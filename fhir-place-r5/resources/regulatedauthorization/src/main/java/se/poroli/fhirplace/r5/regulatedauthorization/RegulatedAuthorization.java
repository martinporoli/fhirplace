package se.poroli.fhirplace.r5.regulatedauthorization;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * Regulatory approval, clearance or licencing related to a regulated product, treatment, facility or activity that is
 * cited in a guidance, regulation, rule or legislative act.
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
 * @param identifier Business identifier for the authorization, typically assigned by the authorizing body.
 * @param subject The product type, treatment, facility or activity that is being authorized. Reference to
 *   MedicinalProductDefinition, BiologicallyDerivedProduct, NutritionProduct, PackagedProductDefinition,
 *   ManufacturedItemDefinition, Ingredient, SubstanceDefinition, DeviceDefinition, ResearchStudy, ActivityDefinition,
 *   PlanDefinition, ObservationDefinition, Practitioner, Organization, Location.
 * @param type Overall type of this authorization, for example drug marketing approval, orphan drug designation.
 * @param description General textual supporting information.
 * @param region The territory in which the authorization has been granted.
 * @param status The status that is authorised e.g. approved. Intermediate states can be tracked with cases and
 *   applications.
 * @param statusDate The date at which the current status was assigned.
 * @param validityPeriod The time period in which the regulatory approval etc. is in effect, e.g. a Marketing
 *   Authorization includes the date of authorization and/or expiration date.
 * @param indication Condition for which the use of the regulated product applies.
 * @param intendedUse The intended use of the product, e.g. prevention, treatment.
 * @param basis The legal/regulatory framework or reasons under which this authorization is granted.
 * @param holder The organization that has been granted this authorization, by the regulator. Reference to
 *   Organization.
 * @param regulator The regulatory authority or authorizing body granting the authorization. Reference to
 *   Organization.
 * @param attachedDocument Additional information or supporting documentation about the authorization. Reference to
 *   DocumentReference.
 * @param caseValue The case or regulatory procedure for granting or amending a regulated authorization. Note: This
 *   area is subject to ongoing review and the workgroup is seeking implementer feedback on its use (see link at
 *   bottom of page). The FHIR element {@code case}.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/RegulatedAuthorization">FHIR R5 RegulatedAuthorization</a>
 */
