package lashmemo;

/**
 * Quick test of the model classes with sample data.
 * (The real app will use a Swing GUI later.)
 *
 * @author Mia Truong
 */
public class LashMemoTest {

    /**
     * Builds a sample client with a few visits and prints the results.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        // Build a lash map: wispy cat eye with 3 layers
        LashMap catEye = new LashMap("cat eye", "Wispy");
        catEye.setLayer(LashMap.TOP, new LashLayer(11, 15, 0.07));
        catEye.setLayer(LashMap.MIDDLE, new LashLayer(9, 12, 0.05));
        catEye.setLayer(LashMap.BOTTOM, new LashLayer(7, 10, 0.15));

        // A client with three visits, one of each service
        Client jessica = new Client("Jessica Tran", "(619) 555-0142",
                "Sensitive to glue fumes", "Fuller look by summer");
        jessica.addVisit(new Appointment("09/16/2026",
                new KoreanLashLift("Brown", 85), 60, "First lift, loved it."));
        jessica.addVisit(new Appointment("10/14/2026",
                new FullSet("Black", catEye, 150), 120, "Leaving for Cancun next week."));
        jessica.addVisit(new Appointment("10/28/2026",
                new Fill("Black", catEye, 2, 65, 80), 75, "Ask how Cancun was!"));

        ClientBook book = new ClientBook();
        book.addClient(jessica);

        // Print every visit. Polymorphism: getDetails() works for any service.
        for (Appointment visit : jessica.getVisits()) {
            System.out.println(visit.getDetails());
            System.out.println("----------");
        }

        // Search test: one name that exists, one that doesn't
        String[] searches = {"jessica tran", "Amanda Lee"};
        for (String name : searches) {
            try {
                Client found = book.findClient(name);
                System.out.println("Found: " + found);
            } catch (ClientNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
