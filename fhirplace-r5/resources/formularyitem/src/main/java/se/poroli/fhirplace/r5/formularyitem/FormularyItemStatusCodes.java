package se.poroli.fhirplace.r5.formularyitem;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * FormularyItem Status Codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/formularyitem-status">FHIR R5 FormularyItemStatusCodes</a>
 */
public enum FormularyItemStatusCodes implements CodedEnum {

    /**
     * The service or product referred to by this FormularyItem is in active use within the drug database or inventory
     * system.
     */
    ACTIVE("active", "Active"),

    /**
     * The service or product referred to by this FormularyItem was entered in error within the drug database or
     * inventory system.
     */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /**
     * The service or product referred to by this FormularyItem is not in active use within the drug database or
     * inventory system.
     */
    INACTIVE("inactive", "Inactive");

    private final String code;
    private final String display;

    FormularyItemStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/formularyitem-status";
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
    public static FormularyItemStatusCodes fromCode(String code) {
        for (FormularyItemStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown FormularyItemStatusCodes code: '" + code + "'");
    }
}
