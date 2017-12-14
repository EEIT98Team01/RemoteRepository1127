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

import model.bean.CustomerBean;
import model.bean.SellerBackstageManageBean;
import model.service.CustomerManagementService;
import model.service.SellerBackstageManageService;

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
		System.out.println("bb");
		System.out.println("storeLogo==>"+storeLogo);
		System.out.println("storeBanner==>"+storeBanner);
		System.out.println("storeName==>"+storeName);
		System.out.println("storePhone==>"+storePhone);
		System.out.println("storeStatus==>"+storeStatus);
		System.out.println("storeDescription==>"+storeDescription);
		
		

		/***************************************************/
		System.out.println("開始");
			// 把 storeBanner 類型轉為  File 類型
		    File convFile = new File( storeLogo.getOriginalFilename());
		    storeLogo.transferTo(convFile);
		    // 把 storeBanner 類型轉為 BYTE[] 類型
		    byte[] storeLogoImgByte = new byte[(int) convFile.length()];
		    FileInputStream fis = new FileInputStream(convFile);
			
		    fis.read(storeLogoImgByte);
		    fis.close();
		   		
		/***************************************************/
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
	       
	       String result="";
	       
	        try {
	        	 // 轉存檔案在upload資料轄下面
	        	
				 storeBanner.transferTo(new File(pathRoot+storeBannerPath));
				 SellerBackstageManageBean bean = new SellerBackstageManageBean();
		         bean.setStoreLogo(new javax.sql.rowset.serial.SerialBlob(storeLogoImgByte));    
		         bean.setCustomerID(2);
				 bean.setStoreDescription(storeDescription); 
				 bean.setStoreName(storeName);
				 bean.setStorePhone(storePhone);
				 bean.setStoreStatus(storeStatus);
				 bean.setStoreBanner(pathRoot+storeBannerPath);
				 System.out.println("===========================");
				 System.out.println(bean);
				 
				 // call Service 新增儲存資料
				 sellerBackstageManageService.insertStoreData(bean);
				 result="儲存成功!";
						 
			} catch (IllegalStateException e) {
				 result="資料錯誤!";
				//e.printStackTrace();
			} catch (IOException e) {
				 result="資料錯誤!";
				//e.printStackTrace();
			} 

		return result;
	}

	public String getCustomerData(String customerAccount, String pageSize, String customerStatue, String pageNumber) {
		if("null".equals(customerAccount)) {
			customerAccount = null;
		}
		
		JSONArray array = new JSONArray(customerManagementService.findByCondition(customerAccount, customerStatue, null, Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
		int quantity = customerManagementService.getConditionQuantity(customerAccount, customerStatue, null);
		int pageQuantity;
		
		if((quantity%10) == 0) {
			pageQuantity = quantity/10;
		} else {
			pageQuantity = quantity/10+1;
		}
		
		String result = "[\"tatal\":\"" + quantity + "\"," +
				        "\"tatalPage\":\"" + pageQuantity + "\"," +
		                "\"pageNumber\":\"" + pageNumber + "\"," +
		                "\"pageSize\":\"" + pageSize + "\"," +
		                "\"list\":\"" + array.toString() + "\"]";
		return result;

	}
}
