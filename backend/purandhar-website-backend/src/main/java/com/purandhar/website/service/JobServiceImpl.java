package com.purandhar.website.service;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.purandhar.website.common.EmailService;
import com.purandhar.website.common.SendGridApiEmailService;
import com.purandhar.website.model.ApiResponse;
import com.purandhar.website.model.JobApplication;
import com.purandhar.website.repository.JobRepository;


@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmailService emailService;
    
    @Autowired(required = false)
    private SendGridApiEmailService sendGridApiEmailService;


    @Autowired(required = false)
    private FileService fileService;

    @Value("${app.resume.save.enabled:false}")
    private boolean resumeSaveEnabled;

    @Value("${app.env.name}")
    private String env;

    @Override
    public ApiResponse apply(JobApplication job, MultipartFile resumeFile) throws IOException {

        try {
            // 1️⃣ Duplicate check
            if (jobRepository.existsByAEmailAndAPosition(
                    job.getaEmail(), job.getaPosition())) {

                return new ApiResponse(
                        409,
                        "FAILED",
                        " You have already applied for this job!",
                        null
                );
            }

            // 2️⃣ DEV only → save resume + path
            if (resumeSaveEnabled && "DEV".equals(env)
                    && resumeFile != null && !resumeFile.isEmpty()) {

                String resumeUrl = fileService.uploadResume(resumeFile);
                job.setaResumeUrl(resumeUrl);
            }

            job.setAppliedDate(LocalDateTime.now().toString());

            // 3️⃣ Save job data
            JobApplication savedJob = jobRepository.save(job);

            // 4️⃣ Send resume via email (DEV + PROD)
//            emailService.sendResume(savedJob, resumeFile);
            
            if ("PROD".equals(env)) {
                sendGridApiEmailService.send(savedJob);
            } else {
                emailService.sendResume(savedJob, resumeFile);
            }

            
            return new ApiResponse(
                    201,
                    "SUCCESS",
                    "✅ Job applied successfully. Resume processed.",
                    savedJob
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(
                    500,
                    "ERROR",
                    "❌ Failed to apply job",
                    null
            );
        }
    }
}


//
//@Service
//public class JobServiceImpl implements JobService {
//
//    @Autowired
//    private JobRepository jobRepository;
//
//    @Autowired
//    private EmailService emailService;
//
//    public ApiResponse apply(JobApplication job, MultipartFile resumeFile) {
//
//        try {
//            // 1️⃣ Save job data in DB (NO resume path)
//            JobApplication savedJob = jobRepository.save(job);
//
//            // 2️⃣ Send resume via email
//            emailService.sendResume(savedJob, resumeFile);
//
//            return new ApiResponse(
//                    201,
//                    "SUCCESS",
//                    "✅ Job applied successfully. Resume sent to admin.",
//                    savedJob
//            );
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ApiResponse(
//                    500,
//                    "ERROR",
//                    "❌ Failed to apply job",
//                    null
//            );
//        }
//    }
//}




//
//@Service
//public class JobServiceImpl implements JobService {
//
//    @Autowired
//    private JobRepository jobRepository;
//    
//    @Autowired
//    private FileService fileService;
//
//    @Override
//    public ApiResponse apply(JobApplication job, MultipartFile resumeFile) throws IOException {
//
//        ApiResponse response = new ApiResponse();
//
//        if (jobRepository.existsByAEmailAndAPosition(job.getaEmail(), job.getaPosition())) {
//            response.setStatusCode(409);
//            response.setStatus("FAILED");
//            response.setMessage("⚠️ You have already applied for this job!");
//            return response;
//        }
//
//        // Save resume if file exists
//        if (resumeFile != null && !resumeFile.isEmpty()) {
//            String resumeUrl = fileService.uploadResume(resumeFile);
//            job.setaResumeUrl(resumeUrl);
//        }
//
//        job.setAppliedDate(LocalDateTime.now().toString());
//        JobApplication saved = jobRepository.save(job);
//
//        response.setStatusCode(200);
//        response.setStatus("SUCCESS");
//        response.setMessage("🎉 Application Received Successfully");
//        response.setData(saved);
//
//        return response;
//    }
//
//}
