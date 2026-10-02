package se.poroli.fhirplace.r5.insuranceplan;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
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
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * Details of a Health Insurance product/plan provided by an organization.
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
 * @param identifier Business Identifier for Product.
 * @param status draft | active | retired | unknown. Modifier element.
 * @param type Kind of product.
 * @param name Official name.
 * @param alias Alternate names.
 * @param period When the product is available.
 * @param ownedBy Product issuer. Reference to Organization.
 * @param administeredBy Product administrator. Reference to Organization.
 * @param coverageArea Where product applies. Reference to Location.
 * @param contact Official contact details relevant to the health insurance plan/product.
 * @param endpoint Technical endpoint. Reference to Endpoint.
 * @param network What networks are Included. Reference to Organization.
 * @param coverage Coverage details.
 * @param plan Plan details.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/InsurancePlan">FHIR R5 InsurancePlan</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record InsurancePlan(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<PublicationStatus> status,
        List<CodeableConcept> type,
        FhirString name,
        List<FhirString> alias,
        Period period,
        Reference ownedBy,
        Reference administeredBy,
        List<Reference> coverageArea,
        List<ExtendedContactDetail> contact,
        List<Reference> endpoint,
        List<Reference> network,
        List<Coverage> coverage,
        List<Plan> plan) implements DomainResource {

    /**
     * Creates an {@code InsurancePlan}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public InsurancePlan {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        type = type == null ? List.of() : List.copyOf(type);
        alias = alias == null ? List.of() : List.copyOf(alias);
        coverageArea = coverageArea == null ? List.of() : List.copyOf(coverageArea);
        contact = contact == null ? List.of() : List.copyOf(contact);
        endpoint = endpoint == null ? List.of() : List.copyOf(endpoint);
        network = network == null ? List.of() : List.copyOf(network);
        coverage = coverage == null ? List.of() : List.copyOf(coverage);
        plan = plan == null ? List.of() : List.copyOf(plan);
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
     * Returns a builder initialized with the values of this {@code InsurancePlan}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Details about the coverage offered by the insurance product.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Type of coverage. Required.
     * @param network What networks provide coverage. Reference to Organization.
     * @param benefit List of benefits. Required.
     */
    public record Coverage(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            List<Reference> network,
            List<CoverageBenefit> benefit) implements BackboneElement {

        /**
         * Creates a {@code Coverage}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Coverage {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            network = network == null ? List.of() : List.copyOf(network);
            benefit = benefit == null ? List.of() : List.copyOf(benefit);
            Objects.requireNonNull(type, "InsurancePlan.coverage.type is required");
            if (benefit.isEmpty()) {
                throw new IllegalArgumentException("InsurancePlan.coverage.benefit requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Coverage}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Specific benefits under this type of coverage.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type Type of benefit. Required.
         * @param requirement Referral requirements.
         * @param limit Benefit limits.
         */
        public record CoverageBenefit(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                FhirString requirement,
                List<Limit> limit) implements BackboneElement {

            /**
             * Creates a {@code CoverageBenefit}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public CoverageBenefit {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                limit = limit == null ? List.of() : List.copyOf(limit);
                Objects.requireNonNull(type, "InsurancePlan.coverage.benefit.type is required");
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
             * Returns a builder initialized with the values of this {@code CoverageBenefit}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * The specific limits on the benefit.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param value Maximum value allowed.
             * @param code Benefit limit details.
             */
            public record Limit(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    Quantity value,
                    CodeableConcept code) implements BackboneElement {

                /**
                 * Creates a {@code Limit}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 */
                public Limit {
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
                 * Returns a builder initialized with the values of this {@code Limit}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Limit}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private Quantity value;
                    private CodeableConcept code;

                    private Builder() {
                    }

                    private Builder(Limit original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.value = original.value();
                        this.code = original.code();
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
                     * Sets {@code value}.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(Quantity value) {
                        this.value = value;
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
                     * Builds the {@code Limit}.
                     *
                     * @return the {@code Limit}
                     */
                    public Limit build() {
                        return new Limit(
                                id, extension, modifierExtension, value, code);
                    }
                }
            }

            /** Builder for {@link CoverageBenefit}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private FhirString requirement;
                private List<Limit> limit = new ArrayList<>();

                private Builder() {
                }

                private Builder(CoverageBenefit original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.requirement = original.requirement();
                    this.limit = new ArrayList<>(original.limit());
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
                 * Sets {@code requirement}.
                 *
                 * @param requirement the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder requirement(FhirString requirement) {
                    this.requirement = requirement;
                    return this;
                }

                /**
                 * Sets {@code requirement}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param requirement the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder requirement(String requirement) {
                    return requirement(requirement == null ? null : FhirString.of(requirement));
                }

                /**
                 * Replaces all {@code limit} values.
                 *
                 * @param limit the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder limit(List<Limit> limit) {
                    this.limit = limit == null ? new ArrayList<>() : new ArrayList<>(limit);
                    return this;
                }

                /**
                 * Adds a {@code limit} value.
                 *
                 * @param limit the value to add
                 * @return this builder
                 */
                public Builder addLimit(Limit limit) {
                    this.limit.add(Objects.requireNonNull(limit, "limit"));
                    return this;
                }

                /**
                 * Builds the {@code CoverageBenefit}.
                 *
                 * @return the {@code CoverageBenefit}
                 * @throws NullPointerException if a required element is absent
                 */
                public CoverageBenefit build() {
                    return new CoverageBenefit(
                            id, extension, modifierExtension, type, requirement, limit);
                }
            }
        }

        /** Builder for {@link Coverage}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private List<Reference> network = new ArrayList<>();
            private List<CoverageBenefit> benefit = new ArrayList<>();

            private Builder() {
            }

            private Builder(Coverage original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.network = new ArrayList<>(original.network());
                this.benefit = new ArrayList<>(original.benefit());
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
             * Replaces all {@code network} values.
             *
             * @param network the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder network(List<Reference> network) {
                this.network = network == null ? new ArrayList<>() : new ArrayList<>(network);
                return this;
            }

            /**
             * Adds a {@code network} value.
             *
             * @param network the value to add
             * @return this builder
             */
            public Builder addNetwork(Reference network) {
                this.network.add(Objects.requireNonNull(network, "network"));
                return this;
            }

            /**
             * Replaces all {@code benefit} values.
             *
             * @param benefit the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder benefit(List<CoverageBenefit> benefit) {
                this.benefit = benefit == null ? new ArrayList<>() : new ArrayList<>(benefit);
                return this;
            }

            /**
             * Adds a {@code benefit} value.
             *
             * @param benefit the value to add
             * @return this builder
             */
            public Builder addBenefit(CoverageBenefit benefit) {
                this.benefit.add(Objects.requireNonNull(benefit, "benefit"));
                return this;
            }

            /**
             * Builds the {@code Coverage}.
             *
             * @return the {@code Coverage}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Coverage build() {
                return new Coverage(
                        id, extension, modifierExtension, type, network, benefit);
            }
        }
    }

    /**
     * Details about an insurance plan.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier Business Identifier for Product.
     * @param type Type of plan.
     * @param coverageArea Where product applies. Reference to Location.
     * @param network What networks provide coverage. Reference to Organization.
     * @param generalCost Overall costs.
     * @param specificCost Specific costs.
     */
    public record Plan(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Identifier> identifier,
            CodeableConcept type,
            List<Reference> coverageArea,
            List<Reference> network,
            List<GeneralCost> generalCost,
            List<SpecificCost> specificCost) implements BackboneElement {

        /**
         * Creates a {@code Plan}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Plan {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            identifier = identifier == null ? List.of() : List.copyOf(identifier);
            coverageArea = coverageArea == null ? List.of() : List.copyOf(coverageArea);
            network = network == null ? List.of() : List.copyOf(network);
            generalCost = generalCost == null ? List.of() : List.copyOf(generalCost);
            specificCost = specificCost == null ? List.of() : List.copyOf(specificCost);
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
         * Returns a builder initialized with the values of this {@code Plan}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Overall costs associated with the plan.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type Type of cost.
         * @param groupSize Number of enrollees.
         * @param cost Cost value.
         * @param comment Additional cost information.
         */
        public record GeneralCost(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                FhirPositiveInt groupSize,
                Money cost,
                FhirString comment) implements BackboneElement {

            /**
             * Creates a {@code GeneralCost}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public GeneralCost {
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
             * Returns a builder initialized with the values of this {@code GeneralCost}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link GeneralCost}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private FhirPositiveInt groupSize;
                private Money cost;
                private FhirString comment;

                private Builder() {
                }

                private Builder(GeneralCost original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.groupSize = original.groupSize();
                    this.cost = original.cost();
                    this.comment = original.comment();
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
                 * Sets {@code groupSize}.
                 *
                 * @param groupSize the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder groupSize(FhirPositiveInt groupSize) {
                    this.groupSize = groupSize;
                    return this;
                }

                /**
                 * Sets {@code groupSize}, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param groupSize the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder groupSize(Integer groupSize) {
                    return groupSize(groupSize == null ? null : FhirPositiveInt.of(groupSize));
                }

                /**
                 * Sets {@code cost}.
                 *
                 * @param cost the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder cost(Money cost) {
                    this.cost = cost;
                    return this;
                }

                /**
                 * Sets {@code comment}.
                 *
                 * @param comment the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder comment(FhirString comment) {
                    this.comment = comment;
                    return this;
                }

                /**
                 * Sets {@code comment}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param comment the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder comment(String comment) {
                    return comment(comment == null ? null : FhirString.of(comment));
                }

                /**
                 * Builds the {@code GeneralCost}.
                 *
                 * @return the {@code GeneralCost}
                 */
                public GeneralCost build() {
                    return new GeneralCost(
                            id, extension, modifierExtension, type, groupSize, cost, comment);
                }
            }
        }

        /**
         * Costs associated with the coverage provided by the product.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param category General category of benefit. Required.
         * @param benefit Benefits list.
         */
        public record SpecificCost(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept category,
                List<PlanBenefit> benefit) implements BackboneElement {

            /**
             * Creates a {@code SpecificCost}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public SpecificCost {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                benefit = benefit == null ? List.of() : List.copyOf(benefit);
                Objects.requireNonNull(category, "InsurancePlan.plan.specificCost.category is required");
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
             * Returns a builder initialized with the values of this {@code SpecificCost}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * List of the specific benefits under this category of benefit.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param type Type of specific benefit. Required.
             * @param cost List of the costs.
             */
            public record PlanBenefit(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    CodeableConcept type,
                    List<Cost> cost) implements BackboneElement {

                /**
                 * Creates a {@code PlanBenefit}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public PlanBenefit {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    cost = cost == null ? List.of() : List.copyOf(cost);
                    Objects.requireNonNull(type, "InsurancePlan.plan.specificCost.benefit.type is required");
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
                 * Returns a builder initialized with the values of this {@code PlanBenefit}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /**
                 * List of the costs associated with a specific benefit.
                 *
                 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
                 * Instances are usually created with {@link #builder()}.
                 *
                 * @param id Unique id for inter-element referencing.
                 * @param extension Additional content defined by implementations.
                 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
                 * @param type Type of cost. Required.
                 * @param applicability in-network | out-of-network | other.
                 * @param qualifiers Additional information about the cost.
                 * @param value The actual cost value.
                 */
                public record Cost(
                        String id,
                        List<Extension> extension,
                        List<Extension> modifierExtension,
                        CodeableConcept type,
                        CodeableConcept applicability,
                        List<CodeableConcept> qualifiers,
                        Quantity value) implements BackboneElement {

                    /**
                     * Creates a {@code Cost}, copying all lists.
                     *
                     * @throws NullPointerException if a required element is absent or a list contains {@code null}
                     */
                    public Cost {
                        extension = extension == null ? List.of() : List.copyOf(extension);
                        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                        qualifiers = qualifiers == null ? List.of() : List.copyOf(qualifiers);
                        Objects.requireNonNull(type, "InsurancePlan.plan.specificCost.benefit.cost.type is required");
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
                     * Returns a builder initialized with the values of this {@code Cost}.
                     *
                     * @return the builder
                     */
                    public Builder toBuilder() {
                        return new Builder(this);
                    }

                    /** Builder for {@link Cost}. Builders are mutable and not thread-safe. */
                    public static final class Builder {

                        private String id;
                        private List<Extension> extension = new ArrayList<>();
                        private List<Extension> modifierExtension = new ArrayList<>();
                        private CodeableConcept type;
                        private CodeableConcept applicability;
                        private List<CodeableConcept> qualifiers = new ArrayList<>();
                        private Quantity value;

                        private Builder() {
                        }

                        private Builder(Cost original) {
                            this.id = original.id();
                            this.extension = new ArrayList<>(original.extension());
                            this.modifierExtension = new ArrayList<>(original.modifierExtension());
                            this.type = original.type();
                            this.applicability = original.applicability();
                            this.qualifiers = new ArrayList<>(original.qualifiers());
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
                            this.modifierExtension.add(
                                    Objects.requireNonNull(modifierExtension, "modifierExtension"));
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
                         * Sets {@code applicability}.
                         *
                         * @param applicability the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder applicability(CodeableConcept applicability) {
                            this.applicability = applicability;
                            return this;
                        }

                        /**
                         * Replaces all {@code qualifiers} values.
                         *
                         * @param qualifiers the new values, or {@code null} to clear them
                         * @return this builder
                         */
                        public Builder qualifiers(List<CodeableConcept> qualifiers) {
                            this.qualifiers = qualifiers == null ? new ArrayList<>() : new ArrayList<>(qualifiers);
                            return this;
                        }

                        /**
                         * Adds a {@code qualifiers} value.
                         *
                         * @param qualifiers the value to add
                         * @return this builder
                         */
                        public Builder addQualifiers(CodeableConcept qualifiers) {
                            this.qualifiers.add(Objects.requireNonNull(qualifiers, "qualifiers"));
                            return this;
                        }

                        /**
                         * Sets {@code value}.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(Quantity value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Builds the {@code Cost}.
                         *
                         * @return the {@code Cost}
                         * @throws NullPointerException if a required element is absent
                         */
                        public Cost build() {
                            return new Cost(
                                    id, extension, modifierExtension, type, applicability, qualifiers, value);
                        }
                    }
                }

                /** Builder for {@link PlanBenefit}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private CodeableConcept type;
                    private List<Cost> cost = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(PlanBenefit original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.type = original.type();
                        this.cost = new ArrayList<>(original.cost());
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
                     * Replaces all {@code cost} values.
                     *
                     * @param cost the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder cost(List<Cost> cost) {
                        this.cost = cost == null ? new ArrayList<>() : new ArrayList<>(cost);
                        return this;
                    }

                    /**
                     * Adds a {@code cost} value.
                     *
                     * @param cost the value to add
                     * @return this builder
                     */
                    public Builder addCost(Cost cost) {
                        this.cost.add(Objects.requireNonNull(cost, "cost"));
                        return this;
                    }

                    /**
                     * Builds the {@code PlanBenefit}.
                     *
                     * @return the {@code PlanBenefit}
                     * @throws NullPointerException if a required element is absent
                     */
                    public PlanBenefit build() {
                        return new PlanBenefit(
                                id, extension, modifierExtension, type, cost);
                    }
                }
            }

            /** Builder for {@link SpecificCost}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept category;
                private List<PlanBenefit> benefit = new ArrayList<>();

                private Builder() {
                }

                private Builder(SpecificCost original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.category = original.category();
                    this.benefit = new ArrayList<>(original.benefit());
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
                 * Replaces all {@code benefit} values.
                 *
                 * @param benefit the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder benefit(List<PlanBenefit> benefit) {
                    this.benefit = benefit == null ? new ArrayList<>() : new ArrayList<>(benefit);
                    return this;
                }

                /**
                 * Adds a {@code benefit} value.
                 *
                 * @param benefit the value to add
                 * @return this builder
                 */
                public Builder addBenefit(PlanBenefit benefit) {
                    this.benefit.add(Objects.requireNonNull(benefit, "benefit"));
                    return this;
                }

                /**
                 * Builds the {@code SpecificCost}.
                 *
                 * @return the {@code SpecificCost}
                 * @throws NullPointerException if a required element is absent
                 */
                public SpecificCost build() {
                    return new SpecificCost(
                            id, extension, modifierExtension, category, benefit);
                }
            }
        }

        /** Builder for {@link Plan}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Identifier> identifier = new ArrayList<>();
            private CodeableConcept type;
            private List<Reference> coverageArea = new ArrayList<>();
            private List<Reference> network = new ArrayList<>();
            private List<GeneralCost> generalCost = new ArrayList<>();
            private List<SpecificCost> specificCost = new ArrayList<>();

            private Builder() {
            }

            private Builder(Plan original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = new ArrayList<>(original.identifier());
                this.type = original.type();
                this.coverageArea = new ArrayList<>(original.coverageArea());
                this.network = new ArrayList<>(original.network());
                this.generalCost = new ArrayList<>(original.generalCost());
                this.specificCost = new ArrayList<>(original.specificCost());
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
             * Replaces all {@code coverageArea} values.
             *
             * @param coverageArea the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder coverageArea(List<Reference> coverageArea) {
                this.coverageArea = coverageArea == null ? new ArrayList<>() : new ArrayList<>(coverageArea);
                return this;
            }

            /**
             * Adds a {@code coverageArea} value.
             *
             * @param coverageArea the value to add
             * @return this builder
             */
            public Builder addCoverageArea(Reference coverageArea) {
                this.coverageArea.add(Objects.requireNonNull(coverageArea, "coverageArea"));
                return this;
            }

            /**
             * Replaces all {@code network} values.
             *
             * @param network the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder network(List<Reference> network) {
                this.network = network == null ? new ArrayList<>() : new ArrayList<>(network);
                return this;
            }

            /**
             * Adds a {@code network} value.
             *
             * @param network the value to add
             * @return this builder
             */
            public Builder addNetwork(Reference network) {
                this.network.add(Objects.requireNonNull(network, "network"));
                return this;
            }

            /**
             * Replaces all {@code generalCost} values.
             *
             * @param generalCost the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder generalCost(List<GeneralCost> generalCost) {
                this.generalCost = generalCost == null ? new ArrayList<>() : new ArrayList<>(generalCost);
                return this;
            }

            /**
             * Adds a {@code generalCost} value.
             *
             * @param generalCost the value to add
             * @return this builder
             */
            public Builder addGeneralCost(GeneralCost generalCost) {
                this.generalCost.add(Objects.requireNonNull(generalCost, "generalCost"));
                return this;
            }

            /**
             * Replaces all {@code specificCost} values.
             *
             * @param specificCost the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder specificCost(List<SpecificCost> specificCost) {
                this.specificCost = specificCost == null ? new ArrayList<>() : new ArrayList<>(specificCost);
                return this;
            }

            /**
             * Adds a {@code specificCost} value.
             *
             * @param specificCost the value to add
             * @return this builder
             */
            public Builder addSpecificCost(SpecificCost specificCost) {
                this.specificCost.add(Objects.requireNonNull(specificCost, "specificCost"));
                return this;
            }

            /**
             * Builds the {@code Plan}.
             *
             * @return the {@code Plan}
             */
            public Plan build() {
                return new Plan(
                        id, extension, modifierExtension, identifier, type, coverageArea, network, generalCost,
                        specificCost);
            }
        }
    }

    /** Builder for {@link InsurancePlan}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<PublicationStatus> status;
        private List<CodeableConcept> type = new ArrayList<>();
        private FhirString name;
        private List<FhirString> alias = new ArrayList<>();
        private Period period;
        private Reference ownedBy;
        private Reference administeredBy;
        private List<Reference> coverageArea = new ArrayList<>();
        private List<ExtendedContactDetail> contact = new ArrayList<>();
        private List<Reference> endpoint = new ArrayList<>();
        private List<Reference> network = new ArrayList<>();
        private List<Coverage> coverage = new ArrayList<>();
        private List<Plan> plan = new ArrayList<>();

        private Builder() {
        }

        private Builder(InsurancePlan original) {
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
            this.type = new ArrayList<>(original.type());
            this.name = original.name();
            this.alias = new ArrayList<>(original.alias());
            this.period = original.period();
            this.ownedBy = original.ownedBy();
            this.administeredBy = original.administeredBy();
            this.coverageArea = new ArrayList<>(original.coverageArea());
            this.contact = new ArrayList<>(original.contact());
            this.endpoint = new ArrayList<>(original.endpoint());
            this.network = new ArrayList<>(original.network());
            this.coverage = new ArrayList<>(original.coverage());
            this.plan = new ArrayList<>(original.plan());
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
        public Builder status(FhirEnum<PublicationStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(PublicationStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Replaces all {@code alias} values.
         *
         * @param alias the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder alias(List<FhirString> alias) {
            this.alias = alias == null ? new ArrayList<>() : new ArrayList<>(alias);
            return this;
        }

        /**
         * Adds a {@code alias} value.
         *
         * @param alias the value to add
         * @return this builder
         */
        public Builder addAlias(FhirString alias) {
            this.alias.add(Objects.requireNonNull(alias, "alias"));
            return this;
        }

        /**
         * Adds a {@code alias} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param alias the value to add
         * @return this builder
         */
        public Builder addAlias(String alias) {
            return addAlias(FhirString.of(alias));
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
         * Sets {@code ownedBy}.
         *
         * @param ownedBy the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder ownedBy(Reference ownedBy) {
            this.ownedBy = ownedBy;
            return this;
        }

        /**
         * Sets {@code administeredBy}.
         *
         * @param administeredBy the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder administeredBy(Reference administeredBy) {
            this.administeredBy = administeredBy;
            return this;
        }

        /**
         * Replaces all {@code coverageArea} values.
         *
         * @param coverageArea the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder coverageArea(List<Reference> coverageArea) {
            this.coverageArea = coverageArea == null ? new ArrayList<>() : new ArrayList<>(coverageArea);
            return this;
        }

        /**
         * Adds a {@code coverageArea} value.
         *
         * @param coverageArea the value to add
         * @return this builder
         */
        public Builder addCoverageArea(Reference coverageArea) {
            this.coverageArea.add(Objects.requireNonNull(coverageArea, "coverageArea"));
            return this;
        }

        /**
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ExtendedContactDetail> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ExtendedContactDetail contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
            return this;
        }

        /**
         * Replaces all {@code endpoint} values.
         *
         * @param endpoint the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder endpoint(List<Reference> endpoint) {
            this.endpoint = endpoint == null ? new ArrayList<>() : new ArrayList<>(endpoint);
            return this;
        }

        /**
         * Adds a {@code endpoint} value.
         *
         * @param endpoint the value to add
         * @return this builder
         */
        public Builder addEndpoint(Reference endpoint) {
            this.endpoint.add(Objects.requireNonNull(endpoint, "endpoint"));
            return this;
        }

        /**
         * Replaces all {@code network} values.
         *
         * @param network the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder network(List<Reference> network) {
            this.network = network == null ? new ArrayList<>() : new ArrayList<>(network);
            return this;
        }

        /**
         * Adds a {@code network} value.
         *
         * @param network the value to add
         * @return this builder
         */
        public Builder addNetwork(Reference network) {
            this.network.add(Objects.requireNonNull(network, "network"));
            return this;
        }

        /**
         * Replaces all {@code coverage} values.
         *
         * @param coverage the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder coverage(List<Coverage> coverage) {
            this.coverage = coverage == null ? new ArrayList<>() : new ArrayList<>(coverage);
            return this;
        }

        /**
         * Adds a {@code coverage} value.
         *
         * @param coverage the value to add
         * @return this builder
         */
        public Builder addCoverage(Coverage coverage) {
            this.coverage.add(Objects.requireNonNull(coverage, "coverage"));
            return this;
        }

        /**
         * Replaces all {@code plan} values.
         *
         * @param plan the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder plan(List<Plan> plan) {
            this.plan = plan == null ? new ArrayList<>() : new ArrayList<>(plan);
            return this;
        }

        /**
         * Adds a {@code plan} value.
         *
         * @param plan the value to add
         * @return this builder
         */
        public Builder addPlan(Plan plan) {
            this.plan.add(Objects.requireNonNull(plan, "plan"));
            return this;
        }

        /**
         * Builds the {@code InsurancePlan}.
         *
         * @return the {@code InsurancePlan}
         */
        public InsurancePlan build() {
            return new InsurancePlan(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, type, name, alias, period, ownedBy, administeredBy, coverageArea, contact, endpoint,
                    network, coverage, plan);
        }
    }
}
