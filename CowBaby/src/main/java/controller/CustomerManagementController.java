package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.service.CustomerManagementService;

@Controller
public class CustomerManagementController {
	@Autowired
	CustomerManagementService customerManagementService;
	
	// 會員管理/會員檢視使用
	@RequestMapping(
			value=("/pages/backstageAdmit/CustomerManagementView"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String view(Model model, String id) {
		if(id != null && !"".equals(id.trim())) {
			model.addAttribute("customerData", customerManagementService.findById(Integer.parseInt(id)));
		}
		
		return "member_managment_view";
	}
	
	// 會員管理/會員編輯使用
	@RequestMapping(
			value=("/pages/backstageAdmit/CustomerManagementEdit"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String edit(Model model, String id) {
		if(id != null && !"".equals(id.trim())) {
			model.addAttribute("customerData", customerManagementService.findById(Integer.parseInt(id)));
		}
		
		return "member_managment_edit";
	}
	
}


