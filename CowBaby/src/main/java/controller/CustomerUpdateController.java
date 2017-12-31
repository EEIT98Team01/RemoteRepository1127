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
	public String reviewupdate(Model model, CustomerBean customerBean,String password, String checkPassword ,String email
							   ,String landline,String mobilePhone,String address) {

		System.out.println("customerBean" + customerBean.toString());
		System.out.println("checkPassword" + checkPassword);

		// 錯誤訊息
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		
		if (errors != null && !errors.isEmpty()) {
			return "customer_Update";
		}
		
		CustomerBean beanaupdate =new CustomerBean();
		beanaupdate.setPassword(password);
		beanaupdate.setLandline(landline);
		beanaupdate.setMobilePhone(mobilePhone);
		beanaupdate.setAddress(address);
		
		customerupdate.updateCustomerData(beanaupdate);
		
		return "customer_Update";
	}
}