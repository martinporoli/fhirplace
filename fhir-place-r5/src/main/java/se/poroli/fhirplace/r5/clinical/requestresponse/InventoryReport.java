package se.poroli.fhirplace.r5.clinical.requestresponse;

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
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.InventoryCountType;
import se.poroli.fhirplace.r5.valuesets.InventoryReportStatus;

/**
 * A report of inventory or stock items.
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
 * @param identifier Business identifier for the report.
 * @param status draft | requested | active | entered-in-error. Required. Modifier element.
 * @param countType snapshot | difference. Required. Modifier element.
 * @param operationType addition | subtraction.
 * @param operationTypeReason The reason for this count - regular count, ad-hoc count, new arrivals, etc.
 * @param reportedDateTime When the report has been submitted. Required.
 * @param reporter Who submits the report. Reference to Practitioner, Patient, RelatedPerson, Device.
 * @param reportingPeriod The period the report refers to.
 * @param inventoryListing An inventory listing section (grouped by any of the attributes).
 * @param note A note associated with the InventoryReport.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/InventoryReport">FHIR R5 InventoryReport</a>
 */
public record InventoryReport(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        FhirEnum<InventoryReportStatus> status,
        FhirEnum<InventoryCountType> countType,
        CodeableConcept operationType,
        CodeableConcept operationTypeReason,
        FhirDateTime reportedDateTime,
        Reference reporter,
        Period reportingPeriod,
        List<InventoryListing> inventoryListing,
        List<Annotation> note) implements DomainResource {

    /**
     * Creates an {@code InventoryReport}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public InventoryReport {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        inventoryListing = inventoryListing == null ? List.of() : List.copyOf(inventoryListing);
        note = note == null ? List.of() : List.copyOf(note);
        Objects.requireNonNull(status, "InventoryReport.status is required");
        Objects.requireNonNull(countType, "InventoryReport.countType is required");
        Objects.requireNonNull(reportedDateTime, "InventoryReport.reportedDateTime is required");
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
     * Returns a builder initialized with the values of this {@code InventoryReport}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * An inventory listing section (grouped by any of the attributes).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param location Location of the inventory items. Reference to Location.
     * @param itemStatus The status of the items that are being reported.
     * @param countingDateTime The date and time when the items were counted.
     * @param item The item or items in this listing.
     */
    public record InventoryListing(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference location,
            CodeableConcept itemStatus,
            FhirDateTime countingDateTime,
            List<Item> item) implements BackboneElement {

        /**
         * Creates an {@code InventoryListing}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public InventoryListing {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            item = item == null ? List.of() : List.copyOf(item);
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
         * Returns a builder initialized with the values of this {@code InventoryListing}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * The item or items in this listing.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param category The inventory category or classification of the items being reported.
         * @param quantity The quantity of the item or items being reported. Required.
         * @param item The code or reference to the item type. Required.
         */
        public record Item(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept category,
                Quantity quantity,
                CodeableReference item) implements BackboneElement {

            /**
             * Creates an {@code Item}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Item {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(quantity, "InventoryReport.inventoryListing.item.quantity is required");
                Objects.requireNonNull(item, "InventoryReport.inventoryListing.item.item is required");
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
             * Returns a builder initialized with the values of this {@code Item}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Item}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept category;
                private Quantity quantity;
                private CodeableReference item;

                private Builder() {
                }

                private Builder(Item original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.category = original.category();
                    this.quantity = original.quantity();
                    this.item = original.item();
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
                 * Sets {@code category}.
                 *
                 * @param category the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder category(CodeableConcept category) {
                    this.category = category;
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
                 * Sets {@code item}.
                 *
                 * @param item the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder item(CodeableReference item) {
                    this.item = item;
                    return this;
                }

                /**
                 * Builds the {@code Item}.
                 *
                 * @return the {@code Item}
                 * @throws NullPointerException if a required element is absent
                 */
                public Item build() {
                    return new Item(
                            id, extension, modifierExtension, category, quantity, item);
                }
            }
        }

        /** Builder for {@link InventoryListing}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference location;
            private CodeableConcept itemStatus;
            private FhirDateTime countingDateTime;
            private List<Item> item = new ArrayList<>();

            private Builder() {
            }

            private Builder(InventoryListing original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.location = original.location();
                this.itemStatus = original.itemStatus();
                this.countingDateTime = original.countingDateTime();
                this.item = new ArrayList<>(original.item());
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
             * Sets {@code itemStatus}.
             *
             * @param itemStatus the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder itemStatus(CodeableConcept itemStatus) {
                this.itemStatus = itemStatus;
                return this;
            }

            /**
             * Sets {@code countingDateTime}.
             *
             * @param countingDateTime the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder countingDateTime(FhirDateTime countingDateTime) {
                this.countingDateTime = countingDateTime;
                return this;
            }

            /**
             * Sets {@code countingDateTime}, wrapped in a {@link FhirDateTime} without id or extensions.
             *
             * @param countingDateTime the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder countingDateTime(Temporal countingDateTime) {
                return countingDateTime(countingDateTime == null ? null : FhirDateTime.of(countingDateTime));
            }

            /**
             * Replaces all {@code item} values.
             *
             * @param item the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder item(List<Item> item) {
                this.item = item == null ? new ArrayList<>() : new ArrayList<>(item);
                return this;
            }

            /**
             * Adds a {@code item} value.
             *
             * @param item the value to add
             * @return this builder
             */
            public Builder addItem(Item item) {
                this.item.add(Objects.requireNonNull(item, "item"));
                return this;
            }

            /**
             * Builds the {@code InventoryListing}.
             *
             * @return the {@code InventoryListing}
             */
            public InventoryListing build() {
                return new InventoryListing(
                        id, extension, modifierExtension, location, itemStatus, countingDateTime, item);
            }
        }
    }

    /** Builder for {@link InventoryReport}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<InventoryReportStatus> status;
        private FhirEnum<InventoryCountType> countType;
        private CodeableConcept operationType;
        private CodeableConcept operationTypeReason;
        private FhirDateTime reportedDateTime;
        private Reference reporter;
        private Period reportingPeriod;
        private List<InventoryListing> inventoryListing = new ArrayList<>();
        private List<Annotation> note = new ArrayList<>();

        private Builder() {
        }

        private Builder(InventoryReport original) {
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
            this.countType = original.countType();
            this.operationType = original.operationType();
            this.operationTypeReason = original.operationTypeReason();
            this.reportedDateTime = original.reportedDateTime();
            this.reporter = original.reporter();
            this.reportingPeriod = original.reportingPeriod();
            this.inventoryListing = new ArrayList<>(original.inventoryListing());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<InventoryReportStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(InventoryReportStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code countType}.
         *
         * @param countType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder countType(FhirEnum<InventoryCountType> countType) {
            this.countType = countType;
            return this;
        }

        /**
         * Sets {@code countType}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param countType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder countType(InventoryCountType countType) {
            return countType(countType == null ? null : FhirEnum.of(countType));
        }

        /**
         * Sets {@code operationType}.
         *
         * @param operationType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder operationType(CodeableConcept operationType) {
            this.operationType = operationType;
            return this;
        }

        /**
         * Sets {@code operationTypeReason}.
         *
         * @param operationTypeReason the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder operationTypeReason(CodeableConcept operationTypeReason) {
            this.operationTypeReason = operationTypeReason;
            return this;
        }

        /**
         * Sets {@code reportedDateTime}.
         *
         * @param reportedDateTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reportedDateTime(FhirDateTime reportedDateTime) {
            this.reportedDateTime = reportedDateTime;
            return this;
        }

        /**
         * Sets {@code reportedDateTime}, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param reportedDateTime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reportedDateTime(Temporal reportedDateTime) {
            return reportedDateTime(reportedDateTime == null ? null : FhirDateTime.of(reportedDateTime));
        }

        /**
         * Sets {@code reporter}.
         *
         * @param reporter the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reporter(Reference reporter) {
            this.reporter = reporter;
            return this;
        }

        /**
         * Sets {@code reportingPeriod}.
         *
         * @param reportingPeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder reportingPeriod(Period reportingPeriod) {
            this.reportingPeriod = reportingPeriod;
            return this;
        }

        /**
         * Replaces all {@code inventoryListing} values.
         *
         * @param inventoryListing the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder inventoryListing(List<InventoryListing> inventoryListing) {
            this.inventoryListing = inventoryListing == null ? new ArrayList<>() : new ArrayList<>(inventoryListing);
            return this;
        }

        /**
         * Adds a {@code inventoryListing} value.
         *
         * @param inventoryListing the value to add
         * @return this builder
         */
        public Builder addInventoryListing(InventoryListing inventoryListing) {
            this.inventoryListing.add(Objects.requireNonNull(inventoryListing, "inventoryListing"));
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
         * Builds the {@code InventoryReport}.
         *
         * @return the {@code InventoryReport}
         * @throws NullPointerException if a required element is absent
         */
        public InventoryReport build() {
            return new InventoryReport(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    status, countType, operationType, operationTypeReason, reportedDateTime, reporter,
                    reportingPeriod, inventoryListing, note);
        }
    }
}
