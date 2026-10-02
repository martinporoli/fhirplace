package se.poroli.fhirplace.r5.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.FhirFormatException;
import se.poroli.fhirplace.r5.FhirFormatException.Problem;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.xml.FhirXml;

/** Content that cannot be read is reported with what is wrong and where. */
class ParseErrorTest {

    private static FhirFormatException json(String json) {
        return assertThrows(FhirFormatException.class, () -> FhirJson.read(json));
    }

    private static FhirFormatException xml(String xml) {
        return assertThrows(FhirFormatException.class, () -> FhirXml.read(xml));
    }

    private static void assertProblem(Problem problem, String expression, FhirFormatException e) {
        assertEquals(problem, e.problem(), e.getMessage());
        assertEquals(expression, e.expression(), e.getMessage());
    }

    @Test
    void malformedContentIsASyntaxError() {
        FhirFormatException json = json("{\"resourceType\":\"Patient\",");
        FhirFormatException xml = xml("<Patient xmlns=\"http://hl7.org/fhir\">");

        assertProblem(Problem.SYNTAX, null, json);
        assertProblem(Problem.SYNTAX, null, xml);
    }

    @Test
    void unknownElementsAndTypesAreStructureErrors() {
        FhirFormatException unknown = json("{\"resourceType\":\"Patient\",\"shoeSize\":42}");

        assertProblem(Problem.STRUCTURE, "Patient", unknown);
        assertEquals("unknown element 'shoeSize'", unknown.detail());
        assertProblem(Problem.STRUCTURE, "Patient.active", json("{\"resourceType\":\"Patient\",\"active\":{}}"));
        assertProblem(Problem.STRUCTURE, "Nope", json("{\"resourceType\":\"Nope\"}"));
        assertProblem(Problem.STRUCTURE, null, json("{\"id\":\"x\"}"));
        assertProblem(Problem.STRUCTURE, "Patient.contact[0]",
                xml("<Patient xmlns=\"http://hl7.org/fhir\"><contact><shoeSize value=\"42\"/></contact></Patient>"));
    }

    @Test
    void choiceValuesOfAnotherTypeAreStructureErrors() {
        assertProblem(Problem.STRUCTURE, "Patient",
                json("{\"resourceType\":\"Patient\",\"deceasedString\":\"maybe\"}"));
    }

    @Test
    void missingRequiredElementsAreReportedWhereTheyBelong() {
        FhirFormatException missing = json("{\"resourceType\":\"Patient\",\"link\":[{\"type\":\"refer\"}]}");

        assertProblem(Problem.REQUIRED, "Patient.link[0]", missing);
        assertTrue(missing.detail().contains("other"), missing.detail());
        assertProblem(Problem.REQUIRED, "Patient.link[0]",
                xml("<Patient xmlns=\"http://hl7.org/fhir\"><link><type value=\"refer\"/></link></Patient>"));
        assertProblem(Problem.REQUIRED, "BodyStructure",
                json("{\"resourceType\":\"BodyStructure\",\"patient\":{\"reference\":\"Patient/1\"}}"));
    }

    @Test
    void invalidValuesAreValueErrors() {
        assertProblem(Problem.VALUE, "Patient.birthDate",
                json("{\"resourceType\":\"Patient\",\"birthDate\":\"1974-13-45\"}"));
        assertProblem(Problem.VALUE, "Patient.gender", json("{\"resourceType\":\"Patient\",\"gender\":\"robot\"}"));
        assertProblem(Problem.VALUE, "Patient.birthDate",
                xml("<Patient xmlns=\"http://hl7.org/fhir\"><birthDate value=\"yesterday\"/></Patient>"));
    }

    @Test
    void errorsDeepInListsAreLocatedByIndex() {
        String json = """
                {"resourceType":"Patient","contact":[{"gender":"male"},{"gender":"robot"}]}""";
        String xml = """
                <Patient xmlns="http://hl7.org/fhir"><contact><gender value="male"/></contact>\
                <contact><gender value="robot"/></contact></Patient>""";

        assertProblem(Problem.VALUE, "Patient.contact[1].gender", json(json));
        assertProblem(Problem.VALUE, "Patient.contact[1].gender", xml(xml));
    }

    @Test
    void readingAnotherTypeThanExpectedIsAStructureError() {
        FhirFormatException e = assertThrows(FhirFormatException.class,
                () -> FhirJson.read("{\"resourceType\":\"Basic\",\"code\":{\"text\":\"x\"}}", Patient.class));

        assertProblem(Problem.STRUCTURE, "Basic", e);
    }
}
