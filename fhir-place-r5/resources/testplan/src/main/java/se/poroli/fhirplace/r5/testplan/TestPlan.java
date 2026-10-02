package se.poroli.fhirplace.r5.testplan;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A plan for executing testing on an artifact or specifications.
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
 * @param url Canonical identifier for this test plan, represented as a URI (globally unique).
 * @param identifier Business identifier identifier for the test plan.
 * @param version Business version of the test plan.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this test plan (computer friendly).
 * @param title Name for this test plan (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the test plan.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction where the test plan applies (if applicable).
 * @param purpose Why this test plan is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param category The category of the Test Plan - can be acceptance, unit, performance.
 * @param scope What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an
 *   external reference.
 * @param testTools A description of test tools to be used in the test plan - narrative for now.
 * @param dependency The required criteria to execute the test plan - e.g. preconditions, previous tests.
 * @param exitCriteria The threshold or criteria for the test plan to be considered successfully executed - narrative.
 * @param testCase The test cases that constitute this plan.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/TestPlan">FHIR R5 TestPlan</a>
 */
public record TestPlan(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirUri url,
        List<Identifier> identifier,
        FhirString version,
        DataType versionAlgorithm,
        FhirString name,
        FhirString title,
        FhirEnum<PublicationStatus> status,
        FhirBoolean experimental,
        FhirDateTime date,
        FhirString publisher,
        List<ContactDetail> contact,
        FhirMarkdown description,
        List<UsageContext> useContext,
        List<CodeableConcept> jurisdiction,
        FhirMarkdown purpose,
        FhirMarkdown copyright,
        FhirString copyrightLabel,
        List<CodeableConcept> category,
        List<Reference> scope,
        FhirMarkdown testTools,
        List<Dependency> dependency,
        FhirMarkdown exitCriteria,
        List<TestCase> testCase) implements DomainResource {

    /**
     * Creates a {@code TestPlan}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public TestPlan {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        category = category == null ? List.of() : List.copyOf(category);
        scope = scope == null ? List.of() : List.copyOf(scope);
        dependency = dependency == null ? List.of() : List.copyOf(dependency);
        testCase = testCase == null ? List.of() : List.copyOf(testCase);
        Objects.requireNonNull(status, "TestPlan.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "TestPlan.versionAlgorithm[x] must be one of string, Coding, but was "
                            + versionAlgorithm.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code TestPlan}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The required criteria to execute the test plan - e.g. preconditions, previous tests...
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param description Description of the dependency criterium.
     * @param predecessor Link to predecessor test plans.
     */
    public record Dependency(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirMarkdown description,
            Reference predecessor) implements BackboneElement {

        /**
         * Creates a {@code Dependency}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Dependency {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
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
         * Returns a builder initialized with the values of this {@code Dependency}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Dependency}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirMarkdown description;
            private Reference predecessor;

            private Builder() {
            }

            private Builder(Dependency original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.description = original.description();
                this.predecessor = original.predecessor();
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
             * Sets {@code description}.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(FhirMarkdown description) {
                this.description = description;
                return this;
            }

            /**
             * Sets {@code description}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param description the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder description(String description) {
                return description(description == null ? null : FhirMarkdown.of(description));
            }

            /**
             * Sets {@code predecessor}.
             *
             * @param predecessor the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder predecessor(Reference predecessor) {
                this.predecessor = predecessor;
                return this;
            }

            /**
             * Builds the {@code Dependency}.
             *
             * @return the {@code Dependency}
             */
            public Dependency build() {
                return new Dependency(
                        id, extension, modifierExtension, description, predecessor);
            }
        }
    }

    /**
     * The individual test cases that are part of this plan, when they they are made explicit.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param sequence Sequence of test case in the test plan.
     * @param scope The scope or artifact covered by the case.
     * @param dependency Required criteria to execute the test case.
     * @param testRun The actual test to be executed.
     * @param testData The test data used in the test case.
     * @param assertion Test assertions or expectations.
     */
    public record TestCase(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirInteger sequence,
            List<Reference> scope,
            List<TestCaseDependency> dependency,
            List<TestRun> testRun,
            List<TestData> testData,
            List<Assertion> assertion) implements BackboneElement {

        /**
         * Creates a {@code TestCase}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public TestCase {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            scope = scope == null ? List.of() : List.copyOf(scope);
            dependency = dependency == null ? List.of() : List.copyOf(dependency);
            testRun = testRun == null ? List.of() : List.copyOf(testRun);
            testData = testData == null ? List.of() : List.copyOf(testData);
            assertion = assertion == null ? List.of() : List.copyOf(assertion);
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
         * Returns a builder initialized with the values of this {@code TestCase}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The required criteria to execute the test case - e.g. preconditions, previous tests.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param description Description of the criteria.
         * @param predecessor Link to predecessor test plans.
         */
        public record TestCaseDependency(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirMarkdown description,
                Reference predecessor) implements BackboneElement {

            /**
             * Creates a {@code TestCaseDependency}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public TestCaseDependency {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
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
             * Returns a builder initialized with the values of this {@code TestCaseDependency}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link TestCaseDependency}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirMarkdown description;
                private Reference predecessor;

                private Builder() {
                }

                private Builder(TestCaseDependency original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.description = original.description();
                    this.predecessor = original.predecessor();
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
                 * Sets {@code description}.
                 *
                 * @param description the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder description(FhirMarkdown description) {
                    this.description = description;
                    return this;
                }

                /**
                 * Sets {@code description}, wrapped in a {@link FhirMarkdown} without id or extensions.
                 *
                 * @param description the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder description(String description) {
                    return description(description == null ? null : FhirMarkdown.of(description));
                }

                /**
                 * Sets {@code predecessor}.
                 *
                 * @param predecessor the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder predecessor(Reference predecessor) {
                    this.predecessor = predecessor;
                    return this;
                }

                /**
                 * Builds the {@code TestCaseDependency}.
                 *
                 * @return the {@code TestCaseDependency}
                 */
                public TestCaseDependency build() {
                    return new TestCaseDependency(
                            id, extension, modifierExtension, description, predecessor);
                }
            }
        }

        /**
         * The actual test to be executed.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param narrative The narrative description of the tests.
         * @param script The test cases in a structured language e.g. gherkin, Postman, or FHIR TestScript.
         */
        public record TestRun(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirMarkdown narrative,
                Script script) implements BackboneElement {

            /**
             * Creates a {@code TestRun}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public TestRun {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
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
             * Returns a builder initialized with the values of this {@code TestRun}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * The test cases in a structured language e.g. gherkin, Postman, or FHIR TestScript.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param language The language for the test cases e.g. 'gherkin', 'testscript'.
             * @param source The actual content of the cases - references to TestScripts or externally defined
             *   content. One of string, Reference.
             */
            public record Script(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    CodeableConcept language,
                    DataType source) implements BackboneElement {

                /**
                 * Creates a {@code Script}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 * @throws IllegalArgumentException if a choice element has a type that is not allowed
                 */
                public Script {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    if (source != null && !(source instanceof FhirString || source instanceof Reference)) {
                        throw new IllegalArgumentException(
                                "TestPlan.testCase.testRun.script.source[x] does not allow "
                                        + source.getClass().getSimpleName());
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
                 * Returns a builder initialized with the values of this {@code Script}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Script}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private CodeableConcept language;
                    private DataType source;

                    private Builder() {
                    }

                    private Builder(Script original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.language = original.language();
                        this.source = original.source();
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
                     * Sets {@code language}.
                     *
                     * @param language the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder language(CodeableConcept language) {
                        this.language = language;
                        return this;
                    }

                    /**
                     * Sets {@code source} to a string.
                     *
                     * @param source the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder source(FhirString source) {
                        this.source = source;
                        return this;
                    }

                    /**
                     * Sets {@code source} to a Reference.
                     *
                     * @param source the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder source(Reference source) {
                        this.source = source;
                        return this;
                    }

                    /**
                     * Sets {@code source} to a string without id or extensions.
                     *
                     * @param source the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder source(String source) {
                        this.source = source == null ? null : FhirString.of(source);
                        return this;
                    }

                    /**
                     * Builds the {@code Script}.
                     *
                     * @return the {@code Script}
                     */
                    public Script build() {
                        return new Script(
                                id, extension, modifierExtension, language, source);
                    }
                }
            }

            /** Builder for {@link TestRun}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirMarkdown narrative;
                private Script script;

                private Builder() {
                }

                private Builder(TestRun original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.narrative = original.narrative();
                    this.script = original.script();
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
                 * Sets {@code narrative}.
                 *
                 * @param narrative the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder narrative(FhirMarkdown narrative) {
                    this.narrative = narrative;
                    return this;
                }

                /**
                 * Sets {@code narrative}, wrapped in a {@link FhirMarkdown} without id or extensions.
                 *
                 * @param narrative the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder narrative(String narrative) {
                    return narrative(narrative == null ? null : FhirMarkdown.of(narrative));
                }

                /**
                 * Sets {@code script}.
                 *
                 * @param script the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder script(Script script) {
                    this.script = script;
                    return this;
                }

                /**
                 * Builds the {@code TestRun}.
                 *
                 * @return the {@code TestRun}
                 */
                public TestRun build() {
                    return new TestRun(
                            id, extension, modifierExtension, narrative, script);
                }
            }
        }

        /**
         * The test data used in the test case.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type The type of test data description, e.g. 'synthea'. Required.
         * @param content The actual test resources when they exist.
         * @param source Pointer to a definition of test resources - narrative or structured e.g. synthetic data
         *   generation, etc. One of string, Reference.
         */
        public record TestData(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Coding type,
                Reference content,
                DataType source) implements BackboneElement {

            /**
             * Creates a {@code TestData}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public TestData {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(type, "TestPlan.testCase.testData.type is required");
                if (source != null && !(source instanceof FhirString || source instanceof Reference)) {
                    throw new IllegalArgumentException(
                            "TestPlan.testCase.testData.source[x] must be one of string, Reference, but was "
                                    + source.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code TestData}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link TestData}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Coding type;
                private Reference content;
                private DataType source;

                private Builder() {
                }

                private Builder(TestData original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.content = original.content();
                    this.source = original.source();
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
                 * Sets {@code type}.
                 *
                 * @param type the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder type(Coding type) {
                    this.type = type;
                    return this;
                }

                /**
                 * Sets {@code content}.
                 *
                 * @param content the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder content(Reference content) {
                    this.content = content;
                    return this;
                }

                /**
                 * Sets {@code source} to a string.
                 *
                 * @param source the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder source(FhirString source) {
                    this.source = source;
                    return this;
                }

                /**
                 * Sets {@code source} to a Reference.
                 *
                 * @param source the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder source(Reference source) {
                    this.source = source;
                    return this;
                }

                /**
                 * Sets {@code source} to a string without id or extensions.
                 *
                 * @param source the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder source(String source) {
                    this.source = source == null ? null : FhirString.of(source);
                    return this;
                }

                /**
                 * Builds the {@code TestData}.
                 *
                 * @return the {@code TestData}
                 * @throws NullPointerException if a required element is absent
                 */
                public TestData build() {
                    return new TestData(
                            id, extension, modifierExtension, type, content, source);
                }
            }
        }

        /**
         * The test assertions - the expectations of test results from the execution of the test case.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type Assertion type - for example 'informative' or 'required'.
         * @param object The focus or object of the assertion.
         * @param result The actual result assertion.
         */
        public record Assertion(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<CodeableConcept> type,
                List<CodeableReference> object,
                List<CodeableReference> result) implements BackboneElement {

            /**
             * Creates an {@code Assertion}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Assertion {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                type = type == null ? List.of() : List.copyOf(type);
                object = object == null ? List.of() : List.copyOf(object);
                result = result == null ? List.of() : List.copyOf(result);
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
             * Returns a builder initialized with the values of this {@code Assertion}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Assertion}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<CodeableConcept> type = new ArrayList<>();
                private List<CodeableReference> object = new ArrayList<>();
                private List<CodeableReference> result = new ArrayList<>();

                private Builder() {
                }

                private Builder(Assertion original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = new ArrayList<>(original.type());
                    this.object = new ArrayList<>(original.object());
                    this.result = new ArrayList<>(original.result());
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
                 * Replaces all {@code type} values.
                 *
                 * @param type the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder type(List<CodeableConcept> type) {
                    this.type = type == null ? new ArrayList<>() : new ArrayList<>(type);
                    return this;
                }

                /**
                 * Adds a {@code type} value.
                 *
                 * @param type the value to add
                 * @return this builder
                 */
                public Builder addType(CodeableConcept type) {
                    this.type.add(Objects.requireNonNull(type, "type"));
                    return this;
                }

                /**
                 * Replaces all {@code object} values.
                 *
                 * @param object the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder object(List<CodeableReference> object) {
                    this.object = object == null ? new ArrayList<>() : new ArrayList<>(object);
                    return this;
                }

                /**
                 * Adds a {@code object} value.
                 *
                 * @param object the value to add
                 * @return this builder
                 */
                public Builder addObject(CodeableReference object) {
                    this.object.add(Objects.requireNonNull(object, "object"));
                    return this;
                }

                /**
                 * Replaces all {@code result} values.
                 *
                 * @param result the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder result(List<CodeableReference> result) {
                    this.result = result == null ? new ArrayList<>() : new ArrayList<>(result);
                    return this;
                }

                /**
                 * Adds a {@code result} value.
                 *
                 * @param result the value to add
                 * @return this builder
                 */
                public Builder addResult(CodeableReference result) {
                    this.result.add(Objects.requireNonNull(result, "result"));
                    return this;
                }

                /**
                 * Builds the {@code Assertion}.
                 *
                 * @return the {@code Assertion}
                 */
                public Assertion build() {
                    return new Assertion(
                            id, extension, modifierExtension, type, object, result);
                }
            }
        }

        /** Builder for {@link TestCase}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirInteger sequence;
            private List<Reference> scope = new ArrayList<>();
            private List<TestCaseDependency> dependency = new ArrayList<>();
            private List<TestRun> testRun = new ArrayList<>();
            private List<TestData> testData = new ArrayList<>();
            private List<Assertion> assertion = new ArrayList<>();

            private Builder() {
            }

            private Builder(TestCase original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.scope = new ArrayList<>(original.scope());
                this.dependency = new ArrayList<>(original.dependency());
                this.testRun = new ArrayList<>(original.testRun());
                this.testData = new ArrayList<>(original.testData());
                this.assertion = new ArrayList<>(original.assertion());
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
             * Sets {@code sequence}.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(FhirInteger sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Sets {@code sequence}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(Integer sequence) {
                return sequence(sequence == null ? null : FhirInteger.of(sequence));
            }

            /**
             * Replaces all {@code scope} values.
             *
             * @param scope the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder scope(List<Reference> scope) {
                this.scope = scope == null ? new ArrayList<>() : new ArrayList<>(scope);
                return this;
            }

            /**
             * Adds a {@code scope} value.
             *
             * @param scope the value to add
             * @return this builder
             */
            public Builder addScope(Reference scope) {
                this.scope.add(Objects.requireNonNull(scope, "scope"));
                return this;
            }

            /**
             * Replaces all {@code dependency} values.
             *
             * @param dependency the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder dependency(List<TestCaseDependency> dependency) {
                this.dependency = dependency == null ? new ArrayList<>() : new ArrayList<>(dependency);
                return this;
            }

            /**
             * Adds a {@code dependency} value.
             *
             * @param dependency the value to add
             * @return this builder
             */
            public Builder addDependency(TestCaseDependency dependency) {
                this.dependency.add(Objects.requireNonNull(dependency, "dependency"));
                return this;
            }

            /**
             * Replaces all {@code testRun} values.
             *
             * @param testRun the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder testRun(List<TestRun> testRun) {
                this.testRun = testRun == null ? new ArrayList<>() : new ArrayList<>(testRun);
                return this;
            }

            /**
             * Adds a {@code testRun} value.
             *
             * @param testRun the value to add
             * @return this builder
             */
            public Builder addTestRun(TestRun testRun) {
                this.testRun.add(Objects.requireNonNull(testRun, "testRun"));
                return this;
            }

            /**
             * Replaces all {@code testData} values.
             *
             * @param testData the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder testData(List<TestData> testData) {
                this.testData = testData == null ? new ArrayList<>() : new ArrayList<>(testData);
                return this;
            }

            /**
             * Adds a {@code testData} value.
             *
             * @param testData the value to add
             * @return this builder
             */
            public Builder addTestData(TestData testData) {
                this.testData.add(Objects.requireNonNull(testData, "testData"));
                return this;
            }

            /**
             * Replaces all {@code assertion} values.
             *
             * @param assertion the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder assertion(List<Assertion> assertion) {
                this.assertion = assertion == null ? new ArrayList<>() : new ArrayList<>(assertion);
                return this;
            }

            /**
             * Adds a {@code assertion} value.
             *
             * @param assertion the value to add
             * @return this builder
             */
            public Builder addAssertion(Assertion assertion) {
                this.assertion.add(Objects.requireNonNull(assertion, "assertion"));
                return this;
            }

            /**
             * Builds the {@code TestCase}.
             *
             * @return the {@code TestCase}
             */
            public TestCase build() {
                return new TestCase(
                        id, extension, modifierExtension, sequence, scope, dependency, testRun, testData, assertion);
            }
        }
    }

    /** Builder for {@link TestPlan}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirUri url;
        private List<Identifier> identifier = new ArrayList<>();
        private FhirString version;
        private DataType versionAlgorithm;
        private FhirString name;
        private FhirString title;
        private FhirEnum<PublicationStatus> status;
        private FhirBoolean experimental;
        private FhirDateTime date;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private FhirMarkdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private FhirMarkdown purpose;
        private FhirMarkdown copyright;
        private FhirString copyrightLabel;
        private List<CodeableConcept> category = new ArrayList<>();
        private List<Reference> scope = new ArrayList<>();
        private FhirMarkdown testTools;
        private List<Dependency> dependency = new ArrayList<>();
        private FhirMarkdown exitCriteria;
        private List<TestCase> testCase = new ArrayList<>();

        private Builder() {
        }

        private Builder(TestPlan original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.url = original.url();
            this.identifier = new ArrayList<>(original.identifier());
            this.version = original.version();
            this.versionAlgorithm = original.versionAlgorithm();
            this.name = original.name();
            this.title = original.title();
            this.status = original.status();
            this.experimental = original.experimental();
            this.date = original.date();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.description = original.description();
            this.useContext = new ArrayList<>(original.useContext());
            this.jurisdiction = new ArrayList<>(original.jurisdiction());
            this.purpose = original.purpose();
            this.copyright = original.copyright();
            this.copyrightLabel = original.copyrightLabel();
            this.category = new ArrayList<>(original.category());
            this.scope = new ArrayList<>(original.scope());
            this.testTools = original.testTools();
            this.dependency = new ArrayList<>(original.dependency());
            this.exitCriteria = original.exitCriteria();
            this.testCase = new ArrayList<>(original.testCase());
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
         * Sets {@code url}.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(FhirUri url) {
            this.url = url;
            return this;
        }

        /**
         * Sets {@code url}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param url the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder url(String url) {
            return url(url == null ? null : FhirUri.of(url));
        }

        /**
         * Replaces all {@code identifier} values.
         *
         * @param identifier the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder identifier(List<Identifier> identifier) {
            this.identifier = identifier == null ? new ArrayList<>() : new ArrayList<>(identifier);
            return this;
        }

        /**
         * Adds a {@code identifier} value.
         *
         * @param identifier the value to add
         * @return this builder
         */
        public Builder addIdentifier(Identifier identifier) {
            this.identifier.add(Objects.requireNonNull(identifier, "identifier"));
            return this;
        }

        /**
         * Sets {@code version}.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(FhirString version) {
            this.version = version;
            return this;
        }

        /**
         * Sets {@code version}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param version the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder version(String version) {
            return version(version == null ? null : FhirString.of(version));
        }

        /**
         * Sets {@code versionAlgorithm} to a string.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(FhirString versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a Coding.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(Coding versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a string without id or extensions.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(String versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm == null ? null : FhirString.of(versionAlgorithm);
            return this;
        }

        /**
         * Sets {@code name}.
         *
         * @param name the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder name(FhirString name) {
            this.name = name;
            return this;
        }

        /**
         * Sets {@code name}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param name the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder name(String name) {
            return name(name == null ? null : FhirString.of(name));
        }

        /**
         * Sets {@code title}.
         *
         * @param title the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder title(FhirString title) {
            this.title = title;
            return this;
        }

        /**
         * Sets {@code title}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param title the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder title(String title) {
            return title(title == null ? null : FhirString.of(title));
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<PublicationStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(PublicationStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code experimental}.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(FhirBoolean experimental) {
            this.experimental = experimental;
            return this;
        }

        /**
         * Sets {@code experimental}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(Boolean experimental) {
            return experimental(experimental == null ? null : FhirBoolean.of(experimental));
        }

        /**
         * Sets {@code date}.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(FhirDateTime date) {
            this.date = date;
            return this;
        }

        /**
         * Sets {@code date}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(Temporal date) {
            return date(date == null ? null : FhirDateTime.of(date));
        }

        /**
         * Sets {@code publisher}.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(FhirString publisher) {
            this.publisher = publisher;
            return this;
        }

        /**
         * Sets {@code publisher}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(String publisher) {
            return publisher(publisher == null ? null : FhirString.of(publisher));
        }

        /**
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ContactDetail> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ContactDetail contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
            return this;
        }

        /**
         * Sets {@code description}.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(FhirMarkdown description) {
            this.description = description;
            return this;
        }

        /**
         * Sets {@code description}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(String description) {
            return description(description == null ? null : FhirMarkdown.of(description));
        }

        /**
         * Replaces all {@code useContext} values.
         *
         * @param useContext the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder useContext(List<UsageContext> useContext) {
            this.useContext = useContext == null ? new ArrayList<>() : new ArrayList<>(useContext);
            return this;
        }

        /**
         * Adds a {@code useContext} value.
         *
         * @param useContext the value to add
         * @return this builder
         */
        public Builder addUseContext(UsageContext useContext) {
            this.useContext.add(Objects.requireNonNull(useContext, "useContext"));
            return this;
        }

        /**
         * Replaces all {@code jurisdiction} values.
         *
         * @param jurisdiction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder jurisdiction(List<CodeableConcept> jurisdiction) {
            this.jurisdiction = jurisdiction == null ? new ArrayList<>() : new ArrayList<>(jurisdiction);
            return this;
        }

        /**
         * Adds a {@code jurisdiction} value.
         *
         * @param jurisdiction the value to add
         * @return this builder
         */
        public Builder addJurisdiction(CodeableConcept jurisdiction) {
            this.jurisdiction.add(Objects.requireNonNull(jurisdiction, "jurisdiction"));
            return this;
        }

        /**
         * Sets {@code purpose}.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(FhirMarkdown purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * Sets {@code purpose}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(String purpose) {
            return purpose(purpose == null ? null : FhirMarkdown.of(purpose));
        }

        /**
         * Sets {@code copyright}.
         *
         * @param copyright the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyright(FhirMarkdown copyright) {
            this.copyright = copyright;
            return this;
        }

        /**
         * Sets {@code copyright}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param copyright the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyright(String copyright) {
            return copyright(copyright == null ? null : FhirMarkdown.of(copyright));
        }

        /**
         * Sets {@code copyrightLabel}.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(FhirString copyrightLabel) {
            this.copyrightLabel = copyrightLabel;
            return this;
        }

        /**
         * Sets {@code copyrightLabel}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(String copyrightLabel) {
            return copyrightLabel(copyrightLabel == null ? null : FhirString.of(copyrightLabel));
        }

        /**
         * Replaces all {@code category} values.
         *
         * @param category the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder category(List<CodeableConcept> category) {
            this.category = category == null ? new ArrayList<>() : new ArrayList<>(category);
            return this;
        }

        /**
         * Adds a {@code category} value.
         *
         * @param category the value to add
         * @return this builder
         */
        public Builder addCategory(CodeableConcept category) {
            this.category.add(Objects.requireNonNull(category, "category"));
            return this;
        }

        /**
         * Replaces all {@code scope} values.
         *
         * @param scope the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder scope(List<Reference> scope) {
            this.scope = scope == null ? new ArrayList<>() : new ArrayList<>(scope);
            return this;
        }

        /**
         * Adds a {@code scope} value.
         *
         * @param scope the value to add
         * @return this builder
         */
        public Builder addScope(Reference scope) {
            this.scope.add(Objects.requireNonNull(scope, "scope"));
            return this;
        }

        /**
         * Sets {@code testTools}.
         *
         * @param testTools the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder testTools(FhirMarkdown testTools) {
            this.testTools = testTools;
            return this;
        }

        /**
         * Sets {@code testTools}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param testTools the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder testTools(String testTools) {
            return testTools(testTools == null ? null : FhirMarkdown.of(testTools));
        }

        /**
         * Replaces all {@code dependency} values.
         *
         * @param dependency the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder dependency(List<Dependency> dependency) {
            this.dependency = dependency == null ? new ArrayList<>() : new ArrayList<>(dependency);
            return this;
        }

        /**
         * Adds a {@code dependency} value.
         *
         * @param dependency the value to add
         * @return this builder
         */
        public Builder addDependency(Dependency dependency) {
            this.dependency.add(Objects.requireNonNull(dependency, "dependency"));
            return this;
        }

        /**
         * Sets {@code exitCriteria}.
         *
         * @param exitCriteria the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder exitCriteria(FhirMarkdown exitCriteria) {
            this.exitCriteria = exitCriteria;
            return this;
        }

        /**
         * Sets {@code exitCriteria}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param exitCriteria the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder exitCriteria(String exitCriteria) {
            return exitCriteria(exitCriteria == null ? null : FhirMarkdown.of(exitCriteria));
        }

        /**
         * Replaces all {@code testCase} values.
         *
         * @param testCase the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder testCase(List<TestCase> testCase) {
            this.testCase = testCase == null ? new ArrayList<>() : new ArrayList<>(testCase);
            return this;
        }

        /**
         * Adds a {@code testCase} value.
         *
         * @param testCase the value to add
         * @return this builder
         */
        public Builder addTestCase(TestCase testCase) {
            this.testCase.add(Objects.requireNonNull(testCase, "testCase"));
            return this;
        }

        /**
         * Builds the {@code TestPlan}.
         *
         * @return the {@code TestPlan}
         * @throws NullPointerException if a required element is absent
         */
        public TestPlan build() {
            return new TestPlan(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, category, scope,
                    testTools, dependency, exitCriteria, testCase);
        }
    }
}
