/**
 * Profiles as code. A {@link se.poroli.fhirplace.r5.validation.Validator} holds typed rules over the FHIR model; its
 * {@link se.poroli.fhirplace.r5.validation.ValidationResult} lists located
 * {@link se.poroli.fhirplace.r5.validation.Issue}s with optional coded details, diagnostics and expressions, and can
 * become an OperationOutcome. Validation is independent of HTTP; callers decide how to handle invalid results.
 *
 * <pre>{@code
 * ValidationResult result = validator.validate(patient);
 * // In a server handler, using se.poroli.fhirplace.r5.rest.FhirHttpException:
 * if (!result.isValid()) {
 *     throw FhirHttpException.unprocessable(result.toOperationOutcome());
 * }
 * }</pre>
 */
package se.poroli.fhirplace.r5.validation;
