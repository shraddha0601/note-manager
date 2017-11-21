package com.demo.keeptuit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidResourceException extends RuntimeException {

    private static final String KEY = "Invalid resource passed";
    private static final long serialVersionUID = -3997823200250719211L;

    public InvalidResourceException() {
        super(KEY);
    }
    public InvalidResourceException(String message) {
        super(message);
    }
}
