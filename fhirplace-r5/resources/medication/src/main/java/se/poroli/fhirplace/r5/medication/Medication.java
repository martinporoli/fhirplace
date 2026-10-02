package se.poroli.fhirplace.r5.medication;

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
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
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
 * This resource is primarily used for the identification and definition of a medication, including ingredients, for
 * the purposes of prescribing, dispensing, and administering a medication as well as for making statements about
 * medication use.
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
 * @param identifier Business identifier for this medication.
 * @param code Codes that identify this medication.
 * @param status active | inactive | entered-in-error. Modifier element.
 * @param marketingAuthorizationHolder Organization that has authorization to market medication. Reference to
 *   Organization.
 * @param doseForm powder | tablets | capsule +.
 * @param totalVolume When the specified product code does not infer a package size, this is the specific amount of
 *   drug in the product.
 * @param ingredient Active or inactive ingredient.
 * @param batch Details about packaged medications.
 * @param definition Knowledge about this medication. Reference to MedicationKnowledge.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Medication">FHIR R5 Medication</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Medication(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        CodeableConcept code,
        FhirEnum<MedicationStatusCodes> status,
        Reference marketingAuthorizationHolder,
        CodeableConcept doseForm,
        Quantity totalVolume,
        List<Ingredient> ingredient,
        Batch batch,
        Reference definition) implements DomainResource {

    /**
     * Creates a {@code Medication}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Medication {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        ingredient = ingredient == null ? List.of() : List.copyOf(ingredient);
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
     * Returns a builder initialized with the values of this {@code Medication}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Identifies a particular constituent of interest in the product.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param item The ingredient (substance or medication) that the ingredient.strength relates to. Required.
     * @param isActive Active ingredient indicator.
     * @param strength Quantity of ingredient present. One of Ratio, CodeableConcept, Quantity.
     */
    public record Ingredient(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference item,
            FhirBoolean isActive,
            DataType strength) implements BackboneElement {

        /**
         * Creates an {@code Ingredient}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Ingredient {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(item, "Medication.ingredient.item is required");
            if (strength != null && !(strength instanceof Ratio
                    || strength instanceof CodeableConcept
                    || strength instanceof Quantity)) {
                throw new IllegalArgumentException(
                        "Medication.ingredient.strength[x] must be one of Ratio, CodeableConcept, Quantity, but was "
                                + strength.getClass().getSimpleName());
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
            private FhirBoolean isActive;
            private DataType strength;

            private Builder() {
            }

            private Builder(Ingredient original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.item = original.item();
                this.isActive = original.isActive();
                this.strength = original.strength();
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
             * Sets {@code isActive}.
             *
             * @param isActive the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder isActive(FhirBoolean isActive) {
                this.isActive = isActive;
                return this;
            }

            /**
             * Sets {@code isActive}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param isActive the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder isActive(Boolean isActive) {
                return isActive(isActive == null ? null : FhirBoolean.of(isActive));
            }

            /**
             * Sets {@code strength} to a Ratio.
             *
             * @param strength the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder strength(Ratio strength) {
                this.strength = strength;
                return this;
            }

            /**
             * Sets {@code strength} to a CodeableConcept.
             *
             * @param strength the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder strength(CodeableConcept strength) {
                this.strength = strength;
                return this;
            }

            /**
             * Sets {@code strength} to a Quantity.
             *
             * @param strength the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder strength(Quantity strength) {
                this.strength = strength;
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
                        id, extension, modifierExtension, item, isActive, strength);
            }
        }
    }

    /**
     * Information that only applies to packages (not products).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param lotNumber Identifier assigned to batch.
     * @param expirationDate When batch will expire.
     */
    public record Batch(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString lotNumber,
            FhirDateTime expirationDate) implements BackboneElement {

        /**
         * Creates a {@code Batch}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Batch {
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
         * Returns a builder initialized with the values of this {@code Batch}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Batch}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString lotNumber;
            private FhirDateTime expirationDate;

            private Builder() {
            }

            private Builder(Batch original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.lotNumber = original.lotNumber();
                this.expirationDate = original.expirationDate();
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
             * Builds the {@code Batch}.
             *
             * @return the {@code Batch}
             */
            public Batch build() {
                return new Batch(
                        id, extension, modifierExtension, lotNumber, expirationDate);
            }
        }
    }

    /** Builder for {@link Medication}. Builders are mutable and not thread-safe. */
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
        private CodeableConcept code;
        private FhirEnum<MedicationStatusCodes> status;
        private Reference marketingAuthorizationHolder;
        private CodeableConcept doseForm;
        private Quantity totalVolume;
        private List<Ingredient> ingredient = new ArrayList<>();
        private Batch batch;
        private Reference definition;

        private Builder() {
        }

        private Builder(Medication original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.code = original.code();
            this.status = original.status();
            this.marketingAuthorizationHolder = original.marketingAuthorizationHolder();
            this.doseForm = original.doseForm();
            this.totalVolume = original.totalVolume();
            this.ingredient = new ArrayList<>(original.ingredient());
            this.batch = original.batch();
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
        public Builder status(FhirEnum<MedicationStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(MedicationStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code marketingAuthorizationHolder}.
         *
         * @param marketingAuthorizationHolder the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder marketingAuthorizationHolder(Reference marketingAuthorizationHolder) {
            this.marketingAuthorizationHolder = marketingAuthorizationHolder;
            return this;
        }

        /**
         * Sets {@code doseForm}.
         *
         * @param doseForm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder doseForm(CodeableConcept doseForm) {
            this.doseForm = doseForm;
            return this;
        }

        /**
         * Sets {@code totalVolume}.
         *
         * @param totalVolume the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder totalVolume(Quantity totalVolume) {
            this.totalVolume = totalVolume;
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
         * Sets {@code batch}.
         *
         * @param batch the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder batch(Batch batch) {
            this.batch = batch;
            return this;
        }

        /**
         * Sets {@code definition}.
         *
         * @param definition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder definition(Reference definition) {
            this.definition = definition;
            return this;
        }

        /**
         * Builds the {@code Medication}.
         *
         * @return the {@code Medication}
         */
        public Medication build() {
            return new Medication(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    code, status, marketingAuthorizationHolder, doseForm, totalVolume, ingredient, batch, definition);
        }
    }
}
