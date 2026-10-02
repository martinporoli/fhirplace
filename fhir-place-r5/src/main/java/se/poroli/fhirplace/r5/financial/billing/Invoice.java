package se.poroli.fhirplace.r5.financial.billing;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.InvoiceStatus;

/**
 * Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing
 * purpose.
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
 * @param identifier Business Identifier for item.
 * @param status draft | issued | balanced | cancelled | entered-in-error. Required. Modifier element.
 * @param cancelledReason Reason for cancellation of this Invoice.
 * @param type Type of Invoice.
 * @param subject Recipient(s) of goods and services. Reference to Patient, Group.
 * @param recipient Recipient of this invoice. Reference to Organization, Patient, RelatedPerson.
 * @param date DEPRICATED.
 * @param creation When posted.
 * @param period Billing date or period. One of date, Period.
 * @param participant Participant in creation of this Invoice.
 * @param issuer Issuing Organization of Invoice. Reference to Organization.
 * @param account Account that is being balanced. Reference to Account.
 * @param lineItem Line items of this Invoice.
 * @param totalPriceComponent Components of Invoice total.
 * @param totalNet Net total of this Invoice.
 * @param totalGross Gross total of this Invoice.
 * @param paymentTerms Payment details.
 * @param note Comments made about the invoice.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Invoice">FHIR R5 Invoice</a>
 */
