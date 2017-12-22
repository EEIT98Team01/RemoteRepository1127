package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import model.bean.CustomerBean;
import model.bean.SellerBackstageManageBean;
import model.service.CustomerUserLoginService;

@Controller
@RequestMapping("CustomerRegisterController")
public class CustomerRegisterController {
	
	@Autowired
	CustomerUserLoginService customerUserLoginService;
	
//	CustomerBean customerBean,MultipartFile loginPhoto
	
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	
	public String method(CustomerBean customerBean, BindingResult bindingResult, MultipartFile loginPhoto) throws IllegalStateException, IOException, SerialException, SQLException {
		System.out.println("customerBean"+customerBean);
		System.out.println("loginPhoto"+loginPhoto);
	
		
		/*********************************/
		// loginPhoto 存【圖片】到資料庫
		System.out.println("開始");
		
		// 把 loginPhoto 類型轉為  File 類型
	    File convFile = new File( loginPhoto.getOriginalFilename());
	    
	    loginPhoto.transferTo(convFile);
	    // 把 loginPhoto 類型轉為 BYTE[] 類型
	    
	    byte[] loginPhotoImgByte = new byte[(int) convFile.length()];
	    FileInputStream fis = new FileInputStream(convFile);
		
	    fis.read(loginPhotoImgByte);
	    fis.close();
	  
	    // 把圖片塞到 customerBean 中
	    customerBean.setLoginPhoto(new javax.sql.rowset.serial.SerialBlob(loginPhotoImgByte));
	    
		System.out.println("customerBean 裡面內容"+customerBean.toString());
	    
		
		
		return "login_error";	
	}
}
