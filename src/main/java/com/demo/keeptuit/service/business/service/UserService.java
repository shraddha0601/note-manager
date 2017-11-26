package com.demo.keeptuit.service.business.service;

import com.demo.keeptuit.service.db.datalayer.api.UserDataService;
import com.demo.keeptuit.service.db.entity.NoteDb;
import com.demo.keeptuit.service.db.entity.UserDb;
import com.demo.keeptuit.service.db.exception.InvalidUserException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

/**
 * Business service for User operations
 */
@Service
@ParametersAreNonnullByDefault
@Validated
public class UserService {

    @Autowired
    private UserDataService userDataService;

    /**
     * Get a list of notes for the given user
     *
     * @param username - user name
     * @return list of notes for the user
     * @throws InvalidUserException if the user with the username is not found
     */
    public List<NoteDb> getNotesForUser(String username) {

        if (StringUtils.isBlank(username)) {
            throw new InvalidUserException();
        }
        UserDb user = userDataService.getUser(username);
        return user.getNotes();
    }


}
