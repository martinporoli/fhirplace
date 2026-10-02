package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.NameUse;

/**
 * A name, normally of a human, that can be used for other living entities (e.g. animals but not organizations) that
 * have been assigned names by a human and may need the use of name parts or the need for usage information.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param use usual | official | temp | nickname | anonymous | old | maiden. Modifier element.
 * @param text Text representation of the full name.
 * @param family Family name (often called 'Surname').
 * @param given Given names (not always 'first'). Includes middle names.
 * @param prefix Parts that come before the name.
 * @param suffix Parts that come after the name.
 * @param period Time period when name was/is in use.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/HumanName">FHIR R5 HumanName</a>
 */
public record HumanName(
        String id,
        List<Extension> extension,
        FhirEnum<NameUse> use,
        FhirString text,
        FhirString family,
        List<FhirString> given,
        List<FhirString> prefix,
        List<FhirString> suffix,
        Period period) implements DataType {

    /**
     * Creates a {@code HumanName}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public HumanName {
        extension = extension == null ? List.of() : List.copyOf(extension);
        given = given == null ? List.of() : List.copyOf(given);
        prefix = prefix == null ? List.of() : List.copyOf(prefix);
        suffix = suffix == null ? List.of() : List.copyOf(suffix);
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
     * Returns a builder initialized with the values of this {@code HumanName}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link HumanName}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirEnum<NameUse> use;
        private FhirString text;
        private FhirString family;
        private List<FhirString> given = new ArrayList<>();
        private List<FhirString> prefix = new ArrayList<>();
        private List<FhirString> suffix = new ArrayList<>();
        private Period period;

        private Builder() {
        }

        private Builder(HumanName original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.use = original.use();
            this.text = original.text();
            this.family = original.family();
            this.given = new ArrayList<>(original.given());
            this.prefix = new ArrayList<>(original.prefix());
            this.suffix = new ArrayList<>(original.suffix());
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
        public Builder use(FhirEnum<NameUse> use) {
            this.use = use;
            return this;
        }

        /**
         * Sets {@code use}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(NameUse use) {
            return use(use == null ? null : FhirEnum.of(use));
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
         * Sets {@code family}.
         *
         * @param family the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder family(FhirString family) {
            this.family = family;
            return this;
        }

        /**
         * Sets {@code family}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param family the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder family(String family) {
            return family(family == null ? null : FhirString.of(family));
        }

        /**
         * Replaces all {@code given} values.
         *
         * @param given the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder given(List<FhirString> given) {
            this.given = given == null ? new ArrayList<>() : new ArrayList<>(given);
            return this;
        }

        /**
         * Adds a {@code given} value.
         *
         * @param given the value to add
         * @return this builder
         */
        public Builder addGiven(FhirString given) {
            this.given.add(Objects.requireNonNull(given, "given"));
            return this;
        }

        /**
         * Adds a {@code given} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param given the value to add
         * @return this builder
         */
        public Builder addGiven(String given) {
            return addGiven(FhirString.of(given));
        }

        /**
         * Replaces all {@code prefix} values.
         *
         * @param prefix the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder prefix(List<FhirString> prefix) {
            this.prefix = prefix == null ? new ArrayList<>() : new ArrayList<>(prefix);
            return this;
        }

        /**
         * Adds a {@code prefix} value.
         *
         * @param prefix the value to add
         * @return this builder
         */
        public Builder addPrefix(FhirString prefix) {
            this.prefix.add(Objects.requireNonNull(prefix, "prefix"));
            return this;
        }

        /**
         * Adds a {@code prefix} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param prefix the value to add
         * @return this builder
         */
        public Builder addPrefix(String prefix) {
            return addPrefix(FhirString.of(prefix));
        }

        /**
         * Replaces all {@code suffix} values.
         *
         * @param suffix the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder suffix(List<FhirString> suffix) {
            this.suffix = suffix == null ? new ArrayList<>() : new ArrayList<>(suffix);
            return this;
        }

        /**
         * Adds a {@code suffix} value.
         *
         * @param suffix the value to add
         * @return this builder
         */
        public Builder addSuffix(FhirString suffix) {
            this.suffix.add(Objects.requireNonNull(suffix, "suffix"));
            return this;
        }

        /**
         * Adds a {@code suffix} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param suffix the value to add
         * @return this builder
         */
        public Builder addSuffix(String suffix) {
            return addSuffix(FhirString.of(suffix));
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
         * Builds the {@code HumanName}.
         *
         * @return the {@code HumanName}
         */
        public HumanName build() {
            return new HumanName(
                    id, extension, use, text, family, given, prefix, suffix, period);
        }
    }
}
