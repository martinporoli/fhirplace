package se.poroli.fhirplace.r5.bundle;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Link Relation Types defined at
 * https://www.iana.org/assignments/link-relations/link-relations.xhtml#link-relations-1.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/iana-link-relations">FHIR R5 LinkRelationTypes</a>
 */
public enum LinkRelationTypes implements CodedEnum {

    /** Refers to a resource that is the subject of the link's context. */
    ABOUT("about", "Refers to a resource that is the subject of the link's context."),

    /** Asserts that the link target provides an access control description for the link context. */
    ACL("acl", "Asserts that the link target provides an access control description for the link context."),

    /** Refers to a substitute for this context. */
    ALTERNATE("alternate", "Refers to a substitute for this context"),

    /** Used to reference alternative content that uses the AMP profile of the HTML format. */
    AMPHTML("amphtml", "Used to reference alternative content that uses the AMP profile of the HTML format."),

    /** Refers to an appendix. */
    APPENDIX("appendix", "Refers to an appendix."),

    /** Refers to an icon for the context. */
    APPLE_TOUCH_ICON("apple-touch-icon", "Refers to an icon for the context. Synonym for icon."),

    /** Refers to a launch screen for the context. */
    APPLE_TOUCH_STARTUP_IMAGE("apple-touch-startup-image", "Refers to a launch screen for the context."),

    /** Refers to a collection of records, documents, or other materials of historical interest. */
    ARCHIVES("archives", "Refers to a collection of records, documents, or other materials of historical interest."),

    /** Refers to the context's author. */
    AUTHOR("author", "Refers to the context's author."),

    /** Identifies the entity that blocks access to a resource following receipt of a legal demand. */
    BLOCKED_BY(
            "blocked-by",
            "Identifies the entity that blocks access to a resource following receipt of a legal demand."),

    /** Gives a permanent link to use for bookmarking purposes. */
    BOOKMARK("bookmark", "Gives a permanent link to use for bookmarking purposes."),

    /** Designates the preferred version of a resource (the IRI and its contents). */
    CANONICAL("canonical", "Designates the preferred version of a resource (the IRI and its contents)."),

    /** Refers to a chapter in a collection of resources. */
    CHAPTER("chapter", "Refers to a chapter in a collection of resources."),

    /** Indicates that the link target is preferred over the link context for the purpose of permanent citation. */
    CITE_AS(
            "cite-as",
            "Indicates that the link target is preferred over the link context for the purpose of permanent citation."),

    /** The target IRI points to a resource which represents the collection resource for the context IRI. */
    COLLECTION(
            "collection",
            "The target IRI points to a resource which represents the collection resource for the context IRI."),

    /** Refers to a table of contents. */
    CONTENTS("contents", "Refers to a table of contents."),

    /** The document linked to was later converted to the document that contains this link relation. */
    CONVERTED_FROM(
            "convertedFrom",
            "The document linked to was later converted to the document that contains this link relation. For example, an RFC can have a link to the Internet-Draft that became the RFC; in that case, the link relation would be \"convertedFrom\"."),

    /** Refers to a copyright statement that applies to the link's context. */
    COPYRIGHT("copyright", "Refers to a copyright statement that applies to the link's context."),

    /** The target IRI points to a resource where a submission form can be obtained. */
    CREATE_FORM("create-form", "The target IRI points to a resource where a submission form can be obtained."),

    /** Refers to a resource containing the most recent item(s) in a collection of resources. */
    CURRENT("current", "Refers to a resource containing the most recent item(s) in a collection of resources."),

    /** Refers to a resource providing information about the link's context. */
    DESCRIBEDBY("describedby", "Refers to a resource providing information about the link's context."),

    /** The relationship A 'describes' B asserts that resource A provides a description of resource B. */
    DESCRIBES(
            "describes",
            "The relationship A 'describes' B asserts that resource A provides a description of resource B. There are no constraints on the format or representation of either A or B, neither are there any further constraints on either resource."),

