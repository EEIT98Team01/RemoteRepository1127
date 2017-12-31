package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.CustomerServiceBean;
import model.service.CustomerServiceAuditService;


public class CustomerUpdateController {
	
//	@Autowired
//	CustomerServiceAuditService customerupdate;
//	
//	@RequestMapping(value = ("CustomerUpdate.controller"), method = { RequestMethod.GET, RequestMethod.POST })
//	public String reviewupdate(Model model,int customerID, String password, String checkPassword,
//			String landline,String mobilePhone) {
//		System.out.println(password);
//		System.out.println(checkPassword);
//		System.out.println(landline);
//		System.out.println(mobilePhone);
//		
//		if ((password == null) || ("".equals(password.trim())) &&
//			(checkPassword == null) || ("".equals(checkPassword.trim())) &&
//			(landline == null) || ("".equals(landline.trim())) &&
//			(mobilePhone == null) || ("".equals(mobilePhone.trim()))
//		   ) {
//			model.addAttribute("ClassficationList", classficationService.find());
//		} else {
//			model.addAttribute("ClassficationList", classficationService.findByCondition(classficatoinName));
//		}
//		return "product_managment_view";
//	}
//		
//		if ("未處理".equals(processStatus)) {
//			processStatus = 1;
//		} else if ("處理中".equals(processStatus)) {
//			processStatus = 2;
//		} else if ("已完成".equals(processStatus)) {
//			processStatus = 3;
//		}
//		System.out.println(processStatus);
//
//		if ((processStatus == -1) )
//		 {
//			return "";
//		} else {
//			Map<String,String> condition = new HashMap<String,String>();
//			if(processStatus != -1){
//			CustomerServiceBean aa = customerupdate.findById(customerID);
//			aa.setProcessStatus(processStatus);
//			}
//		}
//		return "";
//	}
}
