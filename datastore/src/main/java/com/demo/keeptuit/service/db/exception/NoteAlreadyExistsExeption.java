package com.demo.keeptuit.service.db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Note already exists exeption.
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class NoteAlreadyExistsExeption extends RuntimeException {
    private static final String KEY = "Note already exists";
    private static final long serialVersionUID = 7364153782282944463L;

    /**
     * Instantiates a new Note already exists exeption.
     */
    public NoteAlreadyExistsExeption() {
        super(KEY);
    }

    /**
     * Instantiates a new Note already exists exeption.
     *
     * @param message
     *         the message
     */
    public NoteAlreadyExistsExeption(String message) {
        super(message);
    }
}
