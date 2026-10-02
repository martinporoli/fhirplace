package se.poroli.fhirplace.r5.base.workflow;

import java.time.OffsetDateTime;
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
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.valuesets.AppointmentStatus;
import se.poroli.fhirplace.r5.valuesets.ParticipationStatus;

/**
 * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a
 * specific date/time.
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
 * @param identifier External Ids for this item.
 * @param status proposed | pending | booked | arrived | fulfilled | cancelled | noshow | entered-in-error |
 *   checked-in | waitlist. Required. Modifier element.
 * @param cancellationReason The coded reason for the appointment being cancelled.
 * @param classValue Classification when becoming an encounter. The FHIR element {@code class}.
 * @param serviceCategory A broad categorization of the service that is to be performed during this appointment.
 * @param serviceType The specific service that is to be performed during this appointment.
 * @param specialty The specialty of a practitioner that would be required to perform the service requested in this
 *   appointment.
 * @param appointmentType The style of appointment or patient that has been booked in the slot (not service type).
 * @param reason Reason this appointment is scheduled.
 * @param priority Used to make informed decisions if needing to re-prioritize.
 * @param description Shown on a subject line in a meeting request, or appointment list.
 * @param replaces Appointment replaced by this Appointment. Reference to Appointment.
 * @param virtualService Connection details of a virtual service (e.g. conference call).
 * @param supportingInformation Additional information to support the appointment. Reference to Resource.
 * @param previousAppointment The previous appointment in a series. Reference to Appointment.
 * @param originatingAppointment The originating appointment in a recurring set of appointments. Reference to
 *   Appointment.
 * @param start When appointment is to take place.
 * @param end When appointment is to conclude.
 * @param minutesDuration Can be less than start/end (e.g. estimate).
 * @param requestedPeriod Potential date/time interval(s) requested to allocate the appointment within.
 * @param slot The slots that this appointment is filling. Reference to Slot.
 * @param account The set of accounts that may be used for billing for this Appointment. Reference to Account.
 * @param created The date that this appointment was initially created.
 * @param cancellationDate When the appointment was cancelled.
 * @param note Additional comments.
 * @param patientInstruction Detailed information and instructions for the patient.
 * @param basedOn The request this appointment is allocated to assess. Reference to CarePlan, DeviceRequest,
 *   MedicationRequest, ServiceRequest.
 * @param subject The patient or group associated with the appointment. Reference to Patient, Group.
 * @param participant Participants involved in appointment. Required.
 * @param recurrenceId The sequence number in the recurrence.
 * @param occurrenceChanged Indicates that this appointment varies from a recurrence pattern.
 * @param recurrenceTemplate Details of the recurrence pattern/template used to generate occurrences.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Appointment">FHIR R5 Appointment</a>
 */
