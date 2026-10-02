package se.poroli.fhirplace.r5.devicemetric;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * Describes a measurement, calculation or setting capability of a device.
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
 * @param identifier Instance identifier.
 * @param type Identity of metric, for example Heart Rate or PEEP Setting. Required.
 * @param unit Unit of Measure for the Metric.
 * @param device Describes the link to the Device. Reference to Device. Required.
 * @param operationalStatus on | off | standby | entered-in-error.
 * @param color Color name (from CSS4) or #RRGGBB code.
 * @param category measurement | setting | calculation | unspecified. Required.
 * @param measurementFrequency Indicates how often the metric is taken or recorded.
 * @param calibration Describes the calibrations that have been performed or that are required to be performed.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DeviceMetric">FHIR R5 DeviceMetric</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record DeviceMetric(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        CodeableConcept type,
        CodeableConcept unit,
        Reference device,
        FhirEnum<DeviceMetricOperationalStatus> operationalStatus,
        FhirCode color,
        FhirEnum<DeviceMetricCategory> category,
        Quantity measurementFrequency,
        List<Calibration> calibration) implements DomainResource {

    /**
     * Creates a {@code DeviceMetric}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public DeviceMetric {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        calibration = calibration == null ? List.of() : List.copyOf(calibration);
        Objects.requireNonNull(type, "DeviceMetric.type is required");
        Objects.requireNonNull(device, "DeviceMetric.device is required");
        Objects.requireNonNull(category, "DeviceMetric.category is required");
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
     * Returns a builder initialized with the values of this {@code DeviceMetric}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Describes the calibrations that have been performed or that are required to be performed.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type unspecified | offset | gain | two-point.
     * @param state not-calibrated | calibration-required | calibrated | unspecified.
     * @param time Describes the time last calibration has been performed.
     */
    public record Calibration(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<DeviceMetricCalibrationType> type,
            FhirEnum<DeviceMetricCalibrationState> state,
            FhirInstant time) implements BackboneElement {

        /**
         * Creates a {@code Calibration}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Calibration {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
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
         * Returns a builder initialized with the values of this {@code Calibration}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Calibration}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<DeviceMetricCalibrationType> type;
            private FhirEnum<DeviceMetricCalibrationState> state;
            private FhirInstant time;

            private Builder() {
            }

            private Builder(Calibration original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.state = original.state();
                this.time = original.time();
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
            public Builder type(FhirEnum<DeviceMetricCalibrationType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(DeviceMetricCalibrationType type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Sets {@code state}.
             *
             * @param state the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder state(FhirEnum<DeviceMetricCalibrationState> state) {
                this.state = state;
                return this;
            }

            /**
             * Sets {@code state}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param state the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder state(DeviceMetricCalibrationState state) {
                return state(state == null ? null : FhirEnum.of(state));
            }

            /**
             * Sets {@code time}.
             *
             * @param time the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder time(FhirInstant time) {
                this.time = time;
                return this;
            }

            /**
             * Sets {@code time}, wrapped in a {@link FhirInstant} without id or extensions.
             *
             * @param time the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder time(OffsetDateTime time) {
                return time(time == null ? null : FhirInstant.of(time));
            }

            /**
             * Builds the {@code Calibration}.
             *
             * @return the {@code Calibration}
             */
            public Calibration build() {
                return new Calibration(
                        id, extension, modifierExtension, type, state, time);
            }
        }
    }

    /** Builder for {@link DeviceMetric}. Builders are mutable and not thread-safe. */
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
        private CodeableConcept type;
        private CodeableConcept unit;
        private Reference device;
        private FhirEnum<DeviceMetricOperationalStatus> operationalStatus;
        private FhirCode color;
        private FhirEnum<DeviceMetricCategory> category;
        private Quantity measurementFrequency;
        private List<Calibration> calibration = new ArrayList<>();

        private Builder() {
        }

        private Builder(DeviceMetric original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.type = original.type();
            this.unit = original.unit();
            this.device = original.device();
            this.operationalStatus = original.operationalStatus();
            this.color = original.color();
            this.category = original.category();
            this.measurementFrequency = original.measurementFrequency();
            this.calibration = new ArrayList<>(original.calibration());
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
         * Sets {@code unit}.
         *
         * @param unit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder unit(CodeableConcept unit) {
            this.unit = unit;
            return this;
        }

        /**
         * Sets {@code device}.
         *
         * @param device the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder device(Reference device) {
            this.device = device;
            return this;
        }

        /**
         * Sets {@code operationalStatus}.
         *
         * @param operationalStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder operationalStatus(FhirEnum<DeviceMetricOperationalStatus> operationalStatus) {
            this.operationalStatus = operationalStatus;
            return this;
        }

        /**
         * Sets {@code operationalStatus}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param operationalStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder operationalStatus(DeviceMetricOperationalStatus operationalStatus) {
            return operationalStatus(operationalStatus == null ? null : FhirEnum.of(operationalStatus));
        }

        /**
         * Sets {@code color}.
         *
         * @param color the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder color(FhirCode color) {
            this.color = color;
            return this;
        }

        /**
         * Sets {@code color}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param color the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder color(String color) {
            return color(color == null ? null : FhirCode.of(color));
        }

        /**
         * Sets {@code category}.
         *
         * @param category the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder category(FhirEnum<DeviceMetricCategory> category) {
            this.category = category;
            return this;
        }

        /**
         * Sets {@code category}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param category the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder category(DeviceMetricCategory category) {
            return category(category == null ? null : FhirEnum.of(category));
        }

        /**
         * Sets {@code measurementFrequency}.
         *
         * @param measurementFrequency the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder measurementFrequency(Quantity measurementFrequency) {
            this.measurementFrequency = measurementFrequency;
            return this;
        }

        /**
         * Replaces all {@code calibration} values.
         *
         * @param calibration the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder calibration(List<Calibration> calibration) {
            this.calibration = calibration == null ? new ArrayList<>() : new ArrayList<>(calibration);
            return this;
        }

        /**
         * Adds a {@code calibration} value.
         *
         * @param calibration the value to add
         * @return this builder
         */
        public Builder addCalibration(Calibration calibration) {
            this.calibration.add(Objects.requireNonNull(calibration, "calibration"));
            return this;
        }

        /**
         * Builds the {@code DeviceMetric}.
         *
         * @return the {@code DeviceMetric}
         * @throws NullPointerException if a required element is absent
         */
        public DeviceMetric build() {
            return new DeviceMetric(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    type, unit, device, operationalStatus, color, category, measurementFrequency, calibration);
        }
    }
}
