package se.poroli.fhirplace.r5.specialized.medicationdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * Todo.
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
 * @param comment Todo.
 * @param gene Todo.
 * @param geneElement Todo.
 * @param target Todo.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/SubstanceReferenceInformation">FHIR R5 SubstanceReferenceInformation</a>
 */
public record SubstanceReferenceInformation(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirString comment,
        List<Gene> gene,
        List<GeneElement> geneElement,
        List<Target> target) implements DomainResource {

    /**
     * Creates a {@code SubstanceReferenceInformation}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public SubstanceReferenceInformation {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        gene = gene == null ? List.of() : List.copyOf(gene);
        geneElement = geneElement == null ? List.of() : List.copyOf(geneElement);
        target = target == null ? List.of() : List.copyOf(target);
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
     * Returns a builder initialized with the values of this {@code SubstanceReferenceInformation}.
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
     * @param geneSequenceOrigin Todo.
     * @param gene Todo.
     * @param source Todo. Reference to DocumentReference.
     */
    public record Gene(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept geneSequenceOrigin,
            CodeableConcept gene,
            List<Reference> source) implements BackboneElement {

        /**
         * Creates a {@code Gene}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Gene {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
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
         * Returns a builder initialized with the values of this {@code Gene}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Gene}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept geneSequenceOrigin;
            private CodeableConcept gene;
            private List<Reference> source = new ArrayList<>();

            private Builder() {
            }

            private Builder(Gene original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.geneSequenceOrigin = original.geneSequenceOrigin();
                this.gene = original.gene();
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
             * Sets {@code geneSequenceOrigin}.
             *
             * @param geneSequenceOrigin the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder geneSequenceOrigin(CodeableConcept geneSequenceOrigin) {
                this.geneSequenceOrigin = geneSequenceOrigin;
                return this;
            }

            /**
             * Sets {@code gene}.
             *
             * @param gene the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder gene(CodeableConcept gene) {
                this.gene = gene;
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
             * Builds the {@code Gene}.
             *
             * @return the {@code Gene}
             */
            public Gene build() {
                return new Gene(
                        id, extension, modifierExtension, geneSequenceOrigin, gene, source);
            }
        }
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
     * @param type Todo.
     * @param element Todo.
     * @param source Todo. Reference to DocumentReference.
     */
    public record GeneElement(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            Identifier element,
            List<Reference> source) implements BackboneElement {

        /**
         * Creates a {@code GeneElement}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public GeneElement {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
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
         * Returns a builder initialized with the values of this {@code GeneElement}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link GeneElement}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private Identifier element;
            private List<Reference> source = new ArrayList<>();

            private Builder() {
            }

            private Builder(GeneElement original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.element = original.element();
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
             * Sets {@code element}.
             *
             * @param element the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder element(Identifier element) {
                this.element = element;
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
             * Builds the {@code GeneElement}.
             *
             * @return the {@code GeneElement}
             */
            public GeneElement build() {
                return new GeneElement(
                        id, extension, modifierExtension, type, element, source);
            }
        }
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
     * @param target Todo.
     * @param type Todo.
     * @param interaction Todo.
     * @param organism Todo.
     * @param organismType Todo.
     * @param amount Todo. One of Quantity, Range, string.
     * @param amountType Todo.
     * @param source Todo. Reference to DocumentReference.
     */
    public record Target(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Identifier target,
            CodeableConcept type,
            CodeableConcept interaction,
            CodeableConcept organism,
            CodeableConcept organismType,
            DataType amount,
            CodeableConcept amountType,
            List<Reference> source) implements BackboneElement {

        /**
         * Creates a {@code Target}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Target {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            source = source == null ? List.of() : List.copyOf(source);
            if (amount != null && !(amount instanceof Quantity
                    || amount instanceof Range
                    || amount instanceof FhirString)) {
                throw new IllegalArgumentException(
                        "SubstanceReferenceInformation.target.amount[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code Target}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Target}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Identifier target;
            private CodeableConcept type;
            private CodeableConcept interaction;
            private CodeableConcept organism;
            private CodeableConcept organismType;
            private DataType amount;
            private CodeableConcept amountType;
            private List<Reference> source = new ArrayList<>();

            private Builder() {
            }

            private Builder(Target original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.target = original.target();
                this.type = original.type();
                this.interaction = original.interaction();
                this.organism = original.organism();
                this.organismType = original.organismType();
                this.amount = original.amount();
                this.amountType = original.amountType();
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
             * Sets {@code target}.
             *
             * @param target the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder target(Identifier target) {
                this.target = target;
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
             * Sets {@code interaction}.
             *
             * @param interaction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder interaction(CodeableConcept interaction) {
                this.interaction = interaction;
                return this;
            }

            /**
             * Sets {@code organism}.
             *
             * @param organism the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder organism(CodeableConcept organism) {
                this.organism = organism;
                return this;
            }

            /**
             * Sets {@code organismType}.
             *
             * @param organismType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder organismType(CodeableConcept organismType) {
                this.organismType = organismType;
                return this;
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
             * Sets {@code amount} to a Range.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(Range amount) {
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
             * Sets {@code amountType}.
             *
             * @param amountType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amountType(CodeableConcept amountType) {
                this.amountType = amountType;
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
             * Builds the {@code Target}.
             *
             * @return the {@code Target}
             */
            public Target build() {
                return new Target(
                        id, extension, modifierExtension, target, type, interaction, organism, organismType, amount,
                        amountType, source);
            }
        }
    }

    /** Builder for {@link SubstanceReferenceInformation}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirString comment;
        private List<Gene> gene = new ArrayList<>();
        private List<GeneElement> geneElement = new ArrayList<>();
        private List<Target> target = new ArrayList<>();

        private Builder() {
        }

        private Builder(SubstanceReferenceInformation original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.comment = original.comment();
            this.gene = new ArrayList<>(original.gene());
            this.geneElement = new ArrayList<>(original.geneElement());
            this.target = new ArrayList<>(original.target());
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
         * Sets {@code comment}.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(FhirString comment) {
            this.comment = comment;
            return this;
        }

        /**
         * Sets {@code comment}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(String comment) {
            return comment(comment == null ? null : FhirString.of(comment));
        }

        /**
         * Replaces all {@code gene} values.
         *
         * @param gene the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder gene(List<Gene> gene) {
            this.gene = gene == null ? new ArrayList<>() : new ArrayList<>(gene);
            return this;
        }

        /**
         * Adds a {@code gene} value.
         *
         * @param gene the value to add
         * @return this builder
         */
        public Builder addGene(Gene gene) {
            this.gene.add(Objects.requireNonNull(gene, "gene"));
            return this;
        }

        /**
         * Replaces all {@code geneElement} values.
         *
         * @param geneElement the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder geneElement(List<GeneElement> geneElement) {
            this.geneElement = geneElement == null ? new ArrayList<>() : new ArrayList<>(geneElement);
            return this;
        }

        /**
         * Adds a {@code geneElement} value.
         *
         * @param geneElement the value to add
         * @return this builder
         */
        public Builder addGeneElement(GeneElement geneElement) {
            this.geneElement.add(Objects.requireNonNull(geneElement, "geneElement"));
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
         * Builds the {@code SubstanceReferenceInformation}.
         *
         * @return the {@code SubstanceReferenceInformation}
         */
        public SubstanceReferenceInformation build() {
            return new SubstanceReferenceInformation(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, comment, gene,
                    geneElement, target);
        }
    }
}
