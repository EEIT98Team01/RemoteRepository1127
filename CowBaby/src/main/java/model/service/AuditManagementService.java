package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.AdvertisementBean;
import model.bean.AdvertisementDetailBean;
import model.bean.BackstageBean;
import model.bean.CustomerServiceBean;
import model.dao.AdvertisementDao;
import model.dao.AdvertisementDetailDao;
import model.dao.BackstageDao;
import model.dao.CustomerServiceDao;

@Service
@Transactional
public class AuditManagementService {
	@Autowired
	private CustomerServiceDao customerServiceDao;
	
	@Autowired
	private AdvertisementDao advertisementDao;
	
	@Autowired
	private AdvertisementDetailDao advertisementDetailDao;
	
	@Autowired
	private BackstageDao backstageDao;
	
	// 取得特定CustomerService資料
	public CustomerServiceBean findCustomerServiceById(int id) {
		return customerServiceDao.findById(id);
	}
	
	// 取得符合某條件之CustomerService資料
	public List<CustomerServiceBean> findCustomerService(String account, String processStatus, String problemTypes, int page, int rows, String sortCondition) {
		
		if( (account == null || "".equals(account.trim())) && (processStatus == null || "".equals(processStatus.trim())) && (problemTypes == null || "".equals(problemTypes.trim())) ) {
			// 若沒有下任何查詢條件,則回傳所有資料
			return customerServiceDao.find(page, rows, sortCondition);
		} else {
			// 若有下某些條件,則回傳符合條件的資料
			Map<String, String> condition = new HashMap<String, String>();
			
			if(account != null && !"".equals(account.trim())) {
				condition.put("email", "like '%" + account + "%'");
			}
			
			if(processStatus != null && !"".equals(processStatus.trim())) {
				condition.put("processStatus", "= " + processStatus);
			}
			
			if(problemTypes != null && !"".equals(problemTypes.trim())) {
				condition.put("problemTypes", "= " + problemTypes);
			}
			
			return customerServiceDao.findByCondition(condition, page, rows, sortCondition);
		}

	}
	
	// 更新某筆CustomerService資料
	public CustomerServiceBean updateCustomerService(CustomerServiceBean bean) {
		return customerServiceDao.update(bean);
	}
	
	
	// 取得特定Advertisement資料
	public AdvertisementBean findAdvertisementById(int id) {
		return advertisementDao.findById(id);
	}
	
	// 取得符合某條件之Advertisement資料
	public List<AdvertisementBean> findAdvertisement(String storeId, String adState, int page, int rows, String sortCondition) {
		if( (storeId == null || "".equals(storeId.trim())) && (adState == null || "".equals(adState.trim())) ) {
			// 若沒有下任何查詢條件,則回傳所有資料
			return advertisementDao.find(page, rows, sortCondition);
		} else {
			// 若有下某些條件,則回傳符合條件的資料
			Map<String, String> condition = new HashMap<String, String>();
			
			if(storeId != null && !"".equals(storeId.trim())) {
				condition.put("storeID", "= " + storeId);
			}
			
			if(adState != null && !"".equals(adState.trim())) {
				condition.put("adState", "= " + adState);
			}
			
			return advertisementDao.findByCondition(condition, page, rows, sortCondition);
		}
	}
	
	// 更新某筆Advertisement資料
	public AdvertisementBean updateAdvertisement(AdvertisementBean bean) {
		return advertisementDao.update(bean);
	}
	
	
	// 取得符合某條件之AdvertisementDetail資料
	public List<AdvertisementDetailBean> findAdvertisementDetail(String adId, String sortCondition) {
		if( adId == null || "".equals(adId.trim()) ) {
			// 若沒有下任何查詢條件,則回傳所有資料
			return advertisementDetailDao.find(1, 365, sortCondition);
		} else {
			// 若有下某些條件,則回傳符合條件的資料
			Map<String, String> condition = new HashMap<String, String>();
				
			if(adId != null && !"".equals(adId.trim())) {
				condition.put("adID", "= " + adId);
			}

			return advertisementDetailDao.findByCondition(condition, 1, 365, sortCondition);
		}
	}

	// 更新某筆AdvertisementDetail資料
	public AdvertisementDetailBean updateAdvertisementDetail(AdvertisementDetailBean bean) {
		return advertisementDetailDao.update(bean);
	}


	// 取得特定Backstage資料
	public BackstageBean findBackstageById(int id) {
		return backstageDao.findById(id);
	}
	
	// 取得符合否條件之Backstage資料
	public List<BackstageBean> findBackstage(String account, String applicationState, int page, int rows, String sortCondition) {
		if( (account == null || "".equals(account.trim())) && (applicationState == null || "".equals(applicationState.trim())) ) {
			// 若沒有下任何查詢條件,則回傳所有資料
			return backstageDao.find(page, rows, sortCondition);
		} else {
			// 若有下某些條件,則回傳符合條件的資料
			Map<String, String> condition = new HashMap<String, String>();
			
			if(account != null && !"".equals(account.trim())) {
				condition.put("email", "like '%" + account + "%'");
			}
			
			if(applicationState != null && !"".equals(applicationState.trim())) {
				condition.put("applicationState", "= " + applicationState);
			}
			
			return backstageDao.findByCondition(condition, page, rows, sortCondition);
		}
	}

	// 更新某筆Backstage資料
	public BackstageBean updateBackstage(BackstageBean bean) {
		return backstageDao.update(bean);
	}
	
	
	// 發送訊息
}
