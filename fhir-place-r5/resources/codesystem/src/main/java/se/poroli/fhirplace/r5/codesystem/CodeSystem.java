package se.poroli.fhirplace.r5.codesystem;

import java.math.BigDecimal;
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
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.CodeSystemContentMode;
import se.poroli.fhirplace.r5.valuesets.FilterOperator;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement
 * and its key properties, and optionally define a part or all of its content.
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
 * @param url Canonical identifier for this code system, represented as a URI (globally unique) (Coding.system).
 * @param identifier Additional identifier for the code system (business identifier).
 * @param version Business version of the code system (Coding.version).
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this code system (computer friendly).
 * @param title Name for this code system (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the code system.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for code system (if applicable).
 * @param purpose Why this code system is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param approvalDate When the CodeSystem was approved by publisher.
 * @param lastReviewDate When the CodeSystem was last reviewed by the publisher.
 * @param effectivePeriod When the CodeSystem is expected to be used.
 * @param topic E.g. Education, Treatment, Assessment, etc.
 * @param author Who authored the CodeSystem.
 * @param editor Who edited the CodeSystem.
 * @param reviewer Who reviewed the CodeSystem.
 * @param endorser Who endorsed the CodeSystem.
 * @param relatedArtifact Additional documentation, citations, etc.
 * @param caseSensitive If code comparison is case sensitive.
 * @param valueSet Canonical reference to the value set with entire code system. Canonical reference to ValueSet.
 * @param hierarchyMeaning grouped-by | is-a | part-of | classified-with.
 * @param compositional If code system defines a compositional grammar.
 * @param versionNeeded If definitions are not stable.
 * @param content not-present | example | fragment | complete | supplement. Required.
 * @param supplements Canonical URL of Code System this adds designations and properties to. Canonical reference to
 *   CodeSystem.
 * @param count Total concepts in the code system.
 * @param filter Filter that can be used in a value set.
 * @param property Additional information supplied about each concept.
 * @param concept Concepts in the code system.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/CodeSystem">FHIR R5 CodeSystem</a>
 */
public record CodeSystem(
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
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        Period effectivePeriod,
        List<CodeableConcept> topic,
        List<ContactDetail> author,
        List<ContactDetail> editor,
        List<ContactDetail> reviewer,
        List<ContactDetail> endorser,
        List<RelatedArtifact> relatedArtifact,
        FhirBoolean caseSensitive,
        FhirCanonical valueSet,
        FhirEnum<CodeSystemHierarchyMeaning> hierarchyMeaning,
        FhirBoolean compositional,
        FhirBoolean versionNeeded,
        FhirEnum<CodeSystemContentMode> content,
        FhirCanonical supplements,
        FhirUnsignedInt count,
        List<Filter> filter,
        List<Property> property,
        List<ConceptDefinition> concept) implements DomainResource {

    /**
     * Creates a {@code CodeSystem}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public CodeSystem {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        topic = topic == null ? List.of() : List.copyOf(topic);
        author = author == null ? List.of() : List.copyOf(author);
        editor = editor == null ? List.of() : List.copyOf(editor);
        reviewer = reviewer == null ? List.of() : List.copyOf(reviewer);
        endorser = endorser == null ? List.of() : List.copyOf(endorser);
        relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
        filter = filter == null ? List.of() : List.copyOf(filter);
        property = property == null ? List.of() : List.copyOf(property);
        concept = concept == null ? List.of() : List.copyOf(concept);
        Objects.requireNonNull(status, "CodeSystem.status is required");
        Objects.requireNonNull(content, "CodeSystem.content is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "CodeSystem.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code CodeSystem}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A filter that can be used in a value set compose statement when selecting concepts using a filter.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Code that identifies the filter. Required.
     * @param description How or why the filter is used.
     * @param operator = | is-a | descendent-of | is-not-a | regex | in | not-in | generalizes | child-of |
     *   descendent-leaf | exists. Required.
     * @param value What to use for the value. Required.
     */
    public record Filter(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCode code,
            FhirString description,
            List<FhirEnum<FilterOperator>> operator,
            FhirString value) implements BackboneElement {

        /**
         * Creates a {@code Filter}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Filter {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            operator = operator == null ? List.of() : List.copyOf(operator);
            Objects.requireNonNull(code, "CodeSystem.filter.code is required");
            if (operator.isEmpty()) {
                throw new IllegalArgumentException("CodeSystem.filter.operator requires at least one value");
            }
            Objects.requireNonNull(value, "CodeSystem.filter.value is required");
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
         * Returns a builder initialized with the values of this {@code Filter}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Filter}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCode code;
            private FhirString description;
            private List<FhirEnum<FilterOperator>> operator = new ArrayList<>();
            private FhirString value;

            private Builder() {
            }

            private Builder(Filter original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.description = original.description();
                this.operator = new ArrayList<>(original.operator());
                this.value = original.value();
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
             * Sets {@code description}.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(FhirString description) {
                this.description = description;
                return this;
            }

            /**
             * Sets {@code description}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(String description) {
                return description(description == null ? null : FhirString.of(description));
            }

            /**
             * Replaces all {@code operator} values.
             *
             * @param operator the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder operator(List<FhirEnum<FilterOperator>> operator) {
                this.operator = operator == null ? new ArrayList<>() : new ArrayList<>(operator);
                return this;
            }

            /**
             * Adds a {@code operator} value.
             *
             * @param operator the value to add
             * @return this builder
             */
            public Builder addOperator(FhirEnum<FilterOperator> operator) {
                this.operator.add(Objects.requireNonNull(operator, "operator"));
                return this;
            }

            /**
             * Adds a {@code operator} value, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param operator the value to add
             * @return this builder
             */
            public Builder addOperator(FilterOperator operator) {
                return addOperator(FhirEnum.of(operator));
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
             * Builds the {@code Filter}.
             *
             * @return the {@code Filter}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Filter build() {
                return new Filter(
                        id, extension, modifierExtension, code, description, operator, value);
            }
        }
    }

    /**
     * A property defines an additional slot through which additional information can be provided about a concept.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Identifies the property on the concepts, and when referred to in operations. Required.
     * @param uri Formal identifier for the property.
     * @param description Why the property is defined, and/or what it conveys.
     * @param type code | Coding | string | integer | boolean | dateTime | decimal. Required.
     */
    public record Property(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCode code,
            FhirUri uri,
            FhirString description,
            FhirEnum<PropertyType> type) implements BackboneElement {

        /**
         * Creates a {@code Property}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Property {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(code, "CodeSystem.property.code is required");
            Objects.requireNonNull(type, "CodeSystem.property.type is required");
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
         * Returns a builder initialized with the values of this {@code Property}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Property}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCode code;
            private FhirUri uri;
            private FhirString description;
            private FhirEnum<PropertyType> type;

            private Builder() {
            }

            private Builder(Property original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.uri = original.uri();
                this.description = original.description();
                this.type = original.type();
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
             * Sets {@code uri}.
             *
             * @param uri the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder uri(FhirUri uri) {
                this.uri = uri;
                return this;
            }

            /**
             * Sets {@code uri}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param uri the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder uri(String uri) {
                return uri(uri == null ? null : FhirUri.of(uri));
            }

            /**
             * Sets {@code description}.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(FhirString description) {
                this.description = description;
                return this;
            }

            /**
             * Sets {@code description}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(String description) {
                return description(description == null ? null : FhirString.of(description));
            }

            /**
             * Sets {@code type}.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(FhirEnum<PropertyType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(PropertyType type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Builds the {@code Property}.
             *
             * @return the {@code Property}
             * @throws NullPointerException if a required element is absent
             */
            public Property build() {
                return new Property(
                        id, extension, modifierExtension, code, uri, description, type);
            }
        }
    }

    /**
     * Concepts that are in the code system.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Code that identifies concept. Required.
     * @param display Text to display to the user.
     * @param definition Formal definition.
     * @param designation Additional representations for the concept.
     * @param property Property value for the concept.
     * @param concept Child Concepts (is-a/contains/categorizes).
     */
    public record ConceptDefinition(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCode code,
            FhirString display,
            FhirString definition,
            List<Designation> designation,
            List<ConceptProperty> property,
            List<CodeSystem.ConceptDefinition> concept) implements BackboneElement {

        /**
         * Creates a {@code ConceptDefinition}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ConceptDefinition {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            designation = designation == null ? List.of() : List.copyOf(designation);
            property = property == null ? List.of() : List.copyOf(property);
            concept = concept == null ? List.of() : List.copyOf(concept);
            Objects.requireNonNull(code, "CodeSystem.concept.code is required");
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
         * Returns a builder initialized with the values of this {@code ConceptDefinition}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Additional representations for the concept - other languages, aliases, specialized purposes, used for
         * particular purposes, etc.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param language Human language of the designation.
         * @param use Details how this designation would be used.
         * @param additionalUse Additional ways how this designation would be used.
         * @param value The text value for this designation. Required.
         */
        public record Designation(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirCode language,
                Coding use,
                List<Coding> additionalUse,
                FhirString value) implements BackboneElement {

            /**
             * Creates a {@code Designation}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Designation {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                additionalUse = additionalUse == null ? List.of() : List.copyOf(additionalUse);
                Objects.requireNonNull(value, "CodeSystem.concept.designation.value is required");
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
             * Returns a builder initialized with the values of this {@code Designation}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Designation}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirCode language;
                private Coding use;
                private List<Coding> additionalUse = new ArrayList<>();
                private FhirString value;

                private Builder() {
                }

                private Builder(Designation original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.language = original.language();
                    this.use = original.use();
                    this.additionalUse = new ArrayList<>(original.additionalUse());
                    this.value = original.value();
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
                 * Sets {@code use}.
                 *
                 * @param use the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder use(Coding use) {
                    this.use = use;
                    return this;
                }

                /**
                 * Replaces all {@code additionalUse} values.
                 *
                 * @param additionalUse the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder additionalUse(List<Coding> additionalUse) {
                    this.additionalUse = additionalUse == null ? new ArrayList<>() : new ArrayList<>(additionalUse);
                    return this;
                }

                /**
                 * Adds a {@code additionalUse} value.
                 *
                 * @param additionalUse the value to add
                 * @return this builder
                 */
                public Builder addAdditionalUse(Coding additionalUse) {
                    this.additionalUse.add(Objects.requireNonNull(additionalUse, "additionalUse"));
                    return this;
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
                 * Builds the {@code Designation}.
                 *
                 * @return the {@code Designation}
                 * @throws NullPointerException if a required element is absent
                 */
                public Designation build() {
                    return new Designation(
                            id, extension, modifierExtension, language, use, additionalUse, value);
                }
            }
        }

        /**
         * A property value for this concept.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code Reference to CodeSystem.property.code. Required.
         * @param value Value of the property for this concept. One of code, Coding, string, integer, boolean,
         *   dateTime, decimal. Required.
         */
        public record ConceptProperty(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirCode code,
                DataType value) implements BackboneElement {

            /**
             * Creates a {@code ConceptProperty}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public ConceptProperty {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(code, "CodeSystem.concept.property.code is required");
                Objects.requireNonNull(value, "CodeSystem.concept.property.value is required");
                if (value != null && !(value instanceof FhirCode
                        || value instanceof FhirEnum<?>
                        || value instanceof Coding
                        || value instanceof FhirString
                        || value instanceof FhirInteger
                        || value instanceof FhirBoolean
                        || value instanceof FhirDateTime
                        || value instanceof FhirDecimal)) {
                    throw new IllegalArgumentException(
                            "CodeSystem.concept.property.value[x] does not allow "
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
             * Returns a builder initialized with the values of this {@code ConceptProperty}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link ConceptProperty}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirCode code;
                private DataType value;

                private Builder() {
                }

                private Builder(ConceptProperty original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.code = original.code();
                    this.value = original.value();
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
                 * Sets {@code value} to a code.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirCode value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a code bound to an enum.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirEnum<?> value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a Coding.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Coding value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a string.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirString value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a integer.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirInteger value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a boolean.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirBoolean value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a dateTime.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirDateTime value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a decimal.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirDecimal value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a integer without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Integer value) {
                    this.value = value == null ? null : FhirInteger.of(value);
                    return this;
                }

                /**
                 * Sets {@code value} to a boolean without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Boolean value) {
                    this.value = value == null ? null : FhirBoolean.of(value);
                    return this;
                }

                /**
                 * Sets {@code value} to a dateTime without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Temporal value) {
                    this.value = value == null ? null : FhirDateTime.of(value);
                    return this;
                }

                /**
                 * Sets {@code value} to a decimal without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(BigDecimal value) {
                    this.value = value == null ? null : FhirDecimal.of(value);
                    return this;
                }

                /**
                 * Builds the {@code ConceptProperty}.
                 *
                 * @return the {@code ConceptProperty}
                 * @throws NullPointerException if a required element is absent
                 */
                public ConceptProperty build() {
                    return new ConceptProperty(
                            id, extension, modifierExtension, code, value);
                }
            }
        }

        /** Builder for {@link ConceptDefinition}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCode code;
            private FhirString display;
            private FhirString definition;
            private List<Designation> designation = new ArrayList<>();
            private List<ConceptProperty> property = new ArrayList<>();
            private List<CodeSystem.ConceptDefinition> concept = new ArrayList<>();

            private Builder() {
            }

            private Builder(ConceptDefinition original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.display = original.display();
                this.definition = original.definition();
                this.designation = new ArrayList<>(original.designation());
                this.property = new ArrayList<>(original.property());
                this.concept = new ArrayList<>(original.concept());
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
             * Sets {@code definition}.
             *
             * @param definition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definition(FhirString definition) {
                this.definition = definition;
                return this;
            }

            /**
             * Sets {@code definition}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param definition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definition(String definition) {
                return definition(definition == null ? null : FhirString.of(definition));
            }

            /**
             * Replaces all {@code designation} values.
             *
             * @param designation the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder designation(List<Designation> designation) {
                this.designation = designation == null ? new ArrayList<>() : new ArrayList<>(designation);
                return this;
            }

            /**
             * Adds a {@code designation} value.
             *
             * @param designation the value to add
             * @return this builder
             */
            public Builder addDesignation(Designation designation) {
                this.designation.add(Objects.requireNonNull(designation, "designation"));
                return this;
            }

            /**
             * Replaces all {@code property} values.
             *
             * @param property the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder property(List<ConceptProperty> property) {
                this.property = property == null ? new ArrayList<>() : new ArrayList<>(property);
                return this;
            }

            /**
             * Adds a {@code property} value.
             *
             * @param property the value to add
             * @return this builder
             */
            public Builder addProperty(ConceptProperty property) {
                this.property.add(Objects.requireNonNull(property, "property"));
                return this;
            }

            /**
             * Replaces all {@code concept} values.
             *
             * @param concept the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder concept(List<CodeSystem.ConceptDefinition> concept) {
                this.concept = concept == null ? new ArrayList<>() : new ArrayList<>(concept);
                return this;
            }

            /**
             * Adds a {@code concept} value.
             *
             * @param concept the value to add
             * @return this builder
             */
            public Builder addConcept(CodeSystem.ConceptDefinition concept) {
                this.concept.add(Objects.requireNonNull(concept, "concept"));
                return this;
            }

            /**
             * Builds the {@code ConceptDefinition}.
             *
             * @return the {@code ConceptDefinition}
             * @throws NullPointerException if a required element is absent
             */
            public ConceptDefinition build() {
                return new ConceptDefinition(
                        id, extension, modifierExtension, code, display, definition, designation, property, concept);
            }
        }
    }

    /** Builder for {@link CodeSystem}. Builders are mutable and not thread-safe. */
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
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private Period effectivePeriod;
        private List<CodeableConcept> topic = new ArrayList<>();
        private List<ContactDetail> author = new ArrayList<>();
        private List<ContactDetail> editor = new ArrayList<>();
        private List<ContactDetail> reviewer = new ArrayList<>();
        private List<ContactDetail> endorser = new ArrayList<>();
        private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
        private FhirBoolean caseSensitive;
        private FhirCanonical valueSet;
        private FhirEnum<CodeSystemHierarchyMeaning> hierarchyMeaning;
        private FhirBoolean compositional;
        private FhirBoolean versionNeeded;
        private FhirEnum<CodeSystemContentMode> content;
        private FhirCanonical supplements;
        private FhirUnsignedInt count;
        private List<Filter> filter = new ArrayList<>();
        private List<Property> property = new ArrayList<>();
        private List<ConceptDefinition> concept = new ArrayList<>();

        private Builder() {
        }

        private Builder(CodeSystem original) {
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
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.effectivePeriod = original.effectivePeriod();
            this.topic = new ArrayList<>(original.topic());
            this.author = new ArrayList<>(original.author());
            this.editor = new ArrayList<>(original.editor());
            this.reviewer = new ArrayList<>(original.reviewer());
            this.endorser = new ArrayList<>(original.endorser());
            this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
            this.caseSensitive = original.caseSensitive();
            this.valueSet = original.valueSet();
            this.hierarchyMeaning = original.hierarchyMeaning();
            this.compositional = original.compositional();
            this.versionNeeded = original.versionNeeded();
            this.content = original.content();
            this.supplements = original.supplements();
            this.count = original.count();
            this.filter = new ArrayList<>(original.filter());
            this.property = new ArrayList<>(original.property());
            this.concept = new ArrayList<>(original.concept());
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
         * Sets {@code approvalDate}.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(FhirDate approvalDate) {
            this.approvalDate = approvalDate;
            return this;
        }

        /**
         * Sets {@code approvalDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(Temporal approvalDate) {
            return approvalDate(approvalDate == null ? null : FhirDate.of(approvalDate));
        }

        /**
         * Sets {@code lastReviewDate}.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(FhirDate lastReviewDate) {
            this.lastReviewDate = lastReviewDate;
            return this;
        }

        /**
         * Sets {@code lastReviewDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(Temporal lastReviewDate) {
            return lastReviewDate(lastReviewDate == null ? null : FhirDate.of(lastReviewDate));
        }

        /**
         * Sets {@code effectivePeriod}.
         *
         * @param effectivePeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effectivePeriod(Period effectivePeriod) {
            this.effectivePeriod = effectivePeriod;
            return this;
        }

        /**
         * Replaces all {@code topic} values.
         *
         * @param topic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder topic(List<CodeableConcept> topic) {
            this.topic = topic == null ? new ArrayList<>() : new ArrayList<>(topic);
            return this;
        }

        /**
         * Adds a {@code topic} value.
         *
         * @param topic the value to add
         * @return this builder
         */
        public Builder addTopic(CodeableConcept topic) {
            this.topic.add(Objects.requireNonNull(topic, "topic"));
            return this;
        }

        /**
         * Replaces all {@code author} values.
         *
         * @param author the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder author(List<ContactDetail> author) {
            this.author = author == null ? new ArrayList<>() : new ArrayList<>(author);
            return this;
        }

        /**
         * Adds a {@code author} value.
         *
         * @param author the value to add
         * @return this builder
         */
        public Builder addAuthor(ContactDetail author) {
            this.author.add(Objects.requireNonNull(author, "author"));
            return this;
        }

        /**
         * Replaces all {@code editor} values.
         *
         * @param editor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder editor(List<ContactDetail> editor) {
            this.editor = editor == null ? new ArrayList<>() : new ArrayList<>(editor);
            return this;
        }

        /**
         * Adds a {@code editor} value.
         *
         * @param editor the value to add
         * @return this builder
         */
        public Builder addEditor(ContactDetail editor) {
            this.editor.add(Objects.requireNonNull(editor, "editor"));
            return this;
        }

        /**
         * Replaces all {@code reviewer} values.
         *
         * @param reviewer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reviewer(List<ContactDetail> reviewer) {
            this.reviewer = reviewer == null ? new ArrayList<>() : new ArrayList<>(reviewer);
            return this;
        }

        /**
         * Adds a {@code reviewer} value.
         *
         * @param reviewer the value to add
         * @return this builder
         */
        public Builder addReviewer(ContactDetail reviewer) {
            this.reviewer.add(Objects.requireNonNull(reviewer, "reviewer"));
            return this;
        }

        /**
         * Replaces all {@code endorser} values.
         *
         * @param endorser the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder endorser(List<ContactDetail> endorser) {
            this.endorser = endorser == null ? new ArrayList<>() : new ArrayList<>(endorser);
            return this;
        }

        /**
         * Adds a {@code endorser} value.
         *
         * @param endorser the value to add
         * @return this builder
         */
        public Builder addEndorser(ContactDetail endorser) {
            this.endorser.add(Objects.requireNonNull(endorser, "endorser"));
            return this;
        }

        /**
         * Replaces all {@code relatedArtifact} values.
         *
         * @param relatedArtifact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relatedArtifact(List<RelatedArtifact> relatedArtifact) {
            this.relatedArtifact = relatedArtifact == null ? new ArrayList<>() : new ArrayList<>(relatedArtifact);
            return this;
        }

        /**
         * Adds a {@code relatedArtifact} value.
         *
         * @param relatedArtifact the value to add
         * @return this builder
         */
        public Builder addRelatedArtifact(RelatedArtifact relatedArtifact) {
            this.relatedArtifact.add(Objects.requireNonNull(relatedArtifact, "relatedArtifact"));
            return this;
        }

        /**
         * Sets {@code caseSensitive}.
         *
         * @param caseSensitive the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder caseSensitive(FhirBoolean caseSensitive) {
            this.caseSensitive = caseSensitive;
            return this;
        }

        /**
         * Sets {@code caseSensitive}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param caseSensitive the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder caseSensitive(Boolean caseSensitive) {
            return caseSensitive(caseSensitive == null ? null : FhirBoolean.of(caseSensitive));
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
         * Sets {@code hierarchyMeaning}.
         *
         * @param hierarchyMeaning the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder hierarchyMeaning(FhirEnum<CodeSystemHierarchyMeaning> hierarchyMeaning) {
            this.hierarchyMeaning = hierarchyMeaning;
            return this;
        }

        /**
         * Sets {@code hierarchyMeaning}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param hierarchyMeaning the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder hierarchyMeaning(CodeSystemHierarchyMeaning hierarchyMeaning) {
            return hierarchyMeaning(hierarchyMeaning == null ? null : FhirEnum.of(hierarchyMeaning));
        }

        /**
         * Sets {@code compositional}.
         *
         * @param compositional the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder compositional(FhirBoolean compositional) {
            this.compositional = compositional;
            return this;
        }

        /**
         * Sets {@code compositional}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param compositional the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder compositional(Boolean compositional) {
            return compositional(compositional == null ? null : FhirBoolean.of(compositional));
        }

        /**
         * Sets {@code versionNeeded}.
         *
         * @param versionNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionNeeded(FhirBoolean versionNeeded) {
            this.versionNeeded = versionNeeded;
            return this;
        }

        /**
         * Sets {@code versionNeeded}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param versionNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionNeeded(Boolean versionNeeded) {
            return versionNeeded(versionNeeded == null ? null : FhirBoolean.of(versionNeeded));
        }

        /**
         * Sets {@code content}.
         *
         * @param content the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder content(FhirEnum<CodeSystemContentMode> content) {
            this.content = content;
            return this;
        }

        /**
         * Sets {@code content}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param content the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder content(CodeSystemContentMode content) {
            return content(content == null ? null : FhirEnum.of(content));
        }

        /**
         * Sets {@code supplements}.
         *
         * @param supplements the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder supplements(FhirCanonical supplements) {
            this.supplements = supplements;
            return this;
        }

        /**
         * Sets {@code supplements}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param supplements the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder supplements(String supplements) {
            return supplements(supplements == null ? null : FhirCanonical.of(supplements));
        }

        /**
         * Sets {@code count}.
         *
         * @param count the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder count(FhirUnsignedInt count) {
            this.count = count;
            return this;
        }

        /**
         * Sets {@code count}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
         *
         * @param count the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder count(Integer count) {
            return count(count == null ? null : FhirUnsignedInt.of(count));
        }

        /**
         * Replaces all {@code filter} values.
         *
         * @param filter the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder filter(List<Filter> filter) {
            this.filter = filter == null ? new ArrayList<>() : new ArrayList<>(filter);
            return this;
        }

        /**
         * Adds a {@code filter} value.
         *
         * @param filter the value to add
         * @return this builder
         */
        public Builder addFilter(Filter filter) {
            this.filter.add(Objects.requireNonNull(filter, "filter"));
            return this;
        }

        /**
         * Replaces all {@code property} values.
         *
         * @param property the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder property(List<Property> property) {
            this.property = property == null ? new ArrayList<>() : new ArrayList<>(property);
            return this;
        }

        /**
         * Adds a {@code property} value.
         *
         * @param property the value to add
         * @return this builder
         */
        public Builder addProperty(Property property) {
            this.property.add(Objects.requireNonNull(property, "property"));
            return this;
        }

        /**
         * Replaces all {@code concept} values.
         *
         * @param concept the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder concept(List<ConceptDefinition> concept) {
            this.concept = concept == null ? new ArrayList<>() : new ArrayList<>(concept);
            return this;
        }

        /**
         * Adds a {@code concept} value.
         *
         * @param concept the value to add
         * @return this builder
         */
        public Builder addConcept(ConceptDefinition concept) {
            this.concept.add(Objects.requireNonNull(concept, "concept"));
            return this;
        }

        /**
         * Builds the {@code CodeSystem}.
         *
         * @return the {@code CodeSystem}
         * @throws NullPointerException if a required element is absent
         */
        public CodeSystem build() {
            return new CodeSystem(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, approvalDate,
                    lastReviewDate, effectivePeriod, topic, author, editor, reviewer, endorser, relatedArtifact,
                    caseSensitive, valueSet, hierarchyMeaning, compositional, versionNeeded, content, supplements,
                    count, filter, property, concept);
        }
    }
}
