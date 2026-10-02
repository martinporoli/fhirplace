package se.poroli.fhirplace.r5.molecularsequence;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Type if a sequence -- DNA, RNA, or amino acid sequence.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/sequence-type">FHIR R5 SequenceType</a>
 */
public enum SequenceType implements CodedEnum {

    /** Amino acid sequence. */
    AA("aa", "AA Sequence"),

    /** DNA Sequence. */
    DNA("dna", "DNA Sequence"),

    /** RNA Sequence. */
    RNA("rna", "RNA Sequence");

    private final String code;
    private final String display;

    SequenceType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/sequence-type";
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
    public static SequenceType fromCode(String code) {
        for (SequenceType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SequenceType code: '" + code + "'");
    }
}
