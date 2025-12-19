package com.purandhar.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;

import  com.purandhar.website.model.ApiResponse;
import com.purandhar.website.model.JobApplication;
import com.purandhar.website.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    
    @PostMapping(value = "/apply", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> applyJob(
            @RequestPart("data") JobApplication job,
            @RequestPart(value = "resume", required = false) MultipartFile resumeFile) {

        System.out.println("Incoming Job Request: " + job);

        try {
            ApiResponse response = jobService.apply(job, resumeFile);
            return ResponseEntity.status(response.getStatusCode()).body(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500)
                    .body(new ApiResponse(500, "ERROR", "❌ Something went wrong", null));
        }
    }
}
