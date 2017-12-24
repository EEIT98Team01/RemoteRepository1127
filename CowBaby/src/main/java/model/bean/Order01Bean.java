package model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order01")
public class Order01Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderID;
	private String email;
	private Date orderDate;
	private Date acceptDate;
	private Date buyerRequestCancel;
	private Date shippedDate;
	private Date transactionComplete;
	private Date orderCancellation;
	private String pickUpStore;
	private int totalAmount;
	private int totalItems;
	private String receiverName;
	private String receiverEmail;
	private String receiverPhone;
	private int usebonus;
	private int storeID;
	private int status;
	private int paymentMethod;
	
	@Override
	public String toString() {
		return "Order01Bean [orderID=" + orderID + ", email=" + email + ", orderDate=" + orderDate + ", acceptDate="
				+ acceptDate + ", buyerRequestCancel=" + buyerRequestCancel + ", shippedDate=" + shippedDate
				+ ", transactionComplete=" + transactionComplete + ", orderCancellation=" + orderCancellation
				+ ", pickUpStore=" + pickUpStore + ", totalAmount=" + totalAmount + ", totalItems=" + totalItems
				+ ", receiverName=" + receiverName + ", receiverEmail=" + receiverEmail + ", receiverPhone="
				+ receiverPhone + ", usebonus=" + usebonus + ", storeID=" + storeID + ", status=" + status
				+ ", paymentMethod=" + paymentMethod + "]";
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public Date getBuyerRequestCancel() {
		return buyerRequestCancel;
	}

	public void setBuyerRequestCancel(Date buyerRequestCancel) {
		this.buyerRequestCancel = buyerRequestCancel;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public Date getTransactionComplete() {
		return transactionComplete;
	}

	public void setTransactionComplete(Date transactionComplete) {
		this.transactionComplete = transactionComplete;
	}

	public Date getOrderCancellation() {
		return orderCancellation;
	}

	public void setOrderCancellation(Date orderCancellation) {
		this.orderCancellation = orderCancellation;
	}

	public String getPickUpStore() {
		return pickUpStore;
	}

	public void setPickUpStore(String pickUpStore) {
		this.pickUpStore = pickUpStore;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public int getUsebonus() {
		return usebonus;
	}

	public void setUsebonus(int usebonus) {
		this.usebonus = usebonus;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
