package se.poroli.fhirplace.r5.deviceusage;

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
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
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
 * A record of a device being used by a patient where the record is the result of a report from the patient or a
 * clinician.
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
 * @param identifier External identifier for this record.
 * @param basedOn Fulfills plan, proposal or order. Reference to ServiceRequest.
 * @param status active | completed | not-done | entered-in-error +. Required. Modifier element.
 * @param category The category of the statement - classifying how the statement is made.
 * @param patient Patient using device. Reference to Patient. Required.
 * @param derivedFrom Supporting information. Reference to ServiceRequest, Procedure, Claim, Observation,
 *   QuestionnaireResponse, DocumentReference.
 * @param context The encounter or episode of care that establishes the context for this device use statement.
 *   Reference to Encounter, EpisodeOfCare.
 * @param timing How often the device was used. One of Timing, Period, dateTime.
 * @param dateAsserted When the statement was made (and recorded).
 * @param usageStatus The status of the device usage, for example always, sometimes, never. This is not the same as
 *   the status of the statement.
 * @param usageReason The reason for asserting the usage status - for example forgot, lost, stolen, broken.
 * @param adherence How device is being used.
 * @param informationSource Who made the statement. Reference to Patient, Practitioner, PractitionerRole,
 *   RelatedPerson, Organization.
 * @param device Code or Reference to device used. Required.
 * @param reason Why device was used.
 * @param bodySite Target body site.
 * @param note Addition details (comments, instructions).
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DeviceUsage">FHIR R5 DeviceUsage</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record DeviceUsage(
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
        FhirEnum<DeviceUsageStatus> status,
        List<CodeableConcept> category,
        Reference patient,
        List<Reference> derivedFrom,
        Reference context,
        DataType timing,
        FhirDateTime dateAsserted,
        CodeableConcept usageStatus,
        List<CodeableConcept> usageReason,
        Adherence adherence,
        Reference informationSource,
        CodeableReference device,
        List<CodeableReference> reason,
        CodeableReference bodySite,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates a {@code DeviceUsage}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public DeviceUsage {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        category = category == null ? List.of() : List.copyOf(category);
        derivedFrom = derivedFrom == null ? List.of() : List.copyOf(derivedFrom);
        usageReason = usageReason == null ? List.of() : List.copyOf(usageReason);
        reason = reason == null ? List.of() : List.copyOf(reason);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "DeviceUsage.status is required");
        Objects.requireNonNull(patient, "DeviceUsage.patient is required");
        Objects.requireNonNull(device, "DeviceUsage.device is required");
        if (timing != null && !(timing instanceof Timing
                || timing instanceof Period
                || timing instanceof FhirDateTime)) {
            throw new IllegalArgumentException(
                    "DeviceUsage.timing[x] must be one of Timing, Period, dateTime, but was "
                            + timing.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code DeviceUsage}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * This indicates how or if the device is being used.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code always | never | sometimes. Required.
     * @param reason lost | stolen | prescribed | broken | burned | forgot. Required.
     */
    public record Adherence(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            List<CodeableConcept> reason) implements BackboneElement {

        /**
         * Creates an {@code Adherence}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Adherence {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            reason = reason == null ? List.of() : List.copyOf(reason);
            Objects.requireNonNull(code, "DeviceUsage.adherence.code is required");
            if (reason.isEmpty()) {
                throw new IllegalArgumentException("DeviceUsage.adherence.reason requires at least one value");
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
            private List<CodeableConcept> reason = new ArrayList<>();

            private Builder() {
            }

            private Builder(Adherence original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.reason = new ArrayList<>(original.reason());
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
             * Replaces all {@code reason} values.
             *
             * @param reason the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder reason(List<CodeableConcept> reason) {
                this.reason = reason == null ? new ArrayList<>() : new ArrayList<>(reason);
                return this;
            }

            /**
             * Adds a {@code reason} value.
             *
             * @param reason the value to add
             * @return this builder
             */
            public Builder addReason(CodeableConcept reason) {
                this.reason.add(Objects.requireNonNull(reason, "reason"));
                return this;
            }

            /**
             * Builds the {@code Adherence}.
             *
             * @return the {@code Adherence}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Adherence build() {
                return new Adherence(
                        id, extension, modifierExtension, code, reason);
            }
        }
    }

    /** Builder for {@link DeviceUsage}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<DeviceUsageStatus> status;
        private List<CodeableConcept> category = new ArrayList<>();
        private Reference patient;
        private List<Reference> derivedFrom = new ArrayList<>();
        private Reference context;
        private DataType timing;
        private FhirDateTime dateAsserted;
        private CodeableConcept usageStatus;
        private List<CodeableConcept> usageReason = new ArrayList<>();
        private Adherence adherence;
        private Reference informationSource;
        private CodeableReference device;
        private List<CodeableReference> reason = new ArrayList<>();
        private CodeableReference bodySite;
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(DeviceUsage original) {
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
            this.patient = original.patient();
            this.derivedFrom = new ArrayList<>(original.derivedFrom());
            this.context = original.context();
            this.timing = original.timing();
            this.dateAsserted = original.dateAsserted();
            this.usageStatus = original.usageStatus();
            this.usageReason = new ArrayList<>(original.usageReason());
            this.adherence = original.adherence();
            this.informationSource = original.informationSource();
            this.device = original.device();
            this.reason = new ArrayList<>(original.reason());
            this.bodySite = original.bodySite();
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
        public Builder status(FhirEnum<DeviceUsageStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(DeviceUsageStatus status) {
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
         * Sets {@code patient}.
         *
         * @param patient the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder patient(Reference patient) {
            this.patient = patient;
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
         * Sets {@code context}.
         *
         * @param context the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder context(Reference context) {
            this.context = context;
            return this;
        }

        /**
         * Sets {@code timing} to a Timing.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(Timing timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets {@code timing} to a Period.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(Period timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets {@code timing} to a dateTime.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(FhirDateTime timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets {@code timing} to a dateTime without id or extensions.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(Temporal timing) {
            this.timing = timing == null ? null : FhirDateTime.of(timing);
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
         * Sets {@code usageStatus}.
         *
         * @param usageStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder usageStatus(CodeableConcept usageStatus) {
            this.usageStatus = usageStatus;
            return this;
        }

        /**
         * Replaces all {@code usageReason} values.
         *
         * @param usageReason the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder usageReason(List<CodeableConcept> usageReason) {
            this.usageReason = usageReason == null ? new ArrayList<>() : new ArrayList<>(usageReason);
            return this;
        }

        /**
         * Adds a {@code usageReason} value.
         *
         * @param usageReason the value to add
         * @return this builder
         */
        public Builder addUsageReason(CodeableConcept usageReason) {
            this.usageReason.add(Objects.requireNonNull(usageReason, "usageReason"));
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
         * Sets {@code informationSource}.
         *
         * @param informationSource the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder informationSource(Reference informationSource) {
            this.informationSource = informationSource;
            return this;
        }

        /**
         * Sets {@code device}.
         *
         * @param device the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder device(CodeableReference device) {
            this.device = device;
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
         * Sets {@code bodySite}.
         *
         * @param bodySite the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder bodySite(CodeableReference bodySite) {
            this.bodySite = bodySite;
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
         * Builds the {@code DeviceUsage}.
         *
         * @return the {@code DeviceUsage}
         * @throws NullPointerException if a required element is absent
         */
        public DeviceUsage build() {
            return new DeviceUsage(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    basedOn, status, category, patient, derivedFrom, context, timing, dateAsserted, usageStatus,
                    usageReason, adherence, informationSource, device, reason, bodySite, note);
        }
    }
}
