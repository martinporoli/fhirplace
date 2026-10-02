package se.poroli.fhirplace.r5.server.quarkus;

import java.net.URI;
import org.eclipse.microprofile.config.ConfigProvider;
import se.poroli.fhirplace.r5.server.shared.ServerUnderTest;

/** The Quarkus application that {@code @QuarkusTest} starts; the shared tests send their requests to it. */
public final class QuarkusServerUnderTest implements ServerUnderTest {

    @Override
    public URI start() {
        int port = ConfigProvider.getConfig().getOptionalValue("quarkus.http.test-port", Integer.class).orElse(8081);
        return URI.create("http://localhost:" + port + "/fhir/");
    }
}
