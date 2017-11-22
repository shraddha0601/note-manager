package com.demo.keeptuit.service.db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * The type User not found exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    private static final String KEY = "User not found";
    private static final long serialVersionUID = 2055843169772293889L;

    /**
     * Instantiates a new User not found exception.
     */
    public UserNotFoundException() {
        super(KEY);
    }

    /**
     * Instantiates a new User not found exception.
     *
     * @param message
     *         the message
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}


