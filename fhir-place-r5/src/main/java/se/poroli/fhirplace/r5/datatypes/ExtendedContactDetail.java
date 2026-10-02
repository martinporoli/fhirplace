package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Specifies contact information for a specific purpose over a period of time, might be handled/monitored by a
 * specific named person or organization.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param purpose The type of contact.
 * @param name Name of an individual to contact.
 * @param telecom Contact details (e.g.phone/fax/url).
 * @param address Address for the contact.
 * @param organization This contact detail is handled/monitored by a specific organization. Reference to Organization.
 * @param period Period that this contact was valid for usage.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ExtendedContactDetail">FHIR R5 ExtendedContactDetail</a>
 */
public record ExtendedContactDetail(
        String id,
        List<Extension> extension,
        CodeableConcept purpose,
        List<HumanName> name,
        List<ContactPoint> telecom,
        Address address,
        Reference organization,
        Period period) implements DataType {

    /**
     * Creates an {@code ExtendedContactDetail}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public ExtendedContactDetail {
        extension = extension == null ? List.of() : List.copyOf(extension);
        name = name == null ? List.of() : List.copyOf(name);
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
     * Returns a builder initialized with the values of this {@code ExtendedContactDetail}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link ExtendedContactDetail}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private CodeableConcept purpose;
        private List<HumanName> name = new ArrayList<>();
        private List<ContactPoint> telecom = new ArrayList<>();
        private Address address;
        private Reference organization;
        private Period period;

        private Builder() {
        }

        private Builder(ExtendedContactDetail original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.purpose = original.purpose();
            this.name = new ArrayList<>(original.name());
            this.telecom = new ArrayList<>(original.telecom());
            this.address = original.address();
            this.organization = original.organization();
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
         * Sets {@code purpose}.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(CodeableConcept purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * Replaces all {@code name} values.
         *
         * @param name the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder name(List<HumanName> name) {
            this.name = name == null ? new ArrayList<>() : new ArrayList<>(name);
            return this;
        }

        /**
         * Adds a {@code name} value.
         *
         * @param name the value to add
         * @return this builder
         */
        public Builder addName(HumanName name) {
            this.name.add(Objects.requireNonNull(name, "name"));
            return this;
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
         * Sets {@code address}.
         *
         * @param address the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        /**
         * Sets {@code organization}.
         *
         * @param organization the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder organization(Reference organization) {
            this.organization = organization;
            return this;
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
         * Builds the {@code ExtendedContactDetail}.
         *
         * @return the {@code ExtendedContactDetail}
         */
        public ExtendedContactDetail build() {
            return new ExtendedContactDetail(
                    id, extension, purpose, name, telecom, address, organization, period);
        }
    }
}
