package com.demo.keeptuit.service.db.datalayer.impl;

import com.demo.keeptuit.service.db.datalayer.api.NoteDataService;
import com.demo.keeptuit.service.db.entity.NoteDb;
import com.demo.keeptuit.service.db.exception.NoteAlreadyExistsExeption;
import com.demo.keeptuit.service.db.exception.NoteNotFoundException;
import com.demo.keeptuit.service.db.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Implementation of {@code NoteDataService}
 */
@ParametersAreNonnullByDefault
@Service
public class NoteDataServiceImpl implements NoteDataService {

    private static final Logger log = LoggerFactory.getLogger(NoteDataServiceImpl.class);

    @Autowired
    private NoteRepository noteRepository;

    /**
     * {@inheritDoc}
     */
    public NoteDb createNote(NoteDb note) {
        try {
            return noteRepository.save(note);
        } catch (DataIntegrityViolationException e) {
            throw new NoteAlreadyExistsExeption();
        }
    }

    /**
     * {@inheritDoc}
     */
    public NoteDb updateNote(NoteDb note) {
        if (noteRepository.exists(note.getId())) {
            return noteRepository.save(note);
        } else {
            log.error("Note with id: {} does not exist", note.getId());
            throw new NoteNotFoundException();
        }
    }

    /**
     * {@inheritDoc}
     */
    public void deleteNote(Long noteId) {
        if (noteRepository.exists(noteId)) {
            noteRepository.delete(noteId);
        } else {
            log.error("Note with id: {} does not exist", noteId);
            throw new NoteNotFoundException();
        }
    }

}
