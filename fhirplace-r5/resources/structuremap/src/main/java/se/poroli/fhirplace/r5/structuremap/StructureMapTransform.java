package se.poroli.fhirplace.r5.structuremap;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * How data is copied/created.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/map-transform">FHIR R5 StructureMapTransform</a>
 */
public enum StructureMapTransform implements CodedEnum {

    /**
     * create(type : string) - type is passed through to the application on the standard API, and must be known by it.
     */
    CREATE("create", "create"),

    /** copy(source). */
    COPY("copy", "copy"),

    /** truncate(source, length) - source must be stringy type. */
    TRUNCATE("truncate", "truncate"),

    /** escape(source, fmt1, fmt2) - change source from one kind of escaping to another (plain, java, xml, json). */
    ESCAPE("escape", "escape"),

    /** cast(source, type?) - cast (convert) source from one type to another. */
    CAST("cast", "cast"),

    /** append(source...) - source is element or string. */
    APPEND("append", "append"),

    /** translate(source, uri_of_map) - use the translate operation. */
    TRANSLATE("translate", "translate"),

    /** reference(source : object) - return a string that references the provided tree properly. */
    REFERENCE("reference", "reference"),

    /** Perform a date operation. */
    DATE_OP("dateOp", "dateOp"),

    /** Generate a random UUID (in lowercase). */
    UUID("uuid", "uuid"),

    /** Return the appropriate string to put in a reference that refers to the resource provided as a parameter. */
    POINTER("pointer", "pointer"),

    /** Execute the supplied FHIRPath expression and use the value returned by that. */
    EVALUATE("evaluate", "evaluate"),

    /** Create a CodeableConcept. */
    CC("cc", "cc"),

    /** Create a Coding. */
    C("c", "c"),

    /** Create a quantity. */
    QTY("qty", "qty"),

    /** Create an identifier. */
    ID("id", "id"),

    /** Create a contact details. */
    CP("cp", "cp");

    private final String code;
    private final String display;

    StructureMapTransform(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/map-transform";
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
    public static StructureMapTransform fromCode(String code) {
        for (StructureMapTransform value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown StructureMapTransform code: '" + code + "'");
    }
}
