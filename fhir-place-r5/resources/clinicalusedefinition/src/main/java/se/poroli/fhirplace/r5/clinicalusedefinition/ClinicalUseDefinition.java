package se.poroli.fhirplace.r5.clinicalusedefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * A single issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal
 * product, medication, device or procedure.
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
 * @param identifier Business identifier for this issue.
 * @param type indication | contraindication | interaction | undesirable-effect | warning. Required.
 * @param category A categorisation of the issue, primarily for dividing warnings into subject heading areas such as
 *   "Pregnancy", "Overdose".
 * @param subject The medication, product, substance, device, procedure etc. for which this is an indication.
 *   Reference to MedicinalProductDefinition, Medication, ActivityDefinition, PlanDefinition, Device,
 *   DeviceDefinition, Substance, NutritionProduct, BiologicallyDerivedProduct.
 * @param status Whether this is a current issue or one that has been retired etc.
 * @param contraindication Specifics for when this is a contraindication.
 * @param indication Specifics for when this is an indication.
 * @param interaction Specifics for when this is an interaction.
 * @param population The population group to which this applies. Reference to Group.
 * @param library Logic used by the clinical use definition. Canonical reference to Library.
 * @param undesirableEffect A possible negative outcome from the use of this treatment.
 * @param warning Critical environmental, health or physical risks or hazards. For example 'Do not operate heavy
 *   machinery', 'May cause drowsiness'.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ClinicalUseDefinition">FHIR R5 ClinicalUseDefinition</a>
 */
