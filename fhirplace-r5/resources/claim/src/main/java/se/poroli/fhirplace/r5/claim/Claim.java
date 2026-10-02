package se.poroli.fhirplace.r5.claim;

import java.math.BigDecimal;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.Use;

/**
 * A provider issued list of professional services and products which have been provided, or are to be provided, to a
 * patient which is sent to an insurer for reimbursement.
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
 * @param identifier Business Identifier for claim.
 * @param traceNumber Number for tracking.
 * @param status active | cancelled | draft | entered-in-error. Required. Modifier element.
 * @param type Category or discipline. Required.
 * @param subType More granular claim type.
 * @param use claim | preauthorization | predetermination. Required.
 * @param patient The recipient of the products and services. Reference to Patient. Required.
 * @param billablePeriod Relevant time frame for the claim.
 * @param created Resource creation date. Required.
 * @param enterer Author of the claim. Reference to Practitioner, PractitionerRole, Patient, RelatedPerson.
 * @param insurer Target. Reference to Organization.
 * @param provider Party responsible for the claim. Reference to Practitioner, PractitionerRole, Organization.
 * @param priority Desired processing urgency.
 * @param fundsReserve For whom to reserve funds.
 * @param related Prior or corollary claims.
 * @param prescription Prescription authorizing services and products. Reference to DeviceRequest, MedicationRequest,
 *   VisionPrescription.
 * @param originalPrescription Original prescription if superseded by fulfiller. Reference to DeviceRequest,
 *   MedicationRequest, VisionPrescription.
 * @param payee Recipient of benefits payable.
 * @param referral Treatment referral. Reference to ServiceRequest.
 * @param encounter Encounters associated with the listed treatments. Reference to Encounter.
 * @param facility Servicing facility. Reference to Location, Organization.
 * @param diagnosisRelatedGroup Package billing code.
 * @param event Event information.
 * @param careTeam Members of the care team.
 * @param supportingInfo Supporting information.
 * @param diagnosis Pertinent diagnosis information.
 * @param procedure Clinical procedures performed.
 * @param insurance Patient insurance information.
 * @param accident Details of the event.
 * @param patientPaid Paid by the patient.
 * @param item Product or service provided.
 * @param total Total claim cost.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Claim">FHIR R5 Claim</a>
 */
