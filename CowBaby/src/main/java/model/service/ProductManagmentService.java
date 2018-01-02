package model.service;

import java.util.HashMap;
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

@Service
@Transactional
public class ProductManagmentService {
	@Autowired
	ProductDao productDao;
	@Autowired
	ClassficationDao classficationDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	
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
		List<OrderDetailBean> orderDetailList = orderDetailDao.find();
		Map<String, Integer> temp = new HashMap<String, Integer>();
		
		for(OrderDetailBean bean: orderDetailList) {
			int productID = bean.getProductID();
			
			if(temp.get(productID) == null) {
				temp.put(productID + "", 1);
			} else {
				int sum = temp.get(productID);
				temp.put(productID + "", sum+1);
			}
		}
		
		return null;
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
	
}
