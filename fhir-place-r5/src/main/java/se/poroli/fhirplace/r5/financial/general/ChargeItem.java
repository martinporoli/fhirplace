package se.poroli.fhirplace.r5.financial.general;

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
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.valuesets.ChargeItemStatus;

/**
 * The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore
 * referring not only to the product, but containing in addition details of the provision, like date, time, amounts
 * and participating organizations and persons.
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
 * @param definitionUri Defining information about the code of this charge item.
 * @param definitionCanonical Resource defining the code of this ChargeItem. Canonical reference to
 *   ChargeItemDefinition.
 * @param status planned | billable | not-billable | aborted | billed | entered-in-error | unknown. Required. Modifier
 *   element.
 * @param partOf Part of referenced ChargeItem. Reference to ChargeItem.
 * @param code A code that identifies the charge, like a billing code. Required.
 * @param subject Individual service was done for/to. Reference to Patient, Group. Required.
 * @param encounter Encounter associated with this ChargeItem. Reference to Encounter.
 * @param occurrence When the charged service was applied. One of dateTime, Period, Timing.
 * @param performer Who performed charged service.
 * @param performingOrganization Organization providing the charged service. Reference to Organization.
 * @param requestingOrganization Organization requesting the charged service. Reference to Organization.
 * @param costCenter Organization that has ownership of the (potential, future) revenue. Reference to Organization.
 * @param quantity Quantity of which the charge item has been serviced.
 * @param bodysite Anatomical location, if relevant.
 * @param unitPriceComponent Unit price overriding the associated rules.
 * @param totalPriceComponent Total price overriding the associated rules.
 * @param overrideReason Reason for overriding the list price/factor.
 * @param enterer Individual who was entering. Reference to Practitioner, PractitionerRole, Organization, Patient,
 *   Device, RelatedPerson.
 * @param enteredDate Date the charge item was entered.
 * @param reason Why was the charged service rendered?.
 * @param service Which rendered service is being charged?.
 * @param product Product charged.
 * @param account Account to place this charge. Reference to Account.
 * @param note Comments made about the ChargeItem.
 * @param supportingInformation Further information supporting this charge. Reference to Resource.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ChargeItem">FHIR R5 ChargeItem</a>
 */
