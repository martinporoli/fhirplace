package se.poroli.fhirplace.r5.base.workflow;

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
import se.poroli.fhirplace.r5.datatypes.Contributor;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.ElementDefinition;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.TransportStatus;

/**
 * Record of transport.
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
 * @param instantiatesCanonical Formal definition of transport. Canonical reference to ActivityDefinition.
 * @param instantiatesUri Formal definition of transport.
 * @param basedOn Request fulfilled by this transport. Reference to Resource.
 * @param groupIdentifier Requisition or grouper id.
 * @param partOf Part of referenced event. Reference to Transport.
 * @param status in-progress | completed | abandoned | cancelled | planned | entered-in-error. Modifier element.
 * @param statusReason Reason for current status.
 * @param intent unknown | proposal | plan | order | original-order | reflex-order | filler-order | instance-order |
 *   option. Required.
 * @param priority routine | urgent | asap | stat.
 * @param code Transport Type.
 * @param description Human-readable explanation of transport.
 * @param focus What transport is acting on. Reference to Resource.
 * @param forValue Beneficiary of the Transport. Reference to Resource. The FHIR element {@code for}.
 * @param encounter Healthcare event during which this transport originated. Reference to Encounter.
 * @param completionTime Completion time of the event (the occurrence).
 * @param authoredOn Transport Creation Date.
 * @param lastModified Transport Last Modified Date.
 * @param requester Who is asking for transport to be done. Reference to Device, Organization, Patient, Practitioner,
 *   PractitionerRole, RelatedPerson.
 * @param performerType Requested performer.
 * @param owner Responsible individual. Reference to Practitioner, PractitionerRole, Organization, CareTeam,
 *   HealthcareService, Patient, Device, RelatedPerson.
 * @param location Where transport occurs. Reference to Location.
 * @param insurance Associated insurance coverage. Reference to Coverage, ClaimResponse.
 * @param note Comments made about the transport.
 * @param relevantHistory Key events in history of the Transport. Reference to Provenance.
 * @param restriction Constraints on fulfillment transports.
 * @param input Information used to perform transport.
 * @param output Information produced as part of transport.
 * @param requestedLocation The desired location. Reference to Location. Required.
 * @param currentLocation The entity current location. Reference to Location. Required.
 * @param reason Why transport is needed.
 * @param history Parent (or preceding) transport. Reference to Transport.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Transport">FHIR R5 Transport</a>
 */
