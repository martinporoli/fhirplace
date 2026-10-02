package se.poroli.fhirplace.r5.consent;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.ConsentDataMeaning;
import se.poroli.fhirplace.r5.valuesets.ConsentProvisionType;

/**
 * A record of a healthcare consumer’s choices or choices made on their behalf by a third party, which permits or
 * denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context,
 * for specific purposes and periods of time.
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
 * @param identifier Identifier for this record (external references).
 * @param status draft | active | inactive | not-done | entered-in-error | unknown. Required. Modifier element.
 * @param category Classification of the consent statement - for indexing/retrieval.
 * @param subject Who the consent applies to. Reference to Patient, Practitioner, Group.
 * @param date Fully executed date of the consent.
 * @param period Effective period for this Consent.
 * @param grantor Who is granting rights according to the policy and rules. Reference to CareTeam, HealthcareService,
 *   Organization, Patient, Practitioner, RelatedPerson, PractitionerRole.
 * @param grantee Who is agreeing to the policy and rules. Reference to CareTeam, HealthcareService, Organization,
 *   Patient, Practitioner, RelatedPerson, PractitionerRole.
 * @param manager Consent workflow management. Reference to HealthcareService, Organization, Patient, Practitioner.
 * @param controller Consent Enforcer. Reference to HealthcareService, Organization, Patient, Practitioner.
 * @param sourceAttachment Source from which this consent is taken.
 * @param sourceReference Source from which this consent is taken. Reference to Consent, DocumentReference, Contract,
 *   QuestionnaireResponse.
 * @param regulatoryBasis Regulations establishing base Consent.
 * @param policyBasis Computable version of the backing policy.
 * @param policyText Human Readable Policy. Reference to DocumentReference.
 * @param verification Consent Verified by patient or family.
 * @param decision deny | permit. Modifier element.
 * @param provision Constraints to the base Consent.policyRule/Consent.policy.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Consent">FHIR R5 Consent</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Consent(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<ConsentState> status,
        List<CodeableConcept> category,
        Reference subject,
        FhirDate date,
        Period period,
        List<Reference> grantor,
        List<Reference> grantee,
        List<Reference> manager,
        List<Reference> controller,
        List<Attachment> sourceAttachment,
        List<Reference> sourceReference,
        List<CodeableConcept> regulatoryBasis,
        PolicyBasis policyBasis,
        List<Reference> policyText,
        List<Verification> verification,
        FhirEnum<ConsentProvisionType> decision,
        List<provision> provision) implements DomainResource {

    /**
     * Creates a {@code Consent}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Consent {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        category = category == null ? List.of() : List.copyOf(category);
        grantor = grantor == null ? List.of() : List.copyOf(grantor);
        grantee = grantee == null ? List.of() : List.copyOf(grantee);
        manager = manager == null ? List.of() : List.copyOf(manager);
        controller = controller == null ? List.of() : List.copyOf(controller);
        sourceAttachment = sourceAttachment == null ? List.of() : List.copyOf(sourceAttachment);
        sourceReference = sourceReference == null ? List.of() : List.copyOf(sourceReference);
        regulatoryBasis = regulatoryBasis == null ? List.of() : List.copyOf(regulatoryBasis);
        policyText = policyText == null ? List.of() : List.copyOf(policyText);
        verification = verification == null ? List.of() : List.copyOf(verification);
        provision = provision == null ? List.of() : List.copyOf(provision);
        Objects.requireNonNull(status, "Consent.status is required");
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
     * Returns a builder initialized with the values of this {@code Consent}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A Reference or URL used to uniquely identify the policy the organization will enforce for this Consent.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param reference Reference backing policy resource. Reference to Resource.
     * @param url URL to a computable backing policy.
     */
    public record PolicyBasis(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference reference,
            FhirUrl url) implements BackboneElement {

        /**
         * Creates a {@code PolicyBasis}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public PolicyBasis {
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
         * Returns a builder initialized with the values of this {@code PolicyBasis}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link PolicyBasis}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference reference;
            private FhirUrl url;

            private Builder() {
            }

            private Builder(PolicyBasis original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.reference = original.reference();
                this.url = original.url();
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
             * Sets {@code reference}.
             *
             * @param reference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reference(Reference reference) {
                this.reference = reference;
                return this;
            }

            /**
             * Sets {@code url}.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(FhirUrl url) {
                this.url = url;
                return this;
            }

            /**
             * Sets {@code url}, wrapped in a {@link FhirUrl} without id or extensions.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(String url) {
                return url(url == null ? null : FhirUrl.of(url));
            }

            /**
             * Builds the {@code PolicyBasis}.
             *
             * @return the {@code PolicyBasis}
             */
            public PolicyBasis build() {
                return new PolicyBasis(
                        id, extension, modifierExtension, reference, url);
            }
        }
    }

    /**
     * Whether a treatment instruction (e.g. artificial respiration: yes or no) was verified with the patient, his/her
     * family or another authorized person.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param verified Has been verified. Required.
     * @param verificationType Business case of verification.
     * @param verifiedBy Person conducting verification. Reference to Organization, Practitioner, PractitionerRole.
     * @param verifiedWith Person who verified. Reference to Patient, RelatedPerson.
     * @param verificationDate When consent verified.
     */
    public record Verification(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirBoolean verified,
            CodeableConcept verificationType,
            Reference verifiedBy,
            Reference verifiedWith,
            List<FhirDateTime> verificationDate) implements BackboneElement {

        /**
         * Creates a {@code Verification}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Verification {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            verificationDate = verificationDate == null ? List.of() : List.copyOf(verificationDate);
            Objects.requireNonNull(verified, "Consent.verification.verified is required");
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
         * Returns a builder initialized with the values of this {@code Verification}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Verification}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirBoolean verified;
            private CodeableConcept verificationType;
            private Reference verifiedBy;
            private Reference verifiedWith;
            private List<FhirDateTime> verificationDate = new ArrayList<>();

            private Builder() {
            }

            private Builder(Verification original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.verified = original.verified();
                this.verificationType = original.verificationType();
                this.verifiedBy = original.verifiedBy();
                this.verifiedWith = original.verifiedWith();
                this.verificationDate = new ArrayList<>(original.verificationDate());
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
             * Sets {@code verified}.
             *
             * @param verified the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder verified(FhirBoolean verified) {
                this.verified = verified;
                return this;
            }

            /**
             * Sets {@code verified}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param verified the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder verified(Boolean verified) {
                return verified(verified == null ? null : FhirBoolean.of(verified));
            }

            /**
             * Sets {@code verificationType}.
             *
             * @param verificationType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder verificationType(CodeableConcept verificationType) {
                this.verificationType = verificationType;
                return this;
            }

            /**
             * Sets {@code verifiedBy}.
             *
             * @param verifiedBy the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder verifiedBy(Reference verifiedBy) {
                this.verifiedBy = verifiedBy;
                return this;
            }

            /**
             * Sets {@code verifiedWith}.
             *
             * @param verifiedWith the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder verifiedWith(Reference verifiedWith) {
                this.verifiedWith = verifiedWith;
                return this;
            }

            /**
             * Replaces all {@code verificationDate} values.
             *
             * @param verificationDate the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder verificationDate(List<FhirDateTime> verificationDate) {
                this.verificationDate = verificationDate == null
                        ? new ArrayList<>()
                        : new ArrayList<>(verificationDate);
                return this;
            }

            /**
             * Adds a {@code verificationDate} value.
             *
             * @param verificationDate the value to add
             * @return this builder
             */
            public Builder addVerificationDate(FhirDateTime verificationDate) {
                this.verificationDate.add(Objects.requireNonNull(verificationDate, "verificationDate"));
                return this;
            }

            /**
             * Adds a {@code verificationDate} value, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param verificationDate the value to add
             * @return this builder
             */
            public Builder addVerificationDate(Temporal verificationDate) {
                return addVerificationDate(FhirDateTime.of(verificationDate));
            }

            /**
             * Builds the {@code Verification}.
             *
             * @return the {@code Verification}
             * @throws NullPointerException if a required element is absent
             */
            public Verification build() {
                return new Verification(
                        id, extension, modifierExtension, verified, verificationType, verifiedBy, verifiedWith,
                        verificationDate);
            }
        }
    }

    /**
     * An exception to the base policy of this consent.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param period Timeframe for this provision.
     * @param actor Who|what controlled by this provision (or group, by role).
     * @param action Actions controlled by this provision.
     * @param securityLabel Security Labels that define affected resources.
     * @param purpose Context of activities covered by this provision.
     * @param documentType e.g. Resource Type, Profile, CDA, etc.
     * @param resourceType e.g. Resource Type, Profile, etc.
     * @param code e.g. LOINC or SNOMED CT code, etc. in the content.
     * @param dataPeriod Timeframe for data controlled by this provision.
     * @param data Data controlled by this provision.
     * @param expression A computable expression of the consent.
     * @param provision Nested Exception Provisions.
     */
    public record provision(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Period period,
            List<provisionActor> actor,
            List<CodeableConcept> action,
            List<Coding> securityLabel,
            List<Coding> purpose,
            List<Coding> documentType,
            List<Coding> resourceType,
            List<CodeableConcept> code,
            Period dataPeriod,
            List<provisionData> data,
            Expression expression,
            List<Consent.provision> provision) implements BackboneElement {

        /**
         * Creates a {@code provision}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public provision {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            actor = actor == null ? List.of() : List.copyOf(actor);
            action = action == null ? List.of() : List.copyOf(action);
            securityLabel = securityLabel == null ? List.of() : List.copyOf(securityLabel);
            purpose = purpose == null ? List.of() : List.copyOf(purpose);
            documentType = documentType == null ? List.of() : List.copyOf(documentType);
            resourceType = resourceType == null ? List.of() : List.copyOf(resourceType);
            code = code == null ? List.of() : List.copyOf(code);
            data = data == null ? List.of() : List.copyOf(data);
            provision = provision == null ? List.of() : List.copyOf(provision);
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
         * Returns a builder initialized with the values of this {@code provision}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Who or what is controlled by this provision.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param role How the actor is involved.
         * @param reference Resource for the actor (or group, by role). Reference to Device, Group, CareTeam,
         *   Organization, Patient, Practitioner, RelatedPerson, PractitionerRole.
         */
        public record provisionActor(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept role,
                Reference reference) implements BackboneElement {

            /**
             * Creates a {@code provisionActor}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public provisionActor {
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
             * Returns a builder initialized with the values of this {@code provisionActor}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link provisionActor}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept role;
                private Reference reference;

                private Builder() {
                }

                private Builder(provisionActor original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.role = original.role();
                    this.reference = original.reference();
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
                 * Sets {@code role}.
                 *
                 * @param role the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder role(CodeableConcept role) {
                    this.role = role;
                    return this;
                }

                /**
                 * Sets {@code reference}.
                 *
                 * @param reference the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder reference(Reference reference) {
                    this.reference = reference;
                    return this;
                }

                /**
                 * Builds the {@code provisionActor}.
                 *
                 * @return the {@code provisionActor}
                 */
                public provisionActor build() {
                    return new provisionActor(
                            id, extension, modifierExtension, role, reference);
                }
            }
        }

        /**
         * The resources controlled by this provision if specific resources are referenced.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param meaning instance | related | dependents | authoredby. Required.
         * @param reference The actual data reference. Reference to Resource. Required.
         */
        public record provisionData(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<ConsentDataMeaning> meaning,
                Reference reference) implements BackboneElement {

            /**
             * Creates a {@code provisionData}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public provisionData {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(meaning, "Consent.provision.data.meaning is required");
                Objects.requireNonNull(reference, "Consent.provision.data.reference is required");
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
             * Returns a builder initialized with the values of this {@code provisionData}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link provisionData}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<ConsentDataMeaning> meaning;
                private Reference reference;

                private Builder() {
                }

                private Builder(provisionData original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.meaning = original.meaning();
                    this.reference = original.reference();
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
                 * Sets {@code meaning}.
                 *
                 * @param meaning the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder meaning(FhirEnum<ConsentDataMeaning> meaning) {
                    this.meaning = meaning;
                    return this;
                }

                /**
                 * Sets {@code meaning}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param meaning the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder meaning(ConsentDataMeaning meaning) {
                    return meaning(meaning == null ? null : FhirEnum.of(meaning));
                }

                /**
                 * Sets {@code reference}.
                 *
                 * @param reference the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder reference(Reference reference) {
                    this.reference = reference;
                    return this;
                }

                /**
                 * Builds the {@code provisionData}.
                 *
                 * @return the {@code provisionData}
                 * @throws NullPointerException if a required element is absent
                 */
                public provisionData build() {
                    return new provisionData(
                            id, extension, modifierExtension, meaning, reference);
                }
            }
        }

        /** Builder for {@link provision}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Period period;
            private List<provisionActor> actor = new ArrayList<>();
            private List<CodeableConcept> action = new ArrayList<>();
            private List<Coding> securityLabel = new ArrayList<>();
            private List<Coding> purpose = new ArrayList<>();
            private List<Coding> documentType = new ArrayList<>();
            private List<Coding> resourceType = new ArrayList<>();
            private List<CodeableConcept> code = new ArrayList<>();
            private Period dataPeriod;
            private List<provisionData> data = new ArrayList<>();
            private Expression expression;
            private List<Consent.provision> provision = new ArrayList<>();

            private Builder() {
            }

            private Builder(provision original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.period = original.period();
                this.actor = new ArrayList<>(original.actor());
                this.action = new ArrayList<>(original.action());
                this.securityLabel = new ArrayList<>(original.securityLabel());
                this.purpose = new ArrayList<>(original.purpose());
                this.documentType = new ArrayList<>(original.documentType());
                this.resourceType = new ArrayList<>(original.resourceType());
                this.code = new ArrayList<>(original.code());
                this.dataPeriod = original.dataPeriod();
                this.data = new ArrayList<>(original.data());
                this.expression = original.expression();
                this.provision = new ArrayList<>(original.provision());
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
             * Replaces all {@code actor} values.
             *
             * @param actor the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder actor(List<provisionActor> actor) {
                this.actor = actor == null ? new ArrayList<>() : new ArrayList<>(actor);
                return this;
            }

            /**
             * Adds a {@code actor} value.
             *
             * @param actor the value to add
             * @return this builder
             */
            public Builder addActor(provisionActor actor) {
                this.actor.add(Objects.requireNonNull(actor, "actor"));
                return this;
            }

            /**
             * Replaces all {@code action} values.
             *
             * @param action the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder action(List<CodeableConcept> action) {
                this.action = action == null ? new ArrayList<>() : new ArrayList<>(action);
                return this;
            }

            /**
             * Adds a {@code action} value.
             *
             * @param action the value to add
             * @return this builder
             */
            public Builder addAction(CodeableConcept action) {
                this.action.add(Objects.requireNonNull(action, "action"));
                return this;
            }

            /**
             * Replaces all {@code securityLabel} values.
             *
             * @param securityLabel the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder securityLabel(List<Coding> securityLabel) {
                this.securityLabel = securityLabel == null ? new ArrayList<>() : new ArrayList<>(securityLabel);
                return this;
            }

            /**
             * Adds a {@code securityLabel} value.
             *
             * @param securityLabel the value to add
             * @return this builder
             */
            public Builder addSecurityLabel(Coding securityLabel) {
                this.securityLabel.add(Objects.requireNonNull(securityLabel, "securityLabel"));
                return this;
            }

            /**
             * Replaces all {@code purpose} values.
             *
             * @param purpose the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder purpose(List<Coding> purpose) {
                this.purpose = purpose == null ? new ArrayList<>() : new ArrayList<>(purpose);
                return this;
            }

            /**
             * Adds a {@code purpose} value.
             *
             * @param purpose the value to add
             * @return this builder
             */
            public Builder addPurpose(Coding purpose) {
                this.purpose.add(Objects.requireNonNull(purpose, "purpose"));
                return this;
            }

            /**
             * Replaces all {@code documentType} values.
             *
             * @param documentType the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder documentType(List<Coding> documentType) {
                this.documentType = documentType == null ? new ArrayList<>() : new ArrayList<>(documentType);
                return this;
            }

            /**
             * Adds a {@code documentType} value.
             *
             * @param documentType the value to add
             * @return this builder
             */
            public Builder addDocumentType(Coding documentType) {
                this.documentType.add(Objects.requireNonNull(documentType, "documentType"));
                return this;
            }

            /**
             * Replaces all {@code resourceType} values.
             *
             * @param resourceType the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder resourceType(List<Coding> resourceType) {
                this.resourceType = resourceType == null ? new ArrayList<>() : new ArrayList<>(resourceType);
                return this;
            }

            /**
             * Adds a {@code resourceType} value.
             *
             * @param resourceType the value to add
             * @return this builder
             */
            public Builder addResourceType(Coding resourceType) {
                this.resourceType.add(Objects.requireNonNull(resourceType, "resourceType"));
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
             * Sets {@code dataPeriod}.
             *
             * @param dataPeriod the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dataPeriod(Period dataPeriod) {
                this.dataPeriod = dataPeriod;
                return this;
            }

            /**
             * Replaces all {@code data} values.
             *
             * @param data the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder data(List<provisionData> data) {
                this.data = data == null ? new ArrayList<>() : new ArrayList<>(data);
                return this;
            }

            /**
             * Adds a {@code data} value.
             *
             * @param data the value to add
             * @return this builder
             */
            public Builder addData(provisionData data) {
                this.data.add(Objects.requireNonNull(data, "data"));
                return this;
            }

            /**
             * Sets {@code expression}.
             *
             * @param expression the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder expression(Expression expression) {
                this.expression = expression;
                return this;
            }

            /**
             * Replaces all {@code provision} values.
             *
             * @param provision the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder provision(List<Consent.provision> provision) {
                this.provision = provision == null ? new ArrayList<>() : new ArrayList<>(provision);
                return this;
            }

            /**
             * Adds a {@code provision} value.
             *
             * @param provision the value to add
             * @return this builder
             */
            public Builder addProvision(Consent.provision provision) {
                this.provision.add(Objects.requireNonNull(provision, "provision"));
                return this;
            }

            /**
             * Builds the {@code provision}.
             *
             * @return the {@code provision}
             */
            public provision build() {
                return new provision(
                        id, extension, modifierExtension, period, actor, action, securityLabel, purpose, documentType,
                        resourceType, code, dataPeriod, data, expression, provision);
            }
        }
    }

    /** Builder for {@link Consent}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<ConsentState> status;
        private List<CodeableConcept> category = new ArrayList<>();
        private Reference subject;
        private FhirDate date;
        private Period period;
        private List<Reference> grantor = new ArrayList<>();
        private List<Reference> grantee = new ArrayList<>();
        private List<Reference> manager = new ArrayList<>();
        private List<Reference> controller = new ArrayList<>();
        private List<Attachment> sourceAttachment = new ArrayList<>();
        private List<Reference> sourceReference = new ArrayList<>();
        private List<CodeableConcept> regulatoryBasis = new ArrayList<>();
        private PolicyBasis policyBasis;
        private List<Reference> policyText = new ArrayList<>();
        private List<Verification> verification = new ArrayList<>();
        private FhirEnum<ConsentProvisionType> decision;
        private List<provision> provision = new ArrayList<>();

        private Builder() {
        }

        private Builder(Consent original) {
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
            this.category = new ArrayList<>(original.category());
            this.subject = original.subject();
            this.date = original.date();
            this.period = original.period();
            this.grantor = new ArrayList<>(original.grantor());
            this.grantee = new ArrayList<>(original.grantee());
            this.manager = new ArrayList<>(original.manager());
            this.controller = new ArrayList<>(original.controller());
            this.sourceAttachment = new ArrayList<>(original.sourceAttachment());
            this.sourceReference = new ArrayList<>(original.sourceReference());
            this.regulatoryBasis = new ArrayList<>(original.regulatoryBasis());
            this.policyBasis = original.policyBasis();
            this.policyText = new ArrayList<>(original.policyText());
            this.verification = new ArrayList<>(original.verification());
            this.decision = original.decision();
            this.provision = new ArrayList<>(original.provision());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<ConsentState> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(ConsentState status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Sets {@code subject}.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(Reference subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets {@code date}.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(FhirDate date) {
            this.date = date;
            return this;
        }

        /**
         * Sets {@code date}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(Temporal date) {
            return date(date == null ? null : FhirDate.of(date));
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
         * Replaces all {@code grantor} values.
         *
         * @param grantor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder grantor(List<Reference> grantor) {
            this.grantor = grantor == null ? new ArrayList<>() : new ArrayList<>(grantor);
            return this;
        }

        /**
         * Adds a {@code grantor} value.
         *
         * @param grantor the value to add
         * @return this builder
         */
        public Builder addGrantor(Reference grantor) {
            this.grantor.add(Objects.requireNonNull(grantor, "grantor"));
            return this;
        }

        /**
         * Replaces all {@code grantee} values.
         *
         * @param grantee the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder grantee(List<Reference> grantee) {
            this.grantee = grantee == null ? new ArrayList<>() : new ArrayList<>(grantee);
            return this;
        }

        /**
         * Adds a {@code grantee} value.
         *
         * @param grantee the value to add
         * @return this builder
         */
        public Builder addGrantee(Reference grantee) {
            this.grantee.add(Objects.requireNonNull(grantee, "grantee"));
            return this;
        }

        /**
         * Replaces all {@code manager} values.
         *
         * @param manager the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder manager(List<Reference> manager) {
            this.manager = manager == null ? new ArrayList<>() : new ArrayList<>(manager);
            return this;
        }

        /**
         * Adds a {@code manager} value.
         *
         * @param manager the value to add
         * @return this builder
         */
        public Builder addManager(Reference manager) {
            this.manager.add(Objects.requireNonNull(manager, "manager"));
            return this;
        }

        /**
         * Replaces all {@code controller} values.
         *
         * @param controller the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder controller(List<Reference> controller) {
            this.controller = controller == null ? new ArrayList<>() : new ArrayList<>(controller);
            return this;
        }

        /**
         * Adds a {@code controller} value.
         *
         * @param controller the value to add
         * @return this builder
         */
        public Builder addController(Reference controller) {
            this.controller.add(Objects.requireNonNull(controller, "controller"));
            return this;
        }

        /**
         * Replaces all {@code sourceAttachment} values.
         *
         * @param sourceAttachment the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder sourceAttachment(List<Attachment> sourceAttachment) {
            this.sourceAttachment = sourceAttachment == null ? new ArrayList<>() : new ArrayList<>(sourceAttachment);
            return this;
        }

        /**
         * Adds a {@code sourceAttachment} value.
         *
         * @param sourceAttachment the value to add
         * @return this builder
         */
        public Builder addSourceAttachment(Attachment sourceAttachment) {
            this.sourceAttachment.add(Objects.requireNonNull(sourceAttachment, "sourceAttachment"));
            return this;
        }

        /**
         * Replaces all {@code sourceReference} values.
         *
         * @param sourceReference the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder sourceReference(List<Reference> sourceReference) {
            this.sourceReference = sourceReference == null ? new ArrayList<>() : new ArrayList<>(sourceReference);
            return this;
        }

        /**
         * Adds a {@code sourceReference} value.
         *
         * @param sourceReference the value to add
         * @return this builder
         */
        public Builder addSourceReference(Reference sourceReference) {
            this.sourceReference.add(Objects.requireNonNull(sourceReference, "sourceReference"));
            return this;
        }

        /**
         * Replaces all {@code regulatoryBasis} values.
         *
         * @param regulatoryBasis the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder regulatoryBasis(List<CodeableConcept> regulatoryBasis) {
            this.regulatoryBasis = regulatoryBasis == null ? new ArrayList<>() : new ArrayList<>(regulatoryBasis);
            return this;
        }

        /**
         * Adds a {@code regulatoryBasis} value.
         *
         * @param regulatoryBasis the value to add
         * @return this builder
         */
        public Builder addRegulatoryBasis(CodeableConcept regulatoryBasis) {
            this.regulatoryBasis.add(Objects.requireNonNull(regulatoryBasis, "regulatoryBasis"));
            return this;
        }

        /**
         * Sets {@code policyBasis}.
         *
         * @param policyBasis the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder policyBasis(PolicyBasis policyBasis) {
            this.policyBasis = policyBasis;
            return this;
        }

        /**
         * Replaces all {@code policyText} values.
         *
         * @param policyText the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder policyText(List<Reference> policyText) {
            this.policyText = policyText == null ? new ArrayList<>() : new ArrayList<>(policyText);
            return this;
        }

        /**
         * Adds a {@code policyText} value.
         *
         * @param policyText the value to add
         * @return this builder
         */
        public Builder addPolicyText(Reference policyText) {
            this.policyText.add(Objects.requireNonNull(policyText, "policyText"));
            return this;
        }

        /**
         * Replaces all {@code verification} values.
         *
         * @param verification the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder verification(List<Verification> verification) {
            this.verification = verification == null ? new ArrayList<>() : new ArrayList<>(verification);
            return this;
        }

        /**
         * Adds a {@code verification} value.
         *
         * @param verification the value to add
         * @return this builder
         */
        public Builder addVerification(Verification verification) {
            this.verification.add(Objects.requireNonNull(verification, "verification"));
            return this;
        }

        /**
         * Sets {@code decision}.
         *
         * @param decision the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder decision(FhirEnum<ConsentProvisionType> decision) {
            this.decision = decision;
            return this;
        }

        /**
         * Sets {@code decision}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param decision the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder decision(ConsentProvisionType decision) {
            return decision(decision == null ? null : FhirEnum.of(decision));
        }

        /**
         * Replaces all {@code provision} values.
         *
         * @param provision the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder provision(List<provision> provision) {
            this.provision = provision == null ? new ArrayList<>() : new ArrayList<>(provision);
            return this;
        }

        /**
         * Adds a {@code provision} value.
         *
         * @param provision the value to add
         * @return this builder
         */
        public Builder addProvision(provision provision) {
            this.provision.add(Objects.requireNonNull(provision, "provision"));
            return this;
        }

        /**
         * Builds the {@code Consent}.
         *
         * @return the {@code Consent}
         * @throws NullPointerException if a required element is absent
         */
        public Consent build() {
            return new Consent(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, category, subject, date, period, grantor, grantee, manager, controller, sourceAttachment,
                    sourceReference, regulatoryBasis, policyBasis, policyText, verification, decision, provision);
        }
    }
}
