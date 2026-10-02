package se.poroli.fhirplace.r5.clinical.careprovision;

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
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;

/**
 * A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.
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
 * @param identifier Identifiers assigned to this order.
 * @param instantiatesCanonical Instantiates FHIR protocol or definition. Canonical reference to ActivityDefinition,
 *   PlanDefinition.
 * @param instantiatesUri Instantiates external protocol or definition.
 * @param instantiates Instantiates protocol or definition.
 * @param basedOn What this order fulfills. Reference to CarePlan, NutritionOrder, ServiceRequest.
 * @param groupIdentifier Composite Request ID.
 * @param status draft | active | on-hold | revoked | completed | entered-in-error | unknown. Required. Modifier
 *   element.
 * @param intent proposal | plan | directive | order | original-order | reflex-order | filler-order | instance-order |
 *   option. Required. Modifier element.
 * @param priority routine | urgent | asap | stat.
 * @param subject Who requires the diet, formula or nutritional supplement. Reference to Patient, Group. Required.
 * @param encounter The encounter associated with this nutrition order. Reference to Encounter.
 * @param supportingInformation Information to support fulfilling of the nutrition order. Reference to Resource.
 * @param dateTime Date and time the nutrition order was requested. Required.
 * @param orderer Who ordered the diet, formula or nutritional supplement. Reference to Practitioner,
 *   PractitionerRole.
 * @param performer Who is desired to perform the administration of what is being ordered.
 * @param allergyIntolerance List of the patient's food and nutrition-related allergies and intolerances. Reference to
 *   AllergyIntolerance.
 * @param foodPreferenceModifier Order-specific modifier about the type of food that should be given.
 * @param excludeFoodModifier Order-specific modifier about the type of food that should not be given.
 * @param outsideFoodAllowed Capture when a food item is brought in by the patient and/or family.
 * @param oralDiet Oral diet components.
 * @param supplement Supplement components.
 * @param enteralFormula Enteral formula components.
 * @param note Comments.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/NutritionOrder">FHIR R5 NutritionOrder</a>
 */