public record Appointment(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<AppointmentStatus> status,
        CodeableConcept cancellationReason,
        List<CodeableConcept> classValue,
        List<CodeableConcept> serviceCategory,
        List<CodeableReference> serviceType,
        List<CodeableConcept> specialty,
        CodeableConcept appointmentType,
        List<CodeableReference> reason,
        CodeableConcept priority,
        FhirString description,
        List<Reference> replaces,
        List<VirtualServiceDetail> virtualService,
        List<Reference> supportingInformation,
        Reference previousAppointment,
        Reference originatingAppointment,
        FhirInstant start,
        FhirInstant end,
        FhirPositiveInt minutesDuration,
        List<Period> requestedPeriod,
        List<Reference> slot,
        List<Reference> account,
        FhirDateTime created,
        FhirDateTime cancellationDate,
        List<Annotation> note,
        List<CodeableReference> patientInstruction,
        List<Reference> basedOn,
        Reference subject,
        List<Participant> participant,
        FhirPositiveInt recurrenceId,
        FhirBoolean occurrenceChanged,
        List<RecurrenceTemplate> recurrenceTemplate) implements DomainResource {

    /**
     * Creates an {@code Appointment}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a required list is empty
     */
    public Appointment {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        classValue = classValue == null ? List.of() : List.copyOf(classValue);
        serviceCategory = serviceCategory == null ? List.of() : List.copyOf(serviceCategory);
        serviceType = serviceType == null ? List.of() : List.copyOf(serviceType);
        specialty = specialty == null ? List.of() : List.copyOf(specialty);
        reason = reason == null ? List.of() : List.copyOf(reason);
        replaces = replaces == null ? List.of() : List.copyOf(replaces);
        virtualService = virtualService == null ? List.of() : List.copyOf(virtualService);
        supportingInformation = supportingInformation == null ? List.of() : List.copyOf(supportingInformation);
        requestedPeriod = requestedPeriod == null ? List.of() : List.copyOf(requestedPeriod);
        slot = slot == null ? List.of() : List.copyOf(slot);
        account = account == null ? List.of() : List.copyOf(account);
        note = note == null ? List.of() : List.copyOf(note);
        patientInstruction = patientInstruction == null ? List.of() : List.copyOf(patientInstruction);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        participant = participant == null ? List.of() : List.copyOf(participant);
        recurrenceTemplate = recurrenceTemplate == null ? List.of() : List.copyOf(recurrenceTemplate);
        Objects.requireNonNull(status, "Appointment.status is required");
        if (participant.isEmpty()) {
            throw new IllegalArgumentException("Appointment.participant requires at least one value");
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
     * Returns a builder initialized with the values of this {@code Appointment}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * List of participants involved in the appointment.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Role of participant in the appointment.
     * @param period Participation period of the actor.
     * @param actor The individual, device, location, or service participating in the appointment. Reference to
     *   Patient, Group, Practitioner, PractitionerRole, CareTeam, RelatedPerson, Device, HealthcareService, Location.
     * @param required The participant is required to attend (optional when false).
     * @param status accepted | declined | tentative | needs-action. Required.
     */
    public record Participant(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableConcept> type,
            Period period,
            Reference actor,
            FhirBoolean required,
            FhirEnum<ParticipationStatus> status) implements BackboneElement {

        /**
         * Creates a {@code Participant}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Participant {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            type = type == null ? List.of() : List.copyOf(type);
            Objects.requireNonNull(status, "Appointment.participant.status is required");
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
            private FhirBoolean required;
            private FhirEnum<ParticipationStatus> status;

            private Builder() {
            }

            private Builder(Participant original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = new ArrayList<>(original.type());
                this.period = original.period();
                this.actor = original.actor();
                this.required = original.required();
                this.status = original.status();
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
             * Sets {@code required}.
             *
             * @param required the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder required(FhirBoolean required) {
                this.required = required;
                return this;
            }

            /**
             * Sets {@code required}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param required the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder required(Boolean required) {
                return required(required == null ? null : FhirBoolean.of(required));
            }

            /**
             * Sets {@code status}.
             *
             * @param status the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder status(FhirEnum<ParticipationStatus> status) {
                this.status = status;
                return this;
            }

            /**
             * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param status the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder status(ParticipationStatus status) {
                return status(status == null ? null : FhirEnum.of(status));
            }

            /**
             * Builds the {@code Participant}.
             *
             * @return the {@code Participant}
             * @throws NullPointerException if a required element is absent
             */
            public Participant build() {
                return new Participant(
                        id, extension, modifierExtension, type, period, actor, required, status);
            }
        }
    }

    /**
     * The details of the recurrence pattern or template that is used to generate recurring appointments.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param timezone The timezone of the occurrences.
     * @param recurrenceType The frequency of the recurrence. Required.
     * @param lastOccurrenceDate The date when the recurrence should end.
     * @param occurrenceCount The number of planned occurrences.
     * @param occurrenceDate Specific dates for a recurring set of appointments (no template).
     * @param weeklyTemplate Information about weekly recurring appointments.
     * @param monthlyTemplate Information about monthly recurring appointments.
     * @param yearlyTemplate Information about yearly recurring appointments.
     * @param excludingDate Any dates that should be excluded from the series.
     * @param excludingRecurrenceId Any recurrence IDs that should be excluded from the recurrence.
     */
    public record RecurrenceTemplate(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept timezone,
            CodeableConcept recurrenceType,
            FhirDate lastOccurrenceDate,
            FhirPositiveInt occurrenceCount,
            List<FhirDate> occurrenceDate,
            WeeklyTemplate weeklyTemplate,
            MonthlyTemplate monthlyTemplate,
            YearlyTemplate yearlyTemplate,
            List<FhirDate> excludingDate,
            List<FhirPositiveInt> excludingRecurrenceId) implements BackboneElement {

        /**
         * Creates a {@code RecurrenceTemplate}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public RecurrenceTemplate {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            occurrenceDate = occurrenceDate == null ? List.of() : List.copyOf(occurrenceDate);
            excludingDate = excludingDate == null ? List.of() : List.copyOf(excludingDate);
            excludingRecurrenceId = excludingRecurrenceId == null ? List.of() : List.copyOf(excludingRecurrenceId);
            Objects.requireNonNull(recurrenceType, "Appointment.recurrenceTemplate.recurrenceType is required");
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
         * Returns a builder initialized with the values of this {@code RecurrenceTemplate}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Information about weekly recurring appointments.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param monday Recurs on Mondays.
         * @param tuesday Recurs on Tuesday.
         * @param wednesday Recurs on Wednesday.
         * @param thursday Recurs on Thursday.
         * @param friday Recurs on Friday.
         * @param saturday Recurs on Saturday.
         * @param sunday Recurs on Sunday.
         * @param weekInterval Recurs every nth week.
         */
        public record WeeklyTemplate(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirBoolean monday,
                FhirBoolean tuesday,
                FhirBoolean wednesday,
                FhirBoolean thursday,
                FhirBoolean friday,
                FhirBoolean saturday,
                FhirBoolean sunday,
                FhirPositiveInt weekInterval) implements BackboneElement {

            /**
             * Creates a {@code WeeklyTemplate}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public WeeklyTemplate {
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
             * Returns a builder initialized with the values of this {@code WeeklyTemplate}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link WeeklyTemplate}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirBoolean monday;
                private FhirBoolean tuesday;
                private FhirBoolean wednesday;
                private FhirBoolean thursday;
                private FhirBoolean friday;
                private FhirBoolean saturday;
                private FhirBoolean sunday;
                private FhirPositiveInt weekInterval;

                private Builder() {
                }

                private Builder(WeeklyTemplate original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.monday = original.monday();
                    this.tuesday = original.tuesday();
                    this.wednesday = original.wednesday();
                    this.thursday = original.thursday();
                    this.friday = original.friday();
                    this.saturday = original.saturday();
                    this.sunday = original.sunday();
                    this.weekInterval = original.weekInterval();
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
                 * Sets {@code monday}.
                 *
                 * @param monday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder monday(FhirBoolean monday) {
                    this.monday = monday;
                    return this;
                }

                /**
                 * Sets {@code monday}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param monday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder monday(Boolean monday) {
                    return monday(monday == null ? null : FhirBoolean.of(monday));
                }

                /**
                 * Sets {@code tuesday}.
                 *
                 * @param tuesday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder tuesday(FhirBoolean tuesday) {
                    this.tuesday = tuesday;
                    return this;
                }

                /**
                 * Sets {@code tuesday}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param tuesday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder tuesday(Boolean tuesday) {
                    return tuesday(tuesday == null ? null : FhirBoolean.of(tuesday));
                }

                /**
                 * Sets {@code wednesday}.
                 *
                 * @param wednesday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder wednesday(FhirBoolean wednesday) {
                    this.wednesday = wednesday;
                    return this;
                }

                /**
                 * Sets {@code wednesday}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param wednesday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder wednesday(Boolean wednesday) {
                    return wednesday(wednesday == null ? null : FhirBoolean.of(wednesday));
                }

                /**
                 * Sets {@code thursday}.
                 *
                 * @param thursday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder thursday(FhirBoolean thursday) {
                    this.thursday = thursday;
                    return this;
                }

                /**
                 * Sets {@code thursday}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param thursday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder thursday(Boolean thursday) {
                    return thursday(thursday == null ? null : FhirBoolean.of(thursday));
                }

                /**
                 * Sets {@code friday}.
                 *
                 * @param friday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder friday(FhirBoolean friday) {
                    this.friday = friday;
                    return this;
                }

                /**
                 * Sets {@code friday}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param friday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder friday(Boolean friday) {
                    return friday(friday == null ? null : FhirBoolean.of(friday));
                }

                /**
                 * Sets {@code saturday}.
                 *
                 * @param saturday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder saturday(FhirBoolean saturday) {
                    this.saturday = saturday;
                    return this;
                }

                /**
                 * Sets {@code saturday}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param saturday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder saturday(Boolean saturday) {
                    return saturday(saturday == null ? null : FhirBoolean.of(saturday));
                }

                /**
                 * Sets {@code sunday}.
                 *
                 * @param sunday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder sunday(FhirBoolean sunday) {
                    this.sunday = sunday;
                    return this;
                }

                /**
                 * Sets {@code sunday}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param sunday the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder sunday(Boolean sunday) {
                    return sunday(sunday == null ? null : FhirBoolean.of(sunday));
                }

                /**
                 * Sets {@code weekInterval}.
                 *
                 * @param weekInterval the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder weekInterval(FhirPositiveInt weekInterval) {
                    this.weekInterval = weekInterval;
                    return this;
                }

                /**
                 * Sets {@code weekInterval}, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param weekInterval the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder weekInterval(Integer weekInterval) {
                    return weekInterval(weekInterval == null ? null : FhirPositiveInt.of(weekInterval));
                }

                /**
                 * Builds the {@code WeeklyTemplate}.
                 *
                 * @return the {@code WeeklyTemplate}
                 */
                public WeeklyTemplate build() {
                    return new WeeklyTemplate(
                            id, extension, modifierExtension, monday, tuesday, wednesday, thursday, friday, saturday,
                            sunday, weekInterval);
                }
            }
        }

        /**
         * Information about monthly recurring appointments.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param dayOfMonth Recurs on a specific day of the month.
         * @param nthWeekOfMonth Indicates which week of the month the appointment should occur.
         * @param dayOfWeek Indicates which day of the week the appointment should occur.
         * @param monthInterval Recurs every nth month. Required.
         */
        public record MonthlyTemplate(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirPositiveInt dayOfMonth,
                Coding nthWeekOfMonth,
                Coding dayOfWeek,
                FhirPositiveInt monthInterval) implements BackboneElement {

            /**
             * Creates a {@code MonthlyTemplate}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public MonthlyTemplate {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(
                        monthInterval, "Appointment.recurrenceTemplate.monthlyTemplate.monthInterval is required");
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
             * Returns a builder initialized with the values of this {@code MonthlyTemplate}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link MonthlyTemplate}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirPositiveInt dayOfMonth;
                private Coding nthWeekOfMonth;
                private Coding dayOfWeek;
                private FhirPositiveInt monthInterval;

                private Builder() {
                }

                private Builder(MonthlyTemplate original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.dayOfMonth = original.dayOfMonth();
                    this.nthWeekOfMonth = original.nthWeekOfMonth();
                    this.dayOfWeek = original.dayOfWeek();
                    this.monthInterval = original.monthInterval();
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
                 * Sets {@code dayOfMonth}.
                 *
                 * @param dayOfMonth the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder dayOfMonth(FhirPositiveInt dayOfMonth) {
                    this.dayOfMonth = dayOfMonth;
                    return this;
                }

                /**
                 * Sets {@code dayOfMonth}, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param dayOfMonth the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder dayOfMonth(Integer dayOfMonth) {
                    return dayOfMonth(dayOfMonth == null ? null : FhirPositiveInt.of(dayOfMonth));
                }

                /**
                 * Sets {@code nthWeekOfMonth}.
                 *
                 * @param nthWeekOfMonth the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder nthWeekOfMonth(Coding nthWeekOfMonth) {
                    this.nthWeekOfMonth = nthWeekOfMonth;
                    return this;
                }

                /**
                 * Sets {@code dayOfWeek}.
                 *
                 * @param dayOfWeek the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder dayOfWeek(Coding dayOfWeek) {
                    this.dayOfWeek = dayOfWeek;
                    return this;
                }

                /**
                 * Sets {@code monthInterval}.
                 *
                 * @param monthInterval the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder monthInterval(FhirPositiveInt monthInterval) {
                    this.monthInterval = monthInterval;
                    return this;
                }

                /**
                 * Sets {@code monthInterval}, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param monthInterval the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder monthInterval(Integer monthInterval) {
                    return monthInterval(monthInterval == null ? null : FhirPositiveInt.of(monthInterval));
                }

                /**
                 * Builds the {@code MonthlyTemplate}.
                 *
                 * @return the {@code MonthlyTemplate}
                 * @throws NullPointerException if a required element is absent
                 */
                public MonthlyTemplate build() {
                    return new MonthlyTemplate(
                            id, extension, modifierExtension, dayOfMonth, nthWeekOfMonth, dayOfWeek, monthInterval);
                }
            }
        }

        /**
         * Information about yearly recurring appointments.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param yearInterval Recurs every nth year. Required.
         */
        public record YearlyTemplate(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirPositiveInt yearInterval) implements BackboneElement {

            /**
             * Creates a {@code YearlyTemplate}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public YearlyTemplate {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(
                        yearInterval, "Appointment.recurrenceTemplate.yearlyTemplate.yearInterval is required");
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
             * Returns a builder initialized with the values of this {@code YearlyTemplate}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link YearlyTemplate}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirPositiveInt yearInterval;

                private Builder() {
                }

                private Builder(YearlyTemplate original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.yearInterval = original.yearInterval();
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
                 * Sets {@code yearInterval}.
                 *
                 * @param yearInterval the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder yearInterval(FhirPositiveInt yearInterval) {
                    this.yearInterval = yearInterval;
                    return this;
                }

                /**
                 * Sets {@code yearInterval}, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param yearInterval the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder yearInterval(Integer yearInterval) {
                    return yearInterval(yearInterval == null ? null : FhirPositiveInt.of(yearInterval));
                }

                /**
                 * Builds the {@code YearlyTemplate}.
                 *
                 * @return the {@code YearlyTemplate}
                 * @throws NullPointerException if a required element is absent
                 */
                public YearlyTemplate build() {
                    return new YearlyTemplate(
                            id, extension, modifierExtension, yearInterval);
                }
            }
        }

        /** Builder for {@link RecurrenceTemplate}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept timezone;
            private CodeableConcept recurrenceType;
            private FhirDate lastOccurrenceDate;
            private FhirPositiveInt occurrenceCount;
            private List<FhirDate> occurrenceDate = new ArrayList<>();
            private WeeklyTemplate weeklyTemplate;
            private MonthlyTemplate monthlyTemplate;
            private YearlyTemplate yearlyTemplate;
            private List<FhirDate> excludingDate = new ArrayList<>();
            private List<FhirPositiveInt> excludingRecurrenceId = new ArrayList<>();

            private Builder() {
            }

            private Builder(RecurrenceTemplate original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.timezone = original.timezone();
                this.recurrenceType = original.recurrenceType();
                this.lastOccurrenceDate = original.lastOccurrenceDate();
                this.occurrenceCount = original.occurrenceCount();
                this.occurrenceDate = new ArrayList<>(original.occurrenceDate());
                this.weeklyTemplate = original.weeklyTemplate();
                this.monthlyTemplate = original.monthlyTemplate();
                this.yearlyTemplate = original.yearlyTemplate();
                this.excludingDate = new ArrayList<>(original.excludingDate());
                this.excludingRecurrenceId = new ArrayList<>(original.excludingRecurrenceId());
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
             * Sets {@code timezone}.
             *
             * @param timezone the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder timezone(CodeableConcept timezone) {
                this.timezone = timezone;
                return this;
            }

            /**
             * Sets {@code recurrenceType}.
             *
             * @param recurrenceType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder recurrenceType(CodeableConcept recurrenceType) {
                this.recurrenceType = recurrenceType;
                return this;
            }

            /**
             * Sets {@code lastOccurrenceDate}.
             *
             * @param lastOccurrenceDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder lastOccurrenceDate(FhirDate lastOccurrenceDate) {
                this.lastOccurrenceDate = lastOccurrenceDate;
                return this;
            }

            /**
             * Sets {@code lastOccurrenceDate}, wrapped in a {@link FhirDate} without id or extensions.
             *
             * @param lastOccurrenceDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder lastOccurrenceDate(Temporal lastOccurrenceDate) {
                return lastOccurrenceDate(lastOccurrenceDate == null ? null : FhirDate.of(lastOccurrenceDate));
            }

            /**
             * Sets {@code occurrenceCount}.
             *
             * @param occurrenceCount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder occurrenceCount(FhirPositiveInt occurrenceCount) {
                this.occurrenceCount = occurrenceCount;
                return this;
            }

            /**
             * Sets {@code occurrenceCount}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param occurrenceCount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder occurrenceCount(Integer occurrenceCount) {
                return occurrenceCount(occurrenceCount == null ? null : FhirPositiveInt.of(occurrenceCount));
            }

            /**
             * Replaces all {@code occurrenceDate} values.
             *
             * @param occurrenceDate the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder occurrenceDate(List<FhirDate> occurrenceDate) {
                this.occurrenceDate = occurrenceDate == null ? new ArrayList<>() : new ArrayList<>(occurrenceDate);
                return this;
            }

            /**
             * Adds a {@code occurrenceDate} value.
             *
             * @param occurrenceDate the value to add
             * @return this builder
             */
            public Builder addOccurrenceDate(FhirDate occurrenceDate) {
                this.occurrenceDate.add(Objects.requireNonNull(occurrenceDate, "occurrenceDate"));
                return this;
            }

            /**
             * Adds a {@code occurrenceDate} value, wrapped in a {@link FhirDate} without id or extensions.
             *
             * @param occurrenceDate the value to add
             * @return this builder
             */
            public Builder addOccurrenceDate(Temporal occurrenceDate) {
                return addOccurrenceDate(FhirDate.of(occurrenceDate));
            }

            /**
             * Sets {@code weeklyTemplate}.
             *
             * @param weeklyTemplate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder weeklyTemplate(WeeklyTemplate weeklyTemplate) {
                this.weeklyTemplate = weeklyTemplate;
                return this;
            }

            /**
             * Sets {@code monthlyTemplate}.
             *
             * @param monthlyTemplate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder monthlyTemplate(MonthlyTemplate monthlyTemplate) {
                this.monthlyTemplate = monthlyTemplate;
                return this;
            }

            /**
             * Sets {@code yearlyTemplate}.
             *
             * @param yearlyTemplate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder yearlyTemplate(YearlyTemplate yearlyTemplate) {
                this.yearlyTemplate = yearlyTemplate;
                return this;
            }

            /**
             * Replaces all {@code excludingDate} values.
             *
             * @param excludingDate the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder excludingDate(List<FhirDate> excludingDate) {
                this.excludingDate = excludingDate == null ? new ArrayList<>() : new ArrayList<>(excludingDate);
                return this;
            }

            /**
             * Adds a {@code excludingDate} value.
             *
             * @param excludingDate the value to add
             * @return this builder
             */
            public Builder addExcludingDate(FhirDate excludingDate) {
                this.excludingDate.add(Objects.requireNonNull(excludingDate, "excludingDate"));
                return this;
            }

            /**
             * Adds a {@code excludingDate} value, wrapped in a {@link FhirDate} without id or extensions.
             *
             * @param excludingDate the value to add
             * @return this builder
             */
            public Builder addExcludingDate(Temporal excludingDate) {
                return addExcludingDate(FhirDate.of(excludingDate));
            }

            /**
             * Replaces all {@code excludingRecurrenceId} values.
             *
             * @param excludingRecurrenceId the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder excludingRecurrenceId(List<FhirPositiveInt> excludingRecurrenceId) {
                this.excludingRecurrenceId = excludingRecurrenceId == null
                        ? new ArrayList<>()
                        : new ArrayList<>(excludingRecurrenceId);
                return this;
            }

            /**
             * Adds a {@code excludingRecurrenceId} value.
             *
             * @param excludingRecurrenceId the value to add
             * @return this builder
             */
            public Builder addExcludingRecurrenceId(FhirPositiveInt excludingRecurrenceId) {
                this.excludingRecurrenceId.add(
                        Objects.requireNonNull(excludingRecurrenceId, "excludingRecurrenceId"));
                return this;
            }

            /**
             * Adds a {@code excludingRecurrenceId} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param excludingRecurrenceId the value to add
             * @return this builder
             */
            public Builder addExcludingRecurrenceId(Integer excludingRecurrenceId) {
                return addExcludingRecurrenceId(FhirPositiveInt.of(excludingRecurrenceId));
            }

            /**
             * Builds the {@code RecurrenceTemplate}.
             *
             * @return the {@code RecurrenceTemplate}
             * @throws NullPointerException if a required element is absent
             */
            public RecurrenceTemplate build() {
                return new RecurrenceTemplate(
                        id, extension, modifierExtension, timezone, recurrenceType, lastOccurrenceDate,
                        occurrenceCount, occurrenceDate, weeklyTemplate, monthlyTemplate, yearlyTemplate,
                        excludingDate, excludingRecurrenceId);
            }
        }
    }

    /** Builder for {@link Appointment}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<AppointmentStatus> status;
        private CodeableConcept cancellationReason;
        private List<CodeableConcept> classValue = new ArrayList<>();
        private List<CodeableConcept> serviceCategory = new ArrayList<>();
        private List<CodeableReference> serviceType = new ArrayList<>();
        private List<CodeableConcept> specialty = new ArrayList<>();
        private CodeableConcept appointmentType;
        private List<CodeableReference> reason = new ArrayList<>();
        private CodeableConcept priority;
        private FhirString description;
        private List<Reference> replaces = new ArrayList<>();
        private List<VirtualServiceDetail> virtualService = new ArrayList<>();
        private List<Reference> supportingInformation = new ArrayList<>();
        private Reference previousAppointment;
        private Reference originatingAppointment;
        private FhirInstant start;
        private FhirInstant end;
        private FhirPositiveInt minutesDuration;
        private List<Period> requestedPeriod = new ArrayList<>();
        private List<Reference> slot = new ArrayList<>();
        private List<Reference> account = new ArrayList<>();
        private FhirDateTime created;
        private FhirDateTime cancellationDate;
        private List<Annotation> note = new ArrayList<>();
        private List<CodeableReference> patientInstruction = new ArrayList<>();
        private List<Reference> basedOn = new ArrayList<>();
        private Reference subject;
        private List<Participant> participant = new ArrayList<>();
        private FhirPositiveInt recurrenceId;
        private FhirBoolean occurrenceChanged;
        private List<RecurrenceTemplate> recurrenceTemplate = new ArrayList<>();

        private Builder() {
        }

        private Builder(Appointment original) {
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
            this.cancellationReason = original.cancellationReason();
            this.classValue = new ArrayList<>(original.classValue());
            this.serviceCategory = new ArrayList<>(original.serviceCategory());
            this.serviceType = new ArrayList<>(original.serviceType());
            this.specialty = new ArrayList<>(original.specialty());
            this.appointmentType = original.appointmentType();
            this.reason = new ArrayList<>(original.reason());
            this.priority = original.priority();
            this.description = original.description();
            this.replaces = new ArrayList<>(original.replaces());
            this.virtualService = new ArrayList<>(original.virtualService());
            this.supportingInformation = new ArrayList<>(original.supportingInformation());
            this.previousAppointment = original.previousAppointment();
            this.originatingAppointment = original.originatingAppointment();
            this.start = original.start();
            this.end = original.end();
            this.minutesDuration = original.minutesDuration();
            this.requestedPeriod = new ArrayList<>(original.requestedPeriod());
            this.slot = new ArrayList<>(original.slot());
            this.account = new ArrayList<>(original.account());
            this.created = original.created();
            this.cancellationDate = original.cancellationDate();
            this.note = new ArrayList<>(original.note());
            this.patientInstruction = new ArrayList<>(original.patientInstruction());
            this.basedOn = new ArrayList<>(original.basedOn());
            this.subject = original.subject();
            this.participant = new ArrayList<>(original.participant());
            this.recurrenceId = original.recurrenceId();
            this.occurrenceChanged = original.occurrenceChanged();
            this.recurrenceTemplate = new ArrayList<>(original.recurrenceTemplate());
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
        public Builder status(FhirEnum<AppointmentStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(AppointmentStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code cancellationReason}.
         *
         * @param cancellationReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder cancellationReason(CodeableConcept cancellationReason) {
            this.cancellationReason = cancellationReason;
            return this;
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
         * Replaces all {@code serviceCategory} values.
         *
         * @param serviceCategory the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder serviceCategory(List<CodeableConcept> serviceCategory) {
            this.serviceCategory = serviceCategory == null ? new ArrayList<>() : new ArrayList<>(serviceCategory);
            return this;
        }

        /**
         * Adds a {@code serviceCategory} value.
         *
         * @param serviceCategory the value to add
         * @return this builder
         */
        public Builder addServiceCategory(CodeableConcept serviceCategory) {
            this.serviceCategory.add(Objects.requireNonNull(serviceCategory, "serviceCategory"));
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
         * Replaces all {@code specialty} values.
         *
         * @param specialty the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder specialty(List<CodeableConcept> specialty) {
            this.specialty = specialty == null ? new ArrayList<>() : new ArrayList<>(specialty);
            return this;
        }

        /**
         * Adds a {@code specialty} value.
         *
         * @param specialty the value to add
         * @return this builder
         */
        public Builder addSpecialty(CodeableConcept specialty) {
            this.specialty.add(Objects.requireNonNull(specialty, "specialty"));
            return this;
        }

        /**
         * Sets {@code appointmentType}.
         *
         * @param appointmentType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder appointmentType(CodeableConcept appointmentType) {
            this.appointmentType = appointmentType;
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
         * Replaces all {@code replaces} values.
         *
         * @param replaces the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder replaces(List<Reference> replaces) {
            this.replaces = replaces == null ? new ArrayList<>() : new ArrayList<>(replaces);
            return this;
        }

        /**
         * Adds a {@code replaces} value.
         *
         * @param replaces the value to add
         * @return this builder
         */
        public Builder addReplaces(Reference replaces) {
            this.replaces.add(Objects.requireNonNull(replaces, "replaces"));
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
         * Sets {@code previousAppointment}.
         *
         * @param previousAppointment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder previousAppointment(Reference previousAppointment) {
            this.previousAppointment = previousAppointment;
            return this;
        }

        /**
         * Sets {@code originatingAppointment}.
         *
         * @param originatingAppointment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder originatingAppointment(Reference originatingAppointment) {
            this.originatingAppointment = originatingAppointment;
            return this;
        }

        /**
         * Sets {@code start}.
         *
         * @param start the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder start(FhirInstant start) {
            this.start = start;
            return this;
        }

        /**
         * Sets {@code start}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param start the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder start(OffsetDateTime start) {
            return start(start == null ? null : FhirInstant.of(start));
        }

        /**
         * Sets {@code end}.
         *
         * @param end the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder end(FhirInstant end) {
            this.end = end;
            return this;
        }

        /**
         * Sets {@code end}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param end the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder end(OffsetDateTime end) {
            return end(end == null ? null : FhirInstant.of(end));
        }

        /**
         * Sets {@code minutesDuration}.
         *
         * @param minutesDuration the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minutesDuration(FhirPositiveInt minutesDuration) {
            this.minutesDuration = minutesDuration;
            return this;
        }

        /**
         * Sets {@code minutesDuration}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param minutesDuration the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minutesDuration(Integer minutesDuration) {
            return minutesDuration(minutesDuration == null ? null : FhirPositiveInt.of(minutesDuration));
        }

        /**
         * Replaces all {@code requestedPeriod} values.
         *
         * @param requestedPeriod the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder requestedPeriod(List<Period> requestedPeriod) {
            this.requestedPeriod = requestedPeriod == null ? new ArrayList<>() : new ArrayList<>(requestedPeriod);
            return this;
        }

        /**
         * Adds a {@code requestedPeriod} value.
         *
         * @param requestedPeriod the value to add
         * @return this builder
         */
        public Builder addRequestedPeriod(Period requestedPeriod) {
            this.requestedPeriod.add(Objects.requireNonNull(requestedPeriod, "requestedPeriod"));
            return this;
        }

        /**
         * Replaces all {@code slot} values.
         *
         * @param slot the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder slot(List<Reference> slot) {
            this.slot = slot == null ? new ArrayList<>() : new ArrayList<>(slot);
            return this;
        }

        /**
         * Adds a {@code slot} value.
         *
         * @param slot the value to add
         * @return this builder
         */
        public Builder addSlot(Reference slot) {
            this.slot.add(Objects.requireNonNull(slot, "slot"));
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
         * Sets {@code created}.
         *
         * @param created the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder created(FhirDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * Sets {@code created}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param created the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder created(Temporal created) {
            return created(created == null ? null : FhirDateTime.of(created));
        }

        /**
         * Sets {@code cancellationDate}.
         *
         * @param cancellationDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder cancellationDate(FhirDateTime cancellationDate) {
            this.cancellationDate = cancellationDate;
            return this;
        }

        /**
         * Sets {@code cancellationDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param cancellationDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder cancellationDate(Temporal cancellationDate) {
            return cancellationDate(cancellationDate == null ? null : FhirDateTime.of(cancellationDate));
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
         * Replaces all {@code patientInstruction} values.
         *
         * @param patientInstruction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder patientInstruction(List<CodeableReference> patientInstruction) {
            this.patientInstruction = patientInstruction == null
                    ? new ArrayList<>()
                    : new ArrayList<>(patientInstruction);
            return this;
        }

        /**
         * Adds a {@code patientInstruction} value.
         *
         * @param patientInstruction the value to add
         * @return this builder
         */
        public Builder addPatientInstruction(CodeableReference patientInstruction) {
            this.patientInstruction.add(Objects.requireNonNull(patientInstruction, "patientInstruction"));
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
         * Sets {@code recurrenceId}.
         *
         * @param recurrenceId the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recurrenceId(FhirPositiveInt recurrenceId) {
            this.recurrenceId = recurrenceId;
            return this;
        }

        /**
         * Sets {@code recurrenceId}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param recurrenceId the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recurrenceId(Integer recurrenceId) {
            return recurrenceId(recurrenceId == null ? null : FhirPositiveInt.of(recurrenceId));
        }

        /**
         * Sets {@code occurrenceChanged}.
         *
         * @param occurrenceChanged the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrenceChanged(FhirBoolean occurrenceChanged) {
            this.occurrenceChanged = occurrenceChanged;
            return this;
        }

        /**
         * Sets {@code occurrenceChanged}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param occurrenceChanged the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrenceChanged(Boolean occurrenceChanged) {
            return occurrenceChanged(occurrenceChanged == null ? null : FhirBoolean.of(occurrenceChanged));
        }

        /**
         * Replaces all {@code recurrenceTemplate} values.
         *
         * @param recurrenceTemplate the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder recurrenceTemplate(List<RecurrenceTemplate> recurrenceTemplate) {
            this.recurrenceTemplate = recurrenceTemplate == null
                    ? new ArrayList<>()
                    : new ArrayList<>(recurrenceTemplate);
            return this;
        }

        /**
         * Adds a {@code recurrenceTemplate} value.
         *
         * @param recurrenceTemplate the value to add
         * @return this builder
         */
        public Builder addRecurrenceTemplate(RecurrenceTemplate recurrenceTemplate) {
            this.recurrenceTemplate.add(Objects.requireNonNull(recurrenceTemplate, "recurrenceTemplate"));
            return this;
        }

        /**
         * Builds the {@code Appointment}.
         *
         * @return the {@code Appointment}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public Appointment build() {
            return new Appointment(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, cancellationReason, classValue, serviceCategory, serviceType, specialty, appointmentType,
                    reason, priority, description, replaces, virtualService, supportingInformation,
                    previousAppointment, originatingAppointment, start, end, minutesDuration, requestedPeriod, slot,
                    account, created, cancellationDate, note, patientInstruction, basedOn, subject, participant,
                    recurrenceId, occurrenceChanged, recurrenceTemplate);
        }
    }
}
