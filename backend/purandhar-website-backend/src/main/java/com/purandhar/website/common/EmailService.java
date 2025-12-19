package com.purandhar.website.common;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.purandhar.website.model.JobApplication;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.mail.enabled}")
    private boolean mailEnabled;

    @Value("${app.env.name}")
    private String env;

    public void sendResume(JobApplication job, MultipartFile file)
            throws MessagingException, IOException {

        if (!mailEnabled) {
            System.out.println("📧 Mail disabled for env: " + env);
            return;
        }

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("purandhartechnologies@gmail.com");
        helper.setSubject("[" + env + "] New Job Application - " + job.getaName());

        helper.setText(
            "Environment: " + env + "\n\n" +
            "Name: " + job.getaName() + "\n" +
            "Email: " + job.getaEmail() + "\n" +
            "Mobile: " + job.getaPhone()
        );

        if (file != null && !file.isEmpty()) {
            helper.addAttachment(
                file.getOriginalFilename(),
                new ByteArrayResource(file.getBytes())
            );
        }
        
        System.out.println("in Send mail");
        mailSender.send(message);
    }
}
