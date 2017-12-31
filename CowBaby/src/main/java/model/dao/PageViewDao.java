package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.PageViewBean;

public interface PageViewDao {
	// 由pageViewsID取得相對應資料
	public PageViewBean findById(int id);
			
	// 新增 PageView 資料用
	public PageViewBean insert(PageViewBean bean);
			
	// 編輯 PageView 資料用
	public PageViewBean update(PageViewBean bean);
			
	// 取得所有 PageView 資料
	public List<PageViewBean> find();
			
	// 取得所有 PageView 資料中某頁的n筆資料,供分頁功能使用
	public List<PageViewBean> find(int page, int rows);
			
	// 取得所有 PageView 資料中某頁的n筆資料,供分頁功能使用,PageView資料會先依某條件進行排序
	public List<PageViewBean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 PageView 資料(K為欄位名稱, V為條件)
	public List<PageViewBean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 PageView 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<PageViewBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 PageView 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<PageViewBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 PageView 數量
	public int getQuantity();
			
	// 取得符合某條件之 PageView 數量
	public int getConditionQuantity(Map<String, String> condition);
}
