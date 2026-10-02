package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A concept that may be defined by a formal reference to a terminology or ontology or may be provided by text.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param coding Code defined by a terminology system.
 * @param text Plain text representation of the concept.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/CodeableConcept">FHIR R5 CodeableConcept</a>
 */
public record CodeableConcept(
        String id,
        List<Extension> extension,
        List<Coding> coding,
        FhirString text) implements DataType {

    /**
     * Creates a {@code CodeableConcept}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public CodeableConcept {
        extension = extension == null ? List.of() : List.copyOf(extension);
        coding = coding == null ? List.of() : List.copyOf(coding);
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
     * Returns a builder initialized with the values of this {@code CodeableConcept}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link CodeableConcept}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private List<Coding> coding = new ArrayList<>();
        private FhirString text;

        private Builder() {
        }

        private Builder(CodeableConcept original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.coding = new ArrayList<>(original.coding());
            this.text = original.text();
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
         * Replaces all {@code coding} values.
         *
         * @param coding the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder coding(List<Coding> coding) {
            this.coding = coding == null ? new ArrayList<>() : new ArrayList<>(coding);
            return this;
        }

        /**
         * Adds a {@code coding} value.
         *
         * @param coding the value to add
         * @return this builder
         */
        public Builder addCoding(Coding coding) {
            this.coding.add(Objects.requireNonNull(coding, "coding"));
            return this;
        }

        /**
         * Sets {@code text}.
         *
         * @param text the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder text(FhirString text) {
            this.text = text;
            return this;
        }

        /**
         * Sets {@code text}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param text the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder text(String text) {
            return text(text == null ? null : FhirString.of(text));
        }

        /**
         * Builds the {@code CodeableConcept}.
         *
         * @return the {@code CodeableConcept}
         */
        public CodeableConcept build() {
            return new CodeableConcept(
                    id, extension, coding, text);
        }
    }
}
