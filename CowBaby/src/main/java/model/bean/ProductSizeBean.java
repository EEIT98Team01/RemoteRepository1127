package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductSize")
public class ProductSizeBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productSizeID;
	private int productID;
	private String productSpec;
	private int specStock;

	@Override
	public String toString() {
		return "ProductSizeBean [productSizeID=" + productSizeID + ", productID=" + productID + ", productSpec="
				+ productSpec + ", specStock=" + specStock + "]";
	}

	public int getProductSizeID() {
		return productSizeID;
	}

	public void setProductSizeID(int productSizeID) {
		this.productSizeID = productSizeID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}

	public int getSpecStock() {
		return specStock;
	}

	public void setSpecStock(int specStock) {
		this.specStock = specStock;
	}

}
