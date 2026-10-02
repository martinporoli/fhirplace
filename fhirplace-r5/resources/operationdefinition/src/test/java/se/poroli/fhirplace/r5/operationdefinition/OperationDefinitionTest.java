package se.poroli.fhirplace.r5.operationdefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.BindingStrength;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.FHIRTypes;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.OperationParameterUse;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.SearchParamType;

/** Builds a OperationDefinition with all elements and checks the builder and validation. */
class OperationDefinitionTest {

    @Test
    void operationDefinition() {
        OperationDefinition resource = OperationDefinition.builder()
                .id("id1")
                .meta(Meta.builder().build())
                .implicitRules(FhirUri.of("http://example.org/uri"))
                .language(FhirCode.of("code"))
                .text(Narrative.builder()
                        .status(FhirEnum.of(NarrativeStatus.values()[0]))
                        .div(FhirXhtml.of("<div xmlns=\"http://www.w3.org/1999/xhtml\"/>"))
                        .build())
                .addContained(Patient.builder().build())
                .addExtension(Extension.builder().url("http://example.org/extension").build())
                .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                .url(FhirUri.of("http://example.org/uri"))
                .addIdentifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .kind(FhirEnum.of(OperationKind.values()[0]))
                .experimental(FhirBoolean.of(true))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .affectsState(FhirBoolean.of(true))
                .code(FhirCode.of("code"))
                .comment(FhirMarkdown.of("text"))
                .base(FhirCanonical.of("http://example.org/canonical"))
                .addResource(FhirCode.of("code"))
                .system(FhirBoolean.of(true))
                .type(FhirBoolean.of(true))
                .instance(FhirBoolean.of(true))
                .inputProfile(FhirCanonical.of("http://example.org/canonical"))
                .outputProfile(FhirCanonical.of("http://example.org/canonical"))
                .addParameter(OperationDefinition.Parameter.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirCode.of("code"))
                        .use(FhirEnum.of(OperationParameterUse.values()[0]))
                        .addScope(FhirEnum.of(OperationParameterScope.values()[0]))
                        .min(FhirInteger.of(1))
                        .max(FhirString.of("text"))
                        .documentation(FhirMarkdown.of("text"))
                        .type(FhirEnum.of(FHIRTypes.values()[0]))
                        .addAllowedType(FhirEnum.of(FHIRTypes.values()[0]))
                        .addTargetProfile(FhirCanonical.of("http://example.org/canonical"))
                        .searchType(FhirEnum.of(SearchParamType.values()[0]))
                        .binding(OperationDefinition.Parameter.Binding.builder()
                                .strength(FhirEnum.of(BindingStrength.values()[0]))
                                .valueSet(FhirCanonical.of("http://example.org/canonical"))
                                .build())
                        .addReferencedFrom(OperationDefinition.Parameter.ReferencedFrom.builder()
                                .source(FhirString.of("text"))
                                .build())
                        .addPart(OperationDefinition.Parameter.builder()
                                .name(FhirCode.of("code"))
                                .use(FhirEnum.of(OperationParameterUse.values()[0]))
                                .min(FhirInteger.of(1))
                                .max(FhirString.of("text"))
                                .build())
                        .build())
                .addOverload(OperationDefinition.Overload.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addParameterName(FhirString.of("text"))
                        .comment(FhirString.of("text"))
                        .build())
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.text());
        assertFalse(resource.contained().isEmpty());
        assertFalse(resource.extension().isEmpty());
        assertFalse(resource.modifierExtension().isEmpty());
        assertNotNull(resource.url());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.status());
        assertNotNull(resource.kind());
        assertNotNull(resource.experimental());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.affectsState());
        assertNotNull(resource.code());
        assertNotNull(resource.comment());
        assertNotNull(resource.base());
        assertFalse(resource.resource().isEmpty());
        assertNotNull(resource.system());
        assertNotNull(resource.type());
        assertNotNull(resource.instance());
        assertNotNull(resource.inputProfile());
        assertNotNull(resource.outputProfile());
        assertFalse(resource.parameter().isEmpty());
        assertFalse(resource.overload().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("OperationDefinition.name is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().name((FhirString) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(OperationKind.values(), OperationKind::fromCode);
        assertCodes(OperationParameterScope.values(), OperationParameterScope::fromCode);
    }

    private static <E extends CodedEnum> void assertCodes(E[] values, Function<String, E> fromCode) {
        for (E value : values) {
            assertSame(value, fromCode.apply(value.code()));
            assertTrue(URI.create(value.system()).isAbsolute());
            assertFalse(value.display().isBlank());
        }
        assertThrows(IllegalArgumentException.class, () -> fromCode.apply("no-such-code"));
        assertThrows(IllegalArgumentException.class, () -> fromCode.apply(values[0].code().toUpperCase() + "X"));
    }
}
