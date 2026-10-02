package se.poroli.fhirplace.r5.specimendefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Degree of preference of a type of conditioned specimen.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/specimen-contained-preference">FHIR R5 SpecimenContainedPreference</a>
 */
public enum SpecimenContainedPreference implements CodedEnum {

    /** This type of contained specimen is preferred to collect this kind of specimen. */
    PREFERRED("preferred", "Preferred"),

    /** This type of conditioned specimen is an alternate. */
    ALTERNATE("alternate", "Alternate");

    private final String code;
    private final String display;

    SpecimenContainedPreference(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/specimen-contained-preference";
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
    public static SpecimenContainedPreference fromCode(String code) {
        for (SpecimenContainedPreference value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SpecimenContainedPreference code: '" + code + "'");
    }
}
