package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of participant.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/report-participant-type">FHIR R5 TestReportParticipantType</a>
 */
public enum TestReportParticipantType implements CodedEnum {

    /** The test execution engine. */
    TEST_ENGINE("test-engine", "Test Engine"),

    /** A FHIR Client. */
    CLIENT("client", "Client"),

    /** A FHIR Server. */
    SERVER("server", "Server");

    private final String code;
    private final String display;

    TestReportParticipantType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/report-participant-type";
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
    public static TestReportParticipantType fromCode(String code) {
        for (TestReportParticipantType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TestReportParticipantType code: '" + code + "'");
    }
}
