package se.poroli.fhirplace.r5.account;

import java.time.OffsetDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * A financial tool for tracking value accrued for a particular purpose.
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
 * @param identifier Account number.
 * @param status active | inactive | entered-in-error | on-hold | unknown. Required. Modifier element.
 * @param billingStatus Tracks the lifecycle of the account through the billing process.
 * @param type E.g. patient, expense, depreciation.
 * @param name Human-readable label.
 * @param subject The entity that caused the expenses. Reference to Patient, Device, Practitioner, PractitionerRole,
 *   Location, HealthcareService, Organization.
 * @param servicePeriod Transaction window.
 * @param coverage The party(s) that are responsible for covering the payment of this account, and what order should
 *   they be applied to the account.
 * @param owner Entity managing the Account. Reference to Organization.
 * @param description Explanation of purpose/use.
 * @param guarantor The parties ultimately responsible for balancing the Account.
 * @param diagnosis The list of diagnoses relevant to this account.
 * @param procedure The list of procedures relevant to this account.
 * @param relatedAccount Other associated accounts related to this account.
 * @param currency The base or default currency.
 * @param balance Calculated account balance(s).
 * @param calculatedAt Time the balance amount was calculated.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Account">FHIR R5 Account</a>
 */
public record Account(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<AccountStatus> status,
        CodeableConcept billingStatus,
        CodeableConcept type,
        FhirString name,
        List<Reference> subject,
        Period servicePeriod,
        List<Coverage> coverage,
        Reference owner,
        FhirMarkdown description,
        List<Guarantor> guarantor,
        List<Diagnosis> diagnosis,
        List<Procedure> procedure,
        List<RelatedAccount> relatedAccount,
        CodeableConcept currency,
        List<Balance> balance,
        FhirInstant calculatedAt) implements DomainResource {

    /**
     * Creates an {@code Account}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Account {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        subject = subject == null ? List.of() : List.copyOf(subject);
        coverage = coverage == null ? List.of() : List.copyOf(coverage);
        guarantor = guarantor == null ? List.of() : List.copyOf(guarantor);
        diagnosis = diagnosis == null ? List.of() : List.copyOf(diagnosis);
        procedure = procedure == null ? List.of() : List.copyOf(procedure);
        relatedAccount = relatedAccount == null ? List.of() : List.copyOf(relatedAccount);
        balance = balance == null ? List.of() : List.copyOf(balance);
        Objects.requireNonNull(status, "Account.status is required");
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
     * Returns a builder initialized with the values of this {@code Account}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The party(s) that are responsible for covering the payment of this account, and what order should they be
     * applied to the account.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param coverage The party(s), such as insurances, that may contribute to the payment of this account. Reference
     *   to Coverage. Required.
     * @param priority The priority of the coverage in the context of this account.
     */
    public record Coverage(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference coverage,
            FhirPositiveInt priority) implements BackboneElement {

        /**
         * Creates a {@code Coverage}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Coverage {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(coverage, "Account.coverage.coverage is required");
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
         * Returns a builder initialized with the values of this {@code Coverage}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Coverage}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference coverage;
            private FhirPositiveInt priority;

            private Builder() {
            }

            private Builder(Coverage original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.coverage = original.coverage();
                this.priority = original.priority();
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
             * Sets {@code priority}.
             *
             * @param priority the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder priority(FhirPositiveInt priority) {
                this.priority = priority;
                return this;
            }

            /**
             * Sets {@code priority}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param priority the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder priority(Integer priority) {
                return priority(priority == null ? null : FhirPositiveInt.of(priority));
            }

            /**
             * Builds the {@code Coverage}.
             *
             * @return the {@code Coverage}
             * @throws NullPointerException if a required element is absent
             */
            public Coverage build() {
                return new Coverage(
                        id, extension, modifierExtension, coverage, priority);
            }
        }
    }

    /**
     * The parties responsible for balancing the account if other payment options fall short.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param party Responsible entity. Reference to Patient, RelatedPerson, Organization. Required.
     * @param onHold Credit or other hold applied.
     * @param period Guarantee account during.
     */
    public record Guarantor(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference party,
            FhirBoolean onHold,
            Period period) implements BackboneElement {

        /**
         * Creates a {@code Guarantor}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Guarantor {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(party, "Account.guarantor.party is required");
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
         * Returns a builder initialized with the values of this {@code Guarantor}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Guarantor}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference party;
            private FhirBoolean onHold;
            private Period period;

            private Builder() {
            }

            private Builder(Guarantor original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.party = original.party();
                this.onHold = original.onHold();
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
             * Sets {@code onHold}.
             *
             * @param onHold the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder onHold(FhirBoolean onHold) {
                this.onHold = onHold;
                return this;
            }

            /**
             * Sets {@code onHold}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param onHold the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder onHold(Boolean onHold) {
                return onHold(onHold == null ? null : FhirBoolean.of(onHold));
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
             * Builds the {@code Guarantor}.
             *
             * @return the {@code Guarantor}
             * @throws NullPointerException if a required element is absent
             */
            public Guarantor build() {
                return new Guarantor(
                        id, extension, modifierExtension, party, onHold, period);
            }
        }
    }

    /**
     * When using an account for billing a specific Encounter the set of diagnoses that are relevant for billing are
     * stored here on the account where they are able to be sequenced appropriately prior to processing to produce
     * claim(s).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param sequence Ranking of the diagnosis (for each type).
     * @param condition The diagnosis relevant to the account. Required.
     * @param dateOfDiagnosis Date of the diagnosis (when coded diagnosis).
     * @param type Type that this diagnosis has relevant to the account (e.g. admission, billing, discharge …).
     * @param onAdmission Diagnosis present on Admission.
     * @param packageCode Package Code specific for billing.
     */
    public record Diagnosis(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            CodeableReference condition,
            FhirDateTime dateOfDiagnosis,
            List<CodeableConcept> type,
            FhirBoolean onAdmission,
            List<CodeableConcept> packageCode) implements BackboneElement {

        /**
         * Creates a {@code Diagnosis}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Diagnosis {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            type = type == null ? List.of() : List.copyOf(type);
            packageCode = packageCode == null ? List.of() : List.copyOf(packageCode);
            Objects.requireNonNull(condition, "Account.diagnosis.condition is required");
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
         * Returns a builder initialized with the values of this {@code Diagnosis}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Diagnosis}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt sequence;
            private CodeableReference condition;
            private FhirDateTime dateOfDiagnosis;
            private List<CodeableConcept> type = new ArrayList<>();
            private FhirBoolean onAdmission;
            private List<CodeableConcept> packageCode = new ArrayList<>();

            private Builder() {
            }

            private Builder(Diagnosis original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.condition = original.condition();
                this.dateOfDiagnosis = original.dateOfDiagnosis();
                this.type = new ArrayList<>(original.type());
                this.onAdmission = original.onAdmission();
                this.packageCode = new ArrayList<>(original.packageCode());
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
             * Sets {@code sequence}.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(FhirPositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Sets {@code sequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(Integer sequence) {
                return sequence(sequence == null ? null : FhirPositiveInt.of(sequence));
            }

            /**
             * Sets {@code condition}.
             *
             * @param condition the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder condition(CodeableReference condition) {
                this.condition = condition;
                return this;
            }

            /**
             * Sets {@code dateOfDiagnosis}.
             *
             * @param dateOfDiagnosis the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dateOfDiagnosis(FhirDateTime dateOfDiagnosis) {
                this.dateOfDiagnosis = dateOfDiagnosis;
                return this;
            }

            /**
             * Sets {@code dateOfDiagnosis}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param dateOfDiagnosis the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dateOfDiagnosis(Temporal dateOfDiagnosis) {
                return dateOfDiagnosis(dateOfDiagnosis == null ? null : FhirDateTime.of(dateOfDiagnosis));
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
             * Sets {@code onAdmission}.
             *
             * @param onAdmission the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder onAdmission(FhirBoolean onAdmission) {
                this.onAdmission = onAdmission;
                return this;
            }

            /**
             * Sets {@code onAdmission}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param onAdmission the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder onAdmission(Boolean onAdmission) {
                return onAdmission(onAdmission == null ? null : FhirBoolean.of(onAdmission));
            }

            /**
             * Replaces all {@code packageCode} values.
             *
             * @param packageCode the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder packageCode(List<CodeableConcept> packageCode) {
                this.packageCode = packageCode == null ? new ArrayList<>() : new ArrayList<>(packageCode);
                return this;
            }

            /**
             * Adds a {@code packageCode} value.
             *
             * @param packageCode the value to add
             * @return this builder
             */
            public Builder addPackageCode(CodeableConcept packageCode) {
                this.packageCode.add(Objects.requireNonNull(packageCode, "packageCode"));
                return this;
            }

            /**
             * Builds the {@code Diagnosis}.
             *
             * @return the {@code Diagnosis}
             * @throws NullPointerException if a required element is absent
             */
            public Diagnosis build() {
                return new Diagnosis(
                        id, extension, modifierExtension, sequence, condition, dateOfDiagnosis, type, onAdmission,
                        packageCode);
            }
        }
    }

    /**
     * When using an account for billing a specific Encounter the set of procedures that are relevant for billing are
     * stored here on the account where they are able to be sequenced appropriately prior to processing to produce
     * claim(s).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param sequence Ranking of the procedure (for each type).
     * @param code The procedure relevant to the account. Required.
     * @param dateOfService Date of the procedure (when coded procedure).
     * @param type How this procedure value should be used in charging the account.
     * @param packageCode Package Code specific for billing.
     * @param device Any devices that were associated with the procedure. Reference to Device.
     */
    public record Procedure(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            CodeableReference code,
            FhirDateTime dateOfService,
            List<CodeableConcept> type,
            List<CodeableConcept> packageCode,
            List<Reference> device) implements BackboneElement {

        /**
         * Creates a {@code Procedure}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Procedure {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            type = type == null ? List.of() : List.copyOf(type);
            packageCode = packageCode == null ? List.of() : List.copyOf(packageCode);
            device = device == null ? List.of() : List.copyOf(device);
            Objects.requireNonNull(code, "Account.procedure.code is required");
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
         * Returns a builder initialized with the values of this {@code Procedure}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Procedure}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt sequence;
            private CodeableReference code;
            private FhirDateTime dateOfService;
            private List<CodeableConcept> type = new ArrayList<>();
            private List<CodeableConcept> packageCode = new ArrayList<>();
            private List<Reference> device = new ArrayList<>();

            private Builder() {
            }

            private Builder(Procedure original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.code = original.code();
                this.dateOfService = original.dateOfService();
                this.type = new ArrayList<>(original.type());
                this.packageCode = new ArrayList<>(original.packageCode());
                this.device = new ArrayList<>(original.device());
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
             * Sets {@code sequence}.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(FhirPositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Sets {@code sequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(Integer sequence) {
                return sequence(sequence == null ? null : FhirPositiveInt.of(sequence));
            }

            /**
             * Sets {@code code}.
             *
             * @param code the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder code(CodeableReference code) {
                this.code = code;
                return this;
            }

            /**
             * Sets {@code dateOfService}.
             *
             * @param dateOfService the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dateOfService(FhirDateTime dateOfService) {
                this.dateOfService = dateOfService;
                return this;
            }

            /**
             * Sets {@code dateOfService}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param dateOfService the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dateOfService(Temporal dateOfService) {
                return dateOfService(dateOfService == null ? null : FhirDateTime.of(dateOfService));
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
             * Replaces all {@code packageCode} values.
             *
             * @param packageCode the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder packageCode(List<CodeableConcept> packageCode) {
                this.packageCode = packageCode == null ? new ArrayList<>() : new ArrayList<>(packageCode);
                return this;
            }

            /**
             * Adds a {@code packageCode} value.
             *
             * @param packageCode the value to add
             * @return this builder
             */
            public Builder addPackageCode(CodeableConcept packageCode) {
                this.packageCode.add(Objects.requireNonNull(packageCode, "packageCode"));
                return this;
            }

            /**
             * Replaces all {@code device} values.
             *
             * @param device the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder device(List<Reference> device) {
                this.device = device == null ? new ArrayList<>() : new ArrayList<>(device);
                return this;
            }

            /**
             * Adds a {@code device} value.
             *
             * @param device the value to add
             * @return this builder
             */
            public Builder addDevice(Reference device) {
                this.device.add(Objects.requireNonNull(device, "device"));
                return this;
            }

            /**
             * Builds the {@code Procedure}.
             *
             * @return the {@code Procedure}
             * @throws NullPointerException if a required element is absent
             */
            public Procedure build() {
                return new Procedure(
                        id, extension, modifierExtension, sequence, code, dateOfService, type, packageCode, device);
            }
        }
    }

    /**
     * Other associated accounts related to this account.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param relationship Relationship of the associated Account.
     * @param account Reference to an associated Account. Reference to Account. Required.
     */
    public record RelatedAccount(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept relationship,
            Reference account) implements BackboneElement {

        /**
         * Creates a {@code RelatedAccount}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public RelatedAccount {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(account, "Account.relatedAccount.account is required");
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
         * Returns a builder initialized with the values of this {@code RelatedAccount}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link RelatedAccount}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept relationship;
            private Reference account;

            private Builder() {
            }

            private Builder(RelatedAccount original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.relationship = original.relationship();
                this.account = original.account();
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
             * Sets {@code relationship}.
             *
             * @param relationship the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder relationship(CodeableConcept relationship) {
                this.relationship = relationship;
                return this;
            }

            /**
             * Sets {@code account}.
             *
             * @param account the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder account(Reference account) {
                this.account = account;
                return this;
            }

            /**
             * Builds the {@code RelatedAccount}.
             *
             * @return the {@code RelatedAccount}
             * @throws NullPointerException if a required element is absent
             */
            public RelatedAccount build() {
                return new RelatedAccount(
                        id, extension, modifierExtension, relationship, account);
            }
        }
    }

    /**
     * The calculated account balances - these are calculated and processed by the finance system.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param aggregate Who is expected to pay this part of the balance.
     * @param term current | 30 | 60 | 90 | 120.
     * @param estimate Estimated balance.
     * @param amount Calculated amount. Required.
     */
    public record Balance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept aggregate,
            CodeableConcept term,
            FhirBoolean estimate,
            Money amount) implements BackboneElement {

        /**
         * Creates a {@code Balance}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Balance {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(amount, "Account.balance.amount is required");
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
         * Returns a builder initialized with the values of this {@code Balance}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Balance}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept aggregate;
            private CodeableConcept term;
            private FhirBoolean estimate;
            private Money amount;

            private Builder() {
            }

            private Builder(Balance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.aggregate = original.aggregate();
                this.term = original.term();
                this.estimate = original.estimate();
                this.amount = original.amount();
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
             * Sets {@code aggregate}.
             *
             * @param aggregate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder aggregate(CodeableConcept aggregate) {
                this.aggregate = aggregate;
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
             * Sets {@code estimate}.
             *
             * @param estimate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder estimate(FhirBoolean estimate) {
                this.estimate = estimate;
                return this;
            }

            /**
             * Sets {@code estimate}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param estimate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder estimate(Boolean estimate) {
                return estimate(estimate == null ? null : FhirBoolean.of(estimate));
            }

            /**
             * Sets {@code amount}.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(Money amount) {
                this.amount = amount;
                return this;
            }

            /**
             * Builds the {@code Balance}.
             *
             * @return the {@code Balance}
             * @throws NullPointerException if a required element is absent
             */
            public Balance build() {
                return new Balance(
                        id, extension, modifierExtension, aggregate, term, estimate, amount);
            }
        }
    }

    /** Builder for {@link Account}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<AccountStatus> status;
        private CodeableConcept billingStatus;
        private CodeableConcept type;
        private FhirString name;
        private List<Reference> subject = new ArrayList<>();
        private Period servicePeriod;
        private List<Coverage> coverage = new ArrayList<>();
        private Reference owner;
        private FhirMarkdown description;
        private List<Guarantor> guarantor = new ArrayList<>();
        private List<Diagnosis> diagnosis = new ArrayList<>();
        private List<Procedure> procedure = new ArrayList<>();
        private List<RelatedAccount> relatedAccount = new ArrayList<>();
        private CodeableConcept currency;
        private List<Balance> balance = new ArrayList<>();
        private FhirInstant calculatedAt;

        private Builder() {
        }

        private Builder(Account original) {
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
            this.billingStatus = original.billingStatus();
            this.type = original.type();
            this.name = original.name();
            this.subject = new ArrayList<>(original.subject());
            this.servicePeriod = original.servicePeriod();
            this.coverage = new ArrayList<>(original.coverage());
            this.owner = original.owner();
            this.description = original.description();
            this.guarantor = new ArrayList<>(original.guarantor());
            this.diagnosis = new ArrayList<>(original.diagnosis());
            this.procedure = new ArrayList<>(original.procedure());
            this.relatedAccount = new ArrayList<>(original.relatedAccount());
            this.currency = original.currency();
            this.balance = new ArrayList<>(original.balance());
            this.calculatedAt = original.calculatedAt();
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
        public Builder status(FhirEnum<AccountStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(AccountStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code billingStatus}.
         *
         * @param billingStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder billingStatus(CodeableConcept billingStatus) {
            this.billingStatus = billingStatus;
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
         * Sets {@code servicePeriod}.
         *
         * @param servicePeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder servicePeriod(Period servicePeriod) {
            this.servicePeriod = servicePeriod;
            return this;
        }

        /**
         * Replaces all {@code coverage} values.
         *
         * @param coverage the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder coverage(List<Coverage> coverage) {
            this.coverage = coverage == null ? new ArrayList<>() : new ArrayList<>(coverage);
            return this;
        }

        /**
         * Adds a {@code coverage} value.
         *
         * @param coverage the value to add
         * @return this builder
         */
        public Builder addCoverage(Coverage coverage) {
            this.coverage.add(Objects.requireNonNull(coverage, "coverage"));
            return this;
        }

        /**
         * Sets {@code owner}.
         *
         * @param owner the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder owner(Reference owner) {
            this.owner = owner;
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
         * Replaces all {@code guarantor} values.
         *
         * @param guarantor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder guarantor(List<Guarantor> guarantor) {
            this.guarantor = guarantor == null ? new ArrayList<>() : new ArrayList<>(guarantor);
            return this;
        }

        /**
         * Adds a {@code guarantor} value.
         *
         * @param guarantor the value to add
         * @return this builder
         */
        public Builder addGuarantor(Guarantor guarantor) {
            this.guarantor.add(Objects.requireNonNull(guarantor, "guarantor"));
            return this;
        }

        /**
         * Replaces all {@code diagnosis} values.
         *
         * @param diagnosis the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder diagnosis(List<Diagnosis> diagnosis) {
            this.diagnosis = diagnosis == null ? new ArrayList<>() : new ArrayList<>(diagnosis);
            return this;
        }

        /**
         * Adds a {@code diagnosis} value.
         *
         * @param diagnosis the value to add
         * @return this builder
         */
        public Builder addDiagnosis(Diagnosis diagnosis) {
            this.diagnosis.add(Objects.requireNonNull(diagnosis, "diagnosis"));
            return this;
        }

        /**
         * Replaces all {@code procedure} values.
         *
         * @param procedure the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder procedure(List<Procedure> procedure) {
            this.procedure = procedure == null ? new ArrayList<>() : new ArrayList<>(procedure);
            return this;
        }

        /**
         * Adds a {@code procedure} value.
         *
         * @param procedure the value to add
         * @return this builder
         */
        public Builder addProcedure(Procedure procedure) {
            this.procedure.add(Objects.requireNonNull(procedure, "procedure"));
            return this;
        }

        /**
         * Replaces all {@code relatedAccount} values.
         *
         * @param relatedAccount the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relatedAccount(List<RelatedAccount> relatedAccount) {
            this.relatedAccount = relatedAccount == null ? new ArrayList<>() : new ArrayList<>(relatedAccount);
            return this;
        }

        /**
         * Adds a {@code relatedAccount} value.
         *
         * @param relatedAccount the value to add
         * @return this builder
         */
        public Builder addRelatedAccount(RelatedAccount relatedAccount) {
            this.relatedAccount.add(Objects.requireNonNull(relatedAccount, "relatedAccount"));
            return this;
        }

        /**
         * Sets {@code currency}.
         *
         * @param currency the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder currency(CodeableConcept currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Replaces all {@code balance} values.
         *
         * @param balance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder balance(List<Balance> balance) {
            this.balance = balance == null ? new ArrayList<>() : new ArrayList<>(balance);
            return this;
        }

        /**
         * Adds a {@code balance} value.
         *
         * @param balance the value to add
         * @return this builder
         */
        public Builder addBalance(Balance balance) {
            this.balance.add(Objects.requireNonNull(balance, "balance"));
            return this;
        }

        /**
         * Sets {@code calculatedAt}.
         *
         * @param calculatedAt the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder calculatedAt(FhirInstant calculatedAt) {
            this.calculatedAt = calculatedAt;
            return this;
        }

        /**
         * Sets {@code calculatedAt}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param calculatedAt the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder calculatedAt(OffsetDateTime calculatedAt) {
            return calculatedAt(calculatedAt == null ? null : FhirInstant.of(calculatedAt));
        }

        /**
         * Builds the {@code Account}.
         *
         * @return the {@code Account}
         * @throws NullPointerException if a required element is absent
         */
        public Account build() {
            return new Account(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, billingStatus, type, name, subject, servicePeriod, coverage, owner, description,
                    guarantor, diagnosis, procedure, relatedAccount, currency, balance, calculatedAt);
        }
    }
}
