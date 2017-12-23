package webservice;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
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
import model.bean.SellerBackstageManageBean;
import model.service.CustomerManagementService;
import model.service.SellerBackstageManageService;
import model.utils.PrimitiveNumberEditor;  

@RestController
@RequestMapping("/service")
public class CustomerManagementWebService {
	@Autowired
	CustomerManagementService customerManagementService;
	@Autowired
	SellerBackstageManageService sellerBackstageManageService;
	

	@RequestMapping(
			value="/qoo",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String qoogood(MultipartFile storeLogo, MultipartFile storeBanner, String storeName, String storePhone,
			Boolean storeStatus, String storeDescription, HttpServletRequest request,HttpServletResponse response, Model model) throws Exception {
		
		System.out.println("storeLogo==>"+storeLogo.getOriginalFilename());
		System.out.println("storeBanner==>"+storeBanner);
		System.out.println("storeName==>"+storeName);
		System.out.println("storePhone==>"+storePhone);
		System.out.println("storeStatus==>"+storeStatus);
		System.out.println("storeDescription==>"+storeDescription);
		
		
		// 存放回傳給AJAX 的 response jsonObj
		   JSONObject jsonObj = new JSONObject();
		   byte[] storeLogoImg = null;
		   String storeBannerImg = null;
		  
		// 表單檢查
//		// 1. 驗證 storeName長度
//		   if(storeName.length()>10){
//			    jsonObj.put("msg_error", "商店名稱不可超過10字");
//				return jsonObj.toJSONString();
//		   }
//		// 2. 驗證 storePhone長度 只可為數字，且不可超過10字
//		   if(storePhone.length()>10){
//			    jsonObj.put("msg_error", "電話不可超過10字");
//				return jsonObj.toJSONString();
//		   }
//		   
//		// 3. 驗證 storeDescription長度 不可超過30字
//		   if(storeDescription.length()>30){
//			    jsonObj.put("msg_error", "商店描述不可超過30字");
//				return jsonObj.toJSONString();
//		   }
		   
	
		// 4. storeLogo檔案圖片檢查   
		   // 把 storeBanner 類型轉為  File 類型  
		  
		   if(storeLogo.getOriginalFilename() != null || storeLogo.getOriginalFilename() !=""){
			   System.out.println("COME1");
			   File convFile = new File( storeLogo.getOriginalFilename());
			   storeLogo.transferTo(convFile);
			    // 把 storeBanner 類型轉為 BYTE[] 類型
			    byte[] storeLogoImgByte = new byte[(int) convFile.length()];
			    FileInputStream fis = new FileInputStream(convFile);
				
			    fis.read(storeLogoImgByte);
			    fis.close();		    
			    storeLogoImg = storeLogoImgByte;  		
			}
		   
		
		// 5. storeBanner檔案圖片檢查	   
		
		 if(storeBanner.getOriginalFilename() != null || storeBanner.getOriginalFilename() != "" ){
			 System.out.println("COME2");
			 
			//storeBanner 存【路徑】到資料庫
	        // 建立一個存放圖片資料夾，資料匣名稱為upload
	        File uploadPath = new File(request.getServletContext().getRealPath("upload"));  
	        System.out.println("uploadPath=====" + uploadPath);  
	        // 如果資料匣不存在  
	        if (!uploadPath.exists()) {  
	            //创建資料夾
	            uploadPath.mkdir();  
	        }    
			
	        // 獲取webapp所在路径  
	        String pathRoot = request.getSession().getServletContext().getRealPath("");
			
			// 設定storeBanner要儲存在哪的路徑
			String storeBannerPath="";  
			
			// 抓取原始文件名
		    String storeBanner_name = storeBanner.getOriginalFilename();
		    System.out.println("storeBanner_name=>"+storeBanner_name);
		    
		    // 獲取文件類型（可以判断如果不是图片，禁止上传）
		    String storeBanner_contentType=storeBanner.getContentType(); 
		    System.out.println("storeBanner_contentType=>"+storeBanner_contentType);
		    
		    // 設定 uuid作为文件的新檔名
		    String storeBanner_uuid = UUID.randomUUID().toString().replaceAll("-",""); 
		    
		    // 獲取文件附檔名
	        String imageName=storeBanner_contentType.substring(storeBanner_contentType.indexOf("/")+1);
	        storeBannerPath="/upload/"+storeBanner_uuid+"." +imageName; 
	        
	        // 轉存檔案在upload資料夾下面
	        storeBanner.transferTo(new File(pathRoot+storeBannerPath));
	        
	        // storeBanner 完整路徑
	        storeBannerImg = pathRoot+storeBannerPath;
		 }
		 	
       
        try {
			 // 把資料寫入 SellerBackstageManageBean
			 SellerBackstageManageBean bean = new SellerBackstageManageBean();
			 // 如果 storeLogoImg 圖片不是空的才寫入資料庫
			 if(storeLogoImg!=null){
				 bean.setStoreLogo(new javax.sql.rowset.serial.SerialBlob(storeLogoImg));   
			 } else{
				 bean.setStoreLogo(null);   
			 }  
	         bean.setEmail("999@gmail.com");
			 bean.setStoreDescription(storeDescription); 
			 bean.setStoreName(storeName);
			 bean.setStorePhone(storePhone);
			 bean.setStoreStatus(storeStatus);
			 // 如果 storeLogoImg 圖片不是空的才寫入資料庫
			 if(storeLogoImg!=null){
				 bean.setStoreBanner(storeBannerImg);
			 }else{
				 bean.setStoreBanner(null);
			 }
			 
			 System.out.println("===========================");
			 System.out.println(bean);
			 
			 // 新增儲存資料
			 sellerBackstageManageService.insertStoreData(bean);
			 jsonObj.put("msg_success", "success"); 
					 
		} catch (IllegalStateException e) {
			 jsonObj.put("msg_error", "error"); 
			 e.printStackTrace();
		} 
      
		return jsonObj.toJSONString();
	}

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
			value="/getCustomerData",
			method={RequestMethod.GET},
			produces={"application/json;charset=UTF-8"}
	)
	public String getCustomerData(String customerAccount, String pageSize, String customerStatue, String pageNumber) {
		JSONObject jsonObj = new JSONObject();	// json物件,儲存欲回傳資料
		JSONArray array;						// 儲存List<CustomerBean>的json物件
		int quantity;							// 回傳的資料筆數
		int pageQuantity;						// 總頁數
		
		// 檢查使用者輸入條件之情形，呼叫相對應方法
		if( (customerAccount == null || "".equals(customerAccount.trim())) && (customerStatue == null || "".equals(customerStatue.trim()))) {
			array = new JSONArray(customerManagementService.find(Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
			quantity = customerManagementService.getQuantity();
		} else {
			array = new JSONArray(customerManagementService.findByCondition(customerAccount, customerStatue, null, Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
			quantity = customerManagementService.getConditionQuantity(customerAccount, customerStatue, null);
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
	
	// 更新會員資料
	@RequestMapping(
			value="/cutomerDataUpdate",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String cutomerDataUpdate(CustomerBean bean, BindingResult bindingResult) {
		bean.setLoginPhoto( (customerManagementService.findById(bean.getCustomerID())).getLoginPhoto() );

		if(customerManagementService.updateCustomerData(bean)) {
			return "{\"status\":\"updateOK\"}";
		} else {
			return "{\"status\":\"updateError\"}";
		}
	}
}
