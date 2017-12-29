package controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.ProductBean;
import model.bean.ShoppingCart;
import model.service.ProductService;
import model.service.ProductSizeService;

@Controller
public class ShoppinCartCheckoutProcessController {
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductSizeService productSizeService;
	
	// 購物車結帳-step1.確認購物明細
	@RequestMapping(value = ("ShoppingCartCheckController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String shoppingCartCheck(Model model, HttpSession session){
		
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		System.out.println("shoppingCart=======>"+shoppingCart);
		
		Object[][] result = new Object[shoppingCart.getStoreNumber()][4];
		
		int i = 0;
		for(String key: shoppingCart.getProductInfo().keySet()) {
			List<ShoppingCart.Product> list = shoppingCart.getProductInfo().get(key);
			
			int items = list.size();
			int amount = 0;

			for(ShoppingCart.Product product: list) {
				amount = amount + (product.getQuantity() * product.getUnitPrice());
			}
			
			result[i][0] = key;
			result[i][1] = items;
			result[i][2] = amount;
			result[i][3] = list;
			
			i++;
		}
		
		model.addAttribute("shoppingCartInfo", result);
		
		
		return "shopping_cart_check";
	}
	
	// 刪除購物車某樣尚品
	@RequestMapping(value = ("deleteProuductController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String removeShoppingCartItem(int productID, String spec, Model model, HttpSession session) {
		// 獲取購物車物件，並判斷現在有無購物車，沒有則建立購物車
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			session.setAttribute("shoppingCart", shoppingCart);
		}
		
		// 將該商品從購物車移除
		
		shoppingCart.removeProduct(productID, spec);
		
		// 回傳購物車清單
		return "shopping_cart_check";
	}
	
	
	// 獲取商店名稱
	@RequestMapping(value = ("getmarketDataController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String getmarketData(String order_id, String st_code,  String st_addr, String st_tel,String sn_id) throws UnsupportedEncodingException {
		System.out.println("近來了");
		System.out.println("producprocessID=>"+order_id);
		System.out.println("st_code=>"+st_code);
		System.out.println("st_tel=>"+st_tel);
		System.out.println("sn_id=>"+sn_id);
		String utf8String = new String(st_addr.getBytes("big5"), "UTF-8"); 
		System.out.println("utf8String=>"+utf8String);
		
		return "null";
	}
	

	/*
	// 購物車結帳-step2.付款方式和寄件人確認
	@RequestMapping(value = ("AllProductController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String allProduct(Model model) {
		
		List<Object[]> list = productService.findObject();
		model.addAttribute("productList", list);
		
		return "all_product_list";
	}
	
	
	// 購物車結帳-step3.訂單成功
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
	*/
	
	
}

