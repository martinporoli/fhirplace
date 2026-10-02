package se.poroli.fhirplace.r5.base.management;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.valuesets.EncounterLocationStatus;
import se.poroli.fhirplace.r5.valuesets.EncounterStatus;

/**
 * An interaction between healthcare provider(s), and/or patient(s) for the purpose of providing healthcare service(s)
 * or assessing the health status of patient(s).
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
 * @param identifier Identifier(s) by which this encounter is known.
 * @param status planned | in-progress | on-hold | discharged | completed | cancelled | discontinued |
 *   entered-in-error | unknown. Required. Modifier element.
 * @param classValue Classification of patient encounter context - e.g. Inpatient, outpatient. The FHIR element {@code
 *   class}.
 * @param priority Indicates the urgency of the encounter.
 * @param type Specific type of encounter (e.g. e-mail consultation, surgical day-care, ...).
 * @param serviceType Specific type of service.
 * @param subject The patient or group related to this encounter. Reference to Patient, Group.
 * @param subjectStatus The current status of the subject in relation to the Encounter.
 * @param episodeOfCare Episode(s) of care that this encounter should be recorded against. Reference to EpisodeOfCare.
 * @param basedOn The request that initiated this encounter. Reference to CarePlan, DeviceRequest, MedicationRequest,
 *   ServiceRequest.
 * @param careTeam The group(s) that are allocated to participate in this encounter. Reference to CareTeam.
 * @param partOf Another Encounter this encounter is part of. Reference to Encounter.
 * @param serviceProvider The organization (facility) responsible for this encounter. Reference to Organization.
 * @param participant List of participants involved in the encounter.
 * @param appointment The appointment that scheduled this encounter. Reference to Appointment.
 * @param virtualService Connection details of a virtual service (e.g. conference call).
 * @param actualPeriod The actual start and end time of the encounter.
 * @param plannedStartDate The planned start date/time (or admission date) of the encounter.
 * @param plannedEndDate The planned end date/time (or discharge date) of the encounter.
 * @param length Actual quantity of time the encounter lasted (less time absent).
 * @param reason The list of medical reasons that are expected to be addressed during the episode of care.
 * @param diagnosis The list of diagnosis relevant to this encounter.
 * @param account The set of accounts that may be used for billing for this Encounter. Reference to Account.
 * @param dietPreference Diet preferences reported by the patient.
 * @param specialArrangement Wheelchair, translator, stretcher, etc.
 * @param specialCourtesy Special courtesies (VIP, board member).
 * @param admission Details about the admission to a healthcare service.
 * @param location List of locations where the patient has been.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Encounter">FHIR R5 Encounter</a>
 */
