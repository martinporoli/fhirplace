package se.poroli.fhirplace.r5.valuesets;

/**
 * A unit of time (units from UCUM).
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/units-of-time">FHIR R5 UnitsOfTime</a>
 */
public enum UnitsOfTime implements CodedEnum {

    /** second. */
    S("s", "second"),

    /** minute. */
    MIN("min", "minute"),

    /** hour. */
    H("h", "hour"),

    /** day. */
    D("d", "day"),

    /** week. */
    WK("wk", "week"),

    /** month. */
    MO("mo", "month"),

    /** year. */
    A("a", "year");

    private final String code;
    private final String display;

    UnitsOfTime(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://unitsofmeasure.org";
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
    public static UnitsOfTime fromCode(String code) {
        for (UnitsOfTime value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown UnitsOfTime code: '" + code + "'");
    }
}
