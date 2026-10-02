package se.poroli.fhirplace.r5.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.server.internal.Engine;

/**
 * A FHIR RESTful server built from handler objects, independent of any web framework. Adapters for Jakarta REST
 * (MicroProfile) and Spring Boot create it from the application's {@link FhirResource} beans and pass each HTTP
 * request below the FHIR base to {@link #handle(FhirRequest)}.
 *
 * <p>The server implements the FHIR HTTP rules: routing, status codes, {@code ETag}, {@code Last-Modified},
 * {@code Location}, {@code Prefer}, conditional requests, content negotiation with {@code _format} and
 * {@code _pretty}, searchset Bundles, OperationOutcome errors and the CapabilityStatement at {@code metadata}.
 * It is immutable and thread-safe; handlers must be thread-safe too.
 *
 * @see <a href="https://hl7.org/fhir/R5/http.html">FHIR R5 RESTful API</a>
 */
public final class FhirServer {

    private final Engine engine;

    private FhirServer(Engine engine) {
        this.engine = engine;
    }

    /**
     * Returns a builder.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Handles one request. FHIR errors, including those thrown by handlers as {@link FhirException}, become
     * responses with an OperationOutcome. Any other exception from a handler is logged through
     * {@link System.Logger} and answered with 500 and an OperationOutcome that does not reveal the exception.
     *
     * @param request the request
     * @return the response
     */
    public FhirResponse handle(FhirRequest request) {
        return engine.handle(Objects.requireNonNull(request, "request"));
    }

    /** Collects handlers and validates them when building the server. */
    public static final class Builder {

        private final List<Object> handlers = new ArrayList<>();

        private Builder() {
        }

        /**
         * Adds a handler: an object whose class, or a superclass for framework proxies, is annotated with
         * {@link FhirResource}.
         *
         * @param handler the handler
         * @return this builder
         */
        public Builder handler(Object handler) {
            handlers.add(Objects.requireNonNull(handler, "handler"));
            return this;
        }

        /**
         * Builds the server.
         *
         * @return the server
         * @throws IllegalStateException listing every problem if a handler is invalid or two handlers serve the
         *     same resource type
         */
        public FhirServer build() {
            return new FhirServer(Engine.create(handlers));
        }
    }
}
