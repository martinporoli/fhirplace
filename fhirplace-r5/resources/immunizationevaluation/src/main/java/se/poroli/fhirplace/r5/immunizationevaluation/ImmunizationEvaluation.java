package se.poroli.fhirplace.r5.immunizationevaluation;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * Describes a comparison of an immunization event against published recommendations to determine if the
 * administration is "valid" in relation to those recommendations.
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
 * @param status completed | entered-in-error. Required. Modifier element.
 * @param patient Who this evaluation is for. Reference to Patient. Required.
 * @param date Date evaluation was performed.
 * @param authority Who is responsible for publishing the recommendations. Reference to Organization.
 * @param targetDisease The vaccine preventable disease schedule being evaluated. Required.
 * @param immunizationEvent Immunization being evaluated. Reference to Immunization. Required.
 * @param doseStatus Status of the dose relative to published recommendations. Required.
 * @param doseStatusReason Reason why the doese is considered valid, invalid or some other status.
 * @param description Evaluation notes.
 * @param series Name of vaccine series.
 * @param doseNumber Dose number within series.
 * @param seriesDoses Recommended number of doses for immunity.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ImmunizationEvaluation">FHIR R5 ImmunizationEvaluation</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record ImmunizationEvaluation(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<ImmunizationEvaluationStatusCodes> status,
        Reference patient,
        FhirDateTime date,
        Reference authority,
        CodeableConcept targetDisease,
        Reference immunizationEvent,
        CodeableConcept doseStatus,
        List<CodeableConcept> doseStatusReason,
        FhirMarkdown description,
        FhirString series,
        FhirString doseNumber,
        FhirString seriesDoses) implements DomainResource {

    /**
     * Creates an {@code ImmunizationEvaluation}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public ImmunizationEvaluation {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        doseStatusReason = doseStatusReason == null ? List.of() : List.copyOf(doseStatusReason);
        Objects.requireNonNull(status, "ImmunizationEvaluation.status is required");
        Objects.requireNonNull(patient, "ImmunizationEvaluation.patient is required");
        Objects.requireNonNull(targetDisease, "ImmunizationEvaluation.targetDisease is required");
        Objects.requireNonNull(immunizationEvent, "ImmunizationEvaluation.immunizationEvent is required");
        Objects.requireNonNull(doseStatus, "ImmunizationEvaluation.doseStatus is required");
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
     * Returns a builder initialized with the values of this {@code ImmunizationEvaluation}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link ImmunizationEvaluation}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<ImmunizationEvaluationStatusCodes> status;
        private Reference patient;
        private FhirDateTime date;
        private Reference authority;
        private CodeableConcept targetDisease;
        private Reference immunizationEvent;
        private CodeableConcept doseStatus;
        private List<CodeableConcept> doseStatusReason = new ArrayList<>();
        private FhirMarkdown description;
        private FhirString series;
        private FhirString doseNumber;
        private FhirString seriesDoses;

        private Builder() {
        }

        private Builder(ImmunizationEvaluation original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.status = original.status();
            this.patient = original.patient();
            this.date = original.date();
            this.authority = original.authority();
            this.targetDisease = original.targetDisease();
            this.immunizationEvent = original.immunizationEvent();
            this.doseStatus = original.doseStatus();
            this.doseStatusReason = new ArrayList<>(original.doseStatusReason());
            this.description = original.description();
            this.series = original.series();
            this.doseNumber = original.doseNumber();
            this.seriesDoses = original.seriesDoses();
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<ImmunizationEvaluationStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(ImmunizationEvaluationStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code patient}.
         *
         * @param patient the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder patient(Reference patient) {
            this.patient = patient;
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
         * Sets {@code authority}.
         *
         * @param authority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authority(Reference authority) {
            this.authority = authority;
            return this;
        }

        /**
         * Sets {@code targetDisease}.
         *
         * @param targetDisease the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder targetDisease(CodeableConcept targetDisease) {
            this.targetDisease = targetDisease;
            return this;
        }

        /**
         * Sets {@code immunizationEvent}.
         *
         * @param immunizationEvent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder immunizationEvent(Reference immunizationEvent) {
            this.immunizationEvent = immunizationEvent;
            return this;
        }

        /**
         * Sets {@code doseStatus}.
         *
         * @param doseStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder doseStatus(CodeableConcept doseStatus) {
            this.doseStatus = doseStatus;
            return this;
        }

        /**
         * Replaces all {@code doseStatusReason} values.
         *
         * @param doseStatusReason the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder doseStatusReason(List<CodeableConcept> doseStatusReason) {
            this.doseStatusReason = doseStatusReason == null ? new ArrayList<>() : new ArrayList<>(doseStatusReason);
            return this;
        }

        /**
         * Adds a {@code doseStatusReason} value.
         *
         * @param doseStatusReason the value to add
         * @return this builder
         */
        public Builder addDoseStatusReason(CodeableConcept doseStatusReason) {
            this.doseStatusReason.add(Objects.requireNonNull(doseStatusReason, "doseStatusReason"));
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
         * Sets {@code series}.
         *
         * @param series the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder series(FhirString series) {
            this.series = series;
            return this;
        }

        /**
         * Sets {@code series}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param series the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder series(String series) {
            return series(series == null ? null : FhirString.of(series));
        }

        /**
         * Sets {@code doseNumber}.
         *
         * @param doseNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder doseNumber(FhirString doseNumber) {
            this.doseNumber = doseNumber;
            return this;
        }

        /**
         * Sets {@code doseNumber}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param doseNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder doseNumber(String doseNumber) {
            return doseNumber(doseNumber == null ? null : FhirString.of(doseNumber));
        }

        /**
         * Sets {@code seriesDoses}.
         *
         * @param seriesDoses the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder seriesDoses(FhirString seriesDoses) {
            this.seriesDoses = seriesDoses;
            return this;
        }

        /**
         * Sets {@code seriesDoses}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param seriesDoses the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder seriesDoses(String seriesDoses) {
            return seriesDoses(seriesDoses == null ? null : FhirString.of(seriesDoses));
        }

        /**
         * Builds the {@code ImmunizationEvaluation}.
         *
         * @return the {@code ImmunizationEvaluation}
         * @throws NullPointerException if a required element is absent
         */
        public ImmunizationEvaluation build() {
            return new ImmunizationEvaluation(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, patient, date, authority, targetDisease, immunizationEvent, doseStatus, doseStatusReason,
                    description, series, doseNumber, seriesDoses);
        }
    }
}
