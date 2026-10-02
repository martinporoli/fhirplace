package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A set of ordered Quantities defined by a low and high limit.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param low Low limit.
 * @param high High limit.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Range">FHIR R5 Range</a>
 */
public record Range(
        String id,
        List<Extension> extension,
        Quantity low,
        Quantity high) implements DataType {

    /**
     * Creates a {@code Range}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Range {
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
     * Returns a builder initialized with the values of this {@code Range}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Range}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private Quantity low;
        private Quantity high;

        private Builder() {
        }

        private Builder(Range original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.low = original.low();
            this.high = original.high();
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
         * Sets {@code low}.
         *
         * @param low the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder low(Quantity low) {
            this.low = low;
            return this;
        }

        /**
         * Sets {@code high}.
         *
         * @param high the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder high(Quantity high) {
            this.high = high;
            return this;
        }

        /**
         * Builds the {@code Range}.
         *
         * @return the {@code Range}
         */
        public Range build() {
            return new Range(
                    id, extension, low, high);
        }
    }
}
