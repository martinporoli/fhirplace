package se.poroli.fhirplace.r5.valuesets;

/**
 * All FHIR types.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/fhir-types">FHIR R5 FHIRTypes</a>
 */
public enum FHIRTypes implements CodedEnum {

    /** Base Type: Base definition for all types defined in FHIR type system. */
    BASE("Base", "Base"),

    /** Element Type: Base definition for all elements in a resource. */
    ELEMENT("Element", "Element"),

    /**
     * BackboneElement Type: Base definition for all elements that are defined inside a resource - but not those in a
     * data type.
     */
    BACKBONE_ELEMENT("BackboneElement", "BackboneElement"),

    /** DataType Type: The base class for all re-useable types defined as part of the FHIR Specification. */
    DATA_TYPE("DataType", "DataType"),

    /**
     * Address Type: An address expressed using postal conventions (as opposed to GPS or other location definition
     * formats).
     */
    ADDRESS("Address", "Address"),

    /** Annotation Type: A text note which also contains information about who made the statement and when. */
    ANNOTATION("Annotation", "Annotation"),

    /** Attachment Type: For referring to data content defined in other formats. */
    ATTACHMENT("Attachment", "Attachment"),

    /** Availability Type: Availability data for an {item}. */
    AVAILABILITY("Availability", "Availability"),

    /** BackboneType Type: Base definition for the few data types that are allowed to carry modifier extensions. */
    BACKBONE_TYPE("BackboneType", "BackboneType"),

    /** Dosage Type: Indicates how the medication is/was taken or should be taken by the patient. */
    DOSAGE("Dosage", "Dosage"),

    /** ElementDefinition Type: Captures constraints on each element within the resource, profile, or extension. */
    ELEMENT_DEFINITION("ElementDefinition", "ElementDefinition"),

    /**
     * MarketingStatus Type: The marketing status describes the date when a medicinal product is actually put on the
     * market or the date as of which it is no longer available.
     */
    MARKETING_STATUS("MarketingStatus", "MarketingStatus"),

    /**
     * ProductShelfLife Type: The shelf-life and storage information for a medicinal product item or container can be
     * described using this class.
     */
    PRODUCT_SHELF_LIFE("ProductShelfLife", "ProductShelfLife"),

    /** Timing Type: Specifies an event that may occur multiple times. */
    TIMING("Timing", "Timing"),

    /**
     * CodeableConcept Type: A concept that may be defined by a formal reference to a terminology or ontology or may
     * be provided by text.
     */
    CODEABLE_CONCEPT("CodeableConcept", "CodeableConcept"),

    /**
     * CodeableReference Type: A reference to a resource (by instance), or instead, a reference to a concept defined
     * in a terminology or ontology (by class).
     */
    CODEABLE_REFERENCE("CodeableReference", "CodeableReference"),

    /** Coding Type: A reference to a code defined by a terminology system. */
    CODING("Coding", "Coding"),

    /** ContactDetail Type: Specifies contact information for a person or organization. */
    CONTACT_DETAIL("ContactDetail", "ContactDetail"),

    /**
     * ContactPoint Type: Details for all kinds of technology mediated contact points for a person or organization,
     * including telephone, email, etc.
     */
    CONTACT_POINT("ContactPoint", "ContactPoint"),

    /**
     * Contributor Type: A contributor to the content of a knowledge asset, including authors, editors, reviewers, and
     * endorsers.
     */
    CONTRIBUTOR("Contributor", "Contributor"),

    /**
     * DataRequirement Type: Describes a required data item for evaluation in terms of the type of data, and optional
     * code or date-based filters of the data.
     */
    DATA_REQUIREMENT("DataRequirement", "DataRequirement"),

    /** Expression Type: A expression that is evaluated in a specified context and returns a value. */
    EXPRESSION("Expression", "Expression"),

    /**
     * ExtendedContactDetail Type: Specifies contact information for a specific purpose over a period of time, might
     * be handled/monitored by a specific named person or organization.
     */
    EXTENDED_CONTACT_DETAIL("ExtendedContactDetail", "ExtendedContactDetail"),

    /** Extension Type: Optional Extension Element - found in all resources. */
    EXTENSION("Extension", "Extension"),

    /**
     * HumanName Type: A name, normally of a human, that can be used for other living entities (e.g. animals but not
     * organizations) that have been assigned names by a human and may need the use of name parts or the need for
     * usage information.
     */
    HUMAN_NAME("HumanName", "HumanName"),

    /** Identifier Type: An identifier - identifies some entity uniquely and unambiguously. */
    IDENTIFIER("Identifier", "Identifier"),

    /** Meta Type: The metadata about a resource. */
    META("Meta", "Meta"),

    /** MonetaryComponent Type: Availability data for an {item}. */
    MONETARY_COMPONENT("MonetaryComponent", "MonetaryComponent"),

