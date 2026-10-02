/**
 * FHIR RESTful server API: annotate a CDI bean with {@link se.poroli.fhirplace.r5.server.FhirResource} and its methods
 * with interaction annotations such as {@link se.poroli.fhirplace.r5.server.Read} and
 * {@link se.poroli.fhirplace.r5.server.Search}. The server routes FHIR requests under the application's Jakarta REST
 * path to these methods, reads and writes FHIR JSON and XML, sets {@code ETag}, {@code Location} and
 * {@code Last-Modified}, honours {@code Prefer}, {@code If-Match}, {@code If-None-Match} and {@code If-Modified-Since},
 * reports errors as {@code OperationOutcome}, and serves a generated {@code CapabilityStatement} at
 * {@code [base]/metadata}.
 *
 * @see <a href="https://hl7.org/fhir/R5/http.html">FHIR R5 RESTful API</a>
 */
package se.poroli.fhirplace.r5.server;
