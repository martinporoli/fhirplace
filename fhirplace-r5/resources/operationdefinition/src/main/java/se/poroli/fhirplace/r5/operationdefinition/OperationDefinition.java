package se.poroli.fhirplace.r5.operationdefinition;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.BindingStrength;
import se.poroli.fhirplace.r5.valuesets.FHIRTypes;
import se.poroli.fhirplace.r5.valuesets.OperationParameterUse;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.SearchParamType;

/**
 * A formal computable definition of an operation (on the RESTful interface) or a named query (using the search
 * interaction).
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Logical id of this artifact.
 * @param meta Metadata about the resource.
 * @param implicitRules A set of rules under which this content was created. Modifier element.
 * @param language Language of the resource content.
 * @param text Text summary of the resource, for human interpretation.
 * @param contained Contained, inline Resources.
 * @param extension Additional content defined by implementations.
 * @param modifierExtension Extensions that cannot be ignored. Modifier element.
 * @param url Canonical identifier for this operation definition, represented as an absolute URI (globally unique).
 * @param identifier Additional identifier for the implementation guide (business identifier).
 * @param version Business version of the operation definition.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this operation definition (computer friendly). Required.
 * @param title Name for this operation definition (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param kind operation | query. Required.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the operation definition.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for operation definition (if applicable).
 * @param purpose Why this operation definition is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param affectsState Whether content is changed by the operation.
 * @param code Recommended name for operation in search url. Required.
 * @param comment Additional information about use.
 * @param base Marks this as a profile of the base. Canonical reference to OperationDefinition.
 * @param resource Types this operation applies to.
 * @param system Invoke at the system level?. Required.
 * @param type Invoke at the type level?. Required.
 * @param instance Invoke on an instance?. Required.
 * @param inputProfile Validation information for in parameters. Canonical reference to StructureDefinition.
 * @param outputProfile Validation information for out parameters. Canonical reference to StructureDefinition.
 * @param parameter Parameters for the operation/query.
 * @param overload Define overloaded variants for when generating code.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/OperationDefinition">FHIR R5 OperationDefinition</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record OperationDefinition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirUri url,
        List<Identifier> identifier,
        FhirString version,
        DataType versionAlgorithm,
        FhirString name,
        FhirString title,
        FhirEnum<PublicationStatus> status,
        FhirEnum<OperationKind> kind,
        FhirBoolean experimental,
        FhirDateTime date,
        FhirString publisher,
        List<ContactDetail> contact,
        FhirMarkdown description,
        List<UsageContext> useContext,
        List<CodeableConcept> jurisdiction,
        FhirMarkdown purpose,
        FhirMarkdown copyright,
        FhirString copyrightLabel,
        FhirBoolean affectsState,
        FhirCode code,
        FhirMarkdown comment,
        FhirCanonical base,
        List<FhirCode> resource,
        FhirBoolean system,
        FhirBoolean type,
        FhirBoolean instance,
        FhirCanonical inputProfile,
        FhirCanonical outputProfile,
        List<Parameter> parameter,
        List<Overload> overload) implements DomainResource {

    /**
     * Creates an {@code OperationDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public OperationDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        resource = resource == null ? List.of() : List.copyOf(resource);
        parameter = parameter == null ? List.of() : List.copyOf(parameter);
        overload = overload == null ? List.of() : List.copyOf(overload);
        Objects.requireNonNull(name, "OperationDefinition.name is required");
        Objects.requireNonNull(status, "OperationDefinition.status is required");
        Objects.requireNonNull(kind, "OperationDefinition.kind is required");
        Objects.requireNonNull(code, "OperationDefinition.code is required");
        Objects.requireNonNull(system, "OperationDefinition.system is required");
        Objects.requireNonNull(type, "OperationDefinition.type is required");
        Objects.requireNonNull(instance, "OperationDefinition.instance is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "OperationDefinition.versionAlgorithm[x] must be one of string, Coding, but was "
                            + versionAlgorithm.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code OperationDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The parameters for the operation/query.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Name in Parameters.parameter.name or in URL. Required.
     * @param use in | out. Required.
     * @param scope instance | type | system.
     * @param min Minimum Cardinality. Required.
     * @param max Maximum Cardinality (a number or *). Required.
     * @param documentation Description of meaning/use.
     * @param type What type this parameter has.
     * @param allowedType Allowed sub-type this parameter can have (if type is abstract).
     * @param targetProfile If type is Reference | canonical, allowed targets. If type is 'Resource', then this
     *   constrains the allowed resource types. Canonical reference to StructureDefinition.
     * @param searchType number | date | string | token | reference | composite | quantity | uri | special.
     * @param binding ValueSet details if this is coded.
     * @param referencedFrom References to this parameter.
     * @param part Parts of a nested Parameter.
     */
    public record Parameter(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCode name,
            FhirEnum<OperationParameterUse> use,
            List<FhirEnum<OperationParameterScope>> scope,
            FhirInteger min,
            FhirString max,
            FhirMarkdown documentation,
            FhirEnum<FHIRTypes> type,
            List<FhirEnum<FHIRTypes>> allowedType,
            List<FhirCanonical> targetProfile,
            FhirEnum<SearchParamType> searchType,
            Binding binding,
            List<ReferencedFrom> referencedFrom,
            List<OperationDefinition.Parameter> part) implements BackboneElement {

        /**
         * Creates a {@code Parameter}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Parameter {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            scope = scope == null ? List.of() : List.copyOf(scope);
            allowedType = allowedType == null ? List.of() : List.copyOf(allowedType);
            targetProfile = targetProfile == null ? List.of() : List.copyOf(targetProfile);
            referencedFrom = referencedFrom == null ? List.of() : List.copyOf(referencedFrom);
            part = part == null ? List.of() : List.copyOf(part);
            Objects.requireNonNull(name, "OperationDefinition.parameter.name is required");
            Objects.requireNonNull(use, "OperationDefinition.parameter.use is required");
            Objects.requireNonNull(min, "OperationDefinition.parameter.min is required");
            Objects.requireNonNull(max, "OperationDefinition.parameter.max is required");
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

        /**
         * Binds to a value set if this parameter is coded (code, Coding, CodeableConcept).
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param strength required | extensible | preferred | example. Required.
         * @param valueSet Source of value set. Canonical reference to ValueSet. Required.
         */
        public record Binding(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<BindingStrength> strength,
                FhirCanonical valueSet) implements BackboneElement {

            /**
             * Creates a {@code Binding}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Binding {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(strength, "OperationDefinition.parameter.binding.strength is required");
                Objects.requireNonNull(valueSet, "OperationDefinition.parameter.binding.valueSet is required");
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
             * Returns a builder initialized with the values of this {@code Binding}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Binding}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<BindingStrength> strength;
                private FhirCanonical valueSet;

                private Builder() {
                }

                private Builder(Binding original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.strength = original.strength();
                    this.valueSet = original.valueSet();
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
                 * Sets {@code strength}.
                 *
                 * @param strength the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder strength(FhirEnum<BindingStrength> strength) {
                    this.strength = strength;
                    return this;
                }

                /**
                 * Sets {@code strength}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param strength the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder strength(BindingStrength strength) {
                    return strength(strength == null ? null : FhirEnum.of(strength));
                }

                /**
                 * Sets {@code valueSet}.
                 *
                 * @param valueSet the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder valueSet(FhirCanonical valueSet) {
                    this.valueSet = valueSet;
                    return this;
                }

                /**
                 * Sets {@code valueSet}, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param valueSet the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder valueSet(String valueSet) {
                    return valueSet(valueSet == null ? null : FhirCanonical.of(valueSet));
                }

                /**
                 * Builds the {@code Binding}.
                 *
                 * @return the {@code Binding}
                 * @throws NullPointerException if a required element is absent
                 */
                public Binding build() {
                    return new Binding(
                            id, extension, modifierExtension, strength, valueSet);
                }
            }
        }

        /**
         * Identifies other resource parameters within the operation invocation that are expected to resolve to this
         * resource.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param source Referencing parameter. Required.
         * @param sourceId Element id of reference.
         */
        public record ReferencedFrom(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString source,
                FhirString sourceId) implements BackboneElement {

            /**
             * Creates a {@code ReferencedFrom}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public ReferencedFrom {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(source, "OperationDefinition.parameter.referencedFrom.source is required");
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
             * Returns a builder initialized with the values of this {@code ReferencedFrom}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link ReferencedFrom}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString source;
                private FhirString sourceId;

                private Builder() {
                }

                private Builder(ReferencedFrom original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.source = original.source();
                    this.sourceId = original.sourceId();
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
                 * Sets {@code source}.
                 *
                 * @param source the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder source(FhirString source) {
                    this.source = source;
                    return this;
                }

                /**
                 * Sets {@code source}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param source the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder source(String source) {
                    return source(source == null ? null : FhirString.of(source));
                }

                /**
                 * Sets {@code sourceId}.
                 *
                 * @param sourceId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder sourceId(FhirString sourceId) {
                    this.sourceId = sourceId;
                    return this;
                }

                /**
                 * Sets {@code sourceId}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param sourceId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder sourceId(String sourceId) {
                    return sourceId(sourceId == null ? null : FhirString.of(sourceId));
                }

                /**
                 * Builds the {@code ReferencedFrom}.
                 *
                 * @return the {@code ReferencedFrom}
                 * @throws NullPointerException if a required element is absent
                 */
                public ReferencedFrom build() {
                    return new ReferencedFrom(
                            id, extension, modifierExtension, source, sourceId);
                }
            }
        }

        /** Builder for {@link Parameter}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCode name;
            private FhirEnum<OperationParameterUse> use;
            private List<FhirEnum<OperationParameterScope>> scope = new ArrayList<>();
            private FhirInteger min;
            private FhirString max;
            private FhirMarkdown documentation;
            private FhirEnum<FHIRTypes> type;
            private List<FhirEnum<FHIRTypes>> allowedType = new ArrayList<>();
            private List<FhirCanonical> targetProfile = new ArrayList<>();
            private FhirEnum<SearchParamType> searchType;
            private Binding binding;
            private List<ReferencedFrom> referencedFrom = new ArrayList<>();
            private List<OperationDefinition.Parameter> part = new ArrayList<>();

            private Builder() {
            }

            private Builder(Parameter original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.use = original.use();
                this.scope = new ArrayList<>(original.scope());
                this.min = original.min();
                this.max = original.max();
                this.documentation = original.documentation();
                this.type = original.type();
                this.allowedType = new ArrayList<>(original.allowedType());
                this.targetProfile = new ArrayList<>(original.targetProfile());
                this.searchType = original.searchType();
                this.binding = original.binding();
                this.referencedFrom = new ArrayList<>(original.referencedFrom());
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
             * Replaces all {@code scope} values.
             *
             * @param scope the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder scope(List<FhirEnum<OperationParameterScope>> scope) {
                this.scope = scope == null ? new ArrayList<>() : new ArrayList<>(scope);
                return this;
            }

            /**
             * Adds a {@code scope} value.
             *
             * @param scope the value to add
             * @return this builder
             */
            public Builder addScope(FhirEnum<OperationParameterScope> scope) {
                this.scope.add(Objects.requireNonNull(scope, "scope"));
                return this;
            }

            /**
             * Adds a {@code scope} value, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param scope the value to add
             * @return this builder
             */
            public Builder addScope(OperationParameterScope scope) {
                return addScope(FhirEnum.of(scope));
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
            public Builder documentation(FhirMarkdown documentation) {
                this.documentation = documentation;
                return this;
            }

            /**
             * Sets {@code documentation}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param documentation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder documentation(String documentation) {
                return documentation(documentation == null ? null : FhirMarkdown.of(documentation));
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
             * Replaces all {@code allowedType} values.
             *
             * @param allowedType the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder allowedType(List<FhirEnum<FHIRTypes>> allowedType) {
                this.allowedType = allowedType == null ? new ArrayList<>() : new ArrayList<>(allowedType);
                return this;
            }

            /**
             * Adds a {@code allowedType} value.
             *
             * @param allowedType the value to add
             * @return this builder
             */
            public Builder addAllowedType(FhirEnum<FHIRTypes> allowedType) {
                this.allowedType.add(Objects.requireNonNull(allowedType, "allowedType"));
                return this;
            }

            /**
             * Adds a {@code allowedType} value, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param allowedType the value to add
             * @return this builder
             */
            public Builder addAllowedType(FHIRTypes allowedType) {
                return addAllowedType(FhirEnum.of(allowedType));
            }

            /**
             * Replaces all {@code targetProfile} values.
             *
             * @param targetProfile the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder targetProfile(List<FhirCanonical> targetProfile) {
                this.targetProfile = targetProfile == null ? new ArrayList<>() : new ArrayList<>(targetProfile);
                return this;
            }

            /**
             * Adds a {@code targetProfile} value.
             *
             * @param targetProfile the value to add
             * @return this builder
             */
            public Builder addTargetProfile(FhirCanonical targetProfile) {
                this.targetProfile.add(Objects.requireNonNull(targetProfile, "targetProfile"));
                return this;
            }

            /**
             * Adds a {@code targetProfile} value, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param targetProfile the value to add
             * @return this builder
             */
            public Builder addTargetProfile(String targetProfile) {
                return addTargetProfile(FhirCanonical.of(targetProfile));
            }

            /**
             * Sets {@code searchType}.
             *
             * @param searchType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder searchType(FhirEnum<SearchParamType> searchType) {
                this.searchType = searchType;
                return this;
            }

            /**
             * Sets {@code searchType}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param searchType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder searchType(SearchParamType searchType) {
                return searchType(searchType == null ? null : FhirEnum.of(searchType));
            }

            /**
             * Sets {@code binding}.
             *
             * @param binding the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder binding(Binding binding) {
                this.binding = binding;
                return this;
            }

            /**
             * Replaces all {@code referencedFrom} values.
             *
             * @param referencedFrom the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder referencedFrom(List<ReferencedFrom> referencedFrom) {
                this.referencedFrom = referencedFrom == null ? new ArrayList<>() : new ArrayList<>(referencedFrom);
                return this;
            }

            /**
             * Adds a {@code referencedFrom} value.
             *
             * @param referencedFrom the value to add
             * @return this builder
             */
            public Builder addReferencedFrom(ReferencedFrom referencedFrom) {
                this.referencedFrom.add(Objects.requireNonNull(referencedFrom, "referencedFrom"));
                return this;
            }

            /**
             * Replaces all {@code part} values.
             *
             * @param part the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder part(List<OperationDefinition.Parameter> part) {
                this.part = part == null ? new ArrayList<>() : new ArrayList<>(part);
                return this;
            }

            /**
             * Adds a {@code part} value.
             *
             * @param part the value to add
             * @return this builder
             */
            public Builder addPart(OperationDefinition.Parameter part) {
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
                        id, extension, modifierExtension, name, use, scope, min, max, documentation, type,
                        allowedType, targetProfile, searchType, binding, referencedFrom, part);
            }
        }
    }

    /**
     * Defines an appropriate combination of parameters to use when invoking this operation, to help code generators
     * when generating overloaded parameter sets for this operation.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param parameterName Name of parameter to include in overload.
     * @param comment Comments to go on overload.
     */
    public record Overload(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<FhirString> parameterName,
            FhirString comment) implements BackboneElement {

        /**
         * Creates an {@code Overload}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Overload {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            parameterName = parameterName == null ? List.of() : List.copyOf(parameterName);
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
         * Returns a builder initialized with the values of this {@code Overload}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Overload}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<FhirString> parameterName = new ArrayList<>();
            private FhirString comment;

            private Builder() {
            }

            private Builder(Overload original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.parameterName = new ArrayList<>(original.parameterName());
                this.comment = original.comment();
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
             * Replaces all {@code parameterName} values.
             *
             * @param parameterName the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder parameterName(List<FhirString> parameterName) {
                this.parameterName = parameterName == null ? new ArrayList<>() : new ArrayList<>(parameterName);
                return this;
            }

            /**
             * Adds a {@code parameterName} value.
             *
             * @param parameterName the value to add
             * @return this builder
             */
            public Builder addParameterName(FhirString parameterName) {
                this.parameterName.add(Objects.requireNonNull(parameterName, "parameterName"));
                return this;
            }

            /**
             * Adds a {@code parameterName} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param parameterName the value to add
             * @return this builder
             */
            public Builder addParameterName(String parameterName) {
                return addParameterName(FhirString.of(parameterName));
            }

            /**
             * Sets {@code comment}.
             *
             * @param comment the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder comment(FhirString comment) {
                this.comment = comment;
                return this;
            }

            /**
             * Sets {@code comment}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param comment the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder comment(String comment) {
                return comment(comment == null ? null : FhirString.of(comment));
            }

            /**
             * Builds the {@code Overload}.
             *
             * @return the {@code Overload}
             */
            public Overload build() {
                return new Overload(
                        id, extension, modifierExtension, parameterName, comment);
            }
        }
    }

    /** Builder for {@link OperationDefinition}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirUri url;
        private List<Identifier> identifier = new ArrayList<>();
        private FhirString version;
        private DataType versionAlgorithm;
        private FhirString name;
        private FhirString title;
        private FhirEnum<PublicationStatus> status;
        private FhirEnum<OperationKind> kind;
        private FhirBoolean experimental;
        private FhirDateTime date;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private FhirMarkdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private FhirMarkdown purpose;
        private FhirMarkdown copyright;
        private FhirString copyrightLabel;
        private FhirBoolean affectsState;
        private FhirCode code;
        private FhirMarkdown comment;
        private FhirCanonical base;
        private List<FhirCode> resource = new ArrayList<>();
        private FhirBoolean system;
        private FhirBoolean type;
        private FhirBoolean instance;
        private FhirCanonical inputProfile;
        private FhirCanonical outputProfile;
        private List<Parameter> parameter = new ArrayList<>();
        private List<Overload> overload = new ArrayList<>();

        private Builder() {
        }

        private Builder(OperationDefinition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.url = original.url();
            this.identifier = new ArrayList<>(original.identifier());
            this.version = original.version();
            this.versionAlgorithm = original.versionAlgorithm();
            this.name = original.name();
            this.title = original.title();
            this.status = original.status();
            this.kind = original.kind();
            this.experimental = original.experimental();
            this.date = original.date();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.description = original.description();
            this.useContext = new ArrayList<>(original.useContext());
            this.jurisdiction = new ArrayList<>(original.jurisdiction());
            this.purpose = original.purpose();
            this.copyright = original.copyright();
            this.copyrightLabel = original.copyrightLabel();
            this.affectsState = original.affectsState();
            this.code = original.code();
            this.comment = original.comment();
            this.base = original.base();
            this.resource = new ArrayList<>(original.resource());
            this.system = original.system();
            this.type = original.type();
            this.instance = original.instance();
            this.inputProfile = original.inputProfile();
            this.outputProfile = original.outputProfile();
            this.parameter = new ArrayList<>(original.parameter());
            this.overload = new ArrayList<>(original.overload());
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
         * Sets {@code text}.
         *
         * @param text the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder text(Narrative text) {
            this.text = text;
            return this;
        }

        /**
         * Replaces all {@code contained} values.
         *
         * @param contained the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contained(List<Resource> contained) {
            this.contained = contained == null ? new ArrayList<>() : new ArrayList<>(contained);
            return this;
        }

        /**
         * Adds a {@code contained} value.
         *
         * @param contained the value to add
         * @return this builder
         */
        public Builder addContained(Resource contained) {
            this.contained.add(Objects.requireNonNull(contained, "contained"));
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
         * Sets {@code url}.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(FhirUri url) {
            this.url = url;
            return this;
        }

        /**
         * Sets {@code url}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(String url) {
            return url(url == null ? null : FhirUri.of(url));
        }

        /**
         * Replaces all {@code identifier} values.
         *
         * @param identifier the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder identifier(List<Identifier> identifier) {
            this.identifier = identifier == null ? new ArrayList<>() : new ArrayList<>(identifier);
            return this;
        }

        /**
         * Adds a {@code identifier} value.
         *
         * @param identifier the value to add
         * @return this builder
         */
        public Builder addIdentifier(Identifier identifier) {
            this.identifier.add(Objects.requireNonNull(identifier, "identifier"));
            return this;
        }

        /**
         * Sets {@code version}.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(FhirString version) {
            this.version = version;
            return this;
        }

        /**
         * Sets {@code version}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(String version) {
            return version(version == null ? null : FhirString.of(version));
        }

        /**
         * Sets {@code versionAlgorithm} to a string.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(FhirString versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a Coding.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(Coding versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a string without id or extensions.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(String versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm == null ? null : FhirString.of(versionAlgorithm);
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
         * Sets {@code title}.
         *
         * @param title the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder title(FhirString title) {
            this.title = title;
            return this;
        }

        /**
         * Sets {@code title}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param title the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder title(String title) {
            return title(title == null ? null : FhirString.of(title));
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<PublicationStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(PublicationStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code kind}.
         *
         * @param kind the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder kind(FhirEnum<OperationKind> kind) {
            this.kind = kind;
            return this;
        }

        /**
         * Sets {@code kind}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param kind the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder kind(OperationKind kind) {
            return kind(kind == null ? null : FhirEnum.of(kind));
        }

        /**
         * Sets {@code experimental}.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(FhirBoolean experimental) {
            this.experimental = experimental;
            return this;
        }

        /**
         * Sets {@code experimental}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(Boolean experimental) {
            return experimental(experimental == null ? null : FhirBoolean.of(experimental));
        }

        /**
         * Sets {@code date}.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(FhirDateTime date) {
            this.date = date;
            return this;
        }

        /**
         * Sets {@code date}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(Temporal date) {
            return date(date == null ? null : FhirDateTime.of(date));
        }

        /**
         * Sets {@code publisher}.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(FhirString publisher) {
            this.publisher = publisher;
            return this;
        }

        /**
         * Sets {@code publisher}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(String publisher) {
            return publisher(publisher == null ? null : FhirString.of(publisher));
        }

        /**
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ContactDetail> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ContactDetail contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
            return this;
        }

        /**
         * Sets {@code description}.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(FhirMarkdown description) {
            this.description = description;
            return this;
        }

        /**
         * Sets {@code description}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(String description) {
            return description(description == null ? null : FhirMarkdown.of(description));
        }

        /**
         * Replaces all {@code useContext} values.
         *
         * @param useContext the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder useContext(List<UsageContext> useContext) {
            this.useContext = useContext == null ? new ArrayList<>() : new ArrayList<>(useContext);
            return this;
        }

        /**
         * Adds a {@code useContext} value.
         *
         * @param useContext the value to add
         * @return this builder
         */
        public Builder addUseContext(UsageContext useContext) {
            this.useContext.add(Objects.requireNonNull(useContext, "useContext"));
            return this;
        }

        /**
         * Replaces all {@code jurisdiction} values.
         *
         * @param jurisdiction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder jurisdiction(List<CodeableConcept> jurisdiction) {
            this.jurisdiction = jurisdiction == null ? new ArrayList<>() : new ArrayList<>(jurisdiction);
            return this;
        }

        /**
         * Adds a {@code jurisdiction} value.
         *
         * @param jurisdiction the value to add
         * @return this builder
         */
        public Builder addJurisdiction(CodeableConcept jurisdiction) {
            this.jurisdiction.add(Objects.requireNonNull(jurisdiction, "jurisdiction"));
            return this;
        }

        /**
         * Sets {@code purpose}.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(FhirMarkdown purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * Sets {@code purpose}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(String purpose) {
            return purpose(purpose == null ? null : FhirMarkdown.of(purpose));
        }

        /**
         * Sets {@code copyright}.
         *
         * @param copyright the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyright(FhirMarkdown copyright) {
            this.copyright = copyright;
            return this;
        }

        /**
         * Sets {@code copyright}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param copyright the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyright(String copyright) {
            return copyright(copyright == null ? null : FhirMarkdown.of(copyright));
        }

        /**
         * Sets {@code copyrightLabel}.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(FhirString copyrightLabel) {
            this.copyrightLabel = copyrightLabel;
            return this;
        }

        /**
         * Sets {@code copyrightLabel}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(String copyrightLabel) {
            return copyrightLabel(copyrightLabel == null ? null : FhirString.of(copyrightLabel));
        }

        /**
         * Sets {@code affectsState}.
         *
         * @param affectsState the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder affectsState(FhirBoolean affectsState) {
            this.affectsState = affectsState;
            return this;
        }

        /**
         * Sets {@code affectsState}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param affectsState the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder affectsState(Boolean affectsState) {
            return affectsState(affectsState == null ? null : FhirBoolean.of(affectsState));
        }

        /**
         * Sets {@code code}.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(FhirCode code) {
            this.code = code;
            return this;
        }

        /**
         * Sets {@code code}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(String code) {
            return code(code == null ? null : FhirCode.of(code));
        }

        /**
         * Sets {@code comment}.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(FhirMarkdown comment) {
            this.comment = comment;
            return this;
        }

        /**
         * Sets {@code comment}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(String comment) {
            return comment(comment == null ? null : FhirMarkdown.of(comment));
        }

        /**
         * Sets {@code base}.
         *
         * @param base the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder base(FhirCanonical base) {
            this.base = base;
            return this;
        }

        /**
         * Sets {@code base}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param base the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder base(String base) {
            return base(base == null ? null : FhirCanonical.of(base));
        }

        /**
         * Replaces all {@code resource} values.
         *
         * @param resource the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder resource(List<FhirCode> resource) {
            this.resource = resource == null ? new ArrayList<>() : new ArrayList<>(resource);
            return this;
        }

        /**
         * Adds a {@code resource} value.
         *
         * @param resource the value to add
         * @return this builder
         */
        public Builder addResource(FhirCode resource) {
            this.resource.add(Objects.requireNonNull(resource, "resource"));
            return this;
        }

        /**
         * Adds a {@code resource} value, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param resource the value to add
         * @return this builder
         */
        public Builder addResource(String resource) {
            return addResource(FhirCode.of(resource));
        }

        /**
         * Sets {@code system}.
         *
         * @param system the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder system(FhirBoolean system) {
            this.system = system;
            return this;
        }

        /**
         * Sets {@code system}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param system the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder system(Boolean system) {
            return system(system == null ? null : FhirBoolean.of(system));
        }

        /**
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirBoolean type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(Boolean type) {
            return type(type == null ? null : FhirBoolean.of(type));
        }

        /**
         * Sets {@code instance}.
         *
         * @param instance the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instance(FhirBoolean instance) {
            this.instance = instance;
            return this;
        }

        /**
         * Sets {@code instance}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param instance the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instance(Boolean instance) {
            return instance(instance == null ? null : FhirBoolean.of(instance));
        }

        /**
         * Sets {@code inputProfile}.
         *
         * @param inputProfile the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder inputProfile(FhirCanonical inputProfile) {
            this.inputProfile = inputProfile;
            return this;
        }

        /**
         * Sets {@code inputProfile}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param inputProfile the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder inputProfile(String inputProfile) {
            return inputProfile(inputProfile == null ? null : FhirCanonical.of(inputProfile));
        }

        /**
         * Sets {@code outputProfile}.
         *
         * @param outputProfile the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outputProfile(FhirCanonical outputProfile) {
            this.outputProfile = outputProfile;
            return this;
        }

        /**
         * Sets {@code outputProfile}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param outputProfile the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outputProfile(String outputProfile) {
            return outputProfile(outputProfile == null ? null : FhirCanonical.of(outputProfile));
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
         * Replaces all {@code overload} values.
         *
         * @param overload the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder overload(List<Overload> overload) {
            this.overload = overload == null ? new ArrayList<>() : new ArrayList<>(overload);
            return this;
        }

        /**
         * Adds a {@code overload} value.
         *
         * @param overload the value to add
         * @return this builder
         */
        public Builder addOverload(Overload overload) {
            this.overload.add(Objects.requireNonNull(overload, "overload"));
            return this;
        }

        /**
         * Builds the {@code OperationDefinition}.
         *
         * @return the {@code OperationDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public OperationDefinition build() {
            return new OperationDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, kind, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, affectsState, code,
                    comment, base, resource, system, type, instance, inputProfile, outputProfile, parameter, overload);
        }
    }
}
