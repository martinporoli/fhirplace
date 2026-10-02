package se.poroli.fhirplace.r5.evidence;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
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
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.EvidenceVariableHandling;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * The Evidence Resource provides a machine-interpretable expression of an evidence concept including the evidence
 * variables (e.g., population, exposures/interventions, comparators, outcomes, measured variables, confounding
 * variables), the statistics, and the certainty of this evidence.
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
 * @param url Canonical identifier for this evidence, represented as a globally unique URI.
 * @param identifier Additional identifier for the summary.
 * @param version Business version of this summary.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this summary (machine friendly).
 * @param title Name for this summary (human friendly).
 * @param citeAs Citation for this evidence. One of Reference, markdown.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param approvalDate When the summary was approved by publisher.
 * @param lastReviewDate When the summary was last reviewed by the publisher.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param author Who authored the content.
 * @param editor Who edited the content.
 * @param reviewer Who reviewed the content.
 * @param endorser Who endorsed the content.
 * @param useContext The context that the content is intended to support.
 * @param purpose Why this Evidence is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param relatedArtifact Link or citation to artifact associated with the summary.
 * @param description Description of the particular summary.
 * @param assertion Declarative description of the Evidence.
 * @param note Footnotes and/or explanatory notes.
 * @param variableDefinition Evidence variable such as population, exposure, or outcome. Required.
 * @param synthesisType The method to combine studies.
 * @param studyDesign The design of the study that produced this evidence.
 * @param statistic Values and parameters for a single statistic.
 * @param certainty Certainty or quality of the evidence.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Evidence">FHIR R5 Evidence</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Evidence(
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
        DataType versionAlgorithm,
        FhirString name,
        FhirString title,
        DataType citeAs,
        FhirEnum<PublicationStatus> status,
        FhirBoolean experimental,
        FhirDateTime date,
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        FhirString publisher,
        List<ContactDetail> contact,
        List<ContactDetail> author,
        List<ContactDetail> editor,
        List<ContactDetail> reviewer,
        List<ContactDetail> endorser,
        List<UsageContext> useContext,
        FhirMarkdown purpose,
        FhirMarkdown copyright,
        FhirString copyrightLabel,
        List<RelatedArtifact> relatedArtifact,
        FhirMarkdown description,
        FhirMarkdown assertion,
        List<Annotation> note,
        List<VariableDefinition> variableDefinition,
        CodeableConcept synthesisType,
        List<CodeableConcept> studyDesign,
        List<Statistic> statistic,
        List<Certainty> certainty) implements DomainResource {

    /**
     * Creates an {@code Evidence}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Evidence {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        author = author == null ? List.of() : List.copyOf(author);
        editor = editor == null ? List.of() : List.copyOf(editor);
        reviewer = reviewer == null ? List.of() : List.copyOf(reviewer);
        endorser = endorser == null ? List.of() : List.copyOf(endorser);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
        note = note == null ? List.of() : List.copyOf(note);
        variableDefinition = variableDefinition == null ? List.of() : List.copyOf(variableDefinition);
        studyDesign = studyDesign == null ? List.of() : List.copyOf(studyDesign);
        statistic = statistic == null ? List.of() : List.copyOf(statistic);
        certainty = certainty == null ? List.of() : List.copyOf(certainty);
        Objects.requireNonNull(status, "Evidence.status is required");
        if (variableDefinition.isEmpty()) {
            throw new IllegalArgumentException("Evidence.variableDefinition requires at least one value");
        }
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "Evidence.versionAlgorithm[x] must be one of string, Coding, but was "
                            + versionAlgorithm.getClass().getSimpleName());
        }
        if (citeAs != null && !(citeAs instanceof Reference || citeAs instanceof FhirMarkdown)) {
            throw new IllegalArgumentException(
                    "Evidence.citeAs[x] must be one of Reference, markdown, but was "
                            + citeAs.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Evidence}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Evidence variable such as population, exposure, or outcome.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param description A text description or summary of the variable.
     * @param note Footnotes and/or explanatory notes.
     * @param variableRole population | subpopulation | exposure | referenceExposure | measuredVariable | confounder.
     *   Required.
     * @param observed Definition of the actual variable related to the statistic(s). Reference to Group,
     *   EvidenceVariable.
     * @param intended Definition of the intended variable related to the Evidence. Reference to Group,
     *   EvidenceVariable.
     * @param directnessMatch low | moderate | high | exact.
     */
    public record VariableDefinition(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirMarkdown description,
            List<Annotation> note,
            CodeableConcept variableRole,
            Reference observed,
            Reference intended,
            CodeableConcept directnessMatch) implements BackboneElement {

        /**
         * Creates a {@code VariableDefinition}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public VariableDefinition {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            note = note == null ? List.of() : List.copyOf(note);
            Objects.requireNonNull(variableRole, "Evidence.variableDefinition.variableRole is required");
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
         * Returns a builder initialized with the values of this {@code VariableDefinition}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link VariableDefinition}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirMarkdown description;
            private List<Annotation> note = new ArrayList<>();
            private CodeableConcept variableRole;
            private Reference observed;
            private Reference intended;
            private CodeableConcept directnessMatch;

            private Builder() {
            }

            private Builder(VariableDefinition original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.description = original.description();
                this.note = new ArrayList<>(original.note());
                this.variableRole = original.variableRole();
                this.observed = original.observed();
                this.intended = original.intended();
                this.directnessMatch = original.directnessMatch();
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
             * Sets {@code variableRole}.
             *
             * @param variableRole the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder variableRole(CodeableConcept variableRole) {
                this.variableRole = variableRole;
                return this;
            }

            /**
             * Sets {@code observed}.
             *
             * @param observed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder observed(Reference observed) {
                this.observed = observed;
                return this;
            }

            /**
             * Sets {@code intended}.
             *
             * @param intended the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder intended(Reference intended) {
                this.intended = intended;
                return this;
            }

            /**
             * Sets {@code directnessMatch}.
             *
             * @param directnessMatch the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder directnessMatch(CodeableConcept directnessMatch) {
                this.directnessMatch = directnessMatch;
                return this;
            }

            /**
             * Builds the {@code VariableDefinition}.
             *
             * @return the {@code VariableDefinition}
             * @throws NullPointerException if a required element is absent
             */
            public VariableDefinition build() {
                return new VariableDefinition(
                        id, extension, modifierExtension, description, note, variableRole, observed, intended,
                        directnessMatch);
            }
        }
    }

    /**
     * Values and parameters for a single statistic.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param description Description of content.
     * @param note Footnotes and/or explanatory notes.
     * @param statisticType Type of statistic, e.g., relative risk.
     * @param category Associated category for categorical variable.
     * @param quantity Statistic value.
     * @param numberOfEvents The number of events associated with the statistic.
     * @param numberAffected The number of participants affected.
     * @param sampleSize Number of samples in the statistic.
     * @param attributeEstimate An attribute of the Statistic.
     * @param modelCharacteristic An aspect of the statistical model.
     */
    public record Statistic(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirMarkdown description,
            List<Annotation> note,
            CodeableConcept statisticType,
            CodeableConcept category,
            Quantity quantity,
            FhirUnsignedInt numberOfEvents,
            FhirUnsignedInt numberAffected,
            SampleSize sampleSize,
            List<AttributeEstimate> attributeEstimate,
            List<ModelCharacteristic> modelCharacteristic) implements BackboneElement {

        /**
         * Creates a {@code Statistic}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Statistic {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            note = note == null ? List.of() : List.copyOf(note);
            attributeEstimate = attributeEstimate == null ? List.of() : List.copyOf(attributeEstimate);
            modelCharacteristic = modelCharacteristic == null ? List.of() : List.copyOf(modelCharacteristic);
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
         * Returns a builder initialized with the values of this {@code Statistic}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Number of samples in the statistic.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param description Textual description of sample size for statistic.
         * @param note Footnote or explanatory note about the sample size.
         * @param numberOfStudies Number of contributing studies.
         * @param numberOfParticipants Cumulative number of participants.
         * @param knownDataCount Number of participants with known results for measured variables.
         */
        public record SampleSize(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirMarkdown description,
                List<Annotation> note,
                FhirUnsignedInt numberOfStudies,
                FhirUnsignedInt numberOfParticipants,
                FhirUnsignedInt knownDataCount) implements BackboneElement {

            /**
             * Creates a {@code SampleSize}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public SampleSize {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                note = note == null ? List.of() : List.copyOf(note);
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
             * Returns a builder initialized with the values of this {@code SampleSize}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link SampleSize}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirMarkdown description;
                private List<Annotation> note = new ArrayList<>();
                private FhirUnsignedInt numberOfStudies;
                private FhirUnsignedInt numberOfParticipants;
                private FhirUnsignedInt knownDataCount;

                private Builder() {
                }

                private Builder(SampleSize original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.description = original.description();
                    this.note = new ArrayList<>(original.note());
                    this.numberOfStudies = original.numberOfStudies();
                    this.numberOfParticipants = original.numberOfParticipants();
                    this.knownDataCount = original.knownDataCount();
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
                 * Sets {@code numberOfStudies}.
                 *
                 * @param numberOfStudies the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder numberOfStudies(FhirUnsignedInt numberOfStudies) {
                    this.numberOfStudies = numberOfStudies;
                    return this;
                }

                /**
                 * Sets {@code numberOfStudies}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
                 *
                 * @param numberOfStudies the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder numberOfStudies(Integer numberOfStudies) {
                    return numberOfStudies(numberOfStudies == null ? null : FhirUnsignedInt.of(numberOfStudies));
                }

                /**
                 * Sets {@code numberOfParticipants}.
                 *
                 * @param numberOfParticipants the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder numberOfParticipants(FhirUnsignedInt numberOfParticipants) {
                    this.numberOfParticipants = numberOfParticipants;
                    return this;
                }

                /**
                 * Sets {@code numberOfParticipants}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
                 *
                 * @param numberOfParticipants the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder numberOfParticipants(Integer numberOfParticipants) {
                    return numberOfParticipants(
                            numberOfParticipants == null ? null : FhirUnsignedInt.of(numberOfParticipants));
                }

                /**
                 * Sets {@code knownDataCount}.
                 *
                 * @param knownDataCount the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder knownDataCount(FhirUnsignedInt knownDataCount) {
                    this.knownDataCount = knownDataCount;
                    return this;
                }

                /**
                 * Sets {@code knownDataCount}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
                 *
                 * @param knownDataCount the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder knownDataCount(Integer knownDataCount) {
                    return knownDataCount(knownDataCount == null ? null : FhirUnsignedInt.of(knownDataCount));
                }

                /**
                 * Builds the {@code SampleSize}.
                 *
                 * @return the {@code SampleSize}
                 */
                public SampleSize build() {
                    return new SampleSize(
                            id, extension, modifierExtension, description, note, numberOfStudies,
                            numberOfParticipants, knownDataCount);
                }
            }
        }

        /**
         * A statistical attribute of the statistic such as a measure of heterogeneity.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param description Textual description of the attribute estimate.
         * @param note Footnote or explanatory note about the estimate.
         * @param type The type of attribute estimate, e.g., confidence interval or p value.
         * @param quantity The singular quantity of the attribute estimate, for attribute estimates represented as
         *   single values; also used to report unit of measure.
         * @param level Level of confidence interval, e.g., 0.95 for 95% confidence interval.
         * @param range Lower and upper bound values of the attribute estimate.
         * @param attributeEstimate A nested attribute estimate; which is the attribute estimate of an attribute
         *   estimate.
         */
        public record AttributeEstimate(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirMarkdown description,
                List<Annotation> note,
                CodeableConcept type,
                Quantity quantity,
                FhirDecimal level,
                Range range,
                List<Evidence.Statistic.AttributeEstimate> attributeEstimate) implements BackboneElement {

            /**
             * Creates an {@code AttributeEstimate}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public AttributeEstimate {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                note = note == null ? List.of() : List.copyOf(note);
                attributeEstimate = attributeEstimate == null ? List.of() : List.copyOf(attributeEstimate);
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
             * Returns a builder initialized with the values of this {@code AttributeEstimate}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link AttributeEstimate}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirMarkdown description;
                private List<Annotation> note = new ArrayList<>();
                private CodeableConcept type;
                private Quantity quantity;
                private FhirDecimal level;
                private Range range;
                private List<Evidence.Statistic.AttributeEstimate> attributeEstimate = new ArrayList<>();

                private Builder() {
                }

                private Builder(AttributeEstimate original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.description = original.description();
                    this.note = new ArrayList<>(original.note());
                    this.type = original.type();
                    this.quantity = original.quantity();
                    this.level = original.level();
                    this.range = original.range();
                    this.attributeEstimate = new ArrayList<>(original.attributeEstimate());
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
                 * Sets {@code level}.
                 *
                 * @param level the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder level(FhirDecimal level) {
                    this.level = level;
                    return this;
                }

                /**
                 * Sets {@code level}, wrapped in a {@link FhirDecimal} without id or extensions.
                 *
                 * @param level the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder level(BigDecimal level) {
                    return level(level == null ? null : FhirDecimal.of(level));
                }

                /**
                 * Sets {@code range}.
                 *
                 * @param range the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder range(Range range) {
                    this.range = range;
                    return this;
                }

                /**
                 * Replaces all {@code attributeEstimate} values.
                 *
                 * @param attributeEstimate the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder attributeEstimate(List<Evidence.Statistic.AttributeEstimate> attributeEstimate) {
                    this.attributeEstimate = attributeEstimate == null
                            ? new ArrayList<>()
                            : new ArrayList<>(attributeEstimate);
                    return this;
                }

                /**
                 * Adds a {@code attributeEstimate} value.
                 *
                 * @param attributeEstimate the value to add
                 * @return this builder
                 */
                public Builder addAttributeEstimate(Evidence.Statistic.AttributeEstimate attributeEstimate) {
                    this.attributeEstimate.add(Objects.requireNonNull(attributeEstimate, "attributeEstimate"));
                    return this;
                }

                /**
                 * Builds the {@code AttributeEstimate}.
                 *
                 * @return the {@code AttributeEstimate}
                 */
                public AttributeEstimate build() {
                    return new AttributeEstimate(
                            id, extension, modifierExtension, description, note, type, quantity, level, range,
                            attributeEstimate);
                }
            }
        }

        /**
         * A component of the method to generate the statistic.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code Model specification. Required.
         * @param value Numerical value to complete model specification.
         * @param variable A variable adjusted for in the adjusted analysis.
         * @param attributeEstimate An attribute of the statistic used as a model characteristic.
         */
        public record ModelCharacteristic(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept code,
                Quantity value,
                List<Variable> variable,
                List<Evidence.Statistic.AttributeEstimate> attributeEstimate) implements BackboneElement {

            /**
             * Creates a {@code ModelCharacteristic}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public ModelCharacteristic {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                variable = variable == null ? List.of() : List.copyOf(variable);
                attributeEstimate = attributeEstimate == null ? List.of() : List.copyOf(attributeEstimate);
                Objects.requireNonNull(code, "Evidence.statistic.modelCharacteristic.code is required");
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
             * Returns a builder initialized with the values of this {@code ModelCharacteristic}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * A variable adjusted for in the adjusted analysis.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param variableDefinition Description of the variable. Reference to Group, EvidenceVariable. Required.
             * @param handling continuous | dichotomous | ordinal | polychotomous.
             * @param valueCategory Description for grouping of ordinal or polychotomous variables.
             * @param valueQuantity Discrete value for grouping of ordinal or polychotomous variables.
             * @param valueRange Range of values for grouping of ordinal or polychotomous variables.
             */
            public record Variable(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    Reference variableDefinition,
                    FhirEnum<EvidenceVariableHandling> handling,
                    List<CodeableConcept> valueCategory,
                    List<Quantity> valueQuantity,
                    List<Range> valueRange) implements BackboneElement {

                /**
                 * Creates a {@code Variable}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public Variable {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    valueCategory = valueCategory == null ? List.of() : List.copyOf(valueCategory);
                    valueQuantity = valueQuantity == null ? List.of() : List.copyOf(valueQuantity);
                    valueRange = valueRange == null ? List.of() : List.copyOf(valueRange);
                    Objects.requireNonNull(
                            variableDefinition, "Evidence.statistic.modelCharacteristic.variable.variableDefinition is required");
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
                 * Returns a builder initialized with the values of this {@code Variable}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Variable}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private Reference variableDefinition;
                    private FhirEnum<EvidenceVariableHandling> handling;
                    private List<CodeableConcept> valueCategory = new ArrayList<>();
                    private List<Quantity> valueQuantity = new ArrayList<>();
                    private List<Range> valueRange = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(Variable original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.variableDefinition = original.variableDefinition();
                        this.handling = original.handling();
                        this.valueCategory = new ArrayList<>(original.valueCategory());
                        this.valueQuantity = new ArrayList<>(original.valueQuantity());
                        this.valueRange = new ArrayList<>(original.valueRange());
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
                     * Sets {@code variableDefinition}.
                     *
                     * @param variableDefinition the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder variableDefinition(Reference variableDefinition) {
                        this.variableDefinition = variableDefinition;
                        return this;
                    }

                    /**
                     * Sets {@code handling}.
                     *
                     * @param handling the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder handling(FhirEnum<EvidenceVariableHandling> handling) {
                        this.handling = handling;
                        return this;
                    }

                    /**
                     * Sets {@code handling}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param handling the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder handling(EvidenceVariableHandling handling) {
                        return handling(handling == null ? null : FhirEnum.of(handling));
                    }

                    /**
                     * Replaces all {@code valueCategory} values.
                     *
                     * @param valueCategory the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder valueCategory(List<CodeableConcept> valueCategory) {
                        this.valueCategory = valueCategory == null
                                ? new ArrayList<>()
                                : new ArrayList<>(valueCategory);
                        return this;
                    }

                    /**
                     * Adds a {@code valueCategory} value.
                     *
                     * @param valueCategory the value to add
                     * @return this builder
                     */
                    public Builder addValueCategory(CodeableConcept valueCategory) {
                        this.valueCategory.add(Objects.requireNonNull(valueCategory, "valueCategory"));
                        return this;
                    }

                    /**
                     * Replaces all {@code valueQuantity} values.
                     *
                     * @param valueQuantity the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder valueQuantity(List<Quantity> valueQuantity) {
                        this.valueQuantity = valueQuantity == null
                                ? new ArrayList<>()
                                : new ArrayList<>(valueQuantity);
                        return this;
                    }

                    /**
                     * Adds a {@code valueQuantity} value.
                     *
                     * @param valueQuantity the value to add
                     * @return this builder
                     */
                    public Builder addValueQuantity(Quantity valueQuantity) {
                        this.valueQuantity.add(Objects.requireNonNull(valueQuantity, "valueQuantity"));
                        return this;
                    }

                    /**
                     * Replaces all {@code valueRange} values.
                     *
                     * @param valueRange the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder valueRange(List<Range> valueRange) {
                        this.valueRange = valueRange == null ? new ArrayList<>() : new ArrayList<>(valueRange);
                        return this;
                    }

                    /**
                     * Adds a {@code valueRange} value.
                     *
                     * @param valueRange the value to add
                     * @return this builder
                     */
                    public Builder addValueRange(Range valueRange) {
                        this.valueRange.add(Objects.requireNonNull(valueRange, "valueRange"));
                        return this;
                    }

                    /**
                     * Builds the {@code Variable}.
                     *
                     * @return the {@code Variable}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Variable build() {
                        return new Variable(
                                id, extension, modifierExtension, variableDefinition, handling, valueCategory,
                                valueQuantity, valueRange);
                    }
                }
            }

            /** Builder for {@link ModelCharacteristic}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept code;
                private Quantity value;
                private List<Variable> variable = new ArrayList<>();
                private List<Evidence.Statistic.AttributeEstimate> attributeEstimate = new ArrayList<>();

                private Builder() {
                }

                private Builder(ModelCharacteristic original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.code = original.code();
                    this.value = original.value();
                    this.variable = new ArrayList<>(original.variable());
                    this.attributeEstimate = new ArrayList<>(original.attributeEstimate());
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
                 * Sets {@code value}.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Quantity value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Replaces all {@code variable} values.
                 *
                 * @param variable the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder variable(List<Variable> variable) {
                    this.variable = variable == null ? new ArrayList<>() : new ArrayList<>(variable);
                    return this;
                }

                /**
                 * Adds a {@code variable} value.
                 *
                 * @param variable the value to add
                 * @return this builder
                 */
                public Builder addVariable(Variable variable) {
                    this.variable.add(Objects.requireNonNull(variable, "variable"));
                    return this;
                }

                /**
                 * Replaces all {@code attributeEstimate} values.
                 *
                 * @param attributeEstimate the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder attributeEstimate(List<Evidence.Statistic.AttributeEstimate> attributeEstimate) {
                    this.attributeEstimate = attributeEstimate == null
                            ? new ArrayList<>()
                            : new ArrayList<>(attributeEstimate);
                    return this;
                }

                /**
                 * Adds a {@code attributeEstimate} value.
                 *
                 * @param attributeEstimate the value to add
                 * @return this builder
                 */
                public Builder addAttributeEstimate(Evidence.Statistic.AttributeEstimate attributeEstimate) {
                    this.attributeEstimate.add(Objects.requireNonNull(attributeEstimate, "attributeEstimate"));
                    return this;
                }

                /**
                 * Builds the {@code ModelCharacteristic}.
                 *
                 * @return the {@code ModelCharacteristic}
                 * @throws NullPointerException if a required element is absent
                 */
                public ModelCharacteristic build() {
                    return new ModelCharacteristic(
                            id, extension, modifierExtension, code, value, variable, attributeEstimate);
                }
            }
        }

        /** Builder for {@link Statistic}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirMarkdown description;
            private List<Annotation> note = new ArrayList<>();
            private CodeableConcept statisticType;
            private CodeableConcept category;
            private Quantity quantity;
            private FhirUnsignedInt numberOfEvents;
            private FhirUnsignedInt numberAffected;
            private SampleSize sampleSize;
            private List<AttributeEstimate> attributeEstimate = new ArrayList<>();
            private List<ModelCharacteristic> modelCharacteristic = new ArrayList<>();

            private Builder() {
            }

            private Builder(Statistic original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.description = original.description();
                this.note = new ArrayList<>(original.note());
                this.statisticType = original.statisticType();
                this.category = original.category();
                this.quantity = original.quantity();
                this.numberOfEvents = original.numberOfEvents();
                this.numberAffected = original.numberAffected();
                this.sampleSize = original.sampleSize();
                this.attributeEstimate = new ArrayList<>(original.attributeEstimate());
                this.modelCharacteristic = new ArrayList<>(original.modelCharacteristic());
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
             * Sets {@code statisticType}.
             *
             * @param statisticType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder statisticType(CodeableConcept statisticType) {
                this.statisticType = statisticType;
                return this;
            }

            /**
             * Sets {@code category}.
             *
             * @param category the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder category(CodeableConcept category) {
                this.category = category;
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
             * Sets {@code numberOfEvents}.
             *
             * @param numberOfEvents the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder numberOfEvents(FhirUnsignedInt numberOfEvents) {
                this.numberOfEvents = numberOfEvents;
                return this;
            }

            /**
             * Sets {@code numberOfEvents}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
             *
             * @param numberOfEvents the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder numberOfEvents(Integer numberOfEvents) {
                return numberOfEvents(numberOfEvents == null ? null : FhirUnsignedInt.of(numberOfEvents));
            }

            /**
             * Sets {@code numberAffected}.
             *
             * @param numberAffected the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder numberAffected(FhirUnsignedInt numberAffected) {
                this.numberAffected = numberAffected;
                return this;
            }

            /**
             * Sets {@code numberAffected}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
             *
             * @param numberAffected the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder numberAffected(Integer numberAffected) {
                return numberAffected(numberAffected == null ? null : FhirUnsignedInt.of(numberAffected));
            }

            /**
             * Sets {@code sampleSize}.
             *
             * @param sampleSize the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sampleSize(SampleSize sampleSize) {
                this.sampleSize = sampleSize;
                return this;
            }

            /**
             * Replaces all {@code attributeEstimate} values.
             *
             * @param attributeEstimate the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder attributeEstimate(List<AttributeEstimate> attributeEstimate) {
                this.attributeEstimate = attributeEstimate == null
                        ? new ArrayList<>()
                        : new ArrayList<>(attributeEstimate);
                return this;
            }

            /**
             * Adds a {@code attributeEstimate} value.
             *
             * @param attributeEstimate the value to add
             * @return this builder
             */
            public Builder addAttributeEstimate(AttributeEstimate attributeEstimate) {
                this.attributeEstimate.add(Objects.requireNonNull(attributeEstimate, "attributeEstimate"));
                return this;
            }

            /**
             * Replaces all {@code modelCharacteristic} values.
             *
             * @param modelCharacteristic the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder modelCharacteristic(List<ModelCharacteristic> modelCharacteristic) {
                this.modelCharacteristic = modelCharacteristic == null
                        ? new ArrayList<>()
                        : new ArrayList<>(modelCharacteristic);
                return this;
            }

            /**
             * Adds a {@code modelCharacteristic} value.
             *
             * @param modelCharacteristic the value to add
             * @return this builder
             */
            public Builder addModelCharacteristic(ModelCharacteristic modelCharacteristic) {
                this.modelCharacteristic.add(Objects.requireNonNull(modelCharacteristic, "modelCharacteristic"));
                return this;
            }

            /**
             * Builds the {@code Statistic}.
             *
             * @return the {@code Statistic}
             */
            public Statistic build() {
                return new Statistic(
                        id, extension, modifierExtension, description, note, statisticType, category, quantity,
                        numberOfEvents, numberAffected, sampleSize, attributeEstimate, modelCharacteristic);
            }
        }
    }

    /**
     * Assessment of certainty, confidence in the estimates, or quality of the evidence.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param description Textual description of certainty.
     * @param note Footnotes and/or explanatory notes.
     * @param type Aspect of certainty being rated.
     * @param rating Assessment or judgement of the aspect.
     * @param rater Individual or group who did the rating.
     * @param subcomponent A domain or subdomain of certainty.
     */
    public record Certainty(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirMarkdown description,
            List<Annotation> note,
            CodeableConcept type,
            CodeableConcept rating,
            FhirString rater,
            List<Evidence.Certainty> subcomponent) implements BackboneElement {

        /**
         * Creates a {@code Certainty}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Certainty {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            note = note == null ? List.of() : List.copyOf(note);
            subcomponent = subcomponent == null ? List.of() : List.copyOf(subcomponent);
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
         * Returns a builder initialized with the values of this {@code Certainty}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Certainty}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirMarkdown description;
            private List<Annotation> note = new ArrayList<>();
            private CodeableConcept type;
            private CodeableConcept rating;
            private FhirString rater;
            private List<Evidence.Certainty> subcomponent = new ArrayList<>();

            private Builder() {
            }

            private Builder(Certainty original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.description = original.description();
                this.note = new ArrayList<>(original.note());
                this.type = original.type();
                this.rating = original.rating();
                this.rater = original.rater();
                this.subcomponent = new ArrayList<>(original.subcomponent());
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
             * Sets {@code rating}.
             *
             * @param rating the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rating(CodeableConcept rating) {
                this.rating = rating;
                return this;
            }

            /**
             * Sets {@code rater}.
             *
             * @param rater the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rater(FhirString rater) {
                this.rater = rater;
                return this;
            }

            /**
             * Sets {@code rater}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param rater the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rater(String rater) {
                return rater(rater == null ? null : FhirString.of(rater));
            }

            /**
             * Replaces all {@code subcomponent} values.
             *
             * @param subcomponent the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder subcomponent(List<Evidence.Certainty> subcomponent) {
                this.subcomponent = subcomponent == null ? new ArrayList<>() : new ArrayList<>(subcomponent);
                return this;
            }

            /**
             * Adds a {@code subcomponent} value.
             *
             * @param subcomponent the value to add
             * @return this builder
             */
            public Builder addSubcomponent(Evidence.Certainty subcomponent) {
                this.subcomponent.add(Objects.requireNonNull(subcomponent, "subcomponent"));
                return this;
            }

            /**
             * Builds the {@code Certainty}.
             *
             * @return the {@code Certainty}
             */
            public Certainty build() {
                return new Certainty(
                        id, extension, modifierExtension, description, note, type, rating, rater, subcomponent);
            }
        }
    }

    /** Builder for {@link Evidence}. Builders are mutable and not thread-safe. */
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
        private DataType versionAlgorithm;
        private FhirString name;
        private FhirString title;
        private DataType citeAs;
        private FhirEnum<PublicationStatus> status;
        private FhirBoolean experimental;
        private FhirDateTime date;
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private List<ContactDetail> author = new ArrayList<>();
        private List<ContactDetail> editor = new ArrayList<>();
        private List<ContactDetail> reviewer = new ArrayList<>();
        private List<ContactDetail> endorser = new ArrayList<>();
        private List<UsageContext> useContext = new ArrayList<>();
        private FhirMarkdown purpose;
        private FhirMarkdown copyright;
        private FhirString copyrightLabel;
        private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
        private FhirMarkdown description;
        private FhirMarkdown assertion;
        private List<Annotation> note = new ArrayList<>();
        private List<VariableDefinition> variableDefinition = new ArrayList<>();
        private CodeableConcept synthesisType;
        private List<CodeableConcept> studyDesign = new ArrayList<>();
        private List<Statistic> statistic = new ArrayList<>();
        private List<Certainty> certainty = new ArrayList<>();

        private Builder() {
        }

        private Builder(Evidence original) {
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
            this.versionAlgorithm = original.versionAlgorithm();
            this.name = original.name();
            this.title = original.title();
            this.citeAs = original.citeAs();
            this.status = original.status();
            this.experimental = original.experimental();
            this.date = original.date();
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.author = new ArrayList<>(original.author());
            this.editor = new ArrayList<>(original.editor());
            this.reviewer = new ArrayList<>(original.reviewer());
            this.endorser = new ArrayList<>(original.endorser());
            this.useContext = new ArrayList<>(original.useContext());
            this.purpose = original.purpose();
            this.copyright = original.copyright();
            this.copyrightLabel = original.copyrightLabel();
            this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
            this.description = original.description();
            this.assertion = original.assertion();
            this.note = new ArrayList<>(original.note());
            this.variableDefinition = new ArrayList<>(original.variableDefinition());
            this.synthesisType = original.synthesisType();
            this.studyDesign = new ArrayList<>(original.studyDesign());
            this.statistic = new ArrayList<>(original.statistic());
            this.certainty = new ArrayList<>(original.certainty());
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
         * Sets {@code versionAlgorithm} to a string.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(FhirString versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a Coding.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(Coding versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a string without id or extensions.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(String versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm == null ? null : FhirString.of(versionAlgorithm);
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
         * Sets {@code citeAs} to a Reference.
         *
         * @param citeAs the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder citeAs(Reference citeAs) {
            this.citeAs = citeAs;
            return this;
        }

        /**
         * Sets {@code citeAs} to a markdown.
         *
         * @param citeAs the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder citeAs(FhirMarkdown citeAs) {
            this.citeAs = citeAs;
            return this;
        }

        /**
         * Sets {@code citeAs} to a markdown without id or extensions.
         *
         * @param citeAs the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder citeAs(String citeAs) {
            this.citeAs = citeAs == null ? null : FhirMarkdown.of(citeAs);
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
         * Sets {@code experimental}.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(FhirBoolean experimental) {
            this.experimental = experimental;
            return this;
        }

        /**
         * Sets {@code experimental}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(Boolean experimental) {
            return experimental(experimental == null ? null : FhirBoolean.of(experimental));
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
         * Sets {@code approvalDate}.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(FhirDate approvalDate) {
            this.approvalDate = approvalDate;
            return this;
        }

        /**
         * Sets {@code approvalDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(Temporal approvalDate) {
            return approvalDate(approvalDate == null ? null : FhirDate.of(approvalDate));
        }

        /**
         * Sets {@code lastReviewDate}.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(FhirDate lastReviewDate) {
            this.lastReviewDate = lastReviewDate;
            return this;
        }

        /**
         * Sets {@code lastReviewDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(Temporal lastReviewDate) {
            return lastReviewDate(lastReviewDate == null ? null : FhirDate.of(lastReviewDate));
        }

        /**
         * Sets {@code publisher}.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(FhirString publisher) {
            this.publisher = publisher;
            return this;
        }

        /**
         * Sets {@code publisher}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(String publisher) {
            return publisher(publisher == null ? null : FhirString.of(publisher));
        }

        /**
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ContactDetail> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ContactDetail contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
            return this;
        }

        /**
         * Replaces all {@code author} values.
         *
         * @param author the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder author(List<ContactDetail> author) {
            this.author = author == null ? new ArrayList<>() : new ArrayList<>(author);
            return this;
        }

        /**
         * Adds a {@code author} value.
         *
         * @param author the value to add
         * @return this builder
         */
        public Builder addAuthor(ContactDetail author) {
            this.author.add(Objects.requireNonNull(author, "author"));
            return this;
        }

        /**
         * Replaces all {@code editor} values.
         *
         * @param editor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder editor(List<ContactDetail> editor) {
            this.editor = editor == null ? new ArrayList<>() : new ArrayList<>(editor);
            return this;
        }

        /**
         * Adds a {@code editor} value.
         *
         * @param editor the value to add
         * @return this builder
         */
        public Builder addEditor(ContactDetail editor) {
            this.editor.add(Objects.requireNonNull(editor, "editor"));
            return this;
        }

        /**
         * Replaces all {@code reviewer} values.
         *
         * @param reviewer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reviewer(List<ContactDetail> reviewer) {
            this.reviewer = reviewer == null ? new ArrayList<>() : new ArrayList<>(reviewer);
            return this;
        }

        /**
         * Adds a {@code reviewer} value.
         *
         * @param reviewer the value to add
         * @return this builder
         */
        public Builder addReviewer(ContactDetail reviewer) {
            this.reviewer.add(Objects.requireNonNull(reviewer, "reviewer"));
            return this;
        }

        /**
         * Replaces all {@code endorser} values.
         *
         * @param endorser the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder endorser(List<ContactDetail> endorser) {
            this.endorser = endorser == null ? new ArrayList<>() : new ArrayList<>(endorser);
            return this;
        }

        /**
         * Adds a {@code endorser} value.
         *
         * @param endorser the value to add
         * @return this builder
         */
        public Builder addEndorser(ContactDetail endorser) {
            this.endorser.add(Objects.requireNonNull(endorser, "endorser"));
            return this;
        }

        /**
         * Replaces all {@code useContext} values.
         *
         * @param useContext the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder useContext(List<UsageContext> useContext) {
            this.useContext = useContext == null ? new ArrayList<>() : new ArrayList<>(useContext);
            return this;
        }

        /**
         * Adds a {@code useContext} value.
         *
         * @param useContext the value to add
         * @return this builder
         */
        public Builder addUseContext(UsageContext useContext) {
            this.useContext.add(Objects.requireNonNull(useContext, "useContext"));
            return this;
        }

        /**
         * Sets {@code purpose}.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(FhirMarkdown purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * Sets {@code purpose}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(String purpose) {
            return purpose(purpose == null ? null : FhirMarkdown.of(purpose));
        }

        /**
         * Sets {@code copyright}.
         *
         * @param copyright the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyright(FhirMarkdown copyright) {
            this.copyright = copyright;
            return this;
        }

        /**
         * Sets {@code copyright}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param copyright the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyright(String copyright) {
            return copyright(copyright == null ? null : FhirMarkdown.of(copyright));
        }

        /**
         * Sets {@code copyrightLabel}.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(FhirString copyrightLabel) {
            this.copyrightLabel = copyrightLabel;
            return this;
        }

        /**
         * Sets {@code copyrightLabel}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(String copyrightLabel) {
            return copyrightLabel(copyrightLabel == null ? null : FhirString.of(copyrightLabel));
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
         * Sets {@code assertion}.
         *
         * @param assertion the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder assertion(FhirMarkdown assertion) {
            this.assertion = assertion;
            return this;
        }

        /**
         * Sets {@code assertion}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param assertion the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder assertion(String assertion) {
            return assertion(assertion == null ? null : FhirMarkdown.of(assertion));
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
         * Replaces all {@code variableDefinition} values.
         *
         * @param variableDefinition the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder variableDefinition(List<VariableDefinition> variableDefinition) {
            this.variableDefinition = variableDefinition == null
                    ? new ArrayList<>()
                    : new ArrayList<>(variableDefinition);
            return this;
        }

        /**
         * Adds a {@code variableDefinition} value.
         *
         * @param variableDefinition the value to add
         * @return this builder
         */
        public Builder addVariableDefinition(VariableDefinition variableDefinition) {
            this.variableDefinition.add(Objects.requireNonNull(variableDefinition, "variableDefinition"));
            return this;
        }

        /**
         * Sets {@code synthesisType}.
         *
         * @param synthesisType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder synthesisType(CodeableConcept synthesisType) {
            this.synthesisType = synthesisType;
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
         * Replaces all {@code statistic} values.
         *
         * @param statistic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder statistic(List<Statistic> statistic) {
            this.statistic = statistic == null ? new ArrayList<>() : new ArrayList<>(statistic);
            return this;
        }

        /**
         * Adds a {@code statistic} value.
         *
         * @param statistic the value to add
         * @return this builder
         */
        public Builder addStatistic(Statistic statistic) {
            this.statistic.add(Objects.requireNonNull(statistic, "statistic"));
            return this;
        }

        /**
         * Replaces all {@code certainty} values.
         *
         * @param certainty the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder certainty(List<Certainty> certainty) {
            this.certainty = certainty == null ? new ArrayList<>() : new ArrayList<>(certainty);
            return this;
        }

        /**
         * Adds a {@code certainty} value.
         *
         * @param certainty the value to add
         * @return this builder
         */
        public Builder addCertainty(Certainty certainty) {
            this.certainty.add(Objects.requireNonNull(certainty, "certainty"));
            return this;
        }

        /**
         * Builds the {@code Evidence}.
         *
         * @return the {@code Evidence}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public Evidence build() {
            return new Evidence(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, citeAs, status, experimental, date, approvalDate,
                    lastReviewDate, publisher, contact, author, editor, reviewer, endorser, useContext, purpose,
                    copyright, copyrightLabel, relatedArtifact, description, assertion, note, variableDefinition,
                    synthesisType, studyDesign, statistic, certainty);
        }
    }
}
