package se.poroli.fhirplace.r5.specialized.definitionalartifacts;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.ConditionPreconditionType;
import se.poroli.fhirplace.r5.valuesets.ConditionQuestionnairePurpose;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A definition of a condition and information relevant to managing it.
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
 * @param url Canonical identifier for this condition definition, represented as a URI (globally unique).
 * @param identifier Additional identifier for the condition definition.
 * @param version Business version of the condition definition.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this condition definition (computer friendly).
 * @param title Name for this condition definition (human friendly).
 * @param subtitle Subordinate title of the event definition.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the condition definition.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for condition definition (if applicable).
 * @param code Identification of the condition, problem or diagnosis. Required.
 * @param severity Subjective severity of condition.
 * @param bodySite Anatomical location, if relevant.
 * @param stage Stage/grade, usually assessed formally.
 * @param hasSeverity Whether Severity is appropriate.
 * @param hasBodySite Whether bodySite is appropriate.
 * @param hasStage Whether stage is appropriate.
 * @param definition Formal Definition for the condition.
 * @param observation Observations particularly relevant to this condition.
 * @param medication Medications particularly relevant for this condition.
 * @param precondition Observation that suggets this condition.
 * @param team Appropriate team for this condition. Reference to CareTeam.
 * @param questionnaire Questionnaire for this condition.
 * @param plan Plan that is appropriate.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ConditionDefinition">FHIR R5 ConditionDefinition</a>
 */
