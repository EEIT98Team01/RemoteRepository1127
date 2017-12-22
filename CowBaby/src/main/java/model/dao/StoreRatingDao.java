package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.StoreRatingBean;

public interface StoreRatingDao {
	// 由ratingID取得相對應資料
	public StoreRatingBean findById(int id);
			
	// 新增 StoreRating 資料用
	public StoreRatingBean insert(StoreRatingBean bean);
			
	// 編輯 StoreRating 資料用
	public StoreRatingBean update(StoreRatingBean bean);
			
	// 取得所有 StoreRating 資料
	public List<StoreRatingBean> find();
			
	// 取得所有 StoreRating 資料中某頁的n筆資料,供分頁功能使用
	public List<StoreRatingBean> find(int page, int rows);
			
	// 取得所有 StoreRating 資料中某頁的n筆資料,供分頁功能使用,StoreRating資料會先依某條件進行排序
	public List<StoreRatingBean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 StoreRating 資料(K為欄位名稱, V為條件)
	public List<StoreRatingBean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 StoreRating 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<StoreRatingBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 StoreRating 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<StoreRatingBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 StoreRating 數量
	public int getQuantity();
			
	// 取得符合某條件之 StoreRating 數量
	public int getConditionQuantity(Map<String, String> condition);
}
