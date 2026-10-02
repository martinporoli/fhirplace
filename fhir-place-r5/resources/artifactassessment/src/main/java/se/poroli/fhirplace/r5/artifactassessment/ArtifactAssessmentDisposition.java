package se.poroli.fhirplace.r5.artifactassessment;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Possible values for the disposition of a comment or change request, typically used for comments and change
 * requests, to indicate the disposition of the responsible party towards the changes suggested by the comment or
 * change request.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/artifactassessment-disposition">FHIR R5 ArtifactAssessmentDisposition</a>
 */
public enum ArtifactAssessmentDisposition implements CodedEnum {

    /** The comment is unresolved. */
    UNRESOLVED("unresolved", "Unresolved"),

    /** The comment is not persuasive (rejected in full). */
    NOT_PERSUASIVE("not-persuasive", "Not Persuasive"),

    /** The comment is persuasive (accepted in full). */
    PERSUASIVE("persuasive", "Persuasive"),

    /** The comment is persuasive with modification (partially accepted). */
    PERSUASIVE_WITH_MODIFICATION("persuasive-with-modification", "Persuasive with Modification"),

    /** The comment is not persuasive with modification (partially rejected). */
    NOT_PERSUASIVE_WITH_MODIFICATION("not-persuasive-with-modification", "Not Persuasive with Modification");

    private final String code;
    private final String display;

    ArtifactAssessmentDisposition(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/artifactassessment-disposition";
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
    public static ArtifactAssessmentDisposition fromCode(String code) {
        for (ArtifactAssessmentDisposition value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ArtifactAssessmentDisposition code: '" + code + "'");
    }
}
