package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.ProductSizeBean;
import model.dao.ProductSizeDao;

@Service
@Transactional
public class ProductSizeService {
	
	@Autowired
	private ProductSizeDao productSizeDao;
	
	
	// 查詢所有產品設置資料
		@Transactional(readOnly=true)
		public ProductSizeBean getproductData(int productSizeID) {
			return productSizeDao.findById(productSizeID);
		}
		
	
	// 取得符合某條件之 ProductSize 資料(K為欄位名稱, V為條件)	
		public List<ProductSizeBean> findByCondition(Map<String, String> condition){
			return productSizeDao.findByCondition(condition);	
		}
		
		public ProductSizeBean insert(ProductSizeBean bean) {
			return productSizeDao.insert(bean);
		}
}
