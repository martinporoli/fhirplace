package se.poroli.fhirplace.r5.foundation.conformance;

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
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.FHIRVersion;
import se.poroli.fhirplace.r5.valuesets.GuidePageGeneration;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.ResourceType;
import se.poroli.fhirplace.r5.valuesets.SPDXLicense;

/**
 * A set of rules of how a particular interoperability or standards problem is solved - typically through the use of
 * FHIR resources.
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
 * @param url Canonical identifier for this implementation guide, represented as a URI (globally unique). Required.
 * @param identifier Additional identifier for the implementation guide (business identifier).
 * @param version Business version of the implementation guide.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this implementation guide (computer friendly). Required.
 * @param title Name for this implementation guide (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the implementation guide.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for implementation guide (if applicable).
 * @param purpose Why this implementation guide is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param packageId NPM Package name for IG. Required.
 * @param license SPDX license code for this IG (or not-open-source).
 * @param fhirVersion FHIR Version(s) this Implementation Guide targets. Required.
 * @param dependsOn Another Implementation guide this depends on.
 * @param global Profiles that apply globally.
 * @param definition Information needed to build the IG.
 * @param manifest Information about an assembled IG.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ImplementationGuide">FHIR R5 ImplementationGuide</a>
 */
public record ImplementationGuide(
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
        FhirId packageId,
        FhirEnum<SPDXLicense> license,
        List<FhirEnum<FHIRVersion>> fhirVersion,
        List<DependsOn> dependsOn,
        List<Global> global,
        Definition definition,
        Manifest manifest) implements DomainResource {

    /**
     * Creates an {@code ImplementationGuide}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ImplementationGuide {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        fhirVersion = fhirVersion == null ? List.of() : List.copyOf(fhirVersion);
        dependsOn = dependsOn == null ? List.of() : List.copyOf(dependsOn);
        global = global == null ? List.of() : List.copyOf(global);
        Objects.requireNonNull(url, "ImplementationGuide.url is required");
        Objects.requireNonNull(name, "ImplementationGuide.name is required");
        Objects.requireNonNull(status, "ImplementationGuide.status is required");
        Objects.requireNonNull(packageId, "ImplementationGuide.packageId is required");
        if (fhirVersion.isEmpty()) {
            throw new IllegalArgumentException("ImplementationGuide.fhirVersion requires at least one value");
        }
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "ImplementationGuide.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code ImplementationGuide}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Another implementation guide that this implementation depends on.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param uri Identity of the IG that this depends on. Canonical reference to ImplementationGuide. Required.
     * @param packageId NPM Package name for IG this depends on.
     * @param version Version of the IG.
     * @param reason Why dependency exists.
     */
    public record DependsOn(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCanonical uri,
            FhirId packageId,
            FhirString version,
            FhirMarkdown reason) implements BackboneElement {

        /**
         * Creates a {@code DependsOn}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public DependsOn {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(uri, "ImplementationGuide.dependsOn.uri is required");
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
         * Returns a builder initialized with the values of this {@code DependsOn}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link DependsOn}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCanonical uri;
            private FhirId packageId;
            private FhirString version;
            private FhirMarkdown reason;

            private Builder() {
            }

            private Builder(DependsOn original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.uri = original.uri();
                this.packageId = original.packageId();
                this.version = original.version();
                this.reason = original.reason();
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
             * Sets {@code uri}.
             *
             * @param uri the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder uri(FhirCanonical uri) {
                this.uri = uri;
                return this;
            }

            /**
             * Sets {@code uri}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param uri the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder uri(String uri) {
                return uri(uri == null ? null : FhirCanonical.of(uri));
            }

            /**
             * Sets {@code packageId}.
             *
             * @param packageId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder packageId(FhirId packageId) {
                this.packageId = packageId;
                return this;
            }

            /**
             * Sets {@code packageId}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param packageId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder packageId(String packageId) {
                return packageId(packageId == null ? null : FhirId.of(packageId));
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
             * Sets {@code reason}.
             *
             * @param reason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reason(FhirMarkdown reason) {
                this.reason = reason;
                return this;
            }

            /**
             * Sets {@code reason}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param reason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reason(String reason) {
                return reason(reason == null ? null : FhirMarkdown.of(reason));
            }

            /**
             * Builds the {@code DependsOn}.
             *
             * @return the {@code DependsOn}
             * @throws NullPointerException if a required element is absent
             */
            public DependsOn build() {
                return new DependsOn(
                        id, extension, modifierExtension, uri, packageId, version, reason);
            }
        }
    }

    /**
     * A set of profiles that all resources covered by this implementation guide must conform to.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Type this profile applies to. Required.
     * @param profile Profile that all resources must conform to. Canonical reference to StructureDefinition.
     *   Required.
     */
    public record Global(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<ResourceType> type,
            FhirCanonical profile) implements BackboneElement {

        /**
         * Creates a {@code Global}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Global {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "ImplementationGuide.global.type is required");
            Objects.requireNonNull(profile, "ImplementationGuide.global.profile is required");
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
         * Returns a builder initialized with the values of this {@code Global}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Global}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<ResourceType> type;
            private FhirCanonical profile;

            private Builder() {
            }

            private Builder(Global original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
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
            public Builder type(FhirEnum<ResourceType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(ResourceType type) {
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
             * Builds the {@code Global}.
             *
             * @return the {@code Global}
             * @throws NullPointerException if a required element is absent
             */
            public Global build() {
                return new Global(
                        id, extension, modifierExtension, type, profile);
            }
        }
    }

    /**
     * The information needed by an IG publisher tool to publish the whole implementation guide.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param grouping Grouping used to present related resources in the IG.
     * @param resource Resource in the implementation guide.
     * @param page Page/Section in the Guide.
     * @param parameter Defines how IG is built by tools.
     * @param template A template for building resources.
     */
    public record Definition(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Grouping> grouping,
            List<DefinitionResource> resource,
            Page page,
            List<Parameter> parameter,
            List<Template> template) implements BackboneElement {

        /**
         * Creates a {@code Definition}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Definition {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            grouping = grouping == null ? List.of() : List.copyOf(grouping);
            resource = resource == null ? List.of() : List.copyOf(resource);
            parameter = parameter == null ? List.of() : List.copyOf(parameter);
            template = template == null ? List.of() : List.copyOf(template);
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
         * Returns a builder initialized with the values of this {@code Definition}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A logical group of resources.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param name Descriptive name for the package. Required.
         * @param description Human readable text describing the package.
         */
        public record Grouping(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString name,
                FhirMarkdown description) implements BackboneElement {

            /**
             * Creates a {@code Grouping}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Grouping {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(name, "ImplementationGuide.definition.grouping.name is required");
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
             * Returns a builder initialized with the values of this {@code Grouping}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Grouping}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString name;
                private FhirMarkdown description;

                private Builder() {
                }

                private Builder(Grouping original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.name = original.name();
                    this.description = original.description();
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
                 * Builds the {@code Grouping}.
                 *
                 * @return the {@code Grouping}
                 * @throws NullPointerException if a required element is absent
                 */
                public Grouping build() {
                    return new Grouping(
                            id, extension, modifierExtension, name, description);
                }
            }
        }

        /**
         * A resource that is part of the implementation guide.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param reference Location of the resource. Reference to Resource. Required.
         * @param fhirVersion Versions this applies to (if different to IG).
         * @param name Human readable name for the resource.
         * @param description Reason why included in guide.
         * @param isExample Is this an example.
         * @param profile Profile(s) this is an example of. Canonical reference to StructureDefinition.
         * @param groupingId Grouping this is part of.
         */
        public record DefinitionResource(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Reference reference,
                List<FhirEnum<FHIRVersion>> fhirVersion,
                FhirString name,
                FhirMarkdown description,
                FhirBoolean isExample,
                List<FhirCanonical> profile,
                FhirId groupingId) implements BackboneElement {

            /**
             * Creates a {@code DefinitionResource}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public DefinitionResource {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                fhirVersion = fhirVersion == null ? List.of() : List.copyOf(fhirVersion);
                profile = profile == null ? List.of() : List.copyOf(profile);
                Objects.requireNonNull(reference, "ImplementationGuide.definition.resource.reference is required");
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
             * Returns a builder initialized with the values of this {@code DefinitionResource}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link DefinitionResource}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Reference reference;
                private List<FhirEnum<FHIRVersion>> fhirVersion = new ArrayList<>();
                private FhirString name;
                private FhirMarkdown description;
                private FhirBoolean isExample;
                private List<FhirCanonical> profile = new ArrayList<>();
                private FhirId groupingId;

                private Builder() {
                }

                private Builder(DefinitionResource original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.reference = original.reference();
                    this.fhirVersion = new ArrayList<>(original.fhirVersion());
                    this.name = original.name();
                    this.description = original.description();
                    this.isExample = original.isExample();
                    this.profile = new ArrayList<>(original.profile());
                    this.groupingId = original.groupingId();
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
                 * Replaces all {@code fhirVersion} values.
                 *
                 * @param fhirVersion the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder fhirVersion(List<FhirEnum<FHIRVersion>> fhirVersion) {
                    this.fhirVersion = fhirVersion == null ? new ArrayList<>() : new ArrayList<>(fhirVersion);
                    return this;
                }

                /**
                 * Adds a {@code fhirVersion} value.
                 *
                 * @param fhirVersion the value to add
                 * @return this builder
                 */
                public Builder addFhirVersion(FhirEnum<FHIRVersion> fhirVersion) {
                    this.fhirVersion.add(Objects.requireNonNull(fhirVersion, "fhirVersion"));
                    return this;
                }

                /**
                 * Adds a {@code fhirVersion} value, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param fhirVersion the value to add
                 * @return this builder
                 */
                public Builder addFhirVersion(FHIRVersion fhirVersion) {
                    return addFhirVersion(FhirEnum.of(fhirVersion));
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
                 * Sets {@code isExample}.
                 *
                 * @param isExample the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder isExample(FhirBoolean isExample) {
                    this.isExample = isExample;
                    return this;
                }

                /**
                 * Sets {@code isExample}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param isExample the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder isExample(Boolean isExample) {
                    return isExample(isExample == null ? null : FhirBoolean.of(isExample));
                }

                /**
                 * Replaces all {@code profile} values.
                 *
                 * @param profile the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder profile(List<FhirCanonical> profile) {
                    this.profile = profile == null ? new ArrayList<>() : new ArrayList<>(profile);
                    return this;
                }

                /**
                 * Adds a {@code profile} value.
                 *
                 * @param profile the value to add
                 * @return this builder
                 */
                public Builder addProfile(FhirCanonical profile) {
                    this.profile.add(Objects.requireNonNull(profile, "profile"));
                    return this;
                }

                /**
                 * Adds a {@code profile} value, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param profile the value to add
                 * @return this builder
                 */
                public Builder addProfile(String profile) {
                    return addProfile(FhirCanonical.of(profile));
                }

                /**
                 * Sets {@code groupingId}.
                 *
                 * @param groupingId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder groupingId(FhirId groupingId) {
                    this.groupingId = groupingId;
                    return this;
                }

                /**
                 * Sets {@code groupingId}, wrapped in a {@link FhirId} without id or extensions.
                 *
                 * @param groupingId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder groupingId(String groupingId) {
                    return groupingId(groupingId == null ? null : FhirId.of(groupingId));
                }

                /**
                 * Builds the {@code DefinitionResource}.
                 *
                 * @return the {@code DefinitionResource}
                 * @throws NullPointerException if a required element is absent
                 */
                public DefinitionResource build() {
                    return new DefinitionResource(
                            id, extension, modifierExtension, reference, fhirVersion, name, description, isExample,
                            profile, groupingId);
                }
            }
        }

        /**
         * A page / section in the implementation guide.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param source Source for page. One of url, string, markdown.
         * @param name Name of the page when published. Required.
         * @param title Short title shown for navigational assistance. Required.
         * @param generation html | markdown | xml | generated. Required.
         * @param page Nested Pages / Sections.
         */
        public record Page(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                DataType source,
                FhirUrl name,
                FhirString title,
                FhirEnum<GuidePageGeneration> generation,
                List<ImplementationGuide.Definition.Page> page) implements BackboneElement {

            /**
             * Creates a {@code Page}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Page {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                page = page == null ? List.of() : List.copyOf(page);
                Objects.requireNonNull(name, "ImplementationGuide.definition.page.name is required");
                Objects.requireNonNull(title, "ImplementationGuide.definition.page.title is required");
                Objects.requireNonNull(generation, "ImplementationGuide.definition.page.generation is required");
                if (source != null && !(source instanceof FhirUrl
                        || source instanceof FhirString
                        || source instanceof FhirMarkdown)) {
                    throw new IllegalArgumentException(
                            "ImplementationGuide.definition.page.source[x] does not allow "
                                    + source.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code Page}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Page}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private DataType source;
                private FhirUrl name;
                private FhirString title;
                private FhirEnum<GuidePageGeneration> generation;
                private List<ImplementationGuide.Definition.Page> page = new ArrayList<>();

                private Builder() {
                }

                private Builder(Page original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.source = original.source();
                    this.name = original.name();
                    this.title = original.title();
                    this.generation = original.generation();
                    this.page = new ArrayList<>(original.page());
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
                 * Sets {@code source} to a url.
                 *
                 * @param source the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder source(FhirUrl source) {
                    this.source = source;
                    return this;
                }

                /**
                 * Sets {@code source} to a string.
                 *
                 * @param source the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder source(FhirString source) {
                    this.source = source;
                    return this;
                }

                /**
                 * Sets {@code source} to a markdown.
                 *
                 * @param source the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder source(FhirMarkdown source) {
                    this.source = source;
                    return this;
                }

                /**
                 * Sets {@code name}.
                 *
                 * @param name the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder name(FhirUrl name) {
                    this.name = name;
                    return this;
                }

                /**
                 * Sets {@code name}, wrapped in a {@link FhirUrl} without id or extensions.
                 *
                 * @param name the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder name(String name) {
                    return name(name == null ? null : FhirUrl.of(name));
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
                 * Sets {@code generation}.
                 *
                 * @param generation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder generation(FhirEnum<GuidePageGeneration> generation) {
                    this.generation = generation;
                    return this;
                }

                /**
                 * Sets {@code generation}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param generation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder generation(GuidePageGeneration generation) {
                    return generation(generation == null ? null : FhirEnum.of(generation));
                }

                /**
                 * Replaces all {@code page} values.
                 *
                 * @param page the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder page(List<ImplementationGuide.Definition.Page> page) {
                    this.page = page == null ? new ArrayList<>() : new ArrayList<>(page);
                    return this;
                }

                /**
                 * Adds a {@code page} value.
                 *
                 * @param page the value to add
                 * @return this builder
                 */
                public Builder addPage(ImplementationGuide.Definition.Page page) {
                    this.page.add(Objects.requireNonNull(page, "page"));
                    return this;
                }

                /**
                 * Builds the {@code Page}.
                 *
                 * @return the {@code Page}
                 * @throws NullPointerException if a required element is absent
                 */
                public Page build() {
                    return new Page(
                            id, extension, modifierExtension, source, name, title, generation, page);
                }
            }
        }

        /**
         * A set of parameters that defines how the implementation guide is built.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code Code that identifies parameter. Required.
         * @param value Value for named type. Required.
         */
        public record Parameter(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Coding code,
                FhirString value) implements BackboneElement {

            /**
             * Creates a {@code Parameter}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Parameter {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(code, "ImplementationGuide.definition.parameter.code is required");
                Objects.requireNonNull(value, "ImplementationGuide.definition.parameter.value is required");
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
                private Coding code;
                private FhirString value;

                private Builder() {
                }

                private Builder(Parameter original) {
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
                public Builder code(Coding code) {
                    this.code = code;
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
                 * Builds the {@code Parameter}.
                 *
                 * @return the {@code Parameter}
                 * @throws NullPointerException if a required element is absent
                 */
                public Parameter build() {
                    return new Parameter(
                            id, extension, modifierExtension, code, value);
                }
            }
        }

        /**
         * A template for building resources.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code Type of template specified. Required.
         * @param source The source location for the template. Required.
         * @param scope The scope in which the template applies.
         */
        public record Template(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirCode code,
                FhirString source,
                FhirString scope) implements BackboneElement {

            /**
             * Creates a {@code Template}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Template {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(code, "ImplementationGuide.definition.template.code is required");
                Objects.requireNonNull(source, "ImplementationGuide.definition.template.source is required");
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
             * Returns a builder initialized with the values of this {@code Template}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Template}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirCode code;
                private FhirString source;
                private FhirString scope;

                private Builder() {
                }

                private Builder(Template original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.code = original.code();
                    this.source = original.source();
                    this.scope = original.scope();
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
                 * Sets {@code scope}.
                 *
                 * @param scope the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder scope(FhirString scope) {
                    this.scope = scope;
                    return this;
                }

                /**
                 * Sets {@code scope}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param scope the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder scope(String scope) {
                    return scope(scope == null ? null : FhirString.of(scope));
                }

                /**
                 * Builds the {@code Template}.
                 *
                 * @return the {@code Template}
                 * @throws NullPointerException if a required element is absent
                 */
                public Template build() {
                    return new Template(
                            id, extension, modifierExtension, code, source, scope);
                }
            }
        }

        /** Builder for {@link Definition}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Grouping> grouping = new ArrayList<>();
            private List<DefinitionResource> resource = new ArrayList<>();
            private Page page;
            private List<Parameter> parameter = new ArrayList<>();
            private List<Template> template = new ArrayList<>();

            private Builder() {
            }

            private Builder(Definition original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.grouping = new ArrayList<>(original.grouping());
                this.resource = new ArrayList<>(original.resource());
                this.page = original.page();
                this.parameter = new ArrayList<>(original.parameter());
                this.template = new ArrayList<>(original.template());
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
             * Replaces all {@code grouping} values.
             *
             * @param grouping the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder grouping(List<Grouping> grouping) {
                this.grouping = grouping == null ? new ArrayList<>() : new ArrayList<>(grouping);
                return this;
            }

            /**
             * Adds a {@code grouping} value.
             *
             * @param grouping the value to add
             * @return this builder
             */
            public Builder addGrouping(Grouping grouping) {
                this.grouping.add(Objects.requireNonNull(grouping, "grouping"));
                return this;
            }

            /**
             * Replaces all {@code resource} values.
             *
             * @param resource the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder resource(List<DefinitionResource> resource) {
                this.resource = resource == null ? new ArrayList<>() : new ArrayList<>(resource);
                return this;
            }

            /**
             * Adds a {@code resource} value.
             *
             * @param resource the value to add
             * @return this builder
             */
            public Builder addResource(DefinitionResource resource) {
                this.resource.add(Objects.requireNonNull(resource, "resource"));
                return this;
            }

            /**
             * Sets {@code page}.
             *
             * @param page the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder page(Page page) {
                this.page = page;
                return this;
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
             * Replaces all {@code template} values.
             *
             * @param template the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder template(List<Template> template) {
                this.template = template == null ? new ArrayList<>() : new ArrayList<>(template);
                return this;
            }

            /**
             * Adds a {@code template} value.
             *
             * @param template the value to add
             * @return this builder
             */
            public Builder addTemplate(Template template) {
                this.template.add(Objects.requireNonNull(template, "template"));
                return this;
            }

            /**
             * Builds the {@code Definition}.
             *
             * @return the {@code Definition}
             */
            public Definition build() {
                return new Definition(
                        id, extension, modifierExtension, grouping, resource, page, parameter, template);
            }
        }
    }

    /**
     * Information about an assembled implementation guide, created by the publication tooling.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param rendering Location of rendered implementation guide.
     * @param resource Resource in the implementation guide. Required.
     * @param page HTML page within the parent IG.
     * @param image Image within the IG.
     * @param other Additional linkable file in IG.
     */
    public record Manifest(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirUrl rendering,
            List<ManifestResource> resource,
            List<ManifestPage> page,
            List<FhirString> image,
            List<FhirString> other) implements BackboneElement {

        /**
         * Creates a {@code Manifest}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Manifest {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            resource = resource == null ? List.of() : List.copyOf(resource);
            page = page == null ? List.of() : List.copyOf(page);
            image = image == null ? List.of() : List.copyOf(image);
            other = other == null ? List.of() : List.copyOf(other);
            if (resource.isEmpty()) {
                throw new IllegalArgumentException(
                        "ImplementationGuide.manifest.resource requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Manifest}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A resource that is part of the implementation guide.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param reference Location of the resource. Reference to Resource. Required.
         * @param isExample Is this an example.
         * @param profile Profile(s) this is an example of. Canonical reference to StructureDefinition.
         * @param relativePath Relative path for page in IG.
         */
        public record ManifestResource(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Reference reference,
                FhirBoolean isExample,
                List<FhirCanonical> profile,
                FhirUrl relativePath) implements BackboneElement {

            /**
             * Creates a {@code ManifestResource}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public ManifestResource {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                profile = profile == null ? List.of() : List.copyOf(profile);
                Objects.requireNonNull(reference, "ImplementationGuide.manifest.resource.reference is required");
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
             * Returns a builder initialized with the values of this {@code ManifestResource}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link ManifestResource}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Reference reference;
                private FhirBoolean isExample;
                private List<FhirCanonical> profile = new ArrayList<>();
                private FhirUrl relativePath;

                private Builder() {
                }

                private Builder(ManifestResource original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.reference = original.reference();
                    this.isExample = original.isExample();
                    this.profile = new ArrayList<>(original.profile());
                    this.relativePath = original.relativePath();
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
                 * Sets {@code isExample}.
                 *
                 * @param isExample the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder isExample(FhirBoolean isExample) {
                    this.isExample = isExample;
                    return this;
                }

                /**
                 * Sets {@code isExample}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param isExample the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder isExample(Boolean isExample) {
                    return isExample(isExample == null ? null : FhirBoolean.of(isExample));
                }

                /**
                 * Replaces all {@code profile} values.
                 *
                 * @param profile the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder profile(List<FhirCanonical> profile) {
                    this.profile = profile == null ? new ArrayList<>() : new ArrayList<>(profile);
                    return this;
                }

                /**
                 * Adds a {@code profile} value.
                 *
                 * @param profile the value to add
                 * @return this builder
                 */
                public Builder addProfile(FhirCanonical profile) {
                    this.profile.add(Objects.requireNonNull(profile, "profile"));
                    return this;
                }

                /**
                 * Adds a {@code profile} value, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param profile the value to add
                 * @return this builder
                 */
                public Builder addProfile(String profile) {
                    return addProfile(FhirCanonical.of(profile));
                }

                /**
                 * Sets {@code relativePath}.
                 *
                 * @param relativePath the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relativePath(FhirUrl relativePath) {
                    this.relativePath = relativePath;
                    return this;
                }

                /**
                 * Sets {@code relativePath}, wrapped in a {@link FhirUrl} without id or extensions.
                 *
                 * @param relativePath the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relativePath(String relativePath) {
                    return relativePath(relativePath == null ? null : FhirUrl.of(relativePath));
                }

                /**
                 * Builds the {@code ManifestResource}.
                 *
                 * @return the {@code ManifestResource}
                 * @throws NullPointerException if a required element is absent
                 */
                public ManifestResource build() {
                    return new ManifestResource(
                            id, extension, modifierExtension, reference, isExample, profile, relativePath);
                }
            }
        }

        /**
         * Information about a page within the IG.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param name HTML page name. Required.
         * @param title Title of the page, for references.
         * @param anchor Anchor available on the page.
         */
        public record ManifestPage(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString name,
                FhirString title,
                List<FhirString> anchor) implements BackboneElement {

            /**
             * Creates a {@code ManifestPage}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public ManifestPage {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                anchor = anchor == null ? List.of() : List.copyOf(anchor);
                Objects.requireNonNull(name, "ImplementationGuide.manifest.page.name is required");
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
             * Returns a builder initialized with the values of this {@code ManifestPage}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link ManifestPage}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString name;
                private FhirString title;
                private List<FhirString> anchor = new ArrayList<>();

                private Builder() {
                }

                private Builder(ManifestPage original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.name = original.name();
                    this.title = original.title();
                    this.anchor = new ArrayList<>(original.anchor());
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
                 * Replaces all {@code anchor} values.
                 *
                 * @param anchor the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder anchor(List<FhirString> anchor) {
                    this.anchor = anchor == null ? new ArrayList<>() : new ArrayList<>(anchor);
                    return this;
                }

                /**
                 * Adds a {@code anchor} value.
                 *
                 * @param anchor the value to add
                 * @return this builder
                 */
                public Builder addAnchor(FhirString anchor) {
                    this.anchor.add(Objects.requireNonNull(anchor, "anchor"));
                    return this;
                }

                /**
                 * Adds a {@code anchor} value, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param anchor the value to add
                 * @return this builder
                 */
                public Builder addAnchor(String anchor) {
                    return addAnchor(FhirString.of(anchor));
                }

                /**
                 * Builds the {@code ManifestPage}.
                 *
                 * @return the {@code ManifestPage}
                 * @throws NullPointerException if a required element is absent
                 */
                public ManifestPage build() {
                    return new ManifestPage(
                            id, extension, modifierExtension, name, title, anchor);
                }
            }
        }

        /** Builder for {@link Manifest}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirUrl rendering;
            private List<ManifestResource> resource = new ArrayList<>();
            private List<ManifestPage> page = new ArrayList<>();
            private List<FhirString> image = new ArrayList<>();
            private List<FhirString> other = new ArrayList<>();

            private Builder() {
            }

            private Builder(Manifest original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.rendering = original.rendering();
                this.resource = new ArrayList<>(original.resource());
                this.page = new ArrayList<>(original.page());
                this.image = new ArrayList<>(original.image());
                this.other = new ArrayList<>(original.other());
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
             * Sets {@code rendering}.
             *
             * @param rendering the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rendering(FhirUrl rendering) {
                this.rendering = rendering;
                return this;
            }

            /**
             * Sets {@code rendering}, wrapped in a {@link FhirUrl} without id or extensions.
             *
             * @param rendering the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rendering(String rendering) {
                return rendering(rendering == null ? null : FhirUrl.of(rendering));
            }

            /**
             * Replaces all {@code resource} values.
             *
             * @param resource the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder resource(List<ManifestResource> resource) {
                this.resource = resource == null ? new ArrayList<>() : new ArrayList<>(resource);
                return this;
            }

            /**
             * Adds a {@code resource} value.
             *
             * @param resource the value to add
             * @return this builder
             */
            public Builder addResource(ManifestResource resource) {
                this.resource.add(Objects.requireNonNull(resource, "resource"));
                return this;
            }

            /**
             * Replaces all {@code page} values.
             *
             * @param page the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder page(List<ManifestPage> page) {
                this.page = page == null ? new ArrayList<>() : new ArrayList<>(page);
                return this;
            }

            /**
             * Adds a {@code page} value.
             *
             * @param page the value to add
             * @return this builder
             */
            public Builder addPage(ManifestPage page) {
                this.page.add(Objects.requireNonNull(page, "page"));
                return this;
            }

            /**
             * Replaces all {@code image} values.
             *
             * @param image the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder image(List<FhirString> image) {
                this.image = image == null ? new ArrayList<>() : new ArrayList<>(image);
                return this;
            }

            /**
             * Adds a {@code image} value.
             *
             * @param image the value to add
             * @return this builder
             */
            public Builder addImage(FhirString image) {
                this.image.add(Objects.requireNonNull(image, "image"));
                return this;
            }

            /**
             * Adds a {@code image} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param image the value to add
             * @return this builder
             */
            public Builder addImage(String image) {
                return addImage(FhirString.of(image));
            }

            /**
             * Replaces all {@code other} values.
             *
             * @param other the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder other(List<FhirString> other) {
                this.other = other == null ? new ArrayList<>() : new ArrayList<>(other);
                return this;
            }

            /**
             * Adds a {@code other} value.
             *
             * @param other the value to add
             * @return this builder
             */
            public Builder addOther(FhirString other) {
                this.other.add(Objects.requireNonNull(other, "other"));
                return this;
            }

            /**
             * Adds a {@code other} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param other the value to add
             * @return this builder
             */
            public Builder addOther(String other) {
                return addOther(FhirString.of(other));
            }

            /**
             * Builds the {@code Manifest}.
             *
             * @return the {@code Manifest}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Manifest build() {
                return new Manifest(
                        id, extension, modifierExtension, rendering, resource, page, image, other);
            }
        }
    }

    /** Builder for {@link ImplementationGuide}. Builders are mutable and not thread-safe. */
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
        private FhirId packageId;
        private FhirEnum<SPDXLicense> license;
        private List<FhirEnum<FHIRVersion>> fhirVersion = new ArrayList<>();
        private List<DependsOn> dependsOn = new ArrayList<>();
        private List<Global> global = new ArrayList<>();
        private Definition definition;
        private Manifest manifest;

        private Builder() {
        }

        private Builder(ImplementationGuide original) {
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
            this.packageId = original.packageId();
            this.license = original.license();
            this.fhirVersion = new ArrayList<>(original.fhirVersion());
            this.dependsOn = new ArrayList<>(original.dependsOn());
            this.global = new ArrayList<>(original.global());
            this.definition = original.definition();
            this.manifest = original.manifest();
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
         * Sets {@code packageId}.
         *
         * @param packageId the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder packageId(FhirId packageId) {
            this.packageId = packageId;
            return this;
        }

        /**
         * Sets {@code packageId}, wrapped in a {@link FhirId} without id or extensions.
         *
         * @param packageId the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder packageId(String packageId) {
            return packageId(packageId == null ? null : FhirId.of(packageId));
        }

        /**
         * Sets {@code license}.
         *
         * @param license the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder license(FhirEnum<SPDXLicense> license) {
            this.license = license;
            return this;
        }

        /**
         * Sets {@code license}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param license the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder license(SPDXLicense license) {
            return license(license == null ? null : FhirEnum.of(license));
        }

        /**
         * Replaces all {@code fhirVersion} values.
         *
         * @param fhirVersion the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder fhirVersion(List<FhirEnum<FHIRVersion>> fhirVersion) {
            this.fhirVersion = fhirVersion == null ? new ArrayList<>() : new ArrayList<>(fhirVersion);
            return this;
        }

        /**
         * Adds a {@code fhirVersion} value.
         *
         * @param fhirVersion the value to add
         * @return this builder
         */
        public Builder addFhirVersion(FhirEnum<FHIRVersion> fhirVersion) {
            this.fhirVersion.add(Objects.requireNonNull(fhirVersion, "fhirVersion"));
            return this;
        }

        /**
         * Adds a {@code fhirVersion} value, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param fhirVersion the value to add
         * @return this builder
         */
        public Builder addFhirVersion(FHIRVersion fhirVersion) {
            return addFhirVersion(FhirEnum.of(fhirVersion));
        }

        /**
         * Replaces all {@code dependsOn} values.
         *
         * @param dependsOn the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder dependsOn(List<DependsOn> dependsOn) {
            this.dependsOn = dependsOn == null ? new ArrayList<>() : new ArrayList<>(dependsOn);
            return this;
        }

        /**
         * Adds a {@code dependsOn} value.
         *
         * @param dependsOn the value to add
         * @return this builder
         */
        public Builder addDependsOn(DependsOn dependsOn) {
            this.dependsOn.add(Objects.requireNonNull(dependsOn, "dependsOn"));
            return this;
        }

        /**
         * Replaces all {@code global} values.
         *
         * @param global the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder global(List<Global> global) {
            this.global = global == null ? new ArrayList<>() : new ArrayList<>(global);
            return this;
        }

        /**
         * Adds a {@code global} value.
         *
         * @param global the value to add
         * @return this builder
         */
        public Builder addGlobal(Global global) {
            this.global.add(Objects.requireNonNull(global, "global"));
            return this;
        }

        /**
         * Sets {@code definition}.
         *
         * @param definition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder definition(Definition definition) {
            this.definition = definition;
            return this;
        }

        /**
         * Sets {@code manifest}.
         *
         * @param manifest the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder manifest(Manifest manifest) {
            this.manifest = manifest;
            return this;
        }

        /**
         * Builds the {@code ImplementationGuide}.
         *
         * @return the {@code ImplementationGuide}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public ImplementationGuide build() {
            return new ImplementationGuide(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, packageId, license,
                    fhirVersion, dependsOn, global, definition, manifest);
        }
    }
}
