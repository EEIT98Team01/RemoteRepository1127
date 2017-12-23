package model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerService")
public class CustomerServiceBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportID;
	private int problemTypes;
	private String email;
	private String problemDescription;
	private String serviceFeedback;
	private int processStatus;
	private Date reportTime;
	private Date reportiInProcess;
	private Date reportFix;
	
	@Override
	public String toString() {
		return "CustomerServiceBean [reportID=" + reportID + ", problemTypes=" + problemTypes + ", email=" + email
				+ ", problemDescription=" + problemDescription + ", serviceFeedback=" + serviceFeedback
				+ ", processStatus=" + processStatus + ", reportTime=" + reportTime + ", reportiInProcess="
				+ reportiInProcess + ", reportFix=" + reportFix + "]";
	}

	public int getReportID() {
		return reportID;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public int getProblemTypes() {
		return problemTypes;
	}

	public void setProblemTypes(int problemTypes) {
		this.problemTypes = problemTypes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getServiceFeedback() {
		return serviceFeedback;
	}

	public void setServiceFeedback(String serviceFeedback) {
		this.serviceFeedback = serviceFeedback;
	}

	public int getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(int processStatus) {
		this.processStatus = processStatus;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public Date getReportiInProcess() {
		return reportiInProcess;
	}

	public void setReportiInProcess(Date reportiInProcess) {
		this.reportiInProcess = reportiInProcess;
	}

	public Date getReportFix() {
		return reportFix;
	}

	public void setReportFix(Date reportFix) {
		this.reportFix = reportFix;
	}

}
