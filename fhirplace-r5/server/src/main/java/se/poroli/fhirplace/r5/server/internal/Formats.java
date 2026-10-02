package se.poroli.fhirplace.r5.server.internal;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonGeneratorFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import java.util.Map;
import se.poroli.fhirplace.r5.FhirFormatException;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.server.FhirException;
import se.poroli.fhirplace.r5.xml.FhirXml;

/** Content negotiation, and reading and writing FHIR JSON and XML bodies. */
final class Formats {

    static final String FHIR_JSON = "application/fhir+json";
    static final String FHIR_XML = "application/fhir+xml";

    /** {@code _format} values and the media type each stands for. */
    private static final Map<String, String> FORMATS = Map.of(
            "json", FHIR_JSON, "application/json", FHIR_JSON, FHIR_JSON, FHIR_JSON,
            "xml", FHIR_XML, "text/xml", FHIR_XML, "application/xml", FHIR_XML, FHIR_XML, FHIR_XML);

    private static final JsonGeneratorFactory PRETTY_JSON =
            Json.createGeneratorFactory(Map.of(JsonGenerator.PRETTY_PRINTING, true));

    private Formats() {
    }

    /**
     * The negotiated response format.
     *
     * @param mediaType the response media type, such as {@code application/fhir+json}
     * @param xml whether to write XML
     * @param pretty whether to indent JSON
     */
    record Format(String mediaType, boolean xml, boolean pretty) {

        static final Format DEFAULT = new Format(FHIR_JSON, false, false);
    }

    /**
     * Chooses the response format from {@code _format}, which overrides {@code Accept}, and {@code _pretty}.
     *
     * @throws FhirException 406 if the client accepts neither FHIR JSON nor XML
     */
    static Format negotiate(Request request) {
        boolean pretty = "true".equalsIgnoreCase(request.parameter("_pretty"));
        String format = request.parameter("_format");
        String accept = format != null && !format.isBlank()
                ? FORMATS.getOrDefault(format.strip().toLowerCase(Locale.ROOT).replace(' ', '+'), format)
                : request.header("Accept");
        if (accept == null || accept.isBlank()) {
            return new Format(FHIR_JSON, false, pretty);
        }
        String best = null;
        double bestQuality = 0;
        for (String range : accept.split(",")) {
            String[] parts = range.split(";");
            String type = parts[0].strip().toLowerCase(Locale.ROOT);
            double quality = 1;
            for (int i = 1; i < parts.length; i++) {
                String parameter = parts[i].strip();
                if (parameter.startsWith("q=")) {
                    try {
                        quality = Double.parseDouble(parameter.substring(2));
                    } catch (NumberFormatException e) {
                        quality = 0;
                    }
                }
            }
            String mediaType = mediaType(type);
            if (mediaType != null && quality > bestQuality) {
                best = mediaType;
                bestQuality = quality;
            }
        }
        if (best == null) {
            throw new FhirException(406, IssueType.NOT_SUPPORTED,
                    "None of the accepted media types is supported; use application/fhir+json or "
                            + "application/fhir+xml");
        }
        return new Format(best, isXml(best), pretty);
    }

    /** Returns the response media type for an accepted media range, or {@code null} if it is not supported. */
    private static String mediaType(String range) {
        return switch (range) {
            case "*/*", "application/*" -> FHIR_JSON;
            case FHIR_JSON, "application/json", FHIR_XML, "application/xml", "text/xml" -> range;
            default -> null;
        };
    }

    private static boolean isXml(String mediaType) {
        return mediaType.endsWith("/xml") || mediaType.endsWith("+xml");
    }

    /**
     * Reads a request body by its {@code Content-Type}.
     *
     * @throws FhirException 415 for unsupported content types, 400 for invalid content
     */
    static Resource read(byte[] body, String contentType) {
        if (body.length == 0) {
            throw FhirException.invalid("The request has no body");
        }
        String type = contentType == null ? "" : contentType.split(";")[0].strip().toLowerCase(Locale.ROOT);
        boolean xml = type.equals(FHIR_XML) || type.equals("application/xml") || type.equals("text/xml");
        boolean json = type.equals(FHIR_JSON) || type.equals("application/json");
        if (!xml && !json) {
            throw new FhirException(415, IssueType.NOT_SUPPORTED, "Unsupported Content-Type '" + contentType
                    + "'; use application/fhir+json or application/fhir+xml");
        }
        Reader reader = new InputStreamReader(new ByteArrayInputStream(body), charset(contentType));
        try {
            return xml ? FhirXml.read(reader) : FhirJson.read(reader);
        } catch (FhirFormatException e) {
            throw invalidContent(e);
        }
    }

    /**
     * Answers content that cannot be read: 400 for malformed or misstructured content, 422 for content that breaks the
     * specification's rules, with an issue that tells what and where.
     */
    private static FhirException invalidContent(FhirFormatException e) {
        int status = switch (e.problem()) {
            case SYNTAX, STRUCTURE -> 400;
            case REQUIRED, VALUE -> 422;
        };
        IssueType code = switch (e.problem()) {
            case SYNTAX -> IssueType.INVALID;
            case STRUCTURE -> IssueType.STRUCTURE;
            case REQUIRED -> IssueType.REQUIRED;
            case VALUE -> IssueType.VALUE;
        };
        OperationOutcome.Issue.Builder issue = OperationOutcome.Issue.builder()
                .severity(IssueSeverity.ERROR)
                .code(code)
                .diagnostics(FhirString.of(e.detail()));
        if (e.expression() != null) {
            issue.addExpression(FhirString.of(e.expression()));
        }
        return new FhirException(status, OperationOutcome.builder().addIssue(issue.build()).build());
    }

    /** Writes a resource in the negotiated format as UTF-8. */
    static byte[] write(Resource resource, Format format) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
        try {
            if (format.xml()) {
                FhirXml.write(resource, writer);
            } else if (format.pretty()) {
                JsonGenerator generator = PRETTY_JSON.createGenerator(writer);
                FhirJson.write(resource, generator);
                generator.flush();
            } else {
                FhirJson.write(resource, writer);
            }
            writer.flush();
        } catch (java.io.IOException e) {
            throw new java.io.UncheckedIOException(e);
        }
        return out.toByteArray();
    }

    private static Charset charset(String contentType) {
        if (contentType != null) {
            for (String parameter : contentType.split(";")) {
                String[] parts = parameter.strip().split("=", 2);
                if (parts.length == 2 && parts[0].strip().equalsIgnoreCase("charset")) {
                    try {
                        return Charset.forName(parts[1].strip().replace("\"", ""));
                    } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
                        throw new FhirException(415, IssueType.NOT_SUPPORTED, "Unsupported charset " + parts[1]);
                    }
                }
            }
        }
        return StandardCharsets.UTF_8;
    }
}
