package se.poroli.fhirplace.r5.capabilitystatement;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The mode of a message capability statement.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/event-capability-mode">FHIR R5 EventCapabilityMode</a>
 */
public enum EventCapabilityMode implements CodedEnum {

    /** The application sends requests and receives responses. */
    SENDER("sender", "Sender"),

    /** The application receives requests and sends responses. */
    RECEIVER("receiver", "Receiver");

    private final String code;
    private final String display;

    EventCapabilityMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/event-capability-mode";
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
    public static EventCapabilityMode fromCode(String code) {
        for (EventCapabilityMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown EventCapabilityMode code: '" + code + "'");
    }
}
