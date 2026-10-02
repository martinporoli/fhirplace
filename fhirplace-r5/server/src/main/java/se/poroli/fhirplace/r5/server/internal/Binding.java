package se.poroli.fhirplace.r5.server.internal;

/** How the server supplies one handler method parameter. */
sealed interface Binding {

    /** The logical id from the URL. */
    record Id() implements Binding {
    }

    /** The version id from a {@code _history} URL. */
    record VersionId() implements Binding {
    }

    /** The resource in the request body. */
    record Body() implements Binding {
    }

    /**
     * A search parameter.
     *
     * @param name the parameter name
     * @param type the parameter record class, such as {@code StringParam}
     * @param repeating whether the method parameter is a list of occurrences
     */
    record Search(String name, Class<?> type, boolean repeating) implements Binding {
    }
}
