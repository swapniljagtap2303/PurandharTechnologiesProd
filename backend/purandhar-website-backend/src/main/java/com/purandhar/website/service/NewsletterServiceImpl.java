package com.purandhar.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purandhar.website.model.ApiResponse;
import com.purandhar.website.model.NewsletterSubscriber;
import com.purandhar.website.repository.NewsletterRepository;

@Service
public class NewsletterServiceImpl implements NewsletterService {
	
	@Autowired
	NewsletterRepository newsletterRepository;

	
	@Override
	public ApiResponse save(NewsletterSubscriber subscriber) {
		
	    ApiResponse response = new ApiResponse();

	    if (newsletterRepository.existsByEmail(subscriber.getEmail())) {
	        response.setStatusCode(409); // Conflict
	        response.setStatus("FAILED");
	        response.setMessage(" This email (" + subscriber.getEmail() + ") is already subscribed.");
	        return response;
	    }

	    NewsletterSubscriber savedSubscriber = newsletterRepository.save(subscriber);

	    response.setStatusCode(200);
	    response.setStatus("SUCCESS");
	    response.setMessage("Thank you! " + subscriber.getEmail() + " has been subscribed successfully.");
	    response.setData(savedSubscriber);

	    return response;
	}


}
