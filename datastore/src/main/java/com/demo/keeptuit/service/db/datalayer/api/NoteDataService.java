package com.demo.keeptuit.service.db.datalayer.api;


import com.demo.keeptuit.service.db.entity.NoteDb;

public interface NoteDataService {

    NoteDb createNote(NoteDb note);

    NoteDb updateNote(NoteDb note);

    void deleteNote(Long noteId);
}
