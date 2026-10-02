package se.poroli.fhirplace.r5.server.jaxrs;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.enterprise.inject.se.SeContainer;
import java.util.Optional;
import org.jboss.weld.environment.se.Weld;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.Read;

/** An invalid handler fails CDI container startup, with a message naming the problem. */
class InvalidHandlerTest {

    /**
     * No bean-defining annotation, so the shared Helidon server's annotated discovery skips it; the test adds it to its
     * own container explicitly.
     */
    @FhirResource(Bundle.class)
    public static class HandlerWithoutId {
        @Read
        public Optional<Bundle> read(String id) {
            return Optional.empty();
        }
    }

    @Test
    void containerDoesNotStart() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> {
            // A separate Weld container: the shared Helidon server already runs in this JVM.
            SeContainer container = new Weld("invalid-handler")
                    .disableDiscovery()
                    .addBeanClasses(FhirServerBean.class, HandlerWithoutId.class)
                    .initialize();
            container.close();
        });

        String messages = messages(e);
        assertTrue(messages.contains("Invalid FHIR handler"), messages);
        assertTrue(messages.contains("@Read needs exactly one @Id parameter"), messages);
    }

    private static String messages(Throwable e) {
        StringBuilder messages = new StringBuilder();
        for (Throwable t = e; t != null; t = t.getCause()) {
            messages.append(t.getMessage()).append('\n');
        }
        return messages.toString();
    }
}
