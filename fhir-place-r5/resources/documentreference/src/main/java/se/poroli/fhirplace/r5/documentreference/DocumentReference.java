package se.poroli.fhirplace.r5.documentreference;

import java.time.OffsetDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.CompositionStatus;

/**
 * A reference to a document of any kind for any purpose.
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
 * @param identifier Business identifiers for the document.
 * @param version An explicitly assigned identifer of a variation of the content in the DocumentReference.
 * @param basedOn Procedure that caused this media to be created. Reference to Appointment, AppointmentResponse,
 *   CarePlan, Claim, CommunicationRequest, Contract, CoverageEligibilityRequest, DeviceRequest, EnrollmentRequest,
 *   ImmunizationRecommendation, MedicationRequest, NutritionOrder, RequestOrchestration, ServiceRequest,
 *   SupplyRequest, VisionPrescription.
 * @param status current | superseded | entered-in-error. Required. Modifier element.
 * @param docStatus registered | partial | preliminary | final | amended | corrected | appended | cancelled |
 *   entered-in-error | deprecated | unknown.
 * @param modality Imaging modality used.
 * @param type Kind of document (LOINC if possible).
 * @param category Categorization of document.
 * @param subject Who/what is the subject of the document. Reference to Resource.
 * @param context Context of the document content. Reference to Appointment, Encounter, EpisodeOfCare.
 * @param event Main clinical acts documented.
 * @param bodySite Body part included.
 * @param facilityType Kind of facility where patient was seen.
 * @param practiceSetting Additional details about where the content was created (e.g. clinical specialty).
 * @param period Time of service that is being documented.
 * @param date When this document reference was created.
 * @param author Who and/or what authored the document. Reference to Practitioner, PractitionerRole, Organization,
 *   Device, Patient, RelatedPerson, CareTeam.
 * @param attester Attests to accuracy of the document.
 * @param custodian Organization which maintains the document. Reference to Organization.
 * @param relatesTo Relationships to other documents.
 * @param description Human-readable description.
 * @param securityLabel Document security-tags.
 * @param content Document referenced. Required.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DocumentReference">FHIR R5 DocumentReference</a>
 */
