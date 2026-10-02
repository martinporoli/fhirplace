package se.poroli.fhirplace.r5.subscriptionstatus;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirInteger64;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.SubscriptionStatusCodes;

/**
 * The SubscriptionStatus resource describes the state of a Subscription during notifications.
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
 * @param status requested | active | error | off | entered-in-error.
 * @param type handshake | heartbeat | event-notification | query-status | query-event. Required. Modifier element.
 * @param eventsSinceSubscriptionStart Events since the Subscription was created.
 * @param notificationEvent Detailed information about any events relevant to this notification.
 * @param subscription Reference to the Subscription responsible for this notification. Reference to Subscription.
 *   Required.
 * @param topic Reference to the SubscriptionTopic this notification relates to. Canonical reference to
 *   SubscriptionTopic.
 * @param error List of errors on the subscription.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/SubscriptionStatus">FHIR R5 SubscriptionStatus</a>
 */
public record SubscriptionStatus(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirEnum<SubscriptionStatusCodes> status,
        FhirEnum<SubscriptionNotificationType> type,
        FhirInteger64 eventsSinceSubscriptionStart,
        List<NotificationEvent> notificationEvent,
        Reference subscription,
        FhirCanonical topic,
        List<CodeableConcept> error) implements DomainResource {

    /**
     * Creates a {@code SubscriptionStatus}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public SubscriptionStatus {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        notificationEvent = notificationEvent == null ? List.of() : List.copyOf(notificationEvent);
        error = error == null ? List.of() : List.copyOf(error);
        Objects.requireNonNull(type, "SubscriptionStatus.type is required");
        Objects.requireNonNull(subscription, "SubscriptionStatus.subscription is required");
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
     * Returns a builder initialized with the values of this {@code SubscriptionStatus}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Detailed information about events relevant to this subscription notification.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param eventNumber Sequencing index of this event. Required.
     * @param timestamp The instant this event occurred.
     * @param focus Reference to the primary resource or information of this event. Reference to Resource.
     * @param additionalContext References related to the focus resource and/or context of this event. Reference to
     *   Resource.
     */
    public record NotificationEvent(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirInteger64 eventNumber,
            FhirInstant timestamp,
            Reference focus,
            List<Reference> additionalContext) implements BackboneElement {

        /**
         * Creates a {@code NotificationEvent}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public NotificationEvent {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            additionalContext = additionalContext == null ? List.of() : List.copyOf(additionalContext);
            Objects.requireNonNull(eventNumber, "SubscriptionStatus.notificationEvent.eventNumber is required");
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
         * Returns a builder initialized with the values of this {@code NotificationEvent}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link NotificationEvent}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirInteger64 eventNumber;
            private FhirInstant timestamp;
            private Reference focus;
            private List<Reference> additionalContext = new ArrayList<>();

            private Builder() {
            }

            private Builder(NotificationEvent original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.eventNumber = original.eventNumber();
                this.timestamp = original.timestamp();
                this.focus = original.focus();
                this.additionalContext = new ArrayList<>(original.additionalContext());
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
             * Sets {@code eventNumber}.
             *
             * @param eventNumber the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder eventNumber(FhirInteger64 eventNumber) {
                this.eventNumber = eventNumber;
                return this;
            }

            /**
             * Sets {@code eventNumber}, wrapped in a {@link FhirInteger64} without id or extensions.
             *
             * @param eventNumber the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder eventNumber(Long eventNumber) {
                return eventNumber(eventNumber == null ? null : FhirInteger64.of(eventNumber));
            }

            /**
             * Sets {@code timestamp}.
             *
             * @param timestamp the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder timestamp(FhirInstant timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            /**
             * Sets {@code timestamp}, wrapped in a {@link FhirInstant} without id or extensions.
             *
             * @param timestamp the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder timestamp(OffsetDateTime timestamp) {
                return timestamp(timestamp == null ? null : FhirInstant.of(timestamp));
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
             * Replaces all {@code additionalContext} values.
             *
             * @param additionalContext the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder additionalContext(List<Reference> additionalContext) {
                this.additionalContext = additionalContext == null
                        ? new ArrayList<>()
                        : new ArrayList<>(additionalContext);
                return this;
            }

            /**
             * Adds a {@code additionalContext} value.
             *
             * @param additionalContext the value to add
             * @return this builder
             */
            public Builder addAdditionalContext(Reference additionalContext) {
                this.additionalContext.add(Objects.requireNonNull(additionalContext, "additionalContext"));
                return this;
            }

            /**
             * Builds the {@code NotificationEvent}.
             *
             * @return the {@code NotificationEvent}
             * @throws NullPointerException if a required element is absent
             */
            public NotificationEvent build() {
                return new NotificationEvent(
                        id, extension, modifierExtension, eventNumber, timestamp, focus, additionalContext);
            }
        }
    }

    /** Builder for {@link SubscriptionStatus}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirEnum<SubscriptionStatusCodes> status;
        private FhirEnum<SubscriptionNotificationType> type;
        private FhirInteger64 eventsSinceSubscriptionStart;
        private List<NotificationEvent> notificationEvent = new ArrayList<>();
        private Reference subscription;
        private FhirCanonical topic;
        private List<CodeableConcept> error = new ArrayList<>();

        private Builder() {
        }

        private Builder(SubscriptionStatus original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.status = original.status();
            this.type = original.type();
            this.eventsSinceSubscriptionStart = original.eventsSinceSubscriptionStart();
            this.notificationEvent = new ArrayList<>(original.notificationEvent());
            this.subscription = original.subscription();
            this.topic = original.topic();
            this.error = new ArrayList<>(original.error());
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
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<SubscriptionNotificationType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(SubscriptionNotificationType type) {
            return type(type == null ? null : FhirEnum.of(type));
        }

        /**
         * Sets {@code eventsSinceSubscriptionStart}.
         *
         * @param eventsSinceSubscriptionStart the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder eventsSinceSubscriptionStart(FhirInteger64 eventsSinceSubscriptionStart) {
            this.eventsSinceSubscriptionStart = eventsSinceSubscriptionStart;
            return this;
        }

        /**
         * Sets {@code eventsSinceSubscriptionStart}, wrapped in a {@link FhirInteger64} without id or extensions.
         *
         * @param eventsSinceSubscriptionStart the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder eventsSinceSubscriptionStart(Long eventsSinceSubscriptionStart) {
            return eventsSinceSubscriptionStart(
                    eventsSinceSubscriptionStart == null ? null : FhirInteger64.of(eventsSinceSubscriptionStart));
        }

        /**
         * Replaces all {@code notificationEvent} values.
         *
         * @param notificationEvent the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder notificationEvent(List<NotificationEvent> notificationEvent) {
            this.notificationEvent = notificationEvent == null
                    ? new ArrayList<>()
                    : new ArrayList<>(notificationEvent);
            return this;
        }

        /**
         * Adds a {@code notificationEvent} value.
         *
         * @param notificationEvent the value to add
         * @return this builder
         */
        public Builder addNotificationEvent(NotificationEvent notificationEvent) {
            this.notificationEvent.add(Objects.requireNonNull(notificationEvent, "notificationEvent"));
            return this;
        }

        /**
         * Sets {@code subscription}.
         *
         * @param subscription the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subscription(Reference subscription) {
            this.subscription = subscription;
            return this;
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
         * Replaces all {@code error} values.
         *
         * @param error the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder error(List<CodeableConcept> error) {
            this.error = error == null ? new ArrayList<>() : new ArrayList<>(error);
            return this;
        }

        /**
         * Adds a {@code error} value.
         *
         * @param error the value to add
         * @return this builder
         */
        public Builder addError(CodeableConcept error) {
            this.error.add(Objects.requireNonNull(error, "error"));
            return this;
        }

        /**
         * Builds the {@code SubscriptionStatus}.
         *
         * @return the {@code SubscriptionStatus}
         * @throws NullPointerException if a required element is absent
         */
        public SubscriptionStatus build() {
            return new SubscriptionStatus(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, status, type,
                    eventsSinceSubscriptionStart, notificationEvent, subscription, topic, error);
        }
    }
}
