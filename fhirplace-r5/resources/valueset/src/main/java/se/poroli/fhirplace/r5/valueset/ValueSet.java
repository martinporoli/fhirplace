package se.poroli.fhirplace.r5.valueset;

import java.math.BigDecimal;
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
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.FilterOperator;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a
 * particular context.
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
 * @param url Canonical identifier for this value set, represented as a URI (globally unique).
 * @param identifier Additional identifier for the value set (business identifier).
 * @param version Business version of the value set.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this value set (computer friendly).
 * @param title Name for this value set (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the value set.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for value set (if applicable).
 * @param immutable Indicates whether or not any change to the content logical definition may occur.
 * @param purpose Why this value set is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param approvalDate When the ValueSet was approved by publisher.
 * @param lastReviewDate When the ValueSet was last reviewed by the publisher.
 * @param effectivePeriod When the ValueSet is expected to be used.
 * @param topic E.g. Education, Treatment, Assessment, etc.
 * @param author Who authored the ValueSet.
 * @param editor Who edited the ValueSet.
 * @param reviewer Who reviewed the ValueSet.
 * @param endorser Who endorsed the ValueSet.
 * @param relatedArtifact Additional documentation, citations, etc.
 * @param compose Content logical definition of the value set (CLD).
 * @param expansion Used when the value set is "expanded".
 * @param scope Description of the semantic space the Value Set Expansion is intended to cover and should further
 *   clarify the text in ValueSet.description.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ValueSet">FHIR R5 ValueSet</a>
 */
public record ValueSet(
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
        FhirBoolean immutable,
        FhirMarkdown purpose,
        FhirMarkdown copyright,
        FhirString copyrightLabel,
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        Period effectivePeriod,
        List<CodeableConcept> topic,
        List<ContactDetail> author,
        List<ContactDetail> editor,
        List<ContactDetail> reviewer,
        List<ContactDetail> endorser,
        List<RelatedArtifact> relatedArtifact,
        Compose compose,
        Expansion expansion,
        Scope scope) implements DomainResource {

    /**
     * Creates a {@code ValueSet}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ValueSet {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        topic = topic == null ? List.of() : List.copyOf(topic);
        author = author == null ? List.of() : List.copyOf(author);
        editor = editor == null ? List.of() : List.copyOf(editor);
        reviewer = reviewer == null ? List.of() : List.copyOf(reviewer);
        endorser = endorser == null ? List.of() : List.copyOf(endorser);
        relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
        Objects.requireNonNull(status, "ValueSet.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "ValueSet.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code ValueSet}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A set of criteria that define the contents of the value set by including or excluding codes selected from the
     * specified code system(s) that the value set draws from.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param lockedDate Fixed date for references with no specified version (transitive).
     * @param inactive Whether inactive codes are in the value set.
     * @param include Include one or more codes from a code system or other value set(s). Required.
     * @param exclude Explicitly exclude codes from a code system or other value sets.
     * @param property Property to return if client doesn't override.
     */
    public record Compose(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirDate lockedDate,
            FhirBoolean inactive,
            List<ConceptSet> include,
            List<ValueSet.Compose.ConceptSet> exclude,
            List<FhirString> property) implements BackboneElement {

        /**
         * Creates a {@code Compose}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Compose {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            include = include == null ? List.of() : List.copyOf(include);
            exclude = exclude == null ? List.of() : List.copyOf(exclude);
            property = property == null ? List.of() : List.copyOf(property);
            if (include.isEmpty()) {
                throw new IllegalArgumentException("ValueSet.compose.include requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Compose}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Include one or more codes from a code system or other value set(s).
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param system The system the codes come from.
         * @param version Specific version of the code system referred to.
         * @param concept A concept defined in the system.
         * @param filter Select codes/concepts by their properties (including relationships).
         * @param valueSet Select the contents included in this value set. Canonical reference to ValueSet.
         * @param copyright A copyright statement for the specific code system included in the value set.
         */
        public record ConceptSet(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirUri system,
                FhirString version,
                List<ConceptReference> concept,
                List<Filter> filter,
                List<FhirCanonical> valueSet,
                FhirString copyright) implements BackboneElement {

            /**
             * Creates a {@code ConceptSet}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public ConceptSet {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                concept = concept == null ? List.of() : List.copyOf(concept);
                filter = filter == null ? List.of() : List.copyOf(filter);
                valueSet = valueSet == null ? List.of() : List.copyOf(valueSet);
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
             * Returns a builder initialized with the values of this {@code ConceptSet}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Specifies a concept to be included or excluded.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param code Code or expression from system. Required.
             * @param display Text to display for this code for this value set in this valueset.
             * @param designation Additional representations for this concept.
             */
            public record ConceptReference(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirCode code,
                    FhirString display,
                    List<Designation> designation) implements BackboneElement {

                /**
                 * Creates a {@code ConceptReference}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public ConceptReference {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    designation = designation == null ? List.of() : List.copyOf(designation);
                    Objects.requireNonNull(code, "ValueSet.compose.include.concept.code is required");
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
                 * Returns a builder initialized with the values of this {@code ConceptReference}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /**
                 * Additional representations for this concept when used in this value set - other languages, aliases,
                 * specialized purposes, used for particular purposes, etc.
                 *
                 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
                 * Instances are usually created with {@link #builder()}.
                 *
                 * @param id Unique id for inter-element referencing.
                 * @param extension Additional content defined by implementations.
                 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
                 * @param language Human language of the designation.
                 * @param use Types of uses of designations.
                 * @param additionalUse Additional ways how this designation would be used.
                 * @param value The text value for this designation. Required.
                 */
                public record Designation(
                        String id,
                        List<Extension> extension,
                        List<Extension> modifierExtension,
                        FhirCode language,
                        Coding use,
                        List<Coding> additionalUse,
                        FhirString value) implements BackboneElement {

                    /**
                     * Creates a {@code Designation}, copying all lists.
                     *
                     * @throws NullPointerException if a required element is absent or a list contains {@code null}
                     */
                    public Designation {
                        extension = extension == null ? List.of() : List.copyOf(extension);
                        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                        additionalUse = additionalUse == null ? List.of() : List.copyOf(additionalUse);
                        Objects.requireNonNull(
                                value, "ValueSet.compose.include.concept.designation.value is required");
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
                     * Returns a builder initialized with the values of this {@code Designation}.
                     *
                     * @return the builder
                     */
                    public Builder toBuilder() {
                        return new Builder(this);
                    }

                    /** Builder for {@link Designation}. Builders are mutable and not thread-safe. */
                    public static final class Builder {

                        private String id;
                        private List<Extension> extension = new ArrayList<>();
                        private List<Extension> modifierExtension = new ArrayList<>();
                        private FhirCode language;
                        private Coding use;
                        private List<Coding> additionalUse = new ArrayList<>();
                        private FhirString value;

                        private Builder() {
                        }

                        private Builder(Designation original) {
                            this.id = original.id();
                            this.extension = new ArrayList<>(original.extension());
                            this.modifierExtension = new ArrayList<>(original.modifierExtension());
                            this.language = original.language();
                            this.use = original.use();
                            this.additionalUse = new ArrayList<>(original.additionalUse());
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
                         * Sets {@code use}.
                         *
                         * @param use the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder use(Coding use) {
                            this.use = use;
                            return this;
                        }

                        /**
                         * Replaces all {@code additionalUse} values.
                         *
                         * @param additionalUse the new values, or {@code null} to clear them
                         * @return this builder
                         */
                        public Builder additionalUse(List<Coding> additionalUse) {
                            this.additionalUse = additionalUse == null
                                    ? new ArrayList<>()
                                    : new ArrayList<>(additionalUse);
                            return this;
                        }

                        /**
                         * Adds a {@code additionalUse} value.
                         *
                         * @param additionalUse the value to add
                         * @return this builder
                         */
                        public Builder addAdditionalUse(Coding additionalUse) {
                            this.additionalUse.add(Objects.requireNonNull(additionalUse, "additionalUse"));
                            return this;
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
                         * Builds the {@code Designation}.
                         *
                         * @return the {@code Designation}
                         * @throws NullPointerException if a required element is absent
                         */
                        public Designation build() {
                            return new Designation(
                                    id, extension, modifierExtension, language, use, additionalUse, value);
                        }
                    }
                }

                /** Builder for {@link ConceptReference}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirCode code;
                    private FhirString display;
                    private List<Designation> designation = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(ConceptReference original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.code = original.code();
                        this.display = original.display();
                        this.designation = new ArrayList<>(original.designation());
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
                     * Sets {@code code}.
                     *
                     * @param code the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder code(FhirCode code) {
                        this.code = code;
                        return this;
                    }

                    /**
                     * Sets {@code code}, wrapped in a {@link FhirCode} without id or extensions.
                     *
                     * @param code the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder code(String code) {
                        return code(code == null ? null : FhirCode.of(code));
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
                     * Replaces all {@code designation} values.
                     *
                     * @param designation the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder designation(List<Designation> designation) {
                        this.designation = designation == null ? new ArrayList<>() : new ArrayList<>(designation);
                        return this;
                    }

                    /**
                     * Adds a {@code designation} value.
                     *
                     * @param designation the value to add
                     * @return this builder
                     */
                    public Builder addDesignation(Designation designation) {
                        this.designation.add(Objects.requireNonNull(designation, "designation"));
                        return this;
                    }

                    /**
                     * Builds the {@code ConceptReference}.
                     *
                     * @return the {@code ConceptReference}
                     * @throws NullPointerException if a required element is absent
                     */
                    public ConceptReference build() {
                        return new ConceptReference(
                                id, extension, modifierExtension, code, display, designation);
                    }
                }
            }

            /**
             * Select concepts by specifying a matching criterion based on the properties (including relationships)
             * defined by the system, or on filters defined by the system.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param property A property/filter defined by the code system. Required.
             * @param op = | is-a | descendent-of | is-not-a | regex | in | not-in | generalizes | child-of |
             *   descendent-leaf | exists. Required.
             * @param value Code from the system, or regex criteria, or boolean value for exists. Required.
             */
            public record Filter(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirCode property,
                    FhirEnum<FilterOperator> op,
                    FhirString value) implements BackboneElement {

                /**
                 * Creates a {@code Filter}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public Filter {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(property, "ValueSet.compose.include.filter.property is required");
                    Objects.requireNonNull(op, "ValueSet.compose.include.filter.op is required");
                    Objects.requireNonNull(value, "ValueSet.compose.include.filter.value is required");
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
                 * Returns a builder initialized with the values of this {@code Filter}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Filter}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirCode property;
                    private FhirEnum<FilterOperator> op;
                    private FhirString value;

                    private Builder() {
                    }

                    private Builder(Filter original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.property = original.property();
                        this.op = original.op();
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
                        this.modifierExtension.add(Objects.requireNonNull(modifierExtension, "modifierExtension"));
                        return this;
                    }

                    /**
                     * Sets {@code property}.
                     *
                     * @param property the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder property(FhirCode property) {
                        this.property = property;
                        return this;
                    }

                    /**
                     * Sets {@code property}, wrapped in a {@link FhirCode} without id or extensions.
                     *
                     * @param property the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder property(String property) {
                        return property(property == null ? null : FhirCode.of(property));
                    }

                    /**
                     * Sets {@code op}.
                     *
                     * @param op the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder op(FhirEnum<FilterOperator> op) {
                        this.op = op;
                        return this;
                    }

                    /**
                     * Sets {@code op}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param op the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder op(FilterOperator op) {
                        return op(op == null ? null : FhirEnum.of(op));
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
                     * Builds the {@code Filter}.
                     *
                     * @return the {@code Filter}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Filter build() {
                        return new Filter(
                                id, extension, modifierExtension, property, op, value);
                    }
                }
            }

            /** Builder for {@link ConceptSet}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirUri system;
                private FhirString version;
                private List<ConceptReference> concept = new ArrayList<>();
                private List<Filter> filter = new ArrayList<>();
                private List<FhirCanonical> valueSet = new ArrayList<>();
                private FhirString copyright;

                private Builder() {
                }

                private Builder(ConceptSet original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.system = original.system();
                    this.version = original.version();
                    this.concept = new ArrayList<>(original.concept());
                    this.filter = new ArrayList<>(original.filter());
                    this.valueSet = new ArrayList<>(original.valueSet());
                    this.copyright = original.copyright();
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
                 * Sets {@code system}.
                 *
                 * @param system the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder system(FhirUri system) {
                    this.system = system;
                    return this;
                }

                /**
                 * Sets {@code system}, wrapped in a {@link FhirUri} without id or extensions.
                 *
                 * @param system the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder system(String system) {
                    return system(system == null ? null : FhirUri.of(system));
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
                 * Replaces all {@code concept} values.
                 *
                 * @param concept the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder concept(List<ConceptReference> concept) {
                    this.concept = concept == null ? new ArrayList<>() : new ArrayList<>(concept);
                    return this;
                }

                /**
                 * Adds a {@code concept} value.
                 *
                 * @param concept the value to add
                 * @return this builder
                 */
                public Builder addConcept(ConceptReference concept) {
                    this.concept.add(Objects.requireNonNull(concept, "concept"));
                    return this;
                }

                /**
                 * Replaces all {@code filter} values.
                 *
                 * @param filter the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder filter(List<Filter> filter) {
                    this.filter = filter == null ? new ArrayList<>() : new ArrayList<>(filter);
                    return this;
                }

                /**
                 * Adds a {@code filter} value.
                 *
                 * @param filter the value to add
                 * @return this builder
                 */
                public Builder addFilter(Filter filter) {
                    this.filter.add(Objects.requireNonNull(filter, "filter"));
                    return this;
                }

                /**
                 * Replaces all {@code valueSet} values.
                 *
                 * @param valueSet the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder valueSet(List<FhirCanonical> valueSet) {
                    this.valueSet = valueSet == null ? new ArrayList<>() : new ArrayList<>(valueSet);
                    return this;
                }

                /**
                 * Adds a {@code valueSet} value.
                 *
                 * @param valueSet the value to add
                 * @return this builder
                 */
                public Builder addValueSet(FhirCanonical valueSet) {
                    this.valueSet.add(Objects.requireNonNull(valueSet, "valueSet"));
                    return this;
                }

                /**
                 * Adds a {@code valueSet} value, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param valueSet the value to add
                 * @return this builder
                 */
                public Builder addValueSet(String valueSet) {
                    return addValueSet(FhirCanonical.of(valueSet));
                }

                /**
                 * Sets {@code copyright}.
                 *
                 * @param copyright the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder copyright(FhirString copyright) {
                    this.copyright = copyright;
                    return this;
                }

                /**
                 * Sets {@code copyright}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param copyright the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder copyright(String copyright) {
                    return copyright(copyright == null ? null : FhirString.of(copyright));
                }

                /**
                 * Builds the {@code ConceptSet}.
                 *
                 * @return the {@code ConceptSet}
                 */
                public ConceptSet build() {
                    return new ConceptSet(
                            id, extension, modifierExtension, system, version, concept, filter, valueSet, copyright);
                }
            }
        }

        /** Builder for {@link Compose}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirDate lockedDate;
            private FhirBoolean inactive;
            private List<ConceptSet> include = new ArrayList<>();
            private List<ValueSet.Compose.ConceptSet> exclude = new ArrayList<>();
            private List<FhirString> property = new ArrayList<>();

            private Builder() {
            }

            private Builder(Compose original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.lockedDate = original.lockedDate();
                this.inactive = original.inactive();
                this.include = new ArrayList<>(original.include());
                this.exclude = new ArrayList<>(original.exclude());
                this.property = new ArrayList<>(original.property());
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
             * Sets {@code lockedDate}.
             *
             * @param lockedDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder lockedDate(FhirDate lockedDate) {
                this.lockedDate = lockedDate;
                return this;
            }

            /**
             * Sets {@code lockedDate}, wrapped in a {@link FhirDate} without id or extensions.
             *
             * @param lockedDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder lockedDate(Temporal lockedDate) {
                return lockedDate(lockedDate == null ? null : FhirDate.of(lockedDate));
            }

            /**
             * Sets {@code inactive}.
             *
             * @param inactive the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder inactive(FhirBoolean inactive) {
                this.inactive = inactive;
                return this;
            }

            /**
             * Sets {@code inactive}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param inactive the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder inactive(Boolean inactive) {
                return inactive(inactive == null ? null : FhirBoolean.of(inactive));
            }

            /**
             * Replaces all {@code include} values.
             *
             * @param include the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder include(List<ConceptSet> include) {
                this.include = include == null ? new ArrayList<>() : new ArrayList<>(include);
                return this;
            }

            /**
             * Adds a {@code include} value.
             *
             * @param include the value to add
             * @return this builder
             */
            public Builder addInclude(ConceptSet include) {
                this.include.add(Objects.requireNonNull(include, "include"));
                return this;
            }

            /**
             * Replaces all {@code exclude} values.
             *
             * @param exclude the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder exclude(List<ValueSet.Compose.ConceptSet> exclude) {
                this.exclude = exclude == null ? new ArrayList<>() : new ArrayList<>(exclude);
                return this;
            }

            /**
             * Adds a {@code exclude} value.
             *
             * @param exclude the value to add
             * @return this builder
             */
            public Builder addExclude(ValueSet.Compose.ConceptSet exclude) {
                this.exclude.add(Objects.requireNonNull(exclude, "exclude"));
                return this;
            }

            /**
             * Replaces all {@code property} values.
             *
             * @param property the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder property(List<FhirString> property) {
                this.property = property == null ? new ArrayList<>() : new ArrayList<>(property);
                return this;
            }

            /**
             * Adds a {@code property} value.
             *
             * @param property the value to add
             * @return this builder
             */
            public Builder addProperty(FhirString property) {
                this.property.add(Objects.requireNonNull(property, "property"));
                return this;
            }

            /**
             * Adds a {@code property} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param property the value to add
             * @return this builder
             */
            public Builder addProperty(String property) {
                return addProperty(FhirString.of(property));
            }

            /**
             * Builds the {@code Compose}.
             *
             * @return the {@code Compose}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Compose build() {
                return new Compose(
                        id, extension, modifierExtension, lockedDate, inactive, include, exclude, property);
            }
        }
    }

    /**
     * A value set can also be "expanded", where the value set is turned into a simple collection of enumerated codes.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier Identifies the value set expansion (business identifier).
     * @param next Opaque urls for paging through expansion results.
     * @param timestamp Time ValueSet expansion happened. Required.
     * @param total Total number of codes in the expansion.
     * @param offset Offset at which this resource starts.
     * @param parameter Parameter that controlled the expansion process.
     * @param property Additional information supplied about each concept.
     * @param contains Codes in the value set.
     */
    public record Expansion(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirUri identifier,
            FhirUri next,
            FhirDateTime timestamp,
            FhirInteger total,
            FhirInteger offset,
            List<Parameter> parameter,
            List<Property> property,
            List<Contains> contains) implements BackboneElement {

        /**
         * Creates an {@code Expansion}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Expansion {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            parameter = parameter == null ? List.of() : List.copyOf(parameter);
            property = property == null ? List.of() : List.copyOf(property);
            contains = contains == null ? List.of() : List.copyOf(contains);
            Objects.requireNonNull(timestamp, "ValueSet.expansion.timestamp is required");
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
         * Returns a builder initialized with the values of this {@code Expansion}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A parameter that controlled the expansion process.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param name Name as assigned by the client or server. Required.
         * @param value Value of the named parameter. One of string, boolean, integer, decimal, uri, code, dateTime.
         */
        public record Parameter(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString name,
                DataType value) implements BackboneElement {

            /**
             * Creates a {@code Parameter}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Parameter {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(name, "ValueSet.expansion.parameter.name is required");
                if (value != null && !(value instanceof FhirString
                        || value instanceof FhirBoolean
                        || value instanceof FhirInteger
                        || value instanceof FhirDecimal
                        || value instanceof FhirUri
                        || value instanceof FhirCode
                        || value instanceof FhirEnum<?>
                        || value instanceof FhirDateTime)) {
                    throw new IllegalArgumentException(
                            "ValueSet.expansion.parameter.value[x] does not allow "
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
             * Returns a builder initialized with the values of this {@code Parameter}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Parameter}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString name;
                private DataType value;

                private Builder() {
                }

                private Builder(Parameter original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.name = original.name();
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
                 * Sets {@code value} to a string.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirString value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a boolean.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirBoolean value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a integer.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirInteger value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a decimal.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirDecimal value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a uri.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirUri value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a code.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirCode value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a code bound to an enum.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirEnum<?> value) {
                    this.value = value;
                    return this;
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
                 * Sets {@code value} to a boolean without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Boolean value) {
                    this.value = value == null ? null : FhirBoolean.of(value);
                    return this;
                }

                /**
                 * Sets {@code value} to a integer without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Integer value) {
                    this.value = value == null ? null : FhirInteger.of(value);
                    return this;
                }

                /**
                 * Sets {@code value} to a decimal without id or extensions.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(BigDecimal value) {
                    this.value = value == null ? null : FhirDecimal.of(value);
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
                 * Builds the {@code Parameter}.
                 *
                 * @return the {@code Parameter}
                 * @throws NullPointerException if a required element is absent
                 */
                public Parameter build() {
                    return new Parameter(
                            id, extension, modifierExtension, name, value);
                }
            }
        }

        /**
         * A property defines an additional slot through which additional information can be provided about a concept.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code Identifies the property on the concepts, and when referred to in operations. Required.
         * @param uri Formal identifier for the property.
         */
        public record Property(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirCode code,
                FhirUri uri) implements BackboneElement {

            /**
             * Creates a {@code Property}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Property {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(code, "ValueSet.expansion.property.code is required");
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
             * Returns a builder initialized with the values of this {@code Property}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Property}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirCode code;
                private FhirUri uri;

                private Builder() {
                }

                private Builder(Property original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.code = original.code();
                    this.uri = original.uri();
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
                 * Sets {@code code}.
                 *
                 * @param code the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder code(FhirCode code) {
                    this.code = code;
                    return this;
                }

                /**
                 * Sets {@code code}, wrapped in a {@link FhirCode} without id or extensions.
                 *
                 * @param code the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder code(String code) {
                    return code(code == null ? null : FhirCode.of(code));
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
                 * Builds the {@code Property}.
                 *
                 * @return the {@code Property}
                 * @throws NullPointerException if a required element is absent
                 */
                public Property build() {
                    return new Property(
                            id, extension, modifierExtension, code, uri);
                }
            }
        }

        /**
         * The codes that are contained in the value set expansion.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param system System value for the code.
         * @param abstractValue If user cannot select this entry. The FHIR element {@code abstract}.
         * @param inactive If concept is inactive in the code system.
         * @param version Version in which this code/display is defined.
         * @param code Code - if blank, this is not a selectable code.
         * @param display User display for the concept.
         * @param designation Additional representations for this item.
         * @param property Property value for the concept.
         * @param contains Codes contained under this entry.
         */
        public record Contains(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirUri system,
                FhirBoolean abstractValue,
                FhirBoolean inactive,
                FhirString version,
                FhirCode code,
                FhirString display,
                List<ValueSet.Compose.ConceptSet.ConceptReference.Designation> designation,
                List<ConceptProperty> property,
                List<ValueSet.Expansion.Contains> contains) implements BackboneElement {

            /**
             * Creates a {@code Contains}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Contains {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                designation = designation == null ? List.of() : List.copyOf(designation);
                property = property == null ? List.of() : List.copyOf(property);
                contains = contains == null ? List.of() : List.copyOf(contains);
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
             * Returns a builder initialized with the values of this {@code Contains}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * A property value for this concept.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param code Reference to ValueSet.expansion.property.code. Required.
             * @param value Value of the property for this concept. One of code, Coding, string, integer, boolean,
             *   dateTime, decimal. Required.
             * @param subProperty SubProperty value for the concept.
             */
            public record ConceptProperty(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirCode code,
                    DataType value,
                    List<ConceptSubProperty> subProperty) implements BackboneElement {

                /**
                 * Creates a {@code ConceptProperty}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 * @throws IllegalArgumentException if a choice element has a type that is not allowed
                 */
                public ConceptProperty {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    subProperty = subProperty == null ? List.of() : List.copyOf(subProperty);
                    Objects.requireNonNull(code, "ValueSet.expansion.contains.property.code is required");
                    Objects.requireNonNull(value, "ValueSet.expansion.contains.property.value is required");
                    if (value != null && !(value instanceof FhirCode
                            || value instanceof FhirEnum<?>
                            || value instanceof Coding
                            || value instanceof FhirString
                            || value instanceof FhirInteger
                            || value instanceof FhirBoolean
                            || value instanceof FhirDateTime
                            || value instanceof FhirDecimal)) {
                        throw new IllegalArgumentException(
                                "ValueSet.expansion.contains.property.value[x] does not allow "
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
                 * Returns a builder initialized with the values of this {@code ConceptProperty}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /**
                 * A subproperty value for this concept.
                 *
                 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
                 * Instances are usually created with {@link #builder()}.
                 *
                 * @param id Unique id for inter-element referencing.
                 * @param extension Additional content defined by implementations.
                 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
                 * @param code Reference to ValueSet.expansion.property.code. Required.
                 * @param value Value of the subproperty for this concept. One of code, Coding, string, integer,
                 *   boolean, dateTime, decimal. Required.
                 */
                public record ConceptSubProperty(
                        String id,
                        List<Extension> extension,
                        List<Extension> modifierExtension,
                        FhirCode code,
                        DataType value) implements BackboneElement {

                    /**
                     * Creates a {@code ConceptSubProperty}, copying all lists.
                     *
                     * @throws NullPointerException if a required element is absent or a list contains {@code null}
                     * @throws IllegalArgumentException if a choice element has a type that is not allowed
                     */
                    public ConceptSubProperty {
                        extension = extension == null ? List.of() : List.copyOf(extension);
                        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                        Objects.requireNonNull(
                                code, "ValueSet.expansion.contains.property.subProperty.code is required");
                        Objects.requireNonNull(
                                value, "ValueSet.expansion.contains.property.subProperty.value is required");
                        if (value != null && !(value instanceof FhirCode
                                || value instanceof FhirEnum<?>
                                || value instanceof Coding
                                || value instanceof FhirString
                                || value instanceof FhirInteger
                                || value instanceof FhirBoolean
                                || value instanceof FhirDateTime
                                || value instanceof FhirDecimal)) {
                            throw new IllegalArgumentException(
                                    "ValueSet.expansion.contains.property.subProperty.value[x] does not allow "
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
                     * Returns a builder initialized with the values of this {@code ConceptSubProperty}.
                     *
                     * @return the builder
                     */
                    public Builder toBuilder() {
                        return new Builder(this);
                    }

                    /** Builder for {@link ConceptSubProperty}. Builders are mutable and not thread-safe. */
                    public static final class Builder {

                        private String id;
                        private List<Extension> extension = new ArrayList<>();
                        private List<Extension> modifierExtension = new ArrayList<>();
                        private FhirCode code;
                        private DataType value;

                        private Builder() {
                        }

                        private Builder(ConceptSubProperty original) {
                            this.id = original.id();
                            this.extension = new ArrayList<>(original.extension());
                            this.modifierExtension = new ArrayList<>(original.modifierExtension());
                            this.code = original.code();
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
                         * Sets {@code code}.
                         *
                         * @param code the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder code(FhirCode code) {
                            this.code = code;
                            return this;
                        }

                        /**
                         * Sets {@code code}, wrapped in a {@link FhirCode} without id or extensions.
                         *
                         * @param code the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder code(String code) {
                            return code(code == null ? null : FhirCode.of(code));
                        }

                        /**
                         * Sets {@code value} to a code.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirCode value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a code bound to an enum.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirEnum<?> value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a Coding.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(Coding value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a string.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirString value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a integer.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirInteger value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a boolean.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirBoolean value) {
                            this.value = value;
                            return this;
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
                         * Sets {@code value} to a decimal.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(FhirDecimal value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Sets {@code value} to a integer without id or extensions.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(Integer value) {
                            this.value = value == null ? null : FhirInteger.of(value);
                            return this;
                        }

                        /**
                         * Sets {@code value} to a boolean without id or extensions.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(Boolean value) {
                            this.value = value == null ? null : FhirBoolean.of(value);
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
                         * Sets {@code value} to a decimal without id or extensions.
                         *
                         * @param value the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder value(BigDecimal value) {
                            this.value = value == null ? null : FhirDecimal.of(value);
                            return this;
                        }

                        /**
                         * Builds the {@code ConceptSubProperty}.
                         *
                         * @return the {@code ConceptSubProperty}
                         * @throws NullPointerException if a required element is absent
                         */
                        public ConceptSubProperty build() {
                            return new ConceptSubProperty(
                                    id, extension, modifierExtension, code, value);
                        }
                    }
                }

                /** Builder for {@link ConceptProperty}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirCode code;
                    private DataType value;
                    private List<ConceptSubProperty> subProperty = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(ConceptProperty original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.code = original.code();
                        this.value = original.value();
                        this.subProperty = new ArrayList<>(original.subProperty());
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
                     * Sets {@code code}.
                     *
                     * @param code the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder code(FhirCode code) {
                        this.code = code;
                        return this;
                    }

                    /**
                     * Sets {@code code}, wrapped in a {@link FhirCode} without id or extensions.
                     *
                     * @param code the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder code(String code) {
                        return code(code == null ? null : FhirCode.of(code));
                    }

                    /**
                     * Sets {@code value} to a code.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(FhirCode value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value} to a code bound to an enum.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(FhirEnum<?> value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value} to a Coding.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(Coding value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value} to a string.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(FhirString value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value} to a integer.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(FhirInteger value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value} to a boolean.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(FhirBoolean value) {
                        this.value = value;
                        return this;
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
                     * Sets {@code value} to a decimal.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(FhirDecimal value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value} to a integer without id or extensions.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(Integer value) {
                        this.value = value == null ? null : FhirInteger.of(value);
                        return this;
                    }

                    /**
                     * Sets {@code value} to a boolean without id or extensions.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(Boolean value) {
                        this.value = value == null ? null : FhirBoolean.of(value);
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
                     * Sets {@code value} to a decimal without id or extensions.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(BigDecimal value) {
                        this.value = value == null ? null : FhirDecimal.of(value);
                        return this;
                    }

                    /**
                     * Replaces all {@code subProperty} values.
                     *
                     * @param subProperty the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder subProperty(List<ConceptSubProperty> subProperty) {
                        this.subProperty = subProperty == null ? new ArrayList<>() : new ArrayList<>(subProperty);
                        return this;
                    }

                    /**
                     * Adds a {@code subProperty} value.
                     *
                     * @param subProperty the value to add
                     * @return this builder
                     */
                    public Builder addSubProperty(ConceptSubProperty subProperty) {
                        this.subProperty.add(Objects.requireNonNull(subProperty, "subProperty"));
                        return this;
                    }

                    /**
                     * Builds the {@code ConceptProperty}.
                     *
                     * @return the {@code ConceptProperty}
                     * @throws NullPointerException if a required element is absent
                     */
                    public ConceptProperty build() {
                        return new ConceptProperty(
                                id, extension, modifierExtension, code, value, subProperty);
                    }
                }
            }

            /** Builder for {@link Contains}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirUri system;
                private FhirBoolean abstractValue;
                private FhirBoolean inactive;
                private FhirString version;
                private FhirCode code;
                private FhirString display;
                private List<ValueSet.Compose.ConceptSet.ConceptReference.Designation> designation =
                        new ArrayList<>();
                private List<ConceptProperty> property = new ArrayList<>();
                private List<ValueSet.Expansion.Contains> contains = new ArrayList<>();

                private Builder() {
                }

                private Builder(Contains original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.system = original.system();
                    this.abstractValue = original.abstractValue();
                    this.inactive = original.inactive();
                    this.version = original.version();
                    this.code = original.code();
                    this.display = original.display();
                    this.designation = new ArrayList<>(original.designation());
                    this.property = new ArrayList<>(original.property());
                    this.contains = new ArrayList<>(original.contains());
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
                 * Sets {@code system}.
                 *
                 * @param system the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder system(FhirUri system) {
                    this.system = system;
                    return this;
                }

                /**
                 * Sets {@code system}, wrapped in a {@link FhirUri} without id or extensions.
                 *
                 * @param system the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder system(String system) {
                    return system(system == null ? null : FhirUri.of(system));
                }

                /**
                 * Sets {@code abstractValue}.
                 *
                 * @param abstractValue the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder abstractValue(FhirBoolean abstractValue) {
                    this.abstractValue = abstractValue;
                    return this;
                }

                /**
                 * Sets {@code abstractValue}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param abstractValue the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder abstractValue(Boolean abstractValue) {
                    return abstractValue(abstractValue == null ? null : FhirBoolean.of(abstractValue));
                }

                /**
                 * Sets {@code inactive}.
                 *
                 * @param inactive the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder inactive(FhirBoolean inactive) {
                    this.inactive = inactive;
                    return this;
                }

                /**
                 * Sets {@code inactive}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param inactive the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder inactive(Boolean inactive) {
                    return inactive(inactive == null ? null : FhirBoolean.of(inactive));
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
                 * Sets {@code code}.
                 *
                 * @param code the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder code(FhirCode code) {
                    this.code = code;
                    return this;
                }

                /**
                 * Sets {@code code}, wrapped in a {@link FhirCode} without id or extensions.
                 *
                 * @param code the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder code(String code) {
                    return code(code == null ? null : FhirCode.of(code));
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
                 * Replaces all {@code designation} values.
                 *
                 * @param designation the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder designation(List<ValueSet.Compose.ConceptSet.ConceptReference.Designation> designation) {
                    this.designation = designation == null ? new ArrayList<>() : new ArrayList<>(designation);
                    return this;
                }

                /**
                 * Adds a {@code designation} value.
                 *
                 * @param designation the value to add
                 * @return this builder
                 */
                public Builder addDesignation(ValueSet.Compose.ConceptSet.ConceptReference.Designation designation) {
                    this.designation.add(Objects.requireNonNull(designation, "designation"));
                    return this;
                }

                /**
                 * Replaces all {@code property} values.
                 *
                 * @param property the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder property(List<ConceptProperty> property) {
                    this.property = property == null ? new ArrayList<>() : new ArrayList<>(property);
                    return this;
                }

                /**
                 * Adds a {@code property} value.
                 *
                 * @param property the value to add
                 * @return this builder
                 */
                public Builder addProperty(ConceptProperty property) {
                    this.property.add(Objects.requireNonNull(property, "property"));
                    return this;
                }

                /**
                 * Replaces all {@code contains} values.
                 *
                 * @param contains the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder contains(List<ValueSet.Expansion.Contains> contains) {
                    this.contains = contains == null ? new ArrayList<>() : new ArrayList<>(contains);
                    return this;
                }

                /**
                 * Adds a {@code contains} value.
                 *
                 * @param contains the value to add
                 * @return this builder
                 */
                public Builder addContains(ValueSet.Expansion.Contains contains) {
                    this.contains.add(Objects.requireNonNull(contains, "contains"));
                    return this;
                }

                /**
                 * Builds the {@code Contains}.
                 *
                 * @return the {@code Contains}
                 */
                public Contains build() {
                    return new Contains(
                            id, extension, modifierExtension, system, abstractValue, inactive, version, code, display,
                            designation, property, contains);
                }
            }
        }

        /** Builder for {@link Expansion}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirUri identifier;
            private FhirUri next;
            private FhirDateTime timestamp;
            private FhirInteger total;
            private FhirInteger offset;
            private List<Parameter> parameter = new ArrayList<>();
            private List<Property> property = new ArrayList<>();
            private List<Contains> contains = new ArrayList<>();

            private Builder() {
            }

            private Builder(Expansion original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = original.identifier();
                this.next = original.next();
                this.timestamp = original.timestamp();
                this.total = original.total();
                this.offset = original.offset();
                this.parameter = new ArrayList<>(original.parameter());
                this.property = new ArrayList<>(original.property());
                this.contains = new ArrayList<>(original.contains());
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
             * Sets {@code identifier}.
             *
             * @param identifier the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identifier(FhirUri identifier) {
                this.identifier = identifier;
                return this;
            }

            /**
             * Sets {@code identifier}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param identifier the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identifier(String identifier) {
                return identifier(identifier == null ? null : FhirUri.of(identifier));
            }

            /**
             * Sets {@code next}.
             *
             * @param next the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder next(FhirUri next) {
                this.next = next;
                return this;
            }

            /**
             * Sets {@code next}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param next the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder next(String next) {
                return next(next == null ? null : FhirUri.of(next));
            }

            /**
             * Sets {@code timestamp}.
             *
             * @param timestamp the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder timestamp(FhirDateTime timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            /**
             * Sets {@code timestamp}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param timestamp the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder timestamp(Temporal timestamp) {
                return timestamp(timestamp == null ? null : FhirDateTime.of(timestamp));
            }

            /**
             * Sets {@code total}.
             *
             * @param total the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder total(FhirInteger total) {
                this.total = total;
                return this;
            }

            /**
             * Sets {@code total}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param total the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder total(Integer total) {
                return total(total == null ? null : FhirInteger.of(total));
            }

            /**
             * Sets {@code offset}.
             *
             * @param offset the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder offset(FhirInteger offset) {
                this.offset = offset;
                return this;
            }

            /**
             * Sets {@code offset}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param offset the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder offset(Integer offset) {
                return offset(offset == null ? null : FhirInteger.of(offset));
            }

            /**
             * Replaces all {@code parameter} values.
             *
             * @param parameter the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder parameter(List<Parameter> parameter) {
                this.parameter = parameter == null ? new ArrayList<>() : new ArrayList<>(parameter);
                return this;
            }

            /**
             * Adds a {@code parameter} value.
             *
             * @param parameter the value to add
             * @return this builder
             */
            public Builder addParameter(Parameter parameter) {
                this.parameter.add(Objects.requireNonNull(parameter, "parameter"));
                return this;
            }

            /**
             * Replaces all {@code property} values.
             *
             * @param property the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder property(List<Property> property) {
                this.property = property == null ? new ArrayList<>() : new ArrayList<>(property);
                return this;
            }

            /**
             * Adds a {@code property} value.
             *
             * @param property the value to add
             * @return this builder
             */
            public Builder addProperty(Property property) {
                this.property.add(Objects.requireNonNull(property, "property"));
                return this;
            }

            /**
             * Replaces all {@code contains} values.
             *
             * @param contains the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder contains(List<Contains> contains) {
                this.contains = contains == null ? new ArrayList<>() : new ArrayList<>(contains);
                return this;
            }

            /**
             * Adds a {@code contains} value.
             *
             * @param contains the value to add
             * @return this builder
             */
            public Builder addContains(Contains contains) {
                this.contains.add(Objects.requireNonNull(contains, "contains"));
                return this;
            }

            /**
             * Builds the {@code Expansion}.
             *
             * @return the {@code Expansion}
             * @throws NullPointerException if a required element is absent
             */
            public Expansion build() {
                return new Expansion(
                        id, extension, modifierExtension, identifier, next, timestamp, total, offset, parameter,
                        property, contains);
            }
        }
    }

    /**
     * Description of the semantic space the Value Set Expansion is intended to cover and should further clarify the
     * text in ValueSet.description.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param inclusionCriteria Criteria describing which concepts or codes should be included and why.
     * @param exclusionCriteria Criteria describing which concepts or codes should be excluded and why.
     */
    public record Scope(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString inclusionCriteria,
            FhirString exclusionCriteria) implements BackboneElement {

        /**
         * Creates a {@code Scope}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Scope {
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
            private FhirString inclusionCriteria;
            private FhirString exclusionCriteria;

            private Builder() {
            }

            private Builder(Scope original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.inclusionCriteria = original.inclusionCriteria();
                this.exclusionCriteria = original.exclusionCriteria();
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
             * Sets {@code inclusionCriteria}.
             *
             * @param inclusionCriteria the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder inclusionCriteria(FhirString inclusionCriteria) {
                this.inclusionCriteria = inclusionCriteria;
                return this;
            }

            /**
             * Sets {@code inclusionCriteria}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param inclusionCriteria the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder inclusionCriteria(String inclusionCriteria) {
                return inclusionCriteria(inclusionCriteria == null ? null : FhirString.of(inclusionCriteria));
            }

            /**
             * Sets {@code exclusionCriteria}.
             *
             * @param exclusionCriteria the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder exclusionCriteria(FhirString exclusionCriteria) {
                this.exclusionCriteria = exclusionCriteria;
                return this;
            }

            /**
             * Sets {@code exclusionCriteria}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param exclusionCriteria the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder exclusionCriteria(String exclusionCriteria) {
                return exclusionCriteria(exclusionCriteria == null ? null : FhirString.of(exclusionCriteria));
            }

            /**
             * Builds the {@code Scope}.
             *
             * @return the {@code Scope}
             */
            public Scope build() {
                return new Scope(
                        id, extension, modifierExtension, inclusionCriteria, exclusionCriteria);
            }
        }
    }

    /** Builder for {@link ValueSet}. Builders are mutable and not thread-safe. */
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
        private FhirBoolean immutable;
        private FhirMarkdown purpose;
        private FhirMarkdown copyright;
        private FhirString copyrightLabel;
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private Period effectivePeriod;
        private List<CodeableConcept> topic = new ArrayList<>();
        private List<ContactDetail> author = new ArrayList<>();
        private List<ContactDetail> editor = new ArrayList<>();
        private List<ContactDetail> reviewer = new ArrayList<>();
        private List<ContactDetail> endorser = new ArrayList<>();
        private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
        private Compose compose;
        private Expansion expansion;
        private Scope scope;

        private Builder() {
        }

        private Builder(ValueSet original) {
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
            this.immutable = original.immutable();
            this.purpose = original.purpose();
            this.copyright = original.copyright();
            this.copyrightLabel = original.copyrightLabel();
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.effectivePeriod = original.effectivePeriod();
            this.topic = new ArrayList<>(original.topic());
            this.author = new ArrayList<>(original.author());
            this.editor = new ArrayList<>(original.editor());
            this.reviewer = new ArrayList<>(original.reviewer());
            this.endorser = new ArrayList<>(original.endorser());
            this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
            this.compose = original.compose();
            this.expansion = original.expansion();
            this.scope = original.scope();
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
         * Sets {@code immutable}.
         *
         * @param immutable the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder immutable(FhirBoolean immutable) {
            this.immutable = immutable;
            return this;
        }

        /**
         * Sets {@code immutable}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param immutable the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder immutable(Boolean immutable) {
            return immutable(immutable == null ? null : FhirBoolean.of(immutable));
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
         * Sets {@code approvalDate}.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(FhirDate approvalDate) {
            this.approvalDate = approvalDate;
            return this;
        }

        /**
         * Sets {@code approvalDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(Temporal approvalDate) {
            return approvalDate(approvalDate == null ? null : FhirDate.of(approvalDate));
        }

        /**
         * Sets {@code lastReviewDate}.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(FhirDate lastReviewDate) {
            this.lastReviewDate = lastReviewDate;
            return this;
        }

        /**
         * Sets {@code lastReviewDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(Temporal lastReviewDate) {
            return lastReviewDate(lastReviewDate == null ? null : FhirDate.of(lastReviewDate));
        }

        /**
         * Sets {@code effectivePeriod}.
         *
         * @param effectivePeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effectivePeriod(Period effectivePeriod) {
            this.effectivePeriod = effectivePeriod;
            return this;
        }

        /**
         * Replaces all {@code topic} values.
         *
         * @param topic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder topic(List<CodeableConcept> topic) {
            this.topic = topic == null ? new ArrayList<>() : new ArrayList<>(topic);
            return this;
        }

        /**
         * Adds a {@code topic} value.
         *
         * @param topic the value to add
         * @return this builder
         */
        public Builder addTopic(CodeableConcept topic) {
            this.topic.add(Objects.requireNonNull(topic, "topic"));
            return this;
        }

        /**
         * Replaces all {@code author} values.
         *
         * @param author the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder author(List<ContactDetail> author) {
            this.author = author == null ? new ArrayList<>() : new ArrayList<>(author);
            return this;
        }

        /**
         * Adds a {@code author} value.
         *
         * @param author the value to add
         * @return this builder
         */
        public Builder addAuthor(ContactDetail author) {
            this.author.add(Objects.requireNonNull(author, "author"));
            return this;
        }

        /**
         * Replaces all {@code editor} values.
         *
         * @param editor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder editor(List<ContactDetail> editor) {
            this.editor = editor == null ? new ArrayList<>() : new ArrayList<>(editor);
            return this;
        }

        /**
         * Adds a {@code editor} value.
         *
         * @param editor the value to add
         * @return this builder
         */
        public Builder addEditor(ContactDetail editor) {
            this.editor.add(Objects.requireNonNull(editor, "editor"));
            return this;
        }

        /**
         * Replaces all {@code reviewer} values.
         *
         * @param reviewer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reviewer(List<ContactDetail> reviewer) {
            this.reviewer = reviewer == null ? new ArrayList<>() : new ArrayList<>(reviewer);
            return this;
        }

        /**
         * Adds a {@code reviewer} value.
         *
         * @param reviewer the value to add
         * @return this builder
         */
        public Builder addReviewer(ContactDetail reviewer) {
            this.reviewer.add(Objects.requireNonNull(reviewer, "reviewer"));
            return this;
        }

        /**
         * Replaces all {@code endorser} values.
         *
         * @param endorser the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder endorser(List<ContactDetail> endorser) {
            this.endorser = endorser == null ? new ArrayList<>() : new ArrayList<>(endorser);
            return this;
        }

        /**
         * Adds a {@code endorser} value.
         *
         * @param endorser the value to add
         * @return this builder
         */
        public Builder addEndorser(ContactDetail endorser) {
            this.endorser.add(Objects.requireNonNull(endorser, "endorser"));
            return this;
        }

        /**
         * Replaces all {@code relatedArtifact} values.
         *
         * @param relatedArtifact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relatedArtifact(List<RelatedArtifact> relatedArtifact) {
            this.relatedArtifact = relatedArtifact == null ? new ArrayList<>() : new ArrayList<>(relatedArtifact);
            return this;
        }

        /**
         * Adds a {@code relatedArtifact} value.
         *
         * @param relatedArtifact the value to add
         * @return this builder
         */
        public Builder addRelatedArtifact(RelatedArtifact relatedArtifact) {
            this.relatedArtifact.add(Objects.requireNonNull(relatedArtifact, "relatedArtifact"));
            return this;
        }

        /**
         * Sets {@code compose}.
         *
         * @param compose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder compose(Compose compose) {
            this.compose = compose;
            return this;
        }

        /**
         * Sets {@code expansion}.
         *
         * @param expansion the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expansion(Expansion expansion) {
            this.expansion = expansion;
            return this;
        }

        /**
         * Sets {@code scope}.
         *
         * @param scope the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder scope(Scope scope) {
            this.scope = scope;
            return this;
        }

        /**
         * Builds the {@code ValueSet}.
         *
         * @return the {@code ValueSet}
         * @throws NullPointerException if a required element is absent
         */
        public ValueSet build() {
            return new ValueSet(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, immutable, purpose, copyright, copyrightLabel,
                    approvalDate, lastReviewDate, effectivePeriod, topic, author, editor, reviewer, endorser,
                    relatedArtifact, compose, expansion, scope);
        }
    }
}
