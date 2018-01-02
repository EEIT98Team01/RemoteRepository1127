package controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.service.BlogService;
import model.service.ProductManagmentService;
import model.service.SellerBackstageManageService;

@Controller
public class IndexController {
	@Autowired
	private ProductManagmentService productManagmentService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private SellerBackstageManageService sellerBackstageManageService;
	
	// 商品管理/新增商品使用
	@RequestMapping(
			value=("/index"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String index(Model model) {
//		findProduct(String storeId, 
//				String productName, 
//				String productClassfication, 
//				String suitableAges, 
//				String genderPreference, 
//				String productStatus, 
//				int page, 
//				int rows, 
//				String sortCondition) {
		
		// 處理最新商品
		model.addAttribute("newProductList", productManagmentService.findProduct(null, null, null, null, null, "1", 1, 10, "DisplayTime desc"));
		
		// 處理熱門商品
		model.addAttribute("hotProductList", productManagmentService.hotProductList(10));
		
		// 處理熱門店家
		model.addAttribute("hotStoreList", sellerBackstageManageService.hotStoreList(4, 10000, 10));
		
		// 處理媽咪推薦文章
		List<Object[]> blogList = blogService.findObject();
		List<Object[]> newBlogList = new LinkedList<Object[]>();
		for(int i = 0; i < 4; i++) {
			newBlogList.add(blogList.get(i));
		}
		model.addAttribute("newBlogList", newBlogList);
		
		return "index";
	}
}
