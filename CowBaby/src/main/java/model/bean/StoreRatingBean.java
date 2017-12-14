package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StoreRating")
public class StoreRatingBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingID;
	private int customerID;
	private int storeID;
	private int ratingScore;
	private java.sql.Timestamp ratingTime;

	@Override
	public String toString() {
		return "StoreRatingBean [ratingID=" + ratingID + ", customerID=" + customerID + ", storeID=" + storeID
				+ ", ratingScore=" + ratingScore + ", ratingTime=" + ratingTime + "]";
	}

	public int getRatingID() {
		return ratingID;
	}

	public void setRatingID(int ratingID) {
		this.ratingID = ratingID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public int getRatingScore() {
		return ratingScore;
	}

	public void setRatingScore(int ratingScore) {
		this.ratingScore = ratingScore;
	}

	public java.sql.Timestamp getRatingTime() {
		return ratingTime;
	}

	public void setRatingTime(java.sql.Timestamp ratingTime) {
		this.ratingTime = ratingTime;
	}

}
