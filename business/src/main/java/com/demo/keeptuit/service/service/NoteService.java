package com.demo.keeptuit.service.service;

import com.demo.keeptuit.service.ModelValidator;
import com.demo.keeptuit.service.db.datalayer.api.NoteDataService;
import com.demo.keeptuit.service.db.datalayer.api.UserDataService;
import com.demo.keeptuit.service.db.entity.NoteDb;
import com.demo.keeptuit.service.db.exception.InvalidUserException;
import com.demo.keeptuit.service.db.exception.UserNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.ParametersAreNonnullByDefault;

@Service
@ParametersAreNonnullByDefault
@Validated
public class NoteService {

    private static final Logger log = LoggerFactory.getLogger(NoteService.class);

    @Autowired
    private NoteDataService noteDataService;

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private ModelValidator validator;

    public NoteDb createNote(String userName, NoteDb note) {

        if (StringUtils.isBlank(userName)) {
            throw new InvalidUserException();
        }

        validator.validate(note);
        try {
            note.setUser(userDataService.getUser(userName));
            return noteDataService.createNote(note);
        } catch (UserNotFoundException e) {
            log.error("User not found: {}", userName);
            throw e;
        }
    }
}
