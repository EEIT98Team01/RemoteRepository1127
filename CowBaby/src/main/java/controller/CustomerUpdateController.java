package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.CustomerBean;
import model.service.CustomerManagementService;

@Controller
public class CustomerUpdateController {

	@Autowired
	CustomerManagementService customerupdate;

	@RequestMapping(value = ("CustomerUpdate.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String reviewupdate(Model model, int customerID, String password, String checkPassword, String landline,
			String mobilePhone, String address, String income, boolean subscription) {
		System.out.println(customerID);
		System.out.println(password);
		System.out.println(checkPassword);
		System.out.println(landline);
		System.out.println(mobilePhone);
		System.out.println(address);
		
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		
		if (password == null || password.trim().length() == 0) {
			errors.put("password", "密碼不能為空白");
		}
		if (checkPassword == null || checkPassword.trim().length() == 0) {
			errors.put("checkPassword", "確認密碼不能為空白");
		}

		if (errors != null && !errors.isEmpty()) {
			return "customer_Update";
		}
		
		if("".equals(income.trim())){
			income=null;
		}
		if (password == null || "".equals(password.trim()) && (checkPassword == null
				|| "".equals(checkPassword.trim()) && (password == null || "".equals(password.trim())
						&& (landline == null || "".equals(landline.trim()) && (mobilePhone == null
								|| "".equals(mobilePhone.trim()) && (address == null || "".equals(address.trim())
										)))))) {
			System.out.println("111");
			return "customer_Update";
		} else {
			System.out.println("222");
			CustomerBean bean = customerupdate.getStoreData(customerID);
			bean.setPassword(password);
			bean.setLandline(landline);
			bean.setMobilePhone(mobilePhone);
			bean.setAddress(address);
			// bean.setIncome(Integer.parseInt(income));
			bean.setSubscription(subscription);
			customerupdate.updateCustomerData(bean);
		}

		return "customer_Update";
	}
}