public record DocumentReference(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirString version,
        List<Reference> basedOn,
        FhirEnum<DocumentReferenceStatus> status,
        FhirEnum<CompositionStatus> docStatus,
        List<CodeableConcept> modality,
        CodeableConcept type,
        List<CodeableConcept> category,
        Reference subject,
        List<Reference> context,
        List<CodeableReference> event,
        List<CodeableReference> bodySite,
        CodeableConcept facilityType,
        CodeableConcept practiceSetting,
        Period period,
        FhirInstant date,
        List<Reference> author,
        List<Attester> attester,
        Reference custodian,
        List<RelatesTo> relatesTo,
        FhirMarkdown description,
        List<CodeableConcept> securityLabel,
        List<Content> content) implements DomainResource {

    /**
     * Creates a {@code DocumentReference}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a required list is empty
     */
    public DocumentReference {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        modality = modality == null ? List.of() : List.copyOf(modality);
        category = category == null ? List.of() : List.copyOf(category);
        context = context == null ? List.of() : List.copyOf(context);
        event = event == null ? List.of() : List.copyOf(event);
        bodySite = bodySite == null ? List.of() : List.copyOf(bodySite);
        author = author == null ? List.of() : List.copyOf(author);
        attester = attester == null ? List.of() : List.copyOf(attester);
        relatesTo = relatesTo == null ? List.of() : List.copyOf(relatesTo);
        securityLabel = securityLabel == null ? List.of() : List.copyOf(securityLabel);
        content = content == null ? List.of() : List.copyOf(content);
        Objects.requireNonNull(status, "DocumentReference.status is required");
        if (content.isEmpty()) {
            throw new IllegalArgumentException("DocumentReference.content requires at least one value");
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
     * Returns a builder initialized with the values of this {@code DocumentReference}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A participant who has authenticated the accuracy of the document.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param mode personal | professional | legal | official. Required.
     * @param time When the document was attested.
     * @param party Who attested the document. Reference to Patient, RelatedPerson, Practitioner, PractitionerRole,
     *   Organization.
     */
    public record Attester(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept mode,
            FhirDateTime time,
            Reference party) implements BackboneElement {

        /**
         * Creates an {@code Attester}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Attester {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(mode, "DocumentReference.attester.mode is required");
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
         * Returns a builder initialized with the values of this {@code Attester}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Attester}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept mode;
            private FhirDateTime time;
            private Reference party;

            private Builder() {
            }

            private Builder(Attester original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.mode = original.mode();
                this.time = original.time();
                this.party = original.party();
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
             * Sets {@code mode}.
             *
             * @param mode the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder mode(CodeableConcept mode) {
                this.mode = mode;
                return this;
            }

            /**
             * Sets {@code time}.
             *
             * @param time the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder time(FhirDateTime time) {
                this.time = time;
                return this;
            }

            /**
             * Sets {@code time}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param time the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder time(Temporal time) {
                return time(time == null ? null : FhirDateTime.of(time));
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
             * Builds the {@code Attester}.
             *
             * @return the {@code Attester}
             * @throws NullPointerException if a required element is absent
             */
            public Attester build() {
                return new Attester(
                        id, extension, modifierExtension, mode, time, party);
            }
        }
    }

    /**
     * Relationships that this document has with other document references that already exist.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code The relationship type with another document. Required.
     * @param target Target of the relationship. Reference to DocumentReference. Required.
     */
    public record RelatesTo(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            Reference target) implements BackboneElement {

        /**
         * Creates a {@code RelatesTo}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public RelatesTo {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(code, "DocumentReference.relatesTo.code is required");
            Objects.requireNonNull(target, "DocumentReference.relatesTo.target is required");
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
         * Returns a builder initialized with the values of this {@code RelatesTo}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link RelatesTo}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept code;
            private Reference target;

            private Builder() {
            }

            private Builder(RelatesTo original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.target = original.target();
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
             * Sets {@code target}.
             *
             * @param target the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder target(Reference target) {
                this.target = target;
                return this;
            }

            /**
             * Builds the {@code RelatesTo}.
             *
             * @return the {@code RelatesTo}
             * @throws NullPointerException if a required element is absent
             */
            public RelatesTo build() {
                return new RelatesTo(
                        id, extension, modifierExtension, code, target);
            }
        }
    }

    /**
     * The document and format referenced.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param attachment Where to access the document. Required.
     * @param profile Content profile rules for the document.
     */
    public record Content(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Attachment attachment,
            List<Profile> profile) implements BackboneElement {

        /**
         * Creates a {@code Content}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Content {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            profile = profile == null ? List.of() : List.copyOf(profile);
            Objects.requireNonNull(attachment, "DocumentReference.content.attachment is required");
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
         * Returns a builder initialized with the values of this {@code Content}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * An identifier of the document constraints, encoding, structure, and template that the document conforms to
         * beyond the base format indicated in the mimeType.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param value Code|uri|canonical. One of Coding, uri, canonical. Required.
         */
        public record Profile(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                DataType value) implements BackboneElement {

            /**
             * Creates a {@code Profile}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Profile {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(value, "DocumentReference.content.profile.value is required");
                if (value != null && !(value instanceof Coding
                        || value instanceof FhirUri
                        || value instanceof FhirCanonical)) {
                    throw new IllegalArgumentException(
                            "DocumentReference.content.profile.value[x] does not allow "
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
             * Returns a builder initialized with the values of this {@code Profile}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Profile}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private DataType value;

                private Builder() {
                }

                private Builder(Profile original) {
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
                 * Sets {@code value} to a Coding.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(Coding value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a uri.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirUri value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Sets {@code value} to a canonical.
                 *
                 * @param value the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder value(FhirCanonical value) {
                    this.value = value;
                    return this;
                }

                /**
                 * Builds the {@code Profile}.
                 *
                 * @return the {@code Profile}
                 * @throws NullPointerException if a required element is absent
                 */
                public Profile build() {
                    return new Profile(
                            id, extension, modifierExtension, value);
                }
            }
        }

        /** Builder for {@link Content}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Attachment attachment;
            private List<Profile> profile = new ArrayList<>();

            private Builder() {
            }

            private Builder(Content original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.attachment = original.attachment();
                this.profile = new ArrayList<>(original.profile());
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
             * Sets {@code attachment}.
             *
             * @param attachment the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder attachment(Attachment attachment) {
                this.attachment = attachment;
                return this;
            }

            /**
             * Replaces all {@code profile} values.
             *
             * @param profile the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder profile(List<Profile> profile) {
                this.profile = profile == null ? new ArrayList<>() : new ArrayList<>(profile);
                return this;
            }

            /**
             * Adds a {@code profile} value.
             *
             * @param profile the value to add
             * @return this builder
             */
            public Builder addProfile(Profile profile) {
                this.profile.add(Objects.requireNonNull(profile, "profile"));
                return this;
            }

            /**
             * Builds the {@code Content}.
             *
             * @return the {@code Content}
             * @throws NullPointerException if a required element is absent
             */
            public Content build() {
                return new Content(
                        id, extension, modifierExtension, attachment, profile);
            }
        }
    }

    /** Builder for {@link DocumentReference}. Builders are mutable and not thread-safe. */
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
        private FhirString version;
        private List<Reference> basedOn = new ArrayList<>();
        private FhirEnum<DocumentReferenceStatus> status;
        private FhirEnum<CompositionStatus> docStatus;
        private List<CodeableConcept> modality = new ArrayList<>();
        private CodeableConcept type;
        private List<CodeableConcept> category = new ArrayList<>();
        private Reference subject;
        private List<Reference> context = new ArrayList<>();
        private List<CodeableReference> event = new ArrayList<>();
        private List<CodeableReference> bodySite = new ArrayList<>();
        private CodeableConcept facilityType;
        private CodeableConcept practiceSetting;
        private Period period;
        private FhirInstant date;
        private List<Reference> author = new ArrayList<>();
        private List<Attester> attester = new ArrayList<>();
        private Reference custodian;
        private List<RelatesTo> relatesTo = new ArrayList<>();
        private FhirMarkdown description;
        private List<CodeableConcept> securityLabel = new ArrayList<>();
        private List<Content> content = new ArrayList<>();

        private Builder() {
        }

        private Builder(DocumentReference original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.version = original.version();
            this.basedOn = new ArrayList<>(original.basedOn());
            this.status = original.status();
            this.docStatus = original.docStatus();
            this.modality = new ArrayList<>(original.modality());
            this.type = original.type();
            this.category = new ArrayList<>(original.category());
            this.subject = original.subject();
            this.context = new ArrayList<>(original.context());
            this.event = new ArrayList<>(original.event());
            this.bodySite = new ArrayList<>(original.bodySite());
            this.facilityType = original.facilityType();
            this.practiceSetting = original.practiceSetting();
            this.period = original.period();
            this.date = original.date();
            this.author = new ArrayList<>(original.author());
            this.attester = new ArrayList<>(original.attester());
            this.custodian = original.custodian();
            this.relatesTo = new ArrayList<>(original.relatesTo());
            this.description = original.description();
            this.securityLabel = new ArrayList<>(original.securityLabel());
            this.content = new ArrayList<>(original.content());
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
         * Replaces all {@code basedOn} values.
         *
         * @param basedOn the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder basedOn(List<Reference> basedOn) {
            this.basedOn = basedOn == null ? new ArrayList<>() : new ArrayList<>(basedOn);
            return this;
        }

        /**
         * Adds a {@code basedOn} value.
         *
         * @param basedOn the value to add
         * @return this builder
         */
        public Builder addBasedOn(Reference basedOn) {
            this.basedOn.add(Objects.requireNonNull(basedOn, "basedOn"));
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<DocumentReferenceStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(DocumentReferenceStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code docStatus}.
         *
         * @param docStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder docStatus(FhirEnum<CompositionStatus> docStatus) {
            this.docStatus = docStatus;
            return this;
        }

        /**
         * Sets {@code docStatus}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param docStatus the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder docStatus(CompositionStatus docStatus) {
            return docStatus(docStatus == null ? null : FhirEnum.of(docStatus));
        }

        /**
         * Replaces all {@code modality} values.
         *
         * @param modality the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder modality(List<CodeableConcept> modality) {
            this.modality = modality == null ? new ArrayList<>() : new ArrayList<>(modality);
            return this;
        }

        /**
         * Adds a {@code modality} value.
         *
         * @param modality the value to add
         * @return this builder
         */
        public Builder addModality(CodeableConcept modality) {
            this.modality.add(Objects.requireNonNull(modality, "modality"));
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
         * Replaces all {@code context} values.
         *
         * @param context the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder context(List<Reference> context) {
            this.context = context == null ? new ArrayList<>() : new ArrayList<>(context);
            return this;
        }

        /**
         * Adds a {@code context} value.
         *
         * @param context the value to add
         * @return this builder
         */
        public Builder addContext(Reference context) {
            this.context.add(Objects.requireNonNull(context, "context"));
            return this;
        }

        /**
         * Replaces all {@code event} values.
         *
         * @param event the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder event(List<CodeableReference> event) {
            this.event = event == null ? new ArrayList<>() : new ArrayList<>(event);
            return this;
        }

        /**
         * Adds a {@code event} value.
         *
         * @param event the value to add
         * @return this builder
         */
        public Builder addEvent(CodeableReference event) {
            this.event.add(Objects.requireNonNull(event, "event"));
            return this;
        }

        /**
         * Replaces all {@code bodySite} values.
         *
         * @param bodySite the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder bodySite(List<CodeableReference> bodySite) {
            this.bodySite = bodySite == null ? new ArrayList<>() : new ArrayList<>(bodySite);
            return this;
        }

        /**
         * Adds a {@code bodySite} value.
         *
         * @param bodySite the value to add
         * @return this builder
         */
        public Builder addBodySite(CodeableReference bodySite) {
            this.bodySite.add(Objects.requireNonNull(bodySite, "bodySite"));
            return this;
        }

        /**
         * Sets {@code facilityType}.
         *
         * @param facilityType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder facilityType(CodeableConcept facilityType) {
            this.facilityType = facilityType;
            return this;
        }

        /**
         * Sets {@code practiceSetting}.
         *
         * @param practiceSetting the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder practiceSetting(CodeableConcept practiceSetting) {
            this.practiceSetting = practiceSetting;
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
         * Sets {@code date}.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(FhirInstant date) {
            this.date = date;
            return this;
        }

        /**
         * Sets {@code date}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(OffsetDateTime date) {
            return date(date == null ? null : FhirInstant.of(date));
        }

        /**
         * Replaces all {@code author} values.
         *
         * @param author the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder author(List<Reference> author) {
            this.author = author == null ? new ArrayList<>() : new ArrayList<>(author);
            return this;
        }

        /**
         * Adds a {@code author} value.
         *
         * @param author the value to add
         * @return this builder
         */
        public Builder addAuthor(Reference author) {
            this.author.add(Objects.requireNonNull(author, "author"));
            return this;
        }

        /**
         * Replaces all {@code attester} values.
         *
         * @param attester the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder attester(List<Attester> attester) {
            this.attester = attester == null ? new ArrayList<>() : new ArrayList<>(attester);
            return this;
        }

        /**
         * Adds a {@code attester} value.
         *
         * @param attester the value to add
         * @return this builder
         */
        public Builder addAttester(Attester attester) {
            this.attester.add(Objects.requireNonNull(attester, "attester"));
            return this;
        }

        /**
         * Sets {@code custodian}.
         *
         * @param custodian the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder custodian(Reference custodian) {
            this.custodian = custodian;
            return this;
        }

        /**
         * Replaces all {@code relatesTo} values.
         *
         * @param relatesTo the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relatesTo(List<RelatesTo> relatesTo) {
            this.relatesTo = relatesTo == null ? new ArrayList<>() : new ArrayList<>(relatesTo);
            return this;
        }

        /**
         * Adds a {@code relatesTo} value.
         *
         * @param relatesTo the value to add
         * @return this builder
         */
        public Builder addRelatesTo(RelatesTo relatesTo) {
            this.relatesTo.add(Objects.requireNonNull(relatesTo, "relatesTo"));
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
         * Replaces all {@code securityLabel} values.
         *
         * @param securityLabel the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder securityLabel(List<CodeableConcept> securityLabel) {
            this.securityLabel = securityLabel == null ? new ArrayList<>() : new ArrayList<>(securityLabel);
            return this;
        }

        /**
         * Adds a {@code securityLabel} value.
         *
         * @param securityLabel the value to add
         * @return this builder
         */
        public Builder addSecurityLabel(CodeableConcept securityLabel) {
            this.securityLabel.add(Objects.requireNonNull(securityLabel, "securityLabel"));
            return this;
        }

        /**
         * Replaces all {@code content} values.
         *
         * @param content the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder content(List<Content> content) {
            this.content = content == null ? new ArrayList<>() : new ArrayList<>(content);
            return this;
        }

        /**
         * Adds a {@code content} value.
         *
         * @param content the value to add
         * @return this builder
         */
        public Builder addContent(Content content) {
            this.content.add(Objects.requireNonNull(content, "content"));
            return this;
        }

        /**
         * Builds the {@code DocumentReference}.
         *
         * @return the {@code DocumentReference}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public DocumentReference build() {
            return new DocumentReference(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    version, basedOn, status, docStatus, modality, type, category, subject, context, event, bodySite,
                    facilityType, practiceSetting, period, date, author, attester, custodian, relatesTo, description,
                    securityLabel, content);
        }
    }
}
