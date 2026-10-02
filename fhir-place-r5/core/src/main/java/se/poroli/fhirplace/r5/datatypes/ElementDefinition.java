package se.poroli.fhirplace.r5.datatypes;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.AdditionalBindingPurposeVS;
import se.poroli.fhirplace.r5.valuesets.AggregationMode;
import se.poroli.fhirplace.r5.valuesets.BindingStrength;
import se.poroli.fhirplace.r5.valuesets.ConstraintSeverity;
import se.poroli.fhirplace.r5.valuesets.DiscriminatorType;
import se.poroli.fhirplace.r5.valuesets.PropertyRepresentation;
import se.poroli.fhirplace.r5.valuesets.ReferenceVersionRules;
import se.poroli.fhirplace.r5.valuesets.SlicingRules;

/**
 * Captures constraints on each element within the resource, profile, or extension.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
 * @param path Path of the element in the hierarchy of elements. Required.
 * @param representation xmlAttr | xmlText | typeAttr | cdaText | xhtml.
 * @param sliceName Name for this particular element (in a set of slices).
 * @param sliceIsConstraining If this slice definition constrains an inherited slice definition (or not).
 * @param label Name for element to display with or prompt for element.
 * @param code Corresponding codes in terminologies.
 * @param slicing This element is sliced - slices follow.
 * @param shortValue Concise definition for space-constrained presentation. The FHIR element {@code short}.
 * @param definition Full formal definition as narrative text.
 * @param comment Comments about the use of this element.
 * @param requirements Why this resource has been created.
 * @param alias Other names.
 * @param min Minimum Cardinality.
 * @param max Maximum Cardinality (a number or *).
 * @param base Base definition information for tools.
 * @param contentReference Reference to definition of content for the element.
 * @param type Data type and Profile for this element.
 * @param defaultValue Specified value if missing from instance. Any datatype except Contributor,
 *   VirtualServiceDetail, MonetaryComponent, Narrative, Extension, ElementDefinition, ProductShelfLife,
 *   MarketingStatus.
 * @param meaningWhenMissing Implicit meaning when this element is missing.
 * @param orderMeaning What the order of the elements means.
 * @param fixed Value must be exactly this. Any datatype except Contributor, VirtualServiceDetail, MonetaryComponent,
 *   Narrative, Extension, ElementDefinition, ProductShelfLife, MarketingStatus.
 * @param pattern Value must have at least these property values. Any datatype except Contributor,
 *   VirtualServiceDetail, MonetaryComponent, Narrative, Extension, ElementDefinition, ProductShelfLife,
 *   MarketingStatus.
 * @param example Example value (as defined for type).
 * @param minValue Minimum Allowed Value (for some types). One of date, dateTime, instant, time, decimal, integer,
 *   integer64, positiveInt, unsignedInt, Quantity.
 * @param maxValue Maximum Allowed Value (for some types). One of date, dateTime, instant, time, decimal, integer,
 *   integer64, positiveInt, unsignedInt, Quantity.
 * @param maxLength Max length for string type data.
 * @param condition Reference to invariant about presence.
 * @param constraint Condition that must evaluate to true.
 * @param mustHaveValue For primitives, that a value must be present - not replaced by an extension.
 * @param valueAlternatives Extensions that are allowed to replace a primitive value. Canonical reference to
 *   StructureDefinition.
 * @param mustSupport If the element must be supported (discouraged - see obligations).
 * @param isModifier If this modifies the meaning of other elements.
 * @param isModifierReason Reason that this element is marked as a modifier.
 * @param isSummary Include when _summary = true?.
 * @param binding ValueSet details if this is coded.
 * @param mapping Map element to another set of definitions.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ElementDefinition">FHIR R5 ElementDefinition</a>
 */
