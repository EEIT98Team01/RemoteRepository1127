package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import model.bean.ClassficationBean;
import model.bean.CustomerBean;
import model.bean.CustomerServiceBean;
import model.service.CustomerManagementService;
import model.service.CustomerServiceAuditService;

@Controller
public class CustomerServiceAuditController {

	@Autowired
	CustomerManagementService customerManagementService;
	@Autowired
	CustomerServiceAuditService customerServiceAuditService;

	@RequestMapping(value = ("CustomerServiceAuditList.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	// 申請一筆客服資料
	public String insertCustomerServiceData(Model model, String email, int problemTypes, String problemDescription) {

		System.out.println(email);
		System.out.println(problemTypes);
		System.out.println(problemDescription);

		if ("帳號問題".equals(problemTypes)) {
			problemTypes = 1;
		} else if ("BUG問題".equals(problemTypes)) {
			problemTypes = 2;
		} else if ("黑名單檢舉".equals(problemTypes)) {
			problemTypes = 3;
		} else if ("其他".equals(problemTypes)) {
			problemTypes = 4;
		}
		
		if("".equals(email)) {
			email = null;
		}
		
		if("".equals(problemDescription)) {
			problemDescription = null;
		}

			Map<String, String> errors = new HashMap<>();
			model.addAttribute("errors", errors);
			
			if (email == null || email.trim().length() == 0) {
				errors.put("email", "請輸入帳號");
			}
			if (problemDescription == null || problemDescription.trim().length() == 0) {
				errors.put("problemDescription", "請輸入內容");
			}

			if (errors != null && !errors.isEmpty()) {
				return "customer_service_error";
			}
		
			CustomerServiceBean bean = new CustomerServiceBean();
			bean.setEmail(email);
			bean.setProblemTypes(problemTypes);
			bean.setProblemDescription(problemDescription);
			bean.setReportTime(new java.util.Date());
			customerServiceAuditService.insertStoreData(bean);
			
			return "customer_service_success";
	}
}
