package com.purandhar.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purandhar.website.model.Contact;
import com.purandhar.website.repository.ContactRepository;

@Service
public class ContactServiceimpl implements contactService{
	
	@Autowired
	ContactRepository contactRepository;

	public Contact saveContact(Contact message) {
		 
		return contactRepository.save(message); 
	 
	}

}
