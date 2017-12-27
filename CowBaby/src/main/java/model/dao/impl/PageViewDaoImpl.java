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

import model.bean.PageViewBean;
import model.dao.PageViewDao;

@Repository
public class PageViewDaoImpl implements PageViewDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public PageViewBean findById(int id) {
		return this.getSession().get(PageViewBean.class, id);
	}

	@Override
	public PageViewBean insert(PageViewBean bean) {
		if (bean != null) {
			PageViewBean temp = this.findById(bean.getPageViewsID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public PageViewBean update(PageViewBean bean) {
		PageViewBean select = this.findById(bean.getPageViewsID());

		if(select != null) {
			select.setStoreID(bean.getStoreID());
			select.setPageViewsDate(bean.getPageViewsDate());
			select.setPageViews(bean.getPageViews());
			return select;
		}

		return null;
	}

	@Override
	public List<PageViewBean> find() {
		Query<PageViewBean> query = this.getSession().createQuery("FROM PageViewBean", PageViewBean.class);
		return query.getResultList();
	}

	@Override
	public List<PageViewBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<PageViewBean> find(int page, int rows, String sortCondition) {
		Query<PageViewBean> query = this.getSession().createQuery("FROM PageViewBean ORDER BY " + sortCondition, PageViewBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<PageViewBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM PageViewBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<PageViewBean> query = this.getSession().createQuery(hql, PageViewBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<PageViewBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<PageViewBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<PageViewBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM PageViewBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<PageViewBean> query = this.getSession().createQuery(hql, PageViewBean.class);
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
	
	private List<PageViewBean> subList(List<PageViewBean> list, int start, int end) {
		List<PageViewBean> result = new LinkedList<PageViewBean>();
		
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
