package se.poroli.fhirplace.r5.imagingstudy;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The status of the ImagingStudy.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/imagingstudy-status">FHIR R5 ImagingStudyStatus</a>
 */
public enum ImagingStudyStatus implements CodedEnum {

    /** The existence of the imaging study is registered, but there is nothing yet available. */
    REGISTERED("registered", "Registered"),

    /** At least one instance has been associated with this imaging study. */
    AVAILABLE("available", "Available"),

    /**
     * The imaging study is unavailable because the imaging study was not started or not completed (also sometimes
     * called "aborted").
     */
    CANCELLED("cancelled", "Cancelled"),

    /** The imaging study has been withdrawn following a previous final release. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The system does not know which of the status values currently applies for this request. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    ImagingStudyStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/imagingstudy-status";
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
    public static ImagingStudyStatus fromCode(String code) {
        for (ImagingStudyStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ImagingStudyStatus code: '" + code + "'");
    }
}
