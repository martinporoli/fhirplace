package se.poroli.fhirplace.r5.healthcareservice;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.Availability;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * The details of a healthcare service available at a location or in a catalog.
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
 * @param identifier External identifiers for this item.
 * @param active Whether this HealthcareService record is in active use. Modifier element.
 * @param providedBy Organization that provides this service. Reference to Organization.
 * @param offeredIn The service within which this service is offered. Reference to HealthcareService.
 * @param category Broad category of service being performed or delivered.
 * @param type Type of service that may be delivered or performed.
 * @param specialty Specialties handled by the HealthcareService.
 * @param location Location(s) where service may be provided. Reference to Location.
 * @param name Description of service as presented to a consumer while searching.
 * @param comment Additional description and/or any specific issues not covered elsewhere.
 * @param extraDetails Extra details about the service that can't be placed in the other fields.
 * @param photo Facilitates quick identification of the service.
 * @param contact Official contact details for the HealthcareService.
 * @param coverageArea Location(s) service is intended for/available to. Reference to Location.
 * @param serviceProvisionCode Conditions under which service is available/offered.
 * @param eligibility Specific eligibility requirements required to use the service.
 * @param program Programs that this service is applicable to.
 * @param characteristic Collection of characteristics (attributes).
 * @param communication The language that this service is offered in.
 * @param referralMethod Ways that the service accepts referrals.
 * @param appointmentRequired If an appointment is required for access to this service.
 * @param availability Times the healthcare service is available (including exceptions).
 * @param endpoint Technical endpoints providing access to electronic services operated for the healthcare service.
 *   Reference to Endpoint.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/HealthcareService">FHIR R5 HealthcareService</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record HealthcareService(
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
        Reference providedBy,
        List<Reference> offeredIn,
        List<CodeableConcept> category,
        List<CodeableConcept> type,
        List<CodeableConcept> specialty,
        List<Reference> location,
        FhirString name,
        FhirMarkdown comment,
        FhirMarkdown extraDetails,
        Attachment photo,
        List<ExtendedContactDetail> contact,
        List<Reference> coverageArea,
        List<CodeableConcept> serviceProvisionCode,
        List<Eligibility> eligibility,
        List<CodeableConcept> program,
        List<CodeableConcept> characteristic,
        List<CodeableConcept> communication,
        List<CodeableConcept> referralMethod,
        FhirBoolean appointmentRequired,
        List<Availability> availability,
        List<Reference> endpoint) implements DomainResource {

    /**
     * Creates a {@code HealthcareService}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public HealthcareService {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        offeredIn = offeredIn == null ? List.of() : List.copyOf(offeredIn);
        category = category == null ? List.of() : List.copyOf(category);
        type = type == null ? List.of() : List.copyOf(type);
        specialty = specialty == null ? List.of() : List.copyOf(specialty);
        location = location == null ? List.of() : List.copyOf(location);
        contact = contact == null ? List.of() : List.copyOf(contact);
        coverageArea = coverageArea == null ? List.of() : List.copyOf(coverageArea);
        serviceProvisionCode = serviceProvisionCode == null ? List.of() : List.copyOf(serviceProvisionCode);
        eligibility = eligibility == null ? List.of() : List.copyOf(eligibility);
        program = program == null ? List.of() : List.copyOf(program);
        characteristic = characteristic == null ? List.of() : List.copyOf(characteristic);
        communication = communication == null ? List.of() : List.copyOf(communication);
        referralMethod = referralMethod == null ? List.of() : List.copyOf(referralMethod);
        availability = availability == null ? List.of() : List.copyOf(availability);
        endpoint = endpoint == null ? List.of() : List.copyOf(endpoint);
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
     * Returns a builder initialized with the values of this {@code HealthcareService}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Does this service have specific eligibility requirements that need to be met in order to use the service?.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Coded value for the eligibility.
     * @param comment Describes the eligibility conditions for the service.
     */
    public record Eligibility(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            FhirMarkdown comment) implements BackboneElement {

        /**
         * Creates an {@code Eligibility}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Eligibility {
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
         * Returns a builder initialized with the values of this {@code Eligibility}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Eligibility}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private FhirMarkdown comment;

            private Builder() {
            }

            private Builder(Eligibility original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.comment = original.comment();
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
             * Sets {@code comment}.
             *
             * @param comment the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder comment(FhirMarkdown comment) {
                this.comment = comment;
                return this;
            }

            /**
             * Sets {@code comment}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param comment the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder comment(String comment) {
                return comment(comment == null ? null : FhirMarkdown.of(comment));
            }

            /**
             * Builds the {@code Eligibility}.
             *
             * @return the {@code Eligibility}
             */
            public Eligibility build() {
                return new Eligibility(
                        id, extension, modifierExtension, code, comment);
            }
        }
    }

    /** Builder for {@link HealthcareService}. Builders are mutable and not thread-safe. */
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
        private Reference providedBy;
        private List<Reference> offeredIn = new ArrayList<>();
        private List<CodeableConcept> category = new ArrayList<>();
        private List<CodeableConcept> type = new ArrayList<>();
        private List<CodeableConcept> specialty = new ArrayList<>();
        private List<Reference> location = new ArrayList<>();
        private FhirString name;
        private FhirMarkdown comment;
        private FhirMarkdown extraDetails;
        private Attachment photo;
        private List<ExtendedContactDetail> contact = new ArrayList<>();
        private List<Reference> coverageArea = new ArrayList<>();
        private List<CodeableConcept> serviceProvisionCode = new ArrayList<>();
        private List<Eligibility> eligibility = new ArrayList<>();
        private List<CodeableConcept> program = new ArrayList<>();
        private List<CodeableConcept> characteristic = new ArrayList<>();
        private List<CodeableConcept> communication = new ArrayList<>();
        private List<CodeableConcept> referralMethod = new ArrayList<>();
        private FhirBoolean appointmentRequired;
        private List<Availability> availability = new ArrayList<>();
        private List<Reference> endpoint = new ArrayList<>();

        private Builder() {
        }

        private Builder(HealthcareService original) {
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
            this.providedBy = original.providedBy();
            this.offeredIn = new ArrayList<>(original.offeredIn());
            this.category = new ArrayList<>(original.category());
            this.type = new ArrayList<>(original.type());
            this.specialty = new ArrayList<>(original.specialty());
            this.location = new ArrayList<>(original.location());
            this.name = original.name();
            this.comment = original.comment();
            this.extraDetails = original.extraDetails();
            this.photo = original.photo();
            this.contact = new ArrayList<>(original.contact());
            this.coverageArea = new ArrayList<>(original.coverageArea());
            this.serviceProvisionCode = new ArrayList<>(original.serviceProvisionCode());
            this.eligibility = new ArrayList<>(original.eligibility());
            this.program = new ArrayList<>(original.program());
            this.characteristic = new ArrayList<>(original.characteristic());
            this.communication = new ArrayList<>(original.communication());
            this.referralMethod = new ArrayList<>(original.referralMethod());
            this.appointmentRequired = original.appointmentRequired();
            this.availability = new ArrayList<>(original.availability());
            this.endpoint = new ArrayList<>(original.endpoint());
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
         * Sets {@code providedBy}.
         *
         * @param providedBy the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder providedBy(Reference providedBy) {
            this.providedBy = providedBy;
            return this;
        }

        /**
         * Replaces all {@code offeredIn} values.
         *
         * @param offeredIn the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder offeredIn(List<Reference> offeredIn) {
            this.offeredIn = offeredIn == null ? new ArrayList<>() : new ArrayList<>(offeredIn);
            return this;
        }

        /**
         * Adds a {@code offeredIn} value.
         *
         * @param offeredIn the value to add
         * @return this builder
         */
        public Builder addOfferedIn(Reference offeredIn) {
            this.offeredIn.add(Objects.requireNonNull(offeredIn, "offeredIn"));
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
         * Replaces all {@code specialty} values.
         *
         * @param specialty the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder specialty(List<CodeableConcept> specialty) {
            this.specialty = specialty == null ? new ArrayList<>() : new ArrayList<>(specialty);
            return this;
        }

        /**
         * Adds a {@code specialty} value.
         *
         * @param specialty the value to add
         * @return this builder
         */
        public Builder addSpecialty(CodeableConcept specialty) {
            this.specialty.add(Objects.requireNonNull(specialty, "specialty"));
            return this;
        }

        /**
         * Replaces all {@code location} values.
         *
         * @param location the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder location(List<Reference> location) {
            this.location = location == null ? new ArrayList<>() : new ArrayList<>(location);
            return this;
        }

        /**
         * Adds a {@code location} value.
         *
         * @param location the value to add
         * @return this builder
         */
        public Builder addLocation(Reference location) {
            this.location.add(Objects.requireNonNull(location, "location"));
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
         * Sets {@code comment}.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(FhirMarkdown comment) {
            this.comment = comment;
            return this;
        }

        /**
         * Sets {@code comment}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param comment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder comment(String comment) {
            return comment(comment == null ? null : FhirMarkdown.of(comment));
        }

        /**
         * Sets {@code extraDetails}.
         *
         * @param extraDetails the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder extraDetails(FhirMarkdown extraDetails) {
            this.extraDetails = extraDetails;
            return this;
        }

        /**
         * Sets {@code extraDetails}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param extraDetails the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder extraDetails(String extraDetails) {
            return extraDetails(extraDetails == null ? null : FhirMarkdown.of(extraDetails));
        }

        /**
         * Sets {@code photo}.
         *
         * @param photo the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder photo(Attachment photo) {
            this.photo = photo;
            return this;
        }

        /**
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ExtendedContactDetail> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ExtendedContactDetail contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
            return this;
        }

        /**
         * Replaces all {@code coverageArea} values.
         *
         * @param coverageArea the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder coverageArea(List<Reference> coverageArea) {
            this.coverageArea = coverageArea == null ? new ArrayList<>() : new ArrayList<>(coverageArea);
            return this;
        }

        /**
         * Adds a {@code coverageArea} value.
         *
         * @param coverageArea the value to add
         * @return this builder
         */
        public Builder addCoverageArea(Reference coverageArea) {
            this.coverageArea.add(Objects.requireNonNull(coverageArea, "coverageArea"));
            return this;
        }

        /**
         * Replaces all {@code serviceProvisionCode} values.
         *
         * @param serviceProvisionCode the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder serviceProvisionCode(List<CodeableConcept> serviceProvisionCode) {
            this.serviceProvisionCode = serviceProvisionCode == null
                    ? new ArrayList<>()
                    : new ArrayList<>(serviceProvisionCode);
            return this;
        }

        /**
         * Adds a {@code serviceProvisionCode} value.
         *
         * @param serviceProvisionCode the value to add
         * @return this builder
         */
        public Builder addServiceProvisionCode(CodeableConcept serviceProvisionCode) {
            this.serviceProvisionCode.add(Objects.requireNonNull(serviceProvisionCode, "serviceProvisionCode"));
            return this;
        }

        /**
         * Replaces all {@code eligibility} values.
         *
         * @param eligibility the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder eligibility(List<Eligibility> eligibility) {
            this.eligibility = eligibility == null ? new ArrayList<>() : new ArrayList<>(eligibility);
            return this;
        }

        /**
         * Adds a {@code eligibility} value.
         *
         * @param eligibility the value to add
         * @return this builder
         */
        public Builder addEligibility(Eligibility eligibility) {
            this.eligibility.add(Objects.requireNonNull(eligibility, "eligibility"));
            return this;
        }

        /**
         * Replaces all {@code program} values.
         *
         * @param program the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder program(List<CodeableConcept> program) {
            this.program = program == null ? new ArrayList<>() : new ArrayList<>(program);
            return this;
        }

        /**
         * Adds a {@code program} value.
         *
         * @param program the value to add
         * @return this builder
         */
        public Builder addProgram(CodeableConcept program) {
            this.program.add(Objects.requireNonNull(program, "program"));
            return this;
        }

        /**
         * Replaces all {@code characteristic} values.
         *
         * @param characteristic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder characteristic(List<CodeableConcept> characteristic) {
            this.characteristic = characteristic == null ? new ArrayList<>() : new ArrayList<>(characteristic);
            return this;
        }

        /**
         * Adds a {@code characteristic} value.
         *
         * @param characteristic the value to add
         * @return this builder
         */
        public Builder addCharacteristic(CodeableConcept characteristic) {
            this.characteristic.add(Objects.requireNonNull(characteristic, "characteristic"));
            return this;
        }

        /**
         * Replaces all {@code communication} values.
         *
         * @param communication the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder communication(List<CodeableConcept> communication) {
            this.communication = communication == null ? new ArrayList<>() : new ArrayList<>(communication);
            return this;
        }

        /**
         * Adds a {@code communication} value.
         *
         * @param communication the value to add
         * @return this builder
         */
        public Builder addCommunication(CodeableConcept communication) {
            this.communication.add(Objects.requireNonNull(communication, "communication"));
            return this;
        }

        /**
         * Replaces all {@code referralMethod} values.
         *
         * @param referralMethod the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder referralMethod(List<CodeableConcept> referralMethod) {
            this.referralMethod = referralMethod == null ? new ArrayList<>() : new ArrayList<>(referralMethod);
            return this;
        }

        /**
         * Adds a {@code referralMethod} value.
         *
         * @param referralMethod the value to add
         * @return this builder
         */
        public Builder addReferralMethod(CodeableConcept referralMethod) {
            this.referralMethod.add(Objects.requireNonNull(referralMethod, "referralMethod"));
            return this;
        }

        /**
         * Sets {@code appointmentRequired}.
         *
         * @param appointmentRequired the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder appointmentRequired(FhirBoolean appointmentRequired) {
            this.appointmentRequired = appointmentRequired;
            return this;
        }

        /**
         * Sets {@code appointmentRequired}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param appointmentRequired the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder appointmentRequired(Boolean appointmentRequired) {
            return appointmentRequired(appointmentRequired == null ? null : FhirBoolean.of(appointmentRequired));
        }

        /**
         * Replaces all {@code availability} values.
         *
         * @param availability the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder availability(List<Availability> availability) {
            this.availability = availability == null ? new ArrayList<>() : new ArrayList<>(availability);
            return this;
        }

        /**
         * Adds a {@code availability} value.
         *
         * @param availability the value to add
         * @return this builder
         */
        public Builder addAvailability(Availability availability) {
            this.availability.add(Objects.requireNonNull(availability, "availability"));
            return this;
        }

        /**
         * Replaces all {@code endpoint} values.
         *
         * @param endpoint the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder endpoint(List<Reference> endpoint) {
            this.endpoint = endpoint == null ? new ArrayList<>() : new ArrayList<>(endpoint);
            return this;
        }

        /**
         * Adds a {@code endpoint} value.
         *
         * @param endpoint the value to add
         * @return this builder
         */
        public Builder addEndpoint(Reference endpoint) {
            this.endpoint.add(Objects.requireNonNull(endpoint, "endpoint"));
            return this;
        }

        /**
         * Builds the {@code HealthcareService}.
         *
         * @return the {@code HealthcareService}
         */
        public HealthcareService build() {
            return new HealthcareService(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    active, providedBy, offeredIn, category, type, specialty, location, name, comment, extraDetails,
                    photo, contact, coverageArea, serviceProvisionCode, eligibility, program, characteristic,
                    communication, referralMethod, appointmentRequired, availability, endpoint);
        }
    }
}
