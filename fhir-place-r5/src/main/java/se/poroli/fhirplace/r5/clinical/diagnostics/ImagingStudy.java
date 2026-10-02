package se.poroli.fhirplace.r5.clinical.diagnostics;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.ImagingStudyStatus;

/**
 * Representation of the content produced in a DICOM imaging study.
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
 * @param identifier Identifiers for the whole study.
 * @param status registered | available | cancelled | entered-in-error | unknown. Required. Modifier element.
 * @param modality All of the distinct values for series' modalities.
 * @param subject Who or what is the subject of the study. Reference to Patient, Device, Group. Required.
 * @param encounter Encounter with which this imaging study is associated. Reference to Encounter.
 * @param started When the study was started.
 * @param basedOn Request fulfilled. Reference to CarePlan, ServiceRequest, Appointment, AppointmentResponse, Task.
 * @param partOf Part of referenced event. Reference to Procedure.
 * @param referrer Referring physician. Reference to Practitioner, PractitionerRole.
 * @param endpoint Study access endpoint. Reference to Endpoint.
 * @param numberOfSeries Number of Study Related Series.
 * @param numberOfInstances Number of Study Related Instances.
 * @param procedure The performed procedure or code.
 * @param location Where ImagingStudy occurred. Reference to Location.
 * @param reason Why the study was requested / performed.
 * @param note User-defined comments.
 * @param description Institution-generated description.
 * @param series Each study has one or more series of instances.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ImagingStudy">FHIR R5 ImagingStudy</a>
 */
