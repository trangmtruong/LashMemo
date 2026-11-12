package lashmemo;

/**
 * One layer of a lash map (top, middle, or bottom).
 * Stores the length range and diameter used for that layer.
 *
 * @author Mia Truong
 */
public class LashLayer {

    /** Shortest lash length in this layer, in mm. */
    private int minLengthMm;

    /** Longest lash length in this layer, in mm. */
    private int maxLengthMm;

    /** Lash diameter (thickness) for this layer, in mm. */
    private double diameterMm;

    /**
     * Creates a lash layer.
     *
     * @param minLengthMm shortest length in mm
     * @param maxLengthMm longest length in mm
     * @param diameterMm  lash diameter in mm
     */
    public LashLayer(int minLengthMm, int maxLengthMm, double diameterMm) {
        this.minLengthMm = minLengthMm;
        this.maxLengthMm = maxLengthMm;
        this.diameterMm = diameterMm;
    }

    /** @return shortest length in mm */
    public int getMinLength() {
        return minLengthMm;
    }

    /** @return longest length in mm */
    public int getMaxLength() {
        return maxLengthMm;
    }

    /** @return diameter in mm */
    public double getDiameter() {
        return diameterMm;
    }

    /**
     * Describes this layer, for example "11 to 15 mm, 0.07".
     *
     * @return a short description of the layer
     */
    @Override
    public String toString() {
        return minLengthMm + " to " + maxLengthMm + " mm, " + diameterMm;
    }
}
