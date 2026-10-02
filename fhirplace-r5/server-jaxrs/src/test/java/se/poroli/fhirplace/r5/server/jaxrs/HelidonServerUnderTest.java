package se.poroli.fhirplace.r5.server.jaxrs;

import io.helidon.microprofile.server.Server;
import java.net.URI;
import se.poroli.fhirplace.r5.server.shared.ServerUnderTest;

/** Runs the shared HTTP tests on Helidon MP, which discovers the test handlers as CDI beans. */
public final class HelidonServerUnderTest implements ServerUnderTest {

    @Override
    public URI start() {
        Server server = Server.builder().port(0).build().start();
        Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
        return URI.create("http://localhost:" + server.port() + "/fhir/");
    }
}
