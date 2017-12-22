package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.AdvertisementBean;
import model.bean.CustomerBean;

public interface AdvertisementAuditDao {
	
	// 由AdID取得相對應資料
	public AdvertisementBean findById(int id);
	
	// 編輯廣告申請資料用
	public AdvertisementBean update(CustomerBean bean);
	
	// 取得所有廣告申請資料
	public List<AdvertisementBean> find();
	
	// 取得所有廣告申請資料中某頁的n筆資料,供分頁功能使用
	public List<AdvertisementBean> find(int page, int rows);
	
	// 取得所有廣告申請資料中某頁的n筆資料,供分頁功能使用,廣告申請資料會先依某條件進行排序
	public List<AdvertisementBean> find(int page, int rows, String sortCondition);
	
	// 取得符合某條件之廣告申請資料(K為欄位名稱, V為條件)
	public List<AdvertisementBean> findByCondition(Map<String, String> condition);
	
	// 取得符合某條件之廣告申請資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<AdvertisementBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之廣告申請資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<AdvertisementBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有廣告申請數量
	public int getQuantity();
	
	// 取得符合某條件之廣告申請數量
	public int getConditionQuantity(Map<String, String> condition);
}
