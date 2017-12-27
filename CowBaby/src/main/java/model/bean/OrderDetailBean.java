package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetailBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailID;
	private int orderID;
	private int productID;
	private int unitPrice;
	private int quantity;
	private String title; 				// 新增商品名稱
	private String productSpec; 		// 新增商品規格
	
	@Override
	public String toString() {
		return "OrderDetailBean [orderDetailID=" + orderDetailID + ", orderID=" + orderID + ", productID=" + productID
				+ ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", title=" + title + ", productSpec="
				+ productSpec + "]";
	}

	public int getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}

}
