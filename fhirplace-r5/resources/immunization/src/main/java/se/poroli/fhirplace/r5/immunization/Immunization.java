package se.poroli.fhirplace.r5.immunization;

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
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a
 * patient, a clinician or another party.
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
 * @param basedOn Authority that the immunization event is based on. Reference to CarePlan, MedicationRequest,
 *   ServiceRequest, ImmunizationRecommendation.
 * @param status completed | entered-in-error | not-done. Required. Modifier element.
 * @param statusReason Reason for current status.
 * @param vaccineCode Vaccine administered. Required.
 * @param administeredProduct Product that was administered.
 * @param manufacturer Vaccine manufacturer.
 * @param lotNumber Vaccine lot number.
 * @param expirationDate Vaccine expiration date.
 * @param patient Who was immunized. Reference to Patient. Required.
 * @param encounter Encounter immunization was part of. Reference to Encounter.
 * @param supportingInformation Additional information in support of the immunization. Reference to Resource.
 * @param occurrence Vaccine administration date. One of dateTime, string. Required.
 * @param primarySource Indicates context the data was captured in.
 * @param informationSource Indicates the source of a reported record.
 * @param location Where immunization occurred. Reference to Location.
 * @param site Body site vaccine was administered.
 * @param route How vaccine entered body.
 * @param doseQuantity Amount of vaccine administered.
 * @param performer Who performed event.
 * @param note Additional immunization notes.
 * @param reason Why immunization occurred.
 * @param isSubpotent Dose potency. Modifier element.
 * @param subpotentReason Reason for being subpotent.
 * @param programEligibility Patient eligibility for a specific vaccination program.
 * @param fundingSource Funding source for the vaccine.
 * @param reaction Details of a reaction that follows immunization.
 * @param protocolApplied Protocol followed by the provider.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Immunization">FHIR R5 Immunization</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Immunization(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        List<Reference> basedOn,
        FhirEnum<ImmunizationStatusCodes> status,
        CodeableConcept statusReason,
        CodeableConcept vaccineCode,
        CodeableReference administeredProduct,
        CodeableReference manufacturer,
        FhirString lotNumber,
        FhirDate expirationDate,
        Reference patient,
        Reference encounter,
        List<Reference> supportingInformation,
        DataType occurrence,
        FhirBoolean primarySource,
        CodeableReference informationSource,
        Reference location,
        CodeableConcept site,
        CodeableConcept route,
        Quantity doseQuantity,
        List<Performer> performer,
        List<Annotation> note,
        List<CodeableReference> reason,
        FhirBoolean isSubpotent,
        List<CodeableConcept> subpotentReason,
        List<ProgramEligibility> programEligibility,
        CodeableConcept fundingSource,
        List<Reaction> reaction,
        List<ProtocolApplied> protocolApplied) implements DomainResource {

    /**
     * Creates an {@code Immunization}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Immunization {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        supportingInformation = supportingInformation == null ? List.of() : List.copyOf(supportingInformation);
        performer = performer == null ? List.of() : List.copyOf(performer);
        note = note == null ? List.of() : List.copyOf(note);
        reason = reason == null ? List.of() : List.copyOf(reason);
        subpotentReason = subpotentReason == null ? List.of() : List.copyOf(subpotentReason);
        programEligibility = programEligibility == null ? List.of() : List.copyOf(programEligibility);
        reaction = reaction == null ? List.of() : List.copyOf(reaction);
        protocolApplied = protocolApplied == null ? List.of() : List.copyOf(protocolApplied);
        Objects.requireNonNull(status, "Immunization.status is required");
        Objects.requireNonNull(vaccineCode, "Immunization.vaccineCode is required");
        Objects.requireNonNull(patient, "Immunization.patient is required");
        Objects.requireNonNull(occurrence, "Immunization.occurrence is required");
        if (occurrence != null && !(occurrence instanceof FhirDateTime || occurrence instanceof FhirString)) {
            throw new IllegalArgumentException(
                    "Immunization.occurrence[x] must be one of dateTime, string, but was "
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
     * Returns a builder initialized with the values of this {@code Immunization}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates who performed the immunization event.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function What type of performance was done.
     * @param actor Individual or organization who was performing. Reference to Practitioner, PractitionerRole,
     *   Organization, Patient, RelatedPerson. Required.
     */
    public record Performer(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept function,
            Reference actor) implements BackboneElement {

        /**
         * Creates a {@code Performer}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Performer {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(actor, "Immunization.performer.actor is required");
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
         * Returns a builder initialized with the values of this {@code Performer}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Performer}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept function;
            private Reference actor;

            private Builder() {
            }

            private Builder(Performer original) {
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
             * Builds the {@code Performer}.
             *
             * @return the {@code Performer}
             * @throws NullPointerException if a required element is absent
             */
            public Performer build() {
                return new Performer(
                        id, extension, modifierExtension, function, actor);
            }
        }
    }

    /**
     * Indicates a patient's eligibility for a funding program.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param program The program that eligibility is declared for. Required.
     * @param programStatus The patient's eligibility status for the program. Required.
     */
    public record ProgramEligibility(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept program,
            CodeableConcept programStatus) implements BackboneElement {

        /**
         * Creates a {@code ProgramEligibility}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ProgramEligibility {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(program, "Immunization.programEligibility.program is required");
            Objects.requireNonNull(programStatus, "Immunization.programEligibility.programStatus is required");
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
         * Returns a builder initialized with the values of this {@code ProgramEligibility}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ProgramEligibility}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept program;
            private CodeableConcept programStatus;

            private Builder() {
            }

            private Builder(ProgramEligibility original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.program = original.program();
                this.programStatus = original.programStatus();
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
             * Sets {@code program}.
             *
             * @param program the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder program(CodeableConcept program) {
                this.program = program;
                return this;
            }

            /**
             * Sets {@code programStatus}.
             *
             * @param programStatus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder programStatus(CodeableConcept programStatus) {
                this.programStatus = programStatus;
                return this;
            }

            /**
             * Builds the {@code ProgramEligibility}.
             *
             * @return the {@code ProgramEligibility}
             * @throws NullPointerException if a required element is absent
             */
            public ProgramEligibility build() {
                return new ProgramEligibility(
                        id, extension, modifierExtension, program, programStatus);
            }
        }
    }

    /**
     * Categorical data indicating that an adverse event is associated in time to an immunization.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param date When reaction started.
     * @param manifestation Additional information on reaction.
     * @param reported Indicates self-reported reaction.
     */
    public record Reaction(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirDateTime date,
            CodeableReference manifestation,
            FhirBoolean reported) implements BackboneElement {

        /**
         * Creates a {@code Reaction}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Reaction {
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
         * Returns a builder initialized with the values of this {@code Reaction}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Reaction}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirDateTime date;
            private CodeableReference manifestation;
            private FhirBoolean reported;

            private Builder() {
            }

            private Builder(Reaction original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.date = original.date();
                this.manifestation = original.manifestation();
                this.reported = original.reported();
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
             * Sets {@code manifestation}.
             *
             * @param manifestation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder manifestation(CodeableReference manifestation) {
                this.manifestation = manifestation;
                return this;
            }

            /**
             * Sets {@code reported}.
             *
             * @param reported the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reported(FhirBoolean reported) {
                this.reported = reported;
                return this;
            }

            /**
             * Sets {@code reported}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param reported the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reported(Boolean reported) {
                return reported(reported == null ? null : FhirBoolean.of(reported));
            }

            /**
             * Builds the {@code Reaction}.
             *
             * @return the {@code Reaction}
             */
            public Reaction build() {
                return new Reaction(
                        id, extension, modifierExtension, date, manifestation, reported);
            }
        }
    }

    /**
     * The protocol (set of recommendations) being followed by the provider who administered the dose.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param series Name of vaccine series.
     * @param authority Who is responsible for publishing the recommendations. Reference to Organization.
     * @param targetDisease Vaccine preventatable disease being targeted.
     * @param doseNumber Dose number within series. Required.
     * @param seriesDoses Recommended number of doses for immunity.
     */
    public record ProtocolApplied(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString series,
            Reference authority,
            List<CodeableConcept> targetDisease,
            FhirString doseNumber,
            FhirString seriesDoses) implements BackboneElement {

        /**
         * Creates a {@code ProtocolApplied}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ProtocolApplied {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            targetDisease = targetDisease == null ? List.of() : List.copyOf(targetDisease);
            Objects.requireNonNull(doseNumber, "Immunization.protocolApplied.doseNumber is required");
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
         * Returns a builder initialized with the values of this {@code ProtocolApplied}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ProtocolApplied}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString series;
            private Reference authority;
            private List<CodeableConcept> targetDisease = new ArrayList<>();
            private FhirString doseNumber;
            private FhirString seriesDoses;

            private Builder() {
            }

            private Builder(ProtocolApplied original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.series = original.series();
                this.authority = original.authority();
                this.targetDisease = new ArrayList<>(original.targetDisease());
                this.doseNumber = original.doseNumber();
                this.seriesDoses = original.seriesDoses();
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
             * Builds the {@code ProtocolApplied}.
             *
             * @return the {@code ProtocolApplied}
             * @throws NullPointerException if a required element is absent
             */
            public ProtocolApplied build() {
                return new ProtocolApplied(
                        id, extension, modifierExtension, series, authority, targetDisease, doseNumber, seriesDoses);
            }
        }
    }

    /** Builder for {@link Immunization}. Builders are mutable and not thread-safe. */
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
        private List<Reference> basedOn = new ArrayList<>();
        private FhirEnum<ImmunizationStatusCodes> status;
        private CodeableConcept statusReason;
        private CodeableConcept vaccineCode;
        private CodeableReference administeredProduct;
        private CodeableReference manufacturer;
        private FhirString lotNumber;
        private FhirDate expirationDate;
        private Reference patient;
        private Reference encounter;
        private List<Reference> supportingInformation = new ArrayList<>();
        private DataType occurrence;
        private FhirBoolean primarySource;
        private CodeableReference informationSource;
        private Reference location;
        private CodeableConcept site;
        private CodeableConcept route;
        private Quantity doseQuantity;
        private List<Performer> performer = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<CodeableReference> reason = new ArrayList<>();
        private FhirBoolean isSubpotent;
        private List<CodeableConcept> subpotentReason = new ArrayList<>();
        private List<ProgramEligibility> programEligibility = new ArrayList<>();
        private CodeableConcept fundingSource;
        private List<Reaction> reaction = new ArrayList<>();
        private List<ProtocolApplied> protocolApplied = new ArrayList<>();

        private Builder() {
        }

        private Builder(Immunization original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.basedOn = new ArrayList<>(original.basedOn());
            this.status = original.status();
            this.statusReason = original.statusReason();
            this.vaccineCode = original.vaccineCode();
            this.administeredProduct = original.administeredProduct();
            this.manufacturer = original.manufacturer();
            this.lotNumber = original.lotNumber();
            this.expirationDate = original.expirationDate();
            this.patient = original.patient();
            this.encounter = original.encounter();
            this.supportingInformation = new ArrayList<>(original.supportingInformation());
            this.occurrence = original.occurrence();
            this.primarySource = original.primarySource();
            this.informationSource = original.informationSource();
            this.location = original.location();
            this.site = original.site();
            this.route = original.route();
            this.doseQuantity = original.doseQuantity();
            this.performer = new ArrayList<>(original.performer());
            this.note = new ArrayList<>(original.note());
            this.reason = new ArrayList<>(original.reason());
            this.isSubpotent = original.isSubpotent();
            this.subpotentReason = new ArrayList<>(original.subpotentReason());
            this.programEligibility = new ArrayList<>(original.programEligibility());
            this.fundingSource = original.fundingSource();
            this.reaction = new ArrayList<>(original.reaction());
            this.protocolApplied = new ArrayList<>(original.protocolApplied());
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
         * Replaces all {@code basedOn} values.
         *
         * @param basedOn the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder basedOn(List<Reference> basedOn) {
            this.basedOn = basedOn == null ? new ArrayList<>() : new ArrayList<>(basedOn);
            return this;
        }

        /**
         * Adds a {@code basedOn} value.
         *
         * @param basedOn the value to add
         * @return this builder
         */
        public Builder addBasedOn(Reference basedOn) {
            this.basedOn.add(Objects.requireNonNull(basedOn, "basedOn"));
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<ImmunizationStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(ImmunizationStatusCodes status) {
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
         * Sets {@code vaccineCode}.
         *
         * @param vaccineCode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder vaccineCode(CodeableConcept vaccineCode) {
            this.vaccineCode = vaccineCode;
            return this;
        }

        /**
         * Sets {@code administeredProduct}.
         *
         * @param administeredProduct the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder administeredProduct(CodeableReference administeredProduct) {
            this.administeredProduct = administeredProduct;
            return this;
        }

        /**
         * Sets {@code manufacturer}.
         *
         * @param manufacturer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder manufacturer(CodeableReference manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        /**
         * Sets {@code lotNumber}.
         *
         * @param lotNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lotNumber(FhirString lotNumber) {
            this.lotNumber = lotNumber;
            return this;
        }

        /**
         * Sets {@code lotNumber}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param lotNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lotNumber(String lotNumber) {
            return lotNumber(lotNumber == null ? null : FhirString.of(lotNumber));
        }

        /**
         * Sets {@code expirationDate}.
         *
         * @param expirationDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expirationDate(FhirDate expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        /**
         * Sets {@code expirationDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param expirationDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expirationDate(Temporal expirationDate) {
            return expirationDate(expirationDate == null ? null : FhirDate.of(expirationDate));
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
         * Replaces all {@code supportingInformation} values.
         *
         * @param supportingInformation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supportingInformation(List<Reference> supportingInformation) {
            this.supportingInformation = supportingInformation == null
                    ? new ArrayList<>()
                    : new ArrayList<>(supportingInformation);
            return this;
        }

        /**
         * Adds a {@code supportingInformation} value.
         *
         * @param supportingInformation the value to add
         * @return this builder
         */
        public Builder addSupportingInformation(Reference supportingInformation) {
            this.supportingInformation.add(Objects.requireNonNull(supportingInformation, "supportingInformation"));
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
         * Sets {@code occurrence} to a string.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(FhirString occurrence) {
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
         * Sets {@code occurrence} to a string without id or extensions.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(String occurrence) {
            this.occurrence = occurrence == null ? null : FhirString.of(occurrence);
            return this;
        }

        /**
         * Sets {@code primarySource}.
         *
         * @param primarySource the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder primarySource(FhirBoolean primarySource) {
            this.primarySource = primarySource;
            return this;
        }

        /**
         * Sets {@code primarySource}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param primarySource the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder primarySource(Boolean primarySource) {
            return primarySource(primarySource == null ? null : FhirBoolean.of(primarySource));
        }

        /**
         * Sets {@code informationSource}.
         *
         * @param informationSource the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder informationSource(CodeableReference informationSource) {
            this.informationSource = informationSource;
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
         * Sets {@code site}.
         *
         * @param site the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder site(CodeableConcept site) {
            this.site = site;
            return this;
        }

        /**
         * Sets {@code route}.
         *
         * @param route the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder route(CodeableConcept route) {
            this.route = route;
            return this;
        }

        /**
         * Sets {@code doseQuantity}.
         *
         * @param doseQuantity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder doseQuantity(Quantity doseQuantity) {
            this.doseQuantity = doseQuantity;
            return this;
        }

        /**
         * Replaces all {@code performer} values.
         *
         * @param performer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder performer(List<Performer> performer) {
            this.performer = performer == null ? new ArrayList<>() : new ArrayList<>(performer);
            return this;
        }

        /**
         * Adds a {@code performer} value.
         *
         * @param performer the value to add
         * @return this builder
         */
        public Builder addPerformer(Performer performer) {
            this.performer.add(Objects.requireNonNull(performer, "performer"));
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
         * Sets {@code isSubpotent}.
         *
         * @param isSubpotent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder isSubpotent(FhirBoolean isSubpotent) {
            this.isSubpotent = isSubpotent;
            return this;
        }

        /**
         * Sets {@code isSubpotent}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param isSubpotent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder isSubpotent(Boolean isSubpotent) {
            return isSubpotent(isSubpotent == null ? null : FhirBoolean.of(isSubpotent));
        }

        /**
         * Replaces all {@code subpotentReason} values.
         *
         * @param subpotentReason the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder subpotentReason(List<CodeableConcept> subpotentReason) {
            this.subpotentReason = subpotentReason == null ? new ArrayList<>() : new ArrayList<>(subpotentReason);
            return this;
        }

        /**
         * Adds a {@code subpotentReason} value.
         *
         * @param subpotentReason the value to add
         * @return this builder
         */
        public Builder addSubpotentReason(CodeableConcept subpotentReason) {
            this.subpotentReason.add(Objects.requireNonNull(subpotentReason, "subpotentReason"));
            return this;
        }

        /**
         * Replaces all {@code programEligibility} values.
         *
         * @param programEligibility the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder programEligibility(List<ProgramEligibility> programEligibility) {
            this.programEligibility = programEligibility == null
                    ? new ArrayList<>()
                    : new ArrayList<>(programEligibility);
            return this;
        }

        /**
         * Adds a {@code programEligibility} value.
         *
         * @param programEligibility the value to add
         * @return this builder
         */
        public Builder addProgramEligibility(ProgramEligibility programEligibility) {
            this.programEligibility.add(Objects.requireNonNull(programEligibility, "programEligibility"));
            return this;
        }

        /**
         * Sets {@code fundingSource}.
         *
         * @param fundingSource the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder fundingSource(CodeableConcept fundingSource) {
            this.fundingSource = fundingSource;
            return this;
        }

        /**
         * Replaces all {@code reaction} values.
         *
         * @param reaction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reaction(List<Reaction> reaction) {
            this.reaction = reaction == null ? new ArrayList<>() : new ArrayList<>(reaction);
            return this;
        }

        /**
         * Adds a {@code reaction} value.
         *
         * @param reaction the value to add
         * @return this builder
         */
        public Builder addReaction(Reaction reaction) {
            this.reaction.add(Objects.requireNonNull(reaction, "reaction"));
            return this;
        }

        /**
         * Replaces all {@code protocolApplied} values.
         *
         * @param protocolApplied the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder protocolApplied(List<ProtocolApplied> protocolApplied) {
            this.protocolApplied = protocolApplied == null ? new ArrayList<>() : new ArrayList<>(protocolApplied);
            return this;
        }

        /**
         * Adds a {@code protocolApplied} value.
         *
         * @param protocolApplied the value to add
         * @return this builder
         */
        public Builder addProtocolApplied(ProtocolApplied protocolApplied) {
            this.protocolApplied.add(Objects.requireNonNull(protocolApplied, "protocolApplied"));
            return this;
        }

        /**
         * Builds the {@code Immunization}.
         *
         * @return the {@code Immunization}
         * @throws NullPointerException if a required element is absent
         */
        public Immunization build() {
            return new Immunization(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    basedOn, status, statusReason, vaccineCode, administeredProduct, manufacturer, lotNumber,
                    expirationDate, patient, encounter, supportingInformation, occurrence, primarySource,
                    informationSource, location, site, route, doseQuantity, performer, note, reason, isSubpotent,
                    subpotentReason, programEligibility, fundingSource, reaction, protocolApplied);
        }
    }
}
