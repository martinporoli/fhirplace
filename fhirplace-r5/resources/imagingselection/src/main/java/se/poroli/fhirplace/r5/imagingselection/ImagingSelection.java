package se.poroli.fhirplace.r5.imagingselection;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * A selection of DICOM SOP instances and/or frames within a single Study and Series.
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
 * @param identifier Business Identifier for Imaging Selection.
 * @param status available | entered-in-error | unknown. Required. Modifier element.
 * @param subject Subject of the selected instances. Reference to Patient, Group, Device, Location, Organization,
 *   Procedure, Practitioner, Medication, Substance, Specimen.
 * @param issued Date / Time when this imaging selection was created.
 * @param performer Selector of the instances (human or machine).
 * @param basedOn Associated request. Reference to CarePlan, ServiceRequest, Appointment, AppointmentResponse, Task.
 * @param category Classifies the imaging selection.
 * @param code Imaging Selection purpose text or code. Required.
 * @param studyUid DICOM Study Instance UID.
 * @param derivedFrom The imaging study from which the imaging selection is derived. Reference to ImagingStudy,
 *   DocumentReference.
 * @param endpoint The network service providing retrieval for the images referenced in the imaging selection.
 *   Reference to Endpoint.
 * @param seriesUid DICOM Series Instance UID.
 * @param seriesNumber DICOM Series Number.
 * @param frameOfReferenceUid The Frame of Reference UID for the selected images.
 * @param bodySite Body part examined.
 * @param focus Related resource that is the focus for the imaging selection. Reference to ImagingSelection.
 * @param instance The selected instances.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ImagingSelection">FHIR R5 ImagingSelection</a>
 */
