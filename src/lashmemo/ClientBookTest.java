package lashmemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Checks that searching the client book finds the right client,
 * and throws ClientNotFoundException when there is no match.
 *
 * @author Mia Truong
 */
public class ClientBookTest {

    /** Client book with two sample clients. */
    private ClientBook book;

    /** Builds a client book with two clients before each test. */
    @BeforeEach
    public void setUp() {
        book = new ClientBook();
        book.addClient(new Client("Jessica Tran", "(619) 555-0142", "", ""));
        book.addClient(new Client("Kayla Nguyen", "(619) 555-0199", "", ""));
    }

    /** Finds a client with the exact name. */
    @Test
    public void findsExactName() throws ClientNotFoundException {
        assertEquals("Jessica Tran", book.findClient("Jessica Tran").getName());
    }

    /** Finds a client no matter the upper/lower case. */
    @Test
    public void ignoresCase() throws ClientNotFoundException {
        assertEquals("Kayla Nguyen", book.findClient("kayla nguyen").getName());
    }

    /** Ignores extra spaces around the name. */
    @Test
    public void ignoresExtraSpaces() throws ClientNotFoundException {
        assertEquals("Jessica Tran", book.findClient("  Jessica Tran ").getName());
    }

    /** Throws ClientNotFoundException when the client isn't in the book. */
    @Test
    public void throwsWhenNotFound() {
        assertThrows(ClientNotFoundException.class, () -> book.findClient("Amanda Lee"));
    }

    /** Throws ClientNotFoundException when the book is empty. */
    @Test
    public void throwsWhenBookIsEmpty() {
        ClientBook emptyBook = new ClientBook();
        assertThrows(ClientNotFoundException.class, () -> emptyBook.findClient("Jessica Tran"));
    }
}
