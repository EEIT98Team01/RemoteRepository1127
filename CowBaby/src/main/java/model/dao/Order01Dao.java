package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.Order01Bean;

public interface Order01Dao {
	// 由orderID取得相對應資料
	public Order01Bean findById(int id);
			
	// 新增 Order01 資料用
	public Order01Bean insert(Order01Bean bean);
			
	// 編輯 Order01 資料用
	public Order01Bean update(Order01Bean bean);
			
	// 取得所有 Order01 資料
	public List<Order01Bean> find();
			
	// 取得所有 Order01 資料中某頁的n筆資料,供分頁功能使用
	public List<Order01Bean> find(int page, int rows);
			
	// 取得所有 Order01 資料中某頁的n筆資料,供分頁功能使用,Order01資料會先依某條件進行排序
	public List<Order01Bean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 Order01 資料(K為欄位名稱, V為條件)
	public List<Order01Bean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 Order01 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<Order01Bean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 Order01 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<Order01Bean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 Order01 數量
	public int getQuantity();
			
	// 取得符合某條件之 Order01 數量
	public int getConditionQuantity(Map<String, String> condition);
}