    /** Money Type: An amount of economic utility in some recognized currency. */
    MONEY("Money", "Money"),

    /**
     * Narrative Type: A human-readable summary of the resource conveying the essential clinical and business
     * information for the resource.
     */
    NARRATIVE("Narrative", "Narrative"),

    /** ParameterDefinition Type: The parameters to the module. */
    PARAMETER_DEFINITION("ParameterDefinition", "ParameterDefinition"),

    /** Period Type: A time period defined by a start and end date and optionally time. */
    PERIOD("Period", "Period"),

    /** PrimitiveType Type: The base type for all re-useable types defined that have a simple property. */
    PRIMITIVE_TYPE("PrimitiveType", "PrimitiveType"),

    /** base64Binary Type: A stream of bytes. */
    BASE64_BINARY("base64Binary", "base64Binary"),

    /** boolean Type: Value of "true" or "false". */
    BOOLEAN("boolean", "boolean"),

    /** date Type: A date or partial date (e.g. just year or year + month). */
    DATE("date", "date"),

    /** dateTime Type: A date, date-time or partial date (e.g. just year or year + month). */
    DATE_TIME("dateTime", "dateTime"),

    /** decimal Type: A rational number with implicit precision. */
    DECIMAL("decimal", "decimal"),

    /** instant Type: An instant in time - known at least to the second. */
    INSTANT("instant", "instant"),

    /** integer Type: A whole number. */
    INTEGER("integer", "integer"),

    /** positiveInt type: An integer with a value that is positive (e.g. &gt;0). */
    POSITIVE_INT("positiveInt", "positiveInt"),

    /** unsignedInt type: An integer with a value that is not negative (e.g. &gt;= 0). */
    UNSIGNED_INT("unsignedInt", "unsignedInt"),

    /** integer64 Type: A very large whole number. */
    INTEGER64("integer64", "integer64"),

    /** string Type: A sequence of Unicode characters. */
    STRING("string", "string"),

    /**
     * code type: A string which has at least one character and no leading or trailing whitespace and where there is
     * no whitespace other than single spaces in the contents.
     */
    CODE("code", "code"),

    /** id type: Any combination of letters, numerals, "-" and ".", with a length limit of 64 characters. */
    ID("id", "id"),

    /**
     * markdown type: A string that may contain Github Flavored Markdown syntax for optional processing by a mark down
     * presentation engine.
     */
    MARKDOWN("markdown", "markdown"),

    /** time Type: A time during the day, with no date specified. */
    TIME("time", "time"),

    /** uri Type: String of characters used to identify a name or a resource. */
    URI("uri", "uri"),

    /** canonical type: A URI that is a reference to a canonical URL on a FHIR resource. */
    CANONICAL("canonical", "canonical"),

    /** oid type: An OID represented as a URI. */
    OID("oid", "oid"),

    /** url type: A URI that is a literal reference. */
    URL("url", "url"),

    /** uuid type: A UUID, represented as a URI. */
    UUID("uuid", "uuid"),

    /** Quantity Type: A measured amount (or an amount that can potentially be measured). */
    QUANTITY("Quantity", "Quantity"),

    /** Age Type: A duration of time during which an organism (or a process) has existed. */
    AGE("Age", "Age"),

    /** Count Type: A measured amount (or an amount that can potentially be measured). */
    COUNT("Count", "Count"),

    /** Distance Type: A length - a value with a unit that is a physical distance. */
    DISTANCE("Distance", "Distance"),

    /** Duration Type: A length of time. */
    DURATION("Duration", "Duration"),

    /** Range Type: A set of ordered Quantities defined by a low and high limit. */
    RANGE("Range", "Range"),

    /** Ratio Type: A relationship of two Quantity values - expressed as a numerator and a denominator. */
    RATIO("Ratio", "Ratio"),

    /** RatioRange Type: A range of ratios expressed as a low and high numerator and a denominator. */
    RATIO_RANGE("RatioRange", "RatioRange"),

    /** Reference Type: A reference from one resource to another. */
    REFERENCE("Reference", "Reference"),

    /**
     * RelatedArtifact Type: Related artifacts such as additional documentation, justification, or bibliographic
     * references.
     */
    RELATED_ARTIFACT("RelatedArtifact", "RelatedArtifact"),

    /** SampledData Type: A series of measurements taken by a device, with upper and lower limits. */
    SAMPLED_DATA("SampledData", "SampledData"),

    /** Signature Type: A signature along with supporting context. */
    SIGNATURE("Signature", "Signature"),

    /** TriggerDefinition Type: A description of a triggering event. */
    TRIGGER_DEFINITION("TriggerDefinition", "TriggerDefinition"),

