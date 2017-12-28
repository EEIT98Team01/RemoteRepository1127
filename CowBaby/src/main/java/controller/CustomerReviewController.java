package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.service.CustomerServiceAuditService;

@Controller
public class CustomerReviewController {
	
	@Autowired
	CustomerServiceAuditService customerServiceAuditService;
	
	@RequestMapping(value = ("CustomerReview.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String review(Model model, String email, String processStatus, String problemTypes){
		System.out.println(email);
		System.out.println(processStatus);
		System.out.println(problemTypes);
		
		if ("全部".equals(processStatus)) {
			problemTypes = "1";
		} else if ("未處理".equals(processStatus)) {
			problemTypes = "2";
		} else if ("處理中".equals(processStatus)) {
			problemTypes = "3";
		} else if ("已處理".equals(processStatus)) {
			problemTypes = "4";
		}
		
		if ("全部".equals(problemTypes)) {
			problemTypes = "1";
		} else if ("檢舉黑名單".equals(problemTypes)) {
			problemTypes = "2";
		} else if ("帳號問題".equals(problemTypes)) {
			problemTypes = "3";
		} else if ("BUG回報".equals(problemTypes)) {
			problemTypes = "4";
		}else if ("其他".equals(problemTypes)) {
			problemTypes = "5";
		}
		
		if("".equals(email)) {
			email = null;
		}
		
		if(email == null || "".equals(email.trim()) && 
				processStatus == null && problemTypes == null	){
			model.addAttribute("reviewList", customerServiceAuditService.find());
		}else{
			model.addAttribute("reviewList", customerServiceAuditService.findByCondition(email,problemTypes,processStatus));
		}
		return "customer_review_success";
	}
}
