package se.poroli.fhirplace.r5.clinical.medications;

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
import se.poroli.fhirplace.r5.datatypes.Dosage;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.MedicationRequestIntent;
import se.poroli.fhirplace.r5.valuesets.MedicationrequestStatus;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;

/**
 * An order or request for both supply of the medication and the instructions for administration of the medication to
 * a patient.
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
 * @param identifier External ids for this request.
 * @param basedOn A plan or request that is fulfilled in whole or in part by this medication request. Reference to
 *   CarePlan, MedicationRequest, ServiceRequest, ImmunizationRecommendation.
 * @param priorPrescription Reference to an order/prescription that is being replaced by this MedicationRequest.
 *   Reference to MedicationRequest.
 * @param groupIdentifier Composite request this is part of.
 * @param status active | on-hold | ended | stopped | completed | cancelled | entered-in-error | draft | unknown.
 *   Required. Modifier element.
 * @param statusReason Reason for current status.
 * @param statusChanged When the status was changed.
 * @param intent proposal | plan | order | original-order | reflex-order | filler-order | instance-order | option.
 *   Required. Modifier element.
 * @param category Grouping or category of medication request.
 * @param priority routine | urgent | asap | stat.
 * @param doNotPerform True if patient is to stop taking or not to start taking the medication. Modifier element.
 * @param medication Medication to be taken. Required.
 * @param subject Individual or group for whom the medication has been requested. Reference to Patient, Group.
 *   Required.
 * @param informationSource The person or organization who provided the information about this request, if the source
 *   is someone other than the requestor. Reference to Patient, Practitioner, PractitionerRole, RelatedPerson,
 *   Organization.
 * @param encounter Encounter created as part of encounter/admission/stay. Reference to Encounter.
 * @param supportingInformation Information to support fulfilling of the medication. Reference to Resource.
 * @param authoredOn When request was initially authored.
 * @param requester Who/What requested the Request. Reference to Practitioner, PractitionerRole, Organization,
 *   Patient, RelatedPerson, Device.
 * @param reported Reported rather than primary record.
 * @param performerType Desired kind of performer of the medication administration.
 * @param performer Intended performer of administration. Reference to Practitioner, PractitionerRole, Organization,
 *   Patient, DeviceDefinition, RelatedPerson, CareTeam, HealthcareService.
 * @param device Intended type of device for the administration.
 * @param recorder Person who entered the request. Reference to Practitioner, PractitionerRole.
 * @param reason Reason or indication for ordering or not ordering the medication.
 * @param courseOfTherapyType Overall pattern of medication administration.
 * @param insurance Associated insurance coverage. Reference to Coverage, ClaimResponse.
 * @param note Information about the prescription.
 * @param renderedDosageInstruction Full representation of the dosage instructions.
 * @param effectiveDosePeriod Period over which the medication is to be taken.
 * @param dosageInstruction Specific instructions for how the medication should be taken.
 * @param dispenseRequest Medication supply authorization.
 * @param substitution Any restrictions on medication substitution.
 * @param eventHistory A list of events of interest in the lifecycle. Reference to Provenance.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MedicationRequest">FHIR R5 MedicationRequest</a>
 */
