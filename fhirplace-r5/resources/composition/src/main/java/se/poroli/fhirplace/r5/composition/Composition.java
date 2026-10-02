package se.poroli.fhirplace.r5.composition;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.CompositionStatus;

/**
 * A set of healthcare-related information that is assembled together into a single logical package that provides a
 * single coherent statement of meaning, establishes its own context and that has clinical attestation with regard to
 * who is making the statement.
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
 * @param url Canonical identifier for this Composition, represented as a URI (globally unique).
 * @param identifier Version-independent identifier for the Composition.
 * @param version An explicitly assigned identifer of a variation of the content in the Composition.
 * @param status registered | partial | preliminary | final | amended | corrected | appended | cancelled |
 *   entered-in-error | deprecated | unknown. Required. Modifier element.
 * @param type Kind of composition (LOINC if possible). Required.
 * @param category Categorization of Composition.
 * @param subject Who and/or what the composition is about. Reference to Resource.
 * @param encounter Context of the Composition. Reference to Encounter.
 * @param date Composition editing time. Required.
 * @param useContext The context that the content is intended to support.
 * @param author Who and/or what authored the composition. Reference to Practitioner, PractitionerRole, Device,
 *   Patient, RelatedPerson, Organization. Required.
 * @param name Name for this Composition (computer friendly).
 * @param title Human Readable name/title. Required.
 * @param note For any additional notes.
 * @param attester Attests to accuracy of composition.
 * @param custodian Organization which maintains the composition. Reference to Organization.
 * @param relatesTo Relationships to other compositions/documents.
 * @param event The clinical service(s) being documented.
 * @param section Composition is broken into sections.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Composition">FHIR R5 Composition</a>
 */
