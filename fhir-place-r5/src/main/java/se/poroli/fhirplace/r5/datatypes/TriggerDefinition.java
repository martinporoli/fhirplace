package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.TriggerType;

/**
 * A description of a triggering event.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param type named-event | periodic | data-changed | data-added | data-modified | data-removed | data-accessed |
 *   data-access-ended. Required.
 * @param name Name or URI that identifies the event.
 * @param code Coded definition of the event.
 * @param subscriptionTopic What event. Canonical reference to SubscriptionTopic.
 * @param timing Timing of the event. One of Timing, Reference, date, dateTime.
 * @param data Triggering data of the event (multiple = 'and').
 * @param condition Whether the event triggers (boolean expression).
 * @see <a href="http://hl7.org/fhir/StructureDefinition/TriggerDefinition">FHIR R5 TriggerDefinition</a>
 */
public record TriggerDefinition(
        String id,
        List<Extension> extension,
        FhirEnum<TriggerType> type,
        FhirString name,
        CodeableConcept code,
        FhirCanonical subscriptionTopic,
        DataType timing,
        List<DataRequirement> data,
        Expression condition) implements DataType {

    /**
     * Creates a {@code TriggerDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public TriggerDefinition {
        extension = extension == null ? List.of() : List.copyOf(extension);
        data = data == null ? List.of() : List.copyOf(data);
        Objects.requireNonNull(type, "TriggerDefinition.type is required");
        if (timing != null && !(timing instanceof Timing
                || timing instanceof Reference
                || timing instanceof FhirDate
                || timing instanceof FhirDateTime)) {
            throw new IllegalArgumentException(
                    "TriggerDefinition.timing[x] must be one of Timing, Reference, date, dateTime, but was "
                            + timing.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code TriggerDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link TriggerDefinition}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirEnum<TriggerType> type;
        private FhirString name;
        private CodeableConcept code;
        private FhirCanonical subscriptionTopic;
        private DataType timing;
        private List<DataRequirement> data = new ArrayList<>();
        private Expression condition;

        private Builder() {
        }

        private Builder(TriggerDefinition original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.type = original.type();
            this.name = original.name();
            this.code = original.code();
            this.subscriptionTopic = original.subscriptionTopic();
            this.timing = original.timing();
            this.data = new ArrayList<>(original.data());
            this.condition = original.condition();
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
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<TriggerType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(TriggerType type) {
            return type(type == null ? null : FhirEnum.of(type));
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
         * Sets {@code subscriptionTopic}.
         *
         * @param subscriptionTopic the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subscriptionTopic(FhirCanonical subscriptionTopic) {
            this.subscriptionTopic = subscriptionTopic;
            return this;
        }

        /**
         * Sets {@code subscriptionTopic}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param subscriptionTopic the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subscriptionTopic(String subscriptionTopic) {
            return subscriptionTopic(subscriptionTopic == null ? null : FhirCanonical.of(subscriptionTopic));
        }

        /**
         * Sets {@code timing} to a Timing.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(Timing timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets {@code timing} to a Reference.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(Reference timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets {@code timing} to a date.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(FhirDate timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets {@code timing} to a dateTime.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(FhirDateTime timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Replaces all {@code data} values.
         *
         * @param data the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder data(List<DataRequirement> data) {
            this.data = data == null ? new ArrayList<>() : new ArrayList<>(data);
            return this;
        }

        /**
         * Adds a {@code data} value.
         *
         * @param data the value to add
         * @return this builder
         */
        public Builder addData(DataRequirement data) {
            this.data.add(Objects.requireNonNull(data, "data"));
            return this;
        }

        /**
         * Sets {@code condition}.
         *
         * @param condition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder condition(Expression condition) {
            this.condition = condition;
            return this;
        }

        /**
         * Builds the {@code TriggerDefinition}.
         *
         * @return the {@code TriggerDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public TriggerDefinition build() {
            return new TriggerDefinition(
                    id, extension, type, name, code, subscriptionTopic, timing, data, condition);
        }
    }
}
