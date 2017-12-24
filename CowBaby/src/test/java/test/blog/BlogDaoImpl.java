package test.blog;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.BlogBean;
import model.dao.BlogDao;

@Repository
public class BlogDaoImpl implements BlogDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public BlogBean findById(int id) {
		return this.getSession().get(BlogBean.class, id);
	}

	@Override
	public BlogBean insert(BlogBean bean) {
		if (bean != null) {
			BlogBean temp = this.findById(bean.getArticleID());
			
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		
		return null;
	}

	@Override
	public BlogBean update(BlogBean bean) {
		BlogBean select = this.findById(bean.getArticleID());

		if(select != null) {
			select.setArticlePhoto(bean.getArticlePhoto());
			select.setBloggerName(bean.getBloggerName());
			select.setArticleHeader(bean.getArticleHeader());
			select.setArticleContent(bean.getArticleContent());
			return select;
		}

		return null;
	}

	@Override
	public List<BlogBean> find() {
		Query<BlogBean> query = this.getSession().createQuery("FROM BlogBean", BlogBean.class);
		return query.getResultList();
	}

	@Override
	public List<BlogBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	@Override
	public List<BlogBean> find(int page, int rows, String sortCondition) {
		Query<BlogBean> query = this.getSession().createQuery("FROM BlogBean ORDER BY " + sortCondition, BlogBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	@Override
	public List<BlogBean> findByCondition(Map<String, String> condition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM BlogBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<BlogBean> query = this.getSession().createQuery(hql, BlogBean.class);
			return query.getResultList();
		}
		
		return null;
	}

	@Override
	public List<BlogBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<BlogBean> temp = this.findByCondition(condition);

		if(temp != null) {			
			return this.subList(temp, (page - 1) * rows, rows);
		}
		
		return null;
	}

	@Override
	public List<BlogBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if(condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM BlogBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<BlogBean> query = this.getSession().createQuery(hql, BlogBean.class);
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
	
	private List<BlogBean> subList(List<BlogBean> list, int start, int end) {
		List<BlogBean> result = new LinkedList<BlogBean>();
		
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
