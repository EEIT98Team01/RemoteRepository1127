package webservice;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import model.service.CustomerServiceAuditService;

@RestController
@RequestMapping("/webservice")
public class CustomerReviewWebService {
	
	@Autowired
	CustomerServiceAuditService customerServiceAuditService;
	
	
		// 取得申訴資料
		@RequestMapping(
				value="/getCustomerReview",
				method={RequestMethod.GET},
				produces={"application/json;charset=UTF-8"}
		)
		public String getCustomerData(String email, String pageSize, String processStatus, String pageNumber,String problemTypes) {
			System.out.println(email);
			System.out.println(processStatus);
			System.out.println(problemTypes);
			
			JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
			JSONArray array;						// 儲存List<CustomerBean>的json物件
			int quantity;							// 回傳的資料筆數
			int pageQuantity;						// 總頁數
			
			// 檢查使用者輸入條件之情形，呼叫相對應方法
			if( (email == null || "".equals(email.trim())) && (processStatus == null || "".equals(processStatus.trim()) && problemTypes == null)) {
				array = new JSONArray(customerServiceAuditService.find(Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
				quantity = customerServiceAuditService.getQuantity();
			} else {
				array = new JSONArray(customerServiceAuditService.findByCondition(email, processStatus, problemTypes, Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
				quantity = customerServiceAuditService.getConditionQuantity(email, processStatus, problemTypes);
			}
			
			// 計算總頁數
			if((quantity%10) == 0) {
				pageQuantity = quantity/10;
			} else {
				pageQuantity = quantity/10+1;
			}

			// 將回傳資料塞入json物件
			jsonObj.put("tatal", quantity); 
			jsonObj.put("tatalPage", pageQuantity); 
			jsonObj.put("pageNumber", pageNumber);
			jsonObj.put("pageSize", pageSize); 
			jsonObj.put("list", array.toString()); 

			return jsonObj.toString();
		}
}
