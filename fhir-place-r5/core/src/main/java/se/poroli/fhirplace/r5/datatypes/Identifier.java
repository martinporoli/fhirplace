package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.IdentifierUse;

/**
 * An identifier - identifies some entity uniquely and unambiguously.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param use usual | official | temp | secondary | old (If known). Modifier element.
 * @param type Description of identifier.
 * @param system The namespace for the identifier value.
 * @param value The value that is unique.
 * @param period Time period when id is/was valid for use.
 * @param assigner Organization that issued id (may be just text). Reference to Organization.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Identifier">FHIR R5 Identifier</a>
 */
public record Identifier(
        String id,
        List<Extension> extension,
        FhirEnum<IdentifierUse> use,
        CodeableConcept type,
        FhirUri system,
        FhirString value,
        Period period,
        Reference assigner) implements DataType {

    /**
     * Creates an {@code Identifier}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Identifier {
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
     * Returns a builder initialized with the values of this {@code Identifier}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Identifier}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirEnum<IdentifierUse> use;
        private CodeableConcept type;
        private FhirUri system;
        private FhirString value;
        private Period period;
        private Reference assigner;

        private Builder() {
        }

        private Builder(Identifier original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.use = original.use();
            this.type = original.type();
            this.system = original.system();
            this.value = original.value();
            this.period = original.period();
            this.assigner = original.assigner();
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
         * Sets {@code use}.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(FhirEnum<IdentifierUse> use) {
            this.use = use;
            return this;
        }

        /**
         * Sets {@code use}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(IdentifierUse use) {
            return use(use == null ? null : FhirEnum.of(use));
        }

        /**
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(CodeableConcept type) {
            this.type = type;
            return this;
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
         * Sets {@code value}.
         *
         * @param value the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder value(FhirString value) {
            this.value = value;
            return this;
        }

        /**
         * Sets {@code value}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param value the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder value(String value) {
            return value(value == null ? null : FhirString.of(value));
        }

        /**
         * Sets {@code period}.
         *
         * @param period the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder period(Period period) {
            this.period = period;
            return this;
        }

        /**
         * Sets {@code assigner}.
         *
         * @param assigner the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder assigner(Reference assigner) {
            this.assigner = assigner;
            return this;
        }

        /**
         * Builds the {@code Identifier}.
         *
         * @return the {@code Identifier}
         */
        public Identifier build() {
            return new Identifier(
                    id, extension, use, type, system, value, period, assigner);
        }
    }
}
