package se.poroli.fhirplace.r5.genomicstudy;

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
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * A set of analyses performed to analyze and generate genomic data.
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
 * @param identifier Identifiers for this genomic study.
 * @param status registered | available | cancelled | entered-in-error | unknown. Required. Modifier element.
 * @param type The type of the study (e.g., Familial variant segregation, Functional variation detection, or Gene
 *   expression profiling).
 * @param subject The primary subject of the genomic study. Reference to Patient, Group, Substance,
 *   BiologicallyDerivedProduct, NutritionProduct. Required.
 * @param encounter The healthcare event with which this genomics study is associated. Reference to Encounter.
 * @param startDate When the genomic study was started.
 * @param basedOn Event resources that the genomic study is based on. Reference to ServiceRequest, Task.
 * @param referrer Healthcare professional who requested or referred the genomic study. Reference to Practitioner,
 *   PractitionerRole.
 * @param interpreter Healthcare professionals who interpreted the genomic study. Reference to Practitioner,
 *   PractitionerRole.
 * @param reason Why the genomic study was performed.
 * @param instantiatesCanonical The defined protocol that describes the study. Canonical reference to PlanDefinition.
 * @param instantiatesUri The URL pointing to an externally maintained protocol that describes the study.
 * @param note Comments related to the genomic study.
 * @param description Description of the genomic study.
 * @param analysis Genomic Analysis Event.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/GenomicStudy">FHIR R5 GenomicStudy</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record GenomicStudy(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<GenomicStudyStatus> status,
        List<CodeableConcept> type,
        Reference subject,
        Reference encounter,
        FhirDateTime startDate,
        List<Reference> basedOn,
        Reference referrer,
        List<Reference> interpreter,
        List<CodeableReference> reason,
        FhirCanonical instantiatesCanonical,
        FhirUri instantiatesUri,
        List<Annotation> note,
        FhirMarkdown description,
        List<Analysis> analysis) implements DomainResource {

    /**
     * Creates a {@code GenomicStudy}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public GenomicStudy {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        type = type == null ? List.of() : List.copyOf(type);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        interpreter = interpreter == null ? List.of() : List.copyOf(interpreter);
        reason = reason == null ? List.of() : List.copyOf(reason);
        note = note == null ? List.of() : List.copyOf(note);
        analysis = analysis == null ? List.of() : List.copyOf(analysis);
        Objects.requireNonNull(status, "GenomicStudy.status is required");
        Objects.requireNonNull(subject, "GenomicStudy.subject is required");
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
     * Returns a builder initialized with the values of this {@code GenomicStudy}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The details about a specific analysis that was performed in this GenomicStudy.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param identifier Identifiers for the analysis event.
     * @param methodType Type of the methods used in the analysis (e.g., FISH, Karyotyping, MSI).
     * @param changeType Type of the genomic changes studied in the analysis (e.g., DNA, RNA, or AA change).
     * @param genomeBuild Genome build that is used in this analysis.
     * @param instantiatesCanonical The defined protocol that describes the analysis. Canonical reference to
     *   PlanDefinition, ActivityDefinition.
     * @param instantiatesUri The URL pointing to an externally maintained protocol that describes the analysis.
     * @param title Name of the analysis event (human friendly).
     * @param focus What the genomic analysis is about, when it is not about the subject of record. Reference to
     *   Resource.
     * @param specimen The specimen used in the analysis event. Reference to Specimen.
     * @param date The date of the analysis event.
     * @param note Any notes capture with the analysis event.
     * @param protocolPerformed The protocol that was performed for the analysis event. Reference to Procedure, Task.
     * @param regionsStudied The genomic regions to be studied in the analysis (BED file). Reference to
     *   DocumentReference, Observation.
     * @param regionsCalled Genomic regions actually called in the analysis event (BED file). Reference to
     *   DocumentReference, Observation.
     * @param input Inputs for the analysis event.
     * @param output Outputs for the analysis event.
     * @param performer Performer for the analysis event.
     * @param device Devices used for the analysis (e.g., instruments, software), with settings and parameters.
     */
    public record Analysis(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Identifier> identifier,
            List<CodeableConcept> methodType,
            List<CodeableConcept> changeType,
            CodeableConcept genomeBuild,
            FhirCanonical instantiatesCanonical,
            FhirUri instantiatesUri,
            FhirString title,
            List<Reference> focus,
            List<Reference> specimen,
            FhirDateTime date,
            List<Annotation> note,
            Reference protocolPerformed,
            List<Reference> regionsStudied,
            List<Reference> regionsCalled,
            List<Input> input,
            List<Output> output,
            List<Performer> performer,
            List<Device> device) implements BackboneElement {

        /**
         * Creates an {@code Analysis}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Analysis {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            identifier = identifier == null ? List.of() : List.copyOf(identifier);
            methodType = methodType == null ? List.of() : List.copyOf(methodType);
            changeType = changeType == null ? List.of() : List.copyOf(changeType);
            focus = focus == null ? List.of() : List.copyOf(focus);
            specimen = specimen == null ? List.of() : List.copyOf(specimen);
            note = note == null ? List.of() : List.copyOf(note);
            regionsStudied = regionsStudied == null ? List.of() : List.copyOf(regionsStudied);
            regionsCalled = regionsCalled == null ? List.of() : List.copyOf(regionsCalled);
            input = input == null ? List.of() : List.copyOf(input);
            output = output == null ? List.of() : List.copyOf(output);
            performer = performer == null ? List.of() : List.copyOf(performer);
            device = device == null ? List.of() : List.copyOf(device);
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
         * Returns a builder initialized with the values of this {@code Analysis}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Inputs for the analysis event.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param file File containing input data. Reference to DocumentReference.
         * @param type Type of input data (e.g., BAM, CRAM, or FASTA).
         * @param generatedBy The analysis event or other GenomicStudy that generated this input file. One of
         *   Identifier, Reference.
         */
        public record Input(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Reference file,
                CodeableConcept type,
                DataType generatedBy) implements BackboneElement {

            /**
             * Creates an {@code Input}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a choice element has a type that is not allowed
             */
            public Input {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                if (generatedBy != null && !(generatedBy instanceof Identifier || generatedBy instanceof Reference)) {
                    throw new IllegalArgumentException(
                            "GenomicStudy.analysis.input.generatedBy[x] does not allow "
                                    + generatedBy.getClass().getSimpleName());
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
             * Returns a builder initialized with the values of this {@code Input}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Input}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Reference file;
                private CodeableConcept type;
                private DataType generatedBy;

                private Builder() {
                }

                private Builder(Input original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.file = original.file();
                    this.type = original.type();
                    this.generatedBy = original.generatedBy();
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
                 * Sets {@code file}.
                 *
                 * @param file the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder file(Reference file) {
                    this.file = file;
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
                 * Sets {@code generatedBy} to a Identifier.
                 *
                 * @param generatedBy the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder generatedBy(Identifier generatedBy) {
                    this.generatedBy = generatedBy;
                    return this;
                }

                /**
                 * Sets {@code generatedBy} to a Reference.
                 *
                 * @param generatedBy the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder generatedBy(Reference generatedBy) {
                    this.generatedBy = generatedBy;
                    return this;
                }

                /**
                 * Builds the {@code Input}.
                 *
                 * @return the {@code Input}
                 */
                public Input build() {
                    return new Input(
                            id, extension, modifierExtension, file, type, generatedBy);
                }
            }
        }

        /**
         * Outputs for the analysis event.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param file File containing output data. Reference to DocumentReference.
         * @param type Type of output data (e.g., VCF, MAF, or BAM).
         */
        public record Output(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Reference file,
                CodeableConcept type) implements BackboneElement {

            /**
             * Creates an {@code Output}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Output {
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
             * Returns a builder initialized with the values of this {@code Output}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Output}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Reference file;
                private CodeableConcept type;

                private Builder() {
                }

                private Builder(Output original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.file = original.file();
                    this.type = original.type();
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
                 * Sets {@code file}.
                 *
                 * @param file the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder file(Reference file) {
                    this.file = file;
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
                 * Builds the {@code Output}.
                 *
                 * @return the {@code Output}
                 */
                public Output build() {
                    return new Output(
                            id, extension, modifierExtension, file, type);
                }
            }
        }

        /**
         * Performer for the analysis event.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param actor The organization, healthcare professional, or others who participated in performing this
         *   analysis. Reference to Practitioner, PractitionerRole, Organization, Device.
         * @param role Role of the actor for this analysis.
         */
        public record Performer(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Reference actor,
                CodeableConcept role) implements BackboneElement {

            /**
             * Creates a {@code Performer}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Performer {
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
                private Reference actor;
                private CodeableConcept role;

                private Builder() {
                }

                private Builder(Performer original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.actor = original.actor();
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
                 * Builds the {@code Performer}.
                 *
                 * @return the {@code Performer}
                 */
                public Performer build() {
                    return new Performer(
                            id, extension, modifierExtension, actor, role);
                }
            }
        }

        /**
         * Devices used for the analysis (e.g., instruments, software), with settings and parameters.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param device Device used for the analysis. Reference to Device.
         * @param function Specific function for the device used for the analysis.
         */
        public record Device(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                Reference device,
                CodeableConcept function) implements BackboneElement {

            /**
             * Creates a {@code Device}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Device {
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
             * Returns a builder initialized with the values of this {@code Device}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Device}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private Reference device;
                private CodeableConcept function;

                private Builder() {
                }

                private Builder(Device original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.device = original.device();
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
                 * Builds the {@code Device}.
                 *
                 * @return the {@code Device}
                 */
                public Device build() {
                    return new Device(
                            id, extension, modifierExtension, device, function);
                }
            }
        }

        /** Builder for {@link Analysis}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Identifier> identifier = new ArrayList<>();
            private List<CodeableConcept> methodType = new ArrayList<>();
            private List<CodeableConcept> changeType = new ArrayList<>();
            private CodeableConcept genomeBuild;
            private FhirCanonical instantiatesCanonical;
            private FhirUri instantiatesUri;
            private FhirString title;
            private List<Reference> focus = new ArrayList<>();
            private List<Reference> specimen = new ArrayList<>();
            private FhirDateTime date;
            private List<Annotation> note = new ArrayList<>();
            private Reference protocolPerformed;
            private List<Reference> regionsStudied = new ArrayList<>();
            private List<Reference> regionsCalled = new ArrayList<>();
            private List<Input> input = new ArrayList<>();
            private List<Output> output = new ArrayList<>();
            private List<Performer> performer = new ArrayList<>();
            private List<Device> device = new ArrayList<>();

            private Builder() {
            }

            private Builder(Analysis original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.identifier = new ArrayList<>(original.identifier());
                this.methodType = new ArrayList<>(original.methodType());
                this.changeType = new ArrayList<>(original.changeType());
                this.genomeBuild = original.genomeBuild();
                this.instantiatesCanonical = original.instantiatesCanonical();
                this.instantiatesUri = original.instantiatesUri();
                this.title = original.title();
                this.focus = new ArrayList<>(original.focus());
                this.specimen = new ArrayList<>(original.specimen());
                this.date = original.date();
                this.note = new ArrayList<>(original.note());
                this.protocolPerformed = original.protocolPerformed();
                this.regionsStudied = new ArrayList<>(original.regionsStudied());
                this.regionsCalled = new ArrayList<>(original.regionsCalled());
                this.input = new ArrayList<>(original.input());
                this.output = new ArrayList<>(original.output());
                this.performer = new ArrayList<>(original.performer());
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
             * Replaces all {@code methodType} values.
             *
             * @param methodType the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder methodType(List<CodeableConcept> methodType) {
                this.methodType = methodType == null ? new ArrayList<>() : new ArrayList<>(methodType);
                return this;
            }

            /**
             * Adds a {@code methodType} value.
             *
             * @param methodType the value to add
             * @return this builder
             */
            public Builder addMethodType(CodeableConcept methodType) {
                this.methodType.add(Objects.requireNonNull(methodType, "methodType"));
                return this;
            }

            /**
             * Replaces all {@code changeType} values.
             *
             * @param changeType the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder changeType(List<CodeableConcept> changeType) {
                this.changeType = changeType == null ? new ArrayList<>() : new ArrayList<>(changeType);
                return this;
            }

            /**
             * Adds a {@code changeType} value.
             *
             * @param changeType the value to add
             * @return this builder
             */
            public Builder addChangeType(CodeableConcept changeType) {
                this.changeType.add(Objects.requireNonNull(changeType, "changeType"));
                return this;
            }

            /**
             * Sets {@code genomeBuild}.
             *
             * @param genomeBuild the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder genomeBuild(CodeableConcept genomeBuild) {
                this.genomeBuild = genomeBuild;
                return this;
            }

            /**
             * Sets {@code instantiatesCanonical}.
             *
             * @param instantiatesCanonical the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instantiatesCanonical(FhirCanonical instantiatesCanonical) {
                this.instantiatesCanonical = instantiatesCanonical;
                return this;
            }

            /**
             * Sets {@code instantiatesCanonical}, wrapped in a {@link FhirCanonical} without id or extensions.
             *
             * @param instantiatesCanonical the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder instantiatesCanonical(String instantiatesCanonical) {
                return instantiatesCanonical(
                        instantiatesCanonical == null ? null : FhirCanonical.of(instantiatesCanonical));
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
             * Replaces all {@code focus} values.
             *
             * @param focus the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder focus(List<Reference> focus) {
                this.focus = focus == null ? new ArrayList<>() : new ArrayList<>(focus);
                return this;
            }

            /**
             * Adds a {@code focus} value.
             *
             * @param focus the value to add
             * @return this builder
             */
            public Builder addFocus(Reference focus) {
                this.focus.add(Objects.requireNonNull(focus, "focus"));
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
             * Sets {@code protocolPerformed}.
             *
             * @param protocolPerformed the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder protocolPerformed(Reference protocolPerformed) {
                this.protocolPerformed = protocolPerformed;
                return this;
            }

            /**
             * Replaces all {@code regionsStudied} values.
             *
             * @param regionsStudied the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder regionsStudied(List<Reference> regionsStudied) {
                this.regionsStudied = regionsStudied == null ? new ArrayList<>() : new ArrayList<>(regionsStudied);
                return this;
            }

            /**
             * Adds a {@code regionsStudied} value.
             *
             * @param regionsStudied the value to add
             * @return this builder
             */
            public Builder addRegionsStudied(Reference regionsStudied) {
                this.regionsStudied.add(Objects.requireNonNull(regionsStudied, "regionsStudied"));
                return this;
            }

            /**
             * Replaces all {@code regionsCalled} values.
             *
             * @param regionsCalled the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder regionsCalled(List<Reference> regionsCalled) {
                this.regionsCalled = regionsCalled == null ? new ArrayList<>() : new ArrayList<>(regionsCalled);
                return this;
            }

            /**
             * Adds a {@code regionsCalled} value.
             *
             * @param regionsCalled the value to add
             * @return this builder
             */
            public Builder addRegionsCalled(Reference regionsCalled) {
                this.regionsCalled.add(Objects.requireNonNull(regionsCalled, "regionsCalled"));
                return this;
            }

            /**
             * Replaces all {@code input} values.
             *
             * @param input the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder input(List<Input> input) {
                this.input = input == null ? new ArrayList<>() : new ArrayList<>(input);
                return this;
            }

            /**
             * Adds a {@code input} value.
             *
             * @param input the value to add
             * @return this builder
             */
            public Builder addInput(Input input) {
                this.input.add(Objects.requireNonNull(input, "input"));
                return this;
            }

            /**
             * Replaces all {@code output} values.
             *
             * @param output the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder output(List<Output> output) {
                this.output = output == null ? new ArrayList<>() : new ArrayList<>(output);
                return this;
            }

            /**
             * Adds a {@code output} value.
             *
             * @param output the value to add
             * @return this builder
             */
            public Builder addOutput(Output output) {
                this.output.add(Objects.requireNonNull(output, "output"));
                return this;
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
             * Replaces all {@code device} values.
             *
             * @param device the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder device(List<Device> device) {
                this.device = device == null ? new ArrayList<>() : new ArrayList<>(device);
                return this;
            }

            /**
             * Adds a {@code device} value.
             *
             * @param device the value to add
             * @return this builder
             */
            public Builder addDevice(Device device) {
                this.device.add(Objects.requireNonNull(device, "device"));
                return this;
            }

            /**
             * Builds the {@code Analysis}.
             *
             * @return the {@code Analysis}
             */
            public Analysis build() {
                return new Analysis(
                        id, extension, modifierExtension, identifier, methodType, changeType, genomeBuild,
                        instantiatesCanonical, instantiatesUri, title, focus, specimen, date, note, protocolPerformed,
                        regionsStudied, regionsCalled, input, output, performer, device);
            }
        }
    }

    /** Builder for {@link GenomicStudy}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<GenomicStudyStatus> status;
        private List<CodeableConcept> type = new ArrayList<>();
        private Reference subject;
        private Reference encounter;
        private FhirDateTime startDate;
        private List<Reference> basedOn = new ArrayList<>();
        private Reference referrer;
        private List<Reference> interpreter = new ArrayList<>();
        private List<CodeableReference> reason = new ArrayList<>();
        private FhirCanonical instantiatesCanonical;
        private FhirUri instantiatesUri;
        private List<Annotation> note = new ArrayList<>();
        private FhirMarkdown description;
        private List<Analysis> analysis = new ArrayList<>();

        private Builder() {
        }

        private Builder(GenomicStudy original) {
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
            this.type = new ArrayList<>(original.type());
            this.subject = original.subject();
            this.encounter = original.encounter();
            this.startDate = original.startDate();
            this.basedOn = new ArrayList<>(original.basedOn());
            this.referrer = original.referrer();
            this.interpreter = new ArrayList<>(original.interpreter());
            this.reason = new ArrayList<>(original.reason());
            this.instantiatesCanonical = original.instantiatesCanonical();
            this.instantiatesUri = original.instantiatesUri();
            this.note = new ArrayList<>(original.note());
            this.description = original.description();
            this.analysis = new ArrayList<>(original.analysis());
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
        public Builder status(FhirEnum<GenomicStudyStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(GenomicStudyStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Sets {@code startDate}.
         *
         * @param startDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder startDate(FhirDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * Sets {@code startDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param startDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder startDate(Temporal startDate) {
            return startDate(startDate == null ? null : FhirDateTime.of(startDate));
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
         * Replaces all {@code interpreter} values.
         *
         * @param interpreter the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder interpreter(List<Reference> interpreter) {
            this.interpreter = interpreter == null ? new ArrayList<>() : new ArrayList<>(interpreter);
            return this;
        }

        /**
         * Adds a {@code interpreter} value.
         *
         * @param interpreter the value to add
         * @return this builder
         */
        public Builder addInterpreter(Reference interpreter) {
            this.interpreter.add(Objects.requireNonNull(interpreter, "interpreter"));
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
         * Sets {@code instantiatesCanonical}.
         *
         * @param instantiatesCanonical the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesCanonical(FhirCanonical instantiatesCanonical) {
            this.instantiatesCanonical = instantiatesCanonical;
            return this;
        }

        /**
         * Sets {@code instantiatesCanonical}, wrapped in a {@link FhirCanonical} without id or extensions.
         *
         * @param instantiatesCanonical the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder instantiatesCanonical(String instantiatesCanonical) {
            return instantiatesCanonical(
                    instantiatesCanonical == null ? null : FhirCanonical.of(instantiatesCanonical));
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
         * Replaces all {@code analysis} values.
         *
         * @param analysis the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder analysis(List<Analysis> analysis) {
            this.analysis = analysis == null ? new ArrayList<>() : new ArrayList<>(analysis);
            return this;
        }

        /**
         * Adds a {@code analysis} value.
         *
         * @param analysis the value to add
         * @return this builder
         */
        public Builder addAnalysis(Analysis analysis) {
            this.analysis.add(Objects.requireNonNull(analysis, "analysis"));
            return this;
        }

        /**
         * Builds the {@code GenomicStudy}.
         *
         * @return the {@code GenomicStudy}
         * @throws NullPointerException if a required element is absent
         */
        public GenomicStudy build() {
            return new GenomicStudy(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, type, subject, encounter, startDate, basedOn, referrer, interpreter, reason,
                    instantiatesCanonical, instantiatesUri, note, description, analysis);
        }
    }
}
