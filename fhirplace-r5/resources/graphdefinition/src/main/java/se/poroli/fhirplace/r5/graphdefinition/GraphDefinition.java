package se.poroli.fhirplace.r5.graphdefinition;

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
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.CompartmentType;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by
 * following references.
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
 * @param url Canonical identifier for this graph definition, represented as a URI (globally unique).
 * @param identifier Additional identifier for the GraphDefinition (business identifier).
 * @param version Business version of the graph definition.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this graph definition (computer friendly). Required.
 * @param title Name for this graph definition (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the graph definition.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for graph definition (if applicable).
 * @param purpose Why this graph definition is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param start Starting Node.
 * @param node Potential target for the link.
 * @param link Links this graph makes rules about.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/GraphDefinition">FHIR R5 GraphDefinition</a>
 */
public record GraphDefinition(
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
        FhirId start,
        List<Node> node,
        List<Link> link) implements DomainResource {

    /**
     * Creates a {@code GraphDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public GraphDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        node = node == null ? List.of() : List.copyOf(node);
        link = link == null ? List.of() : List.copyOf(link);
        Objects.requireNonNull(name, "GraphDefinition.name is required");
        Objects.requireNonNull(status, "GraphDefinition.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "GraphDefinition.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code GraphDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Potential target for the link.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param nodeId Internal ID - target for link references. Required.
     * @param description Why this node is specified.
     * @param type Type of resource this link refers to. Required.
     * @param profile Profile for the target resource. Canonical reference to StructureDefinition.
     */
    public record Node(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirId nodeId,
            FhirString description,
            FhirCode type,
            FhirCanonical profile) implements BackboneElement {

        /**
         * Creates a {@code Node}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Node {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(nodeId, "GraphDefinition.node.nodeId is required");
            Objects.requireNonNull(type, "GraphDefinition.node.type is required");
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
         * Returns a builder initialized with the values of this {@code Node}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Node}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirId nodeId;
            private FhirString description;
            private FhirCode type;
            private FhirCanonical profile;

            private Builder() {
            }

            private Builder(Node original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.nodeId = original.nodeId();
                this.description = original.description();
                this.type = original.type();
                this.profile = original.profile();
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
             * Sets {@code nodeId}.
             *
             * @param nodeId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder nodeId(FhirId nodeId) {
                this.nodeId = nodeId;
                return this;
            }

            /**
             * Sets {@code nodeId}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param nodeId the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder nodeId(String nodeId) {
                return nodeId(nodeId == null ? null : FhirId.of(nodeId));
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
             * Sets {@code type}.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(FhirCode type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirCode} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(String type) {
                return type(type == null ? null : FhirCode.of(type));
            }

            /**
             * Sets {@code profile}.
             *
             * @param profile the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder profile(FhirCanonical profile) {
                this.profile = profile;
                return this;
            }

            /**
             * Sets {@code profile}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param profile the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder profile(String profile) {
                return profile(profile == null ? null : FhirCanonical.of(profile));
            }

            /**
             * Builds the {@code Node}.
             *
             * @return the {@code Node}
             * @throws NullPointerException if a required element is absent
             */
            public Node build() {
                return new Node(
                        id, extension, modifierExtension, nodeId, description, type, profile);
            }
        }
    }

    /**
     * Links this graph makes rules about.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param description Why this link is specified.
     * @param min Minimum occurrences for this link.
     * @param max Maximum occurrences for this link.
     * @param sourceId Source Node for this link. Required.
     * @param path Path in the resource that contains the link.
     * @param sliceName Which slice (if profiled).
     * @param targetId Target Node for this link. Required.
     * @param params Criteria for reverse lookup.
     * @param compartment Compartment Consistency Rules.
     */
    public record Link(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString description,
            FhirInteger min,
            FhirString max,
            FhirId sourceId,
            FhirString path,
            FhirString sliceName,
            FhirId targetId,
            FhirString params,
            List<Compartment> compartment) implements BackboneElement {

        /**
         * Creates a {@code Link}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Link {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            compartment = compartment == null ? List.of() : List.copyOf(compartment);
            Objects.requireNonNull(sourceId, "GraphDefinition.link.sourceId is required");
            Objects.requireNonNull(targetId, "GraphDefinition.link.targetId is required");
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

        /**
         * Compartment Consistency Rules.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param use where | requires. Required.
         * @param rule identical | matching | different | custom. Required.
         * @param code Patient | Encounter | RelatedPerson | Practitioner | Device | EpisodeOfCare. Required.
         * @param expression Custom rule, as a FHIRPath expression.
         * @param description Documentation for FHIRPath expression.
         */
        public record Compartment(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<GraphCompartmentUse> use,
                FhirEnum<GraphCompartmentRule> rule,
                FhirEnum<CompartmentType> code,
                FhirString expression,
                FhirString description) implements BackboneElement {

            /**
             * Creates a {@code Compartment}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Compartment {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(use, "GraphDefinition.link.compartment.use is required");
                Objects.requireNonNull(rule, "GraphDefinition.link.compartment.rule is required");
                Objects.requireNonNull(code, "GraphDefinition.link.compartment.code is required");
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
             * Returns a builder initialized with the values of this {@code Compartment}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Compartment}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<GraphCompartmentUse> use;
                private FhirEnum<GraphCompartmentRule> rule;
                private FhirEnum<CompartmentType> code;
                private FhirString expression;
                private FhirString description;

                private Builder() {
                }

                private Builder(Compartment original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.use = original.use();
                    this.rule = original.rule();
                    this.code = original.code();
                    this.expression = original.expression();
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
                 * Sets {@code use}.
                 *
                 * @param use the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder use(FhirEnum<GraphCompartmentUse> use) {
                    this.use = use;
                    return this;
                }

                /**
                 * Sets {@code use}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param use the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder use(GraphCompartmentUse use) {
                    return use(use == null ? null : FhirEnum.of(use));
                }

                /**
                 * Sets {@code rule}.
                 *
                 * @param rule the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder rule(FhirEnum<GraphCompartmentRule> rule) {
                    this.rule = rule;
                    return this;
                }

                /**
                 * Sets {@code rule}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param rule the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder rule(GraphCompartmentRule rule) {
                    return rule(rule == null ? null : FhirEnum.of(rule));
                }

                /**
                 * Sets {@code code}.
                 *
                 * @param code the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder code(FhirEnum<CompartmentType> code) {
                    this.code = code;
                    return this;
                }

                /**
                 * Sets {@code code}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param code the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder code(CompartmentType code) {
                    return code(code == null ? null : FhirEnum.of(code));
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
                 * Builds the {@code Compartment}.
                 *
                 * @return the {@code Compartment}
                 * @throws NullPointerException if a required element is absent
                 */
                public Compartment build() {
                    return new Compartment(
                            id, extension, modifierExtension, use, rule, code, expression, description);
                }
            }
        }

        /** Builder for {@link Link}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString description;
            private FhirInteger min;
            private FhirString max;
            private FhirId sourceId;
            private FhirString path;
            private FhirString sliceName;
            private FhirId targetId;
            private FhirString params;
            private List<Compartment> compartment = new ArrayList<>();

            private Builder() {
            }

            private Builder(Link original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.description = original.description();
                this.min = original.min();
                this.max = original.max();
                this.sourceId = original.sourceId();
                this.path = original.path();
                this.sliceName = original.sliceName();
                this.targetId = original.targetId();
                this.params = original.params();
                this.compartment = new ArrayList<>(original.compartment());
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
             * Sets {@code min}.
             *
             * @param min the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder min(FhirInteger min) {
                this.min = min;
                return this;
            }

            /**
             * Sets {@code min}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param min the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder min(Integer min) {
                return min(min == null ? null : FhirInteger.of(min));
            }

            /**
             * Sets {@code max}.
             *
             * @param max the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder max(FhirString max) {
                this.max = max;
                return this;
            }

            /**
             * Sets {@code max}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param max the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder max(String max) {
                return max(max == null ? null : FhirString.of(max));
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
             * Sets {@code sliceName}.
             *
             * @param sliceName the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sliceName(FhirString sliceName) {
                this.sliceName = sliceName;
                return this;
            }

            /**
             * Sets {@code sliceName}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param sliceName the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sliceName(String sliceName) {
                return sliceName(sliceName == null ? null : FhirString.of(sliceName));
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
             * Replaces all {@code compartment} values.
             *
             * @param compartment the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder compartment(List<Compartment> compartment) {
                this.compartment = compartment == null ? new ArrayList<>() : new ArrayList<>(compartment);
                return this;
            }

            /**
             * Adds a {@code compartment} value.
             *
             * @param compartment the value to add
             * @return this builder
             */
            public Builder addCompartment(Compartment compartment) {
                this.compartment.add(Objects.requireNonNull(compartment, "compartment"));
                return this;
            }

            /**
             * Builds the {@code Link}.
             *
             * @return the {@code Link}
             * @throws NullPointerException if a required element is absent
             */
            public Link build() {
                return new Link(
                        id, extension, modifierExtension, description, min, max, sourceId, path, sliceName, targetId,
                        params, compartment);
            }
        }
    }

    /** Builder for {@link GraphDefinition}. Builders are mutable and not thread-safe. */
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
        private FhirId start;
        private List<Node> node = new ArrayList<>();
        private List<Link> link = new ArrayList<>();

        private Builder() {
        }

        private Builder(GraphDefinition original) {
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
            this.start = original.start();
            this.node = new ArrayList<>(original.node());
            this.link = new ArrayList<>(original.link());
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
         * Sets {@code start}.
         *
         * @param start the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder start(FhirId start) {
            this.start = start;
            return this;
        }

        /**
         * Sets {@code start}, wrapped in a {@link FhirId} without id or extensions.
         *
         * @param start the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder start(String start) {
            return start(start == null ? null : FhirId.of(start));
        }

        /**
         * Replaces all {@code node} values.
         *
         * @param node the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder node(List<Node> node) {
            this.node = node == null ? new ArrayList<>() : new ArrayList<>(node);
            return this;
        }

        /**
         * Adds a {@code node} value.
         *
         * @param node the value to add
         * @return this builder
         */
        public Builder addNode(Node node) {
            this.node.add(Objects.requireNonNull(node, "node"));
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
         * Builds the {@code GraphDefinition}.
         *
         * @return the {@code GraphDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public GraphDefinition build() {
            return new GraphDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, start, node, link);
        }
    }
}
