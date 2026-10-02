package se.poroli.fhirplace.r5.nutritionintake;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.valuesets.EventStatus;

/**
 * A record of food or fluid that is being consumed by a patient.
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
 * @param identifier External identifier.
 * @param instantiatesCanonical Instantiates FHIR protocol or definition. Canonical reference to ActivityDefinition,
 *   ChargeItemDefinition, ClinicalUseDefinition, EventDefinition, Measure, MessageDefinition, ObservationDefinition,
 *   OperationDefinition, PlanDefinition, Questionnaire, Requirements, SubscriptionTopic, TestPlan, TestScript.
 * @param instantiatesUri Instantiates external protocol or definition.
 * @param basedOn Fulfils plan, proposal or order. Reference to NutritionOrder, CarePlan, ServiceRequest.
 * @param partOf Part of referenced event. Reference to NutritionIntake, Procedure, Observation.
 * @param status preparation | in-progress | not-done | on-hold | stopped | completed | entered-in-error | unknown.
 *   Required. Modifier element.
 * @param statusReason Reason for current status.
 * @param code Code representing an overall type of nutrition intake.
 * @param subject Who is/was consuming the food or fluid. Reference to Patient, Group. Required.
 * @param encounter Encounter associated with NutritionIntake. Reference to Encounter.
 * @param occurrence The date/time or interval when the food or fluid is/was consumed. One of dateTime, Period.
 * @param recorded When the intake was recorded.
 * @param reported Person or organization that provided the information about the consumption of this food or fluid.
 *   One of boolean, Reference.
 * @param consumedItem What food or fluid product or item was consumed. Required.
 * @param ingredientLabel Total nutrient for the whole meal, product, serving.
 * @param performer Who was performed in the intake.
 * @param location Where the intake occurred. Reference to Location.
 * @param derivedFrom Additional supporting information. Reference to Resource.
 * @param reason Reason for why the food or fluid is /was consumed.
 * @param note Further information about the consumption.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/NutritionIntake">FHIR R5 NutritionIntake</a>
 */
