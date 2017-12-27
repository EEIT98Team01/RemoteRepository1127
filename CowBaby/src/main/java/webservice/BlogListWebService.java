package webservice;

import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import model.bean.BlogBean;
import model.service.BlogService;
import model.utils.PrimitiveNumberEditor;  

@RestController
@RequestMapping("/Blog")
public class BlogListWebService {
	@Autowired
	BlogService blogService;

	// FormBean客製化
	@InitBinder
	public void initialize(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		
		webDataBinder.registerCustomEditor(int.class,
				new PrimitiveNumberEditor(java.lang.Integer.class, true));
	}
	
	// 取得Blog資料
	@RequestMapping(
			value="/getBlogData",
			method={RequestMethod.GET},
			produces={"application/json;charset=UTF-8"}
	)
	public String getBlogData(String author, String pageSize, String article, String pageNumber) {
		JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
		JSONArray array;						// 儲存List<CustomerBean>的json物件
		int quantity;							// 回傳的資料筆數
		int pageQuantity;						// 總頁數
		
		// 檢查使用者輸入條件之情形，呼叫相對應方法
		if( (author == null || "".equals(author.trim())) && (article == null || "".equals(article.trim()))) {
			array = new JSONArray(blogService.find(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), "ArticleID desc"));
			quantity = blogService.getQuantity();
		} else {
			array = new JSONArray(blogService.findByCondition(author, article, Integer.parseInt(pageNumber), Integer.parseInt(pageSize), "ArticleID desc"));
			quantity = blogService.getConditionQuantity(author, article);
		}
		
		// 計算總頁數
		if((quantity%Integer.parseInt(pageSize)) == 0) {
			pageQuantity = quantity/Integer.parseInt(pageSize);
		} else {
			pageQuantity = quantity/Integer.parseInt(pageSize)+1;
		}

		// 將回傳資料塞入json物件
		jsonObj.put("tatal", quantity); 
		jsonObj.put("tatalPage", pageQuantity); 
		jsonObj.put("pageNumber", pageNumber);
		jsonObj.put("pageSize", pageSize); 
		jsonObj.put("list", array.toString()); 

		return jsonObj.toString();
	}
	
	// 更新會員資料
	@RequestMapping(
			value="/blogDataUpdate",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String blogDataUpdate(BlogBean bean, BindingResult bindingResult) {
		bean.setArticlePhoto(((BlogBean) blogService.findById(bean.getArticleID())).getArticlePhoto() );

		if(blogService.updateBlogData(bean)) {
			return "{\"status\":\"updateOK\"}";
		} else {
			return "{\"status\":\"updateError\"}";
		}
	}
}
