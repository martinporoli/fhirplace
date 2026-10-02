package se.poroli.fhirplace.r5.server;

import java.util.Objects;
import se.poroli.fhirplace.r5.Resource;

/**
 * The result of an {@link Update} method that may create the resource: the stored resource and whether it was
 * created, which the server answers with 201 instead of 200.
 *
 * @param resource the stored resource
 * @param created whether the update created the resource
 * @param <T> the resource type
 */
public record Saved<T extends Resource>(T resource, boolean created) {

    /**
     * Creates the result.
     *
     * @throws NullPointerException if the resource is {@code null}
     */
    public Saved {
        Objects.requireNonNull(resource, "resource");
    }

    /**
     * Returns the result of updating an existing resource.
     *
     * @param resource the stored resource
     * @param <T> the resource type
     * @return the result
     */
    public static <T extends Resource> Saved<T> updated(T resource) {
        return new Saved<>(resource, false);
    }

    /**
     * Returns the result of an update that created the resource.
     *
     * @param resource the stored resource
     * @param <T> the resource type
     * @return the result
     */
    public static <T extends Resource> Saved<T> created(T resource) {
        return new Saved<>(resource, true);
    }
}
