package se.poroli.fhirplace.r5.clinical.diagnostics;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Availability;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
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
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
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
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.RatioRange;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.SampledData;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.datatypes.TriggerDefinition;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.valuesets.QuestionnaireResponseStatus;

/**
 * A structured set of questions and their answers.
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
 * @param identifier Business identifier for this set of answers.
 * @param basedOn Request fulfilled by this QuestionnaireResponse. Reference to CarePlan, ServiceRequest.
 * @param partOf Part of referenced event. Reference to Observation, Procedure.
 * @param questionnaire Canonical URL of Questionnaire being answered. Canonical reference to Questionnaire. Required.
 * @param status in-progress | completed | amended | entered-in-error | stopped. Required. Modifier element.
 * @param subject The subject of the questions. Reference to Resource.
 * @param encounter Encounter the questionnaire response is part of. Reference to Encounter.
 * @param authored Date the answers were gathered.
 * @param author The individual or device that received and recorded the answers. Reference to Device, Practitioner,
 *   PractitionerRole, Patient, RelatedPerson, Organization.
 * @param source The individual or device that answered the questions. Reference to Device, Organization, Patient,
 *   Practitioner, PractitionerRole, RelatedPerson.
 * @param item Groups and questions.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse">FHIR R5 QuestionnaireResponse</a>
 */
