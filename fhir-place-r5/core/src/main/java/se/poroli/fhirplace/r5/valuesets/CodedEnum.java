package se.poroli.fhirplace.r5.valuesets;

/**
 * A code from a FHIR code system, implemented by the enums of this package.
 *
 * <p>Each enum constant is one code; {@link #code()} is the exact code used on the wire.
 */
public interface CodedEnum {

    /**
     * Returns the canonical URL of the code system defining the code.
     *
     * @return the code system URL, such as {@code http://hl7.org/fhir/administrative-gender}
     */
    String system();

    /**
     * Returns the code as defined by the code system.
     *
     * @return the code, such as {@code female}
     */
    String code();

    /**
     * Returns the human readable display text of the code.
     *
     * @return the display text, such as {@code Female}
     */
    String display();
}
