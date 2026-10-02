package se.poroli.fhirplace.r5.devicedefinition;

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
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.DeviceNameType;

/**
 * This is a specialized resource that defines the characteristics and capabilities of a device.
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
 * @param description Additional information to describe the device.
 * @param identifier Instance identifier.
 * @param udiDeviceIdentifier Unique Device Identifier (UDI) Barcode string.
 * @param regulatoryIdentifier Regulatory identifier(s) associated with this device.
 * @param partNumber The part number or catalog number of the device.
 * @param manufacturer Name of device manufacturer. Reference to Organization.
 * @param deviceName The name or names of the device as given by the manufacturer.
 * @param modelNumber The catalog or model number for the device for example as defined by the manufacturer.
 * @param classification What kind of device or device system this is.
 * @param conformsTo Identifies the standards, specifications, or formal guidances for the capabilities supported by
 *   the device.
 * @param hasPart A device, part of the current one.
 * @param packaging Information about the packaging of the device, i.e. how the device is packaged.
 * @param version The version of the device or software.
 * @param safety Safety characteristics of the device.
 * @param shelfLifeStorage Shelf Life and storage information.
 * @param languageCode Language code for the human-readable text strings produced by the device (all supported).
 * @param property Inherent, essentially fixed, characteristics of this kind of device, e.g., time properties, size,
 *   etc.
 * @param owner Organization responsible for device. Reference to Organization.
 * @param contact Details for human/organization for support.
 * @param link An associated device, attached to, used with, communicating with or linking a previous or new device
 *   model to the focal device.
 * @param note Device notes and comments.
 * @param material A substance used to create the material(s) of which the device is made.
 * @param productionIdentifierInUDI lot-number | manufactured-date | serial-number | expiration-date |
 *   biological-source | software-version.
 * @param guideline Information aimed at providing directions for the usage of this model of device.
 * @param correctiveAction Tracking of latest field safety corrective action.
 * @param chargeItem Billing code or reference associated with the device.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DeviceDefinition">FHIR R5 DeviceDefinition</a>
 */
