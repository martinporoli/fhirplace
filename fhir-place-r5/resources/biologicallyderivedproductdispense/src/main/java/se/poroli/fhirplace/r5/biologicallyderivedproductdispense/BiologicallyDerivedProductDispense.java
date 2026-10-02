package se.poroli.fhirplace.r5.biologicallyderivedproductdispense;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * A record of dispensation of a biologically derived product.
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
 * @param identifier Business identifier for this dispense.
 * @param basedOn The order or request that this dispense is fulfilling. Reference to ServiceRequest.
 * @param partOf Short description. Reference to BiologicallyDerivedProductDispense.
 * @param status preparation | in-progress | allocated | issued | unfulfilled | returned | entered-in-error | unknown.
 *   Required.
 * @param originRelationshipType Relationship between the donor and intended recipient.
 * @param product The BiologicallyDerivedProduct that is dispensed. Reference to BiologicallyDerivedProduct. Required.
 * @param patient The intended recipient of the dispensed product. Reference to Patient. Required.
 * @param matchStatus Indicates the type of matching associated with the dispense.
 * @param performer Indicates who or what performed an action.
 * @param location Where the dispense occurred. Reference to Location.
 * @param quantity Amount dispensed.
 * @param preparedDate When product was selected/matched.
 * @param whenHandedOver When the product was dispatched.
 * @param destination Where the product was dispatched to. Reference to Location.
 * @param note Additional notes.
 * @param usageInstruction Specific instructions for use.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/BiologicallyDerivedProductDispense">FHIR R5 BiologicallyDerivedProductDispense</a>
 */
public record BiologicallyDerivedProductDispense(
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
        FhirEnum<BiologicallyDerivedProductDispenseCodes> status,
        CodeableConcept originRelationshipType,
        Reference product,
        Reference patient,
        CodeableConcept matchStatus,
        List<Performer> performer,
        Reference location,
        Quantity quantity,
        FhirDateTime preparedDate,
        FhirDateTime whenHandedOver,
        Reference destination,
        List<Annotation> note,
        FhirString usageInstruction) implements DomainResource {

    /**
     * Creates a {@code BiologicallyDerivedProductDispense}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public BiologicallyDerivedProductDispense {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        performer = performer == null ? List.of() : List.copyOf(performer);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "BiologicallyDerivedProductDispense.status is required");
        Objects.requireNonNull(product, "BiologicallyDerivedProductDispense.product is required");
        Objects.requireNonNull(patient, "BiologicallyDerivedProductDispense.patient is required");
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
     * Returns a builder initialized with the values of this {@code BiologicallyDerivedProductDispense}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates who or what performed an action.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function Identifies the function of the performer during the dispense.
     * @param actor Who performed the action. Reference to Practitioner. Required.
     */
    public record Performer(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept function,
            Reference actor) implements BackboneElement {

        /**
         * Creates a {@code Performer}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Performer {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(actor, "BiologicallyDerivedProductDispense.performer.actor is required");
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
            private Reference actor;

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
            public Builder actor(Reference actor) {
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

    /** Builder for {@link BiologicallyDerivedProductDispense}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<BiologicallyDerivedProductDispenseCodes> status;
        private CodeableConcept originRelationshipType;
        private Reference product;
        private Reference patient;
        private CodeableConcept matchStatus;
        private List<Performer> performer = new ArrayList<>();
        private Reference location;
        private Quantity quantity;
        private FhirDateTime preparedDate;
        private FhirDateTime whenHandedOver;
        private Reference destination;
        private List<Annotation> note = new ArrayList<>();
        private FhirString usageInstruction;

        private Builder() {
        }

        private Builder(BiologicallyDerivedProductDispense original) {
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
            this.originRelationshipType = original.originRelationshipType();
            this.product = original.product();
            this.patient = original.patient();
            this.matchStatus = original.matchStatus();
            this.performer = new ArrayList<>(original.performer());
            this.location = original.location();
            this.quantity = original.quantity();
            this.preparedDate = original.preparedDate();
            this.whenHandedOver = original.whenHandedOver();
            this.destination = original.destination();
            this.note = new ArrayList<>(original.note());
            this.usageInstruction = original.usageInstruction();
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
        public Builder status(FhirEnum<BiologicallyDerivedProductDispenseCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(BiologicallyDerivedProductDispenseCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code originRelationshipType}.
         *
         * @param originRelationshipType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder originRelationshipType(CodeableConcept originRelationshipType) {
            this.originRelationshipType = originRelationshipType;
            return this;
        }

        /**
         * Sets {@code product}.
         *
         * @param product the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder product(Reference product) {
            this.product = product;
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
         * Sets {@code matchStatus}.
         *
         * @param matchStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder matchStatus(CodeableConcept matchStatus) {
            this.matchStatus = matchStatus;
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
         * Sets {@code preparedDate}.
         *
         * @param preparedDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preparedDate(FhirDateTime preparedDate) {
            this.preparedDate = preparedDate;
            return this;
        }

        /**
         * Sets {@code preparedDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param preparedDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preparedDate(Temporal preparedDate) {
            return preparedDate(preparedDate == null ? null : FhirDateTime.of(preparedDate));
        }

        /**
         * Sets {@code whenHandedOver}.
         *
         * @param whenHandedOver the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder whenHandedOver(FhirDateTime whenHandedOver) {
            this.whenHandedOver = whenHandedOver;
            return this;
        }

        /**
         * Sets {@code whenHandedOver}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param whenHandedOver the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder whenHandedOver(Temporal whenHandedOver) {
            return whenHandedOver(whenHandedOver == null ? null : FhirDateTime.of(whenHandedOver));
        }

        /**
         * Sets {@code destination}.
         *
         * @param destination the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder destination(Reference destination) {
            this.destination = destination;
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
         * Sets {@code usageInstruction}.
         *
         * @param usageInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder usageInstruction(FhirString usageInstruction) {
            this.usageInstruction = usageInstruction;
            return this;
        }

        /**
         * Sets {@code usageInstruction}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param usageInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder usageInstruction(String usageInstruction) {
            return usageInstruction(usageInstruction == null ? null : FhirString.of(usageInstruction));
        }

        /**
         * Builds the {@code BiologicallyDerivedProductDispense}.
         *
         * @return the {@code BiologicallyDerivedProductDispense}
         * @throws NullPointerException if a required element is absent
         */
        public BiologicallyDerivedProductDispense build() {
            return new BiologicallyDerivedProductDispense(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    basedOn, partOf, status, originRelationshipType, product, patient, matchStatus, performer,
                    location, quantity, preparedDate, whenHandedOver, destination, note, usageInstruction);
        }
    }
}
