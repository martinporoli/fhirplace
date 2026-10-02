package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A relationship of two Quantity values - expressed as a numerator and a denominator.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param numerator Numerator value.
 * @param denominator Denominator value.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Ratio">FHIR R5 Ratio</a>
 */
public record Ratio(
        String id,
        List<Extension> extension,
        Quantity numerator,
        Quantity denominator) implements DataType {

    /**
     * Creates a {@code Ratio}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Ratio {
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
     * Returns a builder initialized with the values of this {@code Ratio}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Ratio}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private Quantity numerator;
        private Quantity denominator;

        private Builder() {
        }

        private Builder(Ratio original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.numerator = original.numerator();
            this.denominator = original.denominator();
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
         * Sets {@code numerator}.
         *
         * @param numerator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder numerator(Quantity numerator) {
            this.numerator = numerator;
            return this;
        }

        /**
         * Sets {@code denominator}.
         *
         * @param denominator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder denominator(Quantity denominator) {
            this.denominator = denominator;
            return this;
        }

        /**
         * Builds the {@code Ratio}.
         *
         * @return the {@code Ratio}
         */
        public Ratio build() {
            return new Ratio(
                    id, extension, numerator, denominator);
        }
    }
}
