package se.poroli.fhirplace.r5.valuesets;

/**
 * The days of the week.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/days-of-week">FHIR R5 DaysOfWeek</a>
 */
public enum DaysOfWeek implements CodedEnum {

    /** Monday. */
    MON("mon", "Monday"),

    /** Tuesday. */
    TUE("tue", "Tuesday"),

    /** Wednesday. */
    WED("wed", "Wednesday"),

    /** Thursday. */
    THU("thu", "Thursday"),

    /** Friday. */
    FRI("fri", "Friday"),

    /** Saturday. */
    SAT("sat", "Saturday"),

    /** Sunday. */
    SUN("sun", "Sunday");

    private final String code;
    private final String display;

    DaysOfWeek(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/days-of-week";
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
    public static DaysOfWeek fromCode(String code) {
        for (DaysOfWeek value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DaysOfWeek code: '" + code + "'");
    }
}
