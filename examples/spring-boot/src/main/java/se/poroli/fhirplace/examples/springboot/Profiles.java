package se.poroli.fhirplace.examples.springboot;

import java.time.LocalDate;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.observation.Observation;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.validation.Issue;
import se.poroli.fhirplace.r5.validation.Validator;

/**
 * The rules this server applies to incoming resources, on top of the FHIR base rules that fhirplace enforces when it
 * reads a request body. Validators are immutable, so they are plain constants; the handlers call them.
 */
final class Profiles {

    static final String MRN_SYSTEM = "http://example.org/mrn";
    static final String LOINC = "http://loinc.org";
    static final String HEART_RATE = "8867-4";

    /** Every name needs a family name. */
    private static final Validator<HumanName> NAME = Validator.builder(HumanName.class)
            .rule("name-family", name -> name.family() != null,
                    Issue.error(IssueType.REQUIRED, "Family name is required").at("family"))
            .build();

    static final Validator<Patient> PATIENT = Validator.builder(Patient.class)
            .rule("patient-name", patient -> !patient.name().isEmpty(),
                    Issue.error(IssueType.REQUIRED, "A patient must have a name").at("name"))
            .each(Patient::name, "name", NAME)
            .rule("patient-birthdate", patient -> !(patient.birthDate() != null
                            && patient.birthDate().value() instanceof LocalDate born
                            && born.isAfter(LocalDate.now())),
                    Issue.error(IssueType.VALUE, "Birth date cannot be in the future").at("birthDate"))
            .rule("patient-mrn", patient -> patient.identifier().stream()
                            .anyMatch(id -> id.system() != null && MRN_SYSTEM.equals(id.system().value())),
                    Issue.warning(IssueType.REQUIRED, "Patients should have a medical record number")
                            .at("identifier"))
            .build();

    static final Validator<Observation> OBSERVATION = Validator.builder(Observation.class)
            .rule("observation-subject", observation -> observation.subject() != null
                            && observation.subject().reference() != null
                            && observation.subject().reference().value().startsWith("Patient/"),
                    Issue.error(IssueType.REQUIRED, "An observation must be about a patient").at("subject"))
            .rule("heart-rate-unit", observation -> !isHeartRate(observation)
                            || observation.value() instanceof Quantity quantity && quantity.unit() != null
                                    && "beats/minute".equals(quantity.unit().value()),
                    Issue.error(IssueType.VALUE, "A heart rate must be a quantity in beats/minute").at("value"))
            .rule("observation-effective", observation -> observation.effective() != null,
                    Issue.warning(IssueType.REQUIRED, "Observations should say when they were made")
                            .at("effective"))
            .build();

    private Profiles() {
    }

    private static boolean isHeartRate(Observation observation) {
        return observation.code() != null && observation.code().coding().stream()
                .anyMatch(coding -> coding.system() != null && LOINC.equals(coding.system().value())
                        && coding.code() != null && HEART_RATE.equals(coding.code().value()));
    }
}
