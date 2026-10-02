package se.poroli.fhirplace.r5.auditevent;

import java.time.OffsetDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.Availability;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Contributor;
import se.poroli.fhirplace.r5.datatypes.Count;
import se.poroli.fhirplace.r5.datatypes.DataRequirement;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Distance;
import se.poroli.fhirplace.r5.datatypes.Dosage;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.ElementDefinition;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirInteger64;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirOid;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirUuid;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.ParameterDefinition;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.RatioRange;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.SampledData;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.datatypes.TriggerDefinition;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;

/**
 * A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance
 * analysis.
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
 * @param category Type/identifier of event.
 * @param code Specific type of event. Required.
 * @param action Type of action performed during the event.
 * @param severity emergency | alert | critical | error | warning | notice | informational | debug.
 * @param occurred When the activity occurred. One of Period, dateTime.
 * @param recorded Time when the event was recorded. Required.
 * @param outcome Whether the event succeeded or failed.
 * @param authorization Authorization related to the event.
 * @param basedOn Workflow authorization within which this event occurred. Reference to CarePlan, DeviceRequest,
 *   ImmunizationRecommendation, MedicationRequest, NutritionOrder, ServiceRequest, Task.
 * @param patient The patient is the subject of the data used/created/updated/deleted during the activity. Reference
 *   to Patient.
 * @param encounter Encounter within which this event occurred or which the event is tightly associated. Reference to
 *   Encounter.
 * @param agent Actor involved in the event. Required.
 * @param source Audit Event Reporter. Required.
 * @param entity Data or objects used.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/AuditEvent">FHIR R5 AuditEvent</a>
 */
