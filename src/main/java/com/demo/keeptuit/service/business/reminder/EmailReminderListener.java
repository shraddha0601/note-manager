package com.demo.keeptuit.service.business.reminder;

import com.demo.keeptuit.service.db.entity.NoteDb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * The type Email reminder listener.
 */
@Component
public class EmailReminderListener implements ReminderListener {

    private static final Logger log = LoggerFactory.getLogger(EmailReminderListener.class);

    @Autowired
    private ReminderDispatcher reminderDispatcher;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SimpleMailMessage template;

    /**
     * Register this listener with the dispatcher
     */
    @PostConstruct
    public void afterInit() {
        log.info("Registering the reminder for the reminder");
        reminderDispatcher.registerListener(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onEventsFound(List<NoteDb> notes) {
        notes.forEach(note -> {
            setMessage(note);
            emailSender.send(template);
        });
    }

    private void setMessage(NoteDb note) {
        template.setText(note.getContent());
        template.setTo(note.getUser().getEmail());
        template.setSubject(note.getTitle());
    }

}
