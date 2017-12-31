package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import model.bean.ProductBean;
import model.service.ClassficationService;
import model.service.ProductManagmentService;

@Controller
public class ProductManagmentController {
	@Autowired
	ProductManagmentService productManagmentService;
	@Autowired
	ClassficationService classficationService;
	@Autowired
	private ServletContext application;
	
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
		
		// 由登入的顧客資料取得商店ID
		
		// 暫時寫死為第一間商店
		List<ProductBean> result = productManagmentService.findProduct("1", productName, productClassfication, null, null, productStatus,    Integer.parseInt(pageNumber), Integer.parseInt(pageSize), "DisplayTime desc");
		quantity = productManagmentService.getQuantity("1", productName, productClassfication, null, null, productStatus);
		
		// 計算總頁數
		if((quantity%Integer.parseInt(pageSize)) == 0) {
			pageQuantity = quantity/Integer.parseInt(pageSize);
		} else {
			pageQuantity = quantity/Integer.parseInt(pageSize)+1;
		}
		
		// 處理所需資料
		List<Object[]> productList = new LinkedList<Object[]>();
		for(ProductBean product: result) {
			Object[] temp = new Object[6];
			temp[0] = product.getTitle();
			temp[1] = product.getProductImage();
			temp[2] = classficationService.getStoreData(product.getClassficationID()).getClassficatoinName();
			temp[3] = product.getUnitPrice();
			if(product.isProductStatus()) {
				temp[4] = "上架";
			} else {
				temp[4] = "下架";
			}
			temp[5] = product.getProductID();
			productList.add(temp);
		}

		// 將分頁及表格所需資料回傳
		model.addAttribute("tatal", quantity);
		model.addAttribute("totalPage", pageQuantity);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("productList", productList);

		// 將查詢條件回填
		model.addAttribute("productName", productName);
		model.addAttribute("productClassfication", productClassfication);
		model.addAttribute("productStatus", productStatus);
		
		// 取得所有啟用分類
		model.addAttribute("classficationList", productManagmentService.findClassfication());

		return "product_list";
	}
	
	// 商品管理/商品列表使用
	@RequestMapping(
			value=("/pages/backstageSeller/ProductAdd"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String productList(Model model) {
		// 取得所有啟用分類
		model.addAttribute("classficationList", productManagmentService.findClassfication());

		return "product_add";
	}
	
	//CKeditor 文字+圖片上傳
	@RequestMapping("/pages/backstageSeller/upload.image")  //<--路徑跟ckeditor的config.js對應 
	public String imageUpload(MultipartFile upload, String CKEditorFuncNum, HttpServletResponse response)
			throws IOException {
		System.out.println("+++");
		PrintWriter out = response.getWriter();
		String name = upload.getOriginalFilename();
		String mimeType = application.getMimeType(name);

		String expandedName = "";
		if (mimeType.equals("image/jpeg")) {
			expandedName = ".jpg";
		} else if (mimeType.equals("image/png")) {
			expandedName = ".png";
		} else if (mimeType.equals("image/gif")) {
			expandedName = ".gif";
		} else if (mimeType.equals("image/bmp")) {
			expandedName = ".bmp";
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'',"
					+ "'文件格式不正確（必須為.jpg/.gif/.bmp/.png文件）');");
			out.println("</script>");
			return null;
		}

		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		name = df.format(new Date()) + expandedName;
		try {
			File file = new File(application.getRealPath("/images"), name);
			upload.transferTo(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String fileURL = application.getContextPath() + "/images/" + name;

		out.println("<script type=\"text/javascript\">");
		out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + fileURL + "','')");
		out.println("</script>");
		out.close();
		return null;
	}
	
}
