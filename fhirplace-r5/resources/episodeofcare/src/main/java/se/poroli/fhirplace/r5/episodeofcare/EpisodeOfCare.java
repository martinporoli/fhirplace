package se.poroli.fhirplace.r5.episodeofcare;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * An association between a patient and an organization / healthcare provider(s) during which time encounters may
 * occur.
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
 * @param identifier Business Identifier(s) relevant for this EpisodeOfCare.
 * @param status planned | waitlist | active | onhold | finished | cancelled | entered-in-error. Required. Modifier
 *   element.
 * @param statusHistory Past list of status codes (the current status may be included to cover the start date of the
 *   status).
 * @param type Type/class - e.g. specialist referral, disease management.
 * @param reason The list of medical reasons that are expected to be addressed during the episode of care.
 * @param diagnosis The list of medical conditions that were addressed during the episode of care.
 * @param patient The patient who is the focus of this episode of care. Reference to Patient. Required.
 * @param managingOrganization Organization that assumes responsibility for care coordination. Reference to
 *   Organization.
 * @param period Interval during responsibility is assumed.
 * @param referralRequest Originating Referral Request(s). Reference to ServiceRequest.
 * @param careManager Care manager/care coordinator for the patient. Reference to Practitioner, PractitionerRole.
 * @param careTeam Other practitioners facilitating this episode of care. Reference to CareTeam.
 * @param account The set of accounts that may be used for billing for this EpisodeOfCare. Reference to Account.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/EpisodeOfCare">FHIR R5 EpisodeOfCare</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record EpisodeOfCare(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<EpisodeOfCareStatus> status,
        List<StatusHistory> statusHistory,
        List<CodeableConcept> type,
        List<Reason> reason,
        List<Diagnosis> diagnosis,
        Reference patient,
        Reference managingOrganization,
        Period period,
        List<Reference> referralRequest,
        Reference careManager,
        List<Reference> careTeam,
        List<Reference> account) implements DomainResource {

    /**
     * Creates an {@code EpisodeOfCare}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public EpisodeOfCare {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        statusHistory = statusHistory == null ? List.of() : List.copyOf(statusHistory);
        type = type == null ? List.of() : List.copyOf(type);
        reason = reason == null ? List.of() : List.copyOf(reason);
        diagnosis = diagnosis == null ? List.of() : List.copyOf(diagnosis);
        referralRequest = referralRequest == null ? List.of() : List.copyOf(referralRequest);
        careTeam = careTeam == null ? List.of() : List.copyOf(careTeam);
        account = account == null ? List.of() : List.copyOf(account);
        Objects.requireNonNull(status, "EpisodeOfCare.status is required");
        Objects.requireNonNull(patient, "EpisodeOfCare.patient is required");
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
     * Returns a builder initialized with the values of this {@code EpisodeOfCare}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The history of statuses that the EpisodeOfCare has been through (without requiring processing the history of
     * the resource).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param status planned | waitlist | active | onhold | finished | cancelled | entered-in-error. Required.
     * @param period Duration the EpisodeOfCare was in the specified status. Required.
     */
    public record StatusHistory(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<EpisodeOfCareStatus> status,
            Period period) implements BackboneElement {

        /**
         * Creates a {@code StatusHistory}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public StatusHistory {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(status, "EpisodeOfCare.statusHistory.status is required");
            Objects.requireNonNull(period, "EpisodeOfCare.statusHistory.period is required");
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
         * Returns a builder initialized with the values of this {@code StatusHistory}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link StatusHistory}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<EpisodeOfCareStatus> status;
            private Period period;

            private Builder() {
            }

            private Builder(StatusHistory original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.status = original.status();
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
             * Sets {@code status}.
             *
             * @param status the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder status(FhirEnum<EpisodeOfCareStatus> status) {
                this.status = status;
                return this;
            }

            /**
             * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param status the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder status(EpisodeOfCareStatus status) {
                return status(status == null ? null : FhirEnum.of(status));
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
             * Builds the {@code StatusHistory}.
             *
             * @return the {@code StatusHistory}
             * @throws NullPointerException if a required element is absent
             */
            public StatusHistory build() {
                return new StatusHistory(
                        id, extension, modifierExtension, status, period);
            }
        }
    }

    /**
     * The list of medical reasons that are expected to be addressed during the episode of care.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param use What the reason value should be used for/as.
     * @param value Medical reason to be addressed.
     */
    public record Reason(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept use,
            List<CodeableReference> value) implements BackboneElement {

        /**
         * Creates a {@code Reason}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Reason {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            value = value == null ? List.of() : List.copyOf(value);
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
         * Returns a builder initialized with the values of this {@code Reason}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Reason}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept use;
            private List<CodeableReference> value = new ArrayList<>();

            private Builder() {
            }

            private Builder(Reason original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.use = original.use();
                this.value = new ArrayList<>(original.value());
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
             * Sets {@code use}.
             *
             * @param use the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder use(CodeableConcept use) {
                this.use = use;
                return this;
            }

            /**
             * Replaces all {@code value} values.
             *
             * @param value the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder value(List<CodeableReference> value) {
                this.value = value == null ? new ArrayList<>() : new ArrayList<>(value);
                return this;
            }

            /**
             * Adds a {@code value} value.
             *
             * @param value the value to add
             * @return this builder
             */
            public Builder addValue(CodeableReference value) {
                this.value.add(Objects.requireNonNull(value, "value"));
                return this;
            }

            /**
             * Builds the {@code Reason}.
             *
             * @return the {@code Reason}
             */
            public Reason build() {
                return new Reason(
                        id, extension, modifierExtension, use, value);
            }
        }
    }

    /**
     * The list of medical conditions that were addressed during the episode of care.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param condition The medical condition that was addressed during the episode of care.
     * @param use Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge …).
     */
    public record Diagnosis(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableReference> condition,
            CodeableConcept use) implements BackboneElement {

        /**
         * Creates a {@code Diagnosis}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Diagnosis {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            condition = condition == null ? List.of() : List.copyOf(condition);
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
            private List<CodeableReference> condition = new ArrayList<>();
            private CodeableConcept use;

            private Builder() {
            }

            private Builder(Diagnosis original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.condition = new ArrayList<>(original.condition());
                this.use = original.use();
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
             * Replaces all {@code condition} values.
             *
             * @param condition the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder condition(List<CodeableReference> condition) {
                this.condition = condition == null ? new ArrayList<>() : new ArrayList<>(condition);
                return this;
            }

            /**
             * Adds a {@code condition} value.
             *
             * @param condition the value to add
             * @return this builder
             */
            public Builder addCondition(CodeableReference condition) {
                this.condition.add(Objects.requireNonNull(condition, "condition"));
                return this;
            }

            /**
             * Sets {@code use}.
             *
             * @param use the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder use(CodeableConcept use) {
                this.use = use;
                return this;
            }

            /**
             * Builds the {@code Diagnosis}.
             *
             * @return the {@code Diagnosis}
             */
            public Diagnosis build() {
                return new Diagnosis(
                        id, extension, modifierExtension, condition, use);
            }
        }
    }

    /** Builder for {@link EpisodeOfCare}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<EpisodeOfCareStatus> status;
        private List<StatusHistory> statusHistory = new ArrayList<>();
        private List<CodeableConcept> type = new ArrayList<>();
        private List<Reason> reason = new ArrayList<>();
        private List<Diagnosis> diagnosis = new ArrayList<>();
        private Reference patient;
        private Reference managingOrganization;
        private Period period;
        private List<Reference> referralRequest = new ArrayList<>();
        private Reference careManager;
        private List<Reference> careTeam = new ArrayList<>();
        private List<Reference> account = new ArrayList<>();

        private Builder() {
        }

        private Builder(EpisodeOfCare original) {
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
            this.statusHistory = new ArrayList<>(original.statusHistory());
            this.type = new ArrayList<>(original.type());
            this.reason = new ArrayList<>(original.reason());
            this.diagnosis = new ArrayList<>(original.diagnosis());
            this.patient = original.patient();
            this.managingOrganization = original.managingOrganization();
            this.period = original.period();
            this.referralRequest = new ArrayList<>(original.referralRequest());
            this.careManager = original.careManager();
            this.careTeam = new ArrayList<>(original.careTeam());
            this.account = new ArrayList<>(original.account());
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
        public Builder status(FhirEnum<EpisodeOfCareStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(EpisodeOfCareStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Replaces all {@code statusHistory} values.
         *
         * @param statusHistory the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder statusHistory(List<StatusHistory> statusHistory) {
            this.statusHistory = statusHistory == null ? new ArrayList<>() : new ArrayList<>(statusHistory);
            return this;
        }

        /**
         * Adds a {@code statusHistory} value.
         *
         * @param statusHistory the value to add
         * @return this builder
         */
        public Builder addStatusHistory(StatusHistory statusHistory) {
            this.statusHistory.add(Objects.requireNonNull(statusHistory, "statusHistory"));
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
         * Replaces all {@code reason} values.
         *
         * @param reason the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reason(List<Reason> reason) {
            this.reason = reason == null ? new ArrayList<>() : new ArrayList<>(reason);
            return this;
        }

        /**
         * Adds a {@code reason} value.
         *
         * @param reason the value to add
         * @return this builder
         */
        public Builder addReason(Reason reason) {
            this.reason.add(Objects.requireNonNull(reason, "reason"));
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
         * Sets {@code managingOrganization}.
         *
         * @param managingOrganization the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder managingOrganization(Reference managingOrganization) {
            this.managingOrganization = managingOrganization;
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
         * Replaces all {@code referralRequest} values.
         *
         * @param referralRequest the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder referralRequest(List<Reference> referralRequest) {
            this.referralRequest = referralRequest == null ? new ArrayList<>() : new ArrayList<>(referralRequest);
            return this;
        }

        /**
         * Adds a {@code referralRequest} value.
         *
         * @param referralRequest the value to add
         * @return this builder
         */
        public Builder addReferralRequest(Reference referralRequest) {
            this.referralRequest.add(Objects.requireNonNull(referralRequest, "referralRequest"));
            return this;
        }

        /**
         * Sets {@code careManager}.
         *
         * @param careManager the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder careManager(Reference careManager) {
            this.careManager = careManager;
            return this;
        }

        /**
         * Replaces all {@code careTeam} values.
         *
         * @param careTeam the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder careTeam(List<Reference> careTeam) {
            this.careTeam = careTeam == null ? new ArrayList<>() : new ArrayList<>(careTeam);
            return this;
        }

        /**
         * Adds a {@code careTeam} value.
         *
         * @param careTeam the value to add
         * @return this builder
         */
        public Builder addCareTeam(Reference careTeam) {
            this.careTeam.add(Objects.requireNonNull(careTeam, "careTeam"));
            return this;
        }

        /**
         * Replaces all {@code account} values.
         *
         * @param account the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder account(List<Reference> account) {
            this.account = account == null ? new ArrayList<>() : new ArrayList<>(account);
            return this;
        }

        /**
         * Adds a {@code account} value.
         *
         * @param account the value to add
         * @return this builder
         */
        public Builder addAccount(Reference account) {
            this.account.add(Objects.requireNonNull(account, "account"));
            return this;
        }

        /**
         * Builds the {@code EpisodeOfCare}.
         *
         * @return the {@code EpisodeOfCare}
         * @throws NullPointerException if a required element is absent
         */
        public EpisodeOfCare build() {
            return new EpisodeOfCare(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, statusHistory, type, reason, diagnosis, patient, managingOrganization, period,
                    referralRequest, careManager, careTeam, account);
        }
    }
}
