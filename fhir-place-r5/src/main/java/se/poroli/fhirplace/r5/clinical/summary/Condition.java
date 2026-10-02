package se.poroli.fhirplace.r5.clinical.summary;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a
 * level of concern.
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
 * @param identifier External Ids for this condition.
 * @param clinicalStatus active | recurrence | relapse | inactive | remission | resolved | unknown. Required. Modifier
 *   element.
 * @param verificationStatus unconfirmed | provisional | differential | confirmed | refuted | entered-in-error.
 *   Modifier element.
 * @param category problem-list-item | encounter-diagnosis.
 * @param severity Subjective severity of condition.
 * @param code Identification of the condition, problem or diagnosis.
 * @param bodySite Anatomical location, if relevant.
 * @param subject Who has the condition?. Reference to Patient, Group. Required.
 * @param encounter The Encounter during which this Condition was created. Reference to Encounter.
 * @param onset Estimated or actual date, date-time, or age. One of dateTime, Age, Period, Range, string.
 * @param abatement When in resolution/remission. One of dateTime, Age, Period, Range, string.
 * @param recordedDate Date condition was first recorded.
 * @param participant Who or what participated in the activities related to the condition and how they were involved.
 * @param stage Stage/grade, usually assessed formally.
 * @param evidence Supporting evidence for the verification status.
 * @param note Additional information about the Condition.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Condition">FHIR R5 Condition</a>
 */
