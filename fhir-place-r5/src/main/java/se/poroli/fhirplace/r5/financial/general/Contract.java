package se.poroli.fhirplace.r5.financial.general;

import java.math.BigDecimal;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.Availability;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Contributor;
import se.poroli.fhirplace.r5.datatypes.Count;
import se.poroli.fhirplace.r5.datatypes.DataRequirement;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Distance;
import se.poroli.fhirplace.r5.datatypes.Dosage;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.ElementDefinition;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirInteger64;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirOid;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirUuid;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.ParameterDefinition;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.RatioRange;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.SampledData;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.datatypes.TriggerDefinition;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.valuesets.ContractResourcePublicationStatusCodes;
import se.poroli.fhirplace.r5.valuesets.ContractResourceStatusCodes;

/**
 * Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement.
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
 * @param identifier Contract number.
 * @param url Basal definition.
 * @param version Business edition.
 * @param status amended | appended | cancelled | disputed | entered-in-error | executable +. Modifier element.
 * @param legalState Negotiation status.
 * @param instantiatesCanonical Source Contract Definition. Reference to Contract.
 * @param instantiatesUri External Contract Definition.
 * @param contentDerivative Content derived from the basal information.
 * @param issued When this Contract was issued.
 * @param applies Effective time.
 * @param expirationType Contract cessation cause.
 * @param subject Contract Target Entity. Reference to Resource.
 * @param authority Authority under which this Contract has standing. Reference to Organization.
 * @param domain A sphere of control governed by an authoritative jurisdiction, organization, or person. Reference to
 *   Location.
 * @param site Specific Location. Reference to Location.
 * @param name Computer friendly designation.
 * @param title Human Friendly name.
 * @param subtitle Subordinate Friendly name.
 * @param alias Acronym or short name.
 * @param author Source of Contract. Reference to Patient, Practitioner, PractitionerRole, Organization.
 * @param scope Range of Legal Concerns.
 * @param topic Focus of contract interest. One of CodeableConcept, Reference.
 * @param type Legal instrument category.
 * @param subType Subtype within the context of type.
 * @param contentDefinition Contract precursor content.
 * @param term Contract Term List.
 * @param supportingInfo Extra Information. Reference to Resource.
 * @param relevantHistory Key event in Contract History. Reference to Provenance.
 * @param signer Contract Signatory.
 * @param friendly Contract Friendly Language.
 * @param legal Contract Legal Language.
 * @param rule Computable Contract Language.
 * @param legallyBinding Binding Contract. One of Attachment, Reference.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Contract">FHIR R5 Contract</a>
 */
