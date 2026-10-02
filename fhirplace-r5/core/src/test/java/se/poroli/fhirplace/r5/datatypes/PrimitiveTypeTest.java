package se.poroli.fhirplace.r5.datatypes;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import se.poroli.fhirplace.r5.valuesets.AdministrativeGender;

class PrimitiveTypeTest {

    private static Arguments valid(String type, Function<String, PrimitiveType<?>> parse, String lexical) {
        return Arguments.of(type, parse, lexical);
    }

    private static Arguments invalid(String type, Function<String, ?> factory, String value) {
        return Arguments.of(type, factory, value);
    }

    static Stream<Arguments> validLexicalForms() {
        return Stream.of(
                valid("boolean", FhirBoolean::parse, "true"),
                valid("integer", FhirInteger::parse, "-2147483648"),
                valid("integer64", FhirInteger64::parse, "9223372036854775807"),
                valid("positiveInt", FhirPositiveInt::parse, "1"),
                valid("unsignedInt", FhirUnsignedInt::parse, "0"),
                valid("decimal", FhirDecimal::parse, "1.50"),
                valid("decimal", FhirDecimal::parse, "-0.001"),
                valid("date", FhirDate::parse, "0999"),
                valid("date", FhirDate::parse, "2024-05"),
                valid("date", FhirDate::parse, "2024-02-29"),
                valid("dateTime", FhirDateTime::parse, "2024"),
                valid("dateTime", FhirDateTime::parse, "2024-05-17T13:28:17+02:00"),
                valid("dateTime", FhirDateTime::parse, "2024-05-17T13:28:17.239Z"),
                valid("instant", FhirInstant::parse, "2024-05-17T13:28:17-05:00"),
                valid("time", FhirTime::parse, "00:00:00"),
                valid("time", FhirTime::parse, "23:59:59.5"));
    }

    @ParameterizedTest(name = "{0} \"{2}\"")
    @MethodSource("validLexicalForms")
    void parseRoundTripsTheLexicalForm(String type, Function<String, PrimitiveType<?>> parse, String lexical) {
        assertEquals(lexical, parse.apply(lexical).valueAsString());
    }

    static Stream<Arguments> invalidLexicalForms() {
        return Stream.of(
                invalid("boolean", FhirBoolean::parse, "TRUE"),
                invalid("integer", FhirInteger::parse, "01"),
                invalid("integer", FhirInteger::parse, "2147483648"),
                invalid("positiveInt", FhirPositiveInt::parse, "0"),
                invalid("unsignedInt", FhirUnsignedInt::parse, "-1"),
                invalid("decimal", FhirDecimal::parse, "1."),
                invalid("date", FhirDate::parse, "2023-02-29"),
                invalid("date", FhirDate::parse, "0000"),
                invalid("date", FhirDate::parse, "2024-05-17T13:28:17Z"),
                invalid("dateTime", FhirDateTime::parse, "2024-05-17T13:28:17"),
                invalid("dateTime", FhirDateTime::parse, "2024-05-17T13:28Z"),
                invalid("dateTime", FhirDateTime::parse, "2024-05-17T13:28:17+15:00"),
                invalid("instant", FhirInstant::parse, "2024-05-17"),
                invalid("time", FhirTime::parse, "13:28"),
                invalid("string", FhirString::of, ""),
                invalid("code", FhirCode::of, " leading"),
                invalid("code", FhirCode::of, "two  spaces"),
                invalid("id", FhirId::of, "under_score"),
                invalid("id", FhirId::of, "a".repeat(65)),
                invalid("uri", FhirUri::of, "has space"),
                invalid("oid", FhirOid::of, "1.2.3"),
                invalid("oid", FhirOid::of, "urn:oid:3.1"),
                invalid("uuid", FhirUuid::of, "urn:uuid:C757873D-EC9A-4326-A141-556F43239520"),
                invalid("base64Binary", FhirBase64Binary::of, "abc"));
    }

    @ParameterizedTest(name = "{0} \"{2}\"")
    @MethodSource("invalidLexicalForms")
    void rejectsInvalidValues(String type, Function<String, ?> factory, String value) {
        assertThrows(IllegalArgumentException.class, () -> factory.apply(value));
    }

    @Test
    void acceptsUriBasedIdentifiers() {
        assertEquals("urn:oid:1.2.840.113619", FhirOid.of("urn:oid:1.2.840.113619").value());
        assertEquals("urn:uuid:c757873d-ec9a-4326-a141-556f43239520",
                FhirUuid.of("urn:uuid:c757873d-ec9a-4326-a141-556f43239520").value());
    }

    @Test
    void dateAndDateTimePrecisionIsTheTypeOfTheValue() {
        assertInstanceOf(Year.class, FhirDate.parse("2024").value());
        assertInstanceOf(YearMonth.class, FhirDate.parse("2024-05").value());
        assertInstanceOf(LocalDate.class, FhirDate.parse("2024-05-17").value());
        assertInstanceOf(LocalDate.class, FhirDateTime.parse("2024-05-17").value());
        assertEquals(OffsetDateTime.of(2024, 5, 17, 13, 28, 17, 0, ZoneOffset.ofHours(2)),
                FhirDateTime.parse("2024-05-17T13:28:17+02:00").value());
    }

    @Test
    void dateRejectsTemporalsOfOtherPrecisions() {
        assertThrows(IllegalArgumentException.class, () -> FhirDate.of(LocalTime.NOON));
        assertThrows(IllegalArgumentException.class, () -> FhirDate.of(OffsetDateTime.now()));
        assertThrows(IllegalArgumentException.class, () -> FhirDate.of(Year.of(10_000)));
    }

    @Test
    void decimalKeepsItsPrecision() {
        assertNotEquals(FhirDecimal.parse("1.5"), FhirDecimal.parse("1.50"));
        assertEquals(new BigDecimal("1.50"), FhirDecimal.parse("1.50").value());
    }

    @Test
    void timeAlwaysFormatsSeconds() {
        assertEquals("08:00:00", FhirTime.of(LocalTime.of(8, 0)).valueAsString());
    }

    @Test
    void primitiveRequiresValueOrExtension() {
        assertThrows(IllegalArgumentException.class, () -> new FhirString(null, List.of(), null));
        assertThrows(IllegalArgumentException.class, () -> FhirBoolean.of(null));

        Extension extension = Extension.builder().url("http://example.org/ext").value(FhirBoolean.of(true)).build();
        FhirString withExtensionOnly = new FhirString("s1", List.of(extension), null);

        assertEquals(List.of(extension), withExtensionOnly.extension());
    }

    @Test
    void base64BinaryEncodesAndDecodesBytes() {
        byte[] bytes = "hello".getBytes(StandardCharsets.UTF_8);

        FhirBase64Binary binary = FhirBase64Binary.of(bytes);

        assertEquals("aGVsbG8=", binary.valueAsString());
        assertArrayEquals(bytes, binary.decode());
    }

    @Test
    void enumCodeUsesTheWireCode() {
        FhirEnum<AdministrativeGender> gender = FhirEnum.of(AdministrativeGender.UNKNOWN);

        assertEquals("unknown", gender.valueAsString());
    }

    @Test
    void xhtmlHasNoExtensions() {
        FhirXhtml xhtml = FhirXhtml.of("<div xmlns=\"http://www.w3.org/1999/xhtml\">Hi</div>");

        assertTrue(xhtml.extension().isEmpty());
        assertThrows(IllegalArgumentException.class, () -> FhirXhtml.of(""));
    }
}
