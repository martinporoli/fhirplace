package se.poroli.fhirplace.r5.valuesets;

/**
 * Telecommunications form for contact point.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/contact-point-system">FHIR R5 ContactPointSystem</a>
 */
public enum ContactPointSystem implements CodedEnum {

    /** The value is a telephone number used for voice calls. */
    PHONE("phone", "Phone"),

    /** The value is a fax machine. */
    FAX("fax", "Fax"),

    /** The value is an email address. */
    EMAIL("email", "Email"),

    /** The value is a pager number. */
    PAGER("pager", "Pager"),

    /** A contact that is not a phone, fax, pager or email address and is expressed as a URL. */
    URL("url", "URL"),

    /** A contact that can be used for sending a sms message (e.g. mobile phones, some landlines). */
    SMS("sms", "SMS"),

    /** A contact that is not a phone, fax, page or email address and is not expressible as a URL. */
    OTHER("other", "Other");

    private final String code;
    private final String display;

    ContactPointSystem(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/contact-point-system";
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
    public static ContactPointSystem fromCode(String code) {
        for (ContactPointSystem value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ContactPointSystem code: '" + code + "'");
    }
}
