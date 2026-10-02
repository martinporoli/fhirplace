package se.poroli.fhirplace.r5.molecularsequence;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * Representation of a molecular sequence.
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
 * @param identifier Unique ID for this particular sequence.
 * @param type aa | dna | rna.
 * @param subject Subject this sequence is associated too. Reference to Patient, Group, Substance,
 *   BiologicallyDerivedProduct, NutritionProduct.
 * @param focus What the molecular sequence is about, when it is not about the subject of record. Reference to
 *   Resource.
 * @param specimen Specimen used for sequencing. Reference to Specimen.
 * @param device The method for sequencing. Reference to Device.
 * @param performer Who should be responsible for test result. Reference to Organization.
 * @param literal Sequence that was observed.
 * @param formatted Embedded file or a link (URL) which contains content to represent the sequence.
 * @param relative A sequence defined relative to another sequence.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MolecularSequence">FHIR R5 MolecularSequence</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record MolecularSequence(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<SequenceType> type,
        Reference subject,
        List<Reference> focus,
        Reference specimen,
        Reference device,
        Reference performer,
        FhirString literal,
        List<Attachment> formatted,
        List<Relative> relative) implements DomainResource {

    /**
     * Creates a {@code MolecularSequence}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public MolecularSequence {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        focus = focus == null ? List.of() : List.copyOf(focus);
        formatted = formatted == null ? List.of() : List.copyOf(formatted);
        relative = relative == null ? List.of() : List.copyOf(relative);
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
     * Returns a builder initialized with the values of this {@code MolecularSequence}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A sequence defined relative to another sequence.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param coordinateSystem Ways of identifying nucleotides or amino acids within a sequence. Required.
     * @param ordinalPosition Indicates the order in which the sequence should be considered when putting multiple
     *   'relative' elements together.
     * @param sequenceRange Indicates the nucleotide range in the composed sequence when multiple 'relative' elements
     *   are used together.
     * @param startingSequence A sequence used as starting sequence.
     * @param edit Changes in sequence from the starting sequence.
     */
    public record Relative(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept coordinateSystem,
            FhirInteger ordinalPosition,
            Range sequenceRange,
            StartingSequence startingSequence,
            List<Edit> edit) implements BackboneElement {

        /**
         * Creates a {@code Relative}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Relative {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            edit = edit == null ? List.of() : List.copyOf(edit);
            Objects.requireNonNull(coordinateSystem, "MolecularSequence.relative.coordinateSystem is required");
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
         * Returns a builder initialized with the values of this {@code Relative}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A sequence that is used as a starting sequence to describe variants that are present in a sequence
         * analyzed.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param genomeAssembly The genome assembly used for starting sequence, e.g. GRCh38.
         * @param chromosome Chromosome Identifier.
         * @param sequence The reference sequence that represents the starting sequence. One of CodeableConcept,
         *   string, Reference.
         * @param windowStart Start position of the window on the starting sequence.
         * @param windowEnd End position of the window on the starting sequence.
         * @param orientation sense | antisense.
         * @param strand watson | crick.
         */
        public record StartingSequence(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept genomeAssembly,
                CodeableConcept chromosome,
                DataType sequence,
                FhirInteger windowStart,
                FhirInteger windowEnd,
                FhirEnum<OrientationType> orientation,
                FhirEnum<StrandType> strand) implements BackboneElement {

            /**
             * Creates a {@code StartingSequence}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public StartingSequence {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                if (sequence != null && !(sequence instanceof CodeableConcept
                        || sequence instanceof FhirString
                        || sequence instanceof Reference)) {
                    throw new IllegalArgumentException(
                            "MolecularSequence.relative.startingSequence.sequence[x] does not allow "
                                    + sequence.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code StartingSequence}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link StartingSequence}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept genomeAssembly;
                private CodeableConcept chromosome;
                private DataType sequence;
                private FhirInteger windowStart;
                private FhirInteger windowEnd;
                private FhirEnum<OrientationType> orientation;
                private FhirEnum<StrandType> strand;

                private Builder() {
                }

                private Builder(StartingSequence original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.genomeAssembly = original.genomeAssembly();
                    this.chromosome = original.chromosome();
                    this.sequence = original.sequence();
                    this.windowStart = original.windowStart();
                    this.windowEnd = original.windowEnd();
                    this.orientation = original.orientation();
                    this.strand = original.strand();
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
                 * Sets {@code genomeAssembly}.
                 *
                 * @param genomeAssembly the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder genomeAssembly(CodeableConcept genomeAssembly) {
                    this.genomeAssembly = genomeAssembly;
                    return this;
                }

                /**
                 * Sets {@code chromosome}.
                 *
                 * @param chromosome the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder chromosome(CodeableConcept chromosome) {
                    this.chromosome = chromosome;
                    return this;
                }

                /**
                 * Sets {@code sequence} to a CodeableConcept.
                 *
                 * @param sequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder sequence(CodeableConcept sequence) {
                    this.sequence = sequence;
                    return this;
                }

                /**
                 * Sets {@code sequence} to a string.
                 *
                 * @param sequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder sequence(FhirString sequence) {
                    this.sequence = sequence;
                    return this;
                }

                /**
                 * Sets {@code sequence} to a Reference.
                 *
                 * @param sequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder sequence(Reference sequence) {
                    this.sequence = sequence;
                    return this;
                }

                /**
                 * Sets {@code sequence} to a string without id or extensions.
                 *
                 * @param sequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder sequence(String sequence) {
                    this.sequence = sequence == null ? null : FhirString.of(sequence);
                    return this;
                }

                /**
                 * Sets {@code windowStart}.
                 *
                 * @param windowStart the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder windowStart(FhirInteger windowStart) {
                    this.windowStart = windowStart;
                    return this;
                }

                /**
                 * Sets {@code windowStart}, wrapped in a {@link FhirInteger} without id or extensions.
                 *
                 * @param windowStart the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder windowStart(Integer windowStart) {
                    return windowStart(windowStart == null ? null : FhirInteger.of(windowStart));
                }

                /**
                 * Sets {@code windowEnd}.
                 *
                 * @param windowEnd the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder windowEnd(FhirInteger windowEnd) {
                    this.windowEnd = windowEnd;
                    return this;
                }

                /**
                 * Sets {@code windowEnd}, wrapped in a {@link FhirInteger} without id or extensions.
                 *
                 * @param windowEnd the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder windowEnd(Integer windowEnd) {
                    return windowEnd(windowEnd == null ? null : FhirInteger.of(windowEnd));
                }

                /**
                 * Sets {@code orientation}.
                 *
                 * @param orientation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder orientation(FhirEnum<OrientationType> orientation) {
                    this.orientation = orientation;
                    return this;
                }

                /**
                 * Sets {@code orientation}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param orientation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder orientation(OrientationType orientation) {
                    return orientation(orientation == null ? null : FhirEnum.of(orientation));
                }

                /**
                 * Sets {@code strand}.
                 *
                 * @param strand the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder strand(FhirEnum<StrandType> strand) {
                    this.strand = strand;
                    return this;
                }

                /**
                 * Sets {@code strand}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param strand the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder strand(StrandType strand) {
                    return strand(strand == null ? null : FhirEnum.of(strand));
                }

                /**
                 * Builds the {@code StartingSequence}.
                 *
                 * @return the {@code StartingSequence}
                 */
                public StartingSequence build() {
                    return new StartingSequence(
                            id, extension, modifierExtension, genomeAssembly, chromosome, sequence, windowStart,
                            windowEnd, orientation, strand);
                }
            }
        }

        /**
         * Changes in sequence from the starting sequence.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param start Start position of the edit on the starting sequence.
         * @param end End position of the edit on the starting sequence.
         * @param replacementSequence Allele that was observed.
         * @param replacedSequence Allele in the starting sequence.
         */
        public record Edit(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirInteger start,
                FhirInteger end,
                FhirString replacementSequence,
                FhirString replacedSequence) implements BackboneElement {

            /**
             * Creates an {@code Edit}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Edit {
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
             * Returns a builder initialized with the values of this {@code Edit}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Edit}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirInteger start;
                private FhirInteger end;
                private FhirString replacementSequence;
                private FhirString replacedSequence;

                private Builder() {
                }

                private Builder(Edit original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.start = original.start();
                    this.end = original.end();
                    this.replacementSequence = original.replacementSequence();
                    this.replacedSequence = original.replacedSequence();
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
                 * Sets {@code start}.
                 *
                 * @param start the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder start(FhirInteger start) {
                    this.start = start;
                    return this;
                }

                /**
                 * Sets {@code start}, wrapped in a {@link FhirInteger} without id or extensions.
                 *
                 * @param start the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder start(Integer start) {
                    return start(start == null ? null : FhirInteger.of(start));
                }

                /**
                 * Sets {@code end}.
                 *
                 * @param end the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder end(FhirInteger end) {
                    this.end = end;
                    return this;
                }

                /**
                 * Sets {@code end}, wrapped in a {@link FhirInteger} without id or extensions.
                 *
                 * @param end the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder end(Integer end) {
                    return end(end == null ? null : FhirInteger.of(end));
                }

                /**
                 * Sets {@code replacementSequence}.
                 *
                 * @param replacementSequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder replacementSequence(FhirString replacementSequence) {
                    this.replacementSequence = replacementSequence;
                    return this;
                }

                /**
                 * Sets {@code replacementSequence}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param replacementSequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder replacementSequence(String replacementSequence) {
                    return replacementSequence(
                            replacementSequence == null ? null : FhirString.of(replacementSequence));
                }

                /**
                 * Sets {@code replacedSequence}.
                 *
                 * @param replacedSequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder replacedSequence(FhirString replacedSequence) {
                    this.replacedSequence = replacedSequence;
                    return this;
                }

                /**
                 * Sets {@code replacedSequence}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param replacedSequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder replacedSequence(String replacedSequence) {
                    return replacedSequence(replacedSequence == null ? null : FhirString.of(replacedSequence));
                }

                /**
                 * Builds the {@code Edit}.
                 *
                 * @return the {@code Edit}
                 */
                public Edit build() {
                    return new Edit(
                            id, extension, modifierExtension, start, end, replacementSequence, replacedSequence);
                }
            }
        }

        /** Builder for {@link Relative}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept coordinateSystem;
            private FhirInteger ordinalPosition;
            private Range sequenceRange;
            private StartingSequence startingSequence;
            private List<Edit> edit = new ArrayList<>();

            private Builder() {
            }

            private Builder(Relative original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.coordinateSystem = original.coordinateSystem();
                this.ordinalPosition = original.ordinalPosition();
                this.sequenceRange = original.sequenceRange();
                this.startingSequence = original.startingSequence();
                this.edit = new ArrayList<>(original.edit());
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
             * Sets {@code coordinateSystem}.
             *
             * @param coordinateSystem the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder coordinateSystem(CodeableConcept coordinateSystem) {
                this.coordinateSystem = coordinateSystem;
                return this;
            }

            /**
             * Sets {@code ordinalPosition}.
             *
             * @param ordinalPosition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder ordinalPosition(FhirInteger ordinalPosition) {
                this.ordinalPosition = ordinalPosition;
                return this;
            }

            /**
             * Sets {@code ordinalPosition}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param ordinalPosition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder ordinalPosition(Integer ordinalPosition) {
                return ordinalPosition(ordinalPosition == null ? null : FhirInteger.of(ordinalPosition));
            }

            /**
             * Sets {@code sequenceRange}.
             *
             * @param sequenceRange the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequenceRange(Range sequenceRange) {
                this.sequenceRange = sequenceRange;
                return this;
            }

            /**
             * Sets {@code startingSequence}.
             *
             * @param startingSequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder startingSequence(StartingSequence startingSequence) {
                this.startingSequence = startingSequence;
                return this;
            }

            /**
             * Replaces all {@code edit} values.
             *
             * @param edit the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder edit(List<Edit> edit) {
                this.edit = edit == null ? new ArrayList<>() : new ArrayList<>(edit);
                return this;
            }

            /**
             * Adds a {@code edit} value.
             *
             * @param edit the value to add
             * @return this builder
             */
            public Builder addEdit(Edit edit) {
                this.edit.add(Objects.requireNonNull(edit, "edit"));
                return this;
            }

            /**
             * Builds the {@code Relative}.
             *
             * @return the {@code Relative}
             * @throws NullPointerException if a required element is absent
             */
            public Relative build() {
                return new Relative(
                        id, extension, modifierExtension, coordinateSystem, ordinalPosition, sequenceRange,
                        startingSequence, edit);
            }
        }
    }

    /** Builder for {@link MolecularSequence}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<SequenceType> type;
        private Reference subject;
        private List<Reference> focus = new ArrayList<>();
        private Reference specimen;
        private Reference device;
        private Reference performer;
        private FhirString literal;
        private List<Attachment> formatted = new ArrayList<>();
        private List<Relative> relative = new ArrayList<>();

        private Builder() {
        }

        private Builder(MolecularSequence original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.type = original.type();
            this.subject = original.subject();
            this.focus = new ArrayList<>(original.focus());
            this.specimen = original.specimen();
            this.device = original.device();
            this.performer = original.performer();
            this.literal = original.literal();
            this.formatted = new ArrayList<>(original.formatted());
            this.relative = new ArrayList<>(original.relative());
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
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<SequenceType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(SequenceType type) {
            return type(type == null ? null : FhirEnum.of(type));
        }

        /**
         * Sets {@code subject}.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(Reference subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Replaces all {@code focus} values.
         *
         * @param focus the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder focus(List<Reference> focus) {
            this.focus = focus == null ? new ArrayList<>() : new ArrayList<>(focus);
            return this;
        }

        /**
         * Adds a {@code focus} value.
         *
         * @param focus the value to add
         * @return this builder
         */
        public Builder addFocus(Reference focus) {
            this.focus.add(Objects.requireNonNull(focus, "focus"));
            return this;
        }

        /**
         * Sets {@code specimen}.
         *
         * @param specimen the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder specimen(Reference specimen) {
            this.specimen = specimen;
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
         * Sets {@code performer}.
         *
         * @param performer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder performer(Reference performer) {
            this.performer = performer;
            return this;
        }

        /**
         * Sets {@code literal}.
         *
         * @param literal the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder literal(FhirString literal) {
            this.literal = literal;
            return this;
        }

        /**
         * Sets {@code literal}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param literal the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder literal(String literal) {
            return literal(literal == null ? null : FhirString.of(literal));
        }

        /**
         * Replaces all {@code formatted} values.
         *
         * @param formatted the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder formatted(List<Attachment> formatted) {
            this.formatted = formatted == null ? new ArrayList<>() : new ArrayList<>(formatted);
            return this;
        }

        /**
         * Adds a {@code formatted} value.
         *
         * @param formatted the value to add
         * @return this builder
         */
        public Builder addFormatted(Attachment formatted) {
            this.formatted.add(Objects.requireNonNull(formatted, "formatted"));
            return this;
        }

        /**
         * Replaces all {@code relative} values.
         *
         * @param relative the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relative(List<Relative> relative) {
            this.relative = relative == null ? new ArrayList<>() : new ArrayList<>(relative);
            return this;
        }

        /**
         * Adds a {@code relative} value.
         *
         * @param relative the value to add
         * @return this builder
         */
        public Builder addRelative(Relative relative) {
            this.relative.add(Objects.requireNonNull(relative, "relative"));
            return this;
        }

        /**
         * Builds the {@code MolecularSequence}.
         *
         * @return the {@code MolecularSequence}
         */
        public MolecularSequence build() {
            return new MolecularSequence(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    type, subject, focus, specimen, device, performer, literal, formatted, relative);
        }
    }
}
