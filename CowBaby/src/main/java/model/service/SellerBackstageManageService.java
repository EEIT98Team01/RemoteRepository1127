package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.SellerBackstageManageBean;
import model.dao.SellerBackstageManageDao;

@Service
@Transactional
public class SellerBackstageManageService {
	@Autowired
	private SellerBackstageManageDao sellerBackstageManageDao;
	
	// 查詢該店家設店設置資料
	@Transactional(readOnly=true)
	public SellerBackstageManageBean getStoreData(int storeID) {
		return sellerBackstageManageDao.findById(storeID);
	}
	
	// 儲存新增商店設置資料
	@Transactional
	public SellerBackstageManageBean insertStoreData(SellerBackstageManageBean bean) {
		return sellerBackstageManageDao.insert(bean);
	}
	
	// 修改商店設置資料
	@Transactional
	public SellerBackstageManageBean updateStoreData(SellerBackstageManageBean bean) {	
		SellerBackstageManageBean result = null;
		if (bean != null) {
			result = sellerBackstageManageDao.update(bean);
		}
		return result;
	}
	
	// 由email取得商店資料,若沒有指定,則取得全部
	public List<SellerBackstageManageBean> findStore(String email, int page, int rows, String sortCondition) {
		if(email == null || "".equals(email.trim())) {
			return sellerBackstageManageDao.find(page, rows, sortCondition);
		} else {
			Map<String, String> condition = new HashMap<String, String>();
			condition.put("email", "like '" + email + "'");
			return sellerBackstageManageDao.findByCondition(condition, page, rows, sortCondition);
		}
	}
	
}
