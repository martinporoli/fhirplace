package se.poroli.fhirplace.r5.financial.support;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.EligibilityOutcome;
import se.poroli.fhirplace.r5.valuesets.EligibilityResponsePurpose;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;

/**
 * This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.
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
 * @param identifier Business Identifier for coverage eligiblity request.
 * @param status active | cancelled | draft | entered-in-error. Required. Modifier element.
 * @param purpose auth-requirements | benefits | discovery | validation. Required.
 * @param patient Intended recipient of products and services. Reference to Patient. Required.
 * @param event Event information.
 * @param serviced Estimated date or dates of service. One of date, Period.
 * @param created Response creation date. Required.
 * @param requestor Party responsible for the request. Reference to Practitioner, PractitionerRole, Organization.
 * @param request Eligibility request reference. Reference to CoverageEligibilityRequest. Required.
 * @param outcome queued | complete | error | partial. Required.
 * @param disposition Disposition Message.
 * @param insurer Coverage issuer. Reference to Organization. Required.
 * @param insurance Patient insurance information.
 * @param preAuthRef Preauthorization reference.
 * @param form Printed form identifier.
 * @param error Processing errors.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/CoverageEligibilityResponse">FHIR R5 CoverageEligibilityResponse</a>
 */
public record CoverageEligibilityResponse(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<FinancialResourceStatusCodes> status,
        List<FhirEnum<EligibilityResponsePurpose>> purpose,
        Reference patient,
        List<Event> event,
        DataType serviced,
        FhirDateTime created,
        Reference requestor,
        Reference request,
        FhirEnum<EligibilityOutcome> outcome,
        FhirString disposition,
        Reference insurer,
        List<Insurance> insurance,
        FhirString preAuthRef,
        CodeableConcept form,
        List<Errors> error) implements DomainResource {

    /**
     * Creates a {@code CoverageEligibilityResponse}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public CoverageEligibilityResponse {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        purpose = purpose == null ? List.of() : List.copyOf(purpose);
        event = event == null ? List.of() : List.copyOf(event);
        insurance = insurance == null ? List.of() : List.copyOf(insurance);
        error = error == null ? List.of() : List.copyOf(error);
        Objects.requireNonNull(status, "CoverageEligibilityResponse.status is required");
        if (purpose.isEmpty()) {
            throw new IllegalArgumentException("CoverageEligibilityResponse.purpose requires at least one value");
        }
        Objects.requireNonNull(patient, "CoverageEligibilityResponse.patient is required");
        Objects.requireNonNull(created, "CoverageEligibilityResponse.created is required");
        Objects.requireNonNull(request, "CoverageEligibilityResponse.request is required");
        Objects.requireNonNull(outcome, "CoverageEligibilityResponse.outcome is required");
        Objects.requireNonNull(insurer, "CoverageEligibilityResponse.insurer is required");
        if (serviced != null && !(serviced instanceof FhirDate || serviced instanceof Period)) {
            throw new IllegalArgumentException(
                    "CoverageEligibilityResponse.serviced[x] must be one of date, Period, but was "
                            + serviced.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code CoverageEligibilityResponse}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Information code for an event with a corresponding date or period.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Specific event. Required.
     * @param when Occurance date or period. One of dateTime, Period. Required.
     */
    public record Event(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType when) implements BackboneElement {

        /**
         * Creates an {@code Event}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Event {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "CoverageEligibilityResponse.event.type is required");
            Objects.requireNonNull(when, "CoverageEligibilityResponse.event.when is required");
            if (when != null && !(when instanceof FhirDateTime || when instanceof Period)) {
                throw new IllegalArgumentException(
                        "CoverageEligibilityResponse.event.when[x] must be one of dateTime, Period, but was "
                                + when.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Event}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Event}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private DataType when;

            private Builder() {
            }

            private Builder(Event original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.when = original.when();
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
             * Sets {@code when} to a dateTime.
             *
             * @param when the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder when(FhirDateTime when) {
                this.when = when;
                return this;
            }

            /**
             * Sets {@code when} to a Period.
             *
             * @param when the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder when(Period when) {
                this.when = when;
                return this;
            }

            /**
             * Sets {@code when} to a dateTime without id or extensions.
             *
             * @param when the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder when(Temporal when) {
                this.when = when == null ? null : FhirDateTime.of(when);
                return this;
            }

            /**
             * Builds the {@code Event}.
             *
             * @return the {@code Event}
             * @throws NullPointerException if a required element is absent
             */
            public Event build() {
                return new Event(
                        id, extension, modifierExtension, type, when);
            }
        }
    }

    /**
     * Financial instruments for reimbursement for the health care products and services.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param coverage Insurance information. Reference to Coverage. Required.
     * @param inforce Coverage inforce indicator.
     * @param benefitPeriod When the benefits are applicable.
     * @param item Benefits and authorization details.
     */
    public record Insurance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference coverage,
            FhirBoolean inforce,
            Period benefitPeriod,
            List<Items> item) implements BackboneElement {

        /**
         * Creates an {@code Insurance}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Insurance {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            item = item == null ? List.of() : List.copyOf(item);
            Objects.requireNonNull(coverage, "CoverageEligibilityResponse.insurance.coverage is required");
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
         * Returns a builder initialized with the values of this {@code Insurance}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Benefits and optionally current balances, and authorization details by category or service.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param category Benefit classification.
         * @param productOrService Billing, service, product, or drug code.
         * @param modifier Product or service billing modifiers.
         * @param provider Performing practitioner. Reference to Practitioner, PractitionerRole.
         * @param excluded Excluded from the plan.
         * @param name Short name for the benefit.
         * @param description Description of the benefit or services covered.
         * @param network In or out of network.
         * @param unit Individual or family.
         * @param term Annual or lifetime.
         * @param benefit Benefit Summary.
         * @param authorizationRequired Authorization required flag.
         * @param authorizationSupporting Type of required supporting materials.
         * @param authorizationUrl Preauthorization requirements endpoint.
         */
        public record Items(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept category,
                CodeableConcept productOrService,
                List<CodeableConcept> modifier,
                Reference provider,
                FhirBoolean excluded,
                FhirString name,
                FhirString description,
                CodeableConcept network,
                CodeableConcept unit,
                CodeableConcept term,
                List<Benefit> benefit,
                FhirBoolean authorizationRequired,
                List<CodeableConcept> authorizationSupporting,
                FhirUri authorizationUrl) implements BackboneElement {

            /**
             * Creates an {@code Items}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Items {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                modifier = modifier == null ? List.of() : List.copyOf(modifier);
                benefit = benefit == null ? List.of() : List.copyOf(benefit);
                authorizationSupporting =
                        authorizationSupporting == null ? List.of() : List.copyOf(authorizationSupporting);
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
             * Returns a builder initialized with the values of this {@code Items}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Benefits used to date.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param type Benefit classification. Required.
             * @param allowed Benefits allowed. One of unsignedInt, string, Money.
             * @param used Benefits used. One of unsignedInt, string, Money.
             */
            public record Benefit(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    CodeableConcept type,
                    DataType allowed,
                    DataType used) implements BackboneElement {

                /**
                 * Creates a {@code Benefit}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 * @throws IllegalArgumentException if a choice element has a type that is not allowed
                 */
                public Benefit {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(
                            type, "CoverageEligibilityResponse.insurance.item.benefit.type is required");
                    if (allowed != null && !(allowed instanceof FhirUnsignedInt
                            || allowed instanceof FhirString
                            || allowed instanceof Money)) {
                        throw new IllegalArgumentException(
                                "CoverageEligibilityResponse.insurance.item.benefit.allowed[x] does not allow "
                                        + allowed.getClass().getSimpleName());
                    }
                    if (used != null && !(used instanceof FhirUnsignedInt
                            || used instanceof FhirString
                            || used instanceof Money)) {
                        throw new IllegalArgumentException(
                                "CoverageEligibilityResponse.insurance.item.benefit.used[x] does not allow "
                                        + used.getClass().getSimpleName());
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
                 * Returns a builder initialized with the values of this {@code Benefit}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link Benefit}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private CodeableConcept type;
                    private DataType allowed;
                    private DataType used;

                    private Builder() {
                    }

                    private Builder(Benefit original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.type = original.type();
                        this.allowed = original.allowed();
                        this.used = original.used();
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
                     * Sets {@code allowed} to a unsignedInt.
                     *
                     * @param allowed the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder allowed(FhirUnsignedInt allowed) {
                        this.allowed = allowed;
                        return this;
                    }

                    /**
                     * Sets {@code allowed} to a string.
                     *
                     * @param allowed the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder allowed(FhirString allowed) {
                        this.allowed = allowed;
                        return this;
                    }

                    /**
                     * Sets {@code allowed} to a Money.
                     *
                     * @param allowed the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder allowed(Money allowed) {
                        this.allowed = allowed;
                        return this;
                    }

                    /**
                     * Sets {@code allowed} to a unsignedInt without id or extensions.
                     *
                     * @param allowed the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder allowed(Integer allowed) {
                        this.allowed = allowed == null ? null : FhirUnsignedInt.of(allowed);
                        return this;
                    }

                    /**
                     * Sets {@code allowed} to a string without id or extensions.
                     *
                     * @param allowed the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder allowed(String allowed) {
                        this.allowed = allowed == null ? null : FhirString.of(allowed);
                        return this;
                    }

                    /**
                     * Sets {@code used} to a unsignedInt.
                     *
                     * @param used the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder used(FhirUnsignedInt used) {
                        this.used = used;
                        return this;
                    }

                    /**
                     * Sets {@code used} to a string.
                     *
                     * @param used the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder used(FhirString used) {
                        this.used = used;
                        return this;
                    }

                    /**
                     * Sets {@code used} to a Money.
                     *
                     * @param used the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder used(Money used) {
                        this.used = used;
                        return this;
                    }

                    /**
                     * Sets {@code used} to a unsignedInt without id or extensions.
                     *
                     * @param used the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder used(Integer used) {
                        this.used = used == null ? null : FhirUnsignedInt.of(used);
                        return this;
                    }

                    /**
                     * Sets {@code used} to a string without id or extensions.
                     *
                     * @param used the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder used(String used) {
                        this.used = used == null ? null : FhirString.of(used);
                        return this;
                    }

                    /**
                     * Builds the {@code Benefit}.
                     *
                     * @return the {@code Benefit}
                     * @throws NullPointerException if a required element is absent
                     */
                    public Benefit build() {
                        return new Benefit(
                                id, extension, modifierExtension, type, allowed, used);
                    }
                }
            }

            /** Builder for {@link Items}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept category;
                private CodeableConcept productOrService;
                private List<CodeableConcept> modifier = new ArrayList<>();
                private Reference provider;
                private FhirBoolean excluded;
                private FhirString name;
                private FhirString description;
                private CodeableConcept network;
                private CodeableConcept unit;
                private CodeableConcept term;
                private List<Benefit> benefit = new ArrayList<>();
                private FhirBoolean authorizationRequired;
                private List<CodeableConcept> authorizationSupporting = new ArrayList<>();
                private FhirUri authorizationUrl;

                private Builder() {
                }

                private Builder(Items original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.category = original.category();
                    this.productOrService = original.productOrService();
                    this.modifier = new ArrayList<>(original.modifier());
                    this.provider = original.provider();
                    this.excluded = original.excluded();
                    this.name = original.name();
                    this.description = original.description();
                    this.network = original.network();
                    this.unit = original.unit();
                    this.term = original.term();
                    this.benefit = new ArrayList<>(original.benefit());
                    this.authorizationRequired = original.authorizationRequired();
                    this.authorizationSupporting = new ArrayList<>(original.authorizationSupporting());
                    this.authorizationUrl = original.authorizationUrl();
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
                 * Sets {@code category}.
                 *
                 * @param category the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder category(CodeableConcept category) {
                    this.category = category;
                    return this;
                }

                /**
                 * Sets {@code productOrService}.
                 *
                 * @param productOrService the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder productOrService(CodeableConcept productOrService) {
                    this.productOrService = productOrService;
                    return this;
                }

                /**
                 * Replaces all {@code modifier} values.
                 *
                 * @param modifier the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder modifier(List<CodeableConcept> modifier) {
                    this.modifier = modifier == null ? new ArrayList<>() : new ArrayList<>(modifier);
                    return this;
                }

                /**
                 * Adds a {@code modifier} value.
                 *
                 * @param modifier the value to add
                 * @return this builder
                 */
                public Builder addModifier(CodeableConcept modifier) {
                    this.modifier.add(Objects.requireNonNull(modifier, "modifier"));
                    return this;
                }

                /**
                 * Sets {@code provider}.
                 *
                 * @param provider the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder provider(Reference provider) {
                    this.provider = provider;
                    return this;
                }

                /**
                 * Sets {@code excluded}.
                 *
                 * @param excluded the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder excluded(FhirBoolean excluded) {
                    this.excluded = excluded;
                    return this;
                }

                /**
                 * Sets {@code excluded}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param excluded the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder excluded(Boolean excluded) {
                    return excluded(excluded == null ? null : FhirBoolean.of(excluded));
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
                 * Sets {@code description}.
                 *
                 * @param description the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder description(FhirString description) {
                    this.description = description;
                    return this;
                }

                /**
                 * Sets {@code description}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param description the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder description(String description) {
                    return description(description == null ? null : FhirString.of(description));
                }

                /**
                 * Sets {@code network}.
                 *
                 * @param network the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder network(CodeableConcept network) {
                    this.network = network;
                    return this;
                }

                /**
                 * Sets {@code unit}.
                 *
                 * @param unit the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder unit(CodeableConcept unit) {
                    this.unit = unit;
                    return this;
                }

                /**
                 * Sets {@code term}.
                 *
                 * @param term the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder term(CodeableConcept term) {
                    this.term = term;
                    return this;
                }

                /**
                 * Replaces all {@code benefit} values.
                 *
                 * @param benefit the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder benefit(List<Benefit> benefit) {
                    this.benefit = benefit == null ? new ArrayList<>() : new ArrayList<>(benefit);
                    return this;
                }

                /**
                 * Adds a {@code benefit} value.
                 *
                 * @param benefit the value to add
                 * @return this builder
                 */
                public Builder addBenefit(Benefit benefit) {
                    this.benefit.add(Objects.requireNonNull(benefit, "benefit"));
                    return this;
                }

                /**
                 * Sets {@code authorizationRequired}.
                 *
                 * @param authorizationRequired the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder authorizationRequired(FhirBoolean authorizationRequired) {
                    this.authorizationRequired = authorizationRequired;
                    return this;
                }

                /**
                 * Sets {@code authorizationRequired}, wrapped in a {@link FhirBoolean} without id or extensions.
                 *
                 * @param authorizationRequired the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder authorizationRequired(Boolean authorizationRequired) {
                    return authorizationRequired(
                            authorizationRequired == null ? null : FhirBoolean.of(authorizationRequired));
                }

                /**
                 * Replaces all {@code authorizationSupporting} values.
                 *
                 * @param authorizationSupporting the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder authorizationSupporting(List<CodeableConcept> authorizationSupporting) {
                    this.authorizationSupporting = authorizationSupporting == null
                            ? new ArrayList<>()
                            : new ArrayList<>(authorizationSupporting);
                    return this;
                }

                /**
                 * Adds a {@code authorizationSupporting} value.
                 *
                 * @param authorizationSupporting the value to add
                 * @return this builder
                 */
                public Builder addAuthorizationSupporting(CodeableConcept authorizationSupporting) {
                    this.authorizationSupporting.add(
                            Objects.requireNonNull(authorizationSupporting, "authorizationSupporting"));
                    return this;
                }

                /**
                 * Sets {@code authorizationUrl}.
                 *
                 * @param authorizationUrl the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder authorizationUrl(FhirUri authorizationUrl) {
                    this.authorizationUrl = authorizationUrl;
                    return this;
                }

                /**
                 * Sets {@code authorizationUrl}, wrapped in a {@link FhirUri} without id or extensions.
                 *
                 * @param authorizationUrl the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder authorizationUrl(String authorizationUrl) {
                    return authorizationUrl(authorizationUrl == null ? null : FhirUri.of(authorizationUrl));
                }

                /**
                 * Builds the {@code Items}.
                 *
                 * @return the {@code Items}
                 */
                public Items build() {
                    return new Items(
                            id, extension, modifierExtension, category, productOrService, modifier, provider,
                            excluded, name, description, network, unit, term, benefit, authorizationRequired,
                            authorizationSupporting, authorizationUrl);
                }
            }
        }

        /** Builder for {@link Insurance}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference coverage;
            private FhirBoolean inforce;
            private Period benefitPeriod;
            private List<Items> item = new ArrayList<>();

            private Builder() {
            }

            private Builder(Insurance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.coverage = original.coverage();
                this.inforce = original.inforce();
                this.benefitPeriod = original.benefitPeriod();
                this.item = new ArrayList<>(original.item());
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
             * Sets {@code coverage}.
             *
             * @param coverage the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder coverage(Reference coverage) {
                this.coverage = coverage;
                return this;
            }

            /**
             * Sets {@code inforce}.
             *
             * @param inforce the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder inforce(FhirBoolean inforce) {
                this.inforce = inforce;
                return this;
            }

            /**
             * Sets {@code inforce}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param inforce the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder inforce(Boolean inforce) {
                return inforce(inforce == null ? null : FhirBoolean.of(inforce));
            }

            /**
             * Sets {@code benefitPeriod}.
             *
             * @param benefitPeriod the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder benefitPeriod(Period benefitPeriod) {
                this.benefitPeriod = benefitPeriod;
                return this;
            }

            /**
             * Replaces all {@code item} values.
             *
             * @param item the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder item(List<Items> item) {
                this.item = item == null ? new ArrayList<>() : new ArrayList<>(item);
                return this;
            }

            /**
             * Adds a {@code item} value.
             *
             * @param item the value to add
             * @return this builder
             */
            public Builder addItem(Items item) {
                this.item.add(Objects.requireNonNull(item, "item"));
                return this;
            }

            /**
             * Builds the {@code Insurance}.
             *
             * @return the {@code Insurance}
             * @throws NullPointerException if a required element is absent
             */
            public Insurance build() {
                return new Insurance(
                        id, extension, modifierExtension, coverage, inforce, benefitPeriod, item);
            }
        }
    }

    /**
     * Errors encountered during the processing of the request.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Error code detailing processing issues. Required.
     * @param expression FHIRPath of element(s) related to issue.
     */
    public record Errors(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            List<FhirString> expression) implements BackboneElement {

        /**
         * Creates an {@code Errors}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Errors {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            expression = expression == null ? List.of() : List.copyOf(expression);
            Objects.requireNonNull(code, "CoverageEligibilityResponse.error.code is required");
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
         * Returns a builder initialized with the values of this {@code Errors}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Errors}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private List<FhirString> expression = new ArrayList<>();

            private Builder() {
            }

            private Builder(Errors original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.expression = new ArrayList<>(original.expression());
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
             * Replaces all {@code expression} values.
             *
             * @param expression the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder expression(List<FhirString> expression) {
                this.expression = expression == null ? new ArrayList<>() : new ArrayList<>(expression);
                return this;
            }

            /**
             * Adds a {@code expression} value.
             *
             * @param expression the value to add
             * @return this builder
             */
            public Builder addExpression(FhirString expression) {
                this.expression.add(Objects.requireNonNull(expression, "expression"));
                return this;
            }

            /**
             * Adds a {@code expression} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param expression the value to add
             * @return this builder
             */
            public Builder addExpression(String expression) {
                return addExpression(FhirString.of(expression));
            }

            /**
             * Builds the {@code Errors}.
             *
             * @return the {@code Errors}
             * @throws NullPointerException if a required element is absent
             */
            public Errors build() {
                return new Errors(
                        id, extension, modifierExtension, code, expression);
            }
        }
    }

    /** Builder for {@link CoverageEligibilityResponse}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<FinancialResourceStatusCodes> status;
        private List<FhirEnum<EligibilityResponsePurpose>> purpose = new ArrayList<>();
        private Reference patient;
        private List<Event> event = new ArrayList<>();
        private DataType serviced;
        private FhirDateTime created;
        private Reference requestor;
        private Reference request;
        private FhirEnum<EligibilityOutcome> outcome;
        private FhirString disposition;
        private Reference insurer;
        private List<Insurance> insurance = new ArrayList<>();
        private FhirString preAuthRef;
        private CodeableConcept form;
        private List<Errors> error = new ArrayList<>();

        private Builder() {
        }

        private Builder(CoverageEligibilityResponse original) {
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
            this.purpose = new ArrayList<>(original.purpose());
            this.patient = original.patient();
            this.event = new ArrayList<>(original.event());
            this.serviced = original.serviced();
            this.created = original.created();
            this.requestor = original.requestor();
            this.request = original.request();
            this.outcome = original.outcome();
            this.disposition = original.disposition();
            this.insurer = original.insurer();
            this.insurance = new ArrayList<>(original.insurance());
            this.preAuthRef = original.preAuthRef();
            this.form = original.form();
            this.error = new ArrayList<>(original.error());
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
        public Builder status(FhirEnum<FinancialResourceStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FinancialResourceStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Replaces all {@code purpose} values.
         *
         * @param purpose the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder purpose(List<FhirEnum<EligibilityResponsePurpose>> purpose) {
            this.purpose = purpose == null ? new ArrayList<>() : new ArrayList<>(purpose);
            return this;
        }

        /**
         * Adds a {@code purpose} value.
         *
         * @param purpose the value to add
         * @return this builder
         */
        public Builder addPurpose(FhirEnum<EligibilityResponsePurpose> purpose) {
            this.purpose.add(Objects.requireNonNull(purpose, "purpose"));
            return this;
        }

        /**
         * Adds a {@code purpose} value, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param purpose the value to add
         * @return this builder
         */
        public Builder addPurpose(EligibilityResponsePurpose purpose) {
            return addPurpose(FhirEnum.of(purpose));
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
         * Replaces all {@code event} values.
         *
         * @param event the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder event(List<Event> event) {
            this.event = event == null ? new ArrayList<>() : new ArrayList<>(event);
            return this;
        }

        /**
         * Adds a {@code event} value.
         *
         * @param event the value to add
         * @return this builder
         */
        public Builder addEvent(Event event) {
            this.event.add(Objects.requireNonNull(event, "event"));
            return this;
        }

        /**
         * Sets {@code serviced} to a date.
         *
         * @param serviced the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder serviced(FhirDate serviced) {
            this.serviced = serviced;
            return this;
        }

        /**
         * Sets {@code serviced} to a Period.
         *
         * @param serviced the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder serviced(Period serviced) {
            this.serviced = serviced;
            return this;
        }

        /**
         * Sets {@code serviced} to a date without id or extensions.
         *
         * @param serviced the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder serviced(Temporal serviced) {
            this.serviced = serviced == null ? null : FhirDate.of(serviced);
            return this;
        }

        /**
         * Sets {@code created}.
         *
         * @param created the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder created(FhirDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * Sets {@code created}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param created the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder created(Temporal created) {
            return created(created == null ? null : FhirDateTime.of(created));
        }

        /**
         * Sets {@code requestor}.
         *
         * @param requestor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requestor(Reference requestor) {
            this.requestor = requestor;
            return this;
        }

        /**
         * Sets {@code request}.
         *
         * @param request the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder request(Reference request) {
            this.request = request;
            return this;
        }

        /**
         * Sets {@code outcome}.
         *
         * @param outcome the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outcome(FhirEnum<EligibilityOutcome> outcome) {
            this.outcome = outcome;
            return this;
        }

        /**
         * Sets {@code outcome}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param outcome the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outcome(EligibilityOutcome outcome) {
            return outcome(outcome == null ? null : FhirEnum.of(outcome));
        }

        /**
         * Sets {@code disposition}.
         *
         * @param disposition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder disposition(FhirString disposition) {
            this.disposition = disposition;
            return this;
        }

        /**
         * Sets {@code disposition}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param disposition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder disposition(String disposition) {
            return disposition(disposition == null ? null : FhirString.of(disposition));
        }

        /**
         * Sets {@code insurer}.
         *
         * @param insurer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder insurer(Reference insurer) {
            this.insurer = insurer;
            return this;
        }

        /**
         * Replaces all {@code insurance} values.
         *
         * @param insurance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder insurance(List<Insurance> insurance) {
            this.insurance = insurance == null ? new ArrayList<>() : new ArrayList<>(insurance);
            return this;
        }

        /**
         * Adds a {@code insurance} value.
         *
         * @param insurance the value to add
         * @return this builder
         */
        public Builder addInsurance(Insurance insurance) {
            this.insurance.add(Objects.requireNonNull(insurance, "insurance"));
            return this;
        }

        /**
         * Sets {@code preAuthRef}.
         *
         * @param preAuthRef the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preAuthRef(FhirString preAuthRef) {
            this.preAuthRef = preAuthRef;
            return this;
        }

        /**
         * Sets {@code preAuthRef}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param preAuthRef the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preAuthRef(String preAuthRef) {
            return preAuthRef(preAuthRef == null ? null : FhirString.of(preAuthRef));
        }

        /**
         * Sets {@code form}.
         *
         * @param form the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder form(CodeableConcept form) {
            this.form = form;
            return this;
        }

        /**
         * Replaces all {@code error} values.
         *
         * @param error the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder error(List<Errors> error) {
            this.error = error == null ? new ArrayList<>() : new ArrayList<>(error);
            return this;
        }

        /**
         * Adds a {@code error} value.
         *
         * @param error the value to add
         * @return this builder
         */
        public Builder addError(Errors error) {
            this.error.add(Objects.requireNonNull(error, "error"));
            return this;
        }

        /**
         * Builds the {@code CoverageEligibilityResponse}.
         *
         * @return the {@code CoverageEligibilityResponse}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public CoverageEligibilityResponse build() {
            return new CoverageEligibilityResponse(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, purpose, patient, event, serviced, created, requestor, request, outcome, disposition,
                    insurer, insurance, preAuthRef, form, error);
        }
    }
}
