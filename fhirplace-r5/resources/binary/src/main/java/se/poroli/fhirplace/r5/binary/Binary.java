package se.poroli.fhirplace.r5.binary;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * A resource that represents the data of a single raw artifact as digital content accessible in its native format.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Logical id of this artifact.
 * @param meta Metadata about the resource.
 * @param implicitRules A set of rules under which this content was created. Modifier element.
 * @param language Language of the resource content.
 * @param contentType MimeType of the binary content. Required.
 * @param securityContext Identifies another resource to use as proxy when enforcing access control. Reference to
 *   Resource.
 * @param data The actual content.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Binary">FHIR R5 Binary</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Binary(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        FhirCode contentType,
        Reference securityContext,
        FhirBase64Binary data) implements Resource {

    /**
     * Creates a {@code Binary}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Binary {
        Objects.requireNonNull(contentType, "Binary.contentType is required");
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
     * Returns a builder initialized with the values of this {@code Binary}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Binary}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private FhirCode contentType;
        private Reference securityContext;
        private FhirBase64Binary data;

        private Builder() {
        }

        private Builder(Binary original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.contentType = original.contentType();
            this.securityContext = original.securityContext();
            this.data = original.data();
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
         * Sets {@code meta}.
         *
         * @param meta the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder meta(Meta meta) {
            this.meta = meta;
            return this;
        }

        /**
         * Sets {@code implicitRules}.
         *
         * @param implicitRules the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder implicitRules(FhirUri implicitRules) {
            this.implicitRules = implicitRules;
            return this;
        }

        /**
         * Sets {@code implicitRules}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param implicitRules the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder implicitRules(String implicitRules) {
            return implicitRules(implicitRules == null ? null : FhirUri.of(implicitRules));
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
         * Sets {@code securityContext}.
         *
         * @param securityContext the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder securityContext(Reference securityContext) {
            this.securityContext = securityContext;
            return this;
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
         * Builds the {@code Binary}.
         *
         * @return the {@code Binary}
         * @throws NullPointerException if a required element is absent
         */
        public Binary build() {
            return new Binary(
                    id, meta, implicitRules, language, contentType, securityContext, data);
        }
    }
}
