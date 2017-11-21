package com.demo.keeptuit.service.db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    private static final String KEY = "User not found";
    private static final long serialVersionUID = 2055843169772293889L;

    public UserNotFoundException() {
        super(KEY);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}


