package se.poroli.fhirplace.r5.patient;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The type of link between this Patient resource and another Patient/RelatedPerson resource.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/link-type">FHIR R5 LinkType</a>
 */
public enum LinkType implements CodedEnum {

    /** The patient resource containing this link must no longer be used. */
    REPLACED_BY("replaced-by", "Replaced-by"),

    /** The patient resource containing this link is the current active patient record. */
    REPLACES("replaces", "Replaces"),

    /**
     * The patient resource containing this link is in use and valid but not considered the main source of information
     * about a patient.
     */
    REFER("refer", "Refer"),

    /**
     * The patient resource containing this link is in use and valid, but points to another Patient or RelatedPerson
     * resource that is known to contain data about the same person.
     */
    SEEALSO("seealso", "See also");

    private final String code;
    private final String display;

    LinkType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/link-type";
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
    public static LinkType fromCode(String code) {
        for (LinkType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown LinkType code: '" + code + "'");
    }
}
