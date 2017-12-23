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

import model.bean.Order01Bean;
import model.dao.Order01Dao;

@Repository
public class Order01DaoImpl implements Order01Dao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Order01Bean findById(int id) {
		return this.getSession().get(Order01Bean.class, id);
	}

	@Override
	public Order01Bean insert(Order01Bean bean) {
		if (bean != null) {
			Order01Bean temp = this.findById(bean.getOrderID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public Order01Bean update(Order01Bean bean) {
		Order01Bean select = this.findById(bean.getOrderID());

		if(select != null) {
			select.setEmail(bean.getEmail());
			select.setOrderDate(bean.getOrderDate());
			select.setAcceptDate(bean.getAcceptDate());
			select.setBuyerRequestCancel(bean.getBuyerRequestCancel());
			select.setShippedDate(bean.getShippedDate());
			select.setTransactionComplete(bean.getTransactionComplete());
			select.setOrderCancellation(bean.getOrderCancellation());
			select.setPickUpStore(bean.getPickUpStore());
			select.setTotalAmount(bean.getTotalAmount());
			select.setTotalItems(bean.getTotalItems());
			select.setReceiverName(bean.getReceiverName());
			select.setReceiverEmail(bean.getReceiverEmail());
			select.setReceiverPhone(bean.getReceiverPhone());
			select.setUsebonus(bean.getUsebonus());
			select.setStoreID(bean.getStoreID());
			select.setStatus(bean.getStatus());
			select.setPaymentMethod(bean.getPaymentMethod());
			return select;
		}

		return null;
	}

	@Override
	public List<Order01Bean> find() {
		Query<Order01Bean> query = this.getSession().createQuery("FROM Order01Bean", Order01Bean.class);
		return query.getResultList();
	}

	@Override
	public List<Order01Bean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<Order01Bean> find(int page, int rows, String sortCondition) {
		Query<Order01Bean> query = this.getSession().createQuery("FROM Order01Bean ORDER BY " + sortCondition, Order01Bean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<Order01Bean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM Order01Bean WHERE ", condition);

			// 查詢並將結果回傳
			Query<Order01Bean> query = this.getSession().createQuery(hql, Order01Bean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<Order01Bean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<Order01Bean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<Order01Bean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM Order01Bean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<Order01Bean> query = this.getSession().createQuery(hql, Order01Bean.class);
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
	
	private List<Order01Bean> subList(List<Order01Bean> list, int start, int end) {
		List<Order01Bean> result = new LinkedList<Order01Bean>();
		
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
