package com.ltimdree.movie.ltimdree.exception;

/**
 * Exception thrown when a resource is not found.
 */
public class NotFoundException extends RuntimeException {

    /**
     * Constructs a new not found exception with null as its detail message.
     */
    public NotFoundException() {
        super();
    }

    /**
     * Constructs a new not found exception with the specified detail message.
     * @param message the detail message
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new not found exception with the specified detail message and cause.
     * @param message the detail message
     * @param cause the cause
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new not found exception with the specified cause and a detail message of (cause==null ? null : cause.toString())
     * @param cause the cause
     */
    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
