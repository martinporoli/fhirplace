package se.poroli.fhirplace.r5.devicedispense;

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
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * Indicates that a device is to be or has been dispensed for a named person/patient.
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
 * @param identifier Business identifier for this dispensation.
 * @param basedOn The order or request that this dispense is fulfilling. Reference to CarePlan, DeviceRequest.
 * @param partOf The bigger event that this dispense is a part of. Reference to Procedure.
 * @param status preparation | in-progress | cancelled | on-hold | completed | entered-in-error | stopped | declined |
 *   unknown. Required. Modifier element.
 * @param statusReason Why a dispense was or was not performed.
 * @param category Type of device dispense.
 * @param device What device was supplied. Required.
 * @param subject Who the dispense is for. Reference to Patient, Practitioner. Required.
 * @param receiver Who collected the device or where the medication was delivered. Reference to Patient, Practitioner,
 *   RelatedPerson, Location, PractitionerRole.
 * @param encounter Encounter associated with event. Reference to Encounter.
 * @param supportingInformation Information that supports the dispensing of the device. Reference to Resource.
 * @param performer Who performed event.
 * @param location Where the dispense occurred. Reference to Location.
 * @param type Trial fill, partial fill, emergency fill, etc.
 * @param quantity Amount dispensed.
 * @param preparedDate When product was packaged and reviewed.
 * @param whenHandedOver When product was given out.
 * @param destination Where the device was sent or should be sent. Reference to Location.
 * @param note Information about the dispense.
 * @param usageInstruction Full representation of the usage instructions.
 * @param eventHistory A list of relevant lifecycle events. Reference to Provenance.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DeviceDispense">FHIR R5 DeviceDispense</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record DeviceDispense(
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
        List<Reference> partOf,
        FhirEnum<DeviceDispenseStatusCodes> status,
        CodeableReference statusReason,
        List<CodeableConcept> category,
        CodeableReference device,
        Reference subject,
        Reference receiver,
        Reference encounter,
        List<Reference> supportingInformation,
        List<Performer> performer,
        Reference location,
        CodeableConcept type,
        Quantity quantity,
        FhirDateTime preparedDate,
        FhirDateTime whenHandedOver,
        Reference destination,
        List<Annotation> note,
        FhirMarkdown usageInstruction,
        List<Reference> eventHistory) implements DomainResource {

    /**
     * Creates a {@code DeviceDispense}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public DeviceDispense {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        category = category == null ? List.of() : List.copyOf(category);
        supportingInformation = supportingInformation == null ? List.of() : List.copyOf(supportingInformation);
        performer = performer == null ? List.of() : List.copyOf(performer);
        note = note == null ? List.of() : List.copyOf(note);
        eventHistory = eventHistory == null ? List.of() : List.copyOf(eventHistory);
        Objects.requireNonNull(status, "DeviceDispense.status is required");
        Objects.requireNonNull(device, "DeviceDispense.device is required");
        Objects.requireNonNull(subject, "DeviceDispense.subject is required");
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
     * Returns a builder initialized with the values of this {@code DeviceDispense}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates who or what performed the event.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function Who performed the dispense and what they did.
     * @param actor Individual who was performing. Reference to Practitioner, PractitionerRole, Organization, Patient,
     *   Device, RelatedPerson, CareTeam. Required.
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
            Objects.requireNonNull(actor, "DeviceDispense.performer.actor is required");
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

    /** Builder for {@link DeviceDispense}. Builders are mutable and not thread-safe. */
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
        private List<Reference> partOf = new ArrayList<>();
        private FhirEnum<DeviceDispenseStatusCodes> status;
        private CodeableReference statusReason;
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableReference device;
        private Reference subject;
        private Reference receiver;
        private Reference encounter;
        private List<Reference> supportingInformation = new ArrayList<>();
        private List<Performer> performer = new ArrayList<>();
        private Reference location;
        private CodeableConcept type;
        private Quantity quantity;
        private FhirDateTime preparedDate;
        private FhirDateTime whenHandedOver;
        private Reference destination;
        private List<Annotation> note = new ArrayList<>();
        private FhirMarkdown usageInstruction;
        private List<Reference> eventHistory = new ArrayList<>();

        private Builder() {
        }

        private Builder(DeviceDispense original) {
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
            this.partOf = new ArrayList<>(original.partOf());
            this.status = original.status();
            this.statusReason = original.statusReason();
            this.category = new ArrayList<>(original.category());
            this.device = original.device();
            this.subject = original.subject();
            this.receiver = original.receiver();
            this.encounter = original.encounter();
            this.supportingInformation = new ArrayList<>(original.supportingInformation());
            this.performer = new ArrayList<>(original.performer());
            this.location = original.location();
            this.type = original.type();
            this.quantity = original.quantity();
            this.preparedDate = original.preparedDate();
            this.whenHandedOver = original.whenHandedOver();
            this.destination = original.destination();
            this.note = new ArrayList<>(original.note());
            this.usageInstruction = original.usageInstruction();
            this.eventHistory = new ArrayList<>(original.eventHistory());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<DeviceDispenseStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(DeviceDispenseStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code statusReason}.
         *
         * @param statusReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusReason(CodeableReference statusReason) {
            this.statusReason = statusReason;
            return this;
        }

        /**
         * Replaces all {@code category} values.
         *
         * @param category the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder category(List<CodeableConcept> category) {
            this.category = category == null ? new ArrayList<>() : new ArrayList<>(category);
            return this;
        }

        /**
         * Adds a {@code category} value.
         *
         * @param category the value to add
         * @return this builder
         */
        public Builder addCategory(CodeableConcept category) {
            this.category.add(Objects.requireNonNull(category, "category"));
            return this;
        }

        /**
         * Sets {@code device}.
         *
         * @param device the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder device(CodeableReference device) {
            this.device = device;
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
         * Sets {@code receiver}.
         *
         * @param receiver the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder receiver(Reference receiver) {
            this.receiver = receiver;
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
         * Sets {@code preparedDate}.
         *
         * @param preparedDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preparedDate(FhirDateTime preparedDate) {
            this.preparedDate = preparedDate;
            return this;
        }

        /**
         * Sets {@code preparedDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param preparedDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preparedDate(Temporal preparedDate) {
            return preparedDate(preparedDate == null ? null : FhirDateTime.of(preparedDate));
        }

        /**
         * Sets {@code whenHandedOver}.
         *
         * @param whenHandedOver the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder whenHandedOver(FhirDateTime whenHandedOver) {
            this.whenHandedOver = whenHandedOver;
            return this;
        }

        /**
         * Sets {@code whenHandedOver}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param whenHandedOver the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder whenHandedOver(Temporal whenHandedOver) {
            return whenHandedOver(whenHandedOver == null ? null : FhirDateTime.of(whenHandedOver));
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
         * Sets {@code usageInstruction}.
         *
         * @param usageInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder usageInstruction(FhirMarkdown usageInstruction) {
            this.usageInstruction = usageInstruction;
            return this;
        }

        /**
         * Sets {@code usageInstruction}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param usageInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder usageInstruction(String usageInstruction) {
            return usageInstruction(usageInstruction == null ? null : FhirMarkdown.of(usageInstruction));
        }

        /**
         * Replaces all {@code eventHistory} values.
         *
         * @param eventHistory the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder eventHistory(List<Reference> eventHistory) {
            this.eventHistory = eventHistory == null ? new ArrayList<>() : new ArrayList<>(eventHistory);
            return this;
        }

        /**
         * Adds a {@code eventHistory} value.
         *
         * @param eventHistory the value to add
         * @return this builder
         */
        public Builder addEventHistory(Reference eventHistory) {
            this.eventHistory.add(Objects.requireNonNull(eventHistory, "eventHistory"));
            return this;
        }

        /**
         * Builds the {@code DeviceDispense}.
         *
         * @return the {@code DeviceDispense}
         * @throws NullPointerException if a required element is absent
         */
        public DeviceDispense build() {
            return new DeviceDispense(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    basedOn, partOf, status, statusReason, category, device, subject, receiver, encounter,
                    supportingInformation, performer, location, type, quantity, preparedDate, whenHandedOver,
                    destination, note, usageInstruction, eventHistory);
        }
    }
}
