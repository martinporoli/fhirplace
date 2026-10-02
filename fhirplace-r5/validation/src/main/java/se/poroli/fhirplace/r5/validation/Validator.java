package se.poroli.fhirplace.r5.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;

/**
 * Validation rules for one type, typically a resource and the rules of a profile, written as code:
 *
 * <pre>{@code
 * static final Validator<Patient> SE_PATIENT = Validator.builder(Patient.class)
 *         .rule("se-1", p -> !p.identifier().isEmpty(),
 *                 Issue.error(IssueType.REQUIRED, "An identifier is required").at("identifier"))
 *         .each(Patient::name, "name", Validator.builder(HumanName.class)
 *                 .rule("se-2", n -> n.family() != null,
 *                         Issue.error(IssueType.REQUIRED, "Family name is required").at("family"))
 *                 .build())
 *         .build();
 *
 * SE_PATIENT.validate(patient).throwIfInvalid();   // in a server handler: 422 with an OperationOutcome
 * }</pre>
 *
 * <p>A validator is immutable and thread-safe, so it can be a shared constant. Issues are located with FHIRPath-style
 * expressions that start at the validated type, such as {@code Patient.name[1].family}. Every rule has an id, unique
 * within the validator, by which {@link #withMessage}, {@link #withSeverity} and {@link #without} adjust validators
 * that are reused rather than written.
 *
 * @param <T> the validated type
 */
public final class Validator<T> {

    private final Class<T> type;
    private final List<Step<T>> steps;
    private final Map<String, UnaryOperator<Issue>> adjustments;

    private Validator(Class<T> type, List<Step<T>> steps, Map<String, UnaryOperator<Issue>> adjustments) {
        this.type = type;
        this.steps = List.copyOf(steps);
        this.adjustments = Map.copyOf(adjustments);
    }

    /** One part of a validator: a rule, a check, or a validator for elements. */
    private sealed interface Step<T> {
    }

    private record Rule<T>(String id, Predicate<? super T> holds, Issue issue) implements Step<T> {
    }

    private record Check<T>(String id, BiConsumer<? super T, Report> check) implements Step<T> {
    }

    private record Elements<T, E>(Function<? super T, ? extends List<E>> elements, String path, Validator<E> validator)
            implements Step<T> {
    }

    private record Element<T, E>(Function<? super T, ? extends E> element, String path, Validator<E> validator)
            implements Step<T> {
    }

    private record Included<T>(Validator<? super T> validator) implements Step<T> {
    }

    /**
     * Returns a builder for a validator of the given type.
     *
     * @param type the validated class, such as {@code Patient.class}
     * @param <T> the validated type
     * @return a new builder
     */
    public static <T> Builder<T> builder(Class<T> type) {
        return new Builder<>(Objects.requireNonNull(type, "type"), List.of());
    }

    /**
     * Returns a builder with this validator's rules, to add more.
     *
     * @return a new builder
     */
    public Builder<T> toBuilder() {
        Builder<T> builder = new Builder<>(type, steps);
        builder.adjustments.putAll(adjustments);
        return builder;
    }

    /**
     * Validates a value.
     *
     * @param value the value
     * @return the issues found, located from the value's type, such as {@code Patient.name[0].family}
     */
    public ValidationResult validate(T value) {
        List<Issue> issues = new ArrayList<>();
        validate(Objects.requireNonNull(value, "value"), type.getSimpleName(), issues);
        return new ValidationResult(issues);
    }

