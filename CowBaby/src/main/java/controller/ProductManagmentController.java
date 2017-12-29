package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.ProductBean;
import model.service.ProductManagmentService;

@Controller
public class ProductManagmentController {
	@Autowired
	ProductManagmentService productManagmentService;
	
	// 商品管理/商品列表使用
	@RequestMapping(
			value=("/pages/backstageSeller/ProductList"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String productList(Model model, String productName, String productClassfication, String productStatus, String pageNumber, String pageSize) {
		int quantity;			// 回傳的資料筆數
		int pageQuantity;		// 總頁數
		
		// 處理頁數及每頁數量筆數初始值
		if(pageNumber == null || "".equals(pageNumber.trim())) {
			pageNumber = "1";
		}

		if(pageSize == null || "".equals(pageSize.trim())) {
			pageSize = "10";
		}
		
		// 暫時寫死為第一間商店
		List<ProductBean> result = productManagmentService.findProduct("1", productName, productClassfication, null, null, productStatus, Integer.parseInt(pageNumber), Integer.parseInt(pageSize), "DisplayTime desc");
		quantity = productManagmentService.getQuantity("1", productName, productClassfication, null, null, productStatus);
		
		// 計算總頁數
		if((quantity%Integer.parseInt(pageSize)) == 0) {
			pageQuantity = quantity/Integer.parseInt(pageSize);
		} else {
			pageQuantity = quantity/Integer.parseInt(pageSize)+1;
		}

		model.addAttribute("tatal", quantity);
		model.addAttribute("totalPage", pageQuantity);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("productList", result);
		
		
		model.addAttribute("productName", productName);
		model.addAttribute("productClassfication", productClassfication);
		
		return "product_list";
	}
	
}