public record AuditEvent(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<CodeableConcept> category,
        CodeableConcept code,
        FhirEnum<AuditEventAction> action,
        FhirEnum<AuditEventSeverity> severity,
        DataType occurred,
        FhirInstant recorded,
        Outcome outcome,
        List<CodeableConcept> authorization,
        List<Reference> basedOn,
        Reference patient,
        Reference encounter,
        List<Agent> agent,
        Source source,
        List<Entity> entity) implements DomainResource {

    /**
     * Creates an {@code AuditEvent}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public AuditEvent {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        category = category == null ? List.of() : List.copyOf(category);
        authorization = authorization == null ? List.of() : List.copyOf(authorization);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        agent = agent == null ? List.of() : List.copyOf(agent);
        entity = entity == null ? List.of() : List.copyOf(entity);
        Objects.requireNonNull(code, "AuditEvent.code is required");
        Objects.requireNonNull(recorded, "AuditEvent.recorded is required");
        if (agent.isEmpty()) {
            throw new IllegalArgumentException("AuditEvent.agent requires at least one value");
        }
        Objects.requireNonNull(source, "AuditEvent.source is required");
        if (occurred != null && !(occurred instanceof Period || occurred instanceof FhirDateTime)) {
            throw new IllegalArgumentException(
                    "AuditEvent.occurred[x] must be one of Period, dateTime, but was "
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
     * Returns a builder initialized with the values of this {@code AuditEvent}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates whether the event succeeded or failed.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Whether the event succeeded or failed. Required.
     * @param detail Additional outcome detail.
     */
    public record Outcome(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Coding code,
            List<CodeableConcept> detail) implements BackboneElement {

        /**
         * Creates an {@code Outcome}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Outcome {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            detail = detail == null ? List.of() : List.copyOf(detail);
            Objects.requireNonNull(code, "AuditEvent.outcome.code is required");
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
         * Returns a builder initialized with the values of this {@code Outcome}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Outcome}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Coding code;
            private List<CodeableConcept> detail = new ArrayList<>();

            private Builder() {
            }

            private Builder(Outcome original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
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
             * Sets {@code code}.
             *
             * @param code the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder code(Coding code) {
                this.code = code;
                return this;
            }

            /**
             * Replaces all {@code detail} values.
             *
             * @param detail the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder detail(List<CodeableConcept> detail) {
                this.detail = detail == null ? new ArrayList<>() : new ArrayList<>(detail);
                return this;
            }

            /**
             * Adds a {@code detail} value.
             *
             * @param detail the value to add
             * @return this builder
             */
            public Builder addDetail(CodeableConcept detail) {
                this.detail.add(Objects.requireNonNull(detail, "detail"));
                return this;
            }

            /**
             * Builds the {@code Outcome}.
             *
             * @return the {@code Outcome}
             * @throws NullPointerException if a required element is absent
             */
            public Outcome build() {
                return new Outcome(
                        id, extension, modifierExtension, code, detail);
            }
        }
    }

    /**
     * An actor taking an active role in the event or activity that is logged.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type How agent participated.
     * @param role Agent role in the event.
     * @param who Identifier of who. Reference to Practitioner, PractitionerRole, Organization, CareTeam, Patient,
     *   Device, RelatedPerson. Required.
     * @param requestor Whether user is initiator.
     * @param location The agent location when the event occurred. Reference to Location.
     * @param policy Policy that authorized the agent participation in the event.
     * @param network This agent network location for the activity. One of Reference, uri, string.
     * @param authorization Allowable authorization for this agent.
     */
    public record Agent(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            List<CodeableConcept> role,
            Reference who,
            FhirBoolean requestor,
            Reference location,
            List<FhirUri> policy,
            DataType network,
            List<CodeableConcept> authorization) implements BackboneElement {

        /**
         * Creates an {@code Agent}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Agent {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            role = role == null ? List.of() : List.copyOf(role);
            policy = policy == null ? List.of() : List.copyOf(policy);
            authorization = authorization == null ? List.of() : List.copyOf(authorization);
            Objects.requireNonNull(who, "AuditEvent.agent.who is required");
            if (network != null && !(network instanceof Reference
                    || network instanceof FhirUri
                    || network instanceof FhirString)) {
                throw new IllegalArgumentException(
                        "AuditEvent.agent.network[x] must be one of Reference, uri, string, but was "
                                + network.getClass().getSimpleName());
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
            private FhirBoolean requestor;
            private Reference location;
            private List<FhirUri> policy = new ArrayList<>();
            private DataType network;
            private List<CodeableConcept> authorization = new ArrayList<>();

            private Builder() {
            }

            private Builder(Agent original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.role = new ArrayList<>(original.role());
                this.who = original.who();
                this.requestor = original.requestor();
                this.location = original.location();
                this.policy = new ArrayList<>(original.policy());
                this.network = original.network();
                this.authorization = new ArrayList<>(original.authorization());
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
             * Sets {@code requestor}.
             *
             * @param requestor the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder requestor(FhirBoolean requestor) {
                this.requestor = requestor;
                return this;
            }

            /**
             * Sets {@code requestor}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param requestor the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder requestor(Boolean requestor) {
                return requestor(requestor == null ? null : FhirBoolean.of(requestor));
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
             * Sets {@code network} to a Reference.
             *
             * @param network the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder network(Reference network) {
                this.network = network;
                return this;
            }

            /**
             * Sets {@code network} to a uri.
             *
             * @param network the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder network(FhirUri network) {
                this.network = network;
                return this;
            }

            /**
             * Sets {@code network} to a string.
             *
             * @param network the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder network(FhirString network) {
                this.network = network;
                return this;
            }

            /**
             * Replaces all {@code authorization} values.
             *
             * @param authorization the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder authorization(List<CodeableConcept> authorization) {
                this.authorization = authorization == null ? new ArrayList<>() : new ArrayList<>(authorization);
                return this;
            }

            /**
             * Adds a {@code authorization} value.
             *
             * @param authorization the value to add
             * @return this builder
             */
            public Builder addAuthorization(CodeableConcept authorization) {
                this.authorization.add(Objects.requireNonNull(authorization, "authorization"));
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
                        id, extension, modifierExtension, type, role, who, requestor, location, policy, network,
                        authorization);
            }
        }
    }

    /**
     * The actor that is reporting the event.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param site Logical source location within the enterprise. Reference to Location.
     * @param observer The identity of source detecting the event. Reference to Practitioner, PractitionerRole,
     *   Organization, CareTeam, Patient, Device, RelatedPerson. Required.
     * @param type The type of source where event originated.
     */
    public record Source(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference site,
            Reference observer,
            List<CodeableConcept> type) implements BackboneElement {

        /**
         * Creates a {@code Source}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Source {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            type = type == null ? List.of() : List.copyOf(type);
            Objects.requireNonNull(observer, "AuditEvent.source.observer is required");
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
         * Returns a builder initialized with the values of this {@code Source}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Source}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference site;
            private Reference observer;
            private List<CodeableConcept> type = new ArrayList<>();

            private Builder() {
            }

            private Builder(Source original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.site = original.site();
                this.observer = original.observer();
                this.type = new ArrayList<>(original.type());
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
             * Sets {@code site}.
             *
             * @param site the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder site(Reference site) {
                this.site = site;
                return this;
            }

            /**
             * Sets {@code observer}.
             *
             * @param observer the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder observer(Reference observer) {
                this.observer = observer;
                return this;
            }

            /**
             * Replaces all {@code type} values.
             *
             * @param type the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder type(List<CodeableConcept> type) {
                this.type = type == null ? new ArrayList<>() : new ArrayList<>(type);
                return this;
            }

            /**
             * Adds a {@code type} value.
             *
             * @param type the value to add
             * @return this builder
             */
            public Builder addType(CodeableConcept type) {
                this.type.add(Objects.requireNonNull(type, "type"));
                return this;
            }

            /**
             * Builds the {@code Source}.
             *
             * @return the {@code Source}
             * @throws NullPointerException if a required element is absent
             */
            public Source build() {
                return new Source(
                        id, extension, modifierExtension, site, observer, type);
            }
        }
    }

    /**
     * Specific instances of data or objects that have been accessed.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param what Specific instance of resource. Reference to Resource.
     * @param role What role the entity played.
     * @param securityLabel Security labels on the entity.
     * @param query Query parameters.
     * @param detail Additional Information about the entity.
     * @param agent Entity is attributed to this agent.
     */
    public record Entity(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference what,
            CodeableConcept role,
            List<CodeableConcept> securityLabel,
            FhirBase64Binary query,
            List<Detail> detail,
            List<AuditEvent.Agent> agent) implements BackboneElement {

        /**
         * Creates an {@code Entity}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Entity {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            securityLabel = securityLabel == null ? List.of() : List.copyOf(securityLabel);
            detail = detail == null ? List.of() : List.copyOf(detail);
            agent = agent == null ? List.of() : List.copyOf(agent);
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

        /**
         * Tagged value pairs for conveying additional information about the entity.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type Name of the property. Required.
         * @param value Property value. Any datatype except FhirInteger64, FhirPositiveInt, FhirUnsignedInt,
         *   FhirDecimal, FhirMarkdown, FhirCode, FhirId, FhirUri, FhirUrl, FhirCanonical, FhirOid, FhirUuid,
         *   FhirInstant, FhirDate, FhirEnum, Identifier, HumanName, Address, ContactPoint, Timing, Attachment,
         *   RatioRange, Coding, SampledData, Age, Distance, Duration, Count, Money, Annotation, Signature,
         *   ContactDetail, Contributor, DataRequirement, ParameterDefinition, RelatedArtifact, TriggerDefinition,
         *   UsageContext, Expression, ExtendedContactDetail, VirtualServiceDetail, Availability, MonetaryComponent,
         *   Reference, CodeableReference, Narrative, Extension, Meta, Dosage, ElementDefinition, ProductShelfLife,
         *   MarketingStatus. Required.
         */
        public record Detail(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                DataType value) implements BackboneElement {

            /**
             * Creates a {@code Detail}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Detail {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(type, "AuditEvent.entity.detail.type is required");
                Objects.requireNonNull(value, "AuditEvent.entity.detail.value is required");
                if (value != null && (value instanceof FhirInteger64
                        || value instanceof FhirPositiveInt
                        || value instanceof FhirUnsignedInt
                        || value instanceof FhirDecimal
                        || value instanceof FhirMarkdown
                        || value instanceof FhirCode
                        || value instanceof FhirId
                        || value instanceof FhirUri
                        || value instanceof FhirUrl
                        || value instanceof FhirCanonical
                        || value instanceof FhirOid
                        || value instanceof FhirUuid
                        || value instanceof FhirInstant
                        || value instanceof FhirDate
                        || value instanceof FhirEnum<?>
                        || value instanceof Identifier
                        || value instanceof HumanName
                        || value instanceof Address
                        || value instanceof ContactPoint
                        || value instanceof Timing
                        || value instanceof Attachment
                        || value instanceof RatioRange
                        || value instanceof Coding
                        || value instanceof SampledData
                        || value instanceof Age
                        || value instanceof Distance
                        || value instanceof Duration
                        || value instanceof Count
                        || value instanceof Money
                        || value instanceof Annotation
                        || value instanceof Signature
                        || value instanceof ContactDetail
                        || value instanceof Contributor
                        || value instanceof DataRequirement
                        || value instanceof ParameterDefinition
                        || value instanceof RelatedArtifact
                        || value instanceof TriggerDefinition
                        || value instanceof UsageContext
                        || value instanceof Expression
                        || value instanceof ExtendedContactDetail
                        || value instanceof VirtualServiceDetail
                        || value instanceof Availability
                        || value instanceof MonetaryComponent
                        || value instanceof Reference
                        || value instanceof CodeableReference
                        || value instanceof Narrative
                        || value instanceof Extension
                        || value instanceof Meta
                        || value instanceof Dosage
                        || value instanceof ElementDefinition
                        || value instanceof ProductShelfLife
                        || value instanceof MarketingStatus)) {
                    throw new IllegalArgumentException(
                            "AuditEvent.entity.detail.value[x] does not allow "
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
             * Returns a builder initialized with the values of this {@code Detail}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Detail}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private DataType value;

                private Builder() {
                }

                private Builder(Detail original) {
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
                 * Sets {@code value}.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(DataType value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Builds the {@code Detail}.
                 *
                 * @return the {@code Detail}
                 * @throws NullPointerException if a required element is absent
                 */
                public Detail build() {
                    return new Detail(
                            id, extension, modifierExtension, type, value);
                }
            }
        }

        /** Builder for {@link Entity}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference what;
            private CodeableConcept role;
            private List<CodeableConcept> securityLabel = new ArrayList<>();
            private FhirBase64Binary query;
            private List<Detail> detail = new ArrayList<>();
            private List<AuditEvent.Agent> agent = new ArrayList<>();

            private Builder() {
            }

            private Builder(Entity original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.what = original.what();
                this.role = original.role();
                this.securityLabel = new ArrayList<>(original.securityLabel());
                this.query = original.query();
                this.detail = new ArrayList<>(original.detail());
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
             * Sets {@code role}.
             *
             * @param role the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder role(CodeableConcept role) {
                this.role = role;
                return this;
            }

            /**
             * Replaces all {@code securityLabel} values.
             *
             * @param securityLabel the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder securityLabel(List<CodeableConcept> securityLabel) {
                this.securityLabel = securityLabel == null ? new ArrayList<>() : new ArrayList<>(securityLabel);
                return this;
            }

            /**
             * Adds a {@code securityLabel} value.
             *
             * @param securityLabel the value to add
             * @return this builder
             */
            public Builder addSecurityLabel(CodeableConcept securityLabel) {
                this.securityLabel.add(Objects.requireNonNull(securityLabel, "securityLabel"));
                return this;
            }

            /**
             * Sets {@code query}.
             *
             * @param query the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder query(FhirBase64Binary query) {
                this.query = query;
                return this;
            }

            /**
             * Replaces all {@code detail} values.
             *
             * @param detail the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder detail(List<Detail> detail) {
                this.detail = detail == null ? new ArrayList<>() : new ArrayList<>(detail);
                return this;
            }

            /**
             * Adds a {@code detail} value.
             *
             * @param detail the value to add
             * @return this builder
             */
            public Builder addDetail(Detail detail) {
                this.detail.add(Objects.requireNonNull(detail, "detail"));
                return this;
            }

            /**
             * Replaces all {@code agent} values.
             *
             * @param agent the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder agent(List<AuditEvent.Agent> agent) {
                this.agent = agent == null ? new ArrayList<>() : new ArrayList<>(agent);
                return this;
            }

            /**
             * Adds a {@code agent} value.
             *
             * @param agent the value to add
             * @return this builder
             */
            public Builder addAgent(AuditEvent.Agent agent) {
                this.agent.add(Objects.requireNonNull(agent, "agent"));
                return this;
            }

            /**
             * Builds the {@code Entity}.
             *
             * @return the {@code Entity}
             */
            public Entity build() {
                return new Entity(
                        id, extension, modifierExtension, what, role, securityLabel, query, detail, agent);
            }
        }
    }

    /** Builder for {@link AuditEvent}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableConcept code;
        private FhirEnum<AuditEventAction> action;
        private FhirEnum<AuditEventSeverity> severity;
        private DataType occurred;
        private FhirInstant recorded;
        private Outcome outcome;
        private List<CodeableConcept> authorization = new ArrayList<>();
        private List<Reference> basedOn = new ArrayList<>();
        private Reference patient;
        private Reference encounter;
        private List<Agent> agent = new ArrayList<>();
        private Source source;
        private List<Entity> entity = new ArrayList<>();

        private Builder() {
        }

        private Builder(AuditEvent original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.category = new ArrayList<>(original.category());
            this.code = original.code();
            this.action = original.action();
            this.severity = original.severity();
            this.occurred = original.occurred();
            this.recorded = original.recorded();
            this.outcome = original.outcome();
            this.authorization = new ArrayList<>(original.authorization());
            this.basedOn = new ArrayList<>(original.basedOn());
            this.patient = original.patient();
            this.encounter = original.encounter();
            this.agent = new ArrayList<>(original.agent());
            this.source = original.source();
            this.entity = new ArrayList<>(original.entity());
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
         * Sets {@code action}.
         *
         * @param action the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder action(FhirEnum<AuditEventAction> action) {
            this.action = action;
            return this;
        }

        /**
         * Sets {@code action}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param action the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder action(AuditEventAction action) {
            return action(action == null ? null : FhirEnum.of(action));
        }

        /**
         * Sets {@code severity}.
         *
         * @param severity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder severity(FhirEnum<AuditEventSeverity> severity) {
            this.severity = severity;
            return this;
        }

        /**
         * Sets {@code severity}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param severity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder severity(AuditEventSeverity severity) {
            return severity(severity == null ? null : FhirEnum.of(severity));
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
         * Sets {@code outcome}.
         *
         * @param outcome the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outcome(Outcome outcome) {
            this.outcome = outcome;
            return this;
        }

        /**
         * Replaces all {@code authorization} values.
         *
         * @param authorization the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder authorization(List<CodeableConcept> authorization) {
            this.authorization = authorization == null ? new ArrayList<>() : new ArrayList<>(authorization);
            return this;
        }

        /**
         * Adds a {@code authorization} value.
         *
         * @param authorization the value to add
         * @return this builder
         */
        public Builder addAuthorization(CodeableConcept authorization) {
            this.authorization.add(Objects.requireNonNull(authorization, "authorization"));
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
         * Sets {@code source}.
         *
         * @param source the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder source(Source source) {
            this.source = source;
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
         * Builds the {@code AuditEvent}.
         *
         * @return the {@code AuditEvent}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public AuditEvent build() {
            return new AuditEvent(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, category, code,
                    action, severity, occurred, recorded, outcome, authorization, basedOn, patient, encounter, agent,
                    source, entity);
        }
    }
}
