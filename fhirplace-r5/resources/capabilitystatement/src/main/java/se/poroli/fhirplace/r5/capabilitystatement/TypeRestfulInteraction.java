package se.poroli.fhirplace.r5.capabilitystatement;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Operations supported by REST at the type or instance level.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/type-restful-interaction">FHIR R5 TypeRestfulInteraction</a>
 */
public enum TypeRestfulInteraction implements CodedEnum {

    /** Read the current state of the resource. */
    READ("read", "read"),

    /** Read the state of a specific version of the resource. */
    VREAD("vread", "vread"),

    /** Update an existing resource by its id (or create it if it is new). */
    UPDATE("update", "update"),

    /** Update an existing resource by posting a set of changes to it. */
    PATCH("patch", "patch"),

    /** Delete a resource. */
    DELETE("delete", "delete"),

    /** Retrieve the change history for a particular resource. */
    HISTORY_INSTANCE("history-instance", "history-instance"),

    /** Retrieve the change history for all resources of a particular type. */
    HISTORY_TYPE("history-type", "history-type"),

    /** Create a new resource with a server assigned id. */
    CREATE("create", "create"),

    /** Search all resources of the specified type based on some filter criteria. */
    SEARCH_TYPE("search-type", "search-type");

    private final String code;
    private final String display;

    TypeRestfulInteraction(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/restful-interaction";
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
    public static TypeRestfulInteraction fromCode(String code) {
        for (TypeRestfulInteraction value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TypeRestfulInteraction code: '" + code + "'");
    }
}
