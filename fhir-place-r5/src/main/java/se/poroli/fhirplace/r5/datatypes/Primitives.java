package se.poroli.fhirplace.r5.datatypes;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.regex.Pattern;

/** Validation and formatting shared by the primitive datatypes. */
final class Primitives {

    private static final Pattern PARTIAL_DATE =
            Pattern.compile("[0-9]{4}(-(0[1-9]|1[0-2])(-(0[1-9]|[12][0-9]|3[01]))?)?");
    private static final Pattern DATE_TIME = Pattern.compile(
            "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])"
                    + "T([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.[0-9]{1,9})?"
                    + "(Z|[+-]((0[0-9]|1[0-3]):[0-5][0-9]|14:00))");
    private static final int MAX_OFFSET_SECONDS = 14 * 60 * 60;

    private Primitives() {
    }

    /** Copies the extensions and enforces that a primitive has a value or at least one extension (ele-1). */
    static List<Extension> extensions(List<Extension> extension, Object value) {
        List<Extension> copy = extension == null ? List.of() : List.copyOf(extension);
        if (value == null && copy.isEmpty()) {
            throw new IllegalArgumentException("A primitive must have a value or at least one extension");
        }
        return copy;
    }

    /** Returns {@code value} if it is {@code null} or matches {@code pattern}, otherwise throws. */
    static String requireMatch(String type, String value, Pattern pattern) {
        if (value != null && !pattern.matcher(value).matches()) {
            throw invalid(type, value);
        }
        return value;
    }

    static IllegalArgumentException invalid(String type, Object value) {
        return new IllegalArgumentException("Invalid FHIR " + type + ": '" + value + "'");
    }

    /** Requires a {@link Year}, {@link YearMonth} or {@link LocalDate} within the years 1 to 9999. */
    static void checkPartialDate(String type, Temporal value) {
        int year = switch (value) {
            case Year y -> y.getValue();
            case YearMonth ym -> ym.getYear();
            case LocalDate d -> d.getYear();
            default -> throw new IllegalArgumentException("A FHIR " + type
                    + " must be a Year, YearMonth or LocalDate, but was " + value.getClass().getName());
        };
        checkYear(type, value, year);
    }

    /** Requires a year within 1 to 9999 and a UTC offset within -14:00 to +14:00. */
    static void checkDateTime(String type, OffsetDateTime value) {
        checkYear(type, value, value.getYear());
        if (Math.abs(value.getOffset().getTotalSeconds()) > MAX_OFFSET_SECONDS) {
            throw invalid(type, value);
        }
    }

    private static void checkYear(String type, Temporal value, int year) {
        if (year < 1 || year > 9999) {
            throw invalid(type, value);
        }
    }

    static boolean isPartialDate(String value) {
        return PARTIAL_DATE.matcher(value).matches();
    }

    static Temporal parsePartialDate(String type, String value) {
        if (!isPartialDate(value)) {
            throw invalid(type, value);
        }
        try {
            return switch (value.length()) {
                case 4 -> Year.parse(value);
                case 7 -> YearMonth.parse(value);
                default -> LocalDate.parse(value);
            };
        } catch (DateTimeParseException e) {
            throw invalid(type, value);
        }
    }

    static OffsetDateTime parseDateTime(String type, String value) {
        if (!DATE_TIME.matcher(value).matches()) {
            throw invalid(type, value);
        }
        try {
            return OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeParseException e) {
            throw invalid(type, value);
        }
    }

    static String formatPartialDate(Temporal value) {
        return switch (value) {
            case Year y -> "%04d".formatted(y.getValue());
            case YearMonth ym -> "%04d-%02d".formatted(ym.getYear(), ym.getMonthValue());
            case LocalDate d -> DateTimeFormatter.ISO_LOCAL_DATE.format(d);
            default -> throw new IllegalStateException("Unexpected partial date " + value);
        };
    }

    static String formatDateTime(OffsetDateTime value) {
        return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(value);
    }
}
