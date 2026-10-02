package se.poroli.fhirplace.r5.foundation.conformance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.ElementDefinition;
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
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.BindingStrength;
import se.poroli.fhirplace.r5.valuesets.CapabilityStatementKind;
import se.poroli.fhirplace.r5.valuesets.CompartmentType;
import se.poroli.fhirplace.r5.valuesets.DocumentMode;
import se.poroli.fhirplace.r5.valuesets.EventCapabilityMode;
import se.poroli.fhirplace.r5.valuesets.ExtensionContextType;
import se.poroli.fhirplace.r5.valuesets.FHIRTypes;
import se.poroli.fhirplace.r5.valuesets.FHIRVersion;
import se.poroli.fhirplace.r5.valuesets.GraphCompartmentRule;
import se.poroli.fhirplace.r5.valuesets.GraphCompartmentUse;
import se.poroli.fhirplace.r5.valuesets.GuidePageGeneration;
import se.poroli.fhirplace.r5.valuesets.MessageSignificanceCategory;
import se.poroli.fhirplace.r5.valuesets.MessageheaderResponseRequest;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.OperationKind;
import se.poroli.fhirplace.r5.valuesets.OperationParameterScope;
import se.poroli.fhirplace.r5.valuesets.OperationParameterUse;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.ResourceType;
import se.poroli.fhirplace.r5.valuesets.RestfulCapabilityMode;
import se.poroli.fhirplace.r5.valuesets.SPDXLicense;
import se.poroli.fhirplace.r5.valuesets.SearchComparator;
import se.poroli.fhirplace.r5.valuesets.SearchModifierCode;
import se.poroli.fhirplace.r5.valuesets.SearchParamType;
import se.poroli.fhirplace.r5.valuesets.SearchProcessingModeType;
import se.poroli.fhirplace.r5.valuesets.StructureDefinitionKind;
import se.poroli.fhirplace.r5.valuesets.StructureMapGroupTypeMode;
import se.poroli.fhirplace.r5.valuesets.StructureMapInputMode;
import se.poroli.fhirplace.r5.valuesets.StructureMapModelMode;
import se.poroli.fhirplace.r5.valuesets.SystemRestfulInteraction;
import se.poroli.fhirplace.r5.valuesets.TypeDerivationRule;

