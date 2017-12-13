package test.customerserviceaudit;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.CustomerServiceBean;
import model.dao.CustomerServiceAuditDao;

@Repository
public class CustomerServiceAuditDaoImpl implements CustomerServiceAuditDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public CustomerServiceBean findById(int id) {
		return this.getSession().get(CustomerServiceBean.class, id);
	}

	@Override
	public CustomerServiceBean update(CustomerServiceBean bean) {
		CustomerServiceBean select = this.findById(bean.getReportID());
		if(select != null) {
			select.setProblemTypes(bean.getProblemTypes());
			select.setProblemDescription(bean.getProblemDescription());
			select.setServiceFeedback(bean.getServiceFeedback());
			select.setProcessStatus(bean.getProcessStatus());
			select.setReportTime(bean.getReportTime());
			select.setReportiInProcess(bean.getReportiInProcess());
			select.setReportFix(bean.getReportFix());
			return select;
		}

		return null;
	}

	@Override
	public List<CustomerServiceBean> find() {
		Query<CustomerServiceBean> query = this.getSession().createQuery("FROM CustomerServiceBean", CustomerServiceBean.class);
		return query.getResultList();
	}

	@Override
	public List<CustomerServiceBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<CustomerServiceBean> find(int page, int rows, String sortCondition) {
		Query<CustomerServiceBean> query = this.getSession().createQuery("FROM CustomerServiceBean ORDER BY " + sortCondition, CustomerServiceBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<CustomerServiceBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM CustomerServiceBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<CustomerServiceBean> query = this.getSession().createQuery(hql, CustomerServiceBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<CustomerServiceBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<CustomerServiceBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<CustomerServiceBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM CustomerServiceBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<CustomerServiceBean> query = this.getSession().createQuery(hql, CustomerServiceBean.class);
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

	private List<CustomerServiceBean> subList(List<CustomerServiceBean> list, int start, int end) {
		List<CustomerServiceBean> result = new LinkedList<CustomerServiceBean>();
		
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
