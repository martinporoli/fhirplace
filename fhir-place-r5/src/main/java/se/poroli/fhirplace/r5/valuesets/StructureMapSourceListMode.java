package se.poroli.fhirplace.r5.valuesets;

/**
 * If field is a list, how to manage the source.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/map-source-list-mode">FHIR R5 StructureMapSourceListMode</a>
 */
public enum StructureMapSourceListMode implements CodedEnum {

    /** Only process this rule for the first in the list. */
    FIRST("first", "First"),

    /** Process this rule for all but the first. */
    NOT_FIRST("not_first", "All but the first"),

    /** Only process this rule for the last in the list. */
    LAST("last", "Last"),

    /** Process this rule for all but the last. */
    NOT_LAST("not_last", "All but the last"),

    /** Only process this rule is there is only item. */
    ONLY_ONE("only_one", "Enforce only one");

    private final String code;
    private final String display;

    StructureMapSourceListMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/map-source-list-mode";
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
    public static StructureMapSourceListMode fromCode(String code) {
        for (StructureMapSourceListMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown StructureMapSourceListMode code: '" + code + "'");
    }
}
