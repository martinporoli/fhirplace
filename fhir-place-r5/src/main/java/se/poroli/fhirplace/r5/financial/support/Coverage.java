package se.poroli.fhirplace.r5.financial.support;

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
import se.poroli.fhirplace.r5.valuesets.Kind;

/**
 * Financial instrument which may be used to reimburse or pay for health care products and services.
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
 * @param identifier Business identifier(s) for this coverage.
 * @param status active | cancelled | draft | entered-in-error. Required. Modifier element.
 * @param kind insurance | self-pay | other. Required.
 * @param paymentBy Self-pay parties and responsibility.
 * @param type Coverage category such as medical or accident.
 * @param policyHolder Owner of the policy. Reference to Patient, RelatedPerson, Organization.
 * @param subscriber Subscriber to the policy. Reference to Patient, RelatedPerson.
 * @param subscriberId ID assigned to the subscriber.
 * @param beneficiary Plan beneficiary. Reference to Patient. Required.
 * @param dependent Dependent number.
 * @param relationship Beneficiary relationship to the subscriber.
 * @param period Coverage start and end dates.
 * @param insurer Issuer of the policy. Reference to Organization.
 * @param classValue Additional coverage classifications. The FHIR element {@code class}.
 * @param order Relative order of the coverage.
 * @param network Insurer network.
 * @param costToBeneficiary Patient payments for services/products.
 * @param subrogation Reimbursement to insurer.
 * @param contract Contract details. Reference to Contract.
 * @param insurancePlan Insurance plan details. Reference to InsurancePlan.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Coverage">FHIR R5 Coverage</a>
 */
