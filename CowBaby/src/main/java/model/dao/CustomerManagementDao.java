package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.CustomerBean;

public interface CustomerManagementDao {
	
	// 由CustomerID取得相對應資料
	public CustomerBean findById(int id);
	
	// 編輯會員資料用
	public CustomerBean update(CustomerBean bean);
	
	// 取得所有會員資料
	public List<CustomerBean> find();
	
	// 取得所有會員資料中某頁的n筆資料,供分頁功能使用
	public List<CustomerBean> find(int page, int rows);
	
	// 取得所有會員資料中某頁的n筆資料,供分頁功能使用,會員資料會先依某條件進行排序
	public List<CustomerBean> find(int page, int rows, String sortCondition);
	
	// 取得符合某條件之會員資料(K為欄位名稱, V為條件)
	public List<CustomerBean> findByCondition(Map<String, String> condition);
	
	// 取得符合某條件之會員資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<CustomerBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之會員資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<CustomerBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有會員數量
	public int getQuantity();
	
	// 取得符合某條件之會員數量
	public int getConditionQuantity(Map<String, String> condition);
	
}
