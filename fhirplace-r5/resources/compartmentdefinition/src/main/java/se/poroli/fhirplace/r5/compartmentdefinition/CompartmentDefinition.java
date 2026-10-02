package se.poroli.fhirplace.r5.compartmentdefinition;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.CompartmentType;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.ResourceType;

/**
 * A compartment definition that defines how resources are accessed on a server.
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
 * @param url Canonical identifier for this compartment definition, represented as a URI (globally unique). Required.
 * @param version Business version of the compartment definition.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this compartment definition (computer friendly). Required.
 * @param title Name for this compartment definition (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the compartment definition.
 * @param useContext The context that the content is intended to support.
 * @param purpose Why this compartment definition is defined.
 * @param code Patient | Encounter | RelatedPerson | Practitioner | Device | EpisodeOfCare. Required.
 * @param search Whether the search syntax is supported. Required.
 * @param resource How a resource is related to the compartment.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/CompartmentDefinition">FHIR R5 CompartmentDefinition</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record CompartmentDefinition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirUri url,
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
        FhirMarkdown purpose,
        FhirEnum<CompartmentType> code,
        FhirBoolean search,
        List<CompartmentDefinitionResource> resource) implements DomainResource {

    /**
     * Creates a {@code CompartmentDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public CompartmentDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        resource = resource == null ? List.of() : List.copyOf(resource);
        Objects.requireNonNull(url, "CompartmentDefinition.url is required");
        Objects.requireNonNull(name, "CompartmentDefinition.name is required");
        Objects.requireNonNull(status, "CompartmentDefinition.status is required");
        Objects.requireNonNull(code, "CompartmentDefinition.code is required");
        Objects.requireNonNull(search, "CompartmentDefinition.search is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "CompartmentDefinition.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code CompartmentDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Information about how a resource is related to the compartment.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Name of resource type. Required.
     * @param param Search Parameter Name, or chained parameters.
     * @param documentation Additional documentation about the resource and compartment.
     * @param startParam Search Param for interpreting $everything.start.
     * @param endParam Search Param for interpreting $everything.end.
     */
    public record CompartmentDefinitionResource(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<ResourceType> code,
            List<FhirString> param,
            FhirString documentation,
            FhirUri startParam,
            FhirUri endParam) implements BackboneElement {

        /**
         * Creates a {@code CompartmentDefinitionResource}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public CompartmentDefinitionResource {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            param = param == null ? List.of() : List.copyOf(param);
            Objects.requireNonNull(code, "CompartmentDefinition.resource.code is required");
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
         * Returns a builder initialized with the values of this {@code CompartmentDefinitionResource}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link CompartmentDefinitionResource}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<ResourceType> code;
            private List<FhirString> param = new ArrayList<>();
            private FhirString documentation;
            private FhirUri startParam;
            private FhirUri endParam;

            private Builder() {
            }

            private Builder(CompartmentDefinitionResource original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.param = new ArrayList<>(original.param());
                this.documentation = original.documentation();
                this.startParam = original.startParam();
                this.endParam = original.endParam();
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
            public Builder code(FhirEnum<ResourceType> code) {
                this.code = code;
                return this;
            }

            /**
             * Sets {@code code}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param code the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder code(ResourceType code) {
                return code(code == null ? null : FhirEnum.of(code));
            }

            /**
             * Replaces all {@code param} values.
             *
             * @param param the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder param(List<FhirString> param) {
                this.param = param == null ? new ArrayList<>() : new ArrayList<>(param);
                return this;
            }

            /**
             * Adds a {@code param} value.
             *
             * @param param the value to add
             * @return this builder
             */
            public Builder addParam(FhirString param) {
                this.param.add(Objects.requireNonNull(param, "param"));
                return this;
            }

            /**
             * Adds a {@code param} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param param the value to add
             * @return this builder
             */
            public Builder addParam(String param) {
                return addParam(FhirString.of(param));
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
             * Sets {@code startParam}.
             *
             * @param startParam the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder startParam(FhirUri startParam) {
                this.startParam = startParam;
                return this;
            }

            /**
             * Sets {@code startParam}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param startParam the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder startParam(String startParam) {
                return startParam(startParam == null ? null : FhirUri.of(startParam));
            }

            /**
             * Sets {@code endParam}.
             *
             * @param endParam the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder endParam(FhirUri endParam) {
                this.endParam = endParam;
                return this;
            }

            /**
             * Sets {@code endParam}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param endParam the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder endParam(String endParam) {
                return endParam(endParam == null ? null : FhirUri.of(endParam));
            }

            /**
             * Builds the {@code CompartmentDefinitionResource}.
             *
             * @return the {@code CompartmentDefinitionResource}
             * @throws NullPointerException if a required element is absent
             */
            public CompartmentDefinitionResource build() {
                return new CompartmentDefinitionResource(
                        id, extension, modifierExtension, code, param, documentation, startParam, endParam);
            }
        }
    }

    /** Builder for {@link CompartmentDefinition}. Builders are mutable and not thread-safe. */
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
        private FhirMarkdown purpose;
        private FhirEnum<CompartmentType> code;
        private FhirBoolean search;
        private List<CompartmentDefinitionResource> resource = new ArrayList<>();

        private Builder() {
        }

        private Builder(CompartmentDefinition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.url = original.url();
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
            this.purpose = original.purpose();
            this.code = original.code();
            this.search = original.search();
            this.resource = new ArrayList<>(original.resource());
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
         * Sets {@code code}.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(FhirEnum<CompartmentType> code) {
            this.code = code;
            return this;
        }

        /**
         * Sets {@code code}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(CompartmentType code) {
            return code(code == null ? null : FhirEnum.of(code));
        }

        /**
         * Sets {@code search}.
         *
         * @param search the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder search(FhirBoolean search) {
            this.search = search;
            return this;
        }

        /**
         * Sets {@code search}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param search the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder search(Boolean search) {
            return search(search == null ? null : FhirBoolean.of(search));
        }

        /**
         * Replaces all {@code resource} values.
         *
         * @param resource the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder resource(List<CompartmentDefinitionResource> resource) {
            this.resource = resource == null ? new ArrayList<>() : new ArrayList<>(resource);
            return this;
        }

        /**
         * Adds a {@code resource} value.
         *
         * @param resource the value to add
         * @return this builder
         */
        public Builder addResource(CompartmentDefinitionResource resource) {
            this.resource.add(Objects.requireNonNull(resource, "resource"));
            return this;
        }

        /**
         * Builds the {@code CompartmentDefinition}.
         *
         * @return the {@code CompartmentDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public CompartmentDefinition build() {
            return new CompartmentDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, version,
                    versionAlgorithm, name, title, status, experimental, date, publisher, contact, description,
                    useContext, purpose, code, search, resource);
        }
    }
}
