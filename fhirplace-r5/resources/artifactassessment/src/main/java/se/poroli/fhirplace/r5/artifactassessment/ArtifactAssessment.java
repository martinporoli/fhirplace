package se.poroli.fhirplace.r5.artifactassessment;

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
import se.poroli.fhirplace.r5.datatypes.DataType;
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
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * This Resource provides one or more comments, classifiers or ratings about a Resource and supports attribution and
 * rights management metadata for the added content.
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
 * @param identifier Additional identifier for the artifact assessment.
 * @param title A short title for the assessment for use in displaying and selecting.
 * @param citeAs How to cite the comment or rating. One of Reference, markdown.
 * @param date Date last changed.
 * @param copyright Use and/or publishing restrictions.
 * @param approvalDate When the artifact assessment was approved by publisher.
 * @param lastReviewDate When the artifact assessment was last reviewed by the publisher.
 * @param artifact The artifact assessed, commented upon or rated. One of Reference, canonical, uri. Required.
 * @param content Comment, classifier, or rating content.
 * @param workflowStatus submitted | triaged | waiting-for-input | resolved-no-change | resolved-change-required |
 *   deferred | duplicate | applied | published | entered-in-error.
 * @param disposition unresolved | not-persuasive | persuasive | persuasive-with-modification |
 *   not-persuasive-with-modification.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ArtifactAssessment">FHIR R5 ArtifactAssessment</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record ArtifactAssessment(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirString title,
        DataType citeAs,
        FhirDateTime date,
        FhirMarkdown copyright,
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        DataType artifact,
        List<Content> content,
        FhirEnum<ArtifactAssessmentWorkflowStatus> workflowStatus,
        FhirEnum<ArtifactAssessmentDisposition> disposition) implements DomainResource {

    /**
     * Creates an {@code ArtifactAssessment}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ArtifactAssessment {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        content = content == null ? List.of() : List.copyOf(content);
        Objects.requireNonNull(artifact, "ArtifactAssessment.artifact is required");
        if (citeAs != null && !(citeAs instanceof Reference || citeAs instanceof FhirMarkdown)) {
            throw new IllegalArgumentException(
                    "ArtifactAssessment.citeAs[x] must be one of Reference, markdown, but was "
                            + citeAs.getClass().getSimpleName());
        }
        if (artifact != null && !(artifact instanceof Reference
                || artifact instanceof FhirCanonical
                || artifact instanceof FhirUri)) {
            throw new IllegalArgumentException(
                    "ArtifactAssessment.artifact[x] must be one of Reference, canonical, uri, but was "
                            + artifact.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code ArtifactAssessment}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A component comment, classifier, or rating of the artifact.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param informationType comment | classifier | rating | container | response | change-request.
     * @param summary Brief summary of the content.
     * @param type What type of content.
     * @param classifier Rating, classifier, or assessment.
     * @param quantity Quantitative rating.
     * @param author Who authored the content. Reference to Patient, Practitioner, PractitionerRole, Organization,
     *   Device.
     * @param path What the comment is directed to.
     * @param relatedArtifact Additional information.
     * @param freeToShare Acceptable to publicly share the resource content.
     * @param component Contained content.
     */
    public record Content(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<ArtifactAssessmentInformationType> informationType,
            FhirMarkdown summary,
            CodeableConcept type,
            List<CodeableConcept> classifier,
            Quantity quantity,
            Reference author,
            List<FhirUri> path,
            List<RelatedArtifact> relatedArtifact,
            FhirBoolean freeToShare,
            List<ArtifactAssessment.Content> component) implements BackboneElement {

        /**
         * Creates a {@code Content}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Content {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            classifier = classifier == null ? List.of() : List.copyOf(classifier);
            path = path == null ? List.of() : List.copyOf(path);
            relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
            component = component == null ? List.of() : List.copyOf(component);
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
         * Returns a builder initialized with the values of this {@code Content}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Content}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<ArtifactAssessmentInformationType> informationType;
            private FhirMarkdown summary;
            private CodeableConcept type;
            private List<CodeableConcept> classifier = new ArrayList<>();
            private Quantity quantity;
            private Reference author;
            private List<FhirUri> path = new ArrayList<>();
            private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
            private FhirBoolean freeToShare;
            private List<ArtifactAssessment.Content> component = new ArrayList<>();

            private Builder() {
            }

            private Builder(Content original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.informationType = original.informationType();
                this.summary = original.summary();
                this.type = original.type();
                this.classifier = new ArrayList<>(original.classifier());
                this.quantity = original.quantity();
                this.author = original.author();
                this.path = new ArrayList<>(original.path());
                this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
                this.freeToShare = original.freeToShare();
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
             * Sets {@code informationType}.
             *
             * @param informationType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder informationType(FhirEnum<ArtifactAssessmentInformationType> informationType) {
                this.informationType = informationType;
                return this;
            }

            /**
             * Sets {@code informationType}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param informationType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder informationType(ArtifactAssessmentInformationType informationType) {
                return informationType(informationType == null ? null : FhirEnum.of(informationType));
            }

            /**
             * Sets {@code summary}.
             *
             * @param summary the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder summary(FhirMarkdown summary) {
                this.summary = summary;
                return this;
            }

            /**
             * Sets {@code summary}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param summary the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder summary(String summary) {
                return summary(summary == null ? null : FhirMarkdown.of(summary));
            }

            /**
             * Sets {@code type}.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(CodeableConcept type) {
                this.type = type;
                return this;
            }

            /**
             * Replaces all {@code classifier} values.
             *
             * @param classifier the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder classifier(List<CodeableConcept> classifier) {
                this.classifier = classifier == null ? new ArrayList<>() : new ArrayList<>(classifier);
                return this;
            }

            /**
             * Adds a {@code classifier} value.
             *
             * @param classifier the value to add
             * @return this builder
             */
            public Builder addClassifier(CodeableConcept classifier) {
                this.classifier.add(Objects.requireNonNull(classifier, "classifier"));
                return this;
            }

            /**
             * Sets {@code quantity}.
             *
             * @param quantity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder quantity(Quantity quantity) {
                this.quantity = quantity;
                return this;
            }

            /**
             * Sets {@code author}.
             *
             * @param author the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder author(Reference author) {
                this.author = author;
                return this;
            }

            /**
             * Replaces all {@code path} values.
             *
             * @param path the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder path(List<FhirUri> path) {
                this.path = path == null ? new ArrayList<>() : new ArrayList<>(path);
                return this;
            }

            /**
             * Adds a {@code path} value.
             *
             * @param path the value to add
             * @return this builder
             */
            public Builder addPath(FhirUri path) {
                this.path.add(Objects.requireNonNull(path, "path"));
                return this;
            }

            /**
             * Adds a {@code path} value, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param path the value to add
             * @return this builder
             */
            public Builder addPath(String path) {
                return addPath(FhirUri.of(path));
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
             * Sets {@code freeToShare}.
             *
             * @param freeToShare the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder freeToShare(FhirBoolean freeToShare) {
                this.freeToShare = freeToShare;
                return this;
            }

            /**
             * Sets {@code freeToShare}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param freeToShare the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder freeToShare(Boolean freeToShare) {
                return freeToShare(freeToShare == null ? null : FhirBoolean.of(freeToShare));
            }

            /**
             * Replaces all {@code component} values.
             *
             * @param component the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder component(List<ArtifactAssessment.Content> component) {
                this.component = component == null ? new ArrayList<>() : new ArrayList<>(component);
                return this;
            }

            /**
             * Adds a {@code component} value.
             *
             * @param component the value to add
             * @return this builder
             */
            public Builder addComponent(ArtifactAssessment.Content component) {
                this.component.add(Objects.requireNonNull(component, "component"));
                return this;
            }

            /**
             * Builds the {@code Content}.
             *
             * @return the {@code Content}
             */
            public Content build() {
                return new Content(
                        id, extension, modifierExtension, informationType, summary, type, classifier, quantity,
                        author, path, relatedArtifact, freeToShare, component);
            }
        }
    }

    /** Builder for {@link ArtifactAssessment}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private List<Identifier> identifier = new ArrayList<>();
        private FhirString title;
        private DataType citeAs;
        private FhirDateTime date;
        private FhirMarkdown copyright;
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private DataType artifact;
        private List<Content> content = new ArrayList<>();
        private FhirEnum<ArtifactAssessmentWorkflowStatus> workflowStatus;
        private FhirEnum<ArtifactAssessmentDisposition> disposition;

        private Builder() {
        }

        private Builder(ArtifactAssessment original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.title = original.title();
            this.citeAs = original.citeAs();
            this.date = original.date();
            this.copyright = original.copyright();
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.artifact = original.artifact();
            this.content = new ArrayList<>(original.content());
            this.workflowStatus = original.workflowStatus();
            this.disposition = original.disposition();
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
         * Sets {@code citeAs} to a Reference.
         *
         * @param citeAs the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder citeAs(Reference citeAs) {
            this.citeAs = citeAs;
            return this;
        }

        /**
         * Sets {@code citeAs} to a markdown.
         *
         * @param citeAs the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder citeAs(FhirMarkdown citeAs) {
            this.citeAs = citeAs;
            return this;
        }

        /**
         * Sets {@code citeAs} to a markdown without id or extensions.
         *
         * @param citeAs the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder citeAs(String citeAs) {
            this.citeAs = citeAs == null ? null : FhirMarkdown.of(citeAs);
            return this;
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
         * Sets {@code artifact} to a Reference.
         *
         * @param artifact the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder artifact(Reference artifact) {
            this.artifact = artifact;
            return this;
        }

        /**
         * Sets {@code artifact} to a canonical.
         *
         * @param artifact the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder artifact(FhirCanonical artifact) {
            this.artifact = artifact;
            return this;
        }

        /**
         * Sets {@code artifact} to a uri.
         *
         * @param artifact the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder artifact(FhirUri artifact) {
            this.artifact = artifact;
            return this;
        }

        /**
         * Replaces all {@code content} values.
         *
         * @param content the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder content(List<Content> content) {
            this.content = content == null ? new ArrayList<>() : new ArrayList<>(content);
            return this;
        }

        /**
         * Adds a {@code content} value.
         *
         * @param content the value to add
         * @return this builder
         */
        public Builder addContent(Content content) {
            this.content.add(Objects.requireNonNull(content, "content"));
            return this;
        }

        /**
         * Sets {@code workflowStatus}.
         *
         * @param workflowStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder workflowStatus(FhirEnum<ArtifactAssessmentWorkflowStatus> workflowStatus) {
            this.workflowStatus = workflowStatus;
            return this;
        }

        /**
         * Sets {@code workflowStatus}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param workflowStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder workflowStatus(ArtifactAssessmentWorkflowStatus workflowStatus) {
            return workflowStatus(workflowStatus == null ? null : FhirEnum.of(workflowStatus));
        }

        /**
         * Sets {@code disposition}.
         *
         * @param disposition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder disposition(FhirEnum<ArtifactAssessmentDisposition> disposition) {
            this.disposition = disposition;
            return this;
        }

        /**
         * Sets {@code disposition}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param disposition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder disposition(ArtifactAssessmentDisposition disposition) {
            return disposition(disposition == null ? null : FhirEnum.of(disposition));
        }

        /**
         * Builds the {@code ArtifactAssessment}.
         *
         * @return the {@code ArtifactAssessment}
         * @throws NullPointerException if a required element is absent
         */
        public ArtifactAssessment build() {
            return new ArtifactAssessment(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    title, citeAs, date, copyright, approvalDate, lastReviewDate, artifact, content, workflowStatus,
                    disposition);
        }
    }
}
