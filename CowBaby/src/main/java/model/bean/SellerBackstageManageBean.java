package model.bean;

import java.sql.Blob;

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
	private String email;
	private boolean storeStatus;
	private String storePhone;
	private String storeDescription;
	private int storeRating;
	private String storeBanner;
	private Blob storeLogo;
	private int totalPageView;
	
	@Override
	public String toString() {
		return "SellerBackstageManageBean [storeID=" + storeID + ", storeName=" + storeName + ", email=" + email
				+ ", storeStatus=" + storeStatus + ", storePhone=" + storePhone + ", storeDescription="
				+ storeDescription + ", storeRating=" + storeRating + ", storeBanner=" + storeBanner + ", storeLogo="
				+ storeLogo + ", totalPageView=" + totalPageView + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Blob getStoreLogo() {
		return storeLogo;
	}

	public void setStoreLogo(Blob storeLogo) {
		this.storeLogo = storeLogo;
	}

	public int getTotalPageView() {
		return totalPageView;
	}

	public void setTotalPageView(int totalPageView) {
		this.totalPageView = totalPageView;
	}
	
}
