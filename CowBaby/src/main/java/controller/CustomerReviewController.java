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

@Controller
public class CustomerReviewController {

	@Autowired
	CustomerServiceAuditService customerServiceAuditService;

	@RequestMapping(value = ("CustomerReview.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String review(Model model, String email, String processStatus, String problemTypes) {
		System.out.println(email);
		System.out.println(processStatus);
		System.out.println(problemTypes);

		if ("全部".equals(processStatus)) {
			processStatus = "1";
		} else if ("未處理".equals(processStatus)) {
			processStatus = "2";
		} else if ("處理中".equals(processStatus)) {
			processStatus = "3";
		} else if ("已處理".equals(processStatus)) {
			processStatus = "4";
		}

		if ("全部".equals(problemTypes)) {
			problemTypes = "1";
		} else if ("檢舉黑名單".equals(problemTypes)) {
			problemTypes = "2";
		} else if ("帳號問題".equals(problemTypes)) {
			problemTypes = "3";
		} else if ("BUG回報".equals(problemTypes)) {
			problemTypes = "4";
		} else if ("其他".equals(problemTypes)) {
			problemTypes = "5";
		}

		if ("".equals(email)) {
			email = null;
		}

		if (email == null || "".equals(email.trim()) && processStatus == null && problemTypes == null) {
			model.addAttribute("reviewList", customerServiceAuditService.find());
		} else {
			model.addAttribute("reviewList",
					customerServiceAuditService.findByReview(email, processStatus, problemTypes));
		}
		return "customer_review_success";
	}

	@RequestMapping(value = ("CustomerReviewUpdate.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String reviewupdate(Model model, int reportid, String processStatus) {
		System.out.println(reportid);
		System.out.println(processStatus);
		int status = -1;
		if ("未處理".equals(processStatus)) {
			status = 0;
		} else if ("處理中".equals(processStatus)) {
			status = 1;
		} else if ("已完成".equals(processStatus)) {
			status = 2;
		}
		if (processStatus == null || processStatus.trim().length() == 0) {
			return "customer_review_success";
		} else {
			Map<String, String> condition = new HashMap<String, String>();
			if (status != -1) {
				CustomerServiceBean aa = customerServiceAuditService.findById(reportid);
				aa.setProcessStatus(status);
				
				customerServiceAuditService.updateCustomerData(aa);
			}
		}
		return "customer_review_success";
	}
	
	@RequestMapping(value = ("CustomerReviewInsert.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String reviewupdateReply(Model model,int reportid, String serviceFeedback) {
		System.out.println(serviceFeedback);

		if ((serviceFeedback == null) || ("".equals(serviceFeedback.trim())))
		 {
			return "customer_review_success";
		} else {
			CustomerServiceBean bean = customerServiceAuditService.findById(reportid);
			bean.setServiceFeedback(serviceFeedback);
			
			customerServiceAuditService.updateCustomerData(bean);
			
//			CustomerServiceBean bean = new CustomerServiceBean();
//			bean.setServiceFeedback(serviceFeedback);
//			customerServiceAuditService.updateCustomerData(bean);
		}
		return "customer_review_success";
	}
}
