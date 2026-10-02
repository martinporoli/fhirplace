package se.poroli.fhirplace.r5.capabilitystatement;

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
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CapabilityStatementKind;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.FHIRVersion;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.ResourceType;
import se.poroli.fhirplace.r5.valuesets.SearchParamType;

/** Builds a CapabilityStatement with all elements and checks the builder and validation. */
class CapabilityStatementTest {

    @Test
    void capabilityStatement() {
        CapabilityStatement resource = CapabilityStatement.builder()
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
                .kind(FhirEnum.of(CapabilityStatementKind.values()[0]))
                .addInstantiates(FhirCanonical.of("http://example.org/canonical"))
                .addImports(FhirCanonical.of("http://example.org/canonical"))
                .software(CapabilityStatement.Software.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .version(FhirString.of("text"))
                        .releaseDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .implementation(CapabilityStatement.Implementation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirMarkdown.of("text"))
                        .url(FhirUrl.of("http://example.org/url"))
                        .custodian(Reference.builder().build())
                        .build())
                .fhirVersion(FhirEnum.of(FHIRVersion.values()[0]))
                .addFormat(FhirCode.of("code"))
                .addPatchFormat(FhirCode.of("code"))
                .addAcceptLanguage(FhirCode.of("code"))
                .addImplementationGuide(FhirCanonical.of("http://example.org/canonical"))
                .addRest(CapabilityStatement.Rest.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .mode(FhirEnum.of(RestfulCapabilityMode.values()[0]))
                        .documentation(FhirMarkdown.of("text"))
                        .security(CapabilityStatement.Rest.Security.builder().build())
                        .addResource(CapabilityStatement.Rest.RestResource.builder()
                                .type(FhirEnum.of(ResourceType.values()[0]))
                                .build())
                        .addInteraction(CapabilityStatement.Rest.SystemInteraction.builder()
                                .code(FhirEnum.of(SystemRestfulInteraction.values()[0]))
                                .build())
                        .addSearchParam(CapabilityStatement.Rest.RestResource.SearchParam.builder()
                                .name(FhirString.of("text"))
                                .type(FhirEnum.of(SearchParamType.values()[0]))
                                .build())
                        .addOperation(CapabilityStatement.Rest.RestResource.Operation.builder()
                                .name(FhirString.of("text"))
                                .definition(FhirCanonical.of("http://example.org/canonical"))
                                .build())
                        .addCompartment(FhirCanonical.of("http://example.org/canonical"))
                        .build())
                .addMessaging(CapabilityStatement.Messaging.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addEndpoint(CapabilityStatement.Messaging.Endpoint.builder()
                                .protocol(Coding.builder().build())
                                .address(FhirUrl.of("http://example.org/url"))
                                .build())
                        .reliableCache(FhirUnsignedInt.of(0))
                        .documentation(FhirMarkdown.of("text"))
                        .addSupportedMessage(CapabilityStatement.Messaging.SupportedMessage.builder()
                                .mode(FhirEnum.of(EventCapabilityMode.values()[0]))
                                .definition(FhirCanonical.of("http://example.org/canonical"))
                                .build())
                        .build())
                .addDocument(CapabilityStatement.Document.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .mode(FhirEnum.of(DocumentMode.values()[0]))
                        .documentation(FhirMarkdown.of("text"))
                        .profile(FhirCanonical.of("http://example.org/canonical"))
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
        assertNotNull(resource.kind());
        assertFalse(resource.instantiates().isEmpty());
        assertFalse(resource.imports().isEmpty());
        assertNotNull(resource.software());
        assertNotNull(resource.implementation());
        assertNotNull(resource.fhirVersion());
        assertFalse(resource.format().isEmpty());
        assertFalse(resource.patchFormat().isEmpty());
        assertFalse(resource.acceptLanguage().isEmpty());
        assertFalse(resource.implementationGuide().isEmpty());
        assertFalse(resource.rest().isEmpty());
        assertFalse(resource.messaging().isEmpty());
        assertFalse(resource.document().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("CapabilityStatement.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(ConditionalDeleteStatus.values(), ConditionalDeleteStatus::fromCode);
        assertCodes(ConditionalReadStatus.values(), ConditionalReadStatus::fromCode);
        assertCodes(DocumentMode.values(), DocumentMode::fromCode);
        assertCodes(EventCapabilityMode.values(), EventCapabilityMode::fromCode);
        assertCodes(ReferenceHandlingPolicy.values(), ReferenceHandlingPolicy::fromCode);
        assertCodes(ResourceVersionPolicy.values(), ResourceVersionPolicy::fromCode);
        assertCodes(RestfulCapabilityMode.values(), RestfulCapabilityMode::fromCode);
        assertCodes(SystemRestfulInteraction.values(), SystemRestfulInteraction::fromCode);
        assertCodes(TypeRestfulInteraction.values(), TypeRestfulInteraction::fromCode);
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
