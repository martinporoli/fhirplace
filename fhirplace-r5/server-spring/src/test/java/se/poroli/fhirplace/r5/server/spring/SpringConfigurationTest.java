package se.poroli.fhirplace.r5.server.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.capabilitystatement.CapabilityStatement;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.FhirServer;
import se.poroli.fhirplace.r5.server.Read;
import se.poroli.fhirplace.r5.server.shared.ObservationHandler;
import se.poroli.fhirplace.r5.server.shared.PatientHandler;

/** The auto-configuration in differently configured Spring Boot applications, each on its own port. */
class SpringConfigurationTest {

    /** An application with a Patient handler and an ordinary controller. */
    @Configuration
    @EnableAutoConfiguration
    @Import(HelloController.class)
    static class PatientApplication {

        @Bean
        PatientHandler patientHandler() {
            return new PatientHandler();
        }
    }

    /** An ordinary Spring MVC controller next to the FHIR API. */
    @RestController
    static class HelloController {

        @GetMapping("/hello")
        String hello() {
            return "hello";
        }
    }

    /** An application that builds its own FhirServer, serving only Observation although a Patient bean exists. */
    @Configuration
    @EnableAutoConfiguration
    static class OwnServerApplication {

        @Bean
        PatientHandler patientHandler() {
            return new PatientHandler();
        }

        @Bean
        FhirServer fhirServer() {
            return FhirServer.builder().handler(new ObservationHandler()).build();
        }
    }

    /** A handler without an {@code @Id} parameter on its read method. */
    @FhirResource(Bundle.class)
    static class HandlerWithoutId {
        @Read
        public Optional<Bundle> read(String id) {
            return Optional.empty();
        }
    }

    /** An application with an invalid handler. */
    @Configuration
    @EnableAutoConfiguration
    static class InvalidApplication {

        @Bean
        HandlerWithoutId handlerWithoutId() {
            return new HandlerWithoutId();
        }
    }

    private static ConfigurableApplicationContext start(Class<?> application, String... properties) {
        return new SpringApplicationBuilder(application)
                .properties("server.port=0", "spring.main.banner-mode=off")
                .properties(properties)
                .run();
    }

    private static RestClient client(ConfigurableApplicationContext context) {
        return RestClient.builder()
                .baseUrl("http://localhost:" + context.getEnvironment().getProperty("local.server.port"))
                .defaultStatusHandler(status -> true, (request, response) -> {
                })
                .build();
    }

    private static int status(RestClient client, String path) {
        return client.get().uri(path).retrieve().toBodilessEntity().getStatusCode().value();
    }

    @Test
    void servesUnderTheConfiguredPath() {
        try (ConfigurableApplicationContext context = start(PatientApplication.class,
                "fhirplace.server.path=/api/fhir")) {
            RestClient client = client(context);

            assertEquals(200, status(client, "/api/fhir/metadata"));
            assertEquals(404, status(client, "/fhir/metadata"));
        }
    }

    @Test
    void urlsIncludeTheServletContextPath() {
        try (ConfigurableApplicationContext context = start(PatientApplication.class,
                "server.servlet.context-path=/app")) {
            RestClient client = client(context);
            String base = "http://localhost:" + context.getEnvironment().getProperty("local.server.port")
                    + "/app/fhir/";
            Patient patient = Patient.builder().addName(HumanName.builder().family("Context").build()).build();

            ResponseEntity<String> created = client.post().uri("/app/fhir/Patient")
                    .contentType(MediaType.valueOf("application/fhir+json")).body(FhirJson.write(patient))
                    .retrieve().toEntity(String.class);
            String id = FhirJson.read(created.getBody(), Patient.class).id();
            Bundle bundle = FhirJson.read(client.get().uri("/app/fhir/Patient?family=Context")
                    .retrieve().body(String.class), Bundle.class);

            assertEquals(201, created.getStatusCode().value());
            assertEquals(base + "Patient/" + id + "/_history/1", created.getHeaders().getLocation().toString());
            assertEquals(base + "Patient?family=Context", bundle.link().getFirst().url().value());
            assertEquals(base + "Patient/" + id, bundle.entry().getFirst().fullUrl().value());
        }
    }

    @Test
    void anApplicationFhirServerBeanReplacesTheDefault() {
        try (ConfigurableApplicationContext context = start(OwnServerApplication.class)) {
            CapabilityStatement statement = FhirJson.read(client(context).get().uri("/fhir/metadata")
                    .retrieve().body(String.class), CapabilityStatement.class);

            assertEquals(List.of("Observation"), statement.rest().getFirst().resource().stream()
                    .map(resource -> resource.type().valueAsString()).toList());
        }
    }

    @Test
    void ownControllersStillAnswer() {
        try (ConfigurableApplicationContext context = start(PatientApplication.class)) {
            RestClient client = client(context);

            assertEquals("hello", client.get().uri("/hello").retrieve().body(String.class));
            assertEquals(200, status(client, "/fhir/metadata"));
        }
    }

    @Test
    void anInvalidHandlerStopsTheApplication() {
        Exception e = assertThrows(Exception.class, () -> start(InvalidApplication.class).close());

        StringBuilder messages = new StringBuilder();
        for (Throwable t = e; t != null; t = t.getCause()) {
            messages.append(t.getMessage()).append('\n');
        }
        assertTrue(messages.toString().contains("@Read needs exactly one @Id parameter"), messages.toString());
    }
}
