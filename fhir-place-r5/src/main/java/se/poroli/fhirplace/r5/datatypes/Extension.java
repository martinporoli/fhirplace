package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Optional Extension Element - found in all resources.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param url identifies the meaning of the extension. Required.
 * @param value Value of extension. Any datatype except Contributor, VirtualServiceDetail, MonetaryComponent,
 *   Narrative, Extension, ElementDefinition, ProductShelfLife, MarketingStatus.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Extension">FHIR R5 Extension</a>
 */
public record Extension(
        String id,
        List<Extension> extension,
        String url,
        DataType value) implements DataType {

    /**
     * Creates an {@code Extension}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Extension {
        extension = extension == null ? List.of() : List.copyOf(extension);
        Objects.requireNonNull(url, "Extension.url is required");
        if (value != null && (value instanceof Contributor
                || value instanceof VirtualServiceDetail
                || value instanceof MonetaryComponent
                || value instanceof Narrative
                || value instanceof Extension
                || value instanceof ElementDefinition
                || value instanceof ProductShelfLife
                || value instanceof MarketingStatus)) {
            throw new IllegalArgumentException(
                    "Extension.value[x] does not allow "
                            + value.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Extension}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Extension}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private String url;
        private DataType value;

        private Builder() {
        }

        private Builder(Extension original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.url = original.url();
            this.value = original.value();
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
         * Sets {@code url}.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(String url) {
            this.url = url;
            return this;
        }

        /**
         * Sets {@code value}.
         *
         * @param value the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder value(DataType value) {
            this.value = value;
            return this;
        }

        /**
         * Builds the {@code Extension}.
         *
         * @return the {@code Extension}
         * @throws NullPointerException if a required element is absent
         */
        public Extension build() {
            return new Extension(
                    id, extension, url, value);
        }
    }
}
