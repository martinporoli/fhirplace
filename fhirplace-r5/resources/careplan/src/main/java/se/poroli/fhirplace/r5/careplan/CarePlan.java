package se.poroli.fhirplace.r5.careplan;

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
import se.poroli.fhirplace.r5.datatypes.Extension;
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
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;

/**
 * Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or
 * community for a period of time, possibly limited to care for a specific condition or set of conditions.
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
 * @param identifier External Ids for this plan.
 * @param instantiatesCanonical Instantiates FHIR protocol or definition. Canonical reference to PlanDefinition,
 *   Questionnaire, Measure, ActivityDefinition, OperationDefinition.
 * @param instantiatesUri Instantiates external protocol or definition.
 * @param basedOn Fulfills plan, proposal or order. Reference to CarePlan, ServiceRequest, RequestOrchestration,
 *   NutritionOrder.
 * @param replaces CarePlan replaced by this CarePlan. Reference to CarePlan.
 * @param partOf Part of referenced CarePlan. Reference to CarePlan.
 * @param status draft | active | on-hold | revoked | completed | entered-in-error | unknown. Required. Modifier
 *   element.
 * @param intent proposal | plan | order | option | directive. Required. Modifier element.
 * @param category Type of plan.
 * @param title Human-friendly name for the care plan.
 * @param description Summary of nature of plan.
 * @param subject Who the care plan is for. Reference to Patient, Group. Required.
 * @param encounter The Encounter during which this CarePlan was created. Reference to Encounter.
 * @param period Time period plan covers.
 * @param created Date record was first recorded.
 * @param custodian Who is the designated responsible party. Reference to Patient, Practitioner, PractitionerRole,
 *   Device, RelatedPerson, Organization, CareTeam.
 * @param contributor Who provided the content of the care plan. Reference to Patient, Practitioner, PractitionerRole,
 *   Device, RelatedPerson, Organization, CareTeam.
 * @param careTeam Who's involved in plan?. Reference to CareTeam.
 * @param addresses Health issues this plan addresses.
 * @param supportingInfo Information considered as part of plan. Reference to Resource.
 * @param goal Desired outcome of plan. Reference to Goal.
 * @param activity Action to occur or has occurred as part of plan.
 * @param note Comments about the plan.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/CarePlan">FHIR R5 CarePlan</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record CarePlan(
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
        List<Reference> replaces,
        List<Reference> partOf,
        FhirEnum<RequestStatus> status,
        FhirEnum<CarePlanIntent> intent,
        List<CodeableConcept> category,
        FhirString title,
        FhirString description,
        Reference subject,
        Reference encounter,
        Period period,
        FhirDateTime created,
        Reference custodian,
        List<Reference> contributor,
        List<Reference> careTeam,
        List<CodeableReference> addresses,
        List<Reference> supportingInfo,
        List<Reference> goal,
        List<Activity> activity,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates a {@code CarePlan}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public CarePlan {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        instantiatesCanonical = instantiatesCanonical == null ? List.of() : List.copyOf(instantiatesCanonical);
        instantiatesUri = instantiatesUri == null ? List.of() : List.copyOf(instantiatesUri);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        replaces = replaces == null ? List.of() : List.copyOf(replaces);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        category = category == null ? List.of() : List.copyOf(category);
        contributor = contributor == null ? List.of() : List.copyOf(contributor);
        careTeam = careTeam == null ? List.of() : List.copyOf(careTeam);
        addresses = addresses == null ? List.of() : List.copyOf(addresses);
        supportingInfo = supportingInfo == null ? List.of() : List.copyOf(supportingInfo);
        goal = goal == null ? List.of() : List.copyOf(goal);
        activity = activity == null ? List.of() : List.copyOf(activity);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "CarePlan.status is required");
        Objects.requireNonNull(intent, "CarePlan.intent is required");
        Objects.requireNonNull(subject, "CarePlan.subject is required");
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
     * Returns a builder initialized with the values of this {@code CarePlan}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Identifies an action that has occurred or is a planned action to occur as part of the plan.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param performedActivity Results of the activity (concept, or Appointment, Encounter, Procedure, etc.).
     * @param progress Comments about the activity status/progress.
     * @param plannedActivityReference Activity that is intended to be part of the care plan. Reference to
     *   Appointment, CommunicationRequest, DeviceRequest, MedicationRequest, NutritionOrder, Task, ServiceRequest,
     *   VisionPrescription, RequestOrchestration, ImmunizationRecommendation, SupplyRequest.
     */
    public record Activity(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableReference> performedActivity,
            List<Annotation> progress,
            Reference plannedActivityReference) implements BackboneElement {

        /**
         * Creates an {@code Activity}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Activity {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            performedActivity = performedActivity == null ? List.of() : List.copyOf(performedActivity);
            progress = progress == null ? List.of() : List.copyOf(progress);
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
         * Returns a builder initialized with the values of this {@code Activity}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Activity}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<CodeableReference> performedActivity = new ArrayList<>();
            private List<Annotation> progress = new ArrayList<>();
            private Reference plannedActivityReference;

            private Builder() {
            }

            private Builder(Activity original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.performedActivity = new ArrayList<>(original.performedActivity());
                this.progress = new ArrayList<>(original.progress());
                this.plannedActivityReference = original.plannedActivityReference();
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
             * Replaces all {@code performedActivity} values.
             *
             * @param performedActivity the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder performedActivity(List<CodeableReference> performedActivity) {
                this.performedActivity = performedActivity == null
                        ? new ArrayList<>()
                        : new ArrayList<>(performedActivity);
                return this;
            }

            /**
             * Adds a {@code performedActivity} value.
             *
             * @param performedActivity the value to add
             * @return this builder
             */
            public Builder addPerformedActivity(CodeableReference performedActivity) {
                this.performedActivity.add(Objects.requireNonNull(performedActivity, "performedActivity"));
                return this;
            }

            /**
             * Replaces all {@code progress} values.
             *
             * @param progress the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder progress(List<Annotation> progress) {
                this.progress = progress == null ? new ArrayList<>() : new ArrayList<>(progress);
                return this;
            }

            /**
             * Adds a {@code progress} value.
             *
             * @param progress the value to add
             * @return this builder
             */
            public Builder addProgress(Annotation progress) {
                this.progress.add(Objects.requireNonNull(progress, "progress"));
                return this;
            }

            /**
             * Sets {@code plannedActivityReference}.
             *
             * @param plannedActivityReference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder plannedActivityReference(Reference plannedActivityReference) {
                this.plannedActivityReference = plannedActivityReference;
                return this;
            }

            /**
             * Builds the {@code Activity}.
             *
             * @return the {@code Activity}
             */
            public Activity build() {
                return new Activity(
                        id, extension, modifierExtension, performedActivity, progress, plannedActivityReference);
            }
        }
    }

    /** Builder for {@link CarePlan}. Builders are mutable and not thread-safe. */
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
        private List<Reference> replaces = new ArrayList<>();
        private List<Reference> partOf = new ArrayList<>();
        private FhirEnum<RequestStatus> status;
        private FhirEnum<CarePlanIntent> intent;
        private List<CodeableConcept> category = new ArrayList<>();
        private FhirString title;
        private FhirString description;
        private Reference subject;
        private Reference encounter;
        private Period period;
        private FhirDateTime created;
        private Reference custodian;
        private List<Reference> contributor = new ArrayList<>();
        private List<Reference> careTeam = new ArrayList<>();
        private List<CodeableReference> addresses = new ArrayList<>();
        private List<Reference> supportingInfo = new ArrayList<>();
        private List<Reference> goal = new ArrayList<>();
        private List<Activity> activity = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(CarePlan original) {
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
            this.replaces = new ArrayList<>(original.replaces());
            this.partOf = new ArrayList<>(original.partOf());
            this.status = original.status();
            this.intent = original.intent();
            this.category = new ArrayList<>(original.category());
            this.title = original.title();
            this.description = original.description();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.period = original.period();
            this.created = original.created();
            this.custodian = original.custodian();
            this.contributor = new ArrayList<>(original.contributor());
            this.careTeam = new ArrayList<>(original.careTeam());
            this.addresses = new ArrayList<>(original.addresses());
            this.supportingInfo = new ArrayList<>(original.supportingInfo());
            this.goal = new ArrayList<>(original.goal());
            this.activity = new ArrayList<>(original.activity());
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
         * Replaces all {@code replaces} values.
         *
         * @param replaces the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder replaces(List<Reference> replaces) {
            this.replaces = replaces == null ? new ArrayList<>() : new ArrayList<>(replaces);
            return this;
        }

        /**
         * Adds a {@code replaces} value.
         *
         * @param replaces the value to add
         * @return this builder
         */
        public Builder addReplaces(Reference replaces) {
            this.replaces.add(Objects.requireNonNull(replaces, "replaces"));
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
        public Builder status(FhirEnum<RequestStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(RequestStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code intent}.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(FhirEnum<CarePlanIntent> intent) {
            this.intent = intent;
            return this;
        }

        /**
         * Sets {@code intent}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(CarePlanIntent intent) {
            return intent(intent == null ? null : FhirEnum.of(intent));
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
         * Sets {@code description}.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(FhirString description) {
            this.description = description;
            return this;
        }

        /**
         * Sets {@code description}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(String description) {
            return description(description == null ? null : FhirString.of(description));
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
         * Sets {@code created}.
         *
         * @param created the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder created(FhirDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * Sets {@code created}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param created the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder created(Temporal created) {
            return created(created == null ? null : FhirDateTime.of(created));
        }

        /**
         * Sets {@code custodian}.
         *
         * @param custodian the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder custodian(Reference custodian) {
            this.custodian = custodian;
            return this;
        }

        /**
         * Replaces all {@code contributor} values.
         *
         * @param contributor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contributor(List<Reference> contributor) {
            this.contributor = contributor == null ? new ArrayList<>() : new ArrayList<>(contributor);
            return this;
        }

        /**
         * Adds a {@code contributor} value.
         *
         * @param contributor the value to add
         * @return this builder
         */
        public Builder addContributor(Reference contributor) {
            this.contributor.add(Objects.requireNonNull(contributor, "contributor"));
            return this;
        }

        /**
         * Replaces all {@code careTeam} values.
         *
         * @param careTeam the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder careTeam(List<Reference> careTeam) {
            this.careTeam = careTeam == null ? new ArrayList<>() : new ArrayList<>(careTeam);
            return this;
        }

        /**
         * Adds a {@code careTeam} value.
         *
         * @param careTeam the value to add
         * @return this builder
         */
        public Builder addCareTeam(Reference careTeam) {
            this.careTeam.add(Objects.requireNonNull(careTeam, "careTeam"));
            return this;
        }

        /**
         * Replaces all {@code addresses} values.
         *
         * @param addresses the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder addresses(List<CodeableReference> addresses) {
            this.addresses = addresses == null ? new ArrayList<>() : new ArrayList<>(addresses);
            return this;
        }

        /**
         * Adds a {@code addresses} value.
         *
         * @param addresses the value to add
         * @return this builder
         */
        public Builder addAddresses(CodeableReference addresses) {
            this.addresses.add(Objects.requireNonNull(addresses, "addresses"));
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
         * Replaces all {@code goal} values.
         *
         * @param goal the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder goal(List<Reference> goal) {
            this.goal = goal == null ? new ArrayList<>() : new ArrayList<>(goal);
            return this;
        }

        /**
         * Adds a {@code goal} value.
         *
         * @param goal the value to add
         * @return this builder
         */
        public Builder addGoal(Reference goal) {
            this.goal.add(Objects.requireNonNull(goal, "goal"));
            return this;
        }

        /**
         * Replaces all {@code activity} values.
         *
         * @param activity the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder activity(List<Activity> activity) {
            this.activity = activity == null ? new ArrayList<>() : new ArrayList<>(activity);
            return this;
        }

        /**
         * Adds a {@code activity} value.
         *
         * @param activity the value to add
         * @return this builder
         */
        public Builder addActivity(Activity activity) {
            this.activity.add(Objects.requireNonNull(activity, "activity"));
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
         * Builds the {@code CarePlan}.
         *
         * @return the {@code CarePlan}
         * @throws NullPointerException if a required element is absent
         */
        public CarePlan build() {
            return new CarePlan(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiatesCanonical, instantiatesUri, basedOn, replaces, partOf, status, intent, category,
                    title, description, subject, encounter, period, created, custodian, contributor, careTeam,
                    addresses, supportingInfo, goal, activity, note);
        }
    }
}
