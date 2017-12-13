package webservice;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public String getCustomerData() {
		JSONArray array = new JSONArray(customerManagementService.find(1, 10, "CustomerID"));
		return array.toString();
	}
}
