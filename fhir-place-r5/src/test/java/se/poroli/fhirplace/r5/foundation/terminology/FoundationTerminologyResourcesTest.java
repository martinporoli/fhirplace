package se.poroli.fhirplace.r5.foundation.terminology;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
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
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.CapabilityStatementKind;
import se.poroli.fhirplace.r5.valuesets.CodeSearchSupport;
import se.poroli.fhirplace.r5.valuesets.CodeSystemContentMode;
import se.poroli.fhirplace.r5.valuesets.CodeSystemHierarchyMeaning;
import se.poroli.fhirplace.r5.valuesets.ConceptMapAttributeType;
import se.poroli.fhirplace.r5.valuesets.ConceptMapGroupUnmappedMode;
import se.poroli.fhirplace.r5.valuesets.ConceptMapPropertyType;
import se.poroli.fhirplace.r5.valuesets.FilterOperator;
import se.poroli.fhirplace.r5.valuesets.NamingSystemIdentifierType;
import se.poroli.fhirplace.r5.valuesets.NamingSystemType;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PropertyType;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;

/** Builds every foundation.terminology resource with all elements and checks the builders and validation. */
class FoundationTerminologyResourcesTest {

    @Test
    void codeSystem() {
        CodeSystem resource = CodeSystem.builder()
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
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addTopic(CodeableConcept.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .caseSensitive(FhirBoolean.of(true))
                .valueSet(FhirCanonical.of("http://example.org/canonical"))
                .hierarchyMeaning(FhirEnum.of(CodeSystemHierarchyMeaning.values()[0]))
                .compositional(FhirBoolean.of(true))
                .versionNeeded(FhirBoolean.of(true))
                .content(FhirEnum.of(CodeSystemContentMode.values()[0]))
                .supplements(FhirCanonical.of("http://example.org/canonical"))
                .count(FhirUnsignedInt.of(0))
                .addFilter(CodeSystem.Filter.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(FhirCode.of("code"))
                        .description(FhirString.of("text"))
                        .addOperator(FhirEnum.of(FilterOperator.values()[0]))
                        .value(FhirString.of("text"))
                        .build())
                .addProperty(CodeSystem.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(FhirCode.of("code"))
                        .uri(FhirUri.of("http://example.org/uri"))
                        .description(FhirString.of("text"))
                        .type(FhirEnum.of(PropertyType.values()[0]))
                        .build())
                .addConcept(CodeSystem.ConceptDefinition.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(FhirCode.of("code"))
                        .display(FhirString.of("text"))
                        .definition(FhirString.of("text"))
                        .addDesignation(CodeSystem.ConceptDefinition.Designation.builder()
                                .value(FhirString.of("text"))
                                .build())
                        .addProperty(CodeSystem.ConceptDefinition.ConceptProperty.builder()
                                .code(FhirCode.of("code"))
                                .value(FhirCode.of("code"))
                                .build())
                        .addConcept(CodeSystem.ConceptDefinition.builder()
                                .code(FhirCode.of("code"))
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
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.topic().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertNotNull(resource.caseSensitive());
        assertNotNull(resource.valueSet());
        assertNotNull(resource.hierarchyMeaning());
        assertNotNull(resource.compositional());
        assertNotNull(resource.versionNeeded());
        assertNotNull(resource.content());
        assertNotNull(resource.supplements());
        assertNotNull(resource.count());
        assertFalse(resource.filter().isEmpty());
        assertFalse(resource.property().isEmpty());
        assertFalse(resource.concept().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("CodeSystem.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void valueSet() {
        ValueSet resource = ValueSet.builder()
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
                .immutable(FhirBoolean.of(true))
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addTopic(CodeableConcept.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .compose(ValueSet.Compose.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .lockedDate(FhirDate.parse("2024-01-01"))
                        .inactive(FhirBoolean.of(true))
                        .addInclude(ValueSet.Compose.ConceptSet.builder().build())
                        .addExclude(ValueSet.Compose.ConceptSet.builder().build())
                        .addProperty(FhirString.of("text"))
                        .build())
                .expansion(ValueSet.Expansion.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .identifier(FhirUri.of("http://example.org/uri"))
                        .next(FhirUri.of("http://example.org/uri"))
                        .timestamp(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .total(FhirInteger.of(1))
                        .offset(FhirInteger.of(1))
                        .addParameter(ValueSet.Expansion.Parameter.builder()
                                .name(FhirString.of("text"))
                                .build())
                        .addProperty(ValueSet.Expansion.Property.builder()
                                .code(FhirCode.of("code"))
                                .build())
                        .addContains(ValueSet.Expansion.Contains.builder().build())
                        .build())
                .scope(ValueSet.Scope.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .inclusionCriteria(FhirString.of("text"))
                        .exclusionCriteria(FhirString.of("text"))
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
        assertNotNull(resource.immutable());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.topic().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertNotNull(resource.compose());
        assertNotNull(resource.expansion());
        assertNotNull(resource.scope());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ValueSet.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void conceptMap() {
        ConceptMap resource = ConceptMap.builder()
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
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addTopic(CodeableConcept.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .addProperty(ConceptMap.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(FhirCode.of("code"))
                        .uri(FhirUri.of("http://example.org/uri"))
                        .description(FhirString.of("text"))
                        .type(FhirEnum.of(ConceptMapPropertyType.values()[0]))
                        .system(FhirCanonical.of("http://example.org/canonical"))
                        .build())
                .addAdditionalAttribute(ConceptMap.AdditionalAttribute.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(FhirCode.of("code"))
                        .uri(FhirUri.of("http://example.org/uri"))
                        .description(FhirString.of("text"))
                        .type(FhirEnum.of(ConceptMapAttributeType.values()[0]))
                        .build())
                .sourceScope(FhirUri.of("http://example.org/uri"))
                .targetScope(FhirUri.of("http://example.org/uri"))
                .addGroup(ConceptMap.Group.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .source(FhirCanonical.of("http://example.org/canonical"))
                        .target(FhirCanonical.of("http://example.org/canonical"))
                        .addElement(ConceptMap.Group.SourceElement.builder().build())
                        .unmapped(ConceptMap.Group.Unmapped.builder()
                                .mode(FhirEnum.of(ConceptMapGroupUnmappedMode.values()[0]))
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
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.topic().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertFalse(resource.property().isEmpty());
        assertFalse(resource.additionalAttribute().isEmpty());
        assertNotNull(resource.sourceScope());
        assertNotNull(resource.targetScope());
        assertFalse(resource.group().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ConceptMap.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void namingSystem() {
        NamingSystem resource = NamingSystem.builder()
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
                .kind(FhirEnum.of(NamingSystemType.values()[0]))
                .experimental(FhirBoolean.of(true))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .responsible(FhirString.of("text"))
                .type(CodeableConcept.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addTopic(CodeableConcept.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .usage(FhirString.of("text"))
                .addUniqueId(NamingSystem.UniqueId.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(FhirEnum.of(NamingSystemIdentifierType.values()[0]))
                        .value(FhirString.of("text"))
                        .preferred(FhirBoolean.of(true))
                        .comment(FhirString.of("text"))
                        .period(Period.builder().build())
                        .authoritative(FhirBoolean.of(true))
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
        assertNotNull(resource.responsible());
        assertNotNull(resource.type());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.topic().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertNotNull(resource.usage());
        assertFalse(resource.uniqueId().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("NamingSystem.name is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().name((FhirString) null).build()).getMessage());
    }

    @Test
    void terminologyCapabilities() {
        TerminologyCapabilities resource = TerminologyCapabilities.builder()
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
                .software(TerminologyCapabilities.Software.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .version(FhirString.of("text"))
                        .build())
                .implementation(TerminologyCapabilities.Implementation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirString.of("text"))
                        .url(FhirUrl.of("http://example.org/url"))
                        .build())
                .lockedDate(FhirBoolean.of(true))
                .addCodeSystem(TerminologyCapabilities.CodeSystem.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .uri(FhirCanonical.of("http://example.org/canonical"))
                        .addVersion(TerminologyCapabilities.CodeSystem.Version.builder().build())
                        .content(FhirEnum.of(CodeSystemContentMode.values()[0]))
                        .subsumption(FhirBoolean.of(true))
                        .build())
                .expansion(TerminologyCapabilities.Expansion.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .hierarchical(FhirBoolean.of(true))
                        .paging(FhirBoolean.of(true))
                        .incomplete(FhirBoolean.of(true))
                        .addParameter(TerminologyCapabilities.Expansion.Parameter.builder()
                                .name(FhirCode.of("code"))
                                .build())
                        .textFilter(FhirMarkdown.of("text"))
                        .build())
                .codeSearch(FhirEnum.of(CodeSearchSupport.values()[0]))
                .validateCode(TerminologyCapabilities.ValidateCode.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .translations(FhirBoolean.of(true))
                        .build())
                .translation(TerminologyCapabilities.Translation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .needsMap(FhirBoolean.of(true))
                        .build())
                .closure(TerminologyCapabilities.Closure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .translation(FhirBoolean.of(true))
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
        assertNotNull(resource.software());
        assertNotNull(resource.implementation());
        assertNotNull(resource.lockedDate());
        assertFalse(resource.codeSystem().isEmpty());
        assertNotNull(resource.expansion());
        assertNotNull(resource.codeSearch());
        assertNotNull(resource.validateCode());
        assertNotNull(resource.translation());
        assertNotNull(resource.closure());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("TerminologyCapabilities.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }
}
