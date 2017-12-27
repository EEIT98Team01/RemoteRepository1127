package test.customerservice;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.CustomerServiceBean;
import model.dao.CustomerServiceDao;

@Service
@Transactional
public class CustomerServiceAuditService {
	@Autowired
	private CustomerServiceDao CustomerServiceAuditDao;
	
	// 回傳客訴資料,若資料不存在,則回傳null
	@Transactional(readOnly=true)
	public CustomerServiceBean findById(int id){
		return CustomerServiceAuditDao.findById(id);
	}
	
	// 回傳所有客訴資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> find() {
		return CustomerServiceAuditDao.find();
	}
	
	// 回傳某頁的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> find(int page, int rows) {
		return CustomerServiceAuditDao.find(page, rows);
	}
	
	// 先依某條件進行排序,再回傳某頁的N筆資料
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> find(int page, int rows, String sortCondition) {
		return CustomerServiceAuditDao.find(page, rows, sortCondition);
	}
	
	// 回傳符合某條件的資料
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> findByCondition(String problemTypes, String processStatus, String customerID) {
		return CustomerServiceAuditDao.findByCondition(this.createCondition(problemTypes, processStatus, customerID));
	}
	
	// 回傳符合某條件的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> findByCondition(String problemTypes, String processStatus, String customerID, int page, int rows) {
		return CustomerServiceAuditDao.findByCondition(this.createCondition(problemTypes, processStatus, customerID), page, rows);
	}
	
	// 先依某條件進行排序,回傳符合某某條件的N筆資料
	@Transactional(readOnly=true)
	public List<CustomerServiceBean> findByCondition(String problemTypes, String processStatus, String customerID, int page, int rows, String sortCondition) {
		return CustomerServiceAuditDao.findByCondition(this.createCondition(problemTypes, processStatus, customerID), page, rows, sortCondition);
	}

	// 回傳資料總筆數
	@Transactional(readOnly=true)
	public int getQuantity() {
		return CustomerServiceAuditDao.getQuantity();
	}

	// 回傳符合條件之資料筆數
	@Transactional(readOnly=true)
	public int getConditionQuantity(String problemTypes, String processStatus, String customerID) {
		return CustomerServiceAuditDao.getConditionQuantity(this.createCondition(problemTypes, processStatus, customerID));
	}
	
	// 更新客訴資料
	public boolean updateCustomerData(CustomerServiceBean bean) {
		CustomerServiceBean update = CustomerServiceAuditDao.update(bean);
		
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
}
