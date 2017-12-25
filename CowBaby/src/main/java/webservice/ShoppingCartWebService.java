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
import model.bean.ProductSizeBean;
import model.bean.SellerBackstageManageBean;
import model.bean.ShoppingCart;
import model.dao.ProductDao;
import model.dao.ProductSizeDao;
import model.dao.SellerBackstageManageDao;

@RestController
@RequestMapping("/shopping")
@SessionAttributes(names={"shoppingCart"})
public class ShoppingCartWebService {
	@Autowired
	ProductDao productDao;
	@Autowired
	SellerBackstageManageDao sellerBackstageManageDao;
	@Autowired
	ProductSizeDao productSizeDao;
	
	@RequestMapping(
			value="/addShoppingCart",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String addShoppingCart(int storeID, int productID, int productSizeID, int productNum, Model model, HttpSession session) {

		// 1，用ID獲得全部商品資訊
		ProductBean product = productDao.findById(productID);
		SellerBackstageManageBean store = sellerBackstageManageDao.findById(storeID);
		ProductSizeBean spec = productSizeDao.findById(productSizeID);
		
		// 2，獲取購物車物件，並判斷現在有無購物車，沒有則建立購物車
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			session.setAttribute("shoppingCart", shoppingCart);
		}
		
		// 3，把点击的选项加入到购物车中；
		shoppingCart.addProduct(store.getStoreID(), store.getStoreName(), product.getProductID(), product.getTitle(), 
				                spec.getProductSpec(), product.getProductImage(), product.getUnitPrice(), productNum);

		return new JSONObject(shoppingCart).toString();
	}
	
	@RequestMapping(
			value="/removeShoppingCart",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String removeShoppingCart(int productID, int productSizeID, Model model, HttpSession session) {

		// 1，用ID獲得全部商品資訊
		ProductSizeBean spec = productSizeDao.findById(productSizeID);
		
		// 2，獲取購物車物件，並判斷現在有無購物車，沒有則建立購物車
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

		if (shoppingCart == null) {
			return "{\"stauts\":\"error\"}";
		}
		
		// 3，把点击的选项加入到购物车中；
		shoppingCart.removeProduct(productID, spec.getProductSpec());
		
		
		return new JSONObject(shoppingCart).toString();
	}
}
