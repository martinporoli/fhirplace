package se.poroli.fhirplace.r5.base.workflow;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.valuesets.VerificationResultStatus;

/**
 * Describes validation requirements, source(s), status and dates for one or more elements.
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
 * @param target A resource that was validated. Reference to Resource.
 * @param targetLocation The fhirpath location(s) within the resource that was validated.
 * @param need none | initial | periodic.
 * @param status attested | validated | in-process | req-revalid | val-fail | reval-fail | entered-in-error. Required.
 * @param statusDate When the validation status was updated.
 * @param validationType nothing | primary | multiple.
 * @param validationProcess The primary process by which the target is validated (edit check; value set; primary
 *   source; multiple sources; standalone; in context).
 * @param frequency Frequency of revalidation.
 * @param lastPerformed The date/time validation was last completed (including failed validations).
 * @param nextScheduled The date when target is next validated, if appropriate.
 * @param failureAction fatal | warn | rec-only | none.
 * @param primarySource Information about the primary source(s) involved in validation.
 * @param attestation Information about the entity attesting to information.
 * @param validator Information about the entity validating information.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/VerificationResult">FHIR R5 VerificationResult</a>
 */
public record VerificationResult(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Reference> target,
        List<FhirString> targetLocation,
        CodeableConcept need,
        FhirEnum<VerificationResultStatus> status,
        FhirDateTime statusDate,
        CodeableConcept validationType,
        List<CodeableConcept> validationProcess,
        Timing frequency,
        FhirDateTime lastPerformed,
        FhirDate nextScheduled,
        CodeableConcept failureAction,
        List<PrimarySource> primarySource,
        Attestation attestation,
        List<Validator> validator) implements DomainResource {

    /**
     * Creates a {@code VerificationResult}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public VerificationResult {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        target = target == null ? List.of() : List.copyOf(target);
        targetLocation = targetLocation == null ? List.of() : List.copyOf(targetLocation);
        validationProcess = validationProcess == null ? List.of() : List.copyOf(validationProcess);
        primarySource = primarySource == null ? List.of() : List.copyOf(primarySource);
        validator = validator == null ? List.of() : List.copyOf(validator);
        Objects.requireNonNull(status, "VerificationResult.status is required");
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
     * Returns a builder initialized with the values of this {@code VerificationResult}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Information about the primary source(s) involved in validation.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param who Reference to the primary source. Reference to Organization, Practitioner, PractitionerRole.
     * @param type Type of primary source (License Board; Primary Education; Continuing Education; Postal Service;
     *   Relationship owner; Registration Authority; legal source; issuing source; authoritative source).
     * @param communicationMethod Method for exchanging information with the primary source.
     * @param validationStatus successful | failed | unknown.
     * @param validationDate When the target was validated against the primary source.
     * @param canPushUpdates yes | no | undetermined.
     * @param pushTypeAvailable specific | any | source.
     */
    public record PrimarySource(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference who,
            List<CodeableConcept> type,
            List<CodeableConcept> communicationMethod,
            CodeableConcept validationStatus,
            FhirDateTime validationDate,
            CodeableConcept canPushUpdates,
            List<CodeableConcept> pushTypeAvailable) implements BackboneElement {

        /**
         * Creates a {@code PrimarySource}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public PrimarySource {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            type = type == null ? List.of() : List.copyOf(type);
            communicationMethod = communicationMethod == null ? List.of() : List.copyOf(communicationMethod);
            pushTypeAvailable = pushTypeAvailable == null ? List.of() : List.copyOf(pushTypeAvailable);
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
         * Returns a builder initialized with the values of this {@code PrimarySource}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link PrimarySource}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference who;
            private List<CodeableConcept> type = new ArrayList<>();
            private List<CodeableConcept> communicationMethod = new ArrayList<>();
            private CodeableConcept validationStatus;
            private FhirDateTime validationDate;
            private CodeableConcept canPushUpdates;
            private List<CodeableConcept> pushTypeAvailable = new ArrayList<>();

            private Builder() {
            }

            private Builder(PrimarySource original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.who = original.who();
                this.type = new ArrayList<>(original.type());
                this.communicationMethod = new ArrayList<>(original.communicationMethod());
                this.validationStatus = original.validationStatus();
                this.validationDate = original.validationDate();
                this.canPushUpdates = original.canPushUpdates();
                this.pushTypeAvailable = new ArrayList<>(original.pushTypeAvailable());
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
             * Sets {@code who}.
             *
             * @param who the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder who(Reference who) {
                this.who = who;
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
             * Replaces all {@code communicationMethod} values.
             *
             * @param communicationMethod the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder communicationMethod(List<CodeableConcept> communicationMethod) {
                this.communicationMethod = communicationMethod == null
                        ? new ArrayList<>()
                        : new ArrayList<>(communicationMethod);
                return this;
            }

            /**
             * Adds a {@code communicationMethod} value.
             *
             * @param communicationMethod the value to add
             * @return this builder
             */
            public Builder addCommunicationMethod(CodeableConcept communicationMethod) {
                this.communicationMethod.add(Objects.requireNonNull(communicationMethod, "communicationMethod"));
                return this;
            }

            /**
             * Sets {@code validationStatus}.
             *
             * @param validationStatus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder validationStatus(CodeableConcept validationStatus) {
                this.validationStatus = validationStatus;
                return this;
            }

            /**
             * Sets {@code validationDate}.
             *
             * @param validationDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder validationDate(FhirDateTime validationDate) {
                this.validationDate = validationDate;
                return this;
            }

            /**
             * Sets {@code validationDate}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param validationDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder validationDate(Temporal validationDate) {
                return validationDate(validationDate == null ? null : FhirDateTime.of(validationDate));
            }

            /**
             * Sets {@code canPushUpdates}.
             *
             * @param canPushUpdates the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder canPushUpdates(CodeableConcept canPushUpdates) {
                this.canPushUpdates = canPushUpdates;
                return this;
            }

            /**
             * Replaces all {@code pushTypeAvailable} values.
             *
             * @param pushTypeAvailable the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder pushTypeAvailable(List<CodeableConcept> pushTypeAvailable) {
                this.pushTypeAvailable = pushTypeAvailable == null
                        ? new ArrayList<>()
                        : new ArrayList<>(pushTypeAvailable);
                return this;
            }

            /**
             * Adds a {@code pushTypeAvailable} value.
             *
             * @param pushTypeAvailable the value to add
             * @return this builder
             */
            public Builder addPushTypeAvailable(CodeableConcept pushTypeAvailable) {
                this.pushTypeAvailable.add(Objects.requireNonNull(pushTypeAvailable, "pushTypeAvailable"));
                return this;
            }

            /**
             * Builds the {@code PrimarySource}.
             *
             * @return the {@code PrimarySource}
             */
            public PrimarySource build() {
                return new PrimarySource(
                        id, extension, modifierExtension, who, type, communicationMethod, validationStatus,
                        validationDate, canPushUpdates, pushTypeAvailable);
            }
        }
    }

    /**
     * Information about the entity attesting to information.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param who The individual or organization attesting to information. Reference to Practitioner,
     *   PractitionerRole, Organization.
     * @param onBehalfOf When the who is asserting on behalf of another (organization or individual). Reference to
     *   Organization, Practitioner, PractitionerRole.
     * @param communicationMethod The method by which attested information was submitted/retrieved.
     * @param date The date the information was attested to.
     * @param sourceIdentityCertificate A digital identity certificate associated with the attestation source.
     * @param proxyIdentityCertificate A digital identity certificate associated with the proxy entity submitting
     *   attested information on behalf of the attestation source.
     * @param proxySignature Proxy signature (digital or image).
     * @param sourceSignature Attester signature (digital or image).
     */
    public record Attestation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference who,
            Reference onBehalfOf,
            CodeableConcept communicationMethod,
            FhirDate date,
            FhirString sourceIdentityCertificate,
            FhirString proxyIdentityCertificate,
            Signature proxySignature,
            Signature sourceSignature) implements BackboneElement {

        /**
         * Creates an {@code Attestation}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Attestation {
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
         * Returns a builder initialized with the values of this {@code Attestation}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Attestation}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference who;
            private Reference onBehalfOf;
            private CodeableConcept communicationMethod;
            private FhirDate date;
            private FhirString sourceIdentityCertificate;
            private FhirString proxyIdentityCertificate;
            private Signature proxySignature;
            private Signature sourceSignature;

            private Builder() {
            }

            private Builder(Attestation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.who = original.who();
                this.onBehalfOf = original.onBehalfOf();
                this.communicationMethod = original.communicationMethod();
                this.date = original.date();
                this.sourceIdentityCertificate = original.sourceIdentityCertificate();
                this.proxyIdentityCertificate = original.proxyIdentityCertificate();
                this.proxySignature = original.proxySignature();
                this.sourceSignature = original.sourceSignature();
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
             * Sets {@code who}.
             *
             * @param who the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder who(Reference who) {
                this.who = who;
                return this;
            }

            /**
             * Sets {@code onBehalfOf}.
             *
             * @param onBehalfOf the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder onBehalfOf(Reference onBehalfOf) {
                this.onBehalfOf = onBehalfOf;
                return this;
            }

            /**
             * Sets {@code communicationMethod}.
             *
             * @param communicationMethod the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder communicationMethod(CodeableConcept communicationMethod) {
                this.communicationMethod = communicationMethod;
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
             * Sets {@code sourceIdentityCertificate}.
             *
             * @param sourceIdentityCertificate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sourceIdentityCertificate(FhirString sourceIdentityCertificate) {
                this.sourceIdentityCertificate = sourceIdentityCertificate;
                return this;
            }

            /**
             * Sets {@code sourceIdentityCertificate}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param sourceIdentityCertificate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sourceIdentityCertificate(String sourceIdentityCertificate) {
                return sourceIdentityCertificate(
                        sourceIdentityCertificate == null ? null : FhirString.of(sourceIdentityCertificate));
            }

            /**
             * Sets {@code proxyIdentityCertificate}.
             *
             * @param proxyIdentityCertificate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder proxyIdentityCertificate(FhirString proxyIdentityCertificate) {
                this.proxyIdentityCertificate = proxyIdentityCertificate;
                return this;
            }

            /**
             * Sets {@code proxyIdentityCertificate}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param proxyIdentityCertificate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder proxyIdentityCertificate(String proxyIdentityCertificate) {
                return proxyIdentityCertificate(
                        proxyIdentityCertificate == null ? null : FhirString.of(proxyIdentityCertificate));
            }

            /**
             * Sets {@code proxySignature}.
             *
             * @param proxySignature the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder proxySignature(Signature proxySignature) {
                this.proxySignature = proxySignature;
                return this;
            }

            /**
             * Sets {@code sourceSignature}.
             *
             * @param sourceSignature the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sourceSignature(Signature sourceSignature) {
                this.sourceSignature = sourceSignature;
                return this;
            }

            /**
             * Builds the {@code Attestation}.
             *
             * @return the {@code Attestation}
             */
            public Attestation build() {
                return new Attestation(
                        id, extension, modifierExtension, who, onBehalfOf, communicationMethod, date,
                        sourceIdentityCertificate, proxyIdentityCertificate, proxySignature, sourceSignature);
            }
        }
    }

    /**
     * Information about the entity validating information.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param organization Reference to the organization validating information. Reference to Organization. Required.
     * @param identityCertificate A digital identity certificate associated with the validator.
     * @param attestationSignature Validator signature (digital or image).
     */
    public record Validator(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference organization,
            FhirString identityCertificate,
            Signature attestationSignature) implements BackboneElement {

        /**
         * Creates a {@code Validator}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Validator {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(organization, "VerificationResult.validator.organization is required");
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
         * Returns a builder initialized with the values of this {@code Validator}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Validator}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference organization;
            private FhirString identityCertificate;
            private Signature attestationSignature;

            private Builder() {
            }

            private Builder(Validator original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.organization = original.organization();
                this.identityCertificate = original.identityCertificate();
                this.attestationSignature = original.attestationSignature();
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
             * Sets {@code identityCertificate}.
             *
             * @param identityCertificate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identityCertificate(FhirString identityCertificate) {
                this.identityCertificate = identityCertificate;
                return this;
            }

            /**
             * Sets {@code identityCertificate}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param identityCertificate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identityCertificate(String identityCertificate) {
                return identityCertificate(identityCertificate == null ? null : FhirString.of(identityCertificate));
            }

            /**
             * Sets {@code attestationSignature}.
             *
             * @param attestationSignature the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder attestationSignature(Signature attestationSignature) {
                this.attestationSignature = attestationSignature;
                return this;
            }

            /**
             * Builds the {@code Validator}.
             *
             * @return the {@code Validator}
             * @throws NullPointerException if a required element is absent
             */
            public Validator build() {
                return new Validator(
                        id, extension, modifierExtension, organization, identityCertificate, attestationSignature);
            }
        }
    }

    /** Builder for {@link VerificationResult}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private List<Reference> target = new ArrayList<>();
        private List<FhirString> targetLocation = new ArrayList<>();
        private CodeableConcept need;
        private FhirEnum<VerificationResultStatus> status;
        private FhirDateTime statusDate;
        private CodeableConcept validationType;
        private List<CodeableConcept> validationProcess = new ArrayList<>();
        private Timing frequency;
        private FhirDateTime lastPerformed;
        private FhirDate nextScheduled;
        private CodeableConcept failureAction;
        private List<PrimarySource> primarySource = new ArrayList<>();
        private Attestation attestation;
        private List<Validator> validator = new ArrayList<>();

        private Builder() {
        }

        private Builder(VerificationResult original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.target = new ArrayList<>(original.target());
            this.targetLocation = new ArrayList<>(original.targetLocation());
            this.need = original.need();
            this.status = original.status();
            this.statusDate = original.statusDate();
            this.validationType = original.validationType();
            this.validationProcess = new ArrayList<>(original.validationProcess());
            this.frequency = original.frequency();
            this.lastPerformed = original.lastPerformed();
            this.nextScheduled = original.nextScheduled();
            this.failureAction = original.failureAction();
            this.primarySource = new ArrayList<>(original.primarySource());
            this.attestation = original.attestation();
            this.validator = new ArrayList<>(original.validator());
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
         * Replaces all {@code target} values.
         *
         * @param target the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder target(List<Reference> target) {
            this.target = target == null ? new ArrayList<>() : new ArrayList<>(target);
            return this;
        }

        /**
         * Adds a {@code target} value.
         *
         * @param target the value to add
         * @return this builder
         */
        public Builder addTarget(Reference target) {
            this.target.add(Objects.requireNonNull(target, "target"));
            return this;
        }

        /**
         * Replaces all {@code targetLocation} values.
         *
         * @param targetLocation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder targetLocation(List<FhirString> targetLocation) {
            this.targetLocation = targetLocation == null ? new ArrayList<>() : new ArrayList<>(targetLocation);
            return this;
        }

        /**
         * Adds a {@code targetLocation} value.
         *
         * @param targetLocation the value to add
         * @return this builder
         */
        public Builder addTargetLocation(FhirString targetLocation) {
            this.targetLocation.add(Objects.requireNonNull(targetLocation, "targetLocation"));
            return this;
        }

        /**
         * Adds a {@code targetLocation} value, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param targetLocation the value to add
         * @return this builder
         */
        public Builder addTargetLocation(String targetLocation) {
            return addTargetLocation(FhirString.of(targetLocation));
        }

        /**
         * Sets {@code need}.
         *
         * @param need the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder need(CodeableConcept need) {
            this.need = need;
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<VerificationResultStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(VerificationResultStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Sets {@code validationType}.
         *
         * @param validationType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder validationType(CodeableConcept validationType) {
            this.validationType = validationType;
            return this;
        }

        /**
         * Replaces all {@code validationProcess} values.
         *
         * @param validationProcess the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder validationProcess(List<CodeableConcept> validationProcess) {
            this.validationProcess = validationProcess == null
                    ? new ArrayList<>()
                    : new ArrayList<>(validationProcess);
            return this;
        }

        /**
         * Adds a {@code validationProcess} value.
         *
         * @param validationProcess the value to add
         * @return this builder
         */
        public Builder addValidationProcess(CodeableConcept validationProcess) {
            this.validationProcess.add(Objects.requireNonNull(validationProcess, "validationProcess"));
            return this;
        }

        /**
         * Sets {@code frequency}.
         *
         * @param frequency the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder frequency(Timing frequency) {
            this.frequency = frequency;
            return this;
        }

        /**
         * Sets {@code lastPerformed}.
         *
         * @param lastPerformed the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastPerformed(FhirDateTime lastPerformed) {
            this.lastPerformed = lastPerformed;
            return this;
        }

        /**
         * Sets {@code lastPerformed}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param lastPerformed the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastPerformed(Temporal lastPerformed) {
            return lastPerformed(lastPerformed == null ? null : FhirDateTime.of(lastPerformed));
        }

        /**
         * Sets {@code nextScheduled}.
         *
         * @param nextScheduled the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder nextScheduled(FhirDate nextScheduled) {
            this.nextScheduled = nextScheduled;
            return this;
        }

        /**
         * Sets {@code nextScheduled}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param nextScheduled the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder nextScheduled(Temporal nextScheduled) {
            return nextScheduled(nextScheduled == null ? null : FhirDate.of(nextScheduled));
        }

        /**
         * Sets {@code failureAction}.
         *
         * @param failureAction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder failureAction(CodeableConcept failureAction) {
            this.failureAction = failureAction;
            return this;
        }

        /**
         * Replaces all {@code primarySource} values.
         *
         * @param primarySource the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder primarySource(List<PrimarySource> primarySource) {
            this.primarySource = primarySource == null ? new ArrayList<>() : new ArrayList<>(primarySource);
            return this;
        }

        /**
         * Adds a {@code primarySource} value.
         *
         * @param primarySource the value to add
         * @return this builder
         */
        public Builder addPrimarySource(PrimarySource primarySource) {
            this.primarySource.add(Objects.requireNonNull(primarySource, "primarySource"));
            return this;
        }

        /**
         * Sets {@code attestation}.
         *
         * @param attestation the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder attestation(Attestation attestation) {
            this.attestation = attestation;
            return this;
        }

        /**
         * Replaces all {@code validator} values.
         *
         * @param validator the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder validator(List<Validator> validator) {
            this.validator = validator == null ? new ArrayList<>() : new ArrayList<>(validator);
            return this;
        }

        /**
         * Adds a {@code validator} value.
         *
         * @param validator the value to add
         * @return this builder
         */
        public Builder addValidator(Validator validator) {
            this.validator.add(Objects.requireNonNull(validator, "validator"));
            return this;
        }

        /**
         * Builds the {@code VerificationResult}.
         *
         * @return the {@code VerificationResult}
         * @throws NullPointerException if a required element is absent
         */
        public VerificationResult build() {
            return new VerificationResult(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, target,
                    targetLocation, need, status, statusDate, validationType, validationProcess, frequency,
                    lastPerformed, nextScheduled, failureAction, primarySource, attestation, validator);
        }
    }
}
