package model.bean;

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
	private int customerID;
	private String problemDescription;
	private String serviceFeedback;
	private int processStatus;
	private java.sql.Timestamp reportTime;
	private java.sql.Timestamp reportiInProcess;
	private java.sql.Timestamp reportFix;

	@Override
	public String toString() {
		return "CustomerServiceBean [reportID=" + reportID + ", problemTypes=" + problemTypes + ", customerID="
				+ customerID + ", problemDescription=" + problemDescription + ", serviceFeedback=" + serviceFeedback
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

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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

	public java.sql.Timestamp getReportTime() {
		return reportTime;
	}

	public void setReportTime(java.sql.Timestamp reportTime) {
		this.reportTime = reportTime;
	}

	public java.sql.Timestamp getReportiInProcess() {
		return reportiInProcess;
	}

	public void setReportiInProcess(java.sql.Timestamp reportiInProcess) {
		this.reportiInProcess = reportiInProcess;
	}

	public java.sql.Timestamp getReportFix() {
		return reportFix;
	}

	public void setReportFix(java.sql.Timestamp reportFix) {
		this.reportFix = reportFix;
	}

}
