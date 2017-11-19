package com.demo.keeptuit.resource;

import com.demo.keeptuit.db.entity.NoteDb;
import com.demo.keeptuit.db.entity.UserDb;
import com.demo.keeptuit.db.repository.NoteRepository;
import com.demo.keeptuit.db.repository.UserRepository;
import com.demo.keeptuit.model.NoteMedia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Resoruce for NoteMedia operations
 */
@RestController
@Api(value = "Notes", description = "Notes")
public class NoteResource {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/notes/{userName}" , method = RequestMethod.GET, produces = NoteMedia.MEDIA_TYPE)
    @ResponseBody
    @ApiOperation(value = "List the existing notes", notes =
            "List the registrations. If the domainName parameter is provided it will return " +
                    "a list with a unique registration that is configured for this domain.")

    public NoteMedia getNotes(@ApiParam(value = "unique identifier of the client") @PathVariable("userName") String userName) {
        UserDb user = userRepository.findByUserName(userName);
        NoteDb note = user.getNotes().get(0);

        return new NoteMedia().withId(note.getId().toString()).withTitle(note.getName()).withContents(note.getContent());
    }





}
