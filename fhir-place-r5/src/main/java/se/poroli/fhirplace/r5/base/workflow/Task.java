package se.poroli.fhirplace.r5.base.workflow;

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
import se.poroli.fhirplace.r5.datatypes.Contributor;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.ElementDefinition;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.TaskStatus;

/**
 * A task to be performed.
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
 * @param identifier Task Instance Identifier.
 * @param instantiatesCanonical Formal definition of task. Canonical reference to ActivityDefinition.
 * @param instantiatesUri Formal definition of task.
 * @param basedOn Request fulfilled by this task. Reference to Resource.
 * @param groupIdentifier Requisition or grouper id.
 * @param partOf Composite task. Reference to Task.
 * @param status draft | requested | received | accepted | +. Required. Modifier element.
 * @param statusReason Reason for current status.
 * @param businessStatus E.g. "Specimen collected", "IV prepped".
 * @param intent unknown | proposal | plan | order | original-order | reflex-order | filler-order | instance-order |
 *   option. Required.
 * @param priority routine | urgent | asap | stat.
 * @param doNotPerform True if Task is prohibiting action. Modifier element.
 * @param code Task Type.
 * @param description Human-readable explanation of task.
 * @param focus What task is acting on. Reference to Resource.
 * @param forValue Beneficiary of the Task. Reference to Resource. The FHIR element {@code for}.
 * @param encounter Healthcare event during which this task originated. Reference to Encounter.
 * @param requestedPeriod When the task should be performed.
 * @param executionPeriod Start and end time of execution.
 * @param authoredOn Task Creation Date.
 * @param lastModified Task Last Modified Date.
 * @param requester Who is asking for task to be done. Reference to Device, Organization, Patient, Practitioner,
 *   PractitionerRole, RelatedPerson.
 * @param requestedPerformer Who should perform Task.
 * @param owner Responsible individual. Reference to Practitioner, PractitionerRole, Organization, CareTeam, Patient,
 *   RelatedPerson.
 * @param performer Who or what performed the task.
 * @param location Where task occurs. Reference to Location.
 * @param reason Why task is needed.
 * @param insurance Associated insurance coverage. Reference to Coverage, ClaimResponse.
 * @param note Comments made about the task.
 * @param relevantHistory Key events in history of the Task. Reference to Provenance.
 * @param restriction Constraints on fulfillment tasks.
 * @param input Information used to perform task.
 * @param output Information produced as part of task.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Task">FHIR R5 Task</a>
 */
