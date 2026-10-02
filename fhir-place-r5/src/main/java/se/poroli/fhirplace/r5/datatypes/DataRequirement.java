package se.poroli.fhirplace.r5.datatypes;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.FHIRTypes;
import se.poroli.fhirplace.r5.valuesets.SortDirection;
import se.poroli.fhirplace.r5.valuesets.ValueFilterComparator;

/**
 * Describes a required data item for evaluation in terms of the type of data, and optional code or date-based filters
 * of the data.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param type The type of the required data. Required.
 * @param profile The profile of the required data. Canonical reference to StructureDefinition.
 * @param subject E.g. Patient, Practitioner, RelatedPerson, Organization, Location, Device. One of CodeableConcept,
 *   Reference.
 * @param mustSupport Indicates specific structure elements that are referenced by the knowledge module.
 * @param codeFilter What codes are expected.
 * @param dateFilter What dates/date ranges are expected.
 * @param valueFilter What values are expected.
 * @param limit Number of results.
 * @param sort Order of the results.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DataRequirement">FHIR R5 DataRequirement</a>
 */
public record DataRequirement(
        String id,
        List<Extension> extension,
        FhirEnum<FHIRTypes> type,
        List<FhirCanonical> profile,
        DataType subject,
        List<FhirString> mustSupport,
        List<CodeFilter> codeFilter,
        List<DateFilter> dateFilter,
        List<ValueFilter> valueFilter,
        FhirPositiveInt limit,
        List<Sort> sort) implements DataType {

    /**
     * Creates a {@code DataRequirement}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public DataRequirement {
        extension = extension == null ? List.of() : List.copyOf(extension);
        profile = profile == null ? List.of() : List.copyOf(profile);
        mustSupport = mustSupport == null ? List.of() : List.copyOf(mustSupport);
        codeFilter = codeFilter == null ? List.of() : List.copyOf(codeFilter);
        dateFilter = dateFilter == null ? List.of() : List.copyOf(dateFilter);
        valueFilter = valueFilter == null ? List.of() : List.copyOf(valueFilter);
        sort = sort == null ? List.of() : List.copyOf(sort);
        Objects.requireNonNull(type, "DataRequirement.type is required");
        if (subject != null && !(subject instanceof CodeableConcept || subject instanceof Reference)) {
            throw new IllegalArgumentException(
                    "DataRequirement.subject[x] must be one of CodeableConcept, Reference, but was "
                            + subject.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code DataRequirement}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Code filters specify additional constraints on the data, specifying the value set of interest for a particular
     * element of the data.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param path A code-valued attribute to filter on.
     * @param searchParam A coded (token) parameter to search on.
     * @param valueSet ValueSet for the filter. Canonical reference to ValueSet.
     * @param code What code is expected.
     */
    public record CodeFilter(
            String id,
            List<Extension> extension,
            FhirString path,
            FhirString searchParam,
            FhirCanonical valueSet,
            List<Coding> code) implements Element {

        /**
         * Creates a {@code CodeFilter}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public CodeFilter {
            extension = extension == null ? List.of() : List.copyOf(extension);
            code = code == null ? List.of() : List.copyOf(code);
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
         * Returns a builder initialized with the values of this {@code CodeFilter}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link CodeFilter}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private FhirString path;
            private FhirString searchParam;
            private FhirCanonical valueSet;
            private List<Coding> code = new ArrayList<>();

            private Builder() {
            }

            private Builder(CodeFilter original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.path = original.path();
                this.searchParam = original.searchParam();
                this.valueSet = original.valueSet();
                this.code = new ArrayList<>(original.code());
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
             * Sets {@code path}.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(FhirString path) {
                this.path = path;
                return this;
            }

            /**
             * Sets {@code path}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(String path) {
                return path(path == null ? null : FhirString.of(path));
            }

            /**
             * Sets {@code searchParam}.
             *
             * @param searchParam the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder searchParam(FhirString searchParam) {
                this.searchParam = searchParam;
                return this;
            }

            /**
             * Sets {@code searchParam}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param searchParam the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder searchParam(String searchParam) {
                return searchParam(searchParam == null ? null : FhirString.of(searchParam));
            }

            /**
             * Sets {@code valueSet}.
             *
             * @param valueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder valueSet(FhirCanonical valueSet) {
                this.valueSet = valueSet;
                return this;
            }

            /**
             * Sets {@code valueSet}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param valueSet the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder valueSet(String valueSet) {
                return valueSet(valueSet == null ? null : FhirCanonical.of(valueSet));
            }

            /**
             * Replaces all {@code code} values.
             *
             * @param code the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder code(List<Coding> code) {
                this.code = code == null ? new ArrayList<>() : new ArrayList<>(code);
                return this;
            }

            /**
             * Adds a {@code code} value.
             *
             * @param code the value to add
             * @return this builder
             */
            public Builder addCode(Coding code) {
                this.code.add(Objects.requireNonNull(code, "code"));
                return this;
            }

            /**
             * Builds the {@code CodeFilter}.
             *
             * @return the {@code CodeFilter}
             */
            public CodeFilter build() {
                return new CodeFilter(
                        id, extension, path, searchParam, valueSet, code);
            }
        }
    }

    /**
     * Date filters specify additional constraints on the data in terms of the applicable date range for specific
     * elements.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param path A date-valued attribute to filter on.
     * @param searchParam A date valued parameter to search on.
     * @param value The value of the filter, as a Period, DateTime, or Duration value. One of dateTime, Period,
     *   Duration.
     */
    public record DateFilter(
            String id,
            List<Extension> extension,
            FhirString path,
            FhirString searchParam,
            DataType value) implements Element {

        /**
         * Creates a {@code DateFilter}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public DateFilter {
            extension = extension == null ? List.of() : List.copyOf(extension);
            if (value != null && !(value instanceof FhirDateTime
                    || value instanceof Period
                    || value instanceof Duration)) {
                throw new IllegalArgumentException(
                        "DataRequirement.dateFilter.value[x] must be one of dateTime, Period, Duration, but was "
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
         * Returns a builder initialized with the values of this {@code DateFilter}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link DateFilter}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private FhirString path;
            private FhirString searchParam;
            private DataType value;

            private Builder() {
            }

            private Builder(DateFilter original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.path = original.path();
                this.searchParam = original.searchParam();
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
             * Sets {@code path}.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(FhirString path) {
                this.path = path;
                return this;
            }

            /**
             * Sets {@code path}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(String path) {
                return path(path == null ? null : FhirString.of(path));
            }

            /**
             * Sets {@code searchParam}.
             *
             * @param searchParam the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder searchParam(FhirString searchParam) {
                this.searchParam = searchParam;
                return this;
            }

            /**
             * Sets {@code searchParam}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param searchParam the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder searchParam(String searchParam) {
                return searchParam(searchParam == null ? null : FhirString.of(searchParam));
            }

            /**
             * Sets {@code value} to a dateTime.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirDateTime value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a Period.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Period value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a Duration.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Duration value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a dateTime without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Temporal value) {
                this.value = value == null ? null : FhirDateTime.of(value);
                return this;
            }

            /**
             * Builds the {@code DateFilter}.
             *
             * @return the {@code DateFilter}
             */
            public DateFilter build() {
                return new DateFilter(
                        id, extension, path, searchParam, value);
            }
        }
    }

    /**
     * Value filters specify additional constraints on the data for elements other than code-valued or date-valued.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param path An attribute to filter on.
     * @param searchParam A parameter to search on.
     * @param comparator eq | gt | lt | ge | le | sa | eb.
     * @param value The value of the filter, as a Period, DateTime, or Duration value. One of dateTime, Period,
     *   Duration.
     */
    public record ValueFilter(
            String id,
            List<Extension> extension,
            FhirString path,
            FhirString searchParam,
            FhirEnum<ValueFilterComparator> comparator,
            DataType value) implements Element {

        /**
         * Creates a {@code ValueFilter}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public ValueFilter {
            extension = extension == null ? List.of() : List.copyOf(extension);
            if (value != null && !(value instanceof FhirDateTime
                    || value instanceof Period
                    || value instanceof Duration)) {
                throw new IllegalArgumentException(
                        "DataRequirement.valueFilter.value[x] must be one of dateTime, Period, Duration, but was "
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
         * Returns a builder initialized with the values of this {@code ValueFilter}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ValueFilter}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private FhirString path;
            private FhirString searchParam;
            private FhirEnum<ValueFilterComparator> comparator;
            private DataType value;

            private Builder() {
            }

            private Builder(ValueFilter original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.path = original.path();
                this.searchParam = original.searchParam();
                this.comparator = original.comparator();
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
             * Sets {@code path}.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(FhirString path) {
                this.path = path;
                return this;
            }

            /**
             * Sets {@code path}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(String path) {
                return path(path == null ? null : FhirString.of(path));
            }

            /**
             * Sets {@code searchParam}.
             *
             * @param searchParam the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder searchParam(FhirString searchParam) {
                this.searchParam = searchParam;
                return this;
            }

            /**
             * Sets {@code searchParam}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param searchParam the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder searchParam(String searchParam) {
                return searchParam(searchParam == null ? null : FhirString.of(searchParam));
            }

            /**
             * Sets {@code comparator}.
             *
             * @param comparator the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder comparator(FhirEnum<ValueFilterComparator> comparator) {
                this.comparator = comparator;
                return this;
            }

            /**
             * Sets {@code comparator}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param comparator the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder comparator(ValueFilterComparator comparator) {
                return comparator(comparator == null ? null : FhirEnum.of(comparator));
            }

            /**
             * Sets {@code value} to a dateTime.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirDateTime value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a Period.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Period value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a Duration.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Duration value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a dateTime without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Temporal value) {
                this.value = value == null ? null : FhirDateTime.of(value);
                return this;
            }

            /**
             * Builds the {@code ValueFilter}.
             *
             * @return the {@code ValueFilter}
             */
            public ValueFilter build() {
                return new ValueFilter(
                        id, extension, path, searchParam, comparator, value);
            }
        }
    }

    /**
     * Specifies the order of the results to be returned.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param path The name of the attribute to perform the sort. Required.
     * @param direction ascending | descending. Required.
     */
    public record Sort(
            String id,
            List<Extension> extension,
            FhirString path,
            FhirEnum<SortDirection> direction) implements Element {

        /**
         * Creates a {@code Sort}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Sort {
            extension = extension == null ? List.of() : List.copyOf(extension);
            Objects.requireNonNull(path, "DataRequirement.sort.path is required");
            Objects.requireNonNull(direction, "DataRequirement.sort.direction is required");
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
         * Returns a builder initialized with the values of this {@code Sort}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Sort}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private FhirString path;
            private FhirEnum<SortDirection> direction;

            private Builder() {
            }

            private Builder(Sort original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.path = original.path();
                this.direction = original.direction();
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
             * Sets {@code path}.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(FhirString path) {
                this.path = path;
                return this;
            }

            /**
             * Sets {@code path}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(String path) {
                return path(path == null ? null : FhirString.of(path));
            }

            /**
             * Sets {@code direction}.
             *
             * @param direction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder direction(FhirEnum<SortDirection> direction) {
                this.direction = direction;
                return this;
            }

            /**
             * Sets {@code direction}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param direction the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder direction(SortDirection direction) {
                return direction(direction == null ? null : FhirEnum.of(direction));
            }

            /**
             * Builds the {@code Sort}.
             *
             * @return the {@code Sort}
             * @throws NullPointerException if a required element is absent
             */
            public Sort build() {
                return new Sort(
                        id, extension, path, direction);
            }
        }
    }

    /** Builder for {@link DataRequirement}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirEnum<FHIRTypes> type;
        private List<FhirCanonical> profile = new ArrayList<>();
        private DataType subject;
        private List<FhirString> mustSupport = new ArrayList<>();
        private List<CodeFilter> codeFilter = new ArrayList<>();
        private List<DateFilter> dateFilter = new ArrayList<>();
        private List<ValueFilter> valueFilter = new ArrayList<>();
        private FhirPositiveInt limit;
        private List<Sort> sort = new ArrayList<>();

        private Builder() {
        }

        private Builder(DataRequirement original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.type = original.type();
            this.profile = new ArrayList<>(original.profile());
            this.subject = original.subject();
            this.mustSupport = new ArrayList<>(original.mustSupport());
            this.codeFilter = new ArrayList<>(original.codeFilter());
            this.dateFilter = new ArrayList<>(original.dateFilter());
            this.valueFilter = new ArrayList<>(original.valueFilter());
            this.limit = original.limit();
            this.sort = new ArrayList<>(original.sort());
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
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<FHIRTypes> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FHIRTypes type) {
            return type(type == null ? null : FhirEnum.of(type));
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
         * Sets {@code subject} to a CodeableConcept.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(CodeableConcept subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets {@code subject} to a Reference.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(Reference subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Replaces all {@code mustSupport} values.
         *
         * @param mustSupport the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder mustSupport(List<FhirString> mustSupport) {
            this.mustSupport = mustSupport == null ? new ArrayList<>() : new ArrayList<>(mustSupport);
            return this;
        }

        /**
         * Adds a {@code mustSupport} value.
         *
         * @param mustSupport the value to add
         * @return this builder
         */
        public Builder addMustSupport(FhirString mustSupport) {
            this.mustSupport.add(Objects.requireNonNull(mustSupport, "mustSupport"));
            return this;
        }

        /**
         * Adds a {@code mustSupport} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param mustSupport the value to add
         * @return this builder
         */
        public Builder addMustSupport(String mustSupport) {
            return addMustSupport(FhirString.of(mustSupport));
        }

        /**
         * Replaces all {@code codeFilter} values.
         *
         * @param codeFilter the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder codeFilter(List<CodeFilter> codeFilter) {
            this.codeFilter = codeFilter == null ? new ArrayList<>() : new ArrayList<>(codeFilter);
            return this;
        }

        /**
         * Adds a {@code codeFilter} value.
         *
         * @param codeFilter the value to add
         * @return this builder
         */
        public Builder addCodeFilter(CodeFilter codeFilter) {
            this.codeFilter.add(Objects.requireNonNull(codeFilter, "codeFilter"));
            return this;
        }

        /**
         * Replaces all {@code dateFilter} values.
         *
         * @param dateFilter the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder dateFilter(List<DateFilter> dateFilter) {
            this.dateFilter = dateFilter == null ? new ArrayList<>() : new ArrayList<>(dateFilter);
            return this;
        }

        /**
         * Adds a {@code dateFilter} value.
         *
         * @param dateFilter the value to add
         * @return this builder
         */
        public Builder addDateFilter(DateFilter dateFilter) {
            this.dateFilter.add(Objects.requireNonNull(dateFilter, "dateFilter"));
            return this;
        }

        /**
         * Replaces all {@code valueFilter} values.
         *
         * @param valueFilter the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder valueFilter(List<ValueFilter> valueFilter) {
            this.valueFilter = valueFilter == null ? new ArrayList<>() : new ArrayList<>(valueFilter);
            return this;
        }

        /**
         * Adds a {@code valueFilter} value.
         *
         * @param valueFilter the value to add
         * @return this builder
         */
        public Builder addValueFilter(ValueFilter valueFilter) {
            this.valueFilter.add(Objects.requireNonNull(valueFilter, "valueFilter"));
            return this;
        }

        /**
         * Sets {@code limit}.
         *
         * @param limit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder limit(FhirPositiveInt limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Sets {@code limit}, wrapped in a {@link FhirPositiveInt} without id or extensions.
         *
         * @param limit the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder limit(Integer limit) {
            return limit(limit == null ? null : FhirPositiveInt.of(limit));
        }

        /**
         * Replaces all {@code sort} values.
         *
         * @param sort the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder sort(List<Sort> sort) {
            this.sort = sort == null ? new ArrayList<>() : new ArrayList<>(sort);
            return this;
        }

        /**
         * Adds a {@code sort} value.
         *
         * @param sort the value to add
         * @return this builder
         */
        public Builder addSort(Sort sort) {
            this.sort.add(Objects.requireNonNull(sort, "sort"));
            return this;
        }

        /**
         * Builds the {@code DataRequirement}.
         *
         * @return the {@code DataRequirement}
         * @throws NullPointerException if a required element is absent
         */
        public DataRequirement build() {
            return new DataRequirement(
                    id, extension, type, profile, subject, mustSupport, codeFilter, dateFilter, valueFilter, limit,
                    sort);
        }
    }
}
