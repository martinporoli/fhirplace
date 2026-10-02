package se.poroli.fhirplace.r5.researchsubject;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A ResearchSubject is a participant or object which is the recipient of investigative activities in a research
 * study.
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
 * @param identifier Business Identifier for research subject in a study.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param progress Subject status.
 * @param period Start and end of participation.
 * @param study Study subject is part of. Reference to ResearchStudy. Required.
 * @param subject Who or what is part of study. Reference to Patient, Group, Specimen, Device, Medication, Substance,
 *   BiologicallyDerivedProduct. Required.
 * @param assignedComparisonGroup What path should be followed.
 * @param actualComparisonGroup What path was followed.
 * @param consent Agreement to participate in study. Reference to Consent.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ResearchSubject">FHIR R5 ResearchSubject</a>
 */
public record ResearchSubject(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<PublicationStatus> status,
        List<Progress> progress,
        Period period,
        Reference study,
        Reference subject,
        FhirId assignedComparisonGroup,
        FhirId actualComparisonGroup,
        List<Reference> consent) implements DomainResource {

    /**
     * Creates a {@code ResearchSubject}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public ResearchSubject {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        progress = progress == null ? List.of() : List.copyOf(progress);
        consent = consent == null ? List.of() : List.copyOf(consent);
        Objects.requireNonNull(status, "ResearchSubject.status is required");
        Objects.requireNonNull(study, "ResearchSubject.study is required");
        Objects.requireNonNull(subject, "ResearchSubject.subject is required");
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
     * Returns a builder initialized with the values of this {@code ResearchSubject}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The current state (status) of the subject and resons for status change where appropriate.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type state | milestone.
     * @param subjectState candidate | eligible | follow-up | ineligible | not-registered | off-study | on-study |
     *   on-study-intervention | on-study-observation | pending-on-study | potential-candidate | screening |
     *   withdrawn.
     * @param milestone SignedUp | Screened | Randomized.
     * @param reason State change reason.
     * @param startDate State change date.
     * @param endDate State change date.
     */
    public record Progress(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            CodeableConcept subjectState,
            CodeableConcept milestone,
            CodeableConcept reason,
            FhirDateTime startDate,
            FhirDateTime endDate) implements BackboneElement {

        /**
         * Creates a {@code Progress}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Progress {
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
         * Returns a builder initialized with the values of this {@code Progress}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Progress}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private CodeableConcept subjectState;
            private CodeableConcept milestone;
            private CodeableConcept reason;
            private FhirDateTime startDate;
            private FhirDateTime endDate;

            private Builder() {
            }

            private Builder(Progress original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.subjectState = original.subjectState();
                this.milestone = original.milestone();
                this.reason = original.reason();
                this.startDate = original.startDate();
                this.endDate = original.endDate();
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
             * Sets {@code subjectState}.
             *
             * @param subjectState the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subjectState(CodeableConcept subjectState) {
                this.subjectState = subjectState;
                return this;
            }

            /**
             * Sets {@code milestone}.
             *
             * @param milestone the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder milestone(CodeableConcept milestone) {
                this.milestone = milestone;
                return this;
            }

            /**
             * Sets {@code reason}.
             *
             * @param reason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reason(CodeableConcept reason) {
                this.reason = reason;
                return this;
            }

            /**
             * Sets {@code startDate}.
             *
             * @param startDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder startDate(FhirDateTime startDate) {
                this.startDate = startDate;
                return this;
            }

            /**
             * Sets {@code startDate}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param startDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder startDate(Temporal startDate) {
                return startDate(startDate == null ? null : FhirDateTime.of(startDate));
            }

            /**
             * Sets {@code endDate}.
             *
             * @param endDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder endDate(FhirDateTime endDate) {
                this.endDate = endDate;
                return this;
            }

            /**
             * Sets {@code endDate}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param endDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder endDate(Temporal endDate) {
                return endDate(endDate == null ? null : FhirDateTime.of(endDate));
            }

            /**
             * Builds the {@code Progress}.
             *
             * @return the {@code Progress}
             */
            public Progress build() {
                return new Progress(
                        id, extension, modifierExtension, type, subjectState, milestone, reason, startDate, endDate);
            }
        }
    }

    /** Builder for {@link ResearchSubject}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<PublicationStatus> status;
        private List<Progress> progress = new ArrayList<>();
        private Period period;
        private Reference study;
        private Reference subject;
        private FhirId assignedComparisonGroup;
        private FhirId actualComparisonGroup;
        private List<Reference> consent = new ArrayList<>();

        private Builder() {
        }

        private Builder(ResearchSubject original) {
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
            this.progress = new ArrayList<>(original.progress());
            this.period = original.period();
            this.study = original.study();
            this.subject = original.subject();
            this.assignedComparisonGroup = original.assignedComparisonGroup();
            this.actualComparisonGroup = original.actualComparisonGroup();
            this.consent = new ArrayList<>(original.consent());
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
        public Builder status(FhirEnum<PublicationStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(PublicationStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Replaces all {@code progress} values.
         *
         * @param progress the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder progress(List<Progress> progress) {
            this.progress = progress == null ? new ArrayList<>() : new ArrayList<>(progress);
            return this;
        }

        /**
         * Adds a {@code progress} value.
         *
         * @param progress the value to add
         * @return this builder
         */
        public Builder addProgress(Progress progress) {
            this.progress.add(Objects.requireNonNull(progress, "progress"));
            return this;
        }

        /**
         * Sets {@code period}.
         *
         * @param period the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder period(Period period) {
            this.period = period;
            return this;
        }

        /**
         * Sets {@code study}.
         *
         * @param study the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder study(Reference study) {
            this.study = study;
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
         * Sets {@code assignedComparisonGroup}.
         *
         * @param assignedComparisonGroup the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder assignedComparisonGroup(FhirId assignedComparisonGroup) {
            this.assignedComparisonGroup = assignedComparisonGroup;
            return this;
        }

        /**
         * Sets {@code assignedComparisonGroup}, wrapped in a {@link FhirId} without id or extensions.
         *
         * @param assignedComparisonGroup the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder assignedComparisonGroup(String assignedComparisonGroup) {
            return assignedComparisonGroup(
                    assignedComparisonGroup == null ? null : FhirId.of(assignedComparisonGroup));
        }

        /**
         * Sets {@code actualComparisonGroup}.
         *
         * @param actualComparisonGroup the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder actualComparisonGroup(FhirId actualComparisonGroup) {
            this.actualComparisonGroup = actualComparisonGroup;
            return this;
        }

        /**
         * Sets {@code actualComparisonGroup}, wrapped in a {@link FhirId} without id or extensions.
         *
         * @param actualComparisonGroup the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder actualComparisonGroup(String actualComparisonGroup) {
            return actualComparisonGroup(actualComparisonGroup == null ? null : FhirId.of(actualComparisonGroup));
        }

        /**
         * Replaces all {@code consent} values.
         *
         * @param consent the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder consent(List<Reference> consent) {
            this.consent = consent == null ? new ArrayList<>() : new ArrayList<>(consent);
            return this;
        }

        /**
         * Adds a {@code consent} value.
         *
         * @param consent the value to add
         * @return this builder
         */
        public Builder addConsent(Reference consent) {
            this.consent.add(Objects.requireNonNull(consent, "consent"));
            return this;
        }

        /**
         * Builds the {@code ResearchSubject}.
         *
         * @return the {@code ResearchSubject}
         * @throws NullPointerException if a required element is absent
         */
        public ResearchSubject build() {
            return new ResearchSubject(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, progress, period, study, subject, assignedComparisonGroup, actualComparisonGroup, consent);
        }
    }
}