public record Invoice(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<InvoiceStatus> status,
        FhirString cancelledReason,
        CodeableConcept type,
        Reference subject,
        Reference recipient,
        FhirDateTime date,
        FhirDateTime creation,
        DataType period,
        List<Participant> participant,
        Reference issuer,
        Reference account,
        List<LineItem> lineItem,
        List<MonetaryComponent> totalPriceComponent,
        Money totalNet,
        Money totalGross,
        FhirMarkdown paymentTerms,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates an {@code Invoice}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Invoice {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        participant = participant == null ? List.of() : List.copyOf(participant);
        lineItem = lineItem == null ? List.of() : List.copyOf(lineItem);
        totalPriceComponent = totalPriceComponent == null ? List.of() : List.copyOf(totalPriceComponent);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "Invoice.status is required");
        if (period != null && !(period instanceof FhirDate || period instanceof Period)) {
            throw new IllegalArgumentException(
                    "Invoice.period[x] must be one of date, Period, but was "
                            + period.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Invoice}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates who or what performed or participated in the charged service.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param role Type of involvement in creation of this Invoice.
     * @param actor Individual who was involved. Reference to Practitioner, Organization, Patient, PractitionerRole,
     *   Device, RelatedPerson. Required.
     */
    public record Participant(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept role,
            Reference actor) implements BackboneElement {

        /**
         * Creates a {@code Participant}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Participant {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(actor, "Invoice.participant.actor is required");
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
            private CodeableConcept role;
            private Reference actor;

            private Builder() {
            }

            private Builder(Participant original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.role = original.role();
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
             * @throws NullPointerException if a required element is absent
             */
            public Participant build() {
                return new Participant(
                        id, extension, modifierExtension, role, actor);
            }
        }
    }

    /**
     * Each line item represents one charge for goods and services rendered.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param sequence Sequence number of line item.
     * @param serviced Service data or period. One of date, Period.
     * @param chargeItem Reference to ChargeItem containing details of this line item or an inline billing code. One
     *   of Reference, CodeableConcept. Required.
     * @param priceComponent Components of total line item price.
     */
    public record LineItem(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            DataType serviced,
            DataType chargeItem,
            List<MonetaryComponent> priceComponent) implements BackboneElement {

        /**
         * Creates a {@code LineItem}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public LineItem {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            priceComponent = priceComponent == null ? List.of() : List.copyOf(priceComponent);
            Objects.requireNonNull(chargeItem, "Invoice.lineItem.chargeItem is required");
            if (serviced != null && !(serviced instanceof FhirDate || serviced instanceof Period)) {
                throw new IllegalArgumentException(
                        "Invoice.lineItem.serviced[x] must be one of date, Period, but was "
                                + serviced.getClass().getSimpleName());
            }
            if (chargeItem != null && !(chargeItem instanceof Reference || chargeItem instanceof CodeableConcept)) {
                throw new IllegalArgumentException(
                        "Invoice.lineItem.chargeItem[x] must be one of Reference, CodeableConcept, but was "
                                + chargeItem.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code LineItem}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link LineItem}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt sequence;
            private DataType serviced;
            private DataType chargeItem;
            private List<MonetaryComponent> priceComponent = new ArrayList<>();

            private Builder() {
            }

            private Builder(LineItem original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.serviced = original.serviced();
                this.chargeItem = original.chargeItem();
                this.priceComponent = new ArrayList<>(original.priceComponent());
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
             * Sets {@code chargeItem} to a Reference.
             *
             * @param chargeItem the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder chargeItem(Reference chargeItem) {
                this.chargeItem = chargeItem;
                return this;
            }

            /**
             * Sets {@code chargeItem} to a CodeableConcept.
             *
             * @param chargeItem the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder chargeItem(CodeableConcept chargeItem) {
                this.chargeItem = chargeItem;
                return this;
            }

            /**
             * Replaces all {@code priceComponent} values.
             *
             * @param priceComponent the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder priceComponent(List<MonetaryComponent> priceComponent) {
                this.priceComponent = priceComponent == null ? new ArrayList<>() : new ArrayList<>(priceComponent);
                return this;
            }

            /**
             * Adds a {@code priceComponent} value.
             *
             * @param priceComponent the value to add
             * @return this builder
             */
            public Builder addPriceComponent(MonetaryComponent priceComponent) {
                this.priceComponent.add(Objects.requireNonNull(priceComponent, "priceComponent"));
                return this;
            }

            /**
             * Builds the {@code LineItem}.
             *
             * @return the {@code LineItem}
             * @throws NullPointerException if a required element is absent
             */
            public LineItem build() {
                return new LineItem(
                        id, extension, modifierExtension, sequence, serviced, chargeItem, priceComponent);
            }
        }
    }

    /** Builder for {@link Invoice}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<InvoiceStatus> status;
        private FhirString cancelledReason;
        private CodeableConcept type;
        private Reference subject;
        private Reference recipient;
        private FhirDateTime date;
        private FhirDateTime creation;
        private DataType period;
        private List<Participant> participant = new ArrayList<>();
        private Reference issuer;
        private Reference account;
        private List<LineItem> lineItem = new ArrayList<>();
        private List<MonetaryComponent> totalPriceComponent = new ArrayList<>();
        private Money totalNet;
        private Money totalGross;
        private FhirMarkdown paymentTerms;
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(Invoice original) {
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
            this.cancelledReason = original.cancelledReason();
            this.type = original.type();
            this.subject = original.subject();
            this.recipient = original.recipient();
            this.date = original.date();
            this.creation = original.creation();
            this.period = original.period();
            this.participant = new ArrayList<>(original.participant());
            this.issuer = original.issuer();
            this.account = original.account();
            this.lineItem = new ArrayList<>(original.lineItem());
            this.totalPriceComponent = new ArrayList<>(original.totalPriceComponent());
            this.totalNet = original.totalNet();
            this.totalGross = original.totalGross();
            this.paymentTerms = original.paymentTerms();
            this.note = new ArrayList<>(original.note());
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
        public Builder status(FhirEnum<InvoiceStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(InvoiceStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code cancelledReason}.
         *
         * @param cancelledReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder cancelledReason(FhirString cancelledReason) {
            this.cancelledReason = cancelledReason;
            return this;
        }

        /**
         * Sets {@code cancelledReason}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param cancelledReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder cancelledReason(String cancelledReason) {
            return cancelledReason(cancelledReason == null ? null : FhirString.of(cancelledReason));
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
         * Sets {@code recipient}.
         *
         * @param recipient the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recipient(Reference recipient) {
            this.recipient = recipient;
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
         * Sets {@code creation}.
         *
         * @param creation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder creation(FhirDateTime creation) {
            this.creation = creation;
            return this;
        }

        /**
         * Sets {@code creation}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param creation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder creation(Temporal creation) {
            return creation(creation == null ? null : FhirDateTime.of(creation));
        }

        /**
         * Sets {@code period} to a date.
         *
         * @param period the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder period(FhirDate period) {
            this.period = period;
            return this;
        }

        /**
         * Sets {@code period} to a Period.
         *
         * @param period the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder period(Period period) {
            this.period = period;
            return this;
        }

        /**
         * Sets {@code period} to a date without id or extensions.
         *
         * @param period the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder period(Temporal period) {
            this.period = period == null ? null : FhirDate.of(period);
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
         * Sets {@code issuer}.
         *
         * @param issuer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issuer(Reference issuer) {
            this.issuer = issuer;
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
         * Replaces all {@code lineItem} values.
         *
         * @param lineItem the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder lineItem(List<LineItem> lineItem) {
            this.lineItem = lineItem == null ? new ArrayList<>() : new ArrayList<>(lineItem);
            return this;
        }

        /**
         * Adds a {@code lineItem} value.
         *
         * @param lineItem the value to add
         * @return this builder
         */
        public Builder addLineItem(LineItem lineItem) {
            this.lineItem.add(Objects.requireNonNull(lineItem, "lineItem"));
            return this;
        }

        /**
         * Replaces all {@code totalPriceComponent} values.
         *
         * @param totalPriceComponent the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder totalPriceComponent(List<MonetaryComponent> totalPriceComponent) {
            this.totalPriceComponent = totalPriceComponent == null
                    ? new ArrayList<>()
                    : new ArrayList<>(totalPriceComponent);
            return this;
        }

        /**
         * Adds a {@code totalPriceComponent} value.
         *
         * @param totalPriceComponent the value to add
         * @return this builder
         */
        public Builder addTotalPriceComponent(MonetaryComponent totalPriceComponent) {
            this.totalPriceComponent.add(Objects.requireNonNull(totalPriceComponent, "totalPriceComponent"));
            return this;
        }

        /**
         * Sets {@code totalNet}.
         *
         * @param totalNet the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder totalNet(Money totalNet) {
            this.totalNet = totalNet;
            return this;
        }

        /**
         * Sets {@code totalGross}.
         *
         * @param totalGross the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder totalGross(Money totalGross) {
            this.totalGross = totalGross;
            return this;
        }

        /**
         * Sets {@code paymentTerms}.
         *
         * @param paymentTerms the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder paymentTerms(FhirMarkdown paymentTerms) {
            this.paymentTerms = paymentTerms;
            return this;
        }

        /**
         * Sets {@code paymentTerms}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param paymentTerms the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder paymentTerms(String paymentTerms) {
            return paymentTerms(paymentTerms == null ? null : FhirMarkdown.of(paymentTerms));
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
         * Builds the {@code Invoice}.
         *
         * @return the {@code Invoice}
         * @throws NullPointerException if a required element is absent
         */
        public Invoice build() {
            return new Invoice(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, cancelledReason, type, subject, recipient, date, creation, period, participant, issuer,
                    account, lineItem, totalPriceComponent, totalNet, totalGross, paymentTerms, note);
        }
    }
}
