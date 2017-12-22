package webservice;



import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import model.bean.ProductSizeBean;
import model.bean.ShoppingCart;

@RestController
@RequestMapping("/shopping")
public class ShoppingCartWebService {
	
	@RequestMapping(
			value="/addShoppingCart",
			method={RequestMethod.POST},
			produces={"application/json;charset=UTF-8"}
	)
	public String addShoppingCart(int storeID,int productId, int productSizeID, int productNum, Model model,HttpSession session) {

		// 1，用ID獲得全部商品資訊
		
		// 2，獲取購物車物件，並判斷現在有無購物車，沒有則建立購物車
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			session.setAttribute("shoppingCart", shoppingCart);
		}
		
		// 3，把点击的选项加入到购物车中；
		shoppingCart.addToCart(storeID,productId,productSizeID,productNum);

		
		
		
		// 4准备响应JSON对象：{"bookName":.....}
		StringBuilder result = new StringBuilder();

//		// 拼装JSON数据，不能使单引号'
//		result.append("{").append("\"bookName\":\"" + bookName + "\"").append(",")
//				.append("\"totalMoney\":" + sc.getTotalMonry()).append(",")
//				.append("\"totalBook\":" + sc.getTotalNumber()).append("}");
//
//		// 5、响应JSON
//		response.setContentType("text/javascript"); // 声明类型
//		response.getWriter().print(result.toString());
//	
		return "QQ";
	
	}
}
