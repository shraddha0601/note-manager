package com.demo.keeptuit.db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoteNotFoundException extends RuntimeException {
    private static final String KEY = "Note not found";
    private static final long serialVersionUID = 5386277742556602956L;

    public NoteNotFoundException() {
        super(KEY);
    }

    public NoteNotFoundException(String message) {
        super(message);
    }
}
