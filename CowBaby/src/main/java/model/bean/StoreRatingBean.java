package model.bean;

import java.util.Date;

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
	private String email;
	private int storeID;
	private int ratingScore;
	private Date ratingTime;
	
	@Override
	public String toString() {
		return "StoreRatingBean [ratingID=" + ratingID + ", email=" + email + ", storeID=" + storeID + ", ratingScore="
				+ ratingScore + ", ratingTime=" + ratingTime + "]";
	}

	public int getRatingID() {
		return ratingID;
	}

	public void setRatingID(int ratingID) {
		this.ratingID = ratingID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getRatingTime() {
		return ratingTime;
	}

	public void setRatingTime(Date ratingTime) {
		this.ratingTime = ratingTime;
	}
	
}
