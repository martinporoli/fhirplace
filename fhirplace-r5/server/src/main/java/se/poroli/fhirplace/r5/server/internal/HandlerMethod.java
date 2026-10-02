package se.poroli.fhirplace.r5.server.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * A validated handler method.
 *
 * @param interaction the interaction it implements
 * @param method the method
 * @param bindings how each parameter is supplied, in parameter order
 */
record HandlerMethod(Interaction interaction, Method method, List<Binding> bindings) {

    HandlerMethod {
        bindings = List.copyOf(bindings);
    }

    Object invoke(Object bean, Object... arguments) {
        try {
            return method.invoke(bean, arguments);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Cannot call " + method + "; is its package exported or open?", e);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof RuntimeException runtime) {
                throw runtime;
            }
            if (cause instanceof Error error) {
                throw error;
            }
            throw new IllegalStateException(cause);
        }
    }

    /** Builds the argument array, supplying each binding through the given function. */
    Object[] arguments(java.util.function.Function<Binding, Object> supplier) {
        Object[] arguments = new Object[bindings.size()];
        for (int i = 0; i < arguments.length; i++) {
            arguments[i] = supplier.apply(bindings.get(i));
        }
        return arguments;
    }
}
