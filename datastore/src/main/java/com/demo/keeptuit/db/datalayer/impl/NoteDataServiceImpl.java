package com.demo.keeptuit.db.datalayer.impl;

import com.demo.keeptuit.db.datalayer.api.NoteDataService;
import com.demo.keeptuit.db.entity.NoteDb;
import com.demo.keeptuit.db.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@Service
public class NoteDataServiceImpl implements NoteDataService {

    @Autowired
    private NoteRepository noteRepository;

    public NoteDb createNote(NoteDb note) {
        return noteRepository.save(note);
    }

    public NoteDb updateNote(NoteDb note) {
        return null;
    }

    public NoteDb deleteNote(Long noteId) {
        return null;
    }

}