    /**
     * UsageContext Type: Specifies clinical/business/etc. metadata that can be used to retrieve, index and/or
     * categorize an artifact.
     */
    USAGE_CONTEXT("UsageContext", "UsageContext"),

    /** VirtualServiceDetail Type: Virtual Service Contact Details. */
    VIRTUAL_SERVICE_DETAIL("VirtualServiceDetail", "VirtualServiceDetail"),

    /** xhtml Type definition. */
    XHTML("xhtml", "xhtml"),

    /** This is the base resource type for everything. */
    RESOURCE("Resource", "Resource"),

    /**
     * A resource that represents the data of a single raw artifact as digital content accessible in its native
     * format.
     */
    BINARY("Binary", "Binary"),

    /** A container for a collection of resources. */
    BUNDLE("Bundle", "Bundle"),

    /** A resource that includes narrative, extensions, and contained resources. */
    DOMAIN_RESOURCE("DomainResource", "DomainResource"),

    /** A financial tool for tracking value accrued for a particular purpose. */
    ACCOUNT("Account", "Account"),

    /**
     * This resource allows for the definition of some activity to be performed, independent of a particular patient,
     * practitioner, or other performance context.
     */
    ACTIVITY_DEFINITION("ActivityDefinition", "ActivityDefinition"),

    /**
     * The ActorDefinition resource is used to describe an actor - a human or an application that plays a role in data
     * exchange, and that may have obligations associated with the role the actor plays.
     */
    ACTOR_DEFINITION("ActorDefinition", "ActorDefinition"),

    /**
     * A medicinal product in the final form which is suitable for administering to a patient (after any mixing of
     * multiple components, dissolution etc. has been performed).
     */
    ADMINISTRABLE_PRODUCT_DEFINITION("AdministrableProductDefinition", "AdministrableProductDefinition"),

    /**
     * An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or
     * research participant.
     */
    ADVERSE_EVENT("AdverseEvent", "AdverseEvent"),

    /**
     * Risk of harmful or undesirable, physiological response which is unique to an individual and associated with
     * exposure to a substance.
     */
    ALLERGY_INTOLERANCE("AllergyIntolerance", "AllergyIntolerance"),

    /**
     * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a
     * specific date/time.
     */
    APPOINTMENT("Appointment", "Appointment"),

    /**
     * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
     */
    APPOINTMENT_RESPONSE("AppointmentResponse", "AppointmentResponse"),

    /**
     * This Resource provides one or more comments, classifiers or ratings about a Resource and supports attribution
     * and rights management metadata for the added content.
     */
    ARTIFACT_ASSESSMENT("ArtifactAssessment", "ArtifactAssessment"),

    /**
     * A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance
     * analysis.
     */
    AUDIT_EVENT("AuditEvent", "AuditEvent"),

    /**
     * Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an
     * existing resource, and custom resources not appropriate for inclusion in the FHIR specification.
     */
    BASIC("Basic", "Basic"),

    /**
     * A biological material originating from a biological entity intended to be transplanted or infused into another
     * (possibly the same) biological entity.
     */
    BIOLOGICALLY_DERIVED_PRODUCT("BiologicallyDerivedProduct", "BiologicallyDerivedProduct"),

    /** A record of dispensation of a biologically derived product. */
    BIOLOGICALLY_DERIVED_PRODUCT_DISPENSE("BiologicallyDerivedProductDispense", "BiologicallyDerivedProductDispense"),

    /** Record details about an anatomical structure. */
    BODY_STRUCTURE("BodyStructure", "BodyStructure"),

    /** Common Interface declaration for conformance and knowledge artifact resources. */
    CANONICAL_RESOURCE("CanonicalResource", "CanonicalResource"),

    /**
     * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server or Client for a particular
     * version of FHIR that may be used as a statement of actual server functionality or a statement of required or
     * desired server implementation.
     */
    CAPABILITY_STATEMENT("CapabilityStatement", "CapabilityStatement"),

    /**
     * Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group
     * or community for a period of time, possibly limited to care for a specific condition or set of conditions.
     */
    CARE_PLAN("CarePlan", "CarePlan"),

    /**
     * The Care Team includes all the people and organizations who plan to participate in the coordination and
     * delivery of care.
     */
    CARE_TEAM("CareTeam", "CareTeam"),

    /**
     * The resource ChargeItem describes the provision of healthcare provider products for a certain patient,
     * therefore referring not only to the product, but containing in addition details of the provision, like date,
     * time, amounts and participating organizations and persons.
     */
    CHARGE_ITEM("ChargeItem", "ChargeItem"),

    /**
     * The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to
     * calculate costs and prices.
     */
    CHARGE_ITEM_DEFINITION("ChargeItemDefinition", "ChargeItemDefinition"),

