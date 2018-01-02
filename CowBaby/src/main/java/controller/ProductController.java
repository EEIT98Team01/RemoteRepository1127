package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
import model.service.ProductManagmentService;
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

	@Autowired
	ProductManagmentService productManagmentService;

	// 後台商品列表頁
	@RequestMapping(value = ("ProductController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String view(Model model, String classficationID, String productStatus) {
		System.out.println(classficationID);
		System.out.println(productStatus);

		if ("".equals(classficationID)) {
			classficationID = null;
		}

		if (classficationID == null || "".equals(classficationID.trim()) && (productStatus == null)) {
			model.addAttribute("classficationIDList", productService.find());
		} else {
			model.addAttribute("productStatusList", productService.findByCondition(classficationID, productStatus));
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
	
	// 前台單品資訊
	@RequestMapping(value = ("ProductItemOfShop"), method = { RequestMethod.GET, RequestMethod.POST })
	public String productItem(Model model, String storeID, String productID) {

		if (storeID != null && !"".equals(storeID.trim()) || productID != null && !"".equals(productID.trim())) {
			// 查詢該商品的全部資訊
			model.addAttribute("productData", productService.getStoreData(Integer.parseInt(productID)));

			// 查詢該商品的size
			Map<String, String> condition = new HashMap<String, String>();
			condition.put("productID", "= " + productID);
			model.addAttribute("productSize", productSizeService.findByCondition(condition));
		}

		return "prouduct_item";
	}

	// 前台商品頁面
	@RequestMapping(value = ("AllProductController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String allProduct(Model model, String keyWord) {
		System.out.println("All");
		if(keyWord == null || "".equals(keyWord.trim())) {
			// 顯示全部商品
			List<Object[]> list = productService.findObject(1, 999, "DisplayTime");;
			model.addAttribute("productList", list);
		} else {
			// 顯示符合KeyWord的商品
			List<Object[]> list = productManagmentService.findObject(null, keyWord, null, null, null, "1", 1, 999, "DisplayTime");
			model.addAttribute("productList", list);
			model.addAttribute("keyWord", keyWord);
		}

		// 顯示商品分類的數量
		List<Object[]> classficationList = new ArrayList<>();
		for (ClassficationBean bean : classficationService.find()) {
			Object[] objarr = new Object[] { bean, productService.ClassficationNumber(bean.getClassficationID()) };
			classficationList.add(objarr);
		}
		model.addAttribute("classficationList", classficationList);


		System.out.println(classficationList);
		return "all_product_list";
	}
	
	// 前台商品頁面
	@RequestMapping(value = ("NewArrivalController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String NewArrivalController(Model model, String keyWord) {
		System.out.println("new");
		if(keyWord == null || "".equals(keyWord.trim())) {
			// 顯示全部商品
			List<Object[]> list = productService.findObject(1, 999, "DisplayTime desc");
			model.addAttribute("productList", list);
		} else {
			// 顯示符合KeyWord的商品
			List<Object[]> list = productManagmentService.findObject(null, keyWord, null, null, null, "1", 1, 999, "DisplayTime desc");
			model.addAttribute("productList", list);
			model.addAttribute("keyWord", keyWord);
		}

		// 顯示商品分類的數量
		List<Object[]> classficationList = new ArrayList<>();
		for (ClassficationBean bean : classficationService.find()) {
			Object[] objarr = new Object[] { bean, productService.ClassficationNumber(bean.getClassficationID()) };
			classficationList.add(objarr);
		}
		model.addAttribute("classficationList", classficationList);


		System.out.println(classficationList);
		return "new_product_list";
	}

}
