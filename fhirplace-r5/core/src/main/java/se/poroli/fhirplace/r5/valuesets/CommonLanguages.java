package se.poroli.fhirplace.r5.valuesets;

/**
 * This value set includes common codes from BCP-47 (see http://tools.ietf.org/html/bcp47).
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/languages">FHIR R5 CommonLanguages</a>
 */
public enum CommonLanguages implements CodedEnum {

    /** Arabic. */
    AR("ar", "Arabic"),

    /** Bulgarian. */
    BG("bg", "Bulgarian"),

    /** Bulgarian (Bulgaria). */
    BG_BG("bg-BG", "Bulgarian (Bulgaria)"),

    /** Bengali. */
    BN("bn", "Bengali"),

    /** Czech. */
    CS("cs", "Czech"),

    /** Czech (Czechia). */
    CS_CZ("cs-CZ", "Czech (Czechia)"),

    /** Bosnian. */
    BS("bs", "Bosnian"),

    /** Bosnian (Bosnia and Herzegovina). */
    BS_BA("bs-BA", "Bosnian (Bosnia and Herzegovina)"),

    /** Danish. */
    DA("da", "Danish"),

    /** Danish (Denmark). */
    DA_DK("da-DK", "Danish (Denmark)"),

    /** German. */
    DE("de", "German"),

    /** German (Austria). */
    DE_AT("de-AT", "German (Austria)"),

    /** German (Switzerland). */
    DE_CH("de-CH", "German (Switzerland)"),

    /** German (Germany). */
    DE_DE("de-DE", "German (Germany)"),

    /** Greek. */
    EL("el", "Greek"),

    /** Greek (Greece). */
    EL_GR("el-GR", "Greek (Greece)"),

    /** English. */
    EN("en", "English"),

    /** English (Australia). */
    EN_AU("en-AU", "English (Australia)"),

    /** English (Canada). */
    EN_CA("en-CA", "English (Canada)"),

    /** English (Great Britain). */
    EN_GB("en-GB", "English (Great Britain)"),

    /** English (India). */
    EN_IN("en-IN", "English (India)"),

    /** English (New Zealand). */
    EN_NZ("en-NZ", "English (New Zealand)"),

    /** English (Singapore). */
    EN_SG("en-SG", "English (Singapore)"),

    /** English (United States). */
    EN_US("en-US", "English (United States)"),

    /** Spanish. */
    ES("es", "Spanish"),

    /** Spanish (Argentina). */
    ES_AR("es-AR", "Spanish (Argentina)"),

    /** Spanish (Spain). */
    ES_ES("es-ES", "Spanish (Spain)"),

    /** Spanish (Uruguay). */
    ES_UY("es-UY", "Spanish (Uruguay)"),

    /** Estonian. */
    ET("et", "Estonian"),

    /** Estonian (Estonia). */
    ET_EE("et-EE", "Estonian (Estonia)"),

    /** Finnish. */
    FI("fi", "Finnish"),

    /** French. */
    FR("fr", "French"),

    /** French (Belgium). */
    FR_BE("fr-BE", "French (Belgium)"),

    /** French (Switzerland). */
    FR_CH("fr-CH", "French (Switzerland)"),

    /** French (France). */
    FR_FR("fr-FR", "French (France)"),

    /** Finnish (Finland). */
    FI_FI("fi-FI", "Finnish (Finland)"),

    /** French (Canada). */
    FR_CA("fr-CA", "French (Canada)"),

    /** Frisian. */
    FY("fy", "Frisian"),

    /** Frisian (Netherlands). */
    FY_NL("fy-NL", "Frisian (Netherlands)"),

    /** Hindi. */
    HI("hi", "Hindi"),

    /** Croatian. */
    HR("hr", "Croatian"),

    /** Croatian (Croatia). */
    HR_HR("hr-HR", "Croatian (Croatia)"),

    /** Icelandic. */
    IS("is", "Icelandic"),

    /** Icelandic (Iceland). */
    IS_IS("is-IS", "Icelandic (Iceland)"),

    /** Italian. */
    IT("it", "Italian"),

    /** Italian (Switzerland). */
    IT_CH("it-CH", "Italian (Switzerland)"),

    /** Italian (Italy). */
    IT_IT("it-IT", "Italian (Italy)"),

    /** Japanese. */
    JA("ja", "Japanese"),

    /** Korean. */
    KO("ko", "Korean"),

    /** Lithuanian. */
    LT("lt", "Lithuanian"),

    /** Lithuanian (Lithuania). */
    LT_LT("lt-LT", "Lithuanian (Lithuania)"),

    /** Latvian. */
    LV("lv", "Latvian"),

    /** Latvian (Latvia). */
    LV_LV("lv-LV", "Latvian (Latvia)"),

    /** Dutch. */
    NL("nl", "Dutch"),

    /** Dutch (Belgium). */
    NL_BE("nl-BE", "Dutch (Belgium)"),

    /** Dutch (Netherlands). */
    NL_NL("nl-NL", "Dutch (Netherlands)"),

    /** Norwegian. */
    NO("no", "Norwegian"),

    /** Norwegian (Norway). */
    NO_NO("no-NO", "Norwegian (Norway)"),

    /** Punjabi. */
    PA("pa", "Punjabi"),

    /** Polish. */
    PL("pl", "Polish"),

    /** Polish (Poland). */
    PL_PL("pl-PL", "Polish (Poland)"),

    /** Portuguese. */
    PT("pt", "Portuguese"),

    /** Portuguese (Portugal). */
    PT_PT("pt-PT", "Portuguese (Portugal)"),

    /** Portuguese (Brazil). */
    PT_BR("pt-BR", "Portuguese (Brazil)"),

    /** Romanian. */
    RO("ro", "Romanian"),

    /** Romanian (Romania). */
    RO_RO("ro-RO", "Romanian (Romania)"),

    /** Russian. */
    RU("ru", "Russian"),

    /** Russian (Russia). */
    RU_RU("ru-RU", "Russian (Russia)"),

    /** Slovakian. */
    SK("sk", "Slovakian"),

    /** Slovakian (Slovakia). */
    SK_SK("sk-SK", "Slovakian (Slovakia)"),

    /** Slovenian. */
    SL("sl", "Slovenian"),

    /** Slovenian (Slovenia). */
    SL_SI("sl-SI", "Slovenian (Slovenia)"),

    /** Serbian. */
    SR("sr", "Serbian"),

    /** Serbian (Serbia). */
    SR_RS("sr-RS", "Serbian (Serbia)"),

    /** Swedish. */
    SV("sv", "Swedish"),

    /** Swedish (Sweden). */
    SV_SE("sv-SE", "Swedish (Sweden)"),

    /** Telugu. */
    TE("te", "Telugu"),

    /** Chinese. */
    ZH("zh", "Chinese"),

    /** Chinese (China). */
    ZH_CN("zh-CN", "Chinese (China)"),

    /** Chinese (Hong Kong). */
    ZH_HK("zh-HK", "Chinese (Hong Kong)"),

    /** Chinese (Singapore). */
    ZH_SG("zh-SG", "Chinese (Singapore)"),

    /** Chinese (Taiwan). */
    ZH_TW("zh-TW", "Chinese (Taiwan)");

    private final String code;
    private final String display;

    CommonLanguages(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "urn:ietf:bcp:47";
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
    public static CommonLanguages fromCode(String code) {
        for (CommonLanguages value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CommonLanguages code: '" + code + "'");
    }
}
