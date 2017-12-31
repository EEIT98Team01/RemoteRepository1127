package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.MessageBoardDetailBean;

public interface MessageBoardDetailDao {
	// 由messageDetailID取得相對應資料
	public MessageBoardDetailBean findById(int id);
			
	// 新增 MessageBoardDetail 資料用
	public MessageBoardDetailBean insert(MessageBoardDetailBean bean);
			
	// 編輯 MessageBoardDetail 資料用
	public MessageBoardDetailBean update(MessageBoardDetailBean bean);
			
	// 取得所有 MessageBoardDetail 資料
	public List<MessageBoardDetailBean> find();
			
	// 取得所有 MessageBoardDetail 資料中某頁的n筆資料,供分頁功能使用
	public List<MessageBoardDetailBean> find(int page, int rows);
			
	// 取得所有 MessageBoardDetail 資料中某頁的n筆資料,供分頁功能使用,MessageBoardDetail資料會先依某條件進行排序
	public List<MessageBoardDetailBean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 MessageBoardDetail 資料(K為欄位名稱, V為條件)
	public List<MessageBoardDetailBean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 MessageBoardDetail 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<MessageBoardDetailBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 MessageBoardDetail 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<MessageBoardDetailBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 MessageBoardDetail 數量
	public int getQuantity();
			
	// 取得符合某條件之 MessageBoardDetail 數量
	public int getConditionQuantity(Map<String, String> condition);
}
