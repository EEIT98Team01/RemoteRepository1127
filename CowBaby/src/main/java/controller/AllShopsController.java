package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
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
import model.bean.ProductBean;
import model.bean.SellerBackstageManageBean;
import model.service.BlogService;
import model.service.CustomerManagementService;
import model.service.ProductService;
import model.service.SellerBackstageManageService;

@Controller
public class AllShopsController {
	
	@Autowired
	SellerBackstageManageService sellerBackstageManageService;
	
	@Autowired
	ProductService productService;
	
	
	// 獲取全部商家資訊
	@RequestMapping(value = ("AllShopController"), method = { RequestMethod.GET,RequestMethod.POST })
	public String view(Model model ,String pageNumber, String pageSize) {
		
		int quantity;			// 回傳的資料筆數
		int pageQuantity;		// 總頁數
		
		// 處理頁數及每頁數量筆數初始值
		if(pageNumber == null || "".equals(pageNumber.trim())) {
			pageNumber = "1";
		}

		if(pageSize == null || "".equals(pageSize.trim())) {
			pageSize = "10";
		}
		
		// 依據最新時間顯示商店
		List<SellerBackstageManageBean> list = sellerBackstageManageService.findStore(null,Integer.parseInt(pageNumber), Integer.parseInt(pageSize), "storeName");
		quantity = sellerBackstageManageService.getQuantity();
		model.addAttribute("shopList", list);
		
		// 計算總頁數
		if((quantity%Integer.parseInt(pageSize)) == 0) {
			pageQuantity = quantity/Integer.parseInt(pageSize);
		} else {
			pageQuantity = quantity/Integer.parseInt(pageSize)+1;
		}
		
		// 將分頁及表格所需資料回傳
		model.addAttribute("tatal", quantity);
		model.addAttribute("totalPage", pageQuantity);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("pageSize", pageSize);
		
		// 如果商店頭貼不為空
		/*if(shopData.getStoreLogo()!=null){
			// 從資料庫抓取LOGO圖片編碼(二進制)
			 java.sql.Blob shopLogo = shopData.getStoreLogo();
			 try {
				 // LOGO圖片編碼(二進制)->轉base64
				 byte[] img = Base64.getEncoder().encode(shopLogo.getBytes(1, (int)shopLogo.length())); 
				 // base64 -> 轉字串顯示於畫面上
				 String shopLogoImg = new String(img);
				 model.addAttribute("shopLogoImg", shopLogoImg);
			 } catch (Exception e) {
				 
				 e.printStackTrace();
			 }
		}*/
		
		return "all_shop"; 
	}
	
	// 獲取個人店家商店訊息
	@RequestMapping(value = ("PersonShopController"), method = { RequestMethod.GET,RequestMethod.POST })
	public String getPersonShopData(Model model ,int storeID,String email) {
		
		// 拿取商家店面設置資料
		SellerBackstageManageBean  shopData = sellerBackstageManageService.getStoreData(storeID);
		model.addAttribute("shopData", shopData);
		
		// 如果商店頭貼不為空
		if(shopData.getStoreLogo()!=null){
			// 從資料庫抓取LOGO圖片編碼(二進制)
			 java.sql.Blob shopLogo = shopData.getStoreLogo();
			 try {
				 // LOGO圖片編碼(二進制)->轉base64
				 byte[] img = Base64.getEncoder().encode(shopLogo.getBytes(1, (int)shopLogo.length())); 
				 // base64 -> 轉字串顯示於畫面上
				 String shopLogoImg = new String(img);
				 model.addAttribute("shopLogoImg", shopLogoImg);
			 } catch (Exception e) {
				 
				 e.printStackTrace();
			 }
		}
	
		// 拿取商家販賣的物品   
		// 參數: int storeId, int page, int rows
		List<ProductBean>  shopProuductsList = productService.findByCondition(storeID,1,10);
		model.addAttribute("shopProuductsList", shopProuductsList);

		return "personal_shop"; 
	}		
	
	
	
}
