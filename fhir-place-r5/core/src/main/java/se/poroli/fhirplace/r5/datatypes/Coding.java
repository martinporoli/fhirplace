package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A reference to a code defined by a terminology system.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param system Identity of the terminology system.
 * @param version Version of the system - if relevant.
 * @param code Symbol in syntax defined by the system.
 * @param display Representation defined by the system.
 * @param userSelected If this coding was chosen directly by the user.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Coding">FHIR R5 Coding</a>
 */
public record Coding(
        String id,
        List<Extension> extension,
        FhirUri system,
        FhirString version,
        FhirCode code,
        FhirString display,
        FhirBoolean userSelected) implements DataType {

    /**
     * Creates a {@code Coding}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Coding {
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
     * Returns a builder initialized with the values of this {@code Coding}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Coding}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirUri system;
        private FhirString version;
        private FhirCode code;
        private FhirString display;
        private FhirBoolean userSelected;

        private Builder() {
        }

        private Builder(Coding original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.system = original.system();
            this.version = original.version();
            this.code = original.code();
            this.display = original.display();
            this.userSelected = original.userSelected();
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
        public Builder system(FhirUri system) {
            this.system = system;
            return this;
        }

        /**
         * Sets {@code system}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param system the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder system(String system) {
            return system(system == null ? null : FhirUri.of(system));
        }

        /**
         * Sets {@code version}.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(FhirString version) {
            this.version = version;
            return this;
        }

        /**
         * Sets {@code version}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(String version) {
            return version(version == null ? null : FhirString.of(version));
        }

        /**
         * Sets {@code code}.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(FhirCode code) {
            this.code = code;
            return this;
        }

        /**
         * Sets {@code code}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(String code) {
            return code(code == null ? null : FhirCode.of(code));
        }

        /**
         * Sets {@code display}.
         *
         * @param display the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder display(FhirString display) {
            this.display = display;
            return this;
        }

        /**
         * Sets {@code display}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param display the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder display(String display) {
            return display(display == null ? null : FhirString.of(display));
        }

        /**
         * Sets {@code userSelected}.
         *
         * @param userSelected the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder userSelected(FhirBoolean userSelected) {
            this.userSelected = userSelected;
            return this;
        }

        /**
         * Sets {@code userSelected}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param userSelected the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder userSelected(Boolean userSelected) {
            return userSelected(userSelected == null ? null : FhirBoolean.of(userSelected));
        }

        /**
         * Builds the {@code Coding}.
         *
         * @return the {@code Coding}
         */
        public Coding build() {
            return new Coding(
                    id, extension, system, version, code, display, userSelected);
        }
    }
}
