package se.poroli.fhirplace.r5.server.internal;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import se.poroli.fhirplace.r5.server.FhirRequest;

/** A {@link FhirRequest} with decoded path segments and parameters, and case-insensitive headers. */
final class Request {

    final FhirRequest original;
    final String method;
    final List<String> segments;
    final Map<String, List<String>> parameters;
    final byte[] body;
    final URI base;
    private final Map<String, List<String>> headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    Request(FhirRequest request) {
        this.original = request;
        this.method = request.method().toUpperCase(Locale.ROOT);
        this.segments = new ArrayList<>();
        for (String segment : request.path().split("/")) {
            if (!segment.isEmpty()) {
                segments.add(decodePath(segment));
            }
        }
        this.parameters = parse(request.query());
        this.body = request.body();
        String base = request.base().toString();
        this.base = URI.create(base.endsWith("/") ? base : base + "/");
        request.headers().forEach((name, values) -> headers.computeIfAbsent(name, n -> new ArrayList<>())
                .addAll(values));
    }

    /** Returns the header's values joined with commas, or {@code null} if absent. */
    String header(String name) {
        List<String> values = headers.get(name);
        return values == null || values.isEmpty() ? null : String.join(",", values);
    }

    String parameter(String name) {
        List<String> values = parameters.get(name);
        return values == null || values.isEmpty() ? null : values.getFirst();
    }

    /** Returns the preferences of the {@code Prefer} header, such as {@code return=minimal}. */
    Map<String, String> preferences() {
        Map<String, String> preferences = new HashMap<>();
        String header = header("Prefer");
        if (header != null) {
            for (String preference : header.split("[,;]")) {
                String[] parts = preference.strip().split("=", 2);
                if (!parts[0].isBlank()) {
                    preferences.put(parts[0].strip().toLowerCase(Locale.ROOT),
                            parts.length > 1 ? parts[1].strip().replace("\"", "") : "");
                }
            }
        }
        return preferences;
    }

    /** Parses an {@code application/x-www-form-urlencoded} string, keeping parameter order. */
    static Map<String, List<String>> parse(String encoded) {
        Map<String, List<String>> parameters = new LinkedHashMap<>();
        if (encoded == null || encoded.isEmpty()) {
            return parameters;
        }
        for (String pair : encoded.split("&")) {
            if (pair.isEmpty()) {
                continue;
            }
            int equals = pair.indexOf('=');
            String name = decode(equals < 0 ? pair : pair.substring(0, equals));
            String value = equals < 0 ? "" : decode(pair.substring(equals + 1));
            parameters.computeIfAbsent(name, n -> new ArrayList<>()).add(value);
        }
        return parameters;
    }

    /** Decodes form encoding, where {@code +} is a space. */
    private static String decode(String value) {
        return URLDecoder.decode(value, StandardCharsets.UTF_8);
    }

    /** Decodes a path segment, where {@code +} is itself. */
    private static String decodePath(String segment) {
        return URLDecoder.decode(segment.replace("+", "%2B"), StandardCharsets.UTF_8);
    }
}
