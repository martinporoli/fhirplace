package se.poroli.fhirplace.r5.structuremap;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * How the referenced structure is used in this mapping.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/map-model-mode">FHIR R5 StructureMapModelMode</a>
 */
public enum StructureMapModelMode implements CodedEnum {

    /** This structure describes an instance passed to the mapping engine that is used a source of data. */
    SOURCE("source", "Source Structure Definition"),

    /** This structure describes an instance that the mapping engine may ask for that is used a source of data. */
    QUERIED("queried", "Queried Structure Definition"),

    /** This structure describes an instance passed to the mapping engine that is used a target of data. */
    TARGET("target", "Target Structure Definition"),

    /**
     * This structure describes an instance that the mapping engine may ask to create that is used a target of data.
     */
    PRODUCED("produced", "Produced Structure Definition");

    private final String code;
    private final String display;

    StructureMapModelMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/map-model-mode";
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
    public static StructureMapModelMode fromCode(String code) {
        for (StructureMapModelMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown StructureMapModelMode code: '" + code + "'");
    }
}
