package se.poroli.fhirplace.r5.datatypes;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A text note which also contains information about who made the statement and when.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param author Individual responsible for the annotation. One of Reference, string.
 * @param time When the annotation was made.
 * @param text The annotation - text content (as markdown). Required.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Annotation">FHIR R5 Annotation</a>
 */
public record Annotation(
        String id,
        List<Extension> extension,
        DataType author,
        FhirDateTime time,
        FhirMarkdown text) implements DataType {

    /**
     * Creates an {@code Annotation}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Annotation {
        extension = extension == null ? List.of() : List.copyOf(extension);
        Objects.requireNonNull(text, "Annotation.text is required");
        if (author != null && !(author instanceof Reference || author instanceof FhirString)) {
            throw new IllegalArgumentException(
                    "Annotation.author[x] must be one of Reference, string, but was "
                            + author.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Annotation}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Annotation}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private DataType author;
        private FhirDateTime time;
        private FhirMarkdown text;

        private Builder() {
        }

        private Builder(Annotation original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.author = original.author();
            this.time = original.time();
            this.text = original.text();
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
         * Sets {@code author} to a Reference.
         *
         * @param author the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder author(Reference author) {
            this.author = author;
            return this;
        }

        /**
         * Sets {@code author} to a string.
         *
         * @param author the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder author(FhirString author) {
            this.author = author;
            return this;
        }

        /**
         * Sets {@code author} to a string without id or extensions.
         *
         * @param author the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder author(String author) {
            this.author = author == null ? null : FhirString.of(author);
            return this;
        }

        /**
         * Sets {@code time}.
         *
         * @param time the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder time(FhirDateTime time) {
            this.time = time;
            return this;
        }

        /**
         * Sets {@code time}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param time the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder time(Temporal time) {
            return time(time == null ? null : FhirDateTime.of(time));
        }

        /**
         * Sets {@code text}.
         *
         * @param text the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder text(FhirMarkdown text) {
            this.text = text;
            return this;
        }

        /**
         * Sets {@code text}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param text the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder text(String text) {
            return text(text == null ? null : FhirMarkdown.of(text));
        }

        /**
         * Builds the {@code Annotation}.
         *
         * @return the {@code Annotation}
         * @throws NullPointerException if a required element is absent
         */
        public Annotation build() {
            return new Annotation(
                    id, extension, author, time, text);
        }
    }
}
