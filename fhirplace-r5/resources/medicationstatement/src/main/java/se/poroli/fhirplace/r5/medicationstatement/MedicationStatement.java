package se.poroli.fhirplace.r5.medicationstatement;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Dosage;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * A record of a medication that is being consumed by a patient.
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
 * @param identifier External identifier.
 * @param partOf Part of referenced event. Reference to Procedure, MedicationStatement.
 * @param status recorded | entered-in-error | draft. Required. Modifier element.
 * @param category Type of medication statement.
 * @param medication What medication was taken. Required.
 * @param subject Who is/was taking the medication. Reference to Patient, Group. Required.
 * @param encounter Encounter associated with MedicationStatement. Reference to Encounter.
 * @param effective The date/time or interval when the medication is/was/will be taken. One of dateTime, Period,
 *   Timing.
 * @param dateAsserted When the usage was asserted?.
 * @param informationSource Person or organization that provided the information about the taking of this medication.
 *   Reference to Patient, Practitioner, PractitionerRole, RelatedPerson, Organization.
 * @param derivedFrom Link to information used to derive the MedicationStatement. Reference to Resource.
 * @param reason Reason for why the medication is being/was taken.
 * @param note Further information about the usage.
 * @param relatedClinicalInformation Link to information relevant to the usage of a medication. Reference to
 *   Observation, Condition.
 * @param renderedDosageInstruction Full representation of the dosage instructions.
 * @param dosage Details of how medication is/was taken or should be taken.
 * @param adherence Indicates whether the medication is or is not being consumed or administered.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MedicationStatement">FHIR R5 MedicationStatement</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record MedicationStatement(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        List<Reference> partOf,
        FhirEnum<MedicationStatementStatusCodes> status,
        List<CodeableConcept> category,
        CodeableReference medication,
        Reference subject,
        Reference encounter,
        DataType effective,
        FhirDateTime dateAsserted,
        List<Reference> informationSource,
        List<Reference> derivedFrom,
        List<CodeableReference> reason,
        List<Annotation> note,
        List<Reference> relatedClinicalInformation,
        FhirMarkdown renderedDosageInstruction,
        List<Dosage> dosage,
        Adherence adherence) implements DomainResource {

    /**
     * Creates a {@code MedicationStatement}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public MedicationStatement {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        category = category == null ? List.of() : List.copyOf(category);
        informationSource = informationSource == null ? List.of() : List.copyOf(informationSource);
        derivedFrom = derivedFrom == null ? List.of() : List.copyOf(derivedFrom);
        reason = reason == null ? List.of() : List.copyOf(reason);
        note = note == null ? List.of() : List.copyOf(note);
        relatedClinicalInformation =
                relatedClinicalInformation == null ? List.of() : List.copyOf(relatedClinicalInformation);
        dosage = dosage == null ? List.of() : List.copyOf(dosage);
        Objects.requireNonNull(status, "MedicationStatement.status is required");
        Objects.requireNonNull(medication, "MedicationStatement.medication is required");
        Objects.requireNonNull(subject, "MedicationStatement.subject is required");
        if (effective != null && !(effective instanceof FhirDateTime
                || effective instanceof Period
                || effective instanceof Timing)) {
            throw new IllegalArgumentException(
                    "MedicationStatement.effective[x] must be one of dateTime, Period, Timing, but was "
                            + effective.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code MedicationStatement}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates whether the medication is or is not being consumed or administered.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Type of adherence. Required.
     * @param reason Details of the reason for the current use of the medication.
     */
    public record Adherence(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            CodeableConcept reason) implements BackboneElement {

        /**
         * Creates an {@code Adherence}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Adherence {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(code, "MedicationStatement.adherence.code is required");
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
         * Returns a builder initialized with the values of this {@code Adherence}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Adherence}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private CodeableConcept reason;

            private Builder() {
            }

            private Builder(Adherence original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.reason = original.reason();
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
             * Sets {@code reason}.
             *
             * @param reason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reason(CodeableConcept reason) {
                this.reason = reason;
                return this;
            }

            /**
             * Builds the {@code Adherence}.
             *
             * @return the {@code Adherence}
             * @throws NullPointerException if a required element is absent
             */
            public Adherence build() {
                return new Adherence(
                        id, extension, modifierExtension, code, reason);
            }
        }
    }

    /** Builder for {@link MedicationStatement}. Builders are mutable and not thread-safe. */
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
        private List<Reference> partOf = new ArrayList<>();
        private FhirEnum<MedicationStatementStatusCodes> status;
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableReference medication;
        private Reference subject;
        private Reference encounter;
        private DataType effective;
        private FhirDateTime dateAsserted;
        private List<Reference> informationSource = new ArrayList<>();
        private List<Reference> derivedFrom = new ArrayList<>();
        private List<CodeableReference> reason = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<Reference> relatedClinicalInformation = new ArrayList<>();
        private FhirMarkdown renderedDosageInstruction;
        private List<Dosage> dosage = new ArrayList<>();
        private Adherence adherence;

        private Builder() {
        }

        private Builder(MedicationStatement original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.partOf = new ArrayList<>(original.partOf());
            this.status = original.status();
            this.category = new ArrayList<>(original.category());
            this.medication = original.medication();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.effective = original.effective();
            this.dateAsserted = original.dateAsserted();
            this.informationSource = new ArrayList<>(original.informationSource());
            this.derivedFrom = new ArrayList<>(original.derivedFrom());
            this.reason = new ArrayList<>(original.reason());
            this.note = new ArrayList<>(original.note());
            this.relatedClinicalInformation = new ArrayList<>(original.relatedClinicalInformation());
            this.renderedDosageInstruction = original.renderedDosageInstruction();
            this.dosage = new ArrayList<>(original.dosage());
            this.adherence = original.adherence();
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
         * Replaces all {@code partOf} values.
         *
         * @param partOf the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder partOf(List<Reference> partOf) {
            this.partOf = partOf == null ? new ArrayList<>() : new ArrayList<>(partOf);
            return this;
        }

        /**
         * Adds a {@code partOf} value.
         *
         * @param partOf the value to add
         * @return this builder
         */
        public Builder addPartOf(Reference partOf) {
            this.partOf.add(Objects.requireNonNull(partOf, "partOf"));
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<MedicationStatementStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(MedicationStatementStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Replaces all {@code category} values.
         *
         * @param category the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder category(List<CodeableConcept> category) {
            this.category = category == null ? new ArrayList<>() : new ArrayList<>(category);
            return this;
        }

        /**
         * Adds a {@code category} value.
         *
         * @param category the value to add
         * @return this builder
         */
        public Builder addCategory(CodeableConcept category) {
            this.category.add(Objects.requireNonNull(category, "category"));
            return this;
        }

        /**
         * Sets {@code medication}.
         *
         * @param medication the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder medication(CodeableReference medication) {
            this.medication = medication;
            return this;
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
         * Sets {@code encounter}.
         *
         * @param encounter the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder encounter(Reference encounter) {
            this.encounter = encounter;
            return this;
        }

        /**
         * Sets {@code effective} to a dateTime.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(FhirDateTime effective) {
            this.effective = effective;
            return this;
        }

        /**
         * Sets {@code effective} to a Period.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(Period effective) {
            this.effective = effective;
            return this;
        }

        /**
         * Sets {@code effective} to a Timing.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(Timing effective) {
            this.effective = effective;
            return this;
        }

        /**
         * Sets {@code effective} to a dateTime without id or extensions.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(Temporal effective) {
            this.effective = effective == null ? null : FhirDateTime.of(effective);
            return this;
        }

        /**
         * Sets {@code dateAsserted}.
         *
         * @param dateAsserted the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dateAsserted(FhirDateTime dateAsserted) {
            this.dateAsserted = dateAsserted;
            return this;
        }

        /**
         * Sets {@code dateAsserted}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param dateAsserted the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dateAsserted(Temporal dateAsserted) {
            return dateAsserted(dateAsserted == null ? null : FhirDateTime.of(dateAsserted));
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
         * Replaces all {@code derivedFrom} values.
         *
         * @param derivedFrom the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder derivedFrom(List<Reference> derivedFrom) {
            this.derivedFrom = derivedFrom == null ? new ArrayList<>() : new ArrayList<>(derivedFrom);
            return this;
        }

        /**
         * Adds a {@code derivedFrom} value.
         *
         * @param derivedFrom the value to add
         * @return this builder
         */
        public Builder addDerivedFrom(Reference derivedFrom) {
            this.derivedFrom.add(Objects.requireNonNull(derivedFrom, "derivedFrom"));
            return this;
        }

        /**
         * Replaces all {@code reason} values.
         *
         * @param reason the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reason(List<CodeableReference> reason) {
            this.reason = reason == null ? new ArrayList<>() : new ArrayList<>(reason);
            return this;
        }

        /**
         * Adds a {@code reason} value.
         *
         * @param reason the value to add
         * @return this builder
         */
        public Builder addReason(CodeableReference reason) {
            this.reason.add(Objects.requireNonNull(reason, "reason"));
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
         * Replaces all {@code relatedClinicalInformation} values.
         *
         * @param relatedClinicalInformation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relatedClinicalInformation(List<Reference> relatedClinicalInformation) {
            this.relatedClinicalInformation = relatedClinicalInformation == null
                    ? new ArrayList<>()
                    : new ArrayList<>(relatedClinicalInformation);
            return this;
        }

        /**
         * Adds a {@code relatedClinicalInformation} value.
         *
         * @param relatedClinicalInformation the value to add
         * @return this builder
         */
        public Builder addRelatedClinicalInformation(Reference relatedClinicalInformation) {
            this.relatedClinicalInformation.add(
                    Objects.requireNonNull(relatedClinicalInformation, "relatedClinicalInformation"));
            return this;
        }

        /**
         * Sets {@code renderedDosageInstruction}.
         *
         * @param renderedDosageInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder renderedDosageInstruction(FhirMarkdown renderedDosageInstruction) {
            this.renderedDosageInstruction = renderedDosageInstruction;
            return this;
        }

        /**
         * Sets {@code renderedDosageInstruction}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param renderedDosageInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder renderedDosageInstruction(String renderedDosageInstruction) {
            return renderedDosageInstruction(
                    renderedDosageInstruction == null ? null : FhirMarkdown.of(renderedDosageInstruction));
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
         * Sets {@code adherence}.
         *
         * @param adherence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder adherence(Adherence adherence) {
            this.adherence = adherence;
            return this;
        }

        /**
         * Builds the {@code MedicationStatement}.
         *
         * @return the {@code MedicationStatement}
         * @throws NullPointerException if a required element is absent
         */
        public MedicationStatement build() {
            return new MedicationStatement(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    partOf, status, category, medication, subject, encounter, effective, dateAsserted,
                    informationSource, derivedFrom, reason, note, relatedClinicalInformation,
                    renderedDosageInstruction, dosage, adherence);
        }
    }
}
