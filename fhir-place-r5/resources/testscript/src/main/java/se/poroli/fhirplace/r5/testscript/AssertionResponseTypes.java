package se.poroli.fhirplace.r5.testscript;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The type of response code to use for assertion.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/assert-response-code-types">FHIR R5 AssertionResponseTypes</a>
 */
public enum AssertionResponseTypes implements CodedEnum {

    /** Response code is 100. */
    CONTINUE("continue", "Continue"),

    /** Response code is 101. */
    SWITCHING_PROTOCOLS("switchingProtocols", "Switching Protocols"),

    /** Response code is 200. */
    OKAY("okay", "OK"),

    /** Response code is 201. */
    CREATED("created", "Created"),

    /** Response code is 202. */
    ACCEPTED("accepted", "Accepted"),

    /** Response code is 203. */
    NON_AUTHORITATIVE_INFORMATION("nonAuthoritativeInformation", "Non-Authoritative Information"),

    /** Response code is 204. */
    NO_CONTENT("noContent", "No Content"),

    /** Response code is 205. */
    RESET_CONTENT("resetContent", "Reset Content"),

    /** Response code is 206. */
    PARTIAL_CONTENT("partialContent", "Partial Content"),

    /** Response code is 300. */
    MULTIPLE_CHOICES("multipleChoices", "Multiple Choices"),

    /** Response code is 301. */
    MOVED_PERMANENTLY("movedPermanently", "Moved Permanently"),

    /** Response code is 302. */
    FOUND("found", "Found"),

    /** Response code is 303. */
    SEE_OTHER("seeOther", "See Other"),

    /** Response code is 304. */
    NOT_MODIFIED("notModified", "Not Modified"),

    /** Response code is 305. */
    USE_PROXY("useProxy", "Use Proxy"),

    /** Response code is 307. */
    TEMPORARY_REDIRECT("temporaryRedirect", "Temporary Redirect"),

    /** Response code is 308. */
    PERMANENT_REDIRECT("permanentRedirect", "Permanent Redirect"),

    /** Response code is 400. */
    BAD_REQUEST("badRequest", "Bad Request"),

    /** Response code is 401. */
    UNAUTHORIZED("unauthorized", "Unauthorized"),

    /** Response code is 402. */
    PAYMENT_REQUIRED("paymentRequired", "Payment Required"),

    /** Response code is 403. */
    FORBIDDEN("forbidden", "Forbidden"),

    /** Response code is 404. */
    NOT_FOUND("notFound", "Not Found"),

    /** Response code is 405. */
    METHOD_NOT_ALLOWED("methodNotAllowed", "Method Not Allowed"),

    /** Response code is 406. */
    NOT_ACCEPTABLE("notAcceptable", "Not Acceptable"),

    /** Response code is 407. */
    PROXY_AUTHENTICATION_REQUIRED("proxyAuthenticationRequired", "Proxy Authentication Required"),

    /** Response code is 408. */
    REQUEST_TIMEOUT("requestTimeout", "Request Timeout"),

    /** Response code is 409. */
    CONFLICT("conflict", "Conflict"),

    /** Response code is 410. */
    GONE("gone", "Gone"),

    /** Response code is 411. */
    LENGTH_REQUIRED("lengthRequired", "Length Required"),

    /** Response code is 412. */
    PRECONDITION_FAILED("preconditionFailed", "Precondition Failed"),

    /** Response code is 413. */
    CONTENT_TOO_LARGE("contentTooLarge", "Content Too Large"),

    /** Response code is 414. */
    URI_TOO_LONG("uriTooLong", "URI Too Long"),

    /** Response code is 415. */
    UNSUPPORTED_MEDIA_TYPE("unsupportedMediaType", "Unsupported Media Type"),

    /** Response code is 416. */
    RANGE_NOT_SATISFIABLE("rangeNotSatisfiable", "Range Not Satisfiable"),

    /** Response code is 417. */
    EXPECTATION_FAILED("expectationFailed", "Expectation Failed"),

    /** Response code is 421. */
    MISDIRECTED_REQUEST("misdirectedRequest", "Misdirected Request"),

    /** Response code is 422. */
    UNPROCESSABLE_CONTENT("unprocessableContent", "Unprocessable Content"),

    /** Response code is 426. */
    UPGRADE_REQUIRED("upgradeRequired", "Upgrade Required"),

    /** Response code is 500. */
    INTERNAL_SERVER_ERROR("internalServerError", "Internal Server Error"),

    /** Response code is 501. */
    NOT_IMPLEMENTED("notImplemented", "Not Implemented"),

    /** Response code is 502. */
    BAD_GATEWAY("badGateway", "Bad Gateway"),

    /** Response code is 503. */
    SERVICE_UNAVAILABLE("serviceUnavailable", "Service Unavailable"),

    /** Response code is 504. */
    GATEWAY_TIMEOUT("gatewayTimeout", "Gateway Timeout"),

    /** Response code is 505. */
    HTTP_VERSION_NOT_SUPPORTED("httpVersionNotSupported", "HTTP Version Not Supported");

    private final String code;
    private final String display;

    AssertionResponseTypes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/assert-response-code-types";
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String display() {
        return display;
    }

    /**
     * Returns the constant for a code.
     *
     * @param code the code, which is case-sensitive
     * @return the constant
     * @throws IllegalArgumentException if the code system does not define the code
     */
    public static AssertionResponseTypes fromCode(String code) {
        for (AssertionResponseTypes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AssertionResponseTypes code: '" + code + "'");
    }
}
