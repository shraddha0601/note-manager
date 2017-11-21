package com.demo.keeptuit.service;

import com.demo.keeptuit.service.db.datalayer.api.NoteDataService;
import com.demo.keeptuit.service.db.datalayer.api.UserDataService;
import com.demo.keeptuit.service.db.entity.NoteDb;
import com.demo.keeptuit.service.db.entity.UserDb;
import com.demo.keeptuit.service.db.exception.InvalidUserException;
import com.demo.keeptuit.service.db.exception.UserNotFoundException;
import com.demo.keeptuit.service.service.NoteService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.FileAssert.fail;

public class NoteServiceTest {

    private NoteDataService mockNoteDataService;
    private UserDataService mockUserDataService;
    private NoteService noteService = new NoteService();
    private UserDb testUser;

    @BeforeMethod
    public void setup() throws Exception {
        mockNoteDataService = mock(NoteDataService.class);
        mockUserDataService = mock(UserDataService.class);
        setField(noteService, "validator", new ModelValidator());
        setField(noteService, "noteDataService", mockNoteDataService);
        setField(noteService, "userDataService", mockUserDataService);
        testUser = new UserDb().withUserName("testuser" + randomAlphanumeric(3));
    }

    @Test
    public void cannotAddNoteIfExceedsTitleLimit() throws Exception {
        try {
            NoteDb note = new NoteDb().withTitle(randomAlphanumeric(16));
            noteService.createNote(testUser.getUserName(), note);
        } catch (ConstraintViolationException e) {
            assertEquals(e.getConstraintViolations().iterator().next().getPropertyPath().toString(), "title", "Wrong field");
            return;
        }
        fail("should have failed");
    }

    @Test
    public void cannotAddNoteIfExceedsContentLimit() throws Exception {
        try {
            NoteDb note = new NoteDb().withTitle(randomAlphanumeric(10))
                    .withContent(randomAlphanumeric(300));
            noteService.createNote(testUser.getUserName(), note);
        } catch (ConstraintViolationException e) {
            assertEquals(e.getConstraintViolations().iterator().next().getPropertyPath().toString(), "content", "Wrong field");
            return;
        }
        fail("should have failed");
    }

    @Test(expectedExceptions = InvalidUserException.class)
    public void cannotAddNoteIfBlankUsernamePassed() throws Exception {
        noteService.createNote(null, aSampleNote());
    }

    @Test(expectedExceptions = UserNotFoundException.class)
    public void cannotAddNoteIfUserDoesNotExist() throws Exception {
        doThrow(new UserNotFoundException()).when(mockUserDataService).getUser(testUser.getUserName());
        noteService.createNote(testUser.getUserName(), aSampleNote());
    }

    @Test
    public void canCreateNote() throws Exception {
        when(mockUserDataService.getUser(testUser.getUserName())).thenReturn(testUser);
        NoteDb note = aSampleNote();
        noteService.createNote(testUser.getUserName(), note);
        verify(mockNoteDataService).createNote(note);
    }

    private NoteDb aSampleNote() {
        return new NoteDb()
                .withTitle("TestNote" + randomAlphanumeric(6))
                .withContent("TestContent");
    }

}
