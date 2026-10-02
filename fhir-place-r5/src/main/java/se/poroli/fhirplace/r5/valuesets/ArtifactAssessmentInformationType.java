package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of information contained in a component of an artifact assessment.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/artifactassessment-information-type">FHIR R5 ArtifactAssessmentInformationType</a>
 */
public enum ArtifactAssessmentInformationType implements CodedEnum {

    /** A comment on the artifact. */
    COMMENT("comment", "Comment"),

    /** A classifier of the artifact. */
    CLASSIFIER("classifier", "Classifier"),

    /** A rating of the artifact. */
    RATING("rating", "Rating"),

    /** A container for multiple components. */
    CONTAINER("container", "Container"),

    /** A response to a comment. */
    RESPONSE("response", "Response"),

    /** A change request for the artifact. */
    CHANGE_REQUEST("change-request", "Change Request");

    private final String code;
    private final String display;

    ArtifactAssessmentInformationType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/artifactassessment-information-type";
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
    public static ArtifactAssessmentInformationType fromCode(String code) {
        for (ArtifactAssessmentInformationType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ArtifactAssessmentInformationType code: '" + code + "'");
    }
}
