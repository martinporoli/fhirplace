package se.poroli.fhirplace.r5.claimresponse;

import java.math.BigDecimal;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.ClaimProcessingCodes;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.Use;

/**
 * This resource provides the adjudication details from the processing of a Claim resource.
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
 * @param identifier Business Identifier for a claim response.
 * @param traceNumber Number for tracking.
 * @param status active | cancelled | draft | entered-in-error. Required. Modifier element.
 * @param type More granular claim type. Required.
 * @param subType More granular claim type.
 * @param use claim | preauthorization | predetermination. Required.
 * @param patient The recipient of the products and services. Reference to Patient. Required.
 * @param created Response creation date. Required.
 * @param insurer Party responsible for reimbursement. Reference to Organization.
 * @param requestor Party responsible for the claim. Reference to Practitioner, PractitionerRole, Organization.
 * @param request Id of resource triggering adjudication. Reference to Claim.
 * @param outcome queued | complete | error | partial. Required.
 * @param decision Result of the adjudication.
 * @param disposition Disposition Message.
 * @param preAuthRef Preauthorization reference.
 * @param preAuthPeriod Preauthorization reference effective period.
 * @param event Event information.
 * @param payeeType Party to be paid any benefits payable.
 * @param encounter Encounters associated with the listed treatments. Reference to Encounter.
 * @param diagnosisRelatedGroup Package billing code.
 * @param item Adjudication for claim line items.
 * @param addItem Insurer added line items.
 * @param adjudication Header-level adjudication.
 * @param total Adjudication totals.
 * @param payment Payment Details.
 * @param fundsReserve Funds reserved status.
 * @param formCode Printed form identifier.
 * @param form Printed reference or actual form.
 * @param processNote Note concerning adjudication.
 * @param communicationRequest Request for additional information. Reference to CommunicationRequest.
 * @param insurance Patient insurance information.
 * @param error Processing errors.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/ClaimResponse">FHIR R5 ClaimResponse</a>
 */
