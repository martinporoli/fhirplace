package se.poroli.fhirplace.r5.clinical.requestresponse;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.Availability;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Contributor;
import se.poroli.fhirplace.r5.datatypes.Count;
import se.poroli.fhirplace.r5.datatypes.DataRequirement;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Distance;
import se.poroli.fhirplace.r5.datatypes.Dosage;
import se.poroli.fhirplace.r5.datatypes.ElementDefinition;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirInteger64;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirOid;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirTime;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUuid;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.ParameterDefinition;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.RatioRange;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.SampledData;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.datatypes.TriggerDefinition;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.valuesets.CommonLanguages;
import se.poroli.fhirplace.r5.valuesets.InventoryItemStatusCodes;

/**
 * functional description of an inventory item used in inventory and supply-related workflows.
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
 * @param identifier Business identifier for the inventory item.
 * @param status active | inactive | entered-in-error | unknown. Required.
 * @param category Category or class of the item.
 * @param code Code designating the specific type of item.
 * @param name The item name(s) - the brand name, or common name, functional name, generic name or others.
 * @param responsibleOrganization Organization(s) responsible for the product.
 * @param description Descriptive characteristics of the item.
 * @param inventoryStatus The usage status like recalled, in use, discarded.
 * @param baseUnit The base unit of measure - the unit in which the product is used or counted.
 * @param netContent Net content or amount present in the item.
 * @param association Association with other items or products.
 * @param characteristic Characteristic of the item.
 * @param instance Instances or occurrences of the product.
 * @param productReference Link to a product resource used in clinical workflows. Reference to Medication, Device,
 *   NutritionProduct, BiologicallyDerivedProduct.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/InventoryItem">FHIR R5 InventoryItem</a>
 */