public record Task(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirCanonical instantiatesCanonical,
        FhirUri instantiatesUri,
        List<Reference> basedOn,
        Identifier groupIdentifier,
        List<Reference> partOf,
        FhirEnum<TaskStatus> status,
        CodeableReference statusReason,
        CodeableConcept businessStatus,
        FhirCode intent,
        FhirEnum<RequestPriority> priority,
        FhirBoolean doNotPerform,
        CodeableConcept code,
        FhirString description,
        Reference focus,
        Reference forValue,
        Reference encounter,
        Period requestedPeriod,
        Period executionPeriod,
        FhirDateTime authoredOn,
        FhirDateTime lastModified,
        Reference requester,
        List<CodeableReference> requestedPerformer,
        Reference owner,
        List<Performer> performer,
        Reference location,
        List<CodeableReference> reason,
        List<Reference> insurance,
        List<Annotation> note,
        List<Reference> relevantHistory,
        Restriction restriction,
        List<Input> input,
        List<Output> output) implements DomainResource {

    /**
     * Creates a {@code Task}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Task {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        requestedPerformer = requestedPerformer == null ? List.of() : List.copyOf(requestedPerformer);
        performer = performer == null ? List.of() : List.copyOf(performer);
        reason = reason == null ? List.of() : List.copyOf(reason);
        insurance = insurance == null ? List.of() : List.copyOf(insurance);
        note = note == null ? List.of() : List.copyOf(note);
        relevantHistory = relevantHistory == null ? List.of() : List.copyOf(relevantHistory);
        input = input == null ? List.of() : List.copyOf(input);
        output = output == null ? List.of() : List.copyOf(output);
        Objects.requireNonNull(status, "Task.status is required");
        Objects.requireNonNull(intent, "Task.intent is required");
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
     * Returns a builder initialized with the values of this {@code Task}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The entity who performed the requested task.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function Type of performance.
     * @param actor Who performed the task. Reference to Practitioner, PractitionerRole, Organization, CareTeam,
     *   Patient, RelatedPerson. Required.
     */
    public record Performer(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept function,
            Reference actor) implements BackboneElement {

        /**
         * Creates a {@code Performer}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Performer {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(actor, "Task.performer.actor is required");
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

            private Builder() {
            }

            private Builder(Performer original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.function = original.function();
                this.actor = original.actor();
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
             * Builds the {@code Performer}.
             *
             * @return the {@code Performer}
             * @throws NullPointerException if a required element is absent
             */
            public Performer build() {
                return new Performer(
                        id, extension, modifierExtension, function, actor);
            }
        }
    }

    /**
     * If the Task.focus is a request resource and the task is seeking fulfillment (i.e. is asking for the request to
     * be actioned), this element identifies any limitations on what parts of the referenced request should be
     * actioned.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param repetitions How many times to repeat.
     * @param period When fulfillment is sought.
     * @param recipient For whom is fulfillment sought?. Reference to Patient, Practitioner, PractitionerRole,
     *   RelatedPerson, Group, Organization.
     */
    public record Restriction(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt repetitions,
            Period period,
            List<Reference> recipient) implements BackboneElement {

        /**
         * Creates a {@code Restriction}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Restriction {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            recipient = recipient == null ? List.of() : List.copyOf(recipient);
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
         * Returns a builder initialized with the values of this {@code Restriction}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Restriction}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt repetitions;
            private Period period;
            private List<Reference> recipient = new ArrayList<>();

            private Builder() {
            }

            private Builder(Restriction original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.repetitions = original.repetitions();
                this.period = original.period();
                this.recipient = new ArrayList<>(original.recipient());
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
             * Sets {@code repetitions}.
             *
             * @param repetitions the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder repetitions(FhirPositiveInt repetitions) {
                this.repetitions = repetitions;
                return this;
            }

            /**
             * Sets {@code repetitions}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param repetitions the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder repetitions(Integer repetitions) {
                return repetitions(repetitions == null ? null : FhirPositiveInt.of(repetitions));
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
             * Replaces all {@code recipient} values.
             *
             * @param recipient the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder recipient(List<Reference> recipient) {
                this.recipient = recipient == null ? new ArrayList<>() : new ArrayList<>(recipient);
                return this;
            }

            /**
             * Adds a {@code recipient} value.
             *
             * @param recipient the value to add
             * @return this builder
             */
            public Builder addRecipient(Reference recipient) {
                this.recipient.add(Objects.requireNonNull(recipient, "recipient"));
                return this;
            }

            /**
             * Builds the {@code Restriction}.
             *
             * @return the {@code Restriction}
             */
            public Restriction build() {
                return new Restriction(
                        id, extension, modifierExtension, repetitions, period, recipient);
            }
        }
    }

    /**
     * Additional information that may be needed in the execution of the task.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Label for the input. Required.
     * @param value Content to use in performing the task. Any datatype except Contributor, VirtualServiceDetail,
     *   MonetaryComponent, Narrative, Extension, ElementDefinition, ProductShelfLife, MarketingStatus. Required.
     */
    public record Input(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType value) implements BackboneElement {

        /**
         * Creates an {@code Input}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Input {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "Task.input.type is required");
            Objects.requireNonNull(value, "Task.input.value is required");
            if (value != null && (value instanceof Contributor
                    || value instanceof VirtualServiceDetail
                    || value instanceof MonetaryComponent
                    || value instanceof Narrative
                    || value instanceof Extension
                    || value instanceof ElementDefinition
                    || value instanceof ProductShelfLife
                    || value instanceof MarketingStatus)) {
                throw new IllegalArgumentException(
                        "Task.input.value[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code Input}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Input}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private DataType value;

            private Builder() {
            }

            private Builder(Input original) {
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
             * Builds the {@code Input}.
             *
             * @return the {@code Input}
             * @throws NullPointerException if a required element is absent
             */
            public Input build() {
                return new Input(
                        id, extension, modifierExtension, type, value);
            }
        }
    }

    /**
     * Outputs produced by the Task.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Label for output. Required.
     * @param value Result of output. Any datatype except Contributor, VirtualServiceDetail, MonetaryComponent,
     *   Narrative, Extension, ElementDefinition, ProductShelfLife, MarketingStatus. Required.
     */
    public record Output(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType value) implements BackboneElement {

        /**
         * Creates an {@code Output}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Output {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "Task.output.type is required");
            Objects.requireNonNull(value, "Task.output.value is required");
            if (value != null && (value instanceof Contributor
                    || value instanceof VirtualServiceDetail
                    || value instanceof MonetaryComponent
                    || value instanceof Narrative
                    || value instanceof Extension
                    || value instanceof ElementDefinition
                    || value instanceof ProductShelfLife
                    || value instanceof MarketingStatus)) {
                throw new IllegalArgumentException(
                        "Task.output.value[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code Output}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Output}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private DataType value;

            private Builder() {
            }

            private Builder(Output original) {
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
             * Builds the {@code Output}.
             *
             * @return the {@code Output}
             * @throws NullPointerException if a required element is absent
             */
            public Output build() {
                return new Output(
                        id, extension, modifierExtension, type, value);
            }
        }
    }

    /** Builder for {@link Task}. Builders are mutable and not thread-safe. */
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
        private FhirCanonical instantiatesCanonical;
        private FhirUri instantiatesUri;
        private List<Reference> basedOn = new ArrayList<>();
        private Identifier groupIdentifier;
        private List<Reference> partOf = new ArrayList<>();
        private FhirEnum<TaskStatus> status;
        private CodeableReference statusReason;
        private CodeableConcept businessStatus;
        private FhirCode intent;
        private FhirEnum<RequestPriority> priority;
        private FhirBoolean doNotPerform;
        private CodeableConcept code;
        private FhirString description;
        private Reference focus;
        private Reference forValue;
        private Reference encounter;
        private Period requestedPeriod;
        private Period executionPeriod;
        private FhirDateTime authoredOn;
        private FhirDateTime lastModified;
        private Reference requester;
        private List<CodeableReference> requestedPerformer = new ArrayList<>();
        private Reference owner;
        private List<Performer> performer = new ArrayList<>();
        private Reference location;
        private List<CodeableReference> reason = new ArrayList<>();
        private List<Reference> insurance = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<Reference> relevantHistory = new ArrayList<>();
        private Restriction restriction;
        private List<Input> input = new ArrayList<>();
        private List<Output> output = new ArrayList<>();

        private Builder() {
        }

        private Builder(Task original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.instantiatesCanonical = original.instantiatesCanonical();
            this.instantiatesUri = original.instantiatesUri();
            this.basedOn = new ArrayList<>(original.basedOn());
            this.groupIdentifier = original.groupIdentifier();
            this.partOf = new ArrayList<>(original.partOf());
            this.status = original.status();
            this.statusReason = original.statusReason();
            this.businessStatus = original.businessStatus();
            this.intent = original.intent();
            this.priority = original.priority();
            this.doNotPerform = original.doNotPerform();
            this.code = original.code();
            this.description = original.description();
            this.focus = original.focus();
            this.forValue = original.forValue();
            this.encounter = original.encounter();
            this.requestedPeriod = original.requestedPeriod();
            this.executionPeriod = original.executionPeriod();
            this.authoredOn = original.authoredOn();
            this.lastModified = original.lastModified();
            this.requester = original.requester();
            this.requestedPerformer = new ArrayList<>(original.requestedPerformer());
            this.owner = original.owner();
            this.performer = new ArrayList<>(original.performer());
            this.location = original.location();
            this.reason = new ArrayList<>(original.reason());
            this.insurance = new ArrayList<>(original.insurance());
            this.note = new ArrayList<>(original.note());
            this.relevantHistory = new ArrayList<>(original.relevantHistory());
            this.restriction = original.restriction();
            this.input = new ArrayList<>(original.input());
            this.output = new ArrayList<>(original.output());
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
         * Sets {@code instantiatesCanonical}.
         *
         * @param instantiatesCanonical the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesCanonical(FhirCanonical instantiatesCanonical) {
            this.instantiatesCanonical = instantiatesCanonical;
            return this;
        }

        /**
         * Sets {@code instantiatesCanonical}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param instantiatesCanonical the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesCanonical(String instantiatesCanonical) {
            return instantiatesCanonical(
                    instantiatesCanonical == null ? null : FhirCanonical.of(instantiatesCanonical));
        }

        /**
         * Sets {@code instantiatesUri}.
         *
         * @param instantiatesUri the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesUri(FhirUri instantiatesUri) {
            this.instantiatesUri = instantiatesUri;
            return this;
        }

        /**
         * Sets {@code instantiatesUri}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param instantiatesUri the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesUri(String instantiatesUri) {
            return instantiatesUri(instantiatesUri == null ? null : FhirUri.of(instantiatesUri));
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
         * Sets {@code groupIdentifier}.
         *
         * @param groupIdentifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder groupIdentifier(Identifier groupIdentifier) {
            this.groupIdentifier = groupIdentifier;
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
        public Builder status(FhirEnum<TaskStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(TaskStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code statusReason}.
         *
         * @param statusReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusReason(CodeableReference statusReason) {
            this.statusReason = statusReason;
            return this;
        }

        /**
         * Sets {@code businessStatus}.
         *
         * @param businessStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder businessStatus(CodeableConcept businessStatus) {
            this.businessStatus = businessStatus;
            return this;
        }

        /**
         * Sets {@code intent}.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(FhirCode intent) {
            this.intent = intent;
            return this;
        }

        /**
         * Sets {@code intent}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(String intent) {
            return intent(intent == null ? null : FhirCode.of(intent));
        }

        /**
         * Sets {@code priority}.
         *
         * @param priority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priority(FhirEnum<RequestPriority> priority) {
            this.priority = priority;
            return this;
        }

        /**
         * Sets {@code priority}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param priority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priority(RequestPriority priority) {
            return priority(priority == null ? null : FhirEnum.of(priority));
        }

        /**
         * Sets {@code doNotPerform}.
         *
         * @param doNotPerform the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder doNotPerform(FhirBoolean doNotPerform) {
            this.doNotPerform = doNotPerform;
            return this;
        }

        /**
         * Sets {@code doNotPerform}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param doNotPerform the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder doNotPerform(Boolean doNotPerform) {
            return doNotPerform(doNotPerform == null ? null : FhirBoolean.of(doNotPerform));
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
         * Sets {@code forValue}.
         *
         * @param forValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder forValue(Reference forValue) {
            this.forValue = forValue;
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
         * Sets {@code requestedPeriod}.
         *
         * @param requestedPeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requestedPeriod(Period requestedPeriod) {
            this.requestedPeriod = requestedPeriod;
            return this;
        }

        /**
         * Sets {@code executionPeriod}.
         *
         * @param executionPeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder executionPeriod(Period executionPeriod) {
            this.executionPeriod = executionPeriod;
            return this;
        }

        /**
         * Sets {@code authoredOn}.
         *
         * @param authoredOn the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authoredOn(FhirDateTime authoredOn) {
            this.authoredOn = authoredOn;
            return this;
        }

        /**
         * Sets {@code authoredOn}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param authoredOn the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authoredOn(Temporal authoredOn) {
            return authoredOn(authoredOn == null ? null : FhirDateTime.of(authoredOn));
        }

        /**
         * Sets {@code lastModified}.
         *
         * @param lastModified the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastModified(FhirDateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        /**
         * Sets {@code lastModified}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param lastModified the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastModified(Temporal lastModified) {
            return lastModified(lastModified == null ? null : FhirDateTime.of(lastModified));
        }

        /**
         * Sets {@code requester}.
         *
         * @param requester the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requester(Reference requester) {
            this.requester = requester;
            return this;
        }

        /**
         * Replaces all {@code requestedPerformer} values.
         *
         * @param requestedPerformer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder requestedPerformer(List<CodeableReference> requestedPerformer) {
            this.requestedPerformer = requestedPerformer == null
                    ? new ArrayList<>()
                    : new ArrayList<>(requestedPerformer);
            return this;
        }

        /**
         * Adds a {@code requestedPerformer} value.
         *
         * @param requestedPerformer the value to add
         * @return this builder
         */
        public Builder addRequestedPerformer(CodeableReference requestedPerformer) {
            this.requestedPerformer.add(Objects.requireNonNull(requestedPerformer, "requestedPerformer"));
            return this;
        }

        /**
         * Sets {@code owner}.
         *
         * @param owner the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder owner(Reference owner) {
            this.owner = owner;
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
         * Replaces all {@code insurance} values.
         *
         * @param insurance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder insurance(List<Reference> insurance) {
            this.insurance = insurance == null ? new ArrayList<>() : new ArrayList<>(insurance);
            return this;
        }

        /**
         * Adds a {@code insurance} value.
         *
         * @param insurance the value to add
         * @return this builder
         */
        public Builder addInsurance(Reference insurance) {
            this.insurance.add(Objects.requireNonNull(insurance, "insurance"));
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
         * Replaces all {@code relevantHistory} values.
         *
         * @param relevantHistory the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relevantHistory(List<Reference> relevantHistory) {
            this.relevantHistory = relevantHistory == null ? new ArrayList<>() : new ArrayList<>(relevantHistory);
            return this;
        }

        /**
         * Adds a {@code relevantHistory} value.
         *
         * @param relevantHistory the value to add
         * @return this builder
         */
        public Builder addRelevantHistory(Reference relevantHistory) {
            this.relevantHistory.add(Objects.requireNonNull(relevantHistory, "relevantHistory"));
            return this;
        }

        /**
         * Sets {@code restriction}.
         *
         * @param restriction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder restriction(Restriction restriction) {
            this.restriction = restriction;
            return this;
        }

        /**
         * Replaces all {@code input} values.
         *
         * @param input the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder input(List<Input> input) {
            this.input = input == null ? new ArrayList<>() : new ArrayList<>(input);
            return this;
        }

        /**
         * Adds a {@code input} value.
         *
         * @param input the value to add
         * @return this builder
         */
        public Builder addInput(Input input) {
            this.input.add(Objects.requireNonNull(input, "input"));
            return this;
        }

        /**
         * Replaces all {@code output} values.
         *
         * @param output the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder output(List<Output> output) {
            this.output = output == null ? new ArrayList<>() : new ArrayList<>(output);
            return this;
        }

        /**
         * Adds a {@code output} value.
         *
         * @param output the value to add
         * @return this builder
         */
        public Builder addOutput(Output output) {
            this.output.add(Objects.requireNonNull(output, "output"));
            return this;
        }

        /**
         * Builds the {@code Task}.
         *
         * @return the {@code Task}
         * @throws NullPointerException if a required element is absent
         */
        public Task build() {
            return new Task(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiatesCanonical, instantiatesUri, basedOn, groupIdentifier, partOf, status, statusReason,
                    businessStatus, intent, priority, doNotPerform, code, description, focus, forValue, encounter,
                    requestedPeriod, executionPeriod, authoredOn, lastModified, requester, requestedPerformer, owner,
                    performer, location, reason, insurance, note, relevantHistory, restriction, input, output);
        }
    }
}
