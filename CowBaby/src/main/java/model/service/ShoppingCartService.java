package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.CustomerBean;
import model.bean.Order01Bean;
import model.bean.OrderDetailBean;
import model.bean.ProductBean;
import model.bean.ProductSizeBean;
import model.bean.SellerBackstageManageBean;
import model.bean.ShoppingCart;
import model.dao.CustomerDao;
import model.dao.Order01Dao;
import model.dao.OrderDetailDao;
import model.dao.ProductDao;
import model.dao.ProductSizeDao;
import model.dao.SellerBackstageManageDao;

@Service
@Transactional
public class ShoppingCartService {
	@Autowired
	ProductDao productDao;
	@Autowired
	SellerBackstageManageDao sellerBackstageManageDao;
	@Autowired
	ProductSizeDao productSizeDao;
	@Autowired
	Order01Dao order01Dao;
	@Autowired
	OrderDetailDao orderDetailDao;
	@Autowired
	CustomerDao CustomerDao;
	
	// 取得某筆Product
	public ProductBean findProductById(int id) {
		return productDao.findById(id);
	}
	
	// 取得某筆SellerBackstageManage
	public SellerBackstageManageBean findSellerBackstageManageById(int id) {
		return sellerBackstageManageDao.findById(id);
	}
	
	// 取得某筆ProductSize
	public ProductSizeBean findproductSizeById(int id) {
		return productSizeDao.findById(id);
	}
	
	// 取得某筆Order01
	public Order01Bean findOrder01ById(int id) {
		return order01Dao.findById(id);
	}
	
	// 結帳
	public boolean checkout(List<ShoppingCart.Product> productList, int storeId, String account, String receiverName, String receiverEmail,
			                String receiverPhone, int paymentMethod, String pickUpStore, int usebonus) {
		
		// 處理Order01資料
		Order01Bean order = new Order01Bean();
		order.setEmail(account);
		order.setReceiverName(receiverName);
		order.setReceiverEmail(receiverEmail);
		order.setReceiverPhone(receiverPhone);
		order.setPaymentMethod(paymentMethod);
		order.setPickUpStore(pickUpStore);
		order.setUsebonus(usebonus);
			
		order.setOrderDate(new java.util.Date());			// 下訂時間,取系統時間,可能須修正
		order.setStatus(1);									// 下訂單為1,可能須修正
		order.setStoreID(storeId);
			
		// 處理OrderDetail資料及ProductSize資料
		OrderDetailBean[] orderDetail = new OrderDetailBean[productList.size()];
		ProductSizeBean[] productSize = new ProductSizeBean[productList.size()];
			
		int count = 0;			// 處理到該店家的第count筆商品
		int totalItems = 0;		// 共多少商品
		int totalAmount = 0;	// 總金額
		for(ShoppingCart.Product product: productList) {
			// 處理OrderDetail資料
			orderDetail[count] = new OrderDetailBean();
			orderDetail[count].setProductID(product.getProductID());
			orderDetail[count].setUnitPrice(product.getUnitPrice());
			orderDetail[count].setQuantity(product.getQuantity());
			orderDetail[count].setTitle(product.getProductName());
			orderDetail[count].setProductSpec(product.getProductSpec());
				
			// 處理總計
			totalItems = totalItems + 1;
			totalAmount = totalAmount + (product.getQuantity() * product.getUnitPrice());
				
			// 處理庫存
			Map<String, String> condition = new HashMap<String, String>();
			condition.put("ProductID", "= " + product.getProductID());
			condition.put("ProductSpec", "like '"+ product.getProductSpec() + "'");
			productSize[count] = productSizeDao.findByCondition(condition).get(0);
				
			count++;
		}
			
		// 新增Order01
		order.setTotalItems(totalItems);
		order.setTotalAmount(totalAmount - usebonus);
		Order01Bean insertOrder = order01Dao.insert(order);
			
		for(int i = 0; i < productList.size(); i++) {
			// 新增OrderDetail
			orderDetail[i].setOrderID(insertOrder.getOrderID());
			orderDetailDao.insert(orderDetail[i]);
				
			// 更新productSize的庫存量
			productSize[i].setSpecStock(productSize[i].getSpecStock() - orderDetail[i].getQuantity());
			productSizeDao.update(productSize[i]);
		}
			
		// 更新Customer的usebonus
		Map<String, String> condition = new HashMap<String, String>();
		condition.put("email", "like '"+ account + "'");
		CustomerBean customer = CustomerDao.findByCondition(condition).get(0);
		customer.setBonus(customer.getBonus() - usebonus + ((totalAmount-usebonus)/100));
		customer.setTotalAmoutOfConsumption(customer.getTotalAmoutOfConsumption() + totalAmount - usebonus);
		customer.setConsumptionTimes(customer.getConsumptionTimes() + 1);

		return true;
	}
	
}
