package com.demo.keeptuit.db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NoteAlreadyExistsExeption extends RuntimeException {
    private static final String KEY = "Note already exists";
    private static final long serialVersionUID = 7364153782282944463L;

    public NoteAlreadyExistsExeption() {
        super(KEY);
    }

    public NoteAlreadyExistsExeption(String message) {
        super(message);
    }
}
