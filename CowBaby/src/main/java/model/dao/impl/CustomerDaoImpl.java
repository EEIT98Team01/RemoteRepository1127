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

import model.bean.CustomerBean;
import model.dao.CustomerDao;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public CustomerBean findById(int id) {
		return this.getSession().get(CustomerBean.class, id);
	}

	@Override
	public CustomerBean insert(CustomerBean bean) {
		if (bean != null) {
			CustomerBean temp = this.findById(bean.getCustomerID());
			System.out.println("temp"+temp);
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}
	
	@Override
	public CustomerBean update(CustomerBean bean) {
		CustomerBean select = this.findById(bean.getCustomerID());
		
		if(select != null) {
			select.setCustomerName(bean.getCustomerName());
			select.setPassword(bean.getPassword());
			select.setEmail(bean.getEmail());
			select.setLoginPhoto(bean.getLoginPhoto());
			select.setGender(bean.getGender());
			select.setBirthday(bean.getBirthday());
			select.setAddress(bean.getAddress());
			select.setLandline(bean.getLandline());
			select.setMobilePhone(bean.getMobilePhone());
			select.setMarriage(bean.isMarriage());
			select.setSubscription(bean.isSubscription());
			select.setIncome(bean.getIncome());
			select.setCreateTime(bean.getCreateTime());
			select.setTotalAmoutOfConsumption(bean.getTotalAmoutOfConsumption());
			select.setConsumptionTimes(bean.getConsumptionTimes());
			select.setUserID(bean.getUserID());
			select.setBonus(bean.getBonus());
			select.setConsumerSegmentation(bean.getConsumerSegmentation());
			
			return select;
		}

		return null;
	}

	@Override
	public List<CustomerBean> find() {
		Query<CustomerBean> query = this.getSession().createQuery("FROM CustomerBean", CustomerBean.class);
		return query.getResultList();
	}

	@Override
	public List<CustomerBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<CustomerBean> find(int page, int rows, String sortCondition) {
		Query<CustomerBean> query = this.getSession().createQuery("FROM CustomerBean ORDER BY " + sortCondition, CustomerBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<CustomerBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM CustomerBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<CustomerBean> query = this.getSession().createQuery(hql, CustomerBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<CustomerBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<CustomerBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<CustomerBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM CustomerBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<CustomerBean> query = this.getSession().createQuery(hql, CustomerBean.class);
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

	private List<CustomerBean> subList(List<CustomerBean> list, int start, int end) {
		List<CustomerBean> result = new LinkedList<CustomerBean>();
		
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
