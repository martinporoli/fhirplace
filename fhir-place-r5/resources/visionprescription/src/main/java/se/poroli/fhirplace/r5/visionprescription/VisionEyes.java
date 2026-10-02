package se.poroli.fhirplace.r5.visionprescription;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * A coded concept listing the eye codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/vision-eye-codes">FHIR R5 VisionEyes</a>
 */
public enum VisionEyes implements CodedEnum {

    /** Right Eye. */
    RIGHT("right", "Right Eye"),

    /** Left Eye. */
    LEFT("left", "Left Eye");

    private final String code;
    private final String display;

    VisionEyes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/vision-eye-codes";
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
    public static VisionEyes fromCode(String code) {
        for (VisionEyes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown VisionEyes code: '" + code + "'");
    }
}
