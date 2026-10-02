package se.poroli.fhirplace.r5.financial.payment;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.NoteType;
import se.poroli.fhirplace.r5.valuesets.PaymentOutcome;

/**
 * This resource provides the details including amount of a payment and allocates the payment items being paid.
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
 * @param identifier Business Identifier for a payment reconciliation.
 * @param type Category of payment. Required.
 * @param status active | cancelled | draft | entered-in-error. Required. Modifier element.
 * @param kind Workflow originating payment.
 * @param period Period covered.
 * @param created Creation date. Required.
 * @param enterer Who entered the payment. Reference to Practitioner, PractitionerRole, Organization.
 * @param issuerType Nature of the source.
 * @param paymentIssuer Party generating payment. Reference to Organization, Patient, RelatedPerson.
 * @param request Reference to requesting resource. Reference to Task.
 * @param requestor Responsible practitioner. Reference to Practitioner, PractitionerRole, Organization.
 * @param outcome queued | complete | error | partial.
 * @param disposition Disposition message.
 * @param date When payment issued. Required.
 * @param location Where payment collected. Reference to Location.
 * @param method Payment instrument.
 * @param cardBrand Type of card.
 * @param accountNumber Digits for verification.
 * @param expirationDate Expiration year-month.
 * @param processor Processor name.
 * @param referenceNumber Check number or payment reference.
 * @param authorization Authorization number.
 * @param tenderedAmount Amount offered by the issuer.
 * @param returnedAmount Amount returned by the receiver.
 * @param amount Total amount of Payment. Required.
 * @param paymentIdentifier Business identifier for the payment.
 * @param allocation Settlement particulars.
 * @param formCode Printed form identifier.
 * @param processNote Note concerning processing.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/PaymentReconciliation">FHIR R5 PaymentReconciliation</a>
 */
