package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.ProductBean;

public interface ProductDao {
	// 由articleID取得相對應資料
	public ProductBean findById(int id);
			
	// 新增 Product 資料用
	public ProductBean insert(ProductBean bean);
			
	// 編輯 Product 資料用
	public ProductBean update(ProductBean bean);
			
	// 取得所有 Product 資料
	public List<ProductBean> find();
			
	// 取得所有 Product 資料中某頁的n筆資料,供分頁功能使用
	public List<ProductBean> find(int page, int rows);
			
	// 取得所有 Product 資料中某頁的n筆資料,供分頁功能使用,Product資料會先依某條件進行排序
	public List<ProductBean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 Product 資料(K為欄位名稱, V為條件)
	public List<ProductBean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 Product 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<ProductBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 Product 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<ProductBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 Product 數量
	public int getQuantity();
			
	// 取得符合某條件之 Product 數量
	public int getConditionQuantity(Map<String, String> condition);
}
