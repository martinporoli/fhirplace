package se.poroli.fhirplace.r5.medicationdispense;

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
import se.poroli.fhirplace.r5.datatypes.Dosage;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
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

/**
 * Indicates that a medication product is to be or has been dispensed for a named person/patient.
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
 * @param identifier External identifier.
 * @param basedOn Plan that is fulfilled by this dispense. Reference to CarePlan.
 * @param partOf Event that dispense is part of. Reference to Procedure, MedicationAdministration.
 * @param status preparation | in-progress | cancelled | on-hold | completed | entered-in-error | stopped | declined |
 *   unknown. Required. Modifier element.
 * @param notPerformedReason Why a dispense was not performed.
 * @param statusChanged When the status changed.
 * @param category Type of medication dispense.
 * @param medication What medication was supplied. Required.
 * @param subject Who the dispense is for. Reference to Patient, Group. Required.
 * @param encounter Encounter associated with event. Reference to Encounter.
 * @param supportingInformation Information that supports the dispensing of the medication. Reference to Resource.
 * @param performer Who performed event.
 * @param location Where the dispense occurred. Reference to Location.
 * @param authorizingPrescription Medication order that authorizes the dispense. Reference to MedicationRequest.
 * @param type Trial fill, partial fill, emergency fill, etc.
 * @param quantity Amount dispensed.
 * @param daysSupply Amount of medication expressed as a timing amount.
 * @param recorded When the recording of the dispense started.
 * @param whenPrepared When product was packaged and reviewed.
 * @param whenHandedOver When product was given out.
 * @param destination Where the medication was/will be sent. Reference to Location.
 * @param receiver Who collected the medication or where the medication was delivered. Reference to Patient,
 *   Practitioner, RelatedPerson, Location, PractitionerRole.
 * @param note Information about the dispense.
 * @param renderedDosageInstruction Full representation of the dosage instructions.
 * @param dosageInstruction How the medication is to be used by the patient or administered by the caregiver.
 * @param substitution Whether a substitution was performed on the dispense.
 * @param eventHistory A list of relevant lifecycle events. Reference to Provenance.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MedicationDispense">FHIR R5 MedicationDispense</a>
 */
