package se.poroli.fhirplace.r5.server;

import java.util.List;

/** Validation shared by the search parameter records. */
final class SearchValues {

    private SearchValues() {
    }

    static <T> List<T> nonEmpty(List<T> values) {
        List<T> copy = List.copyOf(values);
        if (copy.isEmpty()) {
            throw new IllegalArgumentException("A search parameter needs at least one value");
        }
        return copy;
    }
}
