package com.demo.keeptuit.service.db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Invalid user exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidUserException extends RuntimeException {
    private static final String KEY = "Invalid user";
    private static final long serialVersionUID = -4490565973727194458L;

    /**
     * Instantiates a new Invalid user exception.
     */
    public InvalidUserException() {
        super(KEY);
    }

}