public record Composition(
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
        FhirEnum<CompositionStatus> status,
        CodeableConcept type,
        List<CodeableConcept> category,
        List<Reference> subject,
        Reference encounter,
        FhirDateTime date,
        List<UsageContext> useContext,
        List<Reference> author,
        FhirString name,
        FhirString title,
        List<Annotation> note,
        List<Attester> attester,
        Reference custodian,
        List<RelatedArtifact> relatesTo,
        List<Event> event,
        List<Section> section) implements DomainResource {

    /**
     * Creates a {@code Composition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a required list is empty
     */
    public Composition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        category = category == null ? List.of() : List.copyOf(category);
        subject = subject == null ? List.of() : List.copyOf(subject);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        author = author == null ? List.of() : List.copyOf(author);
        note = note == null ? List.of() : List.copyOf(note);
        attester = attester == null ? List.of() : List.copyOf(attester);
        relatesTo = relatesTo == null ? List.of() : List.copyOf(relatesTo);
        event = event == null ? List.of() : List.copyOf(event);
        section = section == null ? List.of() : List.copyOf(section);
        Objects.requireNonNull(status, "Composition.status is required");
        Objects.requireNonNull(type, "Composition.type is required");
        Objects.requireNonNull(date, "Composition.date is required");
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Composition.author requires at least one value");
        }
        Objects.requireNonNull(title, "Composition.title is required");
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
     * Returns a builder initialized with the values of this {@code Composition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A participant who has attested to the accuracy of the composition/document.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param mode personal | professional | legal | official. Required.
     * @param time When the composition was attested.
     * @param party Who attested the composition. Reference to Patient, RelatedPerson, Practitioner, PractitionerRole,
     *   Organization.
     */
    public record Attester(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept mode,
            FhirDateTime time,
            Reference party) implements BackboneElement {

        /**
         * Creates an {@code Attester}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Attester {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(mode, "Composition.attester.mode is required");
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
         * Returns a builder initialized with the values of this {@code Attester}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Attester}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept mode;
            private FhirDateTime time;
            private Reference party;

            private Builder() {
            }

            private Builder(Attester original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.mode = original.mode();
                this.time = original.time();
                this.party = original.party();
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
             * Sets {@code mode}.
             *
             * @param mode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder mode(CodeableConcept mode) {
                this.mode = mode;
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
             * Sets {@code party}.
             *
             * @param party the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder party(Reference party) {
                this.party = party;
                return this;
            }

            /**
             * Builds the {@code Attester}.
             *
             * @return the {@code Attester}
             * @throws NullPointerException if a required element is absent
             */
            public Attester build() {
                return new Attester(
                        id, extension, modifierExtension, mode, time, party);
            }
        }
    }

    /**
     * The clinical service, such as a colonoscopy or an appendectomy, being documented.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param period The period covered by the documentation.
     * @param detail The event(s) being documented, as code(s), reference(s), or both.
     */
    public record Event(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Period period,
            List<CodeableReference> detail) implements BackboneElement {

        /**
         * Creates an {@code Event}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Event {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            detail = detail == null ? List.of() : List.copyOf(detail);
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
         * Returns a builder initialized with the values of this {@code Event}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Event}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Period period;
            private List<CodeableReference> detail = new ArrayList<>();

            private Builder() {
            }

            private Builder(Event original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.period = original.period();
                this.detail = new ArrayList<>(original.detail());
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
             * Replaces all {@code detail} values.
             *
             * @param detail the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder detail(List<CodeableReference> detail) {
                this.detail = detail == null ? new ArrayList<>() : new ArrayList<>(detail);
                return this;
            }

            /**
             * Adds a {@code detail} value.
             *
             * @param detail the value to add
             * @return this builder
             */
            public Builder addDetail(CodeableReference detail) {
                this.detail.add(Objects.requireNonNull(detail, "detail"));
                return this;
            }

            /**
             * Builds the {@code Event}.
             *
             * @return the {@code Event}
             */
            public Event build() {
                return new Event(
                        id, extension, modifierExtension, period, detail);
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
     * @param code Classification of section (recommended).
     * @param author Who and/or what authored the section. Reference to Practitioner, PractitionerRole, Device,
     *   Patient, RelatedPerson, Organization.
     * @param focus Who/what the section is about, when it is not about the subject of composition. Reference to
     *   Resource.
     * @param text Text summary of the section, for human interpretation.
     * @param orderedBy Order of section entries.
     * @param entry A reference to data that supports this section. Reference to Resource.
     * @param emptyReason Why the section is empty.
     * @param section Nested Section.
     */
    public record Section(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString title,
            CodeableConcept code,
            List<Reference> author,
            Reference focus,
            Narrative text,
            CodeableConcept orderedBy,
            List<Reference> entry,
            CodeableConcept emptyReason,
            List<Composition.Section> section) implements BackboneElement {

        /**
         * Creates a {@code Section}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Section {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            author = author == null ? List.of() : List.copyOf(author);
            entry = entry == null ? List.of() : List.copyOf(entry);
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
            private CodeableConcept code;
            private List<Reference> author = new ArrayList<>();
            private Reference focus;
            private Narrative text;
            private CodeableConcept orderedBy;
            private List<Reference> entry = new ArrayList<>();
            private CodeableConcept emptyReason;
            private List<Composition.Section> section = new ArrayList<>();

            private Builder() {
            }

            private Builder(Section original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.title = original.title();
                this.code = original.code();
                this.author = new ArrayList<>(original.author());
                this.focus = original.focus();
                this.text = original.text();
                this.orderedBy = original.orderedBy();
                this.entry = new ArrayList<>(original.entry());
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
             * Sets {@code focus}.
             *
             * @param focus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder focus(Reference focus) {
                this.focus = focus;
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
             * Replaces all {@code entry} values.
             *
             * @param entry the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder entry(List<Reference> entry) {
                this.entry = entry == null ? new ArrayList<>() : new ArrayList<>(entry);
                return this;
            }

            /**
             * Adds a {@code entry} value.
             *
             * @param entry the value to add
             * @return this builder
             */
            public Builder addEntry(Reference entry) {
                this.entry.add(Objects.requireNonNull(entry, "entry"));
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
            public Builder section(List<Composition.Section> section) {
                this.section = section == null ? new ArrayList<>() : new ArrayList<>(section);
                return this;
            }

            /**
             * Adds a {@code section} value.
             *
             * @param section the value to add
             * @return this builder
             */
            public Builder addSection(Composition.Section section) {
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
                        id, extension, modifierExtension, title, code, author, focus, text, orderedBy, entry,
                        emptyReason, section);
            }
        }
    }

    /** Builder for {@link Composition}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<CompositionStatus> status;
        private CodeableConcept type;
        private List<CodeableConcept> category = new ArrayList<>();
        private List<Reference> subject = new ArrayList<>();
        private Reference encounter;
        private FhirDateTime date;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<Reference> author = new ArrayList<>();
        private FhirString name;
        private FhirString title;
        private List<Annotation> note = new ArrayList<>();
        private List<Attester> attester = new ArrayList<>();
        private Reference custodian;
        private List<RelatedArtifact> relatesTo = new ArrayList<>();
        private List<Event> event = new ArrayList<>();
        private List<Section> section = new ArrayList<>();

        private Builder() {
        }

        private Builder(Composition original) {
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
            this.status = original.status();
            this.type = original.type();
            this.category = new ArrayList<>(original.category());
            this.subject = new ArrayList<>(original.subject());
            this.encounter = original.encounter();
            this.date = original.date();
            this.useContext = new ArrayList<>(original.useContext());
            this.author = new ArrayList<>(original.author());
            this.name = original.name();
            this.title = original.title();
            this.note = new ArrayList<>(original.note());
            this.attester = new ArrayList<>(original.attester());
            this.custodian = original.custodian();
            this.relatesTo = new ArrayList<>(original.relatesTo());
            this.event = new ArrayList<>(original.event());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<CompositionStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(CompositionStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Replaces all {@code category} values.
         *
         * @param category the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder category(List<CodeableConcept> category) {
            this.category = category == null ? new ArrayList<>() : new ArrayList<>(category);
            return this;
        }

        /**
         * Adds a {@code category} value.
         *
         * @param category the value to add
         * @return this builder
         */
        public Builder addCategory(CodeableConcept category) {
            this.category.add(Objects.requireNonNull(category, "category"));
            return this;
        }

        /**
         * Replaces all {@code subject} values.
         *
         * @param subject the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder subject(List<Reference> subject) {
            this.subject = subject == null ? new ArrayList<>() : new ArrayList<>(subject);
            return this;
        }

        /**
         * Adds a {@code subject} value.
         *
         * @param subject the value to add
         * @return this builder
         */
        public Builder addSubject(Reference subject) {
            this.subject.add(Objects.requireNonNull(subject, "subject"));
            return this;
        }

        /**
         * Sets {@code encounter}.
         *
         * @param encounter the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder encounter(Reference encounter) {
            this.encounter = encounter;
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
         * Replaces all {@code attester} values.
         *
         * @param attester the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder attester(List<Attester> attester) {
            this.attester = attester == null ? new ArrayList<>() : new ArrayList<>(attester);
            return this;
        }

        /**
         * Adds a {@code attester} value.
         *
         * @param attester the value to add
         * @return this builder
         */
        public Builder addAttester(Attester attester) {
            this.attester.add(Objects.requireNonNull(attester, "attester"));
            return this;
        }

        /**
         * Sets {@code custodian}.
         *
         * @param custodian the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder custodian(Reference custodian) {
            this.custodian = custodian;
            return this;
        }

        /**
         * Replaces all {@code relatesTo} values.
         *
         * @param relatesTo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relatesTo(List<RelatedArtifact> relatesTo) {
            this.relatesTo = relatesTo == null ? new ArrayList<>() : new ArrayList<>(relatesTo);
            return this;
        }

        /**
         * Adds a {@code relatesTo} value.
         *
         * @param relatesTo the value to add
         * @return this builder
         */
        public Builder addRelatesTo(RelatedArtifact relatesTo) {
            this.relatesTo.add(Objects.requireNonNull(relatesTo, "relatesTo"));
            return this;
        }

        /**
         * Replaces all {@code event} values.
         *
         * @param event the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder event(List<Event> event) {
            this.event = event == null ? new ArrayList<>() : new ArrayList<>(event);
            return this;
        }

        /**
         * Adds a {@code event} value.
         *
         * @param event the value to add
         * @return this builder
         */
        public Builder addEvent(Event event) {
            this.event.add(Objects.requireNonNull(event, "event"));
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
         * Builds the {@code Composition}.
         *
         * @return the {@code Composition}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public Composition build() {
            return new Composition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, status, type, category, subject, encounter, date, useContext, author, name, title, note,
                    attester, custodian, relatesTo, event, section);
        }
    }
}
