package se.poroli.fhirplace.r5.nutritionproduct;

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
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * A food or supplement that is consumed by patients.
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
 * @param code A code that can identify the detailed nutrients and ingredients in a specific food product.
 * @param status active | inactive | entered-in-error. Required. Modifier element.
 * @param category Broad product groups or categories used to classify the product, such as Legume and Legume
 *   Products, Beverages, or Beef Products.
 * @param manufacturer Manufacturer, representative or officially responsible for the product. Reference to
 *   Organization.
 * @param nutrient The product's nutritional information expressed by the nutrients.
 * @param ingredient Ingredients contained in this product.
 * @param knownAllergen Known or suspected allergens that are a part of this product.
 * @param characteristic Specifies descriptive properties of the nutrition product.
 * @param instance One or several physical instances or occurrences of the nutrition product.
 * @param note Comments made about the product.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/NutritionProduct">FHIR R5 NutritionProduct</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record NutritionProduct(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        CodeableConcept code,
        FhirEnum<NutritionProductStatus> status,
        List<CodeableConcept> category,
        List<Reference> manufacturer,
        List<Nutrient> nutrient,
        List<Ingredient> ingredient,
        List<CodeableReference> knownAllergen,
        List<Characteristic> characteristic,
        List<Instance> instance,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates a {@code NutritionProduct}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public NutritionProduct {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        category = category == null ? List.of() : List.copyOf(category);
        manufacturer = manufacturer == null ? List.of() : List.copyOf(manufacturer);
        nutrient = nutrient == null ? List.of() : List.copyOf(nutrient);
        ingredient = ingredient == null ? List.of() : List.copyOf(ingredient);
        knownAllergen = knownAllergen == null ? List.of() : List.copyOf(knownAllergen);
        characteristic = characteristic == null ? List.of() : List.copyOf(characteristic);
        instance = instance == null ? List.of() : List.copyOf(instance);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "NutritionProduct.status is required");
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
     * Returns a builder initialized with the values of this {@code NutritionProduct}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The product's nutritional information expressed by the nutrients.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param item The (relevant) nutrients in the product.
     * @param amount The amount of nutrient expressed in one or more units: X per pack / per serving / per dose.
     */
    public record Nutrient(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference item,
            List<Ratio> amount) implements BackboneElement {

        /**
         * Creates a {@code Nutrient}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Nutrient {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            amount = amount == null ? List.of() : List.copyOf(amount);
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
         * Returns a builder initialized with the values of this {@code Nutrient}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Nutrient}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference item;
            private List<Ratio> amount = new ArrayList<>();

            private Builder() {
            }

            private Builder(Nutrient original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.item = original.item();
                this.amount = new ArrayList<>(original.amount());
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
             * Replaces all {@code amount} values.
             *
             * @param amount the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder amount(List<Ratio> amount) {
                this.amount = amount == null ? new ArrayList<>() : new ArrayList<>(amount);
                return this;
            }

            /**
             * Adds a {@code amount} value.
             *
             * @param amount the value to add
             * @return this builder
             */
            public Builder addAmount(Ratio amount) {
                this.amount.add(Objects.requireNonNull(amount, "amount"));
                return this;
            }

            /**
             * Builds the {@code Nutrient}.
             *
             * @return the {@code Nutrient}
             */
            public Nutrient build() {
                return new Nutrient(
                        id, extension, modifierExtension, item, amount);
            }
        }
    }

    /**
     * Ingredients contained in this product.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param item The ingredient contained in the product. Required.
     * @param amount The amount of ingredient that is in the product.
     */
    public record Ingredient(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference item,
            List<Ratio> amount) implements BackboneElement {

        /**
         * Creates an {@code Ingredient}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Ingredient {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            amount = amount == null ? List.of() : List.copyOf(amount);
            Objects.requireNonNull(item, "NutritionProduct.ingredient.item is required");
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
         * Returns a builder initialized with the values of this {@code Ingredient}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Ingredient}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference item;
            private List<Ratio> amount = new ArrayList<>();

            private Builder() {
            }

            private Builder(Ingredient original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.item = original.item();
                this.amount = new ArrayList<>(original.amount());
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
             * Replaces all {@code amount} values.
             *
             * @param amount the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder amount(List<Ratio> amount) {
                this.amount = amount == null ? new ArrayList<>() : new ArrayList<>(amount);
                return this;
            }

            /**
             * Adds a {@code amount} value.
             *
             * @param amount the value to add
             * @return this builder
             */
            public Builder addAmount(Ratio amount) {
                this.amount.add(Objects.requireNonNull(amount, "amount"));
                return this;
            }

            /**
             * Builds the {@code Ingredient}.
             *
             * @return the {@code Ingredient}
             * @throws NullPointerException if a required element is absent
             */
            public Ingredient build() {
                return new Ingredient(
                        id, extension, modifierExtension, item, amount);
            }
        }
    }

    /**
     * Specifies descriptive properties of the nutrition product.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Code specifying the type of characteristic. Required.
     * @param value The value of the characteristic. One of CodeableConcept, string, Quantity, base64Binary,
     *   Attachment, boolean. Required.
     */
    public record Characteristic(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
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
            Objects.requireNonNull(type, "NutritionProduct.characteristic.type is required");
            Objects.requireNonNull(value, "NutritionProduct.characteristic.value is required");
            if (value != null && !(value instanceof CodeableConcept
                    || value instanceof FhirString
                    || value instanceof Quantity
                    || value instanceof FhirBase64Binary
                    || value instanceof Attachment
                    || value instanceof FhirBoolean)) {
                throw new IllegalArgumentException(
                        "NutritionProduct.characteristic.value[x] does not allow "
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
            private CodeableConcept type;
            private DataType value;

            private Builder() {
            }

            private Builder(Characteristic original) {
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
             * Sets {@code value} to a base64Binary.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirBase64Binary value) {
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
             * Builds the {@code Characteristic}.
             *
             * @return the {@code Characteristic}
             * @throws NullPointerException if a required element is absent
             */
            public Characteristic build() {
                return new Characteristic(
                        id, extension, modifierExtension, type, value);
            }
        }
    }

    /**
     * Conveys instance-level information about this product item.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param quantity The amount of items or instances.
     * @param identifier The identifier for the physical instance, typically a serial number or manufacturer number.
     * @param name The name for the specific product.
     * @param lotNumber The identification of the batch or lot of the product.
     * @param expiry The expiry date or date and time for the product.
     * @param useBy The date until which the product is expected to be good for consumption.
     * @param biologicalSourceEvent An identifier that supports traceability to the event during which material in
     *   this product from one or more biological entities was obtained or pooled.
     */
    public record Instance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Quantity quantity,
            List<Identifier> identifier,
            FhirString name,
            FhirString lotNumber,
            FhirDateTime expiry,
            FhirDateTime useBy,
            Identifier biologicalSourceEvent) implements BackboneElement {

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
            private Quantity quantity;
            private List<Identifier> identifier = new ArrayList<>();
            private FhirString name;
            private FhirString lotNumber;
            private FhirDateTime expiry;
            private FhirDateTime useBy;
            private Identifier biologicalSourceEvent;

            private Builder() {
            }

            private Builder(Instance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.quantity = original.quantity();
                this.identifier = new ArrayList<>(original.identifier());
                this.name = original.name();
                this.lotNumber = original.lotNumber();
                this.expiry = original.expiry();
                this.useBy = original.useBy();
                this.biologicalSourceEvent = original.biologicalSourceEvent();
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
             * Sets {@code quantity}.
             *
             * @param quantity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder quantity(Quantity quantity) {
                this.quantity = quantity;
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
             * Sets {@code useBy}.
             *
             * @param useBy the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder useBy(FhirDateTime useBy) {
                this.useBy = useBy;
                return this;
            }

            /**
             * Sets {@code useBy}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param useBy the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder useBy(Temporal useBy) {
                return useBy(useBy == null ? null : FhirDateTime.of(useBy));
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
             * Builds the {@code Instance}.
             *
             * @return the {@code Instance}
             */
            public Instance build() {
                return new Instance(
                        id, extension, modifierExtension, quantity, identifier, name, lotNumber, expiry, useBy,
                        biologicalSourceEvent);
            }
        }
    }

    /** Builder for {@link NutritionProduct}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private CodeableConcept code;
        private FhirEnum<NutritionProductStatus> status;
        private List<CodeableConcept> category = new ArrayList<>();
        private List<Reference> manufacturer = new ArrayList<>();
        private List<Nutrient> nutrient = new ArrayList<>();
        private List<Ingredient> ingredient = new ArrayList<>();
        private List<CodeableReference> knownAllergen = new ArrayList<>();
        private List<Characteristic> characteristic = new ArrayList<>();
        private List<Instance> instance = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(NutritionProduct original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.code = original.code();
            this.status = original.status();
            this.category = new ArrayList<>(original.category());
            this.manufacturer = new ArrayList<>(original.manufacturer());
            this.nutrient = new ArrayList<>(original.nutrient());
            this.ingredient = new ArrayList<>(original.ingredient());
            this.knownAllergen = new ArrayList<>(original.knownAllergen());
            this.characteristic = new ArrayList<>(original.characteristic());
            this.instance = new ArrayList<>(original.instance());
            this.note = new ArrayList<>(original.note());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<NutritionProductStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(NutritionProductStatus status) {
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
         * Replaces all {@code nutrient} values.
         *
         * @param nutrient the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder nutrient(List<Nutrient> nutrient) {
            this.nutrient = nutrient == null ? new ArrayList<>() : new ArrayList<>(nutrient);
            return this;
        }

        /**
         * Adds a {@code nutrient} value.
         *
         * @param nutrient the value to add
         * @return this builder
         */
        public Builder addNutrient(Nutrient nutrient) {
            this.nutrient.add(Objects.requireNonNull(nutrient, "nutrient"));
            return this;
        }

        /**
         * Replaces all {@code ingredient} values.
         *
         * @param ingredient the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder ingredient(List<Ingredient> ingredient) {
            this.ingredient = ingredient == null ? new ArrayList<>() : new ArrayList<>(ingredient);
            return this;
        }

        /**
         * Adds a {@code ingredient} value.
         *
         * @param ingredient the value to add
         * @return this builder
         */
        public Builder addIngredient(Ingredient ingredient) {
            this.ingredient.add(Objects.requireNonNull(ingredient, "ingredient"));
            return this;
        }

        /**
         * Replaces all {@code knownAllergen} values.
         *
         * @param knownAllergen the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder knownAllergen(List<CodeableReference> knownAllergen) {
            this.knownAllergen = knownAllergen == null ? new ArrayList<>() : new ArrayList<>(knownAllergen);
            return this;
        }

        /**
         * Adds a {@code knownAllergen} value.
         *
         * @param knownAllergen the value to add
         * @return this builder
         */
        public Builder addKnownAllergen(CodeableReference knownAllergen) {
            this.knownAllergen.add(Objects.requireNonNull(knownAllergen, "knownAllergen"));
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
         * Replaces all {@code instance} values.
         *
         * @param instance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder instance(List<Instance> instance) {
            this.instance = instance == null ? new ArrayList<>() : new ArrayList<>(instance);
            return this;
        }

        /**
         * Adds a {@code instance} value.
         *
         * @param instance the value to add
         * @return this builder
         */
        public Builder addInstance(Instance instance) {
            this.instance.add(Objects.requireNonNull(instance, "instance"));
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
         * Builds the {@code NutritionProduct}.
         *
         * @return the {@code NutritionProduct}
         * @throws NullPointerException if a required element is absent
         */
        public NutritionProduct build() {
            return new NutritionProduct(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, code, status,
                    category, manufacturer, nutrient, ingredient, knownAllergen, characteristic, instance, note);
        }
    }
}
