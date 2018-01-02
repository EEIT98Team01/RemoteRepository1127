package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.ClassficationBean;
import model.bean.ProductBean;
import model.service.ClassficationService;
import model.service.ProductService;
import model.service.ProductSizeService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductSizeService productSizeService;
	
	@Autowired
	ClassficationService classficationService;
	
	//後台商品列表頁
	@RequestMapping(value = ("ProductController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String view(Model model, String classficationID,String productStatus) {
		System.out.println(classficationID);
		System.out.println(productStatus);
			
		if("".equals(classficationID)){
			classficationID = null;
		}

		if (classficationID == null || "".equals(classficationID.trim()) && (productStatus == null)) {
			model.addAttribute("classficationIDList", productService.find());
		} else {
			model.addAttribute("productStatusList",
					productService.findByCondition(classficationID,productStatus));
		}
		return "product_managment_list";
	}
	
	    // 後台商品列表編輯
		@RequestMapping(value = ("productupdate.controller"), method = { RequestMethod.GET, RequestMethod.POST })
		public String productupdate(Model model, int productID, String productStatus) {
			System.out.println(productStatus);
			
			ProductBean bean = productService.getStoreData(productID);
			
			if ((productStatus == null)) {
				;
			} else {
				if ("true".equals(productStatus)) {
					bean.setProductStatus(true);
				} else {
					bean.setProductStatus(false);
				}
			}
			
			return "product_managment_list";
		}
	
	// 前台商品頁面
	@RequestMapping(value = ("AllProductController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String allProduct(Model model, String title) {
		
		
		if (title == null || "".equals(title.trim())) {
			List<Object[]> list = productService.findObject();
			model.addAttribute("productList", list);		
		}
		
		// 顯示全部商品
		List<Object[]> list = productService.findObject();
		model.addAttribute("productList", list);
		
		// 顯示商品分類
		List<ClassficationBean> classficationList = classficationService.find();
		model.addAttribute("classficationList", classficationList);
		// 顯示商品分類的數量
		int quantity = classficationService.getQuantity();
		model.addAttribute("quantity", quantity);
		
		
		System.out.println(classficationList);
		return "all_product_list";
	}
	
	
	// 前台單品資訊
	@RequestMapping(
			value=("ProductItemOfShop"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String productItem(Model model, String storeID,String productID) {
		
		if(storeID != null && !"".equals(storeID.trim()) || productID != null && !"".equals(productID.trim())) {
			//查詢該商品的全部資訊
			model.addAttribute("productData", productService.getStoreData(Integer.parseInt(productID)));
			
			//查詢該商品的size
			Map<String,String> condition = new HashMap<String,String>();
			condition.put("productID","= " + productID);
			model.addAttribute("productSize", productSizeService.findByCondition(condition));
		}
	
		
		return "prouduct_item";
	}
	
	@RequestMapping(value = ("ProductCommodity"), method = { RequestMethod.GET, RequestMethod.POST })
	public String commodityview(Model model, String title) {
		System.out.println(title);

		if (title == null || "".equals(title.trim())) {
			model.addAttribute("productList", productService.find());
		} else {
			model.addAttribute("productList", productService.findBycommodity(title));
			
		}
		return "all_product_list";
	}
	
	
	
}

