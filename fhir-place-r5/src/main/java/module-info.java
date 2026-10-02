/**
 * FHIR R5 resource model: immutable records for resources and datatypes, with builders.
 *
 * <p>Packages follow the resource categories of the FHIR specification, for example
 * {@code se.poroli.fhirplace.r5.base.individuals} for the "Base / Individuals" resources.
 */
module se.poroli.fhirplace.r5 {
    exports se.poroli.fhirplace.r5;
    exports se.poroli.fhirplace.r5.base.entities1;
    exports se.poroli.fhirplace.r5.base.entities2;
    exports se.poroli.fhirplace.r5.base.individuals;
    exports se.poroli.fhirplace.r5.base.management;
    exports se.poroli.fhirplace.r5.base.workflow;
    exports se.poroli.fhirplace.r5.clinical.careprovision;
    exports se.poroli.fhirplace.r5.clinical.diagnostics;
    exports se.poroli.fhirplace.r5.clinical.medications;
    exports se.poroli.fhirplace.r5.clinical.requestresponse;
    exports se.poroli.fhirplace.r5.clinical.summary;
    exports se.poroli.fhirplace.r5.datatypes;
    exports se.poroli.fhirplace.r5.financial.billing;
    exports se.poroli.fhirplace.r5.financial.general;
    exports se.poroli.fhirplace.r5.financial.payment;
    exports se.poroli.fhirplace.r5.financial.support;
    exports se.poroli.fhirplace.r5.foundation.conformance;
    exports se.poroli.fhirplace.r5.foundation.documents;
    exports se.poroli.fhirplace.r5.foundation.other;
    exports se.poroli.fhirplace.r5.foundation.security;
    exports se.poroli.fhirplace.r5.foundation.terminology;
    exports se.poroli.fhirplace.r5.specialized.definitionalartifacts;
    exports se.poroli.fhirplace.r5.specialized.evidencebasedmedicine;
    exports se.poroli.fhirplace.r5.specialized.medicationdefinition;
    exports se.poroli.fhirplace.r5.specialized.publichealthresearch;
    exports se.poroli.fhirplace.r5.specialized.qualityreportingtesting;
    exports se.poroli.fhirplace.r5.valuesets;
}
