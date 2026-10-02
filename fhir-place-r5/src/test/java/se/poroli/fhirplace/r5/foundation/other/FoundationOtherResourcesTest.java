package se.poroli.fhirplace.r5.foundation.other;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirInteger64;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.BundleType;
import se.poroli.fhirplace.r5.valuesets.HTTPVerb;
import se.poroli.fhirplace.r5.valuesets.InteractionTrigger;
import se.poroli.fhirplace.r5.valuesets.IssueSeverity;
import se.poroli.fhirplace.r5.valuesets.IssueType;
import se.poroli.fhirplace.r5.valuesets.LinkRelationTypes;
import se.poroli.fhirplace.r5.valuesets.LinkageType;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.ResponseType;
import se.poroli.fhirplace.r5.valuesets.SearchComparator;
import se.poroli.fhirplace.r5.valuesets.SearchModifierCode;
import se.poroli.fhirplace.r5.valuesets.SubscriptionNotificationType;
import se.poroli.fhirplace.r5.valuesets.SubscriptionPayloadContent;
import se.poroli.fhirplace.r5.valuesets.SubscriptionStatusCodes;

/** Builds every foundation.other resource with all elements and checks the builders and validation. */
class FoundationOtherResourcesTest {

    @Test
    void basic() {
        Basic resource = Basic.builder()
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
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .author(Reference.builder().build())
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
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.created());
        assertNotNull(resource.author());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Basic.code is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().code((CodeableConcept) null).build()).getMessage());
    }

    @Test
    void binary() {
        Binary resource = Binary.builder()
                .id("id1")
                .meta(Meta.builder().build())
                .implicitRules(FhirUri.of("http://example.org/uri"))
                .language(FhirCode.of("code"))
                .contentType(FhirCode.of("code"))
                .securityContext(Reference.builder().build())
                .data(FhirBase64Binary.of("aGk="))
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.contentType());
        assertNotNull(resource.securityContext());
        assertNotNull(resource.data());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Binary.contentType is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().contentType((FhirCode) null).build()).getMessage());
    }

    @Test
    void bundle() {
        Bundle resource = Bundle.builder()
                .id("id1")
                .meta(Meta.builder().build())
                .implicitRules(FhirUri.of("http://example.org/uri"))
                .language(FhirCode.of("code"))
                .identifier(Identifier.builder().build())
                .type(FhirEnum.of(BundleType.values()[0]))
                .timestamp(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .total(FhirUnsignedInt.of(0))
                .addLink(Bundle.Link.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .relation(FhirEnum.of(LinkRelationTypes.values()[0]))
                        .url(FhirUri.of("http://example.org/uri"))
                        .build())
                .addEntry(Bundle.Entry.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addLink(Bundle.Link.builder()
                                .relation(FhirEnum.of(LinkRelationTypes.values()[0]))
                                .url(FhirUri.of("http://example.org/uri"))
                                .build())
                        .fullUrl(FhirUri.of("http://example.org/uri"))
                        .resource(Patient.builder().build())
                        .search(Bundle.Entry.Search.builder().build())
                        .request(Bundle.Entry.Request.builder()
                                .method(FhirEnum.of(HTTPVerb.values()[0]))
                                .url(FhirUri.of("http://example.org/uri"))
                                .build())
                        .response(Bundle.Entry.Response.builder().status(FhirString.of("text")).build())
                        .build())
                .signature(Signature.builder().build())
                .issues(Patient.builder().build())
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.identifier());
        assertNotNull(resource.type());
        assertNotNull(resource.timestamp());
        assertNotNull(resource.total());
        assertFalse(resource.link().isEmpty());
        assertFalse(resource.entry().isEmpty());
        assertNotNull(resource.signature());
        assertNotNull(resource.issues());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Bundle.type is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().type((FhirEnum<BundleType>) null).build()).getMessage());
    }

    @Test
    void linkage() {
        Linkage resource = Linkage.builder()
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
                .active(FhirBoolean.of(true))
                .author(Reference.builder().build())
                .addItem(Linkage.Item.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(FhirEnum.of(LinkageType.values()[0]))
                        .resource(Reference.builder().build())
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
        assertNotNull(resource.active());
        assertNotNull(resource.author());
        assertFalse(resource.item().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Linkage.item requires at least one value", assertThrows(
                IllegalArgumentException.class,
                () -> resource.toBuilder().item((java.util.List<Linkage.Item>) null).build()).getMessage());
    }

    @Test
    void messageHeader() {
        MessageHeader resource = MessageHeader.builder()
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
                .event(Coding.builder().build())
                .addDestination(MessageHeader.MessageDestination.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .endpoint(FhirUrl.of("http://example.org/url"))
                        .name(FhirString.of("text"))
                        .target(Reference.builder().build())
                        .receiver(Reference.builder().build())
                        .build())
                .sender(Reference.builder().build())
                .author(Reference.builder().build())
                .source(MessageHeader.MessageSource.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .endpoint(FhirUrl.of("http://example.org/url"))
                        .name(FhirString.of("text"))
                        .software(FhirString.of("text"))
                        .version(FhirString.of("text"))
                        .contact(ContactPoint.builder().build())
                        .build())
                .responsible(Reference.builder().build())
                .reason(CodeableConcept.builder().build())
                .response(MessageHeader.Response.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .identifier(Identifier.builder().build())
                        .code(FhirEnum.of(ResponseType.values()[0]))
                        .details(Reference.builder().build())
                        .build())
                .addFocus(Reference.builder().build())
                .definition(FhirCanonical.of("http://example.org/canonical"))
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.text());
        assertFalse(resource.contained().isEmpty());
        assertFalse(resource.extension().isEmpty());
        assertFalse(resource.modifierExtension().isEmpty());
        assertNotNull(resource.event());
        assertFalse(resource.destination().isEmpty());
        assertNotNull(resource.sender());
        assertNotNull(resource.author());
        assertNotNull(resource.source());
        assertNotNull(resource.responsible());
        assertNotNull(resource.reason());
        assertNotNull(resource.response());
        assertFalse(resource.focus().isEmpty());
        assertNotNull(resource.definition());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("MessageHeader.event is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().event((Coding) null).build()).getMessage());
    }

    @Test
    void operationOutcome() {
        OperationOutcome resource = OperationOutcome.builder()
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
                .addIssue(OperationOutcome.Issue.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .severity(FhirEnum.of(IssueSeverity.values()[0]))
                        .code(FhirEnum.of(IssueType.values()[0]))
                        .details(CodeableConcept.builder().build())
                        .diagnostics(FhirString.of("text"))
                        .addLocation(FhirString.of("text"))
                        .addExpression(FhirString.of("text"))
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
        assertFalse(resource.issue().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("OperationOutcome.issue requires at least one value", assertThrows(
                IllegalArgumentException.class,
                (
                        ) -> resource.toBuilder().issue((java.util.List<OperationOutcome.Issue>) null).build()).getMessage());
    }

    @Test
    void parameters() {
        Parameters resource = Parameters.builder()
                .id("id1")
                .meta(Meta.builder().build())
                .implicitRules(FhirUri.of("http://example.org/uri"))
                .language(FhirCode.of("code"))
                .addParameter(Parameters.Parameter.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .value(FhirBase64Binary.of("aGk="))
                        .resource(Patient.builder().build())
                        .addPart(Parameters.Parameter.builder().name(FhirString.of("text")).build())
                        .build())
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertFalse(resource.parameter().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void subscription() {
        Subscription resource = Subscription.builder()
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
                .name(FhirString.of("text"))
                .status(FhirEnum.of(SubscriptionStatusCodes.values()[0]))
                .topic(FhirCanonical.of("http://example.org/canonical"))
                .addContact(ContactPoint.builder().build())
                .end(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .managingEntity(Reference.builder().build())
                .reason(FhirString.of("text"))
                .addFilterBy(Subscription.FilterBy.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .resourceType(FhirUri.of("http://example.org/uri"))
                        .filterParameter(FhirString.of("text"))
                        .comparator(FhirEnum.of(SearchComparator.values()[0]))
                        .modifier(FhirEnum.of(SearchModifierCode.values()[0]))
                        .value(FhirString.of("text"))
                        .build())
                .channelType(Coding.builder().build())
                .endpoint(FhirUrl.of("http://example.org/url"))
                .addParameter(Subscription.Parameter.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .value(FhirString.of("text"))
                        .build())
                .heartbeatPeriod(FhirUnsignedInt.of(0))
                .timeout(FhirUnsignedInt.of(0))
                .contentType(FhirCode.of("code"))
                .content(FhirEnum.of(SubscriptionPayloadContent.values()[0]))
                .maxCount(FhirPositiveInt.of(1))
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
        assertNotNull(resource.name());
        assertNotNull(resource.status());
        assertNotNull(resource.topic());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.end());
        assertNotNull(resource.managingEntity());
        assertNotNull(resource.reason());
        assertFalse(resource.filterBy().isEmpty());
        assertNotNull(resource.channelType());
        assertNotNull(resource.endpoint());
        assertFalse(resource.parameter().isEmpty());
        assertNotNull(resource.heartbeatPeriod());
        assertNotNull(resource.timeout());
        assertNotNull(resource.contentType());
        assertNotNull(resource.content());
        assertNotNull(resource.maxCount());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Subscription.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<SubscriptionStatusCodes>) null).build()).getMessage());
    }

    @Test
    void subscriptionStatus() {
        SubscriptionStatus resource = SubscriptionStatus.builder()
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
                .status(FhirEnum.of(SubscriptionStatusCodes.values()[0]))
                .type(FhirEnum.of(SubscriptionNotificationType.values()[0]))
                .eventsSinceSubscriptionStart(FhirInteger64.of(1L))
                .addNotificationEvent(SubscriptionStatus.NotificationEvent.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .eventNumber(FhirInteger64.of(1L))
                        .timestamp(FhirInstant.parse("2024-01-01T00:00:00Z"))
                        .focus(Reference.builder().build())
                        .addAdditionalContext(Reference.builder().build())
                        .build())
                .subscription(Reference.builder().build())
                .topic(FhirCanonical.of("http://example.org/canonical"))
                .addError(CodeableConcept.builder().build())
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
        assertNotNull(resource.type());
        assertNotNull(resource.eventsSinceSubscriptionStart());
        assertFalse(resource.notificationEvent().isEmpty());
        assertNotNull(resource.subscription());
        assertNotNull(resource.topic());
        assertFalse(resource.error().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("SubscriptionStatus.type is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().type((FhirEnum<SubscriptionNotificationType>) null).build()).getMessage());
    }

    @Test
    void subscriptionTopic() {
        SubscriptionTopic resource = SubscriptionTopic.builder()
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
                .addDerivedFrom(FhirCanonical.of("http://example.org/canonical"))
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
                .addResourceTrigger(SubscriptionTopic.ResourceTrigger.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirMarkdown.of("text"))
                        .resource(FhirUri.of("http://example.org/uri"))
                        .addSupportedInteraction(FhirEnum.of(InteractionTrigger.values()[0]))
                        .queryCriteria(SubscriptionTopic.ResourceTrigger.QueryCriteria.builder().build())
                        .fhirPathCriteria(FhirString.of("text"))
                        .build())
                .addEventTrigger(SubscriptionTopic.EventTrigger.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirMarkdown.of("text"))
                        .event(CodeableConcept.builder().build())
                        .resource(FhirUri.of("http://example.org/uri"))
                        .build())
                .addCanFilterBy(SubscriptionTopic.CanFilterBy.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirMarkdown.of("text"))
                        .resource(FhirUri.of("http://example.org/uri"))
                        .filterParameter(FhirString.of("text"))
                        .filterDefinition(FhirUri.of("http://example.org/uri"))
                        .addComparator(FhirEnum.of(SearchComparator.values()[0]))
                        .addModifier(FhirEnum.of(SearchModifierCode.values()[0]))
                        .build())
                .addNotificationShape(SubscriptionTopic.NotificationShape.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .resource(FhirUri.of("http://example.org/uri"))
                        .addInclude(FhirString.of("text"))
                        .addRevInclude(FhirString.of("text"))
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
        assertFalse(resource.derivedFrom().isEmpty());
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
        assertFalse(resource.resourceTrigger().isEmpty());
        assertFalse(resource.eventTrigger().isEmpty());
        assertFalse(resource.canFilterBy().isEmpty());
        assertFalse(resource.notificationShape().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("SubscriptionTopic.url is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().url((FhirUri) null).build()).getMessage());
    }
}
