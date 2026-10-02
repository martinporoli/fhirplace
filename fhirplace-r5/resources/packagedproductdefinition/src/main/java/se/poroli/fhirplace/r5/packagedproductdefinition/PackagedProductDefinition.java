package se.poroli.fhirplace.r5.packagedproductdefinition;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * A medically related item or items, in a container or package.
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
 * @param identifier A unique identifier for this package as whole - not for the content of the package.
 * @param name A name for this package. Typically as listed in a drug formulary, catalogue, inventory etc.
 * @param type A high level category e.g. medicinal product, raw material, shipping container etc.
 * @param packageFor The product that this is a pack for. Reference to MedicinalProductDefinition.
 * @param status The status within the lifecycle of this item. High level - not intended to duplicate details
 *   elsewhere e.g. legal status, or authorization/marketing status. Modifier element.
 * @param statusDate The date at which the given status became applicable.
 * @param containedItemQuantity A total of the complete count of contained items of a particular type/form,
 *   independent of sub-packaging or organization. This can be considered as the pack size. See also
 *   packaging.containedItem.amount (especially the long definition).
 * @param description Textual description. Note that this is not the name of the package or product.
 * @param legalStatusOfSupply The legal status of supply of the packaged item as classified by the regulator.
 * @param marketingStatus Allows specifying that an item is on the market for sale, or that it is not available, and
 *   the dates and locations associated.
 * @param copackagedIndicator Identifies if the drug product is supplied with another item such as a diluent or
 *   adjuvant.
 * @param manufacturer Manufacturer of this package type (multiple means these are all possible manufacturers).
 *   Reference to Organization.
 * @param attachedDocument Additional information or supporting documentation about the packaged product. Reference to
 *   DocumentReference.
 * @param packaging A packaging item, as a container for medically related items, possibly with other packaging items
 *   within, or a packaging component, such as bottle cap.
 * @param characteristic Allows the key features to be recorded, such as "hospital pack", "nurse prescribable".
 * @see <a href="http://hl7.org/fhir/StructureDefinition/PackagedProductDefinition">FHIR R5 PackagedProductDefinition</a>
 */
