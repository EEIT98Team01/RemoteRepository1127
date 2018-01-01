package webservice;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import model.bean.ProductBean;
import model.bean.ProductSizeBean;
import model.service.ProductManagmentService;
import model.service.ProductSizeService;

@RestController
@RequestMapping("/product")
public class ProductManagmentWebService {
	@Autowired
	ProductManagmentService productManagmentService;
	@Autowired
	ProductSizeService productSizeService;
	@Autowired
	private ServletContext application;
	
	@RequestMapping(
			value="/addProduct",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String addProduct(MultipartFile productImage, String productName, String productSummary, String productClassfication,
            String productUnitPrice, String productStatus, String suitableAges, String genderPreference,
            String productContents, String productSpec, String productStock, Model model) throws Exception {
		
		System.out.println("productImage==>"+productImage.getOriginalFilename());
		System.out.println("productName==>"+productName);
		System.out.println("productSummary==>"+productSummary);
		System.out.println("productClassfication==>"+productClassfication);
		System.out.println("productUnitPrice==>"+productUnitPrice);
		System.out.println("productStatus==>"+productStatus);
		System.out.println("suitableAges==>"+suitableAges);
		System.out.println("genderPreference==>"+genderPreference);
		System.out.println("productContents==>"+productContents);
		System.out.println("productSpec==>"+productSpec);
		System.out.println("productStock==>"+productStock);
		
		// 存放回傳給AJAX 的 response jsonObj
		JSONObject jsonObj = new JSONObject();

		// 設定商品各項資料
		ProductBean product = new ProductBean();
		product.setStoreID(1); // 暫時寫死為1,之後要拿到顧客資料,再拿他的商店ID
		product.setTitle(productName);
		product.setSummary(productSummary);
		product.setUnitPrice(Integer.parseInt(productUnitPrice));
		product.setProductDescription(productContents);
		if("1".equals(productStatus)) {
			product.setProductStatus(true);
		} else {
			product.setProductStatus(false);
		}
		product.setClassficationID(Integer.parseInt(productClassfication));
		product.setSuitableAges(Integer.parseInt(suitableAges));
		product.setGenderPreference(genderPreference);
		product.setDisplayTime(new java.util.Date());
		
		// 處理商品圖示,將檔案存到images資料夾,並將路徑寫到資料庫
		if(productImage != null) {
			String name = productImage.getOriginalFilename();	// 取得來源端檔案名稱
			String mimeType = application.getMimeType(name);	// 取得副檔名
			
			// 由副檔名檢查使用者上傳檔案是否為圖檔
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
				jsonObj.put("message", "");
				jsonObj.put("error", "文件格式不正確)必須為.jpg/.gif/.bmp/.png文件)");
				return jsonObj.toJSONString();
			}
			
			// 取得UUID字串,並加上副檔名,做為檔案名稱
			name = UUID.randomUUID().toString().replaceAll("-","") + expandedName;
			
			// 將使用者上傳之檔案,儲存至/images底下
			try {
				File file = new File(application.getRealPath("/images"), name);
				productImage.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 將路徑設定給ProdcutBean
			product.setProductImage(application.getContextPath() + "/images/" + name);
		}
		
		ProductBean insert = productManagmentService.insertProduct(product);

		// 處理規格表
		String[] spec = productSpec.split(",");
		String[] stock = productStock.split(",");
		
		for(int i = 0; i < spec.length; i++) {
			ProductSizeBean productSize = new ProductSizeBean();
			
			productSize.setProductID(insert.getProductID());
			productSize.setProductSpec(spec[i]);
			productSize.setSpecStock(Integer.parseInt(stock[i]));
			
			productSizeService.insert(productSize);
		}
		
		return jsonObj.toJSONString();
	}
	
	@RequestMapping(
			value="/editProduct",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String editProduct(MultipartFile productImage, String productID, String productName, String productSummary, String productClassfication,
            String productUnitPrice, String productStatus, String suitableAges, String genderPreference,
            String productContents, String productSpec, String productStock, String productSizeID, Model model) throws Exception {
		
		System.out.println("productImage==>"+productImage.getOriginalFilename());
		System.out.println("productID==>"+productID);
		System.out.println("productName==>"+productName);
		System.out.println("productSummary==>"+productSummary);
		System.out.println("productClassfication==>"+productClassfication);
		System.out.println("productUnitPrice==>"+productUnitPrice);
		System.out.println("productStatus==>"+productStatus);
		System.out.println("suitableAges==>"+suitableAges);
		System.out.println("genderPreference==>"+genderPreference);
		System.out.println("productContents==>"+productContents);
		System.out.println("productSpec==>"+productSpec);
		System.out.println("productStock==>"+productStock);
		System.out.println("productSizeID==>"+productSizeID);
		
		// 存放回傳給AJAX 的 response jsonObj
		JSONObject jsonObj = new JSONObject();

		// 設定商品各項資料
		ProductBean product = productManagmentService.findById(Integer.parseInt(productID));
		product.setTitle(productName);
		product.setSummary(productSummary);
		product.setUnitPrice(Integer.parseInt(productUnitPrice));
		product.setProductDescription(productContents);
		if("1".equals(productStatus)) {
			product.setProductStatus(true);
		} else {
			product.setProductStatus(false);
		}
		product.setClassficationID(Integer.parseInt(productClassfication));
		product.setSuitableAges(Integer.parseInt(suitableAges));
		product.setGenderPreference(genderPreference);
		product.setDisplayTime(new java.util.Date());
		
		// 處理商品圖示,將檔案存到images資料夾,並將路徑寫到資料庫
		if(!productImage.getOriginalFilename().equals("")) {
			String name = productImage.getOriginalFilename();	// 取得來源端檔案名稱
			String mimeType = application.getMimeType(name);	// 取得副檔名
			
			// 由副檔名檢查使用者上傳檔案是否為圖檔
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
				jsonObj.put("message", "");
				jsonObj.put("error", "文件格式不正確)必須為.jpg/.gif/.bmp/.png文件)");
				return jsonObj.toJSONString();
			}
			
			// 取得UUID字串,並加上副檔名,做為檔案名稱
			name = UUID.randomUUID().toString().replaceAll("-","") + expandedName;
			
			// 將使用者上傳之檔案,儲存至/images底下
			try {
				File file = new File(application.getRealPath("/images"), name);
				productImage.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 將路徑設定給ProdcutBean
			product.setProductImage(application.getContextPath() + "/images/" + name);
		}
		
		productManagmentService.updateProdcut(product);

		// 處理規格表
		String[] sizeID = productSizeID.replaceAll(",", " ").trim().split(" ");
		String[] spec = productSpec.replaceAll(",", " ").trim().split(" ");
		String[] stock = productStock.replaceAll(",", " ").trim().split(" ");
		
		for(int i = 0; i < sizeID.length; i++) {
			ProductSizeBean bean = productSizeService.getproductData(Integer.parseInt(sizeID[i]));
			bean.setProductSpec(spec[i]);
			bean.setSpecStock(Integer.parseInt(stock[i]));
			productSizeService.update(bean);
		}
		
		return jsonObj.toJSONString();
	}
	
}
