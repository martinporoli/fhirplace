package se.poroli.fhirplace.r5.slot;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * A slot of time on a schedule that may be available for booking appointments.
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
 * @param serviceCategory A broad categorization of the service that is to be performed during this appointment.
 * @param serviceType The type of appointments that can be booked into this slot (ideally this would be an
 *   identifiable service - which is at a location, rather than the location itself). If provided then this overrides
 *   the value provided on the Schedule resource.
 * @param specialty The specialty of a practitioner that would be required to perform the service requested in this
 *   appointment.
 * @param appointmentType The style of appointment or patient that may be booked in the slot (not service type).
 * @param schedule The schedule resource that this slot defines an interval of status information. Reference to
 *   Schedule. Required.
 * @param status busy | free | busy-unavailable | busy-tentative | entered-in-error. Required.
 * @param start Date/Time that the slot is to begin. Required.
 * @param end Date/Time that the slot is to conclude. Required.
 * @param overbooked This slot has already been overbooked, appointments are unlikely to be accepted for this time.
 * @param comment Comments on the slot to describe any extended information. Such as custom constraints on the slot.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Slot">FHIR R5 Slot</a>
 */
public record Slot(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        List<CodeableConcept> serviceCategory,
        List<CodeableReference> serviceType,
        List<CodeableConcept> specialty,
        List<CodeableConcept> appointmentType,
        Reference schedule,
        FhirEnum<SlotStatus> status,
        FhirInstant start,
        FhirInstant end,
        FhirBoolean overbooked,
        FhirString comment) implements DomainResource {

    /**
     * Creates a {@code Slot}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Slot {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        serviceCategory = serviceCategory == null ? List.of() : List.copyOf(serviceCategory);
        serviceType = serviceType == null ? List.of() : List.copyOf(serviceType);
        specialty = specialty == null ? List.of() : List.copyOf(specialty);
        appointmentType = appointmentType == null ? List.of() : List.copyOf(appointmentType);
        Objects.requireNonNull(schedule, "Slot.schedule is required");
        Objects.requireNonNull(status, "Slot.status is required");
        Objects.requireNonNull(start, "Slot.start is required");
        Objects.requireNonNull(end, "Slot.end is required");
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
     * Returns a builder initialized with the values of this {@code Slot}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Slot}. Builders are mutable and not thread-safe. */
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
        private List<CodeableConcept> serviceCategory = new ArrayList<>();
        private List<CodeableReference> serviceType = new ArrayList<>();
        private List<CodeableConcept> specialty = new ArrayList<>();
        private List<CodeableConcept> appointmentType = new ArrayList<>();
        private Reference schedule;
        private FhirEnum<SlotStatus> status;
        private FhirInstant start;
        private FhirInstant end;
        private FhirBoolean overbooked;
        private FhirString comment;

        private Builder() {
        }

        private Builder(Slot original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.serviceCategory = new ArrayList<>(original.serviceCategory());
            this.serviceType = new ArrayList<>(original.serviceType());
            this.specialty = new ArrayList<>(original.specialty());
            this.appointmentType = new ArrayList<>(original.appointmentType());
            this.schedule = original.schedule();
            this.status = original.status();
            this.start = original.start();
            this.end = original.end();
            this.overbooked = original.overbooked();
            this.comment = original.comment();
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
         * Replaces all {@code appointmentType} values.
         *
         * @param appointmentType the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder appointmentType(List<CodeableConcept> appointmentType) {
            this.appointmentType = appointmentType == null ? new ArrayList<>() : new ArrayList<>(appointmentType);
            return this;
        }

        /**
         * Adds a {@code appointmentType} value.
         *
         * @param appointmentType the value to add
         * @return this builder
         */
        public Builder addAppointmentType(CodeableConcept appointmentType) {
            this.appointmentType.add(Objects.requireNonNull(appointmentType, "appointmentType"));
            return this;
        }

        /**
         * Sets {@code schedule}.
         *
         * @param schedule the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder schedule(Reference schedule) {
            this.schedule = schedule;
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<SlotStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(SlotStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Sets {@code overbooked}.
         *
         * @param overbooked the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder overbooked(FhirBoolean overbooked) {
            this.overbooked = overbooked;
            return this;
        }

        /**
         * Sets {@code overbooked}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param overbooked the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder overbooked(Boolean overbooked) {
            return overbooked(overbooked == null ? null : FhirBoolean.of(overbooked));
        }

        /**
         * Sets {@code comment}.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(FhirString comment) {
            this.comment = comment;
            return this;
        }

        /**
         * Sets {@code comment}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(String comment) {
            return comment(comment == null ? null : FhirString.of(comment));
        }

        /**
         * Builds the {@code Slot}.
         *
         * @return the {@code Slot}
         * @throws NullPointerException if a required element is absent
         */
        public Slot build() {
            return new Slot(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    serviceCategory, serviceType, specialty, appointmentType, schedule, status, start, end,
                    overbooked, comment);
        }
    }
}
