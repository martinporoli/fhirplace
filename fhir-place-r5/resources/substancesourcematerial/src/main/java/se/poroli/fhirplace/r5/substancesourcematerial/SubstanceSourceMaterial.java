package se.poroli.fhirplace.r5.substancesourcematerial;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;

/**
 * Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a
 * material that can result in or can be modified to form a substance.
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
 * @param sourceMaterialClass General high level classification of the source material specific to the origin of the
 *   material.
 * @param sourceMaterialType The type of the source material shall be specified based on a controlled vocabulary. For
 *   vaccines, this subclause refers to the class of infectious agent.
 * @param sourceMaterialState The state of the source material when extracted.
 * @param organismId The unique identifier associated with the source material parent organism shall be specified.
 * @param organismName The organism accepted Scientific name shall be provided based on the organism taxonomy.
 * @param parentSubstanceId The parent of the herbal drug Ginkgo biloba, Leaf is the substance ID of the substance
 *   (fresh) of Ginkgo biloba L. or Ginkgo biloba L. (Whole plant).
 * @param parentSubstanceName The parent substance of the Herbal Drug, or Herbal preparation.
 * @param countryOfOrigin The country where the plant material is harvested or the countries where the plasma is
 *   sourced from as laid down in accordance with the Plasma Master File. For “Plasma-derived substances” the
 *   attribute country of origin provides information about the countries used for the manufacturing of the Cryopoor
 *   plama or Crioprecipitate.
 * @param geographicalLocation The place/region where the plant is harvested or the places/regions where the animal
 *   source material has its habitat.
 * @param developmentStage Stage of life for animals, plants, insects and microorganisms. This information shall be
 *   provided only when the substance is significantly different in these stages (e.g. foetal bovine serum).
 * @param fractionDescription Many complex materials are fractions of parts of plants, animals, or minerals. Fraction
 *   elements are often necessary to define both Substances and Specified Group 1 Substances. For substances derived
 *   from Plants, fraction information will be captured at the Substance information level ( . Oils, Juices and
 *   Exudates). Additional information for Extracts, such as extraction solvent composition, will be captured at the
 *   Specified Substance Group 1 information level. For plasma-derived products fraction information will be captured
 *   at the Substance and the Specified Substance Group 1 levels.
 * @param organism This subclause describes the organism which the substance is derived from. For vaccines, the parent
 *   organism shall be specified based on these subclause elements. As an example, full taxonomy will be described for
 *   the Substance Name: ., Leaf.
 * @param partDescription To do.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/SubstanceSourceMaterial">FHIR R5 SubstanceSourceMaterial</a>
 */
