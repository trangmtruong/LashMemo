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
     * Calculates the fill price based on weeks since the last visit.
     *
     * @return price in dollars
     */
    @Override
    public double calculatePrice() {
        // TODO (Mia): return twoWeekPrice if weeksSinceLastVisit is 2 or less,
        //   and threeWeekPrice if it is 3.
        //   Decide what happens past 3 weeks (full set price? three-week price?).
        return 0.0;
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
