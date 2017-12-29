package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.CustomerServiceBean;
import model.bean.SellerBackstageManageBean;
import model.dao.CustomerServiceDao;

@Service
@Transactional
public class CustomerServiceAuditService {
	@Autowired
	private CustomerServiceDao CustomerServiceDao;
	
	// 回傳客訴資料,若資料不存在,則回傳null
	@Transactional(readOnly=true)
	public CustomerServiceBean findById(int id){
		return CustomerServiceDao.findById(id);
	}
	
	// 回傳所有客訴資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> find() {
		return CustomerServiceDao.find();
	}
	
	// 回傳某頁的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> find(int page, int rows) {
		return CustomerServiceDao.find(page, rows);
	}
	
	// 先依某條件進行排序,再回傳某頁的N筆資料
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> find(int page, int rows, String sortCondition) {
		return CustomerServiceDao.find(page, rows, sortCondition);
	}
	
	//新增玩家客訴資料
	@Transactional
	public CustomerServiceBean insertStoreData(CustomerServiceBean bean) {
		return CustomerServiceDao.insert(bean);
	}
	
	// 查詢該客訴玩家設置資料
	@Transactional(readOnly = true)
	public CustomerServiceBean getReprotData(int reportID) {
		return CustomerServiceDao.findById(reportID);
	}
	
	@Transactional(readOnly = true)
	public List<CustomerServiceBean> findByReview(String email, String processStatus, String problemTypes) {
		if((email == null) && (email == processStatus) && (problemTypes == null)){
			return CustomerServiceDao.find();//未使用任何條件
		}else{
			Map<String,String> condition = new HashMap<String,String>();
			if(email != null){
				condition.put("email", "=" + "'" + email + "'");
			}
			if(processStatus != null){
				condition.put("processStatus", "=" + processStatus);
			}
			if(processStatus != null){
				condition.put("problemTypes", "=" + problemTypes);
			}
			return CustomerServiceDao.findByCondition(condition);
		}
	}
	
	// 回傳符合某條件的資料
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> findByCondition(String problemTypes, String processStatus, String email) {
		return CustomerServiceDao.findByCondition(this.createCondition(problemTypes, processStatus, email));
	}
	
	// 回傳符合某條件的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> findByCondition(String problemTypes, String processStatus, String customerID, int page, int rows) {
		return CustomerServiceDao.findByCondition(this.createCondition(problemTypes, processStatus, customerID), page, rows);
	}
	
	// 先依某條件進行排序,回傳符合某某條件的N筆資料
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> findByCondition(String problemTypes, String processStatus, String customerID, int page, int rows, String sortCondition) {
		return CustomerServiceDao.findByCondition(this.createCondition(problemTypes, processStatus, customerID), page, rows, sortCondition);
	}

	// 回傳資料總筆數
	@Transactional(readOnly=true)
	public int getQuantity() {
		return CustomerServiceDao.getQuantity();
	}

	// 回傳符合條件之資料筆數
	@Transactional(readOnly=true)
	public int getConditionQuantity(String problemTypes, String processStatus, String customerID) {
		return CustomerServiceDao.getConditionQuantity(this.createCondition(problemTypes, processStatus, customerID));
	}
	
	@Transactional(readOnly = true)
	public int getConditionreview(String problemTypes, String processStatus, String email) {
		return CustomerServiceDao.getConditionQuantity(this.createCondition(problemTypes, processStatus, email));
	}
	
	// 更新客訴資料
	public boolean updateCustomerData(CustomerServiceBean bean) {
		CustomerServiceBean update = CustomerServiceDao.update(bean);
		
		if(update != null) {
			return true;
		} else {
			return false;
		}
	}
	
	// 將查詢條件塞進Map
	private HashMap<String, String> createCondition(String problemTypes, String processStatus, String customerID) {
		HashMap<String, String> condition = new HashMap<String, String>();
		
		// problemTypes對應到資料庫中的problemTypes,若為null或"",表不設定該條件
		if(problemTypes != null && problemTypes.trim().length() != 0) {
			condition.put("problemTypes", "= " + problemTypes);
		}
			
		// processStatus對應到資料庫中的processStatus,若為null或"",表不設定該條件
		if(processStatus != null && processStatus.trim().length() != 0) {
			condition.put("processStatus", "= " + processStatus);
		}
			
		// customerID對應到資料庫中的customerID,若為null或"",表不設定該條件
		if(customerID != null && customerID.trim().length() != 0) {
			condition.put("customerID", "= " + customerID);
		}
		
		return condition;
	}
	
	// 新增客訴資料
	public CustomerServiceBean insertCustomerData(CustomerServiceBean bean) {
		
		CustomerServiceBean result =  null;	
		if(bean != null) {
			result = CustomerServiceDao.insert(bean);
		} 
		
		return result;
	}
	
	//新增特定客訴資料

}
