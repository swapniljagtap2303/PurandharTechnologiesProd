package com.purandhar.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.purandhar.website.model.ApiResponse;
import com.purandhar.website.model.NewsletterSubscriber;
import com.purandhar.website.service.NewsletterService;

@CrossOrigin(
	    origins = "https://purandhartechnologiesprod.vercel.app",
	    allowedHeaders = "*",
	    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
	)

@RestController
@RequestMapping("/api/newsletter")

public class NewsletterController {

	@Autowired
	NewsletterService newsletterService;
	

    @PostMapping("/subscribe")
    public ResponseEntity<ApiResponse> subscribe(@RequestBody NewsletterSubscriber email) {
    	
    	System.out.println("Email: "+email.getEmail());
    	
    	
        ApiResponse serviceResponse = newsletterService.save(email);
        
        return ResponseEntity.status(serviceResponse.getStatusCode()).body(serviceResponse);
    }

}
