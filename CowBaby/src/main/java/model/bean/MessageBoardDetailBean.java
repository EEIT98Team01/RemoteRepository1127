package model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MessageBoardDetail")
public class MessageBoardDetailBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageDetailID;
	private int messageID;
	private Date messageTime;
	private String messageContent;
	private String email;
	
	@Override
	public String toString() {
		return "MessageBoardDetailBean [messageDetailID=" + messageDetailID + ", messageID=" + messageID
				+ ", messageTime=" + messageTime + ", messageContent=" + messageContent + ", email=" + email + "]";
	}

	public int getMessageDetailID() {
		return messageDetailID;
	}

	public void setMessageDetailID(int messageDetailID) {
		this.messageDetailID = messageDetailID;
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
