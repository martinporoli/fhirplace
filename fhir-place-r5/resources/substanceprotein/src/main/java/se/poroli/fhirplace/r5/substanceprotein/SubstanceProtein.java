package se.poroli.fhirplace.r5.substanceprotein;

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
 * A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that
 * are either covalently linked or have a defined invariant stoichiometric relationship.
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
 * @param sequenceType The SubstanceProtein descriptive elements will only be used when a complete or partial amino
 *   acid sequence is available or derivable from a nucleic acid sequence.
 * @param numberOfSubunits Number of linear sequences of amino acids linked through peptide bonds. The number of
 *   subunits constituting the SubstanceProtein shall be described. It is possible that the number of subunits can be
 *   variable.
 * @param disulfideLinkage The disulphide bond between two cysteine residues either on the same subunit or on two
 *   different subunits shall be described. The position of the disulfide bonds in the SubstanceProtein shall be
 *   listed in increasing order of subunit number and position within subunit followed by the abbreviation of the
 *   amino acids involved. The disulfide linkage positions shall actually contain the amino acid Cysteine at the
 *   respective positions.
 * @param subunit This subclause refers to the description of each subunit constituting the SubstanceProtein. A
 *   subunit is a linear sequence of amino acids linked through peptide bonds. The Subunit information shall be
 *   provided when the finished SubstanceProtein is a complex of multiple sequences; subunits are not used to
 *   delineate domains within a single sequence. Subunits are listed in order of decreasing length; sequences of the
 *   same length will be ordered by decreasing molecular weight; subunits that have identical sequences will be
 *   repeated multiple times.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/SubstanceProtein">FHIR R5 SubstanceProtein</a>
 */
