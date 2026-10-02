package se.poroli.fhirplace.r5.serialization;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonString;
import jakarta.json.JsonValue;
import java.io.StringReader;
import java.util.TreeSet;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonResult;
import org.xmlunit.diff.ComparisonType;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.DifferenceEvaluators;

/**
 * Compares FHIR JSON documents semantically: property order is ignored, numbers must have the same value and
 * precision, and narrative {@code div} content is compared as XML, ignoring whitespace and comments.
 */
final class JsonComparison {

    private JsonComparison() {
    }

    /**
     * Returns the first difference between two JSON texts, or {@code null} if they are equivalent.
     */
    static String difference(String expected, String actual) {
        return difference(parse(expected), parse(actual), "$");
    }

    /**
     * Returns the first difference, ignoring the "test health data" coding ({@code v3-ActReason#HTEST}) that the HL7
     * publication tooling adds to {@code meta.tag} or {@code meta.security} inconsistently between the official JSON
     * and XML editions of the same example.
     */
    static String differenceIgnoringPublisherTestTag(String expected, String actual) {
        return difference(withoutTestTag(parse(expected)), withoutTestTag(parse(actual)), "$");
    }

    private static JsonValue withoutTestTag(JsonValue value) {
        return switch (value) {
            case JsonObject object -> {
                var builder = Json.createObjectBuilder();
                object.forEach((key, child) -> {
                    JsonValue cleaned = withoutTestTag(child);
                    if (cleaned instanceof JsonArray array && (key.equals("tag") || key.equals("security"))) {
                        var kept = Json.createArrayBuilder();
                        array.stream().filter(c -> !isTestTag(c)).forEach(kept::add);
                        cleaned = kept.build();
                    }
                    if (!(cleaned instanceof JsonArray a && a.isEmpty())
                            && !(key.equals("meta") && cleaned instanceof JsonObject m && m.isEmpty())) {
                        builder.add(key, cleaned);
                    }
                });
                yield builder.build();
            }
            case JsonArray array -> {
                var builder = Json.createArrayBuilder();
                array.forEach(item -> builder.add(withoutTestTag(item)));
                yield builder.build();
            }
            default -> value;
        };
    }

    private static boolean isTestTag(JsonValue coding) {
        return coding instanceof JsonObject c
                && "http://terminology.hl7.org/CodeSystem/v3-ActReason".equals(c.getString("system", null))
                && "HTEST".equals(c.getString("code", null));
    }

    static JsonValue parse(String json) {
        try (var reader = Json.createReader(new StringReader(json))) {
            return reader.readValue();
        }
    }

    private static String difference(JsonValue expected, JsonValue actual, String path) {
        if (expected.getValueType() != actual.getValueType()) {
            return path + ": expected " + expected + " but was " + actual;
        }
        switch (expected) {
            case JsonObject e -> {
                JsonObject a = (JsonObject) actual;
                TreeSet<String> keys = new TreeSet<>(e.keySet());
                keys.addAll(a.keySet());
                for (String key : keys) {
                    if (!e.containsKey(key)) {
                        return path + "." + key + ": unexpected " + a.get(key);
                    }
                    if (!a.containsKey(key)) {
                        return path + "." + key + ": missing " + e.get(key);
                    }
                    String d = key.equals("div") && e.get(key) instanceof JsonString es
                            && a.get(key) instanceof JsonString as
                            ? xhtmlDifference(es.getString(), as.getString(), path + ".div")
                            : difference(e.get(key), a.get(key), path + "." + key);
                    if (d != null) {
                        return d;
                    }
                }
                return null;
            }
            case JsonArray e -> {
                JsonArray a = (JsonArray) actual;
                if (e.size() != a.size()) {
                    return path + ": expected " + e.size() + " items but was " + a.size();
                }
                for (int i = 0; i < e.size(); i++) {
                    String d = difference(e.get(i), a.get(i), path + "[" + i + "]");
                    if (d != null) {
                        return d;
                    }
                }
                return null;
            }
            case JsonNumber e -> {
                return e.bigDecimalValue().equals(((JsonNumber) actual).bigDecimalValue())
                        ? null : path + ": expected " + e + " but was " + actual;
            }
            default -> {
                return expected.equals(actual) ? null : path + ": expected " + expected + " but was " + actual;
            }
        }
    }

    /**
     * Treats attribute values that differ only in whitespace as similar. The official JSON edition of some examples
     * holds literal line breaks inside XHTML attribute values, which XML parsing turns into spaces, while the XML
     * edition encodes them as character references that survive.
     */
    private static ComparisonResult attributeWhitespace(Comparison comparison, ComparisonResult outcome) {
        if (outcome == ComparisonResult.DIFFERENT && comparison.getType() == ComparisonType.ATTR_VALUE
                && collapse(comparison.getControlDetails().getValue())
                        .equals(collapse(comparison.getTestDetails().getValue()))) {
            return ComparisonResult.SIMILAR;
        }
        return outcome;
    }

    private static String collapse(Object value) {
        return String.valueOf(value).replaceAll("\\s+", " ").strip();
    }

    private static String xhtmlDifference(String expected, String actual, String path) {
        Diff diff = DiffBuilder.compare(expected).withTest(actual)
                .ignoreComments().ignoreWhitespace().checkForSimilar()
                .withDifferenceEvaluator(DifferenceEvaluators.chain(
                        DifferenceEvaluators.Default, JsonComparison::attributeWhitespace))
                .build();
        return diff.hasDifferences() ? path + ": " + diff.getDifferences().iterator().next() : null;
    }
}
