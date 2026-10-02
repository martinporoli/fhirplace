package se.poroli.fhirplace.r5.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.bundle.BundleType;
import se.poroli.fhirplace.r5.bundle.LinkRelationTypes;
import se.poroli.fhirplace.r5.bundle.SearchEntryMode;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.patient.Patient;

/** {@code searchAll} follows {@code next} links lazily, against a server that answers with three pages. */
class PagingTest {

    private static final AtomicInteger REQUESTS = new AtomicInteger();

    private static final URI BASE = TestServers.start("/paged/", exchange -> {
        REQUESTS.incrementAndGet();
        String query = exchange.getRequestURI().getQuery();
        int page = query != null && query.contains("page=") ? Integer.parseInt(query.replaceAll(".*page=(\\d+).*", "$1"))
                : 1;
        URI base = TestServers.base(exchange, "/paged/");
        Bundle.Builder bundle = Bundle.builder().type(BundleType.SEARCHSET)
                .addEntry(match("p" + page + "a"))
                .addEntry(match("p" + page + "b"));
        if (page == 1) {
            bundle.addEntry(Bundle.Entry.builder()
                    .resource(Patient.builder().id("included").build())
                    .search(Bundle.Entry.Search.builder().mode(SearchEntryMode.INCLUDE).build())
                    .build());
            bundle.addEntry(Bundle.Entry.builder()
                    .resource(OperationOutcome.builder().addIssue(OperationOutcome.Issue.builder()
                            .severity(IssueSeverity.WARNING).code(IssueType.INFORMATIONAL).build()).build())
                    .search(Bundle.Entry.Search.builder().mode(SearchEntryMode.OUTCOME).build())
                    .build());
        }
        if (page < 3) {
            bundle.addLink(Bundle.Link.builder().relation(LinkRelationTypes.NEXT)
                    .url(FhirUri.of(base + "Patient?family=x&page=" + (page + 1))).build());
        }
        TestServers.respond(exchange, 200, Map.of("Content-Type", List.of("application/fhir+json")),
                FhirJson.write(bundle.build()).getBytes(StandardCharsets.UTF_8));
    });

    private static Bundle.Entry match(String id) {
        return Bundle.Entry.builder()
                .resource(Patient.builder().id(id).build())
                .search(Bundle.Entry.Search.builder().mode(SearchEntryMode.MATCH).build())
                .build();
    }

    @Test
    void followsNextLinksAndSkipsIncludesAndOutcomes() {
        REQUESTS.set(0);
        try (Stream<Patient> all = FhirClient.of(BASE).searchAll(Patient.class, Search.where("family", "x"))) {
            assertEquals(List.of("p1a", "p1b", "p2a", "p2b", "p3a", "p3b"), all.map(Patient::id).toList());
        }
        assertEquals(3, REQUESTS.get());
    }

    @Test
    void fetchesPagesOnlyWhenNeeded() {
        REQUESTS.set(0);
        try (Stream<Patient> all = FhirClient.of(BASE).searchAll(Patient.class, Search.where("family", "x"))) {
            assertEquals(List.of("p1a", "p1b"), all.limit(2).map(Patient::id).toList());
        }
        assertEquals(1, REQUESTS.get());
    }
}
