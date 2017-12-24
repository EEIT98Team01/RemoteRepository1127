package test.backstage;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.BackstageBean;
import model.dao.BackstageDao;

@Repository
public class BackstageDaoImpl implements BackstageDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public BackstageBean findById(int id) {
		return this.getSession().get(BackstageBean.class, id);
	}

	@Override
	public BackstageBean insert(BackstageBean bean) {
		if (bean != null) {
			BackstageBean temp = this.findById(bean.getApplicationID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public BackstageBean update(BackstageBean bean) {
		BackstageBean select = this.findById(bean.getApplicationID());
		
		if(select != null) {
			select.setEmail(bean.getEmail());
			select.setApplicationDate(bean.getApplicationDate());
			select.setApplicationState(bean.getApplicationState());
			select.setApplicationDescription(bean.getApplicationDescription());
			return select;
		}

		return null;
	}

	@Override
	public List<BackstageBean> find() {
		Query<BackstageBean> query = this.getSession().createQuery("FROM BackstageBean", BackstageBean.class);
		return query.getResultList();
	}

	@Override
	public List<BackstageBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<BackstageBean> find(int page, int rows, String sortCondition) {
		Query<BackstageBean> query = this.getSession().createQuery("FROM BackstageBean ORDER BY " + sortCondition, BackstageBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<BackstageBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM BackstageBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<BackstageBean> query = this.getSession().createQuery(hql, BackstageBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<BackstageBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<BackstageBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<BackstageBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM BackstageBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<BackstageBean> query = this.getSession().createQuery(hql, BackstageBean.class);
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
	
	private List<BackstageBean> subList(List<BackstageBean> list, int start, int end) {
		List<BackstageBean> result = new LinkedList<BackstageBean>();
		
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
