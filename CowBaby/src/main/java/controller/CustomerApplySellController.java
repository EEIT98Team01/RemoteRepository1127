package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
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

import model.bean.BackstageBean;
import model.bean.CustomerBean;
import model.bean.SellerBackstageManageBean;
import model.service.CustomerApplySellerService;
import model.service.CustomerManagementService;
import model.service.SellerBackstageManageService;

@Controller
@RequestMapping("CustomerApplySellAudit.controller")
public class CustomerApplySellController {
	
	@Autowired
	CustomerApplySellerService customerApplySellerService;
	@Autowired
	CustomerManagementService customerManagementService;
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String method(String email,int customerID){
		
		CustomerBean customerBean = customerManagementService.findById(customerID);
		BackstageBean backstageBean = new BackstageBean();
		
		 // 設定目前時間
	    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    backstageBean.setApplicationDate(timestamp);
	    backstageBean.setApplicationState(1);
	    backstageBean.setEmail(email);
		
		customerApplySellerService.insertBackstageData(backstageBean);
		return "apple_seller_success";
	}
			
}
