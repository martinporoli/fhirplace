package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Specifies contact information for a person or organization.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param name Name of an individual to contact.
 * @param telecom Contact details for individual or organization.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ContactDetail">FHIR R5 ContactDetail</a>
 */
public record ContactDetail(
        String id,
        List<Extension> extension,
        FhirString name,
        List<ContactPoint> telecom) implements DataType {

    /**
     * Creates a {@code ContactDetail}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public ContactDetail {
        extension = extension == null ? List.of() : List.copyOf(extension);
        telecom = telecom == null ? List.of() : List.copyOf(telecom);
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
     * Returns a builder initialized with the values of this {@code ContactDetail}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link ContactDetail}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirString name;
        private List<ContactPoint> telecom = new ArrayList<>();

        private Builder() {
        }

        private Builder(ContactDetail original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.name = original.name();
            this.telecom = new ArrayList<>(original.telecom());
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
         * Replaces all {@code telecom} values.
         *
         * @param telecom the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder telecom(List<ContactPoint> telecom) {
            this.telecom = telecom == null ? new ArrayList<>() : new ArrayList<>(telecom);
            return this;
        }

        /**
         * Adds a {@code telecom} value.
         *
         * @param telecom the value to add
         * @return this builder
         */
        public Builder addTelecom(ContactPoint telecom) {
            this.telecom.add(Objects.requireNonNull(telecom, "telecom"));
            return this;
        }

        /**
         * Builds the {@code ContactDetail}.
         *
         * @return the {@code ContactDetail}
         */
        public ContactDetail build() {
            return new ContactDetail(
                    id, extension, name, telecom);
        }
    }
}
