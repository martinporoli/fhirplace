package se.poroli.fhirplace.r5.serialization;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 * One official FHIR R5 example, available as both JSON and XML.
 *
 * @param resourceType the resource type, such as {@code Patient}
 * @param id the example's resource id
 * @param json the JSON file
 * @param xml the XML file
 */
record Example(String resourceType, String id, Path json, Path xml) {

    static List<Example> all() {
        Path root;
        try {
            root = Path.of(Example.class.getResource("/examples").toURI());
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
        try (Stream<Path> files = Files.list(root.resolve("json"))) {
            return files.map(json -> {
                String name = json.getFileName().toString().replaceFirst("\\.json$", "");
                int dash = name.indexOf('-');
                return new Example(name.substring(0, dash), name.substring(dash + 1), json,
                        root.resolve("xml").resolve(name + ".xml"));
            }).sorted(java.util.Comparator.comparing(Example::toString)).toList();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    String jsonText() {
        return read(json);
    }

    String xmlText() {
        return read(xml);
    }

    private static String read(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public String toString() {
        return resourceType + "/" + id;
    }
}