public record ImagingSelection(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<ImagingSelectionStatus> status,
        Reference subject,
        FhirInstant issued,
        List<Performer> performer,
        List<Reference> basedOn,
        List<CodeableConcept> category,
        CodeableConcept code,
        FhirId studyUid,
        List<Reference> derivedFrom,
        List<Reference> endpoint,
        FhirId seriesUid,
        FhirUnsignedInt seriesNumber,
        FhirId frameOfReferenceUid,
        CodeableReference bodySite,
        List<Reference> focus,
        List<Instance> instance) implements DomainResource {

    /**
     * Creates an {@code ImagingSelection}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public ImagingSelection {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        performer = performer == null ? List.of() : List.copyOf(performer);
        basedOn = basedOn == null ? List.of() : List.copyOf(basedOn);
        category = category == null ? List.of() : List.copyOf(category);
        derivedFrom = derivedFrom == null ? List.of() : List.copyOf(derivedFrom);
        endpoint = endpoint == null ? List.of() : List.copyOf(endpoint);
        focus = focus == null ? List.of() : List.copyOf(focus);
        instance = instance == null ? List.of() : List.copyOf(instance);
        Objects.requireNonNull(status, "ImagingSelection.status is required");
        Objects.requireNonNull(code, "ImagingSelection.code is required");
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
     * Returns a builder initialized with the values of this {@code ImagingSelection}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Selector of the instances – human or machine.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param function Type of performer.
     * @param actor Author (human or machine). Reference to Practitioner, PractitionerRole, Device, Organization,
     *   CareTeam, Patient, RelatedPerson, HealthcareService.
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
             */
            public Performer build() {
                return new Performer(
                        id, extension, modifierExtension, function, actor);
            }
        }
    }

    /**
     * Each imaging selection includes one or more selected DICOM SOP instances.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param uid DICOM SOP Instance UID. Required.
     * @param number DICOM Instance Number.
     * @param sopClass DICOM SOP Class UID.
     * @param subset The selected subset of the SOP Instance.
     * @param imageRegion2D A specific 2D region in a DICOM image / frame.
     * @param imageRegion3D A specific 3D region in a DICOM frame of reference.
     */
    public record Instance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirId uid,
            FhirUnsignedInt number,
            Coding sopClass,
            List<FhirString> subset,
            List<ImageRegion2D> imageRegion2D,
            List<ImageRegion3D> imageRegion3D) implements BackboneElement {

        /**
         * Creates an {@code Instance}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Instance {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            subset = subset == null ? List.of() : List.copyOf(subset);
            imageRegion2D = imageRegion2D == null ? List.of() : List.copyOf(imageRegion2D);
            imageRegion3D = imageRegion3D == null ? List.of() : List.copyOf(imageRegion3D);
            Objects.requireNonNull(uid, "ImagingSelection.instance.uid is required");
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

        /**
         * Each imaging selection instance or frame list might includes an image region, specified by a region type
         * and a set of 2D coordinates.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param regionType point | polyline | interpolated | circle | ellipse. Required.
         * @param coordinate Specifies the coordinates that define the image region. Required.
         */
        public record ImageRegion2D(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<ImagingSelection2DGraphicType> regionType,
                List<FhirDecimal> coordinate) implements BackboneElement {

            /**
             * Creates an {@code ImageRegion2D}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a required list is empty
             */
            public ImageRegion2D {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                coordinate = coordinate == null ? List.of() : List.copyOf(coordinate);
                Objects.requireNonNull(regionType, "ImagingSelection.instance.imageRegion2D.regionType is required");
                if (coordinate.isEmpty()) {
                    throw new IllegalArgumentException(
                            "ImagingSelection.instance.imageRegion2D.coordinate requires at least one value");
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
             * Returns a builder initialized with the values of this {@code ImageRegion2D}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link ImageRegion2D}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<ImagingSelection2DGraphicType> regionType;
                private List<FhirDecimal> coordinate = new ArrayList<>();

                private Builder() {
                }

                private Builder(ImageRegion2D original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.regionType = original.regionType();
                    this.coordinate = new ArrayList<>(original.coordinate());
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
                 * Sets {@code regionType}.
                 *
                 * @param regionType the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder regionType(FhirEnum<ImagingSelection2DGraphicType> regionType) {
                    this.regionType = regionType;
                    return this;
                }

                /**
                 * Sets {@code regionType}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param regionType the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder regionType(ImagingSelection2DGraphicType regionType) {
                    return regionType(regionType == null ? null : FhirEnum.of(regionType));
                }

                /**
                 * Replaces all {@code coordinate} values.
                 *
                 * @param coordinate the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder coordinate(List<FhirDecimal> coordinate) {
                    this.coordinate = coordinate == null ? new ArrayList<>() : new ArrayList<>(coordinate);
                    return this;
                }

                /**
                 * Adds a {@code coordinate} value.
                 *
                 * @param coordinate the value to add
                 * @return this builder
                 */
                public Builder addCoordinate(FhirDecimal coordinate) {
                    this.coordinate.add(Objects.requireNonNull(coordinate, "coordinate"));
                    return this;
                }

                /**
                 * Adds a {@code coordinate} value, wrapped in a {@link FhirDecimal} without id or extensions.
                 *
                 * @param coordinate the value to add
                 * @return this builder
                 */
                public Builder addCoordinate(BigDecimal coordinate) {
                    return addCoordinate(FhirDecimal.of(coordinate));
                }

                /**
                 * Builds the {@code ImageRegion2D}.
                 *
                 * @return the {@code ImageRegion2D}
                 * @throws NullPointerException if a required element is absent
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public ImageRegion2D build() {
                    return new ImageRegion2D(
                            id, extension, modifierExtension, regionType, coordinate);
                }
            }
        }

        /**
         * Each imaging selection might includes a 3D image region, specified by a region type and a set of 3D
         * coordinates.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param regionType point | multipoint | polyline | polygon | ellipse | ellipsoid. Required.
         * @param coordinate Specifies the coordinates that define the image region. Required.
         */
        public record ImageRegion3D(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<ImagingSelection3DGraphicType> regionType,
                List<FhirDecimal> coordinate) implements BackboneElement {

            /**
             * Creates an {@code ImageRegion3D}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             * @throws IllegalArgumentException if a required list is empty
             */
            public ImageRegion3D {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                coordinate = coordinate == null ? List.of() : List.copyOf(coordinate);
                Objects.requireNonNull(regionType, "ImagingSelection.instance.imageRegion3D.regionType is required");
                if (coordinate.isEmpty()) {
                    throw new IllegalArgumentException(
                            "ImagingSelection.instance.imageRegion3D.coordinate requires at least one value");
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
             * Returns a builder initialized with the values of this {@code ImageRegion3D}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link ImageRegion3D}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<ImagingSelection3DGraphicType> regionType;
                private List<FhirDecimal> coordinate = new ArrayList<>();

                private Builder() {
                }

                private Builder(ImageRegion3D original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.regionType = original.regionType();
                    this.coordinate = new ArrayList<>(original.coordinate());
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
                 * Sets {@code regionType}.
                 *
                 * @param regionType the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder regionType(FhirEnum<ImagingSelection3DGraphicType> regionType) {
                    this.regionType = regionType;
                    return this;
                }

                /**
                 * Sets {@code regionType}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param regionType the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder regionType(ImagingSelection3DGraphicType regionType) {
                    return regionType(regionType == null ? null : FhirEnum.of(regionType));
                }

                /**
                 * Replaces all {@code coordinate} values.
                 *
                 * @param coordinate the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder coordinate(List<FhirDecimal> coordinate) {
                    this.coordinate = coordinate == null ? new ArrayList<>() : new ArrayList<>(coordinate);
                    return this;
                }

                /**
                 * Adds a {@code coordinate} value.
                 *
                 * @param coordinate the value to add
                 * @return this builder
                 */
                public Builder addCoordinate(FhirDecimal coordinate) {
                    this.coordinate.add(Objects.requireNonNull(coordinate, "coordinate"));
                    return this;
                }

                /**
                 * Adds a {@code coordinate} value, wrapped in a {@link FhirDecimal} without id or extensions.
                 *
                 * @param coordinate the value to add
                 * @return this builder
                 */
                public Builder addCoordinate(BigDecimal coordinate) {
                    return addCoordinate(FhirDecimal.of(coordinate));
                }

                /**
                 * Builds the {@code ImageRegion3D}.
                 *
                 * @return the {@code ImageRegion3D}
                 * @throws NullPointerException if a required element is absent
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public ImageRegion3D build() {
                    return new ImageRegion3D(
                            id, extension, modifierExtension, regionType, coordinate);
                }
            }
        }

        /** Builder for {@link Instance}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirId uid;
            private FhirUnsignedInt number;
            private Coding sopClass;
            private List<FhirString> subset = new ArrayList<>();
            private List<ImageRegion2D> imageRegion2D = new ArrayList<>();
            private List<ImageRegion3D> imageRegion3D = new ArrayList<>();

            private Builder() {
            }

            private Builder(Instance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.uid = original.uid();
                this.number = original.number();
                this.sopClass = original.sopClass();
                this.subset = new ArrayList<>(original.subset());
                this.imageRegion2D = new ArrayList<>(original.imageRegion2D());
                this.imageRegion3D = new ArrayList<>(original.imageRegion3D());
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
             * Replaces all {@code subset} values.
             *
             * @param subset the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder subset(List<FhirString> subset) {
                this.subset = subset == null ? new ArrayList<>() : new ArrayList<>(subset);
                return this;
            }

            /**
             * Adds a {@code subset} value.
             *
             * @param subset the value to add
             * @return this builder
             */
            public Builder addSubset(FhirString subset) {
                this.subset.add(Objects.requireNonNull(subset, "subset"));
                return this;
            }

            /**
             * Adds a {@code subset} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param subset the value to add
             * @return this builder
             */
            public Builder addSubset(String subset) {
                return addSubset(FhirString.of(subset));
            }

            /**
             * Replaces all {@code imageRegion2D} values.
             *
             * @param imageRegion2D the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder imageRegion2D(List<ImageRegion2D> imageRegion2D) {
                this.imageRegion2D = imageRegion2D == null ? new ArrayList<>() : new ArrayList<>(imageRegion2D);
                return this;
            }

            /**
             * Adds a {@code imageRegion2D} value.
             *
             * @param imageRegion2D the value to add
             * @return this builder
             */
            public Builder addImageRegion2D(ImageRegion2D imageRegion2D) {
                this.imageRegion2D.add(Objects.requireNonNull(imageRegion2D, "imageRegion2D"));
                return this;
            }

            /**
             * Replaces all {@code imageRegion3D} values.
             *
             * @param imageRegion3D the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder imageRegion3D(List<ImageRegion3D> imageRegion3D) {
                this.imageRegion3D = imageRegion3D == null ? new ArrayList<>() : new ArrayList<>(imageRegion3D);
                return this;
            }

            /**
             * Adds a {@code imageRegion3D} value.
             *
             * @param imageRegion3D the value to add
             * @return this builder
             */
            public Builder addImageRegion3D(ImageRegion3D imageRegion3D) {
                this.imageRegion3D.add(Objects.requireNonNull(imageRegion3D, "imageRegion3D"));
                return this;
            }

            /**
             * Builds the {@code Instance}.
             *
             * @return the {@code Instance}
             * @throws NullPointerException if a required element is absent
             */
            public Instance build() {
                return new Instance(
                        id, extension, modifierExtension, uid, number, sopClass, subset, imageRegion2D, imageRegion3D);
            }
        }
    }

    /** Builder for {@link ImagingSelection}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<ImagingSelectionStatus> status;
        private Reference subject;
        private FhirInstant issued;
        private List<Performer> performer = new ArrayList<>();
        private List<Reference> basedOn = new ArrayList<>();
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableConcept code;
        private FhirId studyUid;
        private List<Reference> derivedFrom = new ArrayList<>();
        private List<Reference> endpoint = new ArrayList<>();
        private FhirId seriesUid;
        private FhirUnsignedInt seriesNumber;
        private FhirId frameOfReferenceUid;
        private CodeableReference bodySite;
        private List<Reference> focus = new ArrayList<>();
        private List<Instance> instance = new ArrayList<>();

        private Builder() {
        }

        private Builder(ImagingSelection original) {
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
            this.subject = original.subject();
            this.issued = original.issued();
            this.performer = new ArrayList<>(original.performer());
            this.basedOn = new ArrayList<>(original.basedOn());
            this.category = new ArrayList<>(original.category());
            this.code = original.code();
            this.studyUid = original.studyUid();
            this.derivedFrom = new ArrayList<>(original.derivedFrom());
            this.endpoint = new ArrayList<>(original.endpoint());
            this.seriesUid = original.seriesUid();
            this.seriesNumber = original.seriesNumber();
            this.frameOfReferenceUid = original.frameOfReferenceUid();
            this.bodySite = original.bodySite();
            this.focus = new ArrayList<>(original.focus());
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
        public Builder status(FhirEnum<ImagingSelectionStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(ImagingSelectionStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
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
         * Sets {@code issued}.
         *
         * @param issued the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issued(FhirInstant issued) {
            this.issued = issued;
            return this;
        }

        /**
         * Sets {@code issued}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param issued the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issued(OffsetDateTime issued) {
            return issued(issued == null ? null : FhirInstant.of(issued));
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
         * Sets {@code studyUid}.
         *
         * @param studyUid the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder studyUid(FhirId studyUid) {
            this.studyUid = studyUid;
            return this;
        }

        /**
         * Sets {@code studyUid}, wrapped in a {@link FhirId} without id or extensions.
         *
         * @param studyUid the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder studyUid(String studyUid) {
            return studyUid(studyUid == null ? null : FhirId.of(studyUid));
        }

        /**
         * Replaces all {@code derivedFrom} values.
         *
         * @param derivedFrom the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder derivedFrom(List<Reference> derivedFrom) {
            this.derivedFrom = derivedFrom == null ? new ArrayList<>() : new ArrayList<>(derivedFrom);
            return this;
        }

        /**
         * Adds a {@code derivedFrom} value.
         *
         * @param derivedFrom the value to add
         * @return this builder
         */
        public Builder addDerivedFrom(Reference derivedFrom) {
            this.derivedFrom.add(Objects.requireNonNull(derivedFrom, "derivedFrom"));
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
         * Sets {@code seriesUid}.
         *
         * @param seriesUid the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder seriesUid(FhirId seriesUid) {
            this.seriesUid = seriesUid;
            return this;
        }

        /**
         * Sets {@code seriesUid}, wrapped in a {@link FhirId} without id or extensions.
         *
         * @param seriesUid the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder seriesUid(String seriesUid) {
            return seriesUid(seriesUid == null ? null : FhirId.of(seriesUid));
        }

        /**
         * Sets {@code seriesNumber}.
         *
         * @param seriesNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder seriesNumber(FhirUnsignedInt seriesNumber) {
            this.seriesNumber = seriesNumber;
            return this;
        }

        /**
         * Sets {@code seriesNumber}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
         *
         * @param seriesNumber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder seriesNumber(Integer seriesNumber) {
            return seriesNumber(seriesNumber == null ? null : FhirUnsignedInt.of(seriesNumber));
        }

        /**
         * Sets {@code frameOfReferenceUid}.
         *
         * @param frameOfReferenceUid the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder frameOfReferenceUid(FhirId frameOfReferenceUid) {
            this.frameOfReferenceUid = frameOfReferenceUid;
            return this;
        }

        /**
         * Sets {@code frameOfReferenceUid}, wrapped in a {@link FhirId} without id or extensions.
         *
         * @param frameOfReferenceUid the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder frameOfReferenceUid(String frameOfReferenceUid) {
            return frameOfReferenceUid(frameOfReferenceUid == null ? null : FhirId.of(frameOfReferenceUid));
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
         * Builds the {@code ImagingSelection}.
         *
         * @return the {@code ImagingSelection}
         * @throws NullPointerException if a required element is absent
         */
        public ImagingSelection build() {
            return new ImagingSelection(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, subject, issued, performer, basedOn, category, code, studyUid, derivedFrom, endpoint,
                    seriesUid, seriesNumber, frameOfReferenceUid, bodySite, focus, instance);
        }
    }
}
