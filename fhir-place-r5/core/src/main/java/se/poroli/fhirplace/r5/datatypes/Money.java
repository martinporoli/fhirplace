package se.poroli.fhirplace.r5.datatypes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An amount of economic utility in some recognized currency.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param value Numerical value (with implicit precision).
 * @param currency ISO 4217 Currency Code.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Money">FHIR R5 Money</a>
 */
public record Money(
        String id,
        List<Extension> extension,
        FhirDecimal value,
        FhirCode currency) implements DataType {

    /**
     * Creates a {@code Money}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Money {
        extension = extension == null ? List.of() : List.copyOf(extension);
    }

    /**
     * Returns a new, empty builder.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns a builder initialized with the values of this {@code Money}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Money}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirDecimal value;
        private FhirCode currency;

        private Builder() {
        }

        private Builder(Money original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.value = original.value();
            this.currency = original.currency();
        }

        /**
         * Sets {@code id}.
         *
         * @param id the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Replaces all {@code extension} values.
         *
         * @param extension the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder extension(List<Extension> extension) {
            this.extension = extension == null ? new ArrayList<>() : new ArrayList<>(extension);
            return this;
        }

        /**
         * Adds a {@code extension} value.
         *
         * @param extension the value to add
         * @return this builder
         */
        public Builder addExtension(Extension extension) {
            this.extension.add(Objects.requireNonNull(extension, "extension"));
            return this;
        }

        /**
         * Sets {@code value}.
         *
         * @param value the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder value(FhirDecimal value) {
            this.value = value;
            return this;
        }

        /**
         * Sets {@code value}, wrapped in a {@link FhirDecimal} without id or extensions.
         *
         * @param value the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder value(BigDecimal value) {
            return value(value == null ? null : FhirDecimal.of(value));
        }

        /**
         * Sets {@code currency}.
         *
         * @param currency the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder currency(FhirCode currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Sets {@code currency}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param currency the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder currency(String currency) {
            return currency(currency == null ? null : FhirCode.of(currency));
        }

        /**
         * Builds the {@code Money}.
         *
         * @return the {@code Money}
         */
        public Money build() {
            return new Money(
                    id, extension, value, currency);
        }
    }
}
