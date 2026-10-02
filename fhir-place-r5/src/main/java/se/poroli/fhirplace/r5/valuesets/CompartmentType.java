package se.poroli.fhirplace.r5.valuesets;

/**
 * Which type a compartment definition describes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/compartment-type">FHIR R5 CompartmentType</a>
 */
public enum CompartmentType implements CodedEnum {

    /** The compartment definition is for the patient compartment. */
    PATIENT("Patient", "Patient"),

    /** The compartment definition is for the encounter compartment. */
    ENCOUNTER("Encounter", "Encounter"),

    /** The compartment definition is for the related-person compartment. */
    RELATED_PERSON("RelatedPerson", "RelatedPerson"),

    /** The compartment definition is for the practitioner compartment. */
    PRACTITIONER("Practitioner", "Practitioner"),

    /** The compartment definition is for the device compartment. */
    DEVICE("Device", "Device"),

    /** The compartment definition is for the episodeofcare compartment. */
    EPISODE_OF_CARE("EpisodeOfCare", "EpisodeOfCare");

    private final String code;
    private final String display;

    CompartmentType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/compartment-type";
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
    public static CompartmentType fromCode(String code) {
        for (CompartmentType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CompartmentType code: '" + code + "'");
    }
}
