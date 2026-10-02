package se.poroli.fhirplace.r5.base.entities1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
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
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some
 * form of collective action.
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
 * @param identifier Identifies this organization across multiple systems.
 * @param active Whether the organization's record is still in active use. Modifier element.
 * @param type Kind of organization.
 * @param name Name used for the organization.
 * @param alias A list of alternate names that the organization is known as, or was known as in the past.
 * @param description Additional details about the Organization that could be displayed as further information to
 *   identify the Organization beyond its name.
 * @param contact Official contact details for the Organization.
 * @param partOf The organization of which this organization forms a part. Reference to Organization.
 * @param endpoint Technical endpoints providing access to services operated for the organization. Reference to
 *   Endpoint.
 * @param qualification Qualifications, certifications, accreditations, licenses, training, etc. pertaining to the
 *   provision of care.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Organization">FHIR R5 Organization</a>
 */
public record Organization(
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
        List<CodeableConcept> type,
        FhirString name,
        List<FhirString> alias,
        FhirMarkdown description,
        List<ExtendedContactDetail> contact,
        Reference partOf,
        List<Reference> endpoint,
        List<Qualification> qualification) implements DomainResource {

    /**
     * Creates an {@code Organization}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Organization {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        type = type == null ? List.of() : List.copyOf(type);
        alias = alias == null ? List.of() : List.copyOf(alias);
        contact = contact == null ? List.of() : List.copyOf(contact);
        endpoint = endpoint == null ? List.of() : List.copyOf(endpoint);
        qualification = qualification == null ? List.of() : List.copyOf(qualification);
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
     * Returns a builder initialized with the values of this {@code Organization}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The official certifications, accreditations, training, designations and licenses that authorize and/or
     * otherwise endorse the provision of care by the organization.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier An identifier for this qualification for the organization.
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
            Objects.requireNonNull(code, "Organization.qualification.code is required");
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

    /** Builder for {@link Organization}. Builders are mutable and not thread-safe. */
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
        private List<CodeableConcept> type = new ArrayList<>();
        private FhirString name;
        private List<FhirString> alias = new ArrayList<>();
        private FhirMarkdown description;
        private List<ExtendedContactDetail> contact = new ArrayList<>();
        private Reference partOf;
        private List<Reference> endpoint = new ArrayList<>();
        private List<Qualification> qualification = new ArrayList<>();

        private Builder() {
        }

        private Builder(Organization original) {
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
            this.type = new ArrayList<>(original.type());
            this.name = original.name();
            this.alias = new ArrayList<>(original.alias());
            this.description = original.description();
            this.contact = new ArrayList<>(original.contact());
            this.partOf = original.partOf();
            this.endpoint = new ArrayList<>(original.endpoint());
            this.qualification = new ArrayList<>(original.qualification());
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
         * Replaces all {@code alias} values.
         *
         * @param alias the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder alias(List<FhirString> alias) {
            this.alias = alias == null ? new ArrayList<>() : new ArrayList<>(alias);
            return this;
        }

        /**
         * Adds a {@code alias} value.
         *
         * @param alias the value to add
         * @return this builder
         */
        public Builder addAlias(FhirString alias) {
            this.alias.add(Objects.requireNonNull(alias, "alias"));
            return this;
        }

        /**
         * Adds a {@code alias} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param alias the value to add
         * @return this builder
         */
        public Builder addAlias(String alias) {
            return addAlias(FhirString.of(alias));
        }

        /**
         * Sets {@code description}.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(FhirMarkdown description) {
            this.description = description;
            return this;
        }

        /**
         * Sets {@code description}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param description the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder description(String description) {
            return description(description == null ? null : FhirMarkdown.of(description));
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
         * Sets {@code partOf}.
         *
         * @param partOf the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder partOf(Reference partOf) {
            this.partOf = partOf;
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
         * Builds the {@code Organization}.
         *
         * @return the {@code Organization}
         */
        public Organization build() {
            return new Organization(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    active, type, name, alias, description, contact, partOf, endpoint, qualification);
        }
    }
}
