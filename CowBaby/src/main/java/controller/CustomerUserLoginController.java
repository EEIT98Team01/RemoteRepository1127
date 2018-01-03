package controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.bean.CustomerBean;
import model.bean.SellerBackstageManageBean;
import model.service.CustomerUserLoginService;
import model.service.SellerBackstageManageService;

@Controller
@RequestMapping("CustomerUserLoginController")
@SessionAttributes(names = { "user", "logingPhotoImg","myStoreID"})

public class CustomerUserLoginController {

	@Autowired
	CustomerUserLoginService customerUserLoginService;
	@Autowired
	SellerBackstageManageService SellerBackstageManageService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String method(String useremail, String password, Model model) {

		System.out.println(useremail);
		System.out.println(password);

		// 讀取使用者輸入資料
		// 進行必要的資料型態轉換
		// 進行資料檢查
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (useremail == null || useremail.trim().length() == 0) {
			errors.put("useremail", "請輸入帳號");
		}
		if (password == null || password.trim().length() == 0) {
			errors.put("password", "請輸入密碼");
		}

		if (errors != null && !errors.isEmpty()) {
			return "login_error";
		}

		// 進行商業服務
		CustomerBean bean = customerUserLoginService.findByCondition(useremail, password);
		// 依照執行結果挑選適當的View元件
		

		if (bean == null) {
			errors.put("password", "登入失敗 ");
			return "login_error";
		} else {
			
			List<SellerBackstageManageBean> temp = SellerBackstageManageService.findStore(bean.getEmail(), 1, 999, "storeID");
			System.out.println("temp"+temp);
			if(bean.getUserID()==2){
				
				if(temp.size()!=0){
					int storeID =temp.get(0).getStoreID();
					
					model.addAttribute("myStoreID", storeID);
				}
			}
			
			// 如果大頭貼為空
			if (bean.getLoginPhoto() != null) {

				// 從資料庫抓取LOGO圖片編碼(二進制)
				java.sql.Blob logingPhoto = bean.getLoginPhoto();
				try {
					// LOGO圖片編碼(二進制)->轉base64
					byte[] img = Base64.getEncoder().encode(logingPhoto.getBytes(1, (int) logingPhoto.length()));
					// base64 -> 轉字串顯示於畫面上
					String logingPhotoImg = new String(img);
					model.addAttribute("logingPhotoImg", logingPhotoImg);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			model.addAttribute("user", bean);
			return "login_success";
		}
	}
}
