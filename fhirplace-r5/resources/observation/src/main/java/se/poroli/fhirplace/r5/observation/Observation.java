package se.poroli.fhirplace.r5.observation;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
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
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.RatioRange;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.datatypes.TriggerDefinition;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.ObservationStatus;

/**
 * Measurements and simple assertions made about a patient, device or other subject.
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
 * @param identifier Business Identifier for observation.
 * @param instantiates Instantiates FHIR ObservationDefinition. One of canonical, Reference.
 * @param basedOn Fulfills plan, proposal or order. Reference to CarePlan, DeviceRequest, ImmunizationRecommendation,
 *   MedicationRequest, NutritionOrder, ServiceRequest.
 * @param triggeredBy Triggering observation(s).
 * @param partOf Part of referenced event. Reference to MedicationAdministration, MedicationDispense,
 *   MedicationStatement, Procedure, Immunization, ImagingStudy, GenomicStudy.
 * @param status registered | preliminary | final | amended +. Required. Modifier element.
 * @param category Classification of type of observation.
 * @param code Type of observation (code / type). Required.
 * @param subject Who and/or what the observation is about. Reference to Patient, Group, Device, Location,
 *   Organization, Procedure, Practitioner, Medication, Substance, BiologicallyDerivedProduct, NutritionProduct.
 * @param focus What the observation is about, when it is not about the subject of record. Reference to Resource.
 * @param encounter Healthcare event during which this observation is made. Reference to Encounter.
 * @param effective Clinically relevant time/time-period for observation. One of dateTime, Period, Timing, instant.
 * @param issued Date/Time this version was made available.
 * @param performer Who is responsible for the observation. Reference to Practitioner, PractitionerRole, Organization,
 *   CareTeam, Patient, RelatedPerson.
 * @param value Actual result. Any datatype except FhirInteger64, FhirPositiveInt, FhirUnsignedInt, FhirDecimal,
 *   FhirMarkdown, FhirCode, FhirId, FhirUri, FhirUrl, FhirCanonical, FhirOid, FhirUuid, FhirBase64Binary,
 *   FhirInstant, FhirDate, FhirEnum, Identifier, HumanName, Address, ContactPoint, Timing, RatioRange, Coding, Age,
 *   Distance, Duration, Count, Money, Annotation, Signature, ContactDetail, Contributor, DataRequirement,
 *   ParameterDefinition, RelatedArtifact, TriggerDefinition, UsageContext, Expression, ExtendedContactDetail,
 *   VirtualServiceDetail, Availability, MonetaryComponent, CodeableReference, Narrative, Extension, Meta, Dosage,
 *   ElementDefinition, ProductShelfLife, MarketingStatus.
 * @param dataAbsentReason Why the result is missing.
 * @param interpretation High, low, normal, etc.
 * @param note Comments about the observation.
 * @param bodySite Observed body part.
 * @param bodyStructure Observed body structure. Reference to BodyStructure.
 * @param method How it was done.
 * @param specimen Specimen used for this observation. Reference to Specimen, Group.
 * @param device A reference to the device that generates the measurements or the device settings for the device.
 *   Reference to Device, DeviceMetric.
 * @param referenceRange Provides guide for interpretation.
 * @param hasMember Related resource that belongs to the Observation group. Reference to Observation,
 *   QuestionnaireResponse, MolecularSequence.
 * @param derivedFrom Related resource from which the observation is made. Reference to DocumentReference,
 *   ImagingStudy, ImagingSelection, QuestionnaireResponse, Observation, MolecularSequence, GenomicStudy.
 * @param component Component results.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Observation">FHIR R5 Observation</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Observation(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        DataType instantiates,
        List<Reference> basedOn,
        List<TriggeredBy> triggeredBy,
        List<Reference> partOf,
        FhirEnum<ObservationStatus> status,
        List<CodeableConcept> category,
        CodeableConcept code,
        Reference subject,
        List<Reference> focus,
        Reference encounter,
        DataType effective,
        FhirInstant issued,
        List<Reference> performer,
        DataType value,
        CodeableConcept dataAbsentReason,
        List<CodeableConcept> interpretation,
        List<Annotation> note,
        CodeableConcept bodySite,
        Reference bodyStructure,
        CodeableConcept method,
        Reference specimen,
        Reference device,
        List<ReferenceRange> referenceRange,
        List<Reference> hasMember,
        List<Reference> derivedFrom,
        List<Component> component) implements DomainResource {

    /**
     * Creates an {@code Observation}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Observation {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        triggeredBy = triggeredBy == null ? List.of() : List.copyOf(triggeredBy);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        category = category == null ? List.of() : List.copyOf(category);
        focus = focus == null ? List.of() : List.copyOf(focus);
        performer = performer == null ? List.of() : List.copyOf(performer);
        interpretation = interpretation == null ? List.of() : List.copyOf(interpretation);
        note = note == null ? List.of() : List.copyOf(note);
        referenceRange = referenceRange == null ? List.of() : List.copyOf(referenceRange);
        hasMember = hasMember == null ? List.of() : List.copyOf(hasMember);
        derivedFrom = derivedFrom == null ? List.of() : List.copyOf(derivedFrom);
        component = component == null ? List.of() : List.copyOf(component);
        Objects.requireNonNull(status, "Observation.status is required");
        Objects.requireNonNull(code, "Observation.code is required");
        if (instantiates != null && !(instantiates instanceof FhirCanonical || instantiates instanceof Reference)) {
            throw new IllegalArgumentException(
                    "Observation.instantiates[x] must be one of canonical, Reference, but was "
                            + instantiates.getClass().getSimpleName());
        }
        if (effective != null && !(effective instanceof FhirDateTime
                || effective instanceof Period
                || effective instanceof Timing
                || effective instanceof FhirInstant)) {
            throw new IllegalArgumentException(
                    "Observation.effective[x] must be one of dateTime, Period, Timing, instant, but was "
                            + effective.getClass().getSimpleName());
        }
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
                || value instanceof FhirBase64Binary
                || value instanceof FhirInstant
                || value instanceof FhirDate
                || value instanceof FhirEnum<?>
                || value instanceof Identifier
                || value instanceof HumanName
                || value instanceof Address
                || value instanceof ContactPoint
                || value instanceof Timing
                || value instanceof RatioRange
                || value instanceof Coding
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
                    "Observation.value[x] does not allow "
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
     * Returns a builder initialized with the values of this {@code Observation}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Identifies the observation(s) that triggered the performance of this observation.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param observation Triggering observation. Reference to Observation. Required.
     * @param type reflex | repeat | re-run. Required.
     * @param reason Reason that the observation was triggered.
     */
    public record TriggeredBy(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference observation,
            FhirEnum<TriggeredBytype> type,
            FhirString reason) implements BackboneElement {

        /**
         * Creates a {@code TriggeredBy}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public TriggeredBy {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(observation, "Observation.triggeredBy.observation is required");
            Objects.requireNonNull(type, "Observation.triggeredBy.type is required");
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
         * Returns a builder initialized with the values of this {@code TriggeredBy}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link TriggeredBy}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference observation;
            private FhirEnum<TriggeredBytype> type;
            private FhirString reason;

            private Builder() {
            }

            private Builder(TriggeredBy original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.observation = original.observation();
                this.type = original.type();
                this.reason = original.reason();
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
             * Sets {@code observation}.
             *
             * @param observation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder observation(Reference observation) {
                this.observation = observation;
                return this;
            }

            /**
             * Sets {@code type}.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(FhirEnum<TriggeredBytype> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(TriggeredBytype type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Sets {@code reason}.
             *
             * @param reason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reason(FhirString reason) {
                this.reason = reason;
                return this;
            }

            /**
             * Sets {@code reason}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param reason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reason(String reason) {
                return reason(reason == null ? null : FhirString.of(reason));
            }

            /**
             * Builds the {@code TriggeredBy}.
             *
             * @return the {@code TriggeredBy}
             * @throws NullPointerException if a required element is absent
             */
            public TriggeredBy build() {
                return new TriggeredBy(
                        id, extension, modifierExtension, observation, type, reason);
            }
        }
    }

    /**
     * Guidance on how to interpret the value by comparison to a normal or recommended range.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param low Low Range, if relevant.
     * @param high High Range, if relevant.
     * @param normalValue Normal value, if relevant.
     * @param type Reference range qualifier.
     * @param appliesTo Reference range population.
     * @param age Applicable age range, if relevant.
     * @param text Text based reference range in an observation.
     */
    public record ReferenceRange(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Quantity low,
            Quantity high,
            CodeableConcept normalValue,
            CodeableConcept type,
            List<CodeableConcept> appliesTo,
            Range age,
            FhirMarkdown text) implements BackboneElement {

        /**
         * Creates a {@code ReferenceRange}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public ReferenceRange {
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
         * Returns a builder initialized with the values of this {@code ReferenceRange}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ReferenceRange}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Quantity low;
            private Quantity high;
            private CodeableConcept normalValue;
            private CodeableConcept type;
            private List<CodeableConcept> appliesTo = new ArrayList<>();
            private Range age;
            private FhirMarkdown text;

            private Builder() {
            }

            private Builder(ReferenceRange original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.low = original.low();
                this.high = original.high();
                this.normalValue = original.normalValue();
                this.type = original.type();
                this.appliesTo = new ArrayList<>(original.appliesTo());
                this.age = original.age();
                this.text = original.text();
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
             * Sets {@code low}.
             *
             * @param low the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder low(Quantity low) {
                this.low = low;
                return this;
            }

            /**
             * Sets {@code high}.
             *
             * @param high the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder high(Quantity high) {
                this.high = high;
                return this;
            }

            /**
             * Sets {@code normalValue}.
             *
             * @param normalValue the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder normalValue(CodeableConcept normalValue) {
                this.normalValue = normalValue;
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
             * Sets {@code text}.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(FhirMarkdown text) {
                this.text = text;
                return this;
            }

            /**
             * Sets {@code text}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(String text) {
                return text(text == null ? null : FhirMarkdown.of(text));
            }

            /**
             * Builds the {@code ReferenceRange}.
             *
             * @return the {@code ReferenceRange}
             */
            public ReferenceRange build() {
                return new ReferenceRange(
                        id, extension, modifierExtension, low, high, normalValue, type, appliesTo, age, text);
            }
        }
    }

    /**
     * Some observations have multiple component observations.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Type of component observation (code / type). Required.
     * @param value Actual component result. Any datatype except FhirInteger64, FhirPositiveInt, FhirUnsignedInt,
     *   FhirDecimal, FhirMarkdown, FhirCode, FhirId, FhirUri, FhirUrl, FhirCanonical, FhirOid, FhirUuid,
     *   FhirBase64Binary, FhirInstant, FhirDate, FhirEnum, Identifier, HumanName, Address, ContactPoint, Timing,
     *   RatioRange, Coding, Age, Distance, Duration, Count, Money, Annotation, Signature, ContactDetail, Contributor,
     *   DataRequirement, ParameterDefinition, RelatedArtifact, TriggerDefinition, UsageContext, Expression,
     *   ExtendedContactDetail, VirtualServiceDetail, Availability, MonetaryComponent, CodeableReference, Narrative,
     *   Extension, Meta, Dosage, ElementDefinition, ProductShelfLife, MarketingStatus.
     * @param dataAbsentReason Why the component result is missing.
     * @param interpretation High, low, normal, etc.
     * @param referenceRange Provides guide for interpretation of component result.
     */
    public record Component(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            DataType value,
            CodeableConcept dataAbsentReason,
            List<CodeableConcept> interpretation,
            List<Observation.ReferenceRange> referenceRange) implements BackboneElement {

        /**
         * Creates a {@code Component}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Component {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            interpretation = interpretation == null ? List.of() : List.copyOf(interpretation);
            referenceRange = referenceRange == null ? List.of() : List.copyOf(referenceRange);
            Objects.requireNonNull(code, "Observation.component.code is required");
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
                    || value instanceof FhirBase64Binary
                    || value instanceof FhirInstant
                    || value instanceof FhirDate
                    || value instanceof FhirEnum<?>
                    || value instanceof Identifier
                    || value instanceof HumanName
                    || value instanceof Address
                    || value instanceof ContactPoint
                    || value instanceof Timing
                    || value instanceof RatioRange
                    || value instanceof Coding
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
                        "Observation.component.value[x] does not allow "
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
            private DataType value;
            private CodeableConcept dataAbsentReason;
            private List<CodeableConcept> interpretation = new ArrayList<>();
            private List<Observation.ReferenceRange> referenceRange = new ArrayList<>();

            private Builder() {
            }

            private Builder(Component original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.value = original.value();
                this.dataAbsentReason = original.dataAbsentReason();
                this.interpretation = new ArrayList<>(original.interpretation());
                this.referenceRange = new ArrayList<>(original.referenceRange());
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
             * Sets {@code dataAbsentReason}.
             *
             * @param dataAbsentReason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dataAbsentReason(CodeableConcept dataAbsentReason) {
                this.dataAbsentReason = dataAbsentReason;
                return this;
            }

            /**
             * Replaces all {@code interpretation} values.
             *
             * @param interpretation the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder interpretation(List<CodeableConcept> interpretation) {
                this.interpretation = interpretation == null ? new ArrayList<>() : new ArrayList<>(interpretation);
                return this;
            }

            /**
             * Adds a {@code interpretation} value.
             *
             * @param interpretation the value to add
             * @return this builder
             */
            public Builder addInterpretation(CodeableConcept interpretation) {
                this.interpretation.add(Objects.requireNonNull(interpretation, "interpretation"));
                return this;
            }

            /**
             * Replaces all {@code referenceRange} values.
             *
             * @param referenceRange the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder referenceRange(List<Observation.ReferenceRange> referenceRange) {
                this.referenceRange = referenceRange == null ? new ArrayList<>() : new ArrayList<>(referenceRange);
                return this;
            }

            /**
             * Adds a {@code referenceRange} value.
             *
             * @param referenceRange the value to add
             * @return this builder
             */
            public Builder addReferenceRange(Observation.ReferenceRange referenceRange) {
                this.referenceRange.add(Objects.requireNonNull(referenceRange, "referenceRange"));
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
                        id, extension, modifierExtension, code, value, dataAbsentReason, interpretation,
                        referenceRange);
            }
        }
    }

    /** Builder for {@link Observation}. Builders are mutable and not thread-safe. */
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
        private DataType instantiates;
        private List<Reference> basedOn = new ArrayList<>();
        private List<TriggeredBy> triggeredBy = new ArrayList<>();
        private List<Reference> partOf = new ArrayList<>();
        private FhirEnum<ObservationStatus> status;
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableConcept code;
        private Reference subject;
        private List<Reference> focus = new ArrayList<>();
        private Reference encounter;
        private DataType effective;
        private FhirInstant issued;
        private List<Reference> performer = new ArrayList<>();
        private DataType value;
        private CodeableConcept dataAbsentReason;
        private List<CodeableConcept> interpretation = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private CodeableConcept bodySite;
        private Reference bodyStructure;
        private CodeableConcept method;
        private Reference specimen;
        private Reference device;
        private List<ReferenceRange> referenceRange = new ArrayList<>();
        private List<Reference> hasMember = new ArrayList<>();
        private List<Reference> derivedFrom = new ArrayList<>();
        private List<Component> component = new ArrayList<>();

        private Builder() {
        }

        private Builder(Observation original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.instantiates = original.instantiates();
            this.basedOn = new ArrayList<>(original.basedOn());
            this.triggeredBy = new ArrayList<>(original.triggeredBy());
            this.partOf = new ArrayList<>(original.partOf());
            this.status = original.status();
            this.category = new ArrayList<>(original.category());
            this.code = original.code();
            this.subject = original.subject();
            this.focus = new ArrayList<>(original.focus());
            this.encounter = original.encounter();
            this.effective = original.effective();
            this.issued = original.issued();
            this.performer = new ArrayList<>(original.performer());
            this.value = original.value();
            this.dataAbsentReason = original.dataAbsentReason();
            this.interpretation = new ArrayList<>(original.interpretation());
            this.note = new ArrayList<>(original.note());
            this.bodySite = original.bodySite();
            this.bodyStructure = original.bodyStructure();
            this.method = original.method();
            this.specimen = original.specimen();
            this.device = original.device();
            this.referenceRange = new ArrayList<>(original.referenceRange());
            this.hasMember = new ArrayList<>(original.hasMember());
            this.derivedFrom = new ArrayList<>(original.derivedFrom());
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
         * Sets {@code instantiates} to a canonical.
         *
         * @param instantiates the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiates(FhirCanonical instantiates) {
            this.instantiates = instantiates;
            return this;
        }

        /**
         * Sets {@code instantiates} to a Reference.
         *
         * @param instantiates the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiates(Reference instantiates) {
            this.instantiates = instantiates;
            return this;
        }

        /**
         * Sets {@code instantiates} to a canonical without id or extensions.
         *
         * @param instantiates the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiates(String instantiates) {
            this.instantiates = instantiates == null ? null : FhirCanonical.of(instantiates);
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
         * Replaces all {@code triggeredBy} values.
         *
         * @param triggeredBy the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder triggeredBy(List<TriggeredBy> triggeredBy) {
            this.triggeredBy = triggeredBy == null ? new ArrayList<>() : new ArrayList<>(triggeredBy);
            return this;
        }

        /**
         * Adds a {@code triggeredBy} value.
         *
         * @param triggeredBy the value to add
         * @return this builder
         */
        public Builder addTriggeredBy(TriggeredBy triggeredBy) {
            this.triggeredBy.add(Objects.requireNonNull(triggeredBy, "triggeredBy"));
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
        public Builder status(FhirEnum<ObservationStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(ObservationStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Replaces all {@code focus} values.
         *
         * @param focus the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder focus(List<Reference> focus) {
            this.focus = focus == null ? new ArrayList<>() : new ArrayList<>(focus);
            return this;
        }

        /**
         * Adds a {@code focus} value.
         *
         * @param focus the value to add
         * @return this builder
         */
        public Builder addFocus(Reference focus) {
            this.focus.add(Objects.requireNonNull(focus, "focus"));
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
         * Sets {@code effective} to a dateTime.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(FhirDateTime effective) {
            this.effective = effective;
            return this;
        }

        /**
         * Sets {@code effective} to a Period.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(Period effective) {
            this.effective = effective;
            return this;
        }

        /**
         * Sets {@code effective} to a Timing.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(Timing effective) {
            this.effective = effective;
            return this;
        }

        /**
         * Sets {@code effective} to a instant.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(FhirInstant effective) {
            this.effective = effective;
            return this;
        }

        /**
         * Sets {@code effective} to a dateTime without id or extensions.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(Temporal effective) {
            this.effective = effective == null ? null : FhirDateTime.of(effective);
            return this;
        }

        /**
         * Sets {@code effective} to a instant without id or extensions.
         *
         * @param effective the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effective(OffsetDateTime effective) {
            this.effective = effective == null ? null : FhirInstant.of(effective);
            return this;
        }

        /**
         * Sets {@code issued}.
         *
         * @param issued the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issued(FhirInstant issued) {
            this.issued = issued;
            return this;
        }

        /**
         * Sets {@code issued}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param issued the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issued(OffsetDateTime issued) {
            return issued(issued == null ? null : FhirInstant.of(issued));
        }

        /**
         * Replaces all {@code performer} values.
         *
         * @param performer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder performer(List<Reference> performer) {
            this.performer = performer == null ? new ArrayList<>() : new ArrayList<>(performer);
            return this;
        }

        /**
         * Adds a {@code performer} value.
         *
         * @param performer the value to add
         * @return this builder
         */
        public Builder addPerformer(Reference performer) {
            this.performer.add(Objects.requireNonNull(performer, "performer"));
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
         * Sets {@code dataAbsentReason}.
         *
         * @param dataAbsentReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dataAbsentReason(CodeableConcept dataAbsentReason) {
            this.dataAbsentReason = dataAbsentReason;
            return this;
        }

        /**
         * Replaces all {@code interpretation} values.
         *
         * @param interpretation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder interpretation(List<CodeableConcept> interpretation) {
            this.interpretation = interpretation == null ? new ArrayList<>() : new ArrayList<>(interpretation);
            return this;
        }

        /**
         * Adds a {@code interpretation} value.
         *
         * @param interpretation the value to add
         * @return this builder
         */
        public Builder addInterpretation(CodeableConcept interpretation) {
            this.interpretation.add(Objects.requireNonNull(interpretation, "interpretation"));
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
         * Sets {@code bodyStructure}.
         *
         * @param bodyStructure the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder bodyStructure(Reference bodyStructure) {
            this.bodyStructure = bodyStructure;
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
         * Sets {@code specimen}.
         *
         * @param specimen the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder specimen(Reference specimen) {
            this.specimen = specimen;
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
         * Replaces all {@code referenceRange} values.
         *
         * @param referenceRange the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder referenceRange(List<ReferenceRange> referenceRange) {
            this.referenceRange = referenceRange == null ? new ArrayList<>() : new ArrayList<>(referenceRange);
            return this;
        }

        /**
         * Adds a {@code referenceRange} value.
         *
         * @param referenceRange the value to add
         * @return this builder
         */
        public Builder addReferenceRange(ReferenceRange referenceRange) {
            this.referenceRange.add(Objects.requireNonNull(referenceRange, "referenceRange"));
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
         * Replaces all {@code derivedFrom} values.
         *
         * @param derivedFrom the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder derivedFrom(List<Reference> derivedFrom) {
            this.derivedFrom = derivedFrom == null ? new ArrayList<>() : new ArrayList<>(derivedFrom);
            return this;
        }

        /**
         * Adds a {@code derivedFrom} value.
         *
         * @param derivedFrom the value to add
         * @return this builder
         */
        public Builder addDerivedFrom(Reference derivedFrom) {
            this.derivedFrom.add(Objects.requireNonNull(derivedFrom, "derivedFrom"));
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
         * Builds the {@code Observation}.
         *
         * @return the {@code Observation}
         * @throws NullPointerException if a required element is absent
         */
        public Observation build() {
            return new Observation(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiates, basedOn, triggeredBy, partOf, status, category, code, subject, focus, encounter,
                    effective, issued, performer, value, dataAbsentReason, interpretation, note, bodySite,
                    bodyStructure, method, specimen, device, referenceRange, hasMember, derivedFrom, component);
        }
    }
}
