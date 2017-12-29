package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import model.bean.CustomerBean;
import model.bean.SellerBackstageManageBean;
import model.service.CustomerManagementService;
import model.service.CustomerUserLoginService;

@Controller
@RequestMapping("CustomerRegisterController")
public class CustomerRegisterController {

	@Autowired
	CustomerManagementService customerManagementService;

	@RequestMapping(method = {RequestMethod.POST })
	public String method(CustomerBean customerBean,BindingResult bindingResult,String checkPassword, MultipartFile loginPhoto,Model model)
			throws IllegalStateException, IOException, SerialException, SQLException {

		System.out.println("customerBean" + customerBean.toString());
		
		System.out.println("checkPassword" + checkPassword);
		
		System.out.println("loginPhoto" + loginPhoto.getOriginalFilename());
			
//		/*************** loginPhoto 存【圖片】到資料庫 ******************/
		 // 如果有圖片
		 if(loginPhoto.getOriginalFilename() !=null && loginPhoto.getOriginalFilename() !=""){
			 // 把 loginPhoto 類型轉為 File 類型
			 File convFile = new File( loginPhoto.getOriginalFilename());
			 loginPhoto.transferTo(convFile);
			 
			 // 把 loginPhoto 類型轉為 BYTE[] 類型
			 byte[] loginPhotoImgByte = new byte[(int) convFile.length()];
			 FileInputStream fis = new FileInputStream(convFile);
			
			 fis.read(loginPhotoImgByte);
			 fis.close();
			 
			 customerBean.setLoginPhoto(new javax.sql.rowset.serial.SerialBlob(loginPhotoImgByte));    
		 }else{
		 // 如果沒有上傳圖片
			 customerBean.setLoginPhoto(null); 
		 }
		 
		// 錯誤訊息
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		
		/*************** 資料檢查 ******************/
		// 檢查Email
//		if(!this.isValidEmail(customerBean.getEmail())){
//			errors.put("password_error", "Email欄位不可為空，並且須符合email格式");
//		}
		

		// 如果有錯誤則把錯誤 顯示在畫面上
		if (errors != null && !errors.isEmpty()) {
			return "user_register";
		}

		/*************** 把欄位資料塞回customerBean ******************/

		 CustomerBean myCustomerBean =new CustomerBean();
		 
//		 myCustomerBean.setCustomerID(0);
		 myCustomerBean.setCustomerName(customerBean.getCustomerName());
		 myCustomerBean.setEmail(customerBean.getEmail());
		 myCustomerBean.setPassword(customerBean.getPassword());
		 myCustomerBean.setMobilePhone(customerBean.getMobilePhone());
		 myCustomerBean.setLandline(customerBean.getLandline());
		 myCustomerBean.setIncome(customerBean.getIncome());
		 myCustomerBean.setAddress(customerBean.getAddress());
		 myCustomerBean.setBirthday(customerBean.getBirthday());
		 myCustomerBean.setGender(customerBean.getGender());
		 myCustomerBean.setMarriage(customerBean.isMarriage());
		 myCustomerBean.setSubscription(customerBean.isSubscription());
		 myCustomerBean.setLoginPhoto(customerBean.getLoginPhoto());
		
		 // 設定目前時間
	     Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	     myCustomerBean.setCreateTime(timestamp);
	     
	     System.out.println("***myCustomerBean 裡面內容**"+myCustomerBean.toString());

		 // 把資料儲存到資料庫
		 System.out.println("myCustomerBean 裡面內容"+myCustomerBean.toString());
		 customerManagementService.inSert(myCustomerBean);
		 System.out.println("成功!!");

		 return "register_success";
	}
	

//	// EMAIL 驗證
//	public static boolean isValidEmail(String email) {
//        if (email == null) {
//            return false;
//        }
//        String emailPattern = "^([\\w]+)(([-\\.][\\w]+)?)*@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
//        return email.matches(emailPattern);
//    }
	

}
