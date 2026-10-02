package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A range of ratios expressed as a low and high numerator and a denominator.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param lowNumerator Low Numerator limit.
 * @param highNumerator High Numerator limit.
 * @param denominator Denominator value.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/RatioRange">FHIR R5 RatioRange</a>
 */
public record RatioRange(
        String id,
        List<Extension> extension,
        Quantity lowNumerator,
        Quantity highNumerator,
        Quantity denominator) implements DataType {

    /**
     * Creates a {@code RatioRange}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public RatioRange {
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
     * Returns a builder initialized with the values of this {@code RatioRange}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link RatioRange}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private Quantity lowNumerator;
        private Quantity highNumerator;
        private Quantity denominator;

        private Builder() {
        }

        private Builder(RatioRange original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.lowNumerator = original.lowNumerator();
            this.highNumerator = original.highNumerator();
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
         * Sets {@code lowNumerator}.
         *
         * @param lowNumerator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lowNumerator(Quantity lowNumerator) {
            this.lowNumerator = lowNumerator;
            return this;
        }

        /**
         * Sets {@code highNumerator}.
         *
         * @param highNumerator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder highNumerator(Quantity highNumerator) {
            this.highNumerator = highNumerator;
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
         * Builds the {@code RatioRange}.
         *
         * @return the {@code RatioRange}
         */
        public RatioRange build() {
            return new RatioRange(
                    id, extension, lowNumerator, highNumerator, denominator);
        }
    }
}
