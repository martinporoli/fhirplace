package se.poroli.fhirplace.r5.client;

import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.xml.FhirXml;

/**
 * Request bodies in FHIR JSON or XML for {@code java.net.http.HttpRequest}. Set the matching {@code Content-Type},
 * {@code application/fhir+json} or {@code application/fhir+xml}.
 */
public final class FhirBodyPublishers {

    private FhirBodyPublishers() {
    }

    /**
     * Returns a body publisher that sends a resource as FHIR JSON.
     *
     * @param resource the resource
     * @return the publisher
     */
    public static HttpRequest.BodyPublisher json(Resource resource) {
        return HttpRequest.BodyPublishers.ofString(FhirJson.write(resource), StandardCharsets.UTF_8);
    }

    /**
     * Returns a body publisher that sends a resource as FHIR XML.
     *
     * @param resource the resource
     * @return the publisher
     */
    public static HttpRequest.BodyPublisher xml(Resource resource) {
        return HttpRequest.BodyPublishers.ofString(FhirXml.write(resource), StandardCharsets.UTF_8);
    }

    static HttpRequest.BodyPublisher of(Resource resource, FhirFormat format) {
        return format == FhirFormat.XML ? xml(resource) : json(resource);
    }
}
