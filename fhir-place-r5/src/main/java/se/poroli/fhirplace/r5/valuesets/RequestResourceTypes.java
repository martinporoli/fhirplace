package se.poroli.fhirplace.r5.valuesets;

/**
 * All Resource Types that represent request resources.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/request-resource-types">FHIR R5 RequestResourceTypes</a>
 */
public enum RequestResourceTypes implements CodedEnum {

    /**
     * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a
     * specific date/time.
     */
    APPOINTMENT("Appointment", "Appointment"),

    /**
     * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
     */
    APPOINTMENT_RESPONSE("AppointmentResponse", "AppointmentResponse"),

    /**
     * Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group
     * or community for a period of time, possibly limited to care for a specific condition or set of conditions.
     */
    CARE_PLAN("CarePlan", "CarePlan"),

    /**
     * A provider issued list of professional services and products which have been provided, or are to be provided,
     * to a patient which is sent to an insurer for reimbursement.
     */
    CLAIM("Claim", "Claim"),

    /**
     * A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider,
     * the CDS system proposes that the public health agency be notified about a reportable condition.
     */
    COMMUNICATION_REQUEST("CommunicationRequest", "CommunicationRequest"),

    /**
     * The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to
     * respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage
     * is valid and in-force and optionally to provide the insurance details of the policy.
     */
    COVERAGE_ELIGIBILITY_REQUEST("CoverageEligibilityRequest", "CoverageEligibilityRequest"),

    /** Represents a request a device to be provided to a specific patient. */
    DEVICE_REQUEST("DeviceRequest", "DeviceRequest"),

    /** This resource provides the insurance enrollment details to the insurer regarding a specified coverage. */
    ENROLLMENT_REQUEST("EnrollmentRequest", "EnrollmentRequest"),

    /**
     * A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with
     * optional supporting justification.
     */
    IMMUNIZATION_RECOMMENDATION("ImmunizationRecommendation", "ImmunizationRecommendation"),

    /**
     * An order or request for both supply of the medication and the instructions for administration of the medication
     * to a patient.
     */
    MEDICATION_REQUEST("MedicationRequest", "MedicationRequest"),

    /** A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident. */
    NUTRITION_ORDER("NutritionOrder", "NutritionOrder"),

    /**
     * A set of related requests that can be used to capture intended activities that have inter-dependencies such as
     * "give this medication after that one".
     */
    REQUEST_ORCHESTRATION("RequestOrchestration", "RequestOrchestration"),

    /**
     * A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.
     */
    SERVICE_REQUEST("ServiceRequest", "ServiceRequest"),

    /**
     * A record of a non-patient specific request for a medication, substance, device, certain types of biologically
     * derived product, and nutrition product used in the healthcare setting.
     */
    SUPPLY_REQUEST("SupplyRequest", "SupplyRequest"),

    /** A task to be performed. */
    TASK("Task", "Task"),

    /** Record of transport. */
    TRANSPORT("Transport", "Transport"),

    /** An authorization for the provision of glasses and/or contact lenses to a patient. */
    VISION_PRESCRIPTION("VisionPrescription", "VisionPrescription");

    private final String code;
    private final String display;

    RequestResourceTypes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/fhir-types";
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String display() {
        return display;
    }

    /**
     * Returns the constant for a code.
     *
     * @param code the code, which is case-sensitive
     * @return the constant
     * @throws IllegalArgumentException if the code system does not define the code
     */
    public static RequestResourceTypes fromCode(String code) {
        for (RequestResourceTypes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown RequestResourceTypes code: '" + code + "'");
    }
}
