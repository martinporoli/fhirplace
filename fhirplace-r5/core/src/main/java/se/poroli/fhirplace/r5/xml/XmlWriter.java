package se.poroli.fhirplace.r5.xml;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Minimal streaming XML writer. Unlike the JDK's {@code XMLStreamWriter} it escapes line breaks and tabs in attribute
 * values, which FHIR XML needs because primitive values, including multi-line strings and markdown, are attributes.
 */
final class XmlWriter {

    private final Writer out;
    private final Deque<String> open = new ArrayDeque<>();
    private boolean startTagOpen;
    private boolean emptyElement;

    XmlWriter(Writer out) {
        this.out = out;
    }

    void startElement(String name) {
        closeStartTag();
        write('<');
        write(name);
        open.push(name);
        startTagOpen = true;
    }

    void emptyElement(String name) {
        startElement(name);
        emptyElement = true;
    }

    void attribute(String name, String value) {
        if (!startTagOpen) {
            throw new IllegalStateException("No start tag to add attribute " + name + " to");
        }
        write(' ');
        write(name);
        write("=\"");
        escape(value, true);
        write('"');
    }

    void characters(String text) {
        closeStartTag();
        escape(text, false);
    }

    void comment(String text) {
        closeStartTag();
        write("<!--");
        write(text);
        write("-->");
    }

    void endElement() {
        if (emptyElement) {
            closeStartTag();
        }
        String name = open.pop();
        if (startTagOpen) {
            write("/>");
            startTagOpen = false;
        } else {
            write("</");
            write(name);
            write('>');
        }
    }

    void flush() {
        closeStartTag();
        try {
            out.flush();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void closeStartTag() {
        if (!startTagOpen) {
            return;
        }
        if (emptyElement) {
            write("/>");
            open.pop();
            emptyElement = false;
        } else {
            write('>');
        }
        startTagOpen = false;
    }

    private void escape(String text, boolean attribute) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case '&' -> write("&amp;");
                case '<' -> write("&lt;");
                case '>' -> write("&gt;");
                case '"' -> write(attribute ? "&quot;" : "\"");
                case '\n' -> write(attribute ? "&#10;" : "\n");
                case '\r' -> write("&#13;");
                case '\t' -> write(attribute ? "&#9;" : "\t");
                default -> write(c);
            }
        }
    }

    private void write(String s) {
        try {
            out.write(s);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void write(char c) {
        try {
            out.write(c);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
