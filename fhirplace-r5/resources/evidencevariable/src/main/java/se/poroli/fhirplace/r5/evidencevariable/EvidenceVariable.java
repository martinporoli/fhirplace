package se.poroli.fhirplace.r5.evidencevariable;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.EvidenceVariableHandling;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * The EvidenceVariable resource describes an element that knowledge (Evidence) is about.
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
 * @param url Canonical identifier for this evidence variable, represented as a URI (globally unique).
 * @param identifier Additional identifier for the evidence variable.
 * @param version Business version of the evidence variable.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this evidence variable (computer friendly).
 * @param title Name for this evidence variable (human friendly).
 * @param shortTitle Title for use in informal contexts.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the evidence variable.
 * @param note Used for footnotes or explanatory notes.
 * @param useContext The context that the content is intended to support.
 * @param purpose Why this EvidenceVariable is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param approvalDate When the resource was approved by publisher.
 * @param lastReviewDate When the resource was last reviewed by the publisher.
 * @param effectivePeriod When the resource is expected to be used.
 * @param author Who authored the content.
 * @param editor Who edited the content.
 * @param reviewer Who reviewed the content.
 * @param endorser Who endorsed the content.
 * @param relatedArtifact Additional documentation, citations, etc.
 * @param actual Actual or conceptual.
 * @param characteristic A defining factor of the EvidenceVariable.
 * @param handling continuous | dichotomous | ordinal | polychotomous.
 * @param category A grouping for ordinal or polychotomous variables.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/EvidenceVariable">FHIR R5 EvidenceVariable</a>
 */
