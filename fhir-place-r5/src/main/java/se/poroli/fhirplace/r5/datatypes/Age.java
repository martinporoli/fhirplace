package se.poroli.fhirplace.r5.datatypes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.QuantityComparator;

/**
 * A duration of time during which an organism (or a process) has existed.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param value Numerical value (with implicit precision).
 * @param comparator &lt; | &lt;= | &gt;= | &gt; | ad - how to understand the value. Modifier element.
 * @param unit Unit representation.
 * @param system System that defines coded unit form.
 * @param code Coded form of the unit.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Age">FHIR R5 Age</a>
 */
public record Age(
        String id,
        List<Extension> extension,
        FhirDecimal value,
        FhirEnum<QuantityComparator> comparator,
        FhirString unit,
        FhirUri system,
        FhirCode code) implements DataType {

    /**
     * Creates an {@code Age}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Age {
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
     * Returns a builder initialized with the values of this {@code Age}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Age}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirDecimal value;
        private FhirEnum<QuantityComparator> comparator;
        private FhirString unit;
        private FhirUri system;
        private FhirCode code;

        private Builder() {
        }

        private Builder(Age original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.value = original.value();
            this.comparator = original.comparator();
            this.unit = original.unit();
            this.system = original.system();
            this.code = original.code();
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
         * Sets {@code comparator}.
         *
         * @param comparator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comparator(FhirEnum<QuantityComparator> comparator) {
            this.comparator = comparator;
            return this;
        }

        /**
         * Sets {@code comparator}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param comparator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comparator(QuantityComparator comparator) {
            return comparator(comparator == null ? null : FhirEnum.of(comparator));
        }

        /**
         * Sets {@code unit}.
         *
         * @param unit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder unit(FhirString unit) {
            this.unit = unit;
            return this;
        }

        /**
         * Sets {@code unit}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param unit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder unit(String unit) {
            return unit(unit == null ? null : FhirString.of(unit));
        }

        /**
         * Sets {@code system}.
         *
         * @param system the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder system(FhirUri system) {
            this.system = system;
            return this;
        }

        /**
         * Sets {@code system}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param system the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder system(String system) {
            return system(system == null ? null : FhirUri.of(system));
        }

        /**
         * Sets {@code code}.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(FhirCode code) {
            this.code = code;
            return this;
        }

        /**
         * Sets {@code code}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(String code) {
            return code(code == null ? null : FhirCode.of(code));
        }

        /**
         * Builds the {@code Age}.
         *
         * @return the {@code Age}
         */
        public Age build() {
            return new Age(
                    id, extension, value, comparator, unit, system, code);
        }
    }
}
