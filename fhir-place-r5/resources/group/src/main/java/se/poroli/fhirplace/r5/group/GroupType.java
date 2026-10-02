package se.poroli.fhirplace.r5.group;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Types of resources that are part of group.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/group-type">FHIR R5 GroupType</a>
 */
public enum GroupType implements CodedEnum {

    /** Group contains "person" Patient resources. */
    PERSON("person", "Person"),

    /** Group contains "animal" Patient resources. */
    ANIMAL("animal", "Animal"),

    /** Group contains healthcare practitioner resources (Practitioner or PractitionerRole). */
    PRACTITIONER("practitioner", "Practitioner"),

    /** Group contains Device resources. */
    DEVICE("device", "Device"),

    /** Group contains CareTeam resources. */
    CARETEAM("careteam", "CareTeam"),

    /** Group contains HealthcareService resources. */
    HEALTHCARESERVICE("healthcareservice", "HealthcareService"),

    /** Group contains Location resources. */
    LOCATION("location", "Location"),

    /** Group contains Organization resources. */
    ORGANIZATION("organization", "Organization"),

    /** Group contains RelatedPerson resources. */
    RELATEDPERSON("relatedperson", "RelatedPerson"),

    /** Group contains Specimen resources. */
    SPECIMEN("specimen", "Specimen");

    private final String code;
    private final String display;

    GroupType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/group-type";
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
    public static GroupType fromCode(String code) {
        for (GroupType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown GroupType code: '" + code + "'");
    }
}
