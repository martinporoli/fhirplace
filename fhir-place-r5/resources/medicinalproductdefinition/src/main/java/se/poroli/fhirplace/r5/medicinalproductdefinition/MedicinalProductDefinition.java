package se.poroli.fhirplace.r5.medicinalproductdefinition;

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
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use,
 * drug catalogs, to support prescribing, adverse events management etc.).
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
 * @param identifier Business identifier for this product. Could be an MPID.
 * @param type Regulatory type, e.g. Investigational or Authorized.
 * @param domain If this medicine applies to human or veterinary uses.
 * @param version A business identifier relating to a specific version of the product.
 * @param status The status within the lifecycle of this product record. Modifier element.
 * @param statusDate The date at which the given status became applicable.
 * @param description General description of this product.
 * @param combinedPharmaceuticalDoseForm The dose form for a single part product, or combined form of a multiple part
 *   product.
 * @param route The path by which the product is taken into or makes contact with the body.
 * @param indication Description of indication(s) for this product, used when structured indications are not required.
 * @param legalStatusOfSupply The legal status of supply of the medicinal product as classified by the regulator.
 * @param additionalMonitoringIndicator Whether the Medicinal Product is subject to additional monitoring for
 *   regulatory reasons.
 * @param specialMeasures Whether the Medicinal Product is subject to special measures for regulatory reasons.
 * @param pediatricUseIndicator If authorised for use in children.
 * @param classification Allows the product to be classified by various systems.
 * @param marketingStatus Marketing status of the medicinal product, in contrast to marketing authorization.
 * @param packagedMedicinalProduct Package type for the product.
 * @param comprisedOf Types of medicinal manufactured items and/or devices that this product consists of, such as
 *   tablets, capsule, or syringes. Reference to ManufacturedItemDefinition, DeviceDefinition.
 * @param ingredient The ingredients of this medicinal product - when not detailed in other resources.
 * @param impurity Any component of the drug product which is not the chemical entity defined as the drug substance,
 *   or an excipient in the drug product.
 * @param attachedDocument Additional documentation about the medicinal product. Reference to DocumentReference.
 * @param masterFile A master file for the medicinal product (e.g. Pharmacovigilance System Master File). Reference to
 *   DocumentReference.
 * @param contact A product specific contact, person (in a role), or an organization.
 * @param clinicalTrial Clinical trials or studies that this product is involved in. Reference to ResearchStudy.
 * @param code A code that this product is known by, within some formal terminology.
 * @param name The product's name, including full name and possibly coded parts. Required.
 * @param crossReference Reference to another product, e.g. for linking authorised to investigational product.
 * @param operation A manufacturing or administrative process for the medicinal product.
 * @param characteristic Key product features such as "sugar free", "modified release".
 * @see <a href="http://hl7.org/fhir/StructureDefinition/MedicinalProductDefinition">FHIR R5 MedicinalProductDefinition</a>
 */
