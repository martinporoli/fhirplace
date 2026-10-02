package se.poroli.fhirplace.examples.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A FHIR server on Spring Boot. Depending on {@code fhirplace-r5-server-spring} is all the setup needed: its
 * auto-configuration serves every {@code @FhirResource} bean under {@code fhirplace.server.path}.
 */
@SpringBootApplication
public class FhirApplication {

    public static void main(String[] args) {
        SpringApplication.run(FhirApplication.class, args);
    }
}
