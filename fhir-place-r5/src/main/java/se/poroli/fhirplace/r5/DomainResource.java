package se.poroli.fhirplace.r5;

import java.util.List;
import se.poroli.fhirplace.r5.base.entities1.Endpoint;
import se.poroli.fhirplace.r5.base.entities1.HealthcareService;
import se.poroli.fhirplace.r5.base.entities1.Location;
import se.poroli.fhirplace.r5.base.entities1.Organization;
import se.poroli.fhirplace.r5.base.entities1.OrganizationAffiliation;
import se.poroli.fhirplace.r5.base.entities2.BiologicallyDerivedProduct;
import se.poroli.fhirplace.r5.base.entities2.Device;
import se.poroli.fhirplace.r5.base.entities2.DeviceMetric;
import se.poroli.fhirplace.r5.base.entities2.NutritionProduct;
import se.poroli.fhirplace.r5.base.entities2.Substance;
import se.poroli.fhirplace.r5.base.individuals.Group;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.base.individuals.Person;
import se.poroli.fhirplace.r5.base.individuals.Practitioner;
import se.poroli.fhirplace.r5.base.individuals.PractitionerRole;
import se.poroli.fhirplace.r5.base.individuals.RelatedPerson;
import se.poroli.fhirplace.r5.base.management.Encounter;
import se.poroli.fhirplace.r5.base.management.EncounterHistory;
import se.poroli.fhirplace.r5.base.management.EpisodeOfCare;
import se.poroli.fhirplace.r5.base.management.Flag;
import se.poroli.fhirplace.r5.base.management.Library;
import se.poroli.fhirplace.r5.base.workflow.Appointment;
import se.poroli.fhirplace.r5.base.workflow.AppointmentResponse;
import se.poroli.fhirplace.r5.base.workflow.Schedule;
import se.poroli.fhirplace.r5.base.workflow.Slot;
import se.poroli.fhirplace.r5.base.workflow.Task;
import se.poroli.fhirplace.r5.base.workflow.Transport;
import se.poroli.fhirplace.r5.base.workflow.VerificationResult;
import se.poroli.fhirplace.r5.clinical.careprovision.CarePlan;
import se.poroli.fhirplace.r5.clinical.careprovision.CareTeam;
import se.poroli.fhirplace.r5.clinical.careprovision.Goal;
import se.poroli.fhirplace.r5.clinical.careprovision.NutritionIntake;
import se.poroli.fhirplace.r5.clinical.careprovision.NutritionOrder;
import se.poroli.fhirplace.r5.clinical.careprovision.RequestOrchestration;
import se.poroli.fhirplace.r5.clinical.careprovision.RiskAssessment;
import se.poroli.fhirplace.r5.clinical.careprovision.ServiceRequest;
import se.poroli.fhirplace.r5.clinical.careprovision.VisionPrescription;
import se.poroli.fhirplace.r5.clinical.diagnostics.BodyStructure;
import se.poroli.fhirplace.r5.clinical.diagnostics.DiagnosticReport;
import se.poroli.fhirplace.r5.clinical.diagnostics.GenomicStudy;
import se.poroli.fhirplace.r5.clinical.diagnostics.ImagingSelection;
import se.poroli.fhirplace.r5.clinical.diagnostics.ImagingStudy;
import se.poroli.fhirplace.r5.clinical.diagnostics.MolecularSequence;
import se.poroli.fhirplace.r5.clinical.diagnostics.Observation;
import se.poroli.fhirplace.r5.clinical.diagnostics.QuestionnaireResponse;
import se.poroli.fhirplace.r5.clinical.diagnostics.Specimen;
import se.poroli.fhirplace.r5.clinical.medications.FormularyItem;
import se.poroli.fhirplace.r5.clinical.medications.Immunization;
import se.poroli.fhirplace.r5.clinical.medications.ImmunizationEvaluation;
import se.poroli.fhirplace.r5.clinical.medications.ImmunizationRecommendation;
import se.poroli.fhirplace.r5.clinical.medications.Medication;
import se.poroli.fhirplace.r5.clinical.medications.MedicationAdministration;
import se.poroli.fhirplace.r5.clinical.medications.MedicationDispense;
import se.poroli.fhirplace.r5.clinical.medications.MedicationKnowledge;
import se.poroli.fhirplace.r5.clinical.medications.MedicationRequest;
import se.poroli.fhirplace.r5.clinical.medications.MedicationStatement;
import se.poroli.fhirplace.r5.clinical.requestresponse.BiologicallyDerivedProductDispense;
import se.poroli.fhirplace.r5.clinical.requestresponse.Communication;
import se.poroli.fhirplace.r5.clinical.requestresponse.CommunicationRequest;
import se.poroli.fhirplace.r5.clinical.requestresponse.DeviceAssociation;
import se.poroli.fhirplace.r5.clinical.requestresponse.DeviceDispense;
import se.poroli.fhirplace.r5.clinical.requestresponse.DeviceRequest;
import se.poroli.fhirplace.r5.clinical.requestresponse.DeviceUsage;
import se.poroli.fhirplace.r5.clinical.requestresponse.GuidanceResponse;
import se.poroli.fhirplace.r5.clinical.requestresponse.InventoryItem;
import se.poroli.fhirplace.r5.clinical.requestresponse.InventoryReport;
import se.poroli.fhirplace.r5.clinical.requestresponse.SupplyDelivery;
import se.poroli.fhirplace.r5.clinical.requestresponse.SupplyRequest;
import se.poroli.fhirplace.r5.clinical.summary.AdverseEvent;
import se.poroli.fhirplace.r5.clinical.summary.AllergyIntolerance;
import se.poroli.fhirplace.r5.clinical.summary.ClinicalImpression;
import se.poroli.fhirplace.r5.clinical.summary.Condition;
import se.poroli.fhirplace.r5.clinical.summary.DetectedIssue;
import se.poroli.fhirplace.r5.clinical.summary.FamilyMemberHistory;
import se.poroli.fhirplace.r5.clinical.summary.Procedure;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.financial.billing.Claim;
import se.poroli.fhirplace.r5.financial.billing.ClaimResponse;
import se.poroli.fhirplace.r5.financial.billing.Invoice;
import se.poroli.fhirplace.r5.financial.general.Account;
import se.poroli.fhirplace.r5.financial.general.ChargeItem;
import se.poroli.fhirplace.r5.financial.general.ChargeItemDefinition;
import se.poroli.fhirplace.r5.financial.general.Contract;
import se.poroli.fhirplace.r5.financial.general.ExplanationOfBenefit;
import se.poroli.fhirplace.r5.financial.general.InsurancePlan;
import se.poroli.fhirplace.r5.financial.payment.PaymentNotice;
import se.poroli.fhirplace.r5.financial.payment.PaymentReconciliation;
import se.poroli.fhirplace.r5.financial.support.Coverage;
import se.poroli.fhirplace.r5.financial.support.CoverageEligibilityRequest;
import se.poroli.fhirplace.r5.financial.support.CoverageEligibilityResponse;
import se.poroli.fhirplace.r5.financial.support.EnrollmentRequest;
import se.poroli.fhirplace.r5.financial.support.EnrollmentResponse;
import se.poroli.fhirplace.r5.foundation.conformance.CapabilityStatement;
import se.poroli.fhirplace.r5.foundation.conformance.CompartmentDefinition;
import se.poroli.fhirplace.r5.foundation.conformance.GraphDefinition;
import se.poroli.fhirplace.r5.foundation.conformance.ImplementationGuide;
import se.poroli.fhirplace.r5.foundation.conformance.MessageDefinition;
import se.poroli.fhirplace.r5.foundation.conformance.OperationDefinition;
import se.poroli.fhirplace.r5.foundation.conformance.SearchParameter;
import se.poroli.fhirplace.r5.foundation.conformance.StructureDefinition;
import se.poroli.fhirplace.r5.foundation.conformance.StructureMap;
import se.poroli.fhirplace.r5.foundation.documents.Composition;
import se.poroli.fhirplace.r5.foundation.documents.DocumentReference;
import se.poroli.fhirplace.r5.foundation.other.Basic;
import se.poroli.fhirplace.r5.foundation.other.Linkage;
import se.poroli.fhirplace.r5.foundation.other.MessageHeader;
import se.poroli.fhirplace.r5.foundation.other.OperationOutcome;
import se.poroli.fhirplace.r5.foundation.other.Subscription;
import se.poroli.fhirplace.r5.foundation.other.SubscriptionStatus;
import se.poroli.fhirplace.r5.foundation.other.SubscriptionTopic;
import se.poroli.fhirplace.r5.foundation.security.AuditEvent;
import se.poroli.fhirplace.r5.foundation.security.Consent;
import se.poroli.fhirplace.r5.foundation.security.Permission;
import se.poroli.fhirplace.r5.foundation.security.Provenance;
import se.poroli.fhirplace.r5.foundation.terminology.CodeSystem;
import se.poroli.fhirplace.r5.foundation.terminology.ConceptMap;
import se.poroli.fhirplace.r5.foundation.terminology.NamingSystem;
import se.poroli.fhirplace.r5.foundation.terminology.TerminologyCapabilities;
import se.poroli.fhirplace.r5.foundation.terminology.ValueSet;
import se.poroli.fhirplace.r5.specialized.definitionalartifacts.ActivityDefinition;
import se.poroli.fhirplace.r5.specialized.definitionalartifacts.ActorDefinition;
import se.poroli.fhirplace.r5.specialized.definitionalartifacts.ConditionDefinition;
import se.poroli.fhirplace.r5.specialized.definitionalartifacts.DeviceDefinition;
import se.poroli.fhirplace.r5.specialized.definitionalartifacts.EventDefinition;
import se.poroli.fhirplace.r5.specialized.definitionalartifacts.ExampleScenario;
import se.poroli.fhirplace.r5.specialized.definitionalartifacts.ObservationDefinition;
import se.poroli.fhirplace.r5.specialized.definitionalartifacts.PlanDefinition;
import se.poroli.fhirplace.r5.specialized.definitionalartifacts.Questionnaire;
import se.poroli.fhirplace.r5.specialized.definitionalartifacts.Requirements;
import se.poroli.fhirplace.r5.specialized.definitionalartifacts.SpecimenDefinition;
import se.poroli.fhirplace.r5.specialized.evidencebasedmedicine.ArtifactAssessment;
import se.poroli.fhirplace.r5.specialized.evidencebasedmedicine.Citation;
import se.poroli.fhirplace.r5.specialized.evidencebasedmedicine.Evidence;
import se.poroli.fhirplace.r5.specialized.evidencebasedmedicine.EvidenceReport;
import se.poroli.fhirplace.r5.specialized.evidencebasedmedicine.EvidenceVariable;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.AdministrableProductDefinition;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.ClinicalUseDefinition;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.Ingredient;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.ManufacturedItemDefinition;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.MedicinalProductDefinition;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.PackagedProductDefinition;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.RegulatedAuthorization;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.SubstanceDefinition;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.SubstanceNucleicAcid;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.SubstancePolymer;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.SubstanceProtein;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.SubstanceReferenceInformation;
import se.poroli.fhirplace.r5.specialized.medicationdefinition.SubstanceSourceMaterial;
import se.poroli.fhirplace.r5.specialized.publichealthresearch.ResearchStudy;
import se.poroli.fhirplace.r5.specialized.publichealthresearch.ResearchSubject;
import se.poroli.fhirplace.r5.specialized.qualityreportingtesting.Measure;
import se.poroli.fhirplace.r5.specialized.qualityreportingtesting.MeasureReport;
import se.poroli.fhirplace.r5.specialized.qualityreportingtesting.TestPlan;
import se.poroli.fhirplace.r5.specialized.qualityreportingtesting.TestReport;
import se.poroli.fhirplace.r5.specialized.qualityreportingtesting.TestScript;

