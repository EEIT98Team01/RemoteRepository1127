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

import model.bean.Top5ProductsBean;
import model.dao.Top5ProductsDao;

@Repository
public class Top5ProductsDaoImpl implements Top5ProductsDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Top5ProductsBean findById(int id) {
		return this.getSession().get(Top5ProductsBean.class, id);
	}

	@Override
	public Top5ProductsBean insert(Top5ProductsBean bean) {
		if (bean != null) {
			Top5ProductsBean temp = this.findById(bean.getTop5ProductID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public Top5ProductsBean update(Top5ProductsBean bean) {
		Top5ProductsBean select = this.findById(bean.getTop5ProductID());

		if(select != null) {
			select.setStoreID(bean.getStoreID());
			select.setMonthlyTime(bean.getMonthlyTime());
			select.setTop1Product(bean.getTop1Product());
			select.setTop2Product(bean.getTop2Product());
			select.setTop3Product(bean.getTop3Product());
			select.setTop4Product(bean.getTop4Product());
			select.setTop5Product(bean.getTop5Product());
			return select;
		}

		return null;
	}

	@Override
	public List<Top5ProductsBean> find() {
		Query<Top5ProductsBean> query = this.getSession().createQuery("FROM Top5ProductsBean", Top5ProductsBean.class);
		return query.getResultList();
	}

	@Override
	public List<Top5ProductsBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<Top5ProductsBean> find(int page, int rows, String sortCondition) {
		Query<Top5ProductsBean> query = this.getSession().createQuery("FROM Top5ProductsBean ORDER BY " + sortCondition, Top5ProductsBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<Top5ProductsBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM Top5ProductsBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<Top5ProductsBean> query = this.getSession().createQuery(hql, Top5ProductsBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<Top5ProductsBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<Top5ProductsBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<Top5ProductsBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM Top5ProductsBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<Top5ProductsBean> query = this.getSession().createQuery(hql, Top5ProductsBean.class);
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

	private List<Top5ProductsBean> subList(List<Top5ProductsBean> list, int start, int end) {
		List<Top5ProductsBean> result = new LinkedList<Top5ProductsBean>();
		
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