public record ConditionDefinition(
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
        FhirEnum<PublicationStatus> status,
        FhirBoolean experimental,
        FhirDateTime date,
        FhirString publisher,
        List<ContactDetail> contact,
        FhirMarkdown description,
        List<UsageContext> useContext,
        List<CodeableConcept> jurisdiction,
        CodeableConcept code,
        CodeableConcept severity,
        CodeableConcept bodySite,
        CodeableConcept stage,
        FhirBoolean hasSeverity,
        FhirBoolean hasBodySite,
        FhirBoolean hasStage,
        List<FhirUri> definition,
        List<Observation> observation,
        List<Medication> medication,
        List<Precondition> precondition,
        List<Reference> team,
        List<Questionnaire> questionnaire,
        List<Plan> plan) implements DomainResource {

    /**
     * Creates a {@code ConditionDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ConditionDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        definition = definition == null ? List.of() : List.copyOf(definition);
        observation = observation == null ? List.of() : List.copyOf(observation);
        medication = medication == null ? List.of() : List.copyOf(medication);
        precondition = precondition == null ? List.of() : List.copyOf(precondition);
        team = team == null ? List.of() : List.copyOf(team);
        questionnaire = questionnaire == null ? List.of() : List.copyOf(questionnaire);
        plan = plan == null ? List.of() : List.copyOf(plan);
        Objects.requireNonNull(status, "ConditionDefinition.status is required");
        Objects.requireNonNull(code, "ConditionDefinition.code is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "ConditionDefinition.versionAlgorithm[x] must be one of string, Coding, but was "
                            + versionAlgorithm.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code ConditionDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Observations particularly relevant to this condition.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param category Category that is relevant.
     * @param code Code for relevant Observation.
     */
    public record Observation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept category,
            CodeableConcept code) implements BackboneElement {

        /**
         * Creates an {@code Observation}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Observation {
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
         * Returns a builder initialized with the values of this {@code Observation}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Observation}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept category;
            private CodeableConcept code;

            private Builder() {
            }

            private Builder(Observation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.category = original.category();
                this.code = original.code();
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
             * Builds the {@code Observation}.
             *
             * @return the {@code Observation}
             */
            public Observation build() {
                return new Observation(
                        id, extension, modifierExtension, category, code);
            }
        }
    }

    /**
     * Medications particularly relevant for this condition.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param category Category that is relevant.
     * @param code Code for relevant Medication.
     */
    public record Medication(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept category,
            CodeableConcept code) implements BackboneElement {

        /**
         * Creates a {@code Medication}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Medication {
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
         * Returns a builder initialized with the values of this {@code Medication}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Medication}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept category;
            private CodeableConcept code;

            private Builder() {
            }

            private Builder(Medication original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.category = original.category();
                this.code = original.code();
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
             * Builds the {@code Medication}.
             *
             * @return the {@code Medication}
             */
            public Medication build() {
                return new Medication(
                        id, extension, modifierExtension, category, code);
            }
        }
    }

    /**
     * An observation that suggests that this condition applies.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type sensitive | specific. Required.
     * @param code Code for relevant Observation. Required.
     * @param value Value of Observation. One of CodeableConcept, Quantity.
     */
    public record Precondition(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<ConditionPreconditionType> type,
            CodeableConcept code,
            DataType value) implements BackboneElement {

        /**
         * Creates a {@code Precondition}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Precondition {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "ConditionDefinition.precondition.type is required");
            Objects.requireNonNull(code, "ConditionDefinition.precondition.code is required");
            if (value != null && !(value instanceof CodeableConcept || value instanceof Quantity)) {
                throw new IllegalArgumentException(
                        "ConditionDefinition.precondition.value[x] must be one of CodeableConcept, Quantity, but was "
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
         * Returns a builder initialized with the values of this {@code Precondition}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Precondition}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<ConditionPreconditionType> type;
            private CodeableConcept code;
            private DataType value;

            private Builder() {
            }

            private Builder(Precondition original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.code = original.code();
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
            public Builder type(FhirEnum<ConditionPreconditionType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(ConditionPreconditionType type) {
                return type(type == null ? null : FhirEnum.of(type));
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
             * Sets {@code value} to a CodeableConcept.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(CodeableConcept value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a Quantity.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Quantity value) {
                this.value = value;
                return this;
            }

            /**
             * Builds the {@code Precondition}.
             *
             * @return the {@code Precondition}
             * @throws NullPointerException if a required element is absent
             */
            public Precondition build() {
                return new Precondition(
                        id, extension, modifierExtension, type, code, value);
            }
        }
    }

    /**
     * Questionnaire for this condition.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param purpose preadmit | diff-diagnosis | outcome. Required.
     * @param reference Specific Questionnaire. Reference to Questionnaire. Required.
     */
    public record Questionnaire(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<ConditionQuestionnairePurpose> purpose,
            Reference reference) implements BackboneElement {

        /**
         * Creates a {@code Questionnaire}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Questionnaire {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(purpose, "ConditionDefinition.questionnaire.purpose is required");
            Objects.requireNonNull(reference, "ConditionDefinition.questionnaire.reference is required");
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
         * Returns a builder initialized with the values of this {@code Questionnaire}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Questionnaire}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<ConditionQuestionnairePurpose> purpose;
            private Reference reference;

            private Builder() {
            }

            private Builder(Questionnaire original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.purpose = original.purpose();
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
             * Sets {@code purpose}.
             *
             * @param purpose the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder purpose(FhirEnum<ConditionQuestionnairePurpose> purpose) {
                this.purpose = purpose;
                return this;
            }

            /**
             * Sets {@code purpose}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param purpose the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder purpose(ConditionQuestionnairePurpose purpose) {
                return purpose(purpose == null ? null : FhirEnum.of(purpose));
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
             * Builds the {@code Questionnaire}.
             *
             * @return the {@code Questionnaire}
             * @throws NullPointerException if a required element is absent
             */
            public Questionnaire build() {
                return new Questionnaire(
                        id, extension, modifierExtension, purpose, reference);
            }
        }
    }

    /**
     * Plan that is appropriate.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param role Use for the plan.
     * @param reference The actual plan. Reference to PlanDefinition. Required.
     */
    public record Plan(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept role,
            Reference reference) implements BackboneElement {

        /**
         * Creates a {@code Plan}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Plan {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(reference, "ConditionDefinition.plan.reference is required");
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
         * Returns a builder initialized with the values of this {@code Plan}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Plan}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept role;
            private Reference reference;

            private Builder() {
            }

            private Builder(Plan original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.role = original.role();
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
             * Builds the {@code Plan}.
             *
             * @return the {@code Plan}
             * @throws NullPointerException if a required element is absent
             */
            public Plan build() {
                return new Plan(
                        id, extension, modifierExtension, role, reference);
            }
        }
    }

    /** Builder for {@link ConditionDefinition}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<PublicationStatus> status;
        private FhirBoolean experimental;
        private FhirDateTime date;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private FhirMarkdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private CodeableConcept code;
        private CodeableConcept severity;
        private CodeableConcept bodySite;
        private CodeableConcept stage;
        private FhirBoolean hasSeverity;
        private FhirBoolean hasBodySite;
        private FhirBoolean hasStage;
        private List<FhirUri> definition = new ArrayList<>();
        private List<Observation> observation = new ArrayList<>();
        private List<Medication> medication = new ArrayList<>();
        private List<Precondition> precondition = new ArrayList<>();
        private List<Reference> team = new ArrayList<>();
        private List<Questionnaire> questionnaire = new ArrayList<>();
        private List<Plan> plan = new ArrayList<>();

        private Builder() {
        }

        private Builder(ConditionDefinition original) {
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
            this.status = original.status();
            this.experimental = original.experimental();
            this.date = original.date();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.description = original.description();
            this.useContext = new ArrayList<>(original.useContext());
            this.jurisdiction = new ArrayList<>(original.jurisdiction());
            this.code = original.code();
            this.severity = original.severity();
            this.bodySite = original.bodySite();
            this.stage = original.stage();
            this.hasSeverity = original.hasSeverity();
            this.hasBodySite = original.hasBodySite();
            this.hasStage = original.hasStage();
            this.definition = new ArrayList<>(original.definition());
            this.observation = new ArrayList<>(original.observation());
            this.medication = new ArrayList<>(original.medication());
            this.precondition = new ArrayList<>(original.precondition());
            this.team = new ArrayList<>(original.team());
            this.questionnaire = new ArrayList<>(original.questionnaire());
            this.plan = new ArrayList<>(original.plan());
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
        public Builder severity(CodeableConcept severity) {
            this.severity = severity;
            return this;
        }

        /**
         * Sets {@code bodySite}.
         *
         * @param bodySite the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder bodySite(CodeableConcept bodySite) {
            this.bodySite = bodySite;
            return this;
        }

        /**
         * Sets {@code stage}.
         *
         * @param stage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder stage(CodeableConcept stage) {
            this.stage = stage;
            return this;
        }

        /**
         * Sets {@code hasSeverity}.
         *
         * @param hasSeverity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder hasSeverity(FhirBoolean hasSeverity) {
            this.hasSeverity = hasSeverity;
            return this;
        }

        /**
         * Sets {@code hasSeverity}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param hasSeverity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder hasSeverity(Boolean hasSeverity) {
            return hasSeverity(hasSeverity == null ? null : FhirBoolean.of(hasSeverity));
        }

        /**
         * Sets {@code hasBodySite}.
         *
         * @param hasBodySite the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder hasBodySite(FhirBoolean hasBodySite) {
            this.hasBodySite = hasBodySite;
            return this;
        }

        /**
         * Sets {@code hasBodySite}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param hasBodySite the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder hasBodySite(Boolean hasBodySite) {
            return hasBodySite(hasBodySite == null ? null : FhirBoolean.of(hasBodySite));
        }

        /**
         * Sets {@code hasStage}.
         *
         * @param hasStage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder hasStage(FhirBoolean hasStage) {
            this.hasStage = hasStage;
            return this;
        }

        /**
         * Sets {@code hasStage}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param hasStage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder hasStage(Boolean hasStage) {
            return hasStage(hasStage == null ? null : FhirBoolean.of(hasStage));
        }

        /**
         * Replaces all {@code definition} values.
         *
         * @param definition the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder definition(List<FhirUri> definition) {
            this.definition = definition == null ? new ArrayList<>() : new ArrayList<>(definition);
            return this;
        }

        /**
         * Adds a {@code definition} value.
         *
         * @param definition the value to add
         * @return this builder
         */
        public Builder addDefinition(FhirUri definition) {
            this.definition.add(Objects.requireNonNull(definition, "definition"));
            return this;
        }

        /**
         * Adds a {@code definition} value, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param definition the value to add
         * @return this builder
         */
        public Builder addDefinition(String definition) {
            return addDefinition(FhirUri.of(definition));
        }

        /**
         * Replaces all {@code observation} values.
         *
         * @param observation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder observation(List<Observation> observation) {
            this.observation = observation == null ? new ArrayList<>() : new ArrayList<>(observation);
            return this;
        }

        /**
         * Adds a {@code observation} value.
         *
         * @param observation the value to add
         * @return this builder
         */
        public Builder addObservation(Observation observation) {
            this.observation.add(Objects.requireNonNull(observation, "observation"));
            return this;
        }

        /**
         * Replaces all {@code medication} values.
         *
         * @param medication the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder medication(List<Medication> medication) {
            this.medication = medication == null ? new ArrayList<>() : new ArrayList<>(medication);
            return this;
        }

        /**
         * Adds a {@code medication} value.
         *
         * @param medication the value to add
         * @return this builder
         */
        public Builder addMedication(Medication medication) {
            this.medication.add(Objects.requireNonNull(medication, "medication"));
            return this;
        }

        /**
         * Replaces all {@code precondition} values.
         *
         * @param precondition the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder precondition(List<Precondition> precondition) {
            this.precondition = precondition == null ? new ArrayList<>() : new ArrayList<>(precondition);
            return this;
        }

        /**
         * Adds a {@code precondition} value.
         *
         * @param precondition the value to add
         * @return this builder
         */
        public Builder addPrecondition(Precondition precondition) {
            this.precondition.add(Objects.requireNonNull(precondition, "precondition"));
            return this;
        }

        /**
         * Replaces all {@code team} values.
         *
         * @param team the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder team(List<Reference> team) {
            this.team = team == null ? new ArrayList<>() : new ArrayList<>(team);
            return this;
        }

        /**
         * Adds a {@code team} value.
         *
         * @param team the value to add
         * @return this builder
         */
        public Builder addTeam(Reference team) {
            this.team.add(Objects.requireNonNull(team, "team"));
            return this;
        }

        /**
         * Replaces all {@code questionnaire} values.
         *
         * @param questionnaire the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder questionnaire(List<Questionnaire> questionnaire) {
            this.questionnaire = questionnaire == null ? new ArrayList<>() : new ArrayList<>(questionnaire);
            return this;
        }

        /**
         * Adds a {@code questionnaire} value.
         *
         * @param questionnaire the value to add
         * @return this builder
         */
        public Builder addQuestionnaire(Questionnaire questionnaire) {
            this.questionnaire.add(Objects.requireNonNull(questionnaire, "questionnaire"));
            return this;
        }

        /**
         * Replaces all {@code plan} values.
         *
         * @param plan the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder plan(List<Plan> plan) {
            this.plan = plan == null ? new ArrayList<>() : new ArrayList<>(plan);
            return this;
        }

        /**
         * Adds a {@code plan} value.
         *
         * @param plan the value to add
         * @return this builder
         */
        public Builder addPlan(Plan plan) {
            this.plan.add(Objects.requireNonNull(plan, "plan"));
            return this;
        }

        /**
         * Builds the {@code ConditionDefinition}.
         *
         * @return the {@code ConditionDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public ConditionDefinition build() {
            return new ConditionDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, subtitle, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, code, severity, bodySite, stage, hasSeverity, hasBodySite,
                    hasStage, definition, observation, medication, precondition, team, questionnaire, plan);
        }
    }
}
