package se.poroli.fhirplace.r5.guidanceresponse;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The status of a guidance response.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/guidance-response-status">FHIR R5 GuidanceResponseStatus</a>
 */
public enum GuidanceResponseStatus implements CodedEnum {

    /** The request was processed successfully. */
    SUCCESS("success", "Success"),

    /** The request was processed successfully, but more data may result in a more complete evaluation. */
    DATA_REQUESTED("data-requested", "Data Requested"),

    /** The request was processed, but more data is required to complete the evaluation. */
    DATA_REQUIRED("data-required", "Data Required"),

    /** The request is currently being processed. */
    IN_PROGRESS("in-progress", "In Progress"),

    /** The request was not processed successfully. */
    FAILURE("failure", "Failure"),

    /** The response was entered in error. */
    ENTERED_IN_ERROR("entered-in-error", "Entered In Error");

    private final String code;
    private final String display;

    GuidanceResponseStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/guidance-response-status";
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
    public static GuidanceResponseStatus fromCode(String code) {
        for (GuidanceResponseStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown GuidanceResponseStatus code: '" + code + "'");
    }
}
