package com.demo.keeptuit.service;

import com.demo.keeptuit.db.datalayer.api.NoteDataService;
import com.demo.keeptuit.db.datalayer.api.UserDataService;
import com.demo.keeptuit.db.entity.NoteDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;

@Service
@ParametersAreNonnullByDefault
public class NoteService {

    @Autowired
    private NoteDataService noteDataService;

    @Autowired
    private UserDataService userDataService;

    public NoteDb createNote(String userName, NoteDb note) {
        note.setUser(userDataService.getUser(userName));
        return noteDataService.createNote(note);
    }
}
