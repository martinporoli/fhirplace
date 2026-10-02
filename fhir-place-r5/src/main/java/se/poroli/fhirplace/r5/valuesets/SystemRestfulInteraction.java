package se.poroli.fhirplace.r5.valuesets;

/**
 * Operations supported by REST at the system level.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/system-restful-interaction">FHIR R5 SystemRestfulInteraction</a>
 */
public enum SystemRestfulInteraction implements CodedEnum {

    /** Update, create or delete a set of resources as a single transaction. */
    TRANSACTION("transaction", "transaction"),

    /** perform a set of a separate interactions in a single http operation. */
    BATCH("batch", "batch"),

    /** Search all resources based on some filter criteria. */
    SEARCH_SYSTEM("search-system", "search-system"),

    /** Retrieve the change history for all resources on a system. */
    HISTORY_SYSTEM("history-system", "history-system");

    private final String code;
    private final String display;

    SystemRestfulInteraction(String code, String display) {
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
    public static SystemRestfulInteraction fromCode(String code) {
        for (SystemRestfulInteraction value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SystemRestfulInteraction code: '" + code + "'");
    }
}
