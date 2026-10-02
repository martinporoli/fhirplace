package se.poroli.fhirplace.r5.client;

/** The FHIR representation a client sends and asks for. */
public enum FhirFormat {
    /** FHIR JSON, {@code application/fhir+json}. */
    JSON("application/fhir+json"),
    /** FHIR XML, {@code application/fhir+xml}. */
    XML("application/fhir+xml");

    private final String mediaType;

    FhirFormat(String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * Returns the media type.
     *
     * @return the media type, such as {@code application/fhir+json}
     */
    public String mediaType() {
        return mediaType;
    }
}
