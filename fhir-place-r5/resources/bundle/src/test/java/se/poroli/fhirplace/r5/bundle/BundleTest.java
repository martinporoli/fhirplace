package se.poroli.fhirplace.r5.bundle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/** Builds a Bundle with all elements and checks the builder and validation. */
class BundleTest {

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
    void isAResourceWithoutNarrativeOrExtensionsAndHoldsOtherResources() {
        Resource bundle = Bundle.builder().id("b1").type(BundleType.COLLECTION)
                .addEntry(Bundle.Entry.builder().resource(Patient.builder().id("p1").build()).build())
                .build();

        assertFalse(bundle instanceof DomainResource);
        assertEquals("p1", ((Bundle) bundle).entry().getFirst().resource().id());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(BundleType.values(), BundleType::fromCode);
        assertCodes(HTTPVerb.values(), HTTPVerb::fromCode);
        assertCodes(LinkRelationTypes.values(), LinkRelationTypes::fromCode);
        assertCodes(SearchEntryMode.values(), SearchEntryMode::fromCode);
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
