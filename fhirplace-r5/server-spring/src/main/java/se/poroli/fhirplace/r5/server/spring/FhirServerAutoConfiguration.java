package se.poroli.fhirplace.r5.server.spring;

import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.FhirServer;

/**
 * Serves the application's {@link FhirResource} beans as a FHIR RESTful API under {@code fhirplace.server.path}
 * ({@code /fhir} by default). Invalid handlers fail application startup.
 *
 * <p>Define a {@link FhirServer} bean to build the server differently; the servlet then serves that one.
 */
@AutoConfiguration
@ConditionalOnClass(HttpServlet.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class FhirServerAutoConfiguration {

    /** Creates the configuration. */
    public FhirServerAutoConfiguration() {
    }

    /**
     * Builds the FHIR server from every bean whose class is annotated with {@link FhirResource}.
     *
     * @param context the application context
     * @return the server
     */
    @Bean
    @ConditionalOnMissingBean
    public FhirServer fhirServer(ApplicationContext context) {
        FhirServer.Builder builder = FhirServer.builder();
        for (String name : context.getBeanNamesForAnnotation(FhirResource.class)) {
            builder.handler(context.getBean(name));
        }
        return builder.build();
    }

    /**
     * Registers the servlet that serves the FHIR server.
     *
     * @param server the FHIR server
     * @param path the FHIR base path, from {@code fhirplace.server.path}
     * @return the servlet registration
     */
    @Bean
    public ServletRegistrationBean<FhirServlet> fhirServlet(FhirServer server,
            @Value("${fhirplace.server.path:/fhir}") String path) {
        String base = path.endsWith("/") ? path.substring(0, path.length() - 1) : path;
        ServletRegistrationBean<FhirServlet> registration =
                new ServletRegistrationBean<>(new FhirServlet(server), base + "/*");
        registration.setName("fhirplace");
        return registration;
    }
}
