package test.orderdetail;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.OrderDetailBean;
import model.dao.OrderDetailDao;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public OrderDetailBean findById(int id) {
		return this.getSession().get(OrderDetailBean.class, id);
	}

	@Override
	public OrderDetailBean insert(OrderDetailBean bean) {
		if (bean != null) {
			OrderDetailBean temp = this.findById(bean.getOrderDetailID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public OrderDetailBean update(OrderDetailBean bean) {
		OrderDetailBean select = this.findById(bean.getOrderDetailID());

		if(select != null) {
			select.setOrderID(bean.getOrderID());
			select.setProductID(bean.getProductID());
			select.setUnitPrice(bean.getUnitPrice());
			select.setQuantity(bean.getQuantity());
			select.setTitle(bean.getTitle());
			select.setProductSpec(bean.getProductSpec());
			return select;
		}

		return null;
	}

	@Override
	public List<OrderDetailBean> find() {
		Query<OrderDetailBean> query = this.getSession().createQuery("FROM OrderDetailBean", OrderDetailBean.class);
		return query.getResultList();
	}

	@Override
	public List<OrderDetailBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<OrderDetailBean> find(int page, int rows, String sortCondition) {
		Query<OrderDetailBean> query = this.getSession().createQuery("FROM OrderDetailBean ORDER BY " + sortCondition, OrderDetailBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<OrderDetailBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM OrderDetailBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<OrderDetailBean> query = this.getSession().createQuery(hql, OrderDetailBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<OrderDetailBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<OrderDetailBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<OrderDetailBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM OrderDetailBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<OrderDetailBean> query = this.getSession().createQuery(hql, OrderDetailBean.class);
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

	private List<OrderDetailBean> subList(List<OrderDetailBean> list, int start, int end) {
		List<OrderDetailBean> result = new LinkedList<OrderDetailBean>();
		
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
