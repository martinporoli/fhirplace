package se.poroli.fhirplace.r5.clinical.careprovision;

import java.math.BigDecimal;
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
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.ObservationStatus;

/**
 * An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.
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
 * @param identifier Unique identifier for the assessment.
 * @param basedOn Request fulfilled by this assessment. Reference to Resource.
 * @param parent Part of this occurrence. Reference to Resource.
 * @param status registered | preliminary | final | amended +. Required.
 * @param method Evaluation mechanism.
 * @param code Type of assessment.
 * @param subject Who/what does assessment apply to?. Reference to Patient, Group. Required.
 * @param encounter Where was assessment performed?. Reference to Encounter.
 * @param occurrence When was assessment made?. One of dateTime, Period.
 * @param condition Condition assessed. Reference to Condition.
 * @param performer Who did assessment?. Reference to Patient, Practitioner, PractitionerRole, RelatedPerson, Device.
 * @param reason Why the assessment was necessary?.
 * @param basis Information used in assessment. Reference to Resource.
 * @param prediction Outcome predicted.
 * @param mitigation How to reduce risk.
 * @param note Comments on the risk assessment.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/RiskAssessment">FHIR R5 RiskAssessment</a>
 */
public record RiskAssessment(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        Reference basedOn,
        Reference parent,
        FhirEnum<ObservationStatus> status,
        CodeableConcept method,
        CodeableConcept code,
        Reference subject,
        Reference encounter,
        DataType occurrence,
        Reference condition,
        Reference performer,
        List<CodeableReference> reason,
        List<Reference> basis,
        List<Prediction> prediction,
        FhirString mitigation,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates a {@code RiskAssessment}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public RiskAssessment {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        reason = reason == null ? List.of() : List.copyOf(reason);
        basis = basis == null ? List.of() : List.copyOf(basis);
        prediction = prediction == null ? List.of() : List.copyOf(prediction);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "RiskAssessment.status is required");
        Objects.requireNonNull(subject, "RiskAssessment.subject is required");
        if (occurrence != null && !(occurrence instanceof FhirDateTime || occurrence instanceof Period)) {
            throw new IllegalArgumentException(
                    "RiskAssessment.occurrence[x] must be one of dateTime, Period, but was "
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
     * Returns a builder initialized with the values of this {@code RiskAssessment}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Describes the expected outcome for the subject.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param outcome Possible outcome for the subject.
     * @param probability Likelihood of specified outcome. One of decimal, Range.
     * @param qualitativeRisk Likelihood of specified outcome as a qualitative value.
     * @param relativeRisk Relative likelihood.
     * @param when Timeframe or age range. One of Period, Range.
     * @param rationale Explanation of prediction.
     */
    public record Prediction(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept outcome,
            DataType probability,
            CodeableConcept qualitativeRisk,
            FhirDecimal relativeRisk,
            DataType when,
            FhirString rationale) implements BackboneElement {

        /**
         * Creates a {@code Prediction}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Prediction {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (probability != null && !(probability instanceof FhirDecimal || probability instanceof Range)) {
                throw new IllegalArgumentException(
                        "RiskAssessment.prediction.probability[x] must be one of decimal, Range, but was "
                                + probability.getClass().getSimpleName());
            }
            if (when != null && !(when instanceof Period || when instanceof Range)) {
                throw new IllegalArgumentException(
                        "RiskAssessment.prediction.when[x] must be one of Period, Range, but was "
                                + when.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Prediction}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Prediction}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept outcome;
            private DataType probability;
            private CodeableConcept qualitativeRisk;
            private FhirDecimal relativeRisk;
            private DataType when;
            private FhirString rationale;

            private Builder() {
            }

            private Builder(Prediction original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.outcome = original.outcome();
                this.probability = original.probability();
                this.qualitativeRisk = original.qualitativeRisk();
                this.relativeRisk = original.relativeRisk();
                this.when = original.when();
                this.rationale = original.rationale();
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
             * Sets {@code probability} to a decimal.
             *
             * @param probability the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder probability(FhirDecimal probability) {
                this.probability = probability;
                return this;
            }

            /**
             * Sets {@code probability} to a Range.
             *
             * @param probability the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder probability(Range probability) {
                this.probability = probability;
                return this;
            }

            /**
             * Sets {@code probability} to a decimal without id or extensions.
             *
             * @param probability the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder probability(BigDecimal probability) {
                this.probability = probability == null ? null : FhirDecimal.of(probability);
                return this;
            }

            /**
             * Sets {@code qualitativeRisk}.
             *
             * @param qualitativeRisk the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder qualitativeRisk(CodeableConcept qualitativeRisk) {
                this.qualitativeRisk = qualitativeRisk;
                return this;
            }

            /**
             * Sets {@code relativeRisk}.
             *
             * @param relativeRisk the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder relativeRisk(FhirDecimal relativeRisk) {
                this.relativeRisk = relativeRisk;
                return this;
            }

            /**
             * Sets {@code relativeRisk}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param relativeRisk the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder relativeRisk(BigDecimal relativeRisk) {
                return relativeRisk(relativeRisk == null ? null : FhirDecimal.of(relativeRisk));
            }

            /**
             * Sets {@code when} to a Period.
             *
             * @param when the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder when(Period when) {
                this.when = when;
                return this;
            }

            /**
             * Sets {@code when} to a Range.
             *
             * @param when the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder when(Range when) {
                this.when = when;
                return this;
            }

            /**
             * Sets {@code rationale}.
             *
             * @param rationale the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rationale(FhirString rationale) {
                this.rationale = rationale;
                return this;
            }

            /**
             * Sets {@code rationale}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param rationale the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rationale(String rationale) {
                return rationale(rationale == null ? null : FhirString.of(rationale));
            }

            /**
             * Builds the {@code Prediction}.
             *
             * @return the {@code Prediction}
             */
            public Prediction build() {
                return new Prediction(
                        id, extension, modifierExtension, outcome, probability, qualitativeRisk, relativeRisk, when,
                        rationale);
            }
        }
    }

    /** Builder for {@link RiskAssessment}. Builders are mutable and not thread-safe. */
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
        private Reference basedOn;
        private Reference parent;
        private FhirEnum<ObservationStatus> status;
        private CodeableConcept method;
        private CodeableConcept code;
        private Reference subject;
        private Reference encounter;
        private DataType occurrence;
        private Reference condition;
        private Reference performer;
        private List<CodeableReference> reason = new ArrayList<>();
        private List<Reference> basis = new ArrayList<>();
        private List<Prediction> prediction = new ArrayList<>();
        private FhirString mitigation;
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(RiskAssessment original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.basedOn = original.basedOn();
            this.parent = original.parent();
            this.status = original.status();
            this.method = original.method();
            this.code = original.code();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.occurrence = original.occurrence();
            this.condition = original.condition();
            this.performer = original.performer();
            this.reason = new ArrayList<>(original.reason());
            this.basis = new ArrayList<>(original.basis());
            this.prediction = new ArrayList<>(original.prediction());
            this.mitigation = original.mitigation();
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
         * Sets {@code basedOn}.
         *
         * @param basedOn the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder basedOn(Reference basedOn) {
            this.basedOn = basedOn;
            return this;
        }

        /**
         * Sets {@code parent}.
         *
         * @param parent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder parent(Reference parent) {
            this.parent = parent;
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<ObservationStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(ObservationStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code method}.
         *
         * @param method the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder method(CodeableConcept method) {
            this.method = method;
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
         * Sets {@code condition}.
         *
         * @param condition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder condition(Reference condition) {
            this.condition = condition;
            return this;
        }

        /**
         * Sets {@code performer}.
         *
         * @param performer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder performer(Reference performer) {
            this.performer = performer;
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
         * Replaces all {@code basis} values.
         *
         * @param basis the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder basis(List<Reference> basis) {
            this.basis = basis == null ? new ArrayList<>() : new ArrayList<>(basis);
            return this;
        }

        /**
         * Adds a {@code basis} value.
         *
         * @param basis the value to add
         * @return this builder
         */
        public Builder addBasis(Reference basis) {
            this.basis.add(Objects.requireNonNull(basis, "basis"));
            return this;
        }

        /**
         * Replaces all {@code prediction} values.
         *
         * @param prediction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder prediction(List<Prediction> prediction) {
            this.prediction = prediction == null ? new ArrayList<>() : new ArrayList<>(prediction);
            return this;
        }

        /**
         * Adds a {@code prediction} value.
         *
         * @param prediction the value to add
         * @return this builder
         */
        public Builder addPrediction(Prediction prediction) {
            this.prediction.add(Objects.requireNonNull(prediction, "prediction"));
            return this;
        }

        /**
         * Sets {@code mitigation}.
         *
         * @param mitigation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder mitigation(FhirString mitigation) {
            this.mitigation = mitigation;
            return this;
        }

        /**
         * Sets {@code mitigation}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param mitigation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder mitigation(String mitigation) {
            return mitigation(mitigation == null ? null : FhirString.of(mitigation));
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
         * Builds the {@code RiskAssessment}.
         *
         * @return the {@code RiskAssessment}
         * @throws NullPointerException if a required element is absent
         */
        public RiskAssessment build() {
            return new RiskAssessment(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    basedOn, parent, status, method, code, subject, encounter, occurrence, condition, performer,
                    reason, basis, prediction, mitigation, note);
        }
    }
}
