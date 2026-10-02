package se.poroli.fhirplace.r5.server.internal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.enterprise.inject.Vetoed;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.observation.Observation;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.server.Create;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.Id;
import se.poroli.fhirplace.r5.server.Read;
import se.poroli.fhirplace.r5.server.Search;
import se.poroli.fhirplace.r5.server.SearchParam;

/**
 * Invalid handlers are reported at startup. Deployment fails on the same check, which a server with these handlers
 * would hit; they are vetoed so the shared test server stays deployable.
 */
class HandlerValidationTest {

    @Vetoed
    @FhirResource(Patient.class)
    public static class WrongTypes {
        @Read
        public Optional<Observation> read(@Id String id) {
            return Optional.empty();
        }

        @Create
        public Patient create(Observation observation) {
            return null;
        }

        @Search
        public List<Patient> search(@SearchParam("family") String family) {
            return List.of();
        }
    }

    @Vetoed
    @FhirResource(Patient.class)
    public static class MissingId {
        @Read
        public Patient read(String id) {
            return null;
        }
    }

    @Test
    void reportsEveryProblemOfAHandler() {
        String message = assertThrows(IllegalStateException.class, () -> Handler.inspect(WrongTypes.class))
                .getMessage();

        assertTrue(message.contains("@Read must return T or Optional<T> with T = Patient"), message);
        assertTrue(message.contains("the request body parameter must be a Patient"), message);
        assertTrue(message.contains("a @SearchParam must be StringParam, TokenParam, DateParam or ReferenceParam"),
                message);
    }

    @Test
    void reportsParametersWithoutBinding() {
        String message = assertThrows(IllegalStateException.class, () -> Handler.inspect(MissingId.class))
                .getMessage();

        assertTrue(message.contains("unsupported parameter"), message);
        assertTrue(message.contains("@Read needs exactly one @Id parameter"), message);
    }
}
