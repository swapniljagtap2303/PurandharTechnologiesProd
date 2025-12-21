package com.purandhar.website.common;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.purandhar.website.model.JobApplication;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class SendGridApiEmailService {

    @Value("${SENDGRID_API_KEY:}")
    private String apiKey;

    @Value("${MAIL_FROM:purandhartechnologies@gmail.com}")
    private String from;

    @Value("${MAIL_TO:purandhartechnologies@gmail.com}")
    private String to;

    public void send(JobApplication job) throws IOException {

        Email fromEmail = new Email(from);
        Email toEmail = new Email(to);

        String subject = "[PROD] New Job Application - " + job.getaName();

        Content content = new Content(
                "text/plain",
                "Name: " + job.getaName()
                + "\nEmail: " + job.getaEmail()
                + "\nPhone: " + job.getaPhone()
                + "\nPosition: " + job.getaPosition()
        );

        Mail mail = new Mail(fromEmail, subject, toEmail, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        sg.api(request);

        System.out.println("📧 PROD mail sent via SendGrid API");
    }
}
