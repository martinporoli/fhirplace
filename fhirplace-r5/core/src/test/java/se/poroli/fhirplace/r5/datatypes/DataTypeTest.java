package se.poroli.fhirplace.r5.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import se.poroli.fhirplace.r5.valuesets.ContactPointSystem;
import se.poroli.fhirplace.r5.valuesets.ContributorType;
import se.poroli.fhirplace.r5.valuesets.DaysOfWeek;
import se.poroli.fhirplace.r5.valuesets.FHIRTypes;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.OperationParameterUse;
import se.poroli.fhirplace.r5.valuesets.PriceComponentType;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;
import se.poroli.fhirplace.r5.valuesets.TriggerType;
import se.poroli.fhirplace.r5.valuesets.UnitsOfTime;

class DataTypeTest {

    /** The concrete complex datatypes on https://hl7.org/fhir/R5/datatypes.html, excluding Quantity profiles. */
    private static final Set<String> SPEC_COMPLEX_DATATYPES = Set.of(
            "Identifier", "HumanName", "Address", "ContactPoint", "Timing", "Quantity", "Attachment", "Range",
            "Period", "Ratio", "RatioRange", "CodeableConcept", "Coding", "SampledData", "Age", "Distance",
            "Duration", "Count", "Money", "Annotation", "Signature", "ContactDetail", "Contributor",
            "DataRequirement", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", "UsageContext",
            "Expression", "ExtendedContactDetail", "VirtualServiceDetail", "Availability", "MonetaryComponent",
            "Reference", "CodeableReference", "Narrative", "Extension", "Meta", "Dosage", "ElementDefinition");

    /** Datatypes defined on other pages of the specification and used by resources. */
    private static final Set<String> OTHER_DATATYPES = Set.of("MarketingStatus", "ProductShelfLife");

    private static final Quantity TEN_MG = Quantity.builder().value(BigDecimal.TEN).unit("mg").build();
    private static final CodeableConcept CONCEPT = CodeableConcept.builder().text("concept").build();
    private static final Reference PATIENT = Reference.builder().reference("Patient/1").build();
    private static final ContactPoint EMAIL =
            ContactPoint.builder().system(ContactPointSystem.EMAIL).value("jane@example.org").build();
    private static final Timing TWICE_DAILY = Timing.builder()
            .repeat(Timing.Repeat.builder().frequency(2).period(BigDecimal.ONE).periodUnit(UnitsOfTime.D).build())
            .build();

    static Stream<DataType> complexDatatypes() {
        return Stream.of(
                Identifier.builder().system("urn:ietf:rfc:3986").value("urn:oid:1.2.3").build(),
                HumanName.builder().family("Doe").addGiven("Jane").build(),
                Address.builder().addLine("Storgatan 1").city("Stockholm").build(),
                EMAIL,
                TWICE_DAILY,
                TEN_MG,
                Attachment.builder().contentType("text/plain").data(FhirBase64Binary.of("aGk=")).build(),
                Range.builder().low(TEN_MG).build(),
                Period.builder().start(LocalDate.of(2024, 1, 1)).build(),
                Ratio.builder().numerator(TEN_MG).denominator(TEN_MG).build(),
                RatioRange.builder().lowNumerator(TEN_MG).denominator(TEN_MG).build(),
                CONCEPT,
                Coding.builder().system("http://loinc.org").code("8867-4").build(),
                SampledData.builder().origin(TEN_MG).intervalUnit("ms").dimensions(1).data("1 2 3").build(),
                Age.builder().value(BigDecimal.valueOf(42)).system("http://unitsofmeasure.org").code("a").build(),
                Distance.builder().value(BigDecimal.ONE).system("http://unitsofmeasure.org").code("km").build(),
                Duration.builder().value(BigDecimal.ONE).system("http://unitsofmeasure.org").code("h").build(),
                Count.builder().value(BigDecimal.ONE).system("http://unitsofmeasure.org").code("1").build(),
                Money.builder().value(BigDecimal.TEN).currency("SEK").build(),
                Annotation.builder().text("A note").build(),
                Signature.builder().who(PATIENT).build(),
                ContactDetail.builder().name("Support").addTelecom(EMAIL).build(),
                Contributor.builder().type(ContributorType.AUTHOR).name("Jane").build(),
                DataRequirement.builder().type(FHIRTypes.PATIENT).build(),
                ParameterDefinition.builder().use(OperationParameterUse.IN).type(FHIRTypes.STRING).build(),
                RelatedArtifact.builder().type(RelatedArtifactType.DOCUMENTATION).label("Guide").build(),
                TriggerDefinition.builder().type(TriggerType.NAMED_EVENT).name("admission").build(),
                UsageContext.builder().code(Coding.builder().code("focus").build()).value(CONCEPT).build(),
                Expression.builder().language("text/fhirpath").expression("1 + 1").build(),
                ExtendedContactDetail.builder().addTelecom(EMAIL).build(),
                VirtualServiceDetail.builder().address(FhirUrl.of("https://meet.example.org/1")).build(),
                Availability.builder().addAvailableTime(Availability.AvailableTime.builder()
                        .addDaysOfWeek(DaysOfWeek.MON).availableStartTime(LocalTime.of(8, 0)).build()).build(),
                MonetaryComponent.builder().type(PriceComponentType.BASE).build(),
                PATIENT,
                CodeableReference.builder().concept(CONCEPT).build(),
                Narrative.builder().status(NarrativeStatus.GENERATED).div("<div>Hi</div>").build(),
                Extension.builder().url("http://example.org/ext").value(FhirBoolean.of(true)).build(),
                Meta.builder().versionId("1").build(),
                Dosage.builder().text("Twice daily").timing(TWICE_DAILY).build(),
                ElementDefinition.builder().path("Patient.name").shortValue("A name").min(0).max("*")
                        .addType(ElementDefinition.TypeRef.builder().code("HumanName").build()).build(),
                MarketingStatus.builder().status(CONCEPT).build(),
                ProductShelfLife.builder().type(CONCEPT).period("P2Y").build());
    }