public record MedicinalProductDefinition(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        CodeableConcept type,
        CodeableConcept domain,
        FhirString version,
        CodeableConcept status,
        FhirDateTime statusDate,
        FhirMarkdown description,
        CodeableConcept combinedPharmaceuticalDoseForm,
        List<CodeableConcept> route,
        FhirMarkdown indication,
        CodeableConcept legalStatusOfSupply,
        CodeableConcept additionalMonitoringIndicator,
        List<CodeableConcept> specialMeasures,
        CodeableConcept pediatricUseIndicator,
        List<CodeableConcept> classification,
        List<MarketingStatus> marketingStatus,
        List<CodeableConcept> packagedMedicinalProduct,
        List<Reference> comprisedOf,
        List<CodeableConcept> ingredient,
        List<CodeableReference> impurity,
        List<Reference> attachedDocument,
        List<Reference> masterFile,
        List<Contact> contact,
        List<Reference> clinicalTrial,
        List<Coding> code,
        List<Name> name,
        List<CrossReference> crossReference,
        List<Operation> operation,
        List<Characteristic> characteristic) implements DomainResource {

    /**
     * Creates a {@code MedicinalProductDefinition}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     * @throws IllegalArgumentException if a required list is empty
     */
    public MedicinalProductDefinition {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        route = route == null ? List.of() : List.copyOf(route);
        specialMeasures = specialMeasures == null ? List.of() : List.copyOf(specialMeasures);
        classification = classification == null ? List.of() : List.copyOf(classification);
        marketingStatus = marketingStatus == null ? List.of() : List.copyOf(marketingStatus);
        packagedMedicinalProduct =
                packagedMedicinalProduct == null ? List.of() : List.copyOf(packagedMedicinalProduct);
        comprisedOf = comprisedOf == null ? List.of() : List.copyOf(comprisedOf);
        ingredient = ingredient == null ? List.of() : List.copyOf(ingredient);
        impurity = impurity == null ? List.of() : List.copyOf(impurity);
        attachedDocument = attachedDocument == null ? List.of() : List.copyOf(attachedDocument);
        masterFile = masterFile == null ? List.of() : List.copyOf(masterFile);
        contact = contact == null ? List.of() : List.copyOf(contact);
        clinicalTrial = clinicalTrial == null ? List.of() : List.copyOf(clinicalTrial);
        code = code == null ? List.of() : List.copyOf(code);
        name = name == null ? List.of() : List.copyOf(name);
        crossReference = crossReference == null ? List.of() : List.copyOf(crossReference);
        operation = operation == null ? List.of() : List.copyOf(operation);
        characteristic = characteristic == null ? List.of() : List.copyOf(characteristic);
        if (name.isEmpty()) {
            throw new IllegalArgumentException("MedicinalProductDefinition.name requires at least one value");
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
     * Returns a builder initialized with the values of this {@code MedicinalProductDefinition}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A product specific contact, person (in a role), or an organization.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Allows the contact to be classified, for example QPPV, Pharmacovigilance Enquiry Information.
     * @param contact A product specific contact, person (in a role), or an organization. Reference to Organization,
     *   PractitionerRole. Required.
     */
    public record Contact(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            Reference contact) implements BackboneElement {

        /**
         * Creates a {@code Contact}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Contact {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(contact, "MedicinalProductDefinition.contact.contact is required");
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
         * Returns a builder initialized with the values of this {@code Contact}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Contact}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private Reference contact;

            private Builder() {
            }

            private Builder(Contact original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.contact = original.contact();
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
             * Sets {@code contact}.
             *
             * @param contact the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder contact(Reference contact) {
                this.contact = contact;
                return this;
            }

            /**
             * Builds the {@code Contact}.
             *
             * @return the {@code Contact}
             * @throws NullPointerException if a required element is absent
             */
            public Contact build() {
                return new Contact(
                        id, extension, modifierExtension, type, contact);
            }
        }
    }

    /**
     * The product's name, including full name and possibly coded parts.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param productName The full product name. Required.
     * @param type Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary.
     * @param part Coding words or phrases of the name.
     * @param usage Country and jurisdiction where the name applies.
     */
    public record Name(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirString productName,
            CodeableConcept type,
            List<Part> part,
            List<Usage> usage) implements BackboneElement {

        /**
         * Creates a {@code Name}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Name {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            part = part == null ? List.of() : List.copyOf(part);
            usage = usage == null ? List.of() : List.copyOf(usage);
            Objects.requireNonNull(productName, "MedicinalProductDefinition.name.productName is required");
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
         * Returns a builder initialized with the values of this {@code Name}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Coding words or phrases of the name.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param part A fragment of a product name. Required.
         * @param type Identifying type for this part of the name (e.g. strength part). Required.
         */
        public record Part(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString part,
                CodeableConcept type) implements BackboneElement {

            /**
             * Creates a {@code Part}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Part {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(part, "MedicinalProductDefinition.name.part.part is required");
                Objects.requireNonNull(type, "MedicinalProductDefinition.name.part.type is required");
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
             * Returns a builder initialized with the values of this {@code Part}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Part}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString part;
                private CodeableConcept type;

                private Builder() {
                }

                private Builder(Part original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.part = original.part();
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
                 * Sets {@code part}.
                 *
                 * @param part the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder part(FhirString part) {
                    this.part = part;
                    return this;
                }

                /**
                 * Sets {@code part}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param part the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder part(String part) {
                    return part(part == null ? null : FhirString.of(part));
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
                 * Builds the {@code Part}.
                 *
                 * @return the {@code Part}
                 * @throws NullPointerException if a required element is absent
                 */
                public Part build() {
                    return new Part(
                            id, extension, modifierExtension, part, type);
                }
            }
        }

        /**
         * Country and jurisdiction where the name applies, and associated language.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param country Country code for where this name applies. Required.
         * @param jurisdiction Jurisdiction code for where this name applies.
         * @param language Language code for this name. Required.
         */
        public record Usage(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept country,
                CodeableConcept jurisdiction,
                CodeableConcept language) implements BackboneElement {

            /**
             * Creates an {@code Usage}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Usage {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(country, "MedicinalProductDefinition.name.usage.country is required");
                Objects.requireNonNull(language, "MedicinalProductDefinition.name.usage.language is required");
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
             * Returns a builder initialized with the values of this {@code Usage}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Usage}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept country;
                private CodeableConcept jurisdiction;
                private CodeableConcept language;

                private Builder() {
                }

                private Builder(Usage original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.country = original.country();
                    this.jurisdiction = original.jurisdiction();
                    this.language = original.language();
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
                 * Sets {@code country}.
                 *
                 * @param country the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder country(CodeableConcept country) {
                    this.country = country;
                    return this;
                }

                /**
                 * Sets {@code jurisdiction}.
                 *
                 * @param jurisdiction the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder jurisdiction(CodeableConcept jurisdiction) {
                    this.jurisdiction = jurisdiction;
                    return this;
                }

                /**
                 * Sets {@code language}.
                 *
                 * @param language the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder language(CodeableConcept language) {
                    this.language = language;
                    return this;
                }

                /**
                 * Builds the {@code Usage}.
                 *
                 * @return the {@code Usage}
                 * @throws NullPointerException if a required element is absent
                 */
                public Usage build() {
                    return new Usage(
                            id, extension, modifierExtension, country, jurisdiction, language);
                }
            }
        }

        /** Builder for {@link Name}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirString productName;
            private CodeableConcept type;
            private List<Part> part = new ArrayList<>();
            private List<Usage> usage = new ArrayList<>();

            private Builder() {
            }

            private Builder(Name original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.productName = original.productName();
                this.type = original.type();
                this.part = new ArrayList<>(original.part());
                this.usage = new ArrayList<>(original.usage());
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
             * Sets {@code productName}.
             *
             * @param productName the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder productName(FhirString productName) {
                this.productName = productName;
                return this;
            }

            /**
             * Sets {@code productName}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param productName the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder productName(String productName) {
                return productName(productName == null ? null : FhirString.of(productName));
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
             * Replaces all {@code part} values.
             *
             * @param part the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder part(List<Part> part) {
                this.part = part == null ? new ArrayList<>() : new ArrayList<>(part);
                return this;
            }

            /**
             * Adds a {@code part} value.
             *
             * @param part the value to add
             * @return this builder
             */
            public Builder addPart(Part part) {
                this.part.add(Objects.requireNonNull(part, "part"));
                return this;
            }

            /**
             * Replaces all {@code usage} values.
             *
             * @param usage the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder usage(List<Usage> usage) {
                this.usage = usage == null ? new ArrayList<>() : new ArrayList<>(usage);
                return this;
            }

            /**
             * Adds a {@code usage} value.
             *
             * @param usage the value to add
             * @return this builder
             */
            public Builder addUsage(Usage usage) {
                this.usage.add(Objects.requireNonNull(usage, "usage"));
                return this;
            }

            /**
             * Builds the {@code Name}.
             *
             * @return the {@code Name}
             * @throws NullPointerException if a required element is absent
             */
            public Name build() {
                return new Name(
                        id, extension, modifierExtension, productName, type, part, usage);
            }
        }
    }

    /**
     * Reference to another product, e.g. for linking authorised to investigational product, or a virtual product.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param product Reference to another product, e.g. for linking authorised to investigational product. Required.
     * @param type The type of relationship, for instance branded to generic or virtual to actual product.
     */
    public record CrossReference(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference product,
            CodeableConcept type) implements BackboneElement {

        /**
         * Creates a {@code CrossReference}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public CrossReference {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(product, "MedicinalProductDefinition.crossReference.product is required");
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
         * Returns a builder initialized with the values of this {@code CrossReference}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link CrossReference}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableReference product;
            private CodeableConcept type;

            private Builder() {
            }

            private Builder(CrossReference original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.product = original.product();
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
             * Sets {@code product}.
             *
             * @param product the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder product(CodeableReference product) {
                this.product = product;
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
             * Builds the {@code CrossReference}.
             *
             * @return the {@code CrossReference}
             * @throws NullPointerException if a required element is absent
             */
            public CrossReference build() {
                return new CrossReference(
                        id, extension, modifierExtension, product, type);
            }
        }
    }

    /**
     * A manufacturing or administrative process or step associated with (or performed on) the medicinal product.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type The type of manufacturing operation e.g. manufacturing itself, re-packaging.
     * @param effectiveDate Date range of applicability.
     * @param organization The organization responsible for the particular process, e.g. the manufacturer or importer.
     *   Reference to Organization.
     * @param confidentialityIndicator Specifies whether this process is considered proprietary or confidential.
     */
    public record Operation(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableReference type,
            Period effectiveDate,
            List<Reference> organization,
            CodeableConcept confidentialityIndicator) implements BackboneElement {

        /**
         * Creates an {@code Operation}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Operation {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            organization = organization == null ? List.of() : List.copyOf(organization);
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
            private CodeableReference type;
            private Period effectiveDate;
            private List<Reference> organization = new ArrayList<>();
            private CodeableConcept confidentialityIndicator;

            private Builder() {
            }

            private Builder(Operation original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.effectiveDate = original.effectiveDate();
                this.organization = new ArrayList<>(original.organization());
                this.confidentialityIndicator = original.confidentialityIndicator();
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
            public Builder type(CodeableReference type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code effectiveDate}.
             *
             * @param effectiveDate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder effectiveDate(Period effectiveDate) {
                this.effectiveDate = effectiveDate;
                return this;
            }

            /**
             * Replaces all {@code organization} values.
             *
             * @param organization the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder organization(List<Reference> organization) {
                this.organization = organization == null ? new ArrayList<>() : new ArrayList<>(organization);
                return this;
            }

            /**
             * Adds a {@code organization} value.
             *
             * @param organization the value to add
             * @return this builder
             */
            public Builder addOrganization(Reference organization) {
                this.organization.add(Objects.requireNonNull(organization, "organization"));
                return this;
            }

            /**
             * Sets {@code confidentialityIndicator}.
             *
             * @param confidentialityIndicator the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder confidentialityIndicator(CodeableConcept confidentialityIndicator) {
                this.confidentialityIndicator = confidentialityIndicator;
                return this;
            }

            /**
             * Builds the {@code Operation}.
             *
             * @return the {@code Operation}
             */
            public Operation build() {
                return new Operation(
                        id, extension, modifierExtension, type, effectiveDate, organization, confidentialityIndicator);
            }
        }
    }

    /**
     * Allows the key product features to be recorded, such as "sugar free", "modified release", "parallel import".
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type A code expressing the type of characteristic. Required.
     * @param value A value for the characteristic. One of CodeableConcept, markdown, Quantity, integer, date,
     *   boolean, Attachment.
     */
    public record Characteristic(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType value) implements BackboneElement {

        /**
         * Creates a {@code Characteristic}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Characteristic {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "MedicinalProductDefinition.characteristic.type is required");
            if (value != null && !(value instanceof CodeableConcept
                    || value instanceof FhirMarkdown
                    || value instanceof Quantity
                    || value instanceof FhirInteger
                    || value instanceof FhirDate
                    || value instanceof FhirBoolean
                    || value instanceof Attachment)) {
                throw new IllegalArgumentException(
                        "MedicinalProductDefinition.characteristic.value[x] does not allow "
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
         * Returns a builder initialized with the values of this {@code Characteristic}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Characteristic}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private DataType value;

            private Builder() {
            }

            private Builder(Characteristic original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
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
             * Sets {@code value} to a CodeableConcept.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(CodeableConcept value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a markdown.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirMarkdown value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a Quantity.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Quantity value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a integer.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirInteger value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a date.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirDate value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a boolean.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(FhirBoolean value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a Attachment.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Attachment value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a markdown without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(String value) {
                this.value = value == null ? null : FhirMarkdown.of(value);
                return this;
            }

            /**
             * Sets {@code value} to a integer without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Integer value) {
                this.value = value == null ? null : FhirInteger.of(value);
                return this;
            }

            /**
             * Sets {@code value} to a date without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Temporal value) {
                this.value = value == null ? null : FhirDate.of(value);
                return this;
            }

            /**
             * Sets {@code value} to a boolean without id or extensions.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Boolean value) {
                this.value = value == null ? null : FhirBoolean.of(value);
                return this;
            }

            /**
             * Builds the {@code Characteristic}.
             *
             * @return the {@code Characteristic}
             * @throws NullPointerException if a required element is absent
             */
            public Characteristic build() {
                return new Characteristic(
                        id, extension, modifierExtension, type, value);
            }
        }
    }

    /** Builder for {@link MedicinalProductDefinition}. Builders are mutable and not thread-safe. */
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
        private CodeableConcept type;
        private CodeableConcept domain;
        private FhirString version;
        private CodeableConcept status;
        private FhirDateTime statusDate;
        private FhirMarkdown description;
        private CodeableConcept combinedPharmaceuticalDoseForm;
        private List<CodeableConcept> route = new ArrayList<>();
        private FhirMarkdown indication;
        private CodeableConcept legalStatusOfSupply;
        private CodeableConcept additionalMonitoringIndicator;
        private List<CodeableConcept> specialMeasures = new ArrayList<>();
        private CodeableConcept pediatricUseIndicator;
        private List<CodeableConcept> classification = new ArrayList<>();
        private List<MarketingStatus> marketingStatus = new ArrayList<>();
        private List<CodeableConcept> packagedMedicinalProduct = new ArrayList<>();
        private List<Reference> comprisedOf = new ArrayList<>();
        private List<CodeableConcept> ingredient = new ArrayList<>();
        private List<CodeableReference> impurity = new ArrayList<>();
        private List<Reference> attachedDocument = new ArrayList<>();
        private List<Reference> masterFile = new ArrayList<>();
        private List<Contact> contact = new ArrayList<>();
        private List<Reference> clinicalTrial = new ArrayList<>();
        private List<Coding> code = new ArrayList<>();
        private List<Name> name = new ArrayList<>();
        private List<CrossReference> crossReference = new ArrayList<>();
        private List<Operation> operation = new ArrayList<>();
        private List<Characteristic> characteristic = new ArrayList<>();

        private Builder() {
        }

        private Builder(MedicinalProductDefinition original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.type = original.type();
            this.domain = original.domain();
            this.version = original.version();
            this.status = original.status();
            this.statusDate = original.statusDate();
            this.description = original.description();
            this.combinedPharmaceuticalDoseForm = original.combinedPharmaceuticalDoseForm();
            this.route = new ArrayList<>(original.route());
            this.indication = original.indication();
            this.legalStatusOfSupply = original.legalStatusOfSupply();
            this.additionalMonitoringIndicator = original.additionalMonitoringIndicator();
            this.specialMeasures = new ArrayList<>(original.specialMeasures());
            this.pediatricUseIndicator = original.pediatricUseIndicator();
            this.classification = new ArrayList<>(original.classification());
            this.marketingStatus = new ArrayList<>(original.marketingStatus());
            this.packagedMedicinalProduct = new ArrayList<>(original.packagedMedicinalProduct());
            this.comprisedOf = new ArrayList<>(original.comprisedOf());
            this.ingredient = new ArrayList<>(original.ingredient());
            this.impurity = new ArrayList<>(original.impurity());
            this.attachedDocument = new ArrayList<>(original.attachedDocument());
            this.masterFile = new ArrayList<>(original.masterFile());
            this.contact = new ArrayList<>(original.contact());
            this.clinicalTrial = new ArrayList<>(original.clinicalTrial());
            this.code = new ArrayList<>(original.code());
            this.name = new ArrayList<>(original.name());
            this.crossReference = new ArrayList<>(original.crossReference());
            this.operation = new ArrayList<>(original.operation());
            this.characteristic = new ArrayList<>(original.characteristic());
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
         * Sets {@code domain}.
         *
         * @param domain the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder domain(CodeableConcept domain) {
            this.domain = domain;
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
         * Sets {@code statusDate}.
         *
         * @param statusDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusDate(FhirDateTime statusDate) {
            this.statusDate = statusDate;
            return this;
        }

        /**
         * Sets {@code statusDate}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param statusDate the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder statusDate(Temporal statusDate) {
            return statusDate(statusDate == null ? null : FhirDateTime.of(statusDate));
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
         * Sets {@code combinedPharmaceuticalDoseForm}.
         *
         * @param combinedPharmaceuticalDoseForm the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder combinedPharmaceuticalDoseForm(CodeableConcept combinedPharmaceuticalDoseForm) {
            this.combinedPharmaceuticalDoseForm = combinedPharmaceuticalDoseForm;
            return this;
        }

        /**
         * Replaces all {@code route} values.
         *
         * @param route the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder route(List<CodeableConcept> route) {
            this.route = route == null ? new ArrayList<>() : new ArrayList<>(route);
            return this;
        }

        /**
         * Adds a {@code route} value.
         *
         * @param route the value to add
         * @return this builder
         */
        public Builder addRoute(CodeableConcept route) {
            this.route.add(Objects.requireNonNull(route, "route"));
            return this;
        }

        /**
         * Sets {@code indication}.
         *
         * @param indication the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder indication(FhirMarkdown indication) {
            this.indication = indication;
            return this;
        }

        /**
         * Sets {@code indication}, wrapped in a {@link FhirMarkdown} without id or extensions.
         *
         * @param indication the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder indication(String indication) {
            return indication(indication == null ? null : FhirMarkdown.of(indication));
        }

        /**
         * Sets {@code legalStatusOfSupply}.
         *
         * @param legalStatusOfSupply the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder legalStatusOfSupply(CodeableConcept legalStatusOfSupply) {
            this.legalStatusOfSupply = legalStatusOfSupply;
            return this;
        }

        /**
         * Sets {@code additionalMonitoringIndicator}.
         *
         * @param additionalMonitoringIndicator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder additionalMonitoringIndicator(CodeableConcept additionalMonitoringIndicator) {
            this.additionalMonitoringIndicator = additionalMonitoringIndicator;
            return this;
        }

        /**
         * Replaces all {@code specialMeasures} values.
         *
         * @param specialMeasures the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder specialMeasures(List<CodeableConcept> specialMeasures) {
            this.specialMeasures = specialMeasures == null ? new ArrayList<>() : new ArrayList<>(specialMeasures);
            return this;
        }

        /**
         * Adds a {@code specialMeasures} value.
         *
         * @param specialMeasures the value to add
         * @return this builder
         */
        public Builder addSpecialMeasures(CodeableConcept specialMeasures) {
            this.specialMeasures.add(Objects.requireNonNull(specialMeasures, "specialMeasures"));
            return this;
        }

        /**
         * Sets {@code pediatricUseIndicator}.
         *
         * @param pediatricUseIndicator the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder pediatricUseIndicator(CodeableConcept pediatricUseIndicator) {
            this.pediatricUseIndicator = pediatricUseIndicator;
            return this;
        }

        /**
         * Replaces all {@code classification} values.
         *
         * @param classification the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder classification(List<CodeableConcept> classification) {
            this.classification = classification == null ? new ArrayList<>() : new ArrayList<>(classification);
            return this;
        }

        /**
         * Adds a {@code classification} value.
         *
         * @param classification the value to add
         * @return this builder
         */
        public Builder addClassification(CodeableConcept classification) {
            this.classification.add(Objects.requireNonNull(classification, "classification"));
            return this;
        }

        /**
         * Replaces all {@code marketingStatus} values.
         *
         * @param marketingStatus the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder marketingStatus(List<MarketingStatus> marketingStatus) {
            this.marketingStatus = marketingStatus == null ? new ArrayList<>() : new ArrayList<>(marketingStatus);
            return this;
        }

        /**
         * Adds a {@code marketingStatus} value.
         *
         * @param marketingStatus the value to add
         * @return this builder
         */
        public Builder addMarketingStatus(MarketingStatus marketingStatus) {
            this.marketingStatus.add(Objects.requireNonNull(marketingStatus, "marketingStatus"));
            return this;
        }

        /**
         * Replaces all {@code packagedMedicinalProduct} values.
         *
         * @param packagedMedicinalProduct the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder packagedMedicinalProduct(List<CodeableConcept> packagedMedicinalProduct) {
            this.packagedMedicinalProduct = packagedMedicinalProduct == null
                    ? new ArrayList<>()
                    : new ArrayList<>(packagedMedicinalProduct);
            return this;
        }

        /**
         * Adds a {@code packagedMedicinalProduct} value.
         *
         * @param packagedMedicinalProduct the value to add
         * @return this builder
         */
        public Builder addPackagedMedicinalProduct(CodeableConcept packagedMedicinalProduct) {
            this.packagedMedicinalProduct.add(
                    Objects.requireNonNull(packagedMedicinalProduct, "packagedMedicinalProduct"));
            return this;
        }

        /**
         * Replaces all {@code comprisedOf} values.
         *
         * @param comprisedOf the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder comprisedOf(List<Reference> comprisedOf) {
            this.comprisedOf = comprisedOf == null ? new ArrayList<>() : new ArrayList<>(comprisedOf);
            return this;
        }

        /**
         * Adds a {@code comprisedOf} value.
         *
         * @param comprisedOf the value to add
         * @return this builder
         */
        public Builder addComprisedOf(Reference comprisedOf) {
            this.comprisedOf.add(Objects.requireNonNull(comprisedOf, "comprisedOf"));
            return this;
        }

        /**
         * Replaces all {@code ingredient} values.
         *
         * @param ingredient the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder ingredient(List<CodeableConcept> ingredient) {
            this.ingredient = ingredient == null ? new ArrayList<>() : new ArrayList<>(ingredient);
            return this;
        }

        /**
         * Adds a {@code ingredient} value.
         *
         * @param ingredient the value to add
         * @return this builder
         */
        public Builder addIngredient(CodeableConcept ingredient) {
            this.ingredient.add(Objects.requireNonNull(ingredient, "ingredient"));
            return this;
        }

        /**
         * Replaces all {@code impurity} values.
         *
         * @param impurity the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder impurity(List<CodeableReference> impurity) {
            this.impurity = impurity == null ? new ArrayList<>() : new ArrayList<>(impurity);
            return this;
        }

        /**
         * Adds a {@code impurity} value.
         *
         * @param impurity the value to add
         * @return this builder
         */
        public Builder addImpurity(CodeableReference impurity) {
            this.impurity.add(Objects.requireNonNull(impurity, "impurity"));
            return this;
        }

        /**
         * Replaces all {@code attachedDocument} values.
         *
         * @param attachedDocument the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder attachedDocument(List<Reference> attachedDocument) {
            this.attachedDocument = attachedDocument == null ? new ArrayList<>() : new ArrayList<>(attachedDocument);
            return this;
        }

        /**
         * Adds a {@code attachedDocument} value.
         *
         * @param attachedDocument the value to add
         * @return this builder
         */
        public Builder addAttachedDocument(Reference attachedDocument) {
            this.attachedDocument.add(Objects.requireNonNull(attachedDocument, "attachedDocument"));
            return this;
        }

        /**
         * Replaces all {@code masterFile} values.
         *
         * @param masterFile the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder masterFile(List<Reference> masterFile) {
            this.masterFile = masterFile == null ? new ArrayList<>() : new ArrayList<>(masterFile);
            return this;
        }

        /**
         * Adds a {@code masterFile} value.
         *
         * @param masterFile the value to add
         * @return this builder
         */
        public Builder addMasterFile(Reference masterFile) {
            this.masterFile.add(Objects.requireNonNull(masterFile, "masterFile"));
            return this;
        }

        /**
         * Replaces all {@code contact} values.
         *
         * @param contact the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder contact(List<Contact> contact) {
            this.contact = contact == null ? new ArrayList<>() : new ArrayList<>(contact);
            return this;
        }

        /**
         * Adds a {@code contact} value.
         *
         * @param contact the value to add
         * @return this builder
         */
        public Builder addContact(Contact contact) {
            this.contact.add(Objects.requireNonNull(contact, "contact"));
            return this;
        }

        /**
         * Replaces all {@code clinicalTrial} values.
         *
         * @param clinicalTrial the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder clinicalTrial(List<Reference> clinicalTrial) {
            this.clinicalTrial = clinicalTrial == null ? new ArrayList<>() : new ArrayList<>(clinicalTrial);
            return this;
        }

        /**
         * Adds a {@code clinicalTrial} value.
         *
         * @param clinicalTrial the value to add
         * @return this builder
         */
        public Builder addClinicalTrial(Reference clinicalTrial) {
            this.clinicalTrial.add(Objects.requireNonNull(clinicalTrial, "clinicalTrial"));
            return this;
        }

        /**
         * Replaces all {@code code} values.
         *
         * @param code the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder code(List<Coding> code) {
            this.code = code == null ? new ArrayList<>() : new ArrayList<>(code);
            return this;
        }

        /**
         * Adds a {@code code} value.
         *
         * @param code the value to add
         * @return this builder
         */
        public Builder addCode(Coding code) {
            this.code.add(Objects.requireNonNull(code, "code"));
            return this;
        }

        /**
         * Replaces all {@code name} values.
         *
         * @param name the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder name(List<Name> name) {
            this.name = name == null ? new ArrayList<>() : new ArrayList<>(name);
            return this;
        }

        /**
         * Adds a {@code name} value.
         *
         * @param name the value to add
         * @return this builder
         */
        public Builder addName(Name name) {
            this.name.add(Objects.requireNonNull(name, "name"));
            return this;
        }

        /**
         * Replaces all {@code crossReference} values.
         *
         * @param crossReference the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder crossReference(List<CrossReference> crossReference) {
            this.crossReference = crossReference == null ? new ArrayList<>() : new ArrayList<>(crossReference);
            return this;
        }

        /**
         * Adds a {@code crossReference} value.
         *
         * @param crossReference the value to add
         * @return this builder
         */
        public Builder addCrossReference(CrossReference crossReference) {
            this.crossReference.add(Objects.requireNonNull(crossReference, "crossReference"));
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
         * Replaces all {@code characteristic} values.
         *
         * @param characteristic the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder characteristic(List<Characteristic> characteristic) {
            this.characteristic = characteristic == null ? new ArrayList<>() : new ArrayList<>(characteristic);
            return this;
        }

        /**
         * Adds a {@code characteristic} value.
         *
         * @param characteristic the value to add
         * @return this builder
         */
        public Builder addCharacteristic(Characteristic characteristic) {
            this.characteristic.add(Objects.requireNonNull(characteristic, "characteristic"));
            return this;
        }

        /**
         * Builds the {@code MedicinalProductDefinition}.
         *
         * @return the {@code MedicinalProductDefinition}
         * @throws NullPointerException if a required element is absent
         * @throws IllegalArgumentException if a required list is empty
         */
        public MedicinalProductDefinition build() {
            return new MedicinalProductDefinition(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    type, domain, version, status, statusDate, description, combinedPharmaceuticalDoseForm, route,
                    indication, legalStatusOfSupply, additionalMonitoringIndicator, specialMeasures,
                    pediatricUseIndicator, classification, marketingStatus, packagedMedicinalProduct, comprisedOf,
                    ingredient, impurity, attachedDocument, masterFile, contact, clinicalTrial, code, name,
                    crossReference, operation, characteristic);
        }
    }
}
