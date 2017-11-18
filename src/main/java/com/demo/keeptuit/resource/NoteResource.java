package com.demo.keeptuit.resource;

import com.demo.keeptuit.model.NoteMedia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
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

    @RequestMapping(path = "/notes/{id}" , method = RequestMethod.GET, produces = NoteMedia.MEDIA_TYPE)
    @ResponseBody
    @ApiOperation(value = "List the existing notes", notes =
            "List the registrations. If the domainName parameter is provided it will return " +
                    "a list with a unique registration that is configured for this domain.")

    public NoteMedia getNote(@ApiParam(value = "unique identifier of the client") @PathVariable("id") String id) {
        return new NoteMedia().withId(id).withTitle("test").withContents("test");
    }





}
