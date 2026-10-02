package se.poroli.fhirplace.r5.specialized.definitionalartifacts;

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
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.ConformanceExpectation;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * The Requirements resource is used to describe an actor - a human or an application that plays a role in data
 * exchange, and that may have obligations associated with the role the actor plays.
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
 * @param url Canonical identifier for this Requirements, represented as a URI (globally unique).
 * @param identifier Additional identifier for the Requirements (business identifier).
 * @param version Business version of the Requirements.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this Requirements (computer friendly).
 * @param title Name for this Requirements (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the requirements.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for Requirements (if applicable).
 * @param purpose Why this Requirements is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param derivedFrom Other set of Requirements this builds on. Canonical reference to Requirements.
 * @param reference External artifact (rule/document etc. that) created this set of requirements.
 * @param actor Actor for these requirements. Canonical reference to ActorDefinition.
 * @param statement Actual statement as markdown.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Requirements">FHIR R5 Requirements</a>
 */
public record Requirements(
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
        List<FhirCanonical> derivedFrom,
        List<FhirUrl> reference,
        List<FhirCanonical> actor,
        List<Statement> statement) implements DomainResource {

    /**
     * Creates a {@code Requirements}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Requirements {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        derivedFrom = derivedFrom == null ? List.of() : List.copyOf(derivedFrom);
        reference = reference == null ? List.of() : List.copyOf(reference);
        actor = actor == null ? List.of() : List.copyOf(actor);
        statement = statement == null ? List.of() : List.copyOf(statement);
        Objects.requireNonNull(status, "Requirements.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "Requirements.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code Requirements}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The actual statement of requirement, in markdown format.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param key Key that identifies this statement. Required.
     * @param label Short Human label for this statement.
     * @param conformance SHALL | SHOULD | MAY | SHOULD-NOT.
     * @param conditionality Set to true if requirements statement is conditional.
     * @param requirement The actual requirement. Required.
     * @param derivedFrom Another statement this clarifies/restricts ([url#]key).
     * @param parent A larger requirement that this requirement helps to refine and enable.
     * @param satisfiedBy Design artifact that satisfies this requirement.
     * @param reference External artifact (rule/document etc. that) created this requirement.
     * @param source Who asked for this statement. Reference to CareTeam, Device, Group, HealthcareService,
     *   Organization, Patient, Practitioner, PractitionerRole, RelatedPerson.
     */
    public record Statement(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirId key,
            FhirString label,
            List<FhirEnum<ConformanceExpectation>> conformance,
            FhirBoolean conditionality,
            FhirMarkdown requirement,
            FhirString derivedFrom,
            FhirString parent,
            List<FhirUrl> satisfiedBy,
            List<FhirUrl> reference,
            List<Reference> source) implements BackboneElement {

        /**
         * Creates a {@code Statement}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Statement {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            conformance = conformance == null ? List.of() : List.copyOf(conformance);
            satisfiedBy = satisfiedBy == null ? List.of() : List.copyOf(satisfiedBy);
            reference = reference == null ? List.of() : List.copyOf(reference);
            source = source == null ? List.of() : List.copyOf(source);
            Objects.requireNonNull(key, "Requirements.statement.key is required");
            Objects.requireNonNull(requirement, "Requirements.statement.requirement is required");
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
         * Returns a builder initialized with the values of this {@code Statement}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Statement}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirId key;
            private FhirString label;
            private List<FhirEnum<ConformanceExpectation>> conformance = new ArrayList<>();
            private FhirBoolean conditionality;
            private FhirMarkdown requirement;
            private FhirString derivedFrom;
            private FhirString parent;
            private List<FhirUrl> satisfiedBy = new ArrayList<>();
            private List<FhirUrl> reference = new ArrayList<>();
            private List<Reference> source = new ArrayList<>();

            private Builder() {
            }

            private Builder(Statement original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.key = original.key();
                this.label = original.label();
                this.conformance = new ArrayList<>(original.conformance());
                this.conditionality = original.conditionality();
                this.requirement = original.requirement();
                this.derivedFrom = original.derivedFrom();
                this.parent = original.parent();
                this.satisfiedBy = new ArrayList<>(original.satisfiedBy());
                this.reference = new ArrayList<>(original.reference());
                this.source = new ArrayList<>(original.source());
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
            public Builder key(FhirId key) {
                this.key = key;
                return this;
            }

            /**
             * Sets {@code key}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param key the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder key(String key) {
                return key(key == null ? null : FhirId.of(key));
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
             * Replaces all {@code conformance} values.
             *
             * @param conformance the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder conformance(List<FhirEnum<ConformanceExpectation>> conformance) {
                this.conformance = conformance == null ? new ArrayList<>() : new ArrayList<>(conformance);
                return this;
            }

            /**
             * Adds a {@code conformance} value.
             *
             * @param conformance the value to add
             * @return this builder
             */
            public Builder addConformance(FhirEnum<ConformanceExpectation> conformance) {
                this.conformance.add(Objects.requireNonNull(conformance, "conformance"));
                return this;
            }

            /**
             * Adds a {@code conformance} value, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param conformance the value to add
             * @return this builder
             */
            public Builder addConformance(ConformanceExpectation conformance) {
                return addConformance(FhirEnum.of(conformance));
            }

            /**
             * Sets {@code conditionality}.
             *
             * @param conditionality the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder conditionality(FhirBoolean conditionality) {
                this.conditionality = conditionality;
                return this;
            }

            /**
             * Sets {@code conditionality}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param conditionality the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder conditionality(Boolean conditionality) {
                return conditionality(conditionality == null ? null : FhirBoolean.of(conditionality));
            }

            /**
             * Sets {@code requirement}.
             *
             * @param requirement the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder requirement(FhirMarkdown requirement) {
                this.requirement = requirement;
                return this;
            }

            /**
             * Sets {@code requirement}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param requirement the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder requirement(String requirement) {
                return requirement(requirement == null ? null : FhirMarkdown.of(requirement));
            }

            /**
             * Sets {@code derivedFrom}.
             *
             * @param derivedFrom the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder derivedFrom(FhirString derivedFrom) {
                this.derivedFrom = derivedFrom;
                return this;
            }

            /**
             * Sets {@code derivedFrom}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param derivedFrom the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder derivedFrom(String derivedFrom) {
                return derivedFrom(derivedFrom == null ? null : FhirString.of(derivedFrom));
            }

            /**
             * Sets {@code parent}.
             *
             * @param parent the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder parent(FhirString parent) {
                this.parent = parent;
                return this;
            }

            /**
             * Sets {@code parent}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param parent the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder parent(String parent) {
                return parent(parent == null ? null : FhirString.of(parent));
            }

            /**
             * Replaces all {@code satisfiedBy} values.
             *
             * @param satisfiedBy the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder satisfiedBy(List<FhirUrl> satisfiedBy) {
                this.satisfiedBy = satisfiedBy == null ? new ArrayList<>() : new ArrayList<>(satisfiedBy);
                return this;
            }

            /**
             * Adds a {@code satisfiedBy} value.
             *
             * @param satisfiedBy the value to add
             * @return this builder
             */
            public Builder addSatisfiedBy(FhirUrl satisfiedBy) {
                this.satisfiedBy.add(Objects.requireNonNull(satisfiedBy, "satisfiedBy"));
                return this;
            }

            /**
             * Adds a {@code satisfiedBy} value, wrapped in a {@link FhirUrl} without id or extensions.
             *
             * @param satisfiedBy the value to add
             * @return this builder
             */
            public Builder addSatisfiedBy(String satisfiedBy) {
                return addSatisfiedBy(FhirUrl.of(satisfiedBy));
            }

            /**
             * Replaces all {@code reference} values.
             *
             * @param reference the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder reference(List<FhirUrl> reference) {
                this.reference = reference == null ? new ArrayList<>() : new ArrayList<>(reference);
                return this;
            }

            /**
             * Adds a {@code reference} value.
             *
             * @param reference the value to add
             * @return this builder
             */
            public Builder addReference(FhirUrl reference) {
                this.reference.add(Objects.requireNonNull(reference, "reference"));
                return this;
            }

            /**
             * Adds a {@code reference} value, wrapped in a {@link FhirUrl} without id or extensions.
             *
             * @param reference the value to add
             * @return this builder
             */
            public Builder addReference(String reference) {
                return addReference(FhirUrl.of(reference));
            }

            /**
             * Replaces all {@code source} values.
             *
             * @param source the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder source(List<Reference> source) {
                this.source = source == null ? new ArrayList<>() : new ArrayList<>(source);
                return this;
            }

            /**
             * Adds a {@code source} value.
             *
             * @param source the value to add
             * @return this builder
             */
            public Builder addSource(Reference source) {
                this.source.add(Objects.requireNonNull(source, "source"));
                return this;
            }

            /**
             * Builds the {@code Statement}.
             *
             * @return the {@code Statement}
             * @throws NullPointerException if a required element is absent
             */
            public Statement build() {
                return new Statement(
                        id, extension, modifierExtension, key, label, conformance, conditionality, requirement,
                        derivedFrom, parent, satisfiedBy, reference, source);
            }
        }
    }

    /** Builder for {@link Requirements}. Builders are mutable and not thread-safe. */
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
        private List<FhirCanonical> derivedFrom = new ArrayList<>();
        private List<FhirUrl> reference = new ArrayList<>();
        private List<FhirCanonical> actor = new ArrayList<>();
        private List<Statement> statement = new ArrayList<>();

        private Builder() {
        }

        private Builder(Requirements original) {
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
            this.derivedFrom = new ArrayList<>(original.derivedFrom());
            this.reference = new ArrayList<>(original.reference());
            this.actor = new ArrayList<>(original.actor());
            this.statement = new ArrayList<>(original.statement());
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
         * Replaces all {@code derivedFrom} values.
         *
         * @param derivedFrom the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder derivedFrom(List<FhirCanonical> derivedFrom) {
            this.derivedFrom = derivedFrom == null ? new ArrayList<>() : new ArrayList<>(derivedFrom);
            return this;
        }

        /**
         * Adds a {@code derivedFrom} value.
         *
         * @param derivedFrom the value to add
         * @return this builder
         */
        public Builder addDerivedFrom(FhirCanonical derivedFrom) {
            this.derivedFrom.add(Objects.requireNonNull(derivedFrom, "derivedFrom"));
            return this;
        }

        /**
         * Adds a {@code derivedFrom} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param derivedFrom the value to add
         * @return this builder
         */
        public Builder addDerivedFrom(String derivedFrom) {
            return addDerivedFrom(FhirCanonical.of(derivedFrom));
        }

        /**
         * Replaces all {@code reference} values.
         *
         * @param reference the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reference(List<FhirUrl> reference) {
            this.reference = reference == null ? new ArrayList<>() : new ArrayList<>(reference);
            return this;
        }

        /**
         * Adds a {@code reference} value.
         *
         * @param reference the value to add
         * @return this builder
         */
        public Builder addReference(FhirUrl reference) {
            this.reference.add(Objects.requireNonNull(reference, "reference"));
            return this;
        }

        /**
         * Adds a {@code reference} value, wrapped in a {@link FhirUrl} without id or extensions.
         *
         * @param reference the value to add
         * @return this builder
         */
        public Builder addReference(String reference) {
            return addReference(FhirUrl.of(reference));
        }

        /**
         * Replaces all {@code actor} values.
         *
         * @param actor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder actor(List<FhirCanonical> actor) {
            this.actor = actor == null ? new ArrayList<>() : new ArrayList<>(actor);
            return this;
        }

        /**
         * Adds a {@code actor} value.
         *
         * @param actor the value to add
         * @return this builder
         */
        public Builder addActor(FhirCanonical actor) {
            this.actor.add(Objects.requireNonNull(actor, "actor"));
            return this;
        }

        /**
         * Adds a {@code actor} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param actor the value to add
         * @return this builder
         */
        public Builder addActor(String actor) {
            return addActor(FhirCanonical.of(actor));
        }

        /**
         * Replaces all {@code statement} values.
         *
         * @param statement the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder statement(List<Statement> statement) {
            this.statement = statement == null ? new ArrayList<>() : new ArrayList<>(statement);
            return this;
        }

        /**
         * Adds a {@code statement} value.
         *
         * @param statement the value to add
         * @return this builder
         */
        public Builder addStatement(Statement statement) {
            this.statement.add(Objects.requireNonNull(statement, "statement"));
            return this;
        }

        /**
         * Builds the {@code Requirements}.
         *
         * @return the {@code Requirements}
         * @throws NullPointerException if a required element is absent
         */
        public Requirements build() {
            return new Requirements(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, derivedFrom, reference,
                    actor, statement);
        }
    }
}
