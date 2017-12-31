package webservice;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import model.bean.CustomerBean;
import model.bean.CustomerServiceBean;
import model.bean.SellerBackstageManageBean;
import model.service.CustomerManagementService;
import model.service.CustomerServiceAuditService;
import model.service.SellerBackstageManageService;
import model.utils.PrimitiveNumberEditor;  

@RestController
@RequestMapping("/audit")
public class AuditComplaintsWebService {
	@Autowired
	CustomerServiceAuditService customerServiceAuditService;
	
	
	// 查詢目前客服申訴清單
	@RequestMapping(
			value="/complaints",
			method={RequestMethod.GET},
			produces={"application/json;charset=UTF-8"}
	)
	public String queryComplaintsList(String problemTypes, String processStatus, String customerID, int pageNumber, int pageSize) {

		System.out.println("problemTypes=>"+problemTypes);
		System.out.println("processStatus=>"+processStatus);
		System.out.println("customerID=>"+customerID);
		System.out.println("page=>"+pageNumber);
		System.out.println("rows=>"+pageSize);
		
		JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
		JSONArray array;						// 儲存List<CustomerServiceBean>的json物件
		int quantity;							// 回傳的資料筆數
		int pageQuantity;						// 總頁數
		
		

		// 檢查使用者輸入條件之情形，呼叫相對應方法
		if((customerID == null || "".equals(customerID.trim())) && (processStatus == "") && (problemTypes == "")){
			array = new JSONArray(customerServiceAuditService.find(pageNumber, pageSize));
			quantity = customerServiceAuditService.getQuantity();

		}else{
			array = new JSONArray(customerServiceAuditService.findByCondition(problemTypes, processStatus, customerID, pageNumber, pageSize));
			quantity = customerServiceAuditService.getConditionQuantity(customerID, processStatus, null);
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
