package com.demo.keeptuit.db;

import com.demo.keeptuit.db.config.DbConfiguration;
import com.demo.keeptuit.db.entity.NoteDb;
import com.demo.keeptuit.db.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

@ContextConfiguration(classes = {TestConfiguration.class, DbConfiguration.class})
public class NoteRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void canSaveAndGetNotes() throws Exception {

        NoteDb note = new NoteDb().withContent("Testing").withTitle("Demo-Testing-1");
        NoteDb noteSaved = noteRepository.save(note);
        assertNotNull(noteSaved);

        NoteDb fetched = noteRepository.findOne(noteSaved.getId());
        assertNotNull(fetched);
    }

}
