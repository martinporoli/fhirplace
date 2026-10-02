package se.poroli.fhirplace.r5.xml;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.PrimitiveType;
import se.poroli.fhirplace.r5.internal.Errors;
import se.poroli.fhirplace.r5.internal.FhirTypes;
import se.poroli.fhirplace.r5.internal.ModelInfo;
import se.poroli.fhirplace.r5.internal.Property;

/** Writes model records as FHIR XML and reads them from a StAX reader. */
final class XmlCodec {

    static final String FHIR_NS = "http://hl7.org/fhir";
    static final String XHTML_NS = "http://www.w3.org/1999/xhtml";

    static final XMLInputFactory INPUT = inputFactory();

    private XmlCodec() {
    }

    static XMLInputFactory inputFactory() {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        factory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
        factory.setProperty(XMLInputFactory.IS_COALESCING, true);
        return factory;
    }

    // ---- writing ---------------------------------------------------------------------------------------------------

    static void writeResource(XmlWriter w, Resource resource, boolean root) throws XMLStreamException {
        w.startElement(FhirTypes.resourceType(resource.getClass()));
        if (root) {
            w.attribute("xmlns", FHIR_NS);
        }
        writeContent(w, resource, true);
        w.endElement();
    }

    private static void writeContent(XmlWriter w, Object record, boolean resource) throws XMLStreamException {
        List<Property> properties = ModelInfo.of(record.getClass()).properties();
        for (Property property : properties) {
            if (property.kind() == Property.Kind.STRING && !(resource && property.name().equals("id"))) {
                Object value = property.get(record);
                if (value != null) {
                    w.attribute(property.name(), (String) value);
                }
            }
        }
        for (Property property : properties) {
            Object value = property.get(record);
            if (value == null) {
                continue;
            }
            if (property.kind() == Property.Kind.STRING) {
                if (resource && property.name().equals("id")) {
                    w.emptyElement("id");
                    w.attribute("value", (String) value);
                }
            } else if (property.repeating()) {
                for (Object item : (List<?>) value) {
                    writeElement(w, property, item);
                }
            } else {
                writeElement(w, property, value);
            }
        }
    }

    private static void writeElement(XmlWriter w, Property property, Object value) throws XMLStreamException {
        String name = property.name();
        switch (property.kind()) {
            case PRIMITIVE -> writePrimitive(w, name, (PrimitiveType<?>) value);
            case COMPLEX -> writeComplex(w, name, value);
            case RESOURCE -> {
                w.startElement(name);
                writeResource(w, (Resource) value, false);
                w.endElement();
            }
            case CHOICE -> {
                String choiceName = name + FhirTypes.typeSuffix(value.getClass());
                if (value instanceof PrimitiveType<?> primitive) {
                    writePrimitive(w, choiceName, primitive);
                } else {
                    writeComplex(w, choiceName, value);
                }
            }
            case XHTML -> writeXhtml(w, ((FhirXhtml) value).value());
            case STRING -> throw new IllegalStateException("Repeating string element " + name);
        }
    }

    private static void writeComplex(XmlWriter w, String name, Object value) throws XMLStreamException {
        w.startElement(name);
        writeContent(w, value, false);
        w.endElement();
    }

    private static void writePrimitive(XmlWriter w, String name, PrimitiveType<?> primitive)
            throws XMLStreamException {
        boolean extensions = !primitive.extension().isEmpty();
        if (extensions) {
            w.startElement(name);
        } else {
            w.emptyElement(name);
        }
        if (primitive.id() != null) {
            w.attribute("id", primitive.id());
        }
        if (primitive.value() != null) {
            w.attribute("value", primitive.valueAsString());
        }
        if (extensions) {
            for (Extension extension : primitive.extension()) {
                writeComplex(w, "extension", extension);
            }
            w.endElement();
        }
    }

    private static void writeXhtml(XmlWriter w, String xhtml) throws XMLStreamException {
        XMLStreamReader r = INPUT.createXMLStreamReader(new StringReader(xhtml));
        try {
            while (r.next() != XMLStreamConstants.START_ELEMENT) {
                // skip the prolog
            }
            boolean declareXhtml = r.getNamespaceURI() == null || r.getNamespaceURI().isEmpty();
            copyElement(r, w, declareXhtml);
        } finally {
            r.close();
        }
    }

