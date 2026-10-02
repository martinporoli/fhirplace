package se.poroli.fhirplace.r5.clinical.requestresponse;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.SupplyRequestStatus;

/**
 * A record of a non-patient specific request for a medication, substance, device, certain types of biologically
 * derived product, and nutrition product used in the healthcare setting.
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
 * @param identifier Business Identifier for SupplyRequest.
 * @param status draft | active | suspended +. Modifier element.
 * @param basedOn What other request is fulfilled by this supply request. Reference to Resource.
 * @param category The kind of supply (central, non-stock, etc.).
 * @param priority routine | urgent | asap | stat.
 * @param deliverFor The patient for who the supply request is for. Reference to Patient.
 * @param item Medication, Substance, or Device requested to be supplied. Required.
 * @param quantity The requested amount of the item indicated. Required.
 * @param parameter Ordered item details.
 * @param occurrence When the request should be fulfilled. One of dateTime, Period, Timing.
 * @param authoredOn When the request was made.
 * @param requester Individual making the request. Reference to Practitioner, PractitionerRole, Organization, Patient,
 *   RelatedPerson, Device, CareTeam.
 * @param supplier Who is intended to fulfill the request. Reference to Organization, HealthcareService.
 * @param reason The reason why the supply item was requested.
 * @param deliverFrom The origin of the supply. Reference to Organization, Location.
 * @param deliverTo The destination of the supply. Reference to Organization, Location, Patient, RelatedPerson.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/SupplyRequest">FHIR R5 SupplyRequest</a>
 */
public record SupplyRequest(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<SupplyRequestStatus> status,
        List<Reference> basedOn,
        CodeableConcept category,
        FhirEnum<RequestPriority> priority,
        Reference deliverFor,
        CodeableReference item,
        Quantity quantity,
        List<Parameter> parameter,
        DataType occurrence,
        FhirDateTime authoredOn,
        Reference requester,
        List<Reference> supplier,
        List<CodeableReference> reason,
        Reference deliverFrom,
        Reference deliverTo) implements DomainResource {

    /**
     * Creates a {@code SupplyRequest}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public SupplyRequest {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        parameter = parameter == null ? List.of() : List.copyOf(parameter);
        supplier = supplier == null ? List.of() : List.copyOf(supplier);
        reason = reason == null ? List.of() : List.copyOf(reason);
        Objects.requireNonNull(item, "SupplyRequest.item is required");
        Objects.requireNonNull(quantity, "SupplyRequest.quantity is required");
        if (occurrence != null && !(occurrence instanceof FhirDateTime
                || occurrence instanceof Period
                || occurrence instanceof Timing)) {
            throw new IllegalArgumentException(
                    "SupplyRequest.occurrence[x] must be one of dateTime, Period, Timing, but was "
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
     * Returns a builder initialized with the values of this {@code SupplyRequest}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Specific parameters for the ordered item.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Item detail.
     * @param value Value of detail. One of CodeableConcept, Quantity, Range, boolean.
     */
    public record Parameter(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            DataType value) implements BackboneElement {

        /**
         * Creates a {@code Parameter}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Parameter {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (value != null && !(value instanceof CodeableConcept
                    || value instanceof Quantity
                    || value instanceof Range
                    || value instanceof FhirBoolean)) {
                throw new IllegalArgumentException(
                        "SupplyRequest.parameter.value[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code Parameter}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Parameter}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private DataType value;

            private Builder() {
            }

            private Builder(Parameter original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.value = original.value();
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
             * Sets {@code value} to a CodeableConcept.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(CodeableConcept value) {
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
             * Sets {@code value} to a Range.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Range value) {
                this.value = value;
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
             * Builds the {@code Parameter}.
             *
             * @return the {@code Parameter}
             */
            public Parameter build() {
                return new Parameter(
                        id, extension, modifierExtension, code, value);
            }
        }
    }

    /** Builder for {@link SupplyRequest}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<SupplyRequestStatus> status;
        private List<Reference> basedOn = new ArrayList<>();
        private CodeableConcept category;
        private FhirEnum<RequestPriority> priority;
        private Reference deliverFor;
        private CodeableReference item;
        private Quantity quantity;
        private List<Parameter> parameter = new ArrayList<>();
        private DataType occurrence;
        private FhirDateTime authoredOn;
        private Reference requester;
        private List<Reference> supplier = new ArrayList<>();
        private List<CodeableReference> reason = new ArrayList<>();
        private Reference deliverFrom;
        private Reference deliverTo;

        private Builder() {
        }

        private Builder(SupplyRequest original) {
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
            this.basedOn = new ArrayList<>(original.basedOn());
            this.category = original.category();
            this.priority = original.priority();
            this.deliverFor = original.deliverFor();
            this.item = original.item();
            this.quantity = original.quantity();
            this.parameter = new ArrayList<>(original.parameter());
            this.occurrence = original.occurrence();
            this.authoredOn = original.authoredOn();
            this.requester = original.requester();
            this.supplier = new ArrayList<>(original.supplier());
            this.reason = new ArrayList<>(original.reason());
            this.deliverFrom = original.deliverFrom();
            this.deliverTo = original.deliverTo();
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
        public Builder status(FhirEnum<SupplyRequestStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(SupplyRequestStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Sets {@code deliverFor}.
         *
         * @param deliverFor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deliverFor(Reference deliverFor) {
            this.deliverFor = deliverFor;
            return this;
        }

        /**
         * Sets {@code item}.
         *
         * @param item the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder item(CodeableReference item) {
            this.item = item;
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
         * Replaces all {@code parameter} values.
         *
         * @param parameter the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder parameter(List<Parameter> parameter) {
            this.parameter = parameter == null ? new ArrayList<>() : new ArrayList<>(parameter);
            return this;
        }

        /**
         * Adds a {@code parameter} value.
         *
         * @param parameter the value to add
         * @return this builder
         */
        public Builder addParameter(Parameter parameter) {
            this.parameter.add(Objects.requireNonNull(parameter, "parameter"));
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
         * Replaces all {@code supplier} values.
         *
         * @param supplier the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supplier(List<Reference> supplier) {
            this.supplier = supplier == null ? new ArrayList<>() : new ArrayList<>(supplier);
            return this;
        }

        /**
         * Adds a {@code supplier} value.
         *
         * @param supplier the value to add
         * @return this builder
         */
        public Builder addSupplier(Reference supplier) {
            this.supplier.add(Objects.requireNonNull(supplier, "supplier"));
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
         * Sets {@code deliverFrom}.
         *
         * @param deliverFrom the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deliverFrom(Reference deliverFrom) {
            this.deliverFrom = deliverFrom;
            return this;
        }

        /**
         * Sets {@code deliverTo}.
         *
         * @param deliverTo the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deliverTo(Reference deliverTo) {
            this.deliverTo = deliverTo;
            return this;
        }

        /**
         * Builds the {@code SupplyRequest}.
         *
         * @return the {@code SupplyRequest}
         * @throws NullPointerException if a required element is absent
         */
        public SupplyRequest build() {
            return new SupplyRequest(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, basedOn, category, priority, deliverFor, item, quantity, parameter, occurrence,
                    authoredOn, requester, supplier, reason, deliverFrom, deliverTo);
        }
    }
}
