package se.poroli.fhirplace.r5.goal;

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
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring
 * an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective,
 * etc.
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
 * @param identifier External Ids for this goal.
 * @param lifecycleStatus proposed | planned | accepted | active | on-hold | completed | cancelled | entered-in-error
 *   | rejected. Required. Modifier element.
 * @param achievementStatus in-progress | improving | worsening | no-change | achieved | sustaining | not-achieved |
 *   no-progress | not-attainable.
 * @param category E.g. Treatment, dietary, behavioral, etc.
 * @param continuous After meeting the goal, ongoing activity is needed to sustain the goal objective.
 * @param priority high-priority | medium-priority | low-priority.
 * @param description Code or text describing goal. Required.
 * @param subject Who this goal is intended for. Reference to Patient, Group, Organization. Required.
 * @param start When goal pursuit begins. One of date, CodeableConcept.
 * @param target Target outcome for the goal.
 * @param statusDate When goal status took effect.
 * @param statusReason Reason for current status.
 * @param source Who's responsible for creating Goal?. Reference to Patient, Practitioner, PractitionerRole,
 *   RelatedPerson, CareTeam.
 * @param addresses Issues addressed by this goal. Reference to Condition, Observation, MedicationStatement,
 *   MedicationRequest, NutritionOrder, ServiceRequest, RiskAssessment, Procedure.
 * @param note Comments about the goal.
 * @param outcome What result was achieved regarding the goal?.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Goal">FHIR R5 Goal</a>
 */
