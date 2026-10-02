package se.poroli.fhirplace.r5.communication;

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
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.EventStatus;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;

/**
 * A clinical or business level record of information being transmitted or shared; e.g. an alert that was sent to a
 * responsible provider, a public health agency communication to a provider/reporter in response to a case report for
 * a reportable condition.
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
 * @param instantiatesCanonical Instantiates FHIR protocol or definition. Canonical reference to PlanDefinition,
 *   ActivityDefinition, Measure, OperationDefinition, Questionnaire.
 * @param instantiatesUri Instantiates external protocol or definition.
 * @param basedOn Request fulfilled by this communication. Reference to Resource.
 * @param partOf Part of referenced event (e.g. Communication, Procedure). Reference to Resource.
 * @param inResponseTo Reply to. Reference to Communication.
 * @param status preparation | in-progress | not-done | on-hold | stopped | completed | entered-in-error | unknown.
 *   Required. Modifier element.
 * @param statusReason Reason for current status.
 * @param category Message category.
 * @param priority routine | urgent | asap | stat.
 * @param medium A channel of communication.
 * @param subject Focus of message. Reference to Patient, Group.
 * @param topic Description of the purpose/content.
 * @param about Resources that pertain to this communication. Reference to Resource.
 * @param encounter The Encounter during which this Communication was created. Reference to Encounter.
 * @param sent When sent.
 * @param received When received.
 * @param recipient Who the information is shared with. Reference to CareTeam, Device, Group, HealthcareService,
 *   Location, Organization, Patient, Practitioner, PractitionerRole, RelatedPerson, Endpoint.
 * @param sender Who shares the information. Reference to Device, Organization, Patient, Practitioner,
 *   PractitionerRole, RelatedPerson, HealthcareService, Endpoint, CareTeam.
 * @param reason Indication for message.
 * @param payload Message payload.
 * @param note Comments made about the communication.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Communication">FHIR R5 Communication</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Communication(
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
        List<Reference> partOf,
        List<Reference> inResponseTo,
        FhirEnum<EventStatus> status,
        CodeableConcept statusReason,
        List<CodeableConcept> category,
        FhirEnum<RequestPriority> priority,
        List<CodeableConcept> medium,
        Reference subject,
        CodeableConcept topic,
        List<Reference> about,
        Reference encounter,
        FhirDateTime sent,
        FhirDateTime received,
        List<Reference> recipient,
        Reference sender,
        List<CodeableReference> reason,
        List<Payload> payload,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates a {@code Communication}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Communication {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        instantiatesCanonical = instantiatesCanonical == null ? List.of() : List.copyOf(instantiatesCanonical);
        instantiatesUri = instantiatesUri == null ? List.of() : List.copyOf(instantiatesUri);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        inResponseTo = inResponseTo == null ? List.of() : List.copyOf(inResponseTo);
        category = category == null ? List.of() : List.copyOf(category);
        medium = medium == null ? List.of() : List.copyOf(medium);
        about = about == null ? List.of() : List.copyOf(about);
        recipient = recipient == null ? List.of() : List.copyOf(recipient);
        reason = reason == null ? List.of() : List.copyOf(reason);
        payload = payload == null ? List.of() : List.copyOf(payload);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "Communication.status is required");
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
     * Returns a builder initialized with the values of this {@code Communication}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Text, attachment(s), or resource(s) that was communicated to the recipient.
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
            Objects.requireNonNull(content, "Communication.payload.content is required");
            if (content != null && !(content instanceof Attachment
                    || content instanceof Reference
                    || content instanceof CodeableConcept)) {
                throw new IllegalArgumentException(
                        "Communication.payload.content[x] does not allow "
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

    /** Builder for {@link Communication}. Builders are mutable and not thread-safe. */
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
        private List<Reference> partOf = new ArrayList<>();
        private List<Reference> inResponseTo = new ArrayList<>();
        private FhirEnum<EventStatus> status;
        private CodeableConcept statusReason;
        private List<CodeableConcept> category = new ArrayList<>();
        private FhirEnum<RequestPriority> priority;
        private List<CodeableConcept> medium = new ArrayList<>();
        private Reference subject;
        private CodeableConcept topic;
        private List<Reference> about = new ArrayList<>();
        private Reference encounter;
        private FhirDateTime sent;
        private FhirDateTime received;
        private List<Reference> recipient = new ArrayList<>();
        private Reference sender;
        private List<CodeableReference> reason = new ArrayList<>();
        private List<Payload> payload = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(Communication original) {
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
            this.partOf = new ArrayList<>(original.partOf());
            this.inResponseTo = new ArrayList<>(original.inResponseTo());
            this.status = original.status();
            this.statusReason = original.statusReason();
            this.category = new ArrayList<>(original.category());
            this.priority = original.priority();
            this.medium = new ArrayList<>(original.medium());
            this.subject = original.subject();
            this.topic = original.topic();
            this.about = new ArrayList<>(original.about());
            this.encounter = original.encounter();
            this.sent = original.sent();
            this.received = original.received();
            this.recipient = new ArrayList<>(original.recipient());
            this.sender = original.sender();
            this.reason = new ArrayList<>(original.reason());
            this.payload = new ArrayList<>(original.payload());
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
         * Replaces all {@code inResponseTo} values.
         *
         * @param inResponseTo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder inResponseTo(List<Reference> inResponseTo) {
            this.inResponseTo = inResponseTo == null ? new ArrayList<>() : new ArrayList<>(inResponseTo);
            return this;
        }

        /**
         * Adds a {@code inResponseTo} value.
         *
         * @param inResponseTo the value to add
         * @return this builder
         */
        public Builder addInResponseTo(Reference inResponseTo) {
            this.inResponseTo.add(Objects.requireNonNull(inResponseTo, "inResponseTo"));
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<EventStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(EventStatus status) {
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
         * Sets {@code topic}.
         *
         * @param topic the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder topic(CodeableConcept topic) {
            this.topic = topic;
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
         * Sets {@code sent}.
         *
         * @param sent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sent(FhirDateTime sent) {
            this.sent = sent;
            return this;
        }

        /**
         * Sets {@code sent}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param sent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sent(Temporal sent) {
            return sent(sent == null ? null : FhirDateTime.of(sent));
        }

        /**
         * Sets {@code received}.
         *
         * @param received the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder received(FhirDateTime received) {
            this.received = received;
            return this;
        }

        /**
         * Sets {@code received}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param received the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder received(Temporal received) {
            return received(received == null ? null : FhirDateTime.of(received));
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
         * Sets {@code sender}.
         *
         * @param sender the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sender(Reference sender) {
            this.sender = sender;
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
         * Builds the {@code Communication}.
         *
         * @return the {@code Communication}
         * @throws NullPointerException if a required element is absent
         */
        public Communication build() {
            return new Communication(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    instantiatesCanonical, instantiatesUri, basedOn, partOf, inResponseTo, status, statusReason,
                    category, priority, medium, subject, topic, about, encounter, sent, received, recipient, sender,
                    reason, payload, note);
        }
    }
}
