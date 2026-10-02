package se.poroli.fhirplace.r5.allergyintolerance;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * Risk of harmful or undesirable, physiological response which is unique to an individual and associated with
 * exposure to a substance.
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
 * @param identifier External ids for this item.
 * @param clinicalStatus active | inactive | resolved. Modifier element.
 * @param verificationStatus unconfirmed | presumed | confirmed | refuted | entered-in-error. Modifier element.
 * @param type allergy | intolerance - Underlying mechanism (if known).
 * @param category food | medication | environment | biologic.
 * @param criticality low | high | unable-to-assess.
 * @param code Code that identifies the allergy or intolerance.
 * @param patient Who the allergy or intolerance is for. Reference to Patient. Required.
 * @param encounter Encounter when the allergy or intolerance was asserted. Reference to Encounter.
 * @param onset When allergy or intolerance was identified. One of dateTime, Age, Period, Range, string.
 * @param recordedDate Date allergy or intolerance was first recorded.
 * @param participant Who or what participated in the activities related to the allergy or intolerance and how they
 *   were involved.
 * @param lastOccurrence Date(/time) of last known occurrence of a reaction.
 * @param note Additional text not captured in other fields.
 * @param reaction Adverse Reaction Events linked to exposure to substance.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/AllergyIntolerance">FHIR R5 AllergyIntolerance</a>
 */
