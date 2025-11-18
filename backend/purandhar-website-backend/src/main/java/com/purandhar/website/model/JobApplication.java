package com.purandhar.website.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "JOBAPPLICATION")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID")
    private Long aid;

    @Column(name = "ANAME", nullable = false)
    private String aName;

    @Column(name = "AEMAIL", nullable = false)
    private String aEmail;

    @Column(name = "APHONE", nullable = false)
    private String aPhone;

    @Column(name = "APOSITION", nullable = false)
    private String aPosition;
    
    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "ARESUME_URL")
    private String aResumeUrl;

    @Column(name = "APPLIED_DATE")
    private String appliedDate;   

    @Column(name = "EXPERIENCE")
    private String experience;

    @Column(name = "LOCATION")
    private String location;

	public JobApplication() {
		super();
	}

	public JobApplication(Long aid, String aName, String aEmail, String aPhone, String aPosition, String message,
			String aResumeUrl, String appliedDate, String experience, String location) {
		super();
		this.aid = aid;
		this.aName = aName;
		this.aEmail = aEmail;
		this.aPhone = aPhone;
		this.aPosition = aPosition;
		this.message = message;
		this.aResumeUrl = aResumeUrl;
		this.appliedDate = appliedDate;
		this.experience = experience;
		this.location = location;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaPhone() {
		return aPhone;
	}

	public void setaPhone(String aPhone) {
		this.aPhone = aPhone;
	}

	public String getaPosition() {
		return aPosition;
	}

	public void setaPosition(String aPosition) {
		this.aPosition = aPosition;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getaResumeUrl() {
		return aResumeUrl;
	}

	public void setaResumeUrl(String aResumeUrl) {
		this.aResumeUrl = aResumeUrl;
	}

	public String getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(String appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "JobApplication [aid=" + aid + ", aName=" + aName + ", aEmail=" + aEmail + ", aPhone=" + aPhone
				+ ", aPosition=" + aPosition + ", message=" + message + ", aResumeUrl=" + aResumeUrl + ", appliedDate="
				+ appliedDate + ", experience=" + experience + ", location=" + location + "]";
	}
    
    

}
