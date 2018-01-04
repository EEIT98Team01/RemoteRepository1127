package model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.OrderDetailBean;
import model.dao.Order01Dao;
import model.dao.OrderDetailDao;
import model.dao.ProductDao;

@Service
@Transactional
public class OrderDetailService {

	@Autowired
	private OrderDetailDao orderDetailDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private Order01Dao order01Dao;
	
	// 回傳訂單明細資料,若資料不存在,則回傳null
	@Transactional
	public OrderDetailBean findById(int id) {
		return orderDetailDao.findById(id);
	}
	

	//因為條件只有要依orderID查詢訂單 所有參數代int orderID
	@Transactional   //用集合方式
	public List<OrderDetailBean> findByCondition(int orderID) {
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("orderID", "= " + orderID); //put 把一筆資料 放到MAP裡面  字串串接，key為欄位名稱，value為查詢條件 eg: orderID = 1
		                        
		return orderDetailDao.findByCondition(condition);
	}
}
