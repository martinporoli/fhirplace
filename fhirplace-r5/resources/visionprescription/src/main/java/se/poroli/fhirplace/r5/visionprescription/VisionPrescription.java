package se.poroli.fhirplace.r5.visionprescription;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.math.BigDecimal;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;

/**
 * An authorization for the provision of glasses and/or contact lenses to a patient.
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
 * @param identifier Business Identifier for vision prescription.
 * @param status active | cancelled | draft | entered-in-error. Required. Modifier element.
 * @param created Response creation date. Required.
 * @param patient Who prescription is for. Reference to Patient. Required.
 * @param encounter Created during encounter / admission / stay. Reference to Encounter.
 * @param dateWritten When prescription was authorized. Required.
 * @param prescriber Who authorized the vision prescription. Reference to Practitioner, PractitionerRole. Required.
 * @param lensSpecification Vision lens authorization. Required.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/VisionPrescription">FHIR R5 VisionPrescription</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record VisionPrescription(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<FinancialResourceStatusCodes> status,
        FhirDateTime created,
        Reference patient,
        Reference encounter,
        FhirDateTime dateWritten,
        Reference prescriber,
        List<LensSpecification> lensSpecification) implements DomainResource {

    /**
     * Creates a {@code VisionPrescription}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     * @throws IllegalArgumentException if a required list is empty
     */
    public VisionPrescription {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        lensSpecification = lensSpecification == null ? List.of() : List.copyOf(lensSpecification);
        Objects.requireNonNull(status, "VisionPrescription.status is required");
        Objects.requireNonNull(created, "VisionPrescription.created is required");
        Objects.requireNonNull(patient, "VisionPrescription.patient is required");
        Objects.requireNonNull(dateWritten, "VisionPrescription.dateWritten is required");
        Objects.requireNonNull(prescriber, "VisionPrescription.prescriber is required");
        if (lensSpecification.isEmpty()) {
            throw new IllegalArgumentException("VisionPrescription.lensSpecification requires at least one value");
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
     * Returns a builder initialized with the values of this {@code VisionPrescription}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Contain the details of the individual lens specifications and serves as the authorization for the fullfillment
     * by certified professionals.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param product Product to be supplied. Required.
     * @param eye right | left. Required.
     * @param sphere Power of the lens.
     * @param cylinder Lens power for astigmatism.
     * @param axis Lens meridian which contain no power for astigmatism.
     * @param prism Eye alignment compensation.
     * @param add Added power for multifocal levels.
     * @param power Contact lens power.
     * @param backCurve Contact lens back curvature.
     * @param diameter Contact lens diameter.
     * @param duration Lens wear duration.
     * @param color Color required.
     * @param brand Brand required.
     * @param note Notes for coatings.
     */
    public record LensSpecification(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept product,
            FhirEnum<VisionEyes> eye,
            FhirDecimal sphere,
            FhirDecimal cylinder,
            FhirInteger axis,
            List<Prism> prism,
            FhirDecimal add,
            FhirDecimal power,
            FhirDecimal backCurve,
            FhirDecimal diameter,
            Quantity duration,
            FhirString color,
            FhirString brand,
            List<Annotation> note) implements BackboneElement {

        /**
         * Creates a {@code LensSpecification}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public LensSpecification {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            prism = prism == null ? List.of() : List.copyOf(prism);
            note = note == null ? List.of() : List.copyOf(note);
            Objects.requireNonNull(product, "VisionPrescription.lensSpecification.product is required");
            Objects.requireNonNull(eye, "VisionPrescription.lensSpecification.eye is required");
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
         * Returns a builder initialized with the values of this {@code LensSpecification}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Allows for adjustment on two axis.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param amount Amount of adjustment. Required.
         * @param base up | down | in | out. Required.
         */
        public record Prism(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirDecimal amount,
                FhirEnum<VisionBase> base) implements BackboneElement {

            /**
             * Creates a {@code Prism}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Prism {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(amount, "VisionPrescription.lensSpecification.prism.amount is required");
                Objects.requireNonNull(base, "VisionPrescription.lensSpecification.prism.base is required");
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
             * Returns a builder initialized with the values of this {@code Prism}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Prism}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirDecimal amount;
                private FhirEnum<VisionBase> base;

                private Builder() {
                }

                private Builder(Prism original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.amount = original.amount();
                    this.base = original.base();
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
                 * Sets {@code amount}.
                 *
                 * @param amount the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder amount(FhirDecimal amount) {
                    this.amount = amount;
                    return this;
                }

                /**
                 * Sets {@code amount}, wrapped in a {@link FhirDecimal} without id or extensions.
                 *
                 * @param amount the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder amount(BigDecimal amount) {
                    return amount(amount == null ? null : FhirDecimal.of(amount));
                }

                /**
                 * Sets {@code base}.
                 *
                 * @param base the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder base(FhirEnum<VisionBase> base) {
                    this.base = base;
                    return this;
                }

                /**
                 * Sets {@code base}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param base the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder base(VisionBase base) {
                    return base(base == null ? null : FhirEnum.of(base));
                }

                /**
                 * Builds the {@code Prism}.
                 *
                 * @return the {@code Prism}
                 * @throws NullPointerException if a required element is absent
                 */
                public Prism build() {
                    return new Prism(
                            id, extension, modifierExtension, amount, base);
                }
            }
        }

        /** Builder for {@link LensSpecification}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept product;
            private FhirEnum<VisionEyes> eye;
            private FhirDecimal sphere;
            private FhirDecimal cylinder;
            private FhirInteger axis;
            private List<Prism> prism = new ArrayList<>();
            private FhirDecimal add;
            private FhirDecimal power;
            private FhirDecimal backCurve;
            private FhirDecimal diameter;
            private Quantity duration;
            private FhirString color;
            private FhirString brand;
            private List<Annotation> note = new ArrayList<>();

            private Builder() {
            }

            private Builder(LensSpecification original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.product = original.product();
                this.eye = original.eye();
                this.sphere = original.sphere();
                this.cylinder = original.cylinder();
                this.axis = original.axis();
                this.prism = new ArrayList<>(original.prism());
                this.add = original.add();
                this.power = original.power();
                this.backCurve = original.backCurve();
                this.diameter = original.diameter();
                this.duration = original.duration();
                this.color = original.color();
                this.brand = original.brand();
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
             * Sets {@code product}.
             *
             * @param product the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder product(CodeableConcept product) {
                this.product = product;
                return this;
            }

            /**
             * Sets {@code eye}.
             *
             * @param eye the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder eye(FhirEnum<VisionEyes> eye) {
                this.eye = eye;
                return this;
            }

            /**
             * Sets {@code eye}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param eye the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder eye(VisionEyes eye) {
                return eye(eye == null ? null : FhirEnum.of(eye));
            }

            /**
             * Sets {@code sphere}.
             *
             * @param sphere the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sphere(FhirDecimal sphere) {
                this.sphere = sphere;
                return this;
            }

            /**
             * Sets {@code sphere}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param sphere the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sphere(BigDecimal sphere) {
                return sphere(sphere == null ? null : FhirDecimal.of(sphere));
            }

            /**
             * Sets {@code cylinder}.
             *
             * @param cylinder the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder cylinder(FhirDecimal cylinder) {
                this.cylinder = cylinder;
                return this;
            }

            /**
             * Sets {@code cylinder}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param cylinder the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder cylinder(BigDecimal cylinder) {
                return cylinder(cylinder == null ? null : FhirDecimal.of(cylinder));
            }

            /**
             * Sets {@code axis}.
             *
             * @param axis the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder axis(FhirInteger axis) {
                this.axis = axis;
                return this;
            }

            /**
             * Sets {@code axis}, wrapped in a {@link FhirInteger} without id or extensions.
             *
             * @param axis the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder axis(Integer axis) {
                return axis(axis == null ? null : FhirInteger.of(axis));
            }

            /**
             * Replaces all {@code prism} values.
             *
             * @param prism the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder prism(List<Prism> prism) {
                this.prism = prism == null ? new ArrayList<>() : new ArrayList<>(prism);
                return this;
            }

            /**
             * Adds a {@code prism} value.
             *
             * @param prism the value to add
             * @return this builder
             */
            public Builder addPrism(Prism prism) {
                this.prism.add(Objects.requireNonNull(prism, "prism"));
                return this;
            }

            /**
             * Sets {@code add}.
             *
             * @param add the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder add(FhirDecimal add) {
                this.add = add;
                return this;
            }

            /**
             * Sets {@code add}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param add the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder add(BigDecimal add) {
                return add(add == null ? null : FhirDecimal.of(add));
            }

            /**
             * Sets {@code power}.
             *
             * @param power the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder power(FhirDecimal power) {
                this.power = power;
                return this;
            }

            /**
             * Sets {@code power}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param power the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder power(BigDecimal power) {
                return power(power == null ? null : FhirDecimal.of(power));
            }

            /**
             * Sets {@code backCurve}.
             *
             * @param backCurve the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder backCurve(FhirDecimal backCurve) {
                this.backCurve = backCurve;
                return this;
            }

            /**
             * Sets {@code backCurve}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param backCurve the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder backCurve(BigDecimal backCurve) {
                return backCurve(backCurve == null ? null : FhirDecimal.of(backCurve));
            }

            /**
             * Sets {@code diameter}.
             *
             * @param diameter the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder diameter(FhirDecimal diameter) {
                this.diameter = diameter;
                return this;
            }

            /**
             * Sets {@code diameter}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param diameter the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder diameter(BigDecimal diameter) {
                return diameter(diameter == null ? null : FhirDecimal.of(diameter));
            }

            /**
             * Sets {@code duration}.
             *
             * @param duration the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder duration(Quantity duration) {
                this.duration = duration;
                return this;
            }

            /**
             * Sets {@code color}.
             *
             * @param color the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder color(FhirString color) {
                this.color = color;
                return this;
            }

            /**
             * Sets {@code color}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param color the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder color(String color) {
                return color(color == null ? null : FhirString.of(color));
            }

            /**
             * Sets {@code brand}.
             *
             * @param brand the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder brand(FhirString brand) {
                this.brand = brand;
                return this;
            }

            /**
             * Sets {@code brand}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param brand the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder brand(String brand) {
                return brand(brand == null ? null : FhirString.of(brand));
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
             * Builds the {@code LensSpecification}.
             *
             * @return the {@code LensSpecification}
             * @throws NullPointerException if a required element is absent
             */
            public LensSpecification build() {
                return new LensSpecification(
                        id, extension, modifierExtension, product, eye, sphere, cylinder, axis, prism, add, power,
                        backCurve, diameter, duration, color, brand, note);
            }
        }
    }

    /** Builder for {@link VisionPrescription}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<FinancialResourceStatusCodes> status;
        private FhirDateTime created;
        private Reference patient;
        private Reference encounter;
        private FhirDateTime dateWritten;
        private Reference prescriber;
        private List<LensSpecification> lensSpecification = new ArrayList<>();

        private Builder() {
        }

        private Builder(VisionPrescription original) {
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
            this.created = original.created();
            this.patient = original.patient();
            this.encounter = original.encounter();
            this.dateWritten = original.dateWritten();
            this.prescriber = original.prescriber();
            this.lensSpecification = new ArrayList<>(original.lensSpecification());
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
        public Builder status(FhirEnum<FinancialResourceStatusCodes> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FinancialResourceStatusCodes status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code created}.
         *
         * @param created the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder created(FhirDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * Sets {@code created}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param created the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder created(Temporal created) {
            return created(created == null ? null : FhirDateTime.of(created));
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
         * Sets {@code dateWritten}.
         *
         * @param dateWritten the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dateWritten(FhirDateTime dateWritten) {
            this.dateWritten = dateWritten;
            return this;
        }

        /**
         * Sets {@code dateWritten}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param dateWritten the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder dateWritten(Temporal dateWritten) {
            return dateWritten(dateWritten == null ? null : FhirDateTime.of(dateWritten));
        }

        /**
         * Sets {@code prescriber}.
         *
         * @param prescriber the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder prescriber(Reference prescriber) {
            this.prescriber = prescriber;
            return this;
        }

        /**
         * Replaces all {@code lensSpecification} values.
         *
         * @param lensSpecification the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder lensSpecification(List<LensSpecification> lensSpecification) {
            this.lensSpecification = lensSpecification == null
                    ? new ArrayList<>()
                    : new ArrayList<>(lensSpecification);
            return this;
        }

        /**
         * Adds a {@code lensSpecification} value.
         *
         * @param lensSpecification the value to add
         * @return this builder
         */
        public Builder addLensSpecification(LensSpecification lensSpecification) {
            this.lensSpecification.add(Objects.requireNonNull(lensSpecification, "lensSpecification"));
            return this;
        }

        /**
         * Builds the {@code VisionPrescription}.
         *
         * @return the {@code VisionPrescription}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public VisionPrescription build() {
            return new VisionPrescription(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, created, patient, encounter, dateWritten, prescriber, lensSpecification);
        }
    }
}
