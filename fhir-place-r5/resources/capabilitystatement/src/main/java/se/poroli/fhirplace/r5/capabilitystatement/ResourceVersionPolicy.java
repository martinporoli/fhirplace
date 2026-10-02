package se.poroli.fhirplace.r5.capabilitystatement;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * How the system supports versioning for a resource.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/versioning-policy">FHIR R5 ResourceVersionPolicy</a>
 */
public enum ResourceVersionPolicy implements CodedEnum {

    /** VersionId meta-property is not supported (server) or used (client). */
    NO_VERSION("no-version", "No VersionId Support"),

    /** VersionId meta-property is supported (server) or used (client). */
    VERSIONED("versioned", "Versioned"),

    /** Supports version-aware updates (server) or will be specified (If-match header) for updates (client). */
    VERSIONED_UPDATE("versioned-update", "VersionId tracked fully");

    private final String code;
    private final String display;

    ResourceVersionPolicy(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/versioning-policy";
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
    public static ResourceVersionPolicy fromCode(String code) {
        for (ResourceVersionPolicy value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ResourceVersionPolicy code: '" + code + "'");
    }
}
