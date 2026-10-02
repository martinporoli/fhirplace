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
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.AdministrativeGender;
import se.poroli.fhirplace.r5.valuesets.ObservationDataType;
import se.poroli.fhirplace.r5.valuesets.ObservationRangeCategory;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable
 * health care service.
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
 * @param url Logical canonical URL to reference this ObservationDefinition (globally unique).
 * @param identifier Business identifier of the ObservationDefinition.
 * @param version Business version of the ObservationDefinition.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this ObservationDefinition (computer friendly).
 * @param title Name for this ObservationDefinition (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental If for testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher The name of the individual or organization that published the ObservationDefinition.
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the ObservationDefinition.
 * @param useContext Content intends to support these contexts.
 * @param jurisdiction Intended jurisdiction for this ObservationDefinition (if applicable).
 * @param purpose Why this ObservationDefinition is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param approvalDate When ObservationDefinition was approved by publisher.
 * @param lastReviewDate Date on which the asset content was last reviewed by the publisher.
 * @param effectivePeriod The effective date range for the ObservationDefinition.
 * @param derivedFromCanonical Based on FHIR definition of another observation. Canonical reference to
 *   ObservationDefinition.
 * @param derivedFromUri Based on external definition.
 * @param subject Type of subject for the defined observation.
 * @param performerType Desired kind of performer for such kind of observation.
 * @param category General type of observation.
 * @param code Type of observation. Required.
 * @param permittedDataType Quantity | CodeableConcept | string | boolean | integer | Range | Ratio | SampledData |
 *   time | dateTime | Period.
 * @param multipleResultsAllowed Multiple results allowed for conforming observations.
 * @param bodySite Body part to be observed.
 * @param method Method used to produce the observation.
 * @param specimen Kind of specimen used by this type of observation. Reference to SpecimenDefinition.
 * @param device Measurement device or model of device. Reference to DeviceDefinition, Device.
 * @param preferredReportName The preferred name to be used when reporting the observation results.
 * @param permittedUnit Unit for quantitative results.
 * @param qualifiedValue Set of qualified values for observation results.
 * @param hasMember Definitions of related resources belonging to this kind of observation group. Reference to
 *   ObservationDefinition, Questionnaire.
 * @param component Component results.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ObservationDefinition">FHIR R5 ObservationDefinition</a>
 */
public record ObservationDefinition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirUri url,
        Identifier identifier,
        FhirString version,
        DataType versionAlgorithm,
        FhirString name,
        FhirString title,
        FhirEnum<PublicationStatus> status,
        FhirBoolean experimental,
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
        List<FhirCanonical> derivedFromCanonical,
        List<FhirUri> derivedFromUri,
        List<CodeableConcept> subject,
        CodeableConcept performerType,
        List<CodeableConcept> category,
        CodeableConcept code,
        List<FhirEnum<ObservationDataType>> permittedDataType,
        FhirBoolean multipleResultsAllowed,
        CodeableConcept bodySite,
        CodeableConcept method,
        List<Reference> specimen,
        List<Reference> device,
        FhirString preferredReportName,
        List<Coding> permittedUnit,
        List<QualifiedValue> qualifiedValue,
        List<Reference> hasMember,
        List<Component> component) implements DomainResource {

    /**
     * Creates an {@code ObservationDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ObservationDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        derivedFromCanonical = derivedFromCanonical == null ? List.of() : List.copyOf(derivedFromCanonical);
        derivedFromUri = derivedFromUri == null ? List.of() : List.copyOf(derivedFromUri);
        subject = subject == null ? List.of() : List.copyOf(subject);
        category = category == null ? List.of() : List.copyOf(category);
        permittedDataType = permittedDataType == null ? List.of() : List.copyOf(permittedDataType);
        specimen = specimen == null ? List.of() : List.copyOf(specimen);
        device = device == null ? List.of() : List.copyOf(device);
        permittedUnit = permittedUnit == null ? List.of() : List.copyOf(permittedUnit);
        qualifiedValue = qualifiedValue == null ? List.of() : List.copyOf(qualifiedValue);
        hasMember = hasMember == null ? List.of() : List.copyOf(hasMember);
        component = component == null ? List.of() : List.copyOf(component);
        Objects.requireNonNull(status, "ObservationDefinition.status is required");
        Objects.requireNonNull(code, "ObservationDefinition.code is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "ObservationDefinition.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code ObservationDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A set of qualified values associated with a context and a set of conditions - provides a range for quantitative
     * and ordinal observations and a collection of value sets for qualitative observations.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param context Context qualifier for the set of qualified values.
     * @param appliesTo Targetted population for the set of qualified values.
     * @param gender male | female | other | unknown.
     * @param age Applicable age range for the set of qualified values.
     * @param gestationalAge Applicable gestational age range for the set of qualified values.
     * @param condition Condition associated with the set of qualified values.
     * @param rangeCategory reference | critical | absolute.
     * @param range The range for continuous or ordinal observations.
     * @param validCodedValueSet Value set of valid coded values as part of this set of qualified values. Canonical
     *   reference to ValueSet.
     * @param normalCodedValueSet Value set of normal coded values as part of this set of qualified values. Canonical
     *   reference to ValueSet.
     * @param abnormalCodedValueSet Value set of abnormal coded values as part of this set of qualified values.
     *   Canonical reference to ValueSet.
     * @param criticalCodedValueSet Value set of critical coded values as part of this set of qualified values.
     *   Canonical reference to ValueSet.
     */
    public record QualifiedValue(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept context,
            List<CodeableConcept> appliesTo,
            FhirEnum<AdministrativeGender> gender,
            Range age,
            Range gestationalAge,
            FhirString condition,
            FhirEnum<ObservationRangeCategory> rangeCategory,
            Range range,
            FhirCanonical validCodedValueSet,
            FhirCanonical normalCodedValueSet,
            FhirCanonical abnormalCodedValueSet,
            FhirCanonical criticalCodedValueSet) implements BackboneElement {

        /**
         * Creates a {@code QualifiedValue}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public QualifiedValue {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            appliesTo = appliesTo == null ? List.of() : List.copyOf(appliesTo);
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
         * Returns a builder initialized with the values of this {@code QualifiedValue}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link QualifiedValue}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept context;
            private List<CodeableConcept> appliesTo = new ArrayList<>();
            private FhirEnum<AdministrativeGender> gender;
            private Range age;
            private Range gestationalAge;
            private FhirString condition;
            private FhirEnum<ObservationRangeCategory> rangeCategory;
            private Range range;
            private FhirCanonical validCodedValueSet;
            private FhirCanonical normalCodedValueSet;
            private FhirCanonical abnormalCodedValueSet;
            private FhirCanonical criticalCodedValueSet;

            private Builder() {
            }

            private Builder(QualifiedValue original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.context = original.context();
                this.appliesTo = new ArrayList<>(original.appliesTo());
                this.gender = original.gender();
                this.age = original.age();
                this.gestationalAge = original.gestationalAge();
                this.condition = original.condition();
                this.rangeCategory = original.rangeCategory();
                this.range = original.range();
                this.validCodedValueSet = original.validCodedValueSet();
                this.normalCodedValueSet = original.normalCodedValueSet();
                this.abnormalCodedValueSet = original.abnormalCodedValueSet();
                this.criticalCodedValueSet = original.criticalCodedValueSet();
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
             * Sets {@code context}.
             *
             * @param context the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder context(CodeableConcept context) {
                this.context = context;
                return this;
            }

            /**
             * Replaces all {@code appliesTo} values.
             *
             * @param appliesTo the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder appliesTo(List<CodeableConcept> appliesTo) {
                this.appliesTo = appliesTo == null ? new ArrayList<>() : new ArrayList<>(appliesTo);
                return this;
            }

            /**
             * Adds a {@code appliesTo} value.
             *
             * @param appliesTo the value to add
             * @return this builder
             */
            public Builder addAppliesTo(CodeableConcept appliesTo) {
                this.appliesTo.add(Objects.requireNonNull(appliesTo, "appliesTo"));
                return this;
            }

            /**
             * Sets {@code gender}.
             *
             * @param gender the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder gender(FhirEnum<AdministrativeGender> gender) {
                this.gender = gender;
                return this;
            }

            /**
             * Sets {@code gender}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param gender the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder gender(AdministrativeGender gender) {
                return gender(gender == null ? null : FhirEnum.of(gender));
            }

            /**
             * Sets {@code age}.
             *
             * @param age the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder age(Range age) {
                this.age = age;
                return this;
            }

            /**
             * Sets {@code gestationalAge}.
             *
             * @param gestationalAge the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder gestationalAge(Range gestationalAge) {
                this.gestationalAge = gestationalAge;
                return this;
            }

            /**
             * Sets {@code condition}.
             *
             * @param condition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder condition(FhirString condition) {
                this.condition = condition;
                return this;
            }

            /**
             * Sets {@code condition}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param condition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder condition(String condition) {
                return condition(condition == null ? null : FhirString.of(condition));
            }

            /**
             * Sets {@code rangeCategory}.
             *
             * @param rangeCategory the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rangeCategory(FhirEnum<ObservationRangeCategory> rangeCategory) {
                this.rangeCategory = rangeCategory;
                return this;
            }

            /**
             * Sets {@code rangeCategory}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param rangeCategory the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rangeCategory(ObservationRangeCategory rangeCategory) {
                return rangeCategory(rangeCategory == null ? null : FhirEnum.of(rangeCategory));
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
             * Sets {@code validCodedValueSet}.
             *
             * @param validCodedValueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder validCodedValueSet(FhirCanonical validCodedValueSet) {
                this.validCodedValueSet = validCodedValueSet;
                return this;
            }

            /**
             * Sets {@code validCodedValueSet}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param validCodedValueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder validCodedValueSet(String validCodedValueSet) {
                return validCodedValueSet(validCodedValueSet == null ? null : FhirCanonical.of(validCodedValueSet));
            }

            /**
             * Sets {@code normalCodedValueSet}.
             *
             * @param normalCodedValueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder normalCodedValueSet(FhirCanonical normalCodedValueSet) {
                this.normalCodedValueSet = normalCodedValueSet;
                return this;
            }

            /**
             * Sets {@code normalCodedValueSet}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param normalCodedValueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder normalCodedValueSet(String normalCodedValueSet) {
                return normalCodedValueSet(
                        normalCodedValueSet == null ? null : FhirCanonical.of(normalCodedValueSet));
            }

            /**
             * Sets {@code abnormalCodedValueSet}.
             *
             * @param abnormalCodedValueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder abnormalCodedValueSet(FhirCanonical abnormalCodedValueSet) {
                this.abnormalCodedValueSet = abnormalCodedValueSet;
                return this;
            }

            /**
             * Sets {@code abnormalCodedValueSet}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param abnormalCodedValueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder abnormalCodedValueSet(String abnormalCodedValueSet) {
                return abnormalCodedValueSet(
                        abnormalCodedValueSet == null ? null : FhirCanonical.of(abnormalCodedValueSet));
            }

            /**
             * Sets {@code criticalCodedValueSet}.
             *
             * @param criticalCodedValueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder criticalCodedValueSet(FhirCanonical criticalCodedValueSet) {
                this.criticalCodedValueSet = criticalCodedValueSet;
                return this;
            }

            /**
             * Sets {@code criticalCodedValueSet}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param criticalCodedValueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder criticalCodedValueSet(String criticalCodedValueSet) {
                return criticalCodedValueSet(
                        criticalCodedValueSet == null ? null : FhirCanonical.of(criticalCodedValueSet));
            }

            /**
             * Builds the {@code QualifiedValue}.
             *
             * @return the {@code QualifiedValue}
             */
            public QualifiedValue build() {
                return new QualifiedValue(
                        id, extension, modifierExtension, context, appliesTo, gender, age, gestationalAge, condition,
                        rangeCategory, range, validCodedValueSet, normalCodedValueSet, abnormalCodedValueSet,
                        criticalCodedValueSet);
            }
        }
    }

    /**
     * Some observations have multiple component observations, expressed as separate code value pairs.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Type of observation. Required.
     * @param permittedDataType Quantity | CodeableConcept | string | boolean | integer | Range | Ratio | SampledData
     *   | time | dateTime | Period.
     * @param permittedUnit Unit for quantitative results.
     * @param qualifiedValue Set of qualified values for observation results.
     */
    public record Component(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            List<FhirEnum<ObservationDataType>> permittedDataType,
            List<Coding> permittedUnit,
            List<ObservationDefinition.QualifiedValue> qualifiedValue) implements BackboneElement {

        /**
         * Creates a {@code Component}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Component {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            permittedDataType = permittedDataType == null ? List.of() : List.copyOf(permittedDataType);
            permittedUnit = permittedUnit == null ? List.of() : List.copyOf(permittedUnit);
            qualifiedValue = qualifiedValue == null ? List.of() : List.copyOf(qualifiedValue);
            Objects.requireNonNull(code, "ObservationDefinition.component.code is required");
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
         * Returns a builder initialized with the values of this {@code Component}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Component}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private List<FhirEnum<ObservationDataType>> permittedDataType = new ArrayList<>();
            private List<Coding> permittedUnit = new ArrayList<>();
            private List<ObservationDefinition.QualifiedValue> qualifiedValue = new ArrayList<>();

            private Builder() {
            }

            private Builder(Component original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.permittedDataType = new ArrayList<>(original.permittedDataType());
                this.permittedUnit = new ArrayList<>(original.permittedUnit());
                this.qualifiedValue = new ArrayList<>(original.qualifiedValue());
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
            public Builder code(CodeableConcept code) {
                this.code = code;
                return this;
            }

            /**
             * Replaces all {@code permittedDataType} values.
             *
             * @param permittedDataType the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder permittedDataType(List<FhirEnum<ObservationDataType>> permittedDataType) {
                this.permittedDataType = permittedDataType == null
                        ? new ArrayList<>()
                        : new ArrayList<>(permittedDataType);
                return this;
            }

            /**
             * Adds a {@code permittedDataType} value.
             *
             * @param permittedDataType the value to add
             * @return this builder
             */
            public Builder addPermittedDataType(FhirEnum<ObservationDataType> permittedDataType) {
                this.permittedDataType.add(Objects.requireNonNull(permittedDataType, "permittedDataType"));
                return this;
            }

            /**
             * Adds a {@code permittedDataType} value, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param permittedDataType the value to add
             * @return this builder
             */
            public Builder addPermittedDataType(ObservationDataType permittedDataType) {
                return addPermittedDataType(FhirEnum.of(permittedDataType));
            }

            /**
             * Replaces all {@code permittedUnit} values.
             *
             * @param permittedUnit the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder permittedUnit(List<Coding> permittedUnit) {
                this.permittedUnit = permittedUnit == null ? new ArrayList<>() : new ArrayList<>(permittedUnit);
                return this;
            }

            /**
             * Adds a {@code permittedUnit} value.
             *
             * @param permittedUnit the value to add
             * @return this builder
             */
            public Builder addPermittedUnit(Coding permittedUnit) {
                this.permittedUnit.add(Objects.requireNonNull(permittedUnit, "permittedUnit"));
                return this;
            }

            /**
             * Replaces all {@code qualifiedValue} values.
             *
             * @param qualifiedValue the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder qualifiedValue(List<ObservationDefinition.QualifiedValue> qualifiedValue) {
                this.qualifiedValue = qualifiedValue == null ? new ArrayList<>() : new ArrayList<>(qualifiedValue);
                return this;
            }

            /**
             * Adds a {@code qualifiedValue} value.
             *
             * @param qualifiedValue the value to add
             * @return this builder
             */
            public Builder addQualifiedValue(ObservationDefinition.QualifiedValue qualifiedValue) {
                this.qualifiedValue.add(Objects.requireNonNull(qualifiedValue, "qualifiedValue"));
                return this;
            }

            /**
             * Builds the {@code Component}.
             *
             * @return the {@code Component}
             * @throws NullPointerException if a required element is absent
             */
            public Component build() {
                return new Component(
                        id, extension, modifierExtension, code, permittedDataType, permittedUnit, qualifiedValue);
            }
        }
    }

    /** Builder for {@link ObservationDefinition}. Builders are mutable and not thread-safe. */
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
        private Identifier identifier;
        private FhirString version;
        private DataType versionAlgorithm;
        private FhirString name;
        private FhirString title;
        private FhirEnum<PublicationStatus> status;
        private FhirBoolean experimental;
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
        private List<FhirCanonical> derivedFromCanonical = new ArrayList<>();
        private List<FhirUri> derivedFromUri = new ArrayList<>();
        private List<CodeableConcept> subject = new ArrayList<>();
        private CodeableConcept performerType;
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableConcept code;
        private List<FhirEnum<ObservationDataType>> permittedDataType = new ArrayList<>();
        private FhirBoolean multipleResultsAllowed;
        private CodeableConcept bodySite;
        private CodeableConcept method;
        private List<Reference> specimen = new ArrayList<>();
        private List<Reference> device = new ArrayList<>();
        private FhirString preferredReportName;
        private List<Coding> permittedUnit = new ArrayList<>();
        private List<QualifiedValue> qualifiedValue = new ArrayList<>();
        private List<Reference> hasMember = new ArrayList<>();
        private List<Component> component = new ArrayList<>();

        private Builder() {
        }

        private Builder(ObservationDefinition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.url = original.url();
            this.identifier = original.identifier();
            this.version = original.version();
            this.versionAlgorithm = original.versionAlgorithm();
            this.name = original.name();
            this.title = original.title();
            this.status = original.status();
            this.experimental = original.experimental();
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
            this.derivedFromCanonical = new ArrayList<>(original.derivedFromCanonical());
            this.derivedFromUri = new ArrayList<>(original.derivedFromUri());
            this.subject = new ArrayList<>(original.subject());
            this.performerType = original.performerType();
            this.category = new ArrayList<>(original.category());
            this.code = original.code();
            this.permittedDataType = new ArrayList<>(original.permittedDataType());
            this.multipleResultsAllowed = original.multipleResultsAllowed();
            this.bodySite = original.bodySite();
            this.method = original.method();
            this.specimen = new ArrayList<>(original.specimen());
            this.device = new ArrayList<>(original.device());
            this.preferredReportName = original.preferredReportName();
            this.permittedUnit = new ArrayList<>(original.permittedUnit());
            this.qualifiedValue = new ArrayList<>(original.qualifiedValue());
            this.hasMember = new ArrayList<>(original.hasMember());
            this.component = new ArrayList<>(original.component());
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
         * Sets {@code identifier}.
         *
         * @param identifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder identifier(Identifier identifier) {
            this.identifier = identifier;
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
         * Replaces all {@code derivedFromCanonical} values.
         *
         * @param derivedFromCanonical the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder derivedFromCanonical(List<FhirCanonical> derivedFromCanonical) {
            this.derivedFromCanonical = derivedFromCanonical == null
                    ? new ArrayList<>()
                    : new ArrayList<>(derivedFromCanonical);
            return this;
        }

        /**
         * Adds a {@code derivedFromCanonical} value.
         *
         * @param derivedFromCanonical the value to add
         * @return this builder
         */
        public Builder addDerivedFromCanonical(FhirCanonical derivedFromCanonical) {
            this.derivedFromCanonical.add(Objects.requireNonNull(derivedFromCanonical, "derivedFromCanonical"));
            return this;
        }

        /**
         * Adds a {@code derivedFromCanonical} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param derivedFromCanonical the value to add
         * @return this builder
         */
        public Builder addDerivedFromCanonical(String derivedFromCanonical) {
            return addDerivedFromCanonical(FhirCanonical.of(derivedFromCanonical));
        }

        /**
         * Replaces all {@code derivedFromUri} values.
         *
         * @param derivedFromUri the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder derivedFromUri(List<FhirUri> derivedFromUri) {
            this.derivedFromUri = derivedFromUri == null ? new ArrayList<>() : new ArrayList<>(derivedFromUri);
            return this;
        }

        /**
         * Adds a {@code derivedFromUri} value.
         *
         * @param derivedFromUri the value to add
         * @return this builder
         */
        public Builder addDerivedFromUri(FhirUri derivedFromUri) {
            this.derivedFromUri.add(Objects.requireNonNull(derivedFromUri, "derivedFromUri"));
            return this;
        }

        /**
         * Adds a {@code derivedFromUri} value, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param derivedFromUri the value to add
         * @return this builder
         */
        public Builder addDerivedFromUri(String derivedFromUri) {
            return addDerivedFromUri(FhirUri.of(derivedFromUri));
        }

        /**
         * Replaces all {@code subject} values.
         *
         * @param subject the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder subject(List<CodeableConcept> subject) {
            this.subject = subject == null ? new ArrayList<>() : new ArrayList<>(subject);
            return this;
        }

        /**
         * Adds a {@code subject} value.
         *
         * @param subject the value to add
         * @return this builder
         */
        public Builder addSubject(CodeableConcept subject) {
            this.subject.add(Objects.requireNonNull(subject, "subject"));
            return this;
        }

        /**
         * Sets {@code performerType}.
         *
         * @param performerType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder performerType(CodeableConcept performerType) {
            this.performerType = performerType;
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
         * Replaces all {@code permittedDataType} values.
         *
         * @param permittedDataType the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder permittedDataType(List<FhirEnum<ObservationDataType>> permittedDataType) {
            this.permittedDataType = permittedDataType == null
                    ? new ArrayList<>()
                    : new ArrayList<>(permittedDataType);
            return this;
        }

        /**
         * Adds a {@code permittedDataType} value.
         *
         * @param permittedDataType the value to add
         * @return this builder
         */
        public Builder addPermittedDataType(FhirEnum<ObservationDataType> permittedDataType) {
            this.permittedDataType.add(Objects.requireNonNull(permittedDataType, "permittedDataType"));
            return this;
        }

        /**
         * Adds a {@code permittedDataType} value, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param permittedDataType the value to add
         * @return this builder
         */
        public Builder addPermittedDataType(ObservationDataType permittedDataType) {
            return addPermittedDataType(FhirEnum.of(permittedDataType));
        }

        /**
         * Sets {@code multipleResultsAllowed}.
         *
         * @param multipleResultsAllowed the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder multipleResultsAllowed(FhirBoolean multipleResultsAllowed) {
            this.multipleResultsAllowed = multipleResultsAllowed;
            return this;
        }

        /**
         * Sets {@code multipleResultsAllowed}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param multipleResultsAllowed the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder multipleResultsAllowed(Boolean multipleResultsAllowed) {
            return multipleResultsAllowed(
                    multipleResultsAllowed == null ? null : FhirBoolean.of(multipleResultsAllowed));
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
         * Sets {@code method}.
         *
         * @param method the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder method(CodeableConcept method) {
            this.method = method;
            return this;
        }

        /**
         * Replaces all {@code specimen} values.
         *
         * @param specimen the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder specimen(List<Reference> specimen) {
            this.specimen = specimen == null ? new ArrayList<>() : new ArrayList<>(specimen);
            return this;
        }

        /**
         * Adds a {@code specimen} value.
         *
         * @param specimen the value to add
         * @return this builder
         */
        public Builder addSpecimen(Reference specimen) {
            this.specimen.add(Objects.requireNonNull(specimen, "specimen"));
            return this;
        }

        /**
         * Replaces all {@code device} values.
         *
         * @param device the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder device(List<Reference> device) {
            this.device = device == null ? new ArrayList<>() : new ArrayList<>(device);
            return this;
        }

        /**
         * Adds a {@code device} value.
         *
         * @param device the value to add
         * @return this builder
         */
        public Builder addDevice(Reference device) {
            this.device.add(Objects.requireNonNull(device, "device"));
            return this;
        }

        /**
         * Sets {@code preferredReportName}.
         *
         * @param preferredReportName the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preferredReportName(FhirString preferredReportName) {
            this.preferredReportName = preferredReportName;
            return this;
        }

        /**
         * Sets {@code preferredReportName}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param preferredReportName the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preferredReportName(String preferredReportName) {
            return preferredReportName(preferredReportName == null ? null : FhirString.of(preferredReportName));
        }

        /**
         * Replaces all {@code permittedUnit} values.
         *
         * @param permittedUnit the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder permittedUnit(List<Coding> permittedUnit) {
            this.permittedUnit = permittedUnit == null ? new ArrayList<>() : new ArrayList<>(permittedUnit);
            return this;
        }

        /**
         * Adds a {@code permittedUnit} value.
         *
         * @param permittedUnit the value to add
         * @return this builder
         */
        public Builder addPermittedUnit(Coding permittedUnit) {
            this.permittedUnit.add(Objects.requireNonNull(permittedUnit, "permittedUnit"));
            return this;
        }

        /**
         * Replaces all {@code qualifiedValue} values.
         *
         * @param qualifiedValue the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder qualifiedValue(List<QualifiedValue> qualifiedValue) {
            this.qualifiedValue = qualifiedValue == null ? new ArrayList<>() : new ArrayList<>(qualifiedValue);
            return this;
        }

        /**
         * Adds a {@code qualifiedValue} value.
         *
         * @param qualifiedValue the value to add
         * @return this builder
         */
        public Builder addQualifiedValue(QualifiedValue qualifiedValue) {
            this.qualifiedValue.add(Objects.requireNonNull(qualifiedValue, "qualifiedValue"));
            return this;
        }

        /**
         * Replaces all {@code hasMember} values.
         *
         * @param hasMember the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder hasMember(List<Reference> hasMember) {
            this.hasMember = hasMember == null ? new ArrayList<>() : new ArrayList<>(hasMember);
            return this;
        }

        /**
         * Adds a {@code hasMember} value.
         *
         * @param hasMember the value to add
         * @return this builder
         */
        public Builder addHasMember(Reference hasMember) {
            this.hasMember.add(Objects.requireNonNull(hasMember, "hasMember"));
            return this;
        }

        /**
         * Replaces all {@code component} values.
         *
         * @param component the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder component(List<Component> component) {
            this.component = component == null ? new ArrayList<>() : new ArrayList<>(component);
            return this;
        }

        /**
         * Adds a {@code component} value.
         *
         * @param component the value to add
         * @return this builder
         */
        public Builder addComponent(Component component) {
            this.component.add(Objects.requireNonNull(component, "component"));
            return this;
        }

        /**
         * Builds the {@code ObservationDefinition}.
         *
         * @return the {@code ObservationDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public ObservationDefinition build() {
            return new ObservationDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, approvalDate,
                    lastReviewDate, effectivePeriod, derivedFromCanonical, derivedFromUri, subject, performerType,
                    category, code, permittedDataType, multipleResultsAllowed, bodySite, method, specimen, device,
                    preferredReportName, permittedUnit, qualifiedValue, hasMember, component);
        }
    }
}
