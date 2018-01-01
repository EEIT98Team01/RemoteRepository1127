package webservice;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
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

import model.bean.ClassficationBean;
import model.bean.CustomerBean;
import model.bean.CustomerServiceBean;
import model.bean.SellerBackstageManageBean;
import model.service.ClassficationService;
import model.service.CustomerManagementService;
import model.service.CustomerServiceAuditService;
import model.service.SellerBackstageManageService;
import model.utils.PrimitiveNumberEditor;  

@RestController
@RequestMapping("/prouducts")
public class AllProuductSelectWebService {
	@Autowired
	ClassficationService classficationService;
	
	
	// 查詢目前以勾選條件
	@RequestMapping(
			value="/inquire",
			method={RequestMethod.GET},
			produces={"application/json;charset=UTF-8"}
	)
	public String allProuductsSelect(String[] classfication, int pageNumber, int pageSize) {
		List<Integer> classficationList = new LinkedList<Integer>();
		
		if(classfication[0].length() > 2) {
			String temp = classfication[0].replaceAll("\"", "");
			temp = temp.substring(1, temp.length()-1);
			for(String str: temp.split(",")) {
				classficationList.add(new Integer(str));
			}
		}
		
		
		System.out.println("classfication=>"+classficationList);
		System.out.println("page=>"+pageNumber);
		System.out.println("rows=>"+pageSize);
		System.out.println("-----------------------");
		

		
		//List<ClassficationBean> list = classficationService.findByCondition(classfication, pageNumber, pageSize);
		
		
		//System.out.println("list=>"+list);
		
		
	/*	
		
		
		JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
		JSONArray array;						// 儲存List<CustomerServiceBean>的json物件
		int quantity;							// 回傳的資料筆數
		int pageQuantity;						// 總頁數
		
		
		
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
		*/
		return null;

	}
}
