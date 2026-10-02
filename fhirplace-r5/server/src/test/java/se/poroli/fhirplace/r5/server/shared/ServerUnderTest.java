package se.poroli.fhirplace.r5.server.shared;

import java.net.URI;

/**
 * Starts the FHIR server that the shared HTTP tests run against. Each runtime module (the plain engine, Jakarta REST,
 * Spring) registers one implementation with {@code META-INF/services}; the tests serve {@link PatientHandler} and
 * {@link ObservationHandler}.
 */
public interface ServerUnderTest {

    /**
     * Starts the server once.
     *
     * @return the absolute URL of the FHIR base, ending with {@code /}
     */
    URI start();
}
