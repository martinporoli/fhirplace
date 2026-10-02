package se.poroli.fhirplace.r5.bodystructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * Record details about an anatomical structure.
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
 * @param identifier Bodystructure identifier.
 * @param active Whether this record is in active use. Modifier element.
 * @param morphology Kind of Structure.
 * @param includedStructure Included anatomic location(s). Required.
 * @param excludedStructure Excluded anatomic locations(s).
 * @param description Text description.
 * @param image Attached images.
 * @param patient Who this is about. Reference to Patient. Required.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/BodyStructure">FHIR R5 BodyStructure</a>
 */
public record BodyStructure(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirBoolean active,
        CodeableConcept morphology,
        List<IncludedStructure> includedStructure,
        List<BodyStructure.IncludedStructure> excludedStructure,
        FhirMarkdown description,
        List<Attachment> image,
        Reference patient) implements DomainResource {

    /**
     * Creates a {@code BodyStructure}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a required list is empty
     */
    public BodyStructure {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        includedStructure = includedStructure == null ? List.of() : List.copyOf(includedStructure);
        excludedStructure = excludedStructure == null ? List.of() : List.copyOf(excludedStructure);
        image = image == null ? List.of() : List.copyOf(image);
        if (includedStructure.isEmpty()) {
            throw new IllegalArgumentException("BodyStructure.includedStructure requires at least one value");
        }
        Objects.requireNonNull(patient, "BodyStructure.patient is required");
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
     * Returns a builder initialized with the values of this {@code BodyStructure}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The anatomical location(s) or region(s) of the specimen, lesion, or body structure.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param structure Code that represents the included structure. Required.
     * @param laterality Code that represents the included structure laterality.
     * @param bodyLandmarkOrientation Landmark relative location.
     * @param spatialReference Cartesian reference for structure. Reference to ImagingSelection.
     * @param qualifier Code that represents the included structure qualifier.
     */
    public record IncludedStructure(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept structure,
            CodeableConcept laterality,
            List<BodyLandmarkOrientation> bodyLandmarkOrientation,
            List<Reference> spatialReference,
            List<CodeableConcept> qualifier) implements BackboneElement {

        /**
         * Creates an {@code IncludedStructure}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public IncludedStructure {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            bodyLandmarkOrientation =
                    bodyLandmarkOrientation == null ? List.of() : List.copyOf(bodyLandmarkOrientation);
            spatialReference = spatialReference == null ? List.of() : List.copyOf(spatialReference);
            qualifier = qualifier == null ? List.of() : List.copyOf(qualifier);
            Objects.requireNonNull(structure, "BodyStructure.includedStructure.structure is required");
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
         * Returns a builder initialized with the values of this {@code IncludedStructure}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Body locations in relation to a specific body landmark (tatoo, scar, other body structure).
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param landmarkDescription Body ]andmark description.
         * @param clockFacePosition Clockface orientation.
         * @param distanceFromLandmark Landmark relative location.
         * @param surfaceOrientation Relative landmark surface orientation.
         */
        public record BodyLandmarkOrientation(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<CodeableConcept> landmarkDescription,
                List<CodeableConcept> clockFacePosition,
                List<DistanceFromLandmark> distanceFromLandmark,
                List<CodeableConcept> surfaceOrientation) implements BackboneElement {

            /**
             * Creates a {@code BodyLandmarkOrientation}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public BodyLandmarkOrientation {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                landmarkDescription = landmarkDescription == null ? List.of() : List.copyOf(landmarkDescription);
                clockFacePosition = clockFacePosition == null ? List.of() : List.copyOf(clockFacePosition);
                distanceFromLandmark = distanceFromLandmark == null ? List.of() : List.copyOf(distanceFromLandmark);
                surfaceOrientation = surfaceOrientation == null ? List.of() : List.copyOf(surfaceOrientation);
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
             * Returns a builder initialized with the values of this {@code BodyLandmarkOrientation}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * The distance in centimeters a certain observation is made from a body landmark.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param device Measurement device.
             * @param value Measured distance from body landmark.
             */
            public record DistanceFromLandmark(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    List<CodeableReference> device,
                    List<Quantity> value) implements BackboneElement {

                /**
                 * Creates a {@code DistanceFromLandmark}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 */
                public DistanceFromLandmark {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    device = device == null ? List.of() : List.copyOf(device);
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
                 * Returns a builder initialized with the values of this {@code DistanceFromLandmark}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link DistanceFromLandmark}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private List<CodeableReference> device = new ArrayList<>();
                    private List<Quantity> value = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(DistanceFromLandmark original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.device = new ArrayList<>(original.device());
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
                     * Replaces all {@code device} values.
                     *
                     * @param device the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder device(List<CodeableReference> device) {
                        this.device = device == null ? new ArrayList<>() : new ArrayList<>(device);
                        return this;
                    }

                    /**
                     * Adds a {@code device} value.
                     *
                     * @param device the value to add
                     * @return this builder
                     */
                    public Builder addDevice(CodeableReference device) {
                        this.device.add(Objects.requireNonNull(device, "device"));
                        return this;
                    }

                    /**
                     * Replaces all {@code value} values.
                     *
                     * @param value the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder value(List<Quantity> value) {
                        this.value = value == null ? new ArrayList<>() : new ArrayList<>(value);
                        return this;
                    }

                    /**
                     * Adds a {@code value} value.
                     *
                     * @param value the value to add
                     * @return this builder
                     */
                    public Builder addValue(Quantity value) {
                        this.value.add(Objects.requireNonNull(value, "value"));
                        return this;
                    }

                    /**
                     * Builds the {@code DistanceFromLandmark}.
                     *
                     * @return the {@code DistanceFromLandmark}
                     */
                    public DistanceFromLandmark build() {
                        return new DistanceFromLandmark(
                                id, extension, modifierExtension, device, value);
                    }
                }
            }

            /** Builder for {@link BodyLandmarkOrientation}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<CodeableConcept> landmarkDescription = new ArrayList<>();
                private List<CodeableConcept> clockFacePosition = new ArrayList<>();
                private List<DistanceFromLandmark> distanceFromLandmark = new ArrayList<>();
                private List<CodeableConcept> surfaceOrientation = new ArrayList<>();

                private Builder() {
                }

                private Builder(BodyLandmarkOrientation original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.landmarkDescription = new ArrayList<>(original.landmarkDescription());
                    this.clockFacePosition = new ArrayList<>(original.clockFacePosition());
                    this.distanceFromLandmark = new ArrayList<>(original.distanceFromLandmark());
                    this.surfaceOrientation = new ArrayList<>(original.surfaceOrientation());
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
                 * Replaces all {@code landmarkDescription} values.
                 *
                 * @param landmarkDescription the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder landmarkDescription(List<CodeableConcept> landmarkDescription) {
                    this.landmarkDescription = landmarkDescription == null
                            ? new ArrayList<>()
                            : new ArrayList<>(landmarkDescription);
                    return this;
                }

                /**
                 * Adds a {@code landmarkDescription} value.
                 *
                 * @param landmarkDescription the value to add
                 * @return this builder
                 */
                public Builder addLandmarkDescription(CodeableConcept landmarkDescription) {
                    this.landmarkDescription.add(Objects.requireNonNull(landmarkDescription, "landmarkDescription"));
                    return this;
                }

                /**
                 * Replaces all {@code clockFacePosition} values.
                 *
                 * @param clockFacePosition the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder clockFacePosition(List<CodeableConcept> clockFacePosition) {
                    this.clockFacePosition = clockFacePosition == null
                            ? new ArrayList<>()
                            : new ArrayList<>(clockFacePosition);
                    return this;
                }

                /**
                 * Adds a {@code clockFacePosition} value.
                 *
                 * @param clockFacePosition the value to add
                 * @return this builder
                 */
                public Builder addClockFacePosition(CodeableConcept clockFacePosition) {
                    this.clockFacePosition.add(Objects.requireNonNull(clockFacePosition, "clockFacePosition"));
                    return this;
                }

                /**
                 * Replaces all {@code distanceFromLandmark} values.
                 *
                 * @param distanceFromLandmark the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder distanceFromLandmark(List<DistanceFromLandmark> distanceFromLandmark) {
                    this.distanceFromLandmark = distanceFromLandmark == null
                            ? new ArrayList<>()
                            : new ArrayList<>(distanceFromLandmark);
                    return this;
                }

                /**
                 * Adds a {@code distanceFromLandmark} value.
                 *
                 * @param distanceFromLandmark the value to add
                 * @return this builder
                 */
                public Builder addDistanceFromLandmark(DistanceFromLandmark distanceFromLandmark) {
                    this.distanceFromLandmark.add(
                            Objects.requireNonNull(distanceFromLandmark, "distanceFromLandmark"));
                    return this;
                }

                /**
                 * Replaces all {@code surfaceOrientation} values.
                 *
                 * @param surfaceOrientation the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder surfaceOrientation(List<CodeableConcept> surfaceOrientation) {
                    this.surfaceOrientation = surfaceOrientation == null
                            ? new ArrayList<>()
                            : new ArrayList<>(surfaceOrientation);
                    return this;
                }

                /**
                 * Adds a {@code surfaceOrientation} value.
                 *
                 * @param surfaceOrientation the value to add
                 * @return this builder
                 */
                public Builder addSurfaceOrientation(CodeableConcept surfaceOrientation) {
                    this.surfaceOrientation.add(Objects.requireNonNull(surfaceOrientation, "surfaceOrientation"));
                    return this;
                }

                /**
                 * Builds the {@code BodyLandmarkOrientation}.
                 *
                 * @return the {@code BodyLandmarkOrientation}
                 */
                public BodyLandmarkOrientation build() {
                    return new BodyLandmarkOrientation(
                            id, extension, modifierExtension, landmarkDescription, clockFacePosition,
                            distanceFromLandmark, surfaceOrientation);
                }
            }
        }

        /** Builder for {@link IncludedStructure}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept structure;
            private CodeableConcept laterality;
            private List<BodyLandmarkOrientation> bodyLandmarkOrientation = new ArrayList<>();
            private List<Reference> spatialReference = new ArrayList<>();
            private List<CodeableConcept> qualifier = new ArrayList<>();

            private Builder() {
            }

            private Builder(IncludedStructure original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.structure = original.structure();
                this.laterality = original.laterality();
                this.bodyLandmarkOrientation = new ArrayList<>(original.bodyLandmarkOrientation());
                this.spatialReference = new ArrayList<>(original.spatialReference());
                this.qualifier = new ArrayList<>(original.qualifier());
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
             * Sets {@code structure}.
             *
             * @param structure the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder structure(CodeableConcept structure) {
                this.structure = structure;
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
             * Replaces all {@code bodyLandmarkOrientation} values.
             *
             * @param bodyLandmarkOrientation the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder bodyLandmarkOrientation(List<BodyLandmarkOrientation> bodyLandmarkOrientation) {
                this.bodyLandmarkOrientation = bodyLandmarkOrientation == null
                        ? new ArrayList<>()
                        : new ArrayList<>(bodyLandmarkOrientation);
                return this;
            }

            /**
             * Adds a {@code bodyLandmarkOrientation} value.
             *
             * @param bodyLandmarkOrientation the value to add
             * @return this builder
             */
            public Builder addBodyLandmarkOrientation(BodyLandmarkOrientation bodyLandmarkOrientation) {
                this.bodyLandmarkOrientation.add(
                        Objects.requireNonNull(bodyLandmarkOrientation, "bodyLandmarkOrientation"));
                return this;
            }

            /**
             * Replaces all {@code spatialReference} values.
             *
             * @param spatialReference the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder spatialReference(List<Reference> spatialReference) {
                this.spatialReference = spatialReference == null
                        ? new ArrayList<>()
                        : new ArrayList<>(spatialReference);
                return this;
            }

            /**
             * Adds a {@code spatialReference} value.
             *
             * @param spatialReference the value to add
             * @return this builder
             */
            public Builder addSpatialReference(Reference spatialReference) {
                this.spatialReference.add(Objects.requireNonNull(spatialReference, "spatialReference"));
                return this;
            }

            /**
             * Replaces all {@code qualifier} values.
             *
             * @param qualifier the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder qualifier(List<CodeableConcept> qualifier) {
                this.qualifier = qualifier == null ? new ArrayList<>() : new ArrayList<>(qualifier);
                return this;
            }

            /**
             * Adds a {@code qualifier} value.
             *
             * @param qualifier the value to add
             * @return this builder
             */
            public Builder addQualifier(CodeableConcept qualifier) {
                this.qualifier.add(Objects.requireNonNull(qualifier, "qualifier"));
                return this;
            }

            /**
             * Builds the {@code IncludedStructure}.
             *
             * @return the {@code IncludedStructure}
             * @throws NullPointerException if a required element is absent
             */
            public IncludedStructure build() {
                return new IncludedStructure(
                        id, extension, modifierExtension, structure, laterality, bodyLandmarkOrientation,
                        spatialReference, qualifier);
            }
        }
    }

    /** Builder for {@link BodyStructure}. Builders are mutable and not thread-safe. */
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
        private FhirBoolean active;
        private CodeableConcept morphology;
        private List<IncludedStructure> includedStructure = new ArrayList<>();
        private List<BodyStructure.IncludedStructure> excludedStructure = new ArrayList<>();
        private FhirMarkdown description;
        private List<Attachment> image = new ArrayList<>();
        private Reference patient;

        private Builder() {
        }

        private Builder(BodyStructure original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.active = original.active();
            this.morphology = original.morphology();
            this.includedStructure = new ArrayList<>(original.includedStructure());
            this.excludedStructure = new ArrayList<>(original.excludedStructure());
            this.description = original.description();
            this.image = new ArrayList<>(original.image());
            this.patient = original.patient();
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
         * Sets {@code active}.
         *
         * @param active the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder active(FhirBoolean active) {
            this.active = active;
            return this;
        }

        /**
         * Sets {@code active}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param active the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder active(Boolean active) {
            return active(active == null ? null : FhirBoolean.of(active));
        }

        /**
         * Sets {@code morphology}.
         *
         * @param morphology the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder morphology(CodeableConcept morphology) {
            this.morphology = morphology;
            return this;
        }

        /**
         * Replaces all {@code includedStructure} values.
         *
         * @param includedStructure the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder includedStructure(List<IncludedStructure> includedStructure) {
            this.includedStructure = includedStructure == null
                    ? new ArrayList<>()
                    : new ArrayList<>(includedStructure);
            return this;
        }

        /**
         * Adds a {@code includedStructure} value.
         *
         * @param includedStructure the value to add
         * @return this builder
         */
        public Builder addIncludedStructure(IncludedStructure includedStructure) {
            this.includedStructure.add(Objects.requireNonNull(includedStructure, "includedStructure"));
            return this;
        }

        /**
         * Replaces all {@code excludedStructure} values.
         *
         * @param excludedStructure the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder excludedStructure(List<BodyStructure.IncludedStructure> excludedStructure) {
            this.excludedStructure = excludedStructure == null
                    ? new ArrayList<>()
                    : new ArrayList<>(excludedStructure);
            return this;
        }

        /**
         * Adds a {@code excludedStructure} value.
         *
         * @param excludedStructure the value to add
         * @return this builder
         */
        public Builder addExcludedStructure(BodyStructure.IncludedStructure excludedStructure) {
            this.excludedStructure.add(Objects.requireNonNull(excludedStructure, "excludedStructure"));
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
         * Replaces all {@code image} values.
         *
         * @param image the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder image(List<Attachment> image) {
            this.image = image == null ? new ArrayList<>() : new ArrayList<>(image);
            return this;
        }

        /**
         * Adds a {@code image} value.
         *
         * @param image the value to add
         * @return this builder
         */
        public Builder addImage(Attachment image) {
            this.image.add(Objects.requireNonNull(image, "image"));
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
         * Builds the {@code BodyStructure}.
         *
         * @return the {@code BodyStructure}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public BodyStructure build() {
            return new BodyStructure(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    active, morphology, includedStructure, excludedStructure, description, image, patient);
        }
    }
}
