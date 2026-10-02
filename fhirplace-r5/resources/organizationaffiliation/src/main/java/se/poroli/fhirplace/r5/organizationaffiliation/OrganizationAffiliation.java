package se.poroli.fhirplace.r5.organizationaffiliation;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * Defines an affiliation/assotiation/relationship between 2 distinct organizations, that is not a part-of
 * relationship/sub-division relationship.
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
 * @param identifier Business identifiers that are specific to this role.
 * @param active Whether this organization affiliation record is in active use.
 * @param period The period during which the participatingOrganization is affiliated with the primary organization.
 * @param organization Organization where the role is available. Reference to Organization.
 * @param participatingOrganization Organization that provides/performs the role (e.g. providing services or is a
 *   member of). Reference to Organization.
 * @param network The network in which the participatingOrganization provides the role's services (if defined) at the
 *   indicated locations (if defined). Reference to Organization.
 * @param code Definition of the role the participatingOrganization plays.
 * @param specialty Specific specialty of the participatingOrganization in the context of the role.
 * @param location The location(s) at which the role occurs. Reference to Location.
 * @param healthcareService Healthcare services provided through the role. Reference to HealthcareService.
 * @param contact Official contact details at the participatingOrganization relevant to this Affiliation.
 * @param endpoint Technical endpoints providing access to services operated for this role. Reference to Endpoint.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/OrganizationAffiliation">FHIR R5 OrganizationAffiliation</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record OrganizationAffiliation(
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
        Period period,
        Reference organization,
        Reference participatingOrganization,
        List<Reference> network,
        List<CodeableConcept> code,
        List<CodeableConcept> specialty,
        List<Reference> location,
        List<Reference> healthcareService,
        List<ExtendedContactDetail> contact,
        List<Reference> endpoint) implements DomainResource {

    /**
     * Creates an {@code OrganizationAffiliation}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public OrganizationAffiliation {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        network = network == null ? List.of() : List.copyOf(network);
        code = code == null ? List.of() : List.copyOf(code);
        specialty = specialty == null ? List.of() : List.copyOf(specialty);
        location = location == null ? List.of() : List.copyOf(location);
        healthcareService = healthcareService == null ? List.of() : List.copyOf(healthcareService);
        contact = contact == null ? List.of() : List.copyOf(contact);
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
     * Returns a builder initialized with the values of this {@code OrganizationAffiliation}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /** Builder for {@link OrganizationAffiliation}. Builders are mutable and not thread-safe. */
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
        private Period period;
        private Reference organization;
        private Reference participatingOrganization;
        private List<Reference> network = new ArrayList<>();
        private List<CodeableConcept> code = new ArrayList<>();
        private List<CodeableConcept> specialty = new ArrayList<>();
        private List<Reference> location = new ArrayList<>();
        private List<Reference> healthcareService = new ArrayList<>();
        private List<ExtendedContactDetail> contact = new ArrayList<>();
        private List<Reference> endpoint = new ArrayList<>();

        private Builder() {
        }

        private Builder(OrganizationAffiliation original) {
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
            this.period = original.period();
            this.organization = original.organization();
            this.participatingOrganization = original.participatingOrganization();
            this.network = new ArrayList<>(original.network());
            this.code = new ArrayList<>(original.code());
            this.specialty = new ArrayList<>(original.specialty());
            this.location = new ArrayList<>(original.location());
            this.healthcareService = new ArrayList<>(original.healthcareService());
            this.contact = new ArrayList<>(original.contact());
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
         * Sets {@code participatingOrganization}.
         *
         * @param participatingOrganization the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder participatingOrganization(Reference participatingOrganization) {
            this.participatingOrganization = participatingOrganization;
            return this;
        }

        /**
         * Replaces all {@code network} values.
         *
         * @param network the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder network(List<Reference> network) {
            this.network = network == null ? new ArrayList<>() : new ArrayList<>(network);
            return this;
        }

        /**
         * Adds a {@code network} value.
         *
         * @param network the value to add
         * @return this builder
         */
        public Builder addNetwork(Reference network) {
            this.network.add(Objects.requireNonNull(network, "network"));
            return this;
        }

        /**
         * Replaces all {@code code} values.
         *
         * @param code the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder code(List<CodeableConcept> code) {
            this.code = code == null ? new ArrayList<>() : new ArrayList<>(code);
            return this;
        }

        /**
         * Adds a {@code code} value.
         *
         * @param code the value to add
         * @return this builder
         */
        public Builder addCode(CodeableConcept code) {
            this.code.add(Objects.requireNonNull(code, "code"));
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
         * Replaces all {@code healthcareService} values.
         *
         * @param healthcareService the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder healthcareService(List<Reference> healthcareService) {
            this.healthcareService = healthcareService == null
                    ? new ArrayList<>()
                    : new ArrayList<>(healthcareService);
            return this;
        }

        /**
         * Adds a {@code healthcareService} value.
         *
         * @param healthcareService the value to add
         * @return this builder
         */
        public Builder addHealthcareService(Reference healthcareService) {
            this.healthcareService.add(Objects.requireNonNull(healthcareService, "healthcareService"));
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
         * Builds the {@code OrganizationAffiliation}.
         *
         * @return the {@code OrganizationAffiliation}
         */
        public OrganizationAffiliation build() {
            return new OrganizationAffiliation(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    active, period, organization, participatingOrganization, network, code, specialty, location,
                    healthcareService, contact, endpoint);
        }
    }
}
