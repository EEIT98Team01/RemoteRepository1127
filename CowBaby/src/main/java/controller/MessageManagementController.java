package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.MessageBean;
import model.service.CustomerManagementService;
import model.service.MessageService;

@Controller
public class MessageManagementController {
	@Autowired
	MessageService messageService;
	@Autowired
	CustomerManagementService customerManagementService;
	
	// 訊息管理/訊息檢視使用
	@RequestMapping(
			value=("/pages/backstageSeller/messageView"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String view(Model model, String messageId) {
		if(messageId != null && !"".equals(messageId.trim())) {
			// 將所需資訊塞到requset
			MessageBean message = messageService.findById(Integer.parseInt(messageId));
			model.addAttribute("messageData", message);
			model.addAttribute("customerName", customerManagementService.findByCondition(message.getMsgSenderID(), null, null).get(0).getCustomerName());
			model.addAttribute("messageTime", message.getMsgTime().toString().substring(0, 19));
			
			// 將狀態改為已讀
			messageService.changeMessageStatus(message.getMsgID(), "true", message.isMsgMarker() + "");
		}
			
		return "message_detail";
	}
	
}
