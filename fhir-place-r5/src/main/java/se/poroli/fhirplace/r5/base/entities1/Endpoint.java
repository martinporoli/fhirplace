package se.poroli.fhirplace.r5.base.entities1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.EndpointStatus;

/**
 * The technical details of an endpoint that can be used for electronic services, such as for web services providing
 * XDS.b, a REST endpoint for another FHIR server, or a s/Mime email address.
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
 * @param identifier Identifies this endpoint across multiple systems.
 * @param status active | suspended | error | off | entered-in-error | test. Required. Modifier element.
 * @param connectionType Protocol/Profile/Standard to be used with this endpoint connection. Required.
 * @param name A name that this endpoint can be identified by.
 * @param description Additional details about the endpoint that could be displayed as further information to identify
 *   the description beyond its name.
 * @param environmentType The type of environment(s) exposed at this endpoint.
 * @param managingOrganization Organization that manages this endpoint (might not be the organization that exposes the
 *   endpoint). Reference to Organization.
 * @param contact Contact details for source (e.g. troubleshooting).
 * @param period Interval the endpoint is expected to be operational.
 * @param payload Set of payloads that are provided by this endpoint.
 * @param address The technical base address for connecting to this endpoint. Required.
 * @param header Usage depends on the channel type.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Endpoint">FHIR R5 Endpoint</a>
 */
