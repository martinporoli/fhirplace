package se.poroli.fhirplace.r5.specialized.qualityreportingtesting;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.FHIRTypes;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * The Measure resource provides the definition of a quality measure.
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
 * @param url Canonical identifier for this measure, represented as a URI (globally unique).
 * @param identifier Additional identifier for the measure.
 * @param version Business version of the measure.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this measure (computer friendly).
 * @param title Name for this measure (human friendly).
 * @param subtitle Subordinate title of the measure.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param subject E.g. Patient, Practitioner, RelatedPerson, Organization, Location, Device. One of CodeableConcept,
 *   Reference.
 * @param basis Population basis.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the measure.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for measure (if applicable).
 * @param purpose Why this measure is defined.
 * @param usage Describes the clinical usage of the measure.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param approvalDate When the measure was approved by publisher.
 * @param lastReviewDate When the measure was last reviewed by the publisher.
 * @param effectivePeriod When the measure is expected to be used.
 * @param topic The category of the measure, such as Education, Treatment, Assessment, etc.
 * @param author Who authored the content.
 * @param editor Who edited the content.
 * @param reviewer Who reviewed the content.
 * @param endorser Who endorsed the content.
 * @param relatedArtifact Additional documentation, citations, etc.
 * @param library Logic used by the measure. Canonical reference to Library.
 * @param disclaimer Disclaimer for use of the measure or its referenced content.
 * @param scoring proportion | ratio | continuous-variable | cohort.
 * @param scoringUnit What units?.
 * @param compositeScoring opportunity | all-or-nothing | linear | weighted.
 * @param type process | outcome | structure | patient-reported-outcome | composite.
 * @param riskAdjustment How risk adjustment is applied for this measure.
 * @param rateAggregation How is rate aggregation performed for this measure.
 * @param rationale Detailed description of why the measure exists.
 * @param clinicalRecommendationStatement Summary of clinical guidelines.
 * @param improvementNotation increase | decrease.
 * @param term Defined terms used in the measure documentation.
 * @param guidance Additional guidance for implementers (deprecated).
 * @param group Population criteria group.
 * @param supplementalData What other data should be reported with the measure.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Measure">FHIR R5 Measure</a>
 */
