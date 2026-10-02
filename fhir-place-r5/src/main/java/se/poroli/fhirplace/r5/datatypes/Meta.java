package se.poroli.fhirplace.r5.datatypes;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The metadata about a resource.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param versionId Version specific identifier.
 * @param lastUpdated When the resource version last changed.
 * @param source Identifies where the resource comes from.
 * @param profile Profiles this resource claims to conform to. Canonical reference to StructureDefinition.
 * @param security Security Labels applied to this resource.
 * @param tag Tags applied to this resource.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Meta">FHIR R5 Meta</a>
 */
public record Meta(
        String id,
        List<Extension> extension,
        FhirId versionId,
        FhirInstant lastUpdated,
        FhirUri source,
        List<FhirCanonical> profile,
        List<Coding> security,
        List<Coding> tag) implements DataType {

    /**
     * Creates a {@code Meta}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Meta {
        extension = extension == null ? List.of() : List.copyOf(extension);
        profile = profile == null ? List.of() : List.copyOf(profile);
        security = security == null ? List.of() : List.copyOf(security);
        tag = tag == null ? List.of() : List.copyOf(tag);
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
     * Returns a builder initialized with the values of this {@code Meta}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Meta}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirId versionId;
        private FhirInstant lastUpdated;
        private FhirUri source;
        private List<FhirCanonical> profile = new ArrayList<>();
        private List<Coding> security = new ArrayList<>();
        private List<Coding> tag = new ArrayList<>();

        private Builder() {
        }

        private Builder(Meta original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.versionId = original.versionId();
            this.lastUpdated = original.lastUpdated();
            this.source = original.source();
            this.profile = new ArrayList<>(original.profile());
            this.security = new ArrayList<>(original.security());
            this.tag = new ArrayList<>(original.tag());
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
         * Sets {@code versionId}.
         *
         * @param versionId the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionId(FhirId versionId) {
            this.versionId = versionId;
            return this;
        }

        /**
         * Sets {@code versionId}, wrapped in a {@link FhirId} without id or extensions.
         *
         * @param versionId the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionId(String versionId) {
            return versionId(versionId == null ? null : FhirId.of(versionId));
        }

        /**
         * Sets {@code lastUpdated}.
         *
         * @param lastUpdated the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastUpdated(FhirInstant lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        /**
         * Sets {@code lastUpdated}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param lastUpdated the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastUpdated(OffsetDateTime lastUpdated) {
            return lastUpdated(lastUpdated == null ? null : FhirInstant.of(lastUpdated));
        }

        /**
         * Sets {@code source}.
         *
         * @param source the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder source(FhirUri source) {
            this.source = source;
            return this;
        }

        /**
         * Sets {@code source}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param source the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder source(String source) {
            return source(source == null ? null : FhirUri.of(source));
        }

        /**
         * Replaces all {@code profile} values.
         *
         * @param profile the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder profile(List<FhirCanonical> profile) {
            this.profile = profile == null ? new ArrayList<>() : new ArrayList<>(profile);
            return this;
        }

        /**
         * Adds a {@code profile} value.
         *
         * @param profile the value to add
         * @return this builder
         */
        public Builder addProfile(FhirCanonical profile) {
            this.profile.add(Objects.requireNonNull(profile, "profile"));
            return this;
        }

        /**
         * Adds a {@code profile} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param profile the value to add
         * @return this builder
         */
        public Builder addProfile(String profile) {
            return addProfile(FhirCanonical.of(profile));
        }

        /**
         * Replaces all {@code security} values.
         *
         * @param security the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder security(List<Coding> security) {
            this.security = security == null ? new ArrayList<>() : new ArrayList<>(security);
            return this;
        }

        /**
         * Adds a {@code security} value.
         *
         * @param security the value to add
         * @return this builder
         */
        public Builder addSecurity(Coding security) {
            this.security.add(Objects.requireNonNull(security, "security"));
            return this;
        }

        /**
         * Replaces all {@code tag} values.
         *
         * @param tag the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder tag(List<Coding> tag) {
            this.tag = tag == null ? new ArrayList<>() : new ArrayList<>(tag);
            return this;
        }

        /**
         * Adds a {@code tag} value.
         *
         * @param tag the value to add
         * @return this builder
         */
        public Builder addTag(Coding tag) {
            this.tag.add(Objects.requireNonNull(tag, "tag"));
            return this;
        }

        /**
         * Builds the {@code Meta}.
         *
         * @return the {@code Meta}
         */
        public Meta build() {
            return new Meta(
                    id, extension, versionId, lastUpdated, source, profile, security, tag);
        }
    }
}
