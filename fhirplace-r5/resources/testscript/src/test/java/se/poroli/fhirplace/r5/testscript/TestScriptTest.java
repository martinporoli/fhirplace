package se.poroli.fhirplace.r5.testscript;

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
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/** Builds a TestScript with all elements and checks the builder and validation. */
class TestScriptTest {

    @Test
    void testScript() {
        TestScript resource = TestScript.builder()
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
                .addOrigin(TestScript.Origin.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .index(FhirInteger.of(1))
                        .profile(Coding.builder().build())
                        .url(FhirUrl.of("http://example.org/url"))
                        .build())
                .addDestination(TestScript.Destination.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .index(FhirInteger.of(1))
                        .profile(Coding.builder().build())
                        .url(FhirUrl.of("http://example.org/url"))
                        .build())
                .metadata(TestScript.Metadata.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addLink(TestScript.Metadata.Link.builder()
                                .url(FhirUri.of("http://example.org/uri"))
                                .build())
                        .addCapability(TestScript.Metadata.Capability.builder()
                                .required(FhirBoolean.of(true))
                                .validated(FhirBoolean.of(true))
                                .capabilities(FhirCanonical.of("http://example.org/canonical"))
                                .build())
                        .build())
                .addScope(TestScript.Scope.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .artifact(FhirCanonical.of("http://example.org/canonical"))
                        .conformance(CodeableConcept.builder().build())
                        .phase(CodeableConcept.builder().build())
                        .build())
                .addFixture(TestScript.Fixture.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .autocreate(FhirBoolean.of(true))
                        .autodelete(FhirBoolean.of(true))
                        .resource(Reference.builder().build())
                        .build())
                .addProfile(FhirCanonical.of("http://example.org/canonical"))
                .addVariable(TestScript.Variable.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .defaultValue(FhirString.of("text"))
                        .description(FhirString.of("text"))
                        .expression(FhirString.of("text"))
                        .headerField(FhirString.of("text"))
                        .hint(FhirString.of("text"))
                        .path(FhirString.of("text"))
                        .sourceId(FhirId.of("id1"))
                        .build())
                .setup(TestScript.Setup.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addAction(TestScript.Setup.SetupAction.builder().build())
                        .build())
                .addTest(TestScript.Test.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .description(FhirString.of("text"))
                        .addAction(TestScript.Test.TestAction.builder().build())
                        .build())
                .teardown(TestScript.Teardown.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addAction(TestScript.Teardown.TeardownAction.builder()
                                .operation(TestScript.Setup.SetupAction.Operation.builder()
                                        .encodeRequestUrl(FhirBoolean.of(true))
                                        .build())
                                .build())
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
        assertFalse(resource.origin().isEmpty());
        assertFalse(resource.destination().isEmpty());
        assertNotNull(resource.metadata());
        assertFalse(resource.scope().isEmpty());
        assertFalse(resource.fixture().isEmpty());
        assertFalse(resource.profile().isEmpty());
        assertFalse(resource.variable().isEmpty());
        assertNotNull(resource.setup());
        assertFalse(resource.test().isEmpty());
        assertNotNull(resource.teardown());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("TestScript.name is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().name((FhirString) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(AssertionDirectionType.values(), AssertionDirectionType::fromCode);
        assertCodes(AssertionManualCompletionType.values(), AssertionManualCompletionType::fromCode);
        assertCodes(AssertionOperatorType.values(), AssertionOperatorType::fromCode);
        assertCodes(AssertionResponseTypes.values(), AssertionResponseTypes::fromCode);
        assertCodes(TestScriptRequestMethodCode.values(), TestScriptRequestMethodCode::fromCode);
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