public record Measure(
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
        FhirString subtitle,
        FhirEnum<PublicationStatus> status,
        FhirBoolean experimental,
        DataType subject,
        FhirEnum<FHIRTypes> basis,
        FhirDateTime date,
        FhirString publisher,
        List<ContactDetail> contact,
        FhirMarkdown description,
        List<UsageContext> useContext,
        List<CodeableConcept> jurisdiction,
        FhirMarkdown purpose,
        FhirMarkdown usage,
        FhirMarkdown copyright,
        FhirString copyrightLabel,
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        Period effectivePeriod,
        List<CodeableConcept> topic,
        List<ContactDetail> author,
        List<ContactDetail> editor,
        List<ContactDetail> reviewer,
        List<ContactDetail> endorser,
        List<RelatedArtifact> relatedArtifact,
        List<FhirCanonical> library,
        FhirMarkdown disclaimer,
        CodeableConcept scoring,
        CodeableConcept scoringUnit,
        CodeableConcept compositeScoring,
        List<CodeableConcept> type,
        FhirMarkdown riskAdjustment,
        FhirMarkdown rateAggregation,
        FhirMarkdown rationale,
        FhirMarkdown clinicalRecommendationStatement,
        CodeableConcept improvementNotation,
        List<Term> term,
        FhirMarkdown guidance,
        List<Group> group,
        List<SupplementalData> supplementalData) implements DomainResource {

    /**
     * Creates a {@code Measure}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Measure {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        topic = topic == null ? List.of() : List.copyOf(topic);
        author = author == null ? List.of() : List.copyOf(author);
        editor = editor == null ? List.of() : List.copyOf(editor);
        reviewer = reviewer == null ? List.of() : List.copyOf(reviewer);
        endorser = endorser == null ? List.of() : List.copyOf(endorser);
        relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
        library = library == null ? List.of() : List.copyOf(library);
        type = type == null ? List.of() : List.copyOf(type);
        term = term == null ? List.of() : List.copyOf(term);
        group = group == null ? List.of() : List.copyOf(group);
        supplementalData = supplementalData == null ? List.of() : List.copyOf(supplementalData);
        Objects.requireNonNull(status, "Measure.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "Measure.versionAlgorithm[x] must be one of string, Coding, but was "
                            + versionAlgorithm.getClass().getSimpleName());
        }
        if (subject != null && !(subject instanceof CodeableConcept || subject instanceof Reference)) {
            throw new IllegalArgumentException(
                    "Measure.subject[x] must be one of CodeableConcept, Reference, but was "
                            + subject.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Measure}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Provides a description of an individual term used within the measure.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code What term?.
     * @param definition Meaning of the term.
     */
    public record Term(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            FhirMarkdown definition) implements BackboneElement {

        /**
         * Creates a {@code Term}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Term {
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
         * Returns a builder initialized with the values of this {@code Term}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Term}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private FhirMarkdown definition;

            private Builder() {
            }

            private Builder(Term original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.definition = original.definition();
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
             * Sets {@code definition}.
             *
             * @param definition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definition(FhirMarkdown definition) {
                this.definition = definition;
                return this;
            }

            /**
             * Sets {@code definition}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param definition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definition(String definition) {
                return definition(definition == null ? null : FhirMarkdown.of(definition));
            }

            /**
             * Builds the {@code Term}.
             *
             * @return the {@code Term}
             */
            public Term build() {
                return new Term(
                        id, extension, modifierExtension, code, definition);
            }
        }
    }

    /**
     * A group of population criteria for the measure.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param linkId Unique id for group in measure.
     * @param code Meaning of the group.
     * @param description Summary description.
     * @param type process | outcome | structure | patient-reported-outcome | composite.
     * @param subject E.g. Patient, Practitioner, RelatedPerson, Organization, Location, Device. One of
     *   CodeableConcept, Reference.
     * @param basis Population basis.
     * @param scoring proportion | ratio | continuous-variable | cohort.
     * @param scoringUnit What units?.
     * @param rateAggregation How is rate aggregation performed for this measure.
     * @param improvementNotation increase | decrease.
     * @param library Logic used by the measure group. Canonical reference to Library.
     * @param population Population criteria.
     * @param stratifier Stratifier criteria for the measure.
     */
    public record Group(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString linkId,
            CodeableConcept code,
            FhirMarkdown description,
            List<CodeableConcept> type,
            DataType subject,
            FhirEnum<FHIRTypes> basis,
            CodeableConcept scoring,
            CodeableConcept scoringUnit,
            FhirMarkdown rateAggregation,
            CodeableConcept improvementNotation,
            List<FhirCanonical> library,
            List<Population> population,
            List<Stratifier> stratifier) implements BackboneElement {

        /**
         * Creates a {@code Group}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Group {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            type = type == null ? List.of() : List.copyOf(type);
            library = library == null ? List.of() : List.copyOf(library);
            population = population == null ? List.of() : List.copyOf(population);
            stratifier = stratifier == null ? List.of() : List.copyOf(stratifier);
            if (subject != null && !(subject instanceof CodeableConcept || subject instanceof Reference)) {
                throw new IllegalArgumentException(
                        "Measure.group.subject[x] must be one of CodeableConcept, Reference, but was "
                                + subject.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Group}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A population criteria for the measure.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param linkId Unique id for population in measure.
         * @param code initial-population | numerator | numerator-exclusion | denominator | denominator-exclusion |
         *   denominator-exception | measure-population | measure-population-exclusion | measure-observation.
         * @param description The human readable description of this population criteria.
         * @param criteria The criteria that defines this population.
         * @param groupDefinition A group resource that defines this population. Reference to Group.
         * @param inputPopulationId Which population.
         * @param aggregateMethod Aggregation method for a measure score (e.g. sum, average, median, minimum, maximum,
         *   count).
         */
        public record Population(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString linkId,
                CodeableConcept code,
                FhirMarkdown description,
                Expression criteria,
                Reference groupDefinition,
                FhirString inputPopulationId,
                CodeableConcept aggregateMethod) implements BackboneElement {

            /**
             * Creates a {@code Population}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Population {
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
             * Returns a builder initialized with the values of this {@code Population}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Population}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString linkId;
                private CodeableConcept code;
                private FhirMarkdown description;
                private Expression criteria;
                private Reference groupDefinition;
                private FhirString inputPopulationId;
                private CodeableConcept aggregateMethod;

                private Builder() {
                }

                private Builder(Population original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.linkId = original.linkId();
                    this.code = original.code();
                    this.description = original.description();
                    this.criteria = original.criteria();
                    this.groupDefinition = original.groupDefinition();
                    this.inputPopulationId = original.inputPopulationId();
                    this.aggregateMethod = original.aggregateMethod();
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
                public Builder linkId(FhirString linkId) {
                    this.linkId = linkId;
                    return this;
                }

                /**
                 * Sets {@code linkId}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param linkId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder linkId(String linkId) {
                    return linkId(linkId == null ? null : FhirString.of(linkId));
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
                 * Sets {@code criteria}.
                 *
                 * @param criteria the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder criteria(Expression criteria) {
                    this.criteria = criteria;
                    return this;
                }

                /**
                 * Sets {@code groupDefinition}.
                 *
                 * @param groupDefinition the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder groupDefinition(Reference groupDefinition) {
                    this.groupDefinition = groupDefinition;
                    return this;
                }

                /**
                 * Sets {@code inputPopulationId}.
                 *
                 * @param inputPopulationId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder inputPopulationId(FhirString inputPopulationId) {
                    this.inputPopulationId = inputPopulationId;
                    return this;
                }

                /**
                 * Sets {@code inputPopulationId}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param inputPopulationId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder inputPopulationId(String inputPopulationId) {
                    return inputPopulationId(inputPopulationId == null ? null : FhirString.of(inputPopulationId));
                }

                /**
                 * Sets {@code aggregateMethod}.
                 *
                 * @param aggregateMethod the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder aggregateMethod(CodeableConcept aggregateMethod) {
                    this.aggregateMethod = aggregateMethod;
                    return this;
                }

                /**
                 * Builds the {@code Population}.
                 *
                 * @return the {@code Population}
                 */
                public Population build() {
                    return new Population(
                            id, extension, modifierExtension, linkId, code, description, criteria, groupDefinition,
                            inputPopulationId, aggregateMethod);
                }
            }
        }

        /**
         * The stratifier criteria for the measure report, specified as either the name of a valid CQL expression
         * defined within a referenced library or a valid FHIR Resource Path.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param linkId Unique id for stratifier in measure.
         * @param code Meaning of the stratifier.
         * @param description The human readable description of this stratifier.
         * @param criteria How the measure should be stratified.
         * @param groupDefinition A group resource that defines this population. Reference to Group.
         * @param component Stratifier criteria component for the measure.
         */
        public record Stratifier(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString linkId,
                CodeableConcept code,
                FhirMarkdown description,
                Expression criteria,
                Reference groupDefinition,
                List<Component> component) implements BackboneElement {

            /**
             * Creates a {@code Stratifier}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Stratifier {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                component = component == null ? List.of() : List.copyOf(component);
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
             * Returns a builder initialized with the values of this {@code Stratifier}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * A component of the stratifier criteria for the measure report, specified as either the name of a valid
             * CQL expression defined within a referenced library or a valid FHIR Resource Path.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param linkId Unique id for stratifier component in measure.
             * @param code Meaning of the stratifier component.
             * @param description The human readable description of this stratifier component.
             * @param criteria Component of how the measure should be stratified.
             * @param groupDefinition A group resource that defines this population. Reference to Group.
             */
            public record Component(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirString linkId,
                    CodeableConcept code,
                    FhirMarkdown description,
                    Expression criteria,
                    Reference groupDefinition) implements BackboneElement {

                /**
                 * Creates a {@code Component}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 */
                public Component {
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
                 * Returns a builder initialized with the values of this {@code Component}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Component}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirString linkId;
                    private CodeableConcept code;
                    private FhirMarkdown description;
                    private Expression criteria;
                    private Reference groupDefinition;

                    private Builder() {
                    }

                    private Builder(Component original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.linkId = original.linkId();
                        this.code = original.code();
                        this.description = original.description();
                        this.criteria = original.criteria();
                        this.groupDefinition = original.groupDefinition();
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
                    public Builder linkId(FhirString linkId) {
                        this.linkId = linkId;
                        return this;
                    }

                    /**
                     * Sets {@code linkId}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param linkId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder linkId(String linkId) {
                        return linkId(linkId == null ? null : FhirString.of(linkId));
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
                     * Sets {@code criteria}.
                     *
                     * @param criteria the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder criteria(Expression criteria) {
                        this.criteria = criteria;
                        return this;
                    }

                    /**
                     * Sets {@code groupDefinition}.
                     *
                     * @param groupDefinition the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder groupDefinition(Reference groupDefinition) {
                        this.groupDefinition = groupDefinition;
                        return this;
                    }

                    /**
                     * Builds the {@code Component}.
                     *
                     * @return the {@code Component}
                     */
                    public Component build() {
                        return new Component(
                                id, extension, modifierExtension, linkId, code, description, criteria,
                                groupDefinition);
                    }
                }
            }

            /** Builder for {@link Stratifier}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString linkId;
                private CodeableConcept code;
                private FhirMarkdown description;
                private Expression criteria;
                private Reference groupDefinition;
                private List<Component> component = new ArrayList<>();

                private Builder() {
                }

                private Builder(Stratifier original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.linkId = original.linkId();
                    this.code = original.code();
                    this.description = original.description();
                    this.criteria = original.criteria();
                    this.groupDefinition = original.groupDefinition();
                    this.component = new ArrayList<>(original.component());
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
                public Builder linkId(FhirString linkId) {
                    this.linkId = linkId;
                    return this;
                }

                /**
                 * Sets {@code linkId}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param linkId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder linkId(String linkId) {
                    return linkId(linkId == null ? null : FhirString.of(linkId));
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
                 * Sets {@code criteria}.
                 *
                 * @param criteria the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder criteria(Expression criteria) {
                    this.criteria = criteria;
                    return this;
                }

                /**
                 * Sets {@code groupDefinition}.
                 *
                 * @param groupDefinition the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder groupDefinition(Reference groupDefinition) {
                    this.groupDefinition = groupDefinition;
                    return this;
                }

                /**
                 * Replaces all {@code component} values.
                 *
                 * @param component the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder component(List<Component> component) {
                    this.component = component == null ? new ArrayList<>() : new ArrayList<>(component);
                    return this;
                }

                /**
                 * Adds a {@code component} value.
                 *
                 * @param component the value to add
                 * @return this builder
                 */
                public Builder addComponent(Component component) {
                    this.component.add(Objects.requireNonNull(component, "component"));
                    return this;
                }

                /**
                 * Builds the {@code Stratifier}.
                 *
                 * @return the {@code Stratifier}
                 */
                public Stratifier build() {
                    return new Stratifier(
                            id, extension, modifierExtension, linkId, code, description, criteria, groupDefinition,
                            component);
                }
            }
        }

        /** Builder for {@link Group}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString linkId;
            private CodeableConcept code;
            private FhirMarkdown description;
            private List<CodeableConcept> type = new ArrayList<>();
            private DataType subject;
            private FhirEnum<FHIRTypes> basis;
            private CodeableConcept scoring;
            private CodeableConcept scoringUnit;
            private FhirMarkdown rateAggregation;
            private CodeableConcept improvementNotation;
            private List<FhirCanonical> library = new ArrayList<>();
            private List<Population> population = new ArrayList<>();
            private List<Stratifier> stratifier = new ArrayList<>();

            private Builder() {
            }

            private Builder(Group original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.linkId = original.linkId();
                this.code = original.code();
                this.description = original.description();
                this.type = new ArrayList<>(original.type());
                this.subject = original.subject();
                this.basis = original.basis();
                this.scoring = original.scoring();
                this.scoringUnit = original.scoringUnit();
                this.rateAggregation = original.rateAggregation();
                this.improvementNotation = original.improvementNotation();
                this.library = new ArrayList<>(original.library());
                this.population = new ArrayList<>(original.population());
                this.stratifier = new ArrayList<>(original.stratifier());
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
            public Builder linkId(FhirString linkId) {
                this.linkId = linkId;
                return this;
            }

            /**
             * Sets {@code linkId}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param linkId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder linkId(String linkId) {
                return linkId(linkId == null ? null : FhirString.of(linkId));
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
             * Sets {@code subject} to a CodeableConcept.
             *
             * @param subject the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subject(CodeableConcept subject) {
                this.subject = subject;
                return this;
            }

            /**
             * Sets {@code subject} to a Reference.
             *
             * @param subject the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subject(Reference subject) {
                this.subject = subject;
                return this;
            }

            /**
             * Sets {@code basis}.
             *
             * @param basis the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder basis(FhirEnum<FHIRTypes> basis) {
                this.basis = basis;
                return this;
            }

            /**
             * Sets {@code basis}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param basis the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder basis(FHIRTypes basis) {
                return basis(basis == null ? null : FhirEnum.of(basis));
            }

            /**
             * Sets {@code scoring}.
             *
             * @param scoring the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder scoring(CodeableConcept scoring) {
                this.scoring = scoring;
                return this;
            }

            /**
             * Sets {@code scoringUnit}.
             *
             * @param scoringUnit the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder scoringUnit(CodeableConcept scoringUnit) {
                this.scoringUnit = scoringUnit;
                return this;
            }

            /**
             * Sets {@code rateAggregation}.
             *
             * @param rateAggregation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rateAggregation(FhirMarkdown rateAggregation) {
                this.rateAggregation = rateAggregation;
                return this;
            }

            /**
             * Sets {@code rateAggregation}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param rateAggregation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rateAggregation(String rateAggregation) {
                return rateAggregation(rateAggregation == null ? null : FhirMarkdown.of(rateAggregation));
            }

            /**
             * Sets {@code improvementNotation}.
             *
             * @param improvementNotation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder improvementNotation(CodeableConcept improvementNotation) {
                this.improvementNotation = improvementNotation;
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
             * Replaces all {@code population} values.
             *
             * @param population the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder population(List<Population> population) {
                this.population = population == null ? new ArrayList<>() : new ArrayList<>(population);
                return this;
            }

            /**
             * Adds a {@code population} value.
             *
             * @param population the value to add
             * @return this builder
             */
            public Builder addPopulation(Population population) {
                this.population.add(Objects.requireNonNull(population, "population"));
                return this;
            }

            /**
             * Replaces all {@code stratifier} values.
             *
             * @param stratifier the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder stratifier(List<Stratifier> stratifier) {
                this.stratifier = stratifier == null ? new ArrayList<>() : new ArrayList<>(stratifier);
                return this;
            }

            /**
             * Adds a {@code stratifier} value.
             *
             * @param stratifier the value to add
             * @return this builder
             */
            public Builder addStratifier(Stratifier stratifier) {
                this.stratifier.add(Objects.requireNonNull(stratifier, "stratifier"));
                return this;
            }

            /**
             * Builds the {@code Group}.
             *
             * @return the {@code Group}
             */
            public Group build() {
                return new Group(
                        id, extension, modifierExtension, linkId, code, description, type, subject, basis, scoring,
                        scoringUnit, rateAggregation, improvementNotation, library, population, stratifier);
            }
        }
    }

    /**
     * The supplemental data criteria for the measure report, specified as either the name of a valid CQL expression
     * within a referenced library, or a valid FHIR Resource Path.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param linkId Unique id for supplementalData in measure.
     * @param code Meaning of the supplemental data.
     * @param usage supplemental-data | risk-adjustment-factor.
     * @param description The human readable description of this supplemental data.
     * @param criteria Expression describing additional data to be reported. Required.
     */
    public record SupplementalData(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString linkId,
            CodeableConcept code,
            List<CodeableConcept> usage,
            FhirMarkdown description,
            Expression criteria) implements BackboneElement {

        /**
         * Creates a {@code SupplementalData}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public SupplementalData {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            usage = usage == null ? List.of() : List.copyOf(usage);
            Objects.requireNonNull(criteria, "Measure.supplementalData.criteria is required");
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
         * Returns a builder initialized with the values of this {@code SupplementalData}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link SupplementalData}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString linkId;
            private CodeableConcept code;
            private List<CodeableConcept> usage = new ArrayList<>();
            private FhirMarkdown description;
            private Expression criteria;

            private Builder() {
            }

            private Builder(SupplementalData original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.linkId = original.linkId();
                this.code = original.code();
                this.usage = new ArrayList<>(original.usage());
                this.description = original.description();
                this.criteria = original.criteria();
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
            public Builder linkId(FhirString linkId) {
                this.linkId = linkId;
                return this;
            }

            /**
             * Sets {@code linkId}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param linkId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder linkId(String linkId) {
                return linkId(linkId == null ? null : FhirString.of(linkId));
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
             * Replaces all {@code usage} values.
             *
             * @param usage the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder usage(List<CodeableConcept> usage) {
                this.usage = usage == null ? new ArrayList<>() : new ArrayList<>(usage);
                return this;
            }

            /**
             * Adds a {@code usage} value.
             *
             * @param usage the value to add
             * @return this builder
             */
            public Builder addUsage(CodeableConcept usage) {
                this.usage.add(Objects.requireNonNull(usage, "usage"));
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
             * Sets {@code criteria}.
             *
             * @param criteria the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder criteria(Expression criteria) {
                this.criteria = criteria;
                return this;
            }

            /**
             * Builds the {@code SupplementalData}.
             *
             * @return the {@code SupplementalData}
             * @throws NullPointerException if a required element is absent
             */
            public SupplementalData build() {
                return new SupplementalData(
                        id, extension, modifierExtension, linkId, code, usage, description, criteria);
            }
        }
    }

    /** Builder for {@link Measure}. Builders are mutable and not thread-safe. */
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
        private FhirString subtitle;
        private FhirEnum<PublicationStatus> status;
        private FhirBoolean experimental;
        private DataType subject;
        private FhirEnum<FHIRTypes> basis;
        private FhirDateTime date;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private FhirMarkdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private FhirMarkdown purpose;
        private FhirMarkdown usage;
        private FhirMarkdown copyright;
        private FhirString copyrightLabel;
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private Period effectivePeriod;
        private List<CodeableConcept> topic = new ArrayList<>();
        private List<ContactDetail> author = new ArrayList<>();
        private List<ContactDetail> editor = new ArrayList<>();
        private List<ContactDetail> reviewer = new ArrayList<>();
        private List<ContactDetail> endorser = new ArrayList<>();
        private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
        private List<FhirCanonical> library = new ArrayList<>();
        private FhirMarkdown disclaimer;
        private CodeableConcept scoring;
        private CodeableConcept scoringUnit;
        private CodeableConcept compositeScoring;
        private List<CodeableConcept> type = new ArrayList<>();
        private FhirMarkdown riskAdjustment;
        private FhirMarkdown rateAggregation;
        private FhirMarkdown rationale;
        private FhirMarkdown clinicalRecommendationStatement;
        private CodeableConcept improvementNotation;
        private List<Term> term = new ArrayList<>();
        private FhirMarkdown guidance;
        private List<Group> group = new ArrayList<>();
        private List<SupplementalData> supplementalData = new ArrayList<>();

        private Builder() {
        }

        private Builder(Measure original) {
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
            this.subtitle = original.subtitle();
            this.status = original.status();
            this.experimental = original.experimental();
            this.subject = original.subject();
            this.basis = original.basis();
            this.date = original.date();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.description = original.description();
            this.useContext = new ArrayList<>(original.useContext());
            this.jurisdiction = new ArrayList<>(original.jurisdiction());
            this.purpose = original.purpose();
            this.usage = original.usage();
            this.copyright = original.copyright();
            this.copyrightLabel = original.copyrightLabel();
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.effectivePeriod = original.effectivePeriod();
            this.topic = new ArrayList<>(original.topic());
            this.author = new ArrayList<>(original.author());
            this.editor = new ArrayList<>(original.editor());
            this.reviewer = new ArrayList<>(original.reviewer());
            this.endorser = new ArrayList<>(original.endorser());
            this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
            this.library = new ArrayList<>(original.library());
            this.disclaimer = original.disclaimer();
            this.scoring = original.scoring();
            this.scoringUnit = original.scoringUnit();
            this.compositeScoring = original.compositeScoring();
            this.type = new ArrayList<>(original.type());
            this.riskAdjustment = original.riskAdjustment();
            this.rateAggregation = original.rateAggregation();
            this.rationale = original.rationale();
            this.clinicalRecommendationStatement = original.clinicalRecommendationStatement();
            this.improvementNotation = original.improvementNotation();
            this.term = new ArrayList<>(original.term());
            this.guidance = original.guidance();
            this.group = new ArrayList<>(original.group());
            this.supplementalData = new ArrayList<>(original.supplementalData());
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
         * Sets {@code subtitle}.
         *
         * @param subtitle the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subtitle(FhirString subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        /**
         * Sets {@code subtitle}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param subtitle the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subtitle(String subtitle) {
            return subtitle(subtitle == null ? null : FhirString.of(subtitle));
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
         * Sets {@code subject} to a CodeableConcept.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(CodeableConcept subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets {@code subject} to a Reference.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(Reference subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets {@code basis}.
         *
         * @param basis the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder basis(FhirEnum<FHIRTypes> basis) {
            this.basis = basis;
            return this;
        }

        /**
         * Sets {@code basis}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param basis the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder basis(FHIRTypes basis) {
            return basis(basis == null ? null : FhirEnum.of(basis));
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
         * Replaces all {@code jurisdiction} values.
         *
         * @param jurisdiction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder jurisdiction(List<CodeableConcept> jurisdiction) {
            this.jurisdiction = jurisdiction == null ? new ArrayList<>() : new ArrayList<>(jurisdiction);
            return this;
        }

        /**
         * Adds a {@code jurisdiction} value.
         *
         * @param jurisdiction the value to add
         * @return this builder
         */
        public Builder addJurisdiction(CodeableConcept jurisdiction) {
            this.jurisdiction.add(Objects.requireNonNull(jurisdiction, "jurisdiction"));
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
         * Sets {@code usage}.
         *
         * @param usage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder usage(FhirMarkdown usage) {
            this.usage = usage;
            return this;
        }

        /**
         * Sets {@code usage}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param usage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder usage(String usage) {
            return usage(usage == null ? null : FhirMarkdown.of(usage));
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
         * Sets {@code effectivePeriod}.
         *
         * @param effectivePeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effectivePeriod(Period effectivePeriod) {
            this.effectivePeriod = effectivePeriod;
            return this;
        }

        /**
         * Replaces all {@code topic} values.
         *
         * @param topic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder topic(List<CodeableConcept> topic) {
            this.topic = topic == null ? new ArrayList<>() : new ArrayList<>(topic);
            return this;
        }

        /**
         * Adds a {@code topic} value.
         *
         * @param topic the value to add
         * @return this builder
         */
        public Builder addTopic(CodeableConcept topic) {
            this.topic.add(Objects.requireNonNull(topic, "topic"));
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
         * Sets {@code disclaimer}.
         *
         * @param disclaimer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder disclaimer(FhirMarkdown disclaimer) {
            this.disclaimer = disclaimer;
            return this;
        }

        /**
         * Sets {@code disclaimer}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param disclaimer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder disclaimer(String disclaimer) {
            return disclaimer(disclaimer == null ? null : FhirMarkdown.of(disclaimer));
        }

        /**
         * Sets {@code scoring}.
         *
         * @param scoring the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder scoring(CodeableConcept scoring) {
            this.scoring = scoring;
            return this;
        }

        /**
         * Sets {@code scoringUnit}.
         *
         * @param scoringUnit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder scoringUnit(CodeableConcept scoringUnit) {
            this.scoringUnit = scoringUnit;
            return this;
        }

        /**
         * Sets {@code compositeScoring}.
         *
         * @param compositeScoring the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder compositeScoring(CodeableConcept compositeScoring) {
            this.compositeScoring = compositeScoring;
            return this;
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
         * Sets {@code riskAdjustment}.
         *
         * @param riskAdjustment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder riskAdjustment(FhirMarkdown riskAdjustment) {
            this.riskAdjustment = riskAdjustment;
            return this;
        }

        /**
         * Sets {@code riskAdjustment}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param riskAdjustment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder riskAdjustment(String riskAdjustment) {
            return riskAdjustment(riskAdjustment == null ? null : FhirMarkdown.of(riskAdjustment));
        }

        /**
         * Sets {@code rateAggregation}.
         *
         * @param rateAggregation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder rateAggregation(FhirMarkdown rateAggregation) {
            this.rateAggregation = rateAggregation;
            return this;
        }

        /**
         * Sets {@code rateAggregation}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param rateAggregation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder rateAggregation(String rateAggregation) {
            return rateAggregation(rateAggregation == null ? null : FhirMarkdown.of(rateAggregation));
        }

        /**
         * Sets {@code rationale}.
         *
         * @param rationale the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder rationale(FhirMarkdown rationale) {
            this.rationale = rationale;
            return this;
        }

        /**
         * Sets {@code rationale}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param rationale the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder rationale(String rationale) {
            return rationale(rationale == null ? null : FhirMarkdown.of(rationale));
        }

        /**
         * Sets {@code clinicalRecommendationStatement}.
         *
         * @param clinicalRecommendationStatement the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder clinicalRecommendationStatement(FhirMarkdown clinicalRecommendationStatement) {
            this.clinicalRecommendationStatement = clinicalRecommendationStatement;
            return this;
        }

        /**
         * Sets {@code clinicalRecommendationStatement}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param clinicalRecommendationStatement the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder clinicalRecommendationStatement(String clinicalRecommendationStatement) {
            return clinicalRecommendationStatement(
                    clinicalRecommendationStatement == null ? null : FhirMarkdown.of(clinicalRecommendationStatement));
        }

        /**
         * Sets {@code improvementNotation}.
         *
         * @param improvementNotation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder improvementNotation(CodeableConcept improvementNotation) {
            this.improvementNotation = improvementNotation;
            return this;
        }

        /**
         * Replaces all {@code term} values.
         *
         * @param term the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder term(List<Term> term) {
            this.term = term == null ? new ArrayList<>() : new ArrayList<>(term);
            return this;
        }

        /**
         * Adds a {@code term} value.
         *
         * @param term the value to add
         * @return this builder
         */
        public Builder addTerm(Term term) {
            this.term.add(Objects.requireNonNull(term, "term"));
            return this;
        }

        /**
         * Sets {@code guidance}.
         *
         * @param guidance the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder guidance(FhirMarkdown guidance) {
            this.guidance = guidance;
            return this;
        }

        /**
         * Sets {@code guidance}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param guidance the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder guidance(String guidance) {
            return guidance(guidance == null ? null : FhirMarkdown.of(guidance));
        }

        /**
         * Replaces all {@code group} values.
         *
         * @param group the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder group(List<Group> group) {
            this.group = group == null ? new ArrayList<>() : new ArrayList<>(group);
            return this;
        }

        /**
         * Adds a {@code group} value.
         *
         * @param group the value to add
         * @return this builder
         */
        public Builder addGroup(Group group) {
            this.group.add(Objects.requireNonNull(group, "group"));
            return this;
        }

        /**
         * Replaces all {@code supplementalData} values.
         *
         * @param supplementalData the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supplementalData(List<SupplementalData> supplementalData) {
            this.supplementalData = supplementalData == null ? new ArrayList<>() : new ArrayList<>(supplementalData);
            return this;
        }

        /**
         * Adds a {@code supplementalData} value.
         *
         * @param supplementalData the value to add
         * @return this builder
         */
        public Builder addSupplementalData(SupplementalData supplementalData) {
            this.supplementalData.add(Objects.requireNonNull(supplementalData, "supplementalData"));
            return this;
        }

        /**
         * Builds the {@code Measure}.
         *
         * @return the {@code Measure}
         * @throws NullPointerException if a required element is absent
         */
        public Measure build() {
            return new Measure(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, subtitle, status, experimental, subject, basis, date,
                    publisher, contact, description, useContext, jurisdiction, purpose, usage, copyright,
                    copyrightLabel, approvalDate, lastReviewDate, effectivePeriod, topic, author, editor, reviewer,
                    endorser, relatedArtifact, library, disclaimer, scoring, scoringUnit, compositeScoring, type,
                    riskAdjustment, rateAggregation, rationale, clinicalRecommendationStatement, improvementNotation,
                    term, guidance, group, supplementalData);
        }
    }
}
