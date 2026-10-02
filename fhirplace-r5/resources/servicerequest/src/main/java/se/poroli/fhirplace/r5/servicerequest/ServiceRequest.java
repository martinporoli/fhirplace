package se.poroli.fhirplace.r5.servicerequest;

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
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;

/**
 * A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.
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
 * @param identifier Identifiers assigned to this order.
 * @param instantiatesCanonical Instantiates FHIR protocol or definition. Canonical reference to ActivityDefinition,
 *   PlanDefinition.
 * @param instantiatesUri Instantiates external protocol or definition.
 * @param basedOn What request fulfills. Reference to CarePlan, ServiceRequest, MedicationRequest.
 * @param replaces What request replaces. Reference to ServiceRequest.
 * @param requisition Composite Request ID.
 * @param status draft | active | on-hold | revoked | completed | entered-in-error | unknown. Required. Modifier
 *   element.
 * @param intent proposal | plan | directive | order +. Required. Modifier element.
 * @param category Classification of service.
 * @param priority routine | urgent | asap | stat.
 * @param doNotPerform True if service/procedure should not be performed. Modifier element.
 * @param code What is being requested/ordered.
 * @param orderDetail Additional order information.
 * @param quantity Service amount. One of Quantity, Ratio, Range.
 * @param subject Individual or Entity the service is ordered for. Reference to Patient, Group, Location, Device.
 *   Required.
 * @param focus What the service request is about, when it is not about the subject of record. Reference to Resource.
 * @param encounter Encounter in which the request was created. Reference to Encounter.
 * @param occurrence When service should occur. One of dateTime, Period, Timing.
 * @param asNeeded Preconditions for service. One of boolean, CodeableConcept.
 * @param authoredOn Date request signed.
 * @param requester Who/what is requesting service. Reference to Practitioner, PractitionerRole, Organization,
 *   Patient, RelatedPerson, Device.
 * @param performerType Performer role.
 * @param performer Requested performer. Reference to Practitioner, PractitionerRole, Organization, CareTeam,
 *   HealthcareService, Patient, Device, RelatedPerson.
 * @param location Requested location.
 * @param reason Explanation/Justification for procedure or service.
 * @param insurance Associated insurance coverage. Reference to Coverage, ClaimResponse.
 * @param supportingInfo Additional clinical information.
 * @param specimen Procedure Samples. Reference to Specimen.
 * @param bodySite Coded location on Body.
 * @param bodyStructure BodyStructure-based location on the body. Reference to BodyStructure.
 * @param note Comments.
 * @param patientInstruction Patient or consumer-oriented instructions.
 * @param relevantHistory Request provenance. Reference to Provenance.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ServiceRequest">FHIR R5 ServiceRequest</a>
 */
