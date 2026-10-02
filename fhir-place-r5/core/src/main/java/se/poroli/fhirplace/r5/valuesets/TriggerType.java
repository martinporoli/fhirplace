package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of trigger.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/trigger-type">FHIR R5 TriggerType</a>
 */
public enum TriggerType implements CodedEnum {

    /**
     * The trigger occurs in response to a specific named event, and no other information about the trigger is
     * specified.
     */
    NAMED_EVENT("named-event", "Named Event"),

    /** The trigger occurs at a specific time or periodically as described by a timing or schedule. */
    PERIODIC("periodic", "Periodic"),

    /**
     * The trigger occurs whenever data of a particular type is changed in any way, either added, modified, or
     * removed.
     */
    DATA_CHANGED("data-changed", "Data Changed"),

    /** The trigger occurs whenever data of a particular type is added. */
    DATA_ADDED("data-added", "Data Added"),

    /** The trigger occurs whenever data of a particular type is modified. */
    DATA_MODIFIED("data-modified", "Data Updated"),

    /** The trigger occurs whenever data of a particular type is removed. */
    DATA_REMOVED("data-removed", "Data Removed"),

    /** The trigger occurs whenever data of a particular type is accessed. */
    DATA_ACCESSED("data-accessed", "Data Accessed"),

    /** The trigger occurs whenever access to data of a particular type is completed. */
    DATA_ACCESS_ENDED("data-access-ended", "Data Access Ended");

    private final String code;
    private final String display;

    TriggerType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/trigger-type";
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
    public static TriggerType fromCode(String code) {
        for (TriggerType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TriggerType code: '" + code + "'");
    }
}
