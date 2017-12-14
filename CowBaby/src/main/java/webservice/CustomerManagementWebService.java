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

	public String getCustomerData(String customerAccount, String pageSize, String customerStatue, String pageNumber) {
		if("null".equals(customerAccount)) {
			customerAccount = null;
		}
		
		JSONArray array = new JSONArray(customerManagementService.findByCondition(customerAccount, customerStatue, null, Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
		int quantity = customerManagementService.getConditionQuantity(customerAccount, customerStatue, null);
		int pageQuantity;
		
		if((quantity%10) == 0) {
			pageQuantity = quantity/10;
		} else {
			pageQuantity = quantity/10+1;
		}
		
		String result = "[\"tatal\":\"" + quantity + "\"," +
				        "\"tatalPage\":\"" + pageQuantity + "\"," +
		                "\"pageNumber\":\"" + pageNumber + "\"," +
		                "\"pageSize\":\"" + pageSize + "\"," +
		                "\"list\":\"" + array.toString() + "\"]";
		return result;
	}
}
