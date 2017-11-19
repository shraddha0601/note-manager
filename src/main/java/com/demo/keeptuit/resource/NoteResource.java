package com.demo.keeptuit.resource;

import com.demo.keeptuit.UserService;
import com.demo.keeptuit.db.entity.NoteDb;
import com.demo.keeptuit.db.entity.UserDb;
import com.demo.keeptuit.db.repository.NoteRepository;
import com.demo.keeptuit.db.repository.UserRepository;
import com.demo.keeptuit.model.NoteListMedia;
import com.demo.keeptuit.model.NoteMedia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(path = "/notes/{userName}" , method = RequestMethod.GET, produces = NoteListMedia.MEDIA_TYPE_LIST)
    @ResponseBody
    @ApiOperation(value = "List all of the user's existing notes", notes =
            "List the registrations. If the domainName parameter is provided it will return " +
                    "a list with a unique registration that is configured for this domain.")

    public NoteListMedia getNotes(@ApiParam(value = "unique identifier of the user") @PathVariable("userName") String userName) {
        List<NoteDb> noteDbs = userService.getNotesForUser(userName);

        List<NoteMedia> notes = noteDbs.stream()
                .map(note -> new NoteMedia()
                        .withId(note.getId().toString())
                        .withTitle(note.getName())
                        .withUserName(userName)
                        .withContents(note.getContent()))
                .collect(Collectors.toList());

        return new NoteListMedia().withItems(notes).getThis();
    }





}
