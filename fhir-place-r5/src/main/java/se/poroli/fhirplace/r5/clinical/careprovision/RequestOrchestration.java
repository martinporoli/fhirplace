package se.poroli.fhirplace.r5.clinical.careprovision;

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
import se.poroli.fhirplace.r5.datatypes.DataRequirement;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.valuesets.ActionCardinalityBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionConditionKind;
import se.poroli.fhirplace.r5.valuesets.ActionGroupingBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionParticipantType;
import se.poroli.fhirplace.r5.valuesets.ActionPrecheckBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionRelationshipType;
import se.poroli.fhirplace.r5.valuesets.ActionRequiredBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionSelectionBehavior;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;

/**
 * A set of related requests that can be used to capture intended activities that have inter-dependencies such as
 * "give this medication after that one".
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
 * @param identifier Business identifier.
 * @param instantiatesCanonical Instantiates FHIR protocol or definition.
 * @param instantiatesUri Instantiates external protocol or definition.
 * @param basedOn Fulfills plan, proposal, or order. Reference to Resource.
 * @param replaces Request(s) replaced by this request. Reference to Resource.
 * @param groupIdentifier Composite request this is part of.
 * @param status draft | active | on-hold | revoked | completed | entered-in-error | unknown. Required. Modifier
 *   element.
 * @param intent proposal | plan | directive | order | original-order | reflex-order | filler-order | instance-order |
 *   option. Required. Modifier element.
 * @param priority routine | urgent | asap | stat.
 * @param code What's being requested/ordered.
 * @param subject Who the request orchestration is about. Reference to CareTeam, Device, Group, HealthcareService,
 *   Location, Organization, Patient, Practitioner, PractitionerRole, RelatedPerson.
 * @param encounter Created as part of. Reference to Encounter.
 * @param authoredOn When the request orchestration was authored.
 * @param author Device or practitioner that authored the request orchestration. Reference to Device, Practitioner,
 *   PractitionerRole.
 * @param reason Why the request orchestration is needed.
 * @param goal What goals. Reference to Goal.
 * @param note Additional notes about the response.
 * @param action Proposed actions, if any.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/RequestOrchestration">FHIR R5 RequestOrchestration</a>
 */
