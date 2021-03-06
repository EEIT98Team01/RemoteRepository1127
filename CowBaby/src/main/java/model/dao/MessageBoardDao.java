package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.MessageBoardBean;

public interface MessageBoardDao {
	// 由MessageBoardID取得相對應資料
	public MessageBoardBean findById(int id);
			
	// 新增 MessageBoard 資料用
	public MessageBoardBean insert(MessageBoardBean bean);
			
	// 編輯 MessageBoard 資料用
	public MessageBoardBean update(MessageBoardBean bean);
			
	// 取得所有 MessageBoard 資料
	public List<MessageBoardBean> find();
			
	// 取得所有 MessageBoard 資料中某頁的n筆資料,供分頁功能使用
	public List<MessageBoardBean> find(int page, int rows);
			
	// 取得所有 MessageBoard 資料中某頁的n筆資料,供分頁功能使用,MessageBoard資料會先依某條件進行排序
	public List<MessageBoardBean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 MessageBoard 資料(K為欄位名稱, V為條件)
	public List<MessageBoardBean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 MessageBoard 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<MessageBoardBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 MessageBoard 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<MessageBoardBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 MessageBoard 數量
	public int getQuantity();
			
	// 取得符合某條件之 MessageBoard 數量
	public int getConditionQuantity(Map<String, String> condition);
}
