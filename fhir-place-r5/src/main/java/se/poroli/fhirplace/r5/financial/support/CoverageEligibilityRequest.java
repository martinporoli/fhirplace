package se.poroli.fhirplace.r5.financial.support;

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
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
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
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.EligibilityRequestPurpose;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;

/**
 * The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to
 * respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage is
 * valid and in-force and optionally to provide the insurance details of the policy.
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
 * @param identifier Business Identifier for coverage eligiblity request.
 * @param status active | cancelled | draft | entered-in-error. Required. Modifier element.
 * @param priority Desired processing priority.
 * @param purpose auth-requirements | benefits | discovery | validation. Required.
 * @param patient Intended recipient of products and services. Reference to Patient. Required.
 * @param event Event information.
 * @param serviced Estimated date or dates of service. One of date, Period.
 * @param created Creation date. Required.
 * @param enterer Author. Reference to Practitioner, PractitionerRole.
 * @param provider Party responsible for the request. Reference to Practitioner, PractitionerRole, Organization.
 * @param insurer Coverage issuer. Reference to Organization. Required.
 * @param facility Servicing facility. Reference to Location.
 * @param supportingInfo Supporting information.
 * @param insurance Patient insurance information.
 * @param item Item to be evaluated for eligibiity.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/CoverageEligibilityRequest">FHIR R5 CoverageEligibilityRequest</a>
 */
