package se.poroli.fhirplace.r5.client;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.datatypes.Meta;

/**
 * A client for one FHIR server, on the JDK's {@link HttpClient}.
 *
 * <pre>{@code
 * FhirClient fhir = FhirClient.of("https://example.org/fhir");
 * Patient patient = fhir.read(Patient.class, "123").body();
 * fhir.update(patient.toBuilder().active(true).build());          // If-Match from meta.versionId
 * try (Stream<Patient> all = fhir.searchAll(Patient.class, SearchQuery.where("family", "Chalmers"))) { ... }
 * }</pre>
 *
 * <p>A client is an immutable value: the base URL, an {@code HttpClient}, default headers, a format and an optional
 * request timeout. Creating or deriving one ({@link #at(String)}, {@link #withHeader}, {@link #withTimeout}) is
 * cheap, so applications that talk to many servers may create a client per request. The connections, threads and
 * other expensive state belong to the {@code HttpClient}, which is shared: the one passed to
 * {@link #of(String, HttpClient)}, or one default client for the whole application. Clients are thread-safe.
 *
 * <p>To configure HTTP, such as the connect timeout, TLS, proxies or the executor, build the {@code HttpClient} with
 * the JDK's {@link HttpClient#newBuilder()}. The JDK sets the time to wait for a response per request, so set it on the
 * {@code FhirClient} with {@link #withTimeout}. Create one {@code FhirClient} and derive the others from it:
 *
 * <pre>{@code
 * HttpClient http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
 * FhirClient fhir = FhirClient.of("https://a.example/fhir", http)      // configured once, e.g. as a bean
 *         .withTimeout(Duration.ofSeconds(30));
 * fhir.at("https://b.example/fhir").read(Patient.class, "123");       // same HttpClient, headers, format, timeout
 * }</pre>
 *
 * <p>Error statuses raise {@link FhirClientException} with the server's OperationOutcome. Reading FHIR JSON needs a
 * Jakarta JSON Processing implementation, such as Parsson, unless the runtime provides one.
 */
public final class FhirClient {

    private final URI baseUri;
    private final HttpClient http;
    private final Map<String, List<String>> headers;
    private final FhirFormat format;
    private final Duration timeout;

    private FhirClient(URI baseUri, HttpClient http, Map<String, List<String>> headers, FhirFormat format,
            Duration timeout) {
        String base = Objects.requireNonNull(baseUri, "baseUri").toString();
        this.baseUri = URI.create(base.endsWith("/") ? base : base + "/");
        this.http = Objects.requireNonNull(http, "httpClient");
        this.headers = headers;
        this.format = format;
        this.timeout = timeout;
    }

    /** Holds the default HttpClient, created on first use. */
    private static final class DefaultHttpClient {
        static final HttpClient INSTANCE = HttpClient.newHttpClient();
    }

    /**
     * Returns a client for a FHIR server, using the shared default {@code HttpClient}.
     *
     * @param baseUri the FHIR base URL, such as {@code https://example.org/fhir}
     * @return the client
     */
    public static FhirClient of(String baseUri) {
        return of(URI.create(baseUri));
    }

    /**
     * Returns a client for a FHIR server, using the shared default {@code HttpClient}.
     *
     * @param baseUri the FHIR base URL
     * @return the client
     */
    public static FhirClient of(URI baseUri) {
        return of(baseUri, DefaultHttpClient.INSTANCE);
    }

    /**
     * Returns a client for a FHIR server that sends its requests with the given {@code HttpClient}, which carries the
     * application's settings such as the connect timeout, TLS, proxies, redirects and executor.
     *
     * @param baseUri the FHIR base URL, such as {@code https://example.org/fhir}
     * @param httpClient the HTTP client, typically shared by all clients of the application
     * @return the client
     */
    public static FhirClient of(String baseUri, HttpClient httpClient) {
        return of(URI.create(baseUri), httpClient);
    }

    /**
     * Returns a client for a FHIR server that sends its requests with the given {@code HttpClient}, which carries the
     * application's settings such as the connect timeout, TLS, proxies, redirects and executor.
     *
     * @param baseUri the FHIR base URL
     * @param httpClient the HTTP client, typically shared by all clients of the application
     * @return the client
     */
    public static FhirClient of(URI baseUri, HttpClient httpClient) {
        return new FhirClient(baseUri, httpClient, Map.of(), FhirFormat.JSON, null);
    }

    /**
     * Returns a copy for another FHIR server, keeping the HTTP client, headers, format and timeout.
     *
     * @param baseUri the other server's base URL, such as {@code https://b.example/fhir}
     * @return the new client
     */
    public FhirClient at(String baseUri) {
        return at(URI.create(baseUri));
    }

