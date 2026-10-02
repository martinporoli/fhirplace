package se.poroli.fhirplace.r5.clinicalimpression;

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
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.EventStatus;

/**
 * A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning
 * the treatments or management strategies that are best to manage a patient's condition.
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
 * @param identifier Business identifier.
 * @param status preparation | in-progress | not-done | on-hold | stopped | completed | entered-in-error | unknown.
 *   Required. Modifier element.
 * @param statusReason Reason for current status.
 * @param description Why/how the assessment was performed.
 * @param subject Patient or group assessed. Reference to Patient, Group. Required.
 * @param encounter The Encounter during which this ClinicalImpression was created. Reference to Encounter.
 * @param effective Time of assessment. One of dateTime, Period.
 * @param date When the assessment was documented.
 * @param performer The clinician performing the assessment. Reference to Practitioner, PractitionerRole.
 * @param previous Reference to last assessment. Reference to ClinicalImpression.
 * @param problem Relevant impressions of patient state. Reference to Condition, AllergyIntolerance.
 * @param changePattern Change in the status/pattern of a subject's condition since previously assessed, such as
 *   worsening, improving, or no change.
 * @param protocol Clinical Protocol followed.
 * @param summary Summary of the assessment.
 * @param finding Possible or likely findings and diagnoses.
 * @param prognosisCodeableConcept Estimate of likely outcome.
 * @param prognosisReference RiskAssessment expressing likely outcome. Reference to RiskAssessment.
 * @param supportingInfo Information supporting the clinical impression. Reference to Resource.
 * @param note Comments made about the ClinicalImpression.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ClinicalImpression">FHIR R5 ClinicalImpression</a>
 */
