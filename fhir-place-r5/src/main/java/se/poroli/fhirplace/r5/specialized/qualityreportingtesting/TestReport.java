package se.poroli.fhirplace.r5.specialized.qualityreportingtesting;

import java.math.BigDecimal;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.valuesets.TestReportActionResult;
import se.poroli.fhirplace.r5.valuesets.TestReportParticipantType;
import se.poroli.fhirplace.r5.valuesets.TestReportResult;
import se.poroli.fhirplace.r5.valuesets.TestReportStatus;

/**
 * A summary of information based on the results of executing a TestScript.
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
 * @param identifier External identifier.
 * @param name Informal name of the executed TestReport.
 * @param status completed | in-progress | waiting | stopped | entered-in-error. Required. Modifier element.
 * @param testScript Canonical URL to the version-specific TestScript that was executed to produce this TestReport.
 *   Canonical reference to TestScript. Required.
 * @param result pass | fail | pending. Required.
 * @param score The final score (percentage of tests passed) resulting from the execution of the TestScript.
 * @param tester Name of the tester producing this report (Organization or individual).
 * @param issued When the TestScript was executed and this TestReport was generated.
 * @param participant A participant in the test execution, either the execution engine, a client, or a server.
 * @param setup The results of the series of required setup operations before the tests were executed.
 * @param test A test executed from the test script.
 * @param teardown The results of running the series of required clean up steps.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/TestReport">FHIR R5 TestReport</a>
 */
