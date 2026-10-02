package se.poroli.fhirplace.r5.ingredient;

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
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.RatioRange;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * An ingredient of a manufactured item or pharmaceutical product.
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
 * @param identifier An identifier or code by which the ingredient can be referenced.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param forValue The product which this ingredient is a constituent part of. Reference to
 *   MedicinalProductDefinition, AdministrableProductDefinition, ManufacturedItemDefinition. The FHIR element {@code
 *   for}.
 * @param role Purpose of the ingredient within the product, e.g. active, inactive. Required.
 * @param function Precise action within the drug product, e.g. antioxidant, alkalizing agent.
 * @param group A classification of the ingredient according to where in the physical item it tends to be used, such
 *   the outer shell of a tablet, inner body or ink.
 * @param allergenicIndicator If the ingredient is a known or suspected allergen.
 * @param comment A place for providing any notes that are relevant to the component, e.g. removed during process,
 *   adjusted for loss on drying.
 * @param manufacturer An organization that manufactures this ingredient.
 * @param substance The substance that comprises this ingredient. Required.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Ingredient">FHIR R5 Ingredient</a>
 */
public record Ingredient(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        Identifier identifier,
        FhirEnum<PublicationStatus> status,
        List<Reference> forValue,
        CodeableConcept role,
        List<CodeableConcept> function,
        CodeableConcept group,
        FhirBoolean allergenicIndicator,
        FhirMarkdown comment,
        List<Manufacturer> manufacturer,
        Substance substance) implements DomainResource {

    /**
     * Creates an {@code Ingredient}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Ingredient {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        forValue = forValue == null ? List.of() : List.copyOf(forValue);
        function = function == null ? List.of() : List.copyOf(function);
        manufacturer = manufacturer == null ? List.of() : List.copyOf(manufacturer);
        Objects.requireNonNull(status, "Ingredient.status is required");
        Objects.requireNonNull(role, "Ingredient.role is required");
        Objects.requireNonNull(substance, "Ingredient.substance is required");
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
     * Returns a builder initialized with the values of this {@code Ingredient}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The organization(s) that manufacture this ingredient.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param role allowed | possible | actual.
     * @param manufacturer An organization that manufactures this ingredient. Reference to Organization. Required.
     */
    public record Manufacturer(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<IngredientManufacturerRole> role,
            Reference manufacturer) implements BackboneElement {

        /**
         * Creates a {@code Manufacturer}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Manufacturer {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(manufacturer, "Ingredient.manufacturer.manufacturer is required");
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
         * Returns a builder initialized with the values of this {@code Manufacturer}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Manufacturer}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<IngredientManufacturerRole> role;
            private Reference manufacturer;

            private Builder() {
            }

            private Builder(Manufacturer original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.role = original.role();
                this.manufacturer = original.manufacturer();
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
            public Builder role(FhirEnum<IngredientManufacturerRole> role) {
                this.role = role;
                return this;
            }

            /**
             * Sets {@code role}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param role the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder role(IngredientManufacturerRole role) {
                return role(role == null ? null : FhirEnum.of(role));
            }

            /**
             * Sets {@code manufacturer}.
             *
             * @param manufacturer the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder manufacturer(Reference manufacturer) {
                this.manufacturer = manufacturer;
                return this;
            }

            /**
             * Builds the {@code Manufacturer}.
             *
             * @return the {@code Manufacturer}
             * @throws NullPointerException if a required element is absent
             */
            public Manufacturer build() {
                return new Manufacturer(
                        id, extension, modifierExtension, role, manufacturer);
            }
        }
    }

    /**
     * The substance that comprises this ingredient.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code A code or full resource that represents the ingredient substance. Required.
     * @param strength The quantity of substance, per presentation, or per volume or mass, and type of quantity.
     */
    public record Substance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference code,
            List<Strength> strength) implements BackboneElement {

        /**
         * Creates a {@code Substance}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Substance {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            strength = strength == null ? List.of() : List.copyOf(strength);
            Objects.requireNonNull(code, "Ingredient.substance.code is required");
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
         * Returns a builder initialized with the values of this {@code Substance}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The quantity of substance in the unit of presentation, or in the volume (or mass) of the single
         * pharmaceutical product or manufactured item.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param presentation The quantity of substance in the unit of presentation. One of Ratio, RatioRange,
         *   CodeableConcept, Quantity.
         * @param textPresentation Text of either the whole presentation strength or a part of it (rest being in
         *   Strength.presentation as a ratio).
         * @param concentration The strength per unitary volume (or mass). One of Ratio, RatioRange, CodeableConcept,
         *   Quantity.
         * @param textConcentration Text of either the whole concentration strength or a part of it (rest being in
         *   Strength.concentration as a ratio).
         * @param basis A code that indicates if the strength is, for example, based on the ingredient substance as
         *   stated or on the substance base (when the ingredient is a salt).
         * @param measurementPoint When strength is measured at a particular point or distance.
         * @param country Where the strength range applies.
         * @param referenceStrength Strength expressed in terms of a reference substance.
         */
        public record Strength(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                DataType presentation,
                FhirString textPresentation,
                DataType concentration,
                FhirString textConcentration,
                CodeableConcept basis,
                FhirString measurementPoint,
                List<CodeableConcept> country,
                List<ReferenceStrength> referenceStrength) implements BackboneElement {

            /**
             * Creates a {@code Strength}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Strength {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                country = country == null ? List.of() : List.copyOf(country);
                referenceStrength = referenceStrength == null ? List.of() : List.copyOf(referenceStrength);
                if (presentation != null && !(presentation instanceof Ratio
                        || presentation instanceof RatioRange
                        || presentation instanceof CodeableConcept
                        || presentation instanceof Quantity)) {
                    throw new IllegalArgumentException(
                            "Ingredient.substance.strength.presentation[x] does not allow "
                                    + presentation.getClass().getSimpleName());
                }
                if (concentration != null && !(concentration instanceof Ratio
                        || concentration instanceof RatioRange
                        || concentration instanceof CodeableConcept
                        || concentration instanceof Quantity)) {
                    throw new IllegalArgumentException(
                            "Ingredient.substance.strength.concentration[x] does not allow "
                                    + concentration.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code Strength}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Strength expressed in terms of a reference substance.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param substance Relevant reference substance. Required.
             * @param strength Strength expressed in terms of a reference substance. One of Ratio, RatioRange,
             *   Quantity. Required.
             * @param measurementPoint When strength is measured at a particular point or distance.
             * @param country Where the strength range applies.
             */
            public record ReferenceStrength(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    CodeableReference substance,
                    DataType strength,
                    FhirString measurementPoint,
                    List<CodeableConcept> country) implements BackboneElement {

                /**
                 * Creates a {@code ReferenceStrength}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 * @throws IllegalArgumentException if a choice element has a type that is not allowed
                 */
                public ReferenceStrength {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    country = country == null ? List.of() : List.copyOf(country);
                    Objects.requireNonNull(
                            substance, "Ingredient.substance.strength.referenceStrength.substance is required");
                    Objects.requireNonNull(
                            strength, "Ingredient.substance.strength.referenceStrength.strength is required");
                    if (strength != null && !(strength instanceof Ratio
                            || strength instanceof RatioRange
                            || strength instanceof Quantity)) {
                        throw new IllegalArgumentException(
                                "Ingredient.substance.strength.referenceStrength.strength[x] does not allow "
                                        + strength.getClass().getSimpleName());
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
                 * Returns a builder initialized with the values of this {@code ReferenceStrength}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link ReferenceStrength}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private CodeableReference substance;
                    private DataType strength;
                    private FhirString measurementPoint;
                    private List<CodeableConcept> country = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(ReferenceStrength original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.substance = original.substance();
                        this.strength = original.strength();
                        this.measurementPoint = original.measurementPoint();
                        this.country = new ArrayList<>(original.country());
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
                     * Sets {@code substance}.
                     *
                     * @param substance the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder substance(CodeableReference substance) {
                        this.substance = substance;
                        return this;
                    }

                    /**
                     * Sets {@code strength} to a Ratio.
                     *
                     * @param strength the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder strength(Ratio strength) {
                        this.strength = strength;
                        return this;
                    }

                    /**
                     * Sets {@code strength} to a RatioRange.
                     *
                     * @param strength the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder strength(RatioRange strength) {
                        this.strength = strength;
                        return this;
                    }

                    /**
                     * Sets {@code strength} to a Quantity.
                     *
                     * @param strength the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder strength(Quantity strength) {
                        this.strength = strength;
                        return this;
                    }

                    /**
                     * Sets {@code measurementPoint}.
                     *
                     * @param measurementPoint the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder measurementPoint(FhirString measurementPoint) {
                        this.measurementPoint = measurementPoint;
                        return this;
                    }

                    /**
                     * Sets {@code measurementPoint}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param measurementPoint the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder measurementPoint(String measurementPoint) {
                        return measurementPoint(measurementPoint == null ? null : FhirString.of(measurementPoint));
                    }

                    /**
                     * Replaces all {@code country} values.
                     *
                     * @param country the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder country(List<CodeableConcept> country) {
                        this.country = country == null ? new ArrayList<>() : new ArrayList<>(country);
                        return this;
                    }

                    /**
                     * Adds a {@code country} value.
                     *
                     * @param country the value to add
                     * @return this builder
                     */
                    public Builder addCountry(CodeableConcept country) {
                        this.country.add(Objects.requireNonNull(country, "country"));
                        return this;
                    }

                    /**
                     * Builds the {@code ReferenceStrength}.
                     *
                     * @return the {@code ReferenceStrength}
                     * @throws NullPointerException if a required element is absent
                     */
                    public ReferenceStrength build() {
                        return new ReferenceStrength(
                                id, extension, modifierExtension, substance, strength, measurementPoint, country);
                    }
                }
            }

            /** Builder for {@link Strength}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private DataType presentation;
                private FhirString textPresentation;
                private DataType concentration;
                private FhirString textConcentration;
                private CodeableConcept basis;
                private FhirString measurementPoint;
                private List<CodeableConcept> country = new ArrayList<>();
                private List<ReferenceStrength> referenceStrength = new ArrayList<>();

                private Builder() {
                }

                private Builder(Strength original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.presentation = original.presentation();
                    this.textPresentation = original.textPresentation();
                    this.concentration = original.concentration();
                    this.textConcentration = original.textConcentration();
                    this.basis = original.basis();
                    this.measurementPoint = original.measurementPoint();
                    this.country = new ArrayList<>(original.country());
                    this.referenceStrength = new ArrayList<>(original.referenceStrength());
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
                 * Sets {@code presentation} to a Ratio.
                 *
                 * @param presentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder presentation(Ratio presentation) {
                    this.presentation = presentation;
                    return this;
                }

                /**
                 * Sets {@code presentation} to a RatioRange.
                 *
                 * @param presentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder presentation(RatioRange presentation) {
                    this.presentation = presentation;
                    return this;
                }

                /**
                 * Sets {@code presentation} to a CodeableConcept.
                 *
                 * @param presentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder presentation(CodeableConcept presentation) {
                    this.presentation = presentation;
                    return this;
                }

                /**
                 * Sets {@code presentation} to a Quantity.
                 *
                 * @param presentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder presentation(Quantity presentation) {
                    this.presentation = presentation;
                    return this;
                }

                /**
                 * Sets {@code textPresentation}.
                 *
                 * @param textPresentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder textPresentation(FhirString textPresentation) {
                    this.textPresentation = textPresentation;
                    return this;
                }

                /**
                 * Sets {@code textPresentation}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param textPresentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder textPresentation(String textPresentation) {
                    return textPresentation(textPresentation == null ? null : FhirString.of(textPresentation));
                }

                /**
                 * Sets {@code concentration} to a Ratio.
                 *
                 * @param concentration the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder concentration(Ratio concentration) {
                    this.concentration = concentration;
                    return this;
                }

                /**
                 * Sets {@code concentration} to a RatioRange.
                 *
                 * @param concentration the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder concentration(RatioRange concentration) {
                    this.concentration = concentration;
                    return this;
                }

                /**
                 * Sets {@code concentration} to a CodeableConcept.
                 *
                 * @param concentration the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder concentration(CodeableConcept concentration) {
                    this.concentration = concentration;
                    return this;
                }

                /**
                 * Sets {@code concentration} to a Quantity.
                 *
                 * @param concentration the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder concentration(Quantity concentration) {
                    this.concentration = concentration;
                    return this;
                }

                /**
                 * Sets {@code textConcentration}.
                 *
                 * @param textConcentration the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder textConcentration(FhirString textConcentration) {
                    this.textConcentration = textConcentration;
                    return this;
                }

                /**
                 * Sets {@code textConcentration}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param textConcentration the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder textConcentration(String textConcentration) {
                    return textConcentration(textConcentration == null ? null : FhirString.of(textConcentration));
                }

                /**
                 * Sets {@code basis}.
                 *
                 * @param basis the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder basis(CodeableConcept basis) {
                    this.basis = basis;
                    return this;
                }

                /**
                 * Sets {@code measurementPoint}.
                 *
                 * @param measurementPoint the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder measurementPoint(FhirString measurementPoint) {
                    this.measurementPoint = measurementPoint;
                    return this;
                }

                /**
                 * Sets {@code measurementPoint}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param measurementPoint the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder measurementPoint(String measurementPoint) {
                    return measurementPoint(measurementPoint == null ? null : FhirString.of(measurementPoint));
                }

                /**
                 * Replaces all {@code country} values.
                 *
                 * @param country the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder country(List<CodeableConcept> country) {
                    this.country = country == null ? new ArrayList<>() : new ArrayList<>(country);
                    return this;
                }

                /**
                 * Adds a {@code country} value.
                 *
                 * @param country the value to add
                 * @return this builder
                 */
                public Builder addCountry(CodeableConcept country) {
                    this.country.add(Objects.requireNonNull(country, "country"));
                    return this;
                }

                /**
                 * Replaces all {@code referenceStrength} values.
                 *
                 * @param referenceStrength the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder referenceStrength(List<ReferenceStrength> referenceStrength) {
                    this.referenceStrength = referenceStrength == null
                            ? new ArrayList<>()
                            : new ArrayList<>(referenceStrength);
                    return this;
                }

                /**
                 * Adds a {@code referenceStrength} value.
                 *
                 * @param referenceStrength the value to add
                 * @return this builder
                 */
                public Builder addReferenceStrength(ReferenceStrength referenceStrength) {
                    this.referenceStrength.add(Objects.requireNonNull(referenceStrength, "referenceStrength"));
                    return this;
                }

                /**
                 * Builds the {@code Strength}.
                 *
                 * @return the {@code Strength}
                 */
                public Strength build() {
                    return new Strength(
                            id, extension, modifierExtension, presentation, textPresentation, concentration,
                            textConcentration, basis, measurementPoint, country, referenceStrength);
                }
            }
        }

        /** Builder for {@link Substance}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference code;
            private List<Strength> strength = new ArrayList<>();

            private Builder() {
            }

            private Builder(Substance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.strength = new ArrayList<>(original.strength());
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
            public Builder code(CodeableReference code) {
                this.code = code;
                return this;
            }

            /**
             * Replaces all {@code strength} values.
             *
             * @param strength the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder strength(List<Strength> strength) {
                this.strength = strength == null ? new ArrayList<>() : new ArrayList<>(strength);
                return this;
            }

            /**
             * Adds a {@code strength} value.
             *
             * @param strength the value to add
             * @return this builder
             */
            public Builder addStrength(Strength strength) {
                this.strength.add(Objects.requireNonNull(strength, "strength"));
                return this;
            }

            /**
             * Builds the {@code Substance}.
             *
             * @return the {@code Substance}
             * @throws NullPointerException if a required element is absent
             */
            public Substance build() {
                return new Substance(
                        id, extension, modifierExtension, code, strength);
            }
        }
    }

    /** Builder for {@link Ingredient}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private Identifier identifier;
        private FhirEnum<PublicationStatus> status;
        private List<Reference> forValue = new ArrayList<>();
        private CodeableConcept role;
        private List<CodeableConcept> function = new ArrayList<>();
        private CodeableConcept group;
        private FhirBoolean allergenicIndicator;
        private FhirMarkdown comment;
        private List<Manufacturer> manufacturer = new ArrayList<>();
        private Substance substance;

        private Builder() {
        }

        private Builder(Ingredient original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = original.identifier();
            this.status = original.status();
            this.forValue = new ArrayList<>(original.forValue());
            this.role = original.role();
            this.function = new ArrayList<>(original.function());
            this.group = original.group();
            this.allergenicIndicator = original.allergenicIndicator();
            this.comment = original.comment();
            this.manufacturer = new ArrayList<>(original.manufacturer());
            this.substance = original.substance();
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
         * Replaces all {@code forValue} values.
         *
         * @param forValue the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder forValue(List<Reference> forValue) {
            this.forValue = forValue == null ? new ArrayList<>() : new ArrayList<>(forValue);
            return this;
        }

        /**
         * Adds a {@code forValue} value.
         *
         * @param forValue the value to add
         * @return this builder
         */
        public Builder addForValue(Reference forValue) {
            this.forValue.add(Objects.requireNonNull(forValue, "forValue"));
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
         * Replaces all {@code function} values.
         *
         * @param function the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder function(List<CodeableConcept> function) {
            this.function = function == null ? new ArrayList<>() : new ArrayList<>(function);
            return this;
        }

        /**
         * Adds a {@code function} value.
         *
         * @param function the value to add
         * @return this builder
         */
        public Builder addFunction(CodeableConcept function) {
            this.function.add(Objects.requireNonNull(function, "function"));
            return this;
        }

        /**
         * Sets {@code group}.
         *
         * @param group the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder group(CodeableConcept group) {
            this.group = group;
            return this;
        }

        /**
         * Sets {@code allergenicIndicator}.
         *
         * @param allergenicIndicator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder allergenicIndicator(FhirBoolean allergenicIndicator) {
            this.allergenicIndicator = allergenicIndicator;
            return this;
        }

        /**
         * Sets {@code allergenicIndicator}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param allergenicIndicator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder allergenicIndicator(Boolean allergenicIndicator) {
            return allergenicIndicator(allergenicIndicator == null ? null : FhirBoolean.of(allergenicIndicator));
        }

        /**
         * Sets {@code comment}.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(FhirMarkdown comment) {
            this.comment = comment;
            return this;
        }

        /**
         * Sets {@code comment}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(String comment) {
            return comment(comment == null ? null : FhirMarkdown.of(comment));
        }

        /**
         * Replaces all {@code manufacturer} values.
         *
         * @param manufacturer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder manufacturer(List<Manufacturer> manufacturer) {
            this.manufacturer = manufacturer == null ? new ArrayList<>() : new ArrayList<>(manufacturer);
            return this;
        }

        /**
         * Adds a {@code manufacturer} value.
         *
         * @param manufacturer the value to add
         * @return this builder
         */
        public Builder addManufacturer(Manufacturer manufacturer) {
            this.manufacturer.add(Objects.requireNonNull(manufacturer, "manufacturer"));
            return this;
        }

        /**
         * Sets {@code substance}.
         *
         * @param substance the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder substance(Substance substance) {
            this.substance = substance;
            return this;
        }

        /**
         * Builds the {@code Ingredient}.
         *
         * @return the {@code Ingredient}
         * @throws NullPointerException if a required element is absent
         */
        public Ingredient build() {
            return new Ingredient(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, forValue, role, function, group, allergenicIndicator, comment, manufacturer, substance);
        }
    }
}