public record Contract(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirUri url,
        FhirString version,
        FhirEnum<ContractResourceStatusCodes> status,
        CodeableConcept legalState,
        Reference instantiatesCanonical,
        FhirUri instantiatesUri,
        CodeableConcept contentDerivative,
        FhirDateTime issued,
        Period applies,
        CodeableConcept expirationType,
        List<Reference> subject,
        List<Reference> authority,
        List<Reference> domain,
        List<Reference> site,
        FhirString name,
        FhirString title,
        FhirString subtitle,
        List<FhirString> alias,
        Reference author,
        CodeableConcept scope,
        DataType topic,
        CodeableConcept type,
        List<CodeableConcept> subType,
        ContentDefinition contentDefinition,
        List<Term> term,
        List<Reference> supportingInfo,
        List<Reference> relevantHistory,
        List<Signatory> signer,
        List<FriendlyLanguage> friendly,
        List<LegalLanguage> legal,
        List<ComputableLanguage> rule,
        DataType legallyBinding) implements DomainResource {

    /**
     * Creates a {@code Contract}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public Contract {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        subject = subject == null ? List.of() : List.copyOf(subject);
        authority = authority == null ? List.of() : List.copyOf(authority);
        domain = domain == null ? List.of() : List.copyOf(domain);
        site = site == null ? List.of() : List.copyOf(site);
        alias = alias == null ? List.of() : List.copyOf(alias);
        subType = subType == null ? List.of() : List.copyOf(subType);
        term = term == null ? List.of() : List.copyOf(term);
        supportingInfo = supportingInfo == null ? List.of() : List.copyOf(supportingInfo);
        relevantHistory = relevantHistory == null ? List.of() : List.copyOf(relevantHistory);
        signer = signer == null ? List.of() : List.copyOf(signer);
        friendly = friendly == null ? List.of() : List.copyOf(friendly);
        legal = legal == null ? List.of() : List.copyOf(legal);
        rule = rule == null ? List.of() : List.copyOf(rule);
        if (topic != null && !(topic instanceof CodeableConcept || topic instanceof Reference)) {
            throw new IllegalArgumentException(
                    "Contract.topic[x] must be one of CodeableConcept, Reference, but was "
                            + topic.getClass().getSimpleName());
        }
        if (legallyBinding != null && !(legallyBinding instanceof Attachment
                || legallyBinding instanceof Reference)) {
            throw new IllegalArgumentException(
                    "Contract.legallyBinding[x] must be one of Attachment, Reference, but was "
                            + legallyBinding.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code Contract}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Precusory content developed with a focus and intent of supporting the formation a Contract instance, which may
     * be associated with and transformable into a Contract.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Content structure and use. Required.
     * @param subType Detailed Content Type Definition.
     * @param publisher Publisher Entity. Reference to Practitioner, PractitionerRole, Organization.
     * @param publicationDate When published.
     * @param publicationStatus amended | appended | cancelled | disputed | entered-in-error | executable +. Required.
     * @param copyright Publication Ownership.
     */
    public record ContentDefinition(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            CodeableConcept subType,
            Reference publisher,
            FhirDateTime publicationDate,
            FhirEnum<ContractResourcePublicationStatusCodes> publicationStatus,
            FhirMarkdown copyright) implements BackboneElement {

        /**
         * Creates a {@code ContentDefinition}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ContentDefinition {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "Contract.contentDefinition.type is required");
            Objects.requireNonNull(publicationStatus, "Contract.contentDefinition.publicationStatus is required");
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
         * Returns a builder initialized with the values of this {@code ContentDefinition}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ContentDefinition}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private CodeableConcept subType;
            private Reference publisher;
            private FhirDateTime publicationDate;
            private FhirEnum<ContractResourcePublicationStatusCodes> publicationStatus;
            private FhirMarkdown copyright;

            private Builder() {
            }

            private Builder(ContentDefinition original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.subType = original.subType();
                this.publisher = original.publisher();
                this.publicationDate = original.publicationDate();
                this.publicationStatus = original.publicationStatus();
                this.copyright = original.copyright();
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
             * Sets {@code subType}.
             *
             * @param subType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subType(CodeableConcept subType) {
                this.subType = subType;
                return this;
            }

            /**
             * Sets {@code publisher}.
             *
             * @param publisher the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder publisher(Reference publisher) {
                this.publisher = publisher;
                return this;
            }

            /**
             * Sets {@code publicationDate}.
             *
             * @param publicationDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder publicationDate(FhirDateTime publicationDate) {
                this.publicationDate = publicationDate;
                return this;
            }

            /**
             * Sets {@code publicationDate}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param publicationDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder publicationDate(Temporal publicationDate) {
                return publicationDate(publicationDate == null ? null : FhirDateTime.of(publicationDate));
            }

            /**
             * Sets {@code publicationStatus}.
             *
             * @param publicationStatus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder publicationStatus(FhirEnum<ContractResourcePublicationStatusCodes> publicationStatus) {
                this.publicationStatus = publicationStatus;
                return this;
            }

            /**
             * Sets {@code publicationStatus}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param publicationStatus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder publicationStatus(ContractResourcePublicationStatusCodes publicationStatus) {
                return publicationStatus(publicationStatus == null ? null : FhirEnum.of(publicationStatus));
            }

            /**
             * Sets {@code copyright}.
             *
             * @param copyright the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder copyright(FhirMarkdown copyright) {
                this.copyright = copyright;
                return this;
            }

            /**
             * Sets {@code copyright}, wrapped in a {@link FhirMarkdown} without id or extensions.
             *
             * @param copyright the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder copyright(String copyright) {
                return copyright(copyright == null ? null : FhirMarkdown.of(copyright));
            }

            /**
             * Builds the {@code ContentDefinition}.
             *
             * @return the {@code ContentDefinition}
             * @throws NullPointerException if a required element is absent
             */
            public ContentDefinition build() {
                return new ContentDefinition(
                        id, extension, modifierExtension, type, subType, publisher, publicationDate,
                        publicationStatus, copyright);
            }
        }
    }

    /**
     * One or more Contract Provisions, which may be related and conveyed as a group, and may contain nested groups.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier Contract Term Number.
     * @param issued Contract Term Issue Date Time.
     * @param applies Contract Term Effective Time.
     * @param topic Term Concern. One of CodeableConcept, Reference.
     * @param type Contract Term Type or Form.
     * @param subType Contract Term Type specific classification.
     * @param text Term Statement.
     * @param securityLabel Protection for the Term.
     * @param offer Context of the Contract term. Required.
     * @param asset Contract Term Asset List.
     * @param action Entity being ascribed responsibility.
     * @param group Nested Contract Term Group.
     */
    public record Term(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Identifier identifier,
            FhirDateTime issued,
            Period applies,
            DataType topic,
            CodeableConcept type,
            CodeableConcept subType,
            FhirString text,
            List<SecurityLabel> securityLabel,
            ContractOffer offer,
            List<ContractAsset> asset,
            List<Action> action,
            List<Contract.Term> group) implements BackboneElement {

        /**
         * Creates a {@code Term}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Term {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            securityLabel = securityLabel == null ? List.of() : List.copyOf(securityLabel);
            asset = asset == null ? List.of() : List.copyOf(asset);
            action = action == null ? List.of() : List.copyOf(action);
            group = group == null ? List.of() : List.copyOf(group);
            Objects.requireNonNull(offer, "Contract.term.offer is required");
            if (topic != null && !(topic instanceof CodeableConcept || topic instanceof Reference)) {
                throw new IllegalArgumentException(
                        "Contract.term.topic[x] must be one of CodeableConcept, Reference, but was "
                                + topic.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Term}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Security labels that protect the handling of information about the term and its elements, which may be
         * specifically identified.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param number Link to Security Labels.
         * @param classification Confidentiality Protection. Required.
         * @param category Applicable Policy.
         * @param control Handling Instructions.
         */
        public record SecurityLabel(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<FhirUnsignedInt> number,
                Coding classification,
                List<Coding> category,
                List<Coding> control) implements BackboneElement {

            /**
             * Creates a {@code SecurityLabel}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public SecurityLabel {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                number = number == null ? List.of() : List.copyOf(number);
                category = category == null ? List.of() : List.copyOf(category);
                control = control == null ? List.of() : List.copyOf(control);
                Objects.requireNonNull(classification, "Contract.term.securityLabel.classification is required");
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
             * Returns a builder initialized with the values of this {@code SecurityLabel}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link SecurityLabel}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<FhirUnsignedInt> number = new ArrayList<>();
                private Coding classification;
                private List<Coding> category = new ArrayList<>();
                private List<Coding> control = new ArrayList<>();

                private Builder() {
                }

                private Builder(SecurityLabel original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.number = new ArrayList<>(original.number());
                    this.classification = original.classification();
                    this.category = new ArrayList<>(original.category());
                    this.control = new ArrayList<>(original.control());
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
                 * Replaces all {@code number} values.
                 *
                 * @param number the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder number(List<FhirUnsignedInt> number) {
                    this.number = number == null ? new ArrayList<>() : new ArrayList<>(number);
                    return this;
                }

                /**
                 * Adds a {@code number} value.
                 *
                 * @param number the value to add
                 * @return this builder
                 */
                public Builder addNumber(FhirUnsignedInt number) {
                    this.number.add(Objects.requireNonNull(number, "number"));
                    return this;
                }

                /**
                 * Adds a {@code number} value, wrapped in a {@link FhirUnsignedInt} without id or extensions.
                 *
                 * @param number the value to add
                 * @return this builder
                 */
                public Builder addNumber(Integer number) {
                    return addNumber(FhirUnsignedInt.of(number));
                }

                /**
                 * Sets {@code classification}.
                 *
                 * @param classification the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder classification(Coding classification) {
                    this.classification = classification;
                    return this;
                }

                /**
                 * Replaces all {@code category} values.
                 *
                 * @param category the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder category(List<Coding> category) {
                    this.category = category == null ? new ArrayList<>() : new ArrayList<>(category);
                    return this;
                }

                /**
                 * Adds a {@code category} value.
                 *
                 * @param category the value to add
                 * @return this builder
                 */
                public Builder addCategory(Coding category) {
                    this.category.add(Objects.requireNonNull(category, "category"));
                    return this;
                }

                /**
                 * Replaces all {@code control} values.
                 *
                 * @param control the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder control(List<Coding> control) {
                    this.control = control == null ? new ArrayList<>() : new ArrayList<>(control);
                    return this;
                }

                /**
                 * Adds a {@code control} value.
                 *
                 * @param control the value to add
                 * @return this builder
                 */
                public Builder addControl(Coding control) {
                    this.control.add(Objects.requireNonNull(control, "control"));
                    return this;
                }

                /**
                 * Builds the {@code SecurityLabel}.
                 *
                 * @return the {@code SecurityLabel}
                 * @throws NullPointerException if a required element is absent
                 */
                public SecurityLabel build() {
                    return new SecurityLabel(
                            id, extension, modifierExtension, number, classification, category, control);
                }
            }
        }

        /**
         * The matter of concern in the context of this provision of the agrement.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param identifier Offer business ID.
         * @param party Offer Recipient.
         * @param topic Negotiable offer asset. Reference to Resource.
         * @param type Contract Offer Type or Form.
         * @param decision Accepting party choice.
         * @param decisionMode How decision is conveyed.
         * @param answer Response to offer text.
         * @param text Human readable offer text.
         * @param linkId Pointer to text.
         * @param securityLabelNumber Offer restriction numbers.
         */
        public record ContractOffer(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<Identifier> identifier,
                List<ContractParty> party,
                Reference topic,
                CodeableConcept type,
                CodeableConcept decision,
                List<CodeableConcept> decisionMode,
                List<Answer> answer,
                FhirString text,
                List<FhirString> linkId,
                List<FhirUnsignedInt> securityLabelNumber) implements BackboneElement {

            /**
             * Creates a {@code ContractOffer}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public ContractOffer {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                identifier = identifier == null ? List.of() : List.copyOf(identifier);
                party = party == null ? List.of() : List.copyOf(party);
                decisionMode = decisionMode == null ? List.of() : List.copyOf(decisionMode);
                answer = answer == null ? List.of() : List.copyOf(answer);
                linkId = linkId == null ? List.of() : List.copyOf(linkId);
                securityLabelNumber = securityLabelNumber == null ? List.of() : List.copyOf(securityLabelNumber);
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
             * Returns a builder initialized with the values of this {@code ContractOffer}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Offer Recipient.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param reference Referenced entity. Reference to Patient, RelatedPerson, Practitioner,
             *   PractitionerRole, Device, Group, Organization. Required.
             * @param role Participant engagement type. Required.
             */
            public record ContractParty(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    List<Reference> reference,
                    CodeableConcept role) implements BackboneElement {

                /**
                 * Creates a {@code ContractParty}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public ContractParty {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    reference = reference == null ? List.of() : List.copyOf(reference);
                    if (reference.isEmpty()) {
                        throw new IllegalArgumentException(
                                "Contract.term.offer.party.reference requires at least one value");
                    }
                    Objects.requireNonNull(role, "Contract.term.offer.party.role is required");
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
                 * Returns a builder initialized with the values of this {@code ContractParty}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link ContractParty}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private List<Reference> reference = new ArrayList<>();
                    private CodeableConcept role;

                    private Builder() {
                    }

                    private Builder(ContractParty original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.reference = new ArrayList<>(original.reference());
                        this.role = original.role();
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
                     * Replaces all {@code reference} values.
                     *
                     * @param reference the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder reference(List<Reference> reference) {
                        this.reference = reference == null ? new ArrayList<>() : new ArrayList<>(reference);
                        return this;
                    }

                    /**
                     * Adds a {@code reference} value.
                     *
                     * @param reference the value to add
                     * @return this builder
                     */
                    public Builder addReference(Reference reference) {
                        this.reference.add(Objects.requireNonNull(reference, "reference"));
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
                     * Builds the {@code ContractParty}.
                     *
                     * @return the {@code ContractParty}
                     * @throws NullPointerException if a required element is absent
                     * @throws IllegalArgumentException if a required list is empty
                     */
                    public ContractParty build() {
                        return new ContractParty(
                                id, extension, modifierExtension, reference, role);
                    }
                }
            }

            /**
             * Response to offer text.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param value The actual answer response. Any datatype except FhirInteger64, FhirPositiveInt,
             *   FhirUnsignedInt, FhirMarkdown, FhirCode, FhirId, FhirUrl, FhirCanonical, FhirOid, FhirUuid,
             *   FhirBase64Binary, FhirInstant, FhirEnum, Identifier, HumanName, Address, ContactPoint, Timing, Range,
             *   Period, Ratio, RatioRange, CodeableConcept, SampledData, Age, Distance, Duration, Count, Money,
             *   Annotation, Signature, ContactDetail, Contributor, DataRequirement, ParameterDefinition,
             *   RelatedArtifact, TriggerDefinition, UsageContext, Expression, ExtendedContactDetail,
             *   VirtualServiceDetail, Availability, MonetaryComponent, CodeableReference, Narrative, Extension, Meta,
             *   Dosage, ElementDefinition, ProductShelfLife, MarketingStatus. Required.
             */
            public record Answer(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    DataType value) implements BackboneElement {

                /**
                 * Creates an {@code Answer}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 * @throws IllegalArgumentException if a choice element has a type that is not allowed
                 */
                public Answer {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(value, "Contract.term.offer.answer.value is required");
                    if (value != null && (value instanceof FhirInteger64
                            || value instanceof FhirPositiveInt
                            || value instanceof FhirUnsignedInt
                            || value instanceof FhirMarkdown
                            || value instanceof FhirCode
                            || value instanceof FhirId
                            || value instanceof FhirUrl
                            || value instanceof FhirCanonical
                            || value instanceof FhirOid
                            || value instanceof FhirUuid
                            || value instanceof FhirBase64Binary
                            || value instanceof FhirInstant
                            || value instanceof FhirEnum<?>
                            || value instanceof Identifier
                            || value instanceof HumanName
                            || value instanceof Address
                            || value instanceof ContactPoint
                            || value instanceof Timing
                            || value instanceof Range
                            || value instanceof Period
                            || value instanceof Ratio
                            || value instanceof RatioRange
                            || value instanceof CodeableConcept
                            || value instanceof SampledData
                            || value instanceof Age
                            || value instanceof Distance
                            || value instanceof Duration
                            || value instanceof Count
                            || value instanceof Money
                            || value instanceof Annotation
                            || value instanceof Signature
                            || value instanceof ContactDetail
                            || value instanceof Contributor
                            || value instanceof DataRequirement
                            || value instanceof ParameterDefinition
                            || value instanceof RelatedArtifact
                            || value instanceof TriggerDefinition
                            || value instanceof UsageContext
                            || value instanceof Expression
                            || value instanceof ExtendedContactDetail
                            || value instanceof VirtualServiceDetail
                            || value instanceof Availability
                            || value instanceof MonetaryComponent
                            || value instanceof CodeableReference
                            || value instanceof Narrative
                            || value instanceof Extension
                            || value instanceof Meta
                            || value instanceof Dosage
                            || value instanceof ElementDefinition
                            || value instanceof ProductShelfLife
                            || value instanceof MarketingStatus)) {
                        throw new IllegalArgumentException(
                                "Contract.term.offer.answer.value[x] does not allow "
                                        + value.getClass().getSimpleName());
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
                 * Returns a builder initialized with the values of this {@code Answer}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Answer}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private DataType value;

                    private Builder() {
                    }

                    private Builder(Answer original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.value = original.value();
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
                     * Sets {@code value}.
                     *
                     * @param value the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder value(DataType value) {
                        this.value = value;
                        return this;
                    }

                    /**
                     * Builds the {@code Answer}.
                     *
                     * @return the {@code Answer}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Answer build() {
                        return new Answer(
                                id, extension, modifierExtension, value);
                    }
                }
            }

            /** Builder for {@link ContractOffer}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<Identifier> identifier = new ArrayList<>();
                private List<ContractParty> party = new ArrayList<>();
                private Reference topic;
                private CodeableConcept type;
                private CodeableConcept decision;
                private List<CodeableConcept> decisionMode = new ArrayList<>();
                private List<Answer> answer = new ArrayList<>();
                private FhirString text;
                private List<FhirString> linkId = new ArrayList<>();
                private List<FhirUnsignedInt> securityLabelNumber = new ArrayList<>();

                private Builder() {
                }

                private Builder(ContractOffer original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.identifier = new ArrayList<>(original.identifier());
                    this.party = new ArrayList<>(original.party());
                    this.topic = original.topic();
                    this.type = original.type();
                    this.decision = original.decision();
                    this.decisionMode = new ArrayList<>(original.decisionMode());
                    this.answer = new ArrayList<>(original.answer());
                    this.text = original.text();
                    this.linkId = new ArrayList<>(original.linkId());
                    this.securityLabelNumber = new ArrayList<>(original.securityLabelNumber());
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
                 * Replaces all {@code party} values.
                 *
                 * @param party the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder party(List<ContractParty> party) {
                    this.party = party == null ? new ArrayList<>() : new ArrayList<>(party);
                    return this;
                }

                /**
                 * Adds a {@code party} value.
                 *
                 * @param party the value to add
                 * @return this builder
                 */
                public Builder addParty(ContractParty party) {
                    this.party.add(Objects.requireNonNull(party, "party"));
                    return this;
                }

                /**
                 * Sets {@code topic}.
                 *
                 * @param topic the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder topic(Reference topic) {
                    this.topic = topic;
                    return this;
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
                 * Sets {@code decision}.
                 *
                 * @param decision the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder decision(CodeableConcept decision) {
                    this.decision = decision;
                    return this;
                }

                /**
                 * Replaces all {@code decisionMode} values.
                 *
                 * @param decisionMode the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder decisionMode(List<CodeableConcept> decisionMode) {
                    this.decisionMode = decisionMode == null ? new ArrayList<>() : new ArrayList<>(decisionMode);
                    return this;
                }

                /**
                 * Adds a {@code decisionMode} value.
                 *
                 * @param decisionMode the value to add
                 * @return this builder
                 */
                public Builder addDecisionMode(CodeableConcept decisionMode) {
                    this.decisionMode.add(Objects.requireNonNull(decisionMode, "decisionMode"));
                    return this;
                }

                /**
                 * Replaces all {@code answer} values.
                 *
                 * @param answer the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder answer(List<Answer> answer) {
                    this.answer = answer == null ? new ArrayList<>() : new ArrayList<>(answer);
                    return this;
                }

                /**
                 * Adds a {@code answer} value.
                 *
                 * @param answer the value to add
                 * @return this builder
                 */
                public Builder addAnswer(Answer answer) {
                    this.answer.add(Objects.requireNonNull(answer, "answer"));
                    return this;
                }

                /**
                 * Sets {@code text}.
                 *
                 * @param text the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder text(FhirString text) {
                    this.text = text;
                    return this;
                }

                /**
                 * Sets {@code text}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param text the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder text(String text) {
                    return text(text == null ? null : FhirString.of(text));
                }

                /**
                 * Replaces all {@code linkId} values.
                 *
                 * @param linkId the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder linkId(List<FhirString> linkId) {
                    this.linkId = linkId == null ? new ArrayList<>() : new ArrayList<>(linkId);
                    return this;
                }

                /**
                 * Adds a {@code linkId} value.
                 *
                 * @param linkId the value to add
                 * @return this builder
                 */
                public Builder addLinkId(FhirString linkId) {
                    this.linkId.add(Objects.requireNonNull(linkId, "linkId"));
                    return this;
                }

                /**
                 * Adds a {@code linkId} value, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param linkId the value to add
                 * @return this builder
                 */
                public Builder addLinkId(String linkId) {
                    return addLinkId(FhirString.of(linkId));
                }

                /**
                 * Replaces all {@code securityLabelNumber} values.
                 *
                 * @param securityLabelNumber the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder securityLabelNumber(List<FhirUnsignedInt> securityLabelNumber) {
                    this.securityLabelNumber = securityLabelNumber == null
                            ? new ArrayList<>()
                            : new ArrayList<>(securityLabelNumber);
                    return this;
                }

                /**
                 * Adds a {@code securityLabelNumber} value.
                 *
                 * @param securityLabelNumber the value to add
                 * @return this builder
                 */
                public Builder addSecurityLabelNumber(FhirUnsignedInt securityLabelNumber) {
                    this.securityLabelNumber.add(Objects.requireNonNull(securityLabelNumber, "securityLabelNumber"));
                    return this;
                }

                /**
                 * Adds a {@code securityLabelNumber} value, wrapped in a {@link FhirUnsignedInt} without id or extensions.
                 *
                 * @param securityLabelNumber the value to add
                 * @return this builder
                 */
                public Builder addSecurityLabelNumber(Integer securityLabelNumber) {
                    return addSecurityLabelNumber(FhirUnsignedInt.of(securityLabelNumber));
                }

                /**
                 * Builds the {@code ContractOffer}.
                 *
                 * @return the {@code ContractOffer}
                 */
                public ContractOffer build() {
                    return new ContractOffer(
                            id, extension, modifierExtension, identifier, party, topic, type, decision, decisionMode,
                            answer, text, linkId, securityLabelNumber);
                }
            }
        }

        /**
         * Contract Term Asset List.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param scope Range of asset.
         * @param type Asset category.
         * @param typeReference Associated entities. Reference to Resource.
         * @param subtype Asset sub-category.
         * @param relationship Kinship of the asset.
         * @param context Circumstance of the asset.
         * @param condition Quality desctiption of asset.
         * @param periodType Asset availability types.
         * @param period Time period of the asset.
         * @param usePeriod Time period.
         * @param text Asset clause or question text.
         * @param linkId Pointer to asset text.
         * @param answer Response to assets.
         * @param securityLabelNumber Asset restriction numbers.
         * @param valuedItem Contract Valued Item List.
         */
        public record ContractAsset(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept scope,
                List<CodeableConcept> type,
                List<Reference> typeReference,
                List<CodeableConcept> subtype,
                Coding relationship,
                List<AssetContext> context,
                FhirString condition,
                List<CodeableConcept> periodType,
                List<Period> period,
                List<Period> usePeriod,
                FhirString text,
                List<FhirString> linkId,
                List<Contract.Term.ContractOffer.Answer> answer,
                List<FhirUnsignedInt> securityLabelNumber,
                List<ValuedItem> valuedItem) implements BackboneElement {

            /**
             * Creates a {@code ContractAsset}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public ContractAsset {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                type = type == null ? List.of() : List.copyOf(type);
                typeReference = typeReference == null ? List.of() : List.copyOf(typeReference);
                subtype = subtype == null ? List.of() : List.copyOf(subtype);
                context = context == null ? List.of() : List.copyOf(context);
                periodType = periodType == null ? List.of() : List.copyOf(periodType);
                period = period == null ? List.of() : List.copyOf(period);
                usePeriod = usePeriod == null ? List.of() : List.copyOf(usePeriod);
                linkId = linkId == null ? List.of() : List.copyOf(linkId);
                answer = answer == null ? List.of() : List.copyOf(answer);
                securityLabelNumber = securityLabelNumber == null ? List.of() : List.copyOf(securityLabelNumber);
                valuedItem = valuedItem == null ? List.of() : List.copyOf(valuedItem);
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
             * Returns a builder initialized with the values of this {@code ContractAsset}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Circumstance of the asset.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param reference Creator,custodian or owner. Reference to Resource.
             * @param code Codeable asset context.
             * @param text Context description.
             */
            public record AssetContext(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    Reference reference,
                    List<CodeableConcept> code,
                    FhirString text) implements BackboneElement {

                /**
                 * Creates an {@code AssetContext}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 */
                public AssetContext {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    code = code == null ? List.of() : List.copyOf(code);
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
                 * Returns a builder initialized with the values of this {@code AssetContext}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link AssetContext}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private Reference reference;
                    private List<CodeableConcept> code = new ArrayList<>();
                    private FhirString text;

                    private Builder() {
                    }

                    private Builder(AssetContext original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.reference = original.reference();
                        this.code = new ArrayList<>(original.code());
                        this.text = original.text();
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
                     * Sets {@code text}.
                     *
                     * @param text the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder text(FhirString text) {
                        this.text = text;
                        return this;
                    }

                    /**
                     * Sets {@code text}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param text the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder text(String text) {
                        return text(text == null ? null : FhirString.of(text));
                    }

                    /**
                     * Builds the {@code AssetContext}.
                     *
                     * @return the {@code AssetContext}
                     */
                    public AssetContext build() {
                        return new AssetContext(
                                id, extension, modifierExtension, reference, code, text);
                    }
                }
            }

            /**
             * Contract Valued Item List.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param entity Contract Valued Item Type. One of CodeableConcept, Reference.
             * @param identifier Contract Valued Item Number.
             * @param effectiveTime Contract Valued Item Effective Tiem.
             * @param quantity Count of Contract Valued Items.
             * @param unitPrice Contract Valued Item fee, charge, or cost.
             * @param factor Contract Valued Item Price Scaling Factor.
             * @param points Contract Valued Item Difficulty Scaling Factor.
             * @param net Total Contract Valued Item Value.
             * @param payment Terms of valuation.
             * @param paymentDate When payment is due.
             * @param responsible Who will make payment. Reference to Organization, Patient, Practitioner,
             *   PractitionerRole, RelatedPerson.
             * @param recipient Who will receive payment. Reference to Organization, Patient, Practitioner,
             *   PractitionerRole, RelatedPerson.
             * @param linkId Pointer to specific item.
             * @param securityLabelNumber Security Labels that define affected terms.
             */
            public record ValuedItem(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    DataType entity,
                    Identifier identifier,
                    FhirDateTime effectiveTime,
                    Quantity quantity,
                    Money unitPrice,
                    FhirDecimal factor,
                    FhirDecimal points,
                    Money net,
                    FhirString payment,
                    FhirDateTime paymentDate,
                    Reference responsible,
                    Reference recipient,
                    List<FhirString> linkId,
                    List<FhirUnsignedInt> securityLabelNumber) implements BackboneElement {

                /**
                 * Creates a {@code ValuedItem}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 * @throws IllegalArgumentException if a choice element has a type that is not allowed
                 */
                public ValuedItem {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    linkId = linkId == null ? List.of() : List.copyOf(linkId);
                    securityLabelNumber = securityLabelNumber == null ? List.of() : List.copyOf(securityLabelNumber);
                    if (entity != null && !(entity instanceof CodeableConcept || entity instanceof Reference)) {
                        throw new IllegalArgumentException(
                                "Contract.term.asset.valuedItem.entity[x] does not allow "
                                        + entity.getClass().getSimpleName());
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
                 * Returns a builder initialized with the values of this {@code ValuedItem}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link ValuedItem}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private DataType entity;
                    private Identifier identifier;
                    private FhirDateTime effectiveTime;
                    private Quantity quantity;
                    private Money unitPrice;
                    private FhirDecimal factor;
                    private FhirDecimal points;
                    private Money net;
                    private FhirString payment;
                    private FhirDateTime paymentDate;
                    private Reference responsible;
                    private Reference recipient;
                    private List<FhirString> linkId = new ArrayList<>();
                    private List<FhirUnsignedInt> securityLabelNumber = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(ValuedItem original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.entity = original.entity();
                        this.identifier = original.identifier();
                        this.effectiveTime = original.effectiveTime();
                        this.quantity = original.quantity();
                        this.unitPrice = original.unitPrice();
                        this.factor = original.factor();
                        this.points = original.points();
                        this.net = original.net();
                        this.payment = original.payment();
                        this.paymentDate = original.paymentDate();
                        this.responsible = original.responsible();
                        this.recipient = original.recipient();
                        this.linkId = new ArrayList<>(original.linkId());
                        this.securityLabelNumber = new ArrayList<>(original.securityLabelNumber());
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
                     * Sets {@code entity} to a CodeableConcept.
                     *
                     * @param entity the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder entity(CodeableConcept entity) {
                        this.entity = entity;
                        return this;
                    }

                    /**
                     * Sets {@code entity} to a Reference.
                     *
                     * @param entity the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder entity(Reference entity) {
                        this.entity = entity;
                        return this;
                    }

                    /**
                     * Sets {@code identifier}.
                     *
                     * @param identifier the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder identifier(Identifier identifier) {
                        this.identifier = identifier;
                        return this;
                    }

                    /**
                     * Sets {@code effectiveTime}.
                     *
                     * @param effectiveTime the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder effectiveTime(FhirDateTime effectiveTime) {
                        this.effectiveTime = effectiveTime;
                        return this;
                    }

                    /**
                     * Sets {@code effectiveTime}, wrapped in a {@link FhirDateTime} without id or extensions.
                     *
                     * @param effectiveTime the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder effectiveTime(Temporal effectiveTime) {
                        return effectiveTime(effectiveTime == null ? null : FhirDateTime.of(effectiveTime));
                    }

                    /**
                     * Sets {@code quantity}.
                     *
                     * @param quantity the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder quantity(Quantity quantity) {
                        this.quantity = quantity;
                        return this;
                    }

                    /**
                     * Sets {@code unitPrice}.
                     *
                     * @param unitPrice the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder unitPrice(Money unitPrice) {
                        this.unitPrice = unitPrice;
                        return this;
                    }

                    /**
                     * Sets {@code factor}.
                     *
                     * @param factor the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder factor(FhirDecimal factor) {
                        this.factor = factor;
                        return this;
                    }

                    /**
                     * Sets {@code factor}, wrapped in a {@link FhirDecimal} without id or extensions.
                     *
                     * @param factor the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder factor(BigDecimal factor) {
                        return factor(factor == null ? null : FhirDecimal.of(factor));
                    }

                    /**
                     * Sets {@code points}.
                     *
                     * @param points the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder points(FhirDecimal points) {
                        this.points = points;
                        return this;
                    }

                    /**
                     * Sets {@code points}, wrapped in a {@link FhirDecimal} without id or extensions.
                     *
                     * @param points the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder points(BigDecimal points) {
                        return points(points == null ? null : FhirDecimal.of(points));
                    }

                    /**
                     * Sets {@code net}.
                     *
                     * @param net the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder net(Money net) {
                        this.net = net;
                        return this;
                    }

                    /**
                     * Sets {@code payment}.
                     *
                     * @param payment the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder payment(FhirString payment) {
                        this.payment = payment;
                        return this;
                    }

                    /**
                     * Sets {@code payment}, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param payment the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder payment(String payment) {
                        return payment(payment == null ? null : FhirString.of(payment));
                    }

                    /**
                     * Sets {@code paymentDate}.
                     *
                     * @param paymentDate the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder paymentDate(FhirDateTime paymentDate) {
                        this.paymentDate = paymentDate;
                        return this;
                    }

                    /**
                     * Sets {@code paymentDate}, wrapped in a {@link FhirDateTime} without id or extensions.
                     *
                     * @param paymentDate the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder paymentDate(Temporal paymentDate) {
                        return paymentDate(paymentDate == null ? null : FhirDateTime.of(paymentDate));
                    }

                    /**
                     * Sets {@code responsible}.
                     *
                     * @param responsible the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder responsible(Reference responsible) {
                        this.responsible = responsible;
                        return this;
                    }

                    /**
                     * Sets {@code recipient}.
                     *
                     * @param recipient the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder recipient(Reference recipient) {
                        this.recipient = recipient;
                        return this;
                    }

                    /**
                     * Replaces all {@code linkId} values.
                     *
                     * @param linkId the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder linkId(List<FhirString> linkId) {
                        this.linkId = linkId == null ? new ArrayList<>() : new ArrayList<>(linkId);
                        return this;
                    }

                    /**
                     * Adds a {@code linkId} value.
                     *
                     * @param linkId the value to add
                     * @return this builder
                     */
                    public Builder addLinkId(FhirString linkId) {
                        this.linkId.add(Objects.requireNonNull(linkId, "linkId"));
                        return this;
                    }

                    /**
                     * Adds a {@code linkId} value, wrapped in a {@link FhirString} without id or extensions.
                     *
                     * @param linkId the value to add
                     * @return this builder
                     */
                    public Builder addLinkId(String linkId) {
                        return addLinkId(FhirString.of(linkId));
                    }

                    /**
                     * Replaces all {@code securityLabelNumber} values.
                     *
                     * @param securityLabelNumber the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder securityLabelNumber(List<FhirUnsignedInt> securityLabelNumber) {
                        this.securityLabelNumber = securityLabelNumber == null
                                ? new ArrayList<>()
                                : new ArrayList<>(securityLabelNumber);
                        return this;
                    }

                    /**
                     * Adds a {@code securityLabelNumber} value.
                     *
                     * @param securityLabelNumber the value to add
                     * @return this builder
                     */
                    public Builder addSecurityLabelNumber(FhirUnsignedInt securityLabelNumber) {
                        this.securityLabelNumber.add(
                                Objects.requireNonNull(securityLabelNumber, "securityLabelNumber"));
                        return this;
                    }

                    /**
                     * Adds a {@code securityLabelNumber} value, wrapped in a {@link FhirUnsignedInt} without id or extensions.
                     *
                     * @param securityLabelNumber the value to add
                     * @return this builder
                     */
                    public Builder addSecurityLabelNumber(Integer securityLabelNumber) {
                        return addSecurityLabelNumber(FhirUnsignedInt.of(securityLabelNumber));
                    }

                    /**
                     * Builds the {@code ValuedItem}.
                     *
                     * @return the {@code ValuedItem}
                     */
                    public ValuedItem build() {
                        return new ValuedItem(
                                id, extension, modifierExtension, entity, identifier, effectiveTime, quantity,
                                unitPrice, factor, points, net, payment, paymentDate, responsible, recipient, linkId,
                                securityLabelNumber);
                    }
                }
            }

            /** Builder for {@link ContractAsset}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept scope;
                private List<CodeableConcept> type = new ArrayList<>();
                private List<Reference> typeReference = new ArrayList<>();
                private List<CodeableConcept> subtype = new ArrayList<>();
                private Coding relationship;
                private List<AssetContext> context = new ArrayList<>();
                private FhirString condition;
                private List<CodeableConcept> periodType = new ArrayList<>();
                private List<Period> period = new ArrayList<>();
                private List<Period> usePeriod = new ArrayList<>();
                private FhirString text;
                private List<FhirString> linkId = new ArrayList<>();
                private List<Contract.Term.ContractOffer.Answer> answer = new ArrayList<>();
                private List<FhirUnsignedInt> securityLabelNumber = new ArrayList<>();
                private List<ValuedItem> valuedItem = new ArrayList<>();

                private Builder() {
                }

                private Builder(ContractAsset original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.scope = original.scope();
                    this.type = new ArrayList<>(original.type());
                    this.typeReference = new ArrayList<>(original.typeReference());
                    this.subtype = new ArrayList<>(original.subtype());
                    this.relationship = original.relationship();
                    this.context = new ArrayList<>(original.context());
                    this.condition = original.condition();
                    this.periodType = new ArrayList<>(original.periodType());
                    this.period = new ArrayList<>(original.period());
                    this.usePeriod = new ArrayList<>(original.usePeriod());
                    this.text = original.text();
                    this.linkId = new ArrayList<>(original.linkId());
                    this.answer = new ArrayList<>(original.answer());
                    this.securityLabelNumber = new ArrayList<>(original.securityLabelNumber());
                    this.valuedItem = new ArrayList<>(original.valuedItem());
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
                 * Sets {@code scope}.
                 *
                 * @param scope the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder scope(CodeableConcept scope) {
                    this.scope = scope;
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
                 * Replaces all {@code typeReference} values.
                 *
                 * @param typeReference the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder typeReference(List<Reference> typeReference) {
                    this.typeReference = typeReference == null ? new ArrayList<>() : new ArrayList<>(typeReference);
                    return this;
                }

                /**
                 * Adds a {@code typeReference} value.
                 *
                 * @param typeReference the value to add
                 * @return this builder
                 */
                public Builder addTypeReference(Reference typeReference) {
                    this.typeReference.add(Objects.requireNonNull(typeReference, "typeReference"));
                    return this;
                }

                /**
                 * Replaces all {@code subtype} values.
                 *
                 * @param subtype the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder subtype(List<CodeableConcept> subtype) {
                    this.subtype = subtype == null ? new ArrayList<>() : new ArrayList<>(subtype);
                    return this;
                }

                /**
                 * Adds a {@code subtype} value.
                 *
                 * @param subtype the value to add
                 * @return this builder
                 */
                public Builder addSubtype(CodeableConcept subtype) {
                    this.subtype.add(Objects.requireNonNull(subtype, "subtype"));
                    return this;
                }

                /**
                 * Sets {@code relationship}.
                 *
                 * @param relationship the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder relationship(Coding relationship) {
                    this.relationship = relationship;
                    return this;
                }

                /**
                 * Replaces all {@code context} values.
                 *
                 * @param context the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder context(List<AssetContext> context) {
                    this.context = context == null ? new ArrayList<>() : new ArrayList<>(context);
                    return this;
                }

                /**
                 * Adds a {@code context} value.
                 *
                 * @param context the value to add
                 * @return this builder
                 */
                public Builder addContext(AssetContext context) {
                    this.context.add(Objects.requireNonNull(context, "context"));
                    return this;
                }

                /**
                 * Sets {@code condition}.
                 *
                 * @param condition the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder condition(FhirString condition) {
                    this.condition = condition;
                    return this;
                }

                /**
                 * Sets {@code condition}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param condition the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder condition(String condition) {
                    return condition(condition == null ? null : FhirString.of(condition));
                }

                /**
                 * Replaces all {@code periodType} values.
                 *
                 * @param periodType the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder periodType(List<CodeableConcept> periodType) {
                    this.periodType = periodType == null ? new ArrayList<>() : new ArrayList<>(periodType);
                    return this;
                }

                /**
                 * Adds a {@code periodType} value.
                 *
                 * @param periodType the value to add
                 * @return this builder
                 */
                public Builder addPeriodType(CodeableConcept periodType) {
                    this.periodType.add(Objects.requireNonNull(periodType, "periodType"));
                    return this;
                }

                /**
                 * Replaces all {@code period} values.
                 *
                 * @param period the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder period(List<Period> period) {
                    this.period = period == null ? new ArrayList<>() : new ArrayList<>(period);
                    return this;
                }

                /**
                 * Adds a {@code period} value.
                 *
                 * @param period the value to add
                 * @return this builder
                 */
                public Builder addPeriod(Period period) {
                    this.period.add(Objects.requireNonNull(period, "period"));
                    return this;
                }

                /**
                 * Replaces all {@code usePeriod} values.
                 *
                 * @param usePeriod the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder usePeriod(List<Period> usePeriod) {
                    this.usePeriod = usePeriod == null ? new ArrayList<>() : new ArrayList<>(usePeriod);
                    return this;
                }

                /**
                 * Adds a {@code usePeriod} value.
                 *
                 * @param usePeriod the value to add
                 * @return this builder
                 */
                public Builder addUsePeriod(Period usePeriod) {
                    this.usePeriod.add(Objects.requireNonNull(usePeriod, "usePeriod"));
                    return this;
                }

                /**
                 * Sets {@code text}.
                 *
                 * @param text the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder text(FhirString text) {
                    this.text = text;
                    return this;
                }

                /**
                 * Sets {@code text}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param text the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder text(String text) {
                    return text(text == null ? null : FhirString.of(text));
                }

                /**
                 * Replaces all {@code linkId} values.
                 *
                 * @param linkId the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder linkId(List<FhirString> linkId) {
                    this.linkId = linkId == null ? new ArrayList<>() : new ArrayList<>(linkId);
                    return this;
                }

                /**
                 * Adds a {@code linkId} value.
                 *
                 * @param linkId the value to add
                 * @return this builder
                 */
                public Builder addLinkId(FhirString linkId) {
                    this.linkId.add(Objects.requireNonNull(linkId, "linkId"));
                    return this;
                }

                /**
                 * Adds a {@code linkId} value, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param linkId the value to add
                 * @return this builder
                 */
                public Builder addLinkId(String linkId) {
                    return addLinkId(FhirString.of(linkId));
                }

                /**
                 * Replaces all {@code answer} values.
                 *
                 * @param answer the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder answer(List<Contract.Term.ContractOffer.Answer> answer) {
                    this.answer = answer == null ? new ArrayList<>() : new ArrayList<>(answer);
                    return this;
                }

                /**
                 * Adds a {@code answer} value.
                 *
                 * @param answer the value to add
                 * @return this builder
                 */
                public Builder addAnswer(Contract.Term.ContractOffer.Answer answer) {
                    this.answer.add(Objects.requireNonNull(answer, "answer"));
                    return this;
                }

                /**
                 * Replaces all {@code securityLabelNumber} values.
                 *
                 * @param securityLabelNumber the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder securityLabelNumber(List<FhirUnsignedInt> securityLabelNumber) {
                    this.securityLabelNumber = securityLabelNumber == null
                            ? new ArrayList<>()
                            : new ArrayList<>(securityLabelNumber);
                    return this;
                }

                /**
                 * Adds a {@code securityLabelNumber} value.
                 *
                 * @param securityLabelNumber the value to add
                 * @return this builder
                 */
                public Builder addSecurityLabelNumber(FhirUnsignedInt securityLabelNumber) {
                    this.securityLabelNumber.add(Objects.requireNonNull(securityLabelNumber, "securityLabelNumber"));
                    return this;
                }

                /**
                 * Adds a {@code securityLabelNumber} value, wrapped in a {@link FhirUnsignedInt} without id or extensions.
                 *
                 * @param securityLabelNumber the value to add
                 * @return this builder
                 */
                public Builder addSecurityLabelNumber(Integer securityLabelNumber) {
                    return addSecurityLabelNumber(FhirUnsignedInt.of(securityLabelNumber));
                }

                /**
                 * Replaces all {@code valuedItem} values.
                 *
                 * @param valuedItem the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder valuedItem(List<ValuedItem> valuedItem) {
                    this.valuedItem = valuedItem == null ? new ArrayList<>() : new ArrayList<>(valuedItem);
                    return this;
                }

                /**
                 * Adds a {@code valuedItem} value.
                 *
                 * @param valuedItem the value to add
                 * @return this builder
                 */
                public Builder addValuedItem(ValuedItem valuedItem) {
                    this.valuedItem.add(Objects.requireNonNull(valuedItem, "valuedItem"));
                    return this;
                }

                /**
                 * Builds the {@code ContractAsset}.
                 *
                 * @return the {@code ContractAsset}
                 */
                public ContractAsset build() {
                    return new ContractAsset(
                            id, extension, modifierExtension, scope, type, typeReference, subtype, relationship,
                            context, condition, periodType, period, usePeriod, text, linkId, answer,
                            securityLabelNumber, valuedItem);
                }
            }
        }

        /**
         * An actor taking a role in an activity for which it can be assigned some degree of responsibility for the
         * activity taking place.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param doNotPerform True if the term prohibits the action. Modifier element.
         * @param type Type or form of the action. Required.
         * @param subject Entity of the action.
         * @param intent Purpose for the Contract Term Action. Required.
         * @param linkId Pointer to specific item.
         * @param status State of the action. Required.
         * @param context Episode associated with action. Reference to Encounter, EpisodeOfCare.
         * @param contextLinkId Pointer to specific item.
         * @param occurrence When action happens. One of dateTime, Period, Timing.
         * @param requester Who asked for action. Reference to Patient, RelatedPerson, Practitioner, PractitionerRole,
         *   Device, Group, Organization.
         * @param requesterLinkId Pointer to specific item.
         * @param performerType Kind of service performer.
         * @param performerRole Competency of the performer.
         * @param performer Actor that wil execute (or not) the action. Reference to RelatedPerson, Patient,
         *   Practitioner, PractitionerRole, CareTeam, Device, Substance, Organization, Location.
         * @param performerLinkId Pointer to specific item.
         * @param reason Why is action (not) needed?.
         * @param reasonLinkId Pointer to specific item.
         * @param note Comments about the action.
         * @param securityLabelNumber Action restriction numbers.
         */
        public record Action(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirBoolean doNotPerform,
                CodeableConcept type,
                List<ActionSubject> subject,
                CodeableConcept intent,
                List<FhirString> linkId,
                CodeableConcept status,
                Reference context,
                List<FhirString> contextLinkId,
                DataType occurrence,
                List<Reference> requester,
                List<FhirString> requesterLinkId,
                List<CodeableConcept> performerType,
                CodeableConcept performerRole,
                Reference performer,
                List<FhirString> performerLinkId,
                List<CodeableReference> reason,
                List<FhirString> reasonLinkId,
                List<Annotation> note,
                List<FhirUnsignedInt> securityLabelNumber) implements BackboneElement {

            /**
             * Creates an {@code Action}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Action {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                subject = subject == null ? List.of() : List.copyOf(subject);
                linkId = linkId == null ? List.of() : List.copyOf(linkId);
                contextLinkId = contextLinkId == null ? List.of() : List.copyOf(contextLinkId);
                requester = requester == null ? List.of() : List.copyOf(requester);
                requesterLinkId = requesterLinkId == null ? List.of() : List.copyOf(requesterLinkId);
                performerType = performerType == null ? List.of() : List.copyOf(performerType);
                performerLinkId = performerLinkId == null ? List.of() : List.copyOf(performerLinkId);
                reason = reason == null ? List.of() : List.copyOf(reason);
                reasonLinkId = reasonLinkId == null ? List.of() : List.copyOf(reasonLinkId);
                note = note == null ? List.of() : List.copyOf(note);
                securityLabelNumber = securityLabelNumber == null ? List.of() : List.copyOf(securityLabelNumber);
                Objects.requireNonNull(type, "Contract.term.action.type is required");
                Objects.requireNonNull(intent, "Contract.term.action.intent is required");
                Objects.requireNonNull(status, "Contract.term.action.status is required");
                if (occurrence != null && !(occurrence instanceof FhirDateTime
                        || occurrence instanceof Period
                        || occurrence instanceof Timing)) {
                    throw new IllegalArgumentException(
                            "Contract.term.action.occurrence[x] must be one of dateTime, Period, Timing, but was "
                                    + occurrence.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code Action}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Entity of the action.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param reference Entity of the action. Reference to Patient, RelatedPerson, Practitioner,
             *   PractitionerRole, Device, Group, Organization. Required.
             * @param role Role type of the agent.
             */
            public record ActionSubject(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    List<Reference> reference,
                    CodeableConcept role) implements BackboneElement {

                /**
                 * Creates an {@code ActionSubject}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public ActionSubject {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    reference = reference == null ? List.of() : List.copyOf(reference);
                    if (reference.isEmpty()) {
                        throw new IllegalArgumentException(
                                "Contract.term.action.subject.reference requires at least one value");
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
                 * Returns a builder initialized with the values of this {@code ActionSubject}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link ActionSubject}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private List<Reference> reference = new ArrayList<>();
                    private CodeableConcept role;

                    private Builder() {
                    }

                    private Builder(ActionSubject original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.reference = new ArrayList<>(original.reference());
                        this.role = original.role();
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
                     * Replaces all {@code reference} values.
                     *
                     * @param reference the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder reference(List<Reference> reference) {
                        this.reference = reference == null ? new ArrayList<>() : new ArrayList<>(reference);
                        return this;
                    }

                    /**
                     * Adds a {@code reference} value.
                     *
                     * @param reference the value to add
                     * @return this builder
                     */
                    public Builder addReference(Reference reference) {
                        this.reference.add(Objects.requireNonNull(reference, "reference"));
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
                     * Builds the {@code ActionSubject}.
                     *
                     * @return the {@code ActionSubject}
                     * @throws NullPointerException if a required element is absent
                     * @throws IllegalArgumentException if a required list is empty
                     */
                    public ActionSubject build() {
                        return new ActionSubject(
                                id, extension, modifierExtension, reference, role);
                    }
                }
            }

            /** Builder for {@link Action}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirBoolean doNotPerform;
                private CodeableConcept type;
                private List<ActionSubject> subject = new ArrayList<>();
                private CodeableConcept intent;
                private List<FhirString> linkId = new ArrayList<>();
                private CodeableConcept status;
                private Reference context;
                private List<FhirString> contextLinkId = new ArrayList<>();
                private DataType occurrence;
                private List<Reference> requester = new ArrayList<>();
                private List<FhirString> requesterLinkId = new ArrayList<>();
                private List<CodeableConcept> performerType = new ArrayList<>();
                private CodeableConcept performerRole;
                private Reference performer;
                private List<FhirString> performerLinkId = new ArrayList<>();
                private List<CodeableReference> reason = new ArrayList<>();
                private List<FhirString> reasonLinkId = new ArrayList<>();
                private List<Annotation> note = new ArrayList<>();
                private List<FhirUnsignedInt> securityLabelNumber = new ArrayList<>();

                private Builder() {
                }

                private Builder(Action original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.doNotPerform = original.doNotPerform();
                    this.type = original.type();
                    this.subject = new ArrayList<>(original.subject());
                    this.intent = original.intent();
                    this.linkId = new ArrayList<>(original.linkId());
                    this.status = original.status();
                    this.context = original.context();
                    this.contextLinkId = new ArrayList<>(original.contextLinkId());
                    this.occurrence = original.occurrence();
                    this.requester = new ArrayList<>(original.requester());
                    this.requesterLinkId = new ArrayList<>(original.requesterLinkId());
                    this.performerType = new ArrayList<>(original.performerType());
                    this.performerRole = original.performerRole();
                    this.performer = original.performer();
                    this.performerLinkId = new ArrayList<>(original.performerLinkId());
                    this.reason = new ArrayList<>(original.reason());
                    this.reasonLinkId = new ArrayList<>(original.reasonLinkId());
                    this.note = new ArrayList<>(original.note());
                    this.securityLabelNumber = new ArrayList<>(original.securityLabelNumber());
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
                 * Sets {@code doNotPerform}.
                 *
                 * @param doNotPerform the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder doNotPerform(FhirBoolean doNotPerform) {
                    this.doNotPerform = doNotPerform;
                    return this;
                }

                /**
                 * Sets {@code doNotPerform}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param doNotPerform the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder doNotPerform(Boolean doNotPerform) {
                    return doNotPerform(doNotPerform == null ? null : FhirBoolean.of(doNotPerform));
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
                 * Replaces all {@code subject} values.
                 *
                 * @param subject the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder subject(List<ActionSubject> subject) {
                    this.subject = subject == null ? new ArrayList<>() : new ArrayList<>(subject);
                    return this;
                }

                /**
                 * Adds a {@code subject} value.
                 *
                 * @param subject the value to add
                 * @return this builder
                 */
                public Builder addSubject(ActionSubject subject) {
                    this.subject.add(Objects.requireNonNull(subject, "subject"));
                    return this;
                }

                /**
                 * Sets {@code intent}.
                 *
                 * @param intent the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder intent(CodeableConcept intent) {
                    this.intent = intent;
                    return this;
                }

                /**
                 * Replaces all {@code linkId} values.
                 *
                 * @param linkId the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder linkId(List<FhirString> linkId) {
                    this.linkId = linkId == null ? new ArrayList<>() : new ArrayList<>(linkId);
                    return this;
                }

                /**
                 * Adds a {@code linkId} value.
                 *
                 * @param linkId the value to add
                 * @return this builder
                 */
                public Builder addLinkId(FhirString linkId) {
                    this.linkId.add(Objects.requireNonNull(linkId, "linkId"));
                    return this;
                }

                /**
                 * Adds a {@code linkId} value, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param linkId the value to add
                 * @return this builder
                 */
                public Builder addLinkId(String linkId) {
                    return addLinkId(FhirString.of(linkId));
                }

                /**
                 * Sets {@code status}.
                 *
                 * @param status the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder status(CodeableConcept status) {
                    this.status = status;
                    return this;
                }

                /**
                 * Sets {@code context}.
                 *
                 * @param context the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder context(Reference context) {
                    this.context = context;
                    return this;
                }

                /**
                 * Replaces all {@code contextLinkId} values.
                 *
                 * @param contextLinkId the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder contextLinkId(List<FhirString> contextLinkId) {
                    this.contextLinkId = contextLinkId == null ? new ArrayList<>() : new ArrayList<>(contextLinkId);
                    return this;
                }

                /**
                 * Adds a {@code contextLinkId} value.
                 *
                 * @param contextLinkId the value to add
                 * @return this builder
                 */
                public Builder addContextLinkId(FhirString contextLinkId) {
                    this.contextLinkId.add(Objects.requireNonNull(contextLinkId, "contextLinkId"));
                    return this;
                }

                /**
                 * Adds a {@code contextLinkId} value, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param contextLinkId the value to add
                 * @return this builder
                 */
                public Builder addContextLinkId(String contextLinkId) {
                    return addContextLinkId(FhirString.of(contextLinkId));
                }

                /**
                 * Sets {@code occurrence} to a dateTime.
                 *
                 * @param occurrence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder occurrence(FhirDateTime occurrence) {
                    this.occurrence = occurrence;
                    return this;
                }

                /**
                 * Sets {@code occurrence} to a Period.
                 *
                 * @param occurrence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder occurrence(Period occurrence) {
                    this.occurrence = occurrence;
                    return this;
                }

                /**
                 * Sets {@code occurrence} to a Timing.
                 *
                 * @param occurrence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder occurrence(Timing occurrence) {
                    this.occurrence = occurrence;
                    return this;
                }

                /**
                 * Sets {@code occurrence} to a dateTime without id or extensions.
                 *
                 * @param occurrence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder occurrence(Temporal occurrence) {
                    this.occurrence = occurrence == null ? null : FhirDateTime.of(occurrence);
                    return this;
                }

                /**
                 * Replaces all {@code requester} values.
                 *
                 * @param requester the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder requester(List<Reference> requester) {
                    this.requester = requester == null ? new ArrayList<>() : new ArrayList<>(requester);
                    return this;
                }

                /**
                 * Adds a {@code requester} value.
                 *
                 * @param requester the value to add
                 * @return this builder
                 */
                public Builder addRequester(Reference requester) {
                    this.requester.add(Objects.requireNonNull(requester, "requester"));
                    return this;
                }

                /**
                 * Replaces all {@code requesterLinkId} values.
                 *
                 * @param requesterLinkId the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder requesterLinkId(List<FhirString> requesterLinkId) {
                    this.requesterLinkId = requesterLinkId == null
                            ? new ArrayList<>()
                            : new ArrayList<>(requesterLinkId);
                    return this;
                }

                /**
                 * Adds a {@code requesterLinkId} value.
                 *
                 * @param requesterLinkId the value to add
                 * @return this builder
                 */
                public Builder addRequesterLinkId(FhirString requesterLinkId) {
                    this.requesterLinkId.add(Objects.requireNonNull(requesterLinkId, "requesterLinkId"));
                    return this;
                }

                /**
                 * Adds a {@code requesterLinkId} value, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param requesterLinkId the value to add
                 * @return this builder
                 */
                public Builder addRequesterLinkId(String requesterLinkId) {
                    return addRequesterLinkId(FhirString.of(requesterLinkId));
                }

                /**
                 * Replaces all {@code performerType} values.
                 *
                 * @param performerType the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder performerType(List<CodeableConcept> performerType) {
                    this.performerType = performerType == null ? new ArrayList<>() : new ArrayList<>(performerType);
                    return this;
                }

                /**
                 * Adds a {@code performerType} value.
                 *
                 * @param performerType the value to add
                 * @return this builder
                 */
                public Builder addPerformerType(CodeableConcept performerType) {
                    this.performerType.add(Objects.requireNonNull(performerType, "performerType"));
                    return this;
                }

                /**
                 * Sets {@code performerRole}.
                 *
                 * @param performerRole the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder performerRole(CodeableConcept performerRole) {
                    this.performerRole = performerRole;
                    return this;
                }

                /**
                 * Sets {@code performer}.
                 *
                 * @param performer the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder performer(Reference performer) {
                    this.performer = performer;
                    return this;
                }

                /**
                 * Replaces all {@code performerLinkId} values.
                 *
                 * @param performerLinkId the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder performerLinkId(List<FhirString> performerLinkId) {
                    this.performerLinkId = performerLinkId == null
                            ? new ArrayList<>()
                            : new ArrayList<>(performerLinkId);
                    return this;
                }

                /**
                 * Adds a {@code performerLinkId} value.
                 *
                 * @param performerLinkId the value to add
                 * @return this builder
                 */
                public Builder addPerformerLinkId(FhirString performerLinkId) {
                    this.performerLinkId.add(Objects.requireNonNull(performerLinkId, "performerLinkId"));
                    return this;
                }

                /**
                 * Adds a {@code performerLinkId} value, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param performerLinkId the value to add
                 * @return this builder
                 */
                public Builder addPerformerLinkId(String performerLinkId) {
                    return addPerformerLinkId(FhirString.of(performerLinkId));
                }

                /**
                 * Replaces all {@code reason} values.
                 *
                 * @param reason the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder reason(List<CodeableReference> reason) {
                    this.reason = reason == null ? new ArrayList<>() : new ArrayList<>(reason);
                    return this;
                }

                /**
                 * Adds a {@code reason} value.
                 *
                 * @param reason the value to add
                 * @return this builder
                 */
                public Builder addReason(CodeableReference reason) {
                    this.reason.add(Objects.requireNonNull(reason, "reason"));
                    return this;
                }

                /**
                 * Replaces all {@code reasonLinkId} values.
                 *
                 * @param reasonLinkId the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder reasonLinkId(List<FhirString> reasonLinkId) {
                    this.reasonLinkId = reasonLinkId == null ? new ArrayList<>() : new ArrayList<>(reasonLinkId);
                    return this;
                }

                /**
                 * Adds a {@code reasonLinkId} value.
                 *
                 * @param reasonLinkId the value to add
                 * @return this builder
                 */
                public Builder addReasonLinkId(FhirString reasonLinkId) {
                    this.reasonLinkId.add(Objects.requireNonNull(reasonLinkId, "reasonLinkId"));
                    return this;
                }

                /**
                 * Adds a {@code reasonLinkId} value, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param reasonLinkId the value to add
                 * @return this builder
                 */
                public Builder addReasonLinkId(String reasonLinkId) {
                    return addReasonLinkId(FhirString.of(reasonLinkId));
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
                 * Replaces all {@code securityLabelNumber} values.
                 *
                 * @param securityLabelNumber the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder securityLabelNumber(List<FhirUnsignedInt> securityLabelNumber) {
                    this.securityLabelNumber = securityLabelNumber == null
                            ? new ArrayList<>()
                            : new ArrayList<>(securityLabelNumber);
                    return this;
                }

                /**
                 * Adds a {@code securityLabelNumber} value.
                 *
                 * @param securityLabelNumber the value to add
                 * @return this builder
                 */
                public Builder addSecurityLabelNumber(FhirUnsignedInt securityLabelNumber) {
                    this.securityLabelNumber.add(Objects.requireNonNull(securityLabelNumber, "securityLabelNumber"));
                    return this;
                }

                /**
                 * Adds a {@code securityLabelNumber} value, wrapped in a {@link FhirUnsignedInt} without id or extensions.
                 *
                 * @param securityLabelNumber the value to add
                 * @return this builder
                 */
                public Builder addSecurityLabelNumber(Integer securityLabelNumber) {
                    return addSecurityLabelNumber(FhirUnsignedInt.of(securityLabelNumber));
                }

                /**
                 * Builds the {@code Action}.
                 *
                 * @return the {@code Action}
                 * @throws NullPointerException if a required element is absent
                 */
                public Action build() {
                    return new Action(
                            id, extension, modifierExtension, doNotPerform, type, subject, intent, linkId, status,
                            context, contextLinkId, occurrence, requester, requesterLinkId, performerType,
                            performerRole, performer, performerLinkId, reason, reasonLinkId, note,
                            securityLabelNumber);
                }
            }
        }

        /** Builder for {@link Term}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Identifier identifier;
            private FhirDateTime issued;
            private Period applies;
            private DataType topic;
            private CodeableConcept type;
            private CodeableConcept subType;
            private FhirString text;
            private List<SecurityLabel> securityLabel = new ArrayList<>();
            private ContractOffer offer;
            private List<ContractAsset> asset = new ArrayList<>();
            private List<Action> action = new ArrayList<>();
            private List<Contract.Term> group = new ArrayList<>();

            private Builder() {
            }

            private Builder(Term original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = original.identifier();
                this.issued = original.issued();
                this.applies = original.applies();
                this.topic = original.topic();
                this.type = original.type();
                this.subType = original.subType();
                this.text = original.text();
                this.securityLabel = new ArrayList<>(original.securityLabel());
                this.offer = original.offer();
                this.asset = new ArrayList<>(original.asset());
                this.action = new ArrayList<>(original.action());
                this.group = new ArrayList<>(original.group());
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
             * Sets {@code identifier}.
             *
             * @param identifier the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identifier(Identifier identifier) {
                this.identifier = identifier;
                return this;
            }

            /**
             * Sets {@code issued}.
             *
             * @param issued the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder issued(FhirDateTime issued) {
                this.issued = issued;
                return this;
            }

            /**
             * Sets {@code issued}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param issued the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder issued(Temporal issued) {
                return issued(issued == null ? null : FhirDateTime.of(issued));
            }

            /**
             * Sets {@code applies}.
             *
             * @param applies the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder applies(Period applies) {
                this.applies = applies;
                return this;
            }

            /**
             * Sets {@code topic} to a CodeableConcept.
             *
             * @param topic the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder topic(CodeableConcept topic) {
                this.topic = topic;
                return this;
            }

            /**
             * Sets {@code topic} to a Reference.
             *
             * @param topic the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder topic(Reference topic) {
                this.topic = topic;
                return this;
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
             * Sets {@code subType}.
             *
             * @param subType the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subType(CodeableConcept subType) {
                this.subType = subType;
                return this;
            }

            /**
             * Sets {@code text}.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(FhirString text) {
                this.text = text;
                return this;
            }

            /**
             * Sets {@code text}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(String text) {
                return text(text == null ? null : FhirString.of(text));
            }

            /**
             * Replaces all {@code securityLabel} values.
             *
             * @param securityLabel the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder securityLabel(List<SecurityLabel> securityLabel) {
                this.securityLabel = securityLabel == null ? new ArrayList<>() : new ArrayList<>(securityLabel);
                return this;
            }

            /**
             * Adds a {@code securityLabel} value.
             *
             * @param securityLabel the value to add
             * @return this builder
             */
            public Builder addSecurityLabel(SecurityLabel securityLabel) {
                this.securityLabel.add(Objects.requireNonNull(securityLabel, "securityLabel"));
                return this;
            }

            /**
             * Sets {@code offer}.
             *
             * @param offer the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder offer(ContractOffer offer) {
                this.offer = offer;
                return this;
            }

            /**
             * Replaces all {@code asset} values.
             *
             * @param asset the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder asset(List<ContractAsset> asset) {
                this.asset = asset == null ? new ArrayList<>() : new ArrayList<>(asset);
                return this;
            }

            /**
             * Adds a {@code asset} value.
             *
             * @param asset the value to add
             * @return this builder
             */
            public Builder addAsset(ContractAsset asset) {
                this.asset.add(Objects.requireNonNull(asset, "asset"));
                return this;
            }

            /**
             * Replaces all {@code action} values.
             *
             * @param action the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder action(List<Action> action) {
                this.action = action == null ? new ArrayList<>() : new ArrayList<>(action);
                return this;
            }

            /**
             * Adds a {@code action} value.
             *
             * @param action the value to add
             * @return this builder
             */
            public Builder addAction(Action action) {
                this.action.add(Objects.requireNonNull(action, "action"));
                return this;
            }

            /**
             * Replaces all {@code group} values.
             *
             * @param group the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder group(List<Contract.Term> group) {
                this.group = group == null ? new ArrayList<>() : new ArrayList<>(group);
                return this;
            }

            /**
             * Adds a {@code group} value.
             *
             * @param group the value to add
             * @return this builder
             */
            public Builder addGroup(Contract.Term group) {
                this.group.add(Objects.requireNonNull(group, "group"));
                return this;
            }

            /**
             * Builds the {@code Term}.
             *
             * @return the {@code Term}
             * @throws NullPointerException if a required element is absent
             */
            public Term build() {
                return new Term(
                        id, extension, modifierExtension, identifier, issued, applies, topic, type, subType, text,
                        securityLabel, offer, asset, action, group);
            }
        }
    }

    /**
     * Parties with legal standing in the Contract, including the principal parties, the grantor(s) and grantee(s),
     * which are any person or organization bound by the contract, and any ancillary parties, which facilitate the
     * execution of the contract such as a notary or witness.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Contract Signatory Role. Required.
     * @param party Contract Signatory Party. Reference to Organization, Patient, Practitioner, PractitionerRole,
     *   RelatedPerson. Required.
     * @param signature Contract Documentation Signature. Required.
     */
    public record Signatory(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Coding type,
            Reference party,
            List<Signature> signature) implements BackboneElement {

        /**
         * Creates a {@code Signatory}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a required list is empty
         */
        public Signatory {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            signature = signature == null ? List.of() : List.copyOf(signature);
            Objects.requireNonNull(type, "Contract.signer.type is required");
            Objects.requireNonNull(party, "Contract.signer.party is required");
            if (signature.isEmpty()) {
                throw new IllegalArgumentException("Contract.signer.signature requires at least one value");
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
         * Returns a builder initialized with the values of this {@code Signatory}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Signatory}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Coding type;
            private Reference party;
            private List<Signature> signature = new ArrayList<>();

            private Builder() {
            }

            private Builder(Signatory original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.party = original.party();
                this.signature = new ArrayList<>(original.signature());
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
             * Sets {@code type}.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(Coding type) {
                this.type = type;
                return this;
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
             * Replaces all {@code signature} values.
             *
             * @param signature the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder signature(List<Signature> signature) {
                this.signature = signature == null ? new ArrayList<>() : new ArrayList<>(signature);
                return this;
            }

            /**
             * Adds a {@code signature} value.
             *
             * @param signature the value to add
             * @return this builder
             */
            public Builder addSignature(Signature signature) {
                this.signature.add(Objects.requireNonNull(signature, "signature"));
                return this;
            }

            /**
             * Builds the {@code Signatory}.
             *
             * @return the {@code Signatory}
             * @throws NullPointerException if a required element is absent
             * @throws IllegalArgumentException if a required list is empty
             */
            public Signatory build() {
                return new Signatory(
                        id, extension, modifierExtension, type, party, signature);
            }
        }
    }

    /**
     * The "patient friendly language" versionof the Contract in whole or in parts.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param content Easily comprehended representation of this Contract. One of Attachment, Reference. Required.
     */
    public record FriendlyLanguage(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType content) implements BackboneElement {

        /**
         * Creates a {@code FriendlyLanguage}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public FriendlyLanguage {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(content, "Contract.friendly.content is required");
            if (content != null && !(content instanceof Attachment || content instanceof Reference)) {
                throw new IllegalArgumentException(
                        "Contract.friendly.content[x] must be one of Attachment, Reference, but was "
                                + content.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code FriendlyLanguage}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link FriendlyLanguage}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType content;

            private Builder() {
            }

            private Builder(FriendlyLanguage original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.content = original.content();
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
             * Sets {@code content} to a Attachment.
             *
             * @param content the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder content(Attachment content) {
                this.content = content;
                return this;
            }

            /**
             * Sets {@code content} to a Reference.
             *
             * @param content the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder content(Reference content) {
                this.content = content;
                return this;
            }

            /**
             * Builds the {@code FriendlyLanguage}.
             *
             * @return the {@code FriendlyLanguage}
             * @throws NullPointerException if a required element is absent
             */
            public FriendlyLanguage build() {
                return new FriendlyLanguage(
                        id, extension, modifierExtension, content);
            }
        }
    }

    /**
     * List of Legal expressions or representations of this Contract.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param content Contract Legal Text. One of Attachment, Reference. Required.
     */
    public record LegalLanguage(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType content) implements BackboneElement {

        /**
         * Creates a {@code LegalLanguage}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public LegalLanguage {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(content, "Contract.legal.content is required");
            if (content != null && !(content instanceof Attachment || content instanceof Reference)) {
                throw new IllegalArgumentException(
                        "Contract.legal.content[x] must be one of Attachment, Reference, but was "
                                + content.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code LegalLanguage}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link LegalLanguage}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType content;

            private Builder() {
            }

            private Builder(LegalLanguage original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.content = original.content();
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
             * Sets {@code content} to a Attachment.
             *
             * @param content the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder content(Attachment content) {
                this.content = content;
                return this;
            }

            /**
             * Sets {@code content} to a Reference.
             *
             * @param content the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder content(Reference content) {
                this.content = content;
                return this;
            }

            /**
             * Builds the {@code LegalLanguage}.
             *
             * @return the {@code LegalLanguage}
             * @throws NullPointerException if a required element is absent
             */
            public LegalLanguage build() {
                return new LegalLanguage(
                        id, extension, modifierExtension, content);
            }
        }
    }

    /**
     * List of Computable Policy Rule Language Representations of this Contract.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param content Computable Contract Rules. One of Attachment, Reference. Required.
     */
    public record ComputableLanguage(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            DataType content) implements BackboneElement {

        /**
         * Creates a {@code ComputableLanguage}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public ComputableLanguage {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(content, "Contract.rule.content is required");
            if (content != null && !(content instanceof Attachment || content instanceof Reference)) {
                throw new IllegalArgumentException(
                        "Contract.rule.content[x] must be one of Attachment, Reference, but was "
                                + content.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code ComputableLanguage}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ComputableLanguage}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private DataType content;

            private Builder() {
            }

            private Builder(ComputableLanguage original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.content = original.content();
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
             * Sets {@code content} to a Attachment.
             *
             * @param content the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder content(Attachment content) {
                this.content = content;
                return this;
            }

            /**
             * Sets {@code content} to a Reference.
             *
             * @param content the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder content(Reference content) {
                this.content = content;
                return this;
            }

            /**
             * Builds the {@code ComputableLanguage}.
             *
             * @return the {@code ComputableLanguage}
             * @throws NullPointerException if a required element is absent
             */
            public ComputableLanguage build() {
                return new ComputableLanguage(
                        id, extension, modifierExtension, content);
            }
        }
    }

    /** Builder for {@link Contract}. Builders are mutable and not thread-safe. */
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
        private FhirUri url;
        private FhirString version;
        private FhirEnum<ContractResourceStatusCodes> status;
        private CodeableConcept legalState;
        private Reference instantiatesCanonical;
        private FhirUri instantiatesUri;
        private CodeableConcept contentDerivative;
        private FhirDateTime issued;
        private Period applies;
        private CodeableConcept expirationType;
        private List<Reference> subject = new ArrayList<>();
        private List<Reference> authority = new ArrayList<>();
        private List<Reference> domain = new ArrayList<>();
        private List<Reference> site = new ArrayList<>();
        private FhirString name;
        private FhirString title;
        private FhirString subtitle;
        private List<FhirString> alias = new ArrayList<>();
        private Reference author;
        private CodeableConcept scope;
        private DataType topic;
        private CodeableConcept type;
        private List<CodeableConcept> subType = new ArrayList<>();
        private ContentDefinition contentDefinition;
        private List<Term> term = new ArrayList<>();
        private List<Reference> supportingInfo = new ArrayList<>();
        private List<Reference> relevantHistory = new ArrayList<>();
        private List<Signatory> signer = new ArrayList<>();
        private List<FriendlyLanguage> friendly = new ArrayList<>();
        private List<LegalLanguage> legal = new ArrayList<>();
        private List<ComputableLanguage> rule = new ArrayList<>();
        private DataType legallyBinding;

        private Builder() {
        }

        private Builder(Contract original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.url = original.url();
            this.version = original.version();
            this.status = original.status();
            this.legalState = original.legalState();
            this.instantiatesCanonical = original.instantiatesCanonical();
            this.instantiatesUri = original.instantiatesUri();
            this.contentDerivative = original.contentDerivative();
            this.issued = original.issued();
            this.applies = original.applies();
            this.expirationType = original.expirationType();
            this.subject = new ArrayList<>(original.subject());
            this.authority = new ArrayList<>(original.authority());
            this.domain = new ArrayList<>(original.domain());
            this.site = new ArrayList<>(original.site());
            this.name = original.name();
            this.title = original.title();
            this.subtitle = original.subtitle();
            this.alias = new ArrayList<>(original.alias());
            this.author = original.author();
            this.scope = original.scope();
            this.topic = original.topic();
            this.type = original.type();
            this.subType = new ArrayList<>(original.subType());
            this.contentDefinition = original.contentDefinition();
            this.term = new ArrayList<>(original.term());
            this.supportingInfo = new ArrayList<>(original.supportingInfo());
            this.relevantHistory = new ArrayList<>(original.relevantHistory());
            this.signer = new ArrayList<>(original.signer());
            this.friendly = new ArrayList<>(original.friendly());
            this.legal = new ArrayList<>(original.legal());
            this.rule = new ArrayList<>(original.rule());
            this.legallyBinding = original.legallyBinding();
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
        public Builder status(FhirEnum<ContractResourceStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(ContractResourceStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code legalState}.
         *
         * @param legalState the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder legalState(CodeableConcept legalState) {
            this.legalState = legalState;
            return this;
        }

        /**
         * Sets {@code instantiatesCanonical}.
         *
         * @param instantiatesCanonical the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesCanonical(Reference instantiatesCanonical) {
            this.instantiatesCanonical = instantiatesCanonical;
            return this;
        }

        /**
         * Sets {@code instantiatesUri}.
         *
         * @param instantiatesUri the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesUri(FhirUri instantiatesUri) {
            this.instantiatesUri = instantiatesUri;
            return this;
        }

        /**
         * Sets {@code instantiatesUri}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param instantiatesUri the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesUri(String instantiatesUri) {
            return instantiatesUri(instantiatesUri == null ? null : FhirUri.of(instantiatesUri));
        }

        /**
         * Sets {@code contentDerivative}.
         *
         * @param contentDerivative the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder contentDerivative(CodeableConcept contentDerivative) {
            this.contentDerivative = contentDerivative;
            return this;
        }

        /**
         * Sets {@code issued}.
         *
         * @param issued the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issued(FhirDateTime issued) {
            this.issued = issued;
            return this;
        }

        /**
         * Sets {@code issued}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param issued the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issued(Temporal issued) {
            return issued(issued == null ? null : FhirDateTime.of(issued));
        }

        /**
         * Sets {@code applies}.
         *
         * @param applies the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder applies(Period applies) {
            this.applies = applies;
            return this;
        }

        /**
         * Sets {@code expirationType}.
         *
         * @param expirationType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder expirationType(CodeableConcept expirationType) {
            this.expirationType = expirationType;
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
         * Replaces all {@code authority} values.
         *
         * @param authority the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder authority(List<Reference> authority) {
            this.authority = authority == null ? new ArrayList<>() : new ArrayList<>(authority);
            return this;
        }

        /**
         * Adds a {@code authority} value.
         *
         * @param authority the value to add
         * @return this builder
         */
        public Builder addAuthority(Reference authority) {
            this.authority.add(Objects.requireNonNull(authority, "authority"));
            return this;
        }

        /**
         * Replaces all {@code domain} values.
         *
         * @param domain the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder domain(List<Reference> domain) {
            this.domain = domain == null ? new ArrayList<>() : new ArrayList<>(domain);
            return this;
        }

        /**
         * Adds a {@code domain} value.
         *
         * @param domain the value to add
         * @return this builder
         */
        public Builder addDomain(Reference domain) {
            this.domain.add(Objects.requireNonNull(domain, "domain"));
            return this;
        }

        /**
         * Replaces all {@code site} values.
         *
         * @param site the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder site(List<Reference> site) {
            this.site = site == null ? new ArrayList<>() : new ArrayList<>(site);
            return this;
        }

        /**
         * Adds a {@code site} value.
         *
         * @param site the value to add
         * @return this builder
         */
        public Builder addSite(Reference site) {
            this.site.add(Objects.requireNonNull(site, "site"));
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
         * Sets {@code subtitle}.
         *
         * @param subtitle the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subtitle(FhirString subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        /**
         * Sets {@code subtitle}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param subtitle the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subtitle(String subtitle) {
            return subtitle(subtitle == null ? null : FhirString.of(subtitle));
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
         * Sets {@code author}.
         *
         * @param author the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder author(Reference author) {
            this.author = author;
            return this;
        }

        /**
         * Sets {@code scope}.
         *
         * @param scope the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder scope(CodeableConcept scope) {
            this.scope = scope;
            return this;
        }

        /**
         * Sets {@code topic} to a CodeableConcept.
         *
         * @param topic the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder topic(CodeableConcept topic) {
            this.topic = topic;
            return this;
        }

        /**
         * Sets {@code topic} to a Reference.
         *
         * @param topic the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder topic(Reference topic) {
            this.topic = topic;
            return this;
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
         * Replaces all {@code subType} values.
         *
         * @param subType the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder subType(List<CodeableConcept> subType) {
            this.subType = subType == null ? new ArrayList<>() : new ArrayList<>(subType);
            return this;
        }

        /**
         * Adds a {@code subType} value.
         *
         * @param subType the value to add
         * @return this builder
         */
        public Builder addSubType(CodeableConcept subType) {
            this.subType.add(Objects.requireNonNull(subType, "subType"));
            return this;
        }

        /**
         * Sets {@code contentDefinition}.
         *
         * @param contentDefinition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder contentDefinition(ContentDefinition contentDefinition) {
            this.contentDefinition = contentDefinition;
            return this;
        }

        /**
         * Replaces all {@code term} values.
         *
         * @param term the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder term(List<Term> term) {
            this.term = term == null ? new ArrayList<>() : new ArrayList<>(term);
            return this;
        }

        /**
         * Adds a {@code term} value.
         *
         * @param term the value to add
         * @return this builder
         */
        public Builder addTerm(Term term) {
            this.term.add(Objects.requireNonNull(term, "term"));
            return this;
        }

        /**
         * Replaces all {@code supportingInfo} values.
         *
         * @param supportingInfo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder supportingInfo(List<Reference> supportingInfo) {
            this.supportingInfo = supportingInfo == null ? new ArrayList<>() : new ArrayList<>(supportingInfo);
            return this;
        }

        /**
         * Adds a {@code supportingInfo} value.
         *
         * @param supportingInfo the value to add
         * @return this builder
         */
        public Builder addSupportingInfo(Reference supportingInfo) {
            this.supportingInfo.add(Objects.requireNonNull(supportingInfo, "supportingInfo"));
            return this;
        }

        /**
         * Replaces all {@code relevantHistory} values.
         *
         * @param relevantHistory the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relevantHistory(List<Reference> relevantHistory) {
            this.relevantHistory = relevantHistory == null ? new ArrayList<>() : new ArrayList<>(relevantHistory);
            return this;
        }

        /**
         * Adds a {@code relevantHistory} value.
         *
         * @param relevantHistory the value to add
         * @return this builder
         */
        public Builder addRelevantHistory(Reference relevantHistory) {
            this.relevantHistory.add(Objects.requireNonNull(relevantHistory, "relevantHistory"));
            return this;
        }

        /**
         * Replaces all {@code signer} values.
         *
         * @param signer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder signer(List<Signatory> signer) {
            this.signer = signer == null ? new ArrayList<>() : new ArrayList<>(signer);
            return this;
        }

        /**
         * Adds a {@code signer} value.
         *
         * @param signer the value to add
         * @return this builder
         */
        public Builder addSigner(Signatory signer) {
            this.signer.add(Objects.requireNonNull(signer, "signer"));
            return this;
        }

        /**
         * Replaces all {@code friendly} values.
         *
         * @param friendly the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder friendly(List<FriendlyLanguage> friendly) {
            this.friendly = friendly == null ? new ArrayList<>() : new ArrayList<>(friendly);
            return this;
        }

        /**
         * Adds a {@code friendly} value.
         *
         * @param friendly the value to add
         * @return this builder
         */
        public Builder addFriendly(FriendlyLanguage friendly) {
            this.friendly.add(Objects.requireNonNull(friendly, "friendly"));
            return this;
        }

        /**
         * Replaces all {@code legal} values.
         *
         * @param legal the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder legal(List<LegalLanguage> legal) {
            this.legal = legal == null ? new ArrayList<>() : new ArrayList<>(legal);
            return this;
        }

        /**
         * Adds a {@code legal} value.
         *
         * @param legal the value to add
         * @return this builder
         */
        public Builder addLegal(LegalLanguage legal) {
            this.legal.add(Objects.requireNonNull(legal, "legal"));
            return this;
        }

        /**
         * Replaces all {@code rule} values.
         *
         * @param rule the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder rule(List<ComputableLanguage> rule) {
            this.rule = rule == null ? new ArrayList<>() : new ArrayList<>(rule);
            return this;
        }

        /**
         * Adds a {@code rule} value.
         *
         * @param rule the value to add
         * @return this builder
         */
        public Builder addRule(ComputableLanguage rule) {
            this.rule.add(Objects.requireNonNull(rule, "rule"));
            return this;
        }

        /**
         * Sets {@code legallyBinding} to a Attachment.
         *
         * @param legallyBinding the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder legallyBinding(Attachment legallyBinding) {
            this.legallyBinding = legallyBinding;
            return this;
        }

        /**
         * Sets {@code legallyBinding} to a Reference.
         *
         * @param legallyBinding the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder legallyBinding(Reference legallyBinding) {
            this.legallyBinding = legallyBinding;
            return this;
        }

        /**
         * Builds the {@code Contract}.
         *
         * @return the {@code Contract}
         */
        public Contract build() {
            return new Contract(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier, url,
                    version, status, legalState, instantiatesCanonical, instantiatesUri, contentDerivative, issued,
                    applies, expirationType, subject, authority, domain, site, name, title, subtitle, alias, author,
                    scope, topic, type, subType, contentDefinition, term, supportingInfo, relevantHistory, signer,
                    friendly, legal, rule, legallyBinding);
        }
    }
}
