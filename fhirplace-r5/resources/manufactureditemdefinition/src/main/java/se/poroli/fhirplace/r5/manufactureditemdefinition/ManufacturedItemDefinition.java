package se.poroli.fhirplace.r5.manufactureditemdefinition;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a
 * packaged medicinal product.
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
 * @param identifier Unique identifier.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param name A descriptive name applied to this item.
 * @param manufacturedDoseForm Dose form as manufactured (before any necessary transformation). Required.
 * @param unitOfPresentation The “real-world” units in which the quantity of the item is described.
 * @param manufacturer Manufacturer of the item, one of several possible. Reference to Organization.
 * @param marketingStatus Allows specifying that an item is on the market for sale, or that it is not available, and
 *   the dates and locations associated.
 * @param ingredient The ingredients of this manufactured item. Only needed if these are not specified by incoming
 *   references from the Ingredient resource.
 * @param property General characteristics of this item.
 * @param component Physical parts of the manufactured item, that it is intrisically made from. This is distinct from
 *   the ingredients that are part of its chemical makeup.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ManufacturedItemDefinition">FHIR R5 ManufacturedItemDefinition</a>
 */
public record ManufacturedItemDefinition(
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
        FhirString name,
        CodeableConcept manufacturedDoseForm,
        CodeableConcept unitOfPresentation,
        List<Reference> manufacturer,
        List<MarketingStatus> marketingStatus,
        List<CodeableConcept> ingredient,
        List<Property> property,
        List<Component> component) implements DomainResource {

    /**
     * Creates a {@code ManufacturedItemDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public ManufacturedItemDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        manufacturer = manufacturer == null ? List.of() : List.copyOf(manufacturer);
        marketingStatus = marketingStatus == null ? List.of() : List.copyOf(marketingStatus);
        ingredient = ingredient == null ? List.of() : List.copyOf(ingredient);
        property = property == null ? List.of() : List.copyOf(property);
        component = component == null ? List.of() : List.copyOf(component);
        Objects.requireNonNull(status, "ManufacturedItemDefinition.status is required");
        Objects.requireNonNull(manufacturedDoseForm, "ManufacturedItemDefinition.manufacturedDoseForm is required");
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
     * Returns a builder initialized with the values of this {@code ManufacturedItemDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * General characteristics of this item.
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
     */
    public record Property(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType value) implements BackboneElement {

        /**
         * Creates a {@code Property}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Property {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "ManufacturedItemDefinition.property.type is required");
            if (value != null && !(value instanceof CodeableConcept
                    || value instanceof Quantity
                    || value instanceof FhirDate
                    || value instanceof FhirBoolean
                    || value instanceof FhirMarkdown
                    || value instanceof Attachment
                    || value instanceof Reference)) {
                throw new IllegalArgumentException(
                        "ManufacturedItemDefinition.property.value[x] does not allow "
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

            private Builder() {
            }

            private Builder(Property original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
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
             * Builds the {@code Property}.
             *
             * @return the {@code Property}
             * @throws NullPointerException if a required element is absent
             */
            public Property build() {
                return new Property(
                        id, extension, modifierExtension, type, value);
            }
        }
    }

    /**
     * Physical parts of the manufactured item, that it is intrisically made from.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Defining type of the component e.g. shell, layer, ink. Required.
     * @param function The function of this component within the item e.g. delivers active ingredient, masks taste.
     * @param amount The measurable amount of total quantity of all substances in the component, expressable in
     *   different ways (e.g. by mass or volume).
     * @param constituent A reference to a constituent of the manufactured item as a whole, linked here so that its
     *   component location within the item can be indicated. This not where the item's ingredient are primarily
     *   stated (for which see Ingredient.for or ManufacturedItemDefinition.ingredient).
     * @param property General characteristics of this component.
     * @param component A component that this component contains or is made from.
     */
    public record Component(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            List<CodeableConcept> function,
            List<Quantity> amount,
            List<Constituent> constituent,
            List<ManufacturedItemDefinition.Property> property,
            List<ManufacturedItemDefinition.Component> component) implements BackboneElement {

        /**
         * Creates a {@code Component}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Component {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            function = function == null ? List.of() : List.copyOf(function);
            amount = amount == null ? List.of() : List.copyOf(amount);
            constituent = constituent == null ? List.of() : List.copyOf(constituent);
            property = property == null ? List.of() : List.copyOf(property);
            component = component == null ? List.of() : List.copyOf(component);
            Objects.requireNonNull(type, "ManufacturedItemDefinition.component.type is required");
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
         * Returns a builder initialized with the values of this {@code Component}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A reference to a constituent of the manufactured item as a whole, linked here so that its component
         * location within the item can be indicated.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param amount The measurable amount of the substance, expressable in different ways (e.g. by mass or
         *   volume).
         * @param location The physical location of the constituent/ingredient within the component.
         * @param function The function of this constituent within the component e.g. binder.
         * @param hasIngredient The ingredient that is the constituent of the given component.
         */
        public record Constituent(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<Quantity> amount,
                List<CodeableConcept> location,
                List<CodeableConcept> function,
                List<CodeableReference> hasIngredient) implements BackboneElement {

            /**
             * Creates a {@code Constituent}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Constituent {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                amount = amount == null ? List.of() : List.copyOf(amount);
                location = location == null ? List.of() : List.copyOf(location);
                function = function == null ? List.of() : List.copyOf(function);
                hasIngredient = hasIngredient == null ? List.of() : List.copyOf(hasIngredient);
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
             * Returns a builder initialized with the values of this {@code Constituent}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Constituent}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<Quantity> amount = new ArrayList<>();
                private List<CodeableConcept> location = new ArrayList<>();
                private List<CodeableConcept> function = new ArrayList<>();
                private List<CodeableReference> hasIngredient = new ArrayList<>();

                private Builder() {
                }

                private Builder(Constituent original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.amount = new ArrayList<>(original.amount());
                    this.location = new ArrayList<>(original.location());
                    this.function = new ArrayList<>(original.function());
                    this.hasIngredient = new ArrayList<>(original.hasIngredient());
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
                 * Replaces all {@code amount} values.
                 *
                 * @param amount the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder amount(List<Quantity> amount) {
                    this.amount = amount == null ? new ArrayList<>() : new ArrayList<>(amount);
                    return this;
                }

                /**
                 * Adds a {@code amount} value.
                 *
                 * @param amount the value to add
                 * @return this builder
                 */
                public Builder addAmount(Quantity amount) {
                    this.amount.add(Objects.requireNonNull(amount, "amount"));
                    return this;
                }

                /**
                 * Replaces all {@code location} values.
                 *
                 * @param location the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder location(List<CodeableConcept> location) {
                    this.location = location == null ? new ArrayList<>() : new ArrayList<>(location);
                    return this;
                }

                /**
                 * Adds a {@code location} value.
                 *
                 * @param location the value to add
                 * @return this builder
                 */
                public Builder addLocation(CodeableConcept location) {
                    this.location.add(Objects.requireNonNull(location, "location"));
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
                 * Replaces all {@code hasIngredient} values.
                 *
                 * @param hasIngredient the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder hasIngredient(List<CodeableReference> hasIngredient) {
                    this.hasIngredient = hasIngredient == null ? new ArrayList<>() : new ArrayList<>(hasIngredient);
                    return this;
                }

                /**
                 * Adds a {@code hasIngredient} value.
                 *
                 * @param hasIngredient the value to add
                 * @return this builder
                 */
                public Builder addHasIngredient(CodeableReference hasIngredient) {
                    this.hasIngredient.add(Objects.requireNonNull(hasIngredient, "hasIngredient"));
                    return this;
                }

                /**
                 * Builds the {@code Constituent}.
                 *
                 * @return the {@code Constituent}
                 */
                public Constituent build() {
                    return new Constituent(
                            id, extension, modifierExtension, amount, location, function, hasIngredient);
                }
            }
        }

        /** Builder for {@link Component}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private List<CodeableConcept> function = new ArrayList<>();
            private List<Quantity> amount = new ArrayList<>();
            private List<Constituent> constituent = new ArrayList<>();
            private List<ManufacturedItemDefinition.Property> property = new ArrayList<>();
            private List<ManufacturedItemDefinition.Component> component = new ArrayList<>();

            private Builder() {
            }

            private Builder(Component original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.function = new ArrayList<>(original.function());
                this.amount = new ArrayList<>(original.amount());
                this.constituent = new ArrayList<>(original.constituent());
                this.property = new ArrayList<>(original.property());
                this.component = new ArrayList<>(original.component());
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
             * Replaces all {@code amount} values.
             *
             * @param amount the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder amount(List<Quantity> amount) {
                this.amount = amount == null ? new ArrayList<>() : new ArrayList<>(amount);
                return this;
            }

            /**
             * Adds a {@code amount} value.
             *
             * @param amount the value to add
             * @return this builder
             */
            public Builder addAmount(Quantity amount) {
                this.amount.add(Objects.requireNonNull(amount, "amount"));
                return this;
            }

            /**
             * Replaces all {@code constituent} values.
             *
             * @param constituent the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder constituent(List<Constituent> constituent) {
                this.constituent = constituent == null ? new ArrayList<>() : new ArrayList<>(constituent);
                return this;
            }

            /**
             * Adds a {@code constituent} value.
             *
             * @param constituent the value to add
             * @return this builder
             */
            public Builder addConstituent(Constituent constituent) {
                this.constituent.add(Objects.requireNonNull(constituent, "constituent"));
                return this;
            }

            /**
             * Replaces all {@code property} values.
             *
             * @param property the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder property(List<ManufacturedItemDefinition.Property> property) {
                this.property = property == null ? new ArrayList<>() : new ArrayList<>(property);
                return this;
            }

            /**
             * Adds a {@code property} value.
             *
             * @param property the value to add
             * @return this builder
             */
            public Builder addProperty(ManufacturedItemDefinition.Property property) {
                this.property.add(Objects.requireNonNull(property, "property"));
                return this;
            }

            /**
             * Replaces all {@code component} values.
             *
             * @param component the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder component(List<ManufacturedItemDefinition.Component> component) {
                this.component = component == null ? new ArrayList<>() : new ArrayList<>(component);
                return this;
            }

            /**
             * Adds a {@code component} value.
             *
             * @param component the value to add
             * @return this builder
             */
            public Builder addComponent(ManufacturedItemDefinition.Component component) {
                this.component.add(Objects.requireNonNull(component, "component"));
                return this;
            }

            /**
             * Builds the {@code Component}.
             *
             * @return the {@code Component}
             * @throws NullPointerException if a required element is absent
             */
            public Component build() {
                return new Component(
                        id, extension, modifierExtension, type, function, amount, constituent, property, component);
            }
        }
    }

    /** Builder for {@link ManufacturedItemDefinition}. Builders are mutable and not thread-safe. */
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
        private FhirString name;
        private CodeableConcept manufacturedDoseForm;
        private CodeableConcept unitOfPresentation;
        private List<Reference> manufacturer = new ArrayList<>();
        private List<MarketingStatus> marketingStatus = new ArrayList<>();
        private List<CodeableConcept> ingredient = new ArrayList<>();
        private List<Property> property = new ArrayList<>();
        private List<Component> component = new ArrayList<>();

        private Builder() {
        }

        private Builder(ManufacturedItemDefinition original) {
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
            this.name = original.name();
            this.manufacturedDoseForm = original.manufacturedDoseForm();
            this.unitOfPresentation = original.unitOfPresentation();
            this.manufacturer = new ArrayList<>(original.manufacturer());
            this.marketingStatus = new ArrayList<>(original.marketingStatus());
            this.ingredient = new ArrayList<>(original.ingredient());
            this.property = new ArrayList<>(original.property());
            this.component = new ArrayList<>(original.component());
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
         * Sets {@code manufacturedDoseForm}.
         *
         * @param manufacturedDoseForm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder manufacturedDoseForm(CodeableConcept manufacturedDoseForm) {
            this.manufacturedDoseForm = manufacturedDoseForm;
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
         * Replaces all {@code manufacturer} values.
         *
         * @param manufacturer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder manufacturer(List<Reference> manufacturer) {
            this.manufacturer = manufacturer == null ? new ArrayList<>() : new ArrayList<>(manufacturer);
            return this;
        }

        /**
         * Adds a {@code manufacturer} value.
         *
         * @param manufacturer the value to add
         * @return this builder
         */
        public Builder addManufacturer(Reference manufacturer) {
            this.manufacturer.add(Objects.requireNonNull(manufacturer, "manufacturer"));
            return this;
        }

        /**
         * Replaces all {@code marketingStatus} values.
         *
         * @param marketingStatus the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder marketingStatus(List<MarketingStatus> marketingStatus) {
            this.marketingStatus = marketingStatus == null ? new ArrayList<>() : new ArrayList<>(marketingStatus);
            return this;
        }

        /**
         * Adds a {@code marketingStatus} value.
         *
         * @param marketingStatus the value to add
         * @return this builder
         */
        public Builder addMarketingStatus(MarketingStatus marketingStatus) {
            this.marketingStatus.add(Objects.requireNonNull(marketingStatus, "marketingStatus"));
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
         * Replaces all {@code component} values.
         *
         * @param component the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder component(List<Component> component) {
            this.component = component == null ? new ArrayList<>() : new ArrayList<>(component);
            return this;
        }

        /**
         * Adds a {@code component} value.
         *
         * @param component the value to add
         * @return this builder
         */
        public Builder addComponent(Component component) {
            this.component.add(Objects.requireNonNull(component, "component"));
            return this;
        }

        /**
         * Builds the {@code ManufacturedItemDefinition}.
         *
         * @return the {@code ManufacturedItemDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public ManufacturedItemDefinition build() {
            return new ManufacturedItemDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, name, manufacturedDoseForm, unitOfPresentation, manufacturer, marketingStatus, ingredient,
                    property, component);
        }
    }
}
