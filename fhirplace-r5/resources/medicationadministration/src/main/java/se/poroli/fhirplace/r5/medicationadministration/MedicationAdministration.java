package se.poroli.fhirplace.r5.medicationadministration;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Timing;

/**
 * Describes the event of a patient consuming or otherwise being administered a medication.
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
 * @param identifier External identifier.
 * @param basedOn Plan this is fulfilled by this administration. Reference to CarePlan.
 * @param partOf Part of referenced event. Reference to MedicationAdministration, Procedure, MedicationDispense.
 * @param status in-progress | not-done | on-hold | completed | entered-in-error | stopped | unknown. Required.
 *   Modifier element.
 * @param statusReason Reason administration not performed.
 * @param category Type of medication administration.
 * @param medication What was administered. Required.
 * @param subject Who received medication. Reference to Patient, Group. Required.
 * @param encounter Encounter administered as part of. Reference to Encounter.
 * @param supportingInformation Additional information to support administration. Reference to Resource.
 * @param occurence Specific date/time or interval of time during which the administration took place (or did not take
 *   place). One of dateTime, Period, Timing. Required.
 * @param recorded When the MedicationAdministration was first captured in the subject's record.
 * @param isSubPotent Full dose was not administered.
 * @param subPotentReason Reason full dose was not administered.
 * @param performer Who or what performed the medication administration and what type of performance they did.
 * @param reason Concept, condition or observation that supports why the medication was administered.
 * @param request Request administration performed against. Reference to MedicationRequest.
 * @param device Device used to administer.
 * @param note Information about the administration.
 * @param dosage Details of how medication was taken.
 * @param eventHistory A list of events of interest in the lifecycle. Reference to Provenance.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MedicationAdministration">FHIR R5 MedicationAdministration</a>
 */
