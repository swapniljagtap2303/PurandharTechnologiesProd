package com.purandhar.website.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "C_ID")
	private Long cId;
		
	@Column(name= "C_NAME")
	private String cName;
	
	@Column(name= "C_EMAIL")
	private String cEmail;
	
	@Column(name= "C_MESSAGE")
	private String cMessage;
	
	public Contact() {
		super();
	}

	public Contact(Long cId, String cName, String cEmail, String cMessage) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cMessage = cMessage;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcMessage() {
		return cMessage;
	}

	public void setcMessage(String cMessage) {
		this.cMessage = cMessage;
	}

	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", cName=" + cName + ", cEmail=" + cEmail + ", cMessage=" + cMessage + "]";
	}

}
