package com.purandhar.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purandhar.website.model.ApiResponse;
import com.purandhar.website.model.Contact;
import com.purandhar.website.service.contactService;


@RestController
@RequestMapping("/api/contact")
//@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {
	
	@Autowired
	contactService contactService;
	
	@PostMapping("/saveContact")
	public ResponseEntity<ApiResponse> saveContact(@RequestBody Contact message) {
		
		System.out.println("MESSAGE: "+message);
		
		ApiResponse response=new ApiResponse();
		
		try {
		 Contact result = contactService.saveContact(message);
		 
		 response.setStatusCode(201);
		 response.setStatus("SUCCESS");
		 response.setMessage("Thank you," + message.getcName() + "! We’ve received your message.");
		 response.setData(result);
			
			return ResponseEntity.status(response.getStatusCode()).body(response);
		}catch(Exception e){
			
			response.setStatusCode(500);
			response.setStatus("ERROR");
			response.setMessage("Something went wrong while saving your message.");
			response.setData(e);
			return ResponseEntity.status(response.getStatusCode()).body(response);
		}
	
	}

}
