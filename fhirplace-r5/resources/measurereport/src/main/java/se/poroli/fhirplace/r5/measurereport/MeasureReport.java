package se.poroli.fhirplace.r5.measurereport;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the
 * resources involved in that calculation.
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
 * @param identifier Additional identifier for the MeasureReport.
 * @param status complete | pending | error. Required. Modifier element.
 * @param type individual | subject-list | summary | data-exchange. Required.
 * @param dataUpdateType incremental | snapshot. Modifier element.
 * @param measure What measure was calculated. Canonical reference to Measure.
 * @param subject What individual(s) the report is for. Reference to CareTeam, Device, Group, HealthcareService,
 *   Location, Organization, Patient, Practitioner, PractitionerRole, RelatedPerson.
 * @param date When the measure was calculated.
 * @param reporter Who is reporting the data. Reference to Practitioner, PractitionerRole, Organization, Group.
 * @param reportingVendor What vendor prepared the data. Reference to Organization.
 * @param location Where the reported data is from. Reference to Location.
 * @param period What period the report covers. Required.
 * @param inputParameters What parameters were provided to the report. Reference to Parameters.
 * @param scoring What scoring method (e.g. proportion, ratio, continuous-variable). Modifier element.
 * @param improvementNotation increase | decrease. Modifier element.
 * @param group Measure results for each group.
 * @param supplementalData Additional information collected for the report. Reference to Resource.
 * @param evaluatedResource What data was used to calculate the measure score. Reference to Resource.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MeasureReport">FHIR R5 MeasureReport</a>
 */
