package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.Top5ProductsBean;

public interface Top5ProductsDao {
	// 由top5ProductID取得相對應資料
	public Top5ProductsBean findById(int id);
			
	// 新增 Top5Products 資料用
	public Top5ProductsBean insert(Top5ProductsBean bean);
			
	// 編輯 Top5Products 資料用
	public Top5ProductsBean update(Top5ProductsBean bean);
			
	// 取得所有 Top5Products 資料
	public List<Top5ProductsBean> find();
			
	// 取得所有 Top5Products 資料中某頁的n筆資料,供分頁功能使用
	public List<Top5ProductsBean> find(int page, int rows);
			
	// 取得所有 Top5Products 資料中某頁的n筆資料,供分頁功能使用,Top5Products資料會先依某條件進行排序
	public List<Top5ProductsBean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 Top5Products 資料(K為欄位名稱, V為條件)
	public List<Top5ProductsBean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 Top5Products 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<Top5ProductsBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 Top5Products 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<Top5ProductsBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 Top5Products 數量
	public int getQuantity();
			
	// 取得符合某條件之 Top5Products 數量
	public int getConditionQuantity(Map<String, String> condition);
}
