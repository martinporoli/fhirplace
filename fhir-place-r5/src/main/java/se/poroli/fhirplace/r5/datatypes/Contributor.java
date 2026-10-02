package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.ContributorType;

/**
 * A contributor to the content of a knowledge asset, including authors, editors, reviewers, and endorsers.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param type author | editor | reviewer | endorser. Required.
 * @param name Who contributed the content. Required.
 * @param contact Contact details of the contributor.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Contributor">FHIR R5 Contributor</a>
 */
public record Contributor(
        String id,
        List<Extension> extension,
        FhirEnum<ContributorType> type,
        FhirString name,
        List<ContactDetail> contact) implements DataType {

    /**
     * Creates a {@code Contributor}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Contributor {
        extension = extension == null ? List.of() : List.copyOf(extension);
        contact = contact == null ? List.of() : List.copyOf(contact);
        Objects.requireNonNull(type, "Contributor.type is required");
        Objects.requireNonNull(name, "Contributor.name is required");
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
     * Returns a builder initialized with the values of this {@code Contributor}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Contributor}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirEnum<ContributorType> type;
        private FhirString name;
        private List<ContactDetail> contact = new ArrayList<>();

        private Builder() {
        }

        private Builder(Contributor original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.type = original.type();
            this.name = original.name();
            this.contact = new ArrayList<>(original.contact());
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
        public Builder type(FhirEnum<ContributorType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(ContributorType type) {
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
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ContactDetail> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ContactDetail contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
            return this;
        }

        /**
         * Builds the {@code Contributor}.
         *
         * @return the {@code Contributor}
         * @throws NullPointerException if a required element is absent
         */
        public Contributor build() {
            return new Contributor(
                    id, extension, type, name, contact);
        }
    }
}
