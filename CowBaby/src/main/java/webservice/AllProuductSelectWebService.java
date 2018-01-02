package webservice;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import model.bean.ProductBean;
import model.service.ClassficationService;
import model.service.ProductManagmentService;

@RestController
@RequestMapping("/prouducts")
public class AllProuductSelectWebService {
	@Autowired
	ClassficationService classficationService;

	@Autowired
	ProductManagmentService productManagmentService;

	// 查詢目前以勾選條件
	@RequestMapping(value = "/inquire", method = { RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public String allProuductsSelect(String productClassfication, String suitableAges, String genderPreference,
			int pageNumber, int pageSize) {
		System.out.println("=============================");
		System.out.println("productClassfication==>"+productClassfication);
		System.out.println("suitableAges==>"+suitableAges);
		System.out.println("genderPreference==>"+genderPreference);
		System.out.println("pageNumber==>"+pageNumber);
		System.out.println("pageSize==>"+pageSize);
		
		System.out.println("=============================");
		
		JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
		JSONArray array;						// 儲存List<ProductBean>的json物件
		int quantity;							// 回傳的資料筆數
		int pageQuantity;						// 總頁數

		
		List<ProductBean> productList = productManagmentService.findProduct(productClassfication,
				suitableAges, genderPreference, pageNumber, pageSize);
		
		System.out.println("***productList==>***"+productList);
		
		
		// 檢查使用者輸入條件之情形，呼叫相對應方法
		// 甚麼都沒填查全部
		if( (productClassfication == null || "".equals(productClassfication.trim())) && (suitableAges == null || "".equals(suitableAges.trim())) && (genderPreference == null || "".equals(genderPreference.trim()))) {
			array = new JSONArray(productManagmentService.findProduct(null, null, null, pageNumber, pageSize));
			quantity = productManagmentService.getQuantity(null, null, null, null, null, null);
		} else {
			array = new JSONArray(productManagmentService.findProduct(productClassfication,
					suitableAges, genderPreference, pageNumber, pageSize));
			quantity = productManagmentService.getQuantity(null, null, productClassfication, suitableAges, genderPreference, "1");
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
