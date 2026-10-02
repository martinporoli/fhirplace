package se.poroli.fhirplace.r5.messageheader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * The header for a message exchange that is either requesting or responding to an action.
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
 * @param event Event code or link to EventDefinition. One of Coding, canonical. Required.
 * @param destination Message destination application(s).
 * @param sender Real world sender of the message. Reference to Practitioner, PractitionerRole, Device, Organization.
 * @param author The source of the decision. Reference to Practitioner, PractitionerRole, Device, Organization.
 * @param source Message source application. Required.
 * @param responsible Final responsibility for event. Reference to Practitioner, PractitionerRole, Organization.
 * @param reason Cause of event.
 * @param response If this is a reply to prior message.
 * @param focus The actual content of the message. Reference to Resource.
 * @param definition Link to the definition for this message. Canonical reference to MessageDefinition.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MessageHeader">FHIR R5 MessageHeader</a>
 */
public record MessageHeader(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        DataType event,
        List<MessageDestination> destination,
        Reference sender,
        Reference author,
        MessageSource source,
        Reference responsible,
        CodeableConcept reason,
        Response response,
        List<Reference> focus,
        FhirCanonical definition) implements DomainResource {

    /**
     * Creates a {@code MessageHeader}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public MessageHeader {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        destination = destination == null ? List.of() : List.copyOf(destination);
        focus = focus == null ? List.of() : List.copyOf(focus);
        Objects.requireNonNull(event, "MessageHeader.event is required");
        Objects.requireNonNull(source, "MessageHeader.source is required");
        if (event != null && !(event instanceof Coding || event instanceof FhirCanonical)) {
            throw new IllegalArgumentException(
                    "MessageHeader.event[x] must be one of Coding, canonical, but was "
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
     * Returns a builder initialized with the values of this {@code MessageHeader}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The destination application which the message is intended for.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param endpoint Actual destination address or Endpoint resource. One of url, Reference.
     * @param name Name of system.
     * @param target Particular delivery destination within the destination. Reference to Device.
     * @param receiver Intended "real-world" recipient for the data. Reference to Practitioner, PractitionerRole,
     *   Organization.
     */
    public record MessageDestination(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType endpoint,
            FhirString name,
            Reference target,
            Reference receiver) implements BackboneElement {

        /**
         * Creates a {@code MessageDestination}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public MessageDestination {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (endpoint != null && !(endpoint instanceof FhirUrl || endpoint instanceof Reference)) {
                throw new IllegalArgumentException(
                        "MessageHeader.destination.endpoint[x] must be one of url, Reference, but was "
                                + endpoint.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code MessageDestination}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link MessageDestination}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType endpoint;
            private FhirString name;
            private Reference target;
            private Reference receiver;

            private Builder() {
            }

            private Builder(MessageDestination original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.endpoint = original.endpoint();
                this.name = original.name();
                this.target = original.target();
                this.receiver = original.receiver();
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
             * Sets {@code endpoint} to a url.
             *
             * @param endpoint the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder endpoint(FhirUrl endpoint) {
                this.endpoint = endpoint;
                return this;
            }

            /**
             * Sets {@code endpoint} to a Reference.
             *
             * @param endpoint the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder endpoint(Reference endpoint) {
                this.endpoint = endpoint;
                return this;
            }

            /**
             * Sets {@code endpoint} to a url without id or extensions.
             *
             * @param endpoint the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder endpoint(String endpoint) {
                this.endpoint = endpoint == null ? null : FhirUrl.of(endpoint);
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
             * Sets {@code target}.
             *
             * @param target the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder target(Reference target) {
                this.target = target;
                return this;
            }

            /**
             * Sets {@code receiver}.
             *
             * @param receiver the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder receiver(Reference receiver) {
                this.receiver = receiver;
                return this;
            }

            /**
             * Builds the {@code MessageDestination}.
             *
             * @return the {@code MessageDestination}
             */
            public MessageDestination build() {
                return new MessageDestination(
                        id, extension, modifierExtension, endpoint, name, target, receiver);
            }
        }
    }

    /**
     * The source application from which this message originated.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param endpoint Actual source address or Endpoint resource. One of url, Reference.
     * @param name Name of system.
     * @param software Name of software running the system.
     * @param version Version of software running.
     * @param contact Human contact for problems.
     */
    public record MessageSource(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType endpoint,
            FhirString name,
            FhirString software,
            FhirString version,
            ContactPoint contact) implements BackboneElement {

        /**
         * Creates a {@code MessageSource}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public MessageSource {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (endpoint != null && !(endpoint instanceof FhirUrl || endpoint instanceof Reference)) {
                throw new IllegalArgumentException(
                        "MessageHeader.source.endpoint[x] must be one of url, Reference, but was "
                                + endpoint.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code MessageSource}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link MessageSource}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType endpoint;
            private FhirString name;
            private FhirString software;
            private FhirString version;
            private ContactPoint contact;

            private Builder() {
            }

            private Builder(MessageSource original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.endpoint = original.endpoint();
                this.name = original.name();
                this.software = original.software();
                this.version = original.version();
                this.contact = original.contact();
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
             * Sets {@code endpoint} to a url.
             *
             * @param endpoint the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder endpoint(FhirUrl endpoint) {
                this.endpoint = endpoint;
                return this;
            }

            /**
             * Sets {@code endpoint} to a Reference.
             *
             * @param endpoint the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder endpoint(Reference endpoint) {
                this.endpoint = endpoint;
                return this;
            }

            /**
             * Sets {@code endpoint} to a url without id or extensions.
             *
             * @param endpoint the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder endpoint(String endpoint) {
                this.endpoint = endpoint == null ? null : FhirUrl.of(endpoint);
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
             * Sets {@code software}.
             *
             * @param software the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder software(FhirString software) {
                this.software = software;
                return this;
            }

            /**
             * Sets {@code software}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param software the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder software(String software) {
                return software(software == null ? null : FhirString.of(software));
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
             * Sets {@code contact}.
             *
             * @param contact the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder contact(ContactPoint contact) {
                this.contact = contact;
                return this;
            }

            /**
             * Builds the {@code MessageSource}.
             *
             * @return the {@code MessageSource}
             */
            public MessageSource build() {
                return new MessageSource(
                        id, extension, modifierExtension, endpoint, name, software, version, contact);
            }
        }
    }

    /**
     * Information about the message that this message is a response to.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier Bundle.identifier of original message. Required.
     * @param code ok | transient-error | fatal-error. Required.
     * @param details Specific list of hints/warnings/errors. Reference to OperationOutcome.
     */
    public record Response(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Identifier identifier,
            FhirEnum<ResponseType> code,
            Reference details) implements BackboneElement {

        /**
         * Creates a {@code Response}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Response {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(identifier, "MessageHeader.response.identifier is required");
            Objects.requireNonNull(code, "MessageHeader.response.code is required");
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
         * Returns a builder initialized with the values of this {@code Response}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Response}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Identifier identifier;
            private FhirEnum<ResponseType> code;
            private Reference details;

            private Builder() {
            }

            private Builder(Response original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = original.identifier();
                this.code = original.code();
                this.details = original.details();
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
             * Sets {@code identifier}.
             *
             * @param identifier the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identifier(Identifier identifier) {
                this.identifier = identifier;
                return this;
            }

            /**
             * Sets {@code code}.
             *
             * @param code the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder code(FhirEnum<ResponseType> code) {
                this.code = code;
                return this;
            }

            /**
             * Sets {@code code}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param code the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder code(ResponseType code) {
                return code(code == null ? null : FhirEnum.of(code));
            }

            /**
             * Sets {@code details}.
             *
             * @param details the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder details(Reference details) {
                this.details = details;
                return this;
            }

            /**
             * Builds the {@code Response}.
             *
             * @return the {@code Response}
             * @throws NullPointerException if a required element is absent
             */
            public Response build() {
                return new Response(
                        id, extension, modifierExtension, identifier, code, details);
            }
        }
    }

    /** Builder for {@link MessageHeader}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private DataType event;
        private List<MessageDestination> destination = new ArrayList<>();
        private Reference sender;
        private Reference author;
        private MessageSource source;
        private Reference responsible;
        private CodeableConcept reason;
        private Response response;
        private List<Reference> focus = new ArrayList<>();
        private FhirCanonical definition;

        private Builder() {
        }

        private Builder(MessageHeader original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.event = original.event();
            this.destination = new ArrayList<>(original.destination());
            this.sender = original.sender();
            this.author = original.author();
            this.source = original.source();
            this.responsible = original.responsible();
            this.reason = original.reason();
            this.response = original.response();
            this.focus = new ArrayList<>(original.focus());
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
         * Sets {@code event} to a canonical.
         *
         * @param event the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder event(FhirCanonical event) {
            this.event = event;
            return this;
        }

        /**
         * Sets {@code event} to a canonical without id or extensions.
         *
         * @param event the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder event(String event) {
            this.event = event == null ? null : FhirCanonical.of(event);
            return this;
        }

        /**
         * Replaces all {@code destination} values.
         *
         * @param destination the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder destination(List<MessageDestination> destination) {
            this.destination = destination == null ? new ArrayList<>() : new ArrayList<>(destination);
            return this;
        }

        /**
         * Adds a {@code destination} value.
         *
         * @param destination the value to add
         * @return this builder
         */
        public Builder addDestination(MessageDestination destination) {
            this.destination.add(Objects.requireNonNull(destination, "destination"));
            return this;
        }

        /**
         * Sets {@code sender}.
         *
         * @param sender the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sender(Reference sender) {
            this.sender = sender;
            return this;
        }

        /**
         * Sets {@code author}.
         *
         * @param author the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder author(Reference author) {
            this.author = author;
            return this;
        }

        /**
         * Sets {@code source}.
         *
         * @param source the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder source(MessageSource source) {
            this.source = source;
            return this;
        }

        /**
         * Sets {@code responsible}.
         *
         * @param responsible the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder responsible(Reference responsible) {
            this.responsible = responsible;
            return this;
        }

        /**
         * Sets {@code reason}.
         *
         * @param reason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reason(CodeableConcept reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Sets {@code response}.
         *
         * @param response the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder response(Response response) {
            this.response = response;
            return this;
        }

        /**
         * Replaces all {@code focus} values.
         *
         * @param focus the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder focus(List<Reference> focus) {
            this.focus = focus == null ? new ArrayList<>() : new ArrayList<>(focus);
            return this;
        }

        /**
         * Adds a {@code focus} value.
         *
         * @param focus the value to add
         * @return this builder
         */
        public Builder addFocus(Reference focus) {
            this.focus.add(Objects.requireNonNull(focus, "focus"));
            return this;
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
         * Builds the {@code MessageHeader}.
         *
         * @return the {@code MessageHeader}
         * @throws NullPointerException if a required element is absent
         */
        public MessageHeader build() {
            return new MessageHeader(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, event,
                    destination, sender, author, source, responsible, reason, response, focus, definition);
        }
    }
}
