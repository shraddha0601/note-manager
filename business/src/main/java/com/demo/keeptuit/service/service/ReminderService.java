package com.demo.keeptuit.service.service;

import com.demo.keeptuit.service.db.entity.NoteDb;
import com.demo.keeptuit.service.db.entity.UserDb;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Service for reminders associated with notes
 */
@Service
public class ReminderService {

    /**
     * Get all upcoming reminders
     *
     * Retrieve reminders based on currentTime
     * @return
     */
    public List<NoteDb> getAllUpcomingReminderNotes() {

        /*
         * This is a mock implementation of the reminders
         * In the real world this service would call the database to
         * query on the reminders based on the current time
         *
         * findByReminderDateBetween(Date startDate, Date endDate)
         * where startDate can be passed as current time, endDate as current + 500 ms.
         */

        return Arrays.asList(new NoteDb()
                .withContent("Test Content")
                .withTitle("Test Title")
                .withUser(new UserDb().withUserName("ShraddhaL").withEmail("ladda.shraddha@gmail.com")));
    }
}
