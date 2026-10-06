package se.poroli.fhirplace.examples.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import se.poroli.fhirplace.r5.client.FhirClient;
import se.poroli.fhirplace.r5.client.FhirClientResponse;
import se.poroli.fhirplace.r5.client.SearchQuery;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.rest.FhirHttpException;

/** The proxy in front of two regional backends, each a real FHIR server. */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProxyTest {

    private static final Backend NORTH = Backend.start();
    private static final Backend SOUTH = Backend.start();

    @DynamicPropertySource
    static void backends(DynamicPropertyRegistry properties) {
        properties.add("proxy.backends.north", NORTH.base::toString);
        properties.add("proxy.backends.south", SOUTH.base::toString);
    }

    @Value("${local.server.port}")
    private int port;

    private FhirClient proxy;

    @BeforeEach
    void createClient() {
        proxy = FhirClient.of(URI.create("http://localhost:" + port + "/fhir"));
    }

    private FhirClient north() {
        return proxy.withHeader("X-Region", "north");
    }

    private static Patient patient(String family) {
        return Patient.builder().addName(HumanName.builder().family(family).build()).build();
    }

    private static String unique() {
        return "F" + UUID.randomUUID().toString().substring(0, 8);
    }

    @Test
    void createsInTheRegionsBackend() {
        FhirClientResponse<Patient> created = north().create(patient(unique()));
        String id = created.body().id();

        assertEquals(created.body(), FhirClient.of(NORTH.base).read(Patient.class, id).body());
        assertEquals(404, assertThrows(FhirHttpException.class,
                () -> FhirClient.of(SOUTH.base).read(Patient.class, id)).status());
        assertTrue(created.location().toString().startsWith("http://localhost:" + port + "/fhir/Patient/" + id),
                "Location points to the proxy");
    }

    @Test
    void readsUpdatesAndDeletesThroughTheProxy() {
        Patient patient = north().create(patient(unique())).body();

        Patient updated = north().update(patient.toBuilder().active(true).build()).body();
        assertEquals("2", updated.meta().versionId().value());
        assertEquals(updated, north().read(Patient.class, patient.id()).body());
        assertEquals(412, assertThrows(FhirHttpException.class,
                () -> north().update(patient.toBuilder().active(false).build())).status());   // stale version

        assertEquals(204, north().delete(Patient.class, patient.id()).status());
        assertEquals(404, assertThrows(FhirHttpException.class,
                () -> north().read(Patient.class, patient.id())).status());
    }

    @Test
    void searchesOnlyTheRegionsBackend() {
        String family = unique();
        Patient inNorth = north().create(patient(family)).body();
        proxy.withHeader("X-Region", "south").create(patient(family));

        try (var found = north().searchAll(Patient.class, SearchQuery.where("family", family))) {
            assertEquals(List.of(inNorth.id()), found.map(Patient::id).toList());
        }
    }

    @Test
    void passesBackendErrorsOn() {
        FhirHttpException e = assertThrows(FhirHttpException.class,
                () -> north().read(Patient.class, "missing"));

        assertEquals(404, e.status());
        assertEquals("Patient/missing is not known", e.outcome().issue().getFirst().diagnostics().value());
    }

    @Test
    void forwardsAuthorization() {
        Patient patient = north().create(patient(unique())).body();

        north().withHeader("Authorization", "Bearer secret").read(Patient.class, patient.id());

        assertEquals("Bearer secret", NORTH.patients.lastAuthorization);
    }

    @Test
    void requiresAKnownRegion() {
        FhirHttpException missing = assertThrows(FhirHttpException.class, () -> proxy.create(patient(unique())));
        FhirHttpException unknown = assertThrows(FhirHttpException.class,
                () -> proxy.withHeader("X-Region", "west").create(patient(unique())));

        assertEquals(400, missing.status());
        assertTrue(missing.outcome().issue().getFirst().diagnostics().value().contains("X-Region"));
        assertEquals(400, unknown.status());
    }
}
