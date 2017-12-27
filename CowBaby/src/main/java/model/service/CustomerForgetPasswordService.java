package model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.CustomerBean;
import model.dao.CustomerDao;

@Service
@Transactional
public class CustomerForgetPasswordService {

	@Autowired
	private CustomerDao customerDao;

	// 回傳符合某條件的資料
	@Transactional(readOnly = true)
	public CustomerBean findByCondition(String useremail) {
		List<CustomerBean> list = customerDao.findByCondition(this.createCondition(useremail));

		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}

	}

	// 將查詢條件塞進Map
	private HashMap<String, String> createCondition(String username) {
		HashMap<String, String> condition = new HashMap<String, String>();

		if (username != null && username.trim().length() != 0) {
			condition.put("email", "like '%" + username + "%'");
		}
		return condition;
	}
}