    /**
     * Returns a copy for another FHIR server, keeping the HTTP client, headers, format and timeout.
     *
     * @param baseUri the other server's base URL
     * @return the new client
     */
    public FhirClient at(URI baseUri) {
        return new FhirClient(baseUri, http, headers, format, timeout);
    }

    /**
     * Returns a copy that sends a header with every request, such as {@code Authorization}.
     *
     * @param name the header name
     * @param value the value; added to any values the header already has
     * @return the new client
     */
    public FhirClient withHeader(String name, String value) {
        Map<String, List<String>> copy = new LinkedHashMap<>(headers);
        List<String> values = new ArrayList<>(copy.getOrDefault(Objects.requireNonNull(name, "name"), List.of()));
        values.add(Objects.requireNonNull(value, "value"));
        copy.put(name, List.copyOf(values));
        return new FhirClient(baseUri, http, java.util.Collections.unmodifiableMap(copy), format, timeout);
    }

    /**
     * Returns a copy that sends and asks for the given format; the default is JSON.
     *
     * @param format the format
     * @return the new client
     */
    public FhirClient withFormat(FhirFormat format) {
        return new FhirClient(baseUri, http, headers, Objects.requireNonNull(format, "format"), timeout);
    }

    /**
     * Returns a copy that waits at most the given time for each response; by default, a client waits indefinitely.
     * It applies to every request the client builds, including those from {@link #request(String)} and each page
     * {@link #searchAll} fetches. A request that times out fails with {@link java.net.http.HttpTimeoutException}:
     * wrapped in {@link UncheckedIOException} when sent synchronously, as the cause of the failed future when sent
     * asynchronously.
     *
     * @param timeout the time to wait for a response, positive
     * @return the new client
     * @throws IllegalArgumentException if the timeout is not positive
     */
    public FhirClient withTimeout(Duration timeout) {
        if (Objects.requireNonNull(timeout, "timeout").isNegative() || timeout.isZero()) {
            throw new IllegalArgumentException("Timeout must be positive: " + timeout);
        }
        return new FhirClient(baseUri, http, headers, format, timeout);
    }

    /**
     * Returns the FHIR base URL.
     *
     * @return the base URL, ending with {@code /}
     */
    public URI baseUri() {
        return baseUri;
    }

    /**
     * Returns the HTTP client.
     *
     * @return the HTTP client
     */
    public HttpClient httpClient() {
        return http;
    }

    // ---- interactions -----------------------------------------------------------------------------------------------

    /**
     * Reads the current version of a resource: {@code GET [base]/[type]/[id]}.
     *
     * @param type the resource class
     * @param id the logical id
     * @param <T> the resource type
     * @return the response with the resource
     * @throws FhirClientException for an error status, such as 404 or 410
     */
    public <T extends Resource> FhirClientResponse<T> read(Class<T> type, String id) {
        return send(request(path(type, id)).GET(), type);
    }

    /**
     * Reads the current version of a resource asynchronously.
     *
     * @param type the resource class
     * @param id the logical id
     * @param <T> the resource type
     * @return the response, completing exceptionally with {@link FhirClientException} for an error status
     */
    public <T extends Resource> CompletableFuture<FhirClientResponse<T>> readAsync(Class<T> type, String id) {
        return sendAsync(request(path(type, id)).GET(), type);
    }

    /**
     * Reads a specific version of a resource: {@code GET [base]/[type]/[id]/_history/[vid]}.
     *
     * @param type the resource class
     * @param id the logical id
     * @param versionId the version id
     * @param <T> the resource type
     * @return the response with the resource version
     * @throws FhirClientException for an error status
     */
    public <T extends Resource> FhirClientResponse<T> vread(Class<T> type, String id, String versionId) {
        return send(request(path(type, id) + "/_history/" + encode(versionId)).GET(), type);
    }

    /**
     * Creates a resource: {@code POST [base]/[type]}. The response holds the stored resource, with its new id, and
     * its {@code Location}.
     *
     * @param resource the resource; its id, if any, is ignored by the server
     * @param <T> the resource type
     * @return the response with the stored resource
     * @throws FhirClientException for an error status, such as 400 or 422
     */
    public <T extends Resource> FhirClientResponse<T> create(T resource) {
        return send(createRequest(resource), typeOf(resource));
    }

    /**
     * Creates a resource asynchronously.
     *
     * @param resource the resource
     * @param <T> the resource type
     * @return the response, completing exceptionally with {@link FhirClientException} for an error status
     */
    public <T extends Resource> CompletableFuture<FhirClientResponse<T>> createAsync(T resource) {
        return sendAsync(createRequest(resource), typeOf(resource));
    }

