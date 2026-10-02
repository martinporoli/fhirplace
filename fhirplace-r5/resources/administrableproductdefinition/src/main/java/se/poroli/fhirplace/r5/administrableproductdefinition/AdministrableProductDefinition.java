package se.poroli.fhirplace.r5.administrableproductdefinition;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A medicinal product in the final form which is suitable for administering to a patient (after any mixing of
 * multiple components, dissolution etc. has been performed).
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
 * @param identifier An identifier for the administrable product.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param formOf References a product from which one or more of the constituent parts of that product can be prepared
 *   and used as described by this administrable product. Reference to MedicinalProductDefinition.
 * @param administrableDoseForm The dose form of the final product after necessary reconstitution or processing.
 * @param unitOfPresentation The presentation type in which this item is given to a patient. e.g. for a spray -
 *   'puff'.
 * @param producedFrom Indicates the specific manufactured items that are part of the 'formOf' product that are used
 *   in the preparation of this specific administrable form. Reference to ManufacturedItemDefinition.
 * @param ingredient The ingredients of this administrable medicinal product. This is only needed if the ingredients
 *   are not specified either using ManufacturedItemDefiniton, or using by incoming references from the Ingredient
 *   resource.
 * @param device A device that is integral to the medicinal product, in effect being considered as an "ingredient" of
 *   the medicinal product. Reference to DeviceDefinition.
 * @param description A general description of the product, when in its final form, suitable for administration e.g.
 *   effervescent blue liquid, to be swallowed.
 * @param property Characteristics e.g. a product's onset of action.
 * @param routeOfAdministration The path by which the product is taken into or makes contact with the body. Required.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/AdministrableProductDefinition">FHIR R5 AdministrableProductDefinition</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record AdministrableProductDefinition(
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
        List<Reference> formOf,
        CodeableConcept administrableDoseForm,
        CodeableConcept unitOfPresentation,
        List<Reference> producedFrom,
        List<CodeableConcept> ingredient,
        Reference device,
        FhirMarkdown description,
        List<Property> property,
        List<RouteOfAdministration> routeOfAdministration) implements DomainResource {

    /**
     * Creates an {@code AdministrableProductDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a required list is empty
     */
    public AdministrableProductDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        formOf = formOf == null ? List.of() : List.copyOf(formOf);
        producedFrom = producedFrom == null ? List.of() : List.copyOf(producedFrom);
        ingredient = ingredient == null ? List.of() : List.copyOf(ingredient);
        property = property == null ? List.of() : List.copyOf(property);
        routeOfAdministration = routeOfAdministration == null ? List.of() : List.copyOf(routeOfAdministration);
        Objects.requireNonNull(status, "AdministrableProductDefinition.status is required");
        if (routeOfAdministration.isEmpty()) {
            throw new IllegalArgumentException(
                    "AdministrableProductDefinition.routeOfAdministration requires at least one value");
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
     * Returns a builder initialized with the values of this {@code AdministrableProductDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Characteristics e.g. a product's onset of action.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type A code expressing the type of characteristic. Required.
     * @param value A value for the characteristic. One of CodeableConcept, Quantity, date, boolean, markdown,
     *   Attachment, Reference.
     * @param status The status of characteristic e.g. assigned or pending.
     */
    public record Property(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType value,
            CodeableConcept status) implements BackboneElement {

        /**
         * Creates a {@code Property}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Property {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "AdministrableProductDefinition.property.type is required");
            if (value != null && !(value instanceof CodeableConcept
                    || value instanceof Quantity
                    || value instanceof FhirDate
                    || value instanceof FhirBoolean
                    || value instanceof FhirMarkdown
                    || value instanceof Attachment
                    || value instanceof Reference)) {
                throw new IllegalArgumentException(
                        "AdministrableProductDefinition.property.value[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code Property}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Property}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private DataType value;
            private CodeableConcept status;

            private Builder() {
            }

            private Builder(Property original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.value = original.value();
                this.status = original.status();
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
             * Sets {@code value} to a date.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirDate value) {
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
             * Sets {@code value} to a markdown.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirMarkdown value) {
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
             * Sets {@code value} to a date without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Temporal value) {
                this.value = value == null ? null : FhirDate.of(value);
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
             * Sets {@code value} to a markdown without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(String value) {
                this.value = value == null ? null : FhirMarkdown.of(value);
                return this;
            }

            /**
             * Sets {@code status}.
             *
             * @param status the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder status(CodeableConcept status) {
                this.status = status;
                return this;
            }

            /**
             * Builds the {@code Property}.
             *
             * @return the {@code Property}
             * @throws NullPointerException if a required element is absent
             */
            public Property build() {
                return new Property(
                        id, extension, modifierExtension, type, value, status);
            }
        }
    }

    /**
     * The path by which the product is taken into or makes contact with the body.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Coded expression for the route. Required.
     * @param firstDose The first dose (dose quantity) administered can be specified for the product.
     * @param maxSingleDose The maximum single dose that can be administered.
     * @param maxDosePerDay The maximum dose quantity to be administered in any one 24-h period.
     * @param maxDosePerTreatmentPeriod The maximum dose per treatment period that can be administered.
     * @param maxTreatmentPeriod The maximum treatment period during which the product can be administered.
     * @param targetSpecies A species for which this route applies.
     */
    public record RouteOfAdministration(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            Quantity firstDose,
            Quantity maxSingleDose,
            Quantity maxDosePerDay,
            Ratio maxDosePerTreatmentPeriod,
            Duration maxTreatmentPeriod,
            List<TargetSpecies> targetSpecies) implements BackboneElement {

        /**
         * Creates a {@code RouteOfAdministration}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public RouteOfAdministration {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            targetSpecies = targetSpecies == null ? List.of() : List.copyOf(targetSpecies);
            Objects.requireNonNull(code, "AdministrableProductDefinition.routeOfAdministration.code is required");
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
         * Returns a builder initialized with the values of this {@code RouteOfAdministration}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A species for which this route applies.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code Coded expression for the species. Required.
         * @param withdrawalPeriod A species specific time during which consumption of animal product is not
         *   appropriate.
         */
        public record TargetSpecies(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept code,
                List<WithdrawalPeriod> withdrawalPeriod) implements BackboneElement {

            /**
             * Creates a {@code TargetSpecies}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public TargetSpecies {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                withdrawalPeriod = withdrawalPeriod == null ? List.of() : List.copyOf(withdrawalPeriod);
                Objects.requireNonNull(
                        code, "AdministrableProductDefinition.routeOfAdministration.targetSpecies.code is required");
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
             * Returns a builder initialized with the values of this {@code TargetSpecies}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * A species specific time during which consumption of animal product is not appropriate.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param tissue The type of tissue for which the withdrawal period applies, e.g. meat, milk. Required.
             * @param value A value for the time. Required.
             * @param supportingInformation Extra information about the withdrawal period.
             */
            public record WithdrawalPeriod(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    CodeableConcept tissue,
                    Quantity value,
                    FhirString supportingInformation) implements BackboneElement {

                /**
                 * Creates a {@code WithdrawalPeriod}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public WithdrawalPeriod {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(
                            tissue, "AdministrableProductDefinition.routeOfAdministration.targetSpecies.withdrawalPeriod.tissue is required");
                    Objects.requireNonNull(
                            value, "AdministrableProductDefinition.routeOfAdministration.targetSpecies.withdrawalPeriod.value is required");
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
                 * Returns a builder initialized with the values of this {@code WithdrawalPeriod}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link WithdrawalPeriod}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private CodeableConcept tissue;
                    private Quantity value;
                    private FhirString supportingInformation;

                    private Builder() {
                    }

                    private Builder(WithdrawalPeriod original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.tissue = original.tissue();
                        this.value = original.value();
                        this.supportingInformation = original.supportingInformation();
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
                     * Sets {@code tissue}.
                     *
                     * @param tissue the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder tissue(CodeableConcept tissue) {
                        this.tissue = tissue;
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
                     * Sets {@code supportingInformation}.
                     *
                     * @param supportingInformation the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder supportingInformation(FhirString supportingInformation) {
                        this.supportingInformation = supportingInformation;
                        return this;
                    }

                    /**
                     * Sets {@code supportingInformation}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param supportingInformation the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder supportingInformation(String supportingInformation) {
                        return supportingInformation(
                                supportingInformation == null ? null : FhirString.of(supportingInformation));
                    }

                    /**
                     * Builds the {@code WithdrawalPeriod}.
                     *
                     * @return the {@code WithdrawalPeriod}
                     * @throws NullPointerException if a required element is absent
                     */
                    public WithdrawalPeriod build() {
                        return new WithdrawalPeriod(
                                id, extension, modifierExtension, tissue, value, supportingInformation);
                    }
                }
            }

            /** Builder for {@link TargetSpecies}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept code;
                private List<WithdrawalPeriod> withdrawalPeriod = new ArrayList<>();

                private Builder() {
                }

                private Builder(TargetSpecies original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.code = original.code();
                    this.withdrawalPeriod = new ArrayList<>(original.withdrawalPeriod());
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
                 * Replaces all {@code withdrawalPeriod} values.
                 *
                 * @param withdrawalPeriod the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder withdrawalPeriod(List<WithdrawalPeriod> withdrawalPeriod) {
                    this.withdrawalPeriod = withdrawalPeriod == null
                            ? new ArrayList<>()
                            : new ArrayList<>(withdrawalPeriod);
                    return this;
                }

                /**
                 * Adds a {@code withdrawalPeriod} value.
                 *
                 * @param withdrawalPeriod the value to add
                 * @return this builder
                 */
                public Builder addWithdrawalPeriod(WithdrawalPeriod withdrawalPeriod) {
                    this.withdrawalPeriod.add(Objects.requireNonNull(withdrawalPeriod, "withdrawalPeriod"));
                    return this;
                }

                /**
                 * Builds the {@code TargetSpecies}.
                 *
                 * @return the {@code TargetSpecies}
                 * @throws NullPointerException if a required element is absent
                 */
                public TargetSpecies build() {
                    return new TargetSpecies(
                            id, extension, modifierExtension, code, withdrawalPeriod);
                }
            }
        }

        /** Builder for {@link RouteOfAdministration}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private Quantity firstDose;
            private Quantity maxSingleDose;
            private Quantity maxDosePerDay;
            private Ratio maxDosePerTreatmentPeriod;
            private Duration maxTreatmentPeriod;
            private List<TargetSpecies> targetSpecies = new ArrayList<>();

            private Builder() {
            }

            private Builder(RouteOfAdministration original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.firstDose = original.firstDose();
                this.maxSingleDose = original.maxSingleDose();
                this.maxDosePerDay = original.maxDosePerDay();
                this.maxDosePerTreatmentPeriod = original.maxDosePerTreatmentPeriod();
                this.maxTreatmentPeriod = original.maxTreatmentPeriod();
                this.targetSpecies = new ArrayList<>(original.targetSpecies());
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
             * Sets {@code firstDose}.
             *
             * @param firstDose the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder firstDose(Quantity firstDose) {
                this.firstDose = firstDose;
                return this;
            }

            /**
             * Sets {@code maxSingleDose}.
             *
             * @param maxSingleDose the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder maxSingleDose(Quantity maxSingleDose) {
                this.maxSingleDose = maxSingleDose;
                return this;
            }

            /**
             * Sets {@code maxDosePerDay}.
             *
             * @param maxDosePerDay the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder maxDosePerDay(Quantity maxDosePerDay) {
                this.maxDosePerDay = maxDosePerDay;
                return this;
            }

            /**
             * Sets {@code maxDosePerTreatmentPeriod}.
             *
             * @param maxDosePerTreatmentPeriod the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder maxDosePerTreatmentPeriod(Ratio maxDosePerTreatmentPeriod) {
                this.maxDosePerTreatmentPeriod = maxDosePerTreatmentPeriod;
                return this;
            }

            /**
             * Sets {@code maxTreatmentPeriod}.
             *
             * @param maxTreatmentPeriod the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder maxTreatmentPeriod(Duration maxTreatmentPeriod) {
                this.maxTreatmentPeriod = maxTreatmentPeriod;
                return this;
            }

            /**
             * Replaces all {@code targetSpecies} values.
             *
             * @param targetSpecies the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder targetSpecies(List<TargetSpecies> targetSpecies) {
                this.targetSpecies = targetSpecies == null ? new ArrayList<>() : new ArrayList<>(targetSpecies);
                return this;
            }

            /**
             * Adds a {@code targetSpecies} value.
             *
             * @param targetSpecies the value to add
             * @return this builder
             */
            public Builder addTargetSpecies(TargetSpecies targetSpecies) {
                this.targetSpecies.add(Objects.requireNonNull(targetSpecies, "targetSpecies"));
                return this;
            }

            /**
             * Builds the {@code RouteOfAdministration}.
             *
             * @return the {@code RouteOfAdministration}
             * @throws NullPointerException if a required element is absent
             */
            public RouteOfAdministration build() {
                return new RouteOfAdministration(
                        id, extension, modifierExtension, code, firstDose, maxSingleDose, maxDosePerDay,
                        maxDosePerTreatmentPeriod, maxTreatmentPeriod, targetSpecies);
            }
        }
    }

    /** Builder for {@link AdministrableProductDefinition}. Builders are mutable and not thread-safe. */
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
        private List<Reference> formOf = new ArrayList<>();
        private CodeableConcept administrableDoseForm;
        private CodeableConcept unitOfPresentation;
        private List<Reference> producedFrom = new ArrayList<>();
        private List<CodeableConcept> ingredient = new ArrayList<>();
        private Reference device;
        private FhirMarkdown description;
        private List<Property> property = new ArrayList<>();
        private List<RouteOfAdministration> routeOfAdministration = new ArrayList<>();

        private Builder() {
        }

        private Builder(AdministrableProductDefinition original) {
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
            this.formOf = new ArrayList<>(original.formOf());
            this.administrableDoseForm = original.administrableDoseForm();
            this.unitOfPresentation = original.unitOfPresentation();
            this.producedFrom = new ArrayList<>(original.producedFrom());
            this.ingredient = new ArrayList<>(original.ingredient());
            this.device = original.device();
            this.description = original.description();
            this.property = new ArrayList<>(original.property());
            this.routeOfAdministration = new ArrayList<>(original.routeOfAdministration());
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
         * Replaces all {@code formOf} values.
         *
         * @param formOf the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder formOf(List<Reference> formOf) {
            this.formOf = formOf == null ? new ArrayList<>() : new ArrayList<>(formOf);
            return this;
        }

        /**
         * Adds a {@code formOf} value.
         *
         * @param formOf the value to add
         * @return this builder
         */
        public Builder addFormOf(Reference formOf) {
            this.formOf.add(Objects.requireNonNull(formOf, "formOf"));
            return this;
        }

        /**
         * Sets {@code administrableDoseForm}.
         *
         * @param administrableDoseForm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder administrableDoseForm(CodeableConcept administrableDoseForm) {
            this.administrableDoseForm = administrableDoseForm;
            return this;
        }

        /**
         * Sets {@code unitOfPresentation}.
         *
         * @param unitOfPresentation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder unitOfPresentation(CodeableConcept unitOfPresentation) {
            this.unitOfPresentation = unitOfPresentation;
            return this;
        }

        /**
         * Replaces all {@code producedFrom} values.
         *
         * @param producedFrom the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder producedFrom(List<Reference> producedFrom) {
            this.producedFrom = producedFrom == null ? new ArrayList<>() : new ArrayList<>(producedFrom);
            return this;
        }

        /**
         * Adds a {@code producedFrom} value.
         *
         * @param producedFrom the value to add
         * @return this builder
         */
        public Builder addProducedFrom(Reference producedFrom) {
            this.producedFrom.add(Objects.requireNonNull(producedFrom, "producedFrom"));
            return this;
        }

        /**
         * Replaces all {@code ingredient} values.
         *
         * @param ingredient the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder ingredient(List<CodeableConcept> ingredient) {
            this.ingredient = ingredient == null ? new ArrayList<>() : new ArrayList<>(ingredient);
            return this;
        }

        /**
         * Adds a {@code ingredient} value.
         *
         * @param ingredient the value to add
         * @return this builder
         */
        public Builder addIngredient(CodeableConcept ingredient) {
            this.ingredient.add(Objects.requireNonNull(ingredient, "ingredient"));
            return this;
        }

        /**
         * Sets {@code device}.
         *
         * @param device the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder device(Reference device) {
            this.device = device;
            return this;
        }

        /**
         * Sets {@code description}.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(FhirMarkdown description) {
            this.description = description;
            return this;
        }

        /**
         * Sets {@code description}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(String description) {
            return description(description == null ? null : FhirMarkdown.of(description));
        }

        /**
         * Replaces all {@code property} values.
         *
         * @param property the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder property(List<Property> property) {
            this.property = property == null ? new ArrayList<>() : new ArrayList<>(property);
            return this;
        }

        /**
         * Adds a {@code property} value.
         *
         * @param property the value to add
         * @return this builder
         */
        public Builder addProperty(Property property) {
            this.property.add(Objects.requireNonNull(property, "property"));
            return this;
        }

        /**
         * Replaces all {@code routeOfAdministration} values.
         *
         * @param routeOfAdministration the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder routeOfAdministration(List<RouteOfAdministration> routeOfAdministration) {
            this.routeOfAdministration = routeOfAdministration == null
                    ? new ArrayList<>()
                    : new ArrayList<>(routeOfAdministration);
            return this;
        }

        /**
         * Adds a {@code routeOfAdministration} value.
         *
         * @param routeOfAdministration the value to add
         * @return this builder
         */
        public Builder addRouteOfAdministration(RouteOfAdministration routeOfAdministration) {
            this.routeOfAdministration.add(Objects.requireNonNull(routeOfAdministration, "routeOfAdministration"));
            return this;
        }

        /**
         * Builds the {@code AdministrableProductDefinition}.
         *
         * @return the {@code AdministrableProductDefinition}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public AdministrableProductDefinition build() {
            return new AdministrableProductDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, formOf, administrableDoseForm, unitOfPresentation, producedFrom, ingredient, device,
                    description, property, routeOfAdministration);
        }
    }
}
