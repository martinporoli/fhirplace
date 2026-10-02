package se.poroli.fhirplace.r5.testscript;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR
 * specification.
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
 * @param url Canonical identifier for this test script, represented as a URI (globally unique).
 * @param identifier Additional identifier for the test script.
 * @param version Business version of the test script.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this test script (computer friendly). Required.
 * @param title Name for this test script (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the test script.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for test script (if applicable).
 * @param purpose Why this test script is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param origin An abstract server representing a client or sender in a message exchange.
 * @param destination An abstract server representing a destination or receiver in a message exchange.
 * @param metadata Required capability that is assumed to function correctly on the FHIR server being tested.
 * @param scope Indication of the artifact(s) that are tested by this test case.
 * @param fixture Fixture in the test script - by reference (uri).
 * @param profile Reference of the validation profile. Canonical reference to StructureDefinition.
 * @param variable Placeholder for evaluated elements.
 * @param setup A series of required setup operations before tests are executed.
 * @param test A test in this script.
 * @param teardown A series of required clean up steps.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/TestScript">FHIR R5 TestScript</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record TestScript(
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
        List<Origin> origin,
        List<Destination> destination,
        Metadata metadata,
        List<Scope> scope,
        List<Fixture> fixture,
        List<FhirCanonical> profile,
        List<Variable> variable,
        Setup setup,
        List<Test> test,
        Teardown teardown) implements DomainResource {

    /**
     * Creates a {@code TestScript}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public TestScript {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        origin = origin == null ? List.of() : List.copyOf(origin);
        destination = destination == null ? List.of() : List.copyOf(destination);
        scope = scope == null ? List.of() : List.copyOf(scope);
        fixture = fixture == null ? List.of() : List.copyOf(fixture);
        profile = profile == null ? List.of() : List.copyOf(profile);
        variable = variable == null ? List.of() : List.copyOf(variable);
        test = test == null ? List.of() : List.copyOf(test);
        Objects.requireNonNull(name, "TestScript.name is required");
        Objects.requireNonNull(status, "TestScript.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "TestScript.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code TestScript}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * An abstract server used in operations within this test script in the origin element.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param index The index of the abstract origin server starting at 1. Required.
     * @param profile FHIR-Client | FHIR-SDC-FormFiller. Required.
     * @param url The url path of the origin server.
     */
    public record Origin(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirInteger index,
            Coding profile,
            FhirUrl url) implements BackboneElement {

        /**
         * Creates an {@code Origin}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Origin {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(index, "TestScript.origin.index is required");
            Objects.requireNonNull(profile, "TestScript.origin.profile is required");
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
         * Returns a builder initialized with the values of this {@code Origin}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Origin}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirInteger index;
            private Coding profile;
            private FhirUrl url;

            private Builder() {
            }

            private Builder(Origin original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.index = original.index();
                this.profile = original.profile();
                this.url = original.url();
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
             * Sets {@code index}.
             *
             * @param index the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder index(FhirInteger index) {
                this.index = index;
                return this;
            }

            /**
             * Sets {@code index}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param index the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder index(Integer index) {
                return index(index == null ? null : FhirInteger.of(index));
            }

            /**
             * Sets {@code profile}.
             *
             * @param profile the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder profile(Coding profile) {
                this.profile = profile;
                return this;
            }

            /**
             * Sets {@code url}.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(FhirUrl url) {
                this.url = url;
                return this;
            }

            /**
             * Sets {@code url}, wrapped in a {@link FhirUrl} without id or extensions.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(String url) {
                return url(url == null ? null : FhirUrl.of(url));
            }

            /**
             * Builds the {@code Origin}.
             *
             * @return the {@code Origin}
             * @throws NullPointerException if a required element is absent
             */
            public Origin build() {
                return new Origin(
                        id, extension, modifierExtension, index, profile, url);
            }
        }
    }

    /**
     * An abstract server used in operations within this test script in the destination element.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param index The index of the abstract destination server starting at 1. Required.
     * @param profile FHIR-Server | FHIR-SDC-FormManager | FHIR-SDC-FormReceiver | FHIR-SDC-FormProcessor. Required.
     * @param url The url path of the destination server.
     */
    public record Destination(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirInteger index,
            Coding profile,
            FhirUrl url) implements BackboneElement {

        /**
         * Creates a {@code Destination}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Destination {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(index, "TestScript.destination.index is required");
            Objects.requireNonNull(profile, "TestScript.destination.profile is required");
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
         * Returns a builder initialized with the values of this {@code Destination}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Destination}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirInteger index;
            private Coding profile;
            private FhirUrl url;

            private Builder() {
            }

            private Builder(Destination original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.index = original.index();
                this.profile = original.profile();
                this.url = original.url();
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
             * Sets {@code index}.
             *
             * @param index the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder index(FhirInteger index) {
                this.index = index;
                return this;
            }

            /**
             * Sets {@code index}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param index the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder index(Integer index) {
                return index(index == null ? null : FhirInteger.of(index));
            }

            /**
             * Sets {@code profile}.
             *
             * @param profile the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder profile(Coding profile) {
                this.profile = profile;
                return this;
            }

            /**
             * Sets {@code url}.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(FhirUrl url) {
                this.url = url;
                return this;
            }

            /**
             * Sets {@code url}, wrapped in a {@link FhirUrl} without id or extensions.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(String url) {
                return url(url == null ? null : FhirUrl.of(url));
            }

            /**
             * Builds the {@code Destination}.
             *
             * @return the {@code Destination}
             * @throws NullPointerException if a required element is absent
             */
            public Destination build() {
                return new Destination(
                        id, extension, modifierExtension, index, profile, url);
            }
        }
    }

    /**
     * The required capability must exist and are assumed to function correctly on the FHIR server being tested.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param link Links to the FHIR specification.
     * @param capability Capabilities that are assumed to function correctly on the FHIR server being tested.
     *   Required.
     */
    public record Metadata(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Link> link,
            List<Capability> capability) implements BackboneElement {

        /**
         * Creates a {@code Metadata}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Metadata {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            link = link == null ? List.of() : List.copyOf(link);
            capability = capability == null ? List.of() : List.copyOf(capability);
            if (capability.isEmpty()) {
                throw new IllegalArgumentException("TestScript.metadata.capability requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Metadata}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A link to the FHIR specification that this test is covering.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param url URL to the specification. Required.
         * @param description Short description.
         */
        public record Link(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirUri url,
                FhirString description) implements BackboneElement {

            /**
             * Creates a {@code Link}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Link {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(url, "TestScript.metadata.link.url is required");
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
             * Returns a builder initialized with the values of this {@code Link}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Link}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirUri url;
                private FhirString description;

                private Builder() {
                }

                private Builder(Link original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.url = original.url();
                    this.description = original.description();
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
                 * Builds the {@code Link}.
                 *
                 * @return the {@code Link}
                 * @throws NullPointerException if a required element is absent
                 */
                public Link build() {
                    return new Link(
                            id, extension, modifierExtension, url, description);
                }
            }
        }

        /**
         * Capabilities that must exist and are assumed to function correctly on the FHIR server being tested.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param required Are the capabilities required?. Required.
         * @param validated Are the capabilities validated?. Required.
         * @param description The expected capabilities of the server.
         * @param origin Which origin server these requirements apply to.
         * @param destination Which server these requirements apply to.
         * @param link Links to the FHIR specification.
         * @param capabilities Required Capability Statement. Canonical reference to CapabilityStatement. Required.
         */
        public record Capability(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirBoolean required,
                FhirBoolean validated,
                FhirString description,
                List<FhirInteger> origin,
                FhirInteger destination,
                List<FhirUri> link,
                FhirCanonical capabilities) implements BackboneElement {

            /**
             * Creates a {@code Capability}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Capability {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                origin = origin == null ? List.of() : List.copyOf(origin);
                link = link == null ? List.of() : List.copyOf(link);
                Objects.requireNonNull(required, "TestScript.metadata.capability.required is required");
                Objects.requireNonNull(validated, "TestScript.metadata.capability.validated is required");
                Objects.requireNonNull(capabilities, "TestScript.metadata.capability.capabilities is required");
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
             * Returns a builder initialized with the values of this {@code Capability}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Capability}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirBoolean required;
                private FhirBoolean validated;
                private FhirString description;
                private List<FhirInteger> origin = new ArrayList<>();
                private FhirInteger destination;
                private List<FhirUri> link = new ArrayList<>();
                private FhirCanonical capabilities;

                private Builder() {
                }

                private Builder(Capability original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.required = original.required();
                    this.validated = original.validated();
                    this.description = original.description();
                    this.origin = new ArrayList<>(original.origin());
                    this.destination = original.destination();
                    this.link = new ArrayList<>(original.link());
                    this.capabilities = original.capabilities();
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
                 * Sets {@code required}.
                 *
                 * @param required the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder required(FhirBoolean required) {
                    this.required = required;
                    return this;
                }

                /**
                 * Sets {@code required}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param required the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder required(Boolean required) {
                    return required(required == null ? null : FhirBoolean.of(required));
                }

                /**
                 * Sets {@code validated}.
                 *
                 * @param validated the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder validated(FhirBoolean validated) {
                    this.validated = validated;
                    return this;
                }

                /**
                 * Sets {@code validated}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param validated the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder validated(Boolean validated) {
                    return validated(validated == null ? null : FhirBoolean.of(validated));
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
                 * Replaces all {@code origin} values.
                 *
                 * @param origin the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder origin(List<FhirInteger> origin) {
                    this.origin = origin == null ? new ArrayList<>() : new ArrayList<>(origin);
                    return this;
                }

                /**
                 * Adds a {@code origin} value.
                 *
                 * @param origin the value to add
                 * @return this builder
                 */
                public Builder addOrigin(FhirInteger origin) {
                    this.origin.add(Objects.requireNonNull(origin, "origin"));
                    return this;
                }

                /**
                 * Adds a {@code origin} value, wrapped in a {@link FhirInteger} without id or extensions.
                 *
                 * @param origin the value to add
                 * @return this builder
                 */
                public Builder addOrigin(Integer origin) {
                    return addOrigin(FhirInteger.of(origin));
                }

                /**
                 * Sets {@code destination}.
                 *
                 * @param destination the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder destination(FhirInteger destination) {
                    this.destination = destination;
                    return this;
                }

                /**
                 * Sets {@code destination}, wrapped in a {@link FhirInteger} without id or extensions.
                 *
                 * @param destination the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder destination(Integer destination) {
                    return destination(destination == null ? null : FhirInteger.of(destination));
                }

                /**
                 * Replaces all {@code link} values.
                 *
                 * @param link the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder link(List<FhirUri> link) {
                    this.link = link == null ? new ArrayList<>() : new ArrayList<>(link);
                    return this;
                }

                /**
                 * Adds a {@code link} value.
                 *
                 * @param link the value to add
                 * @return this builder
                 */
                public Builder addLink(FhirUri link) {
                    this.link.add(Objects.requireNonNull(link, "link"));
                    return this;
                }

                /**
                 * Adds a {@code link} value, wrapped in a {@link FhirUri} without id or extensions.
                 *
                 * @param link the value to add
                 * @return this builder
                 */
                public Builder addLink(String link) {
                    return addLink(FhirUri.of(link));
                }

                /**
                 * Sets {@code capabilities}.
                 *
                 * @param capabilities the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder capabilities(FhirCanonical capabilities) {
                    this.capabilities = capabilities;
                    return this;
                }

                /**
                 * Sets {@code capabilities}, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param capabilities the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder capabilities(String capabilities) {
                    return capabilities(capabilities == null ? null : FhirCanonical.of(capabilities));
                }

                /**
                 * Builds the {@code Capability}.
                 *
                 * @return the {@code Capability}
                 * @throws NullPointerException if a required element is absent
                 */
                public Capability build() {
                    return new Capability(
                            id, extension, modifierExtension, required, validated, description, origin, destination,
                            link, capabilities);
                }
            }
        }

        /** Builder for {@link Metadata}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Link> link = new ArrayList<>();
            private List<Capability> capability = new ArrayList<>();

            private Builder() {
            }

            private Builder(Metadata original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.link = new ArrayList<>(original.link());
                this.capability = new ArrayList<>(original.capability());
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
             * Replaces all {@code link} values.
             *
             * @param link the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder link(List<Link> link) {
                this.link = link == null ? new ArrayList<>() : new ArrayList<>(link);
                return this;
            }

            /**
             * Adds a {@code link} value.
             *
             * @param link the value to add
             * @return this builder
             */
            public Builder addLink(Link link) {
                this.link.add(Objects.requireNonNull(link, "link"));
                return this;
            }

            /**
             * Replaces all {@code capability} values.
             *
             * @param capability the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder capability(List<Capability> capability) {
                this.capability = capability == null ? new ArrayList<>() : new ArrayList<>(capability);
                return this;
            }

            /**
             * Adds a {@code capability} value.
             *
             * @param capability the value to add
             * @return this builder
             */
            public Builder addCapability(Capability capability) {
                this.capability.add(Objects.requireNonNull(capability, "capability"));
                return this;
            }

            /**
             * Builds the {@code Metadata}.
             *
             * @return the {@code Metadata}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Metadata build() {
                return new Metadata(
                        id, extension, modifierExtension, link, capability);
            }
        }
    }

    /**
     * The scope indicates a conformance artifact that is tested by the test(s) within this test case and the
     * expectation of the test outcome(s) as well as the intended test phase inclusion.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param artifact The specific conformance artifact being tested. Canonical reference to Resource. Required.
     * @param conformance required | optional | strict.
     * @param phase unit | integration | production.
     */
    public record Scope(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCanonical artifact,
            CodeableConcept conformance,
            CodeableConcept phase) implements BackboneElement {

        /**
         * Creates a {@code Scope}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Scope {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(artifact, "TestScript.scope.artifact is required");
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
         * Returns a builder initialized with the values of this {@code Scope}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Scope}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCanonical artifact;
            private CodeableConcept conformance;
            private CodeableConcept phase;

            private Builder() {
            }

            private Builder(Scope original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.artifact = original.artifact();
                this.conformance = original.conformance();
                this.phase = original.phase();
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
             * Sets {@code artifact}.
             *
             * @param artifact the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder artifact(FhirCanonical artifact) {
                this.artifact = artifact;
                return this;
            }

            /**
             * Sets {@code artifact}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param artifact the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder artifact(String artifact) {
                return artifact(artifact == null ? null : FhirCanonical.of(artifact));
            }

            /**
             * Sets {@code conformance}.
             *
             * @param conformance the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder conformance(CodeableConcept conformance) {
                this.conformance = conformance;
                return this;
            }

            /**
             * Sets {@code phase}.
             *
             * @param phase the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder phase(CodeableConcept phase) {
                this.phase = phase;
                return this;
            }

            /**
             * Builds the {@code Scope}.
             *
             * @return the {@code Scope}
             * @throws NullPointerException if a required element is absent
             */
            public Scope build() {
                return new Scope(
                        id, extension, modifierExtension, artifact, conformance, phase);
            }
        }
    }

    /**
     * Fixture in the test script - by reference (uri).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param autocreate Whether or not to implicitly create the fixture during setup. Required.
     * @param autodelete Whether or not to implicitly delete the fixture during teardown. Required.
     * @param resource Reference of the resource. Reference to Resource.
     */
    public record Fixture(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirBoolean autocreate,
            FhirBoolean autodelete,
            Reference resource) implements BackboneElement {

        /**
         * Creates a {@code Fixture}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Fixture {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(autocreate, "TestScript.fixture.autocreate is required");
            Objects.requireNonNull(autodelete, "TestScript.fixture.autodelete is required");
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
         * Returns a builder initialized with the values of this {@code Fixture}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Fixture}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirBoolean autocreate;
            private FhirBoolean autodelete;
            private Reference resource;

            private Builder() {
            }

            private Builder(Fixture original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.autocreate = original.autocreate();
                this.autodelete = original.autodelete();
                this.resource = original.resource();
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
             * Sets {@code autocreate}.
             *
             * @param autocreate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder autocreate(FhirBoolean autocreate) {
                this.autocreate = autocreate;
                return this;
            }

            /**
             * Sets {@code autocreate}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param autocreate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder autocreate(Boolean autocreate) {
                return autocreate(autocreate == null ? null : FhirBoolean.of(autocreate));
            }

            /**
             * Sets {@code autodelete}.
             *
             * @param autodelete the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder autodelete(FhirBoolean autodelete) {
                this.autodelete = autodelete;
                return this;
            }

            /**
             * Sets {@code autodelete}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param autodelete the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder autodelete(Boolean autodelete) {
                return autodelete(autodelete == null ? null : FhirBoolean.of(autodelete));
            }

            /**
             * Sets {@code resource}.
             *
             * @param resource the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder resource(Reference resource) {
                this.resource = resource;
                return this;
            }

            /**
             * Builds the {@code Fixture}.
             *
             * @return the {@code Fixture}
             * @throws NullPointerException if a required element is absent
             */
            public Fixture build() {
                return new Fixture(
                        id, extension, modifierExtension, autocreate, autodelete, resource);
            }
        }
    }

    /**
     * Variable is set based either on element value in response body or on header field value in the response
     * headers.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Descriptive name for this variable. Required.
     * @param defaultValue Default, hard-coded, or user-defined value for this variable.
     * @param description Natural language description of the variable.
     * @param expression The FHIRPath expression against the fixture body.
     * @param headerField HTTP header field name for source.
     * @param hint Hint help text for default value to enter.
     * @param path XPath or JSONPath against the fixture body.
     * @param sourceId Fixture Id of source expression or headerField within this variable.
     */
    public record Variable(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString name,
            FhirString defaultValue,
            FhirString description,
            FhirString expression,
            FhirString headerField,
            FhirString hint,
            FhirString path,
            FhirId sourceId) implements BackboneElement {

        /**
         * Creates a {@code Variable}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Variable {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(name, "TestScript.variable.name is required");
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
         * Returns a builder initialized with the values of this {@code Variable}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Variable}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString name;
            private FhirString defaultValue;
            private FhirString description;
            private FhirString expression;
            private FhirString headerField;
            private FhirString hint;
            private FhirString path;
            private FhirId sourceId;

            private Builder() {
            }

            private Builder(Variable original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.name = original.name();
                this.defaultValue = original.defaultValue();
                this.description = original.description();
                this.expression = original.expression();
                this.headerField = original.headerField();
                this.hint = original.hint();
                this.path = original.path();
                this.sourceId = original.sourceId();
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
             * Sets {@code defaultValue}.
             *
             * @param defaultValue the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder defaultValue(FhirString defaultValue) {
                this.defaultValue = defaultValue;
                return this;
            }

            /**
             * Sets {@code defaultValue}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param defaultValue the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder defaultValue(String defaultValue) {
                return defaultValue(defaultValue == null ? null : FhirString.of(defaultValue));
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
             * Sets {@code headerField}.
             *
             * @param headerField the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder headerField(FhirString headerField) {
                this.headerField = headerField;
                return this;
            }

            /**
             * Sets {@code headerField}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param headerField the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder headerField(String headerField) {
                return headerField(headerField == null ? null : FhirString.of(headerField));
            }

            /**
             * Sets {@code hint}.
             *
             * @param hint the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder hint(FhirString hint) {
                this.hint = hint;
                return this;
            }

            /**
             * Sets {@code hint}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param hint the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder hint(String hint) {
                return hint(hint == null ? null : FhirString.of(hint));
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
             * Sets {@code sourceId}.
             *
             * @param sourceId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sourceId(FhirId sourceId) {
                this.sourceId = sourceId;
                return this;
            }

            /**
             * Sets {@code sourceId}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param sourceId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sourceId(String sourceId) {
                return sourceId(sourceId == null ? null : FhirId.of(sourceId));
            }

            /**
             * Builds the {@code Variable}.
             *
             * @return the {@code Variable}
             * @throws NullPointerException if a required element is absent
             */
            public Variable build() {
                return new Variable(
                        id, extension, modifierExtension, name, defaultValue, description, expression, headerField,
                        hint, path, sourceId);
            }
        }
    }

    /**
     * A series of required setup operations before tests are executed.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param action A setup operation or assert to perform. Required.
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
                throw new IllegalArgumentException("TestScript.setup.action requires at least one value");
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
         * @param operation The setup operation to perform.
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
             * The operation to perform.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param type The operation code type that will be executed.
             * @param resource Resource type.
             * @param label Tracking/logging operation label.
             * @param description Tracking/reporting operation description.
             * @param accept Mime type to accept in the payload of the response, with charset etc.
             * @param contentType Mime type of the request payload contents, with charset etc.
             * @param destination Server responding to the request.
             * @param encodeRequestUrl Whether or not to send the request url in encoded format. Required.
             * @param method delete | get | options | patch | post | put | head.
             * @param origin Server initiating the request.
             * @param params Explicitly defined path parameters.
             * @param requestHeader Each operation can have one or more header elements.
             * @param requestId Fixture Id of mapped request.
             * @param responseId Fixture Id of mapped response.
             * @param sourceId Fixture Id of body for PUT and POST requests.
             * @param targetId Id of fixture used for extracting the [id], [type], and [vid] for GET requests.
             * @param url Request URL.
             */
            public record Operation(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    Coding type,
                    FhirUri resource,
                    FhirString label,
                    FhirString description,
                    FhirCode accept,
                    FhirCode contentType,
                    FhirInteger destination,
                    FhirBoolean encodeRequestUrl,
                    FhirEnum<TestScriptRequestMethodCode> method,
                    FhirInteger origin,
                    FhirString params,
                    List<RequestHeader> requestHeader,
                    FhirId requestId,
                    FhirId responseId,
                    FhirId sourceId,
                    FhirId targetId,
                    FhirString url) implements BackboneElement {

                /**
                 * Creates an {@code Operation}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public Operation {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    requestHeader = requestHeader == null ? List.of() : List.copyOf(requestHeader);
                    Objects.requireNonNull(
                            encodeRequestUrl, "TestScript.setup.action.operation.encodeRequestUrl is required");
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

                /**
                 * Header elements would be used to set HTTP headers.
                 *
                 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
                 * Instances are usually created with {@link #builder()}.
                 *
                 * @param id Unique id for inter-element referencing.
                 * @param extension Additional content defined by implementations.
                 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
                 * @param field HTTP header field name. Required.
                 * @param value HTTP headerfield value. Required.
                 */
                public record RequestHeader(
                        String id,
                        List<Extension> extension,
                        List<Extension> modifierExtension,
                        FhirString field,
                        FhirString value) implements BackboneElement {

                    /**
                     * Creates a {@code RequestHeader}, copying all lists.
                     *
                     * @throws NullPointerException if a required element is absent or a list contains {@code null}
                     */
                    public RequestHeader {
                        extension = extension == null ? List.of() : List.copyOf(extension);
                        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                        Objects.requireNonNull(
                                field, "TestScript.setup.action.operation.requestHeader.field is required");
                        Objects.requireNonNull(
                                value, "TestScript.setup.action.operation.requestHeader.value is required");
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
                     * Returns a builder initialized with the values of this {@code RequestHeader}.
                     *
                     * @return the builder
                     */
                    public Builder toBuilder() {
                        return new Builder(this);
                    }

                    /** Builder for {@link RequestHeader}. Builders are mutable and not thread-safe. */
                    public static final class Builder {

                        private String id;
                        private List<Extension> extension = new ArrayList<>();
                        private List<Extension> modifierExtension = new ArrayList<>();
                        private FhirString field;
                        private FhirString value;

                        private Builder() {
                        }

                        private Builder(RequestHeader original) {
                            this.id = original.id();
                            this.extension = new ArrayList<>(original.extension());
                            this.modifierExtension = new ArrayList<>(original.modifierExtension());
                            this.field = original.field();
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
                         * Sets {@code field}.
                         *
                         * @param field the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder field(FhirString field) {
                            this.field = field;
                            return this;
                        }

                        /**
                         * Sets {@code field}, wrapped in a {@link FhirString} without id or extensions.
                         *
                         * @param field the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder field(String field) {
                            return field(field == null ? null : FhirString.of(field));
                        }

                        /**
                         * Sets {@code value}.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirString value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value}, wrapped in a {@link FhirString} without id or extensions.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(String value) {
                            return value(value == null ? null : FhirString.of(value));
                        }

                        /**
                         * Builds the {@code RequestHeader}.
                         *
                         * @return the {@code RequestHeader}
                         * @throws NullPointerException if a required element is absent
                         */
                        public RequestHeader build() {
                            return new RequestHeader(
                                    id, extension, modifierExtension, field, value);
                        }
                    }
                }

                /** Builder for {@link Operation}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private Coding type;
                    private FhirUri resource;
                    private FhirString label;
                    private FhirString description;
                    private FhirCode accept;
                    private FhirCode contentType;
                    private FhirInteger destination;
                    private FhirBoolean encodeRequestUrl;
                    private FhirEnum<TestScriptRequestMethodCode> method;
                    private FhirInteger origin;
                    private FhirString params;
                    private List<RequestHeader> requestHeader = new ArrayList<>();
                    private FhirId requestId;
                    private FhirId responseId;
                    private FhirId sourceId;
                    private FhirId targetId;
                    private FhirString url;

                    private Builder() {
                    }

                    private Builder(Operation original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.type = original.type();
                        this.resource = original.resource();
                        this.label = original.label();
                        this.description = original.description();
                        this.accept = original.accept();
                        this.contentType = original.contentType();
                        this.destination = original.destination();
                        this.encodeRequestUrl = original.encodeRequestUrl();
                        this.method = original.method();
                        this.origin = original.origin();
                        this.params = original.params();
                        this.requestHeader = new ArrayList<>(original.requestHeader());
                        this.requestId = original.requestId();
                        this.responseId = original.responseId();
                        this.sourceId = original.sourceId();
                        this.targetId = original.targetId();
                        this.url = original.url();
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
                     * Sets {@code resource}.
                     *
                     * @param resource the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder resource(FhirUri resource) {
                        this.resource = resource;
                        return this;
                    }

                    /**
                     * Sets {@code resource}, wrapped in a {@link FhirUri} without id or extensions.
                     *
                     * @param resource the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder resource(String resource) {
                        return resource(resource == null ? null : FhirUri.of(resource));
                    }

                    /**
                     * Sets {@code label}.
                     *
                     * @param label the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder label(FhirString label) {
                        this.label = label;
                        return this;
                    }

                    /**
                     * Sets {@code label}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param label the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder label(String label) {
                        return label(label == null ? null : FhirString.of(label));
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
                     * Sets {@code accept}.
                     *
                     * @param accept the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder accept(FhirCode accept) {
                        this.accept = accept;
                        return this;
                    }

                    /**
                     * Sets {@code accept}, wrapped in a {@link FhirCode} without id or extensions.
                     *
                     * @param accept the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder accept(String accept) {
                        return accept(accept == null ? null : FhirCode.of(accept));
                    }

                    /**
                     * Sets {@code contentType}.
                     *
                     * @param contentType the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder contentType(FhirCode contentType) {
                        this.contentType = contentType;
                        return this;
                    }

                    /**
                     * Sets {@code contentType}, wrapped in a {@link FhirCode} without id or extensions.
                     *
                     * @param contentType the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder contentType(String contentType) {
                        return contentType(contentType == null ? null : FhirCode.of(contentType));
                    }

                    /**
                     * Sets {@code destination}.
                     *
                     * @param destination the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder destination(FhirInteger destination) {
                        this.destination = destination;
                        return this;
                    }

                    /**
                     * Sets {@code destination}, wrapped in a {@link FhirInteger} without id or extensions.
                     *
                     * @param destination the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder destination(Integer destination) {
                        return destination(destination == null ? null : FhirInteger.of(destination));
                    }

                    /**
                     * Sets {@code encodeRequestUrl}.
                     *
                     * @param encodeRequestUrl the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder encodeRequestUrl(FhirBoolean encodeRequestUrl) {
                        this.encodeRequestUrl = encodeRequestUrl;
                        return this;
                    }

                    /**
                     * Sets {@code encodeRequestUrl}, wrapped in a {@link FhirBoolean} without id or extensions.
                     *
                     * @param encodeRequestUrl the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder encodeRequestUrl(Boolean encodeRequestUrl) {
                        return encodeRequestUrl(encodeRequestUrl == null ? null : FhirBoolean.of(encodeRequestUrl));
                    }

                    /**
                     * Sets {@code method}.
                     *
                     * @param method the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder method(FhirEnum<TestScriptRequestMethodCode> method) {
                        this.method = method;
                        return this;
                    }

                    /**
                     * Sets {@code method}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param method the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder method(TestScriptRequestMethodCode method) {
                        return method(method == null ? null : FhirEnum.of(method));
                    }

                    /**
                     * Sets {@code origin}.
                     *
                     * @param origin the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder origin(FhirInteger origin) {
                        this.origin = origin;
                        return this;
                    }

                    /**
                     * Sets {@code origin}, wrapped in a {@link FhirInteger} without id or extensions.
                     *
                     * @param origin the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder origin(Integer origin) {
                        return origin(origin == null ? null : FhirInteger.of(origin));
                    }

                    /**
                     * Sets {@code params}.
                     *
                     * @param params the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder params(FhirString params) {
                        this.params = params;
                        return this;
                    }

                    /**
                     * Sets {@code params}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param params the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder params(String params) {
                        return params(params == null ? null : FhirString.of(params));
                    }

                    /**
                     * Replaces all {@code requestHeader} values.
                     *
                     * @param requestHeader the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder requestHeader(List<RequestHeader> requestHeader) {
                        this.requestHeader = requestHeader == null
                                ? new ArrayList<>()
                                : new ArrayList<>(requestHeader);
                        return this;
                    }

                    /**
                     * Adds a {@code requestHeader} value.
                     *
                     * @param requestHeader the value to add
                     * @return this builder
                     */
                    public Builder addRequestHeader(RequestHeader requestHeader) {
                        this.requestHeader.add(Objects.requireNonNull(requestHeader, "requestHeader"));
                        return this;
                    }

                    /**
                     * Sets {@code requestId}.
                     *
                     * @param requestId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder requestId(FhirId requestId) {
                        this.requestId = requestId;
                        return this;
                    }

                    /**
                     * Sets {@code requestId}, wrapped in a {@link FhirId} without id or extensions.
                     *
                     * @param requestId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder requestId(String requestId) {
                        return requestId(requestId == null ? null : FhirId.of(requestId));
                    }

                    /**
                     * Sets {@code responseId}.
                     *
                     * @param responseId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder responseId(FhirId responseId) {
                        this.responseId = responseId;
                        return this;
                    }

                    /**
                     * Sets {@code responseId}, wrapped in a {@link FhirId} without id or extensions.
                     *
                     * @param responseId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder responseId(String responseId) {
                        return responseId(responseId == null ? null : FhirId.of(responseId));
                    }

                    /**
                     * Sets {@code sourceId}.
                     *
                     * @param sourceId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder sourceId(FhirId sourceId) {
                        this.sourceId = sourceId;
                        return this;
                    }

                    /**
                     * Sets {@code sourceId}, wrapped in a {@link FhirId} without id or extensions.
                     *
                     * @param sourceId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder sourceId(String sourceId) {
                        return sourceId(sourceId == null ? null : FhirId.of(sourceId));
                    }

                    /**
                     * Sets {@code targetId}.
                     *
                     * @param targetId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder targetId(FhirId targetId) {
                        this.targetId = targetId;
                        return this;
                    }

                    /**
                     * Sets {@code targetId}, wrapped in a {@link FhirId} without id or extensions.
                     *
                     * @param targetId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder targetId(String targetId) {
                        return targetId(targetId == null ? null : FhirId.of(targetId));
                    }

                    /**
                     * Sets {@code url}.
                     *
                     * @param url the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder url(FhirString url) {
                        this.url = url;
                        return this;
                    }

                    /**
                     * Sets {@code url}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param url the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder url(String url) {
                        return url(url == null ? null : FhirString.of(url));
                    }

                    /**
                     * Builds the {@code Operation}.
                     *
                     * @return the {@code Operation}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Operation build() {
                        return new Operation(
                                id, extension, modifierExtension, type, resource, label, description, accept,
                                contentType, destination, encodeRequestUrl, method, origin, params, requestHeader,
                                requestId, responseId, sourceId, targetId, url);
                    }
                }
            }

            /**
             * Evaluates the results of previous operations to determine if the server under test behaves
             * appropriately.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param label Tracking/logging assertion label.
             * @param description Tracking/reporting assertion description.
             * @param direction response | request.
             * @param compareToSourceId Id of the source fixture to be evaluated.
             * @param compareToSourceExpression The FHIRPath expression to evaluate against the source fixture.
             * @param compareToSourcePath XPath or JSONPath expression to evaluate against the source fixture.
             * @param contentType Mime type to compare against the 'Content-Type' header.
             * @param defaultManualCompletion fail | pass | skip | stop.
             * @param expression The FHIRPath expression to be evaluated.
             * @param headerField HTTP header field name.
             * @param minimumId Fixture Id of minimum content resource.
             * @param navigationLinks Perform validation on navigation links?.
             * @param operator equals | notEquals | in | notIn | greaterThan | lessThan | empty | notEmpty | contains
             *   | notContains | eval | manualEval.
             * @param path XPath or JSONPath expression.
             * @param requestMethod delete | get | options | patch | post | put | head.
             * @param requestURL Request URL comparison value.
             * @param resource Resource type.
             * @param response continue | switchingProtocols | okay | created | accepted | nonAuthoritativeInformation
             *   | noContent | resetContent | partialContent | multipleChoices | movedPermanently | found | seeOther |
             *   notModified | useProxy | temporaryRedirect | permanentRedirect | badRequest | unauthorized |
             *   paymentRequired | forbidden | notFound | methodNotAllowed | notAcceptable |
             *   proxyAuthenticationRequired | requestTimeout | conflict | gone | lengthRequired | preconditionFailed
             *   | contentTooLarge | uriTooLong | unsupportedMediaType | rangeNotSatisfiable | expectationFailed |
             *   misdirectedRequest | unprocessableContent | upgradeRequired | internalServerError | notImplemented |
             *   badGateway | serviceUnavailable | gatewayTimeout | httpVersionNotSupported.
             * @param responseCode HTTP response code to test.
             * @param sourceId Fixture Id of source expression or headerField.
             * @param stopTestOnFail If this assert fails, will the current test execution stop?. Required.
             * @param validateProfileId Profile Id of validation profile reference.
             * @param value The value to compare to.
             * @param warningOnly Will this assert produce a warning only on error?. Required.
             * @param requirement Links or references to the testing requirements.
             */
            public record AssertValue(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirString label,
                    FhirString description,
                    FhirEnum<AssertionDirectionType> direction,
                    FhirString compareToSourceId,
                    FhirString compareToSourceExpression,
                    FhirString compareToSourcePath,
                    FhirCode contentType,
                    FhirEnum<AssertionManualCompletionType> defaultManualCompletion,
                    FhirString expression,
                    FhirString headerField,
                    FhirString minimumId,
                    FhirBoolean navigationLinks,
                    FhirEnum<AssertionOperatorType> operator,
                    FhirString path,
                    FhirEnum<TestScriptRequestMethodCode> requestMethod,
                    FhirString requestURL,
                    FhirUri resource,
                    FhirEnum<AssertionResponseTypes> response,
                    FhirString responseCode,
                    FhirId sourceId,
                    FhirBoolean stopTestOnFail,
                    FhirId validateProfileId,
                    FhirString value,
                    FhirBoolean warningOnly,
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
                    Objects.requireNonNull(
                            stopTestOnFail, "TestScript.setup.action.assert.stopTestOnFail is required");
                    Objects.requireNonNull(warningOnly, "TestScript.setup.action.assert.warningOnly is required");
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
                                    "TestScript.setup.action.assert.requirement.link[x] does not allow "
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
                    private FhirString label;
                    private FhirString description;
                    private FhirEnum<AssertionDirectionType> direction;
                    private FhirString compareToSourceId;
                    private FhirString compareToSourceExpression;
                    private FhirString compareToSourcePath;
                    private FhirCode contentType;
                    private FhirEnum<AssertionManualCompletionType> defaultManualCompletion;
                    private FhirString expression;
                    private FhirString headerField;
                    private FhirString minimumId;
                    private FhirBoolean navigationLinks;
                    private FhirEnum<AssertionOperatorType> operator;
                    private FhirString path;
                    private FhirEnum<TestScriptRequestMethodCode> requestMethod;
                    private FhirString requestURL;
                    private FhirUri resource;
                    private FhirEnum<AssertionResponseTypes> response;
                    private FhirString responseCode;
                    private FhirId sourceId;
                    private FhirBoolean stopTestOnFail;
                    private FhirId validateProfileId;
                    private FhirString value;
                    private FhirBoolean warningOnly;
                    private List<Requirement> requirement = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(AssertValue original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.label = original.label();
                        this.description = original.description();
                        this.direction = original.direction();
                        this.compareToSourceId = original.compareToSourceId();
                        this.compareToSourceExpression = original.compareToSourceExpression();
                        this.compareToSourcePath = original.compareToSourcePath();
                        this.contentType = original.contentType();
                        this.defaultManualCompletion = original.defaultManualCompletion();
                        this.expression = original.expression();
                        this.headerField = original.headerField();
                        this.minimumId = original.minimumId();
                        this.navigationLinks = original.navigationLinks();
                        this.operator = original.operator();
                        this.path = original.path();
                        this.requestMethod = original.requestMethod();
                        this.requestURL = original.requestURL();
                        this.resource = original.resource();
                        this.response = original.response();
                        this.responseCode = original.responseCode();
                        this.sourceId = original.sourceId();
                        this.stopTestOnFail = original.stopTestOnFail();
                        this.validateProfileId = original.validateProfileId();
                        this.value = original.value();
                        this.warningOnly = original.warningOnly();
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
                     * Sets {@code label}.
                     *
                     * @param label the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder label(FhirString label) {
                        this.label = label;
                        return this;
                    }

                    /**
                     * Sets {@code label}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param label the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder label(String label) {
                        return label(label == null ? null : FhirString.of(label));
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
                     * Sets {@code direction}.
                     *
                     * @param direction the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder direction(FhirEnum<AssertionDirectionType> direction) {
                        this.direction = direction;
                        return this;
                    }

                    /**
                     * Sets {@code direction}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param direction the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder direction(AssertionDirectionType direction) {
                        return direction(direction == null ? null : FhirEnum.of(direction));
                    }

                    /**
                     * Sets {@code compareToSourceId}.
                     *
                     * @param compareToSourceId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder compareToSourceId(FhirString compareToSourceId) {
                        this.compareToSourceId = compareToSourceId;
                        return this;
                    }

                    /**
                     * Sets {@code compareToSourceId}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param compareToSourceId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder compareToSourceId(String compareToSourceId) {
                        return compareToSourceId(compareToSourceId == null ? null : FhirString.of(compareToSourceId));
                    }

                    /**
                     * Sets {@code compareToSourceExpression}.
                     *
                     * @param compareToSourceExpression the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder compareToSourceExpression(FhirString compareToSourceExpression) {
                        this.compareToSourceExpression = compareToSourceExpression;
                        return this;
                    }

                    /**
                     * Sets {@code compareToSourceExpression}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param compareToSourceExpression the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder compareToSourceExpression(String compareToSourceExpression) {
                        return compareToSourceExpression(
                                compareToSourceExpression == null ? null : FhirString.of(compareToSourceExpression));
                    }

                    /**
                     * Sets {@code compareToSourcePath}.
                     *
                     * @param compareToSourcePath the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder compareToSourcePath(FhirString compareToSourcePath) {
                        this.compareToSourcePath = compareToSourcePath;
                        return this;
                    }

                    /**
                     * Sets {@code compareToSourcePath}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param compareToSourcePath the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder compareToSourcePath(String compareToSourcePath) {
                        return compareToSourcePath(
                                compareToSourcePath == null ? null : FhirString.of(compareToSourcePath));
                    }

                    /**
                     * Sets {@code contentType}.
                     *
                     * @param contentType the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder contentType(FhirCode contentType) {
                        this.contentType = contentType;
                        return this;
                    }

                    /**
                     * Sets {@code contentType}, wrapped in a {@link FhirCode} without id or extensions.
                     *
                     * @param contentType the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder contentType(String contentType) {
                        return contentType(contentType == null ? null : FhirCode.of(contentType));
                    }

                    /**
                     * Sets {@code defaultManualCompletion}.
                     *
                     * @param defaultManualCompletion the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder defaultManualCompletion(FhirEnum<AssertionManualCompletionType> defaultManualCompletion) {
                        this.defaultManualCompletion = defaultManualCompletion;
                        return this;
                    }

                    /**
                     * Sets {@code defaultManualCompletion}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param defaultManualCompletion the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder defaultManualCompletion(AssertionManualCompletionType defaultManualCompletion) {
                        return defaultManualCompletion(
                                defaultManualCompletion == null ? null : FhirEnum.of(defaultManualCompletion));
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
                     * Sets {@code headerField}.
                     *
                     * @param headerField the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder headerField(FhirString headerField) {
                        this.headerField = headerField;
                        return this;
                    }

                    /**
                     * Sets {@code headerField}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param headerField the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder headerField(String headerField) {
                        return headerField(headerField == null ? null : FhirString.of(headerField));
                    }

                    /**
                     * Sets {@code minimumId}.
                     *
                     * @param minimumId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder minimumId(FhirString minimumId) {
                        this.minimumId = minimumId;
                        return this;
                    }

                    /**
                     * Sets {@code minimumId}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param minimumId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder minimumId(String minimumId) {
                        return minimumId(minimumId == null ? null : FhirString.of(minimumId));
                    }

                    /**
                     * Sets {@code navigationLinks}.
                     *
                     * @param navigationLinks the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder navigationLinks(FhirBoolean navigationLinks) {
                        this.navigationLinks = navigationLinks;
                        return this;
                    }

                    /**
                     * Sets {@code navigationLinks}, wrapped in a {@link FhirBoolean} without id or extensions.
                     *
                     * @param navigationLinks the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder navigationLinks(Boolean navigationLinks) {
                        return navigationLinks(navigationLinks == null ? null : FhirBoolean.of(navigationLinks));
                    }

                    /**
                     * Sets {@code operator}.
                     *
                     * @param operator the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder operator(FhirEnum<AssertionOperatorType> operator) {
                        this.operator = operator;
                        return this;
                    }

                    /**
                     * Sets {@code operator}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param operator the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder operator(AssertionOperatorType operator) {
                        return operator(operator == null ? null : FhirEnum.of(operator));
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
                     * Sets {@code requestMethod}.
                     *
                     * @param requestMethod the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder requestMethod(FhirEnum<TestScriptRequestMethodCode> requestMethod) {
                        this.requestMethod = requestMethod;
                        return this;
                    }

                    /**
                     * Sets {@code requestMethod}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param requestMethod the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder requestMethod(TestScriptRequestMethodCode requestMethod) {
                        return requestMethod(requestMethod == null ? null : FhirEnum.of(requestMethod));
                    }

                    /**
                     * Sets {@code requestURL}.
                     *
                     * @param requestURL the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder requestURL(FhirString requestURL) {
                        this.requestURL = requestURL;
                        return this;
                    }

                    /**
                     * Sets {@code requestURL}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param requestURL the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder requestURL(String requestURL) {
                        return requestURL(requestURL == null ? null : FhirString.of(requestURL));
                    }

                    /**
                     * Sets {@code resource}.
                     *
                     * @param resource the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder resource(FhirUri resource) {
                        this.resource = resource;
                        return this;
                    }

                    /**
                     * Sets {@code resource}, wrapped in a {@link FhirUri} without id or extensions.
                     *
                     * @param resource the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder resource(String resource) {
                        return resource(resource == null ? null : FhirUri.of(resource));
                    }

                    /**
                     * Sets {@code response}.
                     *
                     * @param response the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder response(FhirEnum<AssertionResponseTypes> response) {
                        this.response = response;
                        return this;
                    }

                    /**
                     * Sets {@code response}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param response the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder response(AssertionResponseTypes response) {
                        return response(response == null ? null : FhirEnum.of(response));
                    }

                    /**
                     * Sets {@code responseCode}.
                     *
                     * @param responseCode the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder responseCode(FhirString responseCode) {
                        this.responseCode = responseCode;
                        return this;
                    }

                    /**
                     * Sets {@code responseCode}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param responseCode the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder responseCode(String responseCode) {
                        return responseCode(responseCode == null ? null : FhirString.of(responseCode));
                    }

                    /**
                     * Sets {@code sourceId}.
                     *
                     * @param sourceId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder sourceId(FhirId sourceId) {
                        this.sourceId = sourceId;
                        return this;
                    }

                    /**
                     * Sets {@code sourceId}, wrapped in a {@link FhirId} without id or extensions.
                     *
                     * @param sourceId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder sourceId(String sourceId) {
                        return sourceId(sourceId == null ? null : FhirId.of(sourceId));
                    }

                    /**
                     * Sets {@code stopTestOnFail}.
                     *
                     * @param stopTestOnFail the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder stopTestOnFail(FhirBoolean stopTestOnFail) {
                        this.stopTestOnFail = stopTestOnFail;
                        return this;
                    }

                    /**
                     * Sets {@code stopTestOnFail}, wrapped in a {@link FhirBoolean} without id or extensions.
                     *
                     * @param stopTestOnFail the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder stopTestOnFail(Boolean stopTestOnFail) {
                        return stopTestOnFail(stopTestOnFail == null ? null : FhirBoolean.of(stopTestOnFail));
                    }

                    /**
                     * Sets {@code validateProfileId}.
                     *
                     * @param validateProfileId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder validateProfileId(FhirId validateProfileId) {
                        this.validateProfileId = validateProfileId;
                        return this;
                    }

                    /**
                     * Sets {@code validateProfileId}, wrapped in a {@link FhirId} without id or extensions.
                     *
                     * @param validateProfileId the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder validateProfileId(String validateProfileId) {
                        return validateProfileId(validateProfileId == null ? null : FhirId.of(validateProfileId));
                    }

                    /**
                     * Sets {@code value}.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(FhirString value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(String value) {
                        return value(value == null ? null : FhirString.of(value));
                    }

                    /**
                     * Sets {@code warningOnly}.
                     *
                     * @param warningOnly the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder warningOnly(FhirBoolean warningOnly) {
                        this.warningOnly = warningOnly;
                        return this;
                    }

                    /**
                     * Sets {@code warningOnly}, wrapped in a {@link FhirBoolean} without id or extensions.
                     *
                     * @param warningOnly the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder warningOnly(Boolean warningOnly) {
                        return warningOnly(warningOnly == null ? null : FhirBoolean.of(warningOnly));
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
                                id, extension, modifierExtension, label, description, direction, compareToSourceId,
                                compareToSourceExpression, compareToSourcePath, contentType, defaultManualCompletion,
                                expression, headerField, minimumId, navigationLinks, operator, path, requestMethod,
                                requestURL, resource, response, responseCode, sourceId, stopTestOnFail,
                                validateProfileId, value, warningOnly, requirement);
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
     * A test in this script.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param name Tracking/logging name of this test.
     * @param description Tracking/reporting short description of the test.
     * @param action A test operation or assert to perform. Required.
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
                throw new IllegalArgumentException("TestScript.test.action requires at least one value");
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
         * @param operation The setup operation to perform.
         * @param assertValue The setup assertion to perform. The FHIR element {@code assert}.
         */
        public record TestAction(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                TestScript.Setup.SetupAction.Operation operation,
                TestScript.Setup.SetupAction.AssertValue assertValue) implements BackboneElement {

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
                private TestScript.Setup.SetupAction.Operation operation;
                private TestScript.Setup.SetupAction.AssertValue assertValue;

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
                public Builder operation(TestScript.Setup.SetupAction.Operation operation) {
                    this.operation = operation;
                    return this;
                }

                /**
                 * Sets {@code assertValue}.
                 *
                 * @param assertValue the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder assertValue(TestScript.Setup.SetupAction.AssertValue assertValue) {
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
     * A series of operations required to clean up after all the tests are executed (successfully or otherwise).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param action One or more teardown operations to perform. Required.
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
                throw new IllegalArgumentException("TestScript.teardown.action requires at least one value");
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
         * @param operation The teardown operation to perform. Required.
         */
        public record TeardownAction(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                TestScript.Setup.SetupAction.Operation operation) implements BackboneElement {

            /**
             * Creates a {@code TeardownAction}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public TeardownAction {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(operation, "TestScript.teardown.action.operation is required");
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
                private TestScript.Setup.SetupAction.Operation operation;

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
                public Builder operation(TestScript.Setup.SetupAction.Operation operation) {
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

    /** Builder for {@link TestScript}. Builders are mutable and not thread-safe. */
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
        private List<Origin> origin = new ArrayList<>();
        private List<Destination> destination = new ArrayList<>();
        private Metadata metadata;
        private List<Scope> scope = new ArrayList<>();
        private List<Fixture> fixture = new ArrayList<>();
        private List<FhirCanonical> profile = new ArrayList<>();
        private List<Variable> variable = new ArrayList<>();
        private Setup setup;
        private List<Test> test = new ArrayList<>();
        private Teardown teardown;

        private Builder() {
        }

        private Builder(TestScript original) {
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
            this.origin = new ArrayList<>(original.origin());
            this.destination = new ArrayList<>(original.destination());
            this.metadata = original.metadata();
            this.scope = new ArrayList<>(original.scope());
            this.fixture = new ArrayList<>(original.fixture());
            this.profile = new ArrayList<>(original.profile());
            this.variable = new ArrayList<>(original.variable());
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
         * Replaces all {@code origin} values.
         *
         * @param origin the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder origin(List<Origin> origin) {
            this.origin = origin == null ? new ArrayList<>() : new ArrayList<>(origin);
            return this;
        }

        /**
         * Adds a {@code origin} value.
         *
         * @param origin the value to add
         * @return this builder
         */
        public Builder addOrigin(Origin origin) {
            this.origin.add(Objects.requireNonNull(origin, "origin"));
            return this;
        }

        /**
         * Replaces all {@code destination} values.
         *
         * @param destination the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder destination(List<Destination> destination) {
            this.destination = destination == null ? new ArrayList<>() : new ArrayList<>(destination);
            return this;
        }

        /**
         * Adds a {@code destination} value.
         *
         * @param destination the value to add
         * @return this builder
         */
        public Builder addDestination(Destination destination) {
            this.destination.add(Objects.requireNonNull(destination, "destination"));
            return this;
        }

        /**
         * Sets {@code metadata}.
         *
         * @param metadata the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder metadata(Metadata metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Replaces all {@code scope} values.
         *
         * @param scope the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder scope(List<Scope> scope) {
            this.scope = scope == null ? new ArrayList<>() : new ArrayList<>(scope);
            return this;
        }

        /**
         * Adds a {@code scope} value.
         *
         * @param scope the value to add
         * @return this builder
         */
        public Builder addScope(Scope scope) {
            this.scope.add(Objects.requireNonNull(scope, "scope"));
            return this;
        }

        /**
         * Replaces all {@code fixture} values.
         *
         * @param fixture the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder fixture(List<Fixture> fixture) {
            this.fixture = fixture == null ? new ArrayList<>() : new ArrayList<>(fixture);
            return this;
        }

        /**
         * Adds a {@code fixture} value.
         *
         * @param fixture the value to add
         * @return this builder
         */
        public Builder addFixture(Fixture fixture) {
            this.fixture.add(Objects.requireNonNull(fixture, "fixture"));
            return this;
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
         * Replaces all {@code variable} values.
         *
         * @param variable the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder variable(List<Variable> variable) {
            this.variable = variable == null ? new ArrayList<>() : new ArrayList<>(variable);
            return this;
        }

        /**
         * Adds a {@code variable} value.
         *
         * @param variable the value to add
         * @return this builder
         */
        public Builder addVariable(Variable variable) {
            this.variable.add(Objects.requireNonNull(variable, "variable"));
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
         * Builds the {@code TestScript}.
         *
         * @return the {@code TestScript}
         * @throws NullPointerException if a required element is absent
         */
        public TestScript build() {
            return new TestScript(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, origin, destination,
                    metadata, scope, fixture, profile, variable, setup, test, teardown);
        }
    }
}
