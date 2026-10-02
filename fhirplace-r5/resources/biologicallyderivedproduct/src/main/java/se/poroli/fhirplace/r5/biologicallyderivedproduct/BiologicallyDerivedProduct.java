package se.poroli.fhirplace.r5.biologicallyderivedproduct;

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
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * A biological material originating from a biological entity intended to be transplanted or infused into another
 * (possibly the same) biological entity.
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
 * @param productCategory organ | tissue | fluid | cells | biologicalAgent.
 * @param productCode A code that identifies the kind of this biologically derived product.
 * @param parent The parent biologically-derived product. Reference to BiologicallyDerivedProduct.
 * @param request Request to obtain and/or infuse this product. Reference to ServiceRequest.
 * @param identifier Instance identifier.
 * @param biologicalSourceEvent An identifier that supports traceability to the event during which material in this
 *   product from one or more biological entities was obtained or pooled.
 * @param processingFacility Processing facilities responsible for the labeling and distribution of this biologically
 *   derived product. Reference to Organization.
 * @param division A unique identifier for an aliquot of a product.
 * @param productStatus available | unavailable.
 * @param expirationDate Date, and where relevant time, of expiration.
 * @param collection How this product was collected.
 * @param storageTempRequirements Product storage temperature requirements.
 * @param property A property that is specific to this BiologicallyDerviedProduct instance.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/BiologicallyDerivedProduct">FHIR R5 BiologicallyDerivedProduct</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record BiologicallyDerivedProduct(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        Coding productCategory,
        CodeableConcept productCode,
        List<Reference> parent,
        List<Reference> request,
        List<Identifier> identifier,
        Identifier biologicalSourceEvent,
        List<Reference> processingFacility,
        FhirString division,
        Coding productStatus,
        FhirDateTime expirationDate,
        Collection collection,
        Range storageTempRequirements,
        List<Property> property) implements DomainResource {

    /**
     * Creates a {@code BiologicallyDerivedProduct}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public BiologicallyDerivedProduct {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        parent = parent == null ? List.of() : List.copyOf(parent);
        request = request == null ? List.of() : List.copyOf(request);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        processingFacility = processingFacility == null ? List.of() : List.copyOf(processingFacility);
        property = property == null ? List.of() : List.copyOf(property);
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
     * Returns a builder initialized with the values of this {@code BiologicallyDerivedProduct}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * How this product was collected.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param collector Individual performing collection. Reference to Practitioner, PractitionerRole.
     * @param source The patient who underwent the medical procedure to collect the product or the organization that
     *   facilitated the collection. Reference to Patient, Organization.
     * @param collected Time of product collection. One of dateTime, Period.
     */
    public record Collection(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference collector,
            Reference source,
            DataType collected) implements BackboneElement {

        /**
         * Creates a {@code Collection}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Collection {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (collected != null && !(collected instanceof FhirDateTime || collected instanceof Period)) {
                throw new IllegalArgumentException(
                        "BiologicallyDerivedProduct.collection.collected[x] must be one of dateTime, Period, but was "
                                + collected.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Collection}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Collection}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference collector;
            private Reference source;
            private DataType collected;

            private Builder() {
            }

            private Builder(Collection original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.collector = original.collector();
                this.source = original.source();
                this.collected = original.collected();
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
             * Sets {@code collector}.
             *
             * @param collector the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder collector(Reference collector) {
                this.collector = collector;
                return this;
            }

            /**
             * Sets {@code source}.
             *
             * @param source the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder source(Reference source) {
                this.source = source;
                return this;
            }

            /**
             * Sets {@code collected} to a dateTime.
             *
             * @param collected the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder collected(FhirDateTime collected) {
                this.collected = collected;
                return this;
            }

            /**
             * Sets {@code collected} to a Period.
             *
             * @param collected the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder collected(Period collected) {
                this.collected = collected;
                return this;
            }

            /**
             * Sets {@code collected} to a dateTime without id or extensions.
             *
             * @param collected the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder collected(Temporal collected) {
                this.collected = collected == null ? null : FhirDateTime.of(collected);
                return this;
            }

            /**
             * Builds the {@code Collection}.
             *
             * @return the {@code Collection}
             */
            public Collection build() {
                return new Collection(
                        id, extension, modifierExtension, collector, source, collected);
            }
        }
    }

    /**
     * A property that is specific to this BiologicallyDerviedProduct instance.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Code that specifies the property. Required.
     * @param value Property values. One of boolean, integer, CodeableConcept, Period, Quantity, Range, Ratio, string,
     *   Attachment. Required.
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
            Objects.requireNonNull(type, "BiologicallyDerivedProduct.property.type is required");
            Objects.requireNonNull(value, "BiologicallyDerivedProduct.property.value is required");
            if (value != null && !(value instanceof FhirBoolean
                    || value instanceof FhirInteger
                    || value instanceof CodeableConcept
                    || value instanceof Period
                    || value instanceof Quantity
                    || value instanceof Range
                    || value instanceof Ratio
                    || value instanceof FhirString
                    || value instanceof Attachment)) {
                throw new IllegalArgumentException(
                        "BiologicallyDerivedProduct.property.value[x] does not allow "
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
             * Sets {@code value} to a integer.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirInteger value) {
                this.value = value;
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
             * Sets {@code value} to a Period.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Period value) {
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
             * Sets {@code value} to a Ratio.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Ratio value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a string.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirString value) {
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
             * Sets {@code value} to a integer without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Integer value) {
                this.value = value == null ? null : FhirInteger.of(value);
                return this;
            }

            /**
             * Sets {@code value} to a string without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(String value) {
                this.value = value == null ? null : FhirString.of(value);
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

    /** Builder for {@link BiologicallyDerivedProduct}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private Coding productCategory;
        private CodeableConcept productCode;
        private List<Reference> parent = new ArrayList<>();
        private List<Reference> request = new ArrayList<>();
        private List<Identifier> identifier = new ArrayList<>();
        private Identifier biologicalSourceEvent;
        private List<Reference> processingFacility = new ArrayList<>();
        private FhirString division;
        private Coding productStatus;
        private FhirDateTime expirationDate;
        private Collection collection;
        private Range storageTempRequirements;
        private List<Property> property = new ArrayList<>();

        private Builder() {
        }

        private Builder(BiologicallyDerivedProduct original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.productCategory = original.productCategory();
            this.productCode = original.productCode();
            this.parent = new ArrayList<>(original.parent());
            this.request = new ArrayList<>(original.request());
            this.identifier = new ArrayList<>(original.identifier());
            this.biologicalSourceEvent = original.biologicalSourceEvent();
            this.processingFacility = new ArrayList<>(original.processingFacility());
            this.division = original.division();
            this.productStatus = original.productStatus();
            this.expirationDate = original.expirationDate();
            this.collection = original.collection();
            this.storageTempRequirements = original.storageTempRequirements();
            this.property = new ArrayList<>(original.property());
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
         * Sets {@code productCategory}.
         *
         * @param productCategory the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder productCategory(Coding productCategory) {
            this.productCategory = productCategory;
            return this;
        }

        /**
         * Sets {@code productCode}.
         *
         * @param productCode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder productCode(CodeableConcept productCode) {
            this.productCode = productCode;
            return this;
        }

        /**
         * Replaces all {@code parent} values.
         *
         * @param parent the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder parent(List<Reference> parent) {
            this.parent = parent == null ? new ArrayList<>() : new ArrayList<>(parent);
            return this;
        }

        /**
         * Adds a {@code parent} value.
         *
         * @param parent the value to add
         * @return this builder
         */
        public Builder addParent(Reference parent) {
            this.parent.add(Objects.requireNonNull(parent, "parent"));
            return this;
        }

        /**
         * Replaces all {@code request} values.
         *
         * @param request the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder request(List<Reference> request) {
            this.request = request == null ? new ArrayList<>() : new ArrayList<>(request);
            return this;
        }

        /**
         * Adds a {@code request} value.
         *
         * @param request the value to add
         * @return this builder
         */
        public Builder addRequest(Reference request) {
            this.request.add(Objects.requireNonNull(request, "request"));
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
         * Sets {@code biologicalSourceEvent}.
         *
         * @param biologicalSourceEvent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder biologicalSourceEvent(Identifier biologicalSourceEvent) {
            this.biologicalSourceEvent = biologicalSourceEvent;
            return this;
        }

        /**
         * Replaces all {@code processingFacility} values.
         *
         * @param processingFacility the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder processingFacility(List<Reference> processingFacility) {
            this.processingFacility = processingFacility == null
                    ? new ArrayList<>()
                    : new ArrayList<>(processingFacility);
            return this;
        }

        /**
         * Adds a {@code processingFacility} value.
         *
         * @param processingFacility the value to add
         * @return this builder
         */
        public Builder addProcessingFacility(Reference processingFacility) {
            this.processingFacility.add(Objects.requireNonNull(processingFacility, "processingFacility"));
            return this;
        }

        /**
         * Sets {@code division}.
         *
         * @param division the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder division(FhirString division) {
            this.division = division;
            return this;
        }

        /**
         * Sets {@code division}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param division the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder division(String division) {
            return division(division == null ? null : FhirString.of(division));
        }

        /**
         * Sets {@code productStatus}.
         *
         * @param productStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder productStatus(Coding productStatus) {
            this.productStatus = productStatus;
            return this;
        }

        /**
         * Sets {@code expirationDate}.
         *
         * @param expirationDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expirationDate(FhirDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        /**
         * Sets {@code expirationDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param expirationDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expirationDate(Temporal expirationDate) {
            return expirationDate(expirationDate == null ? null : FhirDateTime.of(expirationDate));
        }

        /**
         * Sets {@code collection}.
         *
         * @param collection the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder collection(Collection collection) {
            this.collection = collection;
            return this;
        }

        /**
         * Sets {@code storageTempRequirements}.
         *
         * @param storageTempRequirements the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder storageTempRequirements(Range storageTempRequirements) {
            this.storageTempRequirements = storageTempRequirements;
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
         * Builds the {@code BiologicallyDerivedProduct}.
         *
         * @return the {@code BiologicallyDerivedProduct}
         */
        public BiologicallyDerivedProduct build() {
            return new BiologicallyDerivedProduct(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, productCategory,
                    productCode, parent, request, identifier, biologicalSourceEvent, processingFacility, division,
                    productStatus, expirationDate, collection, storageTempRequirements, property);
        }
    }
}
