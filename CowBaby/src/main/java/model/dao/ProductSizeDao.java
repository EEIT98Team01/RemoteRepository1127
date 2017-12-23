package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.ProductSizeBean;

public interface ProductSizeDao {
	// 由articleID取得相對應資料
	public ProductSizeBean findById(int id);
			
	// 新增 ProductSize 資料用
	public ProductSizeBean insert(ProductSizeBean bean);
			
	// 編輯 ProductSize 資料用
	public ProductSizeBean update(ProductSizeBean bean);
			
	// 取得所有 ProductSize 資料
	public List<ProductSizeBean> find();
			
	// 取得所有 ProductSize 資料中某頁的n筆資料,供分頁功能使用
	public List<ProductSizeBean> find(int page, int rows);
			
	// 取得所有 ProductSize 資料中某頁的n筆資料,供分頁功能使用,ProductSize資料會先依某條件進行排序
	public List<ProductSizeBean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 ProductSize 資料(K為欄位名稱, V為條件)
	public List<ProductSizeBean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 ProductSize 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<ProductSizeBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 ProductSize 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<ProductSizeBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 ProductSize 數量
	public int getQuantity();
			
	// 取得符合某條件之 ProductSize 數量
	public int getConditionQuantity(Map<String, String> condition);
}
