package se.poroli.fhirplace.r5.valuesets;

/**
 * Concepts for how a measure report consumer and receiver coordinate data exchange updates.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/submit-data-update-type">FHIR R5 SubmitDataUpdateType</a>
 */
public enum SubmitDataUpdateType implements CodedEnum {

    /**
     * In contrast to the Snapshot Update, the FHIR Parameters resource used in a Submit Data or the Collect Data
     * scenario contains only the new and updated DEQM and QI Core Profiles since the last transaction.
     */
    INCREMENTAL("incremental", "Incremental"),

    /**
     * In contrast to the Incremental Update, the FHIR Parameters resource used in a Submit Data or the Collect Data
     * scenario contains all the DEQM and QI Core Profiles for each transaction.
     */
    SNAPSHOT("snapshot", "Snapshot");

    private final String code;
    private final String display;

    SubmitDataUpdateType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/submit-data-update-type";
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
    public static SubmitDataUpdateType fromCode(String code) {
        for (SubmitDataUpdateType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SubmitDataUpdateType code: '" + code + "'");
    }
}
