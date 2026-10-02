package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.ContactPointSystem;
import se.poroli.fhirplace.r5.valuesets.ContactPointUse;

/**
 * Details for all kinds of technology mediated contact points for a person or organization, including telephone,
 * email, etc.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param system phone | fax | email | pager | url | sms | other.
 * @param value The actual contact point details.
 * @param use home | work | temp | old | mobile - purpose of this contact point. Modifier element.
 * @param rank Specify preferred order of use (1 = highest).
 * @param period Time period when the contact point was/is in use.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ContactPoint">FHIR R5 ContactPoint</a>
 */
public record ContactPoint(
        String id,
        List<Extension> extension,
        FhirEnum<ContactPointSystem> system,
        FhirString value,
        FhirEnum<ContactPointUse> use,
        FhirPositiveInt rank,
        Period period) implements DataType {

    /**
     * Creates a {@code ContactPoint}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public ContactPoint {
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
     * Returns a builder initialized with the values of this {@code ContactPoint}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link ContactPoint}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirEnum<ContactPointSystem> system;
        private FhirString value;
        private FhirEnum<ContactPointUse> use;
        private FhirPositiveInt rank;
        private Period period;

        private Builder() {
        }

        private Builder(ContactPoint original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.system = original.system();
            this.value = original.value();
            this.use = original.use();
            this.rank = original.rank();
            this.period = original.period();
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
         * Sets {@code system}.
         *
         * @param system the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder system(FhirEnum<ContactPointSystem> system) {
            this.system = system;
            return this;
        }

        /**
         * Sets {@code system}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param system the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder system(ContactPointSystem system) {
            return system(system == null ? null : FhirEnum.of(system));
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
         * Sets {@code use}.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(FhirEnum<ContactPointUse> use) {
            this.use = use;
            return this;
        }

        /**
         * Sets {@code use}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(ContactPointUse use) {
            return use(use == null ? null : FhirEnum.of(use));
        }

        /**
         * Sets {@code rank}.
         *
         * @param rank the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder rank(FhirPositiveInt rank) {
            this.rank = rank;
            return this;
        }

        /**
         * Sets {@code rank}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param rank the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder rank(Integer rank) {
            return rank(rank == null ? null : FhirPositiveInt.of(rank));
        }

        /**
         * Sets {@code period}.
         *
         * @param period the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder period(Period period) {
            this.period = period;
            return this;
        }

        /**
         * Builds the {@code ContactPoint}.
         *
         * @return the {@code ContactPoint}
         */
        public ContactPoint build() {
            return new ContactPoint(
                    id, extension, system, value, use, rank, period);
        }
    }
}
