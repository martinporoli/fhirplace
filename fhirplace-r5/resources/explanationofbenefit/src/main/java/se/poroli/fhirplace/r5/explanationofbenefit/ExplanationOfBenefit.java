package se.poroli.fhirplace.r5.explanationofbenefit;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
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
import se.poroli.fhirplace.r5.datatypes.Coding;
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
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.ClaimProcessingCodes;
import se.poroli.fhirplace.r5.valuesets.Use;

/**
 * This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally
 * account balance information, for informing the subscriber of the benefits provided.
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
 * @param identifier Business Identifier for the resource.
 * @param traceNumber Number for tracking.
 * @param status active | cancelled | draft | entered-in-error. Required. Modifier element.
 * @param type Category or discipline. Required.
 * @param subType More granular claim type.
 * @param use claim | preauthorization | predetermination. Required.
 * @param patient The recipient of the products and services. Reference to Patient. Required.
 * @param billablePeriod Relevant time frame for the claim.
 * @param created Response creation date. Required.
 * @param enterer Author of the claim. Reference to Practitioner, PractitionerRole, Patient, RelatedPerson.
 * @param insurer Party responsible for reimbursement. Reference to Organization.
 * @param provider Party responsible for the claim. Reference to Practitioner, PractitionerRole, Organization.
 * @param priority Desired processing urgency.
 * @param fundsReserveRequested For whom to reserve funds.
 * @param fundsReserve Funds reserved status.
 * @param related Prior or corollary claims.
 * @param prescription Prescription authorizing services or products. Reference to MedicationRequest,
 *   VisionPrescription.
 * @param originalPrescription Original prescription if superceded by fulfiller. Reference to MedicationRequest.
 * @param event Event information.
 * @param payee Recipient of benefits payable.
 * @param referral Treatment Referral. Reference to ServiceRequest.
 * @param encounter Encounters associated with the listed treatments. Reference to Encounter.
 * @param facility Servicing Facility. Reference to Location, Organization.
 * @param claim Claim reference. Reference to Claim.
 * @param claimResponse Claim response reference. Reference to ClaimResponse.
 * @param outcome queued | complete | error | partial. Required.
 * @param decision Result of the adjudication.
 * @param disposition Disposition Message.
 * @param preAuthRef Preauthorization reference.
 * @param preAuthRefPeriod Preauthorization in-effect period.
 * @param diagnosisRelatedGroup Package billing code.
 * @param careTeam Care Team members.
 * @param supportingInfo Supporting information.
 * @param diagnosis Pertinent diagnosis information.
 * @param procedure Clinical procedures performed.
 * @param precedence Precedence (primary, secondary, etc.).
 * @param insurance Patient insurance information.
 * @param accident Details of the event.
 * @param patientPaid Paid by the patient.
 * @param item Product or service provided.
 * @param addItem Insurer added line items.
 * @param adjudication Header-level adjudication.
 * @param total Adjudication totals.
 * @param payment Payment Details.
 * @param formCode Printed form identifier.
 * @param form Printed reference or actual form.
 * @param processNote Note concerning adjudication.
 * @param benefitPeriod When the benefits are applicable.
 * @param benefitBalance Balance by Benefit Category.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ExplanationOfBenefit">FHIR R5 ExplanationOfBenefit</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record ExplanationOfBenefit(
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
        FhirEnum<ExplanationOfBenefitStatus> status,
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
        CodeableConcept fundsReserveRequested,
        CodeableConcept fundsReserve,
        List<RelatedClaim> related,
        Reference prescription,
        Reference originalPrescription,
        List<Event> event,
        Payee payee,
        Reference referral,
        List<Reference> encounter,
        Reference facility,
        Reference claim,
        Reference claimResponse,
        FhirEnum<ClaimProcessingCodes> outcome,
        CodeableConcept decision,
        FhirString disposition,
        List<FhirString> preAuthRef,
        List<Period> preAuthRefPeriod,
        CodeableConcept diagnosisRelatedGroup,
        List<CareTeam> careTeam,
        List<SupportingInformation> supportingInfo,
        List<Diagnosis> diagnosis,
        List<Procedure> procedure,
        FhirPositiveInt precedence,
        List<Insurance> insurance,
        Accident accident,
        Money patientPaid,
        List<Item> item,
        List<AddedItem> addItem,
        List<ExplanationOfBenefit.Item.Adjudication> adjudication,
        List<Total> total,
        Payment payment,
        CodeableConcept formCode,
        Attachment form,
        List<Note> processNote,
        Period benefitPeriod,
        List<BenefitBalance> benefitBalance) implements DomainResource {

    /**
     * Creates an {@code ExplanationOfBenefit}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public ExplanationOfBenefit {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
        related = related == null ? List.of() : List.copyOf(related);
        event = event == null ? List.of() : List.copyOf(event);
        encounter = encounter == null ? List.of() : List.copyOf(encounter);
        preAuthRef = preAuthRef == null ? List.of() : List.copyOf(preAuthRef);
        preAuthRefPeriod = preAuthRefPeriod == null ? List.of() : List.copyOf(preAuthRefPeriod);
        careTeam = careTeam == null ? List.of() : List.copyOf(careTeam);
        supportingInfo = supportingInfo == null ? List.of() : List.copyOf(supportingInfo);
        diagnosis = diagnosis == null ? List.of() : List.copyOf(diagnosis);
        procedure = procedure == null ? List.of() : List.copyOf(procedure);
        insurance = insurance == null ? List.of() : List.copyOf(insurance);
        item = item == null ? List.of() : List.copyOf(item);
        addItem = addItem == null ? List.of() : List.copyOf(addItem);
        adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
        total = total == null ? List.of() : List.copyOf(total);
        processNote = processNote == null ? List.of() : List.copyOf(processNote);
        benefitBalance = benefitBalance == null ? List.of() : List.copyOf(benefitBalance);
        Objects.requireNonNull(status, "ExplanationOfBenefit.status is required");
        Objects.requireNonNull(type, "ExplanationOfBenefit.type is required");
        Objects.requireNonNull(use, "ExplanationOfBenefit.use is required");
        Objects.requireNonNull(patient, "ExplanationOfBenefit.patient is required");
        Objects.requireNonNull(created, "ExplanationOfBenefit.created is required");
        Objects.requireNonNull(outcome, "ExplanationOfBenefit.outcome is required");
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
     * Returns a builder initialized with the values of this {@code ExplanationOfBenefit}.
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
            Objects.requireNonNull(type, "ExplanationOfBenefit.event.type is required");
            Objects.requireNonNull(when, "ExplanationOfBenefit.event.when is required");
            if (when != null && !(when instanceof FhirDateTime || when instanceof Period)) {
                throw new IllegalArgumentException(
                        "ExplanationOfBenefit.event.when[x] must be one of dateTime, Period, but was "
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
     * The party to be reimbursed for cost of the products and services according to the terms of the policy.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Category of recipient.
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
         * @throws NullPointerException if a list contains {@code null}
         */
        public Payee {
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
             */
            public Payee build() {
                return new Payee(
                        id, extension, modifierExtension, type, party);
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
            Objects.requireNonNull(sequence, "ExplanationOfBenefit.careTeam.sequence is required");
            Objects.requireNonNull(provider, "ExplanationOfBenefit.careTeam.provider is required");
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
            Coding reason) implements BackboneElement {

        /**
         * Creates a {@code SupportingInformation}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public SupportingInformation {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(sequence, "ExplanationOfBenefit.supportingInfo.sequence is required");
            Objects.requireNonNull(category, "ExplanationOfBenefit.supportingInfo.category is required");
            if (timing != null && !(timing instanceof FhirDate || timing instanceof Period)) {
                throw new IllegalArgumentException(
                        "ExplanationOfBenefit.supportingInfo.timing[x] must be one of date, Period, but was "
                                + timing.getClass().getSimpleName());
            }
            if (value != null && !(value instanceof FhirBoolean
                    || value instanceof FhirString
                    || value instanceof Quantity
                    || value instanceof Attachment
                    || value instanceof Reference
                    || value instanceof Identifier)) {
                throw new IllegalArgumentException(
                        "ExplanationOfBenefit.supportingInfo.value[x] does not allow "
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
            private Coding reason;

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
            public Builder reason(Coding reason) {
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
            Objects.requireNonNull(sequence, "ExplanationOfBenefit.diagnosis.sequence is required");
            Objects.requireNonNull(diagnosis, "ExplanationOfBenefit.diagnosis.diagnosis is required");
            if (diagnosis != null && !(diagnosis instanceof CodeableConcept || diagnosis instanceof Reference)) {
                throw new IllegalArgumentException(
                        "ExplanationOfBenefit.diagnosis.diagnosis[x] does not allow "
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
            Objects.requireNonNull(sequence, "ExplanationOfBenefit.procedure.sequence is required");
            Objects.requireNonNull(procedure, "ExplanationOfBenefit.procedure.procedure is required");
            if (procedure != null && !(procedure instanceof CodeableConcept || procedure instanceof Reference)) {
                throw new IllegalArgumentException(
                        "ExplanationOfBenefit.procedure.procedure[x] does not allow "
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
     * @param focal Coverage to be used for adjudication. Required.
     * @param coverage Insurance information. Reference to Coverage. Required.
     * @param preAuthRef Prior authorization reference number.
     */
    public record Insurance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirBoolean focal,
            Reference coverage,
            List<FhirString> preAuthRef) implements BackboneElement {

        /**
         * Creates an {@code Insurance}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Insurance {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            preAuthRef = preAuthRef == null ? List.of() : List.copyOf(preAuthRef);
            Objects.requireNonNull(focal, "ExplanationOfBenefit.insurance.focal is required");
            Objects.requireNonNull(coverage, "ExplanationOfBenefit.insurance.coverage is required");
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
            private FhirBoolean focal;
            private Reference coverage;
            private List<FhirString> preAuthRef = new ArrayList<>();

            private Builder() {
            }

            private Builder(Insurance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.focal = original.focal();
                this.coverage = original.coverage();
                this.preAuthRef = new ArrayList<>(original.preAuthRef());
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
             * Builds the {@code Insurance}.
             *
             * @return the {@code Insurance}
             * @throws NullPointerException if a required element is absent
             */
            public Insurance build() {
                return new Insurance(
                        id, extension, modifierExtension, focal, coverage, preAuthRef);
            }
        }
    }

    /**
     * Details of a accident which resulted in injuries which required the products and services listed in the claim.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param date When the incident occurred.
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
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Accident {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (location != null && !(location instanceof Address || location instanceof Reference)) {
                throw new IllegalArgumentException(
                        "ExplanationOfBenefit.accident.location[x] must be one of Address, Reference, but was "
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
     * @param careTeamSequence Applicable care team members.
     * @param diagnosisSequence Applicable diagnoses.
     * @param procedureSequence Applicable procedures.
     * @param informationSequence Applicable exception and supporting information.
     * @param traceNumber Number for tracking.
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
     * @param noteNumber Applicable note numbers.
     * @param reviewOutcome Adjudication results.
     * @param adjudication Adjudication details.
     * @param detail Additional items.
     */
    public record Item(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            List<FhirPositiveInt> careTeamSequence,
            List<FhirPositiveInt> diagnosisSequence,
            List<FhirPositiveInt> procedureSequence,
            List<FhirPositiveInt> informationSequence,
            List<Identifier> traceNumber,
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
            List<ItemBodySite> bodySite,
            List<Reference> encounter,
            List<FhirPositiveInt> noteNumber,
            ReviewOutcome reviewOutcome,
            List<Adjudication> adjudication,
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
            careTeamSequence = careTeamSequence == null ? List.of() : List.copyOf(careTeamSequence);
            diagnosisSequence = diagnosisSequence == null ? List.of() : List.copyOf(diagnosisSequence);
            procedureSequence = procedureSequence == null ? List.of() : List.copyOf(procedureSequence);
            informationSequence = informationSequence == null ? List.of() : List.copyOf(informationSequence);
            traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
            request = request == null ? List.of() : List.copyOf(request);
            modifier = modifier == null ? List.of() : List.copyOf(modifier);
            programCode = programCode == null ? List.of() : List.copyOf(programCode);
            udi = udi == null ? List.of() : List.copyOf(udi);
            bodySite = bodySite == null ? List.of() : List.copyOf(bodySite);
            encounter = encounter == null ? List.of() : List.copyOf(encounter);
            noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
            adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
            detail = detail == null ? List.of() : List.copyOf(detail);
            Objects.requireNonNull(sequence, "ExplanationOfBenefit.item.sequence is required");
            if (serviced != null && !(serviced instanceof FhirDate || serviced instanceof Period)) {
                throw new IllegalArgumentException(
                        "ExplanationOfBenefit.item.serviced[x] must be one of date, Period, but was "
                                + serviced.getClass().getSimpleName());
            }
            if (location != null && !(location instanceof CodeableConcept
                    || location instanceof Address
                    || location instanceof Reference)) {
                throw new IllegalArgumentException(
                        "ExplanationOfBenefit.item.location[x] does not allow "
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
        public record ItemBodySite(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<CodeableReference> site,
                List<CodeableConcept> subSite) implements BackboneElement {

            /**
             * Creates an {@code ItemBodySite}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a required list is empty
             */
            public ItemBodySite {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                site = site == null ? List.of() : List.copyOf(site);
                subSite = subSite == null ? List.of() : List.copyOf(subSite);
                if (site.isEmpty()) {
                    throw new IllegalArgumentException(
                            "ExplanationOfBenefit.item.bodySite.site requires at least one value");
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
             * Returns a builder initialized with the values of this {@code ItemBodySite}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link ItemBodySite}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<CodeableReference> site = new ArrayList<>();
                private List<CodeableConcept> subSite = new ArrayList<>();

                private Builder() {
                }

                private Builder(ItemBodySite original) {
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
                 * Builds the {@code ItemBodySite}.
                 *
                 * @return the {@code ItemBodySite}
                 * @throws NullPointerException if a required element is absent
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public ItemBodySite build() {
                    return new ItemBodySite(
                            id, extension, modifierExtension, site, subSite);
                }
            }
        }

        /**
         * The high-level results of the adjudication if adjudication has been performed.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param decision Result of the adjudication.
         * @param reason Reason for result of the adjudication.
         * @param preAuthRef Preauthorization reference.
         * @param preAuthPeriod Preauthorization reference effective period.
         */
        public record ReviewOutcome(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept decision,
                List<CodeableConcept> reason,
                FhirString preAuthRef,
                Period preAuthPeriod) implements BackboneElement {

            /**
             * Creates a {@code ReviewOutcome}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public ReviewOutcome {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                reason = reason == null ? List.of() : List.copyOf(reason);
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
             * Returns a builder initialized with the values of this {@code ReviewOutcome}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link ReviewOutcome}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept decision;
                private List<CodeableConcept> reason = new ArrayList<>();
                private FhirString preAuthRef;
                private Period preAuthPeriod;

                private Builder() {
                }

                private Builder(ReviewOutcome original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.decision = original.decision();
                    this.reason = new ArrayList<>(original.reason());
                    this.preAuthRef = original.preAuthRef();
                    this.preAuthPeriod = original.preAuthPeriod();
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
                 * Sets {@code decision}.
                 *
                 * @param decision the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder decision(CodeableConcept decision) {
                    this.decision = decision;
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
                 * Sets {@code preAuthRef}.
                 *
                 * @param preAuthRef the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder preAuthRef(FhirString preAuthRef) {
                    this.preAuthRef = preAuthRef;
                    return this;
                }

                /**
                 * Sets {@code preAuthRef}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param preAuthRef the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder preAuthRef(String preAuthRef) {
                    return preAuthRef(preAuthRef == null ? null : FhirString.of(preAuthRef));
                }

                /**
                 * Sets {@code preAuthPeriod}.
                 *
                 * @param preAuthPeriod the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder preAuthPeriod(Period preAuthPeriod) {
                    this.preAuthPeriod = preAuthPeriod;
                    return this;
                }

                /**
                 * Builds the {@code ReviewOutcome}.
                 *
                 * @return the {@code ReviewOutcome}
                 */
                public ReviewOutcome build() {
                    return new ReviewOutcome(
                            id, extension, modifierExtension, decision, reason, preAuthRef, preAuthPeriod);
                }
            }
        }

        /**
         * If this item is a group then the values here are a summary of the adjudication of the detail items.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param category Type of adjudication information. Required.
         * @param reason Explanation of adjudication outcome.
         * @param amount Monetary amount.
         * @param quantity Non-monitary value.
         */
        public record Adjudication(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept category,
                CodeableConcept reason,
                Money amount,
                Quantity quantity) implements BackboneElement {

            /**
             * Creates an {@code Adjudication}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Adjudication {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(category, "ExplanationOfBenefit.item.adjudication.category is required");
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
             * Returns a builder initialized with the values of this {@code Adjudication}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Adjudication}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept category;
                private CodeableConcept reason;
                private Money amount;
                private Quantity quantity;

                private Builder() {
                }

                private Builder(Adjudication original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.category = original.category();
                    this.reason = original.reason();
                    this.amount = original.amount();
                    this.quantity = original.quantity();
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
                 * Sets {@code amount}.
                 *
                 * @param amount the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder amount(Money amount) {
                    this.amount = amount;
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
                 * Builds the {@code Adjudication}.
                 *
                 * @return the {@code Adjudication}
                 * @throws NullPointerException if a required element is absent
                 */
                public Adjudication build() {
                    return new Adjudication(
                            id, extension, modifierExtension, category, reason, amount, quantity);
                }
            }
        }

        /**
         * Second-tier of goods and services.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param sequence Product or service provided. Required.
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
         * @param noteNumber Applicable note numbers.
         * @param reviewOutcome Detail level adjudication results.
         * @param adjudication Detail level adjudication details.
         * @param subDetail Additional items.
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
                List<FhirPositiveInt> noteNumber,
                ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome,
                List<ExplanationOfBenefit.Item.Adjudication> adjudication,
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
                noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
                adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
                subDetail = subDetail == null ? List.of() : List.copyOf(subDetail);
                Objects.requireNonNull(sequence, "ExplanationOfBenefit.item.detail.sequence is required");
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
             * Third-tier of goods and services.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param sequence Product or service provided. Required.
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
             * @param noteNumber Applicable note numbers.
             * @param reviewOutcome Subdetail level adjudication results.
             * @param adjudication Subdetail level adjudication details.
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
                    List<Reference> udi,
                    List<FhirPositiveInt> noteNumber,
                    ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome,
                    List<ExplanationOfBenefit.Item.Adjudication> adjudication) implements BackboneElement {

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
                    noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
                    adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
                    Objects.requireNonNull(
                            sequence, "ExplanationOfBenefit.item.detail.subDetail.sequence is required");
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
                    private List<FhirPositiveInt> noteNumber = new ArrayList<>();
                    private ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome;
                    private List<ExplanationOfBenefit.Item.Adjudication> adjudication = new ArrayList<>();

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
                        this.noteNumber = new ArrayList<>(original.noteNumber());
                        this.reviewOutcome = original.reviewOutcome();
                        this.adjudication = new ArrayList<>(original.adjudication());
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
                     * Replaces all {@code noteNumber} values.
                     *
                     * @param noteNumber the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                        this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                        return this;
                    }

                    /**
                     * Adds a {@code noteNumber} value.
                     *
                     * @param noteNumber the value to add
                     * @return this builder
                     */
                    public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                        this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                        return this;
                    }

                    /**
                     * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
                     *
                     * @param noteNumber the value to add
                     * @return this builder
                     */
                    public Builder addNoteNumber(Integer noteNumber) {
                        return addNoteNumber(FhirPositiveInt.of(noteNumber));
                    }

                    /**
                     * Sets {@code reviewOutcome}.
                     *
                     * @param reviewOutcome the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder reviewOutcome(ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome) {
                        this.reviewOutcome = reviewOutcome;
                        return this;
                    }

                    /**
                     * Replaces all {@code adjudication} values.
                     *
                     * @param adjudication the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder adjudication(List<ExplanationOfBenefit.Item.Adjudication> adjudication) {
                        this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                        return this;
                    }

                    /**
                     * Adds a {@code adjudication} value.
                     *
                     * @param adjudication the value to add
                     * @return this builder
                     */
                    public Builder addAdjudication(ExplanationOfBenefit.Item.Adjudication adjudication) {
                        this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
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
                                unitPrice, factor, tax, net, udi, noteNumber, reviewOutcome, adjudication);
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
                private List<FhirPositiveInt> noteNumber = new ArrayList<>();
                private ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome;
                private List<ExplanationOfBenefit.Item.Adjudication> adjudication = new ArrayList<>();
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
                    this.noteNumber = new ArrayList<>(original.noteNumber());
                    this.reviewOutcome = original.reviewOutcome();
                    this.adjudication = new ArrayList<>(original.adjudication());
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
                 * Replaces all {@code noteNumber} values.
                 *
                 * @param noteNumber the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                    this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                    return this;
                }

                /**
                 * Adds a {@code noteNumber} value.
                 *
                 * @param noteNumber the value to add
                 * @return this builder
                 */
                public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                    this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                    return this;
                }

                /**
                 * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param noteNumber the value to add
                 * @return this builder
                 */
                public Builder addNoteNumber(Integer noteNumber) {
                    return addNoteNumber(FhirPositiveInt.of(noteNumber));
                }

                /**
                 * Sets {@code reviewOutcome}.
                 *
                 * @param reviewOutcome the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder reviewOutcome(ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome) {
                    this.reviewOutcome = reviewOutcome;
                    return this;
                }

                /**
                 * Replaces all {@code adjudication} values.
                 *
                 * @param adjudication the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder adjudication(List<ExplanationOfBenefit.Item.Adjudication> adjudication) {
                    this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                    return this;
                }

                /**
                 * Adds a {@code adjudication} value.
                 *
                 * @param adjudication the value to add
                 * @return this builder
                 */
                public Builder addAdjudication(ExplanationOfBenefit.Item.Adjudication adjudication) {
                    this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
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
                            unitPrice, factor, tax, net, udi, noteNumber, reviewOutcome, adjudication, subDetail);
                }
            }
        }

        /** Builder for {@link Item}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt sequence;
            private List<FhirPositiveInt> careTeamSequence = new ArrayList<>();
            private List<FhirPositiveInt> diagnosisSequence = new ArrayList<>();
            private List<FhirPositiveInt> procedureSequence = new ArrayList<>();
            private List<FhirPositiveInt> informationSequence = new ArrayList<>();
            private List<Identifier> traceNumber = new ArrayList<>();
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
            private List<ItemBodySite> bodySite = new ArrayList<>();
            private List<Reference> encounter = new ArrayList<>();
            private List<FhirPositiveInt> noteNumber = new ArrayList<>();
            private ReviewOutcome reviewOutcome;
            private List<Adjudication> adjudication = new ArrayList<>();
            private List<Detail> detail = new ArrayList<>();

            private Builder() {
            }

            private Builder(Item original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.careTeamSequence = new ArrayList<>(original.careTeamSequence());
                this.diagnosisSequence = new ArrayList<>(original.diagnosisSequence());
                this.procedureSequence = new ArrayList<>(original.procedureSequence());
                this.informationSequence = new ArrayList<>(original.informationSequence());
                this.traceNumber = new ArrayList<>(original.traceNumber());
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
                this.noteNumber = new ArrayList<>(original.noteNumber());
                this.reviewOutcome = original.reviewOutcome();
                this.adjudication = new ArrayList<>(original.adjudication());
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
            public Builder bodySite(List<ItemBodySite> bodySite) {
                this.bodySite = bodySite == null ? new ArrayList<>() : new ArrayList<>(bodySite);
                return this;
            }

            /**
             * Adds a {@code bodySite} value.
             *
             * @param bodySite the value to add
             * @return this builder
             */
            public Builder addBodySite(ItemBodySite bodySite) {
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
             * Replaces all {@code noteNumber} values.
             *
             * @param noteNumber the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                return this;
            }

            /**
             * Adds a {@code noteNumber} value.
             *
             * @param noteNumber the value to add
             * @return this builder
             */
            public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                return this;
            }

            /**
             * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param noteNumber the value to add
             * @return this builder
             */
            public Builder addNoteNumber(Integer noteNumber) {
                return addNoteNumber(FhirPositiveInt.of(noteNumber));
            }

            /**
             * Sets {@code reviewOutcome}.
             *
             * @param reviewOutcome the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reviewOutcome(ReviewOutcome reviewOutcome) {
                this.reviewOutcome = reviewOutcome;
                return this;
            }

            /**
             * Replaces all {@code adjudication} values.
             *
             * @param adjudication the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder adjudication(List<Adjudication> adjudication) {
                this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                return this;
            }

            /**
             * Adds a {@code adjudication} value.
             *
             * @param adjudication the value to add
             * @return this builder
             */
            public Builder addAdjudication(Adjudication adjudication) {
                this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
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
                        id, extension, modifierExtension, sequence, careTeamSequence, diagnosisSequence,
                        procedureSequence, informationSequence, traceNumber, revenue, category, productOrService,
                        productOrServiceEnd, request, modifier, programCode, serviced, location, patientPaid,
                        quantity, unitPrice, factor, tax, net, udi, bodySite, encounter, noteNumber, reviewOutcome,
                        adjudication, detail);
            }
        }
    }

    /**
     * The first-tier service adjudications for payor added product or service lines.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param itemSequence Item sequence number.
     * @param detailSequence Detail sequence number.
     * @param subDetailSequence Subdetail sequence number.
     * @param traceNumber Number for tracking.
     * @param provider Authorized providers. Reference to Practitioner, PractitionerRole, Organization.
     * @param revenue Revenue or cost center code.
     * @param productOrService Billing, service, product, or drug code.
     * @param productOrServiceEnd End of a range of codes.
     * @param request Request or Referral for Service. Reference to DeviceRequest, MedicationRequest, NutritionOrder,
     *   ServiceRequest, SupplyRequest, VisionPrescription.
     * @param modifier Service/Product billing modifiers.
     * @param programCode Program the product or service is provided under.
     * @param serviced Date or dates of service or product delivery. One of date, Period.
     * @param location Place of service or where product was supplied. One of CodeableConcept, Address, Reference.
     * @param patientPaid Paid by the patient.
     * @param quantity Count of products or services.
     * @param unitPrice Fee, charge or cost per item.
     * @param factor Price scaling factor.
     * @param tax Total tax.
     * @param net Total item cost.
     * @param bodySite Anatomical location.
     * @param noteNumber Applicable note numbers.
     * @param reviewOutcome Additem level adjudication results.
     * @param adjudication Added items adjudication.
     * @param detail Insurer added line items.
     */
    public record AddedItem(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<FhirPositiveInt> itemSequence,
            List<FhirPositiveInt> detailSequence,
            List<FhirPositiveInt> subDetailSequence,
            List<Identifier> traceNumber,
            List<Reference> provider,
            CodeableConcept revenue,
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
            List<AddedItemBodySite> bodySite,
            List<FhirPositiveInt> noteNumber,
            ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome,
            List<ExplanationOfBenefit.Item.Adjudication> adjudication,
            List<AddedItemDetail> detail) implements BackboneElement {

        /**
         * Creates an {@code AddedItem}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public AddedItem {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            itemSequence = itemSequence == null ? List.of() : List.copyOf(itemSequence);
            detailSequence = detailSequence == null ? List.of() : List.copyOf(detailSequence);
            subDetailSequence = subDetailSequence == null ? List.of() : List.copyOf(subDetailSequence);
            traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
            provider = provider == null ? List.of() : List.copyOf(provider);
            request = request == null ? List.of() : List.copyOf(request);
            modifier = modifier == null ? List.of() : List.copyOf(modifier);
            programCode = programCode == null ? List.of() : List.copyOf(programCode);
            bodySite = bodySite == null ? List.of() : List.copyOf(bodySite);
            noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
            adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
            detail = detail == null ? List.of() : List.copyOf(detail);
            if (serviced != null && !(serviced instanceof FhirDate || serviced instanceof Period)) {
                throw new IllegalArgumentException(
                        "ExplanationOfBenefit.addItem.serviced[x] must be one of date, Period, but was "
                                + serviced.getClass().getSimpleName());
            }
            if (location != null && !(location instanceof CodeableConcept
                    || location instanceof Address
                    || location instanceof Reference)) {
                throw new IllegalArgumentException(
                        "ExplanationOfBenefit.addItem.location[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code AddedItem}.
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
        public record AddedItemBodySite(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<CodeableReference> site,
                List<CodeableConcept> subSite) implements BackboneElement {

            /**
             * Creates an {@code AddedItemBodySite}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a required list is empty
             */
            public AddedItemBodySite {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                site = site == null ? List.of() : List.copyOf(site);
                subSite = subSite == null ? List.of() : List.copyOf(subSite);
                if (site.isEmpty()) {
                    throw new IllegalArgumentException(
                            "ExplanationOfBenefit.addItem.bodySite.site requires at least one value");
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
             * Returns a builder initialized with the values of this {@code AddedItemBodySite}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link AddedItemBodySite}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<CodeableReference> site = new ArrayList<>();
                private List<CodeableConcept> subSite = new ArrayList<>();

                private Builder() {
                }

                private Builder(AddedItemBodySite original) {
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
                 * Builds the {@code AddedItemBodySite}.
                 *
                 * @return the {@code AddedItemBodySite}
                 * @throws NullPointerException if a required element is absent
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public AddedItemBodySite build() {
                    return new AddedItemBodySite(
                            id, extension, modifierExtension, site, subSite);
                }
            }
        }

        /**
         * The second-tier service adjudications for payor added services.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param traceNumber Number for tracking.
         * @param revenue Revenue or cost center code.
         * @param productOrService Billing, service, product, or drug code.
         * @param productOrServiceEnd End of a range of codes.
         * @param modifier Service/Product billing modifiers.
         * @param patientPaid Paid by the patient.
         * @param quantity Count of products or services.
         * @param unitPrice Fee, charge or cost per item.
         * @param factor Price scaling factor.
         * @param tax Total tax.
         * @param net Total item cost.
         * @param noteNumber Applicable note numbers.
         * @param reviewOutcome Additem detail level adjudication results.
         * @param adjudication Added items adjudication.
         * @param subDetail Insurer added line items.
         */
        public record AddedItemDetail(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<Identifier> traceNumber,
                CodeableConcept revenue,
                CodeableConcept productOrService,
                CodeableConcept productOrServiceEnd,
                List<CodeableConcept> modifier,
                Money patientPaid,
                Quantity quantity,
                Money unitPrice,
                FhirDecimal factor,
                Money tax,
                Money net,
                List<FhirPositiveInt> noteNumber,
                ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome,
                List<ExplanationOfBenefit.Item.Adjudication> adjudication,
                List<AddedItemDetailSubDetail> subDetail) implements BackboneElement {

            /**
             * Creates an {@code AddedItemDetail}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public AddedItemDetail {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
                modifier = modifier == null ? List.of() : List.copyOf(modifier);
                noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
                adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
                subDetail = subDetail == null ? List.of() : List.copyOf(subDetail);
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
             * Returns a builder initialized with the values of this {@code AddedItemDetail}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * The third-tier service adjudications for payor added services.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param traceNumber Number for tracking.
             * @param revenue Revenue or cost center code.
             * @param productOrService Billing, service, product, or drug code.
             * @param productOrServiceEnd End of a range of codes.
             * @param modifier Service/Product billing modifiers.
             * @param patientPaid Paid by the patient.
             * @param quantity Count of products or services.
             * @param unitPrice Fee, charge or cost per item.
             * @param factor Price scaling factor.
             * @param tax Total tax.
             * @param net Total item cost.
             * @param noteNumber Applicable note numbers.
             * @param reviewOutcome Additem subdetail level adjudication results.
             * @param adjudication Added items adjudication.
             */
            public record AddedItemDetailSubDetail(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    List<Identifier> traceNumber,
                    CodeableConcept revenue,
                    CodeableConcept productOrService,
                    CodeableConcept productOrServiceEnd,
                    List<CodeableConcept> modifier,
                    Money patientPaid,
                    Quantity quantity,
                    Money unitPrice,
                    FhirDecimal factor,
                    Money tax,
                    Money net,
                    List<FhirPositiveInt> noteNumber,
                    ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome,
                    List<ExplanationOfBenefit.Item.Adjudication> adjudication) implements BackboneElement {

                /**
                 * Creates an {@code AddedItemDetailSubDetail}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 */
                public AddedItemDetailSubDetail {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
                    modifier = modifier == null ? List.of() : List.copyOf(modifier);
                    noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
                    adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
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
                 * Returns a builder initialized with the values of this {@code AddedItemDetailSubDetail}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link AddedItemDetailSubDetail}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private List<Identifier> traceNumber = new ArrayList<>();
                    private CodeableConcept revenue;
                    private CodeableConcept productOrService;
                    private CodeableConcept productOrServiceEnd;
                    private List<CodeableConcept> modifier = new ArrayList<>();
                    private Money patientPaid;
                    private Quantity quantity;
                    private Money unitPrice;
                    private FhirDecimal factor;
                    private Money tax;
                    private Money net;
                    private List<FhirPositiveInt> noteNumber = new ArrayList<>();
                    private ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome;
                    private List<ExplanationOfBenefit.Item.Adjudication> adjudication = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(AddedItemDetailSubDetail original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.traceNumber = new ArrayList<>(original.traceNumber());
                        this.revenue = original.revenue();
                        this.productOrService = original.productOrService();
                        this.productOrServiceEnd = original.productOrServiceEnd();
                        this.modifier = new ArrayList<>(original.modifier());
                        this.patientPaid = original.patientPaid();
                        this.quantity = original.quantity();
                        this.unitPrice = original.unitPrice();
                        this.factor = original.factor();
                        this.tax = original.tax();
                        this.net = original.net();
                        this.noteNumber = new ArrayList<>(original.noteNumber());
                        this.reviewOutcome = original.reviewOutcome();
                        this.adjudication = new ArrayList<>(original.adjudication());
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
                     * Replaces all {@code noteNumber} values.
                     *
                     * @param noteNumber the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                        this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                        return this;
                    }

                    /**
                     * Adds a {@code noteNumber} value.
                     *
                     * @param noteNumber the value to add
                     * @return this builder
                     */
                    public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                        this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                        return this;
                    }

                    /**
                     * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
                     *
                     * @param noteNumber the value to add
                     * @return this builder
                     */
                    public Builder addNoteNumber(Integer noteNumber) {
                        return addNoteNumber(FhirPositiveInt.of(noteNumber));
                    }

                    /**
                     * Sets {@code reviewOutcome}.
                     *
                     * @param reviewOutcome the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder reviewOutcome(ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome) {
                        this.reviewOutcome = reviewOutcome;
                        return this;
                    }

                    /**
                     * Replaces all {@code adjudication} values.
                     *
                     * @param adjudication the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder adjudication(List<ExplanationOfBenefit.Item.Adjudication> adjudication) {
                        this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                        return this;
                    }

                    /**
                     * Adds a {@code adjudication} value.
                     *
                     * @param adjudication the value to add
                     * @return this builder
                     */
                    public Builder addAdjudication(ExplanationOfBenefit.Item.Adjudication adjudication) {
                        this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
                        return this;
                    }

                    /**
                     * Builds the {@code AddedItemDetailSubDetail}.
                     *
                     * @return the {@code AddedItemDetailSubDetail}
                     */
                    public AddedItemDetailSubDetail build() {
                        return new AddedItemDetailSubDetail(
                                id, extension, modifierExtension, traceNumber, revenue, productOrService,
                                productOrServiceEnd, modifier, patientPaid, quantity, unitPrice, factor, tax, net,
                                noteNumber, reviewOutcome, adjudication);
                    }
                }
            }

            /** Builder for {@link AddedItemDetail}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<Identifier> traceNumber = new ArrayList<>();
                private CodeableConcept revenue;
                private CodeableConcept productOrService;
                private CodeableConcept productOrServiceEnd;
                private List<CodeableConcept> modifier = new ArrayList<>();
                private Money patientPaid;
                private Quantity quantity;
                private Money unitPrice;
                private FhirDecimal factor;
                private Money tax;
                private Money net;
                private List<FhirPositiveInt> noteNumber = new ArrayList<>();
                private ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome;
                private List<ExplanationOfBenefit.Item.Adjudication> adjudication = new ArrayList<>();
                private List<AddedItemDetailSubDetail> subDetail = new ArrayList<>();

                private Builder() {
                }

                private Builder(AddedItemDetail original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.traceNumber = new ArrayList<>(original.traceNumber());
                    this.revenue = original.revenue();
                    this.productOrService = original.productOrService();
                    this.productOrServiceEnd = original.productOrServiceEnd();
                    this.modifier = new ArrayList<>(original.modifier());
                    this.patientPaid = original.patientPaid();
                    this.quantity = original.quantity();
                    this.unitPrice = original.unitPrice();
                    this.factor = original.factor();
                    this.tax = original.tax();
                    this.net = original.net();
                    this.noteNumber = new ArrayList<>(original.noteNumber());
                    this.reviewOutcome = original.reviewOutcome();
                    this.adjudication = new ArrayList<>(original.adjudication());
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
                 * Replaces all {@code noteNumber} values.
                 *
                 * @param noteNumber the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                    this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                    return this;
                }

                /**
                 * Adds a {@code noteNumber} value.
                 *
                 * @param noteNumber the value to add
                 * @return this builder
                 */
                public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                    this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                    return this;
                }

                /**
                 * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param noteNumber the value to add
                 * @return this builder
                 */
                public Builder addNoteNumber(Integer noteNumber) {
                    return addNoteNumber(FhirPositiveInt.of(noteNumber));
                }

                /**
                 * Sets {@code reviewOutcome}.
                 *
                 * @param reviewOutcome the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder reviewOutcome(ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome) {
                    this.reviewOutcome = reviewOutcome;
                    return this;
                }

                /**
                 * Replaces all {@code adjudication} values.
                 *
                 * @param adjudication the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder adjudication(List<ExplanationOfBenefit.Item.Adjudication> adjudication) {
                    this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                    return this;
                }

                /**
                 * Adds a {@code adjudication} value.
                 *
                 * @param adjudication the value to add
                 * @return this builder
                 */
                public Builder addAdjudication(ExplanationOfBenefit.Item.Adjudication adjudication) {
                    this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
                    return this;
                }

                /**
                 * Replaces all {@code subDetail} values.
                 *
                 * @param subDetail the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder subDetail(List<AddedItemDetailSubDetail> subDetail) {
                    this.subDetail = subDetail == null ? new ArrayList<>() : new ArrayList<>(subDetail);
                    return this;
                }

                /**
                 * Adds a {@code subDetail} value.
                 *
                 * @param subDetail the value to add
                 * @return this builder
                 */
                public Builder addSubDetail(AddedItemDetailSubDetail subDetail) {
                    this.subDetail.add(Objects.requireNonNull(subDetail, "subDetail"));
                    return this;
                }

                /**
                 * Builds the {@code AddedItemDetail}.
                 *
                 * @return the {@code AddedItemDetail}
                 */
                public AddedItemDetail build() {
                    return new AddedItemDetail(
                            id, extension, modifierExtension, traceNumber, revenue, productOrService,
                            productOrServiceEnd, modifier, patientPaid, quantity, unitPrice, factor, tax, net,
                            noteNumber, reviewOutcome, adjudication, subDetail);
                }
            }
        }

        /** Builder for {@link AddedItem}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<FhirPositiveInt> itemSequence = new ArrayList<>();
            private List<FhirPositiveInt> detailSequence = new ArrayList<>();
            private List<FhirPositiveInt> subDetailSequence = new ArrayList<>();
            private List<Identifier> traceNumber = new ArrayList<>();
            private List<Reference> provider = new ArrayList<>();
            private CodeableConcept revenue;
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
            private List<AddedItemBodySite> bodySite = new ArrayList<>();
            private List<FhirPositiveInt> noteNumber = new ArrayList<>();
            private ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome;
            private List<ExplanationOfBenefit.Item.Adjudication> adjudication = new ArrayList<>();
            private List<AddedItemDetail> detail = new ArrayList<>();

            private Builder() {
            }

            private Builder(AddedItem original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.itemSequence = new ArrayList<>(original.itemSequence());
                this.detailSequence = new ArrayList<>(original.detailSequence());
                this.subDetailSequence = new ArrayList<>(original.subDetailSequence());
                this.traceNumber = new ArrayList<>(original.traceNumber());
                this.provider = new ArrayList<>(original.provider());
                this.revenue = original.revenue();
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
                this.bodySite = new ArrayList<>(original.bodySite());
                this.noteNumber = new ArrayList<>(original.noteNumber());
                this.reviewOutcome = original.reviewOutcome();
                this.adjudication = new ArrayList<>(original.adjudication());
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
             * Replaces all {@code itemSequence} values.
             *
             * @param itemSequence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder itemSequence(List<FhirPositiveInt> itemSequence) {
                this.itemSequence = itemSequence == null ? new ArrayList<>() : new ArrayList<>(itemSequence);
                return this;
            }

            /**
             * Adds a {@code itemSequence} value.
             *
             * @param itemSequence the value to add
             * @return this builder
             */
            public Builder addItemSequence(FhirPositiveInt itemSequence) {
                this.itemSequence.add(Objects.requireNonNull(itemSequence, "itemSequence"));
                return this;
            }

            /**
             * Adds a {@code itemSequence} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param itemSequence the value to add
             * @return this builder
             */
            public Builder addItemSequence(Integer itemSequence) {
                return addItemSequence(FhirPositiveInt.of(itemSequence));
            }

            /**
             * Replaces all {@code detailSequence} values.
             *
             * @param detailSequence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder detailSequence(List<FhirPositiveInt> detailSequence) {
                this.detailSequence = detailSequence == null ? new ArrayList<>() : new ArrayList<>(detailSequence);
                return this;
            }

            /**
             * Adds a {@code detailSequence} value.
             *
             * @param detailSequence the value to add
             * @return this builder
             */
            public Builder addDetailSequence(FhirPositiveInt detailSequence) {
                this.detailSequence.add(Objects.requireNonNull(detailSequence, "detailSequence"));
                return this;
            }

            /**
             * Adds a {@code detailSequence} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param detailSequence the value to add
             * @return this builder
             */
            public Builder addDetailSequence(Integer detailSequence) {
                return addDetailSequence(FhirPositiveInt.of(detailSequence));
            }

            /**
             * Replaces all {@code subDetailSequence} values.
             *
             * @param subDetailSequence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder subDetailSequence(List<FhirPositiveInt> subDetailSequence) {
                this.subDetailSequence = subDetailSequence == null
                        ? new ArrayList<>()
                        : new ArrayList<>(subDetailSequence);
                return this;
            }

            /**
             * Adds a {@code subDetailSequence} value.
             *
             * @param subDetailSequence the value to add
             * @return this builder
             */
            public Builder addSubDetailSequence(FhirPositiveInt subDetailSequence) {
                this.subDetailSequence.add(Objects.requireNonNull(subDetailSequence, "subDetailSequence"));
                return this;
            }

            /**
             * Adds a {@code subDetailSequence} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param subDetailSequence the value to add
             * @return this builder
             */
            public Builder addSubDetailSequence(Integer subDetailSequence) {
                return addSubDetailSequence(FhirPositiveInt.of(subDetailSequence));
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
             * Replaces all {@code provider} values.
             *
             * @param provider the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder provider(List<Reference> provider) {
                this.provider = provider == null ? new ArrayList<>() : new ArrayList<>(provider);
                return this;
            }

            /**
             * Adds a {@code provider} value.
             *
             * @param provider the value to add
             * @return this builder
             */
            public Builder addProvider(Reference provider) {
                this.provider.add(Objects.requireNonNull(provider, "provider"));
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
             * Replaces all {@code bodySite} values.
             *
             * @param bodySite the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder bodySite(List<AddedItemBodySite> bodySite) {
                this.bodySite = bodySite == null ? new ArrayList<>() : new ArrayList<>(bodySite);
                return this;
            }

            /**
             * Adds a {@code bodySite} value.
             *
             * @param bodySite the value to add
             * @return this builder
             */
            public Builder addBodySite(AddedItemBodySite bodySite) {
                this.bodySite.add(Objects.requireNonNull(bodySite, "bodySite"));
                return this;
            }

            /**
             * Replaces all {@code noteNumber} values.
             *
             * @param noteNumber the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                return this;
            }

            /**
             * Adds a {@code noteNumber} value.
             *
             * @param noteNumber the value to add
             * @return this builder
             */
            public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                return this;
            }

            /**
             * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param noteNumber the value to add
             * @return this builder
             */
            public Builder addNoteNumber(Integer noteNumber) {
                return addNoteNumber(FhirPositiveInt.of(noteNumber));
            }

            /**
             * Sets {@code reviewOutcome}.
             *
             * @param reviewOutcome the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reviewOutcome(ExplanationOfBenefit.Item.ReviewOutcome reviewOutcome) {
                this.reviewOutcome = reviewOutcome;
                return this;
            }

            /**
             * Replaces all {@code adjudication} values.
             *
             * @param adjudication the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder adjudication(List<ExplanationOfBenefit.Item.Adjudication> adjudication) {
                this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                return this;
            }

            /**
             * Adds a {@code adjudication} value.
             *
             * @param adjudication the value to add
             * @return this builder
             */
            public Builder addAdjudication(ExplanationOfBenefit.Item.Adjudication adjudication) {
                this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
                return this;
            }

            /**
             * Replaces all {@code detail} values.
             *
             * @param detail the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder detail(List<AddedItemDetail> detail) {
                this.detail = detail == null ? new ArrayList<>() : new ArrayList<>(detail);
                return this;
            }

            /**
             * Adds a {@code detail} value.
             *
             * @param detail the value to add
             * @return this builder
             */
            public Builder addDetail(AddedItemDetail detail) {
                this.detail.add(Objects.requireNonNull(detail, "detail"));
                return this;
            }

            /**
             * Builds the {@code AddedItem}.
             *
             * @return the {@code AddedItem}
             */
            public AddedItem build() {
                return new AddedItem(
                        id, extension, modifierExtension, itemSequence, detailSequence, subDetailSequence,
                        traceNumber, provider, revenue, productOrService, productOrServiceEnd, request, modifier,
                        programCode, serviced, location, patientPaid, quantity, unitPrice, factor, tax, net, bodySite,
                        noteNumber, reviewOutcome, adjudication, detail);
            }
        }
    }

    /**
     * Categorized monetary totals for the adjudication.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param category Type of adjudication information. Required.
     * @param amount Financial total for the category. Required.
     */
    public record Total(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept category,
            Money amount) implements BackboneElement {

        /**
         * Creates a {@code Total}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Total {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(category, "ExplanationOfBenefit.total.category is required");
            Objects.requireNonNull(amount, "ExplanationOfBenefit.total.amount is required");
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
         * Returns a builder initialized with the values of this {@code Total}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Total}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept category;
            private Money amount;

            private Builder() {
            }

            private Builder(Total original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.category = original.category();
                this.amount = original.amount();
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
             * Sets {@code amount}.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(Money amount) {
                this.amount = amount;
                return this;
            }

            /**
             * Builds the {@code Total}.
             *
             * @return the {@code Total}
             * @throws NullPointerException if a required element is absent
             */
            public Total build() {
                return new Total(
                        id, extension, modifierExtension, category, amount);
            }
        }
    }

    /**
     * Payment details for the adjudication of the claim.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Partial or complete payment.
     * @param adjustment Payment adjustment for non-claim issues.
     * @param adjustmentReason Explanation for the variance.
     * @param date Expected date of payment.
     * @param amount Payable amount after adjustment.
     * @param identifier Business identifier for the payment.
     */
    public record Payment(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            Money adjustment,
            CodeableConcept adjustmentReason,
            FhirDate date,
            Money amount,
            Identifier identifier) implements BackboneElement {

        /**
         * Creates a {@code Payment}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Payment {
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
         * Returns a builder initialized with the values of this {@code Payment}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Payment}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private Money adjustment;
            private CodeableConcept adjustmentReason;
            private FhirDate date;
            private Money amount;
            private Identifier identifier;

            private Builder() {
            }

            private Builder(Payment original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.adjustment = original.adjustment();
                this.adjustmentReason = original.adjustmentReason();
                this.date = original.date();
                this.amount = original.amount();
                this.identifier = original.identifier();
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
             * Sets {@code adjustment}.
             *
             * @param adjustment the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder adjustment(Money adjustment) {
                this.adjustment = adjustment;
                return this;
            }

            /**
             * Sets {@code adjustmentReason}.
             *
             * @param adjustmentReason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder adjustmentReason(CodeableConcept adjustmentReason) {
                this.adjustmentReason = adjustmentReason;
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
             * Sets {@code amount}.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(Money amount) {
                this.amount = amount;
                return this;
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
             * Builds the {@code Payment}.
             *
             * @return the {@code Payment}
             */
            public Payment build() {
                return new Payment(
                        id, extension, modifierExtension, type, adjustment, adjustmentReason, date, amount,
                        identifier);
            }
        }
    }

    /**
     * A note that describes or explains adjudication results in a human readable form.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param number Note instance identifier.
     * @param type Note purpose.
     * @param text Note explanatory text.
     * @param language Language of the text.
     */
    public record Note(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt number,
            CodeableConcept type,
            FhirString text,
            CodeableConcept language) implements BackboneElement {

        /**
         * Creates a {@code Note}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Note {
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
         * Returns a builder initialized with the values of this {@code Note}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Note}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt number;
            private CodeableConcept type;
            private FhirString text;
            private CodeableConcept language;

            private Builder() {
            }

            private Builder(Note original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.number = original.number();
                this.type = original.type();
                this.text = original.text();
                this.language = original.language();
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
             * Sets {@code number}.
             *
             * @param number the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder number(FhirPositiveInt number) {
                this.number = number;
                return this;
            }

            /**
             * Sets {@code number}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param number the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder number(Integer number) {
                return number(number == null ? null : FhirPositiveInt.of(number));
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
             * Sets {@code text}.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(FhirString text) {
                this.text = text;
                return this;
            }

            /**
             * Sets {@code text}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(String text) {
                return text(text == null ? null : FhirString.of(text));
            }

            /**
             * Sets {@code language}.
             *
             * @param language the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder language(CodeableConcept language) {
                this.language = language;
                return this;
            }

            /**
             * Builds the {@code Note}.
             *
             * @return the {@code Note}
             */
            public Note build() {
                return new Note(
                        id, extension, modifierExtension, number, type, text, language);
            }
        }
    }

    /**
     * Balance by Benefit Category.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param category Benefit classification. Required.
     * @param excluded Excluded from the plan.
     * @param name Short name for the benefit.
     * @param description Description of the benefit or services covered.
     * @param network In or out of network.
     * @param unit Individual or family.
     * @param term Annual or lifetime.
     * @param financial Benefit Summary.
     */
    public record BenefitBalance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept category,
            FhirBoolean excluded,
            FhirString name,
            FhirString description,
            CodeableConcept network,
            CodeableConcept unit,
            CodeableConcept term,
            List<Benefit> financial) implements BackboneElement {

        /**
         * Creates a {@code BenefitBalance}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public BenefitBalance {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            financial = financial == null ? List.of() : List.copyOf(financial);
            Objects.requireNonNull(category, "ExplanationOfBenefit.benefitBalance.category is required");
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
         * Returns a builder initialized with the values of this {@code BenefitBalance}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Benefits Used to date.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type Benefit classification. Required.
         * @param allowed Benefits allowed. One of unsignedInt, string, Money.
         * @param used Benefits used. One of unsignedInt, Money.
         */
        public record Benefit(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                DataType allowed,
                DataType used) implements BackboneElement {

            /**
             * Creates a {@code Benefit}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Benefit {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(type, "ExplanationOfBenefit.benefitBalance.financial.type is required");
                if (allowed != null && !(allowed instanceof FhirUnsignedInt
                        || allowed instanceof FhirString
                        || allowed instanceof Money)) {
                    throw new IllegalArgumentException(
                            "ExplanationOfBenefit.benefitBalance.financial.allowed[x] does not allow "
                                    + allowed.getClass().getSimpleName());
                }
                if (used != null && !(used instanceof FhirUnsignedInt || used instanceof Money)) {
                    throw new IllegalArgumentException(
                            "ExplanationOfBenefit.benefitBalance.financial.used[x] does not allow "
                                    + used.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code Benefit}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Benefit}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private DataType allowed;
                private DataType used;

                private Builder() {
                }

                private Builder(Benefit original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.allowed = original.allowed();
                    this.used = original.used();
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
                 * Sets {@code allowed} to a unsignedInt.
                 *
                 * @param allowed the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder allowed(FhirUnsignedInt allowed) {
                    this.allowed = allowed;
                    return this;
                }

                /**
                 * Sets {@code allowed} to a string.
                 *
                 * @param allowed the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder allowed(FhirString allowed) {
                    this.allowed = allowed;
                    return this;
                }

                /**
                 * Sets {@code allowed} to a Money.
                 *
                 * @param allowed the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder allowed(Money allowed) {
                    this.allowed = allowed;
                    return this;
                }

                /**
                 * Sets {@code allowed} to a unsignedInt without id or extensions.
                 *
                 * @param allowed the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder allowed(Integer allowed) {
                    this.allowed = allowed == null ? null : FhirUnsignedInt.of(allowed);
                    return this;
                }

                /**
                 * Sets {@code allowed} to a string without id or extensions.
                 *
                 * @param allowed the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder allowed(String allowed) {
                    this.allowed = allowed == null ? null : FhirString.of(allowed);
                    return this;
                }

                /**
                 * Sets {@code used} to a unsignedInt.
                 *
                 * @param used the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder used(FhirUnsignedInt used) {
                    this.used = used;
                    return this;
                }

                /**
                 * Sets {@code used} to a Money.
                 *
                 * @param used the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder used(Money used) {
                    this.used = used;
                    return this;
                }

                /**
                 * Sets {@code used} to a unsignedInt without id or extensions.
                 *
                 * @param used the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder used(Integer used) {
                    this.used = used == null ? null : FhirUnsignedInt.of(used);
                    return this;
                }

                /**
                 * Builds the {@code Benefit}.
                 *
                 * @return the {@code Benefit}
                 * @throws NullPointerException if a required element is absent
                 */
                public Benefit build() {
                    return new Benefit(
                            id, extension, modifierExtension, type, allowed, used);
                }
            }
        }

        /** Builder for {@link BenefitBalance}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept category;
            private FhirBoolean excluded;
            private FhirString name;
            private FhirString description;
            private CodeableConcept network;
            private CodeableConcept unit;
            private CodeableConcept term;
            private List<Benefit> financial = new ArrayList<>();

            private Builder() {
            }

            private Builder(BenefitBalance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.category = original.category();
                this.excluded = original.excluded();
                this.name = original.name();
                this.description = original.description();
                this.network = original.network();
                this.unit = original.unit();
                this.term = original.term();
                this.financial = new ArrayList<>(original.financial());
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
             * Sets {@code excluded}.
             *
             * @param excluded the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder excluded(FhirBoolean excluded) {
                this.excluded = excluded;
                return this;
            }

            /**
             * Sets {@code excluded}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param excluded the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder excluded(Boolean excluded) {
                return excluded(excluded == null ? null : FhirBoolean.of(excluded));
            }

            /**
             * Sets {@code name}.
             *
             * @param name the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder name(FhirString name) {
                this.name = name;
                return this;
            }

            /**
             * Sets {@code name}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param name the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder name(String name) {
                return name(name == null ? null : FhirString.of(name));
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
             * Sets {@code network}.
             *
             * @param network the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder network(CodeableConcept network) {
                this.network = network;
                return this;
            }

            /**
             * Sets {@code unit}.
             *
             * @param unit the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder unit(CodeableConcept unit) {
                this.unit = unit;
                return this;
            }

            /**
             * Sets {@code term}.
             *
             * @param term the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder term(CodeableConcept term) {
                this.term = term;
                return this;
            }

            /**
             * Replaces all {@code financial} values.
             *
             * @param financial the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder financial(List<Benefit> financial) {
                this.financial = financial == null ? new ArrayList<>() : new ArrayList<>(financial);
                return this;
            }

            /**
             * Adds a {@code financial} value.
             *
             * @param financial the value to add
             * @return this builder
             */
            public Builder addFinancial(Benefit financial) {
                this.financial.add(Objects.requireNonNull(financial, "financial"));
                return this;
            }

            /**
             * Builds the {@code BenefitBalance}.
             *
             * @return the {@code BenefitBalance}
             * @throws NullPointerException if a required element is absent
             */
            public BenefitBalance build() {
                return new BenefitBalance(
                        id, extension, modifierExtension, category, excluded, name, description, network, unit, term,
                        financial);
            }
        }
    }

    /** Builder for {@link ExplanationOfBenefit}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<ExplanationOfBenefitStatus> status;
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
        private CodeableConcept fundsReserveRequested;
        private CodeableConcept fundsReserve;
        private List<RelatedClaim> related = new ArrayList<>();
        private Reference prescription;
        private Reference originalPrescription;
        private List<Event> event = new ArrayList<>();
        private Payee payee;
        private Reference referral;
        private List<Reference> encounter = new ArrayList<>();
        private Reference facility;
        private Reference claim;
        private Reference claimResponse;
        private FhirEnum<ClaimProcessingCodes> outcome;
        private CodeableConcept decision;
        private FhirString disposition;
        private List<FhirString> preAuthRef = new ArrayList<>();
        private List<Period> preAuthRefPeriod = new ArrayList<>();
        private CodeableConcept diagnosisRelatedGroup;
        private List<CareTeam> careTeam = new ArrayList<>();
        private List<SupportingInformation> supportingInfo = new ArrayList<>();
        private List<Diagnosis> diagnosis = new ArrayList<>();
        private List<Procedure> procedure = new ArrayList<>();
        private FhirPositiveInt precedence;
        private List<Insurance> insurance = new ArrayList<>();
        private Accident accident;
        private Money patientPaid;
        private List<Item> item = new ArrayList<>();
        private List<AddedItem> addItem = new ArrayList<>();
        private List<ExplanationOfBenefit.Item.Adjudication> adjudication = new ArrayList<>();
        private List<Total> total = new ArrayList<>();
        private Payment payment;
        private CodeableConcept formCode;
        private Attachment form;
        private List<Note> processNote = new ArrayList<>();
        private Period benefitPeriod;
        private List<BenefitBalance> benefitBalance = new ArrayList<>();

        private Builder() {
        }

        private Builder(ExplanationOfBenefit original) {
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
            this.fundsReserveRequested = original.fundsReserveRequested();
            this.fundsReserve = original.fundsReserve();
            this.related = new ArrayList<>(original.related());
            this.prescription = original.prescription();
            this.originalPrescription = original.originalPrescription();
            this.event = new ArrayList<>(original.event());
            this.payee = original.payee();
            this.referral = original.referral();
            this.encounter = new ArrayList<>(original.encounter());
            this.facility = original.facility();
            this.claim = original.claim();
            this.claimResponse = original.claimResponse();
            this.outcome = original.outcome();
            this.decision = original.decision();
            this.disposition = original.disposition();
            this.preAuthRef = new ArrayList<>(original.preAuthRef());
            this.preAuthRefPeriod = new ArrayList<>(original.preAuthRefPeriod());
            this.diagnosisRelatedGroup = original.diagnosisRelatedGroup();
            this.careTeam = new ArrayList<>(original.careTeam());
            this.supportingInfo = new ArrayList<>(original.supportingInfo());
            this.diagnosis = new ArrayList<>(original.diagnosis());
            this.procedure = new ArrayList<>(original.procedure());
            this.precedence = original.precedence();
            this.insurance = new ArrayList<>(original.insurance());
            this.accident = original.accident();
            this.patientPaid = original.patientPaid();
            this.item = new ArrayList<>(original.item());
            this.addItem = new ArrayList<>(original.addItem());
            this.adjudication = new ArrayList<>(original.adjudication());
            this.total = new ArrayList<>(original.total());
            this.payment = original.payment();
            this.formCode = original.formCode();
            this.form = original.form();
            this.processNote = new ArrayList<>(original.processNote());
            this.benefitPeriod = original.benefitPeriod();
            this.benefitBalance = new ArrayList<>(original.benefitBalance());
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
        public Builder status(FhirEnum<ExplanationOfBenefitStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(ExplanationOfBenefitStatus status) {
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
         * Sets {@code fundsReserveRequested}.
         *
         * @param fundsReserveRequested the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder fundsReserveRequested(CodeableConcept fundsReserveRequested) {
            this.fundsReserveRequested = fundsReserveRequested;
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
         * Sets {@code outcome}.
         *
         * @param outcome the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outcome(FhirEnum<ClaimProcessingCodes> outcome) {
            this.outcome = outcome;
            return this;
        }

        /**
         * Sets {@code outcome}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param outcome the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outcome(ClaimProcessingCodes outcome) {
            return outcome(outcome == null ? null : FhirEnum.of(outcome));
        }

        /**
         * Sets {@code decision}.
         *
         * @param decision the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder decision(CodeableConcept decision) {
            this.decision = decision;
            return this;
        }

        /**
         * Sets {@code disposition}.
         *
         * @param disposition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder disposition(FhirString disposition) {
            this.disposition = disposition;
            return this;
        }

        /**
         * Sets {@code disposition}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param disposition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder disposition(String disposition) {
            return disposition(disposition == null ? null : FhirString.of(disposition));
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
         * Replaces all {@code preAuthRefPeriod} values.
         *
         * @param preAuthRefPeriod the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder preAuthRefPeriod(List<Period> preAuthRefPeriod) {
            this.preAuthRefPeriod = preAuthRefPeriod == null ? new ArrayList<>() : new ArrayList<>(preAuthRefPeriod);
            return this;
        }

        /**
         * Adds a {@code preAuthRefPeriod} value.
         *
         * @param preAuthRefPeriod the value to add
         * @return this builder
         */
        public Builder addPreAuthRefPeriod(Period preAuthRefPeriod) {
            this.preAuthRefPeriod.add(Objects.requireNonNull(preAuthRefPeriod, "preAuthRefPeriod"));
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
         * Sets {@code precedence}.
         *
         * @param precedence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder precedence(FhirPositiveInt precedence) {
            this.precedence = precedence;
            return this;
        }

        /**
         * Sets {@code precedence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param precedence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder precedence(Integer precedence) {
            return precedence(precedence == null ? null : FhirPositiveInt.of(precedence));
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
         * Replaces all {@code addItem} values.
         *
         * @param addItem the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder addItem(List<AddedItem> addItem) {
            this.addItem = addItem == null ? new ArrayList<>() : new ArrayList<>(addItem);
            return this;
        }

        /**
         * Adds a {@code addItem} value.
         *
         * @param addItem the value to add
         * @return this builder
         */
        public Builder addAddItem(AddedItem addItem) {
            this.addItem.add(Objects.requireNonNull(addItem, "addItem"));
            return this;
        }

        /**
         * Replaces all {@code adjudication} values.
         *
         * @param adjudication the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder adjudication(List<ExplanationOfBenefit.Item.Adjudication> adjudication) {
            this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
            return this;
        }

        /**
         * Adds a {@code adjudication} value.
         *
         * @param adjudication the value to add
         * @return this builder
         */
        public Builder addAdjudication(ExplanationOfBenefit.Item.Adjudication adjudication) {
            this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
            return this;
        }

        /**
         * Replaces all {@code total} values.
         *
         * @param total the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder total(List<Total> total) {
            this.total = total == null ? new ArrayList<>() : new ArrayList<>(total);
            return this;
        }

        /**
         * Adds a {@code total} value.
         *
         * @param total the value to add
         * @return this builder
         */
        public Builder addTotal(Total total) {
            this.total.add(Objects.requireNonNull(total, "total"));
            return this;
        }

        /**
         * Sets {@code payment}.
         *
         * @param payment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder payment(Payment payment) {
            this.payment = payment;
            return this;
        }

        /**
         * Sets {@code formCode}.
         *
         * @param formCode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder formCode(CodeableConcept formCode) {
            this.formCode = formCode;
            return this;
        }

        /**
         * Sets {@code form}.
         *
         * @param form the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder form(Attachment form) {
            this.form = form;
            return this;
        }

        /**
         * Replaces all {@code processNote} values.
         *
         * @param processNote the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder processNote(List<Note> processNote) {
            this.processNote = processNote == null ? new ArrayList<>() : new ArrayList<>(processNote);
            return this;
        }

        /**
         * Adds a {@code processNote} value.
         *
         * @param processNote the value to add
         * @return this builder
         */
        public Builder addProcessNote(Note processNote) {
            this.processNote.add(Objects.requireNonNull(processNote, "processNote"));
            return this;
        }

        /**
         * Sets {@code benefitPeriod}.
         *
         * @param benefitPeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder benefitPeriod(Period benefitPeriod) {
            this.benefitPeriod = benefitPeriod;
            return this;
        }

        /**
         * Replaces all {@code benefitBalance} values.
         *
         * @param benefitBalance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder benefitBalance(List<BenefitBalance> benefitBalance) {
            this.benefitBalance = benefitBalance == null ? new ArrayList<>() : new ArrayList<>(benefitBalance);
            return this;
        }

        /**
         * Adds a {@code benefitBalance} value.
         *
         * @param benefitBalance the value to add
         * @return this builder
         */
        public Builder addBenefitBalance(BenefitBalance benefitBalance) {
            this.benefitBalance.add(Objects.requireNonNull(benefitBalance, "benefitBalance"));
            return this;
        }

        /**
         * Builds the {@code ExplanationOfBenefit}.
         *
         * @return the {@code ExplanationOfBenefit}
         * @throws NullPointerException if a required element is absent
         */
        public ExplanationOfBenefit build() {
            return new ExplanationOfBenefit(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    traceNumber, status, type, subType, use, patient, billablePeriod, created, enterer, insurer,
                    provider, priority, fundsReserveRequested, fundsReserve, related, prescription,
                    originalPrescription, event, payee, referral, encounter, facility, claim, claimResponse, outcome,
                    decision, disposition, preAuthRef, preAuthRefPeriod, diagnosisRelatedGroup, careTeam,
                    supportingInfo, diagnosis, procedure, precedence, insurance, accident, patientPaid, item, addItem,
                    adjudication, total, payment, formCode, form, processNote, benefitPeriod, benefitBalance);
        }
    }
}