public record InventoryItem(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<InventoryItemStatusCodes> status,
        List<CodeableConcept> category,
        List<CodeableConcept> code,
        List<Name> name,
        List<ResponsibleOrganization> responsibleOrganization,
        Description description,
        List<CodeableConcept> inventoryStatus,
        CodeableConcept baseUnit,
        Quantity netContent,
        List<Association> association,
        List<Characteristic> characteristic,
        Instance instance,
        Reference productReference) implements DomainResource {

    /**
     * Creates an {@code InventoryItem}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public InventoryItem {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        category = category == null ? List.of() : List.copyOf(category);
        code = code == null ? List.of() : List.copyOf(code);
        name = name == null ? List.of() : List.copyOf(name);
        responsibleOrganization = responsibleOrganization == null ? List.of() : List.copyOf(responsibleOrganization);
        inventoryStatus = inventoryStatus == null ? List.of() : List.copyOf(inventoryStatus);
        association = association == null ? List.of() : List.copyOf(association);
        characteristic = characteristic == null ? List.of() : List.copyOf(characteristic);
        Objects.requireNonNull(status, "InventoryItem.status is required");
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
     * Returns a builder initialized with the values of this {@code InventoryItem}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The item name(s) - the brand name, or common name, functional name, generic name.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param nameType The type of name e.g. 'brand-name', 'functional-name', 'common-name'. Required.
     * @param language The language used to express the item name. Required.
     * @param name The name or designation of the item. Required.
     */
    public record Name(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Coding nameType,
            FhirEnum<CommonLanguages> language,
            FhirString name) implements BackboneElement {

        /**
         * Creates a {@code Name}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Name {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(nameType, "InventoryItem.name.nameType is required");
            Objects.requireNonNull(language, "InventoryItem.name.language is required");
            Objects.requireNonNull(name, "InventoryItem.name.name is required");
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
            private Coding nameType;
            private FhirEnum<CommonLanguages> language;
            private FhirString name;

            private Builder() {
            }

            private Builder(Name original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.nameType = original.nameType();
                this.language = original.language();
                this.name = original.name();
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
             * Sets {@code nameType}.
             *
             * @param nameType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder nameType(Coding nameType) {
                this.nameType = nameType;
                return this;
            }

            /**
             * Sets {@code language}.
             *
             * @param language the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder language(FhirEnum<CommonLanguages> language) {
                this.language = language;
                return this;
            }

            /**
             * Sets {@code language}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param language the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder language(CommonLanguages language) {
                return language(language == null ? null : FhirEnum.of(language));
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
             * Builds the {@code Name}.
             *
             * @return the {@code Name}
             * @throws NullPointerException if a required element is absent
             */
            public Name build() {
                return new Name(
                        id, extension, modifierExtension, nameType, language, name);
            }
        }
    }

    /**
     * Organization(s) responsible for the product.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param role The role of the organization e.g. manufacturer, distributor, or other. Required.
     * @param organization An organization that is associated with the item. Reference to Organization. Required.
     */
    public record ResponsibleOrganization(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept role,
            Reference organization) implements BackboneElement {

        /**
         * Creates a {@code ResponsibleOrganization}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ResponsibleOrganization {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(role, "InventoryItem.responsibleOrganization.role is required");
            Objects.requireNonNull(organization, "InventoryItem.responsibleOrganization.organization is required");
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
         * Returns a builder initialized with the values of this {@code ResponsibleOrganization}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ResponsibleOrganization}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept role;
            private Reference organization;

            private Builder() {
            }

            private Builder(ResponsibleOrganization original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.role = original.role();
                this.organization = original.organization();
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
             * Sets {@code role}.
             *
             * @param role the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder role(CodeableConcept role) {
                this.role = role;
                return this;
            }

            /**
             * Sets {@code organization}.
             *
             * @param organization the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder organization(Reference organization) {
                this.organization = organization;
                return this;
            }

            /**
             * Builds the {@code ResponsibleOrganization}.
             *
             * @return the {@code ResponsibleOrganization}
             * @throws NullPointerException if a required element is absent
             */
            public ResponsibleOrganization build() {
                return new ResponsibleOrganization(
                        id, extension, modifierExtension, role, organization);
            }
        }
    }

    /**
     * The descriptive characteristics of the inventory item.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param language The language that is used in the item description.
     * @param description Textual description of the item.
     */
    public record Description(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<CommonLanguages> language,
            FhirString description) implements BackboneElement {

        /**
         * Creates a {@code Description}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Description {
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
         * Returns a builder initialized with the values of this {@code Description}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Description}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<CommonLanguages> language;
            private FhirString description;

            private Builder() {
            }

            private Builder(Description original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.language = original.language();
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
             * Sets {@code language}.
             *
             * @param language the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder language(FhirEnum<CommonLanguages> language) {
                this.language = language;
                return this;
            }

            /**
             * Sets {@code language}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param language the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder language(CommonLanguages language) {
                return language(language == null ? null : FhirEnum.of(language));
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
             * Builds the {@code Description}.
             *
             * @return the {@code Description}
             */
            public Description build() {
                return new Description(
                        id, extension, modifierExtension, language, description);
            }
        }
    }

    /**
     * Association with other items or products.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param associationType The type of association between the device and the other item. Required.
     * @param relatedItem The related item or product. Reference to InventoryItem, Medication, MedicationKnowledge,
     *   Device, DeviceDefinition, NutritionProduct, BiologicallyDerivedProduct. Required.
     * @param quantity The quantity of the product in this product. Required.
     */
    public record Association(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept associationType,
            Reference relatedItem,
            Ratio quantity) implements BackboneElement {

        /**
         * Creates an {@code Association}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Association {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(associationType, "InventoryItem.association.associationType is required");
            Objects.requireNonNull(relatedItem, "InventoryItem.association.relatedItem is required");
            Objects.requireNonNull(quantity, "InventoryItem.association.quantity is required");
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
         * Returns a builder initialized with the values of this {@code Association}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Association}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept associationType;
            private Reference relatedItem;
            private Ratio quantity;

            private Builder() {
            }

            private Builder(Association original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.associationType = original.associationType();
                this.relatedItem = original.relatedItem();
                this.quantity = original.quantity();
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
             * Sets {@code associationType}.
             *
             * @param associationType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder associationType(CodeableConcept associationType) {
                this.associationType = associationType;
                return this;
            }

            /**
             * Sets {@code relatedItem}.
             *
             * @param relatedItem the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder relatedItem(Reference relatedItem) {
                this.relatedItem = relatedItem;
                return this;
            }

            /**
             * Sets {@code quantity}.
             *
             * @param quantity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder quantity(Ratio quantity) {
                this.quantity = quantity;
                return this;
            }

            /**
             * Builds the {@code Association}.
             *
             * @return the {@code Association}
             * @throws NullPointerException if a required element is absent
             */
            public Association build() {
                return new Association(
                        id, extension, modifierExtension, associationType, relatedItem, quantity);
            }
        }
    }

    /**
     * The descriptive or identifying characteristics of the item.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param characteristicType The characteristic that is being defined. Required.
     * @param value The value of the attribute. Any datatype except FhirInteger64, FhirPositiveInt, FhirUnsignedInt,
     *   FhirMarkdown, FhirCode, FhirId, FhirUri, FhirCanonical, FhirOid, FhirUuid, FhirBase64Binary, FhirInstant,
     *   FhirDate, FhirTime, FhirEnum, Identifier, HumanName, ContactPoint, Timing, Attachment, Period, RatioRange,
     *   Coding, SampledData, Age, Distance, Count, Money, Signature, ContactDetail, Contributor, DataRequirement,
     *   ParameterDefinition, RelatedArtifact, TriggerDefinition, UsageContext, Expression, ExtendedContactDetail,
     *   VirtualServiceDetail, Availability, MonetaryComponent, Reference, CodeableReference, Narrative, Extension,
     *   Meta, Dosage, ElementDefinition, ProductShelfLife, MarketingStatus. Required.
     */
    public record Characteristic(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept characteristicType,
            DataType value) implements BackboneElement {

        /**
         * Creates a {@code Characteristic}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Characteristic {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(characteristicType, "InventoryItem.characteristic.characteristicType is required");
            Objects.requireNonNull(value, "InventoryItem.characteristic.value is required");
            if (value != null && (value instanceof FhirInteger64
                    || value instanceof FhirPositiveInt
                    || value instanceof FhirUnsignedInt
                    || value instanceof FhirMarkdown
                    || value instanceof FhirCode
                    || value instanceof FhirId
                    || value instanceof FhirUri
                    || value instanceof FhirCanonical
                    || value instanceof FhirOid
                    || value instanceof FhirUuid
                    || value instanceof FhirBase64Binary
                    || value instanceof FhirInstant
                    || value instanceof FhirDate
                    || value instanceof FhirTime
                    || value instanceof FhirEnum<?>
                    || value instanceof Identifier
                    || value instanceof HumanName
                    || value instanceof ContactPoint
                    || value instanceof Timing
                    || value instanceof Attachment
                    || value instanceof Period
                    || value instanceof RatioRange
                    || value instanceof Coding
                    || value instanceof SampledData
                    || value instanceof Age
                    || value instanceof Distance
                    || value instanceof Count
                    || value instanceof Money
                    || value instanceof Signature
                    || value instanceof ContactDetail
                    || value instanceof Contributor
                    || value instanceof DataRequirement
                    || value instanceof ParameterDefinition
                    || value instanceof RelatedArtifact
                    || value instanceof TriggerDefinition
                    || value instanceof UsageContext
                    || value instanceof Expression
                    || value instanceof ExtendedContactDetail
                    || value instanceof VirtualServiceDetail
                    || value instanceof Availability
                    || value instanceof MonetaryComponent
                    || value instanceof Reference
                    || value instanceof CodeableReference
                    || value instanceof Narrative
                    || value instanceof Extension
                    || value instanceof Meta
                    || value instanceof Dosage
                    || value instanceof ElementDefinition
                    || value instanceof ProductShelfLife
                    || value instanceof MarketingStatus)) {
                throw new IllegalArgumentException(
                        "InventoryItem.characteristic.value[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code Characteristic}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Characteristic}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept characteristicType;
            private DataType value;

            private Builder() {
            }

            private Builder(Characteristic original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.characteristicType = original.characteristicType();
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
             * Sets {@code characteristicType}.
             *
             * @param characteristicType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder characteristicType(CodeableConcept characteristicType) {
                this.characteristicType = characteristicType;
                return this;
            }

            /**
             * Sets {@code value}.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(DataType value) {
                this.value = value;
                return this;
            }

            /**
             * Builds the {@code Characteristic}.
             *
             * @return the {@code Characteristic}
             * @throws NullPointerException if a required element is absent
             */
            public Characteristic build() {
                return new Characteristic(
                        id, extension, modifierExtension, characteristicType, value);
            }
        }
    }

    /**
     * Instances or occurrences of the product.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier The identifier for the physical instance, typically a serial number.
     * @param lotNumber The lot or batch number of the item.
     * @param expiry The expiry date or date and time for the product.
     * @param subject The subject that the item is associated with. Reference to Patient, Organization.
     * @param location The location that the item is associated with. Reference to Location.
     */
    public record Instance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Identifier> identifier,
            FhirString lotNumber,
            FhirDateTime expiry,
            Reference subject,
            Reference location) implements BackboneElement {

        /**
         * Creates an {@code Instance}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Instance {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            identifier = identifier == null ? List.of() : List.copyOf(identifier);
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
         * Returns a builder initialized with the values of this {@code Instance}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Instance}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Identifier> identifier = new ArrayList<>();
            private FhirString lotNumber;
            private FhirDateTime expiry;
            private Reference subject;
            private Reference location;

            private Builder() {
            }

            private Builder(Instance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = new ArrayList<>(original.identifier());
                this.lotNumber = original.lotNumber();
                this.expiry = original.expiry();
                this.subject = original.subject();
                this.location = original.location();
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
             * Sets {@code expiry}.
             *
             * @param expiry the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder expiry(FhirDateTime expiry) {
                this.expiry = expiry;
                return this;
            }

            /**
             * Sets {@code expiry}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param expiry the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder expiry(Temporal expiry) {
                return expiry(expiry == null ? null : FhirDateTime.of(expiry));
            }

            /**
             * Sets {@code subject}.
             *
             * @param subject the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subject(Reference subject) {
                this.subject = subject;
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
             * Builds the {@code Instance}.
             *
             * @return the {@code Instance}
             */
            public Instance build() {
                return new Instance(
                        id, extension, modifierExtension, identifier, lotNumber, expiry, subject, location);
            }
        }
    }

    /** Builder for {@link InventoryItem}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<InventoryItemStatusCodes> status;
        private List<CodeableConcept> category = new ArrayList<>();
        private List<CodeableConcept> code = new ArrayList<>();
        private List<Name> name = new ArrayList<>();
        private List<ResponsibleOrganization> responsibleOrganization = new ArrayList<>();
        private Description description;
        private List<CodeableConcept> inventoryStatus = new ArrayList<>();
        private CodeableConcept baseUnit;
        private Quantity netContent;
        private List<Association> association = new ArrayList<>();
        private List<Characteristic> characteristic = new ArrayList<>();
        private Instance instance;
        private Reference productReference;

        private Builder() {
        }

        private Builder(InventoryItem original) {
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
            this.category = new ArrayList<>(original.category());
            this.code = new ArrayList<>(original.code());
            this.name = new ArrayList<>(original.name());
            this.responsibleOrganization = new ArrayList<>(original.responsibleOrganization());
            this.description = original.description();
            this.inventoryStatus = new ArrayList<>(original.inventoryStatus());
            this.baseUnit = original.baseUnit();
            this.netContent = original.netContent();
            this.association = new ArrayList<>(original.association());
            this.characteristic = new ArrayList<>(original.characteristic());
            this.instance = original.instance();
            this.productReference = original.productReference();
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
        public Builder status(FhirEnum<InventoryItemStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(InventoryItemStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Replaces all {@code code} values.
         *
         * @param code the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder code(List<CodeableConcept> code) {
            this.code = code == null ? new ArrayList<>() : new ArrayList<>(code);
            return this;
        }

        /**
         * Adds a {@code code} value.
         *
         * @param code the value to add
         * @return this builder
         */
        public Builder addCode(CodeableConcept code) {
            this.code.add(Objects.requireNonNull(code, "code"));
            return this;
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
         * Replaces all {@code responsibleOrganization} values.
         *
         * @param responsibleOrganization the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder responsibleOrganization(List<ResponsibleOrganization> responsibleOrganization) {
            this.responsibleOrganization = responsibleOrganization == null
                    ? new ArrayList<>()
                    : new ArrayList<>(responsibleOrganization);
            return this;
        }

        /**
         * Adds a {@code responsibleOrganization} value.
         *
         * @param responsibleOrganization the value to add
         * @return this builder
         */
        public Builder addResponsibleOrganization(ResponsibleOrganization responsibleOrganization) {
            this.responsibleOrganization.add(
                    Objects.requireNonNull(responsibleOrganization, "responsibleOrganization"));
            return this;
        }

        /**
         * Sets {@code description}.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(Description description) {
            this.description = description;
            return this;
        }

        /**
         * Replaces all {@code inventoryStatus} values.
         *
         * @param inventoryStatus the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder inventoryStatus(List<CodeableConcept> inventoryStatus) {
            this.inventoryStatus = inventoryStatus == null ? new ArrayList<>() : new ArrayList<>(inventoryStatus);
            return this;
        }

        /**
         * Adds a {@code inventoryStatus} value.
         *
         * @param inventoryStatus the value to add
         * @return this builder
         */
        public Builder addInventoryStatus(CodeableConcept inventoryStatus) {
            this.inventoryStatus.add(Objects.requireNonNull(inventoryStatus, "inventoryStatus"));
            return this;
        }

        /**
         * Sets {@code baseUnit}.
         *
         * @param baseUnit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder baseUnit(CodeableConcept baseUnit) {
            this.baseUnit = baseUnit;
            return this;
        }

        /**
         * Sets {@code netContent}.
         *
         * @param netContent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder netContent(Quantity netContent) {
            this.netContent = netContent;
            return this;
        }

        /**
         * Replaces all {@code association} values.
         *
         * @param association the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder association(List<Association> association) {
            this.association = association == null ? new ArrayList<>() : new ArrayList<>(association);
            return this;
        }

        /**
         * Adds a {@code association} value.
         *
         * @param association the value to add
         * @return this builder
         */
        public Builder addAssociation(Association association) {
            this.association.add(Objects.requireNonNull(association, "association"));
            return this;
        }

        /**
         * Replaces all {@code characteristic} values.
         *
         * @param characteristic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder characteristic(List<Characteristic> characteristic) {
            this.characteristic = characteristic == null ? new ArrayList<>() : new ArrayList<>(characteristic);
            return this;
        }

        /**
         * Adds a {@code characteristic} value.
         *
         * @param characteristic the value to add
         * @return this builder
         */
        public Builder addCharacteristic(Characteristic characteristic) {
            this.characteristic.add(Objects.requireNonNull(characteristic, "characteristic"));
            return this;
        }

        /**
         * Sets {@code instance}.
         *
         * @param instance the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instance(Instance instance) {
            this.instance = instance;
            return this;
        }

        /**
         * Sets {@code productReference}.
         *
         * @param productReference the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder productReference(Reference productReference) {
            this.productReference = productReference;
            return this;
        }

        /**
         * Builds the {@code InventoryItem}.
         *
         * @return the {@code InventoryItem}
         * @throws NullPointerException if a required element is absent
         */
        public InventoryItem build() {
            return new InventoryItem(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, category, code, name, responsibleOrganization, description, inventoryStatus, baseUnit,
                    netContent, association, characteristic, instance, productReference);
        }
    }
}
