package se.poroli.fhirplace.r5.server.internal;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/** The FHIR media types and how to choose between JSON and XML. */
final class FhirMediaTypes {

    static final String FHIR_JSON = "application/fhir+json";
    static final String FHIR_XML = "application/fhir+xml";

    static final MediaType FHIR_JSON_TYPE = MediaType.valueOf(FHIR_JSON);
    static final MediaType FHIR_XML_TYPE = MediaType.valueOf(FHIR_XML);

    /** {@code _format} values and the media type each stands for. */
    private static final Map<String, String> FORMATS = Map.of(
            "json", FHIR_JSON, "application/json", FHIR_JSON, FHIR_JSON, FHIR_JSON,
            "xml", FHIR_XML, "text/xml", FHIR_XML, "application/xml", FHIR_XML, FHIR_XML, FHIR_XML);

    private FhirMediaTypes() {
    }

    static boolean isXml(MediaType type) {
        return type != null && (type.getSubtype().equals("xml") || type.getSubtype().endsWith("+xml"));
    }

    static boolean isJson(MediaType type) {
        return type != null && (type.getSubtype().equals("json") || type.getSubtype().endsWith("+json"));
    }

    /** Maps a {@code _format} value to a media type, or returns it unchanged if it is not a FHIR format. */
    static String forFormat(String format) {
        return FORMATS.getOrDefault(format.toLowerCase(Locale.ROOT).replace(' ', '+'), format);
    }

    /** Chooses the FHIR media type for a response from the request's {@code Accept} header. */
    static MediaType negotiate(HttpHeaders headers) {
        List<MediaType> acceptable = headers == null ? List.of() : headers.getAcceptableMediaTypes();
        for (MediaType type : acceptable) {
            if (type.isWildcardType() || type.isWildcardSubtype() && !type.getType().equals("text")) {
                return FHIR_JSON_TYPE;
            }
            if (isXml(type)) {
                return FHIR_XML_TYPE;
            }
            if (isJson(type)) {
                return FHIR_JSON_TYPE;
            }
        }
        return FHIR_JSON_TYPE;
    }
}
