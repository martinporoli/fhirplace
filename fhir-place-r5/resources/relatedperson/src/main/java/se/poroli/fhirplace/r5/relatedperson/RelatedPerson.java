package se.poroli.fhirplace.r5.relatedperson;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.AdministrativeGender;

/**
 * Information about a person that is involved in a patient's health or the care for a patient, but who is not the
 * target of healthcare, nor has a formal responsibility in the care process.
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
 * @param identifier A human identifier for this person.
 * @param active Whether this related person's record is in active use. Modifier element.
 * @param patient The patient this person is related to. Reference to Patient. Required.
 * @param relationship The relationship of the related person to the patient.
 * @param name A name associated with the person.
 * @param telecom A contact detail for the person.
 * @param gender male | female | other | unknown.
 * @param birthDate The date on which the related person was born.
 * @param address Address where the related person can be contacted or visited.
 * @param photo Image of the person.
 * @param period Period of time that this relationship is considered valid.
 * @param communication A language which may be used to communicate with the related person about the patient's
 *   health.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/RelatedPerson">FHIR R5 RelatedPerson</a>
 */
public record RelatedPerson(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirBoolean active,
        Reference patient,
        List<CodeableConcept> relationship,
        List<HumanName> name,
        List<ContactPoint> telecom,
        FhirEnum<AdministrativeGender> gender,
        FhirDate birthDate,
        List<Address> address,
        List<Attachment> photo,
        Period period,
        List<Communication> communication) implements DomainResource {

    /**
     * Creates a {@code RelatedPerson}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public RelatedPerson {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        relationship = relationship == null ? List.of() : List.copyOf(relationship);
        name = name == null ? List.of() : List.copyOf(name);
        telecom = telecom == null ? List.of() : List.copyOf(telecom);
        address = address == null ? List.of() : List.copyOf(address);
        photo = photo == null ? List.of() : List.copyOf(photo);
        communication = communication == null ? List.of() : List.copyOf(communication);
        Objects.requireNonNull(patient, "RelatedPerson.patient is required");
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
     * Returns a builder initialized with the values of this {@code RelatedPerson}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A language which may be used to communicate with the related person about the patient's health.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param language The language which can be used to communicate with the related person about the patient's
     *   health. Required.
     * @param preferred Language preference indicator.
     */
    public record Communication(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept language,
            FhirBoolean preferred) implements BackboneElement {

        /**
         * Creates a {@code Communication}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Communication {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(language, "RelatedPerson.communication.language is required");
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
         * Returns a builder initialized with the values of this {@code Communication}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Communication}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept language;
            private FhirBoolean preferred;

            private Builder() {
            }

            private Builder(Communication original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.language = original.language();
                this.preferred = original.preferred();
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
             * Sets {@code preferred}.
             *
             * @param preferred the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder preferred(FhirBoolean preferred) {
                this.preferred = preferred;
                return this;
            }

            /**
             * Sets {@code preferred}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param preferred the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder preferred(Boolean preferred) {
                return preferred(preferred == null ? null : FhirBoolean.of(preferred));
            }

            /**
             * Builds the {@code Communication}.
             *
             * @return the {@code Communication}
             * @throws NullPointerException if a required element is absent
             */
            public Communication build() {
                return new Communication(
                        id, extension, modifierExtension, language, preferred);
            }
        }
    }

    /** Builder for {@link RelatedPerson}. Builders are mutable and not thread-safe. */
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
        private FhirBoolean active;
        private Reference patient;
        private List<CodeableConcept> relationship = new ArrayList<>();
        private List<HumanName> name = new ArrayList<>();
        private List<ContactPoint> telecom = new ArrayList<>();
        private FhirEnum<AdministrativeGender> gender;
        private FhirDate birthDate;
        private List<Address> address = new ArrayList<>();
        private List<Attachment> photo = new ArrayList<>();
        private Period period;
        private List<Communication> communication = new ArrayList<>();

        private Builder() {
        }

        private Builder(RelatedPerson original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.active = original.active();
            this.patient = original.patient();
            this.relationship = new ArrayList<>(original.relationship());
            this.name = new ArrayList<>(original.name());
            this.telecom = new ArrayList<>(original.telecom());
            this.gender = original.gender();
            this.birthDate = original.birthDate();
            this.address = new ArrayList<>(original.address());
            this.photo = new ArrayList<>(original.photo());
            this.period = original.period();
            this.communication = new ArrayList<>(original.communication());
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
         * Sets {@code active}.
         *
         * @param active the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder active(FhirBoolean active) {
            this.active = active;
            return this;
        }

        /**
         * Sets {@code active}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param active the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder active(Boolean active) {
            return active(active == null ? null : FhirBoolean.of(active));
        }

        /**
         * Sets {@code patient}.
         *
         * @param patient the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder patient(Reference patient) {
            this.patient = patient;
            return this;
        }

        /**
         * Replaces all {@code relationship} values.
         *
         * @param relationship the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relationship(List<CodeableConcept> relationship) {
            this.relationship = relationship == null ? new ArrayList<>() : new ArrayList<>(relationship);
            return this;
        }

        /**
         * Adds a {@code relationship} value.
         *
         * @param relationship the value to add
         * @return this builder
         */
        public Builder addRelationship(CodeableConcept relationship) {
            this.relationship.add(Objects.requireNonNull(relationship, "relationship"));
            return this;
        }

        /**
         * Replaces all {@code name} values.
         *
         * @param name the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder name(List<HumanName> name) {
            this.name = name == null ? new ArrayList<>() : new ArrayList<>(name);
            return this;
        }

        /**
         * Adds a {@code name} value.
         *
         * @param name the value to add
         * @return this builder
         */
        public Builder addName(HumanName name) {
            this.name.add(Objects.requireNonNull(name, "name"));
            return this;
        }

        /**
         * Replaces all {@code telecom} values.
         *
         * @param telecom the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder telecom(List<ContactPoint> telecom) {
            this.telecom = telecom == null ? new ArrayList<>() : new ArrayList<>(telecom);
            return this;
        }

        /**
         * Adds a {@code telecom} value.
         *
         * @param telecom the value to add
         * @return this builder
         */
        public Builder addTelecom(ContactPoint telecom) {
            this.telecom.add(Objects.requireNonNull(telecom, "telecom"));
            return this;
        }

        /**
         * Sets {@code gender}.
         *
         * @param gender the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder gender(FhirEnum<AdministrativeGender> gender) {
            this.gender = gender;
            return this;
        }

        /**
         * Sets {@code gender}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param gender the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder gender(AdministrativeGender gender) {
            return gender(gender == null ? null : FhirEnum.of(gender));
        }

        /**
         * Sets {@code birthDate}.
         *
         * @param birthDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder birthDate(FhirDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        /**
         * Sets {@code birthDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param birthDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder birthDate(Temporal birthDate) {
            return birthDate(birthDate == null ? null : FhirDate.of(birthDate));
        }

        /**
         * Replaces all {@code address} values.
         *
         * @param address the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder address(List<Address> address) {
            this.address = address == null ? new ArrayList<>() : new ArrayList<>(address);
            return this;
        }

        /**
         * Adds a {@code address} value.
         *
         * @param address the value to add
         * @return this builder
         */
        public Builder addAddress(Address address) {
            this.address.add(Objects.requireNonNull(address, "address"));
            return this;
        }

        /**
         * Replaces all {@code photo} values.
         *
         * @param photo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder photo(List<Attachment> photo) {
            this.photo = photo == null ? new ArrayList<>() : new ArrayList<>(photo);
            return this;
        }

        /**
         * Adds a {@code photo} value.
         *
         * @param photo the value to add
         * @return this builder
         */
        public Builder addPhoto(Attachment photo) {
            this.photo.add(Objects.requireNonNull(photo, "photo"));
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
         * Replaces all {@code communication} values.
         *
         * @param communication the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder communication(List<Communication> communication) {
            this.communication = communication == null ? new ArrayList<>() : new ArrayList<>(communication);
            return this;
        }

        /**
         * Adds a {@code communication} value.
         *
         * @param communication the value to add
         * @return this builder
         */
        public Builder addCommunication(Communication communication) {
            this.communication.add(Objects.requireNonNull(communication, "communication"));
            return this;
        }

        /**
         * Builds the {@code RelatedPerson}.
         *
         * @return the {@code RelatedPerson}
         * @throws NullPointerException if a required element is absent
         */
        public RelatedPerson build() {
            return new RelatedPerson(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    active, patient, relationship, name, telecom, gender, birthDate, address, photo, period,
                    communication);
        }
    }
}
