package se.poroli.fhirplace.r5.activitydefinition;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Dosage;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.ActionParticipantType;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;

/**
 * This resource allows for the definition of some activity to be performed, independent of a particular patient,
 * practitioner, or other performance context.
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
 * @param url Canonical identifier for this activity definition, represented as a URI (globally unique).
 * @param identifier Additional identifier for the activity definition.
 * @param version Business version of the activity definition.
 * @param versionAlgorithm How to compare versions. One of string, Coding.
 * @param name Name for this activity definition (computer friendly).
 * @param title Name for this activity definition (human friendly).
 * @param subtitle Subordinate title of the activity definition.
 * @param status draft | active | retired | unknown. Required. Modifier element.
 * @param experimental For testing purposes, not real usage.
 * @param subject Type of individual the activity definition is intended for. One of CodeableConcept, Reference,
 *   canonical.
 * @param date Date last changed.
 * @param publisher Name of the publisher/steward (organization or individual).
 * @param contact Contact details for the publisher.
 * @param description Natural language description of the activity definition.
 * @param useContext The context that the content is intended to support.
 * @param jurisdiction Intended jurisdiction for activity definition (if applicable).
 * @param purpose Why this activity definition is defined.
 * @param usage Describes the clinical usage of the activity definition.
 * @param copyright Use and/or publishing restrictions.
 * @param copyrightLabel Copyright holder and year(s).
 * @param approvalDate When the activity definition was approved by publisher.
 * @param lastReviewDate When the activity definition was last reviewed by the publisher.
 * @param effectivePeriod When the activity definition is expected to be used.
 * @param topic E.g. Education, Treatment, Assessment, etc.
 * @param author Who authored the content.
 * @param editor Who edited the content.
 * @param reviewer Who reviewed the content.
 * @param endorser Who endorsed the content.
 * @param relatedArtifact Additional documentation, citations, etc.
 * @param library Logic used by the activity definition. Canonical reference to Library.
 * @param kind Kind of resource.
 * @param profile What profile the resource needs to conform to. Canonical reference to StructureDefinition.
 * @param code Detail type of activity.
 * @param intent proposal | plan | directive | order | original-order | reflex-order | filler-order | instance-order |
 *   option.
 * @param priority routine | urgent | asap | stat.
 * @param doNotPerform True if the activity should not be performed. Modifier element.
 * @param timing When activity is to occur. One of Timing, Age, Range, Duration.
 * @param asNeeded Preconditions for service. One of boolean, CodeableConcept.
 * @param location Where it should happen.
 * @param participant Who should participate in the action.
 * @param product What's administered/supplied. One of Reference, CodeableConcept.
 * @param quantity How much is administered/consumed/supplied.
 * @param dosage Detailed dosage instructions.
 * @param bodySite What part of body to perform on.
 * @param specimenRequirement What specimens are required to perform this action. Canonical reference to
 *   SpecimenDefinition.
 * @param observationRequirement What observations are required to perform this action. Canonical reference to
 *   ObservationDefinition.
 * @param observationResultRequirement What observations must be produced by this action. Canonical reference to
 *   ObservationDefinition.
 * @param transform Transform to apply the template. Canonical reference to StructureMap.
 * @param dynamicValue Dynamic aspects of the definition.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ActivityDefinition">FHIR R5 ActivityDefinition</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record ActivityDefinition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirUri url,
        List<Identifier> identifier,
        FhirString version,
        DataType versionAlgorithm,
        FhirString name,
        FhirString title,
        FhirString subtitle,
        FhirEnum<PublicationStatus> status,
        FhirBoolean experimental,
        DataType subject,
        FhirDateTime date,
        FhirString publisher,
        List<ContactDetail> contact,
        FhirMarkdown description,
        List<UsageContext> useContext,
        List<CodeableConcept> jurisdiction,
        FhirMarkdown purpose,
        FhirMarkdown usage,
        FhirMarkdown copyright,
        FhirString copyrightLabel,
        FhirDate approvalDate,
        FhirDate lastReviewDate,
        Period effectivePeriod,
        List<CodeableConcept> topic,
        List<ContactDetail> author,
        List<ContactDetail> editor,
        List<ContactDetail> reviewer,
        List<ContactDetail> endorser,
        List<RelatedArtifact> relatedArtifact,
        List<FhirCanonical> library,
        FhirEnum<RequestResourceTypes> kind,
        FhirCanonical profile,
        CodeableConcept code,
        FhirEnum<RequestIntent> intent,
        FhirEnum<RequestPriority> priority,
        FhirBoolean doNotPerform,
        DataType timing,
        DataType asNeeded,
        CodeableReference location,
        List<Participant> participant,
        DataType product,
        Quantity quantity,
        List<Dosage> dosage,
        List<CodeableConcept> bodySite,
        List<FhirCanonical> specimenRequirement,
        List<FhirCanonical> observationRequirement,
        List<FhirCanonical> observationResultRequirement,
        FhirCanonical transform,
        List<DynamicValue> dynamicValue) implements DomainResource {

    /**
     * Creates an {@code ActivityDefinition}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a choice element has a type that is not allowed
     */
    public ActivityDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        contact = contact == null ? List.of() : List.copyOf(contact);
        useContext = useContext == null ? List.of() : List.copyOf(useContext);
        jurisdiction = jurisdiction == null ? List.of() : List.copyOf(jurisdiction);
        topic = topic == null ? List.of() : List.copyOf(topic);
        author = author == null ? List.of() : List.copyOf(author);
        editor = editor == null ? List.of() : List.copyOf(editor);
        reviewer = reviewer == null ? List.of() : List.copyOf(reviewer);
        endorser = endorser == null ? List.of() : List.copyOf(endorser);
        relatedArtifact = relatedArtifact == null ? List.of() : List.copyOf(relatedArtifact);
        library = library == null ? List.of() : List.copyOf(library);
        participant = participant == null ? List.of() : List.copyOf(participant);
        dosage = dosage == null ? List.of() : List.copyOf(dosage);
        bodySite = bodySite == null ? List.of() : List.copyOf(bodySite);
        specimenRequirement = specimenRequirement == null ? List.of() : List.copyOf(specimenRequirement);
        observationRequirement = observationRequirement == null ? List.of() : List.copyOf(observationRequirement);
        observationResultRequirement =
                observationResultRequirement == null ? List.of() : List.copyOf(observationResultRequirement);
        dynamicValue = dynamicValue == null ? List.of() : List.copyOf(dynamicValue);
        Objects.requireNonNull(status, "ActivityDefinition.status is required");
        if (versionAlgorithm != null && !(versionAlgorithm instanceof FhirString
                || versionAlgorithm instanceof Coding)) {
            throw new IllegalArgumentException(
                    "ActivityDefinition.versionAlgorithm[x] must be one of string, Coding, but was "
                            + versionAlgorithm.getClass().getSimpleName());
        }
        if (subject != null && !(subject instanceof CodeableConcept
                || subject instanceof Reference
                || subject instanceof FhirCanonical)) {
            throw new IllegalArgumentException(
                    "ActivityDefinition.subject[x] must be one of CodeableConcept, Reference, canonical, but was "
                            + subject.getClass().getSimpleName());
        }
        if (timing != null && !(timing instanceof Timing
                || timing instanceof Age
                || timing instanceof Range
                || timing instanceof Duration)) {
            throw new IllegalArgumentException(
                    "ActivityDefinition.timing[x] must be one of Timing, Age, Range, Duration, but was "
                            + timing.getClass().getSimpleName());
        }
        if (asNeeded != null && !(asNeeded instanceof FhirBoolean || asNeeded instanceof CodeableConcept)) {
            throw new IllegalArgumentException(
                    "ActivityDefinition.asNeeded[x] must be one of boolean, CodeableConcept, but was "
                            + asNeeded.getClass().getSimpleName());
        }
        if (product != null && !(product instanceof Reference || product instanceof CodeableConcept)) {
            throw new IllegalArgumentException(
                    "ActivityDefinition.product[x] must be one of Reference, CodeableConcept, but was "
                            + product.getClass().getSimpleName());
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
     * Returns a builder initialized with the values of this {@code ActivityDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Indicates who should participate in performing the action described.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type careteam | device | group | healthcareservice | location | organization | patient | practitioner |
     *   practitionerrole | relatedperson.
     * @param typeCanonical Who or what can participate. Canonical reference to CapabilityStatement.
     * @param typeReference Who or what can participate. Reference to CareTeam, Device, DeviceDefinition, Endpoint,
     *   Group, HealthcareService, Location, Organization, Patient, Practitioner, PractitionerRole, RelatedPerson.
     * @param role E.g. Nurse, Surgeon, Parent, etc.
     * @param function E.g. Author, Reviewer, Witness, etc.
     */
    public record Participant(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<ActionParticipantType> type,
            FhirCanonical typeCanonical,
            Reference typeReference,
            CodeableConcept role,
            CodeableConcept function) implements BackboneElement {

        /**
         * Creates a {@code Participant}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Participant {
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
         * Returns a builder initialized with the values of this {@code Participant}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Participant}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<ActionParticipantType> type;
            private FhirCanonical typeCanonical;
            private Reference typeReference;
            private CodeableConcept role;
            private CodeableConcept function;

            private Builder() {
            }

            private Builder(Participant original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.typeCanonical = original.typeCanonical();
                this.typeReference = original.typeReference();
                this.role = original.role();
                this.function = original.function();
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
            public Builder type(FhirEnum<ActionParticipantType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(ActionParticipantType type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Sets {@code typeCanonical}.
             *
             * @param typeCanonical the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder typeCanonical(FhirCanonical typeCanonical) {
                this.typeCanonical = typeCanonical;
                return this;
            }

            /**
             * Sets {@code typeCanonical}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param typeCanonical the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder typeCanonical(String typeCanonical) {
                return typeCanonical(typeCanonical == null ? null : FhirCanonical.of(typeCanonical));
            }

            /**
             * Sets {@code typeReference}.
             *
             * @param typeReference the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder typeReference(Reference typeReference) {
                this.typeReference = typeReference;
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
             * Sets {@code function}.
             *
             * @param function the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder function(CodeableConcept function) {
                this.function = function;
                return this;
            }

            /**
             * Builds the {@code Participant}.
             *
             * @return the {@code Participant}
             */
            public Participant build() {
                return new Participant(
                        id, extension, modifierExtension, type, typeCanonical, typeReference, role, function);
            }
        }
    }

    /**
     * Dynamic values that will be evaluated to produce values for elements of the resulting resource.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param path The path to the element to be set dynamically. Required.
     * @param expression An expression that provides the dynamic value for the customization. Required.
     */
    public record DynamicValue(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString path,
            Expression expression) implements BackboneElement {

        /**
         * Creates a {@code DynamicValue}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public DynamicValue {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(path, "ActivityDefinition.dynamicValue.path is required");
            Objects.requireNonNull(expression, "ActivityDefinition.dynamicValue.expression is required");
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
         * Returns a builder initialized with the values of this {@code DynamicValue}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link DynamicValue}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString path;
            private Expression expression;

            private Builder() {
            }

            private Builder(DynamicValue original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.path = original.path();
                this.expression = original.expression();
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
             * Sets {@code path}.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(FhirString path) {
                this.path = path;
                return this;
            }

            /**
             * Sets {@code path}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param path the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder path(String path) {
                return path(path == null ? null : FhirString.of(path));
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
             * Builds the {@code DynamicValue}.
             *
             * @return the {@code DynamicValue}
             * @throws NullPointerException if a required element is absent
             */
            public DynamicValue build() {
                return new DynamicValue(
                        id, extension, modifierExtension, path, expression);
            }
        }
    }

    /** Builder for {@link ActivityDefinition}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirUri url;
        private List<Identifier> identifier = new ArrayList<>();
        private FhirString version;
        private DataType versionAlgorithm;
        private FhirString name;
        private FhirString title;
        private FhirString subtitle;
        private FhirEnum<PublicationStatus> status;
        private FhirBoolean experimental;
        private DataType subject;
        private FhirDateTime date;
        private FhirString publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private FhirMarkdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private FhirMarkdown purpose;
        private FhirMarkdown usage;
        private FhirMarkdown copyright;
        private FhirString copyrightLabel;
        private FhirDate approvalDate;
        private FhirDate lastReviewDate;
        private Period effectivePeriod;
        private List<CodeableConcept> topic = new ArrayList<>();
        private List<ContactDetail> author = new ArrayList<>();
        private List<ContactDetail> editor = new ArrayList<>();
        private List<ContactDetail> reviewer = new ArrayList<>();
        private List<ContactDetail> endorser = new ArrayList<>();
        private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
        private List<FhirCanonical> library = new ArrayList<>();
        private FhirEnum<RequestResourceTypes> kind;
        private FhirCanonical profile;
        private CodeableConcept code;
        private FhirEnum<RequestIntent> intent;
        private FhirEnum<RequestPriority> priority;
        private FhirBoolean doNotPerform;
        private DataType timing;
        private DataType asNeeded;
        private CodeableReference location;
        private List<Participant> participant = new ArrayList<>();
        private DataType product;
        private Quantity quantity;
        private List<Dosage> dosage = new ArrayList<>();
        private List<CodeableConcept> bodySite = new ArrayList<>();
        private List<FhirCanonical> specimenRequirement = new ArrayList<>();
        private List<FhirCanonical> observationRequirement = new ArrayList<>();
        private List<FhirCanonical> observationResultRequirement = new ArrayList<>();
        private FhirCanonical transform;
        private List<DynamicValue> dynamicValue = new ArrayList<>();

        private Builder() {
        }

        private Builder(ActivityDefinition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.url = original.url();
            this.identifier = new ArrayList<>(original.identifier());
            this.version = original.version();
            this.versionAlgorithm = original.versionAlgorithm();
            this.name = original.name();
            this.title = original.title();
            this.subtitle = original.subtitle();
            this.status = original.status();
            this.experimental = original.experimental();
            this.subject = original.subject();
            this.date = original.date();
            this.publisher = original.publisher();
            this.contact = new ArrayList<>(original.contact());
            this.description = original.description();
            this.useContext = new ArrayList<>(original.useContext());
            this.jurisdiction = new ArrayList<>(original.jurisdiction());
            this.purpose = original.purpose();
            this.usage = original.usage();
            this.copyright = original.copyright();
            this.copyrightLabel = original.copyrightLabel();
            this.approvalDate = original.approvalDate();
            this.lastReviewDate = original.lastReviewDate();
            this.effectivePeriod = original.effectivePeriod();
            this.topic = new ArrayList<>(original.topic());
            this.author = new ArrayList<>(original.author());
            this.editor = new ArrayList<>(original.editor());
            this.reviewer = new ArrayList<>(original.reviewer());
            this.endorser = new ArrayList<>(original.endorser());
            this.relatedArtifact = new ArrayList<>(original.relatedArtifact());
            this.library = new ArrayList<>(original.library());
            this.kind = original.kind();
            this.profile = original.profile();
            this.code = original.code();
            this.intent = original.intent();
            this.priority = original.priority();
            this.doNotPerform = original.doNotPerform();
            this.timing = original.timing();
            this.asNeeded = original.asNeeded();
            this.location = original.location();
            this.participant = new ArrayList<>(original.participant());
            this.product = original.product();
            this.quantity = original.quantity();
            this.dosage = new ArrayList<>(original.dosage());
            this.bodySite = new ArrayList<>(original.bodySite());
            this.specimenRequirement = new ArrayList<>(original.specimenRequirement());
            this.observationRequirement = new ArrayList<>(original.observationRequirement());
            this.observationResultRequirement = new ArrayList<>(original.observationResultRequirement());
            this.transform = original.transform();
            this.dynamicValue = new ArrayList<>(original.dynamicValue());
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
         * Sets {@code versionAlgorithm} to a string.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(FhirString versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a Coding.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(Coding versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm;
            return this;
        }

        /**
         * Sets {@code versionAlgorithm} to a string without id or extensions.
         *
         * @param versionAlgorithm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder versionAlgorithm(String versionAlgorithm) {
            this.versionAlgorithm = versionAlgorithm == null ? null : FhirString.of(versionAlgorithm);
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<PublicationStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(PublicationStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code experimental}.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(FhirBoolean experimental) {
            this.experimental = experimental;
            return this;
        }

        /**
         * Sets {@code experimental}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param experimental the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder experimental(Boolean experimental) {
            return experimental(experimental == null ? null : FhirBoolean.of(experimental));
        }

        /**
         * Sets {@code subject} to a CodeableConcept.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(CodeableConcept subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets {@code subject} to a Reference.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(Reference subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets {@code subject} to a canonical.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(FhirCanonical subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets {@code subject} to a canonical without id or extensions.
         *
         * @param subject the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subject(String subject) {
            this.subject = subject == null ? null : FhirCanonical.of(subject);
            return this;
        }

        /**
         * Sets {@code date}.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(FhirDateTime date) {
            this.date = date;
            return this;
        }

        /**
         * Sets {@code date}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param date the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder date(Temporal date) {
            return date(date == null ? null : FhirDateTime.of(date));
        }

        /**
         * Sets {@code publisher}.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(FhirString publisher) {
            this.publisher = publisher;
            return this;
        }

        /**
         * Sets {@code publisher}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param publisher the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder publisher(String publisher) {
            return publisher(publisher == null ? null : FhirString.of(publisher));
        }

        /**
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<ContactDetail> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(ContactDetail contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
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
         * Replaces all {@code useContext} values.
         *
         * @param useContext the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder useContext(List<UsageContext> useContext) {
            this.useContext = useContext == null ? new ArrayList<>() : new ArrayList<>(useContext);
            return this;
        }

        /**
         * Adds a {@code useContext} value.
         *
         * @param useContext the value to add
         * @return this builder
         */
        public Builder addUseContext(UsageContext useContext) {
            this.useContext.add(Objects.requireNonNull(useContext, "useContext"));
            return this;
        }

        /**
         * Replaces all {@code jurisdiction} values.
         *
         * @param jurisdiction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder jurisdiction(List<CodeableConcept> jurisdiction) {
            this.jurisdiction = jurisdiction == null ? new ArrayList<>() : new ArrayList<>(jurisdiction);
            return this;
        }

        /**
         * Adds a {@code jurisdiction} value.
         *
         * @param jurisdiction the value to add
         * @return this builder
         */
        public Builder addJurisdiction(CodeableConcept jurisdiction) {
            this.jurisdiction.add(Objects.requireNonNull(jurisdiction, "jurisdiction"));
            return this;
        }

        /**
         * Sets {@code purpose}.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(FhirMarkdown purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * Sets {@code purpose}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param purpose the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder purpose(String purpose) {
            return purpose(purpose == null ? null : FhirMarkdown.of(purpose));
        }

        /**
         * Sets {@code usage}.
         *
         * @param usage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder usage(FhirMarkdown usage) {
            this.usage = usage;
            return this;
        }

        /**
         * Sets {@code usage}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param usage the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder usage(String usage) {
            return usage(usage == null ? null : FhirMarkdown.of(usage));
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
         * Sets {@code copyrightLabel}.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(FhirString copyrightLabel) {
            this.copyrightLabel = copyrightLabel;
            return this;
        }

        /**
         * Sets {@code copyrightLabel}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param copyrightLabel the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder copyrightLabel(String copyrightLabel) {
            return copyrightLabel(copyrightLabel == null ? null : FhirString.of(copyrightLabel));
        }

        /**
         * Sets {@code approvalDate}.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(FhirDate approvalDate) {
            this.approvalDate = approvalDate;
            return this;
        }

        /**
         * Sets {@code approvalDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param approvalDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder approvalDate(Temporal approvalDate) {
            return approvalDate(approvalDate == null ? null : FhirDate.of(approvalDate));
        }

        /**
         * Sets {@code lastReviewDate}.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(FhirDate lastReviewDate) {
            this.lastReviewDate = lastReviewDate;
            return this;
        }

        /**
         * Sets {@code lastReviewDate}, wrapped in a {@link FhirDate} without id or extensions.
         *
         * @param lastReviewDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder lastReviewDate(Temporal lastReviewDate) {
            return lastReviewDate(lastReviewDate == null ? null : FhirDate.of(lastReviewDate));
        }

        /**
         * Sets {@code effectivePeriod}.
         *
         * @param effectivePeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder effectivePeriod(Period effectivePeriod) {
            this.effectivePeriod = effectivePeriod;
            return this;
        }

        /**
         * Replaces all {@code topic} values.
         *
         * @param topic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder topic(List<CodeableConcept> topic) {
            this.topic = topic == null ? new ArrayList<>() : new ArrayList<>(topic);
            return this;
        }

        /**
         * Adds a {@code topic} value.
         *
         * @param topic the value to add
         * @return this builder
         */
        public Builder addTopic(CodeableConcept topic) {
            this.topic.add(Objects.requireNonNull(topic, "topic"));
            return this;
        }

        /**
         * Replaces all {@code author} values.
         *
         * @param author the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder author(List<ContactDetail> author) {
            this.author = author == null ? new ArrayList<>() : new ArrayList<>(author);
            return this;
        }

        /**
         * Adds a {@code author} value.
         *
         * @param author the value to add
         * @return this builder
         */
        public Builder addAuthor(ContactDetail author) {
            this.author.add(Objects.requireNonNull(author, "author"));
            return this;
        }

        /**
         * Replaces all {@code editor} values.
         *
         * @param editor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder editor(List<ContactDetail> editor) {
            this.editor = editor == null ? new ArrayList<>() : new ArrayList<>(editor);
            return this;
        }

        /**
         * Adds a {@code editor} value.
         *
         * @param editor the value to add
         * @return this builder
         */
        public Builder addEditor(ContactDetail editor) {
            this.editor.add(Objects.requireNonNull(editor, "editor"));
            return this;
        }

        /**
         * Replaces all {@code reviewer} values.
         *
         * @param reviewer the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder reviewer(List<ContactDetail> reviewer) {
            this.reviewer = reviewer == null ? new ArrayList<>() : new ArrayList<>(reviewer);
            return this;
        }

        /**
         * Adds a {@code reviewer} value.
         *
         * @param reviewer the value to add
         * @return this builder
         */
        public Builder addReviewer(ContactDetail reviewer) {
            this.reviewer.add(Objects.requireNonNull(reviewer, "reviewer"));
            return this;
        }

        /**
         * Replaces all {@code endorser} values.
         *
         * @param endorser the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder endorser(List<ContactDetail> endorser) {
            this.endorser = endorser == null ? new ArrayList<>() : new ArrayList<>(endorser);
            return this;
        }

        /**
         * Adds a {@code endorser} value.
         *
         * @param endorser the value to add
         * @return this builder
         */
        public Builder addEndorser(ContactDetail endorser) {
            this.endorser.add(Objects.requireNonNull(endorser, "endorser"));
            return this;
        }

        /**
         * Replaces all {@code relatedArtifact} values.
         *
         * @param relatedArtifact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder relatedArtifact(List<RelatedArtifact> relatedArtifact) {
            this.relatedArtifact = relatedArtifact == null ? new ArrayList<>() : new ArrayList<>(relatedArtifact);
            return this;
        }

        /**
         * Adds a {@code relatedArtifact} value.
         *
         * @param relatedArtifact the value to add
         * @return this builder
         */
        public Builder addRelatedArtifact(RelatedArtifact relatedArtifact) {
            this.relatedArtifact.add(Objects.requireNonNull(relatedArtifact, "relatedArtifact"));
            return this;
        }

        /**
         * Replaces all {@code library} values.
         *
         * @param library the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder library(List<FhirCanonical> library) {
            this.library = library == null ? new ArrayList<>() : new ArrayList<>(library);
            return this;
        }

        /**
         * Adds a {@code library} value.
         *
         * @param library the value to add
         * @return this builder
         */
        public Builder addLibrary(FhirCanonical library) {
            this.library.add(Objects.requireNonNull(library, "library"));
            return this;
        }

        /**
         * Adds a {@code library} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param library the value to add
         * @return this builder
         */
        public Builder addLibrary(String library) {
            return addLibrary(FhirCanonical.of(library));
        }

        /**
         * Sets {@code kind}.
         *
         * @param kind the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder kind(FhirEnum<RequestResourceTypes> kind) {
            this.kind = kind;
            return this;
        }

        /**
         * Sets {@code kind}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param kind the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder kind(RequestResourceTypes kind) {
            return kind(kind == null ? null : FhirEnum.of(kind));
        }

        /**
         * Sets {@code profile}.
         *
         * @param profile the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder profile(FhirCanonical profile) {
            this.profile = profile;
            return this;
        }

        /**
         * Sets {@code profile}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param profile the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder profile(String profile) {
            return profile(profile == null ? null : FhirCanonical.of(profile));
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
         * Sets {@code intent}.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(FhirEnum<RequestIntent> intent) {
            this.intent = intent;
            return this;
        }

        /**
         * Sets {@code intent}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param intent the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder intent(RequestIntent intent) {
            return intent(intent == null ? null : FhirEnum.of(intent));
        }

        /**
         * Sets {@code priority}.
         *
         * @param priority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priority(FhirEnum<RequestPriority> priority) {
            this.priority = priority;
            return this;
        }

        /**
         * Sets {@code priority}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param priority the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder priority(RequestPriority priority) {
            return priority(priority == null ? null : FhirEnum.of(priority));
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
         * Sets {@code timing} to a Timing.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(Timing timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets {@code timing} to a Age.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(Age timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets {@code timing} to a Range.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(Range timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets {@code timing} to a Duration.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(Duration timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets {@code asNeeded} to a boolean.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(FhirBoolean asNeeded) {
            this.asNeeded = asNeeded;
            return this;
        }

        /**
         * Sets {@code asNeeded} to a CodeableConcept.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(CodeableConcept asNeeded) {
            this.asNeeded = asNeeded;
            return this;
        }

        /**
         * Sets {@code asNeeded} to a boolean without id or extensions.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(Boolean asNeeded) {
            this.asNeeded = asNeeded == null ? null : FhirBoolean.of(asNeeded);
            return this;
        }

        /**
         * Sets {@code location}.
         *
         * @param location the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder location(CodeableReference location) {
            this.location = location;
            return this;
        }

        /**
         * Replaces all {@code participant} values.
         *
         * @param participant the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder participant(List<Participant> participant) {
            this.participant = participant == null ? new ArrayList<>() : new ArrayList<>(participant);
            return this;
        }

        /**
         * Adds a {@code participant} value.
         *
         * @param participant the value to add
         * @return this builder
         */
        public Builder addParticipant(Participant participant) {
            this.participant.add(Objects.requireNonNull(participant, "participant"));
            return this;
        }

        /**
         * Sets {@code product} to a Reference.
         *
         * @param product the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder product(Reference product) {
            this.product = product;
            return this;
        }

        /**
         * Sets {@code product} to a CodeableConcept.
         *
         * @param product the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder product(CodeableConcept product) {
            this.product = product;
            return this;
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
         * Replaces all {@code dosage} values.
         *
         * @param dosage the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder dosage(List<Dosage> dosage) {
            this.dosage = dosage == null ? new ArrayList<>() : new ArrayList<>(dosage);
            return this;
        }

        /**
         * Adds a {@code dosage} value.
         *
         * @param dosage the value to add
         * @return this builder
         */
        public Builder addDosage(Dosage dosage) {
            this.dosage.add(Objects.requireNonNull(dosage, "dosage"));
            return this;
        }

        /**
         * Replaces all {@code bodySite} values.
         *
         * @param bodySite the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder bodySite(List<CodeableConcept> bodySite) {
            this.bodySite = bodySite == null ? new ArrayList<>() : new ArrayList<>(bodySite);
            return this;
        }

        /**
         * Adds a {@code bodySite} value.
         *
         * @param bodySite the value to add
         * @return this builder
         */
        public Builder addBodySite(CodeableConcept bodySite) {
            this.bodySite.add(Objects.requireNonNull(bodySite, "bodySite"));
            return this;
        }

        /**
         * Replaces all {@code specimenRequirement} values.
         *
         * @param specimenRequirement the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder specimenRequirement(List<FhirCanonical> specimenRequirement) {
            this.specimenRequirement = specimenRequirement == null
                    ? new ArrayList<>()
                    : new ArrayList<>(specimenRequirement);
            return this;
        }

        /**
         * Adds a {@code specimenRequirement} value.
         *
         * @param specimenRequirement the value to add
         * @return this builder
         */
        public Builder addSpecimenRequirement(FhirCanonical specimenRequirement) {
            this.specimenRequirement.add(Objects.requireNonNull(specimenRequirement, "specimenRequirement"));
            return this;
        }

        /**
         * Adds a {@code specimenRequirement} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param specimenRequirement the value to add
         * @return this builder
         */
        public Builder addSpecimenRequirement(String specimenRequirement) {
            return addSpecimenRequirement(FhirCanonical.of(specimenRequirement));
        }

        /**
         * Replaces all {@code observationRequirement} values.
         *
         * @param observationRequirement the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder observationRequirement(List<FhirCanonical> observationRequirement) {
            this.observationRequirement = observationRequirement == null
                    ? new ArrayList<>()
                    : new ArrayList<>(observationRequirement);
            return this;
        }

        /**
         * Adds a {@code observationRequirement} value.
         *
         * @param observationRequirement the value to add
         * @return this builder
         */
        public Builder addObservationRequirement(FhirCanonical observationRequirement) {
            this.observationRequirement.add(Objects.requireNonNull(observationRequirement, "observationRequirement"));
            return this;
        }

        /**
         * Adds a {@code observationRequirement} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param observationRequirement the value to add
         * @return this builder
         */
        public Builder addObservationRequirement(String observationRequirement) {
            return addObservationRequirement(FhirCanonical.of(observationRequirement));
        }

        /**
         * Replaces all {@code observationResultRequirement} values.
         *
         * @param observationResultRequirement the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder observationResultRequirement(List<FhirCanonical> observationResultRequirement) {
            this.observationResultRequirement = observationResultRequirement == null
                    ? new ArrayList<>()
                    : new ArrayList<>(observationResultRequirement);
            return this;
        }

        /**
         * Adds a {@code observationResultRequirement} value.
         *
         * @param observationResultRequirement the value to add
         * @return this builder
         */
        public Builder addObservationResultRequirement(FhirCanonical observationResultRequirement) {
            this.observationResultRequirement.add(
                    Objects.requireNonNull(observationResultRequirement, "observationResultRequirement"));
            return this;
        }

        /**
         * Adds a {@code observationResultRequirement} value, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param observationResultRequirement the value to add
         * @return this builder
         */
        public Builder addObservationResultRequirement(String observationResultRequirement) {
            return addObservationResultRequirement(FhirCanonical.of(observationResultRequirement));
        }

        /**
         * Sets {@code transform}.
         *
         * @param transform the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder transform(FhirCanonical transform) {
            this.transform = transform;
            return this;
        }

        /**
         * Sets {@code transform}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param transform the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder transform(String transform) {
            return transform(transform == null ? null : FhirCanonical.of(transform));
        }

        /**
         * Replaces all {@code dynamicValue} values.
         *
         * @param dynamicValue the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder dynamicValue(List<DynamicValue> dynamicValue) {
            this.dynamicValue = dynamicValue == null ? new ArrayList<>() : new ArrayList<>(dynamicValue);
            return this;
        }

        /**
         * Adds a {@code dynamicValue} value.
         *
         * @param dynamicValue the value to add
         * @return this builder
         */
        public Builder addDynamicValue(DynamicValue dynamicValue) {
            this.dynamicValue.add(Objects.requireNonNull(dynamicValue, "dynamicValue"));
            return this;
        }

        /**
         * Builds the {@code ActivityDefinition}.
         *
         * @return the {@code ActivityDefinition}
         * @throws NullPointerException if a required element is absent
         */
        public ActivityDefinition build() {
            return new ActivityDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, url, identifier,
                    version, versionAlgorithm, name, title, subtitle, status, experimental, subject, date, publisher,
                    contact, description, useContext, jurisdiction, purpose, usage, copyright, copyrightLabel,
                    approvalDate, lastReviewDate, effectivePeriod, topic, author, editor, reviewer, endorser,
                    relatedArtifact, library, kind, profile, code, intent, priority, doNotPerform, timing, asNeeded,
                    location, participant, product, quantity, dosage, bodySite, specimenRequirement,
                    observationRequirement, observationResultRequirement, transform, dynamicValue);
        }
    }
}
