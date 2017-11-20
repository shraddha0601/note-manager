package com.demo.keeptuit.service;

import com.demo.keeptuit.ModelValidator;
import com.demo.keeptuit.db.datalayer.api.NoteDataService;
import com.demo.keeptuit.db.datalayer.api.UserDataService;
import com.demo.keeptuit.db.entity.NoteDb;
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
        validator.validate(note);
        note.setUser(userDataService.getUser(userName));
        return noteDataService.createNote(note);
    }
}
