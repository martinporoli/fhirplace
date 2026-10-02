package se.poroli.fhirplace.r5.chargeitemdefinition;

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
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate
 * costs and prices.
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
 * @param url Canonical identifier for this charge item definition, represented as a URI (globally unique).
 * @param identifier Additional identifier for the charge item definition.
 * @param version Business version of the charge item definition.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this charge item definition (computer friendly).
 * @param title Name for this charge item definition (human friendly).
 * @param derivedFromUri Underlying externally-defined charge item definition.
 * @param partOf A larger definition of which this particular definition is a component or step. Canonical reference
 *   to ChargeItemDefinition.
 * @param replaces Completed or terminated request(s) whose function is taken by this new request. Canonical reference
 *   to ChargeItemDefinition.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the charge item definition.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for charge item definition (if applicable).
 * @param purpose Why this charge item definition is defined.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param approvalDate When the charge item definition was approved by publisher.
 * @param lastReviewDate When the charge item definition was last reviewed by the publisher.
 * @param code Billing code or product type this definition applies to.
 * @param instance Instances this definition applies to. Reference to Medication, Substance, Device, DeviceDefinition,
 *   ActivityDefinition, PlanDefinition, HealthcareService.
 * @param applicability Whether or not the billing code is applicable.
 * @param propertyGroup Group of properties which are applicable under the same conditions.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ChargeItemDefinition">FHIR R5 ChargeItemDefinition</a>
 */
