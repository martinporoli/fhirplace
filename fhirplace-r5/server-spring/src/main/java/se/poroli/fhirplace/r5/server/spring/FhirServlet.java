package se.poroli.fhirplace.r5.server.spring;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import se.poroli.fhirplace.r5.server.FhirRequest;
import se.poroli.fhirplace.r5.server.FhirResponse;
import se.poroli.fhirplace.r5.server.FhirServer;

/**
 * Serves a {@link FhirServer} as a servlet. The FHIR base is the servlet's mapping, such as {@code /fhir/*}. The
 * servlet works in any Jakarta Servlet 6 container; {@link FhirServerAutoConfiguration} registers it in Spring Boot.
 */
public class FhirServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final transient FhirServer server;

    /**
     * Creates the servlet.
     *
     * @param server the FHIR server to serve
     */
    public FhirServlet(FhirServer server) {
        this.server = Objects.requireNonNull(server, "server");
    }

    /**
     * Passes the request to the FHIR server and writes its response.
     *
     * @param request the servlet request
     * @param response the servlet response
     * @throws IOException if reading the request or writing the response fails
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String prefix = request.getContextPath() + request.getServletPath();
        String path = request.getRequestURI().substring(prefix.length());
        String url = request.getRequestURL().toString();
        URI base = URI.create(url.substring(0, url.length() - request.getRequestURI().length()) + prefix + "/");
        Map<String, List<String>> headers = new HashMap<>();
        for (String name : Collections.list(request.getHeaderNames())) {
            headers.put(name, Collections.list(request.getHeaders(name)));
        }
        FhirResponse fhir = server.handle(new FhirRequest(request.getMethod(),
                path.startsWith("/") ? path.substring(1) : path, request.getQueryString(), headers,
                request.getInputStream().readAllBytes(), base));
        response.setStatus(fhir.status());
        fhir.headers().forEach((name, values) -> values.forEach(value -> response.addHeader(name, value)));
        if (fhir.body().length > 0) {
            response.setContentLength(fhir.body().length);
            response.getOutputStream().write(fhir.body());
        }
    }
}