public record NutritionIntake(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        List<FhirCanonical> instantiatesCanonical,
        List<FhirUri> instantiatesUri,
        List<Reference> basedOn,
        List<Reference> partOf,
        FhirEnum<EventStatus> status,
        List<CodeableConcept> statusReason,
        CodeableConcept code,
        Reference subject,
        Reference encounter,
        DataType occurrence,
        FhirDateTime recorded,
        DataType reported,
        List<ConsumedItem> consumedItem,
        List<IngredientLabel> ingredientLabel,
        List<Performer> performer,
        Reference location,
        List<Reference> derivedFrom,
        List<CodeableReference> reason,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates a {@code NutritionIntake}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public NutritionIntake {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        instantiatesCanonical = instantiatesCanonical == null ? List.of() : List.copyOf(instantiatesCanonical);
        instantiatesUri = instantiatesUri == null ? List.of() : List.copyOf(instantiatesUri);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        statusReason = statusReason == null ? List.of() : List.copyOf(statusReason);
        consumedItem = consumedItem == null ? List.of() : List.copyOf(consumedItem);
        ingredientLabel = ingredientLabel == null ? List.of() : List.copyOf(ingredientLabel);
        performer = performer == null ? List.of() : List.copyOf(performer);
        derivedFrom = derivedFrom == null ? List.of() : List.copyOf(derivedFrom);
        reason = reason == null ? List.of() : List.copyOf(reason);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "NutritionIntake.status is required");
        Objects.requireNonNull(subject, "NutritionIntake.subject is required");
        if (consumedItem.isEmpty()) {
            throw new IllegalArgumentException("NutritionIntake.consumedItem requires at least one value");
        }
        if (occurrence != null && !(occurrence instanceof FhirDateTime || occurrence instanceof Period)) {
            throw new IllegalArgumentException(
                    "NutritionIntake.occurrence[x] must be one of dateTime, Period, but was "
                            + occurrence.getClass().getSimpleName());
        }
        if (reported != null && !(reported instanceof FhirBoolean || reported instanceof Reference)) {
            throw new IllegalArgumentException(
                    "NutritionIntake.reported[x] must be one of boolean, Reference, but was "
                            + reported.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code NutritionIntake}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * What food or fluid product or item was consumed.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type The type of food or fluid product. Required.
     * @param nutritionProduct Code that identifies the food or fluid product that was consumed. Required.
     * @param schedule Scheduled frequency of consumption.
     * @param amount Quantity of the specified food.
     * @param rate Rate at which enteral feeding was administered.
     * @param notConsumed Flag to indicate if the food or fluid item was refused or otherwise not consumed.
     * @param notConsumedReason Reason food or fluid was not consumed.
     */
    public record ConsumedItem(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            CodeableReference nutritionProduct,
            Timing schedule,
            Quantity amount,
            Quantity rate,
            FhirBoolean notConsumed,
            CodeableConcept notConsumedReason) implements BackboneElement {

        /**
         * Creates a {@code ConsumedItem}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ConsumedItem {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "NutritionIntake.consumedItem.type is required");
            Objects.requireNonNull(nutritionProduct, "NutritionIntake.consumedItem.nutritionProduct is required");
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
         * Returns a builder initialized with the values of this {@code ConsumedItem}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ConsumedItem}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private CodeableReference nutritionProduct;
            private Timing schedule;
            private Quantity amount;
            private Quantity rate;
            private FhirBoolean notConsumed;
            private CodeableConcept notConsumedReason;

            private Builder() {
            }

            private Builder(ConsumedItem original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.nutritionProduct = original.nutritionProduct();
                this.schedule = original.schedule();
                this.amount = original.amount();
                this.rate = original.rate();
                this.notConsumed = original.notConsumed();
                this.notConsumedReason = original.notConsumedReason();
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
             * Sets {@code nutritionProduct}.
             *
             * @param nutritionProduct the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder nutritionProduct(CodeableReference nutritionProduct) {
                this.nutritionProduct = nutritionProduct;
                return this;
            }

            /**
             * Sets {@code schedule}.
             *
             * @param schedule the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder schedule(Timing schedule) {
                this.schedule = schedule;
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
             * Sets {@code rate}.
             *
             * @param rate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rate(Quantity rate) {
                this.rate = rate;
                return this;
            }

            /**
             * Sets {@code notConsumed}.
             *
             * @param notConsumed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder notConsumed(FhirBoolean notConsumed) {
                this.notConsumed = notConsumed;
                return this;
            }

            /**
             * Sets {@code notConsumed}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param notConsumed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder notConsumed(Boolean notConsumed) {
                return notConsumed(notConsumed == null ? null : FhirBoolean.of(notConsumed));
            }

            /**
             * Sets {@code notConsumedReason}.
             *
             * @param notConsumedReason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder notConsumedReason(CodeableConcept notConsumedReason) {
                this.notConsumedReason = notConsumedReason;
                return this;
            }

            /**
             * Builds the {@code ConsumedItem}.
             *
             * @return the {@code ConsumedItem}
             * @throws NullPointerException if a required element is absent
             */
            public ConsumedItem build() {
                return new ConsumedItem(
                        id, extension, modifierExtension, type, nutritionProduct, schedule, amount, rate, notConsumed,
                        notConsumedReason);
            }
        }
    }

    /**
     * Total nutrient amounts for the whole meal, product, serving, etc.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param nutrient Total nutrient consumed. Required.
     * @param amount Total amount of nutrient consumed. Required.
     */
    public record IngredientLabel(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference nutrient,
            Quantity amount) implements BackboneElement {

        /**
         * Creates an {@code IngredientLabel}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public IngredientLabel {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(nutrient, "NutritionIntake.ingredientLabel.nutrient is required");
            Objects.requireNonNull(amount, "NutritionIntake.ingredientLabel.amount is required");
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
         * Returns a builder initialized with the values of this {@code IngredientLabel}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link IngredientLabel}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference nutrient;
            private Quantity amount;

            private Builder() {
            }

            private Builder(IngredientLabel original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.nutrient = original.nutrient();
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
             * Sets {@code nutrient}.
             *
             * @param nutrient the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder nutrient(CodeableReference nutrient) {
                this.nutrient = nutrient;
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
             * Builds the {@code IngredientLabel}.
             *
             * @return the {@code IngredientLabel}
             * @throws NullPointerException if a required element is absent
             */
            public IngredientLabel build() {
                return new IngredientLabel(
                        id, extension, modifierExtension, nutrient, amount);
            }
        }
    }

    /**
     * Who performed the intake and how they were involved.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function Type of performer.
     * @param actor Who performed the intake. Reference to Practitioner, PractitionerRole, Organization, CareTeam,
     *   Patient, Device, RelatedPerson. Required.
     */
    public record Performer(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept function,
            Reference actor) implements BackboneElement {

        /**
         * Creates a {@code Performer}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Performer {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(actor, "NutritionIntake.performer.actor is required");
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
         * Returns a builder initialized with the values of this {@code Performer}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Performer}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept function;
            private Reference actor;

            private Builder() {
            }

            private Builder(Performer original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.function = original.function();
                this.actor = original.actor();
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
             * Sets {@code function}.
             *
             * @param function the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder function(CodeableConcept function) {
                this.function = function;
                return this;
            }

            /**
             * Sets {@code actor}.
             *
             * @param actor the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder actor(Reference actor) {
                this.actor = actor;
                return this;
            }

            /**
             * Builds the {@code Performer}.
             *
             * @return the {@code Performer}
             * @throws NullPointerException if a required element is absent
             */
            public Performer build() {
                return new Performer(
                        id, extension, modifierExtension, function, actor);
            }
        }
    }

    /** Builder for {@link NutritionIntake}. Builders are mutable and not thread-safe. */
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
        private List<FhirCanonical> instantiatesCanonical = new ArrayList<>();
        private List<FhirUri> instantiatesUri = new ArrayList<>();
        private List<Reference> basedOn = new ArrayList<>();
        private List<Reference> partOf = new ArrayList<>();
        private FhirEnum<EventStatus> status;
        private List<CodeableConcept> statusReason = new ArrayList<>();
        private CodeableConcept code;
        private Reference subject;
        private Reference encounter;
        private DataType occurrence;
        private FhirDateTime recorded;
        private DataType reported;
        private List<ConsumedItem> consumedItem = new ArrayList<>();
        private List<IngredientLabel> ingredientLabel = new ArrayList<>();
        private List<Performer> performer = new ArrayList<>();
        private Reference location;
        private List<Reference> derivedFrom = new ArrayList<>();
        private List<CodeableReference> reason = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(NutritionIntake original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.instantiatesCanonical = new ArrayList<>(original.instantiatesCanonical());
            this.instantiatesUri = new ArrayList<>(original.instantiatesUri());
            this.basedOn = new ArrayList<>(original.basedOn());
            this.partOf = new ArrayList<>(original.partOf());
            this.status = original.status();
            this.statusReason = new ArrayList<>(original.statusReason());
            this.code = original.code();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.occurrence = original.occurrence();
            this.recorded = original.recorded();
            this.reported = original.reported();
            this.consumedItem = new ArrayList<>(original.consumedItem());
            this.ingredientLabel = new ArrayList<>(original.ingredientLabel());
            this.performer = new ArrayList<>(original.performer());
            this.location = original.location();
            this.derivedFrom = new ArrayList<>(original.derivedFrom());
            this.reason = new ArrayList<>(original.reason());
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
         * Replaces all {@code instantiatesCanonical} values.
         *
         * @param instantiatesCanonical the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder instantiatesCanonical(List<FhirCanonical> instantiatesCanonical) {
            this.instantiatesCanonical = instantiatesCanonical == null
                    ? new ArrayList<>()
                    : new ArrayList<>(instantiatesCanonical);
            return this;
        }

        /**
         * Adds a {@code instantiatesCanonical} value.
         *
         * @param instantiatesCanonical the value to add
         * @return this builder
         */
        public Builder addInstantiatesCanonical(FhirCanonical instantiatesCanonical) {
            this.instantiatesCanonical.add(Objects.requireNonNull(instantiatesCanonical, "instantiatesCanonical"));
            return this;
        }

        /**
         * Adds a {@code instantiatesCanonical} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param instantiatesCanonical the value to add
         * @return this builder
         */
        public Builder addInstantiatesCanonical(String instantiatesCanonical) {
            return addInstantiatesCanonical(FhirCanonical.of(instantiatesCanonical));
        }

        /**
         * Replaces all {@code instantiatesUri} values.
         *
         * @param instantiatesUri the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder instantiatesUri(List<FhirUri> instantiatesUri) {
            this.instantiatesUri = instantiatesUri == null ? new ArrayList<>() : new ArrayList<>(instantiatesUri);
            return this;
        }

        /**
         * Adds a {@code instantiatesUri} value.
         *
         * @param instantiatesUri the value to add
         * @return this builder
         */
        public Builder addInstantiatesUri(FhirUri instantiatesUri) {
            this.instantiatesUri.add(Objects.requireNonNull(instantiatesUri, "instantiatesUri"));
            return this;
        }

        /**
         * Adds a {@code instantiatesUri} value, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param instantiatesUri the value to add
         * @return this builder
         */
        public Builder addInstantiatesUri(String instantiatesUri) {
            return addInstantiatesUri(FhirUri.of(instantiatesUri));
        }

        /**
         * Replaces all {@code basedOn} values.
         *
         * @param basedOn the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder basedOn(List<Reference> basedOn) {
            this.basedOn = basedOn == null ? new ArrayList<>() : new ArrayList<>(basedOn);
            return this;
        }

        /**
         * Adds a {@code basedOn} value.
         *
         * @param basedOn the value to add
         * @return this builder
         */
        public Builder addBasedOn(Reference basedOn) {
            this.basedOn.add(Objects.requireNonNull(basedOn, "basedOn"));
            return this;
        }

        /**
         * Replaces all {@code partOf} values.
         *
         * @param partOf the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder partOf(List<Reference> partOf) {
            this.partOf = partOf == null ? new ArrayList<>() : new ArrayList<>(partOf);
            return this;
        }

        /**
         * Adds a {@code partOf} value.
         *
         * @param partOf the value to add
         * @return this builder
         */
        public Builder addPartOf(Reference partOf) {
            this.partOf.add(Objects.requireNonNull(partOf, "partOf"));
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<EventStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(EventStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Replaces all {@code statusReason} values.
         *
         * @param statusReason the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder statusReason(List<CodeableConcept> statusReason) {
            this.statusReason = statusReason == null ? new ArrayList<>() : new ArrayList<>(statusReason);
            return this;
        }

        /**
         * Adds a {@code statusReason} value.
         *
         * @param statusReason the value to add
         * @return this builder
         */
        public Builder addStatusReason(CodeableConcept statusReason) {
            this.statusReason.add(Objects.requireNonNull(statusReason, "statusReason"));
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
         * Sets {@code encounter}.
         *
         * @param encounter the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder encounter(Reference encounter) {
            this.encounter = encounter;
            return this;
        }

        /**
         * Sets {@code occurrence} to a dateTime.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(FhirDateTime occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a Period.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Period occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a dateTime without id or extensions.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Temporal occurrence) {
            this.occurrence = occurrence == null ? null : FhirDateTime.of(occurrence);
            return this;
        }

        /**
         * Sets {@code recorded}.
         *
         * @param recorded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorded(FhirDateTime recorded) {
            this.recorded = recorded;
            return this;
        }

        /**
         * Sets {@code recorded}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param recorded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorded(Temporal recorded) {
            return recorded(recorded == null ? null : FhirDateTime.of(recorded));
        }

        /**
         * Sets {@code reported} to a boolean.
         *
         * @param reported the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reported(FhirBoolean reported) {
            this.reported = reported;
            return this;
        }

        /**
         * Sets {@code reported} to a Reference.
         *
         * @param reported the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reported(Reference reported) {
            this.reported = reported;
            return this;
        }

        /**
         * Sets {@code reported} to a boolean without id or extensions.
         *
         * @param reported the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reported(Boolean reported) {
            this.reported = reported == null ? null : FhirBoolean.of(reported);
            return this;
        }

        /**
         * Replaces all {@code consumedItem} values.
         *
         * @param consumedItem the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder consumedItem(List<ConsumedItem> consumedItem) {
            this.consumedItem = consumedItem == null ? new ArrayList<>() : new ArrayList<>(consumedItem);
            return this;
        }

        /**
         * Adds a {@code consumedItem} value.
         *
         * @param consumedItem the value to add
         * @return this builder
         */
        public Builder addConsumedItem(ConsumedItem consumedItem) {
            this.consumedItem.add(Objects.requireNonNull(consumedItem, "consumedItem"));
            return this;
        }

        /**
         * Replaces all {@code ingredientLabel} values.
         *
         * @param ingredientLabel the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder ingredientLabel(List<IngredientLabel> ingredientLabel) {
            this.ingredientLabel = ingredientLabel == null ? new ArrayList<>() : new ArrayList<>(ingredientLabel);
            return this;
        }

        /**
         * Adds a {@code ingredientLabel} value.
         *
         * @param ingredientLabel the value to add
         * @return this builder
         */
        public Builder addIngredientLabel(IngredientLabel ingredientLabel) {
            this.ingredientLabel.add(Objects.requireNonNull(ingredientLabel, "ingredientLabel"));
            return this;
        }

        /**
         * Replaces all {@code performer} values.
         *
         * @param performer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder performer(List<Performer> performer) {
            this.performer = performer == null ? new ArrayList<>() : new ArrayList<>(performer);
            return this;
        }

        /**
         * Adds a {@code performer} value.
         *
         * @param performer the value to add
         * @return this builder
         */
        public Builder addPerformer(Performer performer) {
            this.performer.add(Objects.requireNonNull(performer, "performer"));
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
         * Replaces all {@code derivedFrom} values.
         *
         * @param derivedFrom the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder derivedFrom(List<Reference> derivedFrom) {
            this.derivedFrom = derivedFrom == null ? new ArrayList<>() : new ArrayList<>(derivedFrom);
            return this;
        }

        /**
         * Adds a {@code derivedFrom} value.
         *
         * @param derivedFrom the value to add
         * @return this builder
         */
        public Builder addDerivedFrom(Reference derivedFrom) {
            this.derivedFrom.add(Objects.requireNonNull(derivedFrom, "derivedFrom"));
            return this;
        }

        /**
         * Replaces all {@code reason} values.
         *
         * @param reason the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reason(List<CodeableReference> reason) {
            this.reason = reason == null ? new ArrayList<>() : new ArrayList<>(reason);
            return this;
        }

        /**
         * Adds a {@code reason} value.
         *
         * @param reason the value to add
         * @return this builder
         */
        public Builder addReason(CodeableReference reason) {
            this.reason.add(Objects.requireNonNull(reason, "reason"));
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
         * Builds the {@code NutritionIntake}.
         *
         * @return the {@code NutritionIntake}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public NutritionIntake build() {
            return new NutritionIntake(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiatesCanonical, instantiatesUri, basedOn, partOf, status, statusReason, code, subject,
                    encounter, occurrence, recorded, reported, consumedItem, ingredientLabel, performer, location,
                    derivedFrom, reason, note);
        }
    }
}
