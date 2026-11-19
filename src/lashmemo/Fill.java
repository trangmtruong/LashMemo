package lashmemo;

/**
 * A lash extension fill. Priced by how many weeks since the last visit.
 *
 * Inheritance: Fill IS-A ExtensionService (which IS-A Service).
 *
 * @author Mia Truong
 */
public class Fill extends ExtensionService {

    /** Weeks since the client's last visit. */
    private int weeksSinceLastVisit;

    /** Price for a fill at 2 weeks or less. */
    private double twoWeekPrice;

    /** Price for a fill at 3 weeks. */
    private double threeWeekPrice;

    /**
     * Creates a fill.
     *
     * @param color               lash color
     * @param lashMap             lash map used
     * @param weeksSinceLastVisit weeks since last visit
     * @param twoWeekPrice        price at 2 weeks or less
     * @param threeWeekPrice      price at 3 weeks
     */
    public Fill(String color, LashMap lashMap, int weeksSinceLastVisit,
                double twoWeekPrice, double threeWeekPrice) {
        super("Fill", color, lashMap);
        this.weeksSinceLastVisit = weeksSinceLastVisit;
        this.twoWeekPrice = twoWeekPrice;
        this.threeWeekPrice = threeWeekPrice;
    }

    /** @return weeks since last visit */
    public int getWeeksSinceLastVisit() {
        return weeksSinceLastVisit;
    }

    /**
     * Calculates the fill price based on weeks since the last visit:
     * 2 weeks or less uses the 2-week price, 3 weeks or more uses the 3-week price.
     *
     * @return price in dollars
     */
    @Override
    public double calculatePrice() {
        if (weeksSinceLastVisit <= 2) {
            return twoWeekPrice;
        } else {
            // 3 weeks or more uses the 3-week price.
            return threeWeekPrice;
        }
    }

    /**
     * Adds the weeks to the shared extension details.
     *
     * @return details as text
     */
    @Override
    public String getDetails() {
        return super.getDetails() + "\nWeeks since last visit: " + weeksSinceLastVisit;
    }
}