public record AllergyIntolerance(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        CodeableConcept clinicalStatus,
        CodeableConcept verificationStatus,
        CodeableConcept type,
        List<FhirEnum<AllergyIntoleranceCategory>> category,
        FhirEnum<AllergyIntoleranceCriticality> criticality,
        CodeableConcept code,
        Reference patient,
        Reference encounter,
        DataType onset,
        FhirDateTime recordedDate,
        List<Participant> participant,
        FhirDateTime lastOccurrence,
        List<Annotation> note,
        List<Reaction> reaction) implements DomainResource {

    /**
     * Creates an {@code AllergyIntolerance}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public AllergyIntolerance {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        category = category == null ? List.of() : List.copyOf(category);
        participant = participant == null ? List.of() : List.copyOf(participant);
        note = note == null ? List.of() : List.copyOf(note);
        reaction = reaction == null ? List.of() : List.copyOf(reaction);
        Objects.requireNonNull(patient, "AllergyIntolerance.patient is required");
        if (onset != null && !(onset instanceof FhirDateTime
                || onset instanceof Age
                || onset instanceof Period
                || onset instanceof Range
                || onset instanceof FhirString)) {
            throw new IllegalArgumentException(
                    "AllergyIntolerance.onset[x] must be one of dateTime, Age, Period, Range, string, but was "
                            + onset.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code AllergyIntolerance}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates who or what participated in the activities related to the allergy or intolerance and how they were
     * involved.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function Type of involvement.
     * @param actor Who or what participated in the activities related to the allergy or intolerance. Reference to
     *   Practitioner, PractitionerRole, Patient, RelatedPerson, Device, Organization, CareTeam. Required.
     */
    public record Participant(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept function,
            Reference actor) implements BackboneElement {

        /**
         * Creates a {@code Participant}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Participant {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(actor, "AllergyIntolerance.participant.actor is required");
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
            private CodeableConcept function;
            private Reference actor;

            private Builder() {
            }

            private Builder(Participant original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.function = original.function();
                this.actor = original.actor();
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
             * Sets {@code actor}.
             *
             * @param actor the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder actor(Reference actor) {
                this.actor = actor;
                return this;
            }

            /**
             * Builds the {@code Participant}.
             *
             * @return the {@code Participant}
             * @throws NullPointerException if a required element is absent
             */
            public Participant build() {
                return new Participant(
                        id, extension, modifierExtension, function, actor);
            }
        }
    }

    /**
     * Details about each adverse reaction event linked to exposure to the identified substance.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param substance Specific substance or pharmaceutical product considered to be responsible for event.
     * @param manifestation Clinical symptoms/signs associated with the Event. Required.
     * @param description Description of the event as a whole.
     * @param onset Date(/time) when manifestations showed.
     * @param severity mild | moderate | severe (of event as a whole).
     * @param exposureRoute How the subject was exposed to the substance.
     * @param note Text about event not captured in other fields.
     */
    public record Reaction(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept substance,
            List<CodeableReference> manifestation,
            FhirString description,
            FhirDateTime onset,
            FhirEnum<AllergyIntoleranceSeverity> severity,
            CodeableConcept exposureRoute,
            List<Annotation> note) implements BackboneElement {

        /**
         * Creates a {@code Reaction}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Reaction {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            manifestation = manifestation == null ? List.of() : List.copyOf(manifestation);
            note = note == null ? List.of() : List.copyOf(note);
            if (manifestation.isEmpty()) {
                throw new IllegalArgumentException(
                        "AllergyIntolerance.reaction.manifestation requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Reaction}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Reaction}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept substance;
            private List<CodeableReference> manifestation = new ArrayList<>();
            private FhirString description;
            private FhirDateTime onset;
            private FhirEnum<AllergyIntoleranceSeverity> severity;
            private CodeableConcept exposureRoute;
            private List<Annotation> note = new ArrayList<>();

            private Builder() {
            }

            private Builder(Reaction original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.substance = original.substance();
                this.manifestation = new ArrayList<>(original.manifestation());
                this.description = original.description();
                this.onset = original.onset();
                this.severity = original.severity();
                this.exposureRoute = original.exposureRoute();
                this.note = new ArrayList<>(original.note());
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
             * Sets {@code substance}.
             *
             * @param substance the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder substance(CodeableConcept substance) {
                this.substance = substance;
                return this;
            }

            /**
             * Replaces all {@code manifestation} values.
             *
             * @param manifestation the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder manifestation(List<CodeableReference> manifestation) {
                this.manifestation = manifestation == null ? new ArrayList<>() : new ArrayList<>(manifestation);
                return this;
            }

            /**
             * Adds a {@code manifestation} value.
             *
             * @param manifestation the value to add
             * @return this builder
             */
            public Builder addManifestation(CodeableReference manifestation) {
                this.manifestation.add(Objects.requireNonNull(manifestation, "manifestation"));
                return this;
            }

            /**
             * Sets {@code description}.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(FhirString description) {
                this.description = description;
                return this;
            }

            /**
             * Sets {@code description}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(String description) {
                return description(description == null ? null : FhirString.of(description));
            }

            /**
             * Sets {@code onset}.
             *
             * @param onset the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder onset(FhirDateTime onset) {
                this.onset = onset;
                return this;
            }

            /**
             * Sets {@code onset}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param onset the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder onset(Temporal onset) {
                return onset(onset == null ? null : FhirDateTime.of(onset));
            }

            /**
             * Sets {@code severity}.
             *
             * @param severity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder severity(FhirEnum<AllergyIntoleranceSeverity> severity) {
                this.severity = severity;
                return this;
            }

            /**
             * Sets {@code severity}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param severity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder severity(AllergyIntoleranceSeverity severity) {
                return severity(severity == null ? null : FhirEnum.of(severity));
            }

            /**
             * Sets {@code exposureRoute}.
             *
             * @param exposureRoute the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder exposureRoute(CodeableConcept exposureRoute) {
                this.exposureRoute = exposureRoute;
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
             * Builds the {@code Reaction}.
             *
             * @return the {@code Reaction}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Reaction build() {
                return new Reaction(
                        id, extension, modifierExtension, substance, manifestation, description, onset, severity,
                        exposureRoute, note);
            }
        }
    }

    /** Builder for {@link AllergyIntolerance}. Builders are mutable and not thread-safe. */
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
        private CodeableConcept clinicalStatus;
        private CodeableConcept verificationStatus;
        private CodeableConcept type;
        private List<FhirEnum<AllergyIntoleranceCategory>> category = new ArrayList<>();
        private FhirEnum<AllergyIntoleranceCriticality> criticality;
        private CodeableConcept code;
        private Reference patient;
        private Reference encounter;
        private DataType onset;
        private FhirDateTime recordedDate;
        private List<Participant> participant = new ArrayList<>();
        private FhirDateTime lastOccurrence;
        private List<Annotation> note = new ArrayList<>();
        private List<Reaction> reaction = new ArrayList<>();

        private Builder() {
        }

        private Builder(AllergyIntolerance original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.clinicalStatus = original.clinicalStatus();
            this.verificationStatus = original.verificationStatus();
            this.type = original.type();
            this.category = new ArrayList<>(original.category());
            this.criticality = original.criticality();
            this.code = original.code();
            this.patient = original.patient();
            this.encounter = original.encounter();
            this.onset = original.onset();
            this.recordedDate = original.recordedDate();
            this.participant = new ArrayList<>(original.participant());
            this.lastOccurrence = original.lastOccurrence();
            this.note = new ArrayList<>(original.note());
            this.reaction = new ArrayList<>(original.reaction());
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
         * Sets {@code clinicalStatus}.
         *
         * @param clinicalStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder clinicalStatus(CodeableConcept clinicalStatus) {
            this.clinicalStatus = clinicalStatus;
            return this;
        }

        /**
         * Sets {@code verificationStatus}.
         *
         * @param verificationStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder verificationStatus(CodeableConcept verificationStatus) {
            this.verificationStatus = verificationStatus;
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
         * Replaces all {@code category} values.
         *
         * @param category the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder category(List<FhirEnum<AllergyIntoleranceCategory>> category) {
            this.category = category == null ? new ArrayList<>() : new ArrayList<>(category);
            return this;
        }

        /**
         * Adds a {@code category} value.
         *
         * @param category the value to add
         * @return this builder
         */
        public Builder addCategory(FhirEnum<AllergyIntoleranceCategory> category) {
            this.category.add(Objects.requireNonNull(category, "category"));
            return this;
        }

        /**
         * Adds a {@code category} value, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param category the value to add
         * @return this builder
         */
        public Builder addCategory(AllergyIntoleranceCategory category) {
            return addCategory(FhirEnum.of(category));
        }

        /**
         * Sets {@code criticality}.
         *
         * @param criticality the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder criticality(FhirEnum<AllergyIntoleranceCriticality> criticality) {
            this.criticality = criticality;
            return this;
        }

        /**
         * Sets {@code criticality}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param criticality the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder criticality(AllergyIntoleranceCriticality criticality) {
            return criticality(criticality == null ? null : FhirEnum.of(criticality));
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
         * Sets {@code onset} to a dateTime.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(FhirDateTime onset) {
            this.onset = onset;
            return this;
        }

        /**
         * Sets {@code onset} to a Age.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(Age onset) {
            this.onset = onset;
            return this;
        }

        /**
         * Sets {@code onset} to a Period.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(Period onset) {
            this.onset = onset;
            return this;
        }

        /**
         * Sets {@code onset} to a Range.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(Range onset) {
            this.onset = onset;
            return this;
        }

        /**
         * Sets {@code onset} to a string.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(FhirString onset) {
            this.onset = onset;
            return this;
        }

        /**
         * Sets {@code onset} to a dateTime without id or extensions.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(Temporal onset) {
            this.onset = onset == null ? null : FhirDateTime.of(onset);
            return this;
        }

        /**
         * Sets {@code onset} to a string without id or extensions.
         *
         * @param onset the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onset(String onset) {
            this.onset = onset == null ? null : FhirString.of(onset);
            return this;
        }

        /**
         * Sets {@code recordedDate}.
         *
         * @param recordedDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recordedDate(FhirDateTime recordedDate) {
            this.recordedDate = recordedDate;
            return this;
        }

        /**
         * Sets {@code recordedDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param recordedDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recordedDate(Temporal recordedDate) {
            return recordedDate(recordedDate == null ? null : FhirDateTime.of(recordedDate));
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
         * Sets {@code lastOccurrence}.
         *
         * @param lastOccurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastOccurrence(FhirDateTime lastOccurrence) {
            this.lastOccurrence = lastOccurrence;
            return this;
        }

        /**
         * Sets {@code lastOccurrence}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param lastOccurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastOccurrence(Temporal lastOccurrence) {
            return lastOccurrence(lastOccurrence == null ? null : FhirDateTime.of(lastOccurrence));
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
         * Replaces all {@code reaction} values.
         *
         * @param reaction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reaction(List<Reaction> reaction) {
            this.reaction = reaction == null ? new ArrayList<>() : new ArrayList<>(reaction);
            return this;
        }

        /**
         * Adds a {@code reaction} value.
         *
         * @param reaction the value to add
         * @return this builder
         */
        public Builder addReaction(Reaction reaction) {
            this.reaction.add(Objects.requireNonNull(reaction, "reaction"));
            return this;
        }

        /**
         * Builds the {@code AllergyIntolerance}.
         *
         * @return the {@code AllergyIntolerance}
         * @throws NullPointerException if a required element is absent
         */
        public AllergyIntolerance build() {
            return new AllergyIntolerance(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    clinicalStatus, verificationStatus, type, category, criticality, code, patient, encounter, onset,
                    recordedDate, participant, lastOccurrence, note, reaction);
        }
    }
}
