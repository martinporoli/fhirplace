package se.poroli.fhirplace.r5.provenance;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * How an entity was used in an activity.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/provenance-entity-role">FHIR R5 ProvenanceEntityRole</a>
 */
public enum ProvenanceEntityRole implements CodedEnum {

    /** An entity that is used by the activity to produce a new version of that entity. */
    REVISION("revision", "Revision"),

    /** An entity that is copied in full or part by an agent that is not the author of the entity. */
    QUOTATION("quotation", "Quotation"),

    /** An entity that is used as input to the activity that produced the target. */
    SOURCE("source", "Source"),

    /**
     * The record resulting from this event adheres to the protocol, guideline, order set or other definition
     * represented by this entity.
     */
    INSTANTIATES("instantiates", "Instantiates"),

    /** An entity that is removed from accessibility, usually through the DELETE operator. */
    REMOVAL("removal", "Removal");

    private final String code;
    private final String display;

    ProvenanceEntityRole(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/provenance-entity-role";
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
    public static ProvenanceEntityRole fromCode(String code) {
        for (ProvenanceEntityRole value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ProvenanceEntityRole code: '" + code + "'");
    }
}
