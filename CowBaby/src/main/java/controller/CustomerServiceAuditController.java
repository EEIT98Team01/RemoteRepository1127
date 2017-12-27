package controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.CustomerServiceBean;
import model.service.CustomerManagementService;
import model.service.CustomerServiceAuditService;

@Controller
public class CustomerServiceAuditController {

	@Autowired
	CustomerManagementService customerManagementService;
	@Autowired
	CustomerServiceAuditService customerServiceAuditService;

	@RequestMapping(
			value=("CustomerServiceAuditList.controller"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	// 申請一筆客服資料
	public String insertCustomerServiceData(Model model, CustomerServiceBean customerServiceBean) {
		
		System.out.println("customerServiceBean"+customerServiceBean.toString());
		// 設定申請時間
	    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		customerServiceBean.setReportTime(timestamp);
	
		CustomerServiceBean bean= customerServiceAuditService.insertCustomerData(customerServiceBean);
	
		
		
		
		
	//讀取使用者輸入資料
	//進行必要的資料型態轉換
	//進行資料檢查
	//進行商業服務
	//依照執行結果挑選適當的View元件
		
		
		
		return "apple_seller_success";
	}

	@RequestMapping(value = ("CustomerServiceAuditView.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String view(Model model, String id) {

		return "";
	}

	@RequestMapping(value = ("CustomerServiceAuditEdit.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Model model, String id) {

		return "";
	}
}
