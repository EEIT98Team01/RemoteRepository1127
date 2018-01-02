package test.classfication;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.ClassficationBean;
import model.dao.ClassficationDao;

@Repository
public class ClassficationDaoImpl implements ClassficationDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public ClassficationBean findById(int id) {
		return this.getSession().get(ClassficationBean.class, id);
	}

	@Override
	public ClassficationBean insert(ClassficationBean bean) {
		if (bean != null) {
			ClassficationBean temp = this.findById(bean.getClassficationID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public ClassficationBean update(ClassficationBean bean) {
		ClassficationBean select = this.findById(bean.getClassficationID());

		if(select != null) {
			select.setClassficatoinName(bean.getClassficatoinName());
			select.setClassificationDescription(bean.getClassificationDescription());
			select.setStartStopStatus(bean.isStartStopStatus());
			return select;
		}

		return null;
	}

	@Override
	public List<ClassficationBean> find() {
		Query<ClassficationBean> query = this.getSession().createQuery("FROM ClassficationBean", ClassficationBean.class);
		return query.getResultList();
	}

	@Override
	public List<ClassficationBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<ClassficationBean> find(int page, int rows, String sortCondition) {
		Query<ClassficationBean> query = this.getSession().createQuery("FROM ClassficationBean ORDER BY " + sortCondition, ClassficationBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<ClassficationBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM ClassficationBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<ClassficationBean> query = this.getSession().createQuery(hql, ClassficationBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<ClassficationBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<ClassficationBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<ClassficationBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM ClassficationBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<ClassficationBean> query = this.getSession().createQuery(hql, ClassficationBean.class);
			return this.subList(query.getResultList(), (page - 1) * rows, rows);
		}

		return null;
	}

	@Override
	public int getQuantity() {
		return this.find().size();
	}

	@Override
	public int getConditionQuantity(Map<String, String> condition) {
		return this.findByCondition(condition).size();
	}

	private List<ClassficationBean> subList(List<ClassficationBean> list, int start, int end) {
		List<ClassficationBean> result = new LinkedList<ClassficationBean>();
		
		int i = 0;
		while( ((start+i) < list.size()) && (i < end) ) {
			result.add(list.get(start+i));
			i++;
		}
		
		return result;
	}
	
	private String hqlAddCondition(String hql, Map<String, String> condition) {
		Set<String> fieldNameSet = condition.keySet();
		
		int count = 0;
		for(String fieldName: fieldNameSet) {
			if(count == 0) {
				hql = hql + fieldName + " " + condition.get(fieldName);
				count++;
			} else {
				hql = hql + " AND " + fieldName + " " + condition.get(fieldName);
			}
		}
		
		return hql;
	}

	@Override
	public List<ClassficationBean> findByCondition1(Map<String, String> condition, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
