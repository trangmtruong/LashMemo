package lashmemo;

/**
 * A record of one visit: the date, the service done, how long it took,
 * and notes from the appointment.
 *
 * Aggregation: Appointment HAS-A Service.
 * Implements: Saveable.
 *
 * @author Mia Truong
 */
public class Appointment implements Saveable {

    /** Date of the visit, like "10/28/2026". */
    private String date;

    /** The service done at this visit. Appointment HAS-A Service. */
    private Service service;

    /** How long the visit took, in minutes. */
    private int durationMinutes;

    /** Notes from this visit (what was discussed, how it went). */
    private String visitNotes;

    /**
     * Creates an appointment record.
     *
     * @param date            date of the visit
     * @param service         service done
     * @param durationMinutes length of the visit in minutes
     * @param visitNotes      notes from the visit
     */
    public Appointment(String date, Service service, int durationMinutes, String visitNotes) {
        this.date = date;
        this.service = service;
        this.durationMinutes = durationMinutes;
        this.visitNotes = visitNotes;
    }

    /** @return the visit date */
    public String getDate() {
        return date;
    }

    /** @return the service done */
    public Service getService() {
        return service;
    }

    /** @return the visit length in minutes */
    public int getDurationMinutes() {
        return durationMinutes;
    }

    /** @return the visit notes */
    public String getVisitNotes() {
        return visitNotes;
    }

    /**
     * Gets the price by asking the service (polymorphism: works for any service).
     *
     * @return price in dollars
     */
    public double getPrice() {
        return service.calculatePrice();
    }

    /**
     * Full description of the visit for the visit details screen.
     *
     * @return visit details as text
     */
    public String getDetails() {
        return "Date: " + date + "\n" + service.getDetails()
                + "\nPrice: $" + getPrice()
                + "\nDuration: " + durationMinutes + " min"
                + "\nVisit notes: " + visitNotes;
    }

    /**
     * Converts this appointment into a line for the save file.
     *
     * @return a line of text for the save file
     */
    @Override
    public String toFileString() {
        // TODO (later, LO8): decide the save file format once we cover file I/O.
        return "";
    }
}
