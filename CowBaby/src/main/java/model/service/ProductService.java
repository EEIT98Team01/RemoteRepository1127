package model.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.helpers.ParseConversionEventImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.ProductBean;
import model.bean.ProductSizeBean;
import model.dao.ProductDao;
import model.dao.ProductSizeDao;
import model.dao.SellerBackstageManageDao;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private SellerBackstageManageDao sellerBackstageManageDao;
	@Autowired
	private ProductSizeDao productSizeDao;
	

	// 查詢商品分類單一設置資料
	@Transactional(readOnly = true)
	public ProductBean getStoreData(int classficationID) {
		return productDao.findById(classficationID);
	}

	// 回傳所有商品分類資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly = true)
	public List<ProductBean> find() {
		return productDao.find();
	}
	

	// 回傳某頁的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<ProductBean> find(int page, int rows) {
		return productDao.find(page, rows);
	}

	// 回傳商品分類資料總筆數
	@Transactional(readOnly = true)
	public int getQuantity() {
		return productDao.getQuantity();
	}

	// 回傳符合條件之資料筆數
	@Transactional(readOnly = true)
	public int getConditionQuantity(String account, String userType, String clusterID) {
		return productDao.getConditionQuantity(this.createCondition(account, userType, clusterID));
	}

	// 回傳符合某條件的資料
	@Transactional(readOnly = true)
	public List<ProductBean> findByCondition(String classficationID,String productStatus) {
		if((classficationID == null) || "".equals(classficationID.trim()) && (productStatus == null)){
			return productDao.find();//未使用任何條件
		}else{
			Map<String,String> condition = new HashMap<String,String>();
			if(classficationID != null){
				condition.put("classficationID", "= " + classficationID);
			}
			return productDao.findByCondition(condition);
		}
	}
	
	//全域搜尋
	@Transactional(readOnly = true)
	public List<ProductBean> findBycommodity(String title) {
		if((title == null) || "".equals(title.trim())){
			return productDao.find();//未使用任何條件
		}else{
			Map<String,String> condition = new HashMap<String,String>();
			if(title != null){
				condition.put("title", "like '%" + title + "%'");
			}
			 List<ProductBean> JJ = productDao.findByCondition(condition);
			 System.out.println(JJ);
			 return JJ;
		}
	}

	// 回傳符合某條件的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly = true)
	public List<ProductBean> findByCondition(String account, String userType, String clusterID, int page, int rows) {
		return productDao.findByCondition(this.createCondition(account, userType, clusterID), page, rows);
	}

	// 先依某條件進行排序,回傳符合某某條件的N筆資料
	@Transactional(readOnly = true)
	public List<ProductBean> findByCondition(String account, String userType, String clusterID, int page, int rows,
			String sortCondition) {
		return productDao.findByCondition(this.createCondition(account, userType, clusterID), page, rows,
				sortCondition);
	}

	// 儲存商品分類設置資料
	@Transactional
	public ProductBean insertStoreData(ProductBean bean) {
		return productDao.insert(bean);
	}

	// 修改商品分類設置資料
	@Transactional
	public ProductBean updateStoreData(ProductBean bean) {
		ProductBean result = null;
		if (bean != null) {
			result = productDao.update(bean);
		}
		return result;
	}

	// 將查詢條件塞進Map
	private HashMap<String, String> createCondition(String account, String userType, String clusterID) {
		HashMap<String, String> condition = new HashMap<String, String>();

		// account對應到資料庫中的email,若為null或"",表不設定該條件
		if (account != null && account.trim().length() != 0) {
			condition.put("email", "like '%" + account + "%'");

		}

		// userType對應到資料庫中的userID,若為null或"",表不設定該條件
		if (userType != null && userType.trim().length() != 0) {
			condition.put("userID", "= " + userType);
		}

		// clusterID對應到資料庫中的consumerSegmentation,若為null或"",表不設定該條件
		if (clusterID != null && clusterID.trim().length() != 0) {
			condition.put("consumerSegmentation", "= " + clusterID);
		}

		return condition;
	}
	
	// 回傳有商店名稱的商品
	public List<Object[]> findObject() {
		List<ProductBean> list = this.find();
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
