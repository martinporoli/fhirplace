package se.poroli.fhirplace.r5.specimendefinition;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
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
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A kind of specimen with associated set of requirements.
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
 * @param url Logical canonical URL to reference this SpecimenDefinition (globally unique).
 * @param identifier Business identifier.
 * @param version Business version of the SpecimenDefinition.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this {{title}} (computer friendly).
 * @param title Name for this SpecimenDefinition (Human friendly).
 * @param derivedFromCanonical Based on FHIR definition of another SpecimenDefinition. Canonical reference to
 *   SpecimenDefinition.
 * @param derivedFromUri Based on external definition.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental If this SpecimenDefinition is not for real usage.
 * @param subject Type of subject for specimen collection. One of CodeableConcept, Reference.
 * @param date Date status first applied.
 * @param publisher The name of the individual or organization that published the SpecimenDefinition.
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the SpecimenDefinition.
 * @param useContext Content intends to support these contexts.
 * @param jurisdiction Intended jurisdiction for this SpecimenDefinition (if applicable).
 * @param purpose Why this SpecimenDefinition is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param approvalDate When SpecimenDefinition was approved by publisher.
 * @param lastReviewDate The date on which the asset content was last reviewed by the publisher.
 * @param effectivePeriod The effective date range for the SpecimenDefinition.
 * @param typeCollected Kind of material to collect.
 * @param patientPreparation Patient preparation for collection.
 * @param timeAspect Time aspect for collection.
 * @param collection Specimen collection procedure.
 * @param typeTested Specimen in container intended for testing by lab.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/SpecimenDefinition">FHIR R5 SpecimenDefinition</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record SpecimenDefinition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirUri url,
        Identifier identifier,
        FhirString version,
        DataType versionAlgorithm,
        FhirString name,
        FhirString title,
        List<FhirCanonical> derivedFromCanonical,
        List<FhirUri> derivedFromUri,
        FhirEnum<PublicationStatus> status,
        FhirBoolean experimental,
        DataType subject,
        FhirDateTime date,
        FhirString publisher,
        List<ContactDetail> contact,
        FhirMarkdown description,
        List<UsageContext> useContext,
        List<CodeableConcept> jurisdiction,
        FhirMarkdown purpose,
        FhirMarkdown copyright,
        FhirString copyrightLabel,
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        Period effectivePeriod,
        CodeableConcept typeCollected,
        List<CodeableConcept> patientPreparation,
        FhirString timeAspect,
        List<CodeableConcept> collection,
        List<TypeTested> typeTested) implements DomainResource {

    /**
     * Creates a {@code SpecimenDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public SpecimenDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        derivedFromCanonical = derivedFromCanonical == null ? List.of() : List.copyOf(derivedFromCanonical);
        derivedFromUri = derivedFromUri == null ? List.of() : List.copyOf(derivedFromUri);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        patientPreparation = patientPreparation == null ? List.of() : List.copyOf(patientPreparation);
        collection = collection == null ? List.of() : List.copyOf(collection);
        typeTested = typeTested == null ? List.of() : List.copyOf(typeTested);
        Objects.requireNonNull(status, "SpecimenDefinition.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "SpecimenDefinition.versionAlgorithm[x] must be one of string, Coding, but was "
                            + versionAlgorithm.getClass().getSimpleName());
        }
        if (subject != null && !(subject instanceof CodeableConcept || subject instanceof Reference)) {
            throw new IllegalArgumentException(
                    "SpecimenDefinition.subject[x] must be one of CodeableConcept, Reference, but was "
                            + subject.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code SpecimenDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Specimen conditioned in a container as expected by the testing laboratory.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param isDerived Primary or secondary specimen.
     * @param type Type of intended specimen.
     * @param preference preferred | alternate. Required.
     * @param container The specimen's container.
     * @param requirement Requirements for specimen delivery and special handling.
     * @param retentionTime The usual time for retaining this kind of specimen.
     * @param singleUse Specimen for single use only.
     * @param rejectionCriterion Criterion specified for specimen rejection.
     * @param handling Specimen handling before testing.
     * @param testingDestination Where the specimen will be tested.
     */
    public record TypeTested(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirBoolean isDerived,
            CodeableConcept type,
            FhirEnum<SpecimenContainedPreference> preference,
            Container container,
            FhirMarkdown requirement,
            Duration retentionTime,
            FhirBoolean singleUse,
            List<CodeableConcept> rejectionCriterion,
            List<Handling> handling,
            List<CodeableConcept> testingDestination) implements BackboneElement {

        /**
         * Creates a {@code TypeTested}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public TypeTested {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            rejectionCriterion = rejectionCriterion == null ? List.of() : List.copyOf(rejectionCriterion);
            handling = handling == null ? List.of() : List.copyOf(handling);
            testingDestination = testingDestination == null ? List.of() : List.copyOf(testingDestination);
            Objects.requireNonNull(preference, "SpecimenDefinition.typeTested.preference is required");
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
         * Returns a builder initialized with the values of this {@code TypeTested}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The specimen's container.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param material The material type used for the container.
         * @param type Kind of container associated with the kind of specimen.
         * @param cap Color of container cap.
         * @param description The description of the kind of container.
         * @param capacity The capacity of this kind of container.
         * @param minimumVolume Minimum volume. One of Quantity, string.
         * @param additive Additive associated with container.
         * @param preparation Special processing applied to the container for this specimen type.
         */
        public record Container(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept material,
                CodeableConcept type,
                CodeableConcept cap,
                FhirMarkdown description,
                Quantity capacity,
                DataType minimumVolume,
                List<Additive> additive,
                FhirMarkdown preparation) implements BackboneElement {

            /**
             * Creates a {@code Container}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Container {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                additive = additive == null ? List.of() : List.copyOf(additive);
                if (minimumVolume != null && !(minimumVolume instanceof Quantity
                        || minimumVolume instanceof FhirString)) {
                    throw new IllegalArgumentException(
                            "SpecimenDefinition.typeTested.container.minimumVolume[x] does not allow "
                                    + minimumVolume.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code Container}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Substance introduced in the kind of container to preserve, maintain or enhance the specimen.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param additive Additive associated with container. One of CodeableConcept, Reference. Required.
             */
            public record Additive(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    DataType additive) implements BackboneElement {

                /**
                 * Creates an {@code Additive}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 * @throws IllegalArgumentException if a choice element has a type that is not allowed
                 */
                public Additive {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(
                            additive, "SpecimenDefinition.typeTested.container.additive.additive is required");
                    if (additive != null && !(additive instanceof CodeableConcept || additive instanceof Reference)) {
                        throw new IllegalArgumentException(
                                "SpecimenDefinition.typeTested.container.additive.additive[x] does not allow "
                                        + additive.getClass().getSimpleName());
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
                 * Returns a builder initialized with the values of this {@code Additive}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Additive}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private DataType additive;

                    private Builder() {
                    }

                    private Builder(Additive original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.additive = original.additive();
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
                     * Sets {@code additive} to a CodeableConcept.
                     *
                     * @param additive the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder additive(CodeableConcept additive) {
                        this.additive = additive;
                        return this;
                    }

                    /**
                     * Sets {@code additive} to a Reference.
                     *
                     * @param additive the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder additive(Reference additive) {
                        this.additive = additive;
                        return this;
                    }

                    /**
                     * Builds the {@code Additive}.
                     *
                     * @return the {@code Additive}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Additive build() {
                        return new Additive(
                                id, extension, modifierExtension, additive);
                    }
                }
            }

            /** Builder for {@link Container}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept material;
                private CodeableConcept type;
                private CodeableConcept cap;
                private FhirMarkdown description;
                private Quantity capacity;
                private DataType minimumVolume;
                private List<Additive> additive = new ArrayList<>();
                private FhirMarkdown preparation;

                private Builder() {
                }

                private Builder(Container original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.material = original.material();
                    this.type = original.type();
                    this.cap = original.cap();
                    this.description = original.description();
                    this.capacity = original.capacity();
                    this.minimumVolume = original.minimumVolume();
                    this.additive = new ArrayList<>(original.additive());
                    this.preparation = original.preparation();
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
                 * Sets {@code material}.
                 *
                 * @param material the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder material(CodeableConcept material) {
                    this.material = material;
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
                 * Sets {@code cap}.
                 *
                 * @param cap the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder cap(CodeableConcept cap) {
                    this.cap = cap;
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
                 * Sets {@code capacity}.
                 *
                 * @param capacity the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder capacity(Quantity capacity) {
                    this.capacity = capacity;
                    return this;
                }

                /**
                 * Sets {@code minimumVolume} to a Quantity.
                 *
                 * @param minimumVolume the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder minimumVolume(Quantity minimumVolume) {
                    this.minimumVolume = minimumVolume;
                    return this;
                }

                /**
                 * Sets {@code minimumVolume} to a string.
                 *
                 * @param minimumVolume the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder minimumVolume(FhirString minimumVolume) {
                    this.minimumVolume = minimumVolume;
                    return this;
                }

                /**
                 * Sets {@code minimumVolume} to a string without id or extensions.
                 *
                 * @param minimumVolume the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder minimumVolume(String minimumVolume) {
                    this.minimumVolume = minimumVolume == null ? null : FhirString.of(minimumVolume);
                    return this;
                }

                /**
                 * Replaces all {@code additive} values.
                 *
                 * @param additive the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder additive(List<Additive> additive) {
                    this.additive = additive == null ? new ArrayList<>() : new ArrayList<>(additive);
                    return this;
                }

                /**
                 * Adds a {@code additive} value.
                 *
                 * @param additive the value to add
                 * @return this builder
                 */
                public Builder addAdditive(Additive additive) {
                    this.additive.add(Objects.requireNonNull(additive, "additive"));
                    return this;
                }

                /**
                 * Sets {@code preparation}.
                 *
                 * @param preparation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder preparation(FhirMarkdown preparation) {
                    this.preparation = preparation;
                    return this;
                }

                /**
                 * Sets {@code preparation}, wrapped in a {@link FhirMarkdown} without id or extensions.
                 *
                 * @param preparation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder preparation(String preparation) {
                    return preparation(preparation == null ? null : FhirMarkdown.of(preparation));
                }

                /**
                 * Builds the {@code Container}.
                 *
                 * @return the {@code Container}
                 */
                public Container build() {
                    return new Container(
                            id, extension, modifierExtension, material, type, cap, description, capacity,
                            minimumVolume, additive, preparation);
                }
            }
        }

        /**
         * Set of instructions for preservation/transport of the specimen at a defined temperature interval, prior the
         * testing process.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param temperatureQualifier Qualifies the interval of temperature.
         * @param temperatureRange Temperature range for these handling instructions.
         * @param maxDuration Maximum preservation time.
         * @param instruction Preservation instruction.
         */
        public record Handling(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept temperatureQualifier,
                Range temperatureRange,
                Duration maxDuration,
                FhirMarkdown instruction) implements BackboneElement {

            /**
             * Creates a {@code Handling}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Handling {
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
             * Returns a builder initialized with the values of this {@code Handling}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Handling}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept temperatureQualifier;
                private Range temperatureRange;
                private Duration maxDuration;
                private FhirMarkdown instruction;

                private Builder() {
                }

                private Builder(Handling original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.temperatureQualifier = original.temperatureQualifier();
                    this.temperatureRange = original.temperatureRange();
                    this.maxDuration = original.maxDuration();
                    this.instruction = original.instruction();
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
                 * Sets {@code temperatureQualifier}.
                 *
                 * @param temperatureQualifier the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder temperatureQualifier(CodeableConcept temperatureQualifier) {
                    this.temperatureQualifier = temperatureQualifier;
                    return this;
                }

                /**
                 * Sets {@code temperatureRange}.
                 *
                 * @param temperatureRange the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder temperatureRange(Range temperatureRange) {
                    this.temperatureRange = temperatureRange;
                    return this;
                }

                /**
                 * Sets {@code maxDuration}.
                 *
                 * @param maxDuration the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder maxDuration(Duration maxDuration) {
                    this.maxDuration = maxDuration;
                    return this;
                }

                /**
                 * Sets {@code instruction}.
                 *
                 * @param instruction the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder instruction(FhirMarkdown instruction) {
                    this.instruction = instruction;
                    return this;
                }

                /**
                 * Sets {@code instruction}, wrapped in a {@link FhirMarkdown} without id or extensions.
                 *
                 * @param instruction the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder instruction(String instruction) {
                    return instruction(instruction == null ? null : FhirMarkdown.of(instruction));
                }

                /**
                 * Builds the {@code Handling}.
                 *
                 * @return the {@code Handling}
                 */
                public Handling build() {
                    return new Handling(
                            id, extension, modifierExtension, temperatureQualifier, temperatureRange, maxDuration,
                            instruction);
                }
            }
        }

        /** Builder for {@link TypeTested}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirBoolean isDerived;
            private CodeableConcept type;
            private FhirEnum<SpecimenContainedPreference> preference;
            private Container container;
            private FhirMarkdown requirement;
            private Duration retentionTime;
            private FhirBoolean singleUse;
            private List<CodeableConcept> rejectionCriterion = new ArrayList<>();
            private List<Handling> handling = new ArrayList<>();
            private List<CodeableConcept> testingDestination = new ArrayList<>();

            private Builder() {
            }

            private Builder(TypeTested original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.isDerived = original.isDerived();
                this.type = original.type();
                this.preference = original.preference();
                this.container = original.container();
                this.requirement = original.requirement();
                this.retentionTime = original.retentionTime();
                this.singleUse = original.singleUse();
                this.rejectionCriterion = new ArrayList<>(original.rejectionCriterion());
                this.handling = new ArrayList<>(original.handling());
                this.testingDestination = new ArrayList<>(original.testingDestination());
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
             * Sets {@code isDerived}.
             *
             * @param isDerived the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder isDerived(FhirBoolean isDerived) {
                this.isDerived = isDerived;
                return this;
            }

            /**
             * Sets {@code isDerived}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param isDerived the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder isDerived(Boolean isDerived) {
                return isDerived(isDerived == null ? null : FhirBoolean.of(isDerived));
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
             * Sets {@code preference}.
             *
             * @param preference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder preference(FhirEnum<SpecimenContainedPreference> preference) {
                this.preference = preference;
                return this;
            }

            /**
             * Sets {@code preference}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param preference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder preference(SpecimenContainedPreference preference) {
                return preference(preference == null ? null : FhirEnum.of(preference));
            }

            /**
             * Sets {@code container}.
             *
             * @param container the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder container(Container container) {
                this.container = container;
                return this;
            }

            /**
             * Sets {@code requirement}.
             *
             * @param requirement the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder requirement(FhirMarkdown requirement) {
                this.requirement = requirement;
                return this;
            }

            /**
             * Sets {@code requirement}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param requirement the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder requirement(String requirement) {
                return requirement(requirement == null ? null : FhirMarkdown.of(requirement));
            }

            /**
             * Sets {@code retentionTime}.
             *
             * @param retentionTime the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder retentionTime(Duration retentionTime) {
                this.retentionTime = retentionTime;
                return this;
            }

            /**
             * Sets {@code singleUse}.
             *
             * @param singleUse the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder singleUse(FhirBoolean singleUse) {
                this.singleUse = singleUse;
                return this;
            }

            /**
             * Sets {@code singleUse}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param singleUse the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder singleUse(Boolean singleUse) {
                return singleUse(singleUse == null ? null : FhirBoolean.of(singleUse));
            }

            /**
             * Replaces all {@code rejectionCriterion} values.
             *
             * @param rejectionCriterion the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder rejectionCriterion(List<CodeableConcept> rejectionCriterion) {
                this.rejectionCriterion = rejectionCriterion == null
                        ? new ArrayList<>()
                        : new ArrayList<>(rejectionCriterion);
                return this;
            }

            /**
             * Adds a {@code rejectionCriterion} value.
             *
             * @param rejectionCriterion the value to add
             * @return this builder
             */
            public Builder addRejectionCriterion(CodeableConcept rejectionCriterion) {
                this.rejectionCriterion.add(Objects.requireNonNull(rejectionCriterion, "rejectionCriterion"));
                return this;
            }

            /**
             * Replaces all {@code handling} values.
             *
             * @param handling the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder handling(List<Handling> handling) {
                this.handling = handling == null ? new ArrayList<>() : new ArrayList<>(handling);
                return this;
            }

            /**
             * Adds a {@code handling} value.
             *
             * @param handling the value to add
             * @return this builder
             */
            public Builder addHandling(Handling handling) {
                this.handling.add(Objects.requireNonNull(handling, "handling"));
                return this;
            }

            /**
             * Replaces all {@code testingDestination} values.
             *
             * @param testingDestination the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder testingDestination(List<CodeableConcept> testingDestination) {
                this.testingDestination = testingDestination == null
                        ? new ArrayList<>()
                        : new ArrayList<>(testingDestination);
                return this;
            }

            /**
             * Adds a {@code testingDestination} value.
             *
             * @param testingDestination the value to add
             * @return this builder
             */
            public Builder addTestingDestination(CodeableConcept testingDestination) {
                this.testingDestination.add(Objects.requireNonNull(testingDestination, "testingDestination"));
                return this;
            }

            /**
             * Builds the {@code TypeTested}.
             *
             * @return the {@code TypeTested}
             * @throws NullPointerException if a required element is absent
             */
            public TypeTested build() {
                return new TypeTested(
                        id, extension, modifierExtension, isDerived, type, preference, container, requirement,
                        retentionTime, singleUse, rejectionCriterion, handling, testingDestination);
            }
        }
    }

    /** Builder for {@link SpecimenDefinition}. Builders are mutable and not thread-safe. */
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
        private Identifier identifier;
        private FhirString version;
        private DataType versionAlgorithm;
        private FhirString name;
        private FhirString title;
        private List<FhirCanonical> derivedFromCanonical = new ArrayList<>();
        private List<FhirUri> derivedFromUri = new ArrayList<>();
        private FhirEnum<PublicationStatus> status;
        private FhirBoolean experimental;
        private DataType subject;
        private FhirDateTime date;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private FhirMarkdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private FhirMarkdown purpose;
        private FhirMarkdown copyright;
        private FhirString copyrightLabel;
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private Period effectivePeriod;
        private CodeableConcept typeCollected;
        private List<CodeableConcept> patientPreparation = new ArrayList<>();
        private FhirString timeAspect;
        private List<CodeableConcept> collection = new ArrayList<>();
        private List<TypeTested> typeTested = new ArrayList<>();

        private Builder() {
        }

        private Builder(SpecimenDefinition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.url = original.url();
            this.identifier = original.identifier();
            this.version = original.version();
            this.versionAlgorithm = original.versionAlgorithm();
            this.name = original.name();
            this.title = original.title();
            this.derivedFromCanonical = new ArrayList<>(original.derivedFromCanonical());
            this.derivedFromUri = new ArrayList<>(original.derivedFromUri());
            this.status = original.status();
            this.experimental = original.experimental();
            this.subject = original.subject();
            this.date = original.date();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.description = original.description();
            this.useContext = new ArrayList<>(original.useContext());
            this.jurisdiction = new ArrayList<>(original.jurisdiction());
            this.purpose = original.purpose();
            this.copyright = original.copyright();
            this.copyrightLabel = original.copyrightLabel();
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.effectivePeriod = original.effectivePeriod();
            this.typeCollected = original.typeCollected();
            this.patientPreparation = new ArrayList<>(original.patientPreparation());
            this.timeAspect = original.timeAspect();
            this.collection = new ArrayList<>(original.collection());
            this.typeTested = new ArrayList<>(original.typeTested());
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
         * Replaces all {@code derivedFromCanonical} values.
         *
         * @param derivedFromCanonical the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder derivedFromCanonical(List<FhirCanonical> derivedFromCanonical) {
            this.derivedFromCanonical = derivedFromCanonical == null
                    ? new ArrayList<>()
                    : new ArrayList<>(derivedFromCanonical);
            return this;
        }

        /**
         * Adds a {@code derivedFromCanonical} value.
         *
         * @param derivedFromCanonical the value to add
         * @return this builder
         */
        public Builder addDerivedFromCanonical(FhirCanonical derivedFromCanonical) {
            this.derivedFromCanonical.add(Objects.requireNonNull(derivedFromCanonical, "derivedFromCanonical"));
            return this;
        }

        /**
         * Adds a {@code derivedFromCanonical} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param derivedFromCanonical the value to add
         * @return this builder
         */
        public Builder addDerivedFromCanonical(String derivedFromCanonical) {
            return addDerivedFromCanonical(FhirCanonical.of(derivedFromCanonical));
        }

        /**
         * Replaces all {@code derivedFromUri} values.
         *
         * @param derivedFromUri the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder derivedFromUri(List<FhirUri> derivedFromUri) {
            this.derivedFromUri = derivedFromUri == null ? new ArrayList<>() : new ArrayList<>(derivedFromUri);
            return this;
        }

        /**
         * Adds a {@code derivedFromUri} value.
         *
         * @param derivedFromUri the value to add
         * @return this builder
         */
        public Builder addDerivedFromUri(FhirUri derivedFromUri) {
            this.derivedFromUri.add(Objects.requireNonNull(derivedFromUri, "derivedFromUri"));
            return this;
        }

        /**
         * Adds a {@code derivedFromUri} value, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param derivedFromUri the value to add
         * @return this builder
         */
        public Builder addDerivedFromUri(String derivedFromUri) {
            return addDerivedFromUri(FhirUri.of(derivedFromUri));
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
         * Sets {@code subject} to a CodeableConcept.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(CodeableConcept subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets {@code subject} to a Reference.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(Reference subject) {
            this.subject = subject;
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
         * Sets {@code approvalDate}.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(FhirDate approvalDate) {
            this.approvalDate = approvalDate;
            return this;
        }

        /**
         * Sets {@code approvalDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(Temporal approvalDate) {
            return approvalDate(approvalDate == null ? null : FhirDate.of(approvalDate));
        }

        /**
         * Sets {@code lastReviewDate}.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(FhirDate lastReviewDate) {
            this.lastReviewDate = lastReviewDate;
            return this;
        }

        /**
         * Sets {@code lastReviewDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(Temporal lastReviewDate) {
            return lastReviewDate(lastReviewDate == null ? null : FhirDate.of(lastReviewDate));
        }

        /**
         * Sets {@code effectivePeriod}.
         *
         * @param effectivePeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effectivePeriod(Period effectivePeriod) {
            this.effectivePeriod = effectivePeriod;
            return this;
        }

        /**
         * Sets {@code typeCollected}.
         *
         * @param typeCollected the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder typeCollected(CodeableConcept typeCollected) {
            this.typeCollected = typeCollected;
            return this;
        }

        /**
         * Replaces all {@code patientPreparation} values.
         *
         * @param patientPreparation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder patientPreparation(List<CodeableConcept> patientPreparation) {
            this.patientPreparation = patientPreparation == null
                    ? new ArrayList<>()
                    : new ArrayList<>(patientPreparation);
            return this;
        }

        /**
         * Adds a {@code patientPreparation} value.
         *
         * @param patientPreparation the value to add
         * @return this builder
         */
        public Builder addPatientPreparation(CodeableConcept patientPreparation) {
            this.patientPreparation.add(Objects.requireNonNull(patientPreparation, "patientPreparation"));
            return this;
        }

        /**
         * Sets {@code timeAspect}.
         *
         * @param timeAspect the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timeAspect(FhirString timeAspect) {
            this.timeAspect = timeAspect;
            return this;
        }

        /**
         * Sets {@code timeAspect}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param timeAspect the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timeAspect(String timeAspect) {
            return timeAspect(timeAspect == null ? null : FhirString.of(timeAspect));
        }

        /**
         * Replaces all {@code collection} values.
         *
         * @param collection the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder collection(List<CodeableConcept> collection) {
            this.collection = collection == null ? new ArrayList<>() : new ArrayList<>(collection);
            return this;
        }

        /**
         * Adds a {@code collection} value.
         *
         * @param collection the value to add
         * @return this builder
         */
        public Builder addCollection(CodeableConcept collection) {
            this.collection.add(Objects.requireNonNull(collection, "collection"));
            return this;
        }

        /**
         * Replaces all {@code typeTested} values.
         *
         * @param typeTested the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder typeTested(List<TypeTested> typeTested) {
            this.typeTested = typeTested == null ? new ArrayList<>() : new ArrayList<>(typeTested);
            return this;
        }

        /**
         * Adds a {@code typeTested} value.
         *
         * @param typeTested the value to add
         * @return this builder
         */
        public Builder addTypeTested(TypeTested typeTested) {
            this.typeTested.add(Objects.requireNonNull(typeTested, "typeTested"));
            return this;
        }

        /**
         * Builds the {@code SpecimenDefinition}.
         *
         * @return the {@code SpecimenDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public SpecimenDefinition build() {
            return new SpecimenDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, derivedFromCanonical, derivedFromUri, status,
                    experimental, subject, date, publisher, contact, description, useContext, jurisdiction, purpose,
                    copyright, copyrightLabel, approvalDate, lastReviewDate, effectivePeriod, typeCollected,
                    patientPreparation, timeAspect, collection, typeTested);
        }
    }
}