public record PaymentReconciliation(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        CodeableConcept type,
        FhirEnum<FinancialResourceStatusCodes> status,
        CodeableConcept kind,
        Period period,
        FhirDateTime created,
        Reference enterer,
        CodeableConcept issuerType,
        Reference paymentIssuer,
        Reference request,
        Reference requestor,
        FhirEnum<PaymentOutcome> outcome,
        FhirString disposition,
        FhirDate date,
        Reference location,
        CodeableConcept method,
        FhirString cardBrand,
        FhirString accountNumber,
        FhirDate expirationDate,
        FhirString processor,
        FhirString referenceNumber,
        FhirString authorization,
        Money tenderedAmount,
        Money returnedAmount,
        Money amount,
        Identifier paymentIdentifier,
        List<Allocation> allocation,
        CodeableConcept formCode,
        List<Notes> processNote) implements DomainResource {

    /**
     * Creates a {@code PaymentReconciliation}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public PaymentReconciliation {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        allocation = allocation == null ? List.of() : List.copyOf(allocation);
        processNote = processNote == null ? List.of() : List.copyOf(processNote);
        Objects.requireNonNull(type, "PaymentReconciliation.type is required");
        Objects.requireNonNull(status, "PaymentReconciliation.status is required");
        Objects.requireNonNull(created, "PaymentReconciliation.created is required");
        Objects.requireNonNull(date, "PaymentReconciliation.date is required");
        Objects.requireNonNull(amount, "PaymentReconciliation.amount is required");
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
     * Returns a builder initialized with the values of this {@code PaymentReconciliation}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Distribution of the payment amount for a previously acknowledged payable.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier Business identifier of the payment detail.
     * @param predecessor Business identifier of the prior payment detail.
     * @param target Subject of the payment. Reference to Claim, Account, Invoice, ChargeItem, Encounter, Contract.
     * @param targetItem Sub-element of the subject. One of string, Identifier, positiveInt.
     * @param encounter Applied-to encounter. Reference to Encounter.
     * @param account Applied-to account. Reference to Account.
     * @param type Category of payment.
     * @param submitter Submitter of the request. Reference to Practitioner, PractitionerRole, Organization.
     * @param response Response committing to a payment. Reference to ClaimResponse.
     * @param date Date of commitment to pay.
     * @param responsible Contact for the response. Reference to PractitionerRole.
     * @param payee Recipient of the payment. Reference to Practitioner, PractitionerRole, Organization.
     * @param amount Amount allocated to this payable.
     */
    public record Allocation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Identifier identifier,
            Identifier predecessor,
            Reference target,
            DataType targetItem,
            Reference encounter,
            Reference account,
            CodeableConcept type,
            Reference submitter,
            Reference response,
            FhirDate date,
            Reference responsible,
            Reference payee,
            Money amount) implements BackboneElement {

        /**
         * Creates an {@code Allocation}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Allocation {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (targetItem != null && !(targetItem instanceof FhirString
                    || targetItem instanceof Identifier
                    || targetItem instanceof FhirPositiveInt)) {
                throw new IllegalArgumentException(
                        "PaymentReconciliation.allocation.targetItem[x] does not allow "
                                + targetItem.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Allocation}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Allocation}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Identifier identifier;
            private Identifier predecessor;
            private Reference target;
            private DataType targetItem;
            private Reference encounter;
            private Reference account;
            private CodeableConcept type;
            private Reference submitter;
            private Reference response;
            private FhirDate date;
            private Reference responsible;
            private Reference payee;
            private Money amount;

            private Builder() {
            }

            private Builder(Allocation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = original.identifier();
                this.predecessor = original.predecessor();
                this.target = original.target();
                this.targetItem = original.targetItem();
                this.encounter = original.encounter();
                this.account = original.account();
                this.type = original.type();
                this.submitter = original.submitter();
                this.response = original.response();
                this.date = original.date();
                this.responsible = original.responsible();
                this.payee = original.payee();
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
             * Sets {@code predecessor}.
             *
             * @param predecessor the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder predecessor(Identifier predecessor) {
                this.predecessor = predecessor;
                return this;
            }

            /**
             * Sets {@code target}.
             *
             * @param target the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder target(Reference target) {
                this.target = target;
                return this;
            }

            /**
             * Sets {@code targetItem} to a string.
             *
             * @param targetItem the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder targetItem(FhirString targetItem) {
                this.targetItem = targetItem;
                return this;
            }

            /**
             * Sets {@code targetItem} to a Identifier.
             *
             * @param targetItem the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder targetItem(Identifier targetItem) {
                this.targetItem = targetItem;
                return this;
            }

            /**
             * Sets {@code targetItem} to a positiveInt.
             *
             * @param targetItem the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder targetItem(FhirPositiveInt targetItem) {
                this.targetItem = targetItem;
                return this;
            }

            /**
             * Sets {@code targetItem} to a string without id or extensions.
             *
             * @param targetItem the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder targetItem(String targetItem) {
                this.targetItem = targetItem == null ? null : FhirString.of(targetItem);
                return this;
            }

            /**
             * Sets {@code targetItem} to a positiveInt without id or extensions.
             *
             * @param targetItem the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder targetItem(Integer targetItem) {
                this.targetItem = targetItem == null ? null : FhirPositiveInt.of(targetItem);
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
             * Sets {@code account}.
             *
             * @param account the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder account(Reference account) {
                this.account = account;
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
             * Sets {@code submitter}.
             *
             * @param submitter the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder submitter(Reference submitter) {
                this.submitter = submitter;
                return this;
            }

            /**
             * Sets {@code response}.
             *
             * @param response the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder response(Reference response) {
                this.response = response;
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
             * Sets {@code responsible}.
             *
             * @param responsible the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder responsible(Reference responsible) {
                this.responsible = responsible;
                return this;
            }

            /**
             * Sets {@code payee}.
             *
             * @param payee the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder payee(Reference payee) {
                this.payee = payee;
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
             * Builds the {@code Allocation}.
             *
             * @return the {@code Allocation}
             */
            public Allocation build() {
                return new Allocation(
                        id, extension, modifierExtension, identifier, predecessor, target, targetItem, encounter,
                        account, type, submitter, response, date, responsible, payee, amount);
            }
        }
    }

    /**
     * A note that describes or explains the processing in a human readable form.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type display | print | printoper.
     * @param text Note explanatory text.
     */
    public record Notes(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<NoteType> type,
            FhirString text) implements BackboneElement {

        /**
         * Creates a {@code Notes}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Notes {
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
         * Returns a builder initialized with the values of this {@code Notes}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Notes}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<NoteType> type;
            private FhirString text;

            private Builder() {
            }

            private Builder(Notes original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.text = original.text();
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
            public Builder type(FhirEnum<NoteType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(NoteType type) {
                return type(type == null ? null : FhirEnum.of(type));
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
             * Builds the {@code Notes}.
             *
             * @return the {@code Notes}
             */
            public Notes build() {
                return new Notes(
                        id, extension, modifierExtension, type, text);
            }
        }
    }

    /** Builder for {@link PaymentReconciliation}. Builders are mutable and not thread-safe. */
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
        private CodeableConcept type;
        private FhirEnum<FinancialResourceStatusCodes> status;
        private CodeableConcept kind;
        private Period period;
        private FhirDateTime created;
        private Reference enterer;
        private CodeableConcept issuerType;
        private Reference paymentIssuer;
        private Reference request;
        private Reference requestor;
        private FhirEnum<PaymentOutcome> outcome;
        private FhirString disposition;
        private FhirDate date;
        private Reference location;
        private CodeableConcept method;
        private FhirString cardBrand;
        private FhirString accountNumber;
        private FhirDate expirationDate;
        private FhirString processor;
        private FhirString referenceNumber;
        private FhirString authorization;
        private Money tenderedAmount;
        private Money returnedAmount;
        private Money amount;
        private Identifier paymentIdentifier;
        private List<Allocation> allocation = new ArrayList<>();
        private CodeableConcept formCode;
        private List<Notes> processNote = new ArrayList<>();

        private Builder() {
        }

        private Builder(PaymentReconciliation original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.type = original.type();
            this.status = original.status();
            this.kind = original.kind();
            this.period = original.period();
            this.created = original.created();
            this.enterer = original.enterer();
            this.issuerType = original.issuerType();
            this.paymentIssuer = original.paymentIssuer();
            this.request = original.request();
            this.requestor = original.requestor();
            this.outcome = original.outcome();
            this.disposition = original.disposition();
            this.date = original.date();
            this.location = original.location();
            this.method = original.method();
            this.cardBrand = original.cardBrand();
            this.accountNumber = original.accountNumber();
            this.expirationDate = original.expirationDate();
            this.processor = original.processor();
            this.referenceNumber = original.referenceNumber();
            this.authorization = original.authorization();
            this.tenderedAmount = original.tenderedAmount();
            this.returnedAmount = original.returnedAmount();
            this.amount = original.amount();
            this.paymentIdentifier = original.paymentIdentifier();
            this.allocation = new ArrayList<>(original.allocation());
            this.formCode = original.formCode();
            this.processNote = new ArrayList<>(original.processNote());
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
         * Sets {@code kind}.
         *
         * @param kind the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder kind(CodeableConcept kind) {
            this.kind = kind;
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
         * Sets {@code issuerType}.
         *
         * @param issuerType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issuerType(CodeableConcept issuerType) {
            this.issuerType = issuerType;
            return this;
        }

        /**
         * Sets {@code paymentIssuer}.
         *
         * @param paymentIssuer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder paymentIssuer(Reference paymentIssuer) {
            this.paymentIssuer = paymentIssuer;
            return this;
        }

        /**
         * Sets {@code request}.
         *
         * @param request the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder request(Reference request) {
            this.request = request;
            return this;
        }

        /**
         * Sets {@code requestor}.
         *
         * @param requestor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requestor(Reference requestor) {
            this.requestor = requestor;
            return this;
        }

        /**
         * Sets {@code outcome}.
         *
         * @param outcome the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outcome(FhirEnum<PaymentOutcome> outcome) {
            this.outcome = outcome;
            return this;
        }

        /**
         * Sets {@code outcome}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param outcome the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outcome(PaymentOutcome outcome) {
            return outcome(outcome == null ? null : FhirEnum.of(outcome));
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
         * Sets {@code method}.
         *
         * @param method the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder method(CodeableConcept method) {
            this.method = method;
            return this;
        }

        /**
         * Sets {@code cardBrand}.
         *
         * @param cardBrand the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder cardBrand(FhirString cardBrand) {
            this.cardBrand = cardBrand;
            return this;
        }

        /**
         * Sets {@code cardBrand}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param cardBrand the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder cardBrand(String cardBrand) {
            return cardBrand(cardBrand == null ? null : FhirString.of(cardBrand));
        }

        /**
         * Sets {@code accountNumber}.
         *
         * @param accountNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder accountNumber(FhirString accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        /**
         * Sets {@code accountNumber}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param accountNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder accountNumber(String accountNumber) {
            return accountNumber(accountNumber == null ? null : FhirString.of(accountNumber));
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
         * Sets {@code processor}.
         *
         * @param processor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder processor(FhirString processor) {
            this.processor = processor;
            return this;
        }

        /**
         * Sets {@code processor}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param processor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder processor(String processor) {
            return processor(processor == null ? null : FhirString.of(processor));
        }

        /**
         * Sets {@code referenceNumber}.
         *
         * @param referenceNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder referenceNumber(FhirString referenceNumber) {
            this.referenceNumber = referenceNumber;
            return this;
        }

        /**
         * Sets {@code referenceNumber}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param referenceNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder referenceNumber(String referenceNumber) {
            return referenceNumber(referenceNumber == null ? null : FhirString.of(referenceNumber));
        }

        /**
         * Sets {@code authorization}.
         *
         * @param authorization the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authorization(FhirString authorization) {
            this.authorization = authorization;
            return this;
        }

        /**
         * Sets {@code authorization}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param authorization the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authorization(String authorization) {
            return authorization(authorization == null ? null : FhirString.of(authorization));
        }

        /**
         * Sets {@code tenderedAmount}.
         *
         * @param tenderedAmount the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder tenderedAmount(Money tenderedAmount) {
            this.tenderedAmount = tenderedAmount;
            return this;
        }

        /**
         * Sets {@code returnedAmount}.
         *
         * @param returnedAmount the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder returnedAmount(Money returnedAmount) {
            this.returnedAmount = returnedAmount;
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
         * Sets {@code paymentIdentifier}.
         *
         * @param paymentIdentifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder paymentIdentifier(Identifier paymentIdentifier) {
            this.paymentIdentifier = paymentIdentifier;
            return this;
        }

        /**
         * Replaces all {@code allocation} values.
         *
         * @param allocation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder allocation(List<Allocation> allocation) {
            this.allocation = allocation == null ? new ArrayList<>() : new ArrayList<>(allocation);
            return this;
        }

        /**
         * Adds a {@code allocation} value.
         *
         * @param allocation the value to add
         * @return this builder
         */
        public Builder addAllocation(Allocation allocation) {
            this.allocation.add(Objects.requireNonNull(allocation, "allocation"));
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
         * Replaces all {@code processNote} values.
         *
         * @param processNote the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder processNote(List<Notes> processNote) {
            this.processNote = processNote == null ? new ArrayList<>() : new ArrayList<>(processNote);
            return this;
        }

        /**
         * Adds a {@code processNote} value.
         *
         * @param processNote the value to add
         * @return this builder
         */
        public Builder addProcessNote(Notes processNote) {
            this.processNote.add(Objects.requireNonNull(processNote, "processNote"));
            return this;
        }

        /**
         * Builds the {@code PaymentReconciliation}.
         *
         * @return the {@code PaymentReconciliation}
         * @throws NullPointerException if a required element is absent
         */
        public PaymentReconciliation build() {
            return new PaymentReconciliation(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    type, status, kind, period, created, enterer, issuerType, paymentIssuer, request, requestor,
                    outcome, disposition, date, location, method, cardBrand, accountNumber, expirationDate, processor,
                    referenceNumber, authorization, tenderedAmount, returnedAmount, amount, paymentIdentifier,
                    allocation, formCode, processNote);
        }
    }
}
