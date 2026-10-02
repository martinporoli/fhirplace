package se.poroli.fhirplace.r5.graphdefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Defines how a compartment rule is used.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/graph-compartment-use">FHIR R5 GraphCompartmentUse</a>
 */
public enum GraphCompartmentUse implements CodedEnum {

    /** This compartment rule is a condition for whether the rule applies. */
    WHERE("where", "Where"),

    /** This compartment rule is enforced on any relationships that meet the conditions. */
    REQUIRES("requires", "requires");

    private final String code;
    private final String display;

    GraphCompartmentUse(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/graph-compartment-use";
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
    public static GraphCompartmentUse fromCode(String code) {
        for (GraphCompartmentUse value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown GraphCompartmentUse code: '" + code + "'");
    }
}
