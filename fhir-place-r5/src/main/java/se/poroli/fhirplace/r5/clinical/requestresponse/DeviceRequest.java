package se.poroli.fhirplace.r5.clinical.requestresponse;

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
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;

/**
 * Represents a request a device to be provided to a specific patient.
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
 * @param identifier External Request identifier.
 * @param instantiatesCanonical Instantiates FHIR protocol or definition. Canonical reference to ActivityDefinition,
 *   PlanDefinition.
 * @param instantiatesUri Instantiates external protocol or definition.
 * @param basedOn What request fulfills. Reference to Resource.
 * @param replaces What request replaces. Reference to DeviceRequest.
 * @param groupIdentifier Identifier of composite request.
 * @param status draft | active | on-hold | revoked | completed | entered-in-error | unknown. Modifier element.
 * @param intent proposal | plan | directive | order | original-order | reflex-order | filler-order | instance-order |
 *   option. Required. Modifier element.
 * @param priority routine | urgent | asap | stat.
 * @param doNotPerform True if the request is to stop or not to start using the device. Modifier element.
 * @param code Device requested. Required.
 * @param quantity Quantity of devices to supply.
 * @param parameter Device details.
 * @param subject Focus of request. Reference to Patient, Group, Location, Device. Required.
 * @param encounter Encounter motivating request. Reference to Encounter.
 * @param occurrence Desired time or schedule for use. One of dateTime, Period, Timing.
 * @param authoredOn When recorded.
 * @param requester Who/what submitted the device request. Reference to Device, Practitioner, PractitionerRole,
 *   Organization.
 * @param performer Requested Filler.
 * @param reason Coded/Linked Reason for request.
 * @param asNeeded PRN status of request.
 * @param asNeededFor Device usage reason.
 * @param insurance Associated insurance coverage. Reference to Coverage, ClaimResponse.
 * @param supportingInfo Additional clinical information. Reference to Resource.
 * @param note Notes or comments.
 * @param relevantHistory Request provenance. Reference to Provenance.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DeviceRequest">FHIR R5 DeviceRequest</a>
 */
