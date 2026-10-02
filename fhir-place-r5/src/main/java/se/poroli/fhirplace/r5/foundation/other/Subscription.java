package se.poroli.fhirplace.r5.foundation.other;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.SearchComparator;
import se.poroli.fhirplace.r5.valuesets.SearchModifierCode;
import se.poroli.fhirplace.r5.valuesets.SubscriptionPayloadContent;
import se.poroli.fhirplace.r5.valuesets.SubscriptionStatusCodes;

/**
 * The subscription resource describes a particular client's request to be notified about a SubscriptionTopic.
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
 * @param identifier Additional identifiers (business identifier).
 * @param name Human readable name for this subscription.
 * @param status requested | active | error | off | entered-in-error. Required. Modifier element.
 * @param topic Reference to the subscription topic being subscribed to. Canonical reference to SubscriptionTopic.
 *   Required.
 * @param contact Contact details for source (e.g. troubleshooting).
 * @param end When to automatically delete the subscription.
 * @param managingEntity Entity responsible for Subscription changes. Reference to CareTeam, HealthcareService,
 *   Organization, RelatedPerson, Patient, Practitioner, PractitionerRole.
 * @param reason Description of why this subscription was created.
 * @param filterBy Criteria for narrowing the subscription topic stream.
 * @param channelType Channel type for notifications. Required.
 * @param endpoint Where the channel points to.
 * @param parameter Channel type.
 * @param heartbeatPeriod Interval in seconds to send 'heartbeat' notification.
 * @param timeout Timeout in seconds to attempt notification delivery.
 * @param contentType MIME type to send, or omit for no payload.
 * @param content empty | id-only | full-resource.
 * @param maxCount Maximum number of events that can be combined in a single notification.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Subscription">FHIR R5 Subscription</a>
 */
