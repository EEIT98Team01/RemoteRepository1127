package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.BlogBean;

public interface BlogDao {
	// 由articleID取得相對應資料
	public BlogBean findById(int id);
			
	// 新增 Blog 資料用
	public BlogBean insert(BlogBean bean);
			
	// 編輯 Blog 資料用
	public BlogBean update(BlogBean bean);
			
	// 取得所有 Blog 資料
	public List<BlogBean> find();
			
	// 取得所有 Blog 資料中某頁的n筆資料,供分頁功能使用
	public List<BlogBean> find(int page, int rows);
			
	// 取得所有 Blog 資料中某頁的n筆資料,供分頁功能使用,Blog資料會先依某條件進行排序
	public List<BlogBean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 Blog 資料(K為欄位名稱, V為條件)
	public List<BlogBean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 Blog 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<BlogBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 Blog 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<BlogBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 Blog 數量
	public int getQuantity();
			
	// 取得符合某條件之 Blog 數量
	public int getConditionQuantity(Map<String, String> condition);
}
