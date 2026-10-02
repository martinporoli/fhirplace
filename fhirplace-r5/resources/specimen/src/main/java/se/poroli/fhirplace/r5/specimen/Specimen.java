package se.poroli.fhirplace.r5.specimen;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
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
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * A sample to be used for analysis.
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
 * @param identifier External Identifier.
 * @param accessionIdentifier Identifier assigned by the lab.
 * @param status available | unavailable | unsatisfactory | entered-in-error. Modifier element.
 * @param type Kind of material that forms the specimen.
 * @param subject Where the specimen came from. This may be from patient(s), from a location (e.g., the source of an
 *   environmental sample), or a sampling of a substance, a biologically-derived product, or a device. Reference to
 *   Patient, Group, Device, BiologicallyDerivedProduct, Substance, Location.
 * @param receivedTime The time when specimen is received by the testing laboratory.
 * @param parent Specimen from which this specimen originated. Reference to Specimen.
 * @param request Why the specimen was collected. Reference to ServiceRequest.
 * @param combined grouped | pooled.
 * @param role The role the specimen serves.
 * @param feature The physical feature of a specimen.
 * @param collection Collection details.
 * @param processing Processing and processing step details.
 * @param container Direct container of specimen (tube/slide, etc.).
 * @param condition State of the specimen.
 * @param note Comments.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Specimen">FHIR R5 Specimen</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record Specimen(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        Identifier accessionIdentifier,
        FhirEnum<SpecimenStatus> status,
        CodeableConcept type,
        Reference subject,
        FhirDateTime receivedTime,
        List<Reference> parent,
        List<Reference> request,
        FhirEnum<SpecimenCombined> combined,
        List<CodeableConcept> role,
        List<Feature> feature,
        Collection collection,
        List<Processing> processing,
        List<Container> container,
        List<CodeableConcept> condition,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates a {@code Specimen}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Specimen {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        parent = parent == null ? List.of() : List.copyOf(parent);
        request = request == null ? List.of() : List.copyOf(request);
        role = role == null ? List.of() : List.copyOf(role);
        feature = feature == null ? List.of() : List.copyOf(feature);
        processing = processing == null ? List.of() : List.copyOf(processing);
        container = container == null ? List.of() : List.copyOf(container);
        condition = condition == null ? List.of() : List.copyOf(condition);
        note = note == null ? List.of() : List.copyOf(note);
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
     * Returns a builder initialized with the values of this {@code Specimen}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A physical feature or landmark on a specimen, highlighted for context by the collector of the specimen (e.g.
     * surgeon), that identifies the type of feature as well as its meaning (e.g. the red ink indicating the resection
     * margin of the right lobe of the excised prostate tissue or wire loop at radiologically suspected tumor
     * location).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Highlighted feature. Required.
     * @param description Information about the feature. Required.
     */
    public record Feature(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            FhirString description) implements BackboneElement {

        /**
         * Creates a {@code Feature}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Feature {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "Specimen.feature.type is required");
            Objects.requireNonNull(description, "Specimen.feature.description is required");
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
         * Returns a builder initialized with the values of this {@code Feature}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Feature}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private FhirString description;

            private Builder() {
            }

            private Builder(Feature original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.description = original.description();
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
             * Builds the {@code Feature}.
             *
             * @return the {@code Feature}
             * @throws NullPointerException if a required element is absent
             */
            public Feature build() {
                return new Feature(
                        id, extension, modifierExtension, type, description);
            }
        }
    }

    /**
     * Details concerning the specimen collection.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param collector Who collected the specimen. Reference to Practitioner, PractitionerRole, Patient,
     *   RelatedPerson.
     * @param collected Collection time. One of dateTime, Period.
     * @param duration How long it took to collect specimen.
     * @param quantity The quantity of specimen collected.
     * @param method Technique used to perform collection.
     * @param device Device used to perform collection.
     * @param procedure The procedure that collects the specimen. Reference to Procedure.
     * @param bodySite Anatomical collection site.
     * @param fastingStatus Whether or how long patient abstained from food and/or drink. One of CodeableConcept,
     *   Duration.
     */
    public record Collection(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference collector,
            DataType collected,
            Duration duration,
            Quantity quantity,
            CodeableConcept method,
            CodeableReference device,
            Reference procedure,
            CodeableReference bodySite,
            DataType fastingStatus) implements BackboneElement {

        /**
         * Creates a {@code Collection}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Collection {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            if (collected != null && !(collected instanceof FhirDateTime || collected instanceof Period)) {
                throw new IllegalArgumentException(
                        "Specimen.collection.collected[x] must be one of dateTime, Period, but was "
                                + collected.getClass().getSimpleName());
            }
            if (fastingStatus != null && !(fastingStatus instanceof CodeableConcept
                    || fastingStatus instanceof Duration)) {
                throw new IllegalArgumentException(
                        "Specimen.collection.fastingStatus[x] must be one of CodeableConcept, Duration, but was "
                                + fastingStatus.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Collection}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Collection}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference collector;
            private DataType collected;
            private Duration duration;
            private Quantity quantity;
            private CodeableConcept method;
            private CodeableReference device;
            private Reference procedure;
            private CodeableReference bodySite;
            private DataType fastingStatus;

            private Builder() {
            }

            private Builder(Collection original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.collector = original.collector();
                this.collected = original.collected();
                this.duration = original.duration();
                this.quantity = original.quantity();
                this.method = original.method();
                this.device = original.device();
                this.procedure = original.procedure();
                this.bodySite = original.bodySite();
                this.fastingStatus = original.fastingStatus();
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
             * Sets {@code collector}.
             *
             * @param collector the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder collector(Reference collector) {
                this.collector = collector;
                return this;
            }

            /**
             * Sets {@code collected} to a dateTime.
             *
             * @param collected the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder collected(FhirDateTime collected) {
                this.collected = collected;
                return this;
            }

            /**
             * Sets {@code collected} to a Period.
             *
             * @param collected the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder collected(Period collected) {
                this.collected = collected;
                return this;
            }

            /**
             * Sets {@code collected} to a dateTime without id or extensions.
             *
             * @param collected the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder collected(Temporal collected) {
                this.collected = collected == null ? null : FhirDateTime.of(collected);
                return this;
            }

            /**
             * Sets {@code duration}.
             *
             * @param duration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder duration(Duration duration) {
                this.duration = duration;
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
             * Sets {@code method}.
             *
             * @param method the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder method(CodeableConcept method) {
                this.method = method;
                return this;
            }

            /**
             * Sets {@code device}.
             *
             * @param device the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder device(CodeableReference device) {
                this.device = device;
                return this;
            }

            /**
             * Sets {@code procedure}.
             *
             * @param procedure the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder procedure(Reference procedure) {
                this.procedure = procedure;
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
             * Sets {@code fastingStatus} to a CodeableConcept.
             *
             * @param fastingStatus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder fastingStatus(CodeableConcept fastingStatus) {
                this.fastingStatus = fastingStatus;
                return this;
            }

            /**
             * Sets {@code fastingStatus} to a Duration.
             *
             * @param fastingStatus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder fastingStatus(Duration fastingStatus) {
                this.fastingStatus = fastingStatus;
                return this;
            }

            /**
             * Builds the {@code Collection}.
             *
             * @return the {@code Collection}
             */
            public Collection build() {
                return new Collection(
                        id, extension, modifierExtension, collector, collected, duration, quantity, method, device,
                        procedure, bodySite, fastingStatus);
            }
        }
    }

    /**
     * Details concerning processing and processing steps for the specimen.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param description Textual description of procedure.
     * @param method Indicates the treatment step applied to the specimen.
     * @param additive Material used in the processing step. Reference to Substance.
     * @param time Date and time of specimen processing. One of dateTime, Period.
     */
    public record Processing(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString description,
            CodeableConcept method,
            List<Reference> additive,
            DataType time) implements BackboneElement {

        /**
         * Creates a {@code Processing}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Processing {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            additive = additive == null ? List.of() : List.copyOf(additive);
            if (time != null && !(time instanceof FhirDateTime || time instanceof Period)) {
                throw new IllegalArgumentException(
                        "Specimen.processing.time[x] must be one of dateTime, Period, but was "
                                + time.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Processing}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Processing}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString description;
            private CodeableConcept method;
            private List<Reference> additive = new ArrayList<>();
            private DataType time;

            private Builder() {
            }

            private Builder(Processing original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.description = original.description();
                this.method = original.method();
                this.additive = new ArrayList<>(original.additive());
                this.time = original.time();
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
             * Sets {@code method}.
             *
             * @param method the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder method(CodeableConcept method) {
                this.method = method;
                return this;
            }

            /**
             * Replaces all {@code additive} values.
             *
             * @param additive the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder additive(List<Reference> additive) {
                this.additive = additive == null ? new ArrayList<>() : new ArrayList<>(additive);
                return this;
            }

            /**
             * Adds a {@code additive} value.
             *
             * @param additive the value to add
             * @return this builder
             */
            public Builder addAdditive(Reference additive) {
                this.additive.add(Objects.requireNonNull(additive, "additive"));
                return this;
            }

            /**
             * Sets {@code time} to a dateTime.
             *
             * @param time the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder time(FhirDateTime time) {
                this.time = time;
                return this;
            }

            /**
             * Sets {@code time} to a Period.
             *
             * @param time the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder time(Period time) {
                this.time = time;
                return this;
            }

            /**
             * Sets {@code time} to a dateTime without id or extensions.
             *
             * @param time the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder time(Temporal time) {
                this.time = time == null ? null : FhirDateTime.of(time);
                return this;
            }

            /**
             * Builds the {@code Processing}.
             *
             * @return the {@code Processing}
             */
            public Processing build() {
                return new Processing(
                        id, extension, modifierExtension, description, method, additive, time);
            }
        }
    }

    /**
     * The container holding the specimen.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param device Device resource for the container. Reference to Device. Required.
     * @param location Where the container is. Reference to Location.
     * @param specimenQuantity Quantity of specimen within container.
     */
    public record Container(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference device,
            Reference location,
            Quantity specimenQuantity) implements BackboneElement {

        /**
         * Creates a {@code Container}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Container {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(device, "Specimen.container.device is required");
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
         * Returns a builder initialized with the values of this {@code Container}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Container}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference device;
            private Reference location;
            private Quantity specimenQuantity;

            private Builder() {
            }

            private Builder(Container original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.device = original.device();
                this.location = original.location();
                this.specimenQuantity = original.specimenQuantity();
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
             * Sets {@code device}.
             *
             * @param device the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder device(Reference device) {
                this.device = device;
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
             * Sets {@code specimenQuantity}.
             *
             * @param specimenQuantity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder specimenQuantity(Quantity specimenQuantity) {
                this.specimenQuantity = specimenQuantity;
                return this;
            }

            /**
             * Builds the {@code Container}.
             *
             * @return the {@code Container}
             * @throws NullPointerException if a required element is absent
             */
            public Container build() {
                return new Container(
                        id, extension, modifierExtension, device, location, specimenQuantity);
            }
        }
    }

    /** Builder for {@link Specimen}. Builders are mutable and not thread-safe. */
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
        private Identifier accessionIdentifier;
        private FhirEnum<SpecimenStatus> status;
        private CodeableConcept type;
        private Reference subject;
        private FhirDateTime receivedTime;
        private List<Reference> parent = new ArrayList<>();
        private List<Reference> request = new ArrayList<>();
        private FhirEnum<SpecimenCombined> combined;
        private List<CodeableConcept> role = new ArrayList<>();
        private List<Feature> feature = new ArrayList<>();
        private Collection collection;
        private List<Processing> processing = new ArrayList<>();
        private List<Container> container = new ArrayList<>();
        private List<CodeableConcept> condition = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(Specimen original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.accessionIdentifier = original.accessionIdentifier();
            this.status = original.status();
            this.type = original.type();
            this.subject = original.subject();
            this.receivedTime = original.receivedTime();
            this.parent = new ArrayList<>(original.parent());
            this.request = new ArrayList<>(original.request());
            this.combined = original.combined();
            this.role = new ArrayList<>(original.role());
            this.feature = new ArrayList<>(original.feature());
            this.collection = original.collection();
            this.processing = new ArrayList<>(original.processing());
            this.container = new ArrayList<>(original.container());
            this.condition = new ArrayList<>(original.condition());
            this.note = new ArrayList<>(original.note());
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
         * Sets {@code accessionIdentifier}.
         *
         * @param accessionIdentifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder accessionIdentifier(Identifier accessionIdentifier) {
            this.accessionIdentifier = accessionIdentifier;
            return this;
        }

        /**
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<SpecimenStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(SpecimenStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Sets {@code receivedTime}.
         *
         * @param receivedTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder receivedTime(FhirDateTime receivedTime) {
            this.receivedTime = receivedTime;
            return this;
        }

        /**
         * Sets {@code receivedTime}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param receivedTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder receivedTime(Temporal receivedTime) {
            return receivedTime(receivedTime == null ? null : FhirDateTime.of(receivedTime));
        }

        /**
         * Replaces all {@code parent} values.
         *
         * @param parent the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder parent(List<Reference> parent) {
            this.parent = parent == null ? new ArrayList<>() : new ArrayList<>(parent);
            return this;
        }

        /**
         * Adds a {@code parent} value.
         *
         * @param parent the value to add
         * @return this builder
         */
        public Builder addParent(Reference parent) {
            this.parent.add(Objects.requireNonNull(parent, "parent"));
            return this;
        }

        /**
         * Replaces all {@code request} values.
         *
         * @param request the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder request(List<Reference> request) {
            this.request = request == null ? new ArrayList<>() : new ArrayList<>(request);
            return this;
        }

        /**
         * Adds a {@code request} value.
         *
         * @param request the value to add
         * @return this builder
         */
        public Builder addRequest(Reference request) {
            this.request.add(Objects.requireNonNull(request, "request"));
            return this;
        }

        /**
         * Sets {@code combined}.
         *
         * @param combined the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder combined(FhirEnum<SpecimenCombined> combined) {
            this.combined = combined;
            return this;
        }

        /**
         * Sets {@code combined}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param combined the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder combined(SpecimenCombined combined) {
            return combined(combined == null ? null : FhirEnum.of(combined));
        }

        /**
         * Replaces all {@code role} values.
         *
         * @param role the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder role(List<CodeableConcept> role) {
            this.role = role == null ? new ArrayList<>() : new ArrayList<>(role);
            return this;
        }

        /**
         * Adds a {@code role} value.
         *
         * @param role the value to add
         * @return this builder
         */
        public Builder addRole(CodeableConcept role) {
            this.role.add(Objects.requireNonNull(role, "role"));
            return this;
        }

        /**
         * Replaces all {@code feature} values.
         *
         * @param feature the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder feature(List<Feature> feature) {
            this.feature = feature == null ? new ArrayList<>() : new ArrayList<>(feature);
            return this;
        }

        /**
         * Adds a {@code feature} value.
         *
         * @param feature the value to add
         * @return this builder
         */
        public Builder addFeature(Feature feature) {
            this.feature.add(Objects.requireNonNull(feature, "feature"));
            return this;
        }

        /**
         * Sets {@code collection}.
         *
         * @param collection the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder collection(Collection collection) {
            this.collection = collection;
            return this;
        }

        /**
         * Replaces all {@code processing} values.
         *
         * @param processing the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder processing(List<Processing> processing) {
            this.processing = processing == null ? new ArrayList<>() : new ArrayList<>(processing);
            return this;
        }

        /**
         * Adds a {@code processing} value.
         *
         * @param processing the value to add
         * @return this builder
         */
        public Builder addProcessing(Processing processing) {
            this.processing.add(Objects.requireNonNull(processing, "processing"));
            return this;
        }

        /**
         * Replaces all {@code container} values.
         *
         * @param container the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder container(List<Container> container) {
            this.container = container == null ? new ArrayList<>() : new ArrayList<>(container);
            return this;
        }

        /**
         * Adds a {@code container} value.
         *
         * @param container the value to add
         * @return this builder
         */
        public Builder addContainer(Container container) {
            this.container.add(Objects.requireNonNull(container, "container"));
            return this;
        }

        /**
         * Replaces all {@code condition} values.
         *
         * @param condition the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder condition(List<CodeableConcept> condition) {
            this.condition = condition == null ? new ArrayList<>() : new ArrayList<>(condition);
            return this;
        }

        /**
         * Adds a {@code condition} value.
         *
         * @param condition the value to add
         * @return this builder
         */
        public Builder addCondition(CodeableConcept condition) {
            this.condition.add(Objects.requireNonNull(condition, "condition"));
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
         * Builds the {@code Specimen}.
         *
         * @return the {@code Specimen}
         */
        public Specimen build() {
            return new Specimen(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    accessionIdentifier, status, type, subject, receivedTime, parent, request, combined, role,
                    feature, collection, processing, container, condition, note);
        }
    }
}
