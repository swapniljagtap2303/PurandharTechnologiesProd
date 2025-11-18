package com.purandhar.website.service;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.purandhar.website.model.ApiResponse;
import com.purandhar.website.model.JobApplication;
import com.purandhar.website.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private FileService fileService;

    @Override
    public ApiResponse apply(JobApplication job, MultipartFile resumeFile) throws IOException {

        ApiResponse response = new ApiResponse();

        if (jobRepository.existsByAEmailAndAPosition(job.getaEmail(), job.getaPosition())) {
            response.setStatusCode(409);
            response.setStatus("FAILED");
            response.setMessage("⚠️ You have already applied for this job!");
            return response;
        }

        // Save resume if file exists
        if (resumeFile != null && !resumeFile.isEmpty()) {
            String resumeUrl = fileService.uploadResume(resumeFile);
            job.setaResumeUrl(resumeUrl);
        }

        job.setAppliedDate(LocalDateTime.now().toString());
        JobApplication saved = jobRepository.save(job);

        response.setStatusCode(200);
        response.setStatus("SUCCESS");
        response.setMessage("🎉 Application Received Successfully");
        response.setData(saved);

        return response;
    }

}