public record Transport(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirCanonical instantiatesCanonical,
        FhirUri instantiatesUri,
        List<Reference> basedOn,
        Identifier groupIdentifier,
        List<Reference> partOf,
        FhirEnum<TransportStatus> status,
        CodeableConcept statusReason,
        FhirCode intent,
        FhirEnum<RequestPriority> priority,
        CodeableConcept code,
        FhirString description,
        Reference focus,
        Reference forValue,
        Reference encounter,
        FhirDateTime completionTime,
        FhirDateTime authoredOn,
        FhirDateTime lastModified,
        Reference requester,
        List<CodeableConcept> performerType,
        Reference owner,
        Reference location,
        List<Reference> insurance,
        List<Annotation> note,
        List<Reference> relevantHistory,
        Restriction restriction,
        List<Parameter> input,
        List<Output> output,
        Reference requestedLocation,
        Reference currentLocation,
        CodeableReference reason,
        Reference history) implements DomainResource {

    /**
     * Creates a {@code Transport}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Transport {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        performerType = performerType == null ? List.of() : List.copyOf(performerType);
        insurance = insurance == null ? List.of() : List.copyOf(insurance);
        note = note == null ? List.of() : List.copyOf(note);
        relevantHistory = relevantHistory == null ? List.of() : List.copyOf(relevantHistory);
        input = input == null ? List.of() : List.copyOf(input);
        output = output == null ? List.of() : List.copyOf(output);
        Objects.requireNonNull(intent, "Transport.intent is required");
        Objects.requireNonNull(requestedLocation, "Transport.requestedLocation is required");
        Objects.requireNonNull(currentLocation, "Transport.currentLocation is required");
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
     * Returns a builder initialized with the values of this {@code Transport}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * If the Transport.focus is a request resource and the transport is seeking fulfillment (i.e. is asking for the
     * request to be actioned), this element identifies any limitations on what parts of the referenced request should
     * be actioned.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param repetitions How many times to repeat.
     * @param period When fulfillment sought.
     * @param recipient For whom is fulfillment sought?. Reference to Patient, Practitioner, PractitionerRole,
     *   RelatedPerson, Group, Organization.
     */
    public record Restriction(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt repetitions,
            Period period,
            List<Reference> recipient) implements BackboneElement {

        /**
         * Creates a {@code Restriction}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Restriction {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            recipient = recipient == null ? List.of() : List.copyOf(recipient);
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
         * Returns a builder initialized with the values of this {@code Restriction}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Restriction}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt repetitions;
            private Period period;
            private List<Reference> recipient = new ArrayList<>();

            private Builder() {
            }

            private Builder(Restriction original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.repetitions = original.repetitions();
                this.period = original.period();
                this.recipient = new ArrayList<>(original.recipient());
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
             * Sets {@code repetitions}.
             *
             * @param repetitions the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder repetitions(FhirPositiveInt repetitions) {
                this.repetitions = repetitions;
                return this;
            }

            /**
             * Sets {@code repetitions}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param repetitions the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder repetitions(Integer repetitions) {
                return repetitions(repetitions == null ? null : FhirPositiveInt.of(repetitions));
            }

            /**
             * Sets {@code period}.
             *
             * @param period the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder period(Period period) {
                this.period = period;
                return this;
            }

            /**
             * Replaces all {@code recipient} values.
             *
             * @param recipient the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder recipient(List<Reference> recipient) {
                this.recipient = recipient == null ? new ArrayList<>() : new ArrayList<>(recipient);
                return this;
            }

            /**
             * Adds a {@code recipient} value.
             *
             * @param recipient the value to add
             * @return this builder
             */
            public Builder addRecipient(Reference recipient) {
                this.recipient.add(Objects.requireNonNull(recipient, "recipient"));
                return this;
            }

            /**
             * Builds the {@code Restriction}.
             *
             * @return the {@code Restriction}
             */
            public Restriction build() {
                return new Restriction(
                        id, extension, modifierExtension, repetitions, period, recipient);
            }
        }
    }

    /**
     * Additional information that may be needed in the execution of the transport.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Label for the input. Required.
     * @param value Content to use in performing the transport. Any datatype except Contributor, VirtualServiceDetail,
     *   MonetaryComponent, Narrative, Extension, ElementDefinition, ProductShelfLife, MarketingStatus. Required.
     */
    public record Parameter(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType value) implements BackboneElement {

        /**
         * Creates a {@code Parameter}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Parameter {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "Transport.input.type is required");
            Objects.requireNonNull(value, "Transport.input.value is required");
            if (value != null && (value instanceof Contributor
                    || value instanceof VirtualServiceDetail
                    || value instanceof MonetaryComponent
                    || value instanceof Narrative
                    || value instanceof Extension
                    || value instanceof ElementDefinition
                    || value instanceof ProductShelfLife
                    || value instanceof MarketingStatus)) {
                throw new IllegalArgumentException(
                        "Transport.input.value[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code Parameter}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Parameter}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private DataType value;

            private Builder() {
            }

            private Builder(Parameter original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
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
             * Builds the {@code Parameter}.
             *
             * @return the {@code Parameter}
             * @throws NullPointerException if a required element is absent
             */
            public Parameter build() {
                return new Parameter(
                        id, extension, modifierExtension, type, value);
            }
        }
    }

    /**
     * Outputs produced by the Transport.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Label for output. Required.
     * @param value Result of output. Any datatype except Contributor, VirtualServiceDetail, MonetaryComponent,
     *   Narrative, Extension, ElementDefinition, ProductShelfLife, MarketingStatus. Required.
     */
    public record Output(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType value) implements BackboneElement {

        /**
         * Creates an {@code Output}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Output {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "Transport.output.type is required");
            Objects.requireNonNull(value, "Transport.output.value is required");
            if (value != null && (value instanceof Contributor
                    || value instanceof VirtualServiceDetail
                    || value instanceof MonetaryComponent
                    || value instanceof Narrative
                    || value instanceof Extension
                    || value instanceof ElementDefinition
                    || value instanceof ProductShelfLife
                    || value instanceof MarketingStatus)) {
                throw new IllegalArgumentException(
                        "Transport.output.value[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code Output}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Output}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private DataType value;

            private Builder() {
            }

            private Builder(Output original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
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
             * Builds the {@code Output}.
             *
             * @return the {@code Output}
             * @throws NullPointerException if a required element is absent
             */
            public Output build() {
                return new Output(
                        id, extension, modifierExtension, type, value);
            }
        }
    }

    /** Builder for {@link Transport}. Builders are mutable and not thread-safe. */
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
        private FhirCanonical instantiatesCanonical;
        private FhirUri instantiatesUri;
        private List<Reference> basedOn = new ArrayList<>();
        private Identifier groupIdentifier;
        private List<Reference> partOf = new ArrayList<>();
        private FhirEnum<TransportStatus> status;
        private CodeableConcept statusReason;
        private FhirCode intent;
        private FhirEnum<RequestPriority> priority;
        private CodeableConcept code;
        private FhirString description;
        private Reference focus;
        private Reference forValue;
        private Reference encounter;
        private FhirDateTime completionTime;
        private FhirDateTime authoredOn;
        private FhirDateTime lastModified;
        private Reference requester;
        private List<CodeableConcept> performerType = new ArrayList<>();
        private Reference owner;
        private Reference location;
        private List<Reference> insurance = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<Reference> relevantHistory = new ArrayList<>();
        private Restriction restriction;
        private List<Parameter> input = new ArrayList<>();
        private List<Output> output = new ArrayList<>();
        private Reference requestedLocation;
        private Reference currentLocation;
        private CodeableReference reason;
        private Reference history;

        private Builder() {
        }

        private Builder(Transport original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.instantiatesCanonical = original.instantiatesCanonical();
            this.instantiatesUri = original.instantiatesUri();
            this.basedOn = new ArrayList<>(original.basedOn());
            this.groupIdentifier = original.groupIdentifier();
            this.partOf = new ArrayList<>(original.partOf());
            this.status = original.status();
            this.statusReason = original.statusReason();
            this.intent = original.intent();
            this.priority = original.priority();
            this.code = original.code();
            this.description = original.description();
            this.focus = original.focus();
            this.forValue = original.forValue();
            this.encounter = original.encounter();
            this.completionTime = original.completionTime();
            this.authoredOn = original.authoredOn();
            this.lastModified = original.lastModified();
            this.requester = original.requester();
            this.performerType = new ArrayList<>(original.performerType());
            this.owner = original.owner();
            this.location = original.location();
            this.insurance = new ArrayList<>(original.insurance());
            this.note = new ArrayList<>(original.note());
            this.relevantHistory = new ArrayList<>(original.relevantHistory());
            this.restriction = original.restriction();
            this.input = new ArrayList<>(original.input());
            this.output = new ArrayList<>(original.output());
            this.requestedLocation = original.requestedLocation();
            this.currentLocation = original.currentLocation();
            this.reason = original.reason();
            this.history = original.history();
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
         * Sets {@code instantiatesCanonical}.
         *
         * @param instantiatesCanonical the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesCanonical(FhirCanonical instantiatesCanonical) {
            this.instantiatesCanonical = instantiatesCanonical;
            return this;
        }

        /**
         * Sets {@code instantiatesCanonical}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param instantiatesCanonical the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesCanonical(String instantiatesCanonical) {
            return instantiatesCanonical(
                    instantiatesCanonical == null ? null : FhirCanonical.of(instantiatesCanonical));
        }

        /**
         * Sets {@code instantiatesUri}.
         *
         * @param instantiatesUri the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesUri(FhirUri instantiatesUri) {
            this.instantiatesUri = instantiatesUri;
            return this;
        }

        /**
         * Sets {@code instantiatesUri}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param instantiatesUri the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesUri(String instantiatesUri) {
            return instantiatesUri(instantiatesUri == null ? null : FhirUri.of(instantiatesUri));
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
         * Sets {@code groupIdentifier}.
         *
         * @param groupIdentifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder groupIdentifier(Identifier groupIdentifier) {
            this.groupIdentifier = groupIdentifier;
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
        public Builder status(FhirEnum<TransportStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(TransportStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code statusReason}.
         *
         * @param statusReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusReason(CodeableConcept statusReason) {
            this.statusReason = statusReason;
            return this;
        }

        /**
         * Sets {@code intent}.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(FhirCode intent) {
            this.intent = intent;
            return this;
        }

        /**
         * Sets {@code intent}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(String intent) {
            return intent(intent == null ? null : FhirCode.of(intent));
        }

        /**
         * Sets {@code priority}.
         *
         * @param priority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priority(FhirEnum<RequestPriority> priority) {
            this.priority = priority;
            return this;
        }

        /**
         * Sets {@code priority}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param priority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priority(RequestPriority priority) {
            return priority(priority == null ? null : FhirEnum.of(priority));
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
         * Sets {@code focus}.
         *
         * @param focus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder focus(Reference focus) {
            this.focus = focus;
            return this;
        }

        /**
         * Sets {@code forValue}.
         *
         * @param forValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder forValue(Reference forValue) {
            this.forValue = forValue;
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
         * Sets {@code completionTime}.
         *
         * @param completionTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder completionTime(FhirDateTime completionTime) {
            this.completionTime = completionTime;
            return this;
        }

        /**
         * Sets {@code completionTime}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param completionTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder completionTime(Temporal completionTime) {
            return completionTime(completionTime == null ? null : FhirDateTime.of(completionTime));
        }

        /**
         * Sets {@code authoredOn}.
         *
         * @param authoredOn the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authoredOn(FhirDateTime authoredOn) {
            this.authoredOn = authoredOn;
            return this;
        }

        /**
         * Sets {@code authoredOn}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param authoredOn the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder authoredOn(Temporal authoredOn) {
            return authoredOn(authoredOn == null ? null : FhirDateTime.of(authoredOn));
        }

        /**
         * Sets {@code lastModified}.
         *
         * @param lastModified the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastModified(FhirDateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        /**
         * Sets {@code lastModified}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param lastModified the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastModified(Temporal lastModified) {
            return lastModified(lastModified == null ? null : FhirDateTime.of(lastModified));
        }

        /**
         * Sets {@code requester}.
         *
         * @param requester the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requester(Reference requester) {
            this.requester = requester;
            return this;
        }

        /**
         * Replaces all {@code performerType} values.
         *
         * @param performerType the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder performerType(List<CodeableConcept> performerType) {
            this.performerType = performerType == null ? new ArrayList<>() : new ArrayList<>(performerType);
            return this;
        }

        /**
         * Adds a {@code performerType} value.
         *
         * @param performerType the value to add
         * @return this builder
         */
        public Builder addPerformerType(CodeableConcept performerType) {
            this.performerType.add(Objects.requireNonNull(performerType, "performerType"));
            return this;
        }

        /**
         * Sets {@code owner}.
         *
         * @param owner the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder owner(Reference owner) {
            this.owner = owner;
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
         * Replaces all {@code insurance} values.
         *
         * @param insurance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder insurance(List<Reference> insurance) {
            this.insurance = insurance == null ? new ArrayList<>() : new ArrayList<>(insurance);
            return this;
        }

        /**
         * Adds a {@code insurance} value.
         *
         * @param insurance the value to add
         * @return this builder
         */
        public Builder addInsurance(Reference insurance) {
            this.insurance.add(Objects.requireNonNull(insurance, "insurance"));
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
         * Replaces all {@code relevantHistory} values.
         *
         * @param relevantHistory the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relevantHistory(List<Reference> relevantHistory) {
            this.relevantHistory = relevantHistory == null ? new ArrayList<>() : new ArrayList<>(relevantHistory);
            return this;
        }

        /**
         * Adds a {@code relevantHistory} value.
         *
         * @param relevantHistory the value to add
         * @return this builder
         */
        public Builder addRelevantHistory(Reference relevantHistory) {
            this.relevantHistory.add(Objects.requireNonNull(relevantHistory, "relevantHistory"));
            return this;
        }

        /**
         * Sets {@code restriction}.
         *
         * @param restriction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder restriction(Restriction restriction) {
            this.restriction = restriction;
            return this;
        }

        /**
         * Replaces all {@code input} values.
         *
         * @param input the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder input(List<Parameter> input) {
            this.input = input == null ? new ArrayList<>() : new ArrayList<>(input);
            return this;
        }

        /**
         * Adds a {@code input} value.
         *
         * @param input the value to add
         * @return this builder
         */
        public Builder addInput(Parameter input) {
            this.input.add(Objects.requireNonNull(input, "input"));
            return this;
        }

        /**
         * Replaces all {@code output} values.
         *
         * @param output the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder output(List<Output> output) {
            this.output = output == null ? new ArrayList<>() : new ArrayList<>(output);
            return this;
        }

        /**
         * Adds a {@code output} value.
         *
         * @param output the value to add
         * @return this builder
         */
        public Builder addOutput(Output output) {
            this.output.add(Objects.requireNonNull(output, "output"));
            return this;
        }

        /**
         * Sets {@code requestedLocation}.
         *
         * @param requestedLocation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requestedLocation(Reference requestedLocation) {
            this.requestedLocation = requestedLocation;
            return this;
        }

        /**
         * Sets {@code currentLocation}.
         *
         * @param currentLocation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder currentLocation(Reference currentLocation) {
            this.currentLocation = currentLocation;
            return this;
        }

        /**
         * Sets {@code reason}.
         *
         * @param reason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reason(CodeableReference reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Sets {@code history}.
         *
         * @param history the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder history(Reference history) {
            this.history = history;
            return this;
        }

        /**
         * Builds the {@code Transport}.
         *
         * @return the {@code Transport}
         * @throws NullPointerException if a required element is absent
         */
        public Transport build() {
            return new Transport(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiatesCanonical, instantiatesUri, basedOn, groupIdentifier, partOf, status, statusReason,
                    intent, priority, code, description, focus, forValue, encounter, completionTime, authoredOn,
                    lastModified, requester, performerType, owner, location, insurance, note, relevantHistory,
                    restriction, input, output, requestedLocation, currentLocation, reason, history);
        }
    }
}
