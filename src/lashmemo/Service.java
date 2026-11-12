package lashmemo;

/**
 * A lash service done at an appointment. Abstract because every service
 * is a specific kind (lash lift, full set, or fill).
 *
 * @author Mia Truong
 */
public abstract class Service {

    /** Display name of the service, like "Full Set". */
    private String name;

    /**
     * Creates a service with a name.
     *
     * @param name display name of the service
     */
    public Service(String name) {
        this.name = name;
    }

    /** @return the service name */
    public String getName() {
        return name;
    }

    /**
     * Calculates the price of this service. Each kind of service
     * calculates its price its own way.
     *
     * @return price in dollars
     */
    public abstract double calculatePrice();

    /**
     * Describes the details of this service for the visit screen.
     * Each kind of service describes itself, so the GUI never has to
     * check which kind it is.
     *
     * @return details as text
     */
    public abstract String getDetails();
}
