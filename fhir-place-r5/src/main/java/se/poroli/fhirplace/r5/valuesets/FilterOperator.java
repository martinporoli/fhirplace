package se.poroli.fhirplace.r5.valuesets;

/**
 * The kind of operation to perform as a part of a property based filter.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/filter-operator">FHIR R5 FilterOperator</a>
 */
public enum FilterOperator implements CodedEnum {

    /** The specified property of the code equals the provided value. */
    EQUALS("=", "Equals"),

    /**
     * Includes all concept ids that have a transitive is-a relationship with the concept Id provided as the value,
     * including the provided concept itself (include descendant codes and self).
     */
    IS_A("is-a", "Is A (by subsumption)"),

    /**
     * Includes all concept ids that have a transitive is-a relationship with the concept Id provided as the value,
     * excluding the provided concept itself (i.e. include descendant codes only).
     */
    DESCENDENT_OF("descendent-of", "Descendent Of (by subsumption)"),

    /** The specified property of the code does not have an is-a relationship with the provided value. */
    IS_NOT_A("is-not-a", "Not (Is A) (by subsumption)"),

    /** The specified property of the code matches the regex specified in the provided value. */
    REGEX("regex", "Regular Expression"),

    /**
     * The specified property of the code is in the set of codes or concepts specified in the provided value
     * (comma-separated list).
     */
    IN("in", "In Set"),

    /**
     * The specified property of the code is not in the set of codes or concepts specified in the provided value
     * (comma-separated list).
     */
    NOT_IN("not-in", "Not in Set"),

    /**
     * Includes all concept ids that have a transitive is-a relationship from the concept Id provided as the value,
     * including the provided concept itself (i.e. include ancestor codes and self).
     */
    GENERALIZES("generalizes", "Generalizes (by Subsumption)"),

    /** Only concepts with a direct hierarchical relationship to the index code and no other concepts. */
    CHILD_OF("child-of", "Child Of"),

    /**
     * Includes concept ids that have a transitive is-a relationship with the concept Id provided as the value, but
     * which do not have any concept ids with transitive is-a relationships with themselves.
     */
    DESCENDENT_LEAF("descendent-leaf", "Descendent Leaf"),

    /**
     * The specified property of the code has at least one value (if the specified value is true; if the specified
     * value is false, then matches when the specified property of the code has no values).
     */
    EXISTS("exists", "Exists");

    private final String code;
    private final String display;

    FilterOperator(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/filter-operator";
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
    public static FilterOperator fromCode(String code) {
        for (FilterOperator value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown FilterOperator code: '" + code + "'");
    }
}
