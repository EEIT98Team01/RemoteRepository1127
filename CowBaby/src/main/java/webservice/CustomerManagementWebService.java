package webservice;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	private CustomerManagementService customerManagementService;
	@Autowired
	private SellerBackstageManageService sellerBackstageManageService;
	@Autowired
	private ServletContext application;
	@Autowired
	private HttpSession session;
	

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
		   String name = "";
		   if(storeBanner != null) {
			   name = storeBanner.getOriginalFilename();			// 取得來源端檔案名稱
			   String mimeType = application.getMimeType(name);	// 取得副檔名
				
			   // 由副檔名檢查使用者上傳檔案是否為圖檔
			   String expandedName = "";
			   if (mimeType.equals("image/jpeg")) {
				   expandedName = ".jpg";
			   } else if (mimeType.equals("image/png")) {
				   expandedName = ".png";
			   } else if (mimeType.equals("image/gif")) {
				   expandedName = ".gif";
			   } else if (mimeType.equals("image/bmp")) {
				   expandedName = ".bmp";
			   } else {
				   System.out.println("文件格式不正確必須為.jpg/.gif/.bmp/.png文件");
			   }
				
			   // 取得UUID字串,並加上副檔名,做為檔案名稱
			   name = UUID.randomUUID().toString().replaceAll("-","") + expandedName;
				
			   // 將使用者上傳之檔案,儲存至/images底下
			   try {
				   File file = new File(application.getRealPath("/images"), name);
				   storeBanner.transferTo(file);
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
			   
		        // storeBanner 完整路徑
		        storeBannerImg = application.getContextPath() + "/images/" + name;
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
			 
			 // 取得當前使用者帳號及商店資料
			 CustomerBean user = (CustomerBean)session.getAttribute("user");
			 List<SellerBackstageManageBean> temp = sellerBackstageManageService.findStore(user.getEmail(), 1, 999, "storeID");
			 
			 
			 bean.setEmail(user.getEmail());
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
			 
			 if(temp.size() == 0) {
				 // 資料庫內沒有當初會員的商店資料,故新增
				 sellerBackstageManageService.insertStoreData(bean);
			 } else {
				 bean.setStoreID(temp.get(0).getStoreID());
				 bean.setStoreRating(temp.get(0).getStoreRating());
				 bean.setTotalPageView(temp.get(0).getTotalPageView());
				 sellerBackstageManageService.updateStoreData(bean);
			 }
			 
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

		System.out.println(bean);
		
		if(customerManagementService.updateCustomerData(bean)) {
			return "{\"status\":\"updateOK\"}";
		} else {
			return "{\"status\":\"updateError\"}";
		}
	}
}
