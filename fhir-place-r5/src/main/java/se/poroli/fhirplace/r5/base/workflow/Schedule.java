package se.poroli.fhirplace.r5.base.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * A container for slots of time that may be available for booking appointments.
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
 * @param identifier External Ids for this item.
 * @param active Whether this schedule is in active use. Modifier element.
 * @param serviceCategory High-level category.
 * @param serviceType Specific service.
 * @param specialty Type of specialty needed.
 * @param name Human-readable label.
 * @param actor Resource(s) that availability information is being provided for. Reference to Patient, Practitioner,
 *   PractitionerRole, CareTeam, RelatedPerson, Device, HealthcareService, Location. Required.
 * @param planningHorizon Period of time covered by schedule.
 * @param comment Comments on availability.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Schedule">FHIR R5 Schedule</a>
 */
public record Schedule(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirBoolean active,
        List<CodeableConcept> serviceCategory,
        List<CodeableReference> serviceType,
        List<CodeableConcept> specialty,
        FhirString name,
        List<Reference> actor,
        Period planningHorizon,
        FhirMarkdown comment) implements DomainResource {

    /**
     * Creates a {@code Schedule}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     * @throws IllegalArgumentException if a required list is empty
     */
    public Schedule {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        serviceCategory = serviceCategory == null ? List.of() : List.copyOf(serviceCategory);
        serviceType = serviceType == null ? List.of() : List.copyOf(serviceType);
        specialty = specialty == null ? List.of() : List.copyOf(specialty);
        actor = actor == null ? List.of() : List.copyOf(actor);
        if (actor.isEmpty()) {
            throw new IllegalArgumentException("Schedule.actor requires at least one value");
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
     * Returns a builder initialized with the values of this {@code Schedule}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Schedule}. Builders are mutable and not thread-safe. */
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
        private FhirBoolean active;
        private List<CodeableConcept> serviceCategory = new ArrayList<>();
        private List<CodeableReference> serviceType = new ArrayList<>();
        private List<CodeableConcept> specialty = new ArrayList<>();
        private FhirString name;
        private List<Reference> actor = new ArrayList<>();
        private Period planningHorizon;
        private FhirMarkdown comment;

        private Builder() {
        }

        private Builder(Schedule original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.active = original.active();
            this.serviceCategory = new ArrayList<>(original.serviceCategory());
            this.serviceType = new ArrayList<>(original.serviceType());
            this.specialty = new ArrayList<>(original.specialty());
            this.name = original.name();
            this.actor = new ArrayList<>(original.actor());
            this.planningHorizon = original.planningHorizon();
            this.comment = original.comment();
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
         * Sets {@code active}.
         *
         * @param active the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder active(FhirBoolean active) {
            this.active = active;
            return this;
        }

        /**
         * Sets {@code active}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param active the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder active(Boolean active) {
            return active(active == null ? null : FhirBoolean.of(active));
        }

        /**
         * Replaces all {@code serviceCategory} values.
         *
         * @param serviceCategory the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder serviceCategory(List<CodeableConcept> serviceCategory) {
            this.serviceCategory = serviceCategory == null ? new ArrayList<>() : new ArrayList<>(serviceCategory);
            return this;
        }

        /**
         * Adds a {@code serviceCategory} value.
         *
         * @param serviceCategory the value to add
         * @return this builder
         */
        public Builder addServiceCategory(CodeableConcept serviceCategory) {
            this.serviceCategory.add(Objects.requireNonNull(serviceCategory, "serviceCategory"));
            return this;
        }

        /**
         * Replaces all {@code serviceType} values.
         *
         * @param serviceType the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder serviceType(List<CodeableReference> serviceType) {
            this.serviceType = serviceType == null ? new ArrayList<>() : new ArrayList<>(serviceType);
            return this;
        }

        /**
         * Adds a {@code serviceType} value.
         *
         * @param serviceType the value to add
         * @return this builder
         */
        public Builder addServiceType(CodeableReference serviceType) {
            this.serviceType.add(Objects.requireNonNull(serviceType, "serviceType"));
            return this;
        }

        /**
         * Replaces all {@code specialty} values.
         *
         * @param specialty the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder specialty(List<CodeableConcept> specialty) {
            this.specialty = specialty == null ? new ArrayList<>() : new ArrayList<>(specialty);
            return this;
        }

        /**
         * Adds a {@code specialty} value.
         *
         * @param specialty the value to add
         * @return this builder
         */
        public Builder addSpecialty(CodeableConcept specialty) {
            this.specialty.add(Objects.requireNonNull(specialty, "specialty"));
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
         * Replaces all {@code actor} values.
         *
         * @param actor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder actor(List<Reference> actor) {
            this.actor = actor == null ? new ArrayList<>() : new ArrayList<>(actor);
            return this;
        }

        /**
         * Adds a {@code actor} value.
         *
         * @param actor the value to add
         * @return this builder
         */
        public Builder addActor(Reference actor) {
            this.actor.add(Objects.requireNonNull(actor, "actor"));
            return this;
        }

        /**
         * Sets {@code planningHorizon}.
         *
         * @param planningHorizon the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder planningHorizon(Period planningHorizon) {
            this.planningHorizon = planningHorizon;
            return this;
        }

        /**
         * Sets {@code comment}.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(FhirMarkdown comment) {
            this.comment = comment;
            return this;
        }

        /**
         * Sets {@code comment}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(String comment) {
            return comment(comment == null ? null : FhirMarkdown.of(comment));
        }

        /**
         * Builds the {@code Schedule}.
         *
         * @return the {@code Schedule}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public Schedule build() {
            return new Schedule(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    active, serviceCategory, serviceType, specialty, name, actor, planningHorizon, comment);
        }
    }
}
