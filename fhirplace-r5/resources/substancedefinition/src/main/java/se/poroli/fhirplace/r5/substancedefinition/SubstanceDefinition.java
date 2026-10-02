package se.poroli.fhirplace.r5.substancedefinition;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
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

/**
 * The detailed description of a substance, typically at a level beyond what is used for prescribing.
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
 * @param identifier Identifier by which this substance is known.
 * @param version A business level version identifier of the substance.
 * @param status Status of substance within the catalogue e.g. active, retired.
 * @param classification A categorization, high level e.g. polymer or nucleic acid, or food, chemical, biological, or
 *   lower e.g. polymer linear or branch chain, or type of impurity.
 * @param domain If the substance applies to human or veterinary use.
 * @param grade The quality standard, established benchmark, to which substance complies (e.g. USP/NF, BP).
 * @param description Textual description of the substance.
 * @param informationSource Supporting literature. Reference to Citation.
 * @param note Textual comment about the substance's catalogue or registry record.
 * @param manufacturer The entity that creates, makes, produces or fabricates the substance. Reference to
 *   Organization.
 * @param supplier An entity that is the source for the substance. It may be different from the manufacturer.
 *   Reference to Organization.
 * @param moiety Moiety, for structural modifications.
 * @param characterization General specifications for this substance.
 * @param property General specifications for this substance.
 * @param referenceInformation General information detailing this substance. Reference to
 *   SubstanceReferenceInformation.
 * @param molecularWeight The average mass of a molecule of a compound.
 * @param structure Structural information.
 * @param code Codes associated with the substance.
 * @param name Names applicable to this substance.
 * @param relationship A link between this substance and another.
 * @param nucleicAcid Data items specific to nucleic acids. Reference to SubstanceNucleicAcid.
 * @param polymer Data items specific to polymers. Reference to SubstancePolymer.
 * @param protein Data items specific to proteins. Reference to SubstanceProtein.
 * @param sourceMaterial Material or taxonomic/anatomical source.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/SubstanceDefinition">FHIR R5 SubstanceDefinition</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record SubstanceDefinition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirString version,
        CodeableConcept status,
        List<CodeableConcept> classification,
        CodeableConcept domain,
        List<CodeableConcept> grade,
        FhirMarkdown description,
        List<Reference> informationSource,
        List<Annotation> note,
        List<Reference> manufacturer,
        List<Reference> supplier,
        List<Moiety> moiety,
        List<Characterization> characterization,
        List<Property> property,
        Reference referenceInformation,
        List<MolecularWeight> molecularWeight,
        Structure structure,
        List<Code> code,
        List<Name> name,
        List<Relationship> relationship,
        Reference nucleicAcid,
        Reference polymer,
        Reference protein,
        SourceMaterial sourceMaterial) implements DomainResource {

    /**
     * Creates a {@code SubstanceDefinition}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public SubstanceDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        classification = classification == null ? List.of() : List.copyOf(classification);
        grade = grade == null ? List.of() : List.copyOf(grade);
        informationSource = informationSource == null ? List.of() : List.copyOf(informationSource);
        note = note == null ? List.of() : List.copyOf(note);
        manufacturer = manufacturer == null ? List.of() : List.copyOf(manufacturer);
        supplier = supplier == null ? List.of() : List.copyOf(supplier);
        moiety = moiety == null ? List.of() : List.copyOf(moiety);
        characterization = characterization == null ? List.of() : List.copyOf(characterization);
        property = property == null ? List.of() : List.copyOf(property);
        molecularWeight = molecularWeight == null ? List.of() : List.copyOf(molecularWeight);
        code = code == null ? List.of() : List.copyOf(code);
        name = name == null ? List.of() : List.copyOf(name);
        relationship = relationship == null ? List.of() : List.copyOf(relationship);
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
     * Returns a builder initialized with the values of this {@code SubstanceDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Moiety, for structural modifications.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param role Role that the moiety is playing.
     * @param identifier Identifier by which this moiety substance is known.
     * @param name Textual name for this moiety substance.
     * @param stereochemistry Stereochemistry type.
     * @param opticalActivity Optical activity type.
     * @param molecularFormula Molecular formula for this moiety (e.g. with the Hill system).
     * @param amount Quantitative value for this moiety. One of Quantity, string.
     * @param measurementType The measurement type of the quantitative value.
     */
    public record Moiety(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept role,
            Identifier identifier,
            FhirString name,
            CodeableConcept stereochemistry,
            CodeableConcept opticalActivity,
            FhirString molecularFormula,
            DataType amount,
            CodeableConcept measurementType) implements BackboneElement {

        /**
         * Creates a {@code Moiety}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Moiety {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (amount != null && !(amount instanceof Quantity || amount instanceof FhirString)) {
                throw new IllegalArgumentException(
                        "SubstanceDefinition.moiety.amount[x] must be one of Quantity, string, but was "
                                + amount.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Moiety}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Moiety}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept role;
            private Identifier identifier;
            private FhirString name;
            private CodeableConcept stereochemistry;
            private CodeableConcept opticalActivity;
            private FhirString molecularFormula;
            private DataType amount;
            private CodeableConcept measurementType;

            private Builder() {
            }

            private Builder(Moiety original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.role = original.role();
                this.identifier = original.identifier();
                this.name = original.name();
                this.stereochemistry = original.stereochemistry();
                this.opticalActivity = original.opticalActivity();
                this.molecularFormula = original.molecularFormula();
                this.amount = original.amount();
                this.measurementType = original.measurementType();
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
            public Builder role(CodeableConcept role) {
                this.role = role;
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
             * Sets {@code stereochemistry}.
             *
             * @param stereochemistry the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder stereochemistry(CodeableConcept stereochemistry) {
                this.stereochemistry = stereochemistry;
                return this;
            }

            /**
             * Sets {@code opticalActivity}.
             *
             * @param opticalActivity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder opticalActivity(CodeableConcept opticalActivity) {
                this.opticalActivity = opticalActivity;
                return this;
            }

            /**
             * Sets {@code molecularFormula}.
             *
             * @param molecularFormula the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder molecularFormula(FhirString molecularFormula) {
                this.molecularFormula = molecularFormula;
                return this;
            }

            /**
             * Sets {@code molecularFormula}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param molecularFormula the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder molecularFormula(String molecularFormula) {
                return molecularFormula(molecularFormula == null ? null : FhirString.of(molecularFormula));
            }

            /**
             * Sets {@code amount} to a Quantity.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(Quantity amount) {
                this.amount = amount;
                return this;
            }

            /**
             * Sets {@code amount} to a string.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(FhirString amount) {
                this.amount = amount;
                return this;
            }

            /**
             * Sets {@code amount} to a string without id or extensions.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(String amount) {
                this.amount = amount == null ? null : FhirString.of(amount);
                return this;
            }

            /**
             * Sets {@code measurementType}.
             *
             * @param measurementType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder measurementType(CodeableConcept measurementType) {
                this.measurementType = measurementType;
                return this;
            }

            /**
             * Builds the {@code Moiety}.
             *
             * @return the {@code Moiety}
             */
            public Moiety build() {
                return new Moiety(
                        id, extension, modifierExtension, role, identifier, name, stereochemistry, opticalActivity,
                        molecularFormula, amount, measurementType);
            }
        }
    }

    /**
     * General specifications for this substance.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param technique The method used to find the characterization e.g. HPLC.
     * @param form Describes the nature of the chemical entity and explains, for instance, whether this is a base or a
     *   salt form.
     * @param description The description or justification in support of the interpretation of the data file.
     * @param file The data produced by the analytical instrument or a pictorial representation of that data.
     *   Examples: a JCAMP, JDX, or ADX file, or a chromatogram or spectrum analysis.
     */
    public record Characterization(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept technique,
            CodeableConcept form,
            FhirMarkdown description,
            List<Attachment> file) implements BackboneElement {

        /**
         * Creates a {@code Characterization}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Characterization {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            file = file == null ? List.of() : List.copyOf(file);
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
         * Returns a builder initialized with the values of this {@code Characterization}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Characterization}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept technique;
            private CodeableConcept form;
            private FhirMarkdown description;
            private List<Attachment> file = new ArrayList<>();

            private Builder() {
            }

            private Builder(Characterization original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.technique = original.technique();
                this.form = original.form();
                this.description = original.description();
                this.file = new ArrayList<>(original.file());
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
             * Sets {@code technique}.
             *
             * @param technique the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder technique(CodeableConcept technique) {
                this.technique = technique;
                return this;
            }

            /**
             * Sets {@code form}.
             *
             * @param form the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder form(CodeableConcept form) {
                this.form = form;
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
             * Replaces all {@code file} values.
             *
             * @param file the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder file(List<Attachment> file) {
                this.file = file == null ? new ArrayList<>() : new ArrayList<>(file);
                return this;
            }

            /**
             * Adds a {@code file} value.
             *
             * @param file the value to add
             * @return this builder
             */
            public Builder addFile(Attachment file) {
                this.file.add(Objects.requireNonNull(file, "file"));
                return this;
            }

            /**
             * Builds the {@code Characterization}.
             *
             * @return the {@code Characterization}
             */
            public Characterization build() {
                return new Characterization(
                        id, extension, modifierExtension, technique, form, description, file);
            }
        }
    }

    /**
     * General specifications for this substance.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type A code expressing the type of property. Required.
     * @param value A value for the property. One of CodeableConcept, Quantity, date, boolean, Attachment.
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
            Objects.requireNonNull(type, "SubstanceDefinition.property.type is required");
            if (value != null && !(value instanceof CodeableConcept
                    || value instanceof Quantity
                    || value instanceof FhirDate
                    || value instanceof FhirBoolean
                    || value instanceof Attachment)) {
                throw new IllegalArgumentException(
                        "SubstanceDefinition.property.value[x] does not allow "
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
     * The average mass of a molecule of a compound compared to 1/12 the mass of carbon 12 and calculated as the sum
     * of the atomic weights of the constituent atoms.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param method The method by which the weight was determined.
     * @param type Type of molecular weight e.g. exact, average, weight average.
     * @param amount Used to capture quantitative values for a variety of elements. Required.
     */
    public record MolecularWeight(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept method,
            CodeableConcept type,
            Quantity amount) implements BackboneElement {

        /**
         * Creates a {@code MolecularWeight}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public MolecularWeight {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(amount, "SubstanceDefinition.molecularWeight.amount is required");
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
         * Returns a builder initialized with the values of this {@code MolecularWeight}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link MolecularWeight}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept method;
            private CodeableConcept type;
            private Quantity amount;

            private Builder() {
            }

            private Builder(MolecularWeight original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.method = original.method();
                this.type = original.type();
                this.amount = original.amount();
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
             * Sets {@code method}.
             *
             * @param method the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder method(CodeableConcept method) {
                this.method = method;
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
             * Sets {@code amount}.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(Quantity amount) {
                this.amount = amount;
                return this;
            }

            /**
             * Builds the {@code MolecularWeight}.
             *
             * @return the {@code MolecularWeight}
             * @throws NullPointerException if a required element is absent
             */
            public MolecularWeight build() {
                return new MolecularWeight(
                        id, extension, modifierExtension, method, type, amount);
            }
        }
    }

    /**
     * Structural information.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param stereochemistry Stereochemistry type.
     * @param opticalActivity Optical activity type.
     * @param molecularFormula An expression which states the number and type of atoms present in a molecule of a
     *   substance.
     * @param molecularFormulaByMoiety Specified per moiety according to the Hill system.
     * @param molecularWeight The molecular weight or weight range.
     * @param technique The method used to find the structure e.g. X-ray, NMR.
     * @param sourceDocument Source of information for the structure. Reference to DocumentReference.
     * @param representation A depiction of the structure of the substance.
     */
    public record Structure(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept stereochemistry,
            CodeableConcept opticalActivity,
            FhirString molecularFormula,
            FhirString molecularFormulaByMoiety,
            SubstanceDefinition.MolecularWeight molecularWeight,
            List<CodeableConcept> technique,
            List<Reference> sourceDocument,
            List<Representation> representation) implements BackboneElement {

        /**
         * Creates a {@code Structure}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Structure {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            technique = technique == null ? List.of() : List.copyOf(technique);
            sourceDocument = sourceDocument == null ? List.of() : List.copyOf(sourceDocument);
            representation = representation == null ? List.of() : List.copyOf(representation);
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

        /**
         * A depiction of the structure of the substance.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type The kind of structural representation (e.g. full, partial).
         * @param representation The structural representation as a text string in a standard format.
         * @param format The format of the representation e.g. InChI, SMILES, MOLFILE (note: not the physical file
         *   format).
         * @param document An attachment with the structural representation e.g. a structure graphic or AnIML file.
         *   Reference to DocumentReference.
         */
        public record Representation(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                FhirString representation,
                CodeableConcept format,
                Reference document) implements BackboneElement {

            /**
             * Creates a {@code Representation}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Representation {
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
             * Returns a builder initialized with the values of this {@code Representation}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Representation}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private FhirString representation;
                private CodeableConcept format;
                private Reference document;

                private Builder() {
                }

                private Builder(Representation original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.representation = original.representation();
                    this.format = original.format();
                    this.document = original.document();
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
                 * Sets {@code representation}.
                 *
                 * @param representation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder representation(FhirString representation) {
                    this.representation = representation;
                    return this;
                }

                /**
                 * Sets {@code representation}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param representation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder representation(String representation) {
                    return representation(representation == null ? null : FhirString.of(representation));
                }

                /**
                 * Sets {@code format}.
                 *
                 * @param format the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder format(CodeableConcept format) {
                    this.format = format;
                    return this;
                }

                /**
                 * Sets {@code document}.
                 *
                 * @param document the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder document(Reference document) {
                    this.document = document;
                    return this;
                }

                /**
                 * Builds the {@code Representation}.
                 *
                 * @return the {@code Representation}
                 */
                public Representation build() {
                    return new Representation(
                            id, extension, modifierExtension, type, representation, format, document);
                }
            }
        }

        /** Builder for {@link Structure}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept stereochemistry;
            private CodeableConcept opticalActivity;
            private FhirString molecularFormula;
            private FhirString molecularFormulaByMoiety;
            private SubstanceDefinition.MolecularWeight molecularWeight;
            private List<CodeableConcept> technique = new ArrayList<>();
            private List<Reference> sourceDocument = new ArrayList<>();
            private List<Representation> representation = new ArrayList<>();

            private Builder() {
            }

            private Builder(Structure original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.stereochemistry = original.stereochemistry();
                this.opticalActivity = original.opticalActivity();
                this.molecularFormula = original.molecularFormula();
                this.molecularFormulaByMoiety = original.molecularFormulaByMoiety();
                this.molecularWeight = original.molecularWeight();
                this.technique = new ArrayList<>(original.technique());
                this.sourceDocument = new ArrayList<>(original.sourceDocument());
                this.representation = new ArrayList<>(original.representation());
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
             * Sets {@code stereochemistry}.
             *
             * @param stereochemistry the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder stereochemistry(CodeableConcept stereochemistry) {
                this.stereochemistry = stereochemistry;
                return this;
            }

            /**
             * Sets {@code opticalActivity}.
             *
             * @param opticalActivity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder opticalActivity(CodeableConcept opticalActivity) {
                this.opticalActivity = opticalActivity;
                return this;
            }

            /**
             * Sets {@code molecularFormula}.
             *
             * @param molecularFormula the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder molecularFormula(FhirString molecularFormula) {
                this.molecularFormula = molecularFormula;
                return this;
            }

            /**
             * Sets {@code molecularFormula}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param molecularFormula the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder molecularFormula(String molecularFormula) {
                return molecularFormula(molecularFormula == null ? null : FhirString.of(molecularFormula));
            }

            /**
             * Sets {@code molecularFormulaByMoiety}.
             *
             * @param molecularFormulaByMoiety the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder molecularFormulaByMoiety(FhirString molecularFormulaByMoiety) {
                this.molecularFormulaByMoiety = molecularFormulaByMoiety;
                return this;
            }

            /**
             * Sets {@code molecularFormulaByMoiety}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param molecularFormulaByMoiety the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder molecularFormulaByMoiety(String molecularFormulaByMoiety) {
                return molecularFormulaByMoiety(
                        molecularFormulaByMoiety == null ? null : FhirString.of(molecularFormulaByMoiety));
            }

            /**
             * Sets {@code molecularWeight}.
             *
             * @param molecularWeight the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder molecularWeight(SubstanceDefinition.MolecularWeight molecularWeight) {
                this.molecularWeight = molecularWeight;
                return this;
            }

            /**
             * Replaces all {@code technique} values.
             *
             * @param technique the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder technique(List<CodeableConcept> technique) {
                this.technique = technique == null ? new ArrayList<>() : new ArrayList<>(technique);
                return this;
            }

            /**
             * Adds a {@code technique} value.
             *
             * @param technique the value to add
             * @return this builder
             */
            public Builder addTechnique(CodeableConcept technique) {
                this.technique.add(Objects.requireNonNull(technique, "technique"));
                return this;
            }

            /**
             * Replaces all {@code sourceDocument} values.
             *
             * @param sourceDocument the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder sourceDocument(List<Reference> sourceDocument) {
                this.sourceDocument = sourceDocument == null ? new ArrayList<>() : new ArrayList<>(sourceDocument);
                return this;
            }

            /**
             * Adds a {@code sourceDocument} value.
             *
             * @param sourceDocument the value to add
             * @return this builder
             */
            public Builder addSourceDocument(Reference sourceDocument) {
                this.sourceDocument.add(Objects.requireNonNull(sourceDocument, "sourceDocument"));
                return this;
            }

            /**
             * Replaces all {@code representation} values.
             *
             * @param representation the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder representation(List<Representation> representation) {
                this.representation = representation == null ? new ArrayList<>() : new ArrayList<>(representation);
                return this;
            }

            /**
             * Adds a {@code representation} value.
             *
             * @param representation the value to add
             * @return this builder
             */
            public Builder addRepresentation(Representation representation) {
                this.representation.add(Objects.requireNonNull(representation, "representation"));
                return this;
            }

            /**
             * Builds the {@code Structure}.
             *
             * @return the {@code Structure}
             */
            public Structure build() {
                return new Structure(
                        id, extension, modifierExtension, stereochemistry, opticalActivity, molecularFormula,
                        molecularFormulaByMoiety, molecularWeight, technique, sourceDocument, representation);
            }
        }
    }

    /**
     * Codes associated with the substance.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code The specific code.
     * @param status Status of the code assignment, for example 'provisional', 'approved'.
     * @param statusDate The date at which the code status was changed.
     * @param note Any comment can be provided in this field.
     * @param source Supporting literature. Reference to DocumentReference.
     */
    public record Code(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            CodeableConcept status,
            FhirDateTime statusDate,
            List<Annotation> note,
            List<Reference> source) implements BackboneElement {

        /**
         * Creates a {@code Code}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Code {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            note = note == null ? List.of() : List.copyOf(note);
            source = source == null ? List.of() : List.copyOf(source);
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
         * Returns a builder initialized with the values of this {@code Code}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Code}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private CodeableConcept status;
            private FhirDateTime statusDate;
            private List<Annotation> note = new ArrayList<>();
            private List<Reference> source = new ArrayList<>();

            private Builder() {
            }

            private Builder(Code original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.status = original.status();
                this.statusDate = original.statusDate();
                this.note = new ArrayList<>(original.note());
                this.source = new ArrayList<>(original.source());
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
             * Sets {@code statusDate}.
             *
             * @param statusDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder statusDate(FhirDateTime statusDate) {
                this.statusDate = statusDate;
                return this;
            }

            /**
             * Sets {@code statusDate}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param statusDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder statusDate(Temporal statusDate) {
                return statusDate(statusDate == null ? null : FhirDateTime.of(statusDate));
            }

            /**
             * Replaces all {@code note} values.
             *
             * @param note the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder note(List<Annotation> note) {
                this.note = note == null ? new ArrayList<>() : new ArrayList<>(note);
                return this;
            }

            /**
             * Adds a {@code note} value.
             *
             * @param note the value to add
             * @return this builder
             */
            public Builder addNote(Annotation note) {
                this.note.add(Objects.requireNonNull(note, "note"));
                return this;
            }

            /**
             * Replaces all {@code source} values.
             *
             * @param source the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder source(List<Reference> source) {
                this.source = source == null ? new ArrayList<>() : new ArrayList<>(source);
                return this;
            }

            /**
             * Adds a {@code source} value.
             *
             * @param source the value to add
             * @return this builder
             */
            public Builder addSource(Reference source) {
                this.source.add(Objects.requireNonNull(source, "source"));
                return this;
            }

            /**
             * Builds the {@code Code}.
             *
             * @return the {@code Code}
             */
            public Code build() {
                return new Code(
                        id, extension, modifierExtension, code, status, statusDate, note, source);
            }
        }
    }

    /**
     * Names applicable to this substance.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name The actual name. Required.
     * @param type Name type e.g. 'systematic', 'scientific, 'brand'.
     * @param status The status of the name e.g. 'current', 'proposed'.
     * @param preferred If this is the preferred name for this substance.
     * @param language Human language that the name is written in.
     * @param domain The use context of this name e.g. as an active ingredient or as a food colour additive.
     * @param jurisdiction The jurisdiction where this name applies.
     * @param synonym A synonym of this particular name, by which the substance is also known.
     * @param translation A translation for this name into another human language.
     * @param official Details of the official nature of this name.
     * @param source Supporting literature. Reference to DocumentReference.
     */
    public record Name(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            CodeableConcept type,
            CodeableConcept status,
            FhirBoolean preferred,
            List<CodeableConcept> language,
            List<CodeableConcept> domain,
            List<CodeableConcept> jurisdiction,
            List<SubstanceDefinition.Name> synonym,
            List<SubstanceDefinition.Name> translation,
            List<Official> official,
            List<Reference> source) implements BackboneElement {

        /**
         * Creates a {@code Name}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Name {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            language = language == null ? List.of() : List.copyOf(language);
            domain = domain == null ? List.of() : List.copyOf(domain);
            jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
            synonym = synonym == null ? List.of() : List.copyOf(synonym);
            translation = translation == null ? List.of() : List.copyOf(translation);
            official = official == null ? List.of() : List.copyOf(official);
            source = source == null ? List.of() : List.copyOf(source);
            Objects.requireNonNull(name, "SubstanceDefinition.name.name is required");
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
         * Returns a builder initialized with the values of this {@code Name}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Details of the official nature of this name.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param authority Which authority uses this official name.
         * @param status The status of the official name, for example 'draft', 'active'.
         * @param date Date of official name change.
         */
        public record Official(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept authority,
                CodeableConcept status,
                FhirDateTime date) implements BackboneElement {

            /**
             * Creates an {@code Official}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Official {
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
             * Returns a builder initialized with the values of this {@code Official}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Official}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept authority;
                private CodeableConcept status;
                private FhirDateTime date;

                private Builder() {
                }

                private Builder(Official original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.authority = original.authority();
                    this.status = original.status();
                    this.date = original.date();
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
                 * Sets {@code authority}.
                 *
                 * @param authority the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder authority(CodeableConcept authority) {
                    this.authority = authority;
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
                 * Builds the {@code Official}.
                 *
                 * @return the {@code Official}
                 */
                public Official build() {
                    return new Official(
                            id, extension, modifierExtension, authority, status, date);
                }
            }
        }

        /** Builder for {@link Name}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString name;
            private CodeableConcept type;
            private CodeableConcept status;
            private FhirBoolean preferred;
            private List<CodeableConcept> language = new ArrayList<>();
            private List<CodeableConcept> domain = new ArrayList<>();
            private List<CodeableConcept> jurisdiction = new ArrayList<>();
            private List<SubstanceDefinition.Name> synonym = new ArrayList<>();
            private List<SubstanceDefinition.Name> translation = new ArrayList<>();
            private List<Official> official = new ArrayList<>();
            private List<Reference> source = new ArrayList<>();

            private Builder() {
            }

            private Builder(Name original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.type = original.type();
                this.status = original.status();
                this.preferred = original.preferred();
                this.language = new ArrayList<>(original.language());
                this.domain = new ArrayList<>(original.domain());
                this.jurisdiction = new ArrayList<>(original.jurisdiction());
                this.synonym = new ArrayList<>(original.synonym());
                this.translation = new ArrayList<>(original.translation());
                this.official = new ArrayList<>(original.official());
                this.source = new ArrayList<>(original.source());
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
             * Sets {@code preferred}.
             *
             * @param preferred the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder preferred(FhirBoolean preferred) {
                this.preferred = preferred;
                return this;
            }

            /**
             * Sets {@code preferred}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param preferred the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder preferred(Boolean preferred) {
                return preferred(preferred == null ? null : FhirBoolean.of(preferred));
            }

            /**
             * Replaces all {@code language} values.
             *
             * @param language the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder language(List<CodeableConcept> language) {
                this.language = language == null ? new ArrayList<>() : new ArrayList<>(language);
                return this;
            }

            /**
             * Adds a {@code language} value.
             *
             * @param language the value to add
             * @return this builder
             */
            public Builder addLanguage(CodeableConcept language) {
                this.language.add(Objects.requireNonNull(language, "language"));
                return this;
            }

            /**
             * Replaces all {@code domain} values.
             *
             * @param domain the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder domain(List<CodeableConcept> domain) {
                this.domain = domain == null ? new ArrayList<>() : new ArrayList<>(domain);
                return this;
            }

            /**
             * Adds a {@code domain} value.
             *
             * @param domain the value to add
             * @return this builder
             */
            public Builder addDomain(CodeableConcept domain) {
                this.domain.add(Objects.requireNonNull(domain, "domain"));
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
             * Replaces all {@code synonym} values.
             *
             * @param synonym the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder synonym(List<SubstanceDefinition.Name> synonym) {
                this.synonym = synonym == null ? new ArrayList<>() : new ArrayList<>(synonym);
                return this;
            }

            /**
             * Adds a {@code synonym} value.
             *
             * @param synonym the value to add
             * @return this builder
             */
            public Builder addSynonym(SubstanceDefinition.Name synonym) {
                this.synonym.add(Objects.requireNonNull(synonym, "synonym"));
                return this;
            }

            /**
             * Replaces all {@code translation} values.
             *
             * @param translation the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder translation(List<SubstanceDefinition.Name> translation) {
                this.translation = translation == null ? new ArrayList<>() : new ArrayList<>(translation);
                return this;
            }

            /**
             * Adds a {@code translation} value.
             *
             * @param translation the value to add
             * @return this builder
             */
            public Builder addTranslation(SubstanceDefinition.Name translation) {
                this.translation.add(Objects.requireNonNull(translation, "translation"));
                return this;
            }

            /**
             * Replaces all {@code official} values.
             *
             * @param official the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder official(List<Official> official) {
                this.official = official == null ? new ArrayList<>() : new ArrayList<>(official);
                return this;
            }

            /**
             * Adds a {@code official} value.
             *
             * @param official the value to add
             * @return this builder
             */
            public Builder addOfficial(Official official) {
                this.official.add(Objects.requireNonNull(official, "official"));
                return this;
            }

            /**
             * Replaces all {@code source} values.
             *
             * @param source the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder source(List<Reference> source) {
                this.source = source == null ? new ArrayList<>() : new ArrayList<>(source);
                return this;
            }

            /**
             * Adds a {@code source} value.
             *
             * @param source the value to add
             * @return this builder
             */
            public Builder addSource(Reference source) {
                this.source.add(Objects.requireNonNull(source, "source"));
                return this;
            }

            /**
             * Builds the {@code Name}.
             *
             * @return the {@code Name}
             * @throws NullPointerException if a required element is absent
             */
            public Name build() {
                return new Name(
                        id, extension, modifierExtension, name, type, status, preferred, language, domain,
                        jurisdiction, synonym, translation, official, source);
            }
        }
    }

    /**
     * A link between this substance and another, with details of the relationship.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param substanceDefinition A pointer to another substance, as a resource or a representational code. One of
     *   Reference, CodeableConcept.
     * @param type For example "salt to parent", "active moiety". Required.
     * @param isDefining For example where an enzyme strongly bonds with a particular substance, this is a defining
     *   relationship for that enzyme, out of several possible relationships.
     * @param amount A numeric factor for the relationship, e.g. that a substance salt has some percentage of active
     *   substance in relation to some other. One of Quantity, Ratio, string.
     * @param ratioHighLimitAmount For use when the numeric has an uncertain range.
     * @param comparator An operator for the amount, for example "average", "approximately", "less than".
     * @param source Supporting literature. Reference to DocumentReference.
     */
    public record Relationship(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType substanceDefinition,
            CodeableConcept type,
            FhirBoolean isDefining,
            DataType amount,
            Ratio ratioHighLimitAmount,
            CodeableConcept comparator,
            List<Reference> source) implements BackboneElement {

        /**
         * Creates a {@code Relationship}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Relationship {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            source = source == null ? List.of() : List.copyOf(source);
            Objects.requireNonNull(type, "SubstanceDefinition.relationship.type is required");
            if (substanceDefinition != null && !(substanceDefinition instanceof Reference
                    || substanceDefinition instanceof CodeableConcept)) {
                throw new IllegalArgumentException(
                        "SubstanceDefinition.relationship.substanceDefinition[x] does not allow "
                                + substanceDefinition.getClass().getSimpleName());
            }
            if (amount != null && !(amount instanceof Quantity
                    || amount instanceof Ratio
                    || amount instanceof FhirString)) {
                throw new IllegalArgumentException(
                        "SubstanceDefinition.relationship.amount[x] must be one of Quantity, Ratio, string, but was "
                                + amount.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Relationship}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Relationship}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType substanceDefinition;
            private CodeableConcept type;
            private FhirBoolean isDefining;
            private DataType amount;
            private Ratio ratioHighLimitAmount;
            private CodeableConcept comparator;
            private List<Reference> source = new ArrayList<>();

            private Builder() {
            }

            private Builder(Relationship original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.substanceDefinition = original.substanceDefinition();
                this.type = original.type();
                this.isDefining = original.isDefining();
                this.amount = original.amount();
                this.ratioHighLimitAmount = original.ratioHighLimitAmount();
                this.comparator = original.comparator();
                this.source = new ArrayList<>(original.source());
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
             * Sets {@code substanceDefinition} to a Reference.
             *
             * @param substanceDefinition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder substanceDefinition(Reference substanceDefinition) {
                this.substanceDefinition = substanceDefinition;
                return this;
            }

            /**
             * Sets {@code substanceDefinition} to a CodeableConcept.
             *
             * @param substanceDefinition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder substanceDefinition(CodeableConcept substanceDefinition) {
                this.substanceDefinition = substanceDefinition;
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
             * Sets {@code isDefining}.
             *
             * @param isDefining the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder isDefining(FhirBoolean isDefining) {
                this.isDefining = isDefining;
                return this;
            }

            /**
             * Sets {@code isDefining}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param isDefining the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder isDefining(Boolean isDefining) {
                return isDefining(isDefining == null ? null : FhirBoolean.of(isDefining));
            }

            /**
             * Sets {@code amount} to a Quantity.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(Quantity amount) {
                this.amount = amount;
                return this;
            }

            /**
             * Sets {@code amount} to a Ratio.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(Ratio amount) {
                this.amount = amount;
                return this;
            }

            /**
             * Sets {@code amount} to a string.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(FhirString amount) {
                this.amount = amount;
                return this;
            }

            /**
             * Sets {@code amount} to a string without id or extensions.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(String amount) {
                this.amount = amount == null ? null : FhirString.of(amount);
                return this;
            }

            /**
             * Sets {@code ratioHighLimitAmount}.
             *
             * @param ratioHighLimitAmount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder ratioHighLimitAmount(Ratio ratioHighLimitAmount) {
                this.ratioHighLimitAmount = ratioHighLimitAmount;
                return this;
            }

            /**
             * Sets {@code comparator}.
             *
             * @param comparator the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder comparator(CodeableConcept comparator) {
                this.comparator = comparator;
                return this;
            }

            /**
             * Replaces all {@code source} values.
             *
             * @param source the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder source(List<Reference> source) {
                this.source = source == null ? new ArrayList<>() : new ArrayList<>(source);
                return this;
            }

            /**
             * Adds a {@code source} value.
             *
             * @param source the value to add
             * @return this builder
             */
            public Builder addSource(Reference source) {
                this.source.add(Objects.requireNonNull(source, "source"));
                return this;
            }

            /**
             * Builds the {@code Relationship}.
             *
             * @return the {@code Relationship}
             * @throws NullPointerException if a required element is absent
             */
            public Relationship build() {
                return new Relationship(
                        id, extension, modifierExtension, substanceDefinition, type, isDefining, amount,
                        ratioHighLimitAmount, comparator, source);
            }
        }
    }

    /**
     * Material or taxonomic/anatomical source for the substance.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Classification of the origin of the raw material. e.g. cat hair is an Animal source type.
     * @param genus The genus of an organism e.g. the Latin epithet of the plant/animal scientific name.
     * @param species The species of an organism e.g. the Latin epithet of the species of the plant/animal.
     * @param part An anatomical origin of the source material within an organism.
     * @param countryOfOrigin The country or countries where the material is harvested.
     */
    public record SourceMaterial(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            CodeableConcept genus,
            CodeableConcept species,
            CodeableConcept part,
            List<CodeableConcept> countryOfOrigin) implements BackboneElement {

        /**
         * Creates a {@code SourceMaterial}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public SourceMaterial {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            countryOfOrigin = countryOfOrigin == null ? List.of() : List.copyOf(countryOfOrigin);
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
         * Returns a builder initialized with the values of this {@code SourceMaterial}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link SourceMaterial}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private CodeableConcept genus;
            private CodeableConcept species;
            private CodeableConcept part;
            private List<CodeableConcept> countryOfOrigin = new ArrayList<>();

            private Builder() {
            }

            private Builder(SourceMaterial original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.genus = original.genus();
                this.species = original.species();
                this.part = original.part();
                this.countryOfOrigin = new ArrayList<>(original.countryOfOrigin());
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
             * Sets {@code genus}.
             *
             * @param genus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder genus(CodeableConcept genus) {
                this.genus = genus;
                return this;
            }

            /**
             * Sets {@code species}.
             *
             * @param species the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder species(CodeableConcept species) {
                this.species = species;
                return this;
            }

            /**
             * Sets {@code part}.
             *
             * @param part the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder part(CodeableConcept part) {
                this.part = part;
                return this;
            }

            /**
             * Replaces all {@code countryOfOrigin} values.
             *
             * @param countryOfOrigin the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder countryOfOrigin(List<CodeableConcept> countryOfOrigin) {
                this.countryOfOrigin = countryOfOrigin == null ? new ArrayList<>() : new ArrayList<>(countryOfOrigin);
                return this;
            }

            /**
             * Adds a {@code countryOfOrigin} value.
             *
             * @param countryOfOrigin the value to add
             * @return this builder
             */
            public Builder addCountryOfOrigin(CodeableConcept countryOfOrigin) {
                this.countryOfOrigin.add(Objects.requireNonNull(countryOfOrigin, "countryOfOrigin"));
                return this;
            }

            /**
             * Builds the {@code SourceMaterial}.
             *
             * @return the {@code SourceMaterial}
             */
            public SourceMaterial build() {
                return new SourceMaterial(
                        id, extension, modifierExtension, type, genus, species, part, countryOfOrigin);
            }
        }
    }

    /** Builder for {@link SubstanceDefinition}. Builders are mutable and not thread-safe. */
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
        private FhirString version;
        private CodeableConcept status;
        private List<CodeableConcept> classification = new ArrayList<>();
        private CodeableConcept domain;
        private List<CodeableConcept> grade = new ArrayList<>();
        private FhirMarkdown description;
        private List<Reference> informationSource = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<Reference> manufacturer = new ArrayList<>();
        private List<Reference> supplier = new ArrayList<>();
        private List<Moiety> moiety = new ArrayList<>();
        private List<Characterization> characterization = new ArrayList<>();
        private List<Property> property = new ArrayList<>();
        private Reference referenceInformation;
        private List<MolecularWeight> molecularWeight = new ArrayList<>();
        private Structure structure;
        private List<Code> code = new ArrayList<>();
        private List<Name> name = new ArrayList<>();
        private List<Relationship> relationship = new ArrayList<>();
        private Reference nucleicAcid;
        private Reference polymer;
        private Reference protein;
        private SourceMaterial sourceMaterial;

        private Builder() {
        }

        private Builder(SubstanceDefinition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.version = original.version();
            this.status = original.status();
            this.classification = new ArrayList<>(original.classification());
            this.domain = original.domain();
            this.grade = new ArrayList<>(original.grade());
            this.description = original.description();
            this.informationSource = new ArrayList<>(original.informationSource());
            this.note = new ArrayList<>(original.note());
            this.manufacturer = new ArrayList<>(original.manufacturer());
            this.supplier = new ArrayList<>(original.supplier());
            this.moiety = new ArrayList<>(original.moiety());
            this.characterization = new ArrayList<>(original.characterization());
            this.property = new ArrayList<>(original.property());
            this.referenceInformation = original.referenceInformation();
            this.molecularWeight = new ArrayList<>(original.molecularWeight());
            this.structure = original.structure();
            this.code = new ArrayList<>(original.code());
            this.name = new ArrayList<>(original.name());
            this.relationship = new ArrayList<>(original.relationship());
            this.nucleicAcid = original.nucleicAcid();
            this.polymer = original.polymer();
            this.protein = original.protein();
            this.sourceMaterial = original.sourceMaterial();
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
         * Replaces all {@code classification} values.
         *
         * @param classification the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder classification(List<CodeableConcept> classification) {
            this.classification = classification == null ? new ArrayList<>() : new ArrayList<>(classification);
            return this;
        }

        /**
         * Adds a {@code classification} value.
         *
         * @param classification the value to add
         * @return this builder
         */
        public Builder addClassification(CodeableConcept classification) {
            this.classification.add(Objects.requireNonNull(classification, "classification"));
            return this;
        }

        /**
         * Sets {@code domain}.
         *
         * @param domain the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder domain(CodeableConcept domain) {
            this.domain = domain;
            return this;
        }

        /**
         * Replaces all {@code grade} values.
         *
         * @param grade the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder grade(List<CodeableConcept> grade) {
            this.grade = grade == null ? new ArrayList<>() : new ArrayList<>(grade);
            return this;
        }

        /**
         * Adds a {@code grade} value.
         *
         * @param grade the value to add
         * @return this builder
         */
        public Builder addGrade(CodeableConcept grade) {
            this.grade.add(Objects.requireNonNull(grade, "grade"));
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
         * Replaces all {@code informationSource} values.
         *
         * @param informationSource the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder informationSource(List<Reference> informationSource) {
            this.informationSource = informationSource == null
                    ? new ArrayList<>()
                    : new ArrayList<>(informationSource);
            return this;
        }

        /**
         * Adds a {@code informationSource} value.
         *
         * @param informationSource the value to add
         * @return this builder
         */
        public Builder addInformationSource(Reference informationSource) {
            this.informationSource.add(Objects.requireNonNull(informationSource, "informationSource"));
            return this;
        }

        /**
         * Replaces all {@code note} values.
         *
         * @param note the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder note(List<Annotation> note) {
            this.note = note == null ? new ArrayList<>() : new ArrayList<>(note);
            return this;
        }

        /**
         * Adds a {@code note} value.
         *
         * @param note the value to add
         * @return this builder
         */
        public Builder addNote(Annotation note) {
            this.note.add(Objects.requireNonNull(note, "note"));
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
         * Replaces all {@code moiety} values.
         *
         * @param moiety the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder moiety(List<Moiety> moiety) {
            this.moiety = moiety == null ? new ArrayList<>() : new ArrayList<>(moiety);
            return this;
        }

        /**
         * Adds a {@code moiety} value.
         *
         * @param moiety the value to add
         * @return this builder
         */
        public Builder addMoiety(Moiety moiety) {
            this.moiety.add(Objects.requireNonNull(moiety, "moiety"));
            return this;
        }

        /**
         * Replaces all {@code characterization} values.
         *
         * @param characterization the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder characterization(List<Characterization> characterization) {
            this.characterization = characterization == null ? new ArrayList<>() : new ArrayList<>(characterization);
            return this;
        }

        /**
         * Adds a {@code characterization} value.
         *
         * @param characterization the value to add
         * @return this builder
         */
        public Builder addCharacterization(Characterization characterization) {
            this.characterization.add(Objects.requireNonNull(characterization, "characterization"));
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
         * Sets {@code referenceInformation}.
         *
         * @param referenceInformation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder referenceInformation(Reference referenceInformation) {
            this.referenceInformation = referenceInformation;
            return this;
        }

        /**
         * Replaces all {@code molecularWeight} values.
         *
         * @param molecularWeight the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder molecularWeight(List<MolecularWeight> molecularWeight) {
            this.molecularWeight = molecularWeight == null ? new ArrayList<>() : new ArrayList<>(molecularWeight);
            return this;
        }

        /**
         * Adds a {@code molecularWeight} value.
         *
         * @param molecularWeight the value to add
         * @return this builder
         */
        public Builder addMolecularWeight(MolecularWeight molecularWeight) {
            this.molecularWeight.add(Objects.requireNonNull(molecularWeight, "molecularWeight"));
            return this;
        }

        /**
         * Sets {@code structure}.
         *
         * @param structure the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder structure(Structure structure) {
            this.structure = structure;
            return this;
        }

        /**
         * Replaces all {@code code} values.
         *
         * @param code the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder code(List<Code> code) {
            this.code = code == null ? new ArrayList<>() : new ArrayList<>(code);
            return this;
        }

        /**
         * Adds a {@code code} value.
         *
         * @param code the value to add
         * @return this builder
         */
        public Builder addCode(Code code) {
            this.code.add(Objects.requireNonNull(code, "code"));
            return this;
        }

        /**
         * Replaces all {@code name} values.
         *
         * @param name the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder name(List<Name> name) {
            this.name = name == null ? new ArrayList<>() : new ArrayList<>(name);
            return this;
        }

        /**
         * Adds a {@code name} value.
         *
         * @param name the value to add
         * @return this builder
         */
        public Builder addName(Name name) {
            this.name.add(Objects.requireNonNull(name, "name"));
            return this;
        }

        /**
         * Replaces all {@code relationship} values.
         *
         * @param relationship the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relationship(List<Relationship> relationship) {
            this.relationship = relationship == null ? new ArrayList<>() : new ArrayList<>(relationship);
            return this;
        }

        /**
         * Adds a {@code relationship} value.
         *
         * @param relationship the value to add
         * @return this builder
         */
        public Builder addRelationship(Relationship relationship) {
            this.relationship.add(Objects.requireNonNull(relationship, "relationship"));
            return this;
        }

        /**
         * Sets {@code nucleicAcid}.
         *
         * @param nucleicAcid the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder nucleicAcid(Reference nucleicAcid) {
            this.nucleicAcid = nucleicAcid;
            return this;
        }

        /**
         * Sets {@code polymer}.
         *
         * @param polymer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder polymer(Reference polymer) {
            this.polymer = polymer;
            return this;
        }

        /**
         * Sets {@code protein}.
         *
         * @param protein the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder protein(Reference protein) {
            this.protein = protein;
            return this;
        }

        /**
         * Sets {@code sourceMaterial}.
         *
         * @param sourceMaterial the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sourceMaterial(SourceMaterial sourceMaterial) {
            this.sourceMaterial = sourceMaterial;
            return this;
        }

        /**
         * Builds the {@code SubstanceDefinition}.
         *
         * @return the {@code SubstanceDefinition}
         */
        public SubstanceDefinition build() {
            return new SubstanceDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    version, status, classification, domain, grade, description, informationSource, note,
                    manufacturer, supplier, moiety, characterization, property, referenceInformation, molecularWeight,
                    structure, code, name, relationship, nucleicAcid, polymer, protein, sourceMaterial);
        }
    }
}
