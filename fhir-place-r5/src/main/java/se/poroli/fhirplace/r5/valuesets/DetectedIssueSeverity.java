package se.poroli.fhirplace.r5.valuesets;

/**
 * Indicates the potential degree of impact of the identified issue on the patient.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/detectedissue-severity">FHIR R5 DetectedIssueSeverity</a>
 */
public enum DetectedIssueSeverity implements CodedEnum {

    /** Indicates the issue may be life-threatening or has the potential to cause permanent injury. */
    HIGH("high", "High"),

    /**
     * Indicates the issue may result in noticeable adverse consequences but is unlikely to be life-threatening or
     * cause permanent injury.
     */
    MODERATE("moderate", "Moderate"),

    /**
     * Indicates the issue may result in some adverse consequences but is unlikely to substantially affect the
     * situation of the subject.
     */
    LOW("low", "Low");

    private final String code;
    private final String display;

    DetectedIssueSeverity(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/detectedissue-severity";
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
    public static DetectedIssueSeverity fromCode(String code) {
        for (DetectedIssueSeverity value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DetectedIssueSeverity code: '" + code + "'");
    }
}
