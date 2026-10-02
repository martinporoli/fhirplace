package se.poroli.fhirplace.r5.capabilitystatement;

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
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.CapabilityStatementKind;
import se.poroli.fhirplace.r5.valuesets.FHIRVersion;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.ResourceType;
import se.poroli.fhirplace.r5.valuesets.SearchParamType;

/**
 * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server or Client for a particular
 * version of FHIR that may be used as a statement of actual server functionality or a statement of required or
 * desired server implementation.
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
 * @param url Canonical identifier for this capability statement, represented as a URI (globally unique).
 * @param identifier Additional identifier for the CapabilityStatement (business identifier).
 * @param version Business version of the capability statement.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this capability statement (computer friendly).
 * @param title Name for this capability statement (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed. Required.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the capability statement.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for capability statement (if applicable).
 * @param purpose Why this capability statement is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param kind instance | capability | requirements. Required.
 * @param instantiates Canonical URL of another capability statement this implements. Canonical reference to
 *   CapabilityStatement.
 * @param imports Canonical URL of another capability statement this adds to. Canonical reference to
 *   CapabilityStatement.
 * @param software Software that is covered by this capability statement.
 * @param implementation If this describes a specific instance.
 * @param fhirVersion FHIR Version the system supports. Required.
 * @param format formats supported (xml | json | ttl | mime type). Required.
 * @param patchFormat Patch formats supported.
 * @param acceptLanguage Languages supported.
 * @param implementationGuide Implementation guides supported. Canonical reference to ImplementationGuide.
 * @param rest If the endpoint is a RESTful one.
 * @param messaging If messaging is supported.
 * @param document Document definition.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/CapabilityStatement">FHIR R5 CapabilityStatement</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record CapabilityStatement(
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
        List<FhirCanonical> instantiates,
        List<FhirCanonical> imports,
        Software software,
        Implementation implementation,
        FhirEnum<FHIRVersion> fhirVersion,
        List<FhirCode> format,
        List<FhirCode> patchFormat,
        List<FhirCode> acceptLanguage,
        List<FhirCanonical> implementationGuide,
        List<Rest> rest,
        List<Messaging> messaging,
        List<Document> document) implements DomainResource {

    /**
     * Creates a {@code CapabilityStatement}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public CapabilityStatement {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        instantiates = instantiates == null ? List.of() : List.copyOf(instantiates);
        imports = imports == null ? List.of() : List.copyOf(imports);
        format = format == null ? List.of() : List.copyOf(format);
        patchFormat = patchFormat == null ? List.of() : List.copyOf(patchFormat);
        acceptLanguage = acceptLanguage == null ? List.of() : List.copyOf(acceptLanguage);
        implementationGuide = implementationGuide == null ? List.of() : List.copyOf(implementationGuide);
        rest = rest == null ? List.of() : List.copyOf(rest);
        messaging = messaging == null ? List.of() : List.copyOf(messaging);
        document = document == null ? List.of() : List.copyOf(document);
        Objects.requireNonNull(status, "CapabilityStatement.status is required");
        Objects.requireNonNull(date, "CapabilityStatement.date is required");
        Objects.requireNonNull(kind, "CapabilityStatement.kind is required");
        Objects.requireNonNull(fhirVersion, "CapabilityStatement.fhirVersion is required");
        if (format.isEmpty()) {
            throw new IllegalArgumentException("CapabilityStatement.format requires at least one value");
        }
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "CapabilityStatement.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code CapabilityStatement}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Software that is covered by this capability statement.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name A name the software is known by. Required.
     * @param version Version covered by this statement.
     * @param releaseDate Date this version was released.
     */
    public record Software(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            FhirString version,
            FhirDateTime releaseDate) implements BackboneElement {

        /**
         * Creates a {@code Software}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Software {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(name, "CapabilityStatement.software.name is required");
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
            private FhirDateTime releaseDate;

            private Builder() {
            }

            private Builder(Software original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.version = original.version();
                this.releaseDate = original.releaseDate();
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
             * Sets {@code releaseDate}.
             *
             * @param releaseDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder releaseDate(FhirDateTime releaseDate) {
                this.releaseDate = releaseDate;
                return this;
            }

            /**
             * Sets {@code releaseDate}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param releaseDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder releaseDate(Temporal releaseDate) {
                return releaseDate(releaseDate == null ? null : FhirDateTime.of(releaseDate));
            }

            /**
             * Builds the {@code Software}.
             *
             * @return the {@code Software}
             * @throws NullPointerException if a required element is absent
             */
            public Software build() {
                return new Software(
                        id, extension, modifierExtension, name, version, releaseDate);
            }
        }
    }

    /**
     * Identifies a specific implementation instance that is described by the capability statement - i.e. a particular
     * installation, rather than the capabilities of a software program.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param description Describes this specific instance. Required.
     * @param url Base URL for the installation.
     * @param custodian Organization that manages the data. Reference to Organization.
     */
    public record Implementation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirMarkdown description,
            FhirUrl url,
            Reference custodian) implements BackboneElement {

        /**
         * Creates an {@code Implementation}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Implementation {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(description, "CapabilityStatement.implementation.description is required");
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
            private FhirMarkdown description;
            private FhirUrl url;
            private Reference custodian;

            private Builder() {
            }

            private Builder(Implementation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.description = original.description();
                this.url = original.url();
                this.custodian = original.custodian();
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
             * Sets {@code custodian}.
             *
             * @param custodian the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder custodian(Reference custodian) {
                this.custodian = custodian;
                return this;
            }

            /**
             * Builds the {@code Implementation}.
             *
             * @return the {@code Implementation}
             * @throws NullPointerException if a required element is absent
             */
            public Implementation build() {
                return new Implementation(
                        id, extension, modifierExtension, description, url, custodian);
            }
        }
    }

    /**
     * A definition of the restful capabilities of the solution, if any.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param mode client | server. Required.
     * @param documentation General description of implementation.
     * @param security Information about security of implementation.
     * @param resource Resource served on the REST interface.
     * @param interaction What operations are supported?.
     * @param searchParam Search parameters for searching all resources.
     * @param operation Definition of a system level operation.
     * @param compartment Compartments served/used by system. Canonical reference to CompartmentDefinition.
     */
    public record Rest(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<RestfulCapabilityMode> mode,
            FhirMarkdown documentation,
            Security security,
            List<RestResource> resource,
            List<SystemInteraction> interaction,
            List<CapabilityStatement.Rest.RestResource.SearchParam> searchParam,
            List<CapabilityStatement.Rest.RestResource.Operation> operation,
            List<FhirCanonical> compartment) implements BackboneElement {

        /**
         * Creates a {@code Rest}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Rest {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            resource = resource == null ? List.of() : List.copyOf(resource);
            interaction = interaction == null ? List.of() : List.copyOf(interaction);
            searchParam = searchParam == null ? List.of() : List.copyOf(searchParam);
            operation = operation == null ? List.of() : List.copyOf(operation);
            compartment = compartment == null ? List.of() : List.copyOf(compartment);
            Objects.requireNonNull(mode, "CapabilityStatement.rest.mode is required");
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
         * Returns a builder initialized with the values of this {@code Rest}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Information about security implementation from an interface perspective - what a client needs to know.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param cors Adds CORS Headers (http://enable-cors.org/).
         * @param service OAuth | SMART-on-FHIR | NTLM | Basic | Kerberos | Certificates.
         * @param description General description of how security works.
         */
        public record Security(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirBoolean cors,
                List<CodeableConcept> service,
                FhirMarkdown description) implements BackboneElement {

            /**
             * Creates a {@code Security}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Security {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                service = service == null ? List.of() : List.copyOf(service);
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
             * Returns a builder initialized with the values of this {@code Security}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Security}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirBoolean cors;
                private List<CodeableConcept> service = new ArrayList<>();
                private FhirMarkdown description;

                private Builder() {
                }

                private Builder(Security original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.cors = original.cors();
                    this.service = new ArrayList<>(original.service());
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
                 * Sets {@code cors}.
                 *
                 * @param cors the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder cors(FhirBoolean cors) {
                    this.cors = cors;
                    return this;
                }

                /**
                 * Sets {@code cors}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param cors the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder cors(Boolean cors) {
                    return cors(cors == null ? null : FhirBoolean.of(cors));
                }

                /**
                 * Replaces all {@code service} values.
                 *
                 * @param service the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder service(List<CodeableConcept> service) {
                    this.service = service == null ? new ArrayList<>() : new ArrayList<>(service);
                    return this;
                }

                /**
                 * Adds a {@code service} value.
                 *
                 * @param service the value to add
                 * @return this builder
                 */
                public Builder addService(CodeableConcept service) {
                    this.service.add(Objects.requireNonNull(service, "service"));
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
                 * Builds the {@code Security}.
                 *
                 * @return the {@code Security}
                 */
                public Security build() {
                    return new Security(
                            id, extension, modifierExtension, cors, service, description);
                }
            }
        }

        /**
         * A specification of the restful capabilities of the solution for a specific resource type.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type A resource type that is supported. Required.
         * @param profile System-wide profile. Canonical reference to StructureDefinition.
         * @param supportedProfile Use-case specific profiles. Canonical reference to StructureDefinition.
         * @param documentation Additional information about the use of the resource type.
         * @param interaction What operations are supported?.
         * @param versioning no-version | versioned | versioned-update.
         * @param readHistory Whether vRead can return past versions.
         * @param updateCreate If update can commit to a new identity.
         * @param conditionalCreate If allows/uses conditional create.
         * @param conditionalRead not-supported | modified-since | not-match | full-support.
         * @param conditionalUpdate If allows/uses conditional update.
         * @param conditionalPatch If allows/uses conditional patch.
         * @param conditionalDelete not-supported | single | multiple - how conditional delete is supported.
         * @param referencePolicy literal | logical | resolves | enforced | local.
         * @param searchInclude _include values supported by the server.
         * @param searchRevInclude _revinclude values supported by the server.
         * @param searchParam Search parameters supported by implementation.
         * @param operation Definition of a resource operation.
         */
        public record RestResource(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<ResourceType> type,
                FhirCanonical profile,
                List<FhirCanonical> supportedProfile,
                FhirMarkdown documentation,
                List<ResourceInteraction> interaction,
                FhirEnum<ResourceVersionPolicy> versioning,
                FhirBoolean readHistory,
                FhirBoolean updateCreate,
                FhirBoolean conditionalCreate,
                FhirEnum<ConditionalReadStatus> conditionalRead,
                FhirBoolean conditionalUpdate,
                FhirBoolean conditionalPatch,
                FhirEnum<ConditionalDeleteStatus> conditionalDelete,
                List<FhirEnum<ReferenceHandlingPolicy>> referencePolicy,
                List<FhirString> searchInclude,
                List<FhirString> searchRevInclude,
                List<SearchParam> searchParam,
                List<Operation> operation) implements BackboneElement {

            /**
             * Creates a {@code RestResource}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public RestResource {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                supportedProfile = supportedProfile == null ? List.of() : List.copyOf(supportedProfile);
                interaction = interaction == null ? List.of() : List.copyOf(interaction);
                referencePolicy = referencePolicy == null ? List.of() : List.copyOf(referencePolicy);
                searchInclude = searchInclude == null ? List.of() : List.copyOf(searchInclude);
                searchRevInclude = searchRevInclude == null ? List.of() : List.copyOf(searchRevInclude);
                searchParam = searchParam == null ? List.of() : List.copyOf(searchParam);
                operation = operation == null ? List.of() : List.copyOf(operation);
                Objects.requireNonNull(type, "CapabilityStatement.rest.resource.type is required");
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
             * Returns a builder initialized with the values of this {@code RestResource}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Identifies a restful operation supported by the solution.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param code read | vread | update | patch | delete | history-instance | history-type | create |
             *   search-type. Required.
             * @param documentation Anything special about operation behavior.
             */
            public record ResourceInteraction(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirEnum<TypeRestfulInteraction> code,
                    FhirMarkdown documentation) implements BackboneElement {

                /**
                 * Creates a {@code ResourceInteraction}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public ResourceInteraction {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(code, "CapabilityStatement.rest.resource.interaction.code is required");
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
                 * Returns a builder initialized with the values of this {@code ResourceInteraction}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link ResourceInteraction}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirEnum<TypeRestfulInteraction> code;
                    private FhirMarkdown documentation;

                    private Builder() {
                    }

                    private Builder(ResourceInteraction original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.code = original.code();
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
                     * Sets {@code code}.
                     *
                     * @param code the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder code(FhirEnum<TypeRestfulInteraction> code) {
                        this.code = code;
                        return this;
                    }

                    /**
                     * Sets {@code code}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param code the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder code(TypeRestfulInteraction code) {
                        return code(code == null ? null : FhirEnum.of(code));
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
                     * Builds the {@code ResourceInteraction}.
                     *
                     * @return the {@code ResourceInteraction}
                     * @throws NullPointerException if a required element is absent
                     */
                    public ResourceInteraction build() {
                        return new ResourceInteraction(
                                id, extension, modifierExtension, code, documentation);
                    }
                }
            }

            /**
             * Search parameters for implementations to support and/or make use of - either references to ones defined
             * in the specification, or additional ones defined for/by the implementation.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param name Name for parameter in search url. Required.
             * @param definition Source of definition for parameter. Canonical reference to SearchParameter.
             * @param type number | date | string | token | reference | composite | quantity | uri | special.
             *   Required.
             * @param documentation Server-specific usage.
             */
            public record SearchParam(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirString name,
                    FhirCanonical definition,
                    FhirEnum<SearchParamType> type,
                    FhirMarkdown documentation) implements BackboneElement {

                /**
                 * Creates a {@code SearchParam}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public SearchParam {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(name, "CapabilityStatement.rest.resource.searchParam.name is required");
                    Objects.requireNonNull(type, "CapabilityStatement.rest.resource.searchParam.type is required");
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
                 * Returns a builder initialized with the values of this {@code SearchParam}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link SearchParam}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirString name;
                    private FhirCanonical definition;
                    private FhirEnum<SearchParamType> type;
                    private FhirMarkdown documentation;

                    private Builder() {
                    }

                    private Builder(SearchParam original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.name = original.name();
                        this.definition = original.definition();
                        this.type = original.type();
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
                     * Sets {@code definition}.
                     *
                     * @param definition the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder definition(FhirCanonical definition) {
                        this.definition = definition;
                        return this;
                    }

                    /**
                     * Sets {@code definition}, wrapped in a {@link FhirCanonical} without id or extensions.
                     *
                     * @param definition the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder definition(String definition) {
                        return definition(definition == null ? null : FhirCanonical.of(definition));
                    }

                    /**
                     * Sets {@code type}.
                     *
                     * @param type the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder type(FhirEnum<SearchParamType> type) {
                        this.type = type;
                        return this;
                    }

                    /**
                     * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param type the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder type(SearchParamType type) {
                        return type(type == null ? null : FhirEnum.of(type));
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
                     * Builds the {@code SearchParam}.
                     *
                     * @return the {@code SearchParam}
                     * @throws NullPointerException if a required element is absent
                     */
                    public SearchParam build() {
                        return new SearchParam(
                                id, extension, modifierExtension, name, definition, type, documentation);
                    }
                }
            }

            /**
             * Definition of an operation or a named query together with its parameters and their meaning and type.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param name Name by which the operation/query is invoked. Required.
             * @param definition The defined operation/query. Canonical reference to OperationDefinition. Required.
             * @param documentation Specific details about operation behavior.
             */
            public record Operation(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirString name,
                    FhirCanonical definition,
                    FhirMarkdown documentation) implements BackboneElement {

                /**
                 * Creates an {@code Operation}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public Operation {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(name, "CapabilityStatement.rest.resource.operation.name is required");
                    Objects.requireNonNull(
                            definition, "CapabilityStatement.rest.resource.operation.definition is required");
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
                 * Returns a builder initialized with the values of this {@code Operation}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Operation}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirString name;
                    private FhirCanonical definition;
                    private FhirMarkdown documentation;

                    private Builder() {
                    }

                    private Builder(Operation original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.name = original.name();
                        this.definition = original.definition();
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
                     * Sets {@code definition}.
                     *
                     * @param definition the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder definition(FhirCanonical definition) {
                        this.definition = definition;
                        return this;
                    }

                    /**
                     * Sets {@code definition}, wrapped in a {@link FhirCanonical} without id or extensions.
                     *
                     * @param definition the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder definition(String definition) {
                        return definition(definition == null ? null : FhirCanonical.of(definition));
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
                     * Builds the {@code Operation}.
                     *
                     * @return the {@code Operation}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Operation build() {
                        return new Operation(
                                id, extension, modifierExtension, name, definition, documentation);
                    }
                }
            }

            /** Builder for {@link RestResource}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<ResourceType> type;
                private FhirCanonical profile;
                private List<FhirCanonical> supportedProfile = new ArrayList<>();
                private FhirMarkdown documentation;
                private List<ResourceInteraction> interaction = new ArrayList<>();
                private FhirEnum<ResourceVersionPolicy> versioning;
                private FhirBoolean readHistory;
                private FhirBoolean updateCreate;
                private FhirBoolean conditionalCreate;
                private FhirEnum<ConditionalReadStatus> conditionalRead;
                private FhirBoolean conditionalUpdate;
                private FhirBoolean conditionalPatch;
                private FhirEnum<ConditionalDeleteStatus> conditionalDelete;
                private List<FhirEnum<ReferenceHandlingPolicy>> referencePolicy = new ArrayList<>();
                private List<FhirString> searchInclude = new ArrayList<>();
                private List<FhirString> searchRevInclude = new ArrayList<>();
                private List<SearchParam> searchParam = new ArrayList<>();
                private List<Operation> operation = new ArrayList<>();

                private Builder() {
                }

                private Builder(RestResource original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.profile = original.profile();
                    this.supportedProfile = new ArrayList<>(original.supportedProfile());
                    this.documentation = original.documentation();
                    this.interaction = new ArrayList<>(original.interaction());
                    this.versioning = original.versioning();
                    this.readHistory = original.readHistory();
                    this.updateCreate = original.updateCreate();
                    this.conditionalCreate = original.conditionalCreate();
                    this.conditionalRead = original.conditionalRead();
                    this.conditionalUpdate = original.conditionalUpdate();
                    this.conditionalPatch = original.conditionalPatch();
                    this.conditionalDelete = original.conditionalDelete();
                    this.referencePolicy = new ArrayList<>(original.referencePolicy());
                    this.searchInclude = new ArrayList<>(original.searchInclude());
                    this.searchRevInclude = new ArrayList<>(original.searchRevInclude());
                    this.searchParam = new ArrayList<>(original.searchParam());
                    this.operation = new ArrayList<>(original.operation());
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
                 * Replaces all {@code supportedProfile} values.
                 *
                 * @param supportedProfile the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder supportedProfile(List<FhirCanonical> supportedProfile) {
                    this.supportedProfile = supportedProfile == null
                            ? new ArrayList<>()
                            : new ArrayList<>(supportedProfile);
                    return this;
                }

                /**
                 * Adds a {@code supportedProfile} value.
                 *
                 * @param supportedProfile the value to add
                 * @return this builder
                 */
                public Builder addSupportedProfile(FhirCanonical supportedProfile) {
                    this.supportedProfile.add(Objects.requireNonNull(supportedProfile, "supportedProfile"));
                    return this;
                }

                /**
                 * Adds a {@code supportedProfile} value, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param supportedProfile the value to add
                 * @return this builder
                 */
                public Builder addSupportedProfile(String supportedProfile) {
                    return addSupportedProfile(FhirCanonical.of(supportedProfile));
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
                 * Replaces all {@code interaction} values.
                 *
                 * @param interaction the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder interaction(List<ResourceInteraction> interaction) {
                    this.interaction = interaction == null ? new ArrayList<>() : new ArrayList<>(interaction);
                    return this;
                }

                /**
                 * Adds a {@code interaction} value.
                 *
                 * @param interaction the value to add
                 * @return this builder
                 */
                public Builder addInteraction(ResourceInteraction interaction) {
                    this.interaction.add(Objects.requireNonNull(interaction, "interaction"));
                    return this;
                }

                /**
                 * Sets {@code versioning}.
                 *
                 * @param versioning the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder versioning(FhirEnum<ResourceVersionPolicy> versioning) {
                    this.versioning = versioning;
                    return this;
                }

                /**
                 * Sets {@code versioning}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param versioning the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder versioning(ResourceVersionPolicy versioning) {
                    return versioning(versioning == null ? null : FhirEnum.of(versioning));
                }

                /**
                 * Sets {@code readHistory}.
                 *
                 * @param readHistory the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder readHistory(FhirBoolean readHistory) {
                    this.readHistory = readHistory;
                    return this;
                }

                /**
                 * Sets {@code readHistory}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param readHistory the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder readHistory(Boolean readHistory) {
                    return readHistory(readHistory == null ? null : FhirBoolean.of(readHistory));
                }

                /**
                 * Sets {@code updateCreate}.
                 *
                 * @param updateCreate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder updateCreate(FhirBoolean updateCreate) {
                    this.updateCreate = updateCreate;
                    return this;
                }

                /**
                 * Sets {@code updateCreate}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param updateCreate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder updateCreate(Boolean updateCreate) {
                    return updateCreate(updateCreate == null ? null : FhirBoolean.of(updateCreate));
                }

                /**
                 * Sets {@code conditionalCreate}.
                 *
                 * @param conditionalCreate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder conditionalCreate(FhirBoolean conditionalCreate) {
                    this.conditionalCreate = conditionalCreate;
                    return this;
                }

                /**
                 * Sets {@code conditionalCreate}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param conditionalCreate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder conditionalCreate(Boolean conditionalCreate) {
                    return conditionalCreate(conditionalCreate == null ? null : FhirBoolean.of(conditionalCreate));
                }

                /**
                 * Sets {@code conditionalRead}.
                 *
                 * @param conditionalRead the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder conditionalRead(FhirEnum<ConditionalReadStatus> conditionalRead) {
                    this.conditionalRead = conditionalRead;
                    return this;
                }

                /**
                 * Sets {@code conditionalRead}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param conditionalRead the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder conditionalRead(ConditionalReadStatus conditionalRead) {
                    return conditionalRead(conditionalRead == null ? null : FhirEnum.of(conditionalRead));
                }

                /**
                 * Sets {@code conditionalUpdate}.
                 *
                 * @param conditionalUpdate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder conditionalUpdate(FhirBoolean conditionalUpdate) {
                    this.conditionalUpdate = conditionalUpdate;
                    return this;
                }

                /**
                 * Sets {@code conditionalUpdate}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param conditionalUpdate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder conditionalUpdate(Boolean conditionalUpdate) {
                    return conditionalUpdate(conditionalUpdate == null ? null : FhirBoolean.of(conditionalUpdate));
                }

                /**
                 * Sets {@code conditionalPatch}.
                 *
                 * @param conditionalPatch the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder conditionalPatch(FhirBoolean conditionalPatch) {
                    this.conditionalPatch = conditionalPatch;
                    return this;
                }

                /**
                 * Sets {@code conditionalPatch}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param conditionalPatch the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder conditionalPatch(Boolean conditionalPatch) {
                    return conditionalPatch(conditionalPatch == null ? null : FhirBoolean.of(conditionalPatch));
                }

                /**
                 * Sets {@code conditionalDelete}.
                 *
                 * @param conditionalDelete the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder conditionalDelete(FhirEnum<ConditionalDeleteStatus> conditionalDelete) {
                    this.conditionalDelete = conditionalDelete;
                    return this;
                }

                /**
                 * Sets {@code conditionalDelete}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param conditionalDelete the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder conditionalDelete(ConditionalDeleteStatus conditionalDelete) {
                    return conditionalDelete(conditionalDelete == null ? null : FhirEnum.of(conditionalDelete));
                }

                /**
                 * Replaces all {@code referencePolicy} values.
                 *
                 * @param referencePolicy the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder referencePolicy(List<FhirEnum<ReferenceHandlingPolicy>> referencePolicy) {
                    this.referencePolicy = referencePolicy == null
                            ? new ArrayList<>()
                            : new ArrayList<>(referencePolicy);
                    return this;
                }

                /**
                 * Adds a {@code referencePolicy} value.
                 *
                 * @param referencePolicy the value to add
                 * @return this builder
                 */
                public Builder addReferencePolicy(FhirEnum<ReferenceHandlingPolicy> referencePolicy) {
                    this.referencePolicy.add(Objects.requireNonNull(referencePolicy, "referencePolicy"));
                    return this;
                }

                /**
                 * Adds a {@code referencePolicy} value, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param referencePolicy the value to add
                 * @return this builder
                 */
                public Builder addReferencePolicy(ReferenceHandlingPolicy referencePolicy) {
                    return addReferencePolicy(FhirEnum.of(referencePolicy));
                }

                /**
                 * Replaces all {@code searchInclude} values.
                 *
                 * @param searchInclude the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder searchInclude(List<FhirString> searchInclude) {
                    this.searchInclude = searchInclude == null ? new ArrayList<>() : new ArrayList<>(searchInclude);
                    return this;
                }

                /**
                 * Adds a {@code searchInclude} value.
                 *
                 * @param searchInclude the value to add
                 * @return this builder
                 */
                public Builder addSearchInclude(FhirString searchInclude) {
                    this.searchInclude.add(Objects.requireNonNull(searchInclude, "searchInclude"));
                    return this;
                }

                /**
                 * Adds a {@code searchInclude} value, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param searchInclude the value to add
                 * @return this builder
                 */
                public Builder addSearchInclude(String searchInclude) {
                    return addSearchInclude(FhirString.of(searchInclude));
                }

                /**
                 * Replaces all {@code searchRevInclude} values.
                 *
                 * @param searchRevInclude the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder searchRevInclude(List<FhirString> searchRevInclude) {
                    this.searchRevInclude = searchRevInclude == null
                            ? new ArrayList<>()
                            : new ArrayList<>(searchRevInclude);
                    return this;
                }

                /**
                 * Adds a {@code searchRevInclude} value.
                 *
                 * @param searchRevInclude the value to add
                 * @return this builder
                 */
                public Builder addSearchRevInclude(FhirString searchRevInclude) {
                    this.searchRevInclude.add(Objects.requireNonNull(searchRevInclude, "searchRevInclude"));
                    return this;
                }

                /**
                 * Adds a {@code searchRevInclude} value, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param searchRevInclude the value to add
                 * @return this builder
                 */
                public Builder addSearchRevInclude(String searchRevInclude) {
                    return addSearchRevInclude(FhirString.of(searchRevInclude));
                }

                /**
                 * Replaces all {@code searchParam} values.
                 *
                 * @param searchParam the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder searchParam(List<SearchParam> searchParam) {
                    this.searchParam = searchParam == null ? new ArrayList<>() : new ArrayList<>(searchParam);
                    return this;
                }

                /**
                 * Adds a {@code searchParam} value.
                 *
                 * @param searchParam the value to add
                 * @return this builder
                 */
                public Builder addSearchParam(SearchParam searchParam) {
                    this.searchParam.add(Objects.requireNonNull(searchParam, "searchParam"));
                    return this;
                }

                /**
                 * Replaces all {@code operation} values.
                 *
                 * @param operation the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder operation(List<Operation> operation) {
                    this.operation = operation == null ? new ArrayList<>() : new ArrayList<>(operation);
                    return this;
                }

                /**
                 * Adds a {@code operation} value.
                 *
                 * @param operation the value to add
                 * @return this builder
                 */
                public Builder addOperation(Operation operation) {
                    this.operation.add(Objects.requireNonNull(operation, "operation"));
                    return this;
                }

                /**
                 * Builds the {@code RestResource}.
                 *
                 * @return the {@code RestResource}
                 * @throws NullPointerException if a required element is absent
                 */
                public RestResource build() {
                    return new RestResource(
                            id, extension, modifierExtension, type, profile, supportedProfile, documentation,
                            interaction, versioning, readHistory, updateCreate, conditionalCreate, conditionalRead,
                            conditionalUpdate, conditionalPatch, conditionalDelete, referencePolicy, searchInclude,
                            searchRevInclude, searchParam, operation);
                }
            }
        }

        /**
         * A specification of restful operations supported by the system.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code transaction | batch | search-system | history-system. Required.
         * @param documentation Anything special about operation behavior.
         */
        public record SystemInteraction(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<SystemRestfulInteraction> code,
                FhirMarkdown documentation) implements BackboneElement {

            /**
             * Creates a {@code SystemInteraction}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public SystemInteraction {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(code, "CapabilityStatement.rest.interaction.code is required");
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
             * Returns a builder initialized with the values of this {@code SystemInteraction}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link SystemInteraction}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<SystemRestfulInteraction> code;
                private FhirMarkdown documentation;

                private Builder() {
                }

                private Builder(SystemInteraction original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.code = original.code();
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
                 * Sets {@code code}.
                 *
                 * @param code the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder code(FhirEnum<SystemRestfulInteraction> code) {
                    this.code = code;
                    return this;
                }

                /**
                 * Sets {@code code}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param code the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder code(SystemRestfulInteraction code) {
                    return code(code == null ? null : FhirEnum.of(code));
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
                 * Builds the {@code SystemInteraction}.
                 *
                 * @return the {@code SystemInteraction}
                 * @throws NullPointerException if a required element is absent
                 */
                public SystemInteraction build() {
                    return new SystemInteraction(
                            id, extension, modifierExtension, code, documentation);
                }
            }
        }

        /** Builder for {@link Rest}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<RestfulCapabilityMode> mode;
            private FhirMarkdown documentation;
            private Security security;
            private List<RestResource> resource = new ArrayList<>();
            private List<SystemInteraction> interaction = new ArrayList<>();
            private List<CapabilityStatement.Rest.RestResource.SearchParam> searchParam = new ArrayList<>();
            private List<CapabilityStatement.Rest.RestResource.Operation> operation = new ArrayList<>();
            private List<FhirCanonical> compartment = new ArrayList<>();

            private Builder() {
            }

            private Builder(Rest original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.mode = original.mode();
                this.documentation = original.documentation();
                this.security = original.security();
                this.resource = new ArrayList<>(original.resource());
                this.interaction = new ArrayList<>(original.interaction());
                this.searchParam = new ArrayList<>(original.searchParam());
                this.operation = new ArrayList<>(original.operation());
                this.compartment = new ArrayList<>(original.compartment());
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
            public Builder mode(FhirEnum<RestfulCapabilityMode> mode) {
                this.mode = mode;
                return this;
            }

            /**
             * Sets {@code mode}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param mode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder mode(RestfulCapabilityMode mode) {
                return mode(mode == null ? null : FhirEnum.of(mode));
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
             * Sets {@code security}.
             *
             * @param security the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder security(Security security) {
                this.security = security;
                return this;
            }

            /**
             * Replaces all {@code resource} values.
             *
             * @param resource the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder resource(List<RestResource> resource) {
                this.resource = resource == null ? new ArrayList<>() : new ArrayList<>(resource);
                return this;
            }

            /**
             * Adds a {@code resource} value.
             *
             * @param resource the value to add
             * @return this builder
             */
            public Builder addResource(RestResource resource) {
                this.resource.add(Objects.requireNonNull(resource, "resource"));
                return this;
            }

            /**
             * Replaces all {@code interaction} values.
             *
             * @param interaction the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder interaction(List<SystemInteraction> interaction) {
                this.interaction = interaction == null ? new ArrayList<>() : new ArrayList<>(interaction);
                return this;
            }

            /**
             * Adds a {@code interaction} value.
             *
             * @param interaction the value to add
             * @return this builder
             */
            public Builder addInteraction(SystemInteraction interaction) {
                this.interaction.add(Objects.requireNonNull(interaction, "interaction"));
                return this;
            }

            /**
             * Replaces all {@code searchParam} values.
             *
             * @param searchParam the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder searchParam(List<CapabilityStatement.Rest.RestResource.SearchParam> searchParam) {
                this.searchParam = searchParam == null ? new ArrayList<>() : new ArrayList<>(searchParam);
                return this;
            }

            /**
             * Adds a {@code searchParam} value.
             *
             * @param searchParam the value to add
             * @return this builder
             */
            public Builder addSearchParam(CapabilityStatement.Rest.RestResource.SearchParam searchParam) {
                this.searchParam.add(Objects.requireNonNull(searchParam, "searchParam"));
                return this;
            }

            /**
             * Replaces all {@code operation} values.
             *
             * @param operation the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder operation(List<CapabilityStatement.Rest.RestResource.Operation> operation) {
                this.operation = operation == null ? new ArrayList<>() : new ArrayList<>(operation);
                return this;
            }

            /**
             * Adds a {@code operation} value.
             *
             * @param operation the value to add
             * @return this builder
             */
            public Builder addOperation(CapabilityStatement.Rest.RestResource.Operation operation) {
                this.operation.add(Objects.requireNonNull(operation, "operation"));
                return this;
            }

            /**
             * Replaces all {@code compartment} values.
             *
             * @param compartment the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder compartment(List<FhirCanonical> compartment) {
                this.compartment = compartment == null ? new ArrayList<>() : new ArrayList<>(compartment);
                return this;
            }

            /**
             * Adds a {@code compartment} value.
             *
             * @param compartment the value to add
             * @return this builder
             */
            public Builder addCompartment(FhirCanonical compartment) {
                this.compartment.add(Objects.requireNonNull(compartment, "compartment"));
                return this;
            }

            /**
             * Adds a {@code compartment} value, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param compartment the value to add
             * @return this builder
             */
            public Builder addCompartment(String compartment) {
                return addCompartment(FhirCanonical.of(compartment));
            }

            /**
             * Builds the {@code Rest}.
             *
             * @return the {@code Rest}
             * @throws NullPointerException if a required element is absent
             */
            public Rest build() {
                return new Rest(
                        id, extension, modifierExtension, mode, documentation, security, resource, interaction,
                        searchParam, operation, compartment);
            }
        }
    }

    /**
     * A description of the messaging capabilities of the solution.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param endpoint Where messages should be sent.
     * @param reliableCache Reliable Message Cache Length (min).
     * @param documentation Messaging interface behavior details.
     * @param supportedMessage Messages supported by this system.
     */
    public record Messaging(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Endpoint> endpoint,
            FhirUnsignedInt reliableCache,
            FhirMarkdown documentation,
            List<SupportedMessage> supportedMessage) implements BackboneElement {

        /**
         * Creates a {@code Messaging}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Messaging {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            endpoint = endpoint == null ? List.of() : List.copyOf(endpoint);
            supportedMessage = supportedMessage == null ? List.of() : List.copyOf(supportedMessage);
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
         * Returns a builder initialized with the values of this {@code Messaging}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * An endpoint (network accessible address) to which messages and/or replies are to be sent.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param protocol http | ftp | mllp +. Required.
         * @param address Network address or identifier of the end-point. Required.
         */
        public record Endpoint(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Coding protocol,
                FhirUrl address) implements BackboneElement {

            /**
             * Creates an {@code Endpoint}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Endpoint {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(protocol, "CapabilityStatement.messaging.endpoint.protocol is required");
                Objects.requireNonNull(address, "CapabilityStatement.messaging.endpoint.address is required");
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
             * Returns a builder initialized with the values of this {@code Endpoint}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Endpoint}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Coding protocol;
                private FhirUrl address;

                private Builder() {
                }

                private Builder(Endpoint original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.protocol = original.protocol();
                    this.address = original.address();
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
                 * Sets {@code protocol}.
                 *
                 * @param protocol the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder protocol(Coding protocol) {
                    this.protocol = protocol;
                    return this;
                }

                /**
                 * Sets {@code address}.
                 *
                 * @param address the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder address(FhirUrl address) {
                    this.address = address;
                    return this;
                }

                /**
                 * Sets {@code address}, wrapped in a {@link FhirUrl} without id or extensions.
                 *
                 * @param address the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder address(String address) {
                    return address(address == null ? null : FhirUrl.of(address));
                }

                /**
                 * Builds the {@code Endpoint}.
                 *
                 * @return the {@code Endpoint}
                 * @throws NullPointerException if a required element is absent
                 */
                public Endpoint build() {
                    return new Endpoint(
                            id, extension, modifierExtension, protocol, address);
                }
            }
        }

        /**
         * References to message definitions for messages this system can send or receive.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param mode sender | receiver. Required.
         * @param definition Message supported by this system. Canonical reference to MessageDefinition. Required.
         */
        public record SupportedMessage(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<EventCapabilityMode> mode,
                FhirCanonical definition) implements BackboneElement {

            /**
             * Creates a {@code SupportedMessage}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public SupportedMessage {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(mode, "CapabilityStatement.messaging.supportedMessage.mode is required");
                Objects.requireNonNull(
                        definition, "CapabilityStatement.messaging.supportedMessage.definition is required");
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
             * Returns a builder initialized with the values of this {@code SupportedMessage}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link SupportedMessage}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<EventCapabilityMode> mode;
                private FhirCanonical definition;

                private Builder() {
                }

                private Builder(SupportedMessage original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.mode = original.mode();
                    this.definition = original.definition();
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
                public Builder mode(FhirEnum<EventCapabilityMode> mode) {
                    this.mode = mode;
                    return this;
                }

                /**
                 * Sets {@code mode}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param mode the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder mode(EventCapabilityMode mode) {
                    return mode(mode == null ? null : FhirEnum.of(mode));
                }

                /**
                 * Sets {@code definition}.
                 *
                 * @param definition the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder definition(FhirCanonical definition) {
                    this.definition = definition;
                    return this;
                }

                /**
                 * Sets {@code definition}, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param definition the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder definition(String definition) {
                    return definition(definition == null ? null : FhirCanonical.of(definition));
                }

                /**
                 * Builds the {@code SupportedMessage}.
                 *
                 * @return the {@code SupportedMessage}
                 * @throws NullPointerException if a required element is absent
                 */
                public SupportedMessage build() {
                    return new SupportedMessage(
                            id, extension, modifierExtension, mode, definition);
                }
            }
        }

        /** Builder for {@link Messaging}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Endpoint> endpoint = new ArrayList<>();
            private FhirUnsignedInt reliableCache;
            private FhirMarkdown documentation;
            private List<SupportedMessage> supportedMessage = new ArrayList<>();

            private Builder() {
            }

            private Builder(Messaging original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.endpoint = new ArrayList<>(original.endpoint());
                this.reliableCache = original.reliableCache();
                this.documentation = original.documentation();
                this.supportedMessage = new ArrayList<>(original.supportedMessage());
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
             * Replaces all {@code endpoint} values.
             *
             * @param endpoint the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder endpoint(List<Endpoint> endpoint) {
                this.endpoint = endpoint == null ? new ArrayList<>() : new ArrayList<>(endpoint);
                return this;
            }

            /**
             * Adds a {@code endpoint} value.
             *
             * @param endpoint the value to add
             * @return this builder
             */
            public Builder addEndpoint(Endpoint endpoint) {
                this.endpoint.add(Objects.requireNonNull(endpoint, "endpoint"));
                return this;
            }

            /**
             * Sets {@code reliableCache}.
             *
             * @param reliableCache the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reliableCache(FhirUnsignedInt reliableCache) {
                this.reliableCache = reliableCache;
                return this;
            }

            /**
             * Sets {@code reliableCache}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
             *
             * @param reliableCache the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reliableCache(Integer reliableCache) {
                return reliableCache(reliableCache == null ? null : FhirUnsignedInt.of(reliableCache));
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
             * Replaces all {@code supportedMessage} values.
             *
             * @param supportedMessage the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder supportedMessage(List<SupportedMessage> supportedMessage) {
                this.supportedMessage = supportedMessage == null
                        ? new ArrayList<>()
                        : new ArrayList<>(supportedMessage);
                return this;
            }

            /**
             * Adds a {@code supportedMessage} value.
             *
             * @param supportedMessage the value to add
             * @return this builder
             */
            public Builder addSupportedMessage(SupportedMessage supportedMessage) {
                this.supportedMessage.add(Objects.requireNonNull(supportedMessage, "supportedMessage"));
                return this;
            }

            /**
             * Builds the {@code Messaging}.
             *
             * @return the {@code Messaging}
             */
            public Messaging build() {
                return new Messaging(
                        id, extension, modifierExtension, endpoint, reliableCache, documentation, supportedMessage);
            }
        }
    }

    /**
     * A document definition.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param mode producer | consumer. Required.
     * @param documentation Description of document support.
     * @param profile Constraint on the resources used in the document. Canonical reference to StructureDefinition.
     *   Required.
     */
    public record Document(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<DocumentMode> mode,
            FhirMarkdown documentation,
            FhirCanonical profile) implements BackboneElement {

        /**
         * Creates a {@code Document}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Document {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(mode, "CapabilityStatement.document.mode is required");
            Objects.requireNonNull(profile, "CapabilityStatement.document.profile is required");
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
         * Returns a builder initialized with the values of this {@code Document}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Document}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<DocumentMode> mode;
            private FhirMarkdown documentation;
            private FhirCanonical profile;

            private Builder() {
            }

            private Builder(Document original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.mode = original.mode();
                this.documentation = original.documentation();
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
             * Sets {@code mode}.
             *
             * @param mode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder mode(FhirEnum<DocumentMode> mode) {
                this.mode = mode;
                return this;
            }

            /**
             * Sets {@code mode}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param mode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder mode(DocumentMode mode) {
                return mode(mode == null ? null : FhirEnum.of(mode));
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
             * Builds the {@code Document}.
             *
             * @return the {@code Document}
             * @throws NullPointerException if a required element is absent
             */
            public Document build() {
                return new Document(
                        id, extension, modifierExtension, mode, documentation, profile);
            }
        }
    }

    /** Builder for {@link CapabilityStatement}. Builders are mutable and not thread-safe. */
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
        private List<FhirCanonical> instantiates = new ArrayList<>();
        private List<FhirCanonical> imports = new ArrayList<>();
        private Software software;
        private Implementation implementation;
        private FhirEnum<FHIRVersion> fhirVersion;
        private List<FhirCode> format = new ArrayList<>();
        private List<FhirCode> patchFormat = new ArrayList<>();
        private List<FhirCode> acceptLanguage = new ArrayList<>();
        private List<FhirCanonical> implementationGuide = new ArrayList<>();
        private List<Rest> rest = new ArrayList<>();
        private List<Messaging> messaging = new ArrayList<>();
        private List<Document> document = new ArrayList<>();

        private Builder() {
        }

        private Builder(CapabilityStatement original) {
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
            this.instantiates = new ArrayList<>(original.instantiates());
            this.imports = new ArrayList<>(original.imports());
            this.software = original.software();
            this.implementation = original.implementation();
            this.fhirVersion = original.fhirVersion();
            this.format = new ArrayList<>(original.format());
            this.patchFormat = new ArrayList<>(original.patchFormat());
            this.acceptLanguage = new ArrayList<>(original.acceptLanguage());
            this.implementationGuide = new ArrayList<>(original.implementationGuide());
            this.rest = new ArrayList<>(original.rest());
            this.messaging = new ArrayList<>(original.messaging());
            this.document = new ArrayList<>(original.document());
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
         * Replaces all {@code instantiates} values.
         *
         * @param instantiates the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder instantiates(List<FhirCanonical> instantiates) {
            this.instantiates = instantiates == null ? new ArrayList<>() : new ArrayList<>(instantiates);
            return this;
        }

        /**
         * Adds a {@code instantiates} value.
         *
         * @param instantiates the value to add
         * @return this builder
         */
        public Builder addInstantiates(FhirCanonical instantiates) {
            this.instantiates.add(Objects.requireNonNull(instantiates, "instantiates"));
            return this;
        }

        /**
         * Adds a {@code instantiates} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param instantiates the value to add
         * @return this builder
         */
        public Builder addInstantiates(String instantiates) {
            return addInstantiates(FhirCanonical.of(instantiates));
        }

        /**
         * Replaces all {@code imports} values.
         *
         * @param imports the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder imports(List<FhirCanonical> imports) {
            this.imports = imports == null ? new ArrayList<>() : new ArrayList<>(imports);
            return this;
        }

        /**
         * Adds a {@code imports} value.
         *
         * @param imports the value to add
         * @return this builder
         */
        public Builder addImports(FhirCanonical imports) {
            this.imports.add(Objects.requireNonNull(imports, "imports"));
            return this;
        }

        /**
         * Adds a {@code imports} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param imports the value to add
         * @return this builder
         */
        public Builder addImports(String imports) {
            return addImports(FhirCanonical.of(imports));
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
         * Replaces all {@code format} values.
         *
         * @param format the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder format(List<FhirCode> format) {
            this.format = format == null ? new ArrayList<>() : new ArrayList<>(format);
            return this;
        }

        /**
         * Adds a {@code format} value.
         *
         * @param format the value to add
         * @return this builder
         */
        public Builder addFormat(FhirCode format) {
            this.format.add(Objects.requireNonNull(format, "format"));
            return this;
        }

        /**
         * Adds a {@code format} value, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param format the value to add
         * @return this builder
         */
        public Builder addFormat(String format) {
            return addFormat(FhirCode.of(format));
        }

        /**
         * Replaces all {@code patchFormat} values.
         *
         * @param patchFormat the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder patchFormat(List<FhirCode> patchFormat) {
            this.patchFormat = patchFormat == null ? new ArrayList<>() : new ArrayList<>(patchFormat);
            return this;
        }

        /**
         * Adds a {@code patchFormat} value.
         *
         * @param patchFormat the value to add
         * @return this builder
         */
        public Builder addPatchFormat(FhirCode patchFormat) {
            this.patchFormat.add(Objects.requireNonNull(patchFormat, "patchFormat"));
            return this;
        }

        /**
         * Adds a {@code patchFormat} value, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param patchFormat the value to add
         * @return this builder
         */
        public Builder addPatchFormat(String patchFormat) {
            return addPatchFormat(FhirCode.of(patchFormat));
        }

        /**
         * Replaces all {@code acceptLanguage} values.
         *
         * @param acceptLanguage the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder acceptLanguage(List<FhirCode> acceptLanguage) {
            this.acceptLanguage = acceptLanguage == null ? new ArrayList<>() : new ArrayList<>(acceptLanguage);
            return this;
        }

        /**
         * Adds a {@code acceptLanguage} value.
         *
         * @param acceptLanguage the value to add
         * @return this builder
         */
        public Builder addAcceptLanguage(FhirCode acceptLanguage) {
            this.acceptLanguage.add(Objects.requireNonNull(acceptLanguage, "acceptLanguage"));
            return this;
        }

        /**
         * Adds a {@code acceptLanguage} value, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param acceptLanguage the value to add
         * @return this builder
         */
        public Builder addAcceptLanguage(String acceptLanguage) {
            return addAcceptLanguage(FhirCode.of(acceptLanguage));
        }

        /**
         * Replaces all {@code implementationGuide} values.
         *
         * @param implementationGuide the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder implementationGuide(List<FhirCanonical> implementationGuide) {
            this.implementationGuide = implementationGuide == null
                    ? new ArrayList<>()
                    : new ArrayList<>(implementationGuide);
            return this;
        }

        /**
         * Adds a {@code implementationGuide} value.
         *
         * @param implementationGuide the value to add
         * @return this builder
         */
        public Builder addImplementationGuide(FhirCanonical implementationGuide) {
            this.implementationGuide.add(Objects.requireNonNull(implementationGuide, "implementationGuide"));
            return this;
        }

        /**
         * Adds a {@code implementationGuide} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param implementationGuide the value to add
         * @return this builder
         */
        public Builder addImplementationGuide(String implementationGuide) {
            return addImplementationGuide(FhirCanonical.of(implementationGuide));
        }

        /**
         * Replaces all {@code rest} values.
         *
         * @param rest the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder rest(List<Rest> rest) {
            this.rest = rest == null ? new ArrayList<>() : new ArrayList<>(rest);
            return this;
        }

        /**
         * Adds a {@code rest} value.
         *
         * @param rest the value to add
         * @return this builder
         */
        public Builder addRest(Rest rest) {
            this.rest.add(Objects.requireNonNull(rest, "rest"));
            return this;
        }

        /**
         * Replaces all {@code messaging} values.
         *
         * @param messaging the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder messaging(List<Messaging> messaging) {
            this.messaging = messaging == null ? new ArrayList<>() : new ArrayList<>(messaging);
            return this;
        }

        /**
         * Adds a {@code messaging} value.
         *
         * @param messaging the value to add
         * @return this builder
         */
        public Builder addMessaging(Messaging messaging) {
            this.messaging.add(Objects.requireNonNull(messaging, "messaging"));
            return this;
        }

        /**
         * Replaces all {@code document} values.
         *
         * @param document the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder document(List<Document> document) {
            this.document = document == null ? new ArrayList<>() : new ArrayList<>(document);
            return this;
        }

        /**
         * Adds a {@code document} value.
         *
         * @param document the value to add
         * @return this builder
         */
        public Builder addDocument(Document document) {
            this.document.add(Objects.requireNonNull(document, "document"));
            return this;
        }

        /**
         * Builds the {@code CapabilityStatement}.
         *
         * @return the {@code CapabilityStatement}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public CapabilityStatement build() {
            return new CapabilityStatement(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, kind, instantiates,
                    imports, software, implementation, fhirVersion, format, patchFormat, acceptLanguage,
                    implementationGuide, rest, messaging, document);
        }
    }
}
