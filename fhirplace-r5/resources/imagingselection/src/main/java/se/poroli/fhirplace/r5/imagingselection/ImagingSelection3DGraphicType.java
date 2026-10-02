package se.poroli.fhirplace.r5.imagingselection;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The type of coordinates describing a 3D image region.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/imagingselection-3dgraphictype">FHIR R5 ImagingSelection3DGraphicType</a>
 */
public enum ImagingSelection3DGraphicType implements CodedEnum {

    /** A single location denoted by a single (x,y,z) triplet. */
    POINT("point", "POINT"),

    /** multiple locations each denoted by an (x,y,z) triplet; the points need not be coplanar. */
    MULTIPOINT("multipoint", "MULTIPOINT"),

    /**
     * a series of connected line segments with ordered vertices denoted by (x,y,z) triplets; the points need not be
     * coplanar.
     */
    POLYLINE("polyline", "POLYLINE"),

    /**
     * a series of connected line segments with ordered vertices denoted by (x,y,z) triplets, where the first and last
     * vertices shall be the same forming a polygon; the points shall be coplanar.
     */
    POLYGON("polygon", "POLYGON"),

    /**
     * an ellipse defined by four (x,y,z) triplets, the first two triplets specifying the endpoints of the major axis
     * and the second two triplets specifying the endpoints of the minor axis.
     */
    ELLIPSE("ellipse", "ELLIPSE"),

    /**
     * a three-dimensional geometric surface whose plane sections are either ellipses or circles and contains three
     * intersecting orthogonal axes, "a", "b", and "c"; the ellipsoid is defined by six (x,y,z) triplets, the first
     * and second triplets specifying the endpoints of axis "a", the third and fourth triplets specifying the
     * endpoints of axis "b", and the fifth and sixth triplets specifying the endpoints of axis "c".
     */
    ELLIPSOID("ellipsoid", "ELLIPSOID");

    private final String code;
    private final String display;

    ImagingSelection3DGraphicType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/imagingselection-3dgraphictype";
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
    public static ImagingSelection3DGraphicType fromCode(String code) {
        for (ImagingSelection3DGraphicType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ImagingSelection3DGraphicType code: '" + code + "'");
    }
}
