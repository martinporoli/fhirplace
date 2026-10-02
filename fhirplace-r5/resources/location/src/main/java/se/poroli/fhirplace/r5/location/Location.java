package se.poroli.fhirplace.r5.location;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Availability;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * Details and position information for a place where services are provided and resources and participants may be
 * stored, found, contained, or accommodated.
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
 * @param identifier Unique code or number identifying the location to its users.
 * @param status active | suspended | inactive. Modifier element.
 * @param operationalStatus The operational status of the location (typically only for a bed/room).
 * @param name Name of the location as used by humans.
 * @param alias A list of alternate names that the location is known as, or was known as, in the past.
 * @param description Additional details about the location that could be displayed as further information to identify
 *   the location beyond its name.
 * @param mode instance | kind.
 * @param type Type of function performed.
 * @param contact Official contact details for the location.
 * @param address Physical location.
 * @param form Physical form of the location.
 * @param position The absolute geographic location.
 * @param managingOrganization Organization responsible for provisioning and upkeep. Reference to Organization.
 * @param partOf Another Location this one is physically a part of. Reference to Location.
 * @param characteristic Collection of characteristics (attributes).
 * @param hoursOfOperation What days/times during a week is this location usually open (including exceptions).
 * @param virtualService Connection details of a virtual service (e.g. conference call).
 * @param endpoint Technical endpoints providing access to services operated for the location. Reference to Endpoint.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Location">FHIR R5 Location</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Location(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<LocationStatus> status,
        Coding operationalStatus,
        FhirString name,
        List<FhirString> alias,
        FhirMarkdown description,
        FhirEnum<LocationMode> mode,
        List<CodeableConcept> type,
        List<ExtendedContactDetail> contact,
        Address address,
        CodeableConcept form,
        Position position,
        Reference managingOrganization,
        Reference partOf,
        List<CodeableConcept> characteristic,
        List<Availability> hoursOfOperation,
        List<VirtualServiceDetail> virtualService,
        List<Reference> endpoint) implements DomainResource {

    /**
     * Creates a {@code Location}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Location {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        alias = alias == null ? List.of() : List.copyOf(alias);
        type = type == null ? List.of() : List.copyOf(type);
        contact = contact == null ? List.of() : List.copyOf(contact);
        characteristic = characteristic == null ? List.of() : List.copyOf(characteristic);
        hoursOfOperation = hoursOfOperation == null ? List.of() : List.copyOf(hoursOfOperation);
        virtualService = virtualService == null ? List.of() : List.copyOf(virtualService);
        endpoint = endpoint == null ? List.of() : List.copyOf(endpoint);
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
     * Returns a builder initialized with the values of this {@code Location}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The absolute geographic location of the Location, expressed using the WGS84 datum (This is the same co-ordinate
     * system used in KML).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param longitude Longitude with WGS84 datum. Required.
     * @param latitude Latitude with WGS84 datum. Required.
     * @param altitude Altitude with WGS84 datum.
     */
    public record Position(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirDecimal longitude,
            FhirDecimal latitude,
            FhirDecimal altitude) implements BackboneElement {

        /**
         * Creates a {@code Position}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Position {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(longitude, "Location.position.longitude is required");
            Objects.requireNonNull(latitude, "Location.position.latitude is required");
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
         * Returns a builder initialized with the values of this {@code Position}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Position}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirDecimal longitude;
            private FhirDecimal latitude;
            private FhirDecimal altitude;

            private Builder() {
            }

            private Builder(Position original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.longitude = original.longitude();
                this.latitude = original.latitude();
                this.altitude = original.altitude();
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
             * Sets {@code longitude}.
             *
             * @param longitude the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder longitude(FhirDecimal longitude) {
                this.longitude = longitude;
                return this;
            }

            /**
             * Sets {@code longitude}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param longitude the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder longitude(BigDecimal longitude) {
                return longitude(longitude == null ? null : FhirDecimal.of(longitude));
            }

            /**
             * Sets {@code latitude}.
             *
             * @param latitude the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder latitude(FhirDecimal latitude) {
                this.latitude = latitude;
                return this;
            }

            /**
             * Sets {@code latitude}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param latitude the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder latitude(BigDecimal latitude) {
                return latitude(latitude == null ? null : FhirDecimal.of(latitude));
            }

            /**
             * Sets {@code altitude}.
             *
             * @param altitude the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder altitude(FhirDecimal altitude) {
                this.altitude = altitude;
                return this;
            }

            /**
             * Sets {@code altitude}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param altitude the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder altitude(BigDecimal altitude) {
                return altitude(altitude == null ? null : FhirDecimal.of(altitude));
            }

            /**
             * Builds the {@code Position}.
             *
             * @return the {@code Position}
             * @throws NullPointerException if a required element is absent
             */
            public Position build() {
                return new Position(
                        id, extension, modifierExtension, longitude, latitude, altitude);
            }
        }
    }

    /** Builder for {@link Location}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<LocationStatus> status;
        private Coding operationalStatus;
        private FhirString name;
        private List<FhirString> alias = new ArrayList<>();
        private FhirMarkdown description;
        private FhirEnum<LocationMode> mode;
        private List<CodeableConcept> type = new ArrayList<>();
        private List<ExtendedContactDetail> contact = new ArrayList<>();
        private Address address;
        private CodeableConcept form;
        private Position position;
        private Reference managingOrganization;
        private Reference partOf;
        private List<CodeableConcept> characteristic = new ArrayList<>();
        private List<Availability> hoursOfOperation = new ArrayList<>();
        private List<VirtualServiceDetail> virtualService = new ArrayList<>();
        private List<Reference> endpoint = new ArrayList<>();

        private Builder() {
        }

        private Builder(Location original) {
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
            this.operationalStatus = original.operationalStatus();
            this.name = original.name();
            this.alias = new ArrayList<>(original.alias());
            this.description = original.description();
            this.mode = original.mode();
            this.type = new ArrayList<>(original.type());
            this.contact = new ArrayList<>(original.contact());
            this.address = original.address();
            this.form = original.form();
            this.position = original.position();
            this.managingOrganization = original.managingOrganization();
            this.partOf = original.partOf();
            this.characteristic = new ArrayList<>(original.characteristic());
            this.hoursOfOperation = new ArrayList<>(original.hoursOfOperation());
            this.virtualService = new ArrayList<>(original.virtualService());
            this.endpoint = new ArrayList<>(original.endpoint());
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
        public Builder status(FhirEnum<LocationStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(LocationStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code operationalStatus}.
         *
         * @param operationalStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder operationalStatus(Coding operationalStatus) {
            this.operationalStatus = operationalStatus;
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
         * Replaces all {@code alias} values.
         *
         * @param alias the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder alias(List<FhirString> alias) {
            this.alias = alias == null ? new ArrayList<>() : new ArrayList<>(alias);
            return this;
        }

        /**
         * Adds a {@code alias} value.
         *
         * @param alias the value to add
         * @return this builder
         */
        public Builder addAlias(FhirString alias) {
            this.alias.add(Objects.requireNonNull(alias, "alias"));
            return this;
        }

        /**
         * Adds a {@code alias} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param alias the value to add
         * @return this builder
         */
        public Builder addAlias(String alias) {
            return addAlias(FhirString.of(alias));
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
         * Sets {@code mode}.
         *
         * @param mode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder mode(FhirEnum<LocationMode> mode) {
            this.mode = mode;
            return this;
        }

        /**
         * Sets {@code mode}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param mode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder mode(LocationMode mode) {
            return mode(mode == null ? null : FhirEnum.of(mode));
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
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ExtendedContactDetail> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ExtendedContactDetail contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
            return this;
        }

        /**
         * Sets {@code address}.
         *
         * @param address the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        /**
         * Sets {@code form}.
         *
         * @param form the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder form(CodeableConcept form) {
            this.form = form;
            return this;
        }

        /**
         * Sets {@code position}.
         *
         * @param position the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder position(Position position) {
            this.position = position;
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
         * Sets {@code partOf}.
         *
         * @param partOf the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder partOf(Reference partOf) {
            this.partOf = partOf;
            return this;
        }

        /**
         * Replaces all {@code characteristic} values.
         *
         * @param characteristic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder characteristic(List<CodeableConcept> characteristic) {
            this.characteristic = characteristic == null ? new ArrayList<>() : new ArrayList<>(characteristic);
            return this;
        }

        /**
         * Adds a {@code characteristic} value.
         *
         * @param characteristic the value to add
         * @return this builder
         */
        public Builder addCharacteristic(CodeableConcept characteristic) {
            this.characteristic.add(Objects.requireNonNull(characteristic, "characteristic"));
            return this;
        }

        /**
         * Replaces all {@code hoursOfOperation} values.
         *
         * @param hoursOfOperation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder hoursOfOperation(List<Availability> hoursOfOperation) {
            this.hoursOfOperation = hoursOfOperation == null ? new ArrayList<>() : new ArrayList<>(hoursOfOperation);
            return this;
        }

        /**
         * Adds a {@code hoursOfOperation} value.
         *
         * @param hoursOfOperation the value to add
         * @return this builder
         */
        public Builder addHoursOfOperation(Availability hoursOfOperation) {
            this.hoursOfOperation.add(Objects.requireNonNull(hoursOfOperation, "hoursOfOperation"));
            return this;
        }

        /**
         * Replaces all {@code virtualService} values.
         *
         * @param virtualService the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder virtualService(List<VirtualServiceDetail> virtualService) {
            this.virtualService = virtualService == null ? new ArrayList<>() : new ArrayList<>(virtualService);
            return this;
        }

        /**
         * Adds a {@code virtualService} value.
         *
         * @param virtualService the value to add
         * @return this builder
         */
        public Builder addVirtualService(VirtualServiceDetail virtualService) {
            this.virtualService.add(Objects.requireNonNull(virtualService, "virtualService"));
            return this;
        }

        /**
         * Replaces all {@code endpoint} values.
         *
         * @param endpoint the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder endpoint(List<Reference> endpoint) {
            this.endpoint = endpoint == null ? new ArrayList<>() : new ArrayList<>(endpoint);
            return this;
        }

        /**
         * Adds a {@code endpoint} value.
         *
         * @param endpoint the value to add
         * @return this builder
         */
        public Builder addEndpoint(Reference endpoint) {
            this.endpoint.add(Objects.requireNonNull(endpoint, "endpoint"));
            return this;
        }

        /**
         * Builds the {@code Location}.
         *
         * @return the {@code Location}
         */
        public Location build() {
            return new Location(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, operationalStatus, name, alias, description, mode, type, contact, address, form, position,
                    managingOrganization, partOf, characteristic, hoursOfOperation, virtualService, endpoint);
        }
    }
}
