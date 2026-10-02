package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A reference from one resource to another.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param reference Literal reference, Relative, internal or absolute URL.
 * @param type Type the reference refers to (e.g. "Patient") - must be a resource in resources.
 * @param identifier Logical reference, when literal reference is not known.
 * @param display Text alternative for the resource.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Reference">FHIR R5 Reference</a>
 */
public record Reference(
        String id,
        List<Extension> extension,
        FhirString reference,
        FhirUri type,
        Identifier identifier,
        FhirString display) implements DataType {

    /**
     * Creates a {@code Reference}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Reference {
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
     * Returns a builder initialized with the values of this {@code Reference}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Reference}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirString reference;
        private FhirUri type;
        private Identifier identifier;
        private FhirString display;

        private Builder() {
        }

        private Builder(Reference original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.reference = original.reference();
            this.type = original.type();
            this.identifier = original.identifier();
            this.display = original.display();
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
         * Sets {@code reference}.
         *
         * @param reference the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reference(FhirString reference) {
            this.reference = reference;
            return this;
        }

        /**
         * Sets {@code reference}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param reference the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reference(String reference) {
            return reference(reference == null ? null : FhirString.of(reference));
        }

        /**
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirUri type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(String type) {
            return type(type == null ? null : FhirUri.of(type));
        }

        /**
         * Sets {@code identifier}.
         *
         * @param identifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder identifier(Identifier identifier) {
            this.identifier = identifier;
            return this;
        }

        /**
         * Sets {@code display}.
         *
         * @param display the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder display(FhirString display) {
            this.display = display;
            return this;
        }

        /**
         * Sets {@code display}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param display the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder display(String display) {
            return display(display == null ? null : FhirString.of(display));
        }

        /**
         * Builds the {@code Reference}.
         *
         * @return the {@code Reference}
         */
        public Reference build() {
            return new Reference(
                    id, extension, reference, type, identifier, display);
        }
    }
}
