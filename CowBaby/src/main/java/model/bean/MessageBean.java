package model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Message")
public class MessageBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int msgID;
	private String msgSenderID;
	private String msgReceiverID;
	private Date msgTime;
	private boolean readStatus;
	private String msgContent;
	private String msgResponse;
	private boolean msgMarker;
	
	@Override
	public String toString() {
		return "MessageBean [msgID=" + msgID + ", msgSenderID=" + msgSenderID + ", msgReceiverID=" + msgReceiverID
				+ ", msgTime=" + msgTime + ", readStatus=" + readStatus + ", msgContent=" + msgContent
				+ ", msgResponse=" + msgResponse + ", msgMarker=" + msgMarker + "]";
	}

	public int getMsgID() {
		return msgID;
	}

	public void setMsgID(int msgID) {
		this.msgID = msgID;
	}

	public String getMsgSenderID() {
		return msgSenderID;
	}

	public void setMsgSenderID(String msgSenderID) {
		this.msgSenderID = msgSenderID;
	}

	public String getMsgReceiverID() {
		return msgReceiverID;
	}

	public void setMsgReceiverID(String msgReceiverID) {
		this.msgReceiverID = msgReceiverID;
	}

	public Date getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}

	public boolean isReadStatus() {
		return readStatus;
	}

	public void setReadStatus(boolean readStatus) {
		this.readStatus = readStatus;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getMsgResponse() {
		return msgResponse;
	}

	public void setMsgResponse(String msgResponse) {
		this.msgResponse = msgResponse;
	}

	public boolean isMsgMarker() {
		return msgMarker;
	}

	public void setMsgMarker(boolean msgMarker) {
		this.msgMarker = msgMarker;
	}
	
}
