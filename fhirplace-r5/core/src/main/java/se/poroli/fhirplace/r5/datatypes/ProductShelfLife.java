package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The shelf-life and storage information for a medicinal product item or container can be described using this class.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
 * @param type This describes the shelf life, taking into account various scenarios such as shelf life of the packaged
 *   Medicinal Product itself, shelf life after transformation where necessary and shelf life after the first opening
 *   of a bottle, etc. The shelf life type shall be specified using an appropriate controlled vocabulary The
 *   controlled term and the controlled term identifier shall be specified.
 * @param period The shelf life time period can be specified using a numerical value for the period of time and its
 *   unit of time measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
 *   resulting terminology The symbol and the symbol identifier shall be used. One of Duration, string.
 * @param specialPrecautionsForStorage Special precautions for storage, if any, can be specified using an appropriate
 *   controlled vocabulary The controlled term and the controlled term identifier shall be specified.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ProductShelfLife">FHIR R5 ProductShelfLife</a>
 */
public record ProductShelfLife(
        String id,
        List<Extension> extension,
        List<Extension> modifierExtension,
        CodeableConcept type,
        DataType period,
        List<CodeableConcept> specialPrecautionsForStorage) implements BackboneType {

    /**
     * Creates a {@code ProductShelfLife}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ProductShelfLife {
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        specialPrecautionsForStorage =
                specialPrecautionsForStorage == null ? List.of() : List.copyOf(specialPrecautionsForStorage);
        if (period != null && !(period instanceof Duration || period instanceof FhirString)) {
            throw new IllegalArgumentException(
                    "ProductShelfLife.period[x] must be one of Duration, string, but was "
                            + period.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code ProductShelfLife}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link ProductShelfLife}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private CodeableConcept type;
        private DataType period;
        private List<CodeableConcept> specialPrecautionsForStorage = new ArrayList<>();

        private Builder() {
        }

        private Builder(ProductShelfLife original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.type = original.type();
            this.period = original.period();
            this.specialPrecautionsForStorage = new ArrayList<>(original.specialPrecautionsForStorage());
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
         * Replaces all {@code modifierExtension} values.
         *
         * @param modifierExtension the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder modifierExtension(List<Extension> modifierExtension) {
            this.modifierExtension = modifierExtension == null
                    ? new ArrayList<>()
                    : new ArrayList<>(modifierExtension);
            return this;
        }

        /**
         * Adds a {@code modifierExtension} value.
         *
         * @param modifierExtension the value to add
         * @return this builder
         */
        public Builder addModifierExtension(Extension modifierExtension) {
            this.modifierExtension.add(Objects.requireNonNull(modifierExtension, "modifierExtension"));
            return this;
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
         * Sets {@code period} to a Duration.
         *
         * @param period the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder period(Duration period) {
            this.period = period;
            return this;
        }

        /**
         * Sets {@code period} to a string.
         *
         * @param period the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder period(FhirString period) {
            this.period = period;
            return this;
        }

        /**
         * Sets {@code period} to a string without id or extensions.
         *
         * @param period the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder period(String period) {
            this.period = period == null ? null : FhirString.of(period);
            return this;
        }

        /**
         * Replaces all {@code specialPrecautionsForStorage} values.
         *
         * @param specialPrecautionsForStorage the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder specialPrecautionsForStorage(List<CodeableConcept> specialPrecautionsForStorage) {
            this.specialPrecautionsForStorage = specialPrecautionsForStorage == null
                    ? new ArrayList<>()
                    : new ArrayList<>(specialPrecautionsForStorage);
            return this;
        }

        /**
         * Adds a {@code specialPrecautionsForStorage} value.
         *
         * @param specialPrecautionsForStorage the value to add
         * @return this builder
         */
        public Builder addSpecialPrecautionsForStorage(CodeableConcept specialPrecautionsForStorage) {
            this.specialPrecautionsForStorage.add(
                    Objects.requireNonNull(specialPrecautionsForStorage, "specialPrecautionsForStorage"));
            return this;
        }

        /**
         * Builds the {@code ProductShelfLife}.
         *
         * @return the {@code ProductShelfLife}
         */
        public ProductShelfLife build() {
            return new ProductShelfLife(
                    id, extension, modifierExtension, type, period, specialPrecautionsForStorage);
        }
    }
}
