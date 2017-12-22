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

import model.bean.MessageBoardBean;
import model.dao.MessageBoardDao;

@Repository
public class MessageBoardDaoImpl implements MessageBoardDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public MessageBoardBean findById(int id) {
		return this.getSession().get(MessageBoardBean.class, id);
	}

	@Override
	public MessageBoardBean insert(MessageBoardBean bean) {
		if (bean != null) {
			MessageBoardBean temp = this.findById(bean.getMessageID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public MessageBoardBean update(MessageBoardBean bean) {
		MessageBoardBean select = this.findById(bean.getMessageID());

		if(select != null) {
			select.setStoreID(bean.getStoreID());
			select.setCustomerID(bean.getCustomerID());
			select.setProductID(bean.getCustomerID());
			select.setMessageTopic(bean.getMessageTopic());
			select.setMessageTime(bean.getMessageTime());
			return select;
		}

		return null;
	}

	@Override
	public List<MessageBoardBean> find() {
		Query<MessageBoardBean> query = this.getSession().createQuery("FROM MessageBoardBean", MessageBoardBean.class);
		return query.getResultList();
	}

	@Override
	public List<MessageBoardBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<MessageBoardBean> find(int page, int rows, String sortCondition) {
		Query<MessageBoardBean> query = this.getSession().createQuery("FROM MessageBoardBean ORDER BY " + sortCondition, MessageBoardBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<MessageBoardBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM MessageBoardBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<MessageBoardBean> query = this.getSession().createQuery(hql, MessageBoardBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<MessageBoardBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<MessageBoardBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<MessageBoardBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM MessageBoardBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<MessageBoardBean> query = this.getSession().createQuery(hql, MessageBoardBean.class);
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

	private List<MessageBoardBean> subList(List<MessageBoardBean> list, int start, int end) {
		List<MessageBoardBean> result = new LinkedList<MessageBoardBean>();
		
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
