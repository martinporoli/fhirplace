package se.poroli.fhirplace.r5.substancenucleicacid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;

/**
 * Nucleic acids are defined by three distinct elements: the base, sugar and linkage.
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
 * @param sequenceType The type of the sequence shall be specified based on a controlled vocabulary.
 * @param numberOfSubunits The number of linear sequences of nucleotides linked through phosphodiester bonds shall be
 *   described. Subunits would be strands of nucleic acids that are tightly associated typically through Watson-Crick
 *   base pairing. NOTE: If not specified in the reference source, the assumption is that there is 1 subunit.
 * @param areaOfHybridisation The area of hybridisation shall be described if applicable for double stranded RNA or
 *   DNA. The number associated with the subunit followed by the number associated to the residue shall be specified
 *   in increasing order. The underscore “” shall be used as separator as follows: “Subunitnumber Residue”.
 * @param oligoNucleotideType (TBC).
 * @param subunit Subunits are listed in order of decreasing length; sequences of the same length will be ordered by
 *   molecular weight; subunits that have identical sequences will be repeated multiple times.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/SubstanceNucleicAcid">FHIR R5 SubstanceNucleicAcid</a>
 */
public record SubstanceNucleicAcid(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        CodeableConcept sequenceType,
        FhirInteger numberOfSubunits,
        FhirString areaOfHybridisation,
        CodeableConcept oligoNucleotideType,
        List<Subunit> subunit) implements DomainResource {

    /**
     * Creates a {@code SubstanceNucleicAcid}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public SubstanceNucleicAcid {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        subunit = subunit == null ? List.of() : List.copyOf(subunit);
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
     * Returns a builder initialized with the values of this {@code SubstanceNucleicAcid}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Subunits are listed in order of decreasing length; sequences of the same length will be ordered by molecular
     * weight; subunits that have identical sequences will be repeated multiple times.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param subunit Index of linear sequences of nucleic acids in order of decreasing length. Sequences of the same
     *   length will be ordered by molecular weight. Subunits that have identical sequences will be repeated and have
     *   sequential subscripts.
     * @param sequence Actual nucleotide sequence notation from 5' to 3' end using standard single letter codes. In
     *   addition to the base sequence, sugar and type of phosphate or non-phosphate linkage should also be captured.
     * @param length The length of the sequence shall be captured.
     * @param sequenceAttachment (TBC).
     * @param fivePrime The nucleotide present at the 5’ terminal shall be specified based on a controlled vocabulary.
     *   Since the sequence is represented from the 5' to the 3' end, the 5’ prime nucleotide is the letter at the
     *   first position in the sequence. A separate representation would be redundant.
     * @param threePrime The nucleotide present at the 3’ terminal shall be specified based on a controlled
     *   vocabulary. Since the sequence is represented from the 5' to the 3' end, the 5’ prime nucleotide is the
     *   letter at the last position in the sequence. A separate representation would be redundant.
     * @param linkage The linkages between sugar residues will also be captured.
     * @param sugar 5.3.6.8.1 Sugar ID (Mandatory).
     */
    public record Subunit(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirInteger subunit,
            FhirString sequence,
            FhirInteger length,
            Attachment sequenceAttachment,
            CodeableConcept fivePrime,
            CodeableConcept threePrime,
            List<Linkage> linkage,
            List<Sugar> sugar) implements BackboneElement {

        /**
         * Creates a {@code Subunit}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Subunit {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            linkage = linkage == null ? List.of() : List.copyOf(linkage);
            sugar = sugar == null ? List.of() : List.copyOf(sugar);
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
         * Returns a builder initialized with the values of this {@code Subunit}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The linkages between sugar residues will also be captured.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param connectivity The entity that links the sugar residues together should also be captured for nearly
         *   all naturally occurring nucleic acid the linkage is a phosphate group. For many synthetic
         *   oligonucleotides phosphorothioate linkages are often seen. Linkage connectivity is assumed to be 3’-5’.
         *   If the linkage is either 3’-3’ or 5’-5’ this should be specified.
         * @param identifier Each linkage will be registered as a fragment and have an ID.
         * @param name Each linkage will be registered as a fragment and have at least one name. A single name shall
         *   be assigned to each linkage.
         * @param residueSite Residues shall be captured as described in 5.3.6.8.3.
         */
        public record Linkage(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString connectivity,
                Identifier identifier,
                FhirString name,
                FhirString residueSite) implements BackboneElement {

            /**
             * Creates a {@code Linkage}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Linkage {
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
             * Returns a builder initialized with the values of this {@code Linkage}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Linkage}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString connectivity;
                private Identifier identifier;
                private FhirString name;
                private FhirString residueSite;

                private Builder() {
                }

                private Builder(Linkage original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.connectivity = original.connectivity();
                    this.identifier = original.identifier();
                    this.name = original.name();
                    this.residueSite = original.residueSite();
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
                 * Sets {@code connectivity}.
                 *
                 * @param connectivity the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder connectivity(FhirString connectivity) {
                    this.connectivity = connectivity;
                    return this;
                }

                /**
                 * Sets {@code connectivity}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param connectivity the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder connectivity(String connectivity) {
                    return connectivity(connectivity == null ? null : FhirString.of(connectivity));
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
                 * Sets {@code residueSite}.
                 *
                 * @param residueSite the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder residueSite(FhirString residueSite) {
                    this.residueSite = residueSite;
                    return this;
                }

                /**
                 * Sets {@code residueSite}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param residueSite the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder residueSite(String residueSite) {
                    return residueSite(residueSite == null ? null : FhirString.of(residueSite));
                }

                /**
                 * Builds the {@code Linkage}.
                 *
                 * @return the {@code Linkage}
                 */
                public Linkage build() {
                    return new Linkage(
                            id, extension, modifierExtension, connectivity, identifier, name, residueSite);
                }
            }
        }

        /**
         * 5.3.6.8.1 Sugar ID (Mandatory).
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param identifier The Substance ID of the sugar or sugar-like component that make up the nucleotide.
         * @param name The name of the sugar or sugar-like component that make up the nucleotide.
         * @param residueSite The residues that contain a given sugar will be captured. The order of given residues
         *   will be captured in the 5‘-3‘direction consistent with the base sequences listed above.
         */
        public record Sugar(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Identifier identifier,
                FhirString name,
                FhirString residueSite) implements BackboneElement {

            /**
             * Creates a {@code Sugar}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Sugar {
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
             * Returns a builder initialized with the values of this {@code Sugar}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Sugar}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Identifier identifier;
                private FhirString name;
                private FhirString residueSite;

                private Builder() {
                }

                private Builder(Sugar original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.identifier = original.identifier();
                    this.name = original.name();
                    this.residueSite = original.residueSite();
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
                 * Sets {@code residueSite}.
                 *
                 * @param residueSite the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder residueSite(FhirString residueSite) {
                    this.residueSite = residueSite;
                    return this;
                }

                /**
                 * Sets {@code residueSite}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param residueSite the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder residueSite(String residueSite) {
                    return residueSite(residueSite == null ? null : FhirString.of(residueSite));
                }

                /**
                 * Builds the {@code Sugar}.
                 *
                 * @return the {@code Sugar}
                 */
                public Sugar build() {
                    return new Sugar(
                            id, extension, modifierExtension, identifier, name, residueSite);
                }
            }
        }

        /** Builder for {@link Subunit}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirInteger subunit;
            private FhirString sequence;
            private FhirInteger length;
            private Attachment sequenceAttachment;
            private CodeableConcept fivePrime;
            private CodeableConcept threePrime;
            private List<Linkage> linkage = new ArrayList<>();
            private List<Sugar> sugar = new ArrayList<>();

            private Builder() {
            }

            private Builder(Subunit original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.subunit = original.subunit();
                this.sequence = original.sequence();
                this.length = original.length();
                this.sequenceAttachment = original.sequenceAttachment();
                this.fivePrime = original.fivePrime();
                this.threePrime = original.threePrime();
                this.linkage = new ArrayList<>(original.linkage());
                this.sugar = new ArrayList<>(original.sugar());
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
             * Sets {@code subunit}.
             *
             * @param subunit the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subunit(FhirInteger subunit) {
                this.subunit = subunit;
                return this;
            }

            /**
             * Sets {@code subunit}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param subunit the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subunit(Integer subunit) {
                return subunit(subunit == null ? null : FhirInteger.of(subunit));
            }

            /**
             * Sets {@code sequence}.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(FhirString sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Sets {@code sequence}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(String sequence) {
                return sequence(sequence == null ? null : FhirString.of(sequence));
            }

            /**
             * Sets {@code length}.
             *
             * @param length the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder length(FhirInteger length) {
                this.length = length;
                return this;
            }

            /**
             * Sets {@code length}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param length the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder length(Integer length) {
                return length(length == null ? null : FhirInteger.of(length));
            }

            /**
             * Sets {@code sequenceAttachment}.
             *
             * @param sequenceAttachment the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequenceAttachment(Attachment sequenceAttachment) {
                this.sequenceAttachment = sequenceAttachment;
                return this;
            }

            /**
             * Sets {@code fivePrime}.
             *
             * @param fivePrime the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder fivePrime(CodeableConcept fivePrime) {
                this.fivePrime = fivePrime;
                return this;
            }

            /**
             * Sets {@code threePrime}.
             *
             * @param threePrime the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder threePrime(CodeableConcept threePrime) {
                this.threePrime = threePrime;
                return this;
            }

            /**
             * Replaces all {@code linkage} values.
             *
             * @param linkage the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder linkage(List<Linkage> linkage) {
                this.linkage = linkage == null ? new ArrayList<>() : new ArrayList<>(linkage);
                return this;
            }

            /**
             * Adds a {@code linkage} value.
             *
             * @param linkage the value to add
             * @return this builder
             */
            public Builder addLinkage(Linkage linkage) {
                this.linkage.add(Objects.requireNonNull(linkage, "linkage"));
                return this;
            }

            /**
             * Replaces all {@code sugar} values.
             *
             * @param sugar the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder sugar(List<Sugar> sugar) {
                this.sugar = sugar == null ? new ArrayList<>() : new ArrayList<>(sugar);
                return this;
            }

            /**
             * Adds a {@code sugar} value.
             *
             * @param sugar the value to add
             * @return this builder
             */
            public Builder addSugar(Sugar sugar) {
                this.sugar.add(Objects.requireNonNull(sugar, "sugar"));
                return this;
            }

            /**
             * Builds the {@code Subunit}.
             *
             * @return the {@code Subunit}
             */
            public Subunit build() {
                return new Subunit(
                        id, extension, modifierExtension, subunit, sequence, length, sequenceAttachment, fivePrime,
                        threePrime, linkage, sugar);
            }
        }
    }

    /** Builder for {@link SubstanceNucleicAcid}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private CodeableConcept sequenceType;
        private FhirInteger numberOfSubunits;
        private FhirString areaOfHybridisation;
        private CodeableConcept oligoNucleotideType;
        private List<Subunit> subunit = new ArrayList<>();

        private Builder() {
        }

        private Builder(SubstanceNucleicAcid original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.sequenceType = original.sequenceType();
            this.numberOfSubunits = original.numberOfSubunits();
            this.areaOfHybridisation = original.areaOfHybridisation();
            this.oligoNucleotideType = original.oligoNucleotideType();
            this.subunit = new ArrayList<>(original.subunit());
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
         * Sets {@code sequenceType}.
         *
         * @param sequenceType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sequenceType(CodeableConcept sequenceType) {
            this.sequenceType = sequenceType;
            return this;
        }

        /**
         * Sets {@code numberOfSubunits}.
         *
         * @param numberOfSubunits the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder numberOfSubunits(FhirInteger numberOfSubunits) {
            this.numberOfSubunits = numberOfSubunits;
            return this;
        }

        /**
         * Sets {@code numberOfSubunits}, wrapped in a {@link FhirInteger} without id or extensions.
         *
         * @param numberOfSubunits the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder numberOfSubunits(Integer numberOfSubunits) {
            return numberOfSubunits(numberOfSubunits == null ? null : FhirInteger.of(numberOfSubunits));
        }

        /**
         * Sets {@code areaOfHybridisation}.
         *
         * @param areaOfHybridisation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder areaOfHybridisation(FhirString areaOfHybridisation) {
            this.areaOfHybridisation = areaOfHybridisation;
            return this;
        }

        /**
         * Sets {@code areaOfHybridisation}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param areaOfHybridisation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder areaOfHybridisation(String areaOfHybridisation) {
            return areaOfHybridisation(areaOfHybridisation == null ? null : FhirString.of(areaOfHybridisation));
        }

        /**
         * Sets {@code oligoNucleotideType}.
         *
         * @param oligoNucleotideType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder oligoNucleotideType(CodeableConcept oligoNucleotideType) {
            this.oligoNucleotideType = oligoNucleotideType;
            return this;
        }

        /**
         * Replaces all {@code subunit} values.
         *
         * @param subunit the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder subunit(List<Subunit> subunit) {
            this.subunit = subunit == null ? new ArrayList<>() : new ArrayList<>(subunit);
            return this;
        }

        /**
         * Adds a {@code subunit} value.
         *
         * @param subunit the value to add
         * @return this builder
         */
        public Builder addSubunit(Subunit subunit) {
            this.subunit.add(Objects.requireNonNull(subunit, "subunit"));
            return this;
        }

        /**
         * Builds the {@code SubstanceNucleicAcid}.
         *
         * @return the {@code SubstanceNucleicAcid}
         */
        public SubstanceNucleicAcid build() {
            return new SubstanceNucleicAcid(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, sequenceType,
                    numberOfSubunits, areaOfHybridisation, oligoNucleotideType, subunit);
        }
    }
}
