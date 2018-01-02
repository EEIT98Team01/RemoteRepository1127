package test.product;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.ProductBean;
import model.dao.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public ProductBean findById(int id) {
		return this.getSession().get(ProductBean.class, id);
	}

	@Override
	public ProductBean insert(ProductBean bean) {
		if (bean != null) {
			ProductBean temp = this.findById(bean.getProductID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public ProductBean update(ProductBean bean) {
		ProductBean select = this.findById(bean.getProductID());

		if(select != null) {
			select.setStoreID(bean.getStoreID());
			select.setTitle(bean.getTitle());
			select.setSummary(bean.getSummary());
			select.setUnitPrice(bean.getUnitPrice());
			select.setProductDescription(bean.getProductDescription());
			select.setProductStatus(bean.isProductStatus());
			select.setClassficationID(bean.getClassficationID());
			select.setSuitableAges(bean.getSuitableAges());
			select.setGenderPreference(bean.getGenderPreference());
			select.setDisplayTime(bean.getDisplayTime());
			select.setProductImage(bean.getProductImage());
			return select;
		}

		return null;
	}

	@Override
	public List<ProductBean> find() {
		Query<ProductBean> query = this.getSession().createQuery("FROM ProductBean", ProductBean.class);
		return query.getResultList();
	}

	@Override
	public List<ProductBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<ProductBean> find(int page, int rows, String sortCondition) {
		Query<ProductBean> query = this.getSession().createQuery("FROM ProductBean ORDER BY " + sortCondition, ProductBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<ProductBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM ProductBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<ProductBean> query = this.getSession().createQuery(hql, ProductBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<ProductBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<ProductBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<ProductBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM ProductBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<ProductBean> query = this.getSession().createQuery(hql, ProductBean.class);
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

	private List<ProductBean> subList(List<ProductBean> list, int start, int end) {
		List<ProductBean> result = new LinkedList<ProductBean>();
		
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
	public Integer selectCountByClassficationId(Integer classficationID) {
		
		return null;
	}
	
}
