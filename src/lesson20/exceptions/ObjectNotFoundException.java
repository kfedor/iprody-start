package lesson20.exceptions;

import java.io.FileNotFoundException;

/**
 * Signals that an attempt to get the object from the storage associated with a specified name and namespace has failed.
 */
public class ObjectNotFoundException extends FileNotFoundException {

    /**
     * Constructs a ObjectNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
