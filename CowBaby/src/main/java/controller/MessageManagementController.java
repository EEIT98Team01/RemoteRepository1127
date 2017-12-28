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
	
	// 訊息管理/訊息檢視使用/店家後台
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
	
	// 訊息管理/訊息刪除使用/店家後台
	@RequestMapping(
			value=("/pages/backstageSeller/messageDelete"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String deleteBackstageSeller(Model model, String messageId) {
		System.out.println("messageId:" + messageId);
		
		if(messageId != null && !"".equals(messageId.trim())) {
			messageService.removeMessage(Integer.parseInt(messageId));
		}
				
		return "message_list";
	}
	
	// 訊息管理/訊息檢視使用/會員前台
	@RequestMapping(
			value=("/pages/member/messageView"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String viewMember(Model model, String messageId) {
		if(messageId != null && !"".equals(messageId.trim())) {
			// 將所需資訊塞到requset
			MessageBean message = messageService.findById(Integer.parseInt(messageId));
			model.addAttribute("messageData", message);
			model.addAttribute("receiverName", customerManagementService.findByCondition(message.getMsgReceiverID(), null, null).get(0).getCustomerName());
			model.addAttribute("senderName", customerManagementService.findByCondition(message.getMsgSenderID(), null, null).get(0).getCustomerName());
			model.addAttribute("messageTime", message.getMsgTime().toString().substring(0, 19));
			
			// 將狀態改為已讀
			messageService.changeMessageStatus(message.getMsgID(), "true", message.isMsgMarker() + "");
		}
			
		return "message_detail_member";
	}
	
	// 訊息管理/訊息刪除使用/會員前台
	@RequestMapping(
			value=("/pages/member/messageDelete"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String deleteMember(Model model, String messageId) {
		System.out.println("messageId:" + messageId);
		
		if(messageId != null && !"".equals(messageId.trim())) {
			messageService.removeMessage(Integer.parseInt(messageId));
		}
				
		return "message_list_member";
	}
	
}
