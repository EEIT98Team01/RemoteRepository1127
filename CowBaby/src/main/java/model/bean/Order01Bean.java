package model.bean;

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
	private int customerID;
	private java.sql.Timestamp orderDate;
	private java.sql.Timestamp acceptDate;
	private java.sql.Timestamp buyerRequestCancel;
	private java.sql.Timestamp shippedDate;
	private java.sql.Timestamp transactionComplete;
	private java.sql.Timestamp orderCancellation;
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
		return "Order01Bean [orderID=" + orderID + ", customerID=" + customerID + ", orderDate=" + orderDate
				+ ", acceptDate=" + acceptDate + ", buyerRequestCancel=" + buyerRequestCancel + ", shippedDate="
				+ shippedDate + ", transactionComplete=" + transactionComplete + ", orderCancellation="
				+ orderCancellation + ", pickUpStore=" + pickUpStore + ", totalAmount=" + totalAmount + ", totalItems="
				+ totalItems + ", receiverName=" + receiverName + ", receiverEmail=" + receiverEmail
				+ ", receiverPhone=" + receiverPhone + ", usebonus=" + usebonus + ", storeID=" + storeID + ", status="
				+ status + ", paymentMethod=" + paymentMethod + "]";
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public java.sql.Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public java.sql.Timestamp getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(java.sql.Timestamp acceptDate) {
		this.acceptDate = acceptDate;
	}

	public java.sql.Timestamp getBuyerRequestCancel() {
		return buyerRequestCancel;
	}

	public void setBuyerRequestCancel(java.sql.Timestamp buyerRequestCancel) {
		this.buyerRequestCancel = buyerRequestCancel;
	}

	public java.sql.Timestamp getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(java.sql.Timestamp shippedDate) {
		this.shippedDate = shippedDate;
	}

	public java.sql.Timestamp getTransactionComplete() {
		return transactionComplete;
	}

	public void setTransactionComplete(java.sql.Timestamp transactionComplete) {
		this.transactionComplete = transactionComplete;
	}

	public java.sql.Timestamp getOrderCancellation() {
		return orderCancellation;
	}

	public void setOrderCancellation(java.sql.Timestamp orderCancellation) {
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
