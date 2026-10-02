package se.poroli.fhirplace.r5.valuesets;

/**
 * Used to distinguish different roles a resource can play within a set of linked resources.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/linkage-type">FHIR R5 LinkageType</a>
 */
public enum LinkageType implements CodedEnum {

    /**
     * The resource represents the "source of truth" (from the perspective of this Linkage resource) for the
     * underlying event/condition/etc.
     */
    SOURCE("source", "Source of Truth"),

    /**
     * The resource represents an alternative view of the underlying event/condition/etc. The resource may still be
     * actively maintained, even though it is not considered to be the source of truth.
     */
    ALTERNATE("alternate", "Alternate Record"),

    /**
     * The resource represents an obsolete record of the underlying event/condition/etc. It is not expected to be
     * actively maintained.
     */
    HISTORICAL("historical", "Historical/Obsolete Record");

    private final String code;
    private final String display;

    LinkageType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/linkage-type";
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
    public static LinkageType fromCode(String code) {
        for (LinkageType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown LinkageType code: '" + code + "'");
    }
}
