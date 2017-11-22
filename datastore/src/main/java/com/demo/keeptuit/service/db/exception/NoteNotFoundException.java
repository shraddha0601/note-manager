package com.demo.keeptuit.service.db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * The type Note not found exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoteNotFoundException extends RuntimeException {
    private static final String KEY = "Note not found";
    private static final long serialVersionUID = 5386277742556602956L;

    /**
     * Instantiates a new Note not found exception.
     */
    public NoteNotFoundException() {
        super(KEY);
    }

    /**
     * Instantiates a new Note not found exception.
     *
     * @param message
     *         the message
     */
    public NoteNotFoundException(String message) {
        super(message);
    }
}
