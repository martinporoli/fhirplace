package se.poroli.fhirplace.r5.datatypes;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A signature along with supporting context.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param type Indication of the reason the entity signed the object(s).
 * @param when When the signature was created.
 * @param who Who signed. Reference to Practitioner, PractitionerRole, RelatedPerson, Patient, Device, Organization.
 * @param onBehalfOf The party represented. Reference to Practitioner, PractitionerRole, RelatedPerson, Patient,
 *   Device, Organization.
 * @param targetFormat The technical format of the signed resources.
 * @param sigFormat The technical format of the signature.
 * @param data The actual signature content (XML DigSig. JWS, picture, etc.).
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Signature">FHIR R5 Signature</a>
 */
public record Signature(
        String id,
        List<Extension> extension,
        List<Coding> type,
        FhirInstant when,
        Reference who,
        Reference onBehalfOf,
        FhirCode targetFormat,
        FhirCode sigFormat,
        FhirBase64Binary data) implements DataType {

    /**
     * Creates a {@code Signature}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Signature {
        extension = extension == null ? List.of() : List.copyOf(extension);
        type = type == null ? List.of() : List.copyOf(type);
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
     * Returns a builder initialized with the values of this {@code Signature}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Signature}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private List<Coding> type = new ArrayList<>();
        private FhirInstant when;
        private Reference who;
        private Reference onBehalfOf;
        private FhirCode targetFormat;
        private FhirCode sigFormat;
        private FhirBase64Binary data;

        private Builder() {
        }

        private Builder(Signature original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.type = new ArrayList<>(original.type());
            this.when = original.when();
            this.who = original.who();
            this.onBehalfOf = original.onBehalfOf();
            this.targetFormat = original.targetFormat();
            this.sigFormat = original.sigFormat();
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
         * Replaces all {@code type} values.
         *
         * @param type the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder type(List<Coding> type) {
            this.type = type == null ? new ArrayList<>() : new ArrayList<>(type);
            return this;
        }

        /**
         * Adds a {@code type} value.
         *
         * @param type the value to add
         * @return this builder
         */
        public Builder addType(Coding type) {
            this.type.add(Objects.requireNonNull(type, "type"));
            return this;
        }

        /**
         * Sets {@code when}.
         *
         * @param when the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder when(FhirInstant when) {
            this.when = when;
            return this;
        }

        /**
         * Sets {@code when}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param when the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder when(OffsetDateTime when) {
            return when(when == null ? null : FhirInstant.of(when));
        }

        /**
         * Sets {@code who}.
         *
         * @param who the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder who(Reference who) {
            this.who = who;
            return this;
        }

        /**
         * Sets {@code onBehalfOf}.
         *
         * @param onBehalfOf the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder onBehalfOf(Reference onBehalfOf) {
            this.onBehalfOf = onBehalfOf;
            return this;
        }

        /**
         * Sets {@code targetFormat}.
         *
         * @param targetFormat the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder targetFormat(FhirCode targetFormat) {
            this.targetFormat = targetFormat;
            return this;
        }

        /**
         * Sets {@code targetFormat}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param targetFormat the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder targetFormat(String targetFormat) {
            return targetFormat(targetFormat == null ? null : FhirCode.of(targetFormat));
        }

        /**
         * Sets {@code sigFormat}.
         *
         * @param sigFormat the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sigFormat(FhirCode sigFormat) {
            this.sigFormat = sigFormat;
            return this;
        }

        /**
         * Sets {@code sigFormat}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param sigFormat the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sigFormat(String sigFormat) {
            return sigFormat(sigFormat == null ? null : FhirCode.of(sigFormat));
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
         * Builds the {@code Signature}.
         *
         * @return the {@code Signature}
         */
        public Signature build() {
            return new Signature(
                    id, extension, type, when, who, onBehalfOf, targetFormat, sigFormat, data);
        }
    }
}
