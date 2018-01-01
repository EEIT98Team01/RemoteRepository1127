package webservice;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import model.bean.ProductBean;
import model.bean.ProductSizeBean;
import model.service.ProductManagmentService;
import model.service.ProductSizeService;

@RestController
@RequestMapping("/product")
public class ProductManagmentWebService {
	@Autowired
	ProductManagmentService productManagmentService;
	@Autowired
	ProductSizeService ProductSizeService;
	@Autowired
	private ServletContext application;
	
	@RequestMapping(
			value="/addProduct",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String addProduct(MultipartFile productImage, String productName, String productSummary, String productClassfication,
			                 String productUnitPrice, String productStatus, String suitableAges, String genderPreference,
			                 String productContents, String productSpec, String productStock, 
			                 HttpServletRequest request,HttpServletResponse response, Model model) throws Exception {
		
		System.out.println("productImage==>"+productImage.getOriginalFilename());
		System.out.println("productName==>"+productName);
		System.out.println("productSummary==>"+productSummary);
		System.out.println("productClassfication==>"+productClassfication);
		System.out.println("productUnitPrice==>"+productUnitPrice);
		System.out.println("productStatus==>"+productStatus);
		System.out.println("suitableAges==>"+suitableAges);
		System.out.println("genderPreference==>"+genderPreference);
		System.out.println("productContents==>"+productContents);
		System.out.println("productSpec==>"+productSpec);
		System.out.println("productStock==>"+productStock);
		
		// 存放回傳給AJAX 的 response jsonObj
		JSONObject jsonObj = new JSONObject();

		// 設定商品各項資料
		ProductBean product = new ProductBean();
		product.setStoreID(1); // 暫時寫死為1,之後要拿到顧客資料,再拿他的商店ID
		product.setTitle(productName);
		product.setSummary(productSummary);
		product.setUnitPrice(Integer.parseInt(productUnitPrice));
		product.setProductDescription(productContents);
		if("1".equals(productStatus)) {
			product.setProductStatus(true);
		} else {
			product.setProductStatus(false);
		}
		product.setClassficationID(Integer.parseInt(productClassfication));
		product.setSuitableAges(Integer.parseInt(suitableAges));
		product.setGenderPreference(genderPreference);
		product.setDisplayTime(new java.util.Date());
		
		// 處理商品圖示,將檔案存到images資料夾,並將路徑寫到資料庫
		if(productImage.getOriginalFilename() != null || productImage.getOriginalFilename() != "" ){
	        // 建立一個存放圖片資料夾，資料匣名稱為images
			File uploadPath = new File(request.getServletContext().getRealPath("images"));  
	        // 如果資料匣不存在  
	        if (!uploadPath.exists()) {  
	            //创建資料夾
	            uploadPath.mkdir();  
	        }
			
	        // 獲取webapp所在路径  
	        String pathRoot = request.getSession().getServletContext().getRealPath("");
			
			// 設定productImage要儲存在哪的路徑
			String productImagePath="";  
			
			// 抓取原始文件名
		    String productImage_name = productImage.getOriginalFilename();
		    
		    // 獲取文件類型（可以判断如果不是图片，禁止上传）
		    String productImage_contentType = productImage.getContentType(); 
		    
		    // 設定 uuid作为文件的新檔名
		    String productImage_uuid = UUID.randomUUID().toString().replaceAll("-",""); 
		    
		    // 獲取文件附檔名
	        String imageName = productImage_contentType.substring(productImage_contentType.indexOf("/")+1);
	        productImagePath = "/images/" + productImage_uuid + "." + imageName; 
	        
	        // 轉存檔案在upload資料夾下面
	        productImage.transferTo(new File(pathRoot + productImagePath));
	        
	        // 設定圖檔完整路徑
	        product.setProductImage(pathRoot + productImagePath);
		}
		
		ProductBean insert = productManagmentService.insertProduct(product);

		// 處理規格表
		String[] spec = productSpec.split(",");
		String[] stock = productStock.split(",");
		
		for(int i = 0; i < spec.length; i++) {
			ProductSizeBean productSize = new ProductSizeBean();
			
			productSize.setProductID(insert.getProductID());
			productSize.setProductSpec(spec[i]);
			productSize.setSpecStock(Integer.parseInt(stock[i]));
			
			ProductSizeService.insert(productSize);
		}
		
		return jsonObj.toJSONString();
	}	
	
/*	
	public String searchProductData(String title, String pageSize, String pageNumber) {
		JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
		JSONArray array;						// 儲存List<CustomerBean>的json物件
		int quantity;							// 回傳的資料筆數
		int pageQuantity;						// 總頁數
		
		// 檢查使用者輸入條件之情形，呼叫相對應方法
		if( (title == null || "".equals(title.trim()))) {
			array = new JSONArray(productManagmentService.find(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), "ArticleID desc"));
			quantity = productManagmentService.getQuantity();
		} else {
			array = new JSONArray(productManagmentService.findByCondition(title, Integer.parseInt(pageNumber), Integer.parseInt(pageSize), "ArticleID desc"));
			quantity = productManagmentService.getConditionQuantity(title);
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
*/
	
}