    /** Rebuilds a datatype through its builder; the switch fails to compile if a datatype has no case. */
    private static DataType rebuild(DataType value) {
        return switch (value) {
            case PrimitiveType<?> p -> p;
            case Identifier v -> v.toBuilder().build();
            case HumanName v -> v.toBuilder().build();
            case Address v -> v.toBuilder().build();
            case ContactPoint v -> v.toBuilder().build();
            case Timing v -> v.toBuilder().build();
            case Quantity v -> v.toBuilder().build();
            case Attachment v -> v.toBuilder().build();
            case Range v -> v.toBuilder().build();
            case Period v -> v.toBuilder().build();
            case Ratio v -> v.toBuilder().build();
            case RatioRange v -> v.toBuilder().build();
            case CodeableConcept v -> v.toBuilder().build();
            case Coding v -> v.toBuilder().build();
            case SampledData v -> v.toBuilder().build();
            case Age v -> v.toBuilder().build();
            case Distance v -> v.toBuilder().build();
            case Duration v -> v.toBuilder().build();
            case Count v -> v.toBuilder().build();
            case Money v -> v.toBuilder().build();
            case Annotation v -> v.toBuilder().build();
            case Signature v -> v.toBuilder().build();
            case ContactDetail v -> v.toBuilder().build();
            case Contributor v -> v.toBuilder().build();
            case DataRequirement v -> v.toBuilder().build();
            case ParameterDefinition v -> v.toBuilder().build();
            case RelatedArtifact v -> v.toBuilder().build();
            case TriggerDefinition v -> v.toBuilder().build();
            case UsageContext v -> v.toBuilder().build();
            case Expression v -> v.toBuilder().build();
            case ExtendedContactDetail v -> v.toBuilder().build();
            case VirtualServiceDetail v -> v.toBuilder().build();
            case Availability v -> v.toBuilder().build();
            case MonetaryComponent v -> v.toBuilder().build();
            case Reference v -> v.toBuilder().build();
            case CodeableReference v -> v.toBuilder().build();
            case Narrative v -> v.toBuilder().build();
            case Extension v -> v.toBuilder().build();
            case Meta v -> v.toBuilder().build();
            case Dosage v -> v.toBuilder().build();
            case ElementDefinition v -> v.toBuilder().build();
            case MarketingStatus v -> v.toBuilder().build();
            case ProductShelfLife v -> v.toBuilder().build();
        };
    }

    @Test
    void everyComplexDatatypeOfTheSpecificationIsRepresented() {
        Set<String> represented = complexDatatypes().map(v -> v.getClass().getSimpleName()).collect(Collectors.toSet());

        assertEquals(Stream.concat(SPEC_COMPLEX_DATATYPES.stream(), OTHER_DATATYPES.stream()).collect(Collectors.toSet()),
                represented);
    }

    @ParameterizedTest
    @MethodSource("complexDatatypes")
    void toBuilderRoundTripsEveryDatatype(DataType value) {
        DataType copy = rebuild(value);

        assertEquals(value, copy);
        assertEquals(value.hashCode(), copy.hashCode());
    }

    @Test
    void quantitySpecializationsAreDistinctTypes() {
        Quantity quantity = Quantity.builder().value(BigDecimal.ONE).code("a").build();
        Age age = Age.builder().value(BigDecimal.ONE).code("a").build();

        assertNotEquals(quantity, age);
        assertEquals(age, Extension.builder().url("http://example.org/age").value(age).build().value());
    }

    @Test
    void backboneTypesCarryModifierExtensions() {
        Extension modifier = Extension.builder().url("http://example.org/must-understand").value(FhirBoolean.of(true))
                .build();

        Dosage dosage = Dosage.builder().addModifierExtension(modifier).build();

        BackboneType backbone = assertInstanceOf(BackboneType.class, dosage);
        assertEquals(List.of(modifier), backbone.modifierExtension());
    }

    @Test
    void openChoiceAcceptsDatatypesAndRejectsTheExcludedOnes() {
        ElementDefinition.Builder element = ElementDefinition.builder().path("Patient.gender");

        assertEquals(FhirCode.of("female"), element.fixed(FhirCode.of("female")).build().fixed());
        assertEquals(TEN_MG, element.fixed(TEN_MG).build().fixed());

        Narrative narrative = Narrative.builder().status(NarrativeStatus.EMPTY).div("<div/>").build();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> element.fixed(narrative).build());
        assertEquals("ElementDefinition.fixed[x] does not allow Narrative", e.getMessage());
    }

    @Test
    void javaKeywordElementsAreRenamed() {
        ElementDefinition element = ElementDefinition.builder().path("Patient").shortValue("Patient").build();

        assertEquals("Patient", element.shortValue().value());
    }

    @Test
    void requiredElementsMustBePresent() {
        assertThrows(NullPointerException.class, () -> ElementDefinition.builder().build());
        assertThrows(NullPointerException.class, () -> Annotation.builder().build());
        assertThrows(NullPointerException.class,
                () -> UsageContext.builder().code(Coding.builder().code("focus").build()).build());
    }
}
