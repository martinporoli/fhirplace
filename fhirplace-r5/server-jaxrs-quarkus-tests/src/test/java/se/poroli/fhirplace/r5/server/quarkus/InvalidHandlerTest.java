package se.poroli.fhirplace.r5.server.quarkus;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.quarkus.test.QuarkusProdModeTest;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.Read;

/**
 * An invalid handler stops a Quarkus application from starting, with a message naming the problem. The application
 * is built and started as a separate process, like in production.
 */
class InvalidHandlerTest {

    @ApplicationScoped
    @FhirResource(Bundle.class)
    public static class HandlerWithoutId {
        @Read
        public Optional<Bundle> read(String id) {
            return Optional.empty();
        }
    }

    @RegisterExtension
    static final QuarkusProdModeTest APPLICATION = new QuarkusProdModeTest()
            .withApplicationRoot(jar -> jar.addClasses(HandlerWithoutId.class))
            .setApplicationName("invalid-handler")
            .setApplicationVersion("0")
            .overrideConfigKey("quarkus.arc.exclude-types", "none.Excluded")
            .setExpectExit(true)
            .setRun(true);

    @Test
    void applicationDoesNotStart() {
        String output = APPLICATION.getStartupConsoleOutput();

        assertNotEquals(0, APPLICATION.getExitCode());
        assertTrue(output.contains("Invalid FHIR handler"), output);
        assertTrue(output.contains("@Read needs exactly one @Id parameter"), output);
    }
}
