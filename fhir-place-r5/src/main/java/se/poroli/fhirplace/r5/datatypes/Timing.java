package se.poroli.fhirplace.r5.datatypes;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.DaysOfWeek;
import se.poroli.fhirplace.r5.valuesets.UnitsOfTime;

/**
 * Specifies an event that may occur multiple times.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
 * @param event When the event occurs.
 * @param repeat When the event is to occur.
 * @param code C | BID | TID | QID | AM | PM | QD | QOD | +.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Timing">FHIR R5 Timing</a>
 */
public record Timing(
        String id,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<FhirDateTime> event,
        Repeat repeat,
        CodeableConcept code) implements BackboneType {

    /**
     * Creates a {@code Timing}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Timing {
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        event = event == null ? List.of() : List.copyOf(event);
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
     * Returns a builder initialized with the values of this {@code Timing}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A set of rules that describe when the event is scheduled.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param bounds Length/Range of lengths, or (Start and/or end) limits. One of Duration, Range, Period.
     * @param count Number of times to repeat.
     * @param countMax Maximum number of times to repeat.
     * @param duration How long when it happens.
     * @param durationMax How long when it happens (Max).
     * @param durationUnit s | min | h | d | wk | mo | a - unit of time (UCUM).
     * @param frequency Indicates the number of repetitions that should occur within a period. I.e. Event occurs
     *   frequency times per period.
     * @param frequencyMax Event occurs up to frequencyMax times per period.
     * @param period The duration to which the frequency applies. I.e. Event occurs frequency times per period.
     * @param periodMax Upper limit of period (3-4 hours).
     * @param periodUnit s | min | h | d | wk | mo | a - unit of time (UCUM).
     * @param dayOfWeek mon | tue | wed | thu | fri | sat | sun.
     * @param timeOfDay Time of day for action.
     * @param when Code for time period of occurrence.
     * @param offset Minutes from event (before or after).
     */
    public record Repeat(
            String id,
            List<Extension> extension,
            DataType bounds,
            FhirPositiveInt count,
            FhirPositiveInt countMax,
            FhirDecimal duration,
            FhirDecimal durationMax,
            FhirEnum<UnitsOfTime> durationUnit,
            FhirPositiveInt frequency,
            FhirPositiveInt frequencyMax,
            FhirDecimal period,
            FhirDecimal periodMax,
            FhirEnum<UnitsOfTime> periodUnit,
            List<FhirEnum<DaysOfWeek>> dayOfWeek,
            List<FhirTime> timeOfDay,
            List<FhirCode> when,
            FhirUnsignedInt offset) implements Element {

        /**
         * Creates a {@code Repeat}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Repeat {
            extension = extension == null ? List.of() : List.copyOf(extension);
            dayOfWeek = dayOfWeek == null ? List.of() : List.copyOf(dayOfWeek);
            timeOfDay = timeOfDay == null ? List.of() : List.copyOf(timeOfDay);
            when = when == null ? List.of() : List.copyOf(when);
            if (bounds != null && !(bounds instanceof Duration
                    || bounds instanceof Range
                    || bounds instanceof Period)) {
                throw new IllegalArgumentException(
                        "Timing.repeat.bounds[x] must be one of Duration, Range, Period, but was "
                                + bounds.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Repeat}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Repeat}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private DataType bounds;
            private FhirPositiveInt count;
            private FhirPositiveInt countMax;
            private FhirDecimal duration;
            private FhirDecimal durationMax;
            private FhirEnum<UnitsOfTime> durationUnit;
            private FhirPositiveInt frequency;
            private FhirPositiveInt frequencyMax;
            private FhirDecimal period;
            private FhirDecimal periodMax;
            private FhirEnum<UnitsOfTime> periodUnit;
            private List<FhirEnum<DaysOfWeek>> dayOfWeek = new ArrayList<>();
            private List<FhirTime> timeOfDay = new ArrayList<>();
            private List<FhirCode> when = new ArrayList<>();
            private FhirUnsignedInt offset;

            private Builder() {
            }

            private Builder(Repeat original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.bounds = original.bounds();
                this.count = original.count();
                this.countMax = original.countMax();
                this.duration = original.duration();
                this.durationMax = original.durationMax();
                this.durationUnit = original.durationUnit();
                this.frequency = original.frequency();
                this.frequencyMax = original.frequencyMax();
                this.period = original.period();
                this.periodMax = original.periodMax();
                this.periodUnit = original.periodUnit();
                this.dayOfWeek = new ArrayList<>(original.dayOfWeek());
                this.timeOfDay = new ArrayList<>(original.timeOfDay());
                this.when = new ArrayList<>(original.when());
                this.offset = original.offset();
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
             * Sets {@code bounds} to a Duration.
             *
             * @param bounds the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder bounds(Duration bounds) {
                this.bounds = bounds;
                return this;
            }

            /**
             * Sets {@code bounds} to a Range.
             *
             * @param bounds the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder bounds(Range bounds) {
                this.bounds = bounds;
                return this;
            }

            /**
             * Sets {@code bounds} to a Period.
             *
             * @param bounds the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder bounds(Period bounds) {
                this.bounds = bounds;
                return this;
            }

            /**
             * Sets {@code count}.
             *
             * @param count the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder count(FhirPositiveInt count) {
                this.count = count;
                return this;
            }

            /**
             * Sets {@code count}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param count the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder count(Integer count) {
                return count(count == null ? null : FhirPositiveInt.of(count));
            }

            /**
             * Sets {@code countMax}.
             *
             * @param countMax the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder countMax(FhirPositiveInt countMax) {
                this.countMax = countMax;
                return this;
            }

            /**
             * Sets {@code countMax}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param countMax the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder countMax(Integer countMax) {
                return countMax(countMax == null ? null : FhirPositiveInt.of(countMax));
            }

            /**
             * Sets {@code duration}.
             *
             * @param duration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder duration(FhirDecimal duration) {
                this.duration = duration;
                return this;
            }

            /**
             * Sets {@code duration}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param duration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder duration(BigDecimal duration) {
                return duration(duration == null ? null : FhirDecimal.of(duration));
            }

            /**
             * Sets {@code durationMax}.
             *
             * @param durationMax the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder durationMax(FhirDecimal durationMax) {
                this.durationMax = durationMax;
                return this;
            }

            /**
             * Sets {@code durationMax}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param durationMax the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder durationMax(BigDecimal durationMax) {
                return durationMax(durationMax == null ? null : FhirDecimal.of(durationMax));
            }

            /**
             * Sets {@code durationUnit}.
             *
             * @param durationUnit the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder durationUnit(FhirEnum<UnitsOfTime> durationUnit) {
                this.durationUnit = durationUnit;
                return this;
            }

            /**
             * Sets {@code durationUnit}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param durationUnit the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder durationUnit(UnitsOfTime durationUnit) {
                return durationUnit(durationUnit == null ? null : FhirEnum.of(durationUnit));
            }

            /**
             * Sets {@code frequency}.
             *
             * @param frequency the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder frequency(FhirPositiveInt frequency) {
                this.frequency = frequency;
                return this;
            }

            /**
             * Sets {@code frequency}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param frequency the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder frequency(Integer frequency) {
                return frequency(frequency == null ? null : FhirPositiveInt.of(frequency));
            }

            /**
             * Sets {@code frequencyMax}.
             *
             * @param frequencyMax the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder frequencyMax(FhirPositiveInt frequencyMax) {
                this.frequencyMax = frequencyMax;
                return this;
            }

            /**
             * Sets {@code frequencyMax}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param frequencyMax the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder frequencyMax(Integer frequencyMax) {
                return frequencyMax(frequencyMax == null ? null : FhirPositiveInt.of(frequencyMax));
            }

            /**
             * Sets {@code period}.
             *
             * @param period the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder period(FhirDecimal period) {
                this.period = period;
                return this;
            }

            /**
             * Sets {@code period}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param period the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder period(BigDecimal period) {
                return period(period == null ? null : FhirDecimal.of(period));
            }

            /**
             * Sets {@code periodMax}.
             *
             * @param periodMax the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder periodMax(FhirDecimal periodMax) {
                this.periodMax = periodMax;
                return this;
            }

            /**
             * Sets {@code periodMax}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param periodMax the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder periodMax(BigDecimal periodMax) {
                return periodMax(periodMax == null ? null : FhirDecimal.of(periodMax));
            }

            /**
             * Sets {@code periodUnit}.
             *
             * @param periodUnit the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder periodUnit(FhirEnum<UnitsOfTime> periodUnit) {
                this.periodUnit = periodUnit;
                return this;
            }

            /**
             * Sets {@code periodUnit}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param periodUnit the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder periodUnit(UnitsOfTime periodUnit) {
                return periodUnit(periodUnit == null ? null : FhirEnum.of(periodUnit));
            }

            /**
             * Replaces all {@code dayOfWeek} values.
             *
             * @param dayOfWeek the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder dayOfWeek(List<FhirEnum<DaysOfWeek>> dayOfWeek) {
                this.dayOfWeek = dayOfWeek == null ? new ArrayList<>() : new ArrayList<>(dayOfWeek);
                return this;
            }

            /**
             * Adds a {@code dayOfWeek} value.
             *
             * @param dayOfWeek the value to add
             * @return this builder
             */
            public Builder addDayOfWeek(FhirEnum<DaysOfWeek> dayOfWeek) {
                this.dayOfWeek.add(Objects.requireNonNull(dayOfWeek, "dayOfWeek"));
                return this;
            }

            /**
             * Adds a {@code dayOfWeek} value, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param dayOfWeek the value to add
             * @return this builder
             */
            public Builder addDayOfWeek(DaysOfWeek dayOfWeek) {
                return addDayOfWeek(FhirEnum.of(dayOfWeek));
            }

            /**
             * Replaces all {@code timeOfDay} values.
             *
             * @param timeOfDay the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder timeOfDay(List<FhirTime> timeOfDay) {
                this.timeOfDay = timeOfDay == null ? new ArrayList<>() : new ArrayList<>(timeOfDay);
                return this;
            }

            /**
             * Adds a {@code timeOfDay} value.
             *
             * @param timeOfDay the value to add
             * @return this builder
             */
            public Builder addTimeOfDay(FhirTime timeOfDay) {
                this.timeOfDay.add(Objects.requireNonNull(timeOfDay, "timeOfDay"));
                return this;
            }

            /**
             * Adds a {@code timeOfDay} value, wrapped in a {@link FhirTime} without id or extensions.
             *
             * @param timeOfDay the value to add
             * @return this builder
             */
            public Builder addTimeOfDay(LocalTime timeOfDay) {
                return addTimeOfDay(FhirTime.of(timeOfDay));
            }

            /**
             * Replaces all {@code when} values.
             *
             * @param when the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder when(List<FhirCode> when) {
                this.when = when == null ? new ArrayList<>() : new ArrayList<>(when);
                return this;
            }

            /**
             * Adds a {@code when} value.
             *
             * @param when the value to add
             * @return this builder
             */
            public Builder addWhen(FhirCode when) {
                this.when.add(Objects.requireNonNull(when, "when"));
                return this;
            }

            /**
             * Adds a {@code when} value, wrapped in a {@link FhirCode} without id or extensions.
             *
             * @param when the value to add
             * @return this builder
             */
            public Builder addWhen(String when) {
                return addWhen(FhirCode.of(when));
            }

            /**
             * Sets {@code offset}.
             *
             * @param offset the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder offset(FhirUnsignedInt offset) {
                this.offset = offset;
                return this;
            }

            /**
             * Sets {@code offset}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
             *
             * @param offset the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder offset(Integer offset) {
                return offset(offset == null ? null : FhirUnsignedInt.of(offset));
            }

            /**
             * Builds the {@code Repeat}.
             *
             * @return the {@code Repeat}
             */
            public Repeat build() {
                return new Repeat(
                        id, extension, bounds, count, countMax, duration, durationMax, durationUnit, frequency,
                        frequencyMax, period, periodMax, periodUnit, dayOfWeek, timeOfDay, when, offset);
            }
        }
    }

    /** Builder for {@link Timing}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private List<FhirDateTime> event = new ArrayList<>();
        private Repeat repeat;
        private CodeableConcept code;

        private Builder() {
        }

        private Builder(Timing original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.event = new ArrayList<>(original.event());
            this.repeat = original.repeat();
            this.code = original.code();
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
         * Replaces all {@code event} values.
         *
         * @param event the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder event(List<FhirDateTime> event) {
            this.event = event == null ? new ArrayList<>() : new ArrayList<>(event);
            return this;
        }

        /**
         * Adds a {@code event} value.
         *
         * @param event the value to add
         * @return this builder
         */
        public Builder addEvent(FhirDateTime event) {
            this.event.add(Objects.requireNonNull(event, "event"));
            return this;
        }

        /**
         * Adds a {@code event} value, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param event the value to add
         * @return this builder
         */
        public Builder addEvent(Temporal event) {
            return addEvent(FhirDateTime.of(event));
        }

        /**
         * Sets {@code repeat}.
         *
         * @param repeat the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder repeat(Repeat repeat) {
            this.repeat = repeat;
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
         * Builds the {@code Timing}.
         *
         * @return the {@code Timing}
         */
        public Timing build() {
            return new Timing(
                    id, extension, modifierExtension, event, repeat, code);
        }
    }
}
