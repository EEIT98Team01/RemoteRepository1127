package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.MessageBean;

public interface MessageDao {
	// 由msgID取得相對應資料
	public MessageBean findById(int id);
			
	// 新增 Message 資料用
	public MessageBean insert(MessageBean bean);
			
	// 編輯 Message 資料用
	public MessageBean update(MessageBean bean);
			
	// 取得所有 Message 資料
	public List<MessageBean> find();
			
	// 取得所有 Message 資料中某頁的n筆資料,供分頁功能使用
	public List<MessageBean> find(int page, int rows);
			
	// 取得所有 Message 資料中某頁的n筆資料,供分頁功能使用,Message資料會先依某條件進行排序
	public List<MessageBean> find(int page, int rows, String sortCondition);
			
	// 取得符合某條件之 Message 資料(K為欄位名稱, V為條件)
	public List<MessageBean> findByCondition(Map<String, String> condition);
			
	// 取得符合某條件之 Message 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<MessageBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 Message 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<MessageBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 Message 數量
	public int getQuantity();
			
	// 取得符合某條件之 Message 數量
	public int getConditionQuantity(Map<String, String> condition);
	
	// 刪除某筆Message
	public Boolean delete(int id);
}
