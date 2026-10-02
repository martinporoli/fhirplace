package se.poroli.fhirplace.r5.base.individuals;

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
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.AdministrativeGender;
import se.poroli.fhirplace.r5.valuesets.LinkType;

/**
 * Demographics and other administrative information about an individual or animal receiving care or other
 * health-related services.
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
 * @param identifier An identifier for this patient.
 * @param active Whether this patient's record is in active use. Modifier element.
 * @param name A name associated with the patient.
 * @param telecom A contact detail for the individual.
 * @param gender male | female | other | unknown.
 * @param birthDate The date of birth for the individual.
 * @param deceased Indicates if the individual is deceased or not. One of boolean, dateTime. Modifier element.
 * @param address An address for the individual.
 * @param maritalStatus Marital (civil) status of a patient.
 * @param multipleBirth Whether patient is part of a multiple birth. One of boolean, integer.
 * @param photo Image of the patient.
 * @param contact A contact party (e.g. guardian, partner, friend) for the patient.
 * @param communication A language which may be used to communicate with the patient about his or her health.
 * @param generalPractitioner Patient's nominated primary care provider. Reference to Organization, Practitioner,
 *   PractitionerRole.
 * @param managingOrganization Organization that is the custodian of the patient record. Reference to Organization.
 * @param link Link to a Patient or RelatedPerson resource that concerns the same actual individual. Modifier element.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Patient">FHIR R5 Patient</a>
 */
