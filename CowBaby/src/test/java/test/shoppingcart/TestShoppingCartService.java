package test.shoppingcart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.ShoppingCart;

public class TestShoppingCartService {

	public static void main(String[] args) throws SerialException, SQLException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		ShoppingCartService service = (ShoppingCartService) context.getBean(ShoppingCartService.class);
		
	// 測試內容
		ShoppingCart shoppingCart = new ShoppingCart();

		// 增加商品
		shoppingCart.addProduct(1, "瑑瑑的店", 3, "DinDin書", "精裝", "333.jpg", 10000, 5);
		shoppingCart.addProduct(1, "瑑瑑的店", 2, "DinDin衣", "白", "222.jpg", 10000, 2);
		shoppingCart.addProduct(1, "瑑瑑的店", 2, "DinDin衣", "黑", "222.jpg", 10000, 3);
		shoppingCart.addProduct(2, "第二間店", 4, "小蜜蜂杯子", "藍", "444.jpg", 500, 2);
		shoppingCart.addProduct(2, "第二間店", 5, "大蜜蜂杯子", "紫", "555.jpg", 1000, 10);
		
		// 檢查
		System.out.println("StoreNumber: " + shoppingCart.getStoreNumber());
		System.out.println("TotalItems: " + shoppingCart.getTotalItems());
		System.out.println("TotalAmount: " + shoppingCart.getTotalAmount());
		for(String key: shoppingCart.getProductInfo().keySet()) {
			List<ShoppingCart.Product> list = shoppingCart.getProductInfo().get(key);
			System.out.println(key + ":");
			for(ShoppingCart.Product product: list) {
				System.out.println(product);
			}
		}
		
//		service.checkout(shoppingCart.getProductInfo().get("1-瑑瑑的店"), 1, "999@gmail.com", "功德院", "123@gmail.com", "0987654321", 1, 
//				         "", 50);
//		
//		service.checkout(shoppingCart.getProductInfo().get("2-第二間店"), 1, "999@gmail.com", "功德院", "123@gmail.com", "0987654321", 1, 
//		         "", 100);
		
		JSONObject json = new JSONObject();
		json.put("1-瑑瑑的店", "20");
		json.put("2-第二間店", "10");

		JSONObject result = new JSONObject(json.toString());
		
		
		for(String key: shoppingCart.getProductInfo().keySet()) {
			System.out.println(result.getString(key));
		}
		
	/*---------------------------------------------------------------------------------------------*/
		((ConfigurableApplicationContext) context).close();
	}

}