public record MeasureReport(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<MeasureReportStatus> status,
        FhirEnum<MeasureReportType> type,
        FhirEnum<SubmitDataUpdateType> dataUpdateType,
        FhirCanonical measure,
        Reference subject,
        FhirDateTime date,
        Reference reporter,
        Reference reportingVendor,
        Reference location,
        Period period,
        Reference inputParameters,
        CodeableConcept scoring,
        CodeableConcept improvementNotation,
        List<Group> group,
        List<Reference> supplementalData,
        List<Reference> evaluatedResource) implements DomainResource {

    /**
     * Creates a {@code MeasureReport}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public MeasureReport {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        group = group == null ? List.of() : List.copyOf(group);
        supplementalData = supplementalData == null ? List.of() : List.copyOf(supplementalData);
        evaluatedResource = evaluatedResource == null ? List.of() : List.copyOf(evaluatedResource);
        Objects.requireNonNull(status, "MeasureReport.status is required");
        Objects.requireNonNull(type, "MeasureReport.type is required");
        Objects.requireNonNull(period, "MeasureReport.period is required");
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
     * Returns a builder initialized with the values of this {@code MeasureReport}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The results of the calculation, one for each population group in the measure.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param linkId Pointer to specific group from Measure.
     * @param code Meaning of the group.
     * @param subject What individual(s) the report is for. Reference to CareTeam, Device, Group, HealthcareService,
     *   Location, Organization, Patient, Practitioner, PractitionerRole, RelatedPerson.
     * @param population The populations in the group.
     * @param measureScore What score this group achieved. One of Quantity, dateTime, CodeableConcept, Period, Range,
     *   Duration.
     * @param stratifier Stratification results.
     */
    public record Group(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString linkId,
            CodeableConcept code,
            Reference subject,
            List<Population> population,
            DataType measureScore,
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
            population = population == null ? List.of() : List.copyOf(population);
            stratifier = stratifier == null ? List.of() : List.copyOf(stratifier);
            if (measureScore != null && !(measureScore instanceof Quantity
                    || measureScore instanceof FhirDateTime
                    || measureScore instanceof CodeableConcept
                    || measureScore instanceof Period
                    || measureScore instanceof Range
                    || measureScore instanceof Duration)) {
                throw new IllegalArgumentException(
                        "MeasureReport.group.measureScore[x] does not allow "
                                + measureScore.getClass().getSimpleName());
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
         * The populations that make up the population group, one for each type of population appropriate for the
         * measure.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param linkId Pointer to specific population from Measure.
         * @param code initial-population | numerator | numerator-exclusion | denominator | denominator-exclusion |
         *   denominator-exception | measure-population | measure-population-exclusion | measure-observation.
         * @param count Size of the population.
         * @param subjectResults For subject-list reports, the subject results in this population. Reference to List.
         * @param subjectReport For subject-list reports, a subject result in this population. Reference to
         *   MeasureReport.
         * @param subjects What individual(s) in the population. Reference to Group.
         */
        public record Population(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString linkId,
                CodeableConcept code,
                FhirInteger count,
                Reference subjectResults,
                List<Reference> subjectReport,
                Reference subjects) implements BackboneElement {

            /**
             * Creates a {@code Population}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Population {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                subjectReport = subjectReport == null ? List.of() : List.copyOf(subjectReport);
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
                private FhirInteger count;
                private Reference subjectResults;
                private List<Reference> subjectReport = new ArrayList<>();
                private Reference subjects;

                private Builder() {
                }

                private Builder(Population original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.linkId = original.linkId();
                    this.code = original.code();
                    this.count = original.count();
                    this.subjectResults = original.subjectResults();
                    this.subjectReport = new ArrayList<>(original.subjectReport());
                    this.subjects = original.subjects();
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
                 * Sets {@code count}.
                 *
                 * @param count the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder count(FhirInteger count) {
                    this.count = count;
                    return this;
                }

                /**
                 * Sets {@code count}, wrapped in a {@link FhirInteger} without id or extensions.
                 *
                 * @param count the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder count(Integer count) {
                    return count(count == null ? null : FhirInteger.of(count));
                }

                /**
                 * Sets {@code subjectResults}.
                 *
                 * @param subjectResults the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder subjectResults(Reference subjectResults) {
                    this.subjectResults = subjectResults;
                    return this;
                }

                /**
                 * Replaces all {@code subjectReport} values.
                 *
                 * @param subjectReport the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder subjectReport(List<Reference> subjectReport) {
                    this.subjectReport = subjectReport == null ? new ArrayList<>() : new ArrayList<>(subjectReport);
                    return this;
                }

                /**
                 * Adds a {@code subjectReport} value.
                 *
                 * @param subjectReport the value to add
                 * @return this builder
                 */
                public Builder addSubjectReport(Reference subjectReport) {
                    this.subjectReport.add(Objects.requireNonNull(subjectReport, "subjectReport"));
                    return this;
                }

                /**
                 * Sets {@code subjects}.
                 *
                 * @param subjects the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder subjects(Reference subjects) {
                    this.subjects = subjects;
                    return this;
                }

                /**
                 * Builds the {@code Population}.
                 *
                 * @return the {@code Population}
                 */
                public Population build() {
                    return new Population(
                            id, extension, modifierExtension, linkId, code, count, subjectResults, subjectReport,
                            subjects);
                }
            }
        }

        /**
         * When a measure includes multiple stratifiers, there will be a stratifier group for each stratifier defined
         * by the measure.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param linkId Pointer to specific stratifier from Measure.
         * @param code What stratifier of the group.
         * @param stratum Stratum results, one for each unique value, or set of values, in the stratifier, or
         *   stratifier components.
         */
        public record Stratifier(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString linkId,
                CodeableConcept code,
                List<StratifierGroup> stratum) implements BackboneElement {

            /**
             * Creates a {@code Stratifier}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Stratifier {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                stratum = stratum == null ? List.of() : List.copyOf(stratum);
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
             * This element contains the results for a single stratum within the stratifier.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param value The stratum value, e.g. male. One of CodeableConcept, boolean, Quantity, Range, Reference.
             * @param component Stratifier component values.
             * @param population Population results in this stratum.
             * @param measureScore What score this stratum achieved. One of Quantity, dateTime, CodeableConcept,
             *   Period, Range, Duration.
             */
            public record StratifierGroup(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    DataType value,
                    List<Component> component,
                    List<StratifierGroupPopulation> population,
                    DataType measureScore) implements BackboneElement {

                /**
                 * Creates a {@code StratifierGroup}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 * @throws IllegalArgumentException if a choice element has a type that is not allowed
                 */
                public StratifierGroup {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    component = component == null ? List.of() : List.copyOf(component);
                    population = population == null ? List.of() : List.copyOf(population);
                    if (value != null && !(value instanceof CodeableConcept
                            || value instanceof FhirBoolean
                            || value instanceof Quantity
                            || value instanceof Range
                            || value instanceof Reference)) {
                        throw new IllegalArgumentException(
                                "MeasureReport.group.stratifier.stratum.value[x] does not allow "
                                        + value.getClass().getSimpleName());
                    }
                    if (measureScore != null && !(measureScore instanceof Quantity
                            || measureScore instanceof FhirDateTime
                            || measureScore instanceof CodeableConcept
                            || measureScore instanceof Period
                            || measureScore instanceof Range
                            || measureScore instanceof Duration)) {
                        throw new IllegalArgumentException(
                                "MeasureReport.group.stratifier.stratum.measureScore[x] does not allow "
                                        + measureScore.getClass().getSimpleName());
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
                 * Returns a builder initialized with the values of this {@code StratifierGroup}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /**
                 * A stratifier component value.
                 *
                 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
                 * Instances are usually created with {@link #builder()}.
                 *
                 * @param id Unique id for inter-element referencing.
                 * @param extension Additional content defined by implementations.
                 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
                 * @param linkId Pointer to specific stratifier component from Measure.
                 * @param code What stratifier component of the group. Required.
                 * @param value The stratum component value, e.g. male. One of CodeableConcept, boolean, Quantity,
                 *   Range, Reference. Required.
                 */
                public record Component(
                        String id,
                        List<Extension> extension,
                        List<Extension> modifierExtension,
                        FhirString linkId,
                        CodeableConcept code,
                        DataType value) implements BackboneElement {

                    /**
                     * Creates a {@code Component}, copying all lists.
                     *
                     * @throws NullPointerException if a required element is absent or a list contains {@code null}
                     * @throws IllegalArgumentException if a choice element has a type that is not allowed
                     */
                    public Component {
                        extension = extension == null ? List.of() : List.copyOf(extension);
                        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                        Objects.requireNonNull(
                                code, "MeasureReport.group.stratifier.stratum.component.code is required");
                        Objects.requireNonNull(
                                value, "MeasureReport.group.stratifier.stratum.component.value is required");
                        if (value != null && !(value instanceof CodeableConcept
                                || value instanceof FhirBoolean
                                || value instanceof Quantity
                                || value instanceof Range
                                || value instanceof Reference)) {
                            throw new IllegalArgumentException(
                                    "MeasureReport.group.stratifier.stratum.component.value[x] does not allow "
                                            + value.getClass().getSimpleName());
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
                        private DataType value;

                        private Builder() {
                        }

                        private Builder(Component original) {
                            this.id = original.id();
                            this.extension = new ArrayList<>(original.extension());
                            this.modifierExtension = new ArrayList<>(original.modifierExtension());
                            this.linkId = original.linkId();
                            this.code = original.code();
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
                            this.modifierExtension.add(
                                    Objects.requireNonNull(modifierExtension, "modifierExtension"));
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
                         * Sets {@code value} to a CodeableConcept.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(CodeableConcept value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a boolean.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirBoolean value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a Quantity.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(Quantity value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a Range.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(Range value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a Reference.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(Reference value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a boolean without id or extensions.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(Boolean value) {
                            this.value = value == null ? null : FhirBoolean.of(value);
                            return this;
                        }

                        /**
                         * Builds the {@code Component}.
                         *
                         * @return the {@code Component}
                         * @throws NullPointerException if a required element is absent
                         */
                        public Component build() {
                            return new Component(
                                    id, extension, modifierExtension, linkId, code, value);
                        }
                    }
                }

                /**
                 * The populations that make up the stratum, one for each type of population appropriate to the
                 * measure.
                 *
                 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
                 * Instances are usually created with {@link #builder()}.
                 *
                 * @param id Unique id for inter-element referencing.
                 * @param extension Additional content defined by implementations.
                 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
                 * @param linkId Pointer to specific population from Measure.
                 * @param code initial-population | numerator | numerator-exclusion | denominator |
                 *   denominator-exclusion | denominator-exception | measure-population | measure-population-exclusion
                 *   | measure-observation.
                 * @param count Size of the population.
                 * @param subjectResults For subject-list reports, the subject results in this population. Reference
                 *   to List.
                 * @param subjectReport For subject-list reports, a subject result in this population. Reference to
                 *   MeasureReport.
                 * @param subjects What individual(s) in the population. Reference to Group.
                 */
                public record StratifierGroupPopulation(
                        String id,
                        List<Extension> extension,
                        List<Extension> modifierExtension,
                        FhirString linkId,
                        CodeableConcept code,
                        FhirInteger count,
                        Reference subjectResults,
                        List<Reference> subjectReport,
                        Reference subjects) implements BackboneElement {

                    /**
                     * Creates a {@code StratifierGroupPopulation}, copying all lists.
                     *
                     * @throws NullPointerException if a list contains {@code null}
                     */
                    public StratifierGroupPopulation {
                        extension = extension == null ? List.of() : List.copyOf(extension);
                        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                        subjectReport = subjectReport == null ? List.of() : List.copyOf(subjectReport);
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
                     * Returns a builder initialized with the values of this {@code StratifierGroupPopulation}.
                     *
                     * @return the builder
                     */
                    public Builder toBuilder() {
                        return new Builder(this);
                    }

                    /** Builder for {@link StratifierGroupPopulation}. Builders are mutable and not thread-safe. */
                    public static final class Builder {

                        private String id;
                        private List<Extension> extension = new ArrayList<>();
                        private List<Extension> modifierExtension = new ArrayList<>();
                        private FhirString linkId;
                        private CodeableConcept code;
                        private FhirInteger count;
                        private Reference subjectResults;
                        private List<Reference> subjectReport = new ArrayList<>();
                        private Reference subjects;

                        private Builder() {
                        }

                        private Builder(StratifierGroupPopulation original) {
                            this.id = original.id();
                            this.extension = new ArrayList<>(original.extension());
                            this.modifierExtension = new ArrayList<>(original.modifierExtension());
                            this.linkId = original.linkId();
                            this.code = original.code();
                            this.count = original.count();
                            this.subjectResults = original.subjectResults();
                            this.subjectReport = new ArrayList<>(original.subjectReport());
                            this.subjects = original.subjects();
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
                            this.modifierExtension.add(
                                    Objects.requireNonNull(modifierExtension, "modifierExtension"));
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
                         * Sets {@code count}.
                         *
                         * @param count the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder count(FhirInteger count) {
                            this.count = count;
                            return this;
                        }

                        /**
                         * Sets {@code count}, wrapped in a {@link FhirInteger} without id or extensions.
                         *
                         * @param count the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder count(Integer count) {
                            return count(count == null ? null : FhirInteger.of(count));
                        }

                        /**
                         * Sets {@code subjectResults}.
                         *
                         * @param subjectResults the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder subjectResults(Reference subjectResults) {
                            this.subjectResults = subjectResults;
                            return this;
                        }

                        /**
                         * Replaces all {@code subjectReport} values.
                         *
                         * @param subjectReport the new values, or {@code null} to clear them
                         * @return this builder
                         */
                        public Builder subjectReport(List<Reference> subjectReport) {
                            this.subjectReport = subjectReport == null
                                    ? new ArrayList<>()
                                    : new ArrayList<>(subjectReport);
                            return this;
                        }

                        /**
                         * Adds a {@code subjectReport} value.
                         *
                         * @param subjectReport the value to add
                         * @return this builder
                         */
                        public Builder addSubjectReport(Reference subjectReport) {
                            this.subjectReport.add(Objects.requireNonNull(subjectReport, "subjectReport"));
                            return this;
                        }

                        /**
                         * Sets {@code subjects}.
                         *
                         * @param subjects the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder subjects(Reference subjects) {
                            this.subjects = subjects;
                            return this;
                        }

                        /**
                         * Builds the {@code StratifierGroupPopulation}.
                         *
                         * @return the {@code StratifierGroupPopulation}
                         */
                        public StratifierGroupPopulation build() {
                            return new StratifierGroupPopulation(
                                    id, extension, modifierExtension, linkId, code, count, subjectResults,
                                    subjectReport, subjects);
                        }
                    }
                }

                /** Builder for {@link StratifierGroup}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private DataType value;
                    private List<Component> component = new ArrayList<>();
                    private List<StratifierGroupPopulation> population = new ArrayList<>();
                    private DataType measureScore;

                    private Builder() {
                    }

                    private Builder(StratifierGroup original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.value = original.value();
                        this.component = new ArrayList<>(original.component());
                        this.population = new ArrayList<>(original.population());
                        this.measureScore = original.measureScore();
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
                     * Sets {@code value} to a CodeableConcept.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(CodeableConcept value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value} to a boolean.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(FhirBoolean value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value} to a Quantity.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(Quantity value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value} to a Range.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(Range value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value} to a Reference.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(Reference value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value} to a boolean without id or extensions.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(Boolean value) {
                        this.value = value == null ? null : FhirBoolean.of(value);
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
                     * Replaces all {@code population} values.
                     *
                     * @param population the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder population(List<StratifierGroupPopulation> population) {
                        this.population = population == null ? new ArrayList<>() : new ArrayList<>(population);
                        return this;
                    }

                    /**
                     * Adds a {@code population} value.
                     *
                     * @param population the value to add
                     * @return this builder
                     */
                    public Builder addPopulation(StratifierGroupPopulation population) {
                        this.population.add(Objects.requireNonNull(population, "population"));
                        return this;
                    }

                    /**
                     * Sets {@code measureScore} to a Quantity.
                     *
                     * @param measureScore the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder measureScore(Quantity measureScore) {
                        this.measureScore = measureScore;
                        return this;
                    }

                    /**
                     * Sets {@code measureScore} to a dateTime.
                     *
                     * @param measureScore the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder measureScore(FhirDateTime measureScore) {
                        this.measureScore = measureScore;
                        return this;
                    }

                    /**
                     * Sets {@code measureScore} to a CodeableConcept.
                     *
                     * @param measureScore the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder measureScore(CodeableConcept measureScore) {
                        this.measureScore = measureScore;
                        return this;
                    }

                    /**
                     * Sets {@code measureScore} to a Period.
                     *
                     * @param measureScore the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder measureScore(Period measureScore) {
                        this.measureScore = measureScore;
                        return this;
                    }

                    /**
                     * Sets {@code measureScore} to a Range.
                     *
                     * @param measureScore the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder measureScore(Range measureScore) {
                        this.measureScore = measureScore;
                        return this;
                    }

                    /**
                     * Sets {@code measureScore} to a Duration.
                     *
                     * @param measureScore the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder measureScore(Duration measureScore) {
                        this.measureScore = measureScore;
                        return this;
                    }

                    /**
                     * Sets {@code measureScore} to a dateTime without id or extensions.
                     *
                     * @param measureScore the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder measureScore(Temporal measureScore) {
                        this.measureScore = measureScore == null ? null : FhirDateTime.of(measureScore);
                        return this;
                    }

                    /**
                     * Builds the {@code StratifierGroup}.
                     *
                     * @return the {@code StratifierGroup}
                     */
                    public StratifierGroup build() {
                        return new StratifierGroup(
                                id, extension, modifierExtension, value, component, population, measureScore);
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
                private List<StratifierGroup> stratum = new ArrayList<>();

                private Builder() {
                }

                private Builder(Stratifier original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.linkId = original.linkId();
                    this.code = original.code();
                    this.stratum = new ArrayList<>(original.stratum());
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
                 * Replaces all {@code stratum} values.
                 *
                 * @param stratum the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder stratum(List<StratifierGroup> stratum) {
                    this.stratum = stratum == null ? new ArrayList<>() : new ArrayList<>(stratum);
                    return this;
                }

                /**
                 * Adds a {@code stratum} value.
                 *
                 * @param stratum the value to add
                 * @return this builder
                 */
                public Builder addStratum(StratifierGroup stratum) {
                    this.stratum.add(Objects.requireNonNull(stratum, "stratum"));
                    return this;
                }

                /**
                 * Builds the {@code Stratifier}.
                 *
                 * @return the {@code Stratifier}
                 */
                public Stratifier build() {
                    return new Stratifier(
                            id, extension, modifierExtension, linkId, code, stratum);
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
            private Reference subject;
            private List<Population> population = new ArrayList<>();
            private DataType measureScore;
            private List<Stratifier> stratifier = new ArrayList<>();

            private Builder() {
            }

            private Builder(Group original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.linkId = original.linkId();
                this.code = original.code();
                this.subject = original.subject();
                this.population = new ArrayList<>(original.population());
                this.measureScore = original.measureScore();
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
             * Sets {@code measureScore} to a Quantity.
             *
             * @param measureScore the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder measureScore(Quantity measureScore) {
                this.measureScore = measureScore;
                return this;
            }

            /**
             * Sets {@code measureScore} to a dateTime.
             *
             * @param measureScore the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder measureScore(FhirDateTime measureScore) {
                this.measureScore = measureScore;
                return this;
            }

            /**
             * Sets {@code measureScore} to a CodeableConcept.
             *
             * @param measureScore the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder measureScore(CodeableConcept measureScore) {
                this.measureScore = measureScore;
                return this;
            }

            /**
             * Sets {@code measureScore} to a Period.
             *
             * @param measureScore the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder measureScore(Period measureScore) {
                this.measureScore = measureScore;
                return this;
            }

            /**
             * Sets {@code measureScore} to a Range.
             *
             * @param measureScore the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder measureScore(Range measureScore) {
                this.measureScore = measureScore;
                return this;
            }

            /**
             * Sets {@code measureScore} to a Duration.
             *
             * @param measureScore the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder measureScore(Duration measureScore) {
                this.measureScore = measureScore;
                return this;
            }

            /**
             * Sets {@code measureScore} to a dateTime without id or extensions.
             *
             * @param measureScore the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder measureScore(Temporal measureScore) {
                this.measureScore = measureScore == null ? null : FhirDateTime.of(measureScore);
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
                        id, extension, modifierExtension, linkId, code, subject, population, measureScore, stratifier);
            }
        }
    }

    /** Builder for {@link MeasureReport}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<MeasureReportStatus> status;
        private FhirEnum<MeasureReportType> type;
        private FhirEnum<SubmitDataUpdateType> dataUpdateType;
        private FhirCanonical measure;
        private Reference subject;
        private FhirDateTime date;
        private Reference reporter;
        private Reference reportingVendor;
        private Reference location;
        private Period period;
        private Reference inputParameters;
        private CodeableConcept scoring;
        private CodeableConcept improvementNotation;
        private List<Group> group = new ArrayList<>();
        private List<Reference> supplementalData = new ArrayList<>();
        private List<Reference> evaluatedResource = new ArrayList<>();

        private Builder() {
        }

        private Builder(MeasureReport original) {
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
            this.type = original.type();
            this.dataUpdateType = original.dataUpdateType();
            this.measure = original.measure();
            this.subject = original.subject();
            this.date = original.date();
            this.reporter = original.reporter();
            this.reportingVendor = original.reportingVendor();
            this.location = original.location();
            this.period = original.period();
            this.inputParameters = original.inputParameters();
            this.scoring = original.scoring();
            this.improvementNotation = original.improvementNotation();
            this.group = new ArrayList<>(original.group());
            this.supplementalData = new ArrayList<>(original.supplementalData());
            this.evaluatedResource = new ArrayList<>(original.evaluatedResource());
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
        public Builder status(FhirEnum<MeasureReportStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(MeasureReportStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<MeasureReportType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(MeasureReportType type) {
            return type(type == null ? null : FhirEnum.of(type));
        }

        /**
         * Sets {@code dataUpdateType}.
         *
         * @param dataUpdateType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dataUpdateType(FhirEnum<SubmitDataUpdateType> dataUpdateType) {
            this.dataUpdateType = dataUpdateType;
            return this;
        }

        /**
         * Sets {@code dataUpdateType}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param dataUpdateType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dataUpdateType(SubmitDataUpdateType dataUpdateType) {
            return dataUpdateType(dataUpdateType == null ? null : FhirEnum.of(dataUpdateType));
        }

        /**
         * Sets {@code measure}.
         *
         * @param measure the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder measure(FhirCanonical measure) {
            this.measure = measure;
            return this;
        }

        /**
         * Sets {@code measure}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param measure the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder measure(String measure) {
            return measure(measure == null ? null : FhirCanonical.of(measure));
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
         * Sets {@code reporter}.
         *
         * @param reporter the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reporter(Reference reporter) {
            this.reporter = reporter;
            return this;
        }

        /**
         * Sets {@code reportingVendor}.
         *
         * @param reportingVendor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reportingVendor(Reference reportingVendor) {
            this.reportingVendor = reportingVendor;
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
         * Sets {@code inputParameters}.
         *
         * @param inputParameters the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder inputParameters(Reference inputParameters) {
            this.inputParameters = inputParameters;
            return this;
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
        public Builder supplementalData(List<Reference> supplementalData) {
            this.supplementalData = supplementalData == null ? new ArrayList<>() : new ArrayList<>(supplementalData);
            return this;
        }

        /**
         * Adds a {@code supplementalData} value.
         *
         * @param supplementalData the value to add
         * @return this builder
         */
        public Builder addSupplementalData(Reference supplementalData) {
            this.supplementalData.add(Objects.requireNonNull(supplementalData, "supplementalData"));
            return this;
        }

        /**
         * Replaces all {@code evaluatedResource} values.
         *
         * @param evaluatedResource the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder evaluatedResource(List<Reference> evaluatedResource) {
            this.evaluatedResource = evaluatedResource == null
                    ? new ArrayList<>()
                    : new ArrayList<>(evaluatedResource);
            return this;
        }

        /**
         * Adds a {@code evaluatedResource} value.
         *
         * @param evaluatedResource the value to add
         * @return this builder
         */
        public Builder addEvaluatedResource(Reference evaluatedResource) {
            this.evaluatedResource.add(Objects.requireNonNull(evaluatedResource, "evaluatedResource"));
            return this;
        }

        /**
         * Builds the {@code MeasureReport}.
         *
         * @return the {@code MeasureReport}
         * @throws NullPointerException if a required element is absent
         */
        public MeasureReport build() {
            return new MeasureReport(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, type, dataUpdateType, measure, subject, date, reporter, reportingVendor, location, period,
                    inputParameters, scoring, improvementNotation, group, supplementalData, evaluatedResource);
        }
    }
}
