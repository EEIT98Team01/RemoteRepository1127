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

import model.bean.AdvertisementBean;
import model.dao.AdvertisementDao;

@Repository
public class AdvertisementDaoImpl implements AdvertisementDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public AdvertisementBean findById(int id) {
		return this.getSession().get(AdvertisementBean.class, id);
	}

	@Override
	public AdvertisementBean insert(AdvertisementBean bean) {
		if (bean != null) {
			AdvertisementBean temp = this.findById(bean.getAdID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public AdvertisementBean update(AdvertisementBean bean) {
		AdvertisementBean select = this.findById(bean.getAdID());
		
		if(select != null) {
			select.setStoreID(bean.getStoreID());
			select.setAdState(bean.getAdState());
			select.setOrderAdTime(bean.getOrderAdTime());
			select.setAdFee(bean.getAdFee());
			select.setAdPackage(bean.getAdPackage());
			select.setAdPreviewPhoto(bean.getAdPreviewPhoto());
			return select;
		}

		return null;
	}

	@Override
	public List<AdvertisementBean> find() {
		Query<AdvertisementBean> query = this.getSession().createQuery("FROM AdvertisementBean", AdvertisementBean.class);
		return query.getResultList();
	}

	@Override
	public List<AdvertisementBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<AdvertisementBean> find(int page, int rows, String sortCondition) {
		Query<AdvertisementBean> query = this.getSession().createQuery("FROM AdvertisementBean ORDER BY " + sortCondition, AdvertisementBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<AdvertisementBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM AdvertisementBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<AdvertisementBean> query = this.getSession().createQuery(hql, AdvertisementBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<AdvertisementBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<AdvertisementBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<AdvertisementBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM AdvertisementBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<AdvertisementBean> query = this.getSession().createQuery(hql, AdvertisementBean.class);
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
	
	private List<AdvertisementBean> subList(List<AdvertisementBean> list, int start, int end) {
		List<AdvertisementBean> result = new LinkedList<AdvertisementBean>();
		
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