public record ImagingStudy(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<ImagingStudyStatus> status,
        List<CodeableConcept> modality,
        Reference subject,
        Reference encounter,
        FhirDateTime started,
        List<Reference> basedOn,
        List<Reference> partOf,
        Reference referrer,
        List<Reference> endpoint,
        FhirUnsignedInt numberOfSeries,
        FhirUnsignedInt numberOfInstances,
        List<CodeableReference> procedure,
        Reference location,
        List<CodeableReference> reason,
        List<Annotation> note,
        FhirString description,
        List<Series> series) implements DomainResource {

    /**
     * Creates an {@code ImagingStudy}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public ImagingStudy {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        modality = modality == null ? List.of() : List.copyOf(modality);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        partOf = partOf == null ? List.of() : List.copyOf(partOf);
        endpoint = endpoint == null ? List.of() : List.copyOf(endpoint);
        procedure = procedure == null ? List.of() : List.copyOf(procedure);
        reason = reason == null ? List.of() : List.copyOf(reason);
        note = note == null ? List.of() : List.copyOf(note);
        series = series == null ? List.of() : List.copyOf(series);
        Objects.requireNonNull(status, "ImagingStudy.status is required");
        Objects.requireNonNull(subject, "ImagingStudy.subject is required");
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
     * Returns a builder initialized with the values of this {@code ImagingStudy}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Each study has one or more series of images or other content.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param uid DICOM Series Instance UID for the series. Required.
     * @param number Numeric identifier of this series.
     * @param modality The modality used for this series. Required.
     * @param description A short human readable summary of the series.
     * @param numberOfInstances Number of Series Related Instances.
     * @param endpoint Series access endpoint. Reference to Endpoint.
     * @param bodySite Body part examined.
     * @param laterality Body part laterality.
     * @param specimen Specimen imaged. Reference to Specimen.
     * @param started When the series started.
     * @param performer Who performed the series.
     * @param instance A single SOP instance from the series.
     */
    public record Series(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirId uid,
            FhirUnsignedInt number,
            CodeableConcept modality,
            FhirString description,
            FhirUnsignedInt numberOfInstances,
            List<Reference> endpoint,
            CodeableReference bodySite,
            CodeableConcept laterality,
            List<Reference> specimen,
            FhirDateTime started,
            List<Performer> performer,
            List<Instance> instance) implements BackboneElement {

        /**
         * Creates a {@code Series}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Series {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            endpoint = endpoint == null ? List.of() : List.copyOf(endpoint);
            specimen = specimen == null ? List.of() : List.copyOf(specimen);
            performer = performer == null ? List.of() : List.copyOf(performer);
            instance = instance == null ? List.of() : List.copyOf(instance);
            Objects.requireNonNull(uid, "ImagingStudy.series.uid is required");
            Objects.requireNonNull(modality, "ImagingStudy.series.modality is required");
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
         * Returns a builder initialized with the values of this {@code Series}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Indicates who or what performed the series and how they were involved.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param function Type of performance.
         * @param actor Who performed the series. Reference to Practitioner, PractitionerRole, Organization, CareTeam,
         *   Patient, Device, RelatedPerson, HealthcareService. Required.
         */
        public record Performer(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept function,
                Reference actor) implements BackboneElement {

            /**
             * Creates a {@code Performer}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Performer {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(actor, "ImagingStudy.series.performer.actor is required");
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
             * Returns a builder initialized with the values of this {@code Performer}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Performer}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept function;
                private Reference actor;

                private Builder() {
                }

                private Builder(Performer original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.function = original.function();
                    this.actor = original.actor();
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
                 * Sets {@code actor}.
                 *
                 * @param actor the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder actor(Reference actor) {
                    this.actor = actor;
                    return this;
                }

                /**
                 * Builds the {@code Performer}.
                 *
                 * @return the {@code Performer}
                 * @throws NullPointerException if a required element is absent
                 */
                public Performer build() {
                    return new Performer(
                            id, extension, modifierExtension, function, actor);
                }
            }
        }

        /**
         * A single SOP instance within the series, e.g. an image, or presentation state.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param uid DICOM SOP Instance UID. Required.
         * @param sopClass DICOM class type. Required.
         * @param number The number of this instance in the series.
         * @param title Description of instance.
         */
        public record Instance(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirId uid,
                Coding sopClass,
                FhirUnsignedInt number,
                FhirString title) implements BackboneElement {

            /**
             * Creates an {@code Instance}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Instance {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(uid, "ImagingStudy.series.instance.uid is required");
                Objects.requireNonNull(sopClass, "ImagingStudy.series.instance.sopClass is required");
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
             * Returns a builder initialized with the values of this {@code Instance}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Instance}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirId uid;
                private Coding sopClass;
                private FhirUnsignedInt number;
                private FhirString title;

                private Builder() {
                }

                private Builder(Instance original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.uid = original.uid();
                    this.sopClass = original.sopClass();
                    this.number = original.number();
                    this.title = original.title();
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
                 * Sets {@code uid}.
                 *
                 * @param uid the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder uid(FhirId uid) {
                    this.uid = uid;
                    return this;
                }

                /**
                 * Sets {@code uid}, wrapped in a {@link FhirId} without id or extensions.
                 *
                 * @param uid the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder uid(String uid) {
                    return uid(uid == null ? null : FhirId.of(uid));
                }

                /**
                 * Sets {@code sopClass}.
                 *
                 * @param sopClass the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder sopClass(Coding sopClass) {
                    this.sopClass = sopClass;
                    return this;
                }

                /**
                 * Sets {@code number}.
                 *
                 * @param number the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder number(FhirUnsignedInt number) {
                    this.number = number;
                    return this;
                }

                /**
                 * Sets {@code number}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
                 *
                 * @param number the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder number(Integer number) {
                    return number(number == null ? null : FhirUnsignedInt.of(number));
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
                 * Builds the {@code Instance}.
                 *
                 * @return the {@code Instance}
                 * @throws NullPointerException if a required element is absent
                 */
                public Instance build() {
                    return new Instance(
                            id, extension, modifierExtension, uid, sopClass, number, title);
                }
            }
        }

        /** Builder for {@link Series}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirId uid;
            private FhirUnsignedInt number;
            private CodeableConcept modality;
            private FhirString description;
            private FhirUnsignedInt numberOfInstances;
            private List<Reference> endpoint = new ArrayList<>();
            private CodeableReference bodySite;
            private CodeableConcept laterality;
            private List<Reference> specimen = new ArrayList<>();
            private FhirDateTime started;
            private List<Performer> performer = new ArrayList<>();
            private List<Instance> instance = new ArrayList<>();

            private Builder() {
            }

            private Builder(Series original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.uid = original.uid();
                this.number = original.number();
                this.modality = original.modality();
                this.description = original.description();
                this.numberOfInstances = original.numberOfInstances();
                this.endpoint = new ArrayList<>(original.endpoint());
                this.bodySite = original.bodySite();
                this.laterality = original.laterality();
                this.specimen = new ArrayList<>(original.specimen());
                this.started = original.started();
                this.performer = new ArrayList<>(original.performer());
                this.instance = new ArrayList<>(original.instance());
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
             * Sets {@code uid}.
             *
             * @param uid the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder uid(FhirId uid) {
                this.uid = uid;
                return this;
            }

            /**
             * Sets {@code uid}, wrapped in a {@link FhirId} without id or extensions.
             *
             * @param uid the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder uid(String uid) {
                return uid(uid == null ? null : FhirId.of(uid));
            }

            /**
             * Sets {@code number}.
             *
             * @param number the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder number(FhirUnsignedInt number) {
                this.number = number;
                return this;
            }

            /**
             * Sets {@code number}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
             *
             * @param number the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder number(Integer number) {
                return number(number == null ? null : FhirUnsignedInt.of(number));
            }

            /**
             * Sets {@code modality}.
             *
             * @param modality the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder modality(CodeableConcept modality) {
                this.modality = modality;
                return this;
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
             * Sets {@code numberOfInstances}.
             *
             * @param numberOfInstances the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder numberOfInstances(FhirUnsignedInt numberOfInstances) {
                this.numberOfInstances = numberOfInstances;
                return this;
            }

            /**
             * Sets {@code numberOfInstances}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
             *
             * @param numberOfInstances the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder numberOfInstances(Integer numberOfInstances) {
                return numberOfInstances(numberOfInstances == null ? null : FhirUnsignedInt.of(numberOfInstances));
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
             * Sets {@code bodySite}.
             *
             * @param bodySite the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder bodySite(CodeableReference bodySite) {
                this.bodySite = bodySite;
                return this;
            }

            /**
             * Sets {@code laterality}.
             *
             * @param laterality the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder laterality(CodeableConcept laterality) {
                this.laterality = laterality;
                return this;
            }

            /**
             * Replaces all {@code specimen} values.
             *
             * @param specimen the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder specimen(List<Reference> specimen) {
                this.specimen = specimen == null ? new ArrayList<>() : new ArrayList<>(specimen);
                return this;
            }

            /**
             * Adds a {@code specimen} value.
             *
             * @param specimen the value to add
             * @return this builder
             */
            public Builder addSpecimen(Reference specimen) {
                this.specimen.add(Objects.requireNonNull(specimen, "specimen"));
                return this;
            }

            /**
             * Sets {@code started}.
             *
             * @param started the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder started(FhirDateTime started) {
                this.started = started;
                return this;
            }

            /**
             * Sets {@code started}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param started the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder started(Temporal started) {
                return started(started == null ? null : FhirDateTime.of(started));
            }

            /**
             * Replaces all {@code performer} values.
             *
             * @param performer the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder performer(List<Performer> performer) {
                this.performer = performer == null ? new ArrayList<>() : new ArrayList<>(performer);
                return this;
            }

            /**
             * Adds a {@code performer} value.
             *
             * @param performer the value to add
             * @return this builder
             */
            public Builder addPerformer(Performer performer) {
                this.performer.add(Objects.requireNonNull(performer, "performer"));
                return this;
            }

            /**
             * Replaces all {@code instance} values.
             *
             * @param instance the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder instance(List<Instance> instance) {
                this.instance = instance == null ? new ArrayList<>() : new ArrayList<>(instance);
                return this;
            }

            /**
             * Adds a {@code instance} value.
             *
             * @param instance the value to add
             * @return this builder
             */
            public Builder addInstance(Instance instance) {
                this.instance.add(Objects.requireNonNull(instance, "instance"));
                return this;
            }

            /**
             * Builds the {@code Series}.
             *
             * @return the {@code Series}
             * @throws NullPointerException if a required element is absent
             */
            public Series build() {
                return new Series(
                        id, extension, modifierExtension, uid, number, modality, description, numberOfInstances,
                        endpoint, bodySite, laterality, specimen, started, performer, instance);
            }
        }
    }

    /** Builder for {@link ImagingStudy}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<ImagingStudyStatus> status;
        private List<CodeableConcept> modality = new ArrayList<>();
        private Reference subject;
        private Reference encounter;
        private FhirDateTime started;
        private List<Reference> basedOn = new ArrayList<>();
        private List<Reference> partOf = new ArrayList<>();
        private Reference referrer;
        private List<Reference> endpoint = new ArrayList<>();
        private FhirUnsignedInt numberOfSeries;
        private FhirUnsignedInt numberOfInstances;
        private List<CodeableReference> procedure = new ArrayList<>();
        private Reference location;
        private List<CodeableReference> reason = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();
        private FhirString description;
        private List<Series> series = new ArrayList<>();

        private Builder() {
        }

        private Builder(ImagingStudy original) {
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
            this.modality = new ArrayList<>(original.modality());
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.started = original.started();
            this.basedOn = new ArrayList<>(original.basedOn());
            this.partOf = new ArrayList<>(original.partOf());
            this.referrer = original.referrer();
            this.endpoint = new ArrayList<>(original.endpoint());
            this.numberOfSeries = original.numberOfSeries();
            this.numberOfInstances = original.numberOfInstances();
            this.procedure = new ArrayList<>(original.procedure());
            this.location = original.location();
            this.reason = new ArrayList<>(original.reason());
            this.note = new ArrayList<>(original.note());
            this.description = original.description();
            this.series = new ArrayList<>(original.series());
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
        public Builder status(FhirEnum<ImagingStudyStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(ImagingStudyStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Sets {@code encounter}.
         *
         * @param encounter the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder encounter(Reference encounter) {
            this.encounter = encounter;
            return this;
        }

        /**
         * Sets {@code started}.
         *
         * @param started the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder started(FhirDateTime started) {
            this.started = started;
            return this;
        }

        /**
         * Sets {@code started}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param started the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder started(Temporal started) {
            return started(started == null ? null : FhirDateTime.of(started));
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
         * Replaces all {@code partOf} values.
         *
         * @param partOf the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder partOf(List<Reference> partOf) {
            this.partOf = partOf == null ? new ArrayList<>() : new ArrayList<>(partOf);
            return this;
        }

        /**
         * Adds a {@code partOf} value.
         *
         * @param partOf the value to add
         * @return this builder
         */
        public Builder addPartOf(Reference partOf) {
            this.partOf.add(Objects.requireNonNull(partOf, "partOf"));
            return this;
        }

        /**
         * Sets {@code referrer}.
         *
         * @param referrer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder referrer(Reference referrer) {
            this.referrer = referrer;
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
         * Sets {@code numberOfSeries}.
         *
         * @param numberOfSeries the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder numberOfSeries(FhirUnsignedInt numberOfSeries) {
            this.numberOfSeries = numberOfSeries;
            return this;
        }

        /**
         * Sets {@code numberOfSeries}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
         *
         * @param numberOfSeries the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder numberOfSeries(Integer numberOfSeries) {
            return numberOfSeries(numberOfSeries == null ? null : FhirUnsignedInt.of(numberOfSeries));
        }

        /**
         * Sets {@code numberOfInstances}.
         *
         * @param numberOfInstances the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder numberOfInstances(FhirUnsignedInt numberOfInstances) {
            this.numberOfInstances = numberOfInstances;
            return this;
        }

        /**
         * Sets {@code numberOfInstances}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
         *
         * @param numberOfInstances the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder numberOfInstances(Integer numberOfInstances) {
            return numberOfInstances(numberOfInstances == null ? null : FhirUnsignedInt.of(numberOfInstances));
        }

        /**
         * Replaces all {@code procedure} values.
         *
         * @param procedure the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder procedure(List<CodeableReference> procedure) {
            this.procedure = procedure == null ? new ArrayList<>() : new ArrayList<>(procedure);
            return this;
        }

        /**
         * Adds a {@code procedure} value.
         *
         * @param procedure the value to add
         * @return this builder
         */
        public Builder addProcedure(CodeableReference procedure) {
            this.procedure.add(Objects.requireNonNull(procedure, "procedure"));
            return this;
        }

        /**
         * Sets {@code location}.
         *
         * @param location the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder location(Reference location) {
            this.location = location;
            return this;
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
         * Replaces all {@code series} values.
         *
         * @param series the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder series(List<Series> series) {
            this.series = series == null ? new ArrayList<>() : new ArrayList<>(series);
            return this;
        }

        /**
         * Adds a {@code series} value.
         *
         * @param series the value to add
         * @return this builder
         */
        public Builder addSeries(Series series) {
            this.series.add(Objects.requireNonNull(series, "series"));
            return this;
        }

        /**
         * Builds the {@code ImagingStudy}.
         *
         * @return the {@code ImagingStudy}
         * @throws NullPointerException if a required element is absent
         */
        public ImagingStudy build() {
            return new ImagingStudy(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, modality, subject, encounter, started, basedOn, partOf, referrer, endpoint,
                    numberOfSeries, numberOfInstances, procedure, location, reason, note, description, series);
        }
    }
}
