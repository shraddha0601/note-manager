package com.demo.keeptuit.service.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Invalid resource exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidResourceException extends RuntimeException {

    private static final String KEY = "Invalid resource passed";
    private static final long serialVersionUID = -3997823200250719211L;

    /**
     * Instantiates a new Invalid resource exception.
     */
    public InvalidResourceException() {
        super(KEY);
    }

    /**
     * Instantiates a new Invalid resource exception.
     *
     * @param message
     *         the message
     */
    public InvalidResourceException(String message) {
        super(message);
    }
}