public record CoverageEligibilityRequest(
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
        CodeableConcept priority,
        List<FhirEnum<EligibilityRequestPurpose>> purpose,
        Reference patient,
        List<Event> event,
        DataType serviced,
        FhirDateTime created,
        Reference enterer,
        Reference provider,
        Reference insurer,
        Reference facility,
        List<SupportingInformation> supportingInfo,
        List<Insurance> insurance,
        List<Details> item) implements DomainResource {

    /**
     * Creates a {@code CoverageEligibilityRequest}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public CoverageEligibilityRequest {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        purpose = purpose == null ? List.of() : List.copyOf(purpose);
        event = event == null ? List.of() : List.copyOf(event);
        supportingInfo = supportingInfo == null ? List.of() : List.copyOf(supportingInfo);
        insurance = insurance == null ? List.of() : List.copyOf(insurance);
        item = item == null ? List.of() : List.copyOf(item);
        Objects.requireNonNull(status, "CoverageEligibilityRequest.status is required");
        if (purpose.isEmpty()) {
            throw new IllegalArgumentException("CoverageEligibilityRequest.purpose requires at least one value");
        }
        Objects.requireNonNull(patient, "CoverageEligibilityRequest.patient is required");
        Objects.requireNonNull(created, "CoverageEligibilityRequest.created is required");
        Objects.requireNonNull(insurer, "CoverageEligibilityRequest.insurer is required");
        if (serviced != null && !(serviced instanceof FhirDate || serviced instanceof Period)) {
            throw new IllegalArgumentException(
                    "CoverageEligibilityRequest.serviced[x] must be one of date, Period, but was "
                            + serviced.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code CoverageEligibilityRequest}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
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
            Objects.requireNonNull(type, "CoverageEligibilityRequest.event.type is required");
            Objects.requireNonNull(when, "CoverageEligibilityRequest.event.when is required");
            if (when != null && !(when instanceof FhirDateTime || when instanceof Period)) {
                throw new IllegalArgumentException(
                        "CoverageEligibilityRequest.event.when[x] must be one of dateTime, Period, but was "
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
     * @param information Data to be provided. Reference to Resource. Required.
     * @param appliesToAll Applies to all items.
     */
    public record SupportingInformation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            Reference information,
            FhirBoolean appliesToAll) implements BackboneElement {

        /**
         * Creates a {@code SupportingInformation}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public SupportingInformation {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(sequence, "CoverageEligibilityRequest.supportingInfo.sequence is required");
            Objects.requireNonNull(information, "CoverageEligibilityRequest.supportingInfo.information is required");
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
            private Reference information;
            private FhirBoolean appliesToAll;

            private Builder() {
            }

            private Builder(SupportingInformation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.information = original.information();
                this.appliesToAll = original.appliesToAll();
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
             * Sets {@code information}.
             *
             * @param information the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder information(Reference information) {
                this.information = information;
                return this;
            }

            /**
             * Sets {@code appliesToAll}.
             *
             * @param appliesToAll the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder appliesToAll(FhirBoolean appliesToAll) {
                this.appliesToAll = appliesToAll;
                return this;
            }

            /**
             * Sets {@code appliesToAll}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param appliesToAll the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder appliesToAll(Boolean appliesToAll) {
                return appliesToAll(appliesToAll == null ? null : FhirBoolean.of(appliesToAll));
            }

            /**
             * Builds the {@code SupportingInformation}.
             *
             * @return the {@code SupportingInformation}
             * @throws NullPointerException if a required element is absent
             */
            public SupportingInformation build() {
                return new SupportingInformation(
                        id, extension, modifierExtension, sequence, information, appliesToAll);
            }
        }
    }

    /**
     * Financial instruments for reimbursement for the health care products and services.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param focal Applicable coverage.
     * @param coverage Insurance information. Reference to Coverage. Required.
     * @param businessArrangement Additional provider contract number.
     */
    public record Insurance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirBoolean focal,
            Reference coverage,
            FhirString businessArrangement) implements BackboneElement {

        /**
         * Creates an {@code Insurance}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Insurance {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(coverage, "CoverageEligibilityRequest.insurance.coverage is required");
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
            private FhirString businessArrangement;

            private Builder() {
            }

            private Builder(Insurance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.focal = original.focal();
                this.coverage = original.coverage();
                this.businessArrangement = original.businessArrangement();
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
             * Builds the {@code Insurance}.
             *
             * @return the {@code Insurance}
             * @throws NullPointerException if a required element is absent
             */
            public Insurance build() {
                return new Insurance(
                        id, extension, modifierExtension, focal, coverage, businessArrangement);
            }
        }
    }

    /**
     * Service categories or billable services for which benefit details and/or an authorization prior to service
     * delivery may be required by the payor.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param supportingInfoSequence Applicable exception or supporting information.
     * @param category Benefit classification.
     * @param productOrService Billing, service, product, or drug code.
     * @param modifier Product or service billing modifiers.
     * @param provider Perfoming practitioner. Reference to Practitioner, PractitionerRole.
     * @param quantity Count of products or services.
     * @param unitPrice Fee, charge or cost per item.
     * @param facility Servicing facility. Reference to Location, Organization.
     * @param diagnosis Applicable diagnosis.
     * @param detail Product or service details. Reference to Resource.
     */
    public record Details(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<FhirPositiveInt> supportingInfoSequence,
            CodeableConcept category,
            CodeableConcept productOrService,
            List<CodeableConcept> modifier,
            Reference provider,
            Quantity quantity,
            Money unitPrice,
            Reference facility,
            List<Diagnosis> diagnosis,
            List<Reference> detail) implements BackboneElement {

        /**
         * Creates a {@code Details}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Details {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            supportingInfoSequence = supportingInfoSequence == null ? List.of() : List.copyOf(supportingInfoSequence);
            modifier = modifier == null ? List.of() : List.copyOf(modifier);
            diagnosis = diagnosis == null ? List.of() : List.copyOf(diagnosis);
            detail = detail == null ? List.of() : List.copyOf(detail);
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
         * Returns a builder initialized with the values of this {@code Details}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Patient diagnosis for which care is sought.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param diagnosis Nature of illness or problem. One of CodeableConcept, Reference.
         */
        public record Diagnosis(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                DataType diagnosis) implements BackboneElement {

            /**
             * Creates a {@code Diagnosis}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Diagnosis {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                if (diagnosis != null && !(diagnosis instanceof CodeableConcept || diagnosis instanceof Reference)) {
                    throw new IllegalArgumentException(
                            "CoverageEligibilityRequest.item.diagnosis.diagnosis[x] does not allow "
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
                private DataType diagnosis;

                private Builder() {
                }

                private Builder(Diagnosis original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.diagnosis = original.diagnosis();
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
                 * Builds the {@code Diagnosis}.
                 *
                 * @return the {@code Diagnosis}
                 */
                public Diagnosis build() {
                    return new Diagnosis(
                            id, extension, modifierExtension, diagnosis);
                }
            }
        }

        /** Builder for {@link Details}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<FhirPositiveInt> supportingInfoSequence = new ArrayList<>();
            private CodeableConcept category;
            private CodeableConcept productOrService;
            private List<CodeableConcept> modifier = new ArrayList<>();
            private Reference provider;
            private Quantity quantity;
            private Money unitPrice;
            private Reference facility;
            private List<Diagnosis> diagnosis = new ArrayList<>();
            private List<Reference> detail = new ArrayList<>();

            private Builder() {
            }

            private Builder(Details original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.supportingInfoSequence = new ArrayList<>(original.supportingInfoSequence());
                this.category = original.category();
                this.productOrService = original.productOrService();
                this.modifier = new ArrayList<>(original.modifier());
                this.provider = original.provider();
                this.quantity = original.quantity();
                this.unitPrice = original.unitPrice();
                this.facility = original.facility();
                this.diagnosis = new ArrayList<>(original.diagnosis());
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
             * Replaces all {@code supportingInfoSequence} values.
             *
             * @param supportingInfoSequence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder supportingInfoSequence(List<FhirPositiveInt> supportingInfoSequence) {
                this.supportingInfoSequence = supportingInfoSequence == null
                        ? new ArrayList<>()
                        : new ArrayList<>(supportingInfoSequence);
                return this;
            }

            /**
             * Adds a {@code supportingInfoSequence} value.
             *
             * @param supportingInfoSequence the value to add
             * @return this builder
             */
            public Builder addSupportingInfoSequence(FhirPositiveInt supportingInfoSequence) {
                this.supportingInfoSequence.add(
                        Objects.requireNonNull(supportingInfoSequence, "supportingInfoSequence"));
                return this;
            }

            /**
             * Adds a {@code supportingInfoSequence} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param supportingInfoSequence the value to add
             * @return this builder
             */
            public Builder addSupportingInfoSequence(Integer supportingInfoSequence) {
                return addSupportingInfoSequence(FhirPositiveInt.of(supportingInfoSequence));
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
             * Replaces all {@code detail} values.
             *
             * @param detail the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder detail(List<Reference> detail) {
                this.detail = detail == null ? new ArrayList<>() : new ArrayList<>(detail);
                return this;
            }

            /**
             * Adds a {@code detail} value.
             *
             * @param detail the value to add
             * @return this builder
             */
            public Builder addDetail(Reference detail) {
                this.detail.add(Objects.requireNonNull(detail, "detail"));
                return this;
            }

            /**
             * Builds the {@code Details}.
             *
             * @return the {@code Details}
             */
            public Details build() {
                return new Details(
                        id, extension, modifierExtension, supportingInfoSequence, category, productOrService,
                        modifier, provider, quantity, unitPrice, facility, diagnosis, detail);
            }
        }
    }

    /** Builder for {@link CoverageEligibilityRequest}. Builders are mutable and not thread-safe. */
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
        private CodeableConcept priority;
        private List<FhirEnum<EligibilityRequestPurpose>> purpose = new ArrayList<>();
        private Reference patient;
        private List<Event> event = new ArrayList<>();
        private DataType serviced;
        private FhirDateTime created;
        private Reference enterer;
        private Reference provider;
        private Reference insurer;
        private Reference facility;
        private List<SupportingInformation> supportingInfo = new ArrayList<>();
        private List<Insurance> insurance = new ArrayList<>();
        private List<Details> item = new ArrayList<>();

        private Builder() {
        }

        private Builder(CoverageEligibilityRequest original) {
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
            this.priority = original.priority();
            this.purpose = new ArrayList<>(original.purpose());
            this.patient = original.patient();
            this.event = new ArrayList<>(original.event());
            this.serviced = original.serviced();
            this.created = original.created();
            this.enterer = original.enterer();
            this.provider = original.provider();
            this.insurer = original.insurer();
            this.facility = original.facility();
            this.supportingInfo = new ArrayList<>(original.supportingInfo());
            this.insurance = new ArrayList<>(original.insurance());
            this.item = new ArrayList<>(original.item());
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
         * Replaces all {@code purpose} values.
         *
         * @param purpose the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder purpose(List<FhirEnum<EligibilityRequestPurpose>> purpose) {
            this.purpose = purpose == null ? new ArrayList<>() : new ArrayList<>(purpose);
            return this;
        }

        /**
         * Adds a {@code purpose} value.
         *
         * @param purpose the value to add
         * @return this builder
         */
        public Builder addPurpose(FhirEnum<EligibilityRequestPurpose> purpose) {
            this.purpose.add(Objects.requireNonNull(purpose, "purpose"));
            return this;
        }

        /**
         * Adds a {@code purpose} value, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param purpose the value to add
         * @return this builder
         */
        public Builder addPurpose(EligibilityRequestPurpose purpose) {
            return addPurpose(FhirEnum.of(purpose));
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
         * Replaces all {@code item} values.
         *
         * @param item the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder item(List<Details> item) {
            this.item = item == null ? new ArrayList<>() : new ArrayList<>(item);
            return this;
        }

        /**
         * Adds a {@code item} value.
         *
         * @param item the value to add
         * @return this builder
         */
        public Builder addItem(Details item) {
            this.item.add(Objects.requireNonNull(item, "item"));
            return this;
        }

        /**
         * Builds the {@code CoverageEligibilityRequest}.
         *
         * @return the {@code CoverageEligibilityRequest}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public CoverageEligibilityRequest build() {
            return new CoverageEligibilityRequest(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, priority, purpose, patient, event, serviced, created, enterer, provider, insurer,
                    facility, supportingInfo, insurance, item);
        }
    }
}
