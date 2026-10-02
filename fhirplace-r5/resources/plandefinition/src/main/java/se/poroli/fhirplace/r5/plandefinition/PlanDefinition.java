package se.poroli.fhirplace.r5.plandefinition;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataRequirement;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.datatypes.TriggerDefinition;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.ActionCardinalityBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionConditionKind;
import se.poroli.fhirplace.r5.valuesets.ActionGroupingBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionParticipantType;
import se.poroli.fhirplace.r5.valuesets.ActionPrecheckBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionRelationshipType;
import se.poroli.fhirplace.r5.valuesets.ActionRequiredBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionSelectionBehavior;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;

/**
 * This resource allows for the definition of various types of plans as a sharable, consumable, and executable
 * artifact.
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
 * @param url Canonical identifier for this plan definition, represented as a URI (globally unique).
 * @param identifier Additional identifier for the plan definition.
 * @param version Business version of the plan definition.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this plan definition (computer friendly).
 * @param title Name for this plan definition (human friendly).
 * @param subtitle Subordinate title of the plan definition.
 * @param type order-set | clinical-protocol | eca-rule | workflow-definition.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param subject Type of individual the plan definition is focused on. One of CodeableConcept, Reference, canonical.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the plan definition.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for plan definition (if applicable).
 * @param purpose Why this plan definition is defined.
 * @param usage Describes the clinical usage of the plan.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param approvalDate When the plan definition was approved by publisher.
 * @param lastReviewDate When the plan definition was last reviewed by the publisher.
 * @param effectivePeriod When the plan definition is expected to be used.
 * @param topic E.g. Education, Treatment, Assessment.
 * @param author Who authored the content.
 * @param editor Who edited the content.
 * @param reviewer Who reviewed the content.
 * @param endorser Who endorsed the content.
 * @param relatedArtifact Additional documentation, citations.
 * @param library Logic used by the plan definition. Canonical reference to Library.
 * @param goal What the plan is trying to accomplish.
 * @param actor Actors within the plan.
 * @param action Action defined by the plan.
 * @param asNeeded Preconditions for service. One of boolean, CodeableConcept.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/PlanDefinition">FHIR R5 PlanDefinition</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record PlanDefinition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirUri url,
        List<Identifier> identifier,
        FhirString version,
        DataType versionAlgorithm,
        FhirString name,
        FhirString title,
        FhirString subtitle,
        CodeableConcept type,
        FhirEnum<PublicationStatus> status,
        FhirBoolean experimental,
        DataType subject,
        FhirDateTime date,
        FhirString publisher,
        List<ContactDetail> contact,
        FhirMarkdown description,
        List<UsageContext> useContext,
        List<CodeableConcept> jurisdiction,
        FhirMarkdown purpose,
        FhirMarkdown usage,
        FhirMarkdown copyright,
        FhirString copyrightLabel,
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        Period effectivePeriod,
        List<CodeableConcept> topic,
        List<ContactDetail> author,
        List<ContactDetail> editor,
        List<ContactDetail> reviewer,
        List<ContactDetail> endorser,
        List<RelatedArtifact> relatedArtifact,
        List<FhirCanonical> library,
        List<Goal> goal,
        List<Actor> actor,
        List<Action> action,
        DataType asNeeded) implements DomainResource {

    /**
     * Creates a {@code PlanDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public PlanDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        topic = topic == null ? List.of() : List.copyOf(topic);
        author = author == null ? List.of() : List.copyOf(author);
        editor = editor == null ? List.of() : List.copyOf(editor);
        reviewer = reviewer == null ? List.of() : List.copyOf(reviewer);
        endorser = endorser == null ? List.of() : List.copyOf(endorser);
        relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
        library = library == null ? List.of() : List.copyOf(library);
        goal = goal == null ? List.of() : List.copyOf(goal);
        actor = actor == null ? List.of() : List.copyOf(actor);
        action = action == null ? List.of() : List.copyOf(action);
        Objects.requireNonNull(status, "PlanDefinition.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "PlanDefinition.versionAlgorithm[x] must be one of string, Coding, but was "
                            + versionAlgorithm.getClass().getSimpleName());
        }
        if (subject != null && !(subject instanceof CodeableConcept
                || subject instanceof Reference
                || subject instanceof FhirCanonical)) {
            throw new IllegalArgumentException(
                    "PlanDefinition.subject[x] must be one of CodeableConcept, Reference, canonical, but was "
                            + subject.getClass().getSimpleName());
        }
        if (asNeeded != null && !(asNeeded instanceof FhirBoolean || asNeeded instanceof CodeableConcept)) {
            throw new IllegalArgumentException(
                    "PlanDefinition.asNeeded[x] must be one of boolean, CodeableConcept, but was "
                            + asNeeded.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code PlanDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A goal describes an expected outcome that activities within the plan are intended to achieve.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param category E.g. Treatment, dietary, behavioral.
     * @param description Code or text describing the goal. Required.
     * @param priority high-priority | medium-priority | low-priority.
     * @param start When goal pursuit begins.
     * @param addresses What does the goal address.
     * @param documentation Supporting documentation for the goal.
     * @param target Target outcome for the goal.
     */
    public record Goal(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept category,
            CodeableConcept description,
            CodeableConcept priority,
            CodeableConcept start,
            List<CodeableConcept> addresses,
            List<RelatedArtifact> documentation,
            List<Target> target) implements BackboneElement {

        /**
         * Creates a {@code Goal}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Goal {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            addresses = addresses == null ? List.of() : List.copyOf(addresses);
            documentation = documentation == null ? List.of() : List.copyOf(documentation);
            target = target == null ? List.of() : List.copyOf(target);
            Objects.requireNonNull(description, "PlanDefinition.goal.description is required");
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
         * Returns a builder initialized with the values of this {@code Goal}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Indicates what should be done and within what timeframe.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param measure The parameter whose value is to be tracked.
         * @param detail The target value to be achieved. One of Quantity, Range, CodeableConcept, string, boolean,
         *   integer, Ratio.
         * @param due Reach goal within.
         */
        public record Target(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept measure,
                DataType detail,
                Duration due) implements BackboneElement {

            /**
             * Creates a {@code Target}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Target {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                if (detail != null && !(detail instanceof Quantity
                        || detail instanceof Range
                        || detail instanceof CodeableConcept
                        || detail instanceof FhirString
                        || detail instanceof FhirBoolean
                        || detail instanceof FhirInteger
                        || detail instanceof Ratio)) {
                    throw new IllegalArgumentException(
                            "PlanDefinition.goal.target.detail[x] does not allow "
                                    + detail.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code Target}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Target}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept measure;
                private DataType detail;
                private Duration due;

                private Builder() {
                }

                private Builder(Target original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.measure = original.measure();
                    this.detail = original.detail();
                    this.due = original.due();
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
                 * Sets {@code measure}.
                 *
                 * @param measure the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder measure(CodeableConcept measure) {
                    this.measure = measure;
                    return this;
                }

                /**
                 * Sets {@code detail} to a Quantity.
                 *
                 * @param detail the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detail(Quantity detail) {
                    this.detail = detail;
                    return this;
                }

                /**
                 * Sets {@code detail} to a Range.
                 *
                 * @param detail the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detail(Range detail) {
                    this.detail = detail;
                    return this;
                }

                /**
                 * Sets {@code detail} to a CodeableConcept.
                 *
                 * @param detail the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detail(CodeableConcept detail) {
                    this.detail = detail;
                    return this;
                }

                /**
                 * Sets {@code detail} to a string.
                 *
                 * @param detail the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detail(FhirString detail) {
                    this.detail = detail;
                    return this;
                }

                /**
                 * Sets {@code detail} to a boolean.
                 *
                 * @param detail the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detail(FhirBoolean detail) {
                    this.detail = detail;
                    return this;
                }

                /**
                 * Sets {@code detail} to a integer.
                 *
                 * @param detail the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detail(FhirInteger detail) {
                    this.detail = detail;
                    return this;
                }

                /**
                 * Sets {@code detail} to a Ratio.
                 *
                 * @param detail the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detail(Ratio detail) {
                    this.detail = detail;
                    return this;
                }

                /**
                 * Sets {@code detail} to a string without id or extensions.
                 *
                 * @param detail the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detail(String detail) {
                    this.detail = detail == null ? null : FhirString.of(detail);
                    return this;
                }

                /**
                 * Sets {@code detail} to a boolean without id or extensions.
                 *
                 * @param detail the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detail(Boolean detail) {
                    this.detail = detail == null ? null : FhirBoolean.of(detail);
                    return this;
                }

                /**
                 * Sets {@code detail} to a integer without id or extensions.
                 *
                 * @param detail the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detail(Integer detail) {
                    this.detail = detail == null ? null : FhirInteger.of(detail);
                    return this;
                }

                /**
                 * Sets {@code due}.
                 *
                 * @param due the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder due(Duration due) {
                    this.due = due;
                    return this;
                }

                /**
                 * Builds the {@code Target}.
                 *
                 * @return the {@code Target}
                 */
                public Target build() {
                    return new Target(
                            id, extension, modifierExtension, measure, detail, due);
                }
            }
        }

        /** Builder for {@link Goal}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept category;
            private CodeableConcept description;
            private CodeableConcept priority;
            private CodeableConcept start;
            private List<CodeableConcept> addresses = new ArrayList<>();
            private List<RelatedArtifact> documentation = new ArrayList<>();
            private List<Target> target = new ArrayList<>();

            private Builder() {
            }

            private Builder(Goal original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.category = original.category();
                this.description = original.description();
                this.priority = original.priority();
                this.start = original.start();
                this.addresses = new ArrayList<>(original.addresses());
                this.documentation = new ArrayList<>(original.documentation());
                this.target = new ArrayList<>(original.target());
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
             * Sets {@code category}.
             *
             * @param category the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder category(CodeableConcept category) {
                this.category = category;
                return this;
            }

            /**
             * Sets {@code description}.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(CodeableConcept description) {
                this.description = description;
                return this;
            }

            /**
             * Sets {@code priority}.
             *
             * @param priority the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder priority(CodeableConcept priority) {
                this.priority = priority;
                return this;
            }

            /**
             * Sets {@code start}.
             *
             * @param start the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder start(CodeableConcept start) {
                this.start = start;
                return this;
            }

            /**
             * Replaces all {@code addresses} values.
             *
             * @param addresses the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder addresses(List<CodeableConcept> addresses) {
                this.addresses = addresses == null ? new ArrayList<>() : new ArrayList<>(addresses);
                return this;
            }

            /**
             * Adds a {@code addresses} value.
             *
             * @param addresses the value to add
             * @return this builder
             */
            public Builder addAddresses(CodeableConcept addresses) {
                this.addresses.add(Objects.requireNonNull(addresses, "addresses"));
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
             * Replaces all {@code target} values.
             *
             * @param target the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder target(List<Target> target) {
                this.target = target == null ? new ArrayList<>() : new ArrayList<>(target);
                return this;
            }

            /**
             * Adds a {@code target} value.
             *
             * @param target the value to add
             * @return this builder
             */
            public Builder addTarget(Target target) {
                this.target.add(Objects.requireNonNull(target, "target"));
                return this;
            }

            /**
             * Builds the {@code Goal}.
             *
             * @return the {@code Goal}
             * @throws NullPointerException if a required element is absent
             */
            public Goal build() {
                return new Goal(
                        id, extension, modifierExtension, category, description, priority, start, addresses,
                        documentation, target);
            }
        }
    }

    /**
     * Actors represent the individuals or groups involved in the execution of the defined set of activities.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param title User-visible title.
     * @param description Describes the actor.
     * @param option Who or what can be this actor. Required.
     */
    public record Actor(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString title,
            FhirMarkdown description,
            List<Option> option) implements BackboneElement {

        /**
         * Creates an {@code Actor}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Actor {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            option = option == null ? List.of() : List.copyOf(option);
            if (option.isEmpty()) {
                throw new IllegalArgumentException("PlanDefinition.actor.option requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Actor}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The characteristics of the candidates that could serve as the actor.
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
         * @param role E.g. Nurse, Surgeon, Parent.
         */
        public record Option(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<ActionParticipantType> type,
                FhirCanonical typeCanonical,
                Reference typeReference,
                CodeableConcept role) implements BackboneElement {

            /**
             * Creates an {@code Option}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Option {
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
             * Returns a builder initialized with the values of this {@code Option}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Option}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<ActionParticipantType> type;
                private FhirCanonical typeCanonical;
                private Reference typeReference;
                private CodeableConcept role;

                private Builder() {
                }

                private Builder(Option original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.typeCanonical = original.typeCanonical();
                    this.typeReference = original.typeReference();
                    this.role = original.role();
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
                 * Builds the {@code Option}.
                 *
                 * @return the {@code Option}
                 */
                public Option build() {
                    return new Option(
                            id, extension, modifierExtension, type, typeCanonical, typeReference, role);
                }
            }
        }

        /** Builder for {@link Actor}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString title;
            private FhirMarkdown description;
            private List<Option> option = new ArrayList<>();

            private Builder() {
            }

            private Builder(Actor original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.title = original.title();
                this.description = original.description();
                this.option = new ArrayList<>(original.option());
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
             * Replaces all {@code option} values.
             *
             * @param option the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder option(List<Option> option) {
                this.option = option == null ? new ArrayList<>() : new ArrayList<>(option);
                return this;
            }

            /**
             * Adds a {@code option} value.
             *
             * @param option the value to add
             * @return this builder
             */
            public Builder addOption(Option option) {
                this.option.add(Objects.requireNonNull(option, "option"));
                return this;
            }

            /**
             * Builds the {@code Actor}.
             *
             * @return the {@code Actor}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Actor build() {
                return new Actor(
                        id, extension, modifierExtension, title, description, option);
            }
        }
    }

    /**
     * An action or group of actions to be taken as part of the plan.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param linkId Unique id for the action in the PlanDefinition.
     * @param prefix User-visible prefix for the action (e.g. 1. or A.).
     * @param title User-visible title.
     * @param description Brief description of the action.
     * @param textEquivalent Static text equivalent of the action, used if the dynamic aspects cannot be interpreted
     *   by the receiving system.
     * @param priority routine | urgent | asap | stat.
     * @param code Code representing the meaning of the action or sub-actions.
     * @param reason Why the action should be performed.
     * @param documentation Supporting documentation for the intended performer of the action.
     * @param goalId What goals this action supports.
     * @param subject Type of individual the action is focused on. One of CodeableConcept, Reference, canonical.
     * @param trigger When the action should be triggered.
     * @param condition Whether or not the action is applicable.
     * @param input Input data requirements.
     * @param output Output data definition.
     * @param relatedAction Relationship to another action.
     * @param timing When the action should take place. One of Age, Duration, Range, Timing.
     * @param location Where it should happen.
     * @param participant Who should participate in the action.
     * @param type create | update | remove | fire-event.
     * @param groupingBehavior visual-group | logical-group | sentence-group.
     * @param selectionBehavior any | all | all-or-none | exactly-one | at-most-one | one-or-more.
     * @param requiredBehavior must | could | must-unless-documented.
     * @param precheckBehavior yes | no.
     * @param cardinalityBehavior single | multiple.
     * @param definition Description of the activity to be performed. One of canonical, uri.
     * @param transform Transform to apply the template. Canonical reference to StructureMap.
     * @param dynamicValue Dynamic aspects of the definition.
     * @param action A sub-action.
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
            CodeableConcept code,
            List<CodeableConcept> reason,
            List<RelatedArtifact> documentation,
            List<FhirId> goalId,
            DataType subject,
            List<TriggerDefinition> trigger,
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
            DataType definition,
            FhirCanonical transform,
            List<DynamicValue> dynamicValue,
            List<PlanDefinition.Action> action) implements BackboneElement {

        /**
         * Creates an {@code Action}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Action {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            reason = reason == null ? List.of() : List.copyOf(reason);
            documentation = documentation == null ? List.of() : List.copyOf(documentation);
            goalId = goalId == null ? List.of() : List.copyOf(goalId);
            trigger = trigger == null ? List.of() : List.copyOf(trigger);
            condition = condition == null ? List.of() : List.copyOf(condition);
            input = input == null ? List.of() : List.copyOf(input);
            output = output == null ? List.of() : List.copyOf(output);
            relatedAction = relatedAction == null ? List.of() : List.copyOf(relatedAction);
            participant = participant == null ? List.of() : List.copyOf(participant);
            dynamicValue = dynamicValue == null ? List.of() : List.copyOf(dynamicValue);
            action = action == null ? List.of() : List.copyOf(action);
            if (subject != null && !(subject instanceof CodeableConcept
                    || subject instanceof Reference
                    || subject instanceof FhirCanonical)) {
                throw new IllegalArgumentException(
                        "PlanDefinition.action.subject[x] does not allow "
                                + subject.getClass().getSimpleName());
            }
            if (timing != null && !(timing instanceof Age
                    || timing instanceof Duration
                    || timing instanceof Range
                    || timing instanceof Timing)) {
                throw new IllegalArgumentException(
                        "PlanDefinition.action.timing[x] must be one of Age, Duration, Range, Timing, but was "
                                + timing.getClass().getSimpleName());
            }
            if (definition != null && !(definition instanceof FhirCanonical || definition instanceof FhirUri)) {
                throw new IllegalArgumentException(
                        "PlanDefinition.action.definition[x] must be one of canonical, uri, but was "
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
         * An expression that describes applicability criteria or start/stop conditions for the action.
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
                Objects.requireNonNull(kind, "PlanDefinition.action.condition.kind is required");
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
         * @param targetId What action is this related to. Required.
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
                Objects.requireNonNull(targetId, "PlanDefinition.action.relatedAction.targetId is required");
                Objects.requireNonNull(relationship, "PlanDefinition.action.relatedAction.relationship is required");
                if (offset != null && !(offset instanceof Duration || offset instanceof Range)) {
                    throw new IllegalArgumentException(
                            "PlanDefinition.action.relatedAction.offset[x] must be one of Duration, Range, but was "
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
         * Indicates who should participate in performing the action described.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param actorId What actor.
         * @param type careteam | device | group | healthcareservice | location | organization | patient |
         *   practitioner | practitionerrole | relatedperson.
         * @param typeCanonical Who or what can participate. Canonical reference to CapabilityStatement.
         * @param typeReference Who or what can participate. Reference to CareTeam, Device, DeviceDefinition,
         *   Endpoint, Group, HealthcareService, Location, Organization, Patient, Practitioner, PractitionerRole,
         *   RelatedPerson.
         * @param role E.g. Nurse, Surgeon, Parent.
         * @param function E.g. Author, Reviewer, Witness, etc.
         */
        public record Participant(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString actorId,
                FhirEnum<ActionParticipantType> type,
                FhirCanonical typeCanonical,
                Reference typeReference,
                CodeableConcept role,
                CodeableConcept function) implements BackboneElement {

            /**
             * Creates a {@code Participant}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Participant {
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
                private FhirString actorId;
                private FhirEnum<ActionParticipantType> type;
                private FhirCanonical typeCanonical;
                private Reference typeReference;
                private CodeableConcept role;
                private CodeableConcept function;

                private Builder() {
                }

                private Builder(Participant original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.actorId = original.actorId();
                    this.type = original.type();
                    this.typeCanonical = original.typeCanonical();
                    this.typeReference = original.typeReference();
                    this.role = original.role();
                    this.function = original.function();
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
                 * Sets {@code actorId}.
                 *
                 * @param actorId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder actorId(FhirString actorId) {
                    this.actorId = actorId;
                    return this;
                }

                /**
                 * Sets {@code actorId}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param actorId the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder actorId(String actorId) {
                    return actorId(actorId == null ? null : FhirString.of(actorId));
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
                 * Builds the {@code Participant}.
                 *
                 * @return the {@code Participant}
                 */
                public Participant build() {
                    return new Participant(
                            id, extension, modifierExtension, actorId, type, typeCanonical, typeReference, role,
                            function);
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
            private CodeableConcept code;
            private List<CodeableConcept> reason = new ArrayList<>();
            private List<RelatedArtifact> documentation = new ArrayList<>();
            private List<FhirId> goalId = new ArrayList<>();
            private DataType subject;
            private List<TriggerDefinition> trigger = new ArrayList<>();
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
            private DataType definition;
            private FhirCanonical transform;
            private List<DynamicValue> dynamicValue = new ArrayList<>();
            private List<PlanDefinition.Action> action = new ArrayList<>();

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
                this.code = original.code();
                this.reason = new ArrayList<>(original.reason());
                this.documentation = new ArrayList<>(original.documentation());
                this.goalId = new ArrayList<>(original.goalId());
                this.subject = original.subject();
                this.trigger = new ArrayList<>(original.trigger());
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
             * Replaces all {@code goalId} values.
             *
             * @param goalId the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder goalId(List<FhirId> goalId) {
                this.goalId = goalId == null ? new ArrayList<>() : new ArrayList<>(goalId);
                return this;
            }

            /**
             * Adds a {@code goalId} value.
             *
             * @param goalId the value to add
             * @return this builder
             */
            public Builder addGoalId(FhirId goalId) {
                this.goalId.add(Objects.requireNonNull(goalId, "goalId"));
                return this;
            }

            /**
             * Adds a {@code goalId} value, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param goalId the value to add
             * @return this builder
             */
            public Builder addGoalId(String goalId) {
                return addGoalId(FhirId.of(goalId));
            }

            /**
             * Sets {@code subject} to a CodeableConcept.
             *
             * @param subject the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subject(CodeableConcept subject) {
                this.subject = subject;
                return this;
            }

            /**
             * Sets {@code subject} to a Reference.
             *
             * @param subject the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subject(Reference subject) {
                this.subject = subject;
                return this;
            }

            /**
             * Sets {@code subject} to a canonical.
             *
             * @param subject the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subject(FhirCanonical subject) {
                this.subject = subject;
                return this;
            }

            /**
             * Sets {@code subject} to a canonical without id or extensions.
             *
             * @param subject the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subject(String subject) {
                this.subject = subject == null ? null : FhirCanonical.of(subject);
                return this;
            }

            /**
             * Replaces all {@code trigger} values.
             *
             * @param trigger the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder trigger(List<TriggerDefinition> trigger) {
                this.trigger = trigger == null ? new ArrayList<>() : new ArrayList<>(trigger);
                return this;
            }

            /**
             * Adds a {@code trigger} value.
             *
             * @param trigger the value to add
             * @return this builder
             */
            public Builder addTrigger(TriggerDefinition trigger) {
                this.trigger.add(Objects.requireNonNull(trigger, "trigger"));
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
            public Builder action(List<PlanDefinition.Action> action) {
                this.action = action == null ? new ArrayList<>() : new ArrayList<>(action);
                return this;
            }

            /**
             * Adds a {@code action} value.
             *
             * @param action the value to add
             * @return this builder
             */
            public Builder addAction(PlanDefinition.Action action) {
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
                        priority, code, reason, documentation, goalId, subject, trigger, condition, input, output,
                        relatedAction, timing, location, participant, type, groupingBehavior, selectionBehavior,
                        requiredBehavior, precheckBehavior, cardinalityBehavior, definition, transform, dynamicValue,
                        action);
            }
        }
    }

    /** Builder for {@link PlanDefinition}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirUri url;
        private List<Identifier> identifier = new ArrayList<>();
        private FhirString version;
        private DataType versionAlgorithm;
        private FhirString name;
        private FhirString title;
        private FhirString subtitle;
        private CodeableConcept type;
        private FhirEnum<PublicationStatus> status;
        private FhirBoolean experimental;
        private DataType subject;
        private FhirDateTime date;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private FhirMarkdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private FhirMarkdown purpose;
        private FhirMarkdown usage;
        private FhirMarkdown copyright;
        private FhirString copyrightLabel;
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private Period effectivePeriod;
        private List<CodeableConcept> topic = new ArrayList<>();
        private List<ContactDetail> author = new ArrayList<>();
        private List<ContactDetail> editor = new ArrayList<>();
        private List<ContactDetail> reviewer = new ArrayList<>();
        private List<ContactDetail> endorser = new ArrayList<>();
        private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
        private List<FhirCanonical> library = new ArrayList<>();
        private List<Goal> goal = new ArrayList<>();
        private List<Actor> actor = new ArrayList<>();
        private List<Action> action = new ArrayList<>();
        private DataType asNeeded;

        private Builder() {
        }

        private Builder(PlanDefinition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.url = original.url();
            this.identifier = new ArrayList<>(original.identifier());
            this.version = original.version();
            this.versionAlgorithm = original.versionAlgorithm();
            this.name = original.name();
            this.title = original.title();
            this.subtitle = original.subtitle();
            this.type = original.type();
            this.status = original.status();
            this.experimental = original.experimental();
            this.subject = original.subject();
            this.date = original.date();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.description = original.description();
            this.useContext = new ArrayList<>(original.useContext());
            this.jurisdiction = new ArrayList<>(original.jurisdiction());
            this.purpose = original.purpose();
            this.usage = original.usage();
            this.copyright = original.copyright();
            this.copyrightLabel = original.copyrightLabel();
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.effectivePeriod = original.effectivePeriod();
            this.topic = new ArrayList<>(original.topic());
            this.author = new ArrayList<>(original.author());
            this.editor = new ArrayList<>(original.editor());
            this.reviewer = new ArrayList<>(original.reviewer());
            this.endorser = new ArrayList<>(original.endorser());
            this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
            this.library = new ArrayList<>(original.library());
            this.goal = new ArrayList<>(original.goal());
            this.actor = new ArrayList<>(original.actor());
            this.action = new ArrayList<>(original.action());
            this.asNeeded = original.asNeeded();
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
         * Sets {@code url}.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(FhirUri url) {
            this.url = url;
            return this;
        }

        /**
         * Sets {@code url}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(String url) {
            return url(url == null ? null : FhirUri.of(url));
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
         * Sets {@code version}.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(FhirString version) {
            this.version = version;
            return this;
        }

        /**
         * Sets {@code version}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(String version) {
            return version(version == null ? null : FhirString.of(version));
        }

        /**
         * Sets {@code versionAlgorithm} to a string.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(FhirString versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a Coding.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(Coding versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a string without id or extensions.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(String versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm == null ? null : FhirString.of(versionAlgorithm);
            return this;
        }

        /**
         * Sets {@code name}.
         *
         * @param name the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder name(FhirString name) {
            this.name = name;
            return this;
        }

        /**
         * Sets {@code name}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param name the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder name(String name) {
            return name(name == null ? null : FhirString.of(name));
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
         * Sets {@code subtitle}.
         *
         * @param subtitle the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subtitle(FhirString subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        /**
         * Sets {@code subtitle}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param subtitle the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subtitle(String subtitle) {
            return subtitle(subtitle == null ? null : FhirString.of(subtitle));
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<PublicationStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(PublicationStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code experimental}.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(FhirBoolean experimental) {
            this.experimental = experimental;
            return this;
        }

        /**
         * Sets {@code experimental}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(Boolean experimental) {
            return experimental(experimental == null ? null : FhirBoolean.of(experimental));
        }

        /**
         * Sets {@code subject} to a CodeableConcept.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(CodeableConcept subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets {@code subject} to a Reference.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(Reference subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets {@code subject} to a canonical.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(FhirCanonical subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets {@code subject} to a canonical without id or extensions.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(String subject) {
            this.subject = subject == null ? null : FhirCanonical.of(subject);
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
         * Sets {@code publisher}.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(FhirString publisher) {
            this.publisher = publisher;
            return this;
        }

        /**
         * Sets {@code publisher}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(String publisher) {
            return publisher(publisher == null ? null : FhirString.of(publisher));
        }

        /**
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ContactDetail> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ContactDetail contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
            return this;
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
         * Replaces all {@code useContext} values.
         *
         * @param useContext the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder useContext(List<UsageContext> useContext) {
            this.useContext = useContext == null ? new ArrayList<>() : new ArrayList<>(useContext);
            return this;
        }

        /**
         * Adds a {@code useContext} value.
         *
         * @param useContext the value to add
         * @return this builder
         */
        public Builder addUseContext(UsageContext useContext) {
            this.useContext.add(Objects.requireNonNull(useContext, "useContext"));
            return this;
        }

        /**
         * Replaces all {@code jurisdiction} values.
         *
         * @param jurisdiction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder jurisdiction(List<CodeableConcept> jurisdiction) {
            this.jurisdiction = jurisdiction == null ? new ArrayList<>() : new ArrayList<>(jurisdiction);
            return this;
        }

        /**
         * Adds a {@code jurisdiction} value.
         *
         * @param jurisdiction the value to add
         * @return this builder
         */
        public Builder addJurisdiction(CodeableConcept jurisdiction) {
            this.jurisdiction.add(Objects.requireNonNull(jurisdiction, "jurisdiction"));
            return this;
        }

        /**
         * Sets {@code purpose}.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(FhirMarkdown purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * Sets {@code purpose}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(String purpose) {
            return purpose(purpose == null ? null : FhirMarkdown.of(purpose));
        }

        /**
         * Sets {@code usage}.
         *
         * @param usage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder usage(FhirMarkdown usage) {
            this.usage = usage;
            return this;
        }

        /**
         * Sets {@code usage}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param usage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder usage(String usage) {
            return usage(usage == null ? null : FhirMarkdown.of(usage));
        }

        /**
         * Sets {@code copyright}.
         *
         * @param copyright the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyright(FhirMarkdown copyright) {
            this.copyright = copyright;
            return this;
        }

        /**
         * Sets {@code copyright}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param copyright the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyright(String copyright) {
            return copyright(copyright == null ? null : FhirMarkdown.of(copyright));
        }

        /**
         * Sets {@code copyrightLabel}.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(FhirString copyrightLabel) {
            this.copyrightLabel = copyrightLabel;
            return this;
        }

        /**
         * Sets {@code copyrightLabel}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(String copyrightLabel) {
            return copyrightLabel(copyrightLabel == null ? null : FhirString.of(copyrightLabel));
        }

        /**
         * Sets {@code approvalDate}.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(FhirDate approvalDate) {
            this.approvalDate = approvalDate;
            return this;
        }

        /**
         * Sets {@code approvalDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(Temporal approvalDate) {
            return approvalDate(approvalDate == null ? null : FhirDate.of(approvalDate));
        }

        /**
         * Sets {@code lastReviewDate}.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(FhirDate lastReviewDate) {
            this.lastReviewDate = lastReviewDate;
            return this;
        }

        /**
         * Sets {@code lastReviewDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(Temporal lastReviewDate) {
            return lastReviewDate(lastReviewDate == null ? null : FhirDate.of(lastReviewDate));
        }

        /**
         * Sets {@code effectivePeriod}.
         *
         * @param effectivePeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effectivePeriod(Period effectivePeriod) {
            this.effectivePeriod = effectivePeriod;
            return this;
        }

        /**
         * Replaces all {@code topic} values.
         *
         * @param topic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder topic(List<CodeableConcept> topic) {
            this.topic = topic == null ? new ArrayList<>() : new ArrayList<>(topic);
            return this;
        }

        /**
         * Adds a {@code topic} value.
         *
         * @param topic the value to add
         * @return this builder
         */
        public Builder addTopic(CodeableConcept topic) {
            this.topic.add(Objects.requireNonNull(topic, "topic"));
            return this;
        }

        /**
         * Replaces all {@code author} values.
         *
         * @param author the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder author(List<ContactDetail> author) {
            this.author = author == null ? new ArrayList<>() : new ArrayList<>(author);
            return this;
        }

        /**
         * Adds a {@code author} value.
         *
         * @param author the value to add
         * @return this builder
         */
        public Builder addAuthor(ContactDetail author) {
            this.author.add(Objects.requireNonNull(author, "author"));
            return this;
        }

        /**
         * Replaces all {@code editor} values.
         *
         * @param editor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder editor(List<ContactDetail> editor) {
            this.editor = editor == null ? new ArrayList<>() : new ArrayList<>(editor);
            return this;
        }

        /**
         * Adds a {@code editor} value.
         *
         * @param editor the value to add
         * @return this builder
         */
        public Builder addEditor(ContactDetail editor) {
            this.editor.add(Objects.requireNonNull(editor, "editor"));
            return this;
        }

        /**
         * Replaces all {@code reviewer} values.
         *
         * @param reviewer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reviewer(List<ContactDetail> reviewer) {
            this.reviewer = reviewer == null ? new ArrayList<>() : new ArrayList<>(reviewer);
            return this;
        }

        /**
         * Adds a {@code reviewer} value.
         *
         * @param reviewer the value to add
         * @return this builder
         */
        public Builder addReviewer(ContactDetail reviewer) {
            this.reviewer.add(Objects.requireNonNull(reviewer, "reviewer"));
            return this;
        }

        /**
         * Replaces all {@code endorser} values.
         *
         * @param endorser the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder endorser(List<ContactDetail> endorser) {
            this.endorser = endorser == null ? new ArrayList<>() : new ArrayList<>(endorser);
            return this;
        }

        /**
         * Adds a {@code endorser} value.
         *
         * @param endorser the value to add
         * @return this builder
         */
        public Builder addEndorser(ContactDetail endorser) {
            this.endorser.add(Objects.requireNonNull(endorser, "endorser"));
            return this;
        }

        /**
         * Replaces all {@code relatedArtifact} values.
         *
         * @param relatedArtifact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relatedArtifact(List<RelatedArtifact> relatedArtifact) {
            this.relatedArtifact = relatedArtifact == null ? new ArrayList<>() : new ArrayList<>(relatedArtifact);
            return this;
        }

        /**
         * Adds a {@code relatedArtifact} value.
         *
         * @param relatedArtifact the value to add
         * @return this builder
         */
        public Builder addRelatedArtifact(RelatedArtifact relatedArtifact) {
            this.relatedArtifact.add(Objects.requireNonNull(relatedArtifact, "relatedArtifact"));
            return this;
        }

        /**
         * Replaces all {@code library} values.
         *
         * @param library the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder library(List<FhirCanonical> library) {
            this.library = library == null ? new ArrayList<>() : new ArrayList<>(library);
            return this;
        }

        /**
         * Adds a {@code library} value.
         *
         * @param library the value to add
         * @return this builder
         */
        public Builder addLibrary(FhirCanonical library) {
            this.library.add(Objects.requireNonNull(library, "library"));
            return this;
        }

        /**
         * Adds a {@code library} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param library the value to add
         * @return this builder
         */
        public Builder addLibrary(String library) {
            return addLibrary(FhirCanonical.of(library));
        }

        /**
         * Replaces all {@code goal} values.
         *
         * @param goal the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder goal(List<Goal> goal) {
            this.goal = goal == null ? new ArrayList<>() : new ArrayList<>(goal);
            return this;
        }

        /**
         * Adds a {@code goal} value.
         *
         * @param goal the value to add
         * @return this builder
         */
        public Builder addGoal(Goal goal) {
            this.goal.add(Objects.requireNonNull(goal, "goal"));
            return this;
        }

        /**
         * Replaces all {@code actor} values.
         *
         * @param actor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder actor(List<Actor> actor) {
            this.actor = actor == null ? new ArrayList<>() : new ArrayList<>(actor);
            return this;
        }

        /**
         * Adds a {@code actor} value.
         *
         * @param actor the value to add
         * @return this builder
         */
        public Builder addActor(Actor actor) {
            this.actor.add(Objects.requireNonNull(actor, "actor"));
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
         * Sets {@code asNeeded} to a boolean.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(FhirBoolean asNeeded) {
            this.asNeeded = asNeeded;
            return this;
        }

        /**
         * Sets {@code asNeeded} to a CodeableConcept.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(CodeableConcept asNeeded) {
            this.asNeeded = asNeeded;
            return this;
        }

        /**
         * Sets {@code asNeeded} to a boolean without id or extensions.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(Boolean asNeeded) {
            this.asNeeded = asNeeded == null ? null : FhirBoolean.of(asNeeded);
            return this;
        }

        /**
         * Builds the {@code PlanDefinition}.
         *
         * @return the {@code PlanDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public PlanDefinition build() {
            return new PlanDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, subtitle, type, status, experimental, subject, date,
                    publisher, contact, description, useContext, jurisdiction, purpose, usage, copyright,
                    copyrightLabel, approvalDate, lastReviewDate, effectivePeriod, topic, author, editor, reviewer,
                    endorser, relatedArtifact, library, goal, actor, action, asNeeded);
        }
    }
}