public record SubstanceProtein(
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
        List<FhirString> disulfideLinkage,
        List<Subunit> subunit) implements DomainResource {

    /**
     * Creates a {@code SubstanceProtein}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public SubstanceProtein {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        disulfideLinkage = disulfideLinkage == null ? List.of() : List.copyOf(disulfideLinkage);
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
     * Returns a builder initialized with the values of this {@code SubstanceProtein}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * This subclause refers to the description of each subunit constituting the SubstanceProtein.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param subunit Index of primary sequences of amino acids linked through peptide bonds in order of decreasing
     *   length. Sequences of the same length will be ordered by molecular weight. Subunits that have identical
     *   sequences will be repeated and have sequential subscripts.
     * @param sequence The sequence information shall be provided enumerating the amino acids from N- to C-terminal
     *   end using standard single-letter amino acid codes. Uppercase shall be used for L-amino acids and lowercase
     *   for D-amino acids. Transcribed SubstanceProteins will always be described using the translated sequence; for
     *   synthetic peptide containing amino acids that are not represented with a single letter code an X should be
     *   used within the sequence. The modified amino acids will be distinguished by their position in the sequence.
     * @param length Length of linear sequences of amino acids contained in the subunit.
     * @param sequenceAttachment The sequence information shall be provided enumerating the amino acids from N- to
     *   C-terminal end using standard single-letter amino acid codes. Uppercase shall be used for L-amino acids and
     *   lowercase for D-amino acids. Transcribed SubstanceProteins will always be described using the translated
     *   sequence; for synthetic peptide containing amino acids that are not represented with a single letter code an
     *   X should be used within the sequence. The modified amino acids will be distinguished by their position in the
     *   sequence.
     * @param nTerminalModificationId Unique identifier for molecular fragment modification based on the ISO 11238
     *   Substance ID.
     * @param nTerminalModification The name of the fragment modified at the N-terminal of the SubstanceProtein shall
     *   be specified.
     * @param cTerminalModificationId Unique identifier for molecular fragment modification based on the ISO 11238
     *   Substance ID.
     * @param cTerminalModification The modification at the C-terminal shall be specified.
     */
    public record Subunit(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirInteger subunit,
            FhirString sequence,
            FhirInteger length,
            Attachment sequenceAttachment,
            Identifier nTerminalModificationId,
            FhirString nTerminalModification,
            Identifier cTerminalModificationId,
            FhirString cTerminalModification) implements BackboneElement {

        /**
         * Creates a {@code Subunit}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Subunit {
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
         * Returns a builder initialized with the values of this {@code Subunit}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
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
            private Identifier nTerminalModificationId;
            private FhirString nTerminalModification;
            private Identifier cTerminalModificationId;
            private FhirString cTerminalModification;

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
                this.nTerminalModificationId = original.nTerminalModificationId();
                this.nTerminalModification = original.nTerminalModification();
                this.cTerminalModificationId = original.cTerminalModificationId();
                this.cTerminalModification = original.cTerminalModification();
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
             * Sets {@code nTerminalModificationId}.
             *
             * @param nTerminalModificationId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder nTerminalModificationId(Identifier nTerminalModificationId) {
                this.nTerminalModificationId = nTerminalModificationId;
                return this;
            }

            /**
             * Sets {@code nTerminalModification}.
             *
             * @param nTerminalModification the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder nTerminalModification(FhirString nTerminalModification) {
                this.nTerminalModification = nTerminalModification;
                return this;
            }

            /**
             * Sets {@code nTerminalModification}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param nTerminalModification the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder nTerminalModification(String nTerminalModification) {
                return nTerminalModification(
                        nTerminalModification == null ? null : FhirString.of(nTerminalModification));
            }

            /**
             * Sets {@code cTerminalModificationId}.
             *
             * @param cTerminalModificationId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder cTerminalModificationId(Identifier cTerminalModificationId) {
                this.cTerminalModificationId = cTerminalModificationId;
                return this;
            }

            /**
             * Sets {@code cTerminalModification}.
             *
             * @param cTerminalModification the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder cTerminalModification(FhirString cTerminalModification) {
                this.cTerminalModification = cTerminalModification;
                return this;
            }

            /**
             * Sets {@code cTerminalModification}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param cTerminalModification the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder cTerminalModification(String cTerminalModification) {
                return cTerminalModification(
                        cTerminalModification == null ? null : FhirString.of(cTerminalModification));
            }

            /**
             * Builds the {@code Subunit}.
             *
             * @return the {@code Subunit}
             */
            public Subunit build() {
                return new Subunit(
                        id, extension, modifierExtension, subunit, sequence, length, sequenceAttachment,
                        nTerminalModificationId, nTerminalModification, cTerminalModificationId,
                        cTerminalModification);
            }
        }
    }

    /** Builder for {@link SubstanceProtein}. Builders are mutable and not thread-safe. */
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
        private List<FhirString> disulfideLinkage = new ArrayList<>();
        private List<Subunit> subunit = new ArrayList<>();

        private Builder() {
        }

        private Builder(SubstanceProtein original) {
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
            this.disulfideLinkage = new ArrayList<>(original.disulfideLinkage());
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
         * Replaces all {@code disulfideLinkage} values.
         *
         * @param disulfideLinkage the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder disulfideLinkage(List<FhirString> disulfideLinkage) {
            this.disulfideLinkage = disulfideLinkage == null ? new ArrayList<>() : new ArrayList<>(disulfideLinkage);
            return this;
        }

        /**
         * Adds a {@code disulfideLinkage} value.
         *
         * @param disulfideLinkage the value to add
         * @return this builder
         */
        public Builder addDisulfideLinkage(FhirString disulfideLinkage) {
            this.disulfideLinkage.add(Objects.requireNonNull(disulfideLinkage, "disulfideLinkage"));
            return this;
        }

        /**
         * Adds a {@code disulfideLinkage} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param disulfideLinkage the value to add
         * @return this builder
         */
        public Builder addDisulfideLinkage(String disulfideLinkage) {
            return addDisulfideLinkage(FhirString.of(disulfideLinkage));
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
         * Builds the {@code SubstanceProtein}.
         *
         * @return the {@code SubstanceProtein}
         */
        public SubstanceProtein build() {
            return new SubstanceProtein(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, sequenceType,
                    numberOfSubunits, disulfideLinkage, subunit);
        }
    }
}
