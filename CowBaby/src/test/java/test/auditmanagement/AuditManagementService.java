package test.auditmanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.CustomerBean;
import model.bean.CustomerServiceBean;
import model.dao.AdvertisementDao;
import model.dao.AdvertisementDetailDao;
import model.dao.BackstageDao;
import model.dao.CustomerDao;
import model.dao.CustomerServiceDao;

@Service
@Transactional
public class AuditManagementService {
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CustomerServiceDao customerServiceDao;
	
	@Autowired
	AdvertisementDao advertisementDao;
	
	@Autowired
	AdvertisementDetailDao advertisementDetailDao;
	
	@Autowired
	BackstageDao backstageDao;
	
	// 取得特定CustomerService資料
	public CustomerServiceBean findCustomerServiceById(int id) {
		return customerServiceDao.findById(id);
	}
	
	// 取得符合某條件之CustomerService資料
	public List<CustomerServiceBean> findCustomerService(String account, String processStatus, String problemTypes, int page, int row, String sortCondition) {
		
		if( (account == null || "".equals(account.trim())) && (processStatus == null || "".equals(processStatus.trim())) && (problemTypes == null || "".equals(problemTypes.trim())) ) {
			// 若沒有下任何查詢條件,則回傳所有資料
			return customerServiceDao.find();
		} else {
			// 若有下某些條件,則回傳符合條件的資料
			Map<String, String> condition = new HashMap<String, String>();
			
			if(account != null && !"".equals(account.trim())) {
				// 取得申訴人帳號
				Map<String, String> customerAccountCondition = new HashMap<>();
				customerAccountCondition.put("customerName", "like '%" + account + "%'");
				for(CustomerBean bean: customerDao.findByCondition(customerAccountCondition)) {
					System.out.println(bean);
				}
				
			}
			
			
			return null;
		}

	}
	
	
}
