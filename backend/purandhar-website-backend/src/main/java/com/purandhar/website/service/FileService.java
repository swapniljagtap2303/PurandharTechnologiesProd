package com.purandhar.website.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    private final String uploadPath = "uploads/resumes/";

    public String uploadResume(MultipartFile file) throws IOException {

        File directory = new File(uploadPath);
        if (!directory.exists()) directory.mkdirs();

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadPath + fileName);

        Files.copy(file.getInputStream(), filePath);

        return "/resumes/" + fileName; // return URL
    }
}