public record ClaimResponse(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        List<Identifier> identifier,
        List<Identifier> traceNumber,
        FhirEnum<FinancialResourceStatusCodes> status,
        CodeableConcept type,
        CodeableConcept subType,
        FhirEnum<Use> use,
        Reference patient,
        FhirDateTime created,
        Reference insurer,
        Reference requestor,
        Reference request,
        FhirEnum<ClaimProcessingCodes> outcome,
        CodeableConcept decision,
        FhirString disposition,
        FhirString preAuthRef,
        Period preAuthPeriod,
        List<Event> event,
        CodeableConcept payeeType,
        List<Reference> encounter,
        CodeableConcept diagnosisRelatedGroup,
        List<Item> item,
        List<AddedItem> addItem,
        List<ClaimResponse.Item.Adjudication> adjudication,
        List<Total> total,
        Payment payment,
        CodeableConcept fundsReserve,
        CodeableConcept formCode,
        Attachment form,
        List<Note> processNote,
        List<Reference> communicationRequest,
        List<Insurance> insurance,
        List<ClaimResponseError> error) implements DomainResource {

    /**
     * Creates a {@code ClaimResponse}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public ClaimResponse {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
        event = event == null ? List.of() : List.copyOf(event);
        encounter = encounter == null ? List.of() : List.copyOf(encounter);
        item = item == null ? List.of() : List.copyOf(item);
        addItem = addItem == null ? List.of() : List.copyOf(addItem);
        adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
        total = total == null ? List.of() : List.copyOf(total);
        processNote = processNote == null ? List.of() : List.copyOf(processNote);
        communicationRequest = communicationRequest == null ? List.of() : List.copyOf(communicationRequest);
        insurance = insurance == null ? List.of() : List.copyOf(insurance);
        error = error == null ? List.of() : List.copyOf(error);
        Objects.requireNonNull(status, "ClaimResponse.status is required");
        Objects.requireNonNull(type, "ClaimResponse.type is required");
        Objects.requireNonNull(use, "ClaimResponse.use is required");
        Objects.requireNonNull(patient, "ClaimResponse.patient is required");
        Objects.requireNonNull(created, "ClaimResponse.created is required");
        Objects.requireNonNull(outcome, "ClaimResponse.outcome is required");
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
     * Returns a builder initialized with the values of this {@code ClaimResponse}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Information code for an event with a corresponding date or period.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Specific event. Required.
     * @param when Occurance date or period. One of dateTime, Period. Required.
     */
    public record Event(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            DataType when) implements BackboneElement {

        /**
         * Creates an {@code Event}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Event {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "ClaimResponse.event.type is required");
            Objects.requireNonNull(when, "ClaimResponse.event.when is required");
            if (when != null && !(when instanceof FhirDateTime || when instanceof Period)) {
                throw new IllegalArgumentException(
                        "ClaimResponse.event.when[x] must be one of dateTime, Period, but was "
                                + when.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code Event}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Event}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private DataType when;

            private Builder() {
            }

            private Builder(Event original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.when = original.when();
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
             * Sets {@code when} to a dateTime.
             *
             * @param when the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder when(FhirDateTime when) {
                this.when = when;
                return this;
            }

            /**
             * Sets {@code when} to a Period.
             *
             * @param when the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder when(Period when) {
                this.when = when;
                return this;
            }

            /**
             * Sets {@code when} to a dateTime without id or extensions.
             *
             * @param when the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder when(Temporal when) {
                this.when = when == null ? null : FhirDateTime.of(when);
                return this;
            }

            /**
             * Builds the {@code Event}.
             *
             * @return the {@code Event}
             * @throws NullPointerException if a required element is absent
             */
            public Event build() {
                return new Event(
                        id, extension, modifierExtension, type, when);
            }
        }
    }

    /**
     * A claim line.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param itemSequence Claim item instance identifier. Required.
     * @param traceNumber Number for tracking.
     * @param noteNumber Applicable note numbers.
     * @param reviewOutcome Adjudication results.
     * @param adjudication Adjudication details.
     * @param detail Adjudication for claim details.
     */
    public record Item(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt itemSequence,
            List<Identifier> traceNumber,
            List<FhirPositiveInt> noteNumber,
            ReviewOutcome reviewOutcome,
            List<Adjudication> adjudication,
            List<ItemDetail> detail) implements BackboneElement {

        /**
         * Creates an {@code Item}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Item {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
            noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
            adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
            detail = detail == null ? List.of() : List.copyOf(detail);
            Objects.requireNonNull(itemSequence, "ClaimResponse.item.itemSequence is required");
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

        /**
         * The high-level results of the adjudication if adjudication has been performed.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param decision Result of the adjudication.
         * @param reason Reason for result of the adjudication.
         * @param preAuthRef Preauthorization reference.
         * @param preAuthPeriod Preauthorization reference effective period.
         */
        public record ReviewOutcome(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept decision,
                List<CodeableConcept> reason,
                FhirString preAuthRef,
                Period preAuthPeriod) implements BackboneElement {

            /**
             * Creates a {@code ReviewOutcome}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public ReviewOutcome {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                reason = reason == null ? List.of() : List.copyOf(reason);
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
             * Returns a builder initialized with the values of this {@code ReviewOutcome}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link ReviewOutcome}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept decision;
                private List<CodeableConcept> reason = new ArrayList<>();
                private FhirString preAuthRef;
                private Period preAuthPeriod;

                private Builder() {
                }

                private Builder(ReviewOutcome original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.decision = original.decision();
                    this.reason = new ArrayList<>(original.reason());
                    this.preAuthRef = original.preAuthRef();
                    this.preAuthPeriod = original.preAuthPeriod();
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
                 * Sets {@code decision}.
                 *
                 * @param decision the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder decision(CodeableConcept decision) {
                    this.decision = decision;
                    return this;
                }

                /**
                 * Replaces all {@code reason} values.
                 *
                 * @param reason the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder reason(List<CodeableConcept> reason) {
                    this.reason = reason == null ? new ArrayList<>() : new ArrayList<>(reason);
                    return this;
                }

                /**
                 * Adds a {@code reason} value.
                 *
                 * @param reason the value to add
                 * @return this builder
                 */
                public Builder addReason(CodeableConcept reason) {
                    this.reason.add(Objects.requireNonNull(reason, "reason"));
                    return this;
                }

                /**
                 * Sets {@code preAuthRef}.
                 *
                 * @param preAuthRef the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder preAuthRef(FhirString preAuthRef) {
                    this.preAuthRef = preAuthRef;
                    return this;
                }

                /**
                 * Sets {@code preAuthRef}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param preAuthRef the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder preAuthRef(String preAuthRef) {
                    return preAuthRef(preAuthRef == null ? null : FhirString.of(preAuthRef));
                }

                /**
                 * Sets {@code preAuthPeriod}.
                 *
                 * @param preAuthPeriod the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder preAuthPeriod(Period preAuthPeriod) {
                    this.preAuthPeriod = preAuthPeriod;
                    return this;
                }

                /**
                 * Builds the {@code ReviewOutcome}.
                 *
                 * @return the {@code ReviewOutcome}
                 */
                public ReviewOutcome build() {
                    return new ReviewOutcome(
                            id, extension, modifierExtension, decision, reason, preAuthRef, preAuthPeriod);
                }
            }
        }

        /**
         * If this item is a group then the values here are a summary of the adjudication of the detail items.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param category Type of adjudication information. Required.
         * @param reason Explanation of adjudication outcome.
         * @param amount Monetary amount.
         * @param quantity Non-monetary value.
         */
        public record Adjudication(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                CodeableConcept category,
                CodeableConcept reason,
                Money amount,
                Quantity quantity) implements BackboneElement {

            /**
             * Creates an {@code Adjudication}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Adjudication {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(category, "ClaimResponse.item.adjudication.category is required");
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
             * Returns a builder initialized with the values of this {@code Adjudication}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Adjudication}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private CodeableConcept category;
                private CodeableConcept reason;
                private Money amount;
                private Quantity quantity;

                private Builder() {
                }

                private Builder(Adjudication original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.category = original.category();
                    this.reason = original.reason();
                    this.amount = original.amount();
                    this.quantity = original.quantity();
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
                 * Sets {@code reason}.
                 *
                 * @param reason the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder reason(CodeableConcept reason) {
                    this.reason = reason;
                    return this;
                }

                /**
                 * Sets {@code amount}.
                 *
                 * @param amount the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder amount(Money amount) {
                    this.amount = amount;
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
                 * Builds the {@code Adjudication}.
                 *
                 * @return the {@code Adjudication}
                 * @throws NullPointerException if a required element is absent
                 */
                public Adjudication build() {
                    return new Adjudication(
                            id, extension, modifierExtension, category, reason, amount, quantity);
                }
            }
        }

        /**
         * A claim detail.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param detailSequence Claim detail instance identifier. Required.
         * @param traceNumber Number for tracking.
         * @param noteNumber Applicable note numbers.
         * @param reviewOutcome Detail level adjudication results.
         * @param adjudication Detail level adjudication details.
         * @param subDetail Adjudication for claim sub-details.
         */
        public record ItemDetail(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirPositiveInt detailSequence,
                List<Identifier> traceNumber,
                List<FhirPositiveInt> noteNumber,
                ClaimResponse.Item.ReviewOutcome reviewOutcome,
                List<ClaimResponse.Item.Adjudication> adjudication,
                List<SubDetail> subDetail) implements BackboneElement {

            /**
             * Creates an {@code ItemDetail}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public ItemDetail {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
                noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
                adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
                subDetail = subDetail == null ? List.of() : List.copyOf(subDetail);
                Objects.requireNonNull(detailSequence, "ClaimResponse.item.detail.detailSequence is required");
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
             * Returns a builder initialized with the values of this {@code ItemDetail}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * A sub-detail adjudication of a simple product or service.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param subDetailSequence Claim sub-detail instance identifier. Required.
             * @param traceNumber Number for tracking.
             * @param noteNumber Applicable note numbers.
             * @param reviewOutcome Subdetail level adjudication results.
             * @param adjudication Subdetail level adjudication details.
             */
            public record SubDetail(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirPositiveInt subDetailSequence,
                    List<Identifier> traceNumber,
                    List<FhirPositiveInt> noteNumber,
                    ClaimResponse.Item.ReviewOutcome reviewOutcome,
                    List<ClaimResponse.Item.Adjudication> adjudication) implements BackboneElement {

                /**
                 * Creates a {@code SubDetail}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public SubDetail {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
                    noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
                    adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
                    Objects.requireNonNull(
                            subDetailSequence, "ClaimResponse.item.detail.subDetail.subDetailSequence is required");
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
                 * Returns a builder initialized with the values of this {@code SubDetail}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link SubDetail}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirPositiveInt subDetailSequence;
                    private List<Identifier> traceNumber = new ArrayList<>();
                    private List<FhirPositiveInt> noteNumber = new ArrayList<>();
                    private ClaimResponse.Item.ReviewOutcome reviewOutcome;
                    private List<ClaimResponse.Item.Adjudication> adjudication = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(SubDetail original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.subDetailSequence = original.subDetailSequence();
                        this.traceNumber = new ArrayList<>(original.traceNumber());
                        this.noteNumber = new ArrayList<>(original.noteNumber());
                        this.reviewOutcome = original.reviewOutcome();
                        this.adjudication = new ArrayList<>(original.adjudication());
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
                     * Sets {@code subDetailSequence}.
                     *
                     * @param subDetailSequence the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder subDetailSequence(FhirPositiveInt subDetailSequence) {
                        this.subDetailSequence = subDetailSequence;
                        return this;
                    }

                    /**
                     * Sets {@code subDetailSequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
                     *
                     * @param subDetailSequence the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder subDetailSequence(Integer subDetailSequence) {
                        return subDetailSequence(
                                subDetailSequence == null ? null : FhirPositiveInt.of(subDetailSequence));
                    }

                    /**
                     * Replaces all {@code traceNumber} values.
                     *
                     * @param traceNumber the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder traceNumber(List<Identifier> traceNumber) {
                        this.traceNumber = traceNumber == null ? new ArrayList<>() : new ArrayList<>(traceNumber);
                        return this;
                    }

                    /**
                     * Adds a {@code traceNumber} value.
                     *
                     * @param traceNumber the value to add
                     * @return this builder
                     */
                    public Builder addTraceNumber(Identifier traceNumber) {
                        this.traceNumber.add(Objects.requireNonNull(traceNumber, "traceNumber"));
                        return this;
                    }

                    /**
                     * Replaces all {@code noteNumber} values.
                     *
                     * @param noteNumber the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                        this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                        return this;
                    }

                    /**
                     * Adds a {@code noteNumber} value.
                     *
                     * @param noteNumber the value to add
                     * @return this builder
                     */
                    public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                        this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                        return this;
                    }

                    /**
                     * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
                     *
                     * @param noteNumber the value to add
                     * @return this builder
                     */
                    public Builder addNoteNumber(Integer noteNumber) {
                        return addNoteNumber(FhirPositiveInt.of(noteNumber));
                    }

                    /**
                     * Sets {@code reviewOutcome}.
                     *
                     * @param reviewOutcome the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder reviewOutcome(ClaimResponse.Item.ReviewOutcome reviewOutcome) {
                        this.reviewOutcome = reviewOutcome;
                        return this;
                    }

                    /**
                     * Replaces all {@code adjudication} values.
                     *
                     * @param adjudication the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder adjudication(List<ClaimResponse.Item.Adjudication> adjudication) {
                        this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                        return this;
                    }

                    /**
                     * Adds a {@code adjudication} value.
                     *
                     * @param adjudication the value to add
                     * @return this builder
                     */
                    public Builder addAdjudication(ClaimResponse.Item.Adjudication adjudication) {
                        this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
                        return this;
                    }

                    /**
                     * Builds the {@code SubDetail}.
                     *
                     * @return the {@code SubDetail}
                     * @throws NullPointerException if a required element is absent
                     */
                    public SubDetail build() {
                        return new SubDetail(
                                id, extension, modifierExtension, subDetailSequence, traceNumber, noteNumber,
                                reviewOutcome, adjudication);
                    }
                }
            }

            /** Builder for {@link ItemDetail}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirPositiveInt detailSequence;
                private List<Identifier> traceNumber = new ArrayList<>();
                private List<FhirPositiveInt> noteNumber = new ArrayList<>();
                private ClaimResponse.Item.ReviewOutcome reviewOutcome;
                private List<ClaimResponse.Item.Adjudication> adjudication = new ArrayList<>();
                private List<SubDetail> subDetail = new ArrayList<>();

                private Builder() {
                }

                private Builder(ItemDetail original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.detailSequence = original.detailSequence();
                    this.traceNumber = new ArrayList<>(original.traceNumber());
                    this.noteNumber = new ArrayList<>(original.noteNumber());
                    this.reviewOutcome = original.reviewOutcome();
                    this.adjudication = new ArrayList<>(original.adjudication());
                    this.subDetail = new ArrayList<>(original.subDetail());
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
                 * Sets {@code detailSequence}.
                 *
                 * @param detailSequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detailSequence(FhirPositiveInt detailSequence) {
                    this.detailSequence = detailSequence;
                    return this;
                }

                /**
                 * Sets {@code detailSequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param detailSequence the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder detailSequence(Integer detailSequence) {
                    return detailSequence(detailSequence == null ? null : FhirPositiveInt.of(detailSequence));
                }

                /**
                 * Replaces all {@code traceNumber} values.
                 *
                 * @param traceNumber the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder traceNumber(List<Identifier> traceNumber) {
                    this.traceNumber = traceNumber == null ? new ArrayList<>() : new ArrayList<>(traceNumber);
                    return this;
                }

                /**
                 * Adds a {@code traceNumber} value.
                 *
                 * @param traceNumber the value to add
                 * @return this builder
                 */
                public Builder addTraceNumber(Identifier traceNumber) {
                    this.traceNumber.add(Objects.requireNonNull(traceNumber, "traceNumber"));
                    return this;
                }

                /**
                 * Replaces all {@code noteNumber} values.
                 *
                 * @param noteNumber the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                    this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                    return this;
                }

                /**
                 * Adds a {@code noteNumber} value.
                 *
                 * @param noteNumber the value to add
                 * @return this builder
                 */
                public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                    this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                    return this;
                }

                /**
                 * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param noteNumber the value to add
                 * @return this builder
                 */
                public Builder addNoteNumber(Integer noteNumber) {
                    return addNoteNumber(FhirPositiveInt.of(noteNumber));
                }

                /**
                 * Sets {@code reviewOutcome}.
                 *
                 * @param reviewOutcome the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder reviewOutcome(ClaimResponse.Item.ReviewOutcome reviewOutcome) {
                    this.reviewOutcome = reviewOutcome;
                    return this;
                }

                /**
                 * Replaces all {@code adjudication} values.
                 *
                 * @param adjudication the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder adjudication(List<ClaimResponse.Item.Adjudication> adjudication) {
                    this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                    return this;
                }

                /**
                 * Adds a {@code adjudication} value.
                 *
                 * @param adjudication the value to add
                 * @return this builder
                 */
                public Builder addAdjudication(ClaimResponse.Item.Adjudication adjudication) {
                    this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
                    return this;
                }

                /**
                 * Replaces all {@code subDetail} values.
                 *
                 * @param subDetail the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder subDetail(List<SubDetail> subDetail) {
                    this.subDetail = subDetail == null ? new ArrayList<>() : new ArrayList<>(subDetail);
                    return this;
                }

                /**
                 * Adds a {@code subDetail} value.
                 *
                 * @param subDetail the value to add
                 * @return this builder
                 */
                public Builder addSubDetail(SubDetail subDetail) {
                    this.subDetail.add(Objects.requireNonNull(subDetail, "subDetail"));
                    return this;
                }

                /**
                 * Builds the {@code ItemDetail}.
                 *
                 * @return the {@code ItemDetail}
                 * @throws NullPointerException if a required element is absent
                 */
                public ItemDetail build() {
                    return new ItemDetail(
                            id, extension, modifierExtension, detailSequence, traceNumber, noteNumber, reviewOutcome,
                            adjudication, subDetail);
                }
            }
        }

        /** Builder for {@link Item}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt itemSequence;
            private List<Identifier> traceNumber = new ArrayList<>();
            private List<FhirPositiveInt> noteNumber = new ArrayList<>();
            private ReviewOutcome reviewOutcome;
            private List<Adjudication> adjudication = new ArrayList<>();
            private List<ItemDetail> detail = new ArrayList<>();

            private Builder() {
            }

            private Builder(Item original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.itemSequence = original.itemSequence();
                this.traceNumber = new ArrayList<>(original.traceNumber());
                this.noteNumber = new ArrayList<>(original.noteNumber());
                this.reviewOutcome = original.reviewOutcome();
                this.adjudication = new ArrayList<>(original.adjudication());
                this.detail = new ArrayList<>(original.detail());
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
             * Sets {@code itemSequence}.
             *
             * @param itemSequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder itemSequence(FhirPositiveInt itemSequence) {
                this.itemSequence = itemSequence;
                return this;
            }

            /**
             * Sets {@code itemSequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param itemSequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder itemSequence(Integer itemSequence) {
                return itemSequence(itemSequence == null ? null : FhirPositiveInt.of(itemSequence));
            }

            /**
             * Replaces all {@code traceNumber} values.
             *
             * @param traceNumber the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder traceNumber(List<Identifier> traceNumber) {
                this.traceNumber = traceNumber == null ? new ArrayList<>() : new ArrayList<>(traceNumber);
                return this;
            }

            /**
             * Adds a {@code traceNumber} value.
             *
             * @param traceNumber the value to add
             * @return this builder
             */
            public Builder addTraceNumber(Identifier traceNumber) {
                this.traceNumber.add(Objects.requireNonNull(traceNumber, "traceNumber"));
                return this;
            }

            /**
             * Replaces all {@code noteNumber} values.
             *
             * @param noteNumber the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                return this;
            }

            /**
             * Adds a {@code noteNumber} value.
             *
             * @param noteNumber the value to add
             * @return this builder
             */
            public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                return this;
            }

            /**
             * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param noteNumber the value to add
             * @return this builder
             */
            public Builder addNoteNumber(Integer noteNumber) {
                return addNoteNumber(FhirPositiveInt.of(noteNumber));
            }

            /**
             * Sets {@code reviewOutcome}.
             *
             * @param reviewOutcome the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reviewOutcome(ReviewOutcome reviewOutcome) {
                this.reviewOutcome = reviewOutcome;
                return this;
            }

            /**
             * Replaces all {@code adjudication} values.
             *
             * @param adjudication the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder adjudication(List<Adjudication> adjudication) {
                this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                return this;
            }

            /**
             * Adds a {@code adjudication} value.
             *
             * @param adjudication the value to add
             * @return this builder
             */
            public Builder addAdjudication(Adjudication adjudication) {
                this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
                return this;
            }

            /**
             * Replaces all {@code detail} values.
             *
             * @param detail the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder detail(List<ItemDetail> detail) {
                this.detail = detail == null ? new ArrayList<>() : new ArrayList<>(detail);
                return this;
            }

            /**
             * Adds a {@code detail} value.
             *
             * @param detail the value to add
             * @return this builder
             */
            public Builder addDetail(ItemDetail detail) {
                this.detail.add(Objects.requireNonNull(detail, "detail"));
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
                        id, extension, modifierExtension, itemSequence, traceNumber, noteNumber, reviewOutcome,
                        adjudication, detail);
            }
        }
    }

    /**
     * The first-tier service adjudications for payor added product or service lines.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param itemSequence Item sequence number.
     * @param detailSequence Detail sequence number.
     * @param subdetailSequence Subdetail sequence number.
     * @param traceNumber Number for tracking.
     * @param provider Authorized providers. Reference to Practitioner, PractitionerRole, Organization.
     * @param revenue Revenue or cost center code.
     * @param productOrService Billing, service, product, or drug code.
     * @param productOrServiceEnd End of a range of codes.
     * @param request Request or Referral for Service. Reference to DeviceRequest, MedicationRequest, NutritionOrder,
     *   ServiceRequest, SupplyRequest, VisionPrescription.
     * @param modifier Service/Product billing modifiers.
     * @param programCode Program the product or service is provided under.
     * @param serviced Date or dates of service or product delivery. One of date, Period.
     * @param location Place of service or where product was supplied. One of CodeableConcept, Address, Reference.
     * @param quantity Count of products or services.
     * @param unitPrice Fee, charge or cost per item.
     * @param factor Price scaling factor.
     * @param tax Total tax.
     * @param net Total item cost.
     * @param bodySite Anatomical location.
     * @param noteNumber Applicable note numbers.
     * @param reviewOutcome Added items adjudication results.
     * @param adjudication Added items adjudication.
     * @param detail Insurer added line details.
     */
    public record AddedItem(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<FhirPositiveInt> itemSequence,
            List<FhirPositiveInt> detailSequence,
            List<FhirPositiveInt> subdetailSequence,
            List<Identifier> traceNumber,
            List<Reference> provider,
            CodeableConcept revenue,
            CodeableConcept productOrService,
            CodeableConcept productOrServiceEnd,
            List<Reference> request,
            List<CodeableConcept> modifier,
            List<CodeableConcept> programCode,
            DataType serviced,
            DataType location,
            Quantity quantity,
            Money unitPrice,
            FhirDecimal factor,
            Money tax,
            Money net,
            List<BodySite> bodySite,
            List<FhirPositiveInt> noteNumber,
            ClaimResponse.Item.ReviewOutcome reviewOutcome,
            List<ClaimResponse.Item.Adjudication> adjudication,
            List<AddedItemDetail> detail) implements BackboneElement {

        /**
         * Creates an {@code AddedItem}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public AddedItem {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            itemSequence = itemSequence == null ? List.of() : List.copyOf(itemSequence);
            detailSequence = detailSequence == null ? List.of() : List.copyOf(detailSequence);
            subdetailSequence = subdetailSequence == null ? List.of() : List.copyOf(subdetailSequence);
            traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
            provider = provider == null ? List.of() : List.copyOf(provider);
            request = request == null ? List.of() : List.copyOf(request);
            modifier = modifier == null ? List.of() : List.copyOf(modifier);
            programCode = programCode == null ? List.of() : List.copyOf(programCode);
            bodySite = bodySite == null ? List.of() : List.copyOf(bodySite);
            noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
            adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
            detail = detail == null ? List.of() : List.copyOf(detail);
            if (serviced != null && !(serviced instanceof FhirDate || serviced instanceof Period)) {
                throw new IllegalArgumentException(
                        "ClaimResponse.addItem.serviced[x] must be one of date, Period, but was "
                                + serviced.getClass().getSimpleName());
            }
            if (location != null && !(location instanceof CodeableConcept
                    || location instanceof Address
                    || location instanceof Reference)) {
                throw new IllegalArgumentException(
                        "ClaimResponse.addItem.location[x] does not allow "
                                + location.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code AddedItem}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Physical location where the service is performed or applies.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param site Location. Required.
         * @param subSite Sub-location.
         */
        public record BodySite(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<CodeableReference> site,
                List<CodeableConcept> subSite) implements BackboneElement {

            /**
             * Creates a {@code BodySite}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             * @throws IllegalArgumentException if a required list is empty
             */
            public BodySite {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                site = site == null ? List.of() : List.copyOf(site);
                subSite = subSite == null ? List.of() : List.copyOf(subSite);
                if (site.isEmpty()) {
                    throw new IllegalArgumentException(
                            "ClaimResponse.addItem.bodySite.site requires at least one value");
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
             * Returns a builder initialized with the values of this {@code BodySite}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link BodySite}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<CodeableReference> site = new ArrayList<>();
                private List<CodeableConcept> subSite = new ArrayList<>();

                private Builder() {
                }

                private Builder(BodySite original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.site = new ArrayList<>(original.site());
                    this.subSite = new ArrayList<>(original.subSite());
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
                 * Replaces all {@code site} values.
                 *
                 * @param site the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder site(List<CodeableReference> site) {
                    this.site = site == null ? new ArrayList<>() : new ArrayList<>(site);
                    return this;
                }

                /**
                 * Adds a {@code site} value.
                 *
                 * @param site the value to add
                 * @return this builder
                 */
                public Builder addSite(CodeableReference site) {
                    this.site.add(Objects.requireNonNull(site, "site"));
                    return this;
                }

                /**
                 * Replaces all {@code subSite} values.
                 *
                 * @param subSite the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder subSite(List<CodeableConcept> subSite) {
                    this.subSite = subSite == null ? new ArrayList<>() : new ArrayList<>(subSite);
                    return this;
                }

                /**
                 * Adds a {@code subSite} value.
                 *
                 * @param subSite the value to add
                 * @return this builder
                 */
                public Builder addSubSite(CodeableConcept subSite) {
                    this.subSite.add(Objects.requireNonNull(subSite, "subSite"));
                    return this;
                }

                /**
                 * Builds the {@code BodySite}.
                 *
                 * @return the {@code BodySite}
                 * @throws NullPointerException if a required element is absent
                 * @throws IllegalArgumentException if a required list is empty
                 */
                public BodySite build() {
                    return new BodySite(
                            id, extension, modifierExtension, site, subSite);
                }
            }
        }

        /**
         * The second-tier service adjudications for payor added services.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param traceNumber Number for tracking.
         * @param revenue Revenue or cost center code.
         * @param productOrService Billing, service, product, or drug code.
         * @param productOrServiceEnd End of a range of codes.
         * @param modifier Service/Product billing modifiers.
         * @param quantity Count of products or services.
         * @param unitPrice Fee, charge or cost per item.
         * @param factor Price scaling factor.
         * @param tax Total tax.
         * @param net Total item cost.
         * @param noteNumber Applicable note numbers.
         * @param reviewOutcome Added items detail level adjudication results.
         * @param adjudication Added items detail adjudication.
         * @param subDetail Insurer added line items.
         */
        public record AddedItemDetail(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<Identifier> traceNumber,
                CodeableConcept revenue,
                CodeableConcept productOrService,
                CodeableConcept productOrServiceEnd,
                List<CodeableConcept> modifier,
                Quantity quantity,
                Money unitPrice,
                FhirDecimal factor,
                Money tax,
                Money net,
                List<FhirPositiveInt> noteNumber,
                ClaimResponse.Item.ReviewOutcome reviewOutcome,
                List<ClaimResponse.Item.Adjudication> adjudication,
                List<AddedItemSubDetail> subDetail) implements BackboneElement {

            /**
             * Creates an {@code AddedItemDetail}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public AddedItemDetail {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
                modifier = modifier == null ? List.of() : List.copyOf(modifier);
                noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
                adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
                subDetail = subDetail == null ? List.of() : List.copyOf(subDetail);
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
             * Returns a builder initialized with the values of this {@code AddedItemDetail}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * The third-tier service adjudications for payor added services.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param traceNumber Number for tracking.
             * @param revenue Revenue or cost center code.
             * @param productOrService Billing, service, product, or drug code.
             * @param productOrServiceEnd End of a range of codes.
             * @param modifier Service/Product billing modifiers.
             * @param quantity Count of products or services.
             * @param unitPrice Fee, charge or cost per item.
             * @param factor Price scaling factor.
             * @param tax Total tax.
             * @param net Total item cost.
             * @param noteNumber Applicable note numbers.
             * @param reviewOutcome Added items subdetail level adjudication results.
             * @param adjudication Added items subdetail adjudication.
             */
            public record AddedItemSubDetail(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    List<Identifier> traceNumber,
                    CodeableConcept revenue,
                    CodeableConcept productOrService,
                    CodeableConcept productOrServiceEnd,
                    List<CodeableConcept> modifier,
                    Quantity quantity,
                    Money unitPrice,
                    FhirDecimal factor,
                    Money tax,
                    Money net,
                    List<FhirPositiveInt> noteNumber,
                    ClaimResponse.Item.ReviewOutcome reviewOutcome,
                    List<ClaimResponse.Item.Adjudication> adjudication) implements BackboneElement {

                /**
                 * Creates an {@code AddedItemSubDetail}, copying all lists.
                 *
                 * @throws NullPointerException if a list contains {@code null}
                 */
                public AddedItemSubDetail {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    traceNumber = traceNumber == null ? List.of() : List.copyOf(traceNumber);
                    modifier = modifier == null ? List.of() : List.copyOf(modifier);
                    noteNumber = noteNumber == null ? List.of() : List.copyOf(noteNumber);
                    adjudication = adjudication == null ? List.of() : List.copyOf(adjudication);
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
                 * Returns a builder initialized with the values of this {@code AddedItemSubDetail}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link AddedItemSubDetail}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private List<Identifier> traceNumber = new ArrayList<>();
                    private CodeableConcept revenue;
                    private CodeableConcept productOrService;
                    private CodeableConcept productOrServiceEnd;
                    private List<CodeableConcept> modifier = new ArrayList<>();
                    private Quantity quantity;
                    private Money unitPrice;
                    private FhirDecimal factor;
                    private Money tax;
                    private Money net;
                    private List<FhirPositiveInt> noteNumber = new ArrayList<>();
                    private ClaimResponse.Item.ReviewOutcome reviewOutcome;
                    private List<ClaimResponse.Item.Adjudication> adjudication = new ArrayList<>();

                    private Builder() {
                    }

                    private Builder(AddedItemSubDetail original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.traceNumber = new ArrayList<>(original.traceNumber());
                        this.revenue = original.revenue();
                        this.productOrService = original.productOrService();
                        this.productOrServiceEnd = original.productOrServiceEnd();
                        this.modifier = new ArrayList<>(original.modifier());
                        this.quantity = original.quantity();
                        this.unitPrice = original.unitPrice();
                        this.factor = original.factor();
                        this.tax = original.tax();
                        this.net = original.net();
                        this.noteNumber = new ArrayList<>(original.noteNumber());
                        this.reviewOutcome = original.reviewOutcome();
                        this.adjudication = new ArrayList<>(original.adjudication());
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
                     * Replaces all {@code traceNumber} values.
                     *
                     * @param traceNumber the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder traceNumber(List<Identifier> traceNumber) {
                        this.traceNumber = traceNumber == null ? new ArrayList<>() : new ArrayList<>(traceNumber);
                        return this;
                    }

                    /**
                     * Adds a {@code traceNumber} value.
                     *
                     * @param traceNumber the value to add
                     * @return this builder
                     */
                    public Builder addTraceNumber(Identifier traceNumber) {
                        this.traceNumber.add(Objects.requireNonNull(traceNumber, "traceNumber"));
                        return this;
                    }

                    /**
                     * Sets {@code revenue}.
                     *
                     * @param revenue the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder revenue(CodeableConcept revenue) {
                        this.revenue = revenue;
                        return this;
                    }

                    /**
                     * Sets {@code productOrService}.
                     *
                     * @param productOrService the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder productOrService(CodeableConcept productOrService) {
                        this.productOrService = productOrService;
                        return this;
                    }

                    /**
                     * Sets {@code productOrServiceEnd}.
                     *
                     * @param productOrServiceEnd the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder productOrServiceEnd(CodeableConcept productOrServiceEnd) {
                        this.productOrServiceEnd = productOrServiceEnd;
                        return this;
                    }

                    /**
                     * Replaces all {@code modifier} values.
                     *
                     * @param modifier the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder modifier(List<CodeableConcept> modifier) {
                        this.modifier = modifier == null ? new ArrayList<>() : new ArrayList<>(modifier);
                        return this;
                    }

                    /**
                     * Adds a {@code modifier} value.
                     *
                     * @param modifier the value to add
                     * @return this builder
                     */
                    public Builder addModifier(CodeableConcept modifier) {
                        this.modifier.add(Objects.requireNonNull(modifier, "modifier"));
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
                     * Sets {@code unitPrice}.
                     *
                     * @param unitPrice the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder unitPrice(Money unitPrice) {
                        this.unitPrice = unitPrice;
                        return this;
                    }

                    /**
                     * Sets {@code factor}.
                     *
                     * @param factor the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder factor(FhirDecimal factor) {
                        this.factor = factor;
                        return this;
                    }

                    /**
                     * Sets {@code factor}, wrapped in a {@link FhirDecimal} without id or extensions.
                     *
                     * @param factor the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder factor(BigDecimal factor) {
                        return factor(factor == null ? null : FhirDecimal.of(factor));
                    }

                    /**
                     * Sets {@code tax}.
                     *
                     * @param tax the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder tax(Money tax) {
                        this.tax = tax;
                        return this;
                    }

                    /**
                     * Sets {@code net}.
                     *
                     * @param net the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder net(Money net) {
                        this.net = net;
                        return this;
                    }

                    /**
                     * Replaces all {@code noteNumber} values.
                     *
                     * @param noteNumber the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                        this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                        return this;
                    }

                    /**
                     * Adds a {@code noteNumber} value.
                     *
                     * @param noteNumber the value to add
                     * @return this builder
                     */
                    public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                        this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                        return this;
                    }

                    /**
                     * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
                     *
                     * @param noteNumber the value to add
                     * @return this builder
                     */
                    public Builder addNoteNumber(Integer noteNumber) {
                        return addNoteNumber(FhirPositiveInt.of(noteNumber));
                    }

                    /**
                     * Sets {@code reviewOutcome}.
                     *
                     * @param reviewOutcome the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder reviewOutcome(ClaimResponse.Item.ReviewOutcome reviewOutcome) {
                        this.reviewOutcome = reviewOutcome;
                        return this;
                    }

                    /**
                     * Replaces all {@code adjudication} values.
                     *
                     * @param adjudication the new values, or {@code null} to clear them
                     * @return this builder
                     */
                    public Builder adjudication(List<ClaimResponse.Item.Adjudication> adjudication) {
                        this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                        return this;
                    }

                    /**
                     * Adds a {@code adjudication} value.
                     *
                     * @param adjudication the value to add
                     * @return this builder
                     */
                    public Builder addAdjudication(ClaimResponse.Item.Adjudication adjudication) {
                        this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
                        return this;
                    }

                    /**
                     * Builds the {@code AddedItemSubDetail}.
                     *
                     * @return the {@code AddedItemSubDetail}
                     */
                    public AddedItemSubDetail build() {
                        return new AddedItemSubDetail(
                                id, extension, modifierExtension, traceNumber, revenue, productOrService,
                                productOrServiceEnd, modifier, quantity, unitPrice, factor, tax, net, noteNumber,
                                reviewOutcome, adjudication);
                    }
                }
            }

            /** Builder for {@link AddedItemDetail}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<Identifier> traceNumber = new ArrayList<>();
                private CodeableConcept revenue;
                private CodeableConcept productOrService;
                private CodeableConcept productOrServiceEnd;
                private List<CodeableConcept> modifier = new ArrayList<>();
                private Quantity quantity;
                private Money unitPrice;
                private FhirDecimal factor;
                private Money tax;
                private Money net;
                private List<FhirPositiveInt> noteNumber = new ArrayList<>();
                private ClaimResponse.Item.ReviewOutcome reviewOutcome;
                private List<ClaimResponse.Item.Adjudication> adjudication = new ArrayList<>();
                private List<AddedItemSubDetail> subDetail = new ArrayList<>();

                private Builder() {
                }

                private Builder(AddedItemDetail original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.traceNumber = new ArrayList<>(original.traceNumber());
                    this.revenue = original.revenue();
                    this.productOrService = original.productOrService();
                    this.productOrServiceEnd = original.productOrServiceEnd();
                    this.modifier = new ArrayList<>(original.modifier());
                    this.quantity = original.quantity();
                    this.unitPrice = original.unitPrice();
                    this.factor = original.factor();
                    this.tax = original.tax();
                    this.net = original.net();
                    this.noteNumber = new ArrayList<>(original.noteNumber());
                    this.reviewOutcome = original.reviewOutcome();
                    this.adjudication = new ArrayList<>(original.adjudication());
                    this.subDetail = new ArrayList<>(original.subDetail());
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
                 * Replaces all {@code traceNumber} values.
                 *
                 * @param traceNumber the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder traceNumber(List<Identifier> traceNumber) {
                    this.traceNumber = traceNumber == null ? new ArrayList<>() : new ArrayList<>(traceNumber);
                    return this;
                }

                /**
                 * Adds a {@code traceNumber} value.
                 *
                 * @param traceNumber the value to add
                 * @return this builder
                 */
                public Builder addTraceNumber(Identifier traceNumber) {
                    this.traceNumber.add(Objects.requireNonNull(traceNumber, "traceNumber"));
                    return this;
                }

                /**
                 * Sets {@code revenue}.
                 *
                 * @param revenue the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder revenue(CodeableConcept revenue) {
                    this.revenue = revenue;
                    return this;
                }

                /**
                 * Sets {@code productOrService}.
                 *
                 * @param productOrService the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder productOrService(CodeableConcept productOrService) {
                    this.productOrService = productOrService;
                    return this;
                }

                /**
                 * Sets {@code productOrServiceEnd}.
                 *
                 * @param productOrServiceEnd the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder productOrServiceEnd(CodeableConcept productOrServiceEnd) {
                    this.productOrServiceEnd = productOrServiceEnd;
                    return this;
                }

                /**
                 * Replaces all {@code modifier} values.
                 *
                 * @param modifier the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder modifier(List<CodeableConcept> modifier) {
                    this.modifier = modifier == null ? new ArrayList<>() : new ArrayList<>(modifier);
                    return this;
                }

                /**
                 * Adds a {@code modifier} value.
                 *
                 * @param modifier the value to add
                 * @return this builder
                 */
                public Builder addModifier(CodeableConcept modifier) {
                    this.modifier.add(Objects.requireNonNull(modifier, "modifier"));
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
                 * Sets {@code unitPrice}.
                 *
                 * @param unitPrice the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder unitPrice(Money unitPrice) {
                    this.unitPrice = unitPrice;
                    return this;
                }

                /**
                 * Sets {@code factor}.
                 *
                 * @param factor the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder factor(FhirDecimal factor) {
                    this.factor = factor;
                    return this;
                }

                /**
                 * Sets {@code factor}, wrapped in a {@link FhirDecimal} without id or extensions.
                 *
                 * @param factor the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder factor(BigDecimal factor) {
                    return factor(factor == null ? null : FhirDecimal.of(factor));
                }

                /**
                 * Sets {@code tax}.
                 *
                 * @param tax the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder tax(Money tax) {
                    this.tax = tax;
                    return this;
                }

                /**
                 * Sets {@code net}.
                 *
                 * @param net the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder net(Money net) {
                    this.net = net;
                    return this;
                }

                /**
                 * Replaces all {@code noteNumber} values.
                 *
                 * @param noteNumber the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                    this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                    return this;
                }

                /**
                 * Adds a {@code noteNumber} value.
                 *
                 * @param noteNumber the value to add
                 * @return this builder
                 */
                public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                    this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                    return this;
                }

                /**
                 * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
                 *
                 * @param noteNumber the value to add
                 * @return this builder
                 */
                public Builder addNoteNumber(Integer noteNumber) {
                    return addNoteNumber(FhirPositiveInt.of(noteNumber));
                }

                /**
                 * Sets {@code reviewOutcome}.
                 *
                 * @param reviewOutcome the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder reviewOutcome(ClaimResponse.Item.ReviewOutcome reviewOutcome) {
                    this.reviewOutcome = reviewOutcome;
                    return this;
                }

                /**
                 * Replaces all {@code adjudication} values.
                 *
                 * @param adjudication the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder adjudication(List<ClaimResponse.Item.Adjudication> adjudication) {
                    this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                    return this;
                }

                /**
                 * Adds a {@code adjudication} value.
                 *
                 * @param adjudication the value to add
                 * @return this builder
                 */
                public Builder addAdjudication(ClaimResponse.Item.Adjudication adjudication) {
                    this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
                    return this;
                }

                /**
                 * Replaces all {@code subDetail} values.
                 *
                 * @param subDetail the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder subDetail(List<AddedItemSubDetail> subDetail) {
                    this.subDetail = subDetail == null ? new ArrayList<>() : new ArrayList<>(subDetail);
                    return this;
                }

                /**
                 * Adds a {@code subDetail} value.
                 *
                 * @param subDetail the value to add
                 * @return this builder
                 */
                public Builder addSubDetail(AddedItemSubDetail subDetail) {
                    this.subDetail.add(Objects.requireNonNull(subDetail, "subDetail"));
                    return this;
                }

                /**
                 * Builds the {@code AddedItemDetail}.
                 *
                 * @return the {@code AddedItemDetail}
                 */
                public AddedItemDetail build() {
                    return new AddedItemDetail(
                            id, extension, modifierExtension, traceNumber, revenue, productOrService,
                            productOrServiceEnd, modifier, quantity, unitPrice, factor, tax, net, noteNumber,
                            reviewOutcome, adjudication, subDetail);
                }
            }
        }

        /** Builder for {@link AddedItem}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<FhirPositiveInt> itemSequence = new ArrayList<>();
            private List<FhirPositiveInt> detailSequence = new ArrayList<>();
            private List<FhirPositiveInt> subdetailSequence = new ArrayList<>();
            private List<Identifier> traceNumber = new ArrayList<>();
            private List<Reference> provider = new ArrayList<>();
            private CodeableConcept revenue;
            private CodeableConcept productOrService;
            private CodeableConcept productOrServiceEnd;
            private List<Reference> request = new ArrayList<>();
            private List<CodeableConcept> modifier = new ArrayList<>();
            private List<CodeableConcept> programCode = new ArrayList<>();
            private DataType serviced;
            private DataType location;
            private Quantity quantity;
            private Money unitPrice;
            private FhirDecimal factor;
            private Money tax;
            private Money net;
            private List<BodySite> bodySite = new ArrayList<>();
            private List<FhirPositiveInt> noteNumber = new ArrayList<>();
            private ClaimResponse.Item.ReviewOutcome reviewOutcome;
            private List<ClaimResponse.Item.Adjudication> adjudication = new ArrayList<>();
            private List<AddedItemDetail> detail = new ArrayList<>();

            private Builder() {
            }

            private Builder(AddedItem original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.itemSequence = new ArrayList<>(original.itemSequence());
                this.detailSequence = new ArrayList<>(original.detailSequence());
                this.subdetailSequence = new ArrayList<>(original.subdetailSequence());
                this.traceNumber = new ArrayList<>(original.traceNumber());
                this.provider = new ArrayList<>(original.provider());
                this.revenue = original.revenue();
                this.productOrService = original.productOrService();
                this.productOrServiceEnd = original.productOrServiceEnd();
                this.request = new ArrayList<>(original.request());
                this.modifier = new ArrayList<>(original.modifier());
                this.programCode = new ArrayList<>(original.programCode());
                this.serviced = original.serviced();
                this.location = original.location();
                this.quantity = original.quantity();
                this.unitPrice = original.unitPrice();
                this.factor = original.factor();
                this.tax = original.tax();
                this.net = original.net();
                this.bodySite = new ArrayList<>(original.bodySite());
                this.noteNumber = new ArrayList<>(original.noteNumber());
                this.reviewOutcome = original.reviewOutcome();
                this.adjudication = new ArrayList<>(original.adjudication());
                this.detail = new ArrayList<>(original.detail());
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
             * Replaces all {@code itemSequence} values.
             *
             * @param itemSequence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder itemSequence(List<FhirPositiveInt> itemSequence) {
                this.itemSequence = itemSequence == null ? new ArrayList<>() : new ArrayList<>(itemSequence);
                return this;
            }

            /**
             * Adds a {@code itemSequence} value.
             *
             * @param itemSequence the value to add
             * @return this builder
             */
            public Builder addItemSequence(FhirPositiveInt itemSequence) {
                this.itemSequence.add(Objects.requireNonNull(itemSequence, "itemSequence"));
                return this;
            }

            /**
             * Adds a {@code itemSequence} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param itemSequence the value to add
             * @return this builder
             */
            public Builder addItemSequence(Integer itemSequence) {
                return addItemSequence(FhirPositiveInt.of(itemSequence));
            }

            /**
             * Replaces all {@code detailSequence} values.
             *
             * @param detailSequence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder detailSequence(List<FhirPositiveInt> detailSequence) {
                this.detailSequence = detailSequence == null ? new ArrayList<>() : new ArrayList<>(detailSequence);
                return this;
            }

            /**
             * Adds a {@code detailSequence} value.
             *
             * @param detailSequence the value to add
             * @return this builder
             */
            public Builder addDetailSequence(FhirPositiveInt detailSequence) {
                this.detailSequence.add(Objects.requireNonNull(detailSequence, "detailSequence"));
                return this;
            }

            /**
             * Adds a {@code detailSequence} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param detailSequence the value to add
             * @return this builder
             */
            public Builder addDetailSequence(Integer detailSequence) {
                return addDetailSequence(FhirPositiveInt.of(detailSequence));
            }

            /**
             * Replaces all {@code subdetailSequence} values.
             *
             * @param subdetailSequence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder subdetailSequence(List<FhirPositiveInt> subdetailSequence) {
                this.subdetailSequence = subdetailSequence == null
                        ? new ArrayList<>()
                        : new ArrayList<>(subdetailSequence);
                return this;
            }

            /**
             * Adds a {@code subdetailSequence} value.
             *
             * @param subdetailSequence the value to add
             * @return this builder
             */
            public Builder addSubdetailSequence(FhirPositiveInt subdetailSequence) {
                this.subdetailSequence.add(Objects.requireNonNull(subdetailSequence, "subdetailSequence"));
                return this;
            }

            /**
             * Adds a {@code subdetailSequence} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param subdetailSequence the value to add
             * @return this builder
             */
            public Builder addSubdetailSequence(Integer subdetailSequence) {
                return addSubdetailSequence(FhirPositiveInt.of(subdetailSequence));
            }

            /**
             * Replaces all {@code traceNumber} values.
             *
             * @param traceNumber the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder traceNumber(List<Identifier> traceNumber) {
                this.traceNumber = traceNumber == null ? new ArrayList<>() : new ArrayList<>(traceNumber);
                return this;
            }

            /**
             * Adds a {@code traceNumber} value.
             *
             * @param traceNumber the value to add
             * @return this builder
             */
            public Builder addTraceNumber(Identifier traceNumber) {
                this.traceNumber.add(Objects.requireNonNull(traceNumber, "traceNumber"));
                return this;
            }

            /**
             * Replaces all {@code provider} values.
             *
             * @param provider the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder provider(List<Reference> provider) {
                this.provider = provider == null ? new ArrayList<>() : new ArrayList<>(provider);
                return this;
            }

            /**
             * Adds a {@code provider} value.
             *
             * @param provider the value to add
             * @return this builder
             */
            public Builder addProvider(Reference provider) {
                this.provider.add(Objects.requireNonNull(provider, "provider"));
                return this;
            }

            /**
             * Sets {@code revenue}.
             *
             * @param revenue the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder revenue(CodeableConcept revenue) {
                this.revenue = revenue;
                return this;
            }

            /**
             * Sets {@code productOrService}.
             *
             * @param productOrService the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder productOrService(CodeableConcept productOrService) {
                this.productOrService = productOrService;
                return this;
            }

            /**
             * Sets {@code productOrServiceEnd}.
             *
             * @param productOrServiceEnd the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder productOrServiceEnd(CodeableConcept productOrServiceEnd) {
                this.productOrServiceEnd = productOrServiceEnd;
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
             * Replaces all {@code modifier} values.
             *
             * @param modifier the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder modifier(List<CodeableConcept> modifier) {
                this.modifier = modifier == null ? new ArrayList<>() : new ArrayList<>(modifier);
                return this;
            }

            /**
             * Adds a {@code modifier} value.
             *
             * @param modifier the value to add
             * @return this builder
             */
            public Builder addModifier(CodeableConcept modifier) {
                this.modifier.add(Objects.requireNonNull(modifier, "modifier"));
                return this;
            }

            /**
             * Replaces all {@code programCode} values.
             *
             * @param programCode the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder programCode(List<CodeableConcept> programCode) {
                this.programCode = programCode == null ? new ArrayList<>() : new ArrayList<>(programCode);
                return this;
            }

            /**
             * Adds a {@code programCode} value.
             *
             * @param programCode the value to add
             * @return this builder
             */
            public Builder addProgramCode(CodeableConcept programCode) {
                this.programCode.add(Objects.requireNonNull(programCode, "programCode"));
                return this;
            }

            /**
             * Sets {@code serviced} to a date.
             *
             * @param serviced the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder serviced(FhirDate serviced) {
                this.serviced = serviced;
                return this;
            }

            /**
             * Sets {@code serviced} to a Period.
             *
             * @param serviced the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder serviced(Period serviced) {
                this.serviced = serviced;
                return this;
            }

            /**
             * Sets {@code serviced} to a date without id or extensions.
             *
             * @param serviced the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder serviced(Temporal serviced) {
                this.serviced = serviced == null ? null : FhirDate.of(serviced);
                return this;
            }

            /**
             * Sets {@code location} to a CodeableConcept.
             *
             * @param location the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder location(CodeableConcept location) {
                this.location = location;
                return this;
            }

            /**
             * Sets {@code location} to a Address.
             *
             * @param location the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder location(Address location) {
                this.location = location;
                return this;
            }

            /**
             * Sets {@code location} to a Reference.
             *
             * @param location the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder location(Reference location) {
                this.location = location;
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
             * Sets {@code unitPrice}.
             *
             * @param unitPrice the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder unitPrice(Money unitPrice) {
                this.unitPrice = unitPrice;
                return this;
            }

            /**
             * Sets {@code factor}.
             *
             * @param factor the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder factor(FhirDecimal factor) {
                this.factor = factor;
                return this;
            }

            /**
             * Sets {@code factor}, wrapped in a {@link FhirDecimal} without id or extensions.
             *
             * @param factor the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder factor(BigDecimal factor) {
                return factor(factor == null ? null : FhirDecimal.of(factor));
            }

            /**
             * Sets {@code tax}.
             *
             * @param tax the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder tax(Money tax) {
                this.tax = tax;
                return this;
            }

            /**
             * Sets {@code net}.
             *
             * @param net the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder net(Money net) {
                this.net = net;
                return this;
            }

            /**
             * Replaces all {@code bodySite} values.
             *
             * @param bodySite the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder bodySite(List<BodySite> bodySite) {
                this.bodySite = bodySite == null ? new ArrayList<>() : new ArrayList<>(bodySite);
                return this;
            }

            /**
             * Adds a {@code bodySite} value.
             *
             * @param bodySite the value to add
             * @return this builder
             */
            public Builder addBodySite(BodySite bodySite) {
                this.bodySite.add(Objects.requireNonNull(bodySite, "bodySite"));
                return this;
            }

            /**
             * Replaces all {@code noteNumber} values.
             *
             * @param noteNumber the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder noteNumber(List<FhirPositiveInt> noteNumber) {
                this.noteNumber = noteNumber == null ? new ArrayList<>() : new ArrayList<>(noteNumber);
                return this;
            }

            /**
             * Adds a {@code noteNumber} value.
             *
             * @param noteNumber the value to add
             * @return this builder
             */
            public Builder addNoteNumber(FhirPositiveInt noteNumber) {
                this.noteNumber.add(Objects.requireNonNull(noteNumber, "noteNumber"));
                return this;
            }

            /**
             * Adds a {@code noteNumber} value, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param noteNumber the value to add
             * @return this builder
             */
            public Builder addNoteNumber(Integer noteNumber) {
                return addNoteNumber(FhirPositiveInt.of(noteNumber));
            }

            /**
             * Sets {@code reviewOutcome}.
             *
             * @param reviewOutcome the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder reviewOutcome(ClaimResponse.Item.ReviewOutcome reviewOutcome) {
                this.reviewOutcome = reviewOutcome;
                return this;
            }

            /**
             * Replaces all {@code adjudication} values.
             *
             * @param adjudication the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder adjudication(List<ClaimResponse.Item.Adjudication> adjudication) {
                this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
                return this;
            }

            /**
             * Adds a {@code adjudication} value.
             *
             * @param adjudication the value to add
             * @return this builder
             */
            public Builder addAdjudication(ClaimResponse.Item.Adjudication adjudication) {
                this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
                return this;
            }

            /**
             * Replaces all {@code detail} values.
             *
             * @param detail the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder detail(List<AddedItemDetail> detail) {
                this.detail = detail == null ? new ArrayList<>() : new ArrayList<>(detail);
                return this;
            }

            /**
             * Adds a {@code detail} value.
             *
             * @param detail the value to add
             * @return this builder
             */
            public Builder addDetail(AddedItemDetail detail) {
                this.detail.add(Objects.requireNonNull(detail, "detail"));
                return this;
            }

            /**
             * Builds the {@code AddedItem}.
             *
             * @return the {@code AddedItem}
             */
            public AddedItem build() {
                return new AddedItem(
                        id, extension, modifierExtension, itemSequence, detailSequence, subdetailSequence,
                        traceNumber, provider, revenue, productOrService, productOrServiceEnd, request, modifier,
                        programCode, serviced, location, quantity, unitPrice, factor, tax, net, bodySite, noteNumber,
                        reviewOutcome, adjudication, detail);
            }
        }
    }

    /**
     * Categorized monetary totals for the adjudication.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param category Type of adjudication information. Required.
     * @param amount Financial total for the category. Required.
     */
    public record Total(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept category,
            Money amount) implements BackboneElement {

        /**
         * Creates a {@code Total}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Total {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(category, "ClaimResponse.total.category is required");
            Objects.requireNonNull(amount, "ClaimResponse.total.amount is required");
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
         * Returns a builder initialized with the values of this {@code Total}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Total}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept category;
            private Money amount;

            private Builder() {
            }

            private Builder(Total original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.category = original.category();
                this.amount = original.amount();
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
             * Sets {@code amount}.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(Money amount) {
                this.amount = amount;
                return this;
            }

            /**
             * Builds the {@code Total}.
             *
             * @return the {@code Total}
             * @throws NullPointerException if a required element is absent
             */
            public Total build() {
                return new Total(
                        id, extension, modifierExtension, category, amount);
            }
        }
    }

    /**
     * Payment details for the adjudication of the claim.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type Partial or complete payment. Required.
     * @param adjustment Payment adjustment for non-claim issues.
     * @param adjustmentReason Explanation for the adjustment.
     * @param date Expected date of payment.
     * @param amount Payable amount after adjustment. Required.
     * @param identifier Business identifier for the payment.
     */
    public record Payment(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept type,
            Money adjustment,
            CodeableConcept adjustmentReason,
            FhirDate date,
            Money amount,
            Identifier identifier) implements BackboneElement {

        /**
         * Creates a {@code Payment}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Payment {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(type, "ClaimResponse.payment.type is required");
            Objects.requireNonNull(amount, "ClaimResponse.payment.amount is required");
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
         * Returns a builder initialized with the values of this {@code Payment}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Payment}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private CodeableConcept type;
            private Money adjustment;
            private CodeableConcept adjustmentReason;
            private FhirDate date;
            private Money amount;
            private Identifier identifier;

            private Builder() {
            }

            private Builder(Payment original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.adjustment = original.adjustment();
                this.adjustmentReason = original.adjustmentReason();
                this.date = original.date();
                this.amount = original.amount();
                this.identifier = original.identifier();
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
             * Sets {@code adjustment}.
             *
             * @param adjustment the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder adjustment(Money adjustment) {
                this.adjustment = adjustment;
                return this;
            }

            /**
             * Sets {@code adjustmentReason}.
             *
             * @param adjustmentReason the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder adjustmentReason(CodeableConcept adjustmentReason) {
                this.adjustmentReason = adjustmentReason;
                return this;
            }

            /**
             * Sets {@code date}.
             *
             * @param date the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder date(FhirDate date) {
                this.date = date;
                return this;
            }

            /**
             * Sets {@code date}, wrapped in a {@link FhirDate} without id or extensions.
             *
             * @param date the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder date(Temporal date) {
                return date(date == null ? null : FhirDate.of(date));
            }

            /**
             * Sets {@code amount}.
             *
             * @param amount the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder amount(Money amount) {
                this.amount = amount;
                return this;
            }

            /**
             * Sets {@code identifier}.
             *
             * @param identifier the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder identifier(Identifier identifier) {
                this.identifier = identifier;
                return this;
            }

            /**
             * Builds the {@code Payment}.
             *
             * @return the {@code Payment}
             * @throws NullPointerException if a required element is absent
             */
            public Payment build() {
                return new Payment(
                        id, extension, modifierExtension, type, adjustment, adjustmentReason, date, amount,
                        identifier);
            }
        }
    }

    /**
     * A note that describes or explains adjudication results in a human readable form.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param number Note instance identifier.
     * @param type Note purpose.
     * @param text Note explanatory text. Required.
     * @param language Language of the text.
     */
    public record Note(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt number,
            CodeableConcept type,
            FhirString text,
            CodeableConcept language) implements BackboneElement {

        /**
         * Creates a {@code Note}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Note {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(text, "ClaimResponse.processNote.text is required");
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
         * Returns a builder initialized with the values of this {@code Note}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Note}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt number;
            private CodeableConcept type;
            private FhirString text;
            private CodeableConcept language;

            private Builder() {
            }

            private Builder(Note original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.number = original.number();
                this.type = original.type();
                this.text = original.text();
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
             * Sets {@code number}.
             *
             * @param number the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder number(FhirPositiveInt number) {
                this.number = number;
                return this;
            }

            /**
             * Sets {@code number}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param number the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder number(Integer number) {
                return number(number == null ? null : FhirPositiveInt.of(number));
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
             * Sets {@code text}.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(FhirString text) {
                this.text = text;
                return this;
            }

            /**
             * Sets {@code text}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param text the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder text(String text) {
                return text(text == null ? null : FhirString.of(text));
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
             * Builds the {@code Note}.
             *
             * @return the {@code Note}
             * @throws NullPointerException if a required element is absent
             */
            public Note build() {
                return new Note(
                        id, extension, modifierExtension, number, type, text, language);
            }
        }
    }

    /**
     * Financial instruments for reimbursement for the health care products and services specified on the claim.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param sequence Insurance instance identifier. Required.
     * @param focal Coverage to be used for adjudication. Required.
     * @param coverage Insurance information. Reference to Coverage. Required.
     * @param businessArrangement Additional provider contract number.
     * @param claimResponse Adjudication results. Reference to ClaimResponse.
     */
    public record Insurance(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt sequence,
            FhirBoolean focal,
            Reference coverage,
            FhirString businessArrangement,
            Reference claimResponse) implements BackboneElement {

        /**
         * Creates an {@code Insurance}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Insurance {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(sequence, "ClaimResponse.insurance.sequence is required");
            Objects.requireNonNull(focal, "ClaimResponse.insurance.focal is required");
            Objects.requireNonNull(coverage, "ClaimResponse.insurance.coverage is required");
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
         * Returns a builder initialized with the values of this {@code Insurance}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Insurance}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt sequence;
            private FhirBoolean focal;
            private Reference coverage;
            private FhirString businessArrangement;
            private Reference claimResponse;

            private Builder() {
            }

            private Builder(Insurance original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.sequence = original.sequence();
                this.focal = original.focal();
                this.coverage = original.coverage();
                this.businessArrangement = original.businessArrangement();
                this.claimResponse = original.claimResponse();
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
             * Sets {@code sequence}.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(FhirPositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Sets {@code sequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param sequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder sequence(Integer sequence) {
                return sequence(sequence == null ? null : FhirPositiveInt.of(sequence));
            }

            /**
             * Sets {@code focal}.
             *
             * @param focal the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder focal(FhirBoolean focal) {
                this.focal = focal;
                return this;
            }

            /**
             * Sets {@code focal}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param focal the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder focal(Boolean focal) {
                return focal(focal == null ? null : FhirBoolean.of(focal));
            }

            /**
             * Sets {@code coverage}.
             *
             * @param coverage the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder coverage(Reference coverage) {
                this.coverage = coverage;
                return this;
            }

            /**
             * Sets {@code businessArrangement}.
             *
             * @param businessArrangement the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder businessArrangement(FhirString businessArrangement) {
                this.businessArrangement = businessArrangement;
                return this;
            }

            /**
             * Sets {@code businessArrangement}, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param businessArrangement the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder businessArrangement(String businessArrangement) {
                return businessArrangement(businessArrangement == null ? null : FhirString.of(businessArrangement));
            }

            /**
             * Sets {@code claimResponse}.
             *
             * @param claimResponse the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder claimResponse(Reference claimResponse) {
                this.claimResponse = claimResponse;
                return this;
            }

            /**
             * Builds the {@code Insurance}.
             *
             * @return the {@code Insurance}
             * @throws NullPointerException if a required element is absent
             */
            public Insurance build() {
                return new Insurance(
                        id, extension, modifierExtension, sequence, focal, coverage, businessArrangement,
                        claimResponse);
            }
        }
    }

    /**
     * Errors encountered during the processing of the adjudication.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param itemSequence Item sequence number.
     * @param detailSequence Detail sequence number.
     * @param subDetailSequence Subdetail sequence number.
     * @param code Error code detailing processing issues. Required.
     * @param expression FHIRPath of element(s) related to issue.
     */
    public record ClaimResponseError(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirPositiveInt itemSequence,
            FhirPositiveInt detailSequence,
            FhirPositiveInt subDetailSequence,
            CodeableConcept code,
            List<FhirString> expression) implements BackboneElement {

        /**
         * Creates a {@code ClaimResponseError}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public ClaimResponseError {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            expression = expression == null ? List.of() : List.copyOf(expression);
            Objects.requireNonNull(code, "ClaimResponse.error.code is required");
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
         * Returns a builder initialized with the values of this {@code ClaimResponseError}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link ClaimResponseError}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirPositiveInt itemSequence;
            private FhirPositiveInt detailSequence;
            private FhirPositiveInt subDetailSequence;
            private CodeableConcept code;
            private List<FhirString> expression = new ArrayList<>();

            private Builder() {
            }

            private Builder(ClaimResponseError original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.itemSequence = original.itemSequence();
                this.detailSequence = original.detailSequence();
                this.subDetailSequence = original.subDetailSequence();
                this.code = original.code();
                this.expression = new ArrayList<>(original.expression());
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
             * Sets {@code itemSequence}.
             *
             * @param itemSequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder itemSequence(FhirPositiveInt itemSequence) {
                this.itemSequence = itemSequence;
                return this;
            }

            /**
             * Sets {@code itemSequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param itemSequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder itemSequence(Integer itemSequence) {
                return itemSequence(itemSequence == null ? null : FhirPositiveInt.of(itemSequence));
            }

            /**
             * Sets {@code detailSequence}.
             *
             * @param detailSequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detailSequence(FhirPositiveInt detailSequence) {
                this.detailSequence = detailSequence;
                return this;
            }

            /**
             * Sets {@code detailSequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param detailSequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder detailSequence(Integer detailSequence) {
                return detailSequence(detailSequence == null ? null : FhirPositiveInt.of(detailSequence));
            }

            /**
             * Sets {@code subDetailSequence}.
             *
             * @param subDetailSequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subDetailSequence(FhirPositiveInt subDetailSequence) {
                this.subDetailSequence = subDetailSequence;
                return this;
            }

            /**
             * Sets {@code subDetailSequence}, wrapped in a {@link FhirPositiveInt} without id or extensions.
             *
             * @param subDetailSequence the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder subDetailSequence(Integer subDetailSequence) {
                return subDetailSequence(subDetailSequence == null ? null : FhirPositiveInt.of(subDetailSequence));
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
             * Replaces all {@code expression} values.
             *
             * @param expression the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder expression(List<FhirString> expression) {
                this.expression = expression == null ? new ArrayList<>() : new ArrayList<>(expression);
                return this;
            }

            /**
             * Adds a {@code expression} value.
             *
             * @param expression the value to add
             * @return this builder
             */
            public Builder addExpression(FhirString expression) {
                this.expression.add(Objects.requireNonNull(expression, "expression"));
                return this;
            }

            /**
             * Adds a {@code expression} value, wrapped in a {@link FhirString} without id or extensions.
             *
             * @param expression the value to add
             * @return this builder
             */
            public Builder addExpression(String expression) {
                return addExpression(FhirString.of(expression));
            }

            /**
             * Builds the {@code ClaimResponseError}.
             *
             * @return the {@code ClaimResponseError}
             * @throws NullPointerException if a required element is absent
             */
            public ClaimResponseError build() {
                return new ClaimResponseError(
                        id, extension, modifierExtension, itemSequence, detailSequence, subDetailSequence, code,
                        expression);
            }
        }
    }

    /** Builder for {@link ClaimResponse}. Builders are mutable and not thread-safe. */
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
        private List<Identifier> traceNumber = new ArrayList<>();
        private FhirEnum<FinancialResourceStatusCodes> status;
        private CodeableConcept type;
        private CodeableConcept subType;
        private FhirEnum<Use> use;
        private Reference patient;
        private FhirDateTime created;
        private Reference insurer;
        private Reference requestor;
        private Reference request;
        private FhirEnum<ClaimProcessingCodes> outcome;
        private CodeableConcept decision;
        private FhirString disposition;
        private FhirString preAuthRef;
        private Period preAuthPeriod;
        private List<Event> event = new ArrayList<>();
        private CodeableConcept payeeType;
        private List<Reference> encounter = new ArrayList<>();
        private CodeableConcept diagnosisRelatedGroup;
        private List<Item> item = new ArrayList<>();
        private List<AddedItem> addItem = new ArrayList<>();
        private List<ClaimResponse.Item.Adjudication> adjudication = new ArrayList<>();
        private List<Total> total = new ArrayList<>();
        private Payment payment;
        private CodeableConcept fundsReserve;
        private CodeableConcept formCode;
        private Attachment form;
        private List<Note> processNote = new ArrayList<>();
        private List<Reference> communicationRequest = new ArrayList<>();
        private List<Insurance> insurance = new ArrayList<>();
        private List<ClaimResponseError> error = new ArrayList<>();

        private Builder() {
        }

        private Builder(ClaimResponse original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.identifier = new ArrayList<>(original.identifier());
            this.traceNumber = new ArrayList<>(original.traceNumber());
            this.status = original.status();
            this.type = original.type();
            this.subType = original.subType();
            this.use = original.use();
            this.patient = original.patient();
            this.created = original.created();
            this.insurer = original.insurer();
            this.requestor = original.requestor();
            this.request = original.request();
            this.outcome = original.outcome();
            this.decision = original.decision();
            this.disposition = original.disposition();
            this.preAuthRef = original.preAuthRef();
            this.preAuthPeriod = original.preAuthPeriod();
            this.event = new ArrayList<>(original.event());
            this.payeeType = original.payeeType();
            this.encounter = new ArrayList<>(original.encounter());
            this.diagnosisRelatedGroup = original.diagnosisRelatedGroup();
            this.item = new ArrayList<>(original.item());
            this.addItem = new ArrayList<>(original.addItem());
            this.adjudication = new ArrayList<>(original.adjudication());
            this.total = new ArrayList<>(original.total());
            this.payment = original.payment();
            this.fundsReserve = original.fundsReserve();
            this.formCode = original.formCode();
            this.form = original.form();
            this.processNote = new ArrayList<>(original.processNote());
            this.communicationRequest = new ArrayList<>(original.communicationRequest());
            this.insurance = new ArrayList<>(original.insurance());
            this.error = new ArrayList<>(original.error());
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
         * Replaces all {@code traceNumber} values.
         *
         * @param traceNumber the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder traceNumber(List<Identifier> traceNumber) {
            this.traceNumber = traceNumber == null ? new ArrayList<>() : new ArrayList<>(traceNumber);
            return this;
        }

        /**
         * Adds a {@code traceNumber} value.
         *
         * @param traceNumber the value to add
         * @return this builder
         */
        public Builder addTraceNumber(Identifier traceNumber) {
            this.traceNumber.add(Objects.requireNonNull(traceNumber, "traceNumber"));
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
         * Sets {@code subType}.
         *
         * @param subType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder subType(CodeableConcept subType) {
            this.subType = subType;
            return this;
        }

        /**
         * Sets {@code use}.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(FhirEnum<Use> use) {
            this.use = use;
            return this;
        }

        /**
         * Sets {@code use}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param use the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder use(Use use) {
            return use(use == null ? null : FhirEnum.of(use));
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
         * Sets {@code insurer}.
         *
         * @param insurer the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder insurer(Reference insurer) {
            this.insurer = insurer;
            return this;
        }

        /**
         * Sets {@code requestor}.
         *
         * @param requestor the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder requestor(Reference requestor) {
            this.requestor = requestor;
            return this;
        }

        /**
         * Sets {@code request}.
         *
         * @param request the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder request(Reference request) {
            this.request = request;
            return this;
        }

        /**
         * Sets {@code outcome}.
         *
         * @param outcome the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outcome(FhirEnum<ClaimProcessingCodes> outcome) {
            this.outcome = outcome;
            return this;
        }

        /**
         * Sets {@code outcome}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param outcome the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder outcome(ClaimProcessingCodes outcome) {
            return outcome(outcome == null ? null : FhirEnum.of(outcome));
        }

        /**
         * Sets {@code decision}.
         *
         * @param decision the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder decision(CodeableConcept decision) {
            this.decision = decision;
            return this;
        }

        /**
         * Sets {@code disposition}.
         *
         * @param disposition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder disposition(FhirString disposition) {
            this.disposition = disposition;
            return this;
        }

        /**
         * Sets {@code disposition}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param disposition the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder disposition(String disposition) {
            return disposition(disposition == null ? null : FhirString.of(disposition));
        }

        /**
         * Sets {@code preAuthRef}.
         *
         * @param preAuthRef the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preAuthRef(FhirString preAuthRef) {
            this.preAuthRef = preAuthRef;
            return this;
        }

        /**
         * Sets {@code preAuthRef}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param preAuthRef the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preAuthRef(String preAuthRef) {
            return preAuthRef(preAuthRef == null ? null : FhirString.of(preAuthRef));
        }

        /**
         * Sets {@code preAuthPeriod}.
         *
         * @param preAuthPeriod the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder preAuthPeriod(Period preAuthPeriod) {
            this.preAuthPeriod = preAuthPeriod;
            return this;
        }

        /**
         * Replaces all {@code event} values.
         *
         * @param event the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder event(List<Event> event) {
            this.event = event == null ? new ArrayList<>() : new ArrayList<>(event);
            return this;
        }

        /**
         * Adds a {@code event} value.
         *
         * @param event the value to add
         * @return this builder
         */
        public Builder addEvent(Event event) {
            this.event.add(Objects.requireNonNull(event, "event"));
            return this;
        }

        /**
         * Sets {@code payeeType}.
         *
         * @param payeeType the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder payeeType(CodeableConcept payeeType) {
            this.payeeType = payeeType;
            return this;
        }

        /**
         * Replaces all {@code encounter} values.
         *
         * @param encounter the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder encounter(List<Reference> encounter) {
            this.encounter = encounter == null ? new ArrayList<>() : new ArrayList<>(encounter);
            return this;
        }

        /**
         * Adds a {@code encounter} value.
         *
         * @param encounter the value to add
         * @return this builder
         */
        public Builder addEncounter(Reference encounter) {
            this.encounter.add(Objects.requireNonNull(encounter, "encounter"));
            return this;
        }

        /**
         * Sets {@code diagnosisRelatedGroup}.
         *
         * @param diagnosisRelatedGroup the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder diagnosisRelatedGroup(CodeableConcept diagnosisRelatedGroup) {
            this.diagnosisRelatedGroup = diagnosisRelatedGroup;
            return this;
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
         * Replaces all {@code addItem} values.
         *
         * @param addItem the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder addItem(List<AddedItem> addItem) {
            this.addItem = addItem == null ? new ArrayList<>() : new ArrayList<>(addItem);
            return this;
        }

        /**
         * Adds a {@code addItem} value.
         *
         * @param addItem the value to add
         * @return this builder
         */
        public Builder addAddItem(AddedItem addItem) {
            this.addItem.add(Objects.requireNonNull(addItem, "addItem"));
            return this;
        }

        /**
         * Replaces all {@code adjudication} values.
         *
         * @param adjudication the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder adjudication(List<ClaimResponse.Item.Adjudication> adjudication) {
            this.adjudication = adjudication == null ? new ArrayList<>() : new ArrayList<>(adjudication);
            return this;
        }

        /**
         * Adds a {@code adjudication} value.
         *
         * @param adjudication the value to add
         * @return this builder
         */
        public Builder addAdjudication(ClaimResponse.Item.Adjudication adjudication) {
            this.adjudication.add(Objects.requireNonNull(adjudication, "adjudication"));
            return this;
        }

        /**
         * Replaces all {@code total} values.
         *
         * @param total the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder total(List<Total> total) {
            this.total = total == null ? new ArrayList<>() : new ArrayList<>(total);
            return this;
        }

        /**
         * Adds a {@code total} value.
         *
         * @param total the value to add
         * @return this builder
         */
        public Builder addTotal(Total total) {
            this.total.add(Objects.requireNonNull(total, "total"));
            return this;
        }

        /**
         * Sets {@code payment}.
         *
         * @param payment the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder payment(Payment payment) {
            this.payment = payment;
            return this;
        }

        /**
         * Sets {@code fundsReserve}.
         *
         * @param fundsReserve the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder fundsReserve(CodeableConcept fundsReserve) {
            this.fundsReserve = fundsReserve;
            return this;
        }

        /**
         * Sets {@code formCode}.
         *
         * @param formCode the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder formCode(CodeableConcept formCode) {
            this.formCode = formCode;
            return this;
        }

        /**
         * Sets {@code form}.
         *
         * @param form the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder form(Attachment form) {
            this.form = form;
            return this;
        }

        /**
         * Replaces all {@code processNote} values.
         *
         * @param processNote the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder processNote(List<Note> processNote) {
            this.processNote = processNote == null ? new ArrayList<>() : new ArrayList<>(processNote);
            return this;
        }

        /**
         * Adds a {@code processNote} value.
         *
         * @param processNote the value to add
         * @return this builder
         */
        public Builder addProcessNote(Note processNote) {
            this.processNote.add(Objects.requireNonNull(processNote, "processNote"));
            return this;
        }

        /**
         * Replaces all {@code communicationRequest} values.
         *
         * @param communicationRequest the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder communicationRequest(List<Reference> communicationRequest) {
            this.communicationRequest = communicationRequest == null
                    ? new ArrayList<>()
                    : new ArrayList<>(communicationRequest);
            return this;
        }

        /**
         * Adds a {@code communicationRequest} value.
         *
         * @param communicationRequest the value to add
         * @return this builder
         */
        public Builder addCommunicationRequest(Reference communicationRequest) {
            this.communicationRequest.add(Objects.requireNonNull(communicationRequest, "communicationRequest"));
            return this;
        }

        /**
         * Replaces all {@code insurance} values.
         *
         * @param insurance the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder insurance(List<Insurance> insurance) {
            this.insurance = insurance == null ? new ArrayList<>() : new ArrayList<>(insurance);
            return this;
        }

        /**
         * Adds a {@code insurance} value.
         *
         * @param insurance the value to add
         * @return this builder
         */
        public Builder addInsurance(Insurance insurance) {
            this.insurance.add(Objects.requireNonNull(insurance, "insurance"));
            return this;
        }

        /**
         * Replaces all {@code error} values.
         *
         * @param error the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder error(List<ClaimResponseError> error) {
            this.error = error == null ? new ArrayList<>() : new ArrayList<>(error);
            return this;
        }

        /**
         * Adds a {@code error} value.
         *
         * @param error the value to add
         * @return this builder
         */
        public Builder addError(ClaimResponseError error) {
            this.error.add(Objects.requireNonNull(error, "error"));
            return this;
        }

        /**
         * Builds the {@code ClaimResponse}.
         *
         * @return the {@code ClaimResponse}
         * @throws NullPointerException if a required element is absent
         */
        public ClaimResponse build() {
            return new ClaimResponse(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    traceNumber, status, type, subType, use, patient, created, insurer, requestor, request, outcome,
                    decision, disposition, preAuthRef, preAuthPeriod, event, payeeType, encounter,
                    diagnosisRelatedGroup, item, addItem, adjudication, total, payment, fundsReserve, formCode, form,
                    processNote, communicationRequest, insurance, error);
        }
    }
}
