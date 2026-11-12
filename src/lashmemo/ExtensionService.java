package lashmemo;

/**
 * Parent class for lash extension services (full sets and fills).
 * Holds what every extension service shares: lash color and a lash map.
 *
 * Inheritance: ExtensionService IS-A Service.
 * Aggregation: ExtensionService HAS-A LashMap.
 *
 * @author Mia Truong
 */
public abstract class ExtensionService extends Service {

    /** Lash color, like "Black" or "Brown". */
    private String color;

    /** The lash map used for this set. ExtensionService HAS-A LashMap. */
    private LashMap lashMap;

    /**
     * Creates an extension service.
     *
     * @param name    display name of the service
     * @param color   lash color
     * @param lashMap lash map used
     */
    public ExtensionService(String name, String color, LashMap lashMap) {
        super(name);
        this.color = color;
        this.lashMap = lashMap;
    }

    /** @return the lash color */
    public String getColor() {
        return color;
    }

    /** @return the lash map */
    public LashMap getLashMap() {
        return lashMap;
    }

    /**
     * Describes the color and lash map. Shared by FullSet and Fill.
     *
     * @return details as text
     */
    @Override
    public String getDetails() {
        return "Service: " + getName() + "\nColor: " + color + "\nLash map: " + lashMap;
    }
}
