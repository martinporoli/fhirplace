package se.poroli.fhirplace.r5.imagingselection;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The type of 2D coordinates describing a 2D image region.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/imagingselection-2dgraphictype">FHIR R5 ImagingSelection2DGraphicType</a>
 */
public enum ImagingSelection2DGraphicType implements CodedEnum {

    /** A single location denoted by a single (x,y) pair. */
    POINT("point", "POINT"),

    /**
     * A series of connected line segments with ordered vertices denoted by (x,y) triplets; the points need not be
     * coplanar.
     */
    POLYLINE("polyline", "POLYLINE"),

    /**
     * An n-tuple list of (x,y) pair end points between which some form of implementation dependent curved lines are
     * to be drawn.
     */
    INTERPOLATED("interpolated", "INTERPOLATED"),

    /**
     * Two points shall be present; the first point is to be interpreted as the center and the second point as a point
     * on the circumference of a circle, some form of implementation dependent representation of which is to be drawn.
     */
    CIRCLE("circle", "CIRCLE"),

    /**
     * An ellipse defined by four (x,y) pairs, the first two pairs specifying the endpoints of the major axis and the
     * second two pairs specifying the endpoints of the minor axis.
     */
    ELLIPSE("ellipse", "ELLIPSE");

    private final String code;
    private final String display;

    ImagingSelection2DGraphicType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/imagingselection-2dgraphictype";
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
    public static ImagingSelection2DGraphicType fromCode(String code) {
        for (ImagingSelection2DGraphicType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ImagingSelection2DGraphicType code: '" + code + "'");
    }
}
