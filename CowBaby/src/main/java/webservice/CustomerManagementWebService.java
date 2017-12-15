package webservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import javax.xml.ws.Response;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import model.bean.CustomerBean;
import model.bean.SellerBackstageManageBean;
import model.service.CustomerManagementService;
import model.service.SellerBackstageManageService;
import com.alibaba.fastjson.JSONObject;  


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
//		
//		System.out.println("storeLogo==>"+storeLogo.getOriginalFilename());
//		System.out.println("storeBanner==>"+storeBanner);
//		System.out.println("storeName==>"+storeName);
//		System.out.println("storePhone==>"+storePhone);
//		System.out.println("storeStatus==>"+storeStatus);
//		System.out.println("storeDescription==>"+storeDescription);
		
		
		// 存放回傳給AJAX 的 response jsonObj
		   JSONObject jsonObj = new JSONObject();
		   byte[] storeLogoImg = null;
		   String storeBannerImg = null;
		  
		// 表單檢查
		// 1. 驗證 storeName長度
		   if(storeName.length()>10){
			    jsonObj.put("msg_error", "商店名稱不可超過10字");
				return jsonObj.toJSONString();
		   }
		// 2. 驗證 storePhone長度 只可為數字，且不可超過10字
		   if(storePhone.length()>10){
			    jsonObj.put("msg_error", "電話不可超過10字");
				return jsonObj.toJSONString();
		   }
		   
		// 3. 驗證 storeDescription長度 不可超過30字
		   if(storeDescription.length()>30){
			    jsonObj.put("msg_error", "商店描述不可超過30字");
				return jsonObj.toJSONString();
		   }
		   
	
		// 4. storeLogo檔案圖片檢查   
		   // 把 storeBanner 類型轉為  File 類型  
		   File convFile = new File( storeLogo.getOriginalFilename());
		   if(convFile.exists()){
			   System.out.println("COME1");
			   storeLogo.transferTo(convFile);
			    // 把 storeBanner 類型轉為 BYTE[] 類型
			    byte[] storeLogoImgByte = new byte[(int) convFile.length()];
			    FileInputStream fis = new FileInputStream(convFile);
				
			    fis.read(storeLogoImgByte);
			    fis.close();		    
			    storeLogoImg = storeLogoImgByte;  		
			}
		   
		
		// 5. storeBanner檔案圖片檢查	   
		 File convFile1 = new File( storeBanner.getOriginalFilename());    
		 if(convFile1.exists()){
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
			 }   
	         bean.setCustomerID(2);
			 bean.setStoreDescription(storeDescription); 
			 bean.setStoreName(storeName);
			 bean.setStorePhone(storePhone);
			 bean.setStoreStatus(storeStatus);
			 // 如果 storeLogoImg 圖片不是空的才寫入資料庫
			 if(storeLogoImg!=null){
				 bean.setStoreBanner(storeBannerImg);
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

	
	
	
	
	
	@RequestMapping(
			value="/getCustomerData",
			method={RequestMethod.GET},
			produces={"application/json;charset=UTF-8"}
	)
	public String getCustomerData(String customerAccount, String pageSize, String customerStatue, String pageNumber) {
		
		System.out.println("customerStatue-" + customerStatue.length() +"-123");
		
		if("".equals(customerAccount)) {
			customerAccount = null;
		}
		
		if("".equals(customerStatue)) {
			customerStatue = null;
		}
		
		JSONArray array;
		int quantity;
		if(customerAccount == null && customerStatue == null) {
			array = new JSONArray(customerManagementService.find(Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
			quantity = customerManagementService.getQuantity();
		} else {
			array = new JSONArray(customerManagementService.findByCondition(customerAccount, customerStatue, null, Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
			quantity = customerManagementService.getConditionQuantity(customerAccount, customerStatue, null);
		}
		
		int pageQuantity;
		
		if((quantity%10) == 0) {
			pageQuantity = quantity/10;
		} else {
			pageQuantity = quantity/10+1;
		}
		
		JSONObject jsonObj = new JSONObject(); 
		
		jsonObj.put("tatal", quantity); 
		jsonObj.put("tatalPage", pageQuantity); 
		jsonObj.put("pageNumber", pageNumber);
		jsonObj.put("pageSize", pageSize); 
		jsonObj.put("list", array.toString()); 
		
		System.out.println(jsonObj); 
		
		String result = jsonObj.toString();
		
		return result;

	}
}
