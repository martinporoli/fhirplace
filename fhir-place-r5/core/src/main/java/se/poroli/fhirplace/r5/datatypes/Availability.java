package se.poroli.fhirplace.r5.datatypes;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.DaysOfWeek;

/**
 * Availability data for an {item}.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param availableTime Times the {item} is available.
 * @param notAvailableTime Not available during this time due to provided reason.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Availability">FHIR R5 Availability</a>
 */
public record Availability(
        String id,
        List<Extension> extension,
        List<AvailableTime> availableTime,
        List<NotAvailableTime> notAvailableTime) implements DataType {

    /**
     * Creates an {@code Availability}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Availability {
        extension = extension == null ? List.of() : List.copyOf(extension);
        availableTime = availableTime == null ? List.of() : List.copyOf(availableTime);
        notAvailableTime = notAvailableTime == null ? List.of() : List.copyOf(notAvailableTime);
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
     * Returns a builder initialized with the values of this {@code Availability}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Times the {item} is available.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param daysOfWeek mon | tue | wed | thu | fri | sat | sun.
     * @param allDay Always available? i.e. 24 hour service.
     * @param availableStartTime Opening time of day (ignored if allDay = true).
     * @param availableEndTime Closing time of day (ignored if allDay = true).
     */
    public record AvailableTime(
            String id,
            List<Extension> extension,
            List<FhirEnum<DaysOfWeek>> daysOfWeek,
            FhirBoolean allDay,
            FhirTime availableStartTime,
            FhirTime availableEndTime) implements Element {

        /**
         * Creates an {@code AvailableTime}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public AvailableTime {
            extension = extension == null ? List.of() : List.copyOf(extension);
            daysOfWeek = daysOfWeek == null ? List.of() : List.copyOf(daysOfWeek);
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
         * Returns a builder initialized with the values of this {@code AvailableTime}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link AvailableTime}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<FhirEnum<DaysOfWeek>> daysOfWeek = new ArrayList<>();
            private FhirBoolean allDay;
            private FhirTime availableStartTime;
            private FhirTime availableEndTime;

            private Builder() {
            }

            private Builder(AvailableTime original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.daysOfWeek = new ArrayList<>(original.daysOfWeek());
                this.allDay = original.allDay();
                this.availableStartTime = original.availableStartTime();
                this.availableEndTime = original.availableEndTime();
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
             * Replaces all {@code daysOfWeek} values.
             *
             * @param daysOfWeek the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder daysOfWeek(List<FhirEnum<DaysOfWeek>> daysOfWeek) {
                this.daysOfWeek = daysOfWeek == null ? new ArrayList<>() : new ArrayList<>(daysOfWeek);
                return this;
            }

            /**
             * Adds a {@code daysOfWeek} value.
             *
             * @param daysOfWeek the value to add
             * @return this builder
             */
            public Builder addDaysOfWeek(FhirEnum<DaysOfWeek> daysOfWeek) {
                this.daysOfWeek.add(Objects.requireNonNull(daysOfWeek, "daysOfWeek"));
                return this;
            }

            /**
             * Adds a {@code daysOfWeek} value, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param daysOfWeek the value to add
             * @return this builder
             */
            public Builder addDaysOfWeek(DaysOfWeek daysOfWeek) {
                return addDaysOfWeek(FhirEnum.of(daysOfWeek));
            }

            /**
             * Sets {@code allDay}.
             *
             * @param allDay the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder allDay(FhirBoolean allDay) {
                this.allDay = allDay;
                return this;
            }

            /**
             * Sets {@code allDay}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param allDay the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder allDay(Boolean allDay) {
                return allDay(allDay == null ? null : FhirBoolean.of(allDay));
            }

            /**
             * Sets {@code availableStartTime}.
             *
             * @param availableStartTime the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder availableStartTime(FhirTime availableStartTime) {
                this.availableStartTime = availableStartTime;
                return this;
            }

            /**
             * Sets {@code availableStartTime}, wrapped in a {@link FhirTime} without id or extensions.
             *
             * @param availableStartTime the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder availableStartTime(LocalTime availableStartTime) {
                return availableStartTime(availableStartTime == null ? null : FhirTime.of(availableStartTime));
            }

            /**
             * Sets {@code availableEndTime}.
             *
             * @param availableEndTime the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder availableEndTime(FhirTime availableEndTime) {
                this.availableEndTime = availableEndTime;
                return this;
            }

            /**
             * Sets {@code availableEndTime}, wrapped in a {@link FhirTime} without id or extensions.
             *
             * @param availableEndTime the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder availableEndTime(LocalTime availableEndTime) {
                return availableEndTime(availableEndTime == null ? null : FhirTime.of(availableEndTime));
            }

            /**
             * Builds the {@code AvailableTime}.
             *
             * @return the {@code AvailableTime}
             */
            public AvailableTime build() {
                return new AvailableTime(
                        id, extension, daysOfWeek, allDay, availableStartTime, availableEndTime);
            }
        }
    }

    /**
     * Not available during this time due to provided reason.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param description Reason presented to the user explaining why time not available.
     * @param during Service not available during this period.
     */
    public record NotAvailableTime(
            String id,
            List<Extension> extension,
            FhirString description,
            Period during) implements Element {

        /**
         * Creates a {@code NotAvailableTime}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public NotAvailableTime {
            extension = extension == null ? List.of() : List.copyOf(extension);
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
         * Returns a builder initialized with the values of this {@code NotAvailableTime}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link NotAvailableTime}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private FhirString description;
            private Period during;

            private Builder() {
            }

            private Builder(NotAvailableTime original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.description = original.description();
                this.during = original.during();
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
             * Sets {@code description}.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(FhirString description) {
                this.description = description;
                return this;
            }

            /**
             * Sets {@code description}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(String description) {
                return description(description == null ? null : FhirString.of(description));
            }

            /**
             * Sets {@code during}.
             *
             * @param during the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder during(Period during) {
                this.during = during;
                return this;
            }

            /**
             * Builds the {@code NotAvailableTime}.
             *
             * @return the {@code NotAvailableTime}
             */
            public NotAvailableTime build() {
                return new NotAvailableTime(
                        id, extension, description, during);
            }
        }
    }

    /** Builder for {@link Availability}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private List<AvailableTime> availableTime = new ArrayList<>();
        private List<NotAvailableTime> notAvailableTime = new ArrayList<>();

        private Builder() {
        }

        private Builder(Availability original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.availableTime = new ArrayList<>(original.availableTime());
            this.notAvailableTime = new ArrayList<>(original.notAvailableTime());
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
         * Replaces all {@code availableTime} values.
         *
         * @param availableTime the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder availableTime(List<AvailableTime> availableTime) {
            this.availableTime = availableTime == null ? new ArrayList<>() : new ArrayList<>(availableTime);
            return this;
        }

        /**
         * Adds a {@code availableTime} value.
         *
         * @param availableTime the value to add
         * @return this builder
         */
        public Builder addAvailableTime(AvailableTime availableTime) {
            this.availableTime.add(Objects.requireNonNull(availableTime, "availableTime"));
            return this;
        }

        /**
         * Replaces all {@code notAvailableTime} values.
         *
         * @param notAvailableTime the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder notAvailableTime(List<NotAvailableTime> notAvailableTime) {
            this.notAvailableTime = notAvailableTime == null ? new ArrayList<>() : new ArrayList<>(notAvailableTime);
            return this;
        }

        /**
         * Adds a {@code notAvailableTime} value.
         *
         * @param notAvailableTime the value to add
         * @return this builder
         */
        public Builder addNotAvailableTime(NotAvailableTime notAvailableTime) {
            this.notAvailableTime.add(Objects.requireNonNull(notAvailableTime, "notAvailableTime"));
            return this;
        }

        /**
         * Builds the {@code Availability}.
         *
         * @return the {@code Availability}
         */
        public Availability build() {
            return new Availability(
                    id, extension, availableTime, notAvailableTime);
        }
    }
}
