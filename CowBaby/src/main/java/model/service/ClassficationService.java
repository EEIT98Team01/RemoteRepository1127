package model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.ClassficationBean;
import model.dao.ClassficationDao;

@Service
@Transactional
public class ClassficationService {

	@Autowired
	private ClassficationDao classficationDao;

	// 查詢商品分類單一設置資料
	@Transactional(readOnly = true)
	public ClassficationBean getStoreData(int classficationID) {
		return classficationDao.findById(classficationID);
	}
	
	// 回傳所有商品分類資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly = true)
	public List<ClassficationBean> find() {
		return classficationDao.find();
	}

	// 儲存商品分類設置資料
	@Transactional
	public ClassficationBean insertStoreData(ClassficationBean bean) {
		return classficationDao.insert(bean);
	}

	// 修改商品分類設置資料
	@Transactional
	public ClassficationBean updateStoreData(ClassficationBean bean) {
		ClassficationBean result = null;
		if (bean != null) {
			result = classficationDao.update(bean);
		}
		return result;
	}
}