public record Encounter(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<EncounterStatus> status,
        List<CodeableConcept> classValue,
        CodeableConcept priority,
        List<CodeableConcept> type,
        List<CodeableReference> serviceType,
        Reference subject,
        CodeableConcept subjectStatus,
        List<Reference> episodeOfCare,
        List<Reference> basedOn,
        List<Reference> careTeam,
        Reference partOf,
        Reference serviceProvider,
        List<Participant> participant,
        List<Reference> appointment,
        List<VirtualServiceDetail> virtualService,
        Period actualPeriod,
        FhirDateTime plannedStartDate,
        FhirDateTime plannedEndDate,
        Duration length,
        List<Reason> reason,
        List<Diagnosis> diagnosis,
        List<Reference> account,
        List<CodeableConcept> dietPreference,
        List<CodeableConcept> specialArrangement,
        List<CodeableConcept> specialCourtesy,
        Admission admission,
        List<Location> location) implements DomainResource {

    /**
     * Creates an {@code Encounter}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Encounter {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        classValue = classValue == null ? List.of() : List.copyOf(classValue);
        type = type == null ? List.of() : List.copyOf(type);
        serviceType = serviceType == null ? List.of() : List.copyOf(serviceType);
        episodeOfCare = episodeOfCare == null ? List.of() : List.copyOf(episodeOfCare);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        careTeam = careTeam == null ? List.of() : List.copyOf(careTeam);
        participant = participant == null ? List.of() : List.copyOf(participant);
        appointment = appointment == null ? List.of() : List.copyOf(appointment);
        virtualService = virtualService == null ? List.of() : List.copyOf(virtualService);
        reason = reason == null ? List.of() : List.copyOf(reason);
        diagnosis = diagnosis == null ? List.of() : List.copyOf(diagnosis);
        account = account == null ? List.of() : List.copyOf(account);
        dietPreference = dietPreference == null ? List.of() : List.copyOf(dietPreference);
        specialArrangement = specialArrangement == null ? List.of() : List.copyOf(specialArrangement);
        specialCourtesy = specialCourtesy == null ? List.of() : List.copyOf(specialCourtesy);
        location = location == null ? List.of() : List.copyOf(location);
        Objects.requireNonNull(status, "Encounter.status is required");
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
     * Returns a builder initialized with the values of this {@code Encounter}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The list of people responsible for providing the service.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Role of participant in encounter.
     * @param period Period of time during the encounter that the participant participated.
     * @param actor The individual, device, or service participating in the encounter. Reference to Patient, Group,
     *   RelatedPerson, Practitioner, PractitionerRole, Device, HealthcareService.
     */
    public record Participant(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableConcept> type,
            Period period,
            Reference actor) implements BackboneElement {

        /**
         * Creates a {@code Participant}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Participant {
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
         * Returns a builder initialized with the values of this {@code Participant}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Participant}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<CodeableConcept> type = new ArrayList<>();
            private Period period;
            private Reference actor;

            private Builder() {
            }

            private Builder(Participant original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = new ArrayList<>(original.type());
                this.period = original.period();
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
             * Builds the {@code Participant}.
             *
             * @return the {@code Participant}
             */
            public Participant build() {
                return new Participant(
                        id, extension, modifierExtension, type, period, actor);
            }
        }
    }

    /**
     * The list of medical reasons that are expected to be addressed during the episode of care.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param use What the reason value should be used for/as.
     * @param value Reason the encounter takes place (core or reference).
     */
    public record Reason(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableConcept> use,
            List<CodeableReference> value) implements BackboneElement {

        /**
         * Creates a {@code Reason}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Reason {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            use = use == null ? List.of() : List.copyOf(use);
            value = value == null ? List.of() : List.copyOf(value);
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
         * Returns a builder initialized with the values of this {@code Reason}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Reason}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<CodeableConcept> use = new ArrayList<>();
            private List<CodeableReference> value = new ArrayList<>();

            private Builder() {
            }

            private Builder(Reason original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.use = new ArrayList<>(original.use());
                this.value = new ArrayList<>(original.value());
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
             * Replaces all {@code use} values.
             *
             * @param use the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder use(List<CodeableConcept> use) {
                this.use = use == null ? new ArrayList<>() : new ArrayList<>(use);
                return this;
            }

            /**
             * Adds a {@code use} value.
             *
             * @param use the value to add
             * @return this builder
             */
            public Builder addUse(CodeableConcept use) {
                this.use.add(Objects.requireNonNull(use, "use"));
                return this;
            }

            /**
             * Replaces all {@code value} values.
             *
             * @param value the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder value(List<CodeableReference> value) {
                this.value = value == null ? new ArrayList<>() : new ArrayList<>(value);
                return this;
            }

            /**
             * Adds a {@code value} value.
             *
             * @param value the value to add
             * @return this builder
             */
            public Builder addValue(CodeableReference value) {
                this.value.add(Objects.requireNonNull(value, "value"));
                return this;
            }

            /**
             * Builds the {@code Reason}.
             *
             * @return the {@code Reason}
             */
            public Reason build() {
                return new Reason(
                        id, extension, modifierExtension, use, value);
            }
        }
    }

    /**
     * The list of diagnosis relevant to this encounter.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param condition The diagnosis relevant to the encounter.
     * @param use Role that this diagnosis has within the encounter (e.g. admission, billing, discharge …).
     */
    public record Diagnosis(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableReference> condition,
            List<CodeableConcept> use) implements BackboneElement {

        /**
         * Creates a {@code Diagnosis}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Diagnosis {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            condition = condition == null ? List.of() : List.copyOf(condition);
            use = use == null ? List.of() : List.copyOf(use);
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
         * Returns a builder initialized with the values of this {@code Diagnosis}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Diagnosis}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<CodeableReference> condition = new ArrayList<>();
            private List<CodeableConcept> use = new ArrayList<>();

            private Builder() {
            }

            private Builder(Diagnosis original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.condition = new ArrayList<>(original.condition());
                this.use = new ArrayList<>(original.use());
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
             * Replaces all {@code condition} values.
             *
             * @param condition the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder condition(List<CodeableReference> condition) {
                this.condition = condition == null ? new ArrayList<>() : new ArrayList<>(condition);
                return this;
            }

            /**
             * Adds a {@code condition} value.
             *
             * @param condition the value to add
             * @return this builder
             */
            public Builder addCondition(CodeableReference condition) {
                this.condition.add(Objects.requireNonNull(condition, "condition"));
                return this;
            }

            /**
             * Replaces all {@code use} values.
             *
             * @param use the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder use(List<CodeableConcept> use) {
                this.use = use == null ? new ArrayList<>() : new ArrayList<>(use);
                return this;
            }

            /**
             * Adds a {@code use} value.
             *
             * @param use the value to add
             * @return this builder
             */
            public Builder addUse(CodeableConcept use) {
                this.use.add(Objects.requireNonNull(use, "use"));
                return this;
            }

            /**
             * Builds the {@code Diagnosis}.
             *
             * @return the {@code Diagnosis}
             */
            public Diagnosis build() {
                return new Diagnosis(
                        id, extension, modifierExtension, condition, use);
            }
        }
    }

    /**
     * Details about the stay during which a healthcare service is provided.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param preAdmissionIdentifier Pre-admission identifier.
     * @param origin The location/organization from which the patient came before admission. Reference to Location,
     *   Organization.
     * @param admitSource From where patient was admitted (physician referral, transfer).
     * @param reAdmission Indicates that the patient is being re-admitted.
     * @param destination Location/organization to which the patient is discharged. Reference to Location,
     *   Organization.
     * @param dischargeDisposition Category or kind of location after discharge.
     */
    public record Admission(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Identifier preAdmissionIdentifier,
            Reference origin,
            CodeableConcept admitSource,
            CodeableConcept reAdmission,
            Reference destination,
            CodeableConcept dischargeDisposition) implements BackboneElement {

        /**
         * Creates an {@code Admission}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Admission {
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
         * Returns a builder initialized with the values of this {@code Admission}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Admission}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Identifier preAdmissionIdentifier;
            private Reference origin;
            private CodeableConcept admitSource;
            private CodeableConcept reAdmission;
            private Reference destination;
            private CodeableConcept dischargeDisposition;

            private Builder() {
            }

            private Builder(Admission original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.preAdmissionIdentifier = original.preAdmissionIdentifier();
                this.origin = original.origin();
                this.admitSource = original.admitSource();
                this.reAdmission = original.reAdmission();
                this.destination = original.destination();
                this.dischargeDisposition = original.dischargeDisposition();
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
             * Sets {@code preAdmissionIdentifier}.
             *
             * @param preAdmissionIdentifier the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder preAdmissionIdentifier(Identifier preAdmissionIdentifier) {
                this.preAdmissionIdentifier = preAdmissionIdentifier;
                return this;
            }

            /**
             * Sets {@code origin}.
             *
             * @param origin the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder origin(Reference origin) {
                this.origin = origin;
                return this;
            }

            /**
             * Sets {@code admitSource}.
             *
             * @param admitSource the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder admitSource(CodeableConcept admitSource) {
                this.admitSource = admitSource;
                return this;
            }

            /**
             * Sets {@code reAdmission}.
             *
             * @param reAdmission the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reAdmission(CodeableConcept reAdmission) {
                this.reAdmission = reAdmission;
                return this;
            }

            /**
             * Sets {@code destination}.
             *
             * @param destination the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder destination(Reference destination) {
                this.destination = destination;
                return this;
            }

            /**
             * Sets {@code dischargeDisposition}.
             *
             * @param dischargeDisposition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dischargeDisposition(CodeableConcept dischargeDisposition) {
                this.dischargeDisposition = dischargeDisposition;
                return this;
            }

            /**
             * Builds the {@code Admission}.
             *
             * @return the {@code Admission}
             */
            public Admission build() {
                return new Admission(
                        id, extension, modifierExtension, preAdmissionIdentifier, origin, admitSource, reAdmission,
                        destination, dischargeDisposition);
            }
        }
    }

    /**
     * List of locations where the patient has been during this encounter.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param location Location the encounter takes place. Reference to Location. Required.
     * @param status planned | active | reserved | completed.
     * @param form The physical type of the location (usually the level in the location hierarchy - bed, room, ward,
     *   virtual etc.).
     * @param period Time period during which the patient was present at the location.
     */
    public record Location(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference location,
            FhirEnum<EncounterLocationStatus> status,
            CodeableConcept form,
            Period period) implements BackboneElement {

        /**
         * Creates a {@code Location}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Location {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(location, "Encounter.location.location is required");
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
         * Returns a builder initialized with the values of this {@code Location}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Location}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference location;
            private FhirEnum<EncounterLocationStatus> status;
            private CodeableConcept form;
            private Period period;

            private Builder() {
            }

            private Builder(Location original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.location = original.location();
                this.status = original.status();
                this.form = original.form();
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
             * Sets {@code status}.
             *
             * @param status the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder status(FhirEnum<EncounterLocationStatus> status) {
                this.status = status;
                return this;
            }

            /**
             * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param status the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder status(EncounterLocationStatus status) {
                return status(status == null ? null : FhirEnum.of(status));
            }

            /**
             * Sets {@code form}.
             *
             * @param form the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder form(CodeableConcept form) {
                this.form = form;
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
             * Builds the {@code Location}.
             *
             * @return the {@code Location}
             * @throws NullPointerException if a required element is absent
             */
            public Location build() {
                return new Location(
                        id, extension, modifierExtension, location, status, form, period);
            }
        }
    }

    /** Builder for {@link Encounter}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<EncounterStatus> status;
        private List<CodeableConcept> classValue = new ArrayList<>();
        private CodeableConcept priority;
        private List<CodeableConcept> type = new ArrayList<>();
        private List<CodeableReference> serviceType = new ArrayList<>();
        private Reference subject;
        private CodeableConcept subjectStatus;
        private List<Reference> episodeOfCare = new ArrayList<>();
        private List<Reference> basedOn = new ArrayList<>();
        private List<Reference> careTeam = new ArrayList<>();
        private Reference partOf;
        private Reference serviceProvider;
        private List<Participant> participant = new ArrayList<>();
        private List<Reference> appointment = new ArrayList<>();
        private List<VirtualServiceDetail> virtualService = new ArrayList<>();
        private Period actualPeriod;
        private FhirDateTime plannedStartDate;
        private FhirDateTime plannedEndDate;
        private Duration length;
        private List<Reason> reason = new ArrayList<>();
        private List<Diagnosis> diagnosis = new ArrayList<>();
        private List<Reference> account = new ArrayList<>();
        private List<CodeableConcept> dietPreference = new ArrayList<>();
        private List<CodeableConcept> specialArrangement = new ArrayList<>();
        private List<CodeableConcept> specialCourtesy = new ArrayList<>();
        private Admission admission;
        private List<Location> location = new ArrayList<>();

        private Builder() {
        }

        private Builder(Encounter original) {
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
            this.classValue = new ArrayList<>(original.classValue());
            this.priority = original.priority();
            this.type = new ArrayList<>(original.type());
            this.serviceType = new ArrayList<>(original.serviceType());
            this.subject = original.subject();
            this.subjectStatus = original.subjectStatus();
            this.episodeOfCare = new ArrayList<>(original.episodeOfCare());
            this.basedOn = new ArrayList<>(original.basedOn());
            this.careTeam = new ArrayList<>(original.careTeam());
            this.partOf = original.partOf();
            this.serviceProvider = original.serviceProvider();
            this.participant = new ArrayList<>(original.participant());
            this.appointment = new ArrayList<>(original.appointment());
            this.virtualService = new ArrayList<>(original.virtualService());
            this.actualPeriod = original.actualPeriod();
            this.plannedStartDate = original.plannedStartDate();
            this.plannedEndDate = original.plannedEndDate();
            this.length = original.length();
            this.reason = new ArrayList<>(original.reason());
            this.diagnosis = new ArrayList<>(original.diagnosis());
            this.account = new ArrayList<>(original.account());
            this.dietPreference = new ArrayList<>(original.dietPreference());
            this.specialArrangement = new ArrayList<>(original.specialArrangement());
            this.specialCourtesy = new ArrayList<>(original.specialCourtesy());
            this.admission = original.admission();
            this.location = new ArrayList<>(original.location());
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
        public Builder status(FhirEnum<EncounterStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(EncounterStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Replaces all {@code classValue} values.
         *
         * @param classValue the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder classValue(List<CodeableConcept> classValue) {
            this.classValue = classValue == null ? new ArrayList<>() : new ArrayList<>(classValue);
            return this;
        }

        /**
         * Adds a {@code classValue} value.
         *
         * @param classValue the value to add
         * @return this builder
         */
        public Builder addClassValue(CodeableConcept classValue) {
            this.classValue.add(Objects.requireNonNull(classValue, "classValue"));
            return this;
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
         * Replaces all {@code serviceType} values.
         *
         * @param serviceType the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder serviceType(List<CodeableReference> serviceType) {
            this.serviceType = serviceType == null ? new ArrayList<>() : new ArrayList<>(serviceType);
            return this;
        }

        /**
         * Adds a {@code serviceType} value.
         *
         * @param serviceType the value to add
         * @return this builder
         */
        public Builder addServiceType(CodeableReference serviceType) {
            this.serviceType.add(Objects.requireNonNull(serviceType, "serviceType"));
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
         * Sets {@code subjectStatus}.
         *
         * @param subjectStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subjectStatus(CodeableConcept subjectStatus) {
            this.subjectStatus = subjectStatus;
            return this;
        }

        /**
         * Replaces all {@code episodeOfCare} values.
         *
         * @param episodeOfCare the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder episodeOfCare(List<Reference> episodeOfCare) {
            this.episodeOfCare = episodeOfCare == null ? new ArrayList<>() : new ArrayList<>(episodeOfCare);
            return this;
        }

        /**
         * Adds a {@code episodeOfCare} value.
         *
         * @param episodeOfCare the value to add
         * @return this builder
         */
        public Builder addEpisodeOfCare(Reference episodeOfCare) {
            this.episodeOfCare.add(Objects.requireNonNull(episodeOfCare, "episodeOfCare"));
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
         * Replaces all {@code careTeam} values.
         *
         * @param careTeam the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder careTeam(List<Reference> careTeam) {
            this.careTeam = careTeam == null ? new ArrayList<>() : new ArrayList<>(careTeam);
            return this;
        }

        /**
         * Adds a {@code careTeam} value.
         *
         * @param careTeam the value to add
         * @return this builder
         */
        public Builder addCareTeam(Reference careTeam) {
            this.careTeam.add(Objects.requireNonNull(careTeam, "careTeam"));
            return this;
        }

        /**
         * Sets {@code partOf}.
         *
         * @param partOf the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder partOf(Reference partOf) {
            this.partOf = partOf;
            return this;
        }

        /**
         * Sets {@code serviceProvider}.
         *
         * @param serviceProvider the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder serviceProvider(Reference serviceProvider) {
            this.serviceProvider = serviceProvider;
            return this;
        }

        /**
         * Replaces all {@code participant} values.
         *
         * @param participant the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder participant(List<Participant> participant) {
            this.participant = participant == null ? new ArrayList<>() : new ArrayList<>(participant);
            return this;
        }

        /**
         * Adds a {@code participant} value.
         *
         * @param participant the value to add
         * @return this builder
         */
        public Builder addParticipant(Participant participant) {
            this.participant.add(Objects.requireNonNull(participant, "participant"));
            return this;
        }

        /**
         * Replaces all {@code appointment} values.
         *
         * @param appointment the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder appointment(List<Reference> appointment) {
            this.appointment = appointment == null ? new ArrayList<>() : new ArrayList<>(appointment);
            return this;
        }

        /**
         * Adds a {@code appointment} value.
         *
         * @param appointment the value to add
         * @return this builder
         */
        public Builder addAppointment(Reference appointment) {
            this.appointment.add(Objects.requireNonNull(appointment, "appointment"));
            return this;
        }

        /**
         * Replaces all {@code virtualService} values.
         *
         * @param virtualService the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder virtualService(List<VirtualServiceDetail> virtualService) {
            this.virtualService = virtualService == null ? new ArrayList<>() : new ArrayList<>(virtualService);
            return this;
        }

        /**
         * Adds a {@code virtualService} value.
         *
         * @param virtualService the value to add
         * @return this builder
         */
        public Builder addVirtualService(VirtualServiceDetail virtualService) {
            this.virtualService.add(Objects.requireNonNull(virtualService, "virtualService"));
            return this;
        }

        /**
         * Sets {@code actualPeriod}.
         *
         * @param actualPeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder actualPeriod(Period actualPeriod) {
            this.actualPeriod = actualPeriod;
            return this;
        }

        /**
         * Sets {@code plannedStartDate}.
         *
         * @param plannedStartDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder plannedStartDate(FhirDateTime plannedStartDate) {
            this.plannedStartDate = plannedStartDate;
            return this;
        }

        /**
         * Sets {@code plannedStartDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param plannedStartDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder plannedStartDate(Temporal plannedStartDate) {
            return plannedStartDate(plannedStartDate == null ? null : FhirDateTime.of(plannedStartDate));
        }

        /**
         * Sets {@code plannedEndDate}.
         *
         * @param plannedEndDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder plannedEndDate(FhirDateTime plannedEndDate) {
            this.plannedEndDate = plannedEndDate;
            return this;
        }

        /**
         * Sets {@code plannedEndDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param plannedEndDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder plannedEndDate(Temporal plannedEndDate) {
            return plannedEndDate(plannedEndDate == null ? null : FhirDateTime.of(plannedEndDate));
        }

        /**
         * Sets {@code length}.
         *
         * @param length the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder length(Duration length) {
            this.length = length;
            return this;
        }

        /**
         * Replaces all {@code reason} values.
         *
         * @param reason the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reason(List<Reason> reason) {
            this.reason = reason == null ? new ArrayList<>() : new ArrayList<>(reason);
            return this;
        }

        /**
         * Adds a {@code reason} value.
         *
         * @param reason the value to add
         * @return this builder
         */
        public Builder addReason(Reason reason) {
            this.reason.add(Objects.requireNonNull(reason, "reason"));
            return this;
        }

        /**
         * Replaces all {@code diagnosis} values.
         *
         * @param diagnosis the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder diagnosis(List<Diagnosis> diagnosis) {
            this.diagnosis = diagnosis == null ? new ArrayList<>() : new ArrayList<>(diagnosis);
            return this;
        }

        /**
         * Adds a {@code diagnosis} value.
         *
         * @param diagnosis the value to add
         * @return this builder
         */
        public Builder addDiagnosis(Diagnosis diagnosis) {
            this.diagnosis.add(Objects.requireNonNull(diagnosis, "diagnosis"));
            return this;
        }

        /**
         * Replaces all {@code account} values.
         *
         * @param account the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder account(List<Reference> account) {
            this.account = account == null ? new ArrayList<>() : new ArrayList<>(account);
            return this;
        }

        /**
         * Adds a {@code account} value.
         *
         * @param account the value to add
         * @return this builder
         */
        public Builder addAccount(Reference account) {
            this.account.add(Objects.requireNonNull(account, "account"));
            return this;
        }

        /**
         * Replaces all {@code dietPreference} values.
         *
         * @param dietPreference the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder dietPreference(List<CodeableConcept> dietPreference) {
            this.dietPreference = dietPreference == null ? new ArrayList<>() : new ArrayList<>(dietPreference);
            return this;
        }

        /**
         * Adds a {@code dietPreference} value.
         *
         * @param dietPreference the value to add
         * @return this builder
         */
        public Builder addDietPreference(CodeableConcept dietPreference) {
            this.dietPreference.add(Objects.requireNonNull(dietPreference, "dietPreference"));
            return this;
        }

        /**
         * Replaces all {@code specialArrangement} values.
         *
         * @param specialArrangement the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder specialArrangement(List<CodeableConcept> specialArrangement) {
            this.specialArrangement = specialArrangement == null
                    ? new ArrayList<>()
                    : new ArrayList<>(specialArrangement);
            return this;
        }

        /**
         * Adds a {@code specialArrangement} value.
         *
         * @param specialArrangement the value to add
         * @return this builder
         */
        public Builder addSpecialArrangement(CodeableConcept specialArrangement) {
            this.specialArrangement.add(Objects.requireNonNull(specialArrangement, "specialArrangement"));
            return this;
        }

        /**
         * Replaces all {@code specialCourtesy} values.
         *
         * @param specialCourtesy the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder specialCourtesy(List<CodeableConcept> specialCourtesy) {
            this.specialCourtesy = specialCourtesy == null ? new ArrayList<>() : new ArrayList<>(specialCourtesy);
            return this;
        }

        /**
         * Adds a {@code specialCourtesy} value.
         *
         * @param specialCourtesy the value to add
         * @return this builder
         */
        public Builder addSpecialCourtesy(CodeableConcept specialCourtesy) {
            this.specialCourtesy.add(Objects.requireNonNull(specialCourtesy, "specialCourtesy"));
            return this;
        }

        /**
         * Sets {@code admission}.
         *
         * @param admission the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder admission(Admission admission) {
            this.admission = admission;
            return this;
        }

        /**
         * Replaces all {@code location} values.
         *
         * @param location the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder location(List<Location> location) {
            this.location = location == null ? new ArrayList<>() : new ArrayList<>(location);
            return this;
        }

        /**
         * Adds a {@code location} value.
         *
         * @param location the value to add
         * @return this builder
         */
        public Builder addLocation(Location location) {
            this.location.add(Objects.requireNonNull(location, "location"));
            return this;
        }

        /**
         * Builds the {@code Encounter}.
         *
         * @return the {@code Encounter}
         * @throws NullPointerException if a required element is absent
         */
        public Encounter build() {
            return new Encounter(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, classValue, priority, type, serviceType, subject, subjectStatus, episodeOfCare, basedOn,
                    careTeam, partOf, serviceProvider, participant, appointment, virtualService, actualPeriod,
                    plannedStartDate, plannedEndDate, length, reason, diagnosis, account, dietPreference,
                    specialArrangement, specialCourtesy, admission, location);
        }
    }
}