public record ChargeItem(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        List<FhirUri> definitionUri,
        List<FhirCanonical> definitionCanonical,
        FhirEnum<ChargeItemStatus> status,
        List<Reference> partOf,
        CodeableConcept code,
        Reference subject,
        Reference encounter,
        DataType occurrence,
        List<Performer> performer,
        Reference performingOrganization,
        Reference requestingOrganization,
        Reference costCenter,
        Quantity quantity,
        List<CodeableConcept> bodysite,
        MonetaryComponent unitPriceComponent,
        MonetaryComponent totalPriceComponent,
        CodeableConcept overrideReason,
        Reference enterer,
        FhirDateTime enteredDate,
        List<CodeableConcept> reason,
        List<CodeableReference> service,
        List<CodeableReference> product,
        List<Reference> account,
        List<Annotation> note,
        List<Reference> supportingInformation) implements DomainResource {

    /**
     * Creates a {@code ChargeItem}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ChargeItem {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        definitionUri = definitionUri == null ? List.of() : List.copyOf(definitionUri);
        definitionCanonical = definitionCanonical == null ? List.of() : List.copyOf(definitionCanonical);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        performer = performer == null ? List.of() : List.copyOf(performer);
        bodysite = bodysite == null ? List.of() : List.copyOf(bodysite);
        reason = reason == null ? List.of() : List.copyOf(reason);
        service = service == null ? List.of() : List.copyOf(service);
        product = product == null ? List.of() : List.copyOf(product);
        account = account == null ? List.of() : List.copyOf(account);
        note = note == null ? List.of() : List.copyOf(note);
        supportingInformation = supportingInformation == null ? List.of() : List.copyOf(supportingInformation);
        Objects.requireNonNull(status, "ChargeItem.status is required");
        Objects.requireNonNull(code, "ChargeItem.code is required");
        Objects.requireNonNull(subject, "ChargeItem.subject is required");
        if (occurrence != null && !(occurrence instanceof FhirDateTime
                || occurrence instanceof Period
                || occurrence instanceof Timing)) {
            throw new IllegalArgumentException(
                    "ChargeItem.occurrence[x] must be one of dateTime, Period, Timing, but was "
                            + occurrence.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code ChargeItem}.
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
     * @param function What type of performance was done.
     * @param actor Individual who was performing. Reference to Practitioner, PractitionerRole, Organization,
     *   HealthcareService, CareTeam, Patient, Device, RelatedPerson. Required.
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
            Objects.requireNonNull(actor, "ChargeItem.performer.actor is required");
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

    /** Builder for {@link ChargeItem}. Builders are mutable and not thread-safe. */
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
        private List<FhirUri> definitionUri = new ArrayList<>();
        private List<FhirCanonical> definitionCanonical = new ArrayList<>();
        private FhirEnum<ChargeItemStatus> status;
        private List<Reference> partOf = new ArrayList<>();
        private CodeableConcept code;
        private Reference subject;
        private Reference encounter;
        private DataType occurrence;
        private List<Performer> performer = new ArrayList<>();
        private Reference performingOrganization;
        private Reference requestingOrganization;
        private Reference costCenter;
        private Quantity quantity;
        private List<CodeableConcept> bodysite = new ArrayList<>();
        private MonetaryComponent unitPriceComponent;
        private MonetaryComponent totalPriceComponent;
        private CodeableConcept overrideReason;
        private Reference enterer;
        private FhirDateTime enteredDate;
        private List<CodeableConcept> reason = new ArrayList<>();
        private List<CodeableReference> service = new ArrayList<>();
        private List<CodeableReference> product = new ArrayList<>();
        private List<Reference> account = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<Reference> supportingInformation = new ArrayList<>();

        private Builder() {
        }

        private Builder(ChargeItem original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.definitionUri = new ArrayList<>(original.definitionUri());
            this.definitionCanonical = new ArrayList<>(original.definitionCanonical());
            this.status = original.status();
            this.partOf = new ArrayList<>(original.partOf());
            this.code = original.code();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.occurrence = original.occurrence();
            this.performer = new ArrayList<>(original.performer());
            this.performingOrganization = original.performingOrganization();
            this.requestingOrganization = original.requestingOrganization();
            this.costCenter = original.costCenter();
            this.quantity = original.quantity();
            this.bodysite = new ArrayList<>(original.bodysite());
            this.unitPriceComponent = original.unitPriceComponent();
            this.totalPriceComponent = original.totalPriceComponent();
            this.overrideReason = original.overrideReason();
            this.enterer = original.enterer();
            this.enteredDate = original.enteredDate();
            this.reason = new ArrayList<>(original.reason());
            this.service = new ArrayList<>(original.service());
            this.product = new ArrayList<>(original.product());
            this.account = new ArrayList<>(original.account());
            this.note = new ArrayList<>(original.note());
            this.supportingInformation = new ArrayList<>(original.supportingInformation());
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
         * Replaces all {@code definitionUri} values.
         *
         * @param definitionUri the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder definitionUri(List<FhirUri> definitionUri) {
            this.definitionUri = definitionUri == null ? new ArrayList<>() : new ArrayList<>(definitionUri);
            return this;
        }

        /**
         * Adds a {@code definitionUri} value.
         *
         * @param definitionUri the value to add
         * @return this builder
         */
        public Builder addDefinitionUri(FhirUri definitionUri) {
            this.definitionUri.add(Objects.requireNonNull(definitionUri, "definitionUri"));
            return this;
        }

        /**
         * Adds a {@code definitionUri} value, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param definitionUri the value to add
         * @return this builder
         */
        public Builder addDefinitionUri(String definitionUri) {
            return addDefinitionUri(FhirUri.of(definitionUri));
        }

        /**
         * Replaces all {@code definitionCanonical} values.
         *
         * @param definitionCanonical the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder definitionCanonical(List<FhirCanonical> definitionCanonical) {
            this.definitionCanonical = definitionCanonical == null
                    ? new ArrayList<>()
                    : new ArrayList<>(definitionCanonical);
            return this;
        }

        /**
         * Adds a {@code definitionCanonical} value.
         *
         * @param definitionCanonical the value to add
         * @return this builder
         */
        public Builder addDefinitionCanonical(FhirCanonical definitionCanonical) {
            this.definitionCanonical.add(Objects.requireNonNull(definitionCanonical, "definitionCanonical"));
            return this;
        }

        /**
         * Adds a {@code definitionCanonical} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param definitionCanonical the value to add
         * @return this builder
         */
        public Builder addDefinitionCanonical(String definitionCanonical) {
            return addDefinitionCanonical(FhirCanonical.of(definitionCanonical));
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<ChargeItemStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(ChargeItemStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Sets {@code occurrence} to a dateTime.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(FhirDateTime occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a Period.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Period occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a Timing.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Timing occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a dateTime without id or extensions.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Temporal occurrence) {
            this.occurrence = occurrence == null ? null : FhirDateTime.of(occurrence);
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
         * Sets {@code performingOrganization}.
         *
         * @param performingOrganization the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder performingOrganization(Reference performingOrganization) {
            this.performingOrganization = performingOrganization;
            return this;
        }

        /**
         * Sets {@code requestingOrganization}.
         *
         * @param requestingOrganization the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requestingOrganization(Reference requestingOrganization) {
            this.requestingOrganization = requestingOrganization;
            return this;
        }

        /**
         * Sets {@code costCenter}.
         *
         * @param costCenter the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder costCenter(Reference costCenter) {
            this.costCenter = costCenter;
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
         * Replaces all {@code bodysite} values.
         *
         * @param bodysite the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder bodysite(List<CodeableConcept> bodysite) {
            this.bodysite = bodysite == null ? new ArrayList<>() : new ArrayList<>(bodysite);
            return this;
        }

        /**
         * Adds a {@code bodysite} value.
         *
         * @param bodysite the value to add
         * @return this builder
         */
        public Builder addBodysite(CodeableConcept bodysite) {
            this.bodysite.add(Objects.requireNonNull(bodysite, "bodysite"));
            return this;
        }

        /**
         * Sets {@code unitPriceComponent}.
         *
         * @param unitPriceComponent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder unitPriceComponent(MonetaryComponent unitPriceComponent) {
            this.unitPriceComponent = unitPriceComponent;
            return this;
        }

        /**
         * Sets {@code totalPriceComponent}.
         *
         * @param totalPriceComponent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder totalPriceComponent(MonetaryComponent totalPriceComponent) {
            this.totalPriceComponent = totalPriceComponent;
            return this;
        }

        /**
         * Sets {@code overrideReason}.
         *
         * @param overrideReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder overrideReason(CodeableConcept overrideReason) {
            this.overrideReason = overrideReason;
            return this;
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
         * Sets {@code enteredDate}.
         *
         * @param enteredDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder enteredDate(FhirDateTime enteredDate) {
            this.enteredDate = enteredDate;
            return this;
        }

        /**
         * Sets {@code enteredDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param enteredDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder enteredDate(Temporal enteredDate) {
            return enteredDate(enteredDate == null ? null : FhirDateTime.of(enteredDate));
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
         * Replaces all {@code service} values.
         *
         * @param service the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder service(List<CodeableReference> service) {
            this.service = service == null ? new ArrayList<>() : new ArrayList<>(service);
            return this;
        }

        /**
         * Adds a {@code service} value.
         *
         * @param service the value to add
         * @return this builder
         */
        public Builder addService(CodeableReference service) {
            this.service.add(Objects.requireNonNull(service, "service"));
            return this;
        }

        /**
         * Replaces all {@code product} values.
         *
         * @param product the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder product(List<CodeableReference> product) {
            this.product = product == null ? new ArrayList<>() : new ArrayList<>(product);
            return this;
        }

        /**
         * Adds a {@code product} value.
         *
         * @param product the value to add
         * @return this builder
         */
        public Builder addProduct(CodeableReference product) {
            this.product.add(Objects.requireNonNull(product, "product"));
            return this;
        }

        /**
         * Replaces all {@code account} values.
         *
         * @param account the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder account(List<Reference> account) {
            this.account = account == null ? new ArrayList<>() : new ArrayList<>(account);
            return this;
        }

        /**
         * Adds a {@code account} value.
         *
         * @param account the value to add
         * @return this builder
         */
        public Builder addAccount(Reference account) {
            this.account.add(Objects.requireNonNull(account, "account"));
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
         * Builds the {@code ChargeItem}.
         *
         * @return the {@code ChargeItem}
         * @throws NullPointerException if a required element is absent
         */
        public ChargeItem build() {
            return new ChargeItem(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    definitionUri, definitionCanonical, status, partOf, code, subject, encounter, occurrence,
                    performer, performingOrganization, requestingOrganization, costCenter, quantity, bodysite,
                    unitPriceComponent, totalPriceComponent, overrideReason, enterer, enteredDate, reason, service,
                    product, account, note, supportingInformation);
        }
    }
}
