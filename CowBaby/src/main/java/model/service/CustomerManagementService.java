package model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.ClassficationBean;
import model.bean.CustomerBean;
import model.dao.CustomerDao;
import utils.EmailUtil;

@Service
@Transactional
public class CustomerManagementService {
	@Autowired
	private CustomerDao customerDao;
	
	// 回傳會員資料,若資料不存在,則回傳null
	@Transactional(readOnly=true)
	public CustomerBean findById(int id){
		return customerDao.findById(id);
	}
	
	// 查詢商品分類單一設置資料
		@Transactional(readOnly = true)
		public CustomerBean getStoreData(int customerID) {
			return customerDao.findById(customerID);
		}

	
	// 回傳所有會員資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<CustomerBean> find() {
		return customerDao.find();
	}
	
	// 回傳某頁的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<CustomerBean> find(int page, int rows) {
		return customerDao.find(page, rows);
	}
	
	// 先依某條件進行排序,再回傳某頁的N筆資料
	@Transactional(readOnly=true)
	public List<CustomerBean> find(int page, int rows, String sortCondition) {
		return customerDao.find(page, rows, sortCondition);
	}
	
	// 回傳符合某條件的資料
	@Transactional(readOnly=true)
	public List<CustomerBean> findByCondition(String account, String userType, String clusterID) {
		return customerDao.findByCondition(this.createCondition(account, userType, clusterID));
	}
	
	// 回傳符合某條件的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<CustomerBean> findByCondition(String account, String userType, String clusterID, int page, int rows) {
		return customerDao.findByCondition(this.createCondition(account, userType, clusterID), page, rows);
	}
	
	// 先依某條件進行排序,回傳符合某某條件的N筆資料
	@Transactional(readOnly=true)
	public List<CustomerBean> findByCondition(String account, String userType, String clusterID, int page, int rows, String sortCondition) {
		return customerDao.findByCondition(this.createCondition(account, userType, clusterID), page, rows, sortCondition);
	}

	// 回傳資料總筆數
	@Transactional(readOnly=true)
	public int getQuantity() {
		return customerDao.getQuantity();
	}

	// 回傳符合條件之資料筆數
	@Transactional(readOnly=true)
	public int getConditionQuantity(String account, String userType, String clusterID) {
		return customerDao.getConditionQuantity(this.createCondition(account, userType, clusterID));
	}
	
	// 更新會員資料
	public boolean updateCustomerData(CustomerBean bean) {
		CustomerBean update = customerDao.update(bean);
		
		if(update != null) {
			return true;
		} else {
			return false;
		}
	}	
	
	// 將查詢條件塞進Map
	private HashMap<String, String> createCondition(String account, String userType, String clusterID) {
		HashMap<String, String> condition = new HashMap<String, String>();
		
		// account對應到資料庫中的email,若為null或"",表不設定該條件
		if(account != null && account.trim().length() != 0) {
			condition.put("email", "like '%" + account + "%'");
		}
			
		// userType對應到資料庫中的userID,若為null或"",表不設定該條件
		if(userType != null && userType.trim().length() != 0) {
			condition.put("userID", "= " + userType);
		}
			
		// clusterID對應到資料庫中的consumerSegmentation,若為null或"",表不設定該條件
		if(clusterID != null && clusterID.trim().length() != 0) {
			condition.put("consumerSegmentation", "= " + clusterID);
		}
		
		return condition;
	}
	
	// 新增會員資料
	public CustomerBean inSert(CustomerBean bean) {		
		if(bean!=null){
			String result = EmailUtil.sendEmail(bean.getEmail(), "會員註冊成功認證信",
				"<h3>CowBaby歡迎您加入會員，請點擊以下網址登入會員後啟動帳號功能^^</h3><br><a href='http://localhost:8080/CowBaby/pages/member/user_login.jsp'>牛寶貝官方網站<a/>",null);	
		}
		return  customerDao.insert(bean);
	}
	
}