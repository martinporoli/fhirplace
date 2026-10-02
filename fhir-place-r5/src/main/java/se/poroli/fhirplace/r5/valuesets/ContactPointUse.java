package se.poroli.fhirplace.r5.valuesets;

/**
 * Use of contact point.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/contact-point-use">FHIR R5 ContactPointUse</a>
 */
public enum ContactPointUse implements CodedEnum {

    /**
     * A communication contact point at a home; attempted contacts for business purposes might intrude privacy and
     * chances are one will contact family or other household members instead of the person one wishes to call.
     */
    HOME("home", "Home"),

    /** An office contact point. */
    WORK("work", "Work"),

    /** A temporary contact point. */
    TEMP("temp", "Temp"),

    /** This contact point is no longer in use (or was never correct, but retained for records). */
    OLD("old", "Old"),

    /** A telecommunication device that moves and stays with its owner. */
    MOBILE("mobile", "Mobile");

    private final String code;
    private final String display;

    ContactPointUse(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/contact-point-use";
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
    public static ContactPointUse fromCode(String code) {
        for (ContactPointUse value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ContactPointUse code: '" + code + "'");
    }
}
