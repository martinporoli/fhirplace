package se.poroli.fhirplace.r5.server.internal;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.rest.FhirHttpException;
import se.poroli.fhirplace.r5.server.DateParam;
import se.poroli.fhirplace.r5.server.FhirRequest;
import se.poroli.fhirplace.r5.server.ReferenceParam;
import se.poroli.fhirplace.r5.server.StringParam;
import se.poroli.fhirplace.r5.server.TokenParam;

/** Parses FHIR search parameters from a request and binds them to a search method. */
final class SearchParameters {

    /** Parameters that control the response rather than the search. */
    private static final Set<String> CONTROL = Set.of("_format", "_pretty", "_count", "_offset");

    /** Standard result parameters the server does not implement: rejected in strict mode, ignored when lenient. */
    private static final Set<String> UNSUPPORTED_RESULT = Set.of("_sort", "_summary", "_elements", "_include",
            "_revinclude", "_total", "_contained", "_containedType", "_maxresults", "_graph");

    private SearchParameters() {
    }

    /** One occurrence of a parameter in the request. */
    record Occurrence(String name, String modifier, String value) {

        String key() {
            return modifier == null ? name : name + ":" + modifier;
        }
    }

    /**
     * The bound arguments and the parameters that were used, for the Bundle's self link.
     *
     * @param arguments the method arguments
     * @param used the occurrences that were bound, in request order
     */
    record Bound(Object[] arguments, List<Occurrence> used) {

        String query() {
            StringJoiner query = new StringJoiner("&");
            for (Occurrence occurrence : used) {
                query.add(encode(occurrence.key()) + "=" + encode(occurrence.value()));
            }
            return query.toString();
        }
    }

    static Bound bind(HandlerMethod method, Map<String, List<String>> parameters, boolean lenient,
            FhirRequest request) {
        Map<String, List<Occurrence>> byName = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> parameter : parameters.entrySet()) {
            if (CONTROL.contains(parameter.getKey())) {
                continue;
            }
            int colon = parameter.getKey().indexOf(':');
            String name = colon < 0 ? parameter.getKey() : parameter.getKey().substring(0, colon);
            String modifier = colon < 0 ? null : parameter.getKey().substring(colon + 1);
            for (String value : parameter.getValue()) {
                if (value != null && !value.isEmpty()) {
                    byName.computeIfAbsent(name, n -> new ArrayList<>()).add(new Occurrence(name, modifier, value));
                }
            }
        }
        Set<String> declared = new java.util.HashSet<>();
        method.bindings().forEach(b -> {
            if (b instanceof Binding.Search search) {
                declared.add(search.name());
            }
        });
        if (!lenient) {
            for (String name : byName.keySet()) {
                if (UNSUPPORTED_RESULT.contains(name)) {
                    throw FhirHttpException.invalid("The result parameter '" + name + "' is not supported by this "
                            + "server. Send 'Prefer: handling=lenient' to ignore unsupported parameters.");
                }
                if (!declared.contains(name)) {
                    throw FhirHttpException.invalid("Unknown search parameter '" + name + "'. Supported: "
                            + new java.util.TreeSet<>(declared)
                            + ". Send 'Prefer: handling=lenient' to ignore unknown parameters.");
                }
            }
        }
        List<Occurrence> used = new ArrayList<>();
        Object[] arguments = method.arguments(binding -> {
            if (binding instanceof Binding.Request) {
                return request;
            }
            Binding.Search search = (Binding.Search) binding;
            List<Occurrence> occurrences = byName.getOrDefault(search.name(), List.of());
            if (!search.repeating() && occurrences.size() > 1) {
                throw FhirHttpException.invalid("Search parameter '" + search.name() + "' may appear only once");
            }
            List<Object> values = new ArrayList<>();
            for (Occurrence occurrence : occurrences) {
                values.add(parse(search.type(), occurrence));
                used.add(occurrence);
            }
            return search.repeating() ? List.copyOf(values) : (values.isEmpty() ? null : values.getFirst());
        });
        return new Bound(arguments, used);
    }

    static Object parse(Class<?> type, Occurrence occurrence) {
        List<String> alternatives = split(occurrence.value(), ',');
        try {
            if (type == StringParam.class) {
                return new StringParam(occurrence.modifier(), alternatives.stream().map(SearchParameters::unescape)
                        .toList());
            }
            if (type == ReferenceParam.class) {
                return new ReferenceParam(occurrence.modifier(),
                        alternatives.stream().map(SearchParameters::unescape).toList());
            }
            if (type == TokenParam.class) {
                return new TokenParam(occurrence.modifier(), alternatives.stream().map(SearchParameters::token)
                        .toList());
            }
            if (type == DateParam.class) {
                return new DateParam(occurrence.modifier(), alternatives.stream().map(SearchParameters::date)
                        .toList());
            }
        } catch (IllegalArgumentException e) {
            throw FhirHttpException.invalid("Invalid value '" + occurrence.value() + "' for search parameter '"
                    + occurrence.key() + "': " + e.getMessage());
        }
        throw new IllegalStateException("Unsupported search parameter type " + type);
    }

    private static TokenParam.Token token(String value) {
        List<String> parts = split(value, '|');
        if (parts.size() == 1) {
            return new TokenParam.Token(null, unescape(parts.getFirst()));
        }
        if (parts.size() != 2) {
            throw new IllegalArgumentException("a token has at most one unescaped '|'");
        }
        String code = parts.get(1).isEmpty() ? null : unescape(parts.get(1));
        return new TokenParam.Token(unescape(parts.getFirst()), code);
    }

    private static DateParam.Value date(String value) {
        DateParam.Prefix prefix = DateParam.Prefix.EQ;
        if (value.length() > 2 && Character.isLetter(value.charAt(0))) {
            String code = value.substring(0, 2).toUpperCase(Locale.ROOT);
            try {
                prefix = DateParam.Prefix.valueOf(code);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("unknown prefix '" + value.substring(0, 2) + "'");
            }
            value = value.substring(2);
        }
        return new DateParam.Value(prefix, FhirDateTime.parse(unescape(value)));
    }

    /** Splits on a separator that is not escaped with a backslash, keeping escapes in the parts. */
    static List<String> split(String value, char separator) {
        List<String> parts = new ArrayList<>();
        StringBuilder part = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == '\\' && i + 1 < value.length()) {
                part.append(c).append(value.charAt(++i));
            } else if (c == separator) {
                parts.add(part.toString());
                part.setLength(0);
            } else {
                part.append(c);
            }
        }
        parts.add(part.toString());
        return parts;
    }

    /** Removes the backslash escapes of {@code \,}, {@code \|}, {@code \$} and {@code \\}. */
    static String unescape(String value) {
        StringBuilder result = new StringBuilder(value.length());
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == '\\' && i + 1 < value.length() && ",|$\\".indexOf(value.charAt(i + 1)) >= 0) {
                result.append(value.charAt(++i));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
    }
}
