package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.ProductBean;
import model.service.ProductService;
import model.service.ProductSizeService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductSizeService productSizeService;
	
	@RequestMapping(value = ("ProductController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String view(Model model, String classficationID,String productStatus) {
		System.out.println(classficationID);
		System.out.println(productStatus);
		
		if("全部".equals(productStatus)) {
			productStatus = null;
		} else if("一般會員".equals(productStatus)) {
			productStatus = "1";
		} else if("平台賣家".equals(productStatus)) {
			productStatus = "2";
		} else if("黑名單".equals(productStatus)) {
			productStatus = "3";
		}
		
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
	
	// 前台商品頁面
	@RequestMapping(value = ("AllProductController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String allProduct(Model model) {
		
		List<Object[]> list = productService.findObject();
		model.addAttribute("productList", list);
		
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
	
	
	
}

