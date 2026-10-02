package se.poroli.fhirplace.r5.financial.general;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.AccountStatus;
import se.poroli.fhirplace.r5.valuesets.ChargeItemStatus;
import se.poroli.fhirplace.r5.valuesets.ClaimProcessingCodes;
import se.poroli.fhirplace.r5.valuesets.ContractResourcePublicationStatusCodes;
import se.poroli.fhirplace.r5.valuesets.ContractResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.ExplanationOfBenefitStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PriceComponentType;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;
import se.poroli.fhirplace.r5.valuesets.Use;

/** Builds every financial.general resource with all elements and checks the builders and validation. */
class FinancialGeneralResourcesTest {

    @Test
    void account() {
        Account resource = Account.builder()
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
                .status(FhirEnum.of(AccountStatus.values()[0]))
                .billingStatus(CodeableConcept.builder().build())
                .type(CodeableConcept.builder().build())
                .name(FhirString.of("text"))
                .addSubject(Reference.builder().build())
                .servicePeriod(Period.builder().build())
                .addCoverage(Account.Coverage.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .coverage(Reference.builder().build())
                        .priority(FhirPositiveInt.of(1))
                        .build())
                .owner(Reference.builder().build())
                .description(FhirMarkdown.of("text"))
                .addGuarantor(Account.Guarantor.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .party(Reference.builder().build())
                        .onHold(FhirBoolean.of(true))
                        .period(Period.builder().build())
                        .build())
                .addDiagnosis(Account.Diagnosis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .condition(CodeableReference.builder().build())
                        .dateOfDiagnosis(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .addType(CodeableConcept.builder().build())
                        .onAdmission(FhirBoolean.of(true))
                        .addPackageCode(CodeableConcept.builder().build())
                        .build())
                .addProcedure(Account.Procedure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .code(CodeableReference.builder().build())
                        .dateOfService(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .addType(CodeableConcept.builder().build())
                        .addPackageCode(CodeableConcept.builder().build())
                        .addDevice(Reference.builder().build())
                        .build())
                .addRelatedAccount(Account.RelatedAccount.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .relationship(CodeableConcept.builder().build())
                        .account(Reference.builder().build())
                        .build())
                .currency(CodeableConcept.builder().build())
                .addBalance(Account.Balance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .aggregate(CodeableConcept.builder().build())
                        .term(CodeableConcept.builder().build())
                        .estimate(FhirBoolean.of(true))
                        .amount(Money.builder().build())
                        .build())
                .calculatedAt(FhirInstant.parse("2024-01-01T00:00:00Z"))
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
        assertNotNull(resource.billingStatus());
        assertNotNull(resource.type());
        assertNotNull(resource.name());
        assertFalse(resource.subject().isEmpty());
        assertNotNull(resource.servicePeriod());
        assertFalse(resource.coverage().isEmpty());
        assertNotNull(resource.owner());
        assertNotNull(resource.description());
        assertFalse(resource.guarantor().isEmpty());
        assertFalse(resource.diagnosis().isEmpty());
        assertFalse(resource.procedure().isEmpty());
        assertFalse(resource.relatedAccount().isEmpty());
        assertNotNull(resource.currency());
        assertFalse(resource.balance().isEmpty());
        assertNotNull(resource.calculatedAt());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Account.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<AccountStatus>) null).build()).getMessage());
    }

    @Test
    void chargeItem() {
        ChargeItem resource = ChargeItem.builder()
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
                .addDefinitionUri(FhirUri.of("http://example.org/uri"))
                .addDefinitionCanonical(FhirCanonical.of("http://example.org/canonical"))
                .status(FhirEnum.of(ChargeItemStatus.values()[0]))
                .addPartOf(Reference.builder().build())
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addPerformer(ChargeItem.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .performingOrganization(Reference.builder().build())
                .requestingOrganization(Reference.builder().build())
                .costCenter(Reference.builder().build())
                .quantity(Quantity.builder().build())
                .addBodysite(CodeableConcept.builder().build())
                .unitPriceComponent(MonetaryComponent.builder()
                        .type(FhirEnum.of(PriceComponentType.values()[0]))
                        .build())
                .totalPriceComponent(MonetaryComponent.builder()
                        .type(FhirEnum.of(PriceComponentType.values()[0]))
                        .build())
                .overrideReason(CodeableConcept.builder().build())
                .enterer(Reference.builder().build())
                .enteredDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addReason(CodeableConcept.builder().build())
                .addService(CodeableReference.builder().build())
                .addProduct(CodeableReference.builder().build())
                .addAccount(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addSupportingInformation(Reference.builder().build())
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
        assertFalse(resource.definitionUri().isEmpty());
        assertFalse(resource.definitionCanonical().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.occurrence());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.performingOrganization());
        assertNotNull(resource.requestingOrganization());
        assertNotNull(resource.costCenter());
        assertNotNull(resource.quantity());
        assertFalse(resource.bodysite().isEmpty());
        assertNotNull(resource.unitPriceComponent());
        assertNotNull(resource.totalPriceComponent());
        assertNotNull(resource.overrideReason());
        assertNotNull(resource.enterer());
        assertNotNull(resource.enteredDate());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.service().isEmpty());
        assertFalse(resource.product().isEmpty());
        assertFalse(resource.account().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.supportingInformation().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ChargeItem.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ChargeItemStatus>) null).build()).getMessage());
    }

    @Test
    void chargeItemDefinition() {
        ChargeItemDefinition resource = ChargeItemDefinition.builder()
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
                .addDerivedFromUri(FhirUri.of("http://example.org/uri"))
                .addPartOf(FhirCanonical.of("http://example.org/canonical"))
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
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .code(CodeableConcept.builder().build())
                .addInstance(Reference.builder().build())
                .addApplicability(ChargeItemDefinition.Applicability.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .condition(Expression.builder().build())
                        .effectivePeriod(Period.builder().build())
                        .relatedArtifact(RelatedArtifact.builder()
                                .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                                .build())
                        .build())
                .addPropertyGroup(ChargeItemDefinition.PropertyGroup.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addApplicability(ChargeItemDefinition.Applicability.builder().build())
                        .addPriceComponent(MonetaryComponent.builder()
                                .type(FhirEnum.of(PriceComponentType.values()[0]))
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
        assertFalse(resource.derivedFromUri().isEmpty());
        assertFalse(resource.partOf().isEmpty());
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
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.code());
        assertFalse(resource.instance().isEmpty());
        assertFalse(resource.applicability().isEmpty());
        assertFalse(resource.propertyGroup().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ChargeItemDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

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
    void explanationOfBenefit() {
        ExplanationOfBenefit resource = ExplanationOfBenefit.builder()
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
                .addTraceNumber(Identifier.builder().build())
                .status(FhirEnum.of(ExplanationOfBenefitStatus.values()[0]))
                .type(CodeableConcept.builder().build())
                .subType(CodeableConcept.builder().build())
                .use(FhirEnum.of(Use.values()[0]))
                .patient(Reference.builder().build())
                .billablePeriod(Period.builder().build())
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .enterer(Reference.builder().build())
                .insurer(Reference.builder().build())
                .provider(Reference.builder().build())
                .priority(CodeableConcept.builder().build())
                .fundsReserveRequested(CodeableConcept.builder().build())
                .fundsReserve(CodeableConcept.builder().build())
                .addRelated(ExplanationOfBenefit.RelatedClaim.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .claim(Reference.builder().build())
                        .relationship(CodeableConcept.builder().build())
                        .reference(Identifier.builder().build())
                        .build())
                .prescription(Reference.builder().build())
                .originalPrescription(Reference.builder().build())
                .addEvent(ExplanationOfBenefit.Event.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .when(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .payee(ExplanationOfBenefit.Payee.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .party(Reference.builder().build())
                        .build())
                .referral(Reference.builder().build())
                .addEncounter(Reference.builder().build())
                .facility(Reference.builder().build())
                .claim(Reference.builder().build())
                .claimResponse(Reference.builder().build())
                .outcome(FhirEnum.of(ClaimProcessingCodes.values()[0]))
                .decision(CodeableConcept.builder().build())
                .disposition(FhirString.of("text"))
                .addPreAuthRef(FhirString.of("text"))
                .addPreAuthRefPeriod(Period.builder().build())
                .diagnosisRelatedGroup(CodeableConcept.builder().build())
                .addCareTeam(ExplanationOfBenefit.CareTeam.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .provider(Reference.builder().build())
                        .responsible(FhirBoolean.of(true))
                        .role(CodeableConcept.builder().build())
                        .specialty(CodeableConcept.builder().build())
                        .build())
                .addSupportingInfo(ExplanationOfBenefit.SupportingInformation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .category(CodeableConcept.builder().build())
                        .code(CodeableConcept.builder().build())
                        .timing(FhirDate.parse("2024-01-01"))
                        .value(FhirBoolean.of(true))
                        .reason(Coding.builder().build())
                        .build())
                .addDiagnosis(ExplanationOfBenefit.Diagnosis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .diagnosis(CodeableConcept.builder().build())
                        .addType(CodeableConcept.builder().build())
                        .onAdmission(CodeableConcept.builder().build())
                        .build())
                .addProcedure(ExplanationOfBenefit.Procedure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .addType(CodeableConcept.builder().build())
                        .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .procedure(CodeableConcept.builder().build())
                        .addUdi(Reference.builder().build())
                        .build())
                .precedence(FhirPositiveInt.of(1))
                .addInsurance(ExplanationOfBenefit.Insurance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .focal(FhirBoolean.of(true))
                        .coverage(Reference.builder().build())
                        .addPreAuthRef(FhirString.of("text"))
                        .build())
                .accident(ExplanationOfBenefit.Accident.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .date(FhirDate.parse("2024-01-01"))
                        .type(CodeableConcept.builder().build())
                        .location(Address.builder().build())
                        .build())
                .patientPaid(Money.builder().build())
                .addItem(ExplanationOfBenefit.Item.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .addCareTeamSequence(FhirPositiveInt.of(1))
                        .addDiagnosisSequence(FhirPositiveInt.of(1))
                        .addProcedureSequence(FhirPositiveInt.of(1))
                        .addInformationSequence(FhirPositiveInt.of(1))
                        .addTraceNumber(Identifier.builder().build())
                        .revenue(CodeableConcept.builder().build())
                        .category(CodeableConcept.builder().build())
                        .productOrService(CodeableConcept.builder().build())
                        .productOrServiceEnd(CodeableConcept.builder().build())
                        .addRequest(Reference.builder().build())
                        .addModifier(CodeableConcept.builder().build())
                        .addProgramCode(CodeableConcept.builder().build())
                        .serviced(FhirDate.parse("2024-01-01"))
                        .location(CodeableConcept.builder().build())
                        .patientPaid(Money.builder().build())
                        .quantity(Quantity.builder().build())
                        .unitPrice(Money.builder().build())
                        .factor(FhirDecimal.parse("1.0"))
                        .tax(Money.builder().build())
                        .net(Money.builder().build())
                        .addUdi(Reference.builder().build())
                        .addBodySite(ExplanationOfBenefit.Item.ItemBodySite.builder()
                                .addSite(CodeableReference.builder().build())
                                .build())
                        .addEncounter(Reference.builder().build())
                        .addNoteNumber(FhirPositiveInt.of(1))
                        .reviewOutcome(ExplanationOfBenefit.Item.ReviewOutcome.builder().build())
                        .addAdjudication(ExplanationOfBenefit.Item.Adjudication.builder()
                                .category(CodeableConcept.builder().build())
                                .build())
                        .addDetail(ExplanationOfBenefit.Item.Detail.builder()
                                .sequence(FhirPositiveInt.of(1))
                                .build())
                        .build())
                .addAddItem(ExplanationOfBenefit.AddedItem.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addItemSequence(FhirPositiveInt.of(1))
                        .addDetailSequence(FhirPositiveInt.of(1))
                        .addSubDetailSequence(FhirPositiveInt.of(1))
                        .addTraceNumber(Identifier.builder().build())
                        .addProvider(Reference.builder().build())
                        .revenue(CodeableConcept.builder().build())
                        .productOrService(CodeableConcept.builder().build())
                        .productOrServiceEnd(CodeableConcept.builder().build())
                        .addRequest(Reference.builder().build())
                        .addModifier(CodeableConcept.builder().build())
                        .addProgramCode(CodeableConcept.builder().build())
                        .serviced(FhirDate.parse("2024-01-01"))
                        .location(CodeableConcept.builder().build())
                        .patientPaid(Money.builder().build())
                        .quantity(Quantity.builder().build())
                        .unitPrice(Money.builder().build())
                        .factor(FhirDecimal.parse("1.0"))
                        .tax(Money.builder().build())
                        .net(Money.builder().build())
                        .addBodySite(ExplanationOfBenefit.AddedItem.AddedItemBodySite.builder()
                                .addSite(CodeableReference.builder().build())
                                .build())
                        .addNoteNumber(FhirPositiveInt.of(1))
                        .reviewOutcome(ExplanationOfBenefit.Item.ReviewOutcome.builder().build())
                        .addAdjudication(ExplanationOfBenefit.Item.Adjudication.builder()
                                .category(CodeableConcept.builder().build())
                                .build())
                        .addDetail(ExplanationOfBenefit.AddedItem.AddedItemDetail.builder().build())
                        .build())
                .addAdjudication(ExplanationOfBenefit.Item.Adjudication.builder()
                        .category(CodeableConcept.builder().build())
                        .build())
                .addTotal(ExplanationOfBenefit.Total.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .category(CodeableConcept.builder().build())
                        .amount(Money.builder().build())
                        .build())
                .payment(ExplanationOfBenefit.Payment.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .adjustment(Money.builder().build())
                        .adjustmentReason(CodeableConcept.builder().build())
                        .date(FhirDate.parse("2024-01-01"))
                        .amount(Money.builder().build())
                        .identifier(Identifier.builder().build())
                        .build())
                .formCode(CodeableConcept.builder().build())
                .form(Attachment.builder().build())
                .addProcessNote(ExplanationOfBenefit.Note.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .number(FhirPositiveInt.of(1))
                        .type(CodeableConcept.builder().build())
                        .text(FhirString.of("text"))
                        .language(CodeableConcept.builder().build())
                        .build())
                .benefitPeriod(Period.builder().build())
                .addBenefitBalance(ExplanationOfBenefit.BenefitBalance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .category(CodeableConcept.builder().build())
                        .excluded(FhirBoolean.of(true))
                        .name(FhirString.of("text"))
                        .description(FhirString.of("text"))
                        .network(CodeableConcept.builder().build())
                        .unit(CodeableConcept.builder().build())
                        .term(CodeableConcept.builder().build())
                        .addFinancial(ExplanationOfBenefit.BenefitBalance.Benefit.builder()
                                .type(CodeableConcept.builder().build())
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
        assertFalse(resource.identifier().isEmpty());
        assertFalse(resource.traceNumber().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.type());
        assertNotNull(resource.subType());
        assertNotNull(resource.use());
        assertNotNull(resource.patient());
        assertNotNull(resource.billablePeriod());
        assertNotNull(resource.created());
        assertNotNull(resource.enterer());
        assertNotNull(resource.insurer());
        assertNotNull(resource.provider());
        assertNotNull(resource.priority());
        assertNotNull(resource.fundsReserveRequested());
        assertNotNull(resource.fundsReserve());
        assertFalse(resource.related().isEmpty());
        assertNotNull(resource.prescription());
        assertNotNull(resource.originalPrescription());
        assertFalse(resource.event().isEmpty());
        assertNotNull(resource.payee());
        assertNotNull(resource.referral());
        assertFalse(resource.encounter().isEmpty());
        assertNotNull(resource.facility());
        assertNotNull(resource.claim());
        assertNotNull(resource.claimResponse());
        assertNotNull(resource.outcome());
        assertNotNull(resource.decision());
        assertNotNull(resource.disposition());
        assertFalse(resource.preAuthRef().isEmpty());
        assertFalse(resource.preAuthRefPeriod().isEmpty());
        assertNotNull(resource.diagnosisRelatedGroup());
        assertFalse(resource.careTeam().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.diagnosis().isEmpty());
        assertFalse(resource.procedure().isEmpty());
        assertNotNull(resource.precedence());
        assertFalse(resource.insurance().isEmpty());
        assertNotNull(resource.accident());
        assertNotNull(resource.patientPaid());
        assertFalse(resource.item().isEmpty());
        assertFalse(resource.addItem().isEmpty());
        assertFalse(resource.adjudication().isEmpty());
        assertFalse(resource.total().isEmpty());
        assertNotNull(resource.payment());
        assertNotNull(resource.formCode());
        assertNotNull(resource.form());
        assertFalse(resource.processNote().isEmpty());
        assertNotNull(resource.benefitPeriod());
        assertFalse(resource.benefitBalance().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ExplanationOfBenefit.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ExplanationOfBenefitStatus>) null).build()).getMessage());
    }

    @Test
    void insurancePlan() {
        InsurancePlan resource = InsurancePlan.builder()
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
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .addType(CodeableConcept.builder().build())
                .name(FhirString.of("text"))
                .addAlias(FhirString.of("text"))
                .period(Period.builder().build())
                .ownedBy(Reference.builder().build())
                .administeredBy(Reference.builder().build())
                .addCoverageArea(Reference.builder().build())
                .addContact(ExtendedContactDetail.builder().build())
                .addEndpoint(Reference.builder().build())
                .addNetwork(Reference.builder().build())
                .addCoverage(InsurancePlan.Coverage.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .addNetwork(Reference.builder().build())
                        .addBenefit(InsurancePlan.Coverage.CoverageBenefit.builder()
                                .type(CodeableConcept.builder().build())
                                .build())
                        .build())
                .addPlan(InsurancePlan.Plan.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addIdentifier(Identifier.builder().build())
                        .type(CodeableConcept.builder().build())
                        .addCoverageArea(Reference.builder().build())
                        .addNetwork(Reference.builder().build())
                        .addGeneralCost(InsurancePlan.Plan.GeneralCost.builder().build())
                        .addSpecificCost(InsurancePlan.Plan.SpecificCost.builder()
                                .category(CodeableConcept.builder().build())
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
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.type().isEmpty());
        assertNotNull(resource.name());
        assertFalse(resource.alias().isEmpty());
        assertNotNull(resource.period());
        assertNotNull(resource.ownedBy());
        assertNotNull(resource.administeredBy());
        assertFalse(resource.coverageArea().isEmpty());
        assertFalse(resource.contact().isEmpty());
        assertFalse(resource.endpoint().isEmpty());
        assertFalse(resource.network().isEmpty());
        assertFalse(resource.coverage().isEmpty());
        assertFalse(resource.plan().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
