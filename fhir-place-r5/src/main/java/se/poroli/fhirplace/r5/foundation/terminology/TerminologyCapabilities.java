package se.poroli.fhirplace.r5.foundation.terminology;

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
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.CapabilityStatementKind;
import se.poroli.fhirplace.r5.valuesets.CodeSearchSupport;
import se.poroli.fhirplace.r5.valuesets.CodeSystemContentMode;
import se.poroli.fhirplace.r5.valuesets.CommonLanguages;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that
 * may be used as a statement of actual server functionality or a statement of required or desired server
 * implementation.
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
 * @param url Canonical identifier for this terminology capabilities, represented as a URI (globally unique).
 * @param identifier Additional identifier for the terminology capabilities.
 * @param version Business version of the terminology capabilities.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this terminology capabilities (computer friendly).
 * @param title Name for this terminology capabilities (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed. Required.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the terminology capabilities.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for terminology capabilities (if applicable).
 * @param purpose Why this terminology capabilities is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param kind instance | capability | requirements. Required.
 * @param software Software that is covered by this terminology capability statement.
 * @param implementation If this describes a specific instance.
 * @param lockedDate Whether lockedDate is supported.
 * @param codeSystem A code system supported by the server.
 * @param expansion Information about the ValueSet/$expand operation.
 * @param codeSearch in-compose | in-expansion | in-compose-or-expansion.
 * @param validateCode Information about the ValueSet/$validate-code operation.
 * @param translation Information about the ConceptMap/$translate operation.
 * @param closure Information about the ConceptMap/$closure operation.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/TerminologyCapabilities">FHIR R5 TerminologyCapabilities</a>
 */
public record TerminologyCapabilities(
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
        FhirEnum<CapabilityStatementKind> kind,
        Software software,
        Implementation implementation,
        FhirBoolean lockedDate,
        List<CodeSystem> codeSystem,
        Expansion expansion,
        FhirEnum<CodeSearchSupport> codeSearch,
        ValidateCode validateCode,
        Translation translation,
        Closure closure) implements DomainResource {

    /**
     * Creates a {@code TerminologyCapabilities}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public TerminologyCapabilities {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        codeSystem = codeSystem == null ? List.of() : List.copyOf(codeSystem);
        Objects.requireNonNull(status, "TerminologyCapabilities.status is required");
        Objects.requireNonNull(date, "TerminologyCapabilities.date is required");
        Objects.requireNonNull(kind, "TerminologyCapabilities.kind is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "TerminologyCapabilities.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code TerminologyCapabilities}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Software that is covered by this terminology capability statement.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name A name the software is known by. Required.
     * @param version Version covered by this statement.
     */
    public record Software(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            FhirString version) implements BackboneElement {

        /**
         * Creates a {@code Software}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Software {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(name, "TerminologyCapabilities.software.name is required");
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
         * Returns a builder initialized with the values of this {@code Software}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Software}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString name;
            private FhirString version;

            private Builder() {
            }

            private Builder(Software original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.version = original.version();
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
             * Builds the {@code Software}.
             *
             * @return the {@code Software}
             * @throws NullPointerException if a required element is absent
             */
            public Software build() {
                return new Software(
                        id, extension, modifierExtension, name, version);
            }
        }
    }

    /**
     * Identifies a specific implementation instance that is described by the terminology capability statement - i.e.
     * a particular installation, rather than the capabilities of a software program.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param description Describes this specific instance. Required.
     * @param url Base URL for the implementation.
     */
    public record Implementation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString description,
            FhirUrl url) implements BackboneElement {

        /**
         * Creates an {@code Implementation}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Implementation {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(description, "TerminologyCapabilities.implementation.description is required");
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
         * Returns a builder initialized with the values of this {@code Implementation}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Implementation}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString description;
            private FhirUrl url;

            private Builder() {
            }

            private Builder(Implementation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.description = original.description();
                this.url = original.url();
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
             * Sets {@code url}.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(FhirUrl url) {
                this.url = url;
                return this;
            }

            /**
             * Sets {@code url}, wrapped in a {@link FhirUrl} without id or extensions.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(String url) {
                return url(url == null ? null : FhirUrl.of(url));
            }

            /**
             * Builds the {@code Implementation}.
             *
             * @return the {@code Implementation}
             * @throws NullPointerException if a required element is absent
             */
            public Implementation build() {
                return new Implementation(
                        id, extension, modifierExtension, description, url);
            }
        }
    }

    /**
     * Identifies a code system that is supported by the server.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param uri Canonical identifier for the code system, represented as a URI. Canonical reference to CodeSystem.
     * @param version Version of Code System supported.
     * @param content not-present | example | fragment | complete | supplement. Required.
     * @param subsumption Whether subsumption is supported.
     */
    public record CodeSystem(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCanonical uri,
            List<Version> version,
            FhirEnum<CodeSystemContentMode> content,
            FhirBoolean subsumption) implements BackboneElement {

        /**
         * Creates a {@code CodeSystem}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public CodeSystem {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            version = version == null ? List.of() : List.copyOf(version);
            Objects.requireNonNull(content, "TerminologyCapabilities.codeSystem.content is required");
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
         * For the code system, a list of versions that are supported by the server.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code Version identifier for this version.
         * @param isDefault If this is the default version for this code system.
         * @param compositional If compositional grammar is supported.
         * @param language Language Displays supported.
         * @param filter Filter Properties supported.
         * @param property Properties supported for $lookup.
         */
        public record Version(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString code,
                FhirBoolean isDefault,
                FhirBoolean compositional,
                List<FhirEnum<CommonLanguages>> language,
                List<Filter> filter,
                List<FhirCode> property) implements BackboneElement {

            /**
             * Creates a {@code Version}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Version {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                language = language == null ? List.of() : List.copyOf(language);
                filter = filter == null ? List.of() : List.copyOf(filter);
                property = property == null ? List.of() : List.copyOf(property);
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
             * Returns a builder initialized with the values of this {@code Version}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Filter Properties supported.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param code Code of the property supported. Required.
             * @param op Operations supported for the property. Required.
             */
            public record Filter(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirCode code,
                    List<FhirCode> op) implements BackboneElement {

                /**
                 * Creates a {@code Filter}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public Filter {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    op = op == null ? List.of() : List.copyOf(op);
                    Objects.requireNonNull(
                            code, "TerminologyCapabilities.codeSystem.version.filter.code is required");
                    if (op.isEmpty()) {
                        throw new IllegalArgumentException(
                                "TerminologyCapabilities.codeSystem.version.filter.op requires at least one value");
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
                    private List<FhirCode> op = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(Filter original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.code = original.code();
                        this.op = new ArrayList<>(original.op());
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
                     * Replaces all {@code op} values.
                     *
                     * @param op the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder op(List<FhirCode> op) {
                        this.op = op == null ? new ArrayList<>() : new ArrayList<>(op);
                        return this;
                    }

                    /**
                     * Adds a {@code op} value.
                     *
                     * @param op the value to add
                     * @return this builder
                     */
                    public Builder addOp(FhirCode op) {
                        this.op.add(Objects.requireNonNull(op, "op"));
                        return this;
                    }

                    /**
                     * Adds a {@code op} value, wrapped in a {@link FhirCode} without id or extensions.
                     *
                     * @param op the value to add
                     * @return this builder
                     */
                    public Builder addOp(String op) {
                        return addOp(FhirCode.of(op));
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
                                id, extension, modifierExtension, code, op);
                    }
                }
            }

            /** Builder for {@link Version}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString code;
                private FhirBoolean isDefault;
                private FhirBoolean compositional;
                private List<FhirEnum<CommonLanguages>> language = new ArrayList<>();
                private List<Filter> filter = new ArrayList<>();
                private List<FhirCode> property = new ArrayList<>();

                private Builder() {
                }

                private Builder(Version original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.code = original.code();
                    this.isDefault = original.isDefault();
                    this.compositional = original.compositional();
                    this.language = new ArrayList<>(original.language());
                    this.filter = new ArrayList<>(original.filter());
                    this.property = new ArrayList<>(original.property());
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
                public Builder code(FhirString code) {
                    this.code = code;
                    return this;
                }

                /**
                 * Sets {@code code}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param code the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder code(String code) {
                    return code(code == null ? null : FhirString.of(code));
                }

                /**
                 * Sets {@code isDefault}.
                 *
                 * @param isDefault the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder isDefault(FhirBoolean isDefault) {
                    this.isDefault = isDefault;
                    return this;
                }

                /**
                 * Sets {@code isDefault}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param isDefault the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder isDefault(Boolean isDefault) {
                    return isDefault(isDefault == null ? null : FhirBoolean.of(isDefault));
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
                 * Replaces all {@code language} values.
                 *
                 * @param language the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder language(List<FhirEnum<CommonLanguages>> language) {
                    this.language = language == null ? new ArrayList<>() : new ArrayList<>(language);
                    return this;
                }

                /**
                 * Adds a {@code language} value.
                 *
                 * @param language the value to add
                 * @return this builder
                 */
                public Builder addLanguage(FhirEnum<CommonLanguages> language) {
                    this.language.add(Objects.requireNonNull(language, "language"));
                    return this;
                }

                /**
                 * Adds a {@code language} value, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param language the value to add
                 * @return this builder
                 */
                public Builder addLanguage(CommonLanguages language) {
                    return addLanguage(FhirEnum.of(language));
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
                public Builder property(List<FhirCode> property) {
                    this.property = property == null ? new ArrayList<>() : new ArrayList<>(property);
                    return this;
                }

                /**
                 * Adds a {@code property} value.
                 *
                 * @param property the value to add
                 * @return this builder
                 */
                public Builder addProperty(FhirCode property) {
                    this.property.add(Objects.requireNonNull(property, "property"));
                    return this;
                }

                /**
                 * Adds a {@code property} value, wrapped in a {@link FhirCode} without id or extensions.
                 *
                 * @param property the value to add
                 * @return this builder
                 */
                public Builder addProperty(String property) {
                    return addProperty(FhirCode.of(property));
                }

                /**
                 * Builds the {@code Version}.
                 *
                 * @return the {@code Version}
                 */
                public Version build() {
                    return new Version(
                            id, extension, modifierExtension, code, isDefault, compositional, language, filter,
                            property);
                }
            }
        }

        /** Builder for {@link CodeSystem}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCanonical uri;
            private List<Version> version = new ArrayList<>();
            private FhirEnum<CodeSystemContentMode> content;
            private FhirBoolean subsumption;

            private Builder() {
            }

            private Builder(CodeSystem original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.uri = original.uri();
                this.version = new ArrayList<>(original.version());
                this.content = original.content();
                this.subsumption = original.subsumption();
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
             * Replaces all {@code version} values.
             *
             * @param version the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder version(List<Version> version) {
                this.version = version == null ? new ArrayList<>() : new ArrayList<>(version);
                return this;
            }

            /**
             * Adds a {@code version} value.
             *
             * @param version the value to add
             * @return this builder
             */
            public Builder addVersion(Version version) {
                this.version.add(Objects.requireNonNull(version, "version"));
                return this;
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
             * Sets {@code subsumption}.
             *
             * @param subsumption the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subsumption(FhirBoolean subsumption) {
                this.subsumption = subsumption;
                return this;
            }

            /**
             * Sets {@code subsumption}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param subsumption the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subsumption(Boolean subsumption) {
                return subsumption(subsumption == null ? null : FhirBoolean.of(subsumption));
            }

            /**
             * Builds the {@code CodeSystem}.
             *
             * @return the {@code CodeSystem}
             * @throws NullPointerException if a required element is absent
             */
            public CodeSystem build() {
                return new CodeSystem(
                        id, extension, modifierExtension, uri, version, content, subsumption);
            }
        }
    }

    /**
     * Information about the ValueSet/$expand operation.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param hierarchical Whether the server can return nested value sets.
     * @param paging Whether the server supports paging on expansion.
     * @param incomplete Allow request for incomplete expansions?.
     * @param parameter Supported expansion parameter.
     * @param textFilter Documentation about text searching works.
     */
    public record Expansion(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirBoolean hierarchical,
            FhirBoolean paging,
            FhirBoolean incomplete,
            List<Parameter> parameter,
            FhirMarkdown textFilter) implements BackboneElement {

        /**
         * Creates an {@code Expansion}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Expansion {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
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
         * Returns a builder initialized with the values of this {@code Expansion}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Supported expansion parameter.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param name Name of the supported expansion parameter. Required.
         * @param documentation Description of support for parameter.
         */
        public record Parameter(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirCode name,
                FhirString documentation) implements BackboneElement {

            /**
             * Creates a {@code Parameter}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Parameter {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(name, "TerminologyCapabilities.expansion.parameter.name is required");
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
                private FhirCode name;
                private FhirString documentation;

                private Builder() {
                }

                private Builder(Parameter original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.name = original.name();
                    this.documentation = original.documentation();
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
                 * Builds the {@code Parameter}.
                 *
                 * @return the {@code Parameter}
                 * @throws NullPointerException if a required element is absent
                 */
                public Parameter build() {
                    return new Parameter(
                            id, extension, modifierExtension, name, documentation);
                }
            }
        }

        /** Builder for {@link Expansion}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirBoolean hierarchical;
            private FhirBoolean paging;
            private FhirBoolean incomplete;
            private List<Parameter> parameter = new ArrayList<>();
            private FhirMarkdown textFilter;

            private Builder() {
            }

            private Builder(Expansion original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.hierarchical = original.hierarchical();
                this.paging = original.paging();
                this.incomplete = original.incomplete();
                this.parameter = new ArrayList<>(original.parameter());
                this.textFilter = original.textFilter();
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
             * Sets {@code hierarchical}.
             *
             * @param hierarchical the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder hierarchical(FhirBoolean hierarchical) {
                this.hierarchical = hierarchical;
                return this;
            }

            /**
             * Sets {@code hierarchical}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param hierarchical the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder hierarchical(Boolean hierarchical) {
                return hierarchical(hierarchical == null ? null : FhirBoolean.of(hierarchical));
            }

            /**
             * Sets {@code paging}.
             *
             * @param paging the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder paging(FhirBoolean paging) {
                this.paging = paging;
                return this;
            }

            /**
             * Sets {@code paging}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param paging the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder paging(Boolean paging) {
                return paging(paging == null ? null : FhirBoolean.of(paging));
            }

            /**
             * Sets {@code incomplete}.
             *
             * @param incomplete the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder incomplete(FhirBoolean incomplete) {
                this.incomplete = incomplete;
                return this;
            }

            /**
             * Sets {@code incomplete}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param incomplete the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder incomplete(Boolean incomplete) {
                return incomplete(incomplete == null ? null : FhirBoolean.of(incomplete));
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
             * Sets {@code textFilter}.
             *
             * @param textFilter the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder textFilter(FhirMarkdown textFilter) {
                this.textFilter = textFilter;
                return this;
            }

            /**
             * Sets {@code textFilter}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param textFilter the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder textFilter(String textFilter) {
                return textFilter(textFilter == null ? null : FhirMarkdown.of(textFilter));
            }

            /**
             * Builds the {@code Expansion}.
             *
             * @return the {@code Expansion}
             */
            public Expansion build() {
                return new Expansion(
                        id, extension, modifierExtension, hierarchical, paging, incomplete, parameter, textFilter);
            }
        }
    }

    /**
     * Information about the ValueSet/$validate-code operation.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param translations Whether translations are validated. Required.
     */
    public record ValidateCode(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirBoolean translations) implements BackboneElement {

        /**
         * Creates a {@code ValidateCode}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ValidateCode {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(translations, "TerminologyCapabilities.validateCode.translations is required");
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
         * Returns a builder initialized with the values of this {@code ValidateCode}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ValidateCode}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirBoolean translations;

            private Builder() {
            }

            private Builder(ValidateCode original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.translations = original.translations();
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
             * Sets {@code translations}.
             *
             * @param translations the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder translations(FhirBoolean translations) {
                this.translations = translations;
                return this;
            }

            /**
             * Sets {@code translations}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param translations the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder translations(Boolean translations) {
                return translations(translations == null ? null : FhirBoolean.of(translations));
            }

            /**
             * Builds the {@code ValidateCode}.
             *
             * @return the {@code ValidateCode}
             * @throws NullPointerException if a required element is absent
             */
            public ValidateCode build() {
                return new ValidateCode(
                        id, extension, modifierExtension, translations);
            }
        }
    }

    /**
     * Information about the ConceptMap/$translate operation.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param needsMap Whether the client must identify the map. Required.
     */
    public record Translation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirBoolean needsMap) implements BackboneElement {

        /**
         * Creates a {@code Translation}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Translation {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(needsMap, "TerminologyCapabilities.translation.needsMap is required");
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
         * Returns a builder initialized with the values of this {@code Translation}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Translation}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirBoolean needsMap;

            private Builder() {
            }

            private Builder(Translation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.needsMap = original.needsMap();
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
             * Sets {@code needsMap}.
             *
             * @param needsMap the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder needsMap(FhirBoolean needsMap) {
                this.needsMap = needsMap;
                return this;
            }

            /**
             * Sets {@code needsMap}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param needsMap the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder needsMap(Boolean needsMap) {
                return needsMap(needsMap == null ? null : FhirBoolean.of(needsMap));
            }

            /**
             * Builds the {@code Translation}.
             *
             * @return the {@code Translation}
             * @throws NullPointerException if a required element is absent
             */
            public Translation build() {
                return new Translation(
                        id, extension, modifierExtension, needsMap);
            }
        }
    }

    /**
     * Whether the $closure operation is supported.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param translation If cross-system closure is supported.
     */
    public record Closure(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirBoolean translation) implements BackboneElement {

        /**
         * Creates a {@code Closure}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Closure {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
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
         * Returns a builder initialized with the values of this {@code Closure}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Closure}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirBoolean translation;

            private Builder() {
            }

            private Builder(Closure original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.translation = original.translation();
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
             * Sets {@code translation}.
             *
             * @param translation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder translation(FhirBoolean translation) {
                this.translation = translation;
                return this;
            }

            /**
             * Sets {@code translation}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param translation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder translation(Boolean translation) {
                return translation(translation == null ? null : FhirBoolean.of(translation));
            }

            /**
             * Builds the {@code Closure}.
             *
             * @return the {@code Closure}
             */
            public Closure build() {
                return new Closure(
                        id, extension, modifierExtension, translation);
            }
        }
    }

    /** Builder for {@link TerminologyCapabilities}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<CapabilityStatementKind> kind;
        private Software software;
        private Implementation implementation;
        private FhirBoolean lockedDate;
        private List<CodeSystem> codeSystem = new ArrayList<>();
        private Expansion expansion;
        private FhirEnum<CodeSearchSupport> codeSearch;
        private ValidateCode validateCode;
        private Translation translation;
        private Closure closure;

        private Builder() {
        }

        private Builder(TerminologyCapabilities original) {
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
            this.kind = original.kind();
            this.software = original.software();
            this.implementation = original.implementation();
            this.lockedDate = original.lockedDate();
            this.codeSystem = new ArrayList<>(original.codeSystem());
            this.expansion = original.expansion();
            this.codeSearch = original.codeSearch();
            this.validateCode = original.validateCode();
            this.translation = original.translation();
            this.closure = original.closure();
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
         * Sets {@code kind}.
         *
         * @param kind the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder kind(FhirEnum<CapabilityStatementKind> kind) {
            this.kind = kind;
            return this;
        }

        /**
         * Sets {@code kind}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param kind the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder kind(CapabilityStatementKind kind) {
            return kind(kind == null ? null : FhirEnum.of(kind));
        }

        /**
         * Sets {@code software}.
         *
         * @param software the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder software(Software software) {
            this.software = software;
            return this;
        }

        /**
         * Sets {@code implementation}.
         *
         * @param implementation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder implementation(Implementation implementation) {
            this.implementation = implementation;
            return this;
        }

        /**
         * Sets {@code lockedDate}.
         *
         * @param lockedDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lockedDate(FhirBoolean lockedDate) {
            this.lockedDate = lockedDate;
            return this;
        }

        /**
         * Sets {@code lockedDate}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param lockedDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lockedDate(Boolean lockedDate) {
            return lockedDate(lockedDate == null ? null : FhirBoolean.of(lockedDate));
        }

        /**
         * Replaces all {@code codeSystem} values.
         *
         * @param codeSystem the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder codeSystem(List<CodeSystem> codeSystem) {
            this.codeSystem = codeSystem == null ? new ArrayList<>() : new ArrayList<>(codeSystem);
            return this;
        }

        /**
         * Adds a {@code codeSystem} value.
         *
         * @param codeSystem the value to add
         * @return this builder
         */
        public Builder addCodeSystem(CodeSystem codeSystem) {
            this.codeSystem.add(Objects.requireNonNull(codeSystem, "codeSystem"));
            return this;
        }

        /**
         * Sets {@code expansion}.
         *
         * @param expansion the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expansion(Expansion expansion) {
            this.expansion = expansion;
            return this;
        }

        /**
         * Sets {@code codeSearch}.
         *
         * @param codeSearch the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder codeSearch(FhirEnum<CodeSearchSupport> codeSearch) {
            this.codeSearch = codeSearch;
            return this;
        }

        /**
         * Sets {@code codeSearch}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param codeSearch the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder codeSearch(CodeSearchSupport codeSearch) {
            return codeSearch(codeSearch == null ? null : FhirEnum.of(codeSearch));
        }

        /**
         * Sets {@code validateCode}.
         *
         * @param validateCode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder validateCode(ValidateCode validateCode) {
            this.validateCode = validateCode;
            return this;
        }

        /**
         * Sets {@code translation}.
         *
         * @param translation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder translation(Translation translation) {
            this.translation = translation;
            return this;
        }

        /**
         * Sets {@code closure}.
         *
         * @param closure the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder closure(Closure closure) {
            this.closure = closure;
            return this;
        }

        /**
         * Builds the {@code TerminologyCapabilities}.
         *
         * @return the {@code TerminologyCapabilities}
         * @throws NullPointerException if a required element is absent
         */
        public TerminologyCapabilities build() {
            return new TerminologyCapabilities(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, kind, software,
                    implementation, lockedDate, codeSystem, expansion, codeSearch, validateCode, translation, closure);
        }
    }
}
