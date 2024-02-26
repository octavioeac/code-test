package com.ltimdree.movie.ltimdree.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NotFoundExceptionTest {

    @Test
    void testConstructors() {
        NotFoundException exceptionWithoutMessage = new NotFoundException();
        assertNull(exceptionWithoutMessage.getMessage());
        assertNull(exceptionWithoutMessage.getCause());
        String message = "Resource not found";
        NotFoundException exceptionWithMessage = new NotFoundException(message);
        assertEquals(message, exceptionWithMessage.getMessage());
        assertNull(exceptionWithMessage.getCause());

        Throwable cause = new RuntimeException("Cause of the not found exception");
        NotFoundException exceptionWithMessageAndCause = new NotFoundException(message, cause);
        assertEquals(message, exceptionWithMessageAndCause.getMessage());
        assertEquals(cause, exceptionWithMessageAndCause.getCause());

        NotFoundException exceptionWithCause = new NotFoundException(cause);
        assertEquals(cause.toString(), exceptionWithCause.getMessage());
        assertEquals(cause, exceptionWithCause.getCause());
    }
}
