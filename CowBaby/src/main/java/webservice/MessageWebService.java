package webservice;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.bean.CustomerBean;
import model.bean.MessageBean;
import model.service.CustomerManagementService;
import model.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageWebService {
	@Autowired
	MessageService messageService;
	@Autowired
	CustomerManagementService customerManagementService;
	
	// 回傳單一筆Message資料
	@RequestMapping(
			value="/getMessage",
			method={RequestMethod.GET},
			produces={"application/json;charset=UTF-8"}
	)
	public String getMessage(int messageID) {
		JSONObject jsonObj = new JSONObject();
		MessageBean result = messageService.findById(messageID);
		
		if(result != null) {
			jsonObj.put("message", "success");
			jsonObj.put("error", "");
			jsonObj.put("data", new JSONObject(result).toString());
		} else {
			jsonObj.put("message", "");
			jsonObj.put("error", "no data");
		}
		
		return jsonObj.toString();
	}
	
	// 回傳符合某條件的訊息
	@RequestMapping(
			value="/getMessageList",
			method={RequestMethod.GET},
			produces={"application/json;charset=UTF-8"}
	)
	public String getMessageList(String receiverAccount, String msgSenderID, String userType, String readStatus, String msgMarker, int pageNumber, int pageSize, String sortCondition) {
		JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
		JSONArray array;						// 儲存List<MessageBean>的json物件
		int pageQuantity;						// 總頁數
		int quantity = 0; 						// 取得符合所有條件的筆數
		List<MessageBean> messageList = null;
		
		if( (msgSenderID != null  && !"".equals(msgSenderID.trim())) || "全部".equals(userType) ) {
			// 有指定寄件人或不選擇寄件者身份
			messageList = messageService.receiverMessage(receiverAccount, msgSenderID, readStatus, msgMarker, pageNumber, pageSize, sortCondition);
			quantity = messageService.getQuantity(receiverAccount, msgSenderID, readStatus, msgMarker);
			array = new JSONArray(messageList);
		} else {
			// 沒有指定寄件人,且指定寄件者身份
			List<MessageBean> resultMessageList = null;
			
			if("系統訊息".equals(userType)) {
				// 只看系統訊息
				resultMessageList = messageService.receiverMessage(receiverAccount, "admini@gmail.com", readStatus, msgMarker, pageNumber, pageSize, sortCondition);
				quantity = messageService.getQuantity(receiverAccount, "admini@gmail.com", readStatus, msgMarker);
				array = new JSONArray(messageList);
			} else if("一般會員".equals(userType)) {
				// 只看一般會員訊息
				
				// 取得所有訊息
				quantity = messageService.getQuantity(receiverAccount, msgSenderID, readStatus, msgMarker);
				messageList = messageService.receiverMessage(receiverAccount, msgSenderID, readStatus, msgMarker, 1, quantity, sortCondition);

				// 取得所有一般會員訊息
				quantity = 0;
				List<MessageBean> tempMessageList = new LinkedList<MessageBean>();
				for(int i = 0; i < messageList.size(); i++) {
					// 取得訊息發送者資訊
					CustomerBean customer = customerManagementService.findByCondition(messageList.get(i).getMsgSenderID(), null, null).get(0);
					
					if(customer.getUserID() != 4) {
						// ID不為4表示為其餘會員
						tempMessageList.add(messageList.get(i));
						quantity++;
					}
				}
				
				// 取得某區段一般會員訊息
				resultMessageList = this.subList(tempMessageList, (pageNumber - 1) * pageSize, pageSize);
			} else if("自己".equals(userType)){
				// 只看自己的訊息
				resultMessageList = messageService.receiverMyselfMessage(receiverAccount, pageNumber, pageSize, sortCondition);
				quantity = messageService.getQuantity(null, receiverAccount, null, null);
				System.out.println("quantity:" + quantity);
			}
			
			array = new JSONArray(resultMessageList);
		}

		
		// 計算總頁數
		if((quantity%pageSize) == 0) {
			pageQuantity = quantity/pageSize;
		} else {
			pageQuantity = quantity/pageSize+1;
		}
		
		// 將回傳資料塞入json物件
		jsonObj.put("tatal", quantity); 
		jsonObj.put("tatalPage", pageQuantity); 
		jsonObj.put("pageNumber", pageNumber);
		jsonObj.put("pageSize", pageSize); 
		jsonObj.put("list", array.toString()); 

		return jsonObj.toString();
	}
	
	// 發送訊息
	@RequestMapping(
			value="/sendMessage",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String sendMessage(String msgSenderAccount, String msgReceiverAccount, String msgContent) {
		JSONObject jsonObj = new JSONObject();
		MessageBean result = messageService.sendMessage(msgSenderAccount, msgReceiverAccount, msgContent);
		
		if(result != null) {
			jsonObj.put("message", "發送成功");
			jsonObj.put("error", "");
		} else {
			jsonObj.put("message", "");
			jsonObj.put("error", "發送失敗");
		}
		
		return jsonObj.toString();
	}
	
	// 發送訊息特定人或特定身份(管理者用)
	@RequestMapping(
			value="/sendMessages",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String sendMessages(String account, String range, String msgContent) {
		System.out.println("account:" + account);
		System.out.println("range:" + range);
		System.out.println("msgContent:" + msgContent);
		
		JSONObject jsonObj = new JSONObject();

		if( (account == null || "".equals(account.trim())) && (range == null || "".equals(range.trim())) ) {
			// 沒有指定收件人及範圍
			jsonObj.put("message", "");
			jsonObj.put("error", "沒有指定收件者");
		} else if(account != null && !"".equals(account.trim())) {
			// 指定收件人
			if(customerManagementService.findByCondition(account, null, null).size() == 1) {
				// 收件人帳號存在,則發送訊息
				messageService.sendMessage("admini@gmail.com", account, msgContent);
				jsonObj.put("message", "已成功發送訊息給" + account);
				jsonObj.put("error", "");
			} else {
				// 收件人帳號不存在
				jsonObj.put("message", "");
				jsonObj.put("error", "指定之帳號不存在");
			}
		} else {
			// 沒有指定發送者,選擇依身份發送訊息
			List<CustomerBean> customerList;
			if("0".equals(range)) {
				// 發送訊息給所有會員,取得所有會員清單
				customerList = customerManagementService.find();
			} else {
				// 發送訊息給特定身份會員,取得該身份會員清單
				customerList = customerManagementService.findByCondition(null, range, null);
			}
			
			// 發送訊息給列表內所有人
			for(CustomerBean customer: customerList) {
				messageService.sendMessage("admini@gmail.com", customer.getEmail(), msgContent);
			}
			
			jsonObj.put("message", "訊息成功發出");
			jsonObj.put("error", "");
		}
		
		return jsonObj.toString();
	}
	
	// 回覆訊息
	@RequestMapping(
			value="/replyMessage",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String replyMessage(int messageId, String msgResponse) {
		JSONObject jsonObj = new JSONObject();
		MessageBean result = messageService.replyMessage(messageId, msgResponse);
		
		if(result != null) {
			jsonObj.put("message", "回覆成功");
			jsonObj.put("error", "");
		} else {
			jsonObj.put("message", "");
			jsonObj.put("error", "回覆失敗");
		}
		
		return jsonObj.toString();
	}
	
	// 變更訊息狀態
	@RequestMapping(
			value="/changeMessageStatus",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
		)
	public String changeMessageStatus(int messageId, String readStatus, String msgMarker) {
		JSONObject jsonObj = new JSONObject();
		MessageBean result = messageService.changeMessageStatus(messageId, readStatus, msgMarker);
			
		if(result != null) {
			jsonObj.put("message", "變更成功");
			jsonObj.put("error", "");
		} else {
			jsonObj.put("message", "");
			jsonObj.put("error", "變更失敗");
		}
			
		return jsonObj.toString();
	}
	
	// 刪除訊息
	@RequestMapping(
			value="/removeMessage",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String removeMessage(int messageId) {
		JSONObject jsonObj = new JSONObject();
		Boolean result = messageService.removeMessage(messageId);
			
		if(result) {
			jsonObj.put("message", "刪除成功");
			jsonObj.put("error", "");
		} else {
			jsonObj.put("message", "");
			jsonObj.put("error", "刪除失敗");
		}
			
		return jsonObj.toString();
	}
	
	private List<MessageBean> subList(List<MessageBean> list, int start, int end) {
		List<MessageBean> result = new LinkedList<MessageBean>();
		
		int i = 0;
		while( ((start+i) < list.size()) && (i < end) ) {
			result.add(list.get(start+i));
			i++;
		}
		
		return result;
	}
}