public record ChargeItemDefinition(
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
        List<FhirUri> derivedFromUri,
        List<FhirCanonical> partOf,
        List<FhirCanonical> replaces,
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
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        CodeableConcept code,
        List<Reference> instance,
        List<Applicability> applicability,
        List<PropertyGroup> propertyGroup) implements DomainResource {

    /**
     * Creates a {@code ChargeItemDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ChargeItemDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        derivedFromUri = derivedFromUri == null ? List.of() : List.copyOf(derivedFromUri);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        replaces = replaces == null ? List.of() : List.copyOf(replaces);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        instance = instance == null ? List.of() : List.copyOf(instance);
        applicability = applicability == null ? List.of() : List.copyOf(applicability);
        propertyGroup = propertyGroup == null ? List.of() : List.copyOf(propertyGroup);
        Objects.requireNonNull(status, "ChargeItemDefinition.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "ChargeItemDefinition.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code ChargeItemDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Expressions that describe applicability criteria for the billing code.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param condition Boolean-valued expression.
     * @param effectivePeriod When the charge item definition is expected to be used.
     * @param relatedArtifact Reference to / quotation of the external source of the group of properties.
     */
    public record Applicability(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Expression condition,
            Period effectivePeriod,
            RelatedArtifact relatedArtifact) implements BackboneElement {

        /**
         * Creates an {@code Applicability}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Applicability {
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
         * Returns a builder initialized with the values of this {@code Applicability}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Applicability}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Expression condition;
            private Period effectivePeriod;
            private RelatedArtifact relatedArtifact;

            private Builder() {
            }

            private Builder(Applicability original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.condition = original.condition();
                this.effectivePeriod = original.effectivePeriod();
                this.relatedArtifact = original.relatedArtifact();
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
             * Sets {@code condition}.
             *
             * @param condition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder condition(Expression condition) {
                this.condition = condition;
                return this;
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
             * Sets {@code relatedArtifact}.
             *
             * @param relatedArtifact the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder relatedArtifact(RelatedArtifact relatedArtifact) {
                this.relatedArtifact = relatedArtifact;
                return this;
            }

            /**
             * Builds the {@code Applicability}.
             *
             * @return the {@code Applicability}
             */
            public Applicability build() {
                return new Applicability(
                        id, extension, modifierExtension, condition, effectivePeriod, relatedArtifact);
            }
        }
    }

    /**
     * Group of properties which are applicable under the same conditions.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param applicability Conditions under which the priceComponent is applicable.
     * @param priceComponent Components of total line item price.
     */
    public record PropertyGroup(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<ChargeItemDefinition.Applicability> applicability,
            List<MonetaryComponent> priceComponent) implements BackboneElement {

        /**
         * Creates a {@code PropertyGroup}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public PropertyGroup {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            applicability = applicability == null ? List.of() : List.copyOf(applicability);
            priceComponent = priceComponent == null ? List.of() : List.copyOf(priceComponent);
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
         * Returns a builder initialized with the values of this {@code PropertyGroup}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link PropertyGroup}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<ChargeItemDefinition.Applicability> applicability = new ArrayList<>();
            private List<MonetaryComponent> priceComponent = new ArrayList<>();

            private Builder() {
            }

            private Builder(PropertyGroup original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.applicability = new ArrayList<>(original.applicability());
                this.priceComponent = new ArrayList<>(original.priceComponent());
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
             * Replaces all {@code applicability} values.
             *
             * @param applicability the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder applicability(List<ChargeItemDefinition.Applicability> applicability) {
                this.applicability = applicability == null ? new ArrayList<>() : new ArrayList<>(applicability);
                return this;
            }

            /**
             * Adds a {@code applicability} value.
             *
             * @param applicability the value to add
             * @return this builder
             */
            public Builder addApplicability(ChargeItemDefinition.Applicability applicability) {
                this.applicability.add(Objects.requireNonNull(applicability, "applicability"));
                return this;
            }

            /**
             * Replaces all {@code priceComponent} values.
             *
             * @param priceComponent the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder priceComponent(List<MonetaryComponent> priceComponent) {
                this.priceComponent = priceComponent == null ? new ArrayList<>() : new ArrayList<>(priceComponent);
                return this;
            }

            /**
             * Adds a {@code priceComponent} value.
             *
             * @param priceComponent the value to add
             * @return this builder
             */
            public Builder addPriceComponent(MonetaryComponent priceComponent) {
                this.priceComponent.add(Objects.requireNonNull(priceComponent, "priceComponent"));
                return this;
            }

            /**
             * Builds the {@code PropertyGroup}.
             *
             * @return the {@code PropertyGroup}
             */
            public PropertyGroup build() {
                return new PropertyGroup(
                        id, extension, modifierExtension, applicability, priceComponent);
            }
        }
    }

    /** Builder for {@link ChargeItemDefinition}. Builders are mutable and not thread-safe. */
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
        private List<FhirUri> derivedFromUri = new ArrayList<>();
        private List<FhirCanonical> partOf = new ArrayList<>();
        private List<FhirCanonical> replaces = new ArrayList<>();
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
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private CodeableConcept code;
        private List<Reference> instance = new ArrayList<>();
        private List<Applicability> applicability = new ArrayList<>();
        private List<PropertyGroup> propertyGroup = new ArrayList<>();

        private Builder() {
        }

        private Builder(ChargeItemDefinition original) {
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
            this.derivedFromUri = new ArrayList<>(original.derivedFromUri());
            this.partOf = new ArrayList<>(original.partOf());
            this.replaces = new ArrayList<>(original.replaces());
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
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.code = original.code();
            this.instance = new ArrayList<>(original.instance());
            this.applicability = new ArrayList<>(original.applicability());
            this.propertyGroup = new ArrayList<>(original.propertyGroup());
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
         * Replaces all {@code derivedFromUri} values.
         *
         * @param derivedFromUri the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder derivedFromUri(List<FhirUri> derivedFromUri) {
            this.derivedFromUri = derivedFromUri == null ? new ArrayList<>() : new ArrayList<>(derivedFromUri);
            return this;
        }

        /**
         * Adds a {@code derivedFromUri} value.
         *
         * @param derivedFromUri the value to add
         * @return this builder
         */
        public Builder addDerivedFromUri(FhirUri derivedFromUri) {
            this.derivedFromUri.add(Objects.requireNonNull(derivedFromUri, "derivedFromUri"));
            return this;
        }

        /**
         * Adds a {@code derivedFromUri} value, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param derivedFromUri the value to add
         * @return this builder
         */
        public Builder addDerivedFromUri(String derivedFromUri) {
            return addDerivedFromUri(FhirUri.of(derivedFromUri));
        }

        /**
         * Replaces all {@code partOf} values.
         *
         * @param partOf the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder partOf(List<FhirCanonical> partOf) {
            this.partOf = partOf == null ? new ArrayList<>() : new ArrayList<>(partOf);
            return this;
        }

        /**
         * Adds a {@code partOf} value.
         *
         * @param partOf the value to add
         * @return this builder
         */
        public Builder addPartOf(FhirCanonical partOf) {
            this.partOf.add(Objects.requireNonNull(partOf, "partOf"));
            return this;
        }

        /**
         * Adds a {@code partOf} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param partOf the value to add
         * @return this builder
         */
        public Builder addPartOf(String partOf) {
            return addPartOf(FhirCanonical.of(partOf));
        }

        /**
         * Replaces all {@code replaces} values.
         *
         * @param replaces the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder replaces(List<FhirCanonical> replaces) {
            this.replaces = replaces == null ? new ArrayList<>() : new ArrayList<>(replaces);
            return this;
        }

        /**
         * Adds a {@code replaces} value.
         *
         * @param replaces the value to add
         * @return this builder
         */
        public Builder addReplaces(FhirCanonical replaces) {
            this.replaces.add(Objects.requireNonNull(replaces, "replaces"));
            return this;
        }

        /**
         * Adds a {@code replaces} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param replaces the value to add
         * @return this builder
         */
        public Builder addReplaces(String replaces) {
            return addReplaces(FhirCanonical.of(replaces));
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
         * Sets {@code code}.
         *
         * @param code the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder code(CodeableConcept code) {
            this.code = code;
            return this;
        }

        /**
         * Replaces all {@code instance} values.
         *
         * @param instance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder instance(List<Reference> instance) {
            this.instance = instance == null ? new ArrayList<>() : new ArrayList<>(instance);
            return this;
        }

        /**
         * Adds a {@code instance} value.
         *
         * @param instance the value to add
         * @return this builder
         */
        public Builder addInstance(Reference instance) {
            this.instance.add(Objects.requireNonNull(instance, "instance"));
            return this;
        }

        /**
         * Replaces all {@code applicability} values.
         *
         * @param applicability the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder applicability(List<Applicability> applicability) {
            this.applicability = applicability == null ? new ArrayList<>() : new ArrayList<>(applicability);
            return this;
        }

        /**
         * Adds a {@code applicability} value.
         *
         * @param applicability the value to add
         * @return this builder
         */
        public Builder addApplicability(Applicability applicability) {
            this.applicability.add(Objects.requireNonNull(applicability, "applicability"));
            return this;
        }

        /**
         * Replaces all {@code propertyGroup} values.
         *
         * @param propertyGroup the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder propertyGroup(List<PropertyGroup> propertyGroup) {
            this.propertyGroup = propertyGroup == null ? new ArrayList<>() : new ArrayList<>(propertyGroup);
            return this;
        }

        /**
         * Adds a {@code propertyGroup} value.
         *
         * @param propertyGroup the value to add
         * @return this builder
         */
        public Builder addPropertyGroup(PropertyGroup propertyGroup) {
            this.propertyGroup.add(Objects.requireNonNull(propertyGroup, "propertyGroup"));
            return this;
        }

        /**
         * Builds the {@code ChargeItemDefinition}.
         *
         * @return the {@code ChargeItemDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public ChargeItemDefinition build() {
            return new ChargeItemDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, derivedFromUri, partOf, replaces, status, experimental,
                    date, publisher, contact, description, useContext, jurisdiction, purpose, copyright,
                    copyrightLabel, approvalDate, lastReviewDate, code, instance, applicability, propertyGroup);
        }
    }
}
