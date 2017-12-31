package controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
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

import model.bean.Order01Bean;
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
	public String shoppingCartCheck(Model model, HttpSession session) {

		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		System.out.println("shoppingCart=======>" + shoppingCart);

		Object[][] result = new Object[shoppingCart.getStoreNumber()][4];

		int i = 0;
		for (String key : shoppingCart.getProductInfo().keySet()) {
			List<ShoppingCart.Product> list = shoppingCart.getProductInfo().get(key);

			int items = list.size();
			int amount = 0;

			for (ShoppingCart.Product product : list) {
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
		session.removeAttribute("bonus");
		// 回傳購物車清單
		return "shopping_cart_check";
	}

	// 主要接電子地圖用
	@RequestMapping(value = ("getmarketDataController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String getmarketData(Model model, String order_id, String st_code, String st_addr, String st_tel,
			String sn_id) throws UnsupportedEncodingException {
		System.out.println("近來了");
		System.out.println("producprocessID=>" + order_id);
		System.out.println("st_code=>" + st_code);
		System.out.println("st_tel=>" + st_tel);
		System.out.println("sn_id=>" + sn_id);

		// 自訂門市資訊寫死!!
		Map<String, String> map = new HashMap<String, String>();
		map.put("convenienceStoreName", "全家通昌店");
		map.put("convenienceStoreAdd", "台北市大安區文昌街142號1樓");
		map.put("convenienceStoreTel", "02-23256420");
		map.put("order_id", order_id);// 這是紅利!!

		model.addAttribute("convenienceStorData", map);

		return "shopping_payment";
	}

	// 購物車結帳-step2.付款方式和寄件人確認
	@RequestMapping(value = ("getReceiveData"), method = { RequestMethod.GET, RequestMethod.POST })
	public String getReceiveData(Model model, String recipients, String recipientsMobile, String recipientsAdd,
			String recipientbonus, String recipientsEmail, String convenienceStoreName, String convenienceStoreTel,
			String convenienceStoreAdd,HttpSession session) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("convenienceStoreName", convenienceStoreName);
		map.put("convenienceStoreAdd", convenienceStoreAdd);
		map.put("convenienceStoreTel", convenienceStoreTel);

		map.put("getRecipientsMobile", recipientsMobile);
		map.put("getRecipientsAdd", recipientsAdd);
		map.put("recipientsEmail", recipientsEmail);
		map.put("getRecipients", recipients);
		map.put("getBonus", recipientbonus);// 這是紅利!!

		model.addAttribute("infor", map);

		// 把購物車資訊塞回去
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		System.out.println("shoppingCart=======>" + shoppingCart);

		
		JSONObject bonusJSON = new JSONObject(recipientbonus);
		
		Object[][] result = new Object[shoppingCart.getStoreNumber()][6];

		int i = 0;
		for (String key : shoppingCart.getProductInfo().keySet()) {
			List<ShoppingCart.Product> list = shoppingCart.getProductInfo().get(key);
			
			int bounsSun = 0;	
			int bouns = Integer.parseInt(bonusJSON.getString(key));	
			int items = list.size();
			int amount = 0;

			//總共用掉多少紅利
			bounsSun = bounsSun+bouns;
			
			for (ShoppingCart.Product product : list) {
				amount = amount + (product.getQuantity() * product.getUnitPrice());
			}
			
			result[i][0] = key;
			result[i][1] = items;
			result[i][2] = amount - bouns;
			result[i][3] = list;
			result[i][4] = bouns;
			result[i][5] = bounsSun;

			i++;
		}

		model.addAttribute("shoppingCartInfo", result);

		return "shopping_cart_final";
	}

	// 購物車結帳-step3
	@RequestMapping(value = ("goCheckout"), method = { RequestMethod.GET, RequestMethod.POST })
	public boolean checkout(String receiverName,
			String receiverEmail, String receiverPhone, int paymentMethod, String pickUpStore, String usebonus) {
		System.out.println("inin");

		/*
		 * for(String key: shoppingCart.getProductInfo().keySet()) {
		 * List<ShoppingCart.Product> list =
		 * shoppingCart.getProductInfo().get(key); System.out.println(key +
		 * ":"); for(ShoppingCart.Product product: list) {
		 * System.out.println(product); } }
		 * 
		 * Order01Bean bean = new Order01Bean(); bean.setCustomerID(2);
		 * bean.setOrderDate(new java.sql.Timestamp(new
		 * java.util.Date("2017/12/13 15:22:33").getTime()));
		 * bean.setAcceptDate(new java.sql.Timestamp(new
		 * java.util.Date("2017/12/14 18:22:33").getTime()));
		 * bean.setBuyerRequestCancel(null); bean.setShippedDate(new
		 * java.sql.Timestamp(new
		 * java.util.Date("2017/12/15 18:22:33").getTime()));
		 * bean.setTransactionComplete(null); bean.setOrderCancellation(null);
		 * bean.setPickUpStore("台雞店"); bean.setTotalAmount(3000);
		 * bean.setTotalItems(3); bean.setReceiverName("陳宸晨");
		 * bean.setReceiverEmail("ekdsf@gmail.com");
		 * bean.setReceiverPhone("0998-555-676"); bean.setUsebonus(0);
		 * bean.setStoreID(1); bean.setStatus(3); bean.setPaymentMethod(1);
		 * System.out.println(dao.insert(bean));
		 */

		return true;
	}

}
