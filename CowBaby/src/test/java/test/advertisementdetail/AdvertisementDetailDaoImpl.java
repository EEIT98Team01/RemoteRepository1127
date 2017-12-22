package test.advertisementdetail;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.AdvertisementDetailBean;
import model.dao.AdvertisementDetailDao;

@Repository
public class AdvertisementDetailDaoImpl implements AdvertisementDetailDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public AdvertisementDetailBean findById(int id) {
		return this.getSession().get(AdvertisementDetailBean.class, id);
	}

	@Override
	public AdvertisementDetailBean insert(AdvertisementDetailBean bean) {
		if (bean != null) {
			AdvertisementDetailBean temp = this.findById(bean.getAdDetailID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public AdvertisementDetailBean update(AdvertisementDetailBean bean) {
		AdvertisementDetailBean select = this.findById(bean.getAdDetailID());

		if(select != null) {
			select.setAdID(bean.getAdID());
			select.setAdPurchasedState(bean.isAdPurchasedState());
			select.setDisplayAdTime(bean.getDisplayAdTime());
			return select;
		}

		return null;
	}

	@Override
	public List<AdvertisementDetailBean> find() {
		Query<AdvertisementDetailBean> query = this.getSession().createQuery("FROM AdvertisementDetailBean", AdvertisementDetailBean.class);
		return query.getResultList();
	}

	@Override
	public List<AdvertisementDetailBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<AdvertisementDetailBean> find(int page, int rows, String sortCondition) {
		Query<AdvertisementDetailBean> query = this.getSession().createQuery("FROM AdvertisementDetailBean ORDER BY " + sortCondition, AdvertisementDetailBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<AdvertisementDetailBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM AdvertisementDetailBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<AdvertisementDetailBean> query = this.getSession().createQuery(hql, AdvertisementDetailBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<AdvertisementDetailBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<AdvertisementDetailBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<AdvertisementDetailBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM AdvertisementDetailBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<AdvertisementDetailBean> query = this.getSession().createQuery(hql, AdvertisementDetailBean.class);
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
	
	private List<AdvertisementDetailBean> subList(List<AdvertisementDetailBean> list, int start, int end) {
		List<AdvertisementDetailBean> result = new LinkedList<AdvertisementDetailBean>();
		
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
