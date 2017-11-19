package com.demo.keeptuit.db;

import com.demo.keeptuit.db.config.DbConfiguration;
import com.demo.keeptuit.db.entity.NoteDb;
import com.demo.keeptuit.db.entity.UserDb;
import com.demo.keeptuit.db.repository.NoteRepository;
import com.demo.keeptuit.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertNotNull;

@ContextConfiguration(classes = {TestConfiguration.class, DbConfiguration.class})
public class UserRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void canSaveAndGetUsers() throws Exception {

        NoteDb note1 = new NoteDb().withContent("Testing").withName("Demo-Testing-1");
        NoteDb note2 = new NoteDb().withContent("Testing").withName("Demo-Testing-1");

        UserDb user = new UserDb().withUserName("User-12").withNotes(Arrays.asList(note1, note2));
        UserDb savedUser = userRepository.save(user);
        UserDb retirevedUser = userRepository.findOne(savedUser.getId());

        assertNotNull(retirevedUser);

    }

}
