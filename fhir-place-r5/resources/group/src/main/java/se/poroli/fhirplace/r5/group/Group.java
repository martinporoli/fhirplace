package se.poroli.fhirplace.r5.group;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;

/**
 * Represents a defined collection of entities that may be discussed or acted upon collectively but which are not
 * expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't
 * an Organization.
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
 * @param identifier Business Identifier for this Group.
 * @param active Whether this group's record is in active use. Modifier element.
 * @param type person | animal | practitioner | device | careteam | healthcareservice | location | organization |
 *   relatedperson | specimen. Required.
 * @param membership definitional | enumerated. Required.
 * @param code Kind of Group members.
 * @param name Label for Group.
 * @param description Natural language description of the group.
 * @param quantity Number of members.
 * @param managingEntity Entity that is the custodian of the Group's definition. Reference to Organization,
 *   RelatedPerson, Practitioner, PractitionerRole.
 * @param characteristic Include / Exclude group members by Trait.
 * @param member Who or what is in group.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Group">FHIR R5 Group</a>
 */
public record Group(
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
        FhirEnum<GroupType> type,
        FhirEnum<GroupMembershipBasis> membership,
        CodeableConcept code,
        FhirString name,
        FhirMarkdown description,
        FhirUnsignedInt quantity,
        Reference managingEntity,
        List<Characteristic> characteristic,
        List<Member> member) implements DomainResource {

    /**
     * Creates a {@code Group}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Group {
        contained = contained == null ? List.of() : List.copyOf(contained);
        extension = extension == null ? List.of() : List.copyOf(extension);
        modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
        identifier = identifier == null ? List.of() : List.copyOf(identifier);
        characteristic = characteristic == null ? List.of() : List.copyOf(characteristic);
        member = member == null ? List.of() : List.copyOf(member);
        Objects.requireNonNull(type, "Group.type is required");
        Objects.requireNonNull(membership, "Group.membership is required");
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
     * Returns a builder initialized with the values of this {@code Group}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * Identifies traits whose presence r absence is shared by members of the group.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param code Kind of characteristic. Required.
     * @param value Value held by characteristic. One of CodeableConcept, boolean, Quantity, Range, Reference.
     *   Required.
     * @param exclude Group includes or excludes. Required.
     * @param period Period over which characteristic is tested.
     */
    public record Characteristic(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            CodeableConcept code,
            DataType value,
            FhirBoolean exclude,
            Period period) implements BackboneElement {

        /**
         * Creates a {@code Characteristic}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         * @throws IllegalArgumentException if a choice element has a type that is not allowed
         */
        public Characteristic {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(code, "Group.characteristic.code is required");
            Objects.requireNonNull(value, "Group.characteristic.value is required");
            Objects.requireNonNull(exclude, "Group.characteristic.exclude is required");
            if (value != null && !(value instanceof CodeableConcept
                    || value instanceof FhirBoolean
                    || value instanceof Quantity
                    || value instanceof Range
                    || value instanceof Reference)) {
                throw new IllegalArgumentException(
                        "Group.characteristic.value[x] does not allow "
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
            private CodeableConcept code;
            private DataType value;
            private FhirBoolean exclude;
            private Period period;

            private Builder() {
            }

            private Builder(Characteristic original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.code = original.code();
                this.value = original.value();
                this.exclude = original.exclude();
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
             * Sets {@code value} to a Range.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Range value) {
                this.value = value;
                return this;
            }

            /**
             * Sets {@code value} to a Reference.
             *
             * @param value the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder value(Reference value) {
                this.value = value;
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
             * Sets {@code exclude}.
             *
             * @param exclude the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder exclude(FhirBoolean exclude) {
                this.exclude = exclude;
                return this;
            }

            /**
             * Sets {@code exclude}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param exclude the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder exclude(Boolean exclude) {
                return exclude(exclude == null ? null : FhirBoolean.of(exclude));
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
             * Builds the {@code Characteristic}.
             *
             * @return the {@code Characteristic}
             * @throws NullPointerException if a required element is absent
             */
            public Characteristic build() {
                return new Characteristic(
                        id, extension, modifierExtension, code, value, exclude, period);
            }
        }
    }

    /**
     * Identifies the resource instances that are members of the group.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param entity Reference to the group member. Reference to CareTeam, Device, Group, HealthcareService, Location,
     *   Organization, Patient, Practitioner, PractitionerRole, RelatedPerson, Specimen. Required.
     * @param period Period member belonged to the group.
     * @param inactive If member is no longer in group.
     */
    public record Member(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            Reference entity,
            Period period,
            FhirBoolean inactive) implements BackboneElement {

        /**
         * Creates a {@code Member}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Member {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(entity, "Group.member.entity is required");
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
         * Returns a builder initialized with the values of this {@code Member}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Member}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private Reference entity;
            private Period period;
            private FhirBoolean inactive;

            private Builder() {
            }

            private Builder(Member original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.entity = original.entity();
                this.period = original.period();
                this.inactive = original.inactive();
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
             * Sets {@code entity}.
             *
             * @param entity the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder entity(Reference entity) {
                this.entity = entity;
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
             * Sets {@code inactive}.
             *
             * @param inactive the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder inactive(FhirBoolean inactive) {
                this.inactive = inactive;
                return this;
            }

            /**
             * Sets {@code inactive}, wrapped in a {@link FhirBoolean} without id or extensions.
             *
             * @param inactive the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder inactive(Boolean inactive) {
                return inactive(inactive == null ? null : FhirBoolean.of(inactive));
            }

            /**
             * Builds the {@code Member}.
             *
             * @return the {@code Member}
             * @throws NullPointerException if a required element is absent
             */
            public Member build() {
                return new Member(
                        id, extension, modifierExtension, entity, period, inactive);
            }
        }
    }

    /** Builder for {@link Group}. Builders are mutable and not thread-safe. */
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
        private FhirEnum<GroupType> type;
        private FhirEnum<GroupMembershipBasis> membership;
        private CodeableConcept code;
        private FhirString name;
        private FhirMarkdown description;
        private FhirUnsignedInt quantity;
        private Reference managingEntity;
        private List<Characteristic> characteristic = new ArrayList<>();
        private List<Member> member = new ArrayList<>();

        private Builder() {
        }

        private Builder(Group original) {
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
            this.type = original.type();
            this.membership = original.membership();
            this.code = original.code();
            this.name = original.name();
            this.description = original.description();
            this.quantity = original.quantity();
            this.managingEntity = original.managingEntity();
            this.characteristic = new ArrayList<>(original.characteristic());
            this.member = new ArrayList<>(original.member());
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
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<GroupType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(GroupType type) {
            return type(type == null ? null : FhirEnum.of(type));
        }

        /**
         * Sets {@code membership}.
         *
         * @param membership the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder membership(FhirEnum<GroupMembershipBasis> membership) {
            this.membership = membership;
            return this;
        }

        /**
         * Sets {@code membership}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param membership the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder membership(GroupMembershipBasis membership) {
            return membership(membership == null ? null : FhirEnum.of(membership));
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
         * Sets {@code name}.
         *
         * @param name the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder name(FhirString name) {
            this.name = name;
            return this;
        }

        /**
         * Sets {@code name}, wrapped in a {@link FhirString} without id or extensions.
         *
         * @param name the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder name(String name) {
            return name(name == null ? null : FhirString.of(name));
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
         * Sets {@code quantity}.
         *
         * @param quantity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder quantity(FhirUnsignedInt quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * Sets {@code quantity}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
         *
         * @param quantity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder quantity(Integer quantity) {
            return quantity(quantity == null ? null : FhirUnsignedInt.of(quantity));
        }

        /**
         * Sets {@code managingEntity}.
         *
         * @param managingEntity the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder managingEntity(Reference managingEntity) {
            this.managingEntity = managingEntity;
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
         * Replaces all {@code member} values.
         *
         * @param member the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder member(List<Member> member) {
            this.member = member == null ? new ArrayList<>() : new ArrayList<>(member);
            return this;
        }

        /**
         * Adds a {@code member} value.
         *
         * @param member the value to add
         * @return this builder
         */
        public Builder addMember(Member member) {
            this.member.add(Objects.requireNonNull(member, "member"));
            return this;
        }

        /**
         * Builds the {@code Group}.
         *
         * @return the {@code Group}
         * @throws NullPointerException if a required element is absent
         */
        public Group build() {
            return new Group(
                    id, meta, implicitRules, language, text, contained, extension, modifierExtension, identifier,
                    active, type, membership, code, name, description, quantity, managingEntity, characteristic,
                    member);
        }
    }
}
