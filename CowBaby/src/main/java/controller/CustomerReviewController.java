package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.CustomerServiceBean;
import model.bean.OrderDetailBean;
import model.service.CustomerServiceAuditService;
import model.service.MessageService;

@Controller
public class CustomerReviewController {

	@Autowired
	CustomerServiceAuditService customerServiceAuditService;
	
	@Autowired
	MessageService messageService;

	@RequestMapping(value = ("CustomerReview.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String review(Model model, String email, String processStatus, String problemTypes) {
		System.out.println(email);
		System.out.println(processStatus);
		System.out.println(problemTypes);

		if ("".equals(email)) {
			email = null;
		}

		if ( (email == null || "".equals(email.trim())) && 
			  "0".equals(processStatus) && 
			  "0".equals(problemTypes)) {
			model.addAttribute("reviewList", customerServiceAuditService.find());
		} else {
			List<CustomerServiceBean> customerDetailListTemp = customerServiceAuditService.findByCondition(email, Integer.parseInt(problemTypes), Integer.parseInt(processStatus));
			
			model.addAttribute("reviewList", customerDetailListTemp);
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
			messageService.sendMessage("admini@gmail.com", bean.getEmail(), "親愛的會員您好，相關人員已回覆您，建議您可至訊息中心內查看，謝謝。");
			
//			CustomerServiceBean bean = new CustomerServiceBean();
//			bean.setServiceFeedback(serviceFeedback);
//			customerServiceAuditService.updateCustomerData(bean);
		}
		return "customer_review_success";
	}
}