public record ElementDefinition(
        String id,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirString path,
        List<FhirEnum<PropertyRepresentation>> representation,
        FhirString sliceName,
        FhirBoolean sliceIsConstraining,
        FhirString label,
        List<Coding> code,
        Slicing slicing,
        FhirString shortValue,
        FhirMarkdown definition,
        FhirMarkdown comment,
        FhirMarkdown requirements,
        List<FhirString> alias,
        FhirUnsignedInt min,
        FhirString max,
        Base base,
        FhirUri contentReference,
        List<TypeRef> type,
        DataType defaultValue,
        FhirMarkdown meaningWhenMissing,
        FhirString orderMeaning,
        DataType fixed,
        DataType pattern,
        List<Example> example,
        DataType minValue,
        DataType maxValue,
        FhirInteger maxLength,
        List<FhirId> condition,
        List<Constraint> constraint,
        FhirBoolean mustHaveValue,
        List<FhirCanonical> valueAlternatives,
        FhirBoolean mustSupport,
        FhirBoolean isModifier,
        FhirString isModifierReason,
        FhirBoolean isSummary,
        ElementDefinitionBinding binding,
        List<Mapping> mapping) implements BackboneType {

    /**
     * Creates an {@code ElementDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ElementDefinition {
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        representation = representation == null ? List.of() : List.copyOf(representation);
        code = code == null ? List.of() : List.copyOf(code);
        alias = alias == null ? List.of() : List.copyOf(alias);
        type = type == null ? List.of() : List.copyOf(type);
        example = example == null ? List.of() : List.copyOf(example);
        condition = condition == null ? List.of() : List.copyOf(condition);
        constraint = constraint == null ? List.of() : List.copyOf(constraint);
        valueAlternatives = valueAlternatives == null ? List.of() : List.copyOf(valueAlternatives);
        mapping = mapping == null ? List.of() : List.copyOf(mapping);
        Objects.requireNonNull(path, "ElementDefinition.path is required");
        if (defaultValue != null && (defaultValue instanceof Contributor
                || defaultValue instanceof VirtualServiceDetail
                || defaultValue instanceof MonetaryComponent
                || defaultValue instanceof Narrative
                || defaultValue instanceof Extension
                || defaultValue instanceof ElementDefinition
                || defaultValue instanceof ProductShelfLife
                || defaultValue instanceof MarketingStatus)) {
            throw new IllegalArgumentException(
                    "ElementDefinition.defaultValue[x] does not allow "
                            + defaultValue.getClass().getSimpleName());
        }
        if (fixed != null && (fixed instanceof Contributor
                || fixed instanceof VirtualServiceDetail
                || fixed instanceof MonetaryComponent
                || fixed instanceof Narrative
                || fixed instanceof Extension
                || fixed instanceof ElementDefinition
                || fixed instanceof ProductShelfLife
                || fixed instanceof MarketingStatus)) {
            throw new IllegalArgumentException(
                    "ElementDefinition.fixed[x] does not allow "
                            + fixed.getClass().getSimpleName());
        }
        if (pattern != null && (pattern instanceof Contributor
                || pattern instanceof VirtualServiceDetail
                || pattern instanceof MonetaryComponent
                || pattern instanceof Narrative
                || pattern instanceof Extension
                || pattern instanceof ElementDefinition
                || pattern instanceof ProductShelfLife
                || pattern instanceof MarketingStatus)) {
            throw new IllegalArgumentException(
                    "ElementDefinition.pattern[x] does not allow "
                            + pattern.getClass().getSimpleName());
        }
        if (minValue != null && !(minValue instanceof FhirDate
                || minValue instanceof FhirDateTime
                || minValue instanceof FhirInstant
                || minValue instanceof FhirTime
                || minValue instanceof FhirDecimal
                || minValue instanceof FhirInteger
                || minValue instanceof FhirInteger64
                || minValue instanceof FhirPositiveInt
                || minValue instanceof FhirUnsignedInt
                || minValue instanceof Quantity)) {
            throw new IllegalArgumentException(
                    "ElementDefinition.minValue[x] does not allow "
                            + minValue.getClass().getSimpleName());
        }
        if (maxValue != null && !(maxValue instanceof FhirDate
                || maxValue instanceof FhirDateTime
                || maxValue instanceof FhirInstant
                || maxValue instanceof FhirTime
                || maxValue instanceof FhirDecimal
                || maxValue instanceof FhirInteger
                || maxValue instanceof FhirInteger64
                || maxValue instanceof FhirPositiveInt
                || maxValue instanceof FhirUnsignedInt
                || maxValue instanceof Quantity)) {
            throw new IllegalArgumentException(
                    "ElementDefinition.maxValue[x] does not allow "
                            + maxValue.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code ElementDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates that the element is sliced into a set of alternative definitions (i.e. in a structure definition,
     * there are multiple different constraints on a single element in the base resource).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param discriminator Element values that are used to distinguish the slices.
     * @param description Text description of how slicing works (or not).
     * @param ordered If elements must be in same order as slices.
     * @param rules closed | open | openAtEnd. Required.
     */
    public record Slicing(
            String id,
            List<Extension> extension,
            List<Discriminator> discriminator,
            FhirString description,
            FhirBoolean ordered,
            FhirEnum<SlicingRules> rules) implements Element {

        /**
         * Creates a {@code Slicing}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Slicing {
            extension = extension == null ? List.of() : List.copyOf(extension);
            discriminator = discriminator == null ? List.of() : List.copyOf(discriminator);
            Objects.requireNonNull(rules, "ElementDefinition.slicing.rules is required");
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
         * Returns a builder initialized with the values of this {@code Slicing}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Designates which child elements are used to discriminate between the slices when processing an instance.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param type value | exists | type | profile | position. Required.
         * @param path Path to element value. Required.
         */
        public record Discriminator(
                String id,
                List<Extension> extension,
                FhirEnum<DiscriminatorType> type,
                FhirString path) implements Element {

            /**
             * Creates a {@code Discriminator}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Discriminator {
                extension = extension == null ? List.of() : List.copyOf(extension);
                Objects.requireNonNull(type, "ElementDefinition.slicing.discriminator.type is required");
                Objects.requireNonNull(path, "ElementDefinition.slicing.discriminator.path is required");
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
             * Returns a builder initialized with the values of this {@code Discriminator}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Discriminator}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private FhirEnum<DiscriminatorType> type;
                private FhirString path;

                private Builder() {
                }

                private Builder(Discriminator original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.type = original.type();
                    this.path = original.path();
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
                 * Sets {@code type}.
                 *
                 * @param type the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder type(FhirEnum<DiscriminatorType> type) {
                    this.type = type;
                    return this;
                }

                /**
                 * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param type the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder type(DiscriminatorType type) {
                    return type(type == null ? null : FhirEnum.of(type));
                }

                /**
                 * Sets {@code path}.
                 *
                 * @param path the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder path(FhirString path) {
                    this.path = path;
                    return this;
                }

                /**
                 * Sets {@code path}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param path the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder path(String path) {
                    return path(path == null ? null : FhirString.of(path));
                }

                /**
                 * Builds the {@code Discriminator}.
                 *
                 * @return the {@code Discriminator}
                 * @throws NullPointerException if a required element is absent
                 */
                public Discriminator build() {
                    return new Discriminator(
                            id, extension, type, path);
                }
            }
        }

        /** Builder for {@link Slicing}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Discriminator> discriminator = new ArrayList<>();
            private FhirString description;
            private FhirBoolean ordered;
            private FhirEnum<SlicingRules> rules;

            private Builder() {
            }

            private Builder(Slicing original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.discriminator = new ArrayList<>(original.discriminator());
                this.description = original.description();
                this.ordered = original.ordered();
                this.rules = original.rules();
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
             * Replaces all {@code discriminator} values.
             *
             * @param discriminator the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder discriminator(List<Discriminator> discriminator) {
                this.discriminator = discriminator == null ? new ArrayList<>() : new ArrayList<>(discriminator);
                return this;
            }

            /**
             * Adds a {@code discriminator} value.
             *
             * @param discriminator the value to add
             * @return this builder
             */
            public Builder addDiscriminator(Discriminator discriminator) {
                this.discriminator.add(Objects.requireNonNull(discriminator, "discriminator"));
                return this;
            }

            /**
             * Sets {@code description}.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(FhirString description) {
                this.description = description;
                return this;
            }

            /**
             * Sets {@code description}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(String description) {
                return description(description == null ? null : FhirString.of(description));
            }

            /**
             * Sets {@code ordered}.
             *
             * @param ordered the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder ordered(FhirBoolean ordered) {
                this.ordered = ordered;
                return this;
            }

            /**
             * Sets {@code ordered}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param ordered the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder ordered(Boolean ordered) {
                return ordered(ordered == null ? null : FhirBoolean.of(ordered));
            }

            /**
             * Sets {@code rules}.
             *
             * @param rules the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rules(FhirEnum<SlicingRules> rules) {
                this.rules = rules;
                return this;
            }

            /**
             * Sets {@code rules}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param rules the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rules(SlicingRules rules) {
                return rules(rules == null ? null : FhirEnum.of(rules));
            }

            /**
             * Builds the {@code Slicing}.
             *
             * @return the {@code Slicing}
             * @throws NullPointerException if a required element is absent
             */
            public Slicing build() {
                return new Slicing(
                        id, extension, discriminator, description, ordered, rules);
            }
        }
    }

    /**
     * Information about the base definition of the element, provided to make it unnecessary for tools to trace the
     * deviation of the element through the derived and related profiles.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param path Path that identifies the base element. Required.
     * @param min Min cardinality of the base element. Required.
     * @param max Max cardinality of the base element. Required.
     */
    public record Base(
            String id,
            List<Extension> extension,
            FhirString path,
            FhirUnsignedInt min,
            FhirString max) implements Element {

        /**
         * Creates a {@code Base}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Base {
            extension = extension == null ? List.of() : List.copyOf(extension);
            Objects.requireNonNull(path, "ElementDefinition.base.path is required");
            Objects.requireNonNull(min, "ElementDefinition.base.min is required");
            Objects.requireNonNull(max, "ElementDefinition.base.max is required");
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
         * Returns a builder initialized with the values of this {@code Base}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Base}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private FhirString path;
            private FhirUnsignedInt min;
            private FhirString max;

            private Builder() {
            }

            private Builder(Base original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.path = original.path();
                this.min = original.min();
                this.max = original.max();
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
             * Sets {@code path}.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(FhirString path) {
                this.path = path;
                return this;
            }

            /**
             * Sets {@code path}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(String path) {
                return path(path == null ? null : FhirString.of(path));
            }

            /**
             * Sets {@code min}.
             *
             * @param min the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder min(FhirUnsignedInt min) {
                this.min = min;
                return this;
            }

            /**
             * Sets {@code min}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
             *
             * @param min the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder min(Integer min) {
                return min(min == null ? null : FhirUnsignedInt.of(min));
            }

            /**
             * Sets {@code max}.
             *
             * @param max the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder max(FhirString max) {
                this.max = max;
                return this;
            }

            /**
             * Sets {@code max}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param max the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder max(String max) {
                return max(max == null ? null : FhirString.of(max));
            }

            /**
             * Builds the {@code Base}.
             *
             * @return the {@code Base}
             * @throws NullPointerException if a required element is absent
             */
            public Base build() {
                return new Base(
                        id, extension, path, min, max);
            }
        }
    }

    /**
     * The data type or resource that the value of this element is permitted to be.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param code Data type or Resource (reference to definition). Required.
     * @param profile Profiles (StructureDefinition or IG) - one must apply. Canonical reference to
     *   StructureDefinition, ImplementationGuide.
     * @param targetProfile Profile (StructureDefinition or IG) on the Reference/canonical target - one must apply.
     *   Canonical reference to StructureDefinition, ImplementationGuide.
     * @param aggregation contained | referenced | bundled - how aggregated.
     * @param versioning either | independent | specific.
     */
    public record TypeRef(
            String id,
            List<Extension> extension,
            FhirUri code,
            List<FhirCanonical> profile,
            List<FhirCanonical> targetProfile,
            List<FhirEnum<AggregationMode>> aggregation,
            FhirEnum<ReferenceVersionRules> versioning) implements Element {

        /**
         * Creates a {@code TypeRef}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public TypeRef {
            extension = extension == null ? List.of() : List.copyOf(extension);
            profile = profile == null ? List.of() : List.copyOf(profile);
            targetProfile = targetProfile == null ? List.of() : List.copyOf(targetProfile);
            aggregation = aggregation == null ? List.of() : List.copyOf(aggregation);
            Objects.requireNonNull(code, "ElementDefinition.type.code is required");
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
         * Returns a builder initialized with the values of this {@code TypeRef}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link TypeRef}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private FhirUri code;
            private List<FhirCanonical> profile = new ArrayList<>();
            private List<FhirCanonical> targetProfile = new ArrayList<>();
            private List<FhirEnum<AggregationMode>> aggregation = new ArrayList<>();
            private FhirEnum<ReferenceVersionRules> versioning;

            private Builder() {
            }

            private Builder(TypeRef original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.code = original.code();
                this.profile = new ArrayList<>(original.profile());
                this.targetProfile = new ArrayList<>(original.targetProfile());
                this.aggregation = new ArrayList<>(original.aggregation());
                this.versioning = original.versioning();
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
             * Sets {@code code}.
             *
             * @param code the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder code(FhirUri code) {
                this.code = code;
                return this;
            }

            /**
             * Sets {@code code}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param code the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder code(String code) {
                return code(code == null ? null : FhirUri.of(code));
            }

            /**
             * Replaces all {@code profile} values.
             *
             * @param profile the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder profile(List<FhirCanonical> profile) {
                this.profile = profile == null ? new ArrayList<>() : new ArrayList<>(profile);
                return this;
            }

            /**
             * Adds a {@code profile} value.
             *
             * @param profile the value to add
             * @return this builder
             */
            public Builder addProfile(FhirCanonical profile) {
                this.profile.add(Objects.requireNonNull(profile, "profile"));
                return this;
            }

            /**
             * Adds a {@code profile} value, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param profile the value to add
             * @return this builder
             */
            public Builder addProfile(String profile) {
                return addProfile(FhirCanonical.of(profile));
            }

            /**
             * Replaces all {@code targetProfile} values.
             *
             * @param targetProfile the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder targetProfile(List<FhirCanonical> targetProfile) {
                this.targetProfile = targetProfile == null ? new ArrayList<>() : new ArrayList<>(targetProfile);
                return this;
            }

            /**
             * Adds a {@code targetProfile} value.
             *
             * @param targetProfile the value to add
             * @return this builder
             */
            public Builder addTargetProfile(FhirCanonical targetProfile) {
                this.targetProfile.add(Objects.requireNonNull(targetProfile, "targetProfile"));
                return this;
            }

            /**
             * Adds a {@code targetProfile} value, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param targetProfile the value to add
             * @return this builder
             */
            public Builder addTargetProfile(String targetProfile) {
                return addTargetProfile(FhirCanonical.of(targetProfile));
            }

            /**
             * Replaces all {@code aggregation} values.
             *
             * @param aggregation the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder aggregation(List<FhirEnum<AggregationMode>> aggregation) {
                this.aggregation = aggregation == null ? new ArrayList<>() : new ArrayList<>(aggregation);
                return this;
            }

            /**
             * Adds a {@code aggregation} value.
             *
             * @param aggregation the value to add
             * @return this builder
             */
            public Builder addAggregation(FhirEnum<AggregationMode> aggregation) {
                this.aggregation.add(Objects.requireNonNull(aggregation, "aggregation"));
                return this;
            }

            /**
             * Adds a {@code aggregation} value, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param aggregation the value to add
             * @return this builder
             */
            public Builder addAggregation(AggregationMode aggregation) {
                return addAggregation(FhirEnum.of(aggregation));
            }

            /**
             * Sets {@code versioning}.
             *
             * @param versioning the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder versioning(FhirEnum<ReferenceVersionRules> versioning) {
                this.versioning = versioning;
                return this;
            }

            /**
             * Sets {@code versioning}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param versioning the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder versioning(ReferenceVersionRules versioning) {
                return versioning(versioning == null ? null : FhirEnum.of(versioning));
            }

            /**
             * Builds the {@code TypeRef}.
             *
             * @return the {@code TypeRef}
             * @throws NullPointerException if a required element is absent
             */
            public TypeRef build() {
                return new TypeRef(
                        id, extension, code, profile, targetProfile, aggregation, versioning);
            }
        }
    }

    /**
     * A sample value for this element demonstrating the type of information that would typically be found in the
     * element.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param label Describes the purpose of this example. Required.
     * @param value Value of Example (one of allowed types). Any datatype except Contributor, VirtualServiceDetail,
     *   MonetaryComponent, Narrative, Extension, ElementDefinition, ProductShelfLife, MarketingStatus. Required.
     */
    public record Example(
            String id,
            List<Extension> extension,
            FhirString label,
            DataType value) implements Element {

        /**
         * Creates an {@code Example}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Example {
            extension = extension == null ? List.of() : List.copyOf(extension);
            Objects.requireNonNull(label, "ElementDefinition.example.label is required");
            Objects.requireNonNull(value, "ElementDefinition.example.value is required");
            if (value != null && (value instanceof Contributor
                    || value instanceof VirtualServiceDetail
                    || value instanceof MonetaryComponent
                    || value instanceof Narrative
                    || value instanceof Extension
                    || value instanceof ElementDefinition
                    || value instanceof ProductShelfLife
                    || value instanceof MarketingStatus)) {
                throw new IllegalArgumentException(
                        "ElementDefinition.example.value[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code Example}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Example}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private FhirString label;
            private DataType value;

            private Builder() {
            }

            private Builder(Example original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.label = original.label();
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
             * Sets {@code label}.
             *
             * @param label the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder label(FhirString label) {
                this.label = label;
                return this;
            }

            /**
             * Sets {@code label}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param label the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder label(String label) {
                return label(label == null ? null : FhirString.of(label));
            }

            /**
             * Sets {@code value}.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(DataType value) {
                this.value = value;
                return this;
            }

            /**
             * Builds the {@code Example}.
             *
             * @return the {@code Example}
             * @throws NullPointerException if a required element is absent
             */
            public Example build() {
                return new Example(
                        id, extension, label, value);
            }
        }
    }

    /**
     * Formal constraints such as co-occurrence and other constraints that can be computationally evaluated within the
     * context of the instance.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param key Target of 'condition' reference above. Required.
     * @param requirements Why this constraint is necessary or appropriate.
     * @param severity error | warning. Required.
     * @param suppress Suppress warning or hint in profile.
     * @param human Human description of constraint. Required.
     * @param expression FHIRPath expression of constraint.
     * @param source Reference to original source of constraint. Canonical reference to StructureDefinition.
     */
    public record Constraint(
            String id,
            List<Extension> extension,
            FhirId key,
            FhirMarkdown requirements,
            FhirEnum<ConstraintSeverity> severity,
            FhirBoolean suppress,
            FhirString human,
            FhirString expression,
            FhirCanonical source) implements Element {

        /**
         * Creates a {@code Constraint}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Constraint {
            extension = extension == null ? List.of() : List.copyOf(extension);
            Objects.requireNonNull(key, "ElementDefinition.constraint.key is required");
            Objects.requireNonNull(severity, "ElementDefinition.constraint.severity is required");
            Objects.requireNonNull(human, "ElementDefinition.constraint.human is required");
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
         * Returns a builder initialized with the values of this {@code Constraint}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Constraint}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private FhirId key;
            private FhirMarkdown requirements;
            private FhirEnum<ConstraintSeverity> severity;
            private FhirBoolean suppress;
            private FhirString human;
            private FhirString expression;
            private FhirCanonical source;

            private Builder() {
            }

            private Builder(Constraint original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.key = original.key();
                this.requirements = original.requirements();
                this.severity = original.severity();
                this.suppress = original.suppress();
                this.human = original.human();
                this.expression = original.expression();
                this.source = original.source();
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
             * Sets {@code key}.
             *
             * @param key the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder key(FhirId key) {
                this.key = key;
                return this;
            }

            /**
             * Sets {@code key}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param key the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder key(String key) {
                return key(key == null ? null : FhirId.of(key));
            }

            /**
             * Sets {@code requirements}.
             *
             * @param requirements the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder requirements(FhirMarkdown requirements) {
                this.requirements = requirements;
                return this;
            }

            /**
             * Sets {@code requirements}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param requirements the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder requirements(String requirements) {
                return requirements(requirements == null ? null : FhirMarkdown.of(requirements));
            }

            /**
             * Sets {@code severity}.
             *
             * @param severity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder severity(FhirEnum<ConstraintSeverity> severity) {
                this.severity = severity;
                return this;
            }

            /**
             * Sets {@code severity}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param severity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder severity(ConstraintSeverity severity) {
                return severity(severity == null ? null : FhirEnum.of(severity));
            }

            /**
             * Sets {@code suppress}.
             *
             * @param suppress the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder suppress(FhirBoolean suppress) {
                this.suppress = suppress;
                return this;
            }

            /**
             * Sets {@code suppress}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param suppress the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder suppress(Boolean suppress) {
                return suppress(suppress == null ? null : FhirBoolean.of(suppress));
            }

            /**
             * Sets {@code human}.
             *
             * @param human the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder human(FhirString human) {
                this.human = human;
                return this;
            }

            /**
             * Sets {@code human}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param human the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder human(String human) {
                return human(human == null ? null : FhirString.of(human));
            }

            /**
             * Sets {@code expression}.
             *
             * @param expression the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder expression(FhirString expression) {
                this.expression = expression;
                return this;
            }

            /**
             * Sets {@code expression}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param expression the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder expression(String expression) {
                return expression(expression == null ? null : FhirString.of(expression));
            }

            /**
             * Sets {@code source}.
             *
             * @param source the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder source(FhirCanonical source) {
                this.source = source;
                return this;
            }

            /**
             * Sets {@code source}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param source the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder source(String source) {
                return source(source == null ? null : FhirCanonical.of(source));
            }

            /**
             * Builds the {@code Constraint}.
             *
             * @return the {@code Constraint}
             * @throws NullPointerException if a required element is absent
             */
            public Constraint build() {
                return new Constraint(
                        id, extension, key, requirements, severity, suppress, human, expression, source);
            }
        }
    }

    /**
     * Binds to a value set if this element is coded (code, Coding, CodeableConcept, Quantity), or the data types
     * (string, uri).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param strength required | extensible | preferred | example. Required.
     * @param description Intended use of codes in the bound value set.
     * @param valueSet Source of value set. Canonical reference to ValueSet.
     * @param additional Additional Bindings - more rules about the binding.
     */
    public record ElementDefinitionBinding(
            String id,
            List<Extension> extension,
            FhirEnum<BindingStrength> strength,
            FhirMarkdown description,
            FhirCanonical valueSet,
            List<Additional> additional) implements Element {

        /**
         * Creates an {@code ElementDefinitionBinding}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ElementDefinitionBinding {
            extension = extension == null ? List.of() : List.copyOf(extension);
            additional = additional == null ? List.of() : List.copyOf(additional);
            Objects.requireNonNull(strength, "ElementDefinition.binding.strength is required");
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
         * Returns a builder initialized with the values of this {@code ElementDefinitionBinding}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Additional bindings that help applications implementing this element.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param purpose maximum | minimum | required | extensible | candidate | current | preferred | ui | starter |
         *   component. Required.
         * @param valueSet The value set for the additional binding. Canonical reference to ValueSet. Required.
         * @param documentation Documentation of the purpose of use of the binding.
         * @param shortDoco Concise documentation - for summary tables.
         * @param usage Qualifies the usage - jurisdiction, gender, workflow status etc.
         * @param any Whether binding can applies to all repeats, or just one.
         */
        public record Additional(
                String id,
                List<Extension> extension,
                FhirEnum<AdditionalBindingPurposeVS> purpose,
                FhirCanonical valueSet,
                FhirMarkdown documentation,
                FhirString shortDoco,
                List<UsageContext> usage,
                FhirBoolean any) implements Element {

            /**
             * Creates an {@code Additional}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Additional {
                extension = extension == null ? List.of() : List.copyOf(extension);
                usage = usage == null ? List.of() : List.copyOf(usage);
                Objects.requireNonNull(purpose, "ElementDefinition.binding.additional.purpose is required");
                Objects.requireNonNull(valueSet, "ElementDefinition.binding.additional.valueSet is required");
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
             * Returns a builder initialized with the values of this {@code Additional}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Additional}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private FhirEnum<AdditionalBindingPurposeVS> purpose;
                private FhirCanonical valueSet;
                private FhirMarkdown documentation;
                private FhirString shortDoco;
                private List<UsageContext> usage = new ArrayList<>();
                private FhirBoolean any;

                private Builder() {
                }

                private Builder(Additional original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.purpose = original.purpose();
                    this.valueSet = original.valueSet();
                    this.documentation = original.documentation();
                    this.shortDoco = original.shortDoco();
                    this.usage = new ArrayList<>(original.usage());
                    this.any = original.any();
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
                 * Sets {@code purpose}.
                 *
                 * @param purpose the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder purpose(FhirEnum<AdditionalBindingPurposeVS> purpose) {
                    this.purpose = purpose;
                    return this;
                }

                /**
                 * Sets {@code purpose}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param purpose the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder purpose(AdditionalBindingPurposeVS purpose) {
                    return purpose(purpose == null ? null : FhirEnum.of(purpose));
                }

                /**
                 * Sets {@code valueSet}.
                 *
                 * @param valueSet the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder valueSet(FhirCanonical valueSet) {
                    this.valueSet = valueSet;
                    return this;
                }

                /**
                 * Sets {@code valueSet}, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param valueSet the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder valueSet(String valueSet) {
                    return valueSet(valueSet == null ? null : FhirCanonical.of(valueSet));
                }

                /**
                 * Sets {@code documentation}.
                 *
                 * @param documentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder documentation(FhirMarkdown documentation) {
                    this.documentation = documentation;
                    return this;
                }

                /**
                 * Sets {@code documentation}, wrapped in a {@link FhirMarkdown} without id or extensions.
                 *
                 * @param documentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder documentation(String documentation) {
                    return documentation(documentation == null ? null : FhirMarkdown.of(documentation));
                }

                /**
                 * Sets {@code shortDoco}.
                 *
                 * @param shortDoco the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder shortDoco(FhirString shortDoco) {
                    this.shortDoco = shortDoco;
                    return this;
                }

                /**
                 * Sets {@code shortDoco}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param shortDoco the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder shortDoco(String shortDoco) {
                    return shortDoco(shortDoco == null ? null : FhirString.of(shortDoco));
                }

                /**
                 * Replaces all {@code usage} values.
                 *
                 * @param usage the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder usage(List<UsageContext> usage) {
                    this.usage = usage == null ? new ArrayList<>() : new ArrayList<>(usage);
                    return this;
                }

                /**
                 * Adds a {@code usage} value.
                 *
                 * @param usage the value to add
                 * @return this builder
                 */
                public Builder addUsage(UsageContext usage) {
                    this.usage.add(Objects.requireNonNull(usage, "usage"));
                    return this;
                }

                /**
                 * Sets {@code any}.
                 *
                 * @param any the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder any(FhirBoolean any) {
                    this.any = any;
                    return this;
                }

                /**
                 * Sets {@code any}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param any the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder any(Boolean any) {
                    return any(any == null ? null : FhirBoolean.of(any));
                }

                /**
                 * Builds the {@code Additional}.
                 *
                 * @return the {@code Additional}
                 * @throws NullPointerException if a required element is absent
                 */
                public Additional build() {
                    return new Additional(
                            id, extension, purpose, valueSet, documentation, shortDoco, usage, any);
                }
            }
        }

        /** Builder for {@link ElementDefinitionBinding}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private FhirEnum<BindingStrength> strength;
            private FhirMarkdown description;
            private FhirCanonical valueSet;
            private List<Additional> additional = new ArrayList<>();

            private Builder() {
            }

            private Builder(ElementDefinitionBinding original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.strength = original.strength();
                this.description = original.description();
                this.valueSet = original.valueSet();
                this.additional = new ArrayList<>(original.additional());
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
             * Sets {@code strength}.
             *
             * @param strength the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder strength(FhirEnum<BindingStrength> strength) {
                this.strength = strength;
                return this;
            }

            /**
             * Sets {@code strength}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param strength the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder strength(BindingStrength strength) {
                return strength(strength == null ? null : FhirEnum.of(strength));
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
             * Sets {@code valueSet}.
             *
             * @param valueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder valueSet(FhirCanonical valueSet) {
                this.valueSet = valueSet;
                return this;
            }

            /**
             * Sets {@code valueSet}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param valueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder valueSet(String valueSet) {
                return valueSet(valueSet == null ? null : FhirCanonical.of(valueSet));
            }

            /**
             * Replaces all {@code additional} values.
             *
             * @param additional the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder additional(List<Additional> additional) {
                this.additional = additional == null ? new ArrayList<>() : new ArrayList<>(additional);
                return this;
            }

            /**
             * Adds a {@code additional} value.
             *
             * @param additional the value to add
             * @return this builder
             */
            public Builder addAdditional(Additional additional) {
                this.additional.add(Objects.requireNonNull(additional, "additional"));
                return this;
            }

            /**
             * Builds the {@code ElementDefinitionBinding}.
             *
             * @return the {@code ElementDefinitionBinding}
             * @throws NullPointerException if a required element is absent
             */
            public ElementDefinitionBinding build() {
                return new ElementDefinitionBinding(
                        id, extension, strength, description, valueSet, additional);
            }
        }
    }

    /**
     * Identifies a concept from an external specification that roughly corresponds to this element.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param identity Reference to mapping declaration. Required.
     * @param language Computable language of mapping.
     * @param map Details of the mapping. Required.
     * @param comment Comments about the mapping or its use.
     */
    public record Mapping(
            String id,
            List<Extension> extension,
            FhirId identity,
            FhirCode language,
            FhirString map,
            FhirMarkdown comment) implements Element {

        /**
         * Creates a {@code Mapping}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Mapping {
            extension = extension == null ? List.of() : List.copyOf(extension);
            Objects.requireNonNull(identity, "ElementDefinition.mapping.identity is required");
            Objects.requireNonNull(map, "ElementDefinition.mapping.map is required");
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
         * Returns a builder initialized with the values of this {@code Mapping}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Mapping}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private FhirId identity;
            private FhirCode language;
            private FhirString map;
            private FhirMarkdown comment;

            private Builder() {
            }

            private Builder(Mapping original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.identity = original.identity();
                this.language = original.language();
                this.map = original.map();
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
             * Sets {@code identity}.
             *
             * @param identity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identity(FhirId identity) {
                this.identity = identity;
                return this;
            }

            /**
             * Sets {@code identity}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param identity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identity(String identity) {
                return identity(identity == null ? null : FhirId.of(identity));
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
             * Sets {@code map}.
             *
             * @param map the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder map(FhirString map) {
                this.map = map;
                return this;
            }

            /**
             * Sets {@code map}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param map the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder map(String map) {
                return map(map == null ? null : FhirString.of(map));
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
             * Builds the {@code Mapping}.
             *
             * @return the {@code Mapping}
             * @throws NullPointerException if a required element is absent
             */
            public Mapping build() {
                return new Mapping(
                        id, extension, identity, language, map, comment);
            }
        }
    }

    /** Builder for {@link ElementDefinition}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirString path;
        private List<FhirEnum<PropertyRepresentation>> representation = new ArrayList<>();
        private FhirString sliceName;
        private FhirBoolean sliceIsConstraining;
        private FhirString label;
        private List<Coding> code = new ArrayList<>();
        private Slicing slicing;
        private FhirString shortValue;
        private FhirMarkdown definition;
        private FhirMarkdown comment;
        private FhirMarkdown requirements;
        private List<FhirString> alias = new ArrayList<>();
        private FhirUnsignedInt min;
        private FhirString max;
        private Base base;
        private FhirUri contentReference;
        private List<TypeRef> type = new ArrayList<>();
        private DataType defaultValue;
        private FhirMarkdown meaningWhenMissing;
        private FhirString orderMeaning;
        private DataType fixed;
        private DataType pattern;
        private List<Example> example = new ArrayList<>();
        private DataType minValue;
        private DataType maxValue;
        private FhirInteger maxLength;
        private List<FhirId> condition = new ArrayList<>();
        private List<Constraint> constraint = new ArrayList<>();
        private FhirBoolean mustHaveValue;
        private List<FhirCanonical> valueAlternatives = new ArrayList<>();
        private FhirBoolean mustSupport;
        private FhirBoolean isModifier;
        private FhirString isModifierReason;
        private FhirBoolean isSummary;
        private ElementDefinitionBinding binding;
        private List<Mapping> mapping = new ArrayList<>();

        private Builder() {
        }

        private Builder(ElementDefinition original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.path = original.path();
            this.representation = new ArrayList<>(original.representation());
            this.sliceName = original.sliceName();
            this.sliceIsConstraining = original.sliceIsConstraining();
            this.label = original.label();
            this.code = new ArrayList<>(original.code());
            this.slicing = original.slicing();
            this.shortValue = original.shortValue();
            this.definition = original.definition();
            this.comment = original.comment();
            this.requirements = original.requirements();
            this.alias = new ArrayList<>(original.alias());
            this.min = original.min();
            this.max = original.max();
            this.base = original.base();
            this.contentReference = original.contentReference();
            this.type = new ArrayList<>(original.type());
            this.defaultValue = original.defaultValue();
            this.meaningWhenMissing = original.meaningWhenMissing();
            this.orderMeaning = original.orderMeaning();
            this.fixed = original.fixed();
            this.pattern = original.pattern();
            this.example = new ArrayList<>(original.example());
            this.minValue = original.minValue();
            this.maxValue = original.maxValue();
            this.maxLength = original.maxLength();
            this.condition = new ArrayList<>(original.condition());
            this.constraint = new ArrayList<>(original.constraint());
            this.mustHaveValue = original.mustHaveValue();
            this.valueAlternatives = new ArrayList<>(original.valueAlternatives());
            this.mustSupport = original.mustSupport();
            this.isModifier = original.isModifier();
            this.isModifierReason = original.isModifierReason();
            this.isSummary = original.isSummary();
            this.binding = original.binding();
            this.mapping = new ArrayList<>(original.mapping());
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
         * Sets {@code path}.
         *
         * @param path the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder path(FhirString path) {
            this.path = path;
            return this;
        }

        /**
         * Sets {@code path}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param path the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder path(String path) {
            return path(path == null ? null : FhirString.of(path));
        }

        /**
         * Replaces all {@code representation} values.
         *
         * @param representation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder representation(List<FhirEnum<PropertyRepresentation>> representation) {
            this.representation = representation == null ? new ArrayList<>() : new ArrayList<>(representation);
            return this;
        }

        /**
         * Adds a {@code representation} value.
         *
         * @param representation the value to add
         * @return this builder
         */
        public Builder addRepresentation(FhirEnum<PropertyRepresentation> representation) {
            this.representation.add(Objects.requireNonNull(representation, "representation"));
            return this;
        }

        /**
         * Adds a {@code representation} value, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param representation the value to add
         * @return this builder
         */
        public Builder addRepresentation(PropertyRepresentation representation) {
            return addRepresentation(FhirEnum.of(representation));
        }

        /**
         * Sets {@code sliceName}.
         *
         * @param sliceName the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sliceName(FhirString sliceName) {
            this.sliceName = sliceName;
            return this;
        }

        /**
         * Sets {@code sliceName}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param sliceName the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sliceName(String sliceName) {
            return sliceName(sliceName == null ? null : FhirString.of(sliceName));
        }

        /**
         * Sets {@code sliceIsConstraining}.
         *
         * @param sliceIsConstraining the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sliceIsConstraining(FhirBoolean sliceIsConstraining) {
            this.sliceIsConstraining = sliceIsConstraining;
            return this;
        }

        /**
         * Sets {@code sliceIsConstraining}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param sliceIsConstraining the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sliceIsConstraining(Boolean sliceIsConstraining) {
            return sliceIsConstraining(sliceIsConstraining == null ? null : FhirBoolean.of(sliceIsConstraining));
        }

        /**
         * Sets {@code label}.
         *
         * @param label the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder label(FhirString label) {
            this.label = label;
            return this;
        }

        /**
         * Sets {@code label}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param label the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder label(String label) {
            return label(label == null ? null : FhirString.of(label));
        }

        /**
         * Replaces all {@code code} values.
         *
         * @param code the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder code(List<Coding> code) {
            this.code = code == null ? new ArrayList<>() : new ArrayList<>(code);
            return this;
        }

        /**
         * Adds a {@code code} value.
         *
         * @param code the value to add
         * @return this builder
         */
        public Builder addCode(Coding code) {
            this.code.add(Objects.requireNonNull(code, "code"));
            return this;
        }

        /**
         * Sets {@code slicing}.
         *
         * @param slicing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder slicing(Slicing slicing) {
            this.slicing = slicing;
            return this;
        }

        /**
         * Sets {@code shortValue}.
         *
         * @param shortValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder shortValue(FhirString shortValue) {
            this.shortValue = shortValue;
            return this;
        }

        /**
         * Sets {@code shortValue}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param shortValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder shortValue(String shortValue) {
            return shortValue(shortValue == null ? null : FhirString.of(shortValue));
        }

        /**
         * Sets {@code definition}.
         *
         * @param definition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder definition(FhirMarkdown definition) {
            this.definition = definition;
            return this;
        }

        /**
         * Sets {@code definition}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param definition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder definition(String definition) {
            return definition(definition == null ? null : FhirMarkdown.of(definition));
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
         * Sets {@code requirements}.
         *
         * @param requirements the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requirements(FhirMarkdown requirements) {
            this.requirements = requirements;
            return this;
        }

        /**
         * Sets {@code requirements}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param requirements the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requirements(String requirements) {
            return requirements(requirements == null ? null : FhirMarkdown.of(requirements));
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
         * Sets {@code min}.
         *
         * @param min the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder min(FhirUnsignedInt min) {
            this.min = min;
            return this;
        }

        /**
         * Sets {@code min}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
         *
         * @param min the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder min(Integer min) {
            return min(min == null ? null : FhirUnsignedInt.of(min));
        }

        /**
         * Sets {@code max}.
         *
         * @param max the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder max(FhirString max) {
            this.max = max;
            return this;
        }

        /**
         * Sets {@code max}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param max the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder max(String max) {
            return max(max == null ? null : FhirString.of(max));
        }

        /**
         * Sets {@code base}.
         *
         * @param base the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder base(Base base) {
            this.base = base;
            return this;
        }

        /**
         * Sets {@code contentReference}.
         *
         * @param contentReference the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder contentReference(FhirUri contentReference) {
            this.contentReference = contentReference;
            return this;
        }

        /**
         * Sets {@code contentReference}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param contentReference the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder contentReference(String contentReference) {
            return contentReference(contentReference == null ? null : FhirUri.of(contentReference));
        }

        /**
         * Replaces all {@code type} values.
         *
         * @param type the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder type(List<TypeRef> type) {
            this.type = type == null ? new ArrayList<>() : new ArrayList<>(type);
            return this;
        }

        /**
         * Adds a {@code type} value.
         *
         * @param type the value to add
         * @return this builder
         */
        public Builder addType(TypeRef type) {
            this.type.add(Objects.requireNonNull(type, "type"));
            return this;
        }

        /**
         * Sets {@code defaultValue}.
         *
         * @param defaultValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder defaultValue(DataType defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        /**
         * Sets {@code meaningWhenMissing}.
         *
         * @param meaningWhenMissing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder meaningWhenMissing(FhirMarkdown meaningWhenMissing) {
            this.meaningWhenMissing = meaningWhenMissing;
            return this;
        }

        /**
         * Sets {@code meaningWhenMissing}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param meaningWhenMissing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder meaningWhenMissing(String meaningWhenMissing) {
            return meaningWhenMissing(meaningWhenMissing == null ? null : FhirMarkdown.of(meaningWhenMissing));
        }

        /**
         * Sets {@code orderMeaning}.
         *
         * @param orderMeaning the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder orderMeaning(FhirString orderMeaning) {
            this.orderMeaning = orderMeaning;
            return this;
        }

        /**
         * Sets {@code orderMeaning}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param orderMeaning the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder orderMeaning(String orderMeaning) {
            return orderMeaning(orderMeaning == null ? null : FhirString.of(orderMeaning));
        }

        /**
         * Sets {@code fixed}.
         *
         * @param fixed the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder fixed(DataType fixed) {
            this.fixed = fixed;
            return this;
        }

        /**
         * Sets {@code pattern}.
         *
         * @param pattern the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder pattern(DataType pattern) {
            this.pattern = pattern;
            return this;
        }

        /**
         * Replaces all {@code example} values.
         *
         * @param example the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder example(List<Example> example) {
            this.example = example == null ? new ArrayList<>() : new ArrayList<>(example);
            return this;
        }

        /**
         * Adds a {@code example} value.
         *
         * @param example the value to add
         * @return this builder
         */
        public Builder addExample(Example example) {
            this.example.add(Objects.requireNonNull(example, "example"));
            return this;
        }

        /**
         * Sets {@code minValue} to a date.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(FhirDate minValue) {
            this.minValue = minValue;
            return this;
        }

        /**
         * Sets {@code minValue} to a dateTime.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(FhirDateTime minValue) {
            this.minValue = minValue;
            return this;
        }

        /**
         * Sets {@code minValue} to a instant.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(FhirInstant minValue) {
            this.minValue = minValue;
            return this;
        }

        /**
         * Sets {@code minValue} to a time.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(FhirTime minValue) {
            this.minValue = minValue;
            return this;
        }

        /**
         * Sets {@code minValue} to a decimal.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(FhirDecimal minValue) {
            this.minValue = minValue;
            return this;
        }

        /**
         * Sets {@code minValue} to a integer.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(FhirInteger minValue) {
            this.minValue = minValue;
            return this;
        }

        /**
         * Sets {@code minValue} to a integer64.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(FhirInteger64 minValue) {
            this.minValue = minValue;
            return this;
        }

        /**
         * Sets {@code minValue} to a positiveInt.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(FhirPositiveInt minValue) {
            this.minValue = minValue;
            return this;
        }

        /**
         * Sets {@code minValue} to a unsignedInt.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(FhirUnsignedInt minValue) {
            this.minValue = minValue;
            return this;
        }

        /**
         * Sets {@code minValue} to a Quantity.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(Quantity minValue) {
            this.minValue = minValue;
            return this;
        }

        /**
         * Sets {@code minValue} to a instant without id or extensions.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(OffsetDateTime minValue) {
            this.minValue = minValue == null ? null : FhirInstant.of(minValue);
            return this;
        }

        /**
         * Sets {@code minValue} to a time without id or extensions.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(LocalTime minValue) {
            this.minValue = minValue == null ? null : FhirTime.of(minValue);
            return this;
        }

        /**
         * Sets {@code minValue} to a decimal without id or extensions.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(BigDecimal minValue) {
            this.minValue = minValue == null ? null : FhirDecimal.of(minValue);
            return this;
        }

        /**
         * Sets {@code minValue} to a integer64 without id or extensions.
         *
         * @param minValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder minValue(Long minValue) {
            this.minValue = minValue == null ? null : FhirInteger64.of(minValue);
            return this;
        }

        /**
         * Sets {@code maxValue} to a date.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(FhirDate maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        /**
         * Sets {@code maxValue} to a dateTime.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(FhirDateTime maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        /**
         * Sets {@code maxValue} to a instant.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(FhirInstant maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        /**
         * Sets {@code maxValue} to a time.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(FhirTime maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        /**
         * Sets {@code maxValue} to a decimal.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(FhirDecimal maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        /**
         * Sets {@code maxValue} to a integer.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(FhirInteger maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        /**
         * Sets {@code maxValue} to a integer64.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(FhirInteger64 maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        /**
         * Sets {@code maxValue} to a positiveInt.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(FhirPositiveInt maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        /**
         * Sets {@code maxValue} to a unsignedInt.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(FhirUnsignedInt maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        /**
         * Sets {@code maxValue} to a Quantity.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(Quantity maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        /**
         * Sets {@code maxValue} to a instant without id or extensions.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(OffsetDateTime maxValue) {
            this.maxValue = maxValue == null ? null : FhirInstant.of(maxValue);
            return this;
        }

        /**
         * Sets {@code maxValue} to a time without id or extensions.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(LocalTime maxValue) {
            this.maxValue = maxValue == null ? null : FhirTime.of(maxValue);
            return this;
        }

        /**
         * Sets {@code maxValue} to a decimal without id or extensions.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(BigDecimal maxValue) {
            this.maxValue = maxValue == null ? null : FhirDecimal.of(maxValue);
            return this;
        }

        /**
         * Sets {@code maxValue} to a integer64 without id or extensions.
         *
         * @param maxValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxValue(Long maxValue) {
            this.maxValue = maxValue == null ? null : FhirInteger64.of(maxValue);
            return this;
        }

        /**
         * Sets {@code maxLength}.
         *
         * @param maxLength the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxLength(FhirInteger maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        /**
         * Sets {@code maxLength}, wrapped in a {@link FhirInteger} without id or extensions.
         *
         * @param maxLength the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxLength(Integer maxLength) {
            return maxLength(maxLength == null ? null : FhirInteger.of(maxLength));
        }

        /**
         * Replaces all {@code condition} values.
         *
         * @param condition the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder condition(List<FhirId> condition) {
            this.condition = condition == null ? new ArrayList<>() : new ArrayList<>(condition);
            return this;
        }

        /**
         * Adds a {@code condition} value.
         *
         * @param condition the value to add
         * @return this builder
         */
        public Builder addCondition(FhirId condition) {
            this.condition.add(Objects.requireNonNull(condition, "condition"));
            return this;
        }

        /**
         * Adds a {@code condition} value, wrapped in a {@link FhirId} without id or extensions.
         *
         * @param condition the value to add
         * @return this builder
         */
        public Builder addCondition(String condition) {
            return addCondition(FhirId.of(condition));
        }

        /**
         * Replaces all {@code constraint} values.
         *
         * @param constraint the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder constraint(List<Constraint> constraint) {
            this.constraint = constraint == null ? new ArrayList<>() : new ArrayList<>(constraint);
            return this;
        }

        /**
         * Adds a {@code constraint} value.
         *
         * @param constraint the value to add
         * @return this builder
         */
        public Builder addConstraint(Constraint constraint) {
            this.constraint.add(Objects.requireNonNull(constraint, "constraint"));
            return this;
        }

        /**
         * Sets {@code mustHaveValue}.
         *
         * @param mustHaveValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder mustHaveValue(FhirBoolean mustHaveValue) {
            this.mustHaveValue = mustHaveValue;
            return this;
        }

        /**
         * Sets {@code mustHaveValue}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param mustHaveValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder mustHaveValue(Boolean mustHaveValue) {
            return mustHaveValue(mustHaveValue == null ? null : FhirBoolean.of(mustHaveValue));
        }

        /**
         * Replaces all {@code valueAlternatives} values.
         *
         * @param valueAlternatives the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder valueAlternatives(List<FhirCanonical> valueAlternatives) {
            this.valueAlternatives = valueAlternatives == null
                    ? new ArrayList<>()
                    : new ArrayList<>(valueAlternatives);
            return this;
        }

        /**
         * Adds a {@code valueAlternatives} value.
         *
         * @param valueAlternatives the value to add
         * @return this builder
         */
        public Builder addValueAlternatives(FhirCanonical valueAlternatives) {
            this.valueAlternatives.add(Objects.requireNonNull(valueAlternatives, "valueAlternatives"));
            return this;
        }

        /**
         * Adds a {@code valueAlternatives} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param valueAlternatives the value to add
         * @return this builder
         */
        public Builder addValueAlternatives(String valueAlternatives) {
            return addValueAlternatives(FhirCanonical.of(valueAlternatives));
        }

        /**
         * Sets {@code mustSupport}.
         *
         * @param mustSupport the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder mustSupport(FhirBoolean mustSupport) {
            this.mustSupport = mustSupport;
            return this;
        }

        /**
         * Sets {@code mustSupport}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param mustSupport the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder mustSupport(Boolean mustSupport) {
            return mustSupport(mustSupport == null ? null : FhirBoolean.of(mustSupport));
        }

        /**
         * Sets {@code isModifier}.
         *
         * @param isModifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder isModifier(FhirBoolean isModifier) {
            this.isModifier = isModifier;
            return this;
        }

        /**
         * Sets {@code isModifier}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param isModifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder isModifier(Boolean isModifier) {
            return isModifier(isModifier == null ? null : FhirBoolean.of(isModifier));
        }

        /**
         * Sets {@code isModifierReason}.
         *
         * @param isModifierReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder isModifierReason(FhirString isModifierReason) {
            this.isModifierReason = isModifierReason;
            return this;
        }

        /**
         * Sets {@code isModifierReason}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param isModifierReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder isModifierReason(String isModifierReason) {
            return isModifierReason(isModifierReason == null ? null : FhirString.of(isModifierReason));
        }

        /**
         * Sets {@code isSummary}.
         *
         * @param isSummary the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder isSummary(FhirBoolean isSummary) {
            this.isSummary = isSummary;
            return this;
        }

        /**
         * Sets {@code isSummary}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param isSummary the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder isSummary(Boolean isSummary) {
            return isSummary(isSummary == null ? null : FhirBoolean.of(isSummary));
        }

        /**
         * Sets {@code binding}.
         *
         * @param binding the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder binding(ElementDefinitionBinding binding) {
            this.binding = binding;
            return this;
        }

        /**
         * Replaces all {@code mapping} values.
         *
         * @param mapping the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder mapping(List<Mapping> mapping) {
            this.mapping = mapping == null ? new ArrayList<>() : new ArrayList<>(mapping);
            return this;
        }

        /**
         * Adds a {@code mapping} value.
         *
         * @param mapping the value to add
         * @return this builder
         */
        public Builder addMapping(Mapping mapping) {
            this.mapping.add(Objects.requireNonNull(mapping, "mapping"));
            return this;
        }

        /**
         * Builds the {@code ElementDefinition}.
         *
         * @return the {@code ElementDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public ElementDefinition build() {
            return new ElementDefinition(
                    id, extension, modifierExtension, path, representation, sliceName, sliceIsConstraining, label,
                    code, slicing, shortValue, definition, comment, requirements, alias, min, max, base,
                    contentReference, type, defaultValue, meaningWhenMissing, orderMeaning, fixed, pattern, example,
                    minValue, maxValue, maxLength, condition, constraint, mustHaveValue, valueAlternatives,
                    mustSupport, isModifier, isModifierReason, isSummary, binding, mapping);
        }
    }
}
