package se.poroli.fhirplace.r5.guidanceresponse;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataRequirement;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * A guidance response is the formal response to a guidance request, including any output parameters returned by the
 * evaluation, as well as the description of any proposed actions to be taken.
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
 * @param requestIdentifier The identifier of the request associated with this response, if any.
 * @param identifier Business identifier.
 * @param module What guidance was requested. One of uri, canonical, CodeableConcept. Required.
 * @param status success | data-requested | data-required | in-progress | failure | entered-in-error. Required.
 *   Modifier element.
 * @param subject Patient the request was performed for. Reference to Patient, Group.
 * @param encounter Encounter during which the response was returned. Reference to Encounter.
 * @param occurrenceDateTime When the guidance response was processed.
 * @param performer Device returning the guidance. Reference to Device.
 * @param reason Why guidance is needed.
 * @param note Additional notes about the response.
 * @param evaluationMessage Messages resulting from the evaluation of the artifact or artifacts. Reference to
 *   OperationOutcome.
 * @param outputParameters The output parameters of the evaluation, if any. Reference to Parameters.
 * @param result Proposed actions, if any. Reference to Appointment, AppointmentResponse, CarePlan, Claim,
 *   CommunicationRequest, Contract, CoverageEligibilityRequest, DeviceRequest, EnrollmentRequest,
 *   ImmunizationRecommendation, MedicationRequest, NutritionOrder, RequestOrchestration, ServiceRequest,
 *   SupplyRequest, Task, VisionPrescription.
 * @param dataRequirement Additional required data.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/GuidanceResponse">FHIR R5 GuidanceResponse</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record GuidanceResponse(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        Identifier requestIdentifier,
        List<Identifier> identifier,
        DataType module,
        FhirEnum<GuidanceResponseStatus> status,
        Reference subject,
        Reference encounter,
        FhirDateTime occurrenceDateTime,
        Reference performer,
        List<CodeableReference> reason,
        List<Annotation> note,
        Reference evaluationMessage,
        Reference outputParameters,
        List<Reference> result,
        List<DataRequirement> dataRequirement) implements DomainResource {

    /**
     * Creates a {@code GuidanceResponse}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public GuidanceResponse {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        reason = reason == null ? List.of() : List.copyOf(reason);
        note = note == null ? List.of() : List.copyOf(note);
        result = result == null ? List.of() : List.copyOf(result);
        dataRequirement = dataRequirement == null ? List.of() : List.copyOf(dataRequirement);
        Objects.requireNonNull(module, "GuidanceResponse.module is required");
        Objects.requireNonNull(status, "GuidanceResponse.status is required");
        if (module != null && !(module instanceof FhirUri
                || module instanceof FhirCanonical
                || module instanceof CodeableConcept)) {
            throw new IllegalArgumentException(
                    "GuidanceResponse.module[x] must be one of uri, canonical, CodeableConcept, but was "
                            + module.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code GuidanceResponse}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link GuidanceResponse}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private Identifier requestIdentifier;
        private List<Identifier> identifier = new ArrayList<>();
        private DataType module;
        private FhirEnum<GuidanceResponseStatus> status;
        private Reference subject;
        private Reference encounter;
        private FhirDateTime occurrenceDateTime;
        private Reference performer;
        private List<CodeableReference> reason = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private Reference evaluationMessage;
        private Reference outputParameters;
        private List<Reference> result = new ArrayList<>();
        private List<DataRequirement> dataRequirement = new ArrayList<>();

        private Builder() {
        }

        private Builder(GuidanceResponse original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.requestIdentifier = original.requestIdentifier();
            this.identifier = new ArrayList<>(original.identifier());
            this.module = original.module();
            this.status = original.status();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.occurrenceDateTime = original.occurrenceDateTime();
            this.performer = original.performer();
            this.reason = new ArrayList<>(original.reason());
            this.note = new ArrayList<>(original.note());
            this.evaluationMessage = original.evaluationMessage();
            this.outputParameters = original.outputParameters();
            this.result = new ArrayList<>(original.result());
            this.dataRequirement = new ArrayList<>(original.dataRequirement());
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
         * Sets {@code requestIdentifier}.
         *
         * @param requestIdentifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requestIdentifier(Identifier requestIdentifier) {
            this.requestIdentifier = requestIdentifier;
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
         * Sets {@code module} to a uri.
         *
         * @param module the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder module(FhirUri module) {
            this.module = module;
            return this;
        }

        /**
         * Sets {@code module} to a canonical.
         *
         * @param module the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder module(FhirCanonical module) {
            this.module = module;
            return this;
        }

        /**
         * Sets {@code module} to a CodeableConcept.
         *
         * @param module the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder module(CodeableConcept module) {
            this.module = module;
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<GuidanceResponseStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(GuidanceResponseStatus status) {
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
         * Sets {@code occurrenceDateTime}.
         *
         * @param occurrenceDateTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrenceDateTime(FhirDateTime occurrenceDateTime) {
            this.occurrenceDateTime = occurrenceDateTime;
            return this;
        }

        /**
         * Sets {@code occurrenceDateTime}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param occurrenceDateTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrenceDateTime(Temporal occurrenceDateTime) {
            return occurrenceDateTime(occurrenceDateTime == null ? null : FhirDateTime.of(occurrenceDateTime));
        }

        /**
         * Sets {@code performer}.
         *
         * @param performer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder performer(Reference performer) {
            this.performer = performer;
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
         * Sets {@code evaluationMessage}.
         *
         * @param evaluationMessage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder evaluationMessage(Reference evaluationMessage) {
            this.evaluationMessage = evaluationMessage;
            return this;
        }

        /**
         * Sets {@code outputParameters}.
         *
         * @param outputParameters the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outputParameters(Reference outputParameters) {
            this.outputParameters = outputParameters;
            return this;
        }

        /**
         * Replaces all {@code result} values.
         *
         * @param result the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder result(List<Reference> result) {
            this.result = result == null ? new ArrayList<>() : new ArrayList<>(result);
            return this;
        }

        /**
         * Adds a {@code result} value.
         *
         * @param result the value to add
         * @return this builder
         */
        public Builder addResult(Reference result) {
            this.result.add(Objects.requireNonNull(result, "result"));
            return this;
        }

        /**
         * Replaces all {@code dataRequirement} values.
         *
         * @param dataRequirement the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder dataRequirement(List<DataRequirement> dataRequirement) {
            this.dataRequirement = dataRequirement == null ? new ArrayList<>() : new ArrayList<>(dataRequirement);
            return this;
        }

        /**
         * Adds a {@code dataRequirement} value.
         *
         * @param dataRequirement the value to add
         * @return this builder
         */
        public Builder addDataRequirement(DataRequirement dataRequirement) {
            this.dataRequirement.add(Objects.requireNonNull(dataRequirement, "dataRequirement"));
            return this;
        }

        /**
         * Builds the {@code GuidanceResponse}.
         *
         * @return the {@code GuidanceResponse}
         * @throws NullPointerException if a required element is absent
         */
        public GuidanceResponse build() {
            return new GuidanceResponse(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension,
                    requestIdentifier, identifier, module, status, subject, encounter, occurrenceDateTime, performer,
                    reason, note, evaluationMessage, outputParameters, result, dataRequirement);
        }
    }
}
