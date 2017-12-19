package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Advertisement")
public class AdvertisementBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adID;
	private int storeID;
	private int adState;
	private java.sql.Timestamp orderAdTime;
	private int adFee;
	private byte adPackage; 			  // type改byte
	private java.sql.Blob adPreviewPhoto; // 新增adPreviewPhoto 廣告預覽小圖
	
	@Override
	public String toString() {
		return "AdvertisementBean [adID=" + adID + ", storeID=" + storeID + ", adState=" + adState + ", orderAdTime="
				+ orderAdTime + ", adFee=" + adFee + ", adPackage=" + adPackage + ", adPreviewPhoto=" + adPreviewPhoto
				+ "]";
	}

	public int getAdID() {
		return adID;
	}

	public void setAdID(int adID) {
		this.adID = adID;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public int getAdState() {
		return adState;
	}

	public void setAdState(int adState) {
		this.adState = adState;
	}

	public java.sql.Timestamp getOrderAdTime() {
		return orderAdTime;
	}

	public void setOrderAdTime(java.sql.Timestamp orderAdTime) {
		this.orderAdTime = orderAdTime;
	}

	public int getAdFee() {
		return adFee;
	}

	public void setAdFee(int adFee) {
		this.adFee = adFee;
	}

	public byte getAdPackage() {
		return adPackage;
	}

	public void setAdPackage(byte adPackage) {
		this.adPackage = adPackage;
	}

	public java.sql.Blob getAdPreviewPhoto() {
		return adPreviewPhoto;
	}

	public void setAdPreviewPhoto(java.sql.Blob adPreviewPhoto) {
		this.adPreviewPhoto = adPreviewPhoto;
	}
	
}