public record ServiceRequest(
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
        Identifier requisition,
        FhirEnum<RequestStatus> status,
        FhirEnum<RequestIntent> intent,
        List<CodeableConcept> category,
        FhirEnum<RequestPriority> priority,
        FhirBoolean doNotPerform,
        CodeableReference code,
        List<OrderDetail> orderDetail,
        DataType quantity,
        Reference subject,
        List<Reference> focus,
        Reference encounter,
        DataType occurrence,
        DataType asNeeded,
        FhirDateTime authoredOn,
        Reference requester,
        CodeableConcept performerType,
        List<Reference> performer,
        List<CodeableReference> location,
        List<CodeableReference> reason,
        List<Reference> insurance,
        List<CodeableReference> supportingInfo,
        List<Reference> specimen,
        List<CodeableConcept> bodySite,
        Reference bodyStructure,
        List<Annotation> note,
        List<PatientInstruction> patientInstruction,
        List<Reference> relevantHistory) implements DomainResource {

    /**
     * Creates a {@code ServiceRequest}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ServiceRequest {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        instantiatesCanonical = instantiatesCanonical == null ? List.of() : List.copyOf(instantiatesCanonical);
        instantiatesUri = instantiatesUri == null ? List.of() : List.copyOf(instantiatesUri);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        replaces = replaces == null ? List.of() : List.copyOf(replaces);
        category = category == null ? List.of() : List.copyOf(category);
        orderDetail = orderDetail == null ? List.of() : List.copyOf(orderDetail);
        focus = focus == null ? List.of() : List.copyOf(focus);
        performer = performer == null ? List.of() : List.copyOf(performer);
        location = location == null ? List.of() : List.copyOf(location);
        reason = reason == null ? List.of() : List.copyOf(reason);
        insurance = insurance == null ? List.of() : List.copyOf(insurance);
        supportingInfo = supportingInfo == null ? List.of() : List.copyOf(supportingInfo);
        specimen = specimen == null ? List.of() : List.copyOf(specimen);
        bodySite = bodySite == null ? List.of() : List.copyOf(bodySite);
        note = note == null ? List.of() : List.copyOf(note);
        patientInstruction = patientInstruction == null ? List.of() : List.copyOf(patientInstruction);
        relevantHistory = relevantHistory == null ? List.of() : List.copyOf(relevantHistory);
        Objects.requireNonNull(status, "ServiceRequest.status is required");
        Objects.requireNonNull(intent, "ServiceRequest.intent is required");
        Objects.requireNonNull(subject, "ServiceRequest.subject is required");
        if (quantity != null && !(quantity instanceof Quantity
                || quantity instanceof Ratio
                || quantity instanceof Range)) {
            throw new IllegalArgumentException(
                    "ServiceRequest.quantity[x] must be one of Quantity, Ratio, Range, but was "
                            + quantity.getClass().getSimpleName());
        }
        if (occurrence != null && !(occurrence instanceof FhirDateTime
                || occurrence instanceof Period
                || occurrence instanceof Timing)) {
            throw new IllegalArgumentException(
                    "ServiceRequest.occurrence[x] must be one of dateTime, Period, Timing, but was "
                            + occurrence.getClass().getSimpleName());
        }
        if (asNeeded != null && !(asNeeded instanceof FhirBoolean || asNeeded instanceof CodeableConcept)) {
            throw new IllegalArgumentException(
                    "ServiceRequest.asNeeded[x] must be one of boolean, CodeableConcept, but was "
                            + asNeeded.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code ServiceRequest}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Additional details and instructions about the how the services are to be delivered.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param parameterFocus The context of the order details by reference.
     * @param parameter The parameter details for the service being requested. Required.
     */
    public record OrderDetail(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference parameterFocus,
            List<Parameter> parameter) implements BackboneElement {

        /**
         * Creates an {@code OrderDetail}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public OrderDetail {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            parameter = parameter == null ? List.of() : List.copyOf(parameter);
            if (parameter.isEmpty()) {
                throw new IllegalArgumentException(
                        "ServiceRequest.orderDetail.parameter requires at least one value");
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
         * Returns a builder initialized with the values of this {@code OrderDetail}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The parameter details for the service being requested.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code The detail of the order being requested. Required.
         * @param value The value for the order detail. One of Quantity, Ratio, Range, boolean, CodeableConcept,
         *   string, Period. Required.
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
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Parameter {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(code, "ServiceRequest.orderDetail.parameter.code is required");
                Objects.requireNonNull(value, "ServiceRequest.orderDetail.parameter.value is required");
                if (value != null && !(value instanceof Quantity
                        || value instanceof Ratio
                        || value instanceof Range
                        || value instanceof FhirBoolean
                        || value instanceof CodeableConcept
                        || value instanceof FhirString
                        || value instanceof Period)) {
                    throw new IllegalArgumentException(
                            "ServiceRequest.orderDetail.parameter.value[x] does not allow "
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
                 * Sets {@code value} to a Ratio.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Ratio value) {
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
                 * Sets {@code value} to a string.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirString value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a Period.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Period value) {
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
                 * Sets {@code value} to a string without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(String value) {
                    this.value = value == null ? null : FhirString.of(value);
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
                            id, extension, modifierExtension, code, value);
                }
            }
        }

        /** Builder for {@link OrderDetail}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference parameterFocus;
            private List<Parameter> parameter = new ArrayList<>();

            private Builder() {
            }

            private Builder(OrderDetail original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.parameterFocus = original.parameterFocus();
                this.parameter = new ArrayList<>(original.parameter());
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
             * Sets {@code parameterFocus}.
             *
             * @param parameterFocus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder parameterFocus(CodeableReference parameterFocus) {
                this.parameterFocus = parameterFocus;
                return this;
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
             * Builds the {@code OrderDetail}.
             *
             * @return the {@code OrderDetail}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public OrderDetail build() {
                return new OrderDetail(
                        id, extension, modifierExtension, parameterFocus, parameter);
            }
        }
    }

    /**
     * Instructions in terms that are understood by the patient or consumer.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param instruction Patient or consumer-oriented instructions. One of markdown, Reference.
     */
    public record PatientInstruction(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType instruction) implements BackboneElement {

        /**
         * Creates a {@code PatientInstruction}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public PatientInstruction {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (instruction != null && !(instruction instanceof FhirMarkdown || instruction instanceof Reference)) {
                throw new IllegalArgumentException(
                        "ServiceRequest.patientInstruction.instruction[x] does not allow "
                                + instruction.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code PatientInstruction}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link PatientInstruction}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType instruction;

            private Builder() {
            }

            private Builder(PatientInstruction original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.instruction = original.instruction();
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
             * Sets {@code instruction} to a markdown.
             *
             * @param instruction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instruction(FhirMarkdown instruction) {
                this.instruction = instruction;
                return this;
            }

            /**
             * Sets {@code instruction} to a Reference.
             *
             * @param instruction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instruction(Reference instruction) {
                this.instruction = instruction;
                return this;
            }

            /**
             * Sets {@code instruction} to a markdown without id or extensions.
             *
             * @param instruction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instruction(String instruction) {
                this.instruction = instruction == null ? null : FhirMarkdown.of(instruction);
                return this;
            }

            /**
             * Builds the {@code PatientInstruction}.
             *
             * @return the {@code PatientInstruction}
             */
            public PatientInstruction build() {
                return new PatientInstruction(
                        id, extension, modifierExtension, instruction);
            }
        }
    }

    /** Builder for {@link ServiceRequest}. Builders are mutable and not thread-safe. */
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
        private Identifier requisition;
        private FhirEnum<RequestStatus> status;
        private FhirEnum<RequestIntent> intent;
        private List<CodeableConcept> category = new ArrayList<>();
        private FhirEnum<RequestPriority> priority;
        private FhirBoolean doNotPerform;
        private CodeableReference code;
        private List<OrderDetail> orderDetail = new ArrayList<>();
        private DataType quantity;
        private Reference subject;
        private List<Reference> focus = new ArrayList<>();
        private Reference encounter;
        private DataType occurrence;
        private DataType asNeeded;
        private FhirDateTime authoredOn;
        private Reference requester;
        private CodeableConcept performerType;
        private List<Reference> performer = new ArrayList<>();
        private List<CodeableReference> location = new ArrayList<>();
        private List<CodeableReference> reason = new ArrayList<>();
        private List<Reference> insurance = new ArrayList<>();
        private List<CodeableReference> supportingInfo = new ArrayList<>();
        private List<Reference> specimen = new ArrayList<>();
        private List<CodeableConcept> bodySite = new ArrayList<>();
        private Reference bodyStructure;
        private List<Annotation> note = new ArrayList<>();
        private List<PatientInstruction> patientInstruction = new ArrayList<>();
        private List<Reference> relevantHistory = new ArrayList<>();

        private Builder() {
        }

        private Builder(ServiceRequest original) {
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
            this.requisition = original.requisition();
            this.status = original.status();
            this.intent = original.intent();
            this.category = new ArrayList<>(original.category());
            this.priority = original.priority();
            this.doNotPerform = original.doNotPerform();
            this.code = original.code();
            this.orderDetail = new ArrayList<>(original.orderDetail());
            this.quantity = original.quantity();
            this.subject = original.subject();
            this.focus = new ArrayList<>(original.focus());
            this.encounter = original.encounter();
            this.occurrence = original.occurrence();
            this.asNeeded = original.asNeeded();
            this.authoredOn = original.authoredOn();
            this.requester = original.requester();
            this.performerType = original.performerType();
            this.performer = new ArrayList<>(original.performer());
            this.location = new ArrayList<>(original.location());
            this.reason = new ArrayList<>(original.reason());
            this.insurance = new ArrayList<>(original.insurance());
            this.supportingInfo = new ArrayList<>(original.supportingInfo());
            this.specimen = new ArrayList<>(original.specimen());
            this.bodySite = new ArrayList<>(original.bodySite());
            this.bodyStructure = original.bodyStructure();
            this.note = new ArrayList<>(original.note());
            this.patientInstruction = new ArrayList<>(original.patientInstruction());
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
         * Sets {@code requisition}.
         *
         * @param requisition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requisition(Identifier requisition) {
            this.requisition = requisition;
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
         * Replaces all {@code orderDetail} values.
         *
         * @param orderDetail the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder orderDetail(List<OrderDetail> orderDetail) {
            this.orderDetail = orderDetail == null ? new ArrayList<>() : new ArrayList<>(orderDetail);
            return this;
        }

        /**
         * Adds a {@code orderDetail} value.
         *
         * @param orderDetail the value to add
         * @return this builder
         */
        public Builder addOrderDetail(OrderDetail orderDetail) {
            this.orderDetail.add(Objects.requireNonNull(orderDetail, "orderDetail"));
            return this;
        }

        /**
         * Sets {@code quantity} to a Quantity.
         *
         * @param quantity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder quantity(Quantity quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * Sets {@code quantity} to a Ratio.
         *
         * @param quantity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder quantity(Ratio quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * Sets {@code quantity} to a Range.
         *
         * @param quantity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder quantity(Range quantity) {
            this.quantity = quantity;
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
         * Sets {@code asNeeded} to a boolean.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(FhirBoolean asNeeded) {
            this.asNeeded = asNeeded;
            return this;
        }

        /**
         * Sets {@code asNeeded} to a CodeableConcept.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(CodeableConcept asNeeded) {
            this.asNeeded = asNeeded;
            return this;
        }

        /**
         * Sets {@code asNeeded} to a boolean without id or extensions.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(Boolean asNeeded) {
            this.asNeeded = asNeeded == null ? null : FhirBoolean.of(asNeeded);
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
         * Sets {@code performerType}.
         *
         * @param performerType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder performerType(CodeableConcept performerType) {
            this.performerType = performerType;
            return this;
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
         * Replaces all {@code location} values.
         *
         * @param location the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder location(List<CodeableReference> location) {
            this.location = location == null ? new ArrayList<>() : new ArrayList<>(location);
            return this;
        }

        /**
         * Adds a {@code location} value.
         *
         * @param location the value to add
         * @return this builder
         */
        public Builder addLocation(CodeableReference location) {
            this.location.add(Objects.requireNonNull(location, "location"));
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
        public Builder supportingInfo(List<CodeableReference> supportingInfo) {
            this.supportingInfo = supportingInfo == null ? new ArrayList<>() : new ArrayList<>(supportingInfo);
            return this;
        }

        /**
         * Adds a {@code supportingInfo} value.
         *
         * @param supportingInfo the value to add
         * @return this builder
         */
        public Builder addSupportingInfo(CodeableReference supportingInfo) {
            this.supportingInfo.add(Objects.requireNonNull(supportingInfo, "supportingInfo"));
            return this;
        }

        /**
         * Replaces all {@code specimen} values.
         *
         * @param specimen the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder specimen(List<Reference> specimen) {
            this.specimen = specimen == null ? new ArrayList<>() : new ArrayList<>(specimen);
            return this;
        }

        /**
         * Adds a {@code specimen} value.
         *
         * @param specimen the value to add
         * @return this builder
         */
        public Builder addSpecimen(Reference specimen) {
            this.specimen.add(Objects.requireNonNull(specimen, "specimen"));
            return this;
        }

        /**
         * Replaces all {@code bodySite} values.
         *
         * @param bodySite the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder bodySite(List<CodeableConcept> bodySite) {
            this.bodySite = bodySite == null ? new ArrayList<>() : new ArrayList<>(bodySite);
            return this;
        }

        /**
         * Adds a {@code bodySite} value.
         *
         * @param bodySite the value to add
         * @return this builder
         */
        public Builder addBodySite(CodeableConcept bodySite) {
            this.bodySite.add(Objects.requireNonNull(bodySite, "bodySite"));
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
         * Replaces all {@code patientInstruction} values.
         *
         * @param patientInstruction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder patientInstruction(List<PatientInstruction> patientInstruction) {
            this.patientInstruction = patientInstruction == null
                    ? new ArrayList<>()
                    : new ArrayList<>(patientInstruction);
            return this;
        }

        /**
         * Adds a {@code patientInstruction} value.
         *
         * @param patientInstruction the value to add
         * @return this builder
         */
        public Builder addPatientInstruction(PatientInstruction patientInstruction) {
            this.patientInstruction.add(Objects.requireNonNull(patientInstruction, "patientInstruction"));
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
         * Builds the {@code ServiceRequest}.
         *
         * @return the {@code ServiceRequest}
         * @throws NullPointerException if a required element is absent
         */
        public ServiceRequest build() {
            return new ServiceRequest(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiatesCanonical, instantiatesUri, basedOn, replaces, requisition, status, intent, category,
                    priority, doNotPerform, code, orderDetail, quantity, subject, focus, encounter, occurrence,
                    asNeeded, authoredOn, requester, performerType, performer, location, reason, insurance,
                    supportingInfo, specimen, bodySite, bodyStructure, note, patientInstruction, relevantHistory);
        }
    }
}
