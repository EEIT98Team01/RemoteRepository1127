package webservice;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import model.bean.CustomerBean;
import model.bean.SellerBackstageManageBean;
import model.service.Order01Service;
import model.service.SellerBackstageManageService;
import model.utils.PrimitiveNumberEditor;  

@RestController
@RequestMapping("/order")
public class Order01ListWebService {
	@Autowired
	Order01Service order01Service;
	@Autowired
	private HttpSession session;
	@Autowired
	private SellerBackstageManageService sellerBackstageManageService;

	// FormBean客製化
	@InitBinder
	public void initialize(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		
		webDataBinder.registerCustomEditor(int.class,
				new PrimitiveNumberEditor(java.lang.Integer.class, true));
	}
	
	// 取得會員資料
	@RequestMapping(
			value="/getOrderData",
			method={RequestMethod.GET},
			produces={"application/json;charset=UTF-8"}
	)
	public String getOrderData(String orderID, String pageSize, String status, String pageNumber, String startTime, String endTime) {
		JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
		JSONArray array;						// 儲存List<CustomerBean>的json物件
		int quantity;							// 回傳的資料筆數
		int pageQuantity;						// 總頁數
		
		System.out.println("orderID==>"+orderID);
		System.out.println("pageSize==>"+pageSize);
		System.out.println("status==>"+status);
		System.out.println("pageNumber==>"+pageNumber);
		System.out.println("startTime==>"+startTime);
		System.out.println("endTime==>"+endTime);
		
		// 取得當前使用者帳號及商店資料
		 CustomerBean user = (CustomerBean)session.getAttribute("user");
		 List<SellerBackstageManageBean> temp = sellerBackstageManageService.findStore(user.getEmail(), 1, 999, "storeID");
		 int storeID = temp.get(0).getStoreID();
		
		// 檢查使用者輸入條件之情形，呼叫相對應方法
		if( (orderID == null || "".equals(orderID.trim())) && 
			(status == null || "".equals(status.trim())) && 
			( (startTime == null || "".equals(startTime.trim())) || (endTime == null || "".equals(endTime.trim())) )
		  ) {
//			array = new JSONArray(order01Service.find(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), "orderID desc"));
//			quantity = order01Service.getQuantity();
			
			array = new JSONArray(order01Service.findByCondition(null, storeID+"", null, null, null, Integer.parseInt(pageNumber), Integer.parseInt(pageSize),"orderID desc"));
			quantity = order01Service.getConditionQuantity(null, storeID+"", null, null, null);
		
		} else {
			array = new JSONArray(order01Service.findByCondition(orderID, storeID+"", status, startTime, endTime, Integer.parseInt(pageNumber), Integer.parseInt(pageSize),"orderID desc"));
			quantity = order01Service.getConditionQuantity(orderID, storeID+"", status, startTime, endTime);
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
	
/*
	// 更新Order資料
	@RequestMapping(
			value="/orderDataUpdate",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String blogDataUpdate(Order01Bean bean, BindingResult bindingResult) {
		System.out.println(bean.get());
		System.out.println(bean.getArticleHeader());
		System.out.println(bean.getArticleID());
		System.out.println(bean.getBloggerName());
		System.out.println(bean.getArticlePhoto());

		bean.setArticlePhoto(((BlogBean) blogService.findById(bean.getArticleID())).getArticlePhoto() );

		if(blogService.updateBlogData(bean)) {
			return "{\"status\":\"updateOK\"}";
		} else {
			return "{\"status\":\"updateError\"}";
		}
	}
*/	
}
