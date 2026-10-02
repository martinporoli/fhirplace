package se.poroli.fhirplace.r5.diagnosticreport;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.OffsetDateTime;
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
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * The findings and interpretation of diagnostic tests performed on patients, groups of patients, products,
 * substances, devices, and locations, and/or specimens derived from these.
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
 * @param identifier Business identifier for report.
 * @param basedOn What was requested. Reference to CarePlan, ImmunizationRecommendation, MedicationRequest,
 *   NutritionOrder, ServiceRequest.
 * @param status registered | partial | preliminary | modified | final | amended | corrected | appended | cancelled |
 *   entered-in-error | unknown. Required. Modifier element.
 * @param category Service category.
 * @param code Name/Code for this diagnostic report. Required.
 * @param subject The subject of the report - usually, but not always, the patient. Reference to Patient, Group,
 *   Device, Location, Organization, Practitioner, Medication, Substance, BiologicallyDerivedProduct.
 * @param encounter Health care event when test ordered. Reference to Encounter.
 * @param effective Clinically relevant time/time-period for report. One of dateTime, Period.
 * @param issued DateTime this version was made.
 * @param performer Responsible Diagnostic Service. Reference to Practitioner, PractitionerRole, Organization,
 *   CareTeam.
 * @param resultsInterpreter Primary result interpreter. Reference to Practitioner, PractitionerRole, Organization,
 *   CareTeam.
 * @param specimen Specimens this report is based on. Reference to Specimen.
 * @param result Observations. Reference to Observation.
 * @param note Comments about the diagnostic report.
 * @param study Reference to full details of an analysis associated with the diagnostic report. Reference to
 *   GenomicStudy, ImagingStudy.
 * @param supportingInfo Additional information supporting the diagnostic report.
 * @param media Key images or data associated with this report.
 * @param composition Reference to a Composition resource for the DiagnosticReport structure. Reference to
 *   Composition.
 * @param conclusion Clinical conclusion (interpretation) of test results.
 * @param conclusionCode Codes for the clinical conclusion of test results.
 * @param presentedForm Entire report as issued.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DiagnosticReport">FHIR R5 DiagnosticReport</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record DiagnosticReport(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        List<Reference> basedOn,
        FhirEnum<DiagnosticReportStatus> status,
        List<CodeableConcept> category,
        CodeableConcept code,
        Reference subject,
        Reference encounter,
        DataType effective,
        FhirInstant issued,
        List<Reference> performer,
        List<Reference> resultsInterpreter,
        List<Reference> specimen,
        List<Reference> result,
        List<Annotation> note,
        List<Reference> study,
        List<SupportingInfo> supportingInfo,
        List<Media> media,
        Reference composition,
        FhirMarkdown conclusion,
        List<CodeableConcept> conclusionCode,
        List<Attachment> presentedForm) implements DomainResource {

    /**
     * Creates a {@code DiagnosticReport}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public DiagnosticReport {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        category = category == null ? List.of() : List.copyOf(category);
        performer = performer == null ? List.of() : List.copyOf(performer);
        resultsInterpreter = resultsInterpreter == null ? List.of() : List.copyOf(resultsInterpreter);
        specimen = specimen == null ? List.of() : List.copyOf(specimen);
        result = result == null ? List.of() : List.copyOf(result);
        note = note == null ? List.of() : List.copyOf(note);
        study = study == null ? List.of() : List.copyOf(study);
        supportingInfo = supportingInfo == null ? List.of() : List.copyOf(supportingInfo);
        media = media == null ? List.of() : List.copyOf(media);
        conclusionCode = conclusionCode == null ? List.of() : List.copyOf(conclusionCode);
        presentedForm = presentedForm == null ? List.of() : List.copyOf(presentedForm);
        Objects.requireNonNull(status, "DiagnosticReport.status is required");
        Objects.requireNonNull(code, "DiagnosticReport.code is required");
        if (effective != null && !(effective instanceof FhirDateTime || effective instanceof Period)) {
            throw new IllegalArgumentException(
                    "DiagnosticReport.effective[x] must be one of dateTime, Period, but was "
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
     * Returns a builder initialized with the values of this {@code DiagnosticReport}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * This backbone element contains supporting information that was used in the creation of the report not included
     * in the results already included in the report.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Supporting information role code. Required.
     * @param reference Supporting information reference. Reference to Procedure, Observation, DiagnosticReport,
     *   Citation. Required.
     */
    public record SupportingInfo(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            Reference reference) implements BackboneElement {

        /**
         * Creates a {@code SupportingInfo}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public SupportingInfo {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "DiagnosticReport.supportingInfo.type is required");
            Objects.requireNonNull(reference, "DiagnosticReport.supportingInfo.reference is required");
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
         * Returns a builder initialized with the values of this {@code SupportingInfo}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link SupportingInfo}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private Reference reference;

            private Builder() {
            }

            private Builder(SupportingInfo original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.reference = original.reference();
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
             * Sets {@code reference}.
             *
             * @param reference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reference(Reference reference) {
                this.reference = reference;
                return this;
            }

            /**
             * Builds the {@code SupportingInfo}.
             *
             * @return the {@code SupportingInfo}
             * @throws NullPointerException if a required element is absent
             */
            public SupportingInfo build() {
                return new SupportingInfo(
                        id, extension, modifierExtension, type, reference);
            }
        }
    }

    /**
     * A list of key images or data associated with this report.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param comment Comment about the image or data (e.g. explanation).
     * @param link Reference to the image or data source. Reference to DocumentReference. Required.
     */
    public record Media(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString comment,
            Reference link) implements BackboneElement {

        /**
         * Creates a {@code Media}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Media {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(link, "DiagnosticReport.media.link is required");
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
         * Returns a builder initialized with the values of this {@code Media}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Media}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString comment;
            private Reference link;

            private Builder() {
            }

            private Builder(Media original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.comment = original.comment();
                this.link = original.link();
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
             * Sets {@code link}.
             *
             * @param link the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder link(Reference link) {
                this.link = link;
                return this;
            }

            /**
             * Builds the {@code Media}.
             *
             * @return the {@code Media}
             * @throws NullPointerException if a required element is absent
             */
            public Media build() {
                return new Media(
                        id, extension, modifierExtension, comment, link);
            }
        }
    }

    /** Builder for {@link DiagnosticReport}. Builders are mutable and not thread-safe. */
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
        private List<Reference> basedOn = new ArrayList<>();
        private FhirEnum<DiagnosticReportStatus> status;
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableConcept code;
        private Reference subject;
        private Reference encounter;
        private DataType effective;
        private FhirInstant issued;
        private List<Reference> performer = new ArrayList<>();
        private List<Reference> resultsInterpreter = new ArrayList<>();
        private List<Reference> specimen = new ArrayList<>();
        private List<Reference> result = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<Reference> study = new ArrayList<>();
        private List<SupportingInfo> supportingInfo = new ArrayList<>();
        private List<Media> media = new ArrayList<>();
        private Reference composition;
        private FhirMarkdown conclusion;
        private List<CodeableConcept> conclusionCode = new ArrayList<>();
        private List<Attachment> presentedForm = new ArrayList<>();

        private Builder() {
        }

        private Builder(DiagnosticReport original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.basedOn = new ArrayList<>(original.basedOn());
            this.status = original.status();
            this.category = new ArrayList<>(original.category());
            this.code = original.code();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.effective = original.effective();
            this.issued = original.issued();
            this.performer = new ArrayList<>(original.performer());
            this.resultsInterpreter = new ArrayList<>(original.resultsInterpreter());
            this.specimen = new ArrayList<>(original.specimen());
            this.result = new ArrayList<>(original.result());
            this.note = new ArrayList<>(original.note());
            this.study = new ArrayList<>(original.study());
            this.supportingInfo = new ArrayList<>(original.supportingInfo());
            this.media = new ArrayList<>(original.media());
            this.composition = original.composition();
            this.conclusion = original.conclusion();
            this.conclusionCode = new ArrayList<>(original.conclusionCode());
            this.presentedForm = new ArrayList<>(original.presentedForm());
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
         * Replaces all {@code basedOn} values.
         *
         * @param basedOn the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder basedOn(List<Reference> basedOn) {
            this.basedOn = basedOn == null ? new ArrayList<>() : new ArrayList<>(basedOn);
            return this;
        }

        /**
         * Adds a {@code basedOn} value.
         *
         * @param basedOn the value to add
         * @return this builder
         */
        public Builder addBasedOn(Reference basedOn) {
            this.basedOn.add(Objects.requireNonNull(basedOn, "basedOn"));
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<DiagnosticReportStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(DiagnosticReportStatus status) {
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
         * Sets {@code issued}.
         *
         * @param issued the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issued(FhirInstant issued) {
            this.issued = issued;
            return this;
        }

        /**
         * Sets {@code issued}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param issued the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issued(OffsetDateTime issued) {
            return issued(issued == null ? null : FhirInstant.of(issued));
        }

        /**
         * Replaces all {@code performer} values.
         *
         * @param performer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder performer(List<Reference> performer) {
            this.performer = performer == null ? new ArrayList<>() : new ArrayList<>(performer);
            return this;
        }

        /**
         * Adds a {@code performer} value.
         *
         * @param performer the value to add
         * @return this builder
         */
        public Builder addPerformer(Reference performer) {
            this.performer.add(Objects.requireNonNull(performer, "performer"));
            return this;
        }

        /**
         * Replaces all {@code resultsInterpreter} values.
         *
         * @param resultsInterpreter the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder resultsInterpreter(List<Reference> resultsInterpreter) {
            this.resultsInterpreter = resultsInterpreter == null
                    ? new ArrayList<>()
                    : new ArrayList<>(resultsInterpreter);
            return this;
        }

        /**
         * Adds a {@code resultsInterpreter} value.
         *
         * @param resultsInterpreter the value to add
         * @return this builder
         */
        public Builder addResultsInterpreter(Reference resultsInterpreter) {
            this.resultsInterpreter.add(Objects.requireNonNull(resultsInterpreter, "resultsInterpreter"));
            return this;
        }

        /**
         * Replaces all {@code specimen} values.
         *
         * @param specimen the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder specimen(List<Reference> specimen) {
            this.specimen = specimen == null ? new ArrayList<>() : new ArrayList<>(specimen);
            return this;
        }

        /**
         * Adds a {@code specimen} value.
         *
         * @param specimen the value to add
         * @return this builder
         */
        public Builder addSpecimen(Reference specimen) {
            this.specimen.add(Objects.requireNonNull(specimen, "specimen"));
            return this;
        }

        /**
         * Replaces all {@code result} values.
         *
         * @param result the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder result(List<Reference> result) {
            this.result = result == null ? new ArrayList<>() : new ArrayList<>(result);
            return this;
        }

        /**
         * Adds a {@code result} value.
         *
         * @param result the value to add
         * @return this builder
         */
        public Builder addResult(Reference result) {
            this.result.add(Objects.requireNonNull(result, "result"));
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
         * Replaces all {@code study} values.
         *
         * @param study the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder study(List<Reference> study) {
            this.study = study == null ? new ArrayList<>() : new ArrayList<>(study);
            return this;
        }

        /**
         * Adds a {@code study} value.
         *
         * @param study the value to add
         * @return this builder
         */
        public Builder addStudy(Reference study) {
            this.study.add(Objects.requireNonNull(study, "study"));
            return this;
        }

        /**
         * Replaces all {@code supportingInfo} values.
         *
         * @param supportingInfo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supportingInfo(List<SupportingInfo> supportingInfo) {
            this.supportingInfo = supportingInfo == null ? new ArrayList<>() : new ArrayList<>(supportingInfo);
            return this;
        }

        /**
         * Adds a {@code supportingInfo} value.
         *
         * @param supportingInfo the value to add
         * @return this builder
         */
        public Builder addSupportingInfo(SupportingInfo supportingInfo) {
            this.supportingInfo.add(Objects.requireNonNull(supportingInfo, "supportingInfo"));
            return this;
        }

        /**
         * Replaces all {@code media} values.
         *
         * @param media the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder media(List<Media> media) {
            this.media = media == null ? new ArrayList<>() : new ArrayList<>(media);
            return this;
        }

        /**
         * Adds a {@code media} value.
         *
         * @param media the value to add
         * @return this builder
         */
        public Builder addMedia(Media media) {
            this.media.add(Objects.requireNonNull(media, "media"));
            return this;
        }

        /**
         * Sets {@code composition}.
         *
         * @param composition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder composition(Reference composition) {
            this.composition = composition;
            return this;
        }

        /**
         * Sets {@code conclusion}.
         *
         * @param conclusion the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder conclusion(FhirMarkdown conclusion) {
            this.conclusion = conclusion;
            return this;
        }

        /**
         * Sets {@code conclusion}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param conclusion the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder conclusion(String conclusion) {
            return conclusion(conclusion == null ? null : FhirMarkdown.of(conclusion));
        }

        /**
         * Replaces all {@code conclusionCode} values.
         *
         * @param conclusionCode the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder conclusionCode(List<CodeableConcept> conclusionCode) {
            this.conclusionCode = conclusionCode == null ? new ArrayList<>() : new ArrayList<>(conclusionCode);
            return this;
        }

        /**
         * Adds a {@code conclusionCode} value.
         *
         * @param conclusionCode the value to add
         * @return this builder
         */
        public Builder addConclusionCode(CodeableConcept conclusionCode) {
            this.conclusionCode.add(Objects.requireNonNull(conclusionCode, "conclusionCode"));
            return this;
        }

        /**
         * Replaces all {@code presentedForm} values.
         *
         * @param presentedForm the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder presentedForm(List<Attachment> presentedForm) {
            this.presentedForm = presentedForm == null ? new ArrayList<>() : new ArrayList<>(presentedForm);
            return this;
        }

        /**
         * Adds a {@code presentedForm} value.
         *
         * @param presentedForm the value to add
         * @return this builder
         */
        public Builder addPresentedForm(Attachment presentedForm) {
            this.presentedForm.add(Objects.requireNonNull(presentedForm, "presentedForm"));
            return this;
        }

        /**
         * Builds the {@code DiagnosticReport}.
         *
         * @return the {@code DiagnosticReport}
         * @throws NullPointerException if a required element is absent
         */
        public DiagnosticReport build() {
            return new DiagnosticReport(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    basedOn, status, category, code, subject, encounter, effective, issued, performer,
                    resultsInterpreter, specimen, result, note, study, supportingInfo, media, composition, conclusion,
                    conclusionCode, presentedForm);
        }
    }
}
