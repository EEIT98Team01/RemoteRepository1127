package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.CustomerBean;
import model.bean.CustomerServiceBean;

public interface CustomerServiceDao {

	// 由ReportID取得相對應資料
	public CustomerServiceBean findById(int id);

	// 新增客訴資料用
	public CustomerServiceBean insert(CustomerServiceBean bean);
	
	// 編輯客訴資料用
	public CustomerServiceBean update(CustomerServiceBean bean);
		
	// 取得所有客訴資料
	public List<CustomerServiceBean> find();
		
	// 取得所有客訴資料中某頁的n筆資料,供分頁功能使用
	public List<CustomerServiceBean> find(int page, int rows);
		
	// 取得所有客訴資料中某頁的n筆資料,供分頁功能使用,客訴資料會先依某條件進行排序
	public List<CustomerServiceBean> find(int page, int rows, String sortCondition);
		
	// 取得符合某條件之客訴資料(K為欄位名稱, V為條件)
	public List<CustomerServiceBean> findByCondition(Map<String, String> condition);
		
	// 取得符合某條件之客訴資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<CustomerServiceBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之客訴資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<CustomerServiceBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有客訴數量
	public int getQuantity();
		
	// 取得符合某條件之客訴數量
	public int getConditionQuantity(Map<String, String> condition);
	
}
