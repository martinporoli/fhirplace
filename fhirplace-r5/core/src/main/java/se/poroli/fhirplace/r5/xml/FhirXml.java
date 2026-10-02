package se.poroli.fhirplace.r5.xml;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Objects;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.internal.Errors;

/**
 * Reads resources from FHIR XML using StAX ({@code javax.xml.stream}) and writes them as FHIR XML.
 *
 * <p>Resource types are resolved from the element name: resource {@code X} must be available as module
 * {@code se.poroli.fhirplace.r5.<x>}, for example by depending on {@code fhirplace-r5-patient} for {@code Patient}.
 * Reading rejects malformed XML, elements the model does not know and values that violate the model's constraints
 * with a {@link se.poroli.fhirplace.r5.FhirFormatException} that tells what is wrong and where. DTDs and external
 * entities are not processed.
 *
 * @see <a href="https://hl7.org/fhir/R5/xml.html">FHIR R5 XML representation</a>
 */
public final class FhirXml {

    private FhirXml() {
    }

    /**
     * Writes a resource as FHIR XML.
     *
     * @param resource the resource
     * @return the XML text, without an XML declaration
     */
    public static String write(Resource resource) {
        StringWriter writer = new StringWriter();
        write(resource, writer);
        return writer.toString();
    }

    /**
     * Writes a resource as FHIR XML to a character stream. The writer is flushed but not closed.
     *
     * @param resource the resource
     * @param writer the destination
     */
    public static void write(Resource resource, Writer writer) {
        Objects.requireNonNull(resource, "resource");
        XmlWriter xml = new XmlWriter(Objects.requireNonNull(writer, "writer"));
        try {
            XmlCodec.writeResource(xml, resource, true);
        } catch (XMLStreamException e) {
            throw new IllegalStateException("Invalid narrative XHTML: " + e.getMessage(), e);
        }
        xml.flush();
    }

    /**
     * Reads a resource from FHIR XML.
     *
     * @param xml the XML text of one resource
     * @return the resource, of the class named by its root element
     * @throws se.poroli.fhirplace.r5.FhirFormatException if the text is not a valid FHIR resource for this model
     */
    public static Resource read(String xml) {
        return read(new StringReader(Objects.requireNonNull(xml, "xml")));
    }

    /**
     * Reads a resource of an expected type from FHIR XML.
     *
     * @param xml the XML text of one resource
     * @param type the expected resource class
     * @param <T> the resource type
     * @return the resource
     * @throws se.poroli.fhirplace.r5.FhirFormatException if the text is not a valid FHIR resource of that type
     */
    public static <T extends Resource> T read(String xml, Class<T> type) {
        Resource resource = read(xml);
        if (!type.isInstance(resource)) {
            throw Errors.structure(resource.getClass().getSimpleName(), "expected a " + type.getSimpleName()
                    + " but got a " + resource.getClass().getSimpleName());
        }
        return type.cast(resource);
    }

    /**
     * Reads a resource from a character stream of FHIR XML. The reader is not closed.
     *
     * @param reader the source of one resource
     * @return the resource, of the class named by its root element
     * @throws se.poroli.fhirplace.r5.FhirFormatException if the content is not a valid FHIR resource for this model
     */
    public static Resource read(Reader reader) {
        try {
            XMLStreamReader xml = XmlCodec.INPUT.createXMLStreamReader(Objects.requireNonNull(reader, "reader"));
            try {
                return read(xml);
            } finally {
                xml.close();
            }
        } catch (XMLStreamException e) {
            throw Errors.syntax("Invalid XML: " + e.getMessage(), e);
        }
    }

    /**
     * Reads a resource from a StAX reader positioned at the resource's start tag, or before it. Afterwards the reader
     * is positioned at the resource's end tag.
     *
     * @param reader the reader
     * @return the resource, of the class named by its element
     * @throws XMLStreamException if the XML is malformed
     * @throws se.poroli.fhirplace.r5.FhirFormatException if the content is not a valid FHIR resource for this model
     */
    public static Resource read(XMLStreamReader reader) throws XMLStreamException {
        while (reader.getEventType() != XMLStreamConstants.START_ELEMENT) {
            if (!reader.hasNext()) {
                throw Errors.syntax("No resource element", null);
            }
            reader.next();
        }
        return XmlCodec.readResource(reader, "");
    }
}
