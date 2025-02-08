package dev.dsf.exception;

/**
 * Unchecked exception that can be thrown by some methods of a collection
 * indicating that it is empty.
 * <p>
 * 
 * The available constructors are the following:
 * <p>
 * <ul>
 * <li>{@link #EmptyCollectionException()}: Constructs a new
 * EmptyCollectionException with a default message</li>
 * <li>{@link #EmptyCollectionException(String)}: Constructs a new
 * EmptyCollectionException with a specified message</li>
 * </ul>
 * 
 * <h3>EmptyCollectionException</h3>
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see RuntimeException
 */
public class EmptyCollectionException extends RuntimeException {
    /**
     * Constructs a new EmptyCollectionException with a default message.
     */
    public EmptyCollectionException() {
        this("Collection is empty");
    }

    /**
     * Constructs a new EmptyCollectionException with a specified message.
     * 
     * @param message the specified message
     */
    public EmptyCollectionException(String message) {
        super(message);
    }
}
