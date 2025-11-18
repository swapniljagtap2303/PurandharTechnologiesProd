package com.purandhar.website.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.purandhar.website.model.ApiResponse;
import com.purandhar.website.model.JobApplication;

public interface JobService {

	ApiResponse apply(JobApplication job, MultipartFile resumeFile) throws IOException;

}
