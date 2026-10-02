package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.FHIRTypes;
import se.poroli.fhirplace.r5.valuesets.OperationParameterUse;

/**
 * The parameters to the module.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param name Name used to access the parameter value.
 * @param use in | out. Required.
 * @param min Minimum cardinality.
 * @param max Maximum cardinality (a number of *).
 * @param documentation A brief description of the parameter.
 * @param type What type of value. Required.
 * @param profile What profile the value is expected to be. Canonical reference to StructureDefinition.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ParameterDefinition">FHIR R5 ParameterDefinition</a>
 */
public record ParameterDefinition(
        String id,
        List<Extension> extension,
        FhirCode name,
        FhirEnum<OperationParameterUse> use,
        FhirInteger min,
        FhirString max,
        FhirString documentation,
        FhirEnum<FHIRTypes> type,
        FhirCanonical profile) implements DataType {

    /**
     * Creates a {@code ParameterDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public ParameterDefinition {
        extension = extension == null ? List.of() : List.copyOf(extension);
        Objects.requireNonNull(use, "ParameterDefinition.use is required");
        Objects.requireNonNull(type, "ParameterDefinition.type is required");
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
     * Returns a builder initialized with the values of this {@code ParameterDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link ParameterDefinition}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirCode name;
        private FhirEnum<OperationParameterUse> use;
        private FhirInteger min;
        private FhirString max;
        private FhirString documentation;
        private FhirEnum<FHIRTypes> type;
        private FhirCanonical profile;

        private Builder() {
        }

        private Builder(ParameterDefinition original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.name = original.name();
            this.use = original.use();
            this.min = original.min();
            this.max = original.max();
            this.documentation = original.documentation();
            this.type = original.type();
            this.profile = original.profile();
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
         * Sets {@code name}.
         *
         * @param name the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder name(FhirCode name) {
            this.name = name;
            return this;
        }

        /**
         * Sets {@code name}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param name the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder name(String name) {
            return name(name == null ? null : FhirCode.of(name));
        }

        /**
         * Sets {@code use}.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(FhirEnum<OperationParameterUse> use) {
            this.use = use;
            return this;
        }

        /**
         * Sets {@code use}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(OperationParameterUse use) {
            return use(use == null ? null : FhirEnum.of(use));
        }

        /**
         * Sets {@code min}.
         *
         * @param min the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder min(FhirInteger min) {
            this.min = min;
            return this;
        }

        /**
         * Sets {@code min}, wrapped in a {@link FhirInteger} without id or extensions.
         *
         * @param min the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder min(Integer min) {
            return min(min == null ? null : FhirInteger.of(min));
        }

        /**
         * Sets {@code max}.
         *
         * @param max the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder max(FhirString max) {
            this.max = max;
            return this;
        }

        /**
         * Sets {@code max}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param max the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder max(String max) {
            return max(max == null ? null : FhirString.of(max));
        }

        /**
         * Sets {@code documentation}.
         *
         * @param documentation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder documentation(FhirString documentation) {
            this.documentation = documentation;
            return this;
        }

        /**
         * Sets {@code documentation}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param documentation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder documentation(String documentation) {
            return documentation(documentation == null ? null : FhirString.of(documentation));
        }

        /**
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<FHIRTypes> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FHIRTypes type) {
            return type(type == null ? null : FhirEnum.of(type));
        }

        /**
         * Sets {@code profile}.
         *
         * @param profile the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder profile(FhirCanonical profile) {
            this.profile = profile;
            return this;
        }

        /**
         * Sets {@code profile}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param profile the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder profile(String profile) {
            return profile(profile == null ? null : FhirCanonical.of(profile));
        }

        /**
         * Builds the {@code ParameterDefinition}.
         *
         * @return the {@code ParameterDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public ParameterDefinition build() {
            return new ParameterDefinition(
                    id, extension, name, use, min, max, documentation, type, profile);
        }
    }
}