public record MedicationDispense(
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
        FhirEnum<MedicationDispenseStatusCodes> status,
        CodeableReference notPerformedReason,
        FhirDateTime statusChanged,
        List<CodeableConcept> category,
        CodeableReference medication,
        Reference subject,
        Reference encounter,
        List<Reference> supportingInformation,
        List<Performer> performer,
        Reference location,
        List<Reference> authorizingPrescription,
        CodeableConcept type,
        Quantity quantity,
        Quantity daysSupply,
        FhirDateTime recorded,
        FhirDateTime whenPrepared,
        FhirDateTime whenHandedOver,
        Reference destination,
        List<Reference> receiver,
        List<Annotation> note,
        FhirMarkdown renderedDosageInstruction,
        List<Dosage> dosageInstruction,
        Substitution substitution,
        List<Reference> eventHistory) implements DomainResource {

    /**
     * Creates a {@code MedicationDispense}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public MedicationDispense {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        category = category == null ? List.of() : List.copyOf(category);
        supportingInformation = supportingInformation == null ? List.of() : List.copyOf(supportingInformation);
        performer = performer == null ? List.of() : List.copyOf(performer);
        authorizingPrescription = authorizingPrescription == null ? List.of() : List.copyOf(authorizingPrescription);
        receiver = receiver == null ? List.of() : List.copyOf(receiver);
        note = note == null ? List.of() : List.copyOf(note);
        dosageInstruction = dosageInstruction == null ? List.of() : List.copyOf(dosageInstruction);
        eventHistory = eventHistory == null ? List.of() : List.copyOf(eventHistory);
        Objects.requireNonNull(status, "MedicationDispense.status is required");
        Objects.requireNonNull(medication, "MedicationDispense.medication is required");
        Objects.requireNonNull(subject, "MedicationDispense.subject is required");
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
     * Returns a builder initialized with the values of this {@code MedicationDispense}.
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
            Objects.requireNonNull(actor, "MedicationDispense.performer.actor is required");
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
     * Indicates whether or not substitution was made as part of the dispense.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param wasSubstituted Whether a substitution was or was not performed on the dispense. Required.
     * @param type Code signifying whether a different drug was dispensed from what was prescribed.
     * @param reason Why was substitution made.
     * @param responsibleParty Who is responsible for the substitution. Reference to Practitioner, PractitionerRole,
     *   Organization.
     */
    public record Substitution(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirBoolean wasSubstituted,
            CodeableConcept type,
            List<CodeableConcept> reason,
            Reference responsibleParty) implements BackboneElement {

        /**
         * Creates a {@code Substitution}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Substitution {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            reason = reason == null ? List.of() : List.copyOf(reason);
            Objects.requireNonNull(wasSubstituted, "MedicationDispense.substitution.wasSubstituted is required");
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
         * Returns a builder initialized with the values of this {@code Substitution}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Substitution}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirBoolean wasSubstituted;
            private CodeableConcept type;
            private List<CodeableConcept> reason = new ArrayList<>();
            private Reference responsibleParty;

            private Builder() {
            }

            private Builder(Substitution original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.wasSubstituted = original.wasSubstituted();
                this.type = original.type();
                this.reason = new ArrayList<>(original.reason());
                this.responsibleParty = original.responsibleParty();
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
             * Sets {@code wasSubstituted}.
             *
             * @param wasSubstituted the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder wasSubstituted(FhirBoolean wasSubstituted) {
                this.wasSubstituted = wasSubstituted;
                return this;
            }

            /**
             * Sets {@code wasSubstituted}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param wasSubstituted the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder wasSubstituted(Boolean wasSubstituted) {
                return wasSubstituted(wasSubstituted == null ? null : FhirBoolean.of(wasSubstituted));
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
             * Replaces all {@code reason} values.
             *
             * @param reason the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder reason(List<CodeableConcept> reason) {
                this.reason = reason == null ? new ArrayList<>() : new ArrayList<>(reason);
                return this;
            }

            /**
             * Adds a {@code reason} value.
             *
             * @param reason the value to add
             * @return this builder
             */
            public Builder addReason(CodeableConcept reason) {
                this.reason.add(Objects.requireNonNull(reason, "reason"));
                return this;
            }

            /**
             * Sets {@code responsibleParty}.
             *
             * @param responsibleParty the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder responsibleParty(Reference responsibleParty) {
                this.responsibleParty = responsibleParty;
                return this;
            }

            /**
             * Builds the {@code Substitution}.
             *
             * @return the {@code Substitution}
             * @throws NullPointerException if a required element is absent
             */
            public Substitution build() {
                return new Substitution(
                        id, extension, modifierExtension, wasSubstituted, type, reason, responsibleParty);
            }
        }
    }

    /** Builder for {@link MedicationDispense}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<MedicationDispenseStatusCodes> status;
        private CodeableReference notPerformedReason;
        private FhirDateTime statusChanged;
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableReference medication;
        private Reference subject;
        private Reference encounter;
        private List<Reference> supportingInformation = new ArrayList<>();
        private List<Performer> performer = new ArrayList<>();
        private Reference location;
        private List<Reference> authorizingPrescription = new ArrayList<>();
        private CodeableConcept type;
        private Quantity quantity;
        private Quantity daysSupply;
        private FhirDateTime recorded;
        private FhirDateTime whenPrepared;
        private FhirDateTime whenHandedOver;
        private Reference destination;
        private List<Reference> receiver = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private FhirMarkdown renderedDosageInstruction;
        private List<Dosage> dosageInstruction = new ArrayList<>();
        private Substitution substitution;
        private List<Reference> eventHistory = new ArrayList<>();

        private Builder() {
        }

        private Builder(MedicationDispense original) {
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
            this.notPerformedReason = original.notPerformedReason();
            this.statusChanged = original.statusChanged();
            this.category = new ArrayList<>(original.category());
            this.medication = original.medication();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.supportingInformation = new ArrayList<>(original.supportingInformation());
            this.performer = new ArrayList<>(original.performer());
            this.location = original.location();
            this.authorizingPrescription = new ArrayList<>(original.authorizingPrescription());
            this.type = original.type();
            this.quantity = original.quantity();
            this.daysSupply = original.daysSupply();
            this.recorded = original.recorded();
            this.whenPrepared = original.whenPrepared();
            this.whenHandedOver = original.whenHandedOver();
            this.destination = original.destination();
            this.receiver = new ArrayList<>(original.receiver());
            this.note = new ArrayList<>(original.note());
            this.renderedDosageInstruction = original.renderedDosageInstruction();
            this.dosageInstruction = new ArrayList<>(original.dosageInstruction());
            this.substitution = original.substitution();
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
        public Builder status(FhirEnum<MedicationDispenseStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(MedicationDispenseStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code notPerformedReason}.
         *
         * @param notPerformedReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder notPerformedReason(CodeableReference notPerformedReason) {
            this.notPerformedReason = notPerformedReason;
            return this;
        }

        /**
         * Sets {@code statusChanged}.
         *
         * @param statusChanged the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusChanged(FhirDateTime statusChanged) {
            this.statusChanged = statusChanged;
            return this;
        }

        /**
         * Sets {@code statusChanged}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param statusChanged the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusChanged(Temporal statusChanged) {
            return statusChanged(statusChanged == null ? null : FhirDateTime.of(statusChanged));
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
         * Sets {@code medication}.
         *
         * @param medication the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder medication(CodeableReference medication) {
            this.medication = medication;
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
         * Replaces all {@code authorizingPrescription} values.
         *
         * @param authorizingPrescription the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder authorizingPrescription(List<Reference> authorizingPrescription) {
            this.authorizingPrescription = authorizingPrescription == null
                    ? new ArrayList<>()
                    : new ArrayList<>(authorizingPrescription);
            return this;
        }

        /**
         * Adds a {@code authorizingPrescription} value.
         *
         * @param authorizingPrescription the value to add
         * @return this builder
         */
        public Builder addAuthorizingPrescription(Reference authorizingPrescription) {
            this.authorizingPrescription.add(
                    Objects.requireNonNull(authorizingPrescription, "authorizingPrescription"));
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
         * Sets {@code daysSupply}.
         *
         * @param daysSupply the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder daysSupply(Quantity daysSupply) {
            this.daysSupply = daysSupply;
            return this;
        }

        /**
         * Sets {@code recorded}.
         *
         * @param recorded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorded(FhirDateTime recorded) {
            this.recorded = recorded;
            return this;
        }

        /**
         * Sets {@code recorded}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param recorded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorded(Temporal recorded) {
            return recorded(recorded == null ? null : FhirDateTime.of(recorded));
        }

        /**
         * Sets {@code whenPrepared}.
         *
         * @param whenPrepared the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder whenPrepared(FhirDateTime whenPrepared) {
            this.whenPrepared = whenPrepared;
            return this;
        }

        /**
         * Sets {@code whenPrepared}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param whenPrepared the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder whenPrepared(Temporal whenPrepared) {
            return whenPrepared(whenPrepared == null ? null : FhirDateTime.of(whenPrepared));
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
         * Replaces all {@code receiver} values.
         *
         * @param receiver the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder receiver(List<Reference> receiver) {
            this.receiver = receiver == null ? new ArrayList<>() : new ArrayList<>(receiver);
            return this;
        }

        /**
         * Adds a {@code receiver} value.
         *
         * @param receiver the value to add
         * @return this builder
         */
        public Builder addReceiver(Reference receiver) {
            this.receiver.add(Objects.requireNonNull(receiver, "receiver"));
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
         * Sets {@code renderedDosageInstruction}.
         *
         * @param renderedDosageInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder renderedDosageInstruction(FhirMarkdown renderedDosageInstruction) {
            this.renderedDosageInstruction = renderedDosageInstruction;
            return this;
        }

        /**
         * Sets {@code renderedDosageInstruction}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param renderedDosageInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder renderedDosageInstruction(String renderedDosageInstruction) {
            return renderedDosageInstruction(
                    renderedDosageInstruction == null ? null : FhirMarkdown.of(renderedDosageInstruction));
        }

        /**
         * Replaces all {@code dosageInstruction} values.
         *
         * @param dosageInstruction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder dosageInstruction(List<Dosage> dosageInstruction) {
            this.dosageInstruction = dosageInstruction == null
                    ? new ArrayList<>()
                    : new ArrayList<>(dosageInstruction);
            return this;
        }

        /**
         * Adds a {@code dosageInstruction} value.
         *
         * @param dosageInstruction the value to add
         * @return this builder
         */
        public Builder addDosageInstruction(Dosage dosageInstruction) {
            this.dosageInstruction.add(Objects.requireNonNull(dosageInstruction, "dosageInstruction"));
            return this;
        }

        /**
         * Sets {@code substitution}.
         *
         * @param substitution the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder substitution(Substitution substitution) {
            this.substitution = substitution;
            return this;
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
         * Builds the {@code MedicationDispense}.
         *
         * @return the {@code MedicationDispense}
         * @throws NullPointerException if a required element is absent
         */
        public MedicationDispense build() {
            return new MedicationDispense(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    basedOn, partOf, status, notPerformedReason, statusChanged, category, medication, subject,
                    encounter, supportingInformation, performer, location, authorizingPrescription, type, quantity,
                    daysSupply, recorded, whenPrepared, whenHandedOver, destination, receiver, note,
                    renderedDosageInstruction, dosageInstruction, substitution, eventHistory);
        }
    }
}
