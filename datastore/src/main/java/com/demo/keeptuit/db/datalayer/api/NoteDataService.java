package com.demo.keeptuit.db.datalayer.api;


import com.demo.keeptuit.db.entity.NoteDb;

import java.util.List;

public interface NoteDataService {

    NoteDb createNote(NoteDb note);

    NoteDb updateNote(NoteDb note);

    NoteDb deleteNote(Long noteId);
}
