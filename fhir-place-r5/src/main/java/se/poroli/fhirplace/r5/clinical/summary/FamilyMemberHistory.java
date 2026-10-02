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
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.FamilyHistoryStatus;

/**
 * Significant health conditions for a person related to the patient relevant in the context of care for the patient.
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
 * @param identifier External Id(s) for this record.
 * @param instantiatesCanonical Instantiates FHIR protocol or definition. Canonical reference to PlanDefinition,
 *   Questionnaire, ActivityDefinition, Measure, OperationDefinition.
 * @param instantiatesUri Instantiates external protocol or definition.
 * @param status partial | completed | entered-in-error | health-unknown. Required. Modifier element.
 * @param dataAbsentReason subject-unknown | withheld | unable-to-obtain | deferred.
 * @param patient Patient history is about. Reference to Patient. Required.
 * @param date When history was recorded or last updated.
 * @param participant Who or what participated in the activities related to the family member history and how they
 *   were involved.
 * @param name The family member described.
 * @param relationship Relationship to the subject. Required.
 * @param sex male | female | other | unknown.
 * @param born (approximate) date of birth. One of Period, date, string.
 * @param age (approximate) age. One of Age, Range, string.
 * @param estimatedAge Age is estimated?.
 * @param deceased Dead? How old/when?. One of boolean, Age, Range, date, string.
 * @param reason Why was family member history performed?.
 * @param note General note about related person.
 * @param condition Condition that the related person had.
 * @param procedure Procedures that the related person had.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/FamilyMemberHistory">FHIR R5 FamilyMemberHistory</a>
 */
