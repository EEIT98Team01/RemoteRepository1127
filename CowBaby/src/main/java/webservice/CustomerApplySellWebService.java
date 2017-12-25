package webservice;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import model.bean.BackstageBean;
import model.dao.BackstageDao;
import model.service.CustomerApplySellerService;
import model.service.CustomerManagementService;
import model.service.CustomerServiceAuditService;

@RestController
@RequestMapping("/SellerAudit")
public class CustomerApplySellWebService {
	
	@Autowired
	CustomerApplySellerService customerApplySellerService;

	// 取得申請筆數
	@RequestMapping(
			value="/getSellerAuditData",
			method={RequestMethod.GET},
			produces={"application/json;charset=UTF-8"}
	)
	public String getSellerAuditData(String email, String processStatus, String pageSize, String pageNumber) {
		JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
		JSONArray array;						// 儲存List<CustomerBean>的json物件
		int quantity;							// 回傳的資料筆數
		int pageQuantity;						// 總頁數
		
		
		System.out.println("email"+email);
		System.out.println("processStatus"+processStatus);
		System.out.println("pageSize"+pageSize);
		System.out.println("pageNumber"+pageNumber);

		if( (email == null || "".equals(email.trim())) && (processStatus == null || "".equals(processStatus.trim()))) {
			;
			array = new JSONArray(customerApplySellerService.find(Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
			quantity = customerApplySellerService.getQuantity();
		} else {
			
			array = new JSONArray(customerApplySellerService.findByCondition(email, processStatus,Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
			quantity = customerApplySellerService.getConditionQuantity(email, processStatus);
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
	
	
	// 取得申請筆數
	@RequestMapping(
			value="/updateSellerAuditStatus",
			method={RequestMethod.GET},
			produces={"application/json;charset=UTF-8"}
	)
	public String updateSellerAuditStatus(int applicationID,String email,String applicationDescription,int processStatus) {
		JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
		JSONArray array;						// 儲存List<CustomerBean>的json物件
		int quantity;							// 回傳的資料筆數
		int pageQuantity;						// 總頁數
		
		System.out.println("applicationID-->"+applicationID);
		System.out.println("email-->"+email);
		System.out.println("applicationDescription-->"+applicationDescription);
		System.out.println("processStatus-->"+processStatus);
		
		BackstageBean bean = customerApplySellerService.findById(applicationID);
		System.out.println("bean-->"+bean.toString());

		if(bean.getApplicationState() != processStatus){
			 bean.setApplicationState(processStatus);
			 bean.setApplicationDescription(applicationDescription);
		     customerApplySellerService.update(bean);    
		}

		// 將回傳資料塞入json物件
		
		jsonObj.put("auditStatus","OK");
	
		return jsonObj.toString();
	}

	
	
}
