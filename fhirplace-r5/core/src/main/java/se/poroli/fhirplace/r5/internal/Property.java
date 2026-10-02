package se.poroli.fhirplace.r5.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * One FHIR element of a model record, as the JSON and XML formats see it. Internal; not exported.
 *
 * @param name the FHIR element name; for a choice element the name without the type suffix, such as {@code value}
 * @param kind how the element is represented
 * @param type the Java type of one value: a record or primitive class, or {@code DataType} for choices
 * @param enumType the enum of a {@code FhirEnum} element, otherwise {@code null}
 * @param repeating whether the element is a list
 * @param index the position of the element among the record components
 * @param accessor the record component accessor
 */
public record Property(
        String name, Kind kind, Class<?> type, Class<?> enumType, boolean repeating, int index, Method accessor) {

    /** How an element is represented in FHIR JSON and XML. */
    public enum Kind {
        /** A plain string: the resource or element {@code id}, or {@code Extension.url}. */
        STRING,
        /** A FHIR primitive with optional id and extensions. */
        PRIMITIVE,
        /** The XHTML {@code div} of a narrative. */
        XHTML,
        /** A complex datatype or backbone element. */
        COMPLEX,
        /** A choice element ({@code value[x]}) whose name gets the type as suffix. */
        CHOICE,
        /** A nested resource, such as {@code contained} or {@code Bundle.entry.resource}. */
        RESOURCE
    }

    /**
     * Reads this element from a record.
     *
     * @param record an instance of the record that declares this property
     * @return the value, a list for repeating elements, or {@code null}
     */
    public Object get(Object record) {
        try {
            return accessor.invoke(record);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
            throw ModelInfo.unwrap(e);
        }
    }
}
