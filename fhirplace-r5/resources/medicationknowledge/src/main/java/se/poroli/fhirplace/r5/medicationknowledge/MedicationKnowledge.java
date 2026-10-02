package se.poroli.fhirplace.r5.medicationknowledge;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Dosage;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * Information about a medication that is used to support knowledge.
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
 * @param identifier Business identifier for this medication.
 * @param code Code that identifies this medication.
 * @param status active | entered-in-error | inactive. Modifier element.
 * @param author Creator or owner of the knowledge or information about the medication. Reference to Organization.
 * @param intendedJurisdiction Codes that identify the different jurisdictions for which the information of this
 *   resource was created.
 * @param name A name associated with the medication being described.
 * @param relatedMedicationKnowledge Associated or related medication information.
 * @param associatedMedication The set of medication resources that are associated with this medication. Reference to
 *   Medication.
 * @param productType Category of the medication or product.
 * @param monograph Associated documentation about the medication.
 * @param preparationInstruction The instructions for preparing the medication.
 * @param cost The pricing of the medication.
 * @param monitoringProgram Program under which a medication is reviewed.
 * @param indicationGuideline Guidelines or protocols for administration of the medication for an indication.
 * @param medicineClassification Categorization of the medication within a formulary or classification system.
 * @param packaging Details about packaged medications.
 * @param clinicalUseIssue Potential clinical issue with or between medication(s). Reference to ClinicalUseDefinition.
 * @param storageGuideline How the medication should be stored.
 * @param regulatory Regulatory information about a medication.
 * @param definitional Minimal definition information about the medication.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MedicationKnowledge">FHIR R5 MedicationKnowledge</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record MedicationKnowledge(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        CodeableConcept code,
        FhirEnum<MedicationKnowledgeStatusCodes> status,
        Reference author,
        List<CodeableConcept> intendedJurisdiction,
        List<FhirString> name,
        List<RelatedMedicationKnowledge> relatedMedicationKnowledge,
        List<Reference> associatedMedication,
        List<CodeableConcept> productType,
        List<Monograph> monograph,
        FhirMarkdown preparationInstruction,
        List<Cost> cost,
        List<MonitoringProgram> monitoringProgram,
        List<IndicationGuideline> indicationGuideline,
        List<MedicineClassification> medicineClassification,
        List<Packaging> packaging,
        List<Reference> clinicalUseIssue,
        List<StorageGuideline> storageGuideline,
        List<Regulatory> regulatory,
        Definitional definitional) implements DomainResource {

    /**
     * Creates a {@code MedicationKnowledge}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public MedicationKnowledge {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        intendedJurisdiction = intendedJurisdiction == null ? List.of() : List.copyOf(intendedJurisdiction);
        name = name == null ? List.of() : List.copyOf(name);
        relatedMedicationKnowledge =
                relatedMedicationKnowledge == null ? List.of() : List.copyOf(relatedMedicationKnowledge);
        associatedMedication = associatedMedication == null ? List.of() : List.copyOf(associatedMedication);
        productType = productType == null ? List.of() : List.copyOf(productType);
        monograph = monograph == null ? List.of() : List.copyOf(monograph);
        cost = cost == null ? List.of() : List.copyOf(cost);
        monitoringProgram = monitoringProgram == null ? List.of() : List.copyOf(monitoringProgram);
        indicationGuideline = indicationGuideline == null ? List.of() : List.copyOf(indicationGuideline);
        medicineClassification = medicineClassification == null ? List.of() : List.copyOf(medicineClassification);
        packaging = packaging == null ? List.of() : List.copyOf(packaging);
        clinicalUseIssue = clinicalUseIssue == null ? List.of() : List.copyOf(clinicalUseIssue);
        storageGuideline = storageGuideline == null ? List.of() : List.copyOf(storageGuideline);
        regulatory = regulatory == null ? List.of() : List.copyOf(regulatory);
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
     * Returns a builder initialized with the values of this {@code MedicationKnowledge}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Associated or related medications.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Category of medicationKnowledge. Required.
     * @param reference Associated documentation about the associated medication knowledge. Reference to
     *   MedicationKnowledge. Required.
     */
    public record RelatedMedicationKnowledge(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            List<Reference> reference) implements BackboneElement {

        /**
         * Creates a {@code RelatedMedicationKnowledge}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public RelatedMedicationKnowledge {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            reference = reference == null ? List.of() : List.copyOf(reference);
            Objects.requireNonNull(type, "MedicationKnowledge.relatedMedicationKnowledge.type is required");
            if (reference.isEmpty()) {
                throw new IllegalArgumentException(
                        "MedicationKnowledge.relatedMedicationKnowledge.reference requires at least one value");
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
         * Returns a builder initialized with the values of this {@code RelatedMedicationKnowledge}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link RelatedMedicationKnowledge}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private List<Reference> reference = new ArrayList<>();

            private Builder() {
            }

            private Builder(RelatedMedicationKnowledge original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.reference = new ArrayList<>(original.reference());
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
             * Replaces all {@code reference} values.
             *
             * @param reference the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder reference(List<Reference> reference) {
                this.reference = reference == null ? new ArrayList<>() : new ArrayList<>(reference);
                return this;
            }

            /**
             * Adds a {@code reference} value.
             *
             * @param reference the value to add
             * @return this builder
             */
            public Builder addReference(Reference reference) {
                this.reference.add(Objects.requireNonNull(reference, "reference"));
                return this;
            }

            /**
             * Builds the {@code RelatedMedicationKnowledge}.
             *
             * @return the {@code RelatedMedicationKnowledge}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public RelatedMedicationKnowledge build() {
                return new RelatedMedicationKnowledge(
                        id, extension, modifierExtension, type, reference);
            }
        }
    }

    /**
     * Associated documentation about the medication.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type The category of medication document.
     * @param source Associated documentation about the medication. Reference to DocumentReference.
     */
    public record Monograph(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            Reference source) implements BackboneElement {

        /**
         * Creates a {@code Monograph}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Monograph {
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
         * Returns a builder initialized with the values of this {@code Monograph}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Monograph}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private Reference source;

            private Builder() {
            }

            private Builder(Monograph original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
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
             * Sets {@code source}.
             *
             * @param source the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder source(Reference source) {
                this.source = source;
                return this;
            }

            /**
             * Builds the {@code Monograph}.
             *
             * @return the {@code Monograph}
             */
            public Monograph build() {
                return new Monograph(
                        id, extension, modifierExtension, type, source);
            }
        }
    }

    /**
     * The price of the medication.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param effectiveDate The date range for which the cost is effective.
     * @param type The category of the cost information. Required.
     * @param source The source or owner for the price information.
     * @param cost The price or category of the cost of the medication. One of Money, CodeableConcept. Required.
     */
    public record Cost(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Period> effectiveDate,
            CodeableConcept type,
            FhirString source,
            DataType cost) implements BackboneElement {

        /**
         * Creates a {@code Cost}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Cost {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            effectiveDate = effectiveDate == null ? List.of() : List.copyOf(effectiveDate);
            Objects.requireNonNull(type, "MedicationKnowledge.cost.type is required");
            Objects.requireNonNull(cost, "MedicationKnowledge.cost.cost is required");
            if (cost != null && !(cost instanceof Money || cost instanceof CodeableConcept)) {
                throw new IllegalArgumentException(
                        "MedicationKnowledge.cost.cost[x] must be one of Money, CodeableConcept, but was "
                                + cost.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Cost}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Cost}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Period> effectiveDate = new ArrayList<>();
            private CodeableConcept type;
            private FhirString source;
            private DataType cost;

            private Builder() {
            }

            private Builder(Cost original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.effectiveDate = new ArrayList<>(original.effectiveDate());
                this.type = original.type();
                this.source = original.source();
                this.cost = original.cost();
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
             * Replaces all {@code effectiveDate} values.
             *
             * @param effectiveDate the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder effectiveDate(List<Period> effectiveDate) {
                this.effectiveDate = effectiveDate == null ? new ArrayList<>() : new ArrayList<>(effectiveDate);
                return this;
            }

            /**
             * Adds a {@code effectiveDate} value.
             *
             * @param effectiveDate the value to add
             * @return this builder
             */
            public Builder addEffectiveDate(Period effectiveDate) {
                this.effectiveDate.add(Objects.requireNonNull(effectiveDate, "effectiveDate"));
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
             * Sets {@code source}.
             *
             * @param source the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder source(FhirString source) {
                this.source = source;
                return this;
            }

            /**
             * Sets {@code source}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param source the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder source(String source) {
                return source(source == null ? null : FhirString.of(source));
            }

            /**
             * Sets {@code cost} to a Money.
             *
             * @param cost the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder cost(Money cost) {
                this.cost = cost;
                return this;
            }

            /**
             * Sets {@code cost} to a CodeableConcept.
             *
             * @param cost the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder cost(CodeableConcept cost) {
                this.cost = cost;
                return this;
            }

            /**
             * Builds the {@code Cost}.
             *
             * @return the {@code Cost}
             * @throws NullPointerException if a required element is absent
             */
            public Cost build() {
                return new Cost(
                        id, extension, modifierExtension, effectiveDate, type, source, cost);
            }
        }
    }

    /**
     * The program under which the medication is reviewed.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Type of program under which the medication is monitored.
     * @param name Name of the reviewing program.
     */
    public record MonitoringProgram(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            FhirString name) implements BackboneElement {

        /**
         * Creates a {@code MonitoringProgram}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public MonitoringProgram {
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
         * Returns a builder initialized with the values of this {@code MonitoringProgram}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link MonitoringProgram}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private FhirString name;

            private Builder() {
            }

            private Builder(MonitoringProgram original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.name = original.name();
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
             * Builds the {@code MonitoringProgram}.
             *
             * @return the {@code MonitoringProgram}
             */
            public MonitoringProgram build() {
                return new MonitoringProgram(
                        id, extension, modifierExtension, type, name);
            }
        }
    }

    /**
     * Guidelines or protocols that are applicable for the administration of the medication based on indication.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param indication Indication for use that applies to the specific administration guideline.
     * @param dosingGuideline Guidelines for dosage of the medication.
     */
    public record IndicationGuideline(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableReference> indication,
            List<DosingGuideline> dosingGuideline) implements BackboneElement {

        /**
         * Creates an {@code IndicationGuideline}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public IndicationGuideline {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            indication = indication == null ? List.of() : List.copyOf(indication);
            dosingGuideline = dosingGuideline == null ? List.of() : List.copyOf(dosingGuideline);
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
         * Returns a builder initialized with the values of this {@code IndicationGuideline}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The guidelines for the dosage of the medication for the indication.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param treatmentIntent Intention of the treatment.
         * @param dosage Dosage for the medication for the specific guidelines.
         * @param administrationTreatment Type of treatment the guideline applies to.
         * @param patientCharacteristic Characteristics of the patient that are relevant to the administration
         *   guidelines.
         */
        public record DosingGuideline(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept treatmentIntent,
                List<DosingGuidelineDosage> dosage,
                CodeableConcept administrationTreatment,
                List<PatientCharacteristic> patientCharacteristic) implements BackboneElement {

            /**
             * Creates a {@code DosingGuideline}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public DosingGuideline {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                dosage = dosage == null ? List.of() : List.copyOf(dosage);
                patientCharacteristic =
                        patientCharacteristic == null ? List.of() : List.copyOf(patientCharacteristic);
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
             * Returns a builder initialized with the values of this {@code DosingGuideline}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Dosage for the medication for the specific guidelines.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param type Category of dosage for a medication. Required.
             * @param dosage Dosage for the medication for the specific guidelines. Required.
             */
            public record DosingGuidelineDosage(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    CodeableConcept type,
                    List<Dosage> dosage) implements BackboneElement {

                /**
                 * Creates a {@code DosingGuidelineDosage}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public DosingGuidelineDosage {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    dosage = dosage == null ? List.of() : List.copyOf(dosage);
                    Objects.requireNonNull(
                            type, "MedicationKnowledge.indicationGuideline.dosingGuideline.dosage.type is required");
                    if (dosage.isEmpty()) {
                        throw new IllegalArgumentException(
                                "MedicationKnowledge.indicationGuideline.dosingGuideline.dosage.dosage requires at least one value");
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
                 * Returns a builder initialized with the values of this {@code DosingGuidelineDosage}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link DosingGuidelineDosage}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private CodeableConcept type;
                    private List<Dosage> dosage = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(DosingGuidelineDosage original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.type = original.type();
                        this.dosage = new ArrayList<>(original.dosage());
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
                     * Replaces all {@code dosage} values.
                     *
                     * @param dosage the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder dosage(List<Dosage> dosage) {
                        this.dosage = dosage == null ? new ArrayList<>() : new ArrayList<>(dosage);
                        return this;
                    }

                    /**
                     * Adds a {@code dosage} value.
                     *
                     * @param dosage the value to add
                     * @return this builder
                     */
                    public Builder addDosage(Dosage dosage) {
                        this.dosage.add(Objects.requireNonNull(dosage, "dosage"));
                        return this;
                    }

                    /**
                     * Builds the {@code DosingGuidelineDosage}.
                     *
                     * @return the {@code DosingGuidelineDosage}
                     * @throws NullPointerException if a required element is absent
                     * @throws IllegalArgumentException if a required list is empty
                     */
                    public DosingGuidelineDosage build() {
                        return new DosingGuidelineDosage(
                                id, extension, modifierExtension, type, dosage);
                    }
                }
            }

            /**
             * Characteristics of the patient that are relevant to the administration guidelines (for example, height,
             * weight, gender, etc.).
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param type Categorization of specific characteristic that is relevant to the administration guideline.
             *   Required.
             * @param value The specific characteristic. One of CodeableConcept, Quantity, Range.
             */
            public record PatientCharacteristic(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    CodeableConcept type,
                    DataType value) implements BackboneElement {

                /**
                 * Creates a {@code PatientCharacteristic}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 * @throws IllegalArgumentException if a choice element has a type that is not allowed
                 */
                public PatientCharacteristic {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(
                            type, "MedicationKnowledge.indicationGuideline.dosingGuideline.patientCharacteristic.type is required");
                    if (value != null && !(value instanceof CodeableConcept
                            || value instanceof Quantity
                            || value instanceof Range)) {
                        throw new IllegalArgumentException(
                                "MedicationKnowledge.indicationGuideline.dosingGuideline.patientCharacteristic.value[x] does not allow "
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
                 * Returns a builder initialized with the values of this {@code PatientCharacteristic}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link PatientCharacteristic}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private CodeableConcept type;
                    private DataType value;

                    private Builder() {
                    }

                    private Builder(PatientCharacteristic original) {
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
                     * Sets {@code value} to a Range.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(Range value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Builds the {@code PatientCharacteristic}.
                     *
                     * @return the {@code PatientCharacteristic}
                     * @throws NullPointerException if a required element is absent
                     */
                    public PatientCharacteristic build() {
                        return new PatientCharacteristic(
                                id, extension, modifierExtension, type, value);
                    }
                }
            }

            /** Builder for {@link DosingGuideline}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept treatmentIntent;
                private List<DosingGuidelineDosage> dosage = new ArrayList<>();
                private CodeableConcept administrationTreatment;
                private List<PatientCharacteristic> patientCharacteristic = new ArrayList<>();

                private Builder() {
                }

                private Builder(DosingGuideline original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.treatmentIntent = original.treatmentIntent();
                    this.dosage = new ArrayList<>(original.dosage());
                    this.administrationTreatment = original.administrationTreatment();
                    this.patientCharacteristic = new ArrayList<>(original.patientCharacteristic());
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
                 * Sets {@code treatmentIntent}.
                 *
                 * @param treatmentIntent the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder treatmentIntent(CodeableConcept treatmentIntent) {
                    this.treatmentIntent = treatmentIntent;
                    return this;
                }

                /**
                 * Replaces all {@code dosage} values.
                 *
                 * @param dosage the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder dosage(List<DosingGuidelineDosage> dosage) {
                    this.dosage = dosage == null ? new ArrayList<>() : new ArrayList<>(dosage);
                    return this;
                }

                /**
                 * Adds a {@code dosage} value.
                 *
                 * @param dosage the value to add
                 * @return this builder
                 */
                public Builder addDosage(DosingGuidelineDosage dosage) {
                    this.dosage.add(Objects.requireNonNull(dosage, "dosage"));
                    return this;
                }

                /**
                 * Sets {@code administrationTreatment}.
                 *
                 * @param administrationTreatment the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder administrationTreatment(CodeableConcept administrationTreatment) {
                    this.administrationTreatment = administrationTreatment;
                    return this;
                }

                /**
                 * Replaces all {@code patientCharacteristic} values.
                 *
                 * @param patientCharacteristic the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder patientCharacteristic(List<PatientCharacteristic> patientCharacteristic) {
                    this.patientCharacteristic = patientCharacteristic == null
                            ? new ArrayList<>()
                            : new ArrayList<>(patientCharacteristic);
                    return this;
                }

                /**
                 * Adds a {@code patientCharacteristic} value.
                 *
                 * @param patientCharacteristic the value to add
                 * @return this builder
                 */
                public Builder addPatientCharacteristic(PatientCharacteristic patientCharacteristic) {
                    this.patientCharacteristic.add(
                            Objects.requireNonNull(patientCharacteristic, "patientCharacteristic"));
                    return this;
                }

                /**
                 * Builds the {@code DosingGuideline}.
                 *
                 * @return the {@code DosingGuideline}
                 */
                public DosingGuideline build() {
                    return new DosingGuideline(
                            id, extension, modifierExtension, treatmentIntent, dosage, administrationTreatment,
                            patientCharacteristic);
                }
            }
        }

        /** Builder for {@link IndicationGuideline}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<CodeableReference> indication = new ArrayList<>();
            private List<DosingGuideline> dosingGuideline = new ArrayList<>();

            private Builder() {
            }

            private Builder(IndicationGuideline original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.indication = new ArrayList<>(original.indication());
                this.dosingGuideline = new ArrayList<>(original.dosingGuideline());
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
             * Replaces all {@code indication} values.
             *
             * @param indication the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder indication(List<CodeableReference> indication) {
                this.indication = indication == null ? new ArrayList<>() : new ArrayList<>(indication);
                return this;
            }

            /**
             * Adds a {@code indication} value.
             *
             * @param indication the value to add
             * @return this builder
             */
            public Builder addIndication(CodeableReference indication) {
                this.indication.add(Objects.requireNonNull(indication, "indication"));
                return this;
            }

            /**
             * Replaces all {@code dosingGuideline} values.
             *
             * @param dosingGuideline the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder dosingGuideline(List<DosingGuideline> dosingGuideline) {
                this.dosingGuideline = dosingGuideline == null ? new ArrayList<>() : new ArrayList<>(dosingGuideline);
                return this;
            }

            /**
             * Adds a {@code dosingGuideline} value.
             *
             * @param dosingGuideline the value to add
             * @return this builder
             */
            public Builder addDosingGuideline(DosingGuideline dosingGuideline) {
                this.dosingGuideline.add(Objects.requireNonNull(dosingGuideline, "dosingGuideline"));
                return this;
            }

            /**
             * Builds the {@code IndicationGuideline}.
             *
             * @return the {@code IndicationGuideline}
             */
            public IndicationGuideline build() {
                return new IndicationGuideline(
                        id, extension, modifierExtension, indication, dosingGuideline);
            }
        }
    }

    /**
     * Categorization of the medication within a formulary or classification system.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type The type of category for the medication (for example, therapeutic classification, therapeutic
     *   sub-classification). Required.
     * @param source The source of the classification. One of string, uri.
     * @param classification Specific category assigned to the medication.
     */
    public record MedicineClassification(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType source,
            List<CodeableConcept> classification) implements BackboneElement {

        /**
         * Creates a {@code MedicineClassification}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public MedicineClassification {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            classification = classification == null ? List.of() : List.copyOf(classification);
            Objects.requireNonNull(type, "MedicationKnowledge.medicineClassification.type is required");
            if (source != null && !(source instanceof FhirString || source instanceof FhirUri)) {
                throw new IllegalArgumentException(
                        "MedicationKnowledge.medicineClassification.source[x] must be one of string, uri, but was "
                                + source.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code MedicineClassification}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link MedicineClassification}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private DataType source;
            private List<CodeableConcept> classification = new ArrayList<>();

            private Builder() {
            }

            private Builder(MedicineClassification original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.source = original.source();
                this.classification = new ArrayList<>(original.classification());
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
             * Sets {@code source} to a string.
             *
             * @param source the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder source(FhirString source) {
                this.source = source;
                return this;
            }

            /**
             * Sets {@code source} to a uri.
             *
             * @param source the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder source(FhirUri source) {
                this.source = source;
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
             * Builds the {@code MedicineClassification}.
             *
             * @return the {@code MedicineClassification}
             * @throws NullPointerException if a required element is absent
             */
            public MedicineClassification build() {
                return new MedicineClassification(
                        id, extension, modifierExtension, type, source, classification);
            }
        }
    }

    /**
     * Information that only applies to packages (not products).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param cost Cost of the packaged medication.
     * @param packagedProduct The packaged medication that is being priced. Reference to PackagedProductDefinition.
     */
    public record Packaging(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<MedicationKnowledge.Cost> cost,
            Reference packagedProduct) implements BackboneElement {

        /**
         * Creates a {@code Packaging}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Packaging {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            cost = cost == null ? List.of() : List.copyOf(cost);
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
         * Returns a builder initialized with the values of this {@code Packaging}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Packaging}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<MedicationKnowledge.Cost> cost = new ArrayList<>();
            private Reference packagedProduct;

            private Builder() {
            }

            private Builder(Packaging original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.cost = new ArrayList<>(original.cost());
                this.packagedProduct = original.packagedProduct();
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
             * Replaces all {@code cost} values.
             *
             * @param cost the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder cost(List<MedicationKnowledge.Cost> cost) {
                this.cost = cost == null ? new ArrayList<>() : new ArrayList<>(cost);
                return this;
            }

            /**
             * Adds a {@code cost} value.
             *
             * @param cost the value to add
             * @return this builder
             */
            public Builder addCost(MedicationKnowledge.Cost cost) {
                this.cost.add(Objects.requireNonNull(cost, "cost"));
                return this;
            }

            /**
             * Sets {@code packagedProduct}.
             *
             * @param packagedProduct the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder packagedProduct(Reference packagedProduct) {
                this.packagedProduct = packagedProduct;
                return this;
            }

            /**
             * Builds the {@code Packaging}.
             *
             * @return the {@code Packaging}
             */
            public Packaging build() {
                return new Packaging(
                        id, extension, modifierExtension, cost, packagedProduct);
            }
        }
    }

    /**
     * Information on how the medication should be stored, for example, refrigeration temperatures and length of
     * stability at a given temperature.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param reference Reference to additional information.
     * @param note Additional storage notes.
     * @param stabilityDuration Duration remains stable.
     * @param environmentalSetting Setting or value of environment for adequate storage.
     */
    public record StorageGuideline(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirUri reference,
            List<Annotation> note,
            Duration stabilityDuration,
            List<EnvironmentalSetting> environmentalSetting) implements BackboneElement {

        /**
         * Creates a {@code StorageGuideline}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public StorageGuideline {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            note = note == null ? List.of() : List.copyOf(note);
            environmentalSetting = environmentalSetting == null ? List.of() : List.copyOf(environmentalSetting);
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
         * Returns a builder initialized with the values of this {@code StorageGuideline}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Describes a setting/value on the environment for the adequate storage of the medication and other
         * substances.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type Categorization of the setting. Required.
         * @param value Value of the setting. One of Quantity, Range, CodeableConcept. Required.
         */
        public record EnvironmentalSetting(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                DataType value) implements BackboneElement {

            /**
             * Creates an {@code EnvironmentalSetting}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public EnvironmentalSetting {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(
                        type, "MedicationKnowledge.storageGuideline.environmentalSetting.type is required");
                Objects.requireNonNull(
                        value, "MedicationKnowledge.storageGuideline.environmentalSetting.value is required");
                if (value != null && !(value instanceof Quantity
                        || value instanceof Range
                        || value instanceof CodeableConcept)) {
                    throw new IllegalArgumentException(
                            "MedicationKnowledge.storageGuideline.environmentalSetting.value[x] does not allow "
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
             * Returns a builder initialized with the values of this {@code EnvironmentalSetting}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link EnvironmentalSetting}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private DataType value;

                private Builder() {
                }

                private Builder(EnvironmentalSetting original) {
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
                 * Sets {@code value} to a Range.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Range value) {
                    this.value = value;
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
                 * Builds the {@code EnvironmentalSetting}.
                 *
                 * @return the {@code EnvironmentalSetting}
                 * @throws NullPointerException if a required element is absent
                 */
                public EnvironmentalSetting build() {
                    return new EnvironmentalSetting(
                            id, extension, modifierExtension, type, value);
                }
            }
        }

        /** Builder for {@link StorageGuideline}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirUri reference;
            private List<Annotation> note = new ArrayList<>();
            private Duration stabilityDuration;
            private List<EnvironmentalSetting> environmentalSetting = new ArrayList<>();

            private Builder() {
            }

            private Builder(StorageGuideline original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.reference = original.reference();
                this.note = new ArrayList<>(original.note());
                this.stabilityDuration = original.stabilityDuration();
                this.environmentalSetting = new ArrayList<>(original.environmentalSetting());
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
             * Sets {@code reference}.
             *
             * @param reference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reference(FhirUri reference) {
                this.reference = reference;
                return this;
            }

            /**
             * Sets {@code reference}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param reference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reference(String reference) {
                return reference(reference == null ? null : FhirUri.of(reference));
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
             * Sets {@code stabilityDuration}.
             *
             * @param stabilityDuration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder stabilityDuration(Duration stabilityDuration) {
                this.stabilityDuration = stabilityDuration;
                return this;
            }

            /**
             * Replaces all {@code environmentalSetting} values.
             *
             * @param environmentalSetting the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder environmentalSetting(List<EnvironmentalSetting> environmentalSetting) {
                this.environmentalSetting = environmentalSetting == null
                        ? new ArrayList<>()
                        : new ArrayList<>(environmentalSetting);
                return this;
            }

            /**
             * Adds a {@code environmentalSetting} value.
             *
             * @param environmentalSetting the value to add
             * @return this builder
             */
            public Builder addEnvironmentalSetting(EnvironmentalSetting environmentalSetting) {
                this.environmentalSetting.add(Objects.requireNonNull(environmentalSetting, "environmentalSetting"));
                return this;
            }

            /**
             * Builds the {@code StorageGuideline}.
             *
             * @return the {@code StorageGuideline}
             */
            public StorageGuideline build() {
                return new StorageGuideline(
                        id, extension, modifierExtension, reference, note, stabilityDuration, environmentalSetting);
            }
        }
    }

    /**
     * Regulatory information about a medication.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param regulatoryAuthority Specifies the authority of the regulation. Reference to Organization. Required.
     * @param substitution Specifies if changes are allowed when dispensing a medication from a regulatory
     *   perspective.
     * @param schedule Specifies the schedule of a medication in jurisdiction.
     * @param maxDispense The maximum number of units of the medication that can be dispensed in a period.
     */
    public record Regulatory(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference regulatoryAuthority,
            List<Substitution> substitution,
            List<CodeableConcept> schedule,
            MaxDispense maxDispense) implements BackboneElement {

        /**
         * Creates a {@code Regulatory}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Regulatory {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            substitution = substitution == null ? List.of() : List.copyOf(substitution);
            schedule = schedule == null ? List.of() : List.copyOf(schedule);
            Objects.requireNonNull(
                    regulatoryAuthority, "MedicationKnowledge.regulatory.regulatoryAuthority is required");
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
         * Returns a builder initialized with the values of this {@code Regulatory}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Specifies if changes are allowed when dispensing a medication from a regulatory perspective.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type Specifies the type of substitution allowed. Required.
         * @param allowed Specifies if regulation allows for changes in the medication when dispensing. Required.
         */
        public record Substitution(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                FhirBoolean allowed) implements BackboneElement {

            /**
             * Creates a {@code Substitution}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Substitution {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(type, "MedicationKnowledge.regulatory.substitution.type is required");
                Objects.requireNonNull(allowed, "MedicationKnowledge.regulatory.substitution.allowed is required");
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
             * Returns a builder initialized with the values of this {@code Substitution}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Substitution}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private FhirBoolean allowed;

                private Builder() {
                }

                private Builder(Substitution original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.allowed = original.allowed();
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
                 * Sets {@code allowed}.
                 *
                 * @param allowed the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder allowed(FhirBoolean allowed) {
                    this.allowed = allowed;
                    return this;
                }

                /**
                 * Sets {@code allowed}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param allowed the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder allowed(Boolean allowed) {
                    return allowed(allowed == null ? null : FhirBoolean.of(allowed));
                }

                /**
                 * Builds the {@code Substitution}.
                 *
                 * @return the {@code Substitution}
                 * @throws NullPointerException if a required element is absent
                 */
                public Substitution build() {
                    return new Substitution(
                            id, extension, modifierExtension, type, allowed);
                }
            }
        }

        /**
         * The maximum number of units of the medication that can be dispensed in a period.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param quantity The maximum number of units of the medication that can be dispensed. Required.
         * @param period The period that applies to the maximum number of units.
         */
        public record MaxDispense(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Quantity quantity,
                Duration period) implements BackboneElement {

            /**
             * Creates a {@code MaxDispense}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public MaxDispense {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(quantity, "MedicationKnowledge.regulatory.maxDispense.quantity is required");
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
             * Returns a builder initialized with the values of this {@code MaxDispense}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link MaxDispense}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Quantity quantity;
                private Duration period;

                private Builder() {
                }

                private Builder(MaxDispense original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.quantity = original.quantity();
                    this.period = original.period();
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
                 * Sets {@code quantity}.
                 *
                 * @param quantity the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder quantity(Quantity quantity) {
                    this.quantity = quantity;
                    return this;
                }

                /**
                 * Sets {@code period}.
                 *
                 * @param period the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder period(Duration period) {
                    this.period = period;
                    return this;
                }

                /**
                 * Builds the {@code MaxDispense}.
                 *
                 * @return the {@code MaxDispense}
                 * @throws NullPointerException if a required element is absent
                 */
                public MaxDispense build() {
                    return new MaxDispense(
                            id, extension, modifierExtension, quantity, period);
                }
            }
        }

        /** Builder for {@link Regulatory}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference regulatoryAuthority;
            private List<Substitution> substitution = new ArrayList<>();
            private List<CodeableConcept> schedule = new ArrayList<>();
            private MaxDispense maxDispense;

            private Builder() {
            }

            private Builder(Regulatory original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.regulatoryAuthority = original.regulatoryAuthority();
                this.substitution = new ArrayList<>(original.substitution());
                this.schedule = new ArrayList<>(original.schedule());
                this.maxDispense = original.maxDispense();
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
             * Sets {@code regulatoryAuthority}.
             *
             * @param regulatoryAuthority the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder regulatoryAuthority(Reference regulatoryAuthority) {
                this.regulatoryAuthority = regulatoryAuthority;
                return this;
            }

            /**
             * Replaces all {@code substitution} values.
             *
             * @param substitution the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder substitution(List<Substitution> substitution) {
                this.substitution = substitution == null ? new ArrayList<>() : new ArrayList<>(substitution);
                return this;
            }

            /**
             * Adds a {@code substitution} value.
             *
             * @param substitution the value to add
             * @return this builder
             */
            public Builder addSubstitution(Substitution substitution) {
                this.substitution.add(Objects.requireNonNull(substitution, "substitution"));
                return this;
            }

            /**
             * Replaces all {@code schedule} values.
             *
             * @param schedule the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder schedule(List<CodeableConcept> schedule) {
                this.schedule = schedule == null ? new ArrayList<>() : new ArrayList<>(schedule);
                return this;
            }

            /**
             * Adds a {@code schedule} value.
             *
             * @param schedule the value to add
             * @return this builder
             */
            public Builder addSchedule(CodeableConcept schedule) {
                this.schedule.add(Objects.requireNonNull(schedule, "schedule"));
                return this;
            }

            /**
             * Sets {@code maxDispense}.
             *
             * @param maxDispense the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder maxDispense(MaxDispense maxDispense) {
                this.maxDispense = maxDispense;
                return this;
            }

            /**
             * Builds the {@code Regulatory}.
             *
             * @return the {@code Regulatory}
             * @throws NullPointerException if a required element is absent
             */
            public Regulatory build() {
                return new Regulatory(
                        id, extension, modifierExtension, regulatoryAuthority, substitution, schedule, maxDispense);
            }
        }
    }

    /**
     * Along with the link to a Medicinal Product Definition resource, this information provides common definitional
     * elements that are needed to understand the specific medication that is being described.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param definition Definitional resources that provide more information about this medication. Reference to
     *   MedicinalProductDefinition.
     * @param doseForm powder | tablets | capsule +.
     * @param intendedRoute The intended or approved route of administration.
     * @param ingredient Active or inactive ingredient.
     * @param drugCharacteristic Specifies descriptive properties of the medicine.
     */
    public record Definitional(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Reference> definition,
            CodeableConcept doseForm,
            List<CodeableConcept> intendedRoute,
            List<Ingredient> ingredient,
            List<DrugCharacteristic> drugCharacteristic) implements BackboneElement {

        /**
         * Creates a {@code Definitional}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Definitional {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            definition = definition == null ? List.of() : List.copyOf(definition);
            intendedRoute = intendedRoute == null ? List.of() : List.copyOf(intendedRoute);
            ingredient = ingredient == null ? List.of() : List.copyOf(ingredient);
            drugCharacteristic = drugCharacteristic == null ? List.of() : List.copyOf(drugCharacteristic);
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
         * Returns a builder initialized with the values of this {@code Definitional}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Identifies a particular constituent of interest in the product.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param item Substances contained in the medication. Required.
         * @param type A code that defines the type of ingredient, active, base, etc.
         * @param strength Quantity of ingredient present. One of Ratio, CodeableConcept, Quantity.
         */
        public record Ingredient(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableReference item,
                CodeableConcept type,
                DataType strength) implements BackboneElement {

            /**
             * Creates an {@code Ingredient}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Ingredient {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(item, "MedicationKnowledge.definitional.ingredient.item is required");
                if (strength != null && !(strength instanceof Ratio
                        || strength instanceof CodeableConcept
                        || strength instanceof Quantity)) {
                    throw new IllegalArgumentException(
                            "MedicationKnowledge.definitional.ingredient.strength[x] does not allow "
                                    + strength.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code Ingredient}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Ingredient}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableReference item;
                private CodeableConcept type;
                private DataType strength;

                private Builder() {
                }

                private Builder(Ingredient original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.item = original.item();
                    this.type = original.type();
                    this.strength = original.strength();
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
                 * Sets {@code item}.
                 *
                 * @param item the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder item(CodeableReference item) {
                    this.item = item;
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
                 * Sets {@code strength} to a Ratio.
                 *
                 * @param strength the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder strength(Ratio strength) {
                    this.strength = strength;
                    return this;
                }

                /**
                 * Sets {@code strength} to a CodeableConcept.
                 *
                 * @param strength the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder strength(CodeableConcept strength) {
                    this.strength = strength;
                    return this;
                }

                /**
                 * Sets {@code strength} to a Quantity.
                 *
                 * @param strength the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder strength(Quantity strength) {
                    this.strength = strength;
                    return this;
                }

                /**
                 * Builds the {@code Ingredient}.
                 *
                 * @return the {@code Ingredient}
                 * @throws NullPointerException if a required element is absent
                 */
                public Ingredient build() {
                    return new Ingredient(
                            id, extension, modifierExtension, item, type, strength);
                }
            }
        }

        /**
         * Specifies descriptive properties of the medicine, such as color, shape, imprints, etc.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type Code specifying the type of characteristic of medication.
         * @param value Description of the characteristic. One of CodeableConcept, string, Quantity, base64Binary,
         *   Attachment.
         */
        public record DrugCharacteristic(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                DataType value) implements BackboneElement {

            /**
             * Creates a {@code DrugCharacteristic}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public DrugCharacteristic {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                if (value != null && !(value instanceof CodeableConcept
                        || value instanceof FhirString
                        || value instanceof Quantity
                        || value instanceof FhirBase64Binary
                        || value instanceof Attachment)) {
                    throw new IllegalArgumentException(
                            "MedicationKnowledge.definitional.drugCharacteristic.value[x] does not allow "
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
             * Returns a builder initialized with the values of this {@code DrugCharacteristic}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link DrugCharacteristic}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private DataType value;

                private Builder() {
                }

                private Builder(DrugCharacteristic original) {
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
                 * Sets {@code value} to a base64Binary.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirBase64Binary value) {
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
                 * Sets {@code value} to a string without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(String value) {
                    this.value = value == null ? null : FhirString.of(value);
                    return this;
                }

                /**
                 * Builds the {@code DrugCharacteristic}.
                 *
                 * @return the {@code DrugCharacteristic}
                 */
                public DrugCharacteristic build() {
                    return new DrugCharacteristic(
                            id, extension, modifierExtension, type, value);
                }
            }
        }

        /** Builder for {@link Definitional}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Reference> definition = new ArrayList<>();
            private CodeableConcept doseForm;
            private List<CodeableConcept> intendedRoute = new ArrayList<>();
            private List<Ingredient> ingredient = new ArrayList<>();
            private List<DrugCharacteristic> drugCharacteristic = new ArrayList<>();

            private Builder() {
            }

            private Builder(Definitional original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.definition = new ArrayList<>(original.definition());
                this.doseForm = original.doseForm();
                this.intendedRoute = new ArrayList<>(original.intendedRoute());
                this.ingredient = new ArrayList<>(original.ingredient());
                this.drugCharacteristic = new ArrayList<>(original.drugCharacteristic());
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
             * Replaces all {@code definition} values.
             *
             * @param definition the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder definition(List<Reference> definition) {
                this.definition = definition == null ? new ArrayList<>() : new ArrayList<>(definition);
                return this;
            }

            /**
             * Adds a {@code definition} value.
             *
             * @param definition the value to add
             * @return this builder
             */
            public Builder addDefinition(Reference definition) {
                this.definition.add(Objects.requireNonNull(definition, "definition"));
                return this;
            }

            /**
             * Sets {@code doseForm}.
             *
             * @param doseForm the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder doseForm(CodeableConcept doseForm) {
                this.doseForm = doseForm;
                return this;
            }

            /**
             * Replaces all {@code intendedRoute} values.
             *
             * @param intendedRoute the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder intendedRoute(List<CodeableConcept> intendedRoute) {
                this.intendedRoute = intendedRoute == null ? new ArrayList<>() : new ArrayList<>(intendedRoute);
                return this;
            }

            /**
             * Adds a {@code intendedRoute} value.
             *
             * @param intendedRoute the value to add
             * @return this builder
             */
            public Builder addIntendedRoute(CodeableConcept intendedRoute) {
                this.intendedRoute.add(Objects.requireNonNull(intendedRoute, "intendedRoute"));
                return this;
            }

            /**
             * Replaces all {@code ingredient} values.
             *
             * @param ingredient the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder ingredient(List<Ingredient> ingredient) {
                this.ingredient = ingredient == null ? new ArrayList<>() : new ArrayList<>(ingredient);
                return this;
            }

            /**
             * Adds a {@code ingredient} value.
             *
             * @param ingredient the value to add
             * @return this builder
             */
            public Builder addIngredient(Ingredient ingredient) {
                this.ingredient.add(Objects.requireNonNull(ingredient, "ingredient"));
                return this;
            }

            /**
             * Replaces all {@code drugCharacteristic} values.
             *
             * @param drugCharacteristic the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder drugCharacteristic(List<DrugCharacteristic> drugCharacteristic) {
                this.drugCharacteristic = drugCharacteristic == null
                        ? new ArrayList<>()
                        : new ArrayList<>(drugCharacteristic);
                return this;
            }

            /**
             * Adds a {@code drugCharacteristic} value.
             *
             * @param drugCharacteristic the value to add
             * @return this builder
             */
            public Builder addDrugCharacteristic(DrugCharacteristic drugCharacteristic) {
                this.drugCharacteristic.add(Objects.requireNonNull(drugCharacteristic, "drugCharacteristic"));
                return this;
            }

            /**
             * Builds the {@code Definitional}.
             *
             * @return the {@code Definitional}
             */
            public Definitional build() {
                return new Definitional(
                        id, extension, modifierExtension, definition, doseForm, intendedRoute, ingredient,
                        drugCharacteristic);
            }
        }
    }

    /** Builder for {@link MedicationKnowledge}. Builders are mutable and not thread-safe. */
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
        private CodeableConcept code;
        private FhirEnum<MedicationKnowledgeStatusCodes> status;
        private Reference author;
        private List<CodeableConcept> intendedJurisdiction = new ArrayList<>();
        private List<FhirString> name = new ArrayList<>();
        private List<RelatedMedicationKnowledge> relatedMedicationKnowledge = new ArrayList<>();
        private List<Reference> associatedMedication = new ArrayList<>();
        private List<CodeableConcept> productType = new ArrayList<>();
        private List<Monograph> monograph = new ArrayList<>();
        private FhirMarkdown preparationInstruction;
        private List<Cost> cost = new ArrayList<>();
        private List<MonitoringProgram> monitoringProgram = new ArrayList<>();
        private List<IndicationGuideline> indicationGuideline = new ArrayList<>();
        private List<MedicineClassification> medicineClassification = new ArrayList<>();
        private List<Packaging> packaging = new ArrayList<>();
        private List<Reference> clinicalUseIssue = new ArrayList<>();
        private List<StorageGuideline> storageGuideline = new ArrayList<>();
        private List<Regulatory> regulatory = new ArrayList<>();
        private Definitional definitional;

        private Builder() {
        }

        private Builder(MedicationKnowledge original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.code = original.code();
            this.status = original.status();
            this.author = original.author();
            this.intendedJurisdiction = new ArrayList<>(original.intendedJurisdiction());
            this.name = new ArrayList<>(original.name());
            this.relatedMedicationKnowledge = new ArrayList<>(original.relatedMedicationKnowledge());
            this.associatedMedication = new ArrayList<>(original.associatedMedication());
            this.productType = new ArrayList<>(original.productType());
            this.monograph = new ArrayList<>(original.monograph());
            this.preparationInstruction = original.preparationInstruction();
            this.cost = new ArrayList<>(original.cost());
            this.monitoringProgram = new ArrayList<>(original.monitoringProgram());
            this.indicationGuideline = new ArrayList<>(original.indicationGuideline());
            this.medicineClassification = new ArrayList<>(original.medicineClassification());
            this.packaging = new ArrayList<>(original.packaging());
            this.clinicalUseIssue = new ArrayList<>(original.clinicalUseIssue());
            this.storageGuideline = new ArrayList<>(original.storageGuideline());
            this.regulatory = new ArrayList<>(original.regulatory());
            this.definitional = original.definitional();
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
        public Builder status(FhirEnum<MedicationKnowledgeStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(MedicationKnowledgeStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code author}.
         *
         * @param author the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder author(Reference author) {
            this.author = author;
            return this;
        }

        /**
         * Replaces all {@code intendedJurisdiction} values.
         *
         * @param intendedJurisdiction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder intendedJurisdiction(List<CodeableConcept> intendedJurisdiction) {
            this.intendedJurisdiction = intendedJurisdiction == null
                    ? new ArrayList<>()
                    : new ArrayList<>(intendedJurisdiction);
            return this;
        }

        /**
         * Adds a {@code intendedJurisdiction} value.
         *
         * @param intendedJurisdiction the value to add
         * @return this builder
         */
        public Builder addIntendedJurisdiction(CodeableConcept intendedJurisdiction) {
            this.intendedJurisdiction.add(Objects.requireNonNull(intendedJurisdiction, "intendedJurisdiction"));
            return this;
        }

        /**
         * Replaces all {@code name} values.
         *
         * @param name the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder name(List<FhirString> name) {
            this.name = name == null ? new ArrayList<>() : new ArrayList<>(name);
            return this;
        }

        /**
         * Adds a {@code name} value.
         *
         * @param name the value to add
         * @return this builder
         */
        public Builder addName(FhirString name) {
            this.name.add(Objects.requireNonNull(name, "name"));
            return this;
        }

        /**
         * Adds a {@code name} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param name the value to add
         * @return this builder
         */
        public Builder addName(String name) {
            return addName(FhirString.of(name));
        }

        /**
         * Replaces all {@code relatedMedicationKnowledge} values.
         *
         * @param relatedMedicationKnowledge the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relatedMedicationKnowledge(List<RelatedMedicationKnowledge> relatedMedicationKnowledge) {
            this.relatedMedicationKnowledge = relatedMedicationKnowledge == null
                    ? new ArrayList<>()
                    : new ArrayList<>(relatedMedicationKnowledge);
            return this;
        }

        /**
         * Adds a {@code relatedMedicationKnowledge} value.
         *
         * @param relatedMedicationKnowledge the value to add
         * @return this builder
         */
        public Builder addRelatedMedicationKnowledge(RelatedMedicationKnowledge relatedMedicationKnowledge) {
            this.relatedMedicationKnowledge.add(
                    Objects.requireNonNull(relatedMedicationKnowledge, "relatedMedicationKnowledge"));
            return this;
        }

        /**
         * Replaces all {@code associatedMedication} values.
         *
         * @param associatedMedication the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder associatedMedication(List<Reference> associatedMedication) {
            this.associatedMedication = associatedMedication == null
                    ? new ArrayList<>()
                    : new ArrayList<>(associatedMedication);
            return this;
        }

        /**
         * Adds a {@code associatedMedication} value.
         *
         * @param associatedMedication the value to add
         * @return this builder
         */
        public Builder addAssociatedMedication(Reference associatedMedication) {
            this.associatedMedication.add(Objects.requireNonNull(associatedMedication, "associatedMedication"));
            return this;
        }

        /**
         * Replaces all {@code productType} values.
         *
         * @param productType the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder productType(List<CodeableConcept> productType) {
            this.productType = productType == null ? new ArrayList<>() : new ArrayList<>(productType);
            return this;
        }

        /**
         * Adds a {@code productType} value.
         *
         * @param productType the value to add
         * @return this builder
         */
        public Builder addProductType(CodeableConcept productType) {
            this.productType.add(Objects.requireNonNull(productType, "productType"));
            return this;
        }

        /**
         * Replaces all {@code monograph} values.
         *
         * @param monograph the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder monograph(List<Monograph> monograph) {
            this.monograph = monograph == null ? new ArrayList<>() : new ArrayList<>(monograph);
            return this;
        }

        /**
         * Adds a {@code monograph} value.
         *
         * @param monograph the value to add
         * @return this builder
         */
        public Builder addMonograph(Monograph monograph) {
            this.monograph.add(Objects.requireNonNull(monograph, "monograph"));
            return this;
        }

        /**
         * Sets {@code preparationInstruction}.
         *
         * @param preparationInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preparationInstruction(FhirMarkdown preparationInstruction) {
            this.preparationInstruction = preparationInstruction;
            return this;
        }

        /**
         * Sets {@code preparationInstruction}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param preparationInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preparationInstruction(String preparationInstruction) {
            return preparationInstruction(
                    preparationInstruction == null ? null : FhirMarkdown.of(preparationInstruction));
        }

        /**
         * Replaces all {@code cost} values.
         *
         * @param cost the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder cost(List<Cost> cost) {
            this.cost = cost == null ? new ArrayList<>() : new ArrayList<>(cost);
            return this;
        }

        /**
         * Adds a {@code cost} value.
         *
         * @param cost the value to add
         * @return this builder
         */
        public Builder addCost(Cost cost) {
            this.cost.add(Objects.requireNonNull(cost, "cost"));
            return this;
        }

        /**
         * Replaces all {@code monitoringProgram} values.
         *
         * @param monitoringProgram the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder monitoringProgram(List<MonitoringProgram> monitoringProgram) {
            this.monitoringProgram = monitoringProgram == null
                    ? new ArrayList<>()
                    : new ArrayList<>(monitoringProgram);
            return this;
        }

        /**
         * Adds a {@code monitoringProgram} value.
         *
         * @param monitoringProgram the value to add
         * @return this builder
         */
        public Builder addMonitoringProgram(MonitoringProgram monitoringProgram) {
            this.monitoringProgram.add(Objects.requireNonNull(monitoringProgram, "monitoringProgram"));
            return this;
        }

        /**
         * Replaces all {@code indicationGuideline} values.
         *
         * @param indicationGuideline the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder indicationGuideline(List<IndicationGuideline> indicationGuideline) {
            this.indicationGuideline = indicationGuideline == null
                    ? new ArrayList<>()
                    : new ArrayList<>(indicationGuideline);
            return this;
        }

        /**
         * Adds a {@code indicationGuideline} value.
         *
         * @param indicationGuideline the value to add
         * @return this builder
         */
        public Builder addIndicationGuideline(IndicationGuideline indicationGuideline) {
            this.indicationGuideline.add(Objects.requireNonNull(indicationGuideline, "indicationGuideline"));
            return this;
        }

        /**
         * Replaces all {@code medicineClassification} values.
         *
         * @param medicineClassification the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder medicineClassification(List<MedicineClassification> medicineClassification) {
            this.medicineClassification = medicineClassification == null
                    ? new ArrayList<>()
                    : new ArrayList<>(medicineClassification);
            return this;
        }

        /**
         * Adds a {@code medicineClassification} value.
         *
         * @param medicineClassification the value to add
         * @return this builder
         */
        public Builder addMedicineClassification(MedicineClassification medicineClassification) {
            this.medicineClassification.add(Objects.requireNonNull(medicineClassification, "medicineClassification"));
            return this;
        }

        /**
         * Replaces all {@code packaging} values.
         *
         * @param packaging the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder packaging(List<Packaging> packaging) {
            this.packaging = packaging == null ? new ArrayList<>() : new ArrayList<>(packaging);
            return this;
        }

        /**
         * Adds a {@code packaging} value.
         *
         * @param packaging the value to add
         * @return this builder
         */
        public Builder addPackaging(Packaging packaging) {
            this.packaging.add(Objects.requireNonNull(packaging, "packaging"));
            return this;
        }

        /**
         * Replaces all {@code clinicalUseIssue} values.
         *
         * @param clinicalUseIssue the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder clinicalUseIssue(List<Reference> clinicalUseIssue) {
            this.clinicalUseIssue = clinicalUseIssue == null ? new ArrayList<>() : new ArrayList<>(clinicalUseIssue);
            return this;
        }

        /**
         * Adds a {@code clinicalUseIssue} value.
         *
         * @param clinicalUseIssue the value to add
         * @return this builder
         */
        public Builder addClinicalUseIssue(Reference clinicalUseIssue) {
            this.clinicalUseIssue.add(Objects.requireNonNull(clinicalUseIssue, "clinicalUseIssue"));
            return this;
        }

        /**
         * Replaces all {@code storageGuideline} values.
         *
         * @param storageGuideline the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder storageGuideline(List<StorageGuideline> storageGuideline) {
            this.storageGuideline = storageGuideline == null ? new ArrayList<>() : new ArrayList<>(storageGuideline);
            return this;
        }

        /**
         * Adds a {@code storageGuideline} value.
         *
         * @param storageGuideline the value to add
         * @return this builder
         */
        public Builder addStorageGuideline(StorageGuideline storageGuideline) {
            this.storageGuideline.add(Objects.requireNonNull(storageGuideline, "storageGuideline"));
            return this;
        }

        /**
         * Replaces all {@code regulatory} values.
         *
         * @param regulatory the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder regulatory(List<Regulatory> regulatory) {
            this.regulatory = regulatory == null ? new ArrayList<>() : new ArrayList<>(regulatory);
            return this;
        }

        /**
         * Adds a {@code regulatory} value.
         *
         * @param regulatory the value to add
         * @return this builder
         */
        public Builder addRegulatory(Regulatory regulatory) {
            this.regulatory.add(Objects.requireNonNull(regulatory, "regulatory"));
            return this;
        }

        /**
         * Sets {@code definitional}.
         *
         * @param definitional the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder definitional(Definitional definitional) {
            this.definitional = definitional;
            return this;
        }

        /**
         * Builds the {@code MedicationKnowledge}.
         *
         * @return the {@code MedicationKnowledge}
         */
        public MedicationKnowledge build() {
            return new MedicationKnowledge(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    code, status, author, intendedJurisdiction, name, relatedMedicationKnowledge,
                    associatedMedication, productType, monograph, preparationInstruction, cost, monitoringProgram,
                    indicationGuideline, medicineClassification, packaging, clinicalUseIssue, storageGuideline,
                    regulatory, definitional);
        }
    }
}
