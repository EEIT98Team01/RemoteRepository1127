package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.ClassficationBean;

public interface ClassficationDao {
	// 由classficationID取得相對應資料
	public ClassficationBean findById(int id);
				
	// 新增 Classfication 資料用
	public ClassficationBean insert(ClassficationBean bean);
				
	// 編輯 Classfication 資料用
	public ClassficationBean update(ClassficationBean bean);
				
	// 取得所有 Classfication 資料
	public List<ClassficationBean> find();
				
	// 取得所有 Classfication 資料中某頁的n筆資料,供分頁功能使用
	public List<ClassficationBean> find(int page, int rows);
				
	// 取得所有 Classfication 資料中某頁的n筆資料,供分頁功能使用,Classfication資料會先依某條件進行排序
	public List<ClassficationBean> find(int page, int rows, String sortCondition);
				
	// 取得符合某條件之 Classfication 資料(K為欄位名稱, V為條件)
	public List<ClassficationBean> findByCondition(Map<String, String> condition);
				
	// 取得符合某條件之 Classfication 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	public List<ClassficationBean> findByCondition(Map<String, String> condition, int page, int rows);

	// 取得符合某條件之 Classfication 資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	public List<ClassficationBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition);

	// 取得所有 Classfication 數量
	public int getQuantity();
				
	// 取得符合某條件之 Classfication 數量
	public int getConditionQuantity(Map<String, String> condition);
}
