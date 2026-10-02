package se.poroli.fhirplace.r5.visionprescription;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * A coded concept listing the base codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/vision-base-codes">FHIR R5 VisionBase</a>
 */
public enum VisionBase implements CodedEnum {

    /** top. */
    UP("up", "Up"),

    /** bottom. */
    DOWN("down", "Down"),

    /** inner edge. */
    IN("in", "In"),

    /** outer edge. */
    OUT("out", "Out");

    private final String code;
    private final String display;

    VisionBase(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/vision-base-codes";
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
    public static VisionBase fromCode(String code) {
        for (VisionBase value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown VisionBase code: '" + code + "'");
    }
}
