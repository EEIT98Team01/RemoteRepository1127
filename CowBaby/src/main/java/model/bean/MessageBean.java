package model.bean;

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
	private int msgSenderID;
	private int msgReceiverID;
	private java.sql.Timestamp msgTime;
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

	public int getMsgSenderID() {
		return msgSenderID;
	}

	public void setMsgSenderID(int msgSenderID) {
		this.msgSenderID = msgSenderID;
	}

	public int getMsgReceiverID() {
		return msgReceiverID;
	}

	public void setMsgReceiverID(int msgReceiverID) {
		this.msgReceiverID = msgReceiverID;
	}

	public java.sql.Timestamp getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(java.sql.Timestamp msgTime) {
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
