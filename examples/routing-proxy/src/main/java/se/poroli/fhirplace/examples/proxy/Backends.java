package se.poroli.fhirplace.examples.proxy;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import se.poroli.fhirplace.r5.client.FhirClient;
import se.poroli.fhirplace.r5.server.FhirException;
import se.poroli.fhirplace.r5.server.FhirRequest;

/** The regional FHIR servers, from {@code proxy.backends.<region>=<base URL>}. */
@Component
public class Backends {

    private final Map<String, URI> regions;
    private final FhirClient template;

    public Backends(Environment environment, HttpClient httpClient) {
        this.regions = new TreeMap<>(Binder.get(environment)
                .bind("proxy.backends", Bindable.mapOf(String.class, URI.class))
                .orElseThrow(() -> new IllegalStateException("Configure at least one proxy.backends.<region>")));
        // The template carries the shared HttpClient; per request only the base URL and headers change.
        this.template = FhirClient.of(regions.values().iterator().next(), httpClient);
    }

    /**
     * Returns a client for the backend of the request's region, forwarding the caller's {@code Authorization}.
     * Creating it is cheap: it is a small immutable value that shares the HttpClient.
     */
    public FhirClient clientFor(FhirRequest request) {
        String region = request.header("X-Region");
        if (region == null) {
            throw FhirException.invalid("The X-Region header is required; one of " + regions.keySet());
        }
        URI backend = regions.get(region);
        if (backend == null) {
            throw FhirException.invalid("Unknown region '" + region + "'; one of " + regions.keySet());
        }
        FhirClient client = template.at(backend);
        String authorization = request.header("Authorization");
        return authorization == null ? client : client.withHeader("Authorization", authorization);
    }
}
