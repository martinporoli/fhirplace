package se.poroli.fhirplace.r5.base.management;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.EncounterStatus;

/**
 * A record of significant events/milestones key data throughout the history of an Encounter.
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
 * @param encounter The Encounter associated with this set of historic values. Reference to Encounter.
 * @param identifier Identifier(s) by which this encounter is known.
 * @param status planned | in-progress | on-hold | discharged | completed | cancelled | discontinued |
 *   entered-in-error | unknown. Required. Modifier element.
 * @param classValue Classification of patient encounter. The FHIR element {@code class}. Required.
 * @param type Specific type of encounter.
 * @param serviceType Specific type of service.
 * @param subject The patient or group related to this encounter. Reference to Patient, Group.
 * @param subjectStatus The current status of the subject in relation to the Encounter.
 * @param actualPeriod The actual start and end time associated with this set of values associated with the encounter.
 * @param plannedStartDate The planned start date/time (or admission date) of the encounter.
 * @param plannedEndDate The planned end date/time (or discharge date) of the encounter.
 * @param length Actual quantity of time the encounter lasted (less time absent).
 * @param location Location of the patient at this point in the encounter.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/EncounterHistory">FHIR R5 EncounterHistory</a>
 */
public record EncounterHistory(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        Reference encounter,
        List<Identifier> identifier,
        FhirEnum<EncounterStatus> status,
        CodeableConcept classValue,
        List<CodeableConcept> type,
        List<CodeableReference> serviceType,
        Reference subject,
        CodeableConcept subjectStatus,
        Period actualPeriod,
        FhirDateTime plannedStartDate,
        FhirDateTime plannedEndDate,
        Duration length,
        List<Location> location) implements DomainResource {

    /**
     * Creates an {@code EncounterHistory}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public EncounterHistory {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        type = type == null ? List.of() : List.copyOf(type);
        serviceType = serviceType == null ? List.of() : List.copyOf(serviceType);
        location = location == null ? List.of() : List.copyOf(location);
        Objects.requireNonNull(status, "EncounterHistory.status is required");
        Objects.requireNonNull(classValue, "EncounterHistory.class is required");
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
     * Returns a builder initialized with the values of this {@code EncounterHistory}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The location of the patient at this point in the encounter, the multiple cardinality permits de-normalizing the
     * levels of the location hierarchy, such as site/ward/room/bed.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param location Location the encounter takes place. Reference to Location. Required.
     * @param form The physical type of the location (usually the level in the location hierarchy - bed, room, ward,
     *   virtual etc.).
     */
    public record Location(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference location,
            CodeableConcept form) implements BackboneElement {

        /**
         * Creates a {@code Location}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Location {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(location, "EncounterHistory.location.location is required");
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
         * Returns a builder initialized with the values of this {@code Location}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Location}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference location;
            private CodeableConcept form;

            private Builder() {
            }

            private Builder(Location original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.location = original.location();
                this.form = original.form();
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
             * Sets {@code location}.
             *
             * @param location the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder location(Reference location) {
                this.location = location;
                return this;
            }

            /**
             * Sets {@code form}.
             *
             * @param form the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder form(CodeableConcept form) {
                this.form = form;
                return this;
            }

            /**
             * Builds the {@code Location}.
             *
             * @return the {@code Location}
             * @throws NullPointerException if a required element is absent
             */
            public Location build() {
                return new Location(
                        id, extension, modifierExtension, location, form);
            }
        }
    }

    /** Builder for {@link EncounterHistory}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private Reference encounter;
        private List<Identifier> identifier = new ArrayList<>();
        private FhirEnum<EncounterStatus> status;
        private CodeableConcept classValue;
        private List<CodeableConcept> type = new ArrayList<>();
        private List<CodeableReference> serviceType = new ArrayList<>();
        private Reference subject;
        private CodeableConcept subjectStatus;
        private Period actualPeriod;
        private FhirDateTime plannedStartDate;
        private FhirDateTime plannedEndDate;
        private Duration length;
        private List<Location> location = new ArrayList<>();

        private Builder() {
        }

        private Builder(EncounterHistory original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.encounter = original.encounter();
            this.identifier = new ArrayList<>(original.identifier());
            this.status = original.status();
            this.classValue = original.classValue();
            this.type = new ArrayList<>(original.type());
            this.serviceType = new ArrayList<>(original.serviceType());
            this.subject = original.subject();
            this.subjectStatus = original.subjectStatus();
            this.actualPeriod = original.actualPeriod();
            this.plannedStartDate = original.plannedStartDate();
            this.plannedEndDate = original.plannedEndDate();
            this.length = original.length();
            this.location = new ArrayList<>(original.location());
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
        public Builder status(FhirEnum<EncounterStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(EncounterStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code classValue}.
         *
         * @param classValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder classValue(CodeableConcept classValue) {
            this.classValue = classValue;
            return this;
        }

        /**
         * Replaces all {@code type} values.
         *
         * @param type the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder type(List<CodeableConcept> type) {
            this.type = type == null ? new ArrayList<>() : new ArrayList<>(type);
            return this;
        }

        /**
         * Adds a {@code type} value.
         *
         * @param type the value to add
         * @return this builder
         */
        public Builder addType(CodeableConcept type) {
            this.type.add(Objects.requireNonNull(type, "type"));
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
         * Sets {@code subjectStatus}.
         *
         * @param subjectStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subjectStatus(CodeableConcept subjectStatus) {
            this.subjectStatus = subjectStatus;
            return this;
        }

        /**
         * Sets {@code actualPeriod}.
         *
         * @param actualPeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder actualPeriod(Period actualPeriod) {
            this.actualPeriod = actualPeriod;
            return this;
        }

        /**
         * Sets {@code plannedStartDate}.
         *
         * @param plannedStartDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder plannedStartDate(FhirDateTime plannedStartDate) {
            this.plannedStartDate = plannedStartDate;
            return this;
        }

        /**
         * Sets {@code plannedStartDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param plannedStartDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder plannedStartDate(Temporal plannedStartDate) {
            return plannedStartDate(plannedStartDate == null ? null : FhirDateTime.of(plannedStartDate));
        }

        /**
         * Sets {@code plannedEndDate}.
         *
         * @param plannedEndDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder plannedEndDate(FhirDateTime plannedEndDate) {
            this.plannedEndDate = plannedEndDate;
            return this;
        }

        /**
         * Sets {@code plannedEndDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param plannedEndDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder plannedEndDate(Temporal plannedEndDate) {
            return plannedEndDate(plannedEndDate == null ? null : FhirDateTime.of(plannedEndDate));
        }

        /**
         * Sets {@code length}.
         *
         * @param length the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder length(Duration length) {
            this.length = length;
            return this;
        }

        /**
         * Replaces all {@code location} values.
         *
         * @param location the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder location(List<Location> location) {
            this.location = location == null ? new ArrayList<>() : new ArrayList<>(location);
            return this;
        }

        /**
         * Adds a {@code location} value.
         *
         * @param location the value to add
         * @return this builder
         */
        public Builder addLocation(Location location) {
            this.location.add(Objects.requireNonNull(location, "location"));
            return this;
        }

        /**
         * Builds the {@code EncounterHistory}.
         *
         * @return the {@code EncounterHistory}
         * @throws NullPointerException if a required element is absent
         */
        public EncounterHistory build() {
            return new EncounterHistory(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, encounter,
                    identifier, status, classValue, type, serviceType, subject, subjectStatus, actualPeriod,
                    plannedStartDate, plannedEndDate, length, location);
        }
    }
}
