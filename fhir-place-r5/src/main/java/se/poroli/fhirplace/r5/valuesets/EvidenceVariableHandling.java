package se.poroli.fhirplace.r5.valuesets;

/**
 * The handling of the variable in statistical analysis for exposures or outcomes (E.g.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/variable-handling">FHIR R5 EvidenceVariableHandling</a>
 */
public enum EvidenceVariableHandling implements CodedEnum {

    /**
     * A continuous variable is one for which, within the limits the variable ranges, any value is possible (from
     * STATO http://purl.obolibrary.org/obo/STATO_0000251).
     */
    CONTINUOUS("continuous", "continuous variable"),

    /**
     * A dichotomous variable is a categorical variable which is defined to have only 2 categories or possible values
     * (from STATO http://purl.obolibrary.org/obo/STATO_0000090).
     */
    DICHOTOMOUS("dichotomous", "dichotomous variable"),

    /**
     * An ordinal variable is a categorical variable where the discrete possible values are ordered or correspond to
     * an implicit ranking (from STATO http://purl.obolibrary.org/obo/STATO_0000228).
     */
    ORDINAL("ordinal", "ordinal variable"),

    /**
     * A polychotomous variable is a categorical variable which is defined to have minimally 2 categories or possible
     * values.
     */
    POLYCHOTOMOUS("polychotomous", "polychotomous variable");

    private final String code;
    private final String display;

    EvidenceVariableHandling(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/variable-handling";
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
    public static EvidenceVariableHandling fromCode(String code) {
        for (EvidenceVariableHandling value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown EvidenceVariableHandling code: '" + code + "'");
    }
}