/** Builds every foundation.conformance resource with all elements and checks the builders and validation. */
class FoundationConformanceResourcesTest {

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
    void structureDefinition() {
        StructureDefinition resource = StructureDefinition.builder()
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
                .addKeyword(Coding.builder().build())
                .fhirVersion(FhirEnum.of(FHIRVersion.values()[0]))
                .addMapping(StructureDefinition.Mapping.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .identity(FhirId.of("id1"))
                        .uri(FhirUri.of("http://example.org/uri"))
                        .name(FhirString.of("text"))
                        .comment(FhirString.of("text"))
                        .build())
                .kind(FhirEnum.of(StructureDefinitionKind.values()[0]))
                .abstractValue(FhirBoolean.of(true))
                .addContext(StructureDefinition.Context.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(FhirEnum.of(ExtensionContextType.values()[0]))
                        .expression(FhirString.of("text"))
                        .build())
                .addContextInvariant(FhirString.of("text"))
                .type(FhirUri.of("http://example.org/uri"))
                .baseDefinition(FhirCanonical.of("http://example.org/canonical"))
                .derivation(FhirEnum.of(TypeDerivationRule.values()[0]))
                .snapshot(StructureDefinition.Snapshot.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addElement(ElementDefinition.builder().path(FhirString.of("text")).build())
                        .build())
                .differential(StructureDefinition.Differential.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addElement(ElementDefinition.builder().path(FhirString.of("text")).build())
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
        assertFalse(resource.keyword().isEmpty());
        assertNotNull(resource.fhirVersion());
        assertFalse(resource.mapping().isEmpty());
        assertNotNull(resource.kind());
        assertNotNull(resource.abstractValue());
        assertFalse(resource.context().isEmpty());
        assertFalse(resource.contextInvariant().isEmpty());
        assertNotNull(resource.type());
        assertNotNull(resource.baseDefinition());
        assertNotNull(resource.derivation());
        assertNotNull(resource.snapshot());
        assertNotNull(resource.differential());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("StructureDefinition.url is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().url((FhirUri) null).build()).getMessage());
    }

    @Test
    void implementationGuide() {
        ImplementationGuide resource = ImplementationGuide.builder()
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
                .packageId(FhirId.of("id1"))
                .license(FhirEnum.of(SPDXLicense.values()[0]))
                .addFhirVersion(FhirEnum.of(FHIRVersion.values()[0]))
                .addDependsOn(ImplementationGuide.DependsOn.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .uri(FhirCanonical.of("http://example.org/canonical"))
                        .packageId(FhirId.of("id1"))
                        .version(FhirString.of("text"))
                        .reason(FhirMarkdown.of("text"))
                        .build())
                .addGlobal(ImplementationGuide.Global.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(FhirEnum.of(ResourceType.values()[0]))
                        .profile(FhirCanonical.of("http://example.org/canonical"))
                        .build())
                .definition(ImplementationGuide.Definition.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addGrouping(ImplementationGuide.Definition.Grouping.builder()
                                .name(FhirString.of("text"))
                                .build())
                        .addResource(ImplementationGuide.Definition.DefinitionResource.builder()
                                .reference(Reference.builder().build())
                                .build())
                        .page(ImplementationGuide.Definition.Page.builder()
                                .name(FhirUrl.of("http://example.org/url"))
                                .title(FhirString.of("text"))
                                .generation(FhirEnum.of(GuidePageGeneration.values()[0]))
                                .build())
                        .addParameter(ImplementationGuide.Definition.Parameter.builder()
                                .code(Coding.builder().build())
                                .value(FhirString.of("text"))
                                .build())
                        .addTemplate(ImplementationGuide.Definition.Template.builder()
                                .code(FhirCode.of("code"))
                                .source(FhirString.of("text"))
                                .build())
                        .build())
                .manifest(ImplementationGuide.Manifest.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .rendering(FhirUrl.of("http://example.org/url"))
                        .addResource(ImplementationGuide.Manifest.ManifestResource.builder()
                                .reference(Reference.builder().build())
                                .build())
                        .addPage(ImplementationGuide.Manifest.ManifestPage.builder()
                                .name(FhirString.of("text"))
                                .build())
                        .addImage(FhirString.of("text"))
                        .addOther(FhirString.of("text"))
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
        assertNotNull(resource.packageId());
        assertNotNull(resource.license());
        assertFalse(resource.fhirVersion().isEmpty());
        assertFalse(resource.dependsOn().isEmpty());
        assertFalse(resource.global().isEmpty());
        assertNotNull(resource.definition());
        assertNotNull(resource.manifest());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ImplementationGuide.url is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().url((FhirUri) null).build()).getMessage());
    }

    @Test
    void searchParameter() {
        SearchParameter resource = SearchParameter.builder()
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
                .derivedFrom(FhirCanonical.of("http://example.org/canonical"))
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
                .code(FhirCode.of("code"))
                .addBase(FhirCode.of("code"))
                .type(FhirEnum.of(SearchParamType.values()[0]))
                .expression(FhirString.of("text"))
                .processingMode(FhirEnum.of(SearchProcessingModeType.values()[0]))
                .constraint(FhirString.of("text"))
                .addTarget(FhirCode.of("code"))
                .multipleOr(FhirBoolean.of(true))
                .multipleAnd(FhirBoolean.of(true))
                .addComparator(FhirEnum.of(SearchComparator.values()[0]))
                .addModifier(FhirEnum.of(SearchModifierCode.values()[0]))
                .addChain(FhirString.of("text"))
                .addComponent(SearchParameter.Component.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .definition(FhirCanonical.of("http://example.org/canonical"))
                        .expression(FhirString.of("text"))
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
        assertNotNull(resource.derivedFrom());
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
        assertNotNull(resource.code());
        assertFalse(resource.base().isEmpty());
        assertNotNull(resource.type());
        assertNotNull(resource.expression());
        assertNotNull(resource.processingMode());
        assertNotNull(resource.constraint());
        assertFalse(resource.target().isEmpty());
        assertNotNull(resource.multipleOr());
        assertNotNull(resource.multipleAnd());
        assertFalse(resource.comparator().isEmpty());
        assertFalse(resource.modifier().isEmpty());
        assertFalse(resource.chain().isEmpty());
        assertFalse(resource.component().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("SearchParameter.url is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().url((FhirUri) null).build()).getMessage());
    }

    @Test
    void messageDefinition() {
        MessageDefinition resource = MessageDefinition.builder()
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
                .addReplaces(FhirCanonical.of("http://example.org/canonical"))
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
                .base(FhirCanonical.of("http://example.org/canonical"))
                .addParent(FhirCanonical.of("http://example.org/canonical"))
                .event(Coding.builder().build())
                .category(FhirEnum.of(MessageSignificanceCategory.values()[0]))
                .addFocus(MessageDefinition.Focus.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(FhirEnum.of(ResourceType.values()[0]))
                        .profile(FhirCanonical.of("http://example.org/canonical"))
                        .min(FhirUnsignedInt.of(0))
                        .max(FhirString.of("text"))
                        .build())
                .responseRequired(FhirEnum.of(MessageheaderResponseRequest.values()[0]))
                .addAllowedResponse(MessageDefinition.AllowedResponse.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .message(FhirCanonical.of("http://example.org/canonical"))
                        .situation(FhirMarkdown.of("text"))
                        .build())
                .graph(FhirCanonical.of("http://example.org/canonical"))
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
        assertFalse(resource.replaces().isEmpty());
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
        assertNotNull(resource.base());
        assertFalse(resource.parent().isEmpty());
        assertNotNull(resource.event());
        assertNotNull(resource.category());
        assertFalse(resource.focus().isEmpty());
        assertNotNull(resource.responseRequired());
        assertFalse(resource.allowedResponse().isEmpty());
        assertNotNull(resource.graph());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("MessageDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

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
    void compartmentDefinition() {
        CompartmentDefinition resource = CompartmentDefinition.builder()
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
                .purpose(FhirMarkdown.of("text"))
                .code(FhirEnum.of(CompartmentType.values()[0]))
                .search(FhirBoolean.of(true))
                .addResource(CompartmentDefinition.CompartmentDefinitionResource.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(FhirEnum.of(ResourceType.values()[0]))
                        .addParam(FhirString.of("text"))
                        .documentation(FhirString.of("text"))
                        .startParam(FhirUri.of("http://example.org/uri"))
                        .endParam(FhirUri.of("http://example.org/uri"))
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
        assertNotNull(resource.purpose());
        assertNotNull(resource.code());
        assertNotNull(resource.search());
        assertFalse(resource.resource().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("CompartmentDefinition.url is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().url((FhirUri) null).build()).getMessage());
    }

    @Test
    void structureMap() {
        StructureMap resource = StructureMap.builder()
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
                .addStructure(StructureMap.Structure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .url(FhirCanonical.of("http://example.org/canonical"))
                        .mode(FhirEnum.of(StructureMapModelMode.values()[0]))
                        .alias(FhirString.of("text"))
                        .documentation(FhirString.of("text"))
                        .build())
                .addImportValue(FhirCanonical.of("http://example.org/canonical"))
                .addConstValue(StructureMap.ConstValue.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirId.of("id1"))
                        .value(FhirString.of("text"))
                        .build())
                .addGroup(StructureMap.Group.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirId.of("id1"))
                        .extendsValue(FhirId.of("id1"))
                        .typeMode(FhirEnum.of(StructureMapGroupTypeMode.values()[0]))
                        .documentation(FhirString.of("text"))
                        .addInput(StructureMap.Group.Input.builder()
                                .name(FhirId.of("id1"))
                                .mode(FhirEnum.of(StructureMapInputMode.values()[0]))
                                .build())
                        .addRule(StructureMap.Group.Rule.builder()
                                .addSource(StructureMap.Group.Rule.Source.builder()
                                        .context(FhirId.of("id1"))
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
        assertFalse(resource.structure().isEmpty());
        assertFalse(resource.importValue().isEmpty());
        assertFalse(resource.constValue().isEmpty());
        assertFalse(resource.group().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("StructureMap.url is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().url((FhirUri) null).build()).getMessage());
    }

    @Test
    void graphDefinition() {
        GraphDefinition resource = GraphDefinition.builder()
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
                .start(FhirId.of("id1"))
                .addNode(GraphDefinition.Node.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .nodeId(FhirId.of("id1"))
                        .description(FhirString.of("text"))
                        .type(FhirCode.of("code"))
                        .profile(FhirCanonical.of("http://example.org/canonical"))
                        .build())
                .addLink(GraphDefinition.Link.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirString.of("text"))
                        .min(FhirInteger.of(1))
                        .max(FhirString.of("text"))
                        .sourceId(FhirId.of("id1"))
                        .path(FhirString.of("text"))
                        .sliceName(FhirString.of("text"))
                        .targetId(FhirId.of("id1"))
                        .params(FhirString.of("text"))
                        .addCompartment(GraphDefinition.Link.Compartment.builder()
                                .use(FhirEnum.of(GraphCompartmentUse.values()[0]))
                                .rule(FhirEnum.of(GraphCompartmentRule.values()[0]))
                                .code(FhirEnum.of(CompartmentType.values()[0]))
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
        assertNotNull(resource.start());
        assertFalse(resource.node().isEmpty());
        assertFalse(resource.link().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("GraphDefinition.name is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().name((FhirString) null).build()).getMessage());
    }
}
