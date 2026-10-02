package se.poroli.fhirplace.r5.immunizationrecommendation;

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
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional
 * supporting justification.
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
 * @param patient Who this profile is for. Reference to Patient. Required.
 * @param date Date recommendation(s) created. Required.
 * @param authority Who is responsible for protocol. Reference to Organization.
 * @param recommendation Vaccine administration recommendations. Required.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ImmunizationRecommendation">FHIR R5 ImmunizationRecommendation</a>
 */
public record ImmunizationRecommendation(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        Reference patient,
        FhirDateTime date,
        Reference authority,
        List<Recommendation> recommendation) implements DomainResource {

    /**
     * Creates an {@code ImmunizationRecommendation}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a required list is empty
     */
    public ImmunizationRecommendation {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        recommendation = recommendation == null ? List.of() : List.copyOf(recommendation);
        Objects.requireNonNull(patient, "ImmunizationRecommendation.patient is required");
        Objects.requireNonNull(date, "ImmunizationRecommendation.date is required");
        if (recommendation.isEmpty()) {
            throw new IllegalArgumentException(
                    "ImmunizationRecommendation.recommendation requires at least one value");
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
     * Returns a builder initialized with the values of this {@code ImmunizationRecommendation}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Vaccine administration recommendations.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param vaccineCode Vaccine or vaccine group recommendation applies to.
     * @param targetDisease Disease to be immunized against.
     * @param contraindicatedVaccineCode Vaccine which is contraindicated to fulfill the recommendation.
     * @param forecastStatus Vaccine recommendation status. Required. Modifier element.
     * @param forecastReason Vaccine administration status reason.
     * @param dateCriterion Dates governing proposed immunization.
     * @param description Protocol details.
     * @param series Name of vaccination series.
     * @param doseNumber Recommended dose number within series.
     * @param seriesDoses Recommended number of doses for immunity.
     * @param supportingImmunization Past immunizations supporting recommendation. Reference to Immunization,
     *   ImmunizationEvaluation.
     * @param supportingPatientInformation Patient observations supporting recommendation. Reference to Resource.
     */
    public record Recommendation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableConcept> vaccineCode,
            List<CodeableConcept> targetDisease,
            List<CodeableConcept> contraindicatedVaccineCode,
            CodeableConcept forecastStatus,
            List<CodeableConcept> forecastReason,
            List<DateCriterion> dateCriterion,
            FhirMarkdown description,
            FhirString series,
            FhirString doseNumber,
            FhirString seriesDoses,
            List<Reference> supportingImmunization,
            List<Reference> supportingPatientInformation) implements BackboneElement {

        /**
         * Creates a {@code Recommendation}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Recommendation {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            vaccineCode = vaccineCode == null ? List.of() : List.copyOf(vaccineCode);
            targetDisease = targetDisease == null ? List.of() : List.copyOf(targetDisease);
            contraindicatedVaccineCode =
                    contraindicatedVaccineCode == null ? List.of() : List.copyOf(contraindicatedVaccineCode);
            forecastReason = forecastReason == null ? List.of() : List.copyOf(forecastReason);
            dateCriterion = dateCriterion == null ? List.of() : List.copyOf(dateCriterion);
            supportingImmunization = supportingImmunization == null ? List.of() : List.copyOf(supportingImmunization);
            supportingPatientInformation =
                    supportingPatientInformation == null ? List.of() : List.copyOf(supportingPatientInformation);
            Objects.requireNonNull(
                    forecastStatus, "ImmunizationRecommendation.recommendation.forecastStatus is required");
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
         * Returns a builder initialized with the values of this {@code Recommendation}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Vaccine date recommendations.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code Type of date. Required.
         * @param value Recommended date. Required.
         */
        public record DateCriterion(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept code,
                FhirDateTime value) implements BackboneElement {

            /**
             * Creates a {@code DateCriterion}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public DateCriterion {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(
                        code, "ImmunizationRecommendation.recommendation.dateCriterion.code is required");
                Objects.requireNonNull(
                        value, "ImmunizationRecommendation.recommendation.dateCriterion.value is required");
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
             * Returns a builder initialized with the values of this {@code DateCriterion}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link DateCriterion}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept code;
                private FhirDateTime value;

                private Builder() {
                }

                private Builder(DateCriterion original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
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
                public Builder value(FhirDateTime value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value}, wrapped in a {@link FhirDateTime} without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Temporal value) {
                    return value(value == null ? null : FhirDateTime.of(value));
                }

                /**
                 * Builds the {@code DateCriterion}.
                 *
                 * @return the {@code DateCriterion}
                 * @throws NullPointerException if a required element is absent
                 */
                public DateCriterion build() {
                    return new DateCriterion(
                            id, extension, modifierExtension, code, value);
                }
            }
        }

        /** Builder for {@link Recommendation}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<CodeableConcept> vaccineCode = new ArrayList<>();
            private List<CodeableConcept> targetDisease = new ArrayList<>();
            private List<CodeableConcept> contraindicatedVaccineCode = new ArrayList<>();
            private CodeableConcept forecastStatus;
            private List<CodeableConcept> forecastReason = new ArrayList<>();
            private List<DateCriterion> dateCriterion = new ArrayList<>();
            private FhirMarkdown description;
            private FhirString series;
            private FhirString doseNumber;
            private FhirString seriesDoses;
            private List<Reference> supportingImmunization = new ArrayList<>();
            private List<Reference> supportingPatientInformation = new ArrayList<>();

            private Builder() {
            }

            private Builder(Recommendation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.vaccineCode = new ArrayList<>(original.vaccineCode());
                this.targetDisease = new ArrayList<>(original.targetDisease());
                this.contraindicatedVaccineCode = new ArrayList<>(original.contraindicatedVaccineCode());
                this.forecastStatus = original.forecastStatus();
                this.forecastReason = new ArrayList<>(original.forecastReason());
                this.dateCriterion = new ArrayList<>(original.dateCriterion());
                this.description = original.description();
                this.series = original.series();
                this.doseNumber = original.doseNumber();
                this.seriesDoses = original.seriesDoses();
                this.supportingImmunization = new ArrayList<>(original.supportingImmunization());
                this.supportingPatientInformation = new ArrayList<>(original.supportingPatientInformation());
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
             * Replaces all {@code vaccineCode} values.
             *
             * @param vaccineCode the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder vaccineCode(List<CodeableConcept> vaccineCode) {
                this.vaccineCode = vaccineCode == null ? new ArrayList<>() : new ArrayList<>(vaccineCode);
                return this;
            }

            /**
             * Adds a {@code vaccineCode} value.
             *
             * @param vaccineCode the value to add
             * @return this builder
             */
            public Builder addVaccineCode(CodeableConcept vaccineCode) {
                this.vaccineCode.add(Objects.requireNonNull(vaccineCode, "vaccineCode"));
                return this;
            }

            /**
             * Replaces all {@code targetDisease} values.
             *
             * @param targetDisease the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder targetDisease(List<CodeableConcept> targetDisease) {
                this.targetDisease = targetDisease == null ? new ArrayList<>() : new ArrayList<>(targetDisease);
                return this;
            }

            /**
             * Adds a {@code targetDisease} value.
             *
             * @param targetDisease the value to add
             * @return this builder
             */
            public Builder addTargetDisease(CodeableConcept targetDisease) {
                this.targetDisease.add(Objects.requireNonNull(targetDisease, "targetDisease"));
                return this;
            }

            /**
             * Replaces all {@code contraindicatedVaccineCode} values.
             *
             * @param contraindicatedVaccineCode the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder contraindicatedVaccineCode(List<CodeableConcept> contraindicatedVaccineCode) {
                this.contraindicatedVaccineCode = contraindicatedVaccineCode == null
                        ? new ArrayList<>()
                        : new ArrayList<>(contraindicatedVaccineCode);
                return this;
            }

            /**
             * Adds a {@code contraindicatedVaccineCode} value.
             *
             * @param contraindicatedVaccineCode the value to add
             * @return this builder
             */
            public Builder addContraindicatedVaccineCode(CodeableConcept contraindicatedVaccineCode) {
                this.contraindicatedVaccineCode.add(
                        Objects.requireNonNull(contraindicatedVaccineCode, "contraindicatedVaccineCode"));
                return this;
            }

            /**
             * Sets {@code forecastStatus}.
             *
             * @param forecastStatus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder forecastStatus(CodeableConcept forecastStatus) {
                this.forecastStatus = forecastStatus;
                return this;
            }

            /**
             * Replaces all {@code forecastReason} values.
             *
             * @param forecastReason the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder forecastReason(List<CodeableConcept> forecastReason) {
                this.forecastReason = forecastReason == null ? new ArrayList<>() : new ArrayList<>(forecastReason);
                return this;
            }

            /**
             * Adds a {@code forecastReason} value.
             *
             * @param forecastReason the value to add
             * @return this builder
             */
            public Builder addForecastReason(CodeableConcept forecastReason) {
                this.forecastReason.add(Objects.requireNonNull(forecastReason, "forecastReason"));
                return this;
            }

            /**
             * Replaces all {@code dateCriterion} values.
             *
             * @param dateCriterion the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder dateCriterion(List<DateCriterion> dateCriterion) {
                this.dateCriterion = dateCriterion == null ? new ArrayList<>() : new ArrayList<>(dateCriterion);
                return this;
            }

            /**
             * Adds a {@code dateCriterion} value.
             *
             * @param dateCriterion the value to add
             * @return this builder
             */
            public Builder addDateCriterion(DateCriterion dateCriterion) {
                this.dateCriterion.add(Objects.requireNonNull(dateCriterion, "dateCriterion"));
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
             * Sets {@code series}.
             *
             * @param series the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder series(FhirString series) {
                this.series = series;
                return this;
            }

            /**
             * Sets {@code series}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param series the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder series(String series) {
                return series(series == null ? null : FhirString.of(series));
            }

            /**
             * Sets {@code doseNumber}.
             *
             * @param doseNumber the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder doseNumber(FhirString doseNumber) {
                this.doseNumber = doseNumber;
                return this;
            }

            /**
             * Sets {@code doseNumber}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param doseNumber the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder doseNumber(String doseNumber) {
                return doseNumber(doseNumber == null ? null : FhirString.of(doseNumber));
            }

            /**
             * Sets {@code seriesDoses}.
             *
             * @param seriesDoses the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder seriesDoses(FhirString seriesDoses) {
                this.seriesDoses = seriesDoses;
                return this;
            }

            /**
             * Sets {@code seriesDoses}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param seriesDoses the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder seriesDoses(String seriesDoses) {
                return seriesDoses(seriesDoses == null ? null : FhirString.of(seriesDoses));
            }

            /**
             * Replaces all {@code supportingImmunization} values.
             *
             * @param supportingImmunization the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder supportingImmunization(List<Reference> supportingImmunization) {
                this.supportingImmunization = supportingImmunization == null
                        ? new ArrayList<>()
                        : new ArrayList<>(supportingImmunization);
                return this;
            }

            /**
             * Adds a {@code supportingImmunization} value.
             *
             * @param supportingImmunization the value to add
             * @return this builder
             */
            public Builder addSupportingImmunization(Reference supportingImmunization) {
                this.supportingImmunization.add(
                        Objects.requireNonNull(supportingImmunization, "supportingImmunization"));
                return this;
            }

            /**
             * Replaces all {@code supportingPatientInformation} values.
             *
             * @param supportingPatientInformation the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder supportingPatientInformation(List<Reference> supportingPatientInformation) {
                this.supportingPatientInformation = supportingPatientInformation == null
                        ? new ArrayList<>()
                        : new ArrayList<>(supportingPatientInformation);
                return this;
            }

            /**
             * Adds a {@code supportingPatientInformation} value.
             *
             * @param supportingPatientInformation the value to add
             * @return this builder
             */
            public Builder addSupportingPatientInformation(Reference supportingPatientInformation) {
                this.supportingPatientInformation.add(
                        Objects.requireNonNull(supportingPatientInformation, "supportingPatientInformation"));
                return this;
            }

            /**
             * Builds the {@code Recommendation}.
             *
             * @return the {@code Recommendation}
             * @throws NullPointerException if a required element is absent
             */
            public Recommendation build() {
                return new Recommendation(
                        id, extension, modifierExtension, vaccineCode, targetDisease, contraindicatedVaccineCode,
                        forecastStatus, forecastReason, dateCriterion, description, series, doseNumber, seriesDoses,
                        supportingImmunization, supportingPatientInformation);
            }
        }
    }

    /** Builder for {@link ImmunizationRecommendation}. Builders are mutable and not thread-safe. */
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
        private Reference patient;
        private FhirDateTime date;
        private Reference authority;
        private List<Recommendation> recommendation = new ArrayList<>();

        private Builder() {
        }

        private Builder(ImmunizationRecommendation original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.patient = original.patient();
            this.date = original.date();
            this.authority = original.authority();
            this.recommendation = new ArrayList<>(original.recommendation());
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
         * Sets {@code authority}.
         *
         * @param authority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authority(Reference authority) {
            this.authority = authority;
            return this;
        }

        /**
         * Replaces all {@code recommendation} values.
         *
         * @param recommendation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder recommendation(List<Recommendation> recommendation) {
            this.recommendation = recommendation == null ? new ArrayList<>() : new ArrayList<>(recommendation);
            return this;
        }

        /**
         * Adds a {@code recommendation} value.
         *
         * @param recommendation the value to add
         * @return this builder
         */
        public Builder addRecommendation(Recommendation recommendation) {
            this.recommendation.add(Objects.requireNonNull(recommendation, "recommendation"));
            return this;
        }

        /**
         * Builds the {@code ImmunizationRecommendation}.
         *
         * @return the {@code ImmunizationRecommendation}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public ImmunizationRecommendation build() {
            return new ImmunizationRecommendation(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    patient, date, authority, recommendation);
        }
    }
}
