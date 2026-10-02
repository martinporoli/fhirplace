package se.poroli.fhirplace.r5.foundation.security;

import java.time.OffsetDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.valuesets.ProvenanceEntityRole;

/**
 * Provenance of a resource is a record that describes entities and processes involved in producing and delivering or
 * otherwise influencing that resource.
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
 * @param target Target Reference(s) (usually version specific). Reference to Resource. Required.
 * @param occurred When the activity occurred. One of Period, dateTime.
 * @param recorded When the activity was recorded / updated.
 * @param policy Policy or plan the activity was defined by.
 * @param location Where the activity occurred, if relevant. Reference to Location.
 * @param authorization Authorization (purposeOfUse) related to the event.
 * @param activity Activity that occurred.
 * @param basedOn Workflow authorization within which this event occurred. Reference to CarePlan, DeviceRequest,
 *   ImmunizationRecommendation, MedicationRequest, NutritionOrder, ServiceRequest, Task.
 * @param patient The patient is the subject of the data created/updated (.target) by the activity. Reference to
 *   Patient.
 * @param encounter Encounter within which this event occurred or which the event is tightly associated. Reference to
 *   Encounter.
 * @param agent Actor involved. Required.
 * @param entity An entity used in this activity.
 * @param signature Signature on target.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Provenance">FHIR R5 Provenance</a>
 */
