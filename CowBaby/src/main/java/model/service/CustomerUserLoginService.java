package model.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.CustomerBean;
import model.dao.CustomerUserLoginDao;

@Service
@Transactional
public class CustomerUserLoginService {
	
	@Autowired
	private CustomerUserLoginDao customerUserLoginDao;
	
	// 回傳符合某條件的資料
	@Transactional(readOnly=true)
	public CustomerBean findByCondition(String useremail, String password) {
		List<CustomerBean> list = customerUserLoginDao.findByCondition(this.createCondition(useremail, password));
		
		if(list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
		
	}
	
	// 將查詢條件塞進Map
	 private HashMap<String, String> createCondition(String username, String password) {
		HashMap<String, String> condition = new HashMap<String, String>();
	
		if(username != null && username.trim().length() != 0){
			condition.put("email", "like '%" + username + "%'");
		}
		
		if(password != null && password.trim().length() != 0){
			condition.put("password", "like '%" + password + "%'");
		}
		return condition;
	}
	
	
	
	
	
//	@Transactional(readOnly=true)
//	public CustomerBean login(String email,String password){
//		CustomerBean bean = customerUserLoginDao.selectEmail(email);
//		if(bean!=null){
//			if (password != null && password.length() != 0) {
//				String pass = bean.getPassword();
//				if(pass.equals(password)){
//					return bean;
//				}
//			}
//		}
//		return null;
//		return customerUserLoginDao.select(customerID);
//	}
	
//	public CustomerBean login(String username, String password) {
//		CustomerBean bean = customerUserLoginDao.findById(username);
//		if(bean!=null) {
//			if (password!=null && password.length()!=0) {
//				byte[] pass = bean.getPassword();
//				byte[] temp = password.getBytes();
//				if (Arrays.equals(pass, temp)) {
//					return bean;
//				} 
//			}
//		}
//		return null;
//	}
}
