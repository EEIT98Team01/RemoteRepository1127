package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.service.CustomerManagementService;

@Controller
public class CustomerServiceAuditController {
	
	@Autowired
	CustomerManagementService customerManagementService;
	
	@RequestMapping(
			value=("CustomerServiceAuditList.controller"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String list(Model model) {
	//讀取使用者輸入資料
	//進行必要的資料型態轉換
	//進行資料檢查
	//進行商業服務
	//依照執行結果挑選適當的View元件
		return "";
	}
	
	@RequestMapping(
			value=("CustomerServiceAuditView.controller"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String view(Model model, String id) {
		
		return "";
	}
	
	@RequestMapping(
			value=("CustomerServiceAuditEdit.controller"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String edit(Model model, String id) {

		return "";
	}
}