public record NutritionOrder(
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
        List<FhirUri> instantiates,
        List<Reference> basedOn,
        Identifier groupIdentifier,
        FhirEnum<RequestStatus> status,
        FhirEnum<RequestIntent> intent,
        FhirEnum<RequestPriority> priority,
        Reference subject,
        Reference encounter,
        List<Reference> supportingInformation,
        FhirDateTime dateTime,
        Reference orderer,
        List<CodeableReference> performer,
        List<Reference> allergyIntolerance,
        List<CodeableConcept> foodPreferenceModifier,
        List<CodeableConcept> excludeFoodModifier,
        FhirBoolean outsideFoodAllowed,
        OralDiet oralDiet,
        List<Supplement> supplement,
        EnteralFormula enteralFormula,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates a {@code NutritionOrder}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public NutritionOrder {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        instantiatesCanonical = instantiatesCanonical == null ? List.of() : List.copyOf(instantiatesCanonical);
        instantiatesUri = instantiatesUri == null ? List.of() : List.copyOf(instantiatesUri);
        instantiates = instantiates == null ? List.of() : List.copyOf(instantiates);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        supportingInformation = supportingInformation == null ? List.of() : List.copyOf(supportingInformation);
        performer = performer == null ? List.of() : List.copyOf(performer);
        allergyIntolerance = allergyIntolerance == null ? List.of() : List.copyOf(allergyIntolerance);
        foodPreferenceModifier = foodPreferenceModifier == null ? List.of() : List.copyOf(foodPreferenceModifier);
        excludeFoodModifier = excludeFoodModifier == null ? List.of() : List.copyOf(excludeFoodModifier);
        supplement = supplement == null ? List.of() : List.copyOf(supplement);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "NutritionOrder.status is required");
        Objects.requireNonNull(intent, "NutritionOrder.intent is required");
        Objects.requireNonNull(subject, "NutritionOrder.subject is required");
        Objects.requireNonNull(dateTime, "NutritionOrder.dateTime is required");
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
     * Returns a builder initialized with the values of this {@code NutritionOrder}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Diet given orally in contrast to enteral (tube) feeding.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Type of oral diet or diet restrictions that describe what can be consumed orally.
     * @param schedule Scheduling information for oral diets.
     * @param nutrient Required nutrient modifications.
     * @param texture Required texture modifications.
     * @param fluidConsistencyType The required consistency of fluids and liquids provided to the patient.
     * @param instruction Instructions or additional information about the oral diet.
     */
    public record OralDiet(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableConcept> type,
            OralDietSchedule schedule,
            List<Nutrient> nutrient,
            List<Texture> texture,
            List<CodeableConcept> fluidConsistencyType,
            FhirString instruction) implements BackboneElement {

        /**
         * Creates an {@code OralDiet}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public OralDiet {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            type = type == null ? List.of() : List.copyOf(type);
            nutrient = nutrient == null ? List.of() : List.copyOf(nutrient);
            texture = texture == null ? List.of() : List.copyOf(texture);
            fluidConsistencyType = fluidConsistencyType == null ? List.of() : List.copyOf(fluidConsistencyType);
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
         * Returns a builder initialized with the values of this {@code OralDiet}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Schedule information for an oral diet.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param timing Scheduled frequency of diet.
         * @param asNeeded Take 'as needed'.
         * @param asNeededFor Take 'as needed' for x.
         */
        public record OralDietSchedule(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<Timing> timing,
                FhirBoolean asNeeded,
                CodeableConcept asNeededFor) implements BackboneElement {

            /**
             * Creates an {@code OralDietSchedule}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public OralDietSchedule {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                timing = timing == null ? List.of() : List.copyOf(timing);
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
             * Returns a builder initialized with the values of this {@code OralDietSchedule}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link OralDietSchedule}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<Timing> timing = new ArrayList<>();
                private FhirBoolean asNeeded;
                private CodeableConcept asNeededFor;

                private Builder() {
                }

                private Builder(OralDietSchedule original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.timing = new ArrayList<>(original.timing());
                    this.asNeeded = original.asNeeded();
                    this.asNeededFor = original.asNeededFor();
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
                 * Replaces all {@code timing} values.
                 *
                 * @param timing the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder timing(List<Timing> timing) {
                    this.timing = timing == null ? new ArrayList<>() : new ArrayList<>(timing);
                    return this;
                }

                /**
                 * Adds a {@code timing} value.
                 *
                 * @param timing the value to add
                 * @return this builder
                 */
                public Builder addTiming(Timing timing) {
                    this.timing.add(Objects.requireNonNull(timing, "timing"));
                    return this;
                }

                /**
                 * Sets {@code asNeeded}.
                 *
                 * @param asNeeded the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder asNeeded(FhirBoolean asNeeded) {
                    this.asNeeded = asNeeded;
                    return this;
                }

                /**
                 * Sets {@code asNeeded}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param asNeeded the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder asNeeded(Boolean asNeeded) {
                    return asNeeded(asNeeded == null ? null : FhirBoolean.of(asNeeded));
                }

                /**
                 * Sets {@code asNeededFor}.
                 *
                 * @param asNeededFor the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder asNeededFor(CodeableConcept asNeededFor) {
                    this.asNeededFor = asNeededFor;
                    return this;
                }

                /**
                 * Builds the {@code OralDietSchedule}.
                 *
                 * @return the {@code OralDietSchedule}
                 */
                public OralDietSchedule build() {
                    return new OralDietSchedule(
                            id, extension, modifierExtension, timing, asNeeded, asNeededFor);
                }
            }
        }

        /**
         * Class that defines the quantity and type of nutrient modifications (for example carbohydrate, fiber or
         * sodium) required for the oral diet.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param modifier Type of nutrient that is being modified.
         * @param amount Quantity of the specified nutrient.
         */
        public record Nutrient(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept modifier,
                Quantity amount) implements BackboneElement {

            /**
             * Creates a {@code Nutrient}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Nutrient {
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
                private CodeableConcept modifier;
                private Quantity amount;

                private Builder() {
                }

                private Builder(Nutrient original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.modifier = original.modifier();
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
                 * Sets {@code modifier}.
                 *
                 * @param modifier the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder modifier(CodeableConcept modifier) {
                    this.modifier = modifier;
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
                 * Builds the {@code Nutrient}.
                 *
                 * @return the {@code Nutrient}
                 */
                public Nutrient build() {
                    return new Nutrient(
                            id, extension, modifierExtension, modifier, amount);
                }
            }
        }

        /**
         * Class that describes any texture modifications required for the patient to safely consume various types of
         * solid foods.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param modifier Code to indicate how to alter the texture of the foods, e.g. pureed.
         * @param foodType Concepts that are used to identify an entity that is ingested for nutritional purposes.
         */
        public record Texture(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept modifier,
                CodeableConcept foodType) implements BackboneElement {

            /**
             * Creates a {@code Texture}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Texture {
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
             * Returns a builder initialized with the values of this {@code Texture}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Texture}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept modifier;
                private CodeableConcept foodType;

                private Builder() {
                }

                private Builder(Texture original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.modifier = original.modifier();
                    this.foodType = original.foodType();
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
                 * Sets {@code modifier}.
                 *
                 * @param modifier the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder modifier(CodeableConcept modifier) {
                    this.modifier = modifier;
                    return this;
                }

                /**
                 * Sets {@code foodType}.
                 *
                 * @param foodType the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder foodType(CodeableConcept foodType) {
                    this.foodType = foodType;
                    return this;
                }

                /**
                 * Builds the {@code Texture}.
                 *
                 * @return the {@code Texture}
                 */
                public Texture build() {
                    return new Texture(
                            id, extension, modifierExtension, modifier, foodType);
                }
            }
        }

        /** Builder for {@link OralDiet}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<CodeableConcept> type = new ArrayList<>();
            private OralDietSchedule schedule;
            private List<Nutrient> nutrient = new ArrayList<>();
            private List<Texture> texture = new ArrayList<>();
            private List<CodeableConcept> fluidConsistencyType = new ArrayList<>();
            private FhirString instruction;

            private Builder() {
            }

            private Builder(OralDiet original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = new ArrayList<>(original.type());
                this.schedule = original.schedule();
                this.nutrient = new ArrayList<>(original.nutrient());
                this.texture = new ArrayList<>(original.texture());
                this.fluidConsistencyType = new ArrayList<>(original.fluidConsistencyType());
                this.instruction = original.instruction();
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
             * Sets {@code schedule}.
             *
             * @param schedule the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder schedule(OralDietSchedule schedule) {
                this.schedule = schedule;
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
             * Replaces all {@code texture} values.
             *
             * @param texture the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder texture(List<Texture> texture) {
                this.texture = texture == null ? new ArrayList<>() : new ArrayList<>(texture);
                return this;
            }

            /**
             * Adds a {@code texture} value.
             *
             * @param texture the value to add
             * @return this builder
             */
            public Builder addTexture(Texture texture) {
                this.texture.add(Objects.requireNonNull(texture, "texture"));
                return this;
            }

            /**
             * Replaces all {@code fluidConsistencyType} values.
             *
             * @param fluidConsistencyType the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder fluidConsistencyType(List<CodeableConcept> fluidConsistencyType) {
                this.fluidConsistencyType = fluidConsistencyType == null
                        ? new ArrayList<>()
                        : new ArrayList<>(fluidConsistencyType);
                return this;
            }

            /**
             * Adds a {@code fluidConsistencyType} value.
             *
             * @param fluidConsistencyType the value to add
             * @return this builder
             */
            public Builder addFluidConsistencyType(CodeableConcept fluidConsistencyType) {
                this.fluidConsistencyType.add(Objects.requireNonNull(fluidConsistencyType, "fluidConsistencyType"));
                return this;
            }

            /**
             * Sets {@code instruction}.
             *
             * @param instruction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instruction(FhirString instruction) {
                this.instruction = instruction;
                return this;
            }

            /**
             * Sets {@code instruction}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param instruction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instruction(String instruction) {
                return instruction(instruction == null ? null : FhirString.of(instruction));
            }

            /**
             * Builds the {@code OralDiet}.
             *
             * @return the {@code OralDiet}
             */
            public OralDiet build() {
                return new OralDiet(
                        id, extension, modifierExtension, type, schedule, nutrient, texture, fluidConsistencyType,
                        instruction);
            }
        }
    }

    /**
     * Oral nutritional products given in order to add further nutritional value to the patient's diet.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Type of supplement product requested.
     * @param productName Product or brand name of the nutritional supplement.
     * @param schedule Scheduling information for supplements.
     * @param quantity Amount of the nutritional supplement.
     * @param instruction Instructions or additional information about the oral supplement.
     */
    public record Supplement(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference type,
            FhirString productName,
            SupplementSchedule schedule,
            Quantity quantity,
            FhirString instruction) implements BackboneElement {

        /**
         * Creates a {@code Supplement}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Supplement {
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
         * Returns a builder initialized with the values of this {@code Supplement}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Schedule information for a supplement.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param timing Scheduled frequency of diet.
         * @param asNeeded Take 'as needed'.
         * @param asNeededFor Take 'as needed' for x.
         */
        public record SupplementSchedule(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<Timing> timing,
                FhirBoolean asNeeded,
                CodeableConcept asNeededFor) implements BackboneElement {

            /**
             * Creates a {@code SupplementSchedule}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public SupplementSchedule {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                timing = timing == null ? List.of() : List.copyOf(timing);
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
             * Returns a builder initialized with the values of this {@code SupplementSchedule}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link SupplementSchedule}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<Timing> timing = new ArrayList<>();
                private FhirBoolean asNeeded;
                private CodeableConcept asNeededFor;

                private Builder() {
                }

                private Builder(SupplementSchedule original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.timing = new ArrayList<>(original.timing());
                    this.asNeeded = original.asNeeded();
                    this.asNeededFor = original.asNeededFor();
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
                 * Replaces all {@code timing} values.
                 *
                 * @param timing the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder timing(List<Timing> timing) {
                    this.timing = timing == null ? new ArrayList<>() : new ArrayList<>(timing);
                    return this;
                }

                /**
                 * Adds a {@code timing} value.
                 *
                 * @param timing the value to add
                 * @return this builder
                 */
                public Builder addTiming(Timing timing) {
                    this.timing.add(Objects.requireNonNull(timing, "timing"));
                    return this;
                }

                /**
                 * Sets {@code asNeeded}.
                 *
                 * @param asNeeded the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder asNeeded(FhirBoolean asNeeded) {
                    this.asNeeded = asNeeded;
                    return this;
                }

                /**
                 * Sets {@code asNeeded}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param asNeeded the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder asNeeded(Boolean asNeeded) {
                    return asNeeded(asNeeded == null ? null : FhirBoolean.of(asNeeded));
                }

                /**
                 * Sets {@code asNeededFor}.
                 *
                 * @param asNeededFor the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder asNeededFor(CodeableConcept asNeededFor) {
                    this.asNeededFor = asNeededFor;
                    return this;
                }

                /**
                 * Builds the {@code SupplementSchedule}.
                 *
                 * @return the {@code SupplementSchedule}
                 */
                public SupplementSchedule build() {
                    return new SupplementSchedule(
                            id, extension, modifierExtension, timing, asNeeded, asNeededFor);
                }
            }
        }

        /** Builder for {@link Supplement}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference type;
            private FhirString productName;
            private SupplementSchedule schedule;
            private Quantity quantity;
            private FhirString instruction;

            private Builder() {
            }

            private Builder(Supplement original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.productName = original.productName();
                this.schedule = original.schedule();
                this.quantity = original.quantity();
                this.instruction = original.instruction();
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
            public Builder type(CodeableReference type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code productName}.
             *
             * @param productName the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder productName(FhirString productName) {
                this.productName = productName;
                return this;
            }

            /**
             * Sets {@code productName}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param productName the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder productName(String productName) {
                return productName(productName == null ? null : FhirString.of(productName));
            }

            /**
             * Sets {@code schedule}.
             *
             * @param schedule the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder schedule(SupplementSchedule schedule) {
                this.schedule = schedule;
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
             * Sets {@code instruction}.
             *
             * @param instruction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instruction(FhirString instruction) {
                this.instruction = instruction;
                return this;
            }

            /**
             * Sets {@code instruction}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param instruction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instruction(String instruction) {
                return instruction(instruction == null ? null : FhirString.of(instruction));
            }

            /**
             * Builds the {@code Supplement}.
             *
             * @return the {@code Supplement}
             */
            public Supplement build() {
                return new Supplement(
                        id, extension, modifierExtension, type, productName, schedule, quantity, instruction);
            }
        }
    }

    /**
     * Feeding provided through the gastrointestinal tract via a tube, catheter, or stoma that delivers nutrition
     * distal to the oral cavity.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param baseFormulaType Type of enteral or infant formula.
     * @param baseFormulaProductName Product or brand name of the enteral or infant formula.
     * @param deliveryDevice Intended type of device for the administration.
     * @param additive Components to add to the feeding.
     * @param caloricDensity Amount of energy per specified volume that is required.
     * @param routeOfAdministration How the formula should enter the patient's gastrointestinal tract.
     * @param administration Formula feeding instruction as structured data.
     * @param maxVolumeToDeliver Upper limit on formula volume per unit of time.
     * @param administrationInstruction Formula feeding instructions expressed as text.
     */
    public record EnteralFormula(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference baseFormulaType,
            FhirString baseFormulaProductName,
            List<CodeableReference> deliveryDevice,
            List<Additive> additive,
            Quantity caloricDensity,
            CodeableConcept routeOfAdministration,
            List<Administration> administration,
            Quantity maxVolumeToDeliver,
            FhirMarkdown administrationInstruction) implements BackboneElement {

        /**
         * Creates an {@code EnteralFormula}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public EnteralFormula {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            deliveryDevice = deliveryDevice == null ? List.of() : List.copyOf(deliveryDevice);
            additive = additive == null ? List.of() : List.copyOf(additive);
            administration = administration == null ? List.of() : List.copyOf(administration);
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
         * Returns a builder initialized with the values of this {@code EnteralFormula}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Indicates modular components to be provided in addition or mixed with the base formula.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type Type of modular component to add to the feeding.
         * @param productName Product or brand name of the modular additive.
         * @param quantity Amount of additive to be given or mixed in.
         */
        public record Additive(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableReference type,
                FhirString productName,
                Quantity quantity) implements BackboneElement {

            /**
             * Creates an {@code Additive}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Additive {
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
             * Returns a builder initialized with the values of this {@code Additive}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Additive}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableReference type;
                private FhirString productName;
                private Quantity quantity;

                private Builder() {
                }

                private Builder(Additive original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.productName = original.productName();
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
                 * Sets {@code type}.
                 *
                 * @param type the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder type(CodeableReference type) {
                    this.type = type;
                    return this;
                }

                /**
                 * Sets {@code productName}.
                 *
                 * @param productName the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder productName(FhirString productName) {
                    this.productName = productName;
                    return this;
                }

                /**
                 * Sets {@code productName}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param productName the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder productName(String productName) {
                    return productName(productName == null ? null : FhirString.of(productName));
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
                 * Builds the {@code Additive}.
                 *
                 * @return the {@code Additive}
                 */
                public Additive build() {
                    return new Additive(
                            id, extension, modifierExtension, type, productName, quantity);
                }
            }
        }

        /**
         * Formula administration instructions as structured data.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param schedule Scheduling information for enteral formula products.
         * @param quantity The volume of formula to provide.
         * @param rate Speed with which the formula is provided per period of time. One of Quantity, Ratio.
         */
        public record Administration(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                EnteralFormulaSchedule schedule,
                Quantity quantity,
                DataType rate) implements BackboneElement {

            /**
             * Creates an {@code Administration}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Administration {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                if (rate != null && !(rate instanceof Quantity || rate instanceof Ratio)) {
                    throw new IllegalArgumentException(
                            "NutritionOrder.enteralFormula.administration.rate[x] does not allow "
                                    + rate.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code Administration}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Schedule information for an enteral formula.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param timing Scheduled frequency of enteral formula.
             * @param asNeeded Take 'as needed'.
             * @param asNeededFor Take 'as needed' for x.
             */
            public record EnteralFormulaSchedule(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    List<Timing> timing,
                    FhirBoolean asNeeded,
                    CodeableConcept asNeededFor) implements BackboneElement {

                /**
                 * Creates an {@code EnteralFormulaSchedule}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 */
                public EnteralFormulaSchedule {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    timing = timing == null ? List.of() : List.copyOf(timing);
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
                 * Returns a builder initialized with the values of this {@code EnteralFormulaSchedule}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link EnteralFormulaSchedule}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private List<Timing> timing = new ArrayList<>();
                    private FhirBoolean asNeeded;
                    private CodeableConcept asNeededFor;

                    private Builder() {
                    }

                    private Builder(EnteralFormulaSchedule original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.timing = new ArrayList<>(original.timing());
                        this.asNeeded = original.asNeeded();
                        this.asNeededFor = original.asNeededFor();
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
                     * Replaces all {@code timing} values.
                     *
                     * @param timing the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder timing(List<Timing> timing) {
                        this.timing = timing == null ? new ArrayList<>() : new ArrayList<>(timing);
                        return this;
                    }

                    /**
                     * Adds a {@code timing} value.
                     *
                     * @param timing the value to add
                     * @return this builder
                     */
                    public Builder addTiming(Timing timing) {
                        this.timing.add(Objects.requireNonNull(timing, "timing"));
                        return this;
                    }

                    /**
                     * Sets {@code asNeeded}.
                     *
                     * @param asNeeded the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder asNeeded(FhirBoolean asNeeded) {
                        this.asNeeded = asNeeded;
                        return this;
                    }

                    /**
                     * Sets {@code asNeeded}, wrapped in a {@link FhirBoolean} without id or extensions.
                     *
                     * @param asNeeded the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder asNeeded(Boolean asNeeded) {
                        return asNeeded(asNeeded == null ? null : FhirBoolean.of(asNeeded));
                    }

                    /**
                     * Sets {@code asNeededFor}.
                     *
                     * @param asNeededFor the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder asNeededFor(CodeableConcept asNeededFor) {
                        this.asNeededFor = asNeededFor;
                        return this;
                    }

                    /**
                     * Builds the {@code EnteralFormulaSchedule}.
                     *
                     * @return the {@code EnteralFormulaSchedule}
                     */
                    public EnteralFormulaSchedule build() {
                        return new EnteralFormulaSchedule(
                                id, extension, modifierExtension, timing, asNeeded, asNeededFor);
                    }
                }
            }

            /** Builder for {@link Administration}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private EnteralFormulaSchedule schedule;
                private Quantity quantity;
                private DataType rate;

                private Builder() {
                }

                private Builder(Administration original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.schedule = original.schedule();
                    this.quantity = original.quantity();
                    this.rate = original.rate();
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
                 * Sets {@code schedule}.
                 *
                 * @param schedule the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder schedule(EnteralFormulaSchedule schedule) {
                    this.schedule = schedule;
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
                 * Sets {@code rate} to a Quantity.
                 *
                 * @param rate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder rate(Quantity rate) {
                    this.rate = rate;
                    return this;
                }

                /**
                 * Sets {@code rate} to a Ratio.
                 *
                 * @param rate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder rate(Ratio rate) {
                    this.rate = rate;
                    return this;
                }

                /**
                 * Builds the {@code Administration}.
                 *
                 * @return the {@code Administration}
                 */
                public Administration build() {
                    return new Administration(
                            id, extension, modifierExtension, schedule, quantity, rate);
                }
            }
        }

        /** Builder for {@link EnteralFormula}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference baseFormulaType;
            private FhirString baseFormulaProductName;
            private List<CodeableReference> deliveryDevice = new ArrayList<>();
            private List<Additive> additive = new ArrayList<>();
            private Quantity caloricDensity;
            private CodeableConcept routeOfAdministration;
            private List<Administration> administration = new ArrayList<>();
            private Quantity maxVolumeToDeliver;
            private FhirMarkdown administrationInstruction;

            private Builder() {
            }

            private Builder(EnteralFormula original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.baseFormulaType = original.baseFormulaType();
                this.baseFormulaProductName = original.baseFormulaProductName();
                this.deliveryDevice = new ArrayList<>(original.deliveryDevice());
                this.additive = new ArrayList<>(original.additive());
                this.caloricDensity = original.caloricDensity();
                this.routeOfAdministration = original.routeOfAdministration();
                this.administration = new ArrayList<>(original.administration());
                this.maxVolumeToDeliver = original.maxVolumeToDeliver();
                this.administrationInstruction = original.administrationInstruction();
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
             * Sets {@code baseFormulaType}.
             *
             * @param baseFormulaType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder baseFormulaType(CodeableReference baseFormulaType) {
                this.baseFormulaType = baseFormulaType;
                return this;
            }

            /**
             * Sets {@code baseFormulaProductName}.
             *
             * @param baseFormulaProductName the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder baseFormulaProductName(FhirString baseFormulaProductName) {
                this.baseFormulaProductName = baseFormulaProductName;
                return this;
            }

            /**
             * Sets {@code baseFormulaProductName}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param baseFormulaProductName the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder baseFormulaProductName(String baseFormulaProductName) {
                return baseFormulaProductName(
                        baseFormulaProductName == null ? null : FhirString.of(baseFormulaProductName));
            }

            /**
             * Replaces all {@code deliveryDevice} values.
             *
             * @param deliveryDevice the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder deliveryDevice(List<CodeableReference> deliveryDevice) {
                this.deliveryDevice = deliveryDevice == null ? new ArrayList<>() : new ArrayList<>(deliveryDevice);
                return this;
            }

            /**
             * Adds a {@code deliveryDevice} value.
             *
             * @param deliveryDevice the value to add
             * @return this builder
             */
            public Builder addDeliveryDevice(CodeableReference deliveryDevice) {
                this.deliveryDevice.add(Objects.requireNonNull(deliveryDevice, "deliveryDevice"));
                return this;
            }

            /**
             * Replaces all {@code additive} values.
             *
             * @param additive the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder additive(List<Additive> additive) {
                this.additive = additive == null ? new ArrayList<>() : new ArrayList<>(additive);
                return this;
            }

            /**
             * Adds a {@code additive} value.
             *
             * @param additive the value to add
             * @return this builder
             */
            public Builder addAdditive(Additive additive) {
                this.additive.add(Objects.requireNonNull(additive, "additive"));
                return this;
            }

            /**
             * Sets {@code caloricDensity}.
             *
             * @param caloricDensity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder caloricDensity(Quantity caloricDensity) {
                this.caloricDensity = caloricDensity;
                return this;
            }

            /**
             * Sets {@code routeOfAdministration}.
             *
             * @param routeOfAdministration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder routeOfAdministration(CodeableConcept routeOfAdministration) {
                this.routeOfAdministration = routeOfAdministration;
                return this;
            }

            /**
             * Replaces all {@code administration} values.
             *
             * @param administration the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder administration(List<Administration> administration) {
                this.administration = administration == null ? new ArrayList<>() : new ArrayList<>(administration);
                return this;
            }

            /**
             * Adds a {@code administration} value.
             *
             * @param administration the value to add
             * @return this builder
             */
            public Builder addAdministration(Administration administration) {
                this.administration.add(Objects.requireNonNull(administration, "administration"));
                return this;
            }

            /**
             * Sets {@code maxVolumeToDeliver}.
             *
             * @param maxVolumeToDeliver the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder maxVolumeToDeliver(Quantity maxVolumeToDeliver) {
                this.maxVolumeToDeliver = maxVolumeToDeliver;
                return this;
            }

            /**
             * Sets {@code administrationInstruction}.
             *
             * @param administrationInstruction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder administrationInstruction(FhirMarkdown administrationInstruction) {
                this.administrationInstruction = administrationInstruction;
                return this;
            }

            /**
             * Sets {@code administrationInstruction}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param administrationInstruction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder administrationInstruction(String administrationInstruction) {
                return administrationInstruction(
                        administrationInstruction == null ? null : FhirMarkdown.of(administrationInstruction));
            }

            /**
             * Builds the {@code EnteralFormula}.
             *
             * @return the {@code EnteralFormula}
             */
            public EnteralFormula build() {
                return new EnteralFormula(
                        id, extension, modifierExtension, baseFormulaType, baseFormulaProductName, deliveryDevice,
                        additive, caloricDensity, routeOfAdministration, administration, maxVolumeToDeliver,
                        administrationInstruction);
            }
        }
    }

    /** Builder for {@link NutritionOrder}. Builders are mutable and not thread-safe. */
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
        private List<FhirUri> instantiates = new ArrayList<>();
        private List<Reference> basedOn = new ArrayList<>();
        private Identifier groupIdentifier;
        private FhirEnum<RequestStatus> status;
        private FhirEnum<RequestIntent> intent;
        private FhirEnum<RequestPriority> priority;
        private Reference subject;
        private Reference encounter;
        private List<Reference> supportingInformation = new ArrayList<>();
        private FhirDateTime dateTime;
        private Reference orderer;
        private List<CodeableReference> performer = new ArrayList<>();
        private List<Reference> allergyIntolerance = new ArrayList<>();
        private List<CodeableConcept> foodPreferenceModifier = new ArrayList<>();
        private List<CodeableConcept> excludeFoodModifier = new ArrayList<>();
        private FhirBoolean outsideFoodAllowed;
        private OralDiet oralDiet;
        private List<Supplement> supplement = new ArrayList<>();
        private EnteralFormula enteralFormula;
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(NutritionOrder original) {
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
            this.instantiates = new ArrayList<>(original.instantiates());
            this.basedOn = new ArrayList<>(original.basedOn());
            this.groupIdentifier = original.groupIdentifier();
            this.status = original.status();
            this.intent = original.intent();
            this.priority = original.priority();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.supportingInformation = new ArrayList<>(original.supportingInformation());
            this.dateTime = original.dateTime();
            this.orderer = original.orderer();
            this.performer = new ArrayList<>(original.performer());
            this.allergyIntolerance = new ArrayList<>(original.allergyIntolerance());
            this.foodPreferenceModifier = new ArrayList<>(original.foodPreferenceModifier());
            this.excludeFoodModifier = new ArrayList<>(original.excludeFoodModifier());
            this.outsideFoodAllowed = original.outsideFoodAllowed();
            this.oralDiet = original.oralDiet();
            this.supplement = new ArrayList<>(original.supplement());
            this.enteralFormula = original.enteralFormula();
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
         * Replaces all {@code instantiates} values.
         *
         * @param instantiates the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder instantiates(List<FhirUri> instantiates) {
            this.instantiates = instantiates == null ? new ArrayList<>() : new ArrayList<>(instantiates);
            return this;
        }

        /**
         * Adds a {@code instantiates} value.
         *
         * @param instantiates the value to add
         * @return this builder
         */
        public Builder addInstantiates(FhirUri instantiates) {
            this.instantiates.add(Objects.requireNonNull(instantiates, "instantiates"));
            return this;
        }

        /**
         * Adds a {@code instantiates} value, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param instantiates the value to add
         * @return this builder
         */
        public Builder addInstantiates(String instantiates) {
            return addInstantiates(FhirUri.of(instantiates));
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
         * Sets {@code groupIdentifier}.
         *
         * @param groupIdentifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder groupIdentifier(Identifier groupIdentifier) {
            this.groupIdentifier = groupIdentifier;
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<RequestStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(RequestStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code intent}.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(FhirEnum<RequestIntent> intent) {
            this.intent = intent;
            return this;
        }

        /**
         * Sets {@code intent}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(RequestIntent intent) {
            return intent(intent == null ? null : FhirEnum.of(intent));
        }

        /**
         * Sets {@code priority}.
         *
         * @param priority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priority(FhirEnum<RequestPriority> priority) {
            this.priority = priority;
            return this;
        }

        /**
         * Sets {@code priority}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param priority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priority(RequestPriority priority) {
            return priority(priority == null ? null : FhirEnum.of(priority));
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
         * Replaces all {@code supportingInformation} values.
         *
         * @param supportingInformation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supportingInformation(List<Reference> supportingInformation) {
            this.supportingInformation = supportingInformation == null
                    ? new ArrayList<>()
                    : new ArrayList<>(supportingInformation);
            return this;
        }

        /**
         * Adds a {@code supportingInformation} value.
         *
         * @param supportingInformation the value to add
         * @return this builder
         */
        public Builder addSupportingInformation(Reference supportingInformation) {
            this.supportingInformation.add(Objects.requireNonNull(supportingInformation, "supportingInformation"));
            return this;
        }

        /**
         * Sets {@code dateTime}.
         *
         * @param dateTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dateTime(FhirDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        /**
         * Sets {@code dateTime}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param dateTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dateTime(Temporal dateTime) {
            return dateTime(dateTime == null ? null : FhirDateTime.of(dateTime));
        }

        /**
         * Sets {@code orderer}.
         *
         * @param orderer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder orderer(Reference orderer) {
            this.orderer = orderer;
            return this;
        }

        /**
         * Replaces all {@code performer} values.
         *
         * @param performer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder performer(List<CodeableReference> performer) {
            this.performer = performer == null ? new ArrayList<>() : new ArrayList<>(performer);
            return this;
        }

        /**
         * Adds a {@code performer} value.
         *
         * @param performer the value to add
         * @return this builder
         */
        public Builder addPerformer(CodeableReference performer) {
            this.performer.add(Objects.requireNonNull(performer, "performer"));
            return this;
        }

        /**
         * Replaces all {@code allergyIntolerance} values.
         *
         * @param allergyIntolerance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder allergyIntolerance(List<Reference> allergyIntolerance) {
            this.allergyIntolerance = allergyIntolerance == null
                    ? new ArrayList<>()
                    : new ArrayList<>(allergyIntolerance);
            return this;
        }

        /**
         * Adds a {@code allergyIntolerance} value.
         *
         * @param allergyIntolerance the value to add
         * @return this builder
         */
        public Builder addAllergyIntolerance(Reference allergyIntolerance) {
            this.allergyIntolerance.add(Objects.requireNonNull(allergyIntolerance, "allergyIntolerance"));
            return this;
        }

        /**
         * Replaces all {@code foodPreferenceModifier} values.
         *
         * @param foodPreferenceModifier the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder foodPreferenceModifier(List<CodeableConcept> foodPreferenceModifier) {
            this.foodPreferenceModifier = foodPreferenceModifier == null
                    ? new ArrayList<>()
                    : new ArrayList<>(foodPreferenceModifier);
            return this;
        }

        /**
         * Adds a {@code foodPreferenceModifier} value.
         *
         * @param foodPreferenceModifier the value to add
         * @return this builder
         */
        public Builder addFoodPreferenceModifier(CodeableConcept foodPreferenceModifier) {
            this.foodPreferenceModifier.add(Objects.requireNonNull(foodPreferenceModifier, "foodPreferenceModifier"));
            return this;
        }

        /**
         * Replaces all {@code excludeFoodModifier} values.
         *
         * @param excludeFoodModifier the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder excludeFoodModifier(List<CodeableConcept> excludeFoodModifier) {
            this.excludeFoodModifier = excludeFoodModifier == null
                    ? new ArrayList<>()
                    : new ArrayList<>(excludeFoodModifier);
            return this;
        }

        /**
         * Adds a {@code excludeFoodModifier} value.
         *
         * @param excludeFoodModifier the value to add
         * @return this builder
         */
        public Builder addExcludeFoodModifier(CodeableConcept excludeFoodModifier) {
            this.excludeFoodModifier.add(Objects.requireNonNull(excludeFoodModifier, "excludeFoodModifier"));
            return this;
        }

        /**
         * Sets {@code outsideFoodAllowed}.
         *
         * @param outsideFoodAllowed the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outsideFoodAllowed(FhirBoolean outsideFoodAllowed) {
            this.outsideFoodAllowed = outsideFoodAllowed;
            return this;
        }

        /**
         * Sets {@code outsideFoodAllowed}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param outsideFoodAllowed the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outsideFoodAllowed(Boolean outsideFoodAllowed) {
            return outsideFoodAllowed(outsideFoodAllowed == null ? null : FhirBoolean.of(outsideFoodAllowed));
        }

        /**
         * Sets {@code oralDiet}.
         *
         * @param oralDiet the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder oralDiet(OralDiet oralDiet) {
            this.oralDiet = oralDiet;
            return this;
        }

        /**
         * Replaces all {@code supplement} values.
         *
         * @param supplement the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supplement(List<Supplement> supplement) {
            this.supplement = supplement == null ? new ArrayList<>() : new ArrayList<>(supplement);
            return this;
        }

        /**
         * Adds a {@code supplement} value.
         *
         * @param supplement the value to add
         * @return this builder
         */
        public Builder addSupplement(Supplement supplement) {
            this.supplement.add(Objects.requireNonNull(supplement, "supplement"));
            return this;
        }

        /**
         * Sets {@code enteralFormula}.
         *
         * @param enteralFormula the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder enteralFormula(EnteralFormula enteralFormula) {
            this.enteralFormula = enteralFormula;
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
         * Builds the {@code NutritionOrder}.
         *
         * @return the {@code NutritionOrder}
         * @throws NullPointerException if a required element is absent
         */
        public NutritionOrder build() {
            return new NutritionOrder(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiatesCanonical, instantiatesUri, instantiates, basedOn, groupIdentifier, status, intent,
                    priority, subject, encounter, supportingInformation, dateTime, orderer, performer,
                    allergyIntolerance, foodPreferenceModifier, excludeFoodModifier, outsideFoodAllowed, oralDiet,
                    supplement, enteralFormula, note);
        }
    }
}
