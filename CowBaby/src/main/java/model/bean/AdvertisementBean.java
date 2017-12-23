package model.bean;

import java.util.Date;

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
	private Date orderAdTime;
	private int adFee;
	private int adPackage;
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

	public Date getOrderAdTime() {
		return orderAdTime;
	}

	public void setOrderAdTime(Date orderAdTime) {
		this.orderAdTime = orderAdTime;
	}

	public int getAdFee() {
		return adFee;
	}

	public void setAdFee(int adFee) {
		this.adFee = adFee;
	}

	public int getAdPackage() {
		return adPackage;
	}

	public void setAdPackage(int adPackage) {
		this.adPackage = adPackage;
	}

	public java.sql.Blob getAdPreviewPhoto() {
		return adPreviewPhoto;
	}

	public void setAdPreviewPhoto(java.sql.Blob adPreviewPhoto) {
		this.adPreviewPhoto = adPreviewPhoto;
	}
	
}