public record Patient(
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
        List<HumanName> name,
        List<ContactPoint> telecom,
        FhirEnum<AdministrativeGender> gender,
        FhirDate birthDate,
        DataType deceased,
        List<Address> address,
        CodeableConcept maritalStatus,
        DataType multipleBirth,
        List<Attachment> photo,
        List<Contact> contact,
        List<Communication> communication,
        List<Reference> generalPractitioner,
        Reference managingOrganization,
        List<Link> link) implements DomainResource {

    /**
     * Creates a {@code Patient}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Patient {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        name = name == null ? List.of() : List.copyOf(name);
        telecom = telecom == null ? List.of() : List.copyOf(telecom);
        address = address == null ? List.of() : List.copyOf(address);
        photo = photo == null ? List.of() : List.copyOf(photo);
        contact = contact == null ? List.of() : List.copyOf(contact);
        communication = communication == null ? List.of() : List.copyOf(communication);
        generalPractitioner = generalPractitioner == null ? List.of() : List.copyOf(generalPractitioner);
        link = link == null ? List.of() : List.copyOf(link);
        if (deceased != null && !(deceased instanceof FhirBoolean || deceased instanceof FhirDateTime)) {
            throw new IllegalArgumentException(
                    "Patient.deceased[x] must be one of boolean, dateTime, but was "
                            + deceased.getClass().getSimpleName());
        }
        if (multipleBirth != null && !(multipleBirth instanceof FhirBoolean
                || multipleBirth instanceof FhirInteger)) {
            throw new IllegalArgumentException(
                    "Patient.multipleBirth[x] must be one of boolean, integer, but was "
                            + multipleBirth.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Patient}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A contact party (e.g. guardian, partner, friend) for the patient.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param relationship The kind of relationship.
     * @param name A name associated with the contact person.
     * @param telecom A contact detail for the person.
     * @param address Address for the contact person.
     * @param gender male | female | other | unknown.
     * @param organization Organization that is associated with the contact. Reference to Organization.
     * @param period The period during which this contact person or organization is valid to be contacted relating to
     *   this patient.
     */
    public record Contact(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableConcept> relationship,
            HumanName name,
            List<ContactPoint> telecom,
            Address address,
            FhirEnum<AdministrativeGender> gender,
            Reference organization,
            Period period) implements BackboneElement {

        /**
         * Creates a {@code Contact}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Contact {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            relationship = relationship == null ? List.of() : List.copyOf(relationship);
            telecom = telecom == null ? List.of() : List.copyOf(telecom);
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
         * Returns a builder initialized with the values of this {@code Contact}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Contact}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<CodeableConcept> relationship = new ArrayList<>();
            private HumanName name;
            private List<ContactPoint> telecom = new ArrayList<>();
            private Address address;
            private FhirEnum<AdministrativeGender> gender;
            private Reference organization;
            private Period period;

            private Builder() {
            }

            private Builder(Contact original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.relationship = new ArrayList<>(original.relationship());
                this.name = original.name();
                this.telecom = new ArrayList<>(original.telecom());
                this.address = original.address();
                this.gender = original.gender();
                this.organization = original.organization();
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
             * Sets {@code name}.
             *
             * @param name the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder name(HumanName name) {
                this.name = name;
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
             * Sets {@code address}.
             *
             * @param address the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder address(Address address) {
                this.address = address;
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
             * Sets {@code organization}.
             *
             * @param organization the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder organization(Reference organization) {
                this.organization = organization;
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
             * Builds the {@code Contact}.
             *
             * @return the {@code Contact}
             */
            public Contact build() {
                return new Contact(
                        id, extension, modifierExtension, relationship, name, telecom, address, gender, organization,
                        period);
            }
        }
    }

    /**
     * A language which may be used to communicate with the patient about his or her health.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param language The language which can be used to communicate with the patient about his or her health.
     *   Required.
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
            Objects.requireNonNull(language, "Patient.communication.language is required");
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

    /**
     * Link to a Patient or RelatedPerson resource that concerns the same actual individual.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param other The other patient or related person resource that the link refers to. Reference to Patient,
     *   RelatedPerson. Required.
     * @param type replaced-by | replaces | refer | seealso. Required.
     */
    public record Link(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference other,
            FhirEnum<LinkType> type) implements BackboneElement {

        /**
         * Creates a {@code Link}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Link {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(other, "Patient.link.other is required");
            Objects.requireNonNull(type, "Patient.link.type is required");
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
         * Returns a builder initialized with the values of this {@code Link}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Link}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference other;
            private FhirEnum<LinkType> type;

            private Builder() {
            }

            private Builder(Link original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.other = original.other();
                this.type = original.type();
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
             * Sets {@code other}.
             *
             * @param other the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder other(Reference other) {
                this.other = other;
                return this;
            }

            /**
             * Sets {@code type}.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(FhirEnum<LinkType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(LinkType type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Builds the {@code Link}.
             *
             * @return the {@code Link}
             * @throws NullPointerException if a required element is absent
             */
            public Link build() {
                return new Link(
                        id, extension, modifierExtension, other, type);
            }
        }
    }

    /** Builder for {@link Patient}. Builders are mutable and not thread-safe. */
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
        private List<HumanName> name = new ArrayList<>();
        private List<ContactPoint> telecom = new ArrayList<>();
        private FhirEnum<AdministrativeGender> gender;
        private FhirDate birthDate;
        private DataType deceased;
        private List<Address> address = new ArrayList<>();
        private CodeableConcept maritalStatus;
        private DataType multipleBirth;
        private List<Attachment> photo = new ArrayList<>();
        private List<Contact> contact = new ArrayList<>();
        private List<Communication> communication = new ArrayList<>();
        private List<Reference> generalPractitioner = new ArrayList<>();
        private Reference managingOrganization;
        private List<Link> link = new ArrayList<>();

        private Builder() {
        }

        private Builder(Patient original) {
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
            this.name = new ArrayList<>(original.name());
            this.telecom = new ArrayList<>(original.telecom());
            this.gender = original.gender();
            this.birthDate = original.birthDate();
            this.deceased = original.deceased();
            this.address = new ArrayList<>(original.address());
            this.maritalStatus = original.maritalStatus();
            this.multipleBirth = original.multipleBirth();
            this.photo = new ArrayList<>(original.photo());
            this.contact = new ArrayList<>(original.contact());
            this.communication = new ArrayList<>(original.communication());
            this.generalPractitioner = new ArrayList<>(original.generalPractitioner());
            this.managingOrganization = original.managingOrganization();
            this.link = new ArrayList<>(original.link());
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
         * Sets {@code deceased} to a boolean.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(FhirBoolean deceased) {
            this.deceased = deceased;
            return this;
        }

        /**
         * Sets {@code deceased} to a dateTime.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(FhirDateTime deceased) {
            this.deceased = deceased;
            return this;
        }

        /**
         * Sets {@code deceased} to a boolean without id or extensions.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(Boolean deceased) {
            this.deceased = deceased == null ? null : FhirBoolean.of(deceased);
            return this;
        }

        /**
         * Sets {@code deceased} to a dateTime without id or extensions.
         *
         * @param deceased the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder deceased(Temporal deceased) {
            this.deceased = deceased == null ? null : FhirDateTime.of(deceased);
            return this;
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
         * Sets {@code maritalStatus}.
         *
         * @param maritalStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maritalStatus(CodeableConcept maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        /**
         * Sets {@code multipleBirth} to a boolean.
         *
         * @param multipleBirth the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder multipleBirth(FhirBoolean multipleBirth) {
            this.multipleBirth = multipleBirth;
            return this;
        }

        /**
         * Sets {@code multipleBirth} to a integer.
         *
         * @param multipleBirth the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder multipleBirth(FhirInteger multipleBirth) {
            this.multipleBirth = multipleBirth;
            return this;
        }

        /**
         * Sets {@code multipleBirth} to a boolean without id or extensions.
         *
         * @param multipleBirth the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder multipleBirth(Boolean multipleBirth) {
            this.multipleBirth = multipleBirth == null ? null : FhirBoolean.of(multipleBirth);
            return this;
        }

        /**
         * Sets {@code multipleBirth} to a integer without id or extensions.
         *
         * @param multipleBirth the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder multipleBirth(Integer multipleBirth) {
            this.multipleBirth = multipleBirth == null ? null : FhirInteger.of(multipleBirth);
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
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<Contact> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(Contact contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
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
         * Replaces all {@code generalPractitioner} values.
         *
         * @param generalPractitioner the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder generalPractitioner(List<Reference> generalPractitioner) {
            this.generalPractitioner = generalPractitioner == null
                    ? new ArrayList<>()
                    : new ArrayList<>(generalPractitioner);
            return this;
        }

        /**
         * Adds a {@code generalPractitioner} value.
         *
         * @param generalPractitioner the value to add
         * @return this builder
         */
        public Builder addGeneralPractitioner(Reference generalPractitioner) {
            this.generalPractitioner.add(Objects.requireNonNull(generalPractitioner, "generalPractitioner"));
            return this;
        }

        /**
         * Sets {@code managingOrganization}.
         *
         * @param managingOrganization the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder managingOrganization(Reference managingOrganization) {
            this.managingOrganization = managingOrganization;
            return this;
        }

        /**
         * Replaces all {@code link} values.
         *
         * @param link the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder link(List<Link> link) {
            this.link = link == null ? new ArrayList<>() : new ArrayList<>(link);
            return this;
        }

        /**
         * Adds a {@code link} value.
         *
         * @param link the value to add
         * @return this builder
         */
        public Builder addLink(Link link) {
            this.link.add(Objects.requireNonNull(link, "link"));
            return this;
        }

        /**
         * Builds the {@code Patient}.
         *
         * @return the {@code Patient}
         */
        public Patient build() {
            return new Patient(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    active, name, telecom, gender, birthDate, deceased, address, maritalStatus, multipleBirth, photo,
                    contact, communication, generalPractitioner, managingOrganization, link);
        }
    }
}