public record FamilyMemberHistory(
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
        FhirEnum<FamilyHistoryStatus> status,
        CodeableConcept dataAbsentReason,
        Reference patient,
        FhirDateTime date,
        List<Participant> participant,
        FhirString name,
        CodeableConcept relationship,
        CodeableConcept sex,
        DataType born,
        DataType age,
        FhirBoolean estimatedAge,
        DataType deceased,
        List<CodeableReference> reason,
        List<Annotation> note,
        List<Condition> condition,
        List<Procedure> procedure) implements DomainResource {

    /**
     * Creates a {@code FamilyMemberHistory}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public FamilyMemberHistory {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        instantiatesCanonical = instantiatesCanonical == null ? List.of() : List.copyOf(instantiatesCanonical);
        instantiatesUri = instantiatesUri == null ? List.of() : List.copyOf(instantiatesUri);
        participant = participant == null ? List.of() : List.copyOf(participant);
        reason = reason == null ? List.of() : List.copyOf(reason);
        note = note == null ? List.of() : List.copyOf(note);
        condition = condition == null ? List.of() : List.copyOf(condition);
        procedure = procedure == null ? List.of() : List.copyOf(procedure);
        Objects.requireNonNull(status, "FamilyMemberHistory.status is required");
        Objects.requireNonNull(patient, "FamilyMemberHistory.patient is required");
        Objects.requireNonNull(relationship, "FamilyMemberHistory.relationship is required");
        if (born != null && !(born instanceof Period || born instanceof FhirDate || born instanceof FhirString)) {
            throw new IllegalArgumentException(
                    "FamilyMemberHistory.born[x] must be one of Period, date, string, but was "
                            + born.getClass().getSimpleName());
        }
        if (age != null && !(age instanceof Age || age instanceof Range || age instanceof FhirString)) {
            throw new IllegalArgumentException(
                    "FamilyMemberHistory.age[x] must be one of Age, Range, string, but was "
                            + age.getClass().getSimpleName());
        }
        if (deceased != null && !(deceased instanceof FhirBoolean
                || deceased instanceof Age
                || deceased instanceof Range
                || deceased instanceof FhirDate
                || deceased instanceof FhirString)) {
            throw new IllegalArgumentException(
                    "FamilyMemberHistory.deceased[x] must be one of boolean, Age, Range, date, string, but was "
                            + deceased.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code FamilyMemberHistory}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates who or what participated in the activities related to the family member history and how they were
     * involved.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function Type of involvement.
     * @param actor Who or what participated in the activities related to the family member history. Reference to
     *   Practitioner, PractitionerRole, Patient, RelatedPerson, Device, Organization, CareTeam. Required.
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
            Objects.requireNonNull(actor, "FamilyMemberHistory.participant.actor is required");
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
     * The significant Conditions (or condition) that the family member had.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Condition suffered by relation. Required.
     * @param outcome deceased | permanent disability | etc.
     * @param contributedToDeath Whether the condition contributed to the cause of death.
     * @param onset When condition first manifested. One of Age, Range, Period, string.
     * @param note Extra information about condition.
     */
    public record Condition(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            CodeableConcept outcome,
            FhirBoolean contributedToDeath,
            DataType onset,
            List<Annotation> note) implements BackboneElement {

        /**
         * Creates a {@code Condition}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Condition {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            note = note == null ? List.of() : List.copyOf(note);
            Objects.requireNonNull(code, "FamilyMemberHistory.condition.code is required");
            if (onset != null && !(onset instanceof Age
                    || onset instanceof Range
                    || onset instanceof Period
                    || onset instanceof FhirString)) {
                throw new IllegalArgumentException(
                        "FamilyMemberHistory.condition.onset[x] must be one of Age, Range, Period, string, but was "
                                + onset.getClass().getSimpleName());
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

        /** Builder for {@link Condition}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private CodeableConcept outcome;
            private FhirBoolean contributedToDeath;
            private DataType onset;
            private List<Annotation> note = new ArrayList<>();

            private Builder() {
            }

            private Builder(Condition original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.outcome = original.outcome();
                this.contributedToDeath = original.contributedToDeath();
                this.onset = original.onset();
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
             * Sets {@code outcome}.
             *
             * @param outcome the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder outcome(CodeableConcept outcome) {
                this.outcome = outcome;
                return this;
            }

            /**
             * Sets {@code contributedToDeath}.
             *
             * @param contributedToDeath the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder contributedToDeath(FhirBoolean contributedToDeath) {
                this.contributedToDeath = contributedToDeath;
                return this;
            }

            /**
             * Sets {@code contributedToDeath}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param contributedToDeath the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder contributedToDeath(Boolean contributedToDeath) {
                return contributedToDeath(contributedToDeath == null ? null : FhirBoolean.of(contributedToDeath));
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
                        id, extension, modifierExtension, code, outcome, contributedToDeath, onset, note);
            }
        }
    }

    /**
     * The significant Procedures (or procedure) that the family member had.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Procedures performed on the related person. Required.
     * @param outcome What happened following the procedure.
     * @param contributedToDeath Whether the procedure contributed to the cause of death.
     * @param performed When the procedure was performed. One of Age, Range, Period, string, dateTime.
     * @param note Extra information about the procedure.
     */
    public record Procedure(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            CodeableConcept outcome,
            FhirBoolean contributedToDeath,
            DataType performed,
            List<Annotation> note) implements BackboneElement {

        /**
         * Creates a {@code Procedure}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Procedure {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            note = note == null ? List.of() : List.copyOf(note);
            Objects.requireNonNull(code, "FamilyMemberHistory.procedure.code is required");
            if (performed != null && !(performed instanceof Age
                    || performed instanceof Range
                    || performed instanceof Period
                    || performed instanceof FhirString
                    || performed instanceof FhirDateTime)) {
                throw new IllegalArgumentException(
                        "FamilyMemberHistory.procedure.performed[x] does not allow "
                                + performed.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Procedure}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Procedure}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private CodeableConcept outcome;
            private FhirBoolean contributedToDeath;
            private DataType performed;
            private List<Annotation> note = new ArrayList<>();

            private Builder() {
            }

            private Builder(Procedure original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.outcome = original.outcome();
                this.contributedToDeath = original.contributedToDeath();
                this.performed = original.performed();
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
             * Sets {@code outcome}.
             *
             * @param outcome the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder outcome(CodeableConcept outcome) {
                this.outcome = outcome;
                return this;
            }

            /**
             * Sets {@code contributedToDeath}.
             *
             * @param contributedToDeath the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder contributedToDeath(FhirBoolean contributedToDeath) {
                this.contributedToDeath = contributedToDeath;
                return this;
            }

            /**
             * Sets {@code contributedToDeath}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param contributedToDeath the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder contributedToDeath(Boolean contributedToDeath) {
                return contributedToDeath(contributedToDeath == null ? null : FhirBoolean.of(contributedToDeath));
            }

            /**
             * Sets {@code performed} to a Age.
             *
             * @param performed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder performed(Age performed) {
                this.performed = performed;
                return this;
            }

            /**
             * Sets {@code performed} to a Range.
             *
             * @param performed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder performed(Range performed) {
                this.performed = performed;
                return this;
            }

            /**
             * Sets {@code performed} to a Period.
             *
             * @param performed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder performed(Period performed) {
                this.performed = performed;
                return this;
            }

            /**
             * Sets {@code performed} to a string.
             *
             * @param performed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder performed(FhirString performed) {
                this.performed = performed;
                return this;
            }

            /**
             * Sets {@code performed} to a dateTime.
             *
             * @param performed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder performed(FhirDateTime performed) {
                this.performed = performed;
                return this;
            }

            /**
             * Sets {@code performed} to a string without id or extensions.
             *
             * @param performed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder performed(String performed) {
                this.performed = performed == null ? null : FhirString.of(performed);
                return this;
            }

            /**
             * Sets {@code performed} to a dateTime without id or extensions.
             *
             * @param performed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder performed(Temporal performed) {
                this.performed = performed == null ? null : FhirDateTime.of(performed);
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
             * Builds the {@code Procedure}.
             *
             * @return the {@code Procedure}
             * @throws NullPointerException if a required element is absent
             */
            public Procedure build() {
                return new Procedure(
                        id, extension, modifierExtension, code, outcome, contributedToDeath, performed, note);
            }
        }
    }

    /** Builder for {@link FamilyMemberHistory}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<FamilyHistoryStatus> status;
        private CodeableConcept dataAbsentReason;
        private Reference patient;
        private FhirDateTime date;
        private List<Participant> participant = new ArrayList<>();
        private FhirString name;
        private CodeableConcept relationship;
        private CodeableConcept sex;
        private DataType born;
        private DataType age;
        private FhirBoolean estimatedAge;
        private DataType deceased;
        private List<CodeableReference> reason = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<Condition> condition = new ArrayList<>();
        private List<Procedure> procedure = new ArrayList<>();

        private Builder() {
        }

        private Builder(FamilyMemberHistory original) {
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
            this.status = original.status();
            this.dataAbsentReason = original.dataAbsentReason();
            this.patient = original.patient();
            this.date = original.date();
            this.participant = new ArrayList<>(original.participant());
            this.name = original.name();
            this.relationship = original.relationship();
            this.sex = original.sex();
            this.born = original.born();
            this.age = original.age();
            this.estimatedAge = original.estimatedAge();
            this.deceased = original.deceased();
            this.reason = new ArrayList<>(original.reason());
            this.note = new ArrayList<>(original.note());
            this.condition = new ArrayList<>(original.condition());
            this.procedure = new ArrayList<>(original.procedure());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<FamilyHistoryStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FamilyHistoryStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code dataAbsentReason}.
         *
         * @param dataAbsentReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dataAbsentReason(CodeableConcept dataAbsentReason) {
            this.dataAbsentReason = dataAbsentReason;
            return this;
        }

        /**
         * Sets {@code patient}.
         *
         * @param patient the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder patient(Reference patient) {
            this.patient = patient;
            return this;
        }

        /**
         * Sets {@code date}.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(FhirDateTime date) {
            this.date = date;
            return this;
        }

        /**
         * Sets {@code date}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(Temporal date) {
            return date(date == null ? null : FhirDateTime.of(date));
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
         * Sets {@code relationship}.
         *
         * @param relationship the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder relationship(CodeableConcept relationship) {
            this.relationship = relationship;
            return this;
        }

        /**
         * Sets {@code sex}.
         *
         * @param sex the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sex(CodeableConcept sex) {
            this.sex = sex;
            return this;
        }

        /**
         * Sets {@code born} to a Period.
         *
         * @param born the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder born(Period born) {
            this.born = born;
            return this;
        }

        /**
         * Sets {@code born} to a date.
         *
         * @param born the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder born(FhirDate born) {
            this.born = born;
            return this;
        }

        /**
         * Sets {@code born} to a string.
         *
         * @param born the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder born(FhirString born) {
            this.born = born;
            return this;
        }

        /**
         * Sets {@code born} to a date without id or extensions.
         *
         * @param born the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder born(Temporal born) {
            this.born = born == null ? null : FhirDate.of(born);
            return this;
        }

        /**
         * Sets {@code born} to a string without id or extensions.
         *
         * @param born the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder born(String born) {
            this.born = born == null ? null : FhirString.of(born);
            return this;
        }

        /**
         * Sets {@code age} to a Age.
         *
         * @param age the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder age(Age age) {
            this.age = age;
            return this;
        }

        /**
         * Sets {@code age} to a Range.
         *
         * @param age the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder age(Range age) {
            this.age = age;
            return this;
        }

        /**
         * Sets {@code age} to a string.
         *
         * @param age the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder age(FhirString age) {
            this.age = age;
            return this;
        }

        /**
         * Sets {@code age} to a string without id or extensions.
         *
         * @param age the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder age(String age) {
            this.age = age == null ? null : FhirString.of(age);
            return this;
        }

        /**
         * Sets {@code estimatedAge}.
         *
         * @param estimatedAge the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder estimatedAge(FhirBoolean estimatedAge) {
            this.estimatedAge = estimatedAge;
            return this;
        }

        /**
         * Sets {@code estimatedAge}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param estimatedAge the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder estimatedAge(Boolean estimatedAge) {
            return estimatedAge(estimatedAge == null ? null : FhirBoolean.of(estimatedAge));
        }

        /**
         * Sets {@code deceased} to a boolean.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(FhirBoolean deceased) {
            this.deceased = deceased;
            return this;
        }

        /**
         * Sets {@code deceased} to a Age.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(Age deceased) {
            this.deceased = deceased;
            return this;
        }

        /**
         * Sets {@code deceased} to a Range.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(Range deceased) {
            this.deceased = deceased;
            return this;
        }

        /**
         * Sets {@code deceased} to a date.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(FhirDate deceased) {
            this.deceased = deceased;
            return this;
        }

        /**
         * Sets {@code deceased} to a string.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(FhirString deceased) {
            this.deceased = deceased;
            return this;
        }

        /**
         * Sets {@code deceased} to a boolean without id or extensions.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(Boolean deceased) {
            this.deceased = deceased == null ? null : FhirBoolean.of(deceased);
            return this;
        }

        /**
         * Sets {@code deceased} to a date without id or extensions.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(Temporal deceased) {
            this.deceased = deceased == null ? null : FhirDate.of(deceased);
            return this;
        }

        /**
         * Sets {@code deceased} to a string without id or extensions.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(String deceased) {
            this.deceased = deceased == null ? null : FhirString.of(deceased);
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
         * Replaces all {@code condition} values.
         *
         * @param condition the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder condition(List<Condition> condition) {
            this.condition = condition == null ? new ArrayList<>() : new ArrayList<>(condition);
            return this;
        }

        /**
         * Adds a {@code condition} value.
         *
         * @param condition the value to add
         * @return this builder
         */
        public Builder addCondition(Condition condition) {
            this.condition.add(Objects.requireNonNull(condition, "condition"));
            return this;
        }

        /**
         * Replaces all {@code procedure} values.
         *
         * @param procedure the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder procedure(List<Procedure> procedure) {
            this.procedure = procedure == null ? new ArrayList<>() : new ArrayList<>(procedure);
            return this;
        }

        /**
         * Adds a {@code procedure} value.
         *
         * @param procedure the value to add
         * @return this builder
         */
        public Builder addProcedure(Procedure procedure) {
            this.procedure.add(Objects.requireNonNull(procedure, "procedure"));
            return this;
        }

        /**
         * Builds the {@code FamilyMemberHistory}.
         *
         * @return the {@code FamilyMemberHistory}
         * @throws NullPointerException if a required element is absent
         */
        public FamilyMemberHistory build() {
            return new FamilyMemberHistory(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiatesCanonical, instantiatesUri, status, dataAbsentReason, patient, date, participant,
                    name, relationship, sex, born, age, estimatedAge, deceased, reason, note, condition, procedure);
        }
    }
}
