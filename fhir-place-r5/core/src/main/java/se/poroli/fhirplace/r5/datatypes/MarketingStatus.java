package se.poroli.fhirplace.r5.datatypes;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The marketing status describes the date when a medicinal product is actually put on the market or the date as of
 * which it is no longer available.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
 * @param country The country in which the marketing authorization has been granted shall be specified It should be
 *   specified using the ISO 3166 ‑ 1 alpha-2 code elements.
 * @param jurisdiction Where a Medicines Regulatory Agency has granted a marketing authorization for which specific
 *   provisions within a jurisdiction apply, the jurisdiction can be specified using an appropriate controlled
 *   terminology The controlled term and the controlled term identifier shall be specified.
 * @param status This attribute provides information on the status of the marketing of the medicinal product See
 *   ISO/TS 20443 for more information and examples. Required.
 * @param dateRange The date when the Medicinal Product is placed on the market by the Marketing Authorization Holder
 *   (or where applicable, the manufacturer/distributor) in a country and/or jurisdiction shall be provided A complete
 *   date consisting of day, month and year shall be specified using the ISO 8601 date format NOTE “Placed on the
 *   market” refers to the release of the Medicinal Product into the distribution chain.
 * @param restoreDate The date when the Medicinal Product is placed on the market by the Marketing Authorization
 *   Holder (or where applicable, the manufacturer/distributor) in a country and/or jurisdiction shall be provided A
 *   complete date consisting of day, month and year shall be specified using the ISO 8601 date format NOTE “Placed on
 *   the market” refers to the release of the Medicinal Product into the distribution chain.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MarketingStatus">FHIR R5 MarketingStatus</a>
 */
public record MarketingStatus(
        String id,
        List<Extension> extension,
        List<Extension> modifierExtension,
        CodeableConcept country,
        CodeableConcept jurisdiction,
        CodeableConcept status,
        Period dateRange,
        FhirDateTime restoreDate) implements BackboneType {

    /**
     * Creates a {@code MarketingStatus}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public MarketingStatus {
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        Objects.requireNonNull(status, "MarketingStatus.status is required");
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
     * Returns a builder initialized with the values of this {@code MarketingStatus}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link MarketingStatus}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private CodeableConcept country;
        private CodeableConcept jurisdiction;
        private CodeableConcept status;
        private Period dateRange;
        private FhirDateTime restoreDate;

        private Builder() {
        }

        private Builder(MarketingStatus original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.country = original.country();
            this.jurisdiction = original.jurisdiction();
            this.status = original.status();
            this.dateRange = original.dateRange();
            this.restoreDate = original.restoreDate();
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
         * Replaces all {@code modifierExtension} values.
         *
         * @param modifierExtension the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder modifierExtension(List<Extension> modifierExtension) {
            this.modifierExtension = modifierExtension == null
                    ? new ArrayList<>()
                    : new ArrayList<>(modifierExtension);
            return this;
        }

        /**
         * Adds a {@code modifierExtension} value.
         *
         * @param modifierExtension the value to add
         * @return this builder
         */
        public Builder addModifierExtension(Extension modifierExtension) {
            this.modifierExtension.add(Objects.requireNonNull(modifierExtension, "modifierExtension"));
            return this;
        }

        /**
         * Sets {@code country}.
         *
         * @param country the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder country(CodeableConcept country) {
            this.country = country;
            return this;
        }

        /**
         * Sets {@code jurisdiction}.
         *
         * @param jurisdiction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder jurisdiction(CodeableConcept jurisdiction) {
            this.jurisdiction = jurisdiction;
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(CodeableConcept status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code dateRange}.
         *
         * @param dateRange the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dateRange(Period dateRange) {
            this.dateRange = dateRange;
            return this;
        }

        /**
         * Sets {@code restoreDate}.
         *
         * @param restoreDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder restoreDate(FhirDateTime restoreDate) {
            this.restoreDate = restoreDate;
            return this;
        }

        /**
         * Sets {@code restoreDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param restoreDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder restoreDate(Temporal restoreDate) {
            return restoreDate(restoreDate == null ? null : FhirDateTime.of(restoreDate));
        }

        /**
         * Builds the {@code MarketingStatus}.
         *
         * @return the {@code MarketingStatus}
         * @throws NullPointerException if a required element is absent
         */
        public MarketingStatus build() {
            return new MarketingStatus(
                    id, extension, modifierExtension, country, jurisdiction, status, dateRange, restoreDate);
        }
    }
}
