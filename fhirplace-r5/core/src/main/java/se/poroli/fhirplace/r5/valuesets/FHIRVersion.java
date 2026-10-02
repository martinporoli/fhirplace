package se.poroli.fhirplace.r5.valuesets;

/**
 * All published FHIR Versions.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/FHIR-version">FHIR R5 FHIRVersion</a>
 */
public enum FHIRVersion implements CodedEnum {

    /** Oldest archived version of FHIR. */
    CODE_0_01("0.01", "0.01"),

    /** 1st Draft for Comment (Sept 2012 Ballot). */
    CODE_0_05("0.05", "0.05"),

    /** 2nd Draft for Comment (January 2013 Ballot). */
    CODE_0_06("0.06", "0.06"),

    /** DSTU 1 Ballot version. */
    CODE_0_11("0.11", "0.11"),

    /** DSTU 1 version. */
    CODE_0_0("0.0", "0.0"),

    /** DSTU 1 Official version. */
    CODE_0_0_80("0.0.80", "0.0.80"),

    /** DSTU 1 Official version Technical Errata #1. */
    CODE_0_0_81("0.0.81", "0.0.81"),

    /** DSTU 1 Official version Technical Errata #2. */
    CODE_0_0_82("0.0.82", "0.0.82"),

    /** January 2015 Ballot. */
    CODE_0_4("0.4", "0.4"),

    /** Draft For Comment (January 2015 Ballot). */
    CODE_0_4_0("0.4.0", "0.4.0"),

    /** May 2015 Ballot. */
    CODE_0_5("0.5", "0.5"),

    /** DSTU 2 Ballot version (May 2015 Ballot). */
    CODE_0_5_0("0.5.0", "0.5.0"),

    /** DSTU 2 version. */
    CODE_1_0("1.0", "1.0"),

    /** DSTU 2 QA Preview + CQIF Ballot (Sep 2015). */
    CODE_1_0_0("1.0.0", "1.0.0"),

    /** DSTU 2 (Official version). */
    CODE_1_0_1("1.0.1", "1.0.1"),

    /** DSTU 2 (Official version) with 1 technical errata. */
    CODE_1_0_2("1.0.2", "1.0.2"),

    /** GAO Ballot version. */
    CODE_1_1("1.1", "1.1"),

    /** GAO Ballot + draft changes to main FHIR standard. */
    CODE_1_1_0("1.1.0", "1.1.0"),

    /** Connectathon 12 (Montreal) version. */
    CODE_1_4("1.4", "1.4"),

    /** CQF on FHIR Ballot + Connectathon 12 (Montreal). */
    CODE_1_4_0("1.4.0", "1.4.0"),

    /** Connectathon 13 (Baltimore) version. */
    CODE_1_6("1.6", "1.6"),

    /** FHIR STU3 Ballot + Connectathon 13 (Baltimore). */
    CODE_1_6_0("1.6.0", "1.6.0"),

    /** Connectathon 14 (San Antonio) version. */
    CODE_1_8("1.8", "1.8"),

    /** FHIR STU3 Candidate + Connectathon 14 (San Antonio). */
    CODE_1_8_0("1.8.0", "1.8.0"),

    /** STU3 version. */
    CODE_3_0("3.0", "3.0"),

    /** FHIR Release 3 (STU). */
    CODE_3_0_0("3.0.0", "3.0.0"),

    /** FHIR Release 3 (STU) with 1 technical errata. */
    CODE_3_0_1("3.0.1", "3.0.1"),

    /** FHIR Release 3 (STU) with 2 technical errata. */
    CODE_3_0_2("3.0.2", "3.0.2"),

    /** R4 Ballot #1 version. */
    CODE_3_3("3.3", "3.3"),

    /** R4 Ballot #1 + Connectaton 18 (Cologne). */
    CODE_3_3_0("3.3.0", "3.3.0"),

    /** R4 Ballot #2 version. */
    CODE_3_5("3.5", "3.5"),

    /** R4 Ballot #2 + Connectathon 19 (Baltimore). */
    CODE_3_5_0("3.5.0", "3.5.0"),

    /** R4 version. */
    CODE_4_0("4.0", "4.0"),

    /** FHIR Release 4 (Normative + STU). */
    CODE_4_0_0("4.0.0", "4.0.0"),

    /** FHIR Release 4 (Normative + STU) with 1 technical errata. */
    CODE_4_0_1("4.0.1", "4.0.1"),

    /** R4B Ballot #1 version. */
    CODE_4_1("4.1", "4.1"),

    /** R4B Ballot #1 + Connectathon 27 (Virtual). */
    CODE_4_1_0("4.1.0", "4.1.0"),

    /** R5 Preview #1 version. */
    CODE_4_2("4.2", "4.2"),

    /** R5 Preview #1 + Connectathon 23 (Sydney). */
    CODE_4_2_0("4.2.0", "4.2.0"),

    /** R4B version. */
    CODE_4_3("4.3", "4.3"),

    /** FHIR Release 4B (Normative + STU). */
    CODE_4_3_0("4.3.0", "4.3.0"),

    /** FHIR Release 4B CI-Builld. */
    CODE_4_3_0_CIBUILD("4.3.0-cibuild", "4.3.0-cibuild"),

    /** FHIR Release 4B Snapshot #1. */
    CODE_4_3_0_SNAPSHOT1("4.3.0-snapshot1", "4.3.0-snapshot1"),

    /** R5 Preview #2 version. */
    CODE_4_4("4.4", "4.4"),

    /** R5 Preview #2 + Connectathon 24 (Virtual). */
    CODE_4_4_0("4.4.0", "4.4.0"),

    /** R5 Preview #3 version. */
    CODE_4_5("4.5", "4.5"),

    /** R5 Preview #3 + Connectathon 25 (Virtual). */
    CODE_4_5_0("4.5.0", "4.5.0"),

    /** R5 Draft Ballot version. */
    CODE_4_6("4.6", "4.6"),

    /** R5 Draft Ballot + Connectathon 27 (Virtual). */
    CODE_4_6_0("4.6.0", "4.6.0"),

    /** R5 Versions. */
    CODE_5_0("5.0", "5.0"),

    /** R5 Final Version. */
    CODE_5_0_0("5.0.0", "5.0.0"),

    /** R5 Rolling ci-build. */
    CODE_5_0_0_CIBUILD("5.0.0-cibuild", "5.0.0-cibuild"),

    /** R5 Preview #2. */
    CODE_5_0_0_SNAPSHOT1("5.0.0-snapshot1", "5.0.0-snapshot1"),

    /** R5 Interim tooling stage. */
    CODE_5_0_0_SNAPSHOT2("5.0.0-snapshot2", "5.0.0-snapshot2"),

    /** R5 Ballot. */
    CODE_5_0_0_BALLOT("5.0.0-ballot", "5.0.0-ballot"),

    /** R5 January 2023 Staging Release + Connectathon 32. */
    CODE_5_0_0_SNAPSHOT3("5.0.0-snapshot3", "5.0.0-snapshot3"),

    /** R5 Final QA. */
    CODE_5_0_0_DRAFT_FINAL("5.0.0-draft-final", "5.0.0-draft-final");

    private final String code;
    private final String display;

    FHIRVersion(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/FHIR-version";
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
    public static FHIRVersion fromCode(String code) {
        for (FHIRVersion value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown FHIRVersion code: '" + code + "'");
    }
}
