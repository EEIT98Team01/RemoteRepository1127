package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.BackstageBean;

public interface BackstageDao {
	// 由applicationID取得相對應資料
	public BackstageBean findById(int id);
	
	// 由applicationEmail取得相對應資料
	public BackstageBean findByEmail(String email);
		
	// 新增 Backstage 資料用
	public BackstageBean insert(BackstageBean bean);
		
	// 編輯 Backstage 資料用
	public BackstageBean update(BackstageBean bean);
		
	// 取得所有 Backstage 資料
	public List<BackstageBean> find();
		
	// 取得所有 Backstage 資料中某頁的n筆資料,供分頁功能使用
	public List<BackstageBean> find(int page, int rows);
		
	// 取得所有 Backstage 資料中某頁的n筆資料,供分頁功能使用,Backstage資料會先依某條件進行排序
	public List<BackstageBean> find(int page, int rows, String sortCondition);
		
	// 取得符合某條件之 Backstage 資料(K為欄位名稱, V為條件)
	public List<BackstageBean> findByCondition(Map<String, String> condition);
		
	// 取得符合某條件之 Backstage 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<BackstageBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 Backstage 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<BackstageBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 Backstage 數量
	public int getQuantity();
		
	// 取得符合某條件之 Backstage 數量
	public int getConditionQuantity(Map<String, String> condition);
}
