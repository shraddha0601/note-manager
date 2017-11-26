package com.demo.keeptuit.service.business.reminder;

import com.demo.keeptuit.service.db.entity.NoteDb;

import java.util.List;

/**
 * Listener interface for reminders
 */
public interface ReminderListener {

    /**
     * When notes with reminders found take action
     *
     * @param notes
     *         the notes
     */
    void onEventsFound(List<NoteDb> notes);
}
