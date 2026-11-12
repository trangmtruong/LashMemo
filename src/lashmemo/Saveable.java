package lashmemo;

/**
 * Something that can turn itself into a line of text for the save file.
 *
 * @author Mia Truong
 */
public interface Saveable {

    /**
     * Converts this object into one line of text for the save file.
     *
     * @return a line of text representing this object
     */
    String toFileString();
}