    /**
     * The Citation Resource enables reference to any knowledge artifact for purposes of identification and
     * attribution.
     */
    CITATION("Citation", "Citation"),

    /**
     * A provider issued list of professional services and products which have been provided, or are to be provided,
     * to a patient which is sent to an insurer for reimbursement.
     */
    CLAIM("Claim", "Claim"),

    /** This resource provides the adjudication details from the processing of a Claim resource. */
    CLAIM_RESPONSE("ClaimResponse", "ClaimResponse"),

    /**
     * A record of a clinical assessment performed to determine what problem(s) may affect the patient and before
     * planning the treatments or management strategies that are best to manage a patient's condition.
     */
    CLINICAL_IMPRESSION("ClinicalImpression", "ClinicalImpression"),

    /**
     * A single issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal
     * product, medication, device or procedure.
     */
    CLINICAL_USE_DEFINITION("ClinicalUseDefinition", "ClinicalUseDefinition"),

    /**
     * The CodeSystem resource is used to declare the existence of and describe a code system or code system
     * supplement and its key properties, and optionally define a part or all of its content.
     */
    CODE_SYSTEM("CodeSystem", "CodeSystem"),

    /**
     * A clinical or business level record of information being transmitted or shared; e.g. an alert that was sent to
     * a responsible provider, a public health agency communication to a provider/reporter in response to a case
     * report for a reportable condition.
     */
    COMMUNICATION("Communication", "Communication"),

    /**
     * A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider,
     * the CDS system proposes that the public health agency be notified about a reportable condition.
     */
    COMMUNICATION_REQUEST("CommunicationRequest", "CommunicationRequest"),

    /** A compartment definition that defines how resources are accessed on a server. */
    COMPARTMENT_DEFINITION("CompartmentDefinition", "CompartmentDefinition"),

    /**
     * A set of healthcare-related information that is assembled together into a single logical package that provides
     * a single coherent statement of meaning, establishes its own context and that has clinical attestation with
     * regard to who is making the statement.
     */
    COMPOSITION("Composition", "Composition"),

    /**
     * A statement of relationships from one set of concepts to one or more other concepts - either concepts in code
     * systems, or data element/data element concepts, or classes in class models.
     */
    CONCEPT_MAP("ConceptMap", "ConceptMap"),

    /**
     * A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen
     * to a level of concern.
     */
    CONDITION("Condition", "Condition"),

    /** A definition of a condition and information relevant to managing it. */
    CONDITION_DEFINITION("ConditionDefinition", "ConditionDefinition"),

    /**
     * A record of a healthcare consumer’s choices or choices made on their behalf by a third party, which permits or
     * denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy
     * context, for specific purposes and periods of time.
     */
    CONSENT("Consent", "Consent"),

    /** Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement. */
    CONTRACT("Contract", "Contract"),

    /** Financial instrument which may be used to reimburse or pay for health care products and services. */
    COVERAGE("Coverage", "Coverage"),

    /**
     * The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to
     * respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage
     * is valid and in-force and optionally to provide the insurance details of the policy.
     */
    COVERAGE_ELIGIBILITY_REQUEST("CoverageEligibilityRequest", "CoverageEligibilityRequest"),

    /**
     * This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest
     * resource.
     */
    COVERAGE_ELIGIBILITY_RESPONSE("CoverageEligibilityResponse", "CoverageEligibilityResponse"),

    /**
     * Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions
     * for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, gaps
     * in care, etc.
     */
    DETECTED_ISSUE("DetectedIssue", "DetectedIssue"),

    /**
     * This resource describes the properties (regulated, has real time clock, etc.), adminstrative (manufacturer
     * name, model number, serial number, firmware, etc.), and type (knee replacement, blood pressure cuff, MRI, etc.)
     * of a physical unit (these values do not change much within a given module, for example the serail number,
     * manufacturer name, and model number).
     */
    DEVICE("Device", "Device"),

    /** A record of association of a device. */
    DEVICE_ASSOCIATION("DeviceAssociation", "DeviceAssociation"),

    /** This is a specialized resource that defines the characteristics and capabilities of a device. */
    DEVICE_DEFINITION("DeviceDefinition", "DeviceDefinition"),

    /** Indicates that a device is to be or has been dispensed for a named person/patient. */
    DEVICE_DISPENSE("DeviceDispense", "DeviceDispense"),

    /** Describes a measurement, calculation or setting capability of a device. */
    DEVICE_METRIC("DeviceMetric", "DeviceMetric"),

    /** Represents a request a device to be provided to a specific patient. */
    DEVICE_REQUEST("DeviceRequest", "DeviceRequest"),

    /**
     * A record of a device being used by a patient where the record is the result of a report from the patient or a
     * clinician.
     */
    DEVICE_USAGE("DeviceUsage", "DeviceUsage"),