public record EvidenceVariable(
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
        FhirString shortTitle,
        FhirEnum<PublicationStatus> status,
        FhirBoolean experimental,
        FhirDateTime date,
        FhirString publisher,
        List<ContactDetail> contact,
        FhirMarkdown description,
        List<Annotation> note,
        List<UsageContext> useContext,
        FhirMarkdown purpose,
        FhirMarkdown copyright,
        FhirString copyrightLabel,
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        Period effectivePeriod,
        List<ContactDetail> author,
        List<ContactDetail> editor,
        List<ContactDetail> reviewer,
        List<ContactDetail> endorser,
        List<RelatedArtifact> relatedArtifact,
        FhirBoolean actual,
        List<Characteristic> characteristic,
        FhirEnum<EvidenceVariableHandling> handling,
        List<Category> category) implements DomainResource {

    /**
     * Creates an {@code EvidenceVariable}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public EvidenceVariable {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        note = note == null ? List.of() : List.copyOf(note);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        author = author == null ? List.of() : List.copyOf(author);
        editor = editor == null ? List.of() : List.copyOf(editor);
        reviewer = reviewer == null ? List.of() : List.copyOf(reviewer);
        endorser = endorser == null ? List.of() : List.copyOf(endorser);
        relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
        characteristic = characteristic == null ? List.of() : List.copyOf(characteristic);
        category = category == null ? List.of() : List.copyOf(category);
        Objects.requireNonNull(status, "EvidenceVariable.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "EvidenceVariable.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code EvidenceVariable}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A defining factor of the EvidenceVariable.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param linkId Label for internal linking.
     * @param description Natural language description of the characteristic.
     * @param note Used for footnotes or explanatory notes.
     * @param exclude Whether the characteristic is an inclusion criterion or exclusion criterion.
     * @param definitionReference Defines the characteristic (without using type and value) by a Reference. Reference
     *   to EvidenceVariable, Group, Evidence.
     * @param definitionCanonical Defines the characteristic (without using type and value) by a Canonical. Canonical
     *   reference to EvidenceVariable, Evidence.
     * @param definitionCodeableConcept Defines the characteristic (without using type and value) by a
     *   CodeableConcept.
     * @param definitionExpression Defines the characteristic (without using type and value) by an expression.
     * @param definitionId Defines the characteristic (without using type and value) by an id.
     * @param definitionByTypeAndValue Defines the characteristic using type and value.
     * @param definitionByCombination Used to specify how two or more characteristics are combined.
     * @param instances Number of occurrences meeting the characteristic. One of Quantity, Range.
     * @param duration Length of time in which the characteristic is met. One of Quantity, Range.
     * @param timeFromEvent Timing in which the characteristic is determined.
     */
    public record Characteristic(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirId linkId,
            FhirMarkdown description,
            List<Annotation> note,
            FhirBoolean exclude,
            Reference definitionReference,
            FhirCanonical definitionCanonical,
            CodeableConcept definitionCodeableConcept,
            Expression definitionExpression,
            FhirId definitionId,
            DefinitionByTypeAndValue definitionByTypeAndValue,
            DefinitionByCombination definitionByCombination,
            DataType instances,
            DataType duration,
            List<TimeFromEvent> timeFromEvent) implements BackboneElement {

        /**
         * Creates a {@code Characteristic}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Characteristic {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            note = note == null ? List.of() : List.copyOf(note);
            timeFromEvent = timeFromEvent == null ? List.of() : List.copyOf(timeFromEvent);
            if (instances != null && !(instances instanceof Quantity || instances instanceof Range)) {
                throw new IllegalArgumentException(
                        "EvidenceVariable.characteristic.instances[x] must be one of Quantity, Range, but was "
                                + instances.getClass().getSimpleName());
            }
            if (duration != null && !(duration instanceof Quantity || duration instanceof Range)) {
                throw new IllegalArgumentException(
                        "EvidenceVariable.characteristic.duration[x] must be one of Quantity, Range, but was "
                                + duration.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Characteristic}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Defines the characteristic using both a type and value[x] elements.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type Expresses the type of characteristic. Required.
         * @param method Method for how the characteristic value was determined.
         * @param device Device used for determining characteristic. Reference to Device, DeviceMetric.
         * @param value Defines the characteristic when coupled with characteristic.type. One of CodeableConcept,
         *   boolean, Quantity, Range, Reference, id. Required.
         * @param offset Reference point for valueQuantity or valueRange.
         */
        public record DefinitionByTypeAndValue(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                List<CodeableConcept> method,
                Reference device,
                DataType value,
                CodeableConcept offset) implements BackboneElement {

            /**
             * Creates a {@code DefinitionByTypeAndValue}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public DefinitionByTypeAndValue {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                method = method == null ? List.of() : List.copyOf(method);
                Objects.requireNonNull(
                        type, "EvidenceVariable.characteristic.definitionByTypeAndValue.type is required");
                Objects.requireNonNull(
                        value, "EvidenceVariable.characteristic.definitionByTypeAndValue.value is required");
                if (value != null && !(value instanceof CodeableConcept
                        || value instanceof FhirBoolean
                        || value instanceof Quantity
                        || value instanceof Range
                        || value instanceof Reference
                        || value instanceof FhirId)) {
                    throw new IllegalArgumentException(
                            "EvidenceVariable.characteristic.definitionByTypeAndValue.value[x] does not allow "
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
             * Returns a builder initialized with the values of this {@code DefinitionByTypeAndValue}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link DefinitionByTypeAndValue}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private List<CodeableConcept> method = new ArrayList<>();
                private Reference device;
                private DataType value;
                private CodeableConcept offset;

                private Builder() {
                }

                private Builder(DefinitionByTypeAndValue original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.method = new ArrayList<>(original.method());
                    this.device = original.device();
                    this.value = original.value();
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
                 * Replaces all {@code method} values.
                 *
                 * @param method the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder method(List<CodeableConcept> method) {
                    this.method = method == null ? new ArrayList<>() : new ArrayList<>(method);
                    return this;
                }

                /**
                 * Adds a {@code method} value.
                 *
                 * @param method the value to add
                 * @return this builder
                 */
                public Builder addMethod(CodeableConcept method) {
                    this.method.add(Objects.requireNonNull(method, "method"));
                    return this;
                }

                /**
                 * Sets {@code device}.
                 *
                 * @param device the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder device(Reference device) {
                    this.device = device;
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
                 * Sets {@code value} to a boolean.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirBoolean value) {
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
                 * Sets {@code value} to a Range.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Range value) {
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
                 * Sets {@code value} to a id.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirId value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a boolean without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Boolean value) {
                    this.value = value == null ? null : FhirBoolean.of(value);
                    return this;
                }

                /**
                 * Sets {@code value} to a id without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(String value) {
                    this.value = value == null ? null : FhirId.of(value);
                    return this;
                }

                /**
                 * Sets {@code offset}.
                 *
                 * @param offset the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder offset(CodeableConcept offset) {
                    this.offset = offset;
                    return this;
                }

                /**
                 * Builds the {@code DefinitionByTypeAndValue}.
                 *
                 * @return the {@code DefinitionByTypeAndValue}
                 * @throws NullPointerException if a required element is absent
                 */
                public DefinitionByTypeAndValue build() {
                    return new DefinitionByTypeAndValue(
                            id, extension, modifierExtension, type, method, device, value, offset);
                }
            }
        }

        /**
         * Defines the characteristic as a combination of two or more characteristics.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code all-of | any-of | at-least | at-most | statistical | net-effect | dataset. Required.
         * @param threshold Provides the value of "n" when "at-least" or "at-most" codes are used.
         * @param characteristic A defining factor of the characteristic. Required.
         */
        public record DefinitionByCombination(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<CharacteristicCombination> code,
                FhirPositiveInt threshold,
                List<EvidenceVariable.Characteristic> characteristic) implements BackboneElement {

            /**
             * Creates a {@code DefinitionByCombination}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a required list is empty
             */
            public DefinitionByCombination {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                characteristic = characteristic == null ? List.of() : List.copyOf(characteristic);
                Objects.requireNonNull(
                        code, "EvidenceVariable.characteristic.definitionByCombination.code is required");
                if (characteristic.isEmpty()) {
                    throw new IllegalArgumentException(
                            "EvidenceVariable.characteristic.definitionByCombination.characteristic requires at least one value");
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
             * Returns a builder initialized with the values of this {@code DefinitionByCombination}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link DefinitionByCombination}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<CharacteristicCombination> code;
                private FhirPositiveInt threshold;
                private List<EvidenceVariable.Characteristic> characteristic = new ArrayList<>();

                private Builder() {
                }

                private Builder(DefinitionByCombination original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.code = original.code();
                    this.threshold = original.threshold();
                    this.characteristic = new ArrayList<>(original.characteristic());
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
                public Builder code(FhirEnum<CharacteristicCombination> code) {
                    this.code = code;
                    return this;
                }

                /**
                 * Sets {@code code}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param code the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder code(CharacteristicCombination code) {
                    return code(code == null ? null : FhirEnum.of(code));
                }

                /**
                 * Sets {@code threshold}.
                 *
                 * @param threshold the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder threshold(FhirPositiveInt threshold) {
                    this.threshold = threshold;
                    return this;
                }

                /**
                 * Sets {@code threshold}, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param threshold the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder threshold(Integer threshold) {
                    return threshold(threshold == null ? null : FhirPositiveInt.of(threshold));
                }

                /**
                 * Replaces all {@code characteristic} values.
                 *
                 * @param characteristic the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder characteristic(List<EvidenceVariable.Characteristic> characteristic) {
                    this.characteristic = characteristic == null
                            ? new ArrayList<>()
                            : new ArrayList<>(characteristic);
                    return this;
                }

                /**
                 * Adds a {@code characteristic} value.
                 *
                 * @param characteristic the value to add
                 * @return this builder
                 */
                public Builder addCharacteristic(EvidenceVariable.Characteristic characteristic) {
                    this.characteristic.add(Objects.requireNonNull(characteristic, "characteristic"));
                    return this;
                }

                /**
                 * Builds the {@code DefinitionByCombination}.
                 *
                 * @return the {@code DefinitionByCombination}
                 * @throws NullPointerException if a required element is absent
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public DefinitionByCombination build() {
                    return new DefinitionByCombination(
                            id, extension, modifierExtension, code, threshold, characteristic);
                }
            }
        }

        /**
         * Timing in which the characteristic is determined.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param description Human readable description.
         * @param note Used for footnotes or explanatory notes.
         * @param event The event used as a base point (reference point) in time. One of CodeableConcept, Reference,
         *   dateTime, id.
         * @param quantity Used to express the observation at a defined amount of time before or after the event.
         * @param range Used to express the observation within a period before and/or after the event.
         */
        public record TimeFromEvent(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirMarkdown description,
                List<Annotation> note,
                DataType event,
                Quantity quantity,
                Range range) implements BackboneElement {

            /**
             * Creates a {@code TimeFromEvent}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public TimeFromEvent {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                note = note == null ? List.of() : List.copyOf(note);
                if (event != null && !(event instanceof CodeableConcept
                        || event instanceof Reference
                        || event instanceof FhirDateTime
                        || event instanceof FhirId)) {
                    throw new IllegalArgumentException(
                            "EvidenceVariable.characteristic.timeFromEvent.event[x] does not allow "
                                    + event.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code TimeFromEvent}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link TimeFromEvent}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirMarkdown description;
                private List<Annotation> note = new ArrayList<>();
                private DataType event;
                private Quantity quantity;
                private Range range;

                private Builder() {
                }

                private Builder(TimeFromEvent original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.description = original.description();
                    this.note = new ArrayList<>(original.note());
                    this.event = original.event();
                    this.quantity = original.quantity();
                    this.range = original.range();
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
                 * Sets {@code event} to a CodeableConcept.
                 *
                 * @param event the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder event(CodeableConcept event) {
                    this.event = event;
                    return this;
                }

                /**
                 * Sets {@code event} to a Reference.
                 *
                 * @param event the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder event(Reference event) {
                    this.event = event;
                    return this;
                }

                /**
                 * Sets {@code event} to a dateTime.
                 *
                 * @param event the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder event(FhirDateTime event) {
                    this.event = event;
                    return this;
                }

                /**
                 * Sets {@code event} to a id.
                 *
                 * @param event the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder event(FhirId event) {
                    this.event = event;
                    return this;
                }

                /**
                 * Sets {@code event} to a dateTime without id or extensions.
                 *
                 * @param event the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder event(Temporal event) {
                    this.event = event == null ? null : FhirDateTime.of(event);
                    return this;
                }

                /**
                 * Sets {@code event} to a id without id or extensions.
                 *
                 * @param event the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder event(String event) {
                    this.event = event == null ? null : FhirId.of(event);
                    return this;
                }

                /**
                 * Sets {@code quantity}.
                 *
                 * @param quantity the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder quantity(Quantity quantity) {
                    this.quantity = quantity;
                    return this;
                }

                /**
                 * Sets {@code range}.
                 *
                 * @param range the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder range(Range range) {
                    this.range = range;
                    return this;
                }

                /**
                 * Builds the {@code TimeFromEvent}.
                 *
                 * @return the {@code TimeFromEvent}
                 */
                public TimeFromEvent build() {
                    return new TimeFromEvent(
                            id, extension, modifierExtension, description, note, event, quantity, range);
                }
            }
        }

        /** Builder for {@link Characteristic}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirId linkId;
            private FhirMarkdown description;
            private List<Annotation> note = new ArrayList<>();
            private FhirBoolean exclude;
            private Reference definitionReference;
            private FhirCanonical definitionCanonical;
            private CodeableConcept definitionCodeableConcept;
            private Expression definitionExpression;
            private FhirId definitionId;
            private DefinitionByTypeAndValue definitionByTypeAndValue;
            private DefinitionByCombination definitionByCombination;
            private DataType instances;
            private DataType duration;
            private List<TimeFromEvent> timeFromEvent = new ArrayList<>();

            private Builder() {
            }

            private Builder(Characteristic original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.linkId = original.linkId();
                this.description = original.description();
                this.note = new ArrayList<>(original.note());
                this.exclude = original.exclude();
                this.definitionReference = original.definitionReference();
                this.definitionCanonical = original.definitionCanonical();
                this.definitionCodeableConcept = original.definitionCodeableConcept();
                this.definitionExpression = original.definitionExpression();
                this.definitionId = original.definitionId();
                this.definitionByTypeAndValue = original.definitionByTypeAndValue();
                this.definitionByCombination = original.definitionByCombination();
                this.instances = original.instances();
                this.duration = original.duration();
                this.timeFromEvent = new ArrayList<>(original.timeFromEvent());
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
            public Builder linkId(FhirId linkId) {
                this.linkId = linkId;
                return this;
            }

            /**
             * Sets {@code linkId}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param linkId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder linkId(String linkId) {
                return linkId(linkId == null ? null : FhirId.of(linkId));
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
             * Sets {@code exclude}.
             *
             * @param exclude the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder exclude(FhirBoolean exclude) {
                this.exclude = exclude;
                return this;
            }

            /**
             * Sets {@code exclude}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param exclude the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder exclude(Boolean exclude) {
                return exclude(exclude == null ? null : FhirBoolean.of(exclude));
            }

            /**
             * Sets {@code definitionReference}.
             *
             * @param definitionReference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definitionReference(Reference definitionReference) {
                this.definitionReference = definitionReference;
                return this;
            }

            /**
             * Sets {@code definitionCanonical}.
             *
             * @param definitionCanonical the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definitionCanonical(FhirCanonical definitionCanonical) {
                this.definitionCanonical = definitionCanonical;
                return this;
            }

            /**
             * Sets {@code definitionCanonical}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param definitionCanonical the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definitionCanonical(String definitionCanonical) {
                return definitionCanonical(
                        definitionCanonical == null ? null : FhirCanonical.of(definitionCanonical));
            }

            /**
             * Sets {@code definitionCodeableConcept}.
             *
             * @param definitionCodeableConcept the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definitionCodeableConcept(CodeableConcept definitionCodeableConcept) {
                this.definitionCodeableConcept = definitionCodeableConcept;
                return this;
            }

            /**
             * Sets {@code definitionExpression}.
             *
             * @param definitionExpression the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definitionExpression(Expression definitionExpression) {
                this.definitionExpression = definitionExpression;
                return this;
            }

            /**
             * Sets {@code definitionId}.
             *
             * @param definitionId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definitionId(FhirId definitionId) {
                this.definitionId = definitionId;
                return this;
            }

            /**
             * Sets {@code definitionId}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param definitionId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definitionId(String definitionId) {
                return definitionId(definitionId == null ? null : FhirId.of(definitionId));
            }

            /**
             * Sets {@code definitionByTypeAndValue}.
             *
             * @param definitionByTypeAndValue the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definitionByTypeAndValue(DefinitionByTypeAndValue definitionByTypeAndValue) {
                this.definitionByTypeAndValue = definitionByTypeAndValue;
                return this;
            }

            /**
             * Sets {@code definitionByCombination}.
             *
             * @param definitionByCombination the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definitionByCombination(DefinitionByCombination definitionByCombination) {
                this.definitionByCombination = definitionByCombination;
                return this;
            }

            /**
             * Sets {@code instances} to a Quantity.
             *
             * @param instances the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instances(Quantity instances) {
                this.instances = instances;
                return this;
            }

            /**
             * Sets {@code instances} to a Range.
             *
             * @param instances the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instances(Range instances) {
                this.instances = instances;
                return this;
            }

            /**
             * Sets {@code duration} to a Quantity.
             *
             * @param duration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder duration(Quantity duration) {
                this.duration = duration;
                return this;
            }

            /**
             * Sets {@code duration} to a Range.
             *
             * @param duration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder duration(Range duration) {
                this.duration = duration;
                return this;
            }

            /**
             * Replaces all {@code timeFromEvent} values.
             *
             * @param timeFromEvent the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder timeFromEvent(List<TimeFromEvent> timeFromEvent) {
                this.timeFromEvent = timeFromEvent == null ? new ArrayList<>() : new ArrayList<>(timeFromEvent);
                return this;
            }

            /**
             * Adds a {@code timeFromEvent} value.
             *
             * @param timeFromEvent the value to add
             * @return this builder
             */
            public Builder addTimeFromEvent(TimeFromEvent timeFromEvent) {
                this.timeFromEvent.add(Objects.requireNonNull(timeFromEvent, "timeFromEvent"));
                return this;
            }

            /**
             * Builds the {@code Characteristic}.
             *
             * @return the {@code Characteristic}
             */
            public Characteristic build() {
                return new Characteristic(
                        id, extension, modifierExtension, linkId, description, note, exclude, definitionReference,
                        definitionCanonical, definitionCodeableConcept, definitionExpression, definitionId,
                        definitionByTypeAndValue, definitionByCombination, instances, duration, timeFromEvent);
            }
        }
    }

    /**
     * A grouping for ordinal or polychotomous variables.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Description of the grouping.
     * @param value Definition of the grouping. One of CodeableConcept, Quantity, Range.
     */
    public record Category(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            DataType value) implements BackboneElement {

        /**
         * Creates a {@code Category}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Category {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (value != null && !(value instanceof CodeableConcept
                    || value instanceof Quantity
                    || value instanceof Range)) {
                throw new IllegalArgumentException(
                        "EvidenceVariable.category.value[x] must be one of CodeableConcept, Quantity, Range, but was "
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
         * Returns a builder initialized with the values of this {@code Category}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Category}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString name;
            private DataType value;

            private Builder() {
            }

            private Builder(Category original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
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
             * Sets {@code value} to a Range.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Range value) {
                this.value = value;
                return this;
            }

            /**
             * Builds the {@code Category}.
             *
             * @return the {@code Category}
             */
            public Category build() {
                return new Category(
                        id, extension, modifierExtension, name, value);
            }
        }
    }

    /** Builder for {@link EvidenceVariable}. Builders are mutable and not thread-safe. */
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
        private FhirString shortTitle;
        private FhirEnum<PublicationStatus> status;
        private FhirBoolean experimental;
        private FhirDateTime date;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private FhirMarkdown description;
        private List<Annotation> note = new ArrayList<>();
        private List<UsageContext> useContext = new ArrayList<>();
        private FhirMarkdown purpose;
        private FhirMarkdown copyright;
        private FhirString copyrightLabel;
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private Period effectivePeriod;
        private List<ContactDetail> author = new ArrayList<>();
        private List<ContactDetail> editor = new ArrayList<>();
        private List<ContactDetail> reviewer = new ArrayList<>();
        private List<ContactDetail> endorser = new ArrayList<>();
        private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
        private FhirBoolean actual;
        private List<Characteristic> characteristic = new ArrayList<>();
        private FhirEnum<EvidenceVariableHandling> handling;
        private List<Category> category = new ArrayList<>();

        private Builder() {
        }

        private Builder(EvidenceVariable original) {
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
            this.shortTitle = original.shortTitle();
            this.status = original.status();
            this.experimental = original.experimental();
            this.date = original.date();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.description = original.description();
            this.note = new ArrayList<>(original.note());
            this.useContext = new ArrayList<>(original.useContext());
            this.purpose = original.purpose();
            this.copyright = original.copyright();
            this.copyrightLabel = original.copyrightLabel();
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.effectivePeriod = original.effectivePeriod();
            this.author = new ArrayList<>(original.author());
            this.editor = new ArrayList<>(original.editor());
            this.reviewer = new ArrayList<>(original.reviewer());
            this.endorser = new ArrayList<>(original.endorser());
            this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
            this.actual = original.actual();
            this.characteristic = new ArrayList<>(original.characteristic());
            this.handling = original.handling();
            this.category = new ArrayList<>(original.category());
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
         * Sets {@code shortTitle}.
         *
         * @param shortTitle the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder shortTitle(FhirString shortTitle) {
            this.shortTitle = shortTitle;
            return this;
        }

        /**
         * Sets {@code shortTitle}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param shortTitle the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder shortTitle(String shortTitle) {
            return shortTitle(shortTitle == null ? null : FhirString.of(shortTitle));
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
         * Sets {@code actual}.
         *
         * @param actual the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder actual(FhirBoolean actual) {
            this.actual = actual;
            return this;
        }

        /**
         * Sets {@code actual}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param actual the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder actual(Boolean actual) {
            return actual(actual == null ? null : FhirBoolean.of(actual));
        }

        /**
         * Replaces all {@code characteristic} values.
         *
         * @param characteristic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder characteristic(List<Characteristic> characteristic) {
            this.characteristic = characteristic == null ? new ArrayList<>() : new ArrayList<>(characteristic);
            return this;
        }

        /**
         * Adds a {@code characteristic} value.
         *
         * @param characteristic the value to add
         * @return this builder
         */
        public Builder addCharacteristic(Characteristic characteristic) {
            this.characteristic.add(Objects.requireNonNull(characteristic, "characteristic"));
            return this;
        }

        /**
         * Sets {@code handling}.
         *
         * @param handling the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder handling(FhirEnum<EvidenceVariableHandling> handling) {
            this.handling = handling;
            return this;
        }

        /**
         * Sets {@code handling}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param handling the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder handling(EvidenceVariableHandling handling) {
            return handling(handling == null ? null : FhirEnum.of(handling));
        }

        /**
         * Replaces all {@code category} values.
         *
         * @param category the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder category(List<Category> category) {
            this.category = category == null ? new ArrayList<>() : new ArrayList<>(category);
            return this;
        }

        /**
         * Adds a {@code category} value.
         *
         * @param category the value to add
         * @return this builder
         */
        public Builder addCategory(Category category) {
            this.category.add(Objects.requireNonNull(category, "category"));
            return this;
        }

        /**
         * Builds the {@code EvidenceVariable}.
         *
         * @return the {@code EvidenceVariable}
         * @throws NullPointerException if a required element is absent
         */
        public EvidenceVariable build() {
            return new EvidenceVariable(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, shortTitle, status, experimental, date, publisher,
                    contact, description, note, useContext, purpose, copyright, copyrightLabel, approvalDate,
                    lastReviewDate, effectivePeriod, author, editor, reviewer, endorser, relatedArtifact, actual,
                    characteristic, handling, category);
        }
    }
}
