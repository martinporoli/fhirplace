package se.poroli.fhirplace.r5.datatypes;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A time period defined by a start and end date and optionally time.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param start Starting time with inclusive boundary.
 * @param end End time with inclusive boundary, if not ongoing.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Period">FHIR R5 Period</a>
 */
public record Period(
        String id,
        List<Extension> extension,
        FhirDateTime start,
        FhirDateTime end) implements DataType {

    /**
     * Creates a {@code Period}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Period {
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
     * Returns a builder initialized with the values of this {@code Period}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Period}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirDateTime start;
        private FhirDateTime end;

        private Builder() {
        }

        private Builder(Period original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.start = original.start();
            this.end = original.end();
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
         * Sets {@code start}.
         *
         * @param start the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder start(FhirDateTime start) {
            this.start = start;
            return this;
        }

        /**
         * Sets {@code start}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param start the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder start(Temporal start) {
            return start(start == null ? null : FhirDateTime.of(start));
        }

        /**
         * Sets {@code end}.
         *
         * @param end the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder end(FhirDateTime end) {
            this.end = end;
            return this;
        }

        /**
         * Sets {@code end}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param end the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder end(Temporal end) {
            return end(end == null ? null : FhirDateTime.of(end));
        }

        /**
         * Builds the {@code Period}.
         *
         * @return the {@code Period}
         */
        public Period build() {
            return new Period(
                    id, extension, start, end);
        }
    }
}