    private void validate(T value, String path, List<Issue> out) {
        List<Issue> issues = new ArrayList<>();
        for (Step<T> step : steps) {
            run(step, value, path, issues);
        }
        for (Issue issue : issues) {
            UnaryOperator<Issue> adjustment = issue.ruleId() == null ? null : adjustments.get(issue.ruleId());
            Issue adjusted = adjustment == null ? issue : adjustment.apply(issue);
            if (adjusted != null) {
                out.add(adjusted);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void run(Step<T> step, T value, String path, List<Issue> out) {
        switch (step) {
            case Rule<T> rule -> {
                if (!rule.holds().test(value)) {
                    out.add(locate(rule.issue(), rule.id(), path));
                }
            }
            case Check<T> check -> {
                Report report = new Report();
                check.check().accept(value, report);
                report.issues().forEach(issue -> out.add(locate(issue, check.id(), path)));
            }
            case Elements<T, ?> elements -> validateEach((Elements<T, Object>) elements, value, path, out);
            case Element<T, ?> element -> {
                Object child = element.element().apply(value);
                if (child != null) {
                    ((Validator<Object>) element.validator()).validate(child, path + "." + element.path(), out);
                }
            }
            case Included<T> included -> ((Validator<Object>) included.validator()).validate(value, path, out);
        }
    }

    private static <T> void validateEach(Elements<T, Object> elements, T value, String path, List<Issue> out) {
        List<?> children = elements.elements().apply(value);
        if (children == null) {
            return;
        }
        for (int i = 0; i < children.size(); i++) {
            Object child = children.get(i);
            if (child != null) {
                elements.validator().validate(child, path + "." + elements.path() + "[" + i + "]", out);
            }
        }
    }

    private static Issue locate(Issue issue, String ruleId, String path) {
        String relative = issue.expression();
        String expression = relative == null || relative.isEmpty() ? path
                : relative.startsWith("[") ? path + relative : path + "." + relative;
        return new Issue(ruleId, issue.severity(), issue.code(), issue.message(), expression);
    }

    /**
     * Returns a validator that also applies another validator's rules.
     *
     * @param other the other validator
     * @return the combined validator
     * @throws IllegalArgumentException if both have a rule with the same id
     */
    public Validator<T> and(Validator<? super T> other) {
        return toBuilder().include(other).build();
    }

    /**
     * Returns a validator that reports a rule's issues with another message.
     *
     * @param ruleId the rule's id, here or in a validator this one uses for elements
     * @param message the new message
     * @return the adjusted validator
     * @throws IllegalArgumentException if there is no such rule
     */
    public Validator<T> withMessage(String ruleId, String message) {
        Objects.requireNonNull(message, "message");
        return adjust(ruleId, issue -> new Issue(issue.ruleId(), issue.severity(), issue.code(), message,
                issue.expression()));
    }

    /**
     * Returns a validator that reports a rule's issues with another severity, such as a warning instead of an error.
     *
     * @param ruleId the rule's id, here or in a validator this one uses for elements
     * @param severity the new severity
     * @return the adjusted validator
     * @throws IllegalArgumentException if there is no such rule
     */
    public Validator<T> withSeverity(String ruleId, IssueSeverity severity) {
        Objects.requireNonNull(severity, "severity");
        return adjust(ruleId, issue -> new Issue(issue.ruleId(), severity, issue.code(), issue.message(),
                issue.expression()));
    }

    /**
     * Returns a validator without a rule.
     *
     * @param ruleId the rule's id, here or in a validator this one uses for elements
     * @return the adjusted validator
     * @throws IllegalArgumentException if there is no such rule
     */
    public Validator<T> without(String ruleId) {
        return adjust(ruleId, issue -> null);
    }

    private Validator<T> adjust(String ruleId, UnaryOperator<Issue> adjustment) {
        if (!ruleIds().contains(Objects.requireNonNull(ruleId, "ruleId"))) {
            throw new IllegalArgumentException("No rule '" + ruleId + "' in this validator; rules: " + ruleIds());
        }
        Map<String, UnaryOperator<Issue>> adjusted = new HashMap<>(adjustments);
        adjusted.merge(ruleId, adjustment, (first, second) -> issue -> {
            Issue once = first.apply(issue);
            return once == null ? null : second.apply(once);
        });
        return new Validator<>(type, steps, adjusted);
    }

    /**
     * Returns the ids of all rules, including those of the validators this one uses for elements.
     *
     * @return the rule ids
     */
    public Set<String> ruleIds() {
        Set<String> ids = new HashSet<>();
        collectIds(ids);
        return Set.copyOf(ids);
    }

    private void collectIds(Set<String> ids) {
        for (Step<T> step : steps) {
            switch (step) {
                case Rule<T> rule -> ids.add(rule.id());
                case Check<T> check -> ids.add(check.id());
                case Elements<T, ?> elements -> elements.validator().collectIds(ids);
                case Element<T, ?> element -> element.validator().collectIds(ids);
                case Included<T> included -> included.validator().collectIds(ids);
            }
        }
    }

    /**
     * Collects the rules of a validator.
     *
     * @param <T> the validated type
     */
    public static final class Builder<T> {

        private final Class<T> type;
        private final List<Step<T>> steps;
        private final Map<String, UnaryOperator<Issue>> adjustments = new HashMap<>();

        private Builder(Class<T> type, List<Step<T>> steps) {
            this.type = type;
            this.steps = new ArrayList<>(steps);
        }

        /**
         * Adds a rule: when the predicate does not hold, the issue is reported.
         *
         * @param id the rule's id, unique within the validator, such as {@code se-1}
         * @param holds the condition a valid value meets
         * @param issue the issue to report otherwise; its expression is relative to the validated value
         * @return this builder
         */
        public Builder<T> rule(String id, Predicate<? super T> holds, Issue issue) {
            steps.add(new Rule<>(Objects.requireNonNull(id, "id"), Objects.requireNonNull(holds, "holds"),
                    Objects.requireNonNull(issue, "issue")));
            return this;
        }

        /**
         * Adds a check that may report any number of issues, for rules whose messages depend on the value.
         *
         * @param id the check's id, unique within the validator; every issue it reports carries it
         * @param check reports issues for a value; their expressions are relative to the value
         * @return this builder
         */
        public Builder<T> check(String id, BiConsumer<? super T, Report> check) {
            steps.add(new Check<>(Objects.requireNonNull(id, "id"), Objects.requireNonNull(check, "check")));
            return this;
        }

        /**
         * Validates each element of a list with another validator, located as {@code path[index]}.
         *
         * @param elements the list, such as {@code Patient::name}; {@code null} lists and elements are skipped
         * @param path the element's name, such as {@code name}
         * @param validator the validator for each element
         * @param <E> the element type
         * @return this builder
         */
        public <E> Builder<T> each(Function<? super T, ? extends List<E>> elements, String path,
                Validator<E> validator) {
            steps.add(new Elements<>(Objects.requireNonNull(elements, "elements"), Objects.requireNonNull(path, "path"),
                    Objects.requireNonNull(validator, "validator")));
            return this;
        }

        /**
         * Validates a single element with another validator, located as {@code path}.
         *
         * @param element the element, such as {@code Patient::maritalStatus}; {@code null} is skipped
         * @param path the element's name, such as {@code maritalStatus}
         * @param validator the validator for the element
         * @param <E> the element type
         * @return this builder
         */
        public <E> Builder<T> nested(Function<? super T, ? extends E> element, String path, Validator<E> validator) {
            steps.add(new Element<>(Objects.requireNonNull(element, "element"), Objects.requireNonNull(path, "path"),
                    Objects.requireNonNull(validator, "validator")));
            return this;
        }

        /**
         * Adds all rules of another validator for the same value.
         *
         * @param validator the validator to include
         * @return this builder
         */
        public Builder<T> include(Validator<? super T> validator) {
            steps.add(new Included<>(Objects.requireNonNull(validator, "validator")));
            return this;
        }

        /**
         * Builds the validator.
         *
         * @return the validator
         * @throws IllegalArgumentException if two rules or checks have the same id
         */
        public Validator<T> build() {
            Set<String> ids = new HashSet<>();
            Set<String> duplicates = new HashSet<>();
            for (Step<T> step : steps) {
                Set<String> stepIds = switch (step) {
                    case Rule<T> rule -> Set.of(rule.id());
                    case Check<T> check -> Set.of(check.id());
                    case Included<T> included -> included.validator().ruleIds();
                    case Elements<T, ?> elements -> Set.of();
                    case Element<T, ?> element -> Set.of();
                };
                for (String id : stepIds) {
                    if (!ids.add(id)) {
                        duplicates.add(id);
                    }
                }
            }
            if (!duplicates.isEmpty()) {
                throw new IllegalArgumentException("Rule ids must be unique; duplicated: " + duplicates);
            }
            return new Validator<>(type, steps, adjustments);
        }
    }
}
