package lashmemo;

import java.util.ArrayList;

/**
 * The lash artist's list of all clients.
 *
 * Aggregation: ClientBook HAS-MANY Clients.
 *
 * @author Mia Truong
 */
public class ClientBook {

    /** All clients. ClientBook HAS-MANY Clients. */
    private ArrayList<Client> clients;

    /** Creates an empty client book. */
    public ClientBook() {
        clients = new ArrayList<Client>();
    }

    /**
     * Adds a client to the book.
     *
     * @param client the client to add
     */
    public void addClient(Client client) {
        clients.add(client);
    }

    /**
     * Removes a client from the book.
     *
     * @param client the client to remove
     */
    public void removeClient(Client client) {
        clients.remove(client);
    }

    /** @return all clients */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * Finds a client by name (ignoring upper/lower case).
     *
     * @param name the name to search for
     * @return the matching client
     * @throws ClientNotFoundException if no client has that name
     */
    public Client findClient(String name) throws ClientNotFoundException {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(name.trim())) {
                return client;
            }
        }
        // Went through every client with no match
        throw new ClientNotFoundException(name);
    }
}
