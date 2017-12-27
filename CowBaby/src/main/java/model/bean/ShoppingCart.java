package model.bean;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class ShoppingCart {
	private int totalItems;		// 共多少商品
	private int totalAmount;	// 總金額
	private int storeNumber;	// 商店數量
	private Map<String, List<Product>> productInfo = new HashMap<String, List<Product>>();
	
	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		
		// 增加商品
		shoppingCart.addProduct(1, "商店1", 1, "屁屁褲", "黑", "123.jpg", 1000, 1);
		shoppingCart.addProduct(1, "商店1", 1, "屁屁褲", "藍", "123.jpg", 1000, 10);
		shoppingCart.addProduct(1, "商店1", 1, "鐺鐺鞋", "紅", "1235.jpg", 300, 1);
		shoppingCart.addProduct(1, "商店1", 1, "鐺鐺鞋", "紅", "1235.jpg", 300, 2);
		shoppingCart.addProduct(2, "商店2", 2, "屁屁褲", "藍", "1234.jpg", 500, 10);
		shoppingCart.addProduct(3, "商店3", 3, "格林童話", "精裝", "1111.jpg", 1000, 1);
		
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
		
		System.out.println("-------------------------------------------------------------------------------------");
		
		// 移除商品
		shoppingCart.removeProduct(1, "黑");
		shoppingCart.removeProduct(3, "精裝");
		
		shoppingCart.addProduct(3, "商店3", 4, "三字經", "威力加強版", "11111.jpg", 1000, 1);
		
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
		
		System.out.println("-------------------------------------------------------------------------------------");
		
		System.out.println(new JSONObject(shoppingCart).toString());
	}
	
	// 將商品加入購物車
	public void addProduct(int storeID, String storeName, int productID, String productName, String productSpec, 
			                       String productImage, int unitPrice, int quantity) {
		
		// 取得在該商店的購買清單,若尚未於該商店購買,則productList為null
		List<Product> productList = productInfo.get(storeID + "-" + storeName);
		
		// 檢查是否已在該商店購買,若無則新增
		if(productList == null) {
			productList = new LinkedList<ShoppingCart.Product>();
			productInfo.put(storeID + "-" + storeName, productList);
			storeNumber = storeNumber + 1;
		}
		
		// 檢查該商品是否已於productList中
		int count = 0;
		for(; count < productList.size(); count++) {
			// 已存在,則break 
			if(productList.get(count).getProductID() == productID && 
			   productList.get(count).getProductSpec().equals(productSpec)) {
				break;
			}
		}
		
		// 依照是否存在於productList中,做相對應動作
		if(count == productList.size()) {	// 不存在productList
			// 設定該prodcut資訊
			ShoppingCart.Product product = new ShoppingCart.Product();
			product.setProductID(productID);
			product.setProductName(productName);
			product.setProductSpec(productSpec);
			product.setProductImage(productImage);
			product.setUnitPrice(unitPrice);
			product.setQuantity(quantity);
			
			// 將該prodcut加入productList,並更新相關資訊
			productList.add(product);
			totalItems = totalItems + 1;
			totalAmount = totalAmount + (unitPrice * quantity);
		} else {							// 存在productList
			// 取得該product物件
			ShoppingCart.Product product = productList.get(count);
			
			// 增加該商品購買數量,並更新相關資訊
			product.setQuantity(product.getQuantity() + quantity);
			totalAmount = totalAmount + (unitPrice * quantity);
		}

	}
	
	// 將商品從購物車移除
	public void removeProduct(int productID, String productSpec) {
		for(String key: productInfo.keySet()) {
			List<ShoppingCart.Product> list = productInfo.get(key);
			
			// 檢查欲移除之product是否存在於各店的productList中
			int count = 0;
			for(ShoppingCart.Product product: list) {
				if(product.getProductID() == productID && product.getProductSpec().equals(productSpec)) {
					// 已發現,更新相關資訊,並從列表移除
					totalItems = totalItems - 1;
					totalAmount = totalAmount - (product.getQuantity() * product.getUnitPrice());
					list.remove(count);
					
					// 若list為0,表示在該商店已無購買任何商品,移除在productInfo之資料,並更新相關資訊
					if(list.size() == 0) {
						storeNumber = storeNumber - 1;
						productInfo.remove(key);
					}
					
					break;
				} else {
					count++;
				}
			}
		}
	}
	
	
	
		
	
	@Override
	public String toString() {
		return "ShoppingCart [totalItems=" + totalItems + ", totalAmount=" + totalAmount + ", storeNumber="
				+ storeNumber + ", productInfo=" + productInfo + "]";
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}

	public Map<String, List<Product>> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(Map<String, List<ShoppingCart.Product>> productInfo) {
		this.productInfo = productInfo;
	}

	public class Product {
		private int productID;
		private String productName;
		private String productSpec;
		private String productImage;
		private int unitPrice;
		private int quantity;
		
		@Override
		public String toString() {
			return "Product [productID=" + productID + ", productName=" + productName + ", productSpec=" + productSpec
					+ ", productImage=" + productImage + ", unitPrice=" + unitPrice + ", quantity=" + quantity + "]";
		}

		public int getProductID() {
			return productID;
		}

		public void setProductID(int productID) {
			this.productID = productID;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getProductSpec() {
			return productSpec;
		}

		public void setProductSpec(String productSpec) {
			this.productSpec = productSpec;
		}

		public String getProductImage() {
			return productImage;
		}

		public void setProductImage(String productImage) {
			this.productImage = productImage;
		}

		public int getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(int unitPrice) {
			this.unitPrice = unitPrice;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
	}
}