package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.AddressType;
import se.poroli.fhirplace.r5.valuesets.AddressUse;

/**
 * An address expressed using postal conventions (as opposed to GPS or other location definition formats).
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param use home | work | temp | old | billing - purpose of this address. Modifier element.
 * @param type postal | physical | both.
 * @param text Text representation of the address.
 * @param line Street name, number, direction &amp; P.O. Box etc.
 * @param city Name of city, town etc.
 * @param district District name (aka county).
 * @param state Sub-unit of country (abbreviations ok).
 * @param postalCode Postal code for area.
 * @param country Country (e.g. may be ISO 3166 2 or 3 letter code).
 * @param period Time period when address was/is in use.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Address">FHIR R5 Address</a>
 */
public record Address(
        String id,
        List<Extension> extension,
        FhirEnum<AddressUse> use,
        FhirEnum<AddressType> type,
        FhirString text,
        List<FhirString> line,
        FhirString city,
        FhirString district,
        FhirString state,
        FhirString postalCode,
        FhirString country,
        Period period) implements DataType {

    /**
     * Creates an {@code Address}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Address {
        extension = extension == null ? List.of() : List.copyOf(extension);
        line = line == null ? List.of() : List.copyOf(line);
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
     * Returns a builder initialized with the values of this {@code Address}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Address}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirEnum<AddressUse> use;
        private FhirEnum<AddressType> type;
        private FhirString text;
        private List<FhirString> line = new ArrayList<>();
        private FhirString city;
        private FhirString district;
        private FhirString state;
        private FhirString postalCode;
        private FhirString country;
        private Period period;

        private Builder() {
        }

        private Builder(Address original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.use = original.use();
            this.type = original.type();
            this.text = original.text();
            this.line = new ArrayList<>(original.line());
            this.city = original.city();
            this.district = original.district();
            this.state = original.state();
            this.postalCode = original.postalCode();
            this.country = original.country();
            this.period = original.period();
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
         * Sets {@code use}.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(FhirEnum<AddressUse> use) {
            this.use = use;
            return this;
        }

        /**
         * Sets {@code use}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(AddressUse use) {
            return use(use == null ? null : FhirEnum.of(use));
        }

        /**
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<AddressType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(AddressType type) {
            return type(type == null ? null : FhirEnum.of(type));
        }

        /**
         * Sets {@code text}.
         *
         * @param text the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder text(FhirString text) {
            this.text = text;
            return this;
        }

        /**
         * Sets {@code text}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param text the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder text(String text) {
            return text(text == null ? null : FhirString.of(text));
        }

        /**
         * Replaces all {@code line} values.
         *
         * @param line the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder line(List<FhirString> line) {
            this.line = line == null ? new ArrayList<>() : new ArrayList<>(line);
            return this;
        }

        /**
         * Adds a {@code line} value.
         *
         * @param line the value to add
         * @return this builder
         */
        public Builder addLine(FhirString line) {
            this.line.add(Objects.requireNonNull(line, "line"));
            return this;
        }

        /**
         * Adds a {@code line} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param line the value to add
         * @return this builder
         */
        public Builder addLine(String line) {
            return addLine(FhirString.of(line));
        }

        /**
         * Sets {@code city}.
         *
         * @param city the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder city(FhirString city) {
            this.city = city;
            return this;
        }

        /**
         * Sets {@code city}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param city the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder city(String city) {
            return city(city == null ? null : FhirString.of(city));
        }

        /**
         * Sets {@code district}.
         *
         * @param district the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder district(FhirString district) {
            this.district = district;
            return this;
        }

        /**
         * Sets {@code district}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param district the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder district(String district) {
            return district(district == null ? null : FhirString.of(district));
        }

        /**
         * Sets {@code state}.
         *
         * @param state the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder state(FhirString state) {
            this.state = state;
            return this;
        }

        /**
         * Sets {@code state}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param state the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder state(String state) {
            return state(state == null ? null : FhirString.of(state));
        }

        /**
         * Sets {@code postalCode}.
         *
         * @param postalCode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder postalCode(FhirString postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        /**
         * Sets {@code postalCode}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param postalCode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder postalCode(String postalCode) {
            return postalCode(postalCode == null ? null : FhirString.of(postalCode));
        }

        /**
         * Sets {@code country}.
         *
         * @param country the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder country(FhirString country) {
            this.country = country;
            return this;
        }

        /**
         * Sets {@code country}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param country the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder country(String country) {
            return country(country == null ? null : FhirString.of(country));
        }

        /**
         * Sets {@code period}.
         *
         * @param period the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder period(Period period) {
            this.period = period;
            return this;
        }

        /**
         * Builds the {@code Address}.
         *
         * @return the {@code Address}
         */
        public Address build() {
            return new Address(
                    id, extension, use, type, text, line, city, district, state, postalCode, country, period);
        }
    }
}