public record MedicationAdministration(
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
        FhirEnum<MedicationAdministrationStatusCodes> status,
        List<CodeableConcept> statusReason,
        List<CodeableConcept> category,
        CodeableReference medication,
        Reference subject,
        Reference encounter,
        List<Reference> supportingInformation,
        DataType occurence,
        FhirDateTime recorded,
        FhirBoolean isSubPotent,
        List<CodeableConcept> subPotentReason,
        List<Performer> performer,
        List<CodeableReference> reason,
        Reference request,
        List<CodeableReference> device,
        List<Annotation> note,
        MedicationAdministrationDosage dosage,
        List<Reference> eventHistory) implements DomainResource {

    /**
     * Creates a {@code MedicationAdministration}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public MedicationAdministration {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        statusReason = statusReason == null ? List.of() : List.copyOf(statusReason);
        category = category == null ? List.of() : List.copyOf(category);
        supportingInformation = supportingInformation == null ? List.of() : List.copyOf(supportingInformation);
        subPotentReason = subPotentReason == null ? List.of() : List.copyOf(subPotentReason);
        performer = performer == null ? List.of() : List.copyOf(performer);
        reason = reason == null ? List.of() : List.copyOf(reason);
        device = device == null ? List.of() : List.copyOf(device);
        note = note == null ? List.of() : List.copyOf(note);
        eventHistory = eventHistory == null ? List.of() : List.copyOf(eventHistory);
        Objects.requireNonNull(status, "MedicationAdministration.status is required");
        Objects.requireNonNull(medication, "MedicationAdministration.medication is required");
        Objects.requireNonNull(subject, "MedicationAdministration.subject is required");
        Objects.requireNonNull(occurence, "MedicationAdministration.occurence is required");
        if (occurence != null && !(occurence instanceof FhirDateTime
                || occurence instanceof Period
                || occurence instanceof Timing)) {
            throw new IllegalArgumentException(
                    "MedicationAdministration.occurence[x] must be one of dateTime, Period, Timing, but was "
                            + occurence.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code MedicationAdministration}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The performer of the medication treatment.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function Type of performance.
     * @param actor Who or what performed the medication administration. Required.
     */
    public record Performer(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept function,
            CodeableReference actor) implements BackboneElement {

        /**
         * Creates a {@code Performer}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Performer {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(actor, "MedicationAdministration.performer.actor is required");
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
         * Returns a builder initialized with the values of this {@code Performer}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Performer}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept function;
            private CodeableReference actor;

            private Builder() {
            }

            private Builder(Performer original) {
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
            public Builder actor(CodeableReference actor) {
                this.actor = actor;
                return this;
            }

            /**
             * Builds the {@code Performer}.
             *
             * @return the {@code Performer}
             * @throws NullPointerException if a required element is absent
             */
            public Performer build() {
                return new Performer(
                        id, extension, modifierExtension, function, actor);
            }
        }
    }

    /**
     * Describes the medication dosage information details e.g. dose, rate, site, route, etc.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param text Free text dosage instructions e.g. SIG.
     * @param site Body site administered to.
     * @param route Path of substance into body.
     * @param method How drug was administered.
     * @param dose Amount of medication per dose.
     * @param rate Dose quantity per unit of time. One of Ratio, Quantity.
     */
    public record MedicationAdministrationDosage(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString text,
            CodeableConcept site,
            CodeableConcept route,
            CodeableConcept method,
            Quantity dose,
            DataType rate) implements BackboneElement {

        /**
         * Creates a {@code MedicationAdministrationDosage}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public MedicationAdministrationDosage {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (rate != null && !(rate instanceof Ratio || rate instanceof Quantity)) {
                throw new IllegalArgumentException(
                        "MedicationAdministration.dosage.rate[x] must be one of Ratio, Quantity, but was "
                                + rate.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code MedicationAdministrationDosage}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link MedicationAdministrationDosage}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString text;
            private CodeableConcept site;
            private CodeableConcept route;
            private CodeableConcept method;
            private Quantity dose;
            private DataType rate;

            private Builder() {
            }

            private Builder(MedicationAdministrationDosage original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.text = original.text();
                this.site = original.site();
                this.route = original.route();
                this.method = original.method();
                this.dose = original.dose();
                this.rate = original.rate();
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
             * Sets {@code site}.
             *
             * @param site the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder site(CodeableConcept site) {
                this.site = site;
                return this;
            }

            /**
             * Sets {@code route}.
             *
             * @param route the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder route(CodeableConcept route) {
                this.route = route;
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
             * Sets {@code dose}.
             *
             * @param dose the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dose(Quantity dose) {
                this.dose = dose;
                return this;
            }

            /**
             * Sets {@code rate} to a Ratio.
             *
             * @param rate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rate(Ratio rate) {
                this.rate = rate;
                return this;
            }

            /**
             * Sets {@code rate} to a Quantity.
             *
             * @param rate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rate(Quantity rate) {
                this.rate = rate;
                return this;
            }

            /**
             * Builds the {@code MedicationAdministrationDosage}.
             *
             * @return the {@code MedicationAdministrationDosage}
             */
            public MedicationAdministrationDosage build() {
                return new MedicationAdministrationDosage(
                        id, extension, modifierExtension, text, site, route, method, dose, rate);
            }
        }
    }

    /** Builder for {@link MedicationAdministration}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<MedicationAdministrationStatusCodes> status;
        private List<CodeableConcept> statusReason = new ArrayList<>();
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableReference medication;
        private Reference subject;
        private Reference encounter;
        private List<Reference> supportingInformation = new ArrayList<>();
        private DataType occurence;
        private FhirDateTime recorded;
        private FhirBoolean isSubPotent;
        private List<CodeableConcept> subPotentReason = new ArrayList<>();
        private List<Performer> performer = new ArrayList<>();
        private List<CodeableReference> reason = new ArrayList<>();
        private Reference request;
        private List<CodeableReference> device = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private MedicationAdministrationDosage dosage;
        private List<Reference> eventHistory = new ArrayList<>();

        private Builder() {
        }

        private Builder(MedicationAdministration original) {
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
            this.status = original.status();
            this.statusReason = new ArrayList<>(original.statusReason());
            this.category = new ArrayList<>(original.category());
            this.medication = original.medication();
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.supportingInformation = new ArrayList<>(original.supportingInformation());
            this.occurence = original.occurence();
            this.recorded = original.recorded();
            this.isSubPotent = original.isSubPotent();
            this.subPotentReason = new ArrayList<>(original.subPotentReason());
            this.performer = new ArrayList<>(original.performer());
            this.reason = new ArrayList<>(original.reason());
            this.request = original.request();
            this.device = new ArrayList<>(original.device());
            this.note = new ArrayList<>(original.note());
            this.dosage = original.dosage();
            this.eventHistory = new ArrayList<>(original.eventHistory());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<MedicationAdministrationStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(MedicationAdministrationStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Replaces all {@code statusReason} values.
         *
         * @param statusReason the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder statusReason(List<CodeableConcept> statusReason) {
            this.statusReason = statusReason == null ? new ArrayList<>() : new ArrayList<>(statusReason);
            return this;
        }

        /**
         * Adds a {@code statusReason} value.
         *
         * @param statusReason the value to add
         * @return this builder
         */
        public Builder addStatusReason(CodeableConcept statusReason) {
            this.statusReason.add(Objects.requireNonNull(statusReason, "statusReason"));
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
         * Sets {@code medication}.
         *
         * @param medication the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder medication(CodeableReference medication) {
            this.medication = medication;
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
         * Replaces all {@code supportingInformation} values.
         *
         * @param supportingInformation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supportingInformation(List<Reference> supportingInformation) {
            this.supportingInformation = supportingInformation == null
                    ? new ArrayList<>()
                    : new ArrayList<>(supportingInformation);
            return this;
        }

        /**
         * Adds a {@code supportingInformation} value.
         *
         * @param supportingInformation the value to add
         * @return this builder
         */
        public Builder addSupportingInformation(Reference supportingInformation) {
            this.supportingInformation.add(Objects.requireNonNull(supportingInformation, "supportingInformation"));
            return this;
        }

        /**
         * Sets {@code occurence} to a dateTime.
         *
         * @param occurence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurence(FhirDateTime occurence) {
            this.occurence = occurence;
            return this;
        }

        /**
         * Sets {@code occurence} to a Period.
         *
         * @param occurence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurence(Period occurence) {
            this.occurence = occurence;
            return this;
        }

        /**
         * Sets {@code occurence} to a Timing.
         *
         * @param occurence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurence(Timing occurence) {
            this.occurence = occurence;
            return this;
        }

        /**
         * Sets {@code occurence} to a dateTime without id or extensions.
         *
         * @param occurence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurence(Temporal occurence) {
            this.occurence = occurence == null ? null : FhirDateTime.of(occurence);
            return this;
        }

        /**
         * Sets {@code recorded}.
         *
         * @param recorded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorded(FhirDateTime recorded) {
            this.recorded = recorded;
            return this;
        }

        /**
         * Sets {@code recorded}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param recorded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder recorded(Temporal recorded) {
            return recorded(recorded == null ? null : FhirDateTime.of(recorded));
        }

        /**
         * Sets {@code isSubPotent}.
         *
         * @param isSubPotent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder isSubPotent(FhirBoolean isSubPotent) {
            this.isSubPotent = isSubPotent;
            return this;
        }

        /**
         * Sets {@code isSubPotent}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param isSubPotent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder isSubPotent(Boolean isSubPotent) {
            return isSubPotent(isSubPotent == null ? null : FhirBoolean.of(isSubPotent));
        }

        /**
         * Replaces all {@code subPotentReason} values.
         *
         * @param subPotentReason the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder subPotentReason(List<CodeableConcept> subPotentReason) {
            this.subPotentReason = subPotentReason == null ? new ArrayList<>() : new ArrayList<>(subPotentReason);
            return this;
        }

        /**
         * Adds a {@code subPotentReason} value.
         *
         * @param subPotentReason the value to add
         * @return this builder
         */
        public Builder addSubPotentReason(CodeableConcept subPotentReason) {
            this.subPotentReason.add(Objects.requireNonNull(subPotentReason, "subPotentReason"));
            return this;
        }

        /**
         * Replaces all {@code performer} values.
         *
         * @param performer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder performer(List<Performer> performer) {
            this.performer = performer == null ? new ArrayList<>() : new ArrayList<>(performer);
            return this;
        }

        /**
         * Adds a {@code performer} value.
         *
         * @param performer the value to add
         * @return this builder
         */
        public Builder addPerformer(Performer performer) {
            this.performer.add(Objects.requireNonNull(performer, "performer"));
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
         * Sets {@code request}.
         *
         * @param request the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder request(Reference request) {
            this.request = request;
            return this;
        }

        /**
         * Replaces all {@code device} values.
         *
         * @param device the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder device(List<CodeableReference> device) {
            this.device = device == null ? new ArrayList<>() : new ArrayList<>(device);
            return this;
        }

        /**
         * Adds a {@code device} value.
         *
         * @param device the value to add
         * @return this builder
         */
        public Builder addDevice(CodeableReference device) {
            this.device.add(Objects.requireNonNull(device, "device"));
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
         * Sets {@code dosage}.
         *
         * @param dosage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dosage(MedicationAdministrationDosage dosage) {
            this.dosage = dosage;
            return this;
        }

        /**
         * Replaces all {@code eventHistory} values.
         *
         * @param eventHistory the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder eventHistory(List<Reference> eventHistory) {
            this.eventHistory = eventHistory == null ? new ArrayList<>() : new ArrayList<>(eventHistory);
            return this;
        }

        /**
         * Adds a {@code eventHistory} value.
         *
         * @param eventHistory the value to add
         * @return this builder
         */
        public Builder addEventHistory(Reference eventHistory) {
            this.eventHistory.add(Objects.requireNonNull(eventHistory, "eventHistory"));
            return this;
        }

        /**
         * Builds the {@code MedicationAdministration}.
         *
         * @return the {@code MedicationAdministration}
         * @throws NullPointerException if a required element is absent
         */
        public MedicationAdministration build() {
            return new MedicationAdministration(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    basedOn, partOf, status, statusReason, category, medication, subject, encounter,
                    supportingInformation, occurence, recorded, isSubPotent, subPotentReason, performer, reason,
                    request, device, note, dosage, eventHistory);
        }
    }
}