/**
 * A resource that includes narrative, extensions, and contained resources.
 *
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DomainResource">FHIR R5 DomainResource</a>
 */
public sealed interface DomainResource extends Resource
        permits CapabilityStatement, StructureDefinition, ImplementationGuide, SearchParameter, MessageDefinition,
                OperationDefinition, CompartmentDefinition, StructureMap, GraphDefinition, CodeSystem, ValueSet,
                ConceptMap, NamingSystem, TerminologyCapabilities, Provenance, AuditEvent, Permission, Consent,
                Composition, DocumentReference, Basic, Linkage, MessageHeader, OperationOutcome, Subscription,
                SubscriptionStatus, SubscriptionTopic, Patient, Practitioner, PractitionerRole, RelatedPerson, Person,
                Group, Organization, OrganizationAffiliation, HealthcareService, Endpoint, Location, Substance,
                BiologicallyDerivedProduct, Device, DeviceMetric, NutritionProduct, Task, Transport, Appointment,
                AppointmentResponse, Schedule, Slot, VerificationResult, Encounter, EncounterHistory, EpisodeOfCare,
                Flag, se.poroli.fhirplace.r5.base.management.List, Library, AllergyIntolerance, AdverseEvent,
                Condition, Procedure, FamilyMemberHistory, ClinicalImpression, DetectedIssue, Observation,
                DiagnosticReport, Specimen, BodyStructure, ImagingSelection, ImagingStudy, QuestionnaireResponse,
                MolecularSequence, GenomicStudy, MedicationRequest, MedicationAdministration, MedicationDispense,
                MedicationStatement, Medication, MedicationKnowledge, Immunization, ImmunizationEvaluation,
                ImmunizationRecommendation, FormularyItem, CarePlan, CareTeam, Goal, ServiceRequest, NutritionOrder,
                NutritionIntake, VisionPrescription, RiskAssessment, RequestOrchestration, Communication,
                CommunicationRequest, DeviceRequest, DeviceDispense, DeviceAssociation, DeviceUsage,
                BiologicallyDerivedProductDispense, GuidanceResponse, SupplyRequest, SupplyDelivery, InventoryItem,
                InventoryReport, Coverage, CoverageEligibilityRequest, CoverageEligibilityResponse, EnrollmentRequest,
                EnrollmentResponse, Claim, ClaimResponse, Invoice, PaymentNotice, PaymentReconciliation, Account,
                ChargeItem, ChargeItemDefinition, Contract, ExplanationOfBenefit, InsurancePlan, ResearchStudy,
                ResearchSubject, ActivityDefinition, ConditionDefinition, DeviceDefinition, EventDefinition,
                ObservationDefinition, PlanDefinition, Questionnaire, SpecimenDefinition, ExampleScenario,
                ActorDefinition, Requirements, ArtifactAssessment, Citation, Evidence, EvidenceReport,
                EvidenceVariable, Measure, MeasureReport, TestPlan, TestScript, TestReport,
                MedicinalProductDefinition, PackagedProductDefinition, AdministrableProductDefinition,
                ManufacturedItemDefinition, Ingredient, ClinicalUseDefinition, RegulatedAuthorization,
                SubstanceDefinition, SubstanceNucleicAcid, SubstancePolymer, SubstanceProtein,
                SubstanceReferenceInformation, SubstanceSourceMaterial {

    /**
     * Text summary of the resource, for human interpretation.
     *
     * @return the text, or {@code null} if absent
     */
    Narrative text();

    /**
     * Contained, inline Resources.
     *
     * @return the contained, never {@code null}
     */
    List<Resource> contained();

    /**
     * Additional content defined by implementations.
     *
     * @return the extension, never {@code null}
     */
    List<Extension> extension();

    /**
     * Extensions that cannot be ignored. Modifier element.
     *
     * @return the modifierExtension, never {@code null}
     */
    List<Extension> modifierExtension();
}
