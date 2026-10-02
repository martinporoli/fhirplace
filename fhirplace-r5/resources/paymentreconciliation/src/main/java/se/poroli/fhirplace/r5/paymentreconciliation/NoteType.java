package se.poroli.fhirplace.r5.paymentreconciliation;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The presentation types of notes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/note-type">FHIR R5 NoteType</a>
 */
public enum NoteType implements CodedEnum {

    /** Display the note. */
    DISPLAY("display", "Display"),

    /** Print the note on the form. */
    PRINT("print", "Print (Form)"),

    /** Print the note for the operator. */
    PRINTOPER("printoper", "Print (Operator)");

    private final String code;
    private final String display;

    NoteType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/note-type";
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
    public static NoteType fromCode(String code) {
        for (NoteType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown NoteType code: '" + code + "'");
    }
}
