package model.dao.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StoreRatingBean;
import model.dao.StoreRatingDao;

@Repository
public class StoreRatingDaoImpl implements StoreRatingDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public StoreRatingBean findById(int id) {
		return this.getSession().get(StoreRatingBean.class, id);
	}

	@Override
	public StoreRatingBean insert(StoreRatingBean bean) {
		if (bean != null) {
			StoreRatingBean temp = this.findById(bean.getRatingID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public StoreRatingBean update(StoreRatingBean bean) {
		StoreRatingBean select = this.findById(bean.getRatingID());

		if(select != null) {
			select.setEmail(bean.getEmail());
			select.setStoreID(bean.getStoreID());
			select.setRatingScore(bean.getRatingScore());
			select.setRatingTime(bean.getRatingTime());
			return select;
		}

		return null;
	}

	@Override
	public List<StoreRatingBean> find() {
		Query<StoreRatingBean> query = this.getSession().createQuery("FROM StoreRatingBean", StoreRatingBean.class);
		return query.getResultList();
	}

	@Override
	public List<StoreRatingBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<StoreRatingBean> find(int page, int rows, String sortCondition) {
		Query<StoreRatingBean> query = this.getSession().createQuery("FROM StoreRatingBean ORDER BY " + sortCondition, StoreRatingBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<StoreRatingBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM StoreRatingBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<StoreRatingBean> query = this.getSession().createQuery(hql, StoreRatingBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<StoreRatingBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<StoreRatingBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<StoreRatingBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM StoreRatingBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<StoreRatingBean> query = this.getSession().createQuery(hql, StoreRatingBean.class);
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

	private List<StoreRatingBean> subList(List<StoreRatingBean> list, int start, int end) {
		List<StoreRatingBean> result = new LinkedList<StoreRatingBean>();
		
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
	
}
