package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.BackstageBean;
import model.bean.CustomerBean;
import model.bean.CustomerServiceBean;
import model.dao.BackstageDao;
import model.dao.CustomerServiceDao;

@Service
@Transactional
public class CustomerApplySellerService {
	
	@Autowired
	private BackstageDao backstageDao;
	
	
	// id 查詢
	public BackstageBean findById(int id){
		return backstageDao.findById(id);
	}
	
	// 更新
	public BackstageBean update(BackstageBean bean){
		return backstageDao.update(bean);
	}
	
	//email 查詢
	public BackstageBean findByEmail(String email){
		
		return backstageDao.findByEmail(email);
	}
	
	// 新增客訴資料
	public BackstageBean insertBackstageData(BackstageBean bean) {
		BackstageBean result =  null;	
		if(bean != null) {
			result = backstageDao.insert(bean);
		} 
		return result;
	}
	
	// 查詢全部賣家審核清單
	public List<BackstageBean> find(int page, int rows){
		List<BackstageBean> list = backstageDao.find(page, rows);
		return list;	
	}
	
	// 回傳資料總筆數
	@Transactional(readOnly=true)
	public int getQuantity() {
		return backstageDao.getQuantity();
	}
	
	// 回傳符合某條件的N筆資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly=true)
	public List<BackstageBean> findByCondition(String email, String processStatus, int page, int rows) {
		return backstageDao.findByCondition(this.createCondition(email, processStatus), page, rows);
	}
	
	
	// 回傳符合條件之資料筆數
	@Transactional(readOnly=true)
	public int getConditionQuantity(String email, String processStatus) {
		return backstageDao.getConditionQuantity(this.createCondition(email, processStatus));
	}

   
    // 將查詢條件塞進Map
 	private HashMap<String, String> createCondition(String email, String processStatus) {
 		HashMap<String, String> condition = new HashMap<String, String>();
 		
 		// email對應到資料庫中的email,若為null或"",表不設定該條件
 		if(email != null && email.trim().length() != 0) {
 			condition.put("email", "like '%" + email + "%'");
 		}
 			
 		// processStatus對應到資料庫中的ApplicationDescription,若為null或"",表不設定該條件
 		if(processStatus != null && processStatus.trim().length() != 0) {
 			condition.put("ApplicationDescription", "= " + processStatus);
 		}
 			
 		return condition;
 	}


	
	
	
}
