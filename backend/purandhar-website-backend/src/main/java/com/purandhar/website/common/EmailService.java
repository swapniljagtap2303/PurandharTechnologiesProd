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

    @Autowired(required = false)
    private JavaMailSender mailSender;

    @Value("${app.mail.enabled:false}")
    private boolean mailEnabled;

    @Value("${app.env.name:LOCAL}")
    private String env;

    @Value("${MAIL_FROM:purandhartechnologies@gmail.com}")
    private String from;

    @Value("${MAIL_TO:purandhartechnologies@gmail.com}")
    private String to;

    public void sendResume(JobApplication job, MultipartFile resumeFile)
            throws MessagingException, IOException {

        // ✅ Mail OFF or SMTP missing → safely skip
        if (!mailEnabled || mailSender == null) {
            System.out.println("📧 Mail skipped | enabled=" + mailEnabled + " | env=" + env);
            return;
        }

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("[" + env + "] New Job Application - " + job.getaName());

            String body = """
                    New Job Application Received

                    Name: %s
                    Email: %s
                    Phone: %s
                    Position: %s
                    Experience: %s
                    Location: %s
                    Message: %s
                    """.formatted(
                    job.getaName(),
                    job.getaEmail(),
                    job.getaPhone(),
                    job.getaPosition(),
                    job.getExperience(),
                    job.getLocation(),
                    job.getMessage()
            );

            helper.setText(body);

            if (resumeFile != null && !resumeFile.isEmpty()) {
                helper.addAttachment(
                        resumeFile.getOriginalFilename(),
                        new ByteArrayResource(resumeFile.getBytes())
                );
            }

            mailSender.send(message);

        } catch (Exception e) {
            // ❌ app crash नको
            System.err.println("❌ Email failed but app continues: " + e.getMessage());
        }
    }
}


//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${app.mail.enabled:false}")
//    private boolean mailEnabled;
//
//    @Value("${app.env.name:LOCAL}")
//    private String env;
//    
//    @Value("${MAIL_FROM:purandartechnologies@gmail.com}")
//    private String from;
//
//    @Value("${MAIL_TO:purandhartechnologies@gmail.com}")
//    private String to;
//
//    public void sendResume(JobApplication job, MultipartFile resumeFile)
//            throws MessagingException, IOException {
//    	
//    	
//    	 try {
//    		 
//    		  if (!mailEnabled) {
//    	            System.out.println("📧 Mail disabled for env: " + env);
//    	            return;
//    	        }
//    		 
//             MimeMessage message = mailSender.createMimeMessage();
//             MimeMessageHelper helper =
//                     new MimeMessageHelper(message, true);
//
//             helper.setFrom(from);
//             helper.setTo(to);
//             helper.setSubject("[" + env + "] New Job Application - " + job.getaName());
//
//             String body = """
//                     New Job Application Received
//
//                     Name: %s
//                     Email: %s
//                     Phone: %s
//                     Position: %s
//                     Experience: %s
//                     Location: %s
//                     Message: %s
//                     """.formatted(
//                     job.getaName(),
//                     job.getaEmail(),
//                     job.getaPhone(),
//                     job.getaPosition(),
//                     job.getExperience(),
//                     job.getLocation(),
//                     job.getMessage()
//             );
//
//             helper.setText(body);
//
//             if (resumeFile != null && !resumeFile.isEmpty()) {
//                 helper.addAttachment(
//                         resumeFile.getOriginalFilename(),
//                         new ByteArrayResource(resumeFile.getBytes())
//                 );
//             }
//
//             mailSender.send(message);
//
//         } catch (Exception e) {
//             throw new RuntimeException("Email sending failed", e);
//         }
//    	
    	

//        if (!mailEnabled) {
//            System.out.println("📧 Mail disabled for env: " + env);
//            return;
//        }

//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//        helper.setTo("purandhartechnologies@gmail.com");
//        helper.setSubject("[" + env + "] New Job Application - " + job.getaName());
//
//        helper.setText(
//            "Environment: " + env + "\n\n" +
//            "Name: " + job.getaName() + "\n" +
//            "Email: " + job.getaEmail() + "\n" +
//            "Mobile: " + job.getaPhone()
//        );
//
//        if (file != null && !file.isEmpty()) {
//            helper.addAttachment(
//                file.getOriginalFilename(),
//                new ByteArrayResource(file.getBytes())
//            );
//        }
//        
//        System.out.println("in Send mail");
//        mailSender.send(message);
//    }
//}
