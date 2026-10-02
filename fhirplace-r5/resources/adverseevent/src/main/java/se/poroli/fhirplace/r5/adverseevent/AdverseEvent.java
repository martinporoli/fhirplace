package se.poroli.fhirplace.r5.adverseevent;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or
 * research participant.
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
 * @param identifier Business identifier for the event.
 * @param status in-progress | completed | entered-in-error | unknown. Required. Modifier element.
 * @param actuality actual | potential. Required. Modifier element.
 * @param category wrong-patient | procedure-mishap | medication-mishap | device | unsafe-physical-environment |
 *   hospital-aquired-infection | wrong-body-site.
 * @param code Event or incident that occurred or was averted.
 * @param subject Subject impacted by event. Reference to Patient, Group, Practitioner, RelatedPerson,
 *   ResearchSubject. Required.
 * @param encounter The Encounter associated with the start of the AdverseEvent. Reference to Encounter.
 * @param occurrence When the event occurred. One of dateTime, Period, Timing.
 * @param detected When the event was detected.
 * @param recordedDate When the event was recorded.
 * @param resultingEffect Effect on the subject due to this event. Reference to Condition, Observation.
 * @param location Location where adverse event occurred. Reference to Location.
 * @param seriousness Seriousness or gravity of the event.
 * @param outcome Type of outcome from the adverse event.
 * @param recorder Who recorded the adverse event. Reference to Patient, Practitioner, PractitionerRole,
 *   RelatedPerson, ResearchSubject.
 * @param participant Who was involved in the adverse event or the potential adverse event and what they did.
 * @param study Research study that the subject is enrolled in. Reference to ResearchStudy.
 * @param expectedInResearchStudy Considered likely or probable or anticipated in the research study.
 * @param suspectEntity The suspected agent causing the adverse event.
 * @param contributingFactor Contributing factors suspected to have increased the probability or severity of the
 *   adverse event.
 * @param preventiveAction Preventive actions that contributed to avoiding the adverse event.
 * @param mitigatingAction Ameliorating actions taken after the adverse event occured in order to reduce the extent of
 *   harm.
 * @param supportingInfo Supporting information relevant to the event.
 * @param note Comment on adverse event.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/AdverseEvent">FHIR R5 AdverseEvent</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record AdverseEvent(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<AdverseEventStatus> status,
        FhirEnum<AdverseEventActuality> actuality,
        List<CodeableConcept> category,
        CodeableConcept code,
        Reference subject,
        Reference encounter,
        DataType occurrence,
        FhirDateTime detected,
        FhirDateTime recordedDate,
        List<Reference> resultingEffect,
        Reference location,
        CodeableConcept seriousness,
        List<CodeableConcept> outcome,
        Reference recorder,
        List<Participant> participant,
        List<Reference> study,
        FhirBoolean expectedInResearchStudy,
        List<SuspectEntity> suspectEntity,
        List<ContributingFactor> contributingFactor,
        List<PreventiveAction> preventiveAction,
        List<MitigatingAction> mitigatingAction,
        List<SupportingInfo> supportingInfo,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates an {@code AdverseEvent}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public AdverseEvent {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        category = category == null ? List.of() : List.copyOf(category);
        resultingEffect = resultingEffect == null ? List.of() : List.copyOf(resultingEffect);
        outcome = outcome == null ? List.of() : List.copyOf(outcome);
        participant = participant == null ? List.of() : List.copyOf(participant);
        study = study == null ? List.of() : List.copyOf(study);
        suspectEntity = suspectEntity == null ? List.of() : List.copyOf(suspectEntity);
        contributingFactor = contributingFactor == null ? List.of() : List.copyOf(contributingFactor);
        preventiveAction = preventiveAction == null ? List.of() : List.copyOf(preventiveAction);
        mitigatingAction = mitigatingAction == null ? List.of() : List.copyOf(mitigatingAction);
        supportingInfo = supportingInfo == null ? List.of() : List.copyOf(supportingInfo);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "AdverseEvent.status is required");
        Objects.requireNonNull(actuality, "AdverseEvent.actuality is required");
        Objects.requireNonNull(subject, "AdverseEvent.subject is required");
        if (occurrence != null && !(occurrence instanceof FhirDateTime
                || occurrence instanceof Period
                || occurrence instanceof Timing)) {
            throw new IllegalArgumentException(
                    "AdverseEvent.occurrence[x] must be one of dateTime, Period, Timing, but was "
                            + occurrence.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code AdverseEvent}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates who or what participated in the adverse event and how they were involved.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function Type of involvement.
     * @param actor Who was involved in the adverse event or the potential adverse event. Reference to Practitioner,
     *   PractitionerRole, Organization, CareTeam, Patient, Device, RelatedPerson, ResearchSubject. Required.
     */
    public record Participant(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept function,
            Reference actor) implements BackboneElement {

        /**
         * Creates a {@code Participant}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Participant {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(actor, "AdverseEvent.participant.actor is required");
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
         * Returns a builder initialized with the values of this {@code Participant}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Participant}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept function;
            private Reference actor;

            private Builder() {
            }

            private Builder(Participant original) {
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
             * Builds the {@code Participant}.
             *
             * @return the {@code Participant}
             * @throws NullPointerException if a required element is absent
             */
            public Participant build() {
                return new Participant(
                        id, extension, modifierExtension, function, actor);
            }
        }
    }

    /**
     * Describes the entity that is suspected to have caused the adverse event.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param instance Refers to the specific entity that caused the adverse event. One of CodeableConcept, Reference.
     *   Required.
     * @param causality Information on the possible cause of the event.
     */
    public record SuspectEntity(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType instance,
            Causality causality) implements BackboneElement {

        /**
         * Creates a {@code SuspectEntity}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public SuspectEntity {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(instance, "AdverseEvent.suspectEntity.instance is required");
            if (instance != null && !(instance instanceof CodeableConcept || instance instanceof Reference)) {
                throw new IllegalArgumentException(
                        "AdverseEvent.suspectEntity.instance[x] must be one of CodeableConcept, Reference, but was "
                                + instance.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code SuspectEntity}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Information on the possible cause of the event.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param assessmentMethod Method of evaluating the relatedness of the suspected entity to the event.
         * @param entityRelatedness Result of the assessment regarding the relatedness of the suspected entity to the
         *   event.
         * @param author Author of the information on the possible cause of the event. Reference to Practitioner,
         *   PractitionerRole, Patient, RelatedPerson, ResearchSubject.
         */
        public record Causality(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept assessmentMethod,
                CodeableConcept entityRelatedness,
                Reference author) implements BackboneElement {

            /**
             * Creates a {@code Causality}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Causality {
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
             * Returns a builder initialized with the values of this {@code Causality}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Causality}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept assessmentMethod;
                private CodeableConcept entityRelatedness;
                private Reference author;

                private Builder() {
                }

                private Builder(Causality original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.assessmentMethod = original.assessmentMethod();
                    this.entityRelatedness = original.entityRelatedness();
                    this.author = original.author();
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
                 * Sets {@code assessmentMethod}.
                 *
                 * @param assessmentMethod the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder assessmentMethod(CodeableConcept assessmentMethod) {
                    this.assessmentMethod = assessmentMethod;
                    return this;
                }

                /**
                 * Sets {@code entityRelatedness}.
                 *
                 * @param entityRelatedness the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder entityRelatedness(CodeableConcept entityRelatedness) {
                    this.entityRelatedness = entityRelatedness;
                    return this;
                }

                /**
                 * Sets {@code author}.
                 *
                 * @param author the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder author(Reference author) {
                    this.author = author;
                    return this;
                }

                /**
                 * Builds the {@code Causality}.
                 *
                 * @return the {@code Causality}
                 */
                public Causality build() {
                    return new Causality(
                            id, extension, modifierExtension, assessmentMethod, entityRelatedness, author);
                }
            }
        }

        /** Builder for {@link SuspectEntity}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType instance;
            private Causality causality;

            private Builder() {
            }

            private Builder(SuspectEntity original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.instance = original.instance();
                this.causality = original.causality();
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
             * Sets {@code instance} to a CodeableConcept.
             *
             * @param instance the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instance(CodeableConcept instance) {
                this.instance = instance;
                return this;
            }

            /**
             * Sets {@code instance} to a Reference.
             *
             * @param instance the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instance(Reference instance) {
                this.instance = instance;
                return this;
            }

            /**
             * Sets {@code causality}.
             *
             * @param causality the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder causality(Causality causality) {
                this.causality = causality;
                return this;
            }

            /**
             * Builds the {@code SuspectEntity}.
             *
             * @return the {@code SuspectEntity}
             * @throws NullPointerException if a required element is absent
             */
            public SuspectEntity build() {
                return new SuspectEntity(
                        id, extension, modifierExtension, instance, causality);
            }
        }
    }

    /**
     * The contributing factors suspected to have increased the probability or severity of the adverse event.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param item Item suspected to have increased the probability or severity of the adverse event. One of
     *   Reference, CodeableConcept. Required.
     */
    public record ContributingFactor(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType item) implements BackboneElement {

        /**
         * Creates a {@code ContributingFactor}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public ContributingFactor {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(item, "AdverseEvent.contributingFactor.item is required");
            if (item != null && !(item instanceof Reference || item instanceof CodeableConcept)) {
                throw new IllegalArgumentException(
                        "AdverseEvent.contributingFactor.item[x] must be one of Reference, CodeableConcept, but was "
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
         * Returns a builder initialized with the values of this {@code ContributingFactor}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ContributingFactor}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType item;

            private Builder() {
            }

            private Builder(ContributingFactor original) {
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
             * Builds the {@code ContributingFactor}.
             *
             * @return the {@code ContributingFactor}
             * @throws NullPointerException if a required element is absent
             */
            public ContributingFactor build() {
                return new ContributingFactor(
                        id, extension, modifierExtension, item);
            }
        }
    }

    /**
     * Preventive actions that contributed to avoiding the adverse event.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param item Action that contributed to avoiding the adverse event. One of Reference, CodeableConcept. Required.
     */
    public record PreventiveAction(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType item) implements BackboneElement {

        /**
         * Creates a {@code PreventiveAction}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public PreventiveAction {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(item, "AdverseEvent.preventiveAction.item is required");
            if (item != null && !(item instanceof Reference || item instanceof CodeableConcept)) {
                throw new IllegalArgumentException(
                        "AdverseEvent.preventiveAction.item[x] must be one of Reference, CodeableConcept, but was "
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
         * Returns a builder initialized with the values of this {@code PreventiveAction}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link PreventiveAction}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType item;

            private Builder() {
            }

            private Builder(PreventiveAction original) {
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
             * Builds the {@code PreventiveAction}.
             *
             * @return the {@code PreventiveAction}
             * @throws NullPointerException if a required element is absent
             */
            public PreventiveAction build() {
                return new PreventiveAction(
                        id, extension, modifierExtension, item);
            }
        }
    }

    /**
     * The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param item Ameliorating action taken after the adverse event occured in order to reduce the extent of harm.
     *   One of Reference, CodeableConcept. Required.
     */
    public record MitigatingAction(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType item) implements BackboneElement {

        /**
         * Creates a {@code MitigatingAction}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public MitigatingAction {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(item, "AdverseEvent.mitigatingAction.item is required");
            if (item != null && !(item instanceof Reference || item instanceof CodeableConcept)) {
                throw new IllegalArgumentException(
                        "AdverseEvent.mitigatingAction.item[x] must be one of Reference, CodeableConcept, but was "
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
         * Returns a builder initialized with the values of this {@code MitigatingAction}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link MitigatingAction}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType item;

            private Builder() {
            }

            private Builder(MitigatingAction original) {
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
             * Builds the {@code MitigatingAction}.
             *
             * @return the {@code MitigatingAction}
             * @throws NullPointerException if a required element is absent
             */
            public MitigatingAction build() {
                return new MitigatingAction(
                        id, extension, modifierExtension, item);
            }
        }
    }

    /**
     * Supporting information relevant to the event.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param item Subject medical history or document relevant to this adverse event. One of Reference,
     *   CodeableConcept. Required.
     */
    public record SupportingInfo(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType item) implements BackboneElement {

        /**
         * Creates a {@code SupportingInfo}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public SupportingInfo {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(item, "AdverseEvent.supportingInfo.item is required");
            if (item != null && !(item instanceof Reference || item instanceof CodeableConcept)) {
                throw new IllegalArgumentException(
                        "AdverseEvent.supportingInfo.item[x] must be one of Reference, CodeableConcept, but was "
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
         * Returns a builder initialized with the values of this {@code SupportingInfo}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link SupportingInfo}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType item;

            private Builder() {
            }

            private Builder(SupportingInfo original) {
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
             * Builds the {@code SupportingInfo}.
             *
             * @return the {@code SupportingInfo}
             * @throws NullPointerException if a required element is absent
             */
            public SupportingInfo build() {
                return new SupportingInfo(
                        id, extension, modifierExtension, item);
            }
        }
    }

    /** Builder for {@link AdverseEvent}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<AdverseEventStatus> status;
        private FhirEnum<AdverseEventActuality> actuality;
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableConcept code;
        private Reference subject;
        private Reference encounter;
        private DataType occurrence;
        private FhirDateTime detected;
        private FhirDateTime recordedDate;
        private List<Reference> resultingEffect = new ArrayList<>();
        private Reference location;
        private CodeableConcept seriousness;
        private List<CodeableConcept> outcome = new ArrayList<>();
        private Reference recorder;
        private List<Participant> participant = new ArrayList<>();
        private List<Reference> study = new ArrayList<>();
        private FhirBoolean expectedInResearchStudy;
        private List<SuspectEntity> suspectEntity = new ArrayList<>();
        private List<ContributingFactor> contributingFactor = new ArrayList<>();
        private List<PreventiveAction> preventiveAction = new ArrayList<>();
        private List<MitigatingAction> mitigatingAction = new ArrayList<>();
        private List<SupportingInfo> supportingInfo = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(AdverseEvent original) {
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
            this.actuality = original.actuality();
            this.category = new ArrayList<>(original.category());
            this.code = original.code();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.occurrence = original.occurrence();
            this.detected = original.detected();
            this.recordedDate = original.recordedDate();
            this.resultingEffect = new ArrayList<>(original.resultingEffect());
            this.location = original.location();
            this.seriousness = original.seriousness();
            this.outcome = new ArrayList<>(original.outcome());
            this.recorder = original.recorder();
            this.participant = new ArrayList<>(original.participant());
            this.study = new ArrayList<>(original.study());
            this.expectedInResearchStudy = original.expectedInResearchStudy();
            this.suspectEntity = new ArrayList<>(original.suspectEntity());
            this.contributingFactor = new ArrayList<>(original.contributingFactor());
            this.preventiveAction = new ArrayList<>(original.preventiveAction());
            this.mitigatingAction = new ArrayList<>(original.mitigatingAction());
            this.supportingInfo = new ArrayList<>(original.supportingInfo());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<AdverseEventStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(AdverseEventStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code actuality}.
         *
         * @param actuality the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder actuality(FhirEnum<AdverseEventActuality> actuality) {
            this.actuality = actuality;
            return this;
        }

        /**
         * Sets {@code actuality}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param actuality the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder actuality(AdverseEventActuality actuality) {
            return actuality(actuality == null ? null : FhirEnum.of(actuality));
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
         * Sets {@code occurrence} to a Timing.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Timing occurrence) {
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
         * Sets {@code detected}.
         *
         * @param detected the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder detected(FhirDateTime detected) {
            this.detected = detected;
            return this;
        }

        /**
         * Sets {@code detected}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param detected the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder detected(Temporal detected) {
            return detected(detected == null ? null : FhirDateTime.of(detected));
        }

        /**
         * Sets {@code recordedDate}.
         *
         * @param recordedDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recordedDate(FhirDateTime recordedDate) {
            this.recordedDate = recordedDate;
            return this;
        }

        /**
         * Sets {@code recordedDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param recordedDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recordedDate(Temporal recordedDate) {
            return recordedDate(recordedDate == null ? null : FhirDateTime.of(recordedDate));
        }

        /**
         * Replaces all {@code resultingEffect} values.
         *
         * @param resultingEffect the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder resultingEffect(List<Reference> resultingEffect) {
            this.resultingEffect = resultingEffect == null ? new ArrayList<>() : new ArrayList<>(resultingEffect);
            return this;
        }

        /**
         * Adds a {@code resultingEffect} value.
         *
         * @param resultingEffect the value to add
         * @return this builder
         */
        public Builder addResultingEffect(Reference resultingEffect) {
            this.resultingEffect.add(Objects.requireNonNull(resultingEffect, "resultingEffect"));
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
         * Sets {@code seriousness}.
         *
         * @param seriousness the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder seriousness(CodeableConcept seriousness) {
            this.seriousness = seriousness;
            return this;
        }

        /**
         * Replaces all {@code outcome} values.
         *
         * @param outcome the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder outcome(List<CodeableConcept> outcome) {
            this.outcome = outcome == null ? new ArrayList<>() : new ArrayList<>(outcome);
            return this;
        }

        /**
         * Adds a {@code outcome} value.
         *
         * @param outcome the value to add
         * @return this builder
         */
        public Builder addOutcome(CodeableConcept outcome) {
            this.outcome.add(Objects.requireNonNull(outcome, "outcome"));
            return this;
        }

        /**
         * Sets {@code recorder}.
         *
         * @param recorder the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorder(Reference recorder) {
            this.recorder = recorder;
            return this;
        }

        /**
         * Replaces all {@code participant} values.
         *
         * @param participant the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder participant(List<Participant> participant) {
            this.participant = participant == null ? new ArrayList<>() : new ArrayList<>(participant);
            return this;
        }

        /**
         * Adds a {@code participant} value.
         *
         * @param participant the value to add
         * @return this builder
         */
        public Builder addParticipant(Participant participant) {
            this.participant.add(Objects.requireNonNull(participant, "participant"));
            return this;
        }

        /**
         * Replaces all {@code study} values.
         *
         * @param study the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder study(List<Reference> study) {
            this.study = study == null ? new ArrayList<>() : new ArrayList<>(study);
            return this;
        }

        /**
         * Adds a {@code study} value.
         *
         * @param study the value to add
         * @return this builder
         */
        public Builder addStudy(Reference study) {
            this.study.add(Objects.requireNonNull(study, "study"));
            return this;
        }

        /**
         * Sets {@code expectedInResearchStudy}.
         *
         * @param expectedInResearchStudy the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expectedInResearchStudy(FhirBoolean expectedInResearchStudy) {
            this.expectedInResearchStudy = expectedInResearchStudy;
            return this;
        }

        /**
         * Sets {@code expectedInResearchStudy}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param expectedInResearchStudy the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expectedInResearchStudy(Boolean expectedInResearchStudy) {
            return expectedInResearchStudy(
                    expectedInResearchStudy == null ? null : FhirBoolean.of(expectedInResearchStudy));
        }

        /**
         * Replaces all {@code suspectEntity} values.
         *
         * @param suspectEntity the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder suspectEntity(List<SuspectEntity> suspectEntity) {
            this.suspectEntity = suspectEntity == null ? new ArrayList<>() : new ArrayList<>(suspectEntity);
            return this;
        }

        /**
         * Adds a {@code suspectEntity} value.
         *
         * @param suspectEntity the value to add
         * @return this builder
         */
        public Builder addSuspectEntity(SuspectEntity suspectEntity) {
            this.suspectEntity.add(Objects.requireNonNull(suspectEntity, "suspectEntity"));
            return this;
        }

        /**
         * Replaces all {@code contributingFactor} values.
         *
         * @param contributingFactor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contributingFactor(List<ContributingFactor> contributingFactor) {
            this.contributingFactor = contributingFactor == null
                    ? new ArrayList<>()
                    : new ArrayList<>(contributingFactor);
            return this;
        }

        /**
         * Adds a {@code contributingFactor} value.
         *
         * @param contributingFactor the value to add
         * @return this builder
         */
        public Builder addContributingFactor(ContributingFactor contributingFactor) {
            this.contributingFactor.add(Objects.requireNonNull(contributingFactor, "contributingFactor"));
            return this;
        }

        /**
         * Replaces all {@code preventiveAction} values.
         *
         * @param preventiveAction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder preventiveAction(List<PreventiveAction> preventiveAction) {
            this.preventiveAction = preventiveAction == null ? new ArrayList<>() : new ArrayList<>(preventiveAction);
            return this;
        }

        /**
         * Adds a {@code preventiveAction} value.
         *
         * @param preventiveAction the value to add
         * @return this builder
         */
        public Builder addPreventiveAction(PreventiveAction preventiveAction) {
            this.preventiveAction.add(Objects.requireNonNull(preventiveAction, "preventiveAction"));
            return this;
        }

        /**
         * Replaces all {@code mitigatingAction} values.
         *
         * @param mitigatingAction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder mitigatingAction(List<MitigatingAction> mitigatingAction) {
            this.mitigatingAction = mitigatingAction == null ? new ArrayList<>() : new ArrayList<>(mitigatingAction);
            return this;
        }

        /**
         * Adds a {@code mitigatingAction} value.
         *
         * @param mitigatingAction the value to add
         * @return this builder
         */
        public Builder addMitigatingAction(MitigatingAction mitigatingAction) {
            this.mitigatingAction.add(Objects.requireNonNull(mitigatingAction, "mitigatingAction"));
            return this;
        }

        /**
         * Replaces all {@code supportingInfo} values.
         *
         * @param supportingInfo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supportingInfo(List<SupportingInfo> supportingInfo) {
            this.supportingInfo = supportingInfo == null ? new ArrayList<>() : new ArrayList<>(supportingInfo);
            return this;
        }

        /**
         * Adds a {@code supportingInfo} value.
         *
         * @param supportingInfo the value to add
         * @return this builder
         */
        public Builder addSupportingInfo(SupportingInfo supportingInfo) {
            this.supportingInfo.add(Objects.requireNonNull(supportingInfo, "supportingInfo"));
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
         * Builds the {@code AdverseEvent}.
         *
         * @return the {@code AdverseEvent}
         * @throws NullPointerException if a required element is absent
         */
        public AdverseEvent build() {
            return new AdverseEvent(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, actuality, category, code, subject, encounter, occurrence, detected, recordedDate,
                    resultingEffect, location, seriousness, outcome, recorder, participant, study,
                    expectedInResearchStudy, suspectEntity, contributingFactor, preventiveAction, mitigatingAction,
                    supportingInfo, note);
        }
    }
}
