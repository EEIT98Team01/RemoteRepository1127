package webservice;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.bean.CustomerBean;
import model.service.CustomerManagementService;

@RestController
@RequestMapping("/service")
public class CustomerManagementWebService {
	@Autowired
	CustomerManagementService customerManagementService;
	
	@RequestMapping(
			value="/getCustomerData",
			method={RequestMethod.GET, RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	@ResponseBody
	public List<CustomerBean> getCustomerData() {
		System.out.println("AAAAA");
		return customerManagementService.find(1, 10, "CustomerID");
	}
}
