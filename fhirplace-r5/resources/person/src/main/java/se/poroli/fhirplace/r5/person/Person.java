package se.poroli.fhirplace.r5.person;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
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
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.AdministrativeGender;

/**
 * Demographics and administrative information about a person independent of a specific health-related context.
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
 * @param active This person's record is in active use. Modifier element.
 * @param name A name associated with the person.
 * @param telecom A contact detail for the person.
 * @param gender male | female | other | unknown.
 * @param birthDate The date on which the person was born.
 * @param deceased Indicates if the individual is deceased or not. One of boolean, dateTime.
 * @param address One or more addresses for the person.
 * @param maritalStatus Marital (civil) status of a person.
 * @param photo Image of the person.
 * @param communication A language which may be used to communicate with the person about his or her health.
 * @param managingOrganization The organization that is the custodian of the person record. Reference to Organization.
 * @param link Link to a resource that concerns the same actual person.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Person">FHIR R5 Person</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Person(
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
        List<Attachment> photo,
        List<Communication> communication,
        Reference managingOrganization,
        List<Link> link) implements DomainResource {

    /**
     * Creates a {@code Person}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Person {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        name = name == null ? List.of() : List.copyOf(name);
        telecom = telecom == null ? List.of() : List.copyOf(telecom);
        address = address == null ? List.of() : List.copyOf(address);
        photo = photo == null ? List.of() : List.copyOf(photo);
        communication = communication == null ? List.of() : List.copyOf(communication);
        link = link == null ? List.of() : List.copyOf(link);
        if (deceased != null && !(deceased instanceof FhirBoolean || deceased instanceof FhirDateTime)) {
            throw new IllegalArgumentException(
                    "Person.deceased[x] must be one of boolean, dateTime, but was "
                            + deceased.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Person}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A language which may be used to communicate with the person about his or her health.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param language The language which can be used to communicate with the person about his or her health.
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
            Objects.requireNonNull(language, "Person.communication.language is required");
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
     * Link to a resource that concerns the same actual person.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param target The resource to which this actual person is associated. Reference to Patient, Practitioner,
     *   RelatedPerson, Person. Required.
     * @param assurance level1 | level2 | level3 | level4.
     */
    public record Link(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference target,
            FhirEnum<IdentityAssuranceLevel> assurance) implements BackboneElement {

        /**
         * Creates a {@code Link}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Link {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(target, "Person.link.target is required");
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
            private Reference target;
            private FhirEnum<IdentityAssuranceLevel> assurance;

            private Builder() {
            }

            private Builder(Link original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.target = original.target();
                this.assurance = original.assurance();
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
             * Sets {@code target}.
             *
             * @param target the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder target(Reference target) {
                this.target = target;
                return this;
            }

            /**
             * Sets {@code assurance}.
             *
             * @param assurance the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder assurance(FhirEnum<IdentityAssuranceLevel> assurance) {
                this.assurance = assurance;
                return this;
            }

            /**
             * Sets {@code assurance}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param assurance the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder assurance(IdentityAssuranceLevel assurance) {
                return assurance(assurance == null ? null : FhirEnum.of(assurance));
            }

            /**
             * Builds the {@code Link}.
             *
             * @return the {@code Link}
             * @throws NullPointerException if a required element is absent
             */
            public Link build() {
                return new Link(
                        id, extension, modifierExtension, target, assurance);
            }
        }
    }

    /** Builder for {@link Person}. Builders are mutable and not thread-safe. */
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
        private List<Attachment> photo = new ArrayList<>();
        private List<Communication> communication = new ArrayList<>();
        private Reference managingOrganization;
        private List<Link> link = new ArrayList<>();

        private Builder() {
        }

        private Builder(Person original) {
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
            this.photo = new ArrayList<>(original.photo());
            this.communication = new ArrayList<>(original.communication());
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
         * Builds the {@code Person}.
         *
         * @return the {@code Person}
         */
        public Person build() {
            return new Person(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    active, name, telecom, gender, birthDate, deceased, address, maritalStatus, photo, communication,
                    managingOrganization, link);
        }
    }
}
