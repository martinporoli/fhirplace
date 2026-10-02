package se.poroli.fhirplace.r5.parameters;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.Contributor;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.ElementDefinition;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * This resource is used to pass information into and back from an operation (whether invoked directly from REST or
 * within a messaging environment).
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Logical id of this artifact.
 * @param meta Metadata about the resource.
 * @param implicitRules A set of rules under which this content was created. Modifier element.
 * @param language Language of the resource content.
 * @param parameter Operation Parameter.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Parameters">FHIR R5 Parameters</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Parameters(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        List<Parameter> parameter) implements Resource {

    /**
     * Creates a {@code Parameters}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Parameters {
        parameter = parameter == null ? List.of() : List.copyOf(parameter);
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
     * Returns a builder initialized with the values of this {@code Parameters}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A parameter passed to or received from the operation.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Name from the definition. Required.
     * @param value If parameter is a data type. Any datatype except Contributor, VirtualServiceDetail,
     *   MonetaryComponent, Narrative, Extension, ElementDefinition, ProductShelfLife, MarketingStatus.
     * @param resource If parameter is a whole resource.
     * @param part Named part of a multi-part parameter.
     */
    public record Parameter(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            DataType value,
            Resource resource,
            List<Parameters.Parameter> part) implements BackboneElement {

        /**
         * Creates a {@code Parameter}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Parameter {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            part = part == null ? List.of() : List.copyOf(part);
            Objects.requireNonNull(name, "Parameters.parameter.name is required");
            if (value != null && (value instanceof Contributor
                    || value instanceof VirtualServiceDetail
                    || value instanceof MonetaryComponent
                    || value instanceof Narrative
                    || value instanceof Extension
                    || value instanceof ElementDefinition
                    || value instanceof ProductShelfLife
                    || value instanceof MarketingStatus)) {
                throw new IllegalArgumentException(
                        "Parameters.parameter.value[x] does not allow "
                                + value.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Parameter}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Parameter}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString name;
            private DataType value;
            private Resource resource;
            private List<Parameters.Parameter> part = new ArrayList<>();

            private Builder() {
            }

            private Builder(Parameter original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.value = original.value();
                this.resource = original.resource();
                this.part = new ArrayList<>(original.part());
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
             * Sets {@code name}.
             *
             * @param name the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder name(FhirString name) {
                this.name = name;
                return this;
            }

            /**
             * Sets {@code name}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param name the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder name(String name) {
                return name(name == null ? null : FhirString.of(name));
            }

            /**
             * Sets {@code value}.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(DataType value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code resource}.
             *
             * @param resource the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder resource(Resource resource) {
                this.resource = resource;
                return this;
            }

            /**
             * Replaces all {@code part} values.
             *
             * @param part the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder part(List<Parameters.Parameter> part) {
                this.part = part == null ? new ArrayList<>() : new ArrayList<>(part);
                return this;
            }

            /**
             * Adds a {@code part} value.
             *
             * @param part the value to add
             * @return this builder
             */
            public Builder addPart(Parameters.Parameter part) {
                this.part.add(Objects.requireNonNull(part, "part"));
                return this;
            }

            /**
             * Builds the {@code Parameter}.
             *
             * @return the {@code Parameter}
             * @throws NullPointerException if a required element is absent
             */
            public Parameter build() {
                return new Parameter(
                        id, extension, modifierExtension, name, value, resource, part);
            }
        }
    }

    /** Builder for {@link Parameters}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private List<Parameter> parameter = new ArrayList<>();

        private Builder() {
        }

        private Builder(Parameters original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.parameter = new ArrayList<>(original.parameter());
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
         * Sets {@code meta}.
         *
         * @param meta the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder meta(Meta meta) {
            this.meta = meta;
            return this;
        }

        /**
         * Sets {@code implicitRules}.
         *
         * @param implicitRules the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder implicitRules(FhirUri implicitRules) {
            this.implicitRules = implicitRules;
            return this;
        }

        /**
         * Sets {@code implicitRules}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param implicitRules the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder implicitRules(String implicitRules) {
            return implicitRules(implicitRules == null ? null : FhirUri.of(implicitRules));
        }

        /**
         * Sets {@code language}.
         *
         * @param language the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder language(FhirCode language) {
            this.language = language;
            return this;
        }

        /**
         * Sets {@code language}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param language the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder language(String language) {
            return language(language == null ? null : FhirCode.of(language));
        }

        /**
         * Replaces all {@code parameter} values.
         *
         * @param parameter the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder parameter(List<Parameter> parameter) {
            this.parameter = parameter == null ? new ArrayList<>() : new ArrayList<>(parameter);
            return this;
        }

        /**
         * Adds a {@code parameter} value.
         *
         * @param parameter the value to add
         * @return this builder
         */
        public Builder addParameter(Parameter parameter) {
            this.parameter.add(Objects.requireNonNull(parameter, "parameter"));
            return this;
        }

        /**
         * Builds the {@code Parameters}.
         *
         * @return the {@code Parameters}
         */
        public Parameters build() {
            return new Parameters(
                    id, meta, implicitRules, language, parameter);
        }
    }
}
