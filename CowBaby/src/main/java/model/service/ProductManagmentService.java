package model.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.ClassficationBean;
import model.bean.OrderDetailBean;
import model.bean.ProductBean;
import model.dao.ClassficationDao;
import model.dao.OrderDetailDao;
import model.dao.ProductDao;
import model.dao.SellerBackstageManageDao;
import model.dao.impl.MyDaoImpl;

@Service
@Transactional
public class ProductManagmentService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ClassficationDao classficationDao;
	@Autowired
	private OrderDetailDao orderDetailDao;
	@Autowired
	private MyDaoImpl myDaoImpl;
	@Autowired
	private SellerBackstageManageDao sellerBackstageManageDao;
	
	// 取得特定product資料
	public ProductBean findById(int id) {
		return productDao.findById(id);
	}
	
	// 新增一筆product資料
	public ProductBean insertProduct(ProductBean bean) {
		return productDao.insert(bean);
	}
	
	// 更新一筆product資料
	public ProductBean updateProdcut(ProductBean bean) {
		return productDao.update(bean);
	}
	
	// 取得符合特定條件的product資料
	public List<ProductBean> findProduct(String storeId, String productName, String productClassfication, String suitableAges, String genderPreference, String productStatus, int page, int rows, String sortCondition) {
		
		if( (storeId == null || "".equals(storeId.trim())) &&
		    (productName == null || "".equals(productName.trim())) &&
		    (productClassfication == null || "".equals(productClassfication.trim())) &&
		    (suitableAges == null || "".equals(suitableAges.trim())) &&
		    (genderPreference == null || "".equals(genderPreference.trim())) &&
		    (productStatus == null || "".equals(productStatus.trim())) ) {
			// 沒有下任何條件,取得所有商品
			return productDao.find(page, rows, sortCondition);
		} else {
			// 有下條件,逐項檢查
			Map<String, String> condition = new HashMap<String, String>();
			
			if(storeId != null && !"".equals(storeId.trim())) {
				condition.put("storeId", "= " + storeId);
			}
			
			if(productName != null && !"".equals(productName.trim())) {
				condition.put("title", "like '%" + productName + "%'");
			}
			
			if(productClassfication != null && !"".equals(productClassfication.trim())) {
				condition.put("classficationID", "= " + productClassfication);
			}
			
			if(suitableAges != null && !"".equals(suitableAges.trim())) {
				condition.put("suitableAges", "= " + suitableAges);
			}
			
			if(genderPreference != null && !"".equals(genderPreference.trim())) {
				condition.put("genderPreference", "like '" + genderPreference + "'");
			}
			
			if(productStatus != null && !"".equals(productStatus.trim())) {
				condition.put("productStatus", "= " + productStatus);
			}
			
			return productDao.findByCondition(condition, page, rows, sortCondition);
		}
	}
	
	// 取得符合特定條件的product資料
	public int getQuantity(String storeId, String productName, String productClassfication, String suitableAges, String genderPreference, String productStatus) {
			
		if( (storeId == null || "".equals(storeId.trim())) &&
			(productName == null || "".equals(productName.trim())) &&
			(productClassfication == null || "".equals(productClassfication.trim())) &&
			(suitableAges == null || "".equals(suitableAges.trim())) &&
			(genderPreference == null || "".equals(genderPreference.trim())) &&
			(productStatus == null || "".equals(productStatus.trim())) ) {
			// 沒有下任何條件,取得所有商品
			return productDao.getQuantity();
		} else {
			// 有下條件,逐項檢查
			Map<String, String> condition = new HashMap<String, String>();
				
			if(storeId != null && !"".equals(storeId.trim())) {
				condition.put("storeId", "= " + storeId);
			}
				
			if(productName != null && !"".equals(productName.trim())) {
				condition.put("title", "like '%" + productName + "%'");
			}
				
			if(productClassfication != null && !"".equals(productClassfication.trim())) {
				condition.put("classficationID", "= " + productClassfication);
			}
				
			if(suitableAges != null && !"".equals(suitableAges.trim())) {
				condition.put("suitableAges", "= " + suitableAges);
			}
				
			if(genderPreference != null && !"".equals(genderPreference.trim())) {
				condition.put("genderPreference", "like '" + genderPreference + "'");
			}
				
			if(productStatus != null && !"".equals(productStatus.trim())) {
				condition.put("productStatus", "= " + productStatus);
			}
				
			return productDao.getConditionQuantity(condition);
		}
	}
	
	// 取得啟用的商品分類
	public List<ClassficationBean> findClassfication() {
		Map<String,String> condition = new HashMap<String,String>();
		condition.put("startStopStatus", "= 1");
		return classficationDao.findByCondition(condition);
	}
	
	// 取得熱門商品
	public List<ProductBean> hotProductList(int quantity) {
		List<ProductBean> result = new LinkedList<ProductBean>();
		List<Object[]> hotProductList = myDaoImpl.getHotProduct();
		
		int count = 0;
		for(Object[] obj: hotProductList) {
			ProductBean product = productDao.findById((int) obj[0]);
			
			if(product.isProductStatus()) {
				result.add(product);
				count++;
			}
			
			if(count >= quantity) {
				break;
			}
		}
		
		return result;
	}
	
	// 取得符合特定條件的product資料(DIN***)
	public List<ProductBean> findProduct(String productClassfication, String suitableAges, String genderPreference, int page, int rows) {
		
		if( (productClassfication == null || "".equals(productClassfication.trim())) &&
		    (suitableAges == null || "".equals(suitableAges.trim())) &&
		    (genderPreference == null || "".equals(genderPreference.trim()))
		  ) {
			// 沒有下任何條件,取得所有商品
			return productDao.find(page, rows);
		} else {
			// 有下條件,逐項檢查
			Map<String, String> condition = new HashMap<String, String>();
						
			if(productClassfication != null && !"".equals(productClassfication.trim())) {
				System.out.println("QQ");
				condition.put("classficationID", "= " + productClassfication);
			}
			
			if(suitableAges != null && !"".equals(suitableAges.trim())) {
				condition.put("suitableAges", "= " + suitableAges);
			}
			
			if(genderPreference != null && !"".equals(genderPreference.trim())) {
				condition.put("genderPreference", "like '" + genderPreference + "'");
			}
		
			
			return productDao.findByCondition(condition, page, rows);
		}
	}
	
	// 先依某條件進行排序,回傳符合某某條件的N筆資料  全域搜尋
	@Transactional(readOnly = true)
	public List<ProductBean> findByCondition(String title, int page, int rows, String sortCondition) {
		return productDao.findByCondition(this.createCondition(title), page, rows, sortCondition);
	}

	// 將查詢條件塞進Map
	private HashMap<String, String> createCondition(String title) {
		HashMap<String, String> condition = new HashMap<String, String>();

		// title對應到資料庫中的title,若為null或"",表不設定該條件
		if (title != null && title.trim().length() != 0) {
			condition.put("title", "like '%" + title + "%'");
		}
		return condition;
	}
	
	
	// 回傳有商店名稱的商品  
	public List<Object[]> findObject(String storeId, String productName, String productClassfication, String suitableAges, String genderPreference, String productStatus, int page, int rows, String sortCondition) {
		List<ProductBean> list = this.findProduct(null, null, null, null, null, null, page, rows, sortCondition);
		List<Object[]> objList = new LinkedList<Object[]>();
		// 自己組要的資料塞回頁面
		for(ProductBean bean: list) {
			Object[] obj = new Object[7];
			obj[0] = bean.getStoreID();
			obj[1] = bean.getProductImage();
			obj[2] = sellerBackstageManageDao.findById(bean.getStoreID()).getStoreName();
			obj[3] = bean.getTitle();
			obj[4] = bean.getProductDescription();
			obj[5] = bean.getUnitPrice();
			obj[6] = bean.getProductID();
			objList.add(obj);
		}
		
		return objList;
	}
		
	
}
