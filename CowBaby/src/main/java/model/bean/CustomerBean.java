package model.bean;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class CustomerBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerID;
	private String customerName;
	private String password;
	private String email;
	private String address;
	private String landline;
	private String mobilePhone;
	private Blob loginPhoto;
	private Date birthday;
	private String gender;
	private boolean marriage;
	private int income;
	private boolean subscription;
	private Date createTime;
	private int totalAmoutOfConsumption;
	private int consumptionTimes;
	private int userID;
	private int bonus;
	private byte consumerSegmentation; // type 改byte
	
	@Override
	public String toString() {
		return "CustomerBean [customerID=" + customerID + ", customerName=" + customerName + ", password=" + password
				+ ", email=" + email + ", address=" + address + ", landline=" + landline + ", mobilePhone="
				+ mobilePhone + ", loginPhoto=" + loginPhoto + ", birthday=" + birthday + ", gender=" + gender
				+ ", marriage=" + marriage + ", income=" + income + ", subscription=" + subscription + ", createTime="
				+ createTime + ", totalAmoutOfConsumption=" + totalAmoutOfConsumption + ", consumptionTimes="
				+ consumptionTimes + ", userID=" + userID + ", bonus=" + bonus + ", consumerSegmentation="
				+ consumerSegmentation + "]";
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public java.sql.Blob getLoginPhoto() {
		return loginPhoto;
	}

	public void setLoginPhoto(java.sql.Blob loginPhoto) {
		this.loginPhoto = loginPhoto;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isMarriage() {
		return marriage;
	}

	public void setMarriage(boolean marriage) {
		this.marriage = marriage;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public boolean isSubscription() {
		return subscription;
	}

	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public int getTotalAmoutOfConsumption() {
		return totalAmoutOfConsumption;
	}

	public void setTotalAmoutOfConsumption(int totalAmoutOfConsumption) {
		this.totalAmoutOfConsumption = totalAmoutOfConsumption;
	}

	public int getConsumptionTimes() {
		return consumptionTimes;
	}

	public void setConsumptionTimes(int consumptionTimes) {
		this.consumptionTimes = consumptionTimes;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public byte getConsumerSegmentation() {
		return consumerSegmentation;
	}

	public void setConsumerSegmentation(byte consumerSegmentation) {
		this.consumerSegmentation = consumerSegmentation;
	}
	
}
