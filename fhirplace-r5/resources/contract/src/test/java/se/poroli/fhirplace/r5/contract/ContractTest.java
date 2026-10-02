package se.poroli.fhirplace.r5.contract;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a Contract with all elements and checks the builder and validation. */
class ContractTest {

    @Test
    void contract() {
        Contract resource = Contract.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .version(FhirString.of("text"))
                .status(FhirEnum.of(ContractResourceStatusCodes.values()[0]))
                .legalState(CodeableConcept.builder().build())
                .instantiatesCanonical(Reference.builder().build())
                .instantiatesUri(FhirUri.of("http://example.org/uri"))
                .contentDerivative(CodeableConcept.builder().build())
                .issued(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .applies(Period.builder().build())
                .expirationType(CodeableConcept.builder().build())
                .addSubject(Reference.builder().build())
                .addAuthority(Reference.builder().build())
                .addDomain(Reference.builder().build())
                .addSite(Reference.builder().build())
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .subtitle(FhirString.of("text"))
                .addAlias(FhirString.of("text"))
                .author(Reference.builder().build())
                .scope(CodeableConcept.builder().build())
                .topic(CodeableConcept.builder().build())
                .type(CodeableConcept.builder().build())
                .addSubType(CodeableConcept.builder().build())
                .contentDefinition(Contract.ContentDefinition.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .subType(CodeableConcept.builder().build())
                        .publisher(Reference.builder().build())
                        .publicationDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .publicationStatus(FhirEnum.of(ContractResourcePublicationStatusCodes.values()[0]))
                        .copyright(FhirMarkdown.of("text"))
                        .build())
                .addTerm(Contract.Term.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .identifier(Identifier.builder().build())
                        .issued(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .applies(Period.builder().build())
                        .topic(CodeableConcept.builder().build())
                        .type(CodeableConcept.builder().build())
                        .subType(CodeableConcept.builder().build())
                        .text(FhirString.of("text"))
                        .addSecurityLabel(Contract.Term.SecurityLabel.builder()
                                .classification(Coding.builder().build())
                                .build())
                        .offer(Contract.Term.ContractOffer.builder().build())
                        .addAsset(Contract.Term.ContractAsset.builder().build())
                        .addAction(Contract.Term.Action.builder()
                                .type(CodeableConcept.builder().build())
                                .intent(CodeableConcept.builder().build())
                                .status(CodeableConcept.builder().build())
                                .build())
                        .addGroup(Contract.Term.builder()
                                .offer(Contract.Term.ContractOffer.builder().build())
                                .build())
                        .build())
                .addSupportingInfo(Reference.builder().build())
                .addRelevantHistory(Reference.builder().build())
                .addSigner(Contract.Signatory.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(Coding.builder().build())
                        .party(Reference.builder().build())
                        .addSignature(Signature.builder().build())
                        .build())
                .addFriendly(Contract.FriendlyLanguage.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .content(Attachment.builder().build())
                        .build())
                .addLegal(Contract.LegalLanguage.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .content(Attachment.builder().build())
                        .build())
                .addRule(Contract.ComputableLanguage.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .content(Attachment.builder().build())
                        .build())
                .legallyBinding(Attachment.builder().build())
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
        assertNotNull(resource.url());
        assertNotNull(resource.version());
        assertNotNull(resource.status());
        assertNotNull(resource.legalState());
        assertNotNull(resource.instantiatesCanonical());
        assertNotNull(resource.instantiatesUri());
        assertNotNull(resource.contentDerivative());
        assertNotNull(resource.issued());
        assertNotNull(resource.applies());
        assertNotNull(resource.expirationType());
        assertFalse(resource.subject().isEmpty());
        assertFalse(resource.authority().isEmpty());
        assertFalse(resource.domain().isEmpty());
        assertFalse(resource.site().isEmpty());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.subtitle());
        assertFalse(resource.alias().isEmpty());
        assertNotNull(resource.author());
        assertNotNull(resource.scope());
        assertNotNull(resource.topic());
        assertNotNull(resource.type());
        assertFalse(resource.subType().isEmpty());
        assertNotNull(resource.contentDefinition());
        assertFalse(resource.term().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.relevantHistory().isEmpty());
        assertFalse(resource.signer().isEmpty());
        assertFalse(resource.friendly().isEmpty());
        assertFalse(resource.legal().isEmpty());
        assertFalse(resource.rule().isEmpty());
        assertNotNull(resource.legallyBinding());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(ContractResourcePublicationStatusCodes.values(), ContractResourcePublicationStatusCodes::fromCode);
        assertCodes(ContractResourceStatusCodes.values(), ContractResourceStatusCodes::fromCode);
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
