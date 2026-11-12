package lashmemo;

/**
 * A full set of lash extensions. Priced at a flat rate.
 *
 * Inheritance: FullSet IS-A ExtensionService (which IS-A Service).
 *
 * @author Mia Truong
 */
public class FullSet extends ExtensionService {

    /** Flat price of a full set. */
    private double flatPrice;

    /**
     * Creates a full set.
     *
     * @param color     lash color
     * @param lashMap   lash map used
     * @param flatPrice flat price in dollars
     */
    public FullSet(String color, LashMap lashMap, double flatPrice) {
        super("Full Set", color, lashMap);
        this.flatPrice = flatPrice;
    }

    /**
     * A full set is always the same flat price.
     *
     * @return price in dollars
     */
    @Override
    public double calculatePrice() {
        return flatPrice;
    }
}
