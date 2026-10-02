package se.poroli.fhirplace.r5.foundation.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.valuesets.IssueSeverity;
import se.poroli.fhirplace.r5.valuesets.IssueType;

/**
 * A collection of error, warning, or information messages that result from a system action.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Logical id of this artifact.
 * @param meta Metadata about the resource.
 * @param implicitRules A set of rules under which this content was created. Modifier element.
 * @param language Language of the resource content.
 * @param text Text summary of the resource, for human interpretation.
 * @param contained Contained, inline Resources.
 * @param extension Additional content defined by implementations.
 * @param modifierExtension Extensions that cannot be ignored. Modifier element.
 * @param issue A single issue associated with the action. Required.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/OperationOutcome">FHIR R5 OperationOutcome</a>
 */
public record OperationOutcome(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Issue> issue) implements DomainResource {

    /**
     * Creates an {@code OperationOutcome}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     * @throws IllegalArgumentException if a required list is empty
     */
    public OperationOutcome {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        issue = issue == null ? List.of() : List.copyOf(issue);
        if (issue.isEmpty()) {
            throw new IllegalArgumentException("OperationOutcome.issue requires at least one value");
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
     * Returns a builder initialized with the values of this {@code OperationOutcome}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * An error, warning, or information message that results from a system action.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param severity fatal | error | warning | information | success. Required.
     * @param code Error or warning code. Required.
     * @param details Additional details about the error.
     * @param diagnostics Additional diagnostic information about the issue.
     * @param location Deprecated: Path of element(s) related to issue.
     * @param expression FHIRPath of element(s) related to issue.
     */
    public record Issue(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<IssueSeverity> severity,
            FhirEnum<IssueType> code,
            CodeableConcept details,
            FhirString diagnostics,
            List<FhirString> location,
            List<FhirString> expression) implements BackboneElement {

        /**
         * Creates an {@code Issue}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Issue {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            location = location == null ? List.of() : List.copyOf(location);
            expression = expression == null ? List.of() : List.copyOf(expression);
            Objects.requireNonNull(severity, "OperationOutcome.issue.severity is required");
            Objects.requireNonNull(code, "OperationOutcome.issue.code is required");
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
         * Returns a builder initialized with the values of this {@code Issue}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Issue}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<IssueSeverity> severity;
            private FhirEnum<IssueType> code;
            private CodeableConcept details;
            private FhirString diagnostics;
            private List<FhirString> location = new ArrayList<>();
            private List<FhirString> expression = new ArrayList<>();

            private Builder() {
            }

            private Builder(Issue original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.severity = original.severity();
                this.code = original.code();
                this.details = original.details();
                this.diagnostics = original.diagnostics();
                this.location = new ArrayList<>(original.location());
                this.expression = new ArrayList<>(original.expression());
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
             * Sets {@code severity}.
             *
             * @param severity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder severity(FhirEnum<IssueSeverity> severity) {
                this.severity = severity;
                return this;
            }

            /**
             * Sets {@code severity}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param severity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder severity(IssueSeverity severity) {
                return severity(severity == null ? null : FhirEnum.of(severity));
            }

            /**
             * Sets {@code code}.
             *
             * @param code the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder code(FhirEnum<IssueType> code) {
                this.code = code;
                return this;
            }

            /**
             * Sets {@code code}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param code the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder code(IssueType code) {
                return code(code == null ? null : FhirEnum.of(code));
            }

            /**
             * Sets {@code details}.
             *
             * @param details the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder details(CodeableConcept details) {
                this.details = details;
                return this;
            }

            /**
             * Sets {@code diagnostics}.
             *
             * @param diagnostics the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder diagnostics(FhirString diagnostics) {
                this.diagnostics = diagnostics;
                return this;
            }

            /**
             * Sets {@code diagnostics}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param diagnostics the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder diagnostics(String diagnostics) {
                return diagnostics(diagnostics == null ? null : FhirString.of(diagnostics));
            }

            /**
             * Replaces all {@code location} values.
             *
             * @param location the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder location(List<FhirString> location) {
                this.location = location == null ? new ArrayList<>() : new ArrayList<>(location);
                return this;
            }

            /**
             * Adds a {@code location} value.
             *
             * @param location the value to add
             * @return this builder
             */
            public Builder addLocation(FhirString location) {
                this.location.add(Objects.requireNonNull(location, "location"));
                return this;
            }

            /**
             * Adds a {@code location} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param location the value to add
             * @return this builder
             */
            public Builder addLocation(String location) {
                return addLocation(FhirString.of(location));
            }

            /**
             * Replaces all {@code expression} values.
             *
             * @param expression the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder expression(List<FhirString> expression) {
                this.expression = expression == null ? new ArrayList<>() : new ArrayList<>(expression);
                return this;
            }

            /**
             * Adds a {@code expression} value.
             *
             * @param expression the value to add
             * @return this builder
             */
            public Builder addExpression(FhirString expression) {
                this.expression.add(Objects.requireNonNull(expression, "expression"));
                return this;
            }

            /**
             * Adds a {@code expression} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param expression the value to add
             * @return this builder
             */
            public Builder addExpression(String expression) {
                return addExpression(FhirString.of(expression));
            }

            /**
             * Builds the {@code Issue}.
             *
             * @return the {@code Issue}
             * @throws NullPointerException if a required element is absent
             */
            public Issue build() {
                return new Issue(
                        id, extension, modifierExtension, severity, code, details, diagnostics, location, expression);
            }
        }
    }

    /** Builder for {@link OperationOutcome}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private List<Issue> issue = new ArrayList<>();

        private Builder() {
        }

        private Builder(OperationOutcome original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.issue = new ArrayList<>(original.issue());
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
         * Sets {@code text}.
         *
         * @param text the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder text(Narrative text) {
            this.text = text;
            return this;
        }

        /**
         * Replaces all {@code contained} values.
         *
         * @param contained the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contained(List<Resource> contained) {
            this.contained = contained == null ? new ArrayList<>() : new ArrayList<>(contained);
            return this;
        }

        /**
         * Adds a {@code contained} value.
         *
         * @param contained the value to add
         * @return this builder
         */
        public Builder addContained(Resource contained) {
            this.contained.add(Objects.requireNonNull(contained, "contained"));
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
         * Replaces all {@code issue} values.
         *
         * @param issue the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder issue(List<Issue> issue) {
            this.issue = issue == null ? new ArrayList<>() : new ArrayList<>(issue);
            return this;
        }

        /**
         * Adds a {@code issue} value.
         *
         * @param issue the value to add
         * @return this builder
         */
        public Builder addIssue(Issue issue) {
            this.issue.add(Objects.requireNonNull(issue, "issue"));
            return this;
        }

        /**
         * Builds the {@code OperationOutcome}.
         *
         * @return the {@code OperationOutcome}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public OperationOutcome build() {
            return new OperationOutcome(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, issue);
        }
    }
}
