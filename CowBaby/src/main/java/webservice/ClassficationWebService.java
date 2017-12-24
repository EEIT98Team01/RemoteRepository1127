package webservice;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import model.service.ClassficationService;

@RestController
@RequestMapping
public class ClassficationWebService {
	 
	 @Autowired
	 ClassficationService classficationService;
	 
	 public String getClassficationData(String toys, String books, String clothes, String shoes,String groceries) {
			JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
			JSONArray array;						// 儲存List<CustomerBean>的json物件
			int quantity;							// 回傳的資料筆數
			int pageQuantity;						// 總頁數
			
			// 檢查使用者輸入條件之情形，呼叫相對應方法
//			if( (toys == null || "".equals(toys.trim())) && (books == null || "".equals(books.trim()))
//					&& (clothes == null || "".equals(clothes.trim()))&& (shoes == null || "".equals(shoes.trim()))
//					&& (groceries == null || "".equals(groceries.trim()))) {
//				array = new JSONArray(classficationService.find(Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
//				quantity = classficationService.getStoreData(classficationID);
//			} else {
//				array = new JSONArray(classficationService.findByCondition(customerAccount, customerStatue, null, Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
//				quantity = classficationService.getConditionQuantity(customerAccount, customerStatue, null);
//			}
			
			// 計算總頁數
//			if((quantity%10) == 0) {
//				pageQuantity = quantity/10;
//			} else {
//				pageQuantity = quantity/10+1;
//			}
//
//			// 將回傳資料塞入json物件
//			jsonObj.put("tatal", quantity); 
//			jsonObj.put("tatalPage", pageQuantity); 
//			jsonObj.put("pageNumber", pageNumber);
//			jsonObj.put("pageSize", pageSize); 
//			jsonObj.put("list", array.toString()); 

			return jsonObj.toString();
		}
}
