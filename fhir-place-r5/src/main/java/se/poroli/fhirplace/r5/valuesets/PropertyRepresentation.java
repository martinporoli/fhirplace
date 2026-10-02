package se.poroli.fhirplace.r5.valuesets;

/**
 * How a property is represented when serialized.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/property-representation">FHIR R5 PropertyRepresentation</a>
 */
public enum PropertyRepresentation implements CodedEnum {

    /** In XML, this property is represented as an attribute not an element. */
    XML_ATTR("xmlAttr", "XML Attribute"),

    /** This element is represented using the XML text attribute (primitives only). */
    XML_TEXT("xmlText", "XML Text"),

    /** The type of this element is indicated using xsi:type. */
    TYPE_ATTR("typeAttr", "Type Attribute"),

    /** Use CDA narrative instead of XHTML. */
    CDA_TEXT("cdaText", "CDA Text Format"),

    /** The property is represented using XHTML. */
    XHTML("xhtml", "XHTML");

    private final String code;
    private final String display;

    PropertyRepresentation(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/property-representation";
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
    public static PropertyRepresentation fromCode(String code) {
        for (PropertyRepresentation value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown PropertyRepresentation code: '" + code + "'");
    }
}