public record Endpoint(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<EndpointStatus> status,
        List<CodeableConcept> connectionType,
        FhirString name,
        FhirString description,
        List<CodeableConcept> environmentType,
        Reference managingOrganization,
        List<ContactPoint> contact,
        Period period,
        List<Payload> payload,
        FhirUrl address,
        List<FhirString> header) implements DomainResource {

    /**
     * Creates an {@code Endpoint}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a required list is empty
     */
    public Endpoint {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        connectionType = connectionType == null ? List.of() : List.copyOf(connectionType);
        environmentType = environmentType == null ? List.of() : List.copyOf(environmentType);
        contact = contact == null ? List.of() : List.copyOf(contact);
        payload = payload == null ? List.of() : List.copyOf(payload);
        header = header == null ? List.of() : List.copyOf(header);
        Objects.requireNonNull(status, "Endpoint.status is required");
        if (connectionType.isEmpty()) {
            throw new IllegalArgumentException("Endpoint.connectionType requires at least one value");
        }
        Objects.requireNonNull(address, "Endpoint.address is required");
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

    /**
     * The set of payloads that are provided/available at this endpoint.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type The type of content that may be used at this endpoint (e.g. XDS Discharge summaries).
     * @param mimeType Mimetype to send. If not specified, the content could be anything (including no payload, if the
     *   connectionType defined this).
     */
    public record Payload(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableConcept> type,
            List<FhirCode> mimeType) implements BackboneElement {

        /**
         * Creates a {@code Payload}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Payload {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            type = type == null ? List.of() : List.copyOf(type);
            mimeType = mimeType == null ? List.of() : List.copyOf(mimeType);
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
         * Returns a builder initialized with the values of this {@code Payload}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Payload}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<CodeableConcept> type = new ArrayList<>();
            private List<FhirCode> mimeType = new ArrayList<>();

            private Builder() {
            }

            private Builder(Payload original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = new ArrayList<>(original.type());
                this.mimeType = new ArrayList<>(original.mimeType());
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
             * Replaces all {@code type} values.
             *
             * @param type the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder type(List<CodeableConcept> type) {
                this.type = type == null ? new ArrayList<>() : new ArrayList<>(type);
                return this;
            }

            /**
             * Adds a {@code type} value.
             *
             * @param type the value to add
             * @return this builder
             */
            public Builder addType(CodeableConcept type) {
                this.type.add(Objects.requireNonNull(type, "type"));
                return this;
            }

            /**
             * Replaces all {@code mimeType} values.
             *
             * @param mimeType the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder mimeType(List<FhirCode> mimeType) {
                this.mimeType = mimeType == null ? new ArrayList<>() : new ArrayList<>(mimeType);
                return this;
            }

            /**
             * Adds a {@code mimeType} value.
             *
             * @param mimeType the value to add
             * @return this builder
             */
            public Builder addMimeType(FhirCode mimeType) {
                this.mimeType.add(Objects.requireNonNull(mimeType, "mimeType"));
                return this;
            }

            /**
             * Adds a {@code mimeType} value, wrapped in a {@link FhirCode} without id or extensions.
             *
             * @param mimeType the value to add
             * @return this builder
             */
            public Builder addMimeType(String mimeType) {
                return addMimeType(FhirCode.of(mimeType));
            }

            /**
             * Builds the {@code Payload}.
             *
             * @return the {@code Payload}
             */
            public Payload build() {
                return new Payload(
                        id, extension, modifierExtension, type, mimeType);
            }
        }
    }

    /** Builder for {@link Endpoint}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private List<Identifier> identifier = new ArrayList<>();
        private FhirEnum<EndpointStatus> status;
        private List<CodeableConcept> connectionType = new ArrayList<>();
        private FhirString name;
        private FhirString description;
        private List<CodeableConcept> environmentType = new ArrayList<>();
        private Reference managingOrganization;
        private List<ContactPoint> contact = new ArrayList<>();
        private Period period;
        private List<Payload> payload = new ArrayList<>();
        private FhirUrl address;
        private List<FhirString> header = new ArrayList<>();

        private Builder() {
        }

        private Builder(Endpoint original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.status = original.status();
            this.connectionType = new ArrayList<>(original.connectionType());
            this.name = original.name();
            this.description = original.description();
            this.environmentType = new ArrayList<>(original.environmentType());
            this.managingOrganization = original.managingOrganization();
            this.contact = new ArrayList<>(original.contact());
            this.period = original.period();
            this.payload = new ArrayList<>(original.payload());
            this.address = original.address();
            this.header = new ArrayList<>(original.header());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<EndpointStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(EndpointStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Replaces all {@code connectionType} values.
         *
         * @param connectionType the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder connectionType(List<CodeableConcept> connectionType) {
            this.connectionType = connectionType == null ? new ArrayList<>() : new ArrayList<>(connectionType);
            return this;
        }

        /**
         * Adds a {@code connectionType} value.
         *
         * @param connectionType the value to add
         * @return this builder
         */
        public Builder addConnectionType(CodeableConcept connectionType) {
            this.connectionType.add(Objects.requireNonNull(connectionType, "connectionType"));
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
         * Replaces all {@code environmentType} values.
         *
         * @param environmentType the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder environmentType(List<CodeableConcept> environmentType) {
            this.environmentType = environmentType == null ? new ArrayList<>() : new ArrayList<>(environmentType);
            return this;
        }

        /**
         * Adds a {@code environmentType} value.
         *
         * @param environmentType the value to add
         * @return this builder
         */
        public Builder addEnvironmentType(CodeableConcept environmentType) {
            this.environmentType.add(Objects.requireNonNull(environmentType, "environmentType"));
            return this;
        }

        /**
         * Sets {@code managingOrganization}.
         *
         * @param managingOrganization the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder managingOrganization(Reference managingOrganization) {
            this.managingOrganization = managingOrganization;
            return this;
        }

        /**
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ContactPoint> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ContactPoint contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
            return this;
        }

        /**
         * Sets {@code period}.
         *
         * @param period the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder period(Period period) {
            this.period = period;
            return this;
        }

        /**
         * Replaces all {@code payload} values.
         *
         * @param payload the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder payload(List<Payload> payload) {
            this.payload = payload == null ? new ArrayList<>() : new ArrayList<>(payload);
            return this;
        }

        /**
         * Adds a {@code payload} value.
         *
         * @param payload the value to add
         * @return this builder
         */
        public Builder addPayload(Payload payload) {
            this.payload.add(Objects.requireNonNull(payload, "payload"));
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
         * Replaces all {@code header} values.
         *
         * @param header the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder header(List<FhirString> header) {
            this.header = header == null ? new ArrayList<>() : new ArrayList<>(header);
            return this;
        }

        /**
         * Adds a {@code header} value.
         *
         * @param header the value to add
         * @return this builder
         */
        public Builder addHeader(FhirString header) {
            this.header.add(Objects.requireNonNull(header, "header"));
            return this;
        }

        /**
         * Adds a {@code header} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param header the value to add
         * @return this builder
         */
        public Builder addHeader(String header) {
            return addHeader(FhirString.of(header));
        }

        /**
         * Builds the {@code Endpoint}.
         *
         * @return the {@code Endpoint}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public Endpoint build() {
            return new Endpoint(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, connectionType, name, description, environmentType, managingOrganization, contact, period,
                    payload, address, header);
        }
    }
}
