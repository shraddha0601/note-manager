package com.demo.keeptuit.service;

import com.demo.keeptuit.db.datalayer.api.UserDataService;
import com.demo.keeptuit.db.entity.NoteDb;
import com.demo.keeptuit.db.entity.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Service
@ParametersAreNonnullByDefault
public class UserService {

    @Autowired
    private UserDataService userDataService;

    public List<NoteDb> getNotesForUser(String username) {
        UserDb user = userDataService.getUser(username);
        return user.getNotes();
    }


}