    /**
     * The findings and interpretation of diagnostic tests performed on patients, groups of patients, products,
     * substances, devices, and locations, and/or specimens derived from these.
     */
    DIAGNOSTIC_REPORT("DiagnosticReport", "DiagnosticReport"),

    /** A reference to a document of any kind for any purpose. */
    DOCUMENT_REFERENCE("DocumentReference", "DocumentReference"),

    /**
     * An interaction between healthcare provider(s), and/or patient(s) for the purpose of providing healthcare
     * service(s) or assessing the health status of patient(s).
     */
    ENCOUNTER("Encounter", "Encounter"),

    /** A record of significant events/milestones key data throughout the history of an Encounter. */
    ENCOUNTER_HISTORY("EncounterHistory", "EncounterHistory"),

    /**
     * The technical details of an endpoint that can be used for electronic services, such as for web services
     * providing XDS.b, a REST endpoint for another FHIR server, or a s/Mime email address.
     */
    ENDPOINT("Endpoint", "Endpoint"),

    /** This resource provides the insurance enrollment details to the insurer regarding a specified coverage. */
    ENROLLMENT_REQUEST("EnrollmentRequest", "EnrollmentRequest"),

    /** This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource. */
    ENROLLMENT_RESPONSE("EnrollmentResponse", "EnrollmentResponse"),

    /**
     * An association between a patient and an organization / healthcare provider(s) during which time encounters may
     * occur.
     */
    EPISODE_OF_CARE("EpisodeOfCare", "EpisodeOfCare"),

    /** The EventDefinition resource provides a reusable description of when a particular event can occur. */
    EVENT_DEFINITION("EventDefinition", "EventDefinition"),

    /**
     * The Evidence Resource provides a machine-interpretable expression of an evidence concept including the evidence
     * variables (e.g., population, exposures/interventions, comparators, outcomes, measured variables, confounding
     * variables), the statistics, and the certainty of this evidence.
     */
    EVIDENCE("Evidence", "Evidence"),

    /**
     * The EvidenceReport Resource is a specialized container for a collection of resources and codeable concepts,
     * adapted to support compositions of Evidence, EvidenceVariable, and Citation resources and related concepts.
     */
    EVIDENCE_REPORT("EvidenceReport", "EvidenceReport"),

    /** The EvidenceVariable resource describes an element that knowledge (Evidence) is about. */
    EVIDENCE_VARIABLE("EvidenceVariable", "EvidenceVariable"),

    /**
     * A walkthrough of a workflow showing the interaction between systems and the instances shared, possibly
     * including the evolution of instances over time.
     */
    EXAMPLE_SCENARIO("ExampleScenario", "ExampleScenario"),

    /**
     * This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally
     * account balance information, for informing the subscriber of the benefits provided.
     */
    EXPLANATION_OF_BENEFIT("ExplanationOfBenefit", "ExplanationOfBenefit"),

    /**
     * Significant health conditions for a person related to the patient relevant in the context of care for the
     * patient.
     */
    FAMILY_MEMBER_HISTORY("FamilyMemberHistory", "FamilyMemberHistory"),

    /** Prospective warnings of potential issues when providing care to the patient. */
    FLAG("Flag", "Flag"),

    /**
     * This resource describes a product or service that is available through a program and includes the conditions
     * and constraints of availability.
     */
    FORMULARY_ITEM("FormularyItem", "FormularyItem"),

    /** A set of analyses performed to analyze and generate genomic data. */
    GENOMIC_STUDY("GenomicStudy", "GenomicStudy"),

    /**
     * Describes the intended objective(s) for a patient, group or organization care, for example, weight loss,
     * restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement
     * objective, etc.
     */
    GOAL("Goal", "Goal"),

    /**
     * A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph
     * by following references.
     */
    GRAPH_DEFINITION("GraphDefinition", "GraphDefinition"),

    /**
     * Represents a defined collection of entities that may be discussed or acted upon collectively but which are not
     * expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that
     * isn't an Organization.
     */
    GROUP("Group", "Group"),

    /**
     * A guidance response is the formal response to a guidance request, including any output parameters returned by
     * the evaluation, as well as the description of any proposed actions to be taken.
     */
    GUIDANCE_RESPONSE("GuidanceResponse", "GuidanceResponse"),

    /** The details of a healthcare service available at a location or in a catalog. */
    HEALTHCARE_SERVICE("HealthcareService", "HealthcareService"),

    /** A selection of DICOM SOP instances and/or frames within a single Study and Series. */
    IMAGING_SELECTION("ImagingSelection", "ImagingSelection"),

    /** Representation of the content produced in a DICOM imaging study. */
    IMAGING_STUDY("ImagingStudy", "ImagingStudy"),

    /**
     * Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a
     * patient, a clinician or another party.
     */
    IMMUNIZATION("Immunization", "Immunization"),

