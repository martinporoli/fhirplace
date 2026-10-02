package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A reference to a resource (by instance), or instead, a reference to a concept defined in a terminology or ontology
 * (by class).
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param concept Reference to a concept (by class).
 * @param reference Reference to a resource (by instance).
 * @see <a href="http://hl7.org/fhir/StructureDefinition/CodeableReference">FHIR R5 CodeableReference</a>
 */
public record CodeableReference(
        String id,
        List<Extension> extension,
        CodeableConcept concept,
        Reference reference) implements DataType {

    /**
     * Creates a {@code CodeableReference}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public CodeableReference {
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
     * Returns a builder initialized with the values of this {@code CodeableReference}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link CodeableReference}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private CodeableConcept concept;
        private Reference reference;

        private Builder() {
        }

        private Builder(CodeableReference original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.concept = original.concept();
            this.reference = original.reference();
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
         * Sets {@code concept}.
         *
         * @param concept the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder concept(CodeableConcept concept) {
            this.concept = concept;
            return this;
        }

        /**
         * Sets {@code reference}.
         *
         * @param reference the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reference(Reference reference) {
            this.reference = reference;
            return this;
        }

        /**
         * Builds the {@code CodeableReference}.
         *
         * @return the {@code CodeableReference}
         */
        public CodeableReference build() {
            return new CodeableReference(
                    id, extension, concept, reference);
        }
    }
}
