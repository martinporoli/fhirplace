package se.poroli.fhirplace.r5.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

/** The FHIR search syntax that {@link Search} renders. */
class SearchTest {

    private static String decoded(Search search) {
        return URLDecoder.decode(search.toQuery(), StandardCharsets.UTF_8);
    }

    @Test
    void rendersAlternativesRepetitionsPrefixesAndTokens() {
        Search search = Search.where("given:exact", "Peter", "Pete")
                .and("birthdate", Search.ge(LocalDate.of(1970, 1, 1)))
                .and("birthdate", Search.lt(LocalDate.of(1980, 1, 1)))
                .and("identifier", Search.token("http://acme.org/mrn", "123"), Search.token(null, "456"))
                .count(50)
                .sort("-birthdate", "family");

        assertEquals("given:exact=Peter,Pete&birthdate=ge1970-01-01&birthdate=lt1980-01-01"
                + "&identifier=http://acme.org/mrn|123,456&_count=50&_sort=-birthdate,family", decoded(search));
    }

    @Test
    void escapesSpecialCharactersInPlainValues() {
        assertEquals("family=Smith\\, Jr&code=a\\|b,c\\$d&path=x\\\\y",
                decoded(Search.where("family", "Smith, Jr").and("code", "a|b", "c$d").and("path", "x\\y")));
    }

    @Test
    void encodesTheQueryForAUrl() {
        assertEquals("family=Smith%5C%2C%20Jr", Search.where("family", "Smith, Jr").toQuery());
    }
}