public record PackagedProductDefinition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirString name,
        CodeableConcept type,
        List<Reference> packageFor,
        CodeableConcept status,
        FhirDateTime statusDate,
        List<Quantity> containedItemQuantity,
        FhirMarkdown description,
        List<LegalStatusOfSupply> legalStatusOfSupply,
        List<MarketingStatus> marketingStatus,
        FhirBoolean copackagedIndicator,
        List<Reference> manufacturer,
        List<Reference> attachedDocument,
        Packaging packaging,
        List<PackagedProductDefinition.Packaging.Property> characteristic) implements DomainResource {

    /**
     * Creates a {@code PackagedProductDefinition}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public PackagedProductDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        packageFor = packageFor == null ? List.of() : List.copyOf(packageFor);
        containedItemQuantity = containedItemQuantity == null ? List.of() : List.copyOf(containedItemQuantity);
        legalStatusOfSupply = legalStatusOfSupply == null ? List.of() : List.copyOf(legalStatusOfSupply);
        marketingStatus = marketingStatus == null ? List.of() : List.copyOf(marketingStatus);
        manufacturer = manufacturer == null ? List.of() : List.copyOf(manufacturer);
        attachedDocument = attachedDocument == null ? List.of() : List.copyOf(attachedDocument);
        characteristic = characteristic == null ? List.of() : List.copyOf(characteristic);
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
     * Returns a builder initialized with the values of this {@code PackagedProductDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The legal status of supply of the packaged item as classified by the regulator.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code The actual status of supply. In what situation this package type may be supplied for use.
     * @param jurisdiction The place where the legal status of supply applies.
     */
    public record LegalStatusOfSupply(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            CodeableConcept jurisdiction) implements BackboneElement {

        /**
         * Creates a {@code LegalStatusOfSupply}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public LegalStatusOfSupply {
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
         * Returns a builder initialized with the values of this {@code LegalStatusOfSupply}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link LegalStatusOfSupply}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private CodeableConcept jurisdiction;

            private Builder() {
            }

            private Builder(LegalStatusOfSupply original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
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
             * Sets {@code code}.
             *
             * @param code the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder code(CodeableConcept code) {
                this.code = code;
                return this;
            }

            /**
             * Sets {@code jurisdiction}.
             *
             * @param jurisdiction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder jurisdiction(CodeableConcept jurisdiction) {
                this.jurisdiction = jurisdiction;
                return this;
            }

            /**
             * Builds the {@code LegalStatusOfSupply}.
             *
             * @return the {@code LegalStatusOfSupply}
             */
            public LegalStatusOfSupply build() {
                return new LegalStatusOfSupply(
                        id, extension, modifierExtension, code, jurisdiction);
            }
        }
    }

    /**
     * A packaging item, as a container for medically related items, possibly with other packaging items within, or a
     * packaging component, such as bottle cap (which is not a device or a medication manufactured item).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier An identifier that is specific to this particular part of the packaging. Including possibly a
     *   Data Carrier Identifier.
     * @param type The physical type of the container of the items.
     * @param componentPart Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging
     *   itself (e.g. a bottle or vial).
     * @param quantity The quantity of this level of packaging in the package that contains it (with the outermost
     *   level being 1).
     * @param material Material type of the package item.
     * @param alternateMaterial A possible alternate material for this part of the packaging, that is allowed to be
     *   used instead of the usual material.
     * @param shelfLifeStorage Shelf Life and storage information.
     * @param manufacturer Manufacturer of this packaging item (multiple means these are all potential manufacturers).
     *   Reference to Organization.
     * @param property General characteristics of this item.
     * @param containedItem The item(s) within the packaging.
     * @param packaging Allows containers (and parts of containers) within containers, still as a part of single
     *   packaged product.
     */
    public record Packaging(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Identifier> identifier,
            CodeableConcept type,
            FhirBoolean componentPart,
            FhirInteger quantity,
            List<CodeableConcept> material,
            List<CodeableConcept> alternateMaterial,
            List<ProductShelfLife> shelfLifeStorage,
            List<Reference> manufacturer,
            List<Property> property,
            List<ContainedItem> containedItem,
            List<PackagedProductDefinition.Packaging> packaging) implements BackboneElement {

        /**
         * Creates a {@code Packaging}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Packaging {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            identifier = identifier == null ? List.of() : List.copyOf(identifier);
            material = material == null ? List.of() : List.copyOf(material);
            alternateMaterial = alternateMaterial == null ? List.of() : List.copyOf(alternateMaterial);
            shelfLifeStorage = shelfLifeStorage == null ? List.of() : List.copyOf(shelfLifeStorage);
            manufacturer = manufacturer == null ? List.of() : List.copyOf(manufacturer);
            property = property == null ? List.of() : List.copyOf(property);
            containedItem = containedItem == null ? List.of() : List.copyOf(containedItem);
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
         * General characteristics of this item.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type A code expressing the type of characteristic. Required.
         * @param value A value for the characteristic. One of CodeableConcept, Quantity, date, boolean, Attachment.
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
                Objects.requireNonNull(type, "PackagedProductDefinition.packaging.property.type is required");
                if (value != null && !(value instanceof CodeableConcept
                        || value instanceof Quantity
                        || value instanceof FhirDate
                        || value instanceof FhirBoolean
                        || value instanceof Attachment)) {
                    throw new IllegalArgumentException(
                            "PackagedProductDefinition.packaging.property.value[x] does not allow "
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
                 * Sets {@code value} to a date.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirDate value) {
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
                 * Sets {@code value} to a date without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Temporal value) {
                    this.value = value == null ? null : FhirDate.of(value);
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
         * The item(s) within the packaging.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param item The actual item(s) of medication, as manufactured, or a device, or other medically related item
         *   (food, biologicals, raw materials, medical fluids, gases etc.), as contained in the package. Required.
         * @param amount The number of this type of item within this packaging or for continuous items such as liquids
         *   it is the quantity (for example 25ml). See also PackagedProductDefinition.containedItemQuantity
         *   (especially the long definition).
         */
        public record ContainedItem(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableReference item,
                Quantity amount) implements BackboneElement {

            /**
             * Creates a {@code ContainedItem}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public ContainedItem {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(item, "PackagedProductDefinition.packaging.containedItem.item is required");
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
             * Returns a builder initialized with the values of this {@code ContainedItem}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link ContainedItem}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableReference item;
                private Quantity amount;

                private Builder() {
                }

                private Builder(ContainedItem original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.item = original.item();
                    this.amount = original.amount();
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
                 * Sets {@code item}.
                 *
                 * @param item the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder item(CodeableReference item) {
                    this.item = item;
                    return this;
                }

                /**
                 * Sets {@code amount}.
                 *
                 * @param amount the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder amount(Quantity amount) {
                    this.amount = amount;
                    return this;
                }

                /**
                 * Builds the {@code ContainedItem}.
                 *
                 * @return the {@code ContainedItem}
                 * @throws NullPointerException if a required element is absent
                 */
                public ContainedItem build() {
                    return new ContainedItem(
                            id, extension, modifierExtension, item, amount);
                }
            }
        }

        /** Builder for {@link Packaging}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Identifier> identifier = new ArrayList<>();
            private CodeableConcept type;
            private FhirBoolean componentPart;
            private FhirInteger quantity;
            private List<CodeableConcept> material = new ArrayList<>();
            private List<CodeableConcept> alternateMaterial = new ArrayList<>();
            private List<ProductShelfLife> shelfLifeStorage = new ArrayList<>();
            private List<Reference> manufacturer = new ArrayList<>();
            private List<Property> property = new ArrayList<>();
            private List<ContainedItem> containedItem = new ArrayList<>();
            private List<PackagedProductDefinition.Packaging> packaging = new ArrayList<>();

            private Builder() {
            }

            private Builder(Packaging original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = new ArrayList<>(original.identifier());
                this.type = original.type();
                this.componentPart = original.componentPart();
                this.quantity = original.quantity();
                this.material = new ArrayList<>(original.material());
                this.alternateMaterial = new ArrayList<>(original.alternateMaterial());
                this.shelfLifeStorage = new ArrayList<>(original.shelfLifeStorage());
                this.manufacturer = new ArrayList<>(original.manufacturer());
                this.property = new ArrayList<>(original.property());
                this.containedItem = new ArrayList<>(original.containedItem());
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
             * Sets {@code componentPart}.
             *
             * @param componentPart the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder componentPart(FhirBoolean componentPart) {
                this.componentPart = componentPart;
                return this;
            }

            /**
             * Sets {@code componentPart}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param componentPart the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder componentPart(Boolean componentPart) {
                return componentPart(componentPart == null ? null : FhirBoolean.of(componentPart));
            }

            /**
             * Sets {@code quantity}.
             *
             * @param quantity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder quantity(FhirInteger quantity) {
                this.quantity = quantity;
                return this;
            }

            /**
             * Sets {@code quantity}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param quantity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder quantity(Integer quantity) {
                return quantity(quantity == null ? null : FhirInteger.of(quantity));
            }

            /**
             * Replaces all {@code material} values.
             *
             * @param material the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder material(List<CodeableConcept> material) {
                this.material = material == null ? new ArrayList<>() : new ArrayList<>(material);
                return this;
            }

            /**
             * Adds a {@code material} value.
             *
             * @param material the value to add
             * @return this builder
             */
            public Builder addMaterial(CodeableConcept material) {
                this.material.add(Objects.requireNonNull(material, "material"));
                return this;
            }

            /**
             * Replaces all {@code alternateMaterial} values.
             *
             * @param alternateMaterial the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder alternateMaterial(List<CodeableConcept> alternateMaterial) {
                this.alternateMaterial = alternateMaterial == null
                        ? new ArrayList<>()
                        : new ArrayList<>(alternateMaterial);
                return this;
            }

            /**
             * Adds a {@code alternateMaterial} value.
             *
             * @param alternateMaterial the value to add
             * @return this builder
             */
            public Builder addAlternateMaterial(CodeableConcept alternateMaterial) {
                this.alternateMaterial.add(Objects.requireNonNull(alternateMaterial, "alternateMaterial"));
                return this;
            }

            /**
             * Replaces all {@code shelfLifeStorage} values.
             *
             * @param shelfLifeStorage the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder shelfLifeStorage(List<ProductShelfLife> shelfLifeStorage) {
                this.shelfLifeStorage = shelfLifeStorage == null
                        ? new ArrayList<>()
                        : new ArrayList<>(shelfLifeStorage);
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
             * Replaces all {@code manufacturer} values.
             *
             * @param manufacturer the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder manufacturer(List<Reference> manufacturer) {
                this.manufacturer = manufacturer == null ? new ArrayList<>() : new ArrayList<>(manufacturer);
                return this;
            }

            /**
             * Adds a {@code manufacturer} value.
             *
             * @param manufacturer the value to add
             * @return this builder
             */
            public Builder addManufacturer(Reference manufacturer) {
                this.manufacturer.add(Objects.requireNonNull(manufacturer, "manufacturer"));
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
             * Replaces all {@code containedItem} values.
             *
             * @param containedItem the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder containedItem(List<ContainedItem> containedItem) {
                this.containedItem = containedItem == null ? new ArrayList<>() : new ArrayList<>(containedItem);
                return this;
            }

            /**
             * Adds a {@code containedItem} value.
             *
             * @param containedItem the value to add
             * @return this builder
             */
            public Builder addContainedItem(ContainedItem containedItem) {
                this.containedItem.add(Objects.requireNonNull(containedItem, "containedItem"));
                return this;
            }

            /**
             * Replaces all {@code packaging} values.
             *
             * @param packaging the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder packaging(List<PackagedProductDefinition.Packaging> packaging) {
                this.packaging = packaging == null ? new ArrayList<>() : new ArrayList<>(packaging);
                return this;
            }

            /**
             * Adds a {@code packaging} value.
             *
             * @param packaging the value to add
             * @return this builder
             */
            public Builder addPackaging(PackagedProductDefinition.Packaging packaging) {
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
                        id, extension, modifierExtension, identifier, type, componentPart, quantity, material,
                        alternateMaterial, shelfLifeStorage, manufacturer, property, containedItem, packaging);
            }
        }
    }

    /** Builder for {@link PackagedProductDefinition}. Builders are mutable and not thread-safe. */
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
        private FhirString name;
        private CodeableConcept type;
        private List<Reference> packageFor = new ArrayList<>();
        private CodeableConcept status;
        private FhirDateTime statusDate;
        private List<Quantity> containedItemQuantity = new ArrayList<>();
        private FhirMarkdown description;
        private List<LegalStatusOfSupply> legalStatusOfSupply = new ArrayList<>();
        private List<MarketingStatus> marketingStatus = new ArrayList<>();
        private FhirBoolean copackagedIndicator;
        private List<Reference> manufacturer = new ArrayList<>();
        private List<Reference> attachedDocument = new ArrayList<>();
        private Packaging packaging;
        private List<PackagedProductDefinition.Packaging.Property> characteristic = new ArrayList<>();

        private Builder() {
        }

        private Builder(PackagedProductDefinition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.name = original.name();
            this.type = original.type();
            this.packageFor = new ArrayList<>(original.packageFor());
            this.status = original.status();
            this.statusDate = original.statusDate();
            this.containedItemQuantity = new ArrayList<>(original.containedItemQuantity());
            this.description = original.description();
            this.legalStatusOfSupply = new ArrayList<>(original.legalStatusOfSupply());
            this.marketingStatus = new ArrayList<>(original.marketingStatus());
            this.copackagedIndicator = original.copackagedIndicator();
            this.manufacturer = new ArrayList<>(original.manufacturer());
            this.attachedDocument = new ArrayList<>(original.attachedDocument());
            this.packaging = original.packaging();
            this.characteristic = new ArrayList<>(original.characteristic());
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
        public Builder type(CodeableConcept type) {
            this.type = type;
            return this;
        }

        /**
         * Replaces all {@code packageFor} values.
         *
         * @param packageFor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder packageFor(List<Reference> packageFor) {
            this.packageFor = packageFor == null ? new ArrayList<>() : new ArrayList<>(packageFor);
            return this;
        }

        /**
         * Adds a {@code packageFor} value.
         *
         * @param packageFor the value to add
         * @return this builder
         */
        public Builder addPackageFor(Reference packageFor) {
            this.packageFor.add(Objects.requireNonNull(packageFor, "packageFor"));
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(CodeableConcept status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code statusDate}.
         *
         * @param statusDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusDate(FhirDateTime statusDate) {
            this.statusDate = statusDate;
            return this;
        }

        /**
         * Sets {@code statusDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param statusDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusDate(Temporal statusDate) {
            return statusDate(statusDate == null ? null : FhirDateTime.of(statusDate));
        }

        /**
         * Replaces all {@code containedItemQuantity} values.
         *
         * @param containedItemQuantity the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder containedItemQuantity(List<Quantity> containedItemQuantity) {
            this.containedItemQuantity = containedItemQuantity == null
                    ? new ArrayList<>()
                    : new ArrayList<>(containedItemQuantity);
            return this;
        }

        /**
         * Adds a {@code containedItemQuantity} value.
         *
         * @param containedItemQuantity the value to add
         * @return this builder
         */
        public Builder addContainedItemQuantity(Quantity containedItemQuantity) {
            this.containedItemQuantity.add(Objects.requireNonNull(containedItemQuantity, "containedItemQuantity"));
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
         * Replaces all {@code legalStatusOfSupply} values.
         *
         * @param legalStatusOfSupply the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder legalStatusOfSupply(List<LegalStatusOfSupply> legalStatusOfSupply) {
            this.legalStatusOfSupply = legalStatusOfSupply == null
                    ? new ArrayList<>()
                    : new ArrayList<>(legalStatusOfSupply);
            return this;
        }

        /**
         * Adds a {@code legalStatusOfSupply} value.
         *
         * @param legalStatusOfSupply the value to add
         * @return this builder
         */
        public Builder addLegalStatusOfSupply(LegalStatusOfSupply legalStatusOfSupply) {
            this.legalStatusOfSupply.add(Objects.requireNonNull(legalStatusOfSupply, "legalStatusOfSupply"));
            return this;
        }

        /**
         * Replaces all {@code marketingStatus} values.
         *
         * @param marketingStatus the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder marketingStatus(List<MarketingStatus> marketingStatus) {
            this.marketingStatus = marketingStatus == null ? new ArrayList<>() : new ArrayList<>(marketingStatus);
            return this;
        }

        /**
         * Adds a {@code marketingStatus} value.
         *
         * @param marketingStatus the value to add
         * @return this builder
         */
        public Builder addMarketingStatus(MarketingStatus marketingStatus) {
            this.marketingStatus.add(Objects.requireNonNull(marketingStatus, "marketingStatus"));
            return this;
        }

        /**
         * Sets {@code copackagedIndicator}.
         *
         * @param copackagedIndicator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copackagedIndicator(FhirBoolean copackagedIndicator) {
            this.copackagedIndicator = copackagedIndicator;
            return this;
        }

        /**
         * Sets {@code copackagedIndicator}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param copackagedIndicator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copackagedIndicator(Boolean copackagedIndicator) {
            return copackagedIndicator(copackagedIndicator == null ? null : FhirBoolean.of(copackagedIndicator));
        }

        /**
         * Replaces all {@code manufacturer} values.
         *
         * @param manufacturer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder manufacturer(List<Reference> manufacturer) {
            this.manufacturer = manufacturer == null ? new ArrayList<>() : new ArrayList<>(manufacturer);
            return this;
        }

        /**
         * Adds a {@code manufacturer} value.
         *
         * @param manufacturer the value to add
         * @return this builder
         */
        public Builder addManufacturer(Reference manufacturer) {
            this.manufacturer.add(Objects.requireNonNull(manufacturer, "manufacturer"));
            return this;
        }

        /**
         * Replaces all {@code attachedDocument} values.
         *
         * @param attachedDocument the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder attachedDocument(List<Reference> attachedDocument) {
            this.attachedDocument = attachedDocument == null ? new ArrayList<>() : new ArrayList<>(attachedDocument);
            return this;
        }

        /**
         * Adds a {@code attachedDocument} value.
         *
         * @param attachedDocument the value to add
         * @return this builder
         */
        public Builder addAttachedDocument(Reference attachedDocument) {
            this.attachedDocument.add(Objects.requireNonNull(attachedDocument, "attachedDocument"));
            return this;
        }

        /**
         * Sets {@code packaging}.
         *
         * @param packaging the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder packaging(Packaging packaging) {
            this.packaging = packaging;
            return this;
        }

        /**
         * Replaces all {@code characteristic} values.
         *
         * @param characteristic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder characteristic(List<PackagedProductDefinition.Packaging.Property> characteristic) {
            this.characteristic = characteristic == null ? new ArrayList<>() : new ArrayList<>(characteristic);
            return this;
        }

        /**
         * Adds a {@code characteristic} value.
         *
         * @param characteristic the value to add
         * @return this builder
         */
        public Builder addCharacteristic(PackagedProductDefinition.Packaging.Property characteristic) {
            this.characteristic.add(Objects.requireNonNull(characteristic, "characteristic"));
            return this;
        }

        /**
         * Builds the {@code PackagedProductDefinition}.
         *
         * @return the {@code PackagedProductDefinition}
         */
        public PackagedProductDefinition build() {
            return new PackagedProductDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    name, type, packageFor, status, statusDate, containedItemQuantity, description,
                    legalStatusOfSupply, marketingStatus, copackagedIndicator, manufacturer, attachedDocument,
                    packaging, characteristic);
        }
    }
}
