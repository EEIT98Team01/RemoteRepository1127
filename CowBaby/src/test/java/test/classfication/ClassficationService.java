package test.classfication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.ClassficationBean;
import model.bean.CustomerBean;
import model.dao.ClassficationDao;

@Service
@Transactional
public class ClassficationService {

	@Autowired
	private ClassficationDao classficationDao;

	// 查詢商品分類單一設置資料
	@Transactional(readOnly = true)
	public ClassficationBean getClassficationData(int classficationID) {
		return classficationDao.findById(classficationID);
	}

	// 回傳所有商品分類資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly = true)
	public List<ClassficationBean> find() {
		return classficationDao.find();
	}

}
