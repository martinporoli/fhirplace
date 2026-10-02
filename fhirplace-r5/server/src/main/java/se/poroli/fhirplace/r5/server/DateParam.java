package se.poroli.fhirplace.r5.server;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;

/**
 * One occurrence of a FHIR {@code date} search parameter, such as {@code birthdate=ge1970-01-01} or
 * {@code date=2024-05,2024-06}.
 *
 * @param modifier the modifier after the colon, such as {@code missing}, or {@code null}
 * @param anyOf the comma-separated alternatives; at least one
 * @see <a href="https://hl7.org/fhir/R5/search.html#date">FHIR R5 date search</a>
 */
public record DateParam(String modifier, List<Value> anyOf) {

    /**
     * Creates the parameter, copying the values.
     *
     * @throws IllegalArgumentException if there are no values
     */
    public DateParam {
        anyOf = SearchValues.nonEmpty(anyOf);
    }

    /**
     * One date value with its comparison prefix.
     *
     * @param prefix the comparison, {@link Prefix#EQ} if the value had no prefix
     * @param value the date or dateTime, whose precision defines the range it stands for
     */
    public record Value(Prefix prefix, FhirDateTime value) {

        /**
         * Creates the value.
         *
         * @throws NullPointerException if the prefix or value is {@code null}
         */
        public Value {
            Objects.requireNonNull(prefix, "prefix");
            Objects.requireNonNull(value, "value");
        }
    }

    /** Comparison prefixes of ordered search parameters. */
    public enum Prefix {
        /** Equal: the ranges overlap fully. */
        EQ,
        /** Not equal. */
        NE,
        /** Greater than. */
        GT,
        /** Less than. */
        LT,
        /** Greater or equal. */
        GE,
        /** Less or equal. */
        LE,
        /** Starts after. */
        SA,
        /** Ends before. */
        EB,
        /** Approximately. */
        AP;

        /**
         * Returns the prefix as written in a URL.
         *
         * @return the lower-case code, such as {@code ge}
         */
        public String code() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}
