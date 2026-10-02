package se.poroli.fhirplace.r5.datatypes;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;

/**
 * Related artifacts such as additional documentation, justification, or bibliographic references.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param type documentation | justification | citation | predecessor | successor | derived-from | depends-on |
 *   composed-of | part-of | amends | amended-with | appends | appended-with | cites | cited-by | comments-on |
 *   comment-in | contains | contained-in | corrects | correction-in | replaces | replaced-with | retracts |
 *   retracted-by | signs | similar-to | supports | supported-with | transforms | transformed-into | transformed-with
 *   | documents | specification-of | created-with | cite-as. Required.
 * @param classifier Additional classifiers.
 * @param label Short label.
 * @param display Brief description of the related artifact.
 * @param citation Bibliographic citation for the artifact.
 * @param document What document is being referenced.
 * @param resource What artifact is being referenced. Canonical reference to Resource.
 * @param resourceReference What artifact, if not a conformance resource. Reference to Resource.
 * @param publicationStatus draft | active | retired | unknown.
 * @param publicationDate Date of publication of the artifact being referred to.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/RelatedArtifact">FHIR R5 RelatedArtifact</a>
 */
public record RelatedArtifact(
        String id,
        List<Extension> extension,
        FhirEnum<RelatedArtifactType> type,
        List<CodeableConcept> classifier,
        FhirString label,
        FhirString display,
        FhirMarkdown citation,
        Attachment document,
        FhirCanonical resource,
        Reference resourceReference,
        FhirEnum<PublicationStatus> publicationStatus,
        FhirDate publicationDate) implements DataType {

    /**
     * Creates a {@code RelatedArtifact}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public RelatedArtifact {
        extension = extension == null ? List.of() : List.copyOf(extension);
        classifier = classifier == null ? List.of() : List.copyOf(classifier);
        Objects.requireNonNull(type, "RelatedArtifact.type is required");
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
     * Returns a builder initialized with the values of this {@code RelatedArtifact}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link RelatedArtifact}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private FhirEnum<RelatedArtifactType> type;
        private List<CodeableConcept> classifier = new ArrayList<>();
        private FhirString label;
        private FhirString display;
        private FhirMarkdown citation;
        private Attachment document;
        private FhirCanonical resource;
        private Reference resourceReference;
        private FhirEnum<PublicationStatus> publicationStatus;
        private FhirDate publicationDate;

        private Builder() {
        }

        private Builder(RelatedArtifact original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.type = original.type();
            this.classifier = new ArrayList<>(original.classifier());
            this.label = original.label();
            this.display = original.display();
            this.citation = original.citation();
            this.document = original.document();
            this.resource = original.resource();
            this.resourceReference = original.resourceReference();
            this.publicationStatus = original.publicationStatus();
            this.publicationDate = original.publicationDate();
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
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<RelatedArtifactType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(RelatedArtifactType type) {
            return type(type == null ? null : FhirEnum.of(type));
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
         * Sets {@code publicationStatus}.
         *
         * @param publicationStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publicationStatus(FhirEnum<PublicationStatus> publicationStatus) {
            this.publicationStatus = publicationStatus;
            return this;
        }

        /**
         * Sets {@code publicationStatus}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param publicationStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publicationStatus(PublicationStatus publicationStatus) {
            return publicationStatus(publicationStatus == null ? null : FhirEnum.of(publicationStatus));
        }

        /**
         * Sets {@code publicationDate}.
         *
         * @param publicationDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publicationDate(FhirDate publicationDate) {
            this.publicationDate = publicationDate;
            return this;
        }

        /**
         * Sets {@code publicationDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param publicationDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publicationDate(Temporal publicationDate) {
            return publicationDate(publicationDate == null ? null : FhirDate.of(publicationDate));
        }

        /**
         * Builds the {@code RelatedArtifact}.
         *
         * @return the {@code RelatedArtifact}
         * @throws NullPointerException if a required element is absent
         */
        public RelatedArtifact build() {
            return new RelatedArtifact(
                    id, extension, type, classifier, label, display, citation, document, resource, resourceReference,
                    publicationStatus, publicationDate);
        }
    }
}
