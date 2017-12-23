package model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MessageBoard")
public class MessageBoardBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageID;
	private int storeID;
	private int customerID;
	private int productID;
	private String messageTopic; 						// varchar(max)
	private Date messageTime;
	
	@Override
	public String toString() {
		return "MessageBoardBean [messageID=" + messageID + ", storeID=" + storeID + ", customerID=" + customerID
				+ ", productID=" + productID + ", messageTopic=" + messageTopic + ", messageTime=" + messageTime + "]";
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getMessageTopic() {
		return messageTopic;
	}

	public void setMessageTopic(String messageTopic) {
		this.messageTopic = messageTopic;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

}
