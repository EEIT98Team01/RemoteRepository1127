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

import model.bean.MessageBean;
import model.dao.MessageDao;

@Repository
public class MessageDaoImpl implements MessageDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public MessageBean findById(int id) {
		return this.getSession().get(MessageBean.class, id);
	}

	@Override
	public MessageBean insert(MessageBean bean) {
		if (bean != null) {
			MessageBean temp = this.findById(bean.getMsgID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public MessageBean update(MessageBean bean) {
		MessageBean select = this.findById(bean.getMsgID());

		if(select != null) {
			select.setMsgSenderID(bean.getMsgSenderID());
			select.setMsgReceiverID(bean.getMsgReceiverID());
			select.setMsgTime(bean.getMsgTime());
			select.setReadStatus(bean.isReadStatus());
			select.setMsgContent(bean.getMsgContent());
			select.setMsgResponse(bean.getMsgResponse());
			select.setMsgMarker(bean.isMsgMarker());
			return select;
		}

		return null;
	}

	@Override
	public List<MessageBean> find() {
		Query<MessageBean> query = this.getSession().createQuery("FROM MessageBean", MessageBean.class);
		return query.getResultList();
	}

	@Override
	public List<MessageBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<MessageBean> find(int page, int rows, String sortCondition) {
		Query<MessageBean> query = this.getSession().createQuery("FROM MessageBean ORDER BY " + sortCondition, MessageBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<MessageBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM MessageBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<MessageBean> query = this.getSession().createQuery(hql, MessageBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<MessageBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<MessageBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<MessageBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM MessageBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<MessageBean> query = this.getSession().createQuery(hql, MessageBean.class);
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
	
	private List<MessageBean> subList(List<MessageBean> list, int start, int end) {
		List<MessageBean> result = new LinkedList<MessageBean>();
		
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

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
