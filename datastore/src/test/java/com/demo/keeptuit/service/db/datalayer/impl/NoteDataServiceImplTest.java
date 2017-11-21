package com.demo.keeptuit.db.datalayer.impl;

import com.demo.keeptuit.db.TestConfiguration;
import com.demo.keeptuit.db.config.DbConfiguration;
import com.demo.keeptuit.db.datalayer.api.NoteDataService;
import com.demo.keeptuit.db.entity.NoteDb;
import com.demo.keeptuit.db.entity.UserDb;
import com.demo.keeptuit.db.exception.NoteAlreadyExistsExeption;
import com.demo.keeptuit.db.exception.NoteNotFoundException;
import com.demo.keeptuit.db.repository.NoteRepository;
import com.demo.keeptuit.db.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Long.parseLong;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = {TestConfiguration.class, DbConfiguration.class})
public class NoteDataServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private NoteDataService noteDataService;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    private UserDb testUser;

    @BeforeMethod
    public void resetTables() throws Exception {
        testUser = userRepository.save(
                new UserDb()
                        .withUserName("User-" + randomAlphanumeric(5))
                        .withEmail("Test@example.com"));

        noteRepository.deleteAll();
    }

    @Test
    public void canAddAndRetrieveNote() throws Exception {
        NoteDb createdNote = noteDataService.createNote(aSampleNote());
        NoteDb fetchedNote = noteRepository.findOne(createdNote.getId());
        assertTrue(reflectionEquals(fetchedNote, createdNote, "user"), "Notes mismatch");
    }

    @Test(expectedExceptions = NoteAlreadyExistsExeption.class)
    public void cannotAddADuplicateNote() throws Exception {
        NoteDb createdNote = noteDataService.createNote(aSampleNote());
        NoteDb duplicateNote = aSampleNote().withTitle(createdNote.getTitle()).withUser(createdNote.getUser());
        noteDataService.createNote(duplicateNote);
    }

    @Test
    public void canUpdateNote() throws Exception {
        NoteDb createdNote = noteDataService.createNote(aSampleNote());
        NoteDb noteToUpdate = createdNote.withTitle("Updated" + randomAlphanumeric(3));
        assertTrue(reflectionEquals(noteDataService.updateNote(noteToUpdate), noteToUpdate, "user"), "Notes mismatch");
    }

    @Test(expectedExceptions = NoteNotFoundException.class)
    public void cannotUpdateNoteIfDoesntExist() throws Exception {
        noteDataService.updateNote(aSampleNote().withId(parseLong(randomNumeric(2))));
    }

    @Test
    public void canDeleteNote() throws Exception {
        NoteDb createdNote = noteDataService.createNote(aSampleNote());
        noteDataService.deleteNote(createdNote.getId());
        assertNull(noteRepository.findOne(createdNote.getId()));
    }

    @Test(expectedExceptions = NoteNotFoundException.class)
    public void cannotDeleteNoteIfDoesntExist() throws Exception {
        noteDataService.deleteNote(parseLong(randomNumeric(2)));
    }

    private NoteDb aSampleNote() {
        return new NoteDb()
                .withTitle("TestNote" + randomAlphanumeric(6))
                .withContent("TestContent")
                .withUser(testUser);
    }
}
