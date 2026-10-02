package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Specifies clinical/business/etc. metadata that can be used to retrieve, index and/or categorize an artifact.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param code Type of context being specified. Required.
 * @param value Value that defines the context. One of CodeableConcept, Quantity, Range, Reference. Required.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/UsageContext">FHIR R5 UsageContext</a>
 */
public record UsageContext(
        String id,
        List<Extension> extension,
        Coding code,
        DataType value) implements DataType {

    /**
     * Creates an {@code UsageContext}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public UsageContext {
        extension = extension == null ? List.of() : List.copyOf(extension);
        Objects.requireNonNull(code, "UsageContext.code is required");
        Objects.requireNonNull(value, "UsageContext.value is required");
        if (value != null && !(value instanceof CodeableConcept
                || value instanceof Quantity
                || value instanceof Range
                || value instanceof Reference)) {
            throw new IllegalArgumentException(
                    "UsageContext.value[x] must be one of CodeableConcept, Quantity, Range, Reference, but was "
                            + value.getClass().getSimpleName());
        }
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
     * Returns a builder initialized with the values of this {@code UsageContext}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link UsageContext}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private Coding code;
        private DataType value;

        private Builder() {
        }

        private Builder(UsageContext original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.code = original.code();
            this.value = original.value();
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
         * Sets {@code code}.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(Coding code) {
            this.code = code;
            return this;
        }

        /**
         * Sets {@code value} to a CodeableConcept.
         *
         * @param value the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder value(CodeableConcept value) {
            this.value = value;
            return this;
        }

        /**
         * Sets {@code value} to a Quantity.
         *
         * @param value the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder value(Quantity value) {
            this.value = value;
            return this;
        }

        /**
         * Sets {@code value} to a Range.
         *
         * @param value the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder value(Range value) {
            this.value = value;
            return this;
        }

        /**
         * Sets {@code value} to a Reference.
         *
         * @param value the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder value(Reference value) {
            this.value = value;
            return this;
        }

        /**
         * Builds the {@code UsageContext}.
         *
         * @return the {@code UsageContext}
         * @throws NullPointerException if a required element is absent
         */
        public UsageContext build() {
            return new UsageContext(
                    id, extension, code, value);
        }
    }
}
