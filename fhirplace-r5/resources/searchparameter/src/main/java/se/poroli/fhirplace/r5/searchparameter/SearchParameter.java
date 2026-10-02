package se.poroli.fhirplace.r5.searchparameter;

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
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.SearchComparator;
import se.poroli.fhirplace.r5.valuesets.SearchModifierCode;
import se.poroli.fhirplace.r5.valuesets.SearchParamType;

/**
 * A search parameter that defines a named search item that can be used to search/filter on a resource.
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
 * @param url Canonical identifier for this search parameter, represented as a URI (globally unique). Required.
 * @param identifier Additional identifier for the search parameter (business identifier).
 * @param version Business version of the search parameter.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this search parameter (computer friendly). Required.
 * @param title Name for this search parameter (human friendly).
 * @param derivedFrom Original definition for the search parameter. Canonical reference to SearchParameter.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the search parameter. Required.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for search parameter (if applicable).
 * @param purpose Why this search parameter is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param code Recommended name for parameter in search url. Required.
 * @param base The resource type(s) this search parameter applies to. Required.
 * @param type number | date | string | token | reference | composite | quantity | uri | special. Required.
 * @param expression FHIRPath expression that extracts the values.
 * @param processingMode normal | phonetic | other.
 * @param constraint FHIRPath expression that constraints the usage of this SearchParamete.
 * @param target Types of resource (if a resource reference).
 * @param multipleOr Allow multiple values per parameter (or).
 * @param multipleAnd Allow multiple parameters (and).
 * @param comparator eq | ne | gt | lt | ge | le | sa | eb | ap.
 * @param modifier missing | exact | contains | not | text | in | not-in | below | above | type | identifier | of-type
 *   | code-text | text-advanced | iterate.
 * @param chain Chained names supported.
 * @param component For Composite resources to define the parts.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/SearchParameter">FHIR R5 SearchParameter</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record SearchParameter(
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
        FhirCanonical derivedFrom,
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
        FhirCode code,
        List<FhirCode> base,
        FhirEnum<SearchParamType> type,
        FhirString expression,
        FhirEnum<SearchProcessingModeType> processingMode,
        FhirString constraint,
        List<FhirCode> target,
        FhirBoolean multipleOr,
        FhirBoolean multipleAnd,
        List<FhirEnum<SearchComparator>> comparator,
        List<FhirEnum<SearchModifierCode>> modifier,
        List<FhirString> chain,
        List<Component> component) implements DomainResource {

    /**
     * Creates a {@code SearchParameter}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public SearchParameter {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        base = base == null ? List.of() : List.copyOf(base);
        target = target == null ? List.of() : List.copyOf(target);
        comparator = comparator == null ? List.of() : List.copyOf(comparator);
        modifier = modifier == null ? List.of() : List.copyOf(modifier);
        chain = chain == null ? List.of() : List.copyOf(chain);
        component = component == null ? List.of() : List.copyOf(component);
        Objects.requireNonNull(url, "SearchParameter.url is required");
        Objects.requireNonNull(name, "SearchParameter.name is required");
        Objects.requireNonNull(status, "SearchParameter.status is required");
        Objects.requireNonNull(description, "SearchParameter.description is required");
        Objects.requireNonNull(code, "SearchParameter.code is required");
        if (base.isEmpty()) {
            throw new IllegalArgumentException("SearchParameter.base requires at least one value");
        }
        Objects.requireNonNull(type, "SearchParameter.type is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "SearchParameter.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code SearchParameter}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Used to define the parts of a composite search parameter.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param definition Defines how the part works. Canonical reference to SearchParameter. Required.
     * @param expression Subexpression relative to main expression. Required.
     */
    public record Component(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirCanonical definition,
            FhirString expression) implements BackboneElement {

        /**
         * Creates a {@code Component}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Component {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(definition, "SearchParameter.component.definition is required");
            Objects.requireNonNull(expression, "SearchParameter.component.expression is required");
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
         * Returns a builder initialized with the values of this {@code Component}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Component}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirCanonical definition;
            private FhirString expression;

            private Builder() {
            }

            private Builder(Component original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.definition = original.definition();
                this.expression = original.expression();
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
             * Sets {@code definition}.
             *
             * @param definition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definition(FhirCanonical definition) {
                this.definition = definition;
                return this;
            }

            /**
             * Sets {@code definition}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param definition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder definition(String definition) {
                return definition(definition == null ? null : FhirCanonical.of(definition));
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
             * Builds the {@code Component}.
             *
             * @return the {@code Component}
             * @throws NullPointerException if a required element is absent
             */
            public Component build() {
                return new Component(
                        id, extension, modifierExtension, definition, expression);
            }
        }
    }

    /** Builder for {@link SearchParameter}. Builders are mutable and not thread-safe. */
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
        private FhirCanonical derivedFrom;
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
        private FhirCode code;
        private List<FhirCode> base = new ArrayList<>();
        private FhirEnum<SearchParamType> type;
        private FhirString expression;
        private FhirEnum<SearchProcessingModeType> processingMode;
        private FhirString constraint;
        private List<FhirCode> target = new ArrayList<>();
        private FhirBoolean multipleOr;
        private FhirBoolean multipleAnd;
        private List<FhirEnum<SearchComparator>> comparator = new ArrayList<>();
        private List<FhirEnum<SearchModifierCode>> modifier = new ArrayList<>();
        private List<FhirString> chain = new ArrayList<>();
        private List<Component> component = new ArrayList<>();

        private Builder() {
        }

        private Builder(SearchParameter original) {
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
            this.derivedFrom = original.derivedFrom();
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
            this.code = original.code();
            this.base = new ArrayList<>(original.base());
            this.type = original.type();
            this.expression = original.expression();
            this.processingMode = original.processingMode();
            this.constraint = original.constraint();
            this.target = new ArrayList<>(original.target());
            this.multipleOr = original.multipleOr();
            this.multipleAnd = original.multipleAnd();
            this.comparator = new ArrayList<>(original.comparator());
            this.modifier = new ArrayList<>(original.modifier());
            this.chain = new ArrayList<>(original.chain());
            this.component = new ArrayList<>(original.component());
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
         * Sets {@code derivedFrom}.
         *
         * @param derivedFrom the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder derivedFrom(FhirCanonical derivedFrom) {
            this.derivedFrom = derivedFrom;
            return this;
        }

        /**
         * Sets {@code derivedFrom}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param derivedFrom the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder derivedFrom(String derivedFrom) {
            return derivedFrom(derivedFrom == null ? null : FhirCanonical.of(derivedFrom));
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
         * Replaces all {@code base} values.
         *
         * @param base the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder base(List<FhirCode> base) {
            this.base = base == null ? new ArrayList<>() : new ArrayList<>(base);
            return this;
        }

        /**
         * Adds a {@code base} value.
         *
         * @param base the value to add
         * @return this builder
         */
        public Builder addBase(FhirCode base) {
            this.base.add(Objects.requireNonNull(base, "base"));
            return this;
        }

        /**
         * Adds a {@code base} value, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param base the value to add
         * @return this builder
         */
        public Builder addBase(String base) {
            return addBase(FhirCode.of(base));
        }

        /**
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<SearchParamType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(SearchParamType type) {
            return type(type == null ? null : FhirEnum.of(type));
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
         * Sets {@code processingMode}.
         *
         * @param processingMode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder processingMode(FhirEnum<SearchProcessingModeType> processingMode) {
            this.processingMode = processingMode;
            return this;
        }

        /**
         * Sets {@code processingMode}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param processingMode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder processingMode(SearchProcessingModeType processingMode) {
            return processingMode(processingMode == null ? null : FhirEnum.of(processingMode));
        }

        /**
         * Sets {@code constraint}.
         *
         * @param constraint the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder constraint(FhirString constraint) {
            this.constraint = constraint;
            return this;
        }

        /**
         * Sets {@code constraint}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param constraint the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder constraint(String constraint) {
            return constraint(constraint == null ? null : FhirString.of(constraint));
        }

        /**
         * Replaces all {@code target} values.
         *
         * @param target the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder target(List<FhirCode> target) {
            this.target = target == null ? new ArrayList<>() : new ArrayList<>(target);
            return this;
        }

        /**
         * Adds a {@code target} value.
         *
         * @param target the value to add
         * @return this builder
         */
        public Builder addTarget(FhirCode target) {
            this.target.add(Objects.requireNonNull(target, "target"));
            return this;
        }

        /**
         * Adds a {@code target} value, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param target the value to add
         * @return this builder
         */
        public Builder addTarget(String target) {
            return addTarget(FhirCode.of(target));
        }

        /**
         * Sets {@code multipleOr}.
         *
         * @param multipleOr the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder multipleOr(FhirBoolean multipleOr) {
            this.multipleOr = multipleOr;
            return this;
        }

        /**
         * Sets {@code multipleOr}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param multipleOr the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder multipleOr(Boolean multipleOr) {
            return multipleOr(multipleOr == null ? null : FhirBoolean.of(multipleOr));
        }

        /**
         * Sets {@code multipleAnd}.
         *
         * @param multipleAnd the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder multipleAnd(FhirBoolean multipleAnd) {
            this.multipleAnd = multipleAnd;
            return this;
        }

        /**
         * Sets {@code multipleAnd}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param multipleAnd the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder multipleAnd(Boolean multipleAnd) {
            return multipleAnd(multipleAnd == null ? null : FhirBoolean.of(multipleAnd));
        }

        /**
         * Replaces all {@code comparator} values.
         *
         * @param comparator the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder comparator(List<FhirEnum<SearchComparator>> comparator) {
            this.comparator = comparator == null ? new ArrayList<>() : new ArrayList<>(comparator);
            return this;
        }

        /**
         * Adds a {@code comparator} value.
         *
         * @param comparator the value to add
         * @return this builder
         */
        public Builder addComparator(FhirEnum<SearchComparator> comparator) {
            this.comparator.add(Objects.requireNonNull(comparator, "comparator"));
            return this;
        }

        /**
         * Adds a {@code comparator} value, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param comparator the value to add
         * @return this builder
         */
        public Builder addComparator(SearchComparator comparator) {
            return addComparator(FhirEnum.of(comparator));
        }

        /**
         * Replaces all {@code modifier} values.
         *
         * @param modifier the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder modifier(List<FhirEnum<SearchModifierCode>> modifier) {
            this.modifier = modifier == null ? new ArrayList<>() : new ArrayList<>(modifier);
            return this;
        }

        /**
         * Adds a {@code modifier} value.
         *
         * @param modifier the value to add
         * @return this builder
         */
        public Builder addModifier(FhirEnum<SearchModifierCode> modifier) {
            this.modifier.add(Objects.requireNonNull(modifier, "modifier"));
            return this;
        }

        /**
         * Adds a {@code modifier} value, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param modifier the value to add
         * @return this builder
         */
        public Builder addModifier(SearchModifierCode modifier) {
            return addModifier(FhirEnum.of(modifier));
        }

        /**
         * Replaces all {@code chain} values.
         *
         * @param chain the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder chain(List<FhirString> chain) {
            this.chain = chain == null ? new ArrayList<>() : new ArrayList<>(chain);
            return this;
        }

        /**
         * Adds a {@code chain} value.
         *
         * @param chain the value to add
         * @return this builder
         */
        public Builder addChain(FhirString chain) {
            this.chain.add(Objects.requireNonNull(chain, "chain"));
            return this;
        }

        /**
         * Adds a {@code chain} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param chain the value to add
         * @return this builder
         */
        public Builder addChain(String chain) {
            return addChain(FhirString.of(chain));
        }

        /**
         * Replaces all {@code component} values.
         *
         * @param component the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder component(List<Component> component) {
            this.component = component == null ? new ArrayList<>() : new ArrayList<>(component);
            return this;
        }

        /**
         * Adds a {@code component} value.
         *
         * @param component the value to add
         * @return this builder
         */
        public Builder addComponent(Component component) {
            this.component.add(Objects.requireNonNull(component, "component"));
            return this;
        }

        /**
         * Builds the {@code SearchParameter}.
         *
         * @return the {@code SearchParameter}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public SearchParameter build() {
            return new SearchParameter(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, derivedFrom, status, experimental, date, publisher,
                    contact, description, useContext, jurisdiction, purpose, copyright, copyrightLabel, code, base,
                    type, expression, processingMode, constraint, target, multipleOr, multipleAnd, comparator,
                    modifier, chain, component);
        }
    }
}
