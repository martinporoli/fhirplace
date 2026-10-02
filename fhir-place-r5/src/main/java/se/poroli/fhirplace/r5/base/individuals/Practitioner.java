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
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.AdministrativeGender;

/**
 * A person who is directly or indirectly involved in the provisioning of healthcare or related services.
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
 * @param identifier An identifier for the person as this agent.
 * @param active Whether this practitioner's record is in active use. Modifier element.
 * @param name The name(s) associated with the practitioner.
 * @param telecom A contact detail for the practitioner (that apply to all roles).
 * @param gender male | female | other | unknown.
 * @param birthDate The date on which the practitioner was born.
 * @param deceased Indicates if the practitioner is deceased or not. One of boolean, dateTime.
 * @param address Address(es) of the practitioner that are not role specific (typically home address).
 * @param photo Image of the person.
 * @param qualification Qualifications, certifications, accreditations, licenses, training, etc. pertaining to the
 *   provision of care.
 * @param communication A language which may be used to communicate with the practitioner.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Practitioner">FHIR R5 Practitioner</a>
 */
public record Practitioner(
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
        List<Attachment> photo,
        List<Qualification> qualification,
        List<Communication> communication) implements DomainResource {

    /**
     * Creates a {@code Practitioner}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Practitioner {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        name = name == null ? List.of() : List.copyOf(name);
        telecom = telecom == null ? List.of() : List.copyOf(telecom);
        address = address == null ? List.of() : List.copyOf(address);
        photo = photo == null ? List.of() : List.copyOf(photo);
        qualification = qualification == null ? List.of() : List.copyOf(qualification);
        communication = communication == null ? List.of() : List.copyOf(communication);
        if (deceased != null && !(deceased instanceof FhirBoolean || deceased instanceof FhirDateTime)) {
            throw new IllegalArgumentException(
                    "Practitioner.deceased[x] must be one of boolean, dateTime, but was "
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
     * Returns a builder initialized with the values of this {@code Practitioner}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The official qualifications, certifications, accreditations, training, licenses (and other types of
     * educations/skills/capabilities) that authorize or otherwise pertain to the provision of care by the
     * practitioner.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier An identifier for this qualification for the practitioner.
     * @param code Coded representation of the qualification. Required.
     * @param period Period during which the qualification is valid.
     * @param issuer Organization that regulates and issues the qualification. Reference to Organization.
     */
    public record Qualification(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Identifier> identifier,
            CodeableConcept code,
            Period period,
            Reference issuer) implements BackboneElement {

        /**
         * Creates a {@code Qualification}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Qualification {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            identifier = identifier == null ? List.of() : List.copyOf(identifier);
            Objects.requireNonNull(code, "Practitioner.qualification.code is required");
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
         * Returns a builder initialized with the values of this {@code Qualification}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Qualification}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Identifier> identifier = new ArrayList<>();
            private CodeableConcept code;
            private Period period;
            private Reference issuer;

            private Builder() {
            }

            private Builder(Qualification original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = new ArrayList<>(original.identifier());
                this.code = original.code();
                this.period = original.period();
                this.issuer = original.issuer();
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
             * Sets {@code issuer}.
             *
             * @param issuer the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder issuer(Reference issuer) {
                this.issuer = issuer;
                return this;
            }

            /**
             * Builds the {@code Qualification}.
             *
             * @return the {@code Qualification}
             * @throws NullPointerException if a required element is absent
             */
            public Qualification build() {
                return new Qualification(
                        id, extension, modifierExtension, identifier, code, period, issuer);
            }
        }
    }

    /**
     * A language which may be used to communicate with the practitioner, often for correspondence/administrative
     * purposes.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param language The language code used to communicate with the practitioner. Required.
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
            Objects.requireNonNull(language, "Practitioner.communication.language is required");
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

    /** Builder for {@link Practitioner}. Builders are mutable and not thread-safe. */
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
        private List<Attachment> photo = new ArrayList<>();
        private List<Qualification> qualification = new ArrayList<>();
        private List<Communication> communication = new ArrayList<>();

        private Builder() {
        }

        private Builder(Practitioner original) {
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
            this.photo = new ArrayList<>(original.photo());
            this.qualification = new ArrayList<>(original.qualification());
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
         * Replaces all {@code qualification} values.
         *
         * @param qualification the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder qualification(List<Qualification> qualification) {
            this.qualification = qualification == null ? new ArrayList<>() : new ArrayList<>(qualification);
            return this;
        }

        /**
         * Adds a {@code qualification} value.
         *
         * @param qualification the value to add
         * @return this builder
         */
        public Builder addQualification(Qualification qualification) {
            this.qualification.add(Objects.requireNonNull(qualification, "qualification"));
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
         * Builds the {@code Practitioner}.
         *
         * @return the {@code Practitioner}
         */
        public Practitioner build() {
            return new Practitioner(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    active, name, telecom, gender, birthDate, deceased, address, photo, qualification, communication);
        }
    }
}
