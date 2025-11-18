package com.purandhar.website.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NEWSLETTERSUBSCRIBER")
public class NewsletterSubscriber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EID")
	private Long eID;
	
	@Column(name = "EMAIL")
	private String email;

	public NewsletterSubscriber() {
		super();
	}

	public NewsletterSubscriber(Long eID, String email) {
		super();
		this.eID = eID;
		this.email = email;
	}

	public Long geteID() {
		return eID;
	}

	public void seteID(Long eID) {
		this.eID = eID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NewsletterSubscriber [eID=" + eID + ", email=" + email + "]";
	}
	
}
