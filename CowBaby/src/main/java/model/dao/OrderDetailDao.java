package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.OrderDetailBean;

public interface OrderDetailDao {
	// 由orderDetailID取得相對應資料
	public OrderDetailBean findById(int id);
			
	// 新增 OrderDetail 資料用
	public OrderDetailBean insert(OrderDetailBean bean);
			
	// 編輯 OrderDetail 資料用
	public OrderDetailBean update(OrderDetailBean bean);
			
	// 取得所有 OrderDetail 資料
	public List<OrderDetailBean> find();
			
	// 取得所有 OrderDetail 資料中某頁的n筆資料,供分頁功能使用
	public List<OrderDetailBean> find(int page, int rows);
			
	// 取得所有 OrderDetail 資料中某頁的n筆資料,供分頁功能使用,OrderDetail資料會先依某條件進行排序
	public List<OrderDetailBean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 OrderDetail 資料(K為欄位名稱, V為條件)
	public List<OrderDetailBean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 OrderDetail 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<OrderDetailBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 OrderDetail 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<OrderDetailBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 OrderDetail 數量
	public int getQuantity();
			
	// 取得符合某條件之 OrderDetail 數量
	public int getConditionQuantity(Map<String, String> condition);
}
