package se.poroli.fhirplace.r5.conceptmap;

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
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A statement of relationships from one set of concepts to one or more other concepts - either concepts in code
 * systems, or data element/data element concepts, or classes in class models.
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
 * @param url Canonical identifier for this concept map, represented as a URI (globally unique).
 * @param identifier Additional identifier for the concept map.
 * @param version Business version of the concept map.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this concept map (computer friendly).
 * @param title Name for this concept map (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the concept map.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for concept map (if applicable).
 * @param purpose Why this concept map is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param approvalDate When the ConceptMap was approved by publisher.
 * @param lastReviewDate When the ConceptMap was last reviewed by the publisher.
 * @param effectivePeriod When the ConceptMap is expected to be used.
 * @param topic E.g. Education, Treatment, Assessment, etc.
 * @param author Who authored the ConceptMap.
 * @param editor Who edited the ConceptMap.
 * @param reviewer Who reviewed the ConceptMap.
 * @param endorser Who endorsed the ConceptMap.
 * @param relatedArtifact Additional documentation, citations, etc.
 * @param property Additional properties of the mapping.
 * @param additionalAttribute Definition of an additional attribute to act as a data source or target.
 * @param sourceScope The source value set that contains the concepts that are being mapped. One of uri, canonical.
 * @param targetScope The target value set which provides context for the mappings. One of uri, canonical.
 * @param group Same source and target systems.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ConceptMap">FHIR R5 ConceptMap</a>
 */
public record ConceptMap(
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
        List<Property> property,
        List<AdditionalAttribute> additionalAttribute,
        DataType sourceScope,
        DataType targetScope,
        List<Group> group) implements DomainResource {

    /**
     * Creates a {@code ConceptMap}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ConceptMap {
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
        property = property == null ? List.of() : List.copyOf(property);
        additionalAttribute = additionalAttribute == null ? List.of() : List.copyOf(additionalAttribute);
        group = group == null ? List.of() : List.copyOf(group);
        Objects.requireNonNull(status, "ConceptMap.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "ConceptMap.versionAlgorithm[x] must be one of string, Coding, but was "
                            + versionAlgorithm.getClass().getSimpleName());
        }
        if (sourceScope != null && !(sourceScope instanceof FhirUri || sourceScope instanceof FhirCanonical)) {
            throw new IllegalArgumentException(
                    "ConceptMap.sourceScope[x] must be one of uri, canonical, but was "
                            + sourceScope.getClass().getSimpleName());
        }
        if (targetScope != null && !(targetScope instanceof FhirUri || targetScope instanceof FhirCanonical)) {
            throw new IllegalArgumentException(
                    "ConceptMap.targetScope[x] must be one of uri, canonical, but was "
                            + targetScope.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code ConceptMap}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A property defines a slot through which additional information can be provided about a map from source -&gt;
     * target.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Identifies the property on the mappings, and when referred to in the $translate operation.
     *   Required.
     * @param uri Formal identifier for the property.
     * @param description Why the property is defined, and/or what it conveys.
     * @param type Coding | string | integer | boolean | dateTime | decimal | code. Required.
     * @param system The CodeSystem from which code values come. Canonical reference to CodeSystem.
     */
    public record Property(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCode code,
            FhirUri uri,
            FhirString description,
            FhirEnum<ConceptMapPropertyType> type,
            FhirCanonical system) implements BackboneElement {

        /**
         * Creates a {@code Property}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Property {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(code, "ConceptMap.property.code is required");
            Objects.requireNonNull(type, "ConceptMap.property.type is required");
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
            private FhirEnum<ConceptMapPropertyType> type;
            private FhirCanonical system;

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
                this.system = original.system();
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
            public Builder type(FhirEnum<ConceptMapPropertyType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(ConceptMapPropertyType type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Sets {@code system}.
             *
             * @param system the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder system(FhirCanonical system) {
                this.system = system;
                return this;
            }

            /**
             * Sets {@code system}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param system the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder system(String system) {
                return system(system == null ? null : FhirCanonical.of(system));
            }

            /**
             * Builds the {@code Property}.
             *
             * @return the {@code Property}
             * @throws NullPointerException if a required element is absent
             */
            public Property build() {
                return new Property(
                        id, extension, modifierExtension, code, uri, description, type, system);
            }
        }
    }

    /**
     * An additionalAttribute defines an additional data element found in the source or target data model where the
     * data will come from or be mapped to.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Identifies this additional attribute through this resource. Required.
     * @param uri Formal identifier for the data element referred to in this attribte.
     * @param description Why the additional attribute is defined, and/or what the data element it refers to is.
     * @param type code | Coding | string | boolean | Quantity. Required.
     */
    public record AdditionalAttribute(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCode code,
            FhirUri uri,
            FhirString description,
            FhirEnum<ConceptMapAttributeType> type) implements BackboneElement {

        /**
         * Creates an {@code AdditionalAttribute}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public AdditionalAttribute {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(code, "ConceptMap.additionalAttribute.code is required");
            Objects.requireNonNull(type, "ConceptMap.additionalAttribute.type is required");
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
         * Returns a builder initialized with the values of this {@code AdditionalAttribute}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link AdditionalAttribute}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCode code;
            private FhirUri uri;
            private FhirString description;
            private FhirEnum<ConceptMapAttributeType> type;

            private Builder() {
            }

            private Builder(AdditionalAttribute original) {
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
            public Builder type(FhirEnum<ConceptMapAttributeType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(ConceptMapAttributeType type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Builds the {@code AdditionalAttribute}.
             *
             * @return the {@code AdditionalAttribute}
             * @throws NullPointerException if a required element is absent
             */
            public AdditionalAttribute build() {
                return new AdditionalAttribute(
                        id, extension, modifierExtension, code, uri, description, type);
            }
        }
    }

    /**
     * A group of mappings that all have the same source and target system.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param source Source system where concepts to be mapped are defined. Canonical reference to CodeSystem.
     * @param target Target system that the concepts are to be mapped to. Canonical reference to CodeSystem.
     * @param element Mappings for a concept from the source set. Required.
     * @param unmapped What to do when there is no mapping target for the source concept and
     *   ConceptMap.group.element.noMap is not true.
     */
    public record Group(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCanonical source,
            FhirCanonical target,
            List<SourceElement> element,
            Unmapped unmapped) implements BackboneElement {

        /**
         * Creates a {@code Group}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Group {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            element = element == null ? List.of() : List.copyOf(element);
            if (element.isEmpty()) {
                throw new IllegalArgumentException("ConceptMap.group.element requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Group}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Mappings for an individual concept in the source to one or more concepts in the target.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code Identifies element being mapped.
         * @param display Display for the code.
         * @param valueSet Identifies the set of concepts being mapped. Canonical reference to ValueSet.
         * @param noMap No mapping to a target concept for this source concept.
         * @param target Concept in target system for element.
         */
        public record SourceElement(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirCode code,
                FhirString display,
                FhirCanonical valueSet,
                FhirBoolean noMap,
                List<TargetElement> target) implements BackboneElement {

            /**
             * Creates a {@code SourceElement}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public SourceElement {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                target = target == null ? List.of() : List.copyOf(target);
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
             * Returns a builder initialized with the values of this {@code SourceElement}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * A concept from the target value set that this concept maps to.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param code Code that identifies the target element.
             * @param display Display for the code.
             * @param valueSet Identifies the set of target concepts. Canonical reference to ValueSet.
             * @param relationship related-to | equivalent | source-is-narrower-than-target |
             *   source-is-broader-than-target | not-related-to. Required. Modifier element.
             * @param comment Description of status/issues in mapping.
             * @param property Property value for the source -&gt; target mapping.
             * @param dependsOn Other properties required for this mapping.
             * @param product Other data elements that this mapping also produces.
             */
            public record TargetElement(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirCode code,
                    FhirString display,
                    FhirCanonical valueSet,
                    FhirEnum<ConceptMapRelationship> relationship,
                    FhirString comment,
                    List<MappingProperty> property,
                    List<OtherElement> dependsOn,
                    List<ConceptMap.Group.SourceElement.TargetElement.OtherElement> product) implements BackboneElement {

                /**
                 * Creates a {@code TargetElement}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public TargetElement {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    property = property == null ? List.of() : List.copyOf(property);
                    dependsOn = dependsOn == null ? List.of() : List.copyOf(dependsOn);
                    product = product == null ? List.of() : List.copyOf(product);
                    Objects.requireNonNull(relationship, "ConceptMap.group.element.target.relationship is required");
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
                 * Returns a builder initialized with the values of this {@code TargetElement}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /**
                 * A property value for this source -&gt; target mapping.
                 *
                 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
                 * Instances are usually created with {@link #builder()}.
                 *
                 * @param id Unique id for inter-element referencing.
                 * @param extension Additional content defined by implementations.
                 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
                 * @param code Reference to ConceptMap.property.code. Required.
                 * @param value Value of the property for this concept. One of Coding, string, integer, boolean,
                 *   dateTime, decimal, code. Required.
                 */
                public record MappingProperty(
                        String id,
                        List<Extension> extension,
                        List<Extension> modifierExtension,
                        FhirCode code,
                        DataType value) implements BackboneElement {

                    /**
                     * Creates a {@code MappingProperty}, copying all lists.
                     *
                     * @throws NullPointerException if a required element is absent or a list contains {@code null}
                     * @throws IllegalArgumentException if a choice element has a type that is not allowed
                     */
                    public MappingProperty {
                        extension = extension == null ? List.of() : List.copyOf(extension);
                        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                        Objects.requireNonNull(code, "ConceptMap.group.element.target.property.code is required");
                        Objects.requireNonNull(value, "ConceptMap.group.element.target.property.value is required");
                        if (value != null && !(value instanceof Coding
                                || value instanceof FhirString
                                || value instanceof FhirInteger
                                || value instanceof FhirBoolean
                                || value instanceof FhirDateTime
                                || value instanceof FhirDecimal
                                || value instanceof FhirCode
                                || value instanceof FhirEnum<?>)) {
                            throw new IllegalArgumentException(
                                    "ConceptMap.group.element.target.property.value[x] does not allow "
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
                     * Returns a builder initialized with the values of this {@code MappingProperty}.
                     *
                     * @return the builder
                     */
                    public Builder toBuilder() {
                        return new Builder(this);
                    }

                    /** Builder for {@link MappingProperty}. Builders are mutable and not thread-safe. */
                    public static final class Builder {

                        private String id;
                        private List<Extension> extension = new ArrayList<>();
                        private List<Extension> modifierExtension = new ArrayList<>();
                        private FhirCode code;
                        private DataType value;

                        private Builder() {
                        }

                        private Builder(MappingProperty original) {
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
                            this.modifierExtension.add(
                                    Objects.requireNonNull(modifierExtension, "modifierExtension"));
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
                         * Builds the {@code MappingProperty}.
                         *
                         * @return the {@code MappingProperty}
                         * @throws NullPointerException if a required element is absent
                         */
                        public MappingProperty build() {
                            return new MappingProperty(
                                    id, extension, modifierExtension, code, value);
                        }
                    }
                }

                /**
                 * A set of additional dependencies for this mapping to hold.
                 *
                 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
                 * Instances are usually created with {@link #builder()}.
                 *
                 * @param id Unique id for inter-element referencing.
                 * @param extension Additional content defined by implementations.
                 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
                 * @param attribute A reference to a mapping attribute defined in ConceptMap.additionalAttribute.
                 *   Required.
                 * @param value Value of the referenced data element. One of code, Coding, string, boolean, Quantity.
                 * @param valueSet The mapping depends on a data element with a value from this value set. Canonical
                 *   reference to ValueSet.
                 */
                public record OtherElement(
                        String id,
                        List<Extension> extension,
                        List<Extension> modifierExtension,
                        FhirCode attribute,
                        DataType value,
                        FhirCanonical valueSet) implements BackboneElement {

                    /**
                     * Creates an {@code OtherElement}, copying all lists.
                     *
                     * @throws NullPointerException if a required element is absent or a list contains {@code null}
                     * @throws IllegalArgumentException if a choice element has a type that is not allowed
                     */
                    public OtherElement {
                        extension = extension == null ? List.of() : List.copyOf(extension);
                        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                        Objects.requireNonNull(
                                attribute, "ConceptMap.group.element.target.dependsOn.attribute is required");
                        if (value != null && !(value instanceof FhirCode
                                || value instanceof FhirEnum<?>
                                || value instanceof Coding
                                || value instanceof FhirString
                                || value instanceof FhirBoolean
                                || value instanceof Quantity)) {
                            throw new IllegalArgumentException(
                                    "ConceptMap.group.element.target.dependsOn.value[x] does not allow "
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
                     * Returns a builder initialized with the values of this {@code OtherElement}.
                     *
                     * @return the builder
                     */
                    public Builder toBuilder() {
                        return new Builder(this);
                    }

                    /** Builder for {@link OtherElement}. Builders are mutable and not thread-safe. */
                    public static final class Builder {

                        private String id;
                        private List<Extension> extension = new ArrayList<>();
                        private List<Extension> modifierExtension = new ArrayList<>();
                        private FhirCode attribute;
                        private DataType value;
                        private FhirCanonical valueSet;

                        private Builder() {
                        }

                        private Builder(OtherElement original) {
                            this.id = original.id();
                            this.extension = new ArrayList<>(original.extension());
                            this.modifierExtension = new ArrayList<>(original.modifierExtension());
                            this.attribute = original.attribute();
                            this.value = original.value();
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
                            this.modifierExtension.add(
                                    Objects.requireNonNull(modifierExtension, "modifierExtension"));
                            return this;
                        }

                        /**
                         * Sets {@code attribute}.
                         *
                         * @param attribute the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder attribute(FhirCode attribute) {
                            this.attribute = attribute;
                            return this;
                        }

                        /**
                         * Sets {@code attribute}, wrapped in a {@link FhirCode} without id or extensions.
                         *
                         * @param attribute the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder attribute(String attribute) {
                            return attribute(attribute == null ? null : FhirCode.of(attribute));
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
                         * Sets {@code value} to a Quantity.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(Quantity value) {
                            this.value = value;
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
                         * Builds the {@code OtherElement}.
                         *
                         * @return the {@code OtherElement}
                         * @throws NullPointerException if a required element is absent
                         */
                        public OtherElement build() {
                            return new OtherElement(
                                    id, extension, modifierExtension, attribute, value, valueSet);
                        }
                    }
                }

                /** Builder for {@link TargetElement}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirCode code;
                    private FhirString display;
                    private FhirCanonical valueSet;
                    private FhirEnum<ConceptMapRelationship> relationship;
                    private FhirString comment;
                    private List<MappingProperty> property = new ArrayList<>();
                    private List<OtherElement> dependsOn = new ArrayList<>();
                    private List<ConceptMap.Group.SourceElement.TargetElement.OtherElement> product =
                            new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(TargetElement original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.code = original.code();
                        this.display = original.display();
                        this.valueSet = original.valueSet();
                        this.relationship = original.relationship();
                        this.comment = original.comment();
                        this.property = new ArrayList<>(original.property());
                        this.dependsOn = new ArrayList<>(original.dependsOn());
                        this.product = new ArrayList<>(original.product());
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
                     * Sets {@code relationship}.
                     *
                     * @param relationship the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder relationship(FhirEnum<ConceptMapRelationship> relationship) {
                        this.relationship = relationship;
                        return this;
                    }

                    /**
                     * Sets {@code relationship}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param relationship the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder relationship(ConceptMapRelationship relationship) {
                        return relationship(relationship == null ? null : FhirEnum.of(relationship));
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
                     * Replaces all {@code property} values.
                     *
                     * @param property the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder property(List<MappingProperty> property) {
                        this.property = property == null ? new ArrayList<>() : new ArrayList<>(property);
                        return this;
                    }

                    /**
                     * Adds a {@code property} value.
                     *
                     * @param property the value to add
                     * @return this builder
                     */
                    public Builder addProperty(MappingProperty property) {
                        this.property.add(Objects.requireNonNull(property, "property"));
                        return this;
                    }

                    /**
                     * Replaces all {@code dependsOn} values.
                     *
                     * @param dependsOn the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder dependsOn(List<OtherElement> dependsOn) {
                        this.dependsOn = dependsOn == null ? new ArrayList<>() : new ArrayList<>(dependsOn);
                        return this;
                    }

                    /**
                     * Adds a {@code dependsOn} value.
                     *
                     * @param dependsOn the value to add
                     * @return this builder
                     */
                    public Builder addDependsOn(OtherElement dependsOn) {
                        this.dependsOn.add(Objects.requireNonNull(dependsOn, "dependsOn"));
                        return this;
                    }

                    /**
                     * Replaces all {@code product} values.
                     *
                     * @param product the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder product(List<ConceptMap.Group.SourceElement.TargetElement.OtherElement> product) {
                        this.product = product == null ? new ArrayList<>() : new ArrayList<>(product);
                        return this;
                    }

                    /**
                     * Adds a {@code product} value.
                     *
                     * @param product the value to add
                     * @return this builder
                     */
                    public Builder addProduct(ConceptMap.Group.SourceElement.TargetElement.OtherElement product) {
                        this.product.add(Objects.requireNonNull(product, "product"));
                        return this;
                    }

                    /**
                     * Builds the {@code TargetElement}.
                     *
                     * @return the {@code TargetElement}
                     * @throws NullPointerException if a required element is absent
                     */
                    public TargetElement build() {
                        return new TargetElement(
                                id, extension, modifierExtension, code, display, valueSet, relationship, comment,
                                property, dependsOn, product);
                    }
                }
            }

            /** Builder for {@link SourceElement}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirCode code;
                private FhirString display;
                private FhirCanonical valueSet;
                private FhirBoolean noMap;
                private List<TargetElement> target = new ArrayList<>();

                private Builder() {
                }

                private Builder(SourceElement original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.code = original.code();
                    this.display = original.display();
                    this.valueSet = original.valueSet();
                    this.noMap = original.noMap();
                    this.target = new ArrayList<>(original.target());
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
                 * Sets {@code noMap}.
                 *
                 * @param noMap the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder noMap(FhirBoolean noMap) {
                    this.noMap = noMap;
                    return this;
                }

                /**
                 * Sets {@code noMap}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param noMap the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder noMap(Boolean noMap) {
                    return noMap(noMap == null ? null : FhirBoolean.of(noMap));
                }

                /**
                 * Replaces all {@code target} values.
                 *
                 * @param target the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder target(List<TargetElement> target) {
                    this.target = target == null ? new ArrayList<>() : new ArrayList<>(target);
                    return this;
                }

                /**
                 * Adds a {@code target} value.
                 *
                 * @param target the value to add
                 * @return this builder
                 */
                public Builder addTarget(TargetElement target) {
                    this.target.add(Objects.requireNonNull(target, "target"));
                    return this;
                }

                /**
                 * Builds the {@code SourceElement}.
                 *
                 * @return the {@code SourceElement}
                 */
                public SourceElement build() {
                    return new SourceElement(
                            id, extension, modifierExtension, code, display, valueSet, noMap, target);
                }
            }
        }

        /**
         * What to do when there is no mapping to a target concept from the source concept and
         * ConceptMap.group.element.noMap is not true.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param mode use-source-code | fixed | other-map. Required.
         * @param code Fixed code when mode = fixed.
         * @param display Display for the code.
         * @param valueSet Fixed code set when mode = fixed. Canonical reference to ValueSet.
         * @param relationship related-to | equivalent | source-is-narrower-than-target |
         *   source-is-broader-than-target | not-related-to. Modifier element.
         * @param otherMap canonical reference to an additional ConceptMap to use for mapping if the source concept is
         *   unmapped. Canonical reference to ConceptMap.
         */
        public record Unmapped(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<ConceptMapGroupUnmappedMode> mode,
                FhirCode code,
                FhirString display,
                FhirCanonical valueSet,
                FhirEnum<ConceptMapRelationship> relationship,
                FhirCanonical otherMap) implements BackboneElement {

            /**
             * Creates an {@code Unmapped}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Unmapped {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(mode, "ConceptMap.group.unmapped.mode is required");
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
             * Returns a builder initialized with the values of this {@code Unmapped}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Unmapped}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<ConceptMapGroupUnmappedMode> mode;
                private FhirCode code;
                private FhirString display;
                private FhirCanonical valueSet;
                private FhirEnum<ConceptMapRelationship> relationship;
                private FhirCanonical otherMap;

                private Builder() {
                }

                private Builder(Unmapped original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.mode = original.mode();
                    this.code = original.code();
                    this.display = original.display();
                    this.valueSet = original.valueSet();
                    this.relationship = original.relationship();
                    this.otherMap = original.otherMap();
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
                 * Sets {@code mode}.
                 *
                 * @param mode the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder mode(FhirEnum<ConceptMapGroupUnmappedMode> mode) {
                    this.mode = mode;
                    return this;
                }

                /**
                 * Sets {@code mode}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param mode the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder mode(ConceptMapGroupUnmappedMode mode) {
                    return mode(mode == null ? null : FhirEnum.of(mode));
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
                 * Sets {@code relationship}.
                 *
                 * @param relationship the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relationship(FhirEnum<ConceptMapRelationship> relationship) {
                    this.relationship = relationship;
                    return this;
                }

                /**
                 * Sets {@code relationship}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param relationship the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relationship(ConceptMapRelationship relationship) {
                    return relationship(relationship == null ? null : FhirEnum.of(relationship));
                }

                /**
                 * Sets {@code otherMap}.
                 *
                 * @param otherMap the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder otherMap(FhirCanonical otherMap) {
                    this.otherMap = otherMap;
                    return this;
                }

                /**
                 * Sets {@code otherMap}, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param otherMap the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder otherMap(String otherMap) {
                    return otherMap(otherMap == null ? null : FhirCanonical.of(otherMap));
                }

                /**
                 * Builds the {@code Unmapped}.
                 *
                 * @return the {@code Unmapped}
                 * @throws NullPointerException if a required element is absent
                 */
                public Unmapped build() {
                    return new Unmapped(
                            id, extension, modifierExtension, mode, code, display, valueSet, relationship, otherMap);
                }
            }
        }

        /** Builder for {@link Group}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCanonical source;
            private FhirCanonical target;
            private List<SourceElement> element = new ArrayList<>();
            private Unmapped unmapped;

            private Builder() {
            }

            private Builder(Group original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.source = original.source();
                this.target = original.target();
                this.element = new ArrayList<>(original.element());
                this.unmapped = original.unmapped();
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
            public Builder source(FhirCanonical source) {
                this.source = source;
                return this;
            }

            /**
             * Sets {@code source}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param source the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder source(String source) {
                return source(source == null ? null : FhirCanonical.of(source));
            }

            /**
             * Sets {@code target}.
             *
             * @param target the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder target(FhirCanonical target) {
                this.target = target;
                return this;
            }

            /**
             * Sets {@code target}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param target the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder target(String target) {
                return target(target == null ? null : FhirCanonical.of(target));
            }

            /**
             * Replaces all {@code element} values.
             *
             * @param element the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder element(List<SourceElement> element) {
                this.element = element == null ? new ArrayList<>() : new ArrayList<>(element);
                return this;
            }

            /**
             * Adds a {@code element} value.
             *
             * @param element the value to add
             * @return this builder
             */
            public Builder addElement(SourceElement element) {
                this.element.add(Objects.requireNonNull(element, "element"));
                return this;
            }

            /**
             * Sets {@code unmapped}.
             *
             * @param unmapped the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder unmapped(Unmapped unmapped) {
                this.unmapped = unmapped;
                return this;
            }

            /**
             * Builds the {@code Group}.
             *
             * @return the {@code Group}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Group build() {
                return new Group(
                        id, extension, modifierExtension, source, target, element, unmapped);
            }
        }
    }

    /** Builder for {@link ConceptMap}. Builders are mutable and not thread-safe. */
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
        private List<Property> property = new ArrayList<>();
        private List<AdditionalAttribute> additionalAttribute = new ArrayList<>();
        private DataType sourceScope;
        private DataType targetScope;
        private List<Group> group = new ArrayList<>();

        private Builder() {
        }

        private Builder(ConceptMap original) {
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
            this.property = new ArrayList<>(original.property());
            this.additionalAttribute = new ArrayList<>(original.additionalAttribute());
            this.sourceScope = original.sourceScope();
            this.targetScope = original.targetScope();
            this.group = new ArrayList<>(original.group());
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
         * Replaces all {@code additionalAttribute} values.
         *
         * @param additionalAttribute the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder additionalAttribute(List<AdditionalAttribute> additionalAttribute) {
            this.additionalAttribute = additionalAttribute == null
                    ? new ArrayList<>()
                    : new ArrayList<>(additionalAttribute);
            return this;
        }

        /**
         * Adds a {@code additionalAttribute} value.
         *
         * @param additionalAttribute the value to add
         * @return this builder
         */
        public Builder addAdditionalAttribute(AdditionalAttribute additionalAttribute) {
            this.additionalAttribute.add(Objects.requireNonNull(additionalAttribute, "additionalAttribute"));
            return this;
        }

        /**
         * Sets {@code sourceScope} to a uri.
         *
         * @param sourceScope the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sourceScope(FhirUri sourceScope) {
            this.sourceScope = sourceScope;
            return this;
        }

        /**
         * Sets {@code sourceScope} to a canonical.
         *
         * @param sourceScope the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sourceScope(FhirCanonical sourceScope) {
            this.sourceScope = sourceScope;
            return this;
        }

        /**
         * Sets {@code targetScope} to a uri.
         *
         * @param targetScope the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder targetScope(FhirUri targetScope) {
            this.targetScope = targetScope;
            return this;
        }

        /**
         * Sets {@code targetScope} to a canonical.
         *
         * @param targetScope the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder targetScope(FhirCanonical targetScope) {
            this.targetScope = targetScope;
            return this;
        }

        /**
         * Replaces all {@code group} values.
         *
         * @param group the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder group(List<Group> group) {
            this.group = group == null ? new ArrayList<>() : new ArrayList<>(group);
            return this;
        }

        /**
         * Adds a {@code group} value.
         *
         * @param group the value to add
         * @return this builder
         */
        public Builder addGroup(Group group) {
            this.group.add(Objects.requireNonNull(group, "group"));
            return this;
        }

        /**
         * Builds the {@code ConceptMap}.
         *
         * @return the {@code ConceptMap}
         * @throws NullPointerException if a required element is absent
         */
        public ConceptMap build() {
            return new ConceptMap(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, approvalDate,
                    lastReviewDate, effectivePeriod, topic, author, editor, reviewer, endorser, relatedArtifact,
                    property, additionalAttribute, sourceScope, targetScope, group);
        }
    }
}
