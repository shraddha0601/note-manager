package com.demo.keeptuit.config;

import com.demo.keeptuit.db.entity.NoteDb;
import com.demo.keeptuit.db.entity.UserDb;
import com.demo.keeptuit.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SeedDataCreator {

    private UserRepository userRepository;

    @Autowired
    public SeedDataCreator( UserRepository userRepository )
    {
        this.userRepository = userRepository;
        init();
    }

    private void init() {
        NoteDb note1 = new NoteDb().withContent("Note1").withName("Note1");
        NoteDb note2 = new NoteDb().withContent("Note2").withName("Note2");

        UserDb user1 = new UserDb().withUserName("jediLuke")
                .withFirstName("Luke").withLastName("Skywalker")
                .withNotes(Arrays.asList(note1));
        note1.setUser(user1);

        UserDb user2 = new UserDb().withUserName("jediRey")
                .withFirstName("Rey").withLastName("Skywalker")
                .withNotes(Arrays.asList(note2));
        note2.setUser(user2);

        userRepository.save(Arrays.asList(user1, user2));
    }
}
