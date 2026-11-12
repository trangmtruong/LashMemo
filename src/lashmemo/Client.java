package lashmemo;

import java.util.ArrayList;

/**
 * A lash client: contact info, client notes, lash goals, and visit history.
 *
 * Aggregation: Client HAS-MANY Appointments.
 * Implements: Saveable.
 *
 * @author Mia Truong
 */
public class Client implements Saveable {

    /** Client's full name. */
    private String name;

    /** Client's phone number. */
    private String phone;

    /** Notes that stay the same each visit, like glue sensitivity. */
    private String clientNotes;

    /** The look the client wants to work toward. */
    private String lashGoals;

    /** Visit history. Client HAS-MANY Appointments. */
    private ArrayList<Appointment> visits;

    /**
     * Creates a client with no visits yet.
     *
     * @param name        full name
     * @param phone       phone number
     * @param clientNotes notes that stay the same each visit
     * @param lashGoals   lash goals
     */
    public Client(String name, String phone, String clientNotes, String lashGoals) {
        this.name = name;
        this.phone = phone;
        this.clientNotes = clientNotes;
        this.lashGoals = lashGoals;
        this.visits = new ArrayList<Appointment>();
    }

    /**
     * Adds a visit to this client's history.
     *
     * @param appointment the visit to add
     */
    public void addVisit(Appointment appointment) {
        visits.add(appointment);
    }

    /** @return the client's name */
    public String getName() {
        return name;
    }

    /** @return the client's phone number */
    public String getPhone() {
        return phone;
    }

    /** @return the client notes */
    public String getClientNotes() {
        return clientNotes;
    }

    /** @return the lash goals */
    public String getLashGoals() {
        return lashGoals;
    }

    /** @return the visit history */
    public ArrayList<Appointment> getVisits() {
        return visits;
    }

    /** @return the client's name, so lists show names */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Converts this client into a line for the save file.
     *
     * @return a line of text for the save file
     */
    @Override
    public String toFileString() {
        // TODO (later, LO8): decide the save file format once we cover file I/O.
        return "";
    }
}
