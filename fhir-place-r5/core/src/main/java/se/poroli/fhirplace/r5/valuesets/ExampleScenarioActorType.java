package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of actor - system or human.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/examplescenario-actor-type">FHIR R5 ExampleScenarioActorType</a>
 */
public enum ExampleScenarioActorType implements CodedEnum {

    /** A human actor. */
    PERSON("person", "Person"),

    /** A software application or other system. */
    SYSTEM("system", "System");

    private final String code;
    private final String display;

    ExampleScenarioActorType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/examplescenario-actor-type";
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
    public static ExampleScenarioActorType fromCode(String code) {
        for (ExampleScenarioActorType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ExampleScenarioActorType code: '" + code + "'");
    }
}
