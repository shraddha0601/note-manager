package com.demo.keeptuit.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Component
public class ReminderTask {

    private static final Logger log = LoggerFactory.getLogger(ReminderTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Autowired
//    private JavaMailSender emailSender;
//
//    @Autowired
//    public SimpleMailMessage template;

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("keeptuit.reminder@gmail.com");
        mailSender.setPassword("ssrqracrubpdajrd");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        SimpleMailMessage template = new SimpleMailMessage();
        template.setText(
                "This is the test email template for your email:\n%s\n");

        String text = String.format(template.getText(), "Shraddha Ladda");
        template.setTo("ladda.shraddha@gmail.com");
        template.setSubject("Testing APP");
        template.setText(text);
        //TODO:Fix this
//        mailSender.send(template);
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
