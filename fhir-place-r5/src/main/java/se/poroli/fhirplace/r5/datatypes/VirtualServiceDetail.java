package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Virtual Service Contact Details.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param channelType Channel Type.
 * @param address Contact address/number. One of url, string, ContactPoint, ExtendedContactDetail.
 * @param additionalInfo Address to see alternative connection details.
 * @param maxParticipants Maximum number of participants supported by the virtual service.
 * @param sessionKey Session Key required by the virtual service.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/VirtualServiceDetail">FHIR R5 VirtualServiceDetail</a>
 */
public record VirtualServiceDetail(
        String id,
        List<Extension> extension,
        Coding channelType,
        DataType address,
        List<FhirUrl> additionalInfo,
        FhirPositiveInt maxParticipants,
        FhirString sessionKey) implements DataType {

    /**
     * Creates a {@code VirtualServiceDetail}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public VirtualServiceDetail {
        extension = extension == null ? List.of() : List.copyOf(extension);
        additionalInfo = additionalInfo == null ? List.of() : List.copyOf(additionalInfo);
        if (address != null && !(address instanceof FhirUrl
                || address instanceof FhirString
                || address instanceof ContactPoint
                || address instanceof ExtendedContactDetail)) {
            throw new IllegalArgumentException(
                    "VirtualServiceDetail.address[x] does not allow "
                            + address.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code VirtualServiceDetail}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link VirtualServiceDetail}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private Coding channelType;
        private DataType address;
        private List<FhirUrl> additionalInfo = new ArrayList<>();
        private FhirPositiveInt maxParticipants;
        private FhirString sessionKey;

        private Builder() {
        }

        private Builder(VirtualServiceDetail original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.channelType = original.channelType();
            this.address = original.address();
            this.additionalInfo = new ArrayList<>(original.additionalInfo());
            this.maxParticipants = original.maxParticipants();
            this.sessionKey = original.sessionKey();
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
         * Sets {@code channelType}.
         *
         * @param channelType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder channelType(Coding channelType) {
            this.channelType = channelType;
            return this;
        }

        /**
         * Sets {@code address} to a url.
         *
         * @param address the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder address(FhirUrl address) {
            this.address = address;
            return this;
        }

        /**
         * Sets {@code address} to a string.
         *
         * @param address the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder address(FhirString address) {
            this.address = address;
            return this;
        }

        /**
         * Sets {@code address} to a ContactPoint.
         *
         * @param address the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder address(ContactPoint address) {
            this.address = address;
            return this;
        }

        /**
         * Sets {@code address} to a ExtendedContactDetail.
         *
         * @param address the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder address(ExtendedContactDetail address) {
            this.address = address;
            return this;
        }

        /**
         * Replaces all {@code additionalInfo} values.
         *
         * @param additionalInfo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder additionalInfo(List<FhirUrl> additionalInfo) {
            this.additionalInfo = additionalInfo == null ? new ArrayList<>() : new ArrayList<>(additionalInfo);
            return this;
        }

        /**
         * Adds a {@code additionalInfo} value.
         *
         * @param additionalInfo the value to add
         * @return this builder
         */
        public Builder addAdditionalInfo(FhirUrl additionalInfo) {
            this.additionalInfo.add(Objects.requireNonNull(additionalInfo, "additionalInfo"));
            return this;
        }

        /**
         * Adds a {@code additionalInfo} value, wrapped in a {@link FhirUrl} without id or extensions.
         *
         * @param additionalInfo the value to add
         * @return this builder
         */
        public Builder addAdditionalInfo(String additionalInfo) {
            return addAdditionalInfo(FhirUrl.of(additionalInfo));
        }

        /**
         * Sets {@code maxParticipants}.
         *
         * @param maxParticipants the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxParticipants(FhirPositiveInt maxParticipants) {
            this.maxParticipants = maxParticipants;
            return this;
        }

        /**
         * Sets {@code maxParticipants}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param maxParticipants the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxParticipants(Integer maxParticipants) {
            return maxParticipants(maxParticipants == null ? null : FhirPositiveInt.of(maxParticipants));
        }

        /**
         * Sets {@code sessionKey}.
         *
         * @param sessionKey the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sessionKey(FhirString sessionKey) {
            this.sessionKey = sessionKey;
            return this;
        }

        /**
         * Sets {@code sessionKey}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param sessionKey the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sessionKey(String sessionKey) {
            return sessionKey(sessionKey == null ? null : FhirString.of(sessionKey));
        }

        /**
         * Builds the {@code VirtualServiceDetail}.
         *
         * @return the {@code VirtualServiceDetail}
         */
        public VirtualServiceDetail build() {
            return new VirtualServiceDetail(
                    id, extension, channelType, address, additionalInfo, maxParticipants, sessionKey);
        }
    }
}
