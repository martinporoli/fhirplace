package se.poroli.fhirplace.r5.evidencereport;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.ListMode;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/**
 * The EvidenceReport Resource is a specialized container for a collection of resources and codeable concepts, adapted
 * to support compositions of Evidence, EvidenceVariable, and Citation resources and related concepts.
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
 * @param url Canonical identifier for this EvidenceReport, represented as a globally unique URI.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param useContext The context that the content is intended to support.
 * @param identifier Unique identifier for the evidence report.
 * @param relatedIdentifier Identifiers for articles that may relate to more than one evidence report.
 * @param citeAs Citation for this report. One of Reference, markdown.
 * @param type Kind of report.
 * @param note Used for footnotes and annotations.
 * @param relatedArtifact Link, description or reference to artifact associated with the report.
 * @param subject Focus of the report. Required.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param author Who authored the content.
 * @param editor Who edited the content.
 * @param reviewer Who reviewed the content.
 * @param endorser Who endorsed the content.
 * @param relatesTo Relationships to other compositions/documents.
 * @param section Composition is broken into sections.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/EvidenceReport">FHIR R5 EvidenceReport</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record EvidenceReport(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirUri url,
        FhirEnum<PublicationStatus> status,
        List<UsageContext> useContext,
        List<Identifier> identifier,
        List<Identifier> relatedIdentifier,
        DataType citeAs,
        CodeableConcept type,
        List<Annotation> note,
        List<RelatedArtifact> relatedArtifact,
        Subject subject,
        FhirString publisher,
        List<ContactDetail> contact,
        List<ContactDetail> author,
        List<ContactDetail> editor,
        List<ContactDetail> reviewer,
        List<ContactDetail> endorser,
        List<RelatesTo> relatesTo,
        List<Section> section) implements DomainResource {

    /**
     * Creates an {@code EvidenceReport}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public EvidenceReport {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        relatedIdentifier = relatedIdentifier == null ? List.of() : List.copyOf(relatedIdentifier);
        note = note == null ? List.of() : List.copyOf(note);
        relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
        contact = contact == null ? List.of() : List.copyOf(contact);
        author = author == null ? List.of() : List.copyOf(author);
        editor = editor == null ? List.of() : List.copyOf(editor);
        reviewer = reviewer == null ? List.of() : List.copyOf(reviewer);
        endorser = endorser == null ? List.of() : List.copyOf(endorser);
        relatesTo = relatesTo == null ? List.of() : List.copyOf(relatesTo);
        section = section == null ? List.of() : List.copyOf(section);
        Objects.requireNonNull(status, "EvidenceReport.status is required");
        Objects.requireNonNull(subject, "EvidenceReport.subject is required");
        if (citeAs != null && !(citeAs instanceof Reference || citeAs instanceof FhirMarkdown)) {
            throw new IllegalArgumentException(
                    "EvidenceReport.citeAs[x] must be one of Reference, markdown, but was "
                            + citeAs.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code EvidenceReport}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Specifies the subject or focus of the report.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param characteristic Characteristic.
     * @param note Footnotes and/or explanatory notes.
     */
    public record Subject(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Characteristic> characteristic,
            List<Annotation> note) implements BackboneElement {

        /**
         * Creates a {@code Subject}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Subject {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            characteristic = characteristic == null ? List.of() : List.copyOf(characteristic);
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
         * Returns a builder initialized with the values of this {@code Subject}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Characteristic.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param code Characteristic code. Required.
         * @param value Characteristic value. One of Reference, CodeableConcept, boolean, Quantity, Range. Required.
         * @param exclude Is used to express not the characteristic.
         * @param period Timeframe for the characteristic.
         */
        public record Characteristic(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept code,
                DataType value,
                FhirBoolean exclude,
                Period period) implements BackboneElement {

            /**
             * Creates a {@code Characteristic}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Characteristic {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(code, "EvidenceReport.subject.characteristic.code is required");
                Objects.requireNonNull(value, "EvidenceReport.subject.characteristic.value is required");
                if (value != null && !(value instanceof Reference
                        || value instanceof CodeableConcept
                        || value instanceof FhirBoolean
                        || value instanceof Quantity
                        || value instanceof Range)) {
                    throw new IllegalArgumentException(
                            "EvidenceReport.subject.characteristic.value[x] does not allow "
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
             * Returns a builder initialized with the values of this {@code Characteristic}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Characteristic}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept code;
                private DataType value;
                private FhirBoolean exclude;
                private Period period;

                private Builder() {
                }

                private Builder(Characteristic original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.code = original.code();
                    this.value = original.value();
                    this.exclude = original.exclude();
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
                 * Sets {@code value} to a Reference.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Reference value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a CodeableConcept.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(CodeableConcept value) {
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
                 * Sets {@code value} to a Quantity.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Quantity value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a Range.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Range value) {
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
                 * Sets {@code exclude}.
                 *
                 * @param exclude the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder exclude(FhirBoolean exclude) {
                    this.exclude = exclude;
                    return this;
                }

                /**
                 * Sets {@code exclude}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param exclude the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder exclude(Boolean exclude) {
                    return exclude(exclude == null ? null : FhirBoolean.of(exclude));
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
                 * Builds the {@code Characteristic}.
                 *
                 * @return the {@code Characteristic}
                 * @throws NullPointerException if a required element is absent
                 */
                public Characteristic build() {
                    return new Characteristic(
                            id, extension, modifierExtension, code, value, exclude, period);
                }
            }
        }

        /** Builder for {@link Subject}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Characteristic> characteristic = new ArrayList<>();
            private List<Annotation> note = new ArrayList<>();

            private Builder() {
            }

            private Builder(Subject original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.characteristic = new ArrayList<>(original.characteristic());
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
             * Replaces all {@code characteristic} values.
             *
             * @param characteristic the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder characteristic(List<Characteristic> characteristic) {
                this.characteristic = characteristic == null ? new ArrayList<>() : new ArrayList<>(characteristic);
                return this;
            }

            /**
             * Adds a {@code characteristic} value.
             *
             * @param characteristic the value to add
             * @return this builder
             */
            public Builder addCharacteristic(Characteristic characteristic) {
                this.characteristic.add(Objects.requireNonNull(characteristic, "characteristic"));
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
             * Builds the {@code Subject}.
             *
             * @return the {@code Subject}
             */
            public Subject build() {
                return new Subject(
                        id, extension, modifierExtension, characteristic, note);
            }
        }
    }

    /**
     * Relationships that this composition has with other compositions or documents that already exist.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code replaces | amends | appends | transforms | replacedWith | amendedWith | appendedWith |
     *   transformedWith. Required.
     * @param target Target of the relationship. Required.
     */
    public record RelatesTo(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<ReportRelationshipType> code,
            Target target) implements BackboneElement {

        /**
         * Creates a {@code RelatesTo}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public RelatesTo {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(code, "EvidenceReport.relatesTo.code is required");
            Objects.requireNonNull(target, "EvidenceReport.relatesTo.target is required");
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

        /**
         * The target composition/document of this relationship.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param url Target of the relationship URL.
         * @param identifier Target of the relationship Identifier.
         * @param display Target of the relationship Display.
         * @param resource Target of the relationship Resource reference. Reference to Resource.
         */
        public record Target(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirUri url,
                Identifier identifier,
                FhirMarkdown display,
                Reference resource) implements BackboneElement {

            /**
             * Creates a {@code Target}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Target {
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
             * Returns a builder initialized with the values of this {@code Target}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Target}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirUri url;
                private Identifier identifier;
                private FhirMarkdown display;
                private Reference resource;

                private Builder() {
                }

                private Builder(Target original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.url = original.url();
                    this.identifier = original.identifier();
                    this.display = original.display();
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
                 * Sets {@code identifier}.
                 *
                 * @param identifier the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder identifier(Identifier identifier) {
                    this.identifier = identifier;
                    return this;
                }

                /**
                 * Sets {@code display}.
                 *
                 * @param display the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder display(FhirMarkdown display) {
                    this.display = display;
                    return this;
                }

                /**
                 * Sets {@code display}, wrapped in a {@link FhirMarkdown} without id or extensions.
                 *
                 * @param display the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder display(String display) {
                    return display(display == null ? null : FhirMarkdown.of(display));
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
                 * Builds the {@code Target}.
                 *
                 * @return the {@code Target}
                 */
                public Target build() {
                    return new Target(
                            id, extension, modifierExtension, url, identifier, display, resource);
                }
            }
        }

        /** Builder for {@link RelatesTo}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<ReportRelationshipType> code;
            private Target target;

            private Builder() {
            }

            private Builder(RelatesTo original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.target = original.target();
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
            public Builder code(FhirEnum<ReportRelationshipType> code) {
                this.code = code;
                return this;
            }

            /**
             * Sets {@code code}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param code the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder code(ReportRelationshipType code) {
                return code(code == null ? null : FhirEnum.of(code));
            }

            /**
             * Sets {@code target}.
             *
             * @param target the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder target(Target target) {
                this.target = target;
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
                        id, extension, modifierExtension, code, target);
            }
        }
    }

    /**
     * The root of the sections that make up the composition.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param title Label for section (e.g. for ToC).
     * @param focus Classification of section (recommended).
     * @param focusReference Classification of section by Resource. Reference to Resource.
     * @param author Who and/or what authored the section. Reference to Patient, Practitioner, PractitionerRole,
     *   RelatedPerson, Device, Group, Organization.
     * @param text Text summary of the section, for human interpretation.
     * @param mode working | snapshot | changes.
     * @param orderedBy Order of section entries.
     * @param entryClassifier Extensible classifiers as content.
     * @param entryReference Reference to resources as content. Reference to Resource.
     * @param entryQuantity Quantity as content.
     * @param emptyReason Why the section is empty.
     * @param section Nested Section.
     */
    public record Section(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString title,
            CodeableConcept focus,
            Reference focusReference,
            List<Reference> author,
            Narrative text,
            FhirEnum<ListMode> mode,
            CodeableConcept orderedBy,
            List<CodeableConcept> entryClassifier,
            List<Reference> entryReference,
            List<Quantity> entryQuantity,
            CodeableConcept emptyReason,
            List<EvidenceReport.Section> section) implements BackboneElement {

        /**
         * Creates a {@code Section}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Section {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            author = author == null ? List.of() : List.copyOf(author);
            entryClassifier = entryClassifier == null ? List.of() : List.copyOf(entryClassifier);
            entryReference = entryReference == null ? List.of() : List.copyOf(entryReference);
            entryQuantity = entryQuantity == null ? List.of() : List.copyOf(entryQuantity);
            section = section == null ? List.of() : List.copyOf(section);
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
         * Returns a builder initialized with the values of this {@code Section}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Section}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString title;
            private CodeableConcept focus;
            private Reference focusReference;
            private List<Reference> author = new ArrayList<>();
            private Narrative text;
            private FhirEnum<ListMode> mode;
            private CodeableConcept orderedBy;
            private List<CodeableConcept> entryClassifier = new ArrayList<>();
            private List<Reference> entryReference = new ArrayList<>();
            private List<Quantity> entryQuantity = new ArrayList<>();
            private CodeableConcept emptyReason;
            private List<EvidenceReport.Section> section = new ArrayList<>();

            private Builder() {
            }

            private Builder(Section original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.title = original.title();
                this.focus = original.focus();
                this.focusReference = original.focusReference();
                this.author = new ArrayList<>(original.author());
                this.text = original.text();
                this.mode = original.mode();
                this.orderedBy = original.orderedBy();
                this.entryClassifier = new ArrayList<>(original.entryClassifier());
                this.entryReference = new ArrayList<>(original.entryReference());
                this.entryQuantity = new ArrayList<>(original.entryQuantity());
                this.emptyReason = original.emptyReason();
                this.section = new ArrayList<>(original.section());
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
             * Sets {@code focus}.
             *
             * @param focus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder focus(CodeableConcept focus) {
                this.focus = focus;
                return this;
            }

            /**
             * Sets {@code focusReference}.
             *
             * @param focusReference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder focusReference(Reference focusReference) {
                this.focusReference = focusReference;
                return this;
            }

            /**
             * Replaces all {@code author} values.
             *
             * @param author the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder author(List<Reference> author) {
                this.author = author == null ? new ArrayList<>() : new ArrayList<>(author);
                return this;
            }

            /**
             * Adds a {@code author} value.
             *
             * @param author the value to add
             * @return this builder
             */
            public Builder addAuthor(Reference author) {
                this.author.add(Objects.requireNonNull(author, "author"));
                return this;
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
             * Sets {@code mode}.
             *
             * @param mode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder mode(FhirEnum<ListMode> mode) {
                this.mode = mode;
                return this;
            }

            /**
             * Sets {@code mode}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param mode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder mode(ListMode mode) {
                return mode(mode == null ? null : FhirEnum.of(mode));
            }

            /**
             * Sets {@code orderedBy}.
             *
             * @param orderedBy the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder orderedBy(CodeableConcept orderedBy) {
                this.orderedBy = orderedBy;
                return this;
            }

            /**
             * Replaces all {@code entryClassifier} values.
             *
             * @param entryClassifier the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder entryClassifier(List<CodeableConcept> entryClassifier) {
                this.entryClassifier = entryClassifier == null ? new ArrayList<>() : new ArrayList<>(entryClassifier);
                return this;
            }

            /**
             * Adds a {@code entryClassifier} value.
             *
             * @param entryClassifier the value to add
             * @return this builder
             */
            public Builder addEntryClassifier(CodeableConcept entryClassifier) {
                this.entryClassifier.add(Objects.requireNonNull(entryClassifier, "entryClassifier"));
                return this;
            }

            /**
             * Replaces all {@code entryReference} values.
             *
             * @param entryReference the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder entryReference(List<Reference> entryReference) {
                this.entryReference = entryReference == null ? new ArrayList<>() : new ArrayList<>(entryReference);
                return this;
            }

            /**
             * Adds a {@code entryReference} value.
             *
             * @param entryReference the value to add
             * @return this builder
             */
            public Builder addEntryReference(Reference entryReference) {
                this.entryReference.add(Objects.requireNonNull(entryReference, "entryReference"));
                return this;
            }

            /**
             * Replaces all {@code entryQuantity} values.
             *
             * @param entryQuantity the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder entryQuantity(List<Quantity> entryQuantity) {
                this.entryQuantity = entryQuantity == null ? new ArrayList<>() : new ArrayList<>(entryQuantity);
                return this;
            }

            /**
             * Adds a {@code entryQuantity} value.
             *
             * @param entryQuantity the value to add
             * @return this builder
             */
            public Builder addEntryQuantity(Quantity entryQuantity) {
                this.entryQuantity.add(Objects.requireNonNull(entryQuantity, "entryQuantity"));
                return this;
            }

            /**
             * Sets {@code emptyReason}.
             *
             * @param emptyReason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder emptyReason(CodeableConcept emptyReason) {
                this.emptyReason = emptyReason;
                return this;
            }

            /**
             * Replaces all {@code section} values.
             *
             * @param section the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder section(List<EvidenceReport.Section> section) {
                this.section = section == null ? new ArrayList<>() : new ArrayList<>(section);
                return this;
            }

            /**
             * Adds a {@code section} value.
             *
             * @param section the value to add
             * @return this builder
             */
            public Builder addSection(EvidenceReport.Section section) {
                this.section.add(Objects.requireNonNull(section, "section"));
                return this;
            }

            /**
             * Builds the {@code Section}.
             *
             * @return the {@code Section}
             */
            public Section build() {
                return new Section(
                        id, extension, modifierExtension, title, focus, focusReference, author, text, mode, orderedBy,
                        entryClassifier, entryReference, entryQuantity, emptyReason, section);
            }
        }
    }

    /** Builder for {@link EvidenceReport}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<PublicationStatus> status;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<Identifier> identifier = new ArrayList<>();
        private List<Identifier> relatedIdentifier = new ArrayList<>();
        private DataType citeAs;
        private CodeableConcept type;
        private List<Annotation> note = new ArrayList<>();
        private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
        private Subject subject;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private List<ContactDetail> author = new ArrayList<>();
        private List<ContactDetail> editor = new ArrayList<>();
        private List<ContactDetail> reviewer = new ArrayList<>();
        private List<ContactDetail> endorser = new ArrayList<>();
        private List<RelatesTo> relatesTo = new ArrayList<>();
        private List<Section> section = new ArrayList<>();

        private Builder() {
        }

        private Builder(EvidenceReport original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.url = original.url();
            this.status = original.status();
            this.useContext = new ArrayList<>(original.useContext());
            this.identifier = new ArrayList<>(original.identifier());
            this.relatedIdentifier = new ArrayList<>(original.relatedIdentifier());
            this.citeAs = original.citeAs();
            this.type = original.type();
            this.note = new ArrayList<>(original.note());
            this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
            this.subject = original.subject();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.author = new ArrayList<>(original.author());
            this.editor = new ArrayList<>(original.editor());
            this.reviewer = new ArrayList<>(original.reviewer());
            this.endorser = new ArrayList<>(original.endorser());
            this.relatesTo = new ArrayList<>(original.relatesTo());
            this.section = new ArrayList<>(original.section());
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
         * Sets {@code subject}.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(Subject subject) {
            this.subject = subject;
            return this;
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
         * Replaces all {@code section} values.
         *
         * @param section the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder section(List<Section> section) {
            this.section = section == null ? new ArrayList<>() : new ArrayList<>(section);
            return this;
        }

        /**
         * Adds a {@code section} value.
         *
         * @param section the value to add
         * @return this builder
         */
        public Builder addSection(Section section) {
            this.section.add(Objects.requireNonNull(section, "section"));
            return this;
        }

        /**
         * Builds the {@code EvidenceReport}.
         *
         * @return the {@code EvidenceReport}
         * @throws NullPointerException if a required element is absent
         */
        public EvidenceReport build() {
            return new EvidenceReport(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, status,
                    useContext, identifier, relatedIdentifier, citeAs, type, note, relatedArtifact, subject,
                    publisher, contact, author, editor, reviewer, endorser, relatesTo, section);
        }
    }
}
