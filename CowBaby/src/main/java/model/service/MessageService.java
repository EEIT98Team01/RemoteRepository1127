package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.MessageBean;
import model.dao.MessageDao;

@Service
@Transactional
public class MessageService {
	@Autowired
	private MessageDao messageDao;
	
	// 取得某筆Message資料
	public MessageBean findById(int id) {
		return messageDao.findById(id);
	}
	
	// 接收符合條件的Message資料
	public List<MessageBean> receiverMessage(String receiverAccount, String msgSenderID, String readStatus, String msgMarker, int page, int rows, String sortCondition) {
		
		if(receiverAccount == null || "".equals(receiverAccount.trim())) {
			// 若沒有收訊人,則回傳null
			return null;
		} else {
			// 有收訊人,則回傳回傳符合條件的資料
			Map<String, String> condition = new HashMap<String, String>();
				
			condition.put("msgReceiverID", "like '" + receiverAccount + "'");
				
			if(msgSenderID != null && !"".equals(msgSenderID.trim())) {
				condition.put("msgSenderID", "like '%" + msgSenderID + "%'");
			}
			
			if(readStatus != null && !"".equals(readStatus.trim())) {
				condition.put("readStatus", "= " + readStatus);
			}
				
			if(msgMarker != null && !"".equals(msgMarker.trim())) {
				condition.put("msgMarker", "= " + msgMarker);
			}
				
			return messageDao.findByCondition(condition, page, rows, sortCondition);
		}
	}
	
	// 取得符合條件Message資料數量
	public int getQuantity(String receiverAccount, String msgSenderID, String readStatus, String msgMarker) {

		if(receiverAccount != null && !"".equals(receiverAccount.trim())) {
			// 有輸入收件者帳號才做後續處理
			Map<String, String> condition = new HashMap<String, String>();
			
			condition.put("MsgReceiverID", "like '" + receiverAccount + "'");
			
			if(msgSenderID != null && !"".equals(msgSenderID.trim())) {
				condition.put("msgSenderID", "like '%" + msgSenderID + "%'");
			}
			
			if(readStatus != null && !"".equals(readStatus.trim())) {
				condition.put("readStatus", "= " + readStatus);
			}
				
			if(msgMarker != null && !"".equals(msgMarker.trim())) {
				condition.put("msgMarker", "= " + msgMarker);
			}
				
			return messageDao.getConditionQuantity(condition);
		} else {
			// 沒有收件者帳號,直接回傳0
			return 0;
		}

	}
	
	// 發送訊息
	public MessageBean sendMessage(String msgSenderAccount, String msgReceiverAccount, String msgContent) {
		// 之後要加檢查帳號是否存在
		
		MessageBean message = new MessageBean();
		message.setMsgSenderID(msgSenderAccount);
		message.setMsgReceiverID(msgReceiverAccount);
		message.setMsgTime(new java.util.Date());
		message.setReadStatus(false);
		message.setMsgContent(msgContent);
		message.setMsgResponse(null);
		message.setMsgMarker(false);
		return messageDao.insert(message);
	}
	
	// 回覆訊息
	public MessageBean replyMessage(int messageId, String msgResponse) {
		MessageBean select = messageDao.findById(messageId);
		
		if(select == null) {
			// message不存在
			return null;
		} else {
			// message存在
			if(msgResponse != null && !"".equals(msgResponse.trim())) {
				select.setMsgResponse(msgResponse);
			}
			
			return messageDao.update(select);
		}
		
	}
	
	// 改變訊息狀態
	public MessageBean changeMessageStatus(int messageId, String readStatus, String msgMarker) {
		MessageBean select = messageDao.findById(messageId);
		
		if(select == null) {
			// message不存在
			return null;
		} else {
			// message存在
			if(readStatus != null && !"".equals(readStatus.trim())) {
				select.setReadStatus(Boolean.parseBoolean(readStatus));
			}
			
			if(msgMarker != null && !"".equals(msgMarker.trim())) {
				select.setMsgMarker(Boolean.parseBoolean(msgMarker));
			}
			
			return messageDao.update(select);
		}
		
	}

	// 刪除訊息
	public Boolean removeMessage(int messageId) {
		return messageDao.delete(messageId);
	}
	
}
