package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AdvertisementDetail")
public class AdvertisementDetailBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adDetailID;
	private int adID;
	private java.sql.Timestamp displayAdTime;
	private boolean adPurchasedState; 					// type改boolean

	@Override
	public String toString() {
		return "AdvertisementDetailBean [adDetailID=" + adDetailID + ", adID=" + adID + ", displayAdTime="
				+ displayAdTime + ", adPurchasedState=" + adPurchasedState + "]";
	}

	public int getAdDetailID() {
		return adDetailID;
	}

	public void setAdDetailID(int adDetailID) {
		this.adDetailID = adDetailID;
	}

	public int getAdID() {
		return adID;
	}

	public void setAdID(int adID) {
		this.adID = adID;
	}

	public java.sql.Timestamp getDisplayAdTime() {
		return displayAdTime;
	}

	public void setDisplayAdTime(java.sql.Timestamp displayAdTime) {
		this.displayAdTime = displayAdTime;
	}

	public boolean isAdPurchasedState() {
		return adPurchasedState;
	}

	public void setAdPurchasedState(boolean adPurchasedState) {
		this.adPurchasedState = adPurchasedState;
	}

}
