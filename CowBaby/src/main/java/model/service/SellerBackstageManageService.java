package model.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedList;
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
	
	
	// 取得符合特定條件商店數量
	public int getQuantity() {
			
		return sellerBackstageManageDao.getQuantity();
	}
	
	public List<Object[]> hotStoreList(int rating, int pageView, int quantity) {
		Map<String, String> condition = new HashMap<String, String>();
		condition.put("storeRating", ">= " + rating);
		condition.put("totalPageView", ">= " + pageView);
		List<SellerBackstageManageBean> storeList = sellerBackstageManageDao.findByCondition(condition, 1, quantity, "storeRating desc, totalPageView desc");
		
		List<Object[]> result = new LinkedList<Object[]>();
		for(int i = 0; i < storeList.size(); i++) {
			SellerBackstageManageBean store = storeList.get(i);
			Object[] obj = new Object[6];
			obj[0] = store.getStoreID();
			obj[2] = store.getStoreName();
			obj[3] = store.getStoreDescription();
			obj[4] = store.getStoreRating();
			obj[5] = store.getTotalPageView();
			
			// 處理圖片
			java.sql.Blob blobimg = store.getStoreLogo();
			try {
				byte[] img = Base64.getEncoder().encode(blobimg.getBytes(1, (int) blobimg.length()));
				String logoImg = new String(img);
			 	obj[1] = logoImg;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			result.add(obj);
		}
		
		return result;
	}

	
	
}
