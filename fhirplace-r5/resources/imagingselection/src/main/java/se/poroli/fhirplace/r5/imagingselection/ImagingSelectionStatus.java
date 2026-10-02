package se.poroli.fhirplace.r5.imagingselection;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The status of the ImagingSelection.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/imagingselection-status">FHIR R5 ImagingSelectionStatus</a>
 */
public enum ImagingSelectionStatus implements CodedEnum {

    /** The selected resources are available.. */
    AVAILABLE("available", "Available"),

    /** The imaging selection has been withdrawn following a release. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The system does not know which of the status values currently applies for this request. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    ImagingSelectionStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/imagingselection-status";
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
    public static ImagingSelectionStatus fromCode(String code) {
        for (ImagingSelectionStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ImagingSelectionStatus code: '" + code + "'");
    }
}
