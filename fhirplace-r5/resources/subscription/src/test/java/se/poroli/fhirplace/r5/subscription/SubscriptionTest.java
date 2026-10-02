package se.poroli.fhirplace.r5.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.SearchComparator;
import se.poroli.fhirplace.r5.valuesets.SearchModifierCode;
import se.poroli.fhirplace.r5.valuesets.SubscriptionStatusCodes;

/** Builds a Subscription with all elements and checks the builder and validation. */
class SubscriptionTest {

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
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(SubscriptionPayloadContent.values(), SubscriptionPayloadContent::fromCode);
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
