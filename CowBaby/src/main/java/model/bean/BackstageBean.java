package model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Backstage")
public class BackstageBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicationID;
	private String email;
	private Date applicationDate;
	private int applicationState;
	private String applicationDescription;
	
	@Override
	public String toString() {
		return "BackstageBean [applicationID=" + applicationID + ", email=" + email + ", applicationDate="
				+ applicationDate + ", applicationState=" + applicationState + ", applicationDescription="
				+ applicationDescription + "]";
	}

	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public int getApplicationState() {
		return applicationState;
	}

	public void setApplicationState(int applicationState) {
		this.applicationState = applicationState;
	}

	public String getApplicationDescription() {
		return applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}
	
}
