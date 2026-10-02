package se.poroli.fhirplace.r5.device;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Count;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.DeviceNameType;

/**
 * This resource describes the properties (regulated, has real time clock, etc.), adminstrative (manufacturer name,
 * model number, serial number, firmware, etc.), and type (knee replacement, blood pressure cuff, MRI, etc.) of a
 * physical unit (these values do not change much within a given module, for example the serail number, manufacturer
 * name, and model number).
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
 * @param identifier Instance identifier.
 * @param displayName The name used to display by default when the device is referenced.
 * @param definition The reference to the definition for the device.
 * @param udiCarrier Unique Device Identifier (UDI) Barcode string.
 * @param status active | inactive | entered-in-error. Modifier element.
 * @param availabilityStatus lost | damaged | destroyed | available.
 * @param biologicalSourceEvent An identifier that supports traceability to the event during which material in this
 *   product from one or more biological entities was obtained or pooled.
 * @param manufacturer Name of device manufacturer.
 * @param manufactureDate Date when the device was made.
 * @param expirationDate Date and time of expiry of this device (if applicable).
 * @param lotNumber Lot number of manufacture.
 * @param serialNumber Serial number assigned by the manufacturer.
 * @param name The name or names of the device as known to the manufacturer and/or patient.
 * @param modelNumber The manufacturer's model number for the device.
 * @param partNumber The part number or catalog number of the device.
 * @param category Indicates a high-level grouping of the device.
 * @param type The kind or type of device.
 * @param version The actual design of the device or software version running on the device.
 * @param conformsTo Identifies the standards, specifications, or formal guidances for the capabilities supported by
 *   the device.
 * @param property Inherent, essentially fixed, characteristics of the device. e.g., time properties, size, material,
 *   etc.
 * @param mode The designated condition for performing a task.
 * @param cycle The series of occurrences that repeats during the operation of the device.
 * @param duration A measurement of time during the device's operation (e.g., days, hours, mins, etc.).
 * @param owner Organization responsible for device. Reference to Organization.
 * @param contact Details for human/organization for support.
 * @param location Where the device is found. Reference to Location.
 * @param url Network address to contact device.
 * @param endpoint Technical endpoints providing access to electronic services provided by the device. Reference to
 *   Endpoint.
 * @param gateway Linked device acting as a communication/data collector, translator or controller.
 * @param note Device notes and comments.
 * @param safety Safety Characteristics of Device.
 * @param parent The higher level or encompassing device that this device is a logical part of. Reference to Device.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Device">FHIR R5 Device</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Device(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirString displayName,
        CodeableReference definition,
        List<UdiCarrier> udiCarrier,
        FhirEnum<FHIRDeviceStatus> status,
        CodeableConcept availabilityStatus,
        Identifier biologicalSourceEvent,
        FhirString manufacturer,
        FhirDateTime manufactureDate,
        FhirDateTime expirationDate,
        FhirString lotNumber,
        FhirString serialNumber,
        List<Name> name,
        FhirString modelNumber,
        FhirString partNumber,
        List<CodeableConcept> category,
        List<CodeableConcept> type,
        List<Version> version,
        List<ConformsTo> conformsTo,
        List<Property> property,
        CodeableConcept mode,
        Count cycle,
        Duration duration,
        Reference owner,
        List<ContactPoint> contact,
        Reference location,
        FhirUri url,
        List<Reference> endpoint,
        List<CodeableReference> gateway,
        List<Annotation> note,
        List<CodeableConcept> safety,
        Reference parent) implements DomainResource {

    /**
     * Creates a {@code Device}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Device {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        udiCarrier = udiCarrier == null ? List.of() : List.copyOf(udiCarrier);
        name = name == null ? List.of() : List.copyOf(name);
        category = category == null ? List.of() : List.copyOf(category);
        type = type == null ? List.of() : List.copyOf(type);
        version = version == null ? List.of() : List.copyOf(version);
        conformsTo = conformsTo == null ? List.of() : List.copyOf(conformsTo);
        property = property == null ? List.of() : List.copyOf(property);
        contact = contact == null ? List.of() : List.copyOf(contact);
        endpoint = endpoint == null ? List.of() : List.copyOf(endpoint);
        gateway = gateway == null ? List.of() : List.copyOf(gateway);
        note = note == null ? List.of() : List.copyOf(note);
        safety = safety == null ? List.of() : List.copyOf(safety);
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
     * Returns a builder initialized with the values of this {@code Device}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Unique device identifier (UDI) assigned to device label or package.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param deviceIdentifier Mandatory fixed portion of UDI. Required.
     * @param issuer UDI Issuing Organization. Required.
     * @param jurisdiction Regional UDI authority.
     * @param carrierAIDC UDI Machine Readable Barcode String.
     * @param carrierHRF UDI Human Readable Barcode String.
     * @param entryType barcode | rfid | manual | card | self-reported | electronic-transmission | unknown.
     */
    public record UdiCarrier(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString deviceIdentifier,
            FhirUri issuer,
            FhirUri jurisdiction,
            FhirBase64Binary carrierAIDC,
            FhirString carrierHRF,
            FhirEnum<UDIEntryType> entryType) implements BackboneElement {

        /**
         * Creates an {@code UdiCarrier}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public UdiCarrier {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(deviceIdentifier, "Device.udiCarrier.deviceIdentifier is required");
            Objects.requireNonNull(issuer, "Device.udiCarrier.issuer is required");
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
         * Returns a builder initialized with the values of this {@code UdiCarrier}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link UdiCarrier}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString deviceIdentifier;
            private FhirUri issuer;
            private FhirUri jurisdiction;
            private FhirBase64Binary carrierAIDC;
            private FhirString carrierHRF;
            private FhirEnum<UDIEntryType> entryType;

            private Builder() {
            }

            private Builder(UdiCarrier original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.deviceIdentifier = original.deviceIdentifier();
                this.issuer = original.issuer();
                this.jurisdiction = original.jurisdiction();
                this.carrierAIDC = original.carrierAIDC();
                this.carrierHRF = original.carrierHRF();
                this.entryType = original.entryType();
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
             * Sets {@code deviceIdentifier}.
             *
             * @param deviceIdentifier the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder deviceIdentifier(FhirString deviceIdentifier) {
                this.deviceIdentifier = deviceIdentifier;
                return this;
            }

            /**
             * Sets {@code deviceIdentifier}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param deviceIdentifier the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder deviceIdentifier(String deviceIdentifier) {
                return deviceIdentifier(deviceIdentifier == null ? null : FhirString.of(deviceIdentifier));
            }

            /**
             * Sets {@code issuer}.
             *
             * @param issuer the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder issuer(FhirUri issuer) {
                this.issuer = issuer;
                return this;
            }

            /**
             * Sets {@code issuer}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param issuer the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder issuer(String issuer) {
                return issuer(issuer == null ? null : FhirUri.of(issuer));
            }

            /**
             * Sets {@code jurisdiction}.
             *
             * @param jurisdiction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder jurisdiction(FhirUri jurisdiction) {
                this.jurisdiction = jurisdiction;
                return this;
            }

            /**
             * Sets {@code jurisdiction}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param jurisdiction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder jurisdiction(String jurisdiction) {
                return jurisdiction(jurisdiction == null ? null : FhirUri.of(jurisdiction));
            }

            /**
             * Sets {@code carrierAIDC}.
             *
             * @param carrierAIDC the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder carrierAIDC(FhirBase64Binary carrierAIDC) {
                this.carrierAIDC = carrierAIDC;
                return this;
            }

            /**
             * Sets {@code carrierHRF}.
             *
             * @param carrierHRF the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder carrierHRF(FhirString carrierHRF) {
                this.carrierHRF = carrierHRF;
                return this;
            }

            /**
             * Sets {@code carrierHRF}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param carrierHRF the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder carrierHRF(String carrierHRF) {
                return carrierHRF(carrierHRF == null ? null : FhirString.of(carrierHRF));
            }

            /**
             * Sets {@code entryType}.
             *
             * @param entryType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder entryType(FhirEnum<UDIEntryType> entryType) {
                this.entryType = entryType;
                return this;
            }

            /**
             * Sets {@code entryType}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param entryType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder entryType(UDIEntryType entryType) {
                return entryType(entryType == null ? null : FhirEnum.of(entryType));
            }

            /**
             * Builds the {@code UdiCarrier}.
             *
             * @return the {@code UdiCarrier}
             * @throws NullPointerException if a required element is absent
             */
            public UdiCarrier build() {
                return new UdiCarrier(
                        id, extension, modifierExtension, deviceIdentifier, issuer, jurisdiction, carrierAIDC,
                        carrierHRF, entryType);
            }
        }
    }

    /**
     * This represents the manufacturer's name of the device as provided by the device, from a UDI label, or by a
     * person describing the Device.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param value The term that names the device. Required.
     * @param type registered-name | user-friendly-name | patient-reported-name. Required.
     * @param display The preferred device name. Modifier element.
     */
    public record Name(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString value,
            FhirEnum<DeviceNameType> type,
            FhirBoolean display) implements BackboneElement {

        /**
         * Creates a {@code Name}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Name {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(value, "Device.name.value is required");
            Objects.requireNonNull(type, "Device.name.type is required");
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
         * Returns a builder initialized with the values of this {@code Name}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Name}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString value;
            private FhirEnum<DeviceNameType> type;
            private FhirBoolean display;

            private Builder() {
            }

            private Builder(Name original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.value = original.value();
                this.type = original.type();
                this.display = original.display();
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
             * Sets {@code type}.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(FhirEnum<DeviceNameType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(DeviceNameType type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Sets {@code display}.
             *
             * @param display the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder display(FhirBoolean display) {
                this.display = display;
                return this;
            }

            /**
             * Sets {@code display}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param display the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder display(Boolean display) {
                return display(display == null ? null : FhirBoolean.of(display));
            }

            /**
             * Builds the {@code Name}.
             *
             * @return the {@code Name}
             * @throws NullPointerException if a required element is absent
             */
            public Name build() {
                return new Name(
                        id, extension, modifierExtension, value, type, display);
            }
        }
    }

    /**
     * The actual design of the device or software version running on the device.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type The type of the device version, e.g. manufacturer, approved, internal.
     * @param component The hardware or software module of the device to which the version applies.
     * @param installDate The date the version was installed on the device.
     * @param value The version text. Required.
     */
    public record Version(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            Identifier component,
            FhirDateTime installDate,
            FhirString value) implements BackboneElement {

        /**
         * Creates a {@code Version}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Version {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(value, "Device.version.value is required");
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

        /** Builder for {@link Version}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private Identifier component;
            private FhirDateTime installDate;
            private FhirString value;

            private Builder() {
            }

            private Builder(Version original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.component = original.component();
                this.installDate = original.installDate();
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
             * Sets {@code type}.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(CodeableConcept type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code component}.
             *
             * @param component the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder component(Identifier component) {
                this.component = component;
                return this;
            }

            /**
             * Sets {@code installDate}.
             *
             * @param installDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder installDate(FhirDateTime installDate) {
                this.installDate = installDate;
                return this;
            }

            /**
             * Sets {@code installDate}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param installDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder installDate(Temporal installDate) {
                return installDate(installDate == null ? null : FhirDateTime.of(installDate));
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
             * Builds the {@code Version}.
             *
             * @return the {@code Version}
             * @throws NullPointerException if a required element is absent
             */
            public Version build() {
                return new Version(
                        id, extension, modifierExtension, type, component, installDate, value);
            }
        }
    }

    /**
     * Identifies the standards, specifications, or formal guidances for the capabilities supported by the device.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param category Describes the common type of the standard, specification, or formal guidance. communication |
     *   performance | measurement.
     * @param specification Identifies the standard, specification, or formal guidance that the device adheres to.
     *   Required.
     * @param version Specific form or variant of the standard.
     */
    public record ConformsTo(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept category,
            CodeableConcept specification,
            FhirString version) implements BackboneElement {

        /**
         * Creates a {@code ConformsTo}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ConformsTo {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(specification, "Device.conformsTo.specification is required");
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
         * Returns a builder initialized with the values of this {@code ConformsTo}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ConformsTo}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept category;
            private CodeableConcept specification;
            private FhirString version;

            private Builder() {
            }

            private Builder(ConformsTo original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.category = original.category();
                this.specification = original.specification();
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
             * Sets {@code category}.
             *
             * @param category the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder category(CodeableConcept category) {
                this.category = category;
                return this;
            }

            /**
             * Sets {@code specification}.
             *
             * @param specification the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder specification(CodeableConcept specification) {
                this.specification = specification;
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
             * Builds the {@code ConformsTo}.
             *
             * @return the {@code ConformsTo}
             * @throws NullPointerException if a required element is absent
             */
            public ConformsTo build() {
                return new ConformsTo(
                        id, extension, modifierExtension, category, specification, version);
            }
        }
    }

    /**
     * Static or essentially fixed characteristics or features of the device (e.g., time or timing attributes,
     * resolution, accuracy, intended use or instructions for use, and physical attributes) that are not otherwise
     * captured in more specific attributes.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Code that specifies the property being represented. Required.
     * @param value Value of the property. One of Quantity, CodeableConcept, string, boolean, integer, Range,
     *   Attachment. Required.
     */
    public record Property(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType value) implements BackboneElement {

        /**
         * Creates a {@code Property}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Property {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "Device.property.type is required");
            Objects.requireNonNull(value, "Device.property.value is required");
            if (value != null && !(value instanceof Quantity
                    || value instanceof CodeableConcept
                    || value instanceof FhirString
                    || value instanceof FhirBoolean
                    || value instanceof FhirInteger
                    || value instanceof Range
                    || value instanceof Attachment)) {
                throw new IllegalArgumentException(
                        "Device.property.value[x] does not allow "
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
            private CodeableConcept type;
            private DataType value;

            private Builder() {
            }

            private Builder(Property original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
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
             * Sets {@code type}.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(CodeableConcept type) {
                this.type = type;
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
             * Sets {@code value} to a CodeableConcept.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(CodeableConcept value) {
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
             * Sets {@code value} to a Range.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Range value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a Attachment.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Attachment value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a string without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(String value) {
                this.value = value == null ? null : FhirString.of(value);
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
             * Builds the {@code Property}.
             *
             * @return the {@code Property}
             * @throws NullPointerException if a required element is absent
             */
            public Property build() {
                return new Property(
                        id, extension, modifierExtension, type, value);
            }
        }
    }

    /** Builder for {@link Device}. Builders are mutable and not thread-safe. */
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
        private FhirString displayName;
        private CodeableReference definition;
        private List<UdiCarrier> udiCarrier = new ArrayList<>();
        private FhirEnum<FHIRDeviceStatus> status;
        private CodeableConcept availabilityStatus;
        private Identifier biologicalSourceEvent;
        private FhirString manufacturer;
        private FhirDateTime manufactureDate;
        private FhirDateTime expirationDate;
        private FhirString lotNumber;
        private FhirString serialNumber;
        private List<Name> name = new ArrayList<>();
        private FhirString modelNumber;
        private FhirString partNumber;
        private List<CodeableConcept> category = new ArrayList<>();
        private List<CodeableConcept> type = new ArrayList<>();
        private List<Version> version = new ArrayList<>();
        private List<ConformsTo> conformsTo = new ArrayList<>();
        private List<Property> property = new ArrayList<>();
        private CodeableConcept mode;
        private Count cycle;
        private Duration duration;
        private Reference owner;
        private List<ContactPoint> contact = new ArrayList<>();
        private Reference location;
        private FhirUri url;
        private List<Reference> endpoint = new ArrayList<>();
        private List<CodeableReference> gateway = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<CodeableConcept> safety = new ArrayList<>();
        private Reference parent;

        private Builder() {
        }

        private Builder(Device original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.displayName = original.displayName();
            this.definition = original.definition();
            this.udiCarrier = new ArrayList<>(original.udiCarrier());
            this.status = original.status();
            this.availabilityStatus = original.availabilityStatus();
            this.biologicalSourceEvent = original.biologicalSourceEvent();
            this.manufacturer = original.manufacturer();
            this.manufactureDate = original.manufactureDate();
            this.expirationDate = original.expirationDate();
            this.lotNumber = original.lotNumber();
            this.serialNumber = original.serialNumber();
            this.name = new ArrayList<>(original.name());
            this.modelNumber = original.modelNumber();
            this.partNumber = original.partNumber();
            this.category = new ArrayList<>(original.category());
            this.type = new ArrayList<>(original.type());
            this.version = new ArrayList<>(original.version());
            this.conformsTo = new ArrayList<>(original.conformsTo());
            this.property = new ArrayList<>(original.property());
            this.mode = original.mode();
            this.cycle = original.cycle();
            this.duration = original.duration();
            this.owner = original.owner();
            this.contact = new ArrayList<>(original.contact());
            this.location = original.location();
            this.url = original.url();
            this.endpoint = new ArrayList<>(original.endpoint());
            this.gateway = new ArrayList<>(original.gateway());
            this.note = new ArrayList<>(original.note());
            this.safety = new ArrayList<>(original.safety());
            this.parent = original.parent();
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
         * Sets {@code displayName}.
         *
         * @param displayName the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder displayName(FhirString displayName) {
            this.displayName = displayName;
            return this;
        }

        /**
         * Sets {@code displayName}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param displayName the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder displayName(String displayName) {
            return displayName(displayName == null ? null : FhirString.of(displayName));
        }

        /**
         * Sets {@code definition}.
         *
         * @param definition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder definition(CodeableReference definition) {
            this.definition = definition;
            return this;
        }

        /**
         * Replaces all {@code udiCarrier} values.
         *
         * @param udiCarrier the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder udiCarrier(List<UdiCarrier> udiCarrier) {
            this.udiCarrier = udiCarrier == null ? new ArrayList<>() : new ArrayList<>(udiCarrier);
            return this;
        }

        /**
         * Adds a {@code udiCarrier} value.
         *
         * @param udiCarrier the value to add
         * @return this builder
         */
        public Builder addUdiCarrier(UdiCarrier udiCarrier) {
            this.udiCarrier.add(Objects.requireNonNull(udiCarrier, "udiCarrier"));
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<FHIRDeviceStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FHIRDeviceStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code availabilityStatus}.
         *
         * @param availabilityStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder availabilityStatus(CodeableConcept availabilityStatus) {
            this.availabilityStatus = availabilityStatus;
            return this;
        }

        /**
         * Sets {@code biologicalSourceEvent}.
         *
         * @param biologicalSourceEvent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder biologicalSourceEvent(Identifier biologicalSourceEvent) {
            this.biologicalSourceEvent = biologicalSourceEvent;
            return this;
        }

        /**
         * Sets {@code manufacturer}.
         *
         * @param manufacturer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder manufacturer(FhirString manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        /**
         * Sets {@code manufacturer}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param manufacturer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder manufacturer(String manufacturer) {
            return manufacturer(manufacturer == null ? null : FhirString.of(manufacturer));
        }

        /**
         * Sets {@code manufactureDate}.
         *
         * @param manufactureDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder manufactureDate(FhirDateTime manufactureDate) {
            this.manufactureDate = manufactureDate;
            return this;
        }

        /**
         * Sets {@code manufactureDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param manufactureDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder manufactureDate(Temporal manufactureDate) {
            return manufactureDate(manufactureDate == null ? null : FhirDateTime.of(manufactureDate));
        }

        /**
         * Sets {@code expirationDate}.
         *
         * @param expirationDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expirationDate(FhirDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        /**
         * Sets {@code expirationDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param expirationDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expirationDate(Temporal expirationDate) {
            return expirationDate(expirationDate == null ? null : FhirDateTime.of(expirationDate));
        }

        /**
         * Sets {@code lotNumber}.
         *
         * @param lotNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lotNumber(FhirString lotNumber) {
            this.lotNumber = lotNumber;
            return this;
        }

        /**
         * Sets {@code lotNumber}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param lotNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lotNumber(String lotNumber) {
            return lotNumber(lotNumber == null ? null : FhirString.of(lotNumber));
        }

        /**
         * Sets {@code serialNumber}.
         *
         * @param serialNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder serialNumber(FhirString serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        /**
         * Sets {@code serialNumber}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param serialNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder serialNumber(String serialNumber) {
            return serialNumber(serialNumber == null ? null : FhirString.of(serialNumber));
        }

        /**
         * Replaces all {@code name} values.
         *
         * @param name the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder name(List<Name> name) {
            this.name = name == null ? new ArrayList<>() : new ArrayList<>(name);
            return this;
        }

        /**
         * Adds a {@code name} value.
         *
         * @param name the value to add
         * @return this builder
         */
        public Builder addName(Name name) {
            this.name.add(Objects.requireNonNull(name, "name"));
            return this;
        }

        /**
         * Sets {@code modelNumber}.
         *
         * @param modelNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder modelNumber(FhirString modelNumber) {
            this.modelNumber = modelNumber;
            return this;
        }

        /**
         * Sets {@code modelNumber}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param modelNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder modelNumber(String modelNumber) {
            return modelNumber(modelNumber == null ? null : FhirString.of(modelNumber));
        }

        /**
         * Sets {@code partNumber}.
         *
         * @param partNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder partNumber(FhirString partNumber) {
            this.partNumber = partNumber;
            return this;
        }

        /**
         * Sets {@code partNumber}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param partNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder partNumber(String partNumber) {
            return partNumber(partNumber == null ? null : FhirString.of(partNumber));
        }

        /**
         * Replaces all {@code category} values.
         *
         * @param category the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder category(List<CodeableConcept> category) {
            this.category = category == null ? new ArrayList<>() : new ArrayList<>(category);
            return this;
        }

        /**
         * Adds a {@code category} value.
         *
         * @param category the value to add
         * @return this builder
         */
        public Builder addCategory(CodeableConcept category) {
            this.category.add(Objects.requireNonNull(category, "category"));
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
         * Replaces all {@code conformsTo} values.
         *
         * @param conformsTo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder conformsTo(List<ConformsTo> conformsTo) {
            this.conformsTo = conformsTo == null ? new ArrayList<>() : new ArrayList<>(conformsTo);
            return this;
        }

        /**
         * Adds a {@code conformsTo} value.
         *
         * @param conformsTo the value to add
         * @return this builder
         */
        public Builder addConformsTo(ConformsTo conformsTo) {
            this.conformsTo.add(Objects.requireNonNull(conformsTo, "conformsTo"));
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
         * Sets {@code mode}.
         *
         * @param mode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder mode(CodeableConcept mode) {
            this.mode = mode;
            return this;
        }

        /**
         * Sets {@code cycle}.
         *
         * @param cycle the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder cycle(Count cycle) {
            this.cycle = cycle;
            return this;
        }

        /**
         * Sets {@code duration}.
         *
         * @param duration the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder duration(Duration duration) {
            this.duration = duration;
            return this;
        }

        /**
         * Sets {@code owner}.
         *
         * @param owner the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder owner(Reference owner) {
            this.owner = owner;
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
         * Sets {@code location}.
         *
         * @param location the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder location(Reference location) {
            this.location = location;
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
         * Replaces all {@code gateway} values.
         *
         * @param gateway the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder gateway(List<CodeableReference> gateway) {
            this.gateway = gateway == null ? new ArrayList<>() : new ArrayList<>(gateway);
            return this;
        }

        /**
         * Adds a {@code gateway} value.
         *
         * @param gateway the value to add
         * @return this builder
         */
        public Builder addGateway(CodeableReference gateway) {
            this.gateway.add(Objects.requireNonNull(gateway, "gateway"));
            return this;
        }

        /**
         * Replaces all {@code note} values.
         *
         * @param note the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder note(List<Annotation> note) {
            this.note = note == null ? new ArrayList<>() : new ArrayList<>(note);
            return this;
        }

        /**
         * Adds a {@code note} value.
         *
         * @param note the value to add
         * @return this builder
         */
        public Builder addNote(Annotation note) {
            this.note.add(Objects.requireNonNull(note, "note"));
            return this;
        }

        /**
         * Replaces all {@code safety} values.
         *
         * @param safety the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder safety(List<CodeableConcept> safety) {
            this.safety = safety == null ? new ArrayList<>() : new ArrayList<>(safety);
            return this;
        }

        /**
         * Adds a {@code safety} value.
         *
         * @param safety the value to add
         * @return this builder
         */
        public Builder addSafety(CodeableConcept safety) {
            this.safety.add(Objects.requireNonNull(safety, "safety"));
            return this;
        }

        /**
         * Sets {@code parent}.
         *
         * @param parent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder parent(Reference parent) {
            this.parent = parent;
            return this;
        }

        /**
         * Builds the {@code Device}.
         *
         * @return the {@code Device}
         */
        public Device build() {
            return new Device(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    displayName, definition, udiCarrier, status, availabilityStatus, biologicalSourceEvent,
                    manufacturer, manufactureDate, expirationDate, lotNumber, serialNumber, name, modelNumber,
                    partNumber, category, type, version, conformsTo, property, mode, cycle, duration, owner, contact,
                    location, url, endpoint, gateway, note, safety, parent);
        }
    }
}
