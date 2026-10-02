package se.poroli.fhirplace.r5.structuremap;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * If this is the default rule set to apply for the source type, or this combination of types.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/map-group-type-mode">FHIR R5 StructureMapGroupTypeMode</a>
 */
public enum StructureMapGroupTypeMode implements CodedEnum {

    /** This group is a default mapping group for the specified types and for the primary source type. */
    TYPES("types", "Default for Type Combination"),

    /** This group is a default mapping group for the specified types. */
    TYPE_AND_TYPES("type-and-types", "Default for type + combination");

    private final String code;
    private final String display;

    StructureMapGroupTypeMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/map-group-type-mode";
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
    public static StructureMapGroupTypeMode fromCode(String code) {
        for (StructureMapGroupTypeMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown StructureMapGroupTypeMode code: '" + code + "'");
    }
}
