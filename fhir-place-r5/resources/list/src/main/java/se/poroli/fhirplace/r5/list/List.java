package se.poroli.fhirplace.r5.list;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.ListMode;

/**
 * A List is a curated collection of resources, for things such as problem lists, allergy lists, facility list,
 * organization list, etc.
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
 * @param identifier Business identifier.
 * @param status current | retired | entered-in-error. Required. Modifier element.
 * @param mode working | snapshot | changes. Required. Modifier element.
 * @param title Descriptive name for the list.
 * @param code What the purpose of this list is.
 * @param subject If all resources have the same subject(s). Reference to Resource.
 * @param encounter Context in which list created. Reference to Encounter.
 * @param date When the list was prepared.
 * @param source Who and/or what defined the list contents (aka Author). Reference to Practitioner, PractitionerRole,
 *   Patient, Device, Organization, RelatedPerson, CareTeam.
 * @param orderedBy What order the list has.
 * @param note Comments about the list.
 * @param entry Entries in the list.
 * @param emptyReason Why list is empty.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/List">FHIR R5 java.util.List</a>
 */
public record List(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        java.util.List<Resource> contained,
        java.util.List<Extension> extension,
        java.util.List<Extension> modifierExtension,
        java.util.List<Identifier> identifier,
        FhirEnum<ListStatus> status,
        FhirEnum<ListMode> mode,
        FhirString title,
        CodeableConcept code,
        java.util.List<Reference> subject,
        Reference encounter,
        FhirDateTime date,
        Reference source,
        CodeableConcept orderedBy,
        java.util.List<Annotation> note,
        java.util.List<Entry> entry,
        CodeableConcept emptyReason) implements DomainResource {

    /**
     * Creates a {@code List}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public List {
        contained = contained == null ? java.util.List.of() : java.util.List.copyOf(contained);
        extension = extension == null ? java.util.List.of() : java.util.List.copyOf(extension);
        modifierExtension =
                modifierExtension == null ? java.util.List.of() : java.util.List.copyOf(modifierExtension);
        identifier = identifier == null ? java.util.List.of() : java.util.List.copyOf(identifier);
        subject = subject == null ? java.util.List.of() : java.util.List.copyOf(subject);
        note = note == null ? java.util.List.of() : java.util.List.copyOf(note);
        entry = entry == null ? java.util.List.of() : java.util.List.copyOf(entry);
        Objects.requireNonNull(status, "List.status is required");
        Objects.requireNonNull(mode, "List.mode is required");
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
     * Returns a builder initialized with the values of this {@code List}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Entries in this list.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param flag Status/Workflow information about this item.
     * @param deleted If this item is actually marked as deleted. Modifier element.
     * @param date When item added to list.
     * @param item Actual entry. Reference to Resource. Required.
     */
    public record Entry(
            String id,
            java.util.List<Extension> extension,
            java.util.List<Extension> modifierExtension,
            CodeableConcept flag,
            FhirBoolean deleted,
            FhirDateTime date,
            Reference item) implements BackboneElement {

        /**
         * Creates an {@code Entry}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Entry {
            extension = extension == null ? java.util.List.of() : java.util.List.copyOf(extension);
            modifierExtension =
                    modifierExtension == null ? java.util.List.of() : java.util.List.copyOf(modifierExtension);
            Objects.requireNonNull(item, "List.entry.item is required");
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

        /** Builder for {@link Entry}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private java.util.List<Extension> extension = new ArrayList<>();
            private java.util.List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept flag;
            private FhirBoolean deleted;
            private FhirDateTime date;
            private Reference item;

            private Builder() {
            }

            private Builder(Entry original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.flag = original.flag();
                this.deleted = original.deleted();
                this.date = original.date();
                this.item = original.item();
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
            public Builder extension(java.util.List<Extension> extension) {
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
            public Builder modifierExtension(java.util.List<Extension> modifierExtension) {
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
             * Sets {@code flag}.
             *
             * @param flag the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder flag(CodeableConcept flag) {
                this.flag = flag;
                return this;
            }

            /**
             * Sets {@code deleted}.
             *
             * @param deleted the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder deleted(FhirBoolean deleted) {
                this.deleted = deleted;
                return this;
            }

            /**
             * Sets {@code deleted}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param deleted the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder deleted(Boolean deleted) {
                return deleted(deleted == null ? null : FhirBoolean.of(deleted));
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
             * Sets {@code item}.
             *
             * @param item the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder item(Reference item) {
                this.item = item;
                return this;
            }

            /**
             * Builds the {@code Entry}.
             *
             * @return the {@code Entry}
             * @throws NullPointerException if a required element is absent
             */
            public Entry build() {
                return new Entry(
                        id, extension, modifierExtension, flag, deleted, date, item);
            }
        }
    }

    /** Builder for {@link List}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private java.util.List<Resource> contained = new ArrayList<>();
        private java.util.List<Extension> extension = new ArrayList<>();
        private java.util.List<Extension> modifierExtension = new ArrayList<>();
        private java.util.List<Identifier> identifier = new ArrayList<>();
        private FhirEnum<ListStatus> status;
        private FhirEnum<ListMode> mode;
        private FhirString title;
        private CodeableConcept code;
        private java.util.List<Reference> subject = new ArrayList<>();
        private Reference encounter;
        private FhirDateTime date;
        private Reference source;
        private CodeableConcept orderedBy;
        private java.util.List<Annotation> note = new ArrayList<>();
        private java.util.List<Entry> entry = new ArrayList<>();
        private CodeableConcept emptyReason;

        private Builder() {
        }

        private Builder(List original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.status = original.status();
            this.mode = original.mode();
            this.title = original.title();
            this.code = original.code();
            this.subject = new ArrayList<>(original.subject());
            this.encounter = original.encounter();
            this.date = original.date();
            this.source = original.source();
            this.orderedBy = original.orderedBy();
            this.note = new ArrayList<>(original.note());
            this.entry = new ArrayList<>(original.entry());
            this.emptyReason = original.emptyReason();
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
        public Builder contained(java.util.List<Resource> contained) {
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
        public Builder extension(java.util.List<Extension> extension) {
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
        public Builder modifierExtension(java.util.List<Extension> modifierExtension) {
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
        public Builder identifier(java.util.List<Identifier> identifier) {
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<ListStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(ListStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Replaces all {@code subject} values.
         *
         * @param subject the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder subject(java.util.List<Reference> subject) {
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
         * Sets {@code source}.
         *
         * @param source the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder source(Reference source) {
            this.source = source;
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
         * Replaces all {@code note} values.
         *
         * @param note the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder note(java.util.List<Annotation> note) {
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
         * Replaces all {@code entry} values.
         *
         * @param entry the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder entry(java.util.List<Entry> entry) {
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
         * Builds the {@code List}.
         *
         * @return the {@code List}
         * @throws NullPointerException if a required element is absent
         */
        public List build() {
            return new List(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, mode, title, code, subject, encounter, date, source, orderedBy, note, entry, emptyReason);
        }
    }
}