    /**
     * Updates a resource: {@code PUT [base]/[type]/[id]}. If the resource has {@code meta.versionId}, the request
     * carries {@code If-Match} with it, so the server rejects the update (412) when someone else changed the resource
     * in the meantime.
     *
     * @param resource the new content, with its id
     * @param <T> the resource type
     * @return the response with the stored resource
     * @throws IllegalArgumentException if the resource has no id
     * @throws FhirClientException for an error status, such as 412 on a version conflict
     */
    public <T extends Resource> FhirClientResponse<T> update(T resource) {
        return send(updateRequest(resource), typeOf(resource));
    }

    /**
     * Updates a resource asynchronously, with {@code If-Match} as for {@link #update}.
     *
     * @param resource the new content, with its id
     * @param <T> the resource type
     * @return the response, completing exceptionally with {@link FhirClientException} for an error status
     */
    public <T extends Resource> CompletableFuture<FhirClientResponse<T>> updateAsync(T resource) {
        return sendAsync(updateRequest(resource), typeOf(resource));
    }

    /**
     * Deletes a resource: {@code DELETE [base]/[type]/[id]}.
     *
     * @param type the resource class
     * @param id the logical id
     * @return the response; its body is the OperationOutcome the server may send, or {@code null}
     * @throws FhirClientException for an error status
     */
    public FhirClientResponse<Resource> delete(Class<? extends Resource> type, String id) {
        return send(request(path(type, id)).DELETE(), Resource.class);
    }

    /**
     * Searches resources of a type: {@code GET [base]/[type]?[parameters]}. Returns the first page; use
     * {@link #searchAll} to follow the pages.
     *
     * @param type the resource class
     * @param search the search parameters
     * @return the response with the searchset Bundle
     * @throws FhirClientException for an error status, such as 400 for an unknown parameter
     */
    public FhirClientResponse<Bundle> search(Class<? extends Resource> type, SearchQuery search) {
        return send(searchRequest(type, search), Bundle.class);
    }

    /**
     * Searches resources of a type asynchronously, returning the first page.
     *
     * @param type the resource class
     * @param search the search parameters
     * @return the response, completing exceptionally with {@link FhirClientException} for an error status
     */
    public CompletableFuture<FhirClientResponse<Bundle>> searchAsync(Class<? extends Resource> type,
            SearchQuery search) {
        return sendAsync(searchRequest(type, search), Bundle.class);
    }

