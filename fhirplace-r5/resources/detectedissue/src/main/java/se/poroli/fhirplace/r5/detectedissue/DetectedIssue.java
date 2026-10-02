package se.poroli.fhirplace.r5.detectedissue;

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
import se.poroli.fhirplace.r5.datatypes.DataType;
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
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for
 * a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, gaps in care,
 * etc.
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
 * @param identifier Unique id for the detected issue.
 * @param status preliminary | final | entered-in-error | mitigated. Required. Modifier element.
 * @param category Type of detected issue, e.g. drug-drug, duplicate therapy, etc.
 * @param code Specific type of detected issue, e.g. drug-drug, duplicate therapy, etc.
 * @param severity high | moderate | low.
 * @param subject Associated subject. Reference to Patient, Group, Device, Location, Organization, Procedure,
 *   Practitioner, Medication, Substance, BiologicallyDerivedProduct, NutritionProduct.
 * @param encounter Encounter detected issue is part of. Reference to Encounter.
 * @param identified When identified. One of dateTime, Period.
 * @param author The provider or device that identified the issue. Reference to Patient, RelatedPerson, Practitioner,
 *   PractitionerRole, Device.
 * @param implicated Problem resource. Reference to Resource.
 * @param evidence Supporting evidence.
 * @param detail Description and context.
 * @param reference Authority for issue.
 * @param mitigation Step taken to address.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DetectedIssue">FHIR R5 DetectedIssue</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record DetectedIssue(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirCode status,
        List<CodeableConcept> category,
        CodeableConcept code,
        FhirEnum<DetectedIssueSeverity> severity,
        Reference subject,
        Reference encounter,
        DataType identified,
        Reference author,
        List<Reference> implicated,
        List<Evidence> evidence,
        FhirMarkdown detail,
        FhirUri reference,
        List<Mitigation> mitigation) implements DomainResource {

    /**
     * Creates a {@code DetectedIssue}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public DetectedIssue {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        category = category == null ? List.of() : List.copyOf(category);
        implicated = implicated == null ? List.of() : List.copyOf(implicated);
        evidence = evidence == null ? List.of() : List.copyOf(evidence);
        mitigation = mitigation == null ? List.of() : List.copyOf(mitigation);
        Objects.requireNonNull(status, "DetectedIssue.status is required");
        if (identified != null && !(identified instanceof FhirDateTime || identified instanceof Period)) {
            throw new IllegalArgumentException(
                    "DetectedIssue.identified[x] must be one of dateTime, Period, but was "
                            + identified.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code DetectedIssue}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Supporting evidence or manifestations that provide the basis for identifying the detected issue such as a
     * GuidanceResponse or MeasureReport.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Manifestation.
     * @param detail Supporting information. Reference to Resource.
     */
    public record Evidence(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableConcept> code,
            List<Reference> detail) implements BackboneElement {

        /**
         * Creates an {@code Evidence}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Evidence {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            code = code == null ? List.of() : List.copyOf(code);
            detail = detail == null ? List.of() : List.copyOf(detail);
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
         * Returns a builder initialized with the values of this {@code Evidence}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Evidence}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<CodeableConcept> code = new ArrayList<>();
            private List<Reference> detail = new ArrayList<>();

            private Builder() {
            }

            private Builder(Evidence original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = new ArrayList<>(original.code());
                this.detail = new ArrayList<>(original.detail());
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
             * Replaces all {@code code} values.
             *
             * @param code the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder code(List<CodeableConcept> code) {
                this.code = code == null ? new ArrayList<>() : new ArrayList<>(code);
                return this;
            }

            /**
             * Adds a {@code code} value.
             *
             * @param code the value to add
             * @return this builder
             */
            public Builder addCode(CodeableConcept code) {
                this.code.add(Objects.requireNonNull(code, "code"));
                return this;
            }

            /**
             * Replaces all {@code detail} values.
             *
             * @param detail the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder detail(List<Reference> detail) {
                this.detail = detail == null ? new ArrayList<>() : new ArrayList<>(detail);
                return this;
            }

            /**
             * Adds a {@code detail} value.
             *
             * @param detail the value to add
             * @return this builder
             */
            public Builder addDetail(Reference detail) {
                this.detail.add(Objects.requireNonNull(detail, "detail"));
                return this;
            }

            /**
             * Builds the {@code Evidence}.
             *
             * @return the {@code Evidence}
             */
            public Evidence build() {
                return new Evidence(
                        id, extension, modifierExtension, code, detail);
            }
        }
    }

    /**
     * Indicates an action that has been taken or is committed to reduce or eliminate the likelihood of the risk
     * identified by the detected issue from manifesting.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param action What mitigation?. Required.
     * @param date Date committed.
     * @param author Who is committing?. Reference to Practitioner, PractitionerRole.
     * @param note Additional notes about the mitigation.
     */
    public record Mitigation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept action,
            FhirDateTime date,
            Reference author,
            List<Annotation> note) implements BackboneElement {

        /**
         * Creates a {@code Mitigation}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Mitigation {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            note = note == null ? List.of() : List.copyOf(note);
            Objects.requireNonNull(action, "DetectedIssue.mitigation.action is required");
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
         * Returns a builder initialized with the values of this {@code Mitigation}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Mitigation}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept action;
            private FhirDateTime date;
            private Reference author;
            private List<Annotation> note = new ArrayList<>();

            private Builder() {
            }

            private Builder(Mitigation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.action = original.action();
                this.date = original.date();
                this.author = original.author();
                this.note = new ArrayList<>(original.note());
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
             * Sets {@code action}.
             *
             * @param action the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder action(CodeableConcept action) {
                this.action = action;
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
             * Builds the {@code Mitigation}.
             *
             * @return the {@code Mitigation}
             * @throws NullPointerException if a required element is absent
             */
            public Mitigation build() {
                return new Mitigation(
                        id, extension, modifierExtension, action, date, author, note);
            }
        }
    }

    /** Builder for {@link DetectedIssue}. Builders are mutable and not thread-safe. */
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
        private FhirCode status;
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableConcept code;
        private FhirEnum<DetectedIssueSeverity> severity;
        private Reference subject;
        private Reference encounter;
        private DataType identified;
        private Reference author;
        private List<Reference> implicated = new ArrayList<>();
        private List<Evidence> evidence = new ArrayList<>();
        private FhirMarkdown detail;
        private FhirUri reference;
        private List<Mitigation> mitigation = new ArrayList<>();

        private Builder() {
        }

        private Builder(DetectedIssue original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.status = original.status();
            this.category = new ArrayList<>(original.category());
            this.code = original.code();
            this.severity = original.severity();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.identified = original.identified();
            this.author = original.author();
            this.implicated = new ArrayList<>(original.implicated());
            this.evidence = new ArrayList<>(original.evidence());
            this.detail = original.detail();
            this.reference = original.reference();
            this.mitigation = new ArrayList<>(original.mitigation());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirCode status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(String status) {
            return status(status == null ? null : FhirCode.of(status));
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
         * Sets {@code severity}.
         *
         * @param severity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder severity(FhirEnum<DetectedIssueSeverity> severity) {
            this.severity = severity;
            return this;
        }

        /**
         * Sets {@code severity}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param severity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder severity(DetectedIssueSeverity severity) {
            return severity(severity == null ? null : FhirEnum.of(severity));
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
         * Sets {@code identified} to a dateTime.
         *
         * @param identified the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder identified(FhirDateTime identified) {
            this.identified = identified;
            return this;
        }

        /**
         * Sets {@code identified} to a Period.
         *
         * @param identified the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder identified(Period identified) {
            this.identified = identified;
            return this;
        }

        /**
         * Sets {@code identified} to a dateTime without id or extensions.
         *
         * @param identified the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder identified(Temporal identified) {
            this.identified = identified == null ? null : FhirDateTime.of(identified);
            return this;
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
         * Replaces all {@code implicated} values.
         *
         * @param implicated the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder implicated(List<Reference> implicated) {
            this.implicated = implicated == null ? new ArrayList<>() : new ArrayList<>(implicated);
            return this;
        }

        /**
         * Adds a {@code implicated} value.
         *
         * @param implicated the value to add
         * @return this builder
         */
        public Builder addImplicated(Reference implicated) {
            this.implicated.add(Objects.requireNonNull(implicated, "implicated"));
            return this;
        }

        /**
         * Replaces all {@code evidence} values.
         *
         * @param evidence the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder evidence(List<Evidence> evidence) {
            this.evidence = evidence == null ? new ArrayList<>() : new ArrayList<>(evidence);
            return this;
        }

        /**
         * Adds a {@code evidence} value.
         *
         * @param evidence the value to add
         * @return this builder
         */
        public Builder addEvidence(Evidence evidence) {
            this.evidence.add(Objects.requireNonNull(evidence, "evidence"));
            return this;
        }

        /**
         * Sets {@code detail}.
         *
         * @param detail the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder detail(FhirMarkdown detail) {
            this.detail = detail;
            return this;
        }

        /**
         * Sets {@code detail}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param detail the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder detail(String detail) {
            return detail(detail == null ? null : FhirMarkdown.of(detail));
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
         * Replaces all {@code mitigation} values.
         *
         * @param mitigation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder mitigation(List<Mitigation> mitigation) {
            this.mitigation = mitigation == null ? new ArrayList<>() : new ArrayList<>(mitigation);
            return this;
        }

        /**
         * Adds a {@code mitigation} value.
         *
         * @param mitigation the value to add
         * @return this builder
         */
        public Builder addMitigation(Mitigation mitigation) {
            this.mitigation.add(Objects.requireNonNull(mitigation, "mitigation"));
            return this;
        }

        /**
         * Builds the {@code DetectedIssue}.
         *
         * @return the {@code DetectedIssue}
         * @throws NullPointerException if a required element is absent
         */
        public DetectedIssue build() {
            return new DetectedIssue(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, category, code, severity, subject, encounter, identified, author, implicated, evidence,
                    detail, reference, mitigation);
        }
    }
}
