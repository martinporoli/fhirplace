package se.poroli.fhirplace.r5.server;

import java.util.List;

/**
 * One occurrence of a FHIR {@code token} search parameter, such as {@code identifier=http://acme.org|123} or
 * {@code gender=female,male}.
 *
 * @param modifier the modifier after the colon, such as {@code not} or {@code text}, or {@code null}
 * @param anyOf the comma-separated alternatives; at least one
 * @see <a href="https://hl7.org/fhir/R5/search.html#token">FHIR R5 token search</a>
 */
public record TokenParam(String modifier, List<Token> anyOf) {

    /**
     * Creates the parameter, copying the values.
     *
     * @throws IllegalArgumentException if there are no values
     */
    public TokenParam {
        anyOf = SearchValues.nonEmpty(anyOf);
    }

    /**
     * One token value, {@code [system]|[code]}, {@code [code]}, {@code |[code]} or {@code [system]|}.
     *
     * @param system the system; {@code null} for any system ({@code [code]}), empty for no system ({@code |[code]})
     * @param code the code, or {@code null} for any code in the system ({@code [system]|})
     */
    public record Token(String system, String code) {

        /**
         * Creates the token.
         *
         * @throws IllegalArgumentException if both system and code are {@code null}
         */
        public Token {
            if (system == null && code == null) {
                throw new IllegalArgumentException("A token needs a system or a code");
            }
        }
    }
}
