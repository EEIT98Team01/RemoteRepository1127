package model.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.HashMap;
import java.util.Map;


public class ShoppingCart {
	
	// 存放到購物車的產品 Map< storeID , List<商品名子(OrderDetailBean)>>
	private Map<String, List<OrderDetailBean>> items = new HashMap<String, List<OrderDetailBean>>();

	// 加入購物車
	public void addToCart(int storeID ,int productId,int productSize,int productNum) { 
		
		SellerBackstageManageBean sellerBackstageManageBean = new SellerBackstageManageBean();
		ProductBean productBean =new ProductBean();
		ProductSizeBean productSizeBean = new ProductSizeBean();
		OrderDetailBean orderDetailBean = new OrderDetailBean();
		
		// 用 storeID 來檢查user是否在這家店買過東西，如果沒有，則增加到MAP中		
		if(!items.containsKey(storeID)){
			
			// 撈出該產品的詳細資訊 ProductBean
			// ProductBean=
			
			// 設定訂單明細
			orderDetailBean.setProductID(productId);
			orderDetailBean.setProductID(productId);
			
			// 購買該商品的清單
			List<OrderDetailBean> buyList = new ArrayList<OrderDetailBean>();
			
			
			
			
			
			
			
//			items.put(key, value);
			
		}else{
			// 如果有user在這家店買過東西，則檢查該商品是否已買過，買過則商品+1	
		}
		
		
		
		
		//如果購物車中有這筆商品，則這筆商品數量加1
		if (items.containsKey(storeID)) {
//			ProductBean item = items.get(productID);
			
		
		} else {
		//如果購物車中無該商品，則創建該商品放入購物車
			ProductBean item = new ProductBean();
				
		
		}
		
		
		
		
		
		
		
		// 1.用 productID 查是哪家商店的產品，獲取 store id
		
		// 2. (1)- 如果 store id 還沒有在購物車
		
		
		
		
//		//如果購物車中有這筆商品，則這筆商品數量加1
//		if (items.containsKey(productID)) {
//			ProductBean item = items.get(productID);
//			
//		
//		} else {
//		//如果購物車中無該商品，則創建該商品放入購物車
//			ProductBean item = new ProductBean();
//				
//		
//		}
	}

	// 計算總數
	public int getTotalNumber() {
		int total = 0;
//		for (ProductBean item : items.values()) {
//			total += item.getNumber();
//		}
		return total;
	}
	
	// 計算總價
	public int getTotalMonry() { // 计算总价格
		int money = 0;
//		for (ProductBean item : items.values()) {
//			money += item.getNumber() * item.getPrice();
//		}
		return money;
	}

}



//	5、页面脚本：
//
//	<script>$(
//
//	function(){
//		     $("a").click(
//
//	function(){
//		       var url = this.href;
//		       var args = {"time":new Date()};
//		       $.getJSON(url,args,function(data){
//		         $("#bookName").text(data.bookName);           //从返回数据中取相应值
//		         $("#totalMoney").text(data.totalMoney);
//		         $("#totalBook").text(data.totalBook);
//		       });
//		       return false;
//		     });
//})</script>
