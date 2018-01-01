package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.ClassficationBean;
import model.dao.ClassficationDao;

@Service
@Transactional
public class ClassficationService {

	@Autowired
	private ClassficationDao classficationDao;

	// 查詢商品分類單一設置資料
	@Transactional(readOnly = true)
	public ClassficationBean getStoreData(int classficationID) {
		return classficationDao.findById(classficationID);
	}

	// 回傳所有商品分類資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly = true)
	public List<ClassficationBean> find() {
		return classficationDao.find();
	}
	
	// 回傳某頁的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<ClassficationBean> find(int page, int rows) {
		return classficationDao.find(page, rows);
	}

	// 回傳商品分類資料總筆數
	@Transactional(readOnly = true)
	public int getQuantity() {
		return classficationDao.getQuantity();
	}

	// 回傳符合條件之資料筆數
	@Transactional(readOnly = true)
	public int getConditionQuantity(String account, String userType, String clusterID) {
		return classficationDao.getConditionQuantity(this.createCondition(account, userType, clusterID));
	}

	// 回傳符合某條件的資料
	@Transactional(readOnly = true)
	public List<ClassficationBean> findByCondition(String classficatoinName) {
		if((classficatoinName == null) || "".equals(classficatoinName.trim())){
			return classficationDao.find();//未使用任何條件
		}else{
			Map<String,String> condition = new HashMap<String,String>();
			if(classficatoinName != null){
				condition.put("classficatoinName", "like '%" + classficatoinName + "%'");
			}
			return classficationDao.findByCondition(condition);
		}
	}

	// 回傳符合某條件的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly = true)
	public List<ClassficationBean> findByCondition(String account, String userType, String clusterID, int page, int rows) {
		return classficationDao.findByCondition(this.createCondition(account, userType, clusterID), page, rows);
	}

	
	
	// 先依某條件進行排序,回傳符合某某條件的N筆資料
	@Transactional(readOnly = true)
	public List<ClassficationBean> findByCondition(String account, String userType, String clusterID, int page, int rows,
			String sortCondition) {
		return classficationDao.findByCondition(this.createCondition(account, userType, clusterID), page, rows,
				sortCondition);
	}
	
	// 儲存商品分類設置資料
	@Transactional
	public ClassficationBean insertStoreData(ClassficationBean bean) {
		return classficationDao.insert(bean);
	}

	// 修改商品分類設置資料
	@Transactional
	public ClassficationBean updateStoreData(ClassficationBean bean) {
		ClassficationBean result = null;
		if (bean != null) {
			result = classficationDao.update(bean);
		}
		return result;
	}
	
	
	// 先依某條件勾選查詢,回傳符合某某條件的N筆資料
		@Transactional(readOnly = true)
		public List<ClassficationBean> findByCondition(int classficationID, int page, int rows) {
			
			if((classficationID == 0)){
				return classficationDao.find();//未使用任何條件
			}else{
				Map<String,String> condition = new HashMap<String,String>();
				if(classficationID != 0){
					condition.put("classficationID", "= " + classficationID);
				}
				return classficationDao.findByCondition(condition,page,rows);
			}
			
//			return classficationDao.findByCondition(this.createCondition(classficationID), page, rows);
		}
	

	// 將查詢條件塞進Map
	private HashMap<String, String> createCondition(String account, String userType, String clusterID) {
		HashMap<String, String> condition = new HashMap<String, String>();

		// account對應到資料庫中的email,若為null或"",表不設定該條件
		if (account != null && account.trim().length() != 0) {
			condition.put("email", "like '%" + account + "%'");
		}

		// userType對應到資料庫中的userID,若為null或"",表不設定該條件
		if (userType != null && userType.trim().length() != 0) {
			condition.put("userID", "= " + userType);
		}

		// clusterID對應到資料庫中的consumerSegmentation,若為null或"",表不設定該條件
		if (clusterID != null && clusterID.trim().length() != 0) {
			condition.put("consumerSegmentation", "= " + clusterID);
		}

		return condition;
	}
	
}
