package se.poroli.fhirplace.r5.codesystem;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The meaning of the hierarchy of concepts in a code system.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/codesystem-hierarchy-meaning">FHIR R5 CodeSystemHierarchyMeaning</a>
 */
public enum CodeSystemHierarchyMeaning implements CodedEnum {

    /**
     * No particular relationship between the concepts can be assumed, except what can be determined by inspection of
     * the definitions of the elements (possible reasons to use this: importing from a source where this is not
     * defined, or where various parts of the hierarchy have different meanings).
     */
    GROUPED_BY("grouped-by", "Grouped By"),

    /**
     * A hierarchy where the child concepts have an IS-A relationship with the parents - that is, all the properties
     * of the parent are also true for its child concepts.
     */
    IS_A("is-a", "Is-A"),

    /** Child elements list the individual parts of a composite whole (e.g. body site). */
    PART_OF("part-of", "Part Of"),

    /**
     * Child concepts in the hierarchy may have only one parent, and there is a presumption that the code system is a
     * "closed world" meaning all things must be in the hierarchy.
     */
    CLASSIFIED_WITH("classified-with", "Classified With");

    private final String code;
    private final String display;

    CodeSystemHierarchyMeaning(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/codesystem-hierarchy-meaning";
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
    public static CodeSystemHierarchyMeaning fromCode(String code) {
        for (CodeSystemHierarchyMeaning value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CodeSystemHierarchyMeaning code: '" + code + "'");
    }
}
