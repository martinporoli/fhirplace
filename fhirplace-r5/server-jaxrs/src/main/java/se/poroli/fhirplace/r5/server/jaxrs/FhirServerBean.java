package se.poroli.fhirplace.r5.server.jaxrs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.FhirServer;

/** Builds the {@link FhirServer} from the application's {@link FhirResource} beans when the application starts. */
@ApplicationScoped
public class FhirServerBean {

    private final Instance<Object> beans;
    private FhirServer server;

    /**
     * Creates the bean.
     *
     * @param beans all beans; an {@code @Any Instance<Object>} injection point also keeps build-time containers
     *     such as Quarkus from removing handler beans that nothing else injects
     */
    @Inject
    public FhirServerBean(@Any Instance<Object> beans) {
        this.beans = beans;
    }

    /** CDI proxy constructor. */
    protected FhirServerBean() {
        this.beans = null;
    }

    /**
     * Builds the server when the application starts, so invalid handlers fail deployment.
     *
     * @param event the application scope initialization event
     */
    void onStartup(@Observes @Initialized(ApplicationScoped.class) Object event) {
        server();
    }

    /**
     * Returns the server, built on first use.
     *
     * @return the server
     * @throws IllegalStateException if a handler is invalid
     */
    public synchronized FhirServer server() {
        if (server == null) {
            FhirServer.Builder builder = FhirServer.builder();
            for (Instance.Handle<Object> handle : beans.handles()) {
                if (handle.getBean().getBeanClass().isAnnotationPresent(FhirResource.class)) {
                    builder.handler(handle.get());
                }
            }
            server = builder.build();
        }
        return server;
    }
}
