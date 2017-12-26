package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
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
}
