package se.poroli.fhirplace.r5.valuesets;

/**
 * Regulatory Identifier type.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/devicedefinition-regulatory-identifier-type">FHIR R5 DeviceDefinitionRegulatoryIdentifierType</a>
 */
public enum DeviceDefinitionRegulatoryIdentifierType implements CodedEnum {

    /** EUDAMED's basic UDI-DI identifier. */
    BASIC("basic", "Basic"),

    /** EUDAMED's master UDI-DI identifier. */
    MASTER("master", "Master"),

    /** The identifier is a license number. */
    LICENSE("license", "License");

    private final String code;
    private final String display;

    DeviceDefinitionRegulatoryIdentifierType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/devicedefinition-regulatory-identifier-type";
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
    public static DeviceDefinitionRegulatoryIdentifierType fromCode(String code) {
        for (DeviceDefinitionRegulatoryIdentifierType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DeviceDefinitionRegulatoryIdentifierType code: '" + code + "'");
    }
}
