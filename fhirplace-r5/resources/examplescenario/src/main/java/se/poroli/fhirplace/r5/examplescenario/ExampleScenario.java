package se.poroli.fhirplace.r5.examplescenario;

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
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.ExampleScenarioActorType;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A walkthrough of a workflow showing the interaction between systems and the instances shared, possibly including
 * the evolution of instances over time.
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
 * @param url Canonical identifier for this example scenario, represented as a URI (globally unique).
 * @param identifier Additional identifier for the example scenario.
 * @param version Business version of the example scenario.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name To be removed?.
 * @param title Name for this example scenario (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the ExampleScenario.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for example scenario (if applicable).
 * @param purpose The purpose of the example, e.g. to illustrate a scenario.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param actor Individual involved in exchange.
 * @param instance Data used in the scenario.
 * @param process Major process within scenario.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ExampleScenario">FHIR R5 ExampleScenario</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record ExampleScenario(
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
        List<Actor> actor,
        List<Instance> instance,
        List<Process> process) implements DomainResource {

    /**
     * Creates an {@code ExampleScenario}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ExampleScenario {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        actor = actor == null ? List.of() : List.copyOf(actor);
        instance = instance == null ? List.of() : List.copyOf(instance);
        process = process == null ? List.of() : List.copyOf(process);
        Objects.requireNonNull(status, "ExampleScenario.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "ExampleScenario.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code ExampleScenario}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A system or person who shares or receives an instance within the scenario.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param key ID or acronym of the actor. Required.
     * @param type person | system. Required.
     * @param title Label for actor when rendering. Required.
     * @param description Details about actor.
     */
    public record Actor(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString key,
            FhirEnum<ExampleScenarioActorType> type,
            FhirString title,
            FhirMarkdown description) implements BackboneElement {

        /**
         * Creates an {@code Actor}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Actor {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(key, "ExampleScenario.actor.key is required");
            Objects.requireNonNull(type, "ExampleScenario.actor.type is required");
            Objects.requireNonNull(title, "ExampleScenario.actor.title is required");
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
         * Returns a builder initialized with the values of this {@code Actor}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Actor}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString key;
            private FhirEnum<ExampleScenarioActorType> type;
            private FhirString title;
            private FhirMarkdown description;

            private Builder() {
            }

            private Builder(Actor original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.key = original.key();
                this.type = original.type();
                this.title = original.title();
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
             * Sets {@code key}.
             *
             * @param key the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder key(FhirString key) {
                this.key = key;
                return this;
            }

            /**
             * Sets {@code key}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param key the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder key(String key) {
                return key(key == null ? null : FhirString.of(key));
            }

            /**
             * Sets {@code type}.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(FhirEnum<ExampleScenarioActorType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(ExampleScenarioActorType type) {
                return type(type == null ? null : FhirEnum.of(type));
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
             * Builds the {@code Actor}.
             *
             * @return the {@code Actor}
             * @throws NullPointerException if a required element is absent
             */
            public Actor build() {
                return new Actor(
                        id, extension, modifierExtension, key, type, title, description);
            }
        }
    }

    /**
     * A single data collection that is shared as part of the scenario.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param key ID or acronym of the instance. Required.
     * @param structureType Data structure for example. Required.
     * @param structureVersion E.g. 4.0.1.
     * @param structureProfile Rules instance adheres to. One of canonical, uri.
     * @param title Label for instance. Required.
     * @param description Human-friendly description of the instance.
     * @param content Example instance data.
     * @param version Snapshot of instance that changes.
     * @param containedInstance Resources contained in the instance.
     */
    public record Instance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString key,
            Coding structureType,
            FhirString structureVersion,
            DataType structureProfile,
            FhirString title,
            FhirMarkdown description,
            Reference content,
            List<Version> version,
            List<ContainedInstance> containedInstance) implements BackboneElement {

        /**
         * Creates an {@code Instance}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Instance {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            version = version == null ? List.of() : List.copyOf(version);
            containedInstance = containedInstance == null ? List.of() : List.copyOf(containedInstance);
            Objects.requireNonNull(key, "ExampleScenario.instance.key is required");
            Objects.requireNonNull(structureType, "ExampleScenario.instance.structureType is required");
            Objects.requireNonNull(title, "ExampleScenario.instance.title is required");
            if (structureProfile != null && !(structureProfile instanceof FhirCanonical
                    || structureProfile instanceof FhirUri)) {
                throw new IllegalArgumentException(
                        "ExampleScenario.instance.structureProfile[x] must be one of canonical, uri, but was "
                                + structureProfile.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Instance}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Represents the instance as it was at a specific time-point.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param key ID or acronym of the version. Required.
         * @param title Label for instance version. Required.
         * @param description Details about version.
         * @param content Example instance version data.
         */
        public record Version(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString key,
                FhirString title,
                FhirMarkdown description,
                Reference content) implements BackboneElement {

            /**
             * Creates a {@code Version}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Version {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(key, "ExampleScenario.instance.version.key is required");
                Objects.requireNonNull(title, "ExampleScenario.instance.version.title is required");
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
             * Returns a builder initialized with the values of this {@code Version}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Version}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString key;
                private FhirString title;
                private FhirMarkdown description;
                private Reference content;

                private Builder() {
                }

                private Builder(Version original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.key = original.key();
                    this.title = original.title();
                    this.description = original.description();
                    this.content = original.content();
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
                 * Sets {@code key}.
                 *
                 * @param key the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder key(FhirString key) {
                    this.key = key;
                    return this;
                }

                /**
                 * Sets {@code key}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param key the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder key(String key) {
                    return key(key == null ? null : FhirString.of(key));
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
                 * Builds the {@code Version}.
                 *
                 * @return the {@code Version}
                 * @throws NullPointerException if a required element is absent
                 */
                public Version build() {
                    return new Version(
                            id, extension, modifierExtension, key, title, description, content);
                }
            }
        }

        /**
         * References to other instances that can be found within this instance (e.g. the observations contained in a
         * bundle).
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param instanceReference Key of contained instance. Required.
         * @param versionReference Key of contained instance version.
         */
        public record ContainedInstance(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString instanceReference,
                FhirString versionReference) implements BackboneElement {

            /**
             * Creates a {@code ContainedInstance}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public ContainedInstance {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(
                        instanceReference, "ExampleScenario.instance.containedInstance.instanceReference is required");
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
             * Returns a builder initialized with the values of this {@code ContainedInstance}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link ContainedInstance}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString instanceReference;
                private FhirString versionReference;

                private Builder() {
                }

                private Builder(ContainedInstance original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.instanceReference = original.instanceReference();
                    this.versionReference = original.versionReference();
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
                 * Sets {@code instanceReference}.
                 *
                 * @param instanceReference the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder instanceReference(FhirString instanceReference) {
                    this.instanceReference = instanceReference;
                    return this;
                }

                /**
                 * Sets {@code instanceReference}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param instanceReference the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder instanceReference(String instanceReference) {
                    return instanceReference(instanceReference == null ? null : FhirString.of(instanceReference));
                }

                /**
                 * Sets {@code versionReference}.
                 *
                 * @param versionReference the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder versionReference(FhirString versionReference) {
                    this.versionReference = versionReference;
                    return this;
                }

                /**
                 * Sets {@code versionReference}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param versionReference the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder versionReference(String versionReference) {
                    return versionReference(versionReference == null ? null : FhirString.of(versionReference));
                }

                /**
                 * Builds the {@code ContainedInstance}.
                 *
                 * @return the {@code ContainedInstance}
                 * @throws NullPointerException if a required element is absent
                 */
                public ContainedInstance build() {
                    return new ContainedInstance(
                            id, extension, modifierExtension, instanceReference, versionReference);
                }
            }
        }

        /** Builder for {@link Instance}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString key;
            private Coding structureType;
            private FhirString structureVersion;
            private DataType structureProfile;
            private FhirString title;
            private FhirMarkdown description;
            private Reference content;
            private List<Version> version = new ArrayList<>();
            private List<ContainedInstance> containedInstance = new ArrayList<>();

            private Builder() {
            }

            private Builder(Instance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.key = original.key();
                this.structureType = original.structureType();
                this.structureVersion = original.structureVersion();
                this.structureProfile = original.structureProfile();
                this.title = original.title();
                this.description = original.description();
                this.content = original.content();
                this.version = new ArrayList<>(original.version());
                this.containedInstance = new ArrayList<>(original.containedInstance());
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
             * Sets {@code key}.
             *
             * @param key the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder key(FhirString key) {
                this.key = key;
                return this;
            }

            /**
             * Sets {@code key}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param key the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder key(String key) {
                return key(key == null ? null : FhirString.of(key));
            }

            /**
             * Sets {@code structureType}.
             *
             * @param structureType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder structureType(Coding structureType) {
                this.structureType = structureType;
                return this;
            }

            /**
             * Sets {@code structureVersion}.
             *
             * @param structureVersion the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder structureVersion(FhirString structureVersion) {
                this.structureVersion = structureVersion;
                return this;
            }

            /**
             * Sets {@code structureVersion}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param structureVersion the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder structureVersion(String structureVersion) {
                return structureVersion(structureVersion == null ? null : FhirString.of(structureVersion));
            }

            /**
             * Sets {@code structureProfile} to a canonical.
             *
             * @param structureProfile the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder structureProfile(FhirCanonical structureProfile) {
                this.structureProfile = structureProfile;
                return this;
            }

            /**
             * Sets {@code structureProfile} to a uri.
             *
             * @param structureProfile the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder structureProfile(FhirUri structureProfile) {
                this.structureProfile = structureProfile;
                return this;
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
             * Replaces all {@code version} values.
             *
             * @param version the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder version(List<Version> version) {
                this.version = version == null ? new ArrayList<>() : new ArrayList<>(version);
                return this;
            }

            /**
             * Adds a {@code version} value.
             *
             * @param version the value to add
             * @return this builder
             */
            public Builder addVersion(Version version) {
                this.version.add(Objects.requireNonNull(version, "version"));
                return this;
            }

            /**
             * Replaces all {@code containedInstance} values.
             *
             * @param containedInstance the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder containedInstance(List<ContainedInstance> containedInstance) {
                this.containedInstance = containedInstance == null
                        ? new ArrayList<>()
                        : new ArrayList<>(containedInstance);
                return this;
            }

            /**
             * Adds a {@code containedInstance} value.
             *
             * @param containedInstance the value to add
             * @return this builder
             */
            public Builder addContainedInstance(ContainedInstance containedInstance) {
                this.containedInstance.add(Objects.requireNonNull(containedInstance, "containedInstance"));
                return this;
            }

            /**
             * Builds the {@code Instance}.
             *
             * @return the {@code Instance}
             * @throws NullPointerException if a required element is absent
             */
            public Instance build() {
                return new Instance(
                        id, extension, modifierExtension, key, structureType, structureVersion, structureProfile,
                        title, description, content, version, containedInstance);
            }
        }
    }

    /**
     * A group of operations that represents a significant step within a scenario.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param title Label for procss. Required.
     * @param description Human-friendly description of the process.
     * @param preConditions Status before process starts.
     * @param postConditions Status after successful completion.
     * @param step Event within of the process.
     */
    public record Process(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString title,
            FhirMarkdown description,
            FhirMarkdown preConditions,
            FhirMarkdown postConditions,
            List<Step> step) implements BackboneElement {

        /**
         * Creates a {@code Process}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Process {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            step = step == null ? List.of() : List.copyOf(step);
            Objects.requireNonNull(title, "ExampleScenario.process.title is required");
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
         * Returns a builder initialized with the values of this {@code Process}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A significant action that occurs as part of the process.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param number Sequential number of the step.
         * @param process Step is nested process.
         * @param workflow Step is nested workflow. Canonical reference to ExampleScenario.
         * @param operation Step is simple action.
         * @param alternative Alternate non-typical step action.
         * @param pause Pause in the flow?.
         */
        public record Step(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString number,
                ExampleScenario.Process process,
                FhirCanonical workflow,
                Operation operation,
                List<Alternative> alternative,
                FhirBoolean pause) implements BackboneElement {

            /**
             * Creates a {@code Step}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Step {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                alternative = alternative == null ? List.of() : List.copyOf(alternative);
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
             * Returns a builder initialized with the values of this {@code Step}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * The step represents a single operation invoked on receiver by sender.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param type Kind of action.
             * @param title Label for step. Required.
             * @param initiator Who starts the operation.
             * @param receiver Who receives the operation.
             * @param description Human-friendly description of the operation.
             * @param initiatorActive Initiator stays active?.
             * @param receiverActive Receiver stays active?.
             * @param request Instance transmitted on invocation.
             * @param response Instance transmitted on invocation response.
             */
            public record Operation(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    Coding type,
                    FhirString title,
                    FhirString initiator,
                    FhirString receiver,
                    FhirMarkdown description,
                    FhirBoolean initiatorActive,
                    FhirBoolean receiverActive,
                    ExampleScenario.Instance.ContainedInstance request,
                    ExampleScenario.Instance.ContainedInstance response) implements BackboneElement {

                /**
                 * Creates an {@code Operation}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public Operation {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(title, "ExampleScenario.process.step.operation.title is required");
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
                    private Coding type;
                    private FhirString title;
                    private FhirString initiator;
                    private FhirString receiver;
                    private FhirMarkdown description;
                    private FhirBoolean initiatorActive;
                    private FhirBoolean receiverActive;
                    private ExampleScenario.Instance.ContainedInstance request;
                    private ExampleScenario.Instance.ContainedInstance response;

                    private Builder() {
                    }

                    private Builder(Operation original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.type = original.type();
                        this.title = original.title();
                        this.initiator = original.initiator();
                        this.receiver = original.receiver();
                        this.description = original.description();
                        this.initiatorActive = original.initiatorActive();
                        this.receiverActive = original.receiverActive();
                        this.request = original.request();
                        this.response = original.response();
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
                     * Sets {@code initiator}.
                     *
                     * @param initiator the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder initiator(FhirString initiator) {
                        this.initiator = initiator;
                        return this;
                    }

                    /**
                     * Sets {@code initiator}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param initiator the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder initiator(String initiator) {
                        return initiator(initiator == null ? null : FhirString.of(initiator));
                    }

                    /**
                     * Sets {@code receiver}.
                     *
                     * @param receiver the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder receiver(FhirString receiver) {
                        this.receiver = receiver;
                        return this;
                    }

                    /**
                     * Sets {@code receiver}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param receiver the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder receiver(String receiver) {
                        return receiver(receiver == null ? null : FhirString.of(receiver));
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
                     * Sets {@code initiatorActive}.
                     *
                     * @param initiatorActive the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder initiatorActive(FhirBoolean initiatorActive) {
                        this.initiatorActive = initiatorActive;
                        return this;
                    }

                    /**
                     * Sets {@code initiatorActive}, wrapped in a {@link FhirBoolean} without id or extensions.
                     *
                     * @param initiatorActive the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder initiatorActive(Boolean initiatorActive) {
                        return initiatorActive(initiatorActive == null ? null : FhirBoolean.of(initiatorActive));
                    }

                    /**
                     * Sets {@code receiverActive}.
                     *
                     * @param receiverActive the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder receiverActive(FhirBoolean receiverActive) {
                        this.receiverActive = receiverActive;
                        return this;
                    }

                    /**
                     * Sets {@code receiverActive}, wrapped in a {@link FhirBoolean} without id or extensions.
                     *
                     * @param receiverActive the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder receiverActive(Boolean receiverActive) {
                        return receiverActive(receiverActive == null ? null : FhirBoolean.of(receiverActive));
                    }

                    /**
                     * Sets {@code request}.
                     *
                     * @param request the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder request(ExampleScenario.Instance.ContainedInstance request) {
                        this.request = request;
                        return this;
                    }

                    /**
                     * Sets {@code response}.
                     *
                     * @param response the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder response(ExampleScenario.Instance.ContainedInstance response) {
                        this.response = response;
                        return this;
                    }

                    /**
                     * Builds the {@code Operation}.
                     *
                     * @return the {@code Operation}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Operation build() {
                        return new Operation(
                                id, extension, modifierExtension, type, title, initiator, receiver, description,
                                initiatorActive, receiverActive, request, response);
                    }
                }
            }

            /**
             * Indicates an alternative step that can be taken instead of the sub-process, scenario or operation.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param title Label for alternative. Required.
             * @param description Human-readable description of option.
             * @param step Alternative action(s).
             */
            public record Alternative(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirString title,
                    FhirMarkdown description,
                    List<ExampleScenario.Process.Step> step) implements BackboneElement {

                /**
                 * Creates an {@code Alternative}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public Alternative {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    step = step == null ? List.of() : List.copyOf(step);
                    Objects.requireNonNull(title, "ExampleScenario.process.step.alternative.title is required");
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
                 * Returns a builder initialized with the values of this {@code Alternative}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Alternative}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirString title;
                    private FhirMarkdown description;
                    private List<ExampleScenario.Process.Step> step = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(Alternative original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.title = original.title();
                        this.description = original.description();
                        this.step = new ArrayList<>(original.step());
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
                     * Replaces all {@code step} values.
                     *
                     * @param step the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder step(List<ExampleScenario.Process.Step> step) {
                        this.step = step == null ? new ArrayList<>() : new ArrayList<>(step);
                        return this;
                    }

                    /**
                     * Adds a {@code step} value.
                     *
                     * @param step the value to add
                     * @return this builder
                     */
                    public Builder addStep(ExampleScenario.Process.Step step) {
                        this.step.add(Objects.requireNonNull(step, "step"));
                        return this;
                    }

                    /**
                     * Builds the {@code Alternative}.
                     *
                     * @return the {@code Alternative}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Alternative build() {
                        return new Alternative(
                                id, extension, modifierExtension, title, description, step);
                    }
                }
            }

            /** Builder for {@link Step}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString number;
                private ExampleScenario.Process process;
                private FhirCanonical workflow;
                private Operation operation;
                private List<Alternative> alternative = new ArrayList<>();
                private FhirBoolean pause;

                private Builder() {
                }

                private Builder(Step original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.number = original.number();
                    this.process = original.process();
                    this.workflow = original.workflow();
                    this.operation = original.operation();
                    this.alternative = new ArrayList<>(original.alternative());
                    this.pause = original.pause();
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
                 * Sets {@code number}.
                 *
                 * @param number the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder number(FhirString number) {
                    this.number = number;
                    return this;
                }

                /**
                 * Sets {@code number}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param number the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder number(String number) {
                    return number(number == null ? null : FhirString.of(number));
                }

                /**
                 * Sets {@code process}.
                 *
                 * @param process the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder process(ExampleScenario.Process process) {
                    this.process = process;
                    return this;
                }

                /**
                 * Sets {@code workflow}.
                 *
                 * @param workflow the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder workflow(FhirCanonical workflow) {
                    this.workflow = workflow;
                    return this;
                }

                /**
                 * Sets {@code workflow}, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param workflow the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder workflow(String workflow) {
                    return workflow(workflow == null ? null : FhirCanonical.of(workflow));
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
                 * Replaces all {@code alternative} values.
                 *
                 * @param alternative the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder alternative(List<Alternative> alternative) {
                    this.alternative = alternative == null ? new ArrayList<>() : new ArrayList<>(alternative);
                    return this;
                }

                /**
                 * Adds a {@code alternative} value.
                 *
                 * @param alternative the value to add
                 * @return this builder
                 */
                public Builder addAlternative(Alternative alternative) {
                    this.alternative.add(Objects.requireNonNull(alternative, "alternative"));
                    return this;
                }

                /**
                 * Sets {@code pause}.
                 *
                 * @param pause the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder pause(FhirBoolean pause) {
                    this.pause = pause;
                    return this;
                }

                /**
                 * Sets {@code pause}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param pause the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder pause(Boolean pause) {
                    return pause(pause == null ? null : FhirBoolean.of(pause));
                }

                /**
                 * Builds the {@code Step}.
                 *
                 * @return the {@code Step}
                 */
                public Step build() {
                    return new Step(
                            id, extension, modifierExtension, number, process, workflow, operation, alternative,
                            pause);
                }
            }
        }

        /** Builder for {@link Process}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString title;
            private FhirMarkdown description;
            private FhirMarkdown preConditions;
            private FhirMarkdown postConditions;
            private List<Step> step = new ArrayList<>();

            private Builder() {
            }

            private Builder(Process original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.title = original.title();
                this.description = original.description();
                this.preConditions = original.preConditions();
                this.postConditions = original.postConditions();
                this.step = new ArrayList<>(original.step());
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
             * Sets {@code preConditions}.
             *
             * @param preConditions the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder preConditions(FhirMarkdown preConditions) {
                this.preConditions = preConditions;
                return this;
            }

            /**
             * Sets {@code preConditions}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param preConditions the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder preConditions(String preConditions) {
                return preConditions(preConditions == null ? null : FhirMarkdown.of(preConditions));
            }

            /**
             * Sets {@code postConditions}.
             *
             * @param postConditions the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder postConditions(FhirMarkdown postConditions) {
                this.postConditions = postConditions;
                return this;
            }

            /**
             * Sets {@code postConditions}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param postConditions the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder postConditions(String postConditions) {
                return postConditions(postConditions == null ? null : FhirMarkdown.of(postConditions));
            }

            /**
             * Replaces all {@code step} values.
             *
             * @param step the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder step(List<Step> step) {
                this.step = step == null ? new ArrayList<>() : new ArrayList<>(step);
                return this;
            }

            /**
             * Adds a {@code step} value.
             *
             * @param step the value to add
             * @return this builder
             */
            public Builder addStep(Step step) {
                this.step.add(Objects.requireNonNull(step, "step"));
                return this;
            }

            /**
             * Builds the {@code Process}.
             *
             * @return the {@code Process}
             * @throws NullPointerException if a required element is absent
             */
            public Process build() {
                return new Process(
                        id, extension, modifierExtension, title, description, preConditions, postConditions, step);
            }
        }
    }

    /** Builder for {@link ExampleScenario}. Builders are mutable and not thread-safe. */
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
        private List<Actor> actor = new ArrayList<>();
        private List<Instance> instance = new ArrayList<>();
        private List<Process> process = new ArrayList<>();

        private Builder() {
        }

        private Builder(ExampleScenario original) {
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
            this.actor = new ArrayList<>(original.actor());
            this.instance = new ArrayList<>(original.instance());
            this.process = new ArrayList<>(original.process());
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
         * Replaces all {@code actor} values.
         *
         * @param actor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder actor(List<Actor> actor) {
            this.actor = actor == null ? new ArrayList<>() : new ArrayList<>(actor);
            return this;
        }

        /**
         * Adds a {@code actor} value.
         *
         * @param actor the value to add
         * @return this builder
         */
        public Builder addActor(Actor actor) {
            this.actor.add(Objects.requireNonNull(actor, "actor"));
            return this;
        }

        /**
         * Replaces all {@code instance} values.
         *
         * @param instance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder instance(List<Instance> instance) {
            this.instance = instance == null ? new ArrayList<>() : new ArrayList<>(instance);
            return this;
        }

        /**
         * Adds a {@code instance} value.
         *
         * @param instance the value to add
         * @return this builder
         */
        public Builder addInstance(Instance instance) {
            this.instance.add(Objects.requireNonNull(instance, "instance"));
            return this;
        }

        /**
         * Replaces all {@code process} values.
         *
         * @param process the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder process(List<Process> process) {
            this.process = process == null ? new ArrayList<>() : new ArrayList<>(process);
            return this;
        }

        /**
         * Adds a {@code process} value.
         *
         * @param process the value to add
         * @return this builder
         */
        public Builder addProcess(Process process) {
            this.process.add(Objects.requireNonNull(process, "process"));
            return this;
        }

        /**
         * Builds the {@code ExampleScenario}.
         *
         * @return the {@code ExampleScenario}
         * @throws NullPointerException if a required element is absent
         */
        public ExampleScenario build() {
            return new ExampleScenario(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, actor, instance,
                    process);
        }
    }
}
