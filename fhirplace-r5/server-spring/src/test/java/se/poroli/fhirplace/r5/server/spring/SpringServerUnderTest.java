package se.poroli.fhirplace.r5.server.spring;

import java.net.URI;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.poroli.fhirplace.r5.server.shared.ObservationHandler;
import se.poroli.fhirplace.r5.server.shared.PatientHandler;
import se.poroli.fhirplace.r5.server.shared.ServerUnderTest;

/** Runs the shared HTTP tests on Spring Boot with an embedded web server and the auto-configuration. */
public final class SpringServerUnderTest implements ServerUnderTest {

    /** The test application: the shared handlers as beans. */
    @Configuration
    @EnableAutoConfiguration
    static class TestApplication {

        @Bean
        PatientHandler patientHandler() {
            return new PatientHandler();
        }

        @Bean
        ObservationHandler observationHandler() {
            return new ObservationHandler();
        }
    }

    @Override
    public URI start() {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(TestApplication.class)
                .properties("server.port=0", "spring.main.banner-mode=off")
                .run();
        Runtime.getRuntime().addShutdownHook(new Thread(context::close));
        String port = context.getEnvironment().getProperty("local.server.port");
        return URI.create("http://localhost:" + port + "/fhir/");
    }
}
