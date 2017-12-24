package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.SellerBackstageManageBean;

public interface SellerBackstageManageDao {
	// 由storeID取得相對應資料
	public SellerBackstageManageBean findById(int id);
			
	// 新增 SellerBackstageManage 資料用
	public SellerBackstageManageBean insert(SellerBackstageManageBean bean);
			
	// 編輯 SellerBackstageManage 資料用
	public SellerBackstageManageBean update(SellerBackstageManageBean bean);
			
	// 取得所有 SellerBackstageManage 資料
	public List<SellerBackstageManageBean> find();
			
	// 取得所有 SellerBackstageManage 資料中某頁的n筆資料,供分頁功能使用
	public List<SellerBackstageManageBean> find(int page, int rows);
			
	// 取得所有 SellerBackstageManage 資料中某頁的n筆資料,供分頁功能使用,SellerBackstageManage資料會先依某條件進行排序
	public List<SellerBackstageManageBean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 SellerBackstageManage 資料(K為欄位名稱, V為條件)
	public List<SellerBackstageManageBean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 SellerBackstageManage 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<SellerBackstageManageBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 SellerBackstageManage 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<SellerBackstageManageBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 SellerBackstageManage 數量
	public int getQuantity();
			
	// 取得符合某條件之 SellerBackstageManage 數量
	public int getConditionQuantity(Map<String, String> condition);
}
