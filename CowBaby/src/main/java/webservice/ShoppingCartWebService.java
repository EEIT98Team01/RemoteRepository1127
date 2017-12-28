package webservice;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.bean.ProductBean;
import model.bean.SellerBackstageManageBean;
import model.bean.ShoppingCart;
import model.service.ShoppingCartService;

@RestController
@RequestMapping("/shopping")
@SessionAttributes(names={"shoppingCart"})
public class ShoppingCartWebService {
	@Autowired
	ShoppingCartService shoppingCartService;
	
	
	@RequestMapping(
			value="/getShoppingCart",
			method={RequestMethod.GET},
			produces={"application/json;charset=UTF-8"}
	)
	public String getShoppingCart(Model model, HttpSession session) {
		// 獲取購物車物件，並判斷現在有無購物車，沒有則建立購物車
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			session.setAttribute("shoppingCart", shoppingCart);
		}

		// 回傳購物車清單
		return new JSONObject(session.getAttribute("shoppingCart")).toString();
	}
	
	@RequestMapping(
			value="/addShoppingCart",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String addShoppingCart(int productID, String spec, int productNum, Model model, HttpSession session) {
		// 獲取購物車物件，並判斷現在有無購物車，沒有則建立購物車
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			session.setAttribute("shoppingCart", shoppingCart);
		}
		
		// 利用ID取得商品資訊
		ProductBean product = shoppingCartService.findProductById(productID);
		
		// 商品存在,才可加入購物車
		if(product != null) {
			// 取得商店資訊
			SellerBackstageManageBean store = shoppingCartService.findSellerBackstageManageById(product.getStoreID());
			
			// 將該商品加入購物車中
			shoppingCart.addProduct(store.getStoreID(), store.getStoreName(), product.getProductID(), product.getTitle(), 
					                spec, product.getProductImage(), product.getUnitPrice(), productNum);
			
		}
		
		// 回傳購物車清單
		return new JSONObject(shoppingCart).toString();
	}
	
	@RequestMapping(
			value="/removeShoppingCart",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String removeShoppingCart(int productID, String spec, Model model, HttpSession session) {
		// 獲取購物車物件，並判斷現在有無購物車，沒有則建立購物車
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			session.setAttribute("shoppingCart", shoppingCart);
		}
		
		// 將該商品從購物車移除
		shoppingCart.removeProduct(productID, spec);
		
		// 回傳購物車清單
		return new JSONObject(shoppingCart).toString();
	}
	
	
	
}
