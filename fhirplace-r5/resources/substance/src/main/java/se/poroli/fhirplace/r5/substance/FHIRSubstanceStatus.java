package se.poroli.fhirplace.r5.substance;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * A code to indicate if the substance is actively used.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/substance-status">FHIR R5 FHIRSubstanceStatus</a>
 */
public enum FHIRSubstanceStatus implements CodedEnum {

    /** The substance is considered for use or reference. */
    ACTIVE("active", "Active"),

    /** The substance is considered for reference, but not for use. */
    INACTIVE("inactive", "Inactive"),

    /** The substance was entered in error. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    FHIRSubstanceStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/substance-status";
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
    public static FHIRSubstanceStatus fromCode(String code) {
        for (FHIRSubstanceStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown FHIRSubstanceStatus code: '" + code + "'");
    }
}
