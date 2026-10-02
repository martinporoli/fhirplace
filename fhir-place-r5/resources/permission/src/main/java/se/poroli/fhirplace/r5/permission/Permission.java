package se.poroli.fhirplace.r5.permission;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.ConsentDataMeaning;
import se.poroli.fhirplace.r5.valuesets.ConsentProvisionType;

/**
 * Permission resource holds access rules for a given data and context.
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
 * @param status active | entered-in-error | draft | rejected. Required.
 * @param asserter The person or entity that asserts the permission. Reference to Practitioner, PractitionerRole,
 *   Organization, CareTeam, Patient, RelatedPerson, HealthcareService.
 * @param date The date that permission was asserted.
 * @param validity The period in which the permission is active.
 * @param justification The asserted justification for using the data.
 * @param combining deny-overrides | permit-overrides | ordered-deny-overrides | ordered-permit-overrides |
 *   deny-unless-permit | permit-unless-deny. Required. Modifier element.
 * @param rule Constraints to the Permission.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Permission">FHIR R5 Permission</a>
 */
public record Permission(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Narrative text,
        List<Resource> contained,
        List<Extension> extension,
        List<Extension> modifierExtension,
        FhirEnum<PermissionStatus> status,
        Reference asserter,
        List<FhirDateTime> date,
        Period validity,
        Justification justification,
        FhirEnum<PermissionRuleCombining> combining,
        List<Rule> rule) implements DomainResource {

    /**
     * Creates a {@code Permission}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Permission {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        date = date == null ? List.of() : List.copyOf(date);
        rule = rule == null ? List.of() : List.copyOf(rule);
        Objects.requireNonNull(status, "Permission.status is required");
        Objects.requireNonNull(combining, "Permission.combining is required");
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
     * Returns a builder initialized with the values of this {@code Permission}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * The asserted justification for using the data.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param basis The regulatory grounds upon which this Permission builds.
     * @param evidence Justifing rational. Reference to Resource.
     */
    public record Justification(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<CodeableConcept> basis,
            List<Reference> evidence) implements BackboneElement {

        /**
         * Creates a {@code Justification}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Justification {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            basis = basis == null ? List.of() : List.copyOf(basis);
            evidence = evidence == null ? List.of() : List.copyOf(evidence);
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
         * Returns a builder initialized with the values of this {@code Justification}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Justification}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<CodeableConcept> basis = new ArrayList<>();
            private List<Reference> evidence = new ArrayList<>();

            private Builder() {
            }

            private Builder(Justification original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.basis = new ArrayList<>(original.basis());
                this.evidence = new ArrayList<>(original.evidence());
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
             * Replaces all {@code basis} values.
             *
             * @param basis the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder basis(List<CodeableConcept> basis) {
                this.basis = basis == null ? new ArrayList<>() : new ArrayList<>(basis);
                return this;
            }

            /**
             * Adds a {@code basis} value.
             *
             * @param basis the value to add
             * @return this builder
             */
            public Builder addBasis(CodeableConcept basis) {
                this.basis.add(Objects.requireNonNull(basis, "basis"));
                return this;
            }

            /**
             * Replaces all {@code evidence} values.
             *
             * @param evidence the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder evidence(List<Reference> evidence) {
                this.evidence = evidence == null ? new ArrayList<>() : new ArrayList<>(evidence);
                return this;
            }

            /**
             * Adds a {@code evidence} value.
             *
             * @param evidence the value to add
             * @return this builder
             */
            public Builder addEvidence(Reference evidence) {
                this.evidence.add(Objects.requireNonNull(evidence, "evidence"));
                return this;
            }

            /**
             * Builds the {@code Justification}.
             *
             * @return the {@code Justification}
             */
            public Justification build() {
                return new Justification(
                        id, extension, modifierExtension, basis, evidence);
            }
        }
    }

    /**
     * A set of rules.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param type deny | permit. Modifier element.
     * @param data The selection criteria to identify data that is within scope of this provision.
     * @param activity A description or definition of which activities are allowed to be done on the data.
     * @param limit What limits apply to the use of the data.
     */
    public record Rule(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<ConsentProvisionType> type,
            List<Data> data,
            List<Activity> activity,
            List<CodeableConcept> limit) implements BackboneElement {

        /**
         * Creates a {@code Rule}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Rule {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            data = data == null ? List.of() : List.copyOf(data);
            activity = activity == null ? List.of() : List.copyOf(activity);
            limit = limit == null ? List.of() : List.copyOf(limit);
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
         * Returns a builder initialized with the values of this {@code Rule}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * A description or definition of which activities are allowed to be done on the data.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param resource Explicit FHIR Resource references.
         * @param security Security tag code on .meta.security.
         * @param period Timeframe encompasing data create/update.
         * @param expression Expression identifying the data.
         */
        public record Data(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<DataResource> resource,
                List<Coding> security,
                List<Period> period,
                Expression expression) implements BackboneElement {

            /**
             * Creates a {@code Data}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Data {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                resource = resource == null ? List.of() : List.copyOf(resource);
                security = security == null ? List.of() : List.copyOf(security);
                period = period == null ? List.of() : List.copyOf(period);
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
             * Returns a builder initialized with the values of this {@code Data}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /**
             * Explicit FHIR Resource references.
             *
             * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists.
             * Instances are usually created with {@link #builder()}.
             *
             * @param id Unique id for inter-element referencing.
             * @param extension Additional content defined by implementations.
             * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
             * @param meaning instance | related | dependents | authoredby. Required.
             * @param reference The actual data reference. Reference to Resource. Required.
             */
            public record DataResource(
                    String id,
                    List<Extension> extension,
                    List<Extension> modifierExtension,
                    FhirEnum<ConsentDataMeaning> meaning,
                    Reference reference) implements BackboneElement {

                /**
                 * Creates a {@code DataResource}, copying all lists.
                 *
                 * @throws NullPointerException if a required element is absent or a list contains {@code null}
                 */
                public DataResource {
                    extension = extension == null ? List.of() : List.copyOf(extension);
                    modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                    Objects.requireNonNull(meaning, "Permission.rule.data.resource.meaning is required");
                    Objects.requireNonNull(reference, "Permission.rule.data.resource.reference is required");
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
                 * Returns a builder initialized with the values of this {@code DataResource}.
                 *
                 * @return the builder
                 */
                public Builder toBuilder() {
                    return new Builder(this);
                }

                /** Builder for {@link DataResource}. Builders are mutable and not thread-safe. */
                public static final class Builder {

                    private String id;
                    private List<Extension> extension = new ArrayList<>();
                    private List<Extension> modifierExtension = new ArrayList<>();
                    private FhirEnum<ConsentDataMeaning> meaning;
                    private Reference reference;

                    private Builder() {
                    }

                    private Builder(DataResource original) {
                        this.id = original.id();
                        this.extension = new ArrayList<>(original.extension());
                        this.modifierExtension = new ArrayList<>(original.modifierExtension());
                        this.meaning = original.meaning();
                        this.reference = original.reference();
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
                     * Sets {@code meaning}.
                     *
                     * @param meaning the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder meaning(FhirEnum<ConsentDataMeaning> meaning) {
                        this.meaning = meaning;
                        return this;
                    }

                    /**
                     * Sets {@code meaning}, wrapped in a {@link FhirEnum} without id or extensions.
                     *
                     * @param meaning the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder meaning(ConsentDataMeaning meaning) {
                        return meaning(meaning == null ? null : FhirEnum.of(meaning));
                    }

                    /**
                     * Sets {@code reference}.
                     *
                     * @param reference the value, or {@code null} to clear it
                     * @return this builder
                     */
                    public Builder reference(Reference reference) {
                        this.reference = reference;
                        return this;
                    }

                    /**
                     * Builds the {@code DataResource}.
                     *
                     * @return the {@code DataResource}
                     * @throws NullPointerException if a required element is absent
                     */
                    public DataResource build() {
                        return new DataResource(
                                id, extension, modifierExtension, meaning, reference);
                    }
                }
            }

            /** Builder for {@link Data}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<DataResource> resource = new ArrayList<>();
                private List<Coding> security = new ArrayList<>();
                private List<Period> period = new ArrayList<>();
                private Expression expression;

                private Builder() {
                }

                private Builder(Data original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.resource = new ArrayList<>(original.resource());
                    this.security = new ArrayList<>(original.security());
                    this.period = new ArrayList<>(original.period());
                    this.expression = original.expression();
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
                 * Replaces all {@code resource} values.
                 *
                 * @param resource the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder resource(List<DataResource> resource) {
                    this.resource = resource == null ? new ArrayList<>() : new ArrayList<>(resource);
                    return this;
                }

                /**
                 * Adds a {@code resource} value.
                 *
                 * @param resource the value to add
                 * @return this builder
                 */
                public Builder addResource(DataResource resource) {
                    this.resource.add(Objects.requireNonNull(resource, "resource"));
                    return this;
                }

                /**
                 * Replaces all {@code security} values.
                 *
                 * @param security the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder security(List<Coding> security) {
                    this.security = security == null ? new ArrayList<>() : new ArrayList<>(security);
                    return this;
                }

                /**
                 * Adds a {@code security} value.
                 *
                 * @param security the value to add
                 * @return this builder
                 */
                public Builder addSecurity(Coding security) {
                    this.security.add(Objects.requireNonNull(security, "security"));
                    return this;
                }

                /**
                 * Replaces all {@code period} values.
                 *
                 * @param period the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder period(List<Period> period) {
                    this.period = period == null ? new ArrayList<>() : new ArrayList<>(period);
                    return this;
                }

                /**
                 * Adds a {@code period} value.
                 *
                 * @param period the value to add
                 * @return this builder
                 */
                public Builder addPeriod(Period period) {
                    this.period.add(Objects.requireNonNull(period, "period"));
                    return this;
                }

                /**
                 * Sets {@code expression}.
                 *
                 * @param expression the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder expression(Expression expression) {
                    this.expression = expression;
                    return this;
                }

                /**
                 * Builds the {@code Data}.
                 *
                 * @return the {@code Data}
                 */
                public Data build() {
                    return new Data(
                            id, extension, modifierExtension, resource, security, period, expression);
                }
            }
        }

        /**
         * A description or definition of which activities are allowed to be done on the data.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param actor Authorized actor(s). Reference to Device, Group, CareTeam, Organization, Patient,
         *   Practitioner, RelatedPerson, PractitionerRole.
         * @param action Actions controlled by this rule.
         * @param purpose The purpose for which the permission is given.
         */
        public record Activity(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                List<Reference> actor,
                List<CodeableConcept> action,
                List<CodeableConcept> purpose) implements BackboneElement {

            /**
             * Creates an {@code Activity}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Activity {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                actor = actor == null ? List.of() : List.copyOf(actor);
                action = action == null ? List.of() : List.copyOf(action);
                purpose = purpose == null ? List.of() : List.copyOf(purpose);
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
             * Returns a builder initialized with the values of this {@code Activity}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Activity}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private List<Reference> actor = new ArrayList<>();
                private List<CodeableConcept> action = new ArrayList<>();
                private List<CodeableConcept> purpose = new ArrayList<>();

                private Builder() {
                }

                private Builder(Activity original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.actor = new ArrayList<>(original.actor());
                    this.action = new ArrayList<>(original.action());
                    this.purpose = new ArrayList<>(original.purpose());
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
                 * Replaces all {@code actor} values.
                 *
                 * @param actor the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder actor(List<Reference> actor) {
                    this.actor = actor == null ? new ArrayList<>() : new ArrayList<>(actor);
                    return this;
                }

                /**
                 * Adds a {@code actor} value.
                 *
                 * @param actor the value to add
                 * @return this builder
                 */
                public Builder addActor(Reference actor) {
                    this.actor.add(Objects.requireNonNull(actor, "actor"));
                    return this;
                }

                /**
                 * Replaces all {@code action} values.
                 *
                 * @param action the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder action(List<CodeableConcept> action) {
                    this.action = action == null ? new ArrayList<>() : new ArrayList<>(action);
                    return this;
                }

                /**
                 * Adds a {@code action} value.
                 *
                 * @param action the value to add
                 * @return this builder
                 */
                public Builder addAction(CodeableConcept action) {
                    this.action.add(Objects.requireNonNull(action, "action"));
                    return this;
                }

                /**
                 * Replaces all {@code purpose} values.
                 *
                 * @param purpose the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder purpose(List<CodeableConcept> purpose) {
                    this.purpose = purpose == null ? new ArrayList<>() : new ArrayList<>(purpose);
                    return this;
                }

                /**
                 * Adds a {@code purpose} value.
                 *
                 * @param purpose the value to add
                 * @return this builder
                 */
                public Builder addPurpose(CodeableConcept purpose) {
                    this.purpose.add(Objects.requireNonNull(purpose, "purpose"));
                    return this;
                }

                /**
                 * Builds the {@code Activity}.
                 *
                 * @return the {@code Activity}
                 */
                public Activity build() {
                    return new Activity(
                            id, extension, modifierExtension, actor, action, purpose);
                }
            }
        }

        /** Builder for {@link Rule}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<ConsentProvisionType> type;
            private List<Data> data = new ArrayList<>();
            private List<Activity> activity = new ArrayList<>();
            private List<CodeableConcept> limit = new ArrayList<>();

            private Builder() {
            }

            private Builder(Rule original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.type = original.type();
                this.data = new ArrayList<>(original.data());
                this.activity = new ArrayList<>(original.activity());
                this.limit = new ArrayList<>(original.limit());
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
            public Builder type(FhirEnum<ConsentProvisionType> type) {
                this.type = type;
                return this;
            }

            /**
             * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param type the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder type(ConsentProvisionType type) {
                return type(type == null ? null : FhirEnum.of(type));
            }

            /**
             * Replaces all {@code data} values.
             *
             * @param data the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder data(List<Data> data) {
                this.data = data == null ? new ArrayList<>() : new ArrayList<>(data);
                return this;
            }

            /**
             * Adds a {@code data} value.
             *
             * @param data the value to add
             * @return this builder
             */
            public Builder addData(Data data) {
                this.data.add(Objects.requireNonNull(data, "data"));
                return this;
            }

            /**
             * Replaces all {@code activity} values.
             *
             * @param activity the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder activity(List<Activity> activity) {
                this.activity = activity == null ? new ArrayList<>() : new ArrayList<>(activity);
                return this;
            }

            /**
             * Adds a {@code activity} value.
             *
             * @param activity the value to add
             * @return this builder
             */
            public Builder addActivity(Activity activity) {
                this.activity.add(Objects.requireNonNull(activity, "activity"));
                return this;
            }

            /**
             * Replaces all {@code limit} values.
             *
             * @param limit the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder limit(List<CodeableConcept> limit) {
                this.limit = limit == null ? new ArrayList<>() : new ArrayList<>(limit);
                return this;
            }

            /**
             * Adds a {@code limit} value.
             *
             * @param limit the value to add
             * @return this builder
             */
            public Builder addLimit(CodeableConcept limit) {
                this.limit.add(Objects.requireNonNull(limit, "limit"));
                return this;
            }

            /**
             * Builds the {@code Rule}.
             *
             * @return the {@code Rule}
             */
            public Rule build() {
                return new Rule(
                        id, extension, modifierExtension, type, data, activity, limit);
            }
        }
    }

    /** Builder for {@link Permission}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Narrative text;
        private List<Resource> contained = new ArrayList<>();
        private List<Extension> extension = new ArrayList<>();
        private List<Extension> modifierExtension = new ArrayList<>();
        private FhirEnum<PermissionStatus> status;
        private Reference asserter;
        private List<FhirDateTime> date = new ArrayList<>();
        private Period validity;
        private Justification justification;
        private FhirEnum<PermissionRuleCombining> combining;
        private List<Rule> rule = new ArrayList<>();

        private Builder() {
        }

        private Builder(Permission original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.text = original.text();
            this.contained = new ArrayList<>(original.contained());
            this.extension = new ArrayList<>(original.extension());
            this.modifierExtension = new ArrayList<>(original.modifierExtension());
            this.status = original.status();
            this.asserter = original.asserter();
            this.date = new ArrayList<>(original.date());
            this.validity = original.validity();
            this.justification = original.justification();
            this.combining = original.combining();
            this.rule = new ArrayList<>(original.rule());
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
         * Sets {@code status}.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(FhirEnum<PermissionStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Sets {@code status}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param status the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder status(PermissionStatus status) {
            return status(status == null ? null : FhirEnum.of(status));
        }

        /**
         * Sets {@code asserter}.
         *
         * @param asserter the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder asserter(Reference asserter) {
            this.asserter = asserter;
            return this;
        }

        /**
         * Replaces all {@code date} values.
         *
         * @param date the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder date(List<FhirDateTime> date) {
            this.date = date == null ? new ArrayList<>() : new ArrayList<>(date);
            return this;
        }

        /**
         * Adds a {@code date} value.
         *
         * @param date the value to add
         * @return this builder
         */
        public Builder addDate(FhirDateTime date) {
            this.date.add(Objects.requireNonNull(date, "date"));
            return this;
        }

        /**
         * Adds a {@code date} value, wrapped in a {@link FhirDateTime} without id or extensions.
         *
         * @param date the value to add
         * @return this builder
         */
        public Builder addDate(Temporal date) {
            return addDate(FhirDateTime.of(date));
        }

        /**
         * Sets {@code validity}.
         *
         * @param validity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder validity(Period validity) {
            this.validity = validity;
            return this;
        }

        /**
         * Sets {@code justification}.
         *
         * @param justification the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder justification(Justification justification) {
            this.justification = justification;
            return this;
        }

        /**
         * Sets {@code combining}.
         *
         * @param combining the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder combining(FhirEnum<PermissionRuleCombining> combining) {
            this.combining = combining;
            return this;
        }

        /**
         * Sets {@code combining}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param combining the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder combining(PermissionRuleCombining combining) {
            return combining(combining == null ? null : FhirEnum.of(combining));
        }

        /**
         * Replaces all {@code rule} values.
         *
         * @param rule the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder rule(List<Rule> rule) {
            this.rule = rule == null ? new ArrayList<>() : new ArrayList<>(rule);
            return this;
        }

        /**
         * Adds a {@code rule} value.
         *
         * @param rule the value to add
         * @return this builder
         */
        public Builder addRule(Rule rule) {
            this.rule.add(Objects.requireNonNull(rule, "rule"));
            return this;
        }

        /**
         * Builds the {@code Permission}.
         *
         * @return the {@code Permission}
         * @throws NullPointerException if a required element is absent
         */
        public Permission build() {
            return new Permission(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, status,
                    asserter, date, validity, justification, combining, rule);
        }
    }
}
