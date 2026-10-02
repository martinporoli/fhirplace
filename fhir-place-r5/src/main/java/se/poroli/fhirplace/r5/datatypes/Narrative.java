package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/**
 * A human-readable summary of the resource conveying the essential clinical and business information for the
 * resource.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param status generated | extensions | additional | empty. Required.
 * @param div Limited xhtml content. Required.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Narrative">FHIR R5 Narrative</a>
 */
public record Narrative(
        String id,
        List<Extension> extension,
        FhirEnum<NarrativeStatus> status,
        FhirXhtml div) implements DataType {

    /**
     * Creates a {@code Narrative}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Narrative {
        extension = extension == null ? List.of() : List.copyOf(extension);
        Objects.requireNonNull(status, "Narrative.status is required");
        Objects.requireNonNull(div, "Narrative.div is required");
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
     * Returns a builder initialized with the values of this {@code Narrative}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Narrative}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirEnum<NarrativeStatus> status;
        private FhirXhtml div;

        private Builder() {
        }

        private Builder(Narrative original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.status = original.status();
            this.div = original.div();
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<NarrativeStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(NarrativeStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code div}.
         *
         * @param div the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder div(FhirXhtml div) {
            this.div = div;
            return this;
        }

        /**
         * Sets {@code div}, wrapped in a {@link FhirXhtml} without id or extensions.
         *
         * @param div the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder div(String div) {
            return div(div == null ? null : FhirXhtml.of(div));
        }

        /**
         * Builds the {@code Narrative}.
         *
         * @return the {@code Narrative}
         * @throws NullPointerException if a required element is absent
         */
        public Narrative build() {
            return new Narrative(
                    id, extension, status, div);
        }
    }
}
