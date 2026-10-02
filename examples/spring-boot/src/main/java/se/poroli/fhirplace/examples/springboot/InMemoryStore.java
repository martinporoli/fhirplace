package se.poroli.fhirplace.examples.springboot;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.server.FhirException;

/**
 * A versioned, in-memory resource store standing in for a database. It assigns ids, and sets {@code meta.versionId}
 * and {@code meta.lastUpdated}, which the fhirplace server turns into {@code ETag}, {@code Last-Modified} and
 * {@code Location} headers.
 *
 * @param <T> the resource type
 */
final class InMemoryStore<T extends Resource> {

    /** Returns a copy of a resource with the given id and meta; resources are immutable records. */
    interface Stamp<T> {
        T apply(T resource, String id, Meta meta);
    }

    private final String type;
    private final Stamp<T> stamp;
    private final Map<String, List<T>> versions = new ConcurrentHashMap<>();
    private final Set<String> deleted = ConcurrentHashMap.newKeySet();
    private final AtomicLong ids = new AtomicLong();

    InMemoryStore(String type, Stamp<T> stamp) {
        this.type = type;
        this.stamp = stamp;
    }

    /** The current version; 410 Gone if deleted. */
    Optional<T> current(String id) {
        if (deleted.contains(id)) {
            throw FhirException.gone(type, id);
        }
        List<T> history = versions.get(id);
        return history == null ? Optional.empty() : Optional.of(history.getLast());
    }

    Optional<T> version(String id, String versionId) {
        return versions.getOrDefault(id, List.of()).stream()
                .filter(resource -> resource.meta().versionId().value().equals(versionId))
                .findFirst();
    }

    /** Stores a new resource under a server-assigned id. */
    T create(T resource) {
        return save(String.valueOf(ids.incrementAndGet()), resource);
    }

    /** Stores a new version, creating the resource if the id is new. */
    T save(String id, T resource) {
        List<T> history = versions.computeIfAbsent(id, key -> new ArrayList<>());
        synchronized (history) {
            T stored = stamp.apply(resource, id, Meta.builder()
                    .versionId(String.valueOf(history.size() + 1))
                    .lastUpdated(OffsetDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS))
                    .build());
            history.add(stored);
            deleted.remove(id);
            return stored;
        }
    }

    boolean exists(String id) {
        return versions.containsKey(id) && !deleted.contains(id);
    }

    void delete(String id) {
        if (!exists(id)) {
            throw FhirException.notFound(type, id);
        }
        deleted.add(id);
    }

    /** The current versions of all resources that are not deleted. */
    Stream<T> all() {
        return versions.entrySet().stream()
                .filter(entry -> !deleted.contains(entry.getKey()))
                .map(entry -> entry.getValue().getLast());
    }
}