public record Coverage(
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
        FhirEnum<Kind> kind,
        List<PaymentBy> paymentBy,
        CodeableConcept type,
        Reference policyHolder,
        Reference subscriber,
        List<Identifier> subscriberId,
        Reference beneficiary,
        FhirString dependent,
        CodeableConcept relationship,
        Period period,
        Reference insurer,
        List<CoverageClass> classValue,
        FhirPositiveInt order,
        FhirString network,
        List<CostToBeneficiary> costToBeneficiary,
        FhirBoolean subrogation,
        List<Reference> contract,
        Reference insurancePlan) implements DomainResource {

    /**
     * Creates a {@code Coverage}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Coverage {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        paymentBy = paymentBy == null ? List.of() : List.copyOf(paymentBy);
        subscriberId = subscriberId == null ? List.of() : List.copyOf(subscriberId);
        classValue = classValue == null ? List.of() : List.copyOf(classValue);
        costToBeneficiary = costToBeneficiary == null ? List.of() : List.copyOf(costToBeneficiary);
        contract = contract == null ? List.of() : List.copyOf(contract);
        Objects.requireNonNull(status, "Coverage.status is required");
        Objects.requireNonNull(kind, "Coverage.kind is required");
        Objects.requireNonNull(beneficiary, "Coverage.beneficiary is required");
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
     * Returns a builder initialized with the values of this {@code Coverage}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Link to the paying party and optionally what specifically they will be responsible to pay.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param party Parties performing self-payment. Reference to Patient, RelatedPerson, Organization. Required.
     * @param responsibility Party's responsibility.
     */
    public record PaymentBy(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference party,
            FhirString responsibility) implements BackboneElement {

        /**
         * Creates a {@code PaymentBy}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public PaymentBy {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(party, "Coverage.paymentBy.party is required");
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
         * Returns a builder initialized with the values of this {@code PaymentBy}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link PaymentBy}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference party;
            private FhirString responsibility;

            private Builder() {
            }

            private Builder(PaymentBy original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.party = original.party();
                this.responsibility = original.responsibility();
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
             * Sets {@code responsibility}.
             *
             * @param responsibility the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder responsibility(FhirString responsibility) {
                this.responsibility = responsibility;
                return this;
            }

            /**
             * Sets {@code responsibility}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param responsibility the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder responsibility(String responsibility) {
                return responsibility(responsibility == null ? null : FhirString.of(responsibility));
            }

            /**
             * Builds the {@code PaymentBy}.
             *
             * @return the {@code PaymentBy}
             * @throws NullPointerException if a required element is absent
             */
            public PaymentBy build() {
                return new PaymentBy(
                        id, extension, modifierExtension, party, responsibility);
            }
        }
    }

    /**
     * A suite of underwriter specific classifiers.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Type of class such as 'group' or 'plan'. Required.
     * @param value Value associated with the type. Required.
     * @param name Human readable description of the type and value.
     */
    public record CoverageClass(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            Identifier value,
            FhirString name) implements BackboneElement {

        /**
         * Creates a {@code CoverageClass}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public CoverageClass {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "Coverage.class.type is required");
            Objects.requireNonNull(value, "Coverage.class.value is required");
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
         * Returns a builder initialized with the values of this {@code CoverageClass}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link CoverageClass}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private Identifier value;
            private FhirString name;

            private Builder() {
            }

            private Builder(CoverageClass original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.value = original.value();
                this.name = original.name();
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
             * Sets {@code value}.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Identifier value) {
                this.value = value;
                return this;
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
             * Builds the {@code CoverageClass}.
             *
             * @return the {@code CoverageClass}
             * @throws NullPointerException if a required element is absent
             */
            public CoverageClass build() {
                return new CoverageClass(
                        id, extension, modifierExtension, type, value, name);
            }
        }
    }

    /**
     * A suite of codes indicating the cost category and associated amount which have been detailed in the policy and
     * may have been included on the health card.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Cost category.
     * @param category Benefit classification.
     * @param network In or out of network.
     * @param unit Individual or family.
     * @param term Annual or lifetime.
     * @param value The amount or percentage due from the beneficiary. One of Quantity, Money.
     * @param exception Exceptions for patient payments.
     */
    public record CostToBeneficiary(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            CodeableConcept category,
            CodeableConcept network,
            CodeableConcept unit,
            CodeableConcept term,
            DataType value,
            List<Exemption> exception) implements BackboneElement {

        /**
         * Creates a {@code CostToBeneficiary}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public CostToBeneficiary {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            exception = exception == null ? List.of() : List.copyOf(exception);
            if (value != null && !(value instanceof Quantity || value instanceof Money)) {
                throw new IllegalArgumentException(
                        "Coverage.costToBeneficiary.value[x] must be one of Quantity, Money, but was "
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
         * Returns a builder initialized with the values of this {@code CostToBeneficiary}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A suite of codes indicating exceptions or reductions to patient costs and their effective periods.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type Exception category. Required.
         * @param period The effective period of the exception.
         */
        public record Exemption(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                Period period) implements BackboneElement {

            /**
             * Creates an {@code Exemption}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Exemption {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(type, "Coverage.costToBeneficiary.exception.type is required");
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
             * Returns a builder initialized with the values of this {@code Exemption}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Exemption}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private Period period;

                private Builder() {
                }

                private Builder(Exemption original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.period = original.period();
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
                 * Builds the {@code Exemption}.
                 *
                 * @return the {@code Exemption}
                 * @throws NullPointerException if a required element is absent
                 */
                public Exemption build() {
                    return new Exemption(
                            id, extension, modifierExtension, type, period);
                }
            }
        }

        /** Builder for {@link CostToBeneficiary}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private CodeableConcept category;
            private CodeableConcept network;
            private CodeableConcept unit;
            private CodeableConcept term;
            private DataType value;
            private List<Exemption> exception = new ArrayList<>();

            private Builder() {
            }

            private Builder(CostToBeneficiary original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.category = original.category();
                this.network = original.network();
                this.unit = original.unit();
                this.term = original.term();
                this.value = original.value();
                this.exception = new ArrayList<>(original.exception());
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
             * Sets {@code value} to a Money.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Money value) {
                this.value = value;
                return this;
            }

            /**
             * Replaces all {@code exception} values.
             *
             * @param exception the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder exception(List<Exemption> exception) {
                this.exception = exception == null ? new ArrayList<>() : new ArrayList<>(exception);
                return this;
            }

            /**
             * Adds a {@code exception} value.
             *
             * @param exception the value to add
             * @return this builder
             */
            public Builder addException(Exemption exception) {
                this.exception.add(Objects.requireNonNull(exception, "exception"));
                return this;
            }

            /**
             * Builds the {@code CostToBeneficiary}.
             *
             * @return the {@code CostToBeneficiary}
             */
            public CostToBeneficiary build() {
                return new CostToBeneficiary(
                        id, extension, modifierExtension, type, category, network, unit, term, value, exception);
            }
        }
    }

    /** Builder for {@link Coverage}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<Kind> kind;
        private List<PaymentBy> paymentBy = new ArrayList<>();
        private CodeableConcept type;
        private Reference policyHolder;
        private Reference subscriber;
        private List<Identifier> subscriberId = new ArrayList<>();
        private Reference beneficiary;
        private FhirString dependent;
        private CodeableConcept relationship;
        private Period period;
        private Reference insurer;
        private List<CoverageClass> classValue = new ArrayList<>();
        private FhirPositiveInt order;
        private FhirString network;
        private List<CostToBeneficiary> costToBeneficiary = new ArrayList<>();
        private FhirBoolean subrogation;
        private List<Reference> contract = new ArrayList<>();
        private Reference insurancePlan;

        private Builder() {
        }

        private Builder(Coverage original) {
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
            this.kind = original.kind();
            this.paymentBy = new ArrayList<>(original.paymentBy());
            this.type = original.type();
            this.policyHolder = original.policyHolder();
            this.subscriber = original.subscriber();
            this.subscriberId = new ArrayList<>(original.subscriberId());
            this.beneficiary = original.beneficiary();
            this.dependent = original.dependent();
            this.relationship = original.relationship();
            this.period = original.period();
            this.insurer = original.insurer();
            this.classValue = new ArrayList<>(original.classValue());
            this.order = original.order();
            this.network = original.network();
            this.costToBeneficiary = new ArrayList<>(original.costToBeneficiary());
            this.subrogation = original.subrogation();
            this.contract = new ArrayList<>(original.contract());
            this.insurancePlan = original.insurancePlan();
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
         * Sets {@code kind}.
         *
         * @param kind the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder kind(FhirEnum<Kind> kind) {
            this.kind = kind;
            return this;
        }

        /**
         * Sets {@code kind}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param kind the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder kind(Kind kind) {
            return kind(kind == null ? null : FhirEnum.of(kind));
        }

        /**
         * Replaces all {@code paymentBy} values.
         *
         * @param paymentBy the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder paymentBy(List<PaymentBy> paymentBy) {
            this.paymentBy = paymentBy == null ? new ArrayList<>() : new ArrayList<>(paymentBy);
            return this;
        }

        /**
         * Adds a {@code paymentBy} value.
         *
         * @param paymentBy the value to add
         * @return this builder
         */
        public Builder addPaymentBy(PaymentBy paymentBy) {
            this.paymentBy.add(Objects.requireNonNull(paymentBy, "paymentBy"));
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
         * Sets {@code policyHolder}.
         *
         * @param policyHolder the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder policyHolder(Reference policyHolder) {
            this.policyHolder = policyHolder;
            return this;
        }

        /**
         * Sets {@code subscriber}.
         *
         * @param subscriber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subscriber(Reference subscriber) {
            this.subscriber = subscriber;
            return this;
        }

        /**
         * Replaces all {@code subscriberId} values.
         *
         * @param subscriberId the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder subscriberId(List<Identifier> subscriberId) {
            this.subscriberId = subscriberId == null ? new ArrayList<>() : new ArrayList<>(subscriberId);
            return this;
        }

        /**
         * Adds a {@code subscriberId} value.
         *
         * @param subscriberId the value to add
         * @return this builder
         */
        public Builder addSubscriberId(Identifier subscriberId) {
            this.subscriberId.add(Objects.requireNonNull(subscriberId, "subscriberId"));
            return this;
        }

        /**
         * Sets {@code beneficiary}.
         *
         * @param beneficiary the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder beneficiary(Reference beneficiary) {
            this.beneficiary = beneficiary;
            return this;
        }

        /**
         * Sets {@code dependent}.
         *
         * @param dependent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dependent(FhirString dependent) {
            this.dependent = dependent;
            return this;
        }

        /**
         * Sets {@code dependent}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param dependent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dependent(String dependent) {
            return dependent(dependent == null ? null : FhirString.of(dependent));
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
         * Replaces all {@code classValue} values.
         *
         * @param classValue the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder classValue(List<CoverageClass> classValue) {
            this.classValue = classValue == null ? new ArrayList<>() : new ArrayList<>(classValue);
            return this;
        }

        /**
         * Adds a {@code classValue} value.
         *
         * @param classValue the value to add
         * @return this builder
         */
        public Builder addClassValue(CoverageClass classValue) {
            this.classValue.add(Objects.requireNonNull(classValue, "classValue"));
            return this;
        }

        /**
         * Sets {@code order}.
         *
         * @param order the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder order(FhirPositiveInt order) {
            this.order = order;
            return this;
        }

        /**
         * Sets {@code order}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param order the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder order(Integer order) {
            return order(order == null ? null : FhirPositiveInt.of(order));
        }

        /**
         * Sets {@code network}.
         *
         * @param network the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder network(FhirString network) {
            this.network = network;
            return this;
        }

        /**
         * Sets {@code network}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param network the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder network(String network) {
            return network(network == null ? null : FhirString.of(network));
        }

        /**
         * Replaces all {@code costToBeneficiary} values.
         *
         * @param costToBeneficiary the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder costToBeneficiary(List<CostToBeneficiary> costToBeneficiary) {
            this.costToBeneficiary = costToBeneficiary == null
                    ? new ArrayList<>()
                    : new ArrayList<>(costToBeneficiary);
            return this;
        }

        /**
         * Adds a {@code costToBeneficiary} value.
         *
         * @param costToBeneficiary the value to add
         * @return this builder
         */
        public Builder addCostToBeneficiary(CostToBeneficiary costToBeneficiary) {
            this.costToBeneficiary.add(Objects.requireNonNull(costToBeneficiary, "costToBeneficiary"));
            return this;
        }

        /**
         * Sets {@code subrogation}.
         *
         * @param subrogation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subrogation(FhirBoolean subrogation) {
            this.subrogation = subrogation;
            return this;
        }

        /**
         * Sets {@code subrogation}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param subrogation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subrogation(Boolean subrogation) {
            return subrogation(subrogation == null ? null : FhirBoolean.of(subrogation));
        }

        /**
         * Replaces all {@code contract} values.
         *
         * @param contract the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contract(List<Reference> contract) {
            this.contract = contract == null ? new ArrayList<>() : new ArrayList<>(contract);
            return this;
        }

        /**
         * Adds a {@code contract} value.
         *
         * @param contract the value to add
         * @return this builder
         */
        public Builder addContract(Reference contract) {
            this.contract.add(Objects.requireNonNull(contract, "contract"));
            return this;
        }

        /**
         * Sets {@code insurancePlan}.
         *
         * @param insurancePlan the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder insurancePlan(Reference insurancePlan) {
            this.insurancePlan = insurancePlan;
            return this;
        }

        /**
         * Builds the {@code Coverage}.
         *
         * @return the {@code Coverage}
         * @throws NullPointerException if a required element is absent
         */
        public Coverage build() {
            return new Coverage(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, kind, paymentBy, type, policyHolder, subscriber, subscriberId, beneficiary, dependent,
                    relationship, period, insurer, classValue, order, network, costToBeneficiary, subrogation,
                    contract, insurancePlan);
        }
    }
}
