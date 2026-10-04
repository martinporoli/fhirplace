package se.poroli.fhirplace.r5.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

/**
 * {@code searchAll} follows {@code next} links lazily, against a server that answers with three pages, and only on the
 * client's own server.
 */
class PagingTest {

    private static final AtomicInteger REQUESTS = new AtomicInteger();

    private static final URI BASE = TestServers.start("/paged/", exchange -> {
        REQUESTS.incrementAndGet();
        String query = exchange.getRequestURI().getQuery();
        int page = query != null && query.contains("page=")
                ? Integer.parseInt(query.replaceAll(".*page=(\\d+).*", "$1")) : 1;
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
            String next = "Patient?family=x&page=" + (page + 1);                // relative from page 2 on
            bundle.addLink(Bundle.Link.builder().relation(LinkRelationTypes.NEXT)
                    .url(FhirUri.of(page == 1 ? base + next : next)).build());
        }
        TestServers.respond(exchange, 200, Map.of("Content-Type", List.of("application/fhir+json")),
                FhirJson.write(bundle.build()).getBytes(StandardCharsets.UTF_8));
    });

    private static final AtomicInteger OTHER_REQUESTS = new AtomicInteger();

    private static final URI OTHER = TestServers.start("/other/", exchange -> {
        OTHER_REQUESTS.incrementAndGet();
        TestServers.respond(exchange, 200, Map.of("Content-Type", List.of("application/fhir+json")),
                FhirJson.write(Bundle.builder().type(BundleType.SEARCHSET).build()).getBytes(StandardCharsets.UTF_8));
    });

    /** A server whose first page links to {@link #OTHER}, on another port. */
    private static final URI LEAVING = TestServers.start("/leaving/", exchange -> {
        Bundle bundle = Bundle.builder().type(BundleType.SEARCHSET)
                .addEntry(match("p1a"))
                .addLink(Bundle.Link.builder().relation(LinkRelationTypes.NEXT)
                        .url(FhirUri.of(OTHER + "Patient?page=2")).build())
                .build();
        TestServers.respond(exchange, 200, Map.of("Content-Type", List.of("application/fhir+json")),
                FhirJson.write(bundle).getBytes(StandardCharsets.UTF_8));
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
        try (Stream<Patient> all = FhirClient.of(BASE).searchAll(Patient.class, SearchQuery.where("family", "x"))) {
            assertEquals(List.of("p1a", "p1b", "p2a", "p2b", "p3a", "p3b"), all.map(Patient::id).toList());
        }
        assertEquals(3, REQUESTS.get());
    }

    @Test
    void fetchesPagesOnlyWhenNeeded() {
        REQUESTS.set(0);
        try (Stream<Patient> all = FhirClient.of(BASE).searchAll(Patient.class, SearchQuery.where("family", "x"))) {
            assertEquals(List.of("p1a", "p1b"), all.limit(2).map(Patient::id).toList());
        }
        assertEquals(1, REQUESTS.get());
    }

    @Test
    void sendsNoRequestUntilConsumed() {
        REQUESTS.set(0);
        try (Stream<Patient> all = FhirClient.of(BASE).searchAll(Patient.class, SearchQuery.where("family", "x"))) {
            assertEquals(0, REQUESTS.get());
        }
        assertEquals(0, REQUESTS.get());
    }

    @Test
    void refusesNextLinkToAnotherServer() {
        OTHER_REQUESTS.set(0);
        FhirClient fhir = FhirClient.of(LEAVING).withHeader("Authorization", "Bearer secret");
        try (Stream<Patient> all = fhir.searchAll(Patient.class, SearchQuery.where("family", "x"))) {
            IllegalStateException e = assertThrows(IllegalStateException.class, () -> all.toList());
            assertTrue(e.getMessage().contains(OTHER.toString()), e.getMessage());
        }
        assertEquals(0, OTHER_REQUESTS.get());
    }
}