    /**
     * Refers to a list of patent disclosures made with respect to material for which 'disclosure' relation is
     * specified.
     */
    DISCLOSURE(
            "disclosure",
            "Refers to a list of patent disclosures made with respect to material for which 'disclosure' relation is specified."),

    /**
     * Used to indicate an origin that will be used to fetch required resources for the link context, and that the
     * user agent ought to resolve as early as possible.
     */
    DNS_PREFETCH(
            "dns-prefetch",
            "Used to indicate an origin that will be used to fetch required resources for the link context, and that the user agent ought to resolve as early as possible."),

    /**
     * Refers to a resource whose available representations are byte-for-byte identical with the corresponding
     * representations of the context IRI.
     */
    DUPLICATE(
            "duplicate",
            "Refers to a resource whose available representations are byte-for-byte identical with the corresponding representations of the context IRI."),

    /** Refers to a resource that can be used to edit the link's context. */
    EDIT("edit", "Refers to a resource that can be used to edit the link's context."),

    /**
     * The target IRI points to a resource where a submission form for editing associated resource can be obtained.
     */
    EDIT_FORM(
            "edit-form",
            "The target IRI points to a resource where a submission form for editing associated resource can be obtained."),

    /** Refers to a resource that can be used to edit media associated with the link's context. */
    EDIT_MEDIA(
            "edit-media",
            "Refers to a resource that can be used to edit media associated with the link's context."),

    /** Identifies a related resource that is potentially large and might require special handling. */
    ENCLOSURE(
            "enclosure",
            "Identifies a related resource that is potentially large and might require special handling."),

    /** Refers to a resource that is not part of the same site as the current context. */
    EXTERNAL("external", "Refers to a resource that is not part of the same site as the current context."),

    /** An IRI that refers to the furthest preceding resource in a series of resources. */
    FIRST("first", "An IRI that refers to the furthest preceding resource in a series of resources."),

    /** Refers to a glossary of terms. */
    GLOSSARY("glossary", "Refers to a glossary of terms."),

    /** Refers to context-sensitive help. */
    HELP("help", "Refers to context-sensitive help."),

    /** Refers to a resource hosted by the server indicated by the link context. */
    HOSTS("hosts", "Refers to a resource hosted by the server indicated by the link context."),

    /** Refers to a hub that enables registration for notification of updates to the context. */
    HUB("hub", "Refers to a hub that enables registration for notification of updates to the context."),

    /** Refers to an icon representing the link's context. */
    ICON("icon", "Refers to an icon representing the link's context."),

    /** Refers to an index. */
    INDEX("index", "Refers to an index."),

