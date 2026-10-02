package se.poroli.fhirplace.r5.valuesets;

/**
 * The processing mode that applies to this list.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/list-mode">FHIR R5 ListMode</a>
 */
public enum ListMode implements CodedEnum {

    /**
     * This list is the master list, maintained in an ongoing fashion with regular updates as the real-world list it
     * is tracking changes.
     */
    WORKING("working", "Working List"),

    /** This list was prepared as a snapshot. */
    SNAPSHOT("snapshot", "Snapshot List"),

    /** A point-in-time list that shows what changes have been made or recommended. */
    CHANGES("changes", "Change List");

    private final String code;
    private final String display;

    ListMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/list-mode";
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
    public static ListMode fromCode(String code) {
        for (ListMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ListMode code: '" + code + "'");
    }
}
