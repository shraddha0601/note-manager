package com.demo.keeptuit.service.db.datalayer.api;


import com.demo.keeptuit.service.db.entity.NoteDb;
import com.demo.keeptuit.service.db.exception.NoteAlreadyExistsExeption;

/**
 * Interface for data layer operations for note
 */
public interface NoteDataService {

    /**
     * Create a note in the database
     *
     * @param note - Note to be created
     * @return the created note
     * @throws NoteAlreadyExistsExeption if a {@code NoteDb} with same title exists for a {@code UserDb}
     */
    NoteDb createNote(NoteDb note);

    /**
     * Update a note in the database
     *
     * @param note - Note to be updated
     * @return the updated note
     * @throws NoteNotFoundException if a {@code NoteDb} with id doesn't exist
     */
    NoteDb updateNote(NoteDb note);

    /**
     * Delete a note in the database
     *
     * @param noteId - Note with id to be updated
     * @return the updated note
     * @throws NoteNotFoundException if a {@code NoteDb} with given id doesn't exist
     */
    void deleteNote(Long noteId);
}