    // ---- reading ---------------------------------------------------------------------------------------------------

    static Resource readResource(XMLStreamReader r, String path) throws XMLStreamException {
        requireFhirNamespace(r, path);
        String resourceType = r.getLocalName();
        String resourcePath = path.isEmpty() ? resourceType : path;
        Class<? extends Resource> type;
        try {
            type = FhirTypes.resourceClass(resourceType);
        } catch (IllegalArgumentException e) {
            throw Errors.structure(resourcePath, e.getMessage());
        }
        return (Resource) readComplex(r, type, resourcePath, true);
    }

    private static Object readComplex(XMLStreamReader r, Class<?> type, String path, boolean resource)
            throws XMLStreamException {
        ModelInfo info = ModelInfo.of(type);
        Object[] values = new Object[info.properties().size()];
        for (int i = 0; i < r.getAttributeCount(); i++) {
            String namespace = r.getAttributeNamespace(i);
            if (namespace != null && !namespace.isEmpty()) {
                continue;
            }
            String name = r.getAttributeLocalName(i);
            Property property = info.property(name);
            if (property == null || property.kind() != Property.Kind.STRING || (resource && name.equals("id"))) {
                throw Errors.structure(path, "unknown attribute '" + name + "'");
            }
            values[property.index()] = r.getAttributeValue(i);
        }
        while (r.nextTag() == XMLStreamConstants.START_ELEMENT) {
            String name = r.getLocalName();
            ModelInfo.Resolved resolved = info.resolve(name);
            if (resolved == null) {
                throw Errors.structure(path, "unknown element '" + name + "'");
            }
            Property property = resolved.property();
            String elementPath = path + "." + name + (property.repeating()
                    ? "[" + (values[property.index()] == null ? 0 : ((List<?>) values[property.index()]).size()) + "]"
                    : "");
            if (property.kind() != Property.Kind.XHTML) {
                requireFhirNamespace(r, path);
            }
            Object value = readElement(r, property, resolved.type(), resource, elementPath);
            if (property.repeating()) {
                @SuppressWarnings("unchecked")
                List<Object> list = (List<Object>) values[property.index()];
                if (list == null) {
                    list = new ArrayList<>();
                    values[property.index()] = list;
                }
                list.add(value);
            } else if (values[property.index()] != null) {
                throw Errors.structure(elementPath, "repeated, but " + property.name() + " allows at most one value");
            } else {
                values[property.index()] = value;
            }
        }
        try {
            return info.create(values);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw Errors.fromModel(path, e);
        }
    }

    private static Object readElement(XMLStreamReader r, Property property, Class<?> type, boolean resource,
            String path) throws XMLStreamException {
        Property.Kind kind = property.kind() == Property.Kind.CHOICE
                ? (PrimitiveType.class.isAssignableFrom(type) ? Property.Kind.PRIMITIVE : Property.Kind.COMPLEX)
                : property.kind();
        return switch (kind) {
            case STRING -> {
                if (!resource) {
                    throw Errors.structure(path, "'" + property.name() + "' must be an attribute");
                }
                String value = r.getAttributeValue(null, "value");
                if (r.nextTag() != XMLStreamConstants.END_ELEMENT) {
                    throw Errors.structure(path, "unexpected child element " + r.getLocalName());
                }
                yield value;
            }
            case PRIMITIVE -> readPrimitive(r, property, type, path);
            case COMPLEX -> readComplex(r, type, path, false);
            case RESOURCE -> {
                if (r.nextTag() != XMLStreamConstants.START_ELEMENT) {
                    throw Errors.structure(path, "expected a resource");
                }
                Resource nested = readResource(r, path);
                if (r.nextTag() != XMLStreamConstants.END_ELEMENT) {
                    throw Errors.structure(path, "expected exactly one resource");
                }
                yield nested;
            }
            case XHTML -> {
                if (!XHTML_NS.equals(r.getNamespaceURI())) {
                    throw Errors.structure(path, "div must be in the XHTML namespace");
                }
                yield FhirXhtml.of(captureXhtml(r));
            }
            case CHOICE -> throw new IllegalStateException();
        };
    }

