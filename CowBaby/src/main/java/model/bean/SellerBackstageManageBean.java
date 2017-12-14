package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SellerBackstageManage")
public class SellerBackstageManageBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeID;
	private String storeName;
	private int customerID;
	private boolean storeStatus;
	private String storePhone;
	private String storeDescription;
	private int storeRating;
	private String storeBanner;
	private java.sql.Blob storeLogo;

	@Override
	public String toString() {
		return "SellerBackstageManageBean [storeID=" + storeID + ", storeName=" + storeName + ", customerID="
				+ customerID + ", storeStatus=" + storeStatus + ", storePhone=" + storePhone + ", storeDescription="
				+ storeDescription + ", storeRating=" + storeRating + ", storeBanner=" + storeBanner + ", storeLogo="
				+ storeLogo + "]";
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public boolean isStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(boolean storeStatus) {
		this.storeStatus = storeStatus;
	}

	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}

	public String getStoreDescription() {
		return storeDescription;
	}

	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}

	public int getStoreRating() {
		return storeRating;
	}

	public void setStoreRating(int storeRating) {
		this.storeRating = storeRating;
	}

	public String getStoreBanner() {
		return storeBanner;
	}

	public void setStoreBanner(String storeBanner) {
		this.storeBanner = storeBanner;
	}

	public java.sql.Blob getStoreLogo() {
		return storeLogo;
	}

	public void setStoreLogo(java.sql.Blob storeLogo) {
		this.storeLogo = storeLogo;
	}

}
