package se.poroli.fhirplace.r5.questionnaire;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.math.BigDecimal;
import java.time.LocalTime;
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
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirOid;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirTime;
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
import se.poroli.fhirplace.r5.datatypes.Quantity;
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
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.ResourceType;

/**
 * A structured set of questions intended to guide the collection of answers from end-users.
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
 * @param url Canonical identifier for this questionnaire, represented as an absolute URI (globally unique).
 * @param identifier Business identifier for questionnaire.
 * @param version Business version of the questionnaire.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this questionnaire (computer friendly).
 * @param title Name for this questionnaire (human friendly).
 * @param derivedFrom Based on Questionnaire. Canonical reference to Questionnaire.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param subjectType Resource that can be subject of QuestionnaireResponse.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the questionnaire.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for questionnaire (if applicable).
 * @param purpose Why this questionnaire is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param approvalDate When the questionnaire was approved by publisher.
 * @param lastReviewDate When the questionnaire was last reviewed by the publisher.
 * @param effectivePeriod When the questionnaire is expected to be used.
 * @param code Concept that represents the overall questionnaire.
 * @param item Questions and sections within the Questionnaire.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Questionnaire">FHIR R5 Questionnaire</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Questionnaire(
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
        List<FhirCanonical> derivedFrom,
        FhirEnum<PublicationStatus> status,
        FhirBoolean experimental,
        List<FhirEnum<ResourceType>> subjectType,
        FhirDateTime date,
        FhirString publisher,
        List<ContactDetail> contact,
        FhirMarkdown description,
        List<UsageContext> useContext,
        List<CodeableConcept> jurisdiction,
        FhirMarkdown purpose,
        FhirMarkdown copyright,
        FhirString copyrightLabel,
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        Period effectivePeriod,
        List<Coding> code,
        List<Item> item) implements DomainResource {

    /**
     * Creates a {@code Questionnaire}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Questionnaire {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        derivedFrom = derivedFrom == null ? List.of() : List.copyOf(derivedFrom);
        subjectType = subjectType == null ? List.of() : List.copyOf(subjectType);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        code = code == null ? List.of() : List.copyOf(code);
        item = item == null ? List.of() : List.copyOf(item);
        Objects.requireNonNull(status, "Questionnaire.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "Questionnaire.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code Questionnaire}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A particular question, question grouping or display text that is part of the questionnaire.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param linkId Unique id for item in questionnaire. Required.
     * @param definition ElementDefinition - details for the item.
     * @param code Corresponding concept for this item in a terminology.
     * @param prefix E.g. "1(a)", "2.5.3".
     * @param text Primary text for the item.
     * @param type group | display | boolean | decimal | integer | date | dateTime +. Required.
     * @param enableWhen Only allow data when. Modifier element.
     * @param enableBehavior all | any.
     * @param disabledDisplay hidden | protected.
     * @param required Whether the item must be included in data results.
     * @param repeats Whether the item may repeat.
     * @param readOnly Don't allow human editing.
     * @param maxLength No more than these many characters.
     * @param answerConstraint optionsOnly | optionsOrType | optionsOrString.
     * @param answerValueSet ValueSet containing permitted answers. Canonical reference to ValueSet.
     * @param answerOption Permitted answer.
     * @param initial Initial value(s) when item is first rendered.
     * @param item Nested questionnaire items.
     */
    public record Item(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString linkId,
            FhirUri definition,
            List<Coding> code,
            FhirString prefix,
            FhirString text,
            FhirEnum<QuestionnaireItemType> type,
            List<EnableWhen> enableWhen,
            FhirEnum<EnableWhenBehavior> enableBehavior,
            FhirEnum<QuestionnaireItemDisabledDisplay> disabledDisplay,
            FhirBoolean required,
            FhirBoolean repeats,
            FhirBoolean readOnly,
            FhirInteger maxLength,
            FhirEnum<QuestionnaireAnswerConstraint> answerConstraint,
            FhirCanonical answerValueSet,
            List<AnswerOption> answerOption,
            List<Initial> initial,
            List<Questionnaire.Item> item) implements BackboneElement {

        /**
         * Creates an {@code Item}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Item {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            code = code == null ? List.of() : List.copyOf(code);
            enableWhen = enableWhen == null ? List.of() : List.copyOf(enableWhen);
            answerOption = answerOption == null ? List.of() : List.copyOf(answerOption);
            initial = initial == null ? List.of() : List.copyOf(initial);
            item = item == null ? List.of() : List.copyOf(item);
            Objects.requireNonNull(linkId, "Questionnaire.item.linkId is required");
            Objects.requireNonNull(type, "Questionnaire.item.type is required");
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
         * A constraint indicating that this item should only be enabled (displayed/allow answers to be captured) when
         * the specified condition is true.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param question The linkId of question that determines whether item is enabled/disabled. Required.
         * @param operator exists | = | != | &gt; | &lt; | &gt;= | &lt;=. Required.
         * @param answer Value for question comparison based on operator. One of boolean, decimal, integer, date,
         *   dateTime, time, string, Coding, Quantity, Reference. Required.
         */
        public record EnableWhen(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString question,
                FhirEnum<QuestionnaireItemOperator> operator,
                DataType answer) implements BackboneElement {

            /**
             * Creates an {@code EnableWhen}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public EnableWhen {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(question, "Questionnaire.item.enableWhen.question is required");
                Objects.requireNonNull(operator, "Questionnaire.item.enableWhen.operator is required");
                Objects.requireNonNull(answer, "Questionnaire.item.enableWhen.answer is required");
                if (answer != null && !(answer instanceof FhirBoolean
                        || answer instanceof FhirDecimal
                        || answer instanceof FhirInteger
                        || answer instanceof FhirDate
                        || answer instanceof FhirDateTime
                        || answer instanceof FhirTime
                        || answer instanceof FhirString
                        || answer instanceof Coding
                        || answer instanceof Quantity
                        || answer instanceof Reference)) {
                    throw new IllegalArgumentException(
                            "Questionnaire.item.enableWhen.answer[x] does not allow "
                                    + answer.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code EnableWhen}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link EnableWhen}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString question;
                private FhirEnum<QuestionnaireItemOperator> operator;
                private DataType answer;

                private Builder() {
                }

                private Builder(EnableWhen original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.question = original.question();
                    this.operator = original.operator();
                    this.answer = original.answer();
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
                 * Sets {@code question}.
                 *
                 * @param question the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder question(FhirString question) {
                    this.question = question;
                    return this;
                }

                /**
                 * Sets {@code question}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param question the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder question(String question) {
                    return question(question == null ? null : FhirString.of(question));
                }

                /**
                 * Sets {@code operator}.
                 *
                 * @param operator the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder operator(FhirEnum<QuestionnaireItemOperator> operator) {
                    this.operator = operator;
                    return this;
                }

                /**
                 * Sets {@code operator}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param operator the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder operator(QuestionnaireItemOperator operator) {
                    return operator(operator == null ? null : FhirEnum.of(operator));
                }

                /**
                 * Sets {@code answer} to a boolean.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(FhirBoolean answer) {
                    this.answer = answer;
                    return this;
                }

                /**
                 * Sets {@code answer} to a decimal.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(FhirDecimal answer) {
                    this.answer = answer;
                    return this;
                }

                /**
                 * Sets {@code answer} to a integer.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(FhirInteger answer) {
                    this.answer = answer;
                    return this;
                }

                /**
                 * Sets {@code answer} to a date.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(FhirDate answer) {
                    this.answer = answer;
                    return this;
                }

                /**
                 * Sets {@code answer} to a dateTime.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(FhirDateTime answer) {
                    this.answer = answer;
                    return this;
                }

                /**
                 * Sets {@code answer} to a time.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(FhirTime answer) {
                    this.answer = answer;
                    return this;
                }

                /**
                 * Sets {@code answer} to a string.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(FhirString answer) {
                    this.answer = answer;
                    return this;
                }

                /**
                 * Sets {@code answer} to a Coding.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(Coding answer) {
                    this.answer = answer;
                    return this;
                }

                /**
                 * Sets {@code answer} to a Quantity.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(Quantity answer) {
                    this.answer = answer;
                    return this;
                }

                /**
                 * Sets {@code answer} to a Reference.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(Reference answer) {
                    this.answer = answer;
                    return this;
                }

                /**
                 * Sets {@code answer} to a boolean without id or extensions.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(Boolean answer) {
                    this.answer = answer == null ? null : FhirBoolean.of(answer);
                    return this;
                }

                /**
                 * Sets {@code answer} to a decimal without id or extensions.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(BigDecimal answer) {
                    this.answer = answer == null ? null : FhirDecimal.of(answer);
                    return this;
                }

                /**
                 * Sets {@code answer} to a integer without id or extensions.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(Integer answer) {
                    this.answer = answer == null ? null : FhirInteger.of(answer);
                    return this;
                }

                /**
                 * Sets {@code answer} to a time without id or extensions.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(LocalTime answer) {
                    this.answer = answer == null ? null : FhirTime.of(answer);
                    return this;
                }

                /**
                 * Sets {@code answer} to a string without id or extensions.
                 *
                 * @param answer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder answer(String answer) {
                    this.answer = answer == null ? null : FhirString.of(answer);
                    return this;
                }

                /**
                 * Builds the {@code EnableWhen}.
                 *
                 * @return the {@code EnableWhen}
                 * @throws NullPointerException if a required element is absent
                 */
                public EnableWhen build() {
                    return new EnableWhen(
                            id, extension, modifierExtension, question, operator, answer);
                }
            }
        }

        /**
         * One of the permitted answers for the question.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param value Answer value. One of integer, date, time, string, Coding, Reference. Required.
         * @param initialSelected Whether option is selected by default.
         */
        public record AnswerOption(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                DataType value,
                FhirBoolean initialSelected) implements BackboneElement {

            /**
             * Creates an {@code AnswerOption}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public AnswerOption {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(value, "Questionnaire.item.answerOption.value is required");
                if (value != null && !(value instanceof FhirInteger
                        || value instanceof FhirDate
                        || value instanceof FhirTime
                        || value instanceof FhirString
                        || value instanceof Coding
                        || value instanceof Reference)) {
                    throw new IllegalArgumentException(
                            "Questionnaire.item.answerOption.value[x] does not allow "
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
             * Returns a builder initialized with the values of this {@code AnswerOption}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link AnswerOption}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private DataType value;
                private FhirBoolean initialSelected;

                private Builder() {
                }

                private Builder(AnswerOption original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.value = original.value();
                    this.initialSelected = original.initialSelected();
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
                 * Sets {@code value} to a integer.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirInteger value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a date.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirDate value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a time.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirTime value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a string.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirString value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a Coding.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Coding value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a Reference.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Reference value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a integer without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Integer value) {
                    this.value = value == null ? null : FhirInteger.of(value);
                    return this;
                }

                /**
                 * Sets {@code value} to a date without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Temporal value) {
                    this.value = value == null ? null : FhirDate.of(value);
                    return this;
                }

                /**
                 * Sets {@code value} to a time without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(LocalTime value) {
                    this.value = value == null ? null : FhirTime.of(value);
                    return this;
                }

                /**
                 * Sets {@code value} to a string without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(String value) {
                    this.value = value == null ? null : FhirString.of(value);
                    return this;
                }

                /**
                 * Sets {@code initialSelected}.
                 *
                 * @param initialSelected the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder initialSelected(FhirBoolean initialSelected) {
                    this.initialSelected = initialSelected;
                    return this;
                }

                /**
                 * Sets {@code initialSelected}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param initialSelected the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder initialSelected(Boolean initialSelected) {
                    return initialSelected(initialSelected == null ? null : FhirBoolean.of(initialSelected));
                }

                /**
                 * Builds the {@code AnswerOption}.
                 *
                 * @return the {@code AnswerOption}
                 * @throws NullPointerException if a required element is absent
                 */
                public AnswerOption build() {
                    return new AnswerOption(
                            id, extension, modifierExtension, value, initialSelected);
                }
            }
        }

        /**
         * One or more values that should be pre-populated in the answer when initially rendering the questionnaire
         * for user input.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param value Actual value for initializing the question. Any datatype except FhirInteger64,
         *   FhirPositiveInt, FhirUnsignedInt, FhirMarkdown, FhirCode, FhirId, FhirUrl, FhirCanonical, FhirOid,
         *   FhirUuid, FhirBase64Binary, FhirInstant, FhirEnum, Identifier, HumanName, Address, ContactPoint, Timing,
         *   Range, Period, Ratio, RatioRange, CodeableConcept, SampledData, Age, Distance, Duration, Count, Money,
         *   Annotation, Signature, ContactDetail, Contributor, DataRequirement, ParameterDefinition, RelatedArtifact,
         *   TriggerDefinition, UsageContext, Expression, ExtendedContactDetail, VirtualServiceDetail, Availability,
         *   MonetaryComponent, CodeableReference, Narrative, Extension, Meta, Dosage, ElementDefinition,
         *   ProductShelfLife, MarketingStatus. Required.
         */
        public record Initial(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                DataType value) implements BackboneElement {

            /**
             * Creates an {@code Initial}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Initial {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(value, "Questionnaire.item.initial.value is required");
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
                            "Questionnaire.item.initial.value[x] does not allow "
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
             * Returns a builder initialized with the values of this {@code Initial}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Initial}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private DataType value;

                private Builder() {
                }

                private Builder(Initial original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
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
                 * Builds the {@code Initial}.
                 *
                 * @return the {@code Initial}
                 * @throws NullPointerException if a required element is absent
                 */
                public Initial build() {
                    return new Initial(
                            id, extension, modifierExtension, value);
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
            private List<Coding> code = new ArrayList<>();
            private FhirString prefix;
            private FhirString text;
            private FhirEnum<QuestionnaireItemType> type;
            private List<EnableWhen> enableWhen = new ArrayList<>();
            private FhirEnum<EnableWhenBehavior> enableBehavior;
            private FhirEnum<QuestionnaireItemDisabledDisplay> disabledDisplay;
            private FhirBoolean required;
            private FhirBoolean repeats;
            private FhirBoolean readOnly;
            private FhirInteger maxLength;
            private FhirEnum<QuestionnaireAnswerConstraint> answerConstraint;
            private FhirCanonical answerValueSet;
            private List<AnswerOption> answerOption = new ArrayList<>();
            private List<Initial> initial = new ArrayList<>();
            private List<Questionnaire.Item> item = new ArrayList<>();

            private Builder() {
            }

            private Builder(Item original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.linkId = original.linkId();
                this.definition = original.definition();
                this.code = new ArrayList<>(original.code());
                this.prefix = original.prefix();
                this.text = original.text();
                this.type = original.type();
                this.enableWhen = new ArrayList<>(original.enableWhen());
                this.enableBehavior = original.enableBehavior();
                this.disabledDisplay = original.disabledDisplay();
                this.required = original.required();
                this.repeats = original.repeats();
                this.readOnly = original.readOnly();
                this.maxLength = original.maxLength();
                this.answerConstraint = original.answerConstraint();
                this.answerValueSet = original.answerValueSet();
                this.answerOption = new ArrayList<>(original.answerOption());
                this.initial = new ArrayList<>(original.initial());
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
             * Replaces all {@code code} values.
             *
             * @param code the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder code(List<Coding> code) {
                this.code = code == null ? new ArrayList<>() : new ArrayList<>(code);
                return this;
            }

            /**
             * Adds a {@code code} value.
             *
             * @param code the value to add
             * @return this builder
             */
            public Builder addCode(Coding code) {
                this.code.add(Objects.requireNonNull(code, "code"));
                return this;
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
             * Sets {@code type}.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(FhirEnum<QuestionnaireItemType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(QuestionnaireItemType type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Replaces all {@code enableWhen} values.
             *
             * @param enableWhen the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder enableWhen(List<EnableWhen> enableWhen) {
                this.enableWhen = enableWhen == null ? new ArrayList<>() : new ArrayList<>(enableWhen);
                return this;
            }

            /**
             * Adds a {@code enableWhen} value.
             *
             * @param enableWhen the value to add
             * @return this builder
             */
            public Builder addEnableWhen(EnableWhen enableWhen) {
                this.enableWhen.add(Objects.requireNonNull(enableWhen, "enableWhen"));
                return this;
            }

            /**
             * Sets {@code enableBehavior}.
             *
             * @param enableBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder enableBehavior(FhirEnum<EnableWhenBehavior> enableBehavior) {
                this.enableBehavior = enableBehavior;
                return this;
            }

            /**
             * Sets {@code enableBehavior}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param enableBehavior the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder enableBehavior(EnableWhenBehavior enableBehavior) {
                return enableBehavior(enableBehavior == null ? null : FhirEnum.of(enableBehavior));
            }

            /**
             * Sets {@code disabledDisplay}.
             *
             * @param disabledDisplay the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder disabledDisplay(FhirEnum<QuestionnaireItemDisabledDisplay> disabledDisplay) {
                this.disabledDisplay = disabledDisplay;
                return this;
            }

            /**
             * Sets {@code disabledDisplay}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param disabledDisplay the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder disabledDisplay(QuestionnaireItemDisabledDisplay disabledDisplay) {
                return disabledDisplay(disabledDisplay == null ? null : FhirEnum.of(disabledDisplay));
            }

            /**
             * Sets {@code required}.
             *
             * @param required the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder required(FhirBoolean required) {
                this.required = required;
                return this;
            }

            /**
             * Sets {@code required}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param required the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder required(Boolean required) {
                return required(required == null ? null : FhirBoolean.of(required));
            }

            /**
             * Sets {@code repeats}.
             *
             * @param repeats the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder repeats(FhirBoolean repeats) {
                this.repeats = repeats;
                return this;
            }

            /**
             * Sets {@code repeats}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param repeats the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder repeats(Boolean repeats) {
                return repeats(repeats == null ? null : FhirBoolean.of(repeats));
            }

            /**
             * Sets {@code readOnly}.
             *
             * @param readOnly the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder readOnly(FhirBoolean readOnly) {
                this.readOnly = readOnly;
                return this;
            }

            /**
             * Sets {@code readOnly}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param readOnly the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder readOnly(Boolean readOnly) {
                return readOnly(readOnly == null ? null : FhirBoolean.of(readOnly));
            }

            /**
             * Sets {@code maxLength}.
             *
             * @param maxLength the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder maxLength(FhirInteger maxLength) {
                this.maxLength = maxLength;
                return this;
            }

            /**
             * Sets {@code maxLength}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param maxLength the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder maxLength(Integer maxLength) {
                return maxLength(maxLength == null ? null : FhirInteger.of(maxLength));
            }

            /**
             * Sets {@code answerConstraint}.
             *
             * @param answerConstraint the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder answerConstraint(FhirEnum<QuestionnaireAnswerConstraint> answerConstraint) {
                this.answerConstraint = answerConstraint;
                return this;
            }

            /**
             * Sets {@code answerConstraint}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param answerConstraint the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder answerConstraint(QuestionnaireAnswerConstraint answerConstraint) {
                return answerConstraint(answerConstraint == null ? null : FhirEnum.of(answerConstraint));
            }

            /**
             * Sets {@code answerValueSet}.
             *
             * @param answerValueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder answerValueSet(FhirCanonical answerValueSet) {
                this.answerValueSet = answerValueSet;
                return this;
            }

            /**
             * Sets {@code answerValueSet}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param answerValueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder answerValueSet(String answerValueSet) {
                return answerValueSet(answerValueSet == null ? null : FhirCanonical.of(answerValueSet));
            }

            /**
             * Replaces all {@code answerOption} values.
             *
             * @param answerOption the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder answerOption(List<AnswerOption> answerOption) {
                this.answerOption = answerOption == null ? new ArrayList<>() : new ArrayList<>(answerOption);
                return this;
            }

            /**
             * Adds a {@code answerOption} value.
             *
             * @param answerOption the value to add
             * @return this builder
             */
            public Builder addAnswerOption(AnswerOption answerOption) {
                this.answerOption.add(Objects.requireNonNull(answerOption, "answerOption"));
                return this;
            }

            /**
             * Replaces all {@code initial} values.
             *
             * @param initial the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder initial(List<Initial> initial) {
                this.initial = initial == null ? new ArrayList<>() : new ArrayList<>(initial);
                return this;
            }

            /**
             * Adds a {@code initial} value.
             *
             * @param initial the value to add
             * @return this builder
             */
            public Builder addInitial(Initial initial) {
                this.initial.add(Objects.requireNonNull(initial, "initial"));
                return this;
            }

            /**
             * Replaces all {@code item} values.
             *
             * @param item the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder item(List<Questionnaire.Item> item) {
                this.item = item == null ? new ArrayList<>() : new ArrayList<>(item);
                return this;
            }

            /**
             * Adds a {@code item} value.
             *
             * @param item the value to add
             * @return this builder
             */
            public Builder addItem(Questionnaire.Item item) {
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
                        id, extension, modifierExtension, linkId, definition, code, prefix, text, type, enableWhen,
                        enableBehavior, disabledDisplay, required, repeats, readOnly, maxLength, answerConstraint,
                        answerValueSet, answerOption, initial, item);
            }
        }
    }

    /** Builder for {@link Questionnaire}. Builders are mutable and not thread-safe. */
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
        private List<FhirCanonical> derivedFrom = new ArrayList<>();
        private FhirEnum<PublicationStatus> status;
        private FhirBoolean experimental;
        private List<FhirEnum<ResourceType>> subjectType = new ArrayList<>();
        private FhirDateTime date;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private FhirMarkdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private FhirMarkdown purpose;
        private FhirMarkdown copyright;
        private FhirString copyrightLabel;
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private Period effectivePeriod;
        private List<Coding> code = new ArrayList<>();
        private List<Item> item = new ArrayList<>();

        private Builder() {
        }

        private Builder(Questionnaire original) {
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
            this.derivedFrom = new ArrayList<>(original.derivedFrom());
            this.status = original.status();
            this.experimental = original.experimental();
            this.subjectType = new ArrayList<>(original.subjectType());
            this.date = original.date();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.description = original.description();
            this.useContext = new ArrayList<>(original.useContext());
            this.jurisdiction = new ArrayList<>(original.jurisdiction());
            this.purpose = original.purpose();
            this.copyright = original.copyright();
            this.copyrightLabel = original.copyrightLabel();
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.effectivePeriod = original.effectivePeriod();
            this.code = new ArrayList<>(original.code());
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
         * Replaces all {@code derivedFrom} values.
         *
         * @param derivedFrom the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder derivedFrom(List<FhirCanonical> derivedFrom) {
            this.derivedFrom = derivedFrom == null ? new ArrayList<>() : new ArrayList<>(derivedFrom);
            return this;
        }

        /**
         * Adds a {@code derivedFrom} value.
         *
         * @param derivedFrom the value to add
         * @return this builder
         */
        public Builder addDerivedFrom(FhirCanonical derivedFrom) {
            this.derivedFrom.add(Objects.requireNonNull(derivedFrom, "derivedFrom"));
            return this;
        }

        /**
         * Adds a {@code derivedFrom} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param derivedFrom the value to add
         * @return this builder
         */
        public Builder addDerivedFrom(String derivedFrom) {
            return addDerivedFrom(FhirCanonical.of(derivedFrom));
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
         * Replaces all {@code subjectType} values.
         *
         * @param subjectType the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder subjectType(List<FhirEnum<ResourceType>> subjectType) {
            this.subjectType = subjectType == null ? new ArrayList<>() : new ArrayList<>(subjectType);
            return this;
        }

        /**
         * Adds a {@code subjectType} value.
         *
         * @param subjectType the value to add
         * @return this builder
         */
        public Builder addSubjectType(FhirEnum<ResourceType> subjectType) {
            this.subjectType.add(Objects.requireNonNull(subjectType, "subjectType"));
            return this;
        }

        /**
         * Adds a {@code subjectType} value, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param subjectType the value to add
         * @return this builder
         */
        public Builder addSubjectType(ResourceType subjectType) {
            return addSubjectType(FhirEnum.of(subjectType));
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
         * Replaces all {@code code} values.
         *
         * @param code the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder code(List<Coding> code) {
            this.code = code == null ? new ArrayList<>() : new ArrayList<>(code);
            return this;
        }

        /**
         * Adds a {@code code} value.
         *
         * @param code the value to add
         * @return this builder
         */
        public Builder addCode(Coding code) {
            this.code.add(Objects.requireNonNull(code, "code"));
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
         * Builds the {@code Questionnaire}.
         *
         * @return the {@code Questionnaire}
         * @throws NullPointerException if a required element is absent
         */
        public Questionnaire build() {
            return new Questionnaire(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, derivedFrom, status, experimental, subjectType, date,
                    publisher, contact, description, useContext, jurisdiction, purpose, copyright, copyrightLabel,
                    approvalDate, lastReviewDate, effectivePeriod, code, item);
        }
    }
}
