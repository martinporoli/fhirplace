package se.poroli.fhirplace.r5.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Indicates how the medication is/was taken or should be taken by the patient.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Unique id for inter-element referencing.
 * @param extension Additional content defined by implementations.
 * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
 * @param sequence The order of the dosage instructions.
 * @param text Free text dosage instructions e.g. SIG.
 * @param additionalInstruction Supplemental instruction or warnings to the patient - e.g. "with meals", "may cause
 *   drowsiness".
 * @param patientInstruction Patient or consumer oriented instructions.
 * @param timing When medication should be administered.
 * @param asNeeded Take "as needed".
 * @param asNeededFor Take "as needed" (for x).
 * @param site Body site to administer to.
 * @param route How drug should enter body.
 * @param method Technique for administering medication.
 * @param doseAndRate Amount of medication administered, to be administered or typical amount to be administered.
 * @param maxDosePerPeriod Upper limit on medication per unit of time.
 * @param maxDosePerAdministration Upper limit on medication per administration.
 * @param maxDosePerLifetime Upper limit on medication per lifetime of the patient.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Dosage">FHIR R5 Dosage</a>
 */
public record Dosage(
        String id,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirInteger sequence,
        FhirString text,
        List<CodeableConcept> additionalInstruction,
        FhirString patientInstruction,
        Timing timing,
        FhirBoolean asNeeded,
        List<CodeableConcept> asNeededFor,
        CodeableConcept site,
        CodeableConcept route,
        CodeableConcept method,
        List<DoseAndRate> doseAndRate,
        List<Ratio> maxDosePerPeriod,
        Quantity maxDosePerAdministration,
        Quantity maxDosePerLifetime) implements BackboneType {

    /**
     * Creates a {@code Dosage}, copying all lists.
     *
     * @throws NullPointerException if a list contains {@code null}
     */
    public Dosage {
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        additionalInstruction = additionalInstruction == null ? List.of() : List.copyOf(additionalInstruction);
        asNeededFor = asNeededFor == null ? List.of() : List.copyOf(asNeededFor);
        doseAndRate = doseAndRate == null ? List.of() : List.copyOf(doseAndRate);
        maxDosePerPeriod = maxDosePerPeriod == null ? List.of() : List.copyOf(maxDosePerPeriod);
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
     * Returns a builder initialized with the values of this {@code Dosage}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Depending on the resource,this is the amount of medication administered, to be administered or typical amount
     * to be administered.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param type The kind of dose or rate specified.
     * @param dose Amount of medication per dose. One of Range, Quantity.
     * @param rate Amount of medication per unit of time. One of Ratio, Range, Quantity.
     */
    public record DoseAndRate(
            String id,
            List<Extension> extension,
            CodeableConcept type,
            DataType dose,
            DataType rate) implements Element {

        /**
         * Creates a {@code DoseAndRate}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public DoseAndRate {
            extension = extension == null ? List.of() : List.copyOf(extension);
            if (dose != null && !(dose instanceof Range || dose instanceof Quantity)) {
                throw new IllegalArgumentException(
                        "Dosage.doseAndRate.dose[x] must be one of Range, Quantity, but was "
                                + dose.getClass().getSimpleName());
            }
            if (rate != null && !(rate instanceof Ratio || rate instanceof Range || rate instanceof Quantity)) {
                throw new IllegalArgumentException(
                        "Dosage.doseAndRate.rate[x] must be one of Ratio, Range, Quantity, but was "
                                + rate.getClass().getSimpleName());
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
         * Returns a builder initialized with the values of this {@code DoseAndRate}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link DoseAndRate}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private CodeableConcept type;
            private DataType dose;
            private DataType rate;

            private Builder() {
            }

            private Builder(DoseAndRate original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.type = original.type();
                this.dose = original.dose();
                this.rate = original.rate();
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
             * Sets {@code dose} to a Range.
             *
             * @param dose the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dose(Range dose) {
                this.dose = dose;
                return this;
            }

            /**
             * Sets {@code dose} to a Quantity.
             *
             * @param dose the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder dose(Quantity dose) {
                this.dose = dose;
                return this;
            }

            /**
             * Sets {@code rate} to a Ratio.
             *
             * @param rate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rate(Ratio rate) {
                this.rate = rate;
                return this;
            }

            /**
             * Sets {@code rate} to a Range.
             *
             * @param rate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rate(Range rate) {
                this.rate = rate;
                return this;
            }

            /**
             * Sets {@code rate} to a Quantity.
             *
             * @param rate the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder rate(Quantity rate) {
                this.rate = rate;
                return this;
            }

            /**
             * Builds the {@code DoseAndRate}.
             *
             * @return the {@code DoseAndRate}
             */
            public DoseAndRate build() {
                return new DoseAndRate(
                        id, extension, type, dose, rate);
            }
        }
    }

    /** Builder for {@link Dosage}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirInteger sequence;
        private FhirString text;
        private List<CodeableConcept> additionalInstruction = new ArrayList<>();
        private FhirString patientInstruction;
        private Timing timing;
        private FhirBoolean asNeeded;
        private List<CodeableConcept> asNeededFor = new ArrayList<>();
        private CodeableConcept site;
        private CodeableConcept route;
        private CodeableConcept method;
        private List<DoseAndRate> doseAndRate = new ArrayList<>();
        private List<Ratio> maxDosePerPeriod = new ArrayList<>();
        private Quantity maxDosePerAdministration;
        private Quantity maxDosePerLifetime;

        private Builder() {
        }

        private Builder(Dosage original) {
            this.id = original.id();
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.sequence = original.sequence();
            this.text = original.text();
            this.additionalInstruction = new ArrayList<>(original.additionalInstruction());
            this.patientInstruction = original.patientInstruction();
            this.timing = original.timing();
            this.asNeeded = original.asNeeded();
            this.asNeededFor = new ArrayList<>(original.asNeededFor());
            this.site = original.site();
            this.route = original.route();
            this.method = original.method();
            this.doseAndRate = new ArrayList<>(original.doseAndRate());
            this.maxDosePerPeriod = new ArrayList<>(original.maxDosePerPeriod());
            this.maxDosePerAdministration = original.maxDosePerAdministration();
            this.maxDosePerLifetime = original.maxDosePerLifetime();
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
        public Builder sequence(FhirInteger sequence) {
            this.sequence = sequence;
            return this;
        }

        /**
         * Sets {@code sequence}, wrapped in a {@link FhirInteger} without id or extensions.
         *
         * @param sequence the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder sequence(Integer sequence) {
            return sequence(sequence == null ? null : FhirInteger.of(sequence));
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
         * Replaces all {@code additionalInstruction} values.
         *
         * @param additionalInstruction the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder additionalInstruction(List<CodeableConcept> additionalInstruction) {
            this.additionalInstruction = additionalInstruction == null
                    ? new ArrayList<>()
                    : new ArrayList<>(additionalInstruction);
            return this;
        }

        /**
         * Adds a {@code additionalInstruction} value.
         *
         * @param additionalInstruction the value to add
         * @return this builder
         */
        public Builder addAdditionalInstruction(CodeableConcept additionalInstruction) {
            this.additionalInstruction.add(Objects.requireNonNull(additionalInstruction, "additionalInstruction"));
            return this;
        }

        /**
         * Sets {@code patientInstruction}.
         *
         * @param patientInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder patientInstruction(FhirString patientInstruction) {
            this.patientInstruction = patientInstruction;
            return this;
        }

        /**
         * Sets {@code patientInstruction}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param patientInstruction the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder patientInstruction(String patientInstruction) {
            return patientInstruction(patientInstruction == null ? null : FhirString.of(patientInstruction));
        }

        /**
         * Sets {@code timing}.
         *
         * @param timing the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timing(Timing timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets {@code asNeeded}.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(FhirBoolean asNeeded) {
            this.asNeeded = asNeeded;
            return this;
        }

        /**
         * Sets {@code asNeeded}, wrapped in a {@link FhirBoolean} without id or extensions.
         *
         * @param asNeeded the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asNeeded(Boolean asNeeded) {
            return asNeeded(asNeeded == null ? null : FhirBoolean.of(asNeeded));
        }

        /**
         * Replaces all {@code asNeededFor} values.
         *
         * @param asNeededFor the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder asNeededFor(List<CodeableConcept> asNeededFor) {
            this.asNeededFor = asNeededFor == null ? new ArrayList<>() : new ArrayList<>(asNeededFor);
            return this;
        }

        /**
         * Adds a {@code asNeededFor} value.
         *
         * @param asNeededFor the value to add
         * @return this builder
         */
        public Builder addAsNeededFor(CodeableConcept asNeededFor) {
            this.asNeededFor.add(Objects.requireNonNull(asNeededFor, "asNeededFor"));
            return this;
        }

        /**
         * Sets {@code site}.
         *
         * @param site the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder site(CodeableConcept site) {
            this.site = site;
            return this;
        }

        /**
         * Sets {@code route}.
         *
         * @param route the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder route(CodeableConcept route) {
            this.route = route;
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
         * Replaces all {@code doseAndRate} values.
         *
         * @param doseAndRate the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder doseAndRate(List<DoseAndRate> doseAndRate) {
            this.doseAndRate = doseAndRate == null ? new ArrayList<>() : new ArrayList<>(doseAndRate);
            return this;
        }

        /**
         * Adds a {@code doseAndRate} value.
         *
         * @param doseAndRate the value to add
         * @return this builder
         */
        public Builder addDoseAndRate(DoseAndRate doseAndRate) {
            this.doseAndRate.add(Objects.requireNonNull(doseAndRate, "doseAndRate"));
            return this;
        }

        /**
         * Replaces all {@code maxDosePerPeriod} values.
         *
         * @param maxDosePerPeriod the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder maxDosePerPeriod(List<Ratio> maxDosePerPeriod) {
            this.maxDosePerPeriod = maxDosePerPeriod == null ? new ArrayList<>() : new ArrayList<>(maxDosePerPeriod);
            return this;
        }

        /**
         * Adds a {@code maxDosePerPeriod} value.
         *
         * @param maxDosePerPeriod the value to add
         * @return this builder
         */
        public Builder addMaxDosePerPeriod(Ratio maxDosePerPeriod) {
            this.maxDosePerPeriod.add(Objects.requireNonNull(maxDosePerPeriod, "maxDosePerPeriod"));
            return this;
        }

        /**
         * Sets {@code maxDosePerAdministration}.
         *
         * @param maxDosePerAdministration the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxDosePerAdministration(Quantity maxDosePerAdministration) {
            this.maxDosePerAdministration = maxDosePerAdministration;
            return this;
        }

        /**
         * Sets {@code maxDosePerLifetime}.
         *
         * @param maxDosePerLifetime the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder maxDosePerLifetime(Quantity maxDosePerLifetime) {
            this.maxDosePerLifetime = maxDosePerLifetime;
            return this;
        }

        /**
         * Builds the {@code Dosage}.
         *
         * @return the {@code Dosage}
         */
        public Dosage build() {
            return new Dosage(
                    id, extension, modifierExtension, sequence, text, additionalInstruction, patientInstruction,
                    timing, asNeeded, asNeededFor, site, route, method, doseAndRate, maxDosePerPeriod,
                    maxDosePerAdministration, maxDosePerLifetime);
        }
    }
}
