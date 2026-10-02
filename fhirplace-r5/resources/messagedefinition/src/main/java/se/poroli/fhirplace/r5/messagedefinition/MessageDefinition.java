package se.poroli.fhirplace.r5.messagedefinition;

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
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.ResourceType;

/**
 * Defines the characteristics of a message that can be shared between systems, including the type of event that
 * initiates the message, the content to be transmitted and what response(s), if any, are permitted.
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
 * @param url The cannonical URL for a given MessageDefinition.
 * @param identifier Business Identifier for a given MessageDefinition.
 * @param version Business version of the message definition.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this message definition (computer friendly).
 * @param title Name for this message definition (human friendly).
 * @param replaces Takes the place of. Canonical reference to MessageDefinition.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed. Required.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the message definition.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for message definition (if applicable).
 * @param purpose Why this message definition is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param base Definition this one is based on. Canonical reference to MessageDefinition.
 * @param parent Protocol/workflow this is part of. Canonical reference to ActivityDefinition, PlanDefinition.
 * @param event Event code or link to the EventDefinition. One of Coding, uri. Required.
 * @param category consequence | currency | notification.
 * @param focus Resource(s) that are the subject of the event.
 * @param responseRequired always | on-error | never | on-success.
 * @param allowedResponse Responses to this message.
 * @param graph Canonical reference to a GraphDefinition. Canonical reference to GraphDefinition.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MessageDefinition">FHIR R5 MessageDefinition</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record MessageDefinition(
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
        List<FhirCanonical> replaces,
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
        FhirCanonical base,
        List<FhirCanonical> parent,
        DataType event,
        FhirEnum<MessageSignificanceCategory> category,
        List<Focus> focus,
        FhirEnum<MessageheaderResponseRequest> responseRequired,
        List<AllowedResponse> allowedResponse,
        FhirCanonical graph) implements DomainResource {

    /**
     * Creates a {@code MessageDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public MessageDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        replaces = replaces == null ? List.of() : List.copyOf(replaces);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        parent = parent == null ? List.of() : List.copyOf(parent);
        focus = focus == null ? List.of() : List.copyOf(focus);
        allowedResponse = allowedResponse == null ? List.of() : List.copyOf(allowedResponse);
        Objects.requireNonNull(status, "MessageDefinition.status is required");
        Objects.requireNonNull(date, "MessageDefinition.date is required");
        Objects.requireNonNull(event, "MessageDefinition.event is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "MessageDefinition.versionAlgorithm[x] must be one of string, Coding, but was "
                            + versionAlgorithm.getClass().getSimpleName());
        }
        if (event != null && !(event instanceof Coding || event instanceof FhirUri)) {
            throw new IllegalArgumentException(
                    "MessageDefinition.event[x] must be one of Coding, uri, but was "
                            + event.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code MessageDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Identifies the resource (or resources) that are being addressed by the event.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Type of resource. Required.
     * @param profile Profile that must be adhered to by focus. Canonical reference to StructureDefinition.
     * @param min Minimum number of focuses of this type. Required.
     * @param max Maximum number of focuses of this type.
     */
    public record Focus(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<ResourceType> code,
            FhirCanonical profile,
            FhirUnsignedInt min,
            FhirString max) implements BackboneElement {

        /**
         * Creates a {@code Focus}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Focus {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(code, "MessageDefinition.focus.code is required");
            Objects.requireNonNull(min, "MessageDefinition.focus.min is required");
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
         * Returns a builder initialized with the values of this {@code Focus}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Focus}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<ResourceType> code;
            private FhirCanonical profile;
            private FhirUnsignedInt min;
            private FhirString max;

            private Builder() {
            }

            private Builder(Focus original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.profile = original.profile();
                this.min = original.min();
                this.max = original.max();
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
             * Sets {@code min}.
             *
             * @param min the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder min(FhirUnsignedInt min) {
                this.min = min;
                return this;
            }

            /**
             * Sets {@code min}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
             *
             * @param min the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder min(Integer min) {
                return min(min == null ? null : FhirUnsignedInt.of(min));
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
             * Builds the {@code Focus}.
             *
             * @return the {@code Focus}
             * @throws NullPointerException if a required element is absent
             */
            public Focus build() {
                return new Focus(
                        id, extension, modifierExtension, code, profile, min, max);
            }
        }
    }

    /**
     * Indicates what types of messages may be sent as an application-level response to this message.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param message Reference to allowed message definition response. Canonical reference to MessageDefinition.
     *   Required.
     * @param situation When should this response be used.
     */
    public record AllowedResponse(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCanonical message,
            FhirMarkdown situation) implements BackboneElement {

        /**
         * Creates an {@code AllowedResponse}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public AllowedResponse {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(message, "MessageDefinition.allowedResponse.message is required");
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
         * Returns a builder initialized with the values of this {@code AllowedResponse}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link AllowedResponse}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCanonical message;
            private FhirMarkdown situation;

            private Builder() {
            }

            private Builder(AllowedResponse original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.message = original.message();
                this.situation = original.situation();
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
             * Sets {@code message}.
             *
             * @param message the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder message(FhirCanonical message) {
                this.message = message;
                return this;
            }

            /**
             * Sets {@code message}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param message the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder message(String message) {
                return message(message == null ? null : FhirCanonical.of(message));
            }

            /**
             * Sets {@code situation}.
             *
             * @param situation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder situation(FhirMarkdown situation) {
                this.situation = situation;
                return this;
            }

            /**
             * Sets {@code situation}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param situation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder situation(String situation) {
                return situation(situation == null ? null : FhirMarkdown.of(situation));
            }

            /**
             * Builds the {@code AllowedResponse}.
             *
             * @return the {@code AllowedResponse}
             * @throws NullPointerException if a required element is absent
             */
            public AllowedResponse build() {
                return new AllowedResponse(
                        id, extension, modifierExtension, message, situation);
            }
        }
    }

    /** Builder for {@link MessageDefinition}. Builders are mutable and not thread-safe. */
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
        private List<FhirCanonical> replaces = new ArrayList<>();
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
        private FhirCanonical base;
        private List<FhirCanonical> parent = new ArrayList<>();
        private DataType event;
        private FhirEnum<MessageSignificanceCategory> category;
        private List<Focus> focus = new ArrayList<>();
        private FhirEnum<MessageheaderResponseRequest> responseRequired;
        private List<AllowedResponse> allowedResponse = new ArrayList<>();
        private FhirCanonical graph;

        private Builder() {
        }

        private Builder(MessageDefinition original) {
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
            this.replaces = new ArrayList<>(original.replaces());
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
            this.base = original.base();
            this.parent = new ArrayList<>(original.parent());
            this.event = original.event();
            this.category = original.category();
            this.focus = new ArrayList<>(original.focus());
            this.responseRequired = original.responseRequired();
            this.allowedResponse = new ArrayList<>(original.allowedResponse());
            this.graph = original.graph();
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
         * Replaces all {@code replaces} values.
         *
         * @param replaces the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder replaces(List<FhirCanonical> replaces) {
            this.replaces = replaces == null ? new ArrayList<>() : new ArrayList<>(replaces);
            return this;
        }

        /**
         * Adds a {@code replaces} value.
         *
         * @param replaces the value to add
         * @return this builder
         */
        public Builder addReplaces(FhirCanonical replaces) {
            this.replaces.add(Objects.requireNonNull(replaces, "replaces"));
            return this;
        }

        /**
         * Adds a {@code replaces} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param replaces the value to add
         * @return this builder
         */
        public Builder addReplaces(String replaces) {
            return addReplaces(FhirCanonical.of(replaces));
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
         * Replaces all {@code parent} values.
         *
         * @param parent the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder parent(List<FhirCanonical> parent) {
            this.parent = parent == null ? new ArrayList<>() : new ArrayList<>(parent);
            return this;
        }

        /**
         * Adds a {@code parent} value.
         *
         * @param parent the value to add
         * @return this builder
         */
        public Builder addParent(FhirCanonical parent) {
            this.parent.add(Objects.requireNonNull(parent, "parent"));
            return this;
        }

        /**
         * Adds a {@code parent} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param parent the value to add
         * @return this builder
         */
        public Builder addParent(String parent) {
            return addParent(FhirCanonical.of(parent));
        }

        /**
         * Sets {@code event} to a Coding.
         *
         * @param event the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder event(Coding event) {
            this.event = event;
            return this;
        }

        /**
         * Sets {@code event} to a uri.
         *
         * @param event the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder event(FhirUri event) {
            this.event = event;
            return this;
        }

        /**
         * Sets {@code event} to a uri without id or extensions.
         *
         * @param event the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder event(String event) {
            this.event = event == null ? null : FhirUri.of(event);
            return this;
        }

        /**
         * Sets {@code category}.
         *
         * @param category the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder category(FhirEnum<MessageSignificanceCategory> category) {
            this.category = category;
            return this;
        }

        /**
         * Sets {@code category}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param category the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder category(MessageSignificanceCategory category) {
            return category(category == null ? null : FhirEnum.of(category));
        }

        /**
         * Replaces all {@code focus} values.
         *
         * @param focus the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder focus(List<Focus> focus) {
            this.focus = focus == null ? new ArrayList<>() : new ArrayList<>(focus);
            return this;
        }

        /**
         * Adds a {@code focus} value.
         *
         * @param focus the value to add
         * @return this builder
         */
        public Builder addFocus(Focus focus) {
            this.focus.add(Objects.requireNonNull(focus, "focus"));
            return this;
        }

        /**
         * Sets {@code responseRequired}.
         *
         * @param responseRequired the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder responseRequired(FhirEnum<MessageheaderResponseRequest> responseRequired) {
            this.responseRequired = responseRequired;
            return this;
        }

        /**
         * Sets {@code responseRequired}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param responseRequired the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder responseRequired(MessageheaderResponseRequest responseRequired) {
            return responseRequired(responseRequired == null ? null : FhirEnum.of(responseRequired));
        }

        /**
         * Replaces all {@code allowedResponse} values.
         *
         * @param allowedResponse the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder allowedResponse(List<AllowedResponse> allowedResponse) {
            this.allowedResponse = allowedResponse == null ? new ArrayList<>() : new ArrayList<>(allowedResponse);
            return this;
        }

        /**
         * Adds a {@code allowedResponse} value.
         *
         * @param allowedResponse the value to add
         * @return this builder
         */
        public Builder addAllowedResponse(AllowedResponse allowedResponse) {
            this.allowedResponse.add(Objects.requireNonNull(allowedResponse, "allowedResponse"));
            return this;
        }

        /**
         * Sets {@code graph}.
         *
         * @param graph the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder graph(FhirCanonical graph) {
            this.graph = graph;
            return this;
        }

        /**
         * Sets {@code graph}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param graph the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder graph(String graph) {
            return graph(graph == null ? null : FhirCanonical.of(graph));
        }

        /**
         * Builds the {@code MessageDefinition}.
         *
         * @return the {@code MessageDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public MessageDefinition build() {
            return new MessageDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, replaces, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, base, parent, event,
                    category, focus, responseRequired, allowedResponse, graph);
        }
    }
}
