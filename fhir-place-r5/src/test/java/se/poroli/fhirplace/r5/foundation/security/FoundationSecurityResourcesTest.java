package se.poroli.fhirplace.r5.foundation.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.valuesets.AuditEventAction;
import se.poroli.fhirplace.r5.valuesets.AuditEventSeverity;
import se.poroli.fhirplace.r5.valuesets.ConsentDataMeaning;
import se.poroli.fhirplace.r5.valuesets.ConsentProvisionType;
import se.poroli.fhirplace.r5.valuesets.ConsentState;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PermissionRuleCombining;
import se.poroli.fhirplace.r5.valuesets.PermissionStatus;
import se.poroli.fhirplace.r5.valuesets.ProvenanceEntityRole;

/** Builds every foundation.security resource with all elements and checks the builders and validation. */
class FoundationSecurityResourcesTest {

    @Test
    void provenance() {
        Provenance resource = Provenance.builder()
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
                .addTarget(Reference.builder().build())
                .occurred(Period.builder().build())
                .recorded(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .addPolicy(FhirUri.of("http://example.org/uri"))
                .location(Reference.builder().build())
                .addAuthorization(CodeableReference.builder().build())
                .activity(CodeableConcept.builder().build())
                .addBasedOn(Reference.builder().build())
                .patient(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addAgent(Provenance.Agent.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .addRole(CodeableConcept.builder().build())
                        .who(Reference.builder().build())
                        .onBehalfOf(Reference.builder().build())
                        .build())
                .addEntity(Provenance.Entity.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .role(FhirEnum.of(ProvenanceEntityRole.values()[0]))
                        .what(Reference.builder().build())
                        .addAgent(Provenance.Agent.builder().who(Reference.builder().build()).build())
                        .build())
                .addSignature(Signature.builder().build())
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.text());
        assertFalse(resource.contained().isEmpty());
        assertFalse(resource.extension().isEmpty());
        assertFalse(resource.modifierExtension().isEmpty());
        assertFalse(resource.target().isEmpty());
        assertNotNull(resource.occurred());
        assertNotNull(resource.recorded());
        assertFalse(resource.policy().isEmpty());
        assertNotNull(resource.location());
        assertFalse(resource.authorization().isEmpty());
        assertNotNull(resource.activity());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.patient());
        assertNotNull(resource.encounter());
        assertFalse(resource.agent().isEmpty());
        assertFalse(resource.entity().isEmpty());
        assertFalse(resource.signature().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Provenance.target requires at least one value", assertThrows(
                IllegalArgumentException.class,
                () -> resource.toBuilder().target((java.util.List<Reference>) null).build()).getMessage());
    }

    @Test
    void auditEvent() {
        AuditEvent resource = AuditEvent.builder()
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
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .action(FhirEnum.of(AuditEventAction.values()[0]))
                .severity(FhirEnum.of(AuditEventSeverity.values()[0]))
                .occurred(Period.builder().build())
                .recorded(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .outcome(AuditEvent.Outcome.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(Coding.builder().build())
                        .addDetail(CodeableConcept.builder().build())
                        .build())
                .addAuthorization(CodeableConcept.builder().build())
                .addBasedOn(Reference.builder().build())
                .patient(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addAgent(AuditEvent.Agent.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .addRole(CodeableConcept.builder().build())
                        .who(Reference.builder().build())
                        .requestor(FhirBoolean.of(true))
                        .location(Reference.builder().build())
                        .addPolicy(FhirUri.of("http://example.org/uri"))
                        .network(Reference.builder().build())
                        .addAuthorization(CodeableConcept.builder().build())
                        .build())
                .source(AuditEvent.Source.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .site(Reference.builder().build())
                        .observer(Reference.builder().build())
                        .addType(CodeableConcept.builder().build())
                        .build())
                .addEntity(AuditEvent.Entity.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .what(Reference.builder().build())
                        .role(CodeableConcept.builder().build())
                        .addSecurityLabel(CodeableConcept.builder().build())
                        .query(FhirBase64Binary.of("aGk="))
                        .addDetail(AuditEvent.Entity.Detail.builder()
                                .type(CodeableConcept.builder().build())
                                .value(Quantity.builder().build())
                                .build())
                        .addAgent(AuditEvent.Agent.builder().who(Reference.builder().build()).build())
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
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.action());
        assertNotNull(resource.severity());
        assertNotNull(resource.occurred());
        assertNotNull(resource.recorded());
        assertNotNull(resource.outcome());
        assertFalse(resource.authorization().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.patient());
        assertNotNull(resource.encounter());
        assertFalse(resource.agent().isEmpty());
        assertNotNull(resource.source());
        assertFalse(resource.entity().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("AuditEvent.code is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().code((CodeableConcept) null).build()).getMessage());
    }

    @Test
    void permission() {
        Permission resource = Permission.builder()
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
                .status(FhirEnum.of(PermissionStatus.values()[0]))
                .asserter(Reference.builder().build())
                .addDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .validity(Period.builder().build())
                .justification(Permission.Justification.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addBasis(CodeableConcept.builder().build())
                        .addEvidence(Reference.builder().build())
                        .build())
                .combining(FhirEnum.of(PermissionRuleCombining.values()[0]))
                .addRule(Permission.Rule.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(FhirEnum.of(ConsentProvisionType.values()[0]))
                        .addData(Permission.Rule.Data.builder().build())
                        .addActivity(Permission.Rule.Activity.builder().build())
                        .addLimit(CodeableConcept.builder().build())
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
        assertNotNull(resource.status());
        assertNotNull(resource.asserter());
        assertFalse(resource.date().isEmpty());
        assertNotNull(resource.validity());
        assertNotNull(resource.justification());
        assertNotNull(resource.combining());
        assertFalse(resource.rule().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Permission.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PermissionStatus>) null).build()).getMessage());
    }

    @Test
    void consent() {
        Consent resource = Consent.builder()
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
                .addIdentifier(Identifier.builder().build())
                .status(FhirEnum.of(ConsentState.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .date(FhirDate.parse("2024-01-01"))
                .period(Period.builder().build())
                .addGrantor(Reference.builder().build())
                .addGrantee(Reference.builder().build())
                .addManager(Reference.builder().build())
                .addController(Reference.builder().build())
                .addSourceAttachment(Attachment.builder().build())
                .addSourceReference(Reference.builder().build())
                .addRegulatoryBasis(CodeableConcept.builder().build())
                .policyBasis(Consent.PolicyBasis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .reference(Reference.builder().build())
                        .url(FhirUrl.of("http://example.org/url"))
                        .build())
                .addPolicyText(Reference.builder().build())
                .addVerification(Consent.Verification.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .verified(FhirBoolean.of(true))
                        .verificationType(CodeableConcept.builder().build())
                        .verifiedBy(Reference.builder().build())
                        .verifiedWith(Reference.builder().build())
                        .addVerificationDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .decision(FhirEnum.of(ConsentProvisionType.values()[0]))
                .addProvision(Consent.provision.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .period(Period.builder().build())
                        .addActor(Consent.provision.provisionActor.builder().build())
                        .addAction(CodeableConcept.builder().build())
                        .addSecurityLabel(Coding.builder().build())
                        .addPurpose(Coding.builder().build())
                        .addDocumentType(Coding.builder().build())
                        .addResourceType(Coding.builder().build())
                        .addCode(CodeableConcept.builder().build())
                        .dataPeriod(Period.builder().build())
                        .addData(Consent.provision.provisionData.builder()
                                .meaning(FhirEnum.of(ConsentDataMeaning.values()[0]))
                                .reference(Reference.builder().build())
                                .build())
                        .expression(Expression.builder().build())
                        .addProvision(Consent.provision.builder().build())
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
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.date());
        assertNotNull(resource.period());
        assertFalse(resource.grantor().isEmpty());
        assertFalse(resource.grantee().isEmpty());
        assertFalse(resource.manager().isEmpty());
        assertFalse(resource.controller().isEmpty());
        assertFalse(resource.sourceAttachment().isEmpty());
        assertFalse(resource.sourceReference().isEmpty());
        assertFalse(resource.regulatoryBasis().isEmpty());
        assertNotNull(resource.policyBasis());
        assertFalse(resource.policyText().isEmpty());
        assertFalse(resource.verification().isEmpty());
        assertNotNull(resource.decision());
        assertFalse(resource.provision().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Consent.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ConsentState>) null).build()).getMessage());
    }
}
