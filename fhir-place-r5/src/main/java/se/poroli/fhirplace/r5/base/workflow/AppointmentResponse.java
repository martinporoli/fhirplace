package se.poroli.fhirplace.r5.base.workflow;

import java.time.OffsetDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
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
 * @param appointment Appointment this response relates to. Reference to Appointment. Required.
 * @param proposedNewTime Indicator for a counter proposal.
 * @param start Time from appointment, or requested new start time.
 * @param end Time from appointment, or requested new end time.
 * @param participantType Role of participant in the appointment.
 * @param actor Person(s), Location, HealthcareService, or Device. Reference to Patient, Group, Practitioner,
 *   PractitionerRole, RelatedPerson, Device, HealthcareService, Location.
 * @param participantStatus accepted | declined | tentative | needs-action | entered-in-error. Required. Modifier
 *   element.
 * @param comment Additional comments.
 * @param recurring This response is for all occurrences in a recurring request.
 * @param occurrenceDate Original date within a recurring request.
 * @param recurrenceId The recurrence ID of the specific recurring request.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/AppointmentResponse">FHIR R5 AppointmentResponse</a>
 */
public record AppointmentResponse(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        Reference appointment,
        FhirBoolean proposedNewTime,
        FhirInstant start,
        FhirInstant end,
        List<CodeableConcept> participantType,
        Reference actor,
        FhirCode participantStatus,
        FhirMarkdown comment,
        FhirBoolean recurring,
        FhirDate occurrenceDate,
        FhirPositiveInt recurrenceId) implements DomainResource {

    /**
     * Creates an {@code AppointmentResponse}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public AppointmentResponse {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        participantType = participantType == null ? List.of() : List.copyOf(participantType);
        Objects.requireNonNull(appointment, "AppointmentResponse.appointment is required");
        Objects.requireNonNull(participantStatus, "AppointmentResponse.participantStatus is required");
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
     * Returns a builder initialized with the values of this {@code AppointmentResponse}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link AppointmentResponse}. Builders are mutable and not thread-safe. */
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
        private Reference appointment;
        private FhirBoolean proposedNewTime;
        private FhirInstant start;
        private FhirInstant end;
        private List<CodeableConcept> participantType = new ArrayList<>();
        private Reference actor;
        private FhirCode participantStatus;
        private FhirMarkdown comment;
        private FhirBoolean recurring;
        private FhirDate occurrenceDate;
        private FhirPositiveInt recurrenceId;

        private Builder() {
        }

        private Builder(AppointmentResponse original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.appointment = original.appointment();
            this.proposedNewTime = original.proposedNewTime();
            this.start = original.start();
            this.end = original.end();
            this.participantType = new ArrayList<>(original.participantType());
            this.actor = original.actor();
            this.participantStatus = original.participantStatus();
            this.comment = original.comment();
            this.recurring = original.recurring();
            this.occurrenceDate = original.occurrenceDate();
            this.recurrenceId = original.recurrenceId();
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
         * Sets {@code appointment}.
         *
         * @param appointment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder appointment(Reference appointment) {
            this.appointment = appointment;
            return this;
        }

        /**
         * Sets {@code proposedNewTime}.
         *
         * @param proposedNewTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder proposedNewTime(FhirBoolean proposedNewTime) {
            this.proposedNewTime = proposedNewTime;
            return this;
        }

        /**
         * Sets {@code proposedNewTime}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param proposedNewTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder proposedNewTime(Boolean proposedNewTime) {
            return proposedNewTime(proposedNewTime == null ? null : FhirBoolean.of(proposedNewTime));
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
         * Replaces all {@code participantType} values.
         *
         * @param participantType the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder participantType(List<CodeableConcept> participantType) {
            this.participantType = participantType == null ? new ArrayList<>() : new ArrayList<>(participantType);
            return this;
        }

        /**
         * Adds a {@code participantType} value.
         *
         * @param participantType the value to add
         * @return this builder
         */
        public Builder addParticipantType(CodeableConcept participantType) {
            this.participantType.add(Objects.requireNonNull(participantType, "participantType"));
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
         * Sets {@code participantStatus}.
         *
         * @param participantStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder participantStatus(FhirCode participantStatus) {
            this.participantStatus = participantStatus;
            return this;
        }

        /**
         * Sets {@code participantStatus}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param participantStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder participantStatus(String participantStatus) {
            return participantStatus(participantStatus == null ? null : FhirCode.of(participantStatus));
        }

        /**
         * Sets {@code comment}.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(FhirMarkdown comment) {
            this.comment = comment;
            return this;
        }

        /**
         * Sets {@code comment}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(String comment) {
            return comment(comment == null ? null : FhirMarkdown.of(comment));
        }

        /**
         * Sets {@code recurring}.
         *
         * @param recurring the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recurring(FhirBoolean recurring) {
            this.recurring = recurring;
            return this;
        }

        /**
         * Sets {@code recurring}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param recurring the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recurring(Boolean recurring) {
            return recurring(recurring == null ? null : FhirBoolean.of(recurring));
        }

        /**
         * Sets {@code occurrenceDate}.
         *
         * @param occurrenceDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrenceDate(FhirDate occurrenceDate) {
            this.occurrenceDate = occurrenceDate;
            return this;
        }

        /**
         * Sets {@code occurrenceDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param occurrenceDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrenceDate(Temporal occurrenceDate) {
            return occurrenceDate(occurrenceDate == null ? null : FhirDate.of(occurrenceDate));
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
         * Builds the {@code AppointmentResponse}.
         *
         * @return the {@code AppointmentResponse}
         * @throws NullPointerException if a required element is absent
         */
        public AppointmentResponse build() {
            return new AppointmentResponse(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    appointment, proposedNewTime, start, end, participantType, actor, participantStatus, comment,
                    recurring, occurrenceDate, recurrenceId);
        }
    }
}
