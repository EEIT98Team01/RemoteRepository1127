package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	private int storeID;
	private String title;
	private String summary;
	private int unitPrice;
	private String productDescription;
	private boolean productStatus; 				// type改bit
	private int classficationID;
	private byte suitableAges; 					// type改tinyint
	private String genderPreference;
	private java.sql.Timestamp displayTime;
	private String productImage;
	
	@Override
	public String toString() {
		return "ProductBean [productID=" + productID + ", storeID=" + storeID + ", title=" + title + ", summary="
				+ summary + ", unitPrice=" + unitPrice + ", productDescription=" + productDescription
				+ ", productStatus=" + productStatus + ", classficationID=" + classficationID + ", suitableAges="
				+ suitableAges + ", genderPreference=" + genderPreference + ", displayTime=" + displayTime
				+ ", productImage=" + productImage + "]";
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public int getClassficationID() {
		return classficationID;
	}

	public void setClassficationID(int classficationID) {
		this.classficationID = classficationID;
	}

	public byte getSuitableAges() {
		return suitableAges;
	}

	public void setSuitableAges(byte suitableAges) {
		this.suitableAges = suitableAges;
	}

	public String getGenderPreference() {
		return genderPreference;
	}

	public void setGenderPreference(String genderPreference) {
		this.genderPreference = genderPreference;
	}

	public java.sql.Timestamp getDisplayTime() {
		return displayTime;
	}

	public void setDisplayTime(java.sql.Timestamp displayTime) {
		this.displayTime = displayTime;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

}
