package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.BlogBean;
import model.bean.CustomerBean;
import model.bean.Order01Bean;
import model.bean.OrderDetailBean;
import model.dao.Order01Dao;
import model.dao.OrderDetailDao;
import utils.EmailUtil;

@Service
@Transactional
public class Order01Service {

	@Autowired
	private Order01Dao order01Dao;
	@Autowired
	private OrderDetailDao orderDetailDao;
	

	
	//1 回傳訂單資料,若資料不存在,則回傳null
	@Transactional(readOnly = true)
	public Order01Bean findById(int id) {
		return order01Dao.findById(id);
	}

	//2 回傳所有訂單資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly = true)
	public List<Order01Bean> find() {
		return order01Dao.find();
	}

	//3 回傳某頁的N筆資料,若無資料,則回傳之List為空集合
	public List<Order01Bean> find(int page, int rows) {
		return order01Dao.find(page, rows);
	}

	//4 先依某條件進行排序,再回傳某頁的N筆資料
	@Transactional(readOnly = true)
	public List<Order01Bean> find(int page, int rows, String sortCondition) {
		return order01Dao.find(page, rows, sortCondition);
	}

	//5 回傳符合某條件的資料
	@Transactional(readOnly=true)
	public List<Order01Bean> findByCondition(String orderID, String storeID, String status, String startTime, String endTime) {
		return order01Dao.findByCondition(this.createCondition(orderID, storeID, status, startTime, endTime));
	}
	
	//6 回傳符合某條件的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<Order01Bean> findByCondition(String orderID,String storeID, String status, String startTime,String endTime, int page, int rows) {
		return order01Dao.findByCondition(this.createCondition(orderID, storeID, status, startTime, endTime), page, rows);
	}

	//7 先依某條件進行排序,回傳符合某某條件的N筆資料
	@Transactional(readOnly=true)
	public List<Order01Bean> findByCondition(String orderID,String storeID, String status, String startTime, String endTime, int page, int rows, String sortCondition) {
		return order01Dao.findByCondition(this.createCondition(orderID, storeID, status, startTime, endTime), page, rows, sortCondition);
	}

	//8 回傳資料總筆數
	@Transactional(readOnly=true)
	public int getQuantity() {
		return order01Dao.getQuantity();
	}
	
	//9回傳符合條件之資料筆數
	@Transactional(readOnly=true)
	public int getConditionQuantity(String orderID,String storeID, String status, String startTime, String endTime) {
		return order01Dao.getConditionQuantity(this.createCondition(orderID, storeID, status, startTime, endTime));
	}
	
	// 更新會員資料
	public boolean updateCustomerData(Order01Bean bean) {
		Order01Bean update = order01Dao.update(bean);
		
		if(update != null) {
			return true;
		} else {
			return false;
		}
	}
	
	// 10.將查詢條件塞進Map
	private HashMap<String, String> createCondition(String orderID,String storeID, String status, String startTime, String endTime) {
		HashMap<String, String> condition = new HashMap<String, String>();
		
		// orderID對應到資料庫中的orderID,若為null或"",表不設定該條件
		if((orderID != null && orderID.trim().length() != 0 )) {
			condition.put("orderID", "= " + orderID);
		}
		if((storeID != null && storeID.trim().length() != 0 )) {
			condition.put("storeID", "= " + storeID);
		}	
		// status對應到資料庫中的status,若為null或"",表不設定該條件
		if(status != null && status.trim().length() != 0) {
			condition.put("status", "= " + status);
		}		
		if(((startTime != null && !"".equals(startTime.trim()))) && (endTime != null && !"".equals(endTime.trim()))){  //時間有下條件的話
			 condition.put("orderDate", "between '" + startTime + "' and '" + endTime + "'");
		}
		return condition;
	}
	
	// 新增訂單資料
	public Order01Bean inSert(Order01Bean bean) {		
		return  order01Dao.insert(bean);
	}
	
/*
	//5 回傳符合某條件的資料 此方法包含所有狀態，三個條件。 時間為null 條件沒下。
	public List<Order01Bean> findByCondition(String orderID, String status, String startTime, String endTime,
			int page, int rows, String sortCondition) {
		if ((orderID == null) && (status == null) && (startTime == null) && (endTime == null)) {
			return order01Dao.find(page, rows, sortCondition); // 使用者未下任何條件
		} else { // 有下條件，
			Map<String, String> condition = new HashMap<String, String>();
			if (status != null) {
				condition.put("status", "= " + status);
			}
			if(orderID != null){     //另外一個條件，orderID有下條件才把東西塞到Map裡
				condition.put("orderID", "= " + orderID);
			}
			if(startTime != null && endTime != null){  //時間有下條件的話
				 condition.put("orderDate", "between '" + startTime + "' and '" + endTime + "'");
			}
		
	//Select * from order01 where orderDate between '2001/3/3' and '2015/10/10'		
			return order01Dao.findByCondition(condition);
		}
	}
*/
	

}
