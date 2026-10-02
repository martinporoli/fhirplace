package se.poroli.fhirplace.r5.procedure;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.EventStatus;

/**
 * An action that is or was performed on or for a patient, practitioner, device, organization, or location.
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
 * @param identifier External Identifiers for this procedure.
 * @param instantiatesCanonical Instantiates FHIR protocol or definition. Canonical reference to PlanDefinition,
 *   ActivityDefinition, Measure, OperationDefinition, Questionnaire.
 * @param instantiatesUri Instantiates external protocol or definition.
 * @param basedOn A request for this procedure. Reference to CarePlan, ServiceRequest.
 * @param partOf Part of referenced event. Reference to Procedure, Observation, MedicationAdministration.
 * @param status preparation | in-progress | not-done | on-hold | stopped | completed | entered-in-error | unknown.
 *   Required. Modifier element.
 * @param statusReason Reason for current status.
 * @param category Classification of the procedure.
 * @param code Identification of the procedure.
 * @param subject Individual or entity the procedure was performed on. Reference to Patient, Group, Device,
 *   Practitioner, Organization, Location. Required.
 * @param focus Who is the target of the procedure when it is not the subject of record only. Reference to Patient,
 *   Group, RelatedPerson, Practitioner, Organization, CareTeam, PractitionerRole, Specimen.
 * @param encounter The Encounter during which this Procedure was created. Reference to Encounter.
 * @param occurrence When the procedure occurred or is occurring. One of dateTime, Period, string, Age, Range, Timing.
 * @param recorded When the procedure was first captured in the subject's record.
 * @param recorder Who recorded the procedure. Reference to Patient, RelatedPerson, Practitioner, PractitionerRole.
 * @param reported Reported rather than primary record. One of boolean, Reference.
 * @param performer Who performed the procedure and what they did.
 * @param location Where the procedure happened. Reference to Location.
 * @param reason The justification that the procedure was performed.
 * @param bodySite Target body sites.
 * @param outcome The result of procedure.
 * @param report Any report resulting from the procedure. Reference to DiagnosticReport, DocumentReference,
 *   Composition.
 * @param complication Complication following the procedure.
 * @param followUp Instructions for follow up.
 * @param note Additional information about the procedure.
 * @param focalDevice Manipulated, implanted, or removed device.
 * @param used Items used during procedure.
 * @param supportingInfo Extra information relevant to the procedure. Reference to Resource.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Procedure">FHIR R5 Procedure</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Procedure(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        List<FhirCanonical> instantiatesCanonical,
        List<FhirUri> instantiatesUri,
        List<Reference> basedOn,
        List<Reference> partOf,
        FhirEnum<EventStatus> status,
        CodeableConcept statusReason,
        List<CodeableConcept> category,
        CodeableConcept code,
        Reference subject,
        Reference focus,
        Reference encounter,
        DataType occurrence,
        FhirDateTime recorded,
        Reference recorder,
        DataType reported,
        List<Performer> performer,
        Reference location,
        List<CodeableReference> reason,
        List<CodeableConcept> bodySite,
        CodeableConcept outcome,
        List<Reference> report,
        List<CodeableReference> complication,
        List<CodeableConcept> followUp,
        List<Annotation> note,
        List<FocalDevice> focalDevice,
        List<CodeableReference> used,
        List<Reference> supportingInfo) implements DomainResource {

    /**
     * Creates a {@code Procedure}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Procedure {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        instantiatesCanonical = instantiatesCanonical == null ? List.of() : List.copyOf(instantiatesCanonical);
        instantiatesUri = instantiatesUri == null ? List.of() : List.copyOf(instantiatesUri);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        category = category == null ? List.of() : List.copyOf(category);
        performer = performer == null ? List.of() : List.copyOf(performer);
        reason = reason == null ? List.of() : List.copyOf(reason);
        bodySite = bodySite == null ? List.of() : List.copyOf(bodySite);
        report = report == null ? List.of() : List.copyOf(report);
        complication = complication == null ? List.of() : List.copyOf(complication);
        followUp = followUp == null ? List.of() : List.copyOf(followUp);
        note = note == null ? List.of() : List.copyOf(note);
        focalDevice = focalDevice == null ? List.of() : List.copyOf(focalDevice);
        used = used == null ? List.of() : List.copyOf(used);
        supportingInfo = supportingInfo == null ? List.of() : List.copyOf(supportingInfo);
        Objects.requireNonNull(status, "Procedure.status is required");
        Objects.requireNonNull(subject, "Procedure.subject is required");
        if (occurrence != null && !(occurrence instanceof FhirDateTime
                || occurrence instanceof Period
                || occurrence instanceof FhirString
                || occurrence instanceof Age
                || occurrence instanceof Range
                || occurrence instanceof Timing)) {
            throw new IllegalArgumentException(
                    "Procedure.occurrence[x] must be one of dateTime, Period, string, Age, Range, Timing, but was "
                            + occurrence.getClass().getSimpleName());
        }
        if (reported != null && !(reported instanceof FhirBoolean || reported instanceof Reference)) {
            throw new IllegalArgumentException(
                    "Procedure.reported[x] must be one of boolean, Reference, but was "
                            + reported.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Procedure}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates who or what performed the procedure and how they were involved.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function Type of performance.
     * @param actor Who performed the procedure. Reference to Practitioner, PractitionerRole, Organization, Patient,
     *   RelatedPerson, Device, CareTeam, HealthcareService. Required.
     * @param onBehalfOf Organization the device or practitioner was acting for. Reference to Organization.
     * @param period When the performer performed the procedure.
     */
    public record Performer(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept function,
            Reference actor,
            Reference onBehalfOf,
            Period period) implements BackboneElement {

        /**
         * Creates a {@code Performer}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Performer {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(actor, "Procedure.performer.actor is required");
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
         * Returns a builder initialized with the values of this {@code Performer}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Performer}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept function;
            private Reference actor;
            private Reference onBehalfOf;
            private Period period;

            private Builder() {
            }

            private Builder(Performer original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.function = original.function();
                this.actor = original.actor();
                this.onBehalfOf = original.onBehalfOf();
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
             * Sets {@code function}.
             *
             * @param function the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder function(CodeableConcept function) {
                this.function = function;
                return this;
            }

            /**
             * Sets {@code actor}.
             *
             * @param actor the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder actor(Reference actor) {
                this.actor = actor;
                return this;
            }

            /**
             * Sets {@code onBehalfOf}.
             *
             * @param onBehalfOf the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder onBehalfOf(Reference onBehalfOf) {
                this.onBehalfOf = onBehalfOf;
                return this;
            }

            /**
             * Sets {@code period}.
             *
             * @param period the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder period(Period period) {
                this.period = period;
                return this;
            }

            /**
             * Builds the {@code Performer}.
             *
             * @return the {@code Performer}
             * @throws NullPointerException if a required element is absent
             */
            public Performer build() {
                return new Performer(
                        id, extension, modifierExtension, function, actor, onBehalfOf, period);
            }
        }
    }

    /**
     * A device that is implanted, removed or otherwise manipulated (calibration, battery replacement, fitting a
     * prosthesis, attaching a wound-vac, etc.) as a focal portion of the Procedure.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param action Kind of change to device.
     * @param manipulated Device that was changed. Reference to Device. Required.
     */
    public record FocalDevice(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept action,
            Reference manipulated) implements BackboneElement {

        /**
         * Creates a {@code FocalDevice}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public FocalDevice {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(manipulated, "Procedure.focalDevice.manipulated is required");
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
         * Returns a builder initialized with the values of this {@code FocalDevice}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link FocalDevice}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept action;
            private Reference manipulated;

            private Builder() {
            }

            private Builder(FocalDevice original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.action = original.action();
                this.manipulated = original.manipulated();
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
             * Sets {@code manipulated}.
             *
             * @param manipulated the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder manipulated(Reference manipulated) {
                this.manipulated = manipulated;
                return this;
            }

            /**
             * Builds the {@code FocalDevice}.
             *
             * @return the {@code FocalDevice}
             * @throws NullPointerException if a required element is absent
             */
            public FocalDevice build() {
                return new FocalDevice(
                        id, extension, modifierExtension, action, manipulated);
            }
        }
    }

    /** Builder for {@link Procedure}. Builders are mutable and not thread-safe. */
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
        private List<FhirCanonical> instantiatesCanonical = new ArrayList<>();
        private List<FhirUri> instantiatesUri = new ArrayList<>();
        private List<Reference> basedOn = new ArrayList<>();
        private List<Reference> partOf = new ArrayList<>();
        private FhirEnum<EventStatus> status;
        private CodeableConcept statusReason;
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableConcept code;
        private Reference subject;
        private Reference focus;
        private Reference encounter;
        private DataType occurrence;
        private FhirDateTime recorded;
        private Reference recorder;
        private DataType reported;
        private List<Performer> performer = new ArrayList<>();
        private Reference location;
        private List<CodeableReference> reason = new ArrayList<>();
        private List<CodeableConcept> bodySite = new ArrayList<>();
        private CodeableConcept outcome;
        private List<Reference> report = new ArrayList<>();
        private List<CodeableReference> complication = new ArrayList<>();
        private List<CodeableConcept> followUp = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<FocalDevice> focalDevice = new ArrayList<>();
        private List<CodeableReference> used = new ArrayList<>();
        private List<Reference> supportingInfo = new ArrayList<>();

        private Builder() {
        }

        private Builder(Procedure original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.instantiatesCanonical = new ArrayList<>(original.instantiatesCanonical());
            this.instantiatesUri = new ArrayList<>(original.instantiatesUri());
            this.basedOn = new ArrayList<>(original.basedOn());
            this.partOf = new ArrayList<>(original.partOf());
            this.status = original.status();
            this.statusReason = original.statusReason();
            this.category = new ArrayList<>(original.category());
            this.code = original.code();
            this.subject = original.subject();
            this.focus = original.focus();
            this.encounter = original.encounter();
            this.occurrence = original.occurrence();
            this.recorded = original.recorded();
            this.recorder = original.recorder();
            this.reported = original.reported();
            this.performer = new ArrayList<>(original.performer());
            this.location = original.location();
            this.reason = new ArrayList<>(original.reason());
            this.bodySite = new ArrayList<>(original.bodySite());
            this.outcome = original.outcome();
            this.report = new ArrayList<>(original.report());
            this.complication = new ArrayList<>(original.complication());
            this.followUp = new ArrayList<>(original.followUp());
            this.note = new ArrayList<>(original.note());
            this.focalDevice = new ArrayList<>(original.focalDevice());
            this.used = new ArrayList<>(original.used());
            this.supportingInfo = new ArrayList<>(original.supportingInfo());
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
         * Replaces all {@code instantiatesCanonical} values.
         *
         * @param instantiatesCanonical the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder instantiatesCanonical(List<FhirCanonical> instantiatesCanonical) {
            this.instantiatesCanonical = instantiatesCanonical == null
                    ? new ArrayList<>()
                    : new ArrayList<>(instantiatesCanonical);
            return this;
        }

        /**
         * Adds a {@code instantiatesCanonical} value.
         *
         * @param instantiatesCanonical the value to add
         * @return this builder
         */
        public Builder addInstantiatesCanonical(FhirCanonical instantiatesCanonical) {
            this.instantiatesCanonical.add(Objects.requireNonNull(instantiatesCanonical, "instantiatesCanonical"));
            return this;
        }

        /**
         * Adds a {@code instantiatesCanonical} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param instantiatesCanonical the value to add
         * @return this builder
         */
        public Builder addInstantiatesCanonical(String instantiatesCanonical) {
            return addInstantiatesCanonical(FhirCanonical.of(instantiatesCanonical));
        }

        /**
         * Replaces all {@code instantiatesUri} values.
         *
         * @param instantiatesUri the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder instantiatesUri(List<FhirUri> instantiatesUri) {
            this.instantiatesUri = instantiatesUri == null ? new ArrayList<>() : new ArrayList<>(instantiatesUri);
            return this;
        }

        /**
         * Adds a {@code instantiatesUri} value.
         *
         * @param instantiatesUri the value to add
         * @return this builder
         */
        public Builder addInstantiatesUri(FhirUri instantiatesUri) {
            this.instantiatesUri.add(Objects.requireNonNull(instantiatesUri, "instantiatesUri"));
            return this;
        }

        /**
         * Adds a {@code instantiatesUri} value, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param instantiatesUri the value to add
         * @return this builder
         */
        public Builder addInstantiatesUri(String instantiatesUri) {
            return addInstantiatesUri(FhirUri.of(instantiatesUri));
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
        public Builder status(FhirEnum<EventStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(EventStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code statusReason}.
         *
         * @param statusReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusReason(CodeableConcept statusReason) {
            this.statusReason = statusReason;
            return this;
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
         * Sets {@code focus}.
         *
         * @param focus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder focus(Reference focus) {
            this.focus = focus;
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
         * Sets {@code occurrence} to a dateTime.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(FhirDateTime occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a Period.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Period occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a string.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(FhirString occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a Age.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Age occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a Range.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Range occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a Timing.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Timing occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a dateTime without id or extensions.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Temporal occurrence) {
            this.occurrence = occurrence == null ? null : FhirDateTime.of(occurrence);
            return this;
        }

        /**
         * Sets {@code occurrence} to a string without id or extensions.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(String occurrence) {
            this.occurrence = occurrence == null ? null : FhirString.of(occurrence);
            return this;
        }

        /**
         * Sets {@code recorded}.
         *
         * @param recorded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorded(FhirDateTime recorded) {
            this.recorded = recorded;
            return this;
        }

        /**
         * Sets {@code recorded}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param recorded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorded(Temporal recorded) {
            return recorded(recorded == null ? null : FhirDateTime.of(recorded));
        }

        /**
         * Sets {@code recorder}.
         *
         * @param recorder the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorder(Reference recorder) {
            this.recorder = recorder;
            return this;
        }

        /**
         * Sets {@code reported} to a boolean.
         *
         * @param reported the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reported(FhirBoolean reported) {
            this.reported = reported;
            return this;
        }

        /**
         * Sets {@code reported} to a Reference.
         *
         * @param reported the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reported(Reference reported) {
            this.reported = reported;
            return this;
        }

        /**
         * Sets {@code reported} to a boolean without id or extensions.
         *
         * @param reported the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reported(Boolean reported) {
            this.reported = reported == null ? null : FhirBoolean.of(reported);
            return this;
        }

        /**
         * Replaces all {@code performer} values.
         *
         * @param performer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder performer(List<Performer> performer) {
            this.performer = performer == null ? new ArrayList<>() : new ArrayList<>(performer);
            return this;
        }

        /**
         * Adds a {@code performer} value.
         *
         * @param performer the value to add
         * @return this builder
         */
        public Builder addPerformer(Performer performer) {
            this.performer.add(Objects.requireNonNull(performer, "performer"));
            return this;
        }

        /**
         * Sets {@code location}.
         *
         * @param location the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder location(Reference location) {
            this.location = location;
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
         * Replaces all {@code bodySite} values.
         *
         * @param bodySite the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder bodySite(List<CodeableConcept> bodySite) {
            this.bodySite = bodySite == null ? new ArrayList<>() : new ArrayList<>(bodySite);
            return this;
        }

        /**
         * Adds a {@code bodySite} value.
         *
         * @param bodySite the value to add
         * @return this builder
         */
        public Builder addBodySite(CodeableConcept bodySite) {
            this.bodySite.add(Objects.requireNonNull(bodySite, "bodySite"));
            return this;
        }

        /**
         * Sets {@code outcome}.
         *
         * @param outcome the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outcome(CodeableConcept outcome) {
            this.outcome = outcome;
            return this;
        }

        /**
         * Replaces all {@code report} values.
         *
         * @param report the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder report(List<Reference> report) {
            this.report = report == null ? new ArrayList<>() : new ArrayList<>(report);
            return this;
        }

        /**
         * Adds a {@code report} value.
         *
         * @param report the value to add
         * @return this builder
         */
        public Builder addReport(Reference report) {
            this.report.add(Objects.requireNonNull(report, "report"));
            return this;
        }

        /**
         * Replaces all {@code complication} values.
         *
         * @param complication the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder complication(List<CodeableReference> complication) {
            this.complication = complication == null ? new ArrayList<>() : new ArrayList<>(complication);
            return this;
        }

        /**
         * Adds a {@code complication} value.
         *
         * @param complication the value to add
         * @return this builder
         */
        public Builder addComplication(CodeableReference complication) {
            this.complication.add(Objects.requireNonNull(complication, "complication"));
            return this;
        }

        /**
         * Replaces all {@code followUp} values.
         *
         * @param followUp the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder followUp(List<CodeableConcept> followUp) {
            this.followUp = followUp == null ? new ArrayList<>() : new ArrayList<>(followUp);
            return this;
        }

        /**
         * Adds a {@code followUp} value.
         *
         * @param followUp the value to add
         * @return this builder
         */
        public Builder addFollowUp(CodeableConcept followUp) {
            this.followUp.add(Objects.requireNonNull(followUp, "followUp"));
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
         * Replaces all {@code focalDevice} values.
         *
         * @param focalDevice the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder focalDevice(List<FocalDevice> focalDevice) {
            this.focalDevice = focalDevice == null ? new ArrayList<>() : new ArrayList<>(focalDevice);
            return this;
        }

        /**
         * Adds a {@code focalDevice} value.
         *
         * @param focalDevice the value to add
         * @return this builder
         */
        public Builder addFocalDevice(FocalDevice focalDevice) {
            this.focalDevice.add(Objects.requireNonNull(focalDevice, "focalDevice"));
            return this;
        }

        /**
         * Replaces all {@code used} values.
         *
         * @param used the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder used(List<CodeableReference> used) {
            this.used = used == null ? new ArrayList<>() : new ArrayList<>(used);
            return this;
        }

        /**
         * Adds a {@code used} value.
         *
         * @param used the value to add
         * @return this builder
         */
        public Builder addUsed(CodeableReference used) {
            this.used.add(Objects.requireNonNull(used, "used"));
            return this;
        }

        /**
         * Replaces all {@code supportingInfo} values.
         *
         * @param supportingInfo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supportingInfo(List<Reference> supportingInfo) {
            this.supportingInfo = supportingInfo == null ? new ArrayList<>() : new ArrayList<>(supportingInfo);
            return this;
        }

        /**
         * Adds a {@code supportingInfo} value.
         *
         * @param supportingInfo the value to add
         * @return this builder
         */
        public Builder addSupportingInfo(Reference supportingInfo) {
            this.supportingInfo.add(Objects.requireNonNull(supportingInfo, "supportingInfo"));
            return this;
        }

        /**
         * Builds the {@code Procedure}.
         *
         * @return the {@code Procedure}
         * @throws NullPointerException if a required element is absent
         */
        public Procedure build() {
            return new Procedure(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiatesCanonical, instantiatesUri, basedOn, partOf, status, statusReason, category, code,
                    subject, focus, encounter, occurrence, recorded, recorder, reported, performer, location, reason,
                    bodySite, outcome, report, complication, followUp, note, focalDevice, used, supportingInfo);
        }
    }
}