public record MedicationRequest(
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
        Reference priorPrescription,
        Identifier groupIdentifier,
        FhirEnum<MedicationrequestStatus> status,
        CodeableConcept statusReason,
        FhirDateTime statusChanged,
        FhirEnum<MedicationRequestIntent> intent,
        List<CodeableConcept> category,
        FhirEnum<RequestPriority> priority,
        FhirBoolean doNotPerform,
        CodeableReference medication,
        Reference subject,
        List<Reference> informationSource,
        Reference encounter,
        List<Reference> supportingInformation,
        FhirDateTime authoredOn,
        Reference requester,
        FhirBoolean reported,
        CodeableConcept performerType,
        List<Reference> performer,
        List<CodeableReference> device,
        Reference recorder,
        List<CodeableReference> reason,
        CodeableConcept courseOfTherapyType,
        List<Reference> insurance,
        List<Annotation> note,
        FhirMarkdown renderedDosageInstruction,
        Period effectiveDosePeriod,
        List<Dosage> dosageInstruction,
        DispenseRequest dispenseRequest,
        Substitution substitution,
        List<Reference> eventHistory) implements DomainResource {

    /**
     * Creates a {@code MedicationRequest}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public MedicationRequest {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        category = category == null ? List.of() : List.copyOf(category);
        informationSource = informationSource == null ? List.of() : List.copyOf(informationSource);
        supportingInformation = supportingInformation == null ? List.of() : List.copyOf(supportingInformation);
        performer = performer == null ? List.of() : List.copyOf(performer);
        device = device == null ? List.of() : List.copyOf(device);
        reason = reason == null ? List.of() : List.copyOf(reason);
        insurance = insurance == null ? List.of() : List.copyOf(insurance);
        note = note == null ? List.of() : List.copyOf(note);
        dosageInstruction = dosageInstruction == null ? List.of() : List.copyOf(dosageInstruction);
        eventHistory = eventHistory == null ? List.of() : List.copyOf(eventHistory);
        Objects.requireNonNull(status, "MedicationRequest.status is required");
        Objects.requireNonNull(intent, "MedicationRequest.intent is required");
        Objects.requireNonNull(medication, "MedicationRequest.medication is required");
        Objects.requireNonNull(subject, "MedicationRequest.subject is required");
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
     * Returns a builder initialized with the values of this {@code MedicationRequest}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates the specific details for the dispense or medication supply part of a medication request (also known
     * as a Medication Prescription or Medication Order).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param initialFill First fill details.
     * @param dispenseInterval Minimum period of time between dispenses.
     * @param validityPeriod Time period supply is authorized for.
     * @param numberOfRepeatsAllowed Number of refills authorized.
     * @param quantity Amount of medication to supply per dispense.
     * @param expectedSupplyDuration Number of days supply per dispense.
     * @param dispenser Intended performer of dispense. Reference to Organization.
     * @param dispenserInstruction Additional information for the dispenser.
     * @param doseAdministrationAid Type of adherence packaging to use for the dispense.
     */
    public record DispenseRequest(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            InitialFill initialFill,
            Duration dispenseInterval,
            Period validityPeriod,
            FhirUnsignedInt numberOfRepeatsAllowed,
            Quantity quantity,
            Duration expectedSupplyDuration,
            Reference dispenser,
            List<Annotation> dispenserInstruction,
            CodeableConcept doseAdministrationAid) implements BackboneElement {

        /**
         * Creates a {@code DispenseRequest}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public DispenseRequest {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            dispenserInstruction = dispenserInstruction == null ? List.of() : List.copyOf(dispenserInstruction);
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
         * Returns a builder initialized with the values of this {@code DispenseRequest}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Indicates the quantity or duration for the first dispense of the medication.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param quantity First fill quantity.
         * @param duration First fill duration.
         */
        public record InitialFill(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Quantity quantity,
                Duration duration) implements BackboneElement {

            /**
             * Creates an {@code InitialFill}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public InitialFill {
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
             * Returns a builder initialized with the values of this {@code InitialFill}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link InitialFill}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Quantity quantity;
                private Duration duration;

                private Builder() {
                }

                private Builder(InitialFill original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.quantity = original.quantity();
                    this.duration = original.duration();
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
                 * Sets {@code duration}.
                 *
                 * @param duration the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder duration(Duration duration) {
                    this.duration = duration;
                    return this;
                }

                /**
                 * Builds the {@code InitialFill}.
                 *
                 * @return the {@code InitialFill}
                 */
                public InitialFill build() {
                    return new InitialFill(
                            id, extension, modifierExtension, quantity, duration);
                }
            }
        }

        /** Builder for {@link DispenseRequest}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private InitialFill initialFill;
            private Duration dispenseInterval;
            private Period validityPeriod;
            private FhirUnsignedInt numberOfRepeatsAllowed;
            private Quantity quantity;
            private Duration expectedSupplyDuration;
            private Reference dispenser;
            private List<Annotation> dispenserInstruction = new ArrayList<>();
            private CodeableConcept doseAdministrationAid;

            private Builder() {
            }

            private Builder(DispenseRequest original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.initialFill = original.initialFill();
                this.dispenseInterval = original.dispenseInterval();
                this.validityPeriod = original.validityPeriod();
                this.numberOfRepeatsAllowed = original.numberOfRepeatsAllowed();
                this.quantity = original.quantity();
                this.expectedSupplyDuration = original.expectedSupplyDuration();
                this.dispenser = original.dispenser();
                this.dispenserInstruction = new ArrayList<>(original.dispenserInstruction());
                this.doseAdministrationAid = original.doseAdministrationAid();
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
             * Sets {@code initialFill}.
             *
             * @param initialFill the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder initialFill(InitialFill initialFill) {
                this.initialFill = initialFill;
                return this;
            }

            /**
             * Sets {@code dispenseInterval}.
             *
             * @param dispenseInterval the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dispenseInterval(Duration dispenseInterval) {
                this.dispenseInterval = dispenseInterval;
                return this;
            }

            /**
             * Sets {@code validityPeriod}.
             *
             * @param validityPeriod the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder validityPeriod(Period validityPeriod) {
                this.validityPeriod = validityPeriod;
                return this;
            }

            /**
             * Sets {@code numberOfRepeatsAllowed}.
             *
             * @param numberOfRepeatsAllowed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder numberOfRepeatsAllowed(FhirUnsignedInt numberOfRepeatsAllowed) {
                this.numberOfRepeatsAllowed = numberOfRepeatsAllowed;
                return this;
            }

            /**
             * Sets {@code numberOfRepeatsAllowed}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
             *
             * @param numberOfRepeatsAllowed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder numberOfRepeatsAllowed(Integer numberOfRepeatsAllowed) {
                return numberOfRepeatsAllowed(
                        numberOfRepeatsAllowed == null ? null : FhirUnsignedInt.of(numberOfRepeatsAllowed));
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
             * Sets {@code expectedSupplyDuration}.
             *
             * @param expectedSupplyDuration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder expectedSupplyDuration(Duration expectedSupplyDuration) {
                this.expectedSupplyDuration = expectedSupplyDuration;
                return this;
            }

            /**
             * Sets {@code dispenser}.
             *
             * @param dispenser the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dispenser(Reference dispenser) {
                this.dispenser = dispenser;
                return this;
            }

            /**
             * Replaces all {@code dispenserInstruction} values.
             *
             * @param dispenserInstruction the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder dispenserInstruction(List<Annotation> dispenserInstruction) {
                this.dispenserInstruction = dispenserInstruction == null
                        ? new ArrayList<>()
                        : new ArrayList<>(dispenserInstruction);
                return this;
            }

            /**
             * Adds a {@code dispenserInstruction} value.
             *
             * @param dispenserInstruction the value to add
             * @return this builder
             */
            public Builder addDispenserInstruction(Annotation dispenserInstruction) {
                this.dispenserInstruction.add(Objects.requireNonNull(dispenserInstruction, "dispenserInstruction"));
                return this;
            }

            /**
             * Sets {@code doseAdministrationAid}.
             *
             * @param doseAdministrationAid the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder doseAdministrationAid(CodeableConcept doseAdministrationAid) {
                this.doseAdministrationAid = doseAdministrationAid;
                return this;
            }

            /**
             * Builds the {@code DispenseRequest}.
             *
             * @return the {@code DispenseRequest}
             */
            public DispenseRequest build() {
                return new DispenseRequest(
                        id, extension, modifierExtension, initialFill, dispenseInterval, validityPeriod,
                        numberOfRepeatsAllowed, quantity, expectedSupplyDuration, dispenser, dispenserInstruction,
                        doseAdministrationAid);
            }
        }
    }

    /**
     * Indicates whether or not substitution can or should be part of the dispense.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param allowed Whether substitution is allowed or not. One of boolean, CodeableConcept. Required.
     * @param reason Why should (not) substitution be made.
     */
    public record Substitution(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType allowed,
            CodeableConcept reason) implements BackboneElement {

        /**
         * Creates a {@code Substitution}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Substitution {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(allowed, "MedicationRequest.substitution.allowed is required");
            if (allowed != null && !(allowed instanceof FhirBoolean || allowed instanceof CodeableConcept)) {
                throw new IllegalArgumentException(
                        "MedicationRequest.substitution.allowed[x] must be one of boolean, CodeableConcept, but was "
                                + allowed.getClass().getSimpleName());
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
            private DataType allowed;
            private CodeableConcept reason;

            private Builder() {
            }

            private Builder(Substitution original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.allowed = original.allowed();
                this.reason = original.reason();
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
             * Sets {@code allowed} to a boolean.
             *
             * @param allowed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder allowed(FhirBoolean allowed) {
                this.allowed = allowed;
                return this;
            }

            /**
             * Sets {@code allowed} to a CodeableConcept.
             *
             * @param allowed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder allowed(CodeableConcept allowed) {
                this.allowed = allowed;
                return this;
            }

            /**
             * Sets {@code allowed} to a boolean without id or extensions.
             *
             * @param allowed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder allowed(Boolean allowed) {
                this.allowed = allowed == null ? null : FhirBoolean.of(allowed);
                return this;
            }

            /**
             * Sets {@code reason}.
             *
             * @param reason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reason(CodeableConcept reason) {
                this.reason = reason;
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
                        id, extension, modifierExtension, allowed, reason);
            }
        }
    }

    /** Builder for {@link MedicationRequest}. Builders are mutable and not thread-safe. */
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
        private Reference priorPrescription;
        private Identifier groupIdentifier;
        private FhirEnum<MedicationrequestStatus> status;
        private CodeableConcept statusReason;
        private FhirDateTime statusChanged;
        private FhirEnum<MedicationRequestIntent> intent;
        private List<CodeableConcept> category = new ArrayList<>();
        private FhirEnum<RequestPriority> priority;
        private FhirBoolean doNotPerform;
        private CodeableReference medication;
        private Reference subject;
        private List<Reference> informationSource = new ArrayList<>();
        private Reference encounter;
        private List<Reference> supportingInformation = new ArrayList<>();
        private FhirDateTime authoredOn;
        private Reference requester;
        private FhirBoolean reported;
        private CodeableConcept performerType;
        private List<Reference> performer = new ArrayList<>();
        private List<CodeableReference> device = new ArrayList<>();
        private Reference recorder;
        private List<CodeableReference> reason = new ArrayList<>();
        private CodeableConcept courseOfTherapyType;
        private List<Reference> insurance = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private FhirMarkdown renderedDosageInstruction;
        private Period effectiveDosePeriod;
        private List<Dosage> dosageInstruction = new ArrayList<>();
        private DispenseRequest dispenseRequest;
        private Substitution substitution;
        private List<Reference> eventHistory = new ArrayList<>();

        private Builder() {
        }

        private Builder(MedicationRequest original) {
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
            this.priorPrescription = original.priorPrescription();
            this.groupIdentifier = original.groupIdentifier();
            this.status = original.status();
            this.statusReason = original.statusReason();
            this.statusChanged = original.statusChanged();
            this.intent = original.intent();
            this.category = new ArrayList<>(original.category());
            this.priority = original.priority();
            this.doNotPerform = original.doNotPerform();
            this.medication = original.medication();
            this.subject = original.subject();
            this.informationSource = new ArrayList<>(original.informationSource());
            this.encounter = original.encounter();
            this.supportingInformation = new ArrayList<>(original.supportingInformation());
            this.authoredOn = original.authoredOn();
            this.requester = original.requester();
            this.reported = original.reported();
            this.performerType = original.performerType();
            this.performer = new ArrayList<>(original.performer());
            this.device = new ArrayList<>(original.device());
            this.recorder = original.recorder();
            this.reason = new ArrayList<>(original.reason());
            this.courseOfTherapyType = original.courseOfTherapyType();
            this.insurance = new ArrayList<>(original.insurance());
            this.note = new ArrayList<>(original.note());
            this.renderedDosageInstruction = original.renderedDosageInstruction();
            this.effectiveDosePeriod = original.effectiveDosePeriod();
            this.dosageInstruction = new ArrayList<>(original.dosageInstruction());
            this.dispenseRequest = original.dispenseRequest();
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
         * Sets {@code priorPrescription}.
         *
         * @param priorPrescription the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priorPrescription(Reference priorPrescription) {
            this.priorPrescription = priorPrescription;
            return this;
        }

        /**
         * Sets {@code groupIdentifier}.
         *
         * @param groupIdentifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder groupIdentifier(Identifier groupIdentifier) {
            this.groupIdentifier = groupIdentifier;
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<MedicationrequestStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(MedicationrequestStatus status) {
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
         * Sets {@code intent}.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(FhirEnum<MedicationRequestIntent> intent) {
            this.intent = intent;
            return this;
        }

        /**
         * Sets {@code intent}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(MedicationRequestIntent intent) {
            return intent(intent == null ? null : FhirEnum.of(intent));
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
         * Sets {@code priority}.
         *
         * @param priority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priority(FhirEnum<RequestPriority> priority) {
            this.priority = priority;
            return this;
        }

        /**
         * Sets {@code priority}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param priority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priority(RequestPriority priority) {
            return priority(priority == null ? null : FhirEnum.of(priority));
        }

        /**
         * Sets {@code doNotPerform}.
         *
         * @param doNotPerform the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder doNotPerform(FhirBoolean doNotPerform) {
            this.doNotPerform = doNotPerform;
            return this;
        }

        /**
         * Sets {@code doNotPerform}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param doNotPerform the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder doNotPerform(Boolean doNotPerform) {
            return doNotPerform(doNotPerform == null ? null : FhirBoolean.of(doNotPerform));
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
         * Replaces all {@code informationSource} values.
         *
         * @param informationSource the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder informationSource(List<Reference> informationSource) {
            this.informationSource = informationSource == null
                    ? new ArrayList<>()
                    : new ArrayList<>(informationSource);
            return this;
        }

        /**
         * Adds a {@code informationSource} value.
         *
         * @param informationSource the value to add
         * @return this builder
         */
        public Builder addInformationSource(Reference informationSource) {
            this.informationSource.add(Objects.requireNonNull(informationSource, "informationSource"));
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
         * Sets {@code authoredOn}.
         *
         * @param authoredOn the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authoredOn(FhirDateTime authoredOn) {
            this.authoredOn = authoredOn;
            return this;
        }

        /**
         * Sets {@code authoredOn}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param authoredOn the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authoredOn(Temporal authoredOn) {
            return authoredOn(authoredOn == null ? null : FhirDateTime.of(authoredOn));
        }

        /**
         * Sets {@code requester}.
         *
         * @param requester the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requester(Reference requester) {
            this.requester = requester;
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
         * Sets {@code performerType}.
         *
         * @param performerType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder performerType(CodeableConcept performerType) {
            this.performerType = performerType;
            return this;
        }

        /**
         * Replaces all {@code performer} values.
         *
         * @param performer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder performer(List<Reference> performer) {
            this.performer = performer == null ? new ArrayList<>() : new ArrayList<>(performer);
            return this;
        }

        /**
         * Adds a {@code performer} value.
         *
         * @param performer the value to add
         * @return this builder
         */
        public Builder addPerformer(Reference performer) {
            this.performer.add(Objects.requireNonNull(performer, "performer"));
            return this;
        }

        /**
         * Replaces all {@code device} values.
         *
         * @param device the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder device(List<CodeableReference> device) {
            this.device = device == null ? new ArrayList<>() : new ArrayList<>(device);
            return this;
        }

        /**
         * Adds a {@code device} value.
         *
         * @param device the value to add
         * @return this builder
         */
        public Builder addDevice(CodeableReference device) {
            this.device.add(Objects.requireNonNull(device, "device"));
            return this;
        }

        /**
         * Sets {@code recorder}.
         *
         * @param recorder the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorder(Reference recorder) {
            this.recorder = recorder;
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
         * Sets {@code courseOfTherapyType}.
         *
         * @param courseOfTherapyType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder courseOfTherapyType(CodeableConcept courseOfTherapyType) {
            this.courseOfTherapyType = courseOfTherapyType;
            return this;
        }

        /**
         * Replaces all {@code insurance} values.
         *
         * @param insurance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder insurance(List<Reference> insurance) {
            this.insurance = insurance == null ? new ArrayList<>() : new ArrayList<>(insurance);
            return this;
        }

        /**
         * Adds a {@code insurance} value.
         *
         * @param insurance the value to add
         * @return this builder
         */
        public Builder addInsurance(Reference insurance) {
            this.insurance.add(Objects.requireNonNull(insurance, "insurance"));
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
         * Sets {@code effectiveDosePeriod}.
         *
         * @param effectiveDosePeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effectiveDosePeriod(Period effectiveDosePeriod) {
            this.effectiveDosePeriod = effectiveDosePeriod;
            return this;
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
         * Sets {@code dispenseRequest}.
         *
         * @param dispenseRequest the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dispenseRequest(DispenseRequest dispenseRequest) {
            this.dispenseRequest = dispenseRequest;
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
         * Builds the {@code MedicationRequest}.
         *
         * @return the {@code MedicationRequest}
         * @throws NullPointerException if a required element is absent
         */
        public MedicationRequest build() {
            return new MedicationRequest(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    basedOn, priorPrescription, groupIdentifier, status, statusReason, statusChanged, intent,
                    category, priority, doNotPerform, medication, subject, informationSource, encounter,
                    supportingInformation, authoredOn, requester, reported, performerType, performer, device,
                    recorder, reason, courseOfTherapyType, insurance, note, renderedDosageInstruction,
                    effectiveDosePeriod, dosageInstruction, dispenseRequest, substitution, eventHistory);
        }
    }
}