public record Goal(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<GoalLifecycleStatus> lifecycleStatus,
        CodeableConcept achievementStatus,
        List<CodeableConcept> category,
        FhirBoolean continuous,
        CodeableConcept priority,
        CodeableConcept description,
        Reference subject,
        DataType start,
        List<Target> target,
        FhirDate statusDate,
        FhirString statusReason,
        Reference source,
        List<Reference> addresses,
        List<Annotation> note,
        List<CodeableReference> outcome) implements DomainResource {

    /**
     * Creates a {@code Goal}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Goal {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        category = category == null ? List.of() : List.copyOf(category);
        target = target == null ? List.of() : List.copyOf(target);
        addresses = addresses == null ? List.of() : List.copyOf(addresses);
        note = note == null ? List.of() : List.copyOf(note);
        outcome = outcome == null ? List.of() : List.copyOf(outcome);
        Objects.requireNonNull(lifecycleStatus, "Goal.lifecycleStatus is required");
        Objects.requireNonNull(description, "Goal.description is required");
        Objects.requireNonNull(subject, "Goal.subject is required");
        if (start != null && !(start instanceof FhirDate || start instanceof CodeableConcept)) {
            throw new IllegalArgumentException(
                    "Goal.start[x] must be one of date, CodeableConcept, but was "
                            + start.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Goal}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates what should be done by when.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param measure The parameter whose value is being tracked.
     * @param detail The target value to be achieved. One of Quantity, Range, CodeableConcept, string, boolean,
     *   integer, Ratio.
     * @param due Reach goal on or before. One of date, Duration.
     */
    public record Target(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept measure,
            DataType detail,
            DataType due) implements BackboneElement {

        /**
         * Creates a {@code Target}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Target {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (detail != null && !(detail instanceof Quantity
                    || detail instanceof Range
                    || detail instanceof CodeableConcept
                    || detail instanceof FhirString
                    || detail instanceof FhirBoolean
                    || detail instanceof FhirInteger
                    || detail instanceof Ratio)) {
                throw new IllegalArgumentException(
                        "Goal.target.detail[x] does not allow "
                                + detail.getClass().getSimpleName());
            }
            if (due != null && !(due instanceof FhirDate || due instanceof Duration)) {
                throw new IllegalArgumentException(
                        "Goal.target.due[x] must be one of date, Duration, but was "
                                + due.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Target}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Target}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept measure;
            private DataType detail;
            private DataType due;

            private Builder() {
            }

            private Builder(Target original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.measure = original.measure();
                this.detail = original.detail();
                this.due = original.due();
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
             * Sets {@code measure}.
             *
             * @param measure the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder measure(CodeableConcept measure) {
                this.measure = measure;
                return this;
            }

            /**
             * Sets {@code detail} to a Quantity.
             *
             * @param detail the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detail(Quantity detail) {
                this.detail = detail;
                return this;
            }

            /**
             * Sets {@code detail} to a Range.
             *
             * @param detail the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detail(Range detail) {
                this.detail = detail;
                return this;
            }

            /**
             * Sets {@code detail} to a CodeableConcept.
             *
             * @param detail the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detail(CodeableConcept detail) {
                this.detail = detail;
                return this;
            }

            /**
             * Sets {@code detail} to a string.
             *
             * @param detail the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detail(FhirString detail) {
                this.detail = detail;
                return this;
            }

            /**
             * Sets {@code detail} to a boolean.
             *
             * @param detail the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detail(FhirBoolean detail) {
                this.detail = detail;
                return this;
            }

            /**
             * Sets {@code detail} to a integer.
             *
             * @param detail the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detail(FhirInteger detail) {
                this.detail = detail;
                return this;
            }

            /**
             * Sets {@code detail} to a Ratio.
             *
             * @param detail the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detail(Ratio detail) {
                this.detail = detail;
                return this;
            }

            /**
             * Sets {@code detail} to a string without id or extensions.
             *
             * @param detail the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detail(String detail) {
                this.detail = detail == null ? null : FhirString.of(detail);
                return this;
            }

            /**
             * Sets {@code detail} to a boolean without id or extensions.
             *
             * @param detail the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detail(Boolean detail) {
                this.detail = detail == null ? null : FhirBoolean.of(detail);
                return this;
            }

            /**
             * Sets {@code detail} to a integer without id or extensions.
             *
             * @param detail the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detail(Integer detail) {
                this.detail = detail == null ? null : FhirInteger.of(detail);
                return this;
            }

            /**
             * Sets {@code due} to a date.
             *
             * @param due the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder due(FhirDate due) {
                this.due = due;
                return this;
            }

            /**
             * Sets {@code due} to a Duration.
             *
             * @param due the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder due(Duration due) {
                this.due = due;
                return this;
            }

            /**
             * Sets {@code due} to a date without id or extensions.
             *
             * @param due the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder due(Temporal due) {
                this.due = due == null ? null : FhirDate.of(due);
                return this;
            }

            /**
             * Builds the {@code Target}.
             *
             * @return the {@code Target}
             */
            public Target build() {
                return new Target(
                        id, extension, modifierExtension, measure, detail, due);
            }
        }
    }

    /** Builder for {@link Goal}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<GoalLifecycleStatus> lifecycleStatus;
        private CodeableConcept achievementStatus;
        private List<CodeableConcept> category = new ArrayList<>();
        private FhirBoolean continuous;
        private CodeableConcept priority;
        private CodeableConcept description;
        private Reference subject;
        private DataType start;
        private List<Target> target = new ArrayList<>();
        private FhirDate statusDate;
        private FhirString statusReason;
        private Reference source;
        private List<Reference> addresses = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<CodeableReference> outcome = new ArrayList<>();

        private Builder() {
        }

        private Builder(Goal original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.lifecycleStatus = original.lifecycleStatus();
            this.achievementStatus = original.achievementStatus();
            this.category = new ArrayList<>(original.category());
            this.continuous = original.continuous();
            this.priority = original.priority();
            this.description = original.description();
            this.subject = original.subject();
            this.start = original.start();
            this.target = new ArrayList<>(original.target());
            this.statusDate = original.statusDate();
            this.statusReason = original.statusReason();
            this.source = original.source();
            this.addresses = new ArrayList<>(original.addresses());
            this.note = new ArrayList<>(original.note());
            this.outcome = new ArrayList<>(original.outcome());
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
         * Sets {@code lifecycleStatus}.
         *
         * @param lifecycleStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lifecycleStatus(FhirEnum<GoalLifecycleStatus> lifecycleStatus) {
            this.lifecycleStatus = lifecycleStatus;
            return this;
        }

        /**
         * Sets {@code lifecycleStatus}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param lifecycleStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lifecycleStatus(GoalLifecycleStatus lifecycleStatus) {
            return lifecycleStatus(lifecycleStatus == null ? null : FhirEnum.of(lifecycleStatus));
        }

        /**
         * Sets {@code achievementStatus}.
         *
         * @param achievementStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder achievementStatus(CodeableConcept achievementStatus) {
            this.achievementStatus = achievementStatus;
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
         * Sets {@code continuous}.
         *
         * @param continuous the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder continuous(FhirBoolean continuous) {
            this.continuous = continuous;
            return this;
        }

        /**
         * Sets {@code continuous}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param continuous the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder continuous(Boolean continuous) {
            return continuous(continuous == null ? null : FhirBoolean.of(continuous));
        }

        /**
         * Sets {@code priority}.
         *
         * @param priority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priority(CodeableConcept priority) {
            this.priority = priority;
            return this;
        }

        /**
         * Sets {@code description}.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(CodeableConcept description) {
            this.description = description;
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
         * Sets {@code start} to a date.
         *
         * @param start the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder start(FhirDate start) {
            this.start = start;
            return this;
        }

        /**
         * Sets {@code start} to a CodeableConcept.
         *
         * @param start the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder start(CodeableConcept start) {
            this.start = start;
            return this;
        }

        /**
         * Sets {@code start} to a date without id or extensions.
         *
         * @param start the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder start(Temporal start) {
            this.start = start == null ? null : FhirDate.of(start);
            return this;
        }

        /**
         * Replaces all {@code target} values.
         *
         * @param target the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder target(List<Target> target) {
            this.target = target == null ? new ArrayList<>() : new ArrayList<>(target);
            return this;
        }

        /**
         * Adds a {@code target} value.
         *
         * @param target the value to add
         * @return this builder
         */
        public Builder addTarget(Target target) {
            this.target.add(Objects.requireNonNull(target, "target"));
            return this;
        }

        /**
         * Sets {@code statusDate}.
         *
         * @param statusDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusDate(FhirDate statusDate) {
            this.statusDate = statusDate;
            return this;
        }

        /**
         * Sets {@code statusDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param statusDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusDate(Temporal statusDate) {
            return statusDate(statusDate == null ? null : FhirDate.of(statusDate));
        }

        /**
         * Sets {@code statusReason}.
         *
         * @param statusReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusReason(FhirString statusReason) {
            this.statusReason = statusReason;
            return this;
        }

        /**
         * Sets {@code statusReason}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param statusReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusReason(String statusReason) {
            return statusReason(statusReason == null ? null : FhirString.of(statusReason));
        }

        /**
         * Sets {@code source}.
         *
         * @param source the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder source(Reference source) {
            this.source = source;
            return this;
        }

        /**
         * Replaces all {@code addresses} values.
         *
         * @param addresses the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder addresses(List<Reference> addresses) {
            this.addresses = addresses == null ? new ArrayList<>() : new ArrayList<>(addresses);
            return this;
        }

        /**
         * Adds a {@code addresses} value.
         *
         * @param addresses the value to add
         * @return this builder
         */
        public Builder addAddresses(Reference addresses) {
            this.addresses.add(Objects.requireNonNull(addresses, "addresses"));
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
         * Replaces all {@code outcome} values.
         *
         * @param outcome the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder outcome(List<CodeableReference> outcome) {
            this.outcome = outcome == null ? new ArrayList<>() : new ArrayList<>(outcome);
            return this;
        }

        /**
         * Adds a {@code outcome} value.
         *
         * @param outcome the value to add
         * @return this builder
         */
        public Builder addOutcome(CodeableReference outcome) {
            this.outcome.add(Objects.requireNonNull(outcome, "outcome"));
            return this;
        }

        /**
         * Builds the {@code Goal}.
         *
         * @return the {@code Goal}
         * @throws NullPointerException if a required element is absent
         */
        public Goal build() {
            return new Goal(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    lifecycleStatus, achievementStatus, category, continuous, priority, description, subject, start,
                    target, statusDate, statusReason, source, addresses, note, outcome);
        }
    }
}
