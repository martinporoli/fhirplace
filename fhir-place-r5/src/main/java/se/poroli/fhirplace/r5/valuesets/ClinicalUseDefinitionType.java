package se.poroli.fhirplace.r5.valuesets;

/**
 * Overall defining type of this clinical use definition.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/clinical-use-definition-type">FHIR R5 ClinicalUseDefinitionType</a>
 */
public enum ClinicalUseDefinitionType implements CodedEnum {

    /** A reason for giving the medication. */
    INDICATION("indication", "Indication"),

    /** A reason for not giving the medication. */
    CONTRAINDICATION("contraindication", "Contraindication"),

    /** Interactions between the medication and other substances. */
    INTERACTION("interaction", "Interaction"),

    /** Side effects or adverse effects associated with the medication. */
    UNDESIRABLE_EFFECT("undesirable-effect", "Undesirable Effect"),

    /** A general warning or issue that is not specifically one of the other types. */
    WARNING("warning", "Warning");

    private final String code;
    private final String display;

    ClinicalUseDefinitionType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/clinical-use-definition-type";
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
    public static ClinicalUseDefinitionType fromCode(String code) {
        for (ClinicalUseDefinitionType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ClinicalUseDefinitionType code: '" + code + "'");
    }
}
