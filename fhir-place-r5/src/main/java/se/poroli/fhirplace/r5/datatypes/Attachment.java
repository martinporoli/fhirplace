package se.poroli.fhirplace.r5.datatypes;

import java.math.BigDecimal;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * For referring to data content defined in other formats.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param contentType Mime type of the content, with charset etc.
 * @param language Human language of the content (BCP-47).
 * @param data Data inline, base64ed.
 * @param url Uri where the data can be found.
 * @param size Number of bytes of content (if url provided).
 * @param hash Hash of the data (sha-1, base64ed).
 * @param title Label to display in place of the data.
 * @param creation Date attachment was first created.
 * @param height Height of the image in pixels (photo/video).
 * @param width Width of the image in pixels (photo/video).
 * @param frames Number of frames if &gt; 1 (photo).
 * @param duration Length in seconds (audio / video).
 * @param pages Number of printed pages.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Attachment">FHIR R5 Attachment</a>
 */
public record Attachment(
        String id,
        List<Extension> extension,
        FhirCode contentType,
        FhirCode language,
        FhirBase64Binary data,
        FhirUrl url,
        FhirInteger64 size,
        FhirBase64Binary hash,
        FhirString title,
        FhirDateTime creation,
        FhirPositiveInt height,
        FhirPositiveInt width,
        FhirPositiveInt frames,
        FhirDecimal duration,
        FhirPositiveInt pages) implements DataType {

    /**
     * Creates an {@code Attachment}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Attachment {
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
     * Returns a builder initialized with the values of this {@code Attachment}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Attachment}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirCode contentType;
        private FhirCode language;
        private FhirBase64Binary data;
        private FhirUrl url;
        private FhirInteger64 size;
        private FhirBase64Binary hash;
        private FhirString title;
        private FhirDateTime creation;
        private FhirPositiveInt height;
        private FhirPositiveInt width;
        private FhirPositiveInt frames;
        private FhirDecimal duration;
        private FhirPositiveInt pages;

        private Builder() {
        }

        private Builder(Attachment original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.contentType = original.contentType();
            this.language = original.language();
            this.data = original.data();
            this.url = original.url();
            this.size = original.size();
            this.hash = original.hash();
            this.title = original.title();
            this.creation = original.creation();
            this.height = original.height();
            this.width = original.width();
            this.frames = original.frames();
            this.duration = original.duration();
            this.pages = original.pages();
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
         * Sets {@code contentType}.
         *
         * @param contentType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder contentType(FhirCode contentType) {
            this.contentType = contentType;
            return this;
        }

        /**
         * Sets {@code contentType}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param contentType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder contentType(String contentType) {
            return contentType(contentType == null ? null : FhirCode.of(contentType));
        }

        /**
         * Sets {@code language}.
         *
         * @param language the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder language(FhirCode language) {
            this.language = language;
            return this;
        }

        /**
         * Sets {@code language}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param language the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder language(String language) {
            return language(language == null ? null : FhirCode.of(language));
        }

        /**
         * Sets {@code data}.
         *
         * @param data the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder data(FhirBase64Binary data) {
            this.data = data;
            return this;
        }

        /**
         * Sets {@code url}.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(FhirUrl url) {
            this.url = url;
            return this;
        }

        /**
         * Sets {@code url}, wrapped in a {@link FhirUrl} without id or extensions.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(String url) {
            return url(url == null ? null : FhirUrl.of(url));
        }

        /**
         * Sets {@code size}.
         *
         * @param size the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder size(FhirInteger64 size) {
            this.size = size;
            return this;
        }

        /**
         * Sets {@code size}, wrapped in a {@link FhirInteger64} without id or extensions.
         *
         * @param size the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder size(Long size) {
            return size(size == null ? null : FhirInteger64.of(size));
        }

        /**
         * Sets {@code hash}.
         *
         * @param hash the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder hash(FhirBase64Binary hash) {
            this.hash = hash;
            return this;
        }

        /**
         * Sets {@code title}.
         *
         * @param title the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder title(FhirString title) {
            this.title = title;
            return this;
        }

        /**
         * Sets {@code title}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param title the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder title(String title) {
            return title(title == null ? null : FhirString.of(title));
        }

        /**
         * Sets {@code creation}.
         *
         * @param creation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder creation(FhirDateTime creation) {
            this.creation = creation;
            return this;
        }

        /**
         * Sets {@code creation}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param creation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder creation(Temporal creation) {
            return creation(creation == null ? null : FhirDateTime.of(creation));
        }

        /**
         * Sets {@code height}.
         *
         * @param height the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder height(FhirPositiveInt height) {
            this.height = height;
            return this;
        }

        /**
         * Sets {@code height}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param height the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder height(Integer height) {
            return height(height == null ? null : FhirPositiveInt.of(height));
        }

        /**
         * Sets {@code width}.
         *
         * @param width the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder width(FhirPositiveInt width) {
            this.width = width;
            return this;
        }

        /**
         * Sets {@code width}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param width the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder width(Integer width) {
            return width(width == null ? null : FhirPositiveInt.of(width));
        }

        /**
         * Sets {@code frames}.
         *
         * @param frames the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder frames(FhirPositiveInt frames) {
            this.frames = frames;
            return this;
        }

        /**
         * Sets {@code frames}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param frames the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder frames(Integer frames) {
            return frames(frames == null ? null : FhirPositiveInt.of(frames));
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
         * Sets {@code pages}.
         *
         * @param pages the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder pages(FhirPositiveInt pages) {
            this.pages = pages;
            return this;
        }

        /**
         * Sets {@code pages}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param pages the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder pages(Integer pages) {
            return pages(pages == null ? null : FhirPositiveInt.of(pages));
        }

        /**
         * Builds the {@code Attachment}.
         *
         * @return the {@code Attachment}
         */
        public Attachment build() {
            return new Attachment(
                    id, extension, contentType, language, data, url, size, hash, title, creation, height, width,
                    frames, duration, pages);
        }
    }
}