    private static Object readPrimitive(XMLStreamReader r, Property property, Class<?> type, String path)
            throws XMLStreamException {
        String id = null;
        String value = null;
        for (int i = 0; i < r.getAttributeCount(); i++) {
            String namespace = r.getAttributeNamespace(i);
            if (namespace != null && !namespace.isEmpty()) {
                continue;
            }
            switch (r.getAttributeLocalName(i)) {
                case "id" -> id = r.getAttributeValue(i);
                case "value" -> value = r.getAttributeValue(i);
                default -> throw Errors.structure(path, "unknown attribute '" + r.getAttributeLocalName(i) + "'");
            }
        }
        List<Extension> extensions = null;
        while (r.nextTag() == XMLStreamConstants.START_ELEMENT) {
            requireFhirNamespace(r, path);
            if (!r.getLocalName().equals("extension")) {
                throw Errors.structure(path, "unknown element '" + r.getLocalName() + "'");
            }
            if (extensions == null) {
                extensions = new ArrayList<>();
            }
            extensions.add((Extension) readComplex(r, Extension.class,
                    path + ".extension[" + extensions.size() + "]", false));
        }
        try {
            return FhirTypes.primitive(type, property.enumType(), id, extensions, value);
        } catch (IllegalArgumentException | NullPointerException | java.time.DateTimeException e) {
            throw Errors.fromModel(path, e);
        }
    }

    private static String captureXhtml(XMLStreamReader r) throws XMLStreamException {
        StringWriter out = new StringWriter();
        XmlWriter w = new XmlWriter(out);
        copyElement(r, w, false);
        w.flush();
        return out.toString();
    }

    /**
     * Copies the element at the reader's current start tag, and everything inside it, to the writer. Leaves the
     * reader at the matching end tag.
     */
    private static void copyElement(XMLStreamReader r, XmlWriter w, boolean declareXhtml)
            throws XMLStreamException {
        int depth = 0;
        do {
            switch (r.getEventType()) {
                case XMLStreamConstants.START_ELEMENT -> {
                    String prefix = r.getPrefix() == null ? "" : r.getPrefix();
                    String namespace = r.getNamespaceURI() == null ? "" : r.getNamespaceURI();
                    if (prefix.isEmpty()) {
                        w.startElement(r.getLocalName());
                    } else {
                        w.startElement(prefix + ":" + r.getLocalName());
                    }
                    boolean declaresOwn = false;
                    for (int i = 0; i < r.getNamespaceCount(); i++) {
                        String nsPrefix = r.getNamespacePrefix(i);
                        if (nsPrefix == null || nsPrefix.isEmpty()) {
                            w.attribute("xmlns", r.getNamespaceURI(i));
                        } else {
                            w.attribute("xmlns:" + nsPrefix, r.getNamespaceURI(i));
                        }
                        declaresOwn |= (nsPrefix == null ? "" : nsPrefix).equals(prefix);
                    }
                    if (depth == 0 && !declaresOwn) {
                        if (declareXhtml || prefix.isEmpty()) {
                            w.attribute("xmlns", declareXhtml ? XHTML_NS : namespace);
                        } else {
                            w.attribute("xmlns:" + prefix, namespace);
                        }
                    }
                    for (int i = 0; i < r.getAttributeCount(); i++) {
                        String attributePrefix = r.getAttributePrefix(i);
                        if (attributePrefix == null || attributePrefix.isEmpty()) {
                            w.attribute(r.getAttributeLocalName(i), r.getAttributeValue(i));
                        } else {
                            w.attribute(attributePrefix + ":" + r.getAttributeLocalName(i), r.getAttributeValue(i));
                        }
                    }
                    depth++;
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    w.endElement();
                    depth--;
                }
                case XMLStreamConstants.CHARACTERS, XMLStreamConstants.SPACE, XMLStreamConstants.CDATA ->
                        w.characters(r.getText());
                case XMLStreamConstants.COMMENT -> w.comment(r.getText());
                default -> {
                    // processing instructions and other events carry no content
                }
            }
            if (depth > 0) {
                r.next();
            }
        } while (depth > 0);
    }

    private static void requireFhirNamespace(XMLStreamReader r, String path) {
        if (!FHIR_NS.equals(r.getNamespaceURI())) {
            throw Errors.structure(path, "element '" + r.getLocalName() + "' is not in the FHIR namespace " + FHIR_NS);
        }
    }
}
