package webservice;

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
	public String getMessageList(String receiverAccount, String msgSenderID, String readStatus, String msgMarker, int pageNumber, int pageSize, String sortCondition) {
		JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
		JSONArray array;						// 儲存List<MessageBean>的json物件
		int quantity;							// 回傳的資料筆數
		int pageQuantity;						// 總頁數
		
		// 取得資料及總筆數
		array = new JSONArray(messageService.receiverMessage(receiverAccount, msgSenderID, readStatus, msgMarker, pageNumber, pageSize, sortCondition));
		quantity = messageService.getQuantity(receiverAccount, msgSenderID, readStatus, msgMarker);
		
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
				messageService.sendMessage("999@gmail.com", account, msgContent);
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
				messageService.sendMessage("999@gmail.com", customer.getEmail(), msgContent);
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
	
}
