package se.poroli.fhirplace.r5.datatypes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.PriceComponentType;

/**
 * Availability data for an {item}.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param type base | surcharge | deduction | discount | tax | informational. Required.
 * @param code Codes may be used to differentiate between kinds of taxes, surcharges, discounts etc.
 * @param factor Factor used for calculating this component.
 * @param amount Explicit value amount to be used.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MonetaryComponent">FHIR R5 MonetaryComponent</a>
 */
public record MonetaryComponent(
        String id,
        List<Extension> extension,
        FhirEnum<PriceComponentType> type,
        CodeableConcept code,
        FhirDecimal factor,
        Money amount) implements DataType {

    /**
     * Creates a {@code MonetaryComponent}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public MonetaryComponent {
        extension = extension == null ? List.of() : List.copyOf(extension);
        Objects.requireNonNull(type, "MonetaryComponent.type is required");
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
     * Returns a builder initialized with the values of this {@code MonetaryComponent}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link MonetaryComponent}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirEnum<PriceComponentType> type;
        private CodeableConcept code;
        private FhirDecimal factor;
        private Money amount;

        private Builder() {
        }

        private Builder(MonetaryComponent original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.type = original.type();
            this.code = original.code();
            this.factor = original.factor();
            this.amount = original.amount();
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
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<PriceComponentType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(PriceComponentType type) {
            return type(type == null ? null : FhirEnum.of(type));
        }

        /**
         * Sets {@code code}.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(CodeableConcept code) {
            this.code = code;
            return this;
        }

        /**
         * Sets {@code factor}.
         *
         * @param factor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder factor(FhirDecimal factor) {
            this.factor = factor;
            return this;
        }

        /**
         * Sets {@code factor}, wrapped in a {@link FhirDecimal} without id or extensions.
         *
         * @param factor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder factor(BigDecimal factor) {
            return factor(factor == null ? null : FhirDecimal.of(factor));
        }

        /**
         * Sets {@code amount}.
         *
         * @param amount the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder amount(Money amount) {
            this.amount = amount;
            return this;
        }

        /**
         * Builds the {@code MonetaryComponent}.
         *
         * @return the {@code MonetaryComponent}
         * @throws NullPointerException if a required element is absent
         */
        public MonetaryComponent build() {
            return new MonetaryComponent(
                    id, extension, type, code, factor, amount);
        }
    }
}
