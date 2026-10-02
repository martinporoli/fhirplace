package se.poroli.fhirplace.r5.paymentnotice;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;

/**
 * This resource provides the status of the payment for goods and services rendered, and the request and response
 * resource references.
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
 * @param identifier Business Identifier for the payment notice.
 * @param status active | cancelled | draft | entered-in-error. Required. Modifier element.
 * @param request Request reference. Reference to Resource.
 * @param response Response reference. Reference to Resource.
 * @param created Creation date. Required.
 * @param reporter Responsible practitioner. Reference to Practitioner, PractitionerRole, Organization.
 * @param payment Payment reference. Reference to PaymentReconciliation.
 * @param paymentDate Payment or clearing date.
 * @param payee Party being paid. Reference to Practitioner, PractitionerRole, Organization.
 * @param recipient Party being notified. Reference to Organization. Required.
 * @param amount Monetary amount of the payment. Required.
 * @param paymentStatus Issued or cleared Status of the payment.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/PaymentNotice">FHIR R5 PaymentNotice</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record PaymentNotice(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<FinancialResourceStatusCodes> status,
        Reference request,
        Reference response,
        FhirDateTime created,
        Reference reporter,
        Reference payment,
        FhirDate paymentDate,
        Reference payee,
        Reference recipient,
        Money amount,
        CodeableConcept paymentStatus) implements DomainResource {

    /**
     * Creates a {@code PaymentNotice}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public PaymentNotice {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        Objects.requireNonNull(status, "PaymentNotice.status is required");
        Objects.requireNonNull(created, "PaymentNotice.created is required");
        Objects.requireNonNull(recipient, "PaymentNotice.recipient is required");
        Objects.requireNonNull(amount, "PaymentNotice.amount is required");
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
     * Returns a builder initialized with the values of this {@code PaymentNotice}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link PaymentNotice}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<FinancialResourceStatusCodes> status;
        private Reference request;
        private Reference response;
        private FhirDateTime created;
        private Reference reporter;
        private Reference payment;
        private FhirDate paymentDate;
        private Reference payee;
        private Reference recipient;
        private Money amount;
        private CodeableConcept paymentStatus;

        private Builder() {
        }

        private Builder(PaymentNotice original) {
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
            this.request = original.request();
            this.response = original.response();
            this.created = original.created();
            this.reporter = original.reporter();
            this.payment = original.payment();
            this.paymentDate = original.paymentDate();
            this.payee = original.payee();
            this.recipient = original.recipient();
            this.amount = original.amount();
            this.paymentStatus = original.paymentStatus();
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
         * Sets {@code reporter}.
         *
         * @param reporter the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reporter(Reference reporter) {
            this.reporter = reporter;
            return this;
        }

        /**
         * Sets {@code payment}.
         *
         * @param payment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder payment(Reference payment) {
            this.payment = payment;
            return this;
        }

        /**
         * Sets {@code paymentDate}.
         *
         * @param paymentDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder paymentDate(FhirDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        /**
         * Sets {@code paymentDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param paymentDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder paymentDate(Temporal paymentDate) {
            return paymentDate(paymentDate == null ? null : FhirDate.of(paymentDate));
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
         * Sets {@code paymentStatus}.
         *
         * @param paymentStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder paymentStatus(CodeableConcept paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        /**
         * Builds the {@code PaymentNotice}.
         *
         * @return the {@code PaymentNotice}
         * @throws NullPointerException if a required element is absent
         */
        public PaymentNotice build() {
            return new PaymentNotice(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, request, response, created, reporter, payment, paymentDate, payee, recipient, amount,
                    paymentStatus);
        }
    }
}