public record ClinicalImpression(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<EventStatus> status,
        CodeableConcept statusReason,
        FhirString description,
        Reference subject,
        Reference encounter,
        DataType effective,
        FhirDateTime date,
        Reference performer,
        Reference previous,
        List<Reference> problem,
        CodeableConcept changePattern,
        List<FhirUri> protocol,
        FhirString summary,
        List<Finding> finding,
        List<CodeableConcept> prognosisCodeableConcept,
        List<Reference> prognosisReference,
        List<Reference> supportingInfo,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates a {@code ClinicalImpression}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ClinicalImpression {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        problem = problem == null ? List.of() : List.copyOf(problem);
        protocol = protocol == null ? List.of() : List.copyOf(protocol);
        finding = finding == null ? List.of() : List.copyOf(finding);
        prognosisCodeableConcept =
                prognosisCodeableConcept == null ? List.of() : List.copyOf(prognosisCodeableConcept);
        prognosisReference = prognosisReference == null ? List.of() : List.copyOf(prognosisReference);
        supportingInfo = supportingInfo == null ? List.of() : List.copyOf(supportingInfo);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "ClinicalImpression.status is required");
        Objects.requireNonNull(subject, "ClinicalImpression.subject is required");
        if (effective != null && !(effective instanceof FhirDateTime || effective instanceof Period)) {
            throw new IllegalArgumentException(
                    "ClinicalImpression.effective[x] must be one of dateTime, Period, but was "
                            + effective.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code ClinicalImpression}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Specific findings or diagnoses that were considered likely or relevant to ongoing treatment.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param item What was found.
     * @param basis Which investigations support finding.
     */
    public record Finding(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference item,
            FhirString basis) implements BackboneElement {

        /**
         * Creates a {@code Finding}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Finding {
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
         * Returns a builder initialized with the values of this {@code Finding}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Finding}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference item;
            private FhirString basis;

            private Builder() {
            }

            private Builder(Finding original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.item = original.item();
                this.basis = original.basis();
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
             * Sets {@code basis}.
             *
             * @param basis the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder basis(FhirString basis) {
                this.basis = basis;
                return this;
            }

            /**
             * Sets {@code basis}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param basis the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder basis(String basis) {
                return basis(basis == null ? null : FhirString.of(basis));
            }

            /**
             * Builds the {@code Finding}.
             *
             * @return the {@code Finding}
             */
            public Finding build() {
                return new Finding(
                        id, extension, modifierExtension, item, basis);
            }
        }
    }

    /** Builder for {@link ClinicalImpression}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<EventStatus> status;
        private CodeableConcept statusReason;
        private FhirString description;
        private Reference subject;
        private Reference encounter;
        private DataType effective;
        private FhirDateTime date;
        private Reference performer;
        private Reference previous;
        private List<Reference> problem = new ArrayList<>();
        private CodeableConcept changePattern;
        private List<FhirUri> protocol = new ArrayList<>();
        private FhirString summary;
        private List<Finding> finding = new ArrayList<>();
        private List<CodeableConcept> prognosisCodeableConcept = new ArrayList<>();
        private List<Reference> prognosisReference = new ArrayList<>();
        private List<Reference> supportingInfo = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(ClinicalImpression original) {
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
            this.statusReason = original.statusReason();
            this.description = original.description();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.effective = original.effective();
            this.date = original.date();
            this.performer = original.performer();
            this.previous = original.previous();
            this.problem = new ArrayList<>(original.problem());
            this.changePattern = original.changePattern();
            this.protocol = new ArrayList<>(original.protocol());
            this.summary = original.summary();
            this.finding = new ArrayList<>(original.finding());
            this.prognosisCodeableConcept = new ArrayList<>(original.prognosisCodeableConcept());
            this.prognosisReference = new ArrayList<>(original.prognosisReference());
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
         * Sets {@code statusReason}.
         *
         * @param statusReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusReason(CodeableConcept statusReason) {
            this.statusReason = statusReason;
            return this;
        }

        /**
         * Sets {@code description}.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(FhirString description) {
            this.description = description;
            return this;
        }

        /**
         * Sets {@code description}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(String description) {
            return description(description == null ? null : FhirString.of(description));
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
         * Sets {@code effective} to a dateTime.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(FhirDateTime effective) {
            this.effective = effective;
            return this;
        }

        /**
         * Sets {@code effective} to a Period.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(Period effective) {
            this.effective = effective;
            return this;
        }

        /**
         * Sets {@code effective} to a dateTime without id or extensions.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(Temporal effective) {
            this.effective = effective == null ? null : FhirDateTime.of(effective);
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
         * Sets {@code previous}.
         *
         * @param previous the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder previous(Reference previous) {
            this.previous = previous;
            return this;
        }

        /**
         * Replaces all {@code problem} values.
         *
         * @param problem the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder problem(List<Reference> problem) {
            this.problem = problem == null ? new ArrayList<>() : new ArrayList<>(problem);
            return this;
        }

        /**
         * Adds a {@code problem} value.
         *
         * @param problem the value to add
         * @return this builder
         */
        public Builder addProblem(Reference problem) {
            this.problem.add(Objects.requireNonNull(problem, "problem"));
            return this;
        }

        /**
         * Sets {@code changePattern}.
         *
         * @param changePattern the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder changePattern(CodeableConcept changePattern) {
            this.changePattern = changePattern;
            return this;
        }

        /**
         * Replaces all {@code protocol} values.
         *
         * @param protocol the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder protocol(List<FhirUri> protocol) {
            this.protocol = protocol == null ? new ArrayList<>() : new ArrayList<>(protocol);
            return this;
        }

        /**
         * Adds a {@code protocol} value.
         *
         * @param protocol the value to add
         * @return this builder
         */
        public Builder addProtocol(FhirUri protocol) {
            this.protocol.add(Objects.requireNonNull(protocol, "protocol"));
            return this;
        }

        /**
         * Adds a {@code protocol} value, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param protocol the value to add
         * @return this builder
         */
        public Builder addProtocol(String protocol) {
            return addProtocol(FhirUri.of(protocol));
        }

        /**
         * Sets {@code summary}.
         *
         * @param summary the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder summary(FhirString summary) {
            this.summary = summary;
            return this;
        }

        /**
         * Sets {@code summary}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param summary the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder summary(String summary) {
            return summary(summary == null ? null : FhirString.of(summary));
        }

        /**
         * Replaces all {@code finding} values.
         *
         * @param finding the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder finding(List<Finding> finding) {
            this.finding = finding == null ? new ArrayList<>() : new ArrayList<>(finding);
            return this;
        }

        /**
         * Adds a {@code finding} value.
         *
         * @param finding the value to add
         * @return this builder
         */
        public Builder addFinding(Finding finding) {
            this.finding.add(Objects.requireNonNull(finding, "finding"));
            return this;
        }

        /**
         * Replaces all {@code prognosisCodeableConcept} values.
         *
         * @param prognosisCodeableConcept the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder prognosisCodeableConcept(List<CodeableConcept> prognosisCodeableConcept) {
            this.prognosisCodeableConcept = prognosisCodeableConcept == null
                    ? new ArrayList<>()
                    : new ArrayList<>(prognosisCodeableConcept);
            return this;
        }

        /**
         * Adds a {@code prognosisCodeableConcept} value.
         *
         * @param prognosisCodeableConcept the value to add
         * @return this builder
         */
        public Builder addPrognosisCodeableConcept(CodeableConcept prognosisCodeableConcept) {
            this.prognosisCodeableConcept.add(
                    Objects.requireNonNull(prognosisCodeableConcept, "prognosisCodeableConcept"));
            return this;
        }

        /**
         * Replaces all {@code prognosisReference} values.
         *
         * @param prognosisReference the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder prognosisReference(List<Reference> prognosisReference) {
            this.prognosisReference = prognosisReference == null
                    ? new ArrayList<>()
                    : new ArrayList<>(prognosisReference);
            return this;
        }

        /**
         * Adds a {@code prognosisReference} value.
         *
         * @param prognosisReference the value to add
         * @return this builder
         */
        public Builder addPrognosisReference(Reference prognosisReference) {
            this.prognosisReference.add(Objects.requireNonNull(prognosisReference, "prognosisReference"));
            return this;
        }

        /**
         * Replaces all {@code supportingInfo} values.
         *
         * @param supportingInfo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supportingInfo(List<Reference> supportingInfo) {
            this.supportingInfo = supportingInfo == null ? new ArrayList<>() : new ArrayList<>(supportingInfo);
            return this;
        }

        /**
         * Adds a {@code supportingInfo} value.
         *
         * @param supportingInfo the value to add
         * @return this builder
         */
        public Builder addSupportingInfo(Reference supportingInfo) {
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
         * Builds the {@code ClinicalImpression}.
         *
         * @return the {@code ClinicalImpression}
         * @throws NullPointerException if a required element is absent
         */
        public ClinicalImpression build() {
            return new ClinicalImpression(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, statusReason, description, subject, encounter, effective, date, performer, previous,
                    problem, changePattern, protocol, summary, finding, prognosisCodeableConcept, prognosisReference,
                    supportingInfo, note);
        }
    }
}
