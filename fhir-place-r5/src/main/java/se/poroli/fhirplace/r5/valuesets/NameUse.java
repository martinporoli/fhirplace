package se.poroli.fhirplace.r5.valuesets;

/**
 * The use of a human name.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/name-use">FHIR R5 NameUse</a>
 */
public enum NameUse implements CodedEnum {

    /** Known as/conventional/the one you normally use. */
    USUAL("usual", "Usual"),

    /**
     * The formal name as registered in an official (government) registry, but which name might not be commonly used.
     */
    OFFICIAL("official", "Official"),

    /** A temporary name. */
    TEMP("temp", "Temp"),

    /**
     * A name that is used to address the person in an informal manner, but is not part of their formal or usual name.
     */
    NICKNAME("nickname", "Nickname"),

    /** Anonymous assigned name, alias, or pseudonym (used to protect a person's identity for privacy reasons). */
    ANONYMOUS("anonymous", "Anonymous"),

    /** This name is no longer in use (or was never correct, but retained for records). */
    OLD("old", "Old"),

    /** A name used prior to changing name because of marriage. */
    MAIDEN("maiden", "Name changed for Marriage");

    private final String code;
    private final String display;

    NameUse(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/name-use";
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
    public static NameUse fromCode(String code) {
        for (NameUse value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown NameUse code: '" + code + "'");
    }
}
