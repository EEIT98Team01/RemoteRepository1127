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

import model.bean.SellerBackstageManageBean;
import model.dao.SellerBackstageManageDao;


@Repository
public class SellerBackstageManageDaoImpl implements SellerBackstageManageDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public SellerBackstageManageBean findById(int storeID) {
		return getSession().get(SellerBackstageManageBean.class, storeID);
	}
	
	@Override
	public SellerBackstageManageBean insert(SellerBackstageManageBean bean) {
		if (bean != null) {
			SellerBackstageManageBean temp = this.findById(bean.getStoreID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public SellerBackstageManageBean update(SellerBackstageManageBean bean) {
		SellerBackstageManageBean select = this.findById(bean.getStoreID());
		
		if(select != null) {
			select.setStoreName(bean.getStoreName());
			select.setEmail(bean.getEmail());
			select.setStoreStatus(bean.isStoreStatus());
			select.setStorePhone(bean.getStorePhone());
			select.setStoreDescription(bean.getStoreDescription());
			select.setStoreRating(bean.getStoreRating());
			select.setStoreBanner(bean.getStoreBanner());
			select.setStoreLogo(bean.getStoreLogo());
			select.setTotalPageView(bean.getTotalPageView());
			return select;
		}
		
		return null;
	}

	@Override
	public List<SellerBackstageManageBean> find() {
		Query<SellerBackstageManageBean> query = this.getSession().createQuery("FROM SellerBackstageManageBean", SellerBackstageManageBean.class);
		return query.getResultList();
	}

	@Override
	public List<SellerBackstageManageBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<SellerBackstageManageBean> find(int page, int rows, String sortCondition) {
		Query<SellerBackstageManageBean> query = this.getSession().createQuery("FROM SellerBackstageManageBean ORDER BY " + sortCondition, SellerBackstageManageBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<SellerBackstageManageBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM SellerBackstageManageBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<SellerBackstageManageBean> query = this.getSession().createQuery(hql, SellerBackstageManageBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<SellerBackstageManageBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<SellerBackstageManageBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<SellerBackstageManageBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM SellerBackstageManageBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<SellerBackstageManageBean> query = this.getSession().createQuery(hql, SellerBackstageManageBean.class);
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

	private List<SellerBackstageManageBean> subList(List<SellerBackstageManageBean> list, int start, int end) {
		List<SellerBackstageManageBean> result = new LinkedList<SellerBackstageManageBean>();
		
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
