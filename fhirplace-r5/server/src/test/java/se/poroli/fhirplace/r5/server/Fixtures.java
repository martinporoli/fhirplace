package se.poroli.fhirplace.r5.server;

import java.time.LocalDate;
import java.util.UUID;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.patient.Patient;

/** Test data shared by the server tests. */
final class Fixtures {

    private Fixtures() {
    }

    /** Returns a family name no other test uses. */
    static String uniqueFamily() {
        return "Fam" + UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }

    static Patient patient(String family) {
        return Patient.builder().addName(HumanName.builder().family(family).addGiven("Pat").build()).build();
    }

    static Patient patient(String family, LocalDate birthDate, String mrn, String practitioner) {
        return patient(family).toBuilder()
                .birthDate(birthDate)
                .addIdentifier(Identifier.builder().system("http://acme.org/mrn").value(mrn).build())
                .addGeneralPractitioner(Reference.builder().reference(practitioner).build())
                .build();
    }

    /** Creates a patient through the API and returns it as stored. */
    static Patient created(Patient patient) {
        TestServer.Reply reply = TestServer.post("Patient", FhirJson.write(patient));
        if (reply.status() != 201) {
            throw new AssertionError("create failed: " + reply.status() + " " + reply.body());
        }
        return FhirJson.read(reply.body(), Patient.class);
    }

    static OperationOutcome outcome(TestServer.Reply reply) {
        return FhirJson.read(reply.body(), OperationOutcome.class);
    }

    static String diagnostics(TestServer.Reply reply) {
        return outcome(reply).issue().getFirst().diagnostics().value();
    }
}
