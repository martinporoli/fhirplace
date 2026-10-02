package se.poroli.fhirplace.r5.researchstudy;

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
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A scientific study of nature that sometimes includes processes involved in health and disease.
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
 * @param url Canonical identifier for this study resource.
 * @param identifier Business Identifier for study.
 * @param version The business version for the study record.
 * @param name Name for this study (computer friendly).
 * @param title Human readable name of the study.
 * @param label Additional names for the study.
 * @param protocol Steps followed in executing study. Reference to PlanDefinition.
 * @param partOf Part of larger study. Reference to ResearchStudy.
 * @param relatedArtifact References, URLs, and attachments.
 * @param date Date the resource last changed.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param primaryPurposeType treatment | prevention | diagnostic | supportive-care | screening |
 *   health-services-research | basic-science | device-feasibility.
 * @param phase n-a | early-phase-1 | phase-1 | phase-1-phase-2 | phase-2 | phase-2-phase-3 | phase-3 | phase-4.
 * @param studyDesign Classifications of the study design characteristics.
 * @param focus Drugs, devices, etc. under study.
 * @param condition Condition being studied.
 * @param keyword Used to search for the study.
 * @param region Geographic area for the study.
 * @param descriptionSummary Brief text explaining the study.
 * @param description Detailed narrative of the study.
 * @param period When the study began and ended.
 * @param site Facility where study activities are conducted. Reference to Location, ResearchStudy, Organization.
 * @param note Comments made about the study.
 * @param classifier Classification for the study.
 * @param associatedParty Sponsors, collaborators, and other parties.
 * @param progressStatus Status of study with time for that status.
 * @param whyStopped accrual-goal-met | closed-due-to-toxicity | closed-due-to-lack-of-study-progress |
 *   temporarily-closed-per-study-design.
 * @param recruitment Target or actual group of participants enrolled in study.
 * @param comparisonGroup Defined path through the study for a subject.
 * @param objective A goal for the study.
 * @param outcomeMeasure A variable measured during the study.
 * @param result Link to results generated during the study. Reference to EvidenceReport, Citation, DiagnosticReport.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ResearchStudy">FHIR R5 ResearchStudy</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record ResearchStudy(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirUri url,
        List<Identifier> identifier,
        FhirString version,
        FhirString name,
        FhirString title,
        List<Label> label,
        List<Reference> protocol,
        List<Reference> partOf,
        List<RelatedArtifact> relatedArtifact,
        FhirDateTime date,
        FhirEnum<PublicationStatus> status,
        CodeableConcept primaryPurposeType,
        CodeableConcept phase,
        List<CodeableConcept> studyDesign,
        List<CodeableReference> focus,
        List<CodeableConcept> condition,
        List<CodeableConcept> keyword,
        List<CodeableConcept> region,
        FhirMarkdown descriptionSummary,
        FhirMarkdown description,
        Period period,
        List<Reference> site,
        List<Annotation> note,
        List<CodeableConcept> classifier,
        List<AssociatedParty> associatedParty,
        List<ProgressStatus> progressStatus,
        CodeableConcept whyStopped,
        Recruitment recruitment,
        List<ComparisonGroup> comparisonGroup,
        List<Objective> objective,
        List<OutcomeMeasure> outcomeMeasure,
        List<Reference> result) implements DomainResource {

    /**
     * Creates a {@code ResearchStudy}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public ResearchStudy {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        label = label == null ? List.of() : List.copyOf(label);
        protocol = protocol == null ? List.of() : List.copyOf(protocol);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
        studyDesign = studyDesign == null ? List.of() : List.copyOf(studyDesign);
        focus = focus == null ? List.of() : List.copyOf(focus);
        condition = condition == null ? List.of() : List.copyOf(condition);
        keyword = keyword == null ? List.of() : List.copyOf(keyword);
        region = region == null ? List.of() : List.copyOf(region);
        site = site == null ? List.of() : List.copyOf(site);
        note = note == null ? List.of() : List.copyOf(note);
        classifier = classifier == null ? List.of() : List.copyOf(classifier);
        associatedParty = associatedParty == null ? List.of() : List.copyOf(associatedParty);
        progressStatus = progressStatus == null ? List.of() : List.copyOf(progressStatus);
        comparisonGroup = comparisonGroup == null ? List.of() : List.copyOf(comparisonGroup);
        objective = objective == null ? List.of() : List.copyOf(objective);
        outcomeMeasure = outcomeMeasure == null ? List.of() : List.copyOf(outcomeMeasure);
        result = result == null ? List.of() : List.copyOf(result);
        Objects.requireNonNull(status, "ResearchStudy.status is required");
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
     * Returns a builder initialized with the values of this {@code ResearchStudy}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Additional names for the study.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type primary | official | scientific | plain-language | subtitle | short-title | acronym | earlier-title
     *   | language | auto-translated | human-use | machine-use | duplicate-uid.
     * @param value The name.
     */
    public record Label(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            FhirString value) implements BackboneElement {

        /**
         * Creates a {@code Label}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Label {
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
         * Returns a builder initialized with the values of this {@code Label}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Label}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private FhirString value;

            private Builder() {
            }

            private Builder(Label original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.value = original.value();
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
             * Sets {@code value}.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirString value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(String value) {
                return value(value == null ? null : FhirString.of(value));
            }

            /**
             * Builds the {@code Label}.
             *
             * @return the {@code Label}
             */
            public Label build() {
                return new Label(
                        id, extension, modifierExtension, type, value);
            }
        }
    }

    /**
     * Sponsors, collaborators, and other parties.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Name of associated party.
     * @param role sponsor | lead-sponsor | sponsor-investigator | primary-investigator | collaborator |
     *   funding-source | general-contact | recruitment-contact | sub-investigator | study-director | study-chair.
     *   Required.
     * @param period When active in the role.
     * @param classifier nih | fda | government | nonprofit | academic | industry.
     * @param party Individual or organization associated with study (use practitionerRole to specify their
     *   organisation). Reference to Practitioner, PractitionerRole, Organization.
     */
    public record AssociatedParty(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            CodeableConcept role,
            List<Period> period,
            List<CodeableConcept> classifier,
            Reference party) implements BackboneElement {

        /**
         * Creates an {@code AssociatedParty}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public AssociatedParty {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            period = period == null ? List.of() : List.copyOf(period);
            classifier = classifier == null ? List.of() : List.copyOf(classifier);
            Objects.requireNonNull(role, "ResearchStudy.associatedParty.role is required");
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
         * Returns a builder initialized with the values of this {@code AssociatedParty}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link AssociatedParty}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString name;
            private CodeableConcept role;
            private List<Period> period = new ArrayList<>();
            private List<CodeableConcept> classifier = new ArrayList<>();
            private Reference party;

            private Builder() {
            }

            private Builder(AssociatedParty original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.role = original.role();
                this.period = new ArrayList<>(original.period());
                this.classifier = new ArrayList<>(original.classifier());
                this.party = original.party();
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
             * Sets {@code role}.
             *
             * @param role the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder role(CodeableConcept role) {
                this.role = role;
                return this;
            }

            /**
             * Replaces all {@code period} values.
             *
             * @param period the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder period(List<Period> period) {
                this.period = period == null ? new ArrayList<>() : new ArrayList<>(period);
                return this;
            }

            /**
             * Adds a {@code period} value.
             *
             * @param period the value to add
             * @return this builder
             */
            public Builder addPeriod(Period period) {
                this.period.add(Objects.requireNonNull(period, "period"));
                return this;
            }

            /**
             * Replaces all {@code classifier} values.
             *
             * @param classifier the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder classifier(List<CodeableConcept> classifier) {
                this.classifier = classifier == null ? new ArrayList<>() : new ArrayList<>(classifier);
                return this;
            }

            /**
             * Adds a {@code classifier} value.
             *
             * @param classifier the value to add
             * @return this builder
             */
            public Builder addClassifier(CodeableConcept classifier) {
                this.classifier.add(Objects.requireNonNull(classifier, "classifier"));
                return this;
            }

            /**
             * Sets {@code party}.
             *
             * @param party the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder party(Reference party) {
                this.party = party;
                return this;
            }

            /**
             * Builds the {@code AssociatedParty}.
             *
             * @return the {@code AssociatedParty}
             * @throws NullPointerException if a required element is absent
             */
            public AssociatedParty build() {
                return new AssociatedParty(
                        id, extension, modifierExtension, name, role, period, classifier, party);
            }
        }
    }

    /**
     * Status of study with time for that status.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param state Label for status or state (e.g. recruitment status). Required.
     * @param actual Actual if true else anticipated.
     * @param period Date range.
     */
    public record ProgressStatus(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept state,
            FhirBoolean actual,
            Period period) implements BackboneElement {

        /**
         * Creates a {@code ProgressStatus}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ProgressStatus {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(state, "ResearchStudy.progressStatus.state is required");
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
         * Returns a builder initialized with the values of this {@code ProgressStatus}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ProgressStatus}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept state;
            private FhirBoolean actual;
            private Period period;

            private Builder() {
            }

            private Builder(ProgressStatus original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.state = original.state();
                this.actual = original.actual();
                this.period = original.period();
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
             * Sets {@code state}.
             *
             * @param state the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder state(CodeableConcept state) {
                this.state = state;
                return this;
            }

            /**
             * Sets {@code actual}.
             *
             * @param actual the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder actual(FhirBoolean actual) {
                this.actual = actual;
                return this;
            }

            /**
             * Sets {@code actual}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param actual the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder actual(Boolean actual) {
                return actual(actual == null ? null : FhirBoolean.of(actual));
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
             * Builds the {@code ProgressStatus}.
             *
             * @return the {@code ProgressStatus}
             * @throws NullPointerException if a required element is absent
             */
            public ProgressStatus build() {
                return new ProgressStatus(
                        id, extension, modifierExtension, state, actual, period);
            }
        }
    }

    /**
     * Target or actual group of participants enrolled in study.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param targetNumber Estimated total number of participants to be enrolled.
     * @param actualNumber Actual total number of participants enrolled in study.
     * @param eligibility Inclusion and exclusion criteria. Reference to Group, EvidenceVariable.
     * @param actualGroup Group of participants who were enrolled in study. Reference to Group.
     */
    public record Recruitment(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirUnsignedInt targetNumber,
            FhirUnsignedInt actualNumber,
            Reference eligibility,
            Reference actualGroup) implements BackboneElement {

        /**
         * Creates a {@code Recruitment}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Recruitment {
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
         * Returns a builder initialized with the values of this {@code Recruitment}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Recruitment}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirUnsignedInt targetNumber;
            private FhirUnsignedInt actualNumber;
            private Reference eligibility;
            private Reference actualGroup;

            private Builder() {
            }

            private Builder(Recruitment original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.targetNumber = original.targetNumber();
                this.actualNumber = original.actualNumber();
                this.eligibility = original.eligibility();
                this.actualGroup = original.actualGroup();
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
             * Sets {@code targetNumber}.
             *
             * @param targetNumber the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder targetNumber(FhirUnsignedInt targetNumber) {
                this.targetNumber = targetNumber;
                return this;
            }

            /**
             * Sets {@code targetNumber}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
             *
             * @param targetNumber the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder targetNumber(Integer targetNumber) {
                return targetNumber(targetNumber == null ? null : FhirUnsignedInt.of(targetNumber));
            }

            /**
             * Sets {@code actualNumber}.
             *
             * @param actualNumber the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder actualNumber(FhirUnsignedInt actualNumber) {
                this.actualNumber = actualNumber;
                return this;
            }

            /**
             * Sets {@code actualNumber}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
             *
             * @param actualNumber the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder actualNumber(Integer actualNumber) {
                return actualNumber(actualNumber == null ? null : FhirUnsignedInt.of(actualNumber));
            }

            /**
             * Sets {@code eligibility}.
             *
             * @param eligibility the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder eligibility(Reference eligibility) {
                this.eligibility = eligibility;
                return this;
            }

            /**
             * Sets {@code actualGroup}.
             *
             * @param actualGroup the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder actualGroup(Reference actualGroup) {
                this.actualGroup = actualGroup;
                return this;
            }

            /**
             * Builds the {@code Recruitment}.
             *
             * @return the {@code Recruitment}
             */
            public Recruitment build() {
                return new Recruitment(
                        id, extension, modifierExtension, targetNumber, actualNumber, eligibility, actualGroup);
            }
        }
    }

    /**
     * Describes an expected event or sequence of events for one of the subjects of a study.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param linkId Allows the comparisonGroup for the study and the comparisonGroup for the subject to be linked
     *   easily.
     * @param name Label for study comparisonGroup. Required.
     * @param type Categorization of study comparisonGroup.
     * @param description Short explanation of study path.
     * @param intendedExposure Interventions or exposures in this comparisonGroup or cohort. Reference to
     *   EvidenceVariable.
     * @param observedGroup Group of participants who were enrolled in study comparisonGroup. Reference to Group.
     */
    public record ComparisonGroup(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirId linkId,
            FhirString name,
            CodeableConcept type,
            FhirMarkdown description,
            List<Reference> intendedExposure,
            Reference observedGroup) implements BackboneElement {

        /**
         * Creates a {@code ComparisonGroup}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ComparisonGroup {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            intendedExposure = intendedExposure == null ? List.of() : List.copyOf(intendedExposure);
            Objects.requireNonNull(name, "ResearchStudy.comparisonGroup.name is required");
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
         * Returns a builder initialized with the values of this {@code ComparisonGroup}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ComparisonGroup}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirId linkId;
            private FhirString name;
            private CodeableConcept type;
            private FhirMarkdown description;
            private List<Reference> intendedExposure = new ArrayList<>();
            private Reference observedGroup;

            private Builder() {
            }

            private Builder(ComparisonGroup original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.linkId = original.linkId();
                this.name = original.name();
                this.type = original.type();
                this.description = original.description();
                this.intendedExposure = new ArrayList<>(original.intendedExposure());
                this.observedGroup = original.observedGroup();
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
             * Sets {@code linkId}.
             *
             * @param linkId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder linkId(FhirId linkId) {
                this.linkId = linkId;
                return this;
            }

            /**
             * Sets {@code linkId}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param linkId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder linkId(String linkId) {
                return linkId(linkId == null ? null : FhirId.of(linkId));
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
             * Replaces all {@code intendedExposure} values.
             *
             * @param intendedExposure the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder intendedExposure(List<Reference> intendedExposure) {
                this.intendedExposure = intendedExposure == null
                        ? new ArrayList<>()
                        : new ArrayList<>(intendedExposure);
                return this;
            }

            /**
             * Adds a {@code intendedExposure} value.
             *
             * @param intendedExposure the value to add
             * @return this builder
             */
            public Builder addIntendedExposure(Reference intendedExposure) {
                this.intendedExposure.add(Objects.requireNonNull(intendedExposure, "intendedExposure"));
                return this;
            }

            /**
             * Sets {@code observedGroup}.
             *
             * @param observedGroup the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder observedGroup(Reference observedGroup) {
                this.observedGroup = observedGroup;
                return this;
            }

            /**
             * Builds the {@code ComparisonGroup}.
             *
             * @return the {@code ComparisonGroup}
             * @throws NullPointerException if a required element is absent
             */
            public ComparisonGroup build() {
                return new ComparisonGroup(
                        id, extension, modifierExtension, linkId, name, type, description, intendedExposure,
                        observedGroup);
            }
        }
    }

    /**
     * A goal that the study is aiming to achieve in terms of a scientific question to be answered by the analysis of
     * data collected during the study.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Label for the objective.
     * @param type primary | secondary | exploratory.
     * @param description Description of the objective.
     */
    public record Objective(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            CodeableConcept type,
            FhirMarkdown description) implements BackboneElement {

        /**
         * Creates an {@code Objective}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Objective {
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
         * Returns a builder initialized with the values of this {@code Objective}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Objective}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString name;
            private CodeableConcept type;
            private FhirMarkdown description;

            private Builder() {
            }

            private Builder(Objective original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.type = original.type();
                this.description = original.description();
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
             * Builds the {@code Objective}.
             *
             * @return the {@code Objective}
             */
            public Objective build() {
                return new Objective(
                        id, extension, modifierExtension, name, type, description);
            }
        }
    }

    /**
     * An "outcome measure", "endpoint", "effect measure" or "measure of effect" is a specific measurement or
     * observation used to quantify the effect of experimental variables on the participants in a study, or for
     * observational studies, to describe patterns of diseases or traits or associations with exposures, risk factors
     * or treatment.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Label for the outcome.
     * @param type primary | secondary | exploratory.
     * @param description Description of the outcome.
     * @param reference Structured outcome definition. Reference to EvidenceVariable.
     */
    public record OutcomeMeasure(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            List<CodeableConcept> type,
            FhirMarkdown description,
            Reference reference) implements BackboneElement {

        /**
         * Creates an {@code OutcomeMeasure}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public OutcomeMeasure {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            type = type == null ? List.of() : List.copyOf(type);
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
         * Returns a builder initialized with the values of this {@code OutcomeMeasure}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link OutcomeMeasure}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString name;
            private List<CodeableConcept> type = new ArrayList<>();
            private FhirMarkdown description;
            private Reference reference;

            private Builder() {
            }

            private Builder(OutcomeMeasure original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.type = new ArrayList<>(original.type());
                this.description = original.description();
                this.reference = original.reference();
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
             * Sets {@code reference}.
             *
             * @param reference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reference(Reference reference) {
                this.reference = reference;
                return this;
            }

            /**
             * Builds the {@code OutcomeMeasure}.
             *
             * @return the {@code OutcomeMeasure}
             */
            public OutcomeMeasure build() {
                return new OutcomeMeasure(
                        id, extension, modifierExtension, name, type, description, reference);
            }
        }
    }

    /** Builder for {@link ResearchStudy}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirUri url;
        private List<Identifier> identifier = new ArrayList<>();
        private FhirString version;
        private FhirString name;
        private FhirString title;
        private List<Label> label = new ArrayList<>();
        private List<Reference> protocol = new ArrayList<>();
        private List<Reference> partOf = new ArrayList<>();
        private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
        private FhirDateTime date;
        private FhirEnum<PublicationStatus> status;
        private CodeableConcept primaryPurposeType;
        private CodeableConcept phase;
        private List<CodeableConcept> studyDesign = new ArrayList<>();
        private List<CodeableReference> focus = new ArrayList<>();
        private List<CodeableConcept> condition = new ArrayList<>();
        private List<CodeableConcept> keyword = new ArrayList<>();
        private List<CodeableConcept> region = new ArrayList<>();
        private FhirMarkdown descriptionSummary;
        private FhirMarkdown description;
        private Period period;
        private List<Reference> site = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<CodeableConcept> classifier = new ArrayList<>();
        private List<AssociatedParty> associatedParty = new ArrayList<>();
        private List<ProgressStatus> progressStatus = new ArrayList<>();
        private CodeableConcept whyStopped;
        private Recruitment recruitment;
        private List<ComparisonGroup> comparisonGroup = new ArrayList<>();
        private List<Objective> objective = new ArrayList<>();
        private List<OutcomeMeasure> outcomeMeasure = new ArrayList<>();
        private List<Reference> result = new ArrayList<>();

        private Builder() {
        }

        private Builder(ResearchStudy original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.url = original.url();
            this.identifier = new ArrayList<>(original.identifier());
            this.version = original.version();
            this.name = original.name();
            this.title = original.title();
            this.label = new ArrayList<>(original.label());
            this.protocol = new ArrayList<>(original.protocol());
            this.partOf = new ArrayList<>(original.partOf());
            this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
            this.date = original.date();
            this.status = original.status();
            this.primaryPurposeType = original.primaryPurposeType();
            this.phase = original.phase();
            this.studyDesign = new ArrayList<>(original.studyDesign());
            this.focus = new ArrayList<>(original.focus());
            this.condition = new ArrayList<>(original.condition());
            this.keyword = new ArrayList<>(original.keyword());
            this.region = new ArrayList<>(original.region());
            this.descriptionSummary = original.descriptionSummary();
            this.description = original.description();
            this.period = original.period();
            this.site = new ArrayList<>(original.site());
            this.note = new ArrayList<>(original.note());
            this.classifier = new ArrayList<>(original.classifier());
            this.associatedParty = new ArrayList<>(original.associatedParty());
            this.progressStatus = new ArrayList<>(original.progressStatus());
            this.whyStopped = original.whyStopped();
            this.recruitment = original.recruitment();
            this.comparisonGroup = new ArrayList<>(original.comparisonGroup());
            this.objective = new ArrayList<>(original.objective());
            this.outcomeMeasure = new ArrayList<>(original.outcomeMeasure());
            this.result = new ArrayList<>(original.result());
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
         * Sets {@code url}.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(FhirUri url) {
            this.url = url;
            return this;
        }

        /**
         * Sets {@code url}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(String url) {
            return url(url == null ? null : FhirUri.of(url));
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
         * Sets {@code version}.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(FhirString version) {
            this.version = version;
            return this;
        }

        /**
         * Sets {@code version}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(String version) {
            return version(version == null ? null : FhirString.of(version));
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
         * Sets {@code title}.
         *
         * @param title the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder title(FhirString title) {
            this.title = title;
            return this;
        }

        /**
         * Sets {@code title}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param title the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder title(String title) {
            return title(title == null ? null : FhirString.of(title));
        }

        /**
         * Replaces all {@code label} values.
         *
         * @param label the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder label(List<Label> label) {
            this.label = label == null ? new ArrayList<>() : new ArrayList<>(label);
            return this;
        }

        /**
         * Adds a {@code label} value.
         *
         * @param label the value to add
         * @return this builder
         */
        public Builder addLabel(Label label) {
            this.label.add(Objects.requireNonNull(label, "label"));
            return this;
        }

        /**
         * Replaces all {@code protocol} values.
         *
         * @param protocol the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder protocol(List<Reference> protocol) {
            this.protocol = protocol == null ? new ArrayList<>() : new ArrayList<>(protocol);
            return this;
        }

        /**
         * Adds a {@code protocol} value.
         *
         * @param protocol the value to add
         * @return this builder
         */
        public Builder addProtocol(Reference protocol) {
            this.protocol.add(Objects.requireNonNull(protocol, "protocol"));
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
         * Replaces all {@code relatedArtifact} values.
         *
         * @param relatedArtifact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relatedArtifact(List<RelatedArtifact> relatedArtifact) {
            this.relatedArtifact = relatedArtifact == null ? new ArrayList<>() : new ArrayList<>(relatedArtifact);
            return this;
        }

        /**
         * Adds a {@code relatedArtifact} value.
         *
         * @param relatedArtifact the value to add
         * @return this builder
         */
        public Builder addRelatedArtifact(RelatedArtifact relatedArtifact) {
            this.relatedArtifact.add(Objects.requireNonNull(relatedArtifact, "relatedArtifact"));
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
         * Sets {@code primaryPurposeType}.
         *
         * @param primaryPurposeType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder primaryPurposeType(CodeableConcept primaryPurposeType) {
            this.primaryPurposeType = primaryPurposeType;
            return this;
        }

        /**
         * Sets {@code phase}.
         *
         * @param phase the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder phase(CodeableConcept phase) {
            this.phase = phase;
            return this;
        }

        /**
         * Replaces all {@code studyDesign} values.
         *
         * @param studyDesign the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder studyDesign(List<CodeableConcept> studyDesign) {
            this.studyDesign = studyDesign == null ? new ArrayList<>() : new ArrayList<>(studyDesign);
            return this;
        }

        /**
         * Adds a {@code studyDesign} value.
         *
         * @param studyDesign the value to add
         * @return this builder
         */
        public Builder addStudyDesign(CodeableConcept studyDesign) {
            this.studyDesign.add(Objects.requireNonNull(studyDesign, "studyDesign"));
            return this;
        }

        /**
         * Replaces all {@code focus} values.
         *
         * @param focus the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder focus(List<CodeableReference> focus) {
            this.focus = focus == null ? new ArrayList<>() : new ArrayList<>(focus);
            return this;
        }

        /**
         * Adds a {@code focus} value.
         *
         * @param focus the value to add
         * @return this builder
         */
        public Builder addFocus(CodeableReference focus) {
            this.focus.add(Objects.requireNonNull(focus, "focus"));
            return this;
        }

        /**
         * Replaces all {@code condition} values.
         *
         * @param condition the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder condition(List<CodeableConcept> condition) {
            this.condition = condition == null ? new ArrayList<>() : new ArrayList<>(condition);
            return this;
        }

        /**
         * Adds a {@code condition} value.
         *
         * @param condition the value to add
         * @return this builder
         */
        public Builder addCondition(CodeableConcept condition) {
            this.condition.add(Objects.requireNonNull(condition, "condition"));
            return this;
        }

        /**
         * Replaces all {@code keyword} values.
         *
         * @param keyword the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder keyword(List<CodeableConcept> keyword) {
            this.keyword = keyword == null ? new ArrayList<>() : new ArrayList<>(keyword);
            return this;
        }

        /**
         * Adds a {@code keyword} value.
         *
         * @param keyword the value to add
         * @return this builder
         */
        public Builder addKeyword(CodeableConcept keyword) {
            this.keyword.add(Objects.requireNonNull(keyword, "keyword"));
            return this;
        }

        /**
         * Replaces all {@code region} values.
         *
         * @param region the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder region(List<CodeableConcept> region) {
            this.region = region == null ? new ArrayList<>() : new ArrayList<>(region);
            return this;
        }

        /**
         * Adds a {@code region} value.
         *
         * @param region the value to add
         * @return this builder
         */
        public Builder addRegion(CodeableConcept region) {
            this.region.add(Objects.requireNonNull(region, "region"));
            return this;
        }

        /**
         * Sets {@code descriptionSummary}.
         *
         * @param descriptionSummary the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder descriptionSummary(FhirMarkdown descriptionSummary) {
            this.descriptionSummary = descriptionSummary;
            return this;
        }

        /**
         * Sets {@code descriptionSummary}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param descriptionSummary the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder descriptionSummary(String descriptionSummary) {
            return descriptionSummary(descriptionSummary == null ? null : FhirMarkdown.of(descriptionSummary));
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
         * Replaces all {@code site} values.
         *
         * @param site the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder site(List<Reference> site) {
            this.site = site == null ? new ArrayList<>() : new ArrayList<>(site);
            return this;
        }

        /**
         * Adds a {@code site} value.
         *
         * @param site the value to add
         * @return this builder
         */
        public Builder addSite(Reference site) {
            this.site.add(Objects.requireNonNull(site, "site"));
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
         * Replaces all {@code classifier} values.
         *
         * @param classifier the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder classifier(List<CodeableConcept> classifier) {
            this.classifier = classifier == null ? new ArrayList<>() : new ArrayList<>(classifier);
            return this;
        }

        /**
         * Adds a {@code classifier} value.
         *
         * @param classifier the value to add
         * @return this builder
         */
        public Builder addClassifier(CodeableConcept classifier) {
            this.classifier.add(Objects.requireNonNull(classifier, "classifier"));
            return this;
        }

        /**
         * Replaces all {@code associatedParty} values.
         *
         * @param associatedParty the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder associatedParty(List<AssociatedParty> associatedParty) {
            this.associatedParty = associatedParty == null ? new ArrayList<>() : new ArrayList<>(associatedParty);
            return this;
        }

        /**
         * Adds a {@code associatedParty} value.
         *
         * @param associatedParty the value to add
         * @return this builder
         */
        public Builder addAssociatedParty(AssociatedParty associatedParty) {
            this.associatedParty.add(Objects.requireNonNull(associatedParty, "associatedParty"));
            return this;
        }

        /**
         * Replaces all {@code progressStatus} values.
         *
         * @param progressStatus the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder progressStatus(List<ProgressStatus> progressStatus) {
            this.progressStatus = progressStatus == null ? new ArrayList<>() : new ArrayList<>(progressStatus);
            return this;
        }

        /**
         * Adds a {@code progressStatus} value.
         *
         * @param progressStatus the value to add
         * @return this builder
         */
        public Builder addProgressStatus(ProgressStatus progressStatus) {
            this.progressStatus.add(Objects.requireNonNull(progressStatus, "progressStatus"));
            return this;
        }

        /**
         * Sets {@code whyStopped}.
         *
         * @param whyStopped the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder whyStopped(CodeableConcept whyStopped) {
            this.whyStopped = whyStopped;
            return this;
        }

        /**
         * Sets {@code recruitment}.
         *
         * @param recruitment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recruitment(Recruitment recruitment) {
            this.recruitment = recruitment;
            return this;
        }

        /**
         * Replaces all {@code comparisonGroup} values.
         *
         * @param comparisonGroup the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder comparisonGroup(List<ComparisonGroup> comparisonGroup) {
            this.comparisonGroup = comparisonGroup == null ? new ArrayList<>() : new ArrayList<>(comparisonGroup);
            return this;
        }

        /**
         * Adds a {@code comparisonGroup} value.
         *
         * @param comparisonGroup the value to add
         * @return this builder
         */
        public Builder addComparisonGroup(ComparisonGroup comparisonGroup) {
            this.comparisonGroup.add(Objects.requireNonNull(comparisonGroup, "comparisonGroup"));
            return this;
        }

        /**
         * Replaces all {@code objective} values.
         *
         * @param objective the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder objective(List<Objective> objective) {
            this.objective = objective == null ? new ArrayList<>() : new ArrayList<>(objective);
            return this;
        }

        /**
         * Adds a {@code objective} value.
         *
         * @param objective the value to add
         * @return this builder
         */
        public Builder addObjective(Objective objective) {
            this.objective.add(Objects.requireNonNull(objective, "objective"));
            return this;
        }

        /**
         * Replaces all {@code outcomeMeasure} values.
         *
         * @param outcomeMeasure the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder outcomeMeasure(List<OutcomeMeasure> outcomeMeasure) {
            this.outcomeMeasure = outcomeMeasure == null ? new ArrayList<>() : new ArrayList<>(outcomeMeasure);
            return this;
        }

        /**
         * Adds a {@code outcomeMeasure} value.
         *
         * @param outcomeMeasure the value to add
         * @return this builder
         */
        public Builder addOutcomeMeasure(OutcomeMeasure outcomeMeasure) {
            this.outcomeMeasure.add(Objects.requireNonNull(outcomeMeasure, "outcomeMeasure"));
            return this;
        }

        /**
         * Replaces all {@code result} values.
         *
         * @param result the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder result(List<Reference> result) {
            this.result = result == null ? new ArrayList<>() : new ArrayList<>(result);
            return this;
        }

        /**
         * Adds a {@code result} value.
         *
         * @param result the value to add
         * @return this builder
         */
        public Builder addResult(Reference result) {
            this.result.add(Objects.requireNonNull(result, "result"));
            return this;
        }

        /**
         * Builds the {@code ResearchStudy}.
         *
         * @return the {@code ResearchStudy}
         * @throws NullPointerException if a required element is absent
         */
        public ResearchStudy build() {
            return new ResearchStudy(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, name, title, label, protocol, partOf, relatedArtifact, date, status, primaryPurposeType,
                    phase, studyDesign, focus, condition, keyword, region, descriptionSummary, description, period,
                    site, note, classifier, associatedParty, progressStatus, whyStopped, recruitment, comparisonGroup,
                    objective, outcomeMeasure, result);
        }
    }
}
