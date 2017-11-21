package com.demo.keeptuit.service.service;

import com.demo.keeptuit.service.db.datalayer.api.UserDataService;
import com.demo.keeptuit.service.db.entity.NoteDb;
import com.demo.keeptuit.service.db.entity.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Service
@ParametersAreNonnullByDefault
@Validated
public class UserService {

    @Autowired
    private UserDataService userDataService;

    public List<NoteDb> getNotesForUser(String username) {
        UserDb user = userDataService.getUser(username);
        return user.getNotes();
    }


}