    /**
     * Describes a comparison of an immunization event against published recommendations to determine if the
     * administration is "valid" in relation to those recommendations.
     */
    IMMUNIZATION_EVALUATION("ImmunizationEvaluation", "ImmunizationEvaluation"),

    /**
     * A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with
     * optional supporting justification.
     */
    IMMUNIZATION_RECOMMENDATION("ImmunizationRecommendation", "ImmunizationRecommendation"),

    /**
     * A set of rules of how a particular interoperability or standards problem is solved - typically through the use
     * of FHIR resources.
     */
    IMPLEMENTATION_GUIDE("ImplementationGuide", "ImplementationGuide"),

    /** An ingredient of a manufactured item or pharmaceutical product. */
    INGREDIENT("Ingredient", "Ingredient"),

    /** Details of a Health Insurance product/plan provided by an organization. */
    INSURANCE_PLAN("InsurancePlan", "InsurancePlan"),

    /** functional description of an inventory item used in inventory and supply-related workflows. */
    INVENTORY_ITEM("InventoryItem", "InventoryItem"),

    /** A report of inventory or stock items. */
    INVENTORY_REPORT("InventoryReport", "InventoryReport"),

    /**
     * Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing
     * purpose.
     */
    INVOICE("Invoice", "Invoice"),

    /** The Library resource is a general-purpose container for knowledge asset definitions. */
    LIBRARY("Library", "Library"),

    /** Identifies two or more records (resource instances) that refer to the same real-world "occurrence". */
    LINKAGE("Linkage", "Linkage"),

    /**
     * A List is a curated collection of resources, for things such as problem lists, allergy lists, facility list,
     * organization list, etc.
     */
    LIST("List", "List"),

    /**
     * Details and position information for a place where services are provided and resources and participants may be
     * stored, found, contained, or accommodated.
     */
    LOCATION("Location", "Location"),

    /**
     * The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained
     * in a packaged medicinal product.
     */
    MANUFACTURED_ITEM_DEFINITION("ManufacturedItemDefinition", "ManufacturedItemDefinition"),

    /** The Measure resource provides the definition of a quality measure. */
    MEASURE("Measure", "Measure"),

    /**
     * The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to
     * the resources involved in that calculation.
     */
    MEASURE_REPORT("MeasureReport", "MeasureReport"),

    /**
     * This resource is primarily used for the identification and definition of a medication, including ingredients,
     * for the purposes of prescribing, dispensing, and administering a medication as well as for making statements
     * about medication use.
     */
    MEDICATION("Medication", "Medication"),

    /** Describes the event of a patient consuming or otherwise being administered a medication. */
    MEDICATION_ADMINISTRATION("MedicationAdministration", "MedicationAdministration"),

    /** Indicates that a medication product is to be or has been dispensed for a named person/patient. */
    MEDICATION_DISPENSE("MedicationDispense", "MedicationDispense"),

    /** Information about a medication that is used to support knowledge. */
    MEDICATION_KNOWLEDGE("MedicationKnowledge", "MedicationKnowledge"),

    /**
     * An order or request for both supply of the medication and the instructions for administration of the medication
     * to a patient.
     */
    MEDICATION_REQUEST("MedicationRequest", "MedicationRequest"),

    /** A record of a medication that is being consumed by a patient. */
    MEDICATION_STATEMENT("MedicationStatement", "MedicationStatement"),

    /**
     * Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory
     * use, drug catalogs, to support prescribing, adverse events management etc.).
     */
    MEDICINAL_PRODUCT_DEFINITION("MedicinalProductDefinition", "MedicinalProductDefinition"),

    /**
     * Defines the characteristics of a message that can be shared between systems, including the type of event that
     * initiates the message, the content to be transmitted and what response(s), if any, are permitted.
     */
    MESSAGE_DEFINITION("MessageDefinition", "MessageDefinition"),

    /** The header for a message exchange that is either requesting or responding to an action. */
    MESSAGE_HEADER("MessageHeader", "MessageHeader"),

    /** Common Interface declaration for conformance and knowledge artifact resources. */
    METADATA_RESOURCE("MetadataResource", "MetadataResource"),

    /** Representation of a molecular sequence. */
    MOLECULAR_SEQUENCE("MolecularSequence", "MolecularSequence"),

    /**
     * A curated namespace that issues unique symbols within that namespace for the identification of concepts,
     * people, devices, etc. Represents a "System" used within the Identifier and Coding data types.
     */
    NAMING_SYSTEM("NamingSystem", "NamingSystem"),

    /** A record of food or fluid that is being consumed by a patient. */
    NUTRITION_INTAKE("NutritionIntake", "NutritionIntake"),

    /** A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident. */
    NUTRITION_ORDER("NutritionOrder", "NutritionOrder"),

