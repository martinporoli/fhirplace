package se.poroli.fhirplace.r5.structuremap;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirTime;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A Map of relationships between 2 structures that can be used to transform data.
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
 * @param url Canonical identifier for this structure map, represented as a URI (globally unique). Required.
 * @param identifier Additional identifier for the structure map.
 * @param version Business version of the structure map.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this structure map (computer friendly). Required.
 * @param title Name for this structure map (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the structure map.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for structure map (if applicable).
 * @param purpose Why this structure map is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param structure Structure Definition used by this map.
 * @param importValue Other maps used by this map (canonical URLs). Canonical reference to StructureMap. The FHIR
 *   element {@code import}.
 * @param constValue Definition of the constant value used in the map rules. The FHIR element {@code const}.
 * @param group Named sections for reader convenience. Required.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/StructureMap">FHIR R5 StructureMap</a>
 */
public record StructureMap(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirUri url,
        List<Identifier> identifier,
        FhirString version,
        DataType versionAlgorithm,
        FhirString name,
        FhirString title,
        FhirEnum<PublicationStatus> status,
        FhirBoolean experimental,
        FhirDateTime date,
        FhirString publisher,
        List<ContactDetail> contact,
        FhirMarkdown description,
        List<UsageContext> useContext,
        List<CodeableConcept> jurisdiction,
        FhirMarkdown purpose,
        FhirMarkdown copyright,
        FhirString copyrightLabel,
        List<Structure> structure,
        List<FhirCanonical> importValue,
        List<ConstValue> constValue,
        List<Group> group) implements DomainResource {

    /**
     * Creates a {@code StructureMap}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public StructureMap {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        structure = structure == null ? List.of() : List.copyOf(structure);
        importValue = importValue == null ? List.of() : List.copyOf(importValue);
        constValue = constValue == null ? List.of() : List.copyOf(constValue);
        group = group == null ? List.of() : List.copyOf(group);
        Objects.requireNonNull(url, "StructureMap.url is required");
        Objects.requireNonNull(name, "StructureMap.name is required");
        Objects.requireNonNull(status, "StructureMap.status is required");
        if (group.isEmpty()) {
            throw new IllegalArgumentException("StructureMap.group requires at least one value");
        }
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "StructureMap.versionAlgorithm[x] must be one of string, Coding, but was "
                            + versionAlgorithm.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code StructureMap}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A structure definition used by this map.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param url Canonical reference to structure definition. Canonical reference to StructureDefinition. Required.
     * @param mode source | queried | target | produced. Required.
     * @param alias Name for type in this map.
     * @param documentation Documentation on use of structure.
     */
    public record Structure(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCanonical url,
            FhirEnum<StructureMapModelMode> mode,
            FhirString alias,
            FhirString documentation) implements BackboneElement {

        /**
         * Creates a {@code Structure}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Structure {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(url, "StructureMap.structure.url is required");
            Objects.requireNonNull(mode, "StructureMap.structure.mode is required");
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
         * Returns a builder initialized with the values of this {@code Structure}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Structure}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCanonical url;
            private FhirEnum<StructureMapModelMode> mode;
            private FhirString alias;
            private FhirString documentation;

            private Builder() {
            }

            private Builder(Structure original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.url = original.url();
                this.mode = original.mode();
                this.alias = original.alias();
                this.documentation = original.documentation();
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
             * Sets {@code url}.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(FhirCanonical url) {
                this.url = url;
                return this;
            }

            /**
             * Sets {@code url}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(String url) {
                return url(url == null ? null : FhirCanonical.of(url));
            }

            /**
             * Sets {@code mode}.
             *
             * @param mode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder mode(FhirEnum<StructureMapModelMode> mode) {
                this.mode = mode;
                return this;
            }

            /**
             * Sets {@code mode}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param mode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder mode(StructureMapModelMode mode) {
                return mode(mode == null ? null : FhirEnum.of(mode));
            }

            /**
             * Sets {@code alias}.
             *
             * @param alias the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder alias(FhirString alias) {
                this.alias = alias;
                return this;
            }

            /**
             * Sets {@code alias}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param alias the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder alias(String alias) {
                return alias(alias == null ? null : FhirString.of(alias));
            }

            /**
             * Sets {@code documentation}.
             *
             * @param documentation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder documentation(FhirString documentation) {
                this.documentation = documentation;
                return this;
            }

            /**
             * Sets {@code documentation}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param documentation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder documentation(String documentation) {
                return documentation(documentation == null ? null : FhirString.of(documentation));
            }

            /**
             * Builds the {@code Structure}.
             *
             * @return the {@code Structure}
             * @throws NullPointerException if a required element is absent
             */
            public Structure build() {
                return new Structure(
                        id, extension, modifierExtension, url, mode, alias, documentation);
            }
        }
    }

    /**
     * Definition of a constant value used in the map rules.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Constant name.
     * @param value FHIRPath exression - value of the constant.
     */
    public record ConstValue(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirId name,
            FhirString value) implements BackboneElement {

        /**
         * Creates a {@code ConstValue}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public ConstValue {
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
         * Returns a builder initialized with the values of this {@code ConstValue}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ConstValue}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirId name;
            private FhirString value;

            private Builder() {
            }

            private Builder(ConstValue original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
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
             * Sets {@code name}.
             *
             * @param name the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder name(FhirId name) {
                this.name = name;
                return this;
            }

            /**
             * Sets {@code name}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param name the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder name(String name) {
                return name(name == null ? null : FhirId.of(name));
            }

            /**
             * Sets {@code value}.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirString value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(String value) {
                return value(value == null ? null : FhirString.of(value));
            }

            /**
             * Builds the {@code ConstValue}.
             *
             * @return the {@code ConstValue}
             */
            public ConstValue build() {
                return new ConstValue(
                        id, extension, modifierExtension, name, value);
            }
        }
    }

    /**
     * Organizes the mapping into managable chunks for human review/ease of maintenance.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Human-readable label. Required.
     * @param extendsValue Another group that this group adds rules to. The FHIR element {@code extends}.
     * @param typeMode types | type-and-types.
     * @param documentation Additional description/explanation for group.
     * @param input Named instance provided when invoking the map. Required.
     * @param rule Transform Rule from source to target.
     */
    public record Group(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirId name,
            FhirId extendsValue,
            FhirEnum<StructureMapGroupTypeMode> typeMode,
            FhirString documentation,
            List<Input> input,
            List<Rule> rule) implements BackboneElement {

        /**
         * Creates a {@code Group}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Group {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            input = input == null ? List.of() : List.copyOf(input);
            rule = rule == null ? List.of() : List.copyOf(rule);
            Objects.requireNonNull(name, "StructureMap.group.name is required");
            if (input.isEmpty()) {
                throw new IllegalArgumentException("StructureMap.group.input requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Group}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A name assigned to an instance of data.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param name Name for this instance of data. Required.
         * @param type Type for this instance of data.
         * @param mode source | target. Required.
         * @param documentation Documentation for this instance of data.
         */
        public record Input(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirId name,
                FhirString type,
                FhirEnum<StructureMapInputMode> mode,
                FhirString documentation) implements BackboneElement {

            /**
             * Creates an {@code Input}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Input {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(name, "StructureMap.group.input.name is required");
                Objects.requireNonNull(mode, "StructureMap.group.input.mode is required");
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
             * Returns a builder initialized with the values of this {@code Input}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Input}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirId name;
                private FhirString type;
                private FhirEnum<StructureMapInputMode> mode;
                private FhirString documentation;

                private Builder() {
                }

                private Builder(Input original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.name = original.name();
                    this.type = original.type();
                    this.mode = original.mode();
                    this.documentation = original.documentation();
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
                 * Sets {@code name}.
                 *
                 * @param name the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder name(FhirId name) {
                    this.name = name;
                    return this;
                }

                /**
                 * Sets {@code name}, wrapped in a {@link FhirId} without id or extensions.
                 *
                 * @param name the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder name(String name) {
                    return name(name == null ? null : FhirId.of(name));
                }

                /**
                 * Sets {@code type}.
                 *
                 * @param type the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder type(FhirString type) {
                    this.type = type;
                    return this;
                }

                /**
                 * Sets {@code type}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param type the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder type(String type) {
                    return type(type == null ? null : FhirString.of(type));
                }

                /**
                 * Sets {@code mode}.
                 *
                 * @param mode the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder mode(FhirEnum<StructureMapInputMode> mode) {
                    this.mode = mode;
                    return this;
                }

                /**
                 * Sets {@code mode}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param mode the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder mode(StructureMapInputMode mode) {
                    return mode(mode == null ? null : FhirEnum.of(mode));
                }

                /**
                 * Sets {@code documentation}.
                 *
                 * @param documentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder documentation(FhirString documentation) {
                    this.documentation = documentation;
                    return this;
                }

                /**
                 * Sets {@code documentation}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param documentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder documentation(String documentation) {
                    return documentation(documentation == null ? null : FhirString.of(documentation));
                }

                /**
                 * Builds the {@code Input}.
                 *
                 * @return the {@code Input}
                 * @throws NullPointerException if a required element is absent
                 */
                public Input build() {
                    return new Input(
                            id, extension, modifierExtension, name, type, mode, documentation);
                }
            }
        }

        /**
         * Transform Rule from source to target.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param name Name of the rule for internal references.
         * @param source Source inputs to the mapping. Required.
         * @param target Content to create because of this mapping rule.
         * @param rule Rules contained in this rule.
         * @param dependent Which other rules to apply in the context of this rule.
         * @param documentation Documentation for this instance of data.
         */
        public record Rule(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirId name,
                List<Source> source,
                List<Target> target,
                List<StructureMap.Group.Rule> rule,
                List<Dependent> dependent,
                FhirString documentation) implements BackboneElement {

            /**
             * Creates a {@code Rule}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a required list is empty
             */
            public Rule {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                source = source == null ? List.of() : List.copyOf(source);
                target = target == null ? List.of() : List.copyOf(target);
                rule = rule == null ? List.of() : List.copyOf(rule);
                dependent = dependent == null ? List.of() : List.copyOf(dependent);
                if (source.isEmpty()) {
                    throw new IllegalArgumentException("StructureMap.group.rule.source requires at least one value");
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
             * Returns a builder initialized with the values of this {@code Rule}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Source inputs to the mapping.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param context Type or variable this rule applies to. Required.
             * @param min Specified minimum cardinality.
             * @param max Specified maximum cardinality (number or *).
             * @param type Rule only applies if source has this type.
             * @param defaultValue Default value if no value exists.
             * @param element Optional field for this source.
             * @param listMode first | not_first | last | not_last | only_one.
             * @param variable Named context for field, if a field is specified.
             * @param condition FHIRPath expression - must be true or the rule does not apply.
             * @param check FHIRPath expression - must be true or the mapping engine throws an error instead of
             *   completing.
             * @param logMessage Message to put in log if source exists (FHIRPath).
             */
            public record Source(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirId context,
                    FhirInteger min,
                    FhirString max,
                    FhirString type,
                    FhirString defaultValue,
                    FhirString element,
                    FhirEnum<StructureMapSourceListMode> listMode,
                    FhirId variable,
                    FhirString condition,
                    FhirString check,
                    FhirString logMessage) implements BackboneElement {

                /**
                 * Creates a {@code Source}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public Source {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(context, "StructureMap.group.rule.source.context is required");
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
                 * Returns a builder initialized with the values of this {@code Source}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Source}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirId context;
                    private FhirInteger min;
                    private FhirString max;
                    private FhirString type;
                    private FhirString defaultValue;
                    private FhirString element;
                    private FhirEnum<StructureMapSourceListMode> listMode;
                    private FhirId variable;
                    private FhirString condition;
                    private FhirString check;
                    private FhirString logMessage;

                    private Builder() {
                    }

                    private Builder(Source original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.context = original.context();
                        this.min = original.min();
                        this.max = original.max();
                        this.type = original.type();
                        this.defaultValue = original.defaultValue();
                        this.element = original.element();
                        this.listMode = original.listMode();
                        this.variable = original.variable();
                        this.condition = original.condition();
                        this.check = original.check();
                        this.logMessage = original.logMessage();
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
                     * Sets {@code context}.
                     *
                     * @param context the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder context(FhirId context) {
                        this.context = context;
                        return this;
                    }

                    /**
                     * Sets {@code context}, wrapped in a {@link FhirId} without id or extensions.
                     *
                     * @param context the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder context(String context) {
                        return context(context == null ? null : FhirId.of(context));
                    }

                    /**
                     * Sets {@code min}.
                     *
                     * @param min the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder min(FhirInteger min) {
                        this.min = min;
                        return this;
                    }

                    /**
                     * Sets {@code min}, wrapped in a {@link FhirInteger} without id or extensions.
                     *
                     * @param min the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder min(Integer min) {
                        return min(min == null ? null : FhirInteger.of(min));
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
                     * Sets {@code type}.
                     *
                     * @param type the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder type(FhirString type) {
                        this.type = type;
                        return this;
                    }

                    /**
                     * Sets {@code type}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param type the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder type(String type) {
                        return type(type == null ? null : FhirString.of(type));
                    }

                    /**
                     * Sets {@code defaultValue}.
                     *
                     * @param defaultValue the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder defaultValue(FhirString defaultValue) {
                        this.defaultValue = defaultValue;
                        return this;
                    }

                    /**
                     * Sets {@code defaultValue}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param defaultValue the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder defaultValue(String defaultValue) {
                        return defaultValue(defaultValue == null ? null : FhirString.of(defaultValue));
                    }

                    /**
                     * Sets {@code element}.
                     *
                     * @param element the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder element(FhirString element) {
                        this.element = element;
                        return this;
                    }

                    /**
                     * Sets {@code element}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param element the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder element(String element) {
                        return element(element == null ? null : FhirString.of(element));
                    }

                    /**
                     * Sets {@code listMode}.
                     *
                     * @param listMode the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder listMode(FhirEnum<StructureMapSourceListMode> listMode) {
                        this.listMode = listMode;
                        return this;
                    }

                    /**
                     * Sets {@code listMode}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param listMode the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder listMode(StructureMapSourceListMode listMode) {
                        return listMode(listMode == null ? null : FhirEnum.of(listMode));
                    }

                    /**
                     * Sets {@code variable}.
                     *
                     * @param variable the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder variable(FhirId variable) {
                        this.variable = variable;
                        return this;
                    }

                    /**
                     * Sets {@code variable}, wrapped in a {@link FhirId} without id or extensions.
                     *
                     * @param variable the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder variable(String variable) {
                        return variable(variable == null ? null : FhirId.of(variable));
                    }

                    /**
                     * Sets {@code condition}.
                     *
                     * @param condition the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder condition(FhirString condition) {
                        this.condition = condition;
                        return this;
                    }

                    /**
                     * Sets {@code condition}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param condition the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder condition(String condition) {
                        return condition(condition == null ? null : FhirString.of(condition));
                    }

                    /**
                     * Sets {@code check}.
                     *
                     * @param check the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder check(FhirString check) {
                        this.check = check;
                        return this;
                    }

                    /**
                     * Sets {@code check}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param check the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder check(String check) {
                        return check(check == null ? null : FhirString.of(check));
                    }

                    /**
                     * Sets {@code logMessage}.
                     *
                     * @param logMessage the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder logMessage(FhirString logMessage) {
                        this.logMessage = logMessage;
                        return this;
                    }

                    /**
                     * Sets {@code logMessage}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param logMessage the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder logMessage(String logMessage) {
                        return logMessage(logMessage == null ? null : FhirString.of(logMessage));
                    }

                    /**
                     * Builds the {@code Source}.
                     *
                     * @return the {@code Source}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Source build() {
                        return new Source(
                                id, extension, modifierExtension, context, min, max, type, defaultValue, element,
                                listMode, variable, condition, check, logMessage);
                    }
                }
            }

            /**
             * Content to create because of this mapping rule.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param context Variable this rule applies to.
             * @param element Field to create in the context.
             * @param variable Named context for field, if desired, and a field is specified.
             * @param listMode first | share | last | single.
             * @param listRuleId Internal rule reference for shared list items.
             * @param transform create | copy +.
             * @param parameter Parameters to the transform.
             */
            public record Target(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirString context,
                    FhirString element,
                    FhirId variable,
                    List<FhirEnum<StructureMapTargetListMode>> listMode,
                    FhirId listRuleId,
                    FhirEnum<StructureMapTransform> transform,
                    List<Parameter> parameter) implements BackboneElement {

                /**
                 * Creates a {@code Target}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 */
                public Target {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    listMode = listMode == null ? List.of() : List.copyOf(listMode);
                    parameter = parameter == null ? List.of() : List.copyOf(parameter);
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
                 * Returns a builder initialized with the values of this {@code Target}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /**
                 * Parameters to the transform.
                 *
                 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
                 * Instances are usually created with {@link #builder()}.
                 *
                 * @param id Unique id for inter-element referencing.
                 * @param extension Additional content defined by implementations.
                 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
                 * @param value Parameter value - variable or literal. One of id, string, boolean, integer, decimal,
                 *   date, time, dateTime. Required.
                 */
                public record Parameter(
                        String id,
                        List<Extension> extension,
                        List<Extension> modifierExtension,
                        DataType value) implements BackboneElement {

                    /**
                     * Creates a {@code Parameter}, copying all lists.
                     *
                     * @throws NullPointerException if a required element is absent or a list contains {@code null}
                     * @throws IllegalArgumentException if a choice element has a type that is not allowed
                     */
                    public Parameter {
                        extension = extension == null ? List.of() : List.copyOf(extension);
                        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                        Objects.requireNonNull(value, "StructureMap.group.rule.target.parameter.value is required");
                        if (value != null && !(value instanceof FhirId
                                || value instanceof FhirString
                                || value instanceof FhirBoolean
                                || value instanceof FhirInteger
                                || value instanceof FhirDecimal
                                || value instanceof FhirDate
                                || value instanceof FhirTime
                                || value instanceof FhirDateTime)) {
                            throw new IllegalArgumentException(
                                    "StructureMap.group.rule.target.parameter.value[x] does not allow "
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
                        private DataType value;

                        private Builder() {
                        }

                        private Builder(Parameter original) {
                            this.id = original.id();
                            this.extension = new ArrayList<>(original.extension());
                            this.modifierExtension = new ArrayList<>(original.modifierExtension());
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
                         * Sets {@code value} to a id.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirId value) {
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
                         * Sets {@code value} to a decimal.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirDecimal value) {
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
                         * Sets {@code value} to a time.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirTime value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a dateTime.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirDateTime value) {
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
                         * Sets {@code value} to a decimal without id or extensions.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(BigDecimal value) {
                            this.value = value == null ? null : FhirDecimal.of(value);
                            return this;
                        }

                        /**
                         * Sets {@code value} to a time without id or extensions.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(LocalTime value) {
                            this.value = value == null ? null : FhirTime.of(value);
                            return this;
                        }

                        /**
                         * Builds the {@code Parameter}.
                         *
                         * @return the {@code Parameter}
                         * @throws NullPointerException if a required element is absent
                         */
                        public Parameter build() {
                            return new Parameter(
                                    id, extension, modifierExtension, value);
                        }
                    }
                }

                /** Builder for {@link Target}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirString context;
                    private FhirString element;
                    private FhirId variable;
                    private List<FhirEnum<StructureMapTargetListMode>> listMode = new ArrayList<>();
                    private FhirId listRuleId;
                    private FhirEnum<StructureMapTransform> transform;
                    private List<Parameter> parameter = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(Target original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.context = original.context();
                        this.element = original.element();
                        this.variable = original.variable();
                        this.listMode = new ArrayList<>(original.listMode());
                        this.listRuleId = original.listRuleId();
                        this.transform = original.transform();
                        this.parameter = new ArrayList<>(original.parameter());
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
                     * Sets {@code context}.
                     *
                     * @param context the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder context(FhirString context) {
                        this.context = context;
                        return this;
                    }

                    /**
                     * Sets {@code context}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param context the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder context(String context) {
                        return context(context == null ? null : FhirString.of(context));
                    }

                    /**
                     * Sets {@code element}.
                     *
                     * @param element the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder element(FhirString element) {
                        this.element = element;
                        return this;
                    }

                    /**
                     * Sets {@code element}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param element the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder element(String element) {
                        return element(element == null ? null : FhirString.of(element));
                    }

                    /**
                     * Sets {@code variable}.
                     *
                     * @param variable the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder variable(FhirId variable) {
                        this.variable = variable;
                        return this;
                    }

                    /**
                     * Sets {@code variable}, wrapped in a {@link FhirId} without id or extensions.
                     *
                     * @param variable the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder variable(String variable) {
                        return variable(variable == null ? null : FhirId.of(variable));
                    }

                    /**
                     * Replaces all {@code listMode} values.
                     *
                     * @param listMode the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder listMode(List<FhirEnum<StructureMapTargetListMode>> listMode) {
                        this.listMode = listMode == null ? new ArrayList<>() : new ArrayList<>(listMode);
                        return this;
                    }

                    /**
                     * Adds a {@code listMode} value.
                     *
                     * @param listMode the value to add
                     * @return this builder
                     */
                    public Builder addListMode(FhirEnum<StructureMapTargetListMode> listMode) {
                        this.listMode.add(Objects.requireNonNull(listMode, "listMode"));
                        return this;
                    }

                    /**
                     * Adds a {@code listMode} value, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param listMode the value to add
                     * @return this builder
                     */
                    public Builder addListMode(StructureMapTargetListMode listMode) {
                        return addListMode(FhirEnum.of(listMode));
                    }

                    /**
                     * Sets {@code listRuleId}.
                     *
                     * @param listRuleId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder listRuleId(FhirId listRuleId) {
                        this.listRuleId = listRuleId;
                        return this;
                    }

                    /**
                     * Sets {@code listRuleId}, wrapped in a {@link FhirId} without id or extensions.
                     *
                     * @param listRuleId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder listRuleId(String listRuleId) {
                        return listRuleId(listRuleId == null ? null : FhirId.of(listRuleId));
                    }

                    /**
                     * Sets {@code transform}.
                     *
                     * @param transform the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder transform(FhirEnum<StructureMapTransform> transform) {
                        this.transform = transform;
                        return this;
                    }

                    /**
                     * Sets {@code transform}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param transform the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder transform(StructureMapTransform transform) {
                        return transform(transform == null ? null : FhirEnum.of(transform));
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
                     * Builds the {@code Target}.
                     *
                     * @return the {@code Target}
                     */
                    public Target build() {
                        return new Target(
                                id, extension, modifierExtension, context, element, variable, listMode, listRuleId,
                                transform, parameter);
                    }
                }
            }

            /**
             * Which other rules to apply in the context of this rule.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param name Name of a rule or group to apply. Required.
             * @param parameter Parameter to pass to the rule or group. Required.
             */
            public record Dependent(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirId name,
                    List<StructureMap.Group.Rule.Target.Parameter> parameter) implements BackboneElement {

                /**
                 * Creates a {@code Dependent}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public Dependent {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    parameter = parameter == null ? List.of() : List.copyOf(parameter);
                    Objects.requireNonNull(name, "StructureMap.group.rule.dependent.name is required");
                    if (parameter.isEmpty()) {
                        throw new IllegalArgumentException(
                                "StructureMap.group.rule.dependent.parameter requires at least one value");
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
                 * Returns a builder initialized with the values of this {@code Dependent}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Dependent}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirId name;
                    private List<StructureMap.Group.Rule.Target.Parameter> parameter = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(Dependent original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.name = original.name();
                        this.parameter = new ArrayList<>(original.parameter());
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
                     * Sets {@code name}.
                     *
                     * @param name the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder name(FhirId name) {
                        this.name = name;
                        return this;
                    }

                    /**
                     * Sets {@code name}, wrapped in a {@link FhirId} without id or extensions.
                     *
                     * @param name the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder name(String name) {
                        return name(name == null ? null : FhirId.of(name));
                    }

                    /**
                     * Replaces all {@code parameter} values.
                     *
                     * @param parameter the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder parameter(List<StructureMap.Group.Rule.Target.Parameter> parameter) {
                        this.parameter = parameter == null ? new ArrayList<>() : new ArrayList<>(parameter);
                        return this;
                    }

                    /**
                     * Adds a {@code parameter} value.
                     *
                     * @param parameter the value to add
                     * @return this builder
                     */
                    public Builder addParameter(StructureMap.Group.Rule.Target.Parameter parameter) {
                        this.parameter.add(Objects.requireNonNull(parameter, "parameter"));
                        return this;
                    }

                    /**
                     * Builds the {@code Dependent}.
                     *
                     * @return the {@code Dependent}
                     * @throws NullPointerException if a required element is absent
                     * @throws IllegalArgumentException if a required list is empty
                     */
                    public Dependent build() {
                        return new Dependent(
                                id, extension, modifierExtension, name, parameter);
                    }
                }
            }

            /** Builder for {@link Rule}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirId name;
                private List<Source> source = new ArrayList<>();
                private List<Target> target = new ArrayList<>();
                private List<StructureMap.Group.Rule> rule = new ArrayList<>();
                private List<Dependent> dependent = new ArrayList<>();
                private FhirString documentation;

                private Builder() {
                }

                private Builder(Rule original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.name = original.name();
                    this.source = new ArrayList<>(original.source());
                    this.target = new ArrayList<>(original.target());
                    this.rule = new ArrayList<>(original.rule());
                    this.dependent = new ArrayList<>(original.dependent());
                    this.documentation = original.documentation();
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
                 * Sets {@code name}.
                 *
                 * @param name the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder name(FhirId name) {
                    this.name = name;
                    return this;
                }

                /**
                 * Sets {@code name}, wrapped in a {@link FhirId} without id or extensions.
                 *
                 * @param name the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder name(String name) {
                    return name(name == null ? null : FhirId.of(name));
                }

                /**
                 * Replaces all {@code source} values.
                 *
                 * @param source the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder source(List<Source> source) {
                    this.source = source == null ? new ArrayList<>() : new ArrayList<>(source);
                    return this;
                }

                /**
                 * Adds a {@code source} value.
                 *
                 * @param source the value to add
                 * @return this builder
                 */
                public Builder addSource(Source source) {
                    this.source.add(Objects.requireNonNull(source, "source"));
                    return this;
                }

                /**
                 * Replaces all {@code target} values.
                 *
                 * @param target the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder target(List<Target> target) {
                    this.target = target == null ? new ArrayList<>() : new ArrayList<>(target);
                    return this;
                }

                /**
                 * Adds a {@code target} value.
                 *
                 * @param target the value to add
                 * @return this builder
                 */
                public Builder addTarget(Target target) {
                    this.target.add(Objects.requireNonNull(target, "target"));
                    return this;
                }

                /**
                 * Replaces all {@code rule} values.
                 *
                 * @param rule the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder rule(List<StructureMap.Group.Rule> rule) {
                    this.rule = rule == null ? new ArrayList<>() : new ArrayList<>(rule);
                    return this;
                }

                /**
                 * Adds a {@code rule} value.
                 *
                 * @param rule the value to add
                 * @return this builder
                 */
                public Builder addRule(StructureMap.Group.Rule rule) {
                    this.rule.add(Objects.requireNonNull(rule, "rule"));
                    return this;
                }

                /**
                 * Replaces all {@code dependent} values.
                 *
                 * @param dependent the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder dependent(List<Dependent> dependent) {
                    this.dependent = dependent == null ? new ArrayList<>() : new ArrayList<>(dependent);
                    return this;
                }

                /**
                 * Adds a {@code dependent} value.
                 *
                 * @param dependent the value to add
                 * @return this builder
                 */
                public Builder addDependent(Dependent dependent) {
                    this.dependent.add(Objects.requireNonNull(dependent, "dependent"));
                    return this;
                }

                /**
                 * Sets {@code documentation}.
                 *
                 * @param documentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder documentation(FhirString documentation) {
                    this.documentation = documentation;
                    return this;
                }

                /**
                 * Sets {@code documentation}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param documentation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder documentation(String documentation) {
                    return documentation(documentation == null ? null : FhirString.of(documentation));
                }

                /**
                 * Builds the {@code Rule}.
                 *
                 * @return the {@code Rule}
                 * @throws NullPointerException if a required element is absent
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public Rule build() {
                    return new Rule(
                            id, extension, modifierExtension, name, source, target, rule, dependent, documentation);
                }
            }
        }

        /** Builder for {@link Group}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirId name;
            private FhirId extendsValue;
            private FhirEnum<StructureMapGroupTypeMode> typeMode;
            private FhirString documentation;
            private List<Input> input = new ArrayList<>();
            private List<Rule> rule = new ArrayList<>();

            private Builder() {
            }

            private Builder(Group original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.extendsValue = original.extendsValue();
                this.typeMode = original.typeMode();
                this.documentation = original.documentation();
                this.input = new ArrayList<>(original.input());
                this.rule = new ArrayList<>(original.rule());
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
             * Sets {@code name}.
             *
             * @param name the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder name(FhirId name) {
                this.name = name;
                return this;
            }

            /**
             * Sets {@code name}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param name the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder name(String name) {
                return name(name == null ? null : FhirId.of(name));
            }

            /**
             * Sets {@code extendsValue}.
             *
             * @param extendsValue the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder extendsValue(FhirId extendsValue) {
                this.extendsValue = extendsValue;
                return this;
            }

            /**
             * Sets {@code extendsValue}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param extendsValue the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder extendsValue(String extendsValue) {
                return extendsValue(extendsValue == null ? null : FhirId.of(extendsValue));
            }

            /**
             * Sets {@code typeMode}.
             *
             * @param typeMode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder typeMode(FhirEnum<StructureMapGroupTypeMode> typeMode) {
                this.typeMode = typeMode;
                return this;
            }

            /**
             * Sets {@code typeMode}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param typeMode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder typeMode(StructureMapGroupTypeMode typeMode) {
                return typeMode(typeMode == null ? null : FhirEnum.of(typeMode));
            }

            /**
             * Sets {@code documentation}.
             *
             * @param documentation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder documentation(FhirString documentation) {
                this.documentation = documentation;
                return this;
            }

            /**
             * Sets {@code documentation}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param documentation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder documentation(String documentation) {
                return documentation(documentation == null ? null : FhirString.of(documentation));
            }

            /**
             * Replaces all {@code input} values.
             *
             * @param input the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder input(List<Input> input) {
                this.input = input == null ? new ArrayList<>() : new ArrayList<>(input);
                return this;
            }

            /**
             * Adds a {@code input} value.
             *
             * @param input the value to add
             * @return this builder
             */
            public Builder addInput(Input input) {
                this.input.add(Objects.requireNonNull(input, "input"));
                return this;
            }

            /**
             * Replaces all {@code rule} values.
             *
             * @param rule the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder rule(List<Rule> rule) {
                this.rule = rule == null ? new ArrayList<>() : new ArrayList<>(rule);
                return this;
            }

            /**
             * Adds a {@code rule} value.
             *
             * @param rule the value to add
             * @return this builder
             */
            public Builder addRule(Rule rule) {
                this.rule.add(Objects.requireNonNull(rule, "rule"));
                return this;
            }

            /**
             * Builds the {@code Group}.
             *
             * @return the {@code Group}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Group build() {
                return new Group(
                        id, extension, modifierExtension, name, extendsValue, typeMode, documentation, input, rule);
            }
        }
    }

    /** Builder for {@link StructureMap}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirUri url;
        private List<Identifier> identifier = new ArrayList<>();
        private FhirString version;
        private DataType versionAlgorithm;
        private FhirString name;
        private FhirString title;
        private FhirEnum<PublicationStatus> status;
        private FhirBoolean experimental;
        private FhirDateTime date;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private FhirMarkdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private FhirMarkdown purpose;
        private FhirMarkdown copyright;
        private FhirString copyrightLabel;
        private List<Structure> structure = new ArrayList<>();
        private List<FhirCanonical> importValue = new ArrayList<>();
        private List<ConstValue> constValue = new ArrayList<>();
        private List<Group> group = new ArrayList<>();

        private Builder() {
        }

        private Builder(StructureMap original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.url = original.url();
            this.identifier = new ArrayList<>(original.identifier());
            this.version = original.version();
            this.versionAlgorithm = original.versionAlgorithm();
            this.name = original.name();
            this.title = original.title();
            this.status = original.status();
            this.experimental = original.experimental();
            this.date = original.date();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.description = original.description();
            this.useContext = new ArrayList<>(original.useContext());
            this.jurisdiction = new ArrayList<>(original.jurisdiction());
            this.purpose = original.purpose();
            this.copyright = original.copyright();
            this.copyrightLabel = original.copyrightLabel();
            this.structure = new ArrayList<>(original.structure());
            this.importValue = new ArrayList<>(original.importValue());
            this.constValue = new ArrayList<>(original.constValue());
            this.group = new ArrayList<>(original.group());
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
         * Sets {@code url}.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(FhirUri url) {
            this.url = url;
            return this;
        }

        /**
         * Sets {@code url}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(String url) {
            return url(url == null ? null : FhirUri.of(url));
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
         * Sets {@code version}.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(FhirString version) {
            this.version = version;
            return this;
        }

        /**
         * Sets {@code version}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(String version) {
            return version(version == null ? null : FhirString.of(version));
        }

        /**
         * Sets {@code versionAlgorithm} to a string.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(FhirString versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a Coding.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(Coding versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a string without id or extensions.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(String versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm == null ? null : FhirString.of(versionAlgorithm);
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
         * Sets {@code title}.
         *
         * @param title the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder title(FhirString title) {
            this.title = title;
            return this;
        }

        /**
         * Sets {@code title}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param title the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder title(String title) {
            return title(title == null ? null : FhirString.of(title));
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
         * Sets {@code experimental}.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(FhirBoolean experimental) {
            this.experimental = experimental;
            return this;
        }

        /**
         * Sets {@code experimental}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(Boolean experimental) {
            return experimental(experimental == null ? null : FhirBoolean.of(experimental));
        }

        /**
         * Sets {@code date}.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(FhirDateTime date) {
            this.date = date;
            return this;
        }

        /**
         * Sets {@code date}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(Temporal date) {
            return date(date == null ? null : FhirDateTime.of(date));
        }

        /**
         * Sets {@code publisher}.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(FhirString publisher) {
            this.publisher = publisher;
            return this;
        }

        /**
         * Sets {@code publisher}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(String publisher) {
            return publisher(publisher == null ? null : FhirString.of(publisher));
        }

        /**
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ContactDetail> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ContactDetail contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
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
         * Replaces all {@code useContext} values.
         *
         * @param useContext the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder useContext(List<UsageContext> useContext) {
            this.useContext = useContext == null ? new ArrayList<>() : new ArrayList<>(useContext);
            return this;
        }

        /**
         * Adds a {@code useContext} value.
         *
         * @param useContext the value to add
         * @return this builder
         */
        public Builder addUseContext(UsageContext useContext) {
            this.useContext.add(Objects.requireNonNull(useContext, "useContext"));
            return this;
        }

        /**
         * Replaces all {@code jurisdiction} values.
         *
         * @param jurisdiction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder jurisdiction(List<CodeableConcept> jurisdiction) {
            this.jurisdiction = jurisdiction == null ? new ArrayList<>() : new ArrayList<>(jurisdiction);
            return this;
        }

        /**
         * Adds a {@code jurisdiction} value.
         *
         * @param jurisdiction the value to add
         * @return this builder
         */
        public Builder addJurisdiction(CodeableConcept jurisdiction) {
            this.jurisdiction.add(Objects.requireNonNull(jurisdiction, "jurisdiction"));
            return this;
        }

        /**
         * Sets {@code purpose}.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(FhirMarkdown purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * Sets {@code purpose}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(String purpose) {
            return purpose(purpose == null ? null : FhirMarkdown.of(purpose));
        }

        /**
         * Sets {@code copyright}.
         *
         * @param copyright the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyright(FhirMarkdown copyright) {
            this.copyright = copyright;
            return this;
        }

        /**
         * Sets {@code copyright}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param copyright the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyright(String copyright) {
            return copyright(copyright == null ? null : FhirMarkdown.of(copyright));
        }

        /**
         * Sets {@code copyrightLabel}.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(FhirString copyrightLabel) {
            this.copyrightLabel = copyrightLabel;
            return this;
        }

        /**
         * Sets {@code copyrightLabel}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(String copyrightLabel) {
            return copyrightLabel(copyrightLabel == null ? null : FhirString.of(copyrightLabel));
        }

        /**
         * Replaces all {@code structure} values.
         *
         * @param structure the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder structure(List<Structure> structure) {
            this.structure = structure == null ? new ArrayList<>() : new ArrayList<>(structure);
            return this;
        }

        /**
         * Adds a {@code structure} value.
         *
         * @param structure the value to add
         * @return this builder
         */
        public Builder addStructure(Structure structure) {
            this.structure.add(Objects.requireNonNull(structure, "structure"));
            return this;
        }

        /**
         * Replaces all {@code importValue} values.
         *
         * @param importValue the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder importValue(List<FhirCanonical> importValue) {
            this.importValue = importValue == null ? new ArrayList<>() : new ArrayList<>(importValue);
            return this;
        }

        /**
         * Adds a {@code importValue} value.
         *
         * @param importValue the value to add
         * @return this builder
         */
        public Builder addImportValue(FhirCanonical importValue) {
            this.importValue.add(Objects.requireNonNull(importValue, "importValue"));
            return this;
        }

        /**
         * Adds a {@code importValue} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param importValue the value to add
         * @return this builder
         */
        public Builder addImportValue(String importValue) {
            return addImportValue(FhirCanonical.of(importValue));
        }

        /**
         * Replaces all {@code constValue} values.
         *
         * @param constValue the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder constValue(List<ConstValue> constValue) {
            this.constValue = constValue == null ? new ArrayList<>() : new ArrayList<>(constValue);
            return this;
        }

        /**
         * Adds a {@code constValue} value.
         *
         * @param constValue the value to add
         * @return this builder
         */
        public Builder addConstValue(ConstValue constValue) {
            this.constValue.add(Objects.requireNonNull(constValue, "constValue"));
            return this;
        }

        /**
         * Replaces all {@code group} values.
         *
         * @param group the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder group(List<Group> group) {
            this.group = group == null ? new ArrayList<>() : new ArrayList<>(group);
            return this;
        }

        /**
         * Adds a {@code group} value.
         *
         * @param group the value to add
         * @return this builder
         */
        public Builder addGroup(Group group) {
            this.group.add(Objects.requireNonNull(group, "group"));
            return this;
        }

        /**
         * Builds the {@code StructureMap}.
         *
         * @return the {@code StructureMap}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public StructureMap build() {
            return new StructureMap(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, structure, importValue,
                    constValue, group);
        }
    }
}
