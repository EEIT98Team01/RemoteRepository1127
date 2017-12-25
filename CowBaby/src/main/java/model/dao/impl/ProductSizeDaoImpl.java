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

import model.bean.ProductSizeBean;
import model.dao.ProductSizeDao;

@Repository
public class ProductSizeDaoImpl implements ProductSizeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public ProductSizeBean findById(int id) {
		return this.getSession().get(ProductSizeBean.class, id);
	}

	@Override
	public ProductSizeBean insert(ProductSizeBean bean) {
		if (bean != null) {
			ProductSizeBean temp = this.findById(bean.getProductSizeID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public ProductSizeBean update(ProductSizeBean bean) {
		ProductSizeBean select = this.findById(bean.getProductSizeID());

		if(select != null) {
			select.setProductID(bean.getProductID());
			select.setProductSpec(bean.getProductSpec());
			select.setSpecStock(bean.getSpecStock());
			return select;
		}

		return null;
	}

	@Override
	public List<ProductSizeBean> find() {
		Query<ProductSizeBean> query = this.getSession().createQuery("FROM ProductSizeBean", ProductSizeBean.class);
		return query.getResultList();
	}

	@Override
	public List<ProductSizeBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<ProductSizeBean> find(int page, int rows, String sortCondition) {
		Query<ProductSizeBean> query = this.getSession().createQuery("FROM ProductSizeBean ORDER BY " + sortCondition, ProductSizeBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<ProductSizeBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM ProductSizeBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<ProductSizeBean> query = this.getSession().createQuery(hql, ProductSizeBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<ProductSizeBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<ProductSizeBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<ProductSizeBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM ProductSizeBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<ProductSizeBean> query = this.getSession().createQuery(hql, ProductSizeBean.class);
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

	private List<ProductSizeBean> subList(List<ProductSizeBean> list, int start, int end) {
		List<ProductSizeBean> result = new LinkedList<ProductSizeBean>();
		
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
