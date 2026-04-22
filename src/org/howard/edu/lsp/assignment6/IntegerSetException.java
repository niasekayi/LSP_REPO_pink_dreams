package org.howard.edu.lsp.assignment6;

/**
 * Custom exception thrown when an invalid operation is performed on an IntegerSet,
 * such as calling largest() or smallest() on an empty set.
 *
 * @author Nia Greene
 * @version 1.0
 */
public class IntegerSetException extends RuntimeException {

    /**
     * Constructs a new IntegerSetException with the specified detail message.
     *
     * @param message the detail message describing the cause of the exception
     */
    public IntegerSetException(String message) {
        super(message);
    }
}