public record ClinicalUseDefinition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<ClinicalUseDefinitionType> type,
        List<CodeableConcept> category,
        List<Reference> subject,
        CodeableConcept status,
        Contraindication contraindication,
        Indication indication,
        Interaction interaction,
        List<Reference> population,
        List<FhirCanonical> library,
        UndesirableEffect undesirableEffect,
        Warning warning) implements DomainResource {

    /**
     * Creates a {@code ClinicalUseDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public ClinicalUseDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        category = category == null ? List.of() : List.copyOf(category);
        subject = subject == null ? List.of() : List.copyOf(subject);
        population = population == null ? List.of() : List.copyOf(population);
        library = library == null ? List.of() : List.copyOf(library);
        Objects.requireNonNull(type, "ClinicalUseDefinition.type is required");
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
     * Returns a builder initialized with the values of this {@code ClinicalUseDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Specifics for when this is a contraindication.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param diseaseSymptomProcedure The situation that is being documented as contraindicating against this item.
     * @param diseaseStatus The status of the disease or symptom for the contraindication.
     * @param comorbidity A comorbidity (concurrent condition) or coinfection.
     * @param indication The indication which this is a contraidication for. Reference to ClinicalUseDefinition.
     * @param applicability An expression that returns true or false, indicating whether the indication is applicable
     *   or not, after having applied its other elements.
     * @param otherTherapy Information about use of the product in relation to other therapies described as part of
     *   the contraindication.
     */
    public record Contraindication(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference diseaseSymptomProcedure,
            CodeableReference diseaseStatus,
            List<CodeableReference> comorbidity,
            List<Reference> indication,
            Expression applicability,
            List<OtherTherapy> otherTherapy) implements BackboneElement {

        /**
         * Creates a {@code Contraindication}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Contraindication {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            comorbidity = comorbidity == null ? List.of() : List.copyOf(comorbidity);
            indication = indication == null ? List.of() : List.copyOf(indication);
            otherTherapy = otherTherapy == null ? List.of() : List.copyOf(otherTherapy);
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
         * Returns a builder initialized with the values of this {@code Contraindication}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Information about the use of the medicinal product in relation to other therapies described as part of the
         * contraindication.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param relationshipType The type of relationship between the product indication/contraindication and
         *   another therapy. Required.
         * @param treatment Reference to a specific medication, substance etc. as part of an indication or
         *   contraindication. Required.
         */
        public record OtherTherapy(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept relationshipType,
                CodeableReference treatment) implements BackboneElement {

            /**
             * Creates an {@code OtherTherapy}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public OtherTherapy {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(
                        relationshipType, "ClinicalUseDefinition.contraindication.otherTherapy.relationshipType is required");
                Objects.requireNonNull(
                        treatment, "ClinicalUseDefinition.contraindication.otherTherapy.treatment is required");
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
             * Returns a builder initialized with the values of this {@code OtherTherapy}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link OtherTherapy}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept relationshipType;
                private CodeableReference treatment;

                private Builder() {
                }

                private Builder(OtherTherapy original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.relationshipType = original.relationshipType();
                    this.treatment = original.treatment();
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
                 * Sets {@code relationshipType}.
                 *
                 * @param relationshipType the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relationshipType(CodeableConcept relationshipType) {
                    this.relationshipType = relationshipType;
                    return this;
                }

                /**
                 * Sets {@code treatment}.
                 *
                 * @param treatment the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder treatment(CodeableReference treatment) {
                    this.treatment = treatment;
                    return this;
                }

                /**
                 * Builds the {@code OtherTherapy}.
                 *
                 * @return the {@code OtherTherapy}
                 * @throws NullPointerException if a required element is absent
                 */
                public OtherTherapy build() {
                    return new OtherTherapy(
                            id, extension, modifierExtension, relationshipType, treatment);
                }
            }
        }

        /** Builder for {@link Contraindication}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference diseaseSymptomProcedure;
            private CodeableReference diseaseStatus;
            private List<CodeableReference> comorbidity = new ArrayList<>();
            private List<Reference> indication = new ArrayList<>();
            private Expression applicability;
            private List<OtherTherapy> otherTherapy = new ArrayList<>();

            private Builder() {
            }

            private Builder(Contraindication original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.diseaseSymptomProcedure = original.diseaseSymptomProcedure();
                this.diseaseStatus = original.diseaseStatus();
                this.comorbidity = new ArrayList<>(original.comorbidity());
                this.indication = new ArrayList<>(original.indication());
                this.applicability = original.applicability();
                this.otherTherapy = new ArrayList<>(original.otherTherapy());
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
             * Sets {@code diseaseSymptomProcedure}.
             *
             * @param diseaseSymptomProcedure the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder diseaseSymptomProcedure(CodeableReference diseaseSymptomProcedure) {
                this.diseaseSymptomProcedure = diseaseSymptomProcedure;
                return this;
            }

            /**
             * Sets {@code diseaseStatus}.
             *
             * @param diseaseStatus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder diseaseStatus(CodeableReference diseaseStatus) {
                this.diseaseStatus = diseaseStatus;
                return this;
            }

            /**
             * Replaces all {@code comorbidity} values.
             *
             * @param comorbidity the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder comorbidity(List<CodeableReference> comorbidity) {
                this.comorbidity = comorbidity == null ? new ArrayList<>() : new ArrayList<>(comorbidity);
                return this;
            }

            /**
             * Adds a {@code comorbidity} value.
             *
             * @param comorbidity the value to add
             * @return this builder
             */
            public Builder addComorbidity(CodeableReference comorbidity) {
                this.comorbidity.add(Objects.requireNonNull(comorbidity, "comorbidity"));
                return this;
            }

            /**
             * Replaces all {@code indication} values.
             *
             * @param indication the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder indication(List<Reference> indication) {
                this.indication = indication == null ? new ArrayList<>() : new ArrayList<>(indication);
                return this;
            }

            /**
             * Adds a {@code indication} value.
             *
             * @param indication the value to add
             * @return this builder
             */
            public Builder addIndication(Reference indication) {
                this.indication.add(Objects.requireNonNull(indication, "indication"));
                return this;
            }

            /**
             * Sets {@code applicability}.
             *
             * @param applicability the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder applicability(Expression applicability) {
                this.applicability = applicability;
                return this;
            }

            /**
             * Replaces all {@code otherTherapy} values.
             *
             * @param otherTherapy the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder otherTherapy(List<OtherTherapy> otherTherapy) {
                this.otherTherapy = otherTherapy == null ? new ArrayList<>() : new ArrayList<>(otherTherapy);
                return this;
            }

            /**
             * Adds a {@code otherTherapy} value.
             *
             * @param otherTherapy the value to add
             * @return this builder
             */
            public Builder addOtherTherapy(OtherTherapy otherTherapy) {
                this.otherTherapy.add(Objects.requireNonNull(otherTherapy, "otherTherapy"));
                return this;
            }

            /**
             * Builds the {@code Contraindication}.
             *
             * @return the {@code Contraindication}
             */
            public Contraindication build() {
                return new Contraindication(
                        id, extension, modifierExtension, diseaseSymptomProcedure, diseaseStatus, comorbidity,
                        indication, applicability, otherTherapy);
            }
        }
    }

    /**
     * Specifics for when this is an indication.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param diseaseSymptomProcedure The situation that is being documented as an indicaton for this item.
     * @param diseaseStatus The status of the disease or symptom for the indication.
     * @param comorbidity A comorbidity or coinfection as part of the indication.
     * @param intendedEffect The intended effect, aim or strategy to be achieved.
     * @param duration Timing or duration information. One of Range, string.
     * @param undesirableEffect An unwanted side effect or negative outcome of the subject of this resource when being
     *   used for this indication. Reference to ClinicalUseDefinition.
     * @param applicability An expression that returns true or false, indicating whether the indication is applicable
     *   or not, after having applied its other elements.
     * @param otherTherapy The use of the medicinal product in relation to other therapies described as part of the
     *   indication.
     */
    public record Indication(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference diseaseSymptomProcedure,
            CodeableReference diseaseStatus,
            List<CodeableReference> comorbidity,
            CodeableReference intendedEffect,
            DataType duration,
            List<Reference> undesirableEffect,
            Expression applicability,
            List<ClinicalUseDefinition.Contraindication.OtherTherapy> otherTherapy) implements BackboneElement {

        /**
         * Creates an {@code Indication}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Indication {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            comorbidity = comorbidity == null ? List.of() : List.copyOf(comorbidity);
            undesirableEffect = undesirableEffect == null ? List.of() : List.copyOf(undesirableEffect);
            otherTherapy = otherTherapy == null ? List.of() : List.copyOf(otherTherapy);
            if (duration != null && !(duration instanceof Range || duration instanceof FhirString)) {
                throw new IllegalArgumentException(
                        "ClinicalUseDefinition.indication.duration[x] must be one of Range, string, but was "
                                + duration.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Indication}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Indication}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference diseaseSymptomProcedure;
            private CodeableReference diseaseStatus;
            private List<CodeableReference> comorbidity = new ArrayList<>();
            private CodeableReference intendedEffect;
            private DataType duration;
            private List<Reference> undesirableEffect = new ArrayList<>();
            private Expression applicability;
            private List<ClinicalUseDefinition.Contraindication.OtherTherapy> otherTherapy = new ArrayList<>();

            private Builder() {
            }

            private Builder(Indication original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.diseaseSymptomProcedure = original.diseaseSymptomProcedure();
                this.diseaseStatus = original.diseaseStatus();
                this.comorbidity = new ArrayList<>(original.comorbidity());
                this.intendedEffect = original.intendedEffect();
                this.duration = original.duration();
                this.undesirableEffect = new ArrayList<>(original.undesirableEffect());
                this.applicability = original.applicability();
                this.otherTherapy = new ArrayList<>(original.otherTherapy());
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
             * Sets {@code diseaseSymptomProcedure}.
             *
             * @param diseaseSymptomProcedure the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder diseaseSymptomProcedure(CodeableReference diseaseSymptomProcedure) {
                this.diseaseSymptomProcedure = diseaseSymptomProcedure;
                return this;
            }

            /**
             * Sets {@code diseaseStatus}.
             *
             * @param diseaseStatus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder diseaseStatus(CodeableReference diseaseStatus) {
                this.diseaseStatus = diseaseStatus;
                return this;
            }

            /**
             * Replaces all {@code comorbidity} values.
             *
             * @param comorbidity the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder comorbidity(List<CodeableReference> comorbidity) {
                this.comorbidity = comorbidity == null ? new ArrayList<>() : new ArrayList<>(comorbidity);
                return this;
            }

            /**
             * Adds a {@code comorbidity} value.
             *
             * @param comorbidity the value to add
             * @return this builder
             */
            public Builder addComorbidity(CodeableReference comorbidity) {
                this.comorbidity.add(Objects.requireNonNull(comorbidity, "comorbidity"));
                return this;
            }

            /**
             * Sets {@code intendedEffect}.
             *
             * @param intendedEffect the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder intendedEffect(CodeableReference intendedEffect) {
                this.intendedEffect = intendedEffect;
                return this;
            }

            /**
             * Sets {@code duration} to a Range.
             *
             * @param duration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder duration(Range duration) {
                this.duration = duration;
                return this;
            }

            /**
             * Sets {@code duration} to a string.
             *
             * @param duration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder duration(FhirString duration) {
                this.duration = duration;
                return this;
            }

            /**
             * Sets {@code duration} to a string without id or extensions.
             *
             * @param duration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder duration(String duration) {
                this.duration = duration == null ? null : FhirString.of(duration);
                return this;
            }

            /**
             * Replaces all {@code undesirableEffect} values.
             *
             * @param undesirableEffect the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder undesirableEffect(List<Reference> undesirableEffect) {
                this.undesirableEffect = undesirableEffect == null
                        ? new ArrayList<>()
                        : new ArrayList<>(undesirableEffect);
                return this;
            }

            /**
             * Adds a {@code undesirableEffect} value.
             *
             * @param undesirableEffect the value to add
             * @return this builder
             */
            public Builder addUndesirableEffect(Reference undesirableEffect) {
                this.undesirableEffect.add(Objects.requireNonNull(undesirableEffect, "undesirableEffect"));
                return this;
            }

            /**
             * Sets {@code applicability}.
             *
             * @param applicability the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder applicability(Expression applicability) {
                this.applicability = applicability;
                return this;
            }

            /**
             * Replaces all {@code otherTherapy} values.
             *
             * @param otherTherapy the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder otherTherapy(List<ClinicalUseDefinition.Contraindication.OtherTherapy> otherTherapy) {
                this.otherTherapy = otherTherapy == null ? new ArrayList<>() : new ArrayList<>(otherTherapy);
                return this;
            }

            /**
             * Adds a {@code otherTherapy} value.
             *
             * @param otherTherapy the value to add
             * @return this builder
             */
            public Builder addOtherTherapy(ClinicalUseDefinition.Contraindication.OtherTherapy otherTherapy) {
                this.otherTherapy.add(Objects.requireNonNull(otherTherapy, "otherTherapy"));
                return this;
            }

            /**
             * Builds the {@code Indication}.
             *
             * @return the {@code Indication}
             */
            public Indication build() {
                return new Indication(
                        id, extension, modifierExtension, diseaseSymptomProcedure, diseaseStatus, comorbidity,
                        intendedEffect, duration, undesirableEffect, applicability, otherTherapy);
            }
        }
    }

    /**
     * Specifics for when this is an interaction.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param interactant The specific medication, product, food etc. or laboratory test that interacts.
     * @param type The type of the interaction e.g. drug-drug interaction, drug-lab test interaction.
     * @param effect The effect of the interaction, for example "reduced gastric absorption of primary medication".
     * @param incidence The incidence of the interaction, e.g. theoretical, observed.
     * @param management Actions for managing the interaction.
     */
    public record Interaction(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Interactant> interactant,
            CodeableConcept type,
            CodeableReference effect,
            CodeableConcept incidence,
            List<CodeableConcept> management) implements BackboneElement {

        /**
         * Creates an {@code Interaction}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Interaction {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            interactant = interactant == null ? List.of() : List.copyOf(interactant);
            management = management == null ? List.of() : List.copyOf(management);
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
         * Returns a builder initialized with the values of this {@code Interaction}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The specific medication, product, food, substance etc. or laboratory test that interacts.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param item The specific medication, product, food etc. or laboratory test that interacts. One of
         *   Reference, CodeableConcept. Required.
         */
        public record Interactant(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                DataType item) implements BackboneElement {

            /**
             * Creates an {@code Interactant}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Interactant {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(item, "ClinicalUseDefinition.interaction.interactant.item is required");
                if (item != null && !(item instanceof Reference || item instanceof CodeableConcept)) {
                    throw new IllegalArgumentException(
                            "ClinicalUseDefinition.interaction.interactant.item[x] does not allow "
                                    + item.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code Interactant}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Interactant}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private DataType item;

                private Builder() {
                }

                private Builder(Interactant original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.item = original.item();
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
                 * Sets {@code item} to a Reference.
                 *
                 * @param item the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder item(Reference item) {
                    this.item = item;
                    return this;
                }

                /**
                 * Sets {@code item} to a CodeableConcept.
                 *
                 * @param item the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder item(CodeableConcept item) {
                    this.item = item;
                    return this;
                }

                /**
                 * Builds the {@code Interactant}.
                 *
                 * @return the {@code Interactant}
                 * @throws NullPointerException if a required element is absent
                 */
                public Interactant build() {
                    return new Interactant(
                            id, extension, modifierExtension, item);
                }
            }
        }

        /** Builder for {@link Interaction}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Interactant> interactant = new ArrayList<>();
            private CodeableConcept type;
            private CodeableReference effect;
            private CodeableConcept incidence;
            private List<CodeableConcept> management = new ArrayList<>();

            private Builder() {
            }

            private Builder(Interaction original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.interactant = new ArrayList<>(original.interactant());
                this.type = original.type();
                this.effect = original.effect();
                this.incidence = original.incidence();
                this.management = new ArrayList<>(original.management());
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
             * Replaces all {@code interactant} values.
             *
             * @param interactant the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder interactant(List<Interactant> interactant) {
                this.interactant = interactant == null ? new ArrayList<>() : new ArrayList<>(interactant);
                return this;
            }

            /**
             * Adds a {@code interactant} value.
             *
             * @param interactant the value to add
             * @return this builder
             */
            public Builder addInteractant(Interactant interactant) {
                this.interactant.add(Objects.requireNonNull(interactant, "interactant"));
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
             * Sets {@code effect}.
             *
             * @param effect the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder effect(CodeableReference effect) {
                this.effect = effect;
                return this;
            }

            /**
             * Sets {@code incidence}.
             *
             * @param incidence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder incidence(CodeableConcept incidence) {
                this.incidence = incidence;
                return this;
            }

            /**
             * Replaces all {@code management} values.
             *
             * @param management the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder management(List<CodeableConcept> management) {
                this.management = management == null ? new ArrayList<>() : new ArrayList<>(management);
                return this;
            }

            /**
             * Adds a {@code management} value.
             *
             * @param management the value to add
             * @return this builder
             */
            public Builder addManagement(CodeableConcept management) {
                this.management.add(Objects.requireNonNull(management, "management"));
                return this;
            }

            /**
             * Builds the {@code Interaction}.
             *
             * @return the {@code Interaction}
             */
            public Interaction build() {
                return new Interaction(
                        id, extension, modifierExtension, interactant, type, effect, incidence, management);
            }
        }
    }

    /**
     * Describe the possible undesirable effects (negative outcomes) from the use of the medicinal product as
     * treatment.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param symptomConditionEffect The situation in which the undesirable effect may manifest.
     * @param classification High level classification of the effect.
     * @param frequencyOfOccurrence How often the effect is seen.
     */
    public record UndesirableEffect(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference symptomConditionEffect,
            CodeableConcept classification,
            CodeableConcept frequencyOfOccurrence) implements BackboneElement {

        /**
         * Creates an {@code UndesirableEffect}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public UndesirableEffect {
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
         * Returns a builder initialized with the values of this {@code UndesirableEffect}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link UndesirableEffect}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference symptomConditionEffect;
            private CodeableConcept classification;
            private CodeableConcept frequencyOfOccurrence;

            private Builder() {
            }

            private Builder(UndesirableEffect original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.symptomConditionEffect = original.symptomConditionEffect();
                this.classification = original.classification();
                this.frequencyOfOccurrence = original.frequencyOfOccurrence();
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
             * Sets {@code symptomConditionEffect}.
             *
             * @param symptomConditionEffect the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder symptomConditionEffect(CodeableReference symptomConditionEffect) {
                this.symptomConditionEffect = symptomConditionEffect;
                return this;
            }

            /**
             * Sets {@code classification}.
             *
             * @param classification the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder classification(CodeableConcept classification) {
                this.classification = classification;
                return this;
            }

            /**
             * Sets {@code frequencyOfOccurrence}.
             *
             * @param frequencyOfOccurrence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder frequencyOfOccurrence(CodeableConcept frequencyOfOccurrence) {
                this.frequencyOfOccurrence = frequencyOfOccurrence;
                return this;
            }

            /**
             * Builds the {@code UndesirableEffect}.
             *
             * @return the {@code UndesirableEffect}
             */
            public UndesirableEffect build() {
                return new UndesirableEffect(
                        id, extension, modifierExtension, symptomConditionEffect, classification,
                        frequencyOfOccurrence);
            }
        }
    }

    /**
     * A critical piece of information about environmental, health or physical risks or hazards that serve as caution
     * to the user.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param description A textual definition of this warning, with formatting.
     * @param code A coded or unformatted textual definition of this warning.
     */
    public record Warning(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirMarkdown description,
            CodeableConcept code) implements BackboneElement {

        /**
         * Creates a {@code Warning}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Warning {
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
         * Returns a builder initialized with the values of this {@code Warning}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Warning}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirMarkdown description;
            private CodeableConcept code;

            private Builder() {
            }

            private Builder(Warning original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.description = original.description();
                this.code = original.code();
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
             * Builds the {@code Warning}.
             *
             * @return the {@code Warning}
             */
            public Warning build() {
                return new Warning(
                        id, extension, modifierExtension, description, code);
            }
        }
    }

    /** Builder for {@link ClinicalUseDefinition}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<ClinicalUseDefinitionType> type;
        private List<CodeableConcept> category = new ArrayList<>();
        private List<Reference> subject = new ArrayList<>();
        private CodeableConcept status;
        private Contraindication contraindication;
        private Indication indication;
        private Interaction interaction;
        private List<Reference> population = new ArrayList<>();
        private List<FhirCanonical> library = new ArrayList<>();
        private UndesirableEffect undesirableEffect;
        private Warning warning;

        private Builder() {
        }

        private Builder(ClinicalUseDefinition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.type = original.type();
            this.category = new ArrayList<>(original.category());
            this.subject = new ArrayList<>(original.subject());
            this.status = original.status();
            this.contraindication = original.contraindication();
            this.indication = original.indication();
            this.interaction = original.interaction();
            this.population = new ArrayList<>(original.population());
            this.library = new ArrayList<>(original.library());
            this.undesirableEffect = original.undesirableEffect();
            this.warning = original.warning();
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
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<ClinicalUseDefinitionType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(ClinicalUseDefinitionType type) {
            return type(type == null ? null : FhirEnum.of(type));
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
         * Replaces all {@code subject} values.
         *
         * @param subject the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder subject(List<Reference> subject) {
            this.subject = subject == null ? new ArrayList<>() : new ArrayList<>(subject);
            return this;
        }

        /**
         * Adds a {@code subject} value.
         *
         * @param subject the value to add
         * @return this builder
         */
        public Builder addSubject(Reference subject) {
            this.subject.add(Objects.requireNonNull(subject, "subject"));
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
         * Sets {@code contraindication}.
         *
         * @param contraindication the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder contraindication(Contraindication contraindication) {
            this.contraindication = contraindication;
            return this;
        }

        /**
         * Sets {@code indication}.
         *
         * @param indication the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder indication(Indication indication) {
            this.indication = indication;
            return this;
        }

        /**
         * Sets {@code interaction}.
         *
         * @param interaction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder interaction(Interaction interaction) {
            this.interaction = interaction;
            return this;
        }

        /**
         * Replaces all {@code population} values.
         *
         * @param population the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder population(List<Reference> population) {
            this.population = population == null ? new ArrayList<>() : new ArrayList<>(population);
            return this;
        }

        /**
         * Adds a {@code population} value.
         *
         * @param population the value to add
         * @return this builder
         */
        public Builder addPopulation(Reference population) {
            this.population.add(Objects.requireNonNull(population, "population"));
            return this;
        }

        /**
         * Replaces all {@code library} values.
         *
         * @param library the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder library(List<FhirCanonical> library) {
            this.library = library == null ? new ArrayList<>() : new ArrayList<>(library);
            return this;
        }

        /**
         * Adds a {@code library} value.
         *
         * @param library the value to add
         * @return this builder
         */
        public Builder addLibrary(FhirCanonical library) {
            this.library.add(Objects.requireNonNull(library, "library"));
            return this;
        }

        /**
         * Adds a {@code library} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param library the value to add
         * @return this builder
         */
        public Builder addLibrary(String library) {
            return addLibrary(FhirCanonical.of(library));
        }

        /**
         * Sets {@code undesirableEffect}.
         *
         * @param undesirableEffect the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder undesirableEffect(UndesirableEffect undesirableEffect) {
            this.undesirableEffect = undesirableEffect;
            return this;
        }

        /**
         * Sets {@code warning}.
         *
         * @param warning the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder warning(Warning warning) {
            this.warning = warning;
            return this;
        }

        /**
         * Builds the {@code ClinicalUseDefinition}.
         *
         * @return the {@code ClinicalUseDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public ClinicalUseDefinition build() {
            return new ClinicalUseDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    type, category, subject, status, contraindication, indication, interaction, population, library,
                    undesirableEffect, warning);
        }
    }
}