public record Subscription(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirString name,
        FhirEnum<SubscriptionStatusCodes> status,
        FhirCanonical topic,
        List<ContactPoint> contact,
        FhirInstant end,
        Reference managingEntity,
        FhirString reason,
        List<FilterBy> filterBy,
        Coding channelType,
        FhirUrl endpoint,
        List<Parameter> parameter,
        FhirUnsignedInt heartbeatPeriod,
        FhirUnsignedInt timeout,
        FhirCode contentType,
        FhirEnum<SubscriptionPayloadContent> content,
        FhirPositiveInt maxCount) implements DomainResource {

    /**
     * Creates a {@code Subscription}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Subscription {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        filterBy = filterBy == null ? List.of() : List.copyOf(filterBy);
        parameter = parameter == null ? List.of() : List.copyOf(parameter);
        Objects.requireNonNull(status, "Subscription.status is required");
        Objects.requireNonNull(topic, "Subscription.topic is required");
        Objects.requireNonNull(channelType, "Subscription.channelType is required");
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
     * Returns a builder initialized with the values of this {@code Subscription}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The filter properties to be applied to narrow the subscription topic stream.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param resourceType Allowed Resource (reference to definition) for this Subscription filter.
     * @param filterParameter Filter label defined in SubscriptionTopic. Required.
     * @param comparator eq | ne | gt | lt | ge | le | sa | eb | ap.
     * @param modifier missing | exact | contains | not | text | in | not-in | below | above | type | identifier |
     *   of-type | code-text | text-advanced | iterate.
     * @param value Literal value or resource path. Required.
     */
    public record FilterBy(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirUri resourceType,
            FhirString filterParameter,
            FhirEnum<SearchComparator> comparator,
            FhirEnum<SearchModifierCode> modifier,
            FhirString value) implements BackboneElement {

        /**
         * Creates a {@code FilterBy}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public FilterBy {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(filterParameter, "Subscription.filterBy.filterParameter is required");
            Objects.requireNonNull(value, "Subscription.filterBy.value is required");
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
         * Returns a builder initialized with the values of this {@code FilterBy}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link FilterBy}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirUri resourceType;
            private FhirString filterParameter;
            private FhirEnum<SearchComparator> comparator;
            private FhirEnum<SearchModifierCode> modifier;
            private FhirString value;

            private Builder() {
            }

            private Builder(FilterBy original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.resourceType = original.resourceType();
                this.filterParameter = original.filterParameter();
                this.comparator = original.comparator();
                this.modifier = original.modifier();
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
             * Sets {@code resourceType}.
             *
             * @param resourceType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder resourceType(FhirUri resourceType) {
                this.resourceType = resourceType;
                return this;
            }

            /**
             * Sets {@code resourceType}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param resourceType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder resourceType(String resourceType) {
                return resourceType(resourceType == null ? null : FhirUri.of(resourceType));
            }

            /**
             * Sets {@code filterParameter}.
             *
             * @param filterParameter the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder filterParameter(FhirString filterParameter) {
                this.filterParameter = filterParameter;
                return this;
            }

            /**
             * Sets {@code filterParameter}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param filterParameter the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder filterParameter(String filterParameter) {
                return filterParameter(filterParameter == null ? null : FhirString.of(filterParameter));
            }

            /**
             * Sets {@code comparator}.
             *
             * @param comparator the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder comparator(FhirEnum<SearchComparator> comparator) {
                this.comparator = comparator;
                return this;
            }

            /**
             * Sets {@code comparator}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param comparator the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder comparator(SearchComparator comparator) {
                return comparator(comparator == null ? null : FhirEnum.of(comparator));
            }

            /**
             * Sets {@code modifier}.
             *
             * @param modifier the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder modifier(FhirEnum<SearchModifierCode> modifier) {
                this.modifier = modifier;
                return this;
            }

            /**
             * Sets {@code modifier}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param modifier the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder modifier(SearchModifierCode modifier) {
                return modifier(modifier == null ? null : FhirEnum.of(modifier));
            }

            /**
             * Sets {@code value}.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirString value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(String value) {
                return value(value == null ? null : FhirString.of(value));
            }

            /**
             * Builds the {@code FilterBy}.
             *
             * @return the {@code FilterBy}
             * @throws NullPointerException if a required element is absent
             */
            public FilterBy build() {
                return new FilterBy(
                        id, extension, modifierExtension, resourceType, filterParameter, comparator, modifier, value);
            }
        }
    }

    /**
     * Channel-dependent information to send as part of the notification (e.g., HTTP Headers).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Name (key) of the parameter. Required.
     * @param value Value of the parameter to use or pass through. Required.
     */
    public record Parameter(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            FhirString value) implements BackboneElement {

        /**
         * Creates a {@code Parameter}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Parameter {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(name, "Subscription.parameter.name is required");
            Objects.requireNonNull(value, "Subscription.parameter.value is required");
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
            private FhirString name;
            private FhirString value;

            private Builder() {
            }

            private Builder(Parameter original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
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
             * Sets {@code value}.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirString value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(String value) {
                return value(value == null ? null : FhirString.of(value));
            }

            /**
             * Builds the {@code Parameter}.
             *
             * @return the {@code Parameter}
             * @throws NullPointerException if a required element is absent
             */
            public Parameter build() {
                return new Parameter(
                        id, extension, modifierExtension, name, value);
            }
        }
    }

    /** Builder for {@link Subscription}. Builders are mutable and not thread-safe. */
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
        private FhirString name;
        private FhirEnum<SubscriptionStatusCodes> status;
        private FhirCanonical topic;
        private List<ContactPoint> contact = new ArrayList<>();
        private FhirInstant end;
        private Reference managingEntity;
        private FhirString reason;
        private List<FilterBy> filterBy = new ArrayList<>();
        private Coding channelType;
        private FhirUrl endpoint;
        private List<Parameter> parameter = new ArrayList<>();
        private FhirUnsignedInt heartbeatPeriod;
        private FhirUnsignedInt timeout;
        private FhirCode contentType;
        private FhirEnum<SubscriptionPayloadContent> content;
        private FhirPositiveInt maxCount;

        private Builder() {
        }

        private Builder(Subscription original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.name = original.name();
            this.status = original.status();
            this.topic = original.topic();
            this.contact = new ArrayList<>(original.contact());
            this.end = original.end();
            this.managingEntity = original.managingEntity();
            this.reason = original.reason();
            this.filterBy = new ArrayList<>(original.filterBy());
            this.channelType = original.channelType();
            this.endpoint = original.endpoint();
            this.parameter = new ArrayList<>(original.parameter());
            this.heartbeatPeriod = original.heartbeatPeriod();
            this.timeout = original.timeout();
            this.contentType = original.contentType();
            this.content = original.content();
            this.maxCount = original.maxCount();
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<SubscriptionStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(SubscriptionStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code topic}.
         *
         * @param topic the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder topic(FhirCanonical topic) {
            this.topic = topic;
            return this;
        }

        /**
         * Sets {@code topic}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param topic the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder topic(String topic) {
            return topic(topic == null ? null : FhirCanonical.of(topic));
        }

        /**
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ContactPoint> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ContactPoint contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
            return this;
        }

        /**
         * Sets {@code end}.
         *
         * @param end the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder end(FhirInstant end) {
            this.end = end;
            return this;
        }

        /**
         * Sets {@code end}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param end the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder end(OffsetDateTime end) {
            return end(end == null ? null : FhirInstant.of(end));
        }

        /**
         * Sets {@code managingEntity}.
         *
         * @param managingEntity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder managingEntity(Reference managingEntity) {
            this.managingEntity = managingEntity;
            return this;
        }

        /**
         * Sets {@code reason}.
         *
         * @param reason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reason(FhirString reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Sets {@code reason}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param reason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reason(String reason) {
            return reason(reason == null ? null : FhirString.of(reason));
        }

        /**
         * Replaces all {@code filterBy} values.
         *
         * @param filterBy the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder filterBy(List<FilterBy> filterBy) {
            this.filterBy = filterBy == null ? new ArrayList<>() : new ArrayList<>(filterBy);
            return this;
        }

        /**
         * Adds a {@code filterBy} value.
         *
         * @param filterBy the value to add
         * @return this builder
         */
        public Builder addFilterBy(FilterBy filterBy) {
            this.filterBy.add(Objects.requireNonNull(filterBy, "filterBy"));
            return this;
        }

        /**
         * Sets {@code channelType}.
         *
         * @param channelType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder channelType(Coding channelType) {
            this.channelType = channelType;
            return this;
        }

        /**
         * Sets {@code endpoint}.
         *
         * @param endpoint the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder endpoint(FhirUrl endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        /**
         * Sets {@code endpoint}, wrapped in a {@link FhirUrl} without id or extensions.
         *
         * @param endpoint the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder endpoint(String endpoint) {
            return endpoint(endpoint == null ? null : FhirUrl.of(endpoint));
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
         * Sets {@code heartbeatPeriod}.
         *
         * @param heartbeatPeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder heartbeatPeriod(FhirUnsignedInt heartbeatPeriod) {
            this.heartbeatPeriod = heartbeatPeriod;
            return this;
        }

        /**
         * Sets {@code heartbeatPeriod}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
         *
         * @param heartbeatPeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder heartbeatPeriod(Integer heartbeatPeriod) {
            return heartbeatPeriod(heartbeatPeriod == null ? null : FhirUnsignedInt.of(heartbeatPeriod));
        }

        /**
         * Sets {@code timeout}.
         *
         * @param timeout the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timeout(FhirUnsignedInt timeout) {
            this.timeout = timeout;
            return this;
        }

        /**
         * Sets {@code timeout}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
         *
         * @param timeout the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timeout(Integer timeout) {
            return timeout(timeout == null ? null : FhirUnsignedInt.of(timeout));
        }

        /**
         * Sets {@code contentType}.
         *
         * @param contentType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder contentType(FhirCode contentType) {
            this.contentType = contentType;
            return this;
        }

        /**
         * Sets {@code contentType}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param contentType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder contentType(String contentType) {
            return contentType(contentType == null ? null : FhirCode.of(contentType));
        }

        /**
         * Sets {@code content}.
         *
         * @param content the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder content(FhirEnum<SubscriptionPayloadContent> content) {
            this.content = content;
            return this;
        }

        /**
         * Sets {@code content}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param content the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder content(SubscriptionPayloadContent content) {
            return content(content == null ? null : FhirEnum.of(content));
        }

        /**
         * Sets {@code maxCount}.
         *
         * @param maxCount the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxCount(FhirPositiveInt maxCount) {
            this.maxCount = maxCount;
            return this;
        }

        /**
         * Sets {@code maxCount}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param maxCount the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxCount(Integer maxCount) {
            return maxCount(maxCount == null ? null : FhirPositiveInt.of(maxCount));
        }

        /**
         * Builds the {@code Subscription}.
         *
         * @return the {@code Subscription}
         * @throws NullPointerException if a required element is absent
         */
        public Subscription build() {
            return new Subscription(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    name, status, topic, contact, end, managingEntity, reason, filterBy, channelType, endpoint,
                    parameter, heartbeatPeriod, timeout, contentType, content, maxCount);
        }
    }
}
