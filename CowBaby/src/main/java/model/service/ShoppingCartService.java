package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Order01Bean;
import model.bean.ProductBean;
import model.bean.ProductSizeBean;
import model.bean.SellerBackstageManageBean;
import model.dao.Order01Dao;
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
	
}
