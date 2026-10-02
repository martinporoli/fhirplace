package se.poroli.fhirplace.r5.server.internal;

import jakarta.enterprise.util.AnnotationLiteral;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/** Passed as entity annotation to ask {@link FhirMessageBodyWriter} for indented output ({@code _pretty=true}). */
@Retention(RetentionPolicy.RUNTIME)
@interface Pretty {

    /** The annotation instance. */
    Annotation[] ON = {new Literal()};

    /** No annotations: compact output. */
    Annotation[] OFF = {};

    /** Literal for {@link Pretty}. */
    final class Literal extends AnnotationLiteral<Pretty> implements Pretty {
        private static final long serialVersionUID = 1L;
    }
}