public record Condition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        CodeableConcept clinicalStatus,
        CodeableConcept verificationStatus,
        List<CodeableConcept> category,
        CodeableConcept severity,
        CodeableConcept code,
        List<CodeableConcept> bodySite,
        Reference subject,
        Reference encounter,
        DataType onset,
        DataType abatement,
        FhirDateTime recordedDate,
        List<Participant> participant,
        List<Stage> stage,
        List<CodeableReference> evidence,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates a {@code Condition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Condition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        category = category == null ? List.of() : List.copyOf(category);
        bodySite = bodySite == null ? List.of() : List.copyOf(bodySite);
        participant = participant == null ? List.of() : List.copyOf(participant);
        stage = stage == null ? List.of() : List.copyOf(stage);
        evidence = evidence == null ? List.of() : List.copyOf(evidence);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(clinicalStatus, "Condition.clinicalStatus is required");
        Objects.requireNonNull(subject, "Condition.subject is required");
        if (onset != null && !(onset instanceof FhirDateTime
                || onset instanceof Age
                || onset instanceof Period
                || onset instanceof Range
                || onset instanceof FhirString)) {
            throw new IllegalArgumentException(
                    "Condition.onset[x] must be one of dateTime, Age, Period, Range, string, but was "
                            + onset.getClass().getSimpleName());
        }
        if (abatement != null && !(abatement instanceof FhirDateTime
                || abatement instanceof Age
                || abatement instanceof Period
                || abatement instanceof Range
                || abatement instanceof FhirString)) {
            throw new IllegalArgumentException(
                    "Condition.abatement[x] must be one of dateTime, Age, Period, Range, string, but was "
                            + abatement.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Condition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates who or what participated in the activities related to the condition and how they were involved.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function Type of involvement.
     * @param actor Who or what participated in the activities related to the condition. Reference to Practitioner,
     *   PractitionerRole, Patient, RelatedPerson, Device, Organization, CareTeam. Required.
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
            Objects.requireNonNull(actor, "Condition.participant.actor is required");
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
     * A simple summary of the stage such as "Stage 3" or "Early Onset".
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param summary Simple summary (disease specific).
     * @param assessment Formal record of assessment. Reference to ClinicalImpression, DiagnosticReport, Observation.
     * @param type Kind of staging.
     */
    public record Stage(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept summary,
            List<Reference> assessment,
            CodeableConcept type) implements BackboneElement {

        /**
         * Creates a {@code Stage}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Stage {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            assessment = assessment == null ? List.of() : List.copyOf(assessment);
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
         * Returns a builder initialized with the values of this {@code Stage}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Stage}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept summary;
            private List<Reference> assessment = new ArrayList<>();
            private CodeableConcept type;

            private Builder() {
            }

            private Builder(Stage original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.summary = original.summary();
                this.assessment = new ArrayList<>(original.assessment());
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
             * Sets {@code summary}.
             *
             * @param summary the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder summary(CodeableConcept summary) {
                this.summary = summary;
                return this;
            }

            /**
             * Replaces all {@code assessment} values.
             *
             * @param assessment the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder assessment(List<Reference> assessment) {
                this.assessment = assessment == null ? new ArrayList<>() : new ArrayList<>(assessment);
                return this;
            }

            /**
             * Adds a {@code assessment} value.
             *
             * @param assessment the value to add
             * @return this builder
             */
            public Builder addAssessment(Reference assessment) {
                this.assessment.add(Objects.requireNonNull(assessment, "assessment"));
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
             * Builds the {@code Stage}.
             *
             * @return the {@code Stage}
             */
            public Stage build() {
                return new Stage(
                        id, extension, modifierExtension, summary, assessment, type);
            }
        }
    }

    /** Builder for {@link Condition}. Builders are mutable and not thread-safe. */
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
        private CodeableConcept clinicalStatus;
        private CodeableConcept verificationStatus;
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableConcept severity;
        private CodeableConcept code;
        private List<CodeableConcept> bodySite = new ArrayList<>();
        private Reference subject;
        private Reference encounter;
        private DataType onset;
        private DataType abatement;
        private FhirDateTime recordedDate;
        private List<Participant> participant = new ArrayList<>();
        private List<Stage> stage = new ArrayList<>();
        private List<CodeableReference> evidence = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(Condition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.clinicalStatus = original.clinicalStatus();
            this.verificationStatus = original.verificationStatus();
            this.category = new ArrayList<>(original.category());
            this.severity = original.severity();
            this.code = original.code();
            this.bodySite = new ArrayList<>(original.bodySite());
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.onset = original.onset();
            this.abatement = original.abatement();
            this.recordedDate = original.recordedDate();
            this.participant = new ArrayList<>(original.participant());
            this.stage = new ArrayList<>(original.stage());
            this.evidence = new ArrayList<>(original.evidence());
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
         * Sets {@code clinicalStatus}.
         *
         * @param clinicalStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder clinicalStatus(CodeableConcept clinicalStatus) {
            this.clinicalStatus = clinicalStatus;
            return this;
        }

        /**
         * Sets {@code verificationStatus}.
         *
         * @param verificationStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder verificationStatus(CodeableConcept verificationStatus) {
            this.verificationStatus = verificationStatus;
            return this;
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
         * Sets {@code severity}.
         *
         * @param severity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder severity(CodeableConcept severity) {
            this.severity = severity;
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
         * Replaces all {@code bodySite} values.
         *
         * @param bodySite the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder bodySite(List<CodeableConcept> bodySite) {
            this.bodySite = bodySite == null ? new ArrayList<>() : new ArrayList<>(bodySite);
            return this;
        }

        /**
         * Adds a {@code bodySite} value.
         *
         * @param bodySite the value to add
         * @return this builder
         */
        public Builder addBodySite(CodeableConcept bodySite) {
            this.bodySite.add(Objects.requireNonNull(bodySite, "bodySite"));
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
         * Sets {@code onset} to a dateTime.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(FhirDateTime onset) {
            this.onset = onset;
            return this;
        }

        /**
         * Sets {@code onset} to a Age.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(Age onset) {
            this.onset = onset;
            return this;
        }

        /**
         * Sets {@code onset} to a Period.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(Period onset) {
            this.onset = onset;
            return this;
        }

        /**
         * Sets {@code onset} to a Range.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(Range onset) {
            this.onset = onset;
            return this;
        }

        /**
         * Sets {@code onset} to a string.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(FhirString onset) {
            this.onset = onset;
            return this;
        }

        /**
         * Sets {@code onset} to a dateTime without id or extensions.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(Temporal onset) {
            this.onset = onset == null ? null : FhirDateTime.of(onset);
            return this;
        }

        /**
         * Sets {@code onset} to a string without id or extensions.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(String onset) {
            this.onset = onset == null ? null : FhirString.of(onset);
            return this;
        }

        /**
         * Sets {@code abatement} to a dateTime.
         *
         * @param abatement the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder abatement(FhirDateTime abatement) {
            this.abatement = abatement;
            return this;
        }

        /**
         * Sets {@code abatement} to a Age.
         *
         * @param abatement the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder abatement(Age abatement) {
            this.abatement = abatement;
            return this;
        }

        /**
         * Sets {@code abatement} to a Period.
         *
         * @param abatement the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder abatement(Period abatement) {
            this.abatement = abatement;
            return this;
        }

        /**
         * Sets {@code abatement} to a Range.
         *
         * @param abatement the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder abatement(Range abatement) {
            this.abatement = abatement;
            return this;
        }

        /**
         * Sets {@code abatement} to a string.
         *
         * @param abatement the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder abatement(FhirString abatement) {
            this.abatement = abatement;
            return this;
        }

        /**
         * Sets {@code abatement} to a dateTime without id or extensions.
         *
         * @param abatement the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder abatement(Temporal abatement) {
            this.abatement = abatement == null ? null : FhirDateTime.of(abatement);
            return this;
        }

        /**
         * Sets {@code abatement} to a string without id or extensions.
         *
         * @param abatement the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder abatement(String abatement) {
            this.abatement = abatement == null ? null : FhirString.of(abatement);
            return this;
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
         * Replaces all {@code stage} values.
         *
         * @param stage the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder stage(List<Stage> stage) {
            this.stage = stage == null ? new ArrayList<>() : new ArrayList<>(stage);
            return this;
        }

        /**
         * Adds a {@code stage} value.
         *
         * @param stage the value to add
         * @return this builder
         */
        public Builder addStage(Stage stage) {
            this.stage.add(Objects.requireNonNull(stage, "stage"));
            return this;
        }

        /**
         * Replaces all {@code evidence} values.
         *
         * @param evidence the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder evidence(List<CodeableReference> evidence) {
            this.evidence = evidence == null ? new ArrayList<>() : new ArrayList<>(evidence);
            return this;
        }

        /**
         * Adds a {@code evidence} value.
         *
         * @param evidence the value to add
         * @return this builder
         */
        public Builder addEvidence(CodeableReference evidence) {
            this.evidence.add(Objects.requireNonNull(evidence, "evidence"));
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
         * Builds the {@code Condition}.
         *
         * @return the {@code Condition}
         * @throws NullPointerException if a required element is absent
         */
        public Condition build() {
            return new Condition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    clinicalStatus, verificationStatus, category, severity, code, bodySite, subject, encounter, onset,
                    abatement, recordedDate, participant, stage, evidence, note);
        }
    }
}
