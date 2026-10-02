package se.poroli.fhirplace.r5.foundation.other;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.BackboneElement;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.valuesets.BundleType;
import se.poroli.fhirplace.r5.valuesets.HTTPVerb;
import se.poroli.fhirplace.r5.valuesets.LinkRelationTypes;
import se.poroli.fhirplace.r5.valuesets.SearchEntryMode;

/**
 * A container for a collection of resources.
 *
 * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
 * usually created with {@link #builder()}.
 *
 * @param id Logical id of this artifact.
 * @param meta Metadata about the resource.
 * @param implicitRules A set of rules under which this content was created. Modifier element.
 * @param language Language of the resource content.
 * @param identifier Persistent identifier for the bundle.
 * @param type document | message | transaction | transaction-response | batch | batch-response | history | searchset
 *   | collection | subscription-notification. Required.
 * @param timestamp When the bundle was assembled.
 * @param total If search, the total number of matches.
 * @param link Links related to this Bundle.
 * @param entry Entry in the bundle - will have a resource or information.
 * @param signature Digital Signature.
 * @param issues Issues with the Bundle.
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Bundle">FHIR R5 Bundle</a>
 */
public record Bundle(
        String id,
        Meta meta,
        FhirUri implicitRules,
        FhirCode language,
        Identifier identifier,
        FhirEnum<BundleType> type,
        FhirInstant timestamp,
        FhirUnsignedInt total,
        List<Link> link,
        List<Entry> entry,
        Signature signature,
        Resource issues) implements Resource {

    /**
     * Creates a {@code Bundle}, copying all lists.
     *
     * @throws NullPointerException if a required element is absent or a list contains {@code null}
     */
    public Bundle {
        link = link == null ? List.of() : List.copyOf(link);
        entry = entry == null ? List.of() : List.copyOf(entry);
        Objects.requireNonNull(type, "Bundle.type is required");
    }

    /**
     * Returns a new, empty builder.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns a builder initialized with the values of this {@code Bundle}.
     *
     * @return the builder
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * A series of links that provide context to this bundle.
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param relation See http://www.iana.org/assignments/link-relations/link-relations.xhtml#link-relations-1.
     *   Required.
     * @param url Reference details for the link. Required.
     */
    public record Link(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            FhirEnum<LinkRelationTypes> relation,
            FhirUri url) implements BackboneElement {

        /**
         * Creates a {@code Link}, copying all lists.
         *
         * @throws NullPointerException if a required element is absent or a list contains {@code null}
         */
        public Link {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            Objects.requireNonNull(relation, "Bundle.link.relation is required");
            Objects.requireNonNull(url, "Bundle.link.url is required");
        }

        /**
         * Returns a new, empty builder.
         *
         * @return the builder
         */
        public static Builder builder() {
            return new Builder();
        }

        /**
         * Returns a builder initialized with the values of this {@code Link}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /** Builder for {@link Link}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private FhirEnum<LinkRelationTypes> relation;
            private FhirUri url;

            private Builder() {
            }

            private Builder(Link original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.relation = original.relation();
                this.url = original.url();
            }

            /**
             * Sets {@code id}.
             *
             * @param id the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder id(String id) {
                this.id = id;
                return this;
            }

            /**
             * Replaces all {@code extension} values.
             *
             * @param extension the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder extension(List<Extension> extension) {
                this.extension = extension == null ? new ArrayList<>() : new ArrayList<>(extension);
                return this;
            }

            /**
             * Adds a {@code extension} value.
             *
             * @param extension the value to add
             * @return this builder
             */
            public Builder addExtension(Extension extension) {
                this.extension.add(Objects.requireNonNull(extension, "extension"));
                return this;
            }

            /**
             * Replaces all {@code modifierExtension} values.
             *
             * @param modifierExtension the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder modifierExtension(List<Extension> modifierExtension) {
                this.modifierExtension = modifierExtension == null
                        ? new ArrayList<>()
                        : new ArrayList<>(modifierExtension);
                return this;
            }

            /**
             * Adds a {@code modifierExtension} value.
             *
             * @param modifierExtension the value to add
             * @return this builder
             */
            public Builder addModifierExtension(Extension modifierExtension) {
                this.modifierExtension.add(Objects.requireNonNull(modifierExtension, "modifierExtension"));
                return this;
            }

            /**
             * Sets {@code relation}.
             *
             * @param relation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder relation(FhirEnum<LinkRelationTypes> relation) {
                this.relation = relation;
                return this;
            }

            /**
             * Sets {@code relation}, wrapped in a {@link FhirEnum} without id or extensions.
             *
             * @param relation the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder relation(LinkRelationTypes relation) {
                return relation(relation == null ? null : FhirEnum.of(relation));
            }

            /**
             * Sets {@code url}.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(FhirUri url) {
                this.url = url;
                return this;
            }

            /**
             * Sets {@code url}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param url the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder url(String url) {
                return url(url == null ? null : FhirUri.of(url));
            }

            /**
             * Builds the {@code Link}.
             *
             * @return the {@code Link}
             * @throws NullPointerException if a required element is absent
             */
            public Link build() {
                return new Link(
                        id, extension, modifierExtension, relation, url);
            }
        }
    }

    /**
     * An entry in a bundle resource - will either contain a resource or information about a resource (transactions
     * and history only).
     *
     * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances are
     * usually created with {@link #builder()}.
     *
     * @param id Unique id for inter-element referencing.
     * @param extension Additional content defined by implementations.
     * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
     * @param link Links related to this entry.
     * @param fullUrl URI for resource (e.g. the absolute URL server address, URI for UUID/OID, etc.).
     * @param resource A resource in the bundle.
     * @param search Search related information.
     * @param request Additional execution information (transaction/batch/history).
     * @param response Results of execution (transaction/batch/history).
     */
    public record Entry(
            String id,
            List<Extension> extension,
            List<Extension> modifierExtension,
            List<Bundle.Link> link,
            FhirUri fullUrl,
            Resource resource,
            Search search,
            Request request,
            Response response) implements BackboneElement {

        /**
         * Creates an {@code Entry}, copying all lists.
         *
         * @throws NullPointerException if a list contains {@code null}
         */
        public Entry {
            extension = extension == null ? List.of() : List.copyOf(extension);
            modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            link = link == null ? List.of() : List.copyOf(link);
        }

        /**
         * Returns a new, empty builder.
         *
         * @return the builder
         */
        public static Builder builder() {
            return new Builder();
        }

        /**
         * Returns a builder initialized with the values of this {@code Entry}.
         *
         * @return the builder
         */
        public Builder toBuilder() {
            return new Builder(this);
        }

        /**
         * Information about the search process that lead to the creation of this entry.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param mode match | include - why this is in the result set.
         * @param score Search ranking (between 0 and 1).
         */
        public record Search(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<SearchEntryMode> mode,
                FhirDecimal score) implements BackboneElement {

            /**
             * Creates a {@code Search}, copying all lists.
             *
             * @throws NullPointerException if a list contains {@code null}
             */
            public Search {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
            }

            /**
             * Returns a new, empty builder.
             *
             * @return the builder
             */
            public static Builder builder() {
                return new Builder();
            }

            /**
             * Returns a builder initialized with the values of this {@code Search}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Search}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<SearchEntryMode> mode;
                private FhirDecimal score;

                private Builder() {
                }

                private Builder(Search original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.mode = original.mode();
                    this.score = original.score();
                }

                /**
                 * Sets {@code id}.
                 *
                 * @param id the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder id(String id) {
                    this.id = id;
                    return this;
                }

                /**
                 * Replaces all {@code extension} values.
                 *
                 * @param extension the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder extension(List<Extension> extension) {
                    this.extension = extension == null ? new ArrayList<>() : new ArrayList<>(extension);
                    return this;
                }

                /**
                 * Adds a {@code extension} value.
                 *
                 * @param extension the value to add
                 * @return this builder
                 */
                public Builder addExtension(Extension extension) {
                    this.extension.add(Objects.requireNonNull(extension, "extension"));
                    return this;
                }

                /**
                 * Replaces all {@code modifierExtension} values.
                 *
                 * @param modifierExtension the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder modifierExtension(List<Extension> modifierExtension) {
                    this.modifierExtension = modifierExtension == null
                            ? new ArrayList<>()
                            : new ArrayList<>(modifierExtension);
                    return this;
                }

                /**
                 * Adds a {@code modifierExtension} value.
                 *
                 * @param modifierExtension the value to add
                 * @return this builder
                 */
                public Builder addModifierExtension(Extension modifierExtension) {
                    this.modifierExtension.add(Objects.requireNonNull(modifierExtension, "modifierExtension"));
                    return this;
                }

                /**
                 * Sets {@code mode}.
                 *
                 * @param mode the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder mode(FhirEnum<SearchEntryMode> mode) {
                    this.mode = mode;
                    return this;
                }

                /**
                 * Sets {@code mode}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param mode the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder mode(SearchEntryMode mode) {
                    return mode(mode == null ? null : FhirEnum.of(mode));
                }

                /**
                 * Sets {@code score}.
                 *
                 * @param score the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder score(FhirDecimal score) {
                    this.score = score;
                    return this;
                }

                /**
                 * Sets {@code score}, wrapped in a {@link FhirDecimal} without id or extensions.
                 *
                 * @param score the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder score(BigDecimal score) {
                    return score(score == null ? null : FhirDecimal.of(score));
                }

                /**
                 * Builds the {@code Search}.
                 *
                 * @return the {@code Search}
                 */
                public Search build() {
                    return new Search(
                            id, extension, modifierExtension, mode, score);
                }
            }
        }

        /**
         * Additional information about how this entry should be processed as part of a transaction or batch.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param method GET | HEAD | POST | PUT | DELETE | PATCH. Required.
         * @param url URL for HTTP equivalent of this entry. Required.
         * @param ifNoneMatch For managing cache validation.
         * @param ifModifiedSince For managing cache currency.
         * @param ifMatch For managing update contention.
         * @param ifNoneExist For conditional creates.
         */
        public record Request(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirEnum<HTTPVerb> method,
                FhirUri url,
                FhirString ifNoneMatch,
                FhirInstant ifModifiedSince,
                FhirString ifMatch,
                FhirString ifNoneExist) implements BackboneElement {

            /**
             * Creates a {@code Request}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Request {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(method, "Bundle.entry.request.method is required");
                Objects.requireNonNull(url, "Bundle.entry.request.url is required");
            }

            /**
             * Returns a new, empty builder.
             *
             * @return the builder
             */
            public static Builder builder() {
                return new Builder();
            }

            /**
             * Returns a builder initialized with the values of this {@code Request}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Request}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirEnum<HTTPVerb> method;
                private FhirUri url;
                private FhirString ifNoneMatch;
                private FhirInstant ifModifiedSince;
                private FhirString ifMatch;
                private FhirString ifNoneExist;

                private Builder() {
                }

                private Builder(Request original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.method = original.method();
                    this.url = original.url();
                    this.ifNoneMatch = original.ifNoneMatch();
                    this.ifModifiedSince = original.ifModifiedSince();
                    this.ifMatch = original.ifMatch();
                    this.ifNoneExist = original.ifNoneExist();
                }

                /**
                 * Sets {@code id}.
                 *
                 * @param id the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder id(String id) {
                    this.id = id;
                    return this;
                }

                /**
                 * Replaces all {@code extension} values.
                 *
                 * @param extension the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder extension(List<Extension> extension) {
                    this.extension = extension == null ? new ArrayList<>() : new ArrayList<>(extension);
                    return this;
                }

                /**
                 * Adds a {@code extension} value.
                 *
                 * @param extension the value to add
                 * @return this builder
                 */
                public Builder addExtension(Extension extension) {
                    this.extension.add(Objects.requireNonNull(extension, "extension"));
                    return this;
                }

                /**
                 * Replaces all {@code modifierExtension} values.
                 *
                 * @param modifierExtension the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder modifierExtension(List<Extension> modifierExtension) {
                    this.modifierExtension = modifierExtension == null
                            ? new ArrayList<>()
                            : new ArrayList<>(modifierExtension);
                    return this;
                }

                /**
                 * Adds a {@code modifierExtension} value.
                 *
                 * @param modifierExtension the value to add
                 * @return this builder
                 */
                public Builder addModifierExtension(Extension modifierExtension) {
                    this.modifierExtension.add(Objects.requireNonNull(modifierExtension, "modifierExtension"));
                    return this;
                }

                /**
                 * Sets {@code method}.
                 *
                 * @param method the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder method(FhirEnum<HTTPVerb> method) {
                    this.method = method;
                    return this;
                }

                /**
                 * Sets {@code method}, wrapped in a {@link FhirEnum} without id or extensions.
                 *
                 * @param method the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder method(HTTPVerb method) {
                    return method(method == null ? null : FhirEnum.of(method));
                }

                /**
                 * Sets {@code url}.
                 *
                 * @param url the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder url(FhirUri url) {
                    this.url = url;
                    return this;
                }

                /**
                 * Sets {@code url}, wrapped in a {@link FhirUri} without id or extensions.
                 *
                 * @param url the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder url(String url) {
                    return url(url == null ? null : FhirUri.of(url));
                }

                /**
                 * Sets {@code ifNoneMatch}.
                 *
                 * @param ifNoneMatch the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder ifNoneMatch(FhirString ifNoneMatch) {
                    this.ifNoneMatch = ifNoneMatch;
                    return this;
                }

                /**
                 * Sets {@code ifNoneMatch}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param ifNoneMatch the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder ifNoneMatch(String ifNoneMatch) {
                    return ifNoneMatch(ifNoneMatch == null ? null : FhirString.of(ifNoneMatch));
                }

                /**
                 * Sets {@code ifModifiedSince}.
                 *
                 * @param ifModifiedSince the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder ifModifiedSince(FhirInstant ifModifiedSince) {
                    this.ifModifiedSince = ifModifiedSince;
                    return this;
                }

                /**
                 * Sets {@code ifModifiedSince}, wrapped in a {@link FhirInstant} without id or extensions.
                 *
                 * @param ifModifiedSince the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder ifModifiedSince(OffsetDateTime ifModifiedSince) {
                    return ifModifiedSince(ifModifiedSince == null ? null : FhirInstant.of(ifModifiedSince));
                }

                /**
                 * Sets {@code ifMatch}.
                 *
                 * @param ifMatch the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder ifMatch(FhirString ifMatch) {
                    this.ifMatch = ifMatch;
                    return this;
                }

                /**
                 * Sets {@code ifMatch}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param ifMatch the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder ifMatch(String ifMatch) {
                    return ifMatch(ifMatch == null ? null : FhirString.of(ifMatch));
                }

                /**
                 * Sets {@code ifNoneExist}.
                 *
                 * @param ifNoneExist the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder ifNoneExist(FhirString ifNoneExist) {
                    this.ifNoneExist = ifNoneExist;
                    return this;
                }

                /**
                 * Sets {@code ifNoneExist}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param ifNoneExist the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder ifNoneExist(String ifNoneExist) {
                    return ifNoneExist(ifNoneExist == null ? null : FhirString.of(ifNoneExist));
                }

                /**
                 * Builds the {@code Request}.
                 *
                 * @return the {@code Request}
                 * @throws NullPointerException if a required element is absent
                 */
                public Request build() {
                    return new Request(
                            id, extension, modifierExtension, method, url, ifNoneMatch, ifModifiedSince, ifMatch,
                            ifNoneExist);
                }
            }
        }

        /**
         * Indicates the results of processing the corresponding 'request' entry in the batch or transaction being
         * responded to or what the results of an operation where when returning history.
         *
         * <p>Absent single-valued elements are {@code null} and absent repeating elements are empty lists. Instances
         * are usually created with {@link #builder()}.
         *
         * @param id Unique id for inter-element referencing.
         * @param extension Additional content defined by implementations.
         * @param modifierExtension Extensions that cannot be ignored even if unrecognized. Modifier element.
         * @param status Status response code (text optional). Required.
         * @param location The location (if the operation returns a location).
         * @param etag The Etag for the resource (if relevant).
         * @param lastModified Server's date time modified.
         * @param outcome OperationOutcome with hints and warnings (for batch/transaction).
         */
        public record Response(
                String id,
                List<Extension> extension,
                List<Extension> modifierExtension,
                FhirString status,
                FhirUri location,
                FhirString etag,
                FhirInstant lastModified,
                Resource outcome) implements BackboneElement {

            /**
             * Creates a {@code Response}, copying all lists.
             *
             * @throws NullPointerException if a required element is absent or a list contains {@code null}
             */
            public Response {
                extension = extension == null ? List.of() : List.copyOf(extension);
                modifierExtension = modifierExtension == null ? List.of() : List.copyOf(modifierExtension);
                Objects.requireNonNull(status, "Bundle.entry.response.status is required");
            }

            /**
             * Returns a new, empty builder.
             *
             * @return the builder
             */
            public static Builder builder() {
                return new Builder();
            }

            /**
             * Returns a builder initialized with the values of this {@code Response}.
             *
             * @return the builder
             */
            public Builder toBuilder() {
                return new Builder(this);
            }

            /** Builder for {@link Response}. Builders are mutable and not thread-safe. */
            public static final class Builder {

                private String id;
                private List<Extension> extension = new ArrayList<>();
                private List<Extension> modifierExtension = new ArrayList<>();
                private FhirString status;
                private FhirUri location;
                private FhirString etag;
                private FhirInstant lastModified;
                private Resource outcome;

                private Builder() {
                }

                private Builder(Response original) {
                    this.id = original.id();
                    this.extension = new ArrayList<>(original.extension());
                    this.modifierExtension = new ArrayList<>(original.modifierExtension());
                    this.status = original.status();
                    this.location = original.location();
                    this.etag = original.etag();
                    this.lastModified = original.lastModified();
                    this.outcome = original.outcome();
                }

                /**
                 * Sets {@code id}.
                 *
                 * @param id the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder id(String id) {
                    this.id = id;
                    return this;
                }

                /**
                 * Replaces all {@code extension} values.
                 *
                 * @param extension the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder extension(List<Extension> extension) {
                    this.extension = extension == null ? new ArrayList<>() : new ArrayList<>(extension);
                    return this;
                }

                /**
                 * Adds a {@code extension} value.
                 *
                 * @param extension the value to add
                 * @return this builder
                 */
                public Builder addExtension(Extension extension) {
                    this.extension.add(Objects.requireNonNull(extension, "extension"));
                    return this;
                }

                /**
                 * Replaces all {@code modifierExtension} values.
                 *
                 * @param modifierExtension the new values, or {@code null} to clear them
                 * @return this builder
                 */
                public Builder modifierExtension(List<Extension> modifierExtension) {
                    this.modifierExtension = modifierExtension == null
                            ? new ArrayList<>()
                            : new ArrayList<>(modifierExtension);
                    return this;
                }

                /**
                 * Adds a {@code modifierExtension} value.
                 *
                 * @param modifierExtension the value to add
                 * @return this builder
                 */
                public Builder addModifierExtension(Extension modifierExtension) {
                    this.modifierExtension.add(Objects.requireNonNull(modifierExtension, "modifierExtension"));
                    return this;
                }

                /**
                 * Sets {@code status}.
                 *
                 * @param status the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder status(FhirString status) {
                    this.status = status;
                    return this;
                }

                /**
                 * Sets {@code status}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param status the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder status(String status) {
                    return status(status == null ? null : FhirString.of(status));
                }

                /**
                 * Sets {@code location}.
                 *
                 * @param location the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder location(FhirUri location) {
                    this.location = location;
                    return this;
                }

                /**
                 * Sets {@code location}, wrapped in a {@link FhirUri} without id or extensions.
                 *
                 * @param location the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder location(String location) {
                    return location(location == null ? null : FhirUri.of(location));
                }

                /**
                 * Sets {@code etag}.
                 *
                 * @param etag the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder etag(FhirString etag) {
                    this.etag = etag;
                    return this;
                }

                /**
                 * Sets {@code etag}, wrapped in a {@link FhirString} without id or extensions.
                 *
                 * @param etag the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder etag(String etag) {
                    return etag(etag == null ? null : FhirString.of(etag));
                }

                /**
                 * Sets {@code lastModified}.
                 *
                 * @param lastModified the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder lastModified(FhirInstant lastModified) {
                    this.lastModified = lastModified;
                    return this;
                }

                /**
                 * Sets {@code lastModified}, wrapped in a {@link FhirInstant} without id or extensions.
                 *
                 * @param lastModified the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder lastModified(OffsetDateTime lastModified) {
                    return lastModified(lastModified == null ? null : FhirInstant.of(lastModified));
                }

                /**
                 * Sets {@code outcome}.
                 *
                 * @param outcome the value, or {@code null} to clear it
                 * @return this builder
                 */
                public Builder outcome(Resource outcome) {
                    this.outcome = outcome;
                    return this;
                }

                /**
                 * Builds the {@code Response}.
                 *
                 * @return the {@code Response}
                 * @throws NullPointerException if a required element is absent
                 */
                public Response build() {
                    return new Response(
                            id, extension, modifierExtension, status, location, etag, lastModified, outcome);
                }
            }
        }

        /** Builder for {@link Entry}. Builders are mutable and not thread-safe. */
        public static final class Builder {

            private String id;
            private List<Extension> extension = new ArrayList<>();
            private List<Extension> modifierExtension = new ArrayList<>();
            private List<Bundle.Link> link = new ArrayList<>();
            private FhirUri fullUrl;
            private Resource resource;
            private Search search;
            private Request request;
            private Response response;

            private Builder() {
            }

            private Builder(Entry original) {
                this.id = original.id();
                this.extension = new ArrayList<>(original.extension());
                this.modifierExtension = new ArrayList<>(original.modifierExtension());
                this.link = new ArrayList<>(original.link());
                this.fullUrl = original.fullUrl();
                this.resource = original.resource();
                this.search = original.search();
                this.request = original.request();
                this.response = original.response();
            }

            /**
             * Sets {@code id}.
             *
             * @param id the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder id(String id) {
                this.id = id;
                return this;
            }

            /**
             * Replaces all {@code extension} values.
             *
             * @param extension the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder extension(List<Extension> extension) {
                this.extension = extension == null ? new ArrayList<>() : new ArrayList<>(extension);
                return this;
            }

            /**
             * Adds a {@code extension} value.
             *
             * @param extension the value to add
             * @return this builder
             */
            public Builder addExtension(Extension extension) {
                this.extension.add(Objects.requireNonNull(extension, "extension"));
                return this;
            }

            /**
             * Replaces all {@code modifierExtension} values.
             *
             * @param modifierExtension the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder modifierExtension(List<Extension> modifierExtension) {
                this.modifierExtension = modifierExtension == null
                        ? new ArrayList<>()
                        : new ArrayList<>(modifierExtension);
                return this;
            }

            /**
             * Adds a {@code modifierExtension} value.
             *
             * @param modifierExtension the value to add
             * @return this builder
             */
            public Builder addModifierExtension(Extension modifierExtension) {
                this.modifierExtension.add(Objects.requireNonNull(modifierExtension, "modifierExtension"));
                return this;
            }

            /**
             * Replaces all {@code link} values.
             *
             * @param link the new values, or {@code null} to clear them
             * @return this builder
             */
            public Builder link(List<Bundle.Link> link) {
                this.link = link == null ? new ArrayList<>() : new ArrayList<>(link);
                return this;
            }

            /**
             * Adds a {@code link} value.
             *
             * @param link the value to add
             * @return this builder
             */
            public Builder addLink(Bundle.Link link) {
                this.link.add(Objects.requireNonNull(link, "link"));
                return this;
            }

            /**
             * Sets {@code fullUrl}.
             *
             * @param fullUrl the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder fullUrl(FhirUri fullUrl) {
                this.fullUrl = fullUrl;
                return this;
            }

            /**
             * Sets {@code fullUrl}, wrapped in a {@link FhirUri} without id or extensions.
             *
             * @param fullUrl the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder fullUrl(String fullUrl) {
                return fullUrl(fullUrl == null ? null : FhirUri.of(fullUrl));
            }

            /**
             * Sets {@code resource}.
             *
             * @param resource the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder resource(Resource resource) {
                this.resource = resource;
                return this;
            }

            /**
             * Sets {@code search}.
             *
             * @param search the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder search(Search search) {
                this.search = search;
                return this;
            }

            /**
             * Sets {@code request}.
             *
             * @param request the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder request(Request request) {
                this.request = request;
                return this;
            }

            /**
             * Sets {@code response}.
             *
             * @param response the value, or {@code null} to clear it
             * @return this builder
             */
            public Builder response(Response response) {
                this.response = response;
                return this;
            }

            /**
             * Builds the {@code Entry}.
             *
             * @return the {@code Entry}
             */
            public Entry build() {
                return new Entry(
                        id, extension, modifierExtension, link, fullUrl, resource, search, request, response);
            }
        }
    }

    /** Builder for {@link Bundle}. Builders are mutable and not thread-safe. */
    public static final class Builder {

        private String id;
        private Meta meta;
        private FhirUri implicitRules;
        private FhirCode language;
        private Identifier identifier;
        private FhirEnum<BundleType> type;
        private FhirInstant timestamp;
        private FhirUnsignedInt total;
        private List<Link> link = new ArrayList<>();
        private List<Entry> entry = new ArrayList<>();
        private Signature signature;
        private Resource issues;

        private Builder() {
        }

        private Builder(Bundle original) {
            this.id = original.id();
            this.meta = original.meta();
            this.implicitRules = original.implicitRules();
            this.language = original.language();
            this.identifier = original.identifier();
            this.type = original.type();
            this.timestamp = original.timestamp();
            this.total = original.total();
            this.link = new ArrayList<>(original.link());
            this.entry = new ArrayList<>(original.entry());
            this.signature = original.signature();
            this.issues = original.issues();
        }

        /**
         * Sets {@code id}.
         *
         * @param id the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets {@code meta}.
         *
         * @param meta the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder meta(Meta meta) {
            this.meta = meta;
            return this;
        }

        /**
         * Sets {@code implicitRules}.
         *
         * @param implicitRules the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder implicitRules(FhirUri implicitRules) {
            this.implicitRules = implicitRules;
            return this;
        }

        /**
         * Sets {@code implicitRules}, wrapped in a {@link FhirUri} without id or extensions.
         *
         * @param implicitRules the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder implicitRules(String implicitRules) {
            return implicitRules(implicitRules == null ? null : FhirUri.of(implicitRules));
        }

        /**
         * Sets {@code language}.
         *
         * @param language the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder language(FhirCode language) {
            this.language = language;
            return this;
        }

        /**
         * Sets {@code language}, wrapped in a {@link FhirCode} without id or extensions.
         *
         * @param language the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder language(String language) {
            return language(language == null ? null : FhirCode.of(language));
        }

        /**
         * Sets {@code identifier}.
         *
         * @param identifier the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder identifier(Identifier identifier) {
            this.identifier = identifier;
            return this;
        }

        /**
         * Sets {@code type}.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(FhirEnum<BundleType> type) {
            this.type = type;
            return this;
        }

        /**
         * Sets {@code type}, wrapped in a {@link FhirEnum} without id or extensions.
         *
         * @param type the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder type(BundleType type) {
            return type(type == null ? null : FhirEnum.of(type));
        }

        /**
         * Sets {@code timestamp}.
         *
         * @param timestamp the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timestamp(FhirInstant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Sets {@code timestamp}, wrapped in a {@link FhirInstant} without id or extensions.
         *
         * @param timestamp the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder timestamp(OffsetDateTime timestamp) {
            return timestamp(timestamp == null ? null : FhirInstant.of(timestamp));
        }

        /**
         * Sets {@code total}.
         *
         * @param total the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder total(FhirUnsignedInt total) {
            this.total = total;
            return this;
        }

        /**
         * Sets {@code total}, wrapped in a {@link FhirUnsignedInt} without id or extensions.
         *
         * @param total the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder total(Integer total) {
            return total(total == null ? null : FhirUnsignedInt.of(total));
        }

        /**
         * Replaces all {@code link} values.
         *
         * @param link the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder link(List<Link> link) {
            this.link = link == null ? new ArrayList<>() : new ArrayList<>(link);
            return this;
        }

        /**
         * Adds a {@code link} value.
         *
         * @param link the value to add
         * @return this builder
         */
        public Builder addLink(Link link) {
            this.link.add(Objects.requireNonNull(link, "link"));
            return this;
        }

        /**
         * Replaces all {@code entry} values.
         *
         * @param entry the new values, or {@code null} to clear them
         * @return this builder
         */
        public Builder entry(List<Entry> entry) {
            this.entry = entry == null ? new ArrayList<>() : new ArrayList<>(entry);
            return this;
        }

        /**
         * Adds a {@code entry} value.
         *
         * @param entry the value to add
         * @return this builder
         */
        public Builder addEntry(Entry entry) {
            this.entry.add(Objects.requireNonNull(entry, "entry"));
            return this;
        }

        /**
         * Sets {@code signature}.
         *
         * @param signature the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder signature(Signature signature) {
            this.signature = signature;
            return this;
        }

        /**
         * Sets {@code issues}.
         *
         * @param issues the value, or {@code null} to clear it
         * @return this builder
         */
        public Builder issues(Resource issues) {
            this.issues = issues;
            return this;
        }

        /**
         * Builds the {@code Bundle}.
         *
         * @return the {@code Bundle}
         * @throws NullPointerException if a required element is absent
         */
        public Bundle build() {
            return new Bundle(
                    id, meta, implicitRules, language, identifier, type, timestamp, total, link, entry, signature,
                    issues);
        }
    }
}
