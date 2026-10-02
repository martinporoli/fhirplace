package se.poroli.fhirplace.r5.citation;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
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
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * The Citation Resource enables reference to any knowledge artifact for purposes of identification and attribution.
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
 * @param url Canonical identifier for this citation record, represented as a globally unique URI.
 * @param identifier Identifier for the citation record itself.
 * @param version Business version of the citation record.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this citation record (computer friendly).
 * @param title Name for this citation record (human friendly).
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param date Date last changed.
 * @param publisher The publisher of the citation record, not the publisher of the article or artifact being cited.
 * @param contact Contact details for the publisher of the citation record.
 * @param description Natural language description of the citation.
 * @param useContext The context that the citation record content is intended to support.
 * @param jurisdiction Intended jurisdiction for citation record (if applicable).
 * @param purpose Why this citation is defined.
 * @param copyright Use and/or publishing restrictions for the citation record, not for the cited artifact.
 * @param copyrightLabel Copyright holder and year(s) for the ciation record, not for the cited artifact.
 * @param approvalDate When the citation record was approved by publisher.
 * @param lastReviewDate When the citation record was last reviewed by the publisher.
 * @param effectivePeriod When the citation record is expected to be used.
 * @param author Who authored the citation record.
 * @param editor Who edited the citation record.
 * @param reviewer Who reviewed the citation record.
 * @param endorser Who endorsed the citation record.
 * @param summary A human-readable display of key concepts to represent the citation.
 * @param classification The assignment to an organizing scheme.
 * @param note Used for general notes and annotations not coded elsewhere.
 * @param currentState The status of the citation record.
 * @param statusDate An effective date or period for a status of the citation record.
 * @param relatedArtifact Artifact related to the citation record.
 * @param citedArtifact The article or artifact being described.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Citation">FHIR R5 Citation</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Citation(
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
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        Period effectivePeriod,
        List<ContactDetail> author,
        List<ContactDetail> editor,
        List<ContactDetail> reviewer,
        List<ContactDetail> endorser,
        List<Summary> summary,
        List<Classification> classification,
        List<Annotation> note,
        List<CodeableConcept> currentState,
        List<StatusDate> statusDate,
        List<RelatedArtifact> relatedArtifact,
        CitedArtifact citedArtifact) implements DomainResource {

    /**
     * Creates a {@code Citation}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Citation {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        author = author == null ? List.of() : List.copyOf(author);
        editor = editor == null ? List.of() : List.copyOf(editor);
        reviewer = reviewer == null ? List.of() : List.copyOf(reviewer);
        endorser = endorser == null ? List.of() : List.copyOf(endorser);
        summary = summary == null ? List.of() : List.copyOf(summary);
        classification = classification == null ? List.of() : List.copyOf(classification);
        note = note == null ? List.of() : List.copyOf(note);
        currentState = currentState == null ? List.of() : List.copyOf(currentState);
        statusDate = statusDate == null ? List.of() : List.copyOf(statusDate);
        relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
        Objects.requireNonNull(status, "Citation.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "Citation.versionAlgorithm[x] must be one of string, Coding, but was "
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
     * Returns a builder initialized with the values of this {@code Citation}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A human-readable display of key concepts to represent the citation.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param style Format for display of the citation summary.
     * @param text The human-readable display of the citation summary. Required.
     */
    public record Summary(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept style,
            FhirMarkdown text) implements BackboneElement {

        /**
         * Creates a {@code Summary}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Summary {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(text, "Citation.summary.text is required");
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
         * Returns a builder initialized with the values of this {@code Summary}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Summary}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept style;
            private FhirMarkdown text;

            private Builder() {
            }

            private Builder(Summary original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.style = original.style();
                this.text = original.text();
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
             * Sets {@code style}.
             *
             * @param style the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder style(CodeableConcept style) {
                this.style = style;
                return this;
            }

            /**
             * Sets {@code text}.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(FhirMarkdown text) {
                this.text = text;
                return this;
            }

            /**
             * Sets {@code text}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(String text) {
                return text(text == null ? null : FhirMarkdown.of(text));
            }

            /**
             * Builds the {@code Summary}.
             *
             * @return the {@code Summary}
             * @throws NullPointerException if a required element is absent
             */
            public Summary build() {
                return new Summary(
                        id, extension, modifierExtension, style, text);
            }
        }
    }

    /**
     * The assignment to an organizing scheme.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type The kind of classifier (e.g. publication type, keyword).
     * @param classifier The specific classification value.
     */
    public record Classification(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            List<CodeableConcept> classifier) implements BackboneElement {

        /**
         * Creates a {@code Classification}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Classification {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            classifier = classifier == null ? List.of() : List.copyOf(classifier);
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
         * Returns a builder initialized with the values of this {@code Classification}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Classification}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private List<CodeableConcept> classifier = new ArrayList<>();

            private Builder() {
            }

            private Builder(Classification original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.classifier = new ArrayList<>(original.classifier());
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
             * Builds the {@code Classification}.
             *
             * @return the {@code Classification}
             */
            public Classification build() {
                return new Classification(
                        id, extension, modifierExtension, type, classifier);
            }
        }
    }

    /**
     * The state or status of the citation record paired with an effective date or period for that state.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param activity Classification of the status. Required.
     * @param actual Either occurred or expected.
     * @param period When the status started and/or ended. Required.
     */
    public record StatusDate(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept activity,
            FhirBoolean actual,
            Period period) implements BackboneElement {

        /**
         * Creates a {@code StatusDate}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public StatusDate {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(activity, "Citation.statusDate.activity is required");
            Objects.requireNonNull(period, "Citation.statusDate.period is required");
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
         * Returns a builder initialized with the values of this {@code StatusDate}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link StatusDate}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept activity;
            private FhirBoolean actual;
            private Period period;

            private Builder() {
            }

            private Builder(StatusDate original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.activity = original.activity();
                this.actual = original.actual();
                this.period = original.period();
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
             * Sets {@code activity}.
             *
             * @param activity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder activity(CodeableConcept activity) {
                this.activity = activity;
                return this;
            }

            /**
             * Sets {@code actual}.
             *
             * @param actual the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder actual(FhirBoolean actual) {
                this.actual = actual;
                return this;
            }

            /**
             * Sets {@code actual}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param actual the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder actual(Boolean actual) {
                return actual(actual == null ? null : FhirBoolean.of(actual));
            }

            /**
             * Sets {@code period}.
             *
             * @param period the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder period(Period period) {
                this.period = period;
                return this;
            }

            /**
             * Builds the {@code StatusDate}.
             *
             * @return the {@code StatusDate}
             * @throws NullPointerException if a required element is absent
             */
            public StatusDate build() {
                return new StatusDate(
                        id, extension, modifierExtension, activity, actual, period);
            }
        }
    }

    /**
     * The article or artifact being described.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier Unique identifier. May include DOI, PMID, PMCID, etc.
     * @param relatedIdentifier Identifier not unique to the cited artifact. May include trial registry identifiers.
     * @param dateAccessed When the cited artifact was accessed.
     * @param version The defined version of the cited artifact.
     * @param currentState The status of the cited artifact.
     * @param statusDate An effective date or period for a status of the cited artifact.
     * @param title The title details of the article or artifact.
     * @param abstractValue Summary of the article or artifact. The FHIR element {@code abstract}.
     * @param part The component of the article or artifact.
     * @param relatesTo The artifact related to the cited artifact.
     * @param publicationForm If multiple, used to represent alternative forms of the article that are not separate
     *   citations.
     * @param webLocation Used for any URL for the article or artifact cited.
     * @param classification The assignment to an organizing scheme.
     * @param contributorship Attribution of authors and other contributors.
     * @param note Any additional information or content for the article or artifact.
     */
    public record CitedArtifact(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Identifier> identifier,
            List<Identifier> relatedIdentifier,
            FhirDateTime dateAccessed,
            Version version,
            List<CodeableConcept> currentState,
            List<StatusDate> statusDate,
            List<Title> title,
            List<AbstractValue> abstractValue,
            Part part,
            List<RelatesTo> relatesTo,
            List<PublicationForm> publicationForm,
            List<WebLocation> webLocation,
            List<Classification> classification,
            Contributorship contributorship,
            List<Annotation> note) implements BackboneElement {

        /**
         * Creates a {@code CitedArtifact}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public CitedArtifact {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            identifier = identifier == null ? List.of() : List.copyOf(identifier);
            relatedIdentifier = relatedIdentifier == null ? List.of() : List.copyOf(relatedIdentifier);
            currentState = currentState == null ? List.of() : List.copyOf(currentState);
            statusDate = statusDate == null ? List.of() : List.copyOf(statusDate);
            title = title == null ? List.of() : List.copyOf(title);
            abstractValue = abstractValue == null ? List.of() : List.copyOf(abstractValue);
            relatesTo = relatesTo == null ? List.of() : List.copyOf(relatesTo);
            publicationForm = publicationForm == null ? List.of() : List.copyOf(publicationForm);
            webLocation = webLocation == null ? List.of() : List.copyOf(webLocation);
            classification = classification == null ? List.of() : List.copyOf(classification);
            note = note == null ? List.of() : List.copyOf(note);
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
         * Returns a builder initialized with the values of this {@code CitedArtifact}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The defined version of the cited artifact.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param value The version number or other version identifier. Required.
         * @param baseCitation Citation for the main version of the cited artifact. Reference to Citation.
         */
        public record Version(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString value,
                Reference baseCitation) implements BackboneElement {

            /**
             * Creates a {@code Version}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Version {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(value, "Citation.citedArtifact.version.value is required");
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
                private FhirString value;
                private Reference baseCitation;

                private Builder() {
                }

                private Builder(Version original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.value = original.value();
                    this.baseCitation = original.baseCitation();
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
                 * Sets {@code baseCitation}.
                 *
                 * @param baseCitation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder baseCitation(Reference baseCitation) {
                    this.baseCitation = baseCitation;
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
                            id, extension, modifierExtension, value, baseCitation);
                }
            }
        }

        /**
         * An effective date or period, historical or future, actual or expected, for a status of the cited artifact.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param activity Classification of the status. Required.
         * @param actual Either occurred or expected.
         * @param period When the status started and/or ended. Required.
         */
        public record StatusDate(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept activity,
                FhirBoolean actual,
                Period period) implements BackboneElement {

            /**
             * Creates a {@code StatusDate}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public StatusDate {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(activity, "Citation.citedArtifact.statusDate.activity is required");
                Objects.requireNonNull(period, "Citation.citedArtifact.statusDate.period is required");
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
             * Returns a builder initialized with the values of this {@code StatusDate}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link StatusDate}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept activity;
                private FhirBoolean actual;
                private Period period;

                private Builder() {
                }

                private Builder(StatusDate original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.activity = original.activity();
                    this.actual = original.actual();
                    this.period = original.period();
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
                 * Sets {@code activity}.
                 *
                 * @param activity the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder activity(CodeableConcept activity) {
                    this.activity = activity;
                    return this;
                }

                /**
                 * Sets {@code actual}.
                 *
                 * @param actual the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder actual(FhirBoolean actual) {
                    this.actual = actual;
                    return this;
                }

                /**
                 * Sets {@code actual}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param actual the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder actual(Boolean actual) {
                    return actual(actual == null ? null : FhirBoolean.of(actual));
                }

                /**
                 * Sets {@code period}.
                 *
                 * @param period the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder period(Period period) {
                    this.period = period;
                    return this;
                }

                /**
                 * Builds the {@code StatusDate}.
                 *
                 * @return the {@code StatusDate}
                 * @throws NullPointerException if a required element is absent
                 */
                public StatusDate build() {
                    return new StatusDate(
                            id, extension, modifierExtension, activity, actual, period);
                }
            }
        }

        /**
         * The title details of the article or artifact.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type The kind of title.
         * @param language Used to express the specific language.
         * @param text The title of the article or artifact. Required.
         */
        public record Title(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<CodeableConcept> type,
                CodeableConcept language,
                FhirMarkdown text) implements BackboneElement {

            /**
             * Creates a {@code Title}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Title {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                type = type == null ? List.of() : List.copyOf(type);
                Objects.requireNonNull(text, "Citation.citedArtifact.title.text is required");
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
             * Returns a builder initialized with the values of this {@code Title}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Title}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<CodeableConcept> type = new ArrayList<>();
                private CodeableConcept language;
                private FhirMarkdown text;

                private Builder() {
                }

                private Builder(Title original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = new ArrayList<>(original.type());
                    this.language = original.language();
                    this.text = original.text();
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
                 * Sets {@code text}.
                 *
                 * @param text the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder text(FhirMarkdown text) {
                    this.text = text;
                    return this;
                }

                /**
                 * Sets {@code text}, wrapped in a {@link FhirMarkdown} without id or extensions.
                 *
                 * @param text the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder text(String text) {
                    return text(text == null ? null : FhirMarkdown.of(text));
                }

                /**
                 * Builds the {@code Title}.
                 *
                 * @return the {@code Title}
                 * @throws NullPointerException if a required element is absent
                 */
                public Title build() {
                    return new Title(
                            id, extension, modifierExtension, type, language, text);
                }
            }
        }

        /**
         * The abstract may be used to convey article-contained abstracts, externally-created abstracts, or other
         * descriptive summaries.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type The kind of abstract.
         * @param language Used to express the specific language.
         * @param text Abstract content. Required.
         * @param copyright Copyright notice for the abstract.
         */
        public record AbstractValue(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                CodeableConcept language,
                FhirMarkdown text,
                FhirMarkdown copyright) implements BackboneElement {

            /**
             * Creates an {@code AbstractValue}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public AbstractValue {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(text, "Citation.citedArtifact.abstract.text is required");
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
             * Returns a builder initialized with the values of this {@code AbstractValue}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link AbstractValue}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private CodeableConcept language;
                private FhirMarkdown text;
                private FhirMarkdown copyright;

                private Builder() {
                }

                private Builder(AbstractValue original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.language = original.language();
                    this.text = original.text();
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
                 * Sets {@code text}.
                 *
                 * @param text the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder text(FhirMarkdown text) {
                    this.text = text;
                    return this;
                }

                /**
                 * Sets {@code text}, wrapped in a {@link FhirMarkdown} without id or extensions.
                 *
                 * @param text the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder text(String text) {
                    return text(text == null ? null : FhirMarkdown.of(text));
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
                 * Builds the {@code AbstractValue}.
                 *
                 * @return the {@code AbstractValue}
                 * @throws NullPointerException if a required element is absent
                 */
                public AbstractValue build() {
                    return new AbstractValue(
                            id, extension, modifierExtension, type, language, text, copyright);
                }
            }
        }

        /**
         * The component of the article or artifact.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type The kind of component.
         * @param value The specification of the component.
         * @param baseCitation The citation for the full article or artifact. Reference to Citation.
         */
        public record Part(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                FhirString value,
                Reference baseCitation) implements BackboneElement {

            /**
             * Creates a {@code Part}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Part {
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
             * Returns a builder initialized with the values of this {@code Part}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Part}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private FhirString value;
                private Reference baseCitation;

                private Builder() {
                }

                private Builder(Part original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.value = original.value();
                    this.baseCitation = original.baseCitation();
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
                public Builder type(CodeableConcept type) {
                    this.type = type;
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
                 * Sets {@code baseCitation}.
                 *
                 * @param baseCitation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder baseCitation(Reference baseCitation) {
                    this.baseCitation = baseCitation;
                    return this;
                }

                /**
                 * Builds the {@code Part}.
                 *
                 * @return the {@code Part}
                 */
                public Part build() {
                    return new Part(
                            id, extension, modifierExtension, type, value, baseCitation);
                }
            }
        }

        /**
         * The artifact related to the cited artifact.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type documentation | justification | citation | predecessor | successor | derived-from | depends-on
         *   | composed-of | part-of | amends | amended-with | appends | appended-with | cites | cited-by |
         *   comments-on | comment-in | contains | contained-in | corrects | correction-in | replaces | replaced-with
         *   | retracts | retracted-by | signs | similar-to | supports | supported-with | transforms |
         *   transformed-into | transformed-with | documents | specification-of | created-with | cite-as | reprint |
         *   reprint-of. Required.
         * @param classifier Additional classifiers.
         * @param label Short label.
         * @param display Brief description of the related artifact.
         * @param citation Bibliographic citation for the artifact.
         * @param document What document is being referenced.
         * @param resource What artifact is being referenced.
         * @param resourceReference What artifact, if not a conformance resource.
         */
        public record RelatesTo(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirCode type,
                List<CodeableConcept> classifier,
                FhirString label,
                FhirString display,
                FhirMarkdown citation,
                Attachment document,
                FhirCanonical resource,
                Reference resourceReference) implements BackboneElement {

            /**
             * Creates a {@code RelatesTo}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public RelatesTo {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                classifier = classifier == null ? List.of() : List.copyOf(classifier);
                Objects.requireNonNull(type, "Citation.citedArtifact.relatesTo.type is required");
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
             * Returns a builder initialized with the values of this {@code RelatesTo}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link RelatesTo}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirCode type;
                private List<CodeableConcept> classifier = new ArrayList<>();
                private FhirString label;
                private FhirString display;
                private FhirMarkdown citation;
                private Attachment document;
                private FhirCanonical resource;
                private Reference resourceReference;

                private Builder() {
                }

                private Builder(RelatesTo original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.classifier = new ArrayList<>(original.classifier());
                    this.label = original.label();
                    this.display = original.display();
                    this.citation = original.citation();
                    this.document = original.document();
                    this.resource = original.resource();
                    this.resourceReference = original.resourceReference();
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
                 * Sets {@code citation}.
                 *
                 * @param citation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder citation(FhirMarkdown citation) {
                    this.citation = citation;
                    return this;
                }

                /**
                 * Sets {@code citation}, wrapped in a {@link FhirMarkdown} without id or extensions.
                 *
                 * @param citation the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder citation(String citation) {
                    return citation(citation == null ? null : FhirMarkdown.of(citation));
                }

                /**
                 * Sets {@code document}.
                 *
                 * @param document the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder document(Attachment document) {
                    this.document = document;
                    return this;
                }

                /**
                 * Sets {@code resource}.
                 *
                 * @param resource the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder resource(FhirCanonical resource) {
                    this.resource = resource;
                    return this;
                }

                /**
                 * Sets {@code resource}, wrapped in a {@link FhirCanonical} without id or extensions.
                 *
                 * @param resource the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder resource(String resource) {
                    return resource(resource == null ? null : FhirCanonical.of(resource));
                }

                /**
                 * Sets {@code resourceReference}.
                 *
                 * @param resourceReference the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder resourceReference(Reference resourceReference) {
                    this.resourceReference = resourceReference;
                    return this;
                }

                /**
                 * Builds the {@code RelatesTo}.
                 *
                 * @return the {@code RelatesTo}
                 * @throws NullPointerException if a required element is absent
                 */
                public RelatesTo build() {
                    return new RelatesTo(
                            id, extension, modifierExtension, type, classifier, label, display, citation, document,
                            resource, resourceReference);
                }
            }
        }

        /**
         * If multiple, used to represent alternative forms of the article that are not separate citations.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param publishedIn The collection the cited article or artifact is published in.
         * @param citedMedium Internet or Print.
         * @param volume Volume number of journal or other collection in which the article is published.
         * @param issue Issue, part or supplement of journal or other collection in which the article is published.
         * @param articleDate The date the article was added to the database, or the date the article was released.
         * @param publicationDateText Text representation of the date on which the issue of the cited artifact was
         *   published.
         * @param publicationDateSeason Season in which the cited artifact was published.
         * @param lastRevisionDate The date the article was last revised or updated in the database.
         * @param language Language(s) in which this form of the article is published.
         * @param accessionNumber Entry number or identifier for inclusion in a database.
         * @param pageString Used for full display of pagination.
         * @param firstPage Used for isolated representation of first page.
         * @param lastPage Used for isolated representation of last page.
         * @param pageCount Number of pages or screens.
         * @param copyright Copyright notice for the full article or artifact.
         */
        public record PublicationForm(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                PublishedIn publishedIn,
                CodeableConcept citedMedium,
                FhirString volume,
                FhirString issue,
                FhirDateTime articleDate,
                FhirString publicationDateText,
                FhirString publicationDateSeason,
                FhirDateTime lastRevisionDate,
                List<CodeableConcept> language,
                FhirString accessionNumber,
                FhirString pageString,
                FhirString firstPage,
                FhirString lastPage,
                FhirString pageCount,
                FhirMarkdown copyright) implements BackboneElement {

            /**
             * Creates a {@code PublicationForm}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public PublicationForm {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                language = language == null ? List.of() : List.copyOf(language);
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
             * Returns a builder initialized with the values of this {@code PublicationForm}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * The collection the cited article or artifact is published in.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param type Kind of container (e.g. Periodical, database, or book).
             * @param identifier Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers
             *   include ISBN.
             * @param title Name of the database or title of the book or journal.
             * @param publisher Name of or resource describing the publisher. Reference to Organization.
             * @param publisherLocation Geographic location of the publisher.
             */
            public record PublishedIn(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    CodeableConcept type,
                    List<Identifier> identifier,
                    FhirString title,
                    Reference publisher,
                    FhirString publisherLocation) implements BackboneElement {

                /**
                 * Creates a {@code PublishedIn}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 */
                public PublishedIn {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    identifier = identifier == null ? List.of() : List.copyOf(identifier);
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
                 * Returns a builder initialized with the values of this {@code PublishedIn}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link PublishedIn}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private CodeableConcept type;
                    private List<Identifier> identifier = new ArrayList<>();
                    private FhirString title;
                    private Reference publisher;
                    private FhirString publisherLocation;

                    private Builder() {
                    }

                    private Builder(PublishedIn original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.type = original.type();
                        this.identifier = new ArrayList<>(original.identifier());
                        this.title = original.title();
                        this.publisher = original.publisher();
                        this.publisherLocation = original.publisherLocation();
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
                    public Builder type(CodeableConcept type) {
                        this.type = type;
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
                     * Sets {@code publisher}.
                     *
                     * @param publisher the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder publisher(Reference publisher) {
                        this.publisher = publisher;
                        return this;
                    }

                    /**
                     * Sets {@code publisherLocation}.
                     *
                     * @param publisherLocation the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder publisherLocation(FhirString publisherLocation) {
                        this.publisherLocation = publisherLocation;
                        return this;
                    }

                    /**
                     * Sets {@code publisherLocation}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param publisherLocation the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder publisherLocation(String publisherLocation) {
                        return publisherLocation(publisherLocation == null ? null : FhirString.of(publisherLocation));
                    }

                    /**
                     * Builds the {@code PublishedIn}.
                     *
                     * @return the {@code PublishedIn}
                     */
                    public PublishedIn build() {
                        return new PublishedIn(
                                id, extension, modifierExtension, type, identifier, title, publisher,
                                publisherLocation);
                    }
                }
            }

            /** Builder for {@link PublicationForm}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private PublishedIn publishedIn;
                private CodeableConcept citedMedium;
                private FhirString volume;
                private FhirString issue;
                private FhirDateTime articleDate;
                private FhirString publicationDateText;
                private FhirString publicationDateSeason;
                private FhirDateTime lastRevisionDate;
                private List<CodeableConcept> language = new ArrayList<>();
                private FhirString accessionNumber;
                private FhirString pageString;
                private FhirString firstPage;
                private FhirString lastPage;
                private FhirString pageCount;
                private FhirMarkdown copyright;

                private Builder() {
                }

                private Builder(PublicationForm original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.publishedIn = original.publishedIn();
                    this.citedMedium = original.citedMedium();
                    this.volume = original.volume();
                    this.issue = original.issue();
                    this.articleDate = original.articleDate();
                    this.publicationDateText = original.publicationDateText();
                    this.publicationDateSeason = original.publicationDateSeason();
                    this.lastRevisionDate = original.lastRevisionDate();
                    this.language = new ArrayList<>(original.language());
                    this.accessionNumber = original.accessionNumber();
                    this.pageString = original.pageString();
                    this.firstPage = original.firstPage();
                    this.lastPage = original.lastPage();
                    this.pageCount = original.pageCount();
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
                 * Sets {@code publishedIn}.
                 *
                 * @param publishedIn the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder publishedIn(PublishedIn publishedIn) {
                    this.publishedIn = publishedIn;
                    return this;
                }

                /**
                 * Sets {@code citedMedium}.
                 *
                 * @param citedMedium the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder citedMedium(CodeableConcept citedMedium) {
                    this.citedMedium = citedMedium;
                    return this;
                }

                /**
                 * Sets {@code volume}.
                 *
                 * @param volume the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder volume(FhirString volume) {
                    this.volume = volume;
                    return this;
                }

                /**
                 * Sets {@code volume}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param volume the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder volume(String volume) {
                    return volume(volume == null ? null : FhirString.of(volume));
                }

                /**
                 * Sets {@code issue}.
                 *
                 * @param issue the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder issue(FhirString issue) {
                    this.issue = issue;
                    return this;
                }

                /**
                 * Sets {@code issue}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param issue the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder issue(String issue) {
                    return issue(issue == null ? null : FhirString.of(issue));
                }

                /**
                 * Sets {@code articleDate}.
                 *
                 * @param articleDate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder articleDate(FhirDateTime articleDate) {
                    this.articleDate = articleDate;
                    return this;
                }

                /**
                 * Sets {@code articleDate}, wrapped in a {@link FhirDateTime} without id or extensions.
                 *
                 * @param articleDate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder articleDate(Temporal articleDate) {
                    return articleDate(articleDate == null ? null : FhirDateTime.of(articleDate));
                }

                /**
                 * Sets {@code publicationDateText}.
                 *
                 * @param publicationDateText the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder publicationDateText(FhirString publicationDateText) {
                    this.publicationDateText = publicationDateText;
                    return this;
                }

                /**
                 * Sets {@code publicationDateText}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param publicationDateText the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder publicationDateText(String publicationDateText) {
                    return publicationDateText(
                            publicationDateText == null ? null : FhirString.of(publicationDateText));
                }

                /**
                 * Sets {@code publicationDateSeason}.
                 *
                 * @param publicationDateSeason the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder publicationDateSeason(FhirString publicationDateSeason) {
                    this.publicationDateSeason = publicationDateSeason;
                    return this;
                }

                /**
                 * Sets {@code publicationDateSeason}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param publicationDateSeason the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder publicationDateSeason(String publicationDateSeason) {
                    return publicationDateSeason(
                            publicationDateSeason == null ? null : FhirString.of(publicationDateSeason));
                }

                /**
                 * Sets {@code lastRevisionDate}.
                 *
                 * @param lastRevisionDate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder lastRevisionDate(FhirDateTime lastRevisionDate) {
                    this.lastRevisionDate = lastRevisionDate;
                    return this;
                }

                /**
                 * Sets {@code lastRevisionDate}, wrapped in a {@link FhirDateTime} without id or extensions.
                 *
                 * @param lastRevisionDate the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder lastRevisionDate(Temporal lastRevisionDate) {
                    return lastRevisionDate(lastRevisionDate == null ? null : FhirDateTime.of(lastRevisionDate));
                }

                /**
                 * Replaces all {@code language} values.
                 *
                 * @param language the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder language(List<CodeableConcept> language) {
                    this.language = language == null ? new ArrayList<>() : new ArrayList<>(language);
                    return this;
                }

                /**
                 * Adds a {@code language} value.
                 *
                 * @param language the value to add
                 * @return this builder
                 */
                public Builder addLanguage(CodeableConcept language) {
                    this.language.add(Objects.requireNonNull(language, "language"));
                    return this;
                }

                /**
                 * Sets {@code accessionNumber}.
                 *
                 * @param accessionNumber the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder accessionNumber(FhirString accessionNumber) {
                    this.accessionNumber = accessionNumber;
                    return this;
                }

                /**
                 * Sets {@code accessionNumber}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param accessionNumber the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder accessionNumber(String accessionNumber) {
                    return accessionNumber(accessionNumber == null ? null : FhirString.of(accessionNumber));
                }

                /**
                 * Sets {@code pageString}.
                 *
                 * @param pageString the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder pageString(FhirString pageString) {
                    this.pageString = pageString;
                    return this;
                }

                /**
                 * Sets {@code pageString}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param pageString the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder pageString(String pageString) {
                    return pageString(pageString == null ? null : FhirString.of(pageString));
                }

                /**
                 * Sets {@code firstPage}.
                 *
                 * @param firstPage the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder firstPage(FhirString firstPage) {
                    this.firstPage = firstPage;
                    return this;
                }

                /**
                 * Sets {@code firstPage}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param firstPage the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder firstPage(String firstPage) {
                    return firstPage(firstPage == null ? null : FhirString.of(firstPage));
                }

                /**
                 * Sets {@code lastPage}.
                 *
                 * @param lastPage the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder lastPage(FhirString lastPage) {
                    this.lastPage = lastPage;
                    return this;
                }

                /**
                 * Sets {@code lastPage}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param lastPage the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder lastPage(String lastPage) {
                    return lastPage(lastPage == null ? null : FhirString.of(lastPage));
                }

                /**
                 * Sets {@code pageCount}.
                 *
                 * @param pageCount the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder pageCount(FhirString pageCount) {
                    this.pageCount = pageCount;
                    return this;
                }

                /**
                 * Sets {@code pageCount}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param pageCount the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder pageCount(String pageCount) {
                    return pageCount(pageCount == null ? null : FhirString.of(pageCount));
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
                 * Builds the {@code PublicationForm}.
                 *
                 * @return the {@code PublicationForm}
                 */
                public PublicationForm build() {
                    return new PublicationForm(
                            id, extension, modifierExtension, publishedIn, citedMedium, volume, issue, articleDate,
                            publicationDateText, publicationDateSeason, lastRevisionDate, language, accessionNumber,
                            pageString, firstPage, lastPage, pageCount, copyright);
                }
            }
        }

        /**
         * Used for any URL for the article or artifact cited.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param classifier Code the reason for different URLs, e.g. abstract and full-text.
         * @param url The specific URL.
         */
        public record WebLocation(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<CodeableConcept> classifier,
                FhirUri url) implements BackboneElement {

            /**
             * Creates a {@code WebLocation}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public WebLocation {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                classifier = classifier == null ? List.of() : List.copyOf(classifier);
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
             * Returns a builder initialized with the values of this {@code WebLocation}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link WebLocation}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<CodeableConcept> classifier = new ArrayList<>();
                private FhirUri url;

                private Builder() {
                }

                private Builder(WebLocation original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.classifier = new ArrayList<>(original.classifier());
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
                 * Builds the {@code WebLocation}.
                 *
                 * @return the {@code WebLocation}
                 */
                public WebLocation build() {
                    return new WebLocation(
                            id, extension, modifierExtension, classifier, url);
                }
            }
        }

        /**
         * The assignment to an organizing scheme.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param type The kind of classifier (e.g. publication type, keyword).
         * @param classifier The specific classification value.
         * @param artifactAssessment Complex or externally created classification. Reference to ArtifactAssessment.
         */
        public record Classification(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept type,
                List<CodeableConcept> classifier,
                List<Reference> artifactAssessment) implements BackboneElement {

            /**
             * Creates a {@code Classification}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Classification {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                classifier = classifier == null ? List.of() : List.copyOf(classifier);
                artifactAssessment = artifactAssessment == null ? List.of() : List.copyOf(artifactAssessment);
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
             * Returns a builder initialized with the values of this {@code Classification}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Classification}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept type;
                private List<CodeableConcept> classifier = new ArrayList<>();
                private List<Reference> artifactAssessment = new ArrayList<>();

                private Builder() {
                }

                private Builder(Classification original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.type = original.type();
                    this.classifier = new ArrayList<>(original.classifier());
                    this.artifactAssessment = new ArrayList<>(original.artifactAssessment());
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
                 * Replaces all {@code artifactAssessment} values.
                 *
                 * @param artifactAssessment the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder artifactAssessment(List<Reference> artifactAssessment) {
                    this.artifactAssessment = artifactAssessment == null
                            ? new ArrayList<>()
                            : new ArrayList<>(artifactAssessment);
                    return this;
                }

                /**
                 * Adds a {@code artifactAssessment} value.
                 *
                 * @param artifactAssessment the value to add
                 * @return this builder
                 */
                public Builder addArtifactAssessment(Reference artifactAssessment) {
                    this.artifactAssessment.add(Objects.requireNonNull(artifactAssessment, "artifactAssessment"));
                    return this;
                }

                /**
                 * Builds the {@code Classification}.
                 *
                 * @return the {@code Classification}
                 */
                public Classification build() {
                    return new Classification(
                            id, extension, modifierExtension, type, classifier, artifactAssessment);
                }
            }
        }

        /**
         * This element is used to list authors and other contributors, their contact information, specific
         * contributions, and summary statements.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param complete Indicates if the list includes all authors and/or contributors.
         * @param entry An individual entity named as a contributor.
         * @param summary Used to record a display of the author/contributor list without separate data element for
         *   each list member.
         */
        public record Contributorship(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirBoolean complete,
                List<Entry> entry,
                List<ContributorshipSummary> summary) implements BackboneElement {

            /**
             * Creates a {@code Contributorship}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Contributorship {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                entry = entry == null ? List.of() : List.copyOf(entry);
                summary = summary == null ? List.of() : List.copyOf(summary);
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
             * Returns a builder initialized with the values of this {@code Contributorship}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * An individual entity named as a contributor, for example in the author list or contributor list.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param contributor The identity of the individual contributor. Reference to Practitioner, Organization.
             *   Required.
             * @param forenameInitials For citation styles that use initials.
             * @param affiliation Organizational affiliation. Reference to Organization, PractitionerRole.
             * @param contributionType The specific contribution.
             * @param role The role of the contributor (e.g. author, editor, reviewer, funder).
             * @param contributionInstance Contributions with accounting for time or number.
             * @param correspondingContact Whether the contributor is the corresponding contributor for the role.
             * @param rankingOrder Ranked order of contribution.
             */
            public record Entry(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    Reference contributor,
                    FhirString forenameInitials,
                    List<Reference> affiliation,
                    List<CodeableConcept> contributionType,
                    CodeableConcept role,
                    List<ContributionInstance> contributionInstance,
                    FhirBoolean correspondingContact,
                    FhirPositiveInt rankingOrder) implements BackboneElement {

                /**
                 * Creates an {@code Entry}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public Entry {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    affiliation = affiliation == null ? List.of() : List.copyOf(affiliation);
                    contributionType = contributionType == null ? List.of() : List.copyOf(contributionType);
                    contributionInstance =
                            contributionInstance == null ? List.of() : List.copyOf(contributionInstance);
                    Objects.requireNonNull(
                            contributor, "Citation.citedArtifact.contributorship.entry.contributor is required");
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
                 * Returns a builder initialized with the values of this {@code Entry}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /**
                 * Contributions with accounting for time or number.
                 *
                 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
                 * Instances are usually created with {@link #builder()}.
                 *
                 * @param id Unique id for inter-element referencing.
                 * @param extension Additional content defined by implementations.
                 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
                 * @param type The specific contribution. Required.
                 * @param time The time that the contribution was made.
                 */
                public record ContributionInstance(
                        String id,
                        List<Extension> extension,
                        List<Extension> modifierExtension,
                        CodeableConcept type,
                        FhirDateTime time) implements BackboneElement {

                    /**
                     * Creates a {@code ContributionInstance}, copying all lists.
                     *
                     * @throws NullPointerException if a required element is absent or a list contains {@code null}
                     */
                    public ContributionInstance {
                        extension = extension == null ? List.of() : List.copyOf(extension);
                        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                        Objects.requireNonNull(
                                type, "Citation.citedArtifact.contributorship.entry.contributionInstance.type is required");
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
                     * Returns a builder initialized with the values of this {@code ContributionInstance}.
                     *
                     * @return the builder
                     */
                    public Builder toBuilder() {
                        return new Builder(this);
                    }

                    /** Builder for {@link ContributionInstance}. Builders are mutable and not thread-safe. */
                    public static final class Builder {

                        private String id;
                        private List<Extension> extension = new ArrayList<>();
                        private List<Extension> modifierExtension = new ArrayList<>();
                        private CodeableConcept type;
                        private FhirDateTime time;

                        private Builder() {
                        }

                        private Builder(ContributionInstance original) {
                            this.id = original.id();
                            this.extension = new ArrayList<>(original.extension());
                            this.modifierExtension = new ArrayList<>(original.modifierExtension());
                            this.type = original.type();
                            this.time = original.time();
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
                         * Sets {@code time}.
                         *
                         * @param time the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder time(FhirDateTime time) {
                            this.time = time;
                            return this;
                        }

                        /**
                         * Sets {@code time}, wrapped in a {@link FhirDateTime} without id or extensions.
                         *
                         * @param time the value, or {@code null} to clear it
                         * @return this builder
                         */
                        public Builder time(Temporal time) {
                            return time(time == null ? null : FhirDateTime.of(time));
                        }

                        /**
                         * Builds the {@code ContributionInstance}.
                         *
                         * @return the {@code ContributionInstance}
                         * @throws NullPointerException if a required element is absent
                         */
                        public ContributionInstance build() {
                            return new ContributionInstance(
                                    id, extension, modifierExtension, type, time);
                        }
                    }
                }

                /** Builder for {@link Entry}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private Reference contributor;
                    private FhirString forenameInitials;
                    private List<Reference> affiliation = new ArrayList<>();
                    private List<CodeableConcept> contributionType = new ArrayList<>();
                    private CodeableConcept role;
                    private List<ContributionInstance> contributionInstance = new ArrayList<>();
                    private FhirBoolean correspondingContact;
                    private FhirPositiveInt rankingOrder;

                    private Builder() {
                    }

                    private Builder(Entry original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.contributor = original.contributor();
                        this.forenameInitials = original.forenameInitials();
                        this.affiliation = new ArrayList<>(original.affiliation());
                        this.contributionType = new ArrayList<>(original.contributionType());
                        this.role = original.role();
                        this.contributionInstance = new ArrayList<>(original.contributionInstance());
                        this.correspondingContact = original.correspondingContact();
                        this.rankingOrder = original.rankingOrder();
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
                     * Sets {@code contributor}.
                     *
                     * @param contributor the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder contributor(Reference contributor) {
                        this.contributor = contributor;
                        return this;
                    }

                    /**
                     * Sets {@code forenameInitials}.
                     *
                     * @param forenameInitials the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder forenameInitials(FhirString forenameInitials) {
                        this.forenameInitials = forenameInitials;
                        return this;
                    }

                    /**
                     * Sets {@code forenameInitials}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param forenameInitials the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder forenameInitials(String forenameInitials) {
                        return forenameInitials(forenameInitials == null ? null : FhirString.of(forenameInitials));
                    }

                    /**
                     * Replaces all {@code affiliation} values.
                     *
                     * @param affiliation the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder affiliation(List<Reference> affiliation) {
                        this.affiliation = affiliation == null ? new ArrayList<>() : new ArrayList<>(affiliation);
                        return this;
                    }

                    /**
                     * Adds a {@code affiliation} value.
                     *
                     * @param affiliation the value to add
                     * @return this builder
                     */
                    public Builder addAffiliation(Reference affiliation) {
                        this.affiliation.add(Objects.requireNonNull(affiliation, "affiliation"));
                        return this;
                    }

                    /**
                     * Replaces all {@code contributionType} values.
                     *
                     * @param contributionType the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder contributionType(List<CodeableConcept> contributionType) {
                        this.contributionType = contributionType == null
                                ? new ArrayList<>()
                                : new ArrayList<>(contributionType);
                        return this;
                    }

                    /**
                     * Adds a {@code contributionType} value.
                     *
                     * @param contributionType the value to add
                     * @return this builder
                     */
                    public Builder addContributionType(CodeableConcept contributionType) {
                        this.contributionType.add(Objects.requireNonNull(contributionType, "contributionType"));
                        return this;
                    }

                    /**
                     * Sets {@code role}.
                     *
                     * @param role the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder role(CodeableConcept role) {
                        this.role = role;
                        return this;
                    }

                    /**
                     * Replaces all {@code contributionInstance} values.
                     *
                     * @param contributionInstance the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder contributionInstance(List<ContributionInstance> contributionInstance) {
                        this.contributionInstance = contributionInstance == null
                                ? new ArrayList<>()
                                : new ArrayList<>(contributionInstance);
                        return this;
                    }

                    /**
                     * Adds a {@code contributionInstance} value.
                     *
                     * @param contributionInstance the value to add
                     * @return this builder
                     */
                    public Builder addContributionInstance(ContributionInstance contributionInstance) {
                        this.contributionInstance.add(
                                Objects.requireNonNull(contributionInstance, "contributionInstance"));
                        return this;
                    }

                    /**
                     * Sets {@code correspondingContact}.
                     *
                     * @param correspondingContact the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder correspondingContact(FhirBoolean correspondingContact) {
                        this.correspondingContact = correspondingContact;
                        return this;
                    }

                    /**
                     * Sets {@code correspondingContact}, wrapped in a {@link FhirBoolean} without id or extensions.
                     *
                     * @param correspondingContact the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder correspondingContact(Boolean correspondingContact) {
                        return correspondingContact(
                                correspondingContact == null ? null : FhirBoolean.of(correspondingContact));
                    }

                    /**
                     * Sets {@code rankingOrder}.
                     *
                     * @param rankingOrder the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder rankingOrder(FhirPositiveInt rankingOrder) {
                        this.rankingOrder = rankingOrder;
                        return this;
                    }

                    /**
                     * Sets {@code rankingOrder}, wrapped in a {@link FhirPositiveInt} without id or extensions.
                     *
                     * @param rankingOrder the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder rankingOrder(Integer rankingOrder) {
                        return rankingOrder(rankingOrder == null ? null : FhirPositiveInt.of(rankingOrder));
                    }

                    /**
                     * Builds the {@code Entry}.
                     *
                     * @return the {@code Entry}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Entry build() {
                        return new Entry(
                                id, extension, modifierExtension, contributor, forenameInitials, affiliation,
                                contributionType, role, contributionInstance, correspondingContact, rankingOrder);
                    }
                }
            }

            /**
             * Used to record a display of the author/contributor list without separate data element for each list
             * member.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param type Such as author list, contributorship statement, funding statement, acknowledgements
             *   statement, or conflicts of interest statement.
             * @param style The format for the display string.
             * @param source Used to code the producer or rule for creating the display string.
             * @param value The display string for the author list, contributor list, or contributorship statement.
             *   Required.
             */
            public record ContributorshipSummary(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    CodeableConcept type,
                    CodeableConcept style,
                    CodeableConcept source,
                    FhirMarkdown value) implements BackboneElement {

                /**
                 * Creates a {@code ContributorshipSummary}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public ContributorshipSummary {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(value, "Citation.citedArtifact.contributorship.summary.value is required");
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
                 * Returns a builder initialized with the values of this {@code ContributorshipSummary}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link ContributorshipSummary}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private CodeableConcept type;
                    private CodeableConcept style;
                    private CodeableConcept source;
                    private FhirMarkdown value;

                    private Builder() {
                    }

                    private Builder(ContributorshipSummary original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.type = original.type();
                        this.style = original.style();
                        this.source = original.source();
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
                     * Sets {@code style}.
                     *
                     * @param style the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder style(CodeableConcept style) {
                        this.style = style;
                        return this;
                    }

                    /**
                     * Sets {@code source}.
                     *
                     * @param source the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder source(CodeableConcept source) {
                        this.source = source;
                        return this;
                    }

                    /**
                     * Sets {@code value}.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(FhirMarkdown value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Sets {@code value}, wrapped in a {@link FhirMarkdown} without id or extensions.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(String value) {
                        return value(value == null ? null : FhirMarkdown.of(value));
                    }

                    /**
                     * Builds the {@code ContributorshipSummary}.
                     *
                     * @return the {@code ContributorshipSummary}
                     * @throws NullPointerException if a required element is absent
                     */
                    public ContributorshipSummary build() {
                        return new ContributorshipSummary(
                                id, extension, modifierExtension, type, style, source, value);
                    }
                }
            }

            /** Builder for {@link Contributorship}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirBoolean complete;
                private List<Entry> entry = new ArrayList<>();
                private List<ContributorshipSummary> summary = new ArrayList<>();

                private Builder() {
                }

                private Builder(Contributorship original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.complete = original.complete();
                    this.entry = new ArrayList<>(original.entry());
                    this.summary = new ArrayList<>(original.summary());
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
                 * Sets {@code complete}.
                 *
                 * @param complete the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder complete(FhirBoolean complete) {
                    this.complete = complete;
                    return this;
                }

                /**
                 * Sets {@code complete}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param complete the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder complete(Boolean complete) {
                    return complete(complete == null ? null : FhirBoolean.of(complete));
                }

                /**
                 * Replaces all {@code entry} values.
                 *
                 * @param entry the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder entry(List<Entry> entry) {
                    this.entry = entry == null ? new ArrayList<>() : new ArrayList<>(entry);
                    return this;
                }

                /**
                 * Adds a {@code entry} value.
                 *
                 * @param entry the value to add
                 * @return this builder
                 */
                public Builder addEntry(Entry entry) {
                    this.entry.add(Objects.requireNonNull(entry, "entry"));
                    return this;
                }

                /**
                 * Replaces all {@code summary} values.
                 *
                 * @param summary the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder summary(List<ContributorshipSummary> summary) {
                    this.summary = summary == null ? new ArrayList<>() : new ArrayList<>(summary);
                    return this;
                }

                /**
                 * Adds a {@code summary} value.
                 *
                 * @param summary the value to add
                 * @return this builder
                 */
                public Builder addSummary(ContributorshipSummary summary) {
                    this.summary.add(Objects.requireNonNull(summary, "summary"));
                    return this;
                }

                /**
                 * Builds the {@code Contributorship}.
                 *
                 * @return the {@code Contributorship}
                 */
                public Contributorship build() {
                    return new Contributorship(
                            id, extension, modifierExtension, complete, entry, summary);
                }
            }
        }

        /** Builder for {@link CitedArtifact}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Identifier> identifier = new ArrayList<>();
            private List<Identifier> relatedIdentifier = new ArrayList<>();
            private FhirDateTime dateAccessed;
            private Version version;
            private List<CodeableConcept> currentState = new ArrayList<>();
            private List<StatusDate> statusDate = new ArrayList<>();
            private List<Title> title = new ArrayList<>();
            private List<AbstractValue> abstractValue = new ArrayList<>();
            private Part part;
            private List<RelatesTo> relatesTo = new ArrayList<>();
            private List<PublicationForm> publicationForm = new ArrayList<>();
            private List<WebLocation> webLocation = new ArrayList<>();
            private List<Classification> classification = new ArrayList<>();
            private Contributorship contributorship;
            private List<Annotation> note = new ArrayList<>();

            private Builder() {
            }

            private Builder(CitedArtifact original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = new ArrayList<>(original.identifier());
                this.relatedIdentifier = new ArrayList<>(original.relatedIdentifier());
                this.dateAccessed = original.dateAccessed();
                this.version = original.version();
                this.currentState = new ArrayList<>(original.currentState());
                this.statusDate = new ArrayList<>(original.statusDate());
                this.title = new ArrayList<>(original.title());
                this.abstractValue = new ArrayList<>(original.abstractValue());
                this.part = original.part();
                this.relatesTo = new ArrayList<>(original.relatesTo());
                this.publicationForm = new ArrayList<>(original.publicationForm());
                this.webLocation = new ArrayList<>(original.webLocation());
                this.classification = new ArrayList<>(original.classification());
                this.contributorship = original.contributorship();
                this.note = new ArrayList<>(original.note());
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
             * Replaces all {@code relatedIdentifier} values.
             *
             * @param relatedIdentifier the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder relatedIdentifier(List<Identifier> relatedIdentifier) {
                this.relatedIdentifier = relatedIdentifier == null
                        ? new ArrayList<>()
                        : new ArrayList<>(relatedIdentifier);
                return this;
            }

            /**
             * Adds a {@code relatedIdentifier} value.
             *
             * @param relatedIdentifier the value to add
             * @return this builder
             */
            public Builder addRelatedIdentifier(Identifier relatedIdentifier) {
                this.relatedIdentifier.add(Objects.requireNonNull(relatedIdentifier, "relatedIdentifier"));
                return this;
            }

            /**
             * Sets {@code dateAccessed}.
             *
             * @param dateAccessed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dateAccessed(FhirDateTime dateAccessed) {
                this.dateAccessed = dateAccessed;
                return this;
            }

            /**
             * Sets {@code dateAccessed}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param dateAccessed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dateAccessed(Temporal dateAccessed) {
                return dateAccessed(dateAccessed == null ? null : FhirDateTime.of(dateAccessed));
            }

            /**
             * Sets {@code version}.
             *
             * @param version the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder version(Version version) {
                this.version = version;
                return this;
            }

            /**
             * Replaces all {@code currentState} values.
             *
             * @param currentState the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder currentState(List<CodeableConcept> currentState) {
                this.currentState = currentState == null ? new ArrayList<>() : new ArrayList<>(currentState);
                return this;
            }

            /**
             * Adds a {@code currentState} value.
             *
             * @param currentState the value to add
             * @return this builder
             */
            public Builder addCurrentState(CodeableConcept currentState) {
                this.currentState.add(Objects.requireNonNull(currentState, "currentState"));
                return this;
            }

            /**
             * Replaces all {@code statusDate} values.
             *
             * @param statusDate the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder statusDate(List<StatusDate> statusDate) {
                this.statusDate = statusDate == null ? new ArrayList<>() : new ArrayList<>(statusDate);
                return this;
            }

            /**
             * Adds a {@code statusDate} value.
             *
             * @param statusDate the value to add
             * @return this builder
             */
            public Builder addStatusDate(StatusDate statusDate) {
                this.statusDate.add(Objects.requireNonNull(statusDate, "statusDate"));
                return this;
            }

            /**
             * Replaces all {@code title} values.
             *
             * @param title the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder title(List<Title> title) {
                this.title = title == null ? new ArrayList<>() : new ArrayList<>(title);
                return this;
            }

            /**
             * Adds a {@code title} value.
             *
             * @param title the value to add
             * @return this builder
             */
            public Builder addTitle(Title title) {
                this.title.add(Objects.requireNonNull(title, "title"));
                return this;
            }

            /**
             * Replaces all {@code abstractValue} values.
             *
             * @param abstractValue the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder abstractValue(List<AbstractValue> abstractValue) {
                this.abstractValue = abstractValue == null ? new ArrayList<>() : new ArrayList<>(abstractValue);
                return this;
            }

            /**
             * Adds a {@code abstractValue} value.
             *
             * @param abstractValue the value to add
             * @return this builder
             */
            public Builder addAbstractValue(AbstractValue abstractValue) {
                this.abstractValue.add(Objects.requireNonNull(abstractValue, "abstractValue"));
                return this;
            }

            /**
             * Sets {@code part}.
             *
             * @param part the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder part(Part part) {
                this.part = part;
                return this;
            }

            /**
             * Replaces all {@code relatesTo} values.
             *
             * @param relatesTo the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder relatesTo(List<RelatesTo> relatesTo) {
                this.relatesTo = relatesTo == null ? new ArrayList<>() : new ArrayList<>(relatesTo);
                return this;
            }

            /**
             * Adds a {@code relatesTo} value.
             *
             * @param relatesTo the value to add
             * @return this builder
             */
            public Builder addRelatesTo(RelatesTo relatesTo) {
                this.relatesTo.add(Objects.requireNonNull(relatesTo, "relatesTo"));
                return this;
            }

            /**
             * Replaces all {@code publicationForm} values.
             *
             * @param publicationForm the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder publicationForm(List<PublicationForm> publicationForm) {
                this.publicationForm = publicationForm == null ? new ArrayList<>() : new ArrayList<>(publicationForm);
                return this;
            }

            /**
             * Adds a {@code publicationForm} value.
             *
             * @param publicationForm the value to add
             * @return this builder
             */
            public Builder addPublicationForm(PublicationForm publicationForm) {
                this.publicationForm.add(Objects.requireNonNull(publicationForm, "publicationForm"));
                return this;
            }

            /**
             * Replaces all {@code webLocation} values.
             *
             * @param webLocation the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder webLocation(List<WebLocation> webLocation) {
                this.webLocation = webLocation == null ? new ArrayList<>() : new ArrayList<>(webLocation);
                return this;
            }

            /**
             * Adds a {@code webLocation} value.
             *
             * @param webLocation the value to add
             * @return this builder
             */
            public Builder addWebLocation(WebLocation webLocation) {
                this.webLocation.add(Objects.requireNonNull(webLocation, "webLocation"));
                return this;
            }

            /**
             * Replaces all {@code classification} values.
             *
             * @param classification the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder classification(List<Classification> classification) {
                this.classification = classification == null ? new ArrayList<>() : new ArrayList<>(classification);
                return this;
            }

            /**
             * Adds a {@code classification} value.
             *
             * @param classification the value to add
             * @return this builder
             */
            public Builder addClassification(Classification classification) {
                this.classification.add(Objects.requireNonNull(classification, "classification"));
                return this;
            }

            /**
             * Sets {@code contributorship}.
             *
             * @param contributorship the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder contributorship(Contributorship contributorship) {
                this.contributorship = contributorship;
                return this;
            }

            /**
             * Replaces all {@code note} values.
             *
             * @param note the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder note(List<Annotation> note) {
                this.note = note == null ? new ArrayList<>() : new ArrayList<>(note);
                return this;
            }

            /**
             * Adds a {@code note} value.
             *
             * @param note the value to add
             * @return this builder
             */
            public Builder addNote(Annotation note) {
                this.note.add(Objects.requireNonNull(note, "note"));
                return this;
            }

            /**
             * Builds the {@code CitedArtifact}.
             *
             * @return the {@code CitedArtifact}
             */
            public CitedArtifact build() {
                return new CitedArtifact(
                        id, extension, modifierExtension, identifier, relatedIdentifier, dateAccessed, version,
                        currentState, statusDate, title, abstractValue, part, relatesTo, publicationForm, webLocation,
                        classification, contributorship, note);
            }
        }
    }

    /** Builder for {@link Citation}. Builders are mutable and not thread-safe. */
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
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private Period effectivePeriod;
        private List<ContactDetail> author = new ArrayList<>();
        private List<ContactDetail> editor = new ArrayList<>();
        private List<ContactDetail> reviewer = new ArrayList<>();
        private List<ContactDetail> endorser = new ArrayList<>();
        private List<Summary> summary = new ArrayList<>();
        private List<Classification> classification = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private List<CodeableConcept> currentState = new ArrayList<>();
        private List<StatusDate> statusDate = new ArrayList<>();
        private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
        private CitedArtifact citedArtifact;

        private Builder() {
        }

        private Builder(Citation original) {
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
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.effectivePeriod = original.effectivePeriod();
            this.author = new ArrayList<>(original.author());
            this.editor = new ArrayList<>(original.editor());
            this.reviewer = new ArrayList<>(original.reviewer());
            this.endorser = new ArrayList<>(original.endorser());
            this.summary = new ArrayList<>(original.summary());
            this.classification = new ArrayList<>(original.classification());
            this.note = new ArrayList<>(original.note());
            this.currentState = new ArrayList<>(original.currentState());
            this.statusDate = new ArrayList<>(original.statusDate());
            this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
            this.citedArtifact = original.citedArtifact();
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
         * Replaces all {@code summary} values.
         *
         * @param summary the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder summary(List<Summary> summary) {
            this.summary = summary == null ? new ArrayList<>() : new ArrayList<>(summary);
            return this;
        }

        /**
         * Adds a {@code summary} value.
         *
         * @param summary the value to add
         * @return this builder
         */
        public Builder addSummary(Summary summary) {
            this.summary.add(Objects.requireNonNull(summary, "summary"));
            return this;
        }

        /**
         * Replaces all {@code classification} values.
         *
         * @param classification the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder classification(List<Classification> classification) {
            this.classification = classification == null ? new ArrayList<>() : new ArrayList<>(classification);
            return this;
        }

        /**
         * Adds a {@code classification} value.
         *
         * @param classification the value to add
         * @return this builder
         */
        public Builder addClassification(Classification classification) {
            this.classification.add(Objects.requireNonNull(classification, "classification"));
            return this;
        }

        /**
         * Replaces all {@code note} values.
         *
         * @param note the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder note(List<Annotation> note) {
            this.note = note == null ? new ArrayList<>() : new ArrayList<>(note);
            return this;
        }

        /**
         * Adds a {@code note} value.
         *
         * @param note the value to add
         * @return this builder
         */
        public Builder addNote(Annotation note) {
            this.note.add(Objects.requireNonNull(note, "note"));
            return this;
        }

        /**
         * Replaces all {@code currentState} values.
         *
         * @param currentState the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder currentState(List<CodeableConcept> currentState) {
            this.currentState = currentState == null ? new ArrayList<>() : new ArrayList<>(currentState);
            return this;
        }

        /**
         * Adds a {@code currentState} value.
         *
         * @param currentState the value to add
         * @return this builder
         */
        public Builder addCurrentState(CodeableConcept currentState) {
            this.currentState.add(Objects.requireNonNull(currentState, "currentState"));
            return this;
        }

        /**
         * Replaces all {@code statusDate} values.
         *
         * @param statusDate the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder statusDate(List<StatusDate> statusDate) {
            this.statusDate = statusDate == null ? new ArrayList<>() : new ArrayList<>(statusDate);
            return this;
        }

        /**
         * Adds a {@code statusDate} value.
         *
         * @param statusDate the value to add
         * @return this builder
         */
        public Builder addStatusDate(StatusDate statusDate) {
            this.statusDate.add(Objects.requireNonNull(statusDate, "statusDate"));
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
         * Sets {@code citedArtifact}.
         *
         * @param citedArtifact the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder citedArtifact(CitedArtifact citedArtifact) {
            this.citedArtifact = citedArtifact;
            return this;
        }

        /**
         * Builds the {@code Citation}.
         *
         * @return the {@code Citation}
         * @throws NullPointerException if a required element is absent
         */
        public Citation build() {
            return new Citation(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, status, experimental, date, publisher, contact,
                    description, useContext, jurisdiction, purpose, copyright, copyrightLabel, approvalDate,
                    lastReviewDate, effectivePeriod, author, editor, reviewer, endorser, summary, classification,
                    note, currentState, statusDate, relatedArtifact, citedArtifact);
        }
    }
}
