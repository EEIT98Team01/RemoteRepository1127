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

import model.bean.MessageBoardDetailBean;
import model.dao.MessageBoardDetailDao;

@Repository
public class MessageBoardDetailDaoImpl implements MessageBoardDetailDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public MessageBoardDetailBean findById(int id) {
		return this.getSession().get(MessageBoardDetailBean.class, id);
	}

	@Override
	public MessageBoardDetailBean insert(MessageBoardDetailBean bean) {
		if (bean != null) {
			MessageBoardDetailBean temp = this.findById(bean.getMessageDetailID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public MessageBoardDetailBean update(MessageBoardDetailBean bean) {
		MessageBoardDetailBean select = this.findById(bean.getMessageDetailID());

		if(select != null) {
			select.setMessageID(bean.getMessageID());
			select.setMessageTime(bean.getMessageTime());
			select.setMessageContent(bean.getMessageContent());
			select.setEmail(bean.getEmail());
			return select;
		}

		return null;
	}

	@Override
	public List<MessageBoardDetailBean> find() {
		Query<MessageBoardDetailBean> query = this.getSession().createQuery("FROM MessageBoardDetailBean", MessageBoardDetailBean.class);
		return query.getResultList();
	}

	@Override
	public List<MessageBoardDetailBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<MessageBoardDetailBean> find(int page, int rows, String sortCondition) {
		Query<MessageBoardDetailBean> query = this.getSession().createQuery("FROM MessageBoardDetailBean ORDER BY " + sortCondition, MessageBoardDetailBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<MessageBoardDetailBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM MessageBoardDetailBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<MessageBoardDetailBean> query = this.getSession().createQuery(hql, MessageBoardDetailBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<MessageBoardDetailBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<MessageBoardDetailBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<MessageBoardDetailBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM MessageBoardDetailBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<MessageBoardDetailBean> query = this.getSession().createQuery(hql, MessageBoardDetailBean.class);
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

	private List<MessageBoardDetailBean> subList(List<MessageBoardDetailBean> list, int start, int end) {
		List<MessageBoardDetailBean> result = new LinkedList<MessageBoardDetailBean>();
		
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
