package com.demo.keeptuit.service.business.reminder;

import com.demo.keeptuit.service.db.entity.NoteDb;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The reminder event publisher.
 */
@Component
@ParametersAreNonnullByDefault
public class ReminderDispatcher {

    private List<ReminderListener> listeners = new ArrayList<>();

    /**
     * Notify listeners.
     *
     * @param notes
     *         the notes
     */
    public void notifyListeners(List<NoteDb> notes) {
        if (!CollectionUtils.isEmpty(notes)) {

            /* Notify the listeners in asynchronously */
            CompletableFuture.runAsync(() ->
                    listeners.forEach(listener -> listener.onEventsFound(notes)));
        }
    }

    /**
     * Register listener.
     *
     * @param reminderListener
     *         the reminder listener
     */
    public void registerListener(ReminderListener reminderListener) {
        listeners.add(reminderListener);
    }
}