public record Claim(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        List<Identifier> traceNumber,
        FhirEnum<FinancialResourceStatusCodes> status,
        CodeableConcept type,
        CodeableConcept subType,
        FhirEnum<Use> use,
        Reference patient,
        Period billablePeriod,
        FhirDateTime created,
        Reference enterer,
        Reference insurer,
        Reference provider,
        CodeableConcept priority,
        CodeableConcept fundsReserve,
        List<RelatedClaim> related,
        Reference prescription,
        Reference originalPrescription,
        Payee payee,
        Reference referral,
        List<Reference> encounter,
        Reference facility,
        CodeableConcept diagnosisRelatedGroup,
        List<Event> event,
        List<CareTeam> careTeam,
        List<SupportingInformation> supportingInfo,
        List<Diagnosis> diagnosis,
        List<Procedure> procedure,
        List<Insurance> insurance,
        Accident accident,
        Money patientPaid,
        List<Item> item,
        Money total) implements DomainResource {

    /**
     * Creates a {@code Claim}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Claim {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
        related = related == null ? List.of() : List.copyOf(related);
        encounter = encounter == null ? List.of() : List.copyOf(encounter);
        event = event == null ? List.of() : List.copyOf(event);
        careTeam = careTeam == null ? List.of() : List.copyOf(careTeam);
        supportingInfo = supportingInfo == null ? List.of() : List.copyOf(supportingInfo);
        diagnosis = diagnosis == null ? List.of() : List.copyOf(diagnosis);
        procedure = procedure == null ? List.of() : List.copyOf(procedure);
        insurance = insurance == null ? List.of() : List.copyOf(insurance);
        item = item == null ? List.of() : List.copyOf(item);
        Objects.requireNonNull(status, "Claim.status is required");
        Objects.requireNonNull(type, "Claim.type is required");
        Objects.requireNonNull(use, "Claim.use is required");
        Objects.requireNonNull(patient, "Claim.patient is required");
        Objects.requireNonNull(created, "Claim.created is required");
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
     * Returns a builder initialized with the values of this {@code Claim}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Other claims which are related to this claim such as prior submissions or claims for related services or for
     * the same event.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param claim Reference to the related claim. Reference to Claim.
     * @param relationship How the reference claim is related.
     * @param reference File or case reference.
     */
    public record RelatedClaim(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference claim,
            CodeableConcept relationship,
            Identifier reference) implements BackboneElement {

        /**
         * Creates a {@code RelatedClaim}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public RelatedClaim {
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
         * Returns a builder initialized with the values of this {@code RelatedClaim}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link RelatedClaim}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference claim;
            private CodeableConcept relationship;
            private Identifier reference;

            private Builder() {
            }

            private Builder(RelatedClaim original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.claim = original.claim();
                this.relationship = original.relationship();
                this.reference = original.reference();
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
             * Sets {@code claim}.
             *
             * @param claim the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder claim(Reference claim) {
                this.claim = claim;
                return this;
            }

            /**
             * Sets {@code relationship}.
             *
             * @param relationship the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder relationship(CodeableConcept relationship) {
                this.relationship = relationship;
                return this;
            }

            /**
             * Sets {@code reference}.
             *
             * @param reference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reference(Identifier reference) {
                this.reference = reference;
                return this;
            }

            /**
             * Builds the {@code RelatedClaim}.
             *
             * @return the {@code RelatedClaim}
             */
            public RelatedClaim build() {
                return new RelatedClaim(
                        id, extension, modifierExtension, claim, relationship, reference);
            }
        }
    }

    /**
     * The party to be reimbursed for cost of the products and services according to the terms of the policy.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Category of recipient. Required.
     * @param party Recipient reference. Reference to Practitioner, PractitionerRole, Organization, Patient,
     *   RelatedPerson.
     */
    public record Payee(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            Reference party) implements BackboneElement {

        /**
         * Creates a {@code Payee}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Payee {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "Claim.payee.type is required");
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
         * Returns a builder initialized with the values of this {@code Payee}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Payee}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private Reference party;

            private Builder() {
            }

            private Builder(Payee original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.party = original.party();
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
             * Sets {@code party}.
             *
             * @param party the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder party(Reference party) {
                this.party = party;
                return this;
            }

            /**
             * Builds the {@code Payee}.
             *
             * @return the {@code Payee}
             * @throws NullPointerException if a required element is absent
             */
            public Payee build() {
                return new Payee(
                        id, extension, modifierExtension, type, party);
            }
        }
    }

    /**
     * Information code for an event with a corresponding date or period.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Specific event. Required.
     * @param when Occurance date or period. One of dateTime, Period. Required.
     */
    public record Event(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType when) implements BackboneElement {

        /**
         * Creates an {@code Event}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Event {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "Claim.event.type is required");
            Objects.requireNonNull(when, "Claim.event.when is required");
            if (when != null && !(when instanceof FhirDateTime || when instanceof Period)) {
                throw new IllegalArgumentException(
                        "Claim.event.when[x] must be one of dateTime, Period, but was "
                                + when.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Event}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Event}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private DataType when;

            private Builder() {
            }

            private Builder(Event original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.when = original.when();
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
             * Sets {@code when} to a dateTime.
             *
             * @param when the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder when(FhirDateTime when) {
                this.when = when;
                return this;
            }

            /**
             * Sets {@code when} to a Period.
             *
             * @param when the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder when(Period when) {
                this.when = when;
                return this;
            }

            /**
             * Sets {@code when} to a dateTime without id or extensions.
             *
             * @param when the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder when(Temporal when) {
                this.when = when == null ? null : FhirDateTime.of(when);
                return this;
            }

            /**
             * Builds the {@code Event}.
             *
             * @return the {@code Event}
             * @throws NullPointerException if a required element is absent
             */
            public Event build() {
                return new Event(
                        id, extension, modifierExtension, type, when);
            }
        }
    }

    /**
     * The members of the team who provided the products and services.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param sequence Order of care team. Required.
     * @param provider Practitioner or organization. Reference to Practitioner, PractitionerRole, Organization.
     *   Required.
     * @param responsible Indicator of the lead practitioner.
     * @param role Function within the team.
     * @param specialty Practitioner or provider specialization.
     */
    public record CareTeam(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            Reference provider,
            FhirBoolean responsible,
            CodeableConcept role,
            CodeableConcept specialty) implements BackboneElement {

        /**
         * Creates a {@code CareTeam}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public CareTeam {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(sequence, "Claim.careTeam.sequence is required");
            Objects.requireNonNull(provider, "Claim.careTeam.provider is required");
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
         * Returns a builder initialized with the values of this {@code CareTeam}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link CareTeam}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt sequence;
            private Reference provider;
            private FhirBoolean responsible;
            private CodeableConcept role;
            private CodeableConcept specialty;

            private Builder() {
            }

            private Builder(CareTeam original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.provider = original.provider();
                this.responsible = original.responsible();
                this.role = original.role();
                this.specialty = original.specialty();
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
             * Sets {@code sequence}.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(FhirPositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Sets {@code sequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(Integer sequence) {
                return sequence(sequence == null ? null : FhirPositiveInt.of(sequence));
            }

            /**
             * Sets {@code provider}.
             *
             * @param provider the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder provider(Reference provider) {
                this.provider = provider;
                return this;
            }

            /**
             * Sets {@code responsible}.
             *
             * @param responsible the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder responsible(FhirBoolean responsible) {
                this.responsible = responsible;
                return this;
            }

            /**
             * Sets {@code responsible}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param responsible the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder responsible(Boolean responsible) {
                return responsible(responsible == null ? null : FhirBoolean.of(responsible));
            }

            /**
             * Sets {@code role}.
             *
             * @param role the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder role(CodeableConcept role) {
                this.role = role;
                return this;
            }

            /**
             * Sets {@code specialty}.
             *
             * @param specialty the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder specialty(CodeableConcept specialty) {
                this.specialty = specialty;
                return this;
            }

            /**
             * Builds the {@code CareTeam}.
             *
             * @return the {@code CareTeam}
             * @throws NullPointerException if a required element is absent
             */
            public CareTeam build() {
                return new CareTeam(
                        id, extension, modifierExtension, sequence, provider, responsible, role, specialty);
            }
        }
    }

    /**
     * Additional information codes regarding exceptions, special considerations, the condition, situation, prior or
     * concurrent issues.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param sequence Information instance identifier. Required.
     * @param category Classification of the supplied information. Required.
     * @param code Type of information.
     * @param timing When it occurred. One of date, Period.
     * @param value Data to be provided. One of boolean, string, Quantity, Attachment, Reference, Identifier.
     * @param reason Explanation for the information.
     */
    public record SupportingInformation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            CodeableConcept category,
            CodeableConcept code,
            DataType timing,
            DataType value,
            CodeableConcept reason) implements BackboneElement {

        /**
         * Creates a {@code SupportingInformation}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public SupportingInformation {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(sequence, "Claim.supportingInfo.sequence is required");
            Objects.requireNonNull(category, "Claim.supportingInfo.category is required");
            if (timing != null && !(timing instanceof FhirDate || timing instanceof Period)) {
                throw new IllegalArgumentException(
                        "Claim.supportingInfo.timing[x] must be one of date, Period, but was "
                                + timing.getClass().getSimpleName());
            }
            if (value != null && !(value instanceof FhirBoolean
                    || value instanceof FhirString
                    || value instanceof Quantity
                    || value instanceof Attachment
                    || value instanceof Reference
                    || value instanceof Identifier)) {
                throw new IllegalArgumentException(
                        "Claim.supportingInfo.value[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code SupportingInformation}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link SupportingInformation}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt sequence;
            private CodeableConcept category;
            private CodeableConcept code;
            private DataType timing;
            private DataType value;
            private CodeableConcept reason;

            private Builder() {
            }

            private Builder(SupportingInformation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.category = original.category();
                this.code = original.code();
                this.timing = original.timing();
                this.value = original.value();
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
             * Sets {@code sequence}.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(FhirPositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Sets {@code sequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(Integer sequence) {
                return sequence(sequence == null ? null : FhirPositiveInt.of(sequence));
            }

            /**
             * Sets {@code category}.
             *
             * @param category the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder category(CodeableConcept category) {
                this.category = category;
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
             * Sets {@code timing} to a date.
             *
             * @param timing the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder timing(FhirDate timing) {
                this.timing = timing;
                return this;
            }

            /**
             * Sets {@code timing} to a Period.
             *
             * @param timing the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder timing(Period timing) {
                this.timing = timing;
                return this;
            }

            /**
             * Sets {@code timing} to a date without id or extensions.
             *
             * @param timing the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder timing(Temporal timing) {
                this.timing = timing == null ? null : FhirDate.of(timing);
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
             * Sets {@code value} to a string.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirString value) {
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
             * Sets {@code value} to a Attachment.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Attachment value) {
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
             * Sets {@code value} to a Identifier.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Identifier value) {
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
             * Sets {@code value} to a string without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(String value) {
                this.value = value == null ? null : FhirString.of(value);
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
             * Builds the {@code SupportingInformation}.
             *
             * @return the {@code SupportingInformation}
             * @throws NullPointerException if a required element is absent
             */
            public SupportingInformation build() {
                return new SupportingInformation(
                        id, extension, modifierExtension, sequence, category, code, timing, value, reason);
            }
        }
    }

    /**
     * Information about diagnoses relevant to the claim items.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param sequence Diagnosis instance identifier. Required.
     * @param diagnosis Nature of illness or problem. One of CodeableConcept, Reference. Required.
     * @param type Timing or nature of the diagnosis.
     * @param onAdmission Present on admission.
     */
    public record Diagnosis(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            DataType diagnosis,
            List<CodeableConcept> type,
            CodeableConcept onAdmission) implements BackboneElement {

        /**
         * Creates a {@code Diagnosis}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Diagnosis {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            type = type == null ? List.of() : List.copyOf(type);
            Objects.requireNonNull(sequence, "Claim.diagnosis.sequence is required");
            Objects.requireNonNull(diagnosis, "Claim.diagnosis.diagnosis is required");
            if (diagnosis != null && !(diagnosis instanceof CodeableConcept || diagnosis instanceof Reference)) {
                throw new IllegalArgumentException(
                        "Claim.diagnosis.diagnosis[x] must be one of CodeableConcept, Reference, but was "
                                + diagnosis.getClass().getSimpleName());
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
            private FhirPositiveInt sequence;
            private DataType diagnosis;
            private List<CodeableConcept> type = new ArrayList<>();
            private CodeableConcept onAdmission;

            private Builder() {
            }

            private Builder(Diagnosis original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.diagnosis = original.diagnosis();
                this.type = new ArrayList<>(original.type());
                this.onAdmission = original.onAdmission();
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
             * Sets {@code sequence}.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(FhirPositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Sets {@code sequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(Integer sequence) {
                return sequence(sequence == null ? null : FhirPositiveInt.of(sequence));
            }

            /**
             * Sets {@code diagnosis} to a CodeableConcept.
             *
             * @param diagnosis the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder diagnosis(CodeableConcept diagnosis) {
                this.diagnosis = diagnosis;
                return this;
            }

            /**
             * Sets {@code diagnosis} to a Reference.
             *
             * @param diagnosis the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder diagnosis(Reference diagnosis) {
                this.diagnosis = diagnosis;
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
             * Sets {@code onAdmission}.
             *
             * @param onAdmission the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder onAdmission(CodeableConcept onAdmission) {
                this.onAdmission = onAdmission;
                return this;
            }

            /**
             * Builds the {@code Diagnosis}.
             *
             * @return the {@code Diagnosis}
             * @throws NullPointerException if a required element is absent
             */
            public Diagnosis build() {
                return new Diagnosis(
                        id, extension, modifierExtension, sequence, diagnosis, type, onAdmission);
            }
        }
    }

    /**
     * Procedures performed on the patient relevant to the billing items with the claim.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param sequence Procedure instance identifier. Required.
     * @param type Category of Procedure.
     * @param date When the procedure was performed.
     * @param procedure Specific clinical procedure. One of CodeableConcept, Reference. Required.
     * @param udi Unique device identifier. Reference to Device.
     */
    public record Procedure(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            List<CodeableConcept> type,
            FhirDateTime date,
            DataType procedure,
            List<Reference> udi) implements BackboneElement {

        /**
         * Creates a {@code Procedure}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Procedure {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            type = type == null ? List.of() : List.copyOf(type);
            udi = udi == null ? List.of() : List.copyOf(udi);
            Objects.requireNonNull(sequence, "Claim.procedure.sequence is required");
            Objects.requireNonNull(procedure, "Claim.procedure.procedure is required");
            if (procedure != null && !(procedure instanceof CodeableConcept || procedure instanceof Reference)) {
                throw new IllegalArgumentException(
                        "Claim.procedure.procedure[x] must be one of CodeableConcept, Reference, but was "
                                + procedure.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Procedure}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Procedure}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt sequence;
            private List<CodeableConcept> type = new ArrayList<>();
            private FhirDateTime date;
            private DataType procedure;
            private List<Reference> udi = new ArrayList<>();

            private Builder() {
            }

            private Builder(Procedure original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.type = new ArrayList<>(original.type());
                this.date = original.date();
                this.procedure = original.procedure();
                this.udi = new ArrayList<>(original.udi());
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
             * Sets {@code sequence}.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(FhirPositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Sets {@code sequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(Integer sequence) {
                return sequence(sequence == null ? null : FhirPositiveInt.of(sequence));
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
             * Sets {@code procedure} to a CodeableConcept.
             *
             * @param procedure the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder procedure(CodeableConcept procedure) {
                this.procedure = procedure;
                return this;
            }

            /**
             * Sets {@code procedure} to a Reference.
             *
             * @param procedure the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder procedure(Reference procedure) {
                this.procedure = procedure;
                return this;
            }

            /**
             * Replaces all {@code udi} values.
             *
             * @param udi the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder udi(List<Reference> udi) {
                this.udi = udi == null ? new ArrayList<>() : new ArrayList<>(udi);
                return this;
            }

            /**
             * Adds a {@code udi} value.
             *
             * @param udi the value to add
             * @return this builder
             */
            public Builder addUdi(Reference udi) {
                this.udi.add(Objects.requireNonNull(udi, "udi"));
                return this;
            }

            /**
             * Builds the {@code Procedure}.
             *
             * @return the {@code Procedure}
             * @throws NullPointerException if a required element is absent
             */
            public Procedure build() {
                return new Procedure(
                        id, extension, modifierExtension, sequence, type, date, procedure, udi);
            }
        }
    }

    /**
     * Financial instruments for reimbursement for the health care products and services specified on the claim.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param sequence Insurance instance identifier. Required.
     * @param focal Coverage to be used for adjudication. Required.
     * @param identifier Pre-assigned Claim number.
     * @param coverage Insurance information. Reference to Coverage. Required.
     * @param businessArrangement Additional provider contract number.
     * @param preAuthRef Prior authorization reference number.
     * @param claimResponse Adjudication results. Reference to ClaimResponse.
     */
    public record Insurance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            FhirBoolean focal,
            Identifier identifier,
            Reference coverage,
            FhirString businessArrangement,
            List<FhirString> preAuthRef,
            Reference claimResponse) implements BackboneElement {

        /**
         * Creates an {@code Insurance}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Insurance {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            preAuthRef = preAuthRef == null ? List.of() : List.copyOf(preAuthRef);
            Objects.requireNonNull(sequence, "Claim.insurance.sequence is required");
            Objects.requireNonNull(focal, "Claim.insurance.focal is required");
            Objects.requireNonNull(coverage, "Claim.insurance.coverage is required");
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
         * Returns a builder initialized with the values of this {@code Insurance}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Insurance}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt sequence;
            private FhirBoolean focal;
            private Identifier identifier;
            private Reference coverage;
            private FhirString businessArrangement;
            private List<FhirString> preAuthRef = new ArrayList<>();
            private Reference claimResponse;

            private Builder() {
            }

            private Builder(Insurance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.focal = original.focal();
                this.identifier = original.identifier();
                this.coverage = original.coverage();
                this.businessArrangement = original.businessArrangement();
                this.preAuthRef = new ArrayList<>(original.preAuthRef());
                this.claimResponse = original.claimResponse();
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
             * Sets {@code sequence}.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(FhirPositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Sets {@code sequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(Integer sequence) {
                return sequence(sequence == null ? null : FhirPositiveInt.of(sequence));
            }

            /**
             * Sets {@code focal}.
             *
             * @param focal the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder focal(FhirBoolean focal) {
                this.focal = focal;
                return this;
            }

            /**
             * Sets {@code focal}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param focal the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder focal(Boolean focal) {
                return focal(focal == null ? null : FhirBoolean.of(focal));
            }

            /**
             * Sets {@code identifier}.
             *
             * @param identifier the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identifier(Identifier identifier) {
                this.identifier = identifier;
                return this;
            }

            /**
             * Sets {@code coverage}.
             *
             * @param coverage the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder coverage(Reference coverage) {
                this.coverage = coverage;
                return this;
            }

            /**
             * Sets {@code businessArrangement}.
             *
             * @param businessArrangement the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder businessArrangement(FhirString businessArrangement) {
                this.businessArrangement = businessArrangement;
                return this;
            }

            /**
             * Sets {@code businessArrangement}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param businessArrangement the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder businessArrangement(String businessArrangement) {
                return businessArrangement(businessArrangement == null ? null : FhirString.of(businessArrangement));
            }

            /**
             * Replaces all {@code preAuthRef} values.
             *
             * @param preAuthRef the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder preAuthRef(List<FhirString> preAuthRef) {
                this.preAuthRef = preAuthRef == null ? new ArrayList<>() : new ArrayList<>(preAuthRef);
                return this;
            }

            /**
             * Adds a {@code preAuthRef} value.
             *
             * @param preAuthRef the value to add
             * @return this builder
             */
            public Builder addPreAuthRef(FhirString preAuthRef) {
                this.preAuthRef.add(Objects.requireNonNull(preAuthRef, "preAuthRef"));
                return this;
            }

            /**
             * Adds a {@code preAuthRef} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param preAuthRef the value to add
             * @return this builder
             */
            public Builder addPreAuthRef(String preAuthRef) {
                return addPreAuthRef(FhirString.of(preAuthRef));
            }

            /**
             * Sets {@code claimResponse}.
             *
             * @param claimResponse the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder claimResponse(Reference claimResponse) {
                this.claimResponse = claimResponse;
                return this;
            }

            /**
             * Builds the {@code Insurance}.
             *
             * @return the {@code Insurance}
             * @throws NullPointerException if a required element is absent
             */
            public Insurance build() {
                return new Insurance(
                        id, extension, modifierExtension, sequence, focal, identifier, coverage, businessArrangement,
                        preAuthRef, claimResponse);
            }
        }
    }

    /**
     * Details of an accident which resulted in injuries which required the products and services listed in the claim.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param date When the incident occurred. Required.
     * @param type The nature of the accident.
     * @param location Where the event occurred. One of Address, Reference.
     */
    public record Accident(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirDate date,
            CodeableConcept type,
            DataType location) implements BackboneElement {

        /**
         * Creates an {@code Accident}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Accident {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(date, "Claim.accident.date is required");
            if (location != null && !(location instanceof Address || location instanceof Reference)) {
                throw new IllegalArgumentException(
                        "Claim.accident.location[x] must be one of Address, Reference, but was "
                                + location.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Accident}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Accident}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirDate date;
            private CodeableConcept type;
            private DataType location;

            private Builder() {
            }

            private Builder(Accident original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.date = original.date();
                this.type = original.type();
                this.location = original.location();
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
            public Builder date(FhirDate date) {
                this.date = date;
                return this;
            }

            /**
             * Sets {@code date}, wrapped in a {@link FhirDate} without id or extensions.
             *
             * @param date the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder date(Temporal date) {
                return date(date == null ? null : FhirDate.of(date));
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
             * Sets {@code location} to a Address.
             *
             * @param location the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder location(Address location) {
                this.location = location;
                return this;
            }

            /**
             * Sets {@code location} to a Reference.
             *
             * @param location the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder location(Reference location) {
                this.location = location;
                return this;
            }

            /**
             * Builds the {@code Accident}.
             *
             * @return the {@code Accident}
             * @throws NullPointerException if a required element is absent
             */
            public Accident build() {
                return new Accident(
                        id, extension, modifierExtension, date, type, location);
            }
        }
    }

    /**
     * A claim line.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param sequence Item instance identifier. Required.
     * @param traceNumber Number for tracking.
     * @param careTeamSequence Applicable careTeam members.
     * @param diagnosisSequence Applicable diagnoses.
     * @param procedureSequence Applicable procedures.
     * @param informationSequence Applicable exception and supporting information.
     * @param revenue Revenue or cost center code.
     * @param category Benefit classification.
     * @param productOrService Billing, service, product, or drug code.
     * @param productOrServiceEnd End of a range of codes.
     * @param request Request or Referral for Service. Reference to DeviceRequest, MedicationRequest, NutritionOrder,
     *   ServiceRequest, SupplyRequest, VisionPrescription.
     * @param modifier Product or service billing modifiers.
     * @param programCode Program the product or service is provided under.
     * @param serviced Date or dates of service or product delivery. One of date, Period.
     * @param location Place of service or where product was supplied. One of CodeableConcept, Address, Reference.
     * @param patientPaid Paid by the patient.
     * @param quantity Count of products or services.
     * @param unitPrice Fee, charge or cost per item.
     * @param factor Price scaling factor.
     * @param tax Total tax.
     * @param net Total item cost.
     * @param udi Unique device identifier. Reference to Device.
     * @param bodySite Anatomical location.
     * @param encounter Encounters associated with the listed treatments. Reference to Encounter.
     * @param detail Product or service provided.
     */
    public record Item(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            List<Identifier> traceNumber,
            List<FhirPositiveInt> careTeamSequence,
            List<FhirPositiveInt> diagnosisSequence,
            List<FhirPositiveInt> procedureSequence,
            List<FhirPositiveInt> informationSequence,
            CodeableConcept revenue,
            CodeableConcept category,
            CodeableConcept productOrService,
            CodeableConcept productOrServiceEnd,
            List<Reference> request,
            List<CodeableConcept> modifier,
            List<CodeableConcept> programCode,
            DataType serviced,
            DataType location,
            Money patientPaid,
            Quantity quantity,
            Money unitPrice,
            FhirDecimal factor,
            Money tax,
            Money net,
            List<Reference> udi,
            List<BodySite> bodySite,
            List<Reference> encounter,
            List<Detail> detail) implements BackboneElement {

        /**
         * Creates an {@code Item}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Item {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
            careTeamSequence = careTeamSequence == null ? List.of() : List.copyOf(careTeamSequence);
            diagnosisSequence = diagnosisSequence == null ? List.of() : List.copyOf(diagnosisSequence);
            procedureSequence = procedureSequence == null ? List.of() : List.copyOf(procedureSequence);
            informationSequence = informationSequence == null ? List.of() : List.copyOf(informationSequence);
            request = request == null ? List.of() : List.copyOf(request);
            modifier = modifier == null ? List.of() : List.copyOf(modifier);
            programCode = programCode == null ? List.of() : List.copyOf(programCode);
            udi = udi == null ? List.of() : List.copyOf(udi);
            bodySite = bodySite == null ? List.of() : List.copyOf(bodySite);
            encounter = encounter == null ? List.of() : List.copyOf(encounter);
            detail = detail == null ? List.of() : List.copyOf(detail);
            Objects.requireNonNull(sequence, "Claim.item.sequence is required");
            if (serviced != null && !(serviced instanceof FhirDate || serviced instanceof Period)) {
                throw new IllegalArgumentException(
                        "Claim.item.serviced[x] must be one of date, Period, but was "
                                + serviced.getClass().getSimpleName());
            }
            if (location != null && !(location instanceof CodeableConcept
                    || location instanceof Address
                    || location instanceof Reference)) {
                throw new IllegalArgumentException(
                        "Claim.item.location[x] must be one of CodeableConcept, Address, Reference, but was "
                                + location.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Item}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Physical location where the service is performed or applies.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param site Location. Required.
         * @param subSite Sub-location.
         */
        public record BodySite(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<CodeableReference> site,
                List<CodeableConcept> subSite) implements BackboneElement {

            /**
             * Creates a {@code BodySite}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a required list is empty
             */
            public BodySite {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                site = site == null ? List.of() : List.copyOf(site);
                subSite = subSite == null ? List.of() : List.copyOf(subSite);
                if (site.isEmpty()) {
                    throw new IllegalArgumentException("Claim.item.bodySite.site requires at least one value");
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
             * Returns a builder initialized with the values of this {@code BodySite}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link BodySite}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<CodeableReference> site = new ArrayList<>();
                private List<CodeableConcept> subSite = new ArrayList<>();

                private Builder() {
                }

                private Builder(BodySite original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.site = new ArrayList<>(original.site());
                    this.subSite = new ArrayList<>(original.subSite());
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
                 * Replaces all {@code site} values.
                 *
                 * @param site the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder site(List<CodeableReference> site) {
                    this.site = site == null ? new ArrayList<>() : new ArrayList<>(site);
                    return this;
                }

                /**
                 * Adds a {@code site} value.
                 *
                 * @param site the value to add
                 * @return this builder
                 */
                public Builder addSite(CodeableReference site) {
                    this.site.add(Objects.requireNonNull(site, "site"));
                    return this;
                }

                /**
                 * Replaces all {@code subSite} values.
                 *
                 * @param subSite the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder subSite(List<CodeableConcept> subSite) {
                    this.subSite = subSite == null ? new ArrayList<>() : new ArrayList<>(subSite);
                    return this;
                }

                /**
                 * Adds a {@code subSite} value.
                 *
                 * @param subSite the value to add
                 * @return this builder
                 */
                public Builder addSubSite(CodeableConcept subSite) {
                    this.subSite.add(Objects.requireNonNull(subSite, "subSite"));
                    return this;
                }

                /**
                 * Builds the {@code BodySite}.
                 *
                 * @return the {@code BodySite}
                 * @throws NullPointerException if a required element is absent
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public BodySite build() {
                    return new BodySite(
                            id, extension, modifierExtension, site, subSite);
                }
            }
        }

        /**
         * A claim detail line.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param sequence Item instance identifier. Required.
         * @param traceNumber Number for tracking.
         * @param revenue Revenue or cost center code.
         * @param category Benefit classification.
         * @param productOrService Billing, service, product, or drug code.
         * @param productOrServiceEnd End of a range of codes.
         * @param modifier Service/Product billing modifiers.
         * @param programCode Program the product or service is provided under.
         * @param patientPaid Paid by the patient.
         * @param quantity Count of products or services.
         * @param unitPrice Fee, charge or cost per item.
         * @param factor Price scaling factor.
         * @param tax Total tax.
         * @param net Total item cost.
         * @param udi Unique device identifier. Reference to Device.
         * @param subDetail Product or service provided.
         */
        public record Detail(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirPositiveInt sequence,
                List<Identifier> traceNumber,
                CodeableConcept revenue,
                CodeableConcept category,
                CodeableConcept productOrService,
                CodeableConcept productOrServiceEnd,
                List<CodeableConcept> modifier,
                List<CodeableConcept> programCode,
                Money patientPaid,
                Quantity quantity,
                Money unitPrice,
                FhirDecimal factor,
                Money tax,
                Money net,
                List<Reference> udi,
                List<SubDetail> subDetail) implements BackboneElement {

            /**
             * Creates a {@code Detail}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Detail {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
                modifier = modifier == null ? List.of() : List.copyOf(modifier);
                programCode = programCode == null ? List.of() : List.copyOf(programCode);
                udi = udi == null ? List.of() : List.copyOf(udi);
                subDetail = subDetail == null ? List.of() : List.copyOf(subDetail);
                Objects.requireNonNull(sequence, "Claim.item.detail.sequence is required");
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
             * Returns a builder initialized with the values of this {@code Detail}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * A claim detail line.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param sequence Item instance identifier. Required.
             * @param traceNumber Number for tracking.
             * @param revenue Revenue or cost center code.
             * @param category Benefit classification.
             * @param productOrService Billing, service, product, or drug code.
             * @param productOrServiceEnd End of a range of codes.
             * @param modifier Service/Product billing modifiers.
             * @param programCode Program the product or service is provided under.
             * @param patientPaid Paid by the patient.
             * @param quantity Count of products or services.
             * @param unitPrice Fee, charge or cost per item.
             * @param factor Price scaling factor.
             * @param tax Total tax.
             * @param net Total item cost.
             * @param udi Unique device identifier. Reference to Device.
             */
            public record SubDetail(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirPositiveInt sequence,
                    List<Identifier> traceNumber,
                    CodeableConcept revenue,
                    CodeableConcept category,
                    CodeableConcept productOrService,
                    CodeableConcept productOrServiceEnd,
                    List<CodeableConcept> modifier,
                    List<CodeableConcept> programCode,
                    Money patientPaid,
                    Quantity quantity,
                    Money unitPrice,
                    FhirDecimal factor,
                    Money tax,
                    Money net,
                    List<Reference> udi) implements BackboneElement {

                /**
                 * Creates a {@code SubDetail}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public SubDetail {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
                    modifier = modifier == null ? List.of() : List.copyOf(modifier);
                    programCode = programCode == null ? List.of() : List.copyOf(programCode);
                    udi = udi == null ? List.of() : List.copyOf(udi);
                    Objects.requireNonNull(sequence, "Claim.item.detail.subDetail.sequence is required");
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
                 * Returns a builder initialized with the values of this {@code SubDetail}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link SubDetail}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirPositiveInt sequence;
                    private List<Identifier> traceNumber = new ArrayList<>();
                    private CodeableConcept revenue;
                    private CodeableConcept category;
                    private CodeableConcept productOrService;
                    private CodeableConcept productOrServiceEnd;
                    private List<CodeableConcept> modifier = new ArrayList<>();
                    private List<CodeableConcept> programCode = new ArrayList<>();
                    private Money patientPaid;
                    private Quantity quantity;
                    private Money unitPrice;
                    private FhirDecimal factor;
                    private Money tax;
                    private Money net;
                    private List<Reference> udi = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(SubDetail original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.sequence = original.sequence();
                        this.traceNumber = new ArrayList<>(original.traceNumber());
                        this.revenue = original.revenue();
                        this.category = original.category();
                        this.productOrService = original.productOrService();
                        this.productOrServiceEnd = original.productOrServiceEnd();
                        this.modifier = new ArrayList<>(original.modifier());
                        this.programCode = new ArrayList<>(original.programCode());
                        this.patientPaid = original.patientPaid();
                        this.quantity = original.quantity();
                        this.unitPrice = original.unitPrice();
                        this.factor = original.factor();
                        this.tax = original.tax();
                        this.net = original.net();
                        this.udi = new ArrayList<>(original.udi());
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
                     * Sets {@code sequence}.
                     *
                     * @param sequence the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder sequence(FhirPositiveInt sequence) {
                        this.sequence = sequence;
                        return this;
                    }

                    /**
                     * Sets {@code sequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
                     *
                     * @param sequence the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder sequence(Integer sequence) {
                        return sequence(sequence == null ? null : FhirPositiveInt.of(sequence));
                    }

                    /**
                     * Replaces all {@code traceNumber} values.
                     *
                     * @param traceNumber the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder traceNumber(List<Identifier> traceNumber) {
                        this.traceNumber = traceNumber == null ? new ArrayList<>() : new ArrayList<>(traceNumber);
                        return this;
                    }

                    /**
                     * Adds a {@code traceNumber} value.
                     *
                     * @param traceNumber the value to add
                     * @return this builder
                     */
                    public Builder addTraceNumber(Identifier traceNumber) {
                        this.traceNumber.add(Objects.requireNonNull(traceNumber, "traceNumber"));
                        return this;
                    }

                    /**
                     * Sets {@code revenue}.
                     *
                     * @param revenue the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder revenue(CodeableConcept revenue) {
                        this.revenue = revenue;
                        return this;
                    }

                    /**
                     * Sets {@code category}.
                     *
                     * @param category the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder category(CodeableConcept category) {
                        this.category = category;
                        return this;
                    }

                    /**
                     * Sets {@code productOrService}.
                     *
                     * @param productOrService the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder productOrService(CodeableConcept productOrService) {
                        this.productOrService = productOrService;
                        return this;
                    }

                    /**
                     * Sets {@code productOrServiceEnd}.
                     *
                     * @param productOrServiceEnd the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder productOrServiceEnd(CodeableConcept productOrServiceEnd) {
                        this.productOrServiceEnd = productOrServiceEnd;
                        return this;
                    }

                    /**
                     * Replaces all {@code modifier} values.
                     *
                     * @param modifier the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder modifier(List<CodeableConcept> modifier) {
                        this.modifier = modifier == null ? new ArrayList<>() : new ArrayList<>(modifier);
                        return this;
                    }

                    /**
                     * Adds a {@code modifier} value.
                     *
                     * @param modifier the value to add
                     * @return this builder
                     */
                    public Builder addModifier(CodeableConcept modifier) {
                        this.modifier.add(Objects.requireNonNull(modifier, "modifier"));
                        return this;
                    }

                    /**
                     * Replaces all {@code programCode} values.
                     *
                     * @param programCode the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder programCode(List<CodeableConcept> programCode) {
                        this.programCode = programCode == null ? new ArrayList<>() : new ArrayList<>(programCode);
                        return this;
                    }

                    /**
                     * Adds a {@code programCode} value.
                     *
                     * @param programCode the value to add
                     * @return this builder
                     */
                    public Builder addProgramCode(CodeableConcept programCode) {
                        this.programCode.add(Objects.requireNonNull(programCode, "programCode"));
                        return this;
                    }

                    /**
                     * Sets {@code patientPaid}.
                     *
                     * @param patientPaid the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder patientPaid(Money patientPaid) {
                        this.patientPaid = patientPaid;
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
                     * Sets {@code unitPrice}.
                     *
                     * @param unitPrice the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder unitPrice(Money unitPrice) {
                        this.unitPrice = unitPrice;
                        return this;
                    }

                    /**
                     * Sets {@code factor}.
                     *
                     * @param factor the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder factor(FhirDecimal factor) {
                        this.factor = factor;
                        return this;
                    }

                    /**
                     * Sets {@code factor}, wrapped in a {@link FhirDecimal} without id or extensions.
                     *
                     * @param factor the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder factor(BigDecimal factor) {
                        return factor(factor == null ? null : FhirDecimal.of(factor));
                    }

                    /**
                     * Sets {@code tax}.
                     *
                     * @param tax the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder tax(Money tax) {
                        this.tax = tax;
                        return this;
                    }

                    /**
                     * Sets {@code net}.
                     *
                     * @param net the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder net(Money net) {
                        this.net = net;
                        return this;
                    }

                    /**
                     * Replaces all {@code udi} values.
                     *
                     * @param udi the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder udi(List<Reference> udi) {
                        this.udi = udi == null ? new ArrayList<>() : new ArrayList<>(udi);
                        return this;
                    }

                    /**
                     * Adds a {@code udi} value.
                     *
                     * @param udi the value to add
                     * @return this builder
                     */
                    public Builder addUdi(Reference udi) {
                        this.udi.add(Objects.requireNonNull(udi, "udi"));
                        return this;
                    }

                    /**
                     * Builds the {@code SubDetail}.
                     *
                     * @return the {@code SubDetail}
                     * @throws NullPointerException if a required element is absent
                     */
                    public SubDetail build() {
                        return new SubDetail(
                                id, extension, modifierExtension, sequence, traceNumber, revenue, category,
                                productOrService, productOrServiceEnd, modifier, programCode, patientPaid, quantity,
                                unitPrice, factor, tax, net, udi);
                    }
                }
            }

            /** Builder for {@link Detail}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirPositiveInt sequence;
                private List<Identifier> traceNumber = new ArrayList<>();
                private CodeableConcept revenue;
                private CodeableConcept category;
                private CodeableConcept productOrService;
                private CodeableConcept productOrServiceEnd;
                private List<CodeableConcept> modifier = new ArrayList<>();
                private List<CodeableConcept> programCode = new ArrayList<>();
                private Money patientPaid;
                private Quantity quantity;
                private Money unitPrice;
                private FhirDecimal factor;
                private Money tax;
                private Money net;
                private List<Reference> udi = new ArrayList<>();
                private List<SubDetail> subDetail = new ArrayList<>();

                private Builder() {
                }

                private Builder(Detail original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.sequence = original.sequence();
                    this.traceNumber = new ArrayList<>(original.traceNumber());
                    this.revenue = original.revenue();
                    this.category = original.category();
                    this.productOrService = original.productOrService();
                    this.productOrServiceEnd = original.productOrServiceEnd();
                    this.modifier = new ArrayList<>(original.modifier());
                    this.programCode = new ArrayList<>(original.programCode());
                    this.patientPaid = original.patientPaid();
                    this.quantity = original.quantity();
                    this.unitPrice = original.unitPrice();
                    this.factor = original.factor();
                    this.tax = original.tax();
                    this.net = original.net();
                    this.udi = new ArrayList<>(original.udi());
                    this.subDetail = new ArrayList<>(original.subDetail());
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
                 * Sets {@code sequence}.
                 *
                 * @param sequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder sequence(FhirPositiveInt sequence) {
                    this.sequence = sequence;
                    return this;
                }

                /**
                 * Sets {@code sequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param sequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder sequence(Integer sequence) {
                    return sequence(sequence == null ? null : FhirPositiveInt.of(sequence));
                }

                /**
                 * Replaces all {@code traceNumber} values.
                 *
                 * @param traceNumber the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder traceNumber(List<Identifier> traceNumber) {
                    this.traceNumber = traceNumber == null ? new ArrayList<>() : new ArrayList<>(traceNumber);
                    return this;
                }

                /**
                 * Adds a {@code traceNumber} value.
                 *
                 * @param traceNumber the value to add
                 * @return this builder
                 */
                public Builder addTraceNumber(Identifier traceNumber) {
                    this.traceNumber.add(Objects.requireNonNull(traceNumber, "traceNumber"));
                    return this;
                }

                /**
                 * Sets {@code revenue}.
                 *
                 * @param revenue the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder revenue(CodeableConcept revenue) {
                    this.revenue = revenue;
                    return this;
                }

                /**
                 * Sets {@code category}.
                 *
                 * @param category the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder category(CodeableConcept category) {
                    this.category = category;
                    return this;
                }

                /**
                 * Sets {@code productOrService}.
                 *
                 * @param productOrService the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder productOrService(CodeableConcept productOrService) {
                    this.productOrService = productOrService;
                    return this;
                }

                /**
                 * Sets {@code productOrServiceEnd}.
                 *
                 * @param productOrServiceEnd the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder productOrServiceEnd(CodeableConcept productOrServiceEnd) {
                    this.productOrServiceEnd = productOrServiceEnd;
                    return this;
                }

                /**
                 * Replaces all {@code modifier} values.
                 *
                 * @param modifier the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder modifier(List<CodeableConcept> modifier) {
                    this.modifier = modifier == null ? new ArrayList<>() : new ArrayList<>(modifier);
                    return this;
                }

                /**
                 * Adds a {@code modifier} value.
                 *
                 * @param modifier the value to add
                 * @return this builder
                 */
                public Builder addModifier(CodeableConcept modifier) {
                    this.modifier.add(Objects.requireNonNull(modifier, "modifier"));
                    return this;
                }

                /**
                 * Replaces all {@code programCode} values.
                 *
                 * @param programCode the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder programCode(List<CodeableConcept> programCode) {
                    this.programCode = programCode == null ? new ArrayList<>() : new ArrayList<>(programCode);
                    return this;
                }

                /**
                 * Adds a {@code programCode} value.
                 *
                 * @param programCode the value to add
                 * @return this builder
                 */
                public Builder addProgramCode(CodeableConcept programCode) {
                    this.programCode.add(Objects.requireNonNull(programCode, "programCode"));
                    return this;
                }

                /**
                 * Sets {@code patientPaid}.
                 *
                 * @param patientPaid the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder patientPaid(Money patientPaid) {
                    this.patientPaid = patientPaid;
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
                 * Sets {@code unitPrice}.
                 *
                 * @param unitPrice the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder unitPrice(Money unitPrice) {
                    this.unitPrice = unitPrice;
                    return this;
                }

                /**
                 * Sets {@code factor}.
                 *
                 * @param factor the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder factor(FhirDecimal factor) {
                    this.factor = factor;
                    return this;
                }

                /**
                 * Sets {@code factor}, wrapped in a {@link FhirDecimal} without id or extensions.
                 *
                 * @param factor the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder factor(BigDecimal factor) {
                    return factor(factor == null ? null : FhirDecimal.of(factor));
                }

                /**
                 * Sets {@code tax}.
                 *
                 * @param tax the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder tax(Money tax) {
                    this.tax = tax;
                    return this;
                }

                /**
                 * Sets {@code net}.
                 *
                 * @param net the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder net(Money net) {
                    this.net = net;
                    return this;
                }

                /**
                 * Replaces all {@code udi} values.
                 *
                 * @param udi the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder udi(List<Reference> udi) {
                    this.udi = udi == null ? new ArrayList<>() : new ArrayList<>(udi);
                    return this;
                }

                /**
                 * Adds a {@code udi} value.
                 *
                 * @param udi the value to add
                 * @return this builder
                 */
                public Builder addUdi(Reference udi) {
                    this.udi.add(Objects.requireNonNull(udi, "udi"));
                    return this;
                }

                /**
                 * Replaces all {@code subDetail} values.
                 *
                 * @param subDetail the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder subDetail(List<SubDetail> subDetail) {
                    this.subDetail = subDetail == null ? new ArrayList<>() : new ArrayList<>(subDetail);
                    return this;
                }

                /**
                 * Adds a {@code subDetail} value.
                 *
                 * @param subDetail the value to add
                 * @return this builder
                 */
                public Builder addSubDetail(SubDetail subDetail) {
                    this.subDetail.add(Objects.requireNonNull(subDetail, "subDetail"));
                    return this;
                }

                /**
                 * Builds the {@code Detail}.
                 *
                 * @return the {@code Detail}
                 * @throws NullPointerException if a required element is absent
                 */
                public Detail build() {
                    return new Detail(
                            id, extension, modifierExtension, sequence, traceNumber, revenue, category,
                            productOrService, productOrServiceEnd, modifier, programCode, patientPaid, quantity,
                            unitPrice, factor, tax, net, udi, subDetail);
                }
            }
        }

        /** Builder for {@link Item}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt sequence;
            private List<Identifier> traceNumber = new ArrayList<>();
            private List<FhirPositiveInt> careTeamSequence = new ArrayList<>();
            private List<FhirPositiveInt> diagnosisSequence = new ArrayList<>();
            private List<FhirPositiveInt> procedureSequence = new ArrayList<>();
            private List<FhirPositiveInt> informationSequence = new ArrayList<>();
            private CodeableConcept revenue;
            private CodeableConcept category;
            private CodeableConcept productOrService;
            private CodeableConcept productOrServiceEnd;
            private List<Reference> request = new ArrayList<>();
            private List<CodeableConcept> modifier = new ArrayList<>();
            private List<CodeableConcept> programCode = new ArrayList<>();
            private DataType serviced;
            private DataType location;
            private Money patientPaid;
            private Quantity quantity;
            private Money unitPrice;
            private FhirDecimal factor;
            private Money tax;
            private Money net;
            private List<Reference> udi = new ArrayList<>();
            private List<BodySite> bodySite = new ArrayList<>();
            private List<Reference> encounter = new ArrayList<>();
            private List<Detail> detail = new ArrayList<>();

            private Builder() {
            }

            private Builder(Item original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.traceNumber = new ArrayList<>(original.traceNumber());
                this.careTeamSequence = new ArrayList<>(original.careTeamSequence());
                this.diagnosisSequence = new ArrayList<>(original.diagnosisSequence());
                this.procedureSequence = new ArrayList<>(original.procedureSequence());
                this.informationSequence = new ArrayList<>(original.informationSequence());
                this.revenue = original.revenue();
                this.category = original.category();
                this.productOrService = original.productOrService();
                this.productOrServiceEnd = original.productOrServiceEnd();
                this.request = new ArrayList<>(original.request());
                this.modifier = new ArrayList<>(original.modifier());
                this.programCode = new ArrayList<>(original.programCode());
                this.serviced = original.serviced();
                this.location = original.location();
                this.patientPaid = original.patientPaid();
                this.quantity = original.quantity();
                this.unitPrice = original.unitPrice();
                this.factor = original.factor();
                this.tax = original.tax();
                this.net = original.net();
                this.udi = new ArrayList<>(original.udi());
                this.bodySite = new ArrayList<>(original.bodySite());
                this.encounter = new ArrayList<>(original.encounter());
                this.detail = new ArrayList<>(original.detail());
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
             * Sets {@code sequence}.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(FhirPositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Sets {@code sequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(Integer sequence) {
                return sequence(sequence == null ? null : FhirPositiveInt.of(sequence));
            }

            /**
             * Replaces all {@code traceNumber} values.
             *
             * @param traceNumber the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder traceNumber(List<Identifier> traceNumber) {
                this.traceNumber = traceNumber == null ? new ArrayList<>() : new ArrayList<>(traceNumber);
                return this;
            }

            /**
             * Adds a {@code traceNumber} value.
             *
             * @param traceNumber the value to add
             * @return this builder
             */
            public Builder addTraceNumber(Identifier traceNumber) {
                this.traceNumber.add(Objects.requireNonNull(traceNumber, "traceNumber"));
                return this;
            }

            /**
             * Replaces all {@code careTeamSequence} values.
             *
             * @param careTeamSequence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder careTeamSequence(List<FhirPositiveInt> careTeamSequence) {
                this.careTeamSequence = careTeamSequence == null
                        ? new ArrayList<>()
                        : new ArrayList<>(careTeamSequence);
                return this;
            }

            /**
             * Adds a {@code careTeamSequence} value.
             *
             * @param careTeamSequence the value to add
             * @return this builder
             */
            public Builder addCareTeamSequence(FhirPositiveInt careTeamSequence) {
                this.careTeamSequence.add(Objects.requireNonNull(careTeamSequence, "careTeamSequence"));
                return this;
            }

            /**
             * Adds a {@code careTeamSequence} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param careTeamSequence the value to add
             * @return this builder
             */
            public Builder addCareTeamSequence(Integer careTeamSequence) {
                return addCareTeamSequence(FhirPositiveInt.of(careTeamSequence));
            }

            /**
             * Replaces all {@code diagnosisSequence} values.
             *
             * @param diagnosisSequence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder diagnosisSequence(List<FhirPositiveInt> diagnosisSequence) {
                this.diagnosisSequence = diagnosisSequence == null
                        ? new ArrayList<>()
                        : new ArrayList<>(diagnosisSequence);
                return this;
            }

            /**
             * Adds a {@code diagnosisSequence} value.
             *
             * @param diagnosisSequence the value to add
             * @return this builder
             */
            public Builder addDiagnosisSequence(FhirPositiveInt diagnosisSequence) {
                this.diagnosisSequence.add(Objects.requireNonNull(diagnosisSequence, "diagnosisSequence"));
                return this;
            }

            /**
             * Adds a {@code diagnosisSequence} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param diagnosisSequence the value to add
             * @return this builder
             */
            public Builder addDiagnosisSequence(Integer diagnosisSequence) {
                return addDiagnosisSequence(FhirPositiveInt.of(diagnosisSequence));
            }

            /**
             * Replaces all {@code procedureSequence} values.
             *
             * @param procedureSequence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder procedureSequence(List<FhirPositiveInt> procedureSequence) {
                this.procedureSequence = procedureSequence == null
                        ? new ArrayList<>()
                        : new ArrayList<>(procedureSequence);
                return this;
            }

            /**
             * Adds a {@code procedureSequence} value.
             *
             * @param procedureSequence the value to add
             * @return this builder
             */
            public Builder addProcedureSequence(FhirPositiveInt procedureSequence) {
                this.procedureSequence.add(Objects.requireNonNull(procedureSequence, "procedureSequence"));
                return this;
            }

            /**
             * Adds a {@code procedureSequence} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param procedureSequence the value to add
             * @return this builder
             */
            public Builder addProcedureSequence(Integer procedureSequence) {
                return addProcedureSequence(FhirPositiveInt.of(procedureSequence));
            }

            /**
             * Replaces all {@code informationSequence} values.
             *
             * @param informationSequence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder informationSequence(List<FhirPositiveInt> informationSequence) {
                this.informationSequence = informationSequence == null
                        ? new ArrayList<>()
                        : new ArrayList<>(informationSequence);
                return this;
            }

            /**
             * Adds a {@code informationSequence} value.
             *
             * @param informationSequence the value to add
             * @return this builder
             */
            public Builder addInformationSequence(FhirPositiveInt informationSequence) {
                this.informationSequence.add(Objects.requireNonNull(informationSequence, "informationSequence"));
                return this;
            }

            /**
             * Adds a {@code informationSequence} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param informationSequence the value to add
             * @return this builder
             */
            public Builder addInformationSequence(Integer informationSequence) {
                return addInformationSequence(FhirPositiveInt.of(informationSequence));
            }

            /**
             * Sets {@code revenue}.
             *
             * @param revenue the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder revenue(CodeableConcept revenue) {
                this.revenue = revenue;
                return this;
            }

            /**
             * Sets {@code category}.
             *
             * @param category the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder category(CodeableConcept category) {
                this.category = category;
                return this;
            }

            /**
             * Sets {@code productOrService}.
             *
             * @param productOrService the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder productOrService(CodeableConcept productOrService) {
                this.productOrService = productOrService;
                return this;
            }

            /**
             * Sets {@code productOrServiceEnd}.
             *
             * @param productOrServiceEnd the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder productOrServiceEnd(CodeableConcept productOrServiceEnd) {
                this.productOrServiceEnd = productOrServiceEnd;
                return this;
            }

            /**
             * Replaces all {@code request} values.
             *
             * @param request the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder request(List<Reference> request) {
                this.request = request == null ? new ArrayList<>() : new ArrayList<>(request);
                return this;
            }

            /**
             * Adds a {@code request} value.
             *
             * @param request the value to add
             * @return this builder
             */
            public Builder addRequest(Reference request) {
                this.request.add(Objects.requireNonNull(request, "request"));
                return this;
            }

            /**
             * Replaces all {@code modifier} values.
             *
             * @param modifier the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder modifier(List<CodeableConcept> modifier) {
                this.modifier = modifier == null ? new ArrayList<>() : new ArrayList<>(modifier);
                return this;
            }

            /**
             * Adds a {@code modifier} value.
             *
             * @param modifier the value to add
             * @return this builder
             */
            public Builder addModifier(CodeableConcept modifier) {
                this.modifier.add(Objects.requireNonNull(modifier, "modifier"));
                return this;
            }

            /**
             * Replaces all {@code programCode} values.
             *
             * @param programCode the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder programCode(List<CodeableConcept> programCode) {
                this.programCode = programCode == null ? new ArrayList<>() : new ArrayList<>(programCode);
                return this;
            }

            /**
             * Adds a {@code programCode} value.
             *
             * @param programCode the value to add
             * @return this builder
             */
            public Builder addProgramCode(CodeableConcept programCode) {
                this.programCode.add(Objects.requireNonNull(programCode, "programCode"));
                return this;
            }

            /**
             * Sets {@code serviced} to a date.
             *
             * @param serviced the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder serviced(FhirDate serviced) {
                this.serviced = serviced;
                return this;
            }

            /**
             * Sets {@code serviced} to a Period.
             *
             * @param serviced the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder serviced(Period serviced) {
                this.serviced = serviced;
                return this;
            }

            /**
             * Sets {@code serviced} to a date without id or extensions.
             *
             * @param serviced the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder serviced(Temporal serviced) {
                this.serviced = serviced == null ? null : FhirDate.of(serviced);
                return this;
            }

            /**
             * Sets {@code location} to a CodeableConcept.
             *
             * @param location the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder location(CodeableConcept location) {
                this.location = location;
                return this;
            }

            /**
             * Sets {@code location} to a Address.
             *
             * @param location the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder location(Address location) {
                this.location = location;
                return this;
            }

            /**
             * Sets {@code location} to a Reference.
             *
             * @param location the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder location(Reference location) {
                this.location = location;
                return this;
            }

            /**
             * Sets {@code patientPaid}.
             *
             * @param patientPaid the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder patientPaid(Money patientPaid) {
                this.patientPaid = patientPaid;
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
             * Sets {@code unitPrice}.
             *
             * @param unitPrice the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder unitPrice(Money unitPrice) {
                this.unitPrice = unitPrice;
                return this;
            }

            /**
             * Sets {@code factor}.
             *
             * @param factor the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder factor(FhirDecimal factor) {
                this.factor = factor;
                return this;
            }

            /**
             * Sets {@code factor}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param factor the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder factor(BigDecimal factor) {
                return factor(factor == null ? null : FhirDecimal.of(factor));
            }

            /**
             * Sets {@code tax}.
             *
             * @param tax the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder tax(Money tax) {
                this.tax = tax;
                return this;
            }

            /**
             * Sets {@code net}.
             *
             * @param net the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder net(Money net) {
                this.net = net;
                return this;
            }

            /**
             * Replaces all {@code udi} values.
             *
             * @param udi the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder udi(List<Reference> udi) {
                this.udi = udi == null ? new ArrayList<>() : new ArrayList<>(udi);
                return this;
            }

            /**
             * Adds a {@code udi} value.
             *
             * @param udi the value to add
             * @return this builder
             */
            public Builder addUdi(Reference udi) {
                this.udi.add(Objects.requireNonNull(udi, "udi"));
                return this;
            }

            /**
             * Replaces all {@code bodySite} values.
             *
             * @param bodySite the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder bodySite(List<BodySite> bodySite) {
                this.bodySite = bodySite == null ? new ArrayList<>() : new ArrayList<>(bodySite);
                return this;
            }

            /**
             * Adds a {@code bodySite} value.
             *
             * @param bodySite the value to add
             * @return this builder
             */
            public Builder addBodySite(BodySite bodySite) {
                this.bodySite.add(Objects.requireNonNull(bodySite, "bodySite"));
                return this;
            }

            /**
             * Replaces all {@code encounter} values.
             *
             * @param encounter the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder encounter(List<Reference> encounter) {
                this.encounter = encounter == null ? new ArrayList<>() : new ArrayList<>(encounter);
                return this;
            }

            /**
             * Adds a {@code encounter} value.
             *
             * @param encounter the value to add
             * @return this builder
             */
            public Builder addEncounter(Reference encounter) {
                this.encounter.add(Objects.requireNonNull(encounter, "encounter"));
                return this;
            }

            /**
             * Replaces all {@code detail} values.
             *
             * @param detail the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder detail(List<Detail> detail) {
                this.detail = detail == null ? new ArrayList<>() : new ArrayList<>(detail);
                return this;
            }

            /**
             * Adds a {@code detail} value.
             *
             * @param detail the value to add
             * @return this builder
             */
            public Builder addDetail(Detail detail) {
                this.detail.add(Objects.requireNonNull(detail, "detail"));
                return this;
            }

            /**
             * Builds the {@code Item}.
             *
             * @return the {@code Item}
             * @throws NullPointerException if a required element is absent
             */
            public Item build() {
                return new Item(
                        id, extension, modifierExtension, sequence, traceNumber, careTeamSequence, diagnosisSequence,
                        procedureSequence, informationSequence, revenue, category, productOrService,
                        productOrServiceEnd, request, modifier, programCode, serviced, location, patientPaid,
                        quantity, unitPrice, factor, tax, net, udi, bodySite, encounter, detail);
            }
        }
    }

    /** Builder for {@link Claim}. Builders are mutable and not thread-safe. */
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
        private List<Identifier> traceNumber = new ArrayList<>();
        private FhirEnum<FinancialResourceStatusCodes> status;
        private CodeableConcept type;
        private CodeableConcept subType;
        private FhirEnum<Use> use;
        private Reference patient;
        private Period billablePeriod;
        private FhirDateTime created;
        private Reference enterer;
        private Reference insurer;
        private Reference provider;
        private CodeableConcept priority;
        private CodeableConcept fundsReserve;
        private List<RelatedClaim> related = new ArrayList<>();
        private Reference prescription;
        private Reference originalPrescription;
        private Payee payee;
        private Reference referral;
        private List<Reference> encounter = new ArrayList<>();
        private Reference facility;
        private CodeableConcept diagnosisRelatedGroup;
        private List<Event> event = new ArrayList<>();
        private List<CareTeam> careTeam = new ArrayList<>();
        private List<SupportingInformation> supportingInfo = new ArrayList<>();
        private List<Diagnosis> diagnosis = new ArrayList<>();
        private List<Procedure> procedure = new ArrayList<>();
        private List<Insurance> insurance = new ArrayList<>();
        private Accident accident;
        private Money patientPaid;
        private List<Item> item = new ArrayList<>();
        private Money total;

        private Builder() {
        }

        private Builder(Claim original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.traceNumber = new ArrayList<>(original.traceNumber());
            this.status = original.status();
            this.type = original.type();
            this.subType = original.subType();
            this.use = original.use();
            this.patient = original.patient();
            this.billablePeriod = original.billablePeriod();
            this.created = original.created();
            this.enterer = original.enterer();
            this.insurer = original.insurer();
            this.provider = original.provider();
            this.priority = original.priority();
            this.fundsReserve = original.fundsReserve();
            this.related = new ArrayList<>(original.related());
            this.prescription = original.prescription();
            this.originalPrescription = original.originalPrescription();
            this.payee = original.payee();
            this.referral = original.referral();
            this.encounter = new ArrayList<>(original.encounter());
            this.facility = original.facility();
            this.diagnosisRelatedGroup = original.diagnosisRelatedGroup();
            this.event = new ArrayList<>(original.event());
            this.careTeam = new ArrayList<>(original.careTeam());
            this.supportingInfo = new ArrayList<>(original.supportingInfo());
            this.diagnosis = new ArrayList<>(original.diagnosis());
            this.procedure = new ArrayList<>(original.procedure());
            this.insurance = new ArrayList<>(original.insurance());
            this.accident = original.accident();
            this.patientPaid = original.patientPaid();
            this.item = new ArrayList<>(original.item());
            this.total = original.total();
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
         * Replaces all {@code traceNumber} values.
         *
         * @param traceNumber the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder traceNumber(List<Identifier> traceNumber) {
            this.traceNumber = traceNumber == null ? new ArrayList<>() : new ArrayList<>(traceNumber);
            return this;
        }

        /**
         * Adds a {@code traceNumber} value.
         *
         * @param traceNumber the value to add
         * @return this builder
         */
        public Builder addTraceNumber(Identifier traceNumber) {
            this.traceNumber.add(Objects.requireNonNull(traceNumber, "traceNumber"));
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<FinancialResourceStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FinancialResourceStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Sets {@code subType}.
         *
         * @param subType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subType(CodeableConcept subType) {
            this.subType = subType;
            return this;
        }

        /**
         * Sets {@code use}.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(FhirEnum<Use> use) {
            this.use = use;
            return this;
        }

        /**
         * Sets {@code use}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(Use use) {
            return use(use == null ? null : FhirEnum.of(use));
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
         * Sets {@code billablePeriod}.
         *
         * @param billablePeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder billablePeriod(Period billablePeriod) {
            this.billablePeriod = billablePeriod;
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
         * Sets {@code enterer}.
         *
         * @param enterer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder enterer(Reference enterer) {
            this.enterer = enterer;
            return this;
        }

        /**
         * Sets {@code insurer}.
         *
         * @param insurer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder insurer(Reference insurer) {
            this.insurer = insurer;
            return this;
        }

        /**
         * Sets {@code provider}.
         *
         * @param provider the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder provider(Reference provider) {
            this.provider = provider;
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
         * Sets {@code fundsReserve}.
         *
         * @param fundsReserve the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder fundsReserve(CodeableConcept fundsReserve) {
            this.fundsReserve = fundsReserve;
            return this;
        }

        /**
         * Replaces all {@code related} values.
         *
         * @param related the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder related(List<RelatedClaim> related) {
            this.related = related == null ? new ArrayList<>() : new ArrayList<>(related);
            return this;
        }

        /**
         * Adds a {@code related} value.
         *
         * @param related the value to add
         * @return this builder
         */
        public Builder addRelated(RelatedClaim related) {
            this.related.add(Objects.requireNonNull(related, "related"));
            return this;
        }

        /**
         * Sets {@code prescription}.
         *
         * @param prescription the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder prescription(Reference prescription) {
            this.prescription = prescription;
            return this;
        }

        /**
         * Sets {@code originalPrescription}.
         *
         * @param originalPrescription the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder originalPrescription(Reference originalPrescription) {
            this.originalPrescription = originalPrescription;
            return this;
        }

        /**
         * Sets {@code payee}.
         *
         * @param payee the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder payee(Payee payee) {
            this.payee = payee;
            return this;
        }

        /**
         * Sets {@code referral}.
         *
         * @param referral the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder referral(Reference referral) {
            this.referral = referral;
            return this;
        }

        /**
         * Replaces all {@code encounter} values.
         *
         * @param encounter the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder encounter(List<Reference> encounter) {
            this.encounter = encounter == null ? new ArrayList<>() : new ArrayList<>(encounter);
            return this;
        }

        /**
         * Adds a {@code encounter} value.
         *
         * @param encounter the value to add
         * @return this builder
         */
        public Builder addEncounter(Reference encounter) {
            this.encounter.add(Objects.requireNonNull(encounter, "encounter"));
            return this;
        }

        /**
         * Sets {@code facility}.
         *
         * @param facility the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder facility(Reference facility) {
            this.facility = facility;
            return this;
        }

        /**
         * Sets {@code diagnosisRelatedGroup}.
         *
         * @param diagnosisRelatedGroup the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder diagnosisRelatedGroup(CodeableConcept diagnosisRelatedGroup) {
            this.diagnosisRelatedGroup = diagnosisRelatedGroup;
            return this;
        }

        /**
         * Replaces all {@code event} values.
         *
         * @param event the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder event(List<Event> event) {
            this.event = event == null ? new ArrayList<>() : new ArrayList<>(event);
            return this;
        }

        /**
         * Adds a {@code event} value.
         *
         * @param event the value to add
         * @return this builder
         */
        public Builder addEvent(Event event) {
            this.event.add(Objects.requireNonNull(event, "event"));
            return this;
        }

        /**
         * Replaces all {@code careTeam} values.
         *
         * @param careTeam the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder careTeam(List<CareTeam> careTeam) {
            this.careTeam = careTeam == null ? new ArrayList<>() : new ArrayList<>(careTeam);
            return this;
        }

        /**
         * Adds a {@code careTeam} value.
         *
         * @param careTeam the value to add
         * @return this builder
         */
        public Builder addCareTeam(CareTeam careTeam) {
            this.careTeam.add(Objects.requireNonNull(careTeam, "careTeam"));
            return this;
        }

        /**
         * Replaces all {@code supportingInfo} values.
         *
         * @param supportingInfo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supportingInfo(List<SupportingInformation> supportingInfo) {
            this.supportingInfo = supportingInfo == null ? new ArrayList<>() : new ArrayList<>(supportingInfo);
            return this;
        }

        /**
         * Adds a {@code supportingInfo} value.
         *
         * @param supportingInfo the value to add
         * @return this builder
         */
        public Builder addSupportingInfo(SupportingInformation supportingInfo) {
            this.supportingInfo.add(Objects.requireNonNull(supportingInfo, "supportingInfo"));
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
         * Replaces all {@code procedure} values.
         *
         * @param procedure the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder procedure(List<Procedure> procedure) {
            this.procedure = procedure == null ? new ArrayList<>() : new ArrayList<>(procedure);
            return this;
        }

        /**
         * Adds a {@code procedure} value.
         *
         * @param procedure the value to add
         * @return this builder
         */
        public Builder addProcedure(Procedure procedure) {
            this.procedure.add(Objects.requireNonNull(procedure, "procedure"));
            return this;
        }

        /**
         * Replaces all {@code insurance} values.
         *
         * @param insurance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder insurance(List<Insurance> insurance) {
            this.insurance = insurance == null ? new ArrayList<>() : new ArrayList<>(insurance);
            return this;
        }

        /**
         * Adds a {@code insurance} value.
         *
         * @param insurance the value to add
         * @return this builder
         */
        public Builder addInsurance(Insurance insurance) {
            this.insurance.add(Objects.requireNonNull(insurance, "insurance"));
            return this;
        }

        /**
         * Sets {@code accident}.
         *
         * @param accident the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder accident(Accident accident) {
            this.accident = accident;
            return this;
        }

        /**
         * Sets {@code patientPaid}.
         *
         * @param patientPaid the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder patientPaid(Money patientPaid) {
            this.patientPaid = patientPaid;
            return this;
        }

        /**
         * Replaces all {@code item} values.
         *
         * @param item the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder item(List<Item> item) {
            this.item = item == null ? new ArrayList<>() : new ArrayList<>(item);
            return this;
        }

        /**
         * Adds a {@code item} value.
         *
         * @param item the value to add
         * @return this builder
         */
        public Builder addItem(Item item) {
            this.item.add(Objects.requireNonNull(item, "item"));
            return this;
        }

        /**
         * Sets {@code total}.
         *
         * @param total the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder total(Money total) {
            this.total = total;
            return this;
        }

        /**
         * Builds the {@code Claim}.
         *
         * @return the {@code Claim}
         * @throws NullPointerException if a required element is absent
         */
        public Claim build() {
            return new Claim(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    traceNumber, status, type, subType, use, patient, billablePeriod, created, enterer, insurer,
                    provider, priority, fundsReserve, related, prescription, originalPrescription, payee, referral,
                    encounter, facility, diagnosisRelatedGroup, event, careTeam, supportingInfo, diagnosis, procedure,
                    insurance, accident, patientPaid, item, total);
        }
    }
}
