package model.service;

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
}