public record DeviceRequest(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        List<FhirCanonical> instantiatesCanonical,
        List<FhirUri> instantiatesUri,
        List<Reference> basedOn,
        List<Reference> replaces,
        Identifier groupIdentifier,
        FhirEnum<RequestStatus> status,
        FhirEnum<RequestIntent> intent,
        FhirEnum<RequestPriority> priority,
        FhirBoolean doNotPerform,
        CodeableReference code,
        FhirInteger quantity,
        List<Parameter> parameter,
        Reference subject,
        Reference encounter,
        DataType occurrence,
        FhirDateTime authoredOn,
        Reference requester,
        CodeableReference performer,
        List<CodeableReference> reason,
        FhirBoolean asNeeded,
        CodeableConcept asNeededFor,
        List<Reference> insurance,
        List<Reference> supportingInfo,
        List<Annotation> note,
        List<Reference> relevantHistory) implements DomainResource {

    /**
     * Creates a {@code DeviceRequest}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public DeviceRequest {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        instantiatesCanonical = instantiatesCanonical == null ? List.of() : List.copyOf(instantiatesCanonical);
        instantiatesUri = instantiatesUri == null ? List.of() : List.copyOf(instantiatesUri);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        replaces = replaces == null ? List.of() : List.copyOf(replaces);
        parameter = parameter == null ? List.of() : List.copyOf(parameter);
        reason = reason == null ? List.of() : List.copyOf(reason);
        insurance = insurance == null ? List.of() : List.copyOf(insurance);
        supportingInfo = supportingInfo == null ? List.of() : List.copyOf(supportingInfo);
        note = note == null ? List.of() : List.copyOf(note);
        relevantHistory = relevantHistory == null ? List.of() : List.copyOf(relevantHistory);
        Objects.requireNonNull(intent, "DeviceRequest.intent is required");
        Objects.requireNonNull(code, "DeviceRequest.code is required");
        Objects.requireNonNull(subject, "DeviceRequest.subject is required");
        if (occurrence != null && !(occurrence instanceof FhirDateTime
                || occurrence instanceof Period
                || occurrence instanceof Timing)) {
            throw new IllegalArgumentException(
                    "DeviceRequest.occurrence[x] must be one of dateTime, Period, Timing, but was "
                            + occurrence.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code DeviceRequest}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Specific parameters for the ordered item.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Device detail.
     * @param value Value of detail. One of CodeableConcept, Quantity, Range, boolean.
     */
    public record Parameter(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            DataType value) implements BackboneElement {

        /**
         * Creates a {@code Parameter}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Parameter {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (value != null && !(value instanceof CodeableConcept
                    || value instanceof Quantity
                    || value instanceof Range
                    || value instanceof FhirBoolean)) {
                throw new IllegalArgumentException(
                        "DeviceRequest.parameter.value[x] does not allow "
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
            private CodeableConcept code;
            private DataType value;

            private Builder() {
            }

            private Builder(Parameter original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
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
             * Sets {@code value} to a CodeableConcept.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(CodeableConcept value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a Quantity.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Quantity value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a Range.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Range value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a boolean.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirBoolean value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a boolean without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Boolean value) {
                this.value = value == null ? null : FhirBoolean.of(value);
                return this;
            }

            /**
             * Builds the {@code Parameter}.
             *
             * @return the {@code Parameter}
             */
            public Parameter build() {
                return new Parameter(
                        id, extension, modifierExtension, code, value);
            }
        }
    }

    /** Builder for {@link DeviceRequest}. Builders are mutable and not thread-safe. */
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
        private List<FhirCanonical> instantiatesCanonical = new ArrayList<>();
        private List<FhirUri> instantiatesUri = new ArrayList<>();
        private List<Reference> basedOn = new ArrayList<>();
        private List<Reference> replaces = new ArrayList<>();
        private Identifier groupIdentifier;
        private FhirEnum<RequestStatus> status;
        private FhirEnum<RequestIntent> intent;
        private FhirEnum<RequestPriority> priority;
        private FhirBoolean doNotPerform;
        private CodeableReference code;
        private FhirInteger quantity;
        private List<Parameter> parameter = new ArrayList<>();
        private Reference subject;
        private Reference encounter;
        private DataType occurrence;
        private FhirDateTime authoredOn;
        private Reference requester;
        private CodeableReference performer;
        private List<CodeableReference> reason = new ArrayList<>();
        private FhirBoolean asNeeded;
        private CodeableConcept asNeededFor;
        private List<Reference> insurance = new ArrayList<>();
        private List<Reference> supportingInfo = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<Reference> relevantHistory = new ArrayList<>();

        private Builder() {
        }

        private Builder(DeviceRequest original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.instantiatesCanonical = new ArrayList<>(original.instantiatesCanonical());
            this.instantiatesUri = new ArrayList<>(original.instantiatesUri());
            this.basedOn = new ArrayList<>(original.basedOn());
            this.replaces = new ArrayList<>(original.replaces());
            this.groupIdentifier = original.groupIdentifier();
            this.status = original.status();
            this.intent = original.intent();
            this.priority = original.priority();
            this.doNotPerform = original.doNotPerform();
            this.code = original.code();
            this.quantity = original.quantity();
            this.parameter = new ArrayList<>(original.parameter());
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.occurrence = original.occurrence();
            this.authoredOn = original.authoredOn();
            this.requester = original.requester();
            this.performer = original.performer();
            this.reason = new ArrayList<>(original.reason());
            this.asNeeded = original.asNeeded();
            this.asNeededFor = original.asNeededFor();
            this.insurance = new ArrayList<>(original.insurance());
            this.supportingInfo = new ArrayList<>(original.supportingInfo());
            this.note = new ArrayList<>(original.note());
            this.relevantHistory = new ArrayList<>(original.relevantHistory());
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
         * Replaces all {@code instantiatesCanonical} values.
         *
         * @param instantiatesCanonical the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder instantiatesCanonical(List<FhirCanonical> instantiatesCanonical) {
            this.instantiatesCanonical = instantiatesCanonical == null
                    ? new ArrayList<>()
                    : new ArrayList<>(instantiatesCanonical);
            return this;
        }

        /**
         * Adds a {@code instantiatesCanonical} value.
         *
         * @param instantiatesCanonical the value to add
         * @return this builder
         */
        public Builder addInstantiatesCanonical(FhirCanonical instantiatesCanonical) {
            this.instantiatesCanonical.add(Objects.requireNonNull(instantiatesCanonical, "instantiatesCanonical"));
            return this;
        }

        /**
         * Adds a {@code instantiatesCanonical} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param instantiatesCanonical the value to add
         * @return this builder
         */
        public Builder addInstantiatesCanonical(String instantiatesCanonical) {
            return addInstantiatesCanonical(FhirCanonical.of(instantiatesCanonical));
        }

        /**
         * Replaces all {@code instantiatesUri} values.
         *
         * @param instantiatesUri the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder instantiatesUri(List<FhirUri> instantiatesUri) {
            this.instantiatesUri = instantiatesUri == null ? new ArrayList<>() : new ArrayList<>(instantiatesUri);
            return this;
        }

        /**
         * Adds a {@code instantiatesUri} value.
         *
         * @param instantiatesUri the value to add
         * @return this builder
         */
        public Builder addInstantiatesUri(FhirUri instantiatesUri) {
            this.instantiatesUri.add(Objects.requireNonNull(instantiatesUri, "instantiatesUri"));
            return this;
        }

        /**
         * Adds a {@code instantiatesUri} value, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param instantiatesUri the value to add
         * @return this builder
         */
        public Builder addInstantiatesUri(String instantiatesUri) {
            return addInstantiatesUri(FhirUri.of(instantiatesUri));
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
         * Replaces all {@code replaces} values.
         *
         * @param replaces the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder replaces(List<Reference> replaces) {
            this.replaces = replaces == null ? new ArrayList<>() : new ArrayList<>(replaces);
            return this;
        }

        /**
         * Adds a {@code replaces} value.
         *
         * @param replaces the value to add
         * @return this builder
         */
        public Builder addReplaces(Reference replaces) {
            this.replaces.add(Objects.requireNonNull(replaces, "replaces"));
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<RequestStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(RequestStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code intent}.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(FhirEnum<RequestIntent> intent) {
            this.intent = intent;
            return this;
        }

        /**
         * Sets {@code intent}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(RequestIntent intent) {
            return intent(intent == null ? null : FhirEnum.of(intent));
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
         * Sets {@code doNotPerform}.
         *
         * @param doNotPerform the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder doNotPerform(FhirBoolean doNotPerform) {
            this.doNotPerform = doNotPerform;
            return this;
        }

        /**
         * Sets {@code doNotPerform}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param doNotPerform the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder doNotPerform(Boolean doNotPerform) {
            return doNotPerform(doNotPerform == null ? null : FhirBoolean.of(doNotPerform));
        }

        /**
         * Sets {@code code}.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(CodeableReference code) {
            this.code = code;
            return this;
        }

        /**
         * Sets {@code quantity}.
         *
         * @param quantity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder quantity(FhirInteger quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * Sets {@code quantity}, wrapped in a {@link FhirInteger} without id or extensions.
         *
         * @param quantity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder quantity(Integer quantity) {
            return quantity(quantity == null ? null : FhirInteger.of(quantity));
        }

        /**
         * Replaces all {@code parameter} values.
         *
         * @param parameter the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder parameter(List<Parameter> parameter) {
            this.parameter = parameter == null ? new ArrayList<>() : new ArrayList<>(parameter);
            return this;
        }

        /**
         * Adds a {@code parameter} value.
         *
         * @param parameter the value to add
         * @return this builder
         */
        public Builder addParameter(Parameter parameter) {
            this.parameter.add(Objects.requireNonNull(parameter, "parameter"));
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
         * Sets {@code occurrence} to a dateTime.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(FhirDateTime occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a Period.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Period occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a Timing.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Timing occurrence) {
            this.occurrence = occurrence;
            return this;
        }

        /**
         * Sets {@code occurrence} to a dateTime without id or extensions.
         *
         * @param occurrence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder occurrence(Temporal occurrence) {
            this.occurrence = occurrence == null ? null : FhirDateTime.of(occurrence);
            return this;
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
         * Sets {@code performer}.
         *
         * @param performer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder performer(CodeableReference performer) {
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
         * Sets {@code asNeeded}.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(FhirBoolean asNeeded) {
            this.asNeeded = asNeeded;
            return this;
        }

        /**
         * Sets {@code asNeeded}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(Boolean asNeeded) {
            return asNeeded(asNeeded == null ? null : FhirBoolean.of(asNeeded));
        }

        /**
         * Sets {@code asNeededFor}.
         *
         * @param asNeededFor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeededFor(CodeableConcept asNeededFor) {
            this.asNeededFor = asNeededFor;
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
         * Replaces all {@code supportingInfo} values.
         *
         * @param supportingInfo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supportingInfo(List<Reference> supportingInfo) {
            this.supportingInfo = supportingInfo == null ? new ArrayList<>() : new ArrayList<>(supportingInfo);
            return this;
        }

        /**
         * Adds a {@code supportingInfo} value.
         *
         * @param supportingInfo the value to add
         * @return this builder
         */
        public Builder addSupportingInfo(Reference supportingInfo) {
            this.supportingInfo.add(Objects.requireNonNull(supportingInfo, "supportingInfo"));
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
         * Builds the {@code DeviceRequest}.
         *
         * @return the {@code DeviceRequest}
         * @throws NullPointerException if a required element is absent
         */
        public DeviceRequest build() {
            return new DeviceRequest(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiatesCanonical, instantiatesUri, basedOn, replaces, groupIdentifier, status, intent,
                    priority, doNotPerform, code, quantity, parameter, subject, encounter, occurrence, authoredOn,
                    requester, performer, reason, asNeeded, asNeededFor, insurance, supportingInfo, note,
                    relevantHistory);
        }
    }
}
