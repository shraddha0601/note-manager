package com.demo.keeptuit.service.reminder;

import com.demo.keeptuit.service.db.entity.NoteDb;
import com.demo.keeptuit.service.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Scheduled task for checking upcoming reminder
 */
@Component
public class ReminderTask {

    @Autowired
    private ReminderDispatcher dispatcher;

    @Autowired
    private ReminderService reminderService;

    /**
     * Find notes that need to trigger reminders and notify the listeners
     *
     */
    @Scheduled(fixedRateString = "${fixed.rate}", initialDelayString = "${initial.delay}") //Should ideally run every second
    public void findReminderNotes() {
        List<NoteDb> notes = reminderService.getAllUpcomingReminderNotes();
        dispatcher.notifyListeners(notes);
    }
}
