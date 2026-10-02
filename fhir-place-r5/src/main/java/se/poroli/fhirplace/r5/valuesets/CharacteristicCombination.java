package se.poroli.fhirplace.r5.valuesets;

/**
 * Logical grouping of characteristics.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/characteristic-combination">FHIR R5 CharacteristicCombination</a>
 */
public enum CharacteristicCombination implements CodedEnum {

    /** Combine characteristics with AND. */
    ALL_OF("all-of", "All of"),

    /** Combine characteristics with OR. */
    ANY_OF("any-of", "Any of"),

    /** Meet at least the threshold number of characteristics for definition. */
    AT_LEAST("at-least", "At least"),

    /** Meet at most the threshold number of characteristics for definition. */
    AT_MOST("at-most", "At most"),

    /** Combine characteristics statistically. */
    STATISTICAL("statistical", "Statistical"),

    /** Combine characteristics by addition of benefits and subtraction of harms. */
    NET_EFFECT("net-effect", "Net effect"),

    /** Combine characteristics as a collection used as the dataset. */
    DATASET("dataset", "Dataset");

    private final String code;
    private final String display;

    CharacteristicCombination(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/characteristic-combination";
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
    public static CharacteristicCombination fromCode(String code) {
        for (CharacteristicCombination value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CharacteristicCombination code: '" + code + "'");
    }
}
