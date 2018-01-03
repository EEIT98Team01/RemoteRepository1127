package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import model.bean.ClassficationBean;
import model.bean.SellerBackstageManageBean;
import model.service.BlogService;
import model.service.CustomerManagementService;
import model.service.SellerBackstageManageService;

@Controller
public class AllShopsController {
	
	@Autowired
	SellerBackstageManageService sellerBackstageManageService;
	
	// 獲取全部商家資訊
	@RequestMapping(value = ("AllShopController"), method = { RequestMethod.GET,RequestMethod.POST })
	public String view(Model model) {
		
		// 依據最新時間顯示商店 //String email, 
		List<SellerBackstageManageBean> list = sellerBackstageManageService.findStore(null, 1, 10, "storeName");
		model.addAttribute("shopList", list);
		return "all_shop"; 
	}
	
	// 獲取個人店家商店訊息
	@RequestMapping(value = ("PersonShopController"), method = { RequestMethod.GET,RequestMethod.POST })
	public String getPersonShopData(Model model ,int storeID ) {	
		
		
		return "personal_shop"; 
	}		
	
	
	
}