    /** A food or supplement that is consumed by patients. */
    NUTRITION_PRODUCT("NutritionProduct", "NutritionProduct"),

    /** Measurements and simple assertions made about a patient, device or other subject. */
    OBSERVATION("Observation", "Observation"),

    /**
     * Set of definitional characteristics for a kind of observation or measurement produced or consumed by an
     * orderable health care service.
     */
    OBSERVATION_DEFINITION("ObservationDefinition", "ObservationDefinition"),

    /**
     * A formal computable definition of an operation (on the RESTful interface) or a named query (using the search
     * interaction).
     */
    OPERATION_DEFINITION("OperationDefinition", "OperationDefinition"),

    /** A collection of error, warning, or information messages that result from a system action. */
    OPERATION_OUTCOME("OperationOutcome", "OperationOutcome"),

    /**
     * A formally or informally recognized grouping of people or organizations formed for the purpose of achieving
     * some form of collective action.
     */
    ORGANIZATION("Organization", "Organization"),

    /**
     * Defines an affiliation/assotiation/relationship between 2 distinct organizations, that is not a part-of
     * relationship/sub-division relationship.
     */
    ORGANIZATION_AFFILIATION("OrganizationAffiliation", "OrganizationAffiliation"),

    /** A medically related item or items, in a container or package. */
    PACKAGED_PRODUCT_DEFINITION("PackagedProductDefinition", "PackagedProductDefinition"),

    /**
     * Demographics and other administrative information about an individual or animal receiving care or other
     * health-related services.
     */
    PATIENT("Patient", "Patient"),

    /**
     * This resource provides the status of the payment for goods and services rendered, and the request and response
     * resource references.
     */
    PAYMENT_NOTICE("PaymentNotice", "PaymentNotice"),

    /**
     * This resource provides the details including amount of a payment and allocates the payment items being paid.
     */
    PAYMENT_RECONCILIATION("PaymentReconciliation", "PaymentReconciliation"),

    /** Permission resource holds access rules for a given data and context. */
    PERMISSION("Permission", "Permission"),

    /**
     * Demographics and administrative information about a person independent of a specific health-related context.
     */
    PERSON("Person", "Person"),

    /**
     * This resource allows for the definition of various types of plans as a sharable, consumable, and executable
     * artifact.
     */
    PLAN_DEFINITION("PlanDefinition", "PlanDefinition"),

    /** A person who is directly or indirectly involved in the provisioning of healthcare or related services. */
    PRACTITIONER("Practitioner", "Practitioner"),

    /**
     * A specific set of Roles/Locations/specialties/services that a practitioner may perform, or has performed at an
     * organization during a period of time.
     */
    PRACTITIONER_ROLE("PractitionerRole", "PractitionerRole"),

    /** An action that is or was performed on or for a patient, practitioner, device, organization, or location. */
    PROCEDURE("Procedure", "Procedure"),

    /**
     * Provenance of a resource is a record that describes entities and processes involved in producing and delivering
     * or otherwise influencing that resource.
     */
    PROVENANCE("Provenance", "Provenance"),

    /** A structured set of questions intended to guide the collection of answers from end-users. */
    QUESTIONNAIRE("Questionnaire", "Questionnaire"),

    /** A structured set of questions and their answers. */
    QUESTIONNAIRE_RESPONSE("QuestionnaireResponse", "QuestionnaireResponse"),

    /**
     * Regulatory approval, clearance or licencing related to a regulated product, treatment, facility or activity
     * that is cited in a guidance, regulation, rule or legislative act.
     */
    REGULATED_AUTHORIZATION("RegulatedAuthorization", "RegulatedAuthorization"),

    /**
     * Information about a person that is involved in a patient's health or the care for a patient, but who is not the
     * target of healthcare, nor has a formal responsibility in the care process.
     */
    RELATED_PERSON("RelatedPerson", "RelatedPerson"),

    /**
     * A set of related requests that can be used to capture intended activities that have inter-dependencies such as
     * "give this medication after that one".
     */
    REQUEST_ORCHESTRATION("RequestOrchestration", "RequestOrchestration"),

    /**
     * The Requirements resource is used to describe an actor - a human or an application that plays a role in data
     * exchange, and that may have obligations associated with the role the actor plays.
     */
    REQUIREMENTS("Requirements", "Requirements"),

    /** A scientific study of nature that sometimes includes processes involved in health and disease. */
    RESEARCH_STUDY("ResearchStudy", "ResearchStudy"),

    /**
     * A ResearchSubject is a participant or object which is the recipient of investigative activities in a research
     * study.
     */
    RESEARCH_SUBJECT("ResearchSubject", "ResearchSubject"),

