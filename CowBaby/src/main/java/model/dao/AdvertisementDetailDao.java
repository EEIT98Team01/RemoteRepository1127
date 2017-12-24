package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.AdvertisementDetailBean;

public interface AdvertisementDetailDao {
	// 由adDetailID取得相對應資料
	public AdvertisementDetailBean findById(int id);
	
	// 新增 AdvertisementDetail 資料用
	public AdvertisementDetailBean insert(AdvertisementDetailBean bean);
	
	// 編輯 AdvertisementDetail 資料用
	public AdvertisementDetailBean update(AdvertisementDetailBean bean);
	
	// 取得所有 AdvertisementDetail 資料
	public List<AdvertisementDetailBean> find();
	
	// 取得所有 AdvertisementDetail 資料中某頁的n筆資料,供分頁功能使用
	public List<AdvertisementDetailBean> find(int page, int rows);
	
	// 取得所有 AdvertisementDetail 資料中某頁的n筆資料,供分頁功能使用,AdvertisementDetail資料會先依某條件進行排序
	public List<AdvertisementDetailBean> find(int page, int rows, String sortCondition);
	
	// 取得符合某條件之 AdvertisementDetail 資料(K為欄位名稱, V為條件)
	public List<AdvertisementDetailBean> findByCondition(Map<String, String> condition);
	
	// 取得符合某條件之 AdvertisementDetail 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<AdvertisementDetailBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 AdvertisementDetail 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<AdvertisementDetailBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 AdvertisementDetail 數量
	public int getQuantity();
	
	// 取得符合某條件之 AdvertisementDetail 數量
	public int getConditionQuantity(Map<String, String> condition);
}