public record RegulatedAuthorization(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        List<Reference> subject,
        CodeableConcept type,
        FhirMarkdown description,
        List<CodeableConcept> region,
        CodeableConcept status,
        FhirDateTime statusDate,
        Period validityPeriod,
        List<CodeableReference> indication,
        CodeableConcept intendedUse,
        List<CodeableConcept> basis,
        Reference holder,
        Reference regulator,
        List<Reference> attachedDocument,
        CaseValue caseValue) implements DomainResource {

    /**
     * Creates a {@code RegulatedAuthorization}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public RegulatedAuthorization {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        subject = subject == null ? List.of() : List.copyOf(subject);
        region = region == null ? List.of() : List.copyOf(region);
        indication = indication == null ? List.of() : List.copyOf(indication);
        basis = basis == null ? List.of() : List.copyOf(basis);
        attachedDocument = attachedDocument == null ? List.of() : List.copyOf(attachedDocument);
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
     * Returns a builder initialized with the values of this {@code RegulatedAuthorization}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The case or regulatory procedure for granting or amending a regulated authorization.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier Identifier by which this case can be referenced.
     * @param type The defining type of case.
     * @param status The status associated with the case.
     * @param date Relevant date for this case. One of Period, dateTime.
     * @param application Applications submitted to obtain a regulated authorization. Steps within the longer running
     *   case or procedure.
     */
    public record CaseValue(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Identifier identifier,
            CodeableConcept type,
            CodeableConcept status,
            DataType date,
            List<RegulatedAuthorization.CaseValue> application) implements BackboneElement {

        /**
         * Creates a {@code CaseValue}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public CaseValue {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            application = application == null ? List.of() : List.copyOf(application);
            if (date != null && !(date instanceof Period || date instanceof FhirDateTime)) {
                throw new IllegalArgumentException(
                        "RegulatedAuthorization.case.date[x] must be one of Period, dateTime, but was "
                                + date.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code CaseValue}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link CaseValue}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Identifier identifier;
            private CodeableConcept type;
            private CodeableConcept status;
            private DataType date;
            private List<RegulatedAuthorization.CaseValue> application = new ArrayList<>();

            private Builder() {
            }

            private Builder(CaseValue original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = original.identifier();
                this.type = original.type();
                this.status = original.status();
                this.date = original.date();
                this.application = new ArrayList<>(original.application());
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
             * Sets {@code date} to a Period.
             *
             * @param date the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder date(Period date) {
                this.date = date;
                return this;
            }

            /**
             * Sets {@code date} to a dateTime.
             *
             * @param date the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder date(FhirDateTime date) {
                this.date = date;
                return this;
            }

            /**
             * Sets {@code date} to a dateTime without id or extensions.
             *
             * @param date the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder date(Temporal date) {
                this.date = date == null ? null : FhirDateTime.of(date);
                return this;
            }

            /**
             * Replaces all {@code application} values.
             *
             * @param application the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder application(List<RegulatedAuthorization.CaseValue> application) {
                this.application = application == null ? new ArrayList<>() : new ArrayList<>(application);
                return this;
            }

            /**
             * Adds a {@code application} value.
             *
             * @param application the value to add
             * @return this builder
             */
            public Builder addApplication(RegulatedAuthorization.CaseValue application) {
                this.application.add(Objects.requireNonNull(application, "application"));
                return this;
            }

            /**
             * Builds the {@code CaseValue}.
             *
             * @return the {@code CaseValue}
             */
            public CaseValue build() {
                return new CaseValue(
                        id, extension, modifierExtension, identifier, type, status, date, application);
            }
        }
    }

    /** Builder for {@link RegulatedAuthorization}. Builders are mutable and not thread-safe. */
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
        private List<Reference> subject = new ArrayList<>();
        private CodeableConcept type;
        private FhirMarkdown description;
        private List<CodeableConcept> region = new ArrayList<>();
        private CodeableConcept status;
        private FhirDateTime statusDate;
        private Period validityPeriod;
        private List<CodeableReference> indication = new ArrayList<>();
        private CodeableConcept intendedUse;
        private List<CodeableConcept> basis = new ArrayList<>();
        private Reference holder;
        private Reference regulator;
        private List<Reference> attachedDocument = new ArrayList<>();
        private CaseValue caseValue;

        private Builder() {
        }

        private Builder(RegulatedAuthorization original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.subject = new ArrayList<>(original.subject());
            this.type = original.type();
            this.description = original.description();
            this.region = new ArrayList<>(original.region());
            this.status = original.status();
            this.statusDate = original.statusDate();
            this.validityPeriod = original.validityPeriod();
            this.indication = new ArrayList<>(original.indication());
            this.intendedUse = original.intendedUse();
            this.basis = new ArrayList<>(original.basis());
            this.holder = original.holder();
            this.regulator = original.regulator();
            this.attachedDocument = new ArrayList<>(original.attachedDocument());
            this.caseValue = original.caseValue();
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
         * Replaces all {@code region} values.
         *
         * @param region the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder region(List<CodeableConcept> region) {
            this.region = region == null ? new ArrayList<>() : new ArrayList<>(region);
            return this;
        }

        /**
         * Adds a {@code region} value.
         *
         * @param region the value to add
         * @return this builder
         */
        public Builder addRegion(CodeableConcept region) {
            this.region.add(Objects.requireNonNull(region, "region"));
            return this;
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
         * Sets {@code statusDate}.
         *
         * @param statusDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusDate(FhirDateTime statusDate) {
            this.statusDate = statusDate;
            return this;
        }

        /**
         * Sets {@code statusDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param statusDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusDate(Temporal statusDate) {
            return statusDate(statusDate == null ? null : FhirDateTime.of(statusDate));
        }

        /**
         * Sets {@code validityPeriod}.
         *
         * @param validityPeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder validityPeriod(Period validityPeriod) {
            this.validityPeriod = validityPeriod;
            return this;
        }

        /**
         * Replaces all {@code indication} values.
         *
         * @param indication the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder indication(List<CodeableReference> indication) {
            this.indication = indication == null ? new ArrayList<>() : new ArrayList<>(indication);
            return this;
        }

        /**
         * Adds a {@code indication} value.
         *
         * @param indication the value to add
         * @return this builder
         */
        public Builder addIndication(CodeableReference indication) {
            this.indication.add(Objects.requireNonNull(indication, "indication"));
            return this;
        }

        /**
         * Sets {@code intendedUse}.
         *
         * @param intendedUse the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intendedUse(CodeableConcept intendedUse) {
            this.intendedUse = intendedUse;
            return this;
        }

        /**
         * Replaces all {@code basis} values.
         *
         * @param basis the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder basis(List<CodeableConcept> basis) {
            this.basis = basis == null ? new ArrayList<>() : new ArrayList<>(basis);
            return this;
        }

        /**
         * Adds a {@code basis} value.
         *
         * @param basis the value to add
         * @return this builder
         */
        public Builder addBasis(CodeableConcept basis) {
            this.basis.add(Objects.requireNonNull(basis, "basis"));
            return this;
        }

        /**
         * Sets {@code holder}.
         *
         * @param holder the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder holder(Reference holder) {
            this.holder = holder;
            return this;
        }

        /**
         * Sets {@code regulator}.
         *
         * @param regulator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder regulator(Reference regulator) {
            this.regulator = regulator;
            return this;
        }

        /**
         * Replaces all {@code attachedDocument} values.
         *
         * @param attachedDocument the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder attachedDocument(List<Reference> attachedDocument) {
            this.attachedDocument = attachedDocument == null ? new ArrayList<>() : new ArrayList<>(attachedDocument);
            return this;
        }

        /**
         * Adds a {@code attachedDocument} value.
         *
         * @param attachedDocument the value to add
         * @return this builder
         */
        public Builder addAttachedDocument(Reference attachedDocument) {
            this.attachedDocument.add(Objects.requireNonNull(attachedDocument, "attachedDocument"));
            return this;
        }

        /**
         * Sets {@code caseValue}.
         *
         * @param caseValue the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder caseValue(CaseValue caseValue) {
            this.caseValue = caseValue;
            return this;
        }

        /**
         * Builds the {@code RegulatedAuthorization}.
         *
         * @return the {@code RegulatedAuthorization}
         */
        public RegulatedAuthorization build() {
            return new RegulatedAuthorization(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    subject, type, description, region, status, statusDate, validityPeriod, indication, intendedUse,
                    basis, holder, regulator, attachedDocument, caseValue);
        }
    }
}
