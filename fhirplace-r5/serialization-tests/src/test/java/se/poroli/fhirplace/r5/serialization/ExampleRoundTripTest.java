package se.poroli.fhirplace.r5.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.xml.FhirXml;

/** Reads and writes every committed official FHIR R5 example in JSON, XML and through JSON-B. */
class ExampleRoundTripTest {

    private static final String XSI = "http://www.w3.org/2001/XMLSchema-instance";

    private static Jsonb jsonb;

    @BeforeAll
    static void createJsonb() {
        jsonb = JsonbBuilder.create();
    }

    @AfterAll
    static void closeJsonb() throws Exception {
        jsonb.close();
    }

    static List<Example> examples() {
        return Example.all();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("examples")
    void jsonRoundTripsWithoutLoss(Example example) {
        Resource resource = FhirJson.read(example.jsonText());

        assertEquals(example.resourceType(), resource.getClass().getSimpleName());
        assertNull(JsonComparison.difference(example.jsonText(), FhirJson.write(resource)));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("examples")
    void xmlRoundTripsWithoutLoss(Example example) {
        Resource resource = FhirXml.read(example.xmlText());

        assertEquals(example.resourceType(), resource.getClass().getSimpleName());
        Diff diff = DiffBuilder.compare(example.xmlText()).withTest(FhirXml.write(resource))
                .ignoreComments().ignoreWhitespace().checkForSimilar()
                .withAttributeFilter(attribute -> !XSI.equals(attribute.getNamespaceURI()))
                .build();
        assertFalse(diff.hasDifferences(), () -> diff.getDifferences().iterator().next().toString());
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("examples")
    void xmlAndJsonReadToTheSameResource(Example example) {
        Resource fromXml = FhirXml.read(example.xmlText());

        assertNull(JsonComparison.differenceIgnoringPublisherTestTag(example.jsonText(), FhirJson.write(fromXml)));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("examples")
    void jsonbReadsAndWritesFhirJson(Example example) {
        Resource resource = jsonb.fromJson(example.jsonText(), FhirJson.read(example.jsonText()).getClass());

        assertEquals(FhirJson.read(example.jsonText()), resource);
        assertNull(JsonComparison.difference(example.jsonText(), jsonb.toJson(resource)));
    }
}
