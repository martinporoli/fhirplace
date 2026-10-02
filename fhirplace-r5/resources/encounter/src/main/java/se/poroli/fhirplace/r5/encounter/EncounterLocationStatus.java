package se.poroli.fhirplace.r5.encounter;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The status of the location.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/encounter-location-status">FHIR R5 EncounterLocationStatus</a>
 */
public enum EncounterLocationStatus implements CodedEnum {

    /** The patient is planned to be moved to this location at some point in the future. */
    PLANNED("planned", "Planned"),

    /** The patient is currently at this location, or was between the period specified. */
    ACTIVE("active", "Active"),

    /** This location is held empty for this patient. */
    RESERVED("reserved", "Reserved"),

    /** The patient was at this location during the period specified. */
    COMPLETED("completed", "Completed");

    private final String code;
    private final String display;

    EncounterLocationStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/encounter-location-status";
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
    public static EncounterLocationStatus fromCode(String code) {
        for (EncounterLocationStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown EncounterLocationStatus code: '" + code + "'");
    }
}