public record Provenance(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Reference> target,
        DataType occurred,
        FhirInstant recorded,
        List<FhirUri> policy,
        Reference location,
        List<CodeableReference> authorization,
        CodeableConcept activity,
        List<Reference> basedOn,
        Reference patient,
        Reference encounter,
        List<Agent> agent,
        List<Entity> entity,
        List<Signature> signature) implements DomainResource {

    /**
     * Creates a {@code Provenance}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Provenance {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        target = target == null ? List.of() : List.copyOf(target);
        policy = policy == null ? List.of() : List.copyOf(policy);
        authorization = authorization == null ? List.of() : List.copyOf(authorization);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        agent = agent == null ? List.of() : List.copyOf(agent);
        entity = entity == null ? List.of() : List.copyOf(entity);
        signature = signature == null ? List.of() : List.copyOf(signature);
        if (target.isEmpty()) {
            throw new IllegalArgumentException("Provenance.target requires at least one value");
        }
        if (agent.isEmpty()) {
            throw new IllegalArgumentException("Provenance.agent requires at least one value");
        }
        if (occurred != null && !(occurred instanceof Period || occurred instanceof FhirDateTime)) {
            throw new IllegalArgumentException(
                    "Provenance.occurred[x] must be one of Period, dateTime, but was "
                            + occurred.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Provenance}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * An actor taking a role in an activity for which it can be assigned some degree of responsibility for the
     * activity taking place.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type How the agent participated.
     * @param role What the agents role was.
     * @param who The agent that participated in the event. Reference to Practitioner, PractitionerRole, Organization,
     *   CareTeam, Patient, Device, RelatedPerson. Required.
     * @param onBehalfOf The agent that delegated. Reference to Practitioner, PractitionerRole, Organization,
     *   CareTeam, Patient.
     */
    public record Agent(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            List<CodeableConcept> role,
            Reference who,
            Reference onBehalfOf) implements BackboneElement {

        /**
         * Creates an {@code Agent}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Agent {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            role = role == null ? List.of() : List.copyOf(role);
            Objects.requireNonNull(who, "Provenance.agent.who is required");
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
         * Returns a builder initialized with the values of this {@code Agent}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Agent}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private List<CodeableConcept> role = new ArrayList<>();
            private Reference who;
            private Reference onBehalfOf;

            private Builder() {
            }

            private Builder(Agent original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.role = new ArrayList<>(original.role());
                this.who = original.who();
                this.onBehalfOf = original.onBehalfOf();
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
             * Replaces all {@code role} values.
             *
             * @param role the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder role(List<CodeableConcept> role) {
                this.role = role == null ? new ArrayList<>() : new ArrayList<>(role);
                return this;
            }

            /**
             * Adds a {@code role} value.
             *
             * @param role the value to add
             * @return this builder
             */
            public Builder addRole(CodeableConcept role) {
                this.role.add(Objects.requireNonNull(role, "role"));
                return this;
            }

            /**
             * Sets {@code who}.
             *
             * @param who the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder who(Reference who) {
                this.who = who;
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
             * Builds the {@code Agent}.
             *
             * @return the {@code Agent}
             * @throws NullPointerException if a required element is absent
             */
            public Agent build() {
                return new Agent(
                        id, extension, modifierExtension, type, role, who, onBehalfOf);
            }
        }
    }

    /**
     * An entity used in this activity.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param role revision | quotation | source | instantiates | removal. Required.
     * @param what Identity of entity. Reference to Resource. Required.
     * @param agent Entity is attributed to this agent.
     */
    public record Entity(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<ProvenanceEntityRole> role,
            Reference what,
            List<Provenance.Agent> agent) implements BackboneElement {

        /**
         * Creates an {@code Entity}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Entity {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            agent = agent == null ? List.of() : List.copyOf(agent);
            Objects.requireNonNull(role, "Provenance.entity.role is required");
            Objects.requireNonNull(what, "Provenance.entity.what is required");
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
         * Returns a builder initialized with the values of this {@code Entity}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Entity}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<ProvenanceEntityRole> role;
            private Reference what;
            private List<Provenance.Agent> agent = new ArrayList<>();

            private Builder() {
            }

            private Builder(Entity original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.role = original.role();
                this.what = original.what();
                this.agent = new ArrayList<>(original.agent());
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
             * Sets {@code role}.
             *
             * @param role the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder role(FhirEnum<ProvenanceEntityRole> role) {
                this.role = role;
                return this;
            }

            /**
             * Sets {@code role}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param role the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder role(ProvenanceEntityRole role) {
                return role(role == null ? null : FhirEnum.of(role));
            }

            /**
             * Sets {@code what}.
             *
             * @param what the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder what(Reference what) {
                this.what = what;
                return this;
            }

            /**
             * Replaces all {@code agent} values.
             *
             * @param agent the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder agent(List<Provenance.Agent> agent) {
                this.agent = agent == null ? new ArrayList<>() : new ArrayList<>(agent);
                return this;
            }

            /**
             * Adds a {@code agent} value.
             *
             * @param agent the value to add
             * @return this builder
             */
            public Builder addAgent(Provenance.Agent agent) {
                this.agent.add(Objects.requireNonNull(agent, "agent"));
                return this;
            }

            /**
             * Builds the {@code Entity}.
             *
             * @return the {@code Entity}
             * @throws NullPointerException if a required element is absent
             */
            public Entity build() {
                return new Entity(
                        id, extension, modifierExtension, role, what, agent);
            }
        }
    }

    /** Builder for {@link Provenance}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private List<Reference> target = new ArrayList<>();
        private DataType occurred;
        private FhirInstant recorded;
        private List<FhirUri> policy = new ArrayList<>();
        private Reference location;
        private List<CodeableReference> authorization = new ArrayList<>();
        private CodeableConcept activity;
        private List<Reference> basedOn = new ArrayList<>();
        private Reference patient;
        private Reference encounter;
        private List<Agent> agent = new ArrayList<>();
        private List<Entity> entity = new ArrayList<>();
        private List<Signature> signature = new ArrayList<>();

        private Builder() {
        }

        private Builder(Provenance original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.target = new ArrayList<>(original.target());
            this.occurred = original.occurred();
            this.recorded = original.recorded();
            this.policy = new ArrayList<>(original.policy());
            this.location = original.location();
            this.authorization = new ArrayList<>(original.authorization());
            this.activity = original.activity();
            this.basedOn = new ArrayList<>(original.basedOn());
            this.patient = original.patient();
            this.encounter = original.encounter();
            this.agent = new ArrayList<>(original.agent());
            this.entity = new ArrayList<>(original.entity());
            this.signature = new ArrayList<>(original.signature());
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
         * Replaces all {@code target} values.
         *
         * @param target the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder target(List<Reference> target) {
            this.target = target == null ? new ArrayList<>() : new ArrayList<>(target);
            return this;
        }

        /**
         * Adds a {@code target} value.
         *
         * @param target the value to add
         * @return this builder
         */
        public Builder addTarget(Reference target) {
            this.target.add(Objects.requireNonNull(target, "target"));
            return this;
        }

        /**
         * Sets {@code occurred} to a Period.
         *
         * @param occurred the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurred(Period occurred) {
            this.occurred = occurred;
            return this;
        }

        /**
         * Sets {@code occurred} to a dateTime.
         *
         * @param occurred the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurred(FhirDateTime occurred) {
            this.occurred = occurred;
            return this;
        }

        /**
         * Sets {@code occurred} to a dateTime without id or extensions.
         *
         * @param occurred the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurred(Temporal occurred) {
            this.occurred = occurred == null ? null : FhirDateTime.of(occurred);
            return this;
        }

        /**
         * Sets {@code recorded}.
         *
         * @param recorded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorded(FhirInstant recorded) {
            this.recorded = recorded;
            return this;
        }

        /**
         * Sets {@code recorded}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param recorded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorded(OffsetDateTime recorded) {
            return recorded(recorded == null ? null : FhirInstant.of(recorded));
        }

        /**
         * Replaces all {@code policy} values.
         *
         * @param policy the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder policy(List<FhirUri> policy) {
            this.policy = policy == null ? new ArrayList<>() : new ArrayList<>(policy);
            return this;
        }

        /**
         * Adds a {@code policy} value.
         *
         * @param policy the value to add
         * @return this builder
         */
        public Builder addPolicy(FhirUri policy) {
            this.policy.add(Objects.requireNonNull(policy, "policy"));
            return this;
        }

        /**
         * Adds a {@code policy} value, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param policy the value to add
         * @return this builder
         */
        public Builder addPolicy(String policy) {
            return addPolicy(FhirUri.of(policy));
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
         * Replaces all {@code authorization} values.
         *
         * @param authorization the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder authorization(List<CodeableReference> authorization) {
            this.authorization = authorization == null ? new ArrayList<>() : new ArrayList<>(authorization);
            return this;
        }

        /**
         * Adds a {@code authorization} value.
         *
         * @param authorization the value to add
         * @return this builder
         */
        public Builder addAuthorization(CodeableReference authorization) {
            this.authorization.add(Objects.requireNonNull(authorization, "authorization"));
            return this;
        }

        /**
         * Sets {@code activity}.
         *
         * @param activity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder activity(CodeableConcept activity) {
            this.activity = activity;
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
         * Replaces all {@code agent} values.
         *
         * @param agent the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder agent(List<Agent> agent) {
            this.agent = agent == null ? new ArrayList<>() : new ArrayList<>(agent);
            return this;
        }

        /**
         * Adds a {@code agent} value.
         *
         * @param agent the value to add
         * @return this builder
         */
        public Builder addAgent(Agent agent) {
            this.agent.add(Objects.requireNonNull(agent, "agent"));
            return this;
        }

        /**
         * Replaces all {@code entity} values.
         *
         * @param entity the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder entity(List<Entity> entity) {
            this.entity = entity == null ? new ArrayList<>() : new ArrayList<>(entity);
            return this;
        }

        /**
         * Adds a {@code entity} value.
         *
         * @param entity the value to add
         * @return this builder
         */
        public Builder addEntity(Entity entity) {
            this.entity.add(Objects.requireNonNull(entity, "entity"));
            return this;
        }

        /**
         * Replaces all {@code signature} values.
         *
         * @param signature the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder signature(List<Signature> signature) {
            this.signature = signature == null ? new ArrayList<>() : new ArrayList<>(signature);
            return this;
        }

        /**
         * Adds a {@code signature} value.
         *
         * @param signature the value to add
         * @return this builder
         */
        public Builder addSignature(Signature signature) {
            this.signature.add(Objects.requireNonNull(signature, "signature"));
            return this;
        }

        /**
         * Builds the {@code Provenance}.
         *
         * @return the {@code Provenance}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public Provenance build() {
            return new Provenance(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, target,
                    occurred, recorded, policy, location, authorization, activity, basedOn, patient, encounter, agent,
                    entity, signature);
        }
    }
}
