package se.poroli.fhirplace.r5.artifactassessment;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Possible values for the workflow status of the comment or assessment, typically used to coordinate workflow around
 * the process of accepting and rejecting changes and comments on the artifact.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/artifactassessment-workflow-status">FHIR R5 ArtifactAssessmentWorkflowStatus</a>
 */
public enum ArtifactAssessmentWorkflowStatus implements CodedEnum {

    /**
     * The comment has been submitted, but the responsible party has not yet been determined, or the responsible party
     * has not yet determined the next steps to be taken.
     */
    SUBMITTED("submitted", "Submitted"),

    /**
     * The comment has been triaged, meaning the responsible party has been determined and next steps have been
     * identified to address the comment.
     */
    TRIAGED("triaged", "Triaged"),

    /** The comment is waiting for input from a specific party before next steps can be taken. */
    WAITING_FOR_INPUT("waiting-for-input", "Waiting for Input"),

    /** The comment has been resolved and no changes resulted from the resolution. */
    RESOLVED_NO_CHANGE("resolved-no-change", "Resolved - No Change"),

    /** The comment has been resolved and changes are required to address the comment. */
    RESOLVED_CHANGE_REQUIRED("resolved-change-required", "Resolved - Change Required"),

    /**
     * The comment is acceptable, but resolution of the comment and application of any associated changes have been
     * deferred.
     */
    DEFERRED("deferred", "Deferred"),

    /** The comment is a duplicate of another comment already received. */
    DUPLICATE("duplicate", "Duplicate"),

    /** The comment is resolved and any necessary changes have been applied. */
    APPLIED("applied", "Applied"),

    /** The necessary changes to the artifact have been published in a new version of the artifact. */
    PUBLISHED("published", "Published"),

    /** The assessment was entered in error. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    ArtifactAssessmentWorkflowStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/artifactassessment-workflow-status";
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
    public static ArtifactAssessmentWorkflowStatus fromCode(String code) {
        for (ArtifactAssessmentWorkflowStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ArtifactAssessmentWorkflowStatus code: '" + code + "'");
    }
}
