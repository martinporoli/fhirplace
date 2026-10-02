package se.poroli.fhirplace.r5.patient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.xml.FhirXml;

/** Reads and writes a Patient as FHIR JSON and XML with the resource module on the module path. */
class PatientFormatsTest {

    private static final String JSON = """
            {"resourceType":"Patient","id":"p1","active":true,"birthDate":"1974-12","_birthDate":{"id":"bd"},\
            "name":[{"family":"Chalmers","given":["Peter","James"]}]}""";

    @Test
    void runsAsANamedModule() {
        assertTrue(Patient.class.getModule().isNamed());
    }

    @Test
    void readsJsonByResourceTypeAndWritesItBack() {
        Resource resource = FhirJson.read(JSON);

        Patient patient = assertInstanceOfPatient(resource);
        assertEquals("bd", patient.birthDate().id());
        assertEquals(patient, FhirJson.read(FhirJson.write(patient)));
    }

    @Test
    void readsXmlByElementNameAndWritesItBack() {
        Patient patient = FhirJson.read(JSON, Patient.class);

        assertEquals(patient, FhirXml.read(FhirXml.write(patient), Patient.class));
    }

    private static Patient assertInstanceOfPatient(Resource resource) {
        assertEquals(Patient.class, resource.getClass());
        return (Patient) resource;
    }
}
