package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import model.bean.ClassficationBean;
import model.bean.CustomerBean;
import model.bean.CustomerServiceBean;
import model.service.CustomerManagementService;
import model.service.CustomerServiceAuditService;

@Controller
public class CustomerServiceAuditController {

	@Autowired
	CustomerManagementService customerManagementService;
	@Autowired
	CustomerServiceAuditService customerServiceAuditService;

	@RequestMapping(value = ("CustomerServiceAuditList.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	// 申請一筆客服資料
	public String insertCustomerServiceData(Model model, String email, int problemTypes, String problemDescription) {

		System.out.println(email);
		System.out.println(problemTypes);
		System.out.println(problemDescription);

		if ("帳號問題".equals(problemTypes)) {
			problemTypes = 1;
		} else if ("BUG問題".equals(problemTypes)) {
			problemTypes = 2;
		} else if ("黑名單檢舉".equals(problemTypes)) {
			problemTypes = 3;
		} else if ("其他".equals(problemTypes)) {
			problemTypes = 4;
		}

		if (email == null || ("".equals(email.trim())) && 
			((problemDescription == null) && "".equals(problemDescription.trim()) ))
		   {
			return null;
		} else {
			CustomerServiceBean bean = new CustomerServiceBean();
			bean.setEmail(email);
			bean.setProblemDescription(problemDescription);
			bean.setReportTime(new java.util.Date());
			customerServiceAuditService.insertStoreData(bean);
		}
		// /*************** loginPhoto 存【圖片】到資料庫 ******************/
		// 如果有圖片
		// if(customerservicePhoto.getOriginalFilename() !=null &&
		// customerservicePhoto.getOriginalFilename() !=""){
		// // 把 loginPhoto 類型轉為 File 類型
		// File convFile = new File(
		// customerservicePhoto.getOriginalFilename());
		// customerservicePhoto.transferTo(convFile);
		//
		// // 把 loginPhoto 類型轉為 BYTE[] 類型
		// byte[] loginPhotoImgByte = new byte[(int) convFile.length()];
		// FileInputStream fis = new FileInputStream(convFile);
		//
		// fis.read(loginPhotoImgByte);
		// fis.close();
		//
		// customerBean.setLoginPhoto(new
		// javax.sql.rowset.serial.SerialBlob(loginPhotoImgByte));
		// }else{
		// // 如果沒有上傳圖片
		// customerBean.setLoginPhoto(null);
		// }

		// 錯誤訊息
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (errors != null && !errors.isEmpty()) {
			return "customer_service_error";
		}

		return "customer_service_success";
	}

	@RequestMapping(value = ("CustomerServiceAuditView.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String view(Model model, String id) {

		return "";
	}

	@RequestMapping(value = ("CustomerServiceAuditEdit.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Model model, String id) {

		return "";
	}
}
