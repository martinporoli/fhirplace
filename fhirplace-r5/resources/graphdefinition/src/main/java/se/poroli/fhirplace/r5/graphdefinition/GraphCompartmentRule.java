package se.poroli.fhirplace.r5.graphdefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * How a compartment must be linked.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/graph-compartment-rule">FHIR R5 GraphCompartmentRule</a>
 */
public enum GraphCompartmentRule implements CodedEnum {

    /** The compartment must be identical (the same literal reference). */
    IDENTICAL("identical", "Identical"),

    /**
     * The compartment must be the same - the record must be about the same patient, but the reference may be
     * different.
     */
    MATCHING("matching", "Matching"),

    /** The compartment must be different. */
    DIFFERENT("different", "Different"),

    /** The compartment rule is defined in the accompanying FHIRPath expression. */
    CUSTOM("custom", "Custom");

    private final String code;
    private final String display;

    GraphCompartmentRule(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/graph-compartment-rule";
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
    public static GraphCompartmentRule fromCode(String code) {
        for (GraphCompartmentRule value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown GraphCompartmentRule code: '" + code + "'");
    }
}