public record TestReport(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        Identifier identifier,
        FhirString name,
        FhirEnum<TestReportStatus> status,
        FhirCanonical testScript,
        FhirEnum<TestReportResult> result,
        FhirDecimal score,
        FhirString tester,
        FhirDateTime issued,
        List<Participant> participant,
        Setup setup,
        List<Test> test,
        Teardown teardown) implements DomainResource {

    /**
     * Creates a {@code TestReport}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public TestReport {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        participant = participant == null ? List.of() : List.copyOf(participant);
        test = test == null ? List.of() : List.copyOf(test);
        Objects.requireNonNull(status, "TestReport.status is required");
        Objects.requireNonNull(testScript, "TestReport.testScript is required");
        Objects.requireNonNull(result, "TestReport.result is required");
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
     * Returns a builder initialized with the values of this {@code TestReport}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A participant in the test execution, either the execution engine, a client, or a server.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type test-engine | client | server. Required.
     * @param uri The uri of the participant. An absolute URL is preferred. Required.
     * @param display The display name of the participant.
     */
    public record Participant(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<TestReportParticipantType> type,
            FhirUri uri,
            FhirString display) implements BackboneElement {

        /**
         * Creates a {@code Participant}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Participant {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "TestReport.participant.type is required");
            Objects.requireNonNull(uri, "TestReport.participant.uri is required");
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
         * Returns a builder initialized with the values of this {@code Participant}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Participant}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<TestReportParticipantType> type;
            private FhirUri uri;
            private FhirString display;

            private Builder() {
            }

            private Builder(Participant original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.uri = original.uri();
                this.display = original.display();
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
            public Builder type(FhirEnum<TestReportParticipantType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(TestReportParticipantType type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Sets {@code uri}.
             *
             * @param uri the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder uri(FhirUri uri) {
                this.uri = uri;
                return this;
            }

            /**
             * Sets {@code uri}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param uri the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder uri(String uri) {
                return uri(uri == null ? null : FhirUri.of(uri));
            }

            /**
             * Sets {@code display}.
             *
             * @param display the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder display(FhirString display) {
                this.display = display;
                return this;
            }

            /**
             * Sets {@code display}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param display the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder display(String display) {
                return display(display == null ? null : FhirString.of(display));
            }

            /**
             * Builds the {@code Participant}.
             *
             * @return the {@code Participant}
             * @throws NullPointerException if a required element is absent
             */
            public Participant build() {
                return new Participant(
                        id, extension, modifierExtension, type, uri, display);
            }
        }
    }

    /**
     * The results of the series of required setup operations before the tests were executed.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param action A setup operation or assert that was executed. Required.
     */
    public record Setup(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<SetupAction> action) implements BackboneElement {

        /**
         * Creates a {@code Setup}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Setup {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            action = action == null ? List.of() : List.copyOf(action);
            if (action.isEmpty()) {
                throw new IllegalArgumentException("TestReport.setup.action requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Setup}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Action would contain either an operation or an assertion.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param operation The operation to perform.
         * @param assertValue The assertion to perform. The FHIR element {@code assert}.
         */
        public record SetupAction(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Operation operation,
                AssertValue assertValue) implements BackboneElement {

            /**
             * Creates a {@code SetupAction}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public SetupAction {
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
             * Returns a builder initialized with the values of this {@code SetupAction}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * The operation performed.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param result pass | skip | fail | warning | error. Required.
             * @param message A message associated with the result.
             * @param detail A link to further details on the result.
             */
            public record Operation(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirEnum<TestReportActionResult> result,
                    FhirMarkdown message,
                    FhirUri detail) implements BackboneElement {

                /**
                 * Creates an {@code Operation}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public Operation {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(result, "TestReport.setup.action.operation.result is required");
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
                 * Returns a builder initialized with the values of this {@code Operation}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Operation}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirEnum<TestReportActionResult> result;
                    private FhirMarkdown message;
                    private FhirUri detail;

                    private Builder() {
                    }

                    private Builder(Operation original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.result = original.result();
                        this.message = original.message();
                        this.detail = original.detail();
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
                     * Sets {@code result}.
                     *
                     * @param result the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder result(FhirEnum<TestReportActionResult> result) {
                        this.result = result;
                        return this;
                    }

                    /**
                     * Sets {@code result}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param result the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder result(TestReportActionResult result) {
                        return result(result == null ? null : FhirEnum.of(result));
                    }

                    /**
                     * Sets {@code message}.
                     *
                     * @param message the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder message(FhirMarkdown message) {
                        this.message = message;
                        return this;
                    }

                    /**
                     * Sets {@code message}, wrapped in a {@link FhirMarkdown} without id or extensions.
                     *
                     * @param message the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder message(String message) {
                        return message(message == null ? null : FhirMarkdown.of(message));
                    }

                    /**
                     * Sets {@code detail}.
                     *
                     * @param detail the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder detail(FhirUri detail) {
                        this.detail = detail;
                        return this;
                    }

                    /**
                     * Sets {@code detail}, wrapped in a {@link FhirUri} without id or extensions.
                     *
                     * @param detail the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder detail(String detail) {
                        return detail(detail == null ? null : FhirUri.of(detail));
                    }

                    /**
                     * Builds the {@code Operation}.
                     *
                     * @return the {@code Operation}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Operation build() {
                        return new Operation(
                                id, extension, modifierExtension, result, message, detail);
                    }
                }
            }

            /**
             * The results of the assertion performed on the previous operations.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param result pass | skip | fail | warning | error. Required.
             * @param message A message associated with the result.
             * @param detail A link to further details on the result.
             * @param requirement Links or references to the testing requirements.
             */
            public record AssertValue(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirEnum<TestReportActionResult> result,
                    FhirMarkdown message,
                    FhirString detail,
                    List<Requirement> requirement) implements BackboneElement {

                /**
                 * Creates an {@code AssertValue}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public AssertValue {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    requirement = requirement == null ? List.of() : List.copyOf(requirement);
                    Objects.requireNonNull(result, "TestReport.setup.action.assert.result is required");
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
                 * Returns a builder initialized with the values of this {@code AssertValue}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /**
                 * Links or references providing traceability to the testing requirements for this assert.
                 *
                 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
                 * Instances are usually created with {@link #builder()}.
                 *
                 * @param id Unique id for inter-element referencing.
                 * @param extension Additional content defined by implementations.
                 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
                 * @param link Link or reference to the testing requirement. One of uri, canonical.
                 */
                public record Requirement(
                        String id,
                        List<Extension> extension,
                        List<Extension> modifierExtension,
                        DataType link) implements BackboneElement {

                    /**
                     * Creates a {@code Requirement}, copying all lists.
                     *
                     * @throws NullPointerException if a list contains {@code null}
                     * @throws IllegalArgumentException if a choice element has a type that is not allowed
                     */
                    public Requirement {
                        extension = extension == null ? List.of() : List.copyOf(extension);
                        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                        if (link != null && !(link instanceof FhirUri || link instanceof FhirCanonical)) {
                            throw new IllegalArgumentException(
                                    "TestReport.setup.action.assert.requirement.link[x] does not allow "
                                            + link.getClass().getSimpleName());
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
                     * Returns a builder initialized with the values of this {@code Requirement}.
                     *
                     * @return the builder
                     */
                    public Builder toBuilder() {
                        return new Builder(this);
                    }

                    /** Builder for {@link Requirement}. Builders are mutable and not thread-safe. */
                    public static final class Builder {

                        private String id;
                        private List<Extension> extension = new ArrayList<>();
                        private List<Extension> modifierExtension = new ArrayList<>();
                        private DataType link;

                        private Builder() {
                        }

                        private Builder(Requirement original) {
                            this.id = original.id();
                            this.extension = new ArrayList<>(original.extension());
                            this.modifierExtension = new ArrayList<>(original.modifierExtension());
                            this.link = original.link();
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
                            this.modifierExtension.add(
                                    Objects.requireNonNull(modifierExtension, "modifierExtension"));
                            return this;
                        }

                        /**
                         * Sets {@code link} to a uri.
                         *
                         * @param link the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder link(FhirUri link) {
                            this.link = link;
                            return this;
                        }

                        /**
                         * Sets {@code link} to a canonical.
                         *
                         * @param link the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder link(FhirCanonical link) {
                            this.link = link;
                            return this;
                        }

                        /**
                         * Builds the {@code Requirement}.
                         *
                         * @return the {@code Requirement}
                         */
                        public Requirement build() {
                            return new Requirement(
                                    id, extension, modifierExtension, link);
                        }
                    }
                }

                /** Builder for {@link AssertValue}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirEnum<TestReportActionResult> result;
                    private FhirMarkdown message;
                    private FhirString detail;
                    private List<Requirement> requirement = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(AssertValue original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.result = original.result();
                        this.message = original.message();
                        this.detail = original.detail();
                        this.requirement = new ArrayList<>(original.requirement());
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
                     * Sets {@code result}.
                     *
                     * @param result the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder result(FhirEnum<TestReportActionResult> result) {
                        this.result = result;
                        return this;
                    }

                    /**
                     * Sets {@code result}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param result the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder result(TestReportActionResult result) {
                        return result(result == null ? null : FhirEnum.of(result));
                    }

                    /**
                     * Sets {@code message}.
                     *
                     * @param message the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder message(FhirMarkdown message) {
                        this.message = message;
                        return this;
                    }

                    /**
                     * Sets {@code message}, wrapped in a {@link FhirMarkdown} without id or extensions.
                     *
                     * @param message the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder message(String message) {
                        return message(message == null ? null : FhirMarkdown.of(message));
                    }

                    /**
                     * Sets {@code detail}.
                     *
                     * @param detail the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder detail(FhirString detail) {
                        this.detail = detail;
                        return this;
                    }

                    /**
                     * Sets {@code detail}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param detail the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder detail(String detail) {
                        return detail(detail == null ? null : FhirString.of(detail));
                    }

                    /**
                     * Replaces all {@code requirement} values.
                     *
                     * @param requirement the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder requirement(List<Requirement> requirement) {
                        this.requirement = requirement == null ? new ArrayList<>() : new ArrayList<>(requirement);
                        return this;
                    }

                    /**
                     * Adds a {@code requirement} value.
                     *
                     * @param requirement the value to add
                     * @return this builder
                     */
                    public Builder addRequirement(Requirement requirement) {
                        this.requirement.add(Objects.requireNonNull(requirement, "requirement"));
                        return this;
                    }

                    /**
                     * Builds the {@code AssertValue}.
                     *
                     * @return the {@code AssertValue}
                     * @throws NullPointerException if a required element is absent
                     */
                    public AssertValue build() {
                        return new AssertValue(
                                id, extension, modifierExtension, result, message, detail, requirement);
                    }
                }
            }

            /** Builder for {@link SetupAction}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Operation operation;
                private AssertValue assertValue;

                private Builder() {
                }

                private Builder(SetupAction original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.operation = original.operation();
                    this.assertValue = original.assertValue();
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
                 * Sets {@code operation}.
                 *
                 * @param operation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder operation(Operation operation) {
                    this.operation = operation;
                    return this;
                }

                /**
                 * Sets {@code assertValue}.
                 *
                 * @param assertValue the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder assertValue(AssertValue assertValue) {
                    this.assertValue = assertValue;
                    return this;
                }

                /**
                 * Builds the {@code SetupAction}.
                 *
                 * @return the {@code SetupAction}
                 */
                public SetupAction build() {
                    return new SetupAction(
                            id, extension, modifierExtension, operation, assertValue);
                }
            }
        }

        /** Builder for {@link Setup}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<SetupAction> action = new ArrayList<>();

            private Builder() {
            }

            private Builder(Setup original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.action = new ArrayList<>(original.action());
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
             * Replaces all {@code action} values.
             *
             * @param action the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder action(List<SetupAction> action) {
                this.action = action == null ? new ArrayList<>() : new ArrayList<>(action);
                return this;
            }

            /**
             * Adds a {@code action} value.
             *
             * @param action the value to add
             * @return this builder
             */
            public Builder addAction(SetupAction action) {
                this.action.add(Objects.requireNonNull(action, "action"));
                return this;
            }

            /**
             * Builds the {@code Setup}.
             *
             * @return the {@code Setup}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Setup build() {
                return new Setup(
                        id, extension, modifierExtension, action);
            }
        }
    }

    /**
     * A test executed from the test script.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Tracking/logging name of this test.
     * @param description Tracking/reporting short description of the test.
     * @param action A test operation or assert that was performed. Required.
     */
    public record Test(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            FhirString description,
            List<TestAction> action) implements BackboneElement {

        /**
         * Creates a {@code Test}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Test {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            action = action == null ? List.of() : List.copyOf(action);
            if (action.isEmpty()) {
                throw new IllegalArgumentException("TestReport.test.action requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Test}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Action would contain either an operation or an assertion.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param operation The operation performed.
         * @param assertValue The assertion performed. The FHIR element {@code assert}.
         */
        public record TestAction(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                TestReport.Setup.SetupAction.Operation operation,
                TestReport.Setup.SetupAction.AssertValue assertValue) implements BackboneElement {

            /**
             * Creates a {@code TestAction}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public TestAction {
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
             * Returns a builder initialized with the values of this {@code TestAction}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link TestAction}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private TestReport.Setup.SetupAction.Operation operation;
                private TestReport.Setup.SetupAction.AssertValue assertValue;

                private Builder() {
                }

                private Builder(TestAction original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.operation = original.operation();
                    this.assertValue = original.assertValue();
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
                 * Sets {@code operation}.
                 *
                 * @param operation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder operation(TestReport.Setup.SetupAction.Operation operation) {
                    this.operation = operation;
                    return this;
                }

                /**
                 * Sets {@code assertValue}.
                 *
                 * @param assertValue the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder assertValue(TestReport.Setup.SetupAction.AssertValue assertValue) {
                    this.assertValue = assertValue;
                    return this;
                }

                /**
                 * Builds the {@code TestAction}.
                 *
                 * @return the {@code TestAction}
                 */
                public TestAction build() {
                    return new TestAction(
                            id, extension, modifierExtension, operation, assertValue);
                }
            }
        }

        /** Builder for {@link Test}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString name;
            private FhirString description;
            private List<TestAction> action = new ArrayList<>();

            private Builder() {
            }

            private Builder(Test original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.description = original.description();
                this.action = new ArrayList<>(original.action());
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
             * Replaces all {@code action} values.
             *
             * @param action the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder action(List<TestAction> action) {
                this.action = action == null ? new ArrayList<>() : new ArrayList<>(action);
                return this;
            }

            /**
             * Adds a {@code action} value.
             *
             * @param action the value to add
             * @return this builder
             */
            public Builder addAction(TestAction action) {
                this.action.add(Objects.requireNonNull(action, "action"));
                return this;
            }

            /**
             * Builds the {@code Test}.
             *
             * @return the {@code Test}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Test build() {
                return new Test(
                        id, extension, modifierExtension, name, description, action);
            }
        }
    }

    /**
     * The results of the series of operations required to clean up after all the tests were executed (successfully or
     * otherwise).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param action One or more teardown operations performed. Required.
     */
    public record Teardown(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<TeardownAction> action) implements BackboneElement {

        /**
         * Creates a {@code Teardown}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Teardown {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            action = action == null ? List.of() : List.copyOf(action);
            if (action.isEmpty()) {
                throw new IllegalArgumentException("TestReport.teardown.action requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Teardown}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The teardown action will only contain an operation.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param operation The teardown operation performed. Required.
         */
        public record TeardownAction(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                TestReport.Setup.SetupAction.Operation operation) implements BackboneElement {

            /**
             * Creates a {@code TeardownAction}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public TeardownAction {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(operation, "TestReport.teardown.action.operation is required");
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
             * Returns a builder initialized with the values of this {@code TeardownAction}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link TeardownAction}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private TestReport.Setup.SetupAction.Operation operation;

                private Builder() {
                }

                private Builder(TeardownAction original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.operation = original.operation();
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
                 * Sets {@code operation}.
                 *
                 * @param operation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder operation(TestReport.Setup.SetupAction.Operation operation) {
                    this.operation = operation;
                    return this;
                }

                /**
                 * Builds the {@code TeardownAction}.
                 *
                 * @return the {@code TeardownAction}
                 * @throws NullPointerException if a required element is absent
                 */
                public TeardownAction build() {
                    return new TeardownAction(
                            id, extension, modifierExtension, operation);
                }
            }
        }

        /** Builder for {@link Teardown}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<TeardownAction> action = new ArrayList<>();

            private Builder() {
            }

            private Builder(Teardown original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.action = new ArrayList<>(original.action());
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
             * Replaces all {@code action} values.
             *
             * @param action the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder action(List<TeardownAction> action) {
                this.action = action == null ? new ArrayList<>() : new ArrayList<>(action);
                return this;
            }

            /**
             * Adds a {@code action} value.
             *
             * @param action the value to add
             * @return this builder
             */
            public Builder addAction(TeardownAction action) {
                this.action.add(Objects.requireNonNull(action, "action"));
                return this;
            }

            /**
             * Builds the {@code Teardown}.
             *
             * @return the {@code Teardown}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Teardown build() {
                return new Teardown(
                        id, extension, modifierExtension, action);
            }
        }
    }

    /** Builder for {@link TestReport}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private Identifier identifier;
        private FhirString name;
        private FhirEnum<TestReportStatus> status;
        private FhirCanonical testScript;
        private FhirEnum<TestReportResult> result;
        private FhirDecimal score;
        private FhirString tester;
        private FhirDateTime issued;
        private List<Participant> participant = new ArrayList<>();
        private Setup setup;
        private List<Test> test = new ArrayList<>();
        private Teardown teardown;

        private Builder() {
        }

        private Builder(TestReport original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = original.identifier();
            this.name = original.name();
            this.status = original.status();
            this.testScript = original.testScript();
            this.result = original.result();
            this.score = original.score();
            this.tester = original.tester();
            this.issued = original.issued();
            this.participant = new ArrayList<>(original.participant());
            this.setup = original.setup();
            this.test = new ArrayList<>(original.test());
            this.teardown = original.teardown();
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
         * Sets {@code identifier}.
         *
         * @param identifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder identifier(Identifier identifier) {
            this.identifier = identifier;
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<TestReportStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(TestReportStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code testScript}.
         *
         * @param testScript the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder testScript(FhirCanonical testScript) {
            this.testScript = testScript;
            return this;
        }

        /**
         * Sets {@code testScript}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param testScript the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder testScript(String testScript) {
            return testScript(testScript == null ? null : FhirCanonical.of(testScript));
        }

        /**
         * Sets {@code result}.
         *
         * @param result the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder result(FhirEnum<TestReportResult> result) {
            this.result = result;
            return this;
        }

        /**
         * Sets {@code result}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param result the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder result(TestReportResult result) {
            return result(result == null ? null : FhirEnum.of(result));
        }

        /**
         * Sets {@code score}.
         *
         * @param score the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder score(FhirDecimal score) {
            this.score = score;
            return this;
        }

        /**
         * Sets {@code score}, wrapped in a {@link FhirDecimal} without id or extensions.
         *
         * @param score the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder score(BigDecimal score) {
            return score(score == null ? null : FhirDecimal.of(score));
        }

        /**
         * Sets {@code tester}.
         *
         * @param tester the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder tester(FhirString tester) {
            this.tester = tester;
            return this;
        }

        /**
         * Sets {@code tester}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param tester the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder tester(String tester) {
            return tester(tester == null ? null : FhirString.of(tester));
        }

        /**
         * Sets {@code issued}.
         *
         * @param issued the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issued(FhirDateTime issued) {
            this.issued = issued;
            return this;
        }

        /**
         * Sets {@code issued}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param issued the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issued(Temporal issued) {
            return issued(issued == null ? null : FhirDateTime.of(issued));
        }

        /**
         * Replaces all {@code participant} values.
         *
         * @param participant the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder participant(List<Participant> participant) {
            this.participant = participant == null ? new ArrayList<>() : new ArrayList<>(participant);
            return this;
        }

        /**
         * Adds a {@code participant} value.
         *
         * @param participant the value to add
         * @return this builder
         */
        public Builder addParticipant(Participant participant) {
            this.participant.add(Objects.requireNonNull(participant, "participant"));
            return this;
        }

        /**
         * Sets {@code setup}.
         *
         * @param setup the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder setup(Setup setup) {
            this.setup = setup;
            return this;
        }

        /**
         * Replaces all {@code test} values.
         *
         * @param test the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder test(List<Test> test) {
            this.test = test == null ? new ArrayList<>() : new ArrayList<>(test);
            return this;
        }

        /**
         * Adds a {@code test} value.
         *
         * @param test the value to add
         * @return this builder
         */
        public Builder addTest(Test test) {
            this.test.add(Objects.requireNonNull(test, "test"));
            return this;
        }

        /**
         * Sets {@code teardown}.
         *
         * @param teardown the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder teardown(Teardown teardown) {
            this.teardown = teardown;
            return this;
        }

        /**
         * Builds the {@code TestReport}.
         *
         * @return the {@code TestReport}
         * @throws NullPointerException if a required element is absent
         */
        public TestReport build() {
            return new TestReport(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    name, status, testScript, result, score, tester, issued, participant, setup, test, teardown);
        }
    }
}
