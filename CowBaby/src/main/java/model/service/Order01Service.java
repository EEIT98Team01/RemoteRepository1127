package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Order01Bean;
import model.dao.Order01Dao;

@Service
@Transactional
public class Order01Service {

	@Autowired
	private Order01Dao order01Dao;

	// 回傳會員資料,若資料不存在,則回傳null
	@Transactional(readOnly = true)
	public Order01Bean findById(int id) {
		return order01Dao.findById(id);
	}

	// 回傳所有會員資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly = true)
	public List<Order01Bean> find() {
		return order01Dao.find();
	}

	// 回傳某頁的N筆資料,若無資料,則回傳之List為空集合
	public List<Order01Bean> find(int page, int rows) {
		return order01Dao.find(page, rows);
	}

	// 回傳符合某條件的資料 此方法包含所有狀態，三個條件。 時間為null 條件沒下。
	public List<Order01Bean> findByCondition(String orderID, String orderStatus, String startTime, String endTime) {
		if ((orderID == null) && (orderStatus == null) && (startTime == null) && (endTime == null)) {
			return order01Dao.find(); // 使用未下任何條件
		} else { // 有下條件，
			Map<String, String> condition = new HashMap<String, String>();
			if (orderStatus != null) {
				condition.put("orderStatus", "= " + orderStatus);
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

	// 回傳資料總筆數
	public int getOrderQuantity() {
		return order01Dao.getQuantity();
	}

	// 更新訂單資料
	public boolean updateOrder01Data(Order01Bean bean) {
		Order01Bean update = order01Dao.update(bean);		
		if(update != null) {
			return true;
		} else {
			return false;
		}
	}
	
}
