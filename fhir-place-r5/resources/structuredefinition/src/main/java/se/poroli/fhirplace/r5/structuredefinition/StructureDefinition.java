package se.poroli.fhirplace.r5.structuredefinition;

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
import se.poroli.fhirplace.r5.datatypes.ElementDefinition;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.FHIRVersion;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A definition of a FHIR structure.
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
 * @param url Canonical identifier for this structure definition, represented as a URI (globally unique). Required.
 * @param identifier Additional identifier for the structure definition.
 * @param version Business version of the structure definition.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this structure definition (computer friendly). Required.
 * @param title Name for this structure definition (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the structure definition.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for structure definition (if applicable).
 * @param purpose Why this structure definition is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param keyword Assist with indexing and finding.
 * @param fhirVersion FHIR Version this StructureDefinition targets.
 * @param mapping External specification that the content is mapped to.
 * @param kind primitive-type | complex-type | resource | logical. Required.
 * @param abstractValue Whether the structure is abstract. The FHIR element {@code abstract}. Required.
 * @param context If an extension, where it can be used in instances.
 * @param contextInvariant FHIRPath invariants - when the extension can be used.
 * @param type Type defined or constrained by this structure. Required.
 * @param baseDefinition Definition that this type is constrained/specialized from. Canonical reference to
 *   StructureDefinition.
 * @param derivation specialization | constraint - How relates to base definition.
 * @param snapshot Snapshot view of the structure.
 * @param differential Differential view of the structure.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/StructureDefinition">FHIR R5 StructureDefinition</a>
 */
public record StructureDefinition(
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
        List<Coding> keyword,
        FhirEnum<FHIRVersion> fhirVersion,
        List<Mapping> mapping,
        FhirEnum<StructureDefinitionKind> kind,
        FhirBoolean abstractValue,
        List<Context> context,
        List<FhirString> contextInvariant,
        FhirUri type,
        FhirCanonical baseDefinition,
        FhirEnum<TypeDerivationRule> derivation,
        Snapshot snapshot,
        Differential differential) implements DomainResource {

    /**
     * Creates a {@code StructureDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public StructureDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        keyword = keyword == null ? List.of() : List.copyOf(keyword);
        mapping = mapping == null ? List.of() : List.copyOf(mapping);
        context = context == null ? List.of() : List.copyOf(context);
        contextInvariant = contextInvariant == null ? List.of() : List.copyOf(contextInvariant);
        Objects.requireNonNull(url, "StructureDefinition.url is required");
        Objects.requireNonNull(name, "StructureDefinition.name is required");
        Objects.requireNonNull(status, "StructureDefinition.status is required");
        Objects.requireNonNull(kind, "StructureDefinition.kind is required");
        Objects.requireNonNull(abstractValue, "StructureDefinition.abstract is required");
        Objects.requireNonNull(type, "StructureDefinition.type is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "StructureDefinition.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code StructureDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * An external specification that the content is mapped to.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identity Internal id when this mapping is used. Required.
     * @param uri Identifies what this mapping refers to.
     * @param name Names what this mapping refers to.
     * @param comment Versions, Issues, Scope limitations etc.
     */
    public record Mapping(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirId identity,
            FhirUri uri,
            FhirString name,
            FhirString comment) implements BackboneElement {

        /**
         * Creates a {@code Mapping}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Mapping {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(identity, "StructureDefinition.mapping.identity is required");
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
         * Returns a builder initialized with the values of this {@code Mapping}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Mapping}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirId identity;
            private FhirUri uri;
            private FhirString name;
            private FhirString comment;

            private Builder() {
            }

            private Builder(Mapping original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identity = original.identity();
                this.uri = original.uri();
                this.name = original.name();
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
             * Sets {@code identity}.
             *
             * @param identity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identity(FhirId identity) {
                this.identity = identity;
                return this;
            }

            /**
             * Sets {@code identity}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param identity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identity(String identity) {
                return identity(identity == null ? null : FhirId.of(identity));
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
             * Builds the {@code Mapping}.
             *
             * @return the {@code Mapping}
             * @throws NullPointerException if a required element is absent
             */
            public Mapping build() {
                return new Mapping(
                        id, extension, modifierExtension, identity, uri, name, comment);
            }
        }
    }

    /**
     * Identifies the types of resource or data type elements to which the extension can be applied.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type fhirpath | element | extension. Required.
     * @param expression Where the extension can be used in instances. Required.
     */
    public record Context(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<ExtensionContextType> type,
            FhirString expression) implements BackboneElement {

        /**
         * Creates a {@code Context}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Context {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "StructureDefinition.context.type is required");
            Objects.requireNonNull(expression, "StructureDefinition.context.expression is required");
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
         * Returns a builder initialized with the values of this {@code Context}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Context}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<ExtensionContextType> type;
            private FhirString expression;

            private Builder() {
            }

            private Builder(Context original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.expression = original.expression();
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
            public Builder type(FhirEnum<ExtensionContextType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(ExtensionContextType type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Sets {@code expression}.
             *
             * @param expression the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder expression(FhirString expression) {
                this.expression = expression;
                return this;
            }

            /**
             * Sets {@code expression}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param expression the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder expression(String expression) {
                return expression(expression == null ? null : FhirString.of(expression));
            }

            /**
             * Builds the {@code Context}.
             *
             * @return the {@code Context}
             * @throws NullPointerException if a required element is absent
             */
            public Context build() {
                return new Context(
                        id, extension, modifierExtension, type, expression);
            }
        }
    }

    /**
     * A snapshot view is expressed in a standalone form that can be used and interpreted without considering the base
     * StructureDefinition.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param element Definition of elements in the resource (if no StructureDefinition). Required.
     */
    public record Snapshot(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<ElementDefinition> element) implements BackboneElement {

        /**
         * Creates a {@code Snapshot}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Snapshot {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            element = element == null ? List.of() : List.copyOf(element);
            if (element.isEmpty()) {
                throw new IllegalArgumentException(
                        "StructureDefinition.snapshot.element requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Snapshot}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Snapshot}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<ElementDefinition> element = new ArrayList<>();

            private Builder() {
            }

            private Builder(Snapshot original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.element = new ArrayList<>(original.element());
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
             * Replaces all {@code element} values.
             *
             * @param element the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder element(List<ElementDefinition> element) {
                this.element = element == null ? new ArrayList<>() : new ArrayList<>(element);
                return this;
            }

            /**
             * Adds a {@code element} value.
             *
             * @param element the value to add
             * @return this builder
             */
            public Builder addElement(ElementDefinition element) {
                this.element.add(Objects.requireNonNull(element, "element"));
                return this;
            }

            /**
             * Builds the {@code Snapshot}.
             *
             * @return the {@code Snapshot}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Snapshot build() {
                return new Snapshot(
                        id, extension, modifierExtension, element);
            }
        }
    }

    /**
     * A differential view is expressed relative to the base StructureDefinition - a statement of differences that it
     * applies.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param element Definition of elements in the resource (if no StructureDefinition). Required.
     */
    public record Differential(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<ElementDefinition> element) implements BackboneElement {

        /**
         * Creates a {@code Differential}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Differential {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            element = element == null ? List.of() : List.copyOf(element);
            if (element.isEmpty()) {
                throw new IllegalArgumentException(
                        "StructureDefinition.differential.element requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Differential}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Differential}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<ElementDefinition> element = new ArrayList<>();

            private Builder() {
            }

            private Builder(Differential original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.element = new ArrayList<>(original.element());
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
             * Replaces all {@code element} values.
             *
             * @param element the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder element(List<ElementDefinition> element) {
                this.element = element == null ? new ArrayList<>() : new ArrayList<>(element);
                return this;
            }

            /**
             * Adds a {@code element} value.
             *
             * @param element the value to add
             * @return this builder
             */
            public Builder addElement(ElementDefinition element) {
                this.element.add(Objects.requireNonNull(element, "element"));
                return this;
            }

            /**
             * Builds the {@code Differential}.
             *
             * @return the {@code Differential}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Differential build() {
                return new Differential(
                        id, extension, modifierExtension, element);
            }
        }
    }

    /** Builder for {@link StructureDefinition}. Builders are mutable and not thread-safe. */
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
        private List<Coding> keyword = new ArrayList<>();
        private FhirEnum<FHIRVersion> fhirVersion;
        private List<Mapping> mapping = new ArrayList<>();
        private FhirEnum<StructureDefinitionKind> kind;
        private FhirBoolean abstractValue;
        private List<Context> context = new ArrayList<>();
        private List<FhirString> contextInvariant = new ArrayList<>();
        private FhirUri type;
        private FhirCanonical baseDefinition;
        private FhirEnum<TypeDerivationRule> derivation;
        private Snapshot snapshot;
        private Differential differential;

        private Builder() {
        }

        private Builder(StructureDefinition original) {
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
            this.keyword = new ArrayList<>(original.keyword());
            this.fhirVersion = original.fhirVersion();
            this.mapping = new ArrayList<>(original.mapping());
            this.kind = original.kind();
            this.abstractValue = original.abstractValue();
            this.context = new ArrayList<>(original.context());
            this.contextInvariant = new ArrayList<>(original.contextInvariant());
            this.type = original.type();
            this.baseDefinition = original.baseDefinition();
            this.derivation = original.derivation();
            this.snapshot = original.snapshot();
            this.differential = original.differential();
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
         * Replaces all {@code keyword} values.
         *
         * @param keyword the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder keyword(List<Coding> keyword) {
            this.keyword = keyword == null ? new ArrayList<>() : new ArrayList<>(keyword);
            return this;
        }

        /**
         * Adds a {@code keyword} value.
         *
         * @param keyword the value to add
         * @return this builder
         */
        public Builder addKeyword(Coding keyword) {
            this.keyword.add(Objects.requireNonNull(keyword, "keyword"));
            return this;
        }

        /**
         * Sets {@code fhirVersion}.
         *
         * @param fhirVersion the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder fhirVersion(FhirEnum<FHIRVersion> fhirVersion) {
            this.fhirVersion = fhirVersion;
            return this;
        }

        /**
         * Sets {@code fhirVersion}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param fhirVersion the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder fhirVersion(FHIRVersion fhirVersion) {
            return fhirVersion(fhirVersion == null ? null : FhirEnum.of(fhirVersion));
        }

        /**
         * Replaces all {@code mapping} values.
         *
         * @param mapping the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder mapping(List<Mapping> mapping) {
            this.mapping = mapping == null ? new ArrayList<>() : new ArrayList<>(mapping);
            return this;
        }

        /**
         * Adds a {@code mapping} value.
         *
         * @param mapping the value to add
         * @return this builder
         */
        public Builder addMapping(Mapping mapping) {
            this.mapping.add(Objects.requireNonNull(mapping, "mapping"));
            return this;
        }

        /**
         * Sets {@code kind}.
         *
         * @param kind the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder kind(FhirEnum<StructureDefinitionKind> kind) {
            this.kind = kind;
            return this;
        }

        /**
         * Sets {@code kind}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param kind the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder kind(StructureDefinitionKind kind) {
            return kind(kind == null ? null : FhirEnum.of(kind));
        }

        /**
         * Sets {@code abstractValue}.
         *
         * @param abstractValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder abstractValue(FhirBoolean abstractValue) {
            this.abstractValue = abstractValue;
            return this;
        }

        /**
         * Sets {@code abstractValue}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param abstractValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder abstractValue(Boolean abstractValue) {
            return abstractValue(abstractValue == null ? null : FhirBoolean.of(abstractValue));
        }

        /**
         * Replaces all {@code context} values.
         *
         * @param context the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder context(List<Context> context) {
            this.context = context == null ? new ArrayList<>() : new ArrayList<>(context);
            return this;
        }

        /**
         * Adds a {@code context} value.
         *
         * @param context the value to add
         * @return this builder
         */
        public Builder addContext(Context context) {
            this.context.add(Objects.requireNonNull(context, "context"));
            return this;
        }

        /**
         * Replaces all {@code contextInvariant} values.
         *
         * @param contextInvariant the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contextInvariant(List<FhirString> contextInvariant) {
            this.contextInvariant = contextInvariant == null ? new ArrayList<>() : new ArrayList<>(contextInvariant);
            return this;
        }

        /**
         * Adds a {@code contextInvariant} value.
         *
         * @param contextInvariant the value to add
         * @return this builder
         */
        public Builder addContextInvariant(FhirString contextInvariant) {
            this.contextInvariant.add(Objects.requireNonNull(contextInvariant, "contextInvariant"));
            return this;
        }

        /**
         * Adds a {@code contextInvariant} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param contextInvariant the value to add
         * @return this builder
         */
        public Builder addContextInvariant(String contextInvariant) {
            return addContextInvariant(FhirString.of(contextInvariant));
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
         * Sets {@code baseDefinition}.
         *
         * @param baseDefinition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder baseDefinition(FhirCanonical baseDefinition) {
            this.baseDefinition = baseDefinition;
            return this;
        }

        /**
         * Sets {@code baseDefinition}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param baseDefinition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder baseDefinition(String baseDefinition) {
            return baseDefinition(baseDefinition == null ? null : FhirCanonical.of(baseDefinition));
        }

        /**
         * Sets {@code derivation}.
         *
         * @param derivation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder derivation(FhirEnum<TypeDerivationRule> derivation) {
            this.derivation = derivation;
            return this;
        }

        /**
         * Sets {@code derivation}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param derivation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder derivation(TypeDerivationRule derivation) {
            return derivation(derivation == null ? null : FhirEnum.of(derivation));
        }

        /**
         * Sets {@code snapshot}.
         *
         * @param snapshot the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder snapshot(Snapshot snapshot) {
            this.snapshot = snapshot;
            return this;
        }

        /**
         * Sets {@code differential}.
         *
         * @param differential the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder differential(Differential differential) {
            this.differential = differential;
            return this;
        }

        /**
         * Builds the {@code StructureDefinition}.
         *
         * @return the {@code StructureDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public StructureDefinition build() {
            return new StructureDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, keyword, fhirVersion,
                    mapping, kind, abstractValue, context, contextInvariant, type, baseDefinition, derivation,
                    snapshot, differential);
        }
    }
}
