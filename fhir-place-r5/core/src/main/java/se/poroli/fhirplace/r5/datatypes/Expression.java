package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A expression that is evaluated in a specified context and returns a value.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param description Natural language description of the condition.
 * @param name Short name assigned to expression for reuse.
 * @param language text/cql | text/fhirpath | application/x-fhir-query | etc.
 * @param expression Expression in specified language.
 * @param reference Where the expression is found.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Expression">FHIR R5 Expression</a>
 */
public record Expression(
        String id,
        List<Extension> extension,
        FhirString description,
        FhirCode name,
        FhirCode language,
        FhirString expression,
        FhirUri reference) implements DataType {

    /**
     * Creates an {@code Expression}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Expression {
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
     * Returns a builder initialized with the values of this {@code Expression}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link Expression}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirString description;
        private FhirCode name;
        private FhirCode language;
        private FhirString expression;
        private FhirUri reference;

        private Builder() {
        }

        private Builder(Expression original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.description = original.description();
            this.name = original.name();
            this.language = original.language();
            this.expression = original.expression();
            this.reference = original.reference();
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
         * Sets {@code description}.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(FhirString description) {
            this.description = description;
            return this;
        }

        /**
         * Sets {@code description}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(String description) {
            return description(description == null ? null : FhirString.of(description));
        }

        /**
         * Sets {@code name}.
         *
         * @param name the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder name(FhirCode name) {
            this.name = name;
            return this;
        }

        /**
         * Sets {@code name}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param name the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder name(String name) {
            return name(name == null ? null : FhirCode.of(name));
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
         * Sets {@code expression}.
         *
         * @param expression the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expression(FhirString expression) {
            this.expression = expression;
            return this;
        }

        /**
         * Sets {@code expression}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param expression the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expression(String expression) {
            return expression(expression == null ? null : FhirString.of(expression));
        }

        /**
         * Sets {@code reference}.
         *
         * @param reference the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reference(FhirUri reference) {
            this.reference = reference;
            return this;
        }

        /**
         * Sets {@code reference}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param reference the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reference(String reference) {
            return reference(reference == null ? null : FhirUri.of(reference));
        }

        /**
         * Builds the {@code Expression}.
         *
         * @return the {@code Expression}
         */
        public Expression build() {
            return new Expression(
                    id, extension, description, name, language, expression, reference);
        }
    }
}
