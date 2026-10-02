package se.poroli.fhirplace.r5.client;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;

/**
 * FHIR search parameters, built immutably and rendered with the correct syntax and escaping.
 *
 * <pre>{@code
 * SearchQuery search = SearchQuery.where("family", "Chalmers")                     // family=Chalmers
 *         .and("given:exact", "Peter", "Pete")                           // given:exact=Peter,Pete (OR)
 *         .and("birthdate", SearchQuery.ge(LocalDate.of(1970, 1, 1)))          // birthdate=ge1970-01-01
 *         .and("birthdate", SearchQuery.lt(LocalDate.of(1980, 1, 1)))          // repeated: AND
 *         .and("identifier", SearchQuery.token("http://acme.org/mrn", "123"))  // identifier=http://acme.org/mrn|123
 *         .count(50);
 * }</pre>
 *
 * <p>Plain values are escaped, so a comma or pipe in a name stays part of it. {@link Value}s from the factory methods
 * are written as they are.
 *
 * @see <a href="https://hl7.org/fhir/R5/search.html">FHIR R5 search</a>
 */
public final class SearchQuery {

    private final List<Parameter> parameters;

    private record Parameter(String name, String value) {
    }

    private SearchQuery(List<Parameter> parameters) {
        this.parameters = List.copyOf(parameters);
    }

    /**
     * Returns a search with no parameters, which matches every resource of the type.
     *
     * @return the search
     */
    public static SearchQuery all() {
        return new SearchQuery(List.of());
    }

    /**
     * Returns a search with one parameter.
     *
     * @param name the parameter name, optionally with modifier, such as {@code family} or {@code family:exact}
     * @param anyOf the values, any of which may match: strings, numbers, dates or {@link Value}s
     * @return the search
     */
    public static SearchQuery where(String name, Object... anyOf) {
        return all().and(name, anyOf);
    }

    /**
     * Returns this search with another parameter. Repeating a parameter name requires all occurrences to match.
     *
     * @param name the parameter name, optionally with modifier
     * @param anyOf the values, any of which may match: strings, numbers, dates or {@link Value}s
     * @return the new search
     */
    public SearchQuery and(String name, Object... anyOf) {
        Objects.requireNonNull(name, "name");
        if (anyOf.length == 0) {
            throw new IllegalArgumentException("Search parameter " + name + " needs at least one value");
        }
        StringJoiner value = new StringJoiner(",");
        for (Object alternative : anyOf) {
            value.add(render(Objects.requireNonNull(alternative, "value")));
        }
        List<Parameter> next = new ArrayList<>(parameters);
        next.add(new Parameter(name, value.toString()));
        return new SearchQuery(next);
    }

    /**
     * Returns this search with {@code _count}, the page size.
     *
     * @param count the maximum number of matches per page
     * @return the new search
     */
    public SearchQuery count(int count) {
        return and("_count", count);
    }

    /**
     * Returns this search with {@code _sort}.
     *
     * @param parameters the parameters to sort by, prefixed with {@code -} for descending order
     * @return the new search
     */
    public SearchQuery sort(String... parameters) {
        return and("_sort", (Object[]) java.util.Arrays.stream(parameters).map(SearchQuery::raw).toArray(Value[]::new));
    }

    /**
     * Returns the search as a URL query string, without {@code ?}.
     *
     * @return the encoded query, empty if there are no parameters
     */
    public String toQuery() {
        StringJoiner query = new StringJoiner("&");
        for (Parameter parameter : parameters) {
            query.add(encode(parameter.name()) + "=" + encode(parameter.value()));
        }
        return query.toString();
    }

    @Override
    public String toString() {
        return toQuery();
    }

    /**
     * A search value written as is, without escaping.
     *
     * @param text the value in FHIR search syntax
     */
    public record Value(String text) {

        /** Creates the value. */
        public Value {
            Objects.requireNonNull(text, "text");
        }
    }

    /**
     * Returns a value written as is, for syntax the other factories do not cover.
     *
     * @param text the value in FHIR search syntax
     * @return the value
     */
    public static Value raw(String text) {
        return new Value(text);
    }

    /**
     * Returns a token value {@code system|code}; a {@code null} system matches the code in any system, a {@code null}
     * code any code in the system.
     *
     * @param system the code system, or {@code null}
     * @param code the code, or {@code null}
     * @return the value
     */
    public static Value token(String system, String code) {
        if (system == null && code == null) {
            throw new IllegalArgumentException("A token needs a system or a code");
        }
        return new Value(system == null ? escape(code) : escape(system) + "|" + (code == null ? "" : escape(code)));
    }

    /**
     * Returns a value with prefix {@code eq}.
     *
     * @param value a date, dateTime or number
     * @return the value
     */
    public static Value eq(Object value) {
        return prefixed("eq", value);
    }

    /**
     * Returns a value with prefix {@code ne}.
     *
     * @param value a date, dateTime or number
     * @return the value
     */
    public static Value ne(Object value) {
        return prefixed("ne", value);
    }

    /**
     * Returns a value with prefix {@code gt}.
     *
     * @param value a date, dateTime or number
     * @return the value
     */
    public static Value gt(Object value) {
        return prefixed("gt", value);
    }

    /**
     * Returns a value with prefix {@code lt}.
     *
     * @param value a date, dateTime or number
     * @return the value
     */
    public static Value lt(Object value) {
        return prefixed("lt", value);
    }

    /**
     * Returns a value with prefix {@code ge}.
     *
     * @param value a date, dateTime or number
     * @return the value
     */
    public static Value ge(Object value) {
        return prefixed("ge", value);
    }

    /**
     * Returns a value with prefix {@code le}.
     *
     * @param value a date, dateTime or number
     * @return the value
     */
    public static Value le(Object value) {
        return prefixed("le", value);
    }

    private static Value prefixed(String prefix, Object value) {
        return new Value(prefix + render(Objects.requireNonNull(value, "value")));
    }

    private static String render(Object value) {
        return switch (value) {
            case Value v -> v.text();
            case String s -> escape(s);
            case BigDecimal d -> d.toPlainString();
            case Number n -> n.toString();
            case FhirDateTime d -> d.valueAsString();
            case LocalDate d -> DateTimeFormatter.ISO_LOCAL_DATE.format(d);
            case OffsetDateTime d -> DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(d);
            case Year y -> y.toString();
            case YearMonth m -> m.toString();
            case Temporal t -> throw new IllegalArgumentException("Unsupported date type " + t.getClass().getName()
                    + "; use LocalDate, OffsetDateTime, Year or YearMonth");
            default -> escape(value.toString());
        };
    }

    /** Escapes the characters with a meaning in FHIR search values. */
    private static String escape(String value) {
        StringBuilder escaped = new StringBuilder(value.length());
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == '\\' || c == ',' || c == '|' || c == '$') {
                escaped.append('\\');
            }
            escaped.append(c);
        }
        return escaped.toString();
    }

    private static String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
    }
}
