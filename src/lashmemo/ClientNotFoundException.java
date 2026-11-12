package lashmemo;

/**
 * Thrown when a search for a client finds no match.
 *
 * Inheritance: ClientNotFoundException IS-A Exception.
 *
 * @author Mia Truong
 */
public class ClientNotFoundException extends Exception {

    /** Version number required by Java for Exception subclasses. */
    private static final long serialVersionUID = 1L;

    /**
     * Creates the exception with a message for the user.
     *
     * @param name the name that was searched for
     */
    public ClientNotFoundException(String name) {
        super("No client found with the name \"" + name + "\".");
    }
}
