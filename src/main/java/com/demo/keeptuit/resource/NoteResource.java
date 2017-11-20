package com.demo.keeptuit.resource;

import com.demo.keeptuit.exception.InvalidResourceException;
import com.demo.keeptuit.service.NoteService;
import com.demo.keeptuit.service.UserService;
import com.demo.keeptuit.db.entity.NoteDb;
import com.demo.keeptuit.model.NoteListMedia;
import com.demo.keeptuit.model.NoteMedia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Resoruce for NoteMedia operations
 */
@RestController
@Api(value = "Notes", description = "Notes")
public class NoteResource {

    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;

    /**
     * Get all notes for a user
     *
     * @param userName username
     * @return all notes or empty list if none found
     */
    @RequestMapping(path = "/notes/{userName}" , method = RequestMethod.GET, produces = NoteListMedia.MEDIA_TYPE_LIST)
    @ResponseBody
    @ApiOperation(value = "List existing notes for a user")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "the notes were retrieved")})
    public NoteListMedia getNotes(@ApiParam(value = "unique identifier of the user") @PathVariable("userName") String userName) {
        List<NoteDb> noteDbs = userService.getNotesForUser(userName);

        List<NoteMedia> notes = noteDbs.stream()
                .map(note -> new NoteMedia()
                        .withId(note.getId())
                        .withTitle(note.getTitle())
                        .withUserName(userName)
                        .withContents(note.getContent()))
                .collect(Collectors.toList());

        return new NoteListMedia().withItems(notes).getThis();
    }


    /**
     * Create a note for a user
     */
    @ApiOperation("Create a new note for given user")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "the note was created")})
    @RequestMapping(path = "/notes/{userName}", method = RequestMethod.POST, consumes = NoteMedia.MEDIA_TYPE, produces = NoteMedia.MEDIA_TYPE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public NoteMedia createNote(@ApiParam(value = "unique identifier of the user") @PathVariable("userName") String userName,
                             @ApiParam(value = "the note") @RequestBody NoteMedia noteMedia) {
        try {
            NoteDb createdNote = noteService.createNote(userName, new NoteDb().withContent(noteMedia.getContent()).withTitle(noteMedia.getTitle()));
            return new NoteMedia().withUserName(userName)
                    .withContents(createdNote.getContent())
                    .withTitle(createdNote.getTitle());

        } catch (ConstraintViolationException e) {
            throw new InvalidResourceException();
        }
    }



}
