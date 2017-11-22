package com.demo.keeptuit.service.reminder;

import com.demo.keeptuit.service.db.entity.NoteDb;
import com.demo.keeptuit.service.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@ParametersAreNonnullByDefault
public class ReminderDispatcher {

    private List<ReminderListener> listeners = new ArrayList<>();

    public void notifyListeners(List<NoteDb> notes) {
        if (!CollectionUtils.isEmpty(notes)) {

            /* Notify the listeners in asynchronously */
            CompletableFuture.runAsync(() ->
                    listeners.forEach(listener -> listener.onEventsFound(notes)));
        }
    }

    public void registerListener(ReminderListener reminderListener) {
        listeners.add(reminderListener);
    }
}