public record QuestionnaireResponse(
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
        List<Reference> partOf,
        FhirCanonical questionnaire,
        FhirEnum<QuestionnaireResponseStatus> status,
        Reference subject,
        Reference encounter,
        FhirDateTime authored,
        Reference author,
        Reference source,
        List<Item> item) implements DomainResource {

    /**
     * Creates a {@code QuestionnaireResponse}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public QuestionnaireResponse {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        item = item == null ? List.of() : List.copyOf(item);
        Objects.requireNonNull(questionnaire, "QuestionnaireResponse.questionnaire is required");
        Objects.requireNonNull(status, "QuestionnaireResponse.status is required");
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
     * Returns a builder initialized with the values of this {@code QuestionnaireResponse}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A group or question item from the original questionnaire for which answers are provided.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param linkId Pointer to specific item from Questionnaire. Required.
     * @param definition ElementDefinition - details for the item.
     * @param text Name for group or question text.
     * @param answer The response(s) to the question.
     * @param item Child items of group item.
     */
    public record Item(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString linkId,
            FhirUri definition,
            FhirString text,
            List<Answer> answer,
            List<QuestionnaireResponse.Item> item) implements BackboneElement {

        /**
         * Creates an {@code Item}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Item {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            answer = answer == null ? List.of() : List.copyOf(answer);
            item = item == null ? List.of() : List.copyOf(item);
            Objects.requireNonNull(linkId, "QuestionnaireResponse.item.linkId is required");
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
         * Returns a builder initialized with the values of this {@code Item}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The respondent's answer(s) to the question.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param value Single-valued answer to the question. Any datatype except FhirInteger64, FhirPositiveInt,
         *   FhirUnsignedInt, FhirMarkdown, FhirCode, FhirId, FhirUrl, FhirCanonical, FhirOid, FhirUuid,
         *   FhirBase64Binary, FhirInstant, FhirEnum, Identifier, HumanName, Address, ContactPoint, Timing, Range,
         *   Period, Ratio, RatioRange, CodeableConcept, SampledData, Age, Distance, Duration, Count, Money,
         *   Annotation, Signature, ContactDetail, Contributor, DataRequirement, ParameterDefinition, RelatedArtifact,
         *   TriggerDefinition, UsageContext, Expression, ExtendedContactDetail, VirtualServiceDetail, Availability,
         *   MonetaryComponent, CodeableReference, Narrative, Extension, Meta, Dosage, ElementDefinition,
         *   ProductShelfLife, MarketingStatus. Required.
         * @param item Child items of question.
         */
        public record Answer(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                DataType value,
                List<QuestionnaireResponse.Item> item) implements BackboneElement {

            /**
             * Creates an {@code Answer}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Answer {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                item = item == null ? List.of() : List.copyOf(item);
                Objects.requireNonNull(value, "QuestionnaireResponse.item.answer.value is required");
                if (value != null && (value instanceof FhirInteger64
                        || value instanceof FhirPositiveInt
                        || value instanceof FhirUnsignedInt
                        || value instanceof FhirMarkdown
                        || value instanceof FhirCode
                        || value instanceof FhirId
                        || value instanceof FhirUrl
                        || value instanceof FhirCanonical
                        || value instanceof FhirOid
                        || value instanceof FhirUuid
                        || value instanceof FhirBase64Binary
                        || value instanceof FhirInstant
                        || value instanceof FhirEnum<?>
                        || value instanceof Identifier
                        || value instanceof HumanName
                        || value instanceof Address
                        || value instanceof ContactPoint
                        || value instanceof Timing
                        || value instanceof Range
                        || value instanceof Period
                        || value instanceof Ratio
                        || value instanceof RatioRange
                        || value instanceof CodeableConcept
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
                        || value instanceof CodeableReference
                        || value instanceof Narrative
                        || value instanceof Extension
                        || value instanceof Meta
                        || value instanceof Dosage
                        || value instanceof ElementDefinition
                        || value instanceof ProductShelfLife
                        || value instanceof MarketingStatus)) {
                    throw new IllegalArgumentException(
                            "QuestionnaireResponse.item.answer.value[x] does not allow "
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
             * Returns a builder initialized with the values of this {@code Answer}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Answer}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private DataType value;
                private List<QuestionnaireResponse.Item> item = new ArrayList<>();

                private Builder() {
                }

                private Builder(Answer original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.value = original.value();
                    this.item = new ArrayList<>(original.item());
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
                 * Replaces all {@code item} values.
                 *
                 * @param item the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder item(List<QuestionnaireResponse.Item> item) {
                    this.item = item == null ? new ArrayList<>() : new ArrayList<>(item);
                    return this;
                }

                /**
                 * Adds a {@code item} value.
                 *
                 * @param item the value to add
                 * @return this builder
                 */
                public Builder addItem(QuestionnaireResponse.Item item) {
                    this.item.add(Objects.requireNonNull(item, "item"));
                    return this;
                }

                /**
                 * Builds the {@code Answer}.
                 *
                 * @return the {@code Answer}
                 * @throws NullPointerException if a required element is absent
                 */
                public Answer build() {
                    return new Answer(
                            id, extension, modifierExtension, value, item);
                }
            }
        }

        /** Builder for {@link Item}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString linkId;
            private FhirUri definition;
            private FhirString text;
            private List<Answer> answer = new ArrayList<>();
            private List<QuestionnaireResponse.Item> item = new ArrayList<>();

            private Builder() {
            }

            private Builder(Item original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.linkId = original.linkId();
                this.definition = original.definition();
                this.text = original.text();
                this.answer = new ArrayList<>(original.answer());
                this.item = new ArrayList<>(original.item());
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
             * Sets {@code definition}.
             *
             * @param definition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definition(FhirUri definition) {
                this.definition = definition;
                return this;
            }

            /**
             * Sets {@code definition}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param definition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definition(String definition) {
                return definition(definition == null ? null : FhirUri.of(definition));
            }

            /**
             * Sets {@code text}.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(FhirString text) {
                this.text = text;
                return this;
            }

            /**
             * Sets {@code text}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(String text) {
                return text(text == null ? null : FhirString.of(text));
            }

            /**
             * Replaces all {@code answer} values.
             *
             * @param answer the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder answer(List<Answer> answer) {
                this.answer = answer == null ? new ArrayList<>() : new ArrayList<>(answer);
                return this;
            }

            /**
             * Adds a {@code answer} value.
             *
             * @param answer the value to add
             * @return this builder
             */
            public Builder addAnswer(Answer answer) {
                this.answer.add(Objects.requireNonNull(answer, "answer"));
                return this;
            }

            /**
             * Replaces all {@code item} values.
             *
             * @param item the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder item(List<QuestionnaireResponse.Item> item) {
                this.item = item == null ? new ArrayList<>() : new ArrayList<>(item);
                return this;
            }

            /**
             * Adds a {@code item} value.
             *
             * @param item the value to add
             * @return this builder
             */
            public Builder addItem(QuestionnaireResponse.Item item) {
                this.item.add(Objects.requireNonNull(item, "item"));
                return this;
            }

            /**
             * Builds the {@code Item}.
             *
             * @return the {@code Item}
             * @throws NullPointerException if a required element is absent
             */
            public Item build() {
                return new Item(
                        id, extension, modifierExtension, linkId, definition, text, answer, item);
            }
        }
    }

    /** Builder for {@link QuestionnaireResponse}. Builders are mutable and not thread-safe. */
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
        private List<Reference> partOf = new ArrayList<>();
        private FhirCanonical questionnaire;
        private FhirEnum<QuestionnaireResponseStatus> status;
        private Reference subject;
        private Reference encounter;
        private FhirDateTime authored;
        private Reference author;
        private Reference source;
        private List<Item> item = new ArrayList<>();

        private Builder() {
        }

        private Builder(QuestionnaireResponse original) {
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
            this.partOf = new ArrayList<>(original.partOf());
            this.questionnaire = original.questionnaire();
            this.status = original.status();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.authored = original.authored();
            this.author = original.author();
            this.source = original.source();
            this.item = new ArrayList<>(original.item());
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
         * Sets {@code questionnaire}.
         *
         * @param questionnaire the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder questionnaire(FhirCanonical questionnaire) {
            this.questionnaire = questionnaire;
            return this;
        }

        /**
         * Sets {@code questionnaire}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param questionnaire the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder questionnaire(String questionnaire) {
            return questionnaire(questionnaire == null ? null : FhirCanonical.of(questionnaire));
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<QuestionnaireResponseStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(QuestionnaireResponseStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Sets {@code authored}.
         *
         * @param authored the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authored(FhirDateTime authored) {
            this.authored = authored;
            return this;
        }

        /**
         * Sets {@code authored}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param authored the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authored(Temporal authored) {
            return authored(authored == null ? null : FhirDateTime.of(authored));
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
         * Sets {@code source}.
         *
         * @param source the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder source(Reference source) {
            this.source = source;
            return this;
        }

        /**
         * Replaces all {@code item} values.
         *
         * @param item the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder item(List<Item> item) {
            this.item = item == null ? new ArrayList<>() : new ArrayList<>(item);
            return this;
        }

        /**
         * Adds a {@code item} value.
         *
         * @param item the value to add
         * @return this builder
         */
        public Builder addItem(Item item) {
            this.item.add(Objects.requireNonNull(item, "item"));
            return this;
        }

        /**
         * Builds the {@code QuestionnaireResponse}.
         *
         * @return the {@code QuestionnaireResponse}
         * @throws NullPointerException if a required element is absent
         */
        public QuestionnaireResponse build() {
            return new QuestionnaireResponse(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    basedOn, partOf, questionnaire, status, subject, encounter, authored, author, source, item);
        }
    }
}
