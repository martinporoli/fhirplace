package se.poroli.fhirplace.r5.server.internal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanContainer;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import se.poroli.fhirplace.r5.server.FhirException;
import se.poroli.fhirplace.r5.server.FhirResource;

/**
 * Finds the {@link FhirResource} beans when the application starts, validates them, and resolves request paths to
 * them.
 */
@ApplicationScoped
public class HandlerRegistry {

    private final BeanContainer beans;
    private Map<String, Registered> handlers;

    /**
     * Creates the registry.
     *
     * @param beans the CDI container
     */
    @Inject
    public HandlerRegistry(BeanContainer beans) {
        this.beans = beans;
    }

    /** CDI proxy constructor. */
    protected HandlerRegistry() {
        this.beans = null;
    }

    /**
     * Discovers and validates the handlers when the application starts, so invalid handlers fail deployment.
     *
     * @param event the application scope initialization event
     */
    void onStartup(@Observes @Initialized(ApplicationScoped.class) Object event) {
        handlers();
    }

    /**
     * Returns the handlers by resource type name, sorted.
     *
     * @return the handlers
     */
    public synchronized Map<String, Registered> handlers() {
        if (handlers == null) {
            handlers = discover();
        }
        return handlers;
    }

    /**
     * Returns the handler for a resource type in a request path.
     *
     * @param type the resource type from the URL
     * @return the handler
     * @throws FhirException 404 if the server does not support the type
     */
    public Registered require(String type) {
        Registered handler = handlers().get(type);
        if (handler == null) {
            throw new FhirException(404, se.poroli.fhirplace.r5.operationoutcome.IssueType.NOT_SUPPORTED,
                    "Resource type '" + type + "' is not supported by this server");
        }
        return handler;
    }

    private Map<String, Registered> discover() {
        List<String> problems = new ArrayList<>();
        Map<String, Registered> found = new TreeMap<>();
        for (Bean<?> bean : beans.getBeans(Object.class, Any.Literal.INSTANCE)) {
            Class<?> beanClass = bean.getBeanClass();
            if (!beanClass.isAnnotationPresent(FhirResource.class)) {
                continue;
            }
            Handler handler;
            try {
                handler = Handler.inspect(beanClass);
            } catch (IllegalStateException e) {
                problems.add(e.getMessage());
                continue;
            }
            Registered previous = found.get(handler.typeName());
            if (previous != null) {
                problems.add("Both " + previous.handler().beanClass().getName() + " and " + beanClass.getName()
                        + " handle " + handler.typeName());
                continue;
            }
            Object instance = beans.createInstance().select(beanClass, qualifiers(bean)).get();
            found.put(handler.typeName(), new Registered(handler, instance));
        }
        if (!problems.isEmpty()) {
            throw new IllegalStateException(String.join("\n", problems));
        }
        return java.util.Collections.unmodifiableMap(found);
    }

    private static java.lang.annotation.Annotation[] qualifiers(Bean<?> bean) {
        Collection<java.lang.annotation.Annotation> qualifiers = bean.getQualifiers();
        return qualifiers.toArray(new java.lang.annotation.Annotation[0]);
    }

    /**
     * A handler with the bean instance (a client proxy for normal-scoped beans) to call.
     *
     * @param handler the handler
     * @param instance the bean instance
     */
    public record Registered(Handler handler, Object instance) {

        /**
         * Returns the method for an interaction.
         *
         * @param interaction the interaction
         * @return the method
         * @throws FhirException 405 if the handler does not implement the interaction
         */
        HandlerMethod require(Interaction interaction) {
            return method(interaction).orElseThrow(() -> new FhirException(405,
                    se.poroli.fhirplace.r5.operationoutcome.IssueType.NOT_SUPPORTED,
                    "The " + interaction.code().code() + " interaction is not supported for "
                            + handler.typeName()));
        }

        Optional<HandlerMethod> method(Interaction interaction) {
            return handler.method(interaction);
        }
    }
}