    /**
     * refers to a resource associated with a time interval that ends before the beginning of the time interval
     * associated with the context resource.
     */
    INTERVAL_AFTER(
            "intervalAfter",
            "refers to a resource associated with a time interval that ends before the beginning of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval that begins after the end of the time interval associated
     * with the context resource.
     */
    INTERVAL_BEFORE(
            "intervalBefore",
            "refers to a resource associated with a time interval that begins after the end of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval that begins after the beginning of the time interval
     * associated with the context resource, and ends before the end of the time interval associated with the context
     * resource.
     */
    INTERVAL_CONTAINS(
            "intervalContains",
            "refers to a resource associated with a time interval that begins after the beginning of the time interval associated with the context resource, and ends before the end of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval that begins after the end of the time interval associated
     * with the context resource, or ends before the beginning of the time interval associated with the context
     * resource.
     */
    INTERVAL_DISJOINT(
            "intervalDisjoint",
            "refers to a resource associated with a time interval that begins after the end of the time interval associated with the context resource, or ends before the beginning of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval that begins before the beginning of the time interval
     * associated with the context resource, and ends after the end of the time interval associated with the context
     * resource.
     */
    INTERVAL_DURING(
            "intervalDuring",
            "refers to a resource associated with a time interval that begins before the beginning of the time interval associated with the context resource, and ends after the end of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval whose beginning coincides with the beginning of the time
     * interval associated with the context resource, and whose end coincides with the end of the time interval
     * associated with the context resource.
     */
    INTERVAL_EQUALS(
            "intervalEquals",
            "refers to a resource associated with a time interval whose beginning coincides with the beginning of the time interval associated with the context resource, and whose end coincides with the end of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval that begins after the beginning of the time interval
     * associated with the context resource, and whose end coincides with the end of the time interval associated with
     * the context resource.
     */
    INTERVAL_FINISHED_BY(
            "intervalFinishedBy",
            "refers to a resource associated with a time interval that begins after the beginning of the time interval associated with the context resource, and whose end coincides with the end of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval that begins before the beginning of the time interval
     * associated with the context resource, and whose end coincides with the end of the time interval associated with
     * the context resource.
     */
    INTERVAL_FINISHES(
            "intervalFinishes",
            "refers to a resource associated with a time interval that begins before the beginning of the time interval associated with the context resource, and whose end coincides with the end of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval that begins before or is coincident with the beginning of
     * the time interval associated with the context resource, and ends after or is coincident with the end of the
     * time interval associated with the context resource.
     */
    INTERVAL_IN(
            "intervalIn",
            "refers to a resource associated with a time interval that begins before or is coincident with the beginning of the time interval associated with the context resource, and ends after or is coincident with the end of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval whose beginning coincides with the end of the time
     * interval associated with the context resource.
     */
    INTERVAL_MEETS(
            "intervalMeets",
            "refers to a resource associated with a time interval whose beginning coincides with the end of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval whose end coincides with the beginning of the time
     * interval associated with the context resource.
     */
    INTERVAL_MET_BY(
            "intervalMetBy",
            "refers to a resource associated with a time interval whose end coincides with the beginning of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval that begins before the beginning of the time interval
     * associated with the context resource, and ends after the beginning of the time interval associated with the
     * context resource.
     */
    INTERVAL_OVERLAPPED_BY(
            "intervalOverlappedBy",
            "refers to a resource associated with a time interval that begins before the beginning of the time interval associated with the context resource, and ends after the beginning of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval that begins before the end of the time interval associated
     * with the context resource, and ends after the end of the time interval associated with the context resource.
     */
    INTERVAL_OVERLAPS(
            "intervalOverlaps",
            "refers to a resource associated with a time interval that begins before the end of the time interval associated with the context resource, and ends after the end of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval whose beginning coincides with the beginning of the time
     * interval associated with the context resource, and ends before the end of the time interval associated with the
     * context resource.
     */
    INTERVAL_STARTED_BY(
            "intervalStartedBy",
            "refers to a resource associated with a time interval whose beginning coincides with the beginning of the time interval associated with the context resource, and ends before the end of the time interval associated with the context resource"),

    /**
     * refers to a resource associated with a time interval whose beginning coincides with the beginning of the time
     * interval associated with the context resource, and ends after the end of the time interval associated with the
     * context resource.
     */
    INTERVAL_STARTS(
            "intervalStarts",
            "refers to a resource associated with a time interval whose beginning coincides with the beginning of the time interval associated with the context resource, and ends after the end of the time interval associated with the context resource"),

    /** The target IRI points to a resource that is a member of the collection represented by the context IRI. */
    ITEM(
            "item",
            "The target IRI points to a resource that is a member of the collection represented by the context IRI."),

    /** An IRI that refers to the furthest following resource in a series of resources. */
    LAST("last", "An IRI that refers to the furthest following resource in a series of resources."),

    /** Points to a resource containing the latest (e.g., current) version of the context. */
    LATEST_VERSION(
            "latest-version",
            "Points to a resource containing the latest (e.g., current) version of the context."),

    /** Refers to a license associated with this context. */
    LICENSE("license", "Refers to a license associated with this context."),

    /**
     * The link target of a link with the "linkset" relation type provides a set of links, including links in which
     * the link context of the link participates.
     */
    LINKSET(
            "linkset",
            "The link target of a link with the \"linkset\" relation type provides a set of links, including links in which the link context of the link participates."),

    /**
     * Refers to further information about the link's context, expressed as a LRDD ("Link-based Resource Descriptor
     * Document") resource.
     */
    LRDD(
            "lrdd",
            "Refers to further information about the link's context, expressed as a LRDD (\"Link-based Resource Descriptor Document\") resource. See for information about processing this relation type in host-meta documents. When used elsewhere, it refers to additional links and other metadata. Multiple instances indicate additional LRDD resources. LRDD resources MUST have an \"application/xrd+xml\" representation, and MAY have others."),

    /** Links to a manifest file for the context. */
    MANIFEST("manifest", "Links to a manifest file for the context."),

    /** Refers to a mask that can be applied to the icon for the context. */
    MASK_ICON("mask-icon", "Refers to a mask that can be applied to the icon for the context."),

    /** Refers to a feed of personalised media recommendations relevant to the link context. */
    MEDIA_FEED("media-feed", "Refers to a feed of personalised media recommendations relevant to the link context."),

    /** The Target IRI points to a Memento, a fixed resource that will not change state anymore. */
    MEMENTO("memento", "The Target IRI points to a Memento, a fixed resource that will not change state anymore."),

    /** Links to the context's Micropub endpoint. */
    MICROPUB("micropub", "Links to the context's Micropub endpoint."),

    /** Refers to a module that the user agent is to preemptively fetch and store for use in the current context. */
    MODULEPRELOAD(
            "modulepreload",
            "Refers to a module that the user agent is to preemptively fetch and store for use in the current context."),

    /** Refers to a resource that can be used to monitor changes in an HTTP resource. */
    MONITOR("monitor", "Refers to a resource that can be used to monitor changes in an HTTP resource."),

    /** Refers to a resource that can be used to monitor changes in a specified group of HTTP resources. */
    MONITOR_GROUP(
            "monitor-group",
            "Refers to a resource that can be used to monitor changes in a specified group of HTTP resources."),

    /**
     * Indicates that the link's context is a part of a series, and that the next in the series is the link target.
     */
    NEXT(
            "next",
            "Indicates that the link's context is a part of a series, and that the next in the series is the link target."),

    /** Refers to the immediately following archive resource. */
    NEXT_ARCHIVE("next-archive", "Refers to the immediately following archive resource."),

    /** Indicates that the context’s original author or publisher does not endorse the link target. */
    NOFOLLOW(
            "nofollow",
            "Indicates that the context’s original author or publisher does not endorse the link target."),

    /**
     * Indicates that any newly created top-level browsing context which results from following the link will not be
     * an auxiliary browsing context.
     */
    NOOPENER(
            "noopener",
            "Indicates that any newly created top-level browsing context which results from following the link will not be an auxiliary browsing context."),

    /** Indicates that no referrer information is to be leaked when following the link. */
    NOREFERRER("noreferrer", "Indicates that no referrer information is to be leaked when following the link."),

    /**
     * Indicates that any newly created top-level browsing context which results from following the link will be an
     * auxiliary browsing context.
     */
    OPENER(
            "opener",
            "Indicates that any newly created top-level browsing context which results from following the link will be an auxiliary browsing context."),

    /**
     * Refers to an OpenID Authentication server on which the context relies for an assertion that the end user
     * controls an Identifier.
     */
    OPENID2_LOCAL_ID(
            "openid2.local_id",
            "Refers to an OpenID Authentication server on which the context relies for an assertion that the end user controls an Identifier."),

    /** Refers to a resource which accepts OpenID Authentication protocol messages for the context. */
    OPENID2_PROVIDER(
            "openid2.provider",
            "Refers to a resource which accepts OpenID Authentication protocol messages for the context."),

    /** The Target IRI points to an Original Resource. */
    ORIGINAL("original", "The Target IRI points to an Original Resource."),

    /** Refers to a P3P privacy policy for the context. */
    P3_PV1("P3Pv1", "Refers to a P3P privacy policy for the context."),

    /** Indicates a resource where payment is accepted. */
    PAYMENT("payment", "Indicates a resource where payment is accepted."),

    /** Gives the address of the pingback resource for the link context. */
    PINGBACK("pingback", "Gives the address of the pingback resource for the link context."),

    /** Used to indicate an origin that will be used to fetch required resources for the link context. */
    PRECONNECT(
            "preconnect",
            "Used to indicate an origin that will be used to fetch required resources for the link context. Initiating an early connection, which includes the DNS lookup, TCP handshake, and optional TLS negotiation, allows the user agent to mask the high latency costs of establishing a connection."),

    /** Points to a resource containing the predecessor version in the version history. */
    PREDECESSOR_VERSION(
            "predecessor-version",
            "Points to a resource containing the predecessor version in the version history."),

    /**
     * The prefetch link relation type is used to identify a resource that might be required by the next navigation
     * from the link context, and that the user agent ought to fetch, such that the user agent can deliver a faster
     * response once the resource is requested in the future.
     */
    PREFETCH(
            "prefetch",
            "The prefetch link relation type is used to identify a resource that might be required by the next navigation from the link context, and that the user agent ought to fetch, such that the user agent can deliver a faster response once the resource is requested in the future."),

    /**
     * Refers to a resource that should be loaded early in the processing of the link's context, without blocking
     * rendering.
     */
    PRELOAD(
            "preload",
            "Refers to a resource that should be loaded early in the processing of the link's context, without blocking rendering."),

    /**
     * Used to identify a resource that might be required by the next navigation from the link context, and that the
     * user agent ought to fetch and execute, such that the user agent can deliver a faster response once the resource
     * is requested in the future.
     */
    PRERENDER(
            "prerender",
            "Used to identify a resource that might be required by the next navigation from the link context, and that the user agent ought to fetch and execute, such that the user agent can deliver a faster response once the resource is requested in the future."),

    /**
     * Indicates that the link's context is a part of a series, and that the previous in the series is the link
     * target.
     */
    PREV(
            "prev",
            "Indicates that the link's context is a part of a series, and that the previous in the series is the link target."),

    /** Refers to a resource that provides a preview of the link's context. */
    PREVIEW("preview", "Refers to a resource that provides a preview of the link's context."),

    /** Refers to the previous resource in an ordered series of resources. */
    PREVIOUS("previous", "Refers to the previous resource in an ordered series of resources. Synonym for \"prev\"."),

    /** Refers to the immediately preceding archive resource. */
    PREV_ARCHIVE("prev-archive", "Refers to the immediately preceding archive resource."),

    /** Refers to a privacy policy associated with the link's context. */
    PRIVACY_POLICY("privacy-policy", "Refers to a privacy policy associated with the link's context."),

    /**
     * Identifying that a resource representation conforms to a certain profile, without affecting the non-profile
     * semantics of the resource representation.
     */
    PROFILE(
            "profile",
            "Identifying that a resource representation conforms to a certain profile, without affecting the non-profile semantics of the resource representation."),

    /** Links to a publication manifest. */
    PUBLICATION(
            "publication",
            "Links to a publication manifest. A manifest represents structured information about a publication, such as informative metadata, a list of resources, and a default reading order."),

    /** Identifies a related resource. */
    RELATED("related", "Identifies a related resource."),

    /** Identifies the root of RESTCONF API as configured on this HTTP server. */
    RESTCONF(
            "restconf",
            "Identifies the root of RESTCONF API as configured on this HTTP server. The \"restconf\" relation defines the root of the API defined in RFC8040. Subsequent revisions of RESTCONF will use alternate relation values to support protocol versioning."),

    /** Identifies a resource that is a reply to the context of the link. */
    REPLIES("replies", "Identifies a resource that is a reply to the context of the link."),

    /**
     * The resource identified by the link target provides an input value to an instance of a rule, where the resource
     * which represents the rule instance is identified by the link context.
     */
    RULEINPUT(
            "ruleinput",
            "The resource identified by the link target provides an input value to an instance of a rule, where the resource which represents the rule instance is identified by the link context."),

    /** Refers to a resource that can be used to search through the link's context and related resources. */
    SEARCH(
            "search",
            "Refers to a resource that can be used to search through the link's context and related resources."),

    /** Refers to a section in a collection of resources. */
    SECTION("section", "Refers to a section in a collection of resources."),

    /** Conveys an identifier for the link's context. */
    SELF("self", "Conveys an identifier for the link's context."),

    /** Indicates a URI that can be used to retrieve a service document. */
    SERVICE("service", "Indicates a URI that can be used to retrieve a service document."),

    /** Identifies service description for the context that is primarily intended for consumption by machines. */
    SERVICE_DESC(
            "service-desc",
            "Identifies service description for the context that is primarily intended for consumption by machines."),

    /** Identifies service documentation for the context that is primarily intended for human consumption. */
    SERVICE_DOC(
            "service-doc",
            "Identifies service documentation for the context that is primarily intended for human consumption."),

    /** Identifies general metadata for the context that is primarily intended for consumption by machines. */
    SERVICE_META(
            "service-meta",
            "Identifies general metadata for the context that is primarily intended for consumption by machines."),

    /**
     * Refers to a resource that is within a context that is sponsored (such as advertising or another compensation
     * agreement).
     */
    SPONSORED(
            "sponsored",
            "Refers to a resource that is within a context that is sponsored (such as advertising or another compensation agreement)."),

    /** Refers to the first resource in a collection of resources. */
    START("start", "Refers to the first resource in a collection of resources."),

    /** Identifies a resource that represents the context's status. */
    STATUS("status", "Identifies a resource that represents the context's status."),

    /** Refers to a stylesheet. */
    STYLESHEET("stylesheet", "Refers to a stylesheet."),

    /** Refers to a resource serving as a subsection in a collection of resources. */
    SUBSECTION("subsection", "Refers to a resource serving as a subsection in a collection of resources."),

    /** Points to a resource containing the successor version in the version history. */
    SUCCESSOR_VERSION(
            "successor-version",
            "Points to a resource containing the successor version in the version history."),

    /** Identifies a resource that provides information about the context's retirement policy. */
    SUNSET("sunset", "Identifies a resource that provides information about the context's retirement policy."),

    /** Gives a tag (identified by the given address) that applies to the current document. */
    TAG("tag", "Gives a tag (identified by the given address) that applies to the current document."),

    /** Refers to the terms of service associated with the link's context. */
    TERMS_OF_SERVICE("terms-of-service", "Refers to the terms of service associated with the link's context."),

    /** The Target IRI points to a TimeGate for an Original Resource. */
    TIMEGATE("timegate", "The Target IRI points to a TimeGate for an Original Resource."),

    /** The Target IRI points to a TimeMap for an Original Resource. */
    TIMEMAP("timemap", "The Target IRI points to a TimeMap for an Original Resource."),

    /**
     * Refers to a resource identifying the abstract semantic type of which the link's context is considered to be an
     * instance.
     */
    TYPE(
            "type",
            "Refers to a resource identifying the abstract semantic type of which the link's context is considered to be an instance."),

    /** Refers to a resource that is within a context that is User Generated Content. */
    UGC("ugc", "Refers to a resource that is within a context that is User Generated Content."),

    /** Refers to a parent document in a hierarchy of documents. */
    UP("up", "Refers to a parent document in a hierarchy of documents."),

    /** Points to a resource containing the version history for the context. */
    VERSION_HISTORY("version-history", "Points to a resource containing the version history for the context."),

    /** Identifies a resource that is the source of the information in the link's context. */
    VIA("via", "Identifies a resource that is the source of the information in the link's context."),

    /** Identifies a target URI that supports the Webmention protocol. */
    WEBMENTION(
            "webmention",
            "Identifies a target URI that supports the Webmention protocol. This allows clients that mention a resource in some form of publishing process to contact that endpoint and inform it that this resource has been mentioned."),

    /** Points to a working copy for this resource. */
    WORKING_COPY("working-copy", "Points to a working copy for this resource."),

    /** Points to the versioned resource from which this working copy was obtained. */
    WORKING_COPY_OF("working-copy-of", "Points to the versioned resource from which this working copy was obtained.");

    private final String code;
    private final String display;

    LinkRelationTypes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/iana-link-relations";
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
    public static LinkRelationTypes fromCode(String code) {
        for (LinkRelationTypes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown LinkRelationTypes code: '" + code + "'");
    }
}