    /**
     * An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each
     * outcome.
     */
    RISK_ASSESSMENT("RiskAssessment", "RiskAssessment"),

    /** A container for slots of time that may be available for booking appointments. */
    SCHEDULE("Schedule", "Schedule"),

    /** A search parameter that defines a named search item that can be used to search/filter on a resource. */
    SEARCH_PARAMETER("SearchParameter", "SearchParameter"),

    /**
     * A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.
     */
    SERVICE_REQUEST("ServiceRequest", "ServiceRequest"),

    /** A slot of time on a schedule that may be available for booking appointments. */
    SLOT("Slot", "Slot"),

    /** A sample to be used for analysis. */
    SPECIMEN("Specimen", "Specimen"),

    /** A kind of specimen with associated set of requirements. */
    SPECIMEN_DEFINITION("SpecimenDefinition", "SpecimenDefinition"),

    /** A definition of a FHIR structure. */
    STRUCTURE_DEFINITION("StructureDefinition", "StructureDefinition"),

    /** A Map of relationships between 2 structures that can be used to transform data. */
    STRUCTURE_MAP("StructureMap", "StructureMap"),

    /** The subscription resource describes a particular client's request to be notified about a SubscriptionTopic. */
    SUBSCRIPTION("Subscription", "Subscription"),

    /** The SubscriptionStatus resource describes the state of a Subscription during notifications. */
    SUBSCRIPTION_STATUS("SubscriptionStatus", "SubscriptionStatus"),

    /**
     * Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to
     * filter projections from this topic.
     */
    SUBSCRIPTION_TOPIC("SubscriptionTopic", "SubscriptionTopic"),

    /** A homogeneous material with a definite composition. */
    SUBSTANCE("Substance", "Substance"),

    /** The detailed description of a substance, typically at a level beyond what is used for prescribing. */
    SUBSTANCE_DEFINITION("SubstanceDefinition", "SubstanceDefinition"),

    /** Nucleic acids are defined by three distinct elements: the base, sugar and linkage. */
    SUBSTANCE_NUCLEIC_ACID("SubstanceNucleicAcid", "SubstanceNucleicAcid"),

    /** Properties of a substance specific to it being a polymer. */
    SUBSTANCE_POLYMER("SubstancePolymer", "SubstancePolymer"),

    /**
     * A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits
     * that are either covalently linked or have a defined invariant stoichiometric relationship.
     */
    SUBSTANCE_PROTEIN("SubstanceProtein", "SubstanceProtein"),

    /** Todo. */
    SUBSTANCE_REFERENCE_INFORMATION("SubstanceReferenceInformation", "SubstanceReferenceInformation"),

    /**
     * Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a
     * material that can result in or can be modified to form a substance.
     */
    SUBSTANCE_SOURCE_MATERIAL("SubstanceSourceMaterial", "SubstanceSourceMaterial"),

    /** Record of delivery of what is supplied. */
    SUPPLY_DELIVERY("SupplyDelivery", "SupplyDelivery"),

    /**
     * A record of a non-patient specific request for a medication, substance, device, certain types of biologically
     * derived product, and nutrition product used in the healthcare setting.
     */
    SUPPLY_REQUEST("SupplyRequest", "SupplyRequest"),

    /** A task to be performed. */
    TASK("Task", "Task"),

    /**
     * A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server
     * that may be used as a statement of actual server functionality or a statement of required or desired server
     * implementation.
     */
    TERMINOLOGY_CAPABILITIES("TerminologyCapabilities", "TerminologyCapabilities"),

    /** A plan for executing testing on an artifact or specifications. */
    TEST_PLAN("TestPlan", "TestPlan"),

    /** A summary of information based on the results of executing a TestScript. */
    TEST_REPORT("TestReport", "TestReport"),

    /**
     * A structured set of tests against a FHIR server or client implementation to determine compliance against the
     * FHIR specification.
     */
    TEST_SCRIPT("TestScript", "TestScript"),

    /** Record of transport. */
    TRANSPORT("Transport", "Transport"),

    /**
     * A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in
     * a particular context.
     */
    VALUE_SET("ValueSet", "ValueSet"),

    /** Describes validation requirements, source(s), status and dates for one or more elements. */
    VERIFICATION_RESULT("VerificationResult", "VerificationResult"),

    /** An authorization for the provision of glasses and/or contact lenses to a patient. */
    VISION_PRESCRIPTION("VisionPrescription", "VisionPrescription"),

    /**
     * This resource is used to pass information into and back from an operation (whether invoked directly from REST
     * or within a messaging environment).
     */
    PARAMETERS("Parameters", "Parameters");

    private final String code;
    private final String display;

    FHIRTypes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/fhir-types";
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
    public static FHIRTypes fromCode(String code) {
        for (FHIRTypes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown FHIRTypes code: '" + code + "'");
    }
}
