package lashmemo;

/**
 * A Korean lash lift (a perm for natural lashes), with an optional tint
 * and optional light extensions add-on.
 *
 * Inheritance: KoreanLashLift IS-A Service.
 * Aggregation: KoreanLashLift HAS-A LashMap (only when light extensions are added).
 *
 * @author Mia Truong
 */
public class KoreanLashLift extends Service {

    /** Tint color, or "None". */
    private String tint;

    /** Base price of the lift. */
    private double flatPrice;

    /** True if light extensions were added on. */
    private boolean lightExtensions;

    /** Extra price for the light extensions add-on. */
    private double addOnPrice;

    /** Lash map for the add-on. Null when no light extensions were added. */
    private LashMap lashMap;

    /**
     * Creates a lash lift without light extensions.
     *
     * @param tint      tint color, or "None"
     * @param flatPrice base price in dollars
     */
    public KoreanLashLift(String tint, double flatPrice) {
        super("Korean Lash Lift");
        this.tint = tint;
        this.flatPrice = flatPrice;
        this.lightExtensions = false;
        this.addOnPrice = 0;
        this.lashMap = null;
    }

    /**
     * Creates a lash lift with the light extensions add-on.
     *
     * @param tint       tint color, or "None"
     * @param flatPrice  base price in dollars
     * @param addOnPrice extra price for light extensions
     * @param lashMap    lash map for the add-on
     */
    public KoreanLashLift(String tint, double flatPrice, double addOnPrice, LashMap lashMap) {
        super("Korean Lash Lift");
        this.tint = tint;
        this.flatPrice = flatPrice;
        this.lightExtensions = true;
        this.addOnPrice = addOnPrice;
        this.lashMap = lashMap;
    }

    /** @return the tint color, or "None" */
    public String getTint() {
        return tint;
    }

    /** @return true if light extensions were added */
    public boolean hasLightExtensions() {
        return lightExtensions;
    }

    /**
     * Base price, plus the add-on price if light extensions were added.
     *
     * @return price in dollars
     */
    @Override
    public double calculatePrice() {
        if (lightExtensions) {
            return flatPrice + addOnPrice;
        } else {
            return flatPrice;
        }
    }

    /**
     * Describes the tint, and the lash map only if light extensions were added.
     *
     * @return details as text
     */
    @Override
    public String getDetails() {
        String details = "Service: " + getName() + "\nTint: " + tint;
        if (lightExtensions) {
            details += "\nAdd-on: Light extensions\nLash map: " + lashMap;
        }
        return details;
    }
}
