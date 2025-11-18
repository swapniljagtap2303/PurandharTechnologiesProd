package com.purandhar.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.purandhar.website.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