public record DeviceDefinition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirMarkdown description,
        List<Identifier> identifier,
        List<UdiDeviceIdentifier> udiDeviceIdentifier,
        List<RegulatoryIdentifier> regulatoryIdentifier,
        FhirString partNumber,
        Reference manufacturer,
        List<DeviceName> deviceName,
        FhirString modelNumber,
        List<Classification> classification,
        List<ConformsTo> conformsTo,
        List<HasPart> hasPart,
        List<Packaging> packaging,
        List<Version> version,
        List<CodeableConcept> safety,
        List<ProductShelfLife> shelfLifeStorage,
        List<CodeableConcept> languageCode,
        List<Property> property,
        Reference owner,
        List<ContactPoint> contact,
        List<Link> link,
        List<Annotation> note,
        List<Material> material,
        List<FhirEnum<DeviceProductionIdentifierInUDI>> productionIdentifierInUDI,
        Guideline guideline,
        CorrectiveAction correctiveAction,
        List<ChargeItem> chargeItem) implements DomainResource {

    /**
     * Creates a {@code DeviceDefinition}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public DeviceDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        udiDeviceIdentifier = udiDeviceIdentifier == null ? List.of() : List.copyOf(udiDeviceIdentifier);
        regulatoryIdentifier = regulatoryIdentifier == null ? List.of() : List.copyOf(regulatoryIdentifier);
        deviceName = deviceName == null ? List.of() : List.copyOf(deviceName);
        classification = classification == null ? List.of() : List.copyOf(classification);
        conformsTo = conformsTo == null ? List.of() : List.copyOf(conformsTo);
        hasPart = hasPart == null ? List.of() : List.copyOf(hasPart);
        packaging = packaging == null ? List.of() : List.copyOf(packaging);
        version = version == null ? List.of() : List.copyOf(version);
        safety = safety == null ? List.of() : List.copyOf(safety);
        shelfLifeStorage = shelfLifeStorage == null ? List.of() : List.copyOf(shelfLifeStorage);
        languageCode = languageCode == null ? List.of() : List.copyOf(languageCode);
        property = property == null ? List.of() : List.copyOf(property);
        contact = contact == null ? List.of() : List.copyOf(contact);
        link = link == null ? List.of() : List.copyOf(link);
        note = note == null ? List.of() : List.copyOf(note);
        material = material == null ? List.of() : List.copyOf(material);
        productionIdentifierInUDI =
                productionIdentifierInUDI == null ? List.of() : List.copyOf(productionIdentifierInUDI);
        chargeItem = chargeItem == null ? List.of() : List.copyOf(chargeItem);
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
     * Returns a builder initialized with the values of this {@code DeviceDefinition}.
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
     * @param deviceIdentifier The identifier that is to be associated with every Device that references this
     *   DeviceDefintiion for the issuer and jurisdiction provided in the DeviceDefinition.udiDeviceIdentifier.
     *   Required.
     * @param issuer The organization that assigns the identifier algorithm. Required.
     * @param jurisdiction The jurisdiction to which the deviceIdentifier applies. Required.
     * @param marketDistribution Indicates whether and when the device is available on the market.
     */
    public record UdiDeviceIdentifier(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString deviceIdentifier,
            FhirUri issuer,
            FhirUri jurisdiction,
            List<UdiDeviceIdentifierMarketDistribution> marketDistribution) implements BackboneElement {

        /**
         * Creates an {@code UdiDeviceIdentifier}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public UdiDeviceIdentifier {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            marketDistribution = marketDistribution == null ? List.of() : List.copyOf(marketDistribution);
            Objects.requireNonNull(
                    deviceIdentifier, "DeviceDefinition.udiDeviceIdentifier.deviceIdentifier is required");
            Objects.requireNonNull(issuer, "DeviceDefinition.udiDeviceIdentifier.issuer is required");
            Objects.requireNonNull(jurisdiction, "DeviceDefinition.udiDeviceIdentifier.jurisdiction is required");
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
         * Returns a builder initialized with the values of this {@code UdiDeviceIdentifier}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Indicates where and when the device is available on the market.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param marketPeriod Begin and end dates for the commercial distribution of the device. Required.
         * @param subJurisdiction National state or territory where the device is commercialized. Required.
         */
        public record UdiDeviceIdentifierMarketDistribution(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Period marketPeriod,
                FhirUri subJurisdiction) implements BackboneElement {

            /**
             * Creates an {@code UdiDeviceIdentifierMarketDistribution}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public UdiDeviceIdentifierMarketDistribution {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(
                        marketPeriod, "DeviceDefinition.udiDeviceIdentifier.marketDistribution.marketPeriod is required");
                Objects.requireNonNull(
                        subJurisdiction, "DeviceDefinition.udiDeviceIdentifier.marketDistribution.subJurisdiction is required");
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
             * Returns a builder initialized with the values of this {@code UdiDeviceIdentifierMarketDistribution}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link UdiDeviceIdentifierMarketDistribution}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Period marketPeriod;
                private FhirUri subJurisdiction;

                private Builder() {
                }

                private Builder(UdiDeviceIdentifierMarketDistribution original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.marketPeriod = original.marketPeriod();
                    this.subJurisdiction = original.subJurisdiction();
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
                 * Sets {@code marketPeriod}.
                 *
                 * @param marketPeriod the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder marketPeriod(Period marketPeriod) {
                    this.marketPeriod = marketPeriod;
                    return this;
                }

                /**
                 * Sets {@code subJurisdiction}.
                 *
                 * @param subJurisdiction the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder subJurisdiction(FhirUri subJurisdiction) {
                    this.subJurisdiction = subJurisdiction;
                    return this;
                }

                /**
                 * Sets {@code subJurisdiction}, wrapped in a {@link FhirUri} without id or extensions.
                 *
                 * @param subJurisdiction the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder subJurisdiction(String subJurisdiction) {
                    return subJurisdiction(subJurisdiction == null ? null : FhirUri.of(subJurisdiction));
                }

                /**
                 * Builds the {@code UdiDeviceIdentifierMarketDistribution}.
                 *
                 * @return the {@code UdiDeviceIdentifierMarketDistribution}
                 * @throws NullPointerException if a required element is absent
                 */
                public UdiDeviceIdentifierMarketDistribution build() {
                    return new UdiDeviceIdentifierMarketDistribution(
                            id, extension, modifierExtension, marketPeriod, subJurisdiction);
                }
            }
        }

        /** Builder for {@link UdiDeviceIdentifier}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString deviceIdentifier;
            private FhirUri issuer;
            private FhirUri jurisdiction;
            private List<UdiDeviceIdentifierMarketDistribution> marketDistribution = new ArrayList<>();

            private Builder() {
            }

            private Builder(UdiDeviceIdentifier original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.deviceIdentifier = original.deviceIdentifier();
                this.issuer = original.issuer();
                this.jurisdiction = original.jurisdiction();
                this.marketDistribution = new ArrayList<>(original.marketDistribution());
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
             * Replaces all {@code marketDistribution} values.
             *
             * @param marketDistribution the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder marketDistribution(List<UdiDeviceIdentifierMarketDistribution> marketDistribution) {
                this.marketDistribution = marketDistribution == null
                        ? new ArrayList<>()
                        : new ArrayList<>(marketDistribution);
                return this;
            }

            /**
             * Adds a {@code marketDistribution} value.
             *
             * @param marketDistribution the value to add
             * @return this builder
             */
            public Builder addMarketDistribution(UdiDeviceIdentifierMarketDistribution marketDistribution) {
                this.marketDistribution.add(Objects.requireNonNull(marketDistribution, "marketDistribution"));
                return this;
            }

            /**
             * Builds the {@code UdiDeviceIdentifier}.
             *
             * @return the {@code UdiDeviceIdentifier}
             * @throws NullPointerException if a required element is absent
             */
            public UdiDeviceIdentifier build() {
                return new UdiDeviceIdentifier(
                        id, extension, modifierExtension, deviceIdentifier, issuer, jurisdiction, marketDistribution);
            }
        }
    }

    /**
     * Identifier associated with the regulatory documentation (certificates, technical documentation, post-market
     * surveillance documentation and reports) of a set of device models sharing the same intended purpose, risk class
     * and essential design and manufacturing characteristics.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type basic | master | license. Required.
     * @param deviceIdentifier The identifier itself. Required.
     * @param issuer The organization that issued this identifier. Required.
     * @param jurisdiction The jurisdiction to which the deviceIdentifier applies. Required.
     */
    public record RegulatoryIdentifier(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<DeviceDefinitionRegulatoryIdentifierType> type,
            FhirString deviceIdentifier,
            FhirUri issuer,
            FhirUri jurisdiction) implements BackboneElement {

        /**
         * Creates a {@code RegulatoryIdentifier}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public RegulatoryIdentifier {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "DeviceDefinition.regulatoryIdentifier.type is required");
            Objects.requireNonNull(
                    deviceIdentifier, "DeviceDefinition.regulatoryIdentifier.deviceIdentifier is required");
            Objects.requireNonNull(issuer, "DeviceDefinition.regulatoryIdentifier.issuer is required");
            Objects.requireNonNull(jurisdiction, "DeviceDefinition.regulatoryIdentifier.jurisdiction is required");
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
         * Returns a builder initialized with the values of this {@code RegulatoryIdentifier}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link RegulatoryIdentifier}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<DeviceDefinitionRegulatoryIdentifierType> type;
            private FhirString deviceIdentifier;
            private FhirUri issuer;
            private FhirUri jurisdiction;

            private Builder() {
            }

            private Builder(RegulatoryIdentifier original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.deviceIdentifier = original.deviceIdentifier();
                this.issuer = original.issuer();
                this.jurisdiction = original.jurisdiction();
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
            public Builder type(FhirEnum<DeviceDefinitionRegulatoryIdentifierType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(DeviceDefinitionRegulatoryIdentifierType type) {
                return type(type == null ? null : FhirEnum.of(type));
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
             * Builds the {@code RegulatoryIdentifier}.
             *
             * @return the {@code RegulatoryIdentifier}
             * @throws NullPointerException if a required element is absent
             */
            public RegulatoryIdentifier build() {
                return new RegulatoryIdentifier(
                        id, extension, modifierExtension, type, deviceIdentifier, issuer, jurisdiction);
            }
        }
    }

    /**
     * The name or names of the device as given by the manufacturer.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name A name that is used to refer to the device. Required.
     * @param type registered-name | user-friendly-name | patient-reported-name. Required.
     */
    public record DeviceName(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            FhirEnum<DeviceNameType> type) implements BackboneElement {

        /**
         * Creates a {@code DeviceName}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public DeviceName {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(name, "DeviceDefinition.deviceName.name is required");
            Objects.requireNonNull(type, "DeviceDefinition.deviceName.type is required");
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
         * Returns a builder initialized with the values of this {@code DeviceName}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link DeviceName}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString name;
            private FhirEnum<DeviceNameType> type;

            private Builder() {
            }

            private Builder(DeviceName original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.type = original.type();
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
             * Builds the {@code DeviceName}.
             *
             * @return the {@code DeviceName}
             * @throws NullPointerException if a required element is absent
             */
            public DeviceName build() {
                return new DeviceName(
                        id, extension, modifierExtension, name, type);
            }
        }
    }

    /**
     * What kind of device or device system this is.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type A classification or risk class of the device model. Required.
     * @param justification Further information qualifying this classification of the device model.
     */
    public record Classification(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            List<RelatedArtifact> justification) implements BackboneElement {

        /**
         * Creates a {@code Classification}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Classification {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            justification = justification == null ? List.of() : List.copyOf(justification);
            Objects.requireNonNull(type, "DeviceDefinition.classification.type is required");
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
         * Returns a builder initialized with the values of this {@code Classification}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Classification}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private List<RelatedArtifact> justification = new ArrayList<>();

            private Builder() {
            }

            private Builder(Classification original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.justification = new ArrayList<>(original.justification());
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
             * Replaces all {@code justification} values.
             *
             * @param justification the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder justification(List<RelatedArtifact> justification) {
                this.justification = justification == null ? new ArrayList<>() : new ArrayList<>(justification);
                return this;
            }

            /**
             * Adds a {@code justification} value.
             *
             * @param justification the value to add
             * @return this builder
             */
            public Builder addJustification(RelatedArtifact justification) {
                this.justification.add(Objects.requireNonNull(justification, "justification"));
                return this;
            }

            /**
             * Builds the {@code Classification}.
             *
             * @return the {@code Classification}
             * @throws NullPointerException if a required element is absent
             */
            public Classification build() {
                return new Classification(
                        id, extension, modifierExtension, type, justification);
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
     * @param category Describes the common type of the standard, specification, or formal guidance.
     * @param specification Identifies the standard, specification, or formal guidance that the device adheres to the
     *   Device Specification type. Required.
     * @param version The specific form or variant of the standard, specification or formal guidance.
     * @param source Standard, regulation, certification, or guidance website, document, or other publication, or
     *   similar, supporting the conformance.
     */
    public record ConformsTo(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept category,
            CodeableConcept specification,
            List<FhirString> version,
            List<RelatedArtifact> source) implements BackboneElement {

        /**
         * Creates a {@code ConformsTo}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ConformsTo {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            version = version == null ? List.of() : List.copyOf(version);
            source = source == null ? List.of() : List.copyOf(source);
            Objects.requireNonNull(specification, "DeviceDefinition.conformsTo.specification is required");
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
            private List<FhirString> version = new ArrayList<>();
            private List<RelatedArtifact> source = new ArrayList<>();

            private Builder() {
            }

            private Builder(ConformsTo original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.category = original.category();
                this.specification = original.specification();
                this.version = new ArrayList<>(original.version());
                this.source = new ArrayList<>(original.source());
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
             * Replaces all {@code version} values.
             *
             * @param version the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder version(List<FhirString> version) {
                this.version = version == null ? new ArrayList<>() : new ArrayList<>(version);
                return this;
            }

            /**
             * Adds a {@code version} value.
             *
             * @param version the value to add
             * @return this builder
             */
            public Builder addVersion(FhirString version) {
                this.version.add(Objects.requireNonNull(version, "version"));
                return this;
            }

            /**
             * Adds a {@code version} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param version the value to add
             * @return this builder
             */
            public Builder addVersion(String version) {
                return addVersion(FhirString.of(version));
            }

            /**
             * Replaces all {@code source} values.
             *
             * @param source the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder source(List<RelatedArtifact> source) {
                this.source = source == null ? new ArrayList<>() : new ArrayList<>(source);
                return this;
            }

            /**
             * Adds a {@code source} value.
             *
             * @param source the value to add
             * @return this builder
             */
            public Builder addSource(RelatedArtifact source) {
                this.source.add(Objects.requireNonNull(source, "source"));
                return this;
            }

            /**
             * Builds the {@code ConformsTo}.
             *
             * @return the {@code ConformsTo}
             * @throws NullPointerException if a required element is absent
             */
            public ConformsTo build() {
                return new ConformsTo(
                        id, extension, modifierExtension, category, specification, version, source);
            }
        }
    }

    /**
     * A device that is part (for example a component) of the present device.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param reference Reference to the part. Reference to DeviceDefinition. Required.
     * @param count Number of occurrences of the part.
     */
    public record HasPart(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference reference,
            FhirInteger count) implements BackboneElement {

        /**
         * Creates a {@code HasPart}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public HasPart {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(reference, "DeviceDefinition.hasPart.reference is required");
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
         * Returns a builder initialized with the values of this {@code HasPart}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link HasPart}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference reference;
            private FhirInteger count;

            private Builder() {
            }

            private Builder(HasPart original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.reference = original.reference();
                this.count = original.count();
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
             * Sets {@code count}.
             *
             * @param count the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder count(FhirInteger count) {
                this.count = count;
                return this;
            }

            /**
             * Sets {@code count}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param count the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder count(Integer count) {
                return count(count == null ? null : FhirInteger.of(count));
            }

            /**
             * Builds the {@code HasPart}.
             *
             * @return the {@code HasPart}
             * @throws NullPointerException if a required element is absent
             */
            public HasPart build() {
                return new HasPart(
                        id, extension, modifierExtension, reference, count);
            }
        }
    }

    /**
     * Information about the packaging of the device, i.e. how the device is packaged.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier Business identifier of the packaged medication.
     * @param type A code that defines the specific type of packaging.
     * @param count The number of items contained in the package (devices or sub-packages).
     * @param distributor An organization that distributes the packaged device.
     * @param udiDeviceIdentifier Unique Device Identifier (UDI) Barcode string on the packaging.
     * @param packaging Allows packages within packages.
     */
    public record Packaging(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Identifier identifier,
            CodeableConcept type,
            FhirInteger count,
            List<PackagingDistributor> distributor,
            List<DeviceDefinition.UdiDeviceIdentifier> udiDeviceIdentifier,
            List<DeviceDefinition.Packaging> packaging) implements BackboneElement {

        /**
         * Creates a {@code Packaging}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Packaging {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            distributor = distributor == null ? List.of() : List.copyOf(distributor);
            udiDeviceIdentifier = udiDeviceIdentifier == null ? List.of() : List.copyOf(udiDeviceIdentifier);
            packaging = packaging == null ? List.of() : List.copyOf(packaging);
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
         * Returns a builder initialized with the values of this {@code Packaging}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * An organization that distributes the packaged device.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param name Distributor's human-readable name.
         * @param organizationReference Distributor as an Organization resource. Reference to Organization.
         */
        public record PackagingDistributor(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString name,
                List<Reference> organizationReference) implements BackboneElement {

            /**
             * Creates a {@code PackagingDistributor}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public PackagingDistributor {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                organizationReference =
                        organizationReference == null ? List.of() : List.copyOf(organizationReference);
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
             * Returns a builder initialized with the values of this {@code PackagingDistributor}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link PackagingDistributor}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString name;
                private List<Reference> organizationReference = new ArrayList<>();

                private Builder() {
                }

                private Builder(PackagingDistributor original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.name = original.name();
                    this.organizationReference = new ArrayList<>(original.organizationReference());
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
                 * Replaces all {@code organizationReference} values.
                 *
                 * @param organizationReference the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder organizationReference(List<Reference> organizationReference) {
                    this.organizationReference = organizationReference == null
                            ? new ArrayList<>()
                            : new ArrayList<>(organizationReference);
                    return this;
                }

                /**
                 * Adds a {@code organizationReference} value.
                 *
                 * @param organizationReference the value to add
                 * @return this builder
                 */
                public Builder addOrganizationReference(Reference organizationReference) {
                    this.organizationReference.add(
                            Objects.requireNonNull(organizationReference, "organizationReference"));
                    return this;
                }

                /**
                 * Builds the {@code PackagingDistributor}.
                 *
                 * @return the {@code PackagingDistributor}
                 */
                public PackagingDistributor build() {
                    return new PackagingDistributor(
                            id, extension, modifierExtension, name, organizationReference);
                }
            }
        }

        /** Builder for {@link Packaging}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Identifier identifier;
            private CodeableConcept type;
            private FhirInteger count;
            private List<PackagingDistributor> distributor = new ArrayList<>();
            private List<DeviceDefinition.UdiDeviceIdentifier> udiDeviceIdentifier = new ArrayList<>();
            private List<DeviceDefinition.Packaging> packaging = new ArrayList<>();

            private Builder() {
            }

            private Builder(Packaging original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = original.identifier();
                this.type = original.type();
                this.count = original.count();
                this.distributor = new ArrayList<>(original.distributor());
                this.udiDeviceIdentifier = new ArrayList<>(original.udiDeviceIdentifier());
                this.packaging = new ArrayList<>(original.packaging());
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
             * Sets {@code count}.
             *
             * @param count the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder count(FhirInteger count) {
                this.count = count;
                return this;
            }

            /**
             * Sets {@code count}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param count the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder count(Integer count) {
                return count(count == null ? null : FhirInteger.of(count));
            }

            /**
             * Replaces all {@code distributor} values.
             *
             * @param distributor the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder distributor(List<PackagingDistributor> distributor) {
                this.distributor = distributor == null ? new ArrayList<>() : new ArrayList<>(distributor);
                return this;
            }

            /**
             * Adds a {@code distributor} value.
             *
             * @param distributor the value to add
             * @return this builder
             */
            public Builder addDistributor(PackagingDistributor distributor) {
                this.distributor.add(Objects.requireNonNull(distributor, "distributor"));
                return this;
            }

            /**
             * Replaces all {@code udiDeviceIdentifier} values.
             *
             * @param udiDeviceIdentifier the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder udiDeviceIdentifier(List<DeviceDefinition.UdiDeviceIdentifier> udiDeviceIdentifier) {
                this.udiDeviceIdentifier = udiDeviceIdentifier == null
                        ? new ArrayList<>()
                        : new ArrayList<>(udiDeviceIdentifier);
                return this;
            }

            /**
             * Adds a {@code udiDeviceIdentifier} value.
             *
             * @param udiDeviceIdentifier the value to add
             * @return this builder
             */
            public Builder addUdiDeviceIdentifier(DeviceDefinition.UdiDeviceIdentifier udiDeviceIdentifier) {
                this.udiDeviceIdentifier.add(Objects.requireNonNull(udiDeviceIdentifier, "udiDeviceIdentifier"));
                return this;
            }

            /**
             * Replaces all {@code packaging} values.
             *
             * @param packaging the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder packaging(List<DeviceDefinition.Packaging> packaging) {
                this.packaging = packaging == null ? new ArrayList<>() : new ArrayList<>(packaging);
                return this;
            }

            /**
             * Adds a {@code packaging} value.
             *
             * @param packaging the value to add
             * @return this builder
             */
            public Builder addPackaging(DeviceDefinition.Packaging packaging) {
                this.packaging.add(Objects.requireNonNull(packaging, "packaging"));
                return this;
            }

            /**
             * Builds the {@code Packaging}.
             *
             * @return the {@code Packaging}
             */
            public Packaging build() {
                return new Packaging(
                        id, extension, modifierExtension, identifier, type, count, distributor, udiDeviceIdentifier,
                        packaging);
            }
        }
    }

    /**
     * The version of the device or software.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type The type of the device version, e.g. manufacturer, approved, internal.
     * @param component The hardware or software module of the device to which the version applies.
     * @param value The version text. Required.
     */
    public record Version(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            Identifier component,
            FhirString value) implements BackboneElement {

        /**
         * Creates a {@code Version}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Version {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(value, "DeviceDefinition.version.value is required");
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
            private FhirString value;

            private Builder() {
            }

            private Builder(Version original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.component = original.component();
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
                        id, extension, modifierExtension, type, component, value);
            }
        }
    }

    /**
     * Static or essentially fixed characteristics or features of this kind of device that are otherwise not captured
     * in more specific attributes, e.g., time or timing attributes, resolution, accuracy, and physical attributes.
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
            Objects.requireNonNull(type, "DeviceDefinition.property.type is required");
            Objects.requireNonNull(value, "DeviceDefinition.property.value is required");
            if (value != null && !(value instanceof Quantity
                    || value instanceof CodeableConcept
                    || value instanceof FhirString
                    || value instanceof FhirBoolean
                    || value instanceof FhirInteger
                    || value instanceof Range
                    || value instanceof Attachment)) {
                throw new IllegalArgumentException(
                        "DeviceDefinition.property.value[x] does not allow "
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

    /**
     * An associated device, attached to, used with, communicating with or linking a previous or new device model to
     * the focal device.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param relation The type indicates the relationship of the related device to the device instance. Required.
     * @param relatedDevice A reference to the linked device. Required.
     */
    public record Link(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Coding relation,
            CodeableReference relatedDevice) implements BackboneElement {

        /**
         * Creates a {@code Link}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Link {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(relation, "DeviceDefinition.link.relation is required");
            Objects.requireNonNull(relatedDevice, "DeviceDefinition.link.relatedDevice is required");
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
         * Returns a builder initialized with the values of this {@code Link}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Link}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Coding relation;
            private CodeableReference relatedDevice;

            private Builder() {
            }

            private Builder(Link original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.relation = original.relation();
                this.relatedDevice = original.relatedDevice();
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
             * Sets {@code relation}.
             *
             * @param relation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder relation(Coding relation) {
                this.relation = relation;
                return this;
            }

            /**
             * Sets {@code relatedDevice}.
             *
             * @param relatedDevice the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder relatedDevice(CodeableReference relatedDevice) {
                this.relatedDevice = relatedDevice;
                return this;
            }

            /**
             * Builds the {@code Link}.
             *
             * @return the {@code Link}
             * @throws NullPointerException if a required element is absent
             */
            public Link build() {
                return new Link(
                        id, extension, modifierExtension, relation, relatedDevice);
            }
        }
    }

    /**
     * A substance used to create the material(s) of which the device is made.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param substance A relevant substance that the device contains, may contain, or is made of. Required.
     * @param alternate Indicates an alternative material of the device.
     * @param allergenicIndicator Whether the substance is a known or suspected allergen.
     */
    public record Material(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept substance,
            FhirBoolean alternate,
            FhirBoolean allergenicIndicator) implements BackboneElement {

        /**
         * Creates a {@code Material}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Material {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(substance, "DeviceDefinition.material.substance is required");
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
         * Returns a builder initialized with the values of this {@code Material}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Material}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept substance;
            private FhirBoolean alternate;
            private FhirBoolean allergenicIndicator;

            private Builder() {
            }

            private Builder(Material original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.substance = original.substance();
                this.alternate = original.alternate();
                this.allergenicIndicator = original.allergenicIndicator();
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
             * Sets {@code substance}.
             *
             * @param substance the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder substance(CodeableConcept substance) {
                this.substance = substance;
                return this;
            }

            /**
             * Sets {@code alternate}.
             *
             * @param alternate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder alternate(FhirBoolean alternate) {
                this.alternate = alternate;
                return this;
            }

            /**
             * Sets {@code alternate}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param alternate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder alternate(Boolean alternate) {
                return alternate(alternate == null ? null : FhirBoolean.of(alternate));
            }

            /**
             * Sets {@code allergenicIndicator}.
             *
             * @param allergenicIndicator the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder allergenicIndicator(FhirBoolean allergenicIndicator) {
                this.allergenicIndicator = allergenicIndicator;
                return this;
            }

            /**
             * Sets {@code allergenicIndicator}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param allergenicIndicator the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder allergenicIndicator(Boolean allergenicIndicator) {
                return allergenicIndicator(allergenicIndicator == null ? null : FhirBoolean.of(allergenicIndicator));
            }

            /**
             * Builds the {@code Material}.
             *
             * @return the {@code Material}
             * @throws NullPointerException if a required element is absent
             */
            public Material build() {
                return new Material(
                        id, extension, modifierExtension, substance, alternate, allergenicIndicator);
            }
        }
    }

    /**
     * Information aimed at providing directions for the usage of this model of device.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param useContext The circumstances that form the setting for using the device.
     * @param usageInstruction Detailed written and visual directions for the user on how to use the device.
     * @param relatedArtifact A source of information or reference for this guideline.
     * @param indication A clinical condition for which the device was designed to be used.
     * @param contraindication A specific situation when a device should not be used because it may cause harm.
     * @param warning Specific hazard alert information that a user needs to know before using the device.
     * @param intendedUse A description of the general purpose or medical use of the device or its function.
     */
    public record Guideline(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<UsageContext> useContext,
            FhirMarkdown usageInstruction,
            List<RelatedArtifact> relatedArtifact,
            List<CodeableConcept> indication,
            List<CodeableConcept> contraindication,
            List<CodeableConcept> warning,
            FhirString intendedUse) implements BackboneElement {

        /**
         * Creates a {@code Guideline}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Guideline {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            useContext = useContext == null ? List.of() : List.copyOf(useContext);
            relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
            indication = indication == null ? List.of() : List.copyOf(indication);
            contraindication = contraindication == null ? List.of() : List.copyOf(contraindication);
            warning = warning == null ? List.of() : List.copyOf(warning);
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
         * Returns a builder initialized with the values of this {@code Guideline}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Guideline}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<UsageContext> useContext = new ArrayList<>();
            private FhirMarkdown usageInstruction;
            private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
            private List<CodeableConcept> indication = new ArrayList<>();
            private List<CodeableConcept> contraindication = new ArrayList<>();
            private List<CodeableConcept> warning = new ArrayList<>();
            private FhirString intendedUse;

            private Builder() {
            }

            private Builder(Guideline original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.useContext = new ArrayList<>(original.useContext());
                this.usageInstruction = original.usageInstruction();
                this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
                this.indication = new ArrayList<>(original.indication());
                this.contraindication = new ArrayList<>(original.contraindication());
                this.warning = new ArrayList<>(original.warning());
                this.intendedUse = original.intendedUse();
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
             * Sets {@code usageInstruction}.
             *
             * @param usageInstruction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder usageInstruction(FhirMarkdown usageInstruction) {
                this.usageInstruction = usageInstruction;
                return this;
            }

            /**
             * Sets {@code usageInstruction}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param usageInstruction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder usageInstruction(String usageInstruction) {
                return usageInstruction(usageInstruction == null ? null : FhirMarkdown.of(usageInstruction));
            }

            /**
             * Replaces all {@code relatedArtifact} values.
             *
             * @param relatedArtifact the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder relatedArtifact(List<RelatedArtifact> relatedArtifact) {
                this.relatedArtifact = relatedArtifact == null ? new ArrayList<>() : new ArrayList<>(relatedArtifact);
                return this;
            }

            /**
             * Adds a {@code relatedArtifact} value.
             *
             * @param relatedArtifact the value to add
             * @return this builder
             */
            public Builder addRelatedArtifact(RelatedArtifact relatedArtifact) {
                this.relatedArtifact.add(Objects.requireNonNull(relatedArtifact, "relatedArtifact"));
                return this;
            }

            /**
             * Replaces all {@code indication} values.
             *
             * @param indication the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder indication(List<CodeableConcept> indication) {
                this.indication = indication == null ? new ArrayList<>() : new ArrayList<>(indication);
                return this;
            }

            /**
             * Adds a {@code indication} value.
             *
             * @param indication the value to add
             * @return this builder
             */
            public Builder addIndication(CodeableConcept indication) {
                this.indication.add(Objects.requireNonNull(indication, "indication"));
                return this;
            }

            /**
             * Replaces all {@code contraindication} values.
             *
             * @param contraindication the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder contraindication(List<CodeableConcept> contraindication) {
                this.contraindication = contraindication == null
                        ? new ArrayList<>()
                        : new ArrayList<>(contraindication);
                return this;
            }

            /**
             * Adds a {@code contraindication} value.
             *
             * @param contraindication the value to add
             * @return this builder
             */
            public Builder addContraindication(CodeableConcept contraindication) {
                this.contraindication.add(Objects.requireNonNull(contraindication, "contraindication"));
                return this;
            }

            /**
             * Replaces all {@code warning} values.
             *
             * @param warning the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder warning(List<CodeableConcept> warning) {
                this.warning = warning == null ? new ArrayList<>() : new ArrayList<>(warning);
                return this;
            }

            /**
             * Adds a {@code warning} value.
             *
             * @param warning the value to add
             * @return this builder
             */
            public Builder addWarning(CodeableConcept warning) {
                this.warning.add(Objects.requireNonNull(warning, "warning"));
                return this;
            }

            /**
             * Sets {@code intendedUse}.
             *
             * @param intendedUse the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder intendedUse(FhirString intendedUse) {
                this.intendedUse = intendedUse;
                return this;
            }

            /**
             * Sets {@code intendedUse}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param intendedUse the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder intendedUse(String intendedUse) {
                return intendedUse(intendedUse == null ? null : FhirString.of(intendedUse));
            }

            /**
             * Builds the {@code Guideline}.
             *
             * @return the {@code Guideline}
             */
            public Guideline build() {
                return new Guideline(
                        id, extension, modifierExtension, useContext, usageInstruction, relatedArtifact, indication,
                        contraindication, warning, intendedUse);
            }
        }
    }

    /**
     * Tracking of latest field safety corrective action.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param recall Whether the corrective action was a recall. Required.
     * @param scope model | lot-numbers | serial-numbers.
     * @param period Start and end dates of the corrective action. Required.
     */
    public record CorrectiveAction(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirBoolean recall,
            FhirEnum<DeviceCorrectiveActionScope> scope,
            Period period) implements BackboneElement {

        /**
         * Creates a {@code CorrectiveAction}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public CorrectiveAction {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(recall, "DeviceDefinition.correctiveAction.recall is required");
            Objects.requireNonNull(period, "DeviceDefinition.correctiveAction.period is required");
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
         * Returns a builder initialized with the values of this {@code CorrectiveAction}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link CorrectiveAction}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirBoolean recall;
            private FhirEnum<DeviceCorrectiveActionScope> scope;
            private Period period;

            private Builder() {
            }

            private Builder(CorrectiveAction original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.recall = original.recall();
                this.scope = original.scope();
                this.period = original.period();
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
             * Sets {@code recall}.
             *
             * @param recall the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder recall(FhirBoolean recall) {
                this.recall = recall;
                return this;
            }

            /**
             * Sets {@code recall}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param recall the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder recall(Boolean recall) {
                return recall(recall == null ? null : FhirBoolean.of(recall));
            }

            /**
             * Sets {@code scope}.
             *
             * @param scope the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder scope(FhirEnum<DeviceCorrectiveActionScope> scope) {
                this.scope = scope;
                return this;
            }

            /**
             * Sets {@code scope}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param scope the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder scope(DeviceCorrectiveActionScope scope) {
                return scope(scope == null ? null : FhirEnum.of(scope));
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
             * Builds the {@code CorrectiveAction}.
             *
             * @return the {@code CorrectiveAction}
             * @throws NullPointerException if a required element is absent
             */
            public CorrectiveAction build() {
                return new CorrectiveAction(
                        id, extension, modifierExtension, recall, scope, period);
            }
        }
    }

    /**
     * Billing code or reference associated with the device.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param chargeItemCode The code or reference for the charge item. Required.
     * @param count Coefficient applicable to the billing code. Required.
     * @param effectivePeriod A specific time period in which this charge item applies.
     * @param useContext The context to which this charge item applies.
     */
    public record ChargeItem(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference chargeItemCode,
            Quantity count,
            Period effectivePeriod,
            List<UsageContext> useContext) implements BackboneElement {

        /**
         * Creates a {@code ChargeItem}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ChargeItem {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            useContext = useContext == null ? List.of() : List.copyOf(useContext);
            Objects.requireNonNull(chargeItemCode, "DeviceDefinition.chargeItem.chargeItemCode is required");
            Objects.requireNonNull(count, "DeviceDefinition.chargeItem.count is required");
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
         * Returns a builder initialized with the values of this {@code ChargeItem}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ChargeItem}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference chargeItemCode;
            private Quantity count;
            private Period effectivePeriod;
            private List<UsageContext> useContext = new ArrayList<>();

            private Builder() {
            }

            private Builder(ChargeItem original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.chargeItemCode = original.chargeItemCode();
                this.count = original.count();
                this.effectivePeriod = original.effectivePeriod();
                this.useContext = new ArrayList<>(original.useContext());
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
             * Sets {@code chargeItemCode}.
             *
             * @param chargeItemCode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder chargeItemCode(CodeableReference chargeItemCode) {
                this.chargeItemCode = chargeItemCode;
                return this;
            }

            /**
             * Sets {@code count}.
             *
             * @param count the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder count(Quantity count) {
                this.count = count;
                return this;
            }

            /**
             * Sets {@code effectivePeriod}.
             *
             * @param effectivePeriod the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder effectivePeriod(Period effectivePeriod) {
                this.effectivePeriod = effectivePeriod;
                return this;
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
             * Builds the {@code ChargeItem}.
             *
             * @return the {@code ChargeItem}
             * @throws NullPointerException if a required element is absent
             */
            public ChargeItem build() {
                return new ChargeItem(
                        id, extension, modifierExtension, chargeItemCode, count, effectivePeriod, useContext);
            }
        }
    }

    /** Builder for {@link DeviceDefinition}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirMarkdown description;
        private List<Identifier> identifier = new ArrayList<>();
        private List<UdiDeviceIdentifier> udiDeviceIdentifier = new ArrayList<>();
        private List<RegulatoryIdentifier> regulatoryIdentifier = new ArrayList<>();
        private FhirString partNumber;
        private Reference manufacturer;
        private List<DeviceName> deviceName = new ArrayList<>();
        private FhirString modelNumber;
        private List<Classification> classification = new ArrayList<>();
        private List<ConformsTo> conformsTo = new ArrayList<>();
        private List<HasPart> hasPart = new ArrayList<>();
        private List<Packaging> packaging = new ArrayList<>();
        private List<Version> version = new ArrayList<>();
        private List<CodeableConcept> safety = new ArrayList<>();
        private List<ProductShelfLife> shelfLifeStorage = new ArrayList<>();
        private List<CodeableConcept> languageCode = new ArrayList<>();
        private List<Property> property = new ArrayList<>();
        private Reference owner;
        private List<ContactPoint> contact = new ArrayList<>();
        private List<Link> link = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<Material> material = new ArrayList<>();
        private List<FhirEnum<DeviceProductionIdentifierInUDI>> productionIdentifierInUDI = new ArrayList<>();
        private Guideline guideline;
        private CorrectiveAction correctiveAction;
        private List<ChargeItem> chargeItem = new ArrayList<>();

        private Builder() {
        }

        private Builder(DeviceDefinition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.description = original.description();
            this.identifier = new ArrayList<>(original.identifier());
            this.udiDeviceIdentifier = new ArrayList<>(original.udiDeviceIdentifier());
            this.regulatoryIdentifier = new ArrayList<>(original.regulatoryIdentifier());
            this.partNumber = original.partNumber();
            this.manufacturer = original.manufacturer();
            this.deviceName = new ArrayList<>(original.deviceName());
            this.modelNumber = original.modelNumber();
            this.classification = new ArrayList<>(original.classification());
            this.conformsTo = new ArrayList<>(original.conformsTo());
            this.hasPart = new ArrayList<>(original.hasPart());
            this.packaging = new ArrayList<>(original.packaging());
            this.version = new ArrayList<>(original.version());
            this.safety = new ArrayList<>(original.safety());
            this.shelfLifeStorage = new ArrayList<>(original.shelfLifeStorage());
            this.languageCode = new ArrayList<>(original.languageCode());
            this.property = new ArrayList<>(original.property());
            this.owner = original.owner();
            this.contact = new ArrayList<>(original.contact());
            this.link = new ArrayList<>(original.link());
            this.note = new ArrayList<>(original.note());
            this.material = new ArrayList<>(original.material());
            this.productionIdentifierInUDI = new ArrayList<>(original.productionIdentifierInUDI());
            this.guideline = original.guideline();
            this.correctiveAction = original.correctiveAction();
            this.chargeItem = new ArrayList<>(original.chargeItem());
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
         * Replaces all {@code udiDeviceIdentifier} values.
         *
         * @param udiDeviceIdentifier the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder udiDeviceIdentifier(List<UdiDeviceIdentifier> udiDeviceIdentifier) {
            this.udiDeviceIdentifier = udiDeviceIdentifier == null
                    ? new ArrayList<>()
                    : new ArrayList<>(udiDeviceIdentifier);
            return this;
        }

        /**
         * Adds a {@code udiDeviceIdentifier} value.
         *
         * @param udiDeviceIdentifier the value to add
         * @return this builder
         */
        public Builder addUdiDeviceIdentifier(UdiDeviceIdentifier udiDeviceIdentifier) {
            this.udiDeviceIdentifier.add(Objects.requireNonNull(udiDeviceIdentifier, "udiDeviceIdentifier"));
            return this;
        }

        /**
         * Replaces all {@code regulatoryIdentifier} values.
         *
         * @param regulatoryIdentifier the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder regulatoryIdentifier(List<RegulatoryIdentifier> regulatoryIdentifier) {
            this.regulatoryIdentifier = regulatoryIdentifier == null
                    ? new ArrayList<>()
                    : new ArrayList<>(regulatoryIdentifier);
            return this;
        }

        /**
         * Adds a {@code regulatoryIdentifier} value.
         *
         * @param regulatoryIdentifier the value to add
         * @return this builder
         */
        public Builder addRegulatoryIdentifier(RegulatoryIdentifier regulatoryIdentifier) {
            this.regulatoryIdentifier.add(Objects.requireNonNull(regulatoryIdentifier, "regulatoryIdentifier"));
            return this;
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
         * Sets {@code manufacturer}.
         *
         * @param manufacturer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder manufacturer(Reference manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        /**
         * Replaces all {@code deviceName} values.
         *
         * @param deviceName the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder deviceName(List<DeviceName> deviceName) {
            this.deviceName = deviceName == null ? new ArrayList<>() : new ArrayList<>(deviceName);
            return this;
        }

        /**
         * Adds a {@code deviceName} value.
         *
         * @param deviceName the value to add
         * @return this builder
         */
        public Builder addDeviceName(DeviceName deviceName) {
            this.deviceName.add(Objects.requireNonNull(deviceName, "deviceName"));
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
         * Replaces all {@code classification} values.
         *
         * @param classification the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder classification(List<Classification> classification) {
            this.classification = classification == null ? new ArrayList<>() : new ArrayList<>(classification);
            return this;
        }

        /**
         * Adds a {@code classification} value.
         *
         * @param classification the value to add
         * @return this builder
         */
        public Builder addClassification(Classification classification) {
            this.classification.add(Objects.requireNonNull(classification, "classification"));
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
         * Replaces all {@code hasPart} values.
         *
         * @param hasPart the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder hasPart(List<HasPart> hasPart) {
            this.hasPart = hasPart == null ? new ArrayList<>() : new ArrayList<>(hasPart);
            return this;
        }

        /**
         * Adds a {@code hasPart} value.
         *
         * @param hasPart the value to add
         * @return this builder
         */
        public Builder addHasPart(HasPart hasPart) {
            this.hasPart.add(Objects.requireNonNull(hasPart, "hasPart"));
            return this;
        }

        /**
         * Replaces all {@code packaging} values.
         *
         * @param packaging the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder packaging(List<Packaging> packaging) {
            this.packaging = packaging == null ? new ArrayList<>() : new ArrayList<>(packaging);
            return this;
        }

        /**
         * Adds a {@code packaging} value.
         *
         * @param packaging the value to add
         * @return this builder
         */
        public Builder addPackaging(Packaging packaging) {
            this.packaging.add(Objects.requireNonNull(packaging, "packaging"));
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
         * Replaces all {@code shelfLifeStorage} values.
         *
         * @param shelfLifeStorage the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder shelfLifeStorage(List<ProductShelfLife> shelfLifeStorage) {
            this.shelfLifeStorage = shelfLifeStorage == null ? new ArrayList<>() : new ArrayList<>(shelfLifeStorage);
            return this;
        }

        /**
         * Adds a {@code shelfLifeStorage} value.
         *
         * @param shelfLifeStorage the value to add
         * @return this builder
         */
        public Builder addShelfLifeStorage(ProductShelfLife shelfLifeStorage) {
            this.shelfLifeStorage.add(Objects.requireNonNull(shelfLifeStorage, "shelfLifeStorage"));
            return this;
        }

        /**
         * Replaces all {@code languageCode} values.
         *
         * @param languageCode the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder languageCode(List<CodeableConcept> languageCode) {
            this.languageCode = languageCode == null ? new ArrayList<>() : new ArrayList<>(languageCode);
            return this;
        }

        /**
         * Adds a {@code languageCode} value.
         *
         * @param languageCode the value to add
         * @return this builder
         */
        public Builder addLanguageCode(CodeableConcept languageCode) {
            this.languageCode.add(Objects.requireNonNull(languageCode, "languageCode"));
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
         * Replaces all {@code link} values.
         *
         * @param link the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder link(List<Link> link) {
            this.link = link == null ? new ArrayList<>() : new ArrayList<>(link);
            return this;
        }

        /**
         * Adds a {@code link} value.
         *
         * @param link the value to add
         * @return this builder
         */
        public Builder addLink(Link link) {
            this.link.add(Objects.requireNonNull(link, "link"));
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
         * Replaces all {@code material} values.
         *
         * @param material the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder material(List<Material> material) {
            this.material = material == null ? new ArrayList<>() : new ArrayList<>(material);
            return this;
        }

        /**
         * Adds a {@code material} value.
         *
         * @param material the value to add
         * @return this builder
         */
        public Builder addMaterial(Material material) {
            this.material.add(Objects.requireNonNull(material, "material"));
            return this;
        }

        /**
         * Replaces all {@code productionIdentifierInUDI} values.
         *
         * @param productionIdentifierInUDI the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder productionIdentifierInUDI(List<FhirEnum<DeviceProductionIdentifierInUDI>> productionIdentifierInUDI) {
            this.productionIdentifierInUDI = productionIdentifierInUDI == null
                    ? new ArrayList<>()
                    : new ArrayList<>(productionIdentifierInUDI);
            return this;
        }

        /**
         * Adds a {@code productionIdentifierInUDI} value.
         *
         * @param productionIdentifierInUDI the value to add
         * @return this builder
         */
        public Builder addProductionIdentifierInUDI(FhirEnum<DeviceProductionIdentifierInUDI> productionIdentifierInUDI) {
            this.productionIdentifierInUDI.add(
                    Objects.requireNonNull(productionIdentifierInUDI, "productionIdentifierInUDI"));
            return this;
        }

        /**
         * Adds a {@code productionIdentifierInUDI} value, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param productionIdentifierInUDI the value to add
         * @return this builder
         */
        public Builder addProductionIdentifierInUDI(DeviceProductionIdentifierInUDI productionIdentifierInUDI) {
            return addProductionIdentifierInUDI(FhirEnum.of(productionIdentifierInUDI));
        }

        /**
         * Sets {@code guideline}.
         *
         * @param guideline the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder guideline(Guideline guideline) {
            this.guideline = guideline;
            return this;
        }

        /**
         * Sets {@code correctiveAction}.
         *
         * @param correctiveAction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder correctiveAction(CorrectiveAction correctiveAction) {
            this.correctiveAction = correctiveAction;
            return this;
        }

        /**
         * Replaces all {@code chargeItem} values.
         *
         * @param chargeItem the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder chargeItem(List<ChargeItem> chargeItem) {
            this.chargeItem = chargeItem == null ? new ArrayList<>() : new ArrayList<>(chargeItem);
            return this;
        }

        /**
         * Adds a {@code chargeItem} value.
         *
         * @param chargeItem the value to add
         * @return this builder
         */
        public Builder addChargeItem(ChargeItem chargeItem) {
            this.chargeItem.add(Objects.requireNonNull(chargeItem, "chargeItem"));
            return this;
        }

        /**
         * Builds the {@code DeviceDefinition}.
         *
         * @return the {@code DeviceDefinition}
         */
        public DeviceDefinition build() {
            return new DeviceDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, description,
                    identifier, udiDeviceIdentifier, regulatoryIdentifier, partNumber, manufacturer, deviceName,
                    modelNumber, classification, conformsTo, hasPart, packaging, version, safety, shelfLifeStorage,
                    languageCode, property, owner, contact, link, note, material, productionIdentifierInUDI,
                    guideline, correctiveAction, chargeItem);
        }
    }
}