    /**
     * Searches resources of a type and returns all matches, fetching the pages, starting with the first, as the
     * stream is consumed. Further pages come from the Bundles' {@code next} links, which are followed only on the
     * client's own server (same scheme, host and port), since each request carries the client's headers, such as
     * {@code Authorization}. Included resources and OperationOutcomes are left out.
     *
     * @param type the resource class
     * @param search the search parameters
     * @param <T> the resource type
     * @return the matches; close the stream, for example with try-with-resources, when not consuming it fully
     * @throws FhirClientException for an error status, when the page is fetched
     * @throws IllegalStateException when a {@code next} link points to another server, when the stream reaches it
     */
    public <T extends Resource> Stream<T> searchAll(Class<T> type, SearchQuery search) {
        Iterator<T> matches = new Iterator<>() {
            private Bundle page;
            private Iterator<Bundle.Entry> entries;
            private T next;

            @Override
            public boolean hasNext() {
                if (page == null) {
                    page = search(type, search).body();
                    entries = page.entry().iterator();
                }
                while (next == null) {
                    if (entries.hasNext()) {
                        Bundle.Entry entry = entries.next();
                        boolean match = entry.search() == null || entry.search().mode() == null
                                || "match".equals(entry.search().mode().valueAsString());
                        if (match && type.isInstance(entry.resource())) {
                            next = type.cast(entry.resource());
                        }
                    } else {
                        URI nextPage = nextLink(page);
                        if (nextPage == null) {
                            return false;
                        }
                        page = send(withHeaders(HttpRequest.newBuilder(nextPage)).GET(), Bundle.class).body();
                        entries = page.entry().iterator();
                    }
                }
                return true;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T current = next;
                next = null;
                return current;
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(matches, Spliterator.ORDERED), false);
    }

    /**
     * Returns a request builder for a path below the base URL, with the client's headers, {@code Accept} and timeout,
     * for interactions this class does not cover. Send it with {@link #send(HttpRequest.Builder, Class)}.
     *
     * <pre>{@code
     * Bundle everything = fhir.send(fhir.request("Patient/123/$everything").GET(), Bundle.class).body();
     * }</pre>
     *
     * @param path the path below the base URL, with any query string, URL-encoded
     * @return the builder
     */
    public HttpRequest.Builder request(String path) {
        return withHeaders(HttpRequest.newBuilder(baseUri.resolve(path)));
    }

    /**
     * Sends a request and reads the response body as a resource.
     *
     * @param request the request, typically from {@link #request(String)}
     * @param type the expected resource class; {@code Resource.class} for any
     * @param <T> the resource type
     * @return the response
     * @throws FhirClientException for an error status
     * @throws UncheckedIOException if the request cannot be sent
     */
    public <T extends Resource> FhirClientResponse<T> send(HttpRequest.Builder request, Class<T> type) {
        try {
            HttpResponse<byte[]> response = http.send(request.build(), HttpResponse.BodyHandlers.ofByteArray());
            return toResponse(response, type);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new UncheckedIOException(new java.io.InterruptedIOException(e.getMessage()));
        }
    }

    /**
     * Sends a request asynchronously and reads the response body as a resource.
     *
     * @param request the request, typically from {@link #request(String)}
     * @param type the expected resource class; {@code Resource.class} for any
     * @param <T> the resource type
     * @return the response, completing exceptionally with {@link FhirClientException} for an error status
     */
    public <T extends Resource> CompletableFuture<FhirClientResponse<T>> sendAsync(HttpRequest.Builder request,
            Class<T> type) {
        return http.sendAsync(request.build(), HttpResponse.BodyHandlers.ofByteArray())
                .thenApply(response -> toResponse(response, type))
                .exceptionallyCompose(e -> CompletableFuture.failedFuture(
                        e instanceof CompletionException && e.getCause() != null ? e.getCause() : e));
    }

    // ---- requests ---------------------------------------------------------------------------------------------------

    private HttpRequest.Builder createRequest(Resource resource) {
        return request(encode(resource.getClass().getSimpleName()))
                .header("Content-Type", format.mediaType() + ";charset=UTF-8")
                .header("Prefer", "return=representation")
                .POST(FhirBodyPublishers.of(resource, format));
    }

    private HttpRequest.Builder updateRequest(Resource resource) {
        if (resource.id() == null) {
            throw new IllegalArgumentException("Cannot update a " + resource.getClass().getSimpleName()
                    + " without id");
        }
        HttpRequest.Builder request = request(path(resource.getClass(), resource.id()))
                .header("Content-Type", format.mediaType() + ";charset=UTF-8")
                .header("Prefer", "return=representation")
                .PUT(FhirBodyPublishers.of(resource, format));
        Meta meta = resource.meta();
        if (meta != null && meta.versionId() != null) {
            request.header("If-Match", "W/\"" + meta.versionId().value() + "\"");
        }
        return request;
    }

    private HttpRequest.Builder searchRequest(Class<? extends Resource> type, SearchQuery search) {
        String query = search.toQuery();
        return request(encode(type.getSimpleName()) + (query.isEmpty() ? "" : "?" + query)).GET();
    }

    private HttpRequest.Builder withHeaders(HttpRequest.Builder request) {
        request.header("Accept", format.mediaType());
        if (timeout != null) {
            request.timeout(timeout);
        }
        headers.forEach((name, values) -> values.forEach(value -> request.header(name, value)));
        return request;
    }

    private static String path(Class<? extends Resource> type, String id) {
        return encode(type.getSimpleName()) + "/" + encode(Objects.requireNonNull(id, "id"));
    }

    private static <T extends Resource> FhirClientResponse<T> toResponse(HttpResponse<byte[]> response, Class<T> type) {
        T body = FhirBodyHandlers.read(response.statusCode(), response.headers(), response.body(), type);
        return new FhirClientResponse<>(response.statusCode(), response.headers().map(), body);
    }

    /** Returns the bundle's {@code next} link, resolved against the base URL, if it stays on this server. */
    private URI nextLink(Bundle bundle) {
        URI next = bundle.link().stream()
                .filter(link -> link.relation() != null && "next".equals(link.relation().valueAsString())
                        && link.url() != null)
                .map(link -> baseUri.resolve(link.url().value()))
                .findFirst()
                .orElse(null);
        if (next != null && !sameOrigin(next, baseUri)) {
            throw new IllegalStateException("next link leaves the server: " + next);
        }
        return next;
    }

    private static boolean sameOrigin(URI a, URI b) {
        return a.getScheme() != null && a.getScheme().equalsIgnoreCase(b.getScheme())
                && a.getHost() != null && a.getHost().equalsIgnoreCase(b.getHost())
                && port(a) == port(b);
    }

    private static int port(URI uri) {
        if (uri.getPort() != -1) {
            return uri.getPort();
        }
        return switch (uri.getScheme().toLowerCase(Locale.ROOT)) {
            case "http" -> 80;
            case "https" -> 443;
            default -> -1;
        };
    }

    @SuppressWarnings("unchecked")
    private static <T extends Resource> Class<T> typeOf(T resource) {
        return (Class<T>) resource.getClass();
    }

    private static String encode(String segment) {
        return URLEncoder.encode(segment, StandardCharsets.UTF_8).replace("+", "%20");
    }
}
