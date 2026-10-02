package se.poroli.fhirplace.r5.server.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.patient.Patient;

/** The search interaction. */
public class SearchTest {

    private static List<String> ids(TestServer.Reply reply) {
        assertEquals(200, reply.status(), reply.body());
        Bundle bundle = FhirJson.read(reply.body(), Bundle.class);
        assertEquals("searchset", bundle.type().valueAsString());
        assertEquals(bundle.entry().size(), bundle.total().value());
        return bundle.entry().stream().map(e -> e.resource().id()).toList();
    }

    @Test
    void searchReturnsASearchsetBundle() {
        String family = Fixtures.uniqueFamily();
        Patient patient = Fixtures.created(Fixtures.patient(family));

        TestServer.Reply reply = TestServer.get("Patient?family=" + family);

        assertEquals(List.of(patient.id()), ids(reply));
        Bundle bundle = FhirJson.read(reply.body(), Bundle.class);
        assertEquals(TestServer.base() + "Patient/" + patient.id(), bundle.entry().getFirst().fullUrl().value());
        assertEquals("match", bundle.entry().getFirst().search().mode().valueAsString());
        assertEquals(TestServer.base() + "Patient?family=" + family, bundle.link().getFirst().url().value());
    }

    @Test
    void commaSeparatedValuesAreAlternatives() {
        String a = Fixtures.uniqueFamily();
        String b = Fixtures.uniqueFamily();
        Patient first = Fixtures.created(Fixtures.patient(a));
        Patient second = Fixtures.created(Fixtures.patient(b));

        assertEquals(List.of(first.id(), second.id()).stream().sorted().toList(),
                ids(TestServer.get("Patient?family=" + a + "," + b)));
    }

    @Test
    void repeatedParametersMustAllMatch() {
        String family = Fixtures.uniqueFamily();
        Patient old = Fixtures.created(Fixtures.patient(family, LocalDate.of(1950, 1, 1), "1", "Practitioner/1"));
        Patient young = Fixtures.created(Fixtures.patient(family, LocalDate.of(2000, 1, 1), "2", "Practitioner/2"));

        assertEquals(List.of(young.id()),
                ids(TestServer.get("Patient?family=" + family + "&birthdate=ge1990-01-01&birthdate=le2010-12-31")));
        assertEquals(List.of(old.id()), ids(TestServer.get("Patient?family=" + family + "&birthdate=lt1990-01-01")));
    }

    @Test
    void tokenAndReferenceParametersAreParsed() {
        String family = Fixtures.uniqueFamily();
        Patient patient = Fixtures.created(Fixtures.patient(family, LocalDate.of(1980, 5, 5), "mrn-7",
                "Practitioner/42"));

        assertEquals(List.of(patient.id()),
                ids(TestServer.get("Patient?identifier=http://acme.org/mrn%7Cmrn-7&family=" + family)));
        assertEquals(List.of(), ids(TestServer.get("Patient?identifier=http://other.org%7Cmrn-7&family=" + family)));
        assertEquals(List.of(patient.id()),
                ids(TestServer.get("Patient?general-practitioner=Practitioner/42&family=" + family)));
    }

    @Test
    void searchCanBePostedAsAForm() {
        String family = Fixtures.uniqueFamily();
        Patient patient = Fixtures.created(Fixtures.patient(family));

        TestServer.Reply reply = TestServer.post("Patient/_search", "family=" + family,
                "Content-Type", "application/x-www-form-urlencoded");

        assertEquals(List.of(patient.id()), ids(reply));
    }

    @Test
    void unknownParametersAreRejectedUnlessLenient() {
        TestServer.Reply strict = TestServer.get("Patient?nickname=x");
        TestServer.Reply lenient = TestServer.get("Patient?nickname=x&family=" + Fixtures.uniqueFamily(),
                "Prefer", "handling=lenient");

        assertEquals(400, strict.status());
        assertTrue(Fixtures.diagnostics(strict).contains("Unknown search parameter 'nickname'"));
        assertEquals(List.of(), ids(lenient));
        assertTrue(FhirJson.read(lenient.body(), Bundle.class).link().getFirst().url().value()
                .contains("family="));
        assertTrue(!FhirJson.read(lenient.body(), Bundle.class).link().getFirst().url().value()
                .contains("nickname"));
    }

    @Test
    void invalidValuesAndRepetitionsAreRejected() {
        assertEquals(400, TestServer.get("Patient?birthdate=yesterday").status());
        assertEquals(400, TestServer.get("Patient?family=a&family=b").status());
        assertEquals(405, TestServer.get("Observation?code=1").status());
    }
}
