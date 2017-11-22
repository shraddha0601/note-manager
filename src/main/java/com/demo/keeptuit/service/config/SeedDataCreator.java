package com.demo.keeptuit.service.config;

import com.demo.keeptuit.service.db.entity.NoteDb;
import com.demo.keeptuit.service.db.entity.UserDb;
import com.demo.keeptuit.service.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Data seeder
 */
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
        NoteDb note1 = new NoteDb().withContent("This is the content of Note1").withTitle("Note1");
        NoteDb note2 = new NoteDb().withContent("This is the content of Note2").withTitle("Note2");
        NoteDb note3 = new NoteDb().withContent("This is the content of Note3").withTitle("Note3");
        NoteDb note4 = new NoteDb().withContent("This is the content of Note4").withTitle("Note4");

        UserDb user1 = new UserDb().withUserName("Luke").withFirstName("LJedi").withLastName("Skywalker").withNotes(Arrays.asList(note1));
        note1.setUser(user1);

        UserDb user2 = new UserDb().withUserName("Vader").withFirstName("VJedi").withLastName("Skywalker").withNotes(Arrays.asList(note2));
        note2.setUser(user2);

        UserDb user3 = new UserDb().withUserName("Yoda").withFirstName("YJedi").withLastName("Skywalker").withNotes(Arrays.asList(note1));
        note1.setUser(user1);

        UserDb user4 = new UserDb().withUserName("Obiwan").withFirstName("OJedi").withLastName("Skywalker").withNotes(Arrays.asList(note1));
        note1.setUser(user1);

        userRepository.save(Arrays.asList(user1, user2, user3, user4));
    }
}
