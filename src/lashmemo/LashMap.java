package lashmemo;

/**
 * A lash map: the overall shape and style of a set, plus its three layers.
 *
 * Aggregation: LashMap HAS-MANY LashLayers (exactly 3: top, middle, bottom).
 *
 * @author Mia Truong
 */
public class LashMap {

    /** Position of the top layer in the layers array. */
    public static final int TOP = 0;

    /** Position of the middle layer in the layers array. */
    public static final int MIDDLE = 1;

    /** Position of the bottom layer in the layers array. */
    public static final int BOTTOM = 2;

    /** Names of the layers, in the same order as the array. */
    private static final String[] LAYER_NAMES = {"Top", "Middle", "Bottom"};

    /** Overall shape, like "Cat eye", "Kitten eye", or "Open eye". */
    private String shape;

    /** Overall style, like "Wispy", "Anime", or "Wet". */
    private String style;

    /** The three layers of the map. LashMap HAS-MANY LashLayers. */
    private LashLayer[] layers;

    /**
     * Creates a lash map with empty layers.
     *
     * @param shape overall lash shape
     * @param style overall lash style
     */
    public LashMap(String shape, String style) {
        this.shape = shape;
        this.style = style;
        this.layers = new LashLayer[3];
    }

    /**
     * Sets one layer of the map.
     *
     * @param position TOP, MIDDLE, or BOTTOM
     * @param layer    the layer to store
     */
    public void setLayer(int position, LashLayer layer) {
        layers[position] = layer;
    }

    /**
     * Gets one layer of the map.
     *
     * @param position TOP, MIDDLE, or BOTTOM
     * @return the layer at that position (may be null if not set yet)
     */
    public LashLayer getLayer(int position) {
        return layers[position];
    }

    /** @return the lash shape */
    public String getShape() {
        return shape;
    }

    /** @return the lash style */
    public String getStyle() {
        return style;
    }

    /**
     * Describes the whole map, for example:
     * "Wispy cat eye" followed by one line per layer.
     *
     * @return a multi-line description of the map
     */
    @Override
    public String toString() {
        String result = style + " " + shape;
        // TODO (Mia): loop through the layers array and add one line per layer,
        //   like "\nTop: 11 to 15 mm, 0.07".
        //   Hint: use LAYER_NAMES[i] for the name and layers[i] for the layer.
        //   Skip any layer that is null.
        return result;
    }
}
