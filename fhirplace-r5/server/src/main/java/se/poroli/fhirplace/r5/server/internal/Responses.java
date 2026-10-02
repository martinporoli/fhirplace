package se.poroli.fhirplace.r5.server.internal;

import jakarta.ws.rs.core.EntityTag;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Meta;

/** Building blocks for FHIR responses: versions, ETags, locations and request preferences. */
final class Responses {

    private static final Pattern ID = Pattern.compile("[A-Za-z0-9\\-.]{1,64}");

    private Responses() {
    }

    static Annotation[] pretty(UriInfo uriInfo) {
        return uriInfo != null && "true".equalsIgnoreCase(uriInfo.getQueryParameters().getFirst("_pretty"))
                ? Pretty.ON : Pretty.OFF;
    }

    static boolean isValidId(String id) {
        return id != null && ID.matcher(id).matches();
    }

    static String versionId(Resource resource) {
        Meta meta = resource.meta();
        return meta == null || meta.versionId() == null ? null : meta.versionId().value();
    }

    static EntityTag etag(Resource resource) {
        String version = versionId(resource);
        return version == null ? null : new EntityTag(version, true);
    }

    static Date lastModified(Resource resource) {
        Meta meta = resource.meta();
        return meta == null || meta.lastUpdated() == null || meta.lastUpdated().value() == null
                ? null : Date.from(meta.lastUpdated().value().toInstant());
    }

    /** Adds {@code ETag} and {@code Last-Modified} from the resource's meta. */
    static Response.ResponseBuilder versionHeaders(Response.ResponseBuilder response, Resource resource) {
        EntityTag etag = etag(resource);
        if (etag != null) {
            response.tag(etag);
        }
        Date lastModified = lastModified(resource);
        if (lastModified != null) {
            response.lastModified(lastModified);
        }
        return response;
    }

    /** Returns {@code [base]/[type]/[id]}, followed by {@code /_history/[vid]} if the resource has a version. */
    static URI location(UriInfo uriInfo, String type, Resource resource) {
        String version = versionId(resource);
        return uriInfo.getBaseUri().resolve(type + "/" + resource.id() + (version == null ? "" : "/_history/"
                + version));
    }

    /** Parses the {@code Prefer} header into its preferences, such as {@code return=minimal}. */
    static Map<String, String> preferences(HttpHeaders headers) {
        Map<String, String> preferences = new HashMap<>();
        List<String> values = headers.getRequestHeader("Prefer");
        if (values == null) {
            return preferences;
        }
        for (String value : values) {
            for (String preference : value.split("[,;]")) {
                String[] parts = preference.strip().split("=", 2);
                if (!parts[0].isBlank()) {
                    preferences.put(parts[0].strip().toLowerCase(Locale.ROOT),
                            parts.length > 1 ? parts[1].strip().replace("\"", "") : "");
                }
            }
        }
        return preferences;
    }

    /** Returns whether one of the entity tags in an {@code If-Match} or {@code If-None-Match} header matches. */
    static boolean matches(String header, Resource resource) {
        if (header.strip().equals("*")) {
            return resource != null;
        }
        String version = resource == null ? null : versionId(resource);
        if (version == null) {
            return false;
        }
        for (String tag : header.split(",")) {
            String value = tag.strip();
            if (value.startsWith("W/")) {
                value = value.substring(2);
            }
            if (value.length() >= 2 && value.startsWith("\"") && value.endsWith("\"")) {
                value = value.substring(1, value.length() - 1);
            }
            if (value.equals(version)) {
                return true;
            }
        }
        return false;
    }
}
