package se.poroli.fhirplace.r5.datatypes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A series of measurements taken by a device, with upper and lower limits.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param origin Zero value and units. Required.
 * @param interval Number of intervalUnits between samples.
 * @param intervalUnit The measurement unit of the interval between samples. Required.
 * @param factor Multiply data by this before adding to origin.
 * @param lowerLimit Lower limit of detection.
 * @param upperLimit Upper limit of detection.
 * @param dimensions Number of sample points at each time point. Required.
 * @param codeMap Defines the codes used in the data. Canonical reference to ConceptMap.
 * @param offsets Offsets, typically in time, at which data values were taken.
 * @param data Decimal values with spaces, or "E" | "U" | "L", or another code.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/SampledData">FHIR R5 SampledData</a>
 */
public record SampledData(
        String id,
        List<Extension> extension,
        Quantity origin,
        FhirDecimal interval,
        FhirCode intervalUnit,
        FhirDecimal factor,
        FhirDecimal lowerLimit,
        FhirDecimal upperLimit,
        FhirPositiveInt dimensions,
        FhirCanonical codeMap,
        FhirString offsets,
        FhirString data) implements DataType {

    /**
     * Creates a {@code SampledData}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public SampledData {
        extension = extension == null ? List.of() : List.copyOf(extension);
        Objects.requireNonNull(origin, "SampledData.origin is required");
        Objects.requireNonNull(intervalUnit, "SampledData.intervalUnit is required");
        Objects.requireNonNull(dimensions, "SampledData.dimensions is required");
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
     * Returns a builder initialized with the values of this {@code SampledData}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link SampledData}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private Quantity origin;
        private FhirDecimal interval;
        private FhirCode intervalUnit;
        private FhirDecimal factor;
        private FhirDecimal lowerLimit;
        private FhirDecimal upperLimit;
        private FhirPositiveInt dimensions;
        private FhirCanonical codeMap;
        private FhirString offsets;
        private FhirString data;

        private Builder() {
        }

        private Builder(SampledData original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.origin = original.origin();
            this.interval = original.interval();
            this.intervalUnit = original.intervalUnit();
            this.factor = original.factor();
            this.lowerLimit = original.lowerLimit();
            this.upperLimit = original.upperLimit();
            this.dimensions = original.dimensions();
            this.codeMap = original.codeMap();
            this.offsets = original.offsets();
            this.data = original.data();
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
         * Sets {@code origin}.
         *
         * @param origin the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder origin(Quantity origin) {
            this.origin = origin;
            return this;
        }

        /**
         * Sets {@code interval}.
         *
         * @param interval the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder interval(FhirDecimal interval) {
            this.interval = interval;
            return this;
        }

        /**
         * Sets {@code interval}, wrapped in a {@link FhirDecimal} without id or extensions.
         *
         * @param interval the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder interval(BigDecimal interval) {
            return interval(interval == null ? null : FhirDecimal.of(interval));
        }

        /**
         * Sets {@code intervalUnit}.
         *
         * @param intervalUnit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intervalUnit(FhirCode intervalUnit) {
            this.intervalUnit = intervalUnit;
            return this;
        }

        /**
         * Sets {@code intervalUnit}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param intervalUnit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intervalUnit(String intervalUnit) {
            return intervalUnit(intervalUnit == null ? null : FhirCode.of(intervalUnit));
        }

        /**
         * Sets {@code factor}.
         *
         * @param factor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder factor(FhirDecimal factor) {
            this.factor = factor;
            return this;
        }

        /**
         * Sets {@code factor}, wrapped in a {@link FhirDecimal} without id or extensions.
         *
         * @param factor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder factor(BigDecimal factor) {
            return factor(factor == null ? null : FhirDecimal.of(factor));
        }

        /**
         * Sets {@code lowerLimit}.
         *
         * @param lowerLimit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lowerLimit(FhirDecimal lowerLimit) {
            this.lowerLimit = lowerLimit;
            return this;
        }

        /**
         * Sets {@code lowerLimit}, wrapped in a {@link FhirDecimal} without id or extensions.
         *
         * @param lowerLimit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lowerLimit(BigDecimal lowerLimit) {
            return lowerLimit(lowerLimit == null ? null : FhirDecimal.of(lowerLimit));
        }

        /**
         * Sets {@code upperLimit}.
         *
         * @param upperLimit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder upperLimit(FhirDecimal upperLimit) {
            this.upperLimit = upperLimit;
            return this;
        }

        /**
         * Sets {@code upperLimit}, wrapped in a {@link FhirDecimal} without id or extensions.
         *
         * @param upperLimit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder upperLimit(BigDecimal upperLimit) {
            return upperLimit(upperLimit == null ? null : FhirDecimal.of(upperLimit));
        }

        /**
         * Sets {@code dimensions}.
         *
         * @param dimensions the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dimensions(FhirPositiveInt dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        /**
         * Sets {@code dimensions}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param dimensions the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dimensions(Integer dimensions) {
            return dimensions(dimensions == null ? null : FhirPositiveInt.of(dimensions));
        }

        /**
         * Sets {@code codeMap}.
         *
         * @param codeMap the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder codeMap(FhirCanonical codeMap) {
            this.codeMap = codeMap;
            return this;
        }

        /**
         * Sets {@code codeMap}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param codeMap the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder codeMap(String codeMap) {
            return codeMap(codeMap == null ? null : FhirCanonical.of(codeMap));
        }

        /**
         * Sets {@code offsets}.
         *
         * @param offsets the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder offsets(FhirString offsets) {
            this.offsets = offsets;
            return this;
        }

        /**
         * Sets {@code offsets}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param offsets the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder offsets(String offsets) {
            return offsets(offsets == null ? null : FhirString.of(offsets));
        }

        /**
         * Sets {@code data}.
         *
         * @param data the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder data(FhirString data) {
            this.data = data;
            return this;
        }

        /**
         * Sets {@code data}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param data the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder data(String data) {
            return data(data == null ? null : FhirString.of(data));
        }

        /**
         * Builds the {@code SampledData}.
         *
         * @return the {@code SampledData}
         * @throws NullPointerException if a required element is absent
         */
        public SampledData build() {
            return new SampledData(
                    id, extension, origin, interval, intervalUnit, factor, lowerLimit, upperLimit, dimensions,
                    codeMap, offsets, data);
        }
    }
}
