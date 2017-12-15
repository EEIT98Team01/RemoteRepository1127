package controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.CustomerBean;
import model.service.CustomerManagementService;
import model.utils.PrimitiveNumberEditor;

@Controller
public class CustomerManagementController {
	
	@Autowired
	CustomerManagementService customerManagementService;
	
	@RequestMapping(
			value=("CustomerManagementList.controller"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String list(Model model, String account, String userType, String page, String orderBy) {
	//讀取使用者輸入資料
	//進行必要的資料型態轉換
	//進行資料檢查
	//進行商業服務
		//處理userType的四種狀況
		if("全部".equals(userType)) {
			userType = "";
		} else if("一般會員".equals(userType)) {
			userType = "1";
		} else if("平台賣家".equals(userType)) {
			userType = "2";
		} else if("黑名單".equals(userType)) {
			userType = "3";
		}
		
		//若參數沒有page,則預設為1
		if(page == null) {
			page = "1";
		}
		
		//若參數沒有page,則預設為1
		if(orderBy == null) {
			orderBy = "CustomerID";
		}

		//將相關參數塞回request
		model.addAttribute("account", account);
		model.addAttribute("userType", userType);
		model.addAttribute("page", page);
		model.addAttribute("orderBy", orderBy);
		
		int quantity;
		if("".equals(account) && "".equals(userType)) {
			quantity = customerManagementService.getQuantity();
			model.addAttribute("customerList", customerManagementService.find(Integer.parseInt(page), 10, orderBy));
			model.addAttribute("customerQuantity", quantity);
		} else {
			quantity = customerManagementService.getConditionQuantity(account, userType, null);
			model.addAttribute("customerList", customerManagementService.findByCondition(account, userType, null, Integer.parseInt(page), 10, orderBy));
			model.addAttribute("customerQuantity", customerManagementService.getConditionQuantity(account, userType, null));
		}
		
		if((quantity%10) == 0) {
			model.addAttribute("pageQuantity", quantity/10);
		} else {
			model.addAttribute("pageQuantity", quantity/10+1);
		}

	//依照執行結果挑選適當的View元件
		return "member_managment_list";
	}
	
	@RequestMapping(
			value=("CustomerManagementView.controller"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String view(Model model, String id) {
		model.addAttribute("customerData", customerManagementService.findById(Integer.parseInt(id)));
		return "member_managment_view";
	}
	
	@RequestMapping(
			value=("CustomerManagementEdit.controller"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String edit(Model model, String id) {
		model.addAttribute("customerData", customerManagementService.findById(Integer.parseInt(id)));
		return "member_managment_edit";
	}
	
}
