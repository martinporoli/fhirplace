package se.poroli.fhirplace.r5.communicationrequest;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;

/**
 * A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the
 * CDS system proposes that the public health agency be notified about a reportable condition.
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
 * @param identifier Unique identifier.
 * @param basedOn Fulfills plan or proposal. Reference to Resource.
 * @param replaces Request(s) replaced by this request. Reference to CommunicationRequest.
 * @param groupIdentifier Composite request this is part of.
 * @param status draft | active | on-hold | revoked | completed | entered-in-error | unknown. Required. Modifier
 *   element.
 * @param statusReason Reason for current status.
 * @param intent proposal | plan | directive | order | original-order | reflex-order | filler-order | instance-order |
 *   option. Required. Modifier element.
 * @param category Message category.
 * @param priority routine | urgent | asap | stat.
 * @param doNotPerform True if request is prohibiting action. Modifier element.
 * @param medium A channel of communication.
 * @param subject Focus of message. Reference to Patient, Group.
 * @param about Resources that pertain to this communication request. Reference to Resource.
 * @param encounter The Encounter during which this CommunicationRequest was created. Reference to Encounter.
 * @param payload Message payload.
 * @param occurrence When scheduled. One of dateTime, Period.
 * @param authoredOn When request transitioned to being actionable.
 * @param requester Who asks for the information to be shared. Reference to Practitioner, PractitionerRole,
 *   Organization, Patient, RelatedPerson, Device.
 * @param recipient Who to share the information with. Reference to Device, Organization, Patient, Practitioner,
 *   PractitionerRole, RelatedPerson, Group, CareTeam, HealthcareService, Endpoint.
 * @param informationProvider Who should share the information. Reference to Device, Organization, Patient,
 *   Practitioner, PractitionerRole, RelatedPerson, HealthcareService, Endpoint.
 * @param reason Why is communication needed?.
 * @param note Comments made about communication request.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/CommunicationRequest">FHIR R5 CommunicationRequest</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record CommunicationRequest(
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
        List<Reference> replaces,
        Identifier groupIdentifier,
        FhirEnum<RequestStatus> status,
        CodeableConcept statusReason,
        FhirEnum<RequestIntent> intent,
        List<CodeableConcept> category,
        FhirEnum<RequestPriority> priority,
        FhirBoolean doNotPerform,
        List<CodeableConcept> medium,
        Reference subject,
        List<Reference> about,
        Reference encounter,
        List<Payload> payload,
        DataType occurrence,
        FhirDateTime authoredOn,
        Reference requester,
        List<Reference> recipient,
        List<Reference> informationProvider,
        List<CodeableReference> reason,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates a {@code CommunicationRequest}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public CommunicationRequest {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        replaces = replaces == null ? List.of() : List.copyOf(replaces);
        category = category == null ? List.of() : List.copyOf(category);
        medium = medium == null ? List.of() : List.copyOf(medium);
        about = about == null ? List.of() : List.copyOf(about);
        payload = payload == null ? List.of() : List.copyOf(payload);
        recipient = recipient == null ? List.of() : List.copyOf(recipient);
        informationProvider = informationProvider == null ? List.of() : List.copyOf(informationProvider);
        reason = reason == null ? List.of() : List.copyOf(reason);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "CommunicationRequest.status is required");
        Objects.requireNonNull(intent, "CommunicationRequest.intent is required");
        if (occurrence != null && !(occurrence instanceof FhirDateTime || occurrence instanceof Period)) {
            throw new IllegalArgumentException(
                    "CommunicationRequest.occurrence[x] must be one of dateTime, Period, but was "
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
     * Returns a builder initialized with the values of this {@code CommunicationRequest}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Text, attachment(s), or resource(s) to be communicated to the recipient.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param content Message part content. One of Attachment, Reference, CodeableConcept. Required.
     */
    public record Payload(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType content) implements BackboneElement {

        /**
         * Creates a {@code Payload}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Payload {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(content, "CommunicationRequest.payload.content is required");
            if (content != null && !(content instanceof Attachment
                    || content instanceof Reference
                    || content instanceof CodeableConcept)) {
                throw new IllegalArgumentException(
                        "CommunicationRequest.payload.content[x] does not allow "
                                + content.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Payload}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Payload}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType content;

            private Builder() {
            }

            private Builder(Payload original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.content = original.content();
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
             * Sets {@code content} to a Attachment.
             *
             * @param content the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder content(Attachment content) {
                this.content = content;
                return this;
            }

            /**
             * Sets {@code content} to a Reference.
             *
             * @param content the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder content(Reference content) {
                this.content = content;
                return this;
            }

            /**
             * Sets {@code content} to a CodeableConcept.
             *
             * @param content the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder content(CodeableConcept content) {
                this.content = content;
                return this;
            }

            /**
             * Builds the {@code Payload}.
             *
             * @return the {@code Payload}
             * @throws NullPointerException if a required element is absent
             */
            public Payload build() {
                return new Payload(
                        id, extension, modifierExtension, content);
            }
        }
    }

    /** Builder for {@link CommunicationRequest}. Builders are mutable and not thread-safe. */
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
        private List<Reference> replaces = new ArrayList<>();
        private Identifier groupIdentifier;
        private FhirEnum<RequestStatus> status;
        private CodeableConcept statusReason;
        private FhirEnum<RequestIntent> intent;
        private List<CodeableConcept> category = new ArrayList<>();
        private FhirEnum<RequestPriority> priority;
        private FhirBoolean doNotPerform;
        private List<CodeableConcept> medium = new ArrayList<>();
        private Reference subject;
        private List<Reference> about = new ArrayList<>();
        private Reference encounter;
        private List<Payload> payload = new ArrayList<>();
        private DataType occurrence;
        private FhirDateTime authoredOn;
        private Reference requester;
        private List<Reference> recipient = new ArrayList<>();
        private List<Reference> informationProvider = new ArrayList<>();
        private List<CodeableReference> reason = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(CommunicationRequest original) {
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
            this.replaces = new ArrayList<>(original.replaces());
            this.groupIdentifier = original.groupIdentifier();
            this.status = original.status();
            this.statusReason = original.statusReason();
            this.intent = original.intent();
            this.category = new ArrayList<>(original.category());
            this.priority = original.priority();
            this.doNotPerform = original.doNotPerform();
            this.medium = new ArrayList<>(original.medium());
            this.subject = original.subject();
            this.about = new ArrayList<>(original.about());
            this.encounter = original.encounter();
            this.payload = new ArrayList<>(original.payload());
            this.occurrence = original.occurrence();
            this.authoredOn = original.authoredOn();
            this.requester = original.requester();
            this.recipient = new ArrayList<>(original.recipient());
            this.informationProvider = new ArrayList<>(original.informationProvider());
            this.reason = new ArrayList<>(original.reason());
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
         * Replaces all {@code medium} values.
         *
         * @param medium the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder medium(List<CodeableConcept> medium) {
            this.medium = medium == null ? new ArrayList<>() : new ArrayList<>(medium);
            return this;
        }

        /**
         * Adds a {@code medium} value.
         *
         * @param medium the value to add
         * @return this builder
         */
        public Builder addMedium(CodeableConcept medium) {
            this.medium.add(Objects.requireNonNull(medium, "medium"));
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
         * Replaces all {@code about} values.
         *
         * @param about the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder about(List<Reference> about) {
            this.about = about == null ? new ArrayList<>() : new ArrayList<>(about);
            return this;
        }

        /**
         * Adds a {@code about} value.
         *
         * @param about the value to add
         * @return this builder
         */
        public Builder addAbout(Reference about) {
            this.about.add(Objects.requireNonNull(about, "about"));
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
         * Replaces all {@code payload} values.
         *
         * @param payload the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder payload(List<Payload> payload) {
            this.payload = payload == null ? new ArrayList<>() : new ArrayList<>(payload);
            return this;
        }

        /**
         * Adds a {@code payload} value.
         *
         * @param payload the value to add
         * @return this builder
         */
        public Builder addPayload(Payload payload) {
            this.payload.add(Objects.requireNonNull(payload, "payload"));
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
         * Replaces all {@code informationProvider} values.
         *
         * @param informationProvider the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder informationProvider(List<Reference> informationProvider) {
            this.informationProvider = informationProvider == null
                    ? new ArrayList<>()
                    : new ArrayList<>(informationProvider);
            return this;
        }

        /**
         * Adds a {@code informationProvider} value.
         *
         * @param informationProvider the value to add
         * @return this builder
         */
        public Builder addInformationProvider(Reference informationProvider) {
            this.informationProvider.add(Objects.requireNonNull(informationProvider, "informationProvider"));
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
         * Builds the {@code CommunicationRequest}.
         *
         * @return the {@code CommunicationRequest}
         * @throws NullPointerException if a required element is absent
         */
        public CommunicationRequest build() {
            return new CommunicationRequest(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    basedOn, replaces, groupIdentifier, status, statusReason, intent, category, priority,
                    doNotPerform, medium, subject, about, encounter, payload, occurrence, authoredOn, requester,
                    recipient, informationProvider, reason, note);
        }
    }
}
