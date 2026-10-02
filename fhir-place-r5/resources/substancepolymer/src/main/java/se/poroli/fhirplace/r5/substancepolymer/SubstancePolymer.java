package se.poroli.fhirplace.r5.substancepolymer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;

/**
 * Properties of a substance specific to it being a polymer.
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
 * @param identifier A business idenfier for this polymer, but typically this is handled by a SubstanceDefinition
 *   identifier.
 * @param classValue Overall type of the polymer. The FHIR element {@code class}.
 * @param geometry Polymer geometry, e.g. linear, branched, cross-linked, network or dendritic.
 * @param copolymerConnectivity Descrtibes the copolymer sequence type (polymer connectivity).
 * @param modification Todo - this is intended to connect to a repeating full modification structure, also used by
 *   Protein and Nucleic Acid . String is just a placeholder.
 * @param monomerSet Todo.
 * @param repeat Specifies and quantifies the repeated units and their configuration.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/SubstancePolymer">FHIR R5 SubstancePolymer</a>
 */
public record SubstancePolymer(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        Identifier identifier,
        CodeableConcept classValue,
        CodeableConcept geometry,
        List<CodeableConcept> copolymerConnectivity,
        FhirString modification,
        List<MonomerSet> monomerSet,
        List<Repeat> repeat) implements DomainResource {

    /**
     * Creates a {@code SubstancePolymer}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public SubstancePolymer {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        copolymerConnectivity = copolymerConnectivity == null ? List.of() : List.copyOf(copolymerConnectivity);
        monomerSet = monomerSet == null ? List.of() : List.copyOf(monomerSet);
        repeat = repeat == null ? List.of() : List.copyOf(repeat);
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
     * Returns a builder initialized with the values of this {@code SubstancePolymer}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Todo.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param ratioType Captures the type of ratio to the entire polymer, e.g. Monomer/Polymer ratio, SRU/Polymer
     *   Ratio.
     * @param startingMaterial The starting materials - monomer(s) used in the synthesis of the polymer.
     */
    public record MonomerSet(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept ratioType,
            List<StartingMaterial> startingMaterial) implements BackboneElement {

        /**
         * Creates a {@code MonomerSet}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public MonomerSet {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            startingMaterial = startingMaterial == null ? List.of() : List.copyOf(startingMaterial);
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
         * Returns a builder initialized with the values of this {@code MonomerSet}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The starting materials - monomer(s) used in the synthesis of the polymer.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code The type of substance for this starting material.
         * @param category Substance high level category, e.g. chemical substance.
         * @param isDefining Used to specify whether the attribute described is a defining element for the unique
         *   identification of the polymer.
         * @param amount A percentage.
         */
        public record StartingMaterial(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept code,
                CodeableConcept category,
                FhirBoolean isDefining,
                Quantity amount) implements BackboneElement {

            /**
             * Creates a {@code StartingMaterial}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public StartingMaterial {
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
             * Returns a builder initialized with the values of this {@code StartingMaterial}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link StartingMaterial}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept code;
                private CodeableConcept category;
                private FhirBoolean isDefining;
                private Quantity amount;

                private Builder() {
                }

                private Builder(StartingMaterial original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.code = original.code();
                    this.category = original.category();
                    this.isDefining = original.isDefining();
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
                 * Builds the {@code StartingMaterial}.
                 *
                 * @return the {@code StartingMaterial}
                 */
                public StartingMaterial build() {
                    return new StartingMaterial(
                            id, extension, modifierExtension, code, category, isDefining, amount);
                }
            }
        }

        /** Builder for {@link MonomerSet}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept ratioType;
            private List<StartingMaterial> startingMaterial = new ArrayList<>();

            private Builder() {
            }

            private Builder(MonomerSet original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.ratioType = original.ratioType();
                this.startingMaterial = new ArrayList<>(original.startingMaterial());
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
             * Sets {@code ratioType}.
             *
             * @param ratioType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder ratioType(CodeableConcept ratioType) {
                this.ratioType = ratioType;
                return this;
            }

            /**
             * Replaces all {@code startingMaterial} values.
             *
             * @param startingMaterial the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder startingMaterial(List<StartingMaterial> startingMaterial) {
                this.startingMaterial = startingMaterial == null
                        ? new ArrayList<>()
                        : new ArrayList<>(startingMaterial);
                return this;
            }

            /**
             * Adds a {@code startingMaterial} value.
             *
             * @param startingMaterial the value to add
             * @return this builder
             */
            public Builder addStartingMaterial(StartingMaterial startingMaterial) {
                this.startingMaterial.add(Objects.requireNonNull(startingMaterial, "startingMaterial"));
                return this;
            }

            /**
             * Builds the {@code MonomerSet}.
             *
             * @return the {@code MonomerSet}
             */
            public MonomerSet build() {
                return new MonomerSet(
                        id, extension, modifierExtension, ratioType, startingMaterial);
            }
        }
    }

    /**
     * Specifies and quantifies the repeated units and their configuration.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param averageMolecularFormula A representation of an (average) molecular formula from a polymer.
     * @param repeatUnitAmountType How the quantitative amount of Structural Repeat Units is captured (e.g. Exact,
     *   Numeric, Average).
     * @param repeatUnit An SRU - Structural Repeat Unit.
     */
    public record Repeat(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString averageMolecularFormula,
            CodeableConcept repeatUnitAmountType,
            List<RepeatUnit> repeatUnit) implements BackboneElement {

        /**
         * Creates a {@code Repeat}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Repeat {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            repeatUnit = repeatUnit == null ? List.of() : List.copyOf(repeatUnit);
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
         * Returns a builder initialized with the values of this {@code Repeat}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * An SRU - Structural Repeat Unit.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param unit Structural repeat units are essential elements for defining polymers.
         * @param orientation The orientation of the polymerisation, e.g. head-tail, head-head, random.
         * @param amount Number of repeats of this unit.
         * @param degreeOfPolymerisation Applies to homopolymer and block co-polymers where the degree of
         *   polymerisation within a block can be described.
         * @param structuralRepresentation A graphical structure for this SRU.
         */
        public record RepeatUnit(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString unit,
                CodeableConcept orientation,
                FhirInteger amount,
                List<DegreeOfPolymerisation> degreeOfPolymerisation,
                List<StructuralRepresentation> structuralRepresentation) implements BackboneElement {

            /**
             * Creates a {@code RepeatUnit}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public RepeatUnit {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                degreeOfPolymerisation =
                        degreeOfPolymerisation == null ? List.of() : List.copyOf(degreeOfPolymerisation);
                structuralRepresentation =
                        structuralRepresentation == null ? List.of() : List.copyOf(structuralRepresentation);
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
             * Returns a builder initialized with the values of this {@code RepeatUnit}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Applies to homopolymer and block co-polymers where the degree of polymerisation within a block can be
             * described.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param type The type of the degree of polymerisation shall be described, e.g. SRU/Polymer Ratio.
             * @param average An average amount of polymerisation.
             * @param low A low expected limit of the amount.
             * @param high A high expected limit of the amount.
             */
            public record DegreeOfPolymerisation(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    CodeableConcept type,
                    FhirInteger average,
                    FhirInteger low,
                    FhirInteger high) implements BackboneElement {

                /**
                 * Creates a {@code DegreeOfPolymerisation}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 */
                public DegreeOfPolymerisation {
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
                 * Returns a builder initialized with the values of this {@code DegreeOfPolymerisation}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link DegreeOfPolymerisation}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private CodeableConcept type;
                    private FhirInteger average;
                    private FhirInteger low;
                    private FhirInteger high;

                    private Builder() {
                    }

                    private Builder(DegreeOfPolymerisation original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.type = original.type();
                        this.average = original.average();
                        this.low = original.low();
                        this.high = original.high();
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
                     * Sets {@code average}.
                     *
                     * @param average the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder average(FhirInteger average) {
                        this.average = average;
                        return this;
                    }

                    /**
                     * Sets {@code average}, wrapped in a {@link FhirInteger} without id or extensions.
                     *
                     * @param average the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder average(Integer average) {
                        return average(average == null ? null : FhirInteger.of(average));
                    }

                    /**
                     * Sets {@code low}.
                     *
                     * @param low the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder low(FhirInteger low) {
                        this.low = low;
                        return this;
                    }

                    /**
                     * Sets {@code low}, wrapped in a {@link FhirInteger} without id or extensions.
                     *
                     * @param low the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder low(Integer low) {
                        return low(low == null ? null : FhirInteger.of(low));
                    }

                    /**
                     * Sets {@code high}.
                     *
                     * @param high the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder high(FhirInteger high) {
                        this.high = high;
                        return this;
                    }

                    /**
                     * Sets {@code high}, wrapped in a {@link FhirInteger} without id or extensions.
                     *
                     * @param high the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder high(Integer high) {
                        return high(high == null ? null : FhirInteger.of(high));
                    }

                    /**
                     * Builds the {@code DegreeOfPolymerisation}.
                     *
                     * @return the {@code DegreeOfPolymerisation}
                     */
                    public DegreeOfPolymerisation build() {
                        return new DegreeOfPolymerisation(
                                id, extension, modifierExtension, type, average, low, high);
                    }
                }
            }

            /**
             * A graphical structure for this SRU.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param type The type of structure (e.g. Full, Partial, Representative).
             * @param representation The structural representation as text string in a standard format e.g. InChI,
             *   SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.
             * @param format The format of the representation e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.
             * @param attachment An attached file with the structural representation.
             */
            public record StructuralRepresentation(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    CodeableConcept type,
                    FhirString representation,
                    CodeableConcept format,
                    Attachment attachment) implements BackboneElement {

                /**
                 * Creates a {@code StructuralRepresentation}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 */
                public StructuralRepresentation {
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
                 * Returns a builder initialized with the values of this {@code StructuralRepresentation}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link StructuralRepresentation}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private CodeableConcept type;
                    private FhirString representation;
                    private CodeableConcept format;
                    private Attachment attachment;

                    private Builder() {
                    }

                    private Builder(StructuralRepresentation original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.type = original.type();
                        this.representation = original.representation();
                        this.format = original.format();
                        this.attachment = original.attachment();
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
                     * Sets {@code attachment}.
                     *
                     * @param attachment the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder attachment(Attachment attachment) {
                        this.attachment = attachment;
                        return this;
                    }

                    /**
                     * Builds the {@code StructuralRepresentation}.
                     *
                     * @return the {@code StructuralRepresentation}
                     */
                    public StructuralRepresentation build() {
                        return new StructuralRepresentation(
                                id, extension, modifierExtension, type, representation, format, attachment);
                    }
                }
            }

            /** Builder for {@link RepeatUnit}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString unit;
                private CodeableConcept orientation;
                private FhirInteger amount;
                private List<DegreeOfPolymerisation> degreeOfPolymerisation = new ArrayList<>();
                private List<StructuralRepresentation> structuralRepresentation = new ArrayList<>();

                private Builder() {
                }

                private Builder(RepeatUnit original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.unit = original.unit();
                    this.orientation = original.orientation();
                    this.amount = original.amount();
                    this.degreeOfPolymerisation = new ArrayList<>(original.degreeOfPolymerisation());
                    this.structuralRepresentation = new ArrayList<>(original.structuralRepresentation());
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
                 * Sets {@code unit}.
                 *
                 * @param unit the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder unit(FhirString unit) {
                    this.unit = unit;
                    return this;
                }

                /**
                 * Sets {@code unit}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param unit the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder unit(String unit) {
                    return unit(unit == null ? null : FhirString.of(unit));
                }

                /**
                 * Sets {@code orientation}.
                 *
                 * @param orientation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder orientation(CodeableConcept orientation) {
                    this.orientation = orientation;
                    return this;
                }

                /**
                 * Sets {@code amount}.
                 *
                 * @param amount the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder amount(FhirInteger amount) {
                    this.amount = amount;
                    return this;
                }

                /**
                 * Sets {@code amount}, wrapped in a {@link FhirInteger} without id or extensions.
                 *
                 * @param amount the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder amount(Integer amount) {
                    return amount(amount == null ? null : FhirInteger.of(amount));
                }

                /**
                 * Replaces all {@code degreeOfPolymerisation} values.
                 *
                 * @param degreeOfPolymerisation the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder degreeOfPolymerisation(List<DegreeOfPolymerisation> degreeOfPolymerisation) {
                    this.degreeOfPolymerisation = degreeOfPolymerisation == null
                            ? new ArrayList<>()
                            : new ArrayList<>(degreeOfPolymerisation);
                    return this;
                }

                /**
                 * Adds a {@code degreeOfPolymerisation} value.
                 *
                 * @param degreeOfPolymerisation the value to add
                 * @return this builder
                 */
                public Builder addDegreeOfPolymerisation(DegreeOfPolymerisation degreeOfPolymerisation) {
                    this.degreeOfPolymerisation.add(
                            Objects.requireNonNull(degreeOfPolymerisation, "degreeOfPolymerisation"));
                    return this;
                }

                /**
                 * Replaces all {@code structuralRepresentation} values.
                 *
                 * @param structuralRepresentation the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder structuralRepresentation(List<StructuralRepresentation> structuralRepresentation) {
                    this.structuralRepresentation = structuralRepresentation == null
                            ? new ArrayList<>()
                            : new ArrayList<>(structuralRepresentation);
                    return this;
                }

                /**
                 * Adds a {@code structuralRepresentation} value.
                 *
                 * @param structuralRepresentation the value to add
                 * @return this builder
                 */
                public Builder addStructuralRepresentation(StructuralRepresentation structuralRepresentation) {
                    this.structuralRepresentation.add(
                            Objects.requireNonNull(structuralRepresentation, "structuralRepresentation"));
                    return this;
                }

                /**
                 * Builds the {@code RepeatUnit}.
                 *
                 * @return the {@code RepeatUnit}
                 */
                public RepeatUnit build() {
                    return new RepeatUnit(
                            id, extension, modifierExtension, unit, orientation, amount, degreeOfPolymerisation,
                            structuralRepresentation);
                }
            }
        }

        /** Builder for {@link Repeat}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString averageMolecularFormula;
            private CodeableConcept repeatUnitAmountType;
            private List<RepeatUnit> repeatUnit = new ArrayList<>();

            private Builder() {
            }

            private Builder(Repeat original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.averageMolecularFormula = original.averageMolecularFormula();
                this.repeatUnitAmountType = original.repeatUnitAmountType();
                this.repeatUnit = new ArrayList<>(original.repeatUnit());
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
             * Sets {@code averageMolecularFormula}.
             *
             * @param averageMolecularFormula the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder averageMolecularFormula(FhirString averageMolecularFormula) {
                this.averageMolecularFormula = averageMolecularFormula;
                return this;
            }

            /**
             * Sets {@code averageMolecularFormula}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param averageMolecularFormula the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder averageMolecularFormula(String averageMolecularFormula) {
                return averageMolecularFormula(
                        averageMolecularFormula == null ? null : FhirString.of(averageMolecularFormula));
            }

            /**
             * Sets {@code repeatUnitAmountType}.
             *
             * @param repeatUnitAmountType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder repeatUnitAmountType(CodeableConcept repeatUnitAmountType) {
                this.repeatUnitAmountType = repeatUnitAmountType;
                return this;
            }

            /**
             * Replaces all {@code repeatUnit} values.
             *
             * @param repeatUnit the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder repeatUnit(List<RepeatUnit> repeatUnit) {
                this.repeatUnit = repeatUnit == null ? new ArrayList<>() : new ArrayList<>(repeatUnit);
                return this;
            }

            /**
             * Adds a {@code repeatUnit} value.
             *
             * @param repeatUnit the value to add
             * @return this builder
             */
            public Builder addRepeatUnit(RepeatUnit repeatUnit) {
                this.repeatUnit.add(Objects.requireNonNull(repeatUnit, "repeatUnit"));
                return this;
            }

            /**
             * Builds the {@code Repeat}.
             *
             * @return the {@code Repeat}
             */
            public Repeat build() {
                return new Repeat(
                        id, extension, modifierExtension, averageMolecularFormula, repeatUnitAmountType, repeatUnit);
            }
        }
    }

    /** Builder for {@link SubstancePolymer}. Builders are mutable and not thread-safe. */
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
        private CodeableConcept classValue;
        private CodeableConcept geometry;
        private List<CodeableConcept> copolymerConnectivity = new ArrayList<>();
        private FhirString modification;
        private List<MonomerSet> monomerSet = new ArrayList<>();
        private List<Repeat> repeat = new ArrayList<>();

        private Builder() {
        }

        private Builder(SubstancePolymer original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = original.identifier();
            this.classValue = original.classValue();
            this.geometry = original.geometry();
            this.copolymerConnectivity = new ArrayList<>(original.copolymerConnectivity());
            this.modification = original.modification();
            this.monomerSet = new ArrayList<>(original.monomerSet());
            this.repeat = new ArrayList<>(original.repeat());
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
         * Sets {@code classValue}.
         *
         * @param classValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder classValue(CodeableConcept classValue) {
            this.classValue = classValue;
            return this;
        }

        /**
         * Sets {@code geometry}.
         *
         * @param geometry the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder geometry(CodeableConcept geometry) {
            this.geometry = geometry;
            return this;
        }

        /**
         * Replaces all {@code copolymerConnectivity} values.
         *
         * @param copolymerConnectivity the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder copolymerConnectivity(List<CodeableConcept> copolymerConnectivity) {
            this.copolymerConnectivity = copolymerConnectivity == null
                    ? new ArrayList<>()
                    : new ArrayList<>(copolymerConnectivity);
            return this;
        }

        /**
         * Adds a {@code copolymerConnectivity} value.
         *
         * @param copolymerConnectivity the value to add
         * @return this builder
         */
        public Builder addCopolymerConnectivity(CodeableConcept copolymerConnectivity) {
            this.copolymerConnectivity.add(Objects.requireNonNull(copolymerConnectivity, "copolymerConnectivity"));
            return this;
        }

        /**
         * Sets {@code modification}.
         *
         * @param modification the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder modification(FhirString modification) {
            this.modification = modification;
            return this;
        }

        /**
         * Sets {@code modification}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param modification the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder modification(String modification) {
            return modification(modification == null ? null : FhirString.of(modification));
        }

        /**
         * Replaces all {@code monomerSet} values.
         *
         * @param monomerSet the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder monomerSet(List<MonomerSet> monomerSet) {
            this.monomerSet = monomerSet == null ? new ArrayList<>() : new ArrayList<>(monomerSet);
            return this;
        }

        /**
         * Adds a {@code monomerSet} value.
         *
         * @param monomerSet the value to add
         * @return this builder
         */
        public Builder addMonomerSet(MonomerSet monomerSet) {
            this.monomerSet.add(Objects.requireNonNull(monomerSet, "monomerSet"));
            return this;
        }

        /**
         * Replaces all {@code repeat} values.
         *
         * @param repeat the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder repeat(List<Repeat> repeat) {
            this.repeat = repeat == null ? new ArrayList<>() : new ArrayList<>(repeat);
            return this;
        }

        /**
         * Adds a {@code repeat} value.
         *
         * @param repeat the value to add
         * @return this builder
         */
        public Builder addRepeat(Repeat repeat) {
            this.repeat.add(Objects.requireNonNull(repeat, "repeat"));
            return this;
        }

        /**
         * Builds the {@code SubstancePolymer}.
         *
         * @return the {@code SubstancePolymer}
         */
        public SubstancePolymer build() {
            return new SubstancePolymer(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    classValue, geometry, copolymerConnectivity, modification, monomerSet, repeat);
        }
    }
}