public record SubstanceSourceMaterial(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        CodeableConcept sourceMaterialClass,
        CodeableConcept sourceMaterialType,
        CodeableConcept sourceMaterialState,
        Identifier organismId,
        FhirString organismName,
        List<Identifier> parentSubstanceId,
        List<FhirString> parentSubstanceName,
        List<CodeableConcept> countryOfOrigin,
        List<FhirString> geographicalLocation,
        CodeableConcept developmentStage,
        List<FractionDescription> fractionDescription,
        Organism organism,
        List<PartDescription> partDescription) implements DomainResource {

    /**
     * Creates a {@code SubstanceSourceMaterial}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public SubstanceSourceMaterial {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        parentSubstanceId = parentSubstanceId == null ? List.of() : List.copyOf(parentSubstanceId);
        parentSubstanceName = parentSubstanceName == null ? List.of() : List.copyOf(parentSubstanceName);
        countryOfOrigin = countryOfOrigin == null ? List.of() : List.copyOf(countryOfOrigin);
        geographicalLocation = geographicalLocation == null ? List.of() : List.copyOf(geographicalLocation);
        fractionDescription = fractionDescription == null ? List.of() : List.copyOf(fractionDescription);
        partDescription = partDescription == null ? List.of() : List.copyOf(partDescription);
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
     * Returns a builder initialized with the values of this {@code SubstanceSourceMaterial}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Many complex materials are fractions of parts of plants, animals, or minerals.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param fraction This element is capturing information about the fraction of a plant part, or human plasma for
     *   fractionation.
     * @param materialType The specific type of the material constituting the component. For Herbal preparations the
     *   particulars of the extracts (liquid/dry) is described in Specified Substance Group 1.
     */
    public record FractionDescription(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString fraction,
            CodeableConcept materialType) implements BackboneElement {

        /**
         * Creates a {@code FractionDescription}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public FractionDescription {
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
         * Returns a builder initialized with the values of this {@code FractionDescription}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link FractionDescription}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString fraction;
            private CodeableConcept materialType;

            private Builder() {
            }

            private Builder(FractionDescription original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.fraction = original.fraction();
                this.materialType = original.materialType();
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
             * Sets {@code fraction}.
             *
             * @param fraction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder fraction(FhirString fraction) {
                this.fraction = fraction;
                return this;
            }

            /**
             * Sets {@code fraction}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param fraction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder fraction(String fraction) {
                return fraction(fraction == null ? null : FhirString.of(fraction));
            }

            /**
             * Sets {@code materialType}.
             *
             * @param materialType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder materialType(CodeableConcept materialType) {
                this.materialType = materialType;
                return this;
            }

            /**
             * Builds the {@code FractionDescription}.
             *
             * @return the {@code FractionDescription}
             */
            public FractionDescription build() {
                return new FractionDescription(
                        id, extension, modifierExtension, fraction, materialType);
            }
        }
    }

    /**
     * This subclause describes the organism which the substance is derived from.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param family The family of an organism shall be specified.
     * @param genus The genus of an organism shall be specified; refers to the Latin epithet of the genus element of
     *   the plant/animal scientific name; it is present in names for genera, species and infraspecies.
     * @param species The species of an organism shall be specified; refers to the Latin epithet of the species of the
     *   plant/animal; it is present in names for species and infraspecies.
     * @param intraspecificType The Intraspecific type of an organism shall be specified.
     * @param intraspecificDescription The intraspecific description of an organism shall be specified based on a
     *   controlled vocabulary. For Influenza Vaccine, the intraspecific description shall contain the syntax of the
     *   antigen in line with the WHO convention.
     * @param author 4.9.13.6.1 Author type (Conditional).
     * @param hybrid 4.9.13.8.1 Hybrid species maternal organism ID (Optional).
     * @param organismGeneral 4.9.13.7.1 Kingdom (Conditional).
     */
    public record Organism(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept family,
            CodeableConcept genus,
            CodeableConcept species,
            CodeableConcept intraspecificType,
            FhirString intraspecificDescription,
            List<Author> author,
            Hybrid hybrid,
            OrganismGeneral organismGeneral) implements BackboneElement {

        /**
         * Creates an {@code Organism}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Organism {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            author = author == null ? List.of() : List.copyOf(author);
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
         * Returns a builder initialized with the values of this {@code Organism}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * 4.9.13.6.1 Author type (Conditional).
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param authorType The type of author of an organism species shall be specified. The parenthetical author of
         *   an organism species refers to the first author who published the plant/animal name (of any rank). The
         *   primary author of an organism species refers to the first author(s), who validly published the
         *   plant/animal name.
         * @param authorDescription The author of an organism species shall be specified. The author year of an
         *   organism shall also be specified when applicable; refers to the year in which the first author(s)
         *   published the infraspecific plant/animal name (of any rank).
         */
        public record Author(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept authorType,
                FhirString authorDescription) implements BackboneElement {

            /**
             * Creates an {@code Author}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Author {
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
             * Returns a builder initialized with the values of this {@code Author}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Author}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept authorType;
                private FhirString authorDescription;

                private Builder() {
                }

                private Builder(Author original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.authorType = original.authorType();
                    this.authorDescription = original.authorDescription();
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
                 * Sets {@code authorType}.
                 *
                 * @param authorType the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder authorType(CodeableConcept authorType) {
                    this.authorType = authorType;
                    return this;
                }

                /**
                 * Sets {@code authorDescription}.
                 *
                 * @param authorDescription the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder authorDescription(FhirString authorDescription) {
                    this.authorDescription = authorDescription;
                    return this;
                }

                /**
                 * Sets {@code authorDescription}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param authorDescription the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder authorDescription(String authorDescription) {
                    return authorDescription(authorDescription == null ? null : FhirString.of(authorDescription));
                }

                /**
                 * Builds the {@code Author}.
                 *
                 * @return the {@code Author}
                 */
                public Author build() {
                    return new Author(
                            id, extension, modifierExtension, authorType, authorDescription);
                }
            }
        }

        /**
         * 4.9.13.8.1 Hybrid species maternal organism ID (Optional).
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param maternalOrganismId The identifier of the maternal species constituting the hybrid organism shall be
         *   specified based on a controlled vocabulary. For plants, the parents aren’t always known, and it is
         *   unlikely that it will be known which is maternal and which is paternal.
         * @param maternalOrganismName The name of the maternal species constituting the hybrid organism shall be
         *   specified. For plants, the parents aren’t always known, and it is unlikely that it will be known which is
         *   maternal and which is paternal.
         * @param paternalOrganismId The identifier of the paternal species constituting the hybrid organism shall be
         *   specified based on a controlled vocabulary.
         * @param paternalOrganismName The name of the paternal species constituting the hybrid organism shall be
         *   specified.
         * @param hybridType The hybrid type of an organism shall be specified.
         */
        public record Hybrid(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString maternalOrganismId,
                FhirString maternalOrganismName,
                FhirString paternalOrganismId,
                FhirString paternalOrganismName,
                CodeableConcept hybridType) implements BackboneElement {

            /**
             * Creates a {@code Hybrid}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Hybrid {
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
             * Returns a builder initialized with the values of this {@code Hybrid}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Hybrid}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString maternalOrganismId;
                private FhirString maternalOrganismName;
                private FhirString paternalOrganismId;
                private FhirString paternalOrganismName;
                private CodeableConcept hybridType;

                private Builder() {
                }

                private Builder(Hybrid original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.maternalOrganismId = original.maternalOrganismId();
                    this.maternalOrganismName = original.maternalOrganismName();
                    this.paternalOrganismId = original.paternalOrganismId();
                    this.paternalOrganismName = original.paternalOrganismName();
                    this.hybridType = original.hybridType();
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
                 * Sets {@code maternalOrganismId}.
                 *
                 * @param maternalOrganismId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder maternalOrganismId(FhirString maternalOrganismId) {
                    this.maternalOrganismId = maternalOrganismId;
                    return this;
                }

                /**
                 * Sets {@code maternalOrganismId}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param maternalOrganismId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder maternalOrganismId(String maternalOrganismId) {
                    return maternalOrganismId(maternalOrganismId == null ? null : FhirString.of(maternalOrganismId));
                }

                /**
                 * Sets {@code maternalOrganismName}.
                 *
                 * @param maternalOrganismName the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder maternalOrganismName(FhirString maternalOrganismName) {
                    this.maternalOrganismName = maternalOrganismName;
                    return this;
                }

                /**
                 * Sets {@code maternalOrganismName}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param maternalOrganismName the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder maternalOrganismName(String maternalOrganismName) {
                    return maternalOrganismName(
                            maternalOrganismName == null ? null : FhirString.of(maternalOrganismName));
                }

                /**
                 * Sets {@code paternalOrganismId}.
                 *
                 * @param paternalOrganismId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder paternalOrganismId(FhirString paternalOrganismId) {
                    this.paternalOrganismId = paternalOrganismId;
                    return this;
                }

                /**
                 * Sets {@code paternalOrganismId}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param paternalOrganismId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder paternalOrganismId(String paternalOrganismId) {
                    return paternalOrganismId(paternalOrganismId == null ? null : FhirString.of(paternalOrganismId));
                }

                /**
                 * Sets {@code paternalOrganismName}.
                 *
                 * @param paternalOrganismName the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder paternalOrganismName(FhirString paternalOrganismName) {
                    this.paternalOrganismName = paternalOrganismName;
                    return this;
                }

                /**
                 * Sets {@code paternalOrganismName}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param paternalOrganismName the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder paternalOrganismName(String paternalOrganismName) {
                    return paternalOrganismName(
                            paternalOrganismName == null ? null : FhirString.of(paternalOrganismName));
                }

                /**
                 * Sets {@code hybridType}.
                 *
                 * @param hybridType the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder hybridType(CodeableConcept hybridType) {
                    this.hybridType = hybridType;
                    return this;
                }

                /**
                 * Builds the {@code Hybrid}.
                 *
                 * @return the {@code Hybrid}
                 */
                public Hybrid build() {
                    return new Hybrid(
                            id, extension, modifierExtension, maternalOrganismId, maternalOrganismName,
                            paternalOrganismId, paternalOrganismName, hybridType);
                }
            }
        }

        /**
         * 4.9.13.7.1 Kingdom (Conditional).
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param kingdom The kingdom of an organism shall be specified.
         * @param phylum The phylum of an organism shall be specified.
         * @param classValue The class of an organism shall be specified. The FHIR element {@code class}.
         * @param order The order of an organism shall be specified,.
         */
        public record OrganismGeneral(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept kingdom,
                CodeableConcept phylum,
                CodeableConcept classValue,
                CodeableConcept order) implements BackboneElement {

            /**
             * Creates an {@code OrganismGeneral}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public OrganismGeneral {
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
             * Returns a builder initialized with the values of this {@code OrganismGeneral}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link OrganismGeneral}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept kingdom;
                private CodeableConcept phylum;
                private CodeableConcept classValue;
                private CodeableConcept order;

                private Builder() {
                }

                private Builder(OrganismGeneral original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.kingdom = original.kingdom();
                    this.phylum = original.phylum();
                    this.classValue = original.classValue();
                    this.order = original.order();
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
                 * Sets {@code kingdom}.
                 *
                 * @param kingdom the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder kingdom(CodeableConcept kingdom) {
                    this.kingdom = kingdom;
                    return this;
                }

                /**
                 * Sets {@code phylum}.
                 *
                 * @param phylum the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder phylum(CodeableConcept phylum) {
                    this.phylum = phylum;
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
                 * Sets {@code order}.
                 *
                 * @param order the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder order(CodeableConcept order) {
                    this.order = order;
                    return this;
                }

                /**
                 * Builds the {@code OrganismGeneral}.
                 *
                 * @return the {@code OrganismGeneral}
                 */
                public OrganismGeneral build() {
                    return new OrganismGeneral(
                            id, extension, modifierExtension, kingdom, phylum, classValue, order);
                }
            }
        }

        /** Builder for {@link Organism}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept family;
            private CodeableConcept genus;
            private CodeableConcept species;
            private CodeableConcept intraspecificType;
            private FhirString intraspecificDescription;
            private List<Author> author = new ArrayList<>();
            private Hybrid hybrid;
            private OrganismGeneral organismGeneral;

            private Builder() {
            }

            private Builder(Organism original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.family = original.family();
                this.genus = original.genus();
                this.species = original.species();
                this.intraspecificType = original.intraspecificType();
                this.intraspecificDescription = original.intraspecificDescription();
                this.author = new ArrayList<>(original.author());
                this.hybrid = original.hybrid();
                this.organismGeneral = original.organismGeneral();
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
             * Sets {@code family}.
             *
             * @param family the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder family(CodeableConcept family) {
                this.family = family;
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
             * Sets {@code intraspecificType}.
             *
             * @param intraspecificType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder intraspecificType(CodeableConcept intraspecificType) {
                this.intraspecificType = intraspecificType;
                return this;
            }

            /**
             * Sets {@code intraspecificDescription}.
             *
             * @param intraspecificDescription the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder intraspecificDescription(FhirString intraspecificDescription) {
                this.intraspecificDescription = intraspecificDescription;
                return this;
            }

            /**
             * Sets {@code intraspecificDescription}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param intraspecificDescription the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder intraspecificDescription(String intraspecificDescription) {
                return intraspecificDescription(
                        intraspecificDescription == null ? null : FhirString.of(intraspecificDescription));
            }

            /**
             * Replaces all {@code author} values.
             *
             * @param author the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder author(List<Author> author) {
                this.author = author == null ? new ArrayList<>() : new ArrayList<>(author);
                return this;
            }

            /**
             * Adds a {@code author} value.
             *
             * @param author the value to add
             * @return this builder
             */
            public Builder addAuthor(Author author) {
                this.author.add(Objects.requireNonNull(author, "author"));
                return this;
            }

            /**
             * Sets {@code hybrid}.
             *
             * @param hybrid the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder hybrid(Hybrid hybrid) {
                this.hybrid = hybrid;
                return this;
            }

            /**
             * Sets {@code organismGeneral}.
             *
             * @param organismGeneral the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder organismGeneral(OrganismGeneral organismGeneral) {
                this.organismGeneral = organismGeneral;
                return this;
            }

            /**
             * Builds the {@code Organism}.
             *
             * @return the {@code Organism}
             */
            public Organism build() {
                return new Organism(
                        id, extension, modifierExtension, family, genus, species, intraspecificType,
                        intraspecificDescription, author, hybrid, organismGeneral);
            }
        }
    }

    /**
     * To do.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param part Entity of anatomical origin of source material within an organism.
     * @param partLocation The detailed anatomic location when the part can be extracted from different anatomical
     *   locations of the organism. Multiple alternative locations may apply.
     */
    public record PartDescription(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept part,
            CodeableConcept partLocation) implements BackboneElement {

        /**
         * Creates a {@code PartDescription}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public PartDescription {
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
         * Returns a builder initialized with the values of this {@code PartDescription}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link PartDescription}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept part;
            private CodeableConcept partLocation;

            private Builder() {
            }

            private Builder(PartDescription original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.part = original.part();
                this.partLocation = original.partLocation();
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
             * Sets {@code partLocation}.
             *
             * @param partLocation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder partLocation(CodeableConcept partLocation) {
                this.partLocation = partLocation;
                return this;
            }

            /**
             * Builds the {@code PartDescription}.
             *
             * @return the {@code PartDescription}
             */
            public PartDescription build() {
                return new PartDescription(
                        id, extension, modifierExtension, part, partLocation);
            }
        }
    }

    /** Builder for {@link SubstanceSourceMaterial}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private CodeableConcept sourceMaterialClass;
        private CodeableConcept sourceMaterialType;
        private CodeableConcept sourceMaterialState;
        private Identifier organismId;
        private FhirString organismName;
        private List<Identifier> parentSubstanceId = new ArrayList<>();
        private List<FhirString> parentSubstanceName = new ArrayList<>();
        private List<CodeableConcept> countryOfOrigin = new ArrayList<>();
        private List<FhirString> geographicalLocation = new ArrayList<>();
        private CodeableConcept developmentStage;
        private List<FractionDescription> fractionDescription = new ArrayList<>();
        private Organism organism;
        private List<PartDescription> partDescription = new ArrayList<>();

        private Builder() {
        }

        private Builder(SubstanceSourceMaterial original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.sourceMaterialClass = original.sourceMaterialClass();
            this.sourceMaterialType = original.sourceMaterialType();
            this.sourceMaterialState = original.sourceMaterialState();
            this.organismId = original.organismId();
            this.organismName = original.organismName();
            this.parentSubstanceId = new ArrayList<>(original.parentSubstanceId());
            this.parentSubstanceName = new ArrayList<>(original.parentSubstanceName());
            this.countryOfOrigin = new ArrayList<>(original.countryOfOrigin());
            this.geographicalLocation = new ArrayList<>(original.geographicalLocation());
            this.developmentStage = original.developmentStage();
            this.fractionDescription = new ArrayList<>(original.fractionDescription());
            this.organism = original.organism();
            this.partDescription = new ArrayList<>(original.partDescription());
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
         * Sets {@code sourceMaterialClass}.
         *
         * @param sourceMaterialClass the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sourceMaterialClass(CodeableConcept sourceMaterialClass) {
            this.sourceMaterialClass = sourceMaterialClass;
            return this;
        }

        /**
         * Sets {@code sourceMaterialType}.
         *
         * @param sourceMaterialType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sourceMaterialType(CodeableConcept sourceMaterialType) {
            this.sourceMaterialType = sourceMaterialType;
            return this;
        }

        /**
         * Sets {@code sourceMaterialState}.
         *
         * @param sourceMaterialState the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sourceMaterialState(CodeableConcept sourceMaterialState) {
            this.sourceMaterialState = sourceMaterialState;
            return this;
        }

        /**
         * Sets {@code organismId}.
         *
         * @param organismId the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder organismId(Identifier organismId) {
            this.organismId = organismId;
            return this;
        }

        /**
         * Sets {@code organismName}.
         *
         * @param organismName the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder organismName(FhirString organismName) {
            this.organismName = organismName;
            return this;
        }

        /**
         * Sets {@code organismName}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param organismName the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder organismName(String organismName) {
            return organismName(organismName == null ? null : FhirString.of(organismName));
        }

        /**
         * Replaces all {@code parentSubstanceId} values.
         *
         * @param parentSubstanceId the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder parentSubstanceId(List<Identifier> parentSubstanceId) {
            this.parentSubstanceId = parentSubstanceId == null
                    ? new ArrayList<>()
                    : new ArrayList<>(parentSubstanceId);
            return this;
        }

        /**
         * Adds a {@code parentSubstanceId} value.
         *
         * @param parentSubstanceId the value to add
         * @return this builder
         */
        public Builder addParentSubstanceId(Identifier parentSubstanceId) {
            this.parentSubstanceId.add(Objects.requireNonNull(parentSubstanceId, "parentSubstanceId"));
            return this;
        }

        /**
         * Replaces all {@code parentSubstanceName} values.
         *
         * @param parentSubstanceName the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder parentSubstanceName(List<FhirString> parentSubstanceName) {
            this.parentSubstanceName = parentSubstanceName == null
                    ? new ArrayList<>()
                    : new ArrayList<>(parentSubstanceName);
            return this;
        }

        /**
         * Adds a {@code parentSubstanceName} value.
         *
         * @param parentSubstanceName the value to add
         * @return this builder
         */
        public Builder addParentSubstanceName(FhirString parentSubstanceName) {
            this.parentSubstanceName.add(Objects.requireNonNull(parentSubstanceName, "parentSubstanceName"));
            return this;
        }

        /**
         * Adds a {@code parentSubstanceName} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param parentSubstanceName the value to add
         * @return this builder
         */
        public Builder addParentSubstanceName(String parentSubstanceName) {
            return addParentSubstanceName(FhirString.of(parentSubstanceName));
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
         * Replaces all {@code geographicalLocation} values.
         *
         * @param geographicalLocation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder geographicalLocation(List<FhirString> geographicalLocation) {
            this.geographicalLocation = geographicalLocation == null
                    ? new ArrayList<>()
                    : new ArrayList<>(geographicalLocation);
            return this;
        }

        /**
         * Adds a {@code geographicalLocation} value.
         *
         * @param geographicalLocation the value to add
         * @return this builder
         */
        public Builder addGeographicalLocation(FhirString geographicalLocation) {
            this.geographicalLocation.add(Objects.requireNonNull(geographicalLocation, "geographicalLocation"));
            return this;
        }

        /**
         * Adds a {@code geographicalLocation} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param geographicalLocation the value to add
         * @return this builder
         */
        public Builder addGeographicalLocation(String geographicalLocation) {
            return addGeographicalLocation(FhirString.of(geographicalLocation));
        }

        /**
         * Sets {@code developmentStage}.
         *
         * @param developmentStage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder developmentStage(CodeableConcept developmentStage) {
            this.developmentStage = developmentStage;
            return this;
        }

        /**
         * Replaces all {@code fractionDescription} values.
         *
         * @param fractionDescription the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder fractionDescription(List<FractionDescription> fractionDescription) {
            this.fractionDescription = fractionDescription == null
                    ? new ArrayList<>()
                    : new ArrayList<>(fractionDescription);
            return this;
        }

        /**
         * Adds a {@code fractionDescription} value.
         *
         * @param fractionDescription the value to add
         * @return this builder
         */
        public Builder addFractionDescription(FractionDescription fractionDescription) {
            this.fractionDescription.add(Objects.requireNonNull(fractionDescription, "fractionDescription"));
            return this;
        }

        /**
         * Sets {@code organism}.
         *
         * @param organism the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder organism(Organism organism) {
            this.organism = organism;
            return this;
        }

        /**
         * Replaces all {@code partDescription} values.
         *
         * @param partDescription the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder partDescription(List<PartDescription> partDescription) {
            this.partDescription = partDescription == null ? new ArrayList<>() : new ArrayList<>(partDescription);
            return this;
        }

        /**
         * Adds a {@code partDescription} value.
         *
         * @param partDescription the value to add
         * @return this builder
         */
        public Builder addPartDescription(PartDescription partDescription) {
            this.partDescription.add(Objects.requireNonNull(partDescription, "partDescription"));
            return this;
        }

        /**
         * Builds the {@code SubstanceSourceMaterial}.
         *
         * @return the {@code SubstanceSourceMaterial}
         */
        public SubstanceSourceMaterial build() {
            return new SubstanceSourceMaterial(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension,
                    sourceMaterialClass, sourceMaterialType, sourceMaterialState, organismId, organismName,
                    parentSubstanceId, parentSubstanceName, countryOfOrigin, geographicalLocation, developmentStage,
                    fractionDescription, organism, partDescription);
        }
    }
}