public record RequestOrchestration(
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
        Identifier groupIdentifier,
        FhirEnum<RequestStatus> status,
        FhirEnum<RequestIntent> intent,
        FhirEnum<RequestPriority> priority,
        CodeableConcept code,
        Reference subject,
        Reference encounter,
        FhirDateTime authoredOn,
        Reference author,
        List<CodeableReference> reason,
        List<Reference> goal,
        List<Annotation> note,
        List<Action> action) implements DomainResource {

    /**
     * Creates a {@code RequestOrchestration}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public RequestOrchestration {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        instantiatesCanonical = instantiatesCanonical == null ? List.of() : List.copyOf(instantiatesCanonical);
        instantiatesUri = instantiatesUri == null ? List.of() : List.copyOf(instantiatesUri);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        replaces = replaces == null ? List.of() : List.copyOf(replaces);
        reason = reason == null ? List.of() : List.copyOf(reason);
        goal = goal == null ? List.of() : List.copyOf(goal);
        note = note == null ? List.of() : List.copyOf(note);
        action = action == null ? List.of() : List.copyOf(action);
        Objects.requireNonNull(status, "RequestOrchestration.status is required");
        Objects.requireNonNull(intent, "RequestOrchestration.intent is required");
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
     * Returns a builder initialized with the values of this {@code RequestOrchestration}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The actions, if any, produced by the evaluation of the artifact.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param linkId Pointer to specific item from the PlanDefinition.
     * @param prefix User-visible prefix for the action (e.g. 1. or A.).
     * @param title User-visible title.
     * @param description Short description of the action.
     * @param textEquivalent Static text equivalent of the action, used if the dynamic aspects cannot be interpreted
     *   by the receiving system.
     * @param priority routine | urgent | asap | stat.
     * @param code Code representing the meaning of the action or sub-actions.
     * @param documentation Supporting documentation for the intended performer of the action.
     * @param goal What goals. Reference to Goal.
     * @param condition Whether or not the action is applicable.
     * @param input Input data requirements.
     * @param output Output data definition.
     * @param relatedAction Relationship to another action.
     * @param timing When the action should take place. One of dateTime, Age, Period, Duration, Range, Timing.
     * @param location Where it should happen.
     * @param participant Who should perform the action.
     * @param type create | update | remove | fire-event.
     * @param groupingBehavior visual-group | logical-group | sentence-group.
     * @param selectionBehavior any | all | all-or-none | exactly-one | at-most-one | one-or-more.
     * @param requiredBehavior must | could | must-unless-documented.
     * @param precheckBehavior yes | no.
     * @param cardinalityBehavior single | multiple.
     * @param resource The target of the action. Reference to Resource.
     * @param definition Description of the activity to be performed. One of canonical, uri.
     * @param transform Transform to apply the template. Canonical reference to StructureMap.
     * @param dynamicValue Dynamic aspects of the definition.
     * @param action Sub action.
     */
    public record Action(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString linkId,
            FhirString prefix,
            FhirString title,
            FhirMarkdown description,
            FhirMarkdown textEquivalent,
            FhirEnum<RequestPriority> priority,
            List<CodeableConcept> code,
            List<RelatedArtifact> documentation,
            List<Reference> goal,
            List<Condition> condition,
            List<Input> input,
            List<Output> output,
            List<RelatedAction> relatedAction,
            DataType timing,
            CodeableReference location,
            List<Participant> participant,
            CodeableConcept type,
            FhirEnum<ActionGroupingBehavior> groupingBehavior,
            FhirEnum<ActionSelectionBehavior> selectionBehavior,
            FhirEnum<ActionRequiredBehavior> requiredBehavior,
            FhirEnum<ActionPrecheckBehavior> precheckBehavior,
            FhirEnum<ActionCardinalityBehavior> cardinalityBehavior,
            Reference resource,
            DataType definition,
            FhirCanonical transform,
            List<DynamicValue> dynamicValue,
            List<RequestOrchestration.Action> action) implements BackboneElement {

        /**
         * Creates an {@code Action}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Action {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            code = code == null ? List.of() : List.copyOf(code);
            documentation = documentation == null ? List.of() : List.copyOf(documentation);
            goal = goal == null ? List.of() : List.copyOf(goal);
            condition = condition == null ? List.of() : List.copyOf(condition);
            input = input == null ? List.of() : List.copyOf(input);
            output = output == null ? List.of() : List.copyOf(output);
            relatedAction = relatedAction == null ? List.of() : List.copyOf(relatedAction);
            participant = participant == null ? List.of() : List.copyOf(participant);
            dynamicValue = dynamicValue == null ? List.of() : List.copyOf(dynamicValue);
            action = action == null ? List.of() : List.copyOf(action);
            if (timing != null && !(timing instanceof FhirDateTime
                    || timing instanceof Age
                    || timing instanceof Period
                    || timing instanceof Duration
                    || timing instanceof Range
                    || timing instanceof Timing)) {
                throw new IllegalArgumentException(
                        "RequestOrchestration.action.timing[x] does not allow "
                                + timing.getClass().getSimpleName());
            }
            if (definition != null && !(definition instanceof FhirCanonical || definition instanceof FhirUri)) {
                throw new IllegalArgumentException(
                        "RequestOrchestration.action.definition[x] must be one of canonical, uri, but was "
                                + definition.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Action}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * An expression that describes applicability criteria, or start/stop conditions for the action.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param kind applicability | start | stop. Required.
         * @param expression Boolean-valued expression.
         */
        public record Condition(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<ActionConditionKind> kind,
                Expression expression) implements BackboneElement {

            /**
             * Creates a {@code Condition}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Condition {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(kind, "RequestOrchestration.action.condition.kind is required");
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
             * Returns a builder initialized with the values of this {@code Condition}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Condition}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<ActionConditionKind> kind;
                private Expression expression;

                private Builder() {
                }

                private Builder(Condition original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.kind = original.kind();
                    this.expression = original.expression();
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
                 * Sets {@code kind}.
                 *
                 * @param kind the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder kind(FhirEnum<ActionConditionKind> kind) {
                    this.kind = kind;
                    return this;
                }

                /**
                 * Sets {@code kind}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param kind the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder kind(ActionConditionKind kind) {
                    return kind(kind == null ? null : FhirEnum.of(kind));
                }

                /**
                 * Sets {@code expression}.
                 *
                 * @param expression the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder expression(Expression expression) {
                    this.expression = expression;
                    return this;
                }

                /**
                 * Builds the {@code Condition}.
                 *
                 * @return the {@code Condition}
                 * @throws NullPointerException if a required element is absent
                 */
                public Condition build() {
                    return new Condition(
                            id, extension, modifierExtension, kind, expression);
                }
            }
        }

        /**
         * Defines input data requirements for the action.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param title User-visible title.
         * @param requirement What data is provided.
         * @param relatedData What data is provided.
         */
        public record Input(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString title,
                DataRequirement requirement,
                FhirId relatedData) implements BackboneElement {

            /**
             * Creates an {@code Input}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Input {
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
                private FhirString title;
                private DataRequirement requirement;
                private FhirId relatedData;

                private Builder() {
                }

                private Builder(Input original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.title = original.title();
                    this.requirement = original.requirement();
                    this.relatedData = original.relatedData();
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
                 * Sets {@code requirement}.
                 *
                 * @param requirement the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder requirement(DataRequirement requirement) {
                    this.requirement = requirement;
                    return this;
                }

                /**
                 * Sets {@code relatedData}.
                 *
                 * @param relatedData the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relatedData(FhirId relatedData) {
                    this.relatedData = relatedData;
                    return this;
                }

                /**
                 * Sets {@code relatedData}, wrapped in a {@link FhirId} without id or extensions.
                 *
                 * @param relatedData the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relatedData(String relatedData) {
                    return relatedData(relatedData == null ? null : FhirId.of(relatedData));
                }

                /**
                 * Builds the {@code Input}.
                 *
                 * @return the {@code Input}
                 */
                public Input build() {
                    return new Input(
                            id, extension, modifierExtension, title, requirement, relatedData);
                }
            }
        }

        /**
         * Defines the outputs of the action, if any.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param title User-visible title.
         * @param requirement What data is provided.
         * @param relatedData What data is provided.
         */
        public record Output(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString title,
                DataRequirement requirement,
                FhirString relatedData) implements BackboneElement {

            /**
             * Creates an {@code Output}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Output {
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
                private FhirString title;
                private DataRequirement requirement;
                private FhirString relatedData;

                private Builder() {
                }

                private Builder(Output original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.title = original.title();
                    this.requirement = original.requirement();
                    this.relatedData = original.relatedData();
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
                 * Sets {@code requirement}.
                 *
                 * @param requirement the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder requirement(DataRequirement requirement) {
                    this.requirement = requirement;
                    return this;
                }

                /**
                 * Sets {@code relatedData}.
                 *
                 * @param relatedData the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relatedData(FhirString relatedData) {
                    this.relatedData = relatedData;
                    return this;
                }

                /**
                 * Sets {@code relatedData}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param relatedData the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relatedData(String relatedData) {
                    return relatedData(relatedData == null ? null : FhirString.of(relatedData));
                }

                /**
                 * Builds the {@code Output}.
                 *
                 * @return the {@code Output}
                 */
                public Output build() {
                    return new Output(
                            id, extension, modifierExtension, title, requirement, relatedData);
                }
            }
        }

        /**
         * A relationship to another action such as "before" or "30-60 minutes after start of".
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param targetId What action this is related to. Required.
         * @param relationship before | before-start | before-end | concurrent | concurrent-with-start |
         *   concurrent-with-end | after | after-start | after-end. Required.
         * @param endRelationship before | before-start | before-end | concurrent | concurrent-with-start |
         *   concurrent-with-end | after | after-start | after-end.
         * @param offset Time offset for the relationship. One of Duration, Range.
         */
        public record RelatedAction(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirId targetId,
                FhirEnum<ActionRelationshipType> relationship,
                FhirEnum<ActionRelationshipType> endRelationship,
                DataType offset) implements BackboneElement {

            /**
             * Creates a {@code RelatedAction}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public RelatedAction {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(targetId, "RequestOrchestration.action.relatedAction.targetId is required");
                Objects.requireNonNull(
                        relationship, "RequestOrchestration.action.relatedAction.relationship is required");
                if (offset != null && !(offset instanceof Duration || offset instanceof Range)) {
                    throw new IllegalArgumentException(
                            "RequestOrchestration.action.relatedAction.offset[x] does not allow "
                                    + offset.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code RelatedAction}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link RelatedAction}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirId targetId;
                private FhirEnum<ActionRelationshipType> relationship;
                private FhirEnum<ActionRelationshipType> endRelationship;
                private DataType offset;

                private Builder() {
                }

                private Builder(RelatedAction original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.targetId = original.targetId();
                    this.relationship = original.relationship();
                    this.endRelationship = original.endRelationship();
                    this.offset = original.offset();
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
                 * Sets {@code targetId}.
                 *
                 * @param targetId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder targetId(FhirId targetId) {
                    this.targetId = targetId;
                    return this;
                }

                /**
                 * Sets {@code targetId}, wrapped in a {@link FhirId} without id or extensions.
                 *
                 * @param targetId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder targetId(String targetId) {
                    return targetId(targetId == null ? null : FhirId.of(targetId));
                }

                /**
                 * Sets {@code relationship}.
                 *
                 * @param relationship the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relationship(FhirEnum<ActionRelationshipType> relationship) {
                    this.relationship = relationship;
                    return this;
                }

                /**
                 * Sets {@code relationship}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param relationship the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relationship(ActionRelationshipType relationship) {
                    return relationship(relationship == null ? null : FhirEnum.of(relationship));
                }

                /**
                 * Sets {@code endRelationship}.
                 *
                 * @param endRelationship the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder endRelationship(FhirEnum<ActionRelationshipType> endRelationship) {
                    this.endRelationship = endRelationship;
                    return this;
                }

                /**
                 * Sets {@code endRelationship}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param endRelationship the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder endRelationship(ActionRelationshipType endRelationship) {
                    return endRelationship(endRelationship == null ? null : FhirEnum.of(endRelationship));
                }

                /**
                 * Sets {@code offset} to a Duration.
                 *
                 * @param offset the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder offset(Duration offset) {
                    this.offset = offset;
                    return this;
                }

                /**
                 * Sets {@code offset} to a Range.
                 *
                 * @param offset the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder offset(Range offset) {
                    this.offset = offset;
                    return this;
                }

                /**
                 * Builds the {@code RelatedAction}.
                 *
                 * @return the {@code RelatedAction}
                 * @throws NullPointerException if a required element is absent
                 */
                public RelatedAction build() {
                    return new RelatedAction(
                            id, extension, modifierExtension, targetId, relationship, endRelationship, offset);
                }
            }
        }

        /**
         * The participant that should perform or be responsible for this action.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type careteam | device | group | healthcareservice | location | organization | patient |
         *   practitioner | practitionerrole | relatedperson.
         * @param typeCanonical Who or what can participate. Canonical reference to CapabilityStatement.
         * @param typeReference Who or what can participate. Reference to CareTeam, Device, DeviceDefinition,
         *   Endpoint, Group, HealthcareService, Location, Organization, Patient, Practitioner, PractitionerRole,
         *   RelatedPerson.
         * @param role E.g. Nurse, Surgeon, Parent, etc.
         * @param function E.g. Author, Reviewer, Witness, etc.
         * @param actor Who/what is participating?. One of canonical, Reference.
         */
        public record Participant(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<ActionParticipantType> type,
                FhirCanonical typeCanonical,
                Reference typeReference,
                CodeableConcept role,
                CodeableConcept function,
                DataType actor) implements BackboneElement {

            /**
             * Creates a {@code Participant}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Participant {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                if (actor != null && !(actor instanceof FhirCanonical || actor instanceof Reference)) {
                    throw new IllegalArgumentException(
                            "RequestOrchestration.action.participant.actor[x] does not allow "
                                    + actor.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code Participant}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Participant}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<ActionParticipantType> type;
                private FhirCanonical typeCanonical;
                private Reference typeReference;
                private CodeableConcept role;
                private CodeableConcept function;
                private DataType actor;

                private Builder() {
                }

                private Builder(Participant original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.typeCanonical = original.typeCanonical();
                    this.typeReference = original.typeReference();
                    this.role = original.role();
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
                 * Sets {@code type}.
                 *
                 * @param type the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder type(FhirEnum<ActionParticipantType> type) {
                    this.type = type;
                    return this;
                }

                /**
                 * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param type the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder type(ActionParticipantType type) {
                    return type(type == null ? null : FhirEnum.of(type));
                }

                /**
                 * Sets {@code typeCanonical}.
                 *
                 * @param typeCanonical the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder typeCanonical(FhirCanonical typeCanonical) {
                    this.typeCanonical = typeCanonical;
                    return this;
                }

                /**
                 * Sets {@code typeCanonical}, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param typeCanonical the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder typeCanonical(String typeCanonical) {
                    return typeCanonical(typeCanonical == null ? null : FhirCanonical.of(typeCanonical));
                }

                /**
                 * Sets {@code typeReference}.
                 *
                 * @param typeReference the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder typeReference(Reference typeReference) {
                    this.typeReference = typeReference;
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
                 * Sets {@code actor} to a canonical.
                 *
                 * @param actor the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder actor(FhirCanonical actor) {
                    this.actor = actor;
                    return this;
                }

                /**
                 * Sets {@code actor} to a Reference.
                 *
                 * @param actor the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder actor(Reference actor) {
                    this.actor = actor;
                    return this;
                }

                /**
                 * Sets {@code actor} to a canonical without id or extensions.
                 *
                 * @param actor the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder actor(String actor) {
                    this.actor = actor == null ? null : FhirCanonical.of(actor);
                    return this;
                }

                /**
                 * Builds the {@code Participant}.
                 *
                 * @return the {@code Participant}
                 */
                public Participant build() {
                    return new Participant(
                            id, extension, modifierExtension, type, typeCanonical, typeReference, role, function,
                            actor);
                }
            }
        }

        /**
         * Customizations that should be applied to the statically defined resource.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param path The path to the element to be set dynamically.
         * @param expression An expression that provides the dynamic value for the customization.
         */
        public record DynamicValue(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString path,
                Expression expression) implements BackboneElement {

            /**
             * Creates a {@code DynamicValue}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public DynamicValue {
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
             * Returns a builder initialized with the values of this {@code DynamicValue}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link DynamicValue}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString path;
                private Expression expression;

                private Builder() {
                }

                private Builder(DynamicValue original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.path = original.path();
                    this.expression = original.expression();
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
                 * Sets {@code path}.
                 *
                 * @param path the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder path(FhirString path) {
                    this.path = path;
                    return this;
                }

                /**
                 * Sets {@code path}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param path the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder path(String path) {
                    return path(path == null ? null : FhirString.of(path));
                }

                /**
                 * Sets {@code expression}.
                 *
                 * @param expression the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder expression(Expression expression) {
                    this.expression = expression;
                    return this;
                }

                /**
                 * Builds the {@code DynamicValue}.
                 *
                 * @return the {@code DynamicValue}
                 */
                public DynamicValue build() {
                    return new DynamicValue(
                            id, extension, modifierExtension, path, expression);
                }
            }
        }

        /** Builder for {@link Action}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString linkId;
            private FhirString prefix;
            private FhirString title;
            private FhirMarkdown description;
            private FhirMarkdown textEquivalent;
            private FhirEnum<RequestPriority> priority;
            private List<CodeableConcept> code = new ArrayList<>();
            private List<RelatedArtifact> documentation = new ArrayList<>();
            private List<Reference> goal = new ArrayList<>();
            private List<Condition> condition = new ArrayList<>();
            private List<Input> input = new ArrayList<>();
            private List<Output> output = new ArrayList<>();
            private List<RelatedAction> relatedAction = new ArrayList<>();
            private DataType timing;
            private CodeableReference location;
            private List<Participant> participant = new ArrayList<>();
            private CodeableConcept type;
            private FhirEnum<ActionGroupingBehavior> groupingBehavior;
            private FhirEnum<ActionSelectionBehavior> selectionBehavior;
            private FhirEnum<ActionRequiredBehavior> requiredBehavior;
            private FhirEnum<ActionPrecheckBehavior> precheckBehavior;
            private FhirEnum<ActionCardinalityBehavior> cardinalityBehavior;
            private Reference resource;
            private DataType definition;
            private FhirCanonical transform;
            private List<DynamicValue> dynamicValue = new ArrayList<>();
            private List<RequestOrchestration.Action> action = new ArrayList<>();

            private Builder() {
            }

            private Builder(Action original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.linkId = original.linkId();
                this.prefix = original.prefix();
                this.title = original.title();
                this.description = original.description();
                this.textEquivalent = original.textEquivalent();
                this.priority = original.priority();
                this.code = new ArrayList<>(original.code());
                this.documentation = new ArrayList<>(original.documentation());
                this.goal = new ArrayList<>(original.goal());
                this.condition = new ArrayList<>(original.condition());
                this.input = new ArrayList<>(original.input());
                this.output = new ArrayList<>(original.output());
                this.relatedAction = new ArrayList<>(original.relatedAction());
                this.timing = original.timing();
                this.location = original.location();
                this.participant = new ArrayList<>(original.participant());
                this.type = original.type();
                this.groupingBehavior = original.groupingBehavior();
                this.selectionBehavior = original.selectionBehavior();
                this.requiredBehavior = original.requiredBehavior();
                this.precheckBehavior = original.precheckBehavior();
                this.cardinalityBehavior = original.cardinalityBehavior();
                this.resource = original.resource();
                this.definition = original.definition();
                this.transform = original.transform();
                this.dynamicValue = new ArrayList<>(original.dynamicValue());
                this.action = new ArrayList<>(original.action());
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
             * Sets {@code linkId}.
             *
             * @param linkId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder linkId(FhirString linkId) {
                this.linkId = linkId;
                return this;
            }

            /**
             * Sets {@code linkId}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param linkId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder linkId(String linkId) {
                return linkId(linkId == null ? null : FhirString.of(linkId));
            }

            /**
             * Sets {@code prefix}.
             *
             * @param prefix the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder prefix(FhirString prefix) {
                this.prefix = prefix;
                return this;
            }

            /**
             * Sets {@code prefix}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param prefix the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder prefix(String prefix) {
                return prefix(prefix == null ? null : FhirString.of(prefix));
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
            public Builder description(FhirMarkdown description) {
                this.description = description;
                return this;
            }

            /**
             * Sets {@code description}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(String description) {
                return description(description == null ? null : FhirMarkdown.of(description));
            }

            /**
             * Sets {@code textEquivalent}.
             *
             * @param textEquivalent the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder textEquivalent(FhirMarkdown textEquivalent) {
                this.textEquivalent = textEquivalent;
                return this;
            }

            /**
             * Sets {@code textEquivalent}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param textEquivalent the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder textEquivalent(String textEquivalent) {
                return textEquivalent(textEquivalent == null ? null : FhirMarkdown.of(textEquivalent));
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
             * Replaces all {@code documentation} values.
             *
             * @param documentation the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder documentation(List<RelatedArtifact> documentation) {
                this.documentation = documentation == null ? new ArrayList<>() : new ArrayList<>(documentation);
                return this;
            }

            /**
             * Adds a {@code documentation} value.
             *
             * @param documentation the value to add
             * @return this builder
             */
            public Builder addDocumentation(RelatedArtifact documentation) {
                this.documentation.add(Objects.requireNonNull(documentation, "documentation"));
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
             * Replaces all {@code condition} values.
             *
             * @param condition the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder condition(List<Condition> condition) {
                this.condition = condition == null ? new ArrayList<>() : new ArrayList<>(condition);
                return this;
            }

            /**
             * Adds a {@code condition} value.
             *
             * @param condition the value to add
             * @return this builder
             */
            public Builder addCondition(Condition condition) {
                this.condition.add(Objects.requireNonNull(condition, "condition"));
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
             * Replaces all {@code relatedAction} values.
             *
             * @param relatedAction the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder relatedAction(List<RelatedAction> relatedAction) {
                this.relatedAction = relatedAction == null ? new ArrayList<>() : new ArrayList<>(relatedAction);
                return this;
            }

            /**
             * Adds a {@code relatedAction} value.
             *
             * @param relatedAction the value to add
             * @return this builder
             */
            public Builder addRelatedAction(RelatedAction relatedAction) {
                this.relatedAction.add(Objects.requireNonNull(relatedAction, "relatedAction"));
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
             * Sets {@code timing} to a Age.
             *
             * @param timing the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder timing(Age timing) {
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
             * Sets {@code timing} to a Duration.
             *
             * @param timing the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder timing(Duration timing) {
                this.timing = timing;
                return this;
            }

            /**
             * Sets {@code timing} to a Range.
             *
             * @param timing the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder timing(Range timing) {
                this.timing = timing;
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
             * Sets {@code location}.
             *
             * @param location the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder location(CodeableReference location) {
                this.location = location;
                return this;
            }

            /**
             * Replaces all {@code participant} values.
             *
             * @param participant the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder participant(List<Participant> participant) {
                this.participant = participant == null ? new ArrayList<>() : new ArrayList<>(participant);
                return this;
            }

            /**
             * Adds a {@code participant} value.
             *
             * @param participant the value to add
             * @return this builder
             */
            public Builder addParticipant(Participant participant) {
                this.participant.add(Objects.requireNonNull(participant, "participant"));
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
             * Sets {@code groupingBehavior}.
             *
             * @param groupingBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder groupingBehavior(FhirEnum<ActionGroupingBehavior> groupingBehavior) {
                this.groupingBehavior = groupingBehavior;
                return this;
            }

            /**
             * Sets {@code groupingBehavior}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param groupingBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder groupingBehavior(ActionGroupingBehavior groupingBehavior) {
                return groupingBehavior(groupingBehavior == null ? null : FhirEnum.of(groupingBehavior));
            }

            /**
             * Sets {@code selectionBehavior}.
             *
             * @param selectionBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder selectionBehavior(FhirEnum<ActionSelectionBehavior> selectionBehavior) {
                this.selectionBehavior = selectionBehavior;
                return this;
            }

            /**
             * Sets {@code selectionBehavior}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param selectionBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder selectionBehavior(ActionSelectionBehavior selectionBehavior) {
                return selectionBehavior(selectionBehavior == null ? null : FhirEnum.of(selectionBehavior));
            }

            /**
             * Sets {@code requiredBehavior}.
             *
             * @param requiredBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder requiredBehavior(FhirEnum<ActionRequiredBehavior> requiredBehavior) {
                this.requiredBehavior = requiredBehavior;
                return this;
            }

            /**
             * Sets {@code requiredBehavior}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param requiredBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder requiredBehavior(ActionRequiredBehavior requiredBehavior) {
                return requiredBehavior(requiredBehavior == null ? null : FhirEnum.of(requiredBehavior));
            }

            /**
             * Sets {@code precheckBehavior}.
             *
             * @param precheckBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder precheckBehavior(FhirEnum<ActionPrecheckBehavior> precheckBehavior) {
                this.precheckBehavior = precheckBehavior;
                return this;
            }

            /**
             * Sets {@code precheckBehavior}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param precheckBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder precheckBehavior(ActionPrecheckBehavior precheckBehavior) {
                return precheckBehavior(precheckBehavior == null ? null : FhirEnum.of(precheckBehavior));
            }

            /**
             * Sets {@code cardinalityBehavior}.
             *
             * @param cardinalityBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder cardinalityBehavior(FhirEnum<ActionCardinalityBehavior> cardinalityBehavior) {
                this.cardinalityBehavior = cardinalityBehavior;
                return this;
            }

            /**
             * Sets {@code cardinalityBehavior}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param cardinalityBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder cardinalityBehavior(ActionCardinalityBehavior cardinalityBehavior) {
                return cardinalityBehavior(cardinalityBehavior == null ? null : FhirEnum.of(cardinalityBehavior));
            }

            /**
             * Sets {@code resource}.
             *
             * @param resource the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder resource(Reference resource) {
                this.resource = resource;
                return this;
            }

            /**
             * Sets {@code definition} to a canonical.
             *
             * @param definition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definition(FhirCanonical definition) {
                this.definition = definition;
                return this;
            }

            /**
             * Sets {@code definition} to a uri.
             *
             * @param definition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definition(FhirUri definition) {
                this.definition = definition;
                return this;
            }

            /**
             * Sets {@code transform}.
             *
             * @param transform the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder transform(FhirCanonical transform) {
                this.transform = transform;
                return this;
            }

            /**
             * Sets {@code transform}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param transform the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder transform(String transform) {
                return transform(transform == null ? null : FhirCanonical.of(transform));
            }

            /**
             * Replaces all {@code dynamicValue} values.
             *
             * @param dynamicValue the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder dynamicValue(List<DynamicValue> dynamicValue) {
                this.dynamicValue = dynamicValue == null ? new ArrayList<>() : new ArrayList<>(dynamicValue);
                return this;
            }

            /**
             * Adds a {@code dynamicValue} value.
             *
             * @param dynamicValue the value to add
             * @return this builder
             */
            public Builder addDynamicValue(DynamicValue dynamicValue) {
                this.dynamicValue.add(Objects.requireNonNull(dynamicValue, "dynamicValue"));
                return this;
            }

            /**
             * Replaces all {@code action} values.
             *
             * @param action the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder action(List<RequestOrchestration.Action> action) {
                this.action = action == null ? new ArrayList<>() : new ArrayList<>(action);
                return this;
            }

            /**
             * Adds a {@code action} value.
             *
             * @param action the value to add
             * @return this builder
             */
            public Builder addAction(RequestOrchestration.Action action) {
                this.action.add(Objects.requireNonNull(action, "action"));
                return this;
            }

            /**
             * Builds the {@code Action}.
             *
             * @return the {@code Action}
             */
            public Action build() {
                return new Action(
                        id, extension, modifierExtension, linkId, prefix, title, description, textEquivalent,
                        priority, code, documentation, goal, condition, input, output, relatedAction, timing,
                        location, participant, type, groupingBehavior, selectionBehavior, requiredBehavior,
                        precheckBehavior, cardinalityBehavior, resource, definition, transform, dynamicValue, action);
            }
        }
    }

    /** Builder for {@link RequestOrchestration}. Builders are mutable and not thread-safe. */
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
        private Identifier groupIdentifier;
        private FhirEnum<RequestStatus> status;
        private FhirEnum<RequestIntent> intent;
        private FhirEnum<RequestPriority> priority;
        private CodeableConcept code;
        private Reference subject;
        private Reference encounter;
        private FhirDateTime authoredOn;
        private Reference author;
        private List<CodeableReference> reason = new ArrayList<>();
        private List<Reference> goal = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<Action> action = new ArrayList<>();

        private Builder() {
        }

        private Builder(RequestOrchestration original) {
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
            this.groupIdentifier = original.groupIdentifier();
            this.status = original.status();
            this.intent = original.intent();
            this.priority = original.priority();
            this.code = original.code();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.authoredOn = original.authoredOn();
            this.author = original.author();
            this.reason = new ArrayList<>(original.reason());
            this.goal = new ArrayList<>(original.goal());
            this.note = new ArrayList<>(original.note());
            this.action = new ArrayList<>(original.action());
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
        public Builder intent(FhirEnum<RequestIntent> intent) {
            this.intent = intent;
            return this;
        }

        /**
         * Sets {@code intent}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(RequestIntent intent) {
            return intent(intent == null ? null : FhirEnum.of(intent));
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
         * Replaces all {@code action} values.
         *
         * @param action the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder action(List<Action> action) {
            this.action = action == null ? new ArrayList<>() : new ArrayList<>(action);
            return this;
        }

        /**
         * Adds a {@code action} value.
         *
         * @param action the value to add
         * @return this builder
         */
        public Builder addAction(Action action) {
            this.action.add(Objects.requireNonNull(action, "action"));
            return this;
        }

        /**
         * Builds the {@code RequestOrchestration}.
         *
         * @return the {@code RequestOrchestration}
         * @throws NullPointerException if a required element is absent
         */
        public RequestOrchestration build() {
            return new RequestOrchestration(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiatesCanonical, instantiatesUri, basedOn, replaces, groupIdentifier, status, intent,
                    priority, code, subject, encounter, authoredOn, author, reason, goal, note, action);
        }
    }
}
