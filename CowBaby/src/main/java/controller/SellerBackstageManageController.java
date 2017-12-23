package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

import model.bean.SellerBackstageManageBean;

import model.service.SellerBackstageManageService;

@Controller
@RequestMapping("SellerBackstageManageController.controller")
public class SellerBackstageManageController {

	@Autowired
	SellerBackstageManageService sellerBackstageManageService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String method(MultipartFile storeLogo, MultipartFile storeBanner, String storeName, String storePhone,
			Boolean storeStatus, String storeDescription, HttpServletRequest request, Model model) throws SQLException, IOException {
	
		/***************************************************/
		//storeLogo 存【圖片】到資料庫
			System.out.println("開始");
			// 把 storeLogo 類型轉為  File 類型
		    File convFile = new File( storeLogo.getOriginalFilename());
		    storeLogo.transferTo(convFile);
		    // 把 storeLogo 類型轉為 BYTE[] 類型
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
	       
	      
	        try {
	        	// 轉存檔案在upload資料轄下面
				storeBanner.transferTo(new File(pathRoot+storeBannerPath));
				
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} 

	    	SellerBackstageManageBean bean = new SellerBackstageManageBean();

		
	         bean.setStoreLogo(new javax.sql.rowset.serial.SerialBlob(storeLogoImgByte));    
	         bean.setEmail("999@gmail.com");
			 bean.setStoreDescription(storeDescription); 
			 bean.setStoreName(storeName);
			 bean.setStorePhone(storePhone);
			 bean.setStoreStatus(storeStatus);
			 bean.setStoreBanner(pathRoot+storeBannerPath);
			 System.out.println("===========================");
			 System.out.println(bean);
			 
			 // call Service 新增儲存資料
			 sellerBackstageManageService.insertStoreData(bean);
			 
			 

	
		//
		// System.out.println("storeBanner =>"+ storeBanner);
		// System.out.println("storeLogo =>"+ storeLogo);
		// 儲存錯誤訊息
		// Map<String, String> errors = new HashMap<>();
		// model.addAttribute("errors", errors);
		//
		
		// System.out.println(bean);
		//

		// // 檢查商店名稱長度
		// if(storeName.length()>10){
		// System.out.println("商店名稱超過10個字");
		// }

		// SellerBackstageManageBean bean =
		// sellerBackstageManageService.insertStoreData(bean);

			 
		
			 
			 
			 
			 
		 // 從資料庫抓取LOGO圖片編碼(二進制)
		 SellerBackstageManageBean selectBean =
		 sellerBackstageManageService.getStoreData(1);
		 java.sql.Blob blobimg = selectBean.getStoreLogo();
		
		 try {
		 // LOGO圖片編碼(二進制)->轉base64
		 byte[] img = Base64.getEncoder().encode(blobimg.getBytes(1, (int)
		 blobimg.length()));
		 // base64 ->轉字串顯示於畫面上
		 String logoImg = new String(img);
		 model.addAttribute("logoImg", logoImg);
		 
		 } catch (Exception e) {
		 e.printStackTrace();
		 }

		return "sellerShop";
	}

}
