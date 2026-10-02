package se.poroli.fhirplace.r5.deviceassociation;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * A record of association of a device.
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
 * @param identifier Instance identifier.
 * @param device Reference to the devices associated with the patient or group. Reference to Device. Required.
 * @param category Describes the relationship between the device and subject.
 * @param status implanted | explanted | attached | entered-in-error | unknown. Required.
 * @param statusReason The reasons given for the current association status.
 * @param subject The individual, group of individuals or device that the device is on or associated with. Reference
 *   to Patient, Group, Practitioner, RelatedPerson, Device.
 * @param bodyStructure Current anatomical location of the device in/on subject. Reference to BodyStructure.
 * @param period Begin and end dates and times for the device association.
 * @param operation The details about the device when it is in use to describe its operation.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DeviceAssociation">FHIR R5 DeviceAssociation</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public record DeviceAssociation(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        Reference device,
        List<CodeableConcept> category,
        CodeableConcept status,
        List<CodeableConcept> statusReason,
        Reference subject,
        Reference bodyStructure,
        Period period,
        List<Operation> operation) implements DomainResource {

    /**
     * Creates a {@code DeviceAssociation}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public DeviceAssociation {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        category = category == null ? List.of() : List.copyOf(category);
        statusReason = statusReason == null ? List.of() : List.copyOf(statusReason);
        operation = operation == null ? List.of() : List.copyOf(operation);
        Objects.requireNonNull(device, "DeviceAssociation.device is required");
        Objects.requireNonNull(status, "DeviceAssociation.status is required");
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
     * Returns a builder initialized with the values of this {@code DeviceAssociation}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The details about the device when it is in use to describe its operation.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param status Device operational condition. Required.
     * @param operator The individual performing the action enabled by the device. Reference to Patient, Practitioner,
     *   RelatedPerson.
     * @param period Begin and end dates and times for the device's operation.
     */
    public record Operation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept status,
            List<Reference> operator,
            Period period) implements BackboneElement {

        /**
         * Creates an {@code Operation}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Operation {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            operator = operator == null ? List.of() : List.copyOf(operator);
            Objects.requireNonNull(status, "DeviceAssociation.operation.status is required");
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
         * Returns a builder initialized with the values of this {@code Operation}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Operation}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept status;
            private List<Reference> operator = new ArrayList<>();
            private Period period;

            private Builder() {
            }

            private Builder(Operation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.status = original.status();
                this.operator = new ArrayList<>(original.operator());
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
            public Builder status(CodeableConcept status) {
                this.status = status;
                return this;
            }

            /**
             * Replaces all {@code operator} values.
             *
             * @param operator the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder operator(List<Reference> operator) {
                this.operator = operator == null ? new ArrayList<>() : new ArrayList<>(operator);
                return this;
            }

            /**
             * Adds a {@code operator} value.
             *
             * @param operator the value to add
             * @return this builder
             */
            public Builder addOperator(Reference operator) {
                this.operator.add(Objects.requireNonNull(operator, "operator"));
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
             * Builds the {@code Operation}.
             *
             * @return the {@code Operation}
             * @throws NullPointerException if a required element is absent
             */
            public Operation build() {
                return new Operation(
                        id, extension, modifierExtension, status, operator, period);
            }
        }
    }

    /** Builder for {@link DeviceAssociation}. Builders are mutable and not thread-safe. */
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
        private Reference device;
        private List<CodeableConcept> category = new ArrayList<>();
        private CodeableConcept status;
        private List<CodeableConcept> statusReason = new ArrayList<>();
        private Reference subject;
        private Reference bodyStructure;
        private Period period;
        private List<Operation> operation = new ArrayList<>();

        private Builder() {
        }

        private Builder(DeviceAssociation original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.device = original.device();
            this.category = new ArrayList<>(original.category());
            this.status = original.status();
            this.statusReason = new ArrayList<>(original.statusReason());
            this.subject = original.subject();
            this.bodyStructure = original.bodyStructure();
            this.period = original.period();
            this.operation = new ArrayList<>(original.operation());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(CodeableConcept status) {
            this.status = status;
            return this;
        }

        /**
         * Replaces all {@code statusReason} values.
         *
         * @param statusReason the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder statusReason(List<CodeableConcept> statusReason) {
            this.statusReason = statusReason == null ? new ArrayList<>() : new ArrayList<>(statusReason);
            return this;
        }

        /**
         * Adds a {@code statusReason} value.
         *
         * @param statusReason the value to add
         * @return this builder
         */
        public Builder addStatusReason(CodeableConcept statusReason) {
            this.statusReason.add(Objects.requireNonNull(statusReason, "statusReason"));
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
         * Sets {@code bodyStructure}.
         *
         * @param bodyStructure the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder bodyStructure(Reference bodyStructure) {
            this.bodyStructure = bodyStructure;
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
         * Replaces all {@code operation} values.
         *
         * @param operation the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder operation(List<Operation> operation) {
            this.operation = operation == null ? new ArrayList<>() : new ArrayList<>(operation);
            return this;
        }

        /**
         * Adds a {@code operation} value.
         *
         * @param operation the value to add
         * @return this builder
         */
        public Builder addOperation(Operation operation) {
            this.operation.add(Objects.requireNonNull(operation, "operation"));
            return this;
        }

        /**
         * Builds the {@code DeviceAssociation}.
         *
         * @return the {@code DeviceAssociation}
         * @throws NullPointerException if a required element is absent
         */
        public DeviceAssociation build() {
            return new DeviceAssociation(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    device, category, status, statusReason, subject, bodyStructure, period, operation);
        }
    }
}